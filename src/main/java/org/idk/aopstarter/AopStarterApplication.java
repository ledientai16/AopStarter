package org.idk.aopstarter;

import org.idk.aopstarter.dao.AccountDao;
import org.idk.aopstarter.dao.ContactDao;
import org.idk.aopstarter.dao.MemberAccountDaoImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopStarterApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(
            @Qualifier("AccountDao") AccountDao theAccountDao,
            @Qualifier("MemberAccount")AccountDao theMemberAccountDao,
            ContactDao theContactDao
            ) {
        return runner -> {
            doTheBeforeAspect(theAccountDao, theMemberAccountDao, theContactDao);
        };
    }

    private void doTheBeforeAspect(
            AccountDao theAccountDao,
            AccountDao theMemberAccountDao,
            ContactDao theContactDao
    ) {
        theAccountDao.addAccount();

        theMemberAccountDao.addAccount();

        theContactDao.addAccount();

    }
}
