package com.backendMarch.librarymanagementsystem.Controllers;


import com.backendMarch.librarymanagementsystem.DTOs.StudentUpdateMobRequestDto;
import com.backendMarch.librarymanagementsystem.Entity.Student;
import com.backendMarch.librarymanagementsystem.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public String createStudent(@RequestBody Student student){

        return studentService.createStudent(student);
    }


    @GetMapping("/get_user")
    public String getNameByEmail(@RequestParam("email")String email){

        return studentService.findNameByEmail(email);
    }


    @PutMapping("/update_mob")
    public String updateMob(@RequestBody StudentUpdateMobRequestDto studentReqDto){
        return studentService.updateMobNo(studentReqDto);
    }

}