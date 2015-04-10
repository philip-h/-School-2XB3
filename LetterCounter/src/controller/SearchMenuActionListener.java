package controller;

import view.SearchMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by philip on 10/04/15.
 */
public class SearchMenuActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent evt) {
        String e = evt.getActionCommand();

        if (e.equals("InputSubmit")) {
            //Error catching for the input field
            if (SearchMenu.getInput().length() > 2) {
                JOptionPane.showMessageDialog(null, "Please enter no more than 2 letters", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (SearchMenu.getInput().equals("") || SearchMenu.getInput().equals(" ")) {
                JOptionPane.showMessageDialog(null, "Please do not leave text area blank", "Error", JOptionPane.ERROR_MESSAGE);
            //NO errors, proceed with search
            } else {

            }
        }
    }
}
