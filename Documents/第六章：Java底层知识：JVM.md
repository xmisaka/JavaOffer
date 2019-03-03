## 6-1 谈谈你对Java的理解
- 平台无关性：一次编译，到处运行
- GC：垃圾回收机制
- 语言特性：泛型、反射、lamuda表达式表达式
- 面向对象：封装、继承、多态
- 类库：集合、并发、网络、IO/NIO
- 异常处理

## 6-2 平台无关性如何实现
- 编译时  
使用javac指令，将源码编译生成字节码，并存入到对应的.class文件中。  
```java
package javabasic;

public class ByteCodeSample {
    public static void main(String[] args) {
        int i = 1, j = 5;
        i++;
        ++j;
        System.out.println(i);
        System.out.println(j);
    }
}
```  
使用javac ByteCodeSample.java 编译生成ByteCodeSample.class文件，使用javap -c ByteCodeSample.class对字节码进行反汇编，查看字节码内容。
```java
Compiled from "ByteCodeSample.java"
public class javabasic.ByteCodeSample {
  public javabasic.ByteCodeSample();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: iconst_1                          //将常量1放到栈顶
       1: istore_1                          //将栈顶的值放到局部变量1中
       2: iconst_5                          //将常量2放到栈顶
       3: istore_2                          //将栈顶的值放到局部变量2中
       4: iinc          1, 1                //将变量1加1
       7: iinc          2, 1                //将变量2加1
      10: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
      13: iload_1
      14: invokevirtual #3                  // Method java/io/PrintStream.println:(I)V
      17: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
      20: iload_2
      21: invokevirtual #3                  // Method java/io/PrintStream.println:(I)V
      24: return
}
```  
![java平台无关性](imgs/java平台无关性.png)  
- 运行时  
.class文件是跨平台的基础，Java源码首先被编译成字节码，再由不同平台的JVM进行解析，
Java语言在不同的平台运行时不需要重新进行编译，Java虚拟机在执行字节码的时候，把字节码解释成具体平台上的机器指令。
> Q：为什么JVM不直接将源码解析成机器码去执行  

> A：每次执行的时候都需要进行各种语法、句法、语义的检查，即每次执行的时候这些分析的结果都不会保存下来，
  要重新进行编译，重新去分析，这样整体的性能就会受到影响。同时，也可以脱离Java的束缚，将别的语言解析成字节码，同样能被JVM执行。


## 6-3 JVM如何加载.class文件
![java平台无关性](imgs/JVM内存结构.png)  
- Class Loader ：依据特定格式，加载class文件到内存
- Execution Engine ：对命令进行解析
- Native Interface : 融合不同开发语言的原生库为Java所用
- Runtime Date Area : JVM内存空间结构模型

## 6-4 什么是反射