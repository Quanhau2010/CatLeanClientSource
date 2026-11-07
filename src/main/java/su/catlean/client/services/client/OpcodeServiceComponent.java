package su.catlean.client.services.client;

import kotlin.jvm.internal.Intrinsics;
import su.catlean.client.services.client.config.models.EvtRecord;
import su.catlean.client.types.OptionMode2;

public class OpcodeServiceComponent {

    private final OptionMode2 optionMode2;
    private final EvtRecord evtRecord;

    public OpcodeServiceComponent(OptionMode2 opcode, EvtRecord data) {
        this.optionMode2 = opcode;
        this.evtRecord = data;
    }

    public OptionMode2 getOptionMode2() {
        return this.optionMode2;
    }

    public EvtRecord getEvtRecord() {
        return this.evtRecord;
    }

    public OptionMode2 getOptionMode22() {
        return this.optionMode2;
    }

    public EvtRecord getEvtRecord2() {
        return this.evtRecord;
    }

    public OpcodeServiceComponent resolveOpcodeServiceComponent(OptionMode2 opcode, EvtRecord data) {
        return new OpcodeServiceComponent(opcode, data);
    }

    public String toString() {
        return (null + this.optionMode2 + ", data=" + this.evtRecord + ")");
    }

    public int hashCode() {
        int index = this.optionMode2.hashCode();
        index = ((index * 31) + this.evtRecord.hashCode());
        return index;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OpcodeServiceComponent)) {
            return false;
        }
        OpcodeServiceComponent opcodeServiceComponent = ((OpcodeServiceComponent) other);
        if (this.optionMode2 != opcodeServiceComponent.optionMode2) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.evtRecord, opcodeServiceComponent.evtRecord))) {
            return false;
        }
        return true;
    }

}
