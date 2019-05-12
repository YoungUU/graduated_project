package com.cqupt.ysc.graduation.project.web.admin.web.controller;

import com.cqupt.ysc.graduation.project.domain.Dto.RewardDto;
import com.cqupt.ysc.graduation.project.domain.Dto.StudentDto;
import com.cqupt.ysc.graduation.project.domain.Reward;
import com.cqupt.ysc.graduation.project.domain.Student;
import com.cqupt.ysc.graduation.project.web.admin.Utils.EmailUtils;
import com.cqupt.ysc.graduation.project.web.admin.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "education")
public class EducationController {

    @Autowired
    EducationService educationService;

    /**
     *所有Reward对外接口
     */
    @RequestMapping(value = "reward")
    public String getRewards(HttpServletRequest httpServletRequest, Model model){
        String email = EmailUtils.getUserEmail(httpServletRequest);
        List<Reward> rewards = educationService.getRewards(email);
        model.addAttribute("rewards",rewards);
        return "education_reward";
    }

    @RequestMapping(value = "formReward",method = RequestMethod.GET)
    public String formReward(Long id,Model model){
        if (id != null){
            Reward reward = educationService.getRewardById(id);
            model.addAttribute("reward",reward);
        }
        return "reward_form";
    }

    @RequestMapping(value = "saveReward",method = RequestMethod.POST)
    public String saveReward(HttpServletRequest httpServletRequest, RewardDto rewardDto){
        if(rewardDto == null){
            return "reward_form";
        }

        rewardDto.setEmail(EmailUtils.getUserEmail(httpServletRequest));

        //封装完成，插入数据。
        educationService.saveReward(rewardDto);

        return "redirect:/education/reward";
    }

    @RequestMapping(value = "deleteReward")
    public String deleteRewardById(Long id){
        System.out.println(id);
        educationService.deleteRewardById(id);
        return "redirect:/education/reward";
    }

    @RequestMapping(value = "editReward")
    public String editRewardById(Long id,RewardDto rewardDto){
        rewardDto.setId(id);
        educationService.updateRewardById(rewardDto);
        return "redirect:/education/reward";
    }

    /**
     * @param keyword
     * @param model
     * @return
     */
    @RequestMapping(value = "searchReward",method = RequestMethod.POST)
    public String searchReward(String keyword, Model model){
        List<Reward> rewards = educationService.searchReward(keyword);
        model.addAttribute("rewards",rewards);
        return "education_reward";
    }

    /**
     *所有Student对外接口
     */
    @RequestMapping(value = "student")
    public String getStudents(HttpServletRequest httpServletRequest,Model model){
        String email = EmailUtils.getUserEmail(httpServletRequest);
        List<Student> students = educationService.getStudents(email);
        model.addAttribute("students",students);
        return "education_student";
    }

    @RequestMapping(value = "formStudent",method = RequestMethod.GET)
    public String formStudent(Long id,Model model){
        if (id != null){
            Student student = educationService.getStudentById(id);
            model.addAttribute("student",student);
        }
        return "student_form";
    }

    @RequestMapping(value = "saveStudent",method = RequestMethod.POST)
    public String saveStudent(HttpServletRequest httpServletRequest, StudentDto studentDto){
        if(studentDto == null){
            return "student_form";
        }

        studentDto.setEmail(EmailUtils.getUserEmail(httpServletRequest));

        //封装完成，插入数据。
        educationService.saveStudent(studentDto);

        return "redirect:/education/student";
    }

    @RequestMapping(value = "deleteStudent")
    public String deleteStudentById(Long id){
        educationService.deleteStudentById(id);
        return "redirect:/education/student";
    }

    @RequestMapping(value = "editStudent")
    public String editStudentById(Long id,StudentDto studentDto){
        studentDto.setId(id);
        educationService.updateStudentById(studentDto);
        return "redirect:/education/student";
    }

    /**
     * @param keyword
     * @param model
     * @return
     */
    @RequestMapping(value = "searchStudent",method = RequestMethod.POST)
    public String searchProject(String keyword, Model model){
        List<Student> students = educationService.searchStudent(keyword);
        model.addAttribute("students",students);
        return "education_student";
    }

}
