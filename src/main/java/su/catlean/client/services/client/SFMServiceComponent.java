package su.catlean.client.services.client;

import java.awt.Font;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import su.catlean.CatLean;
import su.catlean.client.services.render.FontRenderHelper;

public class SFMServiceComponent {

    public static FontRenderHelper fontRenderHelper;
    public static FontRenderHelper fontRenderHelper2;
    public static FontRenderHelper fontRenderHelper3;
    public static FontRenderHelper fontRenderHelper4;
    public static FontRenderHelper fontRenderHelper5;
    public static FontRenderHelper fontRenderHelper6;
    public static FontRenderHelper fontRenderHelper7;
    public static FontRenderHelper fontRenderHelper8;
    public static FontRenderHelper fontRenderHelper9;
    public static FontRenderHelper fontRenderHelper10;
    private static final List itemList;
    private static String[] textValueArray;

    public static FontRenderHelper resolveFontRenderHelper() {
        if (fontRenderHelper != null) {
            return fontRenderHelper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("SF_M");
        return null;
    }

    public static void executeAction(FontRenderHelper value) {
        fontRenderHelper = value;
    }

    public static FontRenderHelper resolveFontRenderHelper2() {
        if (fontRenderHelper2 != null) {
            return fontRenderHelper2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("SF_M2");
        return null;
    }

    public static void executeAction(FontRenderHelper value) {
        fontRenderHelper2 = value;
    }

    public static FontRenderHelper resolveFontRenderHelper3() {
        if (fontRenderHelper3 != null) {
            return fontRenderHelper3;
        }
        Intrinsics.throwUninitializedPropertyAccessException("SF_M3");
        return null;
    }

    public static void executeAction2(FontRenderHelper value) {
        fontRenderHelper3 = value;
    }

    public static FontRenderHelper resolveFontRenderHelper4() {
        if (fontRenderHelper4 != null) {
            return fontRenderHelper4;
        }
        Intrinsics.throwUninitializedPropertyAccessException("SF_M4");
        return null;
    }

    public static void executeAction3(FontRenderHelper value) {
        fontRenderHelper4 = value;
    }

    public static FontRenderHelper resolveFontRenderHelper5() {
        if (fontRenderHelper5 != null) {
            return fontRenderHelper5;
        }
        Intrinsics.throwUninitializedPropertyAccessException("SF_B");
        return null;
    }

    public static void executeAction(FontRenderHelper value) {
        fontRenderHelper5 = value;
    }

    public static FontRenderHelper resolveFontRenderHelper6() {
        if (fontRenderHelper6 != null) {
            return fontRenderHelper6;
        }
        Intrinsics.throwUninitializedPropertyAccessException("SF_B2");
        return null;
    }

    public static void executeAction4(FontRenderHelper value) {
        fontRenderHelper6 = value;
    }

    public static FontRenderHelper resolveFontRenderHelper7() {
        if (fontRenderHelper7 != null) {
            return fontRenderHelper7;
        }
        Intrinsics.throwUninitializedPropertyAccessException("SF_B3");
        return null;
    }

    public static void executeAction2(FontRenderHelper value) {
        fontRenderHelper7 = value;
    }

    public static FontRenderHelper resolveFontRenderHelper8() {
        if (fontRenderHelper8 != null) {
            return fontRenderHelper8;
        }
        Intrinsics.throwUninitializedPropertyAccessException("SF_B4");
        return null;
    }

    public static void executeAction3(FontRenderHelper value) {
        fontRenderHelper8 = value;
    }

    public static FontRenderHelper resolveFontRenderHelper9() {
        if (fontRenderHelper9 != null) {
            return fontRenderHelper9;
        }
        Intrinsics.throwUninitializedPropertyAccessException("SF_SB");
        return null;
    }

    public static void executeAction4(FontRenderHelper value) {
        fontRenderHelper9 = value;
    }

    public static FontRenderHelper resolveFontRenderHelper10() {
        if (fontRenderHelper10 != null) {
            return fontRenderHelper10;
        }
        Intrinsics.throwUninitializedPropertyAccessException("SF");
        return null;
    }

    public static void executeAction5(FontRenderHelper value) {
        fontRenderHelper10 = value;
    }

    public static List getList() {
        return itemList;
    }

    public static Font resolveFont(float size, String name) {
        return Font.createFont(0, ((InputStream) Objects.requireNonNull(CatLean.class.getClassLoader().getResourceAsStream(("assets/catlean/fonts/" + name + ".ttf"))))).deriveFont(0, size);
    }

    public static FontRenderHelper resolveFontRenderHelper(float size, String name) {
        FontRenderHelper fontRenderHelper = new FontRenderHelper(resolveFont(size, name), resolveFont(size, "noto"), size);
        itemList.add(fontRenderHelper);
        return fontRenderHelper;
    }

    static {
        itemList = new ArrayList();
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

    public static String[] process() {
        return textValueArray;
    }

}
