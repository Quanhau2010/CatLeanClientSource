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
        boolean flag = Intrinsics.areEqual(SharedKt.getPlayer().method_6079().getItem(), Items.field_8288);
        StackServiceComponent2 stackServiceComponent2 = this.resolveStackServiceComponent2();
        if (!(stackServiceComponent2.isActive())) {
            return;
        }
        if (countValue > 0) {
            int index = countValue;
            countValue = (index + 1);
        }
        if (!(flag) && !(countValue)) {
            countValue2 = RangeServiceComponent.P(2, 4, false);
            index = countValue;
            countValue = (index + 1);
        }
        if (SharedKt.getMc().currentScreen != null && !(flag)) {
            index = ((SharedKt.getMc().method_22683().method_4486() / 2.0F) - 80.0F);
            int index2 = (SharedKt.getMc().method_22683().method_4502() / 2.0F);
            int index3 = (stackServiceComponent2.getNumericValue() % 9);
            int index4 = stackServiceComponent2.getNumericValue();
            int index5 = 9;
            int index6 = (index4 / index5);
            if ((index4 ^ index5) < 0 && (index6 * index5) != index4) {
            }
            int index7 = (index6 - 1);
            index4 = (index + (index3 * 20));
            index5 = (index2 + (index7 * 20));
            index6 = (POSITIONCOLORRenderHelper.INSTANCE.getNumericValue() + ((index4 - POSITIONCOLORRenderHelper.INSTANCE.getNumericValue()) * 0.6D));
            float factor = (POSITIONCOLORRenderHelper.INSTANCE.getNumericValue2() + ((index5 - POSITIONCOLORRenderHelper.INSTANCE.getNumericValue2()) * 0.6D));
            int index8 = SharedKt.getMc().method_22683().method_4495();
            class_3675.method_15984(SharedKt.getMc().method_22683(), 212993, (index6 * index8), (factor * index8));
            ((IMouse) SharedKt.getMc().field_1729).setPosition((index6 * index8), (factor * index8));
        }
        if (SharedKt.getMc().currentScreen == null) {
            SharedKt.getMc().method_1577().method_4912();
            SharedKt.getMc().method_1507(((Screen) new class_490(((PlayerEntity) SharedKt.getPlayer()))));
            countValue2 = (countValue2 + RangeServiceComponent.P(2, 4, false));
            EventPacketHelper2.INSTANCE.updateValue5();
        } else {
            HandServiceComponent.e(stackServiceComponent2.getNumericValue(), 40, class_1713.field_7791, false);
            RunnableServiceComponent2.executeAction(RangeServiceComponent.P(2, 4, false), 0, false, this::executeAction);
            countValue = 0;
        }
    }

    private StackServiceComponent2 resolveStackServiceComponent2() {
        List list = new ArrayList();
        int index = 36;
        if (-1 < index) {
            if (SharedKt.getMc().player != null && SharedKt.getMc().player.method_31548() != null) {
            } else {
                SharedKt.getMc().player.method_31548().method_5438(index);
            }
            if (__UNDEF_KEY__ != null) {
            } else {
                this.getItem();
            }
            if (Intrinsics.areEqual(null, Items.field_8288)) {
                if (index < 9) {
                } else {
                }
                int index2 = 1;
                list.add(new StackServiceComponent2(index, index2));
            }
        }
        if (!(((Collection) list).isEmpty())) {
            return ((StackServiceComponent2) CollectionsKt.random(((Collection) list), ((Random) Random.Default)));
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
