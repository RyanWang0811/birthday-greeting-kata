package dev.ryanwang.birthdaygreetingkata.repository;

import dev.ryanwang.birthdaygreetingkata.po.UserPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserPO, String> {

    @Query(value = "select u from UserPO u where DATE_PART('day', birth) = :day and DATE_PART('month', birth) = :month")
    List<UserPO> findByBirthSpecific(int day,int month);
}
