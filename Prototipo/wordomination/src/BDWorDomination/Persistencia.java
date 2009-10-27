/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BDWorDomination;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**Es un interfaz con la cual los objetos de la aplicación logran persistencia
 *  con la base de datos.
 * @author Andrés
 */
public class Persistencia {
    
    public Persistencia(){
        try // Se inicializa el driver de conexión
        {DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());}
        catch (SQLException ex)
        {Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);}
    }
    //Retorna un arrayList con la información solicitada en la query y la columna 'column'.
    public ArrayList selectSQL(String query, int column) throws SQLException{
           ArrayList al = new ArrayList();
           Connection conexion = DriverManager.getConnection(url, user, password);
           Statement s = conexion.createStatement();
           ResultSet rs = s.executeQuery(query);
           if (rs.first()) al.add(rs.getObject(column));
           while(rs.next()){al.add(rs.getObject(column));}
           conexion.close();
           return al;
    }
    public void updateRowSQL(String query) throws SQLException{}
    public void deleteRowSQL(String query) throws SQLException{}
    public void alterTableSQL(String query) throws SQLException{
        Connection conexion = DriverManager.getConnection(url, user, password);
        Statement s = conexion.createStatement();
        s.executeUpdate(query);
        conexion.close();
    }

    public int getCantJugadores() throws SQLException{
           int num = 0;
           Connection conexion = DriverManager.getConnection(url, user, password);
           Statement s = conexion.createStatement();
           ResultSet rs = s.executeQuery("select * from mesajugadores ");
           if (rs.first()){
               if (rs.getObject(2)!= null) num = 1;
               if (rs.getObject(3)!= null) num = 2;
               if (rs.getObject(4)!= null) num = 3;
               if (rs.getObject(5)!= null) num = 4;
           }
           conexion.close();
           return num;
    }
    
        public ArrayList getNomJugadores() throws SQLException{
           ArrayList al = new ArrayList();
           Connection conexion = DriverManager.getConnection(url, user, password);
           Statement s = conexion.createStatement();
           ResultSet rs = s.executeQuery("select * from mesajugadores");
           if (rs.first()){
               if (rs.getObject(2)!= null) al.add(rs.getObject(2));
               if (rs.getObject(3)!= null) al.add(rs.getObject(3));
               if (rs.getObject(4)!= null) al.add(rs.getObject(4));
               if (rs.getObject(5)!= null) al.add(rs.getObject(5));
           }
           conexion.close();
           return al;
    }

    public void dropTableSQL(String query){}


    private final String url = "jdbc:mysql://186.84.6.33:3306/bdwordomination";
    private final String user = "netbeans";
    private final String password = "adminadmin";

    public static void main(String args[]){
        Persistencia p = new Persistencia();
        ArrayList al = new ArrayList();
        int a = 0;
        try {
            al = p.getNomJugadores();
            //al = p.getCantJugadores("select * from usuario ");
            //if (al.get(0) == null) System.out.println("entro al if");
            
        } catch (SQLException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(al.size());
        System.out.println(al);
    }
}
