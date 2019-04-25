package com.cqupt.ysc.graduation.project.web.admin.service;

import com.cqupt.ysc.graduation.project.domain.Dto.RewardDto;
import com.cqupt.ysc.graduation.project.domain.Dto.StudentDto;
import com.cqupt.ysc.graduation.project.domain.Reward;
import com.cqupt.ysc.graduation.project.domain.Student;

import java.util.List;

public interface EducationService {
    //获奖管理
    List<Reward> getRewards(String email);
    Reward getRewardById(long id);
    void deleteRewardById(long id);
    String saveReward(RewardDto rewardDto);
    void updateRewardById(RewardDto rewardDto);

    //学生管理
    List<Student> getStudents(String email);
    Student getStudentById(long id);
    void deleteStudentById(long id);
    String saveStudent(StudentDto studentDto);
    void updateStudentById(StudentDto tudentDto);
}
