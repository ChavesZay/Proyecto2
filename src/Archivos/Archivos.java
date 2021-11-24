/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chave
 */
public class Archivos {
    private File file;
    private FileReader fr;
    private FileWriter fw;
    private BufferedReader br;
    private BufferedWriter bw;

    public Archivos(String ruta) throws IOException {
       
        this.file = new File(ruta);
        if(!this.validar()){
            throw new NullPointerException();
            
        }
    }   
    public boolean validar(){
        if(this.existe()){
            return this.file.isFile();
        }else{
            try {
                return this.crear();
            } catch (IOException ex) {
                Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean crear() throws IOException {
        return this.file.createNewFile();
    }
    
    public void eliminar() {
        if(this.existe()){
             this.file.delete();
        }
       
    }
     public boolean existe(){
        return this.file.exists();
    }
     
    public void abrir() throws FileNotFoundException, IOException {
      this.fr = new FileReader(this.file,Charset.forName("ISO-8859-1"));
      //Charset.forName("ISO-8859-1") formato de escritura en español
      this.fw = new FileWriter(this.file,true);
      this.br = new BufferedReader(fr);
      this.bw = new BufferedWriter(fw);
    }
    public void cerrar() throws IOException{
      this.br.close();
      this.bw.close();
      this.fr.close();
      this.fw.close();
    }
    
    public String leer() throws IOException{
        return this.br.readLine();
    }
    public void escribir(String linea) throws IOException {
        this.bw.write(linea);
    }
    public void guardar() throws IOException {
        this.bw.flush();
    }
     public int getCantidadLineas() throws IOException {
         return (int)br.lines().count();
    }
    public double getTamano(){
        return (double) (this.file.length()/1048576);
    }
    public Date getFechaModificacion(){
       return  new Date(this.file.lastModified());
    }  
   
}
