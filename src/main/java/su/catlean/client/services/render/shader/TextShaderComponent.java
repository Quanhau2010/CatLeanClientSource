package su.catlean.client.services.render.shader;

import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.vertex.VertexFormat;
import it.unimi.dsi.fastutil.chars.Char2IntArrayMap;
import it.unimi.dsi.fastutil.chars.Char2ObjectArrayMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap.Entry;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap.FastEntrySet;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import it.unimi.dsi.fastutil.objects.ObjectSet;
import java.awt.Color;
import java.awt.Font;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import net.minecraft.class_1044;
import net.minecraft.class_1060;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.client.MinecraftClient;
import org.joml.Matrix3x2f;
import org.joml.Matrix3x2fStack;
import org.joml.Matrix3x2fc;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.utility.misc.NameProtectModule;
import su.catlean.client.services.client.FontServiceComponent;
import su.catlean.client.services.client.MatrixServiceComponent;
import su.catlean.client.services.client.OwnerServiceComponent;
import su.catlean.client.services.client.StringServiceComponent2;
import su.catlean.client.services.render.FormatRenderHelper;
import su.catlean.client.services.render.NewThemeRenderHelper;

public class TextShaderComponent {

    public static final TextShaderComponent INSTANCE;
    private static final char fieldValue;
    private static final Char2IntArrayMap char2IntArrayMap;

    private TextShaderComponent() {
    }

    public Char2IntArrayMap getChar2IntArrayMap() {
        return char2IntArrayMap;
    }

    public int computeValue(int x, int n) {
        return (n * Math.floor((x / n)));
    }

    public String resolveString(String text) {
        char[] items = text.toCharArray();
        StringBuilder stringBuilder = new StringBuilder(items);
        int index = 0;
        if (index < items) {
            Object element = items[index];
            if (__UNDEF_KEY__ >= 0) {
                if (element == 167) {
                    if ((index + 1) < items) {
                        Object element2 = items[(index + 1)];
                        if (__UNDEF_KEY__ >= 0 && __UNDEF_KEY__ >= 0) {
                            if (this.checkCondition(items, index)) {
                            }
                        }
                        stringBuilder.append(element);
                    }
                }
            }
        }
        return stringBuilder.toString();
    }

    public class_2960 resolveMinecraftObject() {
        return StringServiceComponent2.resolveMinecraftObject("catlean", ("temp/" + this.resolveString()));
    }

    public String resolveString() {
        return ((String) IntStream.range(0, 32).mapToObj(this::resolveString).collect(Collectors.joining()));
    }

    public int[] process(int i) {
        int index = ((i >> 16) & 255);
        int index2 = ((i >> 8) & 255);
        int index3 = (i & 255);
        Object element = new int[3];
        element[0] = index;
        element[1] = index2;
        element[2] = index3;
        return element;
    }

    public float computeValue(float n) {
        if (Float.isNaN(n)) {
        } else {
        }
        return (MathKt.roundToInt(((MathKt.roundToInt((n * 100.0F)) / 100.0F) * 10.0F)) / 10.0F);
    }

    public FontServiceComponent resolveFontServiceComponent(char from, char to, Font font, ObjectArrayList maps, int padding) {
        FontServiceComponent fontServiceComponent = new FontServiceComponent(from, to, font, this.resolveMinecraftObject(), padding);
        maps.add(fontServiceComponent);
        return fontServiceComponent;
    }

    public OwnerServiceComponent resolveOwnerServiceComponent(char glyph, ObjectArrayList maps, Font font, Font fallBack) {
        int index = 5;
        int index2 = 512;
        ObjectListIterator iterator = maps.iterator();
        while (iterator.hasNext()) {
            return this.resolveOwnerServiceComponent(glyph);
        }
        iterator = this.computeValue(glyph, index2);
        if (font.canDisplay(glyph)) {
            return __UNDEF_KEY__;
        }
        if (fallBack.canDisplay(glyph)) {
            return this.resolveFontServiceComponent(iterator, (iterator + index2), fallBack, maps, index).resolveOwnerServiceComponent(glyph);
        }
        return null;
    }

