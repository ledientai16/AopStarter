package org.idk.aopstarter.dao;

import org.idk.aopstarter.Account;
import org.springframework.stereotype.Repository;

@Repository("MemberAccount")
public class MemberAccountDaoImpl  {

    public void addAccount() {
        System.out.println(getClass() + " DOING IN DB: ADD ACCOUNTS TO DATABASE");
    }


    public void addAccount(Account theAccount) {

    }
    public void addContact() {

    }
    public Boolean addSillyMember() {
        return null;
    }
}
