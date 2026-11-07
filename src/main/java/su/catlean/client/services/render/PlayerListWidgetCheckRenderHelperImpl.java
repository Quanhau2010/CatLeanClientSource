package su.catlean.client.services.render;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_12079.class_12081;
import net.minecraft.class_408;
import net.minecraft.class_8685;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import org.joml.Matrix3x2f;
import su.catlean.SharedKt;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.player.EntityEntityHelper2;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.types.TpYawSmootherMode;

public class PlayerListWidgetCheckRenderHelperImpl extends CheckRenderHelper {

    public static final PlayerListWidgetCheckRenderHelperImpl INSTANCE;
    private static final List itemList;
    private static final EasingServiceComponent easingServiceComponent;

    private PlayerListWidgetCheckRenderHelperImpl() {
        super("player-list-widget");
    }

    public List getList() {
        return itemList;
    }

    public void render(DrawContext context) {
        int index = 0;
        Collection collection = ((Collection) new ArrayList());
        int index2 = 0;
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            AbstractClientPlayerEntity player = ((AbstractClientPlayerEntity) element);
            collection.add(element);
        }
        Iterator iterator2 = collection.iterator();
        while (iterator2.hasNext()) {
            Iterable iterable = ((Iterable) itemList);
            collection = 0;
            if (iterable instanceof Collection && ((Collection) iterable).isEmpty()) {
            } else {
                index2 = iterable.iterator();
                while (index2.hasNext()) {
                    iterator = index2.next();
                    element = ((EntityEntityHelper2) iterator);
                    player = 0;
                }
            }
            index = 1;
            itemList.add(new EntityEntityHelper2(null, false));
        }
        iterator2 = ((Iterable) itemList);
        index = iterator2;
        iterable = ((Collection) new ArrayList());
        collection = 0;
        index2 = index.iterator();
        while (index2.hasNext()) {
            iterator = index2.next();
            element = ((EntityEntityHelper2) iterator);
            player = 0;
            iterable.add(iterator);
        }
        iterator2 = ((Iterable) iterable);
        index = iterator2.iterator();
        while (index.hasNext()) {
            iterable = index.next();
            collection = ((EntityEntityHelper2) iterable);
            index2 = 0;
            collection.updateValue(true);
        }
        itemList.removeIf(this::checkCondition);
        iterator2 = "Players";
        if (itemList.isEmpty() && !(SharedKt.getMc().currentScreen instanceof class_408) && !(SharedKt.getMc().currentScreen instanceof CatleanWidgetEditorRenderHelper)) {
        } else {
        }
        this.executeAction(1.0F);
        this.render(context, iterator2, easingServiceComponent.getNumericValue());
        index = 17.0F;
        iterable = (SFMServiceComponent.resolveFontRenderHelper().computeValue(iterator2) + 24.0F);
        collection = itemList.iterator();
        while (collection.hasNext()) {
            index2 = ((EntityEntityHelper2) collection.next());
            iterator = SFMServiceComponent.resolveFontRenderHelper().computeValue(index2.resolveString());
            iterable = (iterator + 13.0F);
        }
        collection = itemList.iterator();
        while (collection.hasNext()) {
            index2 = ((EntityEntityHelper2) collection.next());
            iterator = SFMServiceComponent.resolveFontRenderHelper().computeValue(index2.resolveString());
            element = (this.computeValue() - ((1.0F - index2.getEasingServiceComponent().getNumericValue()) * 10));
            CheckRenderHelper.executeAction(this, context.method_51448(), element, (this.computeValue2() + index), (iterator + 21.0F), 13.0F, index2.getEasingServiceComponent().getNumericValue(), false);
            player = index;
            this.render(context, index2.resolveString(), (element + 3.0F), ((this.computeValue2() + player) + 1.0F), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor7(), index2.getEasingServiceComponent().getNumericValue()));
            this.executeAction(context.method_51448(), ((element + iterator) + 6.0F), ((this.computeValue2() + 2.0F) + player), (index2.getEasingServiceComponent().getNumericValue() * 0.27F));
            index = (index + (14.0F * index2.getEasingServiceComponent().getNumericValue()));
        }
        this.executeAction(iterable, (index - 2.0F));
    }

    public void render(DrawContext context) {
        String text = "Players";
        boolean flag = this.computeValue() > (this.computeValue2() / 2.0F);
        float factor = 17.0F;
        float factor2 = (SFMServiceComponent.resolveFontRenderHelper().computeValue(text) + 24.0F);
        Iterator iterator = itemList.iterator();
        while (iterator.hasNext()) {
            EntityEntityHelper2 entityEntityHelper2 = ((EntityEntityHelper2) iterator.next());
            float factor3 = SFMServiceComponent.resolveFontRenderHelper().computeValue(entityEntityHelper2.resolveString());
            factor2 = (factor3 + 13.0F);
        }
        iterator = itemList.iterator();
        while (iterator.hasNext()) {
            entityEntityHelper2 = ((EntityEntityHelper2) iterator.next());
            factor3 = SFMServiceComponent.resolveFontRenderHelper().computeValue(entityEntityHelper2.resolveString());
            if (flag) {
            } else {
            }
            float factor4 = (this.computeValue() - ((1.0F - entityEntityHelper2.getEasingServiceComponent().getNumericValue()) * 10));
            PolygonShaderComponent.executeAction(((Matrix3x2f) context.method_51448()), ((AbstractClientPlayerEntity) entityEntityHelper2.getMinecraftObject()).method_52814().comp_1626().comp_3627(), ((factor4 + factor3) + 10.0F), ((this.computeValue2() + 2.5F) + factor), 8.0F, 8.0F, PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, entityEntityHelper2.getEasingServiceComponent().getNumericValue()), null, null, null, 0.125F, 0.125F, 0.25F, 0.25F, false);
            PolygonShaderComponent.executeAction(((Matrix3x2f) context.method_51448()), ((AbstractClientPlayerEntity) entityEntityHelper2.getMinecraftObject()).method_52814().comp_1626().comp_3627(), ((factor4 + factor3) + 9.0F), ((this.computeValue2() + 1.5F) + factor), 10.0F, 10.0F, PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, entityEntityHelper2.getEasingServiceComponent().getNumericValue()), null, null, null, 0.625F, 0.125F, 0.75F, 0.25F, false);
            factor = (factor + (14.0F * entityEntityHelper2.getEasingServiceComponent().getNumericValue()));
        }
    }

    private static boolean checkCondition(EntityEntityHelper2 arg0) {
        if (arg0.isActive()) {
        } else {
        }
        this.executeAction(1.0F);
        return arg0.getEasingServiceComponent().getNumericValue() <= 0.0F;
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return ((Boolean) arg0.invoke(arg1));
    }

    static {
        INSTANCE = new PlayerListWidgetCheckRenderHelperImpl();
        itemList = new ArrayList();
        easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_BACK);
    }

}
