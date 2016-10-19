/*
 * Esta es la clase BD_Conexion, es la encargada de realizar operaciones con la base de datos, desde establecer la conexion
 * y posteriormente permitir realizar las opreaciones basica de consulta, insertar, modificar o eliminar datos.
 */

package Utilidades;

import java.sql.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo Patiño Salas
 */
public class BD_Conexion {
    //creo los objetos necesarios para poder realizar la conexion e interaccion con la base de datos.
    protected Connection bdConexion;
    protected ResultSet res;
    protected Statement st;
    protected PreparedStatement pst;
    protected String sql;
    //Ahora voy a crear objetos con los cuales voy a leer los parametros de la conexion a la base de datos.
    private String usuario, password, puerto, host, url, driver;
    private BufferedReader entrada;
    //Constructor vacio de la clase BD_Conexion
    public BD_Conexion(){}
    //Metodo con el cual voy a establecer la conexion con la base de datos.
    public void conectar(){
        //Lo primero que se hace en este metodo es buscar el archivo de configuracion, del cual vamos a leer los datos 
        //necesarios para poder realizar nuestra conexion. De esta forma la clase se hace mas dinamica, ya que esta misma clase 
        //se puede conectar a cualquier base de datos solamente con cambiar los datos contenidos en el archivo de configuracion.
        File f = new File("bd_config.dll");
        try {
            this.entrada = new BufferedReader(new FileReader(f));
            this.driver = entrada.readLine();
            this.url = entrada.readLine();
            this.usuario = entrada.readLine();
            this.password = entrada.readLine();
            this.host = entrada.readLine();
            this.puerto = this.entrada.readLine();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "ERROR 1: No se encuentra el archivo de configuracion bd_config.dll, \n" +
                                            "por favor verifique que el archivo este creado dentro de la carpeta principal.", "ERROR 1 ", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
            ex.printStackTrace();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "ERROR 2: No se pudo leer una de las lineas necesarias para poder realizar la conexion, \n" +
                                          "verifique el contenico del archivo de configuracion bd_config.dll.", "ERROR 2", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
            Logger.getLogger(BD_Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Luego de obtener los datos del archivo cerramos el BufferedReader.
        finally{
            try{
                this.entrada.close();
            }
            catch(IOException ex){
                JOptionPane.showMessageDialog(null, "ERROR 3: Hubo un problema al cerrar el BufferedReader.", "ERROR 3", JOptionPane.ERROR_MESSAGE);
            }
        }
        //Ahora vamos a realizar la conexion con la base de datos, ya que tenemos los datos necesarios para hacerlo.
        try{
            Class.forName(this.driver);
            System.setProperty("http:proxyHost", this.host);
            System.setProperty("http:proxyPort", this.puerto);
            this.bdConexion = DriverManager.getConnection(this.url, this.usuario, this.password);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error 4:Existe un problema con el archivo " + this.driver, "ERROR4", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 5: No se pudo establecer conexión con la base datos.", "ERROR5", JOptionPane.ERROR_MESSAGE);
        }
    }
    //Instanciando este metodo cerramos nuestra conexion.
    public void desconectar() throws SQLException{
        if(!this.bdConexion.isClosed())
            this.bdConexion.close();
    }
    /*Con este metodo podemos realizar una validacion de la conexion, y nos retornara un boolean, true si se pudo conectar
    * en caso contrario recibiremos un false. Recibe como parametros la url completa de la base de datos, el nombre de la 
    * base de datos, el nombre de usuario, el password y el string del Drvier.
    */
    public boolean validarConexion(String url, String bd, String user, String clave, String driv){

      try
      {
        Class.forName(driv);
        String url_ = url + "/" + bd;
        this.bdConexion = DriverManager.getConnection( url_, user, clave );
      }
    catch(Exception ex)
      {
        return false;
      }

      return true;
    }
    
    public Connection getConexion(){
        
        return this.bdConexion;
    }
    /* Los siguientes metodos son los que utilizaremos para realizar operaciones con los datos almacenados en la 
       base de datos.    
    */
    
    //Metodo para realizar consultas a la base de datos, retorna un resultset que contendra un array bidimensional,
    //con el contenido de nuestra consulta, recibe como parametro un String sql que es el query correspondiente a la
    //consulta que se desea realizar.
    public ResultSet select(String sql){
        
        try {
            if (bdConexion != null){
                this.st = bdConexion.createStatement();
                this.res = st.executeQuery(sql);
            }
            else 
                return null;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR 6: No se ha podido realizar la consulta.\n" + ex.getMessage(), "ERROR 6", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(BD_Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res;
        
    }
    //metodo para la ejecucion de insert, update, delete de la base de datos, retorna 1 si se realizo la operacion correctamente
    //y 0 en caso contrario, recibe como parametro un string con el sql correspondiente a lo que se desea hacer.
    public int ejecutarQuery(String sql){
        
        int num = 0;
        try {
            
            this.st = bdConexion.createStatement();            
            num = this.st.executeUpdate(sql);
            if(num == 1)
                return num;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR 7: Se produjo un error al tratar de ejecutar la sentencia.\n" + ex.getMessage(), "ERROR 7", num);
            Logger.getLogger(BD_Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return num;
    }
}
