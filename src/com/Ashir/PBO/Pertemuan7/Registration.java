package com.Ashir.PBO.Pertemuan7;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registration extends JFrame{
    private JTextField TxtNama;
    private JTextField TxtNIM;
    private JComboBox CBProdi;
    private JRadioButton lakiLakiRadioButton;
    private JTextField TxtTelp;
    private JRadioButton perempuanRadioButton;
    private JTextArea TxtAlamat;
    private JButton saveButton;
    private JButton clearButton;
    private JPanel mainPanel;
    private ButtonGroup JK;

    public Registration() {
        super("Forumulir Registrasi");

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setSize(800, 600);

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TxtNama.setText("");
                TxtNIM.setText("");
                TxtTelp.setText("");
                TxtAlamat.setText("");
                CBProdi.setSelectedIndex(0);
                // lakiLakiRadioButton.setSelected(false);
                // perempuanRadioButton.setSelected(false);
                JK.clearSelection();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = TxtNama.getText();
                String NIM = TxtNIM.getText();
                String prodi = (String) CBProdi.getSelectedItem();
                String telp = TxtTelp.getText();
                String alamat = TxtAlamat.getText();
                String JK;

                if(lakiLakiRadioButton.isSelected()) {
                    JK = "Laki-Laki";
                } else if (perempuanRadioButton.isSelected()) {
                    JK = "Perempuan";
                } else {
                    JK = "Tidak diketahui";
                }

                // Menampilkan msgbox
                JOptionPane.showMessageDialog(null, "Data berhasil disimpan!");
            }
        });
    }

    public static void main(String[] args) {
        JFrame mainFrame = new Registration();
        mainFrame.setVisible(true);
    }
}
