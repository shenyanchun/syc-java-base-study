package syc.study.javabase.spring.BeanPostProcessor;

import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * BeanDefinition后置处理，在Bean利用BeanDefinition实例化后调用
 * 这个时候就可以自己往对应Bean的BeanDefinition中去给Bean添加属性，应为Bean还没有完成初始化，所以这时候设置属性值是有用的
 * AutowiredAnnotationBeanPostProcessor就是实现了这个后置处理器
 * @author Administrator
 */
public class ShenMergedBeanDefinitionPostProcessor2 implements MergedBeanDefinitionPostProcessor {
    @Override
    public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {

    }

    @Override
    public void resetBeanDefinition(String beanName) {
        MergedBeanDefinitionPostProcessor.super.resetBeanDefinition(beanName);
    }
}
