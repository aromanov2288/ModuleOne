package ru.romanov.moduleone.serviece;

import ru.romanov.moduleone.dao.QuestionDAO;

import java.util.Map;

public class QuestionServiceImpl implements QuestionService {

    private QuestionDAO dao;

    public QuestionServiceImpl(QuestionDAO dao) {
        this.dao = dao;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public int getQuestionsCount() throws Exception {
        return dao.getQuestionsCount();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getQuestionTextById(int id) throws Exception {
        return dao.getQuestionById(id).getText();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, String> getAnswersById(int id) throws Exception {
        return dao.getQuestionById(id).getAnswers();
    }
}
