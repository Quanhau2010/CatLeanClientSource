package su.catlean.client.services.client;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;
import su.catlean.client.features.modules.Module;

public class VersionServiceComponent {

    public static int computeValue(String version) {
        String[] items = new String[2];
        items[0] = "+";
        items[1] = ".";
        List list = StringsKt.split$default(((CharSequence) version), items, false);
        double offset = 0.0D;
        Iterable iterable = ((Iterable) CollectionsKt.reversed(((Iterable) list)));
        int index = 0;
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            if (__UNDEF_KEY__ == null) {
                if (__UNDEF_KEY__ == null) {
                    if (index < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                }
                String text = ((String) element);
                offset = (offset + (Math.pow(10.0D, index) * Integer.parseInt(text)));
            }
        }
        return offset;
    }

    public static boolean isActive() {
        return false;
    }

}
