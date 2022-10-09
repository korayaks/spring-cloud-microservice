package com.korayaks.accountservice.service;

import com.korayaks.accountservice.entity.Account;

public interface AccountService {
    public Account get(String id);
    public Account save(Account account);
    public Account update(Account account);
    public void delete(String id);
}
