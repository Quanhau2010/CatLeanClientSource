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
        super("anti-phase", SubCategoriesKt.getAttackCategory());
    }

    private boolean getTrapCrawlers() {
        return (Boolean) trapCrawlersSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private SettingGroup getGroup() {
        return (SettingGroup) groupSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private boolean getLadders() {
        return (Boolean) laddersSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private boolean getVines() {
        return (Boolean) vinesSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private boolean getFrames() {
        return (Boolean) framesSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    private boolean getScaffoldings() {
        return (Boolean) scaffoldingsSetting.getValue(this, DELEGATED_PROPERTIES[5]);
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        BlockPlacementModule.placeBlocks(this, this.resolveList());
    }

    private List resolveList() {
        Iterable var12 = (Iterable) SharedKt.getWorld().getPlayers();
        int var13 = 0;
        Object var14 = var12;
        Collection var15 = (Collection) new ArrayList();
        int var16 = 0;
        Iterator iterator = var14.iterator();
        while (iterator.hasNext()) {
            Object var18 = iterator.next();
            AbstractClientPlayerEntity player = (AbstractClientPlayerEntity) var18;
            int var20 = 0;
            var15.add();
        }
        var12 = (Iterable) var15;
        var13 = 0;
        var14 = var12;
        var15 = (Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(10));
        var16 = 0;
        iterator = var14.iterator();
        while (iterator.hasNext()) {
            var18 = iterator.next();
            player = (AbstractClientPlayerEntity) var18;
            Object var21 = var15;
            var20 = 0;
            var21.add(BlockPos.ofFloored(INSTANCE.resolveMinecraftObject(player)));
        }
        return var15;
    }

    protected List resolveList2(long arg0) {
        long var3 = (arg0 ^ 57655682716551L);
        long var5 = ((arg0 ^ 129341789484699L) >>> 48);
        long var6 = (((arg0 ^ 129341789484699L) << 16) >>> 48);
        long var7 = (((arg0 ^ 129341789484699L) << 32) >>> 32);
        long var8 = ((arg0 ^ 40697395733575L) >>> 32);
        long var9 = (((arg0 ^ 40697395733575L) << 32) >>> 48);
        long var10 = (((arg0 ^ 40697395733575L) << 48) >>> 48);
        long var11 = (arg0 ^ 129300603557785L);
        List positions = new ArrayList();
        if (this.getScaffoldings()) {
            positions.add(Blocks.field_16492.method_8389());
        }
        if (arg0 > 0L) {
            if (var13 != null) {
                if (this.getLadders()) {
                    positions.add(Blocks.field_9983.method_8389());
                }
            }
        }
        if (arg0 > 0L && var13 != null) {
            if (this.getVines()) {
                positions.add(Blocks.field_10597.method_8389());
            }
        }
        if (this.getFrames()) {
            positions.add(Items.field_8143);
        }
        if (arg0 > 0L) {
        }
        return positions;
    }

    private boolean checkCondition(char arg0, PlayerEntity arg1, short arg2, int arg3) {
        if (arg1.isAlive() && !(Intrinsics.areEqual(SharedKt.getPlayer(), arg1)) && !(arg1.method_5681())) {
            if (arg2 > 0 && var26 != null) {
                if (EntityHelper4.isFriend(arg1)) {
                }
                return false;
            }
        }
        if (!(SharedKt.getWorld().method_52569(arg1, arg1.method_5829().method_989(0.0D, 0.1D, 0.0D).method_1009(1.0D, 0.0D, 1.0D)))) {
            if (arg2 > 0) {
                if (var26 != null) {
                    if (TargetEntityHelper.INSTANCE.resolveList(arg1).size() > 1) {
                    }
                    return false;
                }
            }
        }
        if (arg3 < 0 && var26 != null) {
            if (this.checkCondition(new Box(BlockPos.ofFloored(this.resolveMinecraftObject(arg1).method_1031(0.0D, 0.3D, 0.0D))))) {
                return false;
            }
        }
        if (arg0 >= 0) {
            if (var26 != null) {
                if (!(this.getTrapCrawlers()) && arg1.method_20448()) {
                    return false;
                }
            }
        }
        return SharedKt.getPlayer().distanceTo(arg1) <= (this.getRange() + 3.0F);
    }

    private boolean checkCondition(Box arg0) {
        Iterable var7 = SharedKt.getWorld().method_18112();
        int var8 = 0;
        Object var9 = var7;
        Collection var10 = (Collection) new ArrayList();
        int var11 = 0;
        Iterator iterator = var9.iterator();
        while (iterator.hasNext()) {
            Object var13 = iterator.next();
            var10.add();
        }
        var7 = (Iterable) var10;
        var8 = 0;
        if (var7 instanceof Collection && (Collection) var7.isEmpty()) {
        } else {
            var9 = var7.iterator();
            if (var9.hasNext()) {
                var10 = var9.next();
                var11 = (class_1533) var10;
                iterator = 0;
            } else {
            }
        }
        return false;
    }

    protected OptionMode15 getOptionMode15() {
        return OptionMode15.NONE;
    }

    static {
        KProperty[] var31 = new KProperty[6];
        INSTANCE = new AntiPhaseModule();
        trapCrawlersSetting = VisibleRenderHelper.registerSetting(INSTANCE, "trap-crawlers");
        groupSetting = VisibleRenderHelper.registerSetting(INSTANCE, "blocks", OptionMode14.BOOLS);
        laddersSetting = VisibleRenderHelper.registerSetting(INSTANCE, "ladders", 1, INSTANCE.getGroup());
        vinesSetting = VisibleRenderHelper.registerSetting(INSTANCE, "vines", 1, INSTANCE.getGroup());
        framesSetting = VisibleRenderHelper.registerSetting(INSTANCE, "frames", 1, INSTANCE.getGroup());
        scaffoldingsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "scaffoldings", 1, INSTANCE.getGroup());
    }

}
