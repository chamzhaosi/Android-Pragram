package SimpleRecyclerview;

public class Contact {
    private String name, phoneNumber;

    public Contact(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }
}
