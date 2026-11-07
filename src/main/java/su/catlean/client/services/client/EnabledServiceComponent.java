package su.catlean.client.services.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import org.slf4j.Logger;
import su.catlean.SharedKt;
import su.catlean.api.contracts.Contract9;
import su.catlean.api.event.events.client.InputEvent;
import su.catlean.api.event.events.client.InputEvent.Action;
import su.catlean.api.event.events.client.InputEvent.Device;
import su.catlean.api.setting.VisibleSettingProperty;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.movement.basic.AntiKnockBackModule;
import su.catlean.client.features.modules.movement.basic.AvoidModule;
import su.catlean.client.features.modules.movement.basic.ElytraRecastModule;
import su.catlean.client.features.modules.movement.basic.GuiMoveModule;
import su.catlean.client.features.modules.movement.basic.HoleAnchorModule;
import su.catlean.client.features.modules.movement.basic.InfiniteElytraModule;
import su.catlean.client.features.modules.movement.basic.LegitStrafeModule;
import su.catlean.client.features.modules.movement.basic.MoveFixModule;
import su.catlean.client.features.modules.movement.basic.NoPushModule;
import su.catlean.client.features.modules.movement.basic.SprintModule;
import su.catlean.client.features.modules.movement.basic.WindHopModule;
import su.catlean.client.features.modules.movement.rage.AntiVoidModule;
import su.catlean.client.features.modules.movement.rage.AntiWebModule;
import su.catlean.client.features.modules.movement.rage.BlinkModule;
import su.catlean.client.features.modules.movement.rage.BoatFlyModule;
import su.catlean.client.features.modules.movement.rage.ElytraFreezeModule;
import su.catlean.client.features.modules.movement.rage.ElytraPlusModule;
import su.catlean.client.features.modules.movement.rage.ElytraTargetModule;
import su.catlean.client.features.modules.movement.rage.EntitySpeedModule;
import su.catlean.client.features.modules.movement.rage.FlightModule;
import su.catlean.client.features.modules.movement.rage.HighJumpModule;
import su.catlean.client.features.modules.movement.rage.LevitationControlModule;
import su.catlean.client.features.modules.movement.rage.MaceElytraTargetModule;
import su.catlean.client.features.modules.movement.rage.NoFallModule;
import su.catlean.client.features.modules.movement.rage.NoSlowModule;
import su.catlean.client.features.modules.movement.rage.PhaseModule;
import su.catlean.client.features.modules.movement.rage.ReverseStepModule;
import su.catlean.client.features.modules.movement.rage.ScaffoldModule;
import su.catlean.client.features.modules.movement.rage.SpeedModule;
import su.catlean.client.features.modules.movement.rage.SpiderModule;
import su.catlean.client.features.modules.movement.rage.StepModule;
import su.catlean.client.features.modules.movement.rage.TimerModule;
import su.catlean.client.features.modules.movement.rage.TridentBoostModule;
import su.catlean.client.features.modules.movement.rage.WaterSpeedModule;
import su.catlean.client.features.modules.pvp.attack.AntiPhaseModule;
import su.catlean.client.features.modules.pvp.attack.AttributeSwapModule;
import su.catlean.client.features.modules.pvp.attack.AuraModule;
import su.catlean.client.features.modules.pvp.attack.AutoBasePlaceModule;
import su.catlean.client.features.modules.pvp.attack.AutoCrystalModule;
import su.catlean.client.features.modules.pvp.attack.AutoDripstopeModule;
import su.catlean.client.features.modules.pvp.attack.AutoMineModule;
import su.catlean.client.features.modules.pvp.attack.AutoNetheriteScrapModule;
import su.catlean.client.features.modules.pvp.attack.AutoSweetBerriesModule;
import su.catlean.client.features.modules.pvp.attack.AutoWebModule;
import su.catlean.client.features.modules.pvp.attack.CriticalsModule;
import su.catlean.client.features.modules.pvp.attack.HoleFillerModule;
import su.catlean.client.features.modules.pvp.attack.MaceKillerModule;
import su.catlean.client.features.modules.pvp.attack.MoreKnockbackModule;
import su.catlean.client.features.modules.pvp.attack.TrapModule;
import su.catlean.client.features.modules.pvp.legit.AnchorBindModule;
import su.catlean.client.features.modules.pvp.legit.AutoBuffModule;
import su.catlean.client.features.modules.pvp.legit.BowMinecartModule;
import su.catlean.client.features.modules.pvp.legit.BowSpamModule;
import su.catlean.client.features.modules.pvp.legit.CrystalBindModule;
import su.catlean.client.features.modules.pvp.legit.LegitTotemModule;
import su.catlean.client.features.modules.pvp.legit.ReachModule;
import su.catlean.client.features.modules.pvp.protect.AutoGappleModule;
import su.catlean.client.features.modules.pvp.protect.BlockerModule;
import su.catlean.client.features.modules.pvp.protect.BurrowModule;
import su.catlean.client.features.modules.pvp.protect.MainhandTotemModule;
import su.catlean.client.features.modules.pvp.protect.OffhandModule;
import su.catlean.client.features.modules.pvp.protect.QuiverModule;
import su.catlean.client.features.modules.pvp.protect.SelfTrapModule;
import su.catlean.client.features.modules.pvp.protect.SurroundModule;
import su.catlean.client.features.modules.render.cosmetic.AbsorptionModule;
import su.catlean.client.features.modules.render.cosmetic.AspectModule;
import su.catlean.client.features.modules.render.cosmetic.BuffEffectModule;
import su.catlean.client.features.modules.render.cosmetic.CrystalChamsModule;
import su.catlean.client.features.modules.render.cosmetic.DamageParticlesModule;
import su.catlean.client.features.modules.render.cosmetic.DamageTintModule;
import su.catlean.client.features.modules.render.cosmetic.DismembermentModule;
import su.catlean.client.features.modules.render.cosmetic.FreeLookModule;
import su.catlean.client.features.modules.render.cosmetic.FullBrightModule;
import su.catlean.client.features.modules.render.cosmetic.HandChamsModule;
import su.catlean.client.features.modules.render.cosmetic.HitFxModule;
import su.catlean.client.features.modules.render.cosmetic.NoCameraClipModule;
import su.catlean.client.features.modules.render.cosmetic.ParticlesModule;
import su.catlean.client.features.modules.render.cosmetic.PopChamsModule;
import su.catlean.client.features.modules.render.cosmetic.SkyLanternsModule;
import su.catlean.client.features.modules.render.cosmetic.SwingAnimationsModule;
import su.catlean.client.features.modules.render.cosmetic.ThrowPetardModule;
import su.catlean.client.features.modules.render.cosmetic.TotemAnimationModule;
import su.catlean.client.features.modules.render.cosmetic.TrajectoriesModule;
import su.catlean.client.features.modules.render.cosmetic.ViewModelModule;
import su.catlean.client.features.modules.render.cosmetic.WorldRendererModule;
import su.catlean.client.features.modules.render.esp.BreakEspModule;
import su.catlean.client.features.modules.render.esp.HoleEspModule;
import su.catlean.client.features.modules.render.esp.ItemEspModule;
import su.catlean.client.features.modules.render.esp.LogoutSpotsModule;
import su.catlean.client.features.modules.render.esp.NameTagsModule;
import su.catlean.client.features.modules.render.esp.PearlPhaseEspModule;
import su.catlean.client.features.modules.render.esp.PlayerEspModule;
import su.catlean.client.features.modules.render.esp.ProjectilePredictModule;
import su.catlean.client.features.modules.render.esp.SearchModule;
import su.catlean.client.features.modules.render.esp.StorageEspModule;
import su.catlean.client.features.modules.render.esp.TracersModule;
import su.catlean.client.features.modules.render.esp.VoidEspModule;
import su.catlean.client.features.modules.render.esp.XRayModule;
import su.catlean.client.features.modules.render.world.AutoBoneMealModule;
import su.catlean.client.features.modules.render.world.AutoLandModule;
import su.catlean.client.features.modules.render.world.AutoShearModule;
import su.catlean.client.features.modules.render.world.AutoSignModule;
import su.catlean.client.features.modules.render.world.AutoWitherModule;
import su.catlean.client.features.modules.render.world.FakePlayerModule;
import su.catlean.client.features.modules.render.world.FreeCamModule;
import su.catlean.client.features.modules.render.world.NoRenderModule;
import su.catlean.client.features.modules.render.world.NukerModule;
import su.catlean.client.features.modules.render.world.PearlChaserModule;
import su.catlean.client.features.modules.render.world.ServerHelperModule;
import su.catlean.client.features.modules.render.world.SoilRipperModule;
import su.catlean.client.features.modules.render.world.TpsSyncModule;
import su.catlean.client.features.modules.render.world.ZoomModule;
import su.catlean.client.features.modules.utility.equip.AutoArmorModule;
import su.catlean.client.features.modules.utility.equip.AutoToolModule;
import su.catlean.client.features.modules.utility.equip.ChestStealerModule;
import su.catlean.client.features.modules.utility.equip.EcExploitModule;
import su.catlean.client.features.modules.utility.equip.ElytraReplaceModule;
import su.catlean.client.features.modules.utility.equip.ElytraSwapModule;
import su.catlean.client.features.modules.utility.equip.InventoryManagerModule;
import su.catlean.client.features.modules.utility.equip.ItemScrollerModule;
import su.catlean.client.features.modules.utility.equip.MiddleClickModule;
import su.catlean.client.features.modules.utility.equip.NoServerSlotModule;
import su.catlean.client.features.modules.utility.equip.ReFillerModule;
import su.catlean.client.features.modules.utility.equip.ToolSaverModule;
import su.catlean.client.features.modules.utility.equip.XCarryModule;
import su.catlean.client.features.modules.utility.misc.AntiResourcePackModule;
import su.catlean.client.features.modules.utility.misc.AssistantModule;
import su.catlean.client.features.modules.utility.misc.AutoEatModule;
import su.catlean.client.features.modules.utility.misc.AutoEzModule;
import su.catlean.client.features.modules.utility.misc.AutoLeaveModule;
import su.catlean.client.features.modules.utility.misc.AutoPotionBrewModule;
import su.catlean.client.features.modules.utility.misc.AutoSoupModule;
import su.catlean.client.features.modules.utility.misc.AutoTraderModule;
import su.catlean.client.features.modules.utility.misc.ExtraTabModule;
import su.catlean.client.features.modules.utility.misc.FastLatencyModule;
import su.catlean.client.features.modules.utility.misc.MessageAppendModule;
import su.catlean.client.features.modules.utility.misc.NameProtectModule;
import su.catlean.client.features.modules.utility.misc.NotifierModule;
import su.catlean.client.features.modules.utility.misc.PingSpoofModule;
import su.catlean.client.features.modules.utility.misc.RPCModule;
import su.catlean.client.features.modules.utility.misc.SourceFillerModule;
import su.catlean.client.features.modules.utility.misc.SpammerModule;
import su.catlean.client.features.modules.utility.misc.TapeMouseModule;
import su.catlean.client.features.modules.utility.misc.TeamCommunicationModule;
import su.catlean.client.features.modules.utility.misc.TestModule;
import su.catlean.client.features.modules.utility.misc.TranslatorModule;
import su.catlean.client.features.modules.utility.misc.UIModule;
import su.catlean.client.features.modules.utility.player.ActionRecorderModule;
import su.catlean.client.features.modules.utility.player.AirPlaceModule;
import su.catlean.client.features.modules.utility.player.AntiAimModule;
import su.catlean.client.features.modules.utility.player.AntiAttackModule;
import su.catlean.client.features.modules.utility.player.AntiHungerModule;
import su.catlean.client.features.modules.utility.player.AutoAuthModule;
import su.catlean.client.features.modules.utility.player.AutoFishModule;
import su.catlean.client.features.modules.utility.player.AutoMendModule;
import su.catlean.client.features.modules.utility.player.AutoRespawnModule;
import su.catlean.client.features.modules.utility.player.AutoTpaAcceptModule;
import su.catlean.client.features.modules.utility.player.BoxShrinkerModule;
import su.catlean.client.features.modules.utility.player.ChorusDelayModule;
import su.catlean.client.features.modules.utility.player.MultiTaskModule;
import su.catlean.client.features.modules.utility.player.NoDelayModule;
import su.catlean.client.features.modules.utility.player.NoInteractModule;
import su.catlean.client.features.modules.utility.player.NoServerRotateModule;
import su.catlean.client.features.modules.utility.player.PerfectDelayModule;
import su.catlean.client.features.modules.utility.player.PortalGodModeModule;
import su.catlean.client.features.modules.utility.player.SpeedMineModule;
import su.catlean.client.features.modules.utility.player.TraceThroughModule;
import su.catlean.client.services.client.config.models.IdRecord10;
import su.catlean.client.services.client.config.models.IdRecord3;
import su.catlean.client.services.client.config.models.IdRecord5;
import su.catlean.client.services.client.config.models.KeyRecord;
import su.catlean.client.services.render.CatleanInterfaceRenderHelper;
import su.catlean.client.ui.clickgui.ProxyGuiElement;
import su.catlean.gofra.Gofra;

