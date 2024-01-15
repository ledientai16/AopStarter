package org.idk.aopstarter.dao;

import org.springframework.stereotype.Repository;

@Repository("AccountDao")
public class AccountDaoImpl implements AccountDao{
    @Override
    public void addAccount() {
        System.out.println(getClass() + " DOING IN DB: ADD ACCOUNTS TO DATABASE");
    }
}
