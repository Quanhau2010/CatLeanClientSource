package su.catlean.client.features.modules.utility.misc;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import net.minecraft.class_2561;
import net.minecraft.class_2797;
import net.minecraft.class_7439;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.apache.commons.lang3.StringEscapeUtils;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.event.events.network.SendPacket;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.RunnableServiceComponent;
import su.catlean.client.services.client.ServiceComponent116;
import su.catlean.client.services.client.ServiceComponent15;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.VisibleRenderHelper;

public class TranslatorModule extends Module {

    public static final TranslatorModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 urLangSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 outMessagesSetting;
    private static final List itemList;
    private static String textValue;

    private TranslatorModule() {
        super("translator", SubCategoriesKt.getMiscUtilityCategory());
    }

    private TranslatorUrLangMode getUrLang() {
        return (TranslatorUrLangMode) urLangSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private TranslatorUrLangMode getOutMessages() {
        return (TranslatorUrLangMode) outMessagesSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private void onReceivePacket(ReceivePacket arg0) {
        if (var4 == null) {
        }
        class_7439 var5 = (class_7439) arg0.getPacket();
        String var6 = var5.comp_763().getString();
        Iterator iterator = itemList.iterator();
        if (iterator.hasNext()) {
            String var8 = (String) iterator.next();
            return;
        }
        iterator = RunnableServiceComponent.INSTANCE;
        var8 = 0;
        int var9 = 0;
        iterator.getExecutorService().execute((Runnable) new ServiceComponent116());
    }

    private void onSendPacket(SendPacket arg0) {
        class_2797 var7 = (class_2797) arg0.getPacket();
        if (Objects.equals(var7.comp_945(), textValue)) {
            return;
        }
        if (!(arg0.getPacket() instanceof class_2797) || Intrinsics.areEqual(SharedKt.getPlayer().method_6047().getItem(), Items.field_8204) || Intrinsics.areEqual(SharedKt.getPlayer().method_6079().getItem(), Items.field_8204)) {
            return;
        }
        if (StringsKt.startsWith$default(var7.comp_945(), "/")) {
            return;
        }
        RunnableServiceComponent var8 = RunnableServiceComponent.INSTANCE;
        int var9 = 0;
        int var10 = 0;
        var8.getExecutorService().execute((Runnable) new ServiceComponent15());
        arg0.cancel();
    }

    private String resolveString(String arg0, String arg1, long arg2) {
        StringBuilder var6 = new StringBuilder();
        String var10 = "https://translate.google.com/m?hl=en&sl=auto&tl=%s&ie=UTF-8&prev=_m&q=%s";
        Object[] var11 = new Object[2];
        var11[0] = arg1;
        Object var12 = arg0;
        int var23 = 1;
        Object var22 = var11;
        int var13 = 0;
        CharSequence var14 = (CharSequence) var12;
        int var15 = 0;
        int var16 = 0;
        int var17 = (var14.length() - 1);
        int var18 = 0;
        if (var16 <= var17) {
            if (var5 == null) {
                if (!(var18)) {
                }
            } else {
            }
            int var19 = var17;
            char var20 = var14.charAt();
            int var21 = 0;
            if (var5 == null) {
                if (Intrinsics.compare(32) <= 0) {
                }
            } else {
            }
            var20 = 0;
            if (var5 == null) {
                if (!(var18)) {
                    if (var5 == null) {
                        if (!(var20)) {
                        }
                        var18 = 1;
                    }
                }
            }
            if (!(var20)) {
                if (var5 != null) {
                }
            }
        }
        String var24 = var14.subSequence((var17 + 1)).toString();
        var22[var23] = URLEncoder.encode("UTF-8");
        URI var7 = URI.create(String.format(Arrays.copyOf()));
        Closeable var8 = (Closeable) new BufferedReader((Reader) new InputStreamReader(var7.toURL().openStream(), "UTF-8"));
        var10 = (BufferedReader) var8;
        var11 = 0;
        var13 = var10.readLine();
        var14 = var13;
        var15 = 0;
        var12 = var14;
        if (var13 != null) {
            var6.append((var12));
            if (var5 == null) {
            }
        }
        var10 = Unit.INSTANCE;
        CloseableKt.closeFinally();
        var11 = 1;
        Object var9 = var11;
        CloseableKt.closeFinally();
        var8 = var11;
        var8.printStackTrace();
        var8 = Pattern.compile("class=\"result-container\">([^<]*)</div>", 8).matcher((CharSequence) var6);
        var8.find();
        var9 = var8.group(1);
        if (var5 == null) {
            if (!((CharSequence) var9.length())) {
            }
        } else {
        }
        if (0) {
            return "translation failed";
        }
        return StringEscapeUtils.unescapeHtml4();
    }

    public static String resolveString(TranslatorModule $this, String text, String to) {
        return $this.resolveString(text, to);
    }

    public static TranslatorUrLangMode resolveTranslatorUrLangMode(TranslatorModule $this) {
        return $this.getUrLang();
    }

    public static TranslatorUrLangMode resolveTranslatorUrLangMode(TranslatorModule $this) {
        return $this.getOutMessages();
    }

    public static void updateValue(String value) {
        textValue = value;
    }

    static {
        KProperty[] var26 = new KProperty[2];
        INSTANCE = new TranslatorModule();
        urLangSetting = VisibleRenderHelper.registerSetting(INSTANCE, "your-language", TranslatorUrLangMode.INSTANCE35);
        outMessagesSetting = VisibleRenderHelper.registerSetting(INSTANCE, "out-messages", TranslatorUrLangMode.INSTANCE47);
        var26 = new String[4];
        var26[0] = "was killed by";
        var26[1] = "was destroyed by";
        var26[2] = "has joined a game";
        var26[3] = "has left the game";
        itemList = CollectionsKt.listOf();
    }

}
