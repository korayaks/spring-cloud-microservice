package com.korayaks.accountservice.service;

import com.korayaks.accountservice.dto.AccountDto;
import com.korayaks.accountservice.entity.Account;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface AccountService {
     AccountDto get(String id);
     AccountDto save(AccountDto account);
     AccountDto update(String id, AccountDto account);
     void delete(String id);
     Slice<AccountDto> getAll(Pageable pageable);
}
