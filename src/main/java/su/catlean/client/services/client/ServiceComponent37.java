package su.catlean.client.services.client;

import kotlin.Unit;
import net.minecraft.class_1713;
import net.minecraft.class_2879;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.Hand;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.movement.basic.GuiMoveModule;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.network.PacketPacketHelper;

public class ServiceComponent37 extends Thread {

    private int countValue;
    private int countValue2;
    private int countValue3;
    private boolean enabledFlag;
    private static int countValue4;

    public ServiceComponent37(int epSlot, int originalSlot, int delay, boolean inv) {
        super();
        this.countValue = epSlot;
        this.countValue2 = originalSlot;
        this.countValue3 = delay;
        this.enabledFlag = inv;
    }

    public void run() {
        GuiMoveModule.INSTANCE.updateValue(1);
        if (!(this.enabledFlag)) {
            ItemPacketHelper.INSTANCE.executeAction(this.countValue);
        }
        HandServiceComponent.e(this.countValue, this.countValue2, class_1713.field_7791);
        GuiMoveModule.INSTANCE.updateValue(0);
        Thread.sleep(this.countValue3);
        SequenceServiceComponent.INSTANCE.executeAction((RotationServiceComponent4) new RotationRotationServiceComponent4Impl(new MoveFixServiceComponent(SharedKt.getPlayer().method_36454(), SharedKt.getPlayer().method_36455()), 200, this::getUnit));
        Thread.sleep(this.countValue3);
        GuiMoveModule.INSTANCE.updateValue(1);
        if (!(this.enabledFlag)) {
            ItemPacketHelper.INSTANCE.executeAction(this.countValue2);
        } else {
            HandServiceComponent.e(this.countValue, this.countValue2, class_1713.field_7791);
        }
        GuiMoveModule.INSTANCE.updateValue(0);
        this.run();
    }

    private static Unit getUnit() {
        HandServiceComponent.K(Hand.field_5808, 0.0F, 0.0F);
        PacketPacketHelper.handlePacket((Packet) new class_2879(Hand.field_5808));
        return Unit.INSTANCE;
    }

    public static void updateValue(int arg0) {
        countValue4 = arg0;
    }

    public static int getNumericValue() {
        return countValue4;
    }

    public static int getNumericValue2() {
        return 125;
        return 0;
    }

}
