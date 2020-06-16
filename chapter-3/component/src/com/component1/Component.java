package com.component1;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: component
 * @description: component

 **/
public class Component {
    private List<Component> components ;

    /**
     * 组件名
     */
    private String name;
    /**
     * 组件值
     */
    private String value;
    public Component(String name){
        this.name = name;
        components = new ArrayList<>();
    }
    public Component(String name,String value){
        this.name = name;
        this.value = value;
        components = new ArrayList<>();
    }
    /**
     * 添加子组件
     * @param component
     */
    public void add(Component component){
        components.add(component);
    }
    /**
     * 移除子组件
     * @param component
     */
    public void remove(Component component){
        components.remove(component);
    }

    @Override
    public String toString(){
        if(value == null){
            return String.format("Component Name:%s",name);
        }
        return String.format("Component Name:%s,Display value:%s  ",name,value);
    }
    public void display(){
        System.out.println(this);
        if(components != null){
            components.forEach(x->{
                x.display();
            });
        }

    }
}
