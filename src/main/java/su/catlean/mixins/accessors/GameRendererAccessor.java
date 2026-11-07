package su.catlean.mixins.accessors;

import net.minecraft.class_11286;
import net.minecraft.class_11658;
import net.minecraft.class_4184;
import net.minecraft.client.util.math.MatrixStack;
import org.joml.Matrix4f;

public interface GameRendererAccessor {

    public void iRenderHand(float arg0, boolean arg1, Matrix4f arg2);

    public float iGetFov(class_4184 arg0, float arg1, boolean arg2);

    public void itiltViewWhenHurt(MatrixStack arg0, float arg1);

    public void ibobView(MatrixStack arg0, float arg1);

    public class_11286 getLevelProjectionMatrixBuffer();

    public class_11658 getLevelRenderState();

}
