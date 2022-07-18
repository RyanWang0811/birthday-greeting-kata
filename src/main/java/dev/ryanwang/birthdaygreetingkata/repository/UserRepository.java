package dev.ryanwang.birthdaygreetingkata.repository;

import dev.ryanwang.birthdaygreetingkata.po.UserPO;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<UserPO, String> {

    @Aggregation(value = "{$match: {$expr:{$and:[{$eq:[{$dayOfMonth:'$birth'},?0]},{$eq:[{$month:'$birth'},?1]},],}}}")
    List<UserPO> findByBirthSpecific(int day,int month);
}
