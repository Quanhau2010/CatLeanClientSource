package su.catlean.client.ui.clickgui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KMutableProperty0;
import kotlin.text.StringsKt;
import net.minecraft.class_2960;
import net.minecraft.class_5321;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import su.catlean.SharedKt;
import su.catlean.api.contracts.Contract4;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.DimensionServiceComponent;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.HoveringComponentServiceComponent5;
import su.catlean.client.services.client.HoveringComponentServiceComponent6;
import su.catlean.client.services.client.LocalhostServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.ServiceComponent7;
import su.catlean.client.services.client.ServiceComponent78;
import su.catlean.client.services.client.config.models.IdRecord7;
import su.catlean.client.services.render.ActionRenderHelper;
import su.catlean.client.services.render.ClickActionRenderHelper2Impl;
import su.catlean.client.services.render.ColorValue1RenderHelper;
import su.catlean.client.services.render.FontRenderHelper;
import su.catlean.client.services.render.NewThemeRenderHelper;
import su.catlean.client.services.render.PointRenderHelper2Impl;
import su.catlean.client.services.render.RefRenderHelper2Impl;
import su.catlean.client.services.render.RenderHelper2;
import su.catlean.client.services.render.RenderHelper3;
import su.catlean.client.services.render.SuggestionsRenderHelper2Impl;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;
import su.catlean.client.types.TpYawSmootherMode;

public class WaypointPanelGuiElement extends RenderHelper3 {

    public static final WaypointPanelGuiElement INSTANCE;
    private static List itemList;
    private static RenderHelper2 renderHelper2;
    private static RenderHelper2 renderHelper22;
    private static RenderHelper2 renderHelper23;
    private static PointRenderHelper2Impl pointRenderHelper2Impl;
    private static EasingServiceComponent easingServiceComponent;
    private static EasingServiceComponent easingServiceComponent2;
    private static EasingServiceComponent easingServiceComponent3;
    private static boolean enabledFlag;
    private static float factorValue;
    private static final SuggestionsRenderHelper2Impl suggestionsRenderHelper2Impl;
    private static final SuggestionsRenderHelper2Impl suggestionsRenderHelper2Impl2;
    private static final SuggestionsRenderHelper2Impl suggestionsRenderHelper2Impl3;
    private static final SuggestionsRenderHelper2Impl suggestionsRenderHelper2Impl4;
    private static final SuggestionsRenderHelper2Impl suggestionsRenderHelper2Impl5;

    private WaypointPanelGuiElement() {
        super("waypoint-panel", 0.0F, 0.0F, 0.0F, 0.0F);
    }

    public List getList() {
        return itemList;
    }

    public void executeAction(List value) {
        itemList = value;
    }

    public RenderHelper2 getRenderHelper2() {
        return renderHelper2;
    }

    public void updateValue(RenderHelper2 value) {
        renderHelper2 = value;
    }

    public RenderHelper2 getRenderHelper22() {
        return renderHelper23;
    }

    public void updateValue2(RenderHelper2 value) {
        renderHelper23 = value;
    }

    public PointRenderHelper2Impl getPointRenderHelper2Impl() {
        return pointRenderHelper2Impl;
    }

    public void updateValue(PointRenderHelper2Impl value) {
        pointRenderHelper2Impl = value;
    }

    public EasingServiceComponent getEasingServiceComponent() {
        return easingServiceComponent;
    }

    public void executeAction(EasingServiceComponent value) {
        easingServiceComponent = value;
    }

