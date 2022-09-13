package com.isil.proyecto1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainApp {

    /* Creamos primer "Hola Mundo" */
    /* Nos conectamos a la base de datos */

    public static void main(String[] args) throws Exception {
        //System.out.println("Hello World!");

        // Instanciamos el driver
        // Vamos a utilizar MySQL JDBC Driver

        Class.forName("com.mysql.cj.jdbc.Driver");

        // Creamos el objeto "conexión"
        // Este método recibe la URL, password y el usuario

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test", "root", "123jtm91.");

        // Creamos el statement que es el objeto que nos va a ayudar a ejecutar sql

        Statement stmt = con.createStatement();

        // También podemos hacer un update desde aquí:
        // Le estamos diciendo al programa que antes de mostrar la información de Messi, la actualice.

        int resultUpdate = stmt.executeUpdate("update Users set city='Rosario' where name ='Messi'");

        //ResultSet result = stmt.executeQuery("select * from Users");

        ResultSet result = stmt.executeQuery("select * from Users where name='Messi'");   // también se puede consultar por nombre

        while(result.next()){ // mientras haya un resultado, paso al sgte
            System.out.println(result.getString("idUser"));
            System.out.println(result.getString("name"));
            System.out.println(result.getString("phone"));
            System.out.println(result.getString("city"));
        }

        /* Para obtener una determinada columna de la tabla
         while(result.next()){
            System.out.println(result.getString(1));
            System.out.println(result.getString(2));
            System.out.println(result.getString(3));
         }
        */
    }
}

