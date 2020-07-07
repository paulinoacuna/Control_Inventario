package baseDatos;

import data.Empleado;
import data.Producto;
import data.Proveedor;
import java.sql.*;
import logic.Controlador;
import static logic.Controlador.ArbolEmpleadosTotales;
import static logic.Controlador.ArbolProductosTotales;
import static logic.Controlador.ArbolProveedoresTotales;

/*
   IMPORTANTE !! : SI LA CONEXION CON LA BASE DATOS FALLA, ENTONCES SE DEBE CAMBIAR LO SIGUENTE

    1. variable user = "ingresa tu usuario de MySQL workbench"
    2. variable pass = "ingresa tu contrasena de MySQL workbench"
 */
public class Conexion {

    public Connection conex;
    private String url = String.format("jdbc:mysql://%s:%d/%s?useSSL=false", "localhost", 3306, "controlinvetario");
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

            for (int i = 2; i <= 10; i++) {
                Producto productoN = new Producto(i, "boyourt oreo 250g", 2800, 2000, 14, Controlador.subCategoria,
                        Controlador.almacen);
                ArbolProductosTotales.insert(ArbolProductosTotales.getRoot(), productoN);

            }

            while (rs.next() && counter <= 999) {
                //entran 1000 datos
                //System.out.println(rs.getInt("total"));

                //Proveedor provedorA = new Proveedor(rs.getInt("llave"), rs.getString("nombre"));
                Producto productoA
                        = new Producto(rs.getInt("id"),
                                rs.getString("descripcion"),
                                rs.getInt("precioVenta"),
                                rs.getInt("precioCompra"),
                                rs.getInt("cantidadUnidades"),
                                Controlador.subCategoria, Controlador.almacen);

                //Controlador.ProvedoresTotales.agregarDelante(provedorA);
                ArbolProductosTotales.insert(ArbolProductosTotales.getRoot(), productoA);

                counter++;
            }
            //multiplicador de data en tiempo de ejecucion

            while (counter2 <= 8990) {

                //Proveedor provedorB = new Proveedor(rs.getInt("llave") + counter2, rs.getString("nombre"));
                Producto productoB
                        = new Producto(rs.getInt("id") + counter2,
                                rs.getString("descripcion"),
                                rs.getInt("precioVenta"),
                                rs.getInt("precioCompra"),
                                rs.getInt("cantidadUnidades"),
                                Controlador.subCategoria, Controlador.almacen);

                //Controlador.ProvedoresTotales.agregarDelante(provedorB);
                ArbolProductosTotales.insert(ArbolProductosTotales.getRoot(), productoB);
                counter2++;

            }

            System.out.println("MySQL connection successfully");
            counter2 = 0;
            counter = 1;

        } catch (Exception e) {
            System.out.println("Error: " + e);
            System.out.println("No se ha logrado conectar con MySQL. Esto "
                    + "no afecta el funcionamiento del programa");
        }

        try {

            st = con.conex.createStatement();

            rs = st.executeQuery("select * from provedor");

            while (rs.next() && counter <= 99) {
                //entran 1000 datos
                //System.out.println(rs.getInt("total"));

                //Proveedor provedorA = new Proveedor(rs.getInt("llave"), rs.getString("nombre"));
                Proveedor p
                        = new Proveedor(rs.getInt("id"), rs.getString("nombre"));

                //Controlador.ProvedoresTotales.agregarDelante(provedorA);
                Controlador.ArbolProveedoresTotales.insert(ArbolProveedoresTotales.getRoot(), p);

                counter++;
            }
            //multiplicador de data en tiempo de ejecucion

            while (counter2 <= 9900) {

                //Proveedor provedorB = new Proveedor(rs.getInt("llave") + counter2, rs.getString("nombre"));
                Proveedor p1
                        = new Proveedor(rs.getInt("id") + counter2,
                                rs.getString("nombre"));

                //Controlador.ProvedoresTotales.agregarDelante(provedorB);
                Controlador.ArbolProveedoresTotales.insert(ArbolProveedoresTotales.getRoot(), p1);
                counter2++;

            }

            System.out.println("MySQL connection successfully proveedores");
            counter2 = 0;
            counter = 1;

            System.out.println(Controlador.ArbolProveedoresTotales.getSize());

        } catch (Exception e) {
            System.out.println("Error: " + e);
            System.out.println("No se ha logrado conectar con MySQL. Esto "
                    + "no afecta el funcionamiento del programa");
        }

        try {

            st = con.conex.createStatement();

            rs = st.executeQuery("select * from empleado");

            while (rs.next() && counter <= 299) {
                //entran 1000 datos
                //System.out.println(rs.getInt("total"));

                //Proveedor provedorA = new Proveedor(rs.getInt("llave"), rs.getString("nombre"));
                Empleado e = new Empleado(rs.getInt("idDocumento"),
                        Controlador.almacen,
                        123456,
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("fechaNacimiento"),
                        rs.getString("telefono"),
                        rs.getString("contrasena"),
                        "empleado"
                );
                //Controlador.ProvedoresTotales.agregarDelante(provedorA);
                Controlador.ArbolEmpleadosTotales.insert(ArbolEmpleadosTotales.getRoot(), e);

                counter++;
            }
            //multiplicador de data en tiempo de ejecucion

            while (counter2 <= 9700) {

                //Proveedor provedorB = new Proveedor(rs.getInt("llave") + counter2, rs.getString("nombre"));
                Empleado e = new Empleado(rs.getInt("idDocumento") + counter2,
                        Controlador.almacen,
                        12345,
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("fechaNacimiento"),
                        rs.getString("telefono"),
                        rs.getString("contrasena"),
                        "empleado"
                );
                //Controlador.ProvedoresTotales.agregarDelante(provedorA);
                Controlador.ArbolEmpleadosTotales.insert(ArbolEmpleadosTotales.getRoot(), e);
                counter2++;

            }

            System.out.println("MySQL connection successfully empleados");
            counter2 = 0;
            counter = 1;

            System.out.println(Controlador.ArbolEmpleadosTotales.getSize());
            con.conex.close();

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
