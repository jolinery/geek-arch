package com.component2.impl;


import com.component2.Component;

/**
 * @program: component
 * @description: TextBox
 * @author: zhanglin16
 * @create: 2020-06-16 21:07
 **/
public class TextBox extends Component {

    public TextBox(){
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
