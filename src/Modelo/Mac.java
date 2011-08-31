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

    public String getMacText() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public Mac() {
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mac other = (Mac) obj;
        if ((this.mac == null) ? (other.mac != null) : !this.mac.equals(other.mac)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + (this.mac != null ? this.mac.hashCode() : 0);
        return hash;
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
