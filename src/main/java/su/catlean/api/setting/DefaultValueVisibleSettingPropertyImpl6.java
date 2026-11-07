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
import net.minecraft.class_1299;
import net.minecraft.class_7923;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.EntitiesServiceComponent;
import su.catlean.client.services.client.ServiceComponent79;

public class DefaultValueVisibleSettingPropertyImpl6 extends VisibleSettingProperty {

    public DefaultValueVisibleSettingPropertyImpl6(String id, EntitiesServiceComponent defaultValue, SettingGroup group, Function0 visible) {
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
            Iterable iterable = ((Iterable) class_7923.field_41177);
            if (__UNDEF_KEY__ != null) {
                Iterator iterator2 = iterable.iterator();
                while (iterator2.hasNext()) {
                    Object element2 = iterator2.next();
                    class_1299 class1299 = ((class_1299) element2);
                }
                if (((class_1299) null) != null) {
                    class_1299 class12992 = ((class_1299) null);
                    collection.add(class12992);
                } else {
                }
            }
        }
        List list = CollectionsKt.toMutableList(((Collection) collection));
        this.updateValue(new EntitiesServiceComponent(list));
    }

    public String toString() {
        Json json = VisibleSettingProperty.serviceComponent79.getJson();
        Iterable iterable = ((Iterable) ((EntitiesServiceComponent) this.getObject2()).getList());
        Collection collection = ((Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10)));
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            class_1299 class1299 = ((class_1299) element);
            if (__UNDEF_KEY__ != null) {
                collection.add(class1299.method_5882());
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
