package com.component2.impl;


import com.component2.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: component
 * @description: Picture
 * @author: zhanglin16
 * @create: 2020-06-16 21:07
 **/
public class Picture extends Component {

    public Picture(){
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
