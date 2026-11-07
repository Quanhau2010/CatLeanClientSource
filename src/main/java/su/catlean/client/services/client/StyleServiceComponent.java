package su.catlean.client.services.client;

import java.util.Arrays;
import java.util.Locale;
import java.util.Optional;
import kotlin.jvm.internal.StringCompanionObject;
import net.minecraft.class_2561;
import net.minecraft.class_2583;
import net.minecraft.class_5251;

public class StyleServiceComponent {

    public static final StyleServiceComponent INSTANCE;
    private static final char fieldValue;

    private StyleServiceComponent() {
    }

    public String resolveString(class_2561 t) {
        StringBuilder stringBuilder = new StringBuilder();
        Object element = new int[1];
        element[0] = -2147483648;
        t.method_27658(this::resolveOptional, class_2583.field_24360);
        stringBuilder.append(167).append(114);
        return stringBuilder.toString();
    }

    private String resolveString(int arg0) {
        Character character = this.resolveCharacter(arg0);
        if (character != null) {
            return (character);
        }
        return this.resolveString2(arg0);
    }

    private String resolveString2(int arg0) {
        Locale locale = Locale.ROOT;
        String text = "%06x";
        Object[] items = new Object[1];
        items[0] = Integer.valueOf((arg0 & 16777215));
        String text2 = String.format(locale, text, Arrays.copyOf(items, items));
        StringBuilder stringBuilder = new StringBuilder(14);
        stringBuilder.append(167).append(120);
        locale = 0;
        text = text2.length();
        if (locale < text) {
            items = text2.charAt(locale);
            if (__UNDEF_KEY__ == null) {
                stringBuilder.append(167).append(items);
            }
        }
        return stringBuilder.toString();
    }

    public Character resolveCharacter(int rgb) {
        return null;
    }

    private static Optional resolveOptional(int[] arg0, StringBuilder arg1, class_2583 arg2, String arg3) {
        if (!(((CharSequence) arg3).length())) {
            return Optional.empty();
        }
        if (arg2.method_10973() != null) {
        } else {
        }
        int index = -1;
        if (index != arg0[0]) {
            if (index == -1) {
            } else {
            }
            arg1.append(INSTANCE.resolveString(index));
            arg0[0] = index;
        }
        arg1.append(arg3);
        return Optional.empty();
    }

    static {
        INSTANCE = new StyleServiceComponent();
    }

}