public class EnabledServiceComponent implements Contract9 {

    public static final EnabledServiceComponent INSTANCE;
    private static final ArrayList arrayList;
    private static ArrayList arrayList2;
    private static final ArrayList arrayList3;
    private static int countValue;

    private EnabledServiceComponent() {
    }

    public ArrayList getArrayList() {
        return arrayList;
    }

    public ArrayList getArrayList2() {
        return arrayList2;
    }

    public void executeAction(ArrayList value) {
        arrayList2 = value;
    }

    public ArrayList getArrayList3() {
        return arrayList3;
    }

    private boolean checkCondition() {
        Module[] var3 = new Module[167];
        var3[0] = ElytraTargetModule.INSTANCE;
        var3[1] = BowMinecartModule.INSTANCE;
        var3[2] = ElytraFreezeModule.INSTANCE;
        var3[3] = DismembermentModule.INSTANCE;
        var3[4] = ExtraTabModule.INSTANCE;
        var3[5] = ThrowPetardModule.INSTANCE;
        var3[6] = AntiAimModule.INSTANCE;
        var3[7] = VoidEspModule.INSTANCE;
        var3[8] = AspectModule.INSTANCE;
        var3[9] = TestModule.INSTANCE;
        var3[10] = NameProtectModule.INSTANCE;
        var3[11] = AnchorBindModule.INSTANCE;
        var3[12] = SpiderModule.INSTANCE;
        var3[13] = AssistantModule.INSTANCE;
        var3[14] = AutoBoneMealModule.INSTANCE;
        var3[15] = PearlPhaseEspModule.INSTANCE;
        var3[16] = AutoSweetBerriesModule.INSTANCE;
        var3[17] = MaceElytraTargetModule.INSTANCE;
        var3[18] = DamageParticlesModule.INSTANCE;
        var3[19] = InfiniteElytraModule.INSTANCE;
        var3[20] = MoreKnockbackModule.INSTANCE;
        var3[21] = EcExploitModule.INSTANCE;
        var3[22] = AntiAttackModule.INSTANCE;
        var3[23] = MainhandTotemModule.INSTANCE;
        var3[24] = ServerHelperModule.INSTANCE;
        var3[25] = BoatFlyModule.INSTANCE;
        var3[26] = ZoomModule.INSTANCE;
        var3[27] = WindHopModule.INSTANCE;
        var3[28] = LegitStrafeModule.INSTANCE;
        var3[29] = DamageTintModule.INSTANCE;
        var3[30] = FreeLookModule.INSTANCE;
        var3[31] = AutoNetheriteScrapModule.INSTANCE;
        var3[32] = FastLatencyModule.INSTANCE;
        var3[33] = PingSpoofModule.INSTANCE;
        var3[34] = AutoMendModule.INSTANCE;
        var3[35] = BlockerModule.INSTANCE;
        var3[36] = AutoShearModule.INSTANCE;
        var3[37] = SoilRipperModule.INSTANCE;
        var3[38] = SwingAnimationsModule.INSTANCE;
        var3[39] = ParticlesModule.INSTANCE;
        var3[40] = AutoTraderModule.INSTANCE;
        var3[41] = BuffEffectModule.INSTANCE;
        var3[42] = ActionRecorderModule.INSTANCE;
        var3[43] = AutoPotionBrewModule.INSTANCE;
        var3[44] = AutoLandModule.INSTANCE;
        var3[45] = AntiKnockBackModule.INSTANCE;
        var3[46] = ChestStealerModule.INSTANCE;
        var3[47] = NoCameraClipModule.INSTANCE;
        var3[48] = AvoidModule.INSTANCE;
        var3[49] = BreakEspModule.INSTANCE;
        var3[50] = XRayModule.INSTANCE;
        var3[51] = ElytraRecastModule.INSTANCE;
        var3[52] = AutoBasePlaceModule.INSTANCE;
        var3[53] = GuiMoveModule.INSTANCE;
        var3[54] = MoveFixModule.INSTANCE;
        var3[55] = NoPushModule.INSTANCE;
        var3[56] = SprintModule.INSTANCE;
        var3[57] = AttributeSwapModule.INSTANCE;
        var3[58] = AntiVoidModule.INSTANCE;
        var3[59] = AntiWebModule.INSTANCE;
        var3[60] = ElytraPlusModule.INSTANCE;
        var3[61] = FlightModule.INSTANCE;
        var3[62] = LevitationControlModule.INSTANCE;
        var3[63] = BlinkModule.INSTANCE;
        var3[64] = PopChamsModule.INSTANCE;
        var3[65] = NoFallModule.INSTANCE;
        var3[66] = NoSlowModule.INSTANCE;
        var3[67] = PhaseModule.INSTANCE;
        var3[68] = ReverseStepModule.INSTANCE;
        var3[69] = SpeedModule.INSTANCE;
        var3[70] = StepModule.INSTANCE;
        var3[71] = TimerModule.INSTANCE;
        var3[72] = WaterSpeedModule.INSTANCE;
        var3[73] = AuraModule.INSTANCE;
        var3[74] = AutoCrystalModule.INSTANCE;
        var3[75] = AbsorptionModule.INSTANCE;
        var3[76] = SourceFillerModule.INSTANCE;
        var3[77] = AutoWebModule.INSTANCE;
        var3[78] = MessageAppendModule.INSTANCE;
        var3[79] = CriticalsModule.INSTANCE;
        var3[80] = HoleFillerModule.INSTANCE;
        var3[81] = AutoBuffModule.INSTANCE;
        var3[82] = BowSpamModule.INSTANCE;
        var3[83] = ReachModule.INSTANCE;
        var3[84] = AutoWitherModule.INSTANCE;
        var3[85] = HighJumpModule.INSTANCE;
        var3[86] = SkyLanternsModule.INSTANCE;
        var3[87] = AntiPhaseModule.INSTANCE;
        var3[88] = AutoGappleModule.INSTANCE;
        var3[89] = BurrowModule.INSTANCE;
        var3[90] = LegitTotemModule.INSTANCE;
        var3[91] = OffhandModule.INSTANCE;
        var3[92] = SurroundModule.INSTANCE;
        var3[93] = AutoArmorModule.INSTANCE;
        var3[94] = AutoToolModule.INSTANCE;
        var3[95] = ElytraSwapModule.INSTANCE;
        var3[96] = InventoryManagerModule.INSTANCE;
        var3[97] = ItemScrollerModule.INSTANCE;
        var3[98] = MiddleClickModule.INSTANCE;
        var3[99] = AutoMineModule.INSTANCE;
        var3[100] = NoServerSlotModule.INSTANCE;
        var3[101] = ReFillerModule.INSTANCE;
        var3[102] = ToolSaverModule.INSTANCE;
        var3[103] = XCarryModule.INSTANCE;
        var3[104] = AntiResourcePackModule.INSTANCE;
        var3[105] = UIModule.INSTANCE;
        var3[106] = TrapModule.INSTANCE;
        var3[107] = SelfTrapModule.INSTANCE;
        var3[108] = TeamCommunicationModule.INSTANCE;
        var3[109] = NotifierModule.INSTANCE;
        var3[110] = RPCModule.INSTANCE;
        var3[111] = SpammerModule.INSTANCE;
        var3[112] = TapeMouseModule.INSTANCE;
        var3[113] = TranslatorModule.INSTANCE;
        var3[114] = AirPlaceModule.INSTANCE;
        var3[115] = ElytraReplaceModule.INSTANCE;
        var3[116] = AntiHungerModule.INSTANCE;
        var3[117] = AutoAuthModule.INSTANCE;
        var3[118] = AutoFishModule.INSTANCE;
        var3[119] = AutoRespawnModule.INSTANCE;
        var3[120] = AutoTpaAcceptModule.INSTANCE;
        var3[121] = ChorusDelayModule.INSTANCE;
        var3[122] = MultiTaskModule.INSTANCE;
        var3[123] = NoDelayModule.INSTANCE;
        var3[124] = TraceThroughModule.INSTANCE;
        var3[125] = NoServerRotateModule.INSTANCE;
        var3[126] = PerfectDelayModule.INSTANCE;
        var3[127] = PortalGodModeModule.INSTANCE;
        var3[128] = SpeedMineModule.INSTANCE;
        var3[129] = AutoSignModule.INSTANCE;
        var3[130] = FakePlayerModule.INSTANCE;
        var3[131] = FreeCamModule.INSTANCE;
        var3[132] = NoRenderModule.INSTANCE;
        var3[133] = NukerModule.INSTANCE;
        var3[134] = PearlChaserModule.INSTANCE;
        var3[135] = ScaffoldModule.INSTANCE;
        var3[136] = CrystalChamsModule.INSTANCE;
        var3[137] = FullBrightModule.INSTANCE;
        var3[138] = HandChamsModule.INSTANCE;
        var3[139] = HitFxModule.INSTANCE;
        var3[140] = TotemAnimationModule.INSTANCE;
        var3[141] = TrajectoriesModule.INSTANCE;
        var3[142] = ViewModelModule.INSTANCE;
        var3[143] = WorldRendererModule.INSTANCE;
        var3[144] = HoleAnchorModule.INSTANCE;
        var3[145] = CrystalBindModule.INSTANCE;
        var3[146] = SearchModule.INSTANCE;
        var3[147] = HoleEspModule.INSTANCE;
        var3[148] = EntitySpeedModule.INSTANCE;
        var3[149] = ItemEspModule.INSTANCE;
        var3[150] = LogoutSpotsModule.INSTANCE;
        var3[151] = AutoDripstopeModule.INSTANCE;
        var3[152] = TpsSyncModule.INSTANCE;
        var3[153] = BoxShrinkerModule.INSTANCE;
        var3[154] = AutoLeaveModule.INSTANCE;
        var3[155] = AutoSoupModule.INSTANCE;
        var3[156] = AutoEatModule.INSTANCE;
        var3[157] = NameTagsModule.INSTANCE;
        var3[158] = ProjectilePredictModule.INSTANCE;
        var3[159] = PlayerEspModule.INSTANCE;
        var3[160] = StorageEspModule.INSTANCE;
        var3[161] = TracersModule.INSTANCE;
        var3[162] = NoInteractModule.INSTANCE;
        var3[163] = AutoEzModule.INSTANCE;
        var3[164] = MaceKillerModule.INSTANCE;
        var3[165] = TridentBoostModule.INSTANCE;
        var3[166] = QuiverModule.INSTANCE;
        return arrayList2.addAll((Collection) CollectionsKt.listOf());
    }

