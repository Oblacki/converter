
import com.kumuluz.ee.configuration.cdi.ConfigBundle;
import com.kumuluz.ee.configuration.cdi.ConfigValue;
import javax.enterprise.context.ApplicationScoped;

@ConfigBundle("rest-properties")
@ApplicationScoped
public class RestProperties {

    @ConfigValue(value = "external-services.apartment-service.enabled", watch = true)
    private boolean converterServiceEnabled;

    private boolean healthy;

    public boolean isHealthy() {
        return healthy;
    }

    public void setHealthy(boolean healthy) {
        this.healthy = healthy;
    }

    public boolean isApartmentServiceEnabled() {
        return converterServiceEnabled;
    }

    public void setConverterServiceEnabled(boolean converterServiceEnabled) {
        this.converterServiceEnabled = converterServiceEnabled;
    }
}