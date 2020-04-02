package com.Software.Project.Repoistory;

import com.Software.Project.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepoistory extends JpaRepository<User, Long> {
}
