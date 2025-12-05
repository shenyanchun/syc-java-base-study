package syc.study.javabase.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import syc.study.javabase.spring.BeanModel.Member;
import syc.study.javabase.spring.BeanModel.User;

@Configuration
public class UserConfig {
    @Bean
    public User user() {
        return new User();
    }

    @Bean
    public Member member() {
        return new Member();
    }
}
