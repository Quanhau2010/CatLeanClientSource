package su.catlean.client.features.modules.pvp.attack;

import com.google.common.collect.Lists;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1299;
import net.minecraft.class_1542;
import net.minecraft.class_1661;
import net.minecraft.class_1703;
import net.minecraft.class_1713;
import net.minecraft.class_1774;
import net.minecraft.class_239.class_240;
import net.minecraft.class_2604;
import net.minecraft.class_2663;
import net.minecraft.class_2664;
import net.minecraft.class_2767;
import net.minecraft.class_2784;
import net.minecraft.class_2824;
import net.minecraft.class_2846;
import net.minecraft.class_2846.class_2847;
import net.minecraft.class_2868;
import net.minecraft.class_2879;
import net.minecraft.class_2885;
import net.minecraft.class_3417;
import net.minecraft.class_3532;
import net.minecraft.class_3965;
import net.minecraft.class_6880;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.event.events.network.SendPacket;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.player.PostSyncEvent;
import su.catlean.api.event.events.render.Render2DEvent;
import su.catlean.api.event.events.render.Render3DEvent;
import su.catlean.api.event.events.render.RenderEntityEvent;
import su.catlean.api.event.events.world.AfterEntitySpawn;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl7;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.api.setting.SettingGroup;
import su.catlean.api.setting.SettingIdVisibleSettingPropertyImpl;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.movement.rage.BlinkModule;
import su.catlean.client.features.modules.pvp.protect.OffhandModule;
import su.catlean.client.features.modules.render.esp.NameTagsModule;
import su.catlean.client.features.modules.utility.player.AutoMendModule;
import su.catlean.client.features.modules.utility.player.SpeedMineModule;
import su.catlean.client.features.modules.utility.player.SpeedMineSwitchMode;
import su.catlean.client.services.client.ConfigStateServiceComponent;
import su.catlean.client.services.client.CrystalServiceComponent;
import su.catlean.client.services.client.CrystalServiceComponent2;
import su.catlean.client.services.client.DamageDataServiceComponent;
import su.catlean.client.services.client.DamageSyncServiceComponent;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.HandServiceComponent;
import su.catlean.client.services.client.MessageServiceComponent;
import su.catlean.client.services.client.MoveFixServiceComponent;
import su.catlean.client.services.client.PlaceServiceComponent;
import su.catlean.client.services.client.SequenceServiceComponent;
import su.catlean.client.services.client.ServiceComponent;
import su.catlean.client.services.client.ServiceComponent10;
import su.catlean.client.services.client.ServiceComponent11;
import su.catlean.client.services.client.ServiceComponent131;
import su.catlean.client.services.client.ServiceComponent38;
import su.catlean.client.services.client.ServiceComponent45;
import su.catlean.client.services.client.ServiceComponent74;
import su.catlean.client.services.client.ServiceComponent93;
import su.catlean.client.services.client.ServiceComponent95;
import su.catlean.client.services.client.SideServiceComponent;
import su.catlean.client.services.client.StackServiceComponent2;
import su.catlean.client.services.client.StartupServiceComponent;
import su.catlean.client.services.client.VectorServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EntityPacketHelper;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.network.PacketPacketHelper;
import su.catlean.client.services.network.TheNetherPacketHelper;
import su.catlean.client.services.network.VecPacketHelper;
import su.catlean.client.services.player.ConfigStateEntityHelper;
import su.catlean.client.services.player.EntitiesEntityHelper;
import su.catlean.client.services.player.ExplosionPosEntityHelper;
import su.catlean.client.services.render.NewThemeRenderHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.services.render.shader.BoxShaderComponent;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent3;
import su.catlean.client.services.render.shader.TextShaderComponent2;
import su.catlean.client.types.TpYawSmootherMode;
import su.catlean.client.types.mappings.AuraEspModeWhenMappings;
import su.catlean.mixins.accessors.ClientboundEntityEventPacketAccessor;

public class AutoCrystalModule extends Module {

    public static final AutoCrystalModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl7 mainGroupSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 timingSetting;
    private static final VisibleVisibleSettingPropertyImpl multiActionSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 onCrystalSpawnSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 spawnTimingSetting;
    private static final VisibleVisibleSettingPropertyImpl rotateSetting;
    private static final VisibleVisibleSettingPropertyImpl rayTraceSetting;
    private static final VisibleVisibleSettingPropertyImpl crystalMultiPointSetting;
    private static final VisibleVisibleSettingPropertyImpl asyncCalcSetting;
    private static final VisibleVisibleSettingPropertyImpl failNotifySetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 predictSetting;
    private static final RangeVisibleSettingPropertyImpl predictTicksValueSetting;
    private static final DefaultValueVisibleSettingPropertyImpl7 placeGroupSetting;
    private static final VisibleVisibleSettingPropertyImpl oldVerSetting;
    private static final RangeVisibleSettingPropertyImpl placeDelaySetting;
    private static final RangeVisibleSettingPropertyImpl2 placeRangeSetting;
    private static final VisibleVisibleSettingPropertyImpl limitPlaceSetting;
    private static final VisibleVisibleSettingPropertyImpl removeFireSetting;
    private static final VisibleVisibleSettingPropertyImpl removeLavaSetting;
    private static final DefaultValueVisibleSettingPropertyImpl7 breakGroupSetting;
    private static final RangeVisibleSettingPropertyImpl breakDelaySetting;
    private static final VisibleVisibleSettingPropertyImpl grimBreakRangeSetting;
    private static final RangeVisibleSettingPropertyImpl2 explodeRangeSetting;
    private static final VisibleVisibleSettingPropertyImpl limitBreakSetting;
    private static final VisibleVisibleSettingPropertyImpl randomizeDelaySetting;
    private static final DefaultValueVisibleSettingPropertyImpl7 pauseGroupSetting;
    private static final VisibleVisibleSettingPropertyImpl miningSetting;
    private static final VisibleVisibleSettingPropertyImpl eatingSetting;
    private static final VisibleVisibleSettingPropertyImpl inventorySetting;
    private static final RangeVisibleSettingPropertyImpl switchPauseSetting;
    private static final RangeVisibleSettingPropertyImpl offHandPauseSetting;
    private static final DefaultValueVisibleSettingPropertyImpl7 damagesGroupSetting;
    private static final VisibleVisibleSettingPropertyImpl assumeBestArmorSetting;
    private static final RangeVisibleSettingPropertyImpl2 minDamageSetting;
    private static final RangeVisibleSettingPropertyImpl2 maxSelfDamageSetting;
    private static final RangeVisibleSettingPropertyImpl2 efficiencyFactorSetting;
    private static final RangeVisibleSettingPropertyImpl lethalMultiplierSetting;
    private static final VisibleVisibleSettingPropertyImpl overrideSelfDamageSetting;
    private static final VisibleVisibleSettingPropertyImpl overrideMinDamageSetting;
    private static final RangeVisibleSettingPropertyImpl2 armorScaleSetting;
    private static final RangeVisibleSettingPropertyImpl2 facePlaceHpSetting;
    private static final VisibleVisibleSettingPropertyImpl explodeEChestFarmSetting;
    private static final VisibleVisibleSettingPropertyImpl antiPortalSetting;
    private static final VisibleVisibleSettingPropertyImpl antiQuiverSetting;
    private static final VisibleVisibleSettingPropertyImpl terrainIgnoreSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 friendProtectionSetting;
    private static final VisibleVisibleSettingPropertyImpl calcShieldsSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 damageSyncSetting;
    private static final VisibleVisibleSettingPropertyImpl facePlaceSyncSetting;
    private static final VisibleVisibleSettingPropertyImpl lowCrystalsSetting;
    private static final RangeVisibleSettingPropertyImpl2 stacksLeftSetting;
    private static final VisibleVisibleSettingPropertyImpl minimizeSelfDamageSetting;
    private static final RangeVisibleSettingPropertyImpl2 maxDamageReductionSetting;
    private static final DefaultValueVisibleSettingPropertyImpl7 switchGroupSetting;
    private static final VisibleVisibleSettingPropertyImpl gappleSwitchSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 autoSwitchSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 antiWeaknessSetting;
    private static final DefaultValueVisibleSettingPropertyImpl7 idPredictGroupSetting;
    private static final VisibleVisibleSettingPropertyImpl idPredictSetting;
    private static final RangeVisibleSettingPropertyImpl idOffsetSetting;
    private static final RangeVisibleSettingPropertyImpl idAttacksSetting;
    private static final RangeVisibleSettingPropertyImpl idDelaySetting;
    private static final VisibleVisibleSettingPropertyImpl idPredictOnlyDuelsSetting;
    private static final VisibleVisibleSettingPropertyImpl swingOnceSetting;
    private static final VisibleVisibleSettingPropertyImpl onlyBreakingSurrSetting;
    private static final DefaultValueVisibleSettingPropertyImpl7 targetingSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 targetSortSetting;
    private static final VisibleVisibleSettingPropertyImpl ignoreCreativeSetting;
    private static final VisibleVisibleSettingPropertyImpl ignoreNakedSetting;
    private static final DefaultValueVisibleSettingPropertyImpl7 renderGroupSetting;
    private static final VisibleVisibleSettingPropertyImpl fakeCrystalRemoveSetting;
    private static final RangeVisibleSettingPropertyImpl removeDelaySetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 targetEspSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 renderModeSetting;
    private static final SettingIdVisibleSettingPropertyImpl textPatternSetting;
    private static final RangeVisibleSettingPropertyImpl2 alphaSetting;
    private static PlayerEntity playerEntity;
    private static AtomicReference atomicReference;
    private static AtomicReference atomicReference2;
    private static AtomicBoolean atomicBoolean;
    private static final ServiceComponent38 serviceComponent38;
    private static final ServiceComponent38 serviceComponent382;
    private static final ServiceComponent10 serviceComponent10;
    private static final ServiceComponent38 serviceComponent383;
    private static final ServiceComponent38 serviceComponent384;
    private static int countValue;
    private static int countValue2;
    private static int countValue3;
    private static int countValue4;
    private static SideServiceComponent sideServiceComponent;
    private static Function0 function0;
    private static Function0 function02;
    private static boolean enabledFlag;
    private static boolean enabledFlag2;
    private static boolean enabledFlag3;
    private static long timestampValue2;
    private static int countValue5;
    private static final Map lookupMap;
    private static final LinkedList linkedList;
    private static AtomicReference atomicReference3;
    private static boolean enabledFlag4;
    private static ServiceComponent10 serviceComponent102;
    private static final EasingServiceComponent easingServiceComponent;
    private static String textValue;

