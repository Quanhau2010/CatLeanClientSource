package su.catlean.client.services.render;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_10799;
import net.minecraft.class_1291;
import net.minecraft.class_1293;
import net.minecraft.class_329;
import net.minecraft.class_4081;
import net.minecraft.class_6880;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayerEntity;
import org.joml.Matrix3x2fStack;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.render.esp.NameTagsModule;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.InstanceServiceComponent2;
import su.catlean.client.services.client.KeyServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.types.TpYawSmootherMode;

public class PotionsWidgetCheckRenderHelperImpl extends CheckRenderHelper {

    public static final PotionsWidgetCheckRenderHelperImpl INSTANCE;
    private static final List itemList;
    private static final EasingServiceComponent easingServiceComponent;

    private PotionsWidgetCheckRenderHelperImpl() {
        super("potions-widget");
    }

    public void render(DrawContext context) {
        long var4 = (0L ^ 73719739740194L);
        long var6 = (0L ^ 50910300018319L);
        long var8 = (0L ^ 81581919584095L);
        long var10 = ((0L ^ 72787674350557L) >>> 32);
        long var11 = (((0L ^ 72787674350557L) << 32) >>> 48);
        long var12 = (((0L ^ 72787674350557L) << 48) >>> 48);
        long var13 = ((0L ^ 99541060701969L) >>> 48);
        long var14 = (((0L ^ 99541060701969L) << 16) >>> 32);
        long var15 = (((0L ^ 99541060701969L) << 48) >>> 48);
        long var16 = ((0L ^ 39056381264851L) >>> 8);
        long var18 = (((0L ^ 39056381264851L) << 56) >>> 56);
        long var19 = (0L ^ 109580710346244L);
        long var21 = (0L ^ 100479272291701L);
        long var23 = (0L ^ 130512158954640L);
        long var25 = ((0L ^ 104104530525409L) >>> 48);
        long var26 = (((0L ^ 104104530525409L) << 16) >>> 32);
        long var27 = (((0L ^ 104104530525409L) << 48) >>> 48);
        long var28 = ((0L ^ 87674672431915L) >>> 32);
        long var29 = (((0L ^ 87674672431915L) << 32) >>> 56);
        long var30 = (((0L ^ 87674672431915L) << 40) >>> 40);
        long var31 = (0L ^ 128377113661390L);
        long var33 = (0L ^ 20173347401993L);
        long var35 = (0L ^ 99949442920536L);
        long var37 = (0L ^ 30591967126976L);
        Iterator iterator = SharedKt.getPlayer().method_6026().iterator();
        while (iterator.hasNext()) {
            class_1293 var43 = (class_1293) iterator.next();
            Iterable var44 = (Iterable) itemList;
            int var45 = 0;
            if (0L > 0L) {
                if (var41) {
                }
                if (var44 instanceof Collection && (Collection) var44.isEmpty()) {
                } else {
                    Iterator iterator2 = var44.iterator();
                    if (iterator2.hasNext()) {
                        Object var47 = iterator2.next();
                        InstanceServiceComponent2 var48 = (InstanceServiceComponent2) var47;
                        int var49 = 0;
                    } else {
                    }
                }
                itemList.add(new InstanceServiceComponent2());
            }
        }
        iterator = (Iterable) itemList;
        var43 = 0;
        var44 = iterator.iterator();
        while (var44.hasNext()) {
            var45 = var44.next();
            iterator2 = (InstanceServiceComponent2) var45;
            var47 = 0;
            var48 = (Iterable) SharedKt.getPlayer().method_6026();
            var49 = 0;
            if (0L >= 0L) {
                if (var48 instanceof Collection && (Collection) var48.isEmpty()) {
                } else {
                    Iterator iterator3 = var48.iterator();
                    if (iterator3.hasNext()) {
                        class_1293 var52 = (class_1293) var51;
                        int var53 = 0;
                    } else {
                    }
                }
                if (1) {
                    iterator2.updateValue(1);
                }
            }
            itemList.removeIf(this::checkCondition);
        }
        iterator = "Potions";
        var43 = this.computeValue() > (this.computeValue2() / 2.0F);
        if (0L < 0L || 0L >= 0L) {
            continue;
        }
        if (!(var41) && !(SharedKt.getMc().currentScreen instanceof CatleanWidgetEditorRenderHelper)) {
        } else {
        }
        0.0F.executeAction(1.0F);
        this.render(context, iterator, easingServiceComponent.getNumericValue());
        var44 = 17.0F;
        var45 = (SFMServiceComponent.resolveFontRenderHelper().computeValue(iterator) + 24.0F);
        iterator2 = itemList.iterator();
        if (iterator2.hasNext()) {
            var47 = (InstanceServiceComponent2) iterator2.next();
            Object[] var39 = new Object[0];
            String var40 = var47.getMinecraftObject().method_5586();
            if (0L > 0L && var41) {
                if (var47.getMinecraftObject().method_5578() > 0) {
                } else {
                }
                var48 = (((var47.getMinecraftObject().method_5578() + 1)) + "");
                var49 = SFMServiceComponent.resolveFontRenderHelper().computeValue();
                iterator3 = SFMServiceComponent.resolveFontRenderHelper().computeValue(NameTagsModule.INSTANCE.resolveString(var47.getMinecraftObject()));
                if (0L > 0L) {
                }
                var45 = ((var49 + iterator3) + 27.0F);
            }
            iterator2 = itemList.iterator();
            while (iterator2.hasNext()) {
                var47 = (InstanceServiceComponent2) iterator2.next();
                var39 = new Object[0];
                var40 = var47.getMinecraftObject().method_5586();
            }
            if (var47.getMinecraftObject().method_5578() > 0) {
            } else {
            }
            var48 = (((var47.getMinecraftObject().method_5578() + 1)) + "");
            var49 = SFMServiceComponent.resolveFontRenderHelper().computeValue();
            iterator3 = SFMServiceComponent.resolveFontRenderHelper().computeValue(NameTagsModule.INSTANCE.resolveString(var47.getMinecraftObject()));
            if (var43) {
            } else {
            }
            var52 = (this.computeValue() - ((1.0F - var47.getEasingServiceComponent().getNumericValue()) * 10));
            var53 = 1.0F;
            if (0L >= 0L) {
                if (var47.getMinecraftObject().method_48557(200)) {
                    var53 = (1.0F - (Math.sin(var47.getMinecraftObject().method_5584()) * 0.5F));
                }
                CheckRenderHelper.executeAction(this, context.method_51448(), (this.computeValue2() + var44), 13.0F, 13.0F, var47.getEasingServiceComponent().getNumericValue());
                CheckRenderHelper.executeAction(this, context.method_51448(), (var52 + 14.0F), (this.computeValue2() + var44), (var49 + 6.0F), 13.0F, var47.getEasingServiceComponent().getNumericValue());
                CheckRenderHelper.executeAction(this, context.method_51448(), (var52 + ((var49 + 21.0F) * var47.getEasingServiceComponent().getNumericValue())), (this.computeValue2() + var44), (iterator3 + 6.0F), 13.0F, var47.getEasingServiceComponent().getNumericValue());
            }
            Color var54 = NewThemeRenderHelper.INSTANCE.getColor7();
            context.render((var52 + 17.0F), ((this.computeValue2() + var44) + 1.0F), PolygonShaderComponent.INSTANCE, Color.RED.resolveColor((var47.getEasingServiceComponent().getNumericValue() * var53)));
            this.render(context, NameTagsModule.INSTANCE.resolveString(var47.getMinecraftObject()), (var52 + ((var49 + 24.0F) * var47.getEasingServiceComponent().getNumericValue())), ((this.computeValue2() + var44) + 1.0F), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor7(), (var47.getEasingServiceComponent().getNumericValue() * var53)));
            context.method_51448().pushMatrix();
            context.method_51448().translate((var52 + 2), ((this.computeValue2() + var44) + 2));
            context.method_51448().scale(0.55F);
            context.method_52707(class_10799.field_56883, class_329.method_71644(var47.getMinecraftObject().method_5579()), 0, 0, 18, 18, PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, (var47.getEasingServiceComponent().getNumericValue() * var53)).getRGB());
            context.method_51448().popMatrix();
            var44 = (var44 + (14.0F * var47.getEasingServiceComponent().getNumericValue()));
        }
        this.executeAction((var44 - 2.0F));
    }

    private static boolean checkCondition(InstanceServiceComponent2 arg0) {
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
        INSTANCE = new PotionsWidgetCheckRenderHelperImpl();
        itemList = new ArrayList();
        easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_BACK);
    }

}
