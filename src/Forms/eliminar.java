package Forms;

import BD.Conexion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class eliminar extends javax.swing.JFrame{
    private JButton eliminarButton;
    private JTextField textField1;
    private JButton atrasButton;
    private JPanel eliminarPanel;
    private JLabel eliminarLabel;

    public eliminar() {
        setContentPane(eliminarPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        pack();
        this.setLocationRelativeTo(null);
        setVisible(true);
        //Se llama al método eliminarJugador() para eliminar un jugador existente
    eliminarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int ID = Integer.parseInt(textField1.getText());
            Conexion conexion = new Conexion();
            conexion.eliminarJugador(ID);
            eliminarLabel.setForeground(Color.white);
            eliminarLabel.setText("Eliminado con exito.");
            pack();
            textField1.setText("");

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
