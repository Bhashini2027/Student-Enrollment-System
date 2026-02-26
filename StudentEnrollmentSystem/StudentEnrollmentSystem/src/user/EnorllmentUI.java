/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import business.Enrollment;
import data.enrollDB;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */

public class EnorllmentUI extends javax.swing.JFrame {

    private enrollDB eDB;
    // UI Components
    private javax.swing.JTextField txtStudentID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNIC;
    private javax.swing.JTextField txtCourse;
    private javax.swing.JTextField txtGPA;
    private javax.swing.JTextField txtDistrict;
    private javax.swing.JTextField txtDOB;
    private javax.swing.JCheckBox chkEnrolled;
    private javax.swing.JTable tblDisplay;
    private javax.swing.JScrollPane scrollPane;

    /**
     * Creates new form EnorllmentUI
     */
    public EnorllmentUI() {
        eDB = new enrollDB();
        initComponents();
        refreshTable();
        setLocationRelativeTo(null);
    }

    private void initComponents() {

        javax.swing.JPanel inputPanel = new javax.swing.JPanel();
        javax.swing.JLabel lblID = new javax.swing.JLabel("Student ID:");
        javax.swing.JLabel lblName = new javax.swing.JLabel("Full Name:");
        javax.swing.JLabel lblNIC = new javax.swing.JLabel("NIC:");
        javax.swing.JLabel lblCourse = new javax.swing.JLabel("Course Code:");
        javax.swing.JLabel lblGPA = new javax.swing.JLabel("GPA:");
        javax.swing.JLabel lblDistrict = new javax.swing.JLabel("District:");
        javax.swing.JLabel lblDOB = new javax.swing.JLabel("DOB (M/d/yyyy):");
        javax.swing.JLabel lblEnrolled = new javax.swing.JLabel("Enrolled:");

        txtStudentID = new javax.swing.JTextField(15);
        txtName = new javax.swing.JTextField(20);
        txtNIC = new javax.swing.JTextField(15);
        txtCourse = new javax.swing.JTextField(10);
        txtGPA = new javax.swing.JTextField(5);
        txtDistrict = new javax.swing.JTextField(15);
        txtDOB = new javax.swing.JTextField(10);
        chkEnrolled = new javax.swing.JCheckBox();

        javax.swing.JPanel buttonPanel = new javax.swing.JPanel();
        javax.swing.JButton btnAdd = new javax.swing.JButton("Add");
        javax.swing.JButton btnUpdate = new javax.swing.JButton("Update");
        javax.swing.JButton btnDelete = new javax.swing.JButton("Delete");
        javax.swing.JButton btnSearch = new javax.swing.JButton("Search");
        javax.swing.JButton btnDisplay = new javax.swing.JButton("Refresh/Display");
        javax.swing.JButton btnSort = new javax.swing.JButton("Sort");
        javax.swing.JButton btnClear = new javax.swing.JButton("Clear");
        javax.swing.JButton btnAggregate = new javax.swing.JButton("Aggregate");

        scrollPane = new javax.swing.JScrollPane();
        tblDisplay = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Royal Crest University Enrollment System");

        // Layout Input Panel
        inputPanel.setLayout(new java.awt.GridLayout(4, 4, 10, 10));
        inputPanel.add(lblID);
        inputPanel.add(txtStudentID);
        inputPanel.add(lblName);
        inputPanel.add(txtName);
        inputPanel.add(lblNIC);
        inputPanel.add(txtNIC);
        inputPanel.add(lblCourse);
        inputPanel.add(txtCourse);
        inputPanel.add(lblGPA);
        inputPanel.add(txtGPA);
        inputPanel.add(lblDistrict);
        inputPanel.add(txtDistrict);
        inputPanel.add(lblDOB);
        inputPanel.add(txtDOB);
        inputPanel.add(lblEnrolled);
        inputPanel.add(chkEnrolled);

        // Layout Button Panel
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnSearch);
        buttonPanel.add(btnSort);
        buttonPanel.add(btnDisplay);
        buttonPanel.add(btnClear);
        buttonPanel.add(btnAggregate);

        // Table Setup
        tblDisplay.setModel(new DefaultTableModel(
                new Object[][] {},
                new String[] { "Student ID", "Name", "NIC", "Course", "GPA", "District", "Enrolled", "DOB" }));
        scrollPane.setViewportView(tblDisplay);

