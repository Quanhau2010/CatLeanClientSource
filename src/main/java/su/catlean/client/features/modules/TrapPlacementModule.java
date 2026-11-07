package su.catlean.client.features.modules;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import su.catlean.SharedKt;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl3;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.services.client.BlocksServiceComponent;
import su.catlean.client.services.client.ServiceComponent44;
import su.catlean.client.services.client.module.category.SubCategory;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.network.VecPacketHelper;
import su.catlean.client.services.player.ExplosionPosEntityHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.tools.comparators.Comparator13;
import su.catlean.client.tools.comparators.Comparator22;
import su.catlean.client.types.OptionMode15;

public class TrapPlacementModule extends BlockPlacementModule {

    private final DefaultValueVisibleSettingPropertyImpl3 selectedBlocksSetting;
    private final VisibleVisibleSettingPropertyImpl onlyStandingSetting;
    private static String textValue;

    public TrapPlacementModule(String id, SubCategory category) {
        super(id, category, 131, 1);
        Block[] var18 = new Block[1];
        var18[0] = Blocks.OBSIDIAN;
        int var14 = 12;
        BlocksServiceComponent var17 = new BlocksServiceComponent(CollectionsKt.mutableListOf());
        this.selectedBlocksSetting = VisibleRenderHelper.registerSetting(this, "blocks");
        this.onlyStandingSetting = VisibleRenderHelper.registerSetting(this, "only-standing");
    }

    private BlocksServiceComponent getSelectedBlocks() {
        return (BlocksServiceComponent) this.selectedBlocksSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private void setSelectedBlocks(BlocksServiceComponent value) {
        this.selectedBlocksSetting.setValue(this, DELEGATED_PROPERTIES[0], value);
    }

    public boolean getOnlyStanding() {
        return (Boolean) this.onlyStandingSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    public void executeAction(PlayerEntity target) {
        if (Intrinsics.areEqual(target, SharedKt.getPlayer()) && SharedKt.getPlayer().method_20232() && this.getOnlyStanding()) {
            return;
        }
        double[] var21 = EventPacketHelper2.process(0.5F, 1, 0.0F, 0.0F, 0.0F);
        double var22 = target.method_5829().field_1323;
        double var24 = target.method_5829().field_1322;
        double var26 = target.method_5829().field_1321;
        double var28 = target.method_5829().field_1320;
        double var30 = target.method_5829().field_1325;
        double var32 = target.method_5829().field_1324;
        if (!(target.isOnGround())) {
            target.method_5857(new Box((var30 - 0.5F)));
        }
        List positions = CollectionsKt.toList((Iterable) this.resolveList(BlockPos.ofFloored(this.resolveMinecraftObject(target)), (Set) new LinkedHashSet()));
        if (Intrinsics.areEqual(target, SharedKt.getPlayer())) {
            Iterable var35 = (Iterable) positions;
            int var36 = 0;
        } else {
            var35 = (Iterable) positions;
            var36 = 0;
        }
        positions = CollectionsKt.sortedWith((Comparator) new Comparator22());
        if (0L < 0) {
            BlockPlacementModule.placeBlocks(this, positions);
        }
        target.method_5857(new Box());
    }

    protected boolean checkCondition(Entity crystal) {
        long var4 = ((0L ^ 75096564203215L) >>> 56);
        long var5 = (((0L ^ 75096564203215L) << 8) >>> 8);
        long var7 = (0L ^ 124027046021740L);
        long var9 = (0L ^ 42888259370702L);
        return (ExplosionPosEntityHelper.computeValue(this.resolveMinecraftObject(crystal), (PlayerEntity) SharedKt.getPlayer()) + 4.0F) < (SharedKt.getPlayer().method_6032() + SharedKt.getPlayer().method_6067());
    }

    private List resolveList(BlockPos arg0, Set arg1) {
        List positions = new ArrayList();
        Iterator iterator = ServiceComponent44.enumEntries.iterator();
        while (iterator.hasNext()) {
            Direction var22 = (Direction) iterator.next();
            BlockPos blockPos = arg0.offset();
            BlockState state = SharedKt.getWorld().getBlockState(blockPos);
            if (arg1.contains(blockPos) || !(state.method_45474())) {
                continue;
            }
            arg1.add(blockPos);
            if (this.checkCondition(blockPos)) {
                positions.addAll((Collection) this.resolveList(blockPos, arg1));
            }
            Iterable var27 = (Iterable) ServiceComponent44.enumEntries;
            int var28 = 0;
            Collection var30 = (Collection) new ArrayList();
            int var31 = 0;
            Iterator iterator2 = var29.iterator();
            while (iterator2.hasNext()) {
                Object var33 = iterator2.next();
                Direction var34 = (Direction) var33;
                int var35 = 0;
                var30.add();
            }
            Iterator iterator3 = var30.iterator();
            while (iterator3.hasNext()) {
            }
            var27 = (Direction) iterator3.next();
            var28 = blockPos.offset();
            if (!(SharedKt.getWorld().getBlockState().method_45474())) {
            }
            arg1.add();
            positions.add();
            positions.add(blockPos);
            positions.add(blockPos);
        }
        return positions;
    }

    protected List resolveList(long arg0) {
        long var3 = (arg0 ^ 139471251167438L);
        return this.getSelectedBlocks().getList();
    }

    static {
        KProperty[] var22 = new KProperty[2];
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
