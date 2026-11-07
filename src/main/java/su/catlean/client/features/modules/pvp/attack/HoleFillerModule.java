package su.catlean.client.features.modules.pvp.attack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.client.features.modules.BlockPlacementModule;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.ServiceComponent102;
import su.catlean.client.services.client.StackServiceComponent2;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.network.TheNetherPacketHelper;
import su.catlean.client.services.player.EntityHelper4;
import su.catlean.client.services.player.PlayerEntityHelper2;
import su.catlean.client.services.render.VisibleRenderHelper;

public class HoleFillerModule extends BlockPlacementModule {

    public static final HoleFillerModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 modeSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 preferBlocksSetting;

    private HoleFillerModule() {
        super("hole-filler", SubCategoriesKt.getAttackCategory());
    }

    private HoleFillerMode getMode() {
        return (HoleFillerMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private HoleFillerPreferBlocksMode getPreferBlocks() {
        return (HoleFillerPreferBlocksMode) preferBlocksSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        BlockPlacementModule.placeBlocks(this, this.resolveList());
    }

    private List resolveList() {
        List positions = this.resolveList2();
        if (this.getMode() == HoleFillerMode.DEFAULT) {
            return positions;
        }
        List<BlockPos> positions2 = new ArrayList();
        Iterator iterator = positions.iterator();
        if (iterator.hasNext()) {
            BlockPos blockPos = (BlockPos) iterator.next();
            Iterator iterator2 = SharedKt.getWorld().getPlayers().iterator();
            AbstractClientPlayerEntity player = (AbstractClientPlayerEntity) iterator2.next();
            if (!(Intrinsics.areEqual(player, SharedKt.getMc().player)) && !(EntityHelper4.isFriend((PlayerEntity) player)) && player.distanceTo(SharedKt.getMc().player) > 12.0F) {
            }
            if (player.getY() < blockPos.up().method_10264()) {
            }
            double var29 = Math.ceil(((TheNetherPacketHelper.f() * 1.5D) / 50.0D));
            if (var29 <= 0) {
                if (this.resolveMinecraftObject(player).method_1022(blockPos.toCenterPos()) > 2.0D) {
                }
                positions2.add(blockPos);
            }
            int var30 = 0;
            Vec3d vec = PlayerEntityHelper2.INSTANCE.predictPosition((PlayerEntity) player);
            if (vec.method_1022(blockPos.toCenterPos()) > 2.0D) {
            } else {
                positions2.add(blockPos);
            }
        }
        return positions2;
    }

    private List resolveList2() {
        List positions = new ArrayList();
        BlockPos blockPos = BlockPos.ofFloored(SharedKt.getPlayer().getEyePos());
        double var12 = Math.ceil(this.getRange());
        int var13 = (blockPos.method_10263() - var12);
        int var14 = (blockPos.method_10263() + var12);
        if (var13 <= var14) {
            int var15 = (blockPos.method_10264() - var12);
            int var16 = (blockPos.method_10264() + var12);
            if (var15 <= var16) {
                int var17 = (blockPos.method_10260() - var12);
                int var18 = (blockPos.method_10260() + var12);
                if (var17 <= var18) {
                    BlockPos blockPos2 = new BlockPos();
                    if (ServiceComponent102.INSTANCE.checkCondition(blockPos2)) {
                        positions.add(blockPos2);
                    }
                    if (var17 != var18) {
                    }
                }
                if (var15 != var16) {
                }
            }
            if (var13 != var14) {
            }
        }
        return positions;
    }

    protected List resolveList(long arg0) {
        long var3 = (arg0 ^ 57424830627199L);
        long var5 = ((arg0 ^ 127027046720104L) >>> 32);
        long var6 = (((arg0 ^ 127027046720104L) << 32) >>> 48);
        long var7 = (((arg0 ^ 127027046720104L) << 48) >>> 48);
        long var8 = (arg0 ^ 0L);
        if (var10 != null) {
            if (this.getPreferBlocks() == HoleFillerPreferBlocksMode.WEB) {
                Block[] var11 = new Block[1];
                var11[0] = Blocks.COBWEB;
                if (ItemPacketHelper.INSTANCE.resolveStackServiceComponent2().isActive()) {
                    return CollectionsKt.listOf(Blocks.COBWEB);
                }
            }
        }
        if (arg0 > 0L && var10 == null) {
        }
        return this.resolveList();
    }

    static {
        KProperty[] var26 = new KProperty[2];
        INSTANCE = new HoleFillerModule();
        modeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mode", HoleFillerMode.AROUND_PLAYERS);
        preferBlocksSetting = VisibleRenderHelper.registerSetting(INSTANCE, "prefer", HoleFillerPreferBlocksMode.OBBY);
    }

}
