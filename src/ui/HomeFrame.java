/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.*;
import ui.newBooking;

public class HomeFrame extends javax.swing.JFrame {

    List<Booking> checkinToday = new ArrayList<>();
    List<Booking> checkoutToday = new ArrayList<>();

    public HomeFrame() {

        initComponents();
        loadDailyReservations(); // carrega os check-in e check-out diários

    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roomBtn = new javax.swing.JButton();
        bookBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_checkin = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_checkout = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_chkin = new javax.swing.JButton();
        btn_chkout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HomePage");
        setLocation(new java.awt.Point(0, 0));

        roomBtn.setText("Quartos");
        roomBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomBtnActionPerformed(evt);
            }
        });

        bookBtn.setText("Reservas");
        bookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookBtnActionPerformed(evt);
            }
        });

        tbl_checkin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sobrenome", "Nome", "Quarto", "Check-In"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_checkin);

        tbl_checkout.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sobrenome", "Nome", "Quarto", "Check-Out"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl_checkout);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Tabela de Check-Out hoje: ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Tabela de Check-in hoje:");

        btn_chkin.setText("Check-in");
        btn_chkin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chkinActionPerformed(evt);
            }
        });

        btn_chkout.setText("Check-out");
        btn_chkout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chkoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(roomBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bookBtn)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_chkin)
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_chkout)
                        .addGap(17, 17, 17))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roomBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btn_chkin)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_chkout)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void loadDailyReservations() {
        List<Booking> allBookings = BookingList.lerBookingCSV("dados/booking.csv");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String today = sdf.format(new Date());  // Data de hoje formatada

        for (Booking b : allBookings) {
            String checkInDate = sdf.format(b.getCheckInDate());
            String checkOutDate = sdf.format(b.getCheckOutDate());
            if (checkInDate.equals(today) && b.getStatusId() == 1) {
                checkinToday.add(b);
            }
            if (checkOutDate.equals(today) && b.getStatusId() == 2) {
                checkoutToday.add(b);
            }
        }

        // preencher as tabelas
        populateTable(tbl_checkin, checkinToday, true); // tabela de check-in
        populateTable(tbl_checkout, checkoutToday, false); // tabela de check-out
    }

    public void updateTables() {
        filterReservations(); // filtra as reservas
        populateTable(tbl_checkin, checkinToday, true);
        populateTable(tbl_checkout, checkoutToday, false);
    }

    // FILTRAR AS RESERVAS por dia e estado
    private void filterReservations() {
        List<Booking> allBookings = BookingList.lerBookingCSV("dados/booking.csv");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String today = sdf.format(new Date());

        checkinToday.clear();
        checkoutToday.clear();

        for (Booking b : allBookings) {
            String checkInDate = sdf.format(b.getCheckInDate());
            String checkOutDate = sdf.format(b.getCheckOutDate());
            if (checkInDate.equals(today) && b.getStatusId() == 1) { // Asumindo que 1 é o estado para "Reservado"
                checkinToday.add(b);
            }
            if (checkOutDate.equals(today) && b.getStatusId() == 2) { // Asumindo que 2 é o estado para "Checked-in"
                checkoutToday.add(b);
            }
        }
    }

    // PREENCHE AS TABELAS
    private void populateTable(JTable table, List<Booking> bookings, boolean isCheckIn) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Limpa a tabela antes de adicionar novos dados
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        for (Booking booking : bookings) {
            model.addRow(new Object[]{
                booking.getGuestLastName(),
                booking.getGuestFirstName(),
                booking.getRoomId(),
                isCheckIn ? sdf.format(booking.getCheckInDate()) : sdf.format(booking.getCheckOutDate())
            });

        }
    }

    private void roomBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomBtnActionPerformed
        // TODO add your handling code here:
        new RoomList().display();
        this.dispose();
    }//GEN-LAST:event_roomBtnActionPerformed

    private void bookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookBtnActionPerformed
        // TODO add your handling code here:
        new BookingList().display();
        this.dispose();
    }//GEN-LAST:event_bookBtnActionPerformed

    // PASSA PARA CHECK-IN 
    private void btn_chkinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chkinActionPerformed
        // TODO add your handling code here:
        int selectedRow = tbl_checkin.getSelectedRow();
        if (selectedRow >= 0) {
            Booking selectedBooking = checkinToday.get(selectedRow);
            selectedBooking.setStatusId(2); // Status 2 pode ser "Checked-in"
            newBooking csv = new newBooking(selectedBooking);
            csv.updateBookingInCSV(selectedBooking);
            updateTables();
            JOptionPane.showMessageDialog(this, "Check-in realizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum check-in selecionado!");
        }
    }//GEN-LAST:event_btn_chkinActionPerformed

    // PASSA PARA CHECK-OUT 
    private void btn_chkoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chkoutActionPerformed
        // TODO add your handling code here:
        int selectedRow = tbl_checkout.getSelectedRow();
        if (selectedRow >= 0) {
            Booking selectedBooking = checkoutToday.get(selectedRow);
            selectedBooking.setStatusId(5); // Estado "antigo".
            newBooking csv = new newBooking(selectedBooking);
            csv.updateBookingInCSV(selectedBooking);
            updateTables();
            JOptionPane.showMessageDialog(this, "Check-out realizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum check-out selecionado!");
        }
    }//GEN-LAST:event_btn_chkoutActionPerformed

    // INICIALIZA O PROGRAMA COM O HOME
    public static void main(String args[]) {
        new HomeFrame().display();
    }

    public void display() {
        setVisible(true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bookBtn;
    private javax.swing.JButton btn_chkin;
    private javax.swing.JButton btn_chkout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton roomBtn;
    private javax.swing.JTable tbl_checkin;
    private javax.swing.JTable tbl_checkout;
    // End of variables declaration//GEN-END:variables
}
