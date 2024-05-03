/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import java.util.*;
import javax.swing.*;
import model.*;
import controller.RoomBookingSystem;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import ui.*;

public class newBooking extends javax.swing.JFrame {

    public static final int CANCELED_STATUS_ID = 4;
    public Room quartoDisponivel;

    public newBooking() {
        initComponents();

        btn_cancel.setVisible(false);
        btn_ckin.setVisible(false);
        btn_ckout.setVisible(false);
    }

    // criar vista de edição
    public newBooking(Booking dados) {
        initComponents();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        txt_nome.setText(dados.getGuestFirstName());
        txt_sobrenome.setText(dados.getGuestLastName());
        txt_checkin.setText(df.format(dados.getCheckInDate()));
        txt_checkout.setText(df.format(dados.getCheckOutDate()));
        txt_adultos.setText((Integer.toString(dados.getNumberOfAdults())));
        txt_criancas.setText((Integer.toString(dados.getNumberOfChildren())));

        btn_availableRoom.setVisible(false);
        btn_confirm.setVisible(false);

        if (dados.getStatusId() == 2) { // Supondo que 2 seja o ID para "Checked-in"
            btn_ckin.setEnabled(false);
            btn_ckout.setEnabled(true);
            btn_cancel.setEnabled(false);
            disableFormFields(); // Desativa os campos de formulário após o check-in
        } else if (dados.getStatusId() == 1) { // Supondo que 1 seja o ID para "Booked"
            btn_ckin.setEnabled(true);
            btn_ckout.setEnabled(false);
            btn_cancel.setEnabled(true);
        } else {
            btn_ckin.setEnabled(false);
            btn_ckout.setEnabled(false);
            btn_cancel.setEnabled(false);
        }

        btn_ckin.addActionListener(e -> {
            // Muda o status para Checked-in
            dados.setStatusId(2);
            btn_ckin.setEnabled(false);
            btn_ckout.setEnabled(true);
            btn_cancel.setEnabled(false);
            disableFormFields();
            //updateBookingInCSV(dados);
            JOptionPane.showMessageDialog(this, "Check-in realizado com sucesso.");
        });

        btn_ckout.addActionListener(e -> {
            // Muda o status para Checked-out
            dados.setStatusId(3);
            btn_ckout.setEnabled(false);
            updateBookingInCSV(dados);
            JOptionPane.showMessageDialog(this, "Check-out realizado com sucesso.");
            //dispose();
        });

        btn_cancel.addActionListener(e -> {
            // Cancela a reserva
            dados.setStatusId(CANCELED_STATUS_ID);
            btn_ckin.setEnabled(false);
            btn_ckout.setEnabled(false);
            btn_cancel.setEnabled(false);
            updateBookingInCSV(dados);
            JOptionPane.showMessageDialog(this, "Reserva cancelada.");
            //dispose();
        });
    }

    private void disableFormFields() {
        txt_nome.setEditable(false);
        txt_sobrenome.setEditable(false);
        txt_checkin.setEditable(false);
        txt_checkout.setEditable(false);
        txt_adultos.setEditable(false);
        txt_criancas.setEditable(false);
    }

