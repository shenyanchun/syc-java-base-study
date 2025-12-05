package syc.study.javabase.spring.BeanModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


public class User {
    @Autowired
    private Member member;
}
