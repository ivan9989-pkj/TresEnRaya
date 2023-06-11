import Forms.*;

public class Main {
    public static void main(String[] args) {
        //La clase Main lo único que hace es iniciar el menú del programa.
        //Para poder jugar los usuarios introducidos deben existir en la base de datos.
        //Al darle a crear la base de datos se crea esta y además se insertan dos jugadores, "Aaron" y "Mariola", para que puedas jugar sin necesidad de tener que crearlos.
        //Además del Main tenemos tres package, uno para las conexiones con la base de datos, otro con los formularios y otro con las imagenes.
        /*En caso de que para conectarse a la base de datos el usuario no sea "root" o haya contraseña para la conexión se debe cambiar
         en el package BD en Conexion.java el user y password */
        /* Todo lo referente a la conexión con la base de datos se encuentra en Conexion.java, de esta forma para hacer algo en la base de datos
         solo hay que llamar al método necesario*/
        tresRaya t1 = new tresRaya();
    }
}
