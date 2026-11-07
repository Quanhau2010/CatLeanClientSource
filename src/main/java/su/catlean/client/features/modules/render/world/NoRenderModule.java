package su.catlean.client.features.modules.render.world;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.minecraft.class_11930;
import net.minecraft.class_1303;
import net.minecraft.class_1531;
import net.minecraft.class_1542;
import net.minecraft.class_1667;
import net.minecraft.class_1679;
import net.minecraft.class_1681;
import net.minecraft.class_1683;
import net.minecraft.class_3937;
import net.minecraft.class_5904;
import net.minecraft.class_673;
import net.minecraft.class_677.class_678;
import net.minecraft.class_677.class_681;
import net.minecraft.class_691;
import net.minecraft.class_727;
import net.minecraft.class_9998;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import su.catlean.SharedKt;
import su.catlean.api.event.GetFogBufferEvent;
import su.catlean.api.event.GofraState;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.event.events.render.BossBarRenderEvent;
import su.catlean.api.event.events.render.DarknessEffectEvent;
import su.catlean.api.event.events.render.EntityAlphaEvent;
import su.catlean.api.event.events.render.HurtTiltEvent;
import su.catlean.api.event.events.render.ItemNameRenderEvent;
import su.catlean.api.event.events.render.MapRenderEvent;
import su.catlean.api.event.events.render.NauseaRenderEvent;
import su.catlean.api.event.events.render.Render3DEvent;
import su.catlean.api.event.events.render.RenderArmorEvent;
import su.catlean.api.event.events.render.RenderFireOnEntityEvent;
import su.catlean.api.event.events.render.RenderFireOverlayEvent;
import su.catlean.api.event.events.render.RenderGuiBackgroundEvent;
import su.catlean.api.event.events.render.RenderInWallOverlayEvent;
import su.catlean.api.event.events.render.RenderNameTagEvent;
import su.catlean.api.event.events.render.RenderParticleEvent;
import su.catlean.api.event.events.render.RenderPortalOverlayEvent;
import su.catlean.api.event.events.render.RenderSpawnerEntityEvent;
import su.catlean.api.event.events.render.RenderUnderwaterOverlayEvent;
import su.catlean.api.event.events.render.RenderVignetteOverlayEvent;
import su.catlean.api.event.events.render.ScoreBoardRenderEvent;
import su.catlean.api.event.events.render.ShouldRenderEntityEvent;
import su.catlean.api.event.events.render.SignTextRenderEvent;
import su.catlean.api.event.events.render.StatusEffectsRenderEvent;
import su.catlean.api.event.events.render.WeatherRenderEvent;
import su.catlean.api.event.events.world.GetFogModifierEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl7;
import su.catlean.api.setting.SettingGroup;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.services.render.shader.TextShaderComponent2;
import su.catlean.client.types.OptionMode14;

public class NoRenderModule extends Module {

