package com.component2.impl;


import com.component2.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: component
 * @description: Frame
 * @author: zhanglin16
 * @create: 2020-06-16 21:07
 **/
public class Frame extends Component {

    public Frame(){
        super("Frame");
        components = new ArrayList<>();
    }

    /**
     * 子组件
     */
    private List<Component> components ;

    /**
     * 添加子组件
     * @param component
     */
    @Override
    public void add(Component component){
        components.add(component);
    }

    /**
     * 移除子组件
     * @param component
     */
    @Override
    public void remove(Component component){
        components.remove(component);
    }

    @Override
    public void display(){
        System.out.println(this);
        if(components != null){
            components.forEach(x->{
                x.display();
            });
        }
    }

}
