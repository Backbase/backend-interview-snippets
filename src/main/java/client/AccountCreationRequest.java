package client;

import java.time.LocalDate;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AccountCreationRequest {

    /**
     * Mandatory name of the account for the end-user.
     */
    @NotBlank
    private String name;

    /**
     * Date that the account should be usable by the end-user, must be after the current date.
     */
    @NotNull
    @Future
    private LocalDate activationDate;

    /**
     * Interest rate, this is not Europe, so it must be zero or higher.
     */
    @Min(0)
    private double interestRate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(LocalDate activationDate) {
        this.activationDate = activationDate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
