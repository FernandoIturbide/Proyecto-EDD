package org.example.DBase;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IntefazDAO {
    public abstract boolean insertar(Object o) throws SQLException;
    public abstract boolean update(Object o) throws SQLException;
    public abstract boolean delete (String o)throws SQLException;
    public abstract ArrayList obtenerTodo() throws SQLException;
    public abstract Object buscarPorID(String id) throws SQLException;
}