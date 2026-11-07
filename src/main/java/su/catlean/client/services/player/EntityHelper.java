package su.catlean.client.services.player;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import su.catlean.interfaces.IEntity;

public class EntityHelper {

    private static String[] textValueArray;

    public static Vec3d resolveMinecraftObject(Entity receiver) {
        return ((IEntity) receiver).catLean$getPosition();
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

    public static String[] process() {
        return textValueArray;
    }

}
