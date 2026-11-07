package su.catlean.client.features.modules.movement.rage;

import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.minecraft.class_2851;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.SendPacket;
import su.catlean.api.event.events.player.MoveEvent;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.pvp.attack.AuraModule;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.VisibleRenderHelper;

public class ElytraFreezeModule extends Module {

    public static final ElytraFreezeModule INSTANCE;
    private static final VisibleVisibleSettingPropertyImpl packetSetting;

    private ElytraFreezeModule() {
        super("elytra-freeze", SubCategoriesKt.getRageMovementCategory());
    }

    private boolean getPacket() {
        return (Boolean) packetSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private void onMoveEvent(MoveEvent arg0) {
        if (!(this.checkCondition())) {
            this.updateValue2();
            return;
        }
        arg0.setX(0.0D);
        arg0.setY(0.0D);
        arg0.setZ(0.0D);
        arg0.cancel();
    }

    private void onSendPacket(SendPacket arg0) {
        if (!(arg0.getPacket() instanceof PlayerMoveC2SPacket)) {
        }
        arg0.cancel();
    }

    private boolean checkCondition() {
        if (SharedKt.getPlayer().isFallFlying()) {
            if (AuraModule.INSTANCE.getTarget() == null) {
            }
        } else {
        }
        return AuraModule.INSTANCE.getTarget().distanceTo(SharedKt.getPlayer()) < AuraModule.INSTANCE.getAttackRange();
    }

    static {
        KProperty[] var22 = new KProperty[1];
        INSTANCE = new ElytraFreezeModule();
        packetSetting = VisibleRenderHelper.registerSetting(INSTANCE, "cancel-packet");
    }

}
