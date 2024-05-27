package Model.Dao;

import java.util.ArrayList;

    public interface IDao<E,I> {
        public int add(E e);
        public int delete(Integer e);
        public int update(E e);
        public ArrayList<E> findAll(E e);
    }


