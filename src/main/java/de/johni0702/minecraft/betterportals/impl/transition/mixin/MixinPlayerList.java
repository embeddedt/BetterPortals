package de.johni0702.minecraft.betterportals.impl.transition.mixin;

import de.johni0702.minecraft.betterportals.impl.transition.server.DimensionTransitionHandler;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.management.PlayerList;
import net.minecraftforge.common.util.ITeleporter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerList.class)
public abstract class MixinPlayerList {
    @Inject(method = "transferPlayerToDimension(Lnet/minecraft/entity/player/EntityPlayerMP;ILnet/minecraftforge/common/util/ITeleporter;)V",
            remap = false,
            at = @At("HEAD"),
            cancellable = true)
    private void betterPortalPlayerToDimension(EntityPlayerMP player, int dimensionIn, ITeleporter teleporter, CallbackInfo ci) {
        if (DimensionTransitionHandler.INSTANCE.transferPlayerToDimension(player, dimensionIn, teleporter)) {
            ci.cancel();
        }
    }
}
