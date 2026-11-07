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
        boolean flag = !(SharedKt.getPlayer().method_5681());
        if (arg0 >= 0) {
        }
        if (arg1 > 0L) {
            if (AuraModule.INSTANCE.getSprintMode() != AuraSprintMode.NORMAL) {
            }
        }
        if (arg1 > 0L) {
            enabledFlag = 1;
        }
        SharedKt.getPlayer().method_5728(false);
        SharedKt.getNetwork().method_52787(((Packet) new ClientCommandC2SPacket(SharedKt.getPlayer(), class_2849.field_12985)));
    }

    public void executeAction(MoveFixServiceComponent rotation) {
        if (enabledFlag) {
            SharedKt.getPlayer().method_5728(true);
            SharedKt.getNetwork().method_52787(((Packet) new ClientCommandC2SPacket(SharedKt.getPlayer(), class_2849.field_12981)));
            enabledFlag = 0;
        }
        enabledFlag2 = 0;
        if (__UNDEF_KEY__ > 0) {
            if (__UNDEF_KEY__ >= 0) {
                if (AuraModule.INSTANCE.getSprintMode() != AuraSprintMode.LEGIT_EXTRA && AuraModule.INSTANCE.getSprintMode() != AuraSprintMode.LEGIT) {
                    if (__UNDEF_KEY__ >= 0 && this.checkCondition()) {
                        if (AuraModule.INSTANCE.getSprintMode() == AuraSprintMode.LEGIT_EXTRA) {
                            EventPacketHelper2.INSTANCE.updateValue6();
                        }
                        SharedKt.getPlayer().method_5728(class_3675.method_15987(SharedKt.getMc().method_22683(), ((KeyMappingAccessor) SharedKt.getMc().options.field_1894).getKey().method_1444()));
                    }
                }
            }
        }
    }

    public void updateValue() {
    }

    public void executeAction(boolean hvh) {
        ClientPlayerEntity player = SharedKt.getPlayer();
        player.method_18800((player.method_18798().field_1352 / 0.6D), player.method_18798().field_1351, (player.method_18798().field_1350 / 0.6D));
        player.method_5728(true);
    }

    public boolean checkCondition(long arg0) {
        if (arg0 > 0L) {
            if (__UNDEF_KEY__) {
                if (AuraModule.INSTANCE.getOnHitSwap() && RotationServiceComponent5.INSTANCE.computeValue() != -1) {
                } else {
                }
            }
        }
        return false;
    }

    public boolean checkCondition(boolean can) {
        boolean flag = can;
        boolean flag2 = AuraModule.INSTANCE.getSprintMode() == AuraSprintMode.LEGIT_EXTRA;
        if (__UNDEF_KEY__ > 0) {
            if (__UNDEF_KEY__) {
                if (!(SharedKt.getPlayer().method_5624())) {
                }
            }
        }
        if (__UNDEF_KEY__ >= 0) {
            if (AuraModule.INSTANCE.getSprintMode() != AuraSprintMode.LEGIT) {
                if (AuraModule.INSTANCE.getSprintMode() != AuraSprintMode.LEGIT_EXTRA) {
                    if (RotationServiceComponent.INSTANCE.checkCondition(1) && SharedKt.getPlayer().method_18798().field_1351 < -0.07D && this.checkCondition() && SharedKt.getMc().options.field_1903.method_1434() && this.checkCondition()) {
                        if (__UNDEF_KEY__ >= 0) {
                            if (__UNDEF_KEY__ > 0) {
                                if (flag2) {
                                    EventPacketHelper2.INSTANCE.updateValue5();
                                }
                                SharedKt.getPlayer().method_5728(false);
                                SprintModule.INSTANCE.updateValue(true);
                            }
                            flag = 0;
                            SharedKt.getMc().options.field_1867.method_23481(false);
                            enabledFlag2 = 1;
                            RotationServiceComponent5.INSTANCE.updateValue();
                        }
                        RunnableServiceComponent2.executeAction(3, 0, false, this::updateValue2);
                    }
                }
            }
        }
        return flag;
    }

    private static void updateValue2(boolean arg0) {
        enabledFlag2 = 0;
        SharedKt.getMc().options.field_1867.method_23481(class_3675.method_15987(SharedKt.getMc().method_22683(), ((KeyMappingAccessor) SharedKt.getMc().options.field_1867).getKey().method_1444()));
        EventPacketHelper2.INSTANCE.updateValue6();
    }

    static {
        INSTANCE = new RotationServiceComponent2();
    }

}
