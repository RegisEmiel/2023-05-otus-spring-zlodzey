package otus.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import otus.spring.service.ExaminerService;
import otus.spring.service.ExaminerServiceImpl;


public class Homework01 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("/spring-context.xml");

        ExaminerService examinerService = context.getBean(ExaminerServiceImpl.class);
        examinerService.runTest();

        context.close();
    }
}
