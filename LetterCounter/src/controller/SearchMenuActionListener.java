package controller;

import datastructs.BinarySearch;
import datastructs.Node;
import datastructs.Trie;
import view.MainMenu;
import view.SearchMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by philip on 10/04/15.
 */
public class SearchMenuActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent evt) {
        String e = evt.getActionCommand();

        if (e.equals("InputSubmit")) {
            String input = SearchMenu.getInput();
            //Error catching for the input field
            if (input.length() > 2) {
                JOptionPane.showMessageDialog(null, "Please enter no more than 2 letters", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (input.equals("") || input.equals(" ")) {
                JOptionPane.showMessageDialog(null, "Please do not leave text area blank", "Error", JOptionPane.ERROR_MESSAGE);
            //NO errors, proceed with search
            } else {
                Trie trie = Trie.toTrie(MainMenu.getInputTextArea());
                ArrayList<Node> nodes = trie.nodes();

                Node[] nodes1 = nodes.toArray(new Node[nodes.size()]);
                if (!BinarySearch.contains(SearchMenu.getInput(),nodes1))
                    SearchMenu.setLabel(SearchMenu.getInput() + " is not present in the text");
                else {
                    Node n = BinarySearch.search(SearchMenu.getInput(),nodes1);
                    String label = n.getKey() + " has occurred " + n.getValue() + (n.getValue()==1?" time!":" times!");
                    SearchMenu.setLabel(label);
                }
            }
        }
    }
}
