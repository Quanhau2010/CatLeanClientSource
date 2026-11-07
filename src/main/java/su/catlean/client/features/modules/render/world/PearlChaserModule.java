package su.catlean.client.features.modules.render.world;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.class_1684;
import net.minecraft.class_239.class_240;
import net.minecraft.class_2879;
import net.minecraft.class_3959;
import net.minecraft.class_3959.class_242;
import net.minecraft.class_3959.class_3960;
import net.minecraft.class_3965;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.world.AfterEntitySpawn;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.movement.basic.WindHopSwitchMode;
import su.catlean.client.features.modules.pvp.attack.AuraModule;
import su.catlean.client.features.modules.pvp.attack.AutoCrystalModule;
import su.catlean.client.services.client.HandServiceComponent;
import su.catlean.client.services.client.MoveFixServiceComponent;
import su.catlean.client.services.client.RotationServiceComponent4;
import su.catlean.client.services.client.SequenceServiceComponent;
import su.catlean.client.services.client.ServiceComponent10;
import su.catlean.client.services.client.VectorServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.network.PacketPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;

public class PearlChaserModule extends Module {

    public static final PearlChaserModule INSTANCE;
    private static final VisibleVisibleSettingPropertyImpl onlyTargetSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 switchSetting;
    private static final ServiceComponent10 serviceComponent10;
    private static BlockPos blockPos;
    private static int countValue;
    private static int countValue2;
    private static final HashMap hashMap;

    private PearlChaserModule() {
        super("pearl-chaser", SubCategoriesKt.getWorldRenderCategory());
    }

