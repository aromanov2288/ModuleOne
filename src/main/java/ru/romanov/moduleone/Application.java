package ru.romanov.moduleone;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.romanov.moduleone.domain.Person;
import ru.romanov.moduleone.serviece.PersonService;
import ru.romanov.moduleone.serviece.PersonServiceImpl;
import ru.romanov.moduleone.serviece.QuestionService;
import ru.romanov.moduleone.serviece.QuestionServiceImpl;
import ru.romanov.moduleone.serviece.ResultService;
import ru.romanov.moduleone.serviece.ResultServiceImpl;

import java.util.Map;
import java.util.Scanner;

@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Application.class);

        Presenter presenter = context.getBean(Presenter.class);
        presenter.startTest();
    }
}
