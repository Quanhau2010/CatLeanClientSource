package su.catlean.client.features.modules.render.esp;

import com.google.common.collect.Lists;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.class_1923;
import net.minecraft.class_2338.class_2339;
import net.minecraft.class_2672;
import net.minecraft.class_315;
import net.minecraft.class_4184;
import net.minecraft.class_7172;
import net.minecraft.class_757;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.AfterReceivePacket;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.render.Render3DEvent;
import su.catlean.api.event.events.world.BlockStateEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl3;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl6;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl9;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.BlocksServiceComponent;
import su.catlean.client.services.client.EntitiesServiceComponent;
import su.catlean.client.services.client.EventServiceComponent;
import su.catlean.client.services.client.ServiceComponent10;
import su.catlean.client.services.client.ServiceComponent53;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.TheNetherPacketHelper;
import su.catlean.client.services.render.ColorRenderHelper2;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.TextShaderComponent2;
import su.catlean.client.tools.comparators.Comparator17;
import su.catlean.client.tools.comparators.Comparator25;

public class SearchModule extends Module {

    public static final SearchModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl3 selectedBlocksSetting;
    private static final DefaultValueVisibleSettingPropertyImpl6 selectedEntitiesSetting;
    private static final VisibleVisibleSettingPropertyImpl limitSetting;
    private static final RangeVisibleSettingPropertyImpl limitCountSetting;
    private static final VisibleVisibleSettingPropertyImpl mapColorSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 colorSetting;
    private static final VisibleVisibleSettingPropertyImpl tracersSetting;
    private static final VisibleVisibleSettingPropertyImpl fillSetting;
    private static final VisibleVisibleSettingPropertyImpl outlineSetting;
    private static final ArrayList arrayList;
    private static final ExecutorService executorService;
    private static final ServiceComponent10 serviceComponent10;
    private static boolean enabledFlag;

    private SearchModule() {
        super("search", SubCategoriesKt.getEspCategory());
    }

