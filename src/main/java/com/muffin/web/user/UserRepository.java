package com.muffin.web.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>, IUserRepository {

    User save(User user);

}
