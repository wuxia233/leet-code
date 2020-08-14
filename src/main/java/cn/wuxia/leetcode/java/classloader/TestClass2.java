package cn.wuxia.leetcode.java.classloader;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: WuXia
 * @Email: wuxia1@szunicom.com
 * @Date: 2020/8/13 17:21
 */
@Slf4j
public class TestClass2 {
    public static void main(String[] args) {
        ClassInit2 init=new ClassInit2();
        log.info("x:{}  y:{}", init.x, init.y);
    }
}

class ClassInit2{
    public int x;
    public int y=111;
    public ClassInit2(){
        x=1;
        y=1;
    }
    {
        x=2;
        y=2;
    }
    {
        x=3;
        y=3;
    }
}

/**
 //实例化步骤为：先为属性分配空间，再执行赋默认值，然后按照顺序执行代码块或赋初始值，最后执行构造方法
 //根据上述代码，init方法的伪代码如下：
 init(){
 x=0;//赋默认值
 y=0;//赋默认值
 y=111;//赋初值
 x=2;//从上到下执行第一个代码块
 y=2;//从上到下执行第一个代码块
 x=3;//从上到下执行第二个代码块
 y=3;//从上到下执行第二个代码块
 //ClassInit();执行构造方法
 x=1;//最后执行构造方法
 y=1;//最后执行构造方法
 }
 //如果上述代码的成员变量x,y的定义在类最后时，那么init方法的伪代码如下：
 init(){
 x=0;//赋默认值
 y=0;//赋默认值
 x=2;//从上到下执行第一个代码块
 y=2;//从上到下执行第一个代码块
 x=3;//从上到下执行第二个代码块
 y=3;//从上到下执行第二个代码块
 y=111;//赋初值
 //ClassInit();执行构造方法
 x=1;//最后执行构造方法
 y=1;//最后执行构造方法
 }*/