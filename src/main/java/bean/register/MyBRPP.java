package bean.register;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
public class MyBRPP implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        registry.registerBeanDefinition("barService", BeanDefinitionBuilder.genericBeanDefinition(BarService.class)
        .getBeanDefinition());

        //foo service
        registry.registerBeanDefinition("fooService",BeanDefinitionBuilder.genericBeanDefinition(FooService.class, () -> {
            BeanFactory beanFactory= BeanFactory.class.cast(registry);
            return new FooService(beanFactory.getBean(BarService.class));
        }).getBeanDefinition());
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}
