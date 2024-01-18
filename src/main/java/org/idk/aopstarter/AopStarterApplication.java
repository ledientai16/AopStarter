package org.idk.aopstarter;

import com.sun.source.tree.TryTree;
import org.idk.aopstarter.dao.AccountDao;
import org.idk.aopstarter.dao.ContactDao;
import org.idk.aopstarter.dao.MemberAccountDaoImpl;
import org.idk.aopstarter.service.TrafficFortuneService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopStarterApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(
            @Qualifier("AccountDao") AccountDao theAccountDao,
            ContactDao theContactDao,
            TrafficFortuneService theTrafficFortuneService
            ) {
        return runner -> {
            // doTheBeforeAspect(theAccountDao, theContactDao);
            // demoTheAfterReturningAspect(theAccountDao);
            // demoTheAfterThrowingAspect(theAccountDao);
            demoAroundAspect(theTrafficFortuneService);
        };
    }
    private void demoAroundAspect(TrafficFortuneService theTrafficFortuneService) {
        theTrafficFortuneService.getFortune(true);
    }
    private void demoTheAfterThrowingAspect(AccountDao theAccountDao) {
        try {
            List<Account> accounts = theAccountDao.findAccount(true);
        } catch (Exception theExc) {
            System.out.println("================> main errors: " + theExc.getMessage());
            throw theExc;
        }

    }

    private void demoTheAfterReturningAspect(AccountDao theAccountDao) {
        List<Account> accounts = theAccountDao.findAccount();

        System.out.println("accounts: " + accounts);
    }

    private void doTheBeforeAspect(
            AccountDao theAccountDao,
            ContactDao theContactDao
    ) {
//        theAccountDao.addAccount();
////
////        theAccountDao.addSillyMember();
////        theMemberAccountDao.addAccount();
////
////        theContactDao.addAccount();
        theAccountDao.addAccount(new Account("Le", "DienTai"), true);

        theAccountDao.doWork();
        theAccountDao.setAccount();
        theAccountDao.getAccount();
    }
}
