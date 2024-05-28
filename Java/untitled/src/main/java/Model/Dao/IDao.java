package Model.Dao;

import java.sql.SQLException;
import java.util.ArrayList;

    public interface IDao<E,I> {
        public int add(E e) throws SQLException;
        public int delete(Integer e);
        public int update(E e);
        public ArrayList<E> findAll(E e);
    }


