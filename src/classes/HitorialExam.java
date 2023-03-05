/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Dell
 */
public class HitorialExam {

    public static HashMap<String, ArrayList<String>> historialExam = new HashMap<String, ArrayList<String>>();
    

    public static void load() {

        try {
            String ruta_archivo = System.getProperty("user.dir") + "/hitorialExam.dat";

            //Stream para leer archivo
            ObjectInputStream file = new ObjectInputStream(new FileInputStream(ruta_archivo));
            //Se lee el objeto de archivo y este debe convertirse al tipo de clase que corresponde
            Conexion Conex = (Conexion) file.readObject();

            //se cierra archivo
            file.close();
            //Se utilizan metodos de la clase asi como variables guardados en el objeto
            try {

                ArrayList keys = (ArrayList) (List) Conex.getNombreObjeto().get(0);
//ArrayList values = (ArrayList) (List) Conex.getNombreObjeto().get(1);
                List values = (ArrayList<String>) (List) Conex.getNombreObjeto().get(1);

                int i = 0;
                for (Object k : keys) {

                    ArrayList<String> lista = (ArrayList<String>) values.get(i);

                    historialExam.put(k.toString(), lista);

                    i++;

                }

            } catch (IllegalArgumentException e) {

                System.out.println(e);
            }

        } catch (ClassNotFoundException ex) {
            System.out.println(ex);

        } catch (IOException ex) {

            System.out.println(ex);

        }

    }

    public static void save() {

        String ruta_archivo = System.getProperty("user.dir") + "/hitorialExam.dat";

        try {

            Set<String> keySet = historialExam.keySet();
            Collection<ArrayList<String>> values = historialExam.values();

            List lista = new ArrayList();

            ArrayList<String> listOfKeys = new ArrayList<String>(keySet);


            ArrayList<Object> datos = new ArrayList<>();

            for (ArrayList<String> his : values) {

                datos.add(his);

            }

//      System.out.println(datos);
            lista.add(listOfKeys);
            lista.add(datos);

            Conexion Conex = new Conexion(lista);
            //Se crea un Stream para guardar archivo
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(ruta_archivo));
            //Se escribe el objeto en archivo
//            System.out.println(lista); 
            file.writeObject(Conex);
            //se cierra archivo

            file.close();

        } catch (IOException ex) {
            System.out.println(ex);

        }

    }

}
