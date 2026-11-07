package su.catlean.client.services.client;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.random.Random;
import kotlin.random.Random.Default;
import net.minecraft.class_1011;
import net.minecraft.class_1043;
import net.minecraft.class_1044;
import net.minecraft.class_1060;
import net.minecraft.class_2960;
import net.minecraft.client.MinecraftClient;
import su.catlean.SharedKt;

public class UrlServiceComponent {

    public static final UrlServiceComponent INSTANCE;
    private static final ConcurrentHashMap concurrentHashMap;
    private static final ConcurrentHashMap concurrentHashMap2;
    private static final class_2960 minecraftRef;
    private static int countValue;

    private UrlServiceComponent() {
    }

    public class_2960 resolveMinecraftObject(String url) {
        if (((class_2960) concurrentHashMap.get(url)) != null) {
            class_2960 class2960 = ((class_2960) concurrentHashMap.get(url));
            return class2960;
        }
        return minecraftRef;
    }

    public BufferedImage resolveBufferedImage(BufferedImage image) {
        int index = image.getWidth();
        int index2 = image.getHeight();
        int index3 = Math.min(index, index2);
        int index4 = ((index - index3) / 2);
        int index5 = ((index2 - index3) / 2);
        return image.getSubimage(index4, index5, index3, index3);
    }

    public class_1011 resolveMinecraftObject(class_1011 image) {
        int index = 64;
        int index2 = 32;
        int index3 = image.method_4307();
        int index4 = image.method_4323();
        int index5 = image.method_4323();
        if (index >= index3) {
            if (__UNDEF_KEY__ > 0) {
                if (__UNDEF_KEY__ == null) {
                    if (index2 < index5) {
                        index = (index * 2);
                        index2 = (index2 * 2);
                    }
                }
            }
        }
        class_1011 class1011 = new class_1011(index, index2, true);
        int index6 = 0;
        if (index6 < index3) {
            int index7 = 0;
            if (index7 < index4) {
                class1011.method_61941(index6, index7, image.method_61940(index6, index7));
            }
        }
        image.close();
        if (__UNDEF_KEY__ <= 0 || __UNDEF_KEY__ != null || __UNDEF_KEY__ > 0) {
            continue;
        }
        return class1011;
    }

    private static String resolveString(int arg0) {
        return ("ctl_dyn_texture_" + arg0);
    }

    private static void executeAction(class_2960 arg0, class_1011 arg1, String arg2, CompletableFuture arg3, int arg4) {
        SharedKt.getMc().method_1531().method_4616(arg0, ((class_1044) new class_1043(this::resolveString, arg1)));
        arg3.complete(arg0);
        concurrentHashMap2.remove(arg2);
    }

    private static void executeAction(String arg0, CompletableFuture arg1) {
        class_2960 class2960 = StringServiceComponent2.resolveMinecraftObject(("catlean-img-" + (Random.Default.nextFloat() * 100000)));
        InputStream inputStream = URI.create(arg0).toURL().openStream();
        class_1011 class1011 = class_1011.method_4309(inputStream);
        countValue = (countValue + 1);
        SharedKt.getMc().execute(this::executeAction);
        arg1.complete(minecraftRef);
        concurrentHashMap2.remove(arg0);
    }

    private static CompletableFuture resolveCompletableFuture(String arg0, String arg1) {
        CompletableFuture completableFuture = new CompletableFuture();
        new Thread(this::executeAction).start();
        return completableFuture;
    }

    private static CompletableFuture resolveCompletableFuture(Function1 arg0, Object arg1) {
        return ((CompletableFuture) arg0.invoke(arg1));
    }

    static {
        INSTANCE = new UrlServiceComponent();
        concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap2 = new ConcurrentHashMap();
        minecraftRef = StringServiceComponent2.resolveMinecraftObject("catlean", "textures/ui/windows/config.png");
    }

}
