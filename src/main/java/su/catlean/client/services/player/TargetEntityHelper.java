package su.catlean.client.services.player;

import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.contracts.Contract9;
import su.catlean.client.features.modules.movement.basic.AntiKnockBackModule;
import su.catlean.client.services.network.TheNetherPacketHelper;

public class TargetEntityHelper implements Contract9 {

    public static final TargetEntityHelper INSTANCE;
    private static boolean enabledFlag;

    private TargetEntityHelper() {
    }

    public int getPredictTicks(PlayerEntity target) {
        int index = TheNetherPacketHelper.f();
        int index2 = TheNetherPacketHelper.INSTANCE.computeValue(target);
        float factor = ((0.12857F * (index + index2)) - 7);
        return RangesKt.coerceIn(MathKt.roundToInt(factor), 0, 100);
    }

    public boolean isSurroundedOrWebbed(PlayerEntity receiver) {
        BlockPos blockPos = BlockPos.ofFloored(AntiKnockBackModule.INSTANCE.resolveMinecraftObject(receiver));
        int index = (blockPos.method_10263() - 2);
        int index2 = (blockPos.method_10263() + 2);
        if (index <= index2) {
            int index3 = (blockPos.method_10264() - 1);
            int index4 = (blockPos.method_10264() + 4);
            if (index3 <= index4) {
                int index5 = (blockPos.method_10260() - 2);
                int index6 = (blockPos.method_10260() + 2);
                if (index5 <= index6) {
                    BlockPos blockPos2 = new BlockPos(index, index3, index5);
                    if (__UNDEF_KEY__ >= 0) {
                        if (receiver.method_5829().method_994(new Box(blockPos2)) && Intrinsics.areEqual(SharedKt.getWorld().getBlockState(blockPos2).getBlock(), Blocks.COBWEB)) {
                            return true;
                        }
                    }
                    if (__UNDEF_KEY__ >= 0) {
                        if (__UNDEF_KEY__ != null) {
                            if (index5 != index6) {
                            }
                        }
                        if (__UNDEF_KEY__ >= 0) {
                            if (index3 != index4) {
                            }
                        }
                    }
                }
            }
            if (index != index2 && __UNDEF_KEY__ > 0) {
            }
        }
        return false;
    }

    public boolean isSurroundedOrWebbed(PlayerEntity receiver) {
        BlockPos blockPos = BlockPos.ofFloored(AntiKnockBackModule.INSTANCE.resolveMinecraftObject(receiver));
        int index = (blockPos.method_10263() - 2);
        int index2 = (blockPos.method_10263() + 2);
        if (index <= index2) {
            int index3 = (blockPos.method_10264() - 1);
            int index4 = (blockPos.method_10264() + 4);
            if (index3 <= index4) {
                int index5 = (blockPos.method_10260() - 2);
                int index6 = (blockPos.method_10260() + 2);
                if (index5 <= index6) {
                    BlockPos blockPos2 = new BlockPos(index, index3, index5);
                    if (receiver.method_5829().method_994(new Box(blockPos2)) && Intrinsics.areEqual(SharedKt.getWorld().getBlockState(blockPos2).getBlock(), Blocks.field_16999)) {
                        return true;
                    }
                    if (index5 != index6) {
                    }
                }
                if (index3 != index4) {
                }
            }
            if (index != index2) {
            }
        }
        return false;
    }

    public List resolveList(PlayerEntity receiver) {
        int index = BlockPos.method_49637(receiver.getX(), MathKt.roundToInt(receiver.getY()), receiver.getZ()).method_10264();
        Box box = receiver.method_5829();
        float factor = 1.0E-5F;
        BlockPos[] items = new BlockPos[4];
        items[0] = BlockPos.method_49637(box.field_1323, index, box.field_1321);
        items[1] = BlockPos.method_49637(box.field_1323, index, (box.field_1324 - factor));
        items[2] = BlockPos.method_49637((box.field_1320 - factor), index, box.field_1321);
        items[3] = BlockPos.method_49637((box.field_1320 - factor), index, (box.field_1324 - factor));
        Set set = SetsKt.setOf(items);
        if (CollectionsKt.toList(((Iterable) set)) != null) {
        }
        return null;
    }

    public boolean isSurroundedOrWebbed(Vec3d from, Vec3d to) {
        return ExplosionPosEntityHelper.resolveMinecraftObject(from, to, false, null, false) == null;
    }

    public boolean isSurroundedOrWebbed(PlayerEntity receiver, boolean checkFace) {
        if (checkFace) {
            if (Intrinsics.areEqual(SharedKt.getWorld().getBlockState(BlockPos.ofFloored(AntiKnockBackModule.INSTANCE.resolveMinecraftObject(receiver))).getBlock(), Blocks.COBWEB) && Intrinsics.areEqual(SharedKt.getWorld().getBlockState(BlockPos.ofFloored(AntiKnockBackModule.INSTANCE.resolveMinecraftObject(receiver)).up()).getBlock(), Blocks.COBWEB)) {
            } else {
            }
        }
        return false;
    }

    public boolean checkCondition2(PlayerEntity receiver) {
        return Intrinsics.areEqual(SharedKt.getWorld().getBlockState(BlockPos.ofFloored(AntiKnockBackModule.INSTANCE.resolveMinecraftObject(receiver))).getBlock(), Blocks.field_16999);
    }

    static {
        INSTANCE = new TargetEntityHelper();
    }

    public static void updateValue(boolean arg0) {
        enabledFlag = arg0;
    }

    public static boolean isActive() {
        return enabledFlag;
    }

    public static boolean isActive2() {
        return true;
        return false;
    }

}
