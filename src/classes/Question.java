/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Green
 */
public class Question implements Serializable, Comparable<Object>{

    private int number;
    private int chapter;
    private String question;
    private boolean answered = false, correct, questionHasImage = false, optionsHaveImage = false;
    private List<Integer> rightAnswers, userAnswers;
    private List<String> options;
    private String explanation;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.question);
        return hash;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Question other = (Question) obj;
        return Objects.equals(this.question, other.question);
    }
    

    public Question(int number, int chapter, String question, ArrayList<String> options) {
        this.number = number;
        this.chapter = chapter;
        this.question = question;
        this.options = options;
    }

    public void setUserAnswers(List<Integer> userAnswers) {
        this.userAnswers = userAnswers;
    }

    public List<Integer> getUserAnswers() {
        return userAnswers;
    }

    public void setRightAnswers(ArrayList<Integer> rightAnswers) {
        this.rightAnswers = rightAnswers;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public boolean isQuestionHasImage() {
        return questionHasImage;
    }

    public void setQuestionHasImage(boolean questionHasImage) {
        this.questionHasImage = questionHasImage;
    }

    public boolean isOptionsHaveImage() {
        return optionsHaveImage;
    }

    public void setOptionsHaveImage(boolean optionsHaveImage) {
        this.optionsHaveImage = optionsHaveImage;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getChapter() {
        return chapter;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Integer> getRightAnswers() {
        return rightAnswers;
    }

//    public void setRightAnswers(ArrayList<Integer> rightAnswers) {
//        this.rightAnswers = rightAnswers;
//    }

    public void addRightAnswer(Integer rightAnswer) {
        rightAnswers.add(rightAnswer);
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public List<String> getOptions() {
        return options;
    }

    public void addAnswer(String answer) {
        options.add(answer);
    }

    public boolean isAnswered() {
        return answered;
    }

    public void setAnswered(boolean answered) {
        this.answered = answered;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Question: ").append(chapter);
        sb.append(". ").append(number);
        sb.append(":\n").append(question);
        sb.append("\nOpciones: ").append(options);
        return sb.toString();
    }

    @Override
    public int compareTo(Object o) {
      return this.question.compareTo(((Question)o).question);
    }


}
