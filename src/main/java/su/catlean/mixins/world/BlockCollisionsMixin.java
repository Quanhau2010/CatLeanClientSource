package su.catlean.mixins.world;

import net.minecraft.block.BlockState;
import net.minecraft.class_1922;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.BlockPos;
import su.catlean.api.event.GofraState;
import su.catlean.api.event.events.player.CollisionEvent;

public abstract class BlockCollisionsMixin {

    public BlockCollisionsMixin() {
    }

    private BlockState computeNextHook(class_1922 instance, BlockPos blockPos) {
        if (MinecraftClient.method_1551().world != null && MinecraftClient.method_1551().player != null) {
            if (!(GofraState.INSTANCE.getModifyCollisions())) {
                return instance.getBlockState(blockPos);
            }
        }
        CollisionEvent collisionEvent = new CollisionEvent();
        collisionEvent.call(instance.getBlockState(blockPos), blockPos);
        return collisionEvent.getState();
    }

}
