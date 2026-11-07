package su.catlean.client.features.modules.pvp.attack;

import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_3966;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.MessageServiceComponent;
import su.catlean.client.services.client.MoveFixServiceComponent;
import su.catlean.client.services.client.VectorServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EntityPacketHelper;
import su.catlean.client.services.network.EventPacketHelper2;

public class AiDataCollectorModule extends Module {

    public static final AiDataCollectorModule INSTANCE;
    private static final ConcurrentLinkedQueue concurrentLinkedQueue;
    private static float factorValue;
    private static float factorValue2;
    private static int countValue;
    private static File file;

    private AiDataCollectorModule() {
        super("ai-data-collector", SubCategoriesKt.getAttackCategory());
    }

    public int getNumericValue() {
        return countValue;
    }

    public void updateValue(int value) {
        countValue = value;
    }

    public void updateValue(long arg0) {
        long var3 = ((arg0 ^ 57052227101120L) >>> 48);
        long var4 = (((arg0 ^ 57052227101120L) << 16) >>> 48);
        long var5 = (((arg0 ^ 57052227101120L) << 32) >>> 32);
        String[] var8 = new String[3];
        var8[0] = ".ctl";
        var8[1] = "ai";
        var8[2] = "data.csv";
        String var7 = Paths.get(System.getProperty("user.home")).toString();
        file = new File();
        if (var6 != null) {
            if (arg0 > 0L && file == null) {
                Intrinsics.throwUninitializedPropertyAccessException("outputFile");
            }
        }
        if (!(null.exists())) {
            this.executeAction("delta_yaw,delta_pitch,desired_yaw1,desired_pitch1,desired_yaw2,desired_pitch2,desired_yaw3,desired_pitch3,delta_x,delta_y,delta_z,fallDistance,aimed,distanceFeet,distanceEyes,target_vel_x,target_vel_y,target_vel_z,my_vel_x,my_vel_y,my_vel_z,cd");
        }
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (EntityPacketHelper.findTarget(6.0F, AutoCrystalTargetSortMode.DISTANCE) == null) {
            EntityPacketHelper.findTarget(6.0F, AutoCrystalTargetSortMode.DISTANCE);
            return;
        }
        if (SharedKt.getMc().field_1765 instanceof class_3966 && Intrinsics.areEqual((class_3966) SharedKt.getMc().field_1765.method_17782())) {
        } else {
        }
        float var23 = 0.0F;
        MoveFixServiceComponent var24 = MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent(var22.getEyePos());
        float var25 = ((var24.getNumericValue() - SharedKt.getPlayer().method_36454()) / 180.0F);
        float var26 = ((var24.getNumericValue2() - SharedKt.getPlayer().method_36455()) / 90.0F);
        MoveFixServiceComponent var27 = MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent(var22.method_5829().method_1005());
        float var28 = ((var27.getNumericValue() - SharedKt.getPlayer().method_36454()) / 180.0F);
        float var29 = ((var27.getNumericValue2() - SharedKt.getPlayer().method_36455()) / 90.0F);
        MoveFixServiceComponent var30 = MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent(this.resolveMinecraftObject());
        float var31 = ((var30.getNumericValue() - SharedKt.getPlayer().method_36454()) / 180.0F);
        float var32 = ((var30.getNumericValue2() - SharedKt.getPlayer().method_36455()) / 90.0F);
        double var33 = (SharedKt.getPlayer().getX() - var22.getX());
        double var35 = (SharedKt.getPlayer().getY() - var22.getY());
        double var37 = (SharedKt.getPlayer().getZ() - var22.getZ());
        float var39 = ((SharedKt.getPlayer().method_36454() - factorValue) / 180.0F);
        float var40 = ((SharedKt.getPlayer().method_36455() - factorValue2) / 90.0F);
        factorValue = SharedKt.getPlayer().method_36454();
        factorValue2 = SharedKt.getPlayer().method_36455();
        double var41 = (SharedKt.getPlayer().getEyePos().method_1022(var22.getEyePos()) / 6.0F);
        double var43 = (SharedKt.getPlayer().getEyePos().method_1022(this.resolveMinecraftObject()) / 6.0F);
        Vec3d vec = new Vec3d((var22.getX() - var22.field_6014), (var22.getY() - var22.field_6036), (var22.getZ() - var22.field_5969));
        Vec3d vec2 = SharedKt.getPlayer().method_18798();
        String var47 = (var39 + var40 + var25 + var26 + var28 + var29 + var31 + var32 + var33 + var35 + var37 + EventPacketHelper2.INSTANCE.getNumericValue() + var23 + var43 + var41 + vec.field_1352 + vec.field_1351 + vec.field_1350 + vec2.field_1352 + vec2.field_1351 + vec2.field_1350 + SharedKt.getPlayer().method_7261(0.5F));
        this.executeAction();
        int var48 = countValue;
        countValue = (var48 + 1);
        MessageServiceComponent.S(this, ("saved " + countValue + " lines"));
    }

    private void executeAction(String arg0) {
        concurrentLinkedQueue.add(arg0);
        this.updateValue();
    }

    private void updateValue() {
        if (file == null) {
            Intrinsics.throwUninitializedPropertyAccessException("outputFile");
        }
        Closeable var4 = (Closeable) new FileWriter(null, 1);
        FileWriter var6 = (FileWriter) var4;
        int var7 = 0;
        if (!((Collection) concurrentLinkedQueue.isEmpty())) {
            if (var3 != null) {
            }
        }
        if (0) {
            var6.append((CharSequence) concurrentLinkedQueue.poll());
            var6.append((CharSequence) "\n");
        }
        var6 = Unit.INSTANCE;
        CloseableKt.closeFinally();
        var7 = 1;
        Object var5 = var7;
        CloseableKt.closeFinally();
        var4 = var7;
        System.out.println(("\u041e\u0448\u0438\u0431\u043a\u0430 \u0437\u0430\u043f\u0438\u0441\u0438 \u0432 \u0444\u0430\u0439\u043b: " + var4.getMessage()));
    }

    static {
        INSTANCE = new AiDataCollectorModule();
        concurrentLinkedQueue = new ConcurrentLinkedQueue();
    }

}
