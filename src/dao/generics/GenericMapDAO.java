package dao.generics;

import domain.Customer;
import domain.IRemain;

import java.util.HashMap;
import java.util.Map;

public abstract class GenericMapDAO<T extends IRemain> implements  IGenericDAO<T>{

    private Map<Long, T> database;


    public GenericMapDAO(){
        if(this.database == null){
            this.database = new HashMap<>();
        }
    }


    public abstract void getUpdateStyle(T entity, T entityInDatabase);

    @Override
    public Boolean create(T entity) {
        T object = database.get(entity.getCode());
        if(object == null){
            database.put(entity.getCode(), entity);
            return true;
        }
        return false;
    }

    @Override
    public T read(Long code) {
        return database.get(code);
    }

    @Override
    public void update(T entity) {
        T entityInDatabase = database.get(entity.getCode());
        getUpdateStyle(entity, entityInDatabase);
    }

    @Override
    public Boolean delete(Long code) {
        T entity = database.get(code);
        if(entity != null){
            database.remove(code, entity);
            return true;
        }
        return false;
    }


}
