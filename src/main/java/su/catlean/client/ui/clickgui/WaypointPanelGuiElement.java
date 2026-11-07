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

    public void updateValue(long arg0) {
        long var3 = (arg0 ^ 117820025401429L);
        long var5 = ((arg0 ^ 138605463114249L) >>> 32);
        long var6 = (((arg0 ^ 138605463114249L) << 32) >>> 48);
        long var7 = (((arg0 ^ 138605463114249L) << 48) >>> 48);
        itemList.clear();
        Iterable var8 = (Iterable) LocalhostServiceComponent.INSTANCE.resolveList();
        int var9 = 0;
        Iterator iterator = var8.iterator();
        if (iterator.hasNext()) {
            Object var11 = iterator.next();
            IdRecord7 var12 = (IdRecord7) var11;
            int var13 = 0;
            itemList.add(new PointRenderHelper2Impl());
        }
    }

    public void render(DrawContext context, int mouseX, int mouseY) {
        long var6 = ((0L ^ 138493012530694L) >>> 32);
        long var7 = (((0L ^ 138493012530694L) << 32) >>> 48);
        long var8 = (((0L ^ 138493012530694L) << 48) >>> 48);
        long var9 = (0L ^ 136208856317167L);
        long var11 = (0L ^ 38443269427772L);
        long var13 = (0L ^ 136208856317167L);
        long var15 = (0L ^ 129382754651428L);
        long var17 = (0L ^ 136208856317167L);
        long var19 = ((0L ^ 55302899458674L) >>> 48);
        long var20 = (((0L ^ 55302899458674L) << 16) >>> 32);
        long var21 = (((0L ^ 55302899458674L) << 48) >>> 48);
        long var22 = ((0L ^ 22135879901675L) >>> 48);
        long var23 = (((0L ^ 22135879901675L) << 16) >>> 48);
        long var24 = (((0L ^ 22135879901675L) << 32) >>> 32);
        long var25 = (0L ^ 70517311181201L);
        long var27 = (0L ^ 27182768661316L);
        long var29 = (0L ^ 0L);
        long var31 = (0L ^ 97910750751556L);
        long var33 = (0L ^ 55127167163707L);
        long var35 = (0L ^ 2881734234662L);
        long var37 = (0L ^ 55531218400380L);
        long var39 = ((0L ^ 41763221279864L) >>> 56);
        long var40 = (((0L ^ 41763221279864L) << 8) >>> 32);
        long var41 = (((0L ^ 41763221279864L) << 40) >>> 40);
        long var42 = (0L ^ 107679707250070L);
        long var44 = (0L ^ 53082601043283L);
        long var46 = (0L ^ 136208856317167L);
        this.render(context, mouseX, mouseY);
        if (var63 == null) {
            easingServiceComponent.executeAction(1.0F);
            if (this.getContract4() != null) {
            }
        } else {
        }
        0.5F.executeAction(0.0F);
        easingServiceComponent3.executeAction(factorValue);
        float var64 = (this.getNumericValue() + 3.0F);
        float var65 = (this.getNumericValue() + 72.0F);
        int var66 = mouseX;
        if (0L > 0L) {
            if (var63 == null) {
                if (var64 <= var66) {
                }
            }
            if (var63 == null) {
            }
        } else {
        }
        if (var66 <= var65) {
            var64 = (this.getNumericValue2() + 5.0F);
            var65 = (this.getNumericValue2() + 13.0F);
            var66 = mouseY;
            if (0L > 0L) {
                if (var63 == null) {
                    if (var64 <= var66) {
                    }
                }
                if (var63 == null) {
                }
            } else {
            }
            if (0L >= 0L) {
                if (var66 <= var65) {
                }
            }
        } else {
        }
        }
        enabledFlag = 0;
        if (enabledFlag) {
        } else {
        }
        if (enabledFlag) {
        } else {
        }
        int var49 = 14336;
        float var50 = 0.0F;
        float var51 = 0.0F;
        float var52 = 0.0F;
        Color var53 = NewThemeRenderHelper.INSTANCE.getColor6();
        Color var54 = NewThemeRenderHelper.INSTANCE.getColor4();
        float var55 = 1.0F;
        float var56 = 0.0F;
        float var57 = 0.1F;
        float var58 = 2.0F;
        float var59 = 2.5F;
        float var60 = 2.0F;
        float var61 = 8.0F;
        float var62 = 69.0F;
        StackShaderComponent2.executeAction((this.getNumericValue2() + 3.0F));
        SFMServiceComponent.resolveFontRenderHelper().render(context, "+", (this.getNumericValue() + 36.0F), (this.getNumericValue2() + 1.0F), Color.WHITE);
        StackShaderComponent2.executeAction(context.method_51448(), (this.getNumericValue() + 76.0F), this.getNumericValue2(), 6.0F, this.getNumericValue4(), 1.0F, 0.0F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        renderHelper23 = null;
        renderHelper2 = null;
        var64 = 0.0F;
        var64 = (17.0F + easingServiceComponent3.getNumericValue());
        PolygonShaderComponent.INSTANCE.render(context, new ServiceComponent78(this.getNumericValue(), (this.getNumericValue2() + 14), (this.getNumericValue() + 76), ((this.getNumericValue2() + this.getNumericValue4()) - 2.0F)));
        var65 = (Iterable) itemList;
        var66 = 0;
        Iterator iterator = var65.iterator();
        if (iterator.hasNext()) {
            Object var68 = iterator.next();
            PointRenderHelper2Impl var69 = (PointRenderHelper2Impl) var68;
            int var70 = 0;
            var69.render(context, INSTANCE.getNumericValue(), (INSTANCE.getNumericValue2() + var64), mouseX, mouseY);
            var64 = (var64 + 29.0F);
            if (0L >= 0L) {
                if (var63 == null) {
                }
                PolygonShaderComponent.INSTANCE.render(context);
            }
        }
        if (0L > 0L) {
            if (var63 == null) {
                if (pointRenderHelper2Impl != null) {
                    var65 = ((1.0F - easingServiceComponent.getNumericValue()) * 10.0F);
                    var66 = this::getUnit;
                    suggestionsRenderHelper2Impl.render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 17.0F) + var65), mouseX, mouseY);
                    suggestionsRenderHelper2Impl2.render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 32.0F) + var65), mouseX, mouseY);
                    suggestionsRenderHelper2Impl3.render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 47.0F) + var65), mouseX, mouseY);
                    suggestionsRenderHelper2Impl4.render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 62.0F) + var65), mouseX, mouseY);
                    suggestionsRenderHelper2Impl5.render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 77.0F) + var65), mouseX, mouseY);
                    new RefRenderHelper2Impl(this.getNumericValue3(), (KMutableProperty0) new DimensionServiceComponent(pointRenderHelper2Impl.getIdRecord7()), (KMutableProperty0) new HoveringComponentServiceComponent5(this)).render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 92.0F) + var65), mouseX, mouseY);
                    new ClickActionRenderHelper2Impl(this.getNumericValue3(), (KMutableProperty0) new HoveringComponentServiceComponent6(this)).render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 107.0F) + var65), mouseX, mouseY);
                }
                ColorValue1RenderHelper.executeAction(this.getNumericValue(), this.getNumericValue2(), this.getNumericValue3(), this.getNumericValue4(), 5.0F, PolygonShaderComponent.INSTANCE.resolveColor(Color.BLACK, easingServiceComponent2.getNumericValue()), PolygonShaderComponent.INSTANCE.resolveColor(Color.BLACK, easingServiceComponent2.getNumericValue()), PolygonShaderComponent.INSTANCE.resolveColor(Color.BLACK, easingServiceComponent2.getNumericValue()), PolygonShaderComponent.INSTANCE.resolveColor(Color.BLACK, easingServiceComponent2.getNumericValue()), context.method_51448(), 0.0F);
            }
        }
        if (var63 == null) {
            if (this.getContract4() != null) {
                this.getContract4().render(context, ((this.getNumericValue() + (this.getNumericValue3() / 2.0F)) - 60.0F), ((this.getNumericValue2() + (this.getNumericValue4() / 2)) - 35.0F), mouseX, mouseY);
            }
        } else {
        }
    }

    private void executeAction(String arg0, char arg1) {
        if (var25 == null) {
        }
        if (arg1 > 0) {
            if (var25 == null) {
                if (SharedKt.getMc().player != null && SharedKt.getMc().world != null) {
                }
            }
            if (SharedKt.getMc().method_1562() != null) {
            } else {
                SharedKt.getMc().method_1562().method_45734();
            }
            if (null == null) {
            }
            IdRecord7 var24 = new IdRecord7(arg0);
        } else {
            var24 = new IdRecord7(arg0, SharedKt.getPlayer().getX(), SharedKt.getPlayer().getY(), SharedKt.getPlayer().getZ(), SharedKt.getNetwork().method_45734().field_3761, LocalhostServiceComponent.INSTANCE.computeValue(SharedKt.getWorld().method_27983().method_29177().method_12832()));
        }
        LocalhostServiceComponent.INSTANCE.checkCondition();
        this.updateValue();
        this.updateValue(null);
    }

    public void executeAction(float mX, float mY, int button) {
        int var7 = (((0L << 48) | ((0L << 32) >>> 16)) | ((0L << 48) >>> 48));
        long var9 = (var7 ^ 72650074335561L);
        long var11 = ((var7 ^ 0L) >>> 48);
        long var12 = (((var7 ^ 0L) << 16) >>> 32);
        long var13 = (((var7 ^ 0L) << 48) >>> 48);
        long var14 = (var7 ^ 38836403100948L);
        long var16 = (var7 ^ 89123186698759L);
        long var18 = (var7 ^ 20362906346987L);
        this.executeAction(mX, mY, button);
        if (enabledFlag) {
            SuggestionsRenderHelper2Impl.serviceComponent7.updateValue(null);
            this.updateValue(new ActionRenderHelper(this::resolveUnit));
            return;
        }
        if (0L >= 0) {
            if (this.getContract4() != null && this.getContract4().checkCondition(mX, mY, button)) {
                return;
            }
        }
        this.updateValue(null);
        if (0L > 0) {
            if (renderHelper2 != null) {
                renderHelper22 = renderHelper2;
                renderHelper2.checkCondition(mX, mY, button);
                return;
            }
            renderHelper22 = null;
        }
        if (0L >= 0) {
        }
        (PointRenderHelper2Impl) renderHelper23.getIdRecord7().updateValue(!((PointRenderHelper2Impl) renderHelper23.getIdRecord7().isActive()));
        pointRenderHelper2Impl = (PointRenderHelper2Impl) renderHelper23;
        suggestionsRenderHelper2Impl.executeAction(pointRenderHelper2Impl.getIdRecord7().getString());
        suggestionsRenderHelper2Impl2.executeAction(pointRenderHelper2Impl.getIdRecord7().getString2());
        suggestionsRenderHelper2Impl3.executeAction(String.valueOf(pointRenderHelper2Impl.getIdRecord7().getNumericValue()));
        suggestionsRenderHelper2Impl4.executeAction(String.valueOf(pointRenderHelper2Impl.getIdRecord7().getNumericValue2()));
        suggestionsRenderHelper2Impl5.executeAction(String.valueOf(pointRenderHelper2Impl.getIdRecord7().getNumericValue3()));
        easingServiceComponent.updateValue2(0.0F);
    }

    public void executeAction(double mouseX, double mouseY, double amount) {
        float var10 = this.getNumericValue();
        if (0L >= 0L) {
            if (var9 == null) {
                if (mouseX <= (this.getNumericValue() + 76.0F)) {
                }
            }
            if (var9 == null) {
            }
        } else {
        }
        var10 = this.getNumericValue2();
        if (0L > 0L) {
            if (var9 == null) {
                if (mouseY <= ((this.getNumericValue2() + this.getNumericValue4()) - 2.0F)) {
                }
            }
            if (var9 == null) {
            }
        } else {
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
        Collection var5 = (Collection) itemList;
        PointRenderHelper2Impl var6 = pointRenderHelper2Impl;
        TypeIntrinsics.asMutableCollection().remove();
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
        easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, var0[1]);
        easingServiceComponent2 = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, var0[2]);
        easingServiceComponent3 = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, var0[0]);
        suggestionsRenderHelper2Impl = new SuggestionsRenderHelper2Impl("Name", INSTANCE.getNumericValue3(), null, this::resolveUnit);
        suggestionsRenderHelper2Impl2 = new SuggestionsRenderHelper2Impl("Server", INSTANCE.getNumericValue3(), null, this::resolveUnit2);
        suggestionsRenderHelper2Impl3 = new SuggestionsRenderHelper2Impl("X", INSTANCE.getNumericValue3(), null, this::resolveUnit3);
        suggestionsRenderHelper2Impl4 = new SuggestionsRenderHelper2Impl("Y", INSTANCE.getNumericValue3(), null, this::resolveUnit4);
        suggestionsRenderHelper2Impl5 = new SuggestionsRenderHelper2Impl("Z", INSTANCE.getNumericValue3(), null, this::resolveUnit5);
        INSTANCE.updateValue();
        INSTANCE.updateValue(290.0F);
    }

}
