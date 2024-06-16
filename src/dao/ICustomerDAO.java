package dao;

import domain.Customer;

public interface ICustomerDAO {

    public Boolean create(Customer customer);
    public Customer read(Long cpf);
    public void update(Customer customer);
    public Boolean delete(Long cpf);
}
