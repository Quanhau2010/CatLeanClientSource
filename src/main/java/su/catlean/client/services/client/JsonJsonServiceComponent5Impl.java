package su.catlean.client.services.client;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.json.Json;
import org.slf4j.Logger;
import su.catlean.SharedKt;
import su.catlean.client.services.client.config.models.IdRecord6;
import su.catlean.client.services.client.config.models.ModulesConfigRecord;

public class JsonJsonServiceComponent5Impl extends JsonServiceComponent5 {

    private final JsonServiceComponent4 jsonServiceComponent4;
    private final File file;
    public List itemList;
    public IdRecord6 idRecord6;

    public JsonJsonServiceComponent5Impl(Json json, JsonServiceComponent4 sharedSource) {
        super(json);
        this.jsonServiceComponent4 = sharedSource;
        this.file = new File(ServiceComponent65.getFile(), "themes");
    }

    public File getFile() {
        return this.file;
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

    public IdRecord6 resolveIdRecord6() {
        if (this.idRecord6 != null) {
            return this.idRecord6;
        }
        Intrinsics.throwUninitializedPropertyAccessException("current");
        return null;
    }

    public void executeAction(IdRecord6 value) {
        this.idRecord6 = value;
    }

    public void updateValue() {
        this.getFile().mkdirs();
        Object element = this;
        JsonServiceComponent5 jsonServiceComponent5 = this;
        int index = 0;
        if (__UNDEF_KEY__ == null) {
            if (jsonServiceComponent5.getFile().exists()) {
                if (__UNDEF_KEY__ == null) {
                    if (!(jsonServiceComponent5.getFile().isDirectory())) {
                    }
                }
            }
        }
        File[] items = jsonServiceComponent5.getFile().listFiles();
        if (__UNDEF_KEY__ == null) {
            if (items != null) {
                File[] items2 = items;
                int index2 = 0;
                File[] items3 = items2;
                Collection collection = ((Collection) new ArrayList());
                int index3 = 0;
                int index4 = 0;
                File[] items4 = items3;
                if (index4 < items4) {
                    Object element2 = items3[index4];
                    Object element3 = element2;
                    if (__UNDEF_KEY__ == null) {
                        if (__UNDEF_KEY__ == null) {
                            if (Intrinsics.areEqual(FilesKt.getExtension(element3), "ctlon")) {
                                collection.add(element2);
                            }
                        }
                        index2 = ((Iterable) collection);
                        items3 = 0;
                        collection = index2;
                        index3 = ((Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(index2, 10)));
                        index4 = 0;
                        items4 = collection.iterator();
                        while (items4.hasNext()) {
                            element2 = items4.next();
                            element3 = ((File) element2);
                            Json json = JsonServiceComponent5.S(jsonServiceComponent5);
                            String text = FilesKt.readText$default(element3);
                            json.getSerializersModule();
                            index3.add(json.decodeFromString(((DeserializationStrategy) IdRecord6.serviceComponent3.getKSerializer()), text));
                            if (__UNDEF_KEY__ == null) {
                                index2 = CollectionsKt.toMutableList(((Collection) index3));
                                if (__UNDEF_KEY__ == null) {
                                    if (index2 != null) {
                                    } else {
                                    }
                                }
                            } else {
                            }
                        }
                    } else {
                    }
                }
            } else {
            }
        }
        jsonServiceComponent5 = new ArrayList();
        index = element;
        SharedKt.getLogger().warn("Themes are not loaded from file for some reasons.");
        jsonServiceComponent5 = new ArrayList();
        element.executeAction(jsonServiceComponent5);
        index = ((Iterable) this.resolveList());
        element = this;
        items = 0;
        items2 = index.iterator();
        while (items2.hasNext()) {
            index2 = items2.next();
            items3 = ((IdRecord6) index2);
            collection = 0;
        }
        if (__UNDEF_KEY__ == null) {
            if (((IdRecord6) null) == null) {
                index = CatLeanServiceComponent.getIdRecord6();
                items = index;
                items2 = 0;
                this.resolveList().addAll(((Collection) CollectionsKt.listOf(CatLeanServiceComponent.getIdRecord6())));
            }
        }
        element.executeAction(index);
    }

    public void executeAction(int arg0, int arg1) {
        Iterable iterable = ((Iterable) this.resolveList());
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            IdRecord6 idRecord6 = ((IdRecord6) element);
            File file = new File(this.getFile(), (idRecord6.getString() + ".ctlon"));
            File file2 = file;
            file2.createNewFile();
            file = this.getJson();
            file2 = idRecord6;
            file.getSerializersModule();
            FilesKt.writeText$default(file, file.encodeToString(((SerializationStrategy) IdRecord6.serviceComponent3.getKSerializer()), file2));
            if (arg1 >= 0) {
            }
        }
    }

}
