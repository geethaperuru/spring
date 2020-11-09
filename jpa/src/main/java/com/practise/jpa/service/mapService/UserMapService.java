package com.practise.jpa.service.mapService;

import com.practise.jpa.model.User;
import com.practise.jpa.service.UserService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserMapService implements UserService {

    private Map<Integer,User> map;

    public UserMapService() {
        map = new HashMap<>();
    }

    @Override
    public List<User> listAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public User getById(Integer id) {
        return map.get(id);
    }

    private Integer getNextKey(){
        return Collections.max(map.keySet()) + 1;
    }

    @Override
    public User saveOrUpdate(User user) {
        if (user != null){

            if (user.getId() == null){
                user.setId(getNextKey());
            }
            map.put(user.getId(), user);
            return user;
        } else {
            throw new RuntimeException("Object Can't be null");
        }
    }

    @Override
    public void delete(Integer id) {
        map.remove(id);
    }
}
