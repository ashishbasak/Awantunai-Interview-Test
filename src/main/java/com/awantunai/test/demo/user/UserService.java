package Awantunai-Interview-Test.src.main.java.com.awantunai.test.demo.user;

public class UserService {
    
    @Service
    public class UserService {
    //User Repository
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User SignUp(User user) {
        String unhashed = user.getPassword();
        String hashed = user.hashPassword(unhashed);
        user.setPassword(hashed); 
        return userRepository.save(user);
    }

    public String Login(User user){


        String enteredEmail = user.getEmail();
        String enteredPassword = user.getPassword();
        String hashedPassword = user.hashPassword(enteredPassword);


        User retrieved = userRepository.findByEmail(email);
        String retrievedPassword = retrieved.getPassword();

        if(hashedPassword == retrievedPassword){
            return "Success";
        } else {
            return "Fail"; 
        }


        /* pass in email + password
        hash password
        retrieve user object with email
        match hashed password in database against hashed password that was passed in
        if match, sign in success
        if does not match, sign in fail */

    }


    }

}
