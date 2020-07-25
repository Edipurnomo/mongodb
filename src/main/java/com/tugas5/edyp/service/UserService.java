package com.tugas5.edyp.service;


import com.tugas5.edyp.model.User;
import com.tugas5.edyp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    @Autowired
    UserRepository repository;


    public List<User> getAllUser(Integer pageNo, String sortKey){
        int noOfRecord = 5;
        Pageable page = PageRequest.of(pageNo, noOfRecord, Sort.by(sortKey));
        Page<User> pagedResult = repository.findAll(page);
        return pagedResult.getContent();
    }


    public boolean saveUser(User body) {

        try {
            repository.save(body);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean DeleteBook(String id) {
        User result = repository.deleteByid(id);
        if (result != null) {
            try {
                repository.delete(result);
                return true;
            } catch (Exception e) {
                return false;
            }

        } else {
            return false;
        }
    }

}
