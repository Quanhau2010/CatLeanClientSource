package su.catlean.client.services.client;

import java.io.PrintStream;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.time.Instant;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.concurrent.ThreadsKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.json.Json;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.config.models.CmdRecord;
import su.catlean.client.services.client.config.models.DetailsRecord;
import su.catlean.client.services.client.config.models.EvtRecord;
import su.catlean.client.services.client.config.models.IdRecord2;
import su.catlean.client.services.client.config.models.PidRecord;
import su.catlean.client.services.client.config.models.UserRecord;
import su.catlean.client.services.client.config.models.VRecord;
import su.catlean.client.types.OptionMode;
import su.catlean.client.types.OptionMode2;
import su.catlean.client.types.OptionMode4;
import su.catlean.client.types.mappings.b2WhenMappings;

public class XDGRUNTIMEDIRServiceComponent {

    private final String[] textValueArray;
    private OpcodeServiceComponent2 opcodeServiceComponent2;
    private boolean enabledFlag;
    private DetailsRecord detailsRecord;
    private final IdRecord2 idRecord2;
    private IdRecord2 idRecord22;
    private static Module[] moduleArray;
    private static final long timestampValue2;

    public XDGRUNTIMEDIRServiceComponent() {
        String[] items = new String[4];
        items[0] = "XDG_RUNTIME_DIR";
        items[1] = "TMPDIR";
        items[2] = "TMP";
        items[3] = "TEMP";
        this.textValueArray = items;
        this.timestampValue = Instant.now().getEpochSecond();
        this.idRecord2 = new IdRecord2();
        this.idRecord22 = this.idRecord2;
    }

    public long getNumericValue() {
        return this.timestampValue;
    }

    public IdRecord2 getIdRecord2() {
        return this.idRecord2;
    }

    public IdRecord2 getIdRecord22() {
        return this.idRecord22;
    }

    public boolean checkCondition() {
        return this.opcodeServiceComponent2 != null;
    }

    private int computeValue() {
        return Integer.parseInt(StringsKt.substringBefore$default(ManagementFactory.getRuntimeMXBean().getName()));
    }

    protected void updateValue() {
        this.executeAction();
        ServiceComponent76.INSTANCE.updateValue();
    }

    protected void executeAction(long appId) {
        this.resolveUnit();
        if (__UNDEF_KEY__ > 0) {
            this.opcodeServiceComponent2 = this.resolveOpcodeServiceComponent2();
        } else {
            if (this.opcodeServiceComponent2 != null) {
                OpcodeServiceComponent2 opcodeServiceComponent2 = this.opcodeServiceComponent2;
                Json json = ServiceComponent80.getJson();
                VRecord vRecord = new VRecord(1, String.valueOf(appId));
                json.getSerializersModule();
                opcodeServiceComponent2.executeAction(OptionMode2.HANDSHAKE, json.encodeToJsonElement(((SerializationStrategy) VRecord.serviceComponent35.getKSerializer()), vRecord));
                this.updateValue2();
            } else {
            }
        }
    }

    protected void executeAction(DetailsRecord presence) {
        this.detailsRecord = presence;
    }

    public Unit resolveUnit() {
        this.executeAction();
        this.opcodeServiceComponent2 = null;
        this.enabledFlag = false;
        this.detailsRecord = null;
        this.idRecord22 = this.idRecord2;
        return null;
    }

    private void executeAction() {
        Json json = ServiceComponent80.getJson();
        PidRecord pidRecord = new PidRecord(this.computeValue());
        OptionMode optionMode = OptionMode.SET_ACTIVITY;
        CmdRecord cmdRecord = new CmdRecord(optionMode, pidRecord);
        json.getSerializersModule();
        this.executeAction(OptionMode2.FRAME, json.encodeToJsonElement(((SerializationStrategy) CmdRecord.serviceComponent77.getKSerializer()), cmdRecord));
        this.detailsRecord = null;
    }

