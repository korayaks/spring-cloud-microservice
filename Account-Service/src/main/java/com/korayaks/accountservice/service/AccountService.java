package com.korayaks.accountservice.service;

import com.korayaks.client.contract.AccountDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface AccountService {
     AccountDto get(String id);
     AccountDto save(AccountDto account);
     AccountDto update(String id, AccountDto account);
     void delete(String id);
     Slice<AccountDto> getAll(Pageable pageable);
}
