package su.catlean.client.services.player;

import com.mojang.authlib.GameProfile;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import net.minecraft.class_124;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import su.catlean.SharedKt;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.network.TheNetherPacketHelper;

public class EntityEntityHelper2 {

    private final PlayerEntity playerEntity;
    private final EasingServiceComponent easingServiceComponent;
    private boolean enabledFlag;

    public EntityEntityHelper2(PlayerEntity entity, EasingServiceComponent animation, boolean removing) {
        this.playerEntity = entity;
        this.easingServiceComponent = animation;
        this.enabledFlag = removing;
    }

    public PlayerEntity getMinecraftObject() {
        return this.playerEntity;
    }

    public EasingServiceComponent getEasingServiceComponent() {
        return this.easingServiceComponent;
    }

    public boolean isActive() {
        return this.enabledFlag;
    }

    public void updateValue(boolean value) {
        this.enabledFlag = value;
    }

    public String resolveString() {
        if (EntityHelper4.isFriend(this.playerEntity)) {
        } else {
        }
        int index = TheNetherPacketHelper.INSTANCE.computeValue(this.playerEntity);
        int index2 = MathKt.roundToInt(SharedKt.getPlayer().distanceTo(this.playerEntity));
        int index3 = MathKt.roundToInt((this.playerEntity.method_6032() + this.playerEntity.method_6067()));
        class_124 class124 = class_124.field_1070;
        String text = this.playerEntity.method_7334().name();
        return (class_124.field_1068 + text + class124 + " | " + index3 + " hp | " + index2 + " m | " + index + " ms");
    }

    public PlayerEntity getMinecraftObject2() {
        return this.playerEntity;
    }

    public EasingServiceComponent getEasingServiceComponent2() {
        return this.easingServiceComponent;
    }

    public boolean isActive2() {
        return this.enabledFlag;
    }

    public EntityEntityHelper2 resolveEntityEntityHelper2(PlayerEntity entity, EasingServiceComponent animation, boolean removing) {
        return new EntityEntityHelper2(entity, animation, removing);
    }

    public String toString() {
        boolean flag = this.enabledFlag;
        EasingServiceComponent easingServiceComponent = this.easingServiceComponent;
        PlayerEntity player = this.playerEntity;
        return ("PlayerHolder(entity=" + player + ", animation=" + easingServiceComponent + ", removing=" + flag + ")");
    }

    public int hashCode() {
        int index = this.playerEntity.hashCode();
        index = ((index * 31) + this.easingServiceComponent.hashCode());
        index = ((index * 31) + Boolean.hashCode(this.enabledFlag));
        return index;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EntityEntityHelper2)) {
            return false;
        }
        EntityEntityHelper2 entityEntityHelper2 = ((EntityEntityHelper2) other);
        if (!(Intrinsics.areEqual(this.playerEntity, entityEntityHelper2.playerEntity))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.easingServiceComponent, entityEntityHelper2.easingServiceComponent))) {
            return false;
        }
        if (this.enabledFlag != entityEntityHelper2.enabledFlag) {
            return false;
        }
        return true;
    }

}
