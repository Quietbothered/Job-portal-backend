package com.balaji.springbootrest;

import com.balaji.springbootrest.model.JobPost;
import com.balaji.springbootrest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080"})
@CrossOrigin
public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping("jobPosts")
    public List<JobPost> getAllJobs(){
        return service.getAllJobs();
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId){
        return service.getJob(postId);
    }

    @PostMapping("jobPost")
    public void addJob(@RequestBody JobPost jobPost){
        service.addJob(jobPost);
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String updateJob(@PathVariable int postId){
        service.deleteJob(postId);
        return "deleted";
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword){
        return service.search(keyword);
    }



    @GetMapping("loadData")
    public String load(){
        service.load();
        return "data loaded";
    }
}

