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
        if ((class_2960) concurrentHashMap.get(url) != null) {
            class_2960 var6 = (class_2960) concurrentHashMap.get(url);
            int var7 = 0;
            return var6;
        }
        CompletableFuture var5 = (CompletableFuture) concurrentHashMap2.computeIfAbsent(url, this::resolveCompletableFuture);
        return minecraftRef;
    }

    public BufferedImage resolveBufferedImage(BufferedImage image) {
        int var4 = image.getWidth();
        int var5 = image.getHeight();
        int var6 = Math.min();
        int var7 = ((var4 - var6) / 2);
        int var8 = ((var5 - var6) / 2);
        return image.getSubimage();
    }

    public class_1011 resolveMinecraftObject(class_1011 image) {
        int var8 = 64;
        int var9 = 32;
        int var10 = image.method_4307();
        int var11 = image.method_4323();
        int var12 = image.method_4323();
        if (var8 >= var10) {
            if (0L > 0) {
                if (var7 == null) {
                }
                if (var9 < var12) {
                }
                var8 = (var8 * 2);
            }
            var9 = (var9 * 2);
        }
        class_1011 var13 = new class_1011(1);
        int var14 = 0;
        if (var15 < var11) {
            var13.method_61941(image.method_61940());
            if (var14 < var10 && 0L > 0 && var7 == null) {
            }
        }
        image.close();
        if (0L > 0) {
        }
        return var13;
    }

    private static String resolveString(int arg0) {
        return ("ctl_dyn_texture_" + arg0);
    }

    private static void executeAction(class_2960 arg0, class_1011 arg1, String arg2, CompletableFuture arg3, int arg4) {
        SharedKt.getMc().method_1531().method_4616(arg0, (class_1044) new class_1043(this::resolveString, arg1));
        arg3.complete(arg0);
        concurrentHashMap2.remove(arg2);
    }

    private static void executeAction(String arg0, CompletableFuture arg1) {
        class_2960 var8 = StringServiceComponent2.resolveMinecraftObject(("catlean-img-" + (Random.Default.nextFloat() * 100000)));
        InputStream var9 = URI.create(arg0).toURL().openStream();
        class_1011 var10 = class_1011.method_4309();
        countValue = (countValue + 1);
        int var11 = countValue;
        SharedKt.getMc().execute(this::executeAction);
        arg1.complete(minecraftRef);
        concurrentHashMap2.remove(arg0);
    }

    private static CompletableFuture resolveCompletableFuture(String arg0, String arg1) {
        CompletableFuture var4 = new CompletableFuture();
        Object var5 = var4;
        int var6 = 0;
        new Thread(this::executeAction).start();
        return var4;
    }

    private static CompletableFuture resolveCompletableFuture(Function1 arg0, Object arg1) {
        return (CompletableFuture) arg0.invoke(arg1);
    }

    static {
        INSTANCE = new UrlServiceComponent();
        concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap2 = new ConcurrentHashMap();
        minecraftRef = StringServiceComponent2.resolveMinecraftObject("catlean", "textures/ui/windows/config.png");
    }

}
