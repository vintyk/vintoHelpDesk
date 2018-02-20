package by.lk.repository;

import by.lk.config.RootConfig;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RootConfig.class)
@Transactional
@Suite.SuiteClasses({SystemUserRepository.class})
public class AtssertTestStarter {
}
