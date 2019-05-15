package lookup;

import bean.lookup.GetBeanTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)//运行环境
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})//指定文件配置
public class LookUpTest {

    @Test
    public void lookupTest(){
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        GetBeanTest getBeanTest = context.getBean("getBeanTest",GetBeanTest.class);
        getBeanTest.showMe();
    }
}