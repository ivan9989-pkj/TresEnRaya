package Forms;

import BD.Conexion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class buscar extends javax.swing.JFrame{
    private JButton buscarButton;
    private JTextField textField1;
    private JButton atrasButton;
    private JPanel buscarPanel;
    private JLabel IdLabel;

    public buscar() {
        setContentPane(buscarPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        pack();
        this.setLocationRelativeTo(null);
        setVisible(true);
        //Se llama al método bucarJug() para buscar el ID del jugador
    buscarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = textField1.getText();
            Conexion conexion = new Conexion();
            int id = conexion.bucarJug(name);
            if (id != -1) {
                IdLabel.setForeground(Color.white);
                IdLabel.setText("ID: " + id);
                pack();
                textField1.setText("");
            } else {
                IdLabel.setText("No se ha encontrado a un jugador con ese nombre");
                pack();
            }
        }
    });
    //Se vuelve al menú de administrar jugador
    atrasButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            adminJug admin2 = new adminJug();
            dispose();
        }
    });
}
}
