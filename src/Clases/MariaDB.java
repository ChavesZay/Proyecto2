/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author jordy
 */
public class MariaDB extends BaseDatos{
    
    public MariaDB( String servidor, String base, String uauario, String contrasenia) {
        super("com.mysql.cj.jdbc.Driver", "jdbc", "mysql", servidor, base, uauario, contrasenia);
    }
    
}
