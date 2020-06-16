package com.component2.impl;


import com.component2.Component;

/**
 * @program: component
 * @description: CheckBox
 * @author: zhanglin16
 * @create: 2020-06-16 21:07
 **/
public class CheckBox extends Component {

    public CheckBox(){
        super("checkbox");
    }

    @Override
    public String toString(){
        return String.format("Component Name:%s ",getName());
    }

    @Override
    public void display(){
        System.out.println(this);
    }

}
