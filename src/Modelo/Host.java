/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Excepcion.ExceptionIPFixed;

/**
 *
 * @author matuuar
 */
public class Host {
    
    private String nombre;
    private Mac mac;
    private Ip ip;
    private int id;
    

    public Host(String nombre, String mac, String ip) throws ExceptionIPFixed {
        this.nombre = nombre;
        this.mac = new Mac(mac);
        this.ip = new Ip(ip);
    }

    public Host() {
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Host other = (Host) obj;
        if ((this.mac == null) ? (other.mac != null) : !this.mac.equals(other.mac)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + (this.mac != null ? this.mac.hashCode() : 0);
        return hash;
    }
    
    @Override
    public String toString(){
        String s="host ";
        s+=nombre+" {\n";
        s+="\thardware ethernet "+mac.con2Puntos()+";\n";
        s+="\tfixed-address "+ip+";\n"+"}\n";
        return s;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIp() {
        return ip.toString();
    }

    public void setIp(String ip) throws ExceptionIPFixed {
        this.ip = new Ip(ip);
    }

    public String getMac() {
        return mac.getMac();
    }
    public String getMacCon2Puntos(){
        return mac.con2Puntos();
    }

    public void setMac(String mac) {
        this.mac =new Mac(mac);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
