package su.catlean.mixins.client;

import net.minecraft.class_1713;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.catlean.api.event.events.network.ClearClickMapEvent;

public class ItemStackHashMixin {

    public ItemStackHashMixin() {
    }

    private static void onSlotClickHook(class_1713 actionType, PlayerEntity player, CallbackInfo ci) {
        ci.cancel();
    }

}
