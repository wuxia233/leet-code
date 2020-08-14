package cn.wuxia.leetcode.java.classloader;

/**
 * @Author: WuXia
 * @Email: wuxia1@szunicom.com
 * @Date: 2020/8/13 17:10
 */
public class TestClass {
    public static void main(String[] args) {
        ClassInit init=ClassInit.newInstance();

        System.out.println(init.x);
        System.out.println(init.y);
    }
}

class ClassInit{
    private static ClassInit init=new ClassInit();
    public static int x;
    public static int y=0;
    static{
        x++;
        y++;
    }
    private ClassInit(){
        x++;
        y++;
    }
    public static ClassInit newInstance(){
        return init;
    }
}

/**
 * //在类加载到连接完成阶段，ClassInit类在内存中的状态为：init=null,x=0,y=0
 * //初始化阶段时，需要执行clinit方法，该方法类似如下伪代码：
 * clinit(){
 * 	//init=new ClassInit();调用构造方法
 *     x++;//x=1 因为此时x的值为连接的准备阶段赋的默认值0，然后++变成1
 *     y++;//y=1 因为此时y的值为连接的准备阶段赋的默认值0，然后++变成1
 *     //x=0;//为什么这里没有执行x=0，因为程序没有给x赋初值，因此在初始化阶段时，不会执行赋初值操作
 *     y=0;//因为类变量y在定义时，指定了初值，尽管初值为0，因此在初始化阶段的时候，需要执行赋初值操作
 *     x++;//第一个静态块的自增操作，结果为x=2;
 *     y++;//第一个静态块的自增操作，结果为y=1;
 * }
 * //所以最终结果为x=2,y=1
 * //如果private static ClassInit init=new ClassInit(); 代码在public static int y=0;后面，那么clinit方法的伪代码如下：
 * clinit(){
 *     //x=0;//这里虽然没有执行，但此时x的值为连接的准备阶段赋的默认值0
 *     y=0;//因为类变量y在定义时，指定了初值，尽管初值为0，因此在初始化阶段的时候，需要执行赋初值操作
 * 	//init=new ClassInit();调用构造方法
 *     x++;//x=1 因为此时x的值为连接的准备阶段赋的默认值0，然后++变成1
 *     y++;//y=1 因为此时y的值为初始化阶段赋的初值，只是这个初值刚好等于默认值0而已，然后++变成1
 *     x++;//第一个静态块的自增操作，结果为x=2;
 *     y++;//第一个静态块的自增操作，结果为y=2;
 * }
 * //最终结果为x=2,y=2
 */
