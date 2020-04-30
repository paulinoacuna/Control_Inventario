package baseDatos;
import java.sql.*;

/*
   IMPORTANTE !! : SI LA CONEXION CON LA BASE DATOS FALLA, ENTONCES SE DEBE CAMBIAR LO SIGUENTE

    1. variable user = "ingresa tu usuario de MySQL workbench"
    2. variable pass = "ingresa tu contrasena de MySQL workbench"
 */

public class Conexion {

    
    
    public Connection conex;
    private String url = String.format("jdbc:mysql://%s:%d/%s?useSSL=false", "localhost", 3306, "controlinventario500k");
    private String user = "root";
    private String pass = "123456";

   
    public Conexion() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conex = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            
            System.err.println("Error: " + e);
          
        }
    }
    
     
}


/* CODIGO PARA IMPRIMIR TABLAS DE LA BASE DE DATOS (no usar en esta clase, copiarla en main)
     Conexion cn = new Conexion();

        Statement st;
        ResultSet rs;
        try {
            st = cn.conex.createStatement();
            rs = st.executeQuery("select * from almacen");

            while (rs.next()) {

                System.out.println(rs.getInt("id") + " " + rs.getString("nombre")
                        + " " + rs.getString("telefono") + " " + rs.getString("direccion"));
            }
            cn.conex.close();
    
        } catch (Exception e) {
             System.out.println("Error: " + e);
        }
 */
