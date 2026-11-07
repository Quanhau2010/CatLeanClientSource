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
        Iterable var4 = (Iterable) itemSet;
        int var5 = 0;
        Iterator iterator = var4.iterator();
        while (iterator.hasNext()) {
            Object var7 = iterator.next();
            RenderHelper3 var8 = (RenderHelper3) var7;
            int var9 = 0;
            var8.executeAction();
        }
    }

    public void method_25394(DrawContext context, int mouseX, int mouseY, float delta) {
        if (SharedKt.getMc().world == null) {
            this.method_25420(context, mouseX, mouseY, delta);
        }
        BackRenderHelper.INSTANCE.render(context, mouseX, mouseY);
        renderHelper2 = null;
        Iterable var14 = (Iterable) itemSet;
        int var15 = 0;
        Iterator iterator = var14.iterator();
        while (iterator.hasNext()) {
            Object var17 = iterator.next();
            RenderHelper3 var18 = (RenderHelper3) var17;
            int var19 = 0;
            var18.render(context, mouseX, mouseY);
        }
    }

    public boolean method_25421() {
        return false;
    }

    public boolean method_25402(class_11909 click, boolean doubled) {
        double var11 = click.comp_4798();
        double var13 = click.comp_4799();
        int var15 = click.method_74245();
        if (BackRenderHelper.INSTANCE.checkCondition()) {
            return true;
        }
        Iterable var16 = (Iterable) itemSet;
        int var17 = 0;
        Iterator iterator = var16.iterator();
        while (iterator.hasNext()) {
            Object var19 = iterator.next();
            RenderHelper3 var20 = (RenderHelper3) var19;
            int var21 = 0;
            var20.executeAction();
        }
        if (renderHelper2 != null && renderHelper2 instanceof SuggestionsRenderHelper2Impl) {
            var16 = (Iterable) itemSet;
            var17 = 0;
            if (var16 instanceof Collection && (Collection) var16.isEmpty()) {
            } else {
                iterator = var16.iterator();
                if (iterator.hasNext()) {
                    var19 = iterator.next();
                    var20 = (RenderHelper3) var19;
                    var21 = 0;
                } else {
                }
            }
            if (1) {
                SuggestionsRenderHelper2Impl.serviceComponent7.updateValue((SuggestionsRenderHelper2Impl) renderHelper2);
            }
        } else {
            renderHelper2 = null;
        }
        }
        return this.method_25402(click, doubled);
    }

    public boolean method_25406(class_11909 click) {
        double var7 = click.comp_4798();
        double var9 = click.comp_4799();
        int var11 = click.method_74245();
        Iterable var12 = (Iterable) itemSet;
        int var13 = 0;
        Iterator iterator = var12.iterator();
        while (iterator.hasNext()) {
            Object var15 = iterator.next();
            RenderHelper3 var16 = (RenderHelper3) var15;
            int var17 = 0;
            var16.executeAction2();
        }
        BackRenderHelper.INSTANCE.executeAction();
        return this.method_25406(click);
    }

    public boolean method_25401(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
        Iterable var14 = (Iterable) itemSet;
        int var15 = 0;
        Iterator iterator = var14.iterator();
        while (iterator.hasNext()) {
            Object var17 = iterator.next();
            RenderHelper3 var18 = (RenderHelper3) var17;
            int var19 = 0;
            var18.executeAction(mouseX, mouseY, verticalAmount);
        }
        return this.method_25401(mouseX, mouseY, horizontalAmount, verticalAmount);
    }

    public boolean method_25404(class_11908 input) {
        int var17 = input.comp_4795();
        int var18 = input.comp_4796();
        int var19 = input.comp_4797();
        Iterable var20 = (Iterable) itemSet;
        int var21 = 0;
        Iterator iterator = var20.iterator();
        while (iterator.hasNext()) {
            Object var23 = iterator.next();
            RenderHelper3 var24 = (RenderHelper3) var23;
            int var25 = 0;
            var24.executeAction();
        }
        if (SuggestionsRenderHelper2Impl.serviceComponent7.getSuggestionsRenderHelper2Impl() != null) {
            iterator = SuggestionsRenderHelper2Impl.serviceComponent7.getSuggestionsRenderHelper2Impl();
            var23 = iterator;
            var24 = 0;
            var23.executeAction(StringsKt.dropLast(var23.getString2(), 1));
        } else {
            if (SuggestionsRenderHelper2Impl.serviceComponent7.getSuggestionsRenderHelper2Impl() != null) {
                SuggestionsRenderHelper2Impl.serviceComponent7.getSuggestionsRenderHelper2Impl().resolveUnit();
            } else {
                SuggestionsRenderHelper2Impl.serviceComponent7.updateValue(null);
                if (ServiceComponent13.checkCondition(3305891483701215573L)) {
                    if (GLFW.glfwGetClipboardString(SharedKt.getMc().method_22683().method_4490()) == null) {
                        GLFW.glfwGetClipboardString(SharedKt.getMc().method_22683().method_4490());
                    }
                    var21 = "";
                    iterator = SuggestionsRenderHelper2Impl.serviceComponent7.getSuggestionsRenderHelper2Impl();
                    if (iterator != null) {
                        iterator.executeAction((iterator.getString2() + var21));
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
        Iterable var12 = (Iterable) itemSet;
        int var13 = 0;
        Iterator iterator = var12.iterator();
        while (iterator.hasNext()) {
            Object var15 = iterator.next();
            RenderHelper3 var16 = (RenderHelper3) var15;
            int var17 = 0;
            var16.executeAction();
        }
        var12 = SuggestionsRenderHelper2Impl.serviceComponent7.getSuggestionsRenderHelper2Impl();
        if (var12 != null) {
            var12.executeAction((var12.getString2() + var11));
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
        RenderHelper3[] var19 = new RenderHelper3[5];
        var19[0] = ConfigPanelRenderHelper3Impl.INSTANCE;
        var19[1] = MacroPanelRenderHelper3Impl.INSTANCE;
        var19[2] = WaypointPanelGuiElement.INSTANCE;
        var19[3] = ProxyPanelRenderHelper3Impl.INSTANCE;
        var19[4] = HomiesPanelRenderHelper3Impl.INSTANCE;
        itemSet = SetsKt.setOf();
    }

}
