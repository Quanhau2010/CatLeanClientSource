package su.catlean.client.features.modules.pvp.legit;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.HandServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.VisibleRenderHelper;

public class BowSpamModule extends Module {

    public static final BowSpamModule INSTANCE;
    private static final RangeVisibleSettingPropertyImpl delaySetting;

    private BowSpamModule() {
        super("bow-spam", SubCategoriesKt.getLegitCategory());
    }

    private int getDelay() {
        return (Number) delaySetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        ClientPlayerEntity player = SharedKt.getPlayer();
        int var15 = 0;
        if (!(Intrinsics.areEqual(player.method_6079().getItem(), Items.field_8102))) {
        }
        if (Intrinsics.areEqual(player.method_6047().getItem(), Items.field_8102) && player.method_6115() && player.method_6048() >= INSTANCE.getDelay()) {
            SharedKt.getInteractionManager().method_2897((PlayerEntity) SharedKt.getPlayer());
            HandServiceComponent.K(Hand.field_5808, 0.0F, 0.0F);
            player.method_6075();
        }
    }

    static {
        KProperty[] var26 = new KProperty[1];
        INSTANCE = new BowSpamModule();
        delaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "delay", 3, new IntRange(0, 20));
    }

}
