package com.Ashir.PBO.Pertemuan9;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.sql.*;
import javax.swing.table.DefaultTableModel;


public class DemoDatabase extends JFrame {
    private JTabbedPane tabbedPane;
    private JPanel mainPanel;
    private JTextField nameField;
    private JTextField nimField;
    private JSpinner nilaiSpinner;
    private JButton clearButton;
    private JPanel addDataTab;
    private JLabel namaLabel;
    private JLabel NIMLabel;
    private JLabel nilaiLabel;
    private JTable dataTable;
    private JButton submitButton;
    private JScrollPane dataScrollPane;
    private JPanel seeDataTab;
    private JButton clearTableButton;
    private JButton deleteRowButton;
    private DefaultTableModel model;
    private static Connection c;
    private static Statement s;
    private static ResultSet rs;


    private static void openDb() throws ClassNotFoundException, SQLException {
        String URL = "jdbc:mysql://localhost:3306/dbdemo";
        String username = "root";
        String password = "";

        Class.forName("com.mysql.cj.jdbc.Driver");
        c = DriverManager.getConnection(URL, username, password);
        s = c.createStatement();
    }

    private static void closeDB(){
        try{
            rs.close();
            s.close();
            c.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    // < Komponen-komponen >
    public DemoDatabase(){
        super("Demo Database");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400,300);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nim = nimField.getText();
                String nama = nameField.getText();
                int nilai = (int) nilaiSpinner.getValue();

                if (nim.isEmpty() || nama.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all forms!");
                    return;
                }

                try {
                    openDb();

                    // Check if a row with the same nim already exists
                    PreparedStatement checkStatement = c.prepareStatement("SELECT * FROM tabel WHERE nim = ?");
                    checkStatement.setString(1, nim);
                    ResultSet checkResult = checkStatement.executeQuery();

                    if (checkResult.next()) {
                        JOptionPane.showMessageDialog(null, "A row with the same NIM already exists!");
                        return;
                    }

                    // Insert the new row
                    PreparedStatement insertStatement = c.prepareStatement("INSERT INTO tabel VALUES (?, ?, ?)");
                    insertStatement.setString(1, nim);
                    insertStatement.setString(2, nama);
                    insertStatement.setInt(3, nilai);
                    insertStatement.executeUpdate();

                    Object[] row = { nim, nama, nilai };
                    model.addRow(row);

                    JOptionPane.showMessageDialog(null, "Data added!");
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
                nimField.setText("");
                nameField.setText("");
                nilaiSpinner.setValue(0);
                JOptionPane.showMessageDialog(null, "Form cleared!");
            }
        });

        clearTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete all data?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    try {
                        openDb();
                        int rowsDeleted = s.executeUpdate("DELETE FROM tabel");

                        if (rowsDeleted > 0) {
                            model.setRowCount(0);
                            JOptionPane.showMessageDialog(null, "All data deleted!");
                        } else {
                            JOptionPane.showMessageDialog(null, "No data found to delete.");
                        }
                    } catch (SQLException | ClassNotFoundException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
                    } finally {
                        closeDB();
                    }
                }
            }
        });

        deleteRowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nim = nimField.getText();

                if (nim.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid NIM.");
                    return;
                }

                int selectedRowIndex = dataTable.getSelectedRow();
                if (selectedRowIndex == -1) {
                    JOptionPane.showMessageDialog(null, "Please select a row to delete.");
                    return;
                }

                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this row?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    try {
                        openDb();
                        String selectedNIM = model.getValueAt(selectedRowIndex, 0).toString();
                        int rowsDeleted = s.executeUpdate("DELETE FROM tabel WHERE nim = '" + selectedNIM + "'");

                        if (rowsDeleted > 0) {
                            model.removeRow(selectedRowIndex);
                            JOptionPane.showMessageDialog(null, "Row deleted successfully.");
                        } else {
                            JOptionPane.showMessageDialog(null, "No rows found with the specified NIM.");
                        }
                    } catch (SQLException | ClassNotFoundException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
                    } finally {
                        closeDB();
                    }
                }
            }
        });
    }

    private void createUIComponents() {
        model = new DefaultTableModel();
        dataTable = new JTable(model);
        model.addColumn("NIM");
        model.addColumn("Nama");
        model.addColumn("Nilai");

        try {
            openDb();
            rs = s.executeQuery("SELECT * FROM tabel");

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

        dataTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting() && dataTable.getSelectedRowCount() == 1) {
                    int selectedRowIndex = dataTable.getSelectedRow();
                    String selectedNIM = model.getValueAt(selectedRowIndex, 0).toString();
                    nimField.setText(selectedNIM);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame mainFrame = new DemoDatabase();
        mainFrame.setVisible(true);
    }
}