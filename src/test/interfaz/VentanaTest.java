/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package test.interfaz;

import java.awt.Color;
import app.Main;
import static app.Main.num;
import static app.Main.preguntas;
import static app.Main.preguntasExamen;
import classes.HitorialExam;
import static classes.HitorialExam.historialExam;
import classes.JSON;
import classes.Question;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Dell
 */
public class VentanaTest extends javax.swing.JFrame {

    Color color;
     ScheduledExecutorService ses;

    /**
     * Creates new form VentanaTest
     */
    private void formatoFallo(JRadioButton radioButton) {

        radioButton.setFont(radioButton.getFont().deriveFont(Font.BOLD));
        radioButton.setForeground(Color.red);

    }

    private void formatoAcierto(JRadioButton radioButton) {

        radioButton.setFont(radioButton.getFont().deriveFont(Font.BOLD));
        radioButton.setForeground(new Color(0, 153, 0));

    }

    public void loadImagen(String img, JLabel jl) {

        try {

//ImageIcon logo = new ImageIcon("C:\\Users\\Dell\\Desktop\\CURSO JAVA\\"
// + "Proyecto Test Examen OCP\\Repositorio\\ExamSoftwareV004\\ExamSoftwareV004\\"
// + "ExamSoftwareV004\\src\\resources\\"+img);
            ImageIcon logo = new ImageIcon(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("resources\\" + img)));

//Image image = logo.getImage();
//Image newimg = image.getScaledInstance(jLabelImagen.getWidth(), jLabelImagen.getHeight(),  java.awt.Image.SCALE_SMOOTH);
//ImageIcon newImageIcon = new ImageIcon(newimg);
//                    Icon icon = new ImageIcon(logo.getImage().getScaledInstance(
//                            jLabelImagen.getWidth(),
//                            jLabelImagen.getHeight(),
//                            Image.SCALE_SMOOTH));
            Icon icon = new ImageIcon(logo.getImage().getScaledInstance(
                    jLabelImagen.getWidth(),
                    jLabelImagen.getHeight(),
                    Image.SCALE_AREA_AVERAGING));

//                    Icon icon = new ImageIcon(logo.getImage().getScaledInstance(
//                            jLabelImagen.getWidth(),
//                            jLabelImagen.getHeight(),
//                            Image.SCALE_FAST));
//                    Icon icon = new ImageIcon(logo.getImage().getScaledInstance(
//                            jLabelImagen.getWidth(),
//                            jLabelImagen.getHeight(),
//                            Image.SCALE_REPLICATE));
//                    Icon icon = new ImageIcon(logo.getImage().getScaledInstance(
//                            jLabelImagen.getWidth(),
//                            jLabelImagen.getHeight(),
//                            Image.SCALE_DEFAULT));
            jl.setIcon(icon);

        } catch (NullPointerException e) {

            System.out.println("No pudo cargar la imagen:" + img);
        }

    }

    public void test() {

        String question = preguntasExamen.get(num).getQuestion();
        List<String> options = preguntasExamen.get(num).getOptions();

        jPanelExplicacion.setVisible(false);
        jTextAreaExplicacion.setText("");

        String numRightAnswers = "null";

        if (preguntasExamen.get(num).getRightAnswers() != null) {
            numRightAnswers = String.valueOf(preguntasExamen.get(num).getRightAnswers().size());
        }

        jLabelNumberOfQuestion.setText("Question " + (num + 1) + " of " + preguntasExamen.size() + "           Chapter: "
                + preguntasExamen.get(num).getChapter()
                + " || Question: "
                + preguntasExamen.get(num).getNumber()
                + "         Choose " + numRightAnswers);

        jPanel1.setVisible(true);
        jPanel2.setVisible(false);

      //  System.out.println(num+ " "+preguntasExamen.get(num).isQuestionHasImage());
        
        if (preguntasExamen.get(num).isQuestionHasImage()) {
            String nombreImagen = "Cap" + preguntasExamen.get(num).getChapter() + "-Pregunta" + preguntasExamen.get(num).getNumber() + ".PNG";
            jTextAreaQuestionImagen.setText(question);
            loadImagen(nombreImagen, jLabelImagen);
            jPanel1.setVisible(false);
            jPanel2.setVisible(true);
            jPanelExamen.repaint();
            this.pack();

        }

//        System.out.println(preguntasExamen.get(num).isQuestionHasImage());
        jTextAreaQuestion.setText(question);

        jButtonSolution.setEnabled(false);

        jRadioButtonOpcionA.setVisible(false);
        jRadioButtonOpcionB.setVisible(false);
        jRadioButtonOpcionC.setVisible(false);
        jRadioButtonOpcionD.setVisible(false);
        jRadioButtonOpcionE.setVisible(false);
        jRadioButtonOpcionF.setVisible(false);

        jRadioButtonOpcionA.setSelected(false);
        jRadioButtonOpcionB.setSelected(false);
        jRadioButtonOpcionC.setSelected(false);
        jRadioButtonOpcionD.setSelected(false);
        jRadioButtonOpcionE.setSelected(false);
        jRadioButtonOpcionF.setSelected(false);

        jRadioButtonOpcionA.setFont(new Font("SansSerif", Font.PLAIN, 14));
        jRadioButtonOpcionB.setFont(new Font("SansSerif", Font.PLAIN, 14));
        jRadioButtonOpcionC.setFont(new Font("SansSerif", Font.PLAIN, 14));
        jRadioButtonOpcionD.setFont(new Font("SansSerif", Font.PLAIN, 14));
        jRadioButtonOpcionE.setFont(new Font("SansSerif", Font.PLAIN, 14));
        jRadioButtonOpcionF.setFont(new Font("SansSerif", Font.PLAIN, 14));

        jRadioButtonOpcionA.setForeground(Color.BLACK);
        jRadioButtonOpcionB.setForeground(Color.BLACK);
        jRadioButtonOpcionC.setForeground(Color.BLACK);
        jRadioButtonOpcionD.setForeground(Color.BLACK);
        jRadioButtonOpcionE.setForeground(Color.BLACK);
        jRadioButtonOpcionF.setForeground(Color.BLACK);

        for (int i = 0; i < options.size(); i++) {

            if (i == 0) {
                jRadioButtonOpcionA.setText("A. " + options.get(0).toString());
                jRadioButtonOpcionA.setVisible(true);
            }
            if (i == 1) {
                jRadioButtonOpcionB.setText("B. " + options.get(1).toString());
                jRadioButtonOpcionB.setVisible(true);
            }
            if (i == 2) {
                jRadioButtonOpcionC.setText("C. " + options.get(2).toString());
                jRadioButtonOpcionC.setVisible(true);
            }
            if (i == 3) {
                jRadioButtonOpcionD.setText("D. " + options.get(3).toString());
                jRadioButtonOpcionD.setVisible(true);
            }
            if (i == 4) {
                jRadioButtonOpcionE.setText("E. " + options.get(4).toString());
                jRadioButtonOpcionE.setVisible(true);
            }
            if (i == 5) {
                jRadioButtonOpcionF.setText("F. " + options.get(5).toString());
                jRadioButtonOpcionF.setVisible(true);
            }

        }

//        System.out.println(preguntasExamen.size());
        System.out.println(preguntasExamen.get(num).getUserAnswers());
//        System.out.println(preguntasExamen.get(num).getUserAnswers().size());
        
List<Integer> userAswers= preguntasExamen.get(num).getUserAnswers();

        if (preguntasExamen.get(num).getUserAnswers() != null 
                && preguntasExamen.get(num).getUserAnswers().size() != 0) {
            for (Integer a : userAswers) {
                if (a == 0) {
                    jRadioButtonOpcionA.setSelected(true);                        
                    jRadioButtonOpcionA.setFont(new Font("SansSerif", Font.BOLD, 14));
     
                }
                if (a == 1) {
                    jRadioButtonOpcionB.setSelected(true);
                    jRadioButtonOpcionB.setFont(new Font("SansSerif", Font.BOLD, 14));
                }
                if (a == 2) {
                    jRadioButtonOpcionC.setSelected(true);
                    jRadioButtonOpcionC.setFont(new Font("SansSerif", Font.BOLD, 14));
                }
                if (a == 3) {
                    jRadioButtonOpcionD.setSelected(true);
                    jRadioButtonOpcionD.setFont(new Font("SansSerif", Font.BOLD, 14));
                }
                if (a == 4) {
                    jRadioButtonOpcionE.setSelected(true);
                    jRadioButtonOpcionE.setFont(new Font("SansSerif", Font.BOLD, 14));
                }
                if (a == 5) {
                    jRadioButtonOpcionF.setSelected(true);
                    jRadioButtonOpcionF.setFont(new Font("SansSerif", Font.BOLD, 14));
                }
            }
//            preguntasExamen.get(num).setUserAnswers(new ArrayList());
        }

//        if (preguntasExamen.get(num).isAnswered()) {
//
//            //  System.out.println(preguntasExamen.get(num).getUserAnswers());
///// revisamos las opciones señaladas por el usuario
//            for (Integer a : userAswers) {
//                if (a == 0) {
//                    jRadioButtonOpcionA.setSelected(true);
//                    if (preguntasExamen.get(num).getRightAnswers().contains(a)) {
//                        formatoAcierto(jRadioButtonOpcionA);
//                    } else {
//                        formatoFallo(jRadioButtonOpcionA);
//                    }
//                }
//                if (a == 1) {
//                    jRadioButtonOpcionB.setSelected(true);
//                    if (preguntasExamen.get(num).getRightAnswers().contains(a)) {
//                        formatoAcierto(jRadioButtonOpcionB);
//                    } else {
//                        formatoFallo(jRadioButtonOpcionB);
//                    }
//                }
//                if (a == 2) {
//                    jRadioButtonOpcionC.setSelected(true);
//                    if (preguntasExamen.get(num).getRightAnswers().contains(a)) {
//                        formatoAcierto(jRadioButtonOpcionC);
//                    } else {
//                        formatoFallo(jRadioButtonOpcionC);
//                    }
//                }
//                if (a == 3) {
//                    jRadioButtonOpcionD.setSelected(true);
//                    if (preguntasExamen.get(num).getRightAnswers().contains(a)) {
//                        formatoAcierto(jRadioButtonOpcionD);
//                    } else {
//                        formatoFallo(jRadioButtonOpcionD);
//                    }
//                }
//                if (a == 4) {
//                    jRadioButtonOpcionE.setSelected(true);
//                    if (preguntasExamen.get(num).getRightAnswers().contains(a)) {
//                        formatoAcierto(jRadioButtonOpcionE);
//                    } else {
//                        formatoFallo(jRadioButtonOpcionE);
//                    }
//                }
//                if (a == 5) {
//                    jRadioButtonOpcionF.setSelected(true);
//                    if (preguntasExamen.get(num).getRightAnswers().contains(a)) {
//                        formatoAcierto(jRadioButtonOpcionF);
//                    } else {
//                        formatoFallo(jRadioButtonOpcionF);
//                    }
//                }
//            }
//
//        }
        this.pack();

    }

    private void modoEstudio() {

        List<Integer> rightAnswers = preguntasExamen.get(num).getRightAnswers();
        List<Integer> userAnswers = preguntasExamen.get(num).getUserAnswers();

        jRadioButtonOpcionA.setForeground(Color.BLACK);
        jRadioButtonOpcionB.setForeground(Color.BLACK);
        jRadioButtonOpcionC.setForeground(Color.BLACK);
        jRadioButtonOpcionD.setForeground(Color.BLACK);
        jRadioButtonOpcionE.setForeground(Color.BLACK);
        jRadioButtonOpcionF.setForeground(Color.BLACK);

        for (int i : userAnswers) {

            if (i == 0) {
                formatoFallo(jRadioButtonOpcionA);
            }
            if (i == 1) {
                formatoFallo(jRadioButtonOpcionB);
            }
            if (i == 2) {
                formatoFallo(jRadioButtonOpcionC);
            }
            if (i == 3) {
                formatoFallo(jRadioButtonOpcionD);
            }
            if (i == 4) {
                formatoFallo(jRadioButtonOpcionE);
            }
            if (i == 5) {
                formatoFallo(jRadioButtonOpcionF);
            }

        };

        for (int i : rightAnswers) {

            if (i == 0) {
                formatoAcierto(jRadioButtonOpcionA);
            }
            if (i == 1) {
                formatoAcierto(jRadioButtonOpcionB);
            }
            if (i == 2) {
                formatoAcierto(jRadioButtonOpcionC);
            }
            if (i == 3) {
                formatoAcierto(jRadioButtonOpcionD);
            }
            if (i == 4) {
                formatoAcierto(jRadioButtonOpcionE);
            }
            if (i == 5) {
                formatoAcierto(jRadioButtonOpcionF);
            }

        };

    }

    private void evaluarPreguntaRev() {

        List<Integer> rightAnswers = preguntasExamen.get(num).getRightAnswers();
        List<Integer> userAnswers = new ArrayList<Integer>();

        if (jRadioButtonOpcionA.isVisible() && jRadioButtonOpcionA.isSelected()) {
            userAnswers.add(0);
        }
        if (jRadioButtonOpcionB.isVisible() && jRadioButtonOpcionB.isSelected()) {
            userAnswers.add(1);
        }
        if (jRadioButtonOpcionC.isVisible() && jRadioButtonOpcionC.isSelected()) {
            userAnswers.add(2);
        }
        if (jRadioButtonOpcionD.isVisible() && jRadioButtonOpcionD.isSelected()) {
            userAnswers.add(3);
        }
        if (jRadioButtonOpcionE.isVisible() && jRadioButtonOpcionE.isSelected()) {
            userAnswers.add(4);
        }
        if (jRadioButtonOpcionF.isVisible() && jRadioButtonOpcionF.isSelected()) {
            userAnswers.add(5);
        }

        boolean evalua = true;

        if (userAnswers.isEmpty() || (userAnswers.size() != rightAnswers.size())) {
            evalua = false;

            String texAux = rightAnswers.size() + " opciones";

            if (rightAnswers.size() == 1) {
                texAux = "una opcion";
            }

            JOptionPane.showMessageDialog(null, "Debe elegir " + texAux);

        }

        if (evalua) {
            preguntasExamen.get(num).setAnswered(true);
            preguntasExamen.get(num).setCorrect(false);
            preguntasExamen.get(num).setUserAnswers(userAnswers);

            if (userAnswers.equals(rightAnswers)) {
                preguntasExamen.get(num).setCorrect(true);
            }
            jButtonSolution.setEnabled(true);

        }

    }

    public void swapElementsA(int pos1, int pos2) {

        try {

            String tmp = ((DefaultListModel<String>) jListCharterEvaluate.getModel()).getElementAt(pos1);

            ((DefaultListModel<String>) jListCharterEvaluate.getModel()).set(pos1, ((DefaultListModel<String>) jListCharterEvaluate.getModel()).get(pos2));
            ((DefaultListModel<String>) jListCharterEvaluate.getModel()).set(pos2, tmp);

        } catch (ArrayIndexOutOfBoundsException e) {
        }

    }

    private void evaluarPregunta(boolean save) {

        List<Integer> rightAnswers = preguntasExamen.get(num).getRightAnswers();
        int opcion = 0;

        if (jRadioButtonOpcionA.isSelected()) {
            opcion++;
        }
        if (jRadioButtonOpcionB.isSelected()) {
            opcion++;
        }
        if (jRadioButtonOpcionC.isSelected()) {
            opcion++;
        }
        if (jRadioButtonOpcionD.isSelected()) {
            opcion++;
        }
        if (jRadioButtonOpcionE.isSelected()) {
            opcion++;
        }
        if (jRadioButtonOpcionF.isSelected()) {
            opcion++;
        }

        List<Integer> userAnswers = new ArrayList<Integer>();
        userAnswers = preguntasExamen.get(num).getUserAnswers();

        if ((preguntasExamen.get(num).getRightAnswers() != null)
                && (opcion == rightAnswers.size() || userAnswers.size() == rightAnswers.size())) {

            for (Integer a : rightAnswers) {
                if (jRadioButtonOpcionA.isSelected() || userAnswers.contains(0)) {
                    userAnswers.add(0);
                }
                if (jRadioButtonOpcionB.isSelected() || userAnswers.contains(1)) {
                    userAnswers.add(1);
                }
                if (jRadioButtonOpcionC.isSelected() || userAnswers.contains(2)) {
                    userAnswers.add(2);
                }
                if (jRadioButtonOpcionD.isSelected() || userAnswers.contains(3)) {
                    userAnswers.add(3);
                }
                if (jRadioButtonOpcionE.isSelected() || userAnswers.contains(4)) {
                    userAnswers.add(4);
                }
                if (jRadioButtonOpcionF.isSelected() || userAnswers.contains(5)) {
                    userAnswers.add(5);
                }
            }
            preguntasExamen.get(num).setUserAnswers(userAnswers);
            if (save) {
                preguntasExamen.get(num).setAnswered(save);
            }

        } else {
            if (save) {
                if (rightAnswers.size() == 0) {
                    JOptionPane.showMessageDialog(null, "Debe elegir una opción.");
                } else {
                    JOptionPane.showMessageDialog(null, "Debe elegir " + rightAnswers.size() + " opciones.");
                }
            }
        }
    }

    
    
    private void loadTest(String charter, String aleatorioCharter, Long limit){
    
        String[] text = charter.split(":");
        int c = Integer.valueOf(text[0].substring(7, text[0].length()).trim());

        if (aleatorioCharter.equals("Aleatorio")) {

            Supplier<Question> questGenerator = () -> {
                return preguntas.get(new Random().nextInt(preguntas.size()));

            };

//            Stream.generate(questGenerator).distinct().filter(p -> (p.getChapter() == c) && (!p.isAnswered()
//                    || (p.isAnswered() && !p.isCorrect()))).limit(limit).forEach(p -> preguntasExamen.add(p));
            
Stream.generate(questGenerator).distinct().filter(p -> (p.getChapter() == c) 
        && (!p.isAnswered())).limit(limit).forEach(p -> preguntasExamen.add(p));
            

        } else {

//            preguntas.stream().filter(p -> (p.getChapter() == c) && (!p.isAnswered()
//                    || (p.isAnswered() && !p.isCorrect()))).limit(limit).forEach(p -> preguntasExamen.add(p));
            
                        preguntas.stream().filter(p -> (p.getChapter() == c) && (!p.isAnswered())).limit(limit).forEach(p -> preguntasExamen.add(p));

        }
                    
    }
    
    
    public void comboEstadist(){
           
     jPanel11.removeAll();
     
     for(int i=1;i<jComboBoxHistorial.getItemCount();i++){
         
          String exam=jComboBoxHistorial.getItemAt(i).toString();
          
          ArrayList<String> examHist = historialExam.get(exam);
          
          System.out.println(exam);
          
           
         long totQuestion=0;
         long aciertos=0;
         long fallos=0;
         long hechas=0;
         JLabel label = new JLabel();
         label.setAlignmentX(Component.LEFT_ALIGNMENT);
          
         for (String ques : examHist) {

             totQuestion++;

             String words1[] = ques.split(" ");
             int chapter = Integer.parseInt(words1[0]);
             int number = Integer.parseInt(words1[1]);                

          Optional<Question> q=preguntas.stream().filter(p ->
                  p.getChapter() == chapter && p.getNumber() == number).findFirst();
          
          if(q.isPresent()){          
              Question question = q.get();

              hechas = (question.isAnswered()) ? ++hechas : hechas;
              aciertos = (question.isAnswered()) && (question.isCorrect()) ? ++aciertos : aciertos;
              fallos = (question.isAnswered()) && (!question.isCorrect()) ? ++fallos : fallos;       
          }           
                    
            }     
     
           float calificacion = aciertos/((float)totQuestion)*100;
           calificacion = (float)Math.round(calificacion*100)/100;
           
         // System.out.println("Exam:"+exam+"  aciertos:"+aciertos+"  fallos: "+fallos+"  score:"+calificacion);
          label.setText(exam+"  aciertos: "+aciertos+"  fallos: "+fallos+"  score: "+calificacion);
          
         label.setForeground(new Color(204, 0, 0));

         if (calificacion >= 68) {
             label.setForeground(new Color(0, 141, 50));
         }
          
          jPanel11.add(label);
          
     
     }

      jPanel11.updateUI();
            
    
    
    }
    
    public VentanaTest() {

        try {

            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            this.setDefaultLookAndFeelDecorated(true);

            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        } catch (Exception e) {

        }

        initComponents();

        jDialogEstadistica.pack();
        jDialogEstadistica.setLocationRelativeTo(null);

        jButton4.addActionListener(new JScrollPaneToTopAction(jScrollPaneDatos));

        jPanelExplicacion.setVisible(false);
//        this.setResizable(false);
        cargarDialogo();

        color = jListCharterEvaluate.getSelectionBackground();

        jButtonUP1.setText("\u02C4");
        jButtonDO1.setText("\u02C5");

        DefaultMutableTreeNode Raiz = new DefaultMutableTreeNode("Examen");
        DefaultTreeModel model = new DefaultTreeModel(Raiz);

        DefaultMutableTreeNode Capitulo1 = new DefaultMutableTreeNode("Charter 1: Working with Java Data Types");
        DefaultMutableTreeNode Capitulo2 = new DefaultMutableTreeNode("Chapter 2: Controlling Program Flow");
        DefaultMutableTreeNode Capitulo3 = new DefaultMutableTreeNode("Chapter 3: Java Object‐Oriented Approach");
        DefaultMutableTreeNode Capitulo4 = new DefaultMutableTreeNode("Chapter 4: Exception Handling");
        DefaultMutableTreeNode Capitulo5 = new DefaultMutableTreeNode("Chapter 5: Working with Arrays and Collections");
        DefaultMutableTreeNode Capitulo6 = new DefaultMutableTreeNode("Chapter 6: Working with Streams and Lambda Expressions");
        DefaultMutableTreeNode Capitulo7 = new DefaultMutableTreeNode("Chapter 7: Java Platform Module System");
        DefaultMutableTreeNode Capitulo8 = new DefaultMutableTreeNode("Chapter 8: Concurrency");
        DefaultMutableTreeNode Capitulo9 = new DefaultMutableTreeNode("Chapter 9: Java I/O API");
        DefaultMutableTreeNode Capitulo10 = new DefaultMutableTreeNode("Chapter 10: Secure Coding in Java SE Application");
        DefaultMutableTreeNode Capitulo11 = new DefaultMutableTreeNode("Chapter 11: Database Applications with JDBC");
        DefaultMutableTreeNode Capitulo12 = new DefaultMutableTreeNode("Chapter 12: Localization");
        DefaultMutableTreeNode Capitulo13 = new DefaultMutableTreeNode("Chapter 13: Annotations");

        Raiz.add(Capitulo1);
        Raiz.add(Capitulo2);
        Raiz.add(Capitulo3);
        Raiz.add(Capitulo4);
        Raiz.add(Capitulo5);
        Raiz.add(Capitulo6);
        Raiz.add(Capitulo7);
        Raiz.add(Capitulo8);
        Raiz.add(Capitulo9);
        Raiz.add(Capitulo10);
        Raiz.add(Capitulo11);
        Raiz.add(Capitulo12);
        Raiz.add(Capitulo13);

        jTree1.setModel(model);

//        List<Question> tema1 = new ArrayList();
//        preguntasExamen.stream().filter(p -> p.getChapter() == 1).forEach(p -> tema1.add(p));
        jLabelCharter.setText("All the chapters");

        jScrollPaneDatos.getVerticalScrollBar().setUnitIncrement(75);
        HitorialExam.load();

        jComboBoxHistorial.removeAllItems();
        jComboBoxHistorial.addItem("new test");

        if (!historialExam.isEmpty()) {

            Set<String> keySet = historialExam.keySet();
            ArrayList<String> listOfKeys = new ArrayList<String>(keySet);
            jComboBoxHistorial.removeAll();
            Collections.sort(listOfKeys);
            for (String k : listOfKeys) {
                jComboBoxHistorial.addItem(k);
            }

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogConfi = new javax.swing.JDialog();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jListCharterEvaluate = new javax.swing.JList<>();
        jButtonADD1 = new javax.swing.JButton();
        jButtonREMOV1 = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        jListCharter = new javax.swing.JList<>();
        jButtonUP1 = new javax.swing.JButton("\u02C4");
        jButtonDO1 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSpinnerCantQuestion = new javax.swing.JSpinner();
        jButton2 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jSpinnerTiempo = new javax.swing.JSpinner();
        jLabel31 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jDialogEstadistica = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabelTotP1 = new javax.swing.JLabel();
        jLabelTotP3 = new javax.swing.JLabel();
        jLabelTotP4 = new javax.swing.JLabel();
        jLabelTotP2 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabelTotP5 = new javax.swing.JLabel();
        jLabel1_1 = new javax.swing.JLabel();
        jLabel1_2 = new javax.swing.JLabel();
        jLabel1_3 = new javax.swing.JLabel();
        jLabel1_4 = new javax.swing.JLabel();
        jLabel1_5 = new javax.swing.JLabel();
        jLabel1_6 = new javax.swing.JLabel();
        jLabel2_1 = new javax.swing.JLabel();
        jLabel2_2 = new javax.swing.JLabel();
        jLabel2_3 = new javax.swing.JLabel();
        jLabel2_4 = new javax.swing.JLabel();
        jLabel2_5 = new javax.swing.JLabel();
        jLabel2_6 = new javax.swing.JLabel();
        jLabel3_1 = new javax.swing.JLabel();
        jLabel3_2 = new javax.swing.JLabel();
        jLabel3_3 = new javax.swing.JLabel();
        jLabel3_4 = new javax.swing.JLabel();
        jLabel3_5 = new javax.swing.JLabel();
        jLabel3_6 = new javax.swing.JLabel();
        jLabel4_1 = new javax.swing.JLabel();
        jLabel4_2 = new javax.swing.JLabel();
        jLabel4_3 = new javax.swing.JLabel();
        jLabel4_4 = new javax.swing.JLabel();
        jLabel4_5 = new javax.swing.JLabel();
        jLabel4_6 = new javax.swing.JLabel();
        jLabel5_1 = new javax.swing.JLabel();
        jLabel5_2 = new javax.swing.JLabel();
        jLabel5_3 = new javax.swing.JLabel();
        jLabel5_4 = new javax.swing.JLabel();
        jLabel5_5 = new javax.swing.JLabel();
        jLabel5_6 = new javax.swing.JLabel();
        jLabel6_1 = new javax.swing.JLabel();
        jLabel6_2 = new javax.swing.JLabel();
        jLabel6_3 = new javax.swing.JLabel();
        jLabel6_4 = new javax.swing.JLabel();
        jLabel6_5 = new javax.swing.JLabel();
        jLabel6_6 = new javax.swing.JLabel();
        jLabel7_1 = new javax.swing.JLabel();
        jLabel7_2 = new javax.swing.JLabel();
        jLabel7_3 = new javax.swing.JLabel();
        jLabel7_4 = new javax.swing.JLabel();
        jLabel7_5 = new javax.swing.JLabel();
        jLabel7_6 = new javax.swing.JLabel();
        jLabel8_1 = new javax.swing.JLabel();
        jLabel8_2 = new javax.swing.JLabel();
        jLabel8_3 = new javax.swing.JLabel();
        jLabel8_4 = new javax.swing.JLabel();
        jLabel8_5 = new javax.swing.JLabel();
        jLabel8_6 = new javax.swing.JLabel();
        jLabel9_1 = new javax.swing.JLabel();
        jLabel9_2 = new javax.swing.JLabel();
        jLabel9_3 = new javax.swing.JLabel();
        jLabel9_4 = new javax.swing.JLabel();
        jLabel9_5 = new javax.swing.JLabel();
        jLabel9_6 = new javax.swing.JLabel();
        jLabel10_1 = new javax.swing.JLabel();
        jLabel10_2 = new javax.swing.JLabel();
        jLabel10_3 = new javax.swing.JLabel();
        jLabel10_4 = new javax.swing.JLabel();
        jLabel10_5 = new javax.swing.JLabel();
        jLabel10_6 = new javax.swing.JLabel();
        jLabel11_1 = new javax.swing.JLabel();
        jLabel11_2 = new javax.swing.JLabel();
        jLabel11_3 = new javax.swing.JLabel();
        jLabel11_4 = new javax.swing.JLabel();
        jLabel11_5 = new javax.swing.JLabel();
        jLabel11_6 = new javax.swing.JLabel();
        jLabel12_1 = new javax.swing.JLabel();
        jLabel12_2 = new javax.swing.JLabel();
        jLabel12_3 = new javax.swing.JLabel();
        jLabel12_4 = new javax.swing.JLabel();
        jLabel12_5 = new javax.swing.JLabel();
        jLabel12_6 = new javax.swing.JLabel();
        jLabel13_1 = new javax.swing.JLabel();
        jLabel13_2 = new javax.swing.JLabel();
        jLabel13_3 = new javax.swing.JLabel();
        jLabel13_4 = new javax.swing.JLabel();
        jLabel13_5 = new javax.swing.JLabel();
        jLabel13_6 = new javax.swing.JLabel();
        jLabel15_1 = new javax.swing.JLabel();
        jLabel15_2 = new javax.swing.JLabel();
        jLabel15_3 = new javax.swing.JLabel();
        jLabel15_4 = new javax.swing.JLabel();
        jLabel15_5 = new javax.swing.JLabel();
        jLabel15_6 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel83 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jProgressBar2 = new javax.swing.JProgressBar();
        jProgressBar3 = new javax.swing.JProgressBar();
        jProgressBar4 = new javax.swing.JProgressBar();
        jProgressBar5 = new javax.swing.JProgressBar();
        jProgressBar6 = new javax.swing.JProgressBar();
        jProgressBar7 = new javax.swing.JProgressBar();
        jProgressBar8 = new javax.swing.JProgressBar();
        jProgressBar9 = new javax.swing.JProgressBar();
        jProgressBar10 = new javax.swing.JProgressBar();
        jProgressBar11 = new javax.swing.JProgressBar();
        jProgressBar12 = new javax.swing.JProgressBar();
        jProgressBar13 = new javax.swing.JProgressBar();
        jProgressBar15 = new javax.swing.JProgressBar();
        jPanelInterfaz = new javax.swing.JPanel();
        jPanelPrincipal = new javax.swing.JPanel();
        jButtonHacerExamen = new javax.swing.JButton();
        jButtonExamenErrores = new javax.swing.JButton();
        jButtonRevision = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonReinicio = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jComboBoxHistorial = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel11 = new javax.swing.JPanel();
        jPanelExamen = new javax.swing.JPanel();
        jPanelPregunta = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanelExplicacion = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaExplicacion = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jPanelAlterno = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaQuestion = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaQuestionImagen = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        jLabelImagen = new javax.swing.JLabel();
        jPanelOpciones = new javax.swing.JPanel();
        jRadioButtonOpcionA = new javax.swing.JRadioButton();
        jRadioButtonOpcionB = new javax.swing.JRadioButton();
        jRadioButtonOpcionC = new javax.swing.JRadioButton();
        jRadioButtonOpcionD = new javax.swing.JRadioButton();
        jRadioButtonOpcionE = new javax.swing.JRadioButton();
        jRadioButtonOpcionF = new javax.swing.JRadioButton();
        jPanelControles = new javax.swing.JPanel();
        jButtonBack = new javax.swing.JButton();
        jButtonEvalExamen = new javax.swing.JButton();
        jButtonNext = new javax.swing.JButton();
        jButtonEvalPregunta = new javax.swing.JButton();
        jButtonSolution = new javax.swing.JButton();
        jButtonEvalExamen1 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabelNumberOfQuestion = new javax.swing.JLabel();
        jLabelClock = new javax.swing.JLabel();
        jPanelRevisiones = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelRevision1 = new javax.swing.JPanel();
        jLabelCharter = new javax.swing.JLabel();
        jPanelResultados = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabelAciertos = new javax.swing.JLabel();
        jLabelFallos = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelPreguntas = new javax.swing.JLabel();
        jLabelPreguntasAcertadas = new javax.swing.JLabel();
        jLabelPreguntasFalladas = new javax.swing.JLabel();
        jLabelCalificacion = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPaneDatos = new javax.swing.JScrollPane();
        jPanelDatos = new javax.swing.JPanel();
        jPanelResultados1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabelPreguntas1 = new javax.swing.JLabel();
        jLabelPreguntasAcertadas1 = new javax.swing.JLabel();
        jLabelPreguntasFalladas1 = new javax.swing.JLabel();
        jLabelCalificacion1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();

        jDialogConfi.setTitle("Configurar Examen");

        jListCharterEvaluate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jListCharterEvaluate.setModel(new DefaultListModel ());
        jListCharterEvaluate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jListCharterEvaluateFocusGained(evt);
            }
        });
        jScrollPane11.setViewportView(jListCharterEvaluate);

        jButtonADD1.setText("Agregar >>");
        jButtonADD1.setEnabled(false);
        jButtonADD1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonADD1ActionPerformed(evt);
            }
        });

        jButtonREMOV1.setText("<< Quitar");
        jButtonREMOV1.setEnabled(false);
        jButtonREMOV1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonREMOV1ActionPerformed(evt);
            }
        });

        jListCharter.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jListCharter.setModel(new DefaultListModel ());
        jListCharter.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jListCharterFocusGained(evt);
            }
        });
        jScrollPane12.setViewportView(jListCharter);

        jButtonUP1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonUP1.setText("˄");
        jButtonUP1.setEnabled(false);
        jButtonUP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUP1ActionPerformed(evt);
            }
        });

        jButtonDO1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonDO1.setText("˅");
        jButtonDO1.setEnabled(false);
        jButtonDO1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDO1ActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel21.setText("Charter");

        jLabel22.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel22.setText("Charter to evaluate");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonREMOV1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonADD1))
                        .addGap(11, 11, 11))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonUP1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonDO1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(jButtonUP1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDO1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                            .addComponent(jScrollPane11)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jButtonADD1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonREMOV1)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jComboBox1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aleatorio", "Consecutivo" }));

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel9.setText("Order in the Test:");

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel10.setText("Quantity of Questions:");

        jSpinnerCantQuestion.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jSpinnerCantQuestion.setValue(50);

        jButton2.setText("Aceptar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel12.setText("Time of Test (minutes):");

        jSpinnerTiempo.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jSpinnerTiempo.setValue(90);

        jLabel31.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel31.setText("Selection of Questions:");

        jComboBox2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aleatorio", "Consecutivo" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel31)
                    .addComponent(jLabel9))
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jComboBox1, 0, 176, Short.MAX_VALUE)
                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinnerTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinnerCantQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(63, 63, 63))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSpinnerTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSpinnerCantQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );

        javax.swing.GroupLayout jDialogConfiLayout = new javax.swing.GroupLayout(jDialogConfi.getContentPane());
        jDialogConfi.getContentPane().setLayout(jDialogConfiLayout);
        jDialogConfiLayout.setHorizontalGroup(
            jDialogConfiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogConfiLayout.createSequentialGroup()
                .addGroup(jDialogConfiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jDialogConfiLayout.setVerticalGroup(
            jDialogConfiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogConfiLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jDialogEstadistica.setTitle("ESTADISTICA GENERAL");

        jPanel7.setLayout(new java.awt.GridLayout(15, 1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Charts:");
        jPanel7.add(jLabel3);

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Working with Java Data Types:");
        jPanel7.add(jLabel8);

        jLabel16.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Controlling Program Flow:");
        jPanel7.add(jLabel16);

        jLabel17.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Java Object‐Oriented Approach:");
        jPanel7.add(jLabel17);

        jLabel18.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Exception Handling:");
        jPanel7.add(jLabel18);

        jLabel19.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Working with Arrays and Collections:");
        jPanel7.add(jLabel19);

        jLabel20.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Working with Streams and Lambda Expressions:");
        jPanel7.add(jLabel20);

        jLabel23.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Java Platform Module System:");
        jPanel7.add(jLabel23);

        jLabel24.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("Concurrency:");
        jPanel7.add(jLabel24);

        jLabel25.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("Java I/O API:");
        jPanel7.add(jLabel25);

        jLabel26.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel26.setText("Secure Coding in Java SE Application:");
        jPanel7.add(jLabel26);

        jLabel27.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("Database Applications with JDBC:");
        jPanel7.add(jLabel27);

        jLabel28.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Localization:");
        jPanel7.add(jLabel28);

        jLabel29.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel29.setText("Annotations:");
        jPanel7.add(jLabel29);

        jLabel44.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel44.setText("Totales:");
        jPanel7.add(jLabel44);

        jPanel8.setLayout(new java.awt.GridLayout(15, 6));

        jLabelTotP1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelTotP1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotP1.setText("Preguntas:");
        jPanel8.add(jLabelTotP1);

        jLabelTotP3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelTotP3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotP3.setText("Hechas:");
        jPanel8.add(jLabelTotP3);

        jLabelTotP4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelTotP4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotP4.setText("Sin Hacer:");
        jPanel8.add(jLabelTotP4);

        jLabelTotP2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelTotP2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotP2.setText("Aciertos:");
        jPanel8.add(jLabelTotP2);

        jLabel42.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Fallos:");
        jPanel8.add(jLabel42);

        jLabelTotP5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelTotP5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotP5.setText("Calificación:");
        jPanel8.add(jLabelTotP5);

        jLabel1_1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1_1.setText("jLabel33");
        jPanel8.add(jLabel1_1);

        jLabel1_2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1_2.setText("jLabel33");
        jPanel8.add(jLabel1_2);

        jLabel1_3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1_3.setText("jLabel33");
        jPanel8.add(jLabel1_3);

        jLabel1_4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1_4.setForeground(new java.awt.Color(0, 141, 50));
        jLabel1_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1_4.setText("jLabel37");
        jPanel8.add(jLabel1_4);

        jLabel1_5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1_5.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1_5.setText("jLabel34");
        jPanel8.add(jLabel1_5);

        jLabel1_6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1_6.setText("jLabel31");
        jLabel1_6.setOpaque(true);
        jPanel8.add(jLabel1_6);

        jLabel2_1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2_1.setText("jLabel33");
        jPanel8.add(jLabel2_1);

        jLabel2_2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2_2.setText("jLabel33");
        jPanel8.add(jLabel2_2);

        jLabel2_3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2_3.setText("jLabel35");
        jPanel8.add(jLabel2_3);

        jLabel2_4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2_4.setForeground(new java.awt.Color(0, 141, 50));
        jLabel2_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2_4.setText("jLabel32");
        jPanel8.add(jLabel2_4);

        jLabel2_5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2_5.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2_5.setText("jLabel34");
        jPanel8.add(jLabel2_5);

        jLabel2_6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2_6.setText("jLabel36");
        jPanel8.add(jLabel2_6);

        jLabel3_1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3_1.setText("jLabel33");
        jPanel8.add(jLabel3_1);

        jLabel3_2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3_2.setText("jLabel40");
        jPanel8.add(jLabel3_2);

        jLabel3_3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3_3.setText("jLabel34");
        jPanel8.add(jLabel3_3);

        jLabel3_4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3_4.setForeground(new java.awt.Color(0, 141, 50));
        jLabel3_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3_4.setText("jLabel34");
        jPanel8.add(jLabel3_4);

        jLabel3_5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3_5.setForeground(new java.awt.Color(204, 0, 0));
        jLabel3_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3_5.setText("jLabel40");
        jPanel8.add(jLabel3_5);

        jLabel3_6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3_6.setText("jLabel55");
        jPanel8.add(jLabel3_6);

        jLabel4_1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4_1.setText("jLabel52");
        jPanel8.add(jLabel4_1);

        jLabel4_2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4_2.setText("jLabel49");
        jPanel8.add(jLabel4_2);

        jLabel4_3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4_3.setText("jLabel41");
        jPanel8.add(jLabel4_3);

        jLabel4_4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4_4.setForeground(new java.awt.Color(0, 141, 50));
        jLabel4_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4_4.setText("jLabel36");
        jPanel8.add(jLabel4_4);

        jLabel4_5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4_5.setForeground(new java.awt.Color(204, 0, 0));
        jLabel4_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4_5.setText("jLabel42");
        jPanel8.add(jLabel4_5);

        jLabel4_6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4_6.setText("jLabel33");
        jPanel8.add(jLabel4_6);

        jLabel5_1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5_1.setText("jLabel36");
        jPanel8.add(jLabel5_1);

        jLabel5_2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5_2.setText("jLabel35");
        jPanel8.add(jLabel5_2);

        jLabel5_3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5_3.setText("jLabel34");
        jPanel8.add(jLabel5_3);

        jLabel5_4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5_4.setForeground(new java.awt.Color(0, 141, 50));
        jLabel5_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5_4.setText("jLabel43");
        jPanel8.add(jLabel5_4);

        jLabel5_5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5_5.setForeground(new java.awt.Color(204, 0, 0));
        jLabel5_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5_5.setText("jLabel38");
        jPanel8.add(jLabel5_5);

        jLabel5_6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5_6.setText("jLabel43");
        jPanel8.add(jLabel5_6);

        jLabel6_1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6_1.setText("jLabel33");
        jPanel8.add(jLabel6_1);

        jLabel6_2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6_2.setText("jLabel51");
        jPanel8.add(jLabel6_2);

        jLabel6_3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6_3.setText("jLabel32");
        jPanel8.add(jLabel6_3);

        jLabel6_4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6_4.setForeground(new java.awt.Color(0, 141, 50));
        jLabel6_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6_4.setText("jLabel33");
        jPanel8.add(jLabel6_4);

        jLabel6_5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6_5.setForeground(new java.awt.Color(204, 0, 0));
        jLabel6_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6_5.setText("jLabel33");
        jPanel8.add(jLabel6_5);

        jLabel6_6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6_6.setText("jLabel34");
        jPanel8.add(jLabel6_6);

        jLabel7_1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7_1.setText("jLabel33");
        jPanel8.add(jLabel7_1);

        jLabel7_2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7_2.setText("jLabel32");
        jPanel8.add(jLabel7_2);

        jLabel7_3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7_3.setText("jLabel33");
        jPanel8.add(jLabel7_3);

        jLabel7_4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7_4.setForeground(new java.awt.Color(0, 141, 50));
        jLabel7_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7_4.setText("jLabel31");
        jPanel8.add(jLabel7_4);

        jLabel7_5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7_5.setForeground(new java.awt.Color(204, 0, 0));
        jLabel7_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7_5.setText("jLabel37");
        jPanel8.add(jLabel7_5);

        jLabel7_6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7_6.setText("jLabel33");
        jPanel8.add(jLabel7_6);

        jLabel8_1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8_1.setText("jLabel33");
        jPanel8.add(jLabel8_1);

        jLabel8_2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8_2.setText("jLabel38");
        jPanel8.add(jLabel8_2);

        jLabel8_3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8_3.setText("jLabel36");
        jPanel8.add(jLabel8_3);

        jLabel8_4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8_4.setForeground(new java.awt.Color(0, 141, 50));
        jLabel8_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8_4.setText("jLabel33");
        jPanel8.add(jLabel8_4);

        jLabel8_5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8_5.setForeground(new java.awt.Color(204, 0, 0));
        jLabel8_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8_5.setText("jLabel39");
        jPanel8.add(jLabel8_5);

        jLabel8_6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8_6.setText("jLabel33");
        jPanel8.add(jLabel8_6);

        jLabel9_1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9_1.setText("jLabel40");
        jPanel8.add(jLabel9_1);

        jLabel9_2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9_2.setText("jLabel38");
        jPanel8.add(jLabel9_2);

        jLabel9_3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9_3.setText("jLabel33");
        jPanel8.add(jLabel9_3);

        jLabel9_4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9_4.setForeground(new java.awt.Color(0, 141, 50));
        jLabel9_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9_4.setText("jLabel36");
        jPanel8.add(jLabel9_4);

        jLabel9_5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9_5.setForeground(new java.awt.Color(204, 0, 0));
        jLabel9_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9_5.setText("jLabel34");
        jPanel8.add(jLabel9_5);

        jLabel9_6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9_6.setText("jLabel33");
        jPanel8.add(jLabel9_6);

        jLabel10_1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10_1.setText("jLabel33");
        jPanel8.add(jLabel10_1);

        jLabel10_2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10_2.setText("jLabel33");
        jPanel8.add(jLabel10_2);

        jLabel10_3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10_3.setText("jLabel31");
        jPanel8.add(jLabel10_3);

        jLabel10_4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10_4.setForeground(new java.awt.Color(0, 141, 50));
        jLabel10_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10_4.setText("jLabel33");
        jPanel8.add(jLabel10_4);

        jLabel10_5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10_5.setForeground(new java.awt.Color(204, 0, 0));
        jLabel10_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10_5.setText("jLabel38");
        jPanel8.add(jLabel10_5);

        jLabel10_6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10_6.setText("jLabel35");
        jPanel8.add(jLabel10_6);

        jLabel11_1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11_1.setText("jLabel36");
        jPanel8.add(jLabel11_1);

        jLabel11_2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11_2.setText("jLabel84");
        jPanel8.add(jLabel11_2);

        jLabel11_3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11_3.setText("jLabel85");
        jPanel8.add(jLabel11_3);

        jLabel11_4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11_4.setForeground(new java.awt.Color(0, 141, 50));
        jLabel11_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11_4.setText("jLabel37");
        jPanel8.add(jLabel11_4);

        jLabel11_5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11_5.setForeground(new java.awt.Color(204, 0, 0));
        jLabel11_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11_5.setText("jLabel45");
        jPanel8.add(jLabel11_5);

        jLabel11_6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11_6.setText("jLabel33");
        jPanel8.add(jLabel11_6);

        jLabel12_1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12_1.setText("jLabel32");
        jPanel8.add(jLabel12_1);

        jLabel12_2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12_2.setText("jLabel89");
        jPanel8.add(jLabel12_2);

        jLabel12_3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12_3.setText("jLabel79");
        jPanel8.add(jLabel12_3);

        jLabel12_4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12_4.setForeground(new java.awt.Color(0, 141, 50));
        jLabel12_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12_4.setText("jLabel88");
        jPanel8.add(jLabel12_4);

        jLabel12_5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12_5.setForeground(new java.awt.Color(204, 0, 0));
        jLabel12_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12_5.setText("jLabel39");
        jPanel8.add(jLabel12_5);

        jLabel12_6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12_6.setText("jLabel33");
        jPanel8.add(jLabel12_6);

        jLabel13_1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13_1.setText("jLabel33");
        jPanel8.add(jLabel13_1);

        jLabel13_2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13_2.setText("jLabel36");
        jPanel8.add(jLabel13_2);

        jLabel13_3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13_3.setText("jLabel32");
        jPanel8.add(jLabel13_3);

        jLabel13_4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13_4.setForeground(new java.awt.Color(0, 141, 50));
        jLabel13_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13_4.setText("jLabel32");
        jPanel8.add(jLabel13_4);

        jLabel13_5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13_5.setForeground(new java.awt.Color(204, 0, 0));
        jLabel13_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13_5.setText("jLabel32");
        jPanel8.add(jLabel13_5);

        jLabel13_6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13_6.setText("jLabel32");
        jPanel8.add(jLabel13_6);

        jLabel15_1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15_1.setText("jLabel78");
        jPanel8.add(jLabel15_1);

        jLabel15_2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15_2.setText("jLabel80");
        jPanel8.add(jLabel15_2);

        jLabel15_3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15_3.setText("jLabel86");
        jPanel8.add(jLabel15_3);

        jLabel15_4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15_4.setForeground(new java.awt.Color(0, 141, 50));
        jLabel15_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15_4.setText("jLabel87");
        jPanel8.add(jLabel15_4);

        jLabel15_5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15_5.setForeground(new java.awt.Color(204, 0, 0));
        jLabel15_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15_5.setText("jLabel90");
        jPanel8.add(jLabel15_5);

        jLabel15_6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15_6.setText("jLabel91");
        jPanel8.add(jLabel15_6);

        jPanel9.setLayout(new java.awt.GridLayout(15, 1));

        jLabel83.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel83.setText("Avance:");
        jPanel9.add(jLabel83);
        jPanel9.add(jProgressBar1);
        jPanel9.add(jProgressBar2);
        jPanel9.add(jProgressBar3);
        jPanel9.add(jProgressBar4);
        jPanel9.add(jProgressBar5);
        jPanel9.add(jProgressBar6);
        jPanel9.add(jProgressBar7);
        jPanel9.add(jProgressBar8);
        jPanel9.add(jProgressBar9);
        jPanel9.add(jProgressBar10);
        jPanel9.add(jProgressBar11);
        jPanel9.add(jProgressBar12);
        jPanel9.add(jProgressBar13);
        jPanel9.add(jProgressBar15);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialogEstadisticaLayout = new javax.swing.GroupLayout(jDialogEstadistica.getContentPane());
        jDialogEstadistica.getContentPane().setLayout(jDialogEstadisticaLayout);
        jDialogEstadisticaLayout.setHorizontalGroup(
            jDialogEstadisticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialogEstadisticaLayout.setVerticalGroup(
            jDialogEstadisticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("OCP - ORACLE CERTIFIED PROFESSIONAL - EXAM 1Z0-819");

        jPanelInterfaz.setLayout(new java.awt.CardLayout());

        jButtonHacerExamen.setText("Hacer examen de Preguntas");
        jButtonHacerExamen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHacerExamenActionPerformed(evt);
            }
        });

        jButtonExamenErrores.setText("Hacer examen de errores");
        jButtonExamenErrores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExamenErroresActionPerformed(evt);
            }
        });

        jButtonRevision.setText("Revision");
        jButtonRevision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRevisionActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/escritorio.jpg"))); // NOI18N

        jButtonReinicio.setText("Reiniciar progreso");
        jButtonReinicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReinicioActionPerformed(evt);
            }
        });

        jButton3.setText("Configurar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("Estadistica");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Historial"));

        jComboBoxHistorial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel30.setText("Seleccione examen:");

        jButton6.setText("Borrar examen");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBoxHistorial, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton8.setText("Resultados Test:");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jScrollPane3.setPreferredSize(new java.awt.Dimension(220, 420));

        jPanel11.setLayout(new javax.swing.BoxLayout(jPanel11, javax.swing.BoxLayout.PAGE_AXIS));
        jScrollPane3.setViewportView(jPanel11);

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                        .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonHacerExamen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonExamenErrores, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonRevision, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonReinicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jButtonHacerExamen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonExamenErrores, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonRevision)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonReinicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
        );

        jPanelInterfaz.add(jPanelPrincipal, "card3");

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTextAreaExplicacion.setColumns(20);
        jTextAreaExplicacion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jTextAreaExplicacion.setLineWrap(true);
        jTextAreaExplicacion.setRows(5);
        jTextAreaExplicacion.setText("sdjfkjs kjskfjdhfkjhsdf jhsf kjhskfjhsjhs fdf");
        jTextAreaExplicacion.setWrapStyleWord(true);
        jTextAreaExplicacion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jScrollPane1.setViewportView(jTextAreaExplicacion);

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setText("Explanation:");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanelExplicacionLayout = new javax.swing.GroupLayout(jPanelExplicacion);
        jPanelExplicacion.setLayout(jPanelExplicacionLayout);
        jPanelExplicacionLayout.setHorizontalGroup(
            jPanelExplicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelExplicacionLayout.createSequentialGroup()
                .addGroup(jPanelExplicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelExplicacionLayout.setVerticalGroup(
            jPanelExplicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelExplicacionLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1))
        );

        jPanelAlterno.setLayout(new java.awt.CardLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(254, 600));

        jTextAreaQuestion.setColumns(20);
        jTextAreaQuestion.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jTextAreaQuestion.setLineWrap(true);
        jTextAreaQuestion.setRows(5);
        jTextAreaQuestion.setText("134. What is a possible output of the following application?");
        jTextAreaQuestion.setWrapStyleWord(true);
        jTextAreaQuestion.setMargin(new java.awt.Insets(2, 15, 2, 15));
        jScrollPane2.setViewportView(jTextAreaQuestion);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
        );

        jPanelAlterno.add(jPanel1, "card2");

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jScrollPane4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jScrollPane4.setPreferredSize(new java.awt.Dimension(254, 100));

        jTextAreaQuestionImagen.setColumns(20);
        jTextAreaQuestionImagen.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jTextAreaQuestionImagen.setLineWrap(true);
        jTextAreaQuestionImagen.setRows(5);
        jTextAreaQuestionImagen.setText("134. What is a possible output of the following application?");
        jTextAreaQuestionImagen.setWrapStyleWord(true);
        jTextAreaQuestionImagen.setMargin(new java.awt.Insets(2, 15, 2, 15));
        jScrollPane4.setViewportView(jTextAreaQuestionImagen);

        jScrollPane7.setViewportView(jLabelImagen);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane7)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE))
                .addGap(42, 42, 42))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanelAlterno.add(jPanel2, "card3");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanelAlterno, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelExplicacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelAlterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelExplicacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelPreguntaLayout = new javax.swing.GroupLayout(jPanelPregunta);
        jPanelPregunta.setLayout(jPanelPreguntaLayout);
        jPanelPreguntaLayout.setHorizontalGroup(
            jPanelPreguntaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelPreguntaLayout.setVerticalGroup(
            jPanelPreguntaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelOpciones.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanelOpcionesMouseMoved(evt);
            }
        });
        jPanelOpciones.setLayout(new javax.swing.BoxLayout(jPanelOpciones, javax.swing.BoxLayout.Y_AXIS));

        jRadioButtonOpcionA.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jRadioButtonOpcionA.setText("jRadioButton1");
        jRadioButtonOpcionA.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jRadioButtonOpcionA.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jRadioButtonOpcionA.setIconTextGap(3);
        jRadioButtonOpcionA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jRadioButtonOpcionAMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jRadioButtonOpcionAMouseExited(evt);
            }
        });
        jRadioButtonOpcionA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonOpcionAActionPerformed(evt);
            }
        });
        jPanelOpciones.add(jRadioButtonOpcionA);

        jRadioButtonOpcionB.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jRadioButtonOpcionB.setText("jRadioButton2");
        jRadioButtonOpcionB.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jRadioButtonOpcionB.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jRadioButtonOpcionB.setIconTextGap(3);
        jRadioButtonOpcionB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jRadioButtonOpcionBMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jRadioButtonOpcionBMouseExited(evt);
            }
        });
        jRadioButtonOpcionB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonOpcionBActionPerformed(evt);
            }
        });
        jPanelOpciones.add(jRadioButtonOpcionB);

        jRadioButtonOpcionC.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jRadioButtonOpcionC.setText("jRadioButton3");
        jRadioButtonOpcionC.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jRadioButtonOpcionC.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jRadioButtonOpcionC.setIconTextGap(3);
        jRadioButtonOpcionC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jRadioButtonOpcionCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jRadioButtonOpcionCMouseExited(evt);
            }
        });
        jRadioButtonOpcionC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonOpcionCActionPerformed(evt);
            }
        });
        jPanelOpciones.add(jRadioButtonOpcionC);

        jRadioButtonOpcionD.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jRadioButtonOpcionD.setText("jRadioButton4");
        jRadioButtonOpcionD.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jRadioButtonOpcionD.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jRadioButtonOpcionD.setIconTextGap(3);
        jRadioButtonOpcionD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jRadioButtonOpcionDMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jRadioButtonOpcionDMouseExited(evt);
            }
        });
        jRadioButtonOpcionD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonOpcionDActionPerformed(evt);
            }
        });
        jPanelOpciones.add(jRadioButtonOpcionD);

        jRadioButtonOpcionE.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jRadioButtonOpcionE.setText("jRadioButton5");
        jRadioButtonOpcionE.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jRadioButtonOpcionE.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jRadioButtonOpcionE.setIconTextGap(3);
        jRadioButtonOpcionE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jRadioButtonOpcionEMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jRadioButtonOpcionEMouseExited(evt);
            }
        });
        jRadioButtonOpcionE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonOpcionEActionPerformed(evt);
            }
        });
        jPanelOpciones.add(jRadioButtonOpcionE);

        jRadioButtonOpcionF.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jRadioButtonOpcionF.setText("jRadioButton6");
        jRadioButtonOpcionF.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jRadioButtonOpcionF.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jRadioButtonOpcionF.setIconTextGap(3);
        jRadioButtonOpcionF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jRadioButtonOpcionFMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jRadioButtonOpcionFMouseExited(evt);
            }
        });
        jRadioButtonOpcionF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonOpcionFActionPerformed(evt);
            }
        });
        jPanelOpciones.add(jRadioButtonOpcionF);

        jPanelControles.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanelControlesMouseMoved(evt);
            }
        });

        jButtonBack.setText("<-back");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

        jButtonEvalExamen.setText("Finalizar");
        jButtonEvalExamen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEvalExamenActionPerformed(evt);
            }
        });

        jButtonNext.setText("next ->");
        jButtonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextActionPerformed(evt);
            }
        });

        jButtonEvalPregunta.setText("Evaluate");
        jButtonEvalPregunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEvalPreguntaActionPerformed(evt);
            }
        });

        jButtonSolution.setText("Solution");
        jButtonSolution.setEnabled(false);
        jButtonSolution.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSolutionActionPerformed(evt);
            }
        });

        jButtonEvalExamen1.setText("Delete");
        jButtonEvalExamen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEvalExamen1ActionPerformed(evt);
            }
        });

        jButton7.setText("jButton7");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelControlesLayout = new javax.swing.GroupLayout(jPanelControles);
        jPanelControles.setLayout(jPanelControlesLayout);
        jPanelControlesLayout.setHorizontalGroup(
            jPanelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelControlesLayout.createSequentialGroup()
                .addComponent(jButtonEvalPregunta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSolution)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEvalExamen1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonEvalExamen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonNext)
                .addGap(134, 134, 134))
        );
        jPanelControlesLayout.setVerticalGroup(
            jPanelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelControlesLayout.createSequentialGroup()
                .addGroup(jPanelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNext)
                    .addComponent(jButtonBack)
                    .addComponent(jButtonEvalExamen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEvalPregunta)
                    .addComponent(jButtonSolution)
                    .addComponent(jButtonEvalExamen1)
                    .addComponent(jButton7))
                .addGap(0, 5, Short.MAX_VALUE))
        );

        jLabelNumberOfQuestion.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabelNumberOfQuestion.setText("Question :");
        jLabelNumberOfQuestion.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 15, 1, 1));

        jLabelClock.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelClock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelClock.setText("jLabel3");
        jLabelClock.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanelExamenLayout = new javax.swing.GroupLayout(jPanelExamen);
        jPanelExamen.setLayout(jPanelExamenLayout);
        jPanelExamenLayout.setHorizontalGroup(
            jPanelExamenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelControles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelPregunta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelExamenLayout.createSequentialGroup()
                .addComponent(jLabelNumberOfQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelClock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelExamenLayout.setVerticalGroup(
            jPanelExamenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelExamenLayout.createSequentialGroup()
                .addGroup(jPanelExamenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelNumberOfQuestion)
                    .addGroup(jPanelExamenLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabelClock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelPregunta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelControles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanelInterfaz.add(jPanelExamen, "card2");

        jLabelCharter.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabelCharter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCharter.setText("Working with Java Data Types");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("TOTAL QUESTIONS:");

        jLabelAciertos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelAciertos.setForeground(new java.awt.Color(0, 141, 50));
        jLabelAciertos.setText("CORRECT ANSWERS:");

        jLabelFallos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelFallos.setForeground(new java.awt.Color(204, 0, 0));
        jLabelFallos.setText("FAILED ANSWERS:");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("QUALIFICATION (%):");

        jLabelPreguntas.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelPreguntas.setText("0");

        jLabelPreguntasAcertadas.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelPreguntasAcertadas.setForeground(new java.awt.Color(0, 141, 50));
        jLabelPreguntasAcertadas.setText("0");

        jLabelPreguntasFalladas.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelPreguntasFalladas.setForeground(new java.awt.Color(204, 0, 0));
        jLabelPreguntasFalladas.setText("0");

        jLabelCalificacion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelCalificacion.setText("0");
        jLabelCalificacion.setOpaque(true);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("TEST RESULT:");

        javax.swing.GroupLayout jPanelResultadosLayout = new javax.swing.GroupLayout(jPanelResultados);
        jPanelResultados.setLayout(jPanelResultadosLayout);
        jPanelResultadosLayout.setHorizontalGroup(
            jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelResultadosLayout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCalificacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelResultadosLayout.createSequentialGroup()
                .addGroup(jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabelAciertos, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelFallos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPreguntas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelPreguntasFalladas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelPreguntasAcertadas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelResultadosLayout.setVerticalGroup(
            jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelResultadosLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabelPreguntas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAciertos)
                    .addComponent(jLabelPreguntasAcertadas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFallos)
                    .addComponent(jLabelPreguntasFalladas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabelCalificacion)))
        );

        jButton1.setText("volver inicio");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPaneDatos.setPreferredSize(new java.awt.Dimension(220, 2));

        jPanelDatos.setBackground(new java.awt.Color(255, 255, 255));
        jPanelDatos.setLayout(new javax.swing.BoxLayout(jPanelDatos, javax.swing.BoxLayout.PAGE_AXIS));
        jScrollPaneDatos.setViewportView(jPanelDatos);

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("TOTAL QUESTIONS:");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 141, 50));
        jLabel13.setText("CORRECT ANSWERS:");

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 0, 0));
        jLabel14.setText("FAILED ANSWERS:");

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setText("QUALIFICATION (%):");

        jLabelPreguntas1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelPreguntas1.setText("0");

        jLabelPreguntasAcertadas1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelPreguntasAcertadas1.setForeground(new java.awt.Color(0, 141, 50));
        jLabelPreguntasAcertadas1.setText("0");

        jLabelPreguntasFalladas1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelPreguntasFalladas1.setForeground(new java.awt.Color(204, 0, 0));
        jLabelPreguntasFalladas1.setText("0");

        jLabelCalificacion1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelCalificacion1.setText("0");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("CHARTER:");

        javax.swing.GroupLayout jPanelResultados1Layout = new javax.swing.GroupLayout(jPanelResultados1);
        jPanelResultados1.setLayout(jPanelResultados1Layout);
        jPanelResultados1Layout.setHorizontalGroup(
            jPanelResultados1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelResultados1Layout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCalificacion1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelResultados1Layout.createSequentialGroup()
                .addGroup(jPanelResultados1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelResultados1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPreguntas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelPreguntasFalladas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelPreguntasAcertadas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelResultados1Layout.setVerticalGroup(
            jPanelResultados1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelResultados1Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelResultados1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabelPreguntas1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelResultados1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabelPreguntasAcertadas1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelResultados1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabelPreguntasFalladas1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelResultados1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabelCalificacion1))
                .addContainerGap())
        );

        jButton4.setText("subir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelRevision1Layout = new javax.swing.GroupLayout(jPanelRevision1);
        jPanelRevision1.setLayout(jPanelRevision1Layout);
        jPanelRevision1Layout.setHorizontalGroup(
            jPanelRevision1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelCharter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRevision1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1))
            .addComponent(jScrollPaneDatos, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
            .addGroup(jPanelRevision1Layout.createSequentialGroup()
                .addComponent(jPanelResultados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelResultados1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelRevision1Layout.setVerticalGroup(
            jPanelRevision1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRevision1Layout.createSequentialGroup()
                .addComponent(jLabelCharter, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneDatos, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRevision1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelResultados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelResultados1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRevision1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton4)))
        );

        jTabbedPane1.addTab("Chapter 2", jPanelRevision1);

        jTree1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTree1MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTree1);

        javax.swing.GroupLayout jPanelRevisionesLayout = new javax.swing.GroupLayout(jPanelRevisiones);
        jPanelRevisiones.setLayout(jPanelRevisionesLayout);
        jPanelRevisionesLayout.setHorizontalGroup(
            jPanelRevisionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRevisionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanelRevisionesLayout.setVerticalGroup(
            jPanelRevisionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRevisionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6))
        );

        jPanelInterfaz.add(jPanelRevisiones, "card4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelInterfaz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanelInterfaz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanelOpcionesMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelOpcionesMouseMoved

//jLabelOptionA.setBackground(new Color(240,240,240));
//jLabelOptionB.setBackground(new Color(240,240,240));
//jLabelOptionC.setBackground(new Color(240,240,240));
//jLabelOptionD.setBackground(new Color(240,240,240));

    }//GEN-LAST:event_jPanelOpcionesMouseMoved

    private void jPanelControlesMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelControlesMouseMoved

