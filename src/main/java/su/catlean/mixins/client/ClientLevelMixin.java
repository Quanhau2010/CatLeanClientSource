package su.catlean.mixins.client;

import net.minecraft.class_1297.class_5529;
import net.minecraft.class_5577;
import net.minecraft.class_5582;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.catlean.api.event.events.world.AfterEntityRemove;
import su.catlean.api.event.events.world.AfterEntitySpawn;
import su.catlean.api.event.events.world.EntityRemove;
import su.catlean.api.event.events.world.EntitySpawn;
import su.catlean.mixins.accessors.ClientLevelAccessor;

public class ClientLevelMixin {

    private final MinecraftClient mc;

    public ClientLevelMixin() {
        this.mc = MinecraftClient.method_1551();
    }

    public void addEntityHook(Entity entity, CallbackInfo ci) {
        ci.cancel();
    }

    public void addEntityHookPost(Entity entity, CallbackInfo ci) {
        ci.cancel();
    }

    public void removeEntityHook(int entityId, class_5529 removalReason, CallbackInfo ci) {
        ci.cancel();
    }

    public void removeEntityHookPost(int entityId, class_5529 removalReason, CallbackInfo ci) {
        ci.cancel();
    }

}
