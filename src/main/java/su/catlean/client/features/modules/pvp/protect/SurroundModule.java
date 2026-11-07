package su.catlean.client.features.modules.pvp.protect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.class_1299;
import net.minecraft.class_2604;
import net.minecraft.class_2824;
import net.minecraft.class_2828.class_2830;
import net.minecraft.class_2879;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.client.TickEvent;
import su.catlean.api.event.events.network.AfterReceivePacket;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.world.WorldUpdateEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl3;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.BlockPlacementModule;
import su.catlean.client.services.client.BlocksServiceComponent;
import su.catlean.client.services.client.ServiceComponent10;
import su.catlean.client.services.client.ServiceComponent66;
import su.catlean.client.services.client.ServiceComponent93;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.network.PacketPacketHelper;
import su.catlean.client.services.network.TheNetherPacketHelper;
import su.catlean.client.services.network.VecPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.tools.comparators.Comparator20;
import su.catlean.client.tools.comparators.Comparator23;
import su.catlean.client.types.OptionMode15;

public class SurroundModule extends BlockPlacementModule {

    public static final SurroundModule INSTANCE;
    private static final VisibleVisibleSettingPropertyImpl yDisableSetting;
    private static final VisibleVisibleSettingPropertyImpl asyncSetting;
    private static final RangeVisibleSettingPropertyImpl asyncDelaySetting;
    private static final DefaultValueVisibleSettingPropertyImpl3 selectedBlocksSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 centerSetting;
    private static final VisibleVisibleSettingPropertyImpl forceCenterSetting;
    private static boolean enabledFlag;
    private static ServiceComponent10 serviceComponent10;
    private static ServiceComponent10 serviceComponent102;

    private SurroundModule() {
        super("surround", SubCategoriesKt.getProtectCategory(), 200, false);
    }

