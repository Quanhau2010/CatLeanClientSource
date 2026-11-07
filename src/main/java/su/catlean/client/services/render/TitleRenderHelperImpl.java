package su.catlean.client.services.render;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.text.StringsKt;
import net.minecraft.class_1041;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import su.catlean.SharedKt;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.ServiceComponent78;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;

public abstract class TitleRenderHelperImpl extends RenderHelper {

    private final String textValue;
    private Object object;
    private boolean enabledFlag;
    private boolean enabledFlag2;
    private String textValue2;
    private static int countValue;

    public TitleRenderHelperImpl(String title) {
        super();
        this.textValue = title;
        this.enabledFlag = 1;
        this.textValue2 = "";
    }

    protected String getString() {
        return this.textValue2;
    }

    protected void executeAction(String value) {
        this.textValue2 = value;
    }

    public void render(DrawContext context, int mouseX, int mouseY) {
        long var6 = (0L ^ 49135606458366L);
        long var8 = (0L ^ 31386901146457L);
        long var10 = ((0L ^ 138498907406235L) >>> 32);
        long var11 = (((0L ^ 138498907406235L) << 32) >>> 48);
        long var12 = (((0L ^ 138498907406235L) << 48) >>> 48);
        long var13 = (0L ^ 42294086766012L);
        long var15 = (0L ^ 52204105005381L);
        long var17 = (0L ^ 116260126008077L);
        int var19 = ((SharedKt.getMc().method_22683().method_4486() / 2.0F) - (this.getNumericValue() / 2.0F));
        int var20 = (((SharedKt.getMc().method_22683().method_4502() / 2.0F) - (this.getNumericValue2() / 2.0F)) - 50.0F);
        SFMServiceComponent.resolveFontRenderHelper9().render(context, this.textValue, (var19 + (this.getNumericValue() / 2.0F)), (var20 + 3), 10);
        this.render(context);
        this.render2(context);
        this.render(context, mouseX, mouseY);
    }

