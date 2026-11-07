package su.catlean.client.features.modules.pvp.attack;

import java.util.ArrayList;
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
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.client.features.modules.BlockPlacementModule;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EntityPacketHelper;
import su.catlean.client.services.player.EntityHelper4;
import su.catlean.client.services.player.PlayerEntityHelper2;
import su.catlean.client.services.player.TargetEntityHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.types.OptionMode15;

public class AutoWebModule extends BlockPlacementModule {

    public static final AutoWebModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 targetModeSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 faceSetting;

    private AutoWebModule() {
        super("auto-web", SubCategoriesKt.getAttackCategory(), 132, false);
    }

    private AutoWebTargetMode getTargetMode() {
        return ((AutoWebTargetMode) targetModeSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private void setTargetMode(AutoWebTargetMode value) {
        targetModeSetting.setValue(this, DELEGATED_PROPERTIES[0], value);
    }

    private AutoWebFaceMode getFace() {
        return ((AutoWebFaceMode) faceSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private void setFace(AutoWebFaceMode value) {
        faceSetting.setValue(this, DELEGATED_PROPERTIES[1], value);
    }

    public void onPlayerUpdateEvent(PlayerUpdateEvent e) {
        PlayerEntity player = EntityPacketHelper.findTarget(this.getRange(), AutoCrystalTargetSortMode.FOV, false, false);
        if (this.getTargetMode() == AutoWebTargetMode.AUTO) {
            if (AuraModule.INSTANCE.getEnabled() && AuraModule.INSTANCE.getTarget() != null && AuraModule.INSTANCE.getTarget() instanceof PlayerEntity) {
                player = ((PlayerEntity) AuraModule.INSTANCE.getTarget());
            }
            if (AutoCrystalModule.INSTANCE.getEnabled() && AutoCrystalModule.INSTANCE.getTarget() != null) {
                player = AutoCrystalModule.INSTANCE.getTarget();
            }
            if (player == null || TargetEntityHelper.INSTANCE.isSurroundedOrWebbed(player, this.getFace() != AutoWebFaceMode.OFF)) {
                return;
            }
            this.executeAction(player);
        } else {
            Iterator iterator = SharedKt.getWorld().getPlayers().iterator();
            while (iterator.hasNext()) {
                AbstractClientPlayerEntity player2 = ((AbstractClientPlayerEntity) iterator.next());
                if (Intrinsics.areEqual(player2, SharedKt.getMc().player) || EntityHelper4.isFriend(((PlayerEntity) player2)) || player2.distanceTo(SharedKt.getMc().player) > this.getRange() || TargetEntityHelper.INSTANCE.isSurroundedOrWebbed(((PlayerEntity) player2), this.getFace() != AutoWebFaceMode.OFF)) {
                    continue;
                }
                this.executeAction(((PlayerEntity) player2));
            }
        }
    }

    private void executeAction(PlayerEntity arg0) {
        List<BlockPos> list = new ArrayList();
        BlockPos blockPos = BlockPos.ofFloored(PlayerEntityHelper2.INSTANCE.predictPosition(arg0, TargetEntityHelper.INSTANCE.getPredictTicks(arg0)));
        if (this.getFace() != AutoWebFaceMode.ONLY && !(SharedKt.getWorld().getBlockState(blockPos).getBlock() instanceof FluidBlock)) {
            Entity entity = SharedKt.getMc().player;
            if (!(Intrinsics.areEqual(blockPos, BlockPos.ofFloored(this.resolveMinecraftObject(entity))))) {
                list.add(blockPos);
            }
        }
        if (this.getFace() != AutoWebFaceMode.OFF && !(SharedKt.getWorld().getBlockState(blockPos.up()).getBlock() instanceof FluidBlock) && !(Intrinsics.areEqual(blockPos.up(), BlockPos.ofFloored(SharedKt.getMc().player.getEyePos())))) {
            list.add(blockPos.up());
        }
        BlockPlacementModule.placeBlocks(this, list, false, false, null, false);
    }

    protected List resolveList() {
        return CollectionsKt.listOf(Blocks.COBWEB);
    }

    protected OptionMode15 getOptionMode15() {
        return OptionMode15.NONE;
    }

    static {
        KProperty[] items = new KProperty[2];
        INSTANCE = new AutoWebModule();
        targetModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "target-mode", AutoWebTargetMode.AUTO);
        faceSetting = VisibleRenderHelper.registerSetting(INSTANCE, "face", AutoWebFaceMode.INSTANCE);
    }

}
