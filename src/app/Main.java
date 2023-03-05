/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

//import static app.Inicio.QUEST;
import classes.HitorialExam;
import classes.JSON;
import classes.Question;
import static classes.getAndAssignCorrectAnswer.getAndAssignCorrectAnswer;
import java.util.ArrayList;
import java.util.List;
import test.interfaz.VentanaTest;


/**
 *
 * @author Dell
 */
public class Main {

//    public static Question[] QUEST;
    public static int num = -1;
    public static List<Question> preguntas=new ArrayList<Question>();
    public static List<Question> preguntasExamen=new ArrayList<Question>();

    public static void main(String[] args) {

        load();
        VentanaTest interfaz = new VentanaTest();
        interfaz.setVisible(true);

    }

    public static void load() {
        try {

            //Linea buena
            preguntas = JSON.loadFromJSON(JSON.PROGRESS);

        } catch (Exception e) {
            System.out.println("Error JSON");
        }

    }

}
