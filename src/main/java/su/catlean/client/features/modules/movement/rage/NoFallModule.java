package su.catlean.client.features.modules.movement.rage;

import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import net.minecraft.block.BlockState;
import net.minecraft.class_1269;
import net.minecraft.class_2828.class_2830;
import net.minecraft.class_2828.class_5911;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.SendPacket;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.BlockPlacementInteractMode;
import su.catlean.client.features.modules.BlockPlacementPlaceMode;
import su.catlean.client.features.modules.BlockPlacementSwitchMode;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.HandServiceComponent;
import su.catlean.client.services.client.MoveFixServiceComponent;
import su.catlean.client.services.client.RotationServiceComponent4;
import su.catlean.client.services.client.SequenceServiceComponent;
import su.catlean.client.services.client.ServiceComponent10;
import su.catlean.client.services.client.StackServiceComponent2;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.network.PacketPacketHelper;
import su.catlean.client.services.network.VecPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.types.OptionMode15;
import su.catlean.client.types.mappings.NoFallModeWhenMappings;
import su.catlean.mixins.accessors.ServerboundMovePlayerPacketAccessor;

public class NoFallModule extends Module {

    public static final NoFallModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 modeSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 fallDistanceSetting;
    private static final RangeVisibleSettingPropertyImpl fallDistanceValueSetting;
    private static final VisibleVisibleSettingPropertyImpl waterBucketSetting;
    private static final VisibleVisibleSettingPropertyImpl retrieveSetting;
    private static final VisibleVisibleSettingPropertyImpl enderPearlSetting;
    private static final VisibleVisibleSettingPropertyImpl cobwebSetting;
    private static final VisibleVisibleSettingPropertyImpl twistingVinesSetting;
    private static final VisibleVisibleSettingPropertyImpl grimSetting;
    private static final ServiceComponent10 serviceComponent10;
    private static boolean enabledFlag;
    private static int countValue;
    private static int countValue2;
    private static boolean enabledFlag2;

    private NoFallModule() {
        super("no-fall", SubCategoriesKt.getRageMovementCategory());
    }

