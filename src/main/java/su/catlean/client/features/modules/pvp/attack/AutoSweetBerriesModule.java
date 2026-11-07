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
        super("auto-sweet-berries", SubCategoriesKt.getAttackCategory(), 0, false);
    }

    private AutoSweetBerriesTargetMode getTargetMode() {
        return ((AutoSweetBerriesTargetMode) targetModeSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private void setTargetMode(AutoSweetBerriesTargetMode value) {
        targetModeSetting.setValue(this, DELEGATED_PROPERTIES[0], value);
    }

    private boolean getDirections() {
        return ((Boolean) directionsSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private void setDirections(boolean value) {
        directionsSetting.setValue(this, DELEGATED_PROPERTIES[1], Boolean.valueOf(value));
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        PlayerEntity player = EntityPacketHelper.findTarget(this.getRange(), AutoCrystalTargetSortMode.FOV, false, false);
        if (this.getTargetMode() == AutoSweetBerriesTargetMode.AUTO) {
            if (AuraModule.INSTANCE.getEnabled() && AuraModule.INSTANCE.getTarget() != null && AuraModule.INSTANCE.getTarget() instanceof PlayerEntity) {
                player = ((PlayerEntity) AuraModule.INSTANCE.getTarget());
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
                AbstractClientPlayerEntity player2 = ((AbstractClientPlayerEntity) iterator.next());
                if (Intrinsics.areEqual(player2, SharedKt.getMc().player) || EntityHelper4.isFriend(((PlayerEntity) player2)) || player2.distanceTo(SharedKt.getMc().player) > this.getRange() || TargetEntityHelper.INSTANCE.checkCondition2(((PlayerEntity) player2))) {
                    continue;
                }
                this.executeAction(((PlayerEntity) player2));
            }
        }
    }

    private void executeAction(long arg0, PlayerEntity arg1, short arg2) {
        List<BlockPos> list = new ArrayList();
        BlockPos blockPos = BlockPos.ofFloored(PlayerEntityHelper2.INSTANCE.predictPosition(arg1, TargetEntityHelper.INSTANCE.getPredictTicks(arg1)));
        BlockState state = SharedKt.getWorld().getBlockState(blockPos);
        BlockState state2 = SharedKt.getWorld().getBlockState(blockPos.down());
        if (!(state2.getBlock() instanceof class_2372)) {
        }
        if (Intrinsics.areEqual(state2.getBlock(), Blocks.field_10566) && !(state.getBlock() instanceof FluidBlock)) {
            Entity entity = SharedKt.getMc().player;
            if (arg2 >= 0 && __UNDEF_KEY__) {
                if (!(Intrinsics.areEqual(blockPos, BlockPos.ofFloored(this.resolveMinecraftObject(entity))))) {
                    list.add(blockPos);
                }
            }
        }
        if (this.getDirections()) {
            Iterable iterable = ((Iterable) ServiceComponent42.enumEntries);
            int index = 0;
            Iterable iterable2 = iterable;
            Collection collection = ((Collection) new ArrayList());
            Iterator iterator = iterable2.iterator();
            while (iterator.hasNext()) {
                Object element = iterator.next();
                Direction direction = ((Direction) element);
                if (arg2 > 0) {
                }
                collection.add(element);
            }
            Iterator iterator2 = collection.iterator();
            while (iterator2.hasNext()) {
                iterable = ((Direction) iterator2.next());
                index = blockPos.offset(iterable);
                iterable2 = SharedKt.getWorld().getBlockState(index);
                collection = SharedKt.getWorld().getBlockState(index.down());
                if (arg0 >= 0L) {
                    if (__UNDEF_KEY__) {
                        if (!(collection.getBlock() instanceof class_2372)) {
                            if (arg2 >= 0) {
                                if (__UNDEF_KEY__) {
                                }
                            }
                        }
                        if (arg0 > 0L) {
                            if (__UNDEF_KEY__) {
                                entity = SharedKt.getMc().player;
                            }
                        }
                        list.add(index);
                    }
                }
            }
        }
        BlockPlacementModule.placeBlocks(this, list, false, false, null, false);
    }

    protected List resolveList() {
        return CollectionsKt.listOf(Blocks.field_16999);
    }

    protected OptionMode15 getOptionMode15() {
        return OptionMode15.NONE;
    }

    static {
        KProperty[] items = new KProperty[2];
        INSTANCE = new AutoSweetBerriesModule();
        targetModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "target-mode", AutoSweetBerriesTargetMode.AUTO);
        directionsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "directions", false);
    }

}
