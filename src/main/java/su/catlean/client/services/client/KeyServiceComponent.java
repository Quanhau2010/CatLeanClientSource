package su.catlean.client.services.client;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.Json.Default;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import net.minecraft.class_1074;
import su.catlean.CatLean;
import su.catlean.SharedKt;
import su.catlean.api.event.events.client.ScreenEvent;
import su.catlean.client.features.modules.Module;
import su.catlean.client.types.OptionMode13;

public class KeyServiceComponent {

    public static final KeyServiceComponent INSTANCE;
    private static OptionMode13 optionMode13;
    private static String textValue;

    private KeyServiceComponent() {
    }

    private void onScreenEvent(ScreenEvent arg0) {
        Iterable iterable = ((Iterable) OptionMode13.getEnumEntries());
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            OptionMode13 optionMode13 = ((OptionMode13) element);
        }
        if (((OptionMode13) null) == null) {
        }
        optionMode13 = OptionMode13.INSTANCE;
    }

    public String resolveString(String key, Object[] args) {
        if (((String) optionMode13.getMap().get(key)) == null && ((String) OptionMode13.INSTANCE.getMap().get(key)) == null) {
        }
        String text = class_1074.method_4662(key, new Object[0]);
        Object[] items = Arrays.copyOf(args, args);
        String text2 = String.format(text, Arrays.copyOf(items, items));
        text2 = ("Format error: " + text);
        return text2;
    }

    public void executeAction(short arg0, char arg1, int arg2) {
        int index = 0;
        Iterator iterator = OptionMode13.getEnumEntries().iterator();
        while (iterator.hasNext()) {
            OptionMode13 optionMode13 = ((OptionMode13) iterator.next());
            InputStream inputStream = CatLean.class.getClassLoader().getResourceAsStream(("assets/catlean/translations/" + optionMode13.name().toLowerCase(Locale.ROOT) + ".ctlang"));
            InputStream inputStream2 = inputStream;
            Charset charset = Charsets.UTF_8;
            Reader reader = ((Reader) new InputStreamReader(inputStream2, charset));
            int index2 = 8192;
            if (__UNDEF_KEY__ != null) {
                if (reader instanceof BufferedReader) {
                } else {
                }
            }
            JsonElement jsonElement = ((BufferedReader) reader).parseToJsonElement(TextStreamsKt.readText(((Reader) new BufferedReader(reader, index2))));
            if (__UNDEF_KEY__ != null) {
            }
            inputStream2 = ((Map) jsonElement).entrySet().iterator();
            charset = ((Entry) inputStream2.next());
            reader = ((String) charset.getKey());
            index2 = ((JsonElement) charset.getValue());
            optionMode13.getMap().put(reader, JsonElementKt.getJsonPrimitive(index2).getContent());
            if (arg0 >= 0) {
                if (arg0 >= 0) {
                    if (__UNDEF_KEY__ != null) {
                    }
                }
            }
        }
        index = Json.Default;
    }

    static {
        INSTANCE = new KeyServiceComponent();
        optionMode13 = OptionMode13.INSTANCE;
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
