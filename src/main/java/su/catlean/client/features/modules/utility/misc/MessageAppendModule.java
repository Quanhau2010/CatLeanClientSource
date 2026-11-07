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
        return (String) prefixSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private String getPostfix() {
        return (String) postfixSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private boolean getEmoji() {
        return (Boolean) emojiSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    public String[] process() {
        return textValueArray;
    }

    private void onSendPacket(SendPacket arg0) {
        if (SharedKt.getMc().player == null || SharedKt.getMc().world == null) {
            return;
        }
        String var15 = (class_2797) arg0.getPacket().comp_945;
        if (Intrinsics.areEqual(textValue)) {
            return;
        }
        if (!(arg0.getPacket() instanceof class_2797) || Intrinsics.areEqual(SharedKt.getPlayer().method_6047().getItem(), Items.field_8204) || Intrinsics.areEqual(SharedKt.getPlayer().method_6079().getItem(), Items.field_8204)) {
            return;
        }
        if (var15.length() < 7) {
            CharSequence var16 = (CharSequence) var15;
            int var17 = 0;
            int var18 = 0;
            int var19 = 0;
            if (var19 < var16.length()) {
                char var20 = var16.charAt();
                int var21 = var20;
                int var22 = 0;
                if (Character.isDigit()) {
                }
            }
            if (var18 >= 3) {
                return;
            }
        }
        if (StringsKt.startsWith$default("/") || StringsKt.startsWith$default(WHITEServiceComponent.INSTANCE.getString())) {
            return;
        }
        var16 = 0;
        if (StringsKt.startsWith$default("!")) {
            var15 = var15.substring(1);
            var16 = 1;
        }
        if (var16) {
        } else {
        }
        if (this.getEmoji()) {
        } else {
        }
        textValue = (this.getPrefix() + var15 + this.getPostfix() + (ArraysKt.random(textValueArray, (Random) Random.Default)) + "");
        SharedKt.getPlayer().field_3944.method_45729(textValue);
        arg0.cancel();
    }

    static {
        KProperty[] var29 = new KProperty[3];
        INSTANCE = new MessageAppendModule();
        prefixSetting = VisibleRenderHelper.registerSetting(INSTANCE, "prefix", "> ");
        postfixSetting = VisibleRenderHelper.registerSetting(INSTANCE, "postfix", " [CatLean]");
        emojiSetting = VisibleRenderHelper.registerSetting(INSTANCE, "emoji");
        var29 = new String[64];
        var29[0] = "^_^";
        var29[1] = "^-^";
        var29[2] = "^o^";
        var29[3] = "^O^";
        var29[4] = "o_o";
        var29[5] = "O_O";
        var29[6] = "0_0";
        var29[7] = "x_x";
        var29[8] = ">_<";
        var29[9] = "-_-";
        var29[10] = ";_;";
        var29[11] = "T_T";
        var29[12] = "=_=";
        var29[13] = "v_v";
        var29[14] = "xD";
        var29[15] = "o.O";
        var29[16] = "O.o";
        var29[17] = "._.";
        var29[18] = "o_o;";
        var29[19] = "O_O;";
        var29[20] = ">:(";
        var29[21] = ":)";
        var29[22] = ":D";
        var29[23] = ":P";
        var29[24] = ":o";
        var29[25] = ":O";
        var29[26] = ":3";
        var29[27] = ":|";
        var29[28] = ":/";
        var29[29] = ":*";
        var29[30] = ";)";
        var29[31] = ">:D";
        var29[32] = ">:3c";
        var29[33] = "XD";
        var29[34] = "xP";
        var29[35] = "^_^";
        var29[36] = "(^-^)";
        var29[37] = "(>_<)";
        var29[38] = "(T_T)";
        var29[39] = "(U3O)";
        var29[40] = "o_o";
        var29[41] = "O_O";
        var29[42] = "0_0";
        var29[43] = "(v_v)";
        var29[44] = "(x_x)";
        var29[45] = "(^o^)";
        var29[46] = "(^O^)";
        var29[47] = "(;_;)";
        var29[48] = "(=_=)";
        var29[49] = "(^3^)";
        var29[50] = "(^w^)";
        var29[51] = "UwU";
        var29[52] = "OwO";
        var29[53] = ">w<";
        var29[54] = "xD";
        var29[55] = ";D";
        var29[56] = "(>o<)";
        var29[57] = "(._.)";
        var29[58] = "('~')";
        var29[59] = "(*_*)";
        var29[60] = "(\u00ac_\u00ac)";
        var29[61] = "(\u2022_\u2022)";
        var29[62] = "(\u00b0_\u00b0)";
        var29[63] = "(>_<)b";
        textValueArray = var29;
    }

}
