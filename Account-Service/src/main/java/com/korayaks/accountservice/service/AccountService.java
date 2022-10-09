package com.korayaks.accountservice.service;

import com.korayaks.accountservice.entity.Account;

import java.util.List;

public interface AccountService {
     Account get(String id);
     Account save(Account account);
     Account update(String id, Account account);
     void delete(String id);
     List<Account> getAll();
}
