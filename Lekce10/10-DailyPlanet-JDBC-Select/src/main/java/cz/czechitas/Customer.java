package cz.czechitas;

public class Customer {

    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private boolean deleted;
    private int version;

    public Customer() {
    }

    public Customer(Long id, String firstName, String lastName, String address, boolean deleted, int version) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.deleted = deleted;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long newValue) {
        id = newValue;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String newValue) {
        firstName = newValue;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String newValue) {
        lastName = newValue;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String newValue) {
        address = newValue;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean newValue) {
        deleted = newValue;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int newValue) {
        version = newValue;
    }

    @Override
    public String toString() {
        return "Customer " +
                "id=" + id + ", " +
                "firstName=\"" + firstName + "\"" + ", " +
                "lastName=\"" + lastName + "\"" + ", " +
                "address=\"" + address + "\"" + ", " +
                "deleted=" + deleted + ", " +
                "version=" + version;
    }
}
