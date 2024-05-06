package ui;

import java.io.*;
import model.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class newRoom extends javax.swing.JFrame {

    private Room room; // Para armazenar o quarto sendo editado
    private int id;

    // inicializa para criar um quarto novo
    public newRoom(int id) {
        initComponents();
        lbl_titulo.setText("Criar Quarto");
        room = null; // Sem quarto para editar, criação de um novo
        this.id = id; // obtem o nº de linhas da tabela
    }

    // recebe um quarto para editar
    public newRoom(Room quartos) {
        initComponents();
        
        lbl_titulo.setText("Quarto nº" + String.valueOf(quartos.getRoomNumber()));
        room = quartos; // Carrega o quarto para edição
        // Preencher os campos com os dados do quarto
        txt_nQuarto.setText(String.valueOf(quartos.getRoomNumber()));
        txt_nAdultos.setText(String.valueOf(quartos.getAdultsCapacity()));
        txt_nCriancas.setText(String.valueOf(quartos.getChildrenCapacity()));
        txt_preco.setText(String.valueOf(quartos.getPrice()));
    }

    // adicionar um ID de quarto novo
    private void appendRoomToFile(Room room) throws IOException {
        room.setId(id + 1); // Incrementa o máximo ID encontrado
        try (PrintWriter out = new PrintWriter(new FileWriter("dados/rooms.csv", true))) {
            out.println(room.getId() + "," + room.getRoomNumber() + "," + room.getAdultsCapacity() + ","
                    + room.getChildrenCapacity() + "," + room.getPrice());
        }
    }

    // le o ficheiro CSV e adiciona o novo quarto
    private void updateRoomsFile() throws IOException {
        List<Room> rooms = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("dados/rooms.csv"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                int idRoom = Integer.parseInt(data[0]);
                int number = Integer.parseInt(data[1]);
                int adults = Integer.parseInt(data[2]);
                int children = Integer.parseInt(data[3]);
                float price = Float.parseFloat(data[4]);
                // cria objeto de Room e adiciona ele numa lista
                Room r = new Room(idRoom, number, adults, children, price);
                rooms.add(r);
            }
        }
        
        // pega a lista criada anteriormente para comparar com a lista que será gerada pelo CSV
        // e reescreve o CSV
        try (PrintWriter out = new PrintWriter(new FileWriter("dados/rooms.csv"))) {
            for (Room r : rooms) {
                if (r.getRoomNumber() == room.getRoomNumber()) {
                    out.println(room.getId() + "," + room.getRoomNumber() + "," + room.getAdultsCapacity() + ","
                            + room.getChildrenCapacity() + "," + room.getPrice());
                } else {
                    out.println(r.getId() + "," + r.getRoomNumber() + "," + r.getAdultsCapacity() + ","
                            + r.getChildrenCapacity() + "," + r.getPrice());
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnHome = new javax.swing.JButton();
        btnBooking = new javax.swing.JButton();
        lbl_titulo = new javax.swing.JLabel();
        lbl_nQuarto = new javax.swing.JLabel();
        lbl_nAdultos = new javax.swing.JLabel();
        lbl_nCriancas = new javax.swing.JLabel();
        lbl_preco = new javax.swing.JLabel();
        btn_salvar = new javax.swing.JButton();
        txt_nQuarto = new javax.swing.JTextField();
        txt_nAdultos = new javax.swing.JTextField();
        txt_nCriancas = new javax.swing.JTextField();
        txt_preco = new javax.swing.JTextField();
        btn_cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Detalhes Quartos");

        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnBooking.setText("Reservas");
        btnBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookingActionPerformed(evt);
            }
        });

        lbl_titulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_titulo.setText("Quarto nº");

        lbl_nQuarto.setText("Nº do Quarto:");

        lbl_nAdultos.setText("Nº de Adultos:");

        lbl_nCriancas.setText("Nº de Crianças:");

        lbl_preco.setText("Preço:");

        btn_salvar.setText("Salvar");
        btn_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvarActionPerformed(evt);
            }
        });

        txt_nQuarto.setText(" ");

        txt_nAdultos.setText(" ");

        txt_nCriancas.setText(" ");

        txt_preco.setText(" ");

        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btn_salvar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_preco, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_nCriancas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                            .addComponent(lbl_nAdultos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_nQuarto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_nQuarto)
                            .addComponent(txt_nAdultos)
                            .addComponent(txt_nCriancas)
                            .addComponent(txt_preco)
                            .addComponent(btn_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(lbl_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nQuarto)
                    .addComponent(txt_nQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nAdultos)
                    .addComponent(txt_nAdultos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nCriancas)
                    .addComponent(txt_nCriancas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_preco)
                    .addComponent(txt_preco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_salvar)
                    .addComponent(btn_cancelar))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarActionPerformed
        // TODO add your handling code here:
        try {
            int roomNumber = Integer.parseInt(txt_nQuarto.getText().trim());
            int adults = Integer.parseInt(txt_nAdultos.getText().trim());
            int children = Integer.parseInt(txt_nCriancas.getText().trim());
            float price = Float.parseFloat(txt_preco.getText().trim());

            if (room == null) { // Criação de novo quarto
                room = new Room(id + 1, roomNumber, adults, children, price);
                appendRoomToFile(room); //adiciona o quarto criado no ficheiro
            } else { // Atualização de quarto existente
                room.setId(id + 1);
                room.setRoomNumber(roomNumber);
                room.setAdultsCapacity(adults);
                room.setChildrenCapacity(children);
                room.setPrice(price);
                updateRoomsFile(); // atualiza o ficheiro csv
            }
            JOptionPane.showMessageDialog(this, "Quarto salvo com sucesso!");
            new RoomList().display(); // volta para a lista de quartos
            dispose();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos.");
        } catch (IOException ex) {
            Logger.getLogger(newRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_salvarActionPerformed

    // VOLTA PRO HOME
    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        new HomeFrame().display();
        dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    // VOLTA PRA LISTA DE QUARTO CANCELANDO O FORM
    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        // TODO add your handling code here:
        new RoomList().display();
        dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    // VAI PARA A PAGINA DE RESERVA
    private void btnBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookingActionPerformed
        // TODO add your handling code here:
        new BookingList().display();
        dispose();
    }//GEN-LAST:event_btnBookingActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBooking;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_salvar;
    private javax.swing.JLabel lbl_nAdultos;
    private javax.swing.JLabel lbl_nCriancas;
    private javax.swing.JLabel lbl_nQuarto;
    private javax.swing.JLabel lbl_preco;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JTextField txt_nAdultos;
    private javax.swing.JTextField txt_nCriancas;
    private javax.swing.JTextField txt_nQuarto;
    private javax.swing.JTextField txt_preco;
    // End of variables declaration//GEN-END:variables
}
