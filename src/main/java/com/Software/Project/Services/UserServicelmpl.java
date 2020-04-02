package com.Software.Project.Services;

import com.Software.Project.Domain.User;
import com.Software.Project.Repoistory.IUserRepoistory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServicelmpl implements IUserService {
    public final IUserRepoistory userRepoistory;
    public UserServicelmpl(IUserRepoistory userRepoistory) {
        this.userRepoistory = userRepoistory;
    }

    @Override
    public User findUserById(Long id) {
        return userRepoistory.findById(id).get();
    }

    @Override
    public List<User> findAllUsers() {
        return userRepoistory.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepoistory.save(user);
    }
}
