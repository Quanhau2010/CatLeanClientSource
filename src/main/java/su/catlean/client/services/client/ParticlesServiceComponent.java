package su.catlean.client.services.client;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

public class ParticlesServiceComponent {

    private final int countValue;
    private final List itemList;

    public ParticlesServiceComponent(int playerId, List particles) {
        this.countValue = playerId;
        this.itemList = particles;
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
        if ((arg3 & 1) != 0) {
            arg1 = arg0.countValue;
        }
        if ((arg3 & 2) != 0) {
            arg2 = arg0.itemList;
        }
        return arg0.resolveParticlesServiceComponent(arg1, arg2);
    }

    public String toString() {
        return (null + this.countValue + ", particles=" + this.itemList + ")");
    }

    public int hashCode() {
        int index = Integer.hashCode(this.countValue);
        index = ((index * 31) + this.itemList.hashCode());
        return index;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ParticlesServiceComponent)) {
            return false;
        }
        ParticlesServiceComponent particlesServiceComponent = ((ParticlesServiceComponent) other);
        if (this.countValue != particlesServiceComponent.countValue) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.itemList, particlesServiceComponent.itemList))) {
            return false;
        }
        return true;
    }

}
