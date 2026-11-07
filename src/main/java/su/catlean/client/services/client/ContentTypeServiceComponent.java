package su.catlean.client.services.client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpRequest.Builder;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import kotlin.random.Random;
import kotlin.random.Random.Default;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import net.minecraft.class_320;
import net.minecraft.client.MinecraftClient;
import org.apache.commons.compress.utils.Lists;
import su.catlean.SharedKt;
import su.catlean.api.contracts.Contract9;
import su.catlean.api.event.events.client.TickEvent;

public class ContentTypeServiceComponent implements Contract9 {

    public static final ContentTypeServiceComponent INSTANCE;
    private static final String textValue;
    private static final String textValue2;
    private static int countValue;
    private static boolean enabledFlag;
    private static boolean enabledFlag2;
    private static final ServiceComponent10 serviceComponent10;
    private static final ServiceComponent10 serviceComponent102;
    private static CopyOnWriteArrayList copyOnWriteArrayList;
    private static ConcurrentHashMap concurrentHashMap;
    private static int[] countValueArray;

    private ContentTypeServiceComponent() {
    }

    private void onTickEvent(TickEvent arg0) {
        if (!(enabledFlag2) && SharedKt.getMc().method_1548() != null && SharedKt.getMc().method_1548().method_1676() != null) {
            if ((CharSequence) SharedKt.getMc().method_1548().method_1676().length() <= 0) {
            }
            if (serviceComponent102.checkCondition2(150000)) {
            }
            enabledFlag2 = 1;
            RunnableServiceComponent var9 = RunnableServiceComponent.INSTANCE;
            int var10 = 0;
            int var11 = 0;
            var9.getExecutorService().execute((Runnable) new AnonimServiceComponent());
        }
        if (!(enabledFlag) && SharedKt.getMc().method_1548() != null && SharedKt.getMc().method_1548().method_1676() != null) {
            if ((CharSequence) SharedKt.getMc().method_1548().method_1676().length() <= 0) {
            }
        }
        enabledFlag = 1;
        var9 = RunnableServiceComponent.INSTANCE;
        var10 = 0;
        var11 = 0;
        var9.getExecutorService().execute((Runnable) new ServiceComponent94());
    }

    public void executeAction(String name) {
        String var4 = ("{\"value\":\"" + name + "\"}");
        HttpRequest var5 = HttpRequest.newBuilder(URI.create("https://api.catlean.su/v1/add")).header("Content-Type", "application/json").POST(BodyPublishers.ofString()).build();
        HttpClient.newHttpClient().send(BodyHandlers.ofString());
    }

    public List resolveList() {
        HttpRequest var3 = HttpRequest.newBuilder(URI.create("https://api.catlean.su/v1/online")).GET().build();
        HttpResponse var4 = HttpClient.newHttpClient().send(BodyHandlers.ofString());
        if (var4.statusCode() == 200) {
            Json var5 = ServiceComponent17.getJson();
            String var6 = (String) var4.body();
            int var7 = 0;
            var5.getSerializersModule();
        } else {
        }
        var4 = new ArrayList();
        var5 = var5.decodeFromString((DeserializationStrategy) new ArrayListSerializer(StringSerializer.INSTANCE));
        var4 = new ArrayList();
        return var4;
    }

    public boolean checkCondition(String string) {
        String var7 = (string + "1f");
        if (concurrentHashMap.contains()) {
            return (Boolean) concurrentHashMap.get();
        }
        String var8 = this.resolveString();
        boolean var9 = Lists.newArrayList(copyOnWriteArrayList.iterator()).contains();
        return var9;
    }

    private String resolveString(String arg0) {
        Object var8 = arg0;
        byte[] var7 = var8.getBytes(Charsets.UTF_8);
        String var9 = "sahur1337";
        var8 = var9.getBytes(Charsets.UTF_8);
        var9 = new byte[var7];
        int var10 = 0;
        Object var11 = var7;
        if (var10 < var11) {
            var9[var10] = (var7[var10] ^ var8[(var10 % var8)]);
        }
        return this.resolveString();
    }

    private String resolveString(byte[] arg0) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(Base64.getEncoder().encodeToString(arg0))));
    }

    public static String resolveString(ContentTypeServiceComponent $this, String input) {
        return $this.resolveString(input);
    }

    public static int getNumericValue() {
        return countValue;
    }

    public static CopyOnWriteArrayList getCopyOnWriteArrayList() {
        return copyOnWriteArrayList;
    }

    static {
        textValue2 = "https://api.catlean.su/v1";
        textValue = "sahur1337";
        INSTANCE = new ContentTypeServiceComponent();
        countValue = -1;
        serviceComponent10 = new ServiceComponent10();
        serviceComponent102 = new ServiceComponent10();
        copyOnWriteArrayList = new CopyOnWriteArrayList();
        concurrentHashMap = new ConcurrentHashMap();
        countValue = Random.Default.nextInt(0, 99999999);
    }

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

    public static int[] process() {
        return countValueArray;
    }

}
