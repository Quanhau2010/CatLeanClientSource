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
        ThreadsKt.thread$default(true, false, null, "Discord IPC - Pipe thread", 0, this::resolveUnit, timestampValue);
    }

    protected void executeAction(ByteBuffer buffer) {
        Object element = this;
        BufferOpcodeServiceComponent2Impl2 bufferOpcodeServiceComponent2Impl2 = ((BufferOpcodeServiceComponent2Impl2) element);
        int index = 0;
        bufferOpcodeServiceComponent2Impl2.randomAccessFile.write(buffer.array());
        bufferOpcodeServiceComponent2Impl2 = Result.constructor_impl(Unit.INSTANCE);
        bufferOpcodeServiceComponent2Impl2 = Result.constructor_impl(ResultKt.createFailure(index));
        element = bufferOpcodeServiceComponent2Impl2;
        if (Result.exceptionOrNull_impl(element) != null) {
            bufferOpcodeServiceComponent2Impl2 = Result.exceptionOrNull_impl(element);
            index = bufferOpcodeServiceComponent2Impl2;
            AppIdXDGRUNTIMEDIRServiceComponentImpl.INSTANCE.resolveUnit();
        } else {
        }
    }

    private void executeAction() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(4);
        this.executeAction(byteBuffer);
        OptionMode2 optionMode2 = ((OptionMode2) OptionMode2.getEnumEntries().get(Integer.reverseBytes(byteBuffer.getInt(0))));
        this.executeAction(byteBuffer);
        int index = Integer.reverseBytes(byteBuffer.getInt(0));
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(index);
        this.executeAction(byteBuffer2);
        String text = Charset.defaultCharset().decode(byteBuffer2.rewind()).toString();
        Json json = ServiceComponent80.getJson();
        json.getSerializersModule();
        AppIdXDGRUNTIMEDIRServiceComponentImpl.INSTANCE.resolveUnit(new OpcodeServiceComponent(optionMode2, ((EvtRecord) json.decodeFromString(((DeserializationStrategy) EvtRecord.serviceComponent25.getKSerializer()), text))));
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
        BufferOpcodeServiceComponent2Impl2 bufferOpcodeServiceComponent2Impl2 = ((BufferOpcodeServiceComponent2Impl2) this);
        int index = 0;
        bufferOpcodeServiceComponent2Impl2.randomAccessFile.close();
        bufferOpcodeServiceComponent2Impl2 = Result.constructor_impl(Unit.INSTANCE);
        bufferOpcodeServiceComponent2Impl2 = Result.constructor_impl(ResultKt.createFailure(index));
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
