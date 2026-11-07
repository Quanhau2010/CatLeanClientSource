package su.catlean.client.features.modules.render.world;

import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.ServiceComponent98;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.TheNetherPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;

public class TpsSyncModule extends Module {

    public static final TpsSyncModule INSTANCE;
    private static final VisibleVisibleSettingPropertyImpl protectionSetting;

    private TpsSyncModule() {
        super("tps-sync", SubCategoriesKt.getWorldRenderCategory());
    }

    private boolean getProtection() {
        return (Boolean) protectionSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private void setProtection(boolean value) {
        protectionSetting.setValue(this, DELEGATED_PROPERTIES[0], Boolean.valueOf(value));
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (TheNetherPacketHelper.INSTANCE.getNumericValue() < 18.0F && SharedKt.getPlayer().field_6012 > 100 && !(TheNetherPacketHelper.INSTANCE.checkCondition2())) {
            ServiceComponent98.INSTANCE.updateValue2((TheNetherPacketHelper.INSTANCE.getNumericValue() / 20.0F));
        }
        if (!(SharedKt.getPlayer().isOnGround())) {
        }
        arg0.cancel();
    }

    static {
        KProperty[] var31 = new KProperty[1];
        INSTANCE = new TpsSyncModule();
        protectionSetting = VisibleRenderHelper.registerSetting(INSTANCE, "kick-protection");
    }

}
