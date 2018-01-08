import com.fasterxml.jackson.databind.ObjectMapper;

import com.kumuluz.ee.configuration.utils.ConfigurationUtil;
import com.kumuluz.ee.discovery.annotations.DiscoverService;

import javax.enterprise.context.RequestScoped;
import com.kumuluz.ee.logs.cdi.Log;
import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.xml.crypto.Data;

import org.eclipse.microprofile.metrics.annotation.Metered;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;

@RequestScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("convert")
@Log
public class CustomerResource {

    private Client httpClient;
    private ObjectMapper objectMapper;

    @Inject
    @DiscoverService(value = "convert", version = "1.0.x", environment = "dev")
    private Optional<String> baseUrl;

    @PostConstruct
    private void init() {
        httpClient = ClientBuilder.newClient();
        objectMapper = new ObjectMapper();
    }

    @Inject
    private RestProperties restProperties;


    @GET
    @Path("Us_Eu/{value}")
    public Response usToEu(@PathParam("value") String value) {
        double rate = Database.getRateUsEu();
        return Response.ok(Double.parseDouble(value) * rate).build();
    }

    @GET
    @Path("Eu_Us/{value}")
    public Response euToUs(@PathParam("value") String value) {
        double rate = Database.getRateEuUs();
        return Response.ok(Double.parseDouble(value) * rate).build();
    }

    @GET
    @Path("setRateUsEu/{value}")
    public Response setRateUsEu(@PathParam("value") String value) {
        Database.setRateUsEu(Double.parseDouble(value));
        return Response.noContent().build();
    }

    @GET
    @Path("setRateEuUs/{value}")
    public Response setRateEuUs(@PathParam("value") String value) {
        Database.setRateEuUs(Double.parseDouble(value));
        return Response.noContent().build();
    }
}
