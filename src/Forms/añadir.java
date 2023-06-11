package Forms;

import BD.Conexion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class añadir extends javax.swing.JFrame{
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton crearButton;
    private JPanel añadirPanel;
    private JButton atrasButton;
    private JLabel añadirLabel;

    public añadir(){
        setContentPane(añadirPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        pack();
        this.setLocationRelativeTo(null);
        setVisible(true);
        //Se llama al método crearJugador() para crear a un jugador en la base de datos
        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String name = textField1.getText();
               String password = passwordField1.getText();
               Conexion con1 = new Conexion();
               con1.crearJugador(name, password);
                //aqui va el código para crear jugadores
                añadirLabel.setForeground(Color.DARK_GRAY);
                añadirLabel.setText("Añadido con exito.");
                pack();
                textField1.setText("");
                passwordField1.setText("");
            }
        });
        //Volvemos al menú de administrar jugadores
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminJug admin2 = new adminJug();
                dispose();
            }
        });
    }
}
