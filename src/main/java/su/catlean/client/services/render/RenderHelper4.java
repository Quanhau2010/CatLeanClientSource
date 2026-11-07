package su.catlean.client.services.render;

import net.minecraft.class_4587.class_4665;
import net.minecraft.client.util.math.MatrixStack;
import org.joml.Matrix4f;
import org.joml.Quaternionfc;
import su.catlean.client.features.modules.Module;

public class RenderHelper4 {

    private static Module[] moduleArray;

    public static void render(MatrixStack receiver, Quaternionfc q) {
        class_4665 var4 = receiver.method_23760();
        var4.method_23761().rotate(q);
    }

    public static void updateValue(Module[] arg0) {
        moduleArray = arg0;
    }

    public static Module[] process() {
        return moduleArray;
    }

}
