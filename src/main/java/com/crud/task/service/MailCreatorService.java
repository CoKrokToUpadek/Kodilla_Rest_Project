package com.crud.task.service;

import com.crud.task.config.AdminConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;

@Service
public class MailCreatorService {
    @Autowired
    private AdminConfig adminConfig;


    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    public String buildTrelloCardEmail(String message) {

        List<String> functionality = new ArrayList<>();
        functionality.add("You can manage your tasks");
        functionality.add("Provides connection with Trello Account");
        functionality.add("Application allows sending tasks to Trello");


        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "https://cokroktoupadek.github.io");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_config", adminConfig);
//        context.setVariable("admin_name", adminConfig.getAdminName());
//        context.setVariable("company_name", adminConfig.getCompanyName());
        context.setVariable("goodbye_msg", adminConfig.getGoodbyeMessage()+" "+ adminConfig.getAdminName());
        context.setVariable("show_button", false);
        context.setVariable("is_friend", true);
        return templateEngine.process("mail/created-trello-card-mail", context);
    }

    public String buildTaskCountEmail(String message) {

        Context context2 = new Context();
        context2.setVariable("message", message);
        context2.setVariable("tasks_url", "https://cokroktoupadek.github.io");
        context2.setVariable("admin_config", adminConfig);
        context2.setVariable("goodbye_msg", adminConfig.getGoodbyeMessage()+" "+ adminConfig.getAdminName());
        return templateEngine.process("mail/amount-of-tasks-mail", context2);
    }

}