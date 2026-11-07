package su.catlean.client.services.render;

import java.awt.Color;
import java.util.Iterator;
import java.util.List;
import net.minecraft.class_3532;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.ItemStack;
import org.joml.Matrix3x2fStack;
import su.catlean.SharedKt;
import su.catlean.client.services.player.EntityHelper2;
import su.catlean.client.services.render.shader.PolygonShaderComponent;

public class ArmorWidgetCheckRenderHelperImpl extends CheckRenderHelper {

    public static final ArmorWidgetCheckRenderHelperImpl INSTANCE;

    private ArmorWidgetCheckRenderHelperImpl() {
        super("armor-widget");
    }

    public void render(DrawContext context) {
        int index = 2;
        CheckRenderHelper.executeAction(this, context.method_51448(), this.computeValue(), this.computeValue2(), 81.0F, 22.0F, 1.0F, false);
        context.method_51448().pushMatrix();
        context.method_51448().translate(this.computeValue(), this.computeValue2());
        Iterator iterator = EntityHelper2.resolveList(SharedKt.getPlayer()).iterator();
        while (iterator.hasNext()) {
            ItemStack stack = ((ItemStack) iterator.next());
            if (index < 43) {
                CheckRenderHelper.executeAction(this, context.method_51448(), (index + 18.0F), 7.0F, 0.0F);
            }
            if (!(stack.isEmpty())) {
                context.method_51427(stack, index, 0);
            }
            Color color = NewThemeRenderHelper.INSTANCE.resolveColor(index);
            Color color2 = NewThemeRenderHelper.INSTANCE.resolveColor((index * 2));
            Color color3 = PolygonShaderComponent.INSTANCE.resolveColor(color, 0.4F);
            Color color4 = PolygonShaderComponent.INSTANCE.resolveColor(color2, 0.4F);
            ColorValue1RenderHelper.executeAction(index, 15.0F, 16.0F, 4.0F, 1.5F, color3, color3, color4, color4, context.method_51448(), 1.0F, color2);
            float factor = class_3532.method_15363(((16.0F - ((stack.method_7919() * 16.0F) / stack.method_7936())) + 2.0F), 0.0F, 16.0F);
            ColorValue1RenderHelper.executeAction(index, 15.0F, factor, 4.0F, 1.5F, color, color, color2, color2, context.method_51448(), 1.0F, color2);
        }
        context.method_51448().popMatrix();
        this.executeAction(81.0F, 22.0F);
    }

    public void render(DrawContext context) {
        int index = 2;
        Iterator iterator = EntityHelper2.resolveList(SharedKt.getPlayer()).iterator();
        while (iterator.hasNext()) {
            ItemStack stack = ((ItemStack) iterator.next());
            Color color = NewThemeRenderHelper.INSTANCE.resolveColor(index);
            Color color2 = NewThemeRenderHelper.INSTANCE.resolveColor((index * 2));
            Color color3 = PolygonShaderComponent.INSTANCE.resolveColor(color, 0.4F);
            Color color4 = PolygonShaderComponent.INSTANCE.resolveColor(color2, 0.4F);
            ColorValue1RenderHelper.executeAction((this.computeValue() + index), (this.computeValue2() + 15.0F), 16.0F, 4.0F, 1.5F, color3, color3, color4, color4, context.method_51448(), 1.0F, color2);
            float factor = class_3532.method_15363(((16.0F - ((stack.method_7919() * 16.0F) / stack.method_7936())) + 2.0F), 0.0F, 16.0F);
            ColorValue1RenderHelper.executeAction((this.computeValue() + index), (this.computeValue2() + 15.0F), factor, 4.0F, 1.5F, color, color, color2, color2, context.method_51448(), 1.0F, color2);
        }
    }

    static {
        INSTANCE = new ArmorWidgetCheckRenderHelperImpl();
    }

}
