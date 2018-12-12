package ru.romanov.moduleone;

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

public class Application {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("/spring-context.xml");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Приветствуем в нашем тесте!");
        System.out.print("Введите Ваше имя: ");
        Person person = new Person();
        person.setName(scanner.nextLine());
        System.out.print("Введите Вашу фамилию: ");
        person.setPatronName(scanner.nextLine());

        PersonService personService = context.getBean(PersonServiceImpl.class);
        personService.savePerson(person);

        QuestionService questionService = context.getBean(QuestionServiceImpl.class);
        ResultService resultService = context.getBean(ResultServiceImpl.class);

        try {
            int questionsCount = questionService.getQuestionsCount();
            for (int i = 0; i < questionsCount; i++) {
                System.out.println("Вопрос №" + i + ": " + questionService.getQuestionTextById(i));
                Map<String, String> answersMap = questionService.getAnswersById(i);
                System.out.println("A: " + answersMap.get("A"));
                System.out.println("B: " + answersMap.get("B"));
                System.out.println("C: " + answersMap.get("C"));
                System.out.println("D: " + answersMap.get("D"));
                System.out.print("Введите букву верного ответа: ");
                scanner = new Scanner(System.in);
                String answer = scanner.nextLine();
                while (!(answer.equals("A") || answer.equals("B") || answer.equals("C") || answer.equals("D"))) {
                    System.out.println("\nТакого варианта ответа нет!");
                    System.out.print("Повторно введите букву верного ответа: ");
                    answer = scanner.nextLine();
                }
                resultService.saveAnswer(i, answer);
            }

            int rightAnswersCount = resultService.getRightAnswersCount();

            System.out.println("Результат тестирования: " + personService.getPerson().getName() +
                    ", Вы правильно ответили на " + rightAnswersCount + " из " + questionsCount + " вопросов.");

            if (rightAnswersCount != questionsCount) {
                System.out.println("Не верные ответы:" + resultService.getWrongAnswersString());
            } else {
                System.out.println("Поздравляем!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
