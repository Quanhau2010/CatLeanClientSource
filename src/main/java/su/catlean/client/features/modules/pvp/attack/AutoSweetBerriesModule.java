package su.catlean.client.features.modules.pvp.attack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.class_2372;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.BlockPlacementModule;
import su.catlean.client.services.client.ServiceComponent42;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EntityPacketHelper;
import su.catlean.client.services.player.EntityHelper4;
import su.catlean.client.services.player.PlayerEntityHelper2;
import su.catlean.client.services.player.TargetEntityHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.types.OptionMode15;

public class AutoSweetBerriesModule extends BlockPlacementModule {

    public static final AutoSweetBerriesModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 targetModeSetting;
    private static final VisibleVisibleSettingPropertyImpl directionsSetting;

    private AutoSweetBerriesModule() {
        super("auto-sweet-berries", SubCategoriesKt.getAttackCategory());
    }

    private AutoSweetBerriesTargetMode getTargetMode() {
        return (AutoSweetBerriesTargetMode) targetModeSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private void setTargetMode(AutoSweetBerriesTargetMode value) {
        targetModeSetting.setValue(this, DELEGATED_PROPERTIES[0], value);
    }

    private boolean getDirections() {
        return (Boolean) directionsSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private void setDirections(boolean value) {
        directionsSetting.setValue(this, DELEGATED_PROPERTIES[1], Boolean.valueOf(value));
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        PlayerEntity player = EntityPacketHelper.findTarget(this.getRange(), AutoCrystalTargetSortMode.FOV);
        if (this.getTargetMode() == AutoSweetBerriesTargetMode.AUTO) {
            if (AuraModule.INSTANCE.getEnabled() && AuraModule.INSTANCE.getTarget() != null && AuraModule.INSTANCE.getTarget() instanceof PlayerEntity) {
                player = (PlayerEntity) AuraModule.INSTANCE.getTarget();
            }
            if (AutoCrystalModule.INSTANCE.getEnabled() && AutoCrystalModule.INSTANCE.getTarget() != null) {
                player = AutoCrystalModule.INSTANCE.getTarget();
            }
            if (player == null || TargetEntityHelper.INSTANCE.checkCondition2(player)) {
                return;
            }
            this.executeAction(player);
        } else {
            Iterator iterator = SharedKt.getWorld().getPlayers().iterator();
            while (iterator.hasNext()) {
                AbstractClientPlayerEntity player2 = (AbstractClientPlayerEntity) iterator.next();
                if (Intrinsics.areEqual(player2, SharedKt.getMc().player) || EntityHelper4.isFriend((PlayerEntity) player2) || player2.distanceTo(SharedKt.getMc().player) > this.getRange() || TargetEntityHelper.INSTANCE.checkCondition2((PlayerEntity) player2)) {
                    continue;
                }
                this.executeAction((PlayerEntity) player2);
            }
        }
    }

    private void executeAction(long arg0, PlayerEntity arg1, short arg2) {
        List<BlockPos> positions = new ArrayList();
        BlockPos blockPos = BlockPos.ofFloored(PlayerEntityHelper2.INSTANCE.predictPosition(arg1, TargetEntityHelper.INSTANCE.getPredictTicks(arg1)));
        BlockState state = SharedKt.getWorld().getBlockState(blockPos);
        BlockState state2 = SharedKt.getWorld().getBlockState(blockPos.down());
        if (!(state2.getBlock() instanceof class_2372)) {
        }
        if (Intrinsics.areEqual(state2.getBlock(), Blocks.field_10566) && !(state.getBlock() instanceof FluidBlock)) {
            Entity entity = SharedKt.getMc().player;
            if (arg2 >= 0 && var24) {
                if (!(Intrinsics.areEqual(blockPos, BlockPos.ofFloored(this.resolveMinecraftObject(entity))))) {
                    positions.add(blockPos);
                }
            }
        }
        if (this.getDirections()) {
            Iterable var30 = (Iterable) ServiceComponent42.enumEntries;
            int var31 = 0;
            Object var32 = var30;
            Collection var33 = (Collection) new ArrayList();
            int var34 = 0;
            Iterator iterator = var32.iterator();
            while (iterator.hasNext()) {
                Object var36 = iterator.next();
                Direction var37 = (Direction) var36;
                int var38 = 0;
                if (arg2 > 0) {
                }
                var33.add();
            }
            Iterator iterator2 = var33.iterator();
            while (iterator2.hasNext()) {
                var30 = (Direction) iterator2.next();
                var31 = blockPos.offset();
                var32 = SharedKt.getWorld().getBlockState();
                var33 = SharedKt.getWorld().getBlockState(var31.down());
                if (arg0 >= 0L) {
                    if (var24) {
                    }
                    if (!(var33.getBlock() instanceof class_2372)) {
                        if (arg2 >= 0) {
                            if (var24) {
                            }
                        }
                    }
                    if (arg0 > 0L) {
                        if (var24) {
                            entity = SharedKt.getMc().player;
                        }
                    }
                    positions.add();
                }
            }
        }
        BlockPlacementModule.placeBlocks(this, positions);
    }

    protected List resolveList() {
        return CollectionsKt.listOf(Blocks.field_16999);
    }

    protected OptionMode15 getOptionMode15() {
        return OptionMode15.NONE;
    }

    static {
        KProperty[] var29 = new KProperty[2];
        INSTANCE = new AutoSweetBerriesModule();
        targetModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "target-mode", AutoSweetBerriesTargetMode.AUTO);
        directionsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "directions");
    }

}
