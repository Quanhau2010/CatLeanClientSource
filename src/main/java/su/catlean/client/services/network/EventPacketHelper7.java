package su.catlean.client.services.network;

import java.util.Iterator;
import java.util.List;
import net.minecraft.class_1656;
import net.minecraft.class_2739;
import net.minecraft.class_2848.class_2849;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import net.minecraft.util.math.Box;
import su.catlean.SharedKt;
import su.catlean.api.contracts.Contract6;
import su.catlean.api.event.events.network.AfterSendPacket;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.event.events.player.AfterElytraEvent;
import su.catlean.api.event.events.player.MoveEvent;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.player.PreElytraEvent;
import su.catlean.api.event.events.player.PreSyncEvent;
import su.catlean.api.event.events.player.SetPoseEvent;
import su.catlean.api.event.events.world.FireWorkVelocityEvent;
import su.catlean.client.features.modules.movement.rage.ElytraPlusModule;
import su.catlean.client.features.modules.movement.rage.ElytraPlusNcpStrictMode;
import su.catlean.client.features.modules.utility.equip.ElytraSwapModule;
import su.catlean.client.types.mappings.ElytraPlusNcpStrictModeWhenMappings;

public class EventPacketHelper7 implements Contract6 {

    public static final EventPacketHelper7 INSTANCE;
    private static String[] textValueArray;

    private EventPacketHelper7() {
    }

    public void executeAction(PreSyncEvent e) {
        long var4 = (0L ^ 52537100148008L);
        long var6 = (0L ^ 123048400601652L);
        long var8 = (0L ^ 93268489241074L);
        long var10 = (0L ^ 2350125969345L);
        long var12 = (0L ^ 95174287896623L);
        long var14 = (0L ^ 109028519504674L);
        long var16 = (0L ^ 95510200616042L);
        if (this.checkCondition()) {
            if (0L > 0L) {
                if (var18 == null) {
                }
            }
        }
        if (0L >= 0L) {
            if (var18 == null) {
            }
        }
        if (0L > 0L) {
            if (var18 == null) {
                if (!(ElytraPlusModule.INSTANCE.getInfDurability())) {
                }
                if (0L >= 0L) {
                }
                if (!(SharedKt.getPlayer().isFallFlying())) {
                }
                ElytraSwapModule.INSTANCE.updateValue(1);
                PacketPacketHelper.handlePacket((Packet) new ClientCommandC2SPacket(SharedKt.getPlayer(), class_2849.field_12982));
            }
        }
        e.cancel();
    }

    public void executeAction(PreElytraEvent e) {
    }

    public void executeAction(AfterElytraEvent e) {
    }

