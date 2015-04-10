package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by philip on 10/04/15.
 */
public class SearchMenu extends JFrame {
    private JPanel contentPane;

    private JLabel titleLabel;
    private static JTextField searchField;
    private JButton submit;

    private JLabel occurrence;

    private Font aFont = new Font("TimesRoman",Font.PLAIN,35);
    private Font bFont = new Font("TimesRoman",Font.PLAIN,15);

    public SearchMenu() {
        initFrame();
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       // setResizable(false);
        setVisible(true);
    }

    private void initFrame() {
        //Label for the window
        JPanel labelPanel = new JPanel(new FlowLayout());
        titleLabel = new JLabel("Enter the letter(s) you want to search for (1 or 2)");
        titleLabel.setFont(bFont);
        labelPanel.add(titleLabel);

        //The input text field for the search menu
        JPanel textFieldPanel = new JPanel(new FlowLayout());
        searchField = new JTextField(5);
        searchField.setFont(aFont);
        searchField.setHorizontalAlignment(0);
        textFieldPanel.add(searchField);

        //The submit button for the search menu
        JPanel submitPanel = new JPanel(new FlowLayout());
        submit = new JButton("Submit");
        //submit.addActionListener(new SearchMenuActionListener());
        submit.setActionCommand("InputSubmit");
        submit.setFont(bFont);
        submitPanel.add(submit);

        occurrence = new JLabel("e occurred 2354 times");
        occurrence.setFont(bFont);
        occurrence.setHorizontalAlignment(0);

        contentPane = new JPanel(new GridLayout(4,1));
        contentPane.add(labelPanel);
        contentPane.add(textFieldPanel);
        contentPane.add(submitPanel);
        contentPane.add(occurrence);

        setContentPane(contentPane);
    }

    public static String getInput() {
        return searchField.getText();
    }
}
