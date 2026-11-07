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
        return ((Boolean) friendsSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private boolean getVillagers() {
        return ((Boolean) villagersSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private boolean getZoglins() {
        return ((Boolean) zoglinsSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private void onSendPacket(SendPacket arg0) {
        Packet packet = arg0.getPacket();
        if (packet instanceof class_2824) {
            if (__UNDEF_KEY__ != null) {
                class_2824 class2824 = ((class_2824) packet);
                if (CriticalsModule.INSTANCE.resolveMinecraftObject(class2824) == class_5907.field_29172) {
                    Entity entity = CriticalsModule.INSTANCE.resolveMinecraftObject(((class_2824) packet));
                    if (INSTANCE.getFriends()) {
                        if (entity instanceof PlayerEntity) {
                            if (__UNDEF_KEY__ != null && __UNDEF_KEY__ != null && __UNDEF_KEY__ != null) {
                            }
                        }
                    }
                    if (__UNDEF_KEY__ != null) {
                        if (INSTANCE.getVillagers()) {
                            if (__UNDEF_KEY__ != null) {
                                if (!(EntityHelper4.isFriend(((PlayerEntity) entity))) && !(entity instanceof class_1646)) {
                                    if (__UNDEF_KEY__ != null) {
                                    }
                                    if (__UNDEF_KEY__ != null) {
                                    }
                                    if (INSTANCE.getZoglins() && entity instanceof class_1590 && !(Intrinsics.areEqual(((class_1590) entity).method_5968(), SharedKt.getPlayer()))) {
                                        arg0.cancel();
                                        this.printStackTrace();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    static {
        KProperty[] items = new KProperty[3];
        INSTANCE = new AntiAttackModule();
        friendsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "friends", true);
        villagersSetting = VisibleRenderHelper.registerSetting(INSTANCE, "villagers", true);
        zoglinsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "zoglins", true);
    }

}
