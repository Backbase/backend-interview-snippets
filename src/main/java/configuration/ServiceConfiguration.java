package configuration;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Validated
@Configuration
@ConfigurationProperties("config")
public class ServiceConfiguration {

    /**
     * Port number the service will listen to for remote commands.
     */
    @Min(1024)
    private int portNumber;

    /**
     * Labels assigned to the service, at least one must be present.
     */
    @NotNull
    @NotEmpty
    private List<@NotBlank String> labels = new ArrayList<>();

    public int getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(int portNumber) {
        this.portNumber = portNumber;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }
}
