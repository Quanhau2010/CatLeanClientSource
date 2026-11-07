package su.catlean.client.features.modules.pvp.attack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.class_2502;
import net.minecraft.class_3965;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.BlockPlacementModule;
import su.catlean.client.services.client.RunnableServiceComponent;
import su.catlean.client.services.client.ServiceComponent113;
import su.catlean.client.services.client.ServiceComponent38;
import su.catlean.client.services.client.ServiceComponent47;
import su.catlean.client.services.client.StackServiceComponent2;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.network.VecPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;

public class AutoBasePlaceModule extends BlockPlacementModule {

    public static final AutoBasePlaceModule INSTANCE;
    private static final VisibleVisibleSettingPropertyImpl spongesSetting;
    private static final RangeVisibleSettingPropertyImpl spongeDelaySetting;
    private static final VisibleVisibleSettingPropertyImpl onlyNoPositionsSetting;
    private static final ServiceComponent38 serviceComponent38;
    private static final ServiceComponent38 serviceComponent382;
    private static class_3965 minecraftRef;
    private static BlockPos blockPos;

    private AutoBasePlaceModule() {
        super("auto-base-place", SubCategoriesKt.getAttackCategory());
    }

    private boolean getSponges() {
        return (Boolean) spongesSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private int getSpongeDelay() {
        return (Number) spongeDelaySetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private boolean getOnlyNoPositions() {
        return (Boolean) onlyNoPositionsSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (this.getSponges()) {
            Block[] var25 = new Block[1];
            var25[0] = Blocks.field_10258;
        } else {
        }
        boolean var24 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2().isActive();
        var25 = RunnableServiceComponent.INSTANCE;
        int var26 = 0;
        int var27 = 0;
        var25.getExecutorService().execute((Runnable) new ServiceComponent47());
        if (serviceComponent38.checkCondition(10)) {
            if (minecraftRef != null) {
                var27 = minecraftRef;
                int var28 = 0;
                BlockPlacementModule.placeBlocks(INSTANCE, CollectionsKt.listOf(var27.method_17777()));
                blockPos = var27.method_17777();
                serviceComponent38.updateValue();
            } else {
            }
        }
        var25 = SharedKt.getWorld().getBlockState(blockPos.up());
        var26 = (Iterable) ServiceComponent113.enumEntries;
        var27 = 0;
        if (var26 instanceof Collection && (Collection) var26.isEmpty()) {
        } else {
            var28 = var26.iterator();
            if (var28.hasNext()) {
                Object var29 = var28.next();
                Direction var30 = (Direction) var29;
                int var31 = 0;
            } else {
            }
        }
        if (!(AutoCrystalModule.INSTANCE.getEnabled()) || AutoCrystalModule.INSTANCE.getTarget() == null || !(var24) || blockPos == null || !(serviceComponent382.checkCondition(this.getSpongeDelay())) || var25.method_26215() || !(var25.method_45474()) || 0) {
            return;
        }
        var27 = (Iterable) ServiceComponent113.enumEntries;
        var28 = 0;
        var29 = var27;
        var30 = (Collection) new ArrayList();
        var31 = 0;
        Iterator iterator = var29.iterator();
        while (iterator.hasNext()) {
            Object var33 = iterator.next();
            Direction var34 = (Direction) var33;
            int var35 = 0;
            var30.add();
        }
        var26 = var30.iterator();
        var27 = (Direction) var26.next();
        var28 = blockPos.offset();
        BlockPlacementModule.placeBlocks(this, CollectionsKt.listOf(), 0, 0, CollectionsKt.listOf(Blocks.field_10258));
        serviceComponent382.updateValue();
    }

    public boolean checkCondition(BlockPos pos) {
        if (VecPacketHelper.INSTANCE.checkCondition(pos, this.getInteract(), this.getOptionMode15(), this.getRange(), this.getWallRange()) != null) {
        }
        return null;
    }

    protected List resolveList() {
        return CollectionsKt.listOf(Blocks.OBSIDIAN);
    }

    private static boolean isActive() {
        return INSTANCE.getSponges();
    }

    public static void updateValue(class_3965 value) {
        minecraftRef = value;
    }

    public static boolean checkCondition(AutoBasePlaceModule $this) {
        return $this.getOnlyNoPositions();
    }

    static {
        KProperty[] var31 = new KProperty[3];
        INSTANCE = new AutoBasePlaceModule();
        spongesSetting = VisibleRenderHelper.registerSetting(INSTANCE, "sponges");
        spongeDelaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "sponge-delay", 10, new IntRange(0, 60), null, this::isActive);
        onlyNoPositionsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "only-no-positions");
        serviceComponent38 = new ServiceComponent38();
        serviceComponent382 = new ServiceComponent38();
    }

}
