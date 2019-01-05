package ru.romanov.moduleone.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import ru.romanov.moduleone.Presenter;
import ru.romanov.moduleone.serviece.LocaleService;
import ru.romanov.moduleone.serviece.PersonService;
import ru.romanov.moduleone.serviece.QuestionService;
import ru.romanov.moduleone.serviece.ResultService;

@Configuration
public class AppConfig {

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource =
                new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("bundle");
        messageSource.setDefaultEncoding("windows-1251");
        return messageSource;
    }

    @Bean
    public Presenter presenter(PersonService personService, QuestionService questionService,
                               ResultService resultService, LocaleService localeService,
                               MessageSource messageSource) {
        return new Presenter(personService, questionService, resultService, localeService, messageSource);
    }
}