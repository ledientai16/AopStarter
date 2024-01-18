package org.idk.aopstarter.dao;

import org.idk.aopstarter.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("AccountDao")
public class AccountDaoImpl implements AccountDao{
    @Override
    public void addAccount() {
        System.out.println(getClass() + " DOING IN DB: ADD ACCOUNTS TO DATABASE");
    }

    @Override
    public void addAccount(Account theAccount, Boolean flg) {
        System.out.println(getClass() + " 2 DOING IN DB: ADD ACCOUNTS WITH PARAM TO DATABASE");
    }

    @Override
    public void addContact() {
        System.out.println(getClass() + " DOING IN DB: ADD CONTACT TO DATABASE");
    }

    @Override
    public Boolean addSillyMember() {
        System.out.println(getClass() + " DOING IN DB: ADD SILLY MEMBER TO DATABASE");
        return true;
    }

    @Override
    public Boolean doWork() {
        System.out.println(getClass() + " DOING IN DB: DO WORK SOME THING FUN");
        return true;
    }

    @Override
    public void getAccount() {
        System.out.println(getClass() + " DOING IN DB: GET ACCOUNT");
    }

    @Override
    public void setAccount() {
        System.out.println(getClass() + " DOING IN DB: SET ACCOUNT");
    }

    @Override
    public List<Account> findAccount() {
        return findAccount(false);
    }

    @Override
    public List<Account> findAccount(boolean isExc) {
        if (isExc) {
            throw new RuntimeException("Send my love for you");
        }
        List<Account> accounts = new ArrayList<>();

        accounts.add(new Account("Adam", "LK"));
        accounts.add(new Account("Adam2", "LK"));
        accounts.add(new Account("Adam3", "LK"));
        accounts.add(new Account("Adam3", "LK"));

        return accounts;
    }
}
