import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class AppTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void mainTest() {
        HelloWorld tree =
                applicationContext.getBean(HelloWorld.class);
        HelloWorld leaf =
                applicationContext.getBean(HelloWorld.class);

        POJO.Cat one = applicationContext.getBean(POJO.Cat.class);
        POJO.Cat two = applicationContext.getBean(POJO.Cat.class);

        Assert.assertSame("Тест провален, не корректная настройка бина HelloWorld", tree, leaf);
        Assert.assertNotSame("Тест провален, не корректная настройка бина Cat", one, two);
    }
}
