package su.catlean.client.services.render;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1041;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import org.joml.Matrix3x2f;
import org.lwjgl.glfw.GLFW;
import su.catlean.SharedKt;
import su.catlean.api.setting.SettingGroup;
import su.catlean.api.setting.VisibleSettingProperty;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.SettingServiceComponent2;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;
import su.catlean.client.tools.comparators.Comparator8;
import su.catlean.client.types.OptionMode14;
import su.catlean.client.types.TpYawSmootherMode;

public class SettingRenderHelper5 extends SettingRenderHelper16 {

    private final VisibleSettingProperty visibleSettingProperty;
    private final CatComponentRenderHelper catComponentRenderHelper;
    private final EasingServiceComponent easingServiceComponent;
    private final MissingnoRenderHelper missingnoRenderHelper;
    private List itemList;
    private float factorValue;

    public SettingRenderHelper5(VisibleSettingProperty setting, CatComponentRenderHelper module) {
        super(setting);
        this.visibleSettingProperty = setting;
        this.catComponentRenderHelper = module;
        this.easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, timestampValue);
        this.missingnoRenderHelper = new MissingnoRenderHelper("extra", 10, 10);
        this.itemList = new ArrayList();
        if ((SettingGroup) this.getVisibleSettingProperty().getObject2().getOptionMode14() == OptionMode14.BOOLS) {
            float var17 = 0.0F;
            var17 = 2.0F;
            Iterable var19 = (Iterable) this.catComponentRenderHelper.getModule().getList();
            int var20 = 0;
            Object var21 = var19;
            Collection var22 = (Collection) new ArrayList();
            int var23 = 0;
            Iterator iterator = var21.iterator();
            while (iterator.hasNext()) {
                Object var25 = iterator.next();
                VisibleSettingProperty var26 = (VisibleSettingProperty) var25;
                int var27 = 0;
                var22.add();
            }
            List positions = var22;
            var19 = (Iterable) positions;
            var20 = 0;
            var19 = (Iterable) CollectionsKt.sortedWith((Comparator) new Comparator8());
            var20 = 0;
            var21 = var19.iterator();
            while (var21.hasNext()) {
                var22 = var21.next();
                var23 = (VisibleSettingProperty) var22;
                iterator = 0;
                var25 = var23.getString2();
                var26 = (SFMServiceComponent.resolveFontRenderHelper4().computeValue() + 6.0F);
                if ((var17 + var26) > (this.getNumericValue3() - 10.0F)) {
                    this.factorValue = (this.factorValue + 12.0F);
                    var17 = 2.0F;
                }
                this.itemList.add(new SettingServiceComponent2(this.factorValue));
                var17 = (var17 + (var26 + 2.0F));
            }
        }
    }

    public VisibleSettingProperty getVisibleSettingProperty() {
        return this.visibleSettingProperty;
    }

    public CatComponentRenderHelper getCatComponentRenderHelper() {
        return this.catComponentRenderHelper;
    }

    public void render(DrawContext context, int mouseX, int mouseY, float factor) {
        long var7 = (0L ^ 9915521765924L);
        long var9 = (0L ^ 49494862758009L);
        long var11 = ((0L ^ 20797107207379L) >>> 48);
        long var12 = (((0L ^ 20797107207379L) << 16) >>> 48);
        long var13 = (((0L ^ 20797107207379L) << 32) >>> 32);
        long var14 = (0L ^ 39844814704388L);
        long var16 = (0L ^ 114903264084220L);
        long var18 = (0L ^ 115096991696004L);
        long var20 = (0L ^ 62123167127486L);
        long var22 = (0L ^ 127000398109451L);
        long var24 = (0L ^ 120682356120742L);
        long var26 = (0L ^ 24369959771588L);
        if (var28 != null) {
            if ((SettingGroup) this.getVisibleSettingProperty().getObject2().getOptionMode14() == OptionMode14.BOOLS) {
                FontRenderHelper.W(SFMServiceComponent.resolveFontRenderHelper3(), context.method_51448(), this.getVisibleSettingProperty().getString2(), this.getNumericValue(), (this.getNumericValue2() - 1.0F), NewThemeRenderHelper.INSTANCE.getColor7());
                this.updateValue4((this.factorValue + 26.0F));
                Iterable var29 = (Iterable) this.itemList;
                int var30 = 0;
                Iterator iterator = var29.iterator();
                if (iterator.hasNext()) {
                    Object var32 = iterator.next();
                    SettingServiceComponent2 var33 = (SettingServiceComponent2) var32;
                    int var34 = 0;
                    if (0L >= 0L) {
                        if (var28 != null) {
                            if ((Boolean) var33.getVisibleSettingProperty().getObject2()) {
                            } else {
                            }
                            1.0F.executeAction(0.0F);
                            Color var35 = PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor10(), NewThemeRenderHelper.INSTANCE.getColor11(), var33.getEasingServiceComponent().getNumericValue()).brighter();
                            Color var36 = PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor13(), NewThemeRenderHelper.INSTANCE.getColor12(), var33.getEasingServiceComponent().getNumericValue()).brighter();
                            StackShaderComponent2.executeAction(context.method_51448(), (this.getNumericValue() + var33.getNumericValue()), ((this.getNumericValue2() + var33.getNumericValue2()) + 13.0F), var33.getNumericValue3(), 10.0F, 2.0F, 2.5F, 0.8F, 1.0F, 0.0F, 0.0F, 0.0F);
                            SFMServiceComponent.resolveFontRenderHelper4().render(context, var33.getVisibleSettingProperty().getString2(), (((this.getNumericValue() + var33.getNumericValue()) + (var33.getNumericValue3() / 2.0F)) - 1.0F), (((this.getNumericValue2() - 1.0F) + var33.getNumericValue2()) + 18.0F), NewThemeRenderHelper.INSTANCE.getColor7());
                            float var37 = ((this.getNumericValue() + var33.getNumericValue()) + 1.0F);
                            float var38 = (((this.getNumericValue() + var33.getNumericValue()) + 1.0F) + var33.getNumericValue3());
                            int var39 = mouseX;
                            if (0L >= 0L) {
                                if (var28 != null) {
                                    if (var37 <= var39) {
                                    }
                                }
                                if (var28 != null) {
                                }
                            } else {
                            }
                            if (var39 <= var38) {
                                var37 = (((this.getNumericValue2() - 1.0F) + var33.getNumericValue2()) + 14.0F);
                                var38 = ((this.getNumericValue2() + var33.getNumericValue2()) + 23.0F);
                                var39 = mouseY;
                                if (0L > 0L) {
                                    if (var28 != null) {
                                        if (var37 <= var39) {
                                        }
                                    }
                                    if (var28 != null) {
                                    }
                                } else {
                                }
                                if (0L >= 0L) {
                                }
                                if (var39 <= var38 && GLFW.glfwGetPlatform() != 393219) {
                                    GLFW.glfwSetCursor(SharedKt.getMc().method_22683().method_4490(), GLFW.glfwCreateStandardCursor(221188));
                                    CatleanInterfaceRenderHelper.INSTANCE.updateValue(0);
                                }
                            }
                        }
                        if (0L >= 0L) {
                        }
                    }
                }
            }
        }
        if ((SettingGroup) this.getVisibleSettingProperty().getObject2().isActive()) {
        } else {
        }
        1.0F.executeAction(0.0F);
        if ((SettingGroup) this.getVisibleSettingProperty().getObject2().isActive()) {
        } else {
        }
        var29 = (1.0F + 0.0F);
        var30 = (this.easingServiceComponent.getNumericValue() * 2);
        this.updateValue4(13.0F);
        StackShaderComponent2.executeAction(context.method_51448(), (this.getNumericValue() - var30), (this.getNumericValue2() - 1.0F), ((this.getNumericValue3() - 7.0F) + (var30 * 2)), 3.0F, 2.5F, (this.easingServiceComponent.getNumericValue() / 2.0F), 1.0F, NewThemeRenderHelper.INSTANCE.getColor11(), NewThemeRenderHelper.INSTANCE.getColor12(), 0.0F, 0.0F, 0.0F);
        FontRenderHelper.W(SFMServiceComponent.resolveFontRenderHelper3(), context.method_51448(), this.getVisibleSettingProperty().getString2(), (this.getNumericValue() + 3.0F), (this.getNumericValue2() - 1.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        MissingnoRenderHelper.executeAction(this.missingnoRenderHelper, (Matrix3x2f) context.method_51448(), ((this.getNumericValue() + this.getNumericValue3()) - 18.0D), (this.getNumericValue2() - 1.0D), 0.0F, 0.0F, NewThemeRenderHelper.INSTANCE.getColor7(), null, 0.0F);
    }

    public void setValue(double mouseX, double mouseY) {
        if (0L >= 0L) {
        }
        if ((SettingGroup) this.getVisibleSettingProperty().getObject2().getOptionMode14() == OptionMode14.BOOLS) {
            Iterable var9 = (Iterable) this.itemList;
            int var10 = 0;
            Iterator iterator = var9.iterator();
            while (iterator.hasNext()) {
                Object var12 = iterator.next();
                SettingServiceComponent2 var13 = (SettingServiceComponent2) var12;
                int var14 = 0;
                float var15 = (this.getNumericValue() + var13.getNumericValue());
                if (0L > 0L && var8 != null) {
                    if (0L >= 0L && var8 != null) {
                        if (mouseX <= ((this.getNumericValue() + var13.getNumericValue()) + var13.getNumericValue3())) {
                        }
                    } else {
                    }
                    if (var15 <= mouseX) {
                        var15 = (((this.getNumericValue2() - 1.0F) + var13.getNumericValue2()) + 14.0F);
                        if (0L >= 0L && var8 != null) {
                            if (mouseY <= ((this.getNumericValue2() + var13.getNumericValue2()) + 23.0F)) {
                            }
                        } else {
                        }
                        if (var15 <= mouseY) {
                            var13.getVisibleSettingProperty().updateValue(Boolean.valueOf(!((Boolean) var13.getVisibleSettingProperty().getObject2())));
                        }
                    }
                }
                if (0L >= 0L) {
                }
            }
        } else {
            var9 = this.getNumericValue();
            if (0L >= 0L && var8 != null) {
                if (mouseX <= (this.getNumericValue() + (this.getNumericValue3() - 7))) {
                }
            } else {
            }
            var9 = this.getNumericValue2();
            if (0L >= 0L && var8 != null) {
                if (mouseY <= (this.getNumericValue2() + 13.0F)) {
                }
            } else {
            }
            (SettingGroup) this.getVisibleSettingProperty().getObject2().updateValue(!((SettingGroup) this.getVisibleSettingProperty().getObject2().isActive()));
        }
    }

    public void setValue(double mouseX, double mouseY) {
    }

    public void setValue() {
    }

    public void setValue() {
    }

    public boolean checkCondition(double mouseX, double mouseY, double verticalAmount) {
        return false;
    }

    public void setValue() {
    }

}
