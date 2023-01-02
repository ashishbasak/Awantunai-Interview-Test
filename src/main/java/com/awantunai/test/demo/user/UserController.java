package Awantunai-Interview-Test.src.main.java.com.awantunai.test.demo.user;

public class UserController {
    private final UserService UserService;


    @Autowired
    public UserController(UserService UserService) { //initialize usercontroller
        this.UserService = UserService;
    }

    @GetMapping("/login")
    public User Login(@Requestbody User user) {
        return UserService.Login(id);
    }

    @PostMapping("/signup")
    public User SignUp(@RequestBody User user) {
        return UserService.SignUp(user);
    }




}
