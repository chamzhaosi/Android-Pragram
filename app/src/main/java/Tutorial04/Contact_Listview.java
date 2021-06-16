package Tutorial04;

public class Contact_Listview {
    private String name, phone;

    public Contact_Listview (String name, String phone){
        this.name = name;
        this.phone = phone;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getPhone(){
        return phone;
    }
}
