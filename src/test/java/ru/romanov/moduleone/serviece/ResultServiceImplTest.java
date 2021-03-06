package ru.romanov.moduleone.serviece;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import ru.romanov.moduleone.TestUtils;
import ru.romanov.moduleone.dao.QuestionDAO;
import ru.romanov.moduleone.dao.ResultDAO;
import ru.romanov.moduleone.domain.Question;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockingDetails;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

public class ResultServiceImplTest {

    private ResultServiceImpl resultService;
    private LocaleService localeService;
    private MessageSource ms;
    private ResultDAO resultDAO;
    private QuestionDAO questionDAO;
    private List<Question> questionList;
    private Map<Integer, String> answersMap;


    @Before
    public void init() throws Exception {
        localeService = mock(LocaleService.class);
        when(localeService.getLocale()).thenReturn(new Locale("ru"));
        ms = new ReloadableResourceBundleMessageSource();
        ((ReloadableResourceBundleMessageSource)ms).setBasename("bundle");
        ((ReloadableResourceBundleMessageSource)ms).setDefaultEncoding("windows-1251");
        resultDAO = mock(ResultDAO.class);
        questionDAO = mock(QuestionDAO.class);
        questionList = TestUtils.getPreparedQuestionList();
        when(questionDAO.getQuestionsCount()).thenReturn(questionList.size());
        when(questionDAO.getQuestionById(0)).thenReturn(questionList.get(0));
        when(questionDAO.getQuestionById(1)).thenReturn(questionList.get(1));
        when(questionDAO.getQuestionById(2)).thenReturn(questionList.get(2));
        resultService = new ResultServiceImpl(localeService, ms, resultDAO, questionDAO);
        answersMap = TestUtils.getPreparedAnswersMap();
        when(resultDAO.getAnswers()).thenReturn(answersMap);
    }

    @Test
    public void saveAnswerTest() {
        resultService.saveAnswer(0, "Answer");
        verify(resultDAO).saveAnswer(0, "Answer");
        verifyNoMoreInteractions(resultDAO);
    }

    @Test
    public void getRightAnswersCountTest() throws Exception {
        assertEquals(resultService.getRightAnswersCount(), 1);
    }

    @Test
    public void getWrongAnswersStringTest() throws Exception {
        assertEquals(resultService.getWrongAnswersString(), "1(B вместо A) 2(C вместо A) ");
    }
}