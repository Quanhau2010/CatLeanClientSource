package su.catlean.client.services.render;

import java.awt.Color;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;

public class BoxRenderHelper {

    private final Box minecraftRef;
    private final Color colorValue;
    private final Direction minecraftRef2;

    public BoxRenderHelper(Box box, Color color, Direction side) {
        this.minecraftRef = box;
        this.colorValue = color;
        this.minecraftRef2 = side;
    }

    public Box getMinecraftObject() {
        return this.minecraftRef;
    }

    public Color getColor() {
        return this.colorValue;
    }

    public Direction getMinecraftObject() {
        return this.minecraftRef2;
    }

}
