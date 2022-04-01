package controller;

import repository.TransferEntity;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.AccountEntity;
import repository.AccountRepository;
import repository.TransferRepository;

@RestController("/v1/transfer")
public class TransferController {

    private AccountRepository accountRepository;
    private TransferRepository transferRepository;

    @GetMapping
    public List<TransferEntity> getMyTransfers(long accountId) {
        AccountEntity account = accountRepository.getOne(accountId);
        return transferRepository.findByFromId(account.getId());
    }
}
