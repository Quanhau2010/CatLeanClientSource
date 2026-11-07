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
import net.minecraft.class_7923;
import net.minecraft.item.Item;
import su.catlean.client.services.client.ItemsServiceComponent2;
import su.catlean.client.services.client.ServiceComponent79;

public class DefaultValueVisibleSettingPropertyImpl8 extends VisibleSettingProperty {

    public DefaultValueVisibleSettingPropertyImpl8(String id, ItemsServiceComponent2 defaultValue, SettingGroup group, Function0 visible) {
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
            Iterable iterable = ((Iterable) class_7923.field_41178);
            if (__UNDEF_KEY__ != null) {
                Iterator iterator2 = iterable.iterator();
                while (iterator2.hasNext()) {
                    Object element2 = iterator2.next();
                    Item item = ((Item) element2);
                }
                if (((Item) null) != null) {
                    Item item2 = ((Item) null);
                    collection.add(item2);
                } else {
                }
            }
        }
        List list = CollectionsKt.toMutableList(((Collection) collection));
        this.updateValue(new ItemsServiceComponent2(list));
    }

    public String toString() {
        Json json = VisibleSettingProperty.serviceComponent79.getJson();
        Iterable iterable = ((Iterable) ((ItemsServiceComponent2) this.getObject2()).getList());
        Collection collection = ((Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10)));
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            Item item = ((Item) element);
            if (__UNDEF_KEY__ != null) {
                collection.add(item.method_7876());
            }
        }
        iterable = collection;
        json.getSerializersModule();
        return json.encodeToString(((SerializationStrategy) new ArrayListSerializer(StringSerializer.INSTANCE)), iterable);
    }

    private static boolean isActive() {
        return true;
    }

}
