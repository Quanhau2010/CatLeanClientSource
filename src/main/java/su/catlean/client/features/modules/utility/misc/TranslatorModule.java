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
        return ((TranslatorUrLangMode) urLangSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private TranslatorUrLangMode getOutMessages() {
        return ((TranslatorUrLangMode) outMessagesSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private void onReceivePacket(ReceivePacket arg0) {
        class_7439 class7439 = ((class_7439) arg0.getPacket());
        String text = class7439.comp_763().getString();
        Iterator iterator = itemList.iterator();
        while (iterator.hasNext()) {
            String text2 = ((String) iterator.next());
            return;
        }
        iterator = RunnableServiceComponent.INSTANCE;
        text2 = 0;
        iterator.getExecutorService().execute(((Runnable) new ServiceComponent116(text2, text)));
    }

    private void onSendPacket(SendPacket arg0) {
        class_2797 class2797 = ((class_2797) arg0.getPacket());
        if (Objects.equals(class2797.comp_945(), textValue)) {
            return;
        }
        if (!(arg0.getPacket() instanceof class_2797) || Intrinsics.areEqual(SharedKt.getPlayer().method_6047().getItem(), Items.field_8204) || Intrinsics.areEqual(SharedKt.getPlayer().method_6079().getItem(), Items.field_8204)) {
            return;
        }
        if (StringsKt.startsWith$default(class2797.comp_945(), "/", false)) {
            return;
        }
        RunnableServiceComponent runnableServiceComponent = RunnableServiceComponent.INSTANCE;
        int index = 0;
        runnableServiceComponent.getExecutorService().execute(((Runnable) new ServiceComponent15(index, class2797)));
        arg0.cancel();
    }

    private String resolveString(String arg0, String arg1, long arg2) {
        StringBuilder stringBuilder = new StringBuilder();
        String text = "https://translate.google.com/m?hl=en&sl=auto&tl=%s&ie=UTF-8&prev=_m&q=%s";
        Object[] items = new Object[2];
        items[0] = arg1;
        String text2 = arg0;
        int index = 1;
        int index2 = 0;
        CharSequence charSequence = ((CharSequence) text2);
        int index3 = 0;
        int index4 = (charSequence.length() - 1);
        int index5 = 0;
        if (index3 <= index4) {
            if (__UNDEF_KEY__ == null) {
                if (!(index5)) {
                } else {
                }
            }
            char ch = charSequence.charAt(index4);
            if (__UNDEF_KEY__ == null) {
                if (Intrinsics.compare(ch, 32) <= 0) {
                } else {
                }
            }
            ch = 0;
            if (__UNDEF_KEY__ == null) {
                if (!(index5)) {
                    if (__UNDEF_KEY__ == null) {
                        if (!(ch)) {
                            index5 = 1;
                        }
                    }
                }
            }
            if (!(ch)) {
                if (__UNDEF_KEY__ != null) {
                }
            }
        }
        String text3 = charSequence.subSequence(index3, (index4 + 1)).toString();
        items[index] = URLEncoder.encode(text3, "UTF-8");
        URI uRI = URI.create(String.format(text, Arrays.copyOf(items, items)));
        Closeable closeable = ((Closeable) new BufferedReader(((Reader) new InputStreamReader(uRI.toURL().openStream(), "UTF-8"))));
        text = ((BufferedReader) closeable);
        items = 0;
        index2 = text.readLine();
        charSequence = index2;
        text2 = charSequence;
        if (index2 != null) {
            stringBuilder.append((text2));
            if (__UNDEF_KEY__ == null) {
            }
        }
        text = Unit.INSTANCE;
        CloseableKt.closeFinally(closeable);
        items = 1;
        Object[] items2 = items;
        CloseableKt.closeFinally(closeable, items2);
        closeable = items;
        closeable.printStackTrace();
        closeable = Pattern.compile("class=\"result-container\">([^<]*)</div>", 8).matcher(((CharSequence) stringBuilder));
        closeable.find();
        items2 = closeable.group(1);
        if (__UNDEF_KEY__ == null) {
            if (!(((CharSequence) items2).length())) {
            } else {
            }
        }
        if (0) {
            return "translation failed";
        }
        return StringEscapeUtils.unescapeHtml4(items2);
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
        KProperty[] items = new KProperty[2];
        INSTANCE = new TranslatorModule();
        urLangSetting = VisibleRenderHelper.registerSetting(INSTANCE, "your-language", TranslatorUrLangMode.INSTANCE35);
        outMessagesSetting = VisibleRenderHelper.registerSetting(INSTANCE, "out-messages", TranslatorUrLangMode.INSTANCE47);
        items = new String[4];
        items[0] = "was killed by";
        items[1] = "was destroyed by";
        items[2] = "has joined a game";
        items[3] = "has left the game";
        itemList = CollectionsKt.listOf(items);
    }

}
