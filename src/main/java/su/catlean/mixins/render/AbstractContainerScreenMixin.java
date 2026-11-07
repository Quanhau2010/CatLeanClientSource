package su.catlean.mixins.render;

import net.minecraft.class_1723;
import net.minecraft.class_1735;
import net.minecraft.class_2561;
import net.minecraft.class_3936;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.catlean.api.event.events.render.RenderToolTipEvent;
import su.catlean.api.event.events.render.SlotRenderEvent;

public abstract class AbstractContainerScreenMixin extends Screen implements class_3936 {

    protected class_1735 field_2787;
    protected int field_2776;
    protected int field_2800;

    protected AbstractContainerScreenMixin(class_2561 title) {
        super(title);
    }

    private void renderHook(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        RenderToolTipEvent.INSTANCE.call(this.field_2787.method_7677(), context, mouseX, mouseY);
    }

    protected void drawSlotHook(DrawContext drawContext, class_1735 slot, CallbackInfo ci) {
        SlotRenderEvent.INSTANCE.setSlot(slot);
        SlotRenderEvent.INSTANCE.setContext(drawContext);
        SlotRenderEvent.INSTANCE.call();
    }

}
