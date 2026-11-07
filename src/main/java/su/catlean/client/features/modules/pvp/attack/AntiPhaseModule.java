package su.catlean.client.features.modules.pvp.attack;

import java.util.ArrayList;
import java.util.Collection;
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
import net.minecraft.class_1533;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl7;
import su.catlean.api.setting.SettingGroup;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.BlockPlacementModule;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.player.EntityHelper4;
import su.catlean.client.services.player.TargetEntityHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.types.OptionMode14;
import su.catlean.client.types.OptionMode15;

public class AntiPhaseModule extends BlockPlacementModule {

    public static final AntiPhaseModule INSTANCE;
    private static final VisibleVisibleSettingPropertyImpl trapCrawlersSetting;
    private static final DefaultValueVisibleSettingPropertyImpl7 groupSetting;
    private static final VisibleVisibleSettingPropertyImpl laddersSetting;
    private static final VisibleVisibleSettingPropertyImpl vinesSetting;
    private static final VisibleVisibleSettingPropertyImpl framesSetting;
    private static final VisibleVisibleSettingPropertyImpl scaffoldingsSetting;

    private AntiPhaseModule() {
        super("anti-phase", SubCategoriesKt.getAttackCategory(), 0, false);
    }

    private boolean getTrapCrawlers() {
        return ((Boolean) trapCrawlersSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private SettingGroup getGroup() {
        return ((SettingGroup) groupSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private boolean getLadders() {
        return ((Boolean) laddersSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private boolean getVines() {
        return ((Boolean) vinesSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private boolean getFrames() {
        return ((Boolean) framesSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    private boolean getScaffoldings() {
        return ((Boolean) scaffoldingsSetting.getValue(this, DELEGATED_PROPERTIES[5]));
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        BlockPlacementModule.placeBlocks(this, this.resolveList(), false, false, null, false);
    }

    private List resolveList() {
        Iterable iterable = ((Iterable) SharedKt.getWorld().getPlayers());
        Iterable iterable2 = iterable;
        Collection collection = ((Collection) new ArrayList());
        Iterator iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            AbstractClientPlayerEntity player = ((AbstractClientPlayerEntity) element);
            collection.add(element);
        }
        iterable = ((Iterable) collection);
        iterable2 = iterable;
        collection = ((Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10)));
        iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            element = iterator.next();
            player = ((AbstractClientPlayerEntity) element);
            collection.add(BlockPos.ofFloored(INSTANCE.resolveMinecraftObject(player)));
        }
        return collection;
    }

    protected List resolveList2() {
        List list = new ArrayList();
        if (this.getScaffoldings()) {
            list.add(Blocks.field_16492.method_8389());
        }
        if (this.getLadders()) {
            list.add(Blocks.field_9983.method_8389());
        }
        if (this.getVines()) {
            list.add(Blocks.field_10597.method_8389());
        }
        if (this.getFrames()) {
            list.add(Items.field_8143);
        }
        return list;
    }

    private boolean checkCondition(char arg0, PlayerEntity arg1, short arg2, int arg3) {
        if (arg1.isAlive() && !(Intrinsics.areEqual(SharedKt.getPlayer(), arg1)) && !(arg1.method_5681())) {
            if (arg2 > 0 && __UNDEF_KEY__ != null) {
                if (EntityHelper4.isFriend(arg1)) {
                    return false;
                }
            }
        }
        if (!(SharedKt.getWorld().method_52569(arg1, arg1.method_5829().method_989(0.0D, 0.1D, 0.0D).method_1009(1.0D, 0.0D, 1.0D)))) {
            if (arg2 > 0) {
                if (__UNDEF_KEY__ != null) {
                    if (TargetEntityHelper.INSTANCE.resolveList(arg1).size() > 1) {
                        return false;
                    }
                }
            }
        }
        if (arg3 < 0 && __UNDEF_KEY__ != null) {
            if (this.checkCondition(new Box(BlockPos.ofFloored(this.resolveMinecraftObject(arg1).method_1031(0.0D, 0.3D, 0.0D))))) {
                return false;
            }
        }
        if (arg0 >= 0) {
            if (__UNDEF_KEY__ != null) {
                if (!(this.getTrapCrawlers()) && arg1.method_20448()) {
                    return false;
                }
            }
        }
        return SharedKt.getPlayer().distanceTo(arg1) <= (this.getRange() + 3.0F);
    }

    private boolean checkCondition(Box arg0) {
        Iterable iterable = SharedKt.getWorld().method_18112();
        Iterable iterable2 = iterable;
        Collection collection = ((Collection) new ArrayList());
        int index = 0;
        Iterator iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            collection.add(element);
        }
        iterable = ((Iterable) collection);
        if (iterable instanceof Collection && ((Collection) iterable).isEmpty()) {
        } else {
            iterable2 = iterable.iterator();
            while (iterable2.hasNext()) {
                collection = iterable2.next();
                index = ((class_1533) collection);
                iterator = 0;
            }
        }
        return false;
    }

    protected OptionMode15 getOptionMode15() {
        return OptionMode15.NONE;
    }

    static {
        KProperty[] items = new KProperty[6];
        INSTANCE = new AntiPhaseModule();
        trapCrawlersSetting = VisibleRenderHelper.registerSetting(INSTANCE, "trap-crawlers", false);
        groupSetting = VisibleRenderHelper.registerSetting(INSTANCE, "blocks", OptionMode14.BOOLS);
        laddersSetting = VisibleRenderHelper.registerSetting(INSTANCE, "ladders", true, INSTANCE.getGroup());
        vinesSetting = VisibleRenderHelper.registerSetting(INSTANCE, "vines", true, INSTANCE.getGroup());
        framesSetting = VisibleRenderHelper.registerSetting(INSTANCE, "frames", true, INSTANCE.getGroup());
        scaffoldingsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "scaffoldings", true, INSTANCE.getGroup());
    }

}
