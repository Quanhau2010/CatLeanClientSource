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
        return ((Boolean) cevPrioritySetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private boolean getAntiShulker() {
        return ((Boolean) antiShulkerSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private boolean getEChestMine() {
        return ((Boolean) eChestMineSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private boolean getDebug() {
        return ((Boolean) debugSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private boolean getAntiCrawl() {
        return ((Boolean) antiCrawlSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    private KeyRecord getLevelDown() {
        return ((KeyRecord) levelDownSetting.getValue(this, DELEGATED_PROPERTIES[5]));
    }

    private boolean getCevCrawlers() {
        return ((Boolean) cevCrawlersSetting.getValue(this, DELEGATED_PROPERTIES[6]));
    }

    private boolean getHoldPosition() {
        return ((Boolean) holdPositionSetting.getValue(this, DELEGATED_PROPERTIES[7]));
    }

    private SettingGroup getHoldGroup() {
        return ((SettingGroup) holdGroupSetting.getValue(this, DELEGATED_PROPERTIES[8]));
    }

    private boolean getHoldCiv() {
        return ((Boolean) holdCivSetting.getValue(this, DELEGATED_PROPERTIES[9]));
    }

    private boolean getHoldCev() {
        return ((Boolean) holdCevSetting.getValue(this, DELEGATED_PROPERTIES[10]));
    }

    private boolean getHoldSurr() {
        return ((Boolean) holdSurrSetting.getValue(this, DELEGATED_PROPERTIES[11]));
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
            this.executeAction(blockPos.down(), true);
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
        List list = new ArrayList();
        List list2 = new ArrayList();
        Box box = player.method_5829();
        list2.add(BlockPos.method_49637((box.field_1323 + 0.001D), box.field_1322, (box.field_1321 + 0.001D)));
        list2.add(BlockPos.method_49637((box.field_1323 + 0.001D), box.field_1322, (box.field_1324 - 0.001D)));
        list2.add(BlockPos.method_49637((box.field_1320 - 0.001D), box.field_1322, (box.field_1324 - 0.001D)));
        list2.add(BlockPos.method_49637((box.field_1320 - 0.001D), box.field_1322, (box.field_1321 + 0.001D)));
        Iterator iterator = list2.iterator();
        while (iterator.hasNext()) {
            BlockPos blockPos3 = ((BlockPos) iterator.next());
            if (SharedKt.getPlayer().getEyePos().method_1022(blockPos3.toCenterPos()) > SharedKt.getPlayer().method_55754() || Intrinsics.areEqual(blockPos3, blockPos)) {
                continue;
            }
            BlockState state = this.resolveMinecraftObject(blockPos3);
            if (!(Intrinsics.areEqual(state.getBlock(), Blocks.OBSIDIAN))) {
            }
            list.add(blockPos3);
        }
        iterator = this.resolveMinecraftObject(blockPos2);
        blockPos3 = new ArrayList();
        state = 0;
        if (!(Intrinsics.areEqual(iterator.getBlock(), Blocks.field_9987))) {
            entity = list2;
            if (this.checkCondition(player, entity)) {
                return;
            }
            int index = 8;
            int index2 = 0;
            executeAction(this, player, list2, blockPos3, index2, index, entity);
            int index3 = 0;
            Collection collection = ((Collection) new ArrayList());
            int index4 = 0;
            Iterator iterator2 = this.iterator();
            while (iterator2.hasNext()) {
                Object element = iterator2.next();
                Direction direction = ((Direction) element);
                int index5 = 0;
                collection.add(element);
            }
            Iterator iterator3 = collection.iterator();
            while (iterator3.hasNext()) {
                index3 = 0.0F;
                BlockPos blockPos4 = blockPos2.offset();
                collection = this.resolveMinecraftObject(blockPos4);
                if (Intrinsics.areEqual(collection.getBlock(), Blocks.AIR)) {
                }
                if (!(Intrinsics.areEqual(collection.getBlock(), Blocks.OBSIDIAN))) {
                }
                if (!(Intrinsics.areEqual(collection.getBlock(), Blocks.ENDER_CHEST)) || blockPos4.toCenterPos().method_1022(SharedKt.getPlayer().getEyePos()) > SharedKt.getPlayer().method_55754() || Intrinsics.areEqual(blockPos4, blockPos)) {
                    continue;
                }
                index4 = this.resolveMinecraftObject(blockPos4.down());
                if (!(Intrinsics.areEqual(index4.getBlock(), Blocks.OBSIDIAN))) {
                    if (Intrinsics.areEqual(index4.getBlock(), Blocks.field_9987)) {
                        index3 = (index3 + 6.0F);
                    }
                }
                iterator2 = 1;
                if (iterator2 < 3) {
                    element = this.resolveMinecraftObject(blockPos4.down().method_10079(iterator2));
                    direction = this.resolveMinecraftObject(blockPos4.method_10079(iterator2));
                    if (!(Intrinsics.areEqual(element.getBlock(), Blocks.OBSIDIAN))) {
                        if (Intrinsics.areEqual(element.getBlock(), Blocks.field_9987)) {
                            if (direction.method_26215()) {
                                index3 = (index3 + 7.5F);
                            }
                        }
                    }
                }
                element = ((Iterable) ServiceComponent36.enumEntries);
                direction = 0;
                index5 = element;
                Collection collection2 = ((Collection) new ArrayList());
                int index6 = 0;
                Iterator iterator4 = index5.iterator();
                while (iterator4.hasNext()) {
                    Object element2 = iterator4.next();
                    Direction direction2 = ((Direction) element2);
                    int index7 = 0;
                    if (direction2 != Direction.DOWN) {
                        if (direction2 != Direction.UP) {
                        } else {
                        }
                    } else {
                    }
                    collection2.add(element2);
                }
                iterator2 = collection2.iterator();
                while (iterator2.hasNext()) {
                    element = ((Direction) iterator2.next());
                    direction = blockPos4.offset().offset(element);
                    index5 = this.resolveMinecraftObject(direction);
                    collection2 = this.resolveMinecraftObject(direction.down());
                    index6 = this.resolveMinecraftObject(blockPos4.offset(element));
                    if (Intrinsics.areEqual(index6.getBlock(), Blocks.OBSIDIAN) || Intrinsics.areEqual(index6.getBlock(), Blocks.field_9987)) {
                        continue;
                    }
                    if (!(Intrinsics.areEqual(collection2.getBlock(), Blocks.OBSIDIAN))) {
                    }
                    index3 = (index3 + 9.0F);
                }
                element = ((Iterable) ServiceComponent36.enumEntries);
                direction = 0;
                index5 = element;
                collection2 = ((Collection) new ArrayList());
                index6 = 0;
                iterator4 = index5.iterator();
                while (iterator4.hasNext()) {
                    element2 = iterator4.next();
                    direction2 = ((Direction) element2);
                    index7 = 0;
                    collection2.add(element2);
                }
                iterator2 = collection2.iterator();
                while (iterator2.hasNext()) {
                    element = ((Direction) iterator2.next());
                    direction = blockPos4.offset(element);
                    if (Intrinsics.areEqual(direction, blockPos2) || Intrinsics.areEqual(direction, blockPos) || direction.toCenterPos().method_1022(SharedKt.getPlayer().getEyePos()) > SharedKt.getPlayer().method_55754()) {
                        continue;
                    }
                    index5 = this.resolveMinecraftObject(direction);
                    if (index5.method_26215()) {
                        collection2 = this.resolveMinecraftObject(direction.down());
                        index6 = this.resolveMinecraftObject(direction.method_10087(2));
                        if (!(Intrinsics.areEqual(collection2.getBlock(), Blocks.OBSIDIAN))) {
                        }
                        if (!(Intrinsics.areEqual(index6.getBlock(), Blocks.OBSIDIAN))) {
                            if (Intrinsics.areEqual(index6.getBlock(), Blocks.field_9987)) {
                            } else {
                            }
                        }
                        index3 = (10.0F + 9.0F);
                    }
                    if (!(Intrinsics.areEqual(index5.getBlock(), Blocks.OBSIDIAN))) {
                    }
                    collection2 = 1;
                    iterator4 = ((Iterable) ServiceComponent36.enumEntries);
                    element2 = 0;
                    direction2 = iterator4;
                    index7 = ((Collection) new ArrayList());
                    int index8 = 0;
                    Iterator iterator5 = direction2.iterator();
                    while (iterator5.hasNext()) {
                        Object element3 = iterator5.next();
                        Direction direction3 = ((Direction) element3);
                        int index9 = 0;
                        index7.add(element3);
                    }
                    index6 = index7.iterator();
                    while (index6.hasNext()) {
                    }
                    iterator4 = ((Direction) index6.next());
                    element2 = direction.offset(iterator4);
                    if (Intrinsics.areEqual(element2, blockPos2) || Intrinsics.areEqual(element2, direction) || Intrinsics.areEqual(element2, blockPos4) || Intrinsics.areEqual(element2, blockPos) || element2.toCenterPos().method_1022(SharedKt.getPlayer().getEyePos()) > SharedKt.getPlayer().method_55754()) {
                        continue;
                    }
                    direction2 = this.resolveMinecraftObject(element2.down());
                    if (!(Intrinsics.areEqual(direction2.getBlock(), Blocks.OBSIDIAN))) {
                    }
                    index3 = (index3 + 1.0F);
                    index8 = new Direction[4];
                    index8[0] = Direction.WEST;
                    index8[1] = Direction.NORTH;
                    index8[2] = Direction.EAST;
                    index8[3] = Direction.SOUTH;
                    index7 = CollectionsKt.mutableListOf(index8);
                    index7.remove(element.method_10153());
                    if (element == Direction.UP) {
                    } else {
                        index8 = ((Iterable) index7);
                        float factor = 11.0F;
                        iterator5 = 0;
                        element3 = index8.iterator();
                        while (element3.hasNext()) {
                            direction3 = element3.next();
                            index9 = ((Direction) direction3);
                            BlockPos blockPos5 = direction.down().offset(index9);
                            BlockState state2 = INSTANCE.resolveMinecraftObject(blockPos5);
                            BlockPos blockPos6 = direction.offset(index9);
                            BlockState state3 = INSTANCE.resolveMinecraftObject(blockPos6);
                            if (!(Intrinsics.areEqual(state2.getBlock(), Blocks.OBSIDIAN))) {
                                if (Intrinsics.areEqual(state2.getBlock(), Blocks.field_9987)) {
                                } else {
                                }
                            }
                        }
                    }
                    float factor2 = 11.0F;
                    float factor3 = 16.0F;
                    factor.add(new BlockPosServiceComponent(factor3, factor2));
                    collection2 = 0;
                }
                blockPos3.add(new BlockPosServiceComponent(blockPos4, index3));
            }
        }
        if (state > 1) {
            blockPos3.clear();
        }
        iterator3 = list.iterator();
        while (iterator3.hasNext()) {
            blockPos3.add(new BlockPosServiceComponent(300.0F));
        }
        itemList = blockPos3;
        if (SpeedMineModule.INSTANCE.getEnabled()) {
            if (SpeedMineModule.INSTANCE.getDoubleMine()) {
                index3 = 0;
                if (__UNDEF_KEY__ instanceof Collection) {
                    if (this.isEmpty()) {
                    } else {
                        blockPos4 = this.iterator();
                        while (blockPos4.hasNext()) {
                            collection = blockPos4.next();
                            index4 = ((BlockPosServiceComponent) collection);
                            iterator2 = 0;
                        }
                    }
                } else {
                }
                iterator3 = 0;
                if (iterator3) {
                    index3 = ((Iterable) blockPos3);
                    blockPos4 = 0;
                    collection = index3;
                    index4 = ((Collection) new ArrayList());
                    iterator2 = 0;
                    element = collection.iterator();
                    while (element.hasNext()) {
                        direction = element.next();
                        index5 = ((BlockPosServiceComponent) direction);
                        collection2 = 0;
                        index4.add(direction);
                    }
                    index3 = ((Iterable) index4);
                    blockPos4 = 0;
                    collection = index3.iterator();
                    if (!(collection.hasNext())) {
                    } else {
                        index4 = collection.next();
                        if (!(collection.hasNext())) {
                        } else {
                            iterator2 = ((BlockPosServiceComponent) index4);
                            element = 0;
                            iterator2 = iterator2.getNumericValue();
                            element = collection.next();
                            direction = ((BlockPosServiceComponent) element);
                            index5 = 0;
                            direction = direction.getNumericValue();
                            if (Float.compare(iterator2, direction) < 0) {
                                index4 = element;
                                iterator2 = direction;
                            }
                        }
                    }
                } else {
                    index3 = ((Iterable) blockPos3);
                    blockPos4 = 0;
                    collection = index3.iterator();
                    if (!(collection.hasNext())) {
                    } else {
                        index4 = collection.next();
                        if (!(collection.hasNext())) {
                        } else {
                            iterator2 = ((BlockPosServiceComponent) index4);
                            element = 0;
                            iterator2 = iterator2.getNumericValue();
                            element = collection.next();
                            direction = ((BlockPosServiceComponent) element);
                            index5 = 0;
                            direction = direction.getNumericValue();
                            if (Float.compare(iterator2, direction) < 0) {
                                index4 = element;
                                iterator2 = direction;
                            }
                        }
                    }
                }
                blockPos4 = ((Iterable) blockPos3);
                collection = 0;
                index4 = blockPos4;
                iterator2 = ((Collection) new ArrayList());
                element = 0;
                direction = index4.iterator();
                while (direction.hasNext()) {
                    index5 = direction.next();
                    collection2 = ((BlockPosServiceComponent) index5);
                    index6 = 0;
                    if (((BlockPosServiceComponent) index4) != null) {
                    } else {
                    }
                    iterator2.add(index5);
                }
                blockPos4 = ((Iterable) iterator2);
                collection = 0;
                index4 = blockPos4.iterator();
                if (!(index4.hasNext())) {
                } else {
                    iterator2 = index4.next();
                    if (!(index4.hasNext())) {
                    } else {
                        element = ((BlockPosServiceComponent) iterator2);
                        direction = 0;
                        element = element.getNumericValue();
                        direction = index4.next();
                        index5 = ((BlockPosServiceComponent) direction);
                        collection2 = 0;
                        index5 = index5.getNumericValue();
                        if (Float.compare(element, index5) < 0) {
                            iterator2 = direction;
                            element = index5;
                        }
                    }
                }
                index3 = ((BlockPosServiceComponent) iterator2);
                return;
                if (SpeedMineModule.INSTANCE.checkCondition(this.getMinecraftObject())) {
                    if (index3 == null) {
                    }
                }
                this.executeAction(blockPos4.getMinecraftObject(), false);
            } else {
                index3 = 0;
                blockPos4 = this.iterator();
                if (!(blockPos4.hasNext())) {
                } else {
                    collection = blockPos4.next();
                    if (!(blockPos4.hasNext())) {
                    } else {
                        index4 = ((BlockPosServiceComponent) collection);
                        iterator2 = 0;
                        index4 = index4.getNumericValue();
                        iterator2 = blockPos4.next();
                        element = ((BlockPosServiceComponent) iterator2);
                        direction = 0;
                        element = element.getNumericValue();
                        if (Float.compare(index4, element) < 0) {
                            collection = iterator2;
                            index4 = element;
                        }
                    }
                }
                if (((BlockPosServiceComponent) collection) != null) {
                    index3 = ((BlockPosServiceComponent) collection);
                    blockPos4 = 0;
                    INSTANCE.executeAction(index3.getMinecraftObject(), false);
                } else {
                }
            }
        } else {
        }
    }

    private void executeAction(PlayerEntity arg0, List arg1, List arg2, boolean arg3) {
        if (arg0.method_20448()) {
        }
        Iterable iterable = ((Iterable) arg1);
        int index = 0;
        Iterator iterator = CollectionsKt.sortedWith(iterable, ((java.util.Comparator) new Comparator(arg0))).iterator();
        while (iterator.hasNext()) {
            iterable = ((BlockPos) iterator.next());
            index = iterable.method_10086(2);
            int index2 = 0;
            BlockPos blockPos = index.method_10086(index2);
            if (!(arg3)) {
                if (SharedKt.getPlayer().getEyePos().method_1022(blockPos.toCenterPos()) <= SharedKt.getPlayer().method_55754() && Intrinsics.areEqual(this.resolveMinecraftObject(blockPos).getBlock(), Blocks.OBSIDIAN)) {
                    boolean flag = this.resolveMinecraftObject(blockPos.up()).method_26215();
                    if (!(flag) && index2 == 3) {
                    }
                    float factor = 99.0F;
                    float factor2 = 100.0F;
                    if (this.getCevPriority()) {
                    } else {
                    }
                    blockPos.add(new BlockPosServiceComponent(factor2, 0.5F));
                }
            }
        }
    }

    private static void executeAction(AutoMineModule arg0, PlayerEntity arg1, List arg2, List arg3, boolean arg4, int arg5, Object arg6) {
        if ((arg5 & 8) != 0) {
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
                    return false;
                }
            }
        }
        Iterable iterable = ((Iterable) SpeedMineModule.INSTANCE.getLinkedList());
        int index = 0;
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            ReasonPacketHelper reasonPacketHelper = ((ReasonPacketHelper) element);
            int index2 = 0;
            if (!(SharedKt.getWorld().method_22347(reasonPacketHelper.getMinecraftObject()))) {
                if (reasonPacketHelper.getNumericValue() > 0) {
                } else {
                }
            }
        }
        if (((ReasonPacketHelper) null) != null) {
            if (((ReasonPacketHelper) null).getMinecraftObject() == null) {
                return false;
            }
        }
        if (this.getHoldCev()) {
            List list = new ArrayList();
            this.executeAction(arg0, arg2, list, true);
            iterable = ((Iterable) list);
            if (arg3 > 0) {
                index = 0;
            }
            if (iterable instanceof Collection && ((Collection) iterable).isEmpty()) {
            } else {
                iterator = iterable.iterator();
                while (iterator.hasNext()) {
                    element = iterator.next();
                    reasonPacketHelper = ((BlockPosServiceComponent) element);
                    index2 = 0;
                }
            }
            if (arg4 > 0) {
                if (0) {
                    return true;
                }
            }
        }
        list = arg2.iterator();
        while (list.hasNext()) {
            iterable = ((BlockPos) list.next());
            iterator = ((Iterable) ServiceComponent36.enumEntries);
            element = 0;
            reasonPacketHelper = iterator;
            index2 = ((Collection) new ArrayList());
            Iterator iterator2 = reasonPacketHelper.iterator();
            while (iterator2.hasNext()) {
                Object element2 = iterator2.next();
                Direction direction = ((Direction) element2);
                if (arg1 > 0) {
                    if (direction != Direction.UP) {
                    } else {
                    }
                }
                index2.add(element2);
            }
            index = index2.iterator();
            while (index.hasNext()) {
            }
            iterator = ((Direction) index.next());
            element = iterable.offset(iterator);
            if (arg1 >= 0) {
                if (arg1 >= 0) {
                    if (__UNDEF_KEY__ == null) {
                        if (arg2.contains(element)) {
                        }
                    }
                }
                if (arg3 >= 0) {
                    if (__UNDEF_KEY__ == null) {
                        if (this.getHoldSurr()) {
                            if (!(Intrinsics.areEqual(element, element))) {
                                if (arg4 >= 0) {
                                    if (__UNDEF_KEY__ == null) {
                                    }
                                }
                            }
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
            BlockPosServiceComponent blockPosServiceComponent = ((BlockPosServiceComponent) iterator.next());
            int index = 360;
            if (index >= 180) {
            } else {
            }
            Color color = PolygonShaderComponent.INSTANCE.resolveColor(PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor2(), 0.5F), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor2(), 0.0F), (index / 360.0F));
            int index2 = 4;
            Box box = new Box(blockPosServiceComponent.getMinecraftObject());
            TextShaderComponent2.checkCondition(box, color, index2);
            TextShaderComponent2.executeAction(String.valueOf(blockPosServiceComponent.getNumericValue()), blockPosServiceComponent.getMinecraftObject().toCenterPos(), color, 0.0F, 0.0F, false);
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
                if (__UNDEF_KEY__ == null) {
                    if (!(Intrinsics.areEqual(state.getBlock(), Blocks.field_9987)) && state.method_26214(((class_1922) SharedKt.getWorld()), blockPos2) > 0.0F && !(Intrinsics.areEqual(state.getBlock(), Blocks.AIR)) && !(Intrinsics.areEqual(state.getBlock(), Blocks.field_10543)) && !(state.method_45474())) {
                        this.executeAction(blockPos2, true);
                        return true;
                    }
                }
            }
            if (!(Intrinsics.areEqual(state2.getBlock(), Blocks.field_9987)) && state2.method_26214(((class_1922) SharedKt.getWorld()), blockPos3) > 0.0F && !(Intrinsics.areEqual(state2.getBlock(), Blocks.AIR)) && !(Intrinsics.areEqual(state2.getBlock(), Blocks.field_10543)) && !(state2.method_45474())) {
                this.executeAction(blockPos3, true);
                return true;
            }
        }
        return false;
    }

    private boolean checkCondition(int arg0) {
        Iterator iterator = TheNetherPacketHelper.INSTANCE.getList().iterator();
        while (iterator.hasNext()) {
            class_2586 class2586 = ((class_2586) iterator.next());
            if (arg0 > 0) {
                if (__UNDEF_KEY__ == null) {
                    if (SharedKt.getPlayer().getEyePos().method_1022(class2586.method_11016().toCenterPos()) > 2.2D || !(class2586 instanceof class_2611)) {
                        continue;
                    }
                    this.executeAction(((class_2611) class2586).method_11016(), false);
                }
            }
        }
        return false;
    }

    private boolean checkCondition(PlayerEntity arg0) {
        Iterator iterator = TheNetherPacketHelper.INSTANCE.getList().iterator();
        while (iterator.hasNext()) {
            class_2586 class2586 = ((class_2586) iterator.next());
            if (arg0.getEyePos().method_1022(class2586.method_11016().toCenterPos()) > 2.2D || !(class2586 instanceof class_2627)) {
                continue;
            }
            this.executeAction(((class_2627) class2586).method_11016(), true);
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
                    this.updateValue();
                }
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
        KProperty[] items = new KProperty[12];
        INSTANCE = new AutoMineModule();
        cevPrioritySetting = VisibleRenderHelper.registerSetting(INSTANCE, "cev-priority", true);
        antiShulkerSetting = VisibleRenderHelper.registerSetting(INSTANCE, "anti-shulker", true);
        eChestMineSetting = VisibleRenderHelper.registerSetting(INSTANCE, "e-chests-mine", true);
        debugSetting = VisibleRenderHelper.registerSetting(INSTANCE, "debug", false);
        antiCrawlSetting = VisibleRenderHelper.registerSetting(INSTANCE, "anti-crawl", true);
        levelDownSetting = VisibleRenderHelper.registerSetting(INSTANCE, "level-down", new KeyRecord(0, false, false));
        cevCrawlersSetting = VisibleRenderHelper.registerSetting(INSTANCE, "cev-crawlers", false);
        holdPositionSetting = VisibleRenderHelper.registerSetting(INSTANCE, "sync-with-rebreak", true);
        holdGroupSetting = VisibleRenderHelper.resolveDefaultValueVisibleSettingPropertyImpl7(INSTANCE, "hold-selection", OptionMode14.BOOLS, this::isActive);
        holdCivSetting = VisibleRenderHelper.resolveVisibleVisibleSettingPropertyImpl(INSTANCE, "hold-civ", true, INSTANCE.getHoldGroup(), this::isActive2);
        holdCevSetting = VisibleRenderHelper.resolveVisibleVisibleSettingPropertyImpl(INSTANCE, "hold-cev", true, INSTANCE.getHoldGroup(), this::isActive3);
        holdSurrSetting = VisibleRenderHelper.resolveVisibleVisibleSettingPropertyImpl(INSTANCE, "hold-surr", true, INSTANCE.getHoldGroup(), this::isActive4);
        serviceComponent38 = new ServiceComponent38();
        itemList = new ArrayList();
    }

}
