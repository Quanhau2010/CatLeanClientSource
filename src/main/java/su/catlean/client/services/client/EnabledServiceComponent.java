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
        Module[] items = new Module[167];
        items[0] = ElytraTargetModule.INSTANCE;
        items[1] = BowMinecartModule.INSTANCE;
        items[2] = ElytraFreezeModule.INSTANCE;
        items[3] = DismembermentModule.INSTANCE;
        items[4] = ExtraTabModule.INSTANCE;
        items[5] = ThrowPetardModule.INSTANCE;
        items[6] = AntiAimModule.INSTANCE;
        items[7] = VoidEspModule.INSTANCE;
        items[8] = AspectModule.INSTANCE;
        items[9] = TestModule.INSTANCE;
        items[10] = NameProtectModule.INSTANCE;
        items[11] = AnchorBindModule.INSTANCE;
        items[12] = SpiderModule.INSTANCE;
        items[13] = AssistantModule.INSTANCE;
        items[14] = AutoBoneMealModule.INSTANCE;
        items[15] = PearlPhaseEspModule.INSTANCE;
        items[16] = AutoSweetBerriesModule.INSTANCE;
        items[17] = MaceElytraTargetModule.INSTANCE;
        items[18] = DamageParticlesModule.INSTANCE;
        items[19] = InfiniteElytraModule.INSTANCE;
        items[20] = MoreKnockbackModule.INSTANCE;
        items[21] = EcExploitModule.INSTANCE;
        items[22] = AntiAttackModule.INSTANCE;
        items[23] = MainhandTotemModule.INSTANCE;
        items[24] = ServerHelperModule.INSTANCE;
        items[25] = BoatFlyModule.INSTANCE;
        items[26] = ZoomModule.INSTANCE;
        items[27] = WindHopModule.INSTANCE;
        items[28] = LegitStrafeModule.INSTANCE;
        items[29] = DamageTintModule.INSTANCE;
        items[30] = FreeLookModule.INSTANCE;
        items[31] = AutoNetheriteScrapModule.INSTANCE;
        items[32] = FastLatencyModule.INSTANCE;
        items[33] = PingSpoofModule.INSTANCE;
        items[34] = AutoMendModule.INSTANCE;
        items[35] = BlockerModule.INSTANCE;
        items[36] = AutoShearModule.INSTANCE;
        items[37] = SoilRipperModule.INSTANCE;
        items[38] = SwingAnimationsModule.INSTANCE;
        items[39] = ParticlesModule.INSTANCE;
        items[40] = AutoTraderModule.INSTANCE;
        items[41] = BuffEffectModule.INSTANCE;
        items[42] = ActionRecorderModule.INSTANCE;
        items[43] = AutoPotionBrewModule.INSTANCE;
        items[44] = AutoLandModule.INSTANCE;
        items[45] = AntiKnockBackModule.INSTANCE;
        items[46] = ChestStealerModule.INSTANCE;
        items[47] = NoCameraClipModule.INSTANCE;
        items[48] = AvoidModule.INSTANCE;
        items[49] = BreakEspModule.INSTANCE;
        items[50] = XRayModule.INSTANCE;
        items[51] = ElytraRecastModule.INSTANCE;
        items[52] = AutoBasePlaceModule.INSTANCE;
        items[53] = GuiMoveModule.INSTANCE;
        items[54] = MoveFixModule.INSTANCE;
        items[55] = NoPushModule.INSTANCE;
        items[56] = SprintModule.INSTANCE;
        items[57] = AttributeSwapModule.INSTANCE;
        items[58] = AntiVoidModule.INSTANCE;
        items[59] = AntiWebModule.INSTANCE;
        items[60] = ElytraPlusModule.INSTANCE;
        items[61] = FlightModule.INSTANCE;
        items[62] = LevitationControlModule.INSTANCE;
        items[63] = BlinkModule.INSTANCE;
        items[64] = PopChamsModule.INSTANCE;
        items[65] = NoFallModule.INSTANCE;
        items[66] = NoSlowModule.INSTANCE;
        items[67] = PhaseModule.INSTANCE;
        items[68] = ReverseStepModule.INSTANCE;
        items[69] = SpeedModule.INSTANCE;
        items[70] = StepModule.INSTANCE;
        items[71] = TimerModule.INSTANCE;
        items[72] = WaterSpeedModule.INSTANCE;
        items[73] = AuraModule.INSTANCE;
        items[74] = AutoCrystalModule.INSTANCE;
        items[75] = AbsorptionModule.INSTANCE;
        items[76] = SourceFillerModule.INSTANCE;
        items[77] = AutoWebModule.INSTANCE;
        items[78] = MessageAppendModule.INSTANCE;
        items[79] = CriticalsModule.INSTANCE;
        items[80] = HoleFillerModule.INSTANCE;
        items[81] = AutoBuffModule.INSTANCE;
        items[82] = BowSpamModule.INSTANCE;
        items[83] = ReachModule.INSTANCE;
        items[84] = AutoWitherModule.INSTANCE;
        items[85] = HighJumpModule.INSTANCE;
        items[86] = SkyLanternsModule.INSTANCE;
        items[87] = AntiPhaseModule.INSTANCE;
        items[88] = AutoGappleModule.INSTANCE;
        items[89] = BurrowModule.INSTANCE;
        items[90] = LegitTotemModule.INSTANCE;
        items[91] = OffhandModule.INSTANCE;
        items[92] = SurroundModule.INSTANCE;
        items[93] = AutoArmorModule.INSTANCE;
        items[94] = AutoToolModule.INSTANCE;
        items[95] = ElytraSwapModule.INSTANCE;
        items[96] = InventoryManagerModule.INSTANCE;
        items[97] = ItemScrollerModule.INSTANCE;
        items[98] = MiddleClickModule.INSTANCE;
        items[99] = AutoMineModule.INSTANCE;
        items[100] = NoServerSlotModule.INSTANCE;
        items[101] = ReFillerModule.INSTANCE;
        items[102] = ToolSaverModule.INSTANCE;
        items[103] = XCarryModule.INSTANCE;
        items[104] = AntiResourcePackModule.INSTANCE;
        items[105] = UIModule.INSTANCE;
        items[106] = TrapModule.INSTANCE;
        items[107] = SelfTrapModule.INSTANCE;
        items[108] = TeamCommunicationModule.INSTANCE;
        items[109] = NotifierModule.INSTANCE;
        items[110] = RPCModule.INSTANCE;
        items[111] = SpammerModule.INSTANCE;
        items[112] = TapeMouseModule.INSTANCE;
        items[113] = TranslatorModule.INSTANCE;
        items[114] = AirPlaceModule.INSTANCE;
        items[115] = ElytraReplaceModule.INSTANCE;
        items[116] = AntiHungerModule.INSTANCE;
        items[117] = AutoAuthModule.INSTANCE;
        items[118] = AutoFishModule.INSTANCE;
        items[119] = AutoRespawnModule.INSTANCE;
        items[120] = AutoTpaAcceptModule.INSTANCE;
        items[121] = ChorusDelayModule.INSTANCE;
        items[122] = MultiTaskModule.INSTANCE;
        items[123] = NoDelayModule.INSTANCE;
        items[124] = TraceThroughModule.INSTANCE;
        items[125] = NoServerRotateModule.INSTANCE;
        items[126] = PerfectDelayModule.INSTANCE;
        items[127] = PortalGodModeModule.INSTANCE;
        items[128] = SpeedMineModule.INSTANCE;
        items[129] = AutoSignModule.INSTANCE;
        items[130] = FakePlayerModule.INSTANCE;
        items[131] = FreeCamModule.INSTANCE;
        items[132] = NoRenderModule.INSTANCE;
        items[133] = NukerModule.INSTANCE;
        items[134] = PearlChaserModule.INSTANCE;
        items[135] = ScaffoldModule.INSTANCE;
        items[136] = CrystalChamsModule.INSTANCE;
        items[137] = FullBrightModule.INSTANCE;
        items[138] = HandChamsModule.INSTANCE;
        items[139] = HitFxModule.INSTANCE;
        items[140] = TotemAnimationModule.INSTANCE;
        items[141] = TrajectoriesModule.INSTANCE;
        items[142] = ViewModelModule.INSTANCE;
        items[143] = WorldRendererModule.INSTANCE;
        items[144] = HoleAnchorModule.INSTANCE;
        items[145] = CrystalBindModule.INSTANCE;
        items[146] = SearchModule.INSTANCE;
        items[147] = HoleEspModule.INSTANCE;
        items[148] = EntitySpeedModule.INSTANCE;
        items[149] = ItemEspModule.INSTANCE;
        items[150] = LogoutSpotsModule.INSTANCE;
        items[151] = AutoDripstopeModule.INSTANCE;
        items[152] = TpsSyncModule.INSTANCE;
        items[153] = BoxShrinkerModule.INSTANCE;
        items[154] = AutoLeaveModule.INSTANCE;
        items[155] = AutoSoupModule.INSTANCE;
        items[156] = AutoEatModule.INSTANCE;
        items[157] = NameTagsModule.INSTANCE;
        items[158] = ProjectilePredictModule.INSTANCE;
        items[159] = PlayerEspModule.INSTANCE;
        items[160] = StorageEspModule.INSTANCE;
        items[161] = TracersModule.INSTANCE;
        items[162] = NoInteractModule.INSTANCE;
        items[163] = AutoEzModule.INSTANCE;
        items[164] = MaceKillerModule.INSTANCE;
        items[165] = TridentBoostModule.INSTANCE;
        items[166] = QuiverModule.INSTANCE;
        return arrayList2.addAll(((Collection) CollectionsKt.listOf(items)));
    }

    public void updateValue() {
        Iterable iterable = ((Iterable) arrayList2);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            Module module = ((Module) element);
            Iterable iterable2 = ((Iterable) module.getList());
            Iterator iterator2 = iterable2.iterator();
            while (iterator2.hasNext()) {
                Object element2 = iterator2.next();
                VisibleSettingProperty visibleSettingProperty = ((VisibleSettingProperty) element2);
                Iterable iterable3 = ((Iterable) ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl2().resolveIdRecord3().getList());
                Iterator iterator3 = iterable3.iterator();
                while (iterator3.hasNext()) {
                    Object element3 = iterator3.next();
                    IdRecord5 idRecord5 = ((IdRecord5) element3);
                    int index = 0;
                }
                if (((IdRecord5) null) == null) {
                }
                iterator3 = ((Iterable) element3.getList());
                element3 = iterator3.iterator();
                while (element3.hasNext()) {
                    idRecord5 = element3.next();
                    index = ((IdRecord10) idRecord5);
                }
                if (((IdRecord10) null) == null) {
                }
                visibleSettingProperty.setValue(idRecord5.getString2());
                visibleSettingProperty.setValue();
                String text = this.getMessage();
                String text2 = module.getString2();
                String text3 = visibleSettingProperty.getString2();
                SharedKt.getLogger().warn(("Could not parse setting: " + text3 + " in " + text2 + ": " + text));
            }
        }
    }

    public void executeAction(IdRecord3 prevConfig) {
        Iterable iterable = ((Iterable) arrayList2);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            Module module = ((Module) element);
            if (__UNDEF_KEY__ >= 0) {
                if (prevConfig != null) {
                    List list = prevConfig.getList();
                    if (__UNDEF_KEY__ >= 0) {
                        if (list != null) {
                            Iterable iterable2 = ((Iterable) list);
                            int index = 0;
                            Iterator iterator2 = iterable2.iterator();
                            while (iterator2.hasNext()) {
                                Object element2 = iterator2.next();
                                IdRecord5 idRecord5 = ((IdRecord5) element2);
                                int index2 = 0;
                            }
                            IdRecord5 idRecord52 = ((IdRecord5) null);
                            if (__UNDEF_KEY__ >= 0) {
                                if (idRecord52 != null) {
                                    iterable2 = idRecord52.getList();
                                    if (__UNDEF_KEY__ >= 0) {
                                        if (iterable2 != null) {
                                            iterator2 = ((Iterable) iterable2);
                                            element2 = 0;
                                            idRecord5 = iterator2.iterator();
                                            while (idRecord5.hasNext()) {
                                                index2 = idRecord5.next();
                                                IdRecord10 idRecord10 = ((IdRecord10) index2);
                                            }
                                            index = ((IdRecord10) null);
                                            if (__UNDEF_KEY__ > 0) {
                                                if (index != null) {
                                                    iterator2 = index.getString2();
                                                    if (__UNDEF_KEY__ > 0) {
                                                        if (iterator2 != null) {
                                                        } else {
                                                        }
                                                    }
                                                } else {
                                                }
                                            }
                                        } else {
                                        }
                                    }
                                } else {
                                }
                            }
                        } else {
                        }
                    }
                } else {
                    Gofra.INSTANCE.unplug(module);
                }
            }
            if (__UNDEF_KEY__ >= 0 && module.getEnabled()) {
                Gofra.INSTANCE.plug(module);
                if (!(Intrinsics.areEqual(Boolean.valueOf(module.getEnabled())))) {
                    module.updateValue();
                    if (prevConfig != null) {
                        if (__UNDEF_KEY__ >= 0 && __UNDEF_KEY__ >= 0 && __UNDEF_KEY__ > 0) {
                            if (!(Intrinsics.areEqual(Boolean.valueOf(module.getEnabled())))) {
                                module.updateValue2();
                            }
                        }
                    }
                }
            } else {
            }
        }
    }

    public static void executeAction(EnabledServiceComponent arg0, IdRecord3 arg1, int arg2, Object arg3) {
        if ((arg2 & 1) != 0) {
        }
        arg0.executeAction(arg1);
    }

    public void executeAction(String moduleId, String id) {
        Iterable iterable = ((Iterable) arrayList2);
        Iterable iterable2 = iterable;
        Collection collection = ((Collection) new ArrayList());
        int index = 0;
        Iterator iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            Module module = ((Module) element);
            int index2 = 0;
            collection.add(element);
        }
        iterable = ((Iterable) collection);
        iterable2 = iterable.iterator();
        while (iterable2.hasNext()) {
            collection = iterable2.next();
            index = ((Module) collection);
            iterator = 0;
            element = ((Iterable) index.getList());
            module = element.iterator();
            while (module.hasNext()) {
                index2 = module.next();
                VisibleSettingProperty visibleSettingProperty = ((VisibleSettingProperty) index2);
            }
        }
    }

    public Module resolveModule(String id) {
        Iterable iterable = ((Iterable) arrayList2);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            Module module = ((Module) element);
        }
        if (((Module) null) != null) {
        }
        return element;
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
            SharedKt.getMc().method_1507(((Screen) CatleanInterfaceRenderHelper.INSTANCE));
        }
        Iterable iterable = ((Iterable) arrayList2);
        Iterable iterable2 = iterable;
        Collection collection = ((Collection) new ArrayList());
        int index = 0;
        Iterator iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            Module module = ((Module) element);
            if (module.getBind().getNumericValue() == arg0.getKey()) {
            } else {
            }
            collection.add(element);
        }
        iterable = ((Iterable) collection);
        iterable2 = iterable.iterator();
        while (iterable2.hasNext()) {
            collection = iterable2.next();
            index = ((Module) collection);
            iterator = 0;
            element = INSTANCE;
            module = 0;
            if (!(index.getBind().isActive())) {
                if (arg0.getAction() == Action.Press && SharedKt.getMc().currentScreen == null) {
                    index.updateValue();
                    if (arg0.getAction() == Action.Press) {
                        index.executeAction();
                    }
                    index.updateValue2();
                }
            }
        }
    }

    static {
        INSTANCE = new EnabledServiceComponent();
        SubCategoriesServiceComponent[] items = new SubCategoriesServiceComponent[4];
        items[0] = MovementServiceComponent.getSubCategoriesServiceComponent();
        items[1] = MovementServiceComponent.getSubCategoriesServiceComponent2();
        items[2] = MovementServiceComponent.getSubCategoriesServiceComponent3();
        items[3] = MovementServiceComponent.getSubCategoriesServiceComponent4();
        arrayList = CollectionsKt.arrayListOf(items);
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
