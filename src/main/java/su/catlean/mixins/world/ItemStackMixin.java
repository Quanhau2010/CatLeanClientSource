package su.catlean.mixins.world;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import su.catlean.api.event.events.player.FinishUsingItemEvent;
import su.catlean.api.event.events.player.StackCollectEvent;

public class ItemStackMixin {

    public ItemStackMixin() {
    }

    private void onFinishUsing(World world, LivingEntity entity, CallbackInfoReturnable cir) {
        FinishUsingItemEvent.INSTANCE.call((ItemStack) this);
    }

    private void onRenewItem(int bobbingAnimationTime, CallbackInfo ci) {
        StackCollectEvent.INSTANCE.setItemStack((ItemStack) this);
        StackCollectEvent.INSTANCE.call();
    }

}