//jLabelOptionA.setBackground(new Color(240,240,240));
//jLabelOptionB.setBackground(new Color(240,240,240));
//jLabelOptionC.setBackground(new Color(240,240,240));
//jLabelOptionD.setBackground(new Color(240,240,240));

    }//GEN-LAST:event_jPanelControlesMouseMoved

    private void jButtonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextActionPerformed
//        evaluarPregunta(false);
        
        if (++num == preguntasExamen.size()) {
            num = 0;
        }
        test();
    }//GEN-LAST:event_jButtonNextActionPerformed

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
//        evaluarPregunta(false);
        if (--num == -1) {
            num = preguntasExamen.size() - 1;
        }
        test();
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jButtonHacerExamenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHacerExamenActionPerformed

        this.setResizable(true);
//        Main.load();
        preguntasExamen = new ArrayList();

        if (jComboBoxHistorial.getSelectedIndex() == 0) {

int cant = (int) jSpinnerCantQuestion.getModel().getValue();             
int quantity= jListCharterEvaluate.getModel().getSize();
  
Long limit=  Math.round(cant/(double)quantity);
       
            String aleatorio = jComboBox1.getSelectedItem().toString();
            String aleatorioCharter = jComboBox2.getSelectedItem().toString(); 
                     
            for (int i = 0; i < jListCharterEvaluate.getModel().getSize(); i++) {

                String charter = jListCharterEvaluate.getModel().getElementAt(i).toString();
                loadTest(charter, aleatorioCharter, limit);

            }

            if (aleatorio.equals("Aleatorio")) {
                Collections.shuffle(preguntasExamen);
            }

            
            if (preguntasExamen.size() >= cant) {
                preguntasExamen = preguntasExamen.subList(0, cant);
            }


            ArrayList<String> examHist = new ArrayList();

            preguntasExamen.stream().forEach((Question p) -> examHist.add(p.getChapter() + " " + p.getNumber()));

            String key = "test00";

            if (!historialExam.isEmpty()) {

                int x = 0;
                boolean exit;
                do {
                    exit = false;
                    key = "test" + x;
                    if (x < 10) {
                        key = "test0" + x;
                    }
                    for (int i = 0; i < jComboBoxHistorial.getItemCount(); i++) {

                        if (key.equals(jComboBoxHistorial.getItemAt(i).toString())) {
                            exit = true;
                            x++;
                        }
                    }

                } while (exit);

            }

            historialExam.put(key, examHist);
            jComboBoxHistorial.addItem(key);
            HitorialExam.save();

        } else {

                 
            int m = JOptionPane.showOptionDialog(null, "¿Desea reiniciar el Examen?",
                    "Terminar Examen", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.WARNING_MESSAGE, null,// null para icono por defecto.
                    new Object[]{"SI", "NO"}, "SI");
            ArrayList<String> examHist = historialExam.get(jComboBoxHistorial.getSelectedItem().toString());
            preguntasExamen.clear();
            
            
            for (String ques : examHist) {

                String words1[] = ques.split(" ");
                int charter = Integer.parseInt(words1[0]);
                int number = Integer.parseInt(words1[1]);

                preguntas.stream().filter(p -> (p.getChapter() == charter)
                        && (p.getNumber() == number)).forEachOrdered(p ->{                          
                            if(m==0){
                            p.setAnswered(false);
                            p.setUserAnswers(new ArrayList());
                            }
                                                        
                            preguntasExamen.add(p);} );

            }            
            
            


                   



        }

        num = 0;
        test();
        this.pack();
        jPanelPrincipal.setVisible(false);
        jPanelExamen.setVisible(true);
        
        jLabelClock.setText(((int) jSpinnerTiempo.getModel().getValue()-1) + ":60");
        
        
        Runnable task = () -> {

            String[] text = jLabelClock.getText().split(":");

            int minutes = Integer.parseInt(text[1]) == 0 ? Integer.parseInt(text[0]) - 1 : Integer.parseInt(text[0]);
            int seconds = Integer.parseInt(text[1]) == 0 ? 60 : Integer.parseInt(text[1]);

            --seconds;
            String tSec = seconds < 10 ? "0" + String.valueOf(seconds) : String.valueOf(seconds);

            jLabelClock.setText(minutes + ":" + tSec);

        };
               
        ses = Executors.newScheduledThreadPool(1);
        ses.scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS);
        ExecutorService es = Executors.unconfigurableExecutorService(ses);


    }//GEN-LAST:event_jButtonHacerExamenActionPerformed

    private void jRadioButtonOpcionAMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonOpcionAMouseEntered
        jRadioButtonOpcionA.setFont(new Font("SansSerif", Font.BOLD, 14));
    }//GEN-LAST:event_jRadioButtonOpcionAMouseEntered

    private void jRadioButtonOpcionAMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonOpcionAMouseExited
        jRadioButtonOpcionA.setFont(new Font("SansSerif", Font.PLAIN, 14));
        if (jRadioButtonOpcionA.isSelected()) {
            jRadioButtonOpcionA.setFont(new Font("SansSerif", Font.BOLD, 14));
        }
    }//GEN-LAST:event_jRadioButtonOpcionAMouseExited

    private void jRadioButtonOpcionBMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonOpcionBMouseEntered
        jRadioButtonOpcionB.setFont(new Font("SansSerif", Font.BOLD, 14));
    }//GEN-LAST:event_jRadioButtonOpcionBMouseEntered

    private void jRadioButtonOpcionCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonOpcionCMouseEntered
        jRadioButtonOpcionC.setFont(new Font("SansSerif", Font.BOLD, 14));
    }//GEN-LAST:event_jRadioButtonOpcionCMouseEntered

    private void jRadioButtonOpcionDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonOpcionDActionPerformed
        jRadioButtonOpcionD.setFont(new Font("SansSerif", Font.BOLD, 14));
        
        List<Integer> rightAnswers = preguntasExamen.get(num).getRightAnswers();
            int usw=0;
            if (jRadioButtonOpcionA.isSelected()){usw++;}
             if (jRadioButtonOpcionB.isSelected()){usw++;}
              if (jRadioButtonOpcionC.isSelected()){usw++;}
               if (jRadioButtonOpcionD.isSelected()){usw++;}
                if (jRadioButtonOpcionE.isSelected()){usw++;}
                 if (jRadioButtonOpcionF.isSelected()){usw++;}
    
        if(rightAnswers.size()==usw){
        evaluarPreguntaRev();
        } else{      
        preguntasExamen.get(num).setAnswered(false);       
                 
        }
        
        
    }//GEN-LAST:event_jRadioButtonOpcionDActionPerformed

    private void jRadioButtonOpcionEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonOpcionEMouseEntered
        jRadioButtonOpcionE.setFont(new Font("SansSerif", Font.BOLD, 14));
    }//GEN-LAST:event_jRadioButtonOpcionEMouseEntered

    private void jRadioButtonOpcionFMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonOpcionFMouseEntered
        jRadioButtonOpcionF.setFont(new Font("SansSerif", Font.BOLD, 14));        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonOpcionFMouseEntered

    private void jRadioButtonOpcionBMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonOpcionBMouseExited
        jRadioButtonOpcionB.setFont(new Font("SansSerif", Font.PLAIN, 14));
        if (jRadioButtonOpcionB.isSelected()) {
            jRadioButtonOpcionB.setFont(new Font("SansSerif", Font.BOLD, 14));
        }
    }//GEN-LAST:event_jRadioButtonOpcionBMouseExited

    private void jRadioButtonOpcionCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonOpcionCMouseExited
        jRadioButtonOpcionC.setFont(new Font("SansSerif", Font.PLAIN, 14));
        if (jRadioButtonOpcionC.isSelected()) {
            jRadioButtonOpcionC.setFont(new Font("SansSerif", Font.BOLD, 14));
        }
    }//GEN-LAST:event_jRadioButtonOpcionCMouseExited

    private void jRadioButtonOpcionDMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonOpcionDMouseExited
        jRadioButtonOpcionD.setFont(new Font("SansSerif", Font.PLAIN, 14));
        if (jRadioButtonOpcionD.isSelected()) {
            jRadioButtonOpcionD.setFont(new Font("SansSerif", Font.BOLD, 14));
        }
    }//GEN-LAST:event_jRadioButtonOpcionDMouseExited

    private void jRadioButtonOpcionDMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonOpcionDMouseEntered
        jRadioButtonOpcionD.setFont(new Font("SansSerif", Font.BOLD, 14));
    }//GEN-LAST:event_jRadioButtonOpcionDMouseEntered

    private void jRadioButtonOpcionEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonOpcionEMouseExited
        jRadioButtonOpcionE.setFont(new Font("SansSerif", Font.PLAIN, 14));
        if (jRadioButtonOpcionE.isSelected()) {
            jRadioButtonOpcionE.setFont(new Font("SansSerif", Font.BOLD, 14));
        }
    }//GEN-LAST:event_jRadioButtonOpcionEMouseExited

    private void jRadioButtonOpcionFMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonOpcionFMouseExited
        jRadioButtonOpcionF.setFont(new Font("SansSerif", Font.PLAIN, 14));
        if (jRadioButtonOpcionF.isSelected()) {
            jRadioButtonOpcionF.setFont(new Font("SansSerif", Font.BOLD, 14));
        }
    }//GEN-LAST:event_jRadioButtonOpcionFMouseExited

    private void jRadioButtonOpcionAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonOpcionAActionPerformed
        jRadioButtonOpcionA.setFont(new Font("SansSerif", Font.PLAIN, 14));
        if (jRadioButtonOpcionA.isSelected()) {
            jRadioButtonOpcionA.setFont(new Font("SansSerif", Font.BOLD, 14));
        }
        
