package domain;

public class Customer {

    private String name;
    private Long cpf;
    private Long phoneNumber;
    private String address;
    private Integer houseNumber;
    private String city;
    private String state;

    public Customer(String name, Long cpf, Long phoneNumber, String address, Integer houseNumber, String city, String state){
        this.name = name;
        this.cpf = cpf;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.houseNumber = houseNumber;
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

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
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
}
