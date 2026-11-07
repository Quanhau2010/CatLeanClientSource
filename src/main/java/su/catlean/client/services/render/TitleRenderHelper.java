package su.catlean.client.services.render;

import com.google.common.collect.Lists;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import net.minecraft.class_1041;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.ItemStack;
import org.joml.Matrix3x2f;
import org.joml.Matrix3x2fStack;
import su.catlean.SharedKt;
import su.catlean.api.contracts.Contract9;
import su.catlean.api.event.events.render.Render2DEvent;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.ServiceComponent10;
import su.catlean.client.services.client.StartupServiceComponent;
import su.catlean.client.services.client.TitleServiceComponent;
import su.catlean.client.services.client.VecServiceComponent;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;
import su.catlean.client.types.OptionMode16;
import su.catlean.client.types.mappings.ysWhenMappings2;

public class TitleRenderHelper implements Contract9 {

    public static final TitleRenderHelper INSTANCE;
    private static final List itemList;
    private static final MissingnoRenderHelper missingnoRenderHelper;
    private static final MissingnoRenderHelper missingnoRenderHelper2;
    private static final MissingnoRenderHelper missingnoRenderHelper3;
    private static final MissingnoRenderHelper missingnoRenderHelper4;
    private static final MissingnoRenderHelper missingnoRenderHelper5;
    private static final MissingnoRenderHelper missingnoRenderHelper6;
    private static boolean enabledFlag;
    private static int countValue;

    private TitleRenderHelper() {
    }

    public MissingnoRenderHelper getMissingnoRenderHelper() {
        return missingnoRenderHelper;
    }

    public MissingnoRenderHelper getMissingnoRenderHelper2() {
        return missingnoRenderHelper2;
    }

    public MissingnoRenderHelper getMissingnoRenderHelper3() {
        return missingnoRenderHelper3;
    }

    public MissingnoRenderHelper getMissingnoRenderHelper4() {
        return missingnoRenderHelper4;
    }

    public MissingnoRenderHelper getMissingnoRenderHelper5() {
        return missingnoRenderHelper5;
    }

    public MissingnoRenderHelper getMissingnoRenderHelper6() {
        return missingnoRenderHelper6;
    }

    public boolean isActive() {
        return enabledFlag;
    }

    public void updateValue(boolean value) {
        enabledFlag = value;
    }

    public void executeAction(String title, String content, int second, OptionMode16 type, ItemStack item) {
        if (!(NotificationsCheckRenderHelperImpl.INSTANCE.getEnabled()) || enabledFlag) {
            return;
        }
        SharedKt.getMc().execute(this::executeAction);
    }

    public static void executeAction(TitleRenderHelper arg0, String arg1, String arg2, int arg3, OptionMode16 arg4, ItemStack arg5, int arg6, Object arg7) {
        if ((arg6 & 16)) {
        }
        arg0.executeAction(arg1, arg2, arg3, arg4, arg5);
    }

    public void onRender2DEvent(Render2DEvent e) {
        int var10 = ((SharedKt.getMc().method_22683().method_4502() / 2.0F) + 25);
        if (var9 != null) {
            if (itemList.size() > 8) {
                itemList.removeFirst();
            }
        }
        Iterator iterator = Lists.newArrayList((Iterable) itemList).iterator();
        if (iterator.hasNext()) {
            TitleServiceComponent var12 = (TitleServiceComponent) iterator.next();
            this.render(e.getContext(), (var10 + (itemList.size() * 16)));
            var10 = (var10 - 16.0F);
        }
        var12 = itemList;
        int var13 = 0;
        var13 = itemList.removeIf(this::checkCondition);
        Object var14 = var12;
    }

