// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   DataExchangeTest.java

package main;


class User
{

    public User(String aName, char aPassword[])
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #14  <Method void Object()>
        name = aName;
    //    2    4:aload_0         
    //    3    5:aload_1         
    //    4    6:putfield        #16  <Field String name>
        password = aPassword;
    //    5    9:aload_0         
    //    6   10:aload_2         
    //    7   11:putfield        #18  <Field char[] password>
    //    8   14:return          
    }

    public String getName()
    {
        return name;
    //    0    0:aload_0         
    //    1    1:getfield        #16  <Field String name>
    //    2    4:areturn         
    }

    public char[] getPassword()
    {
        return password;
    //    0    0:aload_0         
    //    1    1:getfield        #18  <Field char[] password>
    //    2    4:areturn         
    }

    public void setName(String aName)
    {
        name = aName;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #16  <Field String name>
    //    3    5:return          
    }

    public void setPassword(char aPassword[])
    {
        password = aPassword;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #18  <Field char[] password>
    //    3    5:return          
    }

    private String name;
    private char password[];
}
