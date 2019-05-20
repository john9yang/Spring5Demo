package register;

import bean.register.BarService;
import bean.register.FooService;
import bean.register.Spring5ConfigApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= Spring5ConfigApplication.class)
public class Spring5ConfigApplicationTests {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void contextLoads() {
        Assert.assertNotNull("the BarService should not be null.",applicationContext.getBean(BarService.class));
        Assert.assertNotNull("the FooService should not be null.",applicationContext.getBean(FooService.class));
    }
}