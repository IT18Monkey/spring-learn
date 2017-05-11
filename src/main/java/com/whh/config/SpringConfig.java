package com.whh.config;

import com.whh.business.service.CDPlayer;
import com.whh.business.service.CompactDisc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @Author 王豪豪
 * @Date 2017/5/9 17:41
 */
@Configuration
@ImportResource("classpath:/spring/spring-*.xml")
@ComponentScan(basePackages = "com.whh.*")
public class SpringConfig {
    @Bean(name = "cdPlayer")
    public CDPlayer cdPlayer(CompactDisc compactDisc){
        CDPlayer cdPlayer=new CDPlayer();
        cdPlayer.setCompactDisc(compactDisc);
        return cdPlayer;
    }
}
