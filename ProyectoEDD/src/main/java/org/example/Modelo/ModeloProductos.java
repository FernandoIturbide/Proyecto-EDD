package org.example.Modelo;
import java.util.ArrayList;
import java.sql.SQLException;
import javax.swing.table.TableModel;
import javax.swing.event.TableModelListener;

import org.example.DBase.ProductosDAO;

public class ModeloProductos extends ProductosDAO implements TableModel{
    public static final int COLUMNAS=3;
    private ProductosDAO productosDAO;
    private ArrayList <Productos> productos;

    public ModeloProductos() {
        productosDAO=new ProductosDAO();
        productos=new ArrayList<>();
    }
    public ModeloProductos(ArrayList<Productos> productos) {
        this.productos = productos;
        productosDAO=new ProductosDAO();
    }

    @Override
    public int getRowCount() {
        return productos.size();
    }
    @Override
    public int getColumnCount() {
        return COLUMNAS;
    }
    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "ID";
            case 1:
                return "Producto";
            case 2:
                return "Precio";
        }
        return null;
    }
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class; // ID
            case 1:
                return String.class; // Producto
            case 2:
                return Double.class; // Precio
        }
        return null;
    }
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Productos producto=productos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return producto.getId();
            case 1:
                return producto.getNombre();
            case 2:
                return producto.getPrecio();
        }
        return null;
    }
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:

                break;
            case 1:
                productos.get(rowIndex).setNombre((String) aValue);
                break;
            case 2:
                productos.get(rowIndex).setPrecio((Double) aValue);
                break;
            default:
                System.out.println("No se modificó nada");
        }
    }
    @Override
    public void addTableModelListener(TableModelListener l) {
        
    }
    @Override
    public void removeTableModelListener(TableModelListener l) {
        
    } 
    public void cargarDatos(){
        try {
            ArrayList <Productos> productos=productosDAO.obtenerTodo();
            System.out.println(productos);
            productos=productosDAO.obtenerTodo();
        } catch (SQLException ex) {
            System.out.println("Error al cargar datos");
        }
    }
    public boolean insertar(Productos producto){
        boolean insertado=false;
        try {
            if (productosDAO.insertar(producto)) {
                productos.add(producto);
                insertado=true;
            }else{
                insertado=false;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return insertado;
    }

    public Productos getPriProductos(int index) {
        return productos.get(index);
    }
    
}
