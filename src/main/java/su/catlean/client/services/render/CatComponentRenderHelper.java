package su.catlean.client.services.render;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.minecraft.client.gui.DrawContext;
import su.catlean.api.setting.SettingGroup;
import su.catlean.api.setting.VisibleSettingProperty;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.utility.misc.UIModule;
import su.catlean.client.features.modules.utility.misc.UIModuleMode;
import su.catlean.client.features.modules.utility.misc.UIModuleTextMode;
import su.catlean.client.services.client.ActionServiceComponent2;
import su.catlean.client.services.client.BlocksServiceComponent;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.EntitiesServiceComponent;
import su.catlean.client.services.client.ItemsServiceComponent2;
import su.catlean.client.services.client.NoneServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.ServiceComponent13;
import su.catlean.client.services.client.ServiceComponent78;
import su.catlean.client.services.client.SettingServiceComponent;
import su.catlean.client.services.client.StartupServiceComponent;
import su.catlean.client.services.client.SubCategoryServiceComponent;
import su.catlean.client.services.client.TextServiceComponent;
import su.catlean.client.services.client.VecServiceComponent;
import su.catlean.client.services.client.config.models.KeyRecord;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;
import su.catlean.client.types.OptionMode14;
import su.catlean.client.types.TpYawSmootherMode;

public class CatComponentRenderHelper {

    private final CategoryRenderHelper categoryRenderHelper;
    private final Module module;
    private float factorValue;
    private float factorValue2;
    private float factorValue3;
    private float factorValue4;
    private final EasingServiceComponent easingServiceComponent;
    private final EasingServiceComponent easingServiceComponent2;
    private final EasingServiceComponent easingServiceComponent3;
    private final EasingServiceComponent easingServiceComponent4;
    private final EasingServiceComponent easingServiceComponent5;
    private final EasingServiceComponent easingServiceComponent6;
    private final EasingServiceComponent easingServiceComponent7;
    private final List itemList;
    private boolean enabledFlag;
    private boolean enabledFlag2;

