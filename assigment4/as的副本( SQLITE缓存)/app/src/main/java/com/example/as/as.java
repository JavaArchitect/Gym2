package com.example.as;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

public class as extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this, "f4f8d4149893215ba412a29d8ac63ff1");
        setContentView(R.layout.activity_as);
    }

    /** Called when the user taps the Send button */
    public void Login(View view) {
        // Do something in response to button
        String name="";
        EditText editText1 =(EditText)findViewById(R.id.ac);
        name=editText1.getText().toString();
        String pass="";
        EditText editText2 =(EditText)findViewById(R.id.ps);
        pass=editText2.getText().toString();
        BmobQuery<Person> query=new BmobQuery<Person>();
        query.addWhereEqualTo("name",name);
        query.addWhereEqualTo("address",pass);
        query.findObjects(new FindListener<Person>() {
            @Override
            public void done(List<Person> list, BmobException e) {
                if(list.size()>0){
                    toast("成功登录");
                    Intent gotoMainContent=new Intent(as.this,home.class);
                    startActivity(gotoMainContent);
                }
                else {
                    toast("您输入的账户名或者密码有误");
                }
            }
        });
    }
    public void Register(View view) {
        // Do something in response to button

        String str1="";
        EditText editText1 =(EditText)findViewById(R.id.ac);
        str1=editText1.getText().toString();
        String str2="";
        EditText editText2 =(EditText)findViewById(R.id.ps);
        str2=editText2.getText().toString();

        Person p2 = new Person();
        p2.setName(str1);
        p2.setAddress(str2);
        p2.save(new SaveListener<String>() {
            @Override
            public void done(String objectId,BmobException e) {
                if(e==null){
                    toast("添加数据成功，返回objectId为："+objectId);

                }else{
                    toast("创建数据失败：" + e.getMessage());
                    //System.out.print("666"+e.getMessage());
                }
            }
        });

    }
    public void toast(String msg){
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }
}
