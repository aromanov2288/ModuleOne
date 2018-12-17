package ru.romanov.moduleone.serviece;

import ru.romanov.moduleone.domain.Person;

public interface PersonService {

    /**
     * Метод сохраняет данные пользователя.
     * @param person данные пользователя
     */
    void savePerson(Person person);

    /**
     * Получить данные пользователя.
     * @return
     */
    Person getPerson();
}
