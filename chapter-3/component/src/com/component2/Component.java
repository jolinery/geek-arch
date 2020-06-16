package com.component2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: component
 * @description: component

 **/
public abstract class Component {

    /**
     * 组件名
     */
    private String name;

    public Component(String name){
        this.name = name;
    }
    /**
     * 添加子组件
     * @param component
     */
    public void add(Component component){
        throw new UnsupportedOperationException("对象不支持这个功能");
    }

    /**
     * 移除子组件
     * @param component
     */
    public void remove(Component component){
        throw new UnsupportedOperationException("对象不支持这个功能");
    }
    /**
     * 获取组件名
     */
    public String getName(){
        return this.name;
    }

    @Override
    public String toString(){
        return String.format("Component Name:%s ",getName());
    }

    /**
     * 显示组件
     */
    public abstract void display();
}
