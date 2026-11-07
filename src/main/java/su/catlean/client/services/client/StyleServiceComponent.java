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
        StringBuilder var4 = new StringBuilder();
        Object var6 = new int[1];
        var6[0] = -2147483648;
        Object var5 = var6;
        t.method_27658(this::resolveOptional, class_2583.field_24360);
        var4.append(167).append(114);
        return var4.toString();
    }

    private String resolveString(int arg0) {
        Character var9 = this.resolveCharacter(arg0);
        if (var9 != null) {
            return (var9);
        }
        return this.resolveString2(arg0);
    }

    private String resolveString2(int arg0) {
        Locale var7 = Locale.ROOT;
        String var8 = "%06x";
        Object[] var9 = new Object[1];
        var9[0] = Integer.valueOf((arg0 & 16777215));
        String var5 = String.format(Arrays.copyOf());
        StringBuilder var6 = new StringBuilder(14);
        var6.append(167).append(120);
        var7 = 0;
        var8 = var5.length();
        if (var7 < var8) {
            var9 = var5.charAt();
            if (var4 == null) {
                var6.append(167).append();
            }
        }
        return var6.toString();
    }

    public Character resolveCharacter(int rgb) {
        return null;
    }

    private static Optional resolveOptional(int[] arg0, StringBuilder arg1, class_2583 arg2, String arg3) {
        if (!((CharSequence) arg3.length())) {
            return Optional.empty();
        }
        if (arg2.method_10973() != null) {
        } else {
        }
        int var9 = -1;
        if (var9 != arg0[0]) {
            if (var9 == -1) {
            } else {
            }
            arg1.append(INSTANCE.resolveString());
            arg0[0] = var9;
        }
        arg1.append(arg3);
        return Optional.empty();
    }

    static {
        INSTANCE = new StyleServiceComponent();
    }

}