    public Unit resolveUnit(OpcodeServiceComponent packet) {
        if (packet.getEvtRecord().getOptionMode4() == OptionMode4.ERROR) {
            System.out.println((b2WhenMappings.ENUM_SWITCH_MAP[packet.getOptionMode2().ordinal()] + packet.getEvtRecord().getUserRecord().getInteger() + " with message: " + packet.getEvtRecord().getUserRecord().getString()));
        } else {
            if (packet.getEvtRecord().getOptionMode() == OptionMode.DISPATCH) {
                this.enabledFlag = true;
                this.idRecord22 = packet.getEvtRecord().getUserRecord().getIdRecord2();
                if (this.detailsRecord != null) {
                    this.executeAction();
                } else {
                    System.out.println((Unit.INSTANCE + packet.getEvtRecord().getUserRecord().getInteger() + " with message: " + packet.getEvtRecord().getUserRecord().getString()));
                }
            } else {
            }
        }
        return Unit.INSTANCE;
    }

    private OpcodeServiceComponent2 resolveOpcodeServiceComponent2() {
        String text = System.getProperty("os.name");
        String text2 = text.toLowerCase(Locale.getDefault());
        if (__UNDEF_KEY__ != null) {
            if (StringsKt.contains$default(((CharSequence) text2), ((CharSequence) "win"), false)) {
                text = 10;
                int index = 0;
                if (__UNDEF_KEY__ != null) {
                    if (index < text) {
                        int index2 = index;
                        int index3 = 0;
                        Object element = this;
                        XDGRUNTIMEDIRServiceComponent xDGRUNTIMEDIRServiceComponent = ((XDGRUNTIMEDIRServiceComponent) element);
                        int index4 = 0;
                        return ((OpcodeServiceComponent2) new BufferOpcodeServiceComponent2Impl2(("\\\\?\\pipe\\discord-ipc-" + index2)));
                        Result.constructor_impl(ResultKt.createFailure(index4));
                        index = this.textValueArray;
                        index2 = 0;
                        index3 = index;
                        if (index2 < index3) {
                            element = index[index2];
                            xDGRUNTIMEDIRServiceComponent = 0;
                            if (__UNDEF_KEY__ != null) {
                                if (__UNDEF_KEY__ != null && System.getenv(element) == null) {
                                    System.getenv(element);
                                }
                            }
                        }
                        index = 10;
                        index2 = 0;
                        if (__UNDEF_KEY__ != null) {
                            if (index2 < index) {
                                index3 = index2;
                                element = 0;
                                xDGRUNTIMEDIRServiceComponent = this;
                                index4 = ((XDGRUNTIMEDIRServiceComponent) xDGRUNTIMEDIRServiceComponent);
                                int index5 = 0;
                                if (text == null) {
                                }
                                return ((OpcodeServiceComponent2) new BufferOpcodeServiceComponent2Impl(("/tmp" + "/discord-ipc-" + index3)));
                                Result.constructor_impl(ResultKt.createFailure(index5));
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    private void updateValue2() {
        ThreadsKt.thread$default(true, true, null, "Discord IPC - Update thread", 0, this::resolveUnit);
    }

    private static Unit resolveUnit(XDGRUNTIMEDIRServiceComponent arg0) {
        if (arg0.checkCondition()) {
            XDGRUNTIMEDIRServiceComponent xDGRUNTIMEDIRServiceComponent = arg0;
            int index = 0;
            xDGRUNTIMEDIRServiceComponent.updateValue();
            index = Unit.INSTANCE;
            xDGRUNTIMEDIRServiceComponent = Result.constructor_impl(ResultKt.createFailure(index));
            Thread.sleep(timestampValue2);
        }
        return Unit.INSTANCE;
    }

    public static void updateValue(Module[] arg0) {
        moduleArray = arg0;
    }

    public static Module[] process() {
        return moduleArray;
    }

}
