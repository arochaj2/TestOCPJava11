/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

/**
 *
 * @author Dell
 */
class JScrollPaneToTopAction implements ActionListener {
  JScrollPane scrollPane;
  public JScrollPaneToTopAction(JScrollPane scrollPane) {
    if (scrollPane == null) {
      throw new IllegalArgumentException(
        "JScrollPaneToTopAction: null JScrollPane");
    }
    this.scrollPane = scrollPane;
  }
  public void actionPerformed(ActionEvent actionEvent) {
    JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
    JScrollBar horizontalScrollBar = scrollPane.getHorizontalScrollBar();
    verticalScrollBar.setValue(verticalScrollBar.getMinimum());
    horizontalScrollBar.setValue(horizontalScrollBar.getMinimum());
  }
}
