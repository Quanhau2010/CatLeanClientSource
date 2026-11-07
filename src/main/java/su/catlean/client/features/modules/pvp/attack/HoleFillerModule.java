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
        super("hole-filler", SubCategoriesKt.getAttackCategory(), 0, false);
    }

    private HoleFillerMode getMode() {
        return ((HoleFillerMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private HoleFillerPreferBlocksMode getPreferBlocks() {
        return ((HoleFillerPreferBlocksMode) preferBlocksSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        BlockPlacementModule.placeBlocks(this, this.resolveList(), false, false, null, false);
    }

    private List resolveList() {
        List list = this.resolveList2();
        if (this.getMode() == HoleFillerMode.DEFAULT) {
            return list;
        }
        List<BlockPos> list2 = new ArrayList();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            BlockPos blockPos = ((BlockPos) iterator.next());
            Iterator iterator2 = SharedKt.getWorld().getPlayers().iterator();
            AbstractClientPlayerEntity player = ((AbstractClientPlayerEntity) iterator2.next());
            if (!(Intrinsics.areEqual(player, SharedKt.getMc().player)) && !(EntityHelper4.isFriend(((PlayerEntity) player))) && player.distanceTo(SharedKt.getMc().player) > 12.0F) {
            }
            if (player.getY() < blockPos.up().method_10264()) {
            }
            double offset = Math.ceil(((TheNetherPacketHelper.f() * 1.5D) / 50.0D));
            if (offset <= 0) {
                if (this.resolveMinecraftObject(player).method_1022(blockPos.toCenterPos()) > 2.0D) {
                }
                list2.add(blockPos);
            }
            int index = 0;
            Vec3d vec = PlayerEntityHelper2.INSTANCE.predictPosition(((PlayerEntity) player), index);
            if (vec.method_1022(blockPos.toCenterPos()) > 2.0D) {
            } else {
                list2.add(blockPos);
            }
        }
        return list2;
    }

    private List resolveList2() {
        List list = new ArrayList();
        BlockPos blockPos = BlockPos.ofFloored(SharedKt.getPlayer().getEyePos());
        double offset = Math.ceil(this.getRange());
        int index = (blockPos.method_10263() - offset);
        int index2 = (blockPos.method_10263() + offset);
        if (index <= index2) {
            int index3 = (blockPos.method_10264() - offset);
            int index4 = (blockPos.method_10264() + offset);
            if (index3 <= index4) {
                int index5 = (blockPos.method_10260() - offset);
                int index6 = (blockPos.method_10260() + offset);
                if (index5 <= index6) {
                    BlockPos blockPos2 = new BlockPos(index, index3, index5);
                    if (ServiceComponent102.INSTANCE.checkCondition(blockPos2)) {
                        list.add(blockPos2);
                    }
                    if (index5 != index6) {
                    }
                }
                if (index3 != index4) {
                }
            }
            if (index != index2) {
            }
        }
        return list;
    }

    protected List resolveList() {
        Block[] items = new Block[1];
        items[0] = Blocks.COBWEB;
        if (ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(items).isActive()) {
            return CollectionsKt.listOf(Blocks.COBWEB);
        }
        return this.resolveList();
    }

    static {
        KProperty[] items = new KProperty[2];
        INSTANCE = new HoleFillerModule();
        modeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mode", HoleFillerMode.AROUND_PLAYERS);
        preferBlocksSetting = VisibleRenderHelper.registerSetting(INSTANCE, "prefer", HoleFillerPreferBlocksMode.OBBY);
    }

}
