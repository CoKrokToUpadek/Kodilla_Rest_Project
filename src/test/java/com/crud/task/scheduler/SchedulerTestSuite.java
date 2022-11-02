package com.crud.task.scheduler;

import com.crud.task.service.SimpleEmailService;

import nl.altindag.log.LogCaptor;
import org.junit.jupiter.api.Test;


import org.mockito.InjectMocks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class SchedulerTestSuite {
    @Autowired
    EmailScheduler scheduler;


   @Test
   void sendInformationEmailPassTest(){
        //given
        String msg="Email has been sent.";
        LogCaptor logCaptor = LogCaptor.forClass(SimpleEmailService.class);
        //when
        scheduler.sendInformationEmail();
        //then
        assertTrue(logCaptor.getInfoLogs().contains(msg));
    }


}
