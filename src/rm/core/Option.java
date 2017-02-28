// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   Option.java

package rm.core;


public class Option
{

    public Option(String description, String name, int numArguments, String synopsis)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #16  <Method void Object()>
        m_Description = description;
    //    2    4:aload_0         
    //    3    5:aload_1         
    //    4    6:putfield        #18  <Field String m_Description>
        m_Name = name;
    //    5    9:aload_0         
    //    6   10:aload_2         
    //    7   11:putfield        #20  <Field String m_Name>
        m_NumArguments = numArguments;
    //    8   14:aload_0         
    //    9   15:iload_3         
    //   10   16:putfield        #22  <Field int m_NumArguments>
        m_Synopsis = synopsis;
    //   11   19:aload_0         
    //   12   20:aload           4
    //   13   22:putfield        #24  <Field String m_Synopsis>
    //   14   25:return          
    }

    public String description()
    {
        return m_Description;
    //    0    0:aload_0         
    //    1    1:getfield        #18  <Field String m_Description>
    //    2    4:areturn         
    }

    public String name()
    {
        return m_Name;
    //    0    0:aload_0         
    //    1    1:getfield        #20  <Field String m_Name>
    //    2    4:areturn         
    }

    public int numArguments()
    {
        return m_NumArguments;
    //    0    0:aload_0         
    //    1    1:getfield        #22  <Field int m_NumArguments>
    //    2    4:ireturn         
    }

    public String synopsis()
    {
        return m_Synopsis;
    //    0    0:aload_0         
    //    1    1:getfield        #24  <Field String m_Synopsis>
    //    2    4:areturn         
    }

    private String m_Description;
    private String m_Synopsis;
    private String m_Name;
    private int m_NumArguments;
}
