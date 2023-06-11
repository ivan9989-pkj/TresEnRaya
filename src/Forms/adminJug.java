package Forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adminJug extends javax.swing.JFrame{

    private JButton eliminarButton;
    private JButton buscarIDButton;
    private JButton modificarButton;
    private JButton añadirButton;
    private JPanel adminPanel;
    private JButton atrasButton;
    public adminJug() {
        setContentPane(adminPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(550, 325);
        this.setLocationRelativeTo(null);
        setVisible(true);
        //Se abre el Frame para añadir a un jugador nuevo
        añadirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                añadir añ1 = new añadir();
                dispose();
            }
        });
        //Se abre el Frame para eliminar a un jugador
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminar el1 = new eliminar();
                dispose();
            }
        });
        //Se abre el Frame para modificar a un jugador
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificar m1 = new modificar();
                dispose();
            }
        });
        //Se abre el Frame para buscar el ID de un jugador
        buscarIDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscar b1 = new buscar();
                dispose();
            }
        });
        //Se abre el Frame del menú principal
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tresRaya t3 = new tresRaya();
                dispose();
            }
        });
    }

}
