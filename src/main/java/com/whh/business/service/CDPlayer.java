package com.whh.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author 王豪豪
 * @Date 2017/5/9 18:19
 */
@Component
public class CDPlayer {
    @Autowired
    private CompactDisc compactDisc;
    public void play(){
        compactDisc.play();
    }
}
