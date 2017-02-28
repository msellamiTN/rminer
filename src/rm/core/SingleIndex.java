// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   SingleIndex.java

package rm.core;

import java.io.PrintStream;
import java.io.Serializable;

public class SingleIndex
    implements Serializable
{

    public SingleIndex()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #21  <Method void Object()>
        m_IndexString = "";
    //    2    4:aload_0         
    //    3    5:ldc1            #23  <String "">
    //    4    7:putfield        #25  <Field String m_IndexString>
        m_SelectedIndex = -1;
    //    5   10:aload_0         
    //    6   11:iconst_m1       
    //    7   12:putfield        #27  <Field int m_SelectedIndex>
        m_Upper = -1;
    //    8   15:aload_0         
    //    9   16:iconst_m1       
    //   10   17:putfield        #29  <Field int m_Upper>
    //   11   20:return          
    }

    public SingleIndex(String index)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #21  <Method void Object()>
        m_IndexString = "";
    //    2    4:aload_0         
    //    3    5:ldc1            #23  <String "">
    //    4    7:putfield        #25  <Field String m_IndexString>
        m_SelectedIndex = -1;
    //    5   10:aload_0         
    //    6   11:iconst_m1       
    //    7   12:putfield        #27  <Field int m_SelectedIndex>
        m_Upper = -1;
    //    8   15:aload_0         
    //    9   16:iconst_m1       
    //   10   17:putfield        #29  <Field int m_Upper>
        setSingleIndex(index);
    //   11   20:aload_0         
    //   12   21:aload_1         
    //   13   22:invokevirtual   #37  <Method void setSingleIndex(String)>
    //   14   25:return          
    }

    public void setUpper(int newUpper)
    {
        if(newUpper >= 0)
    //*   0    0:iload_1         
    //*   1    1:iflt            13
        {
            m_Upper = newUpper;
    //    2    4:aload_0         
    //    3    5:iload_1         
    //    4    6:putfield        #29  <Field int m_Upper>
            setValue();
    //    5    9:aload_0         
    //    6   10:invokevirtual   #43  <Method void setValue()>
        }
    //    7   13:return          
    }

    public String getSingleIndex()
    {
        return m_IndexString;
    //    0    0:aload_0         
    //    1    1:getfield        #25  <Field String m_IndexString>
    //    2    4:areturn         
    }

    public void setSingleIndex(String index)
    {
        m_IndexString = index;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #25  <Field String m_IndexString>
        m_SelectedIndex = -1;
    //    3    5:aload_0         
    //    4    6:iconst_m1       
    //    5    7:putfield        #27  <Field int m_SelectedIndex>
    //    6   10:return          
    }

    public String toString()
    {
        if(m_IndexString.equals(""))
    //*   0    0:aload_0         
    //*   1    1:getfield        #25  <Field String m_IndexString>
    //*   2    4:ldc1            #23  <String "">
    //*   3    6:invokevirtual   #53  <Method boolean String.equals(Object)>
    //*   4    9:ifeq            15
            return "No index set";
    //    5   12:ldc1            #55  <String "No index set">
    //    6   14:areturn         
        if(m_Upper == -1)
    //*   7   15:aload_0         
    //*   8   16:getfield        #29  <Field int m_Upper>
    //*   9   19:iconst_m1       
    //*  10   20:icmpne          33
            throw new RuntimeException("Upper limit has not been specified");
    //   11   23:new             #57  <Class RuntimeException>
    //   12   26:dup             
    //   13   27:ldc1            #59  <String "Upper limit has not been specified">
    //   14   29:invokespecial   #61  <Method void RuntimeException(String)>
    //   15   32:athrow          
        else
            return m_IndexString;
    //   16   33:aload_0         
    //   17   34:getfield        #25  <Field String m_IndexString>
    //   18   37:areturn         
    }

    public int getIndex()
    {
        if(m_IndexString.equals(""))
    //*   0    0:aload_0         
    //*   1    1:getfield        #25  <Field String m_IndexString>
    //*   2    4:ldc1            #23  <String "">
    //*   3    6:invokevirtual   #53  <Method boolean String.equals(Object)>
    //*   4    9:ifeq            22
            throw new RuntimeException("No index set");
    //    5   12:new             #57  <Class RuntimeException>
    //    6   15:dup             
    //    7   16:ldc1            #55  <String "No index set">
    //    8   18:invokespecial   #61  <Method void RuntimeException(String)>
    //    9   21:athrow          
        if(m_Upper == -1)
    //*  10   22:aload_0         
    //*  11   23:getfield        #29  <Field int m_Upper>
    //*  12   26:iconst_m1       
    //*  13   27:icmpne          40
            throw new RuntimeException("No upper limit has been specified for index");
    //   14   30:new             #57  <Class RuntimeException>
    //   15   33:dup             
    //   16   34:ldc1            #65  <String "No upper limit has been specified for index">
    //   17   36:invokespecial   #61  <Method void RuntimeException(String)>
    //   18   39:athrow          
        else
            return m_SelectedIndex;
    //   19   40:aload_0         
    //   20   41:getfield        #27  <Field int m_SelectedIndex>
    //   21   44:ireturn         
    }

    public static String indexToString(int index)
    {
        return (new StringBuilder()).append(index + 1).toString();
    //    0    0:new             #69  <Class StringBuilder>
    //    1    3:dup             
    //    2    4:invokespecial   #70  <Method void StringBuilder()>
    //    3    7:iload_0         
    //    4    8:iconst_1        
    //    5    9:iadd            
    //    6   10:invokevirtual   #74  <Method StringBuilder StringBuilder.append(int)>
    //    7   13:invokevirtual   #76  <Method String StringBuilder.toString()>
    //    8   16:areturn         
    }

    protected void setValue()
    {
        if(m_IndexString.equals(""))
    //*   0    0:aload_0         
    //*   1    1:getfield        #25  <Field String m_IndexString>
    //*   2    4:ldc1            #23  <String "">
    //*   3    6:invokevirtual   #53  <Method boolean String.equals(Object)>
    //*   4    9:ifeq            22
            throw new RuntimeException("No index set");
    //    5   12:new             #57  <Class RuntimeException>
    //    6   15:dup             
    //    7   16:ldc1            #55  <String "No index set">
    //    8   18:invokespecial   #61  <Method void RuntimeException(String)>
    //    9   21:athrow          
        if(m_IndexString.toLowerCase().equals("first"))
    //*  10   22:aload_0         
    //*  11   23:getfield        #25  <Field String m_IndexString>
    //*  12   26:invokevirtual   #79  <Method String String.toLowerCase()>
    //*  13   29:ldc1            #81  <String "first">
    //*  14   31:invokevirtual   #53  <Method boolean String.equals(Object)>
    //*  15   34:ifeq            45
            m_SelectedIndex = 0;
    //   16   37:aload_0         
    //   17   38:iconst_0        
    //   18   39:putfield        #27  <Field int m_SelectedIndex>
        else
    //*  19   42:goto            134
        if(m_IndexString.toLowerCase().equals("last"))
    //*  20   45:aload_0         
    //*  21   46:getfield        #25  <Field String m_IndexString>
    //*  22   49:invokevirtual   #79  <Method String String.toLowerCase()>
    //*  23   52:ldc1            #83  <String "last">
    //*  24   54:invokevirtual   #53  <Method boolean String.equals(Object)>
    //*  25   57:ifeq            71
        {
            m_SelectedIndex = m_Upper;
    //   26   60:aload_0         
    //   27   61:aload_0         
    //   28   62:getfield        #29  <Field int m_Upper>
    //   29   65:putfield        #27  <Field int m_SelectedIndex>
        } else
    //*  30   68:goto            134
        {
            m_SelectedIndex = Integer.parseInt(m_IndexString) - 1;
    //   31   71:aload_0         
    //   32   72:aload_0         
    //   33   73:getfield        #25  <Field String m_IndexString>
    //   34   76:invokestatic    #89  <Method int Integer.parseInt(String)>
    //   35   79:iconst_1        
    //   36   80:isub            
    //   37   81:putfield        #27  <Field int m_SelectedIndex>
            if(m_SelectedIndex < 0)
    //*  38   84:aload_0         
    //*  39   85:getfield        #27  <Field int m_SelectedIndex>
    //*  40   88:ifge            107
            {
                m_IndexString = "";
    //   41   91:aload_0         
    //   42   92:ldc1            #23  <String "">
    //   43   94:putfield        #25  <Field String m_IndexString>
                throw new IllegalArgumentException("Index must be greater than zero");
    //   44   97:new             #91  <Class IllegalArgumentException>
    //   45  100:dup             
    //   46  101:ldc1            #93  <String "Index must be greater than zero">
    //   47  103:invokespecial   #94  <Method void IllegalArgumentException(String)>
    //   48  106:athrow          
            }
            if(m_SelectedIndex > m_Upper)
    //*  49  107:aload_0         
    //*  50  108:getfield        #27  <Field int m_SelectedIndex>
    //*  51  111:aload_0         
    //*  52  112:getfield        #29  <Field int m_Upper>
    //*  53  115:icmple          134
            {
                m_IndexString = "";
    //   54  118:aload_0         
    //   55  119:ldc1            #23  <String "">
    //   56  121:putfield        #25  <Field String m_IndexString>
                throw new IllegalArgumentException("Index is too large");
    //   57  124:new             #91  <Class IllegalArgumentException>
    //   58  127:dup             
    //   59  128:ldc1            #96  <String "Index is too large">
    //   60  130:invokespecial   #94  <Method void IllegalArgumentException(String)>
    //   61  133:athrow          
            }
        }
    //   62  134:return          
    }

    public static void main(String argv[])
    {
        try
        {
            if(argv.length == 0)
    //*   0    0:aload_0         
    //*   1    1:arraylength     
    //*   2    2:ifne            15
                throw new Exception("Usage: SingleIndex <indexspec>");
    //    3    5:new             #100 <Class Exception>
    //    4    8:dup             
    //    5    9:ldc1            #102 <String "Usage: SingleIndex <indexspec>">
    //    6   11:invokespecial   #103 <Method void Exception(String)>
    //    7   14:athrow          
            SingleIndex singleIndex = new SingleIndex();
    //    8   15:new             #2   <Class SingleIndex>
    //    9   18:dup             
    //   10   19:invokespecial   #104 <Method void SingleIndex()>
    //   11   22:astore_1        
            singleIndex.setSingleIndex(argv[0]);
    //   12   23:aload_1         
    //   13   24:aload_0         
    //   14   25:iconst_0        
    //   15   26:aaload          
    //   16   27:invokevirtual   #37  <Method void setSingleIndex(String)>
            singleIndex.setUpper(9);
    //   17   30:aload_1         
    //   18   31:bipush          9
    //   19   33:invokevirtual   #106 <Method void setUpper(int)>
            System.out.println((new StringBuilder("Input: ")).append(argv[0]).append("\n").append(singleIndex.toString()).toString());
    //   20   36:getstatic       #112 <Field PrintStream System.out>
    //   21   39:new             #69  <Class StringBuilder>
    //   22   42:dup             
    //   23   43:ldc1            #114 <String "Input: ">
    //   24   45:invokespecial   #115 <Method void StringBuilder(String)>
    //   25   48:aload_0         
    //   26   49:iconst_0        
    //   27   50:aaload          
    //   28   51:invokevirtual   #118 <Method StringBuilder StringBuilder.append(String)>
    //   29   54:ldc1            #120 <String "\n">
    //   30   56:invokevirtual   #118 <Method StringBuilder StringBuilder.append(String)>
    //   31   59:aload_1         
    //   32   60:invokevirtual   #121 <Method String toString()>
    //   33   63:invokevirtual   #118 <Method StringBuilder StringBuilder.append(String)>
    //   34   66:invokevirtual   #76  <Method String StringBuilder.toString()>
    //   35   69:invokevirtual   #126 <Method void PrintStream.println(String)>
            int selectedIndex = singleIndex.getIndex();
    //   36   72:aload_1         
    //   37   73:invokevirtual   #128 <Method int getIndex()>
    //   38   76:istore_2        
            System.out.println((new StringBuilder(String.valueOf(selectedIndex))).toString());
    //   39   77:getstatic       #112 <Field PrintStream System.out>
    //   40   80:new             #69  <Class StringBuilder>
    //   41   83:dup             
    //   42   84:iload_2         
    //   43   85:invokestatic    #131 <Method String String.valueOf(int)>
    //   44   88:invokespecial   #115 <Method void StringBuilder(String)>
    //   45   91:invokevirtual   #76  <Method String StringBuilder.toString()>
    //   46   94:invokevirtual   #126 <Method void PrintStream.println(String)>
        }
    //*  47   97:goto            115
        catch(Exception ex)
    //*  48  100:astore_1        
        {
            ex.printStackTrace();
    //   49  101:aload_1         
    //   50  102:invokevirtual   #134 <Method void Exception.printStackTrace()>
            System.out.println(ex.getMessage());
    //   51  105:getstatic       #112 <Field PrintStream System.out>
    //   52  108:aload_1         
    //   53  109:invokevirtual   #137 <Method String Exception.getMessage()>
    //   54  112:invokevirtual   #126 <Method void PrintStream.println(String)>
        }
    //   55  115:return          
    }

    static final long serialVersionUID = 0x4958b153639be207L;
    protected String m_IndexString;
    protected int m_SelectedIndex;
    protected int m_Upper;
}