    private BlocksServiceComponent getSelectedBlocks() {
        return ((BlocksServiceComponent) selectedBlocksSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private void setSelectedBlocks(BlocksServiceComponent value) {
        selectedBlocksSetting.setValue(this, DELEGATED_PROPERTIES[0], value);
    }

    private EntitiesServiceComponent getSelectedEntities() {
        return ((EntitiesServiceComponent) selectedEntitiesSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private void setSelectedEntities(EntitiesServiceComponent value) {
        selectedEntitiesSetting.setValue(this, DELEGATED_PROPERTIES[1], value);
    }

    private boolean getLimit() {
        return ((Boolean) limitSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private int getLimitCount() {
        return ((Number) limitCountSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private boolean getMapColor() {
        return ((Boolean) mapColorSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    private Color getColor() {
        return ((Color) colorSetting.getValue(this, DELEGATED_PROPERTIES[5]));
    }

    private boolean getTracers() {
        return ((Boolean) tracersSetting.getValue(this, DELEGATED_PROPERTIES[6]));
    }

    private boolean getFill() {
        return ((Boolean) fillSetting.getValue(this, DELEGATED_PROPERTIES[7]));
    }

    private boolean getOutline() {
        return ((Boolean) outlineSetting.getValue(this, DELEGATED_PROPERTIES[8]));
    }

    public void updateValue() {
        arrayList.clear();
        timestampValue = System.currentTimeMillis();
        enabledFlag = 1;
    }

    public void onPlayerUpdateEvent(PlayerUpdateEvent e) {
        executorService.submit(this::executeAction2);
    }

    public void onBlockStateEvent(BlockStateEvent e) {
        executorService.submit(this::onBlockStateEvent2);
    }

    public void onAfterReceivePacket(AfterReceivePacket e) {
        if (__UNDEF_KEY__ == null) {
        }
        class_2672 class2672 = ((class_2672) e.getPacket());
        executorService.submit(this::updateValue);
    }

    private void executeAction() {
        enabledFlag = 0;
        executorService.submit(this::executeAction3);
    }

    private List resolveList(class_1923 arg0) {
        List list = new ArrayList();
        class_2339 class2339 = new class_2339();
        int index = (arg0.field_9181 * 16);
        int index2 = (arg0.field_9180 * 16);
        int index3 = -64;
        if (index3 < 320) {
            int index4 = 0;
            if (index4 < 16) {
                int index5 = 0;
                if (index5 < 16) {
                    class2339.method_10103((index + index4), index3, (index2 + index5));
                    Block block = SharedKt.getWorld().getBlockState(((BlockPos) class2339)).getBlock();
                    if (__UNDEF_KEY__ == null) {
                        if (this.checkCondition(block)) {
                            if (this.getMapColor()) {
                            } else {
                            }
                            list.add(new ColorRenderHelper2(this.getColor()));
                        }
                    }
                }
            }
        }
        return list;
    }

    public void onRender3DEvent(Render3DEvent e) {
        if (arrayList.isEmpty() && this.getSelectedEntities().getList().isEmpty()) {
            return;
        }
        int index = 0;
        if (EventServiceComponent.INSTANCE.getNumericValue() < 8 && SharedKt.getPlayer().field_6012 > 100) {
            this.updateValue2();
            return;
        }
        if (!(this.getFill())) {
            if (this.getOutline()) {
                Iterable iterable = ((Iterable) CollectionsKt.filterNotNull(((Iterable) Lists.newArrayList(((Iterable) arrayList)))));
                int index2 = 0;
                Iterator iterator = CollectionsKt.sortedWith(iterable, ((Comparator) new Comparator25())).iterator();
                while (iterator.hasNext()) {
                    iterable = ((ServiceComponent53) iterator.next());
                    Iterable iterable2 = ((Iterable) iterable.getList());
                    int index3 = 0;
                    index2 = CollectionsKt.sortedWith(iterable2, ((Comparator) new Comparator17())).iterator();
                    while (index2.hasNext()) {
                    }
                    iterable2 = ((ColorRenderHelper2) index2.next());
                    if (index > this.getLimitCount()) {
                    }
                    if (iterable2.getMinecraftObject().toCenterPos().method_1022(this.resolveMinecraftObject(SharedKt.getPlayer())) > ((((Number) SharedKt.getMc().options.method_42503().method_41753()) + 4) * 16)) {
                    }
                    index3 = new Box(iterable2.getMinecraftObject());
                    if (this.getMapColor()) {
                    } else {
                    }
                    Color color = this.getColor();
                    if (this.getFill()) {
                        TextShaderComponent2.checkCondition(index3, color);
                    }
                    if (this.getOutline()) {
                        TextShaderComponent2.checkCondition(index3, PolygonShaderComponent.INSTANCE.resolveColor(color, (color.getAlpha() * 2.0F)));
                    }
                    if (this.getTracers()) {
                        Vec3d vec = new Vec3d(0.0D, 0.0D, 75.0D).method_1037(Math.toRadians(SharedKt.getMc().field_1773.method_19418().method_19329())).method_1024(Math.toRadians(SharedKt.getMc().field_1773.method_19418().method_19330())).method_1019(SharedKt.getMc().field_1773.method_19418().method_71156());
                        TextShaderComponent2.checkCondition(vec, iterable2.getMinecraftObject().toCenterPos(), color, null, true);
                    }
                }
                iterable = SharedKt.getWorld().method_18112();
                index2 = 0;
                iterable2 = iterable;
                index3 = ((Collection) new ArrayList());
                color = 0;
                vec = iterable2.iterator();
                while (vec.hasNext()) {
                    Object element = vec.next();
                    index3.add(element);
                }
                iterator = index3.iterator();
                while (iterator.hasNext()) {
                    iterable = iterator.next();
                    if (Intrinsics.areEqual(iterable, SharedKt.getPlayer())) {
                    }
                    index2 = TextShaderComponent2.INSTANCE.resolveMinecraftObject(iterable);
                    if (this.getFill()) {
                        TextShaderComponent2.checkCondition(index2, this.getColor());
                    }
                    if (this.getOutline()) {
                        TextShaderComponent2.checkCondition(index2, PolygonShaderComponent.INSTANCE.resolveColor(this.getColor(), (this.getColor().getAlpha() * 2.0F)));
                    }
                    iterable2 = new Vec3d(0.0D, 0.0D, 75.0D).method_1037(Math.toRadians(SharedKt.getMc().field_1773.method_19418().method_19329())).method_1024(Math.toRadians(SharedKt.getMc().field_1773.method_19418().method_19330())).method_1019(SharedKt.getMc().field_1773.method_19418().method_71156());
                    TextShaderComponent2.checkCondition(iterable2, index2.method_1005(), this.getColor(), null, true);
                }
            }
        }
        timestampValue = System.currentTimeMillis();
    }

    private boolean checkCondition(Block arg0) {
        return this.getSelectedBlocks().getList().contains(arg0);
    }

    private static boolean isActive() {
        return INSTANCE.getLimit();
    }

    private static boolean isActive2() {
        return !(INSTANCE.getMapColor());
    }

    private static void executeAction2() {
        INSTANCE.executeAction();
    }

    private static void onBlockStateEvent2(BlockStateEvent arg0) {
        int index = (arg0.getPos().method_10263() >> 4);
        int index2 = (arg0.getPos().method_10260() >> 4);
        Iterable iterable = ((Iterable) arrayList);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            ServiceComponent53 serviceComponent53 = ((ServiceComponent53) element);
        }
        if (((ServiceComponent53) null) != null) {
            ((ServiceComponent53) null).updateValue(true);
        } else {
        }
        index = arrayList;
    }

    private static void updateValue(class_2672 arg0) {
        Iterable iterable = ((Iterable) arrayList);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            ServiceComponent53 serviceComponent53 = ((ServiceComponent53) element);
        }
        if (((ServiceComponent53) null) != null) {
            ((ServiceComponent53) null).updateValue(true);
        } else {
        }
        iterable = arrayList;
    }

    private static boolean checkCondition(int arg0, int arg1, ServiceComponent53 arg2) {
        return Math.hypot((arg0 - arg2.getNumericValue()), (arg1 - arg2.getNumericValue2())) > ((((Number) SharedKt.getMc().options.method_42503().method_41753()) + 4) * 16);
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return ((Boolean) arg0.invoke(arg1));
    }

    private static void executeAction3() {
        boolean flag = serviceComponent10.checkCondition2(1500);
        Iterator iterator = TheNetherPacketHelper.INSTANCE.resolveList2().iterator();
        while (iterator.hasNext()) {
            class_1923 class1923 = ((class_1923) iterator.next());
            Iterable iterable = ((Iterable) arrayList);
            int index = 0;
            Iterator iterator2 = iterable.iterator();
            while (iterator2.hasNext()) {
                Object element = iterator2.next();
                ServiceComponent53 serviceComponent53 = ((ServiceComponent53) element);
            }
            if (flag) {
                if (((ServiceComponent53) null).getList().isEmpty()) {
                    arrayList.remove();
                } else {
                    if (element != null) {
                        if (!(this.isActive())) {
                        }
                    }
                }
            } else {
            }
            iterable = INSTANCE.resolveList(class1923);
            if (this.isActive()) {
                arrayList.remove();
            }
            arrayList.add(new ServiceComponent53(class1923.field_9181, class1923.field_9180, iterable, false));
            index = (SharedKt.getPlayer().getX() >> 4);
            iterator2 = (SharedKt.getPlayer().getZ() >> 4);
            arrayList.removeIf(this::checkCondition);
        }
        enabledFlag = 1;
        flag = arrayList;
    }

    static {
        KProperty[] items = new KProperty[9];
        INSTANCE = new SearchModule();
        int index = 12;
        BlocksServiceComponent blocksServiceComponent = new BlocksServiceComponent();
        selectedBlocksSetting = VisibleRenderHelper.registerSetting(INSTANCE, "blocks", blocksServiceComponent, index);
        index = 12;
        blocksServiceComponent = new EntitiesServiceComponent();
        selectedEntitiesSetting = VisibleRenderHelper.registerSetting(INSTANCE, "entities", blocksServiceComponent, index);
        limitSetting = VisibleRenderHelper.registerSetting(INSTANCE, "limit", true);
        limitCountSetting = VisibleRenderHelper.registerSetting(INSTANCE, "limit-count", 50, new IntRange(1, 2048), null, this::isActive);
        mapColorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "map-color", false);
        colorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "color", new Color(170, 0, 0, 120), null, this::isActive2);
        tracersSetting = VisibleRenderHelper.registerSetting(INSTANCE, "tracers", false);
        fillSetting = VisibleRenderHelper.registerSetting(INSTANCE, "fill", true);
        outlineSetting = VisibleRenderHelper.registerSetting(INSTANCE, "outline", true);
        arrayList = new ArrayList();
        executorService = Executors.newSingleThreadExecutor();
        serviceComponent10 = new ServiceComponent10();
    }

}