    public void updateBookingInCSV(Booking updatedBooking) {
    List<Booking> bookings = new ArrayList<>();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    // Ler todas as reservas
    try (BufferedReader reader = new BufferedReader(new FileReader("dados/booking.csv"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            Booking booking = new Booking(
                Integer.parseInt(data[0]),
                data[1],
                data[2],
                dateFormat.parse(data[3]),
                dateFormat.parse(data[4]),
                Integer.parseInt(data[5]),
                Integer.parseInt(data[6]),
                Integer.parseInt(data[7]),
                Integer.parseInt(data[8])
            );
            if (booking.getId() == updatedBooking.getId()) {
                // Atualiza com os novos detalhes
                bookings.add(updatedBooking);
            } else {
                bookings.add(booking);
            }
        }
    } catch (IOException | ParseException e) {
        System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        e.printStackTrace();
        return;
    }

    // Reescrever o arquivo CSV com as reservas atualizadas
    try (PrintWriter writer = new PrintWriter(new FileWriter("dados/booking.csv"))) {
        for (Booking booking : bookings) {
            String line = String.format("%d,%s,%s,%s,%s,%d,%d,%d,%d",
                booking.getId(),
                booking.getGuestFirstName(),
                booking.getGuestLastName(),
                dateFormat.format(booking.getCheckInDate()),
                dateFormat.format(booking.getCheckOutDate()),
                booking.getNumberOfAdults(),
                booking.getNumberOfChildren(),
                booking.getRoomId(),
                booking.getStatusId());
            writer.println(line);
        }
    } catch (IOException e) {
        System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        e.printStackTrace();
    }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_nome = new javax.swing.JLabel();
        txt_nome = new javax.swing.JTextField();
        lbl_sobrenome = new javax.swing.JLabel();
        txt_sobrenome = new javax.swing.JTextField();
        lbl_checkin = new javax.swing.JLabel();
        txt_checkin = new javax.swing.JTextField();
        lbl_checkout = new javax.swing.JLabel();
        txt_checkout = new javax.swing.JTextField();
        lbl_adultos = new javax.swing.JLabel();
        txt_adultos = new javax.swing.JTextField();
        lbl_criancas = new javax.swing.JLabel();
        txt_criancas = new javax.swing.JTextField();
        lbl_quartos = new javax.swing.JLabel();
        lbl_infoQuarto = new javax.swing.JLabel();
        btn_availableRoom = new javax.swing.JButton();
        btn_confirm = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btn_ckin = new javax.swing.JButton();
        btn_ckout = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Detalhes da Reserva");

        lbl_nome.setText("Nome:");

        lbl_sobrenome.setText("Sobrenome:");

        lbl_checkin.setText("Check-in:");

        lbl_checkout.setText("Check-out:");

        lbl_adultos.setText("Adultos:");

        lbl_criancas.setText("Crianças:");

        lbl_quartos.setText("Quarto:");

        lbl_infoQuarto.setText(" ");

        btn_availableRoom.setText("Obter Quarto Disponível");
        btn_availableRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_availableRoomActionPerformed(evt);
            }
        });

        btn_confirm.setText("Reservar");
        btn_confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_confirmActionPerformed(evt);
            }
        });

        jButton1.setText("Reservas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Home");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btn_ckin.setText("Check-in");

        btn_ckout.setText("Check-out");

        btn_cancel.setText("Cancelar Reserva");

        jLabel1.setText("obs: (dd/mm/aaaa)");

        jLabel2.setText("obs: (dd/mm/aaaa)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lbl_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(lbl_sobrenome)
                        .addGap(12, 12, 12)
                        .addComponent(txt_sobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(lbl_adultos, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(txt_adultos, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(lbl_criancas, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(txt_criancas, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(lbl_quartos, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(lbl_infoQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btn_availableRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btn_ckin, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btn_ckout, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(btn_cancel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_checkin, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(txt_checkin, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_checkout, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(txt_checkout, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lbl_nome))
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lbl_sobrenome))
                    .addComponent(txt_sobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lbl_checkin))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_checkin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lbl_checkout))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_checkout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lbl_adultos))
                    .addComponent(txt_adultos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lbl_criancas))
                    .addComponent(txt_criancas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_quartos)
                    .addComponent(lbl_infoQuarto))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_availableRoom)
                    .addComponent(btn_confirm))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_ckin)
                    .addComponent(btn_ckout)
                    .addComponent(btn_cancel)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new BookingList().display();
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new HomeFrame().display();
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_availableRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_availableRoomActionPerformed
        // TODO add your handling code here:
        RoomBookingSystem bookingSystem = new RoomBookingSystem();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date checkInDate = sdf.parse(txt_checkin.getText());
            Date checkOutDate = sdf.parse(txt_checkout.getText());
            int numAdults = Integer.parseInt(txt_adultos.getText());
            int numChildren = Integer.parseInt(txt_criancas.getText());

            // Suponha que exista uma função para obter todas as reservas e quartos disponíveis
            List<Room> availableRooms = bookingSystem.searchAvailableRooms(RoomList.lerQuartosCSV("dados/rooms.csv"), BookingList.lerBookingCSV("dados/booking.csv"), numAdults, numChildren, checkInDate, checkOutDate, CANCELED_STATUS_ID);
            if (!availableRooms.isEmpty()) {
                quartoDisponivel = availableRooms.get(0); // Assume que a lista já está ordenada pelo preço
                lbl_infoQuarto.setText(quartoDisponivel.getRoomNumber() + " por $" + quartoDisponivel.getPrice() + " por noite"); // Salve o quarto selecionado para uso na reserva
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum quarto disponível.");
            }
        } catch (ParseException pe) {
            JOptionPane.showMessageDialog(this, "Formato de data inválido.");
        }
    }//GEN-LAST:event_btn_availableRoomActionPerformed


    private void btn_confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_confirmActionPerformed
        // TODO add your handling code here:
        try {
            FileWriter fw = new FileWriter("dados/booking.csv", true);
            PrintWriter pw = new PrintWriter(fw);
            // Formata a reserva em uma linha CSV
            pw.println(quartoDisponivel.getId() + ","
                    + txt_nome.getText() + ","
                    + txt_sobrenome.getText() + ","
                    + txt_checkin.getText() + ","
                    + txt_checkout.getText() + ","
                    + txt_adultos.getText() + ","
                    + txt_criancas.getText() + ","
                    + quartoDisponivel.getRoomNumber() + ","
                    + "1"); //  status 1 é 'Reservado/Booked'
            pw.flush();
            pw.close();
            JOptionPane.showMessageDialog(this, "Reserva confirmada com sucesso.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar a reserva.");
        }
    }//GEN-LAST:event_btn_confirmActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_availableRoom;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_ckin;
    private javax.swing.JButton btn_ckout;
    private javax.swing.JButton btn_confirm;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbl_adultos;
    private javax.swing.JLabel lbl_checkin;
    private javax.swing.JLabel lbl_checkout;
    private javax.swing.JLabel lbl_criancas;
    private javax.swing.JLabel lbl_infoQuarto;
    private javax.swing.JLabel lbl_nome;
    private javax.swing.JLabel lbl_quartos;
    private javax.swing.JLabel lbl_sobrenome;
    private javax.swing.JTextField txt_adultos;
    private javax.swing.JTextField txt_checkin;
    private javax.swing.JTextField txt_checkout;
    private javax.swing.JTextField txt_criancas;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextField txt_sobrenome;
    // End of variables declaration//GEN-END:variables
}
