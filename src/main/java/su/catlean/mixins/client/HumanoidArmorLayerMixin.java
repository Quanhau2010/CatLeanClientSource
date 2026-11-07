package su.catlean.mixins.client;

import net.minecraft.class_10034;
import net.minecraft.class_11659;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.catlean.api.event.events.render.RenderArmorEvent;

public abstract class HumanoidArmorLayerMixin {

    public HumanoidArmorLayerMixin() {
    }

    private void onRenderArmor(MatrixStack matrices, class_11659 queue, ItemStack stack, EquipmentSlot slot, class_10034 state, CallbackInfo ci) {
        ci.cancel();
    }

}
