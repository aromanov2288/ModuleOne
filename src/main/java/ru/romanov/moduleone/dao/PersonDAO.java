package ru.romanov.moduleone.dao;

import ru.romanov.moduleone.domain.Person;

public interface PersonDAO {

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
