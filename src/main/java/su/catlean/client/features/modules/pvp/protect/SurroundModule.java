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
        super("surround", SubCategoriesKt.getProtectCategory(), 200, 0);
    }

    private boolean getYDisable() {
        return (Boolean) yDisableSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private boolean getAsync() {
        return (Boolean) asyncSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private int getAsyncDelay() {
        return (Number) asyncDelaySetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private BlocksServiceComponent getSelectedBlocks() {
        return (BlocksServiceComponent) selectedBlocksSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private void setSelectedBlocks(BlocksServiceComponent value) {
        selectedBlocksSetting.setValue(this, DELEGATED_PROPERTIES[3], value);
    }

    private SurroundCenterMode getCenter() {
        return (SurroundCenterMode) centerSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    private void setCenter(SurroundCenterMode value) {
        centerSetting.setValue(this, DELEGATED_PROPERTIES[4], value);
    }

    private boolean getForceCenter() {
        return (Boolean) forceCenterSetting.getValue(this, DELEGATED_PROPERTIES[5]);
    }

    private void setForceCenter(boolean value) {
        forceCenterSetting.setValue(this, DELEGATED_PROPERTIES[5], Boolean.valueOf(value));
    }

    public void updateValue(long arg0) {
        long var3 = ((arg0 ^ 103451004335712L) >>> 56);
        long var4 = (((arg0 ^ 103451004335712L) << 8) >>> 8);
        long var6 = (arg0 ^ 88141289065175L);
        long var8 = (arg0 ^ 70028441922719L);
        long var10 = (arg0 ^ 67464996320865L);
        if (this.getCenter() != SurroundCenterMode.OFF) {
            BlockPos blockPos = BlockPos.ofFloored(this.resolveMinecraftObject(SharedKt.getPlayer()));
            ClosedFloatingPointRange var14 = RangesKt.rangeTo((blockPos.method_10263() + 0.301D), (blockPos.method_10263() + 0.699D));
            ClosedFloatingPointRange var15 = RangesKt.rangeTo((blockPos.method_10260() + 0.301D), (blockPos.method_10260() + 0.699D));
            if (this.getCenter() == SurroundCenterMode.DEFAULT) {
            } else {
            }
            double var16 = (Number) RangesKt.coerceIn((Comparable) Double.valueOf(SharedKt.getPlayer().getX()));
            if (this.getCenter() == SurroundCenterMode.DEFAULT) {
            } else {
            }
            double var18 = (Number) RangesKt.coerceIn((Comparable) Double.valueOf(SharedKt.getPlayer().getZ()));
            SharedKt.getPlayer().method_33574(new Vec3d(this.resolveMinecraftObject(SharedKt.getPlayer()).field_1351));
            if (this.getForceCenter()) {
                ClientPlayerEntity player = SharedKt.getPlayer();
                int var21 = 0;
                player.field_3944.method_52787((Packet) new class_2830(player.getY(), player.method_36454(), player.method_36455(), player.isOnGround(), player.field_5976));
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
        BlockPlacementModule.placeBlocks(this, SharedKt.getPlayer().getX().resolveList(BlockPos.method_49637((Math.floor(SharedKt.getPlayer().getY()) + 1.0D), Math.floor(SharedKt.getPlayer().getY()), SharedKt.getPlayer().getZ()), new ArrayList()));
        enabledFlag = 1;
    }

    private void onAfterReceivePacket(AfterReceivePacket arg0) {
        Packet var18 = arg0.getPacket();
        Vec3d vec = new Vec3d((class_2604) var18.method_11175(), (class_2604) var18.method_11174(), (class_2604) var18.method_11176());
        if ((SharedKt.getPlayer().getY() - Math.floor(SharedKt.getPlayer().getY())) > 0.8D) {
        } else {
        }
        List positions = SharedKt.getPlayer().getX().resolveList(BlockPos.method_49637((Math.floor(SharedKt.getPlayer().getY()) + 1.0D), Math.floor(SharedKt.getPlayer().getY()), SharedKt.getPlayer().getZ()), new ArrayList());
        class_2824 var21 = class_2824.method_34206(SharedKt.getPlayer(), SharedKt.getPlayer().method_5715());
        ServiceComponent93.executeAction((class_2604) var18.method_11167());
        PacketPacketHelper.handlePacket((Packet) var21);
        PacketPacketHelper.handlePacket((Packet) new class_2879(Hand.field_5808));
        Iterable var22 = (Iterable) positions;
        int var23 = 0;
        BlockPlacementModule.placeBlocks(this, CollectionsKt.sortedWith((Comparator) new Comparator20(vec)));
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
        List positions = new ArrayList();
        Iterable var26 = (Iterable) ServiceComponent66.enumEntries;
        int var27 = 0;
        Object var28 = var26;
        Collection var29 = (Collection) new ArrayList();
        int var30 = 0;
        Iterator iterator = var28.iterator();
        if (iterator.hasNext()) {
            Object var32 = iterator;
            Direction var33 = (Direction) var32;
            int var34 = 0;
            var29.add();
        }
        Iterator iterator2 = var29.iterator();
        if (iterator2.hasNext()) {
            var26 = (Direction) iterator2.next();
            var27 = arg0.offset();
            if (!(arg1.contains()) && !(SharedKt.getWorld().getBlockState().method_45474())) {
            }
            if (this.checkCondition()) {
                arg1.add(arg0);
                positions.addAll((Collection) this.resolveList(arg1));
            }
            if (VecPacketHelper.resolveRotationServiceComponent4(0, this.getInteract(), this.getPlaceMode(), OptionMode15.ONLY_CRYSTALS, 6.0F, 6.0F, this.getNumericValue(), this.getSwitch()) == null) {
                var29 = (Iterable) ServiceComponent66.enumEntries;
                var30 = 0;
                iterator = var29;
                var32 = (Collection) new ArrayList();
                var33 = 0;
                var34 = iterator.iterator();
                if (var34.hasNext()) {
                    Object var35 = var34.next();
                    Direction var36 = (Direction) var35;
                    int var37 = 0;
                    var32.add();
                }
                var28 = var32.iterator();
                while (var28.hasNext()) {
                }
                var29 = (Direction) var28.next();
                if (!(SharedKt.getWorld().getBlockState().method_45474())) {
                }
                var30 = var27.offset();
                positions.add();
                positions.add();
            }
            positions.add();
        }
        iterator2 = EventPacketHelper2.process(0.5F, 1, 0.0F, 0.0F, 0.0F);
        var26 = (Iterable) positions;
        var27 = 0;
        return CollectionsKt.sortedWith((Comparator) new Comparator23(iterator2));
    }

    protected List resolveList(long arg0) {
        long var3 = (arg0 ^ 59067967019128L);
        return this.getSelectedBlocks().getList();
    }

    private static boolean isActive() {
        return INSTANCE.getAsync();
    }

    private static boolean isActive2() {
        return INSTANCE.getCenter() != SurroundCenterMode.OFF;
    }

    static {
        KProperty[] var39 = new KProperty[6];
        INSTANCE = new SurroundModule();
        yDisableSetting = VisibleRenderHelper.registerSetting(INSTANCE, "y disable");
        asyncSetting = VisibleRenderHelper.registerSetting(INSTANCE, "async");
        asyncDelaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "async-delay", 0, new IntRange(0, 250), null, this::isActive);
        var39 = new Block[3];
        var39[0] = Blocks.OBSIDIAN;
        var39[1] = Blocks.ENDER_CHEST;
        var39[2] = Blocks.field_22108;
        int var35 = 12;
        BlocksServiceComponent var38 = new BlocksServiceComponent(CollectionsKt.mutableListOf());
        selectedBlocksSetting = VisibleRenderHelper.registerSetting(INSTANCE, "blocks");
        centerSetting = VisibleRenderHelper.registerSetting(INSTANCE, "center", SurroundCenterMode.OFF);
        forceCenterSetting = VisibleRenderHelper.registerSetting(INSTANCE, "force-center", 0, null, this::isActive2);
        serviceComponent10 = new ServiceComponent10();
        serviceComponent102 = new ServiceComponent10();
    }

}
