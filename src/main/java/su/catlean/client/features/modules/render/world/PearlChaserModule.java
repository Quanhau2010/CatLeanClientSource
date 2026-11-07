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
        return ((Boolean) onlyTargetSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private WindHopSwitchMode getSwitch() {
        return ((WindHopSwitchMode) switchSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private void onAfterEntitySpawn(AfterEntitySpawn arg0) {
        SharedKt.getWorld().getPlayers().stream().min(Comparator.comparingDouble(this::computeValue)).ifPresent(this::executeAction);
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        blockPos = null;
        if (this.getOnlyTarget()) {
            if (AuraModule.INSTANCE.getTarget() != null && AuraModule.INSTANCE.getEnabled() && AuraModule.INSTANCE.getTarget() instanceof PlayerEntity) {
                PlayerEntity player = ((PlayerEntity) AuraModule.INSTANCE.getTarget());
                if (!(hashMap.containsKey(player))) {
                }
            }
            if (AutoCrystalModule.INSTANCE.getTarget() != null && AutoCrystalModule.INSTANCE.getEnabled() && AutoCrystalModule.INSTANCE.getTarget() != null) {
                player = AutoCrystalModule.INSTANCE.getTarget();
                if (!(hashMap.containsKey(player))) {
                }
            }
            player = ((Map) new HashMap(((Map) hashMap)));
            int index = 0;
            while (iterator.hasNext()) {
                Entry entry = ((Entry) this.next());
                Entry entry2 = entry;
                int index2 = 0;
                if ((SharedKt.getNumericValue() - ((Number) entry2.getValue()).longValue()) > timestampValue) {
                    hashMap.remove(entry2.getKey());
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
            index = player.next();
            if (((class_1684) index).method_5628() == countValue2) {
            }
            entry = ((Iterable) SharedKt.getWorld().getPlayers());
            entry2 = 0;
            index2 = entry;
            Collection collection = ((Collection) new ArrayList());
            int index3 = 0;
            Iterator iterator2 = index2.iterator();
            while (iterator2.hasNext()) {
                Object element = iterator2.next();
                AbstractClientPlayerEntity player2 = ((AbstractClientPlayerEntity) element);
                if (!(hashMap.containsKey(player2))) {
                }
                collection.add(element);
            }
            entry = ((Iterable) collection);
            entry2 = 0;
            index2 = entry.iterator();
            if (!(index2.hasNext())) {
            } else {
                collection = index2.next();
                if (!(index2.hasNext())) {
                } else {
                    index3 = ((AbstractClientPlayerEntity) collection);
                    iterator2 = 0;
                    index3 = index3.method_5707(INSTANCE.resolveMinecraftObject(index));
                    iterator2 = index2.next();
                    element = ((AbstractClientPlayerEntity) iterator2);
                    player2 = 0;
                    element = element.method_5707(INSTANCE.resolveMinecraftObject(index));
                    if (Double.compare(index3, element) > 0) {
                        collection = iterator2;
                        index3 = element;
                    }
                }
            }
            index2 = 0;
            blockPos = INSTANCE.resolveMinecraftObject(INSTANCE.resolveMinecraftObject(index), ((class_1684) index).method_18798());
            countValue = ((class_1684) index).method_5628();
        }
        if (blockPos == null) {
            return;
        }
        if (SharedKt.getPlayer().method_5707(blockPos.toCenterPos()) < 49.0D) {
            return;
        }
        player = MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent(blockPos.toCenterPos()).getNumericValue();
        index = this.computeValue(blockPos, player);
        if (Float.isNaN(index)) {
            return;
        }
        if (blockPos.method_19770(this.toCenterPos()) > 36.0D) {
            return;
        }
        entry = new MoveFixServiceComponent(player, Math.clamp(index, -89.0F, 89.0F), false);
        SequenceServiceComponent.INSTANCE.executeAction(new RotationServiceComponent4(entry, 150, this::resolveUnit2));
        blockPos = null;
        serviceComponent10.executeAction();
    }

    private float computeValue(BlockPos arg0, float arg1) {
        Vec3d vec = SharedKt.getPlayer().getEyePos();
        List<BlockPos> list = new ArrayList();
        float factor = (arg1 - 10);
        float factor2 = (arg1 + 10);
        if (factor <= factor2) {
            int index = 10;
            if (-86 < index) {
                if (this.toCenterPos().method_1022(arg0.toCenterPos()) < 5.0D) {
                    list.add(TuplesKt.to(Float.valueOf(index)));
                }
            }
            if (factor != factor2) {
            }
        }
        factor2 = ((Iterable) list);
        index = 0;
        if (!(this.hasNext())) {
        } else {
            Object element = this.next();
            if (!(this.hasNext())) {
            } else {
                Pair pair = ((Pair) element);
                int index2 = 0;
                pair = ((BlockPos) pair.getFirst()).toCenterPos().method_1022(arg0.toCenterPos());
                index2 = this.next();
                Pair pair2 = ((Pair) index2);
                pair2 = ((BlockPos) pair2.getFirst()).toCenterPos().method_1022(arg0.toCenterPos());
                if (Double.compare(pair, pair2) > 0) {
                    element = index2;
                    pair = pair2;
                }
            }
        }
        if (((Pair) element) != null) {
        } else {
        }
        return Float.NaN;
    }

    private BlockPos resolveMinecraftObject(float arg0, float arg1) {
        return this.resolveMinecraftObject(SharedKt.getPlayer().getEyePos(), this.resolveMinecraftObject(arg1, arg0));
    }

    private BlockPos resolveMinecraftObject(Vec3d arg0, Vec3d arg1) {
        Vec3d vec = arg1;
        Vec3d vec2 = arg0;
        Vec3d vec3 = arg0;
        int index = 0;
        if (index < 201) {
            vec = vec.method_1031(0.0D, -0.03D, 0.0D);
            vec = this.resolveMinecraftObject(vec, vec2);
            class_3965 class3965 = SharedKt.getWorld().method_17742(new class_3959(vec3, vec2, class_3960.field_17559, class_242.field_1348, SharedKt.getPlayer()));
            if (__UNDEF_KEY__ == null) {
                if (class3965.method_17783() != class_240.field_1333) {
                    return class3965.method_17777();
                }
            }
            Iterator iterator = SharedKt.getWorld().method_18112().iterator();
            while (iterator.hasNext()) {
                Entity entity = iterator.next();
                if (__UNDEF_KEY__ == null) {
                }
                Vec3d vec4 = vec2.method_1019(vec);
                Optional optional = entity.method_5829().method_992(vec2, vec4);
                if (__UNDEF_KEY__ == null) {
                    if (optional.isEmpty()) {
                    }
                }
                return BlockPos.ofFloored(optional.get());
            }
            vec3 = vec2;
            vec2 = vec2.method_1019(vec);
        }
        return null;
    }

    private Vec3d resolveMinecraftObject(Vec3d arg0, Vec3d arg1) {
        if (SharedKt.getWorld().getBlockState(BlockPos.ofFloored(arg1)).getBlock() instanceof FluidBlock) {
        } else {
        }
        return this.method_1021(0.99D);
    }

    private Vec3d resolveMinecraftObject(float arg0, float arg1) {
        double offset = 0.017453292519943295D;
        double offset2 = (Math.sin((arg1 * offset)) * Math.cos((arg0 * offset)));
        double offset3 = Math.sin((arg0 * offset));
        double offset4 = (Math.cos((arg1 * offset)) * Math.cos((arg0 * offset)));
        if (__UNDEF_KEY__ == null) {
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
        return ((Number) arg0.invoke(arg1));
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
        PacketPacketHelper.handlePacket(((Packet) new class_2879(Hand.field_5808)));
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit2(MoveFixServiceComponent arg0) {
        ItemPacketHelper.INSTANCE.checkCondition(Items.field_8634, INSTANCE.getSwitch(), this::resolveUnit);
        return Unit.INSTANCE;
    }

    static {
        KProperty[] items = new KProperty[2];
        INSTANCE = new PearlChaserModule();
        onlyTargetSetting = VisibleRenderHelper.registerSetting(INSTANCE, "only-target", false);
        switchSetting = VisibleRenderHelper.registerSetting(INSTANCE, "switch", WindHopSwitchMode.SILENT_FULL);
        serviceComponent10 = new ServiceComponent10();
        hashMap = new HashMap();
    }

}
