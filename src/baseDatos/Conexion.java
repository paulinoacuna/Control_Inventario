package baseDatos;

import data.Producto;
import java.sql.*;
import logic.Controlador;
import static logic.Controlador.ArbolProductosTotales;

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

    public static void cargarBaseDatos() {

        Conexion con = new Conexion();

        Statement st;
        ResultSet rs;

        int counter = 1;
        int counter2 = 0;

        try {

            st = con.conex.createStatement();

            rs = st.executeQuery("select * from producto");

            //registros de entrada seteados, por defecto entran 100.000
            while (rs.next() && counter <= 4) {
                //System.out.println(rs.getInt("total"));

                //Proveedor provedorA = new Proveedor(rs.getInt("llave"), rs.getString("nombre"));
                Producto productoA
                        = new Producto(rs.getInt("codigoProducto"),
                                rs.getString("descripcion"),
                                rs.getInt("precioVenta"),
                                rs.getInt("precioCompra"),
                                rs.getInt("cantidadUnidades"),
                                Controlador.subCategoria);

                //Controlador.ProvedoresTotales.agregarDelante(provedorA);
                ArbolProductosTotales.insert(ArbolProductosTotales.getRoot(), productoA);

                counter++;
            }
            //multiplicador de data en tiempo de ejecucion
            //seteado a 400.000 registros más
            while (counter2 <= 445) {

                //Proveedor provedorB = new Proveedor(rs.getInt("llave") + counter2, rs.getString("nombre"));
                Producto productoB
                        = new Producto(rs.getInt("codigoProducto") + counter2,
                                rs.getString("descripcion"),
                                rs.getInt("precioVenta"),
                                rs.getInt("precioCompra"),
                                rs.getInt("cantidadUnidades"),
                                Controlador.subCategoria);

                //Controlador.ProvedoresTotales.agregarDelante(provedorB);
                ArbolProductosTotales.insert(ArbolProductosTotales.getRoot(), productoB);
                counter2++;

            }

            con.conex.close();
            System.out.println("MySQL connection successfully");

        } catch (Exception e) {
            System.out.println("Error: " + e);
            System.out.println("No se ha logrado conectar con MySQL. Esto "
                    + "no afecta el funcionamiento del programa");
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
