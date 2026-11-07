package su.catlean.client.features.modules.utility.player;

import java.util.Locale;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import net.minecraft.class_124;
import net.minecraft.class_2561;
import net.minecraft.class_7439;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.setting.SettingIdVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.MessageServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.PacketPacketHelper;
import su.catlean.client.services.render.TitleRenderHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.types.OptionMode16;

public class AutoAuthModule extends Module {

    public static final AutoAuthModule INSTANCE;
    private static final SettingIdVisibleSettingPropertyImpl passSetting;

    private AutoAuthModule() {
        super("auto-auth", SubCategoriesKt.getPlayerUtilityCategory());
    }

    private String getPass() {
        return ((String) passSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private void onReceivePacket(ReceivePacket arg0) {
        class_7439 class7439 = ((class_7439) arg0.getPacket());
        String text = class7439.comp_763().getString().toLowerCase(Locale.ROOT);
        if (!(((CharSequence) this.getPass()).length())) {
            MessageServiceComponent.S(this, (class_124.field_1061 + MessageServiceComponent.Z(this, "pass-is-empty", new Object[0], false)), false);
            TitleRenderHelper.executeAction("Auto Auth", MessageServiceComponent.Z(this, "pass-is-empty", new Object[0], false), 4, OptionMode16.ERROR);
            return;
        }
        if (!(StringsKt.contains$default(((CharSequence) text), ((CharSequence) "/reg"), false)) && !(StringsKt.contains$default(((CharSequence) text), ((CharSequence) "/register"), false))) {
            if (StringsKt.contains$default(((CharSequence) text), ((CharSequence) "\u0437\u0430\u0440\u0435\u0433\u0438\u0441\u0442\u0440\u0438\u0440\u0443\u0439\u0442\u0435\u0441\u044c"), false)) {
                PacketPacketHelper.executeAction((null + this.getPass() + " " + this.getPass()));
                TitleRenderHelper.executeAction("Auto Auth", MessageServiceComponent.Z(this, "reg-success", new Object[0], false), 4, OptionMode16.SUCCESS);
            } else {
                if (!(StringsKt.contains$default(((CharSequence) text), ((CharSequence) "\u0430\u0432\u0442\u043e\u0440\u0438\u0437\u0443\u0439\u0442\u0435\u0441\u044c"), false)) && !(StringsKt.contains$default(((CharSequence) text), ((CharSequence) "/l "), false))) {
                }
                PacketPacketHelper.executeAction(("login " + this.getPass()));
                TitleRenderHelper.executeAction("Auto Auth", MessageServiceComponent.Z(this, "log-success", new Object[0], false), 4, OptionMode16.SUCCESS);
            }
        }
    }

    static {
        KProperty[] items = new KProperty[1];
        INSTANCE = new AutoAuthModule();
        passSetting = VisibleRenderHelper.registerSetting(INSTANCE, "password", "c1a2t3l4e5a6n");
    }

}
