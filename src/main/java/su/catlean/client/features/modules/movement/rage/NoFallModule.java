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
        return (NoFallMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private NoFallFallDistanceMode getFallDistance() {
        return (NoFallFallDistanceMode) fallDistanceSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private int getFallDistanceValue() {
        return (Number) fallDistanceValueSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private boolean getWaterBucket() {
        return (Boolean) waterBucketSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private boolean getRetrieve() {
        return (Boolean) retrieveSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    private boolean getEnderPearl() {
        return (Boolean) enderPearlSetting.getValue(this, DELEGATED_PROPERTIES[5]);
    }

    private boolean getCobweb() {
        return (Boolean) cobwebSetting.getValue(this, DELEGATED_PROPERTIES[6]);
    }

    private boolean getTwistingVines() {
        return (Boolean) twistingVinesSetting.getValue(this, DELEGATED_PROPERTIES[7]);
    }

    private boolean getGrim() {
        return (Boolean) grimSetting.getValue(this, DELEGATED_PROPERTIES[8]);
    }

    public void onPlayerUpdateEvent(PlayerUpdateEvent e) {
        if (var41 != null) {
            if (SharedKt.getPlayer().field_6012 < 5) {
                countValue2 = 0;
            }
        }
        if (var41 != null) {
            if (countValue == 1) {
                countValue = 2;
                this.updateValue();
                return;
            }
        }
        if (var41 != null) {
            if (countValue == 2) {
                SharedKt.getPlayer().method_6043();
                countValue = 3;
                this.updateValue();
                return;
            }
            if (var41 != null) {
            }
            if (countValue == 3) {
                enabledFlag2 = 0;
                countValue = 0;
                this.updateValue();
                return;
            }
        }
        if (var41 != null) {
            if (this.checkCondition()) {
                PacketPacketHelper.handlePacket((Packet) new class_5911(1, SharedKt.getPlayer().field_5976));
                BlockPos blockPos = BlockPos.ofFloored(this.resolveMinecraftObject(SharedKt.getPlayer()));
                int var45 = 5;
                int var46 = 0;
                if (var46 < var45) {
                    int var47 = var46;
                    int var48 = 0;
                    BlockPos blockPos2 = blockPos.method_10087();
                    if (var41 != null) {
                        if (!(SharedKt.getWorld().getBlockState(blockPos2).method_45474())) {
                            blockPos = blockPos2.up();
                        }
                    }
                }
                var46 = new Item[1];
                var46[0] = Items.field_8634;
                var45 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2();
                var47 = new Item[1];
                var47[0] = Items.field_8786;
                var46 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2();
                var48 = new Item[1];
                var48[0] = Items.field_23070;
                var47 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2();
                blockPos2 = new Item[1];
                blockPos2[0] = Items.field_8705;
                var48 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(blockPos2);
                if (var48.isActive()) {
                    if (this.getWaterBucket()) {
                        if (var41 != null && var41 != null && var41 != null) {
                            if (serviceComponent10.checkCondition(500)) {
                                this.executeAction();
                                enabledFlag = this.getRetrieve();
                            }
                        }
                    }
                }
                if (var45.isActive()) {
                    if (this.getEnderPearl()) {
                        if (var41 != null && var41 != null && var41 != null) {
                            if (serviceComponent10.checkCondition(500)) {
                                this.executeAction();
                                serviceComponent10.executeAction();
                            }
                        }
                    }
                }
                if (var46.isActive()) {
                    if (var41 != null && var41 != null) {
                        if (this.getCobweb()) {
                            this.executeAction(blockPos);
                        }
                    }
                }
                if (var41 != null) {
                    if (var41 != null) {
                    }
                }
                this.executeAction(blockPos);
                enabledFlag2 = 1;
                enabledFlag2 = 1;
                this.updateValue();
                var45 = SharedKt.getPlayer();
                var46 = 0;
                PacketPacketHelper.handlePacket((Packet) new class_2830(var45.getX(), (var45.getY() + 1.0E-9D), var45.getZ(), var45.method_36454(), var45.method_36455(), 0, var45.field_5976));
                var45.method_38785();
            }
        }
        Item[] var43 = new Item[1];
        var43[0] = Items.field_8550;
        StackServiceComponent2 var42 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2();
        if (var41 != null) {
            if (var42.isActive()) {
                this.executeAction();
            }
        }
        enabledFlag = 0;
    }

    private void executeAction(StackServiceComponent2 arg0) {
        SequenceServiceComponent.INSTANCE.executeAction(new RotationServiceComponent4(new MoveFixServiceComponent(SharedKt.getPlayer().method_36454(), 90.0F), 0, this::resolveUnit));
    }

    private void executeAction(StackServiceComponent2 arg0, BlockPos arg1) {
        if (this.getGrim()) {
        }
        RotationServiceComponent4 var16 = VecPacketHelper.resolveRotationServiceComponent4(arg1, arg0.getNumericValue(), BlockPlacementInteractMode.GRIM, BlockPlacementInteractMode.Strict, BlockPlacementPlaceMode.Normal, OptionMode15.ALL, SharedKt.getPlayer().method_55754(), 0.0F, 200, BlockPlacementSwitchMode.Silent);
        if (var15 != null) {
            if (var16 != null) {
                Object var17 = var16;
                int var18 = 0;
                SequenceServiceComponent.INSTANCE.executeAction();
                serviceComponent10.executeAction();
            } else {
            }
        }
    }

    private boolean checkCondition() {
        if (var13 != null) {
        }
        if (var13 != null) {
            if (SharedKt.getMc().player != null && !(SharedKt.getPlayer().isFallFlying())) {
                if (var13 != null) {
                    if (SharedKt.getPlayer().method_31549().field_7479) {
                    }
                }
            }
            return false;
        }
        if (var13 != null) {
            if (this.getMode() == NoFallMode.GrimOld) {
                if (var13 != null) {
                    if (EventPacketHelper2.INSTANCE.getNumericValue() > 3.0D) {
                    }
                } else {
                }
                return false;
            }
        }
        if (var13 != null) {
        }
        if (var13 != null) {
            if (EventPacketHelper2.INSTANCE.getNumericValue() > this.getFallDistanceValue()) {
            }
        }
        if (var13 != null) {
            if ((((EventPacketHelper2.INSTANCE.getNumericValue() - 3) / 2.0F) + 3.5F) > (SharedKt.getPlayer().method_6032() / 3.0F)) {
            }
        }
        return new NoWhenBranchMatchedException();
    }

    public void onSendPacket(SendPacket e) {
        if (e.getPacket() instanceof PlayerMoveC2SPacket) {
            if (var8 != null) {
                if (this.getMode() == NoFallMode.GRIM_NEW && countValue2 < 11) {
                }
            } else {
            }
            int var9 = 0;
            if (var8 != null) {
                if (enabledFlag2) {
                }
                if (var9) {
                    if (var8 != null) {
                        if (!(SharedKt.getPlayer().isOnGround())) {
                        }
                    } else {
                    }
                    1.setGround(0);
                    int var10 = countValue2;
                    countValue2 = (var10 + 1);
                    if (var8 == null) {
                    }
                    (ServerboundMovePlayerPacketAccessor) e.getPacket().setGround(0);
                }
                if (var8 != null) {
                }
                if (var8 != null) {
                    if (SharedKt.getPlayer().isOnGround() && !(countValue) && this.getMode() == NoFallMode.GRIM_NEW && !(var9)) {
                    }
                    countValue = 1;
                }
            }
        }
    }

    private void updateValue() {
        SharedKt.getPlayer().method_5728(0);
        SharedKt.getMc().options.field_1894.method_23481(0);
        SharedKt.getMc().options.field_1881.method_23481(0);
        SharedKt.getMc().options.field_1913.method_23481(0);
        SharedKt.getMc().options.field_1849.method_23481(0);
        SharedKt.getMc().options.field_1903.method_23481(0);
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
        if (var7 != null) {
        }
        if (var7 != null) {
            if (INSTANCE.getMode() == NoFallMode.Items && INSTANCE.getWaterBucket()) {
            }
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
        class_1269 var14 = HandServiceComponent.resolveMinecraftObject(Hand.field_5808, SharedKt.getPlayer().method_36454(), 90.0F);
        if (var13 != null) {
            if (!(Intrinsics.areEqual(class_1269.field_5811))) {
                serviceComponent10.executeAction();
            }
            SharedKt.getPlayer().method_6104(Hand.field_5808);
            ItemPacketHelper.INSTANCE.updateValue2();
        }
        return Unit.INSTANCE;
    }

    static {
        KProperty[] var30 = new KProperty[9];
        INSTANCE = new NoFallModule();
        modeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mode", NoFallMode.Rubberband);
        fallDistanceSetting = VisibleRenderHelper.registerSetting(INSTANCE, "fall-distance", NoFallFallDistanceMode.Calc);
        fallDistanceValueSetting = VisibleRenderHelper.registerSetting(INSTANCE, "fall-distance-val", 10, new IntRange(2, 100), null, this::isActive);
        waterBucketSetting = VisibleRenderHelper.registerSetting(INSTANCE, "water-bucket", 1, null, this::isActive2);
        retrieveSetting = VisibleRenderHelper.registerSetting(INSTANCE, "retrieve", 1, null, this::isActive3);
        enderPearlSetting = VisibleRenderHelper.registerSetting(INSTANCE, "ender-pearl", 1, null, this::isActive4);
        cobwebSetting = VisibleRenderHelper.registerSetting(INSTANCE, "cobweb", 1, null, this::isActive5);
        twistingVinesSetting = VisibleRenderHelper.registerSetting(INSTANCE, "twisting-vines", 1, null, this::isActive6);
        grimSetting = VisibleRenderHelper.registerSetting(INSTANCE, "grim", 1, null, this::isActive7);
        serviceComponent10 = new ServiceComponent10();
    }

}
