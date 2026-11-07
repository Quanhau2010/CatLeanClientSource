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

    public void updateValue() {
        String[] items = new String[3];
        items[0] = ".ctl";
        items[1] = "ai";
        items[2] = "data.csv";
        String text = Paths.get(System.getProperty("user.home"), items).toString();
        file = new File(text);
        if (__UNDEF_KEY__ != null) {
            if (file == null) {
                Intrinsics.throwUninitializedPropertyAccessException("outputFile");
            }
        }
        if (!(null.exists())) {
            this.executeAction("delta_yaw,delta_pitch,desired_yaw1,desired_pitch1,desired_yaw2,desired_pitch2,desired_yaw3,desired_pitch3,delta_x,delta_y,delta_z,fallDistance,aimed,distanceFeet,distanceEyes,target_vel_x,target_vel_y,target_vel_z,my_vel_x,my_vel_y,my_vel_z,cd");
        }
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (EntityPacketHelper.findTarget(6.0F, AutoCrystalTargetSortMode.DISTANCE, false, false) == null) {
            EntityPacketHelper.findTarget(6.0F, AutoCrystalTargetSortMode.DISTANCE, false, false);
            return;
        }
        if (SharedKt.getMc().field_1765 instanceof class_3966 && Intrinsics.areEqual(((class_3966) SharedKt.getMc().field_1765).method_17782())) {
        } else {
        }
        float factor = 0.0F;
        MoveFixServiceComponent moveFixServiceComponent = MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent(this.getEyePos());
        float factor2 = ((moveFixServiceComponent.getNumericValue() - SharedKt.getPlayer().method_36454()) / 180.0F);
        float factor3 = ((moveFixServiceComponent.getNumericValue2() - SharedKt.getPlayer().method_36455()) / 90.0F);
        MoveFixServiceComponent moveFixServiceComponent2 = MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent(this.method_5829().method_1005());
        float factor4 = ((moveFixServiceComponent2.getNumericValue() - SharedKt.getPlayer().method_36454()) / 180.0F);
        float factor5 = ((moveFixServiceComponent2.getNumericValue2() - SharedKt.getPlayer().method_36455()) / 90.0F);
        MoveFixServiceComponent moveFixServiceComponent3 = MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent(this.resolveMinecraftObject());
        float factor6 = ((moveFixServiceComponent3.getNumericValue() - SharedKt.getPlayer().method_36454()) / 180.0F);
        float factor7 = ((moveFixServiceComponent3.getNumericValue2() - SharedKt.getPlayer().method_36455()) / 90.0F);
        double offset = (SharedKt.getPlayer().getX() - this.getX());
        double offset2 = (SharedKt.getPlayer().getY() - this.getY());
        double offset3 = (SharedKt.getPlayer().getZ() - this.getZ());
        float factor8 = ((SharedKt.getPlayer().method_36454() - factorValue) / 180.0F);
        float factor9 = ((SharedKt.getPlayer().method_36455() - factorValue2) / 90.0F);
        factorValue = SharedKt.getPlayer().method_36454();
        factorValue2 = SharedKt.getPlayer().method_36455();
        double offset4 = (SharedKt.getPlayer().getEyePos().method_1022(this.getEyePos()) / 6.0F);
        double offset5 = (SharedKt.getPlayer().getEyePos().method_1022(this.resolveMinecraftObject()) / 6.0F);
        Vec3d vec = new Vec3d((this.getX() - this.field_6014), (this.getY() - this.field_6036), (this.getZ() - this.field_5969));
        Vec3d vec2 = SharedKt.getPlayer().method_18798();
        String text = (factor8 + factor9 + factor2 + factor3 + factor4 + factor5 + factor6 + factor7 + offset + offset2 + offset3 + EventPacketHelper2.INSTANCE.getNumericValue() + factor + offset5 + offset4 + vec.field_1352 + vec.field_1351 + vec.field_1350 + vec2.field_1352 + vec2.field_1351 + vec2.field_1350 + SharedKt.getPlayer().method_7261(0.5F));
        this.executeAction(text);
        countValue = (countValue + 1);
        MessageServiceComponent.S(this, ("saved " + countValue + " lines"), false);
    }

    private void executeAction(String arg0) {
        concurrentLinkedQueue.add(arg0);
        this.updateValue();
    }

    private void updateValue() {
        if (file == null) {
            Intrinsics.throwUninitializedPropertyAccessException("outputFile");
        }
        Closeable closeable = ((Closeable) new FileWriter(null, true));
        FileWriter fileWriter = ((FileWriter) closeable);
        int index = 0;
        if (!(((Collection) concurrentLinkedQueue).isEmpty())) {
        }
        if (0) {
            fileWriter.append(((CharSequence) concurrentLinkedQueue.poll()));
            fileWriter.append(((CharSequence) "\n"));
        }
        fileWriter = Unit.INSTANCE;
        CloseableKt.closeFinally(closeable);
        index = 1;
        int index2 = index;
        CloseableKt.closeFinally(closeable, index2);
        closeable = index;
        System.out.println(("\u041e\u0448\u0438\u0431\u043a\u0430 \u0437\u0430\u043f\u0438\u0441\u0438 \u0432 \u0444\u0430\u0439\u043b: " + closeable.getMessage()));
    }

    static {
        INSTANCE = new AiDataCollectorModule();
        concurrentLinkedQueue = new ConcurrentLinkedQueue();
    }

}
