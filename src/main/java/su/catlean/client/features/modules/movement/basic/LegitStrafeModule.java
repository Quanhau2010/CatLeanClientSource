package su.catlean.client.features.modules.movement.basic;

import kotlin.math.MathKt;
import net.minecraft.class_241;
import net.minecraft.class_744;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.KeyboardInputEvent;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.MoveFixServiceComponent;
import su.catlean.client.services.client.SequenceServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.types.OptionMode18;
import su.catlean.mixins.accessors.ClientInputAccessor;

public class LegitStrafeModule extends Module {

    public static final LegitStrafeModule INSTANCE;
    private static boolean enabledFlag;

    private LegitStrafeModule() {
        super("legit-strafe", SubCategoriesKt.getBasicMovementCategory());
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (SharedKt.getMc().options.field_1894.method_1434()) {
            if (EventPacketHelper2.INSTANCE.checkCondition() && SharedKt.getMc().options.field_1881.method_1434()) {
            }
        } else {
        }
        int var18 = 0;
        SequenceServiceComponent.INSTANCE.executeAction(new MoveFixServiceComponent(EventPacketHelper2.INSTANCE.computeValue(), SharedKt.getPlayer().method_36455(), 0, OptionMode18.FORCE), 0);
        enabledFlag = 1;
    }

    private void onKeyboardInputEvent(KeyboardInputEvent arg0) {
        if (!(enabledFlag)) {
            return;
        }
        enabledFlag = 0;
        float var10 = SharedKt.getPlayer().field_3913.method_3128().field_1342;
        float var11 = SharedKt.getPlayer().field_3913.method_3128().field_1343;
        float var12 = ((SharedKt.getPlayer().method_36454() - EventPacketHelper2.INSTANCE.computeValue()) * 0.017453292F);
        double var13 = Math.cos();
        double var14 = Math.sin();
        (ClientInputAccessor) SharedKt.getPlayer().field_3913.setMoveVector(new class_241(MathKt.roundToInt(((var11 * var13) - (var10 * var14))), MathKt.roundToInt(((var10 * var13) + (var11 * var14)))));
    }

    static {
        INSTANCE = new LegitStrafeModule();
    }

}
