package org.idk.aopstarter.dao;

import org.idk.aopstarter.Account;

import java.util.List;

public interface AccountDao {
    void addAccount();
    void addAccount(Account theAccount, Boolean flg);
    void addContact();
    Boolean addSillyMember();
    Boolean doWork();
    void getAccount();
    void setAccount();
    List<Account> findAccount();

    List<Account> findAccount(boolean isExc);
}
