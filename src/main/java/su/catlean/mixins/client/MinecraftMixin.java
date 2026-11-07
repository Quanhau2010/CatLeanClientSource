package su.catlean.mixins.client;

import net.minecraft.class_542;
import net.minecraft.client.gui.screen.Screen;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import su.catlean.api.event.GofraState;
import su.catlean.api.event.events.client.CloseEvent;
import su.catlean.api.event.events.client.InitEvent;
import su.catlean.api.event.events.client.PostTickEvent;
import su.catlean.api.event.events.client.ScreenEvent;
import su.catlean.api.event.events.client.TickEvent;
import su.catlean.api.event.events.network.DisconnectEvent;
import su.catlean.api.event.events.network.PostTasksProcessEvent;
import su.catlean.api.event.events.player.AttackEvent;
import su.catlean.api.event.events.player.ItemUseEvent;

public class MinecraftMixin {

    public MinecraftMixin() {
    }

    private void postWindowInit(class_542 args, CallbackInfo ci) {
        InitEvent.INSTANCE.call();
    }

    public void setScreenHook(Screen screen, CallbackInfo ci) {
        ci.cancel();
    }

    private void preTickHook(CallbackInfo ci) {
        TickEvent.INSTANCE.call();
    }

    private void postTickHook(CallbackInfo ci) {
        PostTickEvent.INSTANCE.call();
    }

    private void doAttackHook(CallbackInfoReturnable cir) {
        cir.setReturnValue(Boolean.valueOf(false));
    }

    private void closeHook(CallbackInfo ci) {
        ci.cancel();
    }

    private static void isAmbientOcclusionEnabledHook(CallbackInfoReturnable cir) {
        cir.setReturnValue(Boolean.valueOf(false));
    }

    public void disconnect(Screen screen, boolean bl, boolean bl2, CallbackInfo ci) {
        DisconnectEvent.INSTANCE.call();
    }

    private void render(boolean tick, CallbackInfo ci) {
        PostTasksProcessEvent.INSTANCE.call();
    }

    private void doItemUse(CallbackInfo callbackInfo) {
        ItemUseEvent.INSTANCE.call();
    }

}
