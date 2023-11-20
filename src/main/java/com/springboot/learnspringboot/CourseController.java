package com.springboot.learnspringboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {
    @RequestMapping("/Course")
    public List<Course> retrieveAllCources(){
        return Arrays.asList(
                new Course(1,"azure","udemy"),
                new Course(2,".net","udemy")
        );
    }
}
