package com.component2.impl;


import com.component2.Component;

/**
 * @program: component
 * @description: PasswordBox
 * @author: zhanglin16
 * @create: 2020-06-16 21:07
 **/
public class PasswordBox extends Component {

    public PasswordBox(){
        super("button");
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
