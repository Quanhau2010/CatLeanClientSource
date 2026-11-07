package su.catlean.client.services.render;

import com.google.common.collect.Maps;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1041;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import org.joml.Matrix3x2fStack;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.JsonJsonServiceComponent5Impl3;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.ServiceComponent62;
import su.catlean.client.services.client.config.models.IdRecord4;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.ui.clickgui.ProxyGuiElement;

public class SelectRenderHelperImpl extends RenderHelper {

    public static final ServiceComponent62 serviceComponent62;
    private final Map lookupMap;
    private final LabelRenderHelper labelRenderHelper;
    private static RenderHelper renderHelper;
    private static Module[] moduleArray;

    public SelectRenderHelperImpl() {
        super();
        this.lookupMap = (Map) new LinkedHashMap();
        this.labelRenderHelper = new LabelRenderHelper(0.0F, 0.0F, 40.0F, 15.0F, "", this::resolveUnit, 0, NewThemeRenderHelper.INSTANCE.getColor10(), NewThemeRenderHelper.INSTANCE.getColor13(), 0.0F, 0.0F);
        this.updateValue();
    }

    private void executeAction(String arg0) {
        Iterable var11 = (Iterable) ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl3().resolveList();
        JsonJsonServiceComponent5Impl3 var17 = ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl3();
        int var12 = 0;
        Iterator iterator = var11.iterator();
        if (iterator.hasNext()) {
            Object var14 = iterator.next();
            IdRecord4 var15 = (IdRecord4) var14;
            int var16 = 0;
        } else {
        }
        if ((IdRecord4) null == null) {
            return;
        }
        var14.executeAction();
        this.updateValue();
    }

    private void executeAction(String arg0) {
        ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl3().resolveList().removeIf(this::checkCondition);
        this.updateValue();
    }

    public void updateValue() {
        this.updateValue(188.0F);
        this.updateValue2(119.0F);
        this.lookupMap.clear();
        int var8 = 0;
        int var9 = 0;
        int var10 = 0;
        if (var10 < 9) {
            int var11 = var8;
            if (ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl3().resolveIdRecord4().getMap().get(Integer.valueOf()) == null) {
            } else {
            }
            Item var13 = (Item) ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl3().resolveIdRecord4().getMap().get(Integer.valueOf());
            Object var12 = var13;
            this.lookupMap.put(new LabelRenderHelper((var10 * 20.0F), (var9 * 20.0F), 18.0F, 18.0F, "", this::resolveUnit, NewThemeRenderHelper.INSTANCE.getColor10(), NewThemeRenderHelper.INSTANCE.getColor13(), 0.0F, 0.0F));
        }
    }