    public OwnerServiceComponent resolveOwnerServiceComponent(char glyph, Char2ObjectArrayMap allGlyphs, ObjectArrayList maps, Font font, Font fallBack) {
        if (((OwnerServiceComponent) allGlyphs.get(glyph)) != null) {
            OwnerServiceComponent ownerServiceComponent = ((OwnerServiceComponent) allGlyphs.get(glyph));
            return ownerServiceComponent;
        }
        OwnerServiceComponent ownerServiceComponent2 = this.resolveOwnerServiceComponent(glyph, maps, font, fallBack);
        return ownerServiceComponent2;
    }

    public void executeAction(Matrix3x2fStack stack, String s, float x, float y, Color color, boolean gradient, int offset, float scaleMul, Char2ObjectArrayMap allGlyphs, ObjectArrayList maps, Font font, Font fallBack, Object2ObjectOpenHashMap glyphPage) {
        String text = NameProtectModule.INSTANCE.resolveString(s);
        int index = (color.getRed() / 255.0F);
        int index2 = (color.getGreen() / 255.0F);
        int index3 = (color.getBlue() / 255.0F);
        int index4 = (color.getAlpha() / 255.0F);
        float factor = this.computeValue((x + 0.5F));
        float factor2 = this.computeValue((y + 1.5F));
        stack.pushMatrix();
        stack.translate(factor, factor2);
        stack.scale((1.0F / scaleMul), (1.0F / scaleMul));
        Matrix3x2f matrix3x2f = new Matrix3x2f(((Matrix3x2fc) stack));
        char[] items = text.toCharArray();
        float factor3 = 0.0F;
        float factor4 = 0.0F;
        int index5 = 0;
        int index6 = 0;
        int index7 = 0;
        if (index7 < items) {
            Object element = items[index7];
            if (__UNDEF_KEY__ > 0) {
                if (__UNDEF_KEY__ != null) {
                    if (index5) {
                        index5 = 0;
                        int index8 = ((Number) this.component1());
                        int index9 = ((Number) this.component2());
                        int index10 = ((Number) this.component3());
                        index = (index8 / 255.0F);
                        index2 = (index9 / 255.0F);
                        index3 = (index10 / 255.0F);
                        if (__UNDEF_KEY__ < 0 || __UNDEF_KEY__ == null || __UNDEF_KEY__ >= 0) {
                            continue;
                        }
                        if (__UNDEF_KEY__ == 82) {
                            index = (color.getRed() / 255.0F);
                            index2 = (color.getGreen() / 255.0F);
                            index3 = (color.getBlue() / 255.0F);
                            index4 = (color.getAlpha() / 255.0F);
                        }
                    }
                }
            }
            if (__UNDEF_KEY__ > 0 && __UNDEF_KEY__ != null) {
                if (gradient) {
                    index = (this.getRed() / 255.0F);
                    index2 = (this.getGreen() / 255.0F);
                    index3 = (this.getBlue() / 255.0F);
                    index4 = (this.getAlpha() / 255.0F);
                }
            }
            index5 = 1;
            factor4 = (factor4 + (this.computeValue(text.substring(index6, index7), allGlyphs, maps, font, fallBack, scaleMul) * scaleMul));
            factor3 = 0.0F;
            index6 = (index7 + 1);
            if (this.resolveOwnerServiceComponent(element, allGlyphs, maps, font, fallBack).process() != 32) {
                index8 = element.getFontServiceComponent().getMinecraftObject();
                index9 = new MatrixServiceComponent(factor3, factor4, index, index2, index3, index4, this.getNumericValue3(), this.getNumericValue4(), this.getFontServiceComponent().getNumericValue(), this.getFontServiceComponent().getNumericValue2(), this.getNumericValue(), this.getNumericValue2(), 0.0F, matrix3x2f);
            }
            factor3 = (factor3 + this.getNumericValue3());
        }
        element = ((ObjectSet) glyphPage.keySet()).iterator();
        while (element.hasNext()) {
            index8 = SharedKt.getMc().method_1531().method_4619().method_71659();
            index9 = ((ObjectList) glyphPage.get());
            int index11 = 4;
            int index12 = 0;
            int index13 = index9.size();
            VertexFormat vertexFormat = class_290.field_1575;
            index10 = new FormatRenderHelper(vertexFormat, index13, index12, index11);
            ObjectListIterator iterator = index9.iterator();
            while (iterator.hasNext()) {
                MatrixServiceComponent matrixServiceComponent = ((MatrixServiceComponent) iterator.next());
                float factor5 = matrixServiceComponent.getNumericValue();
                float factor6 = matrixServiceComponent.getNumericValue2();
                int index14 = matrixServiceComponent.getNumericValue();
                int index15 = matrixServiceComponent.getNumericValue2();
                int index16 = (matrixServiceComponent.getNumericValue5() / matrixServiceComponent.getNumericValue3());
                int index17 = (matrixServiceComponent.getNumericValue6() / matrixServiceComponent.getNumericValue4());
                int index18 = ((matrixServiceComponent.getNumericValue5() + matrixServiceComponent.getNumericValue()) / matrixServiceComponent.getNumericValue3());
                int index19 = ((matrixServiceComponent.getNumericValue6() + matrixServiceComponent.getNumericValue2()) / matrixServiceComponent.getNumericValue4());
                FormatRenderHelper.resolveFormatRenderHelper(index10, (factor5 + 0), (factor6 + index15), 0.0F).resolveFormatRenderHelper(index16, index19).resolveFormatRenderHelper(matrixServiceComponent.getNumericValue3(), matrixServiceComponent.getNumericValue4(), matrixServiceComponent.getNumericValue5(), matrixServiceComponent.getNumericValue6());
                FormatRenderHelper.resolveFormatRenderHelper(index10, (factor5 + index14), (factor6 + index15), 0.0F).resolveFormatRenderHelper(index18, index19).resolveFormatRenderHelper(matrixServiceComponent.getNumericValue3(), matrixServiceComponent.getNumericValue4(), matrixServiceComponent.getNumericValue5(), matrixServiceComponent.getNumericValue6());
                FormatRenderHelper.resolveFormatRenderHelper(index10, (factor5 + index14), (factor6 + 0), 0.0F).resolveFormatRenderHelper(index18, index17).resolveFormatRenderHelper(matrixServiceComponent.getNumericValue3(), matrixServiceComponent.getNumericValue4(), matrixServiceComponent.getNumericValue5(), matrixServiceComponent.getNumericValue6());
                FormatRenderHelper.resolveFormatRenderHelper(index10, (factor5 + 0), (factor6 + 0), 0.0F).resolveFormatRenderHelper(index16, index17).resolveFormatRenderHelper(matrixServiceComponent.getNumericValue3(), matrixServiceComponent.getNumericValue4(), matrixServiceComponent.getNumericValue5(), matrixServiceComponent.getNumericValue6());
            }
            FormatRenderHelper.executeAction(index10, VertexUBOShaderComponent.INSTANCE.getRenderPipeline14(), SharedKt.getMc().method_1522(), null, null, matrix3x2f, MapsKt.mapOf(TuplesKt.to("Sampler0", index8)));
        }
        glyphPage.clear();
        stack.popMatrix();
    }