    private AutoCrystalModule() {
        super("auto-crystal", SubCategoriesKt.getAttackCategory());
    }

    private SettingGroup getMainGroup() {
        return (SettingGroup) mainGroupSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private AutoCrystalTimingMode getTiming() {
        return (AutoCrystalTimingMode) timingSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private boolean getMultiAction() {
        return (Boolean) multiActionSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private AutoCrystalOnCrystalSpawnMode getOnCrystalSpawn() {
        return (AutoCrystalOnCrystalSpawnMode) onCrystalSpawnSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private AutoCrystalSpawnTimingMode getSpawnTiming() {
        return (AutoCrystalSpawnTimingMode) spawnTimingSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    private boolean getRotate() {
        return (Boolean) rotateSetting.getValue(this, DELEGATED_PROPERTIES[5]);
    }

    private boolean getRayTrace() {
        return (Boolean) rayTraceSetting.getValue(this, DELEGATED_PROPERTIES[6]);
    }

    private boolean getCrystalMultiPoint() {
        return (Boolean) crystalMultiPointSetting.getValue(this, DELEGATED_PROPERTIES[7]);
    }

    private boolean getAsyncCalc() {
        return (Boolean) asyncCalcSetting.getValue(this, DELEGATED_PROPERTIES[8]);
    }

    public boolean getFailNotify() {
        return (Boolean) failNotifySetting.getValue(this, DELEGATED_PROPERTIES[9]);
    }

    private AutoCrystalPredictMode getPredict() {
        return (AutoCrystalPredictMode) predictSetting.getValue(this, DELEGATED_PROPERTIES[10]);
    }

    private int getPredictTicksValue() {
        return (Number) predictTicksValueSetting.getValue(this, DELEGATED_PROPERTIES[11]);
    }

    private SettingGroup getPlaceGroup() {
        return (SettingGroup) placeGroupSetting.getValue(this, DELEGATED_PROPERTIES[12]);
    }

    private boolean getOldVer() {
        return (Boolean) oldVerSetting.getValue(this, DELEGATED_PROPERTIES[13]);
    }

    private int getPlaceDelay() {
        return (Number) placeDelaySetting.getValue(this, DELEGATED_PROPERTIES[14]);
    }

    private float getPlaceRange() {
        return (Number) placeRangeSetting.getValue(this, DELEGATED_PROPERTIES[15]);
    }

    private boolean getLimitPlace() {
        return (Boolean) limitPlaceSetting.getValue(this, DELEGATED_PROPERTIES[16]);
    }

    private boolean getRemoveFire() {
        return (Boolean) removeFireSetting.getValue(this, DELEGATED_PROPERTIES[17]);
    }

    private boolean getRemoveLava() {
        return (Boolean) removeLavaSetting.getValue(this, DELEGATED_PROPERTIES[18]);
    }

    private SettingGroup getBreakGroup() {
        return (SettingGroup) breakGroupSetting.getValue(this, DELEGATED_PROPERTIES[19]);
    }

    private int getBreakDelay() {
        return (Number) breakDelaySetting.getValue(this, DELEGATED_PROPERTIES[20]);
    }

    private boolean getGrimBreakRange() {
        return (Boolean) grimBreakRangeSetting.getValue(this, DELEGATED_PROPERTIES[21]);
    }

    private float getExplodeRange() {
        return (Number) explodeRangeSetting.getValue(this, DELEGATED_PROPERTIES[22]);
    }

    private boolean getLimitBreak() {
        return (Boolean) limitBreakSetting.getValue(this, DELEGATED_PROPERTIES[23]);
    }

    public boolean getRandomizeDelay() {
        return (Boolean) randomizeDelaySetting.getValue(this, DELEGATED_PROPERTIES[24]);
    }

    private SettingGroup getPauseGroup() {
        return (SettingGroup) pauseGroupSetting.getValue(this, DELEGATED_PROPERTIES[25]);
    }

    private boolean getMining() {
        return (Boolean) miningSetting.getValue(this, DELEGATED_PROPERTIES[26]);
    }

    private boolean getEating() {
        return (Boolean) eatingSetting.getValue(this, DELEGATED_PROPERTIES[27]);
    }

    private boolean getInventory() {
        return (Boolean) inventorySetting.getValue(this, DELEGATED_PROPERTIES[28]);
    }

    private int getSwitchPause() {
        return (Number) switchPauseSetting.getValue(this, DELEGATED_PROPERTIES[29]);
    }

    private int getOffHandPause() {
        return (Number) offHandPauseSetting.getValue(this, DELEGATED_PROPERTIES[30]);
    }

    private SettingGroup getDamagesGroup() {
        return (SettingGroup) damagesGroupSetting.getValue(this, DELEGATED_PROPERTIES[31]);
    }

    public boolean getAssumeBestArmor() {
        return (Boolean) assumeBestArmorSetting.getValue(this, DELEGATED_PROPERTIES[32]);
    }

    private float getMinDamage() {
        return (Number) minDamageSetting.getValue(this, DELEGATED_PROPERTIES[33]);
    }

    private float getMaxSelfDamage() {
        return (Number) maxSelfDamageSetting.getValue(this, DELEGATED_PROPERTIES[34]);
    }

    private float getEfficiencyFactor() {
        return (Number) efficiencyFactorSetting.getValue(this, DELEGATED_PROPERTIES[35]);
    }

    private int getLethalMultiplier() {
        return (Number) lethalMultiplierSetting.getValue(this, DELEGATED_PROPERTIES[36]);
    }

    private boolean getOverrideSelfDamage() {
        return (Boolean) overrideSelfDamageSetting.getValue(this, DELEGATED_PROPERTIES[37]);
    }

    private boolean getOverrideMinDamage() {
        return (Boolean) overrideMinDamageSetting.getValue(this, DELEGATED_PROPERTIES[38]);
    }

    private float getArmorScale() {
        return (Number) armorScaleSetting.getValue(this, DELEGATED_PROPERTIES[39]);
    }

    private float getFacePlaceHp() {
        return (Number) facePlaceHpSetting.getValue(this, DELEGATED_PROPERTIES[40]);
    }

    private boolean getExplodeEChestFarm() {
        return (Boolean) explodeEChestFarmSetting.getValue(this, DELEGATED_PROPERTIES[41]);
    }

    private boolean getAntiPortal() {
        return (Boolean) antiPortalSetting.getValue(this, DELEGATED_PROPERTIES[42]);
    }

    private boolean getAntiQuiver() {
        return (Boolean) antiQuiverSetting.getValue(this, DELEGATED_PROPERTIES[43]);
    }

    public boolean getTerrainIgnore() {
        return (Boolean) terrainIgnoreSetting.getValue(this, DELEGATED_PROPERTIES[44]);
    }

    private AutoCrystalFriendProtectionMode getFriendProtection() {
        return (AutoCrystalFriendProtectionMode) friendProtectionSetting.getValue(this, DELEGATED_PROPERTIES[45]);
    }

    private boolean getCalcShields() {
        return (Boolean) calcShieldsSetting.getValue(this, DELEGATED_PROPERTIES[46]);
    }

    private AutoCrystalDamageSyncMode getDamageSync() {
        return (AutoCrystalDamageSyncMode) damageSyncSetting.getValue(this, DELEGATED_PROPERTIES[47]);
    }

    private boolean getFacePlaceSync() {
        return (Boolean) facePlaceSyncSetting.getValue(this, DELEGATED_PROPERTIES[48]);
    }

    private boolean getLowCrystals() {
        return (Boolean) lowCrystalsSetting.getValue(this, DELEGATED_PROPERTIES[49]);
    }

    private float getStacksLeft() {
        return (Number) stacksLeftSetting.getValue(this, DELEGATED_PROPERTIES[50]);
    }

    private boolean getMinimizeSelfDamage() {
        return (Boolean) minimizeSelfDamageSetting.getValue(this, DELEGATED_PROPERTIES[51]);
    }

    private float getMaxDamageReduction() {
        return (Number) maxDamageReductionSetting.getValue(this, DELEGATED_PROPERTIES[52]);
    }

    private SettingGroup getSwitchGroup() {
        return (SettingGroup) switchGroupSetting.getValue(this, DELEGATED_PROPERTIES[53]);
    }

    private boolean getGappleSwitch() {
        return (Boolean) gappleSwitchSetting.getValue(this, DELEGATED_PROPERTIES[54]);
    }

    private AutoCrystalAutoSwitchMode getAutoSwitch() {
        return (AutoCrystalAutoSwitchMode) autoSwitchSetting.getValue(this, DELEGATED_PROPERTIES[55]);
    }

    private AutoCrystalAutoSwitchMode getAntiWeakness() {
        return (AutoCrystalAutoSwitchMode) antiWeaknessSetting.getValue(this, DELEGATED_PROPERTIES[56]);
    }

    private SettingGroup getIdPredictGroup() {
        return (SettingGroup) idPredictGroupSetting.getValue(this, DELEGATED_PROPERTIES[57]);
    }

    private boolean getIdPredict() {
        return (Boolean) idPredictSetting.getValue(this, DELEGATED_PROPERTIES[58]);
    }

    private int getIdOffset() {
        return (Number) idOffsetSetting.getValue(this, DELEGATED_PROPERTIES[59]);
    }

    private int getIdAttacks() {
        return (Number) idAttacksSetting.getValue(this, DELEGATED_PROPERTIES[60]);
    }

    private int getIdDelay() {
        return (Number) idDelaySetting.getValue(this, DELEGATED_PROPERTIES[61]);
    }

    private boolean getIdPredictOnlyDuels() {
        return (Boolean) idPredictOnlyDuelsSetting.getValue(this, DELEGATED_PROPERTIES[62]);
    }

    private boolean getSwingOnce() {
        return (Boolean) swingOnceSetting.getValue(this, DELEGATED_PROPERTIES[63]);
    }

    private boolean getOnlyBreakingSurr() {
        return (Boolean) onlyBreakingSurrSetting.getValue(this, DELEGATED_PROPERTIES[64]);
    }

    private SettingGroup getTargeting() {
        return (SettingGroup) targetingSetting.getValue(this, DELEGATED_PROPERTIES[65]);
    }

    private AutoCrystalTargetSortMode getTargetSort() {
        return (AutoCrystalTargetSortMode) targetSortSetting.getValue(this, DELEGATED_PROPERTIES[66]);
    }

    private boolean getIgnoreCreative() {
        return (Boolean) ignoreCreativeSetting.getValue(this, DELEGATED_PROPERTIES[67]);
    }

    private boolean getIgnoreNaked() {
        return (Boolean) ignoreNakedSetting.getValue(this, DELEGATED_PROPERTIES[68]);
    }

    private SettingGroup getRenderGroup() {
        return (SettingGroup) renderGroupSetting.getValue(this, DELEGATED_PROPERTIES[69]);
    }

    private boolean getFakeCrystalRemove() {
        return (Boolean) fakeCrystalRemoveSetting.getValue(this, DELEGATED_PROPERTIES[70]);
    }

    private int getRemoveDelay() {
        return (Number) removeDelaySetting.getValue(this, DELEGATED_PROPERTIES[71]);
    }

    private AuraEspMode getTargetEsp() {
        return (AuraEspMode) targetEspSetting.getValue(this, DELEGATED_PROPERTIES[72]);
    }

    private AutoCrystalRenderMode getRenderMode() {
        return (AutoCrystalRenderMode) renderModeSetting.getValue(this, DELEGATED_PROPERTIES[73]);
    }

    private String getTextPattern() {
        return (String) textPatternSetting.getValue(this, DELEGATED_PROPERTIES[74]);
    }

    private float getAlpha() {
        return (Number) alphaSetting.getValue(this, DELEGATED_PROPERTIES[75]);
    }

    public PlayerEntity getTarget() {
        return playerEntity;
    }

    public void updateValue(PlayerEntity value) {
        playerEntity = value;
    }

    public AtomicReference getAtomicReference() {
        return atomicReference;
    }

    public void executeAction(AtomicReference value) {
        atomicReference = value;
    }

    public AtomicBoolean getAtomicBoolean() {
        return atomicBoolean;
    }

    public void executeAction(AtomicBoolean value) {
        atomicBoolean = value;
    }

    public int getNumericValue() {
        return countValue4;
    }

    public void updateValue(int value) {
        countValue4 = value;
    }

    public long getNumericValue() {
        return timestampValue;
    }

    public void updateValue(long value) {
        timestampValue = value;
    }

    public long getNumericValue2() {
        return timestampValue2;
    }

    public void updateValue2(long value) {
        timestampValue2 = value;
    }

    public Map getMap() {
        return lookupMap;
    }

    public LinkedList getLinkedList() {
        return linkedList;
    }

    public AtomicReference getAtomicReference2() {
        return atomicReference3;
    }

    public void executeAction(AtomicReference value) {
        atomicReference3 = value;
    }

    public boolean isActive() {
        return enabledFlag4;
    }

    public void updateValue(boolean value) {
        enabledFlag4 = value;
    }

    public ServiceComponent10 getServiceComponent10() {
        return serviceComponent102;
    }

    public void executeAction(ServiceComponent10 value) {
        serviceComponent102 = value;
    }

    public void updateValue(long arg0) {
        long var3 = (arg0 ^ 13073325695020L);
        this.updateValue3();
    }

    public void updateValue2(long arg0) {
        long var3 = (arg0 ^ 48717721638758L);
        this.updateValue3();
    }

    private void updateValue3() {
        CrystalServiceComponent2.INSTANCE.executeAction();
        linkedList.clear();
        serviceComponent382.updateValue();
        serviceComponent38.updateValue();
        serviceComponent383.executeAction(20);
        enabledFlag = 0;
        atomicReference2.set();
        atomicReference.set();
        sideServiceComponent = null;
        playerEntity = null;
        timestampValue = 0L;
        countValue5 = 0;
        countValue4 = 0;
        function0 = null;
        function02 = null;
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (var59 == null) {
            if (this.getRenderMode() == AutoCrystalRenderMode.TECHNO) {
                BoxShaderComponent.INSTANCE.executeAction();
            }
        }
        float var60 = (Math.max(this.getPlaceRange(), this.getExplodeRange()) + 12.0F);
        Map var61 = (Map) new HashMap(lookupMap);
        int var62 = 0;
        Iterator iterator = var61.entrySet().iterator();
        if (iterator.hasNext()) {
            Entry var64 = (Entry) iterator.next();
            Object var65 = var64;
            int var66 = 0;
            BlockPos blockPos = (BlockPos) var65.getKey();
            Long var68 = (Long) var65.getValue();
            if (var59 == null) {
                if (var59 == null) {
                    if ((SharedKt.getNumericValue() - var68.longValue()) > (Math.max(100, TheNetherPacketHelper.f()) * 2.0F)) {
                        lookupMap.remove(blockPos);
                    }
                }
            }
            if (playerEntity != null) {
                if (var59 == null && var59 == null) {
                }
                if (playerEntity.method_29504()) {
                    StartupServiceComponent.INSTANCE.executeAction(1);
                    playerEntity = null;
                    return;
                }
            }
            playerEntity = EntityPacketHelper.INSTANCE.findTarget(this.getTargetSort(), this.getIgnoreNaked(), this.getIgnoreCreative());
        }
        if (var59 != null || playerEntity == null) {
            return;
        }
        var61 = this.resolveEntitiesEntityHelper();
        if (var59 == null) {
            if (this.getAsyncCalc()) {
                new Thread(this::updateValue).start();
                if (var59 != null) {
                }
            }
            this.executeAction();
        }
        enabledFlag4 = 0;
        if (!(Intrinsics.areEqual(SharedKt.getPlayer().method_6079().getItem(), Items.field_8301))) {
            if (this.getGappleSwitch()) {
                if (SharedKt.getMc().options.field_1904.method_1434()) {
                    if (var59 == null && var59 == null && var59 == null && var59 == null) {
                        if (Intrinsics.areEqual(SharedKt.getPlayer().method_6047().getItem(), Items.field_8301)) {
                            var62 = new Item[1];
                            var62[0] = Items.field_8367;
                            ItemPacketHelper.INSTANCE.resolveStackServiceComponent2().updateValue();
                        }
                    }
                }
            }
            var62 = countValue3;
            countValue3 = (var62 + 1);
        }
        if (var59 == null) {
            if (var62 >= 20) {
                int var56 = 2;
                int var57 = 0;
                Item var58 = Items.field_8301;
                countValue2 = class_3532.method_15340((countValue - ItemPacketHelper.computeValue()), 0, 255);
                var56 = 2;
                var57 = 0;
                var58 = Items.field_8301;
                countValue = ItemPacketHelper.computeValue();
                countValue3 = 0;
            }
            this.updateValue4();
            if (var59 == null) {
            }
        }
        var62 = (Vec3d) atomicReference3.get();
        iterator = MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent();
        SequenceServiceComponent.INSTANCE.executeAction(iterator, 140);
        if (var59 == null) {
            atomicReference3.lazySet();
        }
        sideServiceComponent = null;
    }

    private void onPostSyncEvent(PostSyncEvent arg0) {
        if (var4 == null) {
            if (function02 != null) {
            }
            function02.invoke();
        } else {
        }
        function02 = null;
        if (var4 == null) {
            if (function0 != null) {
            }
            function0.invoke();
        } else {
        }
        function0 = null;
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        CrystalServiceComponent2.INSTANCE.executeAction();
        if (playerEntity != null) {
            float var27 = (1.0F - RangesKt.coerceIn((SharedKt.getPlayer().distanceTo(playerEntity) / 12.0F), 0.0F, 1.0F));
            Entity entity = playerEntity;
            StackShaderComponent3.INSTANCE.render(arg0.getStack(), entity);
            if (var29 != null) {
                StackShaderComponent3.INSTANCE.render(arg0.getStack(), playerEntity);
            }
        }
        SideServiceComponent var30 = sideServiceComponent;
        easingServiceComponent.executeAction(0.0F);
        this.render(arg0.getStack(), StringsKt.replace$default(StringsKt.replace$default(this.getTextPattern(), "damage", String.valueOf(NameTagsModule.INSTANCE.computeValue(var30.getNumericValue()))), "self", String.valueOf(NameTagsModule.INSTANCE.computeValue(var30.getNumericValue2()))), new Box(var30.getMinecraftObject()));
    }

    private void onRender2DEvent(Render2DEvent arg0) {
        if (playerEntity == null) {
            return;
        }
        StackShaderComponent3.INSTANCE.executeAction();
    }

    private void onAfterEntitySpawn(AfterEntitySpawn arg0) {
        Object var13 = arg0;
        int var14 = 0;
        if (var12 == null) {
            if (var13.getEntity() instanceof EndCrystalEntity && INSTANCE.getSpawnTiming() == AutoCrystalSpawnTimingMode.ADD_TO_WORLD) {
            }
            INSTANCE.executeAction(var13.getEntity().method_5628(), INSTANCE.resolveMinecraftObject(var13.getEntity()));
        }
    }

    private void onReceivePacket(ReceivePacket arg0) {
        Packet var19 = arg0.getPacket();
        int var20 = 0;
        if (var19 instanceof class_2604) {
            ServiceComponent131.INSTANCE.resolveUnit((class_2604) var19.method_11167());
            if (var17 == null && var17 == null) {
                if (var17 == null) {
                }
                if (var17 == null) {
                }
                if (var17 == null) {
                    if (INSTANCE.getAsyncCalc()) {
                        new Thread(this::handlePacket).start();
                        if (Intrinsics.areEqual((class_2604) var19.method_11169(), class_1299.field_6110) && playerEntity != null && INSTANCE.getSpawnTiming() == AutoCrystalSpawnTimingMode.PACKET && var17 != null) {
                        }
                    }
                    INSTANCE.executeAction((class_2604) var19.method_11167(), new Vec3d((class_2604) var19.method_11175(), (class_2604) var19.method_11174(), (class_2604) var19.method_11176()));
                }
            }
        }
        if (var17 == null) {
            if (var19 instanceof class_2664) {
                Iterator iterator = Lists.newArrayList(SharedKt.getWorld().method_18112()).iterator();
                if (iterator.hasNext()) {
                    Entity entity = iterator.next();
                    if (var17 == null) {
                        if (var17 == null) {
                        }
                        if (var17 == null) {
                            if (var17 == null) {
                            }
                        }
                        CrystalServiceComponent2.INSTANCE.resolveLong((EndCrystalEntity) entity.method_5628(), SharedKt.getNumericValue());
                    }
                }
            }
        }
        if (var19 instanceof class_2663) {
            if ((class_2663) var19.method_11470() == 3) {
                if (playerEntity != null) {
                    if (var17 == null && var17 == null && var17 == null) {
                        if ((ClientboundEntityEventPacketAccessor) var19.getEntityId() == playerEntity.method_5628()) {
                            serviceComponent10.executeAction();
                        }
                    }
                }
            }
        }
        if (var17 == null) {
        }
        if (var17 == null) {
            if (!(Intrinsics.areEqual((class_2767) var19.method_11894().comp_349(), class_3417.field_14785))) {
            }
            if (var17 == null) {
                if (!(Intrinsics.areEqual((class_2767) var19.method_11894().comp_349(), class_3417.field_14833))) {
                }
                if (var19 instanceof class_2767 && Intrinsics.areEqual((class_2767) var19.method_11894().comp_349(), class_3417.field_14727)) {
                }
            }
            DamageSyncServiceComponent.INSTANCE.executeAction();
        }
        MessageServiceComponent.S(this, "AUTO CRYSTAL PACKET HANDLE ERROR");
        var18.printStackTrace();
    }

    private void onSendPacket(SendPacket arg0) {
        if (var6 == null) {
        }
        if (var6 == null) {
            if (countValue5 > 0) {
            }
            int var7 = countValue5;
            countValue5 = (var7 + -1);
            return;
        }
        serviceComponent384.updateValue();
    }

    private void executeAction(int arg0, Vec3d arg1) {
        if (var35 != null || CrystalServiceComponent2.INSTANCE.resolvePlaceServiceComponent(arg1) == null) {
            return;
        }
        PlaceServiceComponent var36 = CrystalServiceComponent2.INSTANCE.resolvePlaceServiceComponent(arg1);
        timestampValue = (SharedKt.getNumericValue() - var36.getNumericValue());
        ServiceComponent.INSTANCE.updateValue();
        PlayerEntity player = playerEntity;
        int var38 = 0;
        if (var35 == null) {
        }
        if (var35 == null) {
        }
        if (var35 == null) {
            if (var35 == null) {
            }
            if (player != null && serviceComponent382.checkCondition(INSTANCE.getBreakDelay()) && INSTANCE.getOnCrystalSpawn() != AutoCrystalOnCrystalSpawnMode.NO_REACTION && !(INSTANCE.checkCondition()) && INSTANCE.getMultiAction() && !(INSTANCE.getRandomizeDelay())) {
            }
            EntitiesEntityHelper var39 = INSTANCE.resolveEntitiesEntityHelper(player);
            if (var35 == null) {
                if (INSTANCE.getRotate()) {
                }
                INSTANCE.updateValue(arg1);
            }
            if (ConfigStateServiceComponent.INSTANCE.resolveServiceComponent95(INSTANCE, arg1, 0, 0) != null) {
                INSTANCE.executeAction(arg0, arg1, 1);
            }
            if (var35 == null) {
                if (INSTANCE.getOnCrystalSpawn() == AutoCrystalOnCrystalSpawnMode.ACTION_X && serviceComponent38.checkCondition(INSTANCE.getPlaceDelay())) {
                    if (var35 == null) {
                    }
                    if ((DamageDataServiceComponent) atomicReference.get() != null) {
                        DamageDataServiceComponent var40 = (DamageDataServiceComponent) atomicReference.get();
                        int var41 = 0;
                        INSTANCE.executeAction((class_3965) var40.getObject(), 1);
                    } else {
                    }
                }
            }
        }
    }

    private void onRenderEntityEvent(RenderEntityEvent arg0) {
        if (var11 == null) {
        }
        int var12 = this.getRemoveDelay();
        long var13 = (SharedKt.getNumericValue() - CrystalServiceComponent2.INSTANCE.computeValue(arg0.getState().method_5628()));
        if (var11 == null) {
            if (var12 <= var13) {
            }
            if (var11 == null) {
                if (var13 < 201L) {
                }
            }
        } else {
        }
        arg0.cancel();
    }

    private void updateValue4() {
        DamageDataServiceComponent var23 = (DamageDataServiceComponent) atomicReference.get();
        CrystalServiceComponent var24 = (CrystalServiceComponent) atomicReference2.get();
        if (var22 == null) {
            if (!(this.checkCondition())) {
            }
            if (!(this.getMultiAction())) {
            }
            if (var24 != null && serviceComponent382.checkCondition(this.getBreakDelay())) {
                this.executeAction(var24.getMinecraftObject().method_5628(), this.resolveMinecraftObject(var24.getMinecraftObject()), 0);
            }
            this.executeAction((class_3965) var23.getObject(), 0);
        }
        if (var24 != null) {
            Object var25 = var24;
            int var26 = 0;
            if (var22 == null) {
                if (serviceComponent382.checkCondition(INSTANCE.getBreakDelay())) {
                    INSTANCE.executeAction(var25.getMinecraftObject().method_5628(), INSTANCE.resolveMinecraftObject(var25.getMinecraftObject()), 0);
                }
            }
        } else {
        }
        if (var23 != null) {
            var25 = var23;
            var26 = 0;
            if (var22 == null) {
                if (serviceComponent38.checkCondition(INSTANCE.getPlaceDelay())) {
                    INSTANCE.executeAction((class_3965) var25.getObject(), 0);
                }
            }
        } else {
        }
    }

    private void executeAction(EntitiesEntityHelper arg0) {
        atomicReference.set(ConfigStateEntityHelper.resolveDamageDataServiceComponent(this, arg0));
        atomicReference2.set(ConfigStateServiceComponent.INSTANCE.resolveCrystalServiceComponent(this, arg0));
    }

    private boolean checkCondition() {
        DamageDataServiceComponent var14 = (DamageDataServiceComponent) atomicReference.get();
        if (var13 == null) {
            if (this.getRayTrace()) {
                if (var14 == null) {
                }
            }
            return false;
        }
        Vec3d vec = VecPacketHelper.INSTANCE.resolveMinecraftObject(SharedKt.getPlayer());
        Vec3d vec2 = (class_3965) var14.getObject().method_17784();
        Vec3d vec3 = (class_3965) var14.getObject().method_17777().toCenterPos().method_1031(0.0D, 0.5D, 0.0D);
        Box var18 = new Box((vec3.field_1352 - 1.0F), vec3.field_1351, (vec3.field_1350 - 1.0F), (vec3.field_1352 + 1.0F), (vec3.field_1351 + 2.0F), (vec3.field_1350 + 1.0F));
        if (var13 == null) {
        }
        if (var13 == null) {
        }
        if (var13 == null) {
            if (var18.method_992(vec, vec2).isEmpty() && !(var18.method_1006(vec)) && !(var18.method_1006(vec2))) {
            }
            return true;
        }
        class_3965 var19 = ExplosionPosEntityHelper.resolveMinecraftObject(vec, vec2);
        if (var13 == null) {
        }
        if (var13 == null) {
        }
        if (var13 == null) {
            if (Intrinsics.areEqual(var19.method_17777(), (class_3965) var14.getObject().method_17777())) {
                if (var19 != null && var19.method_17783() != class_240.field_1333 && var19.method_17780() != (class_3965) var14.getObject().method_17780()) {
                }
            }
        } else {
        }
        return false;
    }

    private void render(MatrixStack arg0, String arg1, Box arg2) {
        Color var25 = NewThemeRenderHelper.INSTANCE.getColor2();
        if (var24 == null) {
            if (this.getRenderMode() == AutoCrystalRenderMode.SHADER) {
                TextShaderComponent2.checkCondition(arg2, PolygonShaderComponent.INSTANCE.resolveColor((this.getAlpha() * easingServiceComponent.getNumericValue())));
            }
        }
        if (this.getRenderMode() == AutoCrystalRenderMode.DEAFULT) {
            TextShaderComponent2.checkCondition(arg2, PolygonShaderComponent.INSTANCE.resolveColor((this.getAlpha() * easingServiceComponent.getNumericValue())));
            TextShaderComponent2.checkCondition(arg2, PolygonShaderComponent.INSTANCE.resolveColor(easingServiceComponent.getNumericValue()));
            if (var24 != null && var24 != null) {
            }
            BoxShaderComponent.INSTANCE.render(arg0, arg2);
        }
        TextShaderComponent2.executeAction(arg1, arg2.method_1005(), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor7(), easingServiceComponent.getNumericValue()), 0.0F, 0.0F);
    }

    private boolean checkCondition(boolean arg0) {
        boolean var45 = SharedKt.getPlayer().method_6079().getItem() instanceof class_1774;
        boolean var46 = SharedKt.getPlayer().method_6047().getItem() instanceof class_1774;
        if (!(Intrinsics.areEqual(SharedKt.getPlayer().method_6047().getItem(), Items.field_8367))) {
            if (var44 == null && var44 == null) {
                if (Intrinsics.areEqual(SharedKt.getPlayer().method_6047().getItem(), Items.field_8463)) {
                }
            }
        } else {
        }
        int var47 = 0;
        if (var44 == null) {
            if (!(serviceComponent10.checkCondition(500))) {
                return true;
            }
        }
        if (var44 == null) {
            if (AutoMendModule.INSTANCE.isActive()) {
                return true;
            }
        }
        if (var44 == null) {
            if (BlinkModule.INSTANCE.getEnabled()) {
                return true;
            }
        }
        if (var44 == null) {
            if (SpeedMineModule.INSTANCE.getAtomicBoolean().get()) {
                return true;
            }
        }
        if (SharedKt.getInteractionManager().method_2923()) {
            if (!(var45)) {
                if (var44 == null && var44 == null && var44 == null) {
                    if (this.getMining()) {
                        return true;
                    }
                }
            }
        }
        if (!(arg0)) {
            if (this.getSwitchPause() > 0) {
                if (var44 == null && var44 == null && var44 == null) {
                    if (!(serviceComponent384.checkCondition(this.getSwitchPause()))) {
                        return true;
                    }
                }
            }
        }
        if (this.getOffHandPause() > 0) {
            if (var44 == null && var44 == null) {
                if ((5 - OffhandModule.INSTANCE.getNumericValue()) < this.getOffHandPause()) {
                    return true;
                }
            }
        }
        if (var44 == null) {
            if (arg0) {
                if (var44 == null) {
                    if (var44 == null) {
                    }
                    if (var44 == null) {
                        if (this.getAutoSwitch() == AutoCrystalAutoSwitchMode.NONE && !(var45) && !(var46)) {
                        }
                        return true;
                    }
                }
                if (var44 == null) {
                    if (this.getAutoSwitch() != AutoCrystalAutoSwitchMode.SILENT) {
                    }
                    if (var44 == null) {
                        if (this.getAutoSwitch() == AutoCrystalAutoSwitchMode.NORMAL) {
                        }
                        Item[] var48 = new Item[1];
                        var48[0] = Items.field_8301;
                        if (var44 == null) {
                        }
                        if (var44 == null) {
                            if (!(ItemPacketHelper.INSTANCE.resolveStackServiceComponent2().isActive()) && !(var45)) {
                            }
                            return true;
                        }
                    }
                }
                if (this.getAutoSwitch() == AutoCrystalAutoSwitchMode.INVENTORY) {
                    var48 = new Item[1];
                    var48[0] = Items.field_8301;
                    if (!(ItemPacketHelper.INSTANCE.resolveStackServiceComponent2().isActive())) {
                        if (var44 == null && var44 == null) {
                            if (!(var45)) {
                                return true;
                            }
                        }
                    }
                }
                if (var44 == null) {
                    if (SpeedMineModule.resolveList().isEmpty()) {
                        atomicBoolean.set(0);
                    }
                }
                if (var44 == null) {
                    if (atomicBoolean.get()) {
                        return true;
                    }
                }
            }
        }
        if (SharedKt.getPlayer().method_6115()) {
            if (var44 == null && var44 == null) {
                if (this.getEating()) {
                    return true;
                }
            }
        }
        if (this.getInventory()) {
            if (var44 == null && var44 == null) {
                if (EventPacketHelper2.INSTANCE.isActive2()) {
                    return true;
                }
            }
        }
        if (!(var45)) {
            if (this.getGappleSwitch()) {
                if (SharedKt.getMc().options.field_1904.method_1434()) {
                    if (var44 == null && var44 == null && var44 == null && var44 == null) {
                        if (var44 == null) {
                        }
                        if (var47 && this.getAutoSwitch() != AutoCrystalAutoSwitchMode.SILENT && this.getAutoSwitch() != AutoCrystalAutoSwitchMode.INVENTORY) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private void executeAction(int arg0, Vec3d arg1, boolean arg2) {
        if (CrystalServiceComponent2.INSTANCE.checkCondition(arg0)) {
            if (var18 == null && var18 == null) {
            }
        }
        if (this.getLimitBreak() || this.checkCondition(0) || playerEntity == null) {
            return;
        }
        if (this.getRotate()) {
            if (var18 == null && var18 == null) {
                if (!(arg2)) {
                    if (this.getTiming() == AutoCrystalTimingMode.VANILLA) {
                        if (var18 == null) {
                            if (!(enabledFlag3)) {
                            }
                        } else {
                        }
                        enabledFlag3 = 0;
                    }
                    Box var19 = new Box(arg1.method_1023(1.0D, 0.0D, 1.0D), arg1.method_1031(1.0D, 2.0D, 1.0D));
                    if (var18 == null) {
                    }
                    if (this.getCrystalMultiPoint() && !(var19.method_1006(SharedKt.getPlayer().getEyePos()))) {
                    }
                    new Vec3d(RangesKt.coerceIn(SharedKt.getPlayer().getEyePos().field_1352, (arg1.field_1352 - 1.0D), (arg1.field_1352 + 1.0D)), RangesKt.coerceIn(SharedKt.getPlayer().getEyePos().field_1351, arg1.field_1351, (arg1.field_1351 + 2.0D)), RangesKt.coerceIn(SharedKt.getPlayer().getEyePos().field_1350, (arg1.field_1350 - 1.0D), (arg1.field_1350 + 1.0D))).updateValue(arg1.method_1031(0.0D, 0.5D, 0.0D));
                    enabledFlag4 = 1;
                }
            }
        }
        function02 = this::resolveUnit;
        if (var18 == null) {
            if (this.getTiming() != AutoCrystalTimingMode.VANILLA) {
            }
        }
        function02.invoke();
        function02 = null;
    }

    private void executeAction(Function0 arg0) {
        int var21 = 0;
        class_1293 var22 = SharedKt.getPlayer().method_6112(class_1294.field_5911);
        class_1293 var23 = SharedKt.getPlayer().method_6112(class_1294.field_5910);
        int var24 = -1;
        StackServiceComponent2 var25 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent22();
        StackServiceComponent2 var26 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(ServiceComponent11.INSTANCE);
        if (this.getAntiWeakness() != AutoCrystalAutoSwitchMode.NONE) {
            if (var20 == null && var20 == null) {
                if (var20 == null) {
                    if (var23 != null) {
                    }
                    if (var20 == null) {
                        if (var22 != null && var23.method_5578() < var22.method_5578()) {
                        }
                        var24 = this.computeValue(this.getAntiWeakness());
                    }
                }
            }
            arg0.invoke();
            if (var20 == null) {
            }
        }
        if (var20 == null) {
        }
        HandServiceComponent.executeAction(SharedKt.getPlayer().method_31548().method_67532(), class_1713.field_7791, 1);
        if (this.getAntiWeakness() == AutoCrystalAutoSwitchMode.SILENT) {
            int var27 = countValue5;
            countValue5 = (var27 + 1);
        }
        ItemPacketHelper.INSTANCE.executeAction();
    }

    public void executeAction(class_3965 bhr, boolean instant) {
        if (var45 == null) {
            if (this.checkCondition(1)) {
                return;
            }
            if (var45 == null) {
            }
            if (CrystalServiceComponent2.INSTANCE.checkCondition(bhr.method_17777(), this.getLimitPlace())) {
                return;
            }
        }
        DamageDataServiceComponent var46 = (DamageDataServiceComponent) atomicReference.get();
        if (var45 == null) {
            if (var46 != null) {
            }
            var46.getServiceComponent95();
        }
        if (0L > 0L) {
            if (var45 == null) {
            }
        }
        if (var45 == null) {
            if (this.getRandomizeDelay() && !((countValue4 % 5))) {
            }
        } else {
        }
        float var39 = this.getMinDamage();
        float var40 = this.getStacksLeft();
        boolean var41 = this.getLowCrystals();
        boolean var42 = this.getFacePlaceSync();
        AutoCrystalDamageSyncMode var43 = this.getDamageSync();
        int var44 = 0;
        if (0L >= 0) {
            if (var45 == null) {
                if (!(null.checkCondition(1))) {
                    return;
                }
                var39 = this.resolveEntitiesEntityHelper();
                var40 = 0;
                var41 = bhr.method_17777();
            }
        }
        if (0L >= 0 && var45 == null) {
            if (ConfigStateEntityHelper.checkCondition(this)) {
                return;
            }
            if (0L > 0L && var45 == null) {
            }
            if (0L >= 0L) {
            }
            if (this.getRotate() && !(enabledFlag4)) {
                if (var45 == null) {
                    if (this.getTiming() == AutoCrystalTimingMode.SEQUENTIAL) {
                        if (var45 == null) {
                            if (!(enabledFlag3)) {
                            }
                        } else {
                        }
                        enabledFlag3 = 0;
                    }
                }
                this.updateValue(bhr.method_17784());
            }
            if (0L >= 0) {
                if (var45 == null) {
                    function0 = this::resolveUnit;
                }
                if (this.getTiming() != AutoCrystalTimingMode.VANILLA) {
                }
            }
        }
        if (var45 == null) {
            if (function0 != null) {
            }
            function0.invoke();
        } else {
        }
        function0 = null;
    }

    private int computeValue(StackServiceComponent2 arg0, StackServiceComponent2 arg1, AutoCrystalAutoSwitchMode arg2) {
        int var13 = SharedKt.getPlayer().method_31548().method_67532();
        if (var12 == null && var12 == null) {
            if (arg1.isActive()) {
                HandServiceComponent.executeAction(arg1.getNumericValue(), SharedKt.getPlayer().method_31548().method_67532(), class_1713.field_7791, 1);
                return arg1.getNumericValue();
                if (arg2 == AutoCrystalAutoSwitchMode.SILENT) {
                    int var14 = countValue5;
                    countValue5 = (var14 + 1);
                }
                arg0.updateValue();
            }
        }
        return var13;
    }

    private void executeAction(int arg0, int arg1, boolean arg2, long arg3, short arg4, boolean arg5) {
        if (this.getAutoSwitch() != AutoCrystalAutoSwitchMode.SILENT) {
            if (arg4 <= 0) {
                if (var19 == null) {
                }
            }
        }
        if (arg3 > 0L) {
            if (var19 == null) {
            }
        }
        if (arg3 >= 0L && var19 == null) {
            if (arg2) {
            }
            if (arg3 >= 0L) {
                if (var19 == null) {
                    if (arg1 < 9) {
                    }
                }
            } else {
            }
            HandServiceComponent.executeAction(arg1, SharedKt.getPlayer().method_31548().method_67532(), class_1713.field_7791, 1);
        }
        int var20 = countValue5;
        countValue5 = (var20 + 1);
        ItemPacketHelper.INSTANCE.executeAction(arg0);
    }

    private void executeAction(class_3965 arg0) {
        Item[] var20 = new Item[1];
        var20[0] = Items.field_8276;
        StackServiceComponent2 var19 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2();
        Item[] var21 = new Item[1];
        var21[0] = Items.field_8725;
        var20 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2();
        Item[] var22 = new Item[1];
        var22[0] = Items.field_8810;
        var21 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2();
        if (var18 == null) {
            if (var19.isActive()) {
            }
            if (var18 == null) {
            }
            if (var20.isActive()) {
            }
        } else {
        }
        var22 = var21;
        if (var18 == null) {
            ItemPacketHelper.INSTANCE.executeAction(var22.getNumericValue());
            SharedKt.getInteractionManager().method_2896(SharedKt.getPlayer(), Hand.field_5808, new class_3965(arg0.method_17777().toCenterPos().method_1031(0.0D, 0.5D, 0.0D), Direction.UP, arg0.method_17777(), 0));
            PacketPacketHelper.handlePacket((Packet) new class_2879(Hand.field_5808));
            PacketPacketHelper.handlePacket((Packet) new class_2846(class_2847.field_12968, arg0.method_17777().up(), Direction.UP));
        }
        SharedKt.getInteractionManager().method_2899(arg0.method_17777().up());
        ItemPacketHelper.INSTANCE.updateValue2();
    }

    public boolean checkCondition(BlockPos base, ArrayList entities) {
        Box var6 = new Box(base.up());
        if (var5 != null) {
        }
        return entities.stream().anyMatch(this::checkCondition);
    }

    public void executeAction(boolean offHand, boolean attack) {
        if (!(attack)) {
            if (offHand) {
            }
            Hand.field_5810.method_6104(Hand.field_5808);
        }
        if (offHand) {
        }
        Hand.field_5810.<init>(Hand.field_5808);
        PacketPacketHelper.handlePacket((Packet) new class_2879);
    }

    public int computeValue() {
        if (var10 == null) {
        }
        return new NoWhenBranchMatchedException();
    }

    public int computeValue(boolean place) {
        if (var14 == null) {
        }
        if (var14 == null) {
            if (place) {
            }
        }
        if (var14 == null) {
            if (place) {
            }
        }
        if (0L >= 0) {
            if (new NoWhenBranchMatchedException() != null) {
            }
        }
        return 0;
    }

    public boolean checkCondition(int arg0, short arg1, int arg2) {
        PlayerEntity player = playerEntity;
        if (player == null) {
            return false;
        }
        Iterator iterator = Lists.newArrayList(SharedKt.getWorld().method_18112()).iterator();
        if (iterator.hasNext()) {
            Entity entity = iterator.next();
            if (arg2 > 0) {
                if (var8 == null) {
                }
                if (arg2 >= 0) {
                    if (var8 == null) {
                    }
                }
                if (arg2 >= 0) {
                    if (var8 == null) {
                    }
                    if (arg0 >= 0) {
                    }
                    if (var8 == null) {
                        if (entity instanceof class_1542 && Intrinsics.areEqual((class_1542) entity.method_6983().getItem(), Items.field_8281) && (class_1542) entity.method_6983().method_7947() >= 8) {
                        }
                    }
                    if (!((class_1542) entity.isAlive())) {
                    }
                }
                Box var12 = player.method_5829();
                if (var8 == null) {
                    if (!((class_1542) entity.method_5829().method_994(var12.method_35575(var12.method_1005().method_10214()).method_1009(0.5D, 0.0D, 0.5D)))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public void updateValue(Vec3d v) {
        serviceComponent102.executeAction();
        atomicReference3.set(v);
    }

    private EntitiesEntityHelper resolveEntitiesEntityHelper(PlayerEntity arg0) {
        return new EntitiesEntityHelper(Lists.newArrayList(SharedKt.getWorld().method_18112()), arg0, this.getPlaceRange(), this.getExplodeRange(), this.getMaxSelfDamage(), this.getMinDamage(), this.getOldVer(), this.getArmorScale(), this.getFacePlaceHp(), this.getOverrideSelfDamage(), this.getEfficiencyFactor(), this.getRayTrace(), this.getFriendProtection(), this.getRemoveFire(), this.getTerrainIgnore(), this.getLethalMultiplier(), this.getMinimizeSelfDamage(), this.getMaxDamageReduction(), this.getCalcShields(), this.getRemoveLava(), this.getGrimBreakRange(), this.getExplodeEChestFarm(), this.getAntiPortal(), this.getAntiQuiver(), this.getOverrideMinDamage());
    }

    public EntitiesEntityHelper resolveEntitiesEntityHelper() {
        return this.resolveEntitiesEntityHelper(playerEntity);
    }

    private static boolean isActive2() {
        return INSTANCE.getPredict() == AutoCrystalPredictMode.CUSTOM;
    }

    private static boolean isActive3() {
        if (var4 == null) {
            if (!(INSTANCE.getGrimBreakRange())) {
            }
        } else {
        }
        return false;
    }

    private static boolean isActive4() {
        return INSTANCE.getOverrideMinDamage();
    }

    private static boolean isActive5() {
        return INSTANCE.getOverrideMinDamage();
    }

    private static boolean isActive6() {
        return INSTANCE.getOverrideMinDamage();
    }

    private static boolean isActive7() {
        return INSTANCE.getOverrideMinDamage();
    }

    private static boolean isActive8() {
        return INSTANCE.getOverrideMinDamage();
    }

    private static boolean isActive9() {
        return INSTANCE.getDamageSync() == AutoCrystalDamageSyncMode.CONDITIONS;
    }

    private static boolean isActive10() {
        return INSTANCE.getDamageSync() == AutoCrystalDamageSyncMode.CONDITIONS;
    }

    private static boolean isActive11() {
        if (var6 == null) {
        }
        if (var6 == null) {
            if (INSTANCE.getDamageSync() == AutoCrystalDamageSyncMode.CONDITIONS && INSTANCE.getLowCrystals()) {
            }
        } else {
        }
        return false;
    }

    private static boolean isActive12() {
        return INSTANCE.getMinimizeSelfDamage();
    }

    private static boolean isActive13() {
        return INSTANCE.getFakeCrystalRemove();
    }

    private static void updateValue(EntitiesEntityHelper arg0) {
        INSTANCE.executeAction(arg0);
    }

    private static void handlePacket(Packet arg0) {
        INSTANCE.executeAction((class_2604) arg0.method_11167(), new Vec3d((class_2604) arg0.method_11175(), (class_2604) arg0.method_11174(), (class_2604) arg0.method_11176()));
    }

    private static Unit resolveUnit(int arg0, Vec3d arg1) {
        AutoCrystalModule var37 = INSTANCE;
        int var38 = 0;
        class_1293 var39 = SharedKt.getPlayer().method_6112(class_1294.field_5911);
        class_1293 var40 = SharedKt.getPlayer().method_6112(class_1294.field_5910);
        int var41 = -1;
        StackServiceComponent2 var42 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent22();
        StackServiceComponent2 var43 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(ServiceComponent11.INSTANCE);
        if (var36 == null) {
        }
        if (var36 == null) {
            if (var40 != null) {
            }
            if (var36 == null) {
                if (var37.getAntiWeakness() != AutoCrystalAutoSwitchMode.NONE && var39 != null && var40.method_5578() < var39.method_5578()) {
                }
                var41 = var37.computeValue(var37.getAntiWeakness());
            }
        }
        int var44 = 0;
        class_2824 var45 = class_2824.method_34206(SharedKt.getPlayer(), SharedKt.getPlayer().method_5715());
        ServiceComponent93.executeAction(arg0);
        PacketPacketHelper.handlePacket((Packet) var45);
        CrystalServiceComponent2.INSTANCE.executeAction(TuplesKt.to(Integer.valueOf(arg0), arg1));
        Iterable var46 = (Iterable) Lists.newArrayList(SharedKt.getWorld().method_18112());
        int var47 = 0;
        Object var48 = var46;
        Collection var49 = (Collection) new ArrayList();
        int var50 = 0;
        Iterator iterator = var48.iterator();
        if (iterator.hasNext()) {
            if (var36 == null) {
                Object var52 = iterator.next();
                Entity entity = var52;
                int var54 = 0;
                if (var36 == null) {
                }
                if (var36 == null) {
                    if (entity instanceof class_1542 && arg1.method_1025(INSTANCE.resolveMinecraftObject(entity)) < 2.25D) {
                    }
                } else {
                }
                var49.add();
            }
        }
        Iterator iterator2 = var49.iterator();
        if (iterator2.hasNext()) {
            var46 = iterator2.next();
            CrystalServiceComponent2.INSTANCE.resolveLong(var46.method_5628(), SharedKt.getNumericValue());
            if (var36 == null) {
            }
            INSTANCE.executeAction(0, 1);
            serviceComponent382.updateValue();
        }
        iterator2 = countValue4;
        countValue4 = (iterator2 + 1);
        if (var36 == null) {
            if (var36 == null) {
            }
            HandServiceComponent.executeAction(SharedKt.getPlayer().method_31548().method_67532(), class_1713.field_7791, 1);
            if (var41 != -1 && var36 != null) {
                if (var37.getAntiWeakness() == AutoCrystalAutoSwitchMode.SILENT) {
                    countValue5 = (countValue5 + 1);
                }
                ItemPacketHelper.INSTANCE.executeAction();
            }
        }
        return Unit.INSTANCE;
    }

    private static Packet resolveMinecraftObject(boolean arg0, class_3965 arg1, int arg2) {
        if (arg0) {
        }
        Hand.field_5810.<init>(Hand.field_5808, arg1, arg2);
        return (Packet) new class_2885;
    }

    private static Unit resolveUnit(class_3965 arg0, DamageDataServiceComponent arg1) {
        Block var93 = SharedKt.getWorld().getBlockState(arg0.method_17777().up()).getBlock();
        int var94 = -1;
        boolean var95 = SharedKt.getPlayer().method_6079().getItem() instanceof class_1774;
        if (!(SharedKt.getPlayer().method_6047().getItem() instanceof class_1774)) {
            if (var92 == null && var92 == null) {
                if (var95) {
                }
            }
        } else {
        }
        int var96 = 0;
        Item[] var98 = new Item[1];
        var98[0] = Items.field_8301;
        int var97 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2().getNumericValue();
        var98 = INSTANCE.getAutoSwitch() == AutoCrystalAutoSwitchMode.INVENTORY;
        int var99 = 0;
        int var100 = 0;
        if (INSTANCE.getRemoveFire()) {
            if (var92 == null && var92 == null) {
                if (Intrinsics.areEqual(Blocks.field_10036)) {
                    PacketPacketHelper.handlePacket((Packet) new class_2846(class_2847.field_12968, arg0.method_17777().up(), Direction.UP));
                    PacketPacketHelper.handlePacket((Packet) new class_2879(Hand.field_5808));
                }
            }
        }
        if (INSTANCE.getRemoveLava()) {
            if (INSTANCE.getRemoveFire()) {
                if (var92 == null && var92 == null && var92 == null) {
                    if (Intrinsics.areEqual(Blocks.field_10589)) {
                        PacketPacketHelper.handlePacket((Packet) new class_2846(class_2847.field_12968, arg0.method_17777().up(), Direction.UP));
                        SharedKt.getInteractionManager().method_2899(arg0.method_17777().up());
                        PacketPacketHelper.handlePacket((Packet) new class_2879(Hand.field_5808));
                    }
                }
            }
        }
        if (INSTANCE.getRemoveLava()) {
            if (var92 == null && var92 == null) {
                if (Intrinsics.areEqual(Blocks.field_10164)) {
                    INSTANCE.executeAction(arg0);
                }
            }
        }
        if (!(var96)) {
            if (var92 == null) {
                if (!((Collection) SpeedMineModule.resolveList().isEmpty())) {
                }
            } else {
            }
            if (0) {
                if (var92 == null && var92 == null) {
                    if (SpeedMineModule.INSTANCE.getResetOnSwitch() && SpeedMineModule.INSTANCE.getSwitchMode() == SpeedMineSwitchMode.Alternative) {
                        var100 = 1;
                        var98 = 1;
                    }
                }
            }
        }
        if (var98) {
            if (var92 == null && var92 == null) {
                if (!(SharedKt.getPlayer().field_7512.method_34255().isEmpty())) {
                    return Unit.INSTANCE;
                }
            }
        }
        if (var92 == null) {
        }
        if (var98 && var97 == -1) {
            Item[] var101 = new Item[1];
            var101[0] = Items.field_8301;
            var97 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2().getNumericValue();
        }
        if (var92 == null) {
            if (var92 == null) {
                if (INSTANCE.getAutoSwitch() != AutoCrystalAutoSwitchMode.NONE && !(var96) && var97 != -1) {
                    var94 = SharedKt.getPlayer().method_31548().method_67532();
                    if (var92 == null) {
                        if (var98) {
                        }
                        if (var92 == null) {
                            if (var97 < 9) {
                            }
                        } else {
                        }
                        HandServiceComponent.executeAction(SharedKt.getPlayer().method_31548().method_67532(), class_1713.field_7791, 1);
                        var99 = 1;
                        atomicBoolean.set();
                        if (var92 != null) {
                        }
                        if (INSTANCE.getAutoSwitch() == AutoCrystalAutoSwitchMode.SILENT) {
                            var101 = countValue5;
                            countValue5 = (var101 + 1);
                        }
                        ItemPacketHelper.INSTANCE.executeAction();
                    }
                }
            }
            if (var92 == null) {
            }
            if (var97 != -1) {
            }
        }
        if (var92 == null) {
            if (INSTANCE.getAutoSwitch() == AutoCrystalAutoSwitchMode.NONE && !(var96)) {
                return Unit.INSTANCE;
            }
        }
        if (!(SharedKt.getPlayer().method_6047().getItem() instanceof class_1774)) {
            if (var92 == null && var92 == null) {
                if (!(var95)) {
                    if (var92 == null) {
                        if (INSTANCE.getAutoSwitch() == AutoCrystalAutoSwitchMode.SILENT) {
                        }
                    }
                    BlockPos blockPos = arg0.method_17777();
                    CrystalServiceComponent2.INSTANCE.executeAction(blockPos);
                }
                PacketPacketHelper.executeAction(this::resolveMinecraftObject);
            }
            if (arg1 != null && arg1.getServiceComponent95() != null) {
            } else {
                arg1.getServiceComponent95().getNumericValue();
            }
            if (arg1 != null && arg1.getServiceComponent95() != null) {
            } else {
                arg1.getServiceComponent95().getNumericValue2();
            }
            blockPos = 1.0F;
            float var89 = 1.0F;
            Direction var90 = arg0.method_17780();
            BlockPos blockPos2 = arg0.method_17777();
            sideServiceComponent = new SideServiceComponent(blockPos2, blockPos);
            INSTANCE.executeAction(0);
            ServiceComponent45.INSTANCE.executeAction(arg0.method_17777());
            var101 = (Iterable) ServiceComponent74.enumEntries;
            int var102 = 0;
            Iterator iterator = var101.iterator();
            if (iterator.hasNext()) {
                Object var104 = iterator.next();
                Direction var105 = (Direction) var104;
                int var106 = 0;
                ServiceComponent45.INSTANCE.executeAction(arg0.method_17777().offset());
                if (var92 == null) {
                }
            }
            if (var92 == null) {
                if (INSTANCE.getRenderMode() == AutoCrystalRenderMode.TECHNO) {
                    BoxShaderComponent.INSTANCE.updateValue();
                }
            }
            if (var92 == null) {
            }
            if (var92 == null) {
                if (INSTANCE.getIdPredictOnlyDuels()) {
                    if (var92 == null) {
                        if (SharedKt.getWorld().method_8621().method_11965() == 100.0D) {
                        }
                    } else {
                    }
                }
            }
            if (var92 == null) {
                if (INSTANCE.getOnlyBreakingSurr()) {
                    if (var92 == null) {
                        if (!((Collection) SpeedMineModule.INSTANCE.resolveList(0).isEmpty())) {
                        }
                    } else {
                    }
                    if (INSTANCE.getIdPredict() && 0 && 0) {
                    }
                    ServiceComponent131.INSTANCE.executeAction(INSTANCE.getIdOffset(), INSTANCE.getIdAttacks(), INSTANCE.getIdDelay(), INSTANCE.getSwingOnce());
                }
                if (var92 == null) {
                    if (!(enabledFlag2)) {
                        enabledFlag2 = 1;
                        INSTANCE.executeAction(arg0, 1);
                    }
                }
                enabledFlag2 = 0;
            }
            serviceComponent38.updateValue();
            if (var92 == null) {
                if (arg1 != null && arg1.getServiceComponent95() != null) {
                }
                arg1.getServiceComponent95().getNumericValue();
            }
            DamageSyncServiceComponent.INSTANCE.executeAction(0.0F);
            linkedList.add(arg0.method_17777());
            if (linkedList.size() > 10) {
                linkedList.poll();
                if (var92 == null) {
                }
                easingServiceComponent.updateValue2(1.0F);
            }
            INSTANCE.executeAction();
        }
        return Unit.INSTANCE;
    }

    private static boolean checkCondition(Box arg0, Entity arg1) {
        if (var4 == null) {
        }
        if (var4 == null) {
        }
        if (var4 == null) {
            if (arg1 != null && arg1.method_5829().method_994(arg0) && arg1 instanceof EndCrystalEntity) {
            }
        } else {
        }
        return false;
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return (Boolean) arg0.invoke(arg1);
    }

    static {
        KProperty[] var76 = new KProperty[76];
        INSTANCE = new AutoCrystalModule();
        mainGroupSetting = VisibleRenderHelper.registerSetting(INSTANCE, "main");
        timingSetting = VisibleRenderHelper.registerSetting(INSTANCE, "timing", AutoCrystalTimingMode.VANILLA, INSTANCE.getMainGroup());
        multiActionSetting = VisibleRenderHelper.registerSetting(INSTANCE, "one-tick-action", 1, INSTANCE.getMainGroup());
        onCrystalSpawnSetting = VisibleRenderHelper.registerSetting(INSTANCE, "on-crystal-spawn", AutoCrystalOnCrystalSpawnMode.ACTION_X, INSTANCE.getMainGroup());
        spawnTimingSetting = VisibleRenderHelper.registerSetting(INSTANCE, "spawn-timing", AutoCrystalSpawnTimingMode.ADD_TO_WORLD, INSTANCE.getMainGroup());
        rotateSetting = VisibleRenderHelper.registerSetting(INSTANCE, "rotate", 1, INSTANCE.getMainGroup());
        rayTraceSetting = VisibleRenderHelper.registerSetting(INSTANCE, "ray-trace", 0, INSTANCE.getMainGroup());
        crystalMultiPointSetting = VisibleRenderHelper.registerSetting(INSTANCE, "crystal-multi-point", 0, INSTANCE.getMainGroup());
        asyncCalcSetting = VisibleRenderHelper.registerSetting(INSTANCE, "async-calc", 0, INSTANCE.getMainGroup());
        failNotifySetting = VisibleRenderHelper.registerSetting(INSTANCE, "fail-notify", 0, INSTANCE.getMainGroup());
        predictSetting = VisibleRenderHelper.registerSetting(INSTANCE, "predict", AutoCrystalPredictMode.AUTO, INSTANCE.getMainGroup());
        predictTicksValueSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl(INSTANCE, "predict-ticks", 3, new IntRange(1, 10), INSTANCE.getMainGroup(), this::isActive2);
        placeGroupSetting = VisibleRenderHelper.registerSetting(INSTANCE, "place");
        oldVerSetting = VisibleRenderHelper.registerSetting(INSTANCE, "1.12", 0, INSTANCE.getPlaceGroup());
        placeDelaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "place-delay", 0, new IntRange(0, 10), INSTANCE.getPlaceGroup());
        placeRangeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "place-range", 5.0F, RangesKt.rangeTo(1.0F, 6.0F), INSTANCE.getPlaceGroup());
        limitPlaceSetting = VisibleRenderHelper.registerSetting(INSTANCE, "limit-place", 1, INSTANCE.getPlaceGroup());
        removeFireSetting = VisibleRenderHelper.registerSetting(INSTANCE, "remove-fire", 1, INSTANCE.getPlaceGroup());
        removeLavaSetting = VisibleRenderHelper.registerSetting(INSTANCE, "remove-lava", 1, INSTANCE.getPlaceGroup());
        breakGroupSetting = VisibleRenderHelper.registerSetting(INSTANCE, "break");
        breakDelaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "break-delay", 0, new IntRange(0, 10), INSTANCE.getBreakGroup());
        grimBreakRangeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "grim-break-range", 0, INSTANCE.getBreakGroup());
        explodeRangeSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(INSTANCE, "break-range", 5.0F, RangesKt.rangeTo(1.0F, 6.0F), INSTANCE.getBreakGroup(), this::isActive3);
        limitBreakSetting = VisibleRenderHelper.registerSetting(INSTANCE, "limit-break", 1, INSTANCE.getBreakGroup());
        randomizeDelaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "randomize-delay", 0, INSTANCE.getBreakGroup());
        pauseGroupSetting = VisibleRenderHelper.registerSetting(INSTANCE, "pause");
        miningSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mining", 0, INSTANCE.getPauseGroup());
        eatingSetting = VisibleRenderHelper.registerSetting(INSTANCE, "eating", 0, INSTANCE.getPauseGroup());
        inventorySetting = VisibleRenderHelper.registerSetting(INSTANCE, "inventory", 0, INSTANCE.getPauseGroup());
        switchPauseSetting = VisibleRenderHelper.registerSetting(INSTANCE, "switch-pause", 0, new IntRange(0, 10), INSTANCE.getPauseGroup());
        offHandPauseSetting = VisibleRenderHelper.registerSetting(INSTANCE, "off-hand", 2, new IntRange(0, 5), INSTANCE.getPauseGroup());
        damagesGroupSetting = VisibleRenderHelper.registerSetting(INSTANCE, "damages");
        assumeBestArmorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "assume-best-armor", 0, INSTANCE.getDamagesGroup());
        minDamageSetting = VisibleRenderHelper.registerSetting(INSTANCE, "min-damage", 6.0F, RangesKt.rangeTo(2.0F, 20.0F), INSTANCE.getDamagesGroup());
        maxSelfDamageSetting = VisibleRenderHelper.registerSetting(INSTANCE, "max-self-damage", 10.0F, RangesKt.rangeTo(2.0F, 20.0F), INSTANCE.getDamagesGroup());
        efficiencyFactorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "min-damage-factor", 0.1F, RangesKt.rangeTo(0.1F, 5.0F), INSTANCE.getDamagesGroup());
        lethalMultiplierSetting = VisibleRenderHelper.registerSetting(INSTANCE, "lethal-multiplier", 1, new IntRange(1, 3), INSTANCE.getDamagesGroup());
        overrideSelfDamageSetting = VisibleRenderHelper.registerSetting(INSTANCE, "override-self-damage", 1, INSTANCE.getDamagesGroup());
        overrideMinDamageSetting = VisibleRenderHelper.registerSetting(INSTANCE, "override-min-damage", 1, INSTANCE.getDamagesGroup());
        armorScaleSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(INSTANCE, "armor-percent", 5.0F, RangesKt.rangeTo(0.0F, 40.0F), INSTANCE.getDamagesGroup(), this::isActive4);
        facePlaceHpSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(INSTANCE, "face-place-health", 5.0F, RangesKt.rangeTo(0.0F, 20.0F), INSTANCE.getDamagesGroup(), this::isActive5);
        explodeEChestFarmSetting = VisibleRenderHelper.resolveVisibleVisibleSettingPropertyImpl(INSTANCE, "anti-e-chest-farm", 1, INSTANCE.getDamagesGroup(), this::isActive6);
        antiPortalSetting = VisibleRenderHelper.resolveVisibleVisibleSettingPropertyImpl(INSTANCE, "anti-portal", 1, INSTANCE.getDamagesGroup(), this::isActive7);
        antiQuiverSetting = VisibleRenderHelper.resolveVisibleVisibleSettingPropertyImpl(INSTANCE, "anti-quiver", 1, INSTANCE.getDamagesGroup(), this::isActive8);
        terrainIgnoreSetting = VisibleRenderHelper.registerSetting(INSTANCE, "destructible-terrain", 1, INSTANCE.getDamagesGroup());
        friendProtectionSetting = VisibleRenderHelper.registerSetting(INSTANCE, "friend-protection", AutoCrystalFriendProtectionMode.ONLY_LETHAL, INSTANCE.getDamagesGroup());
        calcShieldsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "calc-shields", 0, INSTANCE.getDamagesGroup());
        damageSyncSetting = VisibleRenderHelper.registerSetting(INSTANCE, "damage-sync", AutoCrystalDamageSyncMode.OFF, INSTANCE.getDamagesGroup());
        facePlaceSyncSetting = VisibleRenderHelper.resolveVisibleVisibleSettingPropertyImpl(INSTANCE, "face-place-sync", 1, INSTANCE.getDamagesGroup(), this::isActive9);
        lowCrystalsSetting = VisibleRenderHelper.resolveVisibleVisibleSettingPropertyImpl(INSTANCE, "low-crystals", 1, INSTANCE.getDamagesGroup(), this::isActive10);
        stacksLeftSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(INSTANCE, "stacks-left", 1.5F, RangesKt.rangeTo(0.5F, 5.0F), INSTANCE.getDamagesGroup(), this::isActive11);
        minimizeSelfDamageSetting = VisibleRenderHelper.registerSetting(INSTANCE, "minimize-self-damage", 1, INSTANCE.getDamagesGroup());
        maxDamageReductionSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(INSTANCE, "max-damage-reduction", 1.5F, RangesKt.rangeTo(0.01F, 10.0F), INSTANCE.getDamagesGroup(), this::isActive12);
        switchGroupSetting = VisibleRenderHelper.registerSetting(INSTANCE, "swap");
        gappleSwitchSetting = VisibleRenderHelper.registerSetting(INSTANCE, "gapple-switch", 1, INSTANCE.getSwitchGroup());
        autoSwitchSetting = VisibleRenderHelper.registerSetting(INSTANCE, "switch", AutoCrystalAutoSwitchMode.NORMAL, INSTANCE.getSwitchGroup());
        antiWeaknessSetting = VisibleRenderHelper.registerSetting(INSTANCE, "anti-weakness", AutoCrystalAutoSwitchMode.SILENT, INSTANCE.getSwitchGroup());
        idPredictGroupSetting = VisibleRenderHelper.registerSetting(INSTANCE, "id-predict");
        idPredictSetting = VisibleRenderHelper.registerSetting(INSTANCE, "predict", 0, INSTANCE.getIdPredictGroup());
        idOffsetSetting = VisibleRenderHelper.registerSetting(INSTANCE, "id-offset", 1, new IntRange(1, 10), INSTANCE.getIdPredictGroup());
        idAttacksSetting = VisibleRenderHelper.registerSetting(INSTANCE, "id-attacks", 3, new IntRange(1, 10), INSTANCE.getIdPredictGroup());
        idDelaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "id-delay", 25, new IntRange(0, 500), INSTANCE.getIdPredictGroup());
        idPredictOnlyDuelsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "predict-only-in-duels", 0, INSTANCE.getIdPredictGroup());
        swingOnceSetting = VisibleRenderHelper.registerSetting(INSTANCE, "swing-once", 0, INSTANCE.getIdPredictGroup());
        onlyBreakingSurrSetting = VisibleRenderHelper.registerSetting(INSTANCE, "only-breaking-surround", 0, INSTANCE.getIdPredictGroup());
        targetingSetting = VisibleRenderHelper.registerSetting(INSTANCE, "targeting");
        targetSortSetting = VisibleRenderHelper.registerSetting(INSTANCE, "target-sort", AutoCrystalTargetSortMode.DISTANCE, INSTANCE.getTargeting());
        ignoreCreativeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "ignore-creative", 1, INSTANCE.getTargeting());
        ignoreNakedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "ignore-naked", 0, INSTANCE.getTargeting());
        renderGroupSetting = VisibleRenderHelper.registerSetting(INSTANCE, "render");
        fakeCrystalRemoveSetting = VisibleRenderHelper.registerSetting(INSTANCE, "fake-crystal-remove", 0, INSTANCE.getRenderGroup());
        removeDelaySetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl(INSTANCE, "remove-delay", 50, new IntRange(0, 200), INSTANCE.getRenderGroup(), this::isActive13);
        targetEspSetting = VisibleRenderHelper.registerSetting(INSTANCE, "highlight-target", AuraEspMode.COMETS, INSTANCE.getRenderGroup());
        renderModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "render-mode", AutoCrystalRenderMode.SHADER, INSTANCE.getRenderGroup());
        textPatternSetting = VisibleRenderHelper.registerSetting(INSTANCE, "text-pattern", "damage / self", INSTANCE.getRenderGroup());
        alphaSetting = VisibleRenderHelper.registerSetting(INSTANCE, "alpha", 0.4F, RangesKt.rangeTo(0.0F, 1.0F), INSTANCE.getRenderGroup());
        atomicReference = new AtomicReference();
        atomicReference2 = new AtomicReference();
        atomicBoolean = new AtomicBoolean();
        serviceComponent38 = new ServiceComponent38();
        serviceComponent382 = new ServiceComponent38();
        serviceComponent10 = new ServiceComponent10();
        serviceComponent383 = new ServiceComponent38();
        serviceComponent384 = new ServiceComponent38();
        lookupMap = (Map) new LinkedHashMap();
        linkedList = new LinkedList();
        atomicReference3 = new AtomicReference();
        serviceComponent102 = new ServiceComponent10();
        easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_BACK, 1000L);
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
