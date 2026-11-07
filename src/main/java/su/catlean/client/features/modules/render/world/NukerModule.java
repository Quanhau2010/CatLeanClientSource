package su.catlean.client.features.modules.render.world;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.class_1934;
import net.minecraft.class_239.class_240;
import net.minecraft.class_2846;
import net.minecraft.class_2846.class_2847;
import net.minecraft.class_3532;
import net.minecraft.class_3959;
import net.minecraft.class_3959.class_242;
import net.minecraft.class_3959.class_3960;
import net.minecraft.class_3965;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.AttackBlockEvent;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.render.Render3DEvent;
import su.catlean.api.event.events.world.BlockStateEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl3;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.utility.player.SpeedMineMode;
import su.catlean.client.features.modules.utility.player.SpeedMineModule;
import su.catlean.client.services.client.BlocksServiceComponent;
import su.catlean.client.services.client.MoveFixServiceComponent;
import su.catlean.client.services.client.RotationServiceComponent4;
import su.catlean.client.services.client.SequenceServiceComponent;
import su.catlean.client.services.client.ServiceComponent10;
import su.catlean.client.services.client.ServiceComponent28;
import su.catlean.client.services.client.Vec3dServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.network.PacketPacketHelper;
import su.catlean.client.services.network.VecPacketHelper;
import su.catlean.client.services.render.NewThemeRenderHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.TextShaderComponent2;
import su.catlean.client.tools.comparators.Comparator15;
import su.catlean.client.tools.comparators.Comparator7;
import su.catlean.client.types.mappings.NukerFilterModeWhenMappings;

public class NukerModule extends Module {

    public static final NukerModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 filterSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 sortSetting;
    private static final DefaultValueVisibleSettingPropertyImpl3 selectedBlocksSetting;
    private static final RangeVisibleSettingPropertyImpl delaySetting;
    private static final RangeVisibleSettingPropertyImpl2 rangeSetting;
    private static final RangeVisibleSettingPropertyImpl yawAngleSetting;
    private static final VisibleVisibleSettingPropertyImpl ignoreWallsSetting;
    private static final VisibleVisibleSettingPropertyImpl flattenSetting;
    private static final VisibleVisibleSettingPropertyImpl creativeSetting;
    private static final VisibleVisibleSettingPropertyImpl avoidLavaSetting;
    private static Block minecraftRef;
    private static Vec3dServiceComponent vec3dServiceComponent;
    private static final ServiceComponent10 serviceComponent10;
    private static boolean enabledFlag;
    private static String textValue;

    private NukerModule() {
        super("nuker", SubCategoriesKt.getWorldRenderCategory());
    }

