package dev.ryanwang.birthdaygreetingkata.service;

import dev.ryanwang.birthdaygreetingkata.dto.GreetingDTO;
import dev.ryanwang.birthdaygreetingkata.po.UserPO;
import dev.ryanwang.birthdaygreetingkata.repository.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
class GreetingServiceTest {

    @Autowired
    private GreetingService greetingService;

    @MockBean
    private UserRepository userRepository;

    @BeforeAll
    void setUp(){
        // mock today
        LocalDate today = LocalDate.of(2022, 8, 8);
        Mockito.mockStatic(LocalDate.class).when(LocalDate::now).thenReturn(today);
    }


    @Test
    void findGreetingList() {
        // mock userRepository
        final List<UserPO> userPOList = new ArrayList<>();
        userPOList.add(new UserPO("uuid-1", "Robert", "Yen", "Male", LocalDate.parse("1985-08-08"), "robert.yen@linecorp.com"));
        Mockito.when(userRepository.findByBirthSpecific(8, 8)).thenReturn(userPOList);

        List<GreetingDTO> greetingDTOList = greetingService.findGreetingList();
        assertEquals(1, greetingDTOList.size());
        assertEquals("Happy birthday, dear Robert!", greetingDTOList.get(0).getContent());
    }

    @Test
    void findGreetingListNoResult() {
        // mock userRepository
        final List<UserPO> userPOList = new ArrayList<>();
        Mockito.when(userRepository.findByBirthSpecific(8, 8)).thenReturn(userPOList);

        List<GreetingDTO> greetingDTOList = greetingService.findGreetingList();
        assertEquals(0, greetingDTOList.size());
    }
}