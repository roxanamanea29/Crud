package org.example;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Roxana
 * @date 04/04/2024
 */
public class GestorTarea {
      Conexion con = new Conexion(); //llamada al archivo donde se guarda la conexion con la BD
    public void anadirTarea(Tarea tarea) {//metodo para guardar la tarea
      try(  Statement consulta = con.conectar().createStatement()) {//statment ejecuta la consulta mysql que tenemos guardad en Conexion → con
          String cadena = "INSERT INTO Tarea(nombre, descripcion, realizada, prioridad) VALUES('"
                  + tarea.getNombre() + "','"
                  + tarea.getDescripcion() + "','"
                  + tarea.getRealizada() + "','"
                  + tarea.getPrioridad() + "') ";

          consulta.executeUpdate(cadena);//la execución de la cadena


      }catch (SQLException e){
          System.out.println("Error al añadir la tarea. " +e.getMessage());
      }

    }

    public List<Tarea> listarAllTareas() throws SQLException {//
        List<Tarea> listaT = new ArrayList<>();
        Statement consulta = con.conectar().createStatement();
        ResultSet result = consulta.executeQuery("SELECT * FROM Tarea");
        while (result.next()){
            Tarea tarea = new Tarea(
                    result.getInt("id"),
                    result.getString("nombre"),
                    result.getString("descripcion"),
                    result.getString("realizada"),
                    result.getString("prioridad")
            );
            listaT.add(tarea);
        }
        result.close();
        consulta.close();//se cierra la ejecucion despues de ejecutar  la consulta
        return listaT;
    }
    public static void modificarTarea( Tarea x) throws SQLException {// el método actualiza los campos de una tarea específica en la base de datos utilizando el ID proporcionado.
        Conexion con = new Conexion(); //se accede a la base de datos a travez de una conexion
        Statement consulta = con.conectar().createStatement();
        //Statement ejecuta la consulta mysql

        String cadena = "UPDATE tarea SET nombre ='" //se utiliza una cadena de tipo String para actualizar los datos existentes con unos nuevos  valores
                + x.getNombre() + "', descripcion = '"
                + x.getDescripcion() + "', realizada = '"
                + x.getRealizada() + "', prioridad = '"
                + x.getPrioridad() + "' WHERE  id = " + x.getId();

        consulta.executeUpdate(cadena);
        //consulta.close();//se cierra la ejecucion despues de ejecutar  la consulta

    }
    public Tarea buscar(int id) throws SQLException {//se utiliza el método buscar para buscar una tarea en la base de datos
        String query = "SELECT * FROM tarea WHERE id =?";//utilizando esta query se busca una cioncidencia por id.
        PreparedStatement consulta  = con.conectar().prepareStatement(query);//PreparedStatment crea un objeto llamado consulta a partir  de la conexion con la base de datos
        consulta.setInt(1, id); //se establece el valor en 1
        ResultSet results =consulta.executeQuery();// se utiliza resultset para para ejecutar la consulta lla preparada.
        Tarea tarea = null; //se inicializa la variable tarea como null
        if (results.next()) { //utilizando un if con el metodo next para poder avanzar a la siguiente registro
            tarea = new Tarea( // se crea un  nueva instancia de la tarea
                    results.getInt("id"),
                    results.getString("nombre"),
                    results.getString("descripcion"),
                    results.getString("realizada"),
                    results.getString("prioridad")
            );
        }
        results.close();// se cierra la ejecucion de results
        consulta.close();//se cierra la ejecucion de la consulta
        return tarea; // se devuelve el objeto tarea con los datos obtenidos
    }

    public void eliminar(int id) throws SQLException{ //se utiliza el metodo elimnar para eliminar una instancia guardada en  la base de datos
        Statement consulta = con.conectar().createStatement();
        consulta.executeUpdate( "DELETE FROM tarea WHERE id = " +id);//se utiliza query delete para eliminar la tarea con el id especificado
        consulta.close();
    }
}

