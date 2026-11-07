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
        this.lookupMap = ((Map) new LinkedHashMap());
        this.labelRenderHelper = new LabelRenderHelper(0.0F, 0.0F, 40.0F, 15.0F, "", this::resolveUnit, 0, NewThemeRenderHelper.INSTANCE.getColor10(), NewThemeRenderHelper.INSTANCE.getColor13(), 0.0F, 0.0F);
        this.updateValue();
    }

    private void executeAction(String arg0) {
        Iterable iterable = ((Iterable) ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl3().resolveList());
        JsonJsonServiceComponent5Impl3 jsonJsonServiceComponent5Impl3 = ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl3();
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            IdRecord4 idRecord4 = ((IdRecord4) element);
        }
        if (((IdRecord4) null) == null) {
            return;
        }
        element.executeAction(jsonJsonServiceComponent5Impl3);
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
        int index = 0;
        int index2 = 0;
        int index3 = 0;
        if (index3 < 9) {
            if (ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl3().resolveIdRecord4().getMap().get(Integer.valueOf(index)) == null) {
            } else {
            }
            Item item = ((Item) ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl3().resolveIdRecord4().getMap().get(Integer.valueOf(index)));
            this.lookupMap.put(new LabelRenderHelper((index3 * 20.0F), (index2 * 20.0F), 18.0F, 18.0F, "", this::resolveUnit, index, NewThemeRenderHelper.INSTANCE.getColor10(), NewThemeRenderHelper.INSTANCE.getColor13(), 0.0F, 0.0F), item);
        }
    }

    private void executeAction(int arg0, int arg1, Item arg2, long arg3) {
        Map map = ((Map) Maps.newHashMap(this.lookupMap));
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry entry = ((Entry) iterator.next());
            if (((LabelRenderHelper) entry.getKey()).getNumericValue() == arg0) {
                this.lookupMap.put(entry.getKey(), arg2);
            }
        }
        ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl3().resolveIdRecord4().getMap().put(Integer.valueOf(arg0), arg2);
    }

    public void render(DrawContext context, int mouseX, int mouseY) {
        int index = ((SharedKt.getMc().method_22683().method_4486() / 2.0F) - (this.getNumericValue() / 2.0F));
        int index2 = (((SharedKt.getMc().method_22683().method_4502() / 2.0F) - (this.getNumericValue2() / 2.0F)) - 50.0F);
        Color[] items = new Color[1];
        items[0] = new Color(1157627903, true);
        PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), (index + 6), (index2 + 91.5F), (this.getNumericValue() - 12), 0.5F, items);
        this.labelRenderHelper.render((index + 6), (index2 + 5.0F), mouseX, mouseY, context);
        SFMServiceComponent.resolveFontRenderHelper2().render(context, "select", (index + 25.0F), (index2 + 11.0F), NewThemeRenderHelper.INSTANCE.getColor8());
        SFMServiceComponent.resolveFontRenderHelper2().render(context, ("Current kit: " + ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl3().resolveIdRecord4().getString()), (index + (this.getNumericValue() / 2.0F)), (index2 + 11.0F), NewThemeRenderHelper.INSTANCE.getColor8());
        items = 0;
        Map map = this.lookupMap;
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry entry = ((Entry) iterator.next());
            if (0 <= items) {
            } else {
                if (items < 9) {
                } else {
                    if (9 <= items) {
                    } else {
                        if (items < 18) {
                        } else {
                            if (18 <= items) {
                            } else {
                                if (items < 27) {
                                } else {
                                }
                            }
                        }
                    }
                }
            }
            int index3 = 65;
            ((LabelRenderHelper) entry.getKey()).render(((((items % 9) * 20.0F) + index) + 5.0F), ((index3 + index2) + 30.0F), mouseX, mouseY, context);
            if (renderHelper == null) {
                context.method_51448().pushMatrix();
                context.method_51448().translate(((((items % 9) * 20.0F) + index) + 6.0F), ((index3 + index2) + 31.0F));
                context.method_51427(((Item) entry.getValue()).method_8389().method_7854(), 0, 0);
                context.method_51448().popMatrix();
            }
            items = (items + 1);
        }
        if (renderHelper != null) {
            renderHelper.render(context, mouseX, mouseY);
        } else {
        }
    }

    public void executeAction(int mouseX, int mouseY, int mouseButton) {
        this.executeAction(mouseX, mouseY, mouseButton);
        if (renderHelper != null) {
            renderHelper.executeAction(mouseX, mouseY, mouseButton);
        }
        Map map = this.lookupMap;
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry entry = ((Entry) iterator.next());
            ((LabelRenderHelper) entry.getKey()).executeAction(mouseX, mouseY);
        }
        this.labelRenderHelper.executeAction(mouseX, mouseY);
    }

    public void executeAction(int key) {
        this.executeAction(key);
        if (__UNDEF_KEY__ != null) {
            if (renderHelper != null) {
                renderHelper.executeAction(key);
            } else {
            }
        }
    }

    public void executeAction(char charParam) {
        this.executeAction(charParam);
        if (__UNDEF_KEY__ != null) {
            if (renderHelper != null) {
                renderHelper.executeAction(charParam);
            } else {
            }
        }
    }

    public void executeAction(double mouseX, double mouseY, double verticalAmount) {
        this.executeAction(mouseX, mouseY, verticalAmount);
        if (__UNDEF_KEY__ != null) {
            if (renderHelper != null) {
                renderHelper.executeAction(mouseX, mouseY, verticalAmount);
            } else {
            }
        }
    }

    private static Unit resolveUnit(SelectRenderHelperImpl arg0, String arg1) {
        arg0.executeAction(arg1);
        renderHelper.updateValue(true);
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit2(SelectRenderHelperImpl arg0, String arg1) {
        arg0.executeAction(arg1);
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit(SelectRenderHelperImpl arg0) {
        Iterable iterable = ((Iterable) ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl3().resolveList());
        Collection collection = ((Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10)));
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            IdRecord4 idRecord4 = ((IdRecord4) element);
            if (__UNDEF_KEY__ != null) {
                collection.add(idRecord4.getString());
            }
        }
        Function1 function1 = this::resolveUnit2;
        Function1 function12 = this::resolveUnit;
        renderHelper = new ClickActionRenderHelper(collection, function12, function1);
        return Unit.INSTANCE;
    }

    private static boolean checkCondition(String arg0, IdRecord4 arg1) {
        return Intrinsics.areEqual(arg1.getString(), arg0);
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return ((Boolean) arg0.invoke(arg1));
    }

    private static Unit resolveUnit(SelectRenderHelperImpl arg0, int arg1, Item arg2) {
        arg0.executeAction(arg1, arg2);
        renderHelper.updateValue(true);
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit(Item arg0, SelectRenderHelperImpl arg1, int arg2) {
        Item[] items = new Item[1];
        items[0] = arg0;
        renderHelper = new ClickActionRenderHelper2(CollectionsKt.mutableListOf(items), this::resolveUnit);
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
