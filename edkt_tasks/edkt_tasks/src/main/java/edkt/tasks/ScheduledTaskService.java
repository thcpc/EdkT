package edkt.tasks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledTaskService {
    private Logger log = LoggerFactory.getLogger(ScheduledTaskService.class);

    @Scheduled(fixedRate = 5000)
    public void testFixedRate(){
        log.info("every 5 s, run it");
    }
}
