package dev.ryanwang.birthdaygreetingkata.service;


import dev.ryanwang.birthdaygreetingkata.dto.GreetingDTO;
import dev.ryanwang.birthdaygreetingkata.po.UserPO;
import dev.ryanwang.birthdaygreetingkata.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.YEARS;

@Service
public class GreetingService {

    private Logger logger = LoggerFactory.getLogger(GreetingService.class);

    @Autowired
    private UserRepository userRepository;

    public List<GreetingDTO> findGreetingList() {
        List<GreetingDTO> greetingDTOList = new ArrayList<>();

        // Get today's day and month.
        LocalDate localDate = LocalDate.now();
        int day = localDate.getDayOfMonth();
        int month = localDate.getMonthValue();

        List<UserPO> userList = userRepository.findByBirthSpecific(day, month);
        for (UserPO user : userList) {
            String title = "Subject: Happy birthday!";
            String content = "Happy birthday, dear " + user.getFirstName() + "!";
            long age = YEARS.between(user.getBirth(), localDate);
            if(age>49){
                content = "Happy birthday, dear " + user.getFirstName() + "! \n (A greeting picture here)";
            }
            GreetingDTO greeting = new GreetingDTO(title, content);
            greetingDTOList.add(greeting);
        }
        logger.info("[findGreetingList] Day:{} Month{}. result size: {}", day, month, greetingDTOList.size());
        return greetingDTOList;

    }
}
