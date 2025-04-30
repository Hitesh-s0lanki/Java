package com.hitesh.backend.controller;

import com.hitesh.backend.model.JobPost;
import com.hitesh.backend.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class JobController {

    @Autowired
    private JobService service;

    @GetMapping("jobPosts")
    public List<JobPost> getAllJobs() {
        return service.getAllJobs();
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable("postId")  int postId) {
        return service.getJob(postId);
    }

    @PostMapping("jobPost")
    public String addJob(@RequestBody JobPost jobPost) {
        service.addJob(jobPost);
        return "Done";
    }

    @PutMapping("jobPost/{postId}")
    public JobPost updateJob(@PathVariable("postId")  int postId, @RequestBody JobPost jobPost) {
        service.updateJob(postId, jobPost);
        return service.getJob(postId);
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable("postId")  int postId) {
        service.deleteJob(postId);
        return "Job deleted Successfully with id " + postId;
    }

    @GetMapping("load")
    public String load(){
        service.load();
        return "Loaded the Static Data";
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable String keyword) {
        return service.search(keyword);
    }
}