    public void updateValue() {
        Iterable var7 = (Iterable) arrayList2;
        int var8 = 0;
        Iterator iterator = var7.iterator();
        while (iterator.hasNext()) {
            Object var10 = iterator.next();
            Module var11 = (Module) var10;
            int var12 = 0;
            Iterable var13 = (Iterable) var11.getList();
            int var14 = 0;
            Iterator iterator2 = var13.iterator();
            while (iterator2.hasNext()) {
                Object var16 = iterator2.next();
                VisibleSettingProperty var17 = (VisibleSettingProperty) var16;
                int var18 = 0;
                Iterable var19 = (Iterable) ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl2().resolveIdRecord3().getList();
                Iterator iterator3 = var19.iterator();
                if (iterator3.hasNext()) {
                    Object var21 = iterator3.next();
                    IdRecord5 var22 = (IdRecord5) var21;
                    int var23 = 0;
                } else {
                }
                if ((IdRecord5) null == null) {
                }
                Object var24 = var21;
                iterator3 = (Iterable) var24.getList();
                var21 = iterator3.iterator();
                if (var21.hasNext()) {
                    var22 = var21.next();
                    var23 = (IdRecord10) var22;
                    int var25 = 0;
                } else {
                }
                if ((IdRecord10) null == null) {
                }
                Object var26 = var22;
                var17.setValue(var26.getString2());
                var17.setValue();
                String var28 = var27.getMessage();
                String var29 = var11.getString2();
                String var30 = var17.getString2();
                SharedKt.getLogger().warn(("Could not parse setting: " + var30 + " in " + var29 + ": " + var28));
            }
        }
    }

