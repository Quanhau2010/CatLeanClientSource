package su.catlean.client.services.client;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_2960;
import net.minecraft.class_315;
import net.minecraft.class_5321;
import net.minecraft.class_7172;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix3x2f;
import su.catlean.SharedKt;
import su.catlean.api.event.events.render.Render2DEvent;
import su.catlean.client.services.client.config.models.IdRecord7;
import su.catlean.client.services.client.config.models.WayPointsRecord;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.player.EntityHelper;
import su.catlean.client.services.render.FontRenderHelper;
import su.catlean.client.services.render.MissingnoRenderHelper;
import su.catlean.client.services.render.NewThemeRenderHelper;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.ui.clickgui.ProxyGuiElement;

public class LocalhostServiceComponent {

    public static final LocalhostServiceComponent INSTANCE;
    private static final MissingnoRenderHelper missingnoRenderHelper;

    private LocalhostServiceComponent() {
    }

    public List resolveList() {
        return ProxyGuiElement.INSTANCE.getJsonServiceComponent().resolveWayPointsRecord().getList();
    }

    private void onRender2DEvent(Render2DEvent arg0) {
        Iterable iterable = ((Iterable) this.resolveList());
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            IdRecord7 idRecord7 = ((IdRecord7) element);
            if (INSTANCE.checkCondition(idRecord7)) {
                Vec3d vec = new Vec3d(idRecord7.getNumericValue(), idRecord7.getNumericValue2(), idRecord7.getNumericValue3());
                if (EventPacketHelper2.INSTANCE.checkCondition(vec, ((Number) SharedKt.getMc().options.method_41808().method_41753()))) {
                    Vec3d vec2 = PolygonShaderComponent.INSTANCE.resolveMinecraftObject(vec);
                    SFMServiceComponent.resolveFontRenderHelper6().render(arg0.getContext(), (idRecord7.getString() + " (" + EntityHelper.resolveMinecraftObject(SharedKt.getPlayer()).method_1022(vec) + "m)"), vec2.field_1352, vec2.field_1351, NewThemeRenderHelper.INSTANCE.getColor7());
                    MissingnoRenderHelper.executeAction(missingnoRenderHelper, ((Matrix3x2f) arg0.getContext().method_51448()), (vec2.field_1352 - 10.0D), (vec2.field_1351 - 25.0D), 0.0F, 0.0F, null, null, 0.0F);
                }
            }
        }
    }

    private boolean checkCondition(IdRecord7 arg0) {
        if (!(Intrinsics.areEqual(arg0.getString2(), "localhost"))) {
            if (SharedKt.getMc().method_1562() != null) {
                if (SharedKt.getMc().method_1562().method_45734() != null) {
                } else {
                }
            } else {
            }
        }
        return arg0.getNumericValue4() == this.computeValue(SharedKt.getWorld().method_27983().method_29177().method_12832());
    }

    public boolean checkCondition(IdRecord7 wayPoint) {
        return this.resolveList().remove(wayPoint);
    }

    public boolean checkCondition(IdRecord7 wayPoint) {
        return this.resolveList().add(wayPoint);
    }

    public int computeValue(String i) {
        if (Intrinsics.areEqual(i, "overworld")) {
        } else {
        }
        return Intrinsics.areEqual(i, "the_nether");
    }

    static {
        INSTANCE = new LocalhostServiceComponent();
        missingnoRenderHelper = new MissingnoRenderHelper("point", 20, 20);
    }

}
