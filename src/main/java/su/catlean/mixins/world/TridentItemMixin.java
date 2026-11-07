package su.catlean.mixins.world;

import net.minecraft.class_1269;
import net.minecraft.class_1890;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import su.catlean.api.event.events.player.TridentUseEvent;
import su.catlean.api.event.events.player.TridentWeatherEvent;

public abstract class TridentItemMixin {

    public TridentItemMixin() {
    }

    public void onStoppedUsingHook(ItemStack stack, World world, LivingEntity user, CallbackInfoReturnable ci) {
        ci.cancel();
        ci.setReturnValue(Boolean.valueOf(true));
    }

    public void useHook(World world, PlayerEntity user, Hand hand, CallbackInfoReturnable cir) {
        ItemStack stack = user.method_5998(hand);
        user.method_6019(hand);
        cir.setReturnValue(class_1269.field_21466);
    }

}
