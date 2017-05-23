package com.whh.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.xml.soap.Text;

/**
 * Created by whh on 2017/5/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-activemq.xml")
public class SpringActiveMQTest {
    private Logger logger = LoggerFactory.getLogger(SpringActiveMQTest.class);
    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    @Qualifier("test-queue")
    private ActiveMQQueue queue;

    @Test
    public void testJmsTemplate() {
        jmsTemplate.send(queue, (Session session) -> {
            Message message = session.createTextMessage("spring-textmessage");
            return message;
        });
    }

    @Test
    public void testJmsRecieve() throws JMSException {
        Message message = jmsTemplate.receive(queue);
        if (message instanceof TextMessage) {
            String text = ((TextMessage) message).getText();
            logger.info(text);
        }
    }

}
