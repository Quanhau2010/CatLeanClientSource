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
        Object[] items = new Object[34];
        items[0] = receiver;
        items[1] = ProxyGuiElement.INSTANCE;
        items[2] = EnabledServiceComponent.INSTANCE;
        items[3] = LogoServiceComponent.INSTANCE;
        items[4] = ExplosionPosEntityHelper.INSTANCE;
        items[5] = POSITIONCOLORRenderHelper.INSTANCE;
        items[6] = EntryPacketHelper.INSTANCE;
        items[7] = TheNetherPacketHelper.INSTANCE;
        items[8] = SequenceServiceComponent.INSTANCE;
        items[9] = ItemPacketHelper.INSTANCE;
        items[10] = WHITEServiceComponent.INSTANCE;
        items[11] = ServiceComponent98.INSTANCE;
        items[12] = TitleRenderHelper.INSTANCE;
        items[13] = EventPacketHelper2.INSTANCE;
        items[14] = EntityPacketHelper.INSTANCE;
        items[15] = POSITIONTEXCOLORShaderComponent.INSTANCE;
        items[16] = MacroServiceComponent.INSTANCE;
        items[17] = LocalhostServiceComponent.INSTANCE;
        items[18] = ProxyServiceComponent.INSTANCE;
        items[19] = RunnableServiceComponent.INSTANCE;
        items[20] = MainServiceComponent.INSTANCE;
        items[21] = ServiceComponent45.INSTANCE;
        items[22] = VecPacketHelper.INSTANCE;
        items[23] = EventServiceComponent.INSTANCE;
        items[24] = StackShaderComponent3.INSTANCE;
        items[25] = StartupServiceComponent.INSTANCE;
        items[26] = ContentTypeServiceComponent.INSTANCE;
        items[27] = PlayerEntityHelper2.INSTANCE;
        items[28] = RunnableServiceComponent2.INSTANCE;
        items[29] = ServiceComponent102.INSTANCE;
        items[30] = PolygonShaderComponent.INSTANCE;
        items[31] = TextShaderComponent2.INSTANCE;
        items[32] = VertexUBOShaderComponent.INSTANCE;
        items[33] = KeyServiceComponent.INSTANCE;
        Gofra.INSTANCE.plugAll(items);
    }

}
