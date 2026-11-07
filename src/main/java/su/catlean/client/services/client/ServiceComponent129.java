package su.catlean.client.services.client;

import java.util.Iterator;
import kotlin.collections.Grouping;
import net.minecraft.class_1542;
import net.minecraft.item.ItemStack;

public class ServiceComponent129 implements Grouping {

    private final Iterable iterable;

    public ServiceComponent129(Iterable $receiver) {
        this.iterable = $receiver;
    }

    public Iterator sourceIterator() {
        return this.iterable.iterator();
    }

    public Object keyOf(Object element) {
        class_1542 var6 = (class_1542) element;
        int var7 = 0;
        return ServiceComponent86.resolveString(var6.method_6983().method_7964());
    }

}
