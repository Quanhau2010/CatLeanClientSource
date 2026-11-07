package su.catlean.client.features.modules.utility.player;

import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.minecraft.class_10182;
import net.minecraft.class_2708;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.network.packet.Packet;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.event.events.player.FlagEvent;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.mixins.accessors.ClientboundPlayerPositionPacketAccessor;

public class NoServerRotateModule extends Module {

    public static final NoServerRotateModule INSTANCE;
    private static final VisibleVisibleSettingPropertyImpl legitSetting;
    private static float factorValue;
    private static float factorValue2;

    private NoServerRotateModule() {
        super("no-server-rotate", SubCategoriesKt.getPlayerUtilityCategory());
    }

    public boolean getLegit() {
        if (var5 == null) {
        }
        return (Boolean) legitSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        factorValue = SharedKt.getPlayer().method_36454();
        factorValue2 = SharedKt.getPlayer().method_36455();
    }

    private void onFlagEvent(FlagEvent arg0) {
        if (var8 != null) {
            SharedKt.getPlayer().method_36456((factorValue + 1.0E-6F));
        }
        SharedKt.getPlayer().method_36457((factorValue2 + 1.0E-6F));
    }

    private void onReceivePacket(ReceivePacket arg0) {
        Packet var9 = arg0.getPacket();
        class_10182 var10 = (class_2708) var9.comp_3228();
        (ClientboundPlayerPositionPacketAccessor) var9.setChange(new class_10182(var10.comp_3148(), var10.comp_3149(), SharedKt.getPlayer().method_36454(), SharedKt.getPlayer().method_36455()));
    }

    static {
        KProperty[] var22 = new KProperty[1];
        INSTANCE = new NoServerRotateModule();
        legitSetting = VisibleRenderHelper.registerSetting(INSTANCE, "legit");
    }

}
