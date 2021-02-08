package com.example.cabinet.utils;

import com.example.cabinet.db.Role;
import com.example.cabinet.db.User;
import com.example.cabinet.db.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Initializer implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger logger = LoggerFactory.getLogger(Initializer.class);

    private final UserRepository userRepository;

    public Initializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (userRepository.count() == 0) {
            logger.info("Insert Users");
            User user1 = new User();
            user1.setUsername("amine");
            user1.setPassword("$2a$10$SBykymndxR1OrKbImpMHNetg6PkcUPJkGqtNupG7aSXzNjP57YIyS");
            Role role = new Role();
            role.setName("ROLE_ADMIN");
            List<Role> roleList = new ArrayList<>();
            roleList.add(role);
            user1.setRoles(roleList);
            userRepository.save(user1);
        }

    }
}
