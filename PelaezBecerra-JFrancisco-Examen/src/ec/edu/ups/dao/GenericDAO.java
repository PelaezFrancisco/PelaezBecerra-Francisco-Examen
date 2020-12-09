package ec.edu.ups.dao;

import java.util.List;

public interface GenericDAO<T, ID, EMAIL> {

    public void create(T entity);

    public T read(ID id);

    public void update(T entity);

    public void delete(T entity);

    public void deleteByID(ID id);
    
    public List<T> findAll();
    
    public T find_email(EMAIL email);
}

