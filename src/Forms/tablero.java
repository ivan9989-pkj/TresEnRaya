package Forms;

import BD.Conexion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class tablero extends javax.swing.JFrame implements ActionListener{
    private JLabel JLabel1, JLabel2, JLabel3, JLabel4, JLabel5, JLabel6, JLabel7, JLabel8, JLabel9;
    private JPanel tabPanel;
    private JButton reiniciarButton;
    private JButton volverAlMenúButton;
    private JLabel Turno;
    String siguienteJuego = "O";
    int contador;
    boolean estado = true; //Si es true si se puede seguir escribiendo, si no no.
    String turno = "X";
    JLabel[] lbs = new JLabel[9];
    Conexion conexion = new Conexion();
    int[][] vic = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9},
        {1, 4, 7},
        {2, 5, 8},
        {3, 6, 9},
        {1, 5, 9},
        {3, 5, 7}
    };
    private String j1, j2;

    public tablero(){
        lbs[0] = JLabel1;
        lbs[1] = JLabel2;
        lbs[2] = JLabel3;
        lbs[3] = JLabel4;
        lbs[4] = JLabel5;
        lbs[5] = JLabel6;
        lbs[6] = JLabel7;
        lbs[7] = JLabel8;
        lbs[8] = JLabel9;
        this.contador = 0;
        setContentPane(tabPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        this.setLocationRelativeTo(null);
        setVisible(true);
        //Del JLabel1 al Jlabel9 son los cuadrados donde se pueden posicionar las fichas
        JLabel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                presionar(1);
            }
        });
        JLabel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                presionar(2);
            }
        });
        JLabel3.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                presionar(3);
            }
        });
        JLabel4.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                presionar(4);
            }
        });
        JLabel5.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                presionar(5);
            }
        });
        JLabel6.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                presionar(6);
            }
        });
        JLabel7.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                presionar(7);
            }
        });
        JLabel8.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                presionar(8);
            }
        });
        JLabel9.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                presionar(9);
            }
        });

        //Se reinicia la partida y el tablero, además empieza el jugador que iba segundo en la anterior partida
        reiniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < lbs.length; i++){
                    lbs[i].setText("");
                    lbs[i].setBackground(Color.white);
                }
                turno = siguienteJuego;
                if(siguienteJuego.equals("O")){
                    siguienteJuego="X";
                } else {
                    siguienteJuego="O";
                }
                if (turno.equals("X")){
                    Turno.setText("Turno de " + j1);
                } else {
                    Turno.setText("Turno de " + j2);
                }
                setEstado(true);
                setContador(0);
            }
        });
        //Se vuelve al menú principal
        volverAlMenúButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tresRaya tr = new tresRaya();
                dispose();
            }
        });
    }

    /**
     * Este método sirve para colocar la ficha dependiendo del jugador que sea (1 o 2)
     * @param casilla
     */
    public void presionar(int casilla){
        if (lbs[casilla-1].getText().equals("") && estado) {
            lbs[casilla - 1].setText(turno);
            cambiarTurno();
            setContador(getContador()+1);
        }
        comprobarEmpate();
    }

    /**
     * Este método cambia el simbolo a escribir cuando se realiza el cambio de turno
     */
    public void cambiarTurno(){
        if (turno.equals("X")){
            turno = "O";
        } else {
            turno = "X";
        }
        if (turno.equals("X")){
            Turno.setText("Turno de " + j1);
        } else {
            Turno.setText("Turno de " + j2);
        }
        comprobarGanador();
    }


    /**
     * Este método comprueba las posibles soluciones guardadas en vic[][] y si alguna coincide le da la victoria a ese jugador y se añaden los datos a las tablas
     */
    public void comprobarGanador(){
        for (int i = 0; i < vic.length; i++){
            //Comprueba si los tres primeros labels tiene la x
            if (lbs[vic[i][0]-1].getText().equals("X") &&
                    lbs[vic[i][1]-1].getText().equals("X") &&
                    lbs[vic[i][2]-1].getText().equals("X")){
                lbs[vic[i][0]-1].setBackground(Color.green);
                lbs[vic[i][1]-1].setBackground(Color.green);
                lbs[vic[i][2]-1].setBackground(Color.green);
                Turno.setText("Ganador: " + j1);
                estado=false;
                conexion.aumentarVic(j1);
                conexion.aumentarDer(j2);
                conexion.aumentarPartida(j1, j2, j1);
            }
            if (lbs[vic[i][0]-1].getText().equals("O") &&
                    lbs[vic[i][1]-1].getText().equals("O") &&
                    lbs[vic[i][2]-1].getText().equals("O")){
                lbs[vic[i][0]-1].setBackground(Color.green);
                lbs[vic[i][1]-1].setBackground(Color.green);
                lbs[vic[i][2]-1].setBackground(Color.green);
                Turno.setText("Ganador: " + j2);
                estado=false;
                conexion.aumentarVic(j2);
                conexion.aumentarDer(j1);
                conexion.aumentarPartida(j1, j2, j2);
            }
        }
    }

    /**
     * En caso de que se llenen las 9 casillas y nadie haya ganado se tomará como empate, añadiendo los datos a las tablas
     */
    public void comprobarEmpate(){
        if (getContador() == 9){
            Turno.setText("Empate!!");
            conexion.aumentarTotal(j1);
            conexion.aumentarTotal(j2);
            conexion.aumentarPartida(j1, j2, null);
        }
    }

    /**
     * @return int con el contador del nº de jugadas de la partida
     */
    public int getContador() {
        return contador;
    }

    /**
     * @param contador
     */
    public void setContador(int contador) {
        this.contador = contador;
    }

    /**
     * @param estado
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * @param j1
     */
    public void setJ1(String j1) {
        this.j1 = j1;
    }

    /**
     * @param j2
     */
    public void setJ2(String j2) {
        this.j2 = j2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {}
}