    private NoFallMode getMode() {
        return ((NoFallMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private NoFallFallDistanceMode getFallDistance() {
        return ((NoFallFallDistanceMode) fallDistanceSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private int getFallDistanceValue() {
        return ((Number) fallDistanceValueSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private boolean getWaterBucket() {
        return ((Boolean) waterBucketSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private boolean getRetrieve() {
        return ((Boolean) retrieveSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    private boolean getEnderPearl() {
        return ((Boolean) enderPearlSetting.getValue(this, DELEGATED_PROPERTIES[5]));
    }

    private boolean getCobweb() {
        return ((Boolean) cobwebSetting.getValue(this, DELEGATED_PROPERTIES[6]));
    }

    private boolean getTwistingVines() {
        return ((Boolean) twistingVinesSetting.getValue(this, DELEGATED_PROPERTIES[7]));
    }

    private boolean getGrim() {
        return ((Boolean) grimSetting.getValue(this, DELEGATED_PROPERTIES[8]));
    }

    public void onPlayerUpdateEvent(PlayerUpdateEvent e) {
        if (__UNDEF_KEY__ != null) {
            if (SharedKt.getPlayer().field_6012 < 5) {
                countValue2 = 0;
            }
        }
        if (__UNDEF_KEY__ != null) {
            if (countValue == 1) {
                countValue = 2;
                this.updateValue();
                return;
            }
        }
        if (__UNDEF_KEY__ != null) {
            if (countValue == 2) {
                SharedKt.getPlayer().method_6043();
                countValue = 3;
                this.updateValue();
                return;
            }
            if (__UNDEF_KEY__ != null) {
                if (countValue == 3) {
                    enabledFlag2 = 0;
                    countValue = 0;
                    this.updateValue();
                    return;
                }
            }
        }
        if (__UNDEF_KEY__ != null) {
            if (this.checkCondition()) {
                PacketPacketHelper.handlePacket(((Packet) new class_5911(true, SharedKt.getPlayer().field_5976)));
                BlockPos blockPos = BlockPos.ofFloored(this.resolveMinecraftObject(SharedKt.getPlayer()));
                int index = 5;
                int index2 = 0;
                if (index2 < index) {
                    int index3 = index2;
                    int index4 = 0;
                    BlockPos blockPos2 = blockPos.method_10087(index3);
                    if (__UNDEF_KEY__ != null) {
                        if (!(SharedKt.getWorld().getBlockState(blockPos2).method_45474())) {
                            blockPos = blockPos2.up();
                        }
                    }
                }
                index2 = new Item[1];
                index2[0] = Items.field_8634;
                index = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(index2);
                index3 = new Item[1];
                index3[0] = Items.field_8786;
                index2 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(index3);
                index4 = new Item[1];
                index4[0] = Items.field_23070;
                index3 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(index4);
                blockPos2 = new Item[1];
                blockPos2[0] = Items.field_8705;
                index4 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(blockPos2);
                if (index4.isActive()) {
                    if (this.getWaterBucket()) {
                        if (__UNDEF_KEY__ != null && __UNDEF_KEY__ != null && __UNDEF_KEY__ != null) {
                            if (serviceComponent10.checkCondition(500)) {
                                this.executeAction(index4);
                                enabledFlag = this.getRetrieve();
                            }
                        }
                    }
                }
                if (index.isActive()) {
                    if (this.getEnderPearl()) {
                        if (__UNDEF_KEY__ != null && __UNDEF_KEY__ != null && __UNDEF_KEY__ != null) {
                            if (serviceComponent10.checkCondition(500)) {
                                this.executeAction(index);
                                serviceComponent10.executeAction();
                            }
                        }
                    }
                }
                if (index2.isActive()) {
                    if (__UNDEF_KEY__ != null && __UNDEF_KEY__ != null) {
                        if (this.getCobweb()) {
                            this.executeAction(index2, blockPos);
                        }
                    }
                }
                if (__UNDEF_KEY__ != null) {
                    if (__UNDEF_KEY__ != null) {
                    }
                }
                this.executeAction(index3, blockPos);
                enabledFlag2 = 1;
                enabledFlag2 = 1;
                this.updateValue();
                index = SharedKt.getPlayer();
                index2 = 0;
                PacketPacketHelper.handlePacket(((Packet) new class_2830(index.getX(), (index.getY() + 1.0E-9D), index.getZ(), index.method_36454(), index.method_36455(), false, index.field_5976)));
                index.method_38785();
            }
        }
        Item[] items = new Item[1];
        items[0] = Items.field_8550;
        StackServiceComponent2 stackServiceComponent2 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(items);
        if (__UNDEF_KEY__ != null) {
            if (stackServiceComponent2.isActive()) {
                this.executeAction(stackServiceComponent2);
            }
        }
        enabledFlag = 0;
    }

    private void executeAction(StackServiceComponent2 arg0) {
        SequenceServiceComponent.INSTANCE.executeAction(new RotationServiceComponent4(0, this::resolveUnit));
    }

    private void executeAction(StackServiceComponent2 arg0, BlockPos arg1) {
        if (this.getGrim()) {
        }
        RotationServiceComponent4 rotationServiceComponent4 = VecPacketHelper.resolveRotationServiceComponent4(arg1, arg0.getNumericValue(), BlockPlacementInteractMode.GRIM, BlockPlacementInteractMode.Strict, BlockPlacementPlaceMode.Normal, OptionMode15.ALL, SharedKt.getPlayer().method_55754(), 0.0F, 200, BlockPlacementSwitchMode.Silent, null, false);
        SequenceServiceComponent.INSTANCE.executeAction(rotationServiceComponent4);
        serviceComponent10.executeAction();
    }

    private boolean checkCondition() {
        if (SharedKt.getMc().player != null && !(SharedKt.getPlayer().isFallFlying())) {
            if (SharedKt.getPlayer().method_31549().field_7479) {
                return false;
            }
        }
        if (this.getMode() == NoFallMode.GrimOld) {
            if (EventPacketHelper2.INSTANCE.getNumericValue() > 3.0D) {
            } else {
            }
            return false;
        }
        if (EventPacketHelper2.INSTANCE.getNumericValue() > this.getFallDistanceValue()) {
        }
        if ((((EventPacketHelper2.INSTANCE.getNumericValue() - 3) / 2.0F) + 3.5F) > (SharedKt.getPlayer().method_6032() / 3.0F)) {
        }
        return new NoWhenBranchMatchedException();
    }

    public void onSendPacket(SendPacket e) {
        if (e.getPacket() instanceof PlayerMoveC2SPacket) {
            if (__UNDEF_KEY__ != null) {
                if (this.getMode() == NoFallMode.GRIM_NEW && countValue2 < 11) {
                } else {
                }
            }
            int index = 0;
            if (__UNDEF_KEY__ != null) {
                if (enabledFlag2) {
                    if (index) {
                        if (__UNDEF_KEY__ != null) {
                            if (!(SharedKt.getPlayer().isOnGround())) {
                            } else {
                            }
                        }
                        this.setGround(false);
                        countValue2 = (countValue2 + 1);
                        if (__UNDEF_KEY__ == null) {
                            ((ServerboundMovePlayerPacketAccessor) e.getPacket()).setGround(false);
                        }
                    }
                    if (__UNDEF_KEY__ != null) {
                    }
                    if (__UNDEF_KEY__ != null) {
                        if (SharedKt.getPlayer().isOnGround() && !(countValue) && this.getMode() == NoFallMode.GRIM_NEW && !(index)) {
                            countValue = 1;
                        }
                    }
                }
            }
        }
    }

    private void updateValue() {
        SharedKt.getPlayer().method_5728(false);
        SharedKt.getMc().options.field_1894.method_23481(false);
        SharedKt.getMc().options.field_1881.method_23481(false);
        SharedKt.getMc().options.field_1913.method_23481(false);
        SharedKt.getMc().options.field_1849.method_23481(false);
        SharedKt.getMc().options.field_1903.method_23481(false);
    }

    public void updateValue() {
        enabledFlag2 = 0;
    }

    private static boolean isActive() {
        return INSTANCE.getFallDistance() == NoFallFallDistanceMode.Custom;
    }

    private static boolean isActive2() {
        return INSTANCE.getMode() == NoFallMode.Items;
    }

    private static boolean isActive3() {
        if (INSTANCE.getMode() == NoFallMode.Items) {
        } else {
        }
        return false;
    }

    private static boolean isActive4() {
        return INSTANCE.getMode() == NoFallMode.Items;
    }

    private static boolean isActive5() {
        return INSTANCE.getMode() == NoFallMode.Items;
    }

    private static boolean isActive6() {
        return INSTANCE.getMode() == NoFallMode.Items;
    }

    private static boolean isActive7() {
        return INSTANCE.getMode() == NoFallMode.Items;
    }

    private static Unit resolveUnit(StackServiceComponent2 arg0) {
        ItemPacketHelper.INSTANCE.updateValue();
        arg0.updateValue();
        class_1269 class1269 = HandServiceComponent.resolveMinecraftObject(Hand.field_5808, SharedKt.getPlayer().method_36454(), 90.0F);
        if (__UNDEF_KEY__ != null) {
            if (!(Intrinsics.areEqual(class1269, class_1269.field_5811))) {
                serviceComponent10.executeAction();
            }
            SharedKt.getPlayer().method_6104(Hand.field_5808);
            ItemPacketHelper.INSTANCE.updateValue2();
        }
        return Unit.INSTANCE;
    }

    static {
        KProperty[] items = new KProperty[9];
        INSTANCE = new NoFallModule();
        modeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mode", NoFallMode.Rubberband);
        fallDistanceSetting = VisibleRenderHelper.registerSetting(INSTANCE, "fall-distance", NoFallFallDistanceMode.Calc);
        fallDistanceValueSetting = VisibleRenderHelper.registerSetting(INSTANCE, "fall-distance-val", 10, new IntRange(2, 100), null, this::isActive);
        waterBucketSetting = VisibleRenderHelper.registerSetting(INSTANCE, "water-bucket", true, null, this::isActive2);
        retrieveSetting = VisibleRenderHelper.registerSetting(INSTANCE, "retrieve", true, null, this::isActive3);
        enderPearlSetting = VisibleRenderHelper.registerSetting(INSTANCE, "ender-pearl", true, null, this::isActive4);
        cobwebSetting = VisibleRenderHelper.registerSetting(INSTANCE, "cobweb", true, null, this::isActive5);
        twistingVinesSetting = VisibleRenderHelper.registerSetting(INSTANCE, "twisting-vines", true, null, this::isActive6);
        grimSetting = VisibleRenderHelper.registerSetting(INSTANCE, "grim", true, null, this::isActive7);
        serviceComponent10 = new ServiceComponent10();
    }

}
