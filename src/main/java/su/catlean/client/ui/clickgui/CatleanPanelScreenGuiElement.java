package su.catlean.client.ui.clickgui;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.text.StringsKt;
import net.minecraft.class_1041;
import net.minecraft.class_11905;
import net.minecraft.class_11908;
import net.minecraft.class_11909;
import net.minecraft.class_2561;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import org.lwjgl.glfw.GLFW;
import su.catlean.SharedKt;
import su.catlean.client.services.client.ServiceComponent13;
import su.catlean.client.services.client.ServiceComponent7;
import su.catlean.client.services.render.BackRenderHelper;
import su.catlean.client.services.render.ConfigPanelRenderHelper3Impl;
import su.catlean.client.services.render.HomiesPanelRenderHelper3Impl;
import su.catlean.client.services.render.MacroPanelRenderHelper3Impl;
import su.catlean.client.services.render.ProxyPanelRenderHelper3Impl;
import su.catlean.client.services.render.RenderHelper2;
import su.catlean.client.services.render.RenderHelper3;
import su.catlean.client.services.render.SuggestionsRenderHelper2Impl;

public class CatleanPanelScreenGuiElement extends Screen {

    public static final CatleanPanelScreenGuiElement INSTANCE;
    private static Set itemSet;
    private static RenderHelper2 renderHelper2;
    private static RenderHelper3 renderHelper3;

    private CatleanPanelScreenGuiElement() {
        super(class_2561.method_30163("catlean-panel-screen"));
    }

    public Set getSet() {
        return itemSet;
    }

    public void executeAction(Set value) {
        itemSet = value;
    }

    public RenderHelper2 getRenderHelper2() {
        return renderHelper2;
    }

    public void updateValue(RenderHelper2 value) {
        renderHelper2 = value;
    }

    public RenderHelper3 getRenderHelper3() {
        return renderHelper3;
    }

    public void updateValue(RenderHelper3 value) {
        renderHelper3 = value;
    }

