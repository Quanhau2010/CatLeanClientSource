package su.catlean.client.services.player;

import kotlin.ranges.RangesKt;
import net.minecraft.entity.Entity;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.render.shader.PolygonShaderComponent;

public class EntityEntityHelper {

    private final Entity targetEntity;
    private final float factorValue;
    private final double preciseValue;
    private final double preciseValue2;
    private final double preciseValue3;
    private int countValue;

    public EntityEntityHelper(Entity entity, float hp, double posX, double posY, double posZ, int ticks) {
        this.targetEntity = entity;
        this.factorValue = hp;
        this.preciseValue = posX;
        this.preciseValue2 = posY;
        this.preciseValue3 = posZ;
        this.countValue = ticks;
    }

    public Entity getMinecraftObject() {
        return this.targetEntity;
    }

    public float getNumericValue() {
        return this.factorValue;
    }

    public double getNumericValue() {
        return this.preciseValue;
    }

    public double getNumericValue2() {
        return this.preciseValue2;
    }

    public double getNumericValue3() {
        return this.preciseValue3;
    }

    public int getNumericValue() {
        return this.countValue;
    }

    public void updateValue(int value) {
        this.countValue = value;
    }

    public float computeValue() {
        if (PolygonShaderComponent.INSTANCE.computeValue(RangesKt.coerceAtLeast((this.countValue - 1.0F), 0.0F), this.countValue) != null) {
        }
        return null;
    }

}