List<Integer> rightAnswers = preguntasExamen.get(num).getRightAnswers();
            int usw=0;
            if (jRadioButtonOpcionA.isSelected()){usw++;}
             if (jRadioButtonOpcionB.isSelected()){usw++;}
              if (jRadioButtonOpcionC.isSelected()){usw++;}
               if (jRadioButtonOpcionD.isSelected()){usw++;}
                if (jRadioButtonOpcionE.isSelected()){usw++;}
                 if (jRadioButtonOpcionF.isSelected()){usw++;}
    
        if(rightAnswers.size()==usw){
        evaluarPreguntaRev();
        } else{      
        preguntasExamen.get(num).setAnswered(false);       
                 
        }
        
        
        
        
        
        
    }//GEN-LAST:event_jRadioButtonOpcionAActionPerformed

    private void jButtonEvalPreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEvalPreguntaActionPerformed
//        evaluarPregunta(true);
        evaluarPreguntaRev();

    }//GEN-LAST:event_jButtonEvalPreguntaActionPerformed

    private void jButtonEvalExamenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEvalExamenActionPerformed

        int p = JOptionPane.showOptionDialog(null, "¿Confirma que desea terminar el examen\n y pasar a la pantalla de revisión?",
                "Terminar Examen", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.WARNING_MESSAGE, null,// null para icono por defecto.
                new Object[]{"SI", "NO"}, "SI");

        if (p == 0) {
            

jRadioButtonOpcionA.setSelected(false);
jRadioButtonOpcionB.setSelected(false);
jRadioButtonOpcionC.setSelected(false);
jRadioButtonOpcionD.setSelected(false);
jRadioButtonOpcionE.setSelected(false);
jRadioButtonOpcionF.setSelected(false);

            this.pack();
            JSON.saveToJSON(preguntas, JSON.PROGRESS);
            jPanelExamen.setVisible(false);
            jPanelPrincipal.setVisible(true);
//          Cronometro.stop = true;
ses.shutdown();
ses.shutdownNow();

            
            

        }


    }//GEN-LAST:event_jButtonEvalExamenActionPerformed

    private void jButtonEvalExamen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEvalExamen1ActionPerformed

        int p = JOptionPane.showOptionDialog(null, "¿Confirma que desea borrar todos los registros actuales?",
                "Borrar registros", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.WARNING_MESSAGE, null,// null para icono por defecto.
                new Object[]{"SI", "NO"}, "SI");

        if (p == 0) {
            File file = new File(System.getProperty("user.dir") + "/data.dat");
            file.delete();

        }
    }//GEN-LAST:event_jButtonEvalExamen1ActionPerformed

    private void jButtonExamenErroresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExamenErroresActionPerformed

        List<Question> questErr = new ArrayList<>();

        //   preguntas.stream().filter(p -> p.isCorrect()).filter(p -> p.isAnswered()).forEach(p -> questErr.add(p));
        preguntas.stream().filter(p -> p.isAnswered() && !p.isCorrect()).forEach(p -> questErr.add(p));

        preguntasExamen = questErr;

        System.out.println(preguntas.size());
        System.out.println(preguntasExamen.size());

        Main.num = 0;
        test();
        jPanelPrincipal.setVisible(false);
        jPanelExamen.setVisible(true);


    }//GEN-LAST:event_jButtonExamenErroresActionPerformed

    private void jButtonRevisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRevisionActionPerformed

        if (jComboBoxHistorial.getSelectedIndex() != 0) {

            ArrayList<String> examHist = historialExam.get(jComboBoxHistorial.getSelectedItem().toString());
            preguntasExamen.clear();
            for (String ques : examHist) {

                String words1[] = ques.split(" ");
                int charter = Integer.parseInt(words1[0]);
                int number = Integer.parseInt(words1[1]);

                preguntas.stream().filter(p -> (p.getChapter() == charter)
                        && (p.getNumber() == number)).forEach(p -> preguntasExamen.add(p));
            }

        }

        float[] resul = cargarRevision(preguntasExamen);

