/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Excepcion.ExceptionIPFixed;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author matuuar
 */
public class HostModel extends AbstractTableModel {

    private LinkedList datos = new LinkedList();
    private LinkedList listeners = new LinkedList();

    public HostModel() {
        super();
    }

    public void vaciar() {
        datos.clear();
        TableModelEvent evento;
        evento = new TableModelEvent(this, 0, this.getRowCount(), TableModelEvent.ALL_COLUMNS, TableModelEvent.DELETE);

        avisaSuscriptores(evento);

    }

    public void addHost(Host h) {
        // Añade la persona al modelo
        datos.add(h);

        TableModelEvent evento;
        evento = new TableModelEvent(this, this.getRowCount() - 1,
                this.getRowCount() - 1, TableModelEvent.ALL_COLUMNS,
                TableModelEvent.INSERT);

        avisaSuscriptores(evento);

    }
    public void cargarHosts(ArrayList<Host> h){
        for(int i=0;i<h.size();i++){
            addHost(h.get(i));
        }
    }

    @Override
    public Object getValueAt(int row, int col) {
        Host aux;

        aux = (Host) (datos.get(row));

        switch (col) {

            case 0:
                return aux.getId();
            case 1:
                return aux.getNombre();
            case 2:
                return aux.getIp();
            case 3:
                return aux.getMacCon2Puntos();
            default:
                return null;
        }
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;

            default:
                return String.class;
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        /*int ,banco, plaza,num_cheque, importe  pers_pago, pers_entregado,fecha_cobro comentario;*/
        switch (columnIndex) {
            case 0:
                return "ID";
            case 1:
                return "Nombre";
            case 2:
                return "IP";
            case 3:
                return "MAC°";


            default:
                return null;
        }
    }

    public void insertarFila(Host value, int row) {


        datos.remove(row);
        datos.add(row, value);
        TableModelEvent evento = new TableModelEvent(this, row, row, TableModelEvent.ALL_COLUMNS);
        avisaSuscriptores(evento);
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        Host aux;

        aux = (Host) (datos.get(row));
        try {
            switch (col) { /*int ,banco, plaza,num_cheque, importe  pers_pago, pers_entregado,fecha_cobro comentario;*/
                case 0:
                    aux.setId((Integer) value);
                    break;
                case 1:
                    aux.setNombre((String) value);
                    break;
                case 2:
                    try {
                        aux.setIp((String) value);
                    } catch (ExceptionIPFixed ex) {
                        Logger.getLogger(HostModel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 3:
                    aux.setMac(((String) value));
                    break;

            }
        } catch (IllegalArgumentException ex) {
        }
        TableModelEvent evento = new TableModelEvent(this, row, row, col);
        avisaSuscriptores(evento);


    }

    @Override
    public int getRowCount() {

        return datos.size();
    }

    public Host getFila(int row) {
        return (Host) (datos.get(row));
    }


    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    @Override
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        
            return false;
        
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        // Añade el suscriptor a la lista de suscriptores
        listeners.add(l);
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        // Elimina los suscriptores.
        listeners.remove(l);
    }

    private void avisaSuscriptores(TableModelEvent evento) {
        int i;

        // Bucle para todos los suscriptores en la lista, se llama al metodo
        // tableChanged() de los mismos, pasándole el evento.
        for (i = 0; i < listeners.size(); i++) {
            ((TableModelListener) listeners.get(i)).tableChanged(evento);
        }
    }
}
