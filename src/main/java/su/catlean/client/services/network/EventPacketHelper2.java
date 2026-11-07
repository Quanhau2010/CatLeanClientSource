package su.catlean.client.services.network;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_10182;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1301;
import net.minecraft.class_1675;
import net.minecraft.class_239;
import net.minecraft.class_239.class_240;
import net.minecraft.class_2708;
import net.minecraft.class_2767;
import net.minecraft.class_2813;
import net.minecraft.class_2815;
import net.minecraft.class_2848.class_2849;
import net.minecraft.class_2886;
import net.minecraft.class_3417;
import net.minecraft.class_3532;
import net.minecraft.class_3675.class_306;
import net.minecraft.class_3959;
import net.minecraft.class_3959.class_242;
import net.minecraft.class_3959.class_3960;
import net.minecraft.class_3965;
import net.minecraft.class_3966;
import net.minecraft.class_4184;
import net.minecraft.class_6880;
import net.minecraft.class_744;
import net.minecraft.class_757;
import net.minecraft.class_9323;
import net.minecraft.class_9334;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.GofraState;
import su.catlean.api.event.events.client.TickEvent;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.event.events.network.SendPacket;
import su.catlean.api.event.events.player.MoveEvent;
import su.catlean.api.event.events.player.StopUsingItemEvent;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.movement.basic.AvoidModule;
import su.catlean.client.features.modules.movement.rage.AntiWebModule;
import su.catlean.client.features.modules.movement.rage.BlinkModule;
import su.catlean.client.features.modules.movement.rage.PhaseModule;
import su.catlean.client.features.modules.utility.player.SpeedMineModule;
import su.catlean.client.services.client.ServiceComponent13;
import su.catlean.client.services.player.EntityHelper;
import su.catlean.mixins.accessors.KeyMappingAccessor;
import su.catlean.mixins.accessors.LocalPlayerAccessor;

public class EventPacketHelper2 {

    public static final EventPacketHelper2 INSTANCE;
    private static int countValue;
    private static float factorValue;
    private static float factorValue2;
    private static boolean enabledFlag;
    private static boolean enabledFlag2;
    private static long timestampValue2;
    private static long timestampValue3;
    private static double preciseValue;
    private static boolean enabledFlag3;
    private static Module[] moduleArray;

    private EventPacketHelper2() {
    }

    public int getNumericValue() {
        return countValue;
    }

    public void updateValue(int value) {
        countValue = value;
    }

    public float getNumericValue() {
        return factorValue;
    }

    public void updateValue(float value) {
        factorValue = value;
    }

    public float getNumericValue2() {
        return factorValue2;
    }

    public void updateValue2(float value) {
        factorValue2 = value;
    }

    public boolean isActive() {
        return enabledFlag;
    }

    public void updateValue(boolean value) {
        enabledFlag = value;
    }

    public boolean isActive2() {
        return enabledFlag2;
    }

