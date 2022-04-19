package de.johni0702.minecraft.view.impl.mixin;

import de.johni0702.minecraft.view.impl.client.render.ViewRenderPlan;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.culling.Frustum;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EntityRenderer.class)
public abstract class MixinEntityRenderer_NoOF {
    @Redirect(method = "renderWorldPass", at = @At(value = "NEW"))
    private Frustum createCamera() {
        ViewRenderPlan plan = ViewRenderPlan.Companion.getCURRENT();
        if (plan != null) {
            return plan.getCamera().getFrustum();
        }
        return new Frustum();
    }
}
