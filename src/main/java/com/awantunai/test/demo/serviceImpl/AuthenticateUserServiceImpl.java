package com.awantunai.test.demo.serviceImpl;


import com.awantunai.test.demo.apiResponse.AuthenticationResponse;
import com.awantunai.test.demo.dto.AuthenticateRequestBody;
import com.awantunai.test.demo.model.UserModel;
import com.awantunai.test.demo.service.AuthenticateUser;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AuthenticateUserServiceImpl implements AuthenticateUser {
    //this hash map supposed to be our temp repo user
    HashMap<String , UserModel> stringUserModelHashMap = new HashMap<>();

    @Override
    public String authenticateUser(AuthenticateRequestBody authenticateRequestBody) {
        try {
            //get the object based on username
            UserModel userModel = stringUserModelHashMap.get(authenticateRequestBody.getUsername());
            if(userModel != null){
                if(userModel.getPassword().equals(authenticateRequestBody.getPassword())){
                    //should give the success authenticate
                    return AuthenticationResponse.SUCCESS_LOGIN;
                }else{
                    return AuthenticationResponse.FAILED_LOGIN;
                }
            }
        }catch (Exception e){

            System.out.println(e.getMessage());
        }
        //should give the failed authenticate
        return AuthenticationResponse.USER_NOT_EXIST;
    }


    //the purpose this function is to add user to our hashmap
    @Override
    public void addUserToHashMap() {
        UserModel userModel = null;
        for (int i = 0; i < 5; i++) {
            userModel= new UserModel();
            //should be username  for authentication
            userModel.setUsername("winnertest"+i);
            //should be password for authentication
            userModel.setPassword("winnertest123");
            //optional attribute
            userModel.setAddress("Indonesia/Asia");
            //optional attribute
            userModel.setGender("Male");
            //this is will add user model to our hashmap
            stringUserModelHashMap.put(userModel.getUsername(),userModel);
        }
    }

}
