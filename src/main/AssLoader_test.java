// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   AssLoader_test.java

package main;

import java.io.*;
import java.util.Enumeration;
import rm.core.*;
import rm.core.converters.AssLoader;

public class AssLoader_test
{

    public AssLoader_test()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #9   <Method void Object()>
    //    2    4:return          
    }

    public static void main(String args[])
    {
        Instances ins = null;
    //    0    0:aconst_null     
    //    1    1:astore_1        
        Assignment Ass = null;
    //    2    2:aconst_null     
    //    3    3:astore_2        
        try
        {
            File file = new File((new StringBuilder(String.valueOf(System.getProperty("user.dir")))).append("\\datasets\\university_runningexample.ass").toString());
    //    4    4:new             #17  <Class File>
    //    5    7:dup             
    //    6    8:new             #19  <Class StringBuilder>
    //    7   11:dup             
    //    8   12:ldc1            #21  <String "user.dir">
    //    9   14:invokestatic    #27  <Method String System.getProperty(String)>
    //   10   17:invokestatic    #33  <Method String String.valueOf(Object)>
    //   11   20:invokespecial   #36  <Method void StringBuilder(String)>
    //   12   23:ldc1            #38  <String "\\datasets\\university_runningexample.ass">
    //   13   25:invokevirtual   #42  <Method StringBuilder StringBuilder.append(String)>
    //   14   28:invokevirtual   #46  <Method String StringBuilder.toString()>
    //   15   31:invokespecial   #47  <Method void File(String)>
    //   16   34:astore_3        
            AssLoader AL = new AssLoader(new FileReader(file));
    //   17   35:new             #49  <Class AssLoader>
    //   18   38:dup             
    //   19   39:new             #51  <Class FileReader>
    //   20   42:dup             
    //   21   43:aload_3         
    //   22   44:invokespecial   #54  <Method void FileReader(File)>
    //   23   47:invokespecial   #57  <Method void AssLoader(FileReader)>
    //   24   50:astore          4
            Ass = AL.getData();
    //   25   52:aload           4
    //   26   54:invokevirtual   #61  <Method Assignment AssLoader.getData()>
    //   27   57:astore_2        
            System.out.println(Ass.getAssignementName());
    //   28   58:getstatic       #65  <Field PrintStream System.out>
    //   29   61:aload_2         
    //   30   62:invokevirtual   #70  <Method String Assignment.getAssignementName()>
    //   31   65:invokevirtual   #75  <Method void PrintStream.println(String)>
            Matrix mat = Ass.getAssignmentMatrix();
    //   32   68:aload_2         
    //   33   69:invokevirtual   #79  <Method Matrix Assignment.getAssignmentMatrix()>
    //   34   72:astore          5
            for(int i = 0; i < mat.getRowDimension(); i++)
    //*  35   74:iconst_0        
    //*  36   75:istore          6
    //*  37   77:goto            141
            {
                for(int j = 0; j < mat.getColumnDimension(); j++)
    //*  38   80:iconst_0        
    //*  39   81:istore          7
    //*  40   83:goto            122
                    System.out.print((new StringBuilder(String.valueOf(mat.get(i, j)))).append(" ").toString());
    //   41   86:getstatic       #65  <Field PrintStream System.out>
    //   42   89:new             #19  <Class StringBuilder>
    //   43   92:dup             
    //   44   93:aload           5
    //   45   95:iload           6
    //   46   97:iload           7
    //   47   99:invokevirtual   #85  <Method byte Matrix.get(int, int)>
    //   48  102:invokestatic    #88  <Method String String.valueOf(int)>
    //   49  105:invokespecial   #36  <Method void StringBuilder(String)>
    //   50  108:ldc1            #90  <String " ">
    //   51  110:invokevirtual   #42  <Method StringBuilder StringBuilder.append(String)>
    //   52  113:invokevirtual   #46  <Method String StringBuilder.toString()>
    //   53  116:invokevirtual   #93  <Method void PrintStream.print(String)>

    //   54  119:iinc            7  1
    //   55  122:iload           7
    //   56  124:aload           5
    //   57  126:invokevirtual   #97  <Method int Matrix.getColumnDimension()>
    //   58  129:icmplt          86
                System.out.println();
    //   59  132:getstatic       #65  <Field PrintStream System.out>
    //   60  135:invokevirtual   #99  <Method void PrintStream.println()>
            }

    //   61  138:iinc            6  1
    //   62  141:iload           6
    //   63  143:aload           5
    //   64  145:invokevirtual   #102 <Method int Matrix.getRowDimension()>
    //   65  148:icmplt          80
            for(Enumeration enu = Ass.getDimensionX().getDimensionAttribute().enumerateValues(); enu.hasMoreElements(); System.out.println((String)(String)enu.nextElement()));
    //   66  151:aload_2         
    //   67  152:invokevirtual   #106 <Method Dimension Assignment.getDimensionX()>
    //   68  155:invokevirtual   #112 <Method Attribute Dimension.getDimensionAttribute()>
    //   69  158:invokevirtual   #118 <Method Enumeration Attribute.enumerateValues()>
    //   70  161:astore          6
    //   71  163:goto            185
    //   72  166:getstatic       #65  <Field PrintStream System.out>
    //   73  169:aload           6
    //   74  171:invokeinterface #124 <Method Object Enumeration.nextElement()>
    //   75  176:checkcast       #29  <Class String>
    //   76  179:checkcast       #29  <Class String>
    //   77  182:invokevirtual   #75  <Method void PrintStream.println(String)>
    //   78  185:aload           6
    //   79  187:invokeinterface #128 <Method boolean Enumeration.hasMoreElements()>
    //   80  192:ifne            166
            Instances insts = Ass.getDimensionY().getDimensionInstances();
    //   81  195:aload_2         
    //   82  196:invokevirtual   #131 <Method Dimension Assignment.getDimensionY()>
    //   83  199:invokevirtual   #135 <Method Instances Dimension.getDimensionInstances()>
    //   84  202:astore          7
            System.out.println(insts.numInstances());
    //   85  204:getstatic       #65  <Field PrintStream System.out>
    //   86  207:aload           7
    //   87  209:invokevirtual   #140 <Method int Instances.numInstances()>
    //   88  212:invokevirtual   #143 <Method void PrintStream.println(int)>
        }
    //*  89  215:goto            223
        catch(Exception e)
    //*  90  218:astore_3        
        {
            e.printStackTrace();
    //   91  219:aload_3         
    //   92  220:invokevirtual   #148 <Method void Exception.printStackTrace()>
        }
    //   93  223:return          
    }
}
