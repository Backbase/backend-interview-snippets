package repository;

import java.util.List;
// more import statements

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

    List<AccountEntity> findAllByTypeIdAndClosedFalse(long typeId);
}