    public void executeAction(Matrix3x2fStack stack, String s, float x, float y, Color color, boolean gradient, int offset, float scaleMul, Char2ObjectArrayMap allGlyphs, ObjectArrayList maps, Font font, Font fallBack, float z, Object2ObjectOpenHashMap batchedDraws) {
        String text = NameProtectModule.INSTANCE.resolveString(s);
        int index = (color.getRed() / 255.0F);
        int index2 = (color.getGreen() / 255.0F);
        int index3 = (color.getBlue() / 255.0F);
        int index4 = (color.getAlpha() / 255.0F);
        float factor = this.computeValue((x + 0.5F));
        float factor2 = this.computeValue((y + 1.5F));
        stack.pushMatrix();
        stack.translate(factor, factor2);
        stack.scale((1.0F / scaleMul), (1.0F / scaleMul));
        Matrix3x2f matrix3x2f = new Matrix3x2f(((Matrix3x2fc) stack));
        char[] items = text.toCharArray();
        float factor3 = 0.0F;
        float factor4 = 0.0F;
        int index5 = 0;
        int index6 = 0;
        int index7 = 0;
        if (index7 < items) {
            Object element = items[index7];
            if (index5) {
                index5 = 0;
                int index8 = ((Number) this.component1());
                int index9 = ((Number) this.component2());
                int index10 = ((Number) this.component3());
                index = (index8 / 255.0F);
                index2 = (index9 / 255.0F);
                index3 = (index10 / 255.0F);
                if (char2IntArrayMap.containsKey()) {
                    index8 = char2IntArrayMap.get();
                    index9 = this.process(index8);
                    index = (index9[0] / 255.0F);
                    index2 = (index9[1] / 255.0F);
                    index3 = (index9[2] / 255.0F);
                } else {
                    if (Character.toUpperCase(element) == 82) {
                        index = (color.getRed() / 255.0F);
                        index2 = (color.getGreen() / 255.0F);
                        index3 = (color.getBlue() / 255.0F);
                        index4 = (color.getAlpha() / 255.0F);
                    }
                }
            }
            if (gradient) {
                index = (this.getRed() / 255.0F);
                index2 = (this.getGreen() / 255.0F);
                index3 = (this.getBlue() / 255.0F);
                index4 = (this.getAlpha() / 255.0F);
            }
            index5 = 1;
            factor4 = (factor4 + (this.computeValue(text.substring(index6, index7), allGlyphs, maps, font, fallBack, scaleMul) * scaleMul));
            factor3 = 0.0F;
            index6 = (index7 + 1);
            if (this.resolveOwnerServiceComponent(element, allGlyphs, maps, font, fallBack).process() != 32) {
                index8 = element.getFontServiceComponent().getMinecraftObject();
                index9 = new MatrixServiceComponent(factor3, factor4, index, index2, index3, index4, this.getNumericValue3(), this.getNumericValue4(), this.getFontServiceComponent().getNumericValue(), this.getFontServiceComponent().getNumericValue2(), this.getNumericValue(), this.getNumericValue2(), z, matrix3x2f);
                if (!(Intrinsics.areEqual(index8))) {
                    int index11 = index8;
                    index10 = ((ObjectList) batchedDraws.get(index8));
                    if (index10 == null) {
                        index10 = ((ObjectList) new ObjectArrayList());
                    }
                    int index12 = index10;
                }
                index12.add(index9);
            }
            factor3 = (factor3 + this.getNumericValue3());
        }
        stack.popMatrix();
    }

