package com.example.userJWT.controller;
import com.example.userJWT.entity.UserEntity;
import com.example.userJWT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping
//@CrossOrigin(origins = "*")
public class PrincipalController {
    @Autowired(required = true)
    UserService userService;
    @GetMapping("/allUser")
    @ResponseStatus(HttpStatus.OK)
    public List<UserEntity> getAllUser() {
        return userService.allUSer();
    }
    @PostMapping("/createUser")
    @ResponseStatus(HttpStatus.CREATED)
    public UserEntity creatUser(@RequestBody UserEntity userEntity){
        return userService.postUser(userEntity);
    }
    @GetMapping("/user/{nombre}")
    public List<Object> data(@PathVariable String nombre) {
        return  userService.userByNombre(nombre);
    }

    @DeleteMapping("/DeleteUser/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return "usuario eliminado: "+id;
    }
}