    public static final NoRenderModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl7 screenSetting;
    private static final VisibleVisibleSettingPropertyImpl hurtCamSetting;
    private static final VisibleVisibleSettingPropertyImpl potionsSetting;
    private static final VisibleVisibleSettingPropertyImpl vignetteSetting;
    private static final VisibleVisibleSettingPropertyImpl portalSetting;
    private static final VisibleVisibleSettingPropertyImpl bossbarSetting;
    private static final VisibleVisibleSettingPropertyImpl fireOverlaySetting;
    private static final VisibleVisibleSettingPropertyImpl waterOverlaySetting;
    private static final VisibleVisibleSettingPropertyImpl blockOverlaySetting;
    private static final VisibleVisibleSettingPropertyImpl nauseaSetting;
    private static final VisibleVisibleSettingPropertyImpl blindnessSetting;
    private static final VisibleVisibleSettingPropertyImpl guiBackGroundSetting;
    private static final VisibleVisibleSettingPropertyImpl noScoreBoardSetting;
    private static final VisibleVisibleSettingPropertyImpl hotbarItemNameSetting;
    private static final VisibleVisibleSettingPropertyImpl antiTitleSetting;
    private static final DefaultValueVisibleSettingPropertyImpl7 entitiesSetting;
    private static final VisibleVisibleSettingPropertyImpl xpSetting;
    private static final VisibleVisibleSettingPropertyImpl arrowsSetting;
    private static final VisibleVisibleSettingPropertyImpl eggsSetting;
    private static final VisibleVisibleSettingPropertyImpl elderGuardianSetting;
    private static final VisibleVisibleSettingPropertyImpl armorSetting;
    private static final VisibleVisibleSettingPropertyImpl itemsSetting;
    private static final VisibleVisibleSettingPropertyImpl crystalsSetting;
    private static final VisibleVisibleSettingPropertyImpl fireworksSetting;
    private static final VisibleVisibleSettingPropertyImpl noArmorStandsSetting;
    private static final DefaultValueVisibleSettingPropertyImpl7 particlesSetting;
    private static final VisibleVisibleSettingPropertyImpl explosionsSetting;
    private static final VisibleVisibleSettingPropertyImpl campFireSetting;
    private static final VisibleVisibleSettingPropertyImpl breakParticlesSetting;
    private static final VisibleVisibleSettingPropertyImpl noWeatherSetting;
    private static final DefaultValueVisibleSettingPropertyImpl7 worldSetting;
    private static final VisibleVisibleSettingPropertyImpl mapsSetting;
    private static final VisibleVisibleSettingPropertyImpl spawnerEntitySetting;
    private static final VisibleVisibleSettingPropertyImpl fireEntitySetting;
    private static final VisibleVisibleSettingPropertyImpl signTextSetting;
    private static final VisibleVisibleSettingPropertyImpl darknessSetting;
    private static final VisibleVisibleSettingPropertyImpl fogSetting;
    private static final DefaultValueVisibleSettingPropertyImpl7 otherSetting;
    private static final VisibleVisibleSettingPropertyImpl antiPlayerCollisionSetting;

    private NoRenderModule() {
        super("no-render", SubCategoriesKt.getWorldRenderCategory());
    }

