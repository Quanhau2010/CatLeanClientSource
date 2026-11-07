package su.catlean.client.services.client;

import net.minecraft.util.math.Vec3d;

public class VectorServiceComponent {

    private static int countValue;

    private VectorServiceComponent() {
    }

    public MoveFixServiceComponent resolveMoveFixServiceComponent(Vec3d vector) {
        return SequenceServiceComponent.INSTANCE.resolveMoveFixServiceComponent(vector);
    }

    public static void updateValue(int arg0) {
        countValue = arg0;
    }

    public static int getNumericValue() {
        return countValue;
    }

    public static int getNumericValue2() {
        return 13;
        return 0;
    }

}
