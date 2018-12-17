package ru.romanov.moduleone.dao;

import ru.romanov.moduleone.domain.Question;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionDAOImpl implements QuestionDAO {

    private String fileName;

    private List<Question> questionsList = null;

    public QuestionDAOImpl(String fileName) {
        this.fileName = System.getProperty("user.dir") + "/src/main/resources/" + fileName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getQuestionsCount() throws Exception {
        if (questionsList == null) {
            readQuestionsFile();
        }
        return questionsList.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Question getQuestionById(int id) throws Exception {
        if (questionsList == null) {
            readQuestionsFile();
        }
        return questionsList.get(id);
    }

    private void readQuestionsFile() throws Exception {
        try {
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            String[] subStr = null;
            questionsList = new ArrayList<Question>();
            while (line != null) {
                subStr = line.split(",");
                int currentId = Integer.parseInt(subStr[0]);
                Question question = new Question(currentId);
                question.setText(subStr[1]);
                Map<String, String> answersMap = new HashMap<String, String>();
                answersMap.put("A", subStr[2]);
                answersMap.put("B", subStr[3]);
                answersMap.put("C", subStr[4]);
                answersMap.put("D", subStr[5]);
                question.setAnswers(answersMap);
                question.setRightAnswer(subStr[6]);
                questionsList.add(question);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new Exception("Не удалось найти файл " + fileName);
        } catch (IOException e) {
            throw new Exception("Не удалось прочитать файл " + fileName);
        }
    }
}
