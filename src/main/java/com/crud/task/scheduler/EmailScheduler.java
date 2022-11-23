package com.crud.task.scheduler;

import com.crud.task.config.AdminConfig;
import com.crud.task.domain.Mail;
import com.crud.task.repository.TaskRepository;
import com.crud.task.service.SimpleEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailScheduler {

    private final SimpleEmailService simpleEmailService;
    private final TaskRepository taskRepository;
    private final AdminConfig adminConfig;
    private static final String SUBJECT = "Tasks: Once a day email";

    //@Scheduled(cron = "0 0 10 * * *")
    //@Scheduled(fixedDelay = 10000)
    public void sendInformationEmail(){
        long size = taskRepository.count();
        simpleEmailService.sendCounter(
                new Mail(
                        adminConfig.getAdminMail(),
                       null ,
                        SUBJECT,
                        "Currently in database you got: " + size + " task"+(size>1 ? "s":"")
                )
        );

    }

}