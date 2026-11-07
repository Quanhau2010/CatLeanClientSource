package su.catlean.api.event.events.render;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.util.math.MatrixStack;
import org.joml.Matrix4f;
import su.catlean.api.event.Event;
import su.catlean.gofra.Gofra;

public class Render3DEventDepth extends Event {

    public static final Render3DEventDepth INSTANCE;
    private static MatrixStack stack;
    private static Matrix4f projection;

    private Render3DEventDepth() {
        super();
    }

    public MatrixStack getStack() {
        if (stack != null) {
            return stack;
        }
        Intrinsics.throwUninitializedPropertyAccessException("stack");
        return null;
    }

    public Matrix4f getProjection() {
        if (projection != null) {
            return projection;
        }
        Intrinsics.throwUninitializedPropertyAccessException("projection");
        return null;
    }

    public boolean call(MatrixStack stack, Matrix4f projection) {
        this.setCancelled(false);
        stack = stack;
        projection = projection;
        Gofra.INSTANCE.drain(this);
        return this.getCancelled();
    }

    static {
        INSTANCE = new Render3DEventDepth();
    }

}
