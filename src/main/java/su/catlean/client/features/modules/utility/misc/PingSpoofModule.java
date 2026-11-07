package su.catlean.client.features.modules.utility.misc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
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
        return (Number) delaySetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private void onReceivePacket(ReceivePacket arg0) {
        if (!(arg0.getPacket() instanceof class_6373)) {
        }
        arg0.cancel();
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        Iterable var12 = (Iterable) concurrentHashMap.entrySet();
        int var13 = 0;
        Object var14 = var12;
        Collection var15 = (Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(10));
        int var16 = 0;
        Iterator iterator = var14.iterator();
        if (iterator.hasNext()) {
            Object var18 = iterator.next();
            Entry var19 = (Entry) var18;
            if (var10 != null) {
                Object var22 = var15;
                int var20 = 0;
                Object var21 = var19;
                var22.add(new Pair(var21.getKey(), var21.getValue()));
            }
        }
        List positions = var15;
        var12 = (Iterable) positions;
        var13 = 0;
        var14 = var12.iterator();
        if (var14.hasNext()) {
            var15 = var14.next();
            var16 = (Pair) var15;
            iterator = 0;
            var18 = (Packet) var16.component1();
            var19 = (Long) var16.component2();
            if (var10 != null) {
                if ((SharedKt.getNumericValue() - var19.longValue()) >= INSTANCE.getDelay()) {
                    var20 = var18;
                    if (var10 != null) {
                        if (var20 instanceof class_6373) {
                            (class_6373) var18.method_36949((class_8705) SharedKt.getNetwork());
                        }
                        if (var10 != null) {
                        }
                        if (var10 == null && var20 instanceof class_2670) {
                            (class_2670) var18.method_11518((class_8705) SharedKt.getNetwork());
                        }
                    }
                    concurrentHashMap.remove();
                    MessageServiceComponent.S(INSTANCE, ("Error processing packet: " + var21.getMessage()));
                }
            }
        }
    }

    static {
        KProperty[] var27 = new KProperty[1];
        INSTANCE = new PingSpoofModule();
        delaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "delay", 100, new IntRange(1, 29500));
        concurrentHashMap = new ConcurrentHashMap();
    }

}
