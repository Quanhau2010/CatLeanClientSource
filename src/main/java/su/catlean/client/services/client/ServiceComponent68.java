package su.catlean.client.services.client;

import su.catlean.api.IPasteable;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.network.EntityPacketHelper;
import su.catlean.client.services.network.EntryPacketHelper;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.network.TheNetherPacketHelper;
import su.catlean.client.services.network.VecPacketHelper;
import su.catlean.client.services.player.ExplosionPosEntityHelper;
import su.catlean.client.services.player.PlayerEntityHelper2;
import su.catlean.client.services.render.POSITIONCOLORRenderHelper;
import su.catlean.client.services.render.TitleRenderHelper;
import su.catlean.client.services.render.shader.POSITIONTEXCOLORShaderComponent;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent3;
import su.catlean.client.services.render.shader.TextShaderComponent2;
import su.catlean.client.services.render.shader.VertexUBOShaderComponent;
import su.catlean.client.ui.clickgui.ProxyGuiElement;
import su.catlean.gofra.Gofra;

public class ServiceComponent68 {

    public static void executeAction(IPasteable receiver) {
        Object[] var4 = new Object[34];
        var4[0] = receiver;
        var4[1] = ProxyGuiElement.INSTANCE;
        var4[2] = EnabledServiceComponent.INSTANCE;
        var4[3] = LogoServiceComponent.INSTANCE;
        var4[4] = ExplosionPosEntityHelper.INSTANCE;
        var4[5] = POSITIONCOLORRenderHelper.INSTANCE;
        var4[6] = EntryPacketHelper.INSTANCE;
        var4[7] = TheNetherPacketHelper.INSTANCE;
        var4[8] = SequenceServiceComponent.INSTANCE;
        var4[9] = ItemPacketHelper.INSTANCE;
        var4[10] = WHITEServiceComponent.INSTANCE;
        var4[11] = ServiceComponent98.INSTANCE;
        var4[12] = TitleRenderHelper.INSTANCE;
        var4[13] = EventPacketHelper2.INSTANCE;
        var4[14] = EntityPacketHelper.INSTANCE;
        var4[15] = POSITIONTEXCOLORShaderComponent.INSTANCE;
        var4[16] = MacroServiceComponent.INSTANCE;
        var4[17] = LocalhostServiceComponent.INSTANCE;
        var4[18] = ProxyServiceComponent.INSTANCE;
        var4[19] = RunnableServiceComponent.INSTANCE;
        var4[20] = MainServiceComponent.INSTANCE;
        var4[21] = ServiceComponent45.INSTANCE;
        var4[22] = VecPacketHelper.INSTANCE;
        var4[23] = EventServiceComponent.INSTANCE;
        var4[24] = StackShaderComponent3.INSTANCE;
        var4[25] = StartupServiceComponent.INSTANCE;
        var4[26] = ContentTypeServiceComponent.INSTANCE;
        var4[27] = PlayerEntityHelper2.INSTANCE;
        var4[28] = RunnableServiceComponent2.INSTANCE;
        var4[29] = ServiceComponent102.INSTANCE;
        var4[30] = PolygonShaderComponent.INSTANCE;
        var4[31] = TextShaderComponent2.INSTANCE;
        var4[32] = VertexUBOShaderComponent.INSTANCE;
        var4[33] = KeyServiceComponent.INSTANCE;
        Gofra.INSTANCE.plugAll();
    }

}
