package su.catlean.client.features.modules.utility.misc;

import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import net.minecraft.class_2535;
import net.minecraft.class_2561;
import net.minecraft.class_2868;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.api.setting.SettingIdVisibleSettingPropertyImpl;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.MessageServiceComponent;
import su.catlean.client.services.client.ServiceComponent10;
import su.catlean.client.services.client.ServiceComponent58;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.PacketPacketHelper;
import su.catlean.client.services.player.EntityHelper4;
import su.catlean.client.services.render.VisibleRenderHelper;

public class AutoLeaveModule extends Module {

    public static final AutoLeaveModule INSTANCE;
    private static final VisibleVisibleSettingPropertyImpl autoDisableSetting;
    private static final VisibleVisibleSettingPropertyImpl fastLeaveSetting;
    private static final VisibleVisibleSettingPropertyImpl lowHpSetting;
    private static final VisibleVisibleSettingPropertyImpl totemsSetting;
    private static final RangeVisibleSettingPropertyImpl minTotemsSetting;
    private static final RangeVisibleSettingPropertyImpl2 minHpSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 playersSetting;
    private static final SettingIdVisibleSettingPropertyImpl commandSetting;
    private static final RangeVisibleSettingPropertyImpl distanceSetting;
    private static final ServiceComponent10 serviceComponent10;

    private AutoLeaveModule() {
        super("auto-leave", SubCategoriesKt.getMiscUtilityCategory());
    }

    private boolean getAutoDisable() {
        return ((Boolean) autoDisableSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private boolean getFastLeave() {
        return ((Boolean) fastLeaveSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private boolean getLowHp() {
        return ((Boolean) lowHpSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private boolean getTotems() {
        return ((Boolean) totemsSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private int getMinTotems() {
        return ((Number) minTotemsSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    private float getMinHp() {
        return ((Number) minHpSetting.getValue(this, DELEGATED_PROPERTIES[5]));
    }

    private AutoLeavePlayersMode getPlayers() {
        return ((AutoLeavePlayersMode) playersSetting.getValue(this, DELEGATED_PROPERTIES[6]));
    }

    private String getCommand() {
        return ((String) commandSetting.getValue(this, DELEGATED_PROPERTIES[7]));
    }

    private void setCommand(String value) {
        commandSetting.setValue(this, DELEGATED_PROPERTIES[7], value);
    }

    private int getDistance() {
        return ((Number) distanceSetting.getValue(this, DELEGATED_PROPERTIES[8]));
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        Iterator iterator = SharedKt.getWorld().getPlayers().iterator();
        while (iterator.hasNext()) {
            AbstractClientPlayerEntity player = ((AbstractClientPlayerEntity) iterator.next());
            if (__UNDEF_KEY__ == null) {
                if (__UNDEF_KEY__ == null) {
                }
                if (__UNDEF_KEY__ == null) {
                }
                if (__UNDEF_KEY__ == null) {
                }
                if (__UNDEF_KEY__ == null) {
                }
                if (__UNDEF_KEY__ == null) {
                    if (__UNDEF_KEY__ == null) {
                        if (this.getAutoDisable()) {
                            this.updateValue2();
                        }
                    }
                }
                MessageServiceComponent.S(this, MessageServiceComponent.Z(this, "player", new Object[0], false), false);
                SharedKt.getPlayer().field_3944.method_45730(StringsKt.replace$default(this.getCommand(), "/", "", false));
                return;
                this.executeAction(MessageServiceComponent.Z(this, "player", new Object[0], false));
                return;
            }
        }
        if (!(serviceComponent10.checkCondition2(1000)) || __UNDEF_KEY__ == null) {
            return;
        }
        if (__UNDEF_KEY__ == null) {
            if (__UNDEF_KEY__ == null) {
            }
        }
        this.executeAction(MessageServiceComponent.Z(this, "hp", new Object[0], false));
    }

    private void executeAction(String arg0) {
        if (this.getAutoDisable()) {
            this.executeAction(arg0);
        }
        if (this.getFastLeave()) {
            PacketPacketHelper.handlePacket(((Packet) new class_2868(-1337)));
        }
        SharedKt.getNetwork().method_48296().method_10747(class_2561.method_30163(("[CatLean] " + arg0)));
    }

    private static boolean isActive() {
        return INSTANCE.getTotems();
    }

    private static boolean isActive2() {
        return INSTANCE.getLowHp();
    }

    private static boolean isActive3() {
        return INSTANCE.getPlayers() == AutoLeavePlayersMode.Command;
    }

    private static boolean isActive4() {
        return INSTANCE.getPlayers() != AutoLeavePlayersMode.None;
    }

    static {
        KProperty[] items = new KProperty[9];
        INSTANCE = new AutoLeaveModule();
        autoDisableSetting = VisibleRenderHelper.registerSetting(INSTANCE, "disable", true);
        fastLeaveSetting = VisibleRenderHelper.registerSetting(INSTANCE, "InstantLeave", true);
        lowHpSetting = VisibleRenderHelper.registerSetting(INSTANCE, "hp", false);
        totemsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "totems", false);
        minTotemsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "min-totems", 2, new IntRange(0, 10), null, this::isActive);
        minHpSetting = VisibleRenderHelper.registerSetting(INSTANCE, "min-hp", 8.0F, RangesKt.rangeTo(1.0F, 20.0F), null, this::isActive2);
        playersSetting = VisibleRenderHelper.registerSetting(INSTANCE, "players", AutoLeavePlayersMode.Leave);
        commandSetting = VisibleRenderHelper.registerSetting(INSTANCE, "command", "hub", null, this::isActive3);
        distanceSetting = VisibleRenderHelper.registerSetting(INSTANCE, "distance", 256, new IntRange(4, 256), null, this::isActive4);
        serviceComponent10 = new ServiceComponent10();
    }

}
