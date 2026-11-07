package su.catlean.client.services.client;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;
import su.catlean.client.features.modules.Module;

public class VersionServiceComponent {

    public static int computeValue(String version) {
        String[] var5 = new String[2];
        var5[0] = "+";
        var5[1] = ".";
        List positions = StringsKt.split$default((CharSequence) version, 0, 0, 5738932118344433670L);
        double var15 = 0.0D;
        Iterable var6 = (Iterable) CollectionsKt.reversed((Iterable) positions);
        int var7 = 0;
        int var8 = 0;
        Iterator iterator = var6.iterator();
        if (iterator.hasNext()) {
            Object var10 = iterator.next();
            int var11 = var8;
            if (var3 == null) {
                if (var3 == null) {
                    if (var11 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                }
                String var12 = (String) var10;
                int var13 = var11;
                int var14 = 0;
                var15 = (var15 + (Math.pow(10.0D) * Integer.parseInt()));
            }
        }
        return var15;
    }

    public static boolean isActive() {
        return false;
    }

}