    private boolean getOnlyTarget() {
        return (Boolean) onlyTargetSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private WindHopSwitchMode getSwitch() {
        return (WindHopSwitchMode) switchSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private void onAfterEntitySpawn(AfterEntitySpawn arg0) {
        SharedKt.getWorld().getPlayers().stream().min(Comparator.comparingDouble(this::computeValue)).ifPresent(this::executeAction);
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        blockPos = null;
        if (this.getOnlyTarget()) {
            if (AuraModule.INSTANCE.getTarget() != null && AuraModule.INSTANCE.getEnabled() && AuraModule.INSTANCE.getTarget() instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) AuraModule.INSTANCE.getTarget();
                if (!(hashMap.containsKey(player))) {
                }
            }
            if (AutoCrystalModule.INSTANCE.getTarget() != null && AutoCrystalModule.INSTANCE.getEnabled() && AutoCrystalModule.INSTANCE.getTarget() != null) {
                player = AutoCrystalModule.INSTANCE.getTarget();
                if (!(hashMap.containsKey(player))) {
                }
            }
            player = (Map) new HashMap((Map) hashMap);
            int var34 = 0;
            while (var35.hasNext()) {
                Entry var36 = (Entry) var35.next();
                Object var37 = var36;
                int var38 = 0;
                if ((SharedKt.getNumericValue() - (Number) var37.getValue().longValue()) > timestampValue) {
                    hashMap.remove(var37.getKey());
                }
            }
        }
        if (SharedKt.getPlayer().method_6032() < 5.0F) {
            return;
        }
        if (!(serviceComponent10.checkCondition(500))) {
            return;
        }
        player = SharedKt.getWorld().method_18112().iterator();
        while (player.hasNext()) {
            var34 = player.next();
            if ((class_1684) var34.method_5628() == countValue2) {
            }
            var36 = (Iterable) SharedKt.getWorld().getPlayers();
            var37 = 0;
            var38 = var36;
            Collection var39 = (Collection) new ArrayList();
            int var40 = 0;
            Iterator iterator = var38.iterator();
            while (iterator.hasNext()) {
                Object var43 = iterator.next();
                AbstractClientPlayerEntity player2 = (AbstractClientPlayerEntity) var43;
                int var46 = 0;
                if (!(hashMap.containsKey(player2))) {
                }
                var39.add();
            }
            var36 = (Iterable) var39;
            var37 = 0;
            var38 = var36.iterator();
            if (!(var38.hasNext())) {
            } else {
                var39 = var38.next();
                if (!(var38.hasNext())) {
                } else {
                    var40 = (AbstractClientPlayerEntity) var39;
                    iterator = 0;
                    var40 = var40.method_5707(INSTANCE.resolveMinecraftObject());
                    iterator = var38.next();
                    var43 = (AbstractClientPlayerEntity) iterator;
                    player2 = 0;
                    var43 = var43.method_5707(INSTANCE.resolveMinecraftObject());
                    if (Double.compare() > 0) {
                        var39 = iterator;
                        var40 = var43;
                    }
                }
            }
            var37 = var35;
            var38 = 0;
            blockPos = INSTANCE.resolveMinecraftObject(INSTANCE.resolveMinecraftObject(), (class_1684) var34.method_18798());
            countValue = (class_1684) var34.method_5628();
        }
        if (blockPos == null) {
            return;
        }
        if (SharedKt.getPlayer().method_5707(blockPos.toCenterPos()) < 49.0D) {
            return;
        }
        player = MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent(blockPos.toCenterPos()).getNumericValue();
        var34 = this.computeValue(blockPos, player);
        if (Float.isNaN()) {
            return;
        }
        if (blockPos.method_19770(var35.toCenterPos()) > 36.0D) {
            return;
        }
        var36 = new MoveFixServiceComponent(player, Math.clamp(-89.0F, 89.0F));
        SequenceServiceComponent.INSTANCE.executeAction(new RotationServiceComponent4(150, this::resolveUnit2));
        blockPos = null;
        serviceComponent10.executeAction();
    }

    private float computeValue(BlockPos arg0, float arg1) {
        Vec3d vec = SharedKt.getPlayer().getEyePos();
        List<BlockPos> positions = new ArrayList();
        float var14 = (arg1 - 10);
        float var15 = (arg1 + 10);
        if (var14 <= var15) {
            int var16 = 10;
            if (-86 < var16) {
                if (var17.toCenterPos().method_1022(arg0.toCenterPos()) < 5.0D) {
                    positions.add(TuplesKt.to(Float.valueOf()));
                }
            }
            if (var14 != var15) {
            }
        }
        var15 = (Iterable) positions;
        var16 = 0;
        if (!(var17.hasNext())) {
        } else {
            Object var18 = var17.next();
            if (!(var17.hasNext())) {
            } else {
                Pair var19 = (Pair) var18;
                int var21 = 0;
                var19 = (BlockPos) var19.getFirst().toCenterPos().method_1022(arg0.toCenterPos());
                var21 = var17.next();
                Pair var22 = (Pair) var21;
                int var24 = 0;
                var22 = (BlockPos) var22.getFirst().toCenterPos().method_1022(arg0.toCenterPos());
                if (Double.compare() > 0) {
                    var18 = var21;
                    var19 = var22;
                }
            }
        }
        if ((Pair) var18 != null) {
        } else {
        }
        return Float.NaN;
    }

    private BlockPos resolveMinecraftObject(float arg0, float arg1) {
        return this.resolveMinecraftObject(SharedKt.getPlayer().getEyePos(), this.resolveMinecraftObject(arg1, arg0));
    }

    private BlockPos resolveMinecraftObject(Vec3d arg0, Vec3d arg1) {
        Object var13 = arg1;
        Object var14 = arg0;
        Object var15 = arg0;
        int var16 = 0;
        if (var16 < 201) {
            var13 = var13.method_1031(0.0D, -0.03D, 0.0D);
            var13 = this.resolveMinecraftObject();
            class_3965 var17 = SharedKt.getWorld().method_17742(new class_3959(class_3960.field_17559, class_242.field_1348, SharedKt.getPlayer()));
            if (var12 == null) {
                if (var17.method_17783() != class_240.field_1333) {
                }
                return var17.method_17777();
            }
            Iterator iterator = SharedKt.getWorld().method_18112().iterator();
            if (iterator.hasNext()) {
                Entity entity = iterator.next();
                if (var12 == null) {
                }
                Object var20 = var14;
                Vec3d vec = var14.method_1019();
                Optional var22 = entity.method_5829().method_992(vec);
                if (var12 == null) {
                    if (var22.isEmpty()) {
                    }
                }
                return BlockPos.ofFloored(var22.get());
            }
            var15 = var14;
            var14 = var14.method_1019();
        }
        return null;
    }

    private Vec3d resolveMinecraftObject(Vec3d arg0, Vec3d arg1) {
        if (SharedKt.getWorld().getBlockState(BlockPos.ofFloored(arg1)).getBlock() instanceof FluidBlock) {
        } else {
        }
        return 0.8D.method_1021(0.99D);
    }

    private Vec3d resolveMinecraftObject(float arg0, float arg1) {
        double var8 = 0.017453292519943295D;
        double var10 = (Math.sin((arg1 * var8)) * Math.cos((arg0 * var8)));
        double var12 = Math.sin((arg0 * var8));
        double var14 = (Math.cos((arg1 * var8)) * Math.cos((arg0 * var8)));
        if (var7 == null) {
            if (SharedKt.getPlayer().isOnGround()) {
            } else {
            }
        }
        return SharedKt.getPlayer().method_60478().field_1352.method_1031(0.0D, SharedKt.getPlayer().method_60478().field_1351, SharedKt.getPlayer().method_60478().field_1350);
    }

    private static double computeValue(AfterEntitySpawn arg0, AbstractClientPlayerEntity arg1) {
        return arg1.method_5707(INSTANCE.resolveMinecraftObject(arg0.getEntity()));
    }

    private static double computeValue(Function1 arg0, Object arg1) {
        return (Number) arg0.invoke(arg1);
    }

    private static Unit resolveUnit(AfterEntitySpawn arg0, AbstractClientPlayerEntity arg1) {
        if (Intrinsics.areEqual(arg1, SharedKt.getPlayer())) {
            countValue2 = arg0.getEntity().method_5628();
        }
        return Unit.INSTANCE;
    }

    private static void executeAction(Function1 arg0, Object arg1) {
        arg0.invoke(arg1);
    }

    private static Unit resolveUnit(MoveFixServiceComponent arg0) {
        HandServiceComponent.resolveMinecraftObject(Hand.field_5808, arg0.getNumericValue(), arg0.getNumericValue2());
        PacketPacketHelper.handlePacket((Packet) new class_2879(Hand.field_5808));
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit2(MoveFixServiceComponent arg0) {
        ItemPacketHelper.INSTANCE.checkCondition(Items.field_8634, INSTANCE.getSwitch(), this::resolveUnit);
        return Unit.INSTANCE;
    }

    static {
        KProperty[] var33 = new KProperty[2];
        INSTANCE = new PearlChaserModule();
        onlyTargetSetting = VisibleRenderHelper.registerSetting(INSTANCE, "only-target");
        switchSetting = VisibleRenderHelper.registerSetting(INSTANCE, "switch", WindHopSwitchMode.SILENT_FULL);
        serviceComponent10 = new ServiceComponent10();
        hashMap = new HashMap();
    }

}
