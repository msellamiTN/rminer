// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   Range.java

package rm.core;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.Vector;

public class Range
    implements Serializable
{

    public Range()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #24  <Method void Object()>
        m_RangeStrings = new Vector();
    //    2    4:aload_0         
    //    3    5:new             #26  <Class Vector>
    //    4    8:dup             
    //    5    9:invokespecial   #27  <Method void Vector()>
    //    6   12:putfield        #29  <Field Vector m_RangeStrings>
        m_Upper = -1;
    //    7   15:aload_0         
    //    8   16:iconst_m1       
    //    9   17:putfield        #31  <Field int m_Upper>
    //   10   20:return          
    }

    public Range(String rangeList)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #24  <Method void Object()>
        m_RangeStrings = new Vector();
    //    2    4:aload_0         
    //    3    5:new             #26  <Class Vector>
    //    4    8:dup             
    //    5    9:invokespecial   #27  <Method void Vector()>
    //    6   12:putfield        #29  <Field Vector m_RangeStrings>
        m_Upper = -1;
    //    7   15:aload_0         
    //    8   16:iconst_m1       
    //    9   17:putfield        #31  <Field int m_Upper>
        setRanges(rangeList);
    //   10   20:aload_0         
    //   11   21:aload_1         
    //   12   22:invokevirtual   #39  <Method void setRanges(String)>
    //   13   25:return          
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
    //    4    6:putfield        #31  <Field int m_Upper>
            setFlags();
    //    5    9:aload_0         
    //    6   10:invokevirtual   #46  <Method void setFlags()>
        }
    //    7   13:return          
    }

    public boolean getInvert()
    {
        return m_Invert;
    //    0    0:aload_0         
    //    1    1:getfield        #51  <Field boolean m_Invert>
    //    2    4:ireturn         
    }

    public void setInvert(boolean newSetting)
    {
        m_Invert = newSetting;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #51  <Field boolean m_Invert>
    //    3    5:return          
    }

    public String getRanges()
    {
        StringBuffer result = new StringBuffer(m_RangeStrings.size() * 4);
    //    0    0:new             #58  <Class StringBuffer>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:getfield        #29  <Field Vector m_RangeStrings>
    //    4    8:invokevirtual   #62  <Method int Vector.size()>
    //    5   11:iconst_4        
    //    6   12:imul            
    //    7   13:invokespecial   #64  <Method void StringBuffer(int)>
    //    8   16:astore_1        
        boolean first = true;
    //    9   17:iconst_1        
    //   10   18:istore_2        
        char sep = ',';
    //   11   19:bipush          44
    //   12   21:istore_3        
        for(int i = 0; i < m_RangeStrings.size(); i++)
    //*  13   22:iconst_0        
    //*  14   23:istore          4
    //*  15   25:goto            97
            if(first)
    //*  16   28:iload_2         
    //*  17   29:ifeq            57
            {
                result.append((String)(String)m_RangeStrings.elementAt(i));
    //   18   32:aload_1         
    //   19   33:aload_0         
    //   20   34:getfield        #29  <Field Vector m_RangeStrings>
    //   21   37:iload           4
    //   22   39:invokevirtual   #68  <Method Object Vector.elementAt(int)>
    //   23   42:checkcast       #70  <Class String>
    //   24   45:checkcast       #70  <Class String>
    //   25   48:invokevirtual   #74  <Method StringBuffer StringBuffer.append(String)>
    //   26   51:pop             
                first = false;
    //   27   52:iconst_0        
    //   28   53:istore_2        
            } else
    //*  29   54:goto            94
            {
                result.append((new StringBuilder(String.valueOf(sep))).append((String)(String)m_RangeStrings.elementAt(i)).toString());
    //   30   57:aload_1         
    //   31   58:new             #76  <Class StringBuilder>
    //   32   61:dup             
    //   33   62:iload_3         
    //   34   63:invokestatic    #80  <Method String String.valueOf(char)>
    //   35   66:invokespecial   #82  <Method void StringBuilder(String)>
    //   36   69:aload_0         
    //   37   70:getfield        #29  <Field Vector m_RangeStrings>
    //   38   73:iload           4
    //   39   75:invokevirtual   #68  <Method Object Vector.elementAt(int)>
    //   40   78:checkcast       #70  <Class String>
    //   41   81:checkcast       #70  <Class String>
    //   42   84:invokevirtual   #85  <Method StringBuilder StringBuilder.append(String)>
    //   43   87:invokevirtual   #88  <Method String StringBuilder.toString()>
    //   44   90:invokevirtual   #74  <Method StringBuffer StringBuffer.append(String)>
    //   45   93:pop             
            }

    //   46   94:iinc            4  1
    //   47   97:iload           4
    //   48   99:aload_0         
    //   49  100:getfield        #29  <Field Vector m_RangeStrings>
    //   50  103:invokevirtual   #62  <Method int Vector.size()>
    //   51  106:icmplt          28
        return result.toString();
    //   52  109:aload_1         
    //   53  110:invokevirtual   #89  <Method String StringBuffer.toString()>
    //   54  113:areturn         
    }

    public void setRanges(String rangeList)
    {
        Vector ranges = new Vector(10);
    //    0    0:new             #26  <Class Vector>
    //    1    3:dup             
    //    2    4:bipush          10
    //    3    6:invokespecial   #96  <Method void Vector(int)>
    //    4    9:astore_2        
    //*   5   10:goto            75
        while(!rangeList.equals("")) 
        {
            String range = rangeList.trim();
    //    6   13:aload_1         
    //    7   14:invokevirtual   #99  <Method String String.trim()>
    //    8   17:astore_3        
            int commaLoc = rangeList.indexOf(',');
    //    9   18:aload_1         
    //   10   19:bipush          44
    //   11   21:invokevirtual   #103 <Method int String.indexOf(int)>
    //   12   24:istore          4
            if(commaLoc != -1)
    //*  13   26:iload           4
    //*  14   28:iconst_m1       
    //*  15   29:icmpeq          58
            {
                range = rangeList.substring(0, commaLoc).trim();
    //   16   32:aload_1         
    //   17   33:iconst_0        
    //   18   34:iload           4
    //   19   36:invokevirtual   #107 <Method String String.substring(int, int)>
    //   20   39:invokevirtual   #99  <Method String String.trim()>
    //   21   42:astore_3        
                rangeList = rangeList.substring(commaLoc + 1).trim();
    //   22   43:aload_1         
    //   23   44:iload           4
    //   24   46:iconst_1        
    //   25   47:iadd            
    //   26   48:invokevirtual   #110 <Method String String.substring(int)>
    //   27   51:invokevirtual   #99  <Method String String.trim()>
    //   28   54:astore_1        
            } else
    //*  29   55:goto            61
            {
                rangeList = "";
    //   30   58:ldc1            #112 <String "">
    //   31   60:astore_1        
            }
            if(!range.equals(""))
    //*  32   61:aload_3         
    //*  33   62:ldc1            #112 <String "">
    //*  34   64:invokevirtual   #116 <Method boolean String.equals(Object)>
    //*  35   67:ifne            75
                ranges.addElement(range);
    //   36   70:aload_2         
    //   37   71:aload_3         
    //   38   72:invokevirtual   #120 <Method void Vector.addElement(Object)>
        }
    //   39   75:aload_1         
    //   40   76:ldc1            #112 <String "">
    //   41   78:invokevirtual   #116 <Method boolean String.equals(Object)>
    //   42   81:ifeq            13
        m_RangeStrings = ranges;
    //   43   84:aload_0         
    //   44   85:aload_2         
    //   45   86:putfield        #29  <Field Vector m_RangeStrings>
        m_SelectFlags = null;
    //   46   89:aload_0         
    //   47   90:aconst_null     
    //   48   91:putfield        #122 <Field boolean[] m_SelectFlags>
    //   49   94:return          
    }

    public boolean isInRange(int index)
    {
        if(m_Upper == -1)
    //*   0    0:aload_0         
    //*   1    1:getfield        #31  <Field int m_Upper>
    //*   2    4:iconst_m1       
    //*   3    5:icmpne          18
            throw new RuntimeException("No upper limit has been specified for range");
    //    4    8:new             #129 <Class RuntimeException>
    //    5   11:dup             
    //    6   12:ldc1            #131 <String "No upper limit has been specified for range">
    //    7   14:invokespecial   #132 <Method void RuntimeException(String)>
    //    8   17:athrow          
        if(m_Invert)
    //*   9   18:aload_0         
    //*  10   19:getfield        #51  <Field boolean m_Invert>
    //*  11   22:ifeq            40
            return !m_SelectFlags[index];
    //   12   25:aload_0         
    //   13   26:getfield        #122 <Field boolean[] m_SelectFlags>
    //   14   29:iload_1         
    //   15   30:baload          
    //   16   31:ifeq            38
    //   17   34:iconst_0        
    //   18   35:goto            39
    //   19   38:iconst_1        
    //   20   39:ireturn         
        else
            return m_SelectFlags[index];
    //   21   40:aload_0         
    //   22   41:getfield        #122 <Field boolean[] m_SelectFlags>
    //   23   44:iload_1         
    //   24   45:baload          
    //   25   46:ireturn         
    }

    public String toString()
    {
        if(m_RangeStrings.size() == 0)
    //*   0    0:aload_0         
    //*   1    1:getfield        #29  <Field Vector m_RangeStrings>
    //*   2    4:invokevirtual   #62  <Method int Vector.size()>
    //*   3    7:ifne            13
            return "Empty";
    //    4   10:ldc1            #135 <String "Empty">
    //    5   12:areturn         
        String result = "Strings: ";
    //    6   13:ldc1            #137 <String "Strings: ">
    //    7   15:astore_1        
        for(Enumeration enu = m_RangeStrings.elements(); enu.hasMoreElements();)
    //*   8   16:aload_0         
    //*   9   17:getfield        #29  <Field Vector m_RangeStrings>
    //*  10   20:invokevirtual   #141 <Method Enumeration Vector.elements()>
    //*  11   23:astore_2        
    //*  12   24:goto            62
            result = (new StringBuilder(String.valueOf(result))).append((String)(String)enu.nextElement()).append(" ").toString();
    //   13   27:new             #76  <Class StringBuilder>
    //   14   30:dup             
    //   15   31:aload_1         
    //   16   32:invokestatic    #144 <Method String String.valueOf(Object)>
    //   17   35:invokespecial   #82  <Method void StringBuilder(String)>
    //   18   38:aload_2         
    //   19   39:invokeinterface #150 <Method Object Enumeration.nextElement()>
    //   20   44:checkcast       #70  <Class String>
    //   21   47:checkcast       #70  <Class String>
    //   22   50:invokevirtual   #85  <Method StringBuilder StringBuilder.append(String)>
    //   23   53:ldc1            #152 <String " ">
    //   24   55:invokevirtual   #85  <Method StringBuilder StringBuilder.append(String)>
    //   25   58:invokevirtual   #88  <Method String StringBuilder.toString()>
    //   26   61:astore_1        

    //   27   62:aload_2         
    //   28   63:invokeinterface #155 <Method boolean Enumeration.hasMoreElements()>
    //   29   68:ifne            27
        result = (new StringBuilder(String.valueOf(result))).append("\n").toString();
    //   30   71:new             #76  <Class StringBuilder>
    //   31   74:dup             
    //   32   75:aload_1         
    //   33   76:invokestatic    #144 <Method String String.valueOf(Object)>
    //   34   79:invokespecial   #82  <Method void StringBuilder(String)>
    //   35   82:ldc1            #157 <String "\n">
    //   36   84:invokevirtual   #85  <Method StringBuilder StringBuilder.append(String)>
    //   37   87:invokevirtual   #88  <Method String StringBuilder.toString()>
    //   38   90:astore_1        
        result = (new StringBuilder(String.valueOf(result))).append("Invert: ").append(m_Invert).append("\n").toString();
    //   39   91:new             #76  <Class StringBuilder>
    //   40   94:dup             
    //   41   95:aload_1         
    //   42   96:invokestatic    #144 <Method String String.valueOf(Object)>
    //   43   99:invokespecial   #82  <Method void StringBuilder(String)>
    //   44  102:ldc1            #159 <String "Invert: ">
    //   45  104:invokevirtual   #85  <Method StringBuilder StringBuilder.append(String)>
    //   46  107:aload_0         
    //   47  108:getfield        #51  <Field boolean m_Invert>
    //   48  111:invokevirtual   #162 <Method StringBuilder StringBuilder.append(boolean)>
    //   49  114:ldc1            #157 <String "\n">
    //   50  116:invokevirtual   #85  <Method StringBuilder StringBuilder.append(String)>
    //   51  119:invokevirtual   #88  <Method String StringBuilder.toString()>
    //   52  122:astore_1        
        try
        {
            if(m_Upper == -1)
    //*  53  123:aload_0         
    //*  54  124:getfield        #31  <Field int m_Upper>
    //*  55  127:iconst_m1       
    //*  56  128:icmpne          141
                throw new RuntimeException("Upper limit has not been specified");
    //   57  131:new             #129 <Class RuntimeException>
    //   58  134:dup             
    //   59  135:ldc1            #164 <String "Upper limit has not been specified">
    //   60  137:invokespecial   #132 <Method void RuntimeException(String)>
    //   61  140:athrow          
            String cols = null;
    //   62  141:aconst_null     
    //   63  142:astore_3        
            for(int i = 0; i < m_SelectFlags.length; i++)
    //*  64  143:iconst_0        
    //*  65  144:istore          4
    //*  66  146:goto            215
                if(isInRange(i))
    //*  67  149:aload_0         
    //*  68  150:iload           4
    //*  69  152:invokevirtual   #166 <Method boolean isInRange(int)>
    //*  70  155:ifeq            212
                    if(cols == null)
    //*  71  158:aload_3         
    //*  72  159:ifnonnull       185
                        cols = (new StringBuilder("Cols: ")).append(i + 1).toString();
    //   73  162:new             #76  <Class StringBuilder>
    //   74  165:dup             
    //   75  166:ldc1            #168 <String "Cols: ">
    //   76  168:invokespecial   #82  <Method void StringBuilder(String)>
    //   77  171:iload           4
    //   78  173:iconst_1        
    //   79  174:iadd            
    //   80  175:invokevirtual   #171 <Method StringBuilder StringBuilder.append(int)>
    //   81  178:invokevirtual   #88  <Method String StringBuilder.toString()>
    //   82  181:astore_3        
                    else
    //*  83  182:goto            212
                        cols = (new StringBuilder(String.valueOf(cols))).append(",").append(i + 1).toString();
    //   84  185:new             #76  <Class StringBuilder>
    //   85  188:dup             
    //   86  189:aload_3         
    //   87  190:invokestatic    #144 <Method String String.valueOf(Object)>
    //   88  193:invokespecial   #82  <Method void StringBuilder(String)>
    //   89  196:ldc1            #173 <String ",">
    //   90  198:invokevirtual   #85  <Method StringBuilder StringBuilder.append(String)>
    //   91  201:iload           4
    //   92  203:iconst_1        
    //   93  204:iadd            
    //   94  205:invokevirtual   #171 <Method StringBuilder StringBuilder.append(int)>
    //   95  208:invokevirtual   #88  <Method String StringBuilder.toString()>
    //   96  211:astore_3        

    //   97  212:iinc            4  1
    //   98  215:iload           4
    //   99  217:aload_0         
    //  100  218:getfield        #122 <Field boolean[] m_SelectFlags>
    //  101  221:arraylength     
    //  102  222:icmplt          149
            if(cols != null)
    //* 103  225:aload_3         
    //* 104  226:ifnull          279
                result = (new StringBuilder(String.valueOf(result))).append(cols).append("\n").toString();
    //  105  229:new             #76  <Class StringBuilder>
    //  106  232:dup             
    //  107  233:aload_1         
    //  108  234:invokestatic    #144 <Method String String.valueOf(Object)>
    //  109  237:invokespecial   #82  <Method void StringBuilder(String)>
    //  110  240:aload_3         
    //  111  241:invokevirtual   #85  <Method StringBuilder StringBuilder.append(String)>
    //  112  244:ldc1            #157 <String "\n">
    //  113  246:invokevirtual   #85  <Method StringBuilder StringBuilder.append(String)>
    //  114  249:invokevirtual   #88  <Method String StringBuilder.toString()>
    //  115  252:astore_1        
        }
    //* 116  253:goto            279
        catch(Exception ex)
    //* 117  256:astore_3        
        {
            result = (new StringBuilder(String.valueOf(result))).append(ex.getMessage()).toString();
    //  118  257:new             #76  <Class StringBuilder>
    //  119  260:dup             
    //  120  261:aload_1         
    //  121  262:invokestatic    #144 <Method String String.valueOf(Object)>
    //  122  265:invokespecial   #82  <Method void StringBuilder(String)>
    //  123  268:aload_3         
    //  124  269:invokevirtual   #178 <Method String Exception.getMessage()>
    //  125  272:invokevirtual   #85  <Method StringBuilder StringBuilder.append(String)>
    //  126  275:invokevirtual   #88  <Method String StringBuilder.toString()>
    //  127  278:astore_1        
        }
        return result;
    //  128  279:aload_1         
    //  129  280:areturn         
    }

    public int[] getSelection()
    {
        if(m_Upper == -1)
    //*   0    0:aload_0         
    //*   1    1:getfield        #31  <Field int m_Upper>
    //*   2    4:iconst_m1       
    //*   3    5:icmpne          18
            throw new RuntimeException("No upper limit has been specified for range");
    //    4    8:new             #129 <Class RuntimeException>
    //    5   11:dup             
    //    6   12:ldc1            #131 <String "No upper limit has been specified for range">
    //    7   14:invokespecial   #132 <Method void RuntimeException(String)>
    //    8   17:athrow          
        int selectIndices[] = new int[m_Upper + 1];
    //    9   18:aload_0         
    //   10   19:getfield        #31  <Field int m_Upper>
    //   11   22:iconst_1        
    //   12   23:iadd            
    //   13   24:newarray        int[]
    //   14   26:astore_1        
        int numSelected = 0;
    //   15   27:iconst_0        
    //   16   28:istore_2        
        if(m_Invert)
    //*  17   29:aload_0         
    //*  18   30:getfield        #51  <Field boolean m_Invert>
    //*  19   33:ifeq            71
        {
            for(int i = 0; i <= m_Upper; i++)
    //*  20   36:iconst_0        
    //*  21   37:istore_3        
    //*  22   38:goto            60
                if(!m_SelectFlags[i])
    //*  23   41:aload_0         
    //*  24   42:getfield        #122 <Field boolean[] m_SelectFlags>
    //*  25   45:iload_3         
    //*  26   46:baload          
    //*  27   47:ifne            57
                    selectIndices[numSelected++] = i;
    //   28   50:aload_1         
    //   29   51:iload_2         
    //   30   52:iinc            2  1
    //   31   55:iload_3         
    //   32   56:iastore         

    //   33   57:iinc            3  1
    //   34   60:iload_3         
    //   35   61:aload_0         
    //   36   62:getfield        #31  <Field int m_Upper>
    //   37   65:icmple          41
        } else
    //*  38   68:goto            165
        {
            for(Enumeration enu = m_RangeStrings.elements(); enu.hasMoreElements();)
    //*  39   71:aload_0         
    //*  40   72:getfield        #29  <Field Vector m_RangeStrings>
    //*  41   75:invokevirtual   #141 <Method Enumeration Vector.elements()>
    //*  42   78:astore_3        
    //*  43   79:goto            156
            {
                String currentRange = (String)(String)enu.nextElement();
    //   44   82:aload_3         
    //   45   83:invokeinterface #150 <Method Object Enumeration.nextElement()>
    //   46   88:checkcast       #70  <Class String>
    //   47   91:checkcast       #70  <Class String>
    //   48   94:astore          4
                int start = rangeLower(currentRange);
    //   49   96:aload_0         
    //   50   97:aload           4
    //   51   99:invokevirtual   #189 <Method int rangeLower(String)>
    //   52  102:istore          5
                int end = rangeUpper(currentRange);
    //   53  104:aload_0         
    //   54  105:aload           4
    //   55  107:invokevirtual   #192 <Method int rangeUpper(String)>
    //   56  110:istore          6
                for(int i = start; i <= m_Upper && i <= end; i++)
    //*  57  112:iload           5
    //*  58  114:istore          7
    //*  59  116:goto            140
                    if(m_SelectFlags[i])
    //*  60  119:aload_0         
    //*  61  120:getfield        #122 <Field boolean[] m_SelectFlags>
    //*  62  123:iload           7
    //*  63  125:baload          
    //*  64  126:ifeq            137
                        selectIndices[numSelected++] = i;
    //   65  129:aload_1         
    //   66  130:iload_2         
    //   67  131:iinc            2  1
    //   68  134:iload           7
    //   69  136:iastore         

    //   70  137:iinc            7  1
    //   71  140:iload           7
    //   72  142:aload_0         
    //   73  143:getfield        #31  <Field int m_Upper>
    //   74  146:icmpgt          156
    //   75  149:iload           7
    //   76  151:iload           6
    //   77  153:icmple          119
            }

    //   78  156:aload_3         
    //   79  157:invokeinterface #155 <Method boolean Enumeration.hasMoreElements()>
    //   80  162:ifne            82
        }
        int result[] = new int[numSelected];
    //   81  165:iload_2         
    //   82  166:newarray        int[]
    //   83  168:astore_3        
        System.arraycopy(selectIndices, 0, result, 0, numSelected);
    //   84  169:aload_1         
    //   85  170:iconst_0        
    //   86  171:aload_3         
    //   87  172:iconst_0        
    //   88  173:iload_2         
    //   89  174:invokestatic    #198 <Method void System.arraycopy(Object, int, Object, int, int)>
        return result;
    //   90  177:aload_3         
    //   91  178:areturn         
    }

    public static String indicesToRangeList(int indices[])
    {
        StringBuffer rl = new StringBuffer();
    //    0    0:new             #58  <Class StringBuffer>
    //    1    3:dup             
    //    2    4:invokespecial   #207 <Method void StringBuffer()>
    //    3    7:astore_1        
        int last = -2;
    //    4    8:bipush          -2
    //    5   10:istore_2        
        boolean range = false;
    //    6   11:iconst_0        
    //    7   12:istore_3        
        for(int i = 0; i < indices.length; i++)
    //*   8   13:iconst_0        
    //*   9   14:istore          4
    //*  10   16:goto            94
        {
            if(i == 0)
    //*  11   19:iload           4
    //*  12   21:ifne            38
                rl.append(indices[i] + 1);
    //   13   24:aload_1         
    //   14   25:aload_0         
    //   15   26:iload           4
    //   16   28:iaload          
    //   17   29:iconst_1        
    //   18   30:iadd            
    //   19   31:invokevirtual   #210 <Method StringBuffer StringBuffer.append(int)>
    //   20   34:pop             
            else
    //*  21   35:goto            84
            if(indices[i] == last)
    //*  22   38:aload_0         
    //*  23   39:iload           4
    //*  24   41:iaload          
    //*  25   42:iload_2         
    //*  26   43:icmpne          51
            {
                range = true;
    //   27   46:iconst_1        
    //   28   47:istore_3        
            } else
    //*  29   48:goto            84
            {
                if(range)
    //*  30   51:iload_3         
    //*  31   52:ifeq            68
                {
                    rl.append('-').append(last);
    //   32   55:aload_1         
    //   33   56:bipush          45
    //   34   58:invokevirtual   #213 <Method StringBuffer StringBuffer.append(char)>
    //   35   61:iload_2         
    //   36   62:invokevirtual   #210 <Method StringBuffer StringBuffer.append(int)>
    //   37   65:pop             
                    range = false;
    //   38   66:iconst_0        
    //   39   67:istore_3        
                }
                rl.append(',').append(indices[i] + 1);
    //   40   68:aload_1         
    //   41   69:bipush          44
    //   42   71:invokevirtual   #213 <Method StringBuffer StringBuffer.append(char)>
    //   43   74:aload_0         
    //   44   75:iload           4
    //   45   77:iaload          
    //   46   78:iconst_1        
    //   47   79:iadd            
    //   48   80:invokevirtual   #210 <Method StringBuffer StringBuffer.append(int)>
    //   49   83:pop             
            }
            last = indices[i] + 1;
    //   50   84:aload_0         
    //   51   85:iload           4
    //   52   87:iaload          
    //   53   88:iconst_1        
    //   54   89:iadd            
    //   55   90:istore_2        
        }

    //   56   91:iinc            4  1
    //   57   94:iload           4
    //   58   96:aload_0         
    //   59   97:arraylength     
    //   60   98:icmplt          19
        if(range)
    //*  61  101:iload_3         
    //*  62  102:ifeq            116
            rl.append('-').append(last);
    //   63  105:aload_1         
    //   64  106:bipush          45
    //   65  108:invokevirtual   #213 <Method StringBuffer StringBuffer.append(char)>
    //   66  111:iload_2         
    //   67  112:invokevirtual   #210 <Method StringBuffer StringBuffer.append(int)>
    //   68  115:pop             
        return rl.toString();
    //   69  116:aload_1         
    //   70  117:invokevirtual   #89  <Method String StringBuffer.toString()>
    //   71  120:areturn         
    }

    protected void setFlags()
    {
        m_SelectFlags = new boolean[m_Upper + 1];
    //    0    0:aload_0         
    //    1    1:aload_0         
    //    2    2:getfield        #31  <Field int m_Upper>
    //    3    5:iconst_1        
    //    4    6:iadd            
    //    5    7:newarray        boolean[]
    //    6    9:putfield        #122 <Field boolean[] m_SelectFlags>
        for(Enumeration enu = m_RangeStrings.elements(); enu.hasMoreElements();)
    //*   7   12:aload_0         
    //*   8   13:getfield        #29  <Field Vector m_RangeStrings>
    //*   9   16:invokevirtual   #141 <Method Enumeration Vector.elements()>
    //*  10   19:astore_1        
    //*  11   20:goto            114
        {
            String currentRange = (String)(String)enu.nextElement();
    //   12   23:aload_1         
    //   13   24:invokeinterface #150 <Method Object Enumeration.nextElement()>
    //   14   29:checkcast       #70  <Class String>
    //   15   32:checkcast       #70  <Class String>
    //   16   35:astore_2        
            if(!isValidRange(currentRange))
    //*  17   36:aload_0         
    //*  18   37:aload_2         
    //*  19   38:invokevirtual   #220 <Method boolean isValidRange(String)>
    //*  20   41:ifne            68
                throw new IllegalArgumentException((new StringBuilder("Invalid range list at ")).append(currentRange).toString());
    //   21   44:new             #222 <Class IllegalArgumentException>
    //   22   47:dup             
    //   23   48:new             #76  <Class StringBuilder>
    //   24   51:dup             
    //   25   52:ldc1            #224 <String "Invalid range list at ">
    //   26   54:invokespecial   #82  <Method void StringBuilder(String)>
    //   27   57:aload_2         
    //   28   58:invokevirtual   #85  <Method StringBuilder StringBuilder.append(String)>
    //   29   61:invokevirtual   #88  <Method String StringBuilder.toString()>
    //   30   64:invokespecial   #225 <Method void IllegalArgumentException(String)>
    //   31   67:athrow          
            int start = rangeLower(currentRange);
    //   32   68:aload_0         
    //   33   69:aload_2         
    //   34   70:invokevirtual   #189 <Method int rangeLower(String)>
    //   35   73:istore_3        
            int end = rangeUpper(currentRange);
    //   36   74:aload_0         
    //   37   75:aload_2         
    //   38   76:invokevirtual   #192 <Method int rangeUpper(String)>
    //   39   79:istore          4
            for(int i = start; i <= m_Upper && i <= end; i++)
    //*  40   81:iload_3         
    //*  41   82:istore          5
    //*  42   84:goto            98
                m_SelectFlags[i] = true;
    //   43   87:aload_0         
    //   44   88:getfield        #122 <Field boolean[] m_SelectFlags>
    //   45   91:iload           5
    //   46   93:iconst_1        
    //   47   94:bastore         

    //   48   95:iinc            5  1
    //   49   98:iload           5
    //   50  100:aload_0         
    //   51  101:getfield        #31  <Field int m_Upper>
    //   52  104:icmpgt          114
    //   53  107:iload           5
    //   54  109:iload           4
    //   55  111:icmple          87
        }

    //   56  114:aload_1         
    //   57  115:invokeinterface #155 <Method boolean Enumeration.hasMoreElements()>
    //   58  120:ifne            23
    //   59  123:return          
    }

    protected int rangeSingle(String single)
    {
        if(single.toLowerCase().equals("first"))
    //*   0    0:aload_1         
    //*   1    1:invokevirtual   #229 <Method String String.toLowerCase()>
    //*   2    4:ldc1            #230 <String "first">
    //*   3    6:invokevirtual   #116 <Method boolean String.equals(Object)>
    //*   4    9:ifeq            14
            return 0;
    //    5   12:iconst_0        
    //    6   13:ireturn         
        if(single.toLowerCase().equals("last"))
    //*   7   14:aload_1         
    //*   8   15:invokevirtual   #229 <Method String String.toLowerCase()>
    //*   9   18:ldc1            #231 <String "last">
    //*  10   20:invokevirtual   #116 <Method boolean String.equals(Object)>
    //*  11   23:ifeq            31
            return m_Upper;
    //   12   26:aload_0         
    //   13   27:getfield        #31  <Field int m_Upper>
    //   14   30:ireturn         
        int index = Integer.parseInt(single) - 1;
    //   15   31:aload_1         
    //   16   32:invokestatic    #236 <Method int Integer.parseInt(String)>
    //   17   35:iconst_1        
    //   18   36:isub            
    //   19   37:istore_2        
        if(index < 0)
    //*  20   38:iload_2         
    //*  21   39:ifge            44
            index = 0;
    //   22   42:iconst_0        
    //   23   43:istore_2        
        if(index > m_Upper)
    //*  24   44:iload_2         
    //*  25   45:aload_0         
    //*  26   46:getfield        #31  <Field int m_Upper>
    //*  27   49:icmple          57
            index = m_Upper;
    //   28   52:aload_0         
    //   29   53:getfield        #31  <Field int m_Upper>
    //   30   56:istore_2        
        return index;
    //   31   57:iload_2         
    //   32   58:ireturn         
    }

    protected int rangeLower(String range)
    {
        int hyphenIndex;
        if((hyphenIndex = range.indexOf('-')) >= 0)
    //*   0    0:aload_1         
    //*   1    1:bipush          45
    //*   2    3:invokevirtual   #103 <Method int String.indexOf(int)>
    //*   3    6:dup             
    //*   4    7:istore_2        
    //*   5    8:iflt            36
            return Math.min(rangeLower(range.substring(0, hyphenIndex)), rangeLower(range.substring(hyphenIndex + 1)));
    //    6   11:aload_0         
    //    7   12:aload_1         
    //    8   13:iconst_0        
    //    9   14:iload_2         
    //   10   15:invokevirtual   #107 <Method String String.substring(int, int)>
    //   11   18:invokevirtual   #189 <Method int rangeLower(String)>
    //   12   21:aload_0         
    //   13   22:aload_1         
    //   14   23:iload_2         
    //   15   24:iconst_1        
    //   16   25:iadd            
    //   17   26:invokevirtual   #110 <Method String String.substring(int)>
    //   18   29:invokevirtual   #189 <Method int rangeLower(String)>
    //   19   32:invokestatic    #243 <Method int Math.min(int, int)>
    //   20   35:ireturn         
        else
            return rangeSingle(range);
    //   21   36:aload_0         
    //   22   37:aload_1         
    //   23   38:invokevirtual   #245 <Method int rangeSingle(String)>
    //   24   41:ireturn         
    }

    protected int rangeUpper(String range)
    {
        int hyphenIndex;
        if((hyphenIndex = range.indexOf('-')) >= 0)
    //*   0    0:aload_1         
    //*   1    1:bipush          45
    //*   2    3:invokevirtual   #103 <Method int String.indexOf(int)>
    //*   3    6:dup             
    //*   4    7:istore_2        
    //*   5    8:iflt            36
            return Math.max(rangeUpper(range.substring(0, hyphenIndex)), rangeUpper(range.substring(hyphenIndex + 1)));
    //    6   11:aload_0         
    //    7   12:aload_1         
    //    8   13:iconst_0        
    //    9   14:iload_2         
    //   10   15:invokevirtual   #107 <Method String String.substring(int, int)>
    //   11   18:invokevirtual   #192 <Method int rangeUpper(String)>
    //   12   21:aload_0         
    //   13   22:aload_1         
    //   14   23:iload_2         
    //   15   24:iconst_1        
    //   16   25:iadd            
    //   17   26:invokevirtual   #110 <Method String String.substring(int)>
    //   18   29:invokevirtual   #192 <Method int rangeUpper(String)>
    //   19   32:invokestatic    #249 <Method int Math.max(int, int)>
    //   20   35:ireturn         
        else
            return rangeSingle(range);
    //   21   36:aload_0         
    //   22   37:aload_1         
    //   23   38:invokevirtual   #245 <Method int rangeSingle(String)>
    //   24   41:ireturn         
    }

    protected boolean isValidRange(String range)
    {
        if(range == null)
    //*   0    0:aload_1         
    //*   1    1:ifnonnull       6
            return false;
    //    2    4:iconst_0        
    //    3    5:ireturn         
        int hyphenIndex;
        if((hyphenIndex = range.indexOf('-')) >= 0)
    //*   4    6:aload_1         
    //*   5    7:bipush          45
    //*   6    9:invokevirtual   #103 <Method int String.indexOf(int)>
    //*   7   12:dup             
    //*   8   13:istore_2        
    //*   9   14:iflt            48
            return isValidRange(range.substring(0, hyphenIndex)) && isValidRange(range.substring(hyphenIndex + 1));
    //   10   17:aload_0         
    //   11   18:aload_1         
    //   12   19:iconst_0        
    //   13   20:iload_2         
    //   14   21:invokevirtual   #107 <Method String String.substring(int, int)>
    //   15   24:invokevirtual   #220 <Method boolean isValidRange(String)>
    //   16   27:ifeq            46
    //   17   30:aload_0         
    //   18   31:aload_1         
    //   19   32:iload_2         
    //   20   33:iconst_1        
    //   21   34:iadd            
    //   22   35:invokevirtual   #110 <Method String String.substring(int)>
    //   23   38:invokevirtual   #220 <Method boolean isValidRange(String)>
    //   24   41:ifeq            46
    //   25   44:iconst_1        
    //   26   45:ireturn         
    //   27   46:iconst_0        
    //   28   47:ireturn         
        if(range.toLowerCase().equals("first"))
    //*  29   48:aload_1         
    //*  30   49:invokevirtual   #229 <Method String String.toLowerCase()>
    //*  31   52:ldc1            #230 <String "first">
    //*  32   54:invokevirtual   #116 <Method boolean String.equals(Object)>
    //*  33   57:ifeq            62
            return true;
    //   34   60:iconst_1        
    //   35   61:ireturn         
        if(range.toLowerCase().equals("last"))
    //*  36   62:aload_1         
    //*  37   63:invokevirtual   #229 <Method String String.toLowerCase()>
    //*  38   66:ldc1            #231 <String "last">
    //*  39   68:invokevirtual   #116 <Method boolean String.equals(Object)>
    //*  40   71:ifeq            76
            return true;
    //   41   74:iconst_1        
    //   42   75:ireturn         
        try
        {
            int index = Integer.parseInt(range);
    //   43   76:aload_1         
    //   44   77:invokestatic    #236 <Method int Integer.parseInt(String)>
    //   45   80:istore_3        
            return index > 0 && index <= m_Upper + 1;
    //   46   81:iload_3         
    //   47   82:ifle            97
    //   48   85:iload_3         
    //   49   86:aload_0         
    //   50   87:getfield        #31  <Field int m_Upper>
    //   51   90:iconst_1        
    //   52   91:iadd            
    //   53   92:icmpgt          97
    //   54   95:iconst_1        
    //   55   96:ireturn         
    //   56   97:iconst_0        
    //   57   98:ireturn         
        }
        catch(NumberFormatException ex)
    //*  58   99:astore_3        
        {
            return false;
    //   59  100:iconst_0        
    //   60  101:ireturn         
        }
    }

    public static void main(String argv[])
    {
        try
        {
            if(argv.length == 0)
    //*   0    0:aload_0         
    //*   1    1:arraylength     
    //*   2    2:ifne            16
                throw new Exception("Usage: Range <rangespec>");
    //    3    5:new             #175 <Class Exception>
    //    4    8:dup             
    //    5    9:ldc2            #256 <String "Usage: Range <rangespec>">
    //    6   12:invokespecial   #257 <Method void Exception(String)>
    //    7   15:athrow          
            Range range = new Range();
    //    8   16:new             #2   <Class Range>
    //    9   19:dup             
    //   10   20:invokespecial   #258 <Method void Range()>
    //   11   23:astore_1        
            range.setRanges(argv[0]);
    //   12   24:aload_1         
    //   13   25:aload_0         
    //   14   26:iconst_0        
    //   15   27:aaload          
    //   16   28:invokevirtual   #39  <Method void setRanges(String)>
            range.setUpper(9);
    //   17   31:aload_1         
    //   18   32:bipush          9
    //   19   34:invokevirtual   #260 <Method void setUpper(int)>
            range.setInvert(false);
    //   20   37:aload_1         
    //   21   38:iconst_0        
    //   22   39:invokevirtual   #262 <Method void setInvert(boolean)>
            System.out.println((new StringBuilder("Input: ")).append(argv[0]).append("\n").append(range.toString()).toString());
    //   23   42:getstatic       #266 <Field PrintStream System.out>
    //   24   45:new             #76  <Class StringBuilder>
    //   25   48:dup             
    //   26   49:ldc2            #268 <String "Input: ">
    //   27   52:invokespecial   #82  <Method void StringBuilder(String)>
    //   28   55:aload_0         
    //   29   56:iconst_0        
    //   30   57:aaload          
    //   31   58:invokevirtual   #85  <Method StringBuilder StringBuilder.append(String)>
    //   32   61:ldc1            #157 <String "\n">
    //   33   63:invokevirtual   #85  <Method StringBuilder StringBuilder.append(String)>
    //   34   66:aload_1         
    //   35   67:invokevirtual   #269 <Method String toString()>
    //   36   70:invokevirtual   #85  <Method StringBuilder StringBuilder.append(String)>
    //   37   73:invokevirtual   #88  <Method String StringBuilder.toString()>
    //   38   76:invokevirtual   #274 <Method void PrintStream.println(String)>
            int rangeIndices[] = range.getSelection();
    //   39   79:aload_1         
    //   40   80:invokevirtual   #276 <Method int[] getSelection()>
    //   41   83:astore_2        
            for(int i = 0; i < rangeIndices.length; i++)
    //*  42   84:iconst_0        
    //*  43   85:istore_3        
    //*  44   86:goto            118
                System.out.print((new StringBuilder(" ")).append(rangeIndices[i] + 1).toString());
    //   45   89:getstatic       #266 <Field PrintStream System.out>
    //   46   92:new             #76  <Class StringBuilder>
    //   47   95:dup             
    //   48   96:ldc1            #152 <String " ">
    //   49   98:invokespecial   #82  <Method void StringBuilder(String)>
    //   50  101:aload_2         
    //   51  102:iload_3         
    //   52  103:iaload          
    //   53  104:iconst_1        
    //   54  105:iadd            
    //   55  106:invokevirtual   #171 <Method StringBuilder StringBuilder.append(int)>
    //   56  109:invokevirtual   #88  <Method String StringBuilder.toString()>
    //   57  112:invokevirtual   #279 <Method void PrintStream.print(String)>

    //   58  115:iinc            3  1
    //   59  118:iload_3         
    //   60  119:aload_2         
    //   61  120:arraylength     
    //   62  121:icmplt          89
            System.out.println("");
    //   63  124:getstatic       #266 <Field PrintStream System.out>
    //   64  127:ldc1            #112 <String "">
    //   65  129:invokevirtual   #274 <Method void PrintStream.println(String)>
        }
    //*  66  132:goto            146
        catch(Exception ex)
    //*  67  135:astore_1        
        {
            System.out.println(ex.getMessage());
    //   68  136:getstatic       #266 <Field PrintStream System.out>
    //   69  139:aload_1         
    //   70  140:invokevirtual   #178 <Method String Exception.getMessage()>
    //   71  143:invokevirtual   #274 <Method void PrintStream.println(String)>
        }
    //   72  146:return          
    }

    static final long serialVersionUID = 0x32e4ffa0aeacc93cL;
    Vector m_RangeStrings;
    boolean m_Invert;
    boolean m_SelectFlags[];
    int m_Upper;
}
