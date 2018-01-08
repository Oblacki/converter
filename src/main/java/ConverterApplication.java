import com.kumuluz.ee.discovery.annotations.RegisterService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@RegisterService("convert")
@ApplicationPath("v1")
public class ConverterApplication extends Application {
}
