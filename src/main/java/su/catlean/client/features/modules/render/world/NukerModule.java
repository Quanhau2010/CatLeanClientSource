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
        return (NukerFilterMode) filterSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private NukerSortMode getSort() {
        return (NukerSortMode) sortSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private BlocksServiceComponent getSelectedBlocks() {
        return (BlocksServiceComponent) selectedBlocksSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private void setSelectedBlocks(BlocksServiceComponent value) {
        selectedBlocksSetting.setValue(this, DELEGATED_PROPERTIES[2], value);
    }

    private int getDelay() {
        return (Number) delaySetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private float getRange() {
        return (Number) rangeSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    private int getYawAngle() {
        return (Number) yawAngleSetting.getValue(this, DELEGATED_PROPERTIES[5]);
    }

    private boolean getIgnoreWalls() {
        return (Boolean) ignoreWallsSetting.getValue(this, DELEGATED_PROPERTIES[6]);
    }

    private boolean getFlatten() {
        return (Boolean) flattenSetting.getValue(this, DELEGATED_PROPERTIES[7]);
    }

    private boolean getCreative() {
        return (Boolean) creativeSetting.getValue(this, DELEGATED_PROPERTIES[8]);
    }

    private boolean getAvoidLava() {
        return (Boolean) avoidLavaSetting.getValue(this, DELEGATED_PROPERTIES[9]);
    }

    public void onAttackBlockEvent(AttackBlockEvent e) {
        if (SharedKt.getWorld().method_22347(e.getPos())) {
            return;
        }
        Block var9 = SharedKt.getWorld().getBlockState(e.getPos()).getBlock();
        minecraftRef = var9;
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
            Block var57 = SharedKt.getWorld().getBlockState(vec3dServiceComponent.getMinecraftObject()).getBlock();
            if (!(Intrinsics.areEqual(minecraftRef))) {
            }
            if (this.getFilter() != NukerFilterMode.Select && EventPacketHelper2.INSTANCE.computeValue(vec3dServiceComponent.getMinecraftObject().toCenterPos()) <= (this.getRange() * this.getRange())) {
                if (Intrinsics.areEqual(Blocks.AIR)) {
                }
                vec3dServiceComponent = null;
                this.updateValue();
            }
        }
        if (SharedKt.getMc().options.field_1886.method_1434() || vec3dServiceComponent == null) {
            return;
        }
        var57 = vec3dServiceComponent.getMinecraftObject();
        if (!(this.getCreative())) {
            double var58 = class_3532.method_15338(((Math.toDegrees(Math.atan2((var57.field_1350 - SharedKt.getPlayer().getZ()), (var57.field_1352 - SharedKt.getPlayer().getX()))) - 90.0F) - EventPacketHelper2.INSTANCE.computeValue()));
            double var60 = (Math.toDegrees(Math.atan2((var57.field_1351 - SharedKt.getPlayer().getEyePos().field_1351), Math.sqrt((Math.pow((var57.field_1352 - SharedKt.getPlayer().getX()), 2.0D) + Math.pow((var57.field_1350 - SharedKt.getPlayer().getZ()), 2.0D))))) - EventPacketHelper2.INSTANCE.computeValue2());
            float var61 = class_3532.method_15363(class_3532.method_15379(), this.getYawAngle(), this.getYawAngle());
            float var62 = class_3532.method_15363(this.getYawAngle(), this.getYawAngle());
            enabledFlag = class_3532.method_15379() <= this.getYawAngle();
            if (var58 > 0.0D) {
            } else {
            }
            float var63 = (var61 + var61);
            float var64 = class_3532.method_15363((EventPacketHelper2.INSTANCE.computeValue2() + var62), -90.0F, 90.0F);
            SequenceServiceComponent.INSTANCE.executeAction(new RotationServiceComponent4(new MoveFixServiceComponent(), 0, this::getUnit));
        }
        if (this.getCreative() && serviceComponent10.checkCondition2(this.getDelay())) {
            var58 = (Math.floor(this.getRange()) + 1);
            List positions = new ArrayList();
            var60 = BlockPos.ofFloored(this.resolveMinecraftObject(SharedKt.getPlayer()));
            var61 = var58;
            if (var61 <= var58) {
                var62 = var58;
                if (var62 <= var58) {
                    var63 = var58;
                    positions.add(var60.method_10069());
                    if (var63 <= var58 && var63 != var58) {
                    }
                    if (var62 != var58) {
                    }
                }
                if (var61 != var58) {
                }
            }
            var62 = (Iterable) positions;
            var63 = 0;
            var61 = CollectionsKt.sortedWith((Comparator) new Comparator7()).iterator();
            while (var61.hasNext()) {
                var62 = (BlockPos) var61.next();
                if (this.getFlatten()) {
                }
                if (this.getAvoidLava()) {
                }
                var63 = SharedKt.getWorld().getBlockState();
                Block var55 = var63.getBlock();
                PacketPacketHelper.executeAction(this::resolveMinecraftObject);
                PacketPacketHelper.executeAction(this::resolveMinecraftObject2);
                SharedKt.getWorld().method_8501(Blocks.AIR.method_9564());
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
                if (var22 == null) {
                    if (SpeedMineModule.INSTANCE.getMode() != SpeedMineMode.DAMAGE) {
                    }
                }
                if (arg2 >= 0 && arg1 >= 0) {
                    if (!(SpeedMineModule.INSTANCE.checkCondition2())) {
                        SpeedMineModule.INSTANCE.executeAction(vec3dServiceComponent.getMinecraftObject(), vec3dServiceComponent.getMinecraftObject());
                        return;
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
        int var14 = 4;
        Color var16 = PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor2(), 1.0F);
        Box var17 = new Box(blockPos);
        TextShaderComponent2.checkCondition();
        TextShaderComponent2.checkCondition(new Box(blockPos), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor2(), 0.5F));
    }

    private Vec3dServiceComponent resolveVec3dServiceComponent(short arg0, short arg1, int arg2) {
        double var40 = (Math.floor(this.getRange()) + 1);
        List positions = new ArrayList();
        BlockPos blockPos = BlockPos.ofFloored(this.resolveMinecraftObject(SharedKt.getPlayer()));
        int var43 = var40;
        if (var43 <= var40) {
            int var44 = var40;
            if (arg1 > 0) {
                if (var44 <= var40) {
                }
                int var45 = var40;
                positions.add(blockPos.method_10069());
                if (var45 <= var40 && var45 != var40 && arg0 >= 0) {
                }
                if (arg2 < 0) {
                    if (var44 != var40) {
                    }
                }
            }
            if (var43 != var40) {
            }
        }
        var44 = (Iterable) positions;
        var45 = 0;
        var43 = CollectionsKt.sortedWith((Comparator) new Comparator15()).iterator();
        if (var43.hasNext()) {
            var44 = (BlockPos) var43.next();
            if (SpeedMineModule.INSTANCE.getEnabled()) {
                if (arg0 >= 0 && var39 == null) {
                }
            }
            if (this.getFlatten()) {
                if (arg2 <= 0) {
                    if (var39 == null) {
                    }
                }
            }
            if (arg1 > 0) {
                if (var39 == null) {
                }
            }
            if (arg2 <= 0 && var39 == null) {
                if (this.getAvoidLava()) {
                }
            }
            var45 = SharedKt.getWorld().getBlockState();
            Block var38 = var45.getBlock();
            if (arg1 >= 0 && var39 == null) {
            }
            if (this.getIgnoreWalls()) {
                class_3965 var46 = VecPacketHelper.resolveMinecraftObject(new class_3959(SharedKt.getPlayer().getEyePos(), var44.toCenterPos(), class_3960.field_17558, class_242.field_1348, SharedKt.getPlayer()));
                return new Vec3dServiceComponent(var46.method_17784(), var46.method_17780());
            }
            var46 = 0;
            int var47 = 0;
            if (var47 < 5) {
                int var48 = 0;
                if (var48 < 5) {
                    float var49 = 0.25F;
                    Vec3d vec = new Vec3d((var44.method_10263() + (var46 * var49)), (var44.method_10264() + (var47 * var49)), (var44.method_10260() + (var48 * var49)));
                    class_3965 var51 = SharedKt.getWorld().method_17742(new class_3959(SharedKt.getPlayer().getEyePos(), vec, class_3960.field_17559, class_242.field_1348, SharedKt.getPlayer()));
                    if (var51.method_17783() == class_240.field_1332 && Intrinsics.areEqual(var51.method_17777())) {
                        return new Vec3dServiceComponent(vec, var51.method_17780());
                    }
                }
            }
        }
        return null;
    }

    private boolean checkCondition(int arg0, BlockPos arg1) {
        Iterator iterator = ServiceComponent28.enumEntries.iterator();
        if (iterator.hasNext()) {
            Direction var10 = (Direction) iterator.next();
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
        boolean var12 = this.getSelectedBlocks().getList().contains(arg2);
        if (!(Intrinsics.areEqual(arg2, Blocks.field_9987)) && !(Intrinsics.areEqual(arg2, Blocks.AIR)) && !(Intrinsics.areEqual(arg2, Blocks.field_10543)) && !(arg2 instanceof FluidBlock)) {
        } else {
            if (arg0 >= 0) {
                if (var11 == null) {
                }
            }
            if (arg1 > 0) {
                if (var11 == null) {
                }
            }
            if (arg3 > 0) {
                if (var11 == null) {
                }
            }
            if (arg3 >= 0) {
                if (var11 == null) {
                }
            }
        }
        return !(arg2 instanceof FluidBlock);
    }

    private static Unit getUnit() {
        return Unit.INSTANCE;
    }

    private static Packet resolveMinecraftObject(BlockPos arg0, int arg1) {
        return (Packet) new class_2846(class_2847.field_12968, arg0, Direction.UP, arg1);
    }

    private static Packet resolveMinecraftObject2(BlockPos arg0, int arg1) {
        return (Packet) new class_2846(class_2847.field_12973, arg0, Direction.UP, arg1);
    }

    public static NukerSortMode resolveNukerSortMode(NukerModule $this) {
        return $this.getSort();
    }

    static {
        KProperty[] var42 = new KProperty[10];
        INSTANCE = new NukerModule();
        filterSetting = VisibleRenderHelper.registerSetting(INSTANCE, "filter", NukerFilterMode.Select);
        sortSetting = VisibleRenderHelper.registerSetting(INSTANCE, "sort", NukerSortMode.FOV);
        int var38 = 12;
        BlocksServiceComponent var41 = new BlocksServiceComponent();
        selectedBlocksSetting = VisibleRenderHelper.registerSetting(INSTANCE, "blocks");
        delaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "delay", 25, new IntRange(0, 1000));
        rangeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "range", 4.2F, RangesKt.rangeTo(3.0F, 7.0F));
        yawAngleSetting = VisibleRenderHelper.registerSetting(INSTANCE, "degrees-per-tick", 35, new IntRange(5, 180));
        ignoreWallsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "ignore-walls");
        flattenSetting = VisibleRenderHelper.registerSetting(INSTANCE, "flatten");
        creativeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "creative");
        avoidLavaSetting = VisibleRenderHelper.registerSetting(INSTANCE, "avoid-lava");
        serviceComponent10 = new ServiceComponent10();
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
