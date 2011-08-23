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
public final class Ip {

    int uno, dos, tre, cua;
    String ip;

    public int getCuatro() {
        return cua;
    }

    public void setCuatro(int cuatro) {
        this.cua = cuatro;
    }

    public int getDos() {
        return dos;
    }

    public void setDos(int dos) {
        this.dos = dos;
    }

    public int getTres() {
        return tre;
    }

    public void setTres(int tres) {
        this.tre = tres;
    }

    public int getUno() {
        return uno;
    }

    public void setUno(int uno) {
        this.uno = uno;
    }

    public Ip() {
    }

    public Ip(String ip) {
        this.ip=parserToInt(ip);
    }

    public String parserToInt(String ip) {
        int op=0;
        String s1="",s2="",s3="",s4="";
        for(int i=0;i<ip.length();i++){
            if(ip.charAt(i)=='.'){
                op++;
            }else{
                switch(op){
                    case 0:
                        s1+=ip.charAt(i);
                        break;
                    case 1:
                        s2+=ip.charAt(i);
                        break;
                    case 2:
                        s3+=ip.charAt(i);
                        break;
                    case 3:
                        s4+=ip.charAt(i);
                        break;
                        
                }
            }
                
        }
        try{
            uno = verificar(Integer.parseInt(s1));
            dos = verificar(Integer.parseInt(s2));
            tre = verificar(Integer.parseInt(s3));
            cua = verificar(Integer.parseInt(s4));
        } catch (NumberFormatException er) {
             new ExceptionIPFixed("Dirección IP mal formada.\n"
                                                        + "El formato es el siguiente: AAA.BBB.CCC.DDD.");
        }
        ip=uno + "." + dos + "." + tre + "." + cua;
        return ip;
        
    }
    private int verificar(int i){
        if(i<0){
            i=i*-1;
        }
        if(i>255){
            i=255;
        }
        return i;
    }

    @Override
    public String toString() {
        return uno + "." + dos + "." + tre + "." + cua;
    }

    public String nextIP() {

        cua++;
        if (cua > 254) {
            cua = 1;
            tre++;
            if (tre > 254) {
                tre = 1;
                dos++;
                if (dos > 254) {
                    dos = 1;
                    uno = (uno + 1) % 223;
                }
            }
        }
        ip= uno + "." + dos + "." + tre + "." + cua;
        return ip;
    }
}
