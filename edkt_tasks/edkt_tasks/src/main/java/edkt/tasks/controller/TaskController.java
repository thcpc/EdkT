package edkt.tasks.controller;


import edkt.tasks.entity.Task;
import edkt.tasks.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;
    @GetMapping("/hello")
    public Mono<Task> hello(){
//        return Mono.just("hello world");
        return taskService.createTask();
    }


}
