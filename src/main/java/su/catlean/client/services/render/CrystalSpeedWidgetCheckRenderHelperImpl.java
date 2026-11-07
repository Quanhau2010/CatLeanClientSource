package su.catlean.client.services.render;

import java.util.concurrent.atomic.AtomicReference;
import net.minecraft.client.gui.DrawContext;
import su.catlean.client.features.modules.pvp.attack.AutoCrystalModule;
import su.catlean.client.services.client.DamageDataServiceComponent;
import su.catlean.client.services.client.ServiceComponent;
import su.catlean.client.services.client.ServiceComponent95;

public class CrystalSpeedWidgetCheckRenderHelperImpl extends CheckRenderHelper {

    public static final CrystalSpeedWidgetCheckRenderHelperImpl INSTANCE;

    private CrystalSpeedWidgetCheckRenderHelperImpl() {
        super("crystal-speed-widget");
    }

    public void render(DrawContext context) {
        long var4 = (0L ^ 116853176505585L);
        if (var6) {
            if ((DamageDataServiceComponent) AutoCrystalModule.INSTANCE.getAtomicReference().get() != null && (DamageDataServiceComponent) AutoCrystalModule.INSTANCE.getAtomicReference().get().getServiceComponent95() != null) {
            } else {
            }
        }
        if (0L >= 0L) {
            if ((DamageDataServiceComponent) AutoCrystalModule.INSTANCE.getAtomicReference().get() != null && (DamageDataServiceComponent) AutoCrystalModule.INSTANCE.getAtomicReference().get().getServiceComponent95() != null) {
            } else {
            }
        }
        float var7 = (((0.0F / 0.0F) * 4235680804396597258L) / 10.0F);
        long var8 = AutoCrystalModule.INSTANCE.getNumericValue2();
        long var10 = AutoCrystalModule.INSTANCE.getNumericValue();
        this.render(context, (ServiceComponent.INSTANCE.getNumericValue() + " c/s | " + var10 + " ping | " + var8 + " cpu | " + var7 + " ef."));
    }

    static {
        INSTANCE = new CrystalSpeedWidgetCheckRenderHelperImpl();
    }

}
