package su.catlean.client.services.client;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

public class ItemsServiceComponent2 {

    private final List itemList;
    private static String[] textValueArray;

    public ItemsServiceComponent2(List items) {
        this.itemList = items;
    }

    public List getList() {
        return this.itemList;
    }

    public List getList2() {
        return this.itemList;
    }

    public ItemsServiceComponent2 resolveItemsServiceComponent2(List items) {
        return new ItemsServiceComponent2(items);
    }

    public String toString() {
        return ("ItemsValue(items=" + this.itemList + ")");
    }

    public int hashCode() {
        return this.itemList.hashCode();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ItemsServiceComponent2)) {
            return false;
        }
        ItemsServiceComponent2 itemsServiceComponent2 = ((ItemsServiceComponent2) other);
        if (!(Intrinsics.areEqual(this.itemList, itemsServiceComponent2.itemList))) {
            return false;
        }
        return true;
    }

    public ItemsServiceComponent2() {
        this();
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

    public static String[] process() {
        return textValueArray;
    }

}
