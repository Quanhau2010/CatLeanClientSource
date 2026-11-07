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
        Iterable var7 = (Iterable) OptionMode13.getEnumEntries();
        int var8 = 0;
        Iterator iterator = var7.iterator();
        if (iterator.hasNext()) {
            Object var10 = iterator.next();
            OptionMode13 var11 = (OptionMode13) var10;
            int var12 = 0;
        } else {
        }
        if ((OptionMode13) null == null) {
        }
        optionMode13 = OptionMode13.INSTANCE;
    }

    public String resolveString(String key, Object[] args) {
        if ((String) optionMode13.getMap().get(key) == null && (String) OptionMode13.INSTANCE.getMap().get(key) == null) {
        }
        String var8 = class_1074.method_4662(key, new Object[0]);
        Object[] var10 = Arrays.copyOf(args, args);
        String var9 = String.format(Arrays.copyOf());
        var9 = ("Format error: " + var8);
        return var9;
    }

    public void executeAction(short arg0, char arg1, int arg2) {
        Object var7 = this;
        KeyServiceComponent var8 = (KeyServiceComponent) var7;
        int var9 = 0;
        Iterator iterator = OptionMode13.getEnumEntries().iterator();
        if (iterator.hasNext()) {
            OptionMode13 var11 = (OptionMode13) iterator.next();
            InputStream var12 = CatLean.class.getClassLoader().getResourceAsStream(("assets/catlean/translations/" + var11.name().toLowerCase(Locale.ROOT) + ".ctlang"));
            Object var13 = var12;
            Charset var14 = Charsets.UTF_8;
            Reader var15 = (Reader) new InputStreamReader();
            long var16 = 3923600994541248512L;
            if (var6 != null) {
                if (var15 instanceof BufferedReader) {
                }
            } else {
            }
            JsonElement var17 = (BufferedReader) var15.parseToJsonElement(TextStreamsKt.readText((Reader) new BufferedReader()));
            if (var6 != null) {
            }
            var13 = (Map) var17.entrySet().iterator();
            var14 = (Entry) var13.next();
            var15 = (String) var14.getKey();
            var16 = (JsonElement) var14.getValue();
            var11.getMap().put(JsonElementKt.getJsonPrimitive().getContent());
            if (arg0 >= 0) {
                if (arg0 >= 0) {
                    if (var6 != null) {
                    }
                }
            }
            var8 = Result.constructor-impl(Unit.INSTANCE);
        }
        var9 = Json.Default;
        var8 = Result.constructor-impl(ResultKt.createFailure());
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
