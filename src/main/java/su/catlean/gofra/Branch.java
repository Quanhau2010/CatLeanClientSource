package su.catlean.gofra;

import java.lang.invoke.CallSite;
import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.function.Consumer;

public class Branch {

    private final Class eventTarget;
    private final byte priority;
    private Consumer consumer;
    private Method privateLookupInMethod;

    public Branch(Class klass, Object obj, Method method) {
        this.eventTarget = method.getParameters()[0].getType();
        this.priority = ((Flow) method.getAnnotation(Flow.class)).priority();
        Class[] items = new Class[2];
        items[0] = Class.class;
        items[1] = Lookup.class;
        this.privateLookupInMethod = MethodHandles.class.getDeclaredMethod("privateLookupIn", items);
        Object[] items2 = new Object[2];
        items2[0] = klass;
        items2[1] = MethodHandles.lookup();
        items = ((Lookup) this.privateLookupInMethod.invoke(null, items2));
        MethodType methodType = MethodType.methodType(Void.TYPE, method.getParameters()[0].getType());
        items2 = items.findVirtual(klass, method.getName(), methodType);
        MethodType methodType2 = MethodType.methodType(Consumer.class, klass);
        this.consumer = LambdaMetafactory.metafactory(items, "accept", methodType2, MethodType.methodType(Void.TYPE, Object.class), items2, methodType).getTarget().invoke(obj);
    }

    public Class getEventTarget() {
        return this.eventTarget;
    }

    public byte getPriority() {
        return this.priority;
    }

    public void call(Object event) {
        this.consumer.accept(event);
    }

}
