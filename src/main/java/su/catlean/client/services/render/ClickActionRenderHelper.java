package su.catlean.client.services.render;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.minecraft.class_1041;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import org.joml.Matrix3x2fStack;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.utility.equip.InventoryManagerModule;
import su.catlean.client.services.client.JsonJsonServiceComponent5Impl3;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.ServiceComponent78;
import su.catlean.client.services.client.config.models.IdRecord4;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;
import su.catlean.client.tools.comparators.Comparator5;
import su.catlean.client.ui.clickgui.ProxyGuiElement;

public class ClickActionRenderHelper extends RenderHelper {

    private final List itemList;
    private final Function1 function1;
    private final Function1 function12;
    private String textValue;
    private boolean enabledFlag;
    private String textValue2;
    private boolean enabledFlag2;
    private boolean enabledFlag3;

    public ClickActionRenderHelper(List list, Function1 clickAction, Function1 clickRemoveAction) {
        super();
        this.itemList = list;
        this.function1 = clickAction;
        this.function12 = clickRemoveAction;
        this.textValue2 = "";
    }

    public List getList() {
        return this.itemList;
    }

    public Function1 getFunction1() {
        return this.function1;
    }

    public Function1 getFunction12() {
        return this.function12;
    }

    public void render(DrawContext context, int mouseX, int mouseY) {
        int index = ((SharedKt.getMc().method_22683().method_4486() / 2.0F) - (this.getNumericValue() / 2.0F));
        int index2 = (((SharedKt.getMc().method_22683().method_4502() / 2.0F) - (this.getNumericValue2() / 2.0F)) - 50.0F);
        int index3 = ((index + this.getNumericValue()) - 25.0F);
        int index4 = ((index + this.getNumericValue()) - 5);
        int index5 = mouseX;
        if (index3 <= index5) {
        } else {
            if (index5 <= index4) {
                index3 = (index2 + 28.0F);
                index4 = (index2 + 48.0F);
                index5 = mouseY;
                if (index3 <= index5) {
                } else {
                }
            } else {
                this.enabledFlag2 = index5 <= index4;
            }
        }
        SFMServiceComponent.resolveFontRenderHelper9().render(context, "Select", (index + (this.getNumericValue() / 2.0F)), (index2 + 3), 10);
        StackShaderComponent2.executeAction(context.method_51448(), (index + 5.0F), (index2 + 28.0F), (this.getNumericValue() - 33.0F), 20.0F, 4.0F, 0.0F, 0.1F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4().brighter(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        StackShaderComponent2.executeAction(context.method_51448(), ((index + this.getNumericValue()) - 24.5F), (index2 + 28.0F), 20.5F, 20.0F, 4.0F, 0.0F, 0.1F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4().brighter(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        if (this.enabledFlag2) {
        } else {
        }
        context.render("+", ((index + this.getNumericValue()) - 15.0F), (index2 + 35.5F), NewThemeRenderHelper.INSTANCE.getColor7(), NewThemeRenderHelper.INSTANCE.getColor8());
        if (this.enabledFlag) {
            if ((SharedKt.getNumericValue() % 700) > timestampValue) {
            } else {
            }
        } else {
        }
        if (this.enabledFlag) {
        } else {
        }
        Color color = NewThemeRenderHelper.INSTANCE.getColor8();
        Color color2 = NewThemeRenderHelper.INSTANCE.getColor7();
        int index6 = (index2 + 29);
        ("_" + "").render("Enter name", (index + 7.0F), index6, color2, color);
        StackShaderComponent2.executeAction(context.method_51448(), (index + 4.0F), (index2 + 53.0F), (this.getNumericValue() - 8.0F), (this.getNumericValue2() - 57.0F), 4.0F, 2.0F, 0.1F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4().brighter(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        this.textValue = null;
        this.enabledFlag3 = false;
        PolygonShaderComponent.INSTANCE.render(context, new ServiceComponent78(index, (index2 + 55.0F), (index + this.getNumericValue()), ((index2 + this.getNumericValue2()) - 6.0F)));
        index4 = ((Iterable) this.itemList);
        index5 = 0;
        index3 = ((Iterable) CollectionsKt.sortedWith(index4, ((Comparator) new Comparator5()))).iterator();
        index4 = 0;
        while (index3.hasNext()) {
            index5 = index4;
            index4 = (index4 + 1);
            String text = ((String) index3.next());
            int index7 = (((index2 + 58.0F) + (index5 * 18.0F)) + this.getNumericValue3());
            if (index7 < (index2 + 40) || index7 > (index2 + this.getNumericValue2())) {
                continue;
            }
            int index8 = (index + this.getNumericValue());
            int index9 = mouseX;
            if (index <= index9) {
            } else {
            }
            if (index9 <= index8 && mouseY > (index2 + 58.0F)) {
                index8 = (index7 + 17.0F);
                index9 = mouseY;
                if (index7 <= index9) {
                } else {
                }
            } else {
            }
            this.textValue = text;
            StackShaderComponent2.executeAction(context.method_51448(), (index + 6.0F), (index7 - 2.0F), (this.getNumericValue() - 12.0F), 20.0F, 4.0F, 2.0F, 0.1F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
            if (text.length() > 28) {
            } else {
            }
            if (Intrinsics.areEqual(text, ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl3().resolveIdRecord4().getString())) {
            } else {
            }
            color = NewThemeRenderHelper.INSTANCE.getColor8();
            color2 = NewThemeRenderHelper.INSTANCE.getColor2();
            index6 = (index7 + 1);
            (text.substring(0, 28) + "...").render(text, (index + 10.0F), index6, color2, color);
            index9 = ((index + this.getNumericValue()) - 20.0F);
            int index10 = ((index + this.getNumericValue()) - 10.0F);
            int index11 = mouseX;
            if (index9 <= index11) {
            } else {
                if (index11 <= index10) {
                    index9 = (index7 + 3.0F);
                    index10 = (index7 + 13.0F);
                    index11 = mouseY;
                    if (index9 <= index11) {
                    } else {
                    }
                } else {
                }
            }
            index9 = PolygonShaderComponent.INSTANCE.resolveColor(Color.RED, 0.5F);
            index10 = PolygonShaderComponent.INSTANCE.resolveColor(Color.RED, 0.5F);
            color = index10;
            color2 = Color.RED;
            index6 = 1.0F;
            float factor = 2.0F;
            Matrix3x2fStack matrix3x2fStack = context.method_51448();
            float factor2 = 3.0F;
            ColorValue1RenderHelper.executeAction(10.0F, 10.0F, factor2, index9, index9, index9, index9, matrix3x2fStack, factor, index6, color2, color);
            this.enabledFlag3 = true;
        }
        PolygonShaderComponent.INSTANCE.render(context);
    }

    public void executeAction(int mouseX, int mouseY, int mouseButton) {
        int index = ((SharedKt.getMc().method_22683().method_4486() / 2.0F) - (this.getNumericValue() / 2.0F));
        int index2 = (((SharedKt.getMc().method_22683().method_4502() / 2.0F) - (this.getNumericValue2() / 2.0F)) - 50.0F);
        if (this.enabledFlag3 && this.textValue != null) {
            this.function12.invoke(this.textValue);
            return;
        }
        if (this.enabledFlag2) {
            this.updateValue();
        }
        int index3 = (index2 + 28.0F);
        int index4 = (index2 + 48.0F);
        int index5 = mouseY;
        if (index3 <= index5) {
        } else {
            if (index5 <= index4) {
                index3 = (index + 4.0F);
                index4 = ((index + this.getNumericValue()) - 33.0F);
                index5 = mouseX;
                if (index3 <= index5) {
                } else {
                    if (index5 <= index4) {
                        this.enabledFlag = !(this.enabledFlag);
                    }
                }
            }
        }
        if (this.textValue != null) {
            index5 = this.textValue;
            this.function1.invoke(this.textValue);
        } else {
        }
        this.executeAction(mouseX, mouseY, mouseButton);
    }

    public void executeAction(int key) {
        this.enabledFlag = false;
        this.updateValue();
        this.textValue2 = StringsKt.dropLast(this.textValue2, 1);
        if (!(((CharSequence) this.textValue2).length())) {
        } else {
        }
        if (0) {
            this.enabledFlag = false;
        }
        this.executeAction(key);
    }

    private void updateValue() {
        Iterable iterable = ((Iterable) ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl3().resolveList());
        Collection collection = ((Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10)));
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            IdRecord4 idRecord4 = ((IdRecord4) element);
            collection.add(idRecord4.getString());
        }
        iterable = InventoryManagerModule.INSTANCE.resolveIdRecord4(this.textValue2);
        ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl3().resolveList().add(iterable);
        ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl3().executeAction(iterable);
        this.textValue2 = "";
        this.enabledFlag = false;
        this.updateValue(true);
        CatleanInterfaceRenderHelper.INSTANCE.updateValue(new SelectRenderHelperImpl());
    }

    public void executeAction(char charParam) {
        if (__UNDEF_KEY__ >= 0L) {
            if (__UNDEF_KEY__) {
            }
        }
        this.textValue2 = (this.textValue2 + charParam);
        this.updateValue3(0.0F);
    }

}
