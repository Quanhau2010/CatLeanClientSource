package su.catlean.client.services.render;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.minecraft.client.gui.DrawContext;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.utility.misc.UIModule;
import su.catlean.client.services.client.BindServiceComponent;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.EnabledServiceComponent;
import su.catlean.client.services.client.NoneServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.config.models.KeyRecord;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.types.TpYawSmootherMode;

public class KeybindsWidgetCheckRenderHelperImpl extends CheckRenderHelper {

    public static final KeybindsWidgetCheckRenderHelperImpl INSTANCE;
    private static final List itemList;
    private static final EasingServiceComponent easingServiceComponent;

    private KeybindsWidgetCheckRenderHelperImpl() {
        super("keybinds-widget");
    }

    public List getList() {
        return itemList;
    }

    public void render(DrawContext context) {
        long var4 = (0L ^ 73719739740194L);
        long var6 = (0L ^ 4149061658461L);
        long var8 = (0L ^ 50910300018319L);
        long var10 = (0L ^ 81581919584095L);
        long var12 = ((0L ^ 130313712838322L) >>> 8);
        long var14 = (((0L ^ 130313712838322L) << 56) >>> 56);
        long var15 = ((0L ^ 99541060701969L) >>> 48);
        long var16 = (((0L ^ 99541060701969L) << 16) >>> 32);
        long var17 = (((0L ^ 99541060701969L) << 48) >>> 48);
        long var18 = (0L ^ 655743806298L);
        long var20 = (0L ^ 100479272291701L);
        long var22 = (0L ^ 130512158954640L);
        long var24 = ((0L ^ 104104530525409L) >>> 48);
        long var25 = (((0L ^ 104104530525409L) << 16) >>> 32);
        long var26 = (((0L ^ 104104530525409L) << 48) >>> 48);
        long var27 = (0L ^ 76479611429891L);
        long var29 = (0L ^ 128377113661390L);
        long var31 = (0L ^ 20173347401993L);
        long var33 = (0L ^ 99949442920536L);
        long var35 = (0L ^ 30591967126976L);
        Iterable var39 = (Iterable) EnabledServiceComponent.INSTANCE.getArrayList2();
        int var40 = 0;
        Object var41 = var39;
        Collection var42 = (Collection) new ArrayList();
        int var43 = 0;
        Iterator iterator = var41.iterator();
        while (iterator.hasNext()) {
            if (0L > 0L) {
            }
            Object var45 = iterator.next();
            Module var46 = (Module) var45;
            int var47 = 0;
            var42.add();
        }
        Iterator iterator2 = var42.iterator();
        if (iterator2.hasNext()) {
            var39 = (Module) iterator2.next();
            var41 = (Iterable) itemList;
            var42 = 0;
            if (0L >= 0L) {
                if (var41 instanceof Collection && (Collection) var41.isEmpty()) {
                } else {
                    var43 = var41.iterator();
                    if (var43.hasNext()) {
                        iterator = var43.next();
                        var45 = (BindServiceComponent) iterator;
                        var46 = 0;
                    } else {
                    }
                }
                var40 = 1;
                if (0L > 0L) {
                }
                if (var39.getBind().getNumericValue() != -1) {
                    if (var39.getEnabled()) {
                        if (0L > 0L) {
                            if (!(var37) && !(var37)) {
                                if (var40) {
                                    itemList.add(new BindServiceComponent(var39.getString2(), NoneServiceComponent.INSTANCE.resolveString(var39.getBind().getNumericValue())));
                                }
                            }
                        }
                    }
                }
                if (0L > 0L) {
                    if (!(var37)) {
                    }
                }
                if (0L > 0L) {
                    if (!(var37)) {
                    }
                    if (var39.getBind().getNumericValue() != -1) {
                        if (0L >= 0L) {
                        }
                        var41 = (Iterable) itemList;
                    }
                    var42 = 0;
                }
                var43 = var41;
                iterator = (Collection) new ArrayList();
                var45 = 0;
                var46 = var43.iterator();
                while (var46.hasNext()) {
                    var47 = var46.next();
                    BindServiceComponent var48 = (BindServiceComponent) var47;
                    int var49 = 0;
                    if (0L > 0L) {
                        if (0L >= 0L && !(var37)) {
                        }
                        iterator.add();
                    }
                    var41 = (Iterable) iterator;
                    if (0L > 0L) {
                        var42 = 0;
                    }
                }
                var43 = var41.iterator();
                while (var43.hasNext()) {
                    iterator = var43.next();
                    var45 = (BindServiceComponent) iterator;
                    var46 = 0;
                    var45.updateValue(1);
                }
            }
            itemList.removeIf(this::checkCondition);
        }
        iterator2 = "Key Binds";
        var39 = this.computeValue() > (this.computeValue2() / 2.0F);
        if (0L <= 0L || var37 || 0L >= 0L) {
            continue;
        }
        if (!(var37)) {
            if (!(SharedKt.getMc().currentScreen instanceof CatleanWidgetEditorRenderHelper)) {
            }
        } else {
        }
        }
        0.0F.executeAction(1.0F);
        this.render(context, iterator2, easingServiceComponent.getNumericValue());
        var40 = 17.0F;
        var41 = (SFMServiceComponent.resolveFontRenderHelper().computeValue(iterator2) + 24.0F);
        var42 = itemList.iterator();
        if (var42.hasNext()) {
            var43 = (BindServiceComponent) var42.next();
            var45 = (CharSequence) var43.getString3();
            if (0L > 0L) {
                if (!(var37)) {
                    if (!(var45.length())) {
                        FontRenderHelper var50 = SFMServiceComponent.resolveFontRenderHelper();
                        var46 = 0;
                    } else {
                    }
                    iterator = StringsKt.trim((CharSequence) var43.getString()).toString().computeValue((String) var45);
                    var45 = SFMServiceComponent.resolveFontRenderHelper().computeValue(var43.getString2());
                    if (0L > 0L) {
                    }
                    var41 = ((iterator + var45) + 13.0F);
                }
                var42 = itemList.iterator();
                while (var42.hasNext()) {
                    var43 = (BindServiceComponent) var42.next();
                    var45 = (CharSequence) var43.getString3();
                }
            }
            if (!(var45.length())) {
                var50 = SFMServiceComponent.resolveFontRenderHelper();
                var46 = 0;
            } else {
            }
            iterator = StringsKt.trim((CharSequence) var43.getString()).toString().computeValue((String) var45);
            var45 = SFMServiceComponent.resolveFontRenderHelper().computeValue(var43.getString2());
            if (var39) {
            } else {
            }
            var46 = (this.computeValue() - ((1.0F - var43.getEasingServiceComponent().getNumericValue()) * 10));
            CheckRenderHelper.executeAction(this, context.method_51448(), (this.computeValue2() + var40), (iterator + 6.0F), 13.0F, var43.getEasingServiceComponent().getNumericValue());
            CheckRenderHelper.executeAction(this, context.method_51448(), (var46 + ((iterator + 7.0F) * var43.getEasingServiceComponent().getNumericValue())), (this.computeValue2() + var40), (var45 + 8.0F), 13.0F, var43.getEasingServiceComponent().getNumericValue());
            var47 = var40;
            var48 = (CharSequence) var43.getString3();
            if (!(var48.length())) {
                Object var51 = context;
                var50 = this;
                var49 = 0;
                String var52 = StringsKt.trim((CharSequence) var43.getString()).toString();
            } else {
            }
            var51.render((String) var48, (var46 + 3.0F), ((this.computeValue2() + var47) + 1.0F), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor7(), var43.getEasingServiceComponent().getNumericValue()));
            this.render(context, var43.getString2(), (var46 + ((iterator + 11.0F) * var43.getEasingServiceComponent().getNumericValue())), ((this.computeValue2() + var47) + 1.0F), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor7(), var43.getEasingServiceComponent().getNumericValue()));
            var40 = (var40 + (14.0F * var43.getEasingServiceComponent().getNumericValue()));
        }
        this.executeAction((var40 - 2.0F));
    }

    private static boolean checkCondition(BindServiceComponent arg0) {
        if (arg0.isActive()) {
        } else {
        }
        0.0F.executeAction(1.0F);
        return arg0.getEasingServiceComponent().getNumericValue() <= 0.0F;
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return (Boolean) arg0.invoke(arg1);
    }

    static {
        INSTANCE = new KeybindsWidgetCheckRenderHelperImpl();
        itemList = new ArrayList();
        easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_BACK);
    }

}
