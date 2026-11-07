package su.catlean.mixins.render;

import net.minecraft.class_11659;
import net.minecraft.class_1306;
import net.minecraft.class_315;
import net.minecraft.class_7172;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.catlean.api.event.events.render.EquipArmEvent;
import su.catlean.api.event.events.render.HandModifyEvent;
import su.catlean.api.event.events.render.SwingArmEvent;

public class ItemInHandRendererMixin {

    public ItemInHandRendererMixin() {
    }

    private void onRenderItem(AbstractClientPlayerEntity player, float tickProgress, float pitch, Hand hand, float swingProgress, ItemStack item, float equipProgress, MatrixStack matrices, class_11659 orderedRenderCommandQueue, CallbackInfo ci) {
        HandModifyEvent.INSTANCE.call(hand, matrices, item, false);
    }

    private void applyEatOrDrinkTransformationHook(MatrixStack matrices, float tickDelta, class_1306 arm, ItemStack stack, PlayerEntity player, CallbackInfo ci) {
        if (MinecraftClient.method_1551().options.method_42552().method_41753() == class_1306.field_6183) {
            if (arm == class_1306.field_6183) {
            } else {
                if (arm == class_1306.field_6183) {
                } else {
                }
            }
        } else {
        }
        ci.cancel();
    }

    private void swingArmHook(float f, MatrixStack matrixStack, int i, class_1306 arm, CallbackInfo ci) {
        ci.cancel();
    }

    private void swingArmHook(MatrixStack matrices, class_1306 arm, float equipProgress, CallbackInfo ci) {
        ci.cancel();
    }

}
