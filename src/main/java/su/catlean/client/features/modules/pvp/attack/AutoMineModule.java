package su.catlean.client.features.modules.pvp.attack;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.class_1922;
import net.minecraft.class_2586;
import net.minecraft.class_2611;
import net.minecraft.class_2627;
import net.minecraft.class_4050;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.render.Render3DEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl2;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl7;
import su.catlean.api.setting.SettingGroup;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.utility.player.SpeedMineModule;
import su.catlean.client.features.modules.utility.player.SpeedMineRebreakMode;
import su.catlean.client.services.client.BlockPosServiceComponent;
import su.catlean.client.services.client.ServiceComponent13;
import su.catlean.client.services.client.ServiceComponent36;
import su.catlean.client.services.client.ServiceComponent38;
import su.catlean.client.services.client.config.models.KeyRecord;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EntityPacketHelper;
import su.catlean.client.services.network.ReasonPacketHelper;
import su.catlean.client.services.network.TheNetherPacketHelper;
import su.catlean.client.services.render.NewThemeRenderHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.TextShaderComponent2;
import su.catlean.client.tools.comparators.Comparator;
import su.catlean.client.types.OptionMode14;

public class AutoMineModule extends Module {

    public static final AutoMineModule INSTANCE;
    private static final VisibleVisibleSettingPropertyImpl cevPrioritySetting;
    private static final VisibleVisibleSettingPropertyImpl antiShulkerSetting;
    private static final VisibleVisibleSettingPropertyImpl eChestMineSetting;
    private static final VisibleVisibleSettingPropertyImpl debugSetting;
    private static final VisibleVisibleSettingPropertyImpl antiCrawlSetting;
    private static final DefaultValueVisibleSettingPropertyImpl2 levelDownSetting;
    private static final VisibleVisibleSettingPropertyImpl cevCrawlersSetting;
    private static final VisibleVisibleSettingPropertyImpl holdPositionSetting;
    private static final DefaultValueVisibleSettingPropertyImpl7 holdGroupSetting;
    private static final VisibleVisibleSettingPropertyImpl holdCivSetting;
    private static final VisibleVisibleSettingPropertyImpl holdCevSetting;
    private static final VisibleVisibleSettingPropertyImpl holdSurrSetting;
    private static final ServiceComponent38 serviceComponent38;
    private static List itemList;

    private AutoMineModule() {
        super("auto-mine", SubCategoriesKt.getAttackCategory());
    }

