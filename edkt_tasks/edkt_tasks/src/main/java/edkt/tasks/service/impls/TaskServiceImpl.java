package edkt.tasks.service.impls;

import edkt.tasks.entity.Task;
import edkt.tasks.entity.TaskFactory;
import edkt.tasks.service.TaskService;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.function.Consumer;
import java.util.function.Function;

@Repository
public class TaskServiceImpl implements TaskService {
    @Override
    public Mono<Task> createTask() {
        System.out.println("[map] Thread name: " + Thread.currentThread().getName());
        Task t = TaskFactory.create();
        Mono.just(t).subscribeOn(Schedulers.newParallel("Test")).subscribe(new Consumer<Task>() {
            @Override
            public void accept(Task task) {
                try {
                System.out.println("[map] Thread name: " + Thread.currentThread().getName());
                System.out.println("run task1");

                Thread.sleep(30000);
                System.out.println("run finish");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            }
        });
        return Mono.just(t);

//        return Mono.just(TaskFactory.create()).publishOn(Schedulers.newParallel("Test1")).flatMap(task -> {
//            try {
//                System.out.println("[map] Thread name: " + Thread.currentThread().getName());
//                System.out.println("run task1");
//
//                Thread.sleep(30000);
//                System.out.println("run finish");
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            return Mono.just(task);
//        }).then(Mono.just(TaskFactory.create()));

    }
}
