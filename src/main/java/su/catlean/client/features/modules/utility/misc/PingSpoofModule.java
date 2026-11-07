package su.catlean.client.features.modules.utility.misc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import net.minecraft.class_2670;
import net.minecraft.class_6373;
import net.minecraft.class_8705;
import net.minecraft.network.packet.Packet;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.event.events.render.Render3DEvent;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.MessageServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.VisibleRenderHelper;

public class PingSpoofModule extends Module {

    public static final PingSpoofModule INSTANCE;
    private static final RangeVisibleSettingPropertyImpl delaySetting;
    private static final ConcurrentHashMap concurrentHashMap;

    private PingSpoofModule() {
        super("ping-spoof", SubCategoriesKt.getMiscUtilityCategory());
    }

    private int getDelay() {
        return ((Number) delaySetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private void onReceivePacket(ReceivePacket arg0) {
        if (!(arg0.getPacket() instanceof class_6373)) {
        }
        arg0.cancel();
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        Iterable iterable = ((Iterable) concurrentHashMap.entrySet());
        Iterable iterable2 = iterable;
        Collection collection = ((Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10)));
        int index = 0;
        Iterator iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            Entry entry = ((Entry) element);
            if (__UNDEF_KEY__ != null) {
                int index2 = 0;
                Entry entry2 = entry;
                collection.add(new Pair(entry2.getKey(), entry2.getValue()));
            }
        }
        iterable = ((Iterable) collection);
        iterable2 = iterable.iterator();
        while (iterable2.hasNext()) {
            collection = iterable2.next();
            index = ((Pair) collection);
            iterator = 0;
            element = ((Packet) index.component1());
            entry = ((Long) index.component2());
            if (__UNDEF_KEY__ != null) {
                if ((SharedKt.getNumericValue() - entry.longValue()) >= INSTANCE.getDelay()) {
                    index2 = element;
                    if (__UNDEF_KEY__ != null) {
                        if (index2 instanceof class_6373) {
                            ((class_6373) element).method_36949(((class_8705) SharedKt.getNetwork()));
                        }
                        if (__UNDEF_KEY__ != null) {
                            if (__UNDEF_KEY__ == null && index2 instanceof class_2670) {
                                ((class_2670) element).method_11518(((class_8705) SharedKt.getNetwork()));
                            }
                        }
                    }
                    concurrentHashMap.remove(element);
                    MessageServiceComponent.S(INSTANCE, ("Error processing packet: " + entry2.getMessage()), false);
                }
            }
        }
    }

    static {
        KProperty[] items = new KProperty[1];
        INSTANCE = new PingSpoofModule();
        delaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "delay", 100, new IntRange(1, 29500));
        concurrentHashMap = new ConcurrentHashMap();
    }

}