    public void updateValue() {
        itemList.clear();
        Iterable iterable = ((Iterable) LocalhostServiceComponent.INSTANCE.resolveList());
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            IdRecord7 idRecord7 = ((IdRecord7) element);
            itemList.add(new PointRenderHelper2Impl(idRecord7));
        }
    }

    public void render(DrawContext context, int mouseX, int mouseY) {
        this.render(context, mouseX, mouseY);
        if (__UNDEF_KEY__ == null) {
            easingServiceComponent.executeAction(1.0F);
            if (this.getContract4() != null) {
            } else {
            }
        }
        this.executeAction(0.0F);
        easingServiceComponent3.executeAction(factorValue);
        float factor = (this.getNumericValue() + 3.0F);
        float factor2 = (this.getNumericValue() + 72.0F);
        int index = mouseX;
        if (__UNDEF_KEY__ == null) {
            if (factor <= index) {
                if (__UNDEF_KEY__ == null) {
                }
            } else {
                if (index <= factor2) {
                    factor = (this.getNumericValue2() + 5.0F);
                    factor2 = (this.getNumericValue2() + 13.0F);
                    index = mouseY;
                    if (__UNDEF_KEY__ == null) {
                        if (factor <= index) {
                            if (__UNDEF_KEY__ == null) {
                            }
                        } else {
                        }
                    }
                } else {
                    enabledFlag = index <= factor2;
                }
            }
        }
        if (enabledFlag) {
        } else {
        }
        if (enabledFlag) {
        } else {
        }
        int index2 = 14336;
        float factor3 = 0.0F;
        float factor4 = 0.0F;
        float factor5 = 0.0F;
        Color color = NewThemeRenderHelper.INSTANCE.getColor6();
        Color color2 = NewThemeRenderHelper.INSTANCE.getColor4();
        float factor6 = 1.0F;
        float factor7 = 0.0F;
        float factor8 = 0.1F;
        float factor9 = 2.0F;
        float factor10 = 2.5F;
        float factor11 = 2.0F;
        float factor12 = 8.0F;
        float factor13 = 69.0F;
        StackShaderComponent2.executeAction((this.getNumericValue2() + 3.0F), factor13, factor12, factor11, factor10, factor9, factor8, factor7, factor6, color2, color, factor5, factor4, factor3, index2);
        SFMServiceComponent.resolveFontRenderHelper().render(context, "+", (this.getNumericValue() + 36.0F), (this.getNumericValue2() + 1.0F), Color.WHITE);
        StackShaderComponent2.executeAction(context.method_51448(), (this.getNumericValue() + 76.0F), this.getNumericValue2(), 6.0F, this.getNumericValue4(), 1.0F, 0.0F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        renderHelper23 = null;
        renderHelper2 = null;
        factor = 0.0F;
        factor = (17.0F + easingServiceComponent3.getNumericValue());
        PolygonShaderComponent.INSTANCE.render(context, new ServiceComponent78(this.getNumericValue(), (this.getNumericValue2() + 14), (this.getNumericValue() + 76), ((this.getNumericValue2() + this.getNumericValue4()) - 2.0F)));
        factor2 = ((Iterable) itemList);
        index = 0;
        Iterator iterator = factor2.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            PointRenderHelper2Impl pointRenderHelper2Impl = ((PointRenderHelper2Impl) element);
            pointRenderHelper2Impl.render(context, INSTANCE.getNumericValue(), (INSTANCE.getNumericValue2() + factor), mouseX, mouseY);
            factor = (factor + 29.0F);
            if (__UNDEF_KEY__ == null) {
                PolygonShaderComponent.INSTANCE.render(context);
            }
        }
        if (__UNDEF_KEY__ == null) {
            if (pointRenderHelper2Impl != null) {
                factor2 = ((1.0F - easingServiceComponent.getNumericValue()) * 10.0F);
                index = this::getUnit;
                suggestionsRenderHelper2Impl.render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 17.0F) + factor2), mouseX, mouseY);
                suggestionsRenderHelper2Impl2.render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 32.0F) + factor2), mouseX, mouseY);
                suggestionsRenderHelper2Impl3.render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 47.0F) + factor2), mouseX, mouseY);
                suggestionsRenderHelper2Impl4.render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 62.0F) + factor2), mouseX, mouseY);
                suggestionsRenderHelper2Impl5.render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 77.0F) + factor2), mouseX, mouseY);
                new RefRenderHelper2Impl(this.getNumericValue3(), ((KMutableProperty0) new DimensionServiceComponent(pointRenderHelper2Impl.getIdRecord7())), ((KMutableProperty0) new HoveringComponentServiceComponent5(this))).render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 92.0F) + factor2), mouseX, mouseY);
                new ClickActionRenderHelper2Impl(index, this.getNumericValue3(), ((KMutableProperty0) new HoveringComponentServiceComponent6(this))).render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 107.0F) + factor2), mouseX, mouseY);
            }
            ColorValue1RenderHelper.executeAction(this.getNumericValue(), this.getNumericValue2(), this.getNumericValue3(), this.getNumericValue4(), 5.0F, PolygonShaderComponent.INSTANCE.resolveColor(Color.BLACK, easingServiceComponent2.getNumericValue()), PolygonShaderComponent.INSTANCE.resolveColor(Color.BLACK, easingServiceComponent2.getNumericValue()), PolygonShaderComponent.INSTANCE.resolveColor(Color.BLACK, easingServiceComponent2.getNumericValue()), PolygonShaderComponent.INSTANCE.resolveColor(Color.BLACK, easingServiceComponent2.getNumericValue()), context.method_51448(), 0.0F);
        }
        if (__UNDEF_KEY__ == null) {
            if (this.getContract4() != null) {
                this.getContract4().render(context, ((this.getNumericValue() + (this.getNumericValue3() / 2.0F)) - 60.0F), ((this.getNumericValue2() + (this.getNumericValue4() / 2)) - 35.0F), mouseX, mouseY);
            } else {
            }
        }
    }

    private void executeAction(String arg0, char arg1) {
        if (arg1 > 0) {
            if (SharedKt.getMc().player != null && SharedKt.getMc().world != null) {
                if (SharedKt.getMc().method_1562() != null) {
                } else {
                    SharedKt.getMc().method_1562().method_45734();
                }
                if (null == null) {
                    IdRecord7 idRecord7 = new IdRecord7(arg0, 0, 0, 0, null, 0, false);
                } else {
                    idRecord7 = new IdRecord7(arg0, SharedKt.getPlayer().getX(), SharedKt.getPlayer().getY(), SharedKt.getPlayer().getZ(), SharedKt.getNetwork().method_45734().field_3761, LocalhostServiceComponent.INSTANCE.computeValue(SharedKt.getWorld().method_27983().method_29177().method_12832()), false);
                }
            }
        }
        LocalhostServiceComponent.INSTANCE.checkCondition(idRecord7);
        this.updateValue();
        this.updateValue(null);
    }

    public void executeAction(float mX, float mY, int button) {
        this.executeAction(mX, mY, button);
        if (enabledFlag) {
            SuggestionsRenderHelper2Impl.serviceComponent7.updateValue(null);
            this.updateValue(new ActionRenderHelper(this::resolveUnit));
            return;
        }
        if (__UNDEF_KEY__ >= 0) {
            if (this.getContract4() != null && this.getContract4().checkCondition(mX, mY, button)) {
                return;
            }
        }
        this.updateValue(null);
        if (__UNDEF_KEY__ > 0) {
            if (renderHelper2 != null) {
                renderHelper22 = renderHelper2;
                renderHelper2.checkCondition(mX, mY, button);
                return;
            }
            renderHelper22 = null;
        }
        if (__UNDEF_KEY__ >= 0) {
        }
        ((PointRenderHelper2Impl) renderHelper23).getIdRecord7().updateValue(!(((PointRenderHelper2Impl) renderHelper23).getIdRecord7().isActive()));
        pointRenderHelper2Impl = ((PointRenderHelper2Impl) renderHelper23);
        suggestionsRenderHelper2Impl.executeAction(pointRenderHelper2Impl.getIdRecord7().getString());
        suggestionsRenderHelper2Impl2.executeAction(pointRenderHelper2Impl.getIdRecord7().getString2());
        suggestionsRenderHelper2Impl3.executeAction(String.valueOf(pointRenderHelper2Impl.getIdRecord7().getNumericValue()));
        suggestionsRenderHelper2Impl4.executeAction(String.valueOf(pointRenderHelper2Impl.getIdRecord7().getNumericValue2()));
        suggestionsRenderHelper2Impl5.executeAction(String.valueOf(pointRenderHelper2Impl.getIdRecord7().getNumericValue3()));
        easingServiceComponent.updateValue2(0.0F);
    }

    public void executeAction(double mouseX, double mouseY, double amount) {
        float factor = this.getNumericValue();
        if (__UNDEF_KEY__ >= 0L) {
            if (__UNDEF_KEY__ == null) {
                if (mouseX <= (this.getNumericValue() + 76.0F)) {
                    if (__UNDEF_KEY__ == null) {
                    }
                } else {
                }
            }
        }
        factor = this.getNumericValue2();
        if (__UNDEF_KEY__ > 0L) {
            if (__UNDEF_KEY__ == null) {
                if (mouseY <= ((this.getNumericValue2() + this.getNumericValue4()) - 2.0F)) {
                    if (__UNDEF_KEY__ == null) {
                    }
                } else {
                }
            }
        }
        factorValue = (factorValue + (amount * 7.0F));
        factorValue = Math.clamp(factorValue, (itemList.size() * -29.0F), 0.0F);
    }

    private static Unit resolveUnit(SuggestionsRenderHelper2Impl arg0) {
        if (pointRenderHelper2Impl != null && pointRenderHelper2Impl.getIdRecord7() != null) {
            pointRenderHelper2Impl.getIdRecord7().executeAction(arg0.getString2());
        } else {
        }
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit2(SuggestionsRenderHelper2Impl arg0) {
        if (pointRenderHelper2Impl != null && pointRenderHelper2Impl.getIdRecord7() != null) {
            pointRenderHelper2Impl.getIdRecord7().executeAction(arg0.getString2());
        } else {
        }
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit3(SuggestionsRenderHelper2Impl arg0) {
        if (pointRenderHelper2Impl != null && pointRenderHelper2Impl.getIdRecord7() != null) {
            if (StringsKt.toIntOrNull(arg0.getString2()) != null) {
            } else {
                StringsKt.toIntOrNull(arg0.getString2());
            }
            pointRenderHelper2Impl.getIdRecord7().updateValue(0);
        } else {
        }
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit4(SuggestionsRenderHelper2Impl arg0) {
        if (pointRenderHelper2Impl != null && pointRenderHelper2Impl.getIdRecord7() != null) {
            if (StringsKt.toIntOrNull(arg0.getString2()) != null) {
            } else {
                StringsKt.toIntOrNull(arg0.getString2());
            }
            pointRenderHelper2Impl.getIdRecord7().updateValue2(0);
        } else {
        }
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit5(SuggestionsRenderHelper2Impl arg0) {
        if (pointRenderHelper2Impl != null && pointRenderHelper2Impl.getIdRecord7() != null) {
            if (StringsKt.toIntOrNull(arg0.getString2()) != null) {
            } else {
                StringsKt.toIntOrNull(arg0.getString2());
            }
            pointRenderHelper2Impl.getIdRecord7().updateValue3(0);
        } else {
        }
        return Unit.INSTANCE;
    }

    private static Unit getUnit() {
        LocalhostServiceComponent.INSTANCE.checkCondition(pointRenderHelper2Impl.getIdRecord7());
        Collection collection = ((Collection) itemList);
        TypeIntrinsics.asMutableCollection(collection).remove(pointRenderHelper2Impl);
        pointRenderHelper2Impl = null;
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit(String arg0) {
        INSTANCE.executeAction(arg0);
        return Unit.INSTANCE;
    }

    static {
        INSTANCE = new WaypointPanelGuiElement();
        itemList = new ArrayList();
        easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT);
        easingServiceComponent2 = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT);
        easingServiceComponent3 = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT);
        suggestionsRenderHelper2Impl = new SuggestionsRenderHelper2Impl("Name", INSTANCE.getNumericValue3(), null, this::resolveUnit);
        suggestionsRenderHelper2Impl2 = new SuggestionsRenderHelper2Impl("Server", INSTANCE.getNumericValue3(), null, this::resolveUnit2);
        suggestionsRenderHelper2Impl3 = new SuggestionsRenderHelper2Impl("X", INSTANCE.getNumericValue3(), null, this::resolveUnit3);
        suggestionsRenderHelper2Impl4 = new SuggestionsRenderHelper2Impl("Y", INSTANCE.getNumericValue3(), null, this::resolveUnit4);
        suggestionsRenderHelper2Impl5 = new SuggestionsRenderHelper2Impl("Z", INSTANCE.getNumericValue3(), null, this::resolveUnit5);
        INSTANCE.updateValue();
        INSTANCE.updateValue(290.0F);
    }

}
