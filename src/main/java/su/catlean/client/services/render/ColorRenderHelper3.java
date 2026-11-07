package su.catlean.client.services.render;

import java.awt.Color;

public class ColorRenderHelper3 {

    private final float factorValue;
    private final float factorValue2;
    private final float factorValue3;
    private int countValue;
    private final Color colorValue;

    public ColorRenderHelper3(float posX, float posY, float posZ, int age, Color color) {
        this.factorValue = posX;
        this.factorValue2 = posY;
        this.factorValue3 = posZ;
        this.countValue = age;
        this.colorValue = color;
    }

    public float getNumericValue() {
        return this.factorValue;
    }

    public float getNumericValue2() {
        return this.factorValue2;
    }

    public float getNumericValue3() {
        return this.factorValue3;
    }

    public int getNumericValue() {
        return this.countValue;
    }

    public void updateValue(int value) {
        this.countValue = value;
    }

    public Color getColor() {
        return this.colorValue;
    }

}
