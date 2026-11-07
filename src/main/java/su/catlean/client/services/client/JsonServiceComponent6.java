package su.catlean.client.services.client;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.json.Json;
import org.slf4j.Logger;
import su.catlean.SharedKt;
import su.catlean.api.contracts.Contract3;
import su.catlean.client.services.client.config.models.IdRecord;
import su.catlean.client.services.client.config.models.IdRecord11;
import su.catlean.client.services.client.config.models.IdRecord9;
import su.catlean.client.services.client.config.models.SettingMacrosRecord;

public class JsonServiceComponent6 implements Contract3 {

    private final Json json;
    private final File file;
    public List itemList;

    public JsonServiceComponent6(Json json) {
        this.json = json;
        this.file = new File(ServiceComponent65.getFile(), "macro.ctlon");
    }

    public List resolveList() {
        if (this.itemList != null) {
            return this.itemList;
        }
        Intrinsics.throwUninitializedPropertyAccessException("data");
        return null;
    }

    public void executeAction(List value) {
        this.itemList = value;
    }

    public void updateValue() {
        if (this.file.createNewFile()) {
        }
        List list = new ArrayList();
        Json json = this.json;
        String text = FilesKt.readText$default(this.file);
        json.getSerializersModule();
        SettingMacrosRecord settingMacrosRecord = ((SettingMacrosRecord) json.decodeFromString(((DeserializationStrategy) SettingMacrosRecord.serviceComponent104.getKSerializer()), text));
        json = new ArrayList();
        text = json;
        text.addAll(((Collection) settingMacrosRecord.getList2()));
        text.addAll(((Collection) settingMacrosRecord.getList3()));
        text.addAll(((Collection) settingMacrosRecord.getList()));
        settingMacrosRecord = json;
        json = list;
        SharedKt.getLogger().warn("Macros are not loaded from file for some reasons.");
        settingMacrosRecord = new ArrayList();
        list.executeAction(settingMacrosRecord);
    }

    public void executeAction(int arg0, int arg1, byte arg2) {
        Json json = this.json;
        Iterable iterable = ((Iterable) this.resolveList());
        File file = this.file;
        int index = 0;
        Iterable iterable2 = iterable;
        Collection collection = ((Collection) new ArrayList());
        int index2 = 0;
        Iterator iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            collection.add(element);
        }
        List list = TypeIntrinsics.asMutableList(collection);
        index = ((Iterable) this.resolveList());
        iterable2 = 0;
        collection = index;
        index2 = ((Collection) new ArrayList());
        iterator = 0;
        element = collection.iterator();
        while (element.hasNext()) {
            Object element2 = element.next();
            index2.add(element2);
        }
        List list2 = TypeIntrinsics.asMutableList(index2);
        iterable2 = ((Iterable) this.resolveList());
        collection = 0;
        index2 = iterable2;
        iterator = ((Collection) new ArrayList());
        element = 0;
        element2 = index2.iterator();
        while (element2.hasNext()) {
            Object element3 = element2.next();
            iterator.add(element3);
        }
        iterable = TypeIntrinsics.asMutableList(iterator);
        list = new SettingMacrosRecord(iterable, list, list2);
        list2 = 0;
        json.getSerializersModule();
        FilesKt.writeText$default(file, json.encodeToString(((SerializationStrategy) SettingMacrosRecord.serviceComponent104.getKSerializer()), list));
    }

}
