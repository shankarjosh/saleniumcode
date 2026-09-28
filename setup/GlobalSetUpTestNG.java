package setup;

import config.TestConfig;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class GlobalSetUpTestNG{

    @BeforeSuite
    public void Globalsetup() {
        GlobalAuthsetUp.loginAndSaveState(
                TestConfig.USERNAME,
                TestConfig.PASSWORD,
                TestConfig.USER_STATE);
        //GlobalAuthSetup.createExpiredState(TestConfig.EXPIRED_STATE);
    }
}
