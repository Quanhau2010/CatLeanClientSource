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
        S(receiver, m.toString(), false);
    }

    public static void executeAction(Module receiver, String message, boolean chat) {
        SharedKt.getNetwork().method_45729(message);
        class_124 class124 = class_124.field_1080;
        String text = StringsKt.trim(((CharSequence) receiver.getString2())).toString();
        class_124 class1242 = class_124.field_1065;
        class_124 class1243 = class_124.field_1080;
        class_2561 class2561 = class_2561.method_30163((class_124.field_1060 + "> " + class1243 + "[" + class1242 + text + class124 + "] " + message));
        if (SharedKt.getMc().method_18854()) {
            SharedKt.getPlayer().method_7353(class2561, false);
        }
        SharedKt.getMc().method_40000(this::updateValue);
    }

    public static String resolveString(Module receiver, String message, Object[] args, boolean common) {
        Object[] items = args;
        String text = ("common" + (receiver.getSubCategory().getString() + receiver.getString()) + "." + message);
        KeyServiceComponent keyServiceComponent = KeyServiceComponent.INSTANCE;
        Object[] items2 = items;
        Collection collection = ((Collection) new ArrayList(items));
        int index = 0;
        if (index < items2) {
            Object element = items2[index];
            if (__UNDEF_KEY__ == null) {
                Collection collection2 = collection;
                collection2.add(element);
            }
        }
        collection2 = collection;
        items = ((Collection) collection2);
        items2 = items;
        Object[] items3 = items2.toArray(new Object[0]);
        return keyServiceComponent.resolveString(text, Arrays.copyOf(items3, items3));
    }

    private static void updateValue(class_2561 arg0) {
        SharedKt.getPlayer().method_7353(arg0, false);
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
