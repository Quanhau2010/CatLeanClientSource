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
        char[] var10 = text.toCharArray();
        StringBuilder var11 = new StringBuilder();
        int var12 = 0;
        if (var12 < var10) {
            Object var13 = var10[var12];
            if (0L >= 0) {
                if (var13 == 167) {
                    if ((var12 + 1) < var10) {
                        Object var14 = var10[(var12 + 1)];
                        if (0L >= 0 && 0L >= 0) {
                            if (this.checkCondition()) {
                            }
                        }
                    }
                    var11.append();
                }
            }
        }
        return var11.toString();
    }

    public class_2960 resolveMinecraftObject() {
        return StringServiceComponent2.resolveMinecraftObject("catlean", ("temp/" + this.resolveString()));
    }

    public String resolveString() {
        return (String) IntStream.range(0, 32).mapToObj(this::resolveString).collect(Collectors.joining());
    }

    public int[] process(int i) {
        int var4 = ((i >> 16) & 255);
        int var5 = ((i >> 8) & 255);
        int var6 = (i & 255);
        Object var7 = new int[3];
        var7[0] = var4;
        var7[1] = var5;
        var7[2] = var6;
        return var7;
    }

    public float computeValue(float n) {
        if (Float.isNaN(n)) {
        } else {
        }
        return (MathKt.roundToInt(((MathKt.roundToInt((n * 100.0F)) / 100.0F) * 10.0F)) / 10.0F);
    }

    public FontServiceComponent resolveFontServiceComponent(char from, char to, Font font, ObjectArrayList maps, int padding) {
        FontServiceComponent var12 = new FontServiceComponent(from, to, font, this.resolveMinecraftObject(), padding);
        maps.add();
        return var12;
    }

    public OwnerServiceComponent resolveOwnerServiceComponent(char glyph, ObjectArrayList maps, Font font, Font fallBack) {
        int var13 = 5;
        int var14 = 512;
        ObjectListIterator iterator = maps.iterator();
        if (iterator.hasNext()) {
            return var16.resolveOwnerServiceComponent(glyph);
        }
        iterator = this.computeValue(glyph);
        if (font.canDisplay(glyph)) {
            return var16;
        }
        if (fallBack.canDisplay(glyph)) {
            return this.resolveFontServiceComponent(iterator, (iterator + var14), fallBack, maps).resolveOwnerServiceComponent(glyph);
        }
        return null;
    }

    public OwnerServiceComponent resolveOwnerServiceComponent(char glyph, Char2ObjectArrayMap allGlyphs, ObjectArrayList maps, Font font, Font fallBack) {
        if ((OwnerServiceComponent) allGlyphs.get(glyph) != null) {
            OwnerServiceComponent var14 = (OwnerServiceComponent) allGlyphs.get(glyph);
            int var15 = 0;
            return var14;
        }
        OwnerServiceComponent var13 = this.resolveOwnerServiceComponent(glyph, maps, font, fallBack);
        return var13;
    }

    public void executeAction(Matrix3x2fStack stack, String s, float x, float y, Color color, boolean gradient, int offset, float scaleMul, Char2ObjectArrayMap allGlyphs, ObjectArrayList maps, Font font, Font fallBack, Object2ObjectOpenHashMap glyphPage) {
        String var59 = NameProtectModule.INSTANCE.resolveString(s);
        int var60 = (color.getRed() / 255.0F);
        int var61 = (color.getGreen() / 255.0F);
        int var62 = (color.getBlue() / 255.0F);
        int var63 = (color.getAlpha() / 255.0F);
        float var64 = this.computeValue((x + 0.5F));
        float var65 = this.computeValue((y + 1.5F));
        stack.pushMatrix();
        stack.translate();
        stack.scale((1.0F / scaleMul), (1.0F / scaleMul));
        Matrix3x2f var66 = new Matrix3x2f((Matrix3x2fc) stack);
        char[] var67 = var59.toCharArray();
        float var68 = 0.0F;
        float var69 = 0.0F;
        int var70 = 0;
        int var71 = 0;
        int var72 = 0;
        if (var72 < var67) {
            Object var73 = var67[var72];
            if (0L > 0) {
                if (var58 != null) {
                    if (var70) {
                        var70 = 0;
                        int var75 = (Number) var74.component1();
                        int var76 = (Number) var74.component2();
                        int var77 = (Number) var74.component3();
                        var60 = (var75 / 255.0F);
                        var61 = (var76 / 255.0F);
                        var62 = (var77 / 255.0F);
                        if (0L < 0 || var58 == null || 0L >= 0) {
                            continue;
                        }
                        if (var58 == 82) {
                            var60 = (color.getRed() / 255.0F);
                            var61 = (color.getGreen() / 255.0F);
                            var62 = (color.getBlue() / 255.0F);
                            var63 = (color.getAlpha() / 255.0F);
                        }
                    }
                }
            }
            if (0L > 0 && var58 != null) {
                if (gradient) {
                    var60 = (var74.getRed() / 255.0F);
                    var61 = (var74.getGreen() / 255.0F);
                    var62 = (var74.getBlue() / 255.0F);
                    var63 = (var74.getAlpha() / 255.0F);
                }
            }
            var70 = 1;
            var69 = (var69 + (this.computeValue(var59.substring(), allGlyphs, maps, font, fallBack, scaleMul) * scaleMul));
            var68 = 0.0F;
            var71 = (var72 + 1);
            if (this.resolveOwnerServiceComponent(allGlyphs, maps, font, fallBack).process() != 32) {
                var75 = var73.getFontServiceComponent().getMinecraftObject();
                var76 = new MatrixServiceComponent(var74.getNumericValue3(), var74.getNumericValue4(), var74.getFontServiceComponent().getNumericValue(), var74.getFontServiceComponent().getNumericValue2(), var74.getNumericValue(), var74.getNumericValue2(), 0.0F);
            }
            var68 = (var68 + var74.getNumericValue3());
        }
        var73 = (ObjectSet) glyphPage.keySet().iterator();
        while (var73.hasNext()) {
            var75 = SharedKt.getMc().method_1531().method_4619().method_71659();
            var76 = (ObjectList) glyphPage.get();
            int var54 = 4;
            int var55 = 0;
            int var56 = var76.size();
            VertexFormat var57 = class_290.field_1575;
            var77 = new FormatRenderHelper();
            ObjectListIterator iterator = var76.iterator();
            while (iterator.hasNext()) {
                MatrixServiceComponent var79 = (MatrixServiceComponent) iterator.next();
                float var80 = var79.getNumericValue();
                float var81 = var79.getNumericValue2();
                int var82 = var79.getNumericValue();
                int var83 = var79.getNumericValue2();
                int var84 = (var79.getNumericValue5() / var79.getNumericValue3());
                int var85 = (var79.getNumericValue6() / var79.getNumericValue4());
                int var86 = ((var79.getNumericValue5() + var79.getNumericValue()) / var79.getNumericValue3());
                int var87 = ((var79.getNumericValue6() + var79.getNumericValue2()) / var79.getNumericValue4());
                FormatRenderHelper.resolveFormatRenderHelper((var80 + 0), (var81 + var83), 0.0F).resolveFormatRenderHelper().resolveFormatRenderHelper(var79.getNumericValue3(), var79.getNumericValue4(), var79.getNumericValue5(), var79.getNumericValue6());
                FormatRenderHelper.resolveFormatRenderHelper((var80 + var82), (var81 + var83), 0.0F).resolveFormatRenderHelper().resolveFormatRenderHelper(var79.getNumericValue3(), var79.getNumericValue4(), var79.getNumericValue5(), var79.getNumericValue6());
                FormatRenderHelper.resolveFormatRenderHelper((var80 + var82), (var81 + 0), 0.0F).resolveFormatRenderHelper().resolveFormatRenderHelper(var79.getNumericValue3(), var79.getNumericValue4(), var79.getNumericValue5(), var79.getNumericValue6());
                FormatRenderHelper.resolveFormatRenderHelper((var80 + 0), (var81 + 0), 0.0F).resolveFormatRenderHelper().resolveFormatRenderHelper(var79.getNumericValue3(), var79.getNumericValue4(), var79.getNumericValue5(), var79.getNumericValue6());
            }
            FormatRenderHelper.executeAction(VertexUBOShaderComponent.INSTANCE.getRenderPipeline14(), SharedKt.getMc().method_1522(), null, null, MapsKt.mapOf(TuplesKt.to("Sampler0")));
        }
        glyphPage.clear();
        stack.popMatrix();
    }

    public void executeAction(Matrix3x2fStack stack, String s, float x, float y, Color color, boolean gradient, int offset, float scaleMul, Char2ObjectArrayMap allGlyphs, ObjectArrayList maps, Font font, Font fallBack, float z, Object2ObjectOpenHashMap batchedDraws) {
        String var39 = NameProtectModule.INSTANCE.resolveString(s);
        int var40 = (color.getRed() / 255.0F);
        int var41 = (color.getGreen() / 255.0F);
        int var42 = (color.getBlue() / 255.0F);
        int var43 = (color.getAlpha() / 255.0F);
        float var44 = this.computeValue((x + 0.5F));
        float var45 = this.computeValue((y + 1.5F));
        stack.pushMatrix();
        stack.translate();
        stack.scale((1.0F / scaleMul), (1.0F / scaleMul));
        Matrix3x2f var46 = new Matrix3x2f((Matrix3x2fc) stack);
        char[] var47 = var39.toCharArray();
        float var48 = 0.0F;
        float var49 = 0.0F;
        int var50 = 0;
        int var51 = 0;
        int var54 = 0;
        if (var54 < var47) {
            Object var55 = var47[var54];
            if (var50) {
                var50 = 0;
                int var57 = (Number) var56.component1();
                int var58 = (Number) var56.component2();
                int var59 = (Number) var56.component3();
                var40 = (var57 / 255.0F);
                var41 = (var58 / 255.0F);
                var42 = (var59 / 255.0F);
                if (char2IntArrayMap.containsKey()) {
                    var57 = char2IntArrayMap.get();
                    var58 = this.process();
                    var40 = (var58[0] / 255.0F);
                    var41 = (var58[1] / 255.0F);
                    var42 = (var58[2] / 255.0F);
                } else {
                    if (Character.toUpperCase() == 82) {
                        var40 = (color.getRed() / 255.0F);
                        var41 = (color.getGreen() / 255.0F);
                        var42 = (color.getBlue() / 255.0F);
                        var43 = (color.getAlpha() / 255.0F);
                    }
                }
            }
            if (gradient) {
                var40 = (var56.getRed() / 255.0F);
                var41 = (var56.getGreen() / 255.0F);
                var42 = (var56.getBlue() / 255.0F);
                var43 = (var56.getAlpha() / 255.0F);
            }
            var50 = 1;
            var49 = (var49 + (this.computeValue(var39.substring(), allGlyphs, maps, font, fallBack, scaleMul) * scaleMul));
            var48 = 0.0F;
            var51 = (var54 + 1);
            if (this.resolveOwnerServiceComponent(allGlyphs, maps, font, fallBack).process() != 32) {
                var57 = var55.getFontServiceComponent().getMinecraftObject();
                var58 = new MatrixServiceComponent(var56.getNumericValue3(), var56.getNumericValue4(), var56.getFontServiceComponent().getNumericValue(), var56.getFontServiceComponent().getNumericValue2(), var56.getNumericValue(), var56.getNumericValue2(), z);
                if (!(Intrinsics.areEqual())) {
                    Object var52 = var57;
                    var59 = (ObjectList) batchedDraws.get();
                    if (var59 == null) {
                        var59 = (ObjectList) new ObjectArrayList();
                    }
                    Object var53 = var59;
                }
                var53.add();
            }
            var48 = (var48 + var56.getNumericValue3());
        }
        stack.popMatrix();
    }

    public float computeValue(String text, Char2ObjectArrayMap allGlyphs, ObjectArrayList maps, Font font, Font fallBack, float scaleMul) {
        String var22 = NameProtectModule.INSTANCE.resolveString(text);
        char[] var23 = this.resolveString().toCharArray();
        if (!(var23)) {
            Object var24 = new char[1];
            var24[0] = 32;
            var23 = var24;
        }
        var24 = 0.0F;
        float var25 = 0.0F;
        Object var26 = var23;
        int var27 = 0;
        Object var28 = var26;
        if (var27 < var28) {
            Object var29 = var26[var27];
            if (0L > 0 && var21 != null) {
                if (var29 == 10) {
                }
                if (var24 == 0.0F) {
                    if (0L > 0L) {
                        if (this.resolveOwnerServiceComponent(32, allGlyphs, maps, font, fallBack) != null) {
                        } else {
                            this.resolveOwnerServiceComponent(32, allGlyphs, maps, font, fallBack).getNumericValue4();
                        }
                    }
                    var24 = (1.0F / scaleMul);
                }
                var25 = (var25 + var24);
                var24 = 0.0F;
                if (var21 == null) {
                }
                OwnerServiceComponent var30 = this.resolveOwnerServiceComponent(allGlyphs, maps, font, fallBack);
                if (var30 == null) {
                } else {
                }
                var24 = Math.max((0.0F.getNumericValue4() / scaleMul));
            }
        }
        return (var24 + var25);
    }

    public void executeAction(Object2ObjectOpenHashMap batchedDraws) {
        if (var22 != null) {
            if (batchedDraws.isEmpty()) {
                return;
            }
        }
        ObjectIterator iterator = batchedDraws.object2ObjectEntrySet().iterator();
        if (iterator.hasNext()) {
            Entry var24 = (Entry) iterator.next();
            class_2960 var25 = (class_2960) (java.util.Map.Entry) var24.getKey();
            ObjectList positions = (ObjectList) (java.util.Map.Entry) var24.getValue();
            GpuTextureView var27 = SharedKt.getMc().method_1531().method_4619().method_71659();
            int var18 = 4;
            int var19 = 0;
            int var20 = positions.size();
            VertexFormat var21 = class_290.field_1575;
            FormatRenderHelper var28 = new FormatRenderHelper();
            ObjectListIterator iterator2 = positions.iterator();
            if (iterator2.hasNext()) {
                MatrixServiceComponent var30 = (MatrixServiceComponent) iterator2.next();
                Matrix3x2f var31 = var30.getMatrix3x2f();
                float var32 = var30.getNumericValue();
                float var33 = var30.getNumericValue2();
                int var34 = var30.getNumericValue();
                int var35 = var30.getNumericValue2();
                int var36 = (var30.getNumericValue5() / var30.getNumericValue3());
                int var37 = (var30.getNumericValue6() / var30.getNumericValue4());
                int var38 = ((var30.getNumericValue5() + var30.getNumericValue()) / var30.getNumericValue3());
                int var39 = ((var30.getNumericValue6() + var30.getNumericValue2()) / var30.getNumericValue4());
                var28.resolveFormatRenderHelper((var33 + var35), var30.getNumericValue7()).resolveFormatRenderHelper().resolveFormatRenderHelper(var30.getNumericValue3(), var30.getNumericValue4(), var30.getNumericValue5(), var30.getNumericValue6());
                var28.resolveFormatRenderHelper((var32 + var34), (var33 + var35), var30.getNumericValue7()).resolveFormatRenderHelper().resolveFormatRenderHelper(var30.getNumericValue3(), var30.getNumericValue4(), var30.getNumericValue5(), var30.getNumericValue6());
                var28.resolveFormatRenderHelper((var32 + var34), var30.getNumericValue7()).resolveFormatRenderHelper().resolveFormatRenderHelper(var30.getNumericValue3(), var30.getNumericValue4(), var30.getNumericValue5(), var30.getNumericValue6());
                var28.resolveFormatRenderHelper(var30.getNumericValue7()).resolveFormatRenderHelper().resolveFormatRenderHelper(var30.getNumericValue3(), var30.getNumericValue4(), var30.getNumericValue5(), var30.getNumericValue6());
                if (var22 != null) {
                }
                FormatRenderHelper.executeAction(VertexUBOShaderComponent.INSTANCE.getRenderPipeline15(), SharedKt.getMc().method_1522(), null, null, new Matrix3x2f(), MapsKt.mapOf(TuplesKt.to("Sampler0")));
            }
        }
        batchedDraws.clear();
    }

    public float computeValue(String text, Char2ObjectArrayMap allGlyphs, ObjectArrayList maps, Font font, Font fallBack, float scaleMul) {
        String var21 = NameProtectModule.INSTANCE.resolveString(text);
        char[] var22 = this.resolveString().toCharArray();
        float var23 = 0.0F;
        float var24 = 0.0F;
        int var25 = 0;
        Object var26 = var22;
        if (var25 < var26) {
            Object var27 = var22[var25];
            if (0L >= 0) {
                if (var27 == 10) {
                    var24 = Math.max();
                    var23 = 0.0F;
                }
                if (0L < 0) {
                }
                OwnerServiceComponent var28 = this.resolveOwnerServiceComponent(allGlyphs, maps, font, fallBack);
                if (0L >= 0) {
                    if (var28 == null) {
                    }
                } else {
                }
                var23 = (var23 + (0.0F.getNumericValue3() / scaleMul));
            }
        }
        return Math.max();
    }

    private int computeValue(char arg0) {
        int var4 = arg0;
        if (48 <= var4) {
        } else {
        }
        if (var4 < 58) {
        } else {
            if (97 <= var4) {
            } else {
            }
            if (var4 < 103) {
            } else {
                if (65 <= var4) {
                } else {
                }
                if (var4 < 71) {
                } else {
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
        Object var10 = arg0[(arg1 + 1)];
        if (var10 != 120) {
            if (arg3 >= 0 && arg3 >= 0) {
                if (var10 != 88) {
                    return false;
                }
            }
        }
        int var11 = 0;
        var11 = (arg1 + 2);
        int var12 = 6;
        int var13 = 0;
        if (var13 < var12) {
            int var14 = var13;
            int var15 = 0;
            if (arg4 >= 0) {
                if (arg2 >= 0) {
                    if (arg0[var11] != 167) {
                        return false;
                    }
                }
                if (arg4 > 0) {
                    if (INSTANCE.computeValue(arg0[(var11 + 1)]) < 0) {
                        return false;
                    }
                }
                var11 = (var11 + 2);
            }
        }
        return true;
    }

    private Triple resolveTriple(short arg0, char[] arg1, char arg2, int arg3) {
        if ((arg3 - 1) >= 0) {
            if (arg1[(arg3 - 1)] != 167) {
            }
            return null;
        }
        if (arg2 >= 0 && arg2 >= 0) {
        }
        if ((arg3 + 12) >= arg1) {
            return null;
        }
        int var11 = 0;
        int var12 = 0;
        var12 = (arg3 + 1);
        int var13 = 6;
        int var14 = 0;
        if (var14 < var13) {
            int var15 = var14;
            int var16 = 0;
            if (arg1[var12] != 167) {
                return null;
            }
            int var17 = INSTANCE.computeValue(arg1[(var12 + 1)]);
            if (var17 < 0) {
                return null;
            }
            var11 = ((var11 << 4) | var17);
            var12 = (var12 + 2);
        }
        var13 = ((var11 >> 16) & 255);
        var14 = ((var11 >> 8) & 255);
        if (arg0 < 0 || arg2 >= 0) {
            continue;
        }
        var15 = (var11 & 1331);
        return new Triple(Integer.valueOf(), Integer.valueOf(), Integer.valueOf());
    }

    private static String resolveString() {
        return String.valueOf(new Random().nextInt(97, 123));
    }

    private static ObjectList resolveObjectList(Object arg0) {
        return (ObjectList) new ObjectArrayList();
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
