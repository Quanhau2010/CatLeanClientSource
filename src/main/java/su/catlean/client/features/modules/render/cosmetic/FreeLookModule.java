package su.catlean.client.features.modules.render.cosmetic;

import net.minecraft.class_10209;
import net.minecraft.class_239;
import net.minecraft.class_315;
import net.minecraft.class_3695;
import net.minecraft.class_3966;
import net.minecraft.class_5498;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.EventPlayerTravel;
import su.catlean.api.event.events.player.EventPostPlayerTravel;
import su.catlean.api.event.events.player.JumpEvent;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.player.UpdateCrosshairTarget;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.MoveFixServiceComponent;
import su.catlean.client.services.client.SequenceServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EventPacketHelper2;

public class FreeLookModule extends Module {

    public static final FreeLookModule INSTANCE;
    private static MoveFixServiceComponent moveFixServiceComponent;
    private static MoveFixServiceComponent moveFixServiceComponent2;

    private FreeLookModule() {
        super("free-look", SubCategoriesKt.getCosmeticCategory());
    }

    public MoveFixServiceComponent getMoveFixServiceComponent() {
        return moveFixServiceComponent;
    }

    public void executeAction(MoveFixServiceComponent value) {
        moveFixServiceComponent = value;
    }

    public void updateValue() {
        if (SharedKt.getMc().player != null) {
            if (SharedKt.getMc().world == null) {
                this.updateValue2();
                return;
            }
        }
        moveFixServiceComponent = new MoveFixServiceComponent(SharedKt.getPlayer().method_36454(), SharedKt.getPlayer().method_36455(), false);
        SharedKt.getMc().options.method_31043(class_5498.field_26665);
    }

    public void updateValue2() {
        if (SharedKt.getMc().player == null || SharedKt.getMc().world == null) {
            return;
        }
        SharedKt.getMc().options.method_31043(class_5498.field_26664);
        SharedKt.getPlayer().method_36456(moveFixServiceComponent.getNumericValue());
        SharedKt.getPlayer().method_36457(moveFixServiceComponent.getNumericValue2());
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        SequenceServiceComponent.INSTANCE.executeAction(moveFixServiceComponent, 0);
    }

    private void onJumpEvent(JumpEvent arg0) {
        arg0.setYaw(moveFixServiceComponent.getNumericValue());
        arg0.cancel();
    }

    public void onEventPlayerTravel(EventPlayerTravel e) {
        moveFixServiceComponent2 = new MoveFixServiceComponent(SharedKt.getPlayer().method_36454(), SharedKt.getPlayer().method_36455(), false);
        SharedKt.getPlayer().method_36456(moveFixServiceComponent.getNumericValue());
        SharedKt.getPlayer().method_36457(moveFixServiceComponent.getNumericValue2());
    }

    public void onEventPostPlayerTravel(EventPostPlayerTravel e) {
        SharedKt.getPlayer().method_36456(moveFixServiceComponent2.getNumericValue());
        SharedKt.getPlayer().method_36457(moveFixServiceComponent2.getNumericValue2());
    }

    private void onUpdateCrosshairTarget(UpdateCrosshairTarget arg0) {
        class_10209.method_64146().method_15407();
        arg0.cancel();
        if (__UNDEF_KEY__ == null) {
        }
        if (__UNDEF_KEY__ == null) {
        }
        class_239 class239 = EventPacketHelper2.INSTANCE.resolveMinecraftObject(SharedKt.getPlayer().method_55754(), SharedKt.getPlayer().method_55755(), moveFixServiceComponent.getNumericValue(), moveFixServiceComponent.getNumericValue2());
        SharedKt.getMc().field_1765 = class239;
        if (__UNDEF_KEY__ == null) {
            if (class239 instanceof class_3966) {
            } else {
            }
        }
        ((class_3966) class239).method_17782().field_1692 = null;
    }

    static {
        INSTANCE = new FreeLookModule();
        moveFixServiceComponent = new MoveFixServiceComponent(0.0F, 0.0F, false);
        moveFixServiceComponent2 = new MoveFixServiceComponent(0.0F, 0.0F, false);
    }

}
