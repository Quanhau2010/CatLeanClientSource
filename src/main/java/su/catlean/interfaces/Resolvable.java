package su.catlean.interfaces;

import net.minecraft.util.math.Vec3d;

public interface Resolvable {

    public void savePosition(Vec3d arg0);

    public Vec3d getSavedPosition();

}
