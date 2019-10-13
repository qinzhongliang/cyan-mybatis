package com.cyan.mapper;

import com.cyan.pojo.Account;

import java.util.List;

public interface AccountMapper {
    Account selectAccountById(Integer id);
    List<Account> getAccountList();
    List<Account> selectAccountList();
}
