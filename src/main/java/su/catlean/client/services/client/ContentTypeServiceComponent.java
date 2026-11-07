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
            if (((CharSequence) SharedKt.getMc().method_1548().method_1676()).length() <= 0) {
                if (serviceComponent102.checkCondition2(150000)) {
                    enabledFlag2 = 1;
                    RunnableServiceComponent runnableServiceComponent = RunnableServiceComponent.INSTANCE;
                    int index = 0;
                    runnableServiceComponent.getExecutorService().execute(((Runnable) new AnonimServiceComponent(index)));
                }
            }
        }
        if (!(enabledFlag) && SharedKt.getMc().method_1548() != null && SharedKt.getMc().method_1548().method_1676() != null) {
            if (((CharSequence) SharedKt.getMc().method_1548().method_1676()).length() <= 0) {
            }
        }
        enabledFlag = 1;
        runnableServiceComponent = RunnableServiceComponent.INSTANCE;
        index = 0;
        runnableServiceComponent.getExecutorService().execute(((Runnable) new ServiceComponent94(index)));
    }

    public void executeAction(String name) {
        String text = ("{\"value\":\"" + name + "\"}");
        HttpRequest httpRequest = HttpRequest.newBuilder(URI.create("https://api.catlean.su/v1/add")).header("Content-Type", "application/json").POST(BodyPublishers.ofString(text)).build();
        HttpClient.newHttpClient().send(httpRequest, BodyHandlers.ofString());
    }

    public List resolveList() {
        HttpRequest httpRequest = HttpRequest.newBuilder(URI.create("https://api.catlean.su/v1/online")).GET().build();
        HttpResponse httpResponse = HttpClient.newHttpClient().send(httpRequest, BodyHandlers.ofString());
        if (httpResponse.statusCode() == 200) {
            Json json = ServiceComponent17.getJson();
            String text = ((String) httpResponse.body());
            json.getSerializersModule();
        } else {
        }
        httpResponse = new ArrayList();
        json = json.decodeFromString(((DeserializationStrategy) new ArrayListSerializer(StringSerializer.INSTANCE)), text);
        httpResponse = new ArrayList();
        return httpResponse;
    }

    public boolean checkCondition(String string) {
        String text = (string + "1f");
        if (concurrentHashMap.contains(text)) {
            return ((Boolean) concurrentHashMap.get(text));
        }
        String text2 = this.resolveString(text);
        boolean flag = Lists.newArrayList(copyOnWriteArrayList.iterator()).contains(text2);
        return flag;
    }

    private String resolveString(String arg0) {
        String text = arg0;
        byte[] items = text.getBytes(Charsets.UTF_8);
        String text2 = "sahur1337";
        text = text2.getBytes(Charsets.UTF_8);
        text2 = new byte[items];
        int index = 0;
        if (index < items) {
            text2[index] = (items[index] ^ text[(index % text)]);
        }
        return this.resolveString(text2);
    }

    private String resolveString(byte[] arg0) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(Base64.getEncoder().encodeToString(arg0), 64, 40, false), 42, 41, false), 94, 37, false);
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