    public float computeValue(String text, Char2ObjectArrayMap allGlyphs, ObjectArrayList maps, Font font, Font fallBack, float scaleMul) {
        String text2 = NameProtectModule.INSTANCE.resolveString(text);
        char[] items = this.resolveString(text2).toCharArray();
        if (!(items)) {
            Object element = new char[1];
            element[0] = 32;
            items = element;
        }
        element = 0.0F;
        float factor = 0.0F;
        int index = 0;
        if (index < items) {
            Object element2 = items[index];
            if (__UNDEF_KEY__ > 0 && __UNDEF_KEY__ != null) {
                if (element2 == 10) {
                    if (element == 0.0F) {
                        if (__UNDEF_KEY__ > 0L) {
                            if (this.resolveOwnerServiceComponent(32, allGlyphs, maps, font, fallBack) != null) {
                            } else {
                                this.resolveOwnerServiceComponent(32, allGlyphs, maps, font, fallBack).getNumericValue4();
                            }
                        }
                        element = (1.0F / scaleMul);
                    }
                    factor = (factor + element);
                    element = 0.0F;
                    if (__UNDEF_KEY__ == null) {
                        OwnerServiceComponent ownerServiceComponent = this.resolveOwnerServiceComponent(element2, allGlyphs, maps, font, fallBack);
                        if (ownerServiceComponent == null) {
                        } else {
                        }
                        element = Math.max((this.getNumericValue4() / scaleMul), element);
                    }
                }
            }
        }
        return (element + factor);
    }

