/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Green
 */
public class getAndAssignCorrectAnswer {

    public static List<Question> getAndAssignCorrectAnswer(List<Question> preguntas) {

        int i = 0;
        File file = new File(new File("").getAbsolutePath() + "\\parsedAnswers.txt");
        Scanner sc = null;

        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(getAndAssignCorrectAnswer.class.getName()).log(Level.SEVERE, null, ex);
        }

        StringBuilder explanation = null;
        ArrayList<Integer> rightAnswers = null;

        String line = null;
        boolean answ = false, enounc = false;
        int num = 0, chap = 0;

        while (sc.hasNextLine()) {
            line = sc.nextLine();
            if (line.matches("\\d{1,4}\\.{1}.*")) {
                //  Si en la primera linea de cada respuesta @explanation y @rightAnswers ya han sido inicializadas (step 0),
                //  guarda la info en la @Pregunta correspondiente, vacia @explanation y @rightAnswers 
                //  e incrementa @i para saltar a la siguiente respuesta
                if (explanation != null && rightAnswers != null) {
                    preguntas.get(i).setExplanation(explanation.toString());
                    preguntas.get(i).setRightAnswers(rightAnswers);
                    explanation = new StringBuilder("");
                    rightAnswers = new ArrayList();
                    i++;

                } else {
                    explanation = new StringBuilder("");
                    rightAnswers = new ArrayList();
                }

                line = line.substring(line.indexOf(" ") + 1, line.length() - 1);
                if (line.matches("[A-F]\\.{1}.*")) {
                    switch (line.charAt(0)) {
                        case 'A':
                            rightAnswers.add(0);
                            break;
                        case 'B':
                            rightAnswers.add(1);
                            break;
                        case 'C':
                            rightAnswers.add(2);
                            break;
                        case 'D':
                            rightAnswers.add(3);
                            break;
                        case 'E':
                            rightAnswers.add(4);
                            break;
                        case 'F':
                            rightAnswers.add(5);
                            break;
                    }
                } else if (line.matches("[A-F]\\,{1}[A-F]\\.{1}.*")) {

                    for (int it = 0; it < 3; it += 2) {
                        switch (line.charAt(it)) {
                            case 'A':
                                rightAnswers.add(0);
                                break;
                            case 'B':
                                rightAnswers.add(1);
                                break;
                            case 'C':
                                rightAnswers.add(2);
                                break;
                            case 'D':
                                rightAnswers.add(3);
                                break;
                            case 'E':
                                rightAnswers.add(4);
                                break;
                            case 'F':
                                rightAnswers.add(5);
                                break;
                        }
                    }
                } else if (line.matches("[A-F]\\,{1}[A-F]\\,{1}[A-F]\\.{1}.*")) {
                    for (int it = 0; it < 5; it += 2) {
                        switch (line.charAt(it)) {
                            case 'A':
                                rightAnswers.add(0);
                                break;
                            case 'B':
                                rightAnswers.add(1);
                                break;
                            case 'C':
                                rightAnswers.add(2);
                                break;
                            case 'D':
                                rightAnswers.add(3);
                                break;
                            case 'E':
                                rightAnswers.add(4);
                                break;
                            case 'F':
                                rightAnswers.add(5);
                                break;
                        }
                    }
                }
                explanation = explanation.append(line.substring(line.indexOf(" ") + 1));
            } else {
                explanation = explanation.append("\n" + line);
            }
        }
        return preguntas;
    }

}
