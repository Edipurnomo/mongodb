package com.tugas5.edyp.controller;


import com.tugas5.edyp.model.User;
import com.tugas5.edyp.repository.UserRepository;
import com.tugas5.edyp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {


    @Autowired
    UserRepository repository;

    @Autowired
    UserService service;





//--------------------------------->pagination<-------------------------------------------//


    @GetMapping
    public List<User> getAllUser(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                 @RequestParam(value = "sortKey", defaultValue = "name") String sortKey) {
        return service.getAllUser(pageNo, sortKey);
    }

    //--------------------------------->Menambah data<-------------------------------------------//

    @PostMapping("/insert")
    public Map<String, Object> addNewBook(@RequestBody User body) {
        Map<String, Object> result = new HashMap<>();
        if (service.saveUser(body)) {
            result.put("success", true);
            result.put("message", "user berhasil ditambahkan");
        } else {
            result.put("successs", false);
            result.put("message", "user gagal ditambahkan");
        }
        return result;
    }

    //--------------------------------->Mendelete data<-------------------------------------------//

    @DeleteMapping("/delete")
        //id dr param postman
    Map<String, Object> deleteBook(@RequestParam String id) {
        Map<String, Object> result = new HashMap<>();
        if (service.DeleteBook(id)) {
            result.put("success", true);
            result.put("message", "User Deleted!");
        } else {
            result.put("success", false);
            result.put("message", "User Not Deleted!");
        }
        return result;
    }

    @PutMapping("/update")
    Map<String, Object> UpdateUser(@RequestBody User body) {
        Map<String, Object> result = new HashMap<>();
        if (service.updateUser(body)) {
            result.put("success", true);
            result.put("mes", "berhasil");
        } else {
            result.put("success", false);
            result.put("mes", "gagal");
        }
        return result;
    }

}
