package daobackup;

import java.util.List;

public interface IDAO<T,K> {
	
	public void insert(T t);
	
	public T findById(K id);
	
	public List<T> findAll();
	
	public void save(T t);
	
	public void deleteById(K id);
	
}

