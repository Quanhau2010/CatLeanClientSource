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
        Iterable iterable = ((Iterable) this.itemList);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            String text = ((String) element);
        }
        return ((String) null);
    }

}
