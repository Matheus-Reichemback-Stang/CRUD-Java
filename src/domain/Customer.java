package domain;

public class Customer implements IRemain {

    private String name;
    private Long cpf;
    private Long phoneNumber;
    private String address;
    private Integer addressNumber;
    private String city;
    private String state;

    public Customer(String name, String cpf, String phoneNumber, String address, String addressNumber, String city, String state){
        this.name = name;
        this.cpf = Long.valueOf(cpf);
        this.phoneNumber = Long.valueOf(phoneNumber);
        this.address = address;
        this.addressNumber = Integer.valueOf(addressNumber);
        this.city = city;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCpf() {
        return cpf;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(Integer addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", cpf=" + cpf +
                ", phoneNumber=" + phoneNumber +
                ", address='" + address + '\'' +
                ", addressNumber=" + addressNumber +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
