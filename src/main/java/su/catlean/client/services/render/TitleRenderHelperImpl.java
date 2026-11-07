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
        this.enabledFlag = true;
        this.textValue2 = "";
    }

    protected String getString() {
        return this.textValue2;
    }

    protected void executeAction(String value) {
        this.textValue2 = value;
    }

    public void render(DrawContext context, int mouseX, int mouseY) {
        int index = ((SharedKt.getMc().method_22683().method_4486() / 2.0F) - (this.getNumericValue() / 2.0F));
        int index2 = (((SharedKt.getMc().method_22683().method_4502() / 2.0F) - (this.getNumericValue2() / 2.0F)) - 50.0F);
        SFMServiceComponent.resolveFontRenderHelper9().render(context, this.textValue, (index + (this.getNumericValue() / 2.0F)), (index2 + 3), 10);
        this.render(context, index, index2);
        this.render2(context, index, index2);
        this.render(context, index, index2, mouseX, mouseY);
    }

    private void render(DrawContext arg0, float arg1, float arg2, long arg3) {
        StackShaderComponent2.executeAction(arg0.method_51448(), (arg1 + 4.0F), (arg2 + 28.0F), (this.getNumericValue() - 8.0F), 20.0F, 4.0F, 0.0F, 0.1F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4().darker(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        if (__UNDEF_KEY__) {
            if (this.enabledFlag2) {
                if ((SharedKt.getNumericValue() % 700) > timestampValue) {
                } else {
                }
            } else {
            }
        }
        if (this.enabledFlag2) {
        } else {
        }
        Color color = NewThemeRenderHelper.INSTANCE.getColor8();
        Color color2 = NewThemeRenderHelper.INSTANCE.getColor7();
        float factor = (arg2 + 29.5F);
        ("_" + "").render("Search", (arg1 + 8.0F), factor, color2, color);
    }

    private void render2(DrawContext arg0, float arg1, float arg2) {
        StackShaderComponent2.executeAction();
        if (this.enabledFlag) {
            StackShaderComponent2.executeAction(arg0.method_51448(), (arg1 + 6.0F), (arg2 + 54.0F), ((this.getNumericValue() / 2.0F) - 8.0F), 13.0F, 3.0F, 2.0F, 0.1F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        }
        int index = 14336;
        float factor = 0.0F;
        float factor2 = 0.0F;
        float factor3 = 0.0F;
        Color color = NewThemeRenderHelper.INSTANCE.getColor6();
        Color color2 = NewThemeRenderHelper.INSTANCE.getColor4();
        float factor4 = 1.0F;
        float factor5 = 0.1F;
        float factor6 = 2.0F;
        float factor7 = 3.0F;
        float factor8 = 13.0F;
        float factor9 = ((this.getNumericValue() / 2.0F) - 8.0F);
        float factor10 = (arg2 + 54.0F);
        float factor11 = (((arg1 + 6.0F) + (this.getNumericValue() / 2.0F)) - 4);
        StackShaderComponent2.executeAction(arg0.method_51448(), factor11, factor10, factor9, factor8, factor7, factor6, factor5, factor4, color2, color, factor3, factor2, factor, index);
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
        Iterable iterable = ((Iterable) this.resolveList());
        int index = 0;
        Iterable iterable2 = iterable;
        Collection collection = ((Collection) new ArrayList());
        int index2 = 0;
        while (iterator.hasNext()) {
            Object element = this.next();
            Object element2 = element;
            if (!(this.enabledFlag)) {
                if (arg1 >= 0 && !(__UNDEF_KEY__)) {
                }
            }
            if (arg1 >= 0) {
                if (((CharSequence) this.textValue2).length()) {
                    if (this.checkCondition(element2) && StringsKt.contains(((CharSequence) this.resolveString(element2)), ((CharSequence) this.textValue2), true)) {
                    } else {
                    }
                }
            }
            collection.add(element);
        }
        iterable = ((Iterable) collection).iterator();
        index = 0;
        while (iterable.hasNext()) {
            iterable2 = index;
            index = (index + 1);
            collection = iterable.next();
            index2 = (((arg3 + 78.0F) + (iterable2 * 20.0F)) + this.getNumericValue3());
            if (arg6 <= 0) {
            }
            if (arg1 > 0) {
                if (index2 > (arg3 + this.getNumericValue2())) {
                }
            }
            element = (arg2 + this.getNumericValue());
            element2 = arg4;
            if (arg6 < 0 && !(__UNDEF_KEY__)) {
                if (arg2 <= element2) {
                } else {
                }
            }
            if (arg1 > 0) {
            }
            if (arg5 > 0) {
                if (!(__UNDEF_KEY__)) {
                    if (element2 <= element && arg7 > (arg3 + 74.0F)) {
                        element = (index2 + 18);
                        element2 = arg7;
                        if (arg1 > 0 && !(__UNDEF_KEY__)) {
                            if (index2 <= element2) {
                            } else {
                            }
                        }
                        if (arg5 > 0) {
                            if (element2 <= element) {
                            } else {
                            }
                        }
                    } else {
                    }
                }
            }
            if (arg1 > 0) {
                if (!(__UNDEF_KEY__)) {
                    this.object = collection;
                }
            }
            StackShaderComponent2.executeAction(arg0.method_51448(), (arg2 + 6.0F), (index2 - 2.0F), (this.getNumericValue() - 12.0F), 20.0F, 4.0F, 2.0F, 0.1F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
            if (arg5 >= 0) {
            }
            if (this.resolveString(collection).length() > 28) {
            } else {
            }
            if (this.checkCondition(collection)) {
            } else {
            }
            Color color = NewThemeRenderHelper.INSTANCE.getColor8();
            Color color2 = NewThemeRenderHelper.INSTANCE.getColor2();
            int index3 = (index2 + 1.5F);
            StringsKt.take(this.resolveString(collection), 28).render(("..." + ""), (arg2 + 27.0F), index3, color2, color);
            this.render(arg0, arg2, index2, collection);
        }
        PolygonShaderComponent.INSTANCE.render(arg0);
    }

    public void executeAction(int mouseX, int mouseY, int mouseButton) {
        int index = ((SharedKt.getMc().method_22683().method_4486() / 2.0F) - (this.getNumericValue() / 2.0F));
        int index2 = (((SharedKt.getMc().method_22683().method_4502() / 2.0F) - (this.getNumericValue2() / 2.0F)) - 50.0F);
        int index3 = (index + 6.0F);
        int index4 = ((index + (this.getNumericValue() / 2.0F)) - 2.0F);
        int index5 = mouseX;
        if (index3 <= index5) {
        } else {
            if (index5 <= index4) {
                index3 = (index2 + 54.0F);
                index4 = (index2 + 67.0F);
                index5 = mouseY;
                if (index3 <= index5) {
                } else {
                    if (index5 <= index4) {
                        this.enabledFlag = true;
                        this.updateValue3(0.0F);
                    } else {
                        index3 = (index + (this.getNumericValue() / 2.0F));
                        index4 = ((index + this.getNumericValue()) - 12.0F);
                        index5 = mouseX;
                        if (index3 <= index5) {
                        } else {
                            if (index5 <= index4) {
                                index3 = (index2 + 54.0F);
                                index4 = (index2 + 67.0F);
                                index5 = mouseY;
                                if (index3 <= index5) {
                                } else {
                                    if (index5 <= index4) {
                                        this.enabledFlag = false;
                                        this.updateValue3(0.0F);
                                    } else {
                                        index3 = (index2 + 28.0F);
                                        index4 = (index2 + 48.0F);
                                        index5 = mouseY;
                                        if (index3 <= index5) {
                                        } else {
                                            if (index5 <= index4) {
                                                index3 = (index + 4.0F);
                                                index4 = (((index + 4.0F) + this.getNumericValue()) - 8.0F);
                                                index5 = mouseX;
                                                if (index3 <= index5) {
                                                } else {
                                                    if (index5 <= index4) {
                                                        this.enabledFlag2 = !(this.enabledFlag2);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                            }
                        }
                    }
                }
            } else {
            }
        }
        if (this.object != null) {
            index5 = this.object;
            this.executeAction(index5);
        } else {
        }
        this.executeAction(mouseX, mouseY, mouseButton);
    }

    public void executeAction(int key) {
        this.enabledFlag2 = false;
        this.textValue2 = StringsKt.dropLast(this.textValue2, 1);
        if (!(((CharSequence) this.textValue2).length())) {
        } else {
        }
        if (0) {
            this.enabledFlag2 = false;
        }
        this.executeAction(key);
    }

    public void executeAction(char charParam) {
        if (__UNDEF_KEY__ > 0L) {
            if (__UNDEF_KEY__) {
            }
        }
        this.textValue2 = (this.textValue2 + charParam);
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