        // Main Layout
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(inputPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 800,
                                                Short.MAX_VALUE)
                                        .addComponent(scrollPane))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(inputPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                                .addContainerGap()));

        // Action Listeners
        btnAdd.addActionListener(e -> addRecord());
        btnUpdate.addActionListener(e -> updateRecord());
        btnDelete.addActionListener(e -> deleteRecord());
        btnSearch.addActionListener(e -> searchRecord());
        btnDisplay.addActionListener(e -> refreshTable());
        btnSort.addActionListener(e -> sortRecords());
        btnClear.addActionListener(e -> clearFields());
        btnAggregate.addActionListener(e -> showAggregationStats());

        // Table Selection Listener
        tblDisplay.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tblDisplay.getSelectedRow() != -1) {
                int row = tblDisplay.getSelectedRow();
                txtStudentID.setText(tblDisplay.getValueAt(row, 0).toString());
                txtName.setText(tblDisplay.getValueAt(row, 1).toString());
                txtNIC.setText(tblDisplay.getValueAt(row, 2).toString());
                txtCourse.setText(tblDisplay.getValueAt(row, 3).toString());
                txtGPA.setText(tblDisplay.getValueAt(row, 4).toString());
                txtDistrict.setText(tblDisplay.getValueAt(row, 5).toString());
                chkEnrolled.setSelected(tblDisplay.getValueAt(row, 6).toString().equalsIgnoreCase("TRUE"));
                txtDOB.setText(tblDisplay.getValueAt(row, 7).toString());
            }
        });

        pack();
    }

    private void addRecord() {
        try {
            Enrollment e = getFromFields();
            if (eDB.add(e)) {
                JOptionPane.showMessageDialog(this, "Record Added");
                refreshTable();
                clearFields();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void updateRecord() {
        try {
            Enrollment e = getFromFields();
            if (eDB.update(e)) {
                JOptionPane.showMessageDialog(this, "Record Updated");
                refreshTable();
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Record not found to update.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void deleteRecord() {
        String id = txtStudentID.getText();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter Student ID to delete");
            return;
        }
        if (eDB.delete(id)) {
            JOptionPane.showMessageDialog(this, "Record Deleted");
            refreshTable();
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Record not found");
        }
    }

    private void searchRecord() {
        String query = JOptionPane.showInputDialog("Enter Student ID to Search:");
        if (query != null && !query.isEmpty()) {
            Enrollment e = eDB.search(query);
            if (e != null) {
                populateFields(e);
            } else {
                JOptionPane.showMessageDialog(this, "Record not found");
            }
        }
    }

    private void sortRecords() {
        String[] options = { "Name", "Course", "GPA" };
        int choice = JOptionPane.showOptionDialog(this, "Sort by:", "Sort",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (choice >= 0) {
            eDB.sort(options[choice]);
            refreshTable();
        }
    }

    private void refreshTable() {
        DefaultTableModel model = (DefaultTableModel) tblDisplay.getModel();
        model.setRowCount(0);
        ArrayList<Enrollment> list = eDB.getAll();
        for (Enrollment e : list) {
            model.addRow(new Object[] {
                    e.getStudentID(), e.getFullName(), e.getNic(), e.getCourseCode(),
                    e.getGpa(), e.getDistrict(), e.isEnrolled() ? "TRUE" : "FALSE", e.getDob()
            });
        }
    }

    private void showAggregationStats() {
        ArrayList<Enrollment> list = eDB.getAll();
        if (list.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No records available for aggregation.", "Aggregation Stats",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int totalStudents = list.size();
        double totalGpa = 0.0;

        for (Enrollment e : list) {
            totalGpa += e.getGpa();
        }

        double averageGpa = totalGpa / totalStudents;
        String report = String.format("Total Enrolled Students: %d\nAverage GPA: %.2f", totalStudents, averageGpa);
        JOptionPane.showMessageDialog(this, report, "Student Aggregation Report", JOptionPane.INFORMATION_MESSAGE);
    }

    private void clearFields() {
        txtStudentID.setText("");
        txtName.setText("");
        txtNIC.setText("");
        txtCourse.setText("");
        txtGPA.setText("");
        txtDistrict.setText("");
        txtDOB.setText("");
        chkEnrolled.setSelected(false);
        tblDisplay.clearSelection();
    }

    private Enrollment getFromFields() {
        String id = txtStudentID.getText().trim();
        String name = txtName.getText().trim();
        String nic = txtNIC.getText().trim();
        String course = txtCourse.getText().trim();
        double gpa;
        try {
            gpa = Double.parseDouble(txtGPA.getText().trim());
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("කරුණාකර වලංගු GPA අගයක් ඇතුළත් කරන්න.");
        }
        String district = txtDistrict.getText().trim();
        boolean enrolled = chkEnrolled.isSelected();
        String dob = txtDOB.getText().trim();

        if (id.isEmpty() || name.isEmpty())
            throw new IllegalArgumentException("ID and Name are required");

        if (!name.matches("^[a-zA-Z\\s]+$"))
            throw new IllegalArgumentException("ක්‍රියා විරහිතයි! නමට අකුරු පමණක් ඇතුළත් කරන්න.");

        if (gpa < 0.0 || gpa > 4.0)
            throw new IllegalArgumentException("ක්‍රියා විරහිතයි! GPA අගය 0.0 ත් 4.0 ත් අතර විය යුතුය.");

        return new Enrollment(id, name, nic, course, gpa, district, enrolled, dob);
    }

    private void populateFields(Enrollment e) {
        txtStudentID.setText(e.getStudentID());
        txtName.setText(e.getFullName());
        txtNIC.setText(e.getNic());
        txtCourse.setText(e.getCourseCode());
        txtGPA.setText(String.valueOf(e.getGpa()));
        txtDistrict.setText(e.getDistrict());
        chkEnrolled.setSelected(e.isEnrolled());
        txtDOB.setText(e.getDob());
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EnorllmentUI.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new EnorllmentUI().setVisible(true);
        });
    }
}
