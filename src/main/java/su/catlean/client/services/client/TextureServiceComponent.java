package su.catlean.client.services.client;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_2960;
import org.joml.Matrix3x2f;

public class TextureServiceComponent {

    private final class_2960 minecraftRef;
    private final Matrix3x2f matrix3x2f;

    public TextureServiceComponent(class_2960 texture, Matrix3x2f matrix) {
        this.minecraftRef = texture;
        this.matrix3x2f = matrix;
    }

    public class_2960 getMinecraftObject() {
        return this.minecraftRef;
    }

    public Matrix3x2f getMatrix3x2f() {
        return this.matrix3x2f;
    }

    public class_2960 getMinecraftObject2() {
        return this.minecraftRef;
    }

    public Matrix3x2f getMatrix3x2f2() {
        return this.matrix3x2f;
    }

    public TextureServiceComponent resolveTextureServiceComponent(class_2960 texture, Matrix3x2f matrix) {
        return new TextureServiceComponent(texture, matrix);
    }

    public String toString() {
        return (null + this.minecraftRef + ", matrix=" + this.matrix3x2f + ")");
    }

    public int hashCode() {
        int index = this.minecraftRef.hashCode();
        index = ((index * 31) + this.matrix3x2f.hashCode());
        return index;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextureServiceComponent)) {
            return false;
        }
        TextureServiceComponent textureServiceComponent = ((TextureServiceComponent) other);
        if (!(Intrinsics.areEqual(this.minecraftRef, textureServiceComponent.minecraftRef))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.matrix3x2f, textureServiceComponent.matrix3x2f))) {
            return false;
        }
        return true;
    }

}
