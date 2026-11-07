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
        return CollectionsKt.toList((Iterable) class_7923.field_41177);
    }

    protected String resolveString(class_1299 item) {
        return item.method_5897().getString();
    }

    protected boolean checkCondition(class_1299 item) {
        return (EntitiesServiceComponent) this.visibleSettingProperty.getObject2().getList().contains(item);
    }

    public void render(DrawContext context, float x, float y, class_1299 entity) {
        if (var7) {
            if (class_1826.method_8019(entity) != null) {
            } else {
            }
        }
        Item var9 = Items.field_8077;
        Object var8 = var9;
        context.method_51448().pushMatrix();
        context.method_51448().translate((x + 8.0F), y);
        context.method_51427(var8.method_7854(), 0, 0);
        context.method_51448().popMatrix();
    }

    protected void setValue(class_1299 item) {
        List positions = (EntitiesServiceComponent) this.visibleSettingProperty.getObject2().getList();
        int var6 = 0;
        if (var4) {
            if (positions.contains(item)) {
            } else {
            }
        }
        positions.add(item);
    }

    public String resolveString(Object item) {
        long var4 = (0L ^ 90927979473846L);
        return this.resolveString((class_1299) item);
    }

    public boolean checkCondition(Object item) {
        long var4 = (0L ^ 111487467574449L);
        return this.checkCondition((class_1299) item);
    }

    public void render(DrawContext context, float x, float y, Object component) {
        long var7 = (0L ^ 74559184613877L);
        this.render(context, x, y, (class_1299) component);
    }

    public void setValue(Object item) {
        long var4 = (0L ^ 91422355180470L);
        this.setValue((class_1299) item);
    }

}
