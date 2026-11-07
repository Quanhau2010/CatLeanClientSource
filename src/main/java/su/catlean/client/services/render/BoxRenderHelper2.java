package su.catlean.client.services.render;

import java.awt.Color;
import net.minecraft.util.math.Box;

public class BoxRenderHelper2 {

    private final Box minecraftRef;
    private final Color colorValue;
    private final Color colorValue2;

    public BoxRenderHelper2(Box box, Color color, Color color2) {
        this.minecraftRef = box;
        this.colorValue = color;
        this.colorValue2 = color2;
    }

    public Box getMinecraftObject() {
        return this.minecraftRef;
    }

    public Color getColor() {
        return this.colorValue;
    }

    public Color getColor2() {
        return this.colorValue2;
    }

}
