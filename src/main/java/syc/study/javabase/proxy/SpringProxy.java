package syc.study.javabase.proxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.IntroductionInterceptor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;
@Transactional
public class SpringProxy {

    public static void main(String[] args) {
        User user = new User();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(user);
        proxyFactory.addAdvice(new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {
                System.out.println("before");
                Object proceed = invocation.proceed();
                System.out.println("after");
                return proceed;
            }
        });
        User user1 = (User) proxyFactory.getProxy();
        user1.test();
        ((User) proxyFactory.getProxy()).test();
        System.out.println("---------------");

    }
}
