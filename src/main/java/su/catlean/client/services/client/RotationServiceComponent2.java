package su.catlean.client.services.client;

import net.minecraft.class_2848.class_2849;
import net.minecraft.class_3675;
import net.minecraft.class_3675.class_306;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import su.catlean.SharedKt;
import su.catlean.api.contracts.Contract2;
import su.catlean.client.features.modules.movement.basic.SprintModule;
import su.catlean.client.features.modules.pvp.attack.AuraModule;
import su.catlean.client.features.modules.pvp.attack.AuraSprintMode;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.mixins.accessors.KeyMappingAccessor;

public class RotationServiceComponent2 implements Contract2 {

    public static final RotationServiceComponent2 INSTANCE;
    private static boolean enabledFlag;
    private static boolean enabledFlag2;

    private RotationServiceComponent2() {
    }

    public boolean isActive() {
        return enabledFlag2;
    }

    public void updateValue(boolean value) {
        enabledFlag2 = value;
    }

    public void executeAction(int arg0, long arg1) {
        int var4 = ((arg0 << 32) | ((arg1 << 32) >>> 32));
        long var6 = (var4 ^ 118634436058407L);
        long var8 = (var4 ^ 82055159719698L);
        long var10 = (var4 ^ 53672989956210L);
        long var12 = (var4 ^ 16782221287606L);
        boolean var15 = !(SharedKt.getPlayer().method_5681());
        if (arg0 >= 0) {
        }
        if (arg1 > 0L) {
            if (AuraModule.INSTANCE.getSprintMode() != AuraSprintMode.NORMAL) {
            }
        }
        if (arg1 > 0L) {
            enabledFlag = 1;
        }
        SharedKt.getPlayer().method_5728(0);
        SharedKt.getNetwork().method_52787((Packet) new ClientCommandC2SPacket(SharedKt.getPlayer(), class_2849.field_12985));
    }

    public void executeAction(MoveFixServiceComponent rotation) {
        int var5 = (((0L << 48) | ((0L << 32) >>> 16)) | ((0L << 48) >>> 48));
        long var7 = ((var5 ^ 82911683487590L) >>> 32);
        long var9 = (((var5 ^ 82911683487590L) << 32) >>> 32);
        long var10 = (var5 ^ 115964598551774L);
        long var12 = (var5 ^ 51433702095905L);
        long var14 = (var5 ^ 13460627852636L);
        long var16 = (var5 ^ 130078601425468L);
        long var18 = (var5 ^ 81216036539128L);
        if (enabledFlag) {
            SharedKt.getPlayer().method_5728(1);
            SharedKt.getNetwork().method_52787((Packet) new ClientCommandC2SPacket(SharedKt.getPlayer(), class_2849.field_12981));
            enabledFlag = 0;
        }
        enabledFlag2 = 0;
        if (0L > 0) {
            if (0L >= 0) {
                if (AuraModule.INSTANCE.getSprintMode() != AuraSprintMode.LEGIT_EXTRA && AuraModule.INSTANCE.getSprintMode() != AuraSprintMode.LEGIT) {
                    if (0L >= 0 && this.checkCondition()) {
                    }
                }
            }
            if (AuraModule.INSTANCE.getSprintMode() == AuraSprintMode.LEGIT_EXTRA) {
                EventPacketHelper2.INSTANCE.updateValue6();
            }
            SharedKt.getPlayer().method_5728(class_3675.method_15987(SharedKt.getMc().method_22683(), (KeyMappingAccessor) SharedKt.getMc().options.field_1894.getKey().method_1444()));
        }
    }

    public void updateValue() {
    }

    public void executeAction(boolean hvh) {
        ClientPlayerEntity player = SharedKt.getPlayer();
        int var8 = 0;
        player.method_18800((player.method_18798().field_1352 / 0.6D), player.method_18798().field_1351, (player.method_18798().field_1350 / 0.6D));
        player.method_5728(1);
    }

    public boolean checkCondition(long arg0) {
        if (arg0 > 0L) {
            if (var10) {
            }
            if (AuraModule.INSTANCE.getOnHitSwap() && RotationServiceComponent5.INSTANCE.computeValue() != -1) {
            }
        } else {
        }
        return false;
    }

    public boolean checkCondition(boolean can) {
        int var25 = can;
        boolean var26 = AuraModule.INSTANCE.getSprintMode() == AuraSprintMode.LEGIT_EXTRA;
        if (0L > 0) {
            if (var24) {
                if (!(SharedKt.getPlayer().method_5624())) {
                }
            }
        }
        if (0L >= 0) {
            if (AuraModule.INSTANCE.getSprintMode() != AuraSprintMode.LEGIT) {
            }
            if (AuraModule.INSTANCE.getSprintMode() != AuraSprintMode.LEGIT_EXTRA) {
                if (RotationServiceComponent.INSTANCE.checkCondition(1) && SharedKt.getPlayer().method_18798().field_1351 < -0.07D && this.checkCondition() && SharedKt.getMc().options.field_1903.method_1434() && this.checkCondition()) {
                }
            }
            if (0L >= 0) {
                if (0L > 0) {
                    if (var26) {
                        EventPacketHelper2.INSTANCE.updateValue5();
                    }
                    SharedKt.getPlayer().method_5728(0);
                    SprintModule.INSTANCE.updateValue(1);
                }
                var25 = 0;
                SharedKt.getMc().options.field_1867.method_23481(0);
                enabledFlag2 = 1;
                RotationServiceComponent5.INSTANCE.updateValue();
            }
            RunnableServiceComponent2.executeAction(3, 0, 0, this::updateValue2, -3117543247782608890L);
        }
        return var25;
    }

    private static void updateValue2(boolean arg0) {
        enabledFlag2 = 0;
        SharedKt.getMc().options.field_1867.method_23481(class_3675.method_15987(SharedKt.getMc().method_22683(), (KeyMappingAccessor) SharedKt.getMc().options.field_1867.getKey().method_1444()));
        EventPacketHelper2.INSTANCE.updateValue6();
    }

    static {
        INSTANCE = new RotationServiceComponent2();
    }

}
