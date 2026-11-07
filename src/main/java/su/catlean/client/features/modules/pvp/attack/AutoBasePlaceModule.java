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
        super("auto-base-place", SubCategoriesKt.getAttackCategory(), 0, false);
    }

    private boolean getSponges() {
        return ((Boolean) spongesSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private int getSpongeDelay() {
        return ((Number) spongeDelaySetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private boolean getOnlyNoPositions() {
        return ((Boolean) onlyNoPositionsSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (this.getSponges()) {
            Block[] items = new Block[1];
            items[0] = Blocks.field_10258;
        } else {
            boolean flag = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(items).isActive();
        }
        items = RunnableServiceComponent.INSTANCE;
        int index = 0;
        int index2 = 0;
        items.getExecutorService().execute(((Runnable) new ServiceComponent47(index, flag)));
        if (serviceComponent38.checkCondition(10)) {
            if (minecraftRef != null) {
                index2 = minecraftRef;
                int index3 = 0;
                BlockPlacementModule.placeBlocks(INSTANCE, CollectionsKt.listOf(index2.method_17777()), false, false, null, false);
                blockPos = index2.method_17777();
                serviceComponent38.updateValue();
            } else {
            }
        }
        items = SharedKt.getWorld().getBlockState(blockPos.up());
        index = ((Iterable) ServiceComponent113.enumEntries);
        index2 = 0;
        if (index instanceof Collection && ((Collection) index).isEmpty()) {
        } else {
            index3 = index.iterator();
            while (index3.hasNext()) {
                Object element = index3.next();
                Direction direction = ((Direction) element);
            }
        }
        if (!(AutoCrystalModule.INSTANCE.getEnabled()) || AutoCrystalModule.INSTANCE.getTarget() == null || !(flag) || blockPos == null || !(serviceComponent382.checkCondition(this.getSpongeDelay())) || items.method_26215() || !(items.method_45474()) || 0) {
            return;
        }
        index2 = ((Iterable) ServiceComponent113.enumEntries);
        index3 = 0;
        element = index2;
        direction = ((Collection) new ArrayList());
        Iterator iterator = element.iterator();
        while (iterator.hasNext()) {
            Object element2 = iterator.next();
            Direction direction2 = ((Direction) element2);
            direction.add(element2);
        }
        index = direction.iterator();
        while (index.hasNext()) {
            index2 = ((Direction) index.next());
            index3 = blockPos.offset(index2);
            BlockPlacementModule.placeBlocks(this, CollectionsKt.listOf(index3), false, false, CollectionsKt.listOf(Blocks.field_10258), false);
            serviceComponent382.updateValue();
        }
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
        KProperty[] items = new KProperty[3];
        INSTANCE = new AutoBasePlaceModule();
        spongesSetting = VisibleRenderHelper.registerSetting(INSTANCE, "sponges", false);
        spongeDelaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "sponge-delay", 10, new IntRange(0, 60), null, this::isActive);
        onlyNoPositionsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "only-no-positions", false);
        serviceComponent38 = new ServiceComponent38();
        serviceComponent382 = new ServiceComponent38();
    }

}
