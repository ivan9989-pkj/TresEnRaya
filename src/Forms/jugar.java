package Forms;

import BD.Conexion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class jugar extends javax.swing.JFrame{
    private JTextField nombreTextField;
    private JButton jugarButton;
    private JPanel jugarPanel;
    private JButton atrasButton;
    private JTextField nombre2TextField;
    private JLabel errorLabel;
    private String j1, j2;
    Conexion conexion = new Conexion();

    public jugar(){
       setContentPane(jugarPanel);
       setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       setResizable(false);
       pack();
        this.setLocationRelativeTo(null);
       setVisible(true);
       //Se confirma que los dos jugadores existen en la base de datos y se abre el trablero de juego en caso afirmativo
       jugarButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               if (conexion.bucarJug(nombreTextField.getText()) != -1 && conexion.bucarJug(nombre2TextField.getText()) != -1){

               tablero tab = new tablero();
               dispose();
               tab.setJ1(nombreTextField.getText());
               tab.setJ2(nombre2TextField.getText());
               pack();
               } else if (conexion.bucarJug(nombreTextField.getText()) != -1){
                   errorLabel.setText("El jugador 2 no existe, por favor creelo.");
                   pack();
               } else if(conexion.bucarJug(nombre2TextField.getText()) != -1){
                   errorLabel.setText("El jugador 1 no existe, por favor creelo.");
                   pack();
               } else {
                   errorLabel.setText("No existe niguno de los dos juagdores.");
                   pack();
               }

           }
       });
       //Se vuelve al Frame para introducir los nombres de los jugadores
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tresRaya t3 = new tresRaya();
                dispose();
            }
        });
   }
}
