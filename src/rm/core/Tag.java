// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   Tag.java

package rm.core;

import java.io.Serializable;

public class Tag
    implements Serializable
{

    public Tag()
    {
        this(0, "A new tag", "A new tag", true);
    //    0    0:aload_0         
    //    1    1:iconst_0        
    //    2    2:ldc1            #16  <String "A new tag">
    //    3    4:ldc1            #16  <String "A new tag">
    //    4    6:iconst_1        
    //    5    7:invokespecial   #19  <Method void Tag(int, String, String, boolean)>
    //    6   10:return          
    }

    public Tag(int ident, String readable)
    {
        this(ident, "", readable);
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:ldc1            #26  <String "">
    //    3    4:aload_2         
    //    4    5:invokespecial   #29  <Method void Tag(int, String, String)>
    //    5    8:return          
    }

    public Tag(int ident, String identStr, String readable)
    {
        this(ident, identStr, readable, true);
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:aload_2         
    //    3    3:aload_3         
    //    4    4:iconst_1        
    //    5    5:invokespecial   #19  <Method void Tag(int, String, String, boolean)>
    //    6    8:return          
    }

    public Tag(int ident, String identStr, String readable, boolean upperCase)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #34  <Method void Object()>
        m_ID = ident;
    //    2    4:aload_0         
    //    3    5:iload_1         
    //    4    6:putfield        #36  <Field int m_ID>
        if(identStr.length() == 0)
    //*   5    9:aload_2         
    //*   6   10:invokevirtual   #42  <Method int String.length()>
    //*   7   13:ifne            37
        {
            m_IDStr = (new StringBuilder()).append(ident).toString();
    //    8   16:aload_0         
    //    9   17:new             #44  <Class StringBuilder>
    //   10   20:dup             
    //   11   21:invokespecial   #45  <Method void StringBuilder()>
    //   12   24:iload_1         
    //   13   25:invokevirtual   #49  <Method StringBuilder StringBuilder.append(int)>
    //   14   28:invokevirtual   #53  <Method String StringBuilder.toString()>
    //   15   31:putfield        #55  <Field String m_IDStr>
        } else
    //*  16   34:goto            55
        {
            m_IDStr = identStr;
    //   17   37:aload_0         
    //   18   38:aload_2         
    //   19   39:putfield        #55  <Field String m_IDStr>
            if(upperCase)
    //*  20   42:iload           4
    //*  21   44:ifeq            55
                m_IDStr = identStr.toUpperCase();
    //   22   47:aload_0         
    //   23   48:aload_2         
    //   24   49:invokevirtual   #58  <Method String String.toUpperCase()>
    //   25   52:putfield        #55  <Field String m_IDStr>
        }
        m_Readable = readable;
    //   26   55:aload_0         
    //   27   56:aload_3         
    //   28   57:putfield        #60  <Field String m_Readable>
    //   29   60:return          
    }

    public int getID()
    {
        return m_ID;
    //    0    0:aload_0         
    //    1    1:getfield        #36  <Field int m_ID>
    //    2    4:ireturn         
    }

    public void setID(int id)
    {
        m_ID = id;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #36  <Field int m_ID>
    //    3    5:return          
    }

    public String getIDStr()
    {
        return m_IDStr;
    //    0    0:aload_0         
    //    1    1:getfield        #55  <Field String m_IDStr>
    //    2    4:areturn         
    }

    public void setIDStr(String str)
    {
        m_IDStr = str;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #55  <Field String m_IDStr>
    //    3    5:return          
    }

    public String getReadable()
    {
        return m_Readable;
    //    0    0:aload_0         
    //    1    1:getfield        #60  <Field String m_Readable>
    //    2    4:areturn         
    }

    public void setReadable(String r)
    {
        m_Readable = r;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #60  <Field String m_Readable>
    //    3    5:return          
    }

    public String toString()
    {
        return m_IDStr;
    //    0    0:aload_0         
    //    1    1:getfield        #55  <Field String m_IDStr>
    //    2    4:areturn         
    }

    public static String toOptionList(Tag tags[])
    {
        String result = "<";
    //    0    0:ldc1            #77  <String "<">
    //    1    2:astore_1        
        for(int i = 0; i < tags.length; i++)
    //*   2    3:iconst_0        
    //*   3    4:istore_2        
    //*   4    5:goto            56
        {
            if(i > 0)
    //*   5    8:iload_2         
    //*   6    9:ifle            32
                result = (new StringBuilder(String.valueOf(result))).append("|").toString();
    //    7   12:new             #44  <Class StringBuilder>
    //    8   15:dup             
    //    9   16:aload_1         
    //   10   17:invokestatic    #81  <Method String String.valueOf(Object)>
    //   11   20:invokespecial   #83  <Method void StringBuilder(String)>
    //   12   23:ldc1            #85  <String "|">
    //   13   25:invokevirtual   #88  <Method StringBuilder StringBuilder.append(String)>
    //   14   28:invokevirtual   #53  <Method String StringBuilder.toString()>
    //   15   31:astore_1        
            result = (new StringBuilder(String.valueOf(result))).append(tags[i]).toString();
    //   16   32:new             #44  <Class StringBuilder>
    //   17   35:dup             
    //   18   36:aload_1         
    //   19   37:invokestatic    #81  <Method String String.valueOf(Object)>
    //   20   40:invokespecial   #83  <Method void StringBuilder(String)>
    //   21   43:aload_0         
    //   22   44:iload_2         
    //   23   45:aaload          
    //   24   46:invokevirtual   #91  <Method StringBuilder StringBuilder.append(Object)>
    //   25   49:invokevirtual   #53  <Method String StringBuilder.toString()>
    //   26   52:astore_1        
        }

    //   27   53:iinc            2  1
    //   28   56:iload_2         
    //   29   57:aload_0         
    //   30   58:arraylength     
    //   31   59:icmplt          8
        result = (new StringBuilder(String.valueOf(result))).append(">").toString();
    //   32   62:new             #44  <Class StringBuilder>
    //   33   65:dup             
    //   34   66:aload_1         
    //   35   67:invokestatic    #81  <Method String String.valueOf(Object)>
    //   36   70:invokespecial   #83  <Method void StringBuilder(String)>
    //   37   73:ldc1            #93  <String ">">
    //   38   75:invokevirtual   #88  <Method StringBuilder StringBuilder.append(String)>
    //   39   78:invokevirtual   #53  <Method String StringBuilder.toString()>
    //   40   81:astore_1        
        return result;
    //   41   82:aload_1         
    //   42   83:areturn         
    }

    public static String toOptionSynopsis(Tag tags[])
    {
        String result = "";
    //    0    0:ldc1            #26  <String "">
    //    1    2:astore_1        
        for(int i = 0; i < tags.length; i++)
    //*   2    3:iconst_0        
    //*   3    4:istore_2        
    //*   4    5:goto            59
            result = (new StringBuilder(String.valueOf(result))).append("\t\t").append(tags[i].getIDStr()).append(" = ").append(tags[i].getReadable()).append("\n").toString();
    //    5    8:new             #44  <Class StringBuilder>
    //    6   11:dup             
    //    7   12:aload_1         
    //    8   13:invokestatic    #81  <Method String String.valueOf(Object)>
    //    9   16:invokespecial   #83  <Method void StringBuilder(String)>
    //   10   19:ldc1            #100 <String "\t\t">
    //   11   21:invokevirtual   #88  <Method StringBuilder StringBuilder.append(String)>
    //   12   24:aload_0         
    //   13   25:iload_2         
    //   14   26:aaload          
    //   15   27:invokevirtual   #102 <Method String getIDStr()>
    //   16   30:invokevirtual   #88  <Method StringBuilder StringBuilder.append(String)>
    //   17   33:ldc1            #104 <String " = ">
    //   18   35:invokevirtual   #88  <Method StringBuilder StringBuilder.append(String)>
    //   19   38:aload_0         
    //   20   39:iload_2         
    //   21   40:aaload          
    //   22   41:invokevirtual   #106 <Method String getReadable()>
    //   23   44:invokevirtual   #88  <Method StringBuilder StringBuilder.append(String)>
    //   24   47:ldc1            #108 <String "\n">
    //   25   49:invokevirtual   #88  <Method StringBuilder StringBuilder.append(String)>
    //   26   52:invokevirtual   #53  <Method String StringBuilder.toString()>
    //   27   55:astore_1        

    //   28   56:iinc            2  1
    //   29   59:iload_2         
    //   30   60:aload_0         
    //   31   61:arraylength     
    //   32   62:icmplt          8
        return result;
    //   33   65:aload_1         
    //   34   66:areturn         
    }

    protected int m_ID;
    protected String m_IDStr;
    protected String m_Readable;
}
