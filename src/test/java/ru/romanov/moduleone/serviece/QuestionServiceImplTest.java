package ru.romanov.moduleone.serviece;

import org.junit.Before;
import org.junit.Test;
import ru.romanov.moduleone.TestUtils;
import ru.romanov.moduleone.dao.QuestionDAO;
import ru.romanov.moduleone.dao.QuestionDAOImpl;
import ru.romanov.moduleone.domain.Question;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class QuestionServiceImplTest {

    private QuestionServiceImpl questionService;
    private QuestionDAO dao;
    private List<Question> questionList;

    @Before
    public void init() throws Exception {
        dao = mock(QuestionDAOImpl.class);
        questionList = TestUtils.getPreparedQuestionList();
        when(dao.getQuestionsCount()).thenReturn(questionList.size());
        when(dao.getQuestionById(0)).thenReturn(questionList.get(0));
        when(dao.getQuestionById(1)).thenReturn(questionList.get(1));
        when(dao.getQuestionById(2)).thenReturn(questionList.get(2));
        questionService = new QuestionServiceImpl(dao);
    }

    @Test
    public void getQuestionsCountTest() throws Exception {
        assertEquals(questionService.getQuestionsCount(), 3);
    }

    @Test
    public void getQuestionTextByIdTest() throws Exception {
        for (int i = 0; i < 3; i++) {
            assertEquals(questionService.getQuestionTextById(i), "Текст " + i + " вопроса.");
        }
    }

    @Test
    public void getAnswersByIdTest() throws Exception {
        for (int i = 0; i < 3; i++) {
            assertEquals(questionService.getAnswersById(i).size(), 4);
            assertEquals(questionService.getAnswersById(i).get("A"), "Ответ А" + i);
            assertEquals(questionService.getAnswersById(i).get("B"), "Ответ B" + i);
            assertEquals(questionService.getAnswersById(i).get("C"), "Ответ C" + i);
            assertEquals(questionService.getAnswersById(i).get("D"), "Ответ D" + i);
        }
    }
}