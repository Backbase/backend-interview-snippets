package repository;

import javax.persistence.Entity;

@Entity
public class TransferEntity {

    private long id;
    private AccountEntity from;
    private AccountEntity target;

    // Getters/Setters
}
