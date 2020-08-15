package com.muffin.web.user;

import com.muffin.web.util.Box;
import com.muffin.web.util.GenericService;
import org.springframework.stereotype.Service;

import java.util.Optional;

interface UserService extends GenericService<User> {

    void save(User user);

}

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public Optional<User> findById(String emailId) {
        return repository.findByEmailId(emailId);
    }

    @Override
    public Iterable<User> findAll() {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public boolean exists(String emailId) {
        return repository.existsByEmailId(emailId);
    }


}
