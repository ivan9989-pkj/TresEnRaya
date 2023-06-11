package Forms;

import BD.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class partidas extends javax.swing.JFrame{
    private JPanel partidasPanel;
    private JButton atrasButton;
    private JButton partidasButton;
    private JButton jugadoresButton;
    private JTable partidasTabla;
    private JTable partidaTable;
    Conexion conexion = new Conexion();

    public partidas() {
        setContentPane(partidasPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        pack();
        this.setLocationRelativeTo(null);
        setVisible(true);

        //Se vuelve al menú principal
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tresRaya r3 = new tresRaya();
                dispose();
            }
        });
        //Se llama al método mostrarPartidas() para crear la lista con los datos de las partidas
        partidasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conexion.mostrarPartidas(partidasTabla);
                pack();
            }
        });
        //Se llama al método mostrarJugadores() para crear la lista con los datos de los jugadores
        jugadoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conexion.mostrarJugadores(partidasTabla);
                pack();
            }
        });
    }

}
