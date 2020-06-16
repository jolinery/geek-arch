package com.component2.impl;


import com.component2.Component;

/**
 * @program: component
 * @description: LinkedLable
 * @author: zhanglin16
 * @create: 2020-06-16 21:07
 **/
public class LinkedLable extends Component {

    public LinkedLable(String value){
        super("linkedBox");
        this.value = value;
    }
    /**
     * 组件值
     */
    private String value;

    @Override
    public String toString(){
        return String.format("Component Name:%s,Display value:%s  ",getName(),value);
    }

    @Override
    public void display(){
        System.out.println(this);
    }
}
