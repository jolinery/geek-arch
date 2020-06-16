package com.component2;

import com.component2.impl.*;
import com.component2.impl.Button;
import com.component2.impl.Frame;
import com.component2.impl.CheckBox;


/**
 * 抽象
 */
public class Main {

    public static void main(String[] args) {
        Component windowForm = new WindowForm();
        windowForm.add(new Picture());
        windowForm.add(new Button("登录"));
        windowForm.add(new Button("注册"));
        Component frame = new Frame();
        windowForm.add(frame);
        frame.add(new Lable("用户名"));
        frame.add(new TextBox());
        frame.add(new Lable("密码"));
        frame.add(new PasswordBox());
        frame.add(new CheckBox());
        frame.add(new Lable("记住用户名"));
        frame.add(new LinkedLable("忘记密码"));
        windowForm.display();
    }
}
