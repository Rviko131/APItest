package StepsDef;

public class Post {
    private int id;
     String name;
     String username;
     String email;
     String address;
     String phone;


    public Post (int id, String name, String username, String email, String address, String phone){
        this.id = id;
        this.name=name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public int getId(){
        return id;
    }
}
