package dev.ryanwang.birthdaygreetingkata;

import dev.ryanwang.birthdaygreetingkata.controller.GreetingController;
import dev.ryanwang.birthdaygreetingkata.repository.UserRepository;
import dev.ryanwang.birthdaygreetingkata.service.GreetingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class BirthdayGreetingKataApplicationTests {

    @Autowired
    private GreetingController greetingController;

    @Autowired
    private GreetingService greetingService;

    @Autowired
    private UserRepository userRepository;

    @Test
    void contextLoads() {
        assertThat(greetingController).isNotNull();
        assertThat(greetingService).isNotNull();
        assertThat(userRepository).isNotNull();
    }


}
