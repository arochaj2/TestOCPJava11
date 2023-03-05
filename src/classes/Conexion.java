/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author Dell
 */
import java.io.Serializable;
import java.util.List;



/**
 *
 * @author jose
 */

@SuppressWarnings({"rawtypes","serial","unchecked","static"})
public class Conexion implements Serializable {
    

    private final List<Object> Data;

    /* Constructor de la clase */
    public Conexion(List Data){
        this.Data = Data;
        
        
    }

    public List getNombreObjeto()
    {
        return this.Data;
    }

    
    
}
