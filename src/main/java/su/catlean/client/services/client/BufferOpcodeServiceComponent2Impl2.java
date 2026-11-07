package su.catlean.client.services.client;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.concurrent.ThreadsKt;
import kotlin.enums.EnumEntries;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.json.Json;
import su.catlean.client.services.client.config.models.EvtRecord;
import su.catlean.client.types.OptionMode2;

public class BufferOpcodeServiceComponent2Impl2 extends OpcodeServiceComponent2 {

    private final RandomAccessFile randomAccessFile;
    private static boolean enabledFlag;

    public BufferOpcodeServiceComponent2Impl2(String name) {
        super();
        this.randomAccessFile = new RandomAccessFile(name, "rw");
        ThreadsKt.thread$default(1, 0, null, "Discord IPC - Pipe thread", 0, this::resolveUnit, timestampValue);
    }

    protected void executeAction(ByteBuffer buffer) {
        long var4 = (0L ^ 32913269016412L);
        Object var6 = this;
        BufferOpcodeServiceComponent2Impl2 var7 = (BufferOpcodeServiceComponent2Impl2) var6;
        int var8 = 0;
        var7.randomAccessFile.write(buffer.array());
        var7 = Result.constructor-impl(Unit.INSTANCE);
        var7 = Result.constructor-impl(ResultKt.createFailure());
        var6 = var7;
        if (Result.exceptionOrNull-impl() != null) {
            var7 = Result.exceptionOrNull-impl();
            var8 = var7;
            int var9 = 0;
            AppIdXDGRUNTIMEDIRServiceComponentImpl.INSTANCE.resolveUnit();
        } else {
        }
    }

    private void executeAction() {
        ByteBuffer var14 = ByteBuffer.allocate(4);
        this.executeAction();
        OptionMode2 var15 = (OptionMode2) OptionMode2.getEnumEntries().get(Integer.reverseBytes(var14.getInt(0)));
        this.executeAction();
        int var16 = Integer.reverseBytes(var14.getInt(0));
        ByteBuffer var17 = ByteBuffer.allocate();
        this.executeAction();
        String var18 = Charset.defaultCharset().decode(var17.rewind()).toString();
        Json var19 = ServiceComponent80.getJson();
        Object var20 = var18;
        int var21 = 0;
        var19.getSerializersModule();
        AppIdXDGRUNTIMEDIRServiceComponentImpl.INSTANCE.resolveUnit(new OpcodeServiceComponent((EvtRecord) var19.decodeFromString((DeserializationStrategy) EvtRecord.serviceComponent25.getKSerializer())));
    }

    private void executeAction(int arg0, ByteBuffer arg1) {
        arg1.rewind();
        if (this.randomAccessFile.length() < arg1.remaining()) {
            Thread.onSpinWait();
            Thread.sleep(100L);
            if (arg0 >= 0) {
            }
        }
        this.randomAccessFile.getChannel().read(arg1);
    }

    public void executeAction() {
        Object var1 = this;
        BufferOpcodeServiceComponent2Impl2 var2 = (BufferOpcodeServiceComponent2Impl2) var1;
        int var3 = 0;
        var2.randomAccessFile.close();
        var2 = Result.constructor-impl(Unit.INSTANCE);
        var2 = Result.constructor-impl(ResultKt.createFailure());
    }

    private static Unit resolveUnit(BufferOpcodeServiceComponent2Impl2 arg0) {
        arg0.executeAction();
        return Unit.INSTANCE;
    }

    public static void updateValue(boolean arg0) {
        enabledFlag = arg0;
    }

    public static boolean isActive() {
        return enabledFlag;
    }

    public static boolean isActive2() {
        return true;
        return false;
    }

}
