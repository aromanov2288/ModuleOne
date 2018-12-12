package ru.romanov.moduleone.serviece;

import org.junit.Before;
import org.junit.Test;
import ru.romanov.moduleone.TestUtils;
import ru.romanov.moduleone.dao.PersonDAO;
import ru.romanov.moduleone.dao.QuestionDAOImpl;
import ru.romanov.moduleone.domain.Person;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

public class PersonServiceImplTest {

    private PersonServiceImpl personService;
    private PersonDAO dao;
    private Person person;

    @Before
    public void init() {
        dao = mock(PersonDAO.class);
        person = new Person("Иван", "Петров");
        when(dao.getPerson()).thenReturn(person);
        personService = new PersonServiceImpl(dao);
    }

    @Test
    public void savePersonTest() {
        personService.savePerson(person);
        verify(dao).savePerson(person);
        verifyNoMoreInteractions(dao);
    }

    @Test
    public void getPersonTest() {
        assertEquals(personService.getPerson(), person);
    }
}