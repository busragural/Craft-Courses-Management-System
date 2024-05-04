package management;

public abstract class Person {
    private String name;
    private String surname;
    private String email;
    private String mobilePhone;
    private String homePhone;
    private String address;

    public Person(String name, String surname, String email, String mobilePhone, String homePhone, String address) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.mobilePhone = mobilePhone;
        this.homePhone = homePhone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getAddress() {
        return address;
    }
}
