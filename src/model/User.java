package model;

public class User {


    private  int id;
    private String name;
    private String phone_number;
    private String address;


    public User(String name,String phone_number,String address){
        this.name=name;
        this.phone_number=phone_number;
        this.address=address;
    }



    public User(int id,String name,String phone_number,String address){
        this.id=id;
        this.name=name;
        this.address=address;
        this.phone_number=phone_number;
    }


    public int getId(){
        return id;
    }

    public void SetId(int id){
        this.id=id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;

    }


    public String getAddress(){
        return address;

    }


    public void setAddress(String address){
        this.address=address;
    }

    public String getphone_number(){
        return phone_number;

    }

    public void setphone_number(String phone_number){
        this.phone_number=phone_number;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", address='" + address + '\'' +
                '}';
    }


}
