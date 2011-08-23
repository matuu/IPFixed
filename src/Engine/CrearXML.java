/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;


import Modelo.Host;
import Modelo.Nodo;
import java.io.*;
import java.util.ArrayList;
import org.jdom.*;
import org.jdom.output.*;

/**
 *
 * @author matuuar
 */
public class CrearXML {

    public CrearXML(){
        
    }
    public CrearXML(String file, Host h) {

        Element root = new Element("config");

        Element datos = new Nodo(h);
        root.addContent(datos);
        Document doc = new Document(root);//Creamos el documento
        try {
            XMLOutputter out = new XMLOutputter();
            FileOutputStream salida = new FileOutputStream(file);
            out.output(doc, salida);
            salida.flush();
            salida.close();
            //out.output(doc, System.out);
        } catch (Exception e) {

        }
    }
        public boolean guardar(String file, ArrayList<Host> hosts) {

        Element root = new Element("config");
        for(int i=0;i<hosts.size();i++){
            Element datos = new Nodo((Host)hosts.get(i));
            root.addContent(datos);
        }
                
        Document doc = new Document(root);//Creamos el documento
        try {
            XMLOutputter out = new XMLOutputter();
            FileOutputStream salida = new FileOutputStream(file);
            out.output(doc, salida);
            salida.flush();
            salida.close();
            return true;
            //out.output(doc, System.out);
        } catch (Exception e) {
            return false;
        }
    }
        public boolean guardar(File file, ArrayList<Host> hosts) {

        Element root = new Element("config");
        for(int i=0;i<hosts.size();i++){
            Element datos = new Nodo((Host)hosts.get(i));
            root.addContent(datos);
        }
                
        Document doc = new Document(root);//Creamos el documento
        try {
            XMLOutputter out = new XMLOutputter();
            FileOutputStream salida = new FileOutputStream(file.getName());
            out.output(doc, salida);
            salida.flush();
            salida.close();
            return true;
            //out.output(doc, System.out);
        } catch (Exception e) {
            return false;
        }
    }
        
}

