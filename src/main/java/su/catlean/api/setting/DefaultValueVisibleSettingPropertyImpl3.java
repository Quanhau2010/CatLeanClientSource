package su.catlean.api.setting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import net.minecraft.block.Block;
import net.minecraft.class_7923;
import su.catlean.client.services.client.BlocksServiceComponent;
import su.catlean.client.services.client.ServiceComponent79;

public class DefaultValueVisibleSettingPropertyImpl3 extends VisibleSettingProperty {

    private static boolean enabledFlag;

    public DefaultValueVisibleSettingPropertyImpl3(String id, BlocksServiceComponent defaultValue, SettingGroup group, Function0 visible) {
        super(id, defaultValue, null, group, visible);
    }

    public void setValue(String setting) {
        Json json = VisibleSettingProperty.serviceComponent79.getJson();
        String text = setting;
        int index = 0;
        json.getSerializersModule();
        json = ((Iterable) json.decodeFromString(((DeserializationStrategy) new ArrayListSerializer(StringSerializer.INSTANCE)), text));
        text = 0;
        index = json;
        Collection collection = ((Collection) new ArrayList());
        Iterator iterator = index.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            String text2 = ((String) element);
            Iterable iterable = ((Iterable) class_7923.field_41175);
            if (__UNDEF_KEY__ != null) {
                Iterator iterator2 = iterable.iterator();
                while (iterator2.hasNext()) {
                    Object element2 = iterator2.next();
                    Block block = ((Block) element2);
                }
                if (((Block) null) != null) {
                    Block block2 = ((Block) null);
                    collection.add(block2);
                } else {
                }
            }
        }
        List list = CollectionsKt.toMutableList(((Collection) collection));
        this.updateValue(new BlocksServiceComponent(list));
    }

    public String toString() {
        Json json = VisibleSettingProperty.serviceComponent79.getJson();
        Iterable iterable = ((Iterable) ((BlocksServiceComponent) this.getObject2()).getList());
        Collection collection = ((Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10)));
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            Block block = ((Block) element);
            if (__UNDEF_KEY__ != null) {
                collection.add(block.method_63499());
            }
        }
        iterable = collection;
        json.getSerializersModule();
        return json.encodeToString(((SerializationStrategy) new ArrayListSerializer(StringSerializer.INSTANCE)), iterable);
    }

    private static boolean isActive() {
        return true;
    }

    public static void updateValue(boolean arg0) {
        enabledFlag = arg0;
    }

    public static boolean isActive2() {
        return enabledFlag;
    }

    public static boolean isActive3() {
        return true;
        return false;
    }

}
