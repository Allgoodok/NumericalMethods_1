import javax.swing.*;
import java.awt.*;

/**
 * Created by vlad on 09.10.15.
 */
public class VIew extends JFrame {

    JTable jTable1;
    JTable jTable2;

    Test test = new Test();

    String[] column_headers_1 =  {"eps", "n", "Absolute Error", "Remaining Term"};
    String[] column_headers_2 = {"Xi", "Absolute Error", "Remaining Term"};

    VIew(){
        Test test = new Test();
        jTable1 = new JTable(test.dataFirstTable(), column_headers_1);
        jTable2 = new JTable(test.dataSecondTable(), column_headers_2);
        jTable1.setBounds(50,50,200,200);
        jTable2.setBounds(300,200,200,200);
        JScrollPane jScrollPane1 = new JScrollPane(jTable1);
        JScrollPane jScrollPane2 = new JScrollPane(jTable2);
        this.add(jScrollPane1, BorderLayout.CENTER);
        this.add(jScrollPane2, BorderLayout.SOUTH);
        this.validate();
        this.setSize(300, 600);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new VIew();

    }
}
