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
        double var8 = 0.0D;
        double var10 = 0.0D;
        double var12 = 0.0D;
        Iterator iterator = this.itemList.iterator();
        if (iterator.hasNext()) {
            class_1542 var15 = (class_1542) iterator.next();
            var8 = (var8 + var5.computeValue(PolygonShaderComponent.INSTANCE, var15.field_6014, EntityHelper.resolveMinecraftObject().field_1352));
            var10 = (var10 + var5.computeValue(PolygonShaderComponent.INSTANCE, var15.field_6036, EntityHelper.resolveMinecraftObject().field_1351));
            var12 = (var12 + var5.computeValue(PolygonShaderComponent.INSTANCE, var15.field_5969, EntityHelper.resolveMinecraftObject().field_1350));
        }
        iterator = this.itemList.size();
        return new Vec3d((var8 / iterator), ((var10 / iterator) + 0.7D), (var12 / iterator));
    }

    public List resolveList() {
        Iterable var4 = (Iterable) this.itemList;
        int var5 = 0;
        var4 = (Grouping) new ServiceComponent129();
        var5 = Integer.valueOf(0);
        int var6 = 0;
        Object var7 = var4;
        int var8 = 0;
        Object var9 = var7;
        Map var10 = (Map) new LinkedHashMap();
        int var11 = 0;
        Iterator iterator = var9.sourceIterator();
        while (iterator.hasNext()) {
            Object var13 = iterator.next();
            Object var14 = var9.keyOf();
            boolean var17 = !(var10.containsKey());
            Object var18 = var13;
            Object var19 = var15;
            Object var20 = var14;
            int var21 = 0;
            class_1542 var22 = (class_1542) var17;
            int var23 = (Number) var18;
            int var24 = 0;
            var23 = Integer.valueOf((var23 + var22.method_6983().method_7947()));
            var20.put();
        }
        var4 = var10;
        var5 = 0;
        var6 = var4;
        var7 = (Collection) new ArrayList(var4.size());
        var8 = 0;
        var9 = var6.entrySet().iterator();
        while (var9.hasNext()) {
            var10 = (Entry) var9.next();
            var11 = var10;
            Object var25 = var7;
            iterator = 0;
            var13 = (String) var11.getKey();
            var14 = (Number) var11.getValue();
            var25.add((var13 + " x" + var14));
        }
        return var7;
    }

    public List getList2() {
        return this.itemList;
    }

    public ItemsServiceComponent resolveItemsServiceComponent(List items) {
        return new ItemsServiceComponent(items);
    }

    public static ItemsServiceComponent resolveItemsServiceComponent(ItemsServiceComponent arg0, List arg1, int arg2, Object arg3) {
        if ((arg2 & 1)) {
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
        ItemsServiceComponent var5 = (ItemsServiceComponent) other;
        if (!(Intrinsics.areEqual(this.itemList, var5.itemList))) {
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
