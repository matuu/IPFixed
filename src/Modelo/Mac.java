/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author matuuar
 */
public class Mac {
    
    String mac;

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public Mac() {
    }

    public Mac(String mac) {
        this.mac = mac;
    }
    public String con2Puntos(){
        String temp="";
        if(mac.length()==12){
            for(int i=0;i<12;i++){
                if(i%2==0&&i!=0){
                    temp+=":";
                }
                
                temp+=mac.charAt(i);
                
            }
        }
        return temp;
    }
    public String conGuion(){
        String temp="";
        if(mac.length()==12){
            for(int i=0;i<12;i++){
                if(i%2==0){
                    temp+="-";
                }    
                temp+=mac.charAt(i);
                
            }
        }
        return temp;
    }
    
    @Override
    public String toString(){
            return mac;
    }
    
    
}
