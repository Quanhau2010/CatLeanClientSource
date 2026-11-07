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
        int var10 = TheNetherPacketHelper.f();
        int var11 = TheNetherPacketHelper.INSTANCE.computeValue(target);
        float var12 = ((0.12857F * (var10 + var11)) - 7);
        return RangesKt.coerceIn(MathKt.roundToInt(), 0, 100);
    }

    public boolean isSurroundedOrWebbed(PlayerEntity receiver) {
        BlockPos blockPos = BlockPos.ofFloored(AntiKnockBackModule.INSTANCE.resolveMinecraftObject(receiver));
        int var14 = (blockPos.method_10263() - 2);
        int var15 = (blockPos.method_10263() + 2);
        if (var14 <= var15) {
            int var16 = (blockPos.method_10264() - 1);
            int var17 = (blockPos.method_10264() + 4);
            if (var16 <= var17) {
                int var18 = (blockPos.method_10260() - 2);
                int var19 = (blockPos.method_10260() + 2);
                if (var18 <= var19) {
                    BlockPos blockPos2 = new BlockPos();
                    if (0L >= 0) {
                        if (receiver.method_5829().method_994(new Box(blockPos2)) && Intrinsics.areEqual(SharedKt.getWorld().getBlockState(blockPos2).getBlock(), Blocks.COBWEB)) {
                            return true;
                        }
                    }
                    if (0L >= 0) {
                        if (var12 != null) {
                            if (var18 != var19) {
                            }
                        }
                    }
                    if (0L >= 0) {
                    }
                    if (var16 != var17) {
                    }
                }
            }
            if (var14 != var15 && 0L > 0) {
            }
        }
        return false;
    }

    public boolean isSurroundedOrWebbed(PlayerEntity receiver) {
        BlockPos blockPos = BlockPos.ofFloored(AntiKnockBackModule.INSTANCE.resolveMinecraftObject(receiver));
        int var11 = (blockPos.method_10263() - 2);
        int var12 = (blockPos.method_10263() + 2);
        if (var11 <= var12) {
            int var13 = (blockPos.method_10264() - 1);
            int var14 = (blockPos.method_10264() + 4);
            if (var13 <= var14) {
                int var15 = (blockPos.method_10260() - 2);
                int var16 = (blockPos.method_10260() + 2);
                if (var15 <= var16) {
                    BlockPos blockPos2 = new BlockPos();
                    if (receiver.method_5829().method_994(new Box(blockPos2)) && Intrinsics.areEqual(SharedKt.getWorld().getBlockState(blockPos2).getBlock(), Blocks.field_16999)) {
                        return true;
                    }
                    if (var15 != var16) {
                    }
                }
                if (var13 != var14) {
                }
            }
            if (var11 != var12) {
            }
        }
        return false;
    }

    public List resolveList(PlayerEntity receiver) {
        int var8 = BlockPos.method_49637(receiver.getX(), MathKt.roundToInt(receiver.getY()), receiver.getZ()).method_10264();
        Box var10 = receiver.method_5829();
        float var11 = 1.0E-5F;
        BlockPos[] var13 = new BlockPos[4];
        var13[0] = BlockPos.method_49637(var10.field_1323, var10.field_1321);
        var13[1] = BlockPos.method_49637(var10.field_1323, (var10.field_1324 - var11));
        var13[2] = BlockPos.method_49637((var10.field_1320 - var11), var10.field_1321);
        var13[3] = BlockPos.method_49637((var10.field_1320 - var11), (var10.field_1324 - var11));
        Set var12 = SetsKt.setOf();
        if (CollectionsKt.toList((Iterable) var12) != null) {
        }
        return null;
    }

    public boolean isSurroundedOrWebbed(Vec3d from, Vec3d to) {
        return ExplosionPosEntityHelper.resolveMinecraftObject(from, to) == null;
    }

    public boolean isSurroundedOrWebbed(PlayerEntity receiver, boolean checkFace) {
        if (checkFace) {
            if (Intrinsics.areEqual(SharedKt.getWorld().getBlockState(BlockPos.ofFloored(AntiKnockBackModule.INSTANCE.resolveMinecraftObject(receiver))).getBlock(), Blocks.COBWEB) && Intrinsics.areEqual(SharedKt.getWorld().getBlockState(BlockPos.ofFloored(AntiKnockBackModule.INSTANCE.resolveMinecraftObject(receiver)).up()).getBlock(), Blocks.COBWEB)) {
            }
        } else {
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