    protected void method_25426() {
        Iterable iterable = ((Iterable) itemSet);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            RenderHelper3 renderHelper3 = ((RenderHelper3) element);
            renderHelper3.executeAction();
        }
    }

    public void method_25394(DrawContext context, int mouseX, int mouseY, float delta) {
        if (SharedKt.getMc().world == null) {
            this.method_25420(context, mouseX, mouseY, delta);
        }
        BackRenderHelper.INSTANCE.render(context, mouseX, mouseY);
        renderHelper2 = null;
        Iterable iterable = ((Iterable) itemSet);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            RenderHelper3 renderHelper3 = ((RenderHelper3) element);
            renderHelper3.render(context, mouseX, mouseY);
        }
    }

    public boolean method_25421() {
        return false;
    }

    public boolean method_25402(class_11909 click, boolean doubled) {
        double offset = click.comp_4798();
        double offset2 = click.comp_4799();
        int index = click.method_74245();
        if (BackRenderHelper.INSTANCE.checkCondition(offset, offset2, index)) {
            return true;
        }
        Iterable iterable = ((Iterable) itemSet);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            RenderHelper3 renderHelper3 = ((RenderHelper3) element);
            renderHelper3.executeAction(offset, offset2, index);
        }
        if (renderHelper2 != null && renderHelper2 instanceof SuggestionsRenderHelper2Impl) {
            iterable = ((Iterable) itemSet);
            if (iterable instanceof Collection && ((Collection) iterable).isEmpty()) {
            } else {
                iterator = iterable.iterator();
                while (iterator.hasNext()) {
                    element = iterator.next();
                    renderHelper3 = ((RenderHelper3) element);
                }
            }
            if (1) {
                SuggestionsRenderHelper2Impl.serviceComponent7.updateValue(((SuggestionsRenderHelper2Impl) renderHelper2));
            } else {
                renderHelper2 = null;
            }
        } else {
        }
        return this.method_25402(click, doubled);
    }

    public boolean method_25406(class_11909 click) {
        double offset = click.comp_4798();
        double offset2 = click.comp_4799();
        int index = click.method_74245();
        Iterable iterable = ((Iterable) itemSet);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            RenderHelper3 renderHelper3 = ((RenderHelper3) element);
            renderHelper3.executeAction2();
        }
        BackRenderHelper.INSTANCE.executeAction(offset, offset2, index);
        return this.method_25406(click);
    }

    public boolean method_25401(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
        Iterable iterable = ((Iterable) itemSet);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            RenderHelper3 renderHelper3 = ((RenderHelper3) element);
            renderHelper3.executeAction(mouseX, mouseY, verticalAmount);
        }
        return this.method_25401(mouseX, mouseY, horizontalAmount, verticalAmount);
    }

    public boolean method_25404(class_11908 input) {
        int index = input.comp_4795();
        int index2 = input.comp_4796();
        int index3 = input.comp_4797();
        Iterable iterable = ((Iterable) itemSet);
        int index4 = 0;
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            RenderHelper3 renderHelper3 = ((RenderHelper3) element);
            renderHelper3.executeAction(index, index2, index3);
        }
        if (SuggestionsRenderHelper2Impl.serviceComponent7.getSuggestionsRenderHelper2Impl() != null) {
            iterator = SuggestionsRenderHelper2Impl.serviceComponent7.getSuggestionsRenderHelper2Impl();
            element = iterator;
            renderHelper3 = 0;
            element.executeAction(StringsKt.dropLast(element.getString2(), 1));
        } else {
            if (SuggestionsRenderHelper2Impl.serviceComponent7.getSuggestionsRenderHelper2Impl() != null) {
                SuggestionsRenderHelper2Impl.serviceComponent7.getSuggestionsRenderHelper2Impl().resolveUnit();
            } else {
                SuggestionsRenderHelper2Impl.serviceComponent7.updateValue(null);
                if (ServiceComponent13.checkCondition(341)) {
                    if (GLFW.glfwGetClipboardString(SharedKt.getMc().method_22683().method_4490()) == null) {
                        GLFW.glfwGetClipboardString(SharedKt.getMc().method_22683().method_4490());
                    }
                    index4 = "";
                    iterator = SuggestionsRenderHelper2Impl.serviceComponent7.getSuggestionsRenderHelper2Impl();
                    if (iterator != null) {
                        iterator.executeAction((iterator.getString2() + index4));
                    } else {
                    }
                }
            }
        }
        return this.method_25404(input);
    }

    public boolean method_25400(class_11905 input) {
        if (ArraysKt.firstOrNull(input.method_74226().toCharArray()) != null) {
        } else {
            ArraysKt.firstOrNull(input.method_74226().toCharArray()).charValue();
            return this.method_25400(input);
        }
        Iterable iterable = ((Iterable) itemSet);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            RenderHelper3 renderHelper3 = ((RenderHelper3) element);
            renderHelper3.executeAction();
        }
        iterable = SuggestionsRenderHelper2Impl.serviceComponent7.getSuggestionsRenderHelper2Impl();
        if (iterable != null) {
            iterable.executeAction();
        } else {
        }
        BackRenderHelper.INSTANCE.executeAction();
        return this.method_25400(input);
    }

    protected void method_57734(DrawContext guiGraphics) {
    }

    public void method_25420(DrawContext guiGraphics, float deltaTicks) {
    }

    static {
        INSTANCE = new CatleanPanelScreenGuiElement();
        RenderHelper3[] items = new RenderHelper3[5];
        items[0] = ConfigPanelRenderHelper3Impl.INSTANCE;
        items[1] = MacroPanelRenderHelper3Impl.INSTANCE;
        items[2] = WaypointPanelGuiElement.INSTANCE;
        items[3] = ProxyPanelRenderHelper3Impl.INSTANCE;
        items[4] = HomiesPanelRenderHelper3Impl.INSTANCE;
        itemSet = SetsKt.setOf(items);
    }

}
