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
        long var4 = ((0L ^ 104104530525409L) >>> 48);
        long var5 = (((0L ^ 104104530525409L) << 16) >>> 32);
        long var6 = (((0L ^ 104104530525409L) << 48) >>> 48);
        long var7 = (0L ^ 37430498539930L);
        long var9 = (0L ^ 50910300018319L);
        long var11 = (0L ^ 139672553149144L);
        long var13 = (0L ^ 17946477735558L);
        long var15 = ((0L ^ 99541060701969L) >>> 48);
        long var16 = (((0L ^ 99541060701969L) << 16) >>> 32);
        long var17 = (((0L ^ 99541060701969L) << 48) >>> 48);
        long var18 = (0L ^ 30591967126976L);
        long var20 = (0L ^ 109580710346244L);
        long var22 = (0L ^ 118028023098805L);
        int var25 = 2;
        CheckRenderHelper.executeAction(this, context.method_51448(), this.computeValue(), this.computeValue2(), 81.0F, 22.0F, 1.0F);
        context.method_51448().pushMatrix();
        context.method_51448().translate(this.computeValue(), this.computeValue2());
        Iterator iterator = EntityHelper2.resolveList(SharedKt.getPlayer()).iterator();
        while (iterator.hasNext()) {
            ItemStack stack = (ItemStack) iterator.next();
            if (0L >= 0L) {
            }
            if (0L > 0L) {
                if (var25 < 43) {
                    CheckRenderHelper.executeAction(this, context.method_51448(), (var25 + 18.0F), 7.0F, 0.0F);
                }
            }
            if (!(stack.isEmpty())) {
                context.method_51427(stack, 0);
            }
            Color var28 = NewThemeRenderHelper.INSTANCE.resolveColor();
            Color var29 = NewThemeRenderHelper.INSTANCE.resolveColor((var25 * 2));
            Color var30 = PolygonShaderComponent.INSTANCE.resolveColor(0.4F);
            Color var31 = PolygonShaderComponent.INSTANCE.resolveColor(0.4F);
            ColorValue1RenderHelper.executeAction(15.0F, 16.0F, 4.0F, 1.5F, context.method_51448(), 1.0F);
            float var32 = class_3532.method_15363(((16.0F - ((stack.method_7919() * 16.0F) / stack.method_7936())) + 2.0F), 0.0F, 16.0F);
            ColorValue1RenderHelper.executeAction(15.0F, 4.0F, 1.5F, context.method_51448(), 1.0F);
        }
        context.method_51448().popMatrix();
        this.executeAction(81.0F, 22.0F);
    }

    public void render(DrawContext context) {
        long var4 = (0L ^ 105984575582407L);
        long var6 = (0L ^ 118901760466898L);
        long var8 = (0L ^ 67510703577989L);
        long var10 = (0L ^ 90421913266139L);
        long var12 = ((0L ^ 27379191465548L) >>> 48);
        long var13 = (((0L ^ 27379191465548L) << 16) >>> 32);
        long var14 = (((0L ^ 27379191465548L) << 48) >>> 48);
        long var15 = (0L ^ 98664999447709L);
        long var17 = (0L ^ 37139592738649L);
        int var20 = 2;
        Iterator iterator = EntityHelper2.resolveList(SharedKt.getPlayer()).iterator();
        ItemStack stack = (ItemStack) iterator.next();
        Color var23 = NewThemeRenderHelper.INSTANCE.resolveColor();
        Color var24 = NewThemeRenderHelper.INSTANCE.resolveColor((var20 * 2));
        Color var25 = PolygonShaderComponent.INSTANCE.resolveColor(0.4F);
        Color var26 = PolygonShaderComponent.INSTANCE.resolveColor(0.4F);
        ColorValue1RenderHelper.executeAction((this.computeValue() + var20), (this.computeValue2() + 15.0F), 16.0F, 4.0F, 1.5F, context.method_51448(), 1.0F);
        float var27 = class_3532.method_15363(((16.0F - ((stack.method_7919() * 16.0F) / stack.method_7936())) + 2.0F), 0.0F, 16.0F);
        ColorValue1RenderHelper.executeAction((this.computeValue() + var20), (this.computeValue2() + 15.0F), 4.0F, 1.5F, context.method_51448(), 1.0F);
    }

    static {
        INSTANCE = new ArmorWidgetCheckRenderHelperImpl();
    }

}
