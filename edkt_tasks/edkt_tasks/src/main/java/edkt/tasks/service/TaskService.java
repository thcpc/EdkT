package edkt.tasks.service;

import edkt.tasks.entity.Task;
import reactor.core.publisher.Mono;

public interface TaskService {
    Mono<Task> createTask();
}
