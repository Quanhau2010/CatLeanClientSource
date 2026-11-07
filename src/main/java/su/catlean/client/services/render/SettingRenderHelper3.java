package su.catlean.client.services.render;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.class_5250;
import net.minecraft.class_7923;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.Item;
import org.joml.Matrix3x2fStack;
import su.catlean.api.setting.VisibleSettingProperty;
import su.catlean.client.services.client.BlocksServiceComponent;
import su.catlean.client.tools.comparators.Comparator18;

public class SettingRenderHelper3 extends TitleRenderHelperImpl {

    private final VisibleSettingProperty visibleSettingProperty;

    public SettingRenderHelper3(VisibleSettingProperty setting) {
        super("Select Blocks");
        this.visibleSettingProperty = setting;
    }

    public VisibleSettingProperty getVisibleSettingProperty() {
        return this.visibleSettingProperty;
    }

    protected List resolveList() {
        List list = new ArrayList();
        CollectionsKt.addAll(((Collection) list), ((Iterable) class_7923.field_41175));
        list.remove(Blocks.AIR);
        Iterable iterable = ((Iterable) list);
        CollectionsKt.sortedWith(iterable, ((Comparator) new Comparator18()));
        return list;
    }

    protected String resolveString(Block item) {
        return item.method_9518().getString();
    }

    protected boolean checkCondition(Block item) {
        return ((BlocksServiceComponent) this.visibleSettingProperty.getObject2()).getList().contains(item);
    }

    public void render(DrawContext context, float x, float y, Block block) {
        context.method_51448().pushMatrix();
        context.method_51448().translate((x + 8.0F), y);
        context.method_51427(block.method_8389().method_7854(), 0, 0);
        context.method_51448().popMatrix();
    }

    protected void setValue(Block item) {
        List list = ((BlocksServiceComponent) this.visibleSettingProperty.getObject2()).getList();
        if (!(__UNDEF_KEY__)) {
            if (list.contains(item)) {
            } else {
            }
        }
        list.add(item);
    }

    public String resolveString(Object item) {
        return this.resolveString(((Block) item));
    }

    public boolean checkCondition(Object item) {
        return this.checkCondition(((Block) item));
    }

    public void render(DrawContext context, float x, float y, Object component) {
        this.render(context, x, y, ((Block) component));
    }

    public void setValue(Object item) {
        this.setValue(((Block) item));
    }

}
