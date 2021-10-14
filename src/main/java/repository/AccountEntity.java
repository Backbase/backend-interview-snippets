package repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AccountEntity {

    @Id
    private Long id;

    @Column(name = "type_id")
    private Long typeId;

    @Column
    private String name;

    @Column
    private boolean closed;
}
