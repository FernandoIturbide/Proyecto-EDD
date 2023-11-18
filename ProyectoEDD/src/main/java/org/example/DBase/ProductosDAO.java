package org.example.DBase;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.example.Modelo.Productos;

import java.sql.ResultSet;

public class ProductosDAO implements IntefazDAO{
        public ProductosDAO() {
        }
    
        @Override
        public boolean insertar(Object o) throws SQLException {
            String sql = "INSERT INTO Productos (Producto,Precio) VALUES (?,?);";
            int rowCount=0;
            PreparedStatement pstm= Singleton.getInstance("Precios.db").getConnection().prepareStatement(sql);
            pstm.setString(1,((Productos)o).getNombre());
            pstm.setDouble(2,((Productos)o).getPrecio());
            rowCount=pstm.executeUpdate();
            return rowCount>0;

        }
    
        @Override
        public boolean update(Object o) throws SQLException{
            String sql = "UPDATE Productos SET Producto=?,Precio=? WHERE id=?;";
            int rowCount=0;
            PreparedStatement pstm= Singleton.getInstance("Precios.db").getConnection().prepareStatement(sql);
            pstm.setString(1,((Productos)o).getNombre());
            pstm.setDouble(2,((Productos)o).getPrecio());
            pstm.setInt(3,((Productos)o).getId());
            rowCount=pstm.executeUpdate();
            return rowCount>0;
        }
    
        @Override
        public boolean delete(String o) throws SQLException {
            String sql = "DELETE FROM Productos WHERE id=?;";
            int rowCount=0;
            PreparedStatement pstm= Singleton.getInstance("Precios.db").getConnection().prepareStatement(sql);
            pstm.setInt(1,Integer.parseInt(o));
            rowCount=pstm.executeUpdate();
            return rowCount>0;
        }
        public ArrayList obtenerTodo() throws SQLException {
            String sql = "SELECT * FROM Productos";
            ArrayList<Productos> productos=new ArrayList<>();
            PreparedStatement pstm= Singleton.getInstance("Precios.db").getConnection().prepareStatement(sql);
            ResultSet rs=pstm.executeQuery();
            while (rs.next()){
                productos.add(new Productos(rs.getInt("id"),rs.getString("Producto"),rs.getDouble("Precio")));
            }
            return productos;
        }
    
        @Override
        public Object buscarPorID(String id)  throws SQLException {
            String sql = "SELECT * FROM Productos WHERE id=?;";
            Productos productos=null;
            PreparedStatement pstm= Singleton.getInstance("Precios.db").getConnection().prepareStatement(sql);
            pstm.setString(1,id);
            ResultSet rs=pstm.executeQuery();
            while (rs.next()){
                productos=new Productos(rs.getInt("id"),rs.getString("Producto"),rs.getDouble("Precio"));
                return productos;
            }
            return null;
        }
    
}
