package su.catlean.client.services.render;

import it.unimi.dsi.fastutil.chars.Char2ObjectArrayMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.awt.Color;
import java.awt.Font;
import java.io.Closeable;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import net.minecraft.class_1041;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import org.joml.Matrix3x2fStack;
import su.catlean.SharedKt;
import su.catlean.client.services.client.FontServiceComponent;
import su.catlean.client.services.render.shader.TextShaderComponent;

public class FontRenderHelper implements Closeable {

    private Font font;
    private Font font2;
    private final float factorValue;
    private final Object2ObjectOpenHashMap object2ObjectOpenHashMap;
    private final Object2ObjectOpenHashMap object2ObjectOpenHashMap2;
    private final ObjectArrayList objectArrayList;
    private final Char2ObjectArrayMap char2ObjectArrayMap;
    private int countValue;
    private float factorValue2;
    private static int[] countValueArray;

    public FontRenderHelper(Font font, Font fallBack, float size) {
        this.font = font;
        this.font2 = fallBack;
        this.factorValue = size;
        this.object2ObjectOpenHashMap = new Object2ObjectOpenHashMap();
        this.object2ObjectOpenHashMap2 = new Object2ObjectOpenHashMap();
        this.objectArrayList = new ObjectArrayList();
        this.char2ObjectArrayMap = new Char2ObjectArrayMap();
        this.updateValue();
    }

    public float getNumericValue() {
        return this.factorValue2;
    }

    public void updateValue(float value) {
        this.factorValue2 = value;
    }

    public void updateValue() {
        this.countValue = SharedKt.getMc().method_22683().method_4495();
        this.font = this.font.deriveFont((this.factorValue * this.countValue));
        this.font2 = this.font2.deriveFont((this.factorValue * this.countValue));
    }

    public void render(DrawContext context, String s, float x, float y, Color color) {
        v(this, context.method_51448(), s, x, y, color, false);
    }

    public void executeAction(Matrix3x2fStack m, String s, float x, float y, Color color, boolean gradient, int offset) {
        float factor = this.factorValue2;
        Font font = this.font2;
        Font font2 = this.font;
        ObjectArrayList list = this.objectArrayList;
        Char2ObjectArrayMap char2ObjectArrayMap = this.char2ObjectArrayMap;
        int index = this.countValue;
        TextShaderComponent textShaderComponent = TextShaderComponent.INSTANCE;
        this.factorValue2 = (this.factorValue2 + 0.1F);
        textShaderComponent.executeAction(m, s, x, y, color, gradient, offset, index, char2ObjectArrayMap, list, font2, font, factor, this.object2ObjectOpenHashMap2);
    }

    public void executeAction(Matrix3x2fStack m, String s, float x, float y, Color color, boolean gradient, int offset) {
        TextShaderComponent.INSTANCE.executeAction(m, s, x, y, color, gradient, offset, this.countValue, this.char2ObjectArrayMap, this.objectArrayList, this.font, this.font2, this.object2ObjectOpenHashMap);
    }

    public void executeAction(Matrix3x2fStack m, String s, float x, float y, Color color) {
        v(this, m, s, (x - (this.computeValue(s) / 2.0F)), (y - (TextShaderComponent.INSTANCE.computeValue(s, this.char2ObjectArrayMap, this.objectArrayList, this.font, this.font2, this.countValue) / 2.0F)), color, false);
    }

    public void render(DrawContext context, String s, float x, float y, Color color) {
        v(this, context.method_51448(), s, (x - (this.computeValue(s) / 2.0F)), (y - (TextShaderComponent.INSTANCE.computeValue(s, this.char2ObjectArrayMap, this.objectArrayList, this.font, this.font2, this.countValue) / 2.0F)), color, false);
    }

    public void executeAction() {
        TextShaderComponent.INSTANCE.executeAction(this.object2ObjectOpenHashMap2);
        this.factorValue2 = 0.0F;
    }

    public float computeValue(String s) {
        return TextShaderComponent.INSTANCE.computeValue(s, this.char2ObjectArrayMap, this.objectArrayList, this.font, this.font2, this.countValue);
    }

    public void close() {
        FontRenderHelper fontRenderHelper = ((FontRenderHelper) this);
        int index = 0;
        fontRenderHelper.objectArrayList.removeIf(this::checkCondition);
        fontRenderHelper.char2ObjectArrayMap.clear();
        fontRenderHelper = Result.constructor_impl(Unit.INSTANCE);
        fontRenderHelper = Result.constructor_impl(ResultKt.createFailure(index));
    }

    public void render(DrawContext context, String s, float x, float y, int offset) {
        int index = 1;
        Color color = Color.WHITE;
        Matrix3x2fStack matrix3x2fStack = context.method_51448();
        this.executeAction(matrix3x2fStack, s, x, y, color, index, offset);
    }

    public void render(DrawContext context, String s, float x, float y, int i) {
        this.render(context, s, (x - (this.computeValue(s) / 2.0F)), y, i);
    }

    private static boolean checkCondition(FontServiceComponent arg0) {
        arg0.updateValue();
        return true;
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return ((Boolean) arg0.invoke(arg1));
    }

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

    public static int[] process() {
        return countValueArray;
    }

}
