package su.catlean.client.services.client;

import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.class_1294;
import net.minecraft.class_2189;
import net.minecraft.class_3486;
import net.minecraft.class_5134;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import su.catlean.SharedKt;
import su.catlean.api.contracts.Contract2;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.movement.rage.MaceElytraTargetModule;
import su.catlean.client.features.modules.pvp.attack.AuraModule;
import su.catlean.client.features.modules.pvp.attack.AuraRandomizeDelayMode;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.player.TargetEntityHelper;
import su.catlean.client.types.mappings.AuraRandomizeDelayModeWhenMappings;

public class RotationServiceComponent implements Contract2 {

    public static final RotationServiceComponent INSTANCE;
    private static int countValue;
    private static int countValue2;
    private static int countValue3;
    private static int countValue4;

    private RotationServiceComponent() {
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

    public int getNumericValue3() {
        return countValue3;
    }

    public void updateValue3(int value) {
        countValue3 = value;
    }

    public void executeAction() {
    }

    public void executeAction(MoveFixServiceComponent rotation) {
        float factor = ((20.0F / AuraModule.INSTANCE.getMinCps()) - 1);
        float factor2 = ((20.0F / AuraModule.INSTANCE.getMaxCps()) - 1);
        int index = Math.min(factor, factor2);
        int index2 = Math.max(factor, factor2);
        countValue3 = (countValue3 + 1);
        if (AuraModule.INSTANCE.getOldDelay()) {
        } else {
        }
        countValue = this.computeValue();
        countValue2 = countValue;
        if (__UNDEF_KEY__ >= 0) {
        }
    }

    public void updateValue() {
        countValue = (countValue + -1);
    }

    public boolean checkCondition(int offset) {
        if (!(this.checkCondition2(offset))) {
        }
        return (countValue - offset) <= 0;
    }

    public static boolean checkCondition(RotationServiceComponent arg0, int arg1, int arg2, Object arg3) {
        if ((arg2 & 1) != 0) {
            arg1 = 0;
        }
        return arg0.checkCondition(arg1);
    }

    public boolean checkCondition() {
        return SharedKt.getPlayer().method_7261(0.5F) > 0.93D;
    }

    private boolean checkCondition2(int arg0) {
        if (EventPacketHelper2.INSTANCE.getNumericValue() <= 0.0D) {
            if (!(SharedKt.getPlayer().isOnGround()) && SharedKt.getPlayer().method_18798().field_1351 < 0.0031D && arg0) {
                double offset = EventPacketHelper2.INSTANCE.getNumericValue();
                if (1.13D <= offset) {
                } else {
                    if (offset <= 1.146D) {
                        if (!(SharedKt.getMc().options.field_1903.method_1434())) {
                        } else {
                        }
                    }
                }
            }
        }
        int index = 0;
        if (!(SharedKt.getPlayer().method_5799())) {
            if (SharedKt.getPlayer().method_5771()) {
            }
            if (!(SharedKt.getPlayer().method_6059(class_1294.field_5919)) && !(SharedKt.getPlayer().method_6059(class_1294.field_5902)) && !(SharedKt.getPlayer().method_5777(class_3486.field_15517)) && !(SharedKt.getPlayer().method_5777(class_3486.field_15518)) && !(TargetEntityHelper.INSTANCE.isSurroundedOrWebbed(((PlayerEntity) SharedKt.getPlayer()))) && !(TargetEntityHelper.INSTANCE.isSurroundedOrWebbed(((PlayerEntity) SharedKt.getPlayer()))) && !(SharedKt.getPlayer().method_21754())) {
                if (SharedKt.getPlayer().method_31549().field_7479) {
                } else {
                }
            }
            offset = 0;
            if (!(offset)) {
                return index;
                offset = SharedKt.getWorld().getBlockState(BlockPos.ofFloored(AuraModule.INSTANCE.resolveMinecraftObject(SharedKt.getPlayer())).up()).getBlock() instanceof class_2189;
                if (offset) {
                    if (SharedKt.getPlayer().method_31549().field_7479) {
                    } else {
                    }
                }
                int index2 = 0;
                if (!(SharedKt.getPlayer().method_5681())) {
                    if (!(SharedKt.getMc().options.field_1903.method_1434())) {
                        return true;
                    }
                }
                if (!(index2)) {
                    return index;
                }
            }
        }
        return true;
    }

    private static boolean checkCondition(RotationServiceComponent arg0, int arg1, int arg2, Object arg3) {
        if ((arg2 & 1) != 0) {
            arg1 = 0;
        }
        return arg0.checkCondition2(arg1);
    }

    private int computeValue(long arg0) {
        if (MaceElytraTargetModule.INSTANCE.checkCondition()) {
            return 10;
        }
        double offset = SharedKt.getPlayer().method_45325(class_5134.field_23723);
        float factor = ((1.0F / SharedKt.getPlayer().method_45325(class_5134.field_23723)) * 18);
        factor = Math.max(factor, 10);
        if (4.4D <= offset) {
        } else {
            if (offset != 4.0D && offset > 4.401D) {
                if (4.8D <= offset) {
                } else {
                    if (offset <= 4.801D) {
                        factor = 10;
                    }
                }
            }
        }
        if (AuraModule.INSTANCE.getSplashWhileOnGround() && !(SharedKt.getMc().options.field_1903.method_1434()) && SharedKt.getPlayer().isOnGround()) {
            factor = 12;
        }
        boolean flag = !(SharedKt.getMc().options.field_1903.method_1434());
        if ((countValue3 % 7) == 3) {
        } else {
            if (!((countValue3 % 5))) {
                if (SharedKt.getPlayer().isOnGround()) {
                    if (!(SharedKt.getMc().options.field_1903.method_1434())) {
                    } else {
                        if ((countValue3 % 7) == 3) {
                        } else {
                        }
                    }
                } else {
                }
            } else {
                return factor;
            }
        }
    }

    static {
        INSTANCE = new RotationServiceComponent();
    }

    public static void updateValue4(int arg0) {
        countValue4 = arg0;
    }

    public static int getNumericValue4() {
        return countValue4;
    }

    public static int getNumericValue5() {
        return 37;
        return 0;
    }

}