    public void updateValue2(boolean value) {
        enabledFlag2 = value;
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

    public long getNumericValue3() {
        return timestampValue3;
    }

    public void updateValue3(long value) {
        timestampValue3 = value;
    }

    public double getNumericValue() {
        return preciseValue;
    }

    public void updateValue(double value) {
        preciseValue = value;
    }

    public boolean isActive3() {
        return enabledFlag3;
    }

    public void updateValue3(boolean value) {
        enabledFlag3 = value;
    }

    public float computeValue() {
        return ((LocalPlayerAccessor) SharedKt.getPlayer()).getLastYaw();
    }

    public float computeValue2() {
        return ((LocalPlayerAccessor) SharedKt.getPlayer()).getLastPitch();
    }

    public Vec3d resolveMinecraftObject() {
        if (BlinkModule.INSTANCE.getEnabled() && BlinkModule.INSTANCE.getMinecraftObject() != null) {
        } else {
        }
        return EntityHelper.resolveMinecraftObject(SharedKt.getPlayer());
    }

    private void onSendPacket(SendPacket arg0) {
        if (arg0.getPacket() instanceof ClientCommandC2SPacket) {
            if (((ClientCommandC2SPacket) arg0.getPacket()).method_12365() == class_2849.field_12981) {
                enabledFlag = 1;
            }
            if (((ClientCommandC2SPacket) arg0.getPacket()).method_12365() == class_2849.field_12985) {
                enabledFlag = 0;
            }
        }
        if (arg0.getPacket() instanceof class_2813) {
            enabledFlag2 = 1;
        }
        if (arg0.getPacket() instanceof class_2815) {
            enabledFlag2 = 0;
        }
        timestampValue3 = SharedKt.getNumericValue();
    }

    private void onStopUsingItemEvent(StopUsingItemEvent arg0) {
        timestampValue3 = SharedKt.getNumericValue();
    }

    private void onReceivePacket(ReceivePacket arg0) {
        if (arg0.getPacket() instanceof class_2708 && ((class_2708) arg0.getPacket()).comp_3228().comp_3148().method_1022(EntityHelper.resolveMinecraftObject(SharedKt.getPlayer())) > 3.0D) {
            timestampValue2 = SharedKt.getNumericValue();
        }
        if (arg0.getPacket() instanceof class_2708 && (SharedKt.getNumericValue() - timestampValue3) > 10000L && SharedKt.getPlayer().field_6012 > 20) {
            timestampValue = SharedKt.getNumericValue();
        }
        timestampValue3 = SharedKt.getNumericValue();
    }

    private void onTickEvent(TickEvent arg0) {
        if (SharedKt.getMc().player == null) {
            return;
        }
        if (!(AvoidModule.INSTANCE.getEnabled()) && !(AntiWebModule.INSTANCE.getEnabled()) && !(PhaseModule.INSTANCE.getEnabled())) {
            if (SpeedMineModule.INSTANCE.checkCondition()) {
            } else {
            }
        }
        this.setModifyCollisions(false);
        double offset = (SharedKt.getPlayer().getX() - SharedKt.getPlayer().field_6014);
        double offset2 = (SharedKt.getPlayer().getY() - SharedKt.getPlayer().field_6036);
        double offset3 = (SharedKt.getPlayer().getZ() - SharedKt.getPlayer().field_5969);
        factorValue = Math.hypot(offset, offset3);
        factorValue2 = Math.sqrt((((offset * offset) + (offset2 * offset2)) + (offset3 * offset3)));
        if (SharedKt.getPlayer().isFallFlying() && Intrinsics.areEqual(SharedKt.getPlayer().getEquippedStack(EquipmentSlot.CHEST).getItem(), Items.ELYTRA)) {
            countValue = (countValue + 1);
        } else {
            countValue = 0;
        }
        enabledFlag2 = 0;
    }

    private void onMoveEvent(MoveEvent arg0) {
        if (!(SharedKt.getPlayer().isOnGround()) && !(SharedKt.getPlayer().method_52535())) {
            if (arg0.getY() < 0.0D) {
                preciseValue = (preciseValue - arg0.getY());
                preciseValue = 0.0D;
            }
        } else {
        }
        enabledFlag3 = preciseValue > 0.0D;
    }

    public long getNumericValue4() {
        return (System.currentTimeMillis() - timestampValue);
    }

    public boolean checkCondition() {
        if (SharedKt.getPlayer().field_3913.method_3128().field_1342 == 0.0F) {
            if (SharedKt.getMc().player != null && SharedKt.getMc().world != null && SharedKt.getPlayer().field_3913.method_3128().field_1343 != 0.0F) {
            } else {
            }
        }
        return false;
    }

    public double[] process(float d, boolean moveFix, float forward, float sideways, float yaw) {
        float factor = forward;
        float factor2 = sideways;
        if (moveFix) {
            if (__UNDEF_KEY__ > 0) {
                if (SharedKt.getMc().options.field_1894.method_1434()) {
                } else {
                    if (SharedKt.getMc().options.field_1881.method_1434()) {
                    } else {
                    }
                }
            }
            factor = 0.0F;
            if (__UNDEF_KEY__ >= 0L) {
                if (SharedKt.getMc().options.field_1913.method_1434()) {
                } else {
                    if (SharedKt.getMc().options.field_1849.method_1434()) {
                    } else {
                    }
                }
            }
            factor2 = 0.0F;
        }
        float factor3 = yaw;
        if (__UNDEF_KEY__ >= 0) {
            if (factor != 0.0F) {
                if (factor2 != 0.0F) {
                    if (factor2 > 0.0F) {
                        if (factor > 0.0F) {
                        } else {
                            if (factor > 0.0F) {
                            } else {
                            }
                        }
                    } else {
                    }
                    factor3 = (45.0F + -45.0F);
                    factor2 = 0.0F;
                }
                if (factor > 0.0F) {
                } else {
                }
                factor = -1.0F;
            }
        }
        double offset = Math.sin(Math.toRadians((factor3 + 90.0F)));
        double offset2 = Math.cos(Math.toRadians((factor3 + 90.0F)));
        float factor4 = (((factor * d) * offset2) + ((factor2 * d) * offset));
        float factor5 = (((factor * d) * offset) - ((factor2 * d) * offset2));
        Object element = new double[2];
        element[0] = factor4;
        element[1] = factor5;
        return element;
    }

    public static double[] process(EventPacketHelper2 arg0, float arg1, boolean arg2, float arg3, float arg4, float arg5, int arg6, Object arg7) {
        if ((arg6 & 2) != 0) {
            arg2 = 0;
        }
        if ((arg6 & 4) != 0) {
            arg3 = SharedKt.getPlayer().field_3913.method_3128().field_1342;
        }
        if ((arg6 & 8) != 0) {
            arg4 = SharedKt.getPlayer().field_3913.method_3128().field_1343;
        }
        if ((arg6 & 16) != 0) {
            arg5 = SharedKt.getPlayer().method_36454();
        }
        return arg0.process(arg1, arg2, arg3, arg4, arg5);
    }

    public void executeAction(MoveEvent event, double d) {
        float factor = SharedKt.getMc().player.field_3913.method_3128().field_1342;
        float factor2 = SharedKt.getMc().player.field_3913.method_3128().field_1343;
        float factor3 = SharedKt.getMc().player.method_36454();
        if (factor == 0.0D) {
            if (__UNDEF_KEY__ <= 0 && __UNDEF_KEY__ < 0) {
                if (factor2 == 0.0D) {
                    event.setX(0.0D);
                    event.setZ(0.0D);
                } else {
                    if (__UNDEF_KEY__ >= 0) {
                        if (factor != 0.0D) {
                            if (__UNDEF_KEY__ > 0) {
                                if (__UNDEF_KEY__ == null && __UNDEF_KEY__ > 0) {
                                    if (factor2 > 0.0D) {
                                        if (factor > 0.0D) {
                                        } else {
                                        }
                                        factor3 = (-45 + 45);
                                        if (__UNDEF_KEY__ > 0) {
                                            if (__UNDEF_KEY__ > 0 && __UNDEF_KEY__ == null) {
                                                if (factor2 < 0.0D) {
                                                    if (factor > 0.0D) {
                                                    } else {
                                                    }
                                                    factor3 = (45 + -45);
                                                }
                                                factor2 = 0.0D;
                                            }
                                        }
                                    } else {
                                    }
                                }
                            }
                            if (factor > 0.0D) {
                                if (__UNDEF_KEY__ < 0) {
                                    factor = 1.0D;
                                    if (factor < 0.0D) {
                                        factor = -1.0D;
                                    }
                                }
                            } else {
                            }
                        }
                    }
                    double offset = Math.sin(Math.toRadians((factor3 + 90.0F)));
                    double offset2 = Math.cos(Math.toRadians((factor3 + 90.0F)));
                    event.setX((((factor * d) * offset2) + ((factor2 * d) * offset)));
                    event.setZ((((factor * d) * offset) - ((factor2 * d) * offset2)));
                }
            }
        } else {
        }
    }

    public float computeValue(int arg0, long arg1) {
        if (SharedKt.getMc().options.field_1894.method_1434()) {
        } else {
            if (SharedKt.getMc().options.field_1881.method_1434()) {
            } else {
            }
        }
        double offset = 0.0D;
        if (arg1 > 0L) {
            if (SharedKt.getMc().options.field_1913.method_1434()) {
            } else {
                if (SharedKt.getMc().options.field_1849.method_1434()) {
                } else {
                }
            }
        }
        double offset2 = 0.0D;
        if (offset2 > 0.0D) {
            offset2 = 1.0D;
            if (arg0 >= 0) {
            } else {
                if (offset2 < 0.0D) {
                    offset2 = -1.0D;
                }
            }
        } else {
        }
        float factor = SharedKt.getMc().player.method_36454();
        if (offset == 0.0D) {
            if (arg1 > 0L && arg1 >= 0L) {
                if (offset2 == 0.0D) {
                    return factor;
                }
            }
        }
        if (arg0 >= 0) {
            if (offset != 0.0D) {
                if (arg1 > 0L) {
                    if (__UNDEF_KEY__ == null && arg1 > 0L) {
                        if (offset2 > 0.0D) {
                            if (offset > 0.0D) {
                            } else {
                            }
                            factor = (-45.0F + -135.0F);
                        } else {
                            if (arg0 > 0) {
                                if (__UNDEF_KEY__ == null) {
                                    if (offset2 < 0.0D) {
                                        if (offset > 0.0D) {
                                        } else {
                                        }
                                        factor = (45.0F + 135.0F);
                                    } else {
                                        if (arg1 > 0L && __UNDEF_KEY__ == null) {
                                            if (offset < 0.0D) {
                                                factor = (factor + 180.0F);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (arg1 > 0L) {
            if (offset == 0.0D) {
                if (offset2 > 0.0D) {
                    if (arg1 >= 0L) {
                        factor = (factor - 90.0F);
                        factor = (factor + 90.0F);
                    }
                } else {
                }
            }
        }
        return factor;
    }

    public double[] process(double d) {
        float factor = SharedKt.getMc().player.method_36454();
        double offset = (d * Math.cos(Math.toRadians((factor + 90.0F))));
        double offset2 = (d * Math.sin(Math.toRadians((factor + 90.0F))));
        Object element = new double[2];
        element[0] = offset;
        element[1] = offset2;
        return element;
    }

    public Entity resolveMinecraftObject(float yaw, float pitch, float distance, boolean ignoreWalls, boolean onlyLiving) {
        Vec3d vec = EntityHelper.resolveMinecraftObject(SharedKt.getPlayer()).method_1031(0.0D, SharedKt.getPlayer().method_18381(SharedKt.getPlayer().method_18376()), 0.0D);
        double offset = Math.pow(distance, 2);
        offset = this.method_17784().method_1025(vec);
        Vec3d vec2 = this.resolveMinecraftObject(pitch, yaw);
        Vec3d vec3 = vec.method_1031((vec2.field_1352 * distance), (vec2.field_1351 * distance), (vec2.field_1350 * distance));
        Box box = SharedKt.getPlayer().method_5829().method_18804(vec2.method_1021(distance)).method_1009(1.0D, 1.0D, 1.0D);
        class_3966 class3966 = class_1675.method_18075(SharedKt.getPlayer(), vec, vec3, box, this::checkCondition, offset);
        if (class3966 != null) {
            if (vec.method_1025(class3966.method_17784()) >= offset) {
            }
            return class3966.method_17782();
        }
        return null;
    }

    public static Entity resolveMinecraftObject(EventPacketHelper2 arg0, float arg1, float arg2, float arg3, boolean arg4, boolean arg5, int arg6, Object arg7) {
        if ((arg6 & 16) != 0) {
            arg5 = 1;
        }
        return arg0.resolveMinecraftObject(arg1, arg2, arg3, arg4, arg5);
    }

    public class_239 resolveMinecraftObject(float yaw, float pitch, double x, double y, double z) {
        class_239 class239 = this.resolveMinecraftObject(5.0F, yaw, pitch, x, y, z);
        Vec3d vec = new Vec3d(x, y, z).method_1031(0.0D, SharedKt.getPlayer().method_18381(SharedKt.getPlayer().method_18376()), 0.0D);
        double offset = 25.0D;
        if (class239.method_17783() != class_240.field_1333) {
            offset = class239.method_17784().method_1025(vec);
        }
        Vec3d vec2 = this.resolveMinecraftObject(pitch, yaw);
        Vec3d vec3 = vec.method_1031((vec2.field_1352 * 5), (vec2.field_1351 * 5), (vec2.field_1350 * 5));
        Box box = new Box((x - 0.3D), y, (z - 0.3D), (x + 0.3D), (y + 1.8D), (z + 0.3D)).method_18804(vec2.method_1021(5.0D)).method_1009(1.0D, 1.0D, 1.0D);
        class_3966 class3966 = class_1675.method_18075(SharedKt.getPlayer(), vec, vec3, box, this::checkCondition, offset);
        if (class3966 != null) {
            Entity entity = class3966.method_17782();
            Vec3d vec4 = class3966.method_17784();
            double offset2 = vec.method_1025(vec4);
            if (offset2 >= offset) {
            }
            if (class239.method_17783() == class_240.field_1333 && entity instanceof LivingEntity) {
                return ((class_239) class3966);
            }
        }
        return null;
    }

    public Vec3d resolveMinecraftObject(float yaw, float pitch) {
        return new Vec3d((Math.sin((pitch * 0.017453292F)) * Math.cos((yaw * 0.017453292F))), Math.sin((yaw * 0.017453292F)), (Math.cos((pitch * 0.017453292F)) * Math.cos((yaw * 0.017453292F))));
    }

    public class_239 resolveMinecraftObject(float dst, float yaw, float pitch) {
        Vec3d vec = SharedKt.getPlayer().method_5836(1.0F);
        Vec3d vec2 = this.resolveMinecraftObject(pitch, yaw);
        Vec3d vec3 = vec.method_1031((vec2.field_1352 * dst), (vec2.field_1351 * dst), (vec2.field_1350 * dst));
        return ((class_239) SharedKt.getWorld().method_17742(new class_3959(vec, vec3, class_3960.field_17559, class_242.field_1348, SharedKt.getPlayer())));
    }

    private class_239 resolveMinecraftObject(float arg0, float arg1, float arg2, float arg3, float arg4, float arg5) {
        Vec3d vec = new Vec3d(arg3, arg4, arg5);
        Vec3d vec2 = this.resolveMinecraftObject(arg2, arg1);
        Vec3d vec3 = vec.method_1031((vec2.field_1352 * arg0), (vec2.field_1351 * arg0), (vec2.field_1350 * arg0));
        return ((class_239) SharedKt.getWorld().method_17742(new class_3959(vec, vec3, class_3960.field_17559, class_242.field_1348, SharedKt.getPlayer())));
    }

    public double computeValue() {
        int index = 0;
        double offset = 0.2873D;
        if (SharedKt.getMc().player == null) {
            return 0.0D;
        }
        if (SharedKt.getPlayer().method_6059(class_1294.field_5904)) {
            index = SharedKt.getPlayer().method_6112(class_1294.field_5904).method_5578();
            offset = (offset * (1.0D + (0.2D * (index + 1))));
        }
        if (SharedKt.getPlayer().method_6059(class_1294.field_5913)) {
            index = SharedKt.getPlayer().method_6112(class_1294.field_5913).method_5578();
            offset = (offset / (1.0D + (0.2D * (index + 1))));
        }
        if (SharedKt.getPlayer().method_6059(class_1294.field_5909)) {
            index = SharedKt.getPlayer().method_6112(class_1294.field_5909).method_5578();
            offset = (offset / (1.0D + (0.2D * (index + 1))));
        }
        return offset;
    }

    public double computeValue2() {
        double offset = 0.3999999463558197D;
        if (SharedKt.getPlayer().method_6059(class_1294.field_5913)) {
            int index = SharedKt.getPlayer().method_6112(class_1294.field_5913).method_5578();
            offset = (offset + ((index + 1.0D) * 0.1D));
        }
        return offset;
    }

    public float computeValue(ItemStack stack) {
        return (((stack.method_7936() - stack.method_7919()) / stack.method_7936()) * 100.0F);
    }

    public float computeValue(Vec3d targetPos) {
        return Math.sqrt(this.computeValue(targetPos));
    }

    public float computeValue(Vec3d targetPos) {
        if (SharedKt.getMc().player == null) {
            return 0.0F;
        }
        Vec3d vec = VecPacketHelper.INSTANCE.resolveMinecraftObject(SharedKt.getPlayer());
        double offset = (targetPos.field_1352 - vec.field_1352);
        double offset2 = (targetPos.field_1351 - vec.field_1351);
        double offset3 = (targetPos.field_1350 - vec.field_1350);
        return (((offset * offset) + (offset2 * offset2)) + (offset3 * offset3));
    }

    public boolean checkCondition(Vec3d pos, int fov) {
        double offset = (pos.method_10216() - SharedKt.getMc().field_1773.method_19418().method_71156().field_1352);
        double offset2 = (pos.method_10215() - SharedKt.getMc().field_1773.method_19418().method_71156().field_1350);
        float factor = class_3532.method_15393((class_3532.method_15338((Math.toDegrees(Math.atan2(offset2, offset)) - 90.0D)) - class_3532.method_15393(SharedKt.getMc().field_1773.method_19418().method_19330())));
        return Math.abs(factor) <= fov;
    }

    public boolean checkCondition2() {
        if (SharedKt.getMc().player == null) {
            return false;
        }
        if (!(SharedKt.getPlayer().method_6047().method_57353().method_57832(class_9334.field_50075))) {
        }
        return SharedKt.getPlayer().method_6115();
    }

    public Vec3d resolveMinecraftObject(float yaw, float pitch, float distance) {
        Vec3d vec = EntityHelper.resolveMinecraftObject(SharedKt.getMc().player).method_1031(0.0D, SharedKt.getPlayer().method_18381(SharedKt.getPlayer().method_18376()), 0.0D);
        double offset = Math.pow(distance, 2.0F);
        Vec3d vec2 = this.resolveMinecraftObject(pitch, yaw);
        Vec3d vec3 = vec.method_1031((vec2.field_1352 * distance), (vec2.field_1351 * distance), (vec2.field_1350 * distance));
        Box box = SharedKt.getPlayer().method_5829().method_18804(vec2.method_1021(distance)).method_1009(1.0D, 1.0D, 1.0D);
        class_3966 class3966 = class_1675.method_18075(SharedKt.getPlayer(), vec, vec3, box, this::checkCondition2, offset);
        if (__UNDEF_KEY__ == null) {
            if (class3966 != null) {
            } else {
                class3966.method_17784();
            }
        }
        return null;
    }

    public float computeValue(double x, double z) {
        if (SharedKt.getMc().player == null) {
            return 0.0F;
        }
        double offset = (SharedKt.getPlayer().getX() - x);
        double offset2 = (SharedKt.getPlayer().getZ() - z);
        return ((offset * offset) + (offset2 * offset2));
    }

    public float computeValue(double x, double z) {
        return Math.sqrt(this.computeValue(x, z));
    }

    public void updateValue4() {
        SharedKt.getNetwork().method_52787(((Packet) new ClientCommandC2SPacket(SharedKt.getPlayer(), class_2849.field_12985)));
        SharedKt.getPlayer().method_5728(false);
        SharedKt.getPlayer().field_3919 = false;
    }

    public class_239 resolveMinecraftObject(double blockInteractionRange, double entityInteractionRange, float yaw, float pitch) {
        double offset = Math.max(blockInteractionRange, entityInteractionRange);
        double offset2 = class_3532.method_33723(offset);
        Vec3d vec = SharedKt.getPlayer().getEyePos();
        class_239 class239 = this.resolveMinecraftObject(blockInteractionRange, yaw, pitch);
        double offset3 = class239.method_17784().method_1025(vec);
        if (__UNDEF_KEY__ == null) {
            if (class239.method_17783() != class_240.field_1333) {
                offset2 = offset3;
                offset = Math.sqrt(offset3);
            }
        }
        Vec3d vec2 = this.resolveMinecraftObject(pitch, yaw);
        Vec3d vec3 = vec.method_1031((vec2.field_1352 * offset), (vec2.field_1351 * offset), (vec2.field_1350 * offset));
        Box box = SharedKt.getPlayer().method_5829().method_18804(vec2.method_1021(offset)).method_1009(1.0D, 1.0D, 1.0D);
        class_3966 class3966 = class_1675.method_18075(SharedKt.getPlayer(), vec, vec3, box, class_1301.field_52443, offset2);
        if (__UNDEF_KEY__ == null) {
        }
        if (__UNDEF_KEY__ == null) {
            if (class3966 != null && class3966.method_17784().method_1025(vec) < offset3) {
            } else {
            }
        }
        return this.resolveMinecraftObject(class239, vec, blockInteractionRange);
    }

    private class_239 resolveMinecraftObject(class_239 arg0, Vec3d arg1, double arg2) {
        Vec3d vec = arg0.method_17784();
        if (__UNDEF_KEY__ == null) {
            if (!(vec.method_24802(arg1, arg2))) {
                Vec3d vec2 = arg0.method_17784();
                Direction direction = Direction.method_10142((vec2.field_1352 - arg1.field_1352), (vec2.field_1351 - arg1.field_1351), (vec2.field_1350 - arg1.field_1350));
                return ((class_239) class_3965.method_17778(vec2, direction, BlockPos.ofFloored(vec2)));
            }
        }
        return arg0;
    }

    public class_239 resolveMinecraftObject(double l, float yaw, float pitch) {
        Vec3d vec = this.resolveMinecraftObject(pitch, yaw).method_1021(l);
        return ((class_239) SharedKt.getWorld().method_17742(new class_3959(SharedKt.getPlayer().getEyePos(), SharedKt.getPlayer().getEyePos().method_1019(vec), class_3960.field_17559, class_242.field_1348, SharedKt.getPlayer())));
    }

    public void updateValue5() {
        SharedKt.getMc().options.field_1894.method_23481(false);
        SharedKt.getMc().options.field_1881.method_23481(false);
        SharedKt.getMc().options.field_1913.method_23481(false);
        SharedKt.getMc().options.field_1849.method_23481(false);
        SharedKt.getMc().options.field_1903.method_23481(false);
        SharedKt.getMc().options.field_1832.method_23481(false);
    }

    public void updateValue6() {
        SharedKt.getMc().options.field_1894.method_23481(ServiceComponent13.checkCondition(((KeyMappingAccessor) SharedKt.getMc().options.field_1894).getKey().method_1444()));
        SharedKt.getMc().options.field_1881.method_23481(ServiceComponent13.checkCondition(((KeyMappingAccessor) SharedKt.getMc().options.field_1881).getKey().method_1444()));
        SharedKt.getMc().options.field_1913.method_23481(ServiceComponent13.checkCondition(((KeyMappingAccessor) SharedKt.getMc().options.field_1913).getKey().method_1444()));
        SharedKt.getMc().options.field_1849.method_23481(ServiceComponent13.checkCondition(((KeyMappingAccessor) SharedKt.getMc().options.field_1849).getKey().method_1444()));
        SharedKt.getMc().options.field_1903.method_23481(ServiceComponent13.checkCondition(((KeyMappingAccessor) SharedKt.getMc().options.field_1903).getKey().method_1444()));
        SharedKt.getMc().options.field_1832.method_23481(ServiceComponent13.checkCondition(((KeyMappingAccessor) SharedKt.getMc().options.field_1832).getKey().method_1444()));
    }

    private static boolean checkCondition(boolean arg0, Entity arg1) {
        if (!(arg1 instanceof LivingEntity)) {
            if (!(arg1.method_7325()) && arg1.method_5863() && !(arg0)) {
            } else {
            }
        }
        return false;
    }

    private static boolean checkCondition(Entity arg0) {
        return arg0.method_5863();
    }

    private static boolean checkCondition2(Entity arg0) {
        return !(arg0.method_7325());
    }

    static {
        INSTANCE = new EventPacketHelper2();
        timestampValue = -1L;
        timestampValue2 = -1L;
        timestampValue3 = -1L;
    }

    public static void updateValue(Module[] arg0) {
        moduleArray = arg0;
    }

    public static Module[] process() {
        return moduleArray;
    }

}
