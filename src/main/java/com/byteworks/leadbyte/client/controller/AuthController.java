package com.byteworks.leadbyte.client.controller;

import com.byteworks.leadbyte.model.User;
import com.byteworks.leadbyte.repository.NinRepository;
import com.byteworks.leadbyte.repository.UserRepository;
import com.byteworks.leadbyte.service.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.xml.bind.DatatypeConverter;
import java.net.URI;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@RestController
@RequestMapping("/api")
public class AuthController {


    final
    UserRepository userRepository;

    final
    NinRepository roleRepository;

    public AuthController(UserRepository userRepository, NinRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @PostMapping("/create-user")
    public ResponseEntity<?> createUser(@Valid @RequestBody User user) {
        if(userRepository.existsByUsername(user.getUsername())) {
            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        User new_user = new User(user.getUsername(), user.getPassword());

        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(new_user.getPassword().getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }

        new_user.setPassword(generatedPassword);

        User result = userRepository.save(new_user);


        URI location = getUri(result);

        return ResponseEntity.created(location).body(new ApiResponse(true,
                "New user created " + result.toString()));
    }


    private URI getUri(User tempUser) {
        return ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/users/{username}")
                .buildAndExpand(tempUser.getUsername()).toUri();
    }

}