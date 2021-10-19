package repository;

// import statements

@Entity
public class AccountEntity {

    @Id
    private Long id;

    private long accountHolderId;

    @Column(name = "type_id")
    private Long typeId;

    @Column
    private String name;

    @Column
    private boolean closed;

    // Getters/Setters
}
