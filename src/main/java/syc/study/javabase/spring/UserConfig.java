package syc.study.javabase.spring;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Component
@Conditional(UserCondition.class)
public class UserConfig {
}
