/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import org.jdom.Element;
/**
 *
 * @author matuuar
 */
public class Nodo  extends Element{
  public Nodo(Host name) {
    super("host");
    addContent(new Element("id").setText(Integer.toString(name.getId())));
    addContent(new Element("nombre").setText(name.getNombre()));
    addContent(new Element("mac").setText(name.getMac()));
    addContent(new Element("ip").setText(name.getIp()));
  }
}