    private boolean getCevPriority() {
        return (Boolean) cevPrioritySetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private boolean getAntiShulker() {
        return (Boolean) antiShulkerSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private boolean getEChestMine() {
        return (Boolean) eChestMineSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private boolean getDebug() {
        return (Boolean) debugSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private boolean getAntiCrawl() {
        return (Boolean) antiCrawlSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    private KeyRecord getLevelDown() {
        return (KeyRecord) levelDownSetting.getValue(this, DELEGATED_PROPERTIES[5]);
    }

    private boolean getCevCrawlers() {
        return (Boolean) cevCrawlersSetting.getValue(this, DELEGATED_PROPERTIES[6]);
    }

    private boolean getHoldPosition() {
        return (Boolean) holdPositionSetting.getValue(this, DELEGATED_PROPERTIES[7]);
    }

    private SettingGroup getHoldGroup() {
        return (SettingGroup) holdGroupSetting.getValue(this, DELEGATED_PROPERTIES[8]);
    }

    private boolean getHoldCiv() {
        return (Boolean) holdCivSetting.getValue(this, DELEGATED_PROPERTIES[9]);
    }

    private boolean getHoldCev() {
        return (Boolean) holdCevSetting.getValue(this, DELEGATED_PROPERTIES[10]);
    }

    private boolean getHoldSurr() {
        return (Boolean) holdSurrSetting.getValue(this, DELEGATED_PROPERTIES[11]);
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        itemList.clear();
        BlockPos blockPos = BlockPos.ofFloored(this.resolveMinecraftObject(SharedKt.getPlayer()));
        if (this.getAntiCrawl() && this.checkCondition()) {
            return;
        }
        if (this.getEChestMine() && this.checkCondition()) {
            return;
        }
        if (ServiceComponent13.checkCondition(this.getLevelDown().getNumericValue())) {
            this.executeAction(blockPos.down(), 1);
            return;
        }
        if (AutoCrystalModule.INSTANCE.getTarget() == null) {
        } else {
        }
        PlayerEntity player = AutoCrystalModule.INSTANCE.getTarget();
        if (player == null || !(serviceComponent38.checkCondition(60))) {
            return;
        }
        if (this.getAntiShulker() && this.checkCondition(player)) {
            return;
        }
        Entity entity = player;
        BlockPos blockPos2 = BlockPos.ofFloored(this.resolveMinecraftObject(entity));
        List positions = new ArrayList();
        List positions2 = new ArrayList();
        Box var67 = player.method_5829();
        positions2.add(BlockPos.method_49637((var67.field_1323 + 0.001D), var67.field_1322, (var67.field_1321 + 0.001D)));
        positions2.add(BlockPos.method_49637((var67.field_1323 + 0.001D), var67.field_1322, (var67.field_1324 - 0.001D)));
        positions2.add(BlockPos.method_49637((var67.field_1320 - 0.001D), var67.field_1322, (var67.field_1324 - 0.001D)));
        positions2.add(BlockPos.method_49637((var67.field_1320 - 0.001D), var67.field_1322, (var67.field_1321 + 0.001D)));
        Iterator iterator = positions2.iterator();
        while (iterator.hasNext()) {
            BlockPos blockPos3 = (BlockPos) iterator.next();
            if (SharedKt.getPlayer().getEyePos().method_1022(blockPos3.toCenterPos()) > SharedKt.getPlayer().method_55754() || Intrinsics.areEqual(blockPos3, blockPos)) {
                continue;
            }
            BlockState state = this.resolveMinecraftObject(blockPos3);
            if (!(Intrinsics.areEqual(state.getBlock(), Blocks.OBSIDIAN))) {
            }
            positions.add(blockPos3);
        }
        iterator = this.resolveMinecraftObject(blockPos2);
        blockPos3 = new ArrayList();
        state = 0;
        if (!(Intrinsics.areEqual(iterator.getBlock(), Blocks.field_9987))) {
            entity = positions2;
            if (this.checkCondition(player, entity)) {
                return;
            }
            int var55 = 8;
            int var56 = 0;
            List positions3 = blockPos3;
            Object var58 = positions2;
            Object var59 = player;
            Object var60 = this;
            executeAction(positions3, entity);
            int var73 = 0;
            Object var74 = var72;
            Collection var75 = (Collection) new ArrayList();
            int var76 = 0;
            Iterator iterator2 = var74.iterator();
            while (iterator2.hasNext()) {
                Object var78 = iterator2.next();
                Direction var79 = (Direction) var78;
                int var80 = 0;
                var75.add();
            }
            Iterator iterator3 = var75.iterator();
            while (iterator3.hasNext()) {
                var73 = 0.0F;
                var74 = blockPos2.offset();
                var75 = this.resolveMinecraftObject();
                if (Intrinsics.areEqual(var75.getBlock(), Blocks.AIR)) {
                }
                if (!(Intrinsics.areEqual(var75.getBlock(), Blocks.OBSIDIAN))) {
                }
                if (!(Intrinsics.areEqual(var75.getBlock(), Blocks.ENDER_CHEST)) || var74.toCenterPos().method_1022(SharedKt.getPlayer().getEyePos()) > SharedKt.getPlayer().method_55754() || Intrinsics.areEqual(blockPos)) {
                    continue;
                }
                var76 = this.resolveMinecraftObject(var74.down());
                if (!(Intrinsics.areEqual(var76.getBlock(), Blocks.OBSIDIAN))) {
                    if (Intrinsics.areEqual(var76.getBlock(), Blocks.field_9987)) {
                    }
                    var73 = (var73 + 6.0F);
                }
                iterator2 = 1;
                if (iterator2 < 3) {
                    var78 = this.resolveMinecraftObject(var74.down().method_10079(iterator2));
                    var79 = this.resolveMinecraftObject(var74.method_10079(iterator2));
                    if (!(Intrinsics.areEqual(var78.getBlock(), Blocks.OBSIDIAN))) {
                        if (Intrinsics.areEqual(var78.getBlock(), Blocks.field_9987)) {
                        }
                        if (var79.method_26215()) {
                            var73 = (var73 + 7.5F);
                        }
                    }
                }
                var78 = (Iterable) ServiceComponent36.enumEntries;
                var79 = 0;
                var80 = var78;
                Collection var81 = (Collection) new ArrayList();
                int var82 = 0;
                Iterator iterator4 = var80.iterator();
                while (iterator4.hasNext()) {
                    Object var84 = iterator4.next();
                    Direction var85 = (Direction) var84;
                    int var86 = 0;
                    if (var85 != Direction.DOWN) {
                        if (var85 != Direction.UP) {
                        }
                    } else {
                    }
                }
                var81.add();
            }
            iterator2 = var81.iterator();
            while (iterator2.hasNext()) {
                var78 = (Direction) iterator2.next();
                var79 = var74.offset().offset();
                var80 = this.resolveMinecraftObject();
                var81 = this.resolveMinecraftObject(var79.down());
                var82 = this.resolveMinecraftObject(var74.offset());
                if (Intrinsics.areEqual(var82.getBlock(), Blocks.OBSIDIAN) || Intrinsics.areEqual(var82.getBlock(), Blocks.field_9987)) {
                    continue;
                }
                if (!(Intrinsics.areEqual(var81.getBlock(), Blocks.OBSIDIAN))) {
                }
                var73 = (var73 + 9.0F);
            }
            var78 = (Iterable) ServiceComponent36.enumEntries;
            var79 = 0;
            var80 = var78;
            var81 = (Collection) new ArrayList();
            var82 = 0;
            iterator4 = var80.iterator();
            while (iterator4.hasNext()) {
                var84 = iterator4.next();
                var85 = (Direction) var84;
                var86 = 0;
                var81.add();
            }
            iterator2 = var81.iterator();
            while (iterator2.hasNext()) {
                var78 = (Direction) iterator2.next();
                var79 = var74.offset();
                if (Intrinsics.areEqual(blockPos2) || Intrinsics.areEqual(blockPos) || var79.toCenterPos().method_1022(SharedKt.getPlayer().getEyePos()) > SharedKt.getPlayer().method_55754()) {
                    continue;
                }
                var80 = this.resolveMinecraftObject();
                if (var80.method_26215()) {
                    var81 = this.resolveMinecraftObject(var79.down());
                    var82 = this.resolveMinecraftObject(var79.method_10087(2));
                    if (!(Intrinsics.areEqual(var81.getBlock(), Blocks.OBSIDIAN))) {
                    }
                    if (!(Intrinsics.areEqual(var82.getBlock(), Blocks.OBSIDIAN))) {
                        if (Intrinsics.areEqual(var82.getBlock(), Blocks.field_9987)) {
                        }
                    } else {
                    }
                    var73 = (10.0F + 9.0F);
                }
                if (!(Intrinsics.areEqual(var80.getBlock(), Blocks.OBSIDIAN))) {
                }
                var81 = 1;
                iterator4 = (Iterable) ServiceComponent36.enumEntries;
                var84 = 0;
                var85 = iterator4;
                var86 = (Collection) new ArrayList();
                int var87 = 0;
                Iterator iterator5 = var85.iterator();
                while (iterator5.hasNext()) {
                    Object var89 = iterator5.next();
                    Direction var90 = (Direction) var89;
                    int var91 = 0;
                    var86.add();
                }
                var82 = var86.iterator();
                while (var82.hasNext()) {
                }
                iterator4 = (Direction) var82.next();
                var84 = var79.offset(iterator4);
                if (Intrinsics.areEqual(blockPos2) || Intrinsics.areEqual() || Intrinsics.areEqual() || Intrinsics.areEqual(blockPos) || var84.toCenterPos().method_1022(SharedKt.getPlayer().getEyePos()) > SharedKt.getPlayer().method_55754()) {
                    continue;
                }
                var85 = this.resolveMinecraftObject(var84.down());
                if (!(Intrinsics.areEqual(var85.getBlock(), Blocks.OBSIDIAN))) {
                }
                var73 = (var73 + 1.0F);
                var87 = new Direction[4];
                var87[0] = Direction.WEST;
                var87[1] = Direction.NORTH;
                var87[2] = Direction.EAST;
                var87[3] = Direction.SOUTH;
                var86 = CollectionsKt.mutableListOf();
                var86.remove(var78.method_10153());
                if (var78 == Direction.UP) {
                } else {
                    var87 = (Iterable) var86;
                    float var98 = 11.0F;
                    Object var97 = var79;
                    iterator5 = 0;
                    var89 = var87.iterator();
                    if (var89.hasNext()) {
                        var90 = var89.next();
                        var91 = (Direction) var90;
                        int var92 = 0;
                        BlockPos blockPos4 = var79.down().offset();
                        BlockState state2 = INSTANCE.resolveMinecraftObject(blockPos4);
                        BlockPos blockPos5 = var79.offset();
                        BlockState state3 = INSTANCE.resolveMinecraftObject(blockPos5);
                        if (!(Intrinsics.areEqual(state2.getBlock(), Blocks.OBSIDIAN))) {
                            if (Intrinsics.areEqual(state2.getBlock(), Blocks.field_9987)) {
                            }
                        } else {
                        }
                    } else {
                    }
                }
                float var100 = 11.0F;
                float var101 = 16.0F;
                var98.add(new BlockPosServiceComponent());
                var81 = 0;
            }
            blockPos3.add(new BlockPosServiceComponent());
        }
        }
        if (state > 1) {
            blockPos3.clear();
        }
        iterator3 = positions.iterator();
        while (iterator3.hasNext()) {
            blockPos3.add(new BlockPosServiceComponent(300.0F));
        }
        itemList = blockPos3;
        if (SpeedMineModule.INSTANCE.getEnabled()) {
            if (SpeedMineModule.INSTANCE.getDoubleMine()) {
                var73 = 0;
                if (var72 instanceof Collection) {
                    if ((Collection) var72.isEmpty()) {
                    }
                } else {
                    var74 = var72.iterator();
                    if (var74.hasNext()) {
                        var75 = var74.next();
                        var76 = (BlockPosServiceComponent) var75;
                        iterator2 = 0;
                    } else {
                    }
                }
            }
            iterator3 = 0;
            if (iterator3) {
                var73 = (Iterable) blockPos3;
                var74 = 0;
                var75 = var73;
                var76 = (Collection) new ArrayList();
                iterator2 = 0;
                var78 = var75.iterator();
                while (var78.hasNext()) {
                    var79 = var78.next();
                    var80 = (BlockPosServiceComponent) var79;
                    var81 = 0;
                    var76.add();
                }
                var73 = (Iterable) var76;
                var74 = 0;
                var75 = var73.iterator();
                if (!(var75.hasNext())) {
                } else {
                    var76 = var75.next();
                    if (!(var75.hasNext())) {
                    } else {
                        iterator2 = (BlockPosServiceComponent) var76;
                        var78 = 0;
                        iterator2 = iterator2.getNumericValue();
                        var78 = var75.next();
                        var79 = (BlockPosServiceComponent) var78;
                        var80 = 0;
                        var79 = var79.getNumericValue();
                        if (Float.compare(iterator2) < 0) {
                            var76 = var78;
                            iterator2 = var79;
                        }
                    }
                }
            } else {
                var73 = (Iterable) blockPos3;
                var74 = 0;
                var75 = var73.iterator();
                if (!(var75.hasNext())) {
                } else {
                    var76 = var75.next();
                    if (!(var75.hasNext())) {
                    } else {
                        iterator2 = (BlockPosServiceComponent) var76;
                        var78 = 0;
                        iterator2 = iterator2.getNumericValue();
                        var78 = var75.next();
                        var79 = (BlockPosServiceComponent) var78;
                        var80 = 0;
                        var79 = var79.getNumericValue();
                        if (Float.compare(iterator2) < 0) {
                            var76 = var78;
                            iterator2 = var79;
                        }
                    }
                }
            }
            var74 = (Iterable) blockPos3;
            var75 = 0;
            var76 = var74;
            iterator2 = (Collection) new ArrayList();
            var78 = 0;
            var79 = var76.iterator();
            while (var79.hasNext()) {
                var80 = var79.next();
                var81 = (BlockPosServiceComponent) var80;
                var82 = 0;
                if ((BlockPosServiceComponent) var76 != null) {
                } else {
                }
                iterator2.add();
            }
            var74 = (Iterable) iterator2;
            var75 = 0;
            var76 = var74.iterator();
            if (!(var76.hasNext())) {
            } else {
                iterator2 = var76.next();
                if (!(var76.hasNext())) {
                } else {
                    var78 = (BlockPosServiceComponent) iterator2;
                    var79 = 0;
                    var78 = var78.getNumericValue();
                    var79 = var76.next();
                    var80 = (BlockPosServiceComponent) var79;
                    var81 = 0;
                    var80 = var80.getNumericValue();
                    if (Float.compare() < 0) {
                        iterator2 = var79;
                        var78 = var80;
                    }
                }
            }
            var73 = (BlockPosServiceComponent) iterator2;
            return;
            if (SpeedMineModule.INSTANCE.checkCondition(var72.getMinecraftObject())) {
                if (var73 == null) {
                }
            }
            var74 = var72;
            this.executeAction(var74.getMinecraftObject(), 0);
        }
        } else {
            var73 = 0;
            var74 = var72.iterator();
            if (!(var74.hasNext())) {
            } else {
                var75 = var74.next();
                if (!(var74.hasNext())) {
                } else {
                    var76 = (BlockPosServiceComponent) var75;
                    iterator2 = 0;
                    var76 = var76.getNumericValue();
                    iterator2 = var74.next();
                    var78 = (BlockPosServiceComponent) iterator2;
                    var79 = 0;
                    var78 = var78.getNumericValue();
                    if (Float.compare() < 0) {
                        var75 = iterator2;
                        var76 = var78;
                    }
                }
            }
            if ((BlockPosServiceComponent) var75 != null) {
                var73 = (BlockPosServiceComponent) var75;
                var74 = 0;
                INSTANCE.executeAction(var73.getMinecraftObject(), 0);
            } else {
            }
        }
        }
    }

    private void executeAction(PlayerEntity arg0, List arg1, List arg2, boolean arg3) {
        if (arg0.method_20448()) {
        }
        Iterable var24 = (Iterable) arg1;
        int var25 = 0;
        Iterator iterator = CollectionsKt.sortedWith((java.util.Comparator) new Comparator(arg0)).iterator();
        while (iterator.hasNext()) {
            var24 = (BlockPos) iterator.next();
            var25 = var24.method_10086(2);
            int var26 = 0;
            BlockPos blockPos = var25.method_10086();
            if (!(arg3)) {
                if (SharedKt.getPlayer().getEyePos().method_1022(blockPos.toCenterPos()) <= SharedKt.getPlayer().method_55754() && Intrinsics.areEqual(this.resolveMinecraftObject(blockPos).getBlock(), Blocks.OBSIDIAN)) {
                }
                boolean var28 = this.resolveMinecraftObject(blockPos.up()).method_26215();
                if (!(var28) && var26 == 3) {
                }
                float var31 = 99.0F;
                float var32 = 100.0F;
                if (this.getCevPriority()) {
                } else {
                }
                var31.<init>(0.5F);
            }
        }
    }

    private static void executeAction(AutoMineModule arg0, PlayerEntity arg1, List arg2, List arg3, boolean arg4, int arg5, Object arg6) {
        if ((arg5 & 8)) {
            arg4 = 0;
        }
        arg0.executeAction(arg1, arg2, arg3, arg4);
    }

    private BlockState resolveMinecraftObject(BlockPos arg0) {
        return SharedKt.getWorld().getBlockState(arg0);
    }

    private boolean checkCondition(PlayerEntity arg0, int arg1, List arg2, char arg3, int arg4) {
        if (arg4 > 0) {
            if (this.getHoldPosition() && SpeedMineModule.INSTANCE.getEnabled()) {
                if (SpeedMineModule.INSTANCE.getRebreak() == SpeedMineRebreakMode.OFF) {
                }
            }
            return false;
        }
        Iterable var30 = (Iterable) SpeedMineModule.INSTANCE.getLinkedList();
        int var31 = 0;
        Iterator iterator = var30.iterator();
        if (iterator.hasNext()) {
            Object var33 = iterator.next();
            ReasonPacketHelper var34 = (ReasonPacketHelper) var33;
            int var35 = 0;
            if (!(SharedKt.getWorld().method_22347(var34.getMinecraftObject()))) {
                if (var34.getNumericValue() > 0) {
                }
            } else {
            }
        } else {
        }
        if ((ReasonPacketHelper) null != null) {
            if ((ReasonPacketHelper) null.getMinecraftObject() == null) {
            }
            return false;
        }
        Object var28 = var33;
        if (this.getHoldCev()) {
            List positions = new ArrayList();
            this.executeAction(arg0, arg2, positions, 1);
            var30 = (Iterable) positions;
            if (arg3 > 0) {
                var31 = 0;
            }
            if (var30 instanceof Collection && (Collection) var30.isEmpty()) {
            } else {
                iterator = var30.iterator();
                if (iterator.hasNext()) {
                    var33 = iterator.next();
                    var34 = (BlockPosServiceComponent) var33;
                    var35 = 0;
                } else {
                }
            }
            if (arg4 > 0) {
                if (0) {
                }
                return true;
            }
        }
        positions = arg2.iterator();
        if (positions.hasNext()) {
            var30 = (BlockPos) positions.next();
            iterator = (Iterable) ServiceComponent36.enumEntries;
            var33 = 0;
            var34 = iterator;
            var35 = (Collection) new ArrayList();
            int var36 = 0;
            Iterator iterator2 = var34.iterator();
            while (iterator2.hasNext()) {
                Object var38 = iterator2.next();
                Direction var39 = (Direction) var38;
                int var40 = 0;
                if (arg1 > 0) {
                    if (var39 != Direction.UP) {
                    }
                } else {
                }
                var35.add();
            }
            var31 = var35.iterator();
            while (var31.hasNext()) {
            }
            iterator = (Direction) var31.next();
            var33 = var30.offset(iterator);
            if (arg1 >= 0) {
                if (arg1 >= 0) {
                    if (var27 == null) {
                        if (arg2.contains()) {
                        }
                    }
                }
                if (arg3 >= 0) {
                    if (var27 == null) {
                        if (this.getHoldSurr()) {
                            if (!(Intrinsics.areEqual())) {
                            }
                        }
                    }
                    if (arg4 >= 0) {
                        if (var27 == null) {
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        Iterator iterator = itemList.iterator();
        while (iterator.hasNext()) {
            BlockPosServiceComponent var22 = (BlockPosServiceComponent) iterator.next();
            int var23 = 360;
            if (var23 >= 180) {
            } else {
            }
            Color var24 = PolygonShaderComponent.INSTANCE.resolveColor(PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor2(), 0.5F), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor2(), 0.0F), (var23 / 360.0F));
            int var16 = 4;
            Object var18 = var24;
            Box var19 = new Box(var22.getMinecraftObject());
            TextShaderComponent2.checkCondition();
            TextShaderComponent2.executeAction(String.valueOf(var22.getNumericValue()), var22.getMinecraftObject().toCenterPos(), 0.0F, 0.0F);
        }
    }

    private boolean checkCondition(int arg0) {
        BlockPos blockPos = BlockPos.ofFloored(this.resolveMinecraftObject(SharedKt.getPlayer()));
        if (SharedKt.getPlayer().method_18376() == class_4050.field_18079 && !(SharedKt.getPlayer().method_5799()) && !(SharedKt.getPlayer().method_5869())) {
            BlockPos blockPos2 = blockPos.up();
            BlockState state = SharedKt.getWorld().getBlockState(blockPos2);
            BlockPos blockPos3 = blockPos.down();
            BlockState state2 = SharedKt.getWorld().getBlockState(blockPos3);
            if (arg0 >= 0) {
                if (var15 == null) {
                    if (!(Intrinsics.areEqual(state.getBlock(), Blocks.field_9987)) && state.method_26214((class_1922) SharedKt.getWorld(), blockPos2) > 0.0F && !(Intrinsics.areEqual(state.getBlock(), Blocks.AIR)) && !(Intrinsics.areEqual(state.getBlock(), Blocks.field_10543)) && !(state.method_45474())) {
                        this.executeAction(blockPos2, 1);
                        return true;
                    }
                }
            }
            if (!(Intrinsics.areEqual(state2.getBlock(), Blocks.field_9987)) && state2.method_26214((class_1922) SharedKt.getWorld(), blockPos3) > 0.0F && !(Intrinsics.areEqual(state2.getBlock(), Blocks.AIR)) && !(Intrinsics.areEqual(state2.getBlock(), Blocks.field_10543)) && !(state2.method_45474())) {
                this.executeAction(blockPos3, 1);
                return true;
            }
        }
        return false;
    }

    private boolean checkCondition(int arg0) {
        Iterator iterator = TheNetherPacketHelper.INSTANCE.getList().iterator();
        if (iterator.hasNext()) {
            class_2586 var12 = (class_2586) iterator.next();
            if (arg0 > 0) {
                if (var10 == null) {
                }
                if (SharedKt.getPlayer().getEyePos().method_1022(var12.method_11016().toCenterPos()) <= 2.2D) {
                    if (!(var12 instanceof class_2611)) {
                    }
                }
                this.executeAction((class_2611) var12.method_11016(), 0);
            }
        }
        return false;
    }

    private boolean checkCondition(PlayerEntity arg0) {
        Iterator iterator = TheNetherPacketHelper.INSTANCE.getList().iterator();
        if (iterator.hasNext()) {
            class_2586 var8 = (class_2586) iterator.next();
            if (var6 == null) {
                if (var6 == null) {
                    if (arg0.getEyePos().method_1022(var8.method_11016().toCenterPos()) <= 2.2D) {
                    }
                    if (!(var8 instanceof class_2627)) {
                    }
                }
                this.executeAction((class_2627) var8.method_11016(), 1);
            }
        }
        return false;
    }

    private void executeAction(BlockPos arg0, boolean arg1) {
        if (SpeedMineModule.INSTANCE.checkCondition2() && !(arg1)) {
            return;
        }
        if (SpeedMineModule.INSTANCE.getEnabled()) {
            if (SpeedMineModule.INSTANCE.getDoubleMine()) {
                if (SpeedMineModule.INSTANCE.getLinkedList().size() == 1) {
                }
                this.updateValue();
            }
            SpeedMineModule.INSTANCE.executeAction(arg0, Direction.UP);
        } else {
            SharedKt.getInteractionManager().method_2902(arg0, Direction.UP);
            SharedKt.getPlayer().method_6104(Hand.field_5808);
        }
    }

    public void updateValue() {
        serviceComponent38.updateValue();
    }

    private static boolean isActive() {
        return INSTANCE.getHoldPosition();
    }

    private static boolean isActive2() {
        return INSTANCE.getHoldPosition();
    }

    private static boolean isActive3() {
        return INSTANCE.getHoldPosition();
    }

    private static boolean isActive4() {
        return INSTANCE.getHoldPosition();
    }

    static {
        KProperty[] var39 = new KProperty[12];
        INSTANCE = new AutoMineModule();
        cevPrioritySetting = VisibleRenderHelper.registerSetting(INSTANCE, "cev-priority");
        antiShulkerSetting = VisibleRenderHelper.registerSetting(INSTANCE, "anti-shulker");
        eChestMineSetting = VisibleRenderHelper.registerSetting(INSTANCE, "e-chests-mine");
        debugSetting = VisibleRenderHelper.registerSetting(INSTANCE, "debug");
        antiCrawlSetting = VisibleRenderHelper.registerSetting(INSTANCE, "anti-crawl");
        levelDownSetting = VisibleRenderHelper.registerSetting(INSTANCE, "level-down", new KeyRecord());
        cevCrawlersSetting = VisibleRenderHelper.registerSetting(INSTANCE, "cev-crawlers");
        holdPositionSetting = VisibleRenderHelper.registerSetting(INSTANCE, "sync-with-rebreak");
        holdGroupSetting = VisibleRenderHelper.resolveDefaultValueVisibleSettingPropertyImpl7(INSTANCE, "hold-selection", OptionMode14.BOOLS, this::isActive);
        holdCivSetting = VisibleRenderHelper.resolveVisibleVisibleSettingPropertyImpl(INSTANCE, "hold-civ", 1, INSTANCE.getHoldGroup(), this::isActive2);
        holdCevSetting = VisibleRenderHelper.resolveVisibleVisibleSettingPropertyImpl(INSTANCE, "hold-cev", 1, INSTANCE.getHoldGroup(), this::isActive3);
        holdSurrSetting = VisibleRenderHelper.resolveVisibleVisibleSettingPropertyImpl(INSTANCE, "hold-surr", 1, INSTANCE.getHoldGroup(), this::isActive4);
        serviceComponent38 = new ServiceComponent38();
        itemList = new ArrayList();
    }

}
