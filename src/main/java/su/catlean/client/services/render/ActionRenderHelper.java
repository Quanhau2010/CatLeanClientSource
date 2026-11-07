package su.catlean.client.services.render;

import java.awt.Color;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt;
import net.minecraft.class_1041;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import org.lwjgl.glfw.GLFW;
import su.catlean.SharedKt;
import su.catlean.api.contracts.Contract4;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.ServiceComponent13;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;

public class ActionRenderHelper implements Contract4 {

    private final Function1 function1;
    private String textValue;
    private int countValue;
    private boolean enabledFlag;
    private static Module[] moduleArray;

    public ActionRenderHelper(Function1 action) {
        this.function1 = action;
        this.textValue = "";
    }

    public Function1 getFunction1() {
        return this.function1;
    }

    public String getString() {
        return this.textValue;
    }

    public void executeAction(String value) {
        this.textValue = value;
    }

    public int getNumericValue() {
        return this.countValue;
    }

    public void updateValue(int value) {
        this.countValue = value;
    }

    public void render(DrawContext context, float x, float y, float mouseX, float mouseY) {
        float factor = (x + 43.0F);
        if (mouseX <= (x + 77.0F)) {
        } else {
            if (factor <= mouseX) {
                factor = (y + 25.0F);
                if (mouseY <= (y + 38.0F)) {
                } else {
                }
            } else {
                this.enabledFlag = factor <= mouseY;
            }
        }
        StackShaderComponent2.executeAction(context.method_51448(), x, y, 120.0F, 60.0F, 4.0F, 2.0F, 0.1F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        StackShaderComponent2.executeAction(context.method_51448(), (x + 43.0F), (y + 25.0F), 34.0F, 13.0F, 4.0F, 2.0F, 0.1F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor5(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        if (StringsKt.isBlank(((CharSequence) this.textValue))) {
        } else {
        }
        context.render("Cancel", "Create", (x + 48), (y + 26.0F), Color.WHITE);
        StackShaderComponent2.executeAction(context.method_51448(), (x + 5.0F), (y + 5.0F), 110.0F, 13.0F, 3.0F, 2.0F, 0.1F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor5(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        factor = new Color[1];
        factor[0] = new Color(1157627903, true);
        PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), (x + 33.0F), (y + 9.0F), 0.5F, 7.0F, factor);
        SFMServiceComponent.resolveFontRenderHelper().render(context, "Name", (x + 8.0F), (y + 6.0F), Color.WHITE);
        if ((System.currentTimeMillis() % 700) > timestampValue) {
        } else {
        }
        context.render(this.textValue, ("" + "|"), (x + 37.0F), (y + 6.0F), PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, 0.8F));
        SFMServiceComponent.resolveFontRenderHelper().render(context, "Or drag file there", (x + 60.0F), (y + 46.0F), PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, 0.4F));
    }

    public void executeAction(char chr) {
        this.textValue = (this.textValue + chr);
    }

    public void executeAction(int key) {
        this.textValue = StringsKt.dropLast(this.textValue, 1);
        if (__UNDEF_KEY__ >= 0) {
            this.executeAction();
        }
        if (GLFW.glfwGetClipboardString(SharedKt.getMc().method_22683().method_4490()) == null) {
            GLFW.glfwGetClipboardString(SharedKt.getMc().method_22683().method_4490());
        }
        String text = "";
        this.textValue = (this.textValue + text);
    }

    public boolean checkCondition(float x, float y) {
        if (this.enabledFlag) {
            this.executeAction();
            return true;
        }
        return false;
    }

    private void executeAction() {
        this.function1.invoke(this.textValue);
    }

    public static void updateValue(Module[] arg0) {
        moduleArray = arg0;
    }

    public static Module[] process() {
        return moduleArray;
    }

}
