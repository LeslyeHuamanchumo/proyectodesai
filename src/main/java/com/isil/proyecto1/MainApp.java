package com.isil.proyecto1;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class MainApp {

    /* Creamos primer "Hola Mundo" */
    /* Nos conectamos a la base de datos */

    public static void main(String[] args) throws Exception {

        //System.out.println("Hello World!");

        // 1. Cargar driver
        // Instanciamos el driver
        // Vamos a utilizar MySQL JDBC Driver

        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. Crear conexion
        // Creamos el objeto "conexión"
        // Este método recibe la URL, password y el usuario

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test", "root", "123jtm91.");

        /*

        3. Crear statement
        Creamos el statement que es el objeto que nos va a ayudar a ejecutar sql

        Statement stmt = con.createStatement();

        4. Ejecutar query
        También podemos hacer un update desde aquí:
        Le estamos diciendo al programa que antes de mostrar la información de Messi, la actualice.

        int resultUpdate = stmt.executeUpdate("update Users set city='Rosario' where name ='Messi'");

        ResultSet result = stmt.executeQuery("select * from Users");

        ResultSet result = stmt.executeQuery("select * from Users where name='Messi'");   // también se puede consultar por nombre

        5. Recorrer resultados

        while(result.next()){ // mientras haya un resultado, paso al sgte
            System.out.println(result.getString("idUser"));
            System.out.println(result.getString("name"));
            System.out.println(result.getString("phone"));
            System.out.println(result.getString("city"));
        }

        Para obtener una determinada columna de la tabla

        while(result.next()){
            System.out.println(result.getString(1));
            System.out.println(result.getString(2));
            System.out.println(result.getString(3));
         }

        */

        /* ========================================================================================================= */

        /*

        Statement stmt2 = con.createStatement();

        ResultSet resultSet = stmt2.executeQuery("select * from Users where name='Ronaldo'");

        while(resultSet.next()){
            System.out.println(resultSet.getString("name") + "\n" +
                    resultSet.getString("phone") + "\n" +
                    resultSet.getString("city"));
        }

        */

        /* ========================================================================================================== */

        /*

        PreparedStatement preparedStatement = con.prepareStatement("select * from Users where name=? and city=?");

        // Aquí estamos diciendo que la primera variable sea Cueva y que sea de Lima.
        preparedStatement.setString(1, "Cueva");
        preparedStatement.setString(2, "Lima");

        ResultSet resultSet2 = preparedStatement.executeQuery();

        while(resultSet2.next()) {
            System.out.println(resultSet2.getString("name") + "\n" +
                    resultSet2.getString("phone") + "\n" +
                    resultSet2.getString("city"));
        }

        */

        /* ========================================================================================================== */

        /*

        Statement stCreate = con.createStatement();

        int filasAfectadas = stCreate.executeUpdate("insert into Users values (5, 'Maria', '922335555','Quito')");

        System.out.println("Filas afectadas: " + filasAfectadas);

        PreparedStatement preparedStatement = con.prepareStatement("select * from Users where name=?");

        preparedStatement.setString(1, "Maria");

        ResultSet resultSet2 = preparedStatement.executeQuery();

        while(resultSet2.next()) {
            System.out.println(resultSet2.getString("name") + "\n" +
                    resultSet2.getString("phone") + "\n" +
                    resultSet2.getString("city"));
        }

        // 3.1 Statement de mantenimiento

        // Statement stCreate = con.createStatement();
        // int filasAfectadas = stCreate.executeUpdate("insert into Users values (5, 'Maria', '922335555','Quito')");
        // System.out.println("Filas afectadas: " + filasAfectadas);

        // 3.2 Statement de consulta

        //PreparedStatement preparedStatement = con.prepareStatement("select * from Users where name=?");
        // preparedStatement.setString(1, "Maria");
        // ResultSet resultSet2 = preparedStatement.executeQuery();

        */

        /* ======================================================================================================== */

        Statement stCreate = con.createStatement();

        int filasAfectadas = stCreate.executeUpdate("update Users set name='Juan' where idUser=1");

        System.out.println("Filas afectadas: " + filasAfectadas);

        PreparedStatement preparedStatement = con.prepareStatement("select * from Users where idUser=?");

        preparedStatement.setInt(1, 1);  // setInt porque estamos ajustando el id que es un entero

        ResultSet resultSet2 = preparedStatement.executeQuery();

        while(resultSet2.next()) {
            System.out.println(resultSet2.getString("name") + "\n" +
                    resultSet2.getString("phone") + "\n" +
                    resultSet2.getString("city"));
        }


        // 6. Cerrar conexión
        con.close();

    }
}

