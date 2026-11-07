package su.catlean.client.features.modules.utility.player;

import com.mojang.authlib.GameProfile;
import java.util.Iterator;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import net.minecraft.class_2561;
import net.minecraft.class_640;
import net.minecraft.class_7439;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.ServiceComponent10;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.PacketPacketHelper;
import su.catlean.client.services.player.PlayerEntityHelper;
import su.catlean.client.services.render.VisibleRenderHelper;

public class AutoTpaAcceptModule extends Module {

    public static final AutoTpaAcceptModule INSTANCE;
    private static final VisibleVisibleSettingPropertyImpl griefSetting;
    private static final VisibleVisibleSettingPropertyImpl onlyFriendsSetting;
    private static final ServiceComponent10 serviceComponent10;

    private AutoTpaAcceptModule() {
        super("auto-tpa-accept", SubCategoriesKt.getPlayerUtilityCategory());
    }

    private boolean getGrief() {
        return ((Boolean) griefSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private void setGrief(boolean value) {
        griefSetting.setValue(this, DELEGATED_PROPERTIES[0], Boolean.valueOf(value));
    }

    private boolean getOnlyFriends() {
        return ((Boolean) onlyFriendsSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private void setOnlyFriends(boolean value) {
        onlyFriendsSetting.setValue(this, DELEGATED_PROPERTIES[1], Boolean.valueOf(value));
    }

    public void onReceivePacket(ReceivePacket event) {
        String text = ((class_7439) event.getPacket()).comp_763().getString();
        if (!(StringsKt.contains$default(((CharSequence) text), ((CharSequence) "\u0442\u0435\u043b\u0435\u043f\u043e\u0440\u0442\u0438\u0440\u043e\u0432\u0430\u0442\u044c\u0441\u044f"), false))) {
        }
        if (this.getOnlyFriends()) {
            if (StringsKt.contains$default(((CharSequence) text), ((CharSequence) "tpaccept"), false) && PlayerEntityHelper.INSTANCE.checkCondition(this.resolveString(text))) {
                if (this.getGrief()) {
                } else {
                }
                PacketPacketHelper.executeAction(("tpaccept " + ""));
            }
        }
        serviceComponent10.executeAction();
    }

    private String resolveString(String arg0) {
        Iterable iterable = ((Iterable) SharedKt.getNetwork().method_45732());
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            class_640 class640 = ((class_640) element);
        }
        if (((class_640) null) != null && ((class_640) null).method_2966() != null) {
            if (((class_640) null).method_2966().name() == null) {
            }
        }
        return "-";
    }

    static {
        KProperty[] items = new KProperty[2];
        INSTANCE = new AutoTpaAcceptModule();
        griefSetting = VisibleRenderHelper.registerSetting(INSTANCE, "grief", false);
        onlyFriendsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "only-friends", true);
        serviceComponent10 = new ServiceComponent10();
    }

}
