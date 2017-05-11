package com.whh.config;

import com.whh.business.service.CDPlayer;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by whh on 2017/5/9.
 */
@ContextConfiguration(classes = SpringConfig.class)
public class SpringConfigTest extends AbstractJUnit4SpringContextTests {
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
    @Autowired
    private CDPlayer cdPlayer;

    @Test
    public void CDPlayerTest() {
        cdPlayer.play();
        assertEquals("CD Player",systemOutRule.getLog());
    }

}
