package su.catlean.client.features.modules.utility.misc;

import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.random.Random;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import net.minecraft.class_2797;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.SendPacket;
import su.catlean.api.setting.SettingIdVisibleSettingPropertyImpl;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.WHITEServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.VisibleRenderHelper;

public class MessageAppendModule extends Module {

    public static final MessageAppendModule INSTANCE;
    private static final SettingIdVisibleSettingPropertyImpl prefixSetting;
    private static final SettingIdVisibleSettingPropertyImpl postfixSetting;
    private static final VisibleVisibleSettingPropertyImpl emojiSetting;
    private static final String[] textValueArray;
    private static String textValue;

    private MessageAppendModule() {
        super("message-append", SubCategoriesKt.getMiscUtilityCategory());
    }

    private String getPrefix() {
        return ((String) prefixSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private String getPostfix() {
        return ((String) postfixSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private boolean getEmoji() {
        return ((Boolean) emojiSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    public String[] process() {
        return textValueArray;
    }

    private void onSendPacket(SendPacket arg0) {
        if (SharedKt.getMc().player == null || SharedKt.getMc().world == null) {
            return;
        }
        String text = ((class_2797) arg0.getPacket()).comp_945;
        if (Intrinsics.areEqual(text, textValue)) {
            return;
        }
        if (!(arg0.getPacket() instanceof class_2797) || Intrinsics.areEqual(SharedKt.getPlayer().method_6047().getItem(), Items.field_8204) || Intrinsics.areEqual(SharedKt.getPlayer().method_6079().getItem(), Items.field_8204)) {
            return;
        }
        if (text.length() < 7) {
            int index = 0;
            int index2 = 0;
            if (index2 < this.length()) {
                char ch = this.charAt(index2);
                if (Character.isDigit(ch)) {
                }
            }
            if (index >= 3) {
                return;
            }
        }
        if (StringsKt.startsWith$default(text, "/", false) || StringsKt.startsWith$default(text, WHITEServiceComponent.INSTANCE.getString(), false)) {
            return;
        }
        if (StringsKt.startsWith$default(text, "!", false)) {
            text = text.substring(1);
        }
        if (this.getEmoji()) {
        } else {
        }
        textValue = (this.getPrefix() + text + this.getPostfix() + (ArraysKt.random(textValueArray, ((Random) Random.Default))) + "");
        SharedKt.getPlayer().field_3944.method_45729(textValue);
        arg0.cancel();
    }

    static {
        KProperty[] items = new KProperty[3];
        INSTANCE = new MessageAppendModule();
        prefixSetting = VisibleRenderHelper.registerSetting(INSTANCE, "prefix", "> ");
        postfixSetting = VisibleRenderHelper.registerSetting(INSTANCE, "postfix", " [CatLean]");
        emojiSetting = VisibleRenderHelper.registerSetting(INSTANCE, "emoji", true);
        items = new String[64];
        items[0] = "^_^";
        items[1] = "^-^";
        items[2] = "^o^";
        items[3] = "^O^";
        items[4] = "o_o";
        items[5] = "O_O";
        items[6] = "0_0";
        items[7] = "x_x";
        items[8] = ">_<";
        items[9] = "-_-";
        items[10] = ";_;";
        items[11] = "T_T";
        items[12] = "=_=";
        items[13] = "v_v";
        items[14] = "xD";
        items[15] = "o.O";
        items[16] = "O.o";
        items[17] = "._.";
        items[18] = "o_o;";
        items[19] = "O_O;";
        items[20] = ">:(";
        items[21] = ":)";
        items[22] = ":D";
        items[23] = ":P";
        items[24] = ":o";
        items[25] = ":O";
        items[26] = ":3";
        items[27] = ":|";
        items[28] = ":/";
        items[29] = ":*";
        items[30] = ";)";
        items[31] = ">:D";
        items[32] = ">:3c";
        items[33] = "XD";
        items[34] = "xP";
        items[35] = "^_^";
        items[36] = "(^-^)";
        items[37] = "(>_<)";
        items[38] = "(T_T)";
        items[39] = "(U3O)";
        items[40] = "o_o";
        items[41] = "O_O";
        items[42] = "0_0";
        items[43] = "(v_v)";
        items[44] = "(x_x)";
        items[45] = "(^o^)";
        items[46] = "(^O^)";
        items[47] = "(;_;)";
        items[48] = "(=_=)";
        items[49] = "(^3^)";
        items[50] = "(^w^)";
        items[51] = "UwU";
        items[52] = "OwO";
        items[53] = ">w<";
        items[54] = "xD";
        items[55] = ";D";
        items[56] = "(>o<)";
        items[57] = "(._.)";
        items[58] = "('~')";
        items[59] = "(*_*)";
        items[60] = "(\u00ac_\u00ac)";
        items[61] = "(\u2022_\u2022)";
        items[62] = "(\u00b0_\u00b0)";
        items[63] = "(>_<)b";
        textValueArray = items;
    }

}
