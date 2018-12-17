package ru.romanov.moduleone.dao;

import ru.romanov.moduleone.domain.Person;

public class PersonDAOImpl implements PersonDAO {

    private Person person;

    /**
     * {@inheritDoc}
     */
    @Override
    public void savePerson(Person person) {
        this.person = person;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Person getPerson() {
        return person;
    }
}
