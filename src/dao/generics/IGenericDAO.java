package dao.generics;

import domain.IRemain;

public interface IGenericDAO<T extends IRemain> {
    public Boolean create(T entity);
    public T read(Long cpf);
    public void update(T entity);
    public Boolean delete(Long cpf);
}
