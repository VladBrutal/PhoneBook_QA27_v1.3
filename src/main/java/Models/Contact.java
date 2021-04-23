package Models;

public class Contact {
    String name;
    String lastName;
    String phone;
    String email;
    String address;
    String description;

    public String getName() {
        return name;
    }

    public Contact withName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Contact withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Contact withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Contact withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Contact withAddress(String address) {
        this.address = address;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Contact withDescription(String description) {
        this.description = description;
        return this;
    }


}
