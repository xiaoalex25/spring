package com.study.aop.annotationPc;

import com.study.aop.staticPc.Singer;

public class Guitarist implements Singer {

    public void sing() {
        System.out.println("Dream of way to throw it all way");
    }

    public void sing(String  guitar) {
        System.out.println("play：" + guitar);
    }

    public void reset() {
        System.out.println("zzz");
    }
}
