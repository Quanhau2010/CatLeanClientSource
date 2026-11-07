package su.catlean.client.features.modules.utility.equip;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1661;
import net.minecraft.class_1713;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.HandServiceComponent;
import su.catlean.client.services.client.ServiceComponent38;
import su.catlean.client.services.client.StackServiceComponent2;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.render.CatleanInterfaceRenderHelper;
import su.catlean.client.services.render.CatleanWidgetEditorRenderHelper;
import su.catlean.client.ui.clickgui.CatleanPanelScreenGuiElement;

public class ReFillerModule extends Module {

    public static final ReFillerModule INSTANCE;
    private static final ServiceComponent38 serviceComponent38;
    private static int countValue;
    private static int countValue2;

    private ReFillerModule() {
        super("re-filler", SubCategoriesKt.getEquipCategory());
    }

    public int getNumericValue() {
        return countValue;
    }

    public void updateValue(int value) {
        countValue = value;
    }

    public int getNumericValue2() {
        return countValue2;
    }

    public void updateValue2(int value) {
        countValue2 = value;
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (SharedKt.getMc().currentScreen != null && !(SharedKt.getMc().currentScreen instanceof CatleanInterfaceRenderHelper) && !(SharedKt.getMc().currentScreen instanceof CatleanPanelScreenGuiElement) && !(SharedKt.getMc().currentScreen instanceof CatleanWidgetEditorRenderHelper)) {
            countValue = 0;
            return;
        }
        if (Intrinsics.areEqual(SharedKt.getPlayer().method_6047().getItem(), Items.field_8288)) {
            countValue = 3;
            countValue2 = SharedKt.getPlayer().method_31548().method_67532();
        } else {
            if (countValue > 0) {
                if (!(Intrinsics.areEqual(SharedKt.getPlayer().method_31548().method_5438(countValue2).getItem(), Items.field_8288))) {
                    Item[] var20 = new Item[1];
                    var20[0] = Items.field_8288;
                    StackServiceComponent2 var19 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2();
                    if (var19.isActive()) {
                        HandServiceComponent.executeAction(var19.getNumericValue(), countValue2, class_1713.field_7791, 1);
                        countValue = 0;
                    }
                }
                var19 = countValue;
                countValue = (var19 + -1);
            }
        }
        if (!(serviceComponent38.checkCondition(10))) {
            return;
        }
        var19 = 0;
        if (this.checkCondition()) {
            return;
        }
    }

    private boolean checkCondition(int arg0, long arg1) {
        ItemStack stack = SharedKt.getPlayer().method_31548().method_5438(arg0);
        if (!(stack.isEmpty())) {
            if (!(stack.method_7946())) {
            }
            return false;
        }
        if (stack.method_7914() == 16 && stack.method_7947() > 8) {
            return false;
        }
        if (stack.method_7914() == 64 && stack.method_7947() > 32) {
            return false;
        }
        int var21 = 9;
        if (var21 < 36) {
            ItemStack stack2 = SharedKt.getPlayer().method_31548().method_5438();
            if (!(stack2.isEmpty())) {
                if (!(this.checkCondition(stack, stack2))) {
                } else {
                    boolean var23 = (stack2.method_7947() + stack.method_7947()) > stack2.method_7914();
                    if (stack2.method_7914() == stack2.method_7947()) {
                        HandServiceComponent.executeAction(arg0, class_1713.field_7791, 1);
                    } else {
                        HandServiceComponent.e();
                        if (arg0 < 9) {
                        } else {
                        }
                        int var15 = 6;
                        boolean var16 = !(var23);
                        int var18 = 0;
                        HandServiceComponent.e(arg0);
                        if (var23) {
                            HandServiceComponent.e();
                        }
                    }
                    serviceComponent38.updateValue();
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkCondition(ItemStack arg0, ItemStack arg1) {
        return Intrinsics.areEqual(arg0.method_7964(), arg1.method_7964());
    }

    static {
        INSTANCE = new ReFillerModule();
        serviceComponent38 = new ServiceComponent38();
    }

}
