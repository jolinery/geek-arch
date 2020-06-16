package com.component2.impl;


import com.component2.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: component
 * @description: 按钮
 * @author: zhanglin16
 * @create: 2020-06-16 21:07
 **/
public class Button extends Component {

    public Button(String value){
        super("button");
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
