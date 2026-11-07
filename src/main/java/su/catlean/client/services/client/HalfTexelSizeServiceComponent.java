package su.catlean.client.services.client;

import com.mojang.blaze3d.buffers.Std140Builder;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_11280.class_11281;
import net.minecraft.class_241;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.render.esp.StorageEspModule;
import su.catlean.client.features.modules.render.esp.StorageEspShaderMode;
import su.catlean.client.services.render.shader.PolygonShaderComponent;

public class HalfTexelSizeServiceComponent implements class_11281 {

    private final class_241 minecraftRef;

    public HalfTexelSizeServiceComponent(class_241 halfTexelSize) {
        this.minecraftRef = halfTexelSize;
    }

    public class_241 getMinecraftObject() {
        return this.minecraftRef;
    }

    public void method_71104(ByteBuffer buffer) {
        Std140Builder.intoBuffer(buffer).putVec2(this.minecraftRef.field_1343, this.minecraftRef.field_1342).putFloat(Math.abs(PolygonShaderComponent.INSTANCE.computeValue(((SharedKt.getPlayer().field_6012 - 1) / 48.0F), (SharedKt.getPlayer().field_6012 / 48.0F), PolygonShaderComponent.INSTANCE.computeValue()))).putInt(StorageEspModule.INSTANCE.getShaderMode().ordinal());
    }

    public class_241 getMinecraftObject2() {
        return this.minecraftRef;
    }

    public HalfTexelSizeServiceComponent resolveHalfTexelSizeServiceComponent(class_241 halfTexelSize) {
        return new HalfTexelSizeServiceComponent(halfTexelSize);
    }

    public static HalfTexelSizeServiceComponent resolveHalfTexelSizeServiceComponent(HalfTexelSizeServiceComponent arg0, class_241 arg1, int arg2, Object arg3) {
        if ((arg2 & 1)) {
            arg1 = arg0.minecraftRef;
        }
        return arg0.resolveHalfTexelSizeServiceComponent(arg1);
    }

    public String toString() {
        return ("UniformData(halfTexelSize=" + this.minecraftRef + ")");
    }

    public int hashCode() {
        return this.minecraftRef.hashCode();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HalfTexelSizeServiceComponent)) {
            return false;
        }
        HalfTexelSizeServiceComponent var5 = (HalfTexelSizeServiceComponent) other;
        if (!(Intrinsics.areEqual(this.minecraftRef, var5.minecraftRef))) {
            return false;
        }
        return true;
    }

}
