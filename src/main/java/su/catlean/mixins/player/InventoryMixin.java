package su.catlean.mixins.player;

import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import su.catlean.api.event.events.player.InsertStackEvent;
import su.catlean.api.event.events.player.UpdateSelectedSlotEvent;

public class InventoryMixin {

    public InventoryMixin() {
    }

    private void insertStackHook(ItemStack stack, CallbackInfoReturnable cir) {
        InsertStackEvent.INSTANCE.setStack(stack);
        InsertStackEvent.INSTANCE.call();
    }

    private void setSelectedSlotHook(int slot, CallbackInfo ci) {
        UpdateSelectedSlotEvent.INSTANCE.setSlot(slot);
        ci.cancel();
    }

}
