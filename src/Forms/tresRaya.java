package Forms;

import BD.Conexion;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;


public class tresRaya extends javax.swing.JFrame {
    private JButton jugarButton;
    private JButton administrarJugadorButton;
    private JButton verPartidasButton;
    private JButton crearBaseDeDatosButton;
    private JPanel Inicial;
    public tresRaya() {
        setContentPane(Inicial);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        pack();
        this.setLocationRelativeTo(null);
        setVisible(true);
        //Accede al menú para introducir los nombres de los jugadores que van a participar
        jugarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jugar j1 = new jugar();
                dispose();
            }
        });
        //Accede al menú de administrar jugadores
        administrarJugadorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminJug admi1 = new adminJug();
                dispose();
            }
        });
        //Accedemos al ranking, tanto de partidas como de jugadores
        verPartidasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                partidas p1 = new partidas();
                dispose();
            }
        });
        //Se crea la base de datos que se encuentra en el script tresRaya.sql
        crearBaseDeDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Aquí va el código de cuando pulsamos para crear la base de datos
                Conexion conexion = new Conexion();
                conexion.crearBD("./BD/tresRaya.sql");
            }
        });
    }

}


