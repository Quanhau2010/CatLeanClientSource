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
        long var6 = (0L ^ 49135606458366L);
        long var8 = (0L ^ 85446347042374L);
        long var10 = (0L ^ 31386901146457L);
        long var12 = ((0L ^ 21275552979796L) >>> 48);
        long var13 = (((0L ^ 21275552979796L) << 16) >>> 48);
        long var14 = (((0L ^ 21275552979796L) << 32) >>> 32);
        long var15 = (0L ^ 42294086766012L);
        long var17 = (0L ^ 140651307937406L);
        long var19 = (0L ^ 126255758620571L);
        long var21 = (0L ^ 83711771966610L);
        long var23 = (0L ^ 119233142815521L);
        long var25 = (0L ^ 6487619135641L);
        long var27 = (0L ^ 59344335851203L);
        long var29 = ((0L ^ 58498614843597L) >>> 48);
        long var30 = (((0L ^ 58498614843597L) << 16) >>> 32);
        long var31 = (((0L ^ 58498614843597L) << 48) >>> 48);
        int var43 = ((SharedKt.getMc().method_22683().method_4486() / 2.0F) - (this.getNumericValue() / 2.0F));
        int var44 = (((SharedKt.getMc().method_22683().method_4502() / 2.0F) - (this.getNumericValue2() / 2.0F)) - 50.0F);
        float var45 = ((var43 + this.getNumericValue()) - 25.0F);
        float var46 = ((var43 + this.getNumericValue()) - 5);
        int var47 = mouseX;
        if (var45 <= var47) {
        } else {
        }
        if (var47 <= var46) {
            var45 = (var44 + 28.0F);
            var46 = (var44 + 48.0F);
            var47 = mouseY;
            if (0L > 0L && !(var42)) {
                if (var45 <= var47) {
                }
            } else {
            }
            if (0L > 0L) {
                if (var47 <= var46) {
                }
            }
        } else {
        }
        }
        1.enabledFlag2 = 0;
        SFMServiceComponent.resolveFontRenderHelper9().render(context, "Select", (var43 + (this.getNumericValue() / 2.0F)), (var44 + 3), 10);
        StackShaderComponent2.executeAction(context.method_51448(), (var43 + 5.0F), (var44 + 28.0F), (this.getNumericValue() - 33.0F), 20.0F, 4.0F, 0.0F, 0.1F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4().brighter(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        StackShaderComponent2.executeAction(context.method_51448(), ((var43 + this.getNumericValue()) - 24.5F), (var44 + 28.0F), 20.5F, 20.0F, 4.0F, 0.0F, 0.1F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4().brighter(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        if (this.enabledFlag2) {
        } else {
        }
        context.render("+", ((var43 + this.getNumericValue()) - 15.0F), (var44 + 35.5F), NewThemeRenderHelper.INSTANCE.getColor7(), NewThemeRenderHelper.INSTANCE.getColor8());
        if (0L >= 0L) {
            if (0L > 0L) {
                if (this.enabledFlag) {
                }
                if ((SharedKt.getNumericValue() % 700) > timestampValue) {
                } else {
                }
            } else {
            }
        }
        if (this.enabledFlag) {
        } else {
        }
        Color var32 = NewThemeRenderHelper.INSTANCE.getColor8();
        Color var33 = NewThemeRenderHelper.INSTANCE.getColor7();
        float var34 = (var44 + 29);
        ("_" + "").render("Enter name", (var43 + 7.0F));
        StackShaderComponent2.executeAction(context.method_51448(), (var43 + 4.0F), (var44 + 53.0F), (this.getNumericValue() - 8.0F), (this.getNumericValue2() - 57.0F), 4.0F, 2.0F, 0.1F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4().brighter(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        this.textValue = null;
        this.enabledFlag3 = 0;
        PolygonShaderComponent.INSTANCE.render(context, new ServiceComponent78((var44 + 55.0F), (var43 + this.getNumericValue()), ((var44 + this.getNumericValue2()) - 6.0F)));
        var46 = (Iterable) this.itemList;
        var47 = 0;
        var45 = (Iterable) CollectionsKt.sortedWith((Comparator) new Comparator5()).iterator();
        var46 = 0;
        while (var45.hasNext()) {
            var47 = var46;
            var46 = (var46 + 1);
            String var48 = (String) var45.next();
            float var49 = (((var44 + 58.0F) + (var47 * 18.0F)) + this.getNumericValue3());
            if (0L > 0L) {
            }
            if (0L >= 0L) {
                if (var42 || 0L <= 0L || var49 < (var44 + 40) || 0L > 0L) {
                    continue;
                }
            }
            float var51 = var49;
            int var52 = mouseX;
            if (0L >= 0L && !(var42)) {
                if (var43 <= var52) {
                }
            } else {
            }
            if (0L > 0L) {
            }
            if (0L > 0L) {
                if (!(var42)) {
                    if (var52 <= var51 && mouseY > (var44 + 58.0F)) {
                        var51 = (var49 + 17.0F);
                        var52 = mouseY;
                    }
                }
                if (0L > 0L && !(var42)) {
                    if (var49 <= var52) {
                    }
                } else {
                }
                if (0L >= 0L) {
                    if (var52 <= var51) {
                    }
                }
            } else {
            }
        }
        int var50 = 0;
        if (0L > 0L) {
            if (!(var42)) {
            }
            if (var50) {
                this.textValue = var48;
            }
            StackShaderComponent2.executeAction(context.method_51448(), (var43 + 6.0F), (var49 - 2.0F), (this.getNumericValue() - 12.0F), 20.0F, 4.0F, 2.0F, 0.1F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        }
        if (var48.length() > 28) {
        } else {
        }
        if (Intrinsics.areEqual(ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl3().resolveIdRecord4().getString())) {
        } else {
        }
        var32 = NewThemeRenderHelper.INSTANCE.getColor8();
        var33 = NewThemeRenderHelper.INSTANCE.getColor2();
        var34 = (var49 + 1);
        (var48.substring(0, 28) + "...").render((var43 + 10.0F));
        var52 = ((var43 + this.getNumericValue()) - 20.0F);
        float var53 = ((var43 + this.getNumericValue()) - 10.0F);
        int var54 = mouseX;
        if (0L >= 0L && !(var42)) {
            if (var52 <= var54) {
            }
        } else {
        }
        if (var54 <= var53) {
            var52 = (var49 + 3.0F);
            var53 = (var49 + 13.0F);
            var54 = mouseY;
            if (0L >= 0L && !(var42)) {
                if (var52 <= var54) {
                }
            } else {
            }
            if (0L >= 0L) {
                if (var54 <= var53) {
                }
            }
        } else {
        }
        }
        var52 = PolygonShaderComponent.INSTANCE.resolveColor(Color.RED, 0.5F);
        var53 = PolygonShaderComponent.INSTANCE.resolveColor(Color.RED, 0.5F);
        var32 = var53;
        var33 = Color.RED;
        var34 = 1.0F;
        float var35 = 2.0F;
        Matrix3x2fStack var36 = context.method_51448();
        Object var37 = var52;
        Object var38 = var52;
        Object var39 = var52;
        Object var40 = var52;
        float var41 = 3.0F;
        ColorValue1RenderHelper.executeAction(10.0F, 10.0F);
        if (0L >= 0L && !(var42)) {
        }
        this.enabledFlag3 = 1;
        }
        PolygonShaderComponent.INSTANCE.render(context);
    }

    public void executeAction(int mouseX, int mouseY, int mouseButton) {
        long var6 = (0L ^ 86391959954688L);
        long var8 = (0L ^ 0L);
        long var10 = (0L ^ 138412909566640L);
        int var13 = ((SharedKt.getMc().method_22683().method_4486() / 2.0F) - (this.getNumericValue() / 2.0F));
        int var14 = (((SharedKt.getMc().method_22683().method_4502() / 2.0F) - (this.getNumericValue2() / 2.0F)) - 50.0F);
        if (0L > 0L) {
            if (var12) {
                if (this.enabledFlag3 && this.textValue != null) {
                    this.function12.invoke(this.textValue);
                    return;
                }
            }
        }
        if (this.enabledFlag2) {
            this.updateValue();
        }
        float var15 = (var14 + 28.0F);
        float var16 = (var14 + 48.0F);
        int var17 = mouseY;
        if (0L > 0L && var12) {
            if (var15 <= var17) {
            }
        } else {
        }
        if (var17 <= var16) {
            var15 = (var13 + 4.0F);
            var16 = ((var13 + this.getNumericValue()) - 33.0F);
            var17 = mouseX;
            if (0L >= 0L && var12) {
                if (var15 <= var17) {
                }
            } else {
            }
            if (var17 <= var16) {
                this.enabledFlag = !(this.enabledFlag);
            }
        }
        if (this.textValue != null) {
            var17 = this.textValue;
            int var18 = 0;
            this.function1.invoke(this.textValue);
        } else {
        }
        this.executeAction(mouseX, mouseY, mouseButton);
    }

    public void executeAction(int key) {
        long var4 = (0L ^ 20046362045052L);
        long var6 = (0L ^ 0L);
        if (0L >= 0L) {
            this.enabledFlag = 0;
        }
        this.updateValue();
        this.textValue2 = StringsKt.dropLast(this.textValue2, 1);
        if (!((CharSequence) this.textValue2.length())) {
        } else {
        }
        if (0) {
            this.enabledFlag = 0;
        }
        this.executeAction(key);
    }

    private void updateValue() {
        Iterable var13 = (Iterable) ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl3().resolveList();
        int var14 = 0;
        Object var15 = var13;
        Collection var16 = (Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(10));
        int var17 = 0;
        Iterator iterator = var15.iterator();
        while (iterator.hasNext()) {
            Object var19 = iterator.next();
            IdRecord4 var20 = (IdRecord4) var19;
            Object var22 = var16;
            int var21 = 0;
            var22.add(var20.getString());
        }
        var13 = InventoryManagerModule.INSTANCE.resolveIdRecord4(this.textValue2);
        ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl3().resolveList().add();
        ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl3().executeAction();
        this.textValue2 = "";
        this.enabledFlag = 0;
        this.updateValue(1);
        CatleanInterfaceRenderHelper.INSTANCE.updateValue(new SelectRenderHelperImpl());
    }

    public void executeAction(char char) {
        if (0L >= 0L) {
            if (var4) {
            }
        }
        this.textValue2 = (this.textValue2 + char);
        this.updateValue3(0.0F);
    }

}
