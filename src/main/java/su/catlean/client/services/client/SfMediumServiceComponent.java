package su.catlean.client.services.client;

import su.catlean.api.IPasteable;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.render.shader.POSITIONCOLORShaderComponent;
import su.catlean.gofra.Gofra;

public class SfMediumServiceComponent {

    private static Module[] moduleArray;

    public static void executeAction(IPasteable receiver) {
        SFMServiceComponent.executeAction(SFMServiceComponent.resolveFontRenderHelper(7.5F, "sf_medium"));
        SFMServiceComponent.executeAction2(SFMServiceComponent.resolveFontRenderHelper(8.0F, "sf_medium"));
        SFMServiceComponent.executeAction(SFMServiceComponent.resolveFontRenderHelper(9.5F, "sf_medium"));
        SFMServiceComponent.executeAction3(SFMServiceComponent.resolveFontRenderHelper(6.5F, "sf_medium"));
        SFMServiceComponent.executeAction(SFMServiceComponent.resolveFontRenderHelper(12.0F, "sf_bold"));
        SFMServiceComponent.executeAction4(SFMServiceComponent.resolveFontRenderHelper(8.0F, "sf_bold"));
        SFMServiceComponent.executeAction2(SFMServiceComponent.resolveFontRenderHelper(20.0F, "sf_bold"));
        SFMServiceComponent.executeAction3(SFMServiceComponent.resolveFontRenderHelper(25.0F, "sf_bold"));
        SFMServiceComponent.executeAction4(SFMServiceComponent.resolveFontRenderHelper(12.0F, "sf_semibold"));
        SFMServiceComponent.executeAction5(SFMServiceComponent.resolveFontRenderHelper(7.5F, "sf_regular"));
        Gofra.INSTANCE.plug(POSITIONCOLORShaderComponent.INSTANCE);
    }

    public static void updateValue(Module[] arg0) {
        moduleArray = arg0;
    }

    public static Module[] process() {
        return moduleArray;
    }

}
