package su.catlean.api.contracts;

import su.catlean.client.services.client.ServiceComponent20;
import su.catlean.client.services.client.config.models.KeyRecord;

public interface Contract8 {

    public static final ServiceComponent20 serviceComponent20 = null;

    public String getString();

    public void executeAction(String arg0);

    public KeyRecord getKeyRecord();

    public void executeAction(KeyRecord arg0);

    public boolean isActive();

    public void updateValue(boolean arg0);

}
