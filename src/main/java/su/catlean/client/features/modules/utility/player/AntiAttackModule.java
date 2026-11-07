package su.catlean.client.features.modules.utility.player;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.minecraft.class_1590;
import net.minecraft.class_1646;
import net.minecraft.class_2824;
import net.minecraft.class_2824.class_5907;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.Packet;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.SendPacket;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.pvp.attack.CriticalsModule;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.player.EntityHelper4;
import su.catlean.client.services.render.VisibleRenderHelper;

public class AntiAttackModule extends Module {

    public static final AntiAttackModule INSTANCE;
    private static final VisibleVisibleSettingPropertyImpl friendsSetting;
    private static final VisibleVisibleSettingPropertyImpl villagersSetting;
    private static final VisibleVisibleSettingPropertyImpl zoglinsSetting;

    private AntiAttackModule() {
        super("anti-attack", SubCategoriesKt.getPlayerUtilityCategory());
    }

    private boolean getFriends() {
        return (Boolean) friendsSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private boolean getVillagers() {
        return (Boolean) villagersSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private boolean getZoglins() {
        return (Boolean) zoglinsSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private void onSendPacket(SendPacket arg0) {
        Packet var21 = arg0.getPacket();
        Object var22 = var21;
        int var23 = 0;
        if (var22 instanceof class_2824) {
            if (var20 != null) {
                class_2824 var19 = (class_2824) var22;
                if (CriticalsModule.INSTANCE.resolveMinecraftObject() == class_5907.field_29172) {
                }
                Entity entity = CriticalsModule.INSTANCE.resolveMinecraftObject((class_2824) var22);
                if (INSTANCE.getFriends()) {
                    if (entity instanceof PlayerEntity) {
                        if (var20 != null && var20 != null && var20 != null) {
                        }
                    }
                }
                if (var20 != null) {
                    if (INSTANCE.getVillagers()) {
                        if (var20 != null) {
                            if (!(EntityHelper4.isFriend((PlayerEntity) entity)) && !(entity instanceof class_1646)) {
                            }
                        }
                    }
                    if (var20 != null) {
                    }
                    if (var20 != null) {
                    }
                    if (INSTANCE.getZoglins() && entity instanceof class_1590 && !(Intrinsics.areEqual((class_1590) entity.method_5968(), SharedKt.getPlayer()))) {
                    }
                    arg0.cancel();
                    var25.printStackTrace();
                }
            }
        }
    }

    static {
        KProperty[] var26 = new KProperty[3];
        INSTANCE = new AntiAttackModule();
        friendsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "friends", 1, null, null, -7042834530998157300L);
        villagersSetting = VisibleRenderHelper.registerSetting(INSTANCE, "villagers", 1, null, null, -6525862567552745460L);
        zoglinsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "zoglins", 1, null, null, -6525862567552745460L);
    }

}
