package su.catlean.client.services.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.collections.Grouping;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1542;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import su.catlean.client.services.player.EntityHelper;
import su.catlean.client.services.render.shader.PolygonShaderComponent;

public class ItemsServiceComponent {

    private final List itemList;
    private static int countValue;

    public ItemsServiceComponent(List items) {
        this.itemList = items;
    }

    public List getList() {
        return this.itemList;
    }

    public Vec3d resolveMinecraftObject() {
        if (this.itemList.isEmpty()) {
            return Vec3d.ZERO;
        }
        double offset = 0.0D;
        double offset2 = 0.0D;
        double offset3 = 0.0D;
        Iterator iterator = this.itemList.iterator();
        while (iterator.hasNext()) {
            class_1542 class1542 = ((class_1542) iterator.next());
            offset = (offset + this.computeValue(PolygonShaderComponent.INSTANCE, class1542.field_6014, EntityHelper.resolveMinecraftObject(class1542).field_1352));
            offset2 = (offset2 + this.computeValue(PolygonShaderComponent.INSTANCE, class1542.field_6036, EntityHelper.resolveMinecraftObject(class1542).field_1351));
            offset3 = (offset3 + this.computeValue(PolygonShaderComponent.INSTANCE, class1542.field_5969, EntityHelper.resolveMinecraftObject(class1542).field_1350));
        }
        iterator = this.itemList.size();
        return new Vec3d((offset / iterator), ((offset2 / iterator) + 0.7D), (offset3 / iterator));
    }

    public List resolveList() {
        Iterable iterable = ((Iterable) this.itemList);
        int index = 0;
        iterable = ((Grouping) new ServiceComponent129(iterable));
        index = Integer.valueOf(0);
        int index2 = 0;
        Iterable iterable2 = iterable;
        Iterable iterable3 = iterable2;
        Map map = ((Map) new LinkedHashMap());
        int index3 = 0;
        Iterator iterator = iterable3.sourceIterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            Object element2 = iterable3.keyOf(element);
            boolean flag = !(map.containsKey(element2));
            class_1542 class1542 = ((class_1542) flag);
            int index4 = ((Number) element);
            index4 = Integer.valueOf((index4 + class1542.method_6983().method_7947()));
            element2.put(index4);
        }
        iterable = map;
        index = 0;
        index2 = iterable;
        iterable2 = ((Collection) new ArrayList(iterable.size()));
        iterable3 = index2.entrySet().iterator();
        while (iterable3.hasNext()) {
            map = ((Entry) iterable3.next());
            index3 = map;
            iterator = 0;
            element = ((String) index3.getKey());
            element2 = ((Number) index3.getValue());
            iterable2.add((element + " x" + element2));
        }
        return iterable2;
    }

    public List getList2() {
        return this.itemList;
    }

    public ItemsServiceComponent resolveItemsServiceComponent(List items) {
        return new ItemsServiceComponent(items);
    }

    public static ItemsServiceComponent resolveItemsServiceComponent(ItemsServiceComponent arg0, List arg1, int arg2, Object arg3) {
        if ((arg2 & 1) != 0) {
            arg1 = arg0.itemList;
        }
        return arg0.resolveItemsServiceComponent(arg1);
    }

    public String toString() {
        return ("ItemCluster(items=" + this.itemList + ")");
    }

    public int hashCode() {
        return this.itemList.hashCode();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ItemsServiceComponent)) {
            return false;
        }
        ItemsServiceComponent itemsServiceComponent = ((ItemsServiceComponent) other);
        if (!(Intrinsics.areEqual(this.itemList, itemsServiceComponent.itemList))) {
            return false;
        }
        return true;
    }

    public static void updateValue(int arg0) {
        countValue = arg0;
    }

    public static int getNumericValue() {
        return countValue;
    }

    public static int getNumericValue2() {
        return 72;
        return 0;
    }

}
