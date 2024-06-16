package dao;

import domain.Customer;

import java.util.HashMap;
import java.util.Map;

public class CustomerMapDAO implements ICustomerDAO {
    private Map<Long, Customer> database = new HashMap<>();

    @Override
    public Boolean create(Customer customer) {
        Customer object = database.get(customer.getCpf());
        if(object == null){
            database.put(customer.getCpf(), customer);
            return true;
        }
        return false;

    }

    @Override
    public Customer read(Long cpf) {
        return database.get(cpf);
    }

    @Override
    public void update(Customer customer) {
        Customer object = database.get(customer.getCpf());
        object.setName(customer.getName());
        object.setPhoneNumber(customer.getPhoneNumber());
        object.setAddress(customer.getAddress());
        object.setAddressNumber(customer.getAddressNumber());
        object.setCity(customer.getCity());
        object.setState(customer.getState());
    }

    @Override
    public Boolean delete(Long cpf) {
        Customer object = database.get(cpf);
        if(object != null){
            database.remove(cpf, object);
            return true;
        }
        return false;
    }
}
