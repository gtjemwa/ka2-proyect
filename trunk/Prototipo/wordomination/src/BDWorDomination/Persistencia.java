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
    //Retorna un arrayList con la información solicitada en la query.
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
    public void updateRowSQL(String query){}
    public void deleteRowSQL(String query){}
    public void alterTableSQL(String query){}
    public void dropTableSQL(String query){}


    private final String url = "jdbc:mysql://186.84.6.33:3306/bdwordomination";
    private final String user = "netbeans";
    private final String password = "adminadmin";

    public static void main(String args[]){
        Persistencia p = new Persistencia();
        ArrayList al = new ArrayList();
        try {
            al = p.selectSQL("select * from usuario ",1);
            
        } catch (SQLException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(al.size());
        System.out.println(al);
    }
}
