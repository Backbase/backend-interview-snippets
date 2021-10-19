package repository;

// import statements

@Entity
public class AccountTypeEntity {

    @Id
    private Long id;

    @Column
    private String name;
}
