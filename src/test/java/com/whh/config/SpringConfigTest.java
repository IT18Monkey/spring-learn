package com.whh.config;

import com.whh.business.mapper.UserMapper;
import com.whh.business.model.User;
import com.whh.business.service.CDPlayer;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import javax.jws.soap.SOAPBinding;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by whh on 2017/5/9.
 */
@ContextConfiguration("classpath:/spring/spring-*.xml")
public class SpringConfigTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
    @Autowired
    private CDPlayer cdPlayer;
    @Autowired
    private UserMapper userMapper;

    @Test
    public void CDPlayerTest() {
        cdPlayer.play();
        assertEquals("CD Player", systemOutRule.getLog());
    }

    @Test
    @Rollback(false)
    public void jdbcTest() {
        jdbcTemplate.execute("INSERT INTO  USER VALUE (2,'haha',123)");
    }

    @Test
    @Rollback(false)
    public void saveUser() {
        User user = new User();
        user.setUserId(2l);
        user.setAge(12);
        user.setName("whh");
        int result = userMapper.insert(user);
        assertEquals(1, result);
    }
}