    private SettingGroup getScreen() {
        return (SettingGroup) screenSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private boolean getHurtCam() {
        return (Boolean) hurtCamSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private boolean getPotions() {
        return (Boolean) potionsSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private boolean getVignette() {
        return (Boolean) vignetteSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private boolean getPortal() {
        return (Boolean) portalSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    private boolean getBossbar() {
        return (Boolean) bossbarSetting.getValue(this, DELEGATED_PROPERTIES[5]);
    }

    private boolean getFireOverlay() {
        return (Boolean) fireOverlaySetting.getValue(this, DELEGATED_PROPERTIES[6]);
    }

    private boolean getWaterOverlay() {
        return (Boolean) waterOverlaySetting.getValue(this, DELEGATED_PROPERTIES[7]);
    }

    private boolean getBlockOverlay() {
        return (Boolean) blockOverlaySetting.getValue(this, DELEGATED_PROPERTIES[8]);
    }

    private boolean getNausea() {
        return (Boolean) nauseaSetting.getValue(this, DELEGATED_PROPERTIES[9]);
    }

    private boolean getBlindness() {
        return (Boolean) blindnessSetting.getValue(this, DELEGATED_PROPERTIES[10]);
    }

    private boolean getGuiBackGround() {
        return (Boolean) guiBackGroundSetting.getValue(this, DELEGATED_PROPERTIES[11]);
    }

    private boolean getNoScoreBoard() {
        return (Boolean) noScoreBoardSetting.getValue(this, DELEGATED_PROPERTIES[12]);
    }

    private boolean getHotbarItemName() {
        return (Boolean) hotbarItemNameSetting.getValue(this, DELEGATED_PROPERTIES[13]);
    }

    private boolean getAntiTitle() {
        return (Boolean) antiTitleSetting.getValue(this, DELEGATED_PROPERTIES[14]);
    }

    private SettingGroup getEntities() {
        return (SettingGroup) entitiesSetting.getValue(this, DELEGATED_PROPERTIES[15]);
    }

    private boolean getXp() {
        return (Boolean) xpSetting.getValue(this, DELEGATED_PROPERTIES[16]);
    }

    private boolean getArrows() {
        return (Boolean) arrowsSetting.getValue(this, DELEGATED_PROPERTIES[17]);
    }

    private boolean getEggs() {
        return (Boolean) eggsSetting.getValue(this, DELEGATED_PROPERTIES[18]);
    }

    private boolean getElderGuardian() {
        return (Boolean) elderGuardianSetting.getValue(this, DELEGATED_PROPERTIES[19]);
    }

    private boolean getArmor() {
        return (Boolean) armorSetting.getValue(this, DELEGATED_PROPERTIES[20]);
    }

    private boolean getItems() {
        return (Boolean) itemsSetting.getValue(this, DELEGATED_PROPERTIES[21]);
    }

    private boolean getCrystals() {
        return (Boolean) crystalsSetting.getValue(this, DELEGATED_PROPERTIES[22]);
    }

    private boolean getFireworks() {
        return (Boolean) fireworksSetting.getValue(this, DELEGATED_PROPERTIES[23]);
    }

    private boolean getNoArmorStands() {
        return (Boolean) noArmorStandsSetting.getValue(this, DELEGATED_PROPERTIES[24]);
    }

    private SettingGroup getParticles() {
        return (SettingGroup) particlesSetting.getValue(this, DELEGATED_PROPERTIES[25]);
    }

    private boolean getExplosions() {
        return (Boolean) explosionsSetting.getValue(this, DELEGATED_PROPERTIES[26]);
    }

    private boolean getCampFire() {
        return (Boolean) campFireSetting.getValue(this, DELEGATED_PROPERTIES[27]);
    }

    private boolean getBreakParticles() {
        return (Boolean) breakParticlesSetting.getValue(this, DELEGATED_PROPERTIES[28]);
    }

    private boolean getNoWeather() {
        return (Boolean) noWeatherSetting.getValue(this, DELEGATED_PROPERTIES[29]);
    }

    private SettingGroup getWorld() {
        return (SettingGroup) worldSetting.getValue(this, DELEGATED_PROPERTIES[30]);
    }

    private boolean getMaps() {
        return (Boolean) mapsSetting.getValue(this, DELEGATED_PROPERTIES[31]);
    }

    private boolean getSpawnerEntity() {
        return (Boolean) spawnerEntitySetting.getValue(this, DELEGATED_PROPERTIES[32]);
    }

    private boolean getFireEntity() {
        return (Boolean) fireEntitySetting.getValue(this, DELEGATED_PROPERTIES[33]);
    }

    private boolean getSignText() {
        return (Boolean) signTextSetting.getValue(this, DELEGATED_PROPERTIES[34]);
    }

    private boolean getDarkness() {
        return (Boolean) darknessSetting.getValue(this, DELEGATED_PROPERTIES[35]);
    }

    private boolean getFog() {
        return (Boolean) fogSetting.getValue(this, DELEGATED_PROPERTIES[36]);
    }

    private SettingGroup getOther() {
        return (SettingGroup) otherSetting.getValue(this, DELEGATED_PROPERTIES[37]);
    }

    private boolean getAntiPlayerCollision() {
        return (Boolean) antiPlayerCollisionSetting.getValue(this, DELEGATED_PROPERTIES[38]);
    }

    private void onReceivePacket(ReceivePacket arg0) {
        arg0.cancel();
    }

    private void onSignTextRenderEvent(SignTextRenderEvent arg0) {
        if (!(this.getSignText()) || SharedKt.getMc().field_1765 != null) {
            return;
        }
        arg0.cancel();
    }

    private void onRenderArmorEvent(RenderArmorEvent arg0) {
        arg0.cancel();
    }

    private void onMapRenderEvent(MapRenderEvent arg0) {
        arg0.cancel();
    }

    private void onRenderFireOverlayEvent(RenderFireOverlayEvent arg0) {
        arg0.cancel();
    }

    private void onWeatherRenderEvent(WeatherRenderEvent arg0) {
        arg0.cancel();
    }

    private void onRenderUnderwaterOverlayEvent(RenderUnderwaterOverlayEvent arg0) {
        arg0.cancel();
    }

    private void onRenderGuiBackgroundEvent(RenderGuiBackgroundEvent arg0) {
        arg0.cancel();
    }

    private void onRenderInWallOverlayEvent(RenderInWallOverlayEvent arg0) {
        arg0.cancel();
    }

    private void onDarknessEffectEvent(DarknessEffectEvent arg0) {
        arg0.cancel();
    }

    private void onRenderSpawnerEntityEvent(RenderSpawnerEntityEvent arg0) {
        arg0.cancel();
    }

    private void onNauseaRenderEvent(NauseaRenderEvent arg0) {
        arg0.cancel();
    }

    private void onStatusEffectsRenderEvent(StatusEffectsRenderEvent arg0) {
        arg0.cancel();
    }

    private void onRenderPortalOverlayEvent(RenderPortalOverlayEvent arg0) {
        arg0.cancel();
    }

    private void onRenderVignetteOverlayEvent(RenderVignetteOverlayEvent arg0) {
        arg0.cancel();
    }

    private void onScoreBoardRenderEvent(ScoreBoardRenderEvent arg0) {
        arg0.cancel();
    }

    private void onItemNameRenderEvent(ItemNameRenderEvent arg0) {
        arg0.cancel();
    }

    private void onRenderFireOnEntityEvent(RenderFireOnEntityEvent arg0) {
        arg0.cancel();
    }

    private void onBossBarRenderEvent(BossBarRenderEvent arg0) {
        arg0.cancel();
    }

    private void onHurtTiltEvent(HurtTiltEvent arg0) {
        arg0.cancel();
    }

    private void onEntityAlphaEvent(EntityAlphaEvent arg0) {
        arg0.setAlpha(Math.clamp(((SharedKt.getPlayer().method_5707(arg0.getPos()) / 3.0F) + 0.2F), 0.0F, 1.0F));
        arg0.cancel();
    }

    private void onRenderParticleEvent(RenderParticleEvent arg0) {
        if (this.getElderGuardian() && arg0.getParticle() instanceof class_11930) {
            arg0.cancel();
        } else {
            if (!(arg0.getParticle() instanceof class_691)) {
                if (this.getExplosions() && arg0.getParticle() instanceof class_673) {
                }
                arg0.cancel();
            } else {
                if (this.getCampFire() && arg0.getParticle() instanceof class_3937) {
                    arg0.cancel();
                } else {
                    if (this.getBreakParticles() && arg0.getParticle() instanceof class_727) {
                        arg0.cancel();
                    } else {
                        if (!(arg0.getParticle() instanceof class_681)) {
                        }
                        arg0.cancel();
                    }
                }
            }
        }
    }

    private void onShouldRenderEntityEvent(ShouldRenderEntityEvent arg0) {
        arg0.cancel();
    }

    private void onRenderNameTagEvent(RenderNameTagEvent arg0) {
        arg0.cancel();
    }

    private void updateValue(GetFogBufferEvent arg0) {
        arg0.cancel();
    }

    private void onGetFogModifierEvent(GetFogModifierEvent arg0) {
        arg0.cancel();
    }

    public void onRender3DEvent(Render3DEvent event) {
        GofraState.INSTANCE.setShouldRender(this.checkCondition());
    }

    private boolean checkCondition(Object arg0) {
        if (arg0 instanceof EndCrystalEntity && this.getCrystals()) {
            return true;
        }
        if (arg0 instanceof class_1531 && this.getNoArmorStands()) {
            return true;
        }
        if (arg0 instanceof class_1542 && this.getItems()) {
            return true;
        }
        if (arg0 instanceof class_1681 && this.getEggs()) {
            return true;
        }
        if (!(arg0 instanceof class_1683)) {
        }
        if (arg0 instanceof class_1303 && this.getXp()) {
            return true;
        }
        if (arg0 instanceof class_1667 && this.getArrows()) {
            return true;
        }
        if (arg0 instanceof class_1679 && this.getArrows()) {
            return true;
        }
        return false;
    }

    private boolean checkCondition() {
        if (!(this.getCrystals())) {
            if (!(this.getNoArmorStands())) {
                if (!(this.getItems())) {
                    if (!(this.getEggs())) {
                        if (!(this.getXp())) {
                            if (this.getEnabled() && this.getArrows()) {
                            }
                        }
                    }
                }
            }
        } else {
        }
        return false;
    }

    static {
        KProperty[] var39 = new KProperty[39];
        INSTANCE = new NoRenderModule();
        screenSetting = VisibleRenderHelper.registerSetting(INSTANCE, "screen", OptionMode14.BOOLS);
        hurtCamSetting = VisibleRenderHelper.registerSetting(INSTANCE, "hurt-cam", 1, INSTANCE.getScreen());
        potionsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "potions", 0, INSTANCE.getScreen());
        vignetteSetting = VisibleRenderHelper.registerSetting(INSTANCE, "vignette", 1, INSTANCE.getScreen());
        portalSetting = VisibleRenderHelper.registerSetting(INSTANCE, "portal", 1, INSTANCE.getScreen());
        bossbarSetting = VisibleRenderHelper.registerSetting(INSTANCE, "bossbar", 0, INSTANCE.getScreen());
        fireOverlaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "fire-overlay", 0, INSTANCE.getScreen());
        waterOverlaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "water-overlay", 0, INSTANCE.getScreen());
        blockOverlaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "block-overlay", 0, INSTANCE.getScreen());
        nauseaSetting = VisibleRenderHelper.registerSetting(INSTANCE, "nausea", 0, INSTANCE.getScreen());
        blindnessSetting = VisibleRenderHelper.registerSetting(INSTANCE, "blindness", 0, INSTANCE.getScreen());
        guiBackGroundSetting = VisibleRenderHelper.registerSetting(INSTANCE, "gui-back-ground", 1, INSTANCE.getScreen());
        noScoreBoardSetting = VisibleRenderHelper.registerSetting(INSTANCE, "no-score-board", 1, INSTANCE.getScreen());
        hotbarItemNameSetting = VisibleRenderHelper.registerSetting(INSTANCE, "hotbar-item-name", 0, INSTANCE.getScreen());
        antiTitleSetting = VisibleRenderHelper.registerSetting(INSTANCE, "anti-title", 0, INSTANCE.getScreen());
        entitiesSetting = VisibleRenderHelper.registerSetting(INSTANCE, "entities", OptionMode14.BOOLS);
        xpSetting = VisibleRenderHelper.registerSetting(INSTANCE, "xp", 0, INSTANCE.getEntities());
        arrowsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "arrows", 0, INSTANCE.getEntities());
        eggsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "eggs", 0, INSTANCE.getEntities());
        elderGuardianSetting = VisibleRenderHelper.registerSetting(INSTANCE, "guardian", 0, INSTANCE.getEntities());
        armorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "armor", 0, INSTANCE.getEntities());
        itemsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "items", 0, INSTANCE.getEntities());
        crystalsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "crystals", 0, INSTANCE.getEntities());
        fireworksSetting = VisibleRenderHelper.registerSetting(INSTANCE, "fireworks", 0, INSTANCE.getEntities());
        noArmorStandsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "no-armor-stands", 0, INSTANCE.getEntities());
        particlesSetting = VisibleRenderHelper.registerSetting(INSTANCE, "particles", OptionMode14.BOOLS);
        explosionsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "explosions", 1, INSTANCE.getParticles());
        campFireSetting = VisibleRenderHelper.registerSetting(INSTANCE, "camp-fire", 0, INSTANCE.getParticles());
        breakParticlesSetting = VisibleRenderHelper.registerSetting(INSTANCE, "break-particles", 1, INSTANCE.getParticles());
        noWeatherSetting = VisibleRenderHelper.registerSetting(INSTANCE, "no-weather", 0, INSTANCE.getParticles());
        worldSetting = VisibleRenderHelper.registerSetting(INSTANCE, "world", OptionMode14.BOOLS);
        mapsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "maps", 0, INSTANCE.getWorld());
        spawnerEntitySetting = VisibleRenderHelper.registerSetting(INSTANCE, "spawner-entity", 0, INSTANCE.getWorld());
        fireEntitySetting = VisibleRenderHelper.registerSetting(INSTANCE, "fire-on-entity", 1, INSTANCE.getWorld());
        signTextSetting = VisibleRenderHelper.registerSetting(INSTANCE, "sign-text", 0, INSTANCE.getWorld());
        darknessSetting = VisibleRenderHelper.registerSetting(INSTANCE, "darkness", 0, INSTANCE.getWorld());
        fogSetting = VisibleRenderHelper.registerSetting(INSTANCE, "fog", 0, INSTANCE.getWorld());
        otherSetting = VisibleRenderHelper.registerSetting(INSTANCE, "other", OptionMode14.BOOLS);
        antiPlayerCollisionSetting = VisibleRenderHelper.registerSetting(INSTANCE, "anti-player-collision", 1, INSTANCE.getOther());
    }

}
