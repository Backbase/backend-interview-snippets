package configuration;

import java.util.ArrayList;
import java.util.List;
// more import statements

@Configuration
@ConfigurationProperties("config")
public class ServiceConfiguration {

    /**
     * Port number the service will listen to for remote commands.
     */
    private int portNumber;

    /**
     * Labels assigned to the service, at least one must be present.
     */
    private List<String> labels = new ArrayList<>();

    // Getters/Setters
}
