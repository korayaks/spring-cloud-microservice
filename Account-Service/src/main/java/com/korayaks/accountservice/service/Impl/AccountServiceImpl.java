package com.korayaks.accountservice.service.Impl;

import com.korayaks.accountservice.entity.Account;
import com.korayaks.accountservice.repository.AccountRepository;
import com.korayaks.accountservice.service.AccountService;

import com.korayaks.client.contract.AccountDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final ModelMapper modelmapper;

    public AccountDto get(String id) {
        return modelmapper.map(accountRepository.findById(id).orElseThrow(IllegalArgumentException::new), AccountDto.class);
    }
    @Transactional
    public AccountDto save(AccountDto accountDto) {
        return modelmapper.map(accountRepository.save(modelmapper.map(accountDto,Account.class)),AccountDto.class);
    }
    @Transactional
    public AccountDto update(String id, AccountDto accountDto) {
        Assert.isNull(id, "id cannot be null!");
        Optional<Account> account = accountRepository.findById(id);
        Account updatedAccount = account.map(item ->{
            item.setBirthDate(accountDto.getBirthDate());
            item.setName(accountDto.getName());
            item.setSurname(accountDto.getSurname());
            return item;
        }).orElseThrow(IllegalArgumentException::new);
        return modelmapper.map(accountRepository.save(updatedAccount), AccountDto.class);
    }
    @Transactional
    public void delete(String id) {
        Account account = accountRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        accountRepository.delete(account);
    }

    @Override
    public Slice<AccountDto> getAll(Pageable pageable) {
        Slice<Account> accounts =  accountRepository.findAll(pageable);
        return null;
    }

}
