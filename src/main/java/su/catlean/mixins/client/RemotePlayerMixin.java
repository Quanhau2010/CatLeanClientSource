package su.catlean.mixins.client;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.Vec3d;
import su.catlean.interfaces.Resolvable;

public class RemotePlayerMixin extends AbstractClientPlayerEntity implements Resolvable {

    private Vec3d cachePosition;

    public RemotePlayerMixin(ClientWorld world, GameProfile profile) {
        super(world, profile);
        this.cachePosition = Vec3d.ZERO;
    }

    public void savePosition(Vec3d position) {
        this.cachePosition = position;
    }

    public Vec3d getSavedPosition() {
        return this.cachePosition;
    }

}
