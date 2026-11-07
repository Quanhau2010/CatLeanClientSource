package su.catlean.client.services.player;

import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.player.PlayerEntity;

public class UuidEntityHelper {

    private final UUID uUID;
    private final PlayerEntity playerEntity;

    public UuidEntityHelper(UUID uuid, PlayerEntity player, long logTime) {
        this.uUID = uuid;
        this.playerEntity = player;
        this.timestampValue = logTime;
    }

    public UUID getUUID() {
        return this.uUID;
    }

    public PlayerEntity getMinecraftObject() {
        return this.playerEntity;
    }

    public long getNumericValue() {
        return this.timestampValue;
    }

    public void updateValue(long value) {
        this.timestampValue = value;
    }

    public UUID getUUID2() {
        return this.uUID;
    }

    public PlayerEntity getMinecraftObject2() {
        return this.playerEntity;
    }

    public long getNumericValue2() {
        return this.timestampValue;
    }

    public UuidEntityHelper resolveUuidEntityHelper(UUID uuid, PlayerEntity player, long logTime) {
        return new UuidEntityHelper(uuid, player, logTime);
    }

    public String toString() {
        PlayerEntity player = this.playerEntity;
        UUID var6 = this.uUID;
        return ("LogoutSpot(uuid=" + var6 + ", player=" + player + ", logTime=" + var3 + ")");
    }

    public int hashCode() {
        int var4 = this.uUID.hashCode();
        var4 = ((var4 * 31) + this.playerEntity.hashCode());
        if (var4 != null) {
        }
        return null;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UuidEntityHelper)) {
            return false;
        }
        UuidEntityHelper var5 = (UuidEntityHelper) other;
        if (!(Intrinsics.areEqual(this.uUID, var5.uUID))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.playerEntity, var5.playerEntity))) {
            return false;
        }
        if (this.timestampValue != var5.timestampValue) {
            return false;
        }
        return true;
    }

}