    public void executeAction(MoveEvent e) {
        long var4 = (0L ^ 129836602860932L);
        long var6 = (0L ^ 52389835191008L);
        long var8 = (0L ^ 116402100060533L);
        long var10 = (0L ^ 59600180345496L);
        long var12 = (0L ^ 4452337967885L);
        long var14 = (0L ^ 123833832724325L);
        long var16 = (0L ^ 14353991285086L);
        long var18 = (0L ^ 119169530931175L);
        long var20 = (0L ^ 28734862241446L);
        long var22 = (0L ^ 8571044726872L);
        long var24 = (0L ^ 64823430370190L);
        long var26 = (0L ^ 16494758083782L);
        SharedKt.getPlayer().method_31549().field_7479 = 0;
        SharedKt.getPlayer().method_31549().method_7248(0.05F);
        if (this.checkCondition()) {
        }
        if (ElytraPlusModule.INSTANCE.getStopOnGround() || 0L > 0L) {
            return;
        }
        if (ElytraPlusModule.INSTANCE.getAccelerate()) {
            float var30 = ElytraPlusModule.INSTANCE.getAccelerateFactor();
            float var34 = (ElytraPlusModule.INSTANCE.getXzSpeed() / 15.0F);
            class_1656 var33 = SharedKt.getPlayer().method_31549();
            int var31 = 0;
            ElytraPlusModule.INSTANCE.updateValue((ElytraPlusModule.INSTANCE.getNumericValue() + var30));
            float var36 = ElytraPlusModule.INSTANCE.getNumericValue();
            float var29 = (var36 / 100.0D);
            var31 = 1.0D;
        } else {
        }
        var34.method_7248((Math.min() * 1.0D));
        e.cancel();
        if (0L > 0L) {
            if (var28 == null) {
                if (!((SharedKt.getPlayer().field_6012 % 3)) && ElytraPlusModule.INSTANCE.getNcpStrictMode() == ElytraPlusNcpStrictMode.Motion) {
                    e.setX(0.0D);
                    e.setY(0.0D);
                    e.setZ(0.0D);
                    return;
                }
            }
            if (0L > 0L) {
            }
            if (Math.abs(e.getX()) < 0.05D) {
                e.setX(0.0D);
            }
            if (0L >= 0L) {
            }
            if (Math.abs(e.getZ()) < 0.05D) {
                e.setZ(0.0D);
            }
        }
        if (0L >= 0L) {
            if (var28 == null) {
                if (ElytraPlusModule.INSTANCE.getVertical()) {
                }
                if (0L > 0L) {
                }
                if (SharedKt.getMc().options.field_1903.method_1434()) {
                } else {
                }
                if (SharedKt.getMc().options.field_1832.method_1434()) {
                } else {
                } else {
                }
            }
        }
        0.0D.setY(0.0D);
        if (0L >= 0L && var28 == null) {
            e.setY(-1.000088900582341E-12D);
            e.setY(-4.000355602329364E-12D);
            if (!((SharedKt.getPlayer().field_6012 % 2))) {
            } else {
            }
            2.0E-4D.setY(((0.0D - 1.0E-6D) + (Math.random() * 9.0E-7D)));
        }
        if (0L >= 0L) {
            if (ElytraPlusModule.INSTANCE.getNcpStrictMode() != ElytraPlusNcpStrictMode.New) {
            }
        }
        if (0L > 0L) {
            if (var28 == null) {
                if (SharedKt.getPlayer().field_5976 && ElytraPlusModule.INSTANCE.getNcpStrictMode() == ElytraPlusNcpStrictMode.Motion && !((SharedKt.getPlayer().field_6012 % 2))) {
                    e.setY(-0.07840000152587923D);
                }
            }
        }
        if (0L >= 0L) {
            if (var28 == null) {
                if (!(ElytraPlusModule.INSTANCE.getInfDurability())) {
                }
            }
        }
        if (0L >= 0L) {
            if (var28 == null) {
            }
            if (0L > 0L) {
            }
            if (0L > 0L) {
            }
        }
        var29 = Math.toRadians((4.5D * (SharedKt.getPlayer().field_6012 % 80)));
        e.setX((Math.sin() * 0.12D));
        e.setZ((Math.cos() * 0.12D));
    }

    public void executeAction(AfterSendPacket event) {
    }

    public void executeAction(ReceivePacket e) {
        long var5 = ((0L << 16) | ((0L << 48) >>> 48));
        long var7 = (var5 ^ 25371452378166L);
        if (var9 == null) {
        }
        class_2739 var10 = (class_2739) e.getPacket();
        if (var9 == null) {
        }
        if (var10.comp_1128().isEmpty()) {
            return;
        }
        e.cancel();
    }

    public void executeAction(PlayerUpdateEvent e) {
    }

    public void executeAction() {
    }

    public void updateValue(long arg0) {
        long var3 = (arg0 ^ 85510088156605L);
        SharedKt.getPlayer().method_31549().field_7479 = 0;
        SharedKt.getPlayer().method_31549().method_7248(0.05F);
    }

    public void executeAction(FireWorkVelocityEvent e) {
    }

    public void onSetPoseEvent(SetPoseEvent e) {
    }

    public void executeAction(ReceivePacket e) {
    }

    public boolean checkCondition() {
        return SharedKt.getWorld().method_20812(SharedKt.getPlayer(), SharedKt.getPlayer().method_5829().method_1009(-0.25D, 0.0D, -0.25D).method_989(0.0D, -0.3D, 0.0D)).iterator().hasNext();
    }

    static {
        INSTANCE = new EventPacketHelper7();
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

    public static String[] process() {
        return textValueArray;
    }

}
