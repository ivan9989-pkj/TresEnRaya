package Forms;

import BD.Conexion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class modificar extends javax.swing.JFrame{
    private JButton buscarButton;
    private JTextField textField1;
    private JButton atrasButton;
    private JPanel modificarPanel;
    private JPasswordField passwordField1;
    private JTextField textField2;
    private JLabel mensajeLabel;

    public modificar() {
        setContentPane(modificarPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        pack();
        this.setLocationRelativeTo(null);
        setVisible(true);
        //Se llama al método modificarJugador() para modificar el nombre o contraseña del jugador
    buscarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int ID = Integer.parseInt(textField1.getText());
            String nombre = textField2.getText();
            String cont = passwordField1.getText();
            Conexion conexion = new Conexion();
            conexion.modificarJugador(ID, nombre, cont);
            textField1.setText("");
            textField2.setText("");
            passwordField1.setText("");
            mensajeLabel.setText("Jugador modificado con exito");
            pack();
        }
    });
    //Se vuelve al menú de administrar jugadores
    atrasButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            adminJug admin2 = new adminJug();
            dispose();
        }
    });
}
}
