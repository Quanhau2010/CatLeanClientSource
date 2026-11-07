package su.catlean.client.features.modules.utility.player;

import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.minecraft.class_2848.class_2849;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import su.catlean.api.event.events.network.SendPacket;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.mixins.accessors.ServerboundMovePlayerPacketAccessor;

public class AntiHungerModule extends Module {

    public static final AntiHungerModule INSTANCE;
    private static final VisibleVisibleSettingPropertyImpl groundSetting;
    private static final VisibleVisibleSettingPropertyImpl sprintSetting;

    private AntiHungerModule() {
        super("anti-hunger", SubCategoriesKt.getPlayerUtilityCategory());
    }

    private boolean getGround() {
        return ((Boolean) groundSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private boolean getSprint() {
        return ((Boolean) sprintSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private void onSendPacket(SendPacket arg0) {
        if (arg0.getPacket() instanceof PlayerMoveC2SPacket && this.getGround()) {
            ((ServerboundMovePlayerPacketAccessor) arg0.getPacket()).setGround(false);
        }
        arg0.cancel();
    }

    static {
        KProperty[] items = new KProperty[2];
        INSTANCE = new AntiHungerModule();
        groundSetting = VisibleRenderHelper.registerSetting(INSTANCE, "cancel-ground", true);
        sprintSetting = VisibleRenderHelper.registerSetting(INSTANCE, "cancel-sprint", true);
    }

}
