package su.catlean.client.services.render;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.minecraft.class_408;
import net.minecraft.client.gui.DrawContext;
import su.catlean.SharedKt;
import su.catlean.client.services.client.AnimationServiceComponent2;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.ProfileServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.network.EntryPacketHelper;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.types.TpYawSmootherMode;

public class StaffWidgetCheckRenderHelperImpl extends CheckRenderHelper {

    public static final StaffWidgetCheckRenderHelperImpl INSTANCE;
    private static final List itemList;
    private static final EasingServiceComponent easingServiceComponent;

    private StaffWidgetCheckRenderHelperImpl() {
        super("staff-widget");
    }

    public void render(DrawContext context) {
        long var4 = (0L ^ 73719739740194L);
        long var6 = (0L ^ 70082237648869L);
        long var8 = (0L ^ 50910300018319L);
        long var10 = (0L ^ 81581919584095L);
        long var12 = ((0L ^ 99541060701969L) >>> 48);
        long var13 = (((0L ^ 99541060701969L) << 16) >>> 32);
        long var14 = (((0L ^ 99541060701969L) << 48) >>> 48);
        long var15 = (0L ^ 100479272291701L);
        long var17 = (0L ^ 130512158954640L);
        long var19 = ((0L ^ 104104530525409L) >>> 48);
        long var20 = (((0L ^ 104104530525409L) << 16) >>> 32);
        long var21 = (((0L ^ 104104530525409L) << 48) >>> 48);
        long var22 = (0L ^ 128377113661390L);
        long var24 = (0L ^ 20173347401993L);
        long var26 = (0L ^ 99949442920536L);
        long var28 = (0L ^ 30591967126976L);
        long var30 = (0L ^ 14190504267447L);
        Iterator iterator = EntryPacketHelper.INSTANCE.getList().iterator();
        while (iterator.hasNext()) {
            ProfileServiceComponent var34 = (ProfileServiceComponent) iterator.next();
            Iterable var36 = (Iterable) itemList;
            int var37 = 0;
            if (0L > 0L) {
                if (var32) {
                }
                if (var36 instanceof Collection && (Collection) var36.isEmpty()) {
                } else {
                    Iterator iterator2 = var36.iterator();
                    if (iterator2.hasNext()) {
                        Object var39 = iterator2.next();
                        AnimationServiceComponent2 var40 = (AnimationServiceComponent2) var39;
                        int var41 = 0;
                    } else {
                    }
                }
                int var35 = 1;
                itemList.add(new AnimationServiceComponent2(var34.resolveString3()));
            }
        }
        iterator = (Iterable) itemList;
        var34 = 0;
        var35 = iterator.iterator();
        while (var35.hasNext()) {
            var36 = var35.next();
            var37 = (AnimationServiceComponent2) var36;
            iterator2 = 0;
            var39 = (Iterable) EntryPacketHelper.INSTANCE.getList();
            var40 = 0;
            if (0L <= 0L || 0L >= 0L) {
                continue;
            }
        }
        iterator = "Staff";
        var34 = this.computeValue() > (this.computeValue2() / 2.0F);
        if (0L > 0L) {
            if (var32) {
            }
            if (0L >= 0L) {
            }
        }
        if (itemList.isEmpty() && !(SharedKt.getMc().currentScreen instanceof class_408) && !(SharedKt.getMc().currentScreen instanceof CatleanWidgetEditorRenderHelper)) {
        } else {
        }
        0.0F.executeAction(1.0F);
        this.render(context, iterator, easingServiceComponent.getNumericValue());
        var35 = 17.0F;
        var36 = (SFMServiceComponent.resolveFontRenderHelper().computeValue(iterator) + 24.0F);
        var37 = itemList.iterator();
        while (var37.hasNext()) {
            iterator2 = (AnimationServiceComponent2) var37.next();
            var39 = SFMServiceComponent.resolveFontRenderHelper().computeValue(StringsKt.trim((CharSequence) iterator2.getString()).toString());
            if (0L > 0L) {
            }
            var36 = (var39 + 7.0F);
        }
        var37 = itemList.iterator();
        while (var37.hasNext()) {
            iterator2 = (AnimationServiceComponent2) var37.next();
            var39 = SFMServiceComponent.resolveFontRenderHelper().computeValue(StringsKt.trim((CharSequence) iterator2.getString()).toString());
            if (0L >= 0L) {
            }
            if (var34) {
            } else {
            }
            var40 = (this.computeValue() - ((1.0F - iterator2.getEasingServiceComponent().getNumericValue()) * 10));
            CheckRenderHelper.executeAction(this, context.method_51448(), (this.computeValue2() + var35), (var39 + 7.0F), 13.0F, iterator2.getEasingServiceComponent().getNumericValue());
            var41 = var35;
            this.render(context, StringsKt.trim((CharSequence) iterator2.getString()).toString(), (var40 + 3.0F), ((this.computeValue2() + var41) + 1.0F), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor7(), iterator2.getEasingServiceComponent().getNumericValue()));
            var35 = (var35 + (14.0F * iterator2.getEasingServiceComponent().getNumericValue()));
        }
        this.executeAction((13.0F + var35));
    }

    private static boolean checkCondition(AnimationServiceComponent2 arg0) {
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
        INSTANCE = new StaffWidgetCheckRenderHelperImpl();
        itemList = new ArrayList();
        easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_BACK);
    }

}