    public void executeAction(Object2ObjectOpenHashMap batchedDraws) {
        if (__UNDEF_KEY__ != null) {
            if (batchedDraws.isEmpty()) {
                return;
            }
        }
        ObjectIterator iterator = batchedDraws.object2ObjectEntrySet().iterator();
        while (iterator.hasNext()) {
            Entry entry = ((Entry) iterator.next());
            class_2960 class2960 = ((class_2960) ((java.util.Map.Entry) entry).getKey());
            ObjectList list = ((ObjectList) ((java.util.Map.Entry) entry).getValue());
            GpuTextureView gpuTextureView = SharedKt.getMc().method_1531().method_4619(class2960).method_71659();
            int index = 4;
            int index2 = 0;
            int index3 = list.size();
            VertexFormat vertexFormat = class_290.field_1575;
            FormatRenderHelper formatRenderHelper = new FormatRenderHelper(vertexFormat, index3, index2, index);
            ObjectListIterator iterator2 = list.iterator();
            while (iterator2.hasNext()) {
                MatrixServiceComponent matrixServiceComponent = ((MatrixServiceComponent) iterator2.next());
                Matrix3x2f matrix3x2f = matrixServiceComponent.getMatrix3x2f();
                float factor = matrixServiceComponent.getNumericValue();
                float factor2 = matrixServiceComponent.getNumericValue2();
                int index4 = matrixServiceComponent.getNumericValue();
                int index5 = matrixServiceComponent.getNumericValue2();
                int index6 = (matrixServiceComponent.getNumericValue5() / matrixServiceComponent.getNumericValue3());
                int index7 = (matrixServiceComponent.getNumericValue6() / matrixServiceComponent.getNumericValue4());
                int index8 = ((matrixServiceComponent.getNumericValue5() + matrixServiceComponent.getNumericValue()) / matrixServiceComponent.getNumericValue3());
                int index9 = ((matrixServiceComponent.getNumericValue6() + matrixServiceComponent.getNumericValue2()) / matrixServiceComponent.getNumericValue4());
                formatRenderHelper.resolveFormatRenderHelper(matrix3x2f, factor, (factor2 + index5), matrixServiceComponent.getNumericValue7()).resolveFormatRenderHelper(index6, index9).resolveFormatRenderHelper(matrixServiceComponent.getNumericValue3(), matrixServiceComponent.getNumericValue4(), matrixServiceComponent.getNumericValue5(), matrixServiceComponent.getNumericValue6());
                formatRenderHelper.resolveFormatRenderHelper(matrix3x2f, (factor + index4), (factor2 + index5), matrixServiceComponent.getNumericValue7()).resolveFormatRenderHelper(index8, index9).resolveFormatRenderHelper(matrixServiceComponent.getNumericValue3(), matrixServiceComponent.getNumericValue4(), matrixServiceComponent.getNumericValue5(), matrixServiceComponent.getNumericValue6());
                formatRenderHelper.resolveFormatRenderHelper(matrix3x2f, (factor + index4), factor2, matrixServiceComponent.getNumericValue7()).resolveFormatRenderHelper(index8, index7).resolveFormatRenderHelper(matrixServiceComponent.getNumericValue3(), matrixServiceComponent.getNumericValue4(), matrixServiceComponent.getNumericValue5(), matrixServiceComponent.getNumericValue6());
                formatRenderHelper.resolveFormatRenderHelper(matrix3x2f, factor, factor2, matrixServiceComponent.getNumericValue7()).resolveFormatRenderHelper(index6, index7).resolveFormatRenderHelper(matrixServiceComponent.getNumericValue3(), matrixServiceComponent.getNumericValue4(), matrixServiceComponent.getNumericValue5(), matrixServiceComponent.getNumericValue6());
                if (__UNDEF_KEY__ != null) {
                    FormatRenderHelper.executeAction(formatRenderHelper, VertexUBOShaderComponent.INSTANCE.getRenderPipeline15(), SharedKt.getMc().method_1522(), null, null, new Matrix3x2f(), MapsKt.mapOf(TuplesKt.to("Sampler0", gpuTextureView)));
                }
            }
        }
        batchedDraws.clear();
    }

    public float computeValue(String text, Char2ObjectArrayMap allGlyphs, ObjectArrayList maps, Font font, Font fallBack, float scaleMul) {
        String text2 = NameProtectModule.INSTANCE.resolveString(text);
        char[] items = this.resolveString(text2).toCharArray();
        float factor = 0.0F;
        float factor2 = 0.0F;
        int index = 0;
        if (index < items) {
            Object element = items[index];
            if (__UNDEF_KEY__ >= 0) {
                if (element == 10) {
                    factor2 = Math.max(factor, factor2);
                    factor = 0.0F;
                    if (__UNDEF_KEY__ < 0) {
                        OwnerServiceComponent ownerServiceComponent = this.resolveOwnerServiceComponent(element, allGlyphs, maps, font, fallBack);
                        if (__UNDEF_KEY__ >= 0) {
                            if (ownerServiceComponent == null) {
                            } else {
                            }
                        }
                        factor = (factor + (this.getNumericValue3() / scaleMul));
                    }
                }
            }
        }
        return Math.max(factor, factor2);
    }

