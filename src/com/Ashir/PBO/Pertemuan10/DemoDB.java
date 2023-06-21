package com.Ashir.PBO.Pertemuan10;

import com.mysql.cj.x.protobuf.MysqlxCrud;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class DemoDB extends JFrame{
    private JTextField txt_nim;
    private JTextField txt_nama;
    private JButton saveButton;
    private JButton clearButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JSpinner spr_nilai;
    private JTable dataTable;
    private JPanel mainPanel;
    private DefaultTableModel model;
    private static Connection c;
    private static Statement s;
    private static ResultSet rs;

    public DemoDB() {
        super("DemoDB");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600, 400);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = txt_nama.getText();
                String nim = txt_nim.getText();
                int nilai = (int) spr_nilai.getValue();

                if (nim.isEmpty() || nama.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all forms!");
                    return;
                }

                try {
                    openDB();
                    s.executeUpdate(
                            "INSERT INTO tb_mahasiswa values ('"+nim+"','"+nama+"','"+nilai+"')"
                    );

                    Object[] row = {nim, nama, nilai};
                    model.addRow(row);
                    JOptionPane.showMessageDialog(null, "Berhasil Menyimpan Data!");
                } catch (SQLException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
                } finally {
                    closeDB();
                }
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txt_nim.setText("");
                txt_nama.setText("");
                spr_nilai.setValue(0);
            }
        });
        dataTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = dataTable.getSelectedRow();

                String nim = dataTable.getValueAt(row, 0).toString();
                String nama = dataTable.getValueAt(row, 1).toString();
                int nilai = dataTable.getValueAt(row, 2).hashCode();

                txt_nim.setText(nim);
                txt_nama.setText(nama);
                spr_nilai.setValue(nilai);
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = txt_nama.getText();
                String nim = txt_nim.getText();
                int nilai = (int) spr_nilai.getValue();

                if (nim.isEmpty() || nama.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all forms!");
                    return;
                }

                try {
                    openDB();
                    s.executeUpdate(
                            "UPDATE tb_mahasiswa SET nama = '"+nama+"', nilai = '"+nilai+"' WHERE nim = '"+nim+"';"
                    );
                    model.setValueAt(nim, dataTable.getSelectedRow(), 0);
                    model.setValueAt(nama, dataTable.getSelectedRow(), 1);
                    model.setValueAt(nilai, dataTable.getSelectedRow(), 2);

                    txt_nim.setText("");
                    txt_nama.setText("");
                    spr_nilai.setValue(0);
                    JOptionPane.showMessageDialog(null, "Berhasil Mengubah Data!");
                } catch (SQLException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
                } finally {
                    closeDB();
                }
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nim = txt_nim.getText();

                try {
                    openDB();
                    s.executeUpdate(
                            "DELETE FROM tb_mahasiswa WHERE nim = '"+nim+"';"
                    );
                    JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus!");
                    model.removeRow(dataTable.getSelectedRow());
                } catch (SQLException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
                } finally {
                    closeDB();
                }
            }
        });
    }

    public static void main(String[] args) {
        DemoDB frame = new DemoDB();
        frame.setVisible(true);
    }

    // Open DB
    private static void openDB() throws ClassNotFoundException, SQLException {
        String URL = "jdbc:mysql://localhost:3306/dbdemo";
        String Username = "root";
        String Password = "";

        Class.forName("com.mysql.cj.jdbc.Driver");
        c = DriverManager.getConnection(URL, Username, Password);
        s = c.createStatement();
    }

    // Close DB
    private static void closeDB(){
        try{
            rs.close();
            s.close();
            c.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        model = new DefaultTableModel();
        dataTable = new JTable(model);
        model.addColumn("NIM");
        model.addColumn("Nama");
        model.addColumn("Nilai");

        try {
            openDB();
            rs = s.executeQuery("SELECT * FROM tb_mahasiswa");

            while(rs.next()){
                Object[] row = {
                        rs.getString("nim"),
                        rs.getString("nama"),
                        rs.getInt("nilai")
                };
                model.addRow(row);
            }
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }finally{
            closeDB();
        }
    }
}
