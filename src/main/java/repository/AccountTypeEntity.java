package repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AccountTypeEntity {

    @Id
    private Long id;

    @Column
    private String name;
}