    private void render(TitleServiceComponent arg0, short arg1, DrawContext arg2, float arg3) {
        if (arg0.getServiceComponent10().checkCondition((arg0.getNumericValue() - 350))) {
        } else {
        }
        0.0F.executeAction(1.0F);
        if (arg1 >= 0) {
            if (arg0.getEasingServiceComponent().getNumericValue() < 0.01D) {
                return;
            }
            arg0.updateValue(this.computeValue(arg0.getNumericValue(), arg3));
        }
        int var30 = ((SharedKt.getMc().method_22683().method_4486() / 2.0F) - (arg0.getNumericValue2() / 2.0F));
        Matrix3x2fStack var31 = arg2.method_51448();
        var31.pushMatrix();
        var31.translate((var30 + (arg0.getNumericValue2() / 2.0F)), (arg0.getNumericValue() + 6.5F));
        var31.scale(arg0.getEasingServiceComponent().getNumericValue(), arg0.getEasingServiceComponent().getNumericValue());
        var31.translate((var30 + (arg0.getNumericValue2() / 2.0F)), (arg0.getNumericValue() + 6.5F));
        StackShaderComponent2.executeAction(arg0.getNumericValue(), arg0.getNumericValue2(), 13.0F, 3.0F, 1.5F, 0.0F, arg0.getEasingServiceComponent().getNumericValue(), NewThemeRenderHelper.INSTANCE.getColor5(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        Color[] var32 = new Color[1];
        var32[0] = PolygonShaderComponent.INSTANCE.resolveColor(new Color(1157627903, 1), (arg0.getEasingServiceComponent().getNumericValue() * 0.1F));
        PolygonShaderComponent.INSTANCE.executeAction((var30 + 14), (arg0.getNumericValue() + 2), 0.5F, 9.0F);
        if (arg0.getMinecraftObject() == null) {
        } else {
        }
        arg2.render((arg0.getString() + arg0.getString2()), arg0.getString2(), (var30 + 16.0F), (arg0.getNumericValue() + 1.0F), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor7(), arg0.getEasingServiceComponent().getNumericValue()));
        if (arg0.getMinecraftObject() == null) {
            MissingnoRenderHelper.executeAction(arg0.getMissingnoRenderHelper(), (Matrix3x2f) var31, (var30 + 2.0D), (arg0.getNumericValue() + 0.5D), 0.0F, 0.0F, null, null, 0.0F);
        } else {
            arg2.method_51448().translate((var30 + 2.0F), (arg0.getNumericValue() + 1.0F));
            arg2.method_51448().scale(0.65F, 0.65F);
            arg2.method_51427(arg0.getMinecraftObject(), 0, 0);
            arg2.method_51448().scale(1.0F, 1.0F);
            arg2.method_51448().translate((var30 + 2.0F), (arg0.getNumericValue() + 1.0F));
        }
        var31.popMatrix();
    }

    private float computeValue(float arg0, float arg1) {
        return (arg0 + ((arg1 - arg0) / 8.0F));
    }

    private static void executeAction(String arg0, String arg1, OptionMode16 arg2, int arg3, ItemStack arg4) {
        itemList.add(new TitleServiceComponent(arg0, arg1, arg2, (arg3 * 1600), arg4));
        if (var12 != null) {
            StartupServiceComponent.INSTANCE.getVecServiceComponent7().updateValue();
        }
        StartupServiceComponent.INSTANCE.getVecServiceComponent6().updateValue();
    }

    private static boolean checkCondition(TitleServiceComponent arg0) {
        return arg0.checkCondition();
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return (Boolean) arg0.invoke(arg1);
    }

    static {
        INSTANCE = new TitleRenderHelper();
        itemList = new ArrayList();
        missingnoRenderHelper = new MissingnoRenderHelper("on", 9, 9);
        missingnoRenderHelper2 = new MissingnoRenderHelper("off", 9, 9);
        missingnoRenderHelper3 = new MissingnoRenderHelper("warning", 9, 9);
        missingnoRenderHelper4 = new MissingnoRenderHelper("info", 9, 9);
        missingnoRenderHelper5 = new MissingnoRenderHelper("success", 9, 9);
        missingnoRenderHelper6 = new MissingnoRenderHelper("error", 9, 9);
    }

    public static void updateValue(int arg0) {
        countValue = arg0;
    }

    public static int getNumericValue() {
        return countValue;
    }

    public static int getNumericValue2() {
        return 90;
        return 0;
    }

}
