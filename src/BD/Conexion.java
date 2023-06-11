package BD;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    Scanner sc = new Scanner(System.in);
    Connection conn1 = null;
    //Se crea la conexión con la base de datos.
    public Conexion() {
        try {
            String url = "jdbc:mysql://localhost";
            String user = "root";
            String password = "";
            conn1 = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            System.out.println("ERROR:La dirección no es válida o el usuario clave");
            ex.printStackTrace();
        }
    }

    /**
     * Este método crea la base de datos. La crea a través de un script SQL que se encuentra en la carpeta BD del proyecto
     * @param archivo
     */
    public void crearBD(String archivo) {
        FileReader fr = null;
        try {
            Statement stmt = conn1.createStatement();
            stmt.execute("CREATE DATABASE tresraya;");
            stmt.execute("USE tresraya");
            File file = new File(archivo);
            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            String lineaBD = "";
            while (linea != null) {
                if (linea.length() != 0) {
                    char Firstchar = linea.charAt(0);
                    if (Firstchar != '/' && Firstchar != '-' && linea.length() != 0) {
                        char LastChar = linea.charAt(linea.length() - 1);
                        if (LastChar == ';') {
                            PreparedStatement ps = conn1.prepareStatement(lineaBD + linea);
                            ps.executeUpdate();
                            ps.close();
                            lineaBD = "";
                            linea = br.readLine();
                        } else {
                            lineaBD += linea;
                            linea = br.readLine();
                        }
                    } else {
                        linea = br.readLine();
                    }
                } else
                    linea = br.readLine();
            }
            System.out.println("Base de datos creada y funcionando");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Este método sirve para crear a un nuevo jugador en la base de datos
     * @param nom
     * @param cont
     */
    public void crearJugador(String nom, String cont){
        try {
            String insJug = "insert into jugador(nombre, contraseña, victorias, derrotas, empates, total) values (?, ?, default, default, default, default);";
            PreparedStatement stmt = conn1.prepareStatement(insJug);
            stmt.setString(1, nom);
            stmt.setString(2, cont);
            stmt.execute("USE tresraya");
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: No se pudo añadir al jugador. " + e.getMessage());
        }
    }

    /**
     * Este método sirve para eliminar a un jugador a través de su ID
     * @param ID
     */
    public void eliminarJugador(int ID){
        try {
            String elJug = "delete from jugador where codJugador=?;";
            PreparedStatement stmt = conn1.prepareStatement(elJug);
            stmt.setInt(1, ID);
            stmt.execute("USE tresraya");
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: No se pudo eliminar al jugador. " + e.getMessage());
        }

    }

    /**
     * Este método sirve para modificar el nombre o contraseña de un jugador a través del ID
     * @param ID
     * @param nom
     * @param cont
     */
    public void modificarJugador(int ID, String nom, String cont){
        try {
            String modJug = "update jugador set nombre=?, contraseña=? where codJugador=?;";
            PreparedStatement stmt = conn1.prepareStatement(modJug);
            stmt.setString(1, nom);
            stmt.setString(2, cont);
            stmt.setInt(3, ID);
            stmt.execute("USE tresraya");
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: No se pudo modificar al jugador. " + e.getMessage());
        }
    }

    /**
     * Este método sirve para buscar el ID del jugador a través del nombre
     * @param nom
     * @return
     */
    public int bucarJug(String nom){
        int ID = -1;
        try{
            Statement stmt = conn1.createStatement();
            stmt.execute("USE tresraya");
            ResultSet result = stmt.executeQuery("select codJugador from jugador where nombre like '" + nom + "';");
            if (result.next()){
                ID = result.getInt(1);
            }


        } catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        return ID;
    }

    /**
     * Este método sirve para aumentar el nº de victorias y el total de partidas del jugador
     * @param nom
     */
    public void aumentarVic(String nom){
        try{
            String aumVic = "update jugador set victorias=victorias+1, total=total+1 where nombre=?;";
            PreparedStatement stmt = conn1.prepareStatement(aumVic);
            stmt.setString(1, nom);
            stmt.execute("USE tresraya");
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: No se pudo aumentar las victorias. " + e.getMessage());
        }
    }

    /**
     * Este método sirve para aumentar el nº de derrotas y el total de partidas del jugador
     * @param nom
     */
    public void aumentarDer(String nom){
        try{
            String aumDer = "update jugador set derrotas=derrotas+1, total=total+1 where nombre=?;";
            PreparedStatement stmt = conn1.prepareStatement(aumDer);
            stmt.setString(1, nom);
            stmt.execute("USE tresraya");
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: No se pudo aumentar las derrotas. " + e.getMessage());
        }
    }

    /**
     * Este método sirve para aumentar el nº de empates y el total de partidas del jugador
     * @param nom
     */
    public void aumentarTotal(String nom){
        try{
            String aumTotal = "update jugador set total=total+1, empates=empates+1 where nombre=?;";
            PreparedStatement stmt = conn1.prepareStatement(aumTotal);
            stmt.setString(1, nom);
            stmt.execute("USE tresraya");
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: No se pudo aumentar las partidas. " + e.getMessage());
        }
    }

    /**
     * Este método sirve para añadir la partida que se jugó a la base de datos en la tabla partida
     * @param nom1
     * @param nom2
     * @param ganador
     */
    public void aumentarPartida(String nom1, String nom2, String ganador){
        try{
            String aumPartida = "insert into partida (jugador1, jugador2, ganador, fechaPartida) values (?, ?, ?, current_date);";
            PreparedStatement stmt = conn1.prepareStatement(aumPartida);
            stmt.setString(1, nom1);
            stmt.setString(2, nom2);
            stmt.setString(3, ganador);
            stmt.execute("USE tresraya");
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: No se pudo ingresar la partida. " + e.getMessage());
        }
    }

    /**
     * Este método sirve para mostrar una tabla con los datos de los jugadores
     * @param table
     */
    public void mostrarJugadores(JTable table){
        try {
            String sql = "SELECT codJugador, nombre, victorias, derrotas, empates, total from jugador;";
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("Nombre");
            model.addColumn("Victorias");
            model.addColumn("Derrotas");
            model.addColumn("Empates");
            model.addColumn("Total");
            table.setModel(model);
            String [] datos = new String [6];
            Statement stmt = conn1.createStatement();
            stmt.execute("USE tresraya");
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()){
                datos[0] = String.valueOf(result.getInt(1));
                datos[1] = result.getString(2);
                datos[2] = String.valueOf(result.getInt(3));
                datos[3] = String.valueOf(result.getInt(4));
                datos[4] = String.valueOf(result.getInt(5));
                datos[5] = String.valueOf(result.getInt(6));
                model.addRow(datos);
            }
        } catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Este método sirve para mostrar una tabla con los datos de las partidas
     * @param table
     */
    public void mostrarPartidas(JTable table){
        try {
            String sql = "SELECT codPartida, jugador1, jugador2, ganador from partida;";
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("Jug. 1");
            model.addColumn("Jug. 2");
            model.addColumn("Ganador");
            table.setModel(model);
            String [] datos = new String [4];
            Statement stmt = conn1.createStatement();
            stmt.execute("USE tresraya");
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()){
                datos[0] = String.valueOf(result.getInt(1));
                datos[1] = result.getString(2);
                datos[2] = result.getString(3);
                datos[3] = result.getString(4);
                model.addRow(datos);
            }
        } catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

}