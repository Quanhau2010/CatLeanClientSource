package su.catlean.mixins.world;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;
import su.catlean.api.event.events.world.FireWorkVectorEvent;
import su.catlean.api.event.events.world.FireWorkVelocityEvent;

public class FireWorkEntityMixin {

    private LivingEntity field_7616;

    public FireWorkEntityMixin() {
    }

    private Vec3d tickHook(LivingEntity instance) {
        if (this.field_7616 == MinecraftClient.method_1551().player && FireWorkVectorEvent.INSTANCE.call(this.field_7616.method_5720())) {
            return FireWorkVectorEvent.INSTANCE.getVector();
        }
        return this.field_7616.method_5720();
    }

    public void tickHook2(Args args) {
        args.set(0, FireWorkVelocityEvent.INSTANCE.getVelocity());
    }

}
