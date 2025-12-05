package syc.study.javabase.spring.BeanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 实现Bean实例化前的拓展点
 * 1.要注意如果实现了这个拓展接口，那么在所有bean实例化前都会进入这个回调方法
 * 2.如果postProcessBeforeInitialization返回了一个对象，那么Spring将不会帮我们进行实例化，也不会在进行后面的依赖注入等功能
 * @author Administrator
 */
@Component
public class ShenInstantiationAwareBeanPostProcessor1 implements InstantiationAwareBeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // 这样就是单独处理user这个bean
        if("user".equals(beanName)){
            System.out.println("user --- ShenBeanPostProcessor.postProcessBeforeInitialization");
        }
        // 这一句你有多少个Bean就会打印几次
        System.out.println("-------------------------"+bean);
        System.out.println(beanName+" --- ShenBeanPostProcessor.postProcessBeforeInitialization");
        return null;
    }
}