    public void executeAction(IdRecord3 prevConfig) {
        Iterable var13 = (Iterable) arrayList2;
        int var14 = 0;
        Iterator iterator = var13.iterator();
        if (iterator.hasNext()) {
            Object var16 = iterator.next();
            Module var17 = (Module) var16;
            int var18 = 0;
            if (0L >= 0) {
                if (prevConfig != null) {
                }
                List positions = prevConfig.getList();
                if (0L >= 0) {
                    if (positions != null) {
                    }
                    Iterable var20 = (Iterable) positions;
                    int var21 = 0;
                    Iterator iterator2 = var20.iterator();
                    if (iterator2.hasNext()) {
                        Object var23 = iterator2.next();
                        IdRecord5 var24 = (IdRecord5) var23;
                        int var25 = 0;
                    } else {
                    }
                    IdRecord5 var26 = (IdRecord5) null;
                    if (0L >= 0) {
                        if (var26 != null) {
                        }
                        var20 = var26.getList();
                        if (0L >= 0) {
                            if (var20 != null) {
                            }
                            iterator2 = (Iterable) var20;
                            var23 = 0;
                            var24 = iterator2.iterator();
                            if (var24.hasNext()) {
                                var25 = var24.next();
                                IdRecord10 var27 = (IdRecord10) var25;
                                int var28 = 0;
                            } else {
                            }
                            var21 = (IdRecord10) null;
                            if (0L > 0) {
                                if (var21 != null) {
                                }
                                iterator2 = var21.getString2();
                                if (0L > 0) {
                                    if (iterator2 != null) {
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
            }
        }
        }
        }
        }
        }
        Gofra.INSTANCE.unplug();
        if (0L >= 0 && var17.getEnabled()) {
            Gofra.INSTANCE.plug();
            if (!(Intrinsics.areEqual(Boolean.valueOf(var17.getEnabled())))) {
                var17.updateValue();
            } else {
                if (prevConfig != null) {
                    if (0L >= 0 && 0L >= 0 && 0L > 0) {
                        if (!(Intrinsics.areEqual(Boolean.valueOf(var17.getEnabled())))) {
                            var17.updateValue2();
                        }
                    }
                }
            }
        }
        }
    }

    public static void executeAction(EnabledServiceComponent arg0, IdRecord3 arg1, int arg2, Object arg3) {
        if ((arg2 & 1)) {
        }
        arg0.executeAction(arg1);
    }

    public void executeAction(String moduleId, String id) {
        Iterable var6 = (Iterable) arrayList2;
        int var7 = 0;
        Object var8 = var6;
        Collection var9 = (Collection) new ArrayList();
        int var10 = 0;
        Iterator iterator = var8.iterator();
        while (iterator.hasNext()) {
            Object var12 = iterator.next();
            Module var13 = (Module) var12;
            int var14 = 0;
            var9.add();
        }
        var6 = (Iterable) var9;
        var7 = 0;
        var8 = var6.iterator();
        while (var8.hasNext()) {
            var9 = var8.next();
            var10 = (Module) var9;
            iterator = 0;
            var12 = (Iterable) var10.getList();
            var13 = var12.iterator();
            if (var13.hasNext()) {
                var14 = var13.next();
                VisibleSettingProperty var15 = (VisibleSettingProperty) var14;
                int var16 = 0;
            }
        }
    }

    public Module resolveModule(String id) {
        Iterable var5 = (Iterable) arrayList2;
        Iterator iterator = var5.iterator();
        if (iterator.hasNext()) {
            Object var7 = iterator.next();
            Module var8 = (Module) var7;
            int var9 = 0;
        } else {
        }
        if ((Module) null != null) {
        }
        return var7;
    }

    private void onInputEvent(InputEvent arg0) {
        if (arg0.getKey() == -1 || arg0.getAction() == Action.Hold) {
            return;
        }
        if (arg0.getDevice() == Device.Mouse) {
            if (arg0.getAction() == Action.Press) {
                arrayList3.add(Integer.valueOf(arg0.getKey()));
            }
            arrayList3.clear();
        }
        if (arg0.getKey() == UIModule.INSTANCE.getBind().getNumericValue() && arg0.getAction() == Action.Press && SharedKt.getMc().currentScreen == null) {
            SharedKt.getMc().method_1507((Screen) CatleanInterfaceRenderHelper.INSTANCE);
        }
        Iterable var16 = (Iterable) arrayList2;
        int var17 = 0;
        Object var18 = var16;
        Collection var19 = (Collection) new ArrayList();
        int var20 = 0;
        Iterator iterator = var18.iterator();
        if (iterator.hasNext()) {
            Object var22 = iterator.next();
            Module var23 = (Module) var22;
            int var24 = 0;
            if (var23.getBind().getNumericValue() == arg0.getKey()) {
            } else {
            }
            var19.add();
        }
        var16 = (Iterable) var19;
        var17 = 0;
        var18 = var16.iterator();
        if (var18.hasNext()) {
            var19 = var18.next();
            var20 = (Module) var19;
            iterator = 0;
            var22 = INSTANCE;
            var23 = 0;
            if (!(var20.getBind().isActive())) {
                if (arg0.getAction() == Action.Press && SharedKt.getMc().currentScreen == null) {
                    var20.updateValue();
                }
                if (arg0.getAction() == Action.Press) {
                    var20.executeAction();
                }
                var20.updateValue2();
            }
        }
    }

    static {
        INSTANCE = new EnabledServiceComponent();
        SubCategoriesServiceComponent[] var29 = new SubCategoriesServiceComponent[4];
        var29[0] = MovementServiceComponent.getSubCategoriesServiceComponent();
        var29[1] = MovementServiceComponent.getSubCategoriesServiceComponent2();
        var29[2] = MovementServiceComponent.getSubCategoriesServiceComponent3();
        var29[3] = MovementServiceComponent.getSubCategoriesServiceComponent4();
        arrayList = CollectionsKt.arrayListOf();
        arrayList2 = new ArrayList();
        arrayList3 = new ArrayList();
        INSTANCE.checkCondition();
        INSTANCE.updateValue();
        executeAction(INSTANCE);
    }

    public static void updateValue(int arg0) {
        countValue = arg0;
    }

    public static int getNumericValue() {
        return countValue;
    }

    public static int getNumericValue2() {
        return 47;
        return 0;
    }

}