    private void executeAction(int arg0, int arg1, Item arg2, long arg3) {
        Map var11 = (Map) Maps.newHashMap(this.lookupMap);
        int var12 = 0;
        Iterator iterator = var11.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry var14 = (Entry) iterator.next();
            Object var15 = var14;
            int var16 = 0;
            if ((LabelRenderHelper) var15.getKey().getNumericValue() == arg0) {
                this.lookupMap.put(var15.getKey(), arg2);
            }
        }
        ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl3().resolveIdRecord4().getMap().put(Integer.valueOf(arg0), arg2);
    }

    public void render(DrawContext context, int mouseX, int mouseY) {
        long var6 = (0L ^ 49135606458366L);
        long var8 = (0L ^ 140651307937406L);
        long var10 = (0L ^ 83711771966610L);
        long var12 = (0L ^ 119233142815521L);
        long var14 = (0L ^ 134822669100867L);
        long var16 = (0L ^ 109054091827800L);
        long var18 = (0L ^ 102625430865227L);
        int var21 = ((SharedKt.getMc().method_22683().method_4486() / 2.0F) - (this.getNumericValue() / 2.0F));
        int var22 = (((SharedKt.getMc().method_22683().method_4502() / 2.0F) - (this.getNumericValue2() / 2.0F)) - 50.0F);
        Color[] var23 = new Color[1];
        var23[0] = new Color(1157627903, 1);
        PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), (var21 + 6), (var22 + 91.5F), (this.getNumericValue() - 12), 0.5F);
        this.labelRenderHelper.render((var21 + 6), (var22 + 5.0F), mouseX, mouseY, context);
        SFMServiceComponent.resolveFontRenderHelper2().render(context, "select", (var21 + 25.0F), (var22 + 11.0F), NewThemeRenderHelper.INSTANCE.getColor8());
        SFMServiceComponent.resolveFontRenderHelper2().render(context, ("Current kit: " + ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl3().resolveIdRecord4().getString()), (var21 + (this.getNumericValue() / 2.0F)), (var22 + 11.0F), NewThemeRenderHelper.INSTANCE.getColor8());
        var23 = 0;
        Map var24 = this.lookupMap;
        int var25 = 0;
        Iterator iterator = var24.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry var27 = (Entry) iterator.next();
            Object var28 = var27;
            int var29 = 0;
            int var30 = var23;
            if (0L >= 0L && var20 != null) {
                if (0L >= 0L) {
                    if (0 <= var30) {
                    }
                } else {
                }
                if (0L > 0L) {
                    if (var30 < 9) {
                    } else {
                    }
                    if (0L > 0L) {
                        if (9 <= var30) {
                        }
                    } else {
                    }
                    if (0L >= 0L) {
                        if (var30 < 18) {
                        } else {
                        }
                        if (0L > 0L) {
                            if (18 <= var30) {
                            }
                        } else {
                        }
                        if (0L > 0L) {
                            if (var30 < 27) {
                            } else {
                            }
                        }
                    }
                }
                int var31 = 65;
                (LabelRenderHelper) var28.getKey().render(((((var23 % 9) * 20.0F) + var21) + 5.0F), ((var31 + var22) + 30.0F), mouseX, mouseY, context);
                if (renderHelper == null) {
                    context.method_51448().pushMatrix();
                    context.method_51448().translate(((((var23 % 9) * 20.0F) + var21) + 6.0F), ((var31 + var22) + 31.0F));
                    context.method_51427((Item) var28.getValue().method_8389().method_7854(), 0, 0);
                    context.method_51448().popMatrix();
                }
                var23 = (var23 + 1);
            }
        }
        if (0L < 0L || var20 == null || renderHelper != null) {
            continue;
        }
    }

    public void executeAction(int mouseX, int mouseY, int mouseButton) {
        long var6 = (0L ^ 83277054500049L);
        long var8 = (0L ^ 0L);
        this.executeAction(mouseX, mouseY, mouseButton);
        if (renderHelper != null) {
            renderHelper.executeAction(mouseX, mouseY, mouseButton);
        }
        Map var11 = this.lookupMap;
        int var12 = 0;
        Iterator iterator = var11.entrySet().iterator();
        if (iterator.hasNext()) {
            Entry var14 = (Entry) iterator.next();
            Object var15 = var14;
            int var16 = 0;
            if (0L >= 0L) {
                (LabelRenderHelper) var15.getKey().executeAction(mouseX, mouseY);
            }
        }
        this.labelRenderHelper.executeAction(mouseX, mouseY);
    }

    public void executeAction(int key) {
        long var4 = (0L ^ 0L);
        this.executeAction(key);
        if (var6 != null) {
            if (renderHelper != null) {
                renderHelper.executeAction(key);
            }
        } else {
        }
    }

    public void executeAction(char char) {
        long var4 = (0L ^ 0L);
        this.executeAction(char);
        if (var6 != null) {
            if (renderHelper != null) {
                renderHelper.executeAction(char);
            }
        } else {
        }
    }

    public void executeAction(double mouseX, double mouseY, double verticalAmount) {
        long var9 = (0L ^ 0L);
        this.executeAction(mouseX, mouseY, verticalAmount);
        if (var11 != null) {
            if (renderHelper != null) {
                renderHelper.executeAction(mouseX, mouseY, verticalAmount);
            }
        } else {
        }
    }

    private static Unit resolveUnit(SelectRenderHelperImpl arg0, String arg1) {
        arg0.executeAction(arg1);
        renderHelper.updateValue(1);
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit2(SelectRenderHelperImpl arg0, String arg1) {
        arg0.executeAction(arg1);
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit(SelectRenderHelperImpl arg0) {
        Iterable var8 = (Iterable) ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl3().resolveList();
        int var9 = 0;
        Object var10 = var8;
        Collection var11 = (Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(10));
        int var12 = 0;
        Iterator iterator = var10.iterator();
        if (iterator.hasNext()) {
            Object var14 = iterator.next();
            IdRecord4 var15 = (IdRecord4) var14;
            if (var7 != null) {
                Object var17 = var11;
                int var16 = 0;
                var17.add(var15.getString());
            }
        }
        Function1 var18 = this::resolveUnit2;
        Function1 var19 = this::resolveUnit;
        List positions = var11;
        renderHelper = new ClickActionRenderHelper(positions);
        return Unit.INSTANCE;
    }

    private static boolean checkCondition(String arg0, IdRecord4 arg1) {
        return Intrinsics.areEqual(arg1.getString(), arg0);
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return (Boolean) arg0.invoke(arg1);
    }

    private static Unit resolveUnit(SelectRenderHelperImpl arg0, int arg1, Item arg2) {
        arg0.executeAction(arg1, arg2);
        renderHelper.updateValue(1);
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit(Item arg0, SelectRenderHelperImpl arg1, int arg2) {
        Item[] var8 = new Item[1];
        var8[0] = arg0;
        renderHelper = new ClickActionRenderHelper2(CollectionsKt.mutableListOf(), this::resolveUnit);
        return Unit.INSTANCE;
    }

    public static RenderHelper getRenderHelper() {
        return renderHelper;
    }

    public static void updateValue(RenderHelper value) {
        renderHelper = value;
    }

    static {
        serviceComponent62 = new ServiceComponent62();
    }

    public static void updateValue(Module[] arg0) {
        moduleArray = arg0;
    }

    public static Module[] process() {
        return moduleArray;
    }

}
