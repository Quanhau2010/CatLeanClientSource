package su.catlean.client.services.render;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import net.minecraft.class_1796;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.Item;
import org.joml.Matrix3x2fStack;
import su.catlean.SharedKt;
import su.catlean.api.contracts.Contract8;
import su.catlean.client.services.client.MacroServiceComponent;
import su.catlean.client.services.client.NoneServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.ServiceComponent13;
import su.catlean.client.services.client.StackServiceComponent2;
import su.catlean.client.services.client.config.models.IdRecord;
import su.catlean.client.services.client.config.models.KeyRecord;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;

public class MacroWidgetCheckRenderHelperImpl extends CheckRenderHelper {

    public static final MacroWidgetCheckRenderHelperImpl INSTANCE;

    private MacroWidgetCheckRenderHelperImpl() {
        super("macro-widget");
    }

    public void render(DrawContext context) {
        float factor = this.computeValue();
        float factor2 = this.computeValue2();
        float factor3 = 0.0F;
        Iterable iterable = ((Iterable) MacroServiceComponent.INSTANCE.resolveList());
        int index = 0;
        Iterable iterable2 = iterable;
        Collection collection = ((Collection) new ArrayList());
        int index2 = 0;
        Iterator iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            int index3 = 0;
            collection.add(element);
        }
        Iterator iterator2 = collection.iterator();
        while (iterator2.hasNext()) {
            iterable = iterator2.next();
            index = ((IdRecord) iterable);
            if (MacroServiceComponent.INSTANCE.resolveMinecraftObject(index.getString()) == null) {
                MacroServiceComponent.INSTANCE.resolveMinecraftObject(index.getString());
            }
            iterable2 = element;
            index2 = new Item[1];
            index2[0] = iterable2;
            collection = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(index2).isActive();
            index2 = ServiceComponent13.checkCondition(index.getKeyRecord().getNumericValue());
            iterator = NoneServiceComponent.INSTANCE.resolveString(index.getKeyRecord().getNumericValue());
            element = (SFMServiceComponent.resolveFontRenderHelper().computeValue(iterator) + 22.0F);
            CheckRenderHelper.executeAction(this, context.method_51448(), factor, factor2, element, 16.0F, 0.0F, false);
            index3 = SharedKt.getPlayer().method_7357().method_7905(iterable2.method_7854(), PolygonShaderComponent.INSTANCE.computeValue());
            StackShaderComponent2.executeAction(context.method_51448(), factor, (factor2 + (16.0F * (1.0F - index3))), element, (16.0F * index3), 3.0F, 0.0F, 0.0F, 1.0F, Color.RED, NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
            context.method_51448().pushMatrix();
            context.method_51448().translate((factor + 2.0F), (factor2 + 2.0F));
            context.method_51448().scale(0.7F);
            context.method_51427(iterable2.method_7854(), 0, 0);
            context.method_51448().popMatrix();
            index3 = new Color[1];
            index3[0] = new Color(1157627903, true);
            PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), (factor + 14), (factor2 + 4.0F), 0.5F, 9.0F, index3);
            if (index2) {
            } else {
                if (collection) {
                } else {
                }
            }
            index3 = Color.RED;
            this.render(context, iterator, (factor + 18.0F), (factor2 + 3.0F), index3);
            factor = (factor + (element + 2.0F));
            factor3 = (factor3 + (element + 2.0F));
        }
        this.executeAction(factor3, 16.0F);
    }

    static {
        INSTANCE = new MacroWidgetCheckRenderHelperImpl();
    }

}
