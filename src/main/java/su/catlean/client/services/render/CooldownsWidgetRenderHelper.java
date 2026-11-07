package su.catlean.client.services.render;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import net.minecraft.class_1796;
import net.minecraft.class_2960;
import net.minecraft.class_408;
import net.minecraft.class_7922;
import net.minecraft.class_7923;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.Item;
import org.joml.Matrix3x2fStack;
import su.catlean.SharedKt;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.InstanceServiceComponent;
import su.catlean.client.services.client.KeyServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.types.TpYawSmootherMode;
import su.catlean.mixins.accessors.CooldownInstanceAccessor;
import su.catlean.mixins.accessors.ItemCooldownsAccessor;

public class CooldownsWidgetRenderHelper extends CheckRenderHelper {

    public static final CooldownsWidgetRenderHelper INSTANCE;
    private static final List itemList;
    private static final EasingServiceComponent easingServiceComponent;

    private CooldownsWidgetRenderHelper() {
        super("cooldowns-widget");
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
        long var16 = (0L ^ 109580710346244L);
        long var18 = (0L ^ 100479272291701L);
        long var20 = (0L ^ 130512158954640L);
        long var22 = ((0L ^ 104104530525409L) >>> 48);
        long var23 = (((0L ^ 104104530525409L) << 16) >>> 32);
        long var24 = (((0L ^ 104104530525409L) << 48) >>> 48);
        long var25 = (0L ^ 112434023090035L);
        long var27 = (0L ^ 128377113661390L);
        long var29 = (0L ^ 122988646685770L);
        long var31 = (0L ^ 20173347401993L);
        long var33 = (0L ^ 99949442920536L);
        long var35 = (0L ^ 30591967126976L);
        Iterator iterator = (ItemCooldownsAccessor) SharedKt.getPlayer().method_7357().getCooldowns().entrySet().iterator();
        while (iterator.hasNext()) {
            Entry var41 = (Entry) iterator.next();
            Item var42 = (Item) class_7923.field_41178.method_63535((class_2960) var41.getKey());
            Iterable var43 = (Iterable) itemList;
            int var44 = 0;
            if (0L >= 0L) {
                if (0L > 0L && var39) {
                }
                if (var43 instanceof Collection) {
                    if (var39 && var39) {
                        if ((Collection) var43.isEmpty()) {
                        }
                    }
                }
                Iterator iterator2 = var43.iterator();
                if (iterator2.hasNext()) {
                    Object var46 = iterator2.next();
                    InstanceServiceComponent var47 = (InstanceServiceComponent) var46;
                    int var48 = 0;
                } else {
                }
                itemList.add(new InstanceServiceComponent((CooldownInstanceAccessor) var41.getValue().getEndTime()));
                iterator = 0;
                iterator.printStackTrace();
            }
        }
        iterator = (Iterable) itemList;
        var41 = 0;
        var42 = iterator.iterator();
        if (var42.hasNext()) {
            var43 = var42.next();
            var44 = (InstanceServiceComponent) var43;
            iterator2 = 0;
            if (0L > 0L) {
                if (var39) {
                    if (0L > 0L) {
                        if (var39) {
                            if (!(SharedKt.getPlayer().method_7357().method_7904(var44.getMinecraftObject().method_7854()))) {
                                var44.updateValue(1);
                            }
                        }
                    }
                }
            }
            itemList.removeIf(this::checkCondition);
        }
        iterator = "Cooldowns";
        if (var39) {
            if (this.computeValue() > (this.computeValue2() / 2.0F)) {
            }
        } else {
        }
        var41 = 0;
        if (0L >= 0L) {
            if (var39) {
            }
            if (0L > 0L) {
            }
            if (var39) {
            }
        }
        if (itemList.isEmpty() && !(SharedKt.getMc().currentScreen instanceof class_408) && !(SharedKt.getMc().currentScreen instanceof CatleanWidgetEditorRenderHelper)) {
        }
        0.0F.executeAction(1.0F);
        this.render(context, iterator, easingServiceComponent.getNumericValue());
        var42 = 17.0F;
        var43 = (SFMServiceComponent.resolveFontRenderHelper().computeValue(iterator) + 24.0F);
        var44 = itemList.iterator();
        if (var44.hasNext()) {
            iterator2 = (InstanceServiceComponent) var44.next();
            var46 = this.resolveString((iterator2.getNumericValue() - (ItemCooldownsAccessor) SharedKt.getPlayer().method_7357().getTickCount()));
            Object[] var37 = new Object[0];
            String var38 = iterator2.getMinecraftObject().method_7876();
            var47 = KeyServiceComponent.INSTANCE.resolveString();
            var48 = SFMServiceComponent.resolveFontRenderHelper().computeValue();
            float var49 = SFMServiceComponent.resolveFontRenderHelper().computeValue();
            if (0L >= 0L) {
                if (var39) {
                    if (var39) {
                    }
                }
                var43 = ((var48 + var49) + 27.0F);
            }
            var44 = itemList.iterator();
        }
        if (var44.hasNext()) {
            iterator2 = (InstanceServiceComponent) var44.next();
            var46 = this.resolveString((iterator2.getNumericValue() - (ItemCooldownsAccessor) SharedKt.getPlayer().method_7357().getTickCount()));
            var37 = new Object[0];
            var38 = iterator2.getMinecraftObject().method_7876();
            var47 = KeyServiceComponent.INSTANCE.resolveString();
            var48 = SFMServiceComponent.resolveFontRenderHelper().computeValue();
            var49 = SFMServiceComponent.resolveFontRenderHelper().computeValue();
            if (0L > 0L) {
            }
            if (var41) {
            }
            float var50 = (this.computeValue() - ((1.0F - iterator2.getEasingServiceComponent().getNumericValue()) * 10));
            CheckRenderHelper.executeAction(this, context.method_51448(), (this.computeValue2() + var42), 13.0F, 13.0F, iterator2.getEasingServiceComponent().getNumericValue());
            CheckRenderHelper.executeAction(this, context.method_51448(), (var50 + 14.0F), (this.computeValue2() + var42), (var48 + 6.0F), 13.0F, iterator2.getEasingServiceComponent().getNumericValue());
            CheckRenderHelper.executeAction(this, context.method_51448(), (var50 + ((var48 + 21.0F) * iterator2.getEasingServiceComponent().getNumericValue())), (this.computeValue2() + var42), (var49 + 6.0F), 13.0F, iterator2.getEasingServiceComponent().getNumericValue());
            this.render(context, (var50 + 17.0F), ((this.computeValue2() + var42) + 1.0F), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor7(), iterator2.getEasingServiceComponent().getNumericValue()));
            this.render(context, (var50 + ((var48 + 24.0F) * iterator2.getEasingServiceComponent().getNumericValue())), ((this.computeValue2() + var42) + 1.0F), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor7(), iterator2.getEasingServiceComponent().getNumericValue()));
            context.method_51448().pushMatrix();
            context.method_51448().translate((var50 + 2), ((this.computeValue2() + var42) + 2));
            context.method_51448().scale(0.55F);
            if (0L >= 0L) {
                if (var39) {
                    if (iterator2.getEasingServiceComponent().getNumericValue() > 0.8F) {
                        context.method_51427(iterator2.getMinecraftObject().method_7854(), 0, 0);
                    }
                    context.method_51448().popMatrix();
                }
            }
            var42 = (var42 + (14.0F * iterator2.getEasingServiceComponent().getNumericValue()));
        }
        this.executeAction((var42 - 2.0F));
    }

    public String resolveString(int ticks) {
        String var4 = "%02d";
        Object[] var5 = new Object[1];
        var5[0] = Integer.valueOf(((ticks % 1200) / 20));
        return ((ticks / 1200) + String.format(Arrays.copyOf()));
    }

    private static boolean checkCondition(InstanceServiceComponent arg0) {
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
        INSTANCE = new CooldownsWidgetRenderHelper();
        itemList = new ArrayList();
        easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_BACK);
    }

}
