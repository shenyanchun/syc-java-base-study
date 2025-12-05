package syc.study.javabase.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Administrator
 * spring测试代码
 */
public class UserCondition {

    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(UserConfig.class);
        /**
         * 这种构造方式启动spring可以直观的看到spring是如何扫描类成为到一个BeanDefinition的Set集合
         * 1.扫描对应路劲下的所有类，得到类文件信息（是File对象）
         * 2.利用ASM技术得到每个class的类元数据信息
         *  2.1 因为spring不想直接用类加载器在这扫描这个时间点就把所有扫描的类都加载出来，所以使用ASM技术去得到类元数据信息，而不用加载类
         * 3.根据excludeFilter和includeFilter对类进行过滤(默认include里面会带有一个Component注解，这就是为什么@Controller,@Service会自动注入到IOC中)
         *  3.1 Component是在构造ClassPathBeanDefinitionScanner扫描器的时候放进includeFilter里面的
         * 4.在includeFilter过滤的方法里面，最后会对@Condition进行解析，即使你这个类在includeFilter里面，但是可能会被@Condition注解所过滤掉
         * 5.经过上面后会得到ScannedGenericBeanDefinition这个是BeanDefinition的一个子类，里面放了类元数据信息（前面的File对象）
         */
        AnnotationConfigApplicationContext context1 = new AnnotationConfigApplicationContext("syc.study.javabase.spring");
//        Object user = context.getBean("user");
//        System.out.println(user);
        Object user1 = context1.getBean("user");
        System.out.println(user1);


    }
}
