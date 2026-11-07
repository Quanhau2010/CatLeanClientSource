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
        String[] var6 = new String[4];
        var6[0] = "XDG_RUNTIME_DIR";
        var6[1] = "TMPDIR";
        var6[2] = "TMP";
        var6[3] = "TEMP";
        this.textValueArray = var6;
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
        if (var8 != null) {
        }
        this.executeAction();
        ServiceComponent76.INSTANCE.updateValue();
    }

    protected void executeAction(long appId) {
        if (var18 != null) {
            if (this.opcodeServiceComponent2 != null) {
                OpcodeServiceComponent2 var19 = this.opcodeServiceComponent2;
                int var20 = 0;
                this.resolveUnit();
            } else {
            }
        }
        if (0L > 0) {
            this.opcodeServiceComponent2 = this.resolveOpcodeServiceComponent2();
            if (var18 != null) {
            }
            if (this.opcodeServiceComponent2 != null) {
                var19 = this.opcodeServiceComponent2;
                var20 = 0;
                Json var21 = ServiceComponent80.getJson();
                VRecord var22 = new VRecord(1, String.valueOf(appId));
                int var23 = 0;
                var21.getSerializersModule();
                var19.executeAction(OptionMode2.HANDSHAKE, var21.encodeToJsonElement((SerializationStrategy) VRecord.serviceComponent35.getKSerializer()));
                this.updateValue2();
            } else {
            }
        }
    }

    protected void executeAction(DetailsRecord presence) {
        this.detailsRecord = presence;
    }

    public Unit resolveUnit() {
        if (var3 != null) {
            if (this.opcodeServiceComponent2 != null) {
                OpcodeServiceComponent2 var4 = this.opcodeServiceComponent2;
                int var5 = 0;
                var4.executeAction();
                this.opcodeServiceComponent2 = null;
                this.enabledFlag = 0;
                this.detailsRecord = null;
                this.idRecord22 = this.idRecord2;
            } else {
            }
        }
        return null;
    }

    private void executeAction() {
        if (var18 != null) {
            if (this.opcodeServiceComponent2 != null) {
                OpcodeServiceComponent2 var19 = this.opcodeServiceComponent2;
                int var20 = 0;
                if (var18 != null) {
                    if (this.detailsRecord != null) {
                        DetailsRecord var21 = this.detailsRecord;
                        int var22 = 0;
                        Json var23 = ServiceComponent80.getJson();
                        PidRecord var16 = new PidRecord(this.computeValue());
                        OptionMode var17 = OptionMode.SET_ACTIVITY;
                        CmdRecord var24 = new CmdRecord();
                        int var25 = 0;
                        var23.getSerializersModule();
                        var19.executeAction(OptionMode2.FRAME, var23.encodeToJsonElement((SerializationStrategy) CmdRecord.serviceComponent77.getKSerializer()));
                    } else {
                    }
                }
            } else {
            }
        }
        this.detailsRecord = null;
    }

    public Unit resolveUnit(OpcodeServiceComponent packet) {
        if (packet.getEvtRecord().getOptionMode4() == OptionMode4.ERROR) {
            System.out.println((b2WhenMappings.ENUM_SWITCH_MAP[packet.getOptionMode2().ordinal()] + packet.getEvtRecord().getUserRecord().getInteger() + " with message: " + packet.getEvtRecord().getUserRecord().getString()));
        } else {
            if (packet.getEvtRecord().getOptionMode() == OptionMode.DISPATCH) {
                this.enabledFlag = 1;
                this.idRecord22 = packet.getEvtRecord().getUserRecord().getIdRecord2();
                if (this.detailsRecord != null) {
                    DetailsRecord var10 = this.detailsRecord;
                    int var11 = 0;
                    this.executeAction();
                } else {
                } else {
                    System.out.println((Unit.INSTANCE + packet.getEvtRecord().getUserRecord().getInteger() + " with message: " + packet.getEvtRecord().getUserRecord().getString()));
                }
            }
        }
        return Unit.INSTANCE;
    }

    private OpcodeServiceComponent2 resolveOpcodeServiceComponent2() {
        String var9 = System.getProperty("os.name");
        String var8 = var9.toLowerCase(Locale.getDefault());
        if (var7 != null) {
            if (StringsKt.contains$default((CharSequence) var8, (CharSequence) "win")) {
            }
            var9 = 10;
            int var10 = 0;
            if (var7 != null) {
                if (var10 < var9) {
                }
                int var11 = var10;
                int var12 = 0;
                Object var13 = this;
                XDGRUNTIMEDIRServiceComponent var14 = (XDGRUNTIMEDIRServiceComponent) var13;
                int var15 = 0;
                return (OpcodeServiceComponent2) new BufferOpcodeServiceComponent2Impl2(("\\\\?\\pipe\\discord-ipc-" + var11));
                Result.constructor-impl(ResultKt.createFailure());
            }
            var10 = this.textValueArray;
            var11 = 0;
            var12 = var10;
            if (var11 < var12) {
                var13 = var10[var11];
                var14 = 0;
                if (var7 != null) {
                    if (var7 != null && System.getenv() == null) {
                        System.getenv();
                    }
                }
            }
            var10 = 10;
            var11 = 0;
            if (var7 != null) {
                if (var11 < var10) {
                    var12 = var11;
                }
                var13 = 0;
                var14 = this;
                var15 = (XDGRUNTIMEDIRServiceComponent) var14;
                int var16 = 0;
                if (var9 == null) {
                }
                return (OpcodeServiceComponent2) new BufferOpcodeServiceComponent2Impl(("/tmp" + "/discord-ipc-" + var12));
                Result.constructor-impl(ResultKt.createFailure());
            }
        }
        return null;
    }

    private void updateValue2() {
        ThreadsKt.thread$default(1, 1, null, "Discord IPC - Update thread", 0, this::resolveUnit);
    }

    private static Unit resolveUnit(XDGRUNTIMEDIRServiceComponent arg0) {
        if (arg0.checkCondition()) {
            Object var8 = arg0;
            Object var9 = var8;
            int var10 = 0;
            var9.updateValue();
            if (var7 != null) {
                var9 = Result.constructor-impl(Unit.INSTANCE);
                var9 = Result.constructor-impl(ResultKt.createFailure());
                Thread.sleep(timestampValue2);
            }
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