    public CatComponentRenderHelper(CategoryRenderHelper catComponent, Module module, float x, float y) {
        this.categoryRenderHelper = catComponent;
        this.module = module;
        this.factorValue = x;
        this.factorValue2 = y;
        this.factorValue3 = 120.0F;
        this.factorValue4 = 17.0F;
        this.easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, 200L);
        this.easingServiceComponent2 = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, 200L);
        this.easingServiceComponent3 = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, 300L);
        this.easingServiceComponent4 = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, 200L);
        this.easingServiceComponent5 = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, 200L);
        this.easingServiceComponent6 = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, 200L);
        this.easingServiceComponent7 = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, 200L);
        this.itemList = new ArrayList();
        Iterable var39 = (Iterable) this.module.getList();
        int var40 = 0;
        Iterator iterator = var39.iterator();
        while (iterator.hasNext()) {
            Object var42 = iterator.next();
            VisibleSettingProperty var43 = (VisibleSettingProperty) var42;
            int var44 = 0;
            Object var45 = var43.getObject2();
            if (var45 instanceof Boolean) {
            }
            if (var45 instanceof Float) {
            }
            if (var45 instanceof Integer) {
            }
            if (var45 instanceof KeyRecord) {
            }
            if (var45 instanceof String) {
            }
            if (var45 instanceof Color) {
            }
            if (var45 instanceof SettingGroup) {
            }
            if (var45 instanceof BlocksServiceComponent) {
            }
            if (var45 instanceof EntitiesServiceComponent) {
            }
            if (var45 instanceof ItemsServiceComponent2) {
            }
            if (var45 instanceof ActionServiceComponent2) {
            }
            if (var45 instanceof TextServiceComponent) {
            }
            SettingRenderHelper16 var46 = (SettingRenderHelper16) new SettingRenderHelper10();
            if (!(Intrinsics.areEqual(var43.getString(), "enabled")) && !(Intrinsics.areEqual(var43.getString(), "bind"))) {
                Object var47 = var46;
                int var48 = 0;
                this.itemList.add();
            }
        }
    }

    public Module getModule() {
        return this.module;
    }

    public float getNumericValue() {
        return this.factorValue;
    }

    public void updateValue(float value) {
        this.factorValue = value;
    }

    public float getNumericValue2() {
        return this.factorValue2;
    }

    public void updateValue2(float value) {
        this.factorValue2 = value;
    }

    public float getNumericValue3() {
        return this.factorValue3;
    }

    public void updateValue3(float value) {
        this.factorValue3 = value;
    }

    public float getNumericValue4() {
        return this.factorValue4;
    }

    public void updateValue4(float value) {
        this.factorValue4 = value;
    }

    public List resolveList() {
        Iterable var4 = (Iterable) this.itemList;
        int var5 = 0;
        Object var6 = var4;
        Collection var7 = (Collection) new ArrayList();
        int var8 = 0;
        Iterator iterator = var6.iterator();
        if (iterator.hasNext()) {
            Object var10 = iterator.next();
            SettingRenderHelper16 var11 = (SettingRenderHelper16) var10;
            int var12 = 0;
            if (!(var3)) {
            }
            var7.add();
        }
        return var7;
    }

    public void executeAction(List value) {
        this.itemList.addAll((Collection) value);
    }

    public boolean isActive() {
        return this.enabledFlag;
    }

    public void updateValue(boolean value) {
        this.enabledFlag = value;
    }

    public void render(DrawContext context, int mouseX, int mouseY, float factor, boolean hAnimation) {
        if (this.enabledFlag) {
        }
        31.0F.factorValue4 = 17.0F;
        if (this.module.getEnabled()) {
        }
        1.0F.executeAction(0.0F);
        float var45 = this.factorValue;
        float var46 = ((this.factorValue + this.factorValue3) - 6);
        int var47 = mouseX;
        if (0L >= 0) {
            if (!(var44)) {
                if (var45 <= var47) {
                }
            }
            if (!(var44)) {
                if (var47 <= var46) {
                }
            }
        } else {
        }
        if (0) {
            var45 = this.factorValue2;
            var46 = (this.factorValue2 + this.factorValue4);
            var47 = mouseY;
            if (0L >= 0) {
                if (!(var44)) {
                    if (var45 <= var47) {
                    }
                }
                if (!(var44)) {
                    if (var47 <= var46) {
                    }
                }
            } else {
            }
            if (0L >= 0) {
            }
            if (0 && !(this.enabledFlag)) {
            }
        }
        if (0L > 0) {
            0.5F.executeAction(0.0F);
            if (this.enabledFlag) {
            }
        }
        if (0L >= 0) {
            1.0F.executeAction(0.0F);
            if (ServiceComponent13.checkCondition(342)) {
            }
        }
        0.0F.executeAction(1.0F);
        this.factorValue4 = (17.0F + (14.0F * this.easingServiceComponent3.getNumericValue()));
        var45 = PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor10(), NewThemeRenderHelper.INSTANCE.getColor11(), this.easingServiceComponent.getNumericValue());
        var46 = PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor13(), NewThemeRenderHelper.INSTANCE.getColor12(), this.easingServiceComponent.getNumericValue());
        if (!(var44)) {
            if (UIModule.INSTANCE.getModuleMode() == UIModuleMode.DEFAULT) {
                StackShaderComponent2.executeAction(context.method_51448(), this.factorValue, this.factorValue2, (this.factorValue3 - 6), (17.0F + (14.0F * this.easingServiceComponent3.getNumericValue())), 4.0F, (2.5F + this.easingServiceComponent2.getNumericValue()), 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
                if (var44) {
                }
                if (0L > 0 && !(var44)) {
                }
                if (UIModule.INSTANCE.getModuleMode() == UIModuleMode.RECT) {
                    var47 = this.categoryRenderHelper.getArrayList2();
                    int var48 = 0;
                    ListIterator iterator = var47.listIterator(var47.size());
                    if (iterator.hasPrevious()) {
                        Object var50 = iterator.previous();
                        CatComponentRenderHelper var51 = (CatComponentRenderHelper) var50;
                        int var52 = 0;
                    } else {
                    }
                    if (0L >= 0) {
                        if (Intrinsics.areEqual((CatComponentRenderHelper) new NoSuchElementException("List contains no element matching the predicate.").module.getString(), this.module.getString())) {
                            StackShaderComponent2.executeAction(context.method_51448(), this.factorValue, this.factorValue2, (this.factorValue3 - 6), (17.0F + (14.0F * this.easingServiceComponent3.getNumericValue())), 0.0F, (2.5F + this.easingServiceComponent2.getNumericValue()), 1.0F, 1.0F, 4.0F, 4.0F, 0.0F);
                        }
                    }
                    StackShaderComponent2.executeAction(context.method_51448(), this.factorValue, this.factorValue2, (this.factorValue3 - 6), (17.0F + (14.0F * this.easingServiceComponent3.getNumericValue())), 0.0F, (2.5F + this.easingServiceComponent2.getNumericValue()), 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
                }
                if (!(var44)) {
                }
                if (var44 && this.module.getEnabled()) {
                }
                var47 = this.categoryRenderHelper.getArrayList2();
                var48 = 0;
                iterator = var47.listIterator(var47.size());
                if (iterator.hasPrevious()) {
                    var50 = iterator.previous();
                    var51 = (CatComponentRenderHelper) var50;
                    var52 = 0;
                } else {
                }
                if (0L >= 0) {
                    if (Intrinsics.areEqual((CatComponentRenderHelper) new NoSuchElementException("List contains no element matching the predicate.").module.getString(), this.module.getString())) {
                        StackShaderComponent2.executeAction(context.method_51448(), (this.factorValue - 3.0F), this.factorValue2, this.factorValue3, (20.0F + (14.0F * this.easingServiceComponent3.getNumericValue())), 0.0F, 0.0F, 1.0F, 1.0F, 7.0F, 7.0F, 0.0F);
                    }
                    if (var44) {
                    }
                    StackShaderComponent2.executeAction(context.method_51448(), (this.factorValue - 3.0F), this.factorValue2, this.factorValue3, (19.0F + (14.0F * this.easingServiceComponent3.getNumericValue())), 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
                }
            }
        }
        var47 = PolygonShaderComponent.INSTANCE.resolveColor(Color.BLACK, NewThemeRenderHelper.INSTANCE.getColor7(), factor);
        if (!(var44)) {
            if (this.easingServiceComponent2.getNumericValue() == 0.0F) {
            }
        } else {
        }
        if (0L > 0) {
        }
        if (0L >= 0) {
            if (!(var44)) {
            }
        }
        if (!(var44)) {
            if (!(0) && ServiceComponent13.checkCondition(341) && ServiceComponent13.checkCondition(340)) {
            }
        } else {
        }
        var48 = 0;
        if (0L > 0 && !(var44)) {
            if ((System.currentTimeMillis() - this.timestampValue) >= 400L) {
                if (var48) {
                }
            }
            if (var48) {
            }
        } else {
        }
        iterator = Float.valueOf(0.0F);
        if (0L >= 0 && !(var44)) {
            if (UIModule.INSTANCE.getModuleText() == UIModuleTextMode.LEFT) {
            }
            if (!(var44)) {
            }
            if (this.module.getBind().getNumericValue() != -1) {
            }
        } else {
        }
        FontRenderHelper.W(this.module.getString2(), ((this.factorValue + 4.0F) + (Number) iterator), (((this.factorValue3 - 8.0F) / 2.0F) - (SFMServiceComponent.resolveFontRenderHelper2().computeValue(this.module.getString2()) / 2.0F)), (0.0F + (this.easingServiceComponent7.getNumericValue() * 1.0F)), ((this.factorValue2 + (this.factorValue4 / 2.0F)) - 7.0F), PolygonShaderComponent.INSTANCE.resolveColor((1.0F - this.easingServiceComponent3.getNumericValue())));
        if (this.easingServiceComponent7.getNumericValue() < 1.0F) {
            if (!(var44) && !(var44)) {
                if (!(this.enabledFlag)) {
                    var50 = NoneServiceComponent.INSTANCE.resolveString(this.module.getBind().getNumericValue());
                    if (0L >= 0) {
                        if (!(var44)) {
                        }
                        if (this.module.getBind().getNumericValue() != -1) {
                            FontRenderHelper.W(SFMServiceComponent.resolveFontRenderHelper2(), context.method_51448(), (((this.factorValue + this.factorValue3) - 10.0F) - SFMServiceComponent.resolveFontRenderHelper2().computeValue()), ((this.factorValue2 + (this.factorValue4 / 2.0F)) - 7.0F), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor8(), (1.0F - this.easingServiceComponent7.getNumericValue())));
                        }
                    }
                }
                if (!(var44)) {
                }
            }
            if (this.easingServiceComponent3.getNumericValue() > 0.0F) {
            }
            this.render(context, mouseX, mouseY);
        }
        if (var44) {
        }
    }

    private void render(DrawContext arg0, int arg1, int arg2, Color arg3, Color arg4) {
        float var31 = (this.factorValue + 58.0F);
        float var32 = (((this.factorValue + 58.0F) + (this.factorValue3 / 2.0F)) - 6);
        int var33 = arg1;
        if (var30) {
            if (var31 <= var33) {
            }
            if (var30) {
                if (var33 <= var32) {
                }
            }
        } else {
        }
        if (0) {
            var31 = (this.factorValue2 + 15.0F);
            var32 = (this.factorValue2 + 27.0F);
            var33 = arg2;
            if (var30) {
                if (var31 <= var33) {
                }
                if (var30) {
                    if (var33 <= var32) {
                    }
                }
            } else {
            }
            if (0) {
            }
        }
        1.0F.executeAction(0.0F);
        var31 = (this.factorValue + 2.0F);
        var32 = (((this.factorValue + 2.0F) + (this.factorValue3 / 2.0F)) - 6);
        var33 = arg1;
        if (var30) {
            if (var31 <= var33) {
            }
            if (var30) {
                if (var33 <= var32) {
                }
            }
        } else {
        }
        if (0) {
            var31 = (this.factorValue2 + 15.0F);
            var32 = (this.factorValue2 + 27.0F);
            var33 = arg2;
            if (var30) {
                if (var31 <= var33) {
                }
                if (var30) {
                    if (var33 <= var32) {
                    }
                }
            } else {
            }
            if (0) {
            }
        }
        1.0F.executeAction(0.0F);
        if (this.enabledFlag2) {
        }
        1.0F.executeAction(0.0F);
        PolygonShaderComponent.INSTANCE.render(arg0, new ServiceComponent78(this.factorValue, this.factorValue2, (this.factorValue + this.factorValue3), (this.factorValue2 + this.factorValue4)));
        FontRenderHelper.W(SFMServiceComponent.resolveFontRenderHelper2(), arg0.method_51448(), StringsKt.dropLast("Press any key                    ...", (3 - (4 * ((System.currentTimeMillis() % 700) / 700.0D)))), ((this.factorValue + 3.0F) + (60 * (1.0F - this.easingServiceComponent3.getNumericValue()))), (this.factorValue2 + 2.0F), PolygonShaderComponent.INSTANCE.resolveColor(arg3, (this.easingServiceComponent3.getNumericValue() - 0.1F)));
        StackShaderComponent2.executeAction(arg0.method_51448(), (this.factorValue + 2.0F), (this.factorValue2 + 17.0F), ((this.factorValue3 / 2.0F) - 6), 12.0F, 3.0F, (2.5F + (this.easingServiceComponent4.getNumericValue() / 2.0F)), (1.0F - this.easingServiceComponent6.getNumericValue()), 1.0F, PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor10(), NewThemeRenderHelper.INSTANCE.getColor11(), (1.0F - this.easingServiceComponent6.getNumericValue())), arg4, 0.0F, 0.0F, 0.0F);
        SFMServiceComponent.resolveFontRenderHelper10().render(arg0, "Toggle", (this.factorValue + 15.0F), (this.factorValue2 + 17.0F), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor8(), NewThemeRenderHelper.INSTANCE.getColor7(), (this.easingServiceComponent4.getNumericValue() + ((1.0F - this.easingServiceComponent6.getNumericValue()) / 2.0F))));
        StackShaderComponent2.executeAction(arg0.method_51448(), (this.factorValue + 58.0F), (this.factorValue2 + 17.0F), ((this.factorValue3 / 2.0F) - 6), 12.0F, 3.0F, (2.5F + (this.easingServiceComponent5.getNumericValue() / 2.0F)), this.easingServiceComponent6.getNumericValue(), 1.0F, PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor10(), NewThemeRenderHelper.INSTANCE.getColor11(), this.easingServiceComponent6.getNumericValue()), arg4, 0.0F, 0.0F, 0.0F);
        SFMServiceComponent.resolveFontRenderHelper10().render(arg0, "Hold", (this.factorValue + 76.0F), (this.factorValue2 + 17.0F), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor8(), NewThemeRenderHelper.INSTANCE.getColor7(), (this.easingServiceComponent5.getNumericValue() + (this.easingServiceComponent6.getNumericValue() / 2.0F))));
        PolygonShaderComponent.INSTANCE.render(arg0);
    }

    public void executeAction(double mouseX, double mouseY, int button) {
        if (!(var26)) {
            if (this.enabledFlag) {
                float var27 = (this.factorValue + 58.0F);
                float var28 = (((this.factorValue + 58.0F) + (this.factorValue3 / 2.0F)) - 6);
                double var29 = mouseX;
                if (0L >= 0) {
                    if (!(var26)) {
                        if (var27 <= var29) {
                        }
                    }
                    if (!(var26)) {
                        if (var29 <= var28) {
                        }
                    }
                } else {
                }
                if (0) {
                    var27 = (this.factorValue2 + 15.0F);
                    var28 = (this.factorValue2 + 27.0F);
                    var29 = mouseY;
                    if (0L >= 0) {
                        if (!(var26)) {
                            if (var27 <= var29) {
                            }
                        }
                        if (!(var26)) {
                            if (var29 <= var28) {
                            }
                        }
                    } else {
                    }
                    if (0L > 0) {
                    }
                    if (0L >= 0) {
                        if (!(var26)) {
                            if (0 && !(button)) {
                                this.enabledFlag2 = 1;
                                if (var26) {
                                }
                            }
                            var27 = (this.factorValue + 2.0F);
                            var28 = (((this.factorValue + 2.0F) + (this.factorValue3 / 2.0F)) - 6);
                            var29 = mouseX;
                        }
                    }
                    if (0L > 0) {
                        if (!(var26)) {
                            if (var27 <= var29) {
                            }
                        }
                        if (!(var26)) {
                            if (var29 <= var28) {
                            }
                        }
                    } else {
                    }
                    if (0) {
                        var27 = (this.factorValue2 + 15.0F);
                        var28 = (this.factorValue2 + 27.0F);
                        var29 = mouseY;
                        if (0L >= 0) {
                            if (!(var26)) {
                                if (var27 <= var29) {
                                }
                            }
                            if (!(var26)) {
                                if (var29 <= var28) {
                                }
                            }
                        } else {
                        }
                        if (0L >= 0) {
                        }
                        if (0 && !(button)) {
                            this.enabledFlag2 = 0;
                            if (var26) {
                            }
                        }
                        this.module.setBind(new KeyRecord(button, this.enabledFlag2, 1));
                        this.enabledFlag = 0;
                    }
                }
            }
        }
        var27 = this.factorValue;
        if (0L > 0) {
            if (!(var26)) {
                if (mouseX <= ((this.factorValue + this.factorValue3) - 6)) {
                }
            }
            if (!(var26)) {
                if (var27 <= mouseX) {
                }
            }
        } else {
        }
        var27 = this.factorValue2;
        if (0L >= 0) {
            if (!(var26)) {
                if (mouseY <= (this.factorValue2 + this.factorValue4)) {
                }
            }
            if (!(var26)) {
                if (var27 <= mouseY) {
                }
            }
        } else {
        }
        if (0L >= 0) {
        }
        if (0L >= 0) {
            if (!(var26)) {
            }
        }
        if (ServiceComponent13.checkCondition(341)) {
            if (0L >= 0) {
                if (!(var26) && !(var26)) {
                    if (0L > 0) {
                        if (ServiceComponent13.checkCondition(340)) {
                            if (!(var26)) {
                                if (this.module.getEnabled()) {
                                    this.module.updateValue2();
                                }
                            }
                            var27 = this.module.getList().iterator();
                            while (var27.hasNext()) {
                                var28 = (VisibleSettingProperty) var27.next();
                                var28.setValue();
                            }
                        }
                    }
                }
            }
            if (0L >= 0 && !(var26)) {
                if (ServiceComponent13.checkCondition(342)) {
                    this.enabledFlag = 1;
                }
            }
            if (0L > 0) {
                this.module.updateValue();
            }
            if (!(var26)) {
                if (!((Collection) this.itemList.isEmpty())) {
                }
            } else {
            }
            if (0L >= 0) {
                if (0) {
                    StartupServiceComponent.INSTANCE.getVecServiceComponent().updateValue();
                    this.categoryRenderHelper.updateValue(this);
                }
                this.updateValue();
            }
            this.enabledFlag = 1;
        }
    }

    public void updateValue() {
        StartupServiceComponent.INSTANCE.getVecServiceComponent3().updateValue();
        this.timestampValue = System.currentTimeMillis();
    }

    public void executeAction(int key) {
        if (var12) {
            if (Intrinsics.areEqual(this.categoryRenderHelper.getCatComponentRenderHelper(), this)) {
                Iterable var13 = (Iterable) this.itemList;
                int var14 = 0;
                Iterator iterator = var13.iterator();
                if (iterator.hasNext()) {
                    Object var16 = iterator.next();
                    SettingRenderHelper16 var17 = (SettingRenderHelper16) var16;
                    int var18 = 0;
                    var17.setValue(key);
                    if (0L >= 0) {
                        if (var12) {
                        }
                    }
                }
            }
        }
        if (0L >= 0 && var12) {
        }
        if (0L >= 0) {
            if (0L > 0) {
                this.module.setBind(new KeyRecord(-1, this.enabledFlag2, 0));
            }
            if (!(var12)) {
                this.module.setBind(new KeyRecord(key, this.enabledFlag2, 0));
            }
        }
        this.enabledFlag = 0;
    }

    public void executeAction(char char) {
        if (!(var6)) {
        }
        Iterable var7 = (Iterable) this.itemList;
        int var8 = 0;
        Iterator iterator = var7.iterator();
        if (iterator.hasNext()) {
            Object var10 = iterator.next();
            SettingRenderHelper16 var11 = (SettingRenderHelper16) var10;
            int var12 = 0;
            var11.setValue(char);
        }
    }

    public boolean checkCondition(double mouseX, double mouseY, double verticalAmount) {
        int var13 = 0;
        if (var12) {
            if (Intrinsics.areEqual(this.categoryRenderHelper.getCatComponentRenderHelper(), this)) {
                Iterable var14 = (Iterable) this.itemList;
                int var15 = 0;
                Iterator iterator = var14.iterator();
                if (iterator.hasNext()) {
                    Object var17 = iterator.next();
                    SettingRenderHelper16 var18 = (SettingRenderHelper16) var17;
                    int var19 = 0;
                    if (var12) {
                        if (var18.getVisibleSettingProperty().getSettingGroup() != null) {
                            if (var12) {
                                if (var18.getVisibleSettingProperty().getSettingGroup().isActive()) {
                                }
                                if (var12 && var12) {
                                }
                            }
                            if (var12) {
                            }
                            if (var12) {
                                if (var18.getVisibleSettingProperty().getSettingGroup().getOptionMode14() != OptionMode14.BOOLS && (Boolean) var18.getVisibleSettingProperty().getFunction0().invoke() && var18.checkCondition(mouseX, mouseY, verticalAmount)) {
                                }
                                var13 = 1;
                            }
                        }
                    }
                }
            }
        }
        return var13;
    }

    public float computeValue(SettingGroup group) {
        if (var4) {
        }
        if (!(group.isActive()) && group.getOptionMode14() != OptionMode14.BOOLS) {
            return 13.0F;
        }
        float var5 = 0.0F;
        var5 = 13.0F;
        Iterable var7 = (Iterable) this.itemList;
        int var8 = 0;
        Object var9 = var7;
        Collection var10 = (Collection) new ArrayList();
        int var11 = 0;
        Iterator iterator = var9.iterator();
        if (iterator.hasNext()) {
            Object var13 = iterator.next();
            SettingRenderHelper16 var14 = (SettingRenderHelper16) var13;
            int var15 = 0;
            if (var4) {
            }
            if (var4) {
                if (Intrinsics.areEqual(var14.getVisibleSettingProperty().getSettingGroup(), group) && (Boolean) var14.getVisibleSettingProperty().getFunction0().invoke()) {
                }
            } else {
            }
            var10.add();
        }
        List positions = var10;
        var7 = (Iterable) positions;
        var8 = 0;
        var9 = var7.iterator();
        if (var9.hasNext()) {
            var10 = var9.next();
            var11 = (SettingRenderHelper16) var10;
            iterator = 0;
            var5 = (var5 + (var11.getNumericValue4() + 2.0F));
            if (var4) {
            }
        }
        return var5;
    }

}
