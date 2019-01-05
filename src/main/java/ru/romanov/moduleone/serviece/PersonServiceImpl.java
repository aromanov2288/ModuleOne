package ru.romanov.moduleone.serviece;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.romanov.moduleone.dao.PersonDAO;
import ru.romanov.moduleone.domain.Person;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonDAO dao;

    @Autowired
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
