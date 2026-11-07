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
        if (__UNDEF_KEY__) {
            if (((DamageDataServiceComponent) AutoCrystalModule.INSTANCE.getAtomicReference().get()) != null && ((DamageDataServiceComponent) AutoCrystalModule.INSTANCE.getAtomicReference().get()).getServiceComponent95() != null) {
            } else {
            }
        }
        if (((DamageDataServiceComponent) AutoCrystalModule.INSTANCE.getAtomicReference().get()) != null && ((DamageDataServiceComponent) AutoCrystalModule.INSTANCE.getAtomicReference().get()).getServiceComponent95() != null) {
        } else {
        }
        float factor = (((0.0F / 0.0F) * 10) / 10.0F);
        long time = AutoCrystalModule.INSTANCE.getNumericValue2();
        long time2 = AutoCrystalModule.INSTANCE.getNumericValue();
        this.render(context, (ServiceComponent.INSTANCE.getNumericValue() + " c/s | " + time2 + " ping | " + time + " cpu | " + factor + " ef."));
    }

    static {
        INSTANCE = new CrystalSpeedWidgetCheckRenderHelperImpl();
    }

}
