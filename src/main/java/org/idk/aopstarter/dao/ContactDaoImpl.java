package org.idk.aopstarter.dao;

import org.springframework.stereotype.Repository;

@Repository
public class ContactDaoImpl implements ContactDao{
    @Override
    public void addAccount() {
        System.out.println(getClass() + " DOING IN DB: ADD ACCOUNTS TO DATABASE");
    }
}
