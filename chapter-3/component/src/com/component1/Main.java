package com.component1;

/**
 * 简洁版本
 */
public class Main {

    public static void main(String[] args) {
//        Component container = new Component("container");
        Component windowForm = new Component("window form");
//        container.add(windowForm);
        windowForm.add(new Component("picture"));
        windowForm.add(new Component("button","登录"));
        windowForm.add(new Component("button","注册"));
        Component frame = new Component("frame");
        windowForm.add(frame);
        frame.add(new Component("lable","用户名"));
        frame.add(new Component("textbox","文本框"));
        frame.add(new Component("lable","密码"));
        frame.add(new Component("passwordbox"));
        frame.add(new Component("checkbox"));
        frame.add(new Component("lable","记住用户名"));
        frame.add(new Component("linklable","忘记密码"));
        windowForm.display();
    }
}
