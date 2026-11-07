package su.catlean.mixins.accessors;

import java.util.Map;
import java.util.SequencedMap;
import net.minecraft.class_1921;
import net.minecraft.class_9799;

public interface ImmediateAccessor {

    public SequencedMap getLayers();

    public class_1921 getLastSharedType();

    public void setLastSharedType(class_1921 value);

    public class_9799 getSharedBuffer();

    public Map getStartedBuilders();

}
