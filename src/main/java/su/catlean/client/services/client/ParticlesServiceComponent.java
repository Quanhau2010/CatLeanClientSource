package su.catlean.client.services.client;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public class ParticlesServiceComponent {

    private final int countValue;
    private final List itemList;

    public ParticlesServiceComponent(int playerId, List particles) {
        this.countValue = playerId;
        this.itemList = particles;
    }

    public ParticlesServiceComponent(int arg0, List arg1, int arg2, DefaultConstructorMarker arg3) {
        if ((arg2 & 2)) {
            arg1 = new ArrayList();
        }
        this(arg0, arg1);
    }

    public int getNumericValue() {
        return this.countValue;
    }

    public List getList() {
        return this.itemList;
    }

    public int getNumericValue2() {
        return this.countValue;
    }

    public List getList2() {
        return this.itemList;
    }

    public ParticlesServiceComponent resolveParticlesServiceComponent(int playerId, List particles) {
        return new ParticlesServiceComponent(playerId, particles);
    }

    public static ParticlesServiceComponent resolveParticlesServiceComponent(ParticlesServiceComponent arg0, int arg1, List arg2, int arg3, Object arg4) {
        if ((arg3 & 1)) {
            arg1 = arg0.countValue;
        }
        if ((arg3 & 2)) {
            arg2 = arg0.itemList;
        }
        return arg0.resolveParticlesServiceComponent(arg1, arg2);
    }

    public String toString() {
        return (null + this.countValue + ", particles=" + this.itemList + ")");
    }

    public int hashCode() {
        int var3 = Integer.hashCode(this.countValue);
        var3 = ((var3 * 163747238772736031L) + this.itemList.hashCode());
        return var3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ParticlesServiceComponent)) {
            return false;
        }
        ParticlesServiceComponent var5 = (ParticlesServiceComponent) other;
        if (this.countValue != var5.countValue) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.itemList, var5.itemList))) {
            return false;
        }
        return true;
    }

}