//jTextPaneRevisionesCharter1.setText("<body>"+Text+"</body>");
        float fallos = resul[2];
        float aciertos = resul[1];
        float total = resul[0];

        double calificacion = (double) Math.round(aciertos / total * 100 * 100) / 100;

        String aprob = "% You have failed!";
        jLabelCalificacion.setForeground(new Color(204, 0, 0));

        if (calificacion >= 68) {
            aprob = "% You passed!";
            jLabelCalificacion.setForeground(new Color(0, 141, 50));
        }

        jLabelPreguntas.setText(String.valueOf(preguntasExamen.size()));
        jLabelPreguntasFalladas.setText(String.valueOf(fallos));
        jLabelPreguntasAcertadas.setText(String.valueOf(aciertos));
        jLabelCalificacion.setText(String.valueOf(calificacion) + aprob);

        jPanelPrincipal.setVisible(false);
        jPanelRevisiones.setVisible(true);

        jPanelResultados1.setVisible(false);

        jButton4.doClick();


    }//GEN-LAST:event_jButtonRevisionActionPerformed

    private void jButtonReinicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReinicioActionPerformed
        int p = JOptionPane.showOptionDialog(null, "¿Confirma que desea borrar todos los registros actuales?",
                "Borrar registros", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.WARNING_MESSAGE, null,// null para icono por defecto.
                new Object[]{"SI", "NO"}, "NO");

        if (p == 0) {
            try {
                preguntas = JSON.freshLoadFromJSON();
            } catch (IOException ex) {
                Logger.getLogger(VentanaTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonReinicioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        this.pack();
        jPanelRevisiones.setVisible(false);
        jPanelPrincipal.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTree1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTree1MouseClicked

        if (evt.getClickCount() == 1) {

            jPanelDatos.removeAll();
            jLabelPreguntas1.setText("");
            jPanelResultados1.setVisible(true);

            DefaultTreeModel model = (DefaultTreeModel) jTree1.getModel();
            DefaultMutableTreeNode Estimado = (DefaultMutableTreeNode) model.getRoot(); //insertar en la raiz

            DefaultMutableTreeNode Capitulo = null;
            try {

                Capitulo = (DefaultMutableTreeNode) model.getChild(Estimado,
                        model.getIndexOfChild(((DefaultMutableTreeNode) jTree1.getSelectionPath().getPathComponent(0)),
                                ((DefaultMutableTreeNode) jTree1.getSelectionPath().getPathComponent(1))));

                jLabelCharter.setText(Capitulo.toString());

            } catch (IllegalArgumentException e) {
                System.out.println("mostrar todos los capitulos");
            }

            List<Question> tema1 = new ArrayList();
            if (Capitulo != null && Capitulo.toString().equals("Charter 1: Working with Java Data Types")) {
                preguntasExamen.stream().filter(p -> p.getChapter() == 1).forEach(p -> tema1.add(p));
            }
            if (Capitulo != null && Capitulo.toString().equals("Chapter 2: Controlling Program Flow")) {
                preguntasExamen.stream().filter(p -> p.getChapter() == 2).forEach(p -> tema1.add(p));
            }
            if (Capitulo != null && Capitulo.toString().equals("Chapter 3: Java Object‐Oriented Approach")) {
                preguntasExamen.stream().filter(p -> p.getChapter() == 3).forEach(p -> tema1.add(p));
            }
            if (Capitulo != null && Capitulo.toString().equals("Chapter 4: Exception Handling")) {
                preguntasExamen.stream().filter(p -> p.getChapter() == 4).forEach(p -> tema1.add(p));
            }
            if (Capitulo != null && Capitulo.toString().equals("Chapter 5: Working with Arrays and Collections")) {
                preguntasExamen.stream().filter(p -> p.getChapter() == 5).forEach(p -> tema1.add(p));
            }
            if (Capitulo != null && Capitulo.toString().equals("Chapter 6: Working with Streams and Lambda Expressions")) {
                preguntasExamen.stream().filter(p -> p.getChapter() == 6).forEach(p -> tema1.add(p));
            }
            if (Capitulo != null && Capitulo.toString().equals("Chapter 7: Java Platform Module System")) {
                preguntasExamen.stream().filter(p -> p.getChapter() == 7).forEach(p -> tema1.add(p));
            }
            if (Capitulo != null && Capitulo.toString().equals("Chapter 8: Concurrency")) {
                preguntasExamen.stream().filter(p -> p.getChapter() == 8).forEach(p -> tema1.add(p));
            }
            if (Capitulo != null && Capitulo.toString().equals("Chapter 9: Java I/O API")) {
                preguntasExamen.stream().filter(p -> p.getChapter() == 9).forEach(p -> tema1.add(p));
            }
            if (Capitulo != null && Capitulo.toString().equals("Chapter 10: Secure Coding in Java SE Application")) {
                preguntasExamen.stream().filter(p -> p.getChapter() == 10).forEach(p -> tema1.add(p));
            }
            if (Capitulo != null && Capitulo.toString().equals("Chapter 11: Database Applications with JDBC")) {
                preguntasExamen.stream().filter(p -> p.getChapter() == 11).forEach(p -> tema1.add(p));
            }
            if (Capitulo != null && Capitulo.toString().equals("Chapter 12: Localization")) {
                preguntasExamen.stream().filter(p -> p.getChapter() == 12).forEach(p -> tema1.add(p));
            }
            if (Capitulo != null && Capitulo.toString().equals("Chapter 13: Annotations")) {
                preguntasExamen.stream().filter(p -> p.getChapter() == 13).forEach(p -> tema1.add(p));
            }

            if (Capitulo == null) {
                jLabelCharter.setText("All the chapters");
                preguntasExamen.stream().forEach(p -> tema1.add(p));
                jPanelResultados1.setVisible(false);

            }

            float[] resul = cargarRevision(tema1);

            if (Capitulo != null) {

                float fallos = resul[2];
                float aciertos = resul[1];
                float total = resul[0];

                double calificacion = (double) Math.round(aciertos / total * 100 * 100) / 100;
                String aprob = "% You have failed!";
                jLabelCalificacion1.setForeground(new Color(204, 0, 0));

                if (calificacion >= 68) {
                    aprob = "% You passed!";
                    jLabelCalificacion1.setForeground(new Color(0, 141, 50));
                }

                jLabelPreguntasFalladas1.setText(String.valueOf(fallos));
                jLabelPreguntasAcertadas1.setText(String.valueOf(aciertos));
                jLabelCalificacion1.setText(String.valueOf(calificacion) + aprob);
                jLabelPreguntas1.setText(String.valueOf(total));

                jLabel6.setText("Result " + Capitulo);

            }

            if (tema1.isEmpty()) {
                jPanelResultados1.setVisible(false);
            }

            jButton4.doClick();

        }

    }//GEN-LAST:event_jTree1MouseClicked

    public float[] cargarRevision(List<Question> tema) {

        
        jPanelDatos.removeAll();
        jLabelPreguntas1.setText("");
        
        for (Question quest : tema) {

            JTextArea jtextAreaRev = new JTextArea();
            JTextArea jTextAreaExp = new JTextArea();
            JLabel jLabelCharter = new JLabel();
            jLabelCharter.setFont(jtextAreaRev.getFont());

            jTextAreaExp.setBackground(new Color(255, 248, 229));
            jtextAreaRev.setAlignmentX(Component.LEFT_ALIGNMENT);
            jTextAreaExp.setAlignmentX(Component.LEFT_ALIGNMENT);
            jLabelCharter.setAlignmentX(Component.LEFT_ALIGNMENT);

            jLabelCharter.setText("Charter:" + quest.getChapter());
            jPanelDatos.add(jLabelCharter);

            List<String> Option = quest.getOptions();
            String Explicacion = quest.getExplanation();

            String TextAux = "<b>" + quest.getNumber() + "." + quest.getQuestion() + "\n" + "</b><br><br>";

            String question = quest.getNumber() + "." + quest.getQuestion() + "\n";
            String explanation = "Explanation:" + "\n" + Explicacion + "\n" + "\n";

            jtextAreaRev.setText(question);
            jTextAreaExp.setText(explanation);

//            Text = Text + TextAux;
            jtextAreaRev.setCaretPosition(0);
            jPanelDatos.add(jtextAreaRev);

            if (quest.isQuestionHasImage()) {

                JLabel labelImagen = new JLabel();
                labelImagen.setAlignmentX(Component.LEFT_ALIGNMENT);
                String nombreImagen = "Cap" + quest.getChapter() + "-Pregunta" + quest.getNumber() + ".PNG";
                System.out.println(nombreImagen);

                loadImagen(nombreImagen, labelImagen);
                jPanelDatos.add(labelImagen);

            }

            List<Integer> rightAnswers = quest.getRightAnswers();
            List<Integer> userAnswers = quest.getUserAnswers();

            List<JRadioButton> listJR = new ArrayList<JRadioButton>();


            for (int i = 0; i < Option.size(); i++) {

                String texQuest = null;

                if (i == 0) {
                    texQuest = "  A." + Option.get(i).toString();
                }
                if (i == 1) {
                    texQuest = "  B." + Option.get(i).toString();
                }
                if (i == 2) {
                    texQuest = "  C." + Option.get(i).toString();
                }
                if (i == 3) {
                    texQuest = "  D." + Option.get(i).toString();
                }
                if (i == 4) {
                    texQuest = "  E." + Option.get(i).toString();
                }
                if (i == 5) {
                    texQuest = "  F." + Option.get(i).toString();
                }
                JRadioButton jrb = new JRadioButton();
                
                jrb.setAlignmentX(Component.LEFT_ALIGNMENT);
                jrb.setBackground(Color.white);

                jrb.setText(texQuest);
                listJR.add(jrb);
                jPanelDatos.add(jrb);

            }

            for (int i : userAnswers) {

                if (i == 0) {
                    listJR.get(i).setSelected(true);
                    formatoFallo(listJR.get(i));
                }
                if (i == 1) {
                    listJR.get(i).setSelected(true);
                    formatoFallo(listJR.get(i));
                }
                if (i == 2) {
                    listJR.get(i).setSelected(true);
                    formatoFallo(listJR.get(i));
                }
                if (i == 3) {
                    listJR.get(i).setSelected(true);
                    formatoFallo(listJR.get(i));
                }
                if (i == 4) {
                    listJR.get(i).setSelected(true);
                    formatoFallo(listJR.get(i));
                }
                if (i == 5) {
                    listJR.get(i).setSelected(true);
                    formatoFallo(listJR.get(i));
                }

            };

            for (int i : rightAnswers) {

                if (i == 0) {
                    formatoAcierto(listJR.get(i));
                }
                if (i == 1) {
                    formatoAcierto(listJR.get(i));
                }
                if (i == 2) {
                    formatoAcierto(listJR.get(i));
                }
                if (i == 3) {
                    formatoAcierto(listJR.get(i));
                }
                if (i == 4) {
                    formatoAcierto(listJR.get(i));
                }
                if (i == 5) {
                    formatoAcierto(listJR.get(i));
                }

            };

            jPanelDatos.add(jTextAreaExp);

        }

        float fallos = tema.stream().filter(p -> !p.isCorrect() && p.isAnswered()).count();
        float aciertos = tema.stream().filter(p -> p.isCorrect() && p.isAnswered()).count();
        float total = tema.size();
        float[] resul = new float[3];
        resul[0] = total;
        resul[1] = aciertos;
        resul[2] = fallos;

        return resul;

    }

    public void actionPerformed(JScrollPane sp) {
        JScrollBar verticalScrollBar = sp.getVerticalScrollBar();
        JScrollBar horizontalScrollBar = sp.getHorizontalScrollBar();
        verticalScrollBar.setValue(verticalScrollBar.getMinimum());
        horizontalScrollBar.setValue(horizontalScrollBar.getMinimum());
    }


    private void jButtonSolutionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSolutionActionPerformed
        modoEstudio();

        jTextAreaExplicacion.setText(preguntasExamen.get(num).getExplanation());
        jTextAreaExplicacion.setCaretPosition(0);
        jPanelExplicacion.setVisible(true);

    }//GEN-LAST:event_jButtonSolutionActionPerformed

    private void jListCharterEvaluateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jListCharterEvaluateFocusGained

        jButtonUP1.setEnabled(true);

        jButtonADD1.setEnabled(false);
        jButtonREMOV1.setEnabled(true);
        jButtonDO1.setEnabled(true);

        jListCharter.setSelectionBackground(Color.lightGray);
        jListCharterEvaluate.setSelectionBackground(color);

    }//GEN-LAST:event_jListCharterEvaluateFocusGained

    private void jButtonADD1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonADD1ActionPerformed

        java.util.List parametros = jListCharter.getSelectedValuesList();

        int index = jListCharter.getSelectedIndex();

        for (int i = 0; i < parametros.size(); i++) {

            ((DefaultListModel<String>) jListCharterEvaluate.getModel()).addElement(parametros.get(i).toString());
            ((DefaultListModel<String>) jListCharter.getModel()).removeElement(parametros.get(i).toString());

        }

        index = index - 1;

        if (index < 0) {
            index = 0;
        }

        jListCharter.setSelectedIndex(index);


    }//GEN-LAST:event_jButtonADD1ActionPerformed

    private void jButtonREMOV1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonREMOV1ActionPerformed

        java.util.List parametros = jListCharterEvaluate.getSelectedValuesList();

        int index = jListCharterEvaluate.getSelectedIndex();

        for (int i = 0; i < parametros.size(); i++) {

            ((DefaultListModel<String>) jListCharter.getModel()).addElement(parametros.get(i).toString());
            ((DefaultListModel<String>) jListCharterEvaluate.getModel()).removeElement(parametros.get(i).toString());

        }

        index = index - 1;

        if (index < 0) {
            index = 0;
        }

        jListCharterEvaluate.setSelectedIndex(index);


    }//GEN-LAST:event_jButtonREMOV1ActionPerformed

    private void jListCharterFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jListCharterFocusGained

        jButtonADD1.setEnabled(true);
        jButtonREMOV1.setEnabled(false);

        jButtonUP1.setEnabled(false);
        jButtonDO1.setEnabled(false);

        jListCharter.setSelectionBackground(color);
        jListCharterEvaluate.setSelectionBackground(Color.lightGray);


    }//GEN-LAST:event_jListCharterFocusGained

    private void jButtonUP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUP1ActionPerformed

        try {

            int indexOfSelected = jListCharterEvaluate.getSelectedIndex();

            swapElementsA(indexOfSelected, indexOfSelected - 1);

            indexOfSelected = indexOfSelected - 1;

            jListCharterEvaluate.setSelectedIndex(indexOfSelected);
            jListCharterEvaluate.updateUI();

        } catch (IndexOutOfBoundsException e) {
        }

    }//GEN-LAST:event_jButtonUP1ActionPerformed

    private void jButtonDO1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDO1ActionPerformed

        try {

            int indexOfSelected = jListCharterEvaluate.getSelectedIndex();

            swapElementsA(indexOfSelected, indexOfSelected + 1);

            indexOfSelected = indexOfSelected + 1;

            jListCharterEvaluate.setSelectedIndex(indexOfSelected);
            jListCharterEvaluate.updateUI();

        } catch (IndexOutOfBoundsException e) {
        }

    }//GEN-LAST:event_jButtonDO1ActionPerformed

    public void cargarDialogo() {

        ((DefaultListModel<String>) jListCharterEvaluate.getModel()).addElement("Charter 1: Working with Java Data Types");
        ((DefaultListModel<String>) jListCharterEvaluate.getModel()).addElement("Chapter 2: Controlling Program Flow");
        ((DefaultListModel<String>) jListCharterEvaluate.getModel()).addElement("Chapter 3: Java Object‐Oriented Approach");
        ((DefaultListModel<String>) jListCharterEvaluate.getModel()).addElement("Chapter 4: Exception Handling");
        ((DefaultListModel<String>) jListCharterEvaluate.getModel()).addElement("Chapter 5: Working with Arrays and Collections");
        ((DefaultListModel<String>) jListCharterEvaluate.getModel()).addElement("Chapter 6: Working with Streams and Lambda Expressions");
        ((DefaultListModel<String>) jListCharterEvaluate.getModel()).addElement("Chapter 7: Java Platform Module System");
        ((DefaultListModel<String>) jListCharterEvaluate.getModel()).addElement("Chapter 8: Concurrency");
        ((DefaultListModel<String>) jListCharterEvaluate.getModel()).addElement("Chapter 9: Java I/O API");
        ((DefaultListModel<String>) jListCharterEvaluate.getModel()).addElement("Chapter 10: Secure Coding in Java SE Application");
        ((DefaultListModel<String>) jListCharterEvaluate.getModel()).addElement("Chapter 11: Database Applications with JDBC");
        ((DefaultListModel<String>) jListCharterEvaluate.getModel()).addElement("Chapter 12: Localization");
        ((DefaultListModel<String>) jListCharterEvaluate.getModel()).addElement("Chapter 13: Annotations");

        jDialogConfi.pack();
        jDialogConfi.setLocationRelativeTo(null);

    }

    public float[] estadistica(int chapter) {


        long totQuestion =  preguntas.stream().filter(p -> p.getChapter() == chapter).count();
        long hechas =  preguntas.stream().filter(p -> (p.getChapter() == chapter) && (p.isAnswered())).count();
        long sinHacer =  preguntas.stream().filter(p -> (p.getChapter() == chapter) && (!p.isAnswered())).count();
        long  aciertos =  preguntas.stream().filter(p -> (p.getChapter() == chapter) && (p.isAnswered()) && (p.isCorrect())).count();
        long  fallos =  preguntas.stream().filter(p -> (p.getChapter() == chapter) && (p.isAnswered()) && (!p.isCorrect())).count();

        float calificacion;
        if(hechas != 0){
            
           calificacion = aciertos/((float)hechas)*100;
           calificacion = (float)Math.round(calificacion*100)/100;
                
        }
        else{
            calificacion = 0;
        }

        float[] resul = new float[6];
        resul[0] = totQuestion;
        resul[1] = hechas;
        resul[2] = sinHacer;
        resul[3] = aciertos;
        resul[4] = fallos;
        
        
        
        resul[5] = (float) calificacion;

        return resul;

    }


    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jDialogConfi.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jDialogConfi.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        ArrayList listResult = new ArrayList();

        for (int i = 1; i <= 15; i++) {
            float[] resul = estadistica(i);
            listResult.add(resul);

        }
