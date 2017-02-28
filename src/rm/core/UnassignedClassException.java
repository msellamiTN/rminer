// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   UnassignedClassException.java

package rm.core;


public class UnassignedClassException extends RuntimeException
{

    public UnassignedClassException()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #9   <Method void RuntimeException()>
    //    2    4:return          
    }

    public UnassignedClassException(String message)
    {
        super(message);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokespecial   #16  <Method void RuntimeException(String)>
    //    3    5:return          
    }
}
