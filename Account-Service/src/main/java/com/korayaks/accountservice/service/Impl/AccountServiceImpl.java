package com.korayaks.accountservice.service.Impl;

import com.korayaks.accountservice.entity.Account;
import com.korayaks.accountservice.repository.AccountRepository;
import com.korayaks.accountservice.service.AccountService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;


    public Account get(String id) {
        return accountRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public Account save(Account account) {
        return accountRepository.save(account);
    }

    public Account update(String id, Account account) {
        Assert.isNull(id, "id cannot be null!");
        return accountRepository.save(account);
    }

    public void delete(String id) {

    }

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

}
