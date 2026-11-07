package su.catlean.client.services.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import kotlin.text.StringsKt;
import net.minecraft.class_124;
import net.minecraft.class_2561;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.ItemStack;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.module.category.SubCategory;
import su.catlean.client.services.render.TitleRenderHelper;
import su.catlean.client.types.OptionMode16;

public class MessageServiceComponent {

    private static String textValue;

    public static void executeAction(Module receiver, Object m) {
        e(receiver, m.toString());
    }

    public static void executeAction(Module receiver, String message, OptionMode16 type, int timeout, ItemStack item) {
        TitleRenderHelper.INSTANCE.executeAction(receiver.getString2(), message, timeout, type, item);
    }

    public static void executeAction(Module receiver, Object m) {
        S(receiver, m.toString());
    }

    public static void executeAction(Module receiver, String message, boolean chat) {
        SharedKt.getNetwork().method_45729(message);
        Object var13 = message;
        class_124 var14 = class_124.field_1080;
        String var15 = StringsKt.trim((CharSequence) receiver.getString2()).toString();
        class_124 var16 = class_124.field_1065;
        class_124 var17 = class_124.field_1080;
        class_2561 var12 = class_2561.method_30163((class_124.field_1060 + "> " + var17 + "[" + var16 + var15 + var14 + "] " + var13));
        if (SharedKt.getMc().method_18854()) {
            SharedKt.getPlayer().method_7353(0);
        }
        SharedKt.getMc().method_40000(this::updateValue);
    }

    public static String resolveString(Module receiver, String message, Object[] args, boolean common) {
        Object var11 = args;
        String var22 = ("common" + (receiver.getSubCategory().getString() + receiver.getString()) + "." + message);
        KeyServiceComponent var21 = KeyServiceComponent.INSTANCE;
        int var12 = 0;
        Object var13 = var11;
        Collection var14 = (Collection) new ArrayList();
        int var15 = 0;
        int var16 = 0;
        Object var17 = var13;
        if (var16 < var17) {
            Object var18 = var13[var16];
            Object var19 = var18;
            if (var9 == null) {
                Object var23 = var14;
                int var20 = 0;
                var23.add();
            }
        }
        var23 = var14;
        var11 = (Collection) var23;
        var12 = 0;
        var13 = var11;
        Object[] var10 = var13.toArray(new Object[0]);
        return var21.resolveString(Arrays.copyOf());
    }

    private static void updateValue(class_2561 arg0) {
        SharedKt.getPlayer().method_7353(arg0, 0);
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
