package repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<TransferEntity, Long> {

    List<TransferEntity> findByFromId(long accountId);
}
