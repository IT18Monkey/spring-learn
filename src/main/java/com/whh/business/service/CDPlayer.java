package com.whh.business.service;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author 王豪豪
 * @Date 2017/5/9 18:19
 */
public class CDPlayer {
    private CompactDisc compactDisc;

    public CompactDisc getCompactDisc() {
        return compactDisc;
    }

    public void setCompactDisc(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }

    public void play(){
        compactDisc.play();
    }
}
