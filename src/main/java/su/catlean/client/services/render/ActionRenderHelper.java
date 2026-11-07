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
        long var8 = ((0L ^ 13851571978927L) >>> 48);
        long var9 = (((0L ^ 13851571978927L) << 16) >>> 48);
        long var10 = (((0L ^ 13851571978927L) << 32) >>> 32);
        long var11 = (0L ^ 119935861042784L);
        long var13 = (0L ^ 46848168590975L);
        long var15 = (0L ^ 127206913172186L);
        long var17 = (0L ^ 111455786286776L);
        long var19 = ((0L ^ 47230931714358L) >>> 48);
        long var20 = (((0L ^ 47230931714358L) << 16) >>> 32);
        long var21 = (((0L ^ 47230931714358L) << 48) >>> 48);
        float var23 = (x + 43.0F);
        if (mouseX <= (x + 77.0F)) {
        } else {
        }
        if (var23 <= mouseX) {
            var23 = (y + 25.0F);
            if (0L >= 0L && var22 == null) {
                if (mouseY <= (y + 38.0F)) {
                }
            } else {
            }
            if (0L >= 0L) {
                if (var23 <= mouseY) {
                }
            }
        } else {
        }
        }
        1.enabledFlag = 0;
        StackShaderComponent2.executeAction(context.method_51448(), x, y, 120.0F, 60.0F, 4.0F, 2.0F, 0.1F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        StackShaderComponent2.executeAction(context.method_51448(), (x + 43.0F), (y + 25.0F), 34.0F, 13.0F, 4.0F, 2.0F, 0.1F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor5(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        if (0L >= 0L) {
        }
        if (0L >= 0L) {
            if (StringsKt.isBlank((CharSequence) this.textValue)) {
            } else {
            }
        }
        context.render("Cancel", "Create", (x + 48), (y + 26.0F), Color.WHITE);
        StackShaderComponent2.executeAction(context.method_51448(), (x + 5.0F), (y + 5.0F), 110.0F, 13.0F, 3.0F, 2.0F, 0.1F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor5(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        var23 = new Color[1];
        var23[0] = new Color(1157627903, 1);
        PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), (x + 33.0F), (y + 9.0F), 0.5F, 7.0F);
        SFMServiceComponent.resolveFontRenderHelper().render(context, "Name", (x + 8.0F), (y + 6.0F), Color.WHITE);
        if ((System.currentTimeMillis() % 700) > timestampValue) {
        } else {
        }
        context.render(this.textValue, ("" + "|"), (x + 37.0F), (y + 6.0F), PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, 0.8F));
        SFMServiceComponent.resolveFontRenderHelper().render(context, "Or drag file there", (x + 60.0F), (y + 46.0F), PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, 0.4F));
        if (0L > 0L) {
        }
    }

    public void executeAction(char chr) {
        if (var4 == null) {
        }
        this.textValue = (this.textValue + chr);
    }

    public void executeAction(int key) {
        int var5 = (((0L << 48) | ((0L << 32) >>> 16)) | ((0L << 48) >>> 48));
        long var7 = (var5 ^ 86329864647393L);
        long var9 = ((var5 ^ 111975145312813L) >>> 48);
        long var10 = (((var5 ^ 111975145312813L) << 16) >>> 16);
        long var12 = ((var5 ^ 102103657852107L) >>> 48);
        long var13 = (((var5 ^ 102103657852107L) << 16) >>> 32);
        long var14 = (((var5 ^ 102103657852107L) << 48) >>> 48);
        this.textValue = StringsKt.dropLast(this.textValue, 1);
        if (0L >= 0) {
            this.executeAction();
        }
        if (GLFW.glfwGetClipboardString(SharedKt.getMc().method_22683().method_4490()) == null) {
            GLFW.glfwGetClipboardString(SharedKt.getMc().method_22683().method_4490());
        }
        String var16 = "";
        this.textValue = (this.textValue + var16);
    }

    public boolean checkCondition(float x, float y) {
        long var6 = ((0L ^ 99180875954261L) >>> 48);
        long var7 = (((0L ^ 99180875954261L) << 16) >>> 16);
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