//float[] resul =(float[]) listResult.get(0);
        int i = 0;

        float tot = 0;
        float hechas = 0;
        float sinHacer = 0;
        float aciertos = 0;
        float fallos = 0;

        for (Object resul : listResult) {

            float[] resul1 = (float[]) resul;
            i++;
            if (i == 1) {
                jLabel1_1.setText(String.valueOf((int)resul1[0])); // total pregungas
                jLabel1_2.setText(String.valueOf((int)resul1[1])); // hechas
                jLabel1_3.setText(String.valueOf((int)resul1[2])); // sin hacer
                jLabel1_4.setText(String.valueOf((int)resul1[3])); // aciertos
                jLabel1_5.setText(String.valueOf((int)resul1[4])); // fallos
                jLabel1_6.setText(String.valueOf(resul1[5]) + "%"); // calificacion
                
                jProgressBar1.setStringPainted(true);
                jProgressBar1.setMinimum(0);
                jProgressBar1.setMaximum((int) resul1[0]);
                jProgressBar1.setValue((int) resul1[1]);
                
                jLabel1_6.setForeground(new Color(0,141,50));
                if(resul1[5]<68){
                jLabel1_6.setForeground(new Color(204,0,0));
                }
                

                tot = tot + resul1[0];
                hechas = hechas + resul1[1];
                sinHacer = sinHacer + resul1[2];
                aciertos = aciertos + resul1[3];
                fallos = fallos + resul1[4];

            }

            if (i == 2) {
                jLabel2_1.setText(String.valueOf((int)resul1[0])); // total pregungas
                jLabel2_2.setText(String.valueOf((int)resul1[1])); // hechas
                jLabel2_3.setText(String.valueOf((int)resul1[2])); // sin hacer
                jLabel2_4.setText(String.valueOf((int)resul1[3])); // aciertos
                jLabel2_5.setText(String.valueOf((int)resul1[4])); // fallos
                jLabel2_6.setText(String.valueOf(resul1[5]) + "%"); // calificacion

                jLabel2_6.setForeground(new Color(0, 141, 50));
                if (resul1[5] < 68) {
                    jLabel2_6.setForeground(new Color(204, 0, 0));
                }
                
                jProgressBar2.setStringPainted(true);
                jProgressBar2.setMinimum(0);
                jProgressBar2.setMaximum((int) resul1[0]);
                jProgressBar2.setValue((int) resul1[1]);

                tot = tot + resul1[0];
                hechas = hechas + resul1[1];
                sinHacer = sinHacer + resul1[2];
                aciertos = aciertos + resul1[3];
                fallos = fallos + resul1[4];

            }

            if (i == 3) {
                jLabel3_1.setText(String.valueOf((int)resul1[0])); // total pregungas
                jLabel3_2.setText(String.valueOf((int)resul1[1])); // hechas
                jLabel3_3.setText(String.valueOf((int)resul1[2])); // sin hacer
                jLabel3_4.setText(String.valueOf((int)resul1[3])); // aciertos
                jLabel3_5.setText(String.valueOf((int)resul1[4])); // fallos
                jLabel3_6.setText(String.valueOf(resul1[5]) + "%"); // calificacion

                jLabel3_6.setForeground(new Color(0, 141, 50));
                if (resul1[5] < 68) {
                    jLabel3_6.setForeground(new Color(204, 0, 0));
                }
                
                
                jProgressBar3.setStringPainted(true);
                jProgressBar3.setMinimum(0);
                jProgressBar3.setMaximum((int) resul1[0]);
                jProgressBar3.setValue((int) resul1[1]);

                tot = tot + resul1[0];
                hechas = hechas + resul1[1];
                sinHacer = sinHacer + resul1[2];
                aciertos = aciertos + resul1[3];
                fallos = fallos + resul1[4];

            }

            if (i == 4) {
                jLabel4_1.setText(String.valueOf((int)resul1[0])); // total pregungas
                jLabel4_2.setText(String.valueOf((int)resul1[1])); // hechas
                jLabel4_3.setText(String.valueOf((int)resul1[2])); // sin hacer
                jLabel4_4.setText(String.valueOf((int)resul1[3])); // aciertos
                jLabel4_5.setText(String.valueOf((int)resul1[4])); // fallos
                jLabel4_6.setText(String.valueOf(resul1[5]) + "%"); // calificacion

                jLabel4_6.setForeground(new Color(0, 141, 50));
                if (resul1[5] < 68) {
                    jLabel4_6.setForeground(new Color(204, 0, 0));
                }                
                
                
                
                jProgressBar4.setStringPainted(true);
                jProgressBar4.setMinimum(0);
                jProgressBar4.setMaximum((int) resul1[0]);
                jProgressBar4.setValue((int) resul1[1]);

                tot = tot + resul1[0];
                hechas = hechas + resul1[1];
                sinHacer = sinHacer + resul1[2];
                aciertos = aciertos + resul1[3];
                fallos = fallos + resul1[4];

            }

            if (i == 5) {
                jLabel5_1.setText(String.valueOf((int)resul1[0])); // total pregungas
                jLabel5_2.setText(String.valueOf((int)resul1[1])); // hechas
                jLabel5_3.setText(String.valueOf((int)resul1[2])); // sin hacer
                jLabel5_4.setText(String.valueOf((int)resul1[3])); // aciertos
                jLabel5_5.setText(String.valueOf((int)resul1[4])); // fallos
                jLabel5_6.setText(String.valueOf(resul1[5]) + "%"); // calificacion

                
                jLabel5_6.setForeground(new Color(0, 141, 50));
                if (resul1[5] < 68) {
                    jLabel5_6.setForeground(new Color(204, 0, 0));
                }
                
                
                jProgressBar5.setStringPainted(true);
                jProgressBar5.setMinimum(0);
                jProgressBar5.setMaximum((int) resul1[0]);
                jProgressBar5.setValue((int) resul1[1]);

                tot = tot + resul1[0];
                hechas = hechas + resul1[1];
                sinHacer = sinHacer + resul1[2];
                aciertos = aciertos + resul1[3];
                fallos = fallos + resul1[4];

            }

            if (i == 6) {
                jLabel6_1.setText(String.valueOf((int)resul1[0])); // total pregungas
                jLabel6_2.setText(String.valueOf((int)resul1[1])); // hechas
                jLabel6_3.setText(String.valueOf((int)resul1[2])); // sin hacer
                jLabel6_4.setText(String.valueOf((int)resul1[3])); // aciertos
                jLabel6_5.setText(String.valueOf((int)resul1[4])); // fallos
                jLabel6_6.setText(String.valueOf(resul1[5]) + "%"); // calificacion

                
                jLabel6_6.setForeground(new Color(0, 141, 50));
                if (resul1[5] < 68) {
                    jLabel6_6.setForeground(new Color(204, 0, 0));
                }
                
                
                
                jProgressBar6.setStringPainted(true);
                jProgressBar6.setMinimum(0);
                jProgressBar6.setMaximum((int) resul1[0]);
                jProgressBar6.setValue((int) resul1[1]);

                tot = tot + resul1[0];
                hechas = hechas + resul1[1];
                sinHacer = sinHacer + resul1[2];
                aciertos = aciertos + resul1[3];
                fallos = fallos + resul1[4];

            }

            if (i == 7) {
                jLabel7_1.setText(String.valueOf((int)resul1[0])); // total pregungas
                jLabel7_2.setText(String.valueOf((int)resul1[1])); // hechas
                jLabel7_3.setText(String.valueOf((int)resul1[2])); // sin hacer
                jLabel7_4.setText(String.valueOf((int)resul1[3])); // aciertos
                jLabel7_5.setText(String.valueOf((int)resul1[4])); // fallos
                jLabel7_6.setText(String.valueOf(resul1[5]) + "%"); // calificacion

                jLabel7_6.setForeground(new Color(0, 141, 50));
                if (resul1[5] < 68) {
                    jLabel7_6.setForeground(new Color(204, 0, 0));
                }                
                
                
                
                
                jProgressBar7.setStringPainted(true);
                jProgressBar7.setMinimum(0);
                jProgressBar7.setMaximum((int) resul1[0]);
                jProgressBar7.setValue((int) resul1[1]);

                tot = tot + resul1[0];
                hechas = hechas + resul1[1];
                sinHacer = sinHacer + resul1[2];
                aciertos = aciertos + resul1[3];
                fallos = fallos + resul1[4];

            }

            if (i == 8) {
                jLabel8_1.setText(String.valueOf((int)resul1[0])); // total pregungas
                jLabel8_2.setText(String.valueOf((int)resul1[1])); // hechas
                jLabel8_3.setText(String.valueOf((int)resul1[2])); // sin hacer
                jLabel8_4.setText(String.valueOf((int)resul1[3])); // aciertos
                jLabel8_5.setText(String.valueOf((int)resul1[4])); // fallos
                jLabel8_6.setText(String.valueOf(resul1[5]) + "%"); // calificacion

                jProgressBar8.setStringPainted(true);
                jProgressBar8.setMinimum(0);
                jProgressBar8.setMaximum((int) resul1[0]);
                jProgressBar8.setValue((int) resul1[1]);

                jLabel8_6.setForeground(new Color(0, 141, 50));
                if (resul1[5] < 68) {
                    jLabel8_6.setForeground(new Color(204, 0, 0));
                }
                
                
                tot = tot + resul1[0];
                hechas = hechas + resul1[1];
                sinHacer = sinHacer + resul1[2];
                aciertos = aciertos + resul1[3];
                fallos = fallos + resul1[4];

            }

            if (i == 9) {
                jLabel9_1.setText(String.valueOf((int)resul1[0])); // total pregungas
                jLabel9_2.setText(String.valueOf((int)resul1[1])); // hechas
                jLabel9_3.setText(String.valueOf((int)resul1[2])); // sin hacer
                jLabel9_4.setText(String.valueOf((int)resul1[3])); // aciertos
                jLabel9_5.setText(String.valueOf((int)resul1[4])); // fallos
                jLabel9_6.setText(String.valueOf(resul1[5]) + "%"); // calificacion


                jLabel9_6.setForeground(new Color(0, 141, 50));
                if (resul1[5] < 68) {
                    jLabel9_6.setForeground(new Color(204, 0, 0));
                }

                jProgressBar9.setStringPainted(true);
                jProgressBar9.setMinimum(0);
                jProgressBar9.setMaximum((int) resul1[0]);
                jProgressBar9.setValue((int) resul1[1]);

                tot = tot + resul1[0];
                hechas = hechas + resul1[1];
                sinHacer = sinHacer + resul1[2];
                aciertos = aciertos + resul1[3];
                fallos = fallos + resul1[4];

            }

            if (i == 10) {
                jLabel10_1.setText(String.valueOf((int)resul1[0])); // total pregungas
                jLabel10_2.setText(String.valueOf((int)resul1[1])); // hechas
                jLabel10_3.setText(String.valueOf((int)resul1[2])); // sin hacer
                jLabel10_4.setText(String.valueOf((int)resul1[3])); // aciertos
                jLabel10_5.setText(String.valueOf((int)resul1[4])); // fallos
                jLabel10_6.setText(String.valueOf(resul1[5]) + "%"); // calificacion

                
                jLabel10_6.setForeground(new Color(0, 141, 50));
                if (resul1[5] < 68) {
                    jLabel10_6.setForeground(new Color(204, 0, 0));
                }
                
                
                jProgressBar10.setStringPainted(true);
                jProgressBar10.setMinimum(0);
                jProgressBar10.setMaximum((int) resul1[0]);
                jProgressBar10.setValue((int) resul1[1]);

                tot = tot + resul1[0];
                hechas = hechas + resul1[1];
                sinHacer = sinHacer + resul1[2];
                aciertos = aciertos + resul1[3];
                fallos = fallos + resul1[4];

            }

            if (i == 11) {
                jLabel11_1.setText(String.valueOf((int)resul1[0])); // total pregungas
                jLabel11_2.setText(String.valueOf((int)resul1[1])); // hechas
                jLabel11_3.setText(String.valueOf((int)resul1[2])); // sin hacer
                jLabel11_4.setText(String.valueOf((int)resul1[3])); // aciertos
                jLabel11_5.setText(String.valueOf((int)resul1[4])); // fallos
                jLabel11_6.setText(String.valueOf(resul1[5]) + "%"); // calificacion

                jProgressBar11.setStringPainted(true);
                jProgressBar11.setMinimum(0);
                jProgressBar11.setMaximum((int) resul1[0]);
                jProgressBar11.setValue((int) resul1[1]);

                jLabel11_6.setForeground(new Color(0, 141, 50));
                if (resul1[5] < 68) {
                    jLabel11_6.setForeground(new Color(204, 0, 0));
                }                
                
                
                tot = tot + resul1[0];
                hechas = hechas + resul1[1];
                sinHacer = sinHacer + resul1[2];
                aciertos = aciertos + resul1[3];
                fallos = fallos + resul1[4];

            }

            if (i == 12) {
                jLabel12_1.setText(String.valueOf((int)resul1[0])); // total pregungas
                jLabel12_2.setText(String.valueOf((int)resul1[1])); // hechas
                jLabel12_3.setText(String.valueOf((int)resul1[2])); // sin hacer
                jLabel12_4.setText(String.valueOf((int)resul1[3])); // aciertos
                jLabel12_5.setText(String.valueOf((int)resul1[4])); // fallos
                jLabel12_6.setText(String.valueOf(resul1[5]) + "%"); // calificacion

                jLabel12_6.setForeground(new Color(0, 141, 50));
                if (resul1[5] < 68) {
                    jLabel12_6.setForeground(new Color(204, 0, 0));
                } 


                jProgressBar12.setStringPainted(true);
                jProgressBar12.setMinimum(0);
                jProgressBar12.setMaximum((int) resul1[0]);
                jProgressBar12.setValue((int) resul1[1]);

                tot = tot + resul1[0];
                hechas = hechas + resul1[1];
                sinHacer = sinHacer + resul1[2];
                aciertos = aciertos + resul1[3];
                fallos = fallos + resul1[4];

            }

            if (i == 13) {
                jLabel13_1.setText(String.valueOf((int)resul1[0])); // total pregungas
                jLabel13_2.setText(String.valueOf((int)resul1[1])); // hechas
                jLabel13_3.setText(String.valueOf((int)resul1[2])); // sin hacer
                jLabel13_4.setText(String.valueOf((int)resul1[3])); // aciertos
                jLabel13_5.setText(String.valueOf((int)resul1[4])); // fallos
                jLabel13_6.setText(String.valueOf(resul1[5]) + "%"); // calificacion

                jLabel13_6.setForeground(new Color(0, 141, 50));
                if (resul1[5] < 68) {
                    jLabel13_6.setForeground(new Color(204, 0, 0));
                }


                jProgressBar13.setStringPainted(true);
                jProgressBar13.setMinimum(0);
                jProgressBar13.setMaximum((int) resul1[0]);
                jProgressBar13.setValue((int) resul1[1]);

                tot = tot + resul1[0];
                hechas = hechas + resul1[1];
                sinHacer = sinHacer + resul1[2];
                aciertos = aciertos + resul1[3];
                fallos = fallos + resul1[4];

            }

        }

        jLabel15_1.setText(String.valueOf((int)tot)); // total pregungas
        jLabel15_2.setText(String.valueOf((int)hechas)); // hechas
        jLabel15_3.setText(String.valueOf((int)sinHacer)); // sin hacer
        jLabel15_4.setText(String.valueOf((int)aciertos)); // aciertos
        jLabel15_5.setText(String.valueOf((int)fallos)); // fallos

        double calificacion = (double) Math.round(aciertos / hechas * 100 * 100) / 100;

        jLabel15_6.setText(String.valueOf(calificacion) + "%"); // calificacion
        
                        jLabel15_6.setForeground(new Color(0, 141, 50));
                if (calificacion < 68) {
                    jLabel15_6.setForeground(new Color(204, 0, 0));
                }
        
        
        

        jProgressBar15.setStringPainted(true);
        jProgressBar15.setMinimum(0);
        jProgressBar15.setMaximum((int) tot);
        jProgressBar15.setValue((int) hechas);

        jDialogEstadistica.setVisible(true);


    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        if (jComboBoxHistorial.getSelectedIndex() != 0) {

            String key = jComboBoxHistorial.getSelectedItem().toString();

            int p = JOptionPane.showOptionDialog(null, "¿Confirma que borrar el examen: " + key + "?",
                    "Borrar examen", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.WARNING_MESSAGE, null,// null para icono por defecto.
                    new Object[]{"SI", "NO"}, "SI");

            if (p == 0) {

                historialExam.remove(key);
                jComboBoxHistorial.removeItem(key.toString());
                HitorialExam.save();

            }

        }


    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jRadioButtonOpcionBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonOpcionBActionPerformed
    
   List<Integer> rightAnswers = preguntasExamen.get(num).getRightAnswers();
            int usw=0;
            if (jRadioButtonOpcionA.isSelected()){usw++;}
             if (jRadioButtonOpcionB.isSelected()){usw++;}
              if (jRadioButtonOpcionC.isSelected()){usw++;}
               if (jRadioButtonOpcionD.isSelected()){usw++;}
                if (jRadioButtonOpcionE.isSelected()){usw++;}
                 if (jRadioButtonOpcionF.isSelected()){usw++;}
    
        if(rightAnswers.size()==usw){
        evaluarPreguntaRev();
        } else{      
        preguntasExamen.get(num).setAnswered(false);       
                 
        }     
        
        
        
        
    }//GEN-LAST:event_jRadioButtonOpcionBActionPerformed

    private void jRadioButtonOpcionCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonOpcionCActionPerformed
     
        jRadioButtonOpcionC.setFont(new Font("SansSerif", Font.PLAIN, 14));
        if (jRadioButtonOpcionC.isSelected()) {
            jRadioButtonOpcionC.setFont(new Font("SansSerif", Font.BOLD, 14));
        }
        
        List<Integer> rightAnswers = preguntasExamen.get(num).getRightAnswers();
            int usw=0;
            if (jRadioButtonOpcionA.isSelected()){usw++;}
             if (jRadioButtonOpcionB.isSelected()){usw++;}
              if (jRadioButtonOpcionC.isSelected()){usw++;}
               if (jRadioButtonOpcionD.isSelected()){usw++;}
                if (jRadioButtonOpcionE.isSelected()){usw++;}
                 if (jRadioButtonOpcionF.isSelected()){usw++;}
    
        if(rightAnswers.size()==usw){
        evaluarPreguntaRev();
        } else{      
        preguntasExamen.get(num).setAnswered(false);       
                 
        }
        
        
    }//GEN-LAST:event_jRadioButtonOpcionCActionPerformed

    private void jRadioButtonOpcionEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonOpcionEActionPerformed
       
        List<Integer> rightAnswers = preguntasExamen.get(num).getRightAnswers();
            int usw=0;
            if (jRadioButtonOpcionA.isSelected()){usw++;}
             if (jRadioButtonOpcionB.isSelected()){usw++;}
              if (jRadioButtonOpcionC.isSelected()){usw++;}
               if (jRadioButtonOpcionD.isSelected()){usw++;}
                if (jRadioButtonOpcionE.isSelected()){usw++;}
                 if (jRadioButtonOpcionF.isSelected()){usw++;}
    
        if(rightAnswers.size()==usw){
        evaluarPreguntaRev();
        } else{      
        preguntasExamen.get(num).setAnswered(false);       
                 
        }
        
        
    }//GEN-LAST:event_jRadioButtonOpcionEActionPerformed

    private void jRadioButtonOpcionFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonOpcionFActionPerformed
     
        List<Integer> rightAnswers = preguntasExamen.get(num).getRightAnswers();
            int usw=0;
            if (jRadioButtonOpcionA.isSelected()){usw++;}
             if (jRadioButtonOpcionB.isSelected()){usw++;}
              if (jRadioButtonOpcionC.isSelected()){usw++;}
               if (jRadioButtonOpcionD.isSelected()){usw++;}
                if (jRadioButtonOpcionE.isSelected()){usw++;}
                 if (jRadioButtonOpcionF.isSelected()){usw++;}
    
        if(rightAnswers.size()==usw){
        evaluarPreguntaRev();
        } else{      
        preguntasExamen.get(num).setAnswered(false);       
                 
        }
        
    }//GEN-LAST:event_jRadioButtonOpcionFActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       
        
        System.out.println("Charter:"+preguntasExamen.get(num).getChapter());
        System.out.println("Question:"+preguntasExamen.get(num).getNumber());
        
        System.out.println("Fue respondida:"+preguntasExamen.get(num).isAnswered());
        System.out.println("Es correcta:"+preguntasExamen.get(num).isCorrect());
        System.out.println("RightAswered:"+preguntasExamen.get(num).getRightAnswers());
        System.out.println("UserAswered:"+preguntasExamen.get(num).getUserAnswers());
        
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        
        comboEstadist();
        
    }//GEN-LAST:event_jButton8ActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(VentanaTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(VentanaTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(VentanaTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(VentanaTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new VentanaTest().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButtonADD1;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonDO1;
    private javax.swing.JButton jButtonEvalExamen;
    private javax.swing.JButton jButtonEvalExamen1;
    private javax.swing.JButton jButtonEvalPregunta;
    private javax.swing.JButton jButtonExamenErrores;
    private javax.swing.JButton jButtonHacerExamen;
    private javax.swing.JButton jButtonNext;
    private javax.swing.JButton jButtonREMOV1;
    private javax.swing.JButton jButtonReinicio;
    private javax.swing.JButton jButtonRevision;
    private javax.swing.JButton jButtonSolution;
    private javax.swing.JButton jButtonUP1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBoxHistorial;
    private javax.swing.JDialog jDialogConfi;
    private javax.swing.JDialog jDialogEstadistica;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel10_1;
    private javax.swing.JLabel jLabel10_2;
    private javax.swing.JLabel jLabel10_3;
    private javax.swing.JLabel jLabel10_4;
    private javax.swing.JLabel jLabel10_5;
    private javax.swing.JLabel jLabel10_6;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel11_1;
    private javax.swing.JLabel jLabel11_2;
    private javax.swing.JLabel jLabel11_3;
    private javax.swing.JLabel jLabel11_4;
    private javax.swing.JLabel jLabel11_5;
    private javax.swing.JLabel jLabel11_6;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel12_1;
    private javax.swing.JLabel jLabel12_2;
    private javax.swing.JLabel jLabel12_3;
    private javax.swing.JLabel jLabel12_4;
    private javax.swing.JLabel jLabel12_5;
    private javax.swing.JLabel jLabel12_6;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel13_1;
    private javax.swing.JLabel jLabel13_2;
    private javax.swing.JLabel jLabel13_3;
    private javax.swing.JLabel jLabel13_4;
    private javax.swing.JLabel jLabel13_5;
    private javax.swing.JLabel jLabel13_6;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel15_1;
    private javax.swing.JLabel jLabel15_2;
    private javax.swing.JLabel jLabel15_3;
    private javax.swing.JLabel jLabel15_4;
    private javax.swing.JLabel jLabel15_5;
    private javax.swing.JLabel jLabel15_6;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel1_1;
    private javax.swing.JLabel jLabel1_2;
    private javax.swing.JLabel jLabel1_3;
    private javax.swing.JLabel jLabel1_4;
    private javax.swing.JLabel jLabel1_5;
    private javax.swing.JLabel jLabel1_6;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel2_1;
    private javax.swing.JLabel jLabel2_2;
    private javax.swing.JLabel jLabel2_3;
    private javax.swing.JLabel jLabel2_4;
    private javax.swing.JLabel jLabel2_5;
    private javax.swing.JLabel jLabel2_6;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel3_1;
    private javax.swing.JLabel jLabel3_2;
    private javax.swing.JLabel jLabel3_3;
    private javax.swing.JLabel jLabel3_4;
    private javax.swing.JLabel jLabel3_5;
    private javax.swing.JLabel jLabel3_6;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel4_1;
    private javax.swing.JLabel jLabel4_2;
    private javax.swing.JLabel jLabel4_3;
    private javax.swing.JLabel jLabel4_4;
    private javax.swing.JLabel jLabel4_5;
    private javax.swing.JLabel jLabel4_6;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel5_1;
    private javax.swing.JLabel jLabel5_2;
    private javax.swing.JLabel jLabel5_3;
    private javax.swing.JLabel jLabel5_4;
    private javax.swing.JLabel jLabel5_5;
    private javax.swing.JLabel jLabel5_6;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel6_1;
    private javax.swing.JLabel jLabel6_2;
    private javax.swing.JLabel jLabel6_3;
    private javax.swing.JLabel jLabel6_4;
    private javax.swing.JLabel jLabel6_5;
    private javax.swing.JLabel jLabel6_6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel7_1;
    private javax.swing.JLabel jLabel7_2;
    private javax.swing.JLabel jLabel7_3;
    private javax.swing.JLabel jLabel7_4;
    private javax.swing.JLabel jLabel7_5;
    private javax.swing.JLabel jLabel7_6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel8_1;
    private javax.swing.JLabel jLabel8_2;
    private javax.swing.JLabel jLabel8_3;
    private javax.swing.JLabel jLabel8_4;
    private javax.swing.JLabel jLabel8_5;
    private javax.swing.JLabel jLabel8_6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel9_1;
    private javax.swing.JLabel jLabel9_2;
    private javax.swing.JLabel jLabel9_3;
    private javax.swing.JLabel jLabel9_4;
    private javax.swing.JLabel jLabel9_5;
    private javax.swing.JLabel jLabel9_6;
    private javax.swing.JLabel jLabelAciertos;
    private javax.swing.JLabel jLabelCalificacion;
    private javax.swing.JLabel jLabelCalificacion1;
    private javax.swing.JLabel jLabelCharter;
    public javax.swing.JLabel jLabelClock;
    private javax.swing.JLabel jLabelFallos;
    private javax.swing.JLabel jLabelImagen;
    private javax.swing.JLabel jLabelNumberOfQuestion;
    private javax.swing.JLabel jLabelPreguntas;
    private javax.swing.JLabel jLabelPreguntas1;
    private javax.swing.JLabel jLabelPreguntasAcertadas;
    private javax.swing.JLabel jLabelPreguntasAcertadas1;
    private javax.swing.JLabel jLabelPreguntasFalladas;
    private javax.swing.JLabel jLabelPreguntasFalladas1;
    private javax.swing.JLabel jLabelTotP1;
    private javax.swing.JLabel jLabelTotP2;
    private javax.swing.JLabel jLabelTotP3;
    private javax.swing.JLabel jLabelTotP4;
    private javax.swing.JLabel jLabelTotP5;
    private javax.swing.JList<String> jListCharter;
    private javax.swing.JList<String> jListCharterEvaluate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelAlterno;
    private javax.swing.JPanel jPanelControles;
    private javax.swing.JPanel jPanelDatos;
    private javax.swing.JPanel jPanelExamen;
    private javax.swing.JPanel jPanelExplicacion;
    private javax.swing.JPanel jPanelInterfaz;
    private javax.swing.JPanel jPanelOpciones;
    private javax.swing.JPanel jPanelPregunta;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JPanel jPanelResultados;
    private javax.swing.JPanel jPanelResultados1;
    private javax.swing.JPanel jPanelRevision1;
    private javax.swing.JPanel jPanelRevisiones;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar10;
    private javax.swing.JProgressBar jProgressBar11;
    private javax.swing.JProgressBar jProgressBar12;
    private javax.swing.JProgressBar jProgressBar13;
    private javax.swing.JProgressBar jProgressBar15;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JProgressBar jProgressBar3;
    private javax.swing.JProgressBar jProgressBar4;
    private javax.swing.JProgressBar jProgressBar5;
    private javax.swing.JProgressBar jProgressBar6;
    private javax.swing.JProgressBar jProgressBar7;
    private javax.swing.JProgressBar jProgressBar8;
    private javax.swing.JProgressBar jProgressBar9;
    private javax.swing.JRadioButton jRadioButtonOpcionA;
    private javax.swing.JRadioButton jRadioButtonOpcionB;
    private javax.swing.JRadioButton jRadioButtonOpcionC;
    private javax.swing.JRadioButton jRadioButtonOpcionD;
    private javax.swing.JRadioButton jRadioButtonOpcionE;
    private javax.swing.JRadioButton jRadioButtonOpcionF;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPaneDatos;
    private javax.swing.JSpinner jSpinnerCantQuestion;
    private javax.swing.JSpinner jSpinnerTiempo;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextAreaExplicacion;
    private javax.swing.JTextArea jTextAreaQuestion;
    private javax.swing.JTextArea jTextAreaQuestionImagen;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables

}
