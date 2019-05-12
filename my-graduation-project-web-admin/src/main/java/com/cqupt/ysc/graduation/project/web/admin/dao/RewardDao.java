package com.cqupt.ysc.graduation.project.web.admin.dao;

import com.cqupt.ysc.graduation.project.domain.Reward;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RewardDao {
    List<Reward> getRewards(String email);
    Reward getRewardById(long id);
    void deleteRewardById(long id);
    void saveReward(Reward reward);
    void updateRewardById(Reward reward);
    List<Reward> searchReward(Reward reward);
}
