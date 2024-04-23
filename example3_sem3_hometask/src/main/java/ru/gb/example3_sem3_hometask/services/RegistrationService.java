package ru.gb.example3_sem3_hometask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.example3_sem3_hometask.domain.User;
import ru.gb.example3_sem3_hometask.repository.UserRepository;

@Service
public class RegistrationService {

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    @Autowired
    private DataProcessingService dataProcessingService;

    private final UserService userService;

    private final NotificationService notificationService;
    @Autowired
    public RegistrationService(UserService userService, NotificationService notificationService) {
        this.userService = userService;
        this.notificationService = notificationService;
    }

    public void processRegistration(String name, int age, String email){
        User user = userService.createUser(name, age,email);

        dataProcessingService.addUserToList(user);
        notificationService.sendNotification(user);

    }
}
