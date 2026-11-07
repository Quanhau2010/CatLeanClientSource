package su.catlean.client.features.modules.pvp.legit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import net.minecraft.class_1041;
import net.minecraft.class_1156;
import net.minecraft.class_1661;
import net.minecraft.class_1713;
import net.minecraft.class_3675;
import net.minecraft.class_490;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.HandServiceComponent;
import su.catlean.client.services.client.RangeServiceComponent;
import su.catlean.client.services.client.RunnableServiceComponent2;
import su.catlean.client.services.client.StackServiceComponent;
import su.catlean.client.services.client.StackServiceComponent2;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.render.POSITIONCOLORRenderHelper;
import su.catlean.interfaces.IMouse;

public class LegitTotemModule extends Module {

    public static final LegitTotemModule INSTANCE;
    private static int countValue;
    private static int countValue2;

    private LegitTotemModule() {
        super("legit-totem", SubCategoriesKt.getLegitCategory());
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        boolean var19 = Intrinsics.areEqual(SharedKt.getPlayer().method_6079().getItem(), Items.field_8288);
        StackServiceComponent2 var20 = this.resolveStackServiceComponent2();
        if (!(var20.isActive())) {
            return;
        }
        if (countValue > 0) {
            int var21 = countValue;
            countValue = (var21 + 1);
        }
        if (!(var19) && !(countValue)) {
            countValue2 = RangeServiceComponent.P();
            var21 = countValue;
            countValue = (var21 + 1);
        }
        if (SharedKt.getMc().currentScreen != null && !(var19)) {
            var21 = ((SharedKt.getMc().method_22683().method_4486() / 2.0F) - 80.0F);
            int var22 = (SharedKt.getMc().method_22683().method_4502() / 2.0F);
            int var23 = (var20.getNumericValue() % 9);
            int var25 = var20.getNumericValue();
            int var26 = 9;
            int var27 = (var25 / var26);
            if ((var25 ^ var26) < 0 && (var27 * var26) != var25) {
            }
            int var24 = (var27 - 1);
            var25 = (var21 + (var23 * 20));
            var26 = (var22 + (var24 * 20));
            var27 = (POSITIONCOLORRenderHelper.INSTANCE.getNumericValue() + ((var25 - POSITIONCOLORRenderHelper.INSTANCE.getNumericValue()) * 0.6D));
            float var29 = (POSITIONCOLORRenderHelper.INSTANCE.getNumericValue2() + ((var26 - POSITIONCOLORRenderHelper.INSTANCE.getNumericValue2()) * 0.6D));
            int var31 = SharedKt.getMc().method_22683().method_4495();
            class_3675.method_15984(SharedKt.getMc().method_22683(), 212993, (var27 * var31), (var29 * var31));
            (IMouse) SharedKt.getMc().field_1729.setPosition((var27 * var31), (var29 * var31));
        }
        if (SharedKt.getMc().currentScreen == null) {
            SharedKt.getMc().method_1577().method_4912();
            SharedKt.getMc().method_1507((Screen) new class_490((PlayerEntity) SharedKt.getPlayer()));
            countValue2 = (countValue2 + RangeServiceComponent.P());
            EventPacketHelper2.INSTANCE.updateValue5();
        } else {
            HandServiceComponent.e(var20.getNumericValue(), 40, class_1713.field_7791);
            RunnableServiceComponent2.executeAction(RangeServiceComponent.P(), 0, 0, this::executeAction);
            countValue = 0;
        }
    }

    private StackServiceComponent2 resolveStackServiceComponent2() {
        List positions = new ArrayList();
        int var12 = 36;
        if (-1 < var12) {
            if (SharedKt.getMc().player != null && SharedKt.getMc().player.method_31548() != null) {
            } else {
                SharedKt.getMc().player.method_31548().method_5438();
            }
            if (var13 != null) {
            } else {
                var13.getItem();
            }
            if (Intrinsics.areEqual(null, Items.field_8288)) {
                if (var12 < 9) {
                } else {
                }
                Object var7 = var13;
                int var8 = 1;
                int var9 = var12;
                (var12 + 36).<init>();
            }
        }
        if (!((Collection) positions.isEmpty())) {
            return (StackServiceComponent2) CollectionsKt.random((Collection) positions, (Random) Random.Default);
        }
        return StackServiceComponent2.stackServiceComponent.getStackServiceComponent2();
    }

    private static void executeAction() {
        SharedKt.getPlayer().method_3137();
        SharedKt.getPlayer().method_7346();
        SharedKt.getMc().method_1507(null);
        EventPacketHelper2.INSTANCE.updateValue6();
    }

    static {
        INSTANCE = new LegitTotemModule();
    }

}
