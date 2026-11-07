package su.catlean.client.features.modules.utility.player;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.class_2323;
import net.minecraft.class_2349;
import net.minecraft.class_2354;
import net.minecraft.class_2449;
import net.minecraft.class_2533;
import net.minecraft.class_3965;
import net.minecraft.class_4850;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.InteractBlockEvent;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.VecPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;

public class NoInteractModule extends Module {

    public static final NoInteractModule INSTANCE;
    private static final VisibleVisibleSettingPropertyImpl allBlocksSetting;

    private NoInteractModule() {
        super("no-interact", SubCategoriesKt.getPlayerUtilityCategory());
    }

    private boolean getAllBlocks() {
        return ((Boolean) allBlocksSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private void onInteractBlockEvent(InteractBlockEvent arg0) {
        Block block = SharedKt.getWorld().getBlockState(arg0.getHitResult().method_17777()).getBlock();
        if (!(this.getAllBlocks()) && !(VecPacketHelper.INSTANCE.checkCondition(block)) && !(block instanceof class_2354) && !(block instanceof class_2349) && !(block instanceof class_2533) && !(block instanceof class_2323) && !(block instanceof class_4850)) {
            if (block instanceof class_2449) {
                arg0.cancel();
            }
        }
        if (Intrinsics.areEqual(SharedKt.getPlayer().method_6079().getItem(), Items.field_8575)) {
            if (arg0.getHand() != Hand.field_5810) {
            }
        }
        arg0.cancel();
    }

    static {
        KProperty[] items = new KProperty[1];
        INSTANCE = new NoInteractModule();
        allBlocksSetting = VisibleRenderHelper.registerSetting(INSTANCE, "all-blocks", false);
    }

}
