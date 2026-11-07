package su.catlean.client.services.client;

import java.util.Iterator;
import java.util.List;
import kotlin.text.StringsKt;

public class SuggestionsServiceComponent {

    private final List itemList;

    public SuggestionsServiceComponent(List suggestions) {
        this.itemList = suggestions;
    }

    public String resolveString(String s) {
        Iterable var5 = (Iterable) this.itemList;
        int var6 = 0;
        Iterator iterator = var5.iterator();
        if (iterator.hasNext()) {
            Object var8 = iterator.next();
            String var9 = (String) var8;
            int var10 = 0;
        } else {
        }
        return (String) null;
    }

}