    private int computeValue(char arg0) {
        if (48 <= arg0) {
        } else {
            if (arg0 < 58) {
            } else {
                if (97 <= arg0) {
                } else {
                    if (arg0 < 103) {
                    } else {
                        if (65 <= arg0) {
                        } else {
                            if (arg0 < 71) {
                            } else {
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

    private boolean checkCondition(char[] arg0, int arg1, short arg2, int arg3, int arg4) {
        if ((arg1 + 13) >= arg0) {
            return false;
        }
        if (arg3 > 0) {
            if (arg0[arg1] != 167) {
                return false;
            }
        }
        Object element = arg0[(arg1 + 1)];
        if (element != 120) {
            if (arg3 >= 0 && arg3 >= 0) {
                if (element != 88) {
                    return false;
                }
            }
        }
        int index = 0;
        index = (arg1 + 2);
        int index2 = 6;
        int index3 = 0;
        if (index3 < index2) {
            if (arg4 >= 0) {
                if (arg2 >= 0) {
                    if (arg0[index] != 167) {
                        return false;
                    }
                }
                if (arg4 > 0) {
                    if (INSTANCE.computeValue(arg0[(index + 1)]) < 0) {
                        return false;
                    }
                }
                index = (index + 2);
            }
        }
        return true;
    }

    private Triple resolveTriple(short arg0, char[] arg1, char arg2, int arg3) {
        if ((arg3 - 1) >= 0) {
            if (arg1[(arg3 - 1)] != 167) {
                return null;
            }
        }
        if (arg2 >= 0 && arg2 >= 0) {
        }
        if ((arg3 + 12) >= arg1) {
            return null;
        }
        int index = 0;
        int index2 = 0;
        index2 = (arg3 + 1);
        int index3 = 6;
        int index4 = 0;
        if (index4 < index3) {
            int index5 = index4;
            if (arg1[index2] != 167) {
                return null;
            }
            int index6 = INSTANCE.computeValue(arg1[(index2 + 1)]);
            if (index6 < 0) {
                return null;
            }
            index = ((index << 4) | index6);
            index2 = (index2 + 2);
        }
        index3 = ((index >> 16) & 255);
        index4 = ((index >> 8) & 255);
        if (arg0 < 0 || arg2 >= 0) {
            continue;
        }
        index5 = (index & 1331);
        return new Triple(Integer.valueOf(index3), Integer.valueOf(index4), Integer.valueOf(index5));
    }

    private static String resolveString() {
        return String.valueOf(new Random().nextInt(97, 123));
    }

    private static ObjectList resolveObjectList(Object arg0) {
        return ((ObjectList) new ObjectArrayList());
    }

    static {
        INSTANCE = new TextShaderComponent();
        char2IntArrayMap = new Char2IntArrayMap();
        char2IntArrayMap.put(48, 0);
        char2IntArrayMap.put(49, 170);
        char2IntArrayMap.put(50, 43520);
        char2IntArrayMap.put(51, 43690);
        char2IntArrayMap.put(52, 11141120);
        char2IntArrayMap.put(53, 11141290);
        char2IntArrayMap.put(54, 16755200);
        char2IntArrayMap.put(55, 11184810);
        char2IntArrayMap.put(56, 5592405);
        char2IntArrayMap.put(57, 5592575);
        char2IntArrayMap.put(65, 5635925);
        char2IntArrayMap.put(97, 5635925);
        char2IntArrayMap.put(66, 5636095);
        char2IntArrayMap.put(98, 5636095);
        char2IntArrayMap.put(67, 16733525);
        char2IntArrayMap.put(99, 16733525);
        char2IntArrayMap.put(68, 16733695);
        char2IntArrayMap.put(100, 16733695);
        char2IntArrayMap.put(69, 16777045);
        char2IntArrayMap.put(101, 16777045);
        char2IntArrayMap.put(70, 16777215);
        char2IntArrayMap.put(102, 16777215);
    }

}
