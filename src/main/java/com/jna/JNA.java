package com.jna;

import com.sun.jna.Library;
import com.sun.jna.Native;  
import com.sun.jna.Platform;  
  
public class JNA {  
  
    // 定义接口CLibrary，继承自com.sun.jna.Library  
    public interface testdll extends Library {  
        // msvcrt为dll名称,msvcrt目录的位置为:C:\Windows\System32下面,  
        testdll Instance = (testdll) Native.loadLibrary((Platform.isWindows() ? "msvcrt" : "c"),  
                testdll.class);  
        // printf为msvcrt.dll中的一个方法.  
        void printf(String format, Object... args);  
    }  
  
    public static void main(String[] args) {  
        // 调用printf打印信息  
        testdll.Instance.printf("yyyyMMdd");  
    }  
  
}  