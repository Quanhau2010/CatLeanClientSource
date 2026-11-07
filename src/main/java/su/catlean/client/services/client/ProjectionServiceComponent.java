package su.catlean.client.services.client;

import com.mojang.blaze3d.buffers.Std140Builder;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_11280.class_11281;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;

public class ProjectionServiceComponent implements class_11281 {

    private final Matrix4f matrix4f;
    private final Matrix4f matrix4f2;

    public ProjectionServiceComponent(Matrix4f projection, Matrix4f view) {
        this.matrix4f = projection;
        this.matrix4f2 = view;
    }

    public Matrix4f getMatrix4f() {
        return this.matrix4f;
    }

    public Matrix4f getMatrix4f2() {
        return this.matrix4f2;
    }

    public void method_71104(ByteBuffer buffer) {
        if (var4 == null) {
            if (this.matrix4f2 == null) {
            }
        }
        Std140Builder.intoBuffer(buffer).putMat4f((Matrix4fc) this.matrix4f).putMat4f((Matrix4fc) new Matrix4f());
    }

    public Matrix4f getMatrix4f3() {
        return this.matrix4f;
    }

    public Matrix4f getMatrix4f4() {
        return this.matrix4f2;
    }

    public ProjectionServiceComponent resolveProjectionServiceComponent(Matrix4f projection, Matrix4f view) {
        return new ProjectionServiceComponent(projection, view);
    }

    public static ProjectionServiceComponent resolveProjectionServiceComponent(ProjectionServiceComponent arg0, Matrix4f arg1, Matrix4f arg2, int arg3, Object arg4) {
        if ((arg3 & 1)) {
            arg1 = arg0.matrix4f;
        }
        if ((arg3 & 2)) {
            arg2 = arg0.matrix4f2;
        }
        return arg0.resolveProjectionServiceComponent(arg1, arg2);
    }

    public String toString() {
        return (null + this.matrix4f + ", view=" + this.matrix4f2 + ")");
    }

    public int hashCode() {
        int var4 = this.matrix4f.hashCode();
        var4 = ((var4 * 3299967873396506655L) + this.matrix4f2 != null);
        return var4;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProjectionServiceComponent)) {
            return false;
        }
        ProjectionServiceComponent var5 = (ProjectionServiceComponent) other;
        if (!(Intrinsics.areEqual(this.matrix4f, var5.matrix4f))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.matrix4f2, var5.matrix4f2))) {
            return false;
        }
        return true;
    }

}
