package su.catlean.client.services.client;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.json.Json;
import org.slf4j.Logger;
import su.catlean.SharedKt;
import su.catlean.api.setting.VisibleSettingProperty;
import su.catlean.client.services.client.config.models.IdRecord10;
import su.catlean.client.services.client.config.models.IdRecord5;
import su.catlean.client.services.client.config.models.IdRecord8;
import su.catlean.client.services.client.config.models.ModulesConfigRecord;
import su.catlean.client.services.render.CheckRenderHelper;

public class JsonJsonServiceComponent5Impl4 extends JsonServiceComponent5 {

    private final JsonServiceComponent4 jsonServiceComponent4;
    private final File file;
    public IdRecord8 idRecord8;
    public List itemList;
    private static String[] textValueArray;

    public JsonJsonServiceComponent5Impl4(Json json, JsonServiceComponent4 sharedSource) {
        super(json);
        this.jsonServiceComponent4 = sharedSource;
        this.file = new File(ServiceComponent65.getFile(), "widgets");
    }

    public File getFile() {
        return this.file;
    }

    public IdRecord8 resolveIdRecord8() {
        if (this.idRecord8 != null) {
            return this.idRecord8;
        }
        Intrinsics.throwUninitializedPropertyAccessException("current");
        return null;
    }

    public void executeAction(IdRecord8 value) {
        this.idRecord8 = value;
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
                            index3.add(json.decodeFromString(((DeserializationStrategy) IdRecord8.serviceComponent32.getKSerializer()), text));
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
        SharedKt.getLogger().warn("Widgets are not loaded from file for some reasons.");
        jsonServiceComponent5 = new ArrayList();
        element.executeAction(jsonServiceComponent5);
        index = ((Iterable) this.resolveList());
        element = this;
        items = 0;
        items2 = index.iterator();
        while (items2.hasNext()) {
            index2 = items2.next();
            items3 = ((IdRecord8) index2);
            collection = 0;
        }
        if (__UNDEF_KEY__ == null) {
            if (((IdRecord8) null) == null) {
                index = new IdRecord8(this.jsonServiceComponent4.resolveModulesConfigRecord().getString2());
                items = index;
                items2 = 0;
                this.resolveList().add(items);
            }
        }
        element.executeAction(index);
    }

    public void executeAction(int arg0) {
        Iterable iterable = ((Iterable) this.resolveList());
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            IdRecord8 idRecord8 = ((IdRecord8) element);
            File file = new File(this.getFile(), (idRecord8.getString() + ".ctlon"));
            File file2 = file;
            file2.createNewFile();
            file = this.getJson();
            file2 = idRecord8;
            file.getSerializersModule();
            FilesKt.writeText$default(file, file.encodeToString(((SerializationStrategy) IdRecord8.serviceComponent32.getKSerializer()), file2));
            if (arg0 > 0) {
            }
        }
    }

    public void executeAction(List widgets, String id) {
        Iterable iterable = ((Iterable) this.resolveList());
        int index = 0;
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            IdRecord8 idRecord8 = ((IdRecord8) element);
            int index2 = 0;
        }
        if (((IdRecord8) null) == null) {
        }
        IdRecord8 idRecord82 = new IdRecord8(id);
        Iterable iterable2 = ((Iterable) widgets);
        iterable = 0;
        index = iterable2;
        iterator = ((Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10)));
        element = 0;
        idRecord8 = index.iterator();
        while (idRecord8.hasNext()) {
            index2 = idRecord8.next();
            CheckRenderHelper checkRenderHelper = ((CheckRenderHelper) index2);
            Iterable iterable3 = ((Iterable) checkRenderHelper.getList());
            String text = checkRenderHelper.getString();
            Collection collection = ((Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable3, 10)));
            Iterator iterator2 = iterable3.iterator();
            while (iterator2.hasNext()) {
                Object element2 = iterator2.next();
                VisibleSettingProperty visibleSettingProperty = ((VisibleSettingProperty) element2);
                collection.add(new IdRecord10(visibleSettingProperty.getString(), visibleSettingProperty.toString()));
            }
            iterator.add(new IdRecord5(text, collection));
        }
        idRecord82.executeAction(iterator);
        this.resolveList().removeIf(this::checkCondition);
        this.resolveList().add(idRecord82);
    }

    private static boolean checkCondition(String arg0, IdRecord8 arg1) {
        return Intrinsics.areEqual(arg1.getString(), arg0);
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return ((Boolean) arg0.invoke(arg1));
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

    public static String[] process() {
        return textValueArray;
    }

}
