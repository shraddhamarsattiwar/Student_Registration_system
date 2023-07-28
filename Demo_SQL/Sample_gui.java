package Demo_SQL;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Sample_gui implements ActionListener {
    JFrame jFrame;
    JLabel jLabelname;
    JLabel jLabelname2;
    JLabel jLabelname3;
    JLabel jLabelname4;
    JTextField jTextFieldName;
    JTextField jTextFieldname2;
    JTextField jTextFieldname3;
    JTextField jTxetFieldname4;
    JButton jButtonname;
    JButton jButtonname2;
    JButton jButtonname3;
    JButton jButtonname4;
    JButton jButtonname5;
    JButton jButtonname6;
//    JButton jButtonname7;
//    JButton jButtonname8;
    Font font;
    Statement stmt;
    ResultSet rs;
    Connection con;

    public Sample_gui() {
        font = new Font("Consolas", Font.BOLD, 25);
        jFrame = new JFrame();
        jFrame.setBounds(100, 200, 800, 400);
        jFrame.setTitle("Student's Data");
        jLabelname = new JLabel();
        jLabelname2 = new JLabel();
        jLabelname3 = new JLabel();
        jLabelname4 = new JLabel();
        jLabelname.setBounds(20, 20, 200, 30);
        jLabelname.setText("Roll no ");
        jLabelname.setFont(font);
        jLabelname2.setText("Name ");
        jLabelname2.setBounds(20, 60, 200, 30);
        jLabelname2.setFont(font);
        jLabelname3.setBounds(20, 100, 200, 30);
        jLabelname3.setFont(font);
        jLabelname3.setText("Course ");
        jLabelname4.setFont(font);
        jLabelname4.setText("Fees ");
        jLabelname4.setBounds(20, 140, 200, 30);

        jTextFieldName = new JTextField();
        jTextFieldname2 = new JTextField();
        jTextFieldname3 = new JTextField();
        jTxetFieldname4 = new JTextField();
        jTextFieldName.setBounds(240, 20, 200, 30);
        jTextFieldname2.setBounds(240, 60, 200, 30);
        jTextFieldname3.setBounds(240, 100, 200, 30);
        jTxetFieldname4.setBounds(240, 140, 200, 30);

        jButtonname = new JButton();
        jButtonname2 = new JButton();
        jButtonname3 = new JButton();
        jButtonname4 = new JButton();
        jButtonname5 = new JButton();
        jButtonname6 = new JButton();
//        jButtonname7 = new JButton();
//        jButtonname8 = new JButton();

        jButtonname.setText("First");
        jButtonname.setFont(font);
        jButtonname.setBounds(20, 200, 150, 30);
        jButtonname2.setText("Next");
        jButtonname2.setFont(font);
        jButtonname2.setBounds(180, 200, 150, 30);
        jButtonname3.setText("Previous");
        jButtonname3.setFont(font);
        jButtonname3.setBounds(340, 200, 150, 30);
        jButtonname4.setText("Last");
        jButtonname4.setFont(font);
        jButtonname4.setBounds(500, 200, 150, 30);
        jButtonname5.setText("New");
        jButtonname5.setFont(font);
        jButtonname5.setBounds(20, 240, 150, 30);
        jButtonname6.setText("Insert");
        jButtonname6.setFont(font);
        jButtonname6.setBounds(180, 240, 150, 30);
//        jButtonname7.setText("Update");
//        jButtonname7.setFont(font);
//        jButtonname7.setBounds(340, 240, 150, 30);
//        jButtonname8.setText("Delete");
//        jButtonname8.setFont(font);
//        jButtonname8.setBounds(500, 240, 150, 30);
        jFrame.getContentPane().setBackground(Color.gray);

        jFrame.setVisible(true);
        jFrame.setLayout(null);
        jFrame.add(jLabelname);
        jFrame.add(jTextFieldName);
        jFrame.add(jLabelname2);
        jFrame.add(jTextFieldname2);
        jFrame.add(jLabelname3);
        jFrame.add(jTextFieldname3);
        jFrame.add(jLabelname4);
        jFrame.add(jTxetFieldname4);
        jFrame.add(jButtonname);
        jFrame.add(jButtonname2);
        jFrame.add(jButtonname3);
        jFrame.add(jButtonname4);
        jFrame.add(jButtonname5);
        jFrame.add(jButtonname6);
//        jFrame.add(jButtonname7);
//        jFrame.add(jButtonname8);
        jButtonname.addActionListener(this);
        jButtonname2.addActionListener(this);
        jButtonname3.addActionListener(this);
        jButtonname4.addActionListener(this);
        jButtonname5.addActionListener(this);
        jButtonname6.addActionListener(this);

        connectToDB();
    }

    public void connectToDB() {
        try {
            //laod the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");

            //ConnectionEstablish
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb?useTimezone=true&serverTimezone=UTC",
                    "root",
                    "");

            getData();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void getData() {
        try {
            //create stmt object
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            //execute the query
            rs = stmt.executeQuery("select * from student ");

            if (rs.next() == true) {
                showData();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//    @Override
//    public void actionPerformed(ActionEvent e) {
//        try
//        {
//            if(e.getSource()== jButtonname) {
//                //laod the driver class
//                Class.forName("com.mysql.cj.jdbc.Driver");
//
//                //establish the connection
//                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb?useTimezone=true&serverTimezone=UTC",
//                        "root",
//                        "");
//
//                //create stmt object
//                Statement stmt = con.createStatement();
//
//                //execute the query
//                ResultSet rs = stmt.executeQuery("select * from student");
//
//
//                if (rs.next() == true) {
//                    jTextFieldName.setText(rs.getString(1));
//                    jTextFieldname2.setText(rs.getString(2));
//                    jTextFieldname3.setText(rs.getString(3));
//                    jTxetFieldname4.setText(rs.getString(4));
//                }
//
//
//                con.close();
//            }
//
//        }
//        catch (Exception e1)
//
//        {
//            System.out.println("error in code ");
//        }
//    }

    public void showData() {
        try {

            jTextFieldName.setText(rs.getString(1));
            jTextFieldname2.setText(rs.getString(2));
            jTextFieldname3.setText(rs.getString(3));
            jTxetFieldname4.setText(rs.getString(4));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearAll() {
        try {
            jTextFieldName.setText("");
            jTextFieldname2.setText("");
            jTextFieldname3.setText("");
            jTxetFieldname4.setText("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertData() {
        try {
            int rno = Integer.parseInt(jTextFieldName.getText());
            String name = jTextFieldname2.getText();
            String crs = jTextFieldname3.getText();
            float fee = Float.parseFloat(jTxetFieldname4.getText());

            String insqry = "insert into student values(" + rno + ",'" + name + "','" + crs + "'," + fee + ")";

            int n = stmt.executeUpdate(insqry);
            if (n > 0) {
                JOptionPane.showMessageDialog(jFrame, "Data Inserted Successfully ");
                getData();
            } else {
                JOptionPane.showMessageDialog(jFrame, "Data insertion error");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == jButtonname2) {
                if (rs.next() == true) {
                    showData();
                } else {
                    JOptionPane.showMessageDialog(jFrame, "Last Record");
                }
            } else if (e.getSource() == jButtonname3) {
                if (rs.previous() == true) {
                    showData();
                }
            } else if (e.getSource() == jButtonname4) {
                if (rs.last() == true) {
                    showData();
                }
            } else if (e.getSource() == jButtonname5) {
                clearAll();
            } else if (e.getSource() == jButtonname6) {
                insertData();
            } con.close();      //Close the connection
        }

        catch (Exception ex) {
            ex.printStackTrace();
        }


    }
}