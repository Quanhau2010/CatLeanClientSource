package su.catlean.client.features.modules.movement.rage;

import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.class_1656;
import net.minecraft.class_2708;
import net.minecraft.class_2828.class_2830;
import net.minecraft.class_2828.class_5911;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.event.events.network.SendPacket;
import su.catlean.api.event.events.player.MoveEvent;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.player.PreSyncEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.ServiceComponent110;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.network.PacketPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;

public class FlightModule extends Module {

    public static final FlightModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 modeSetting;
    private static final RangeVisibleSettingPropertyImpl2 hSpeedSetting;
    private static final RangeVisibleSettingPropertyImpl2 vSpeedSetting;
    private static final VisibleVisibleSettingPropertyImpl antiKickSetting;
    private static Vec3d vec3d;

    private FlightModule() {
        super("flight", SubCategoriesKt.getRageMovementCategory());
    }

    private FlightMode getMode() {
        return (FlightMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private float getHSpeed() {
        return (Number) hSpeedSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private float getVSpeed() {
        return (Number) vSpeedSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private boolean getAntiKick() {
        return (Boolean) antiKickSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private void onPreSyncEvent(PreSyncEvent arg0) {
        if (EventPacketHelper2.INSTANCE.checkCondition()) {
            double[] var23 = EventPacketHelper2.process(this.getHSpeed(), 0, 0.0F, 0.0F, 0.0F);
            SharedKt.getPlayer().method_18800(var23[0], 0.0D, var23[1]);
        } else {
            SharedKt.getPlayer().method_18800(0.0D, 0.0D, 0.0D);
        }
        if (SharedKt.getMc().options.field_1903.method_1434()) {
            SharedKt.getPlayer().method_18799(SharedKt.getPlayer().method_18798().method_1031(0.0D, this.getVSpeed(), 0.0D));
        }
        SharedKt.getPlayer().method_18799(SharedKt.getPlayer().method_18798().method_1031(0.0D, this.getVSpeed(), 0.0D));
        SharedKt.getPlayer().method_5728(1);
        if (SharedKt.getMc().options.field_1832.method_1434() && !((SharedKt.getPlayer().field_6012 % 2))) {
            arg0.cancel();
            PacketPacketHelper.handlePacket((Packet) new class_5911(1, 0));
        }
        if (!((SharedKt.getPlayer().field_6012 % 30))) {
        } else {
        }
        SharedKt.getPlayer().method_18798().field_1352.<init>(-0.08D, 0.08D, SharedKt.getPlayer().method_18798().field_1350);
        new Vec3d.method_18799(new Vec3d);
    }

    public void onPlayerUpdateEvent(PlayerUpdateEvent event) {
        if (this.getMode() == FlightMode.Creative) {
            SharedKt.getPlayer().method_31549().field_7479 = 1;
            SharedKt.getPlayer().method_31549().method_7248((this.getHSpeed() / 10.0F));
        }
        double[] var17 = EventPacketHelper2.process(this.getHSpeed(), 0, 0.0F, 0.0F, 0.0F);
        int var18 = 0;
        if (SharedKt.getMc().options.field_1903.method_1434()) {
        } else {
            if (SharedKt.getMc().options.field_1832.method_1434()) {
            } else {
            }
        }
        INSTANCE.getVSpeed().method_18800(INSTANCE.getVSpeed(), 0.0D, var17[1]);
    }

    private void onReceivePacket(ReceivePacket arg0) {
        vec3d = SharedKt.getPlayer().method_18798();
    }

    private void onSendPacket(SendPacket arg0) {
        SharedKt.getPlayer().method_18800(vec3d.field_1352, vec3d.field_1351, vec3d.field_1350);
        this.updateValue2();
        vec3d = null;
    }

    public void onMoveEvent(MoveEvent event) {
        double[] var10 = EventPacketHelper2.process(0.3F, 0, 1.0F, 0.0F, 0.0F);
        event.cancel();
        event.setY(-0.03D);
        event.setX(var10[0]);
        event.setZ(var10[1]);
        SharedKt.getPlayer().method_18800(event.getX(), -0.03D, event.getZ());
    }

    public void updateValue2(long arg0) {
        long var3 = (arg0 ^ 29647348875563L);
        SharedKt.getPlayer().method_31549().field_7479 = 0;
        SharedKt.getPlayer().method_31549().method_7248(0.05F);
    }

    private static boolean isActive() {
        if (INSTANCE.getMode() != FlightMode.Creative) {
            if (INSTANCE.getMode() == FlightMode.Vanilla) {
            }
        } else {
        }
        return false;
    }

    static {
        KProperty[] var30 = new KProperty[4];
        INSTANCE = new FlightModule();
        modeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mode", FlightMode.Vanilla);
        hSpeedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "horizontal", 1.0F, RangesKt.rangeTo(0.0F, 10.0F));
        vSpeedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "vertical", 0.78F, RangesKt.rangeTo(0.0F, 5.0F));
        antiKickSetting = VisibleRenderHelper.registerSetting(INSTANCE, "anti-kick", 0, null, this::isActive);
        vec3d = Vec3d.ZERO;
    }

}
