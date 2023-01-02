package Awantunai-Interview-Test.src.main.java.com.awantunai.test.demo.user;




@Entity
// change name to exact table name for users
@Table(name = "user", uniqueConstraints = {
    @UniqueConstraint(columnNames = "username")
})

public class User {



    @Column(name= "email",nullable = false, unique = true, length = 45)
    private String email;

    @Column(name= "password",nullable = false, length = 45)
    private String password;

    @Column(name= "username",nullable = false, length = 45)
    private String username; //random user object information

    @Column(name= "username",nullable = false, length = 45)
    private String address; //random user object information


    public User(String email, String password, String username, String address){ //create user object
        this.email = email;
        this.password = password;
        this.username = username;
        this.address = address;
    }


    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }


    // hash the password + salt values
    public static String hashPassword(String password) {
        String concat = password;
        // security
        String stringHash = "";
        MessageDigest messageDigest;
        try {
        messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(concat.getBytes());
        stringHash = new String(messageDigest.digest());

        } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
        }
        return stringHash;

    }





}
