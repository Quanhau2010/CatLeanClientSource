package su.catlean.client.services.render;

import java.util.List;
import kotlin.collections.CollectionsKt;
import net.minecraft.class_1299;
import net.minecraft.class_1826;
import net.minecraft.class_2561;
import net.minecraft.class_7923;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import org.joml.Matrix3x2fStack;
import su.catlean.api.setting.VisibleSettingProperty;
import su.catlean.client.services.client.EntitiesServiceComponent;

public class SettingRenderHelper2 extends TitleRenderHelperImpl {

    private final VisibleSettingProperty visibleSettingProperty;

    public SettingRenderHelper2(VisibleSettingProperty setting) {
        super("Select Entities");
        this.visibleSettingProperty = setting;
    }

    public VisibleSettingProperty getVisibleSettingProperty() {
        return this.visibleSettingProperty;
    }

    protected List resolveList() {
        return CollectionsKt.toList(((Iterable) class_7923.field_41177));
    }

    protected String resolveString(class_1299 item) {
        return item.method_5897().getString();
    }

    protected boolean checkCondition(class_1299 item) {
        return ((EntitiesServiceComponent) this.visibleSettingProperty.getObject2()).getList().contains(item);
    }

    public void render(DrawContext context, float x, float y, class_1299 entity) {
        if (__UNDEF_KEY__) {
            if (class_1826.method_8019(entity) != null) {
            } else {
            }
        }
        Item item = Items.field_8077;
        context.method_51448().pushMatrix();
        context.method_51448().translate((x + 8.0F), y);
        context.method_51427(item.method_7854(), 0, 0);
        context.method_51448().popMatrix();
    }

    protected void setValue(class_1299 item) {
        List list = ((EntitiesServiceComponent) this.visibleSettingProperty.getObject2()).getList();
        if (__UNDEF_KEY__) {
            if (list.contains(item)) {
            } else {
            }
        }
        list.add(item);
    }

    public String resolveString(Object item) {
        return this.resolveString(((class_1299) item));
    }

    public boolean checkCondition(Object item) {
        return this.checkCondition(((class_1299) item));
    }

    public void render(DrawContext context, float x, float y, Object component) {
        this.render(context, x, y, ((class_1299) component));
    }

    public void setValue(Object item) {
        this.setValue(((class_1299) item));
    }

}
