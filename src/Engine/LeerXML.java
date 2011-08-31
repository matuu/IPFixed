/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import Excepcion.ExceptionIPFixed;
import Modelo.Host;
import ipfixed.Main;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

/**
 *
 * @author matuuar
 */
public class LeerXML {

    private Document doc = null;

    public LeerXML() {
    }

    public boolean open(File f)  {
        SAXBuilder builder = new SAXBuilder(false);
        try {

            if (f.canRead()) {

                doc = builder.build(f);
                Element raiz = doc.getRootElement();
                List nodos = raiz.getChildren("host");
                Iterator i=nodos.iterator();
                int id=Main.getId();
                ArrayList<Host> hosts= Main.getHost();
                while(i.hasNext()){
                    Element n=  (Element) i.next();
                    Host h= new Host();
                    
                    h.setIp(n.getChild("ip").getText());
                    h.setNombre(n.getChild("nombre").getText());
                    h.setMac(n.getChild("mac").getText());
                    h.setId(id);
                    id++;
                    hosts.add(h);
                    //System.out.print(h);
                }
                Main.setHost(hosts);
                Main.setId(id);
            }
        } catch (JDOMException ex) {
            Logger.getLogger(LeerXML.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(LeerXML.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch ( ExceptionIPFixed ex){
            return false;
        }

        return true;

    }
}
