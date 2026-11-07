package su.catlean.client.services.render;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import net.minecraft.class_2561;
import net.minecraft.class_7923;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.Item;
import org.joml.Matrix3x2fStack;

public class ClickActionRenderHelper2 extends TitleRenderHelperImpl {

    private final List itemList;
    private final Function1 function1;

    public ClickActionRenderHelper2(List list, Function1 clickAction) {
        super("Select Items");
        this.itemList = list;
        this.function1 = clickAction;
    }

    public List getList() {
        return this.itemList;
    }

    public Function1 getFunction1() {
        return this.function1;
    }

    protected List resolveList() {
        return CollectionsKt.toList(((Iterable) class_7923.field_41178));
    }

    protected String resolveString(Item item) {
        return item.method_63680().getString();
    }

    protected boolean checkCondition(Item item) {
        return this.itemList.contains(item);
    }

    public void render(DrawContext context, float x, float y, Item item) {
        context.method_51448().pushMatrix();
        context.method_51448().translate((x + 8.0F), y);
        context.method_51427(item.method_7854(), 0, 0);
        context.method_51448().popMatrix();
    }

    protected void executeAction(Item item) {
        this.function1.invoke(item);
        List list = this.itemList;
        if (!(__UNDEF_KEY__)) {
            if (list.contains(item)) {
            } else {
            }
        }
        list.add(item);
    }

    public String resolveString(Object item) {
        return this.resolveString(((Item) item));
    }

    public boolean checkCondition(Object item) {
        return this.checkCondition(((Item) item));
    }

    public void render(DrawContext context, float x, float y, Object component) {
        this.render(context, x, y, ((Item) component));
    }

    public void executeAction(Object item) {
        this.executeAction(((Item) item));
    }

}