    private void render(DrawContext arg0, float arg1, float arg2, long arg3) {
        StackShaderComponent2.executeAction(arg0.method_51448(), (arg1 + 4.0F), (arg2 + 28.0F), (this.getNumericValue() - 8.0F), 20.0F, 4.0F, 0.0F, 0.1F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4().darker(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        if (var16) {
            if (this.enabledFlag2) {
            }
            if ((SharedKt.getNumericValue() % 700) > timestampValue) {
            } else {
            }
        } else {
        }
        if (this.enabledFlag2) {
        } else {
        }
        Color var13 = NewThemeRenderHelper.INSTANCE.getColor8();
        Color var14 = NewThemeRenderHelper.INSTANCE.getColor7();
        float var15 = (arg2 + 29.5F);
        ("_" + "").render("Search", (arg1 + 8.0F));
    }

    private void render2(DrawContext arg0, float arg1, float arg2) {
        StackShaderComponent2.executeAction();
        if (this.enabledFlag) {
            StackShaderComponent2.executeAction(arg0.method_51448(), (arg1 + 6.0F), (arg2 + 54.0F), ((this.getNumericValue() / 2.0F) - 8.0F), 13.0F, 3.0F, 2.0F, 0.1F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        }
        int var14 = 14336;
        float var15 = 0.0F;
        float var16 = 0.0F;
        float var17 = 0.0F;
        Color var18 = NewThemeRenderHelper.INSTANCE.getColor6();
        Color var19 = NewThemeRenderHelper.INSTANCE.getColor4();
        float var20 = 1.0F;
        float var21 = 0.1F;
        float var22 = 2.0F;
        float var23 = 3.0F;
        float var24 = 13.0F;
        float var25 = ((this.getNumericValue() / 2.0F) - 8.0F);
        float var26 = (arg2 + 54.0F);
        float var27 = (((arg1 + 6.0F) + (this.getNumericValue() / 2.0F)) - 4);
        StackShaderComponent2.executeAction(arg0.method_51448());
        if (this.enabledFlag) {
        } else {
        }
        arg0.render("All", (arg1 + (this.getNumericValue() / 4.0F)), (arg2 + 60.5F), NewThemeRenderHelper.INSTANCE.getColor2(), NewThemeRenderHelper.INSTANCE.getColor8());
        if (!(this.enabledFlag)) {
        } else {
        }
        arg0.render("Selected", (arg1 + ((3 * this.getNumericValue()) / 4.0F)), (arg2 + 60.5F), NewThemeRenderHelper.INSTANCE.getColor2(), NewThemeRenderHelper.INSTANCE.getColor8());
    }

    protected List resolveList() {
    }

    protected String resolveString(Object arg0) {
    }

    protected boolean checkCondition(Object arg0) {
    }

    protected void executeAction(Object arg0) {
    }

    private void render(DrawContext arg0, int arg1, float arg2, float arg3, int arg4, char arg5, short arg6, int arg7) {
        this.object = null;
        PolygonShaderComponent.INSTANCE.render(arg0, new ServiceComponent78(arg2, (arg3 + 71.0F), (arg2 + this.getNumericValue()), (arg3 + this.getNumericValue2())));
        Iterable var35 = (Iterable) this.resolveList();
        int var36 = 0;
        Object var37 = var35;
        Collection var38 = (Collection) new ArrayList();
        int var39 = 0;
        Iterator iterator = var37.iterator();
        while (iterator.hasNext()) {
            Object var41 = iterator.next();
            Object var42 = var41;
            int var43 = 0;
            if (!(this.enabledFlag)) {
                if (arg1 >= 0 && !(var33)) {
                }
            }
            if (arg1 >= 0) {
                if ((CharSequence) this.textValue2.length()) {
                }
                if (this.checkCondition() && StringsKt.contains((CharSequence) this.resolveString(), (CharSequence) this.textValue2, 1)) {
                }
            } else {
            }
            var38.add();
        }
        List positions = var38;
        var35 = (Iterable) positions.iterator();
        var36 = 0;
        while (var35.hasNext()) {
            var37 = var36;
            var36 = (var36 + 1);
            var38 = var35.next();
            var39 = (((arg3 + 78.0F) + (var37 * 20.0F)) + this.getNumericValue3());
            if (arg6 <= 0) {
            }
            if (arg1 > 0) {
                if (var39 > (arg3 + this.getNumericValue2())) {
                }
            }
            var41 = (arg2 + this.getNumericValue());
            var42 = arg4;
            if (arg6 < 0 && !(var33)) {
                if (arg2 <= var42) {
                }
            } else {
            }
            if (arg1 > 0) {
            }
            if (arg5 > 0) {
                if (!(var33)) {
                    if (var42 <= var41 && arg7 > (arg3 + 74.0F)) {
                        var41 = (var39 + 18);
                        var42 = arg7;
                    }
                }
                if (arg1 > 0 && !(var33)) {
                    if (var39 <= var42) {
                    }
                } else {
                }
                if (arg5 > 0) {
                    if (var42 <= var41) {
                    }
                }
            } else {
            }
        }
        iterator = 0;
        if (arg1 > 0) {
            if (!(var33)) {
            }
            if (iterator) {
                this.object = var38;
            }
            StackShaderComponent2.executeAction(arg0.method_51448(), (arg2 + 6.0F), (var39 - 2.0F), (this.getNumericValue() - 12.0F), 20.0F, 4.0F, 2.0F, 0.1F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        }
        if (arg5 >= 0) {
        }
        if (this.resolveString().length() > 28) {
        } else {
        }
        if (this.checkCondition()) {
        } else {
        }
        Color var30 = NewThemeRenderHelper.INSTANCE.getColor8();
        Color var31 = NewThemeRenderHelper.INSTANCE.getColor2();
        float var32 = (var39 + 1.5F);
        StringsKt.take(this.resolveString(), 28).render(("..." + ""), (arg2 + 27.0F));
        this.render(arg0, arg2);
        }
        PolygonShaderComponent.INSTANCE.render(arg0);
    }

    public void executeAction(int mouseX, int mouseY, int mouseButton) {
        long var6 = (0L ^ 86391959954688L);
        long var8 = (0L ^ 0L);
        long var10 = (0L ^ 40614691011106L);
        int var13 = ((SharedKt.getMc().method_22683().method_4486() / 2.0F) - (this.getNumericValue() / 2.0F));
        int var14 = (((SharedKt.getMc().method_22683().method_4502() / 2.0F) - (this.getNumericValue2() / 2.0F)) - 50.0F);
        float var15 = (var13 + 6.0F);
        float var16 = ((var13 + (this.getNumericValue() / 2.0F)) - 2.0F);
        int var17 = mouseX;
        if (var15 <= var17) {
        } else {
        }
        if (var17 <= var16) {
            var15 = (var14 + 54.0F);
            var16 = (var14 + 67.0F);
            var17 = mouseY;
            if (0L >= 0L && !(var12)) {
                if (var15 <= var17) {
                }
            } else {
            }
            if (0L > 0L) {
                if (var17 <= var16) {
                    this.enabledFlag = 1;
                    if (0L >= 0L) {
                        this.updateValue3(0.0F);
                    }
                } else {
                    var15 = (var13 + (this.getNumericValue() / 2.0F));
                    var16 = ((var13 + this.getNumericValue()) - 12.0F);
                    var17 = mouseX;
                }
                if (0L > 0L && !(var12)) {
                    if (var15 <= var17) {
                    }
                } else {
                }
                if (var17 <= var16) {
                    var15 = (var14 + 54.0F);
                    var16 = (var14 + 67.0F);
                    var17 = mouseY;
                    if (0L >= 0L && !(var12)) {
                        if (var15 <= var17) {
                        }
                    } else {
                    }
                    if (0L > 0L) {
                        if (var17 <= var16) {
                            this.enabledFlag = 0;
                            if (0L >= 0L) {
                                this.updateValue3(0.0F);
                            }
                        } else {
                            var15 = (var14 + 28.0F);
                            var16 = (var14 + 48.0F);
                            var17 = mouseY;
                        }
                        if (0L > 0L && !(var12)) {
                            if (var15 <= var17) {
                            }
                        } else {
                        }
                        if (var17 <= var16) {
                            var15 = (var13 + 4.0F);
                            var16 = (((var13 + 4.0F) + this.getNumericValue()) - 8.0F);
                            var17 = mouseX;
                            if (0L >= 0L && !(var12)) {
                                if (var15 <= var17) {
                                }
                            } else {
                            }
                            if (var17 <= var16) {
                                this.enabledFlag2 = !(this.enabledFlag2);
                            }
                        }
                    }
                }
            }
        }
        }
        }
        if (this.object != null) {
            var17 = this.object;
            int var18 = 0;
            this.executeAction();
        } else {
        }
        this.executeAction(mouseX, mouseY, mouseButton);
    }

    public void executeAction(int key) {
        long var4 = (0L ^ 0L);
        if (0L > 0L) {
            this.enabledFlag2 = 0;
        }
        this.textValue2 = StringsKt.dropLast(this.textValue2, 1);
        if (!((CharSequence) this.textValue2.length())) {
            this.enabledFlag2 = 0;
        }
        this.executeAction(key);
    }

    public void executeAction(char char) {
        if (0L > 0L) {
            if (var4) {
            }
        }
        this.textValue2 = (this.textValue2 + char);
        this.updateValue3(0.0F);
    }

    public void render(DrawContext context, float x, float y, Object component) {
    }

    public static void updateValue(int arg0) {
        countValue = arg0;
    }

    public static int getNumericValue() {
        return countValue;
    }

    public static int getNumericValue2() {
        return 123;
        return 0;
    }

}
