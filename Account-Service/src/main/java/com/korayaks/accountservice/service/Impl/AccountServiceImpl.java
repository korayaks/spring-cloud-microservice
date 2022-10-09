package com.korayaks.accountservice.service.Impl;

import com.korayaks.accountservice.entity.Account;
import com.korayaks.accountservice.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    public Account get(String id) {
        return new Account("test-id");
    }
    public Account save(Account account) {
        return new Account("test-id");
    }
    public Account update(Account account) {
        return new Account("test-id");
    }
    public void delete(String id) {

    }

}