    private NukerFilterMode getFilter() {
        return ((NukerFilterMode) filterSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private NukerSortMode getSort() {
        return ((NukerSortMode) sortSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private BlocksServiceComponent getSelectedBlocks() {
        return ((BlocksServiceComponent) selectedBlocksSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private void setSelectedBlocks(BlocksServiceComponent value) {
        selectedBlocksSetting.setValue(this, DELEGATED_PROPERTIES[2], value);
    }

    private int getDelay() {
        return ((Number) delaySetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private float getRange() {
        return ((Number) rangeSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    private int getYawAngle() {
        return ((Number) yawAngleSetting.getValue(this, DELEGATED_PROPERTIES[5]));
    }

    private boolean getIgnoreWalls() {
        return ((Boolean) ignoreWallsSetting.getValue(this, DELEGATED_PROPERTIES[6]));
    }

    private boolean getFlatten() {
        return ((Boolean) flattenSetting.getValue(this, DELEGATED_PROPERTIES[7]));
    }

    private boolean getCreative() {
        return ((Boolean) creativeSetting.getValue(this, DELEGATED_PROPERTIES[8]));
    }

    private boolean getAvoidLava() {
        return ((Boolean) avoidLavaSetting.getValue(this, DELEGATED_PROPERTIES[9]));
    }

    public void onAttackBlockEvent(AttackBlockEvent e) {
        if (SharedKt.getWorld().method_22347(e.getPos())) {
            return;
        }
        Block block = SharedKt.getWorld().getBlockState(e.getPos()).getBlock();
        minecraftRef = block;
    }

    public void onBlockStateEvent(BlockStateEvent e) {
        if (vec3dServiceComponent != null) {
        } else {
            vec3dServiceComponent.getMinecraftObject();
        }
        vec3dServiceComponent = null;
        this.updateValue();
    }

    public void onPlayerUpdateEvent(PlayerUpdateEvent e) {
        this.updateValue();
        if (vec3dServiceComponent != null) {
            Block block = SharedKt.getWorld().getBlockState(vec3dServiceComponent.getMinecraftObject()).getBlock();
            if (!(Intrinsics.areEqual(block, minecraftRef))) {
            }
            if (this.getFilter() != NukerFilterMode.Select && EventPacketHelper2.INSTANCE.computeValue(vec3dServiceComponent.getMinecraftObject().toCenterPos()) <= (this.getRange() * this.getRange())) {
                if (Intrinsics.areEqual(block, Blocks.AIR)) {
                    vec3dServiceComponent = null;
                    this.updateValue();
                }
            }
        }
        if (SharedKt.getMc().options.field_1886.method_1434() || vec3dServiceComponent == null) {
            return;
        }
        block = vec3dServiceComponent.getMinecraftObject();
        if (!(this.getCreative())) {
            double offset = class_3532.method_15338(((Math.toDegrees(Math.atan2((block.field_1350 - SharedKt.getPlayer().getZ()), (block.field_1352 - SharedKt.getPlayer().getX()))) - 90.0F) - EventPacketHelper2.INSTANCE.computeValue()));
            double offset2 = (Math.toDegrees(Math.atan2((block.field_1351 - SharedKt.getPlayer().getEyePos().field_1351), Math.sqrt((Math.pow((block.field_1352 - SharedKt.getPlayer().getX()), 2.0D) + Math.pow((block.field_1350 - SharedKt.getPlayer().getZ()), 2.0D))))) - EventPacketHelper2.INSTANCE.computeValue2());
            float factor = class_3532.method_15363(class_3532.method_15379(offset), this.getYawAngle(), this.getYawAngle());
            float factor2 = class_3532.method_15363(offset2, this.getYawAngle(), this.getYawAngle());
            enabledFlag = class_3532.method_15379(offset) <= this.getYawAngle();
            if (offset > 0.0D) {
            } else {
            }
            float factor3 = (factor + factor);
            float factor4 = class_3532.method_15363((EventPacketHelper2.INSTANCE.computeValue2() + factor2), -90.0F, 90.0F);
            SequenceServiceComponent.INSTANCE.executeAction(new RotationServiceComponent4(0, this::getUnit));
        }
        if (this.getCreative() && serviceComponent10.checkCondition2(this.getDelay())) {
            offset = (Math.floor(this.getRange()) + 1);
            List list = new ArrayList();
            offset2 = BlockPos.ofFloored(this.resolveMinecraftObject(SharedKt.getPlayer()));
            factor = offset;
            if (factor <= offset) {
                factor2 = offset;
                if (factor2 <= offset) {
                    factor3 = offset;
                    list.add(offset2.method_10069(factor, factor2, factor3));
                    if (factor3 <= offset && factor3 != offset) {
                    }
                    if (factor2 != offset) {
                    }
                }
                if (factor != offset) {
                }
            }
            factor2 = ((Iterable) list);
            factor3 = 0;
            factor = CollectionsKt.sortedWith(factor2, ((Comparator) new Comparator7())).iterator();
            while (factor.hasNext()) {
                factor2 = ((BlockPos) factor.next());
                if (this.getFlatten()) {
                }
                if (this.getAvoidLava()) {
                }
                factor3 = SharedKt.getWorld().getBlockState(factor2);
                Block block2 = factor3.getBlock();
                PacketPacketHelper.executeAction(this::resolveMinecraftObject);
                PacketPacketHelper.executeAction(this::resolveMinecraftObject2);
                SharedKt.getWorld().method_8501(factor2, Blocks.AIR.method_9564());
                SharedKt.getPlayer().method_6104(Hand.field_5808);
            }
        }
        this.executeAction();
    }

    public void executeAction(char arg0, short arg1, int arg2) {
        if (vec3dServiceComponent == null || arg0 >= 0) {
            return;
        }
        if (SharedKt.getMc().options.field_1886.method_1434()) {
            if (arg0 >= 0) {
                if (__UNDEF_KEY__ == null) {
                    if (SpeedMineModule.INSTANCE.getMode() != SpeedMineMode.DAMAGE) {
                        if (arg2 >= 0 && arg1 >= 0) {
                            if (!(SpeedMineModule.INSTANCE.checkCondition2())) {
                                SpeedMineModule.INSTANCE.executeAction(vec3dServiceComponent.getMinecraftObject(), vec3dServiceComponent.getMinecraftObject());
                                return;
                            }
                        }
                    }
                }
            }
        }
        if (SharedKt.getInteractionManager().method_2920() == class_1934.field_9220) {
        } else {
        }
        SharedKt.getInteractionManager().method_2902(vec3dServiceComponent.getMinecraftObject(), vec3dServiceComponent.getMinecraftObject());
        SharedKt.getPlayer().method_6104(Hand.field_5808);
    }

    public void onRender3DEvent(Render3DEvent event) {
        if (!(this.getCreative()) && vec3dServiceComponent != null) {
            BlockPos blockPos = vec3dServiceComponent.getMinecraftObject();
        }
        int index = 4;
        Color color = PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor2(), 1.0F);
        Box box = new Box(blockPos);
        TextShaderComponent2.checkCondition(box, color, index);
        TextShaderComponent2.checkCondition(new Box(blockPos), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor2(), 0.5F));
    }

    private Vec3dServiceComponent resolveVec3dServiceComponent(short arg0, short arg1, int arg2) {
        double offset = (Math.floor(this.getRange()) + 1);
        List list = new ArrayList();
        BlockPos blockPos = BlockPos.ofFloored(this.resolveMinecraftObject(SharedKt.getPlayer()));
        double offset2 = offset;
        if (offset2 <= offset) {
            double offset3 = offset;
            if (arg1 > 0) {
                if (offset3 <= offset) {
                    double offset4 = offset;
                    list.add(blockPos.method_10069(offset2, offset3, offset4));
                    if (offset4 <= offset && offset4 != offset && arg0 >= 0) {
                    }
                    if (arg2 < 0) {
                        if (offset3 != offset) {
                        }
                    }
                }
            }
            if (offset2 != offset) {
            }
        }
        offset3 = ((Iterable) list);
        offset4 = 0;
        offset2 = CollectionsKt.sortedWith(offset3, ((Comparator) new Comparator15())).iterator();
        while (offset2.hasNext()) {
            offset3 = ((BlockPos) offset2.next());
            if (SpeedMineModule.INSTANCE.getEnabled()) {
                if (arg0 >= 0 && __UNDEF_KEY__ == null) {
                }
            }
            if (this.getFlatten()) {
                if (arg2 <= 0) {
                    if (__UNDEF_KEY__ == null) {
                    }
                }
            }
            if (arg1 > 0) {
                if (__UNDEF_KEY__ == null) {
                }
            }
            if (arg2 <= 0 && __UNDEF_KEY__ == null) {
                if (this.getAvoidLava()) {
                }
            }
            offset4 = SharedKt.getWorld().getBlockState(offset3);
            Block block = offset4.getBlock();
            if (arg1 >= 0 && __UNDEF_KEY__ == null) {
            }
            if (this.getIgnoreWalls()) {
                class_3965 class3965 = VecPacketHelper.resolveMinecraftObject(new class_3959(SharedKt.getPlayer().getEyePos(), offset3.toCenterPos(), class_3960.field_17558, class_242.field_1348, SharedKt.getPlayer()), offset3);
                return new Vec3dServiceComponent(offset3, class3965.method_17784(), class3965.method_17780());
            }
            class3965 = 0;
            int index = 0;
            if (index < 5) {
                int index2 = 0;
                if (index2 < 5) {
                    float factor = 0.25F;
                    Vec3d vec = new Vec3d((offset3.method_10263() + (class3965 * factor)), (offset3.method_10264() + (index * factor)), (offset3.method_10260() + (index2 * factor)));
                    class_3965 class39652 = SharedKt.getWorld().method_17742(new class_3959(SharedKt.getPlayer().getEyePos(), vec, class_3960.field_17559, class_242.field_1348, SharedKt.getPlayer()));
                    if (class39652.method_17783() == class_240.field_1332 && Intrinsics.areEqual(class39652.method_17777(), offset3)) {
                        return new Vec3dServiceComponent(offset3, vec, class39652.method_17780());
                    }
                }
            }
        }
        return null;
    }

    private boolean checkCondition(int arg0, BlockPos arg1) {
        Iterator iterator = ServiceComponent28.enumEntries.iterator();
        while (iterator.hasNext()) {
            Direction direction = ((Direction) iterator.next());
            return true;
        }
        return false;
    }

    private void updateValue() {
        if (minecraftRef == null) {
        }
        vec3dServiceComponent = this.resolveVec3dServiceComponent();
    }

    private boolean checkCondition(short arg0, char arg1, Block arg2, int arg3) {
        boolean flag = this.getSelectedBlocks().getList().contains(arg2);
        if (!(Intrinsics.areEqual(arg2, Blocks.field_9987)) && !(Intrinsics.areEqual(arg2, Blocks.AIR)) && !(Intrinsics.areEqual(arg2, Blocks.field_10543)) && !(arg2 instanceof FluidBlock)) {
        } else {
            if (arg0 >= 0) {
                if (__UNDEF_KEY__ == null) {
                }
            }
            if (arg1 > 0) {
                if (__UNDEF_KEY__ == null) {
                }
            }
            if (arg3 > 0) {
                if (__UNDEF_KEY__ == null) {
                }
            }
            if (arg3 >= 0) {
                if (__UNDEF_KEY__ == null) {
                }
            }
        }
        return !(arg2 instanceof FluidBlock);
    }

    private static Unit getUnit() {
        return Unit.INSTANCE;
    }

    private static Packet resolveMinecraftObject(BlockPos arg0, int arg1) {
        return ((Packet) new class_2846(class_2847.field_12968, arg0, Direction.UP, arg1));
    }

    private static Packet resolveMinecraftObject2(BlockPos arg0, int arg1) {
        return ((Packet) new class_2846(class_2847.field_12973, arg0, Direction.UP, arg1));
    }

    public static NukerSortMode resolveNukerSortMode(NukerModule $this) {
        return $this.getSort();
    }

    static {
        KProperty[] items = new KProperty[10];
        INSTANCE = new NukerModule();
        filterSetting = VisibleRenderHelper.registerSetting(INSTANCE, "filter", NukerFilterMode.Select);
        sortSetting = VisibleRenderHelper.registerSetting(INSTANCE, "sort", NukerSortMode.FOV);
        int index = 12;
        BlocksServiceComponent blocksServiceComponent = new BlocksServiceComponent();
        selectedBlocksSetting = VisibleRenderHelper.registerSetting(INSTANCE, "blocks", blocksServiceComponent, index);
        delaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "delay", 25, new IntRange(0, 1000));
        rangeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "range", 4.2F, RangesKt.rangeTo(3.0F, 7.0F));
        yawAngleSetting = VisibleRenderHelper.registerSetting(INSTANCE, "degrees-per-tick", 35, new IntRange(5, 180));
        ignoreWallsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "ignore-walls", false);
        flattenSetting = VisibleRenderHelper.registerSetting(INSTANCE, "flatten", false);
        creativeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "creative", false);
        avoidLavaSetting = VisibleRenderHelper.registerSetting(INSTANCE, "avoid-lava", false);
        serviceComponent10 = new ServiceComponent10();
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
