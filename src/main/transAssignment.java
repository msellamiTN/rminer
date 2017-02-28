// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   transAssignment.java

package main;

import java.io.*;
import rm.core.*;
import rm.core.converters.AssLoader;

public class transAssignment
{

    public transAssignment()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #9   <Method void Object()>
    //    2    4:return          
    }

    public static void main(String args[])
        throws Exception
    {
        File file = new File((new StringBuilder(String.valueOf(System.getProperty("user.dir")))).append("\\datasets\\university_party.ass").toString());
    //    0    0:new             #20  <Class File>
    //    1    3:dup             
    //    2    4:new             #22  <Class StringBuilder>
    //    3    7:dup             
    //    4    8:ldc1            #24  <String "user.dir">
    //    5   10:invokestatic    #30  <Method String System.getProperty(String)>
    //    6   13:invokestatic    #36  <Method String String.valueOf(Object)>
    //    7   16:invokespecial   #39  <Method void StringBuilder(String)>
    //    8   19:ldc1            #41  <String "\\datasets\\university_party.ass">
    //    9   21:invokevirtual   #45  <Method StringBuilder StringBuilder.append(String)>
    //   10   24:invokevirtual   #49  <Method String StringBuilder.toString()>
    //   11   27:invokespecial   #50  <Method void File(String)>
    //   12   30:astore_1        
        AssLoader AL = new AssLoader(new FileReader(file));
    //   13   31:new             #52  <Class AssLoader>
    //   14   34:dup             
    //   15   35:new             #54  <Class FileReader>
    //   16   38:dup             
    //   17   39:aload_1         
    //   18   40:invokespecial   #57  <Method void FileReader(File)>
    //   19   43:invokespecial   #60  <Method void AssLoader(FileReader)>
    //   20   46:astore_2        
        Assignment m_Assignment = AL.getData();
    //   21   47:aload_2         
    //   22   48:invokevirtual   #64  <Method Assignment AssLoader.getData()>
    //   23   51:astore_3        
        Object roleSet[] = m_Assignment.getDimensionX().getDimensionAttribute().toArray();
    //   24   52:aload_3         
    //   25   53:invokevirtual   #70  <Method Dimension Assignment.getDimensionX()>
    //   26   56:invokevirtual   #76  <Method Attribute Dimension.getDimensionAttribute()>
    //   27   59:invokevirtual   #82  <Method Object[] Attribute.toArray()>
    //   28   62:astore          4
        Object permSet[] = m_Assignment.getDimensionY().getDimensionAttribute().toArray();
    //   29   64:aload_3         
    //   30   65:invokevirtual   #85  <Method Dimension Assignment.getDimensionY()>
    //   31   68:invokevirtual   #76  <Method Attribute Dimension.getDimensionAttribute()>
    //   32   71:invokevirtual   #82  <Method Object[] Attribute.toArray()>
    //   33   74:astore          5
        Matrix mat = m_Assignment.getAssignmentMatrix();
    //   34   76:aload_3         
    //   35   77:invokevirtual   #89  <Method Matrix Assignment.getAssignmentMatrix()>
    //   36   80:astore          6
        StringBuffer txt = new StringBuffer();
    //   37   82:new             #91  <Class StringBuffer>
    //   38   85:dup             
    //   39   86:invokespecial   #92  <Method void StringBuffer()>
    //   40   89:astore          7
        for(int i = 0; i < roleSet.length; i++)
    //*  41   91:iconst_0        
    //*  42   92:istore          8
    //*  43   94:goto            209
        {
            txt.append((new StringBuilder()).append(roleSet[i]).append("(").toString());
    //   44   97:aload           7
    //   45   99:new             #22  <Class StringBuilder>
    //   46  102:dup             
    //   47  103:invokespecial   #93  <Method void StringBuilder()>
    //   48  106:aload           4
    //   49  108:iload           8
    //   50  110:aaload          
    //   51  111:invokevirtual   #96  <Method StringBuilder StringBuilder.append(Object)>
    //   52  114:ldc1            #98  <String "(">
    //   53  116:invokevirtual   #45  <Method StringBuilder StringBuilder.append(String)>
    //   54  119:invokevirtual   #49  <Method String StringBuilder.toString()>
    //   55  122:invokevirtual   #101 <Method StringBuffer StringBuffer.append(String)>
    //   56  125:pop             
            for(int j = 0; j < permSet.length; j++)
    //*  57  126:iconst_0        
    //*  58  127:istore          9
    //*  59  129:goto            177
                if(mat.get(i, j) == 1)
    //*  60  132:aload           6
    //*  61  134:iload           8
    //*  62  136:iload           9
    //*  63  138:invokevirtual   #107 <Method byte Matrix.get(int, int)>
    //*  64  141:iconst_1        
    //*  65  142:icmpne          174
                    txt.append((new StringBuilder()).append(permSet[j]).append(",").toString());
    //   66  145:aload           7
    //   67  147:new             #22  <Class StringBuilder>
    //   68  150:dup             
    //   69  151:invokespecial   #93  <Method void StringBuilder()>
    //   70  154:aload           5
    //   71  156:iload           9
    //   72  158:aaload          
    //   73  159:invokevirtual   #96  <Method StringBuilder StringBuilder.append(Object)>
    //   74  162:ldc1            #109 <String ",">
    //   75  164:invokevirtual   #45  <Method StringBuilder StringBuilder.append(String)>
    //   76  167:invokevirtual   #49  <Method String StringBuilder.toString()>
    //   77  170:invokevirtual   #101 <Method StringBuffer StringBuffer.append(String)>
    //   78  173:pop             

    //   79  174:iinc            9  1
    //   80  177:iload           9
    //   81  179:aload           5
    //   82  181:arraylength     
    //   83  182:icmplt          132
            txt.deleteCharAt(txt.length() - 1);
    //   84  185:aload           7
    //   85  187:aload           7
    //   86  189:invokevirtual   #113 <Method int StringBuffer.length()>
    //   87  192:iconst_1        
    //   88  193:isub            
    //   89  194:invokevirtual   #117 <Method StringBuffer StringBuffer.deleteCharAt(int)>
    //   90  197:pop             
            txt.append(");");
    //   91  198:aload           7
    //   92  200:ldc1            #119 <String ");">
    //   93  202:invokevirtual   #101 <Method StringBuffer StringBuffer.append(String)>
    //   94  205:pop             
        }

    //   95  206:iinc            8  1
    //   96  209:iload           8
    //   97  211:aload           4
    //   98  213:arraylength     
    //   99  214:icmplt          97
        System.out.println(txt.toString());
    //  100  217:getstatic       #123 <Field PrintStream System.out>
    //  101  220:aload           7
    //  102  222:invokevirtual   #124 <Method String StringBuffer.toString()>
    //  103  225:invokevirtual   #129 <Method void PrintStream.println(String)>
    //  104  228:return          
    }
}
