package ru.romanov.moduleone.serviece;

import ru.romanov.moduleone.dao.PersonDAO;
import ru.romanov.moduleone.domain.Person;

public class PersonServiceImpl implements PersonService {

    private PersonDAO dao;

    public PersonServiceImpl(PersonDAO dao) {
        this.dao = dao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void savePerson(Person person) {
        dao.savePerson(person);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Person getPerson() {
        return dao.getPerson();
    }
}
