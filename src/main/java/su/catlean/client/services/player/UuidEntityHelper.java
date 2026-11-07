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
        UUID uUID = this.uUID;
        return ("LogoutSpot(uuid=" + uUID + ", player=" + player + ", logTime=" + __UNDEF_KEY__ + ")");
    }

    public int hashCode() {
        int index = this.uUID.hashCode();
        index = ((index * 31) + this.playerEntity.hashCode());
        if (index != null) {
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
        UuidEntityHelper uuidEntityHelper = ((UuidEntityHelper) other);
        if (!(Intrinsics.areEqual(this.uUID, uuidEntityHelper.uUID))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.playerEntity, uuidEntityHelper.playerEntity))) {
            return false;
        }
        if (this.timestampValue != uuidEntityHelper.timestampValue) {
            return false;
        }
        return true;
    }

}
