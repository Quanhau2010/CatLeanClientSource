package su.catlean.api.setting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import net.minecraft.class_7923;
import net.minecraft.item.Item;
import su.catlean.client.services.client.ItemsServiceComponent2;
import su.catlean.client.services.client.ServiceComponent79;

public class DefaultValueVisibleSettingPropertyImpl8 extends VisibleSettingProperty {

    public DefaultValueVisibleSettingPropertyImpl8(String id, ItemsServiceComponent2 defaultValue, SettingGroup group, Function0 visible) {
        super(id, defaultValue, null, group, visible);
    }

    public DefaultValueVisibleSettingPropertyImpl8(String arg0, ItemsServiceComponent2 arg1, SettingGroup arg2, Function0 arg3, int arg4, DefaultConstructorMarker arg5) {
        if ((arg4 & 4)) {
        }
        if ((arg4 & 8)) {
            arg3 = this::isActive;
        }
        this(arg0, arg1, arg2, arg3);
    }

    public void setValue(String setting) {
        long var4 = ((0L ^ 100557064647339L) >>> 32);
        long var5 = (((0L ^ 100557064647339L) << 32) >>> 48);
        long var6 = (((0L ^ 100557064647339L) << 48) >>> 48);
        Json var8 = VisibleSettingProperty.serviceComponent79.getJson();
        Object var9 = setting;
        int var10 = 0;
        var8.getSerializersModule();
        var8 = (Iterable) var8.decodeFromString((DeserializationStrategy) new ArrayListSerializer(StringSerializer.INSTANCE));
        Object var29 = this;
        var9 = 0;
        var10 = var8;
        Collection var11 = (Collection) new ArrayList();
        int var12 = 0;
        Object var13 = var10;
        int var14 = 0;
        Iterator iterator = var13.iterator();
        if (iterator.hasNext()) {
            Object var16 = iterator.next();
            Object var17 = var16;
            int var18 = 0;
            String var19 = (String) var17;
            int var20 = 0;
            Iterable var21 = (Iterable) class_7923.field_41178;
            int var22 = 0;
            if (var7 != null) {
                Iterator iterator2 = var21.iterator();
                if (iterator2.hasNext()) {
                    Object var24 = iterator2.next();
                    Item var25 = (Item) var24;
                    int var26 = 0;
                } else {
                }
                if ((Item) null != null) {
                    Item var27 = (Item) null;
                    int var28 = 0;
                    var11.add();
                } else {
                }
            }
            if (0L >= 0L) {
            }
        }
        List positions = CollectionsKt.toMutableList((Collection) var11);
        var29.updateValue(new ItemsServiceComponent2(positions));
    }

    public String toString() {
        Json var4 = VisibleSettingProperty.serviceComponent79.getJson();
        Iterable var5 = (Iterable) (ItemsServiceComponent2) this.getObject2().getList();
        int var6 = 0;
        Object var7 = var5;
        Collection var8 = (Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(10));
        int var9 = 0;
        Iterator iterator = var7.iterator();
        if (iterator.hasNext()) {
            Object var11 = iterator.next();
            Item var12 = (Item) var11;
            if (var3 != null) {
                Object var14 = var8;
                int var13 = 0;
                var14.add(var12.method_7876());
            }
        }
        var5 = var8;
        var6 = 0;
        var4.getSerializersModule();
        return var4.encodeToString((SerializationStrategy) new ArrayListSerializer(StringSerializer.INSTANCE));
    }

    private static boolean isActive() {
        return true;
    }

}
