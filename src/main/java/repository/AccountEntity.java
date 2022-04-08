package repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AccountEntity {

    @Id
    @GeneratedValue
    private Long id;

    private long accountHolderId;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private AccountTypeEntity type;

    @Column
    private String name;

    @Column
    private boolean closed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getAccountHolderId() {
        return accountHolderId;
    }

    public void setAccountHolderId(long accountHolderId) {
        this.accountHolderId = accountHolderId;
    }

    public AccountTypeEntity getType() {
        return type;
    }

    public void setType(AccountTypeEntity type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }
}
