package java_basic_projects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class form1 extends JFrame{
    private JPanel panel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JLabel vize;
    private JLabel odev;
    private JLabel gecmenotu;
    private JLabel gereklinot;
    private JButton hesapla;



    form1(){
        panel=new JPanel();
        add(panel);
        panel.setLayout(new java.awt.GridLayout(0, 1));
        setSize(500,500);
        setTitle("Final Notu Hesaplama");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        textField1 = new JTextField(10);
        textField2 = new JTextField(10);
        textField3 = new JTextField(10);

        vize = new JLabel("Vize Notu : ");
        odev = new JLabel("Ödev Notu : ");
        gecmenotu = new JLabel("Geçme Notu : ");
        gereklinot = new JLabel("");

        hesapla = new JButton("Hesapla");

        panel.add(odev);
        panel.add(textField1);

        panel.add(vize);
        panel.add(textField2);

        panel.add(gecmenotu);
        panel.add(textField3);

        panel.add(gereklinot);
        panel.add(hesapla);


        hesapla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (textField1.getText().isEmpty() ||
                        textField2.getText().isEmpty() ||
                        textField3.getText().isEmpty()) {

                    gereklinot.setText("Boş bırakma.");
                    gereklinot.setBackground(Color.GRAY);
                    return;
                }

                double odevNot =  Double.parseDouble(textField1.getText());
                double vizeNot = Double.parseDouble(textField2.getText());
                double gecmeNot = Double.parseDouble(textField3.getText());

                double araToplam = (odevNot * 0.125) + (vizeNot * 0.375);
                double ffinal = (gecmeNot - araToplam) / 0.5;

                System.out.println("FFINAL: " + ffinal);

                gereklinot.setOpaque(true);

                if (ffinal >= 101) {
                    gereklinot.setBackground(Color.RED);
                    gereklinot.setText("İmkansız durum | GEREKLİ NOT: " + ffinal);

                } else if (ffinal >= 85) {
                    gereklinot.setBackground(Color.ORANGE);
                    gereklinot.setText("Çok yüksek not gerekiyor: " + ffinal);

                } else if (ffinal >= 50) {
                    gereklinot.setBackground(Color.YELLOW);
                    gereklinot.setText("Orta seviye: " + ffinal);

                } else if (ffinal >= 0) {
                    gereklinot.setBackground(Color.GREEN);
                    gereklinot.setText("Kolay geçiş: " + ffinal);

                } else {
                    gereklinot.setBackground(Color.GRAY);
                    gereklinot.setText("Hatalı veri");
                }


            }
        });
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                form1 f = new form1();
                f.setVisible(true);
            }
        });
    }
}
