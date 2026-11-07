package su.catlean.mixins.world;

import net.minecraft.class_1313;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import su.catlean.api.event.events.player.AfterElytraEvent;
import su.catlean.api.event.events.player.FallFlyingEvent;
import su.catlean.api.event.events.player.HealthEvent;
import su.catlean.api.event.events.player.JumpEvent;
import su.catlean.api.event.events.player.PreElytraEvent;
import su.catlean.api.event.events.player.SprintEvent;
import su.catlean.api.event.events.render.SwingDurationEvent;

public abstract class EntityLivingMixin {

    public EntityLivingMixin() {
    }

    protected float method_6106() {
    }

    public void travelHook(Vec3d movementInput, CallbackInfo ci) {
        if (((LivingEntity) this) != MinecraftClient.method_1551().player) {
            return;
        }
        MinecraftClient.method_1551().player.method_5784(class_1313.field_6308, PreElytraEvent.INSTANCE.getVec());
        ci.cancel();
    }

    public void travelPostHook(Vec3d movementInput, CallbackInfo ci) {
        if (((LivingEntity) this) != MinecraftClient.method_1551().player) {
            return;
        }
        MinecraftClient.method_1551().player.method_5784(class_1313.field_6308, AfterElytraEvent.INSTANCE.getVec());
        ci.cancel();
    }

    public void isGlidingHook(CallbackInfoReturnable cir) {
        if (((LivingEntity) this) != MinecraftClient.method_1551().player) {
            return;
        }
        cir.setReturnValue(Boolean.valueOf(FallFlyingEvent.INSTANCE.getValue()));
    }

    private void jumpHook(CallbackInfo info) {
        if (((LivingEntity) this) != MinecraftClient.method_1551().player) {
            return;
        }
        LivingEntity entity = ((LivingEntity) this);
        info.cancel();
        Vec3d vec = entity.method_18798();
        entity.method_18800(vec.field_1352, Math.max(JumpEvent.INSTANCE.getY(), vec.field_1351), vec.field_1350);
        if (entity.method_5624()) {
            float factor = (JumpEvent.INSTANCE.getYaw() * 0.017453292F);
            entity.method_45319(new Vec3d((Math.sin(factor) * JumpEvent.INSTANCE.getXz()), 0.0D, (Math.cos(factor) * JumpEvent.INSTANCE.getXz())));
        }
        entity.field_64356 = true;
    }

    private boolean setSprintingHook(boolean sprinting) {
        SprintEvent.INSTANCE.setSprinting(sprinting);
        SprintEvent.INSTANCE.call();
        return SprintEvent.INSTANCE.getSprinting();
    }

    private void setHealth(float health, CallbackInfo ci) {
        HealthEvent.INSTANCE.call(health);
    }

    private void getArmSwingAnimationEnd(CallbackInfoReturnable info) {
        info.setReturnValue(Integer.valueOf(SwingDurationEvent.INSTANCE.getValue()));
    }

}
