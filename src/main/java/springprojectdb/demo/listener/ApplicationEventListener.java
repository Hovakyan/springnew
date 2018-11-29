package springprojectdb.demo.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import springprojectdb.demo.models.MyUser;
import springprojectdb.demo.service.UserService;

@Component
public class ApplicationEventListener {

    @Autowired
    UserService userService;

    @EventListener({ContextRefreshedEvent.class})
    public void onContextRefreshedEvent() {
        userService.save(new MyUser("Aram", "Hovakanyan", "adolfik", "hitler"));
    }

}
