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

@Service
public class GreetingService {

    private final Logger logger = LoggerFactory.getLogger(GreetingService.class);

    private static final String MANCONTENT = "Happy birthday, dear %s! \n" +
            "We offer special discount 20%% off for the following items: White Wine, iPhone X";

    private static final String FEMALECONTENT = "Happy birthday, dear %s! \n" +
            "We offer special discount 50%% off for the following items: Cosmetic, LV Handbags";

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
            String content = "";

            if(user.getGender().equals("Male")){
                content = String.format(MANCONTENT,user.getFirstName());
            }else if (user.getGender().equals("Female")){
                content = String.format(FEMALECONTENT,user.getFirstName());
            }

            String title = "Subject: Happy birthday!";
            GreetingDTO greeting = new GreetingDTO(title, content);
            greetingDTOList.add(greeting);
        }
        logger.info("[findGreetingList] Day:{} Month{}. result size: {}", day, month, greetingDTOList.size());
        return greetingDTOList;

    }
}
