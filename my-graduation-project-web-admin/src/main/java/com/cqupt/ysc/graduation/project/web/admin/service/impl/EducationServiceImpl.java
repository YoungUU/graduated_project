package com.cqupt.ysc.graduation.project.web.admin.service.impl;

import com.cqupt.ysc.graduation.project.commons.constant.TimeUtils;
import com.cqupt.ysc.graduation.project.domain.Dto.RewardDto;
import com.cqupt.ysc.graduation.project.domain.Dto.StudentDto;
import com.cqupt.ysc.graduation.project.domain.Reward;
import com.cqupt.ysc.graduation.project.domain.Student;
import com.cqupt.ysc.graduation.project.web.admin.dao.RewardDao;
import com.cqupt.ysc.graduation.project.web.admin.dao.StudentDao;
import com.cqupt.ysc.graduation.project.web.admin.service.EducationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationServiceImpl implements EducationService {
    @Autowired
    RewardDao rewardDao;

    @Autowired
    StudentDao studentDao;

    /**
     *Reward所有操作
     */
    @Override
    public List<Reward> getRewards(String email) {
        return rewardDao.getRewards(email);
    }

    @Override
    public Reward getRewardById(long id) {
        return rewardDao.getRewardById(id);
    }

    @Override
    public void deleteRewardById(long id) {
        rewardDao.deleteRewardById(id);
    }

    @Override
    public String saveReward(RewardDto rewardDto) {
        if (rewardDto == null){
            return "reward_form";
        }
        //新增用户
        if (rewardDto.getId() == null){
            Reward reward = new Reward();
            BeanUtils.copyProperties(rewardDto,reward);
            reward.setUpdated(TimeUtils.getSystemTime());
            reward.setCreated(TimeUtils.getSystemTime());
            rewardDao.saveReward(reward);
        }
        return "插入成功";
    }

    @Override
    public void updateRewardById(RewardDto rewardDto) {
        Reward reward = new Reward();
        BeanUtils.copyProperties(rewardDto,reward);
        reward.setUpdated(TimeUtils.getSystemTime());
        rewardDao.updateRewardById(reward);
    }

    @Override
    public List<Reward> searchReward(String keyword) {
        Reward reward = new Reward();
        reward.setRewardName(keyword);
        reward.setContext(keyword);
        return rewardDao.searchReward(reward);
    }


    /**
     *Student所有操作
     */
    @Override
    public List<Student> getStudents(String email) {
        return studentDao.getStudents(email);
    }

    @Override
    public Student getStudentById(long id) {
        return studentDao.getStudentById(id);
    }

    @Override
    public void deleteStudentById(long id) {
        studentDao.deleteStudentById(id);
    }

    @Override
    public String saveStudent(StudentDto studentDto) {
        if (studentDto == null){
            return "student_form";
        }
        //新增用户
        if (studentDto.getId() == null){
            Student student = new Student();
            BeanUtils.copyProperties(studentDto,student);
            student.setUpdated(TimeUtils.getSystemTime());
            student.setCreated(TimeUtils.getSystemTime());
            studentDao.saveStudent(student);
        }
        return "插入成功";
    }

    @Override
    public void updateStudentById(StudentDto studentDto) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDto,student);
        student.setUpdated(TimeUtils.getSystemTime());
        studentDao.updateStudentById(student);
    }

    @Override
    public List<Student> searchStudent(String keyword) {
        Student student = new Student();
        student.setStuName(keyword);
        student.setStuNum(Integer.parseInt(keyword));
        return studentDao.searchStudent(student);
    }
}
