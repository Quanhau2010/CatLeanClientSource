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
        return (BlocksServiceComponent) selectedBlocksSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private void setSelectedBlocks(BlocksServiceComponent value) {
        selectedBlocksSetting.setValue(this, DELEGATED_PROPERTIES[0], value);
    }

    private EntitiesServiceComponent getSelectedEntities() {
        return (EntitiesServiceComponent) selectedEntitiesSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private void setSelectedEntities(EntitiesServiceComponent value) {
        selectedEntitiesSetting.setValue(this, DELEGATED_PROPERTIES[1], value);
    }

    private boolean getLimit() {
        return (Boolean) limitSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private int getLimitCount() {
        return (Number) limitCountSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private boolean getMapColor() {
        return (Boolean) mapColorSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    private Color getColor() {
        return (Color) colorSetting.getValue(this, DELEGATED_PROPERTIES[5]);
    }

    private boolean getTracers() {
        return (Boolean) tracersSetting.getValue(this, DELEGATED_PROPERTIES[6]);
    }

    private boolean getFill() {
        return (Boolean) fillSetting.getValue(this, DELEGATED_PROPERTIES[7]);
    }

    private boolean getOutline() {
        return (Boolean) outlineSetting.getValue(this, DELEGATED_PROPERTIES[8]);
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
        if (var4 == null) {
        }
        class_2672 var5 = (class_2672) e.getPacket();
        executorService.submit(this::updateValue);
    }

    private void executeAction() {
        enabledFlag = 0;
        executorService.submit(this::executeAction3);
    }

    private List resolveList(class_1923 arg0) {
        List positions = new ArrayList();
        class_2339 var16 = new class_2339();
        int var17 = (arg0.field_9181 * 16);
        int var18 = (arg0.field_9180 * 16);
        int var19 = -64;
        if (var19 < 320) {
            int var20 = 0;
            if (var20 < 16) {
                int var21 = 0;
                if (var21 < 16) {
                    var16.method_10103((var17 + var20), (var18 + var21));
                    Block var22 = SharedKt.getWorld().getBlockState((BlockPos) var16).getBlock();
                    if (var14 == null) {
                        if (this.checkCondition()) {
                            if (this.getMapColor()) {
                            } else {
                            }
                            var16.method_10062().<init>(new Color(var22.method_26403().field_16011), this.getColor());
                        }
                    }
                }
            }
        }
        return positions;
    }

    public void onRender3DEvent(Render3DEvent e) {
        if (arrayList.isEmpty() && this.getSelectedEntities().getList().isEmpty()) {
            return;
        }
        int var46 = 0;
        if (EventServiceComponent.INSTANCE.getNumericValue() < 8 && SharedKt.getPlayer().field_6012 > 100) {
            this.updateValue2();
            return;
        }
        if (!(this.getFill())) {
            if (this.getOutline()) {
            }
            Iterable var48 = (Iterable) CollectionsKt.filterNotNull((Iterable) Lists.newArrayList((Iterable) arrayList));
            int var49 = 0;
            Iterator iterator = CollectionsKt.sortedWith((Comparator) new Comparator25()).iterator();
            if (iterator.hasNext()) {
                var48 = (ServiceComponent53) iterator.next();
                Iterable var50 = (Iterable) var48.getList();
                int var51 = 0;
                var49 = CollectionsKt.sortedWith((Comparator) new Comparator17()).iterator();
                while (var49.hasNext()) {
                }
                var50 = (ColorRenderHelper2) var49.next();
                if (var46 > this.getLimitCount()) {
                }
                if (var50.getMinecraftObject().toCenterPos().method_1022(this.resolveMinecraftObject(SharedKt.getPlayer())) > (((Number) SharedKt.getMc().options.method_42503().method_41753() + 4) * 16)) {
                }
                var51 = new Box(var50.getMinecraftObject());
                if (this.getMapColor()) {
                } else {
                }
                Color var52 = this.getColor();
                if (this.getFill()) {
                    TextShaderComponent2.checkCondition();
                }
                if (this.getOutline()) {
                    TextShaderComponent2.checkCondition(PolygonShaderComponent.INSTANCE.resolveColor((var52.getAlpha() * 2.0F)));
                }
                if (this.getTracers()) {
                    Vec3d vec = new Vec3d(0.0D, 0.0D, 75.0D).method_1037(Math.toRadians(SharedKt.getMc().field_1773.method_19418().method_19329())).method_1024(Math.toRadians(SharedKt.getMc().field_1773.method_19418().method_19330())).method_1019(SharedKt.getMc().field_1773.method_19418().method_71156());
                    TextShaderComponent2.checkCondition(vec, var50.getMinecraftObject().toCenterPos());
                }
            }
            var48 = SharedKt.getWorld().method_18112();
            var49 = 0;
            var50 = var48;
            var51 = (Collection) new ArrayList();
            var52 = 0;
            vec = var50.iterator();
            while (vec.hasNext()) {
                Object var54 = vec.next();
                Entity entity = var54;
                int var56 = 0;
                var51.add();
            }
            iterator = var51.iterator();
            while (iterator.hasNext()) {
                var48 = iterator.next();
                if (Intrinsics.areEqual(SharedKt.getPlayer())) {
                }
                var49 = TextShaderComponent2.INSTANCE.resolveMinecraftObject();
                if (this.getFill()) {
                    TextShaderComponent2.checkCondition(this.getColor());
                }
                if (this.getOutline()) {
                    TextShaderComponent2.checkCondition(PolygonShaderComponent.INSTANCE.resolveColor(this.getColor(), (this.getColor().getAlpha() * 2.0F)));
                }
                var50 = new Vec3d(0.0D, 0.0D, 75.0D).method_1037(Math.toRadians(SharedKt.getMc().field_1773.method_19418().method_19329())).method_1024(Math.toRadians(SharedKt.getMc().field_1773.method_19418().method_19330())).method_1019(SharedKt.getMc().field_1773.method_19418().method_71156());
                TextShaderComponent2.checkCondition(var49.method_1005(), this.getColor());
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
        List<BlockPos> positions = arrayList;
        int var5 = 0;
        int var6 = (arg0.getPos().method_10263() >> 4);
        int var7 = (arg0.getPos().method_10260() >> 4);
        Iterable var8 = (Iterable) arrayList;
        int var9 = 0;
        Iterator iterator = var8.iterator();
        if (iterator.hasNext()) {
            Object var11 = iterator.next();
            ServiceComponent53 var12 = (ServiceComponent53) var11;
            int var13 = 0;
        } else {
        }
        if ((ServiceComponent53) null != null) {
            (ServiceComponent53) null.updateValue(1);
        } else {
        }
        var5 = Unit.INSTANCE;
        var6 = positions;
    }

    private static void updateValue(class_2672 arg0) {
        List<BlockPos> positions = arrayList;
        int var5 = 0;
        Iterable var6 = (Iterable) arrayList;
        int var7 = 0;
        Iterator iterator = var6.iterator();
        if (iterator.hasNext()) {
            Object var9 = iterator.next();
            ServiceComponent53 var10 = (ServiceComponent53) var9;
            int var11 = 0;
        } else {
        }
        if ((ServiceComponent53) null != null) {
            (ServiceComponent53) null.updateValue(1);
        } else {
        }
        var5 = Unit.INSTANCE;
        var6 = positions;
    }

    private static boolean checkCondition(int arg0, int arg1, ServiceComponent53 arg2) {
        return Math.hypot((arg0 - arg2.getNumericValue()), (arg1 - arg2.getNumericValue2())) > (((Number) SharedKt.getMc().options.method_42503().method_41753() + 4) * 16);
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return (Boolean) arg0.invoke(arg1);
    }

    private static void executeAction3() {
        List<BlockPos> positions = arrayList;
        int var15 = 0;
        boolean var16 = serviceComponent10.checkCondition2(1500);
        Iterator iterator = TheNetherPacketHelper.INSTANCE.resolveList2().iterator();
        while (iterator.hasNext()) {
            class_1923 var18 = (class_1923) iterator.next();
            Iterable var19 = (Iterable) arrayList;
            int var20 = 0;
            Iterator iterator2 = var19.iterator();
            if (iterator2.hasNext()) {
                Object var22 = iterator2.next();
                ServiceComponent53 var23 = (ServiceComponent53) var22;
                int var24 = 0;
            } else {
            }
            if (var16) {
                if ((ServiceComponent53) null.getList().isEmpty()) {
                    arrayList.remove();
                }
            } else {
                if (var22 != null) {
                    if (!(var25.isActive())) {
                    }
                }
            }
        }
        var19 = INSTANCE.resolveList();
        if (var25.isActive()) {
            arrayList.remove();
        }
        arrayList.add(new ServiceComponent53(var18.field_9181, var18.field_9180));
        var20 = (SharedKt.getPlayer().getX() >> 4);
        iterator2 = (SharedKt.getPlayer().getZ() >> 4);
        arrayList.removeIf(this::checkCondition);
        }
        enabledFlag = 1;
        var15 = Unit.INSTANCE;
        var16 = positions;
    }

    static {
        KProperty[] var47 = new KProperty[9];
        INSTANCE = new SearchModule();
        int var43 = 12;
        BlocksServiceComponent var46 = new BlocksServiceComponent();
        selectedBlocksSetting = VisibleRenderHelper.registerSetting(INSTANCE, "blocks");
        var43 = 12;
        var46 = new EntitiesServiceComponent();
        selectedEntitiesSetting = VisibleRenderHelper.registerSetting(INSTANCE, "entities");
        limitSetting = VisibleRenderHelper.registerSetting(INSTANCE, "limit");
        limitCountSetting = VisibleRenderHelper.registerSetting(INSTANCE, "limit-count", 50, new IntRange(1, 2048), null, this::isActive);
        mapColorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "map-color");
        colorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "color", new Color(170, 0, 0, 120), null, this::isActive2);
        tracersSetting = VisibleRenderHelper.registerSetting(INSTANCE, "tracers");
        fillSetting = VisibleRenderHelper.registerSetting(INSTANCE, "fill");
        outlineSetting = VisibleRenderHelper.registerSetting(INSTANCE, "outline");
        arrayList = new ArrayList();
        executorService = Executors.newSingleThreadExecutor();
        serviceComponent10 = new ServiceComponent10();
    }

}
