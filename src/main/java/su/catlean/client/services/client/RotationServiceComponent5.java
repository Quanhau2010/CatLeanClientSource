package su.catlean.client.services.client;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.minecraft.class_1320;
import net.minecraft.class_1322;
import net.minecraft.class_1661;
import net.minecraft.class_1703;
import net.minecraft.class_1713;
import net.minecraft.class_476;
import net.minecraft.class_495;
import net.minecraft.class_6880;
import net.minecraft.class_9274;
import net.minecraft.class_9285;
import net.minecraft.class_9285.class_9287;
import net.minecraft.class_9323;
import net.minecraft.class_9336;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.ItemStack;
import su.catlean.SharedKt;
import su.catlean.api.contracts.Contract2;
import su.catlean.client.features.modules.movement.basic.GuiMoveModule;
import su.catlean.client.features.modules.pvp.attack.AuraModule;
import su.catlean.client.features.modules.pvp.protect.OffhandModule;
import su.catlean.client.services.network.EventPacketHelper2;

public class RotationServiceComponent5 implements Contract2 {

    public static final RotationServiceComponent5 INSTANCE;
    private static Function0 function0;
    private static Function0 function02;

    private RotationServiceComponent5() {
    }

    public Function0 getFunction0() {
        return function0;
    }

    public void executeAction(Function0 value) {
        function0 = value;
    }

    public Function0 getFunction02() {
        return function02;
    }

    public void executeAction(Function0 value) {
        function02 = value;
    }

    public void executeAction() {
    }

    public void executeAction(MoveFixServiceComponent rotation) {
        function02.invoke();
        function02 = this::getUnit3;
        OffhandModule.INSTANCE.updateValue(1);
        EventPacketHelper2.INSTANCE.updateValue6();
    }

    public void updateValue() {
    }

    public void updateValue() {
        int index = this.computeValue();
        boolean flag = !(SharedKt.getMc().currentScreen instanceof class_476);
        EventPacketHelper2.INSTANCE.updateValue5();
        RunnableServiceComponent2.executeAction(2, 0, false, this::executeAction2);
        if (index < 9) {
        } else {
        }
        Function0 function0 = this::resolveUnit;
        function0 = function0;
        function02 = function0;
    }

    public int computeValue() {
        int index = -1;
        double offset = 0.0D;
        int index2 = 0;
        if (index2 < 37) {
            if (index2 == 36) {
                Iterator iterator = SharedKt.getPlayer().method_6079().method_57353().iterator();
                while (iterator.hasNext()) {
                    class_9336 class9336 = ((class_9336) iterator.next());
                    Iterator iterator2 = ((class_9285) class9336.comp_2444()).comp_2393().iterator();
                    while (iterator2.hasNext()) {
                    }
                    class_9287 class9287 = ((class_9287) iterator2.next());
                    offset = class9287.comp_2396().comp_2449();
                    index = -1;
                    iterator = SharedKt.getPlayer().method_31548().method_5438(index2).method_57353().iterator();
                    while (iterator.hasNext()) {
                        class9336 = ((class_9336) iterator.next());
                        iterator2 = ((class_9285) class9336.comp_2444()).comp_2393().iterator();
                        while (iterator2.hasNext()) {
                        }
                        class9287 = ((class_9287) iterator2.next());
                        offset = class9287.comp_2396().comp_2449();
                        index = index2;
                    }
                }
            }
        }
        if (index == -1) {
            index2 = 0;
            if (index2 < 37) {
                iterator = ((Iterable) SharedKt.getPlayer().method_31548().method_5438(index2).method_57353());
                class9336 = 0;
                if (iterator instanceof Collection && ((Collection) iterator).isEmpty()) {
                } else {
                    iterator2 = iterator.iterator();
                    while (iterator2.hasNext()) {
                        class9287 = iterator2.next();
                        class_9336 class93362 = ((class_9336) class9287);
                    }
                }
                if (0) {
                    index = index2;
                }
            }
        }
        return index;
    }

    public void executeAction() {
        function0.invoke();
        function0 = this::getUnit4;
    }

    private static Unit getUnit() {
        return Unit.INSTANCE;
    }

    private static Unit getUnit2() {
        return Unit.INSTANCE;
    }

    private static Unit getUnit3() {
        return Unit.INSTANCE;
    }

    private static void executeAction2() {
        EventPacketHelper2.INSTANCE.updateValue6();
    }

    private static Unit resolveUnit(int arg0, boolean arg1) {
        GuiMoveModule.INSTANCE.updateValue(true);
        if (!(SharedKt.getPlayer().field_7512.method_34255().isEmpty())) {
            HandServiceComponent.e(-999, 0, null, false);
        }
        HandServiceComponent.executeAction(arg0, 40, class_1713.field_7791, arg1);
        GuiMoveModule.INSTANCE.updateValue(false);
        OffhandModule.INSTANCE.updateValue(15);
        return Unit.INSTANCE;
    }

    private static Unit getUnit4() {
        return Unit.INSTANCE;
    }

    static {
        INSTANCE = new RotationServiceComponent5();
        function0 = this::getUnit;
        function02 = this::getUnit2;
    }

}
