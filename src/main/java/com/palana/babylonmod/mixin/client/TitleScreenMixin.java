package com.palana.babylonmod.mixin.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.RotatingCubeMapRenderer;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.Identifier;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin {

    @Unique
    private static final Identifier TITLE_BG =
            new Identifier("babylonmod", "textures/gui/title_background.png");

    // Image is 3840x2160 (16:9)
    @Unique
    private static final float IMG_ASPECT = 16.0f / 9.0f;

    // Capture DrawContext so the @Redirect below can use it
    @Unique
    private DrawContext babylonmod$ctx;

    @Inject(method = "render", at = @At("HEAD"))
    private void captureContext(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        babylonmod$ctx = context;
    }

    @Redirect(method = "render",
              at = @At(value = "INVOKE",
                       target = "Lnet/minecraft/client/gui/RotatingCubeMapRenderer;render(FF)V"))
    private void renderKenBurns(RotatingCubeMapRenderer panorama, float delta, float alpha) {
        DrawContext ctx = babylonmod$ctx;
        if (ctx == null) return;

        MinecraftClient mc = MinecraftClient.getInstance();
        float sw = mc.getWindow().getScaledWidth();
        float sh = mc.getWindow().getScaledHeight();

        // Scale-to-fill: base size that covers the full screen with correct aspect ratio
        float screenAspect = sw / sh;
        float baseW, baseH;
        if (screenAspect > IMG_ASPECT) {
            baseW = sw;
            baseH = sw / IMG_ASPECT;
        } else {
            baseH = sh;
            baseW = sh * IMG_ASPECT;
        }

        // Ken Burns: 50-second cycle, zoom 1.0→1.06→1.0, slow drift pan
        float t = (System.currentTimeMillis() % 50000L) / 50000.0f;
        double twoPiT = 2.0 * Math.PI * t;
        float zoom  = 1.0f + 0.06f * (float)(0.5 - 0.5 * Math.cos(twoPiT));
        float panX  = (float) Math.sin(twoPiT * 0.71 + 0.30);
        float panY  = (float) Math.sin(twoPiT * 0.47 + 1.70);

        float drawW  = baseW * zoom;
        float drawH  = baseH * zoom;
        float extraX = (drawW - sw) * 0.5f;
        float extraY = (drawH - sh) * 0.5f;
        float x = (sw - drawW) * 0.5f + panX * extraX;
        float y = (sh - drawH) * 0.5f + panY * extraY;

        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderTexture(0, TITLE_BG);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, alpha);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();

        // Draw full-screen quad with normalized UVs — GPU scales the 3840x2160 texture to fit
        Matrix4f matrix = ctx.getMatrices().peek().getPositionMatrix();
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder buf = tessellator.getBuffer();
        buf.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE);
        buf.vertex(matrix, x,         y + drawH, 0).texture(0.0f, 1.0f).next();
        buf.vertex(matrix, x + drawW, y + drawH, 0).texture(1.0f, 1.0f).next();
        buf.vertex(matrix, x + drawW, y,         0).texture(1.0f, 0.0f).next();
        buf.vertex(matrix, x,         y,         0).texture(0.0f, 0.0f).next();
        tessellator.draw();

        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.disableBlend();
    }
}