    private boolean getYDisable() {
        return ((Boolean) yDisableSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private boolean getAsync() {
        return ((Boolean) asyncSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private int getAsyncDelay() {
        return ((Number) asyncDelaySetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private BlocksServiceComponent getSelectedBlocks() {
        return ((BlocksServiceComponent) selectedBlocksSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private void setSelectedBlocks(BlocksServiceComponent value) {
        selectedBlocksSetting.setValue(this, DELEGATED_PROPERTIES[3], value);
    }

    private SurroundCenterMode getCenter() {
        return ((SurroundCenterMode) centerSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    private void setCenter(SurroundCenterMode value) {
        centerSetting.setValue(this, DELEGATED_PROPERTIES[4], value);
    }

    private boolean getForceCenter() {
        return ((Boolean) forceCenterSetting.getValue(this, DELEGATED_PROPERTIES[5]));
    }

    private void setForceCenter(boolean value) {
        forceCenterSetting.setValue(this, DELEGATED_PROPERTIES[5], Boolean.valueOf(value));
    }

    public void updateValue() {
        if (this.getCenter() != SurroundCenterMode.OFF) {
            BlockPos blockPos = BlockPos.ofFloored(this.resolveMinecraftObject(SharedKt.getPlayer()));
            ClosedFloatingPointRange closedFloatingPointRange = RangesKt.rangeTo((blockPos.method_10263() + 0.301D), (blockPos.method_10263() + 0.699D));
            ClosedFloatingPointRange closedFloatingPointRange2 = RangesKt.rangeTo((blockPos.method_10260() + 0.301D), (blockPos.method_10260() + 0.699D));
            if (this.getCenter() == SurroundCenterMode.DEFAULT) {
            } else {
            }
            double offset = ((Number) RangesKt.coerceIn(((Comparable) Double.valueOf(SharedKt.getPlayer().getX())), closedFloatingPointRange));
            if (this.getCenter() == SurroundCenterMode.DEFAULT) {
            } else {
            }
            double offset2 = ((Number) RangesKt.coerceIn(((Comparable) Double.valueOf(SharedKt.getPlayer().getZ())), closedFloatingPointRange2));
            SharedKt.getPlayer().method_33574(new Vec3d(offset, this.resolveMinecraftObject(SharedKt.getPlayer()).field_1351, offset2));
            if (this.getForceCenter()) {
                ClientPlayerEntity player = SharedKt.getPlayer();
                player.field_3944.method_52787(((Packet) new class_2830(offset, player.getY(), offset2, player.method_36454(), player.method_36455(), player.isOnGround(), player.field_5976)));
            }
        }
        enabledFlag = 0;
    }

    private void onTickEvent(TickEvent arg0) {
        this.updateValue2();
    }

    private void onWorldUpdateEvent(WorldUpdateEvent arg0) {
        if ((SharedKt.getPlayer().getY() - Math.floor(SharedKt.getPlayer().getY())) > 0.8D) {
        } else {
        }
        BlockPlacementModule.placeBlocks(this, SharedKt.getPlayer().getX().resolveList(BlockPos.method_49637((Math.floor(SharedKt.getPlayer().getY()) + 1.0D), Math.floor(SharedKt.getPlayer().getY()), SharedKt.getPlayer().getZ()), new ArrayList()), true, false, null, false);
        enabledFlag = 1;
    }

    private void onAfterReceivePacket(AfterReceivePacket arg0) {
        Packet packet = arg0.getPacket();
        Vec3d vec = new Vec3d(((class_2604) packet).method_11175(), ((class_2604) packet).method_11174(), ((class_2604) packet).method_11176());
        if ((SharedKt.getPlayer().getY() - Math.floor(SharedKt.getPlayer().getY())) > 0.8D) {
        } else {
        }
        List list = SharedKt.getPlayer().getX().resolveList(BlockPos.method_49637((Math.floor(SharedKt.getPlayer().getY()) + 1.0D), Math.floor(SharedKt.getPlayer().getY()), SharedKt.getPlayer().getZ()), new ArrayList());
        class_2824 class2824 = class_2824.method_34206(SharedKt.getPlayer(), SharedKt.getPlayer().method_5715());
        ServiceComponent93.executeAction(class2824, ((class_2604) packet).method_11167());
        PacketPacketHelper.handlePacket(((Packet) class2824));
        PacketPacketHelper.handlePacket(((Packet) new class_2879(Hand.field_5808)));
        Iterable iterable = ((Iterable) list);
        BlockPlacementModule.placeBlocks(this, CollectionsKt.sortedWith(iterable, ((Comparator) new Comparator20(vec))), true, false, null, false);
        enabledFlag = 1;
        arg0.cancel();
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (enabledFlag) {
            enabledFlag = 0;
            return;
        }
        if ((SharedKt.getPlayer().getY() - Math.floor(SharedKt.getPlayer().getY())) > 0.8D) {
        } else {
        }
        serviceComponent102.executeAction();
    }

    private List resolveList(BlockPos arg0, List arg1) {
        List list = new ArrayList();
        Iterable iterable = ((Iterable) ServiceComponent66.enumEntries);
        int index = 0;
        Iterable iterable2 = iterable;
        Collection collection = ((Collection) new ArrayList());
        int index2 = 0;
        Iterator iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            Iterator iterator2 = iterator;
            Direction direction = ((Direction) iterator2);
            int index3 = 0;
            collection.add(iterator2);
        }
        Iterator iterator3 = collection.iterator();
        while (iterator3.hasNext()) {
            iterable = ((Direction) iterator3.next());
            index = arg0.offset(iterable);
            if (!(arg1.contains(index)) && !(SharedKt.getWorld().getBlockState(index).method_45474())) {
            }
            if (this.checkCondition(index)) {
                arg1.add(arg0);
                list.addAll(((Collection) this.resolveList(index, arg1)));
            }
            if (VecPacketHelper.resolveRotationServiceComponent4(index, 0, this.getInteract(), this.getPlaceMode(), OptionMode15.ONLY_CRYSTALS, 6.0F, 6.0F, this.getNumericValue(), this.getSwitch(), null, false) == null) {
                collection = ((Iterable) ServiceComponent66.enumEntries);
                index2 = 0;
                iterator = collection;
                iterator2 = ((Collection) new ArrayList());
                direction = 0;
                index3 = iterator.iterator();
                while (index3.hasNext()) {
                    Object element = index3.next();
                    Direction direction2 = ((Direction) element);
                    iterator2.add(element);
                }
                iterable2 = iterator2.iterator();
                while (iterable2.hasNext()) {
                }
                collection = ((Direction) iterable2.next());
                if (!(SharedKt.getWorld().getBlockState(index).method_45474())) {
                }
                index2 = index.offset(collection);
                list.add(index2);
                list.add(index);
            }
            list.add(index);
        }
        iterator3 = EventPacketHelper2.process(0.5F, true, 0.0F, 0.0F, 0.0F);
        iterable = ((Iterable) list);
        index = 0;
        return CollectionsKt.sortedWith(iterable, ((Comparator) new Comparator23(iterator3)));
    }

    protected List resolveList() {
        return this.getSelectedBlocks().getList();
    }

    private static boolean isActive() {
        return INSTANCE.getAsync();
    }

    private static boolean isActive2() {
        return INSTANCE.getCenter() != SurroundCenterMode.OFF;
    }

    static {
        KProperty[] items = new KProperty[6];
        INSTANCE = new SurroundModule();
        yDisableSetting = VisibleRenderHelper.registerSetting(INSTANCE, "y disable", true);
        asyncSetting = VisibleRenderHelper.registerSetting(INSTANCE, "async", true);
        asyncDelaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "async-delay", 0, new IntRange(0, 250), null, this::isActive);
        items = new Block[3];
        items[0] = Blocks.OBSIDIAN;
        items[1] = Blocks.ENDER_CHEST;
        items[2] = Blocks.field_22108;
        int index = 12;
        BlocksServiceComponent blocksServiceComponent = new BlocksServiceComponent(CollectionsKt.mutableListOf(items));
        selectedBlocksSetting = VisibleRenderHelper.registerSetting(INSTANCE, "blocks", blocksServiceComponent, index);
        centerSetting = VisibleRenderHelper.registerSetting(INSTANCE, "center", SurroundCenterMode.OFF);
        forceCenterSetting = VisibleRenderHelper.registerSetting(INSTANCE, "force-center", false, null, this::isActive2);
        serviceComponent10 = new ServiceComponent10();
        serviceComponent102 = new ServiceComponent10();
    }

}
