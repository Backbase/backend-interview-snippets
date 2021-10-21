package client;

import java.time.LocalDate;

public class AccountCreationRequest {

    /**
     * Mandatory name of the account for the end-user.
     */
    private String name;

    /**
     * Date that the account should be usable by the end-user, must be after the current date.
     */
    private LocalDate activationDate;

    /**
     * Interest rate, this is not Europe, so it must be zero or higher.
     */
    private double interestRate;

    // Getters/Setters
}
