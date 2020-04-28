package Snake.LeaderBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class LeaderBoardManager extends JFrame {
    LeaderBoardAdaptor leaderBoardAdaptor;
    public LeaderBoardManager(LeaderBoardAdaptor leaderBoardAdaptor){
        this.leaderBoardAdaptor = leaderBoardAdaptor;
        setTitle("Snake Game Leaderboard");
        setSize(400, 250);
        setVisible(true);
    }

    public void showLeaderboard(){
        getContentPane().removeAll();
        getContentPane().setLayout(new BorderLayout());
        JTable jTable = new JTable(leaderBoardAdaptor.getData(), new String[]{"First", "Last", "Age", "Score"});
        jTable.setEnabled(false);
        getContentPane().add(jTable.getTableHeader(), BorderLayout.PAGE_START);
        getContentPane().add(jTable);
        SwingUtilities.updateComponentTreeUI(getContentPane());
    }

    public void addToLeaderboard(int Score){
        getContentPane().setLayout(new GridLayout(5,1,0,0));


        JTextField firstNameTxt = new HintTextField("First Name", 12);
        JTextField lastNameTxt = new HintTextField("Last Name", 12);
        JTextField ageTxt = new HintTextField("Age", 3);
        JLabel scoreDis = new JLabel("Your Score: " + String.valueOf(Score));


        JButton addBtn = new JButton("ADD");
        getContentPane().add(firstNameTxt);
        getContentPane().add(lastNameTxt);
        getContentPane().add(ageTxt);
        getContentPane().add(scoreDis);
        getContentPane().add(addBtn);

        SwingUtilities.updateComponentTreeUI(getContentPane());

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                leaderBoardAdaptor.addMember(new Member(firstNameTxt.getText(), lastNameTxt.getText(), ageTxt.getText(), Score));
                showLeaderboard();
            }
        });
    }
}

class HintTextField extends JTextField implements FocusListener {

    private final String hint;
    private boolean showingHint;

    public HintTextField(final String hint, int cols) {
        super(hint, cols);
        this.hint = hint;
        this.showingHint = true;
        super.addFocusListener(this);
    }

    @Override
    public void focusGained(FocusEvent e) {
        if(this.getText().isEmpty()) {
            super.setText("");
            showingHint = false;
        }
    }
    @Override
    public void focusLost(FocusEvent e) {
        if(this.getText().isEmpty()) {
            super.setText(hint);
            showingHint = true;
        }
    }

    @Override
    public String getText() {
        return showingHint ? "" : super.getText();
    }
}
