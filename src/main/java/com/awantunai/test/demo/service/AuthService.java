package com.awantunai.test.demo.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.awantunai.test.demo.Storage.UserData;
import com.awantunai.test.demo.dto.request.SignupRequest;
import com.awantunai.test.demo.dto.response.LoginReponse;
import com.awantunai.test.demo.dto.response.SignupResponse;

@Service
public class AuthService {

    List<UserData> userData = new ArrayList<>();

    public SignupResponse signup(SignupRequest params) {
        SignupResponse result = new SignupResponse();
        try {
            MessageDigest msg = MessageDigest.getInstance("MD5");
            msg.update(params.getUsername().getBytes());
            byte[] bt = msg.digest();
            StringBuilder str = new StringBuilder(); 

            for (int i = 0; i < bt.length; i++) {
                str.append(Integer.toString((bt[i] & 0xff) + 0x100, 16).substring(1));
            }

            // ed = str.toString();

            userData.add(UserData.builder().username(params.getUsername()).password(null).build());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

    public LoginReponse login(RequestBody requestBody) {
        LoginReponse result = new LoginReponse();
        return result;
    }
}
