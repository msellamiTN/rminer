// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   AssignmentEvaluation.java

package rm.assignment;

import java.io.*;
import java.util.Enumeration;
import rm.core.*;

// Referenced classes of package rm.assignment:
//            Assignment

public class AssignmentEvaluation
{

    public AssignmentEvaluation()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #11  <Method void Object()>
        m_Result = new StringBuffer();
    //    2    4:aload_0         
    //    3    5:new             #13  <Class StringBuffer>
    //    4    8:dup             
    //    5    9:invokespecial   #14  <Method void StringBuffer()>
    //    6   12:putfield        #16  <Field StringBuffer m_Result>
    //    7   15:return          
    }

    protected static String makeOptionString(rm.assignment.Assignment assiger)
    {
        StringBuffer text = new StringBuffer();
    //    0    0:new             #13  <Class StringBuffer>
    //    1    3:dup             
    //    2    4:invokespecial   #14  <Method void StringBuffer()>
    //    3    7:astore_1        
        text.append("\nGeneral options:\n\n");
    //    4    8:aload_1         
    //    5    9:ldc1            #24  <String "\nGeneral options:\n\n">
    //    6   11:invokevirtual   #28  <Method StringBuffer StringBuffer.append(String)>
    //    7   14:pop             
        text.append("-t <training file>\n");
    //    8   15:aload_1         
    //    9   16:ldc1            #30  <String "-t <training file>\n">
    //   10   18:invokevirtual   #28  <Method StringBuffer StringBuffer.append(String)>
    //   11   21:pop             
        text.append("\tThe name of the training file.\n");
    //   12   22:aload_1         
    //   13   23:ldc1            #32  <String "\tThe name of the training file.\n">
    //   14   25:invokevirtual   #28  <Method StringBuffer StringBuffer.append(String)>
    //   15   28:pop             
        text.append("-g <name of graph file>\n");
    //   16   29:aload_1         
    //   17   30:ldc1            #34  <String "-g <name of graph file>\n">
    //   18   32:invokevirtual   #28  <Method StringBuffer StringBuffer.append(String)>
    //   19   35:pop             
        text.append("\tOutputs the graph representation (if supported) of the associator to a file.\n");
    //   20   36:aload_1         
    //   21   37:ldc1            #36  <String "\tOutputs the graph representation (if supported) of the associator to a file.\n">
    //   22   39:invokevirtual   #28  <Method StringBuffer StringBuffer.append(String)>
    //   23   42:pop             
        if(assiger instanceof OptionHandler)
    //*  24   43:aload_0         
    //*  25   44:instanceof      #38  <Class OptionHandler>
    //*  26   47:ifeq            178
        {
            text.append((new StringBuilder("\nOptions specific to ")).append(assiger.getClass().getName().replaceAll(".*\\.", "")).append(":\n\n").toString());
    //   27   50:aload_1         
    //   28   51:new             #40  <Class StringBuilder>
    //   29   54:dup             
    //   30   55:ldc1            #42  <String "\nOptions specific to ">
    //   31   57:invokespecial   #45  <Method void StringBuilder(String)>
    //   32   60:aload_0         
    //   33   61:invokevirtual   #49  <Method Class Object.getClass()>
    //   34   64:invokevirtual   #55  <Method String Class.getName()>
    //   35   67:ldc1            #57  <String ".*\\.">
    //   36   69:ldc1            #59  <String "">
    //   37   71:invokevirtual   #65  <Method String String.replaceAll(String, String)>
    //   38   74:invokevirtual   #68  <Method StringBuilder StringBuilder.append(String)>
    //   39   77:ldc1            #70  <String ":\n\n">
    //   40   79:invokevirtual   #68  <Method StringBuilder StringBuilder.append(String)>
    //   41   82:invokevirtual   #73  <Method String StringBuilder.toString()>
    //   42   85:invokevirtual   #28  <Method StringBuffer StringBuffer.append(String)>
    //   43   88:pop             
            Option option;
            for(Enumeration enm = ((OptionHandler)assiger).listOptions(); enm.hasMoreElements(); text.append((new StringBuilder(String.valueOf(option.description()))).append("\n").toString()))
    //*  44   89:aload_0         
    //*  45   90:checkcast       #38  <Class OptionHandler>
    //*  46   93:invokeinterface #77  <Method Enumeration OptionHandler.listOptions()>
    //*  47   98:astore_2        
    //*  48   99:goto            169
            {
                option = (Option)(Option)enm.nextElement();
    //   49  102:aload_2         
    //   50  103:invokeinterface #83  <Method Object Enumeration.nextElement()>
    //   51  108:checkcast       #85  <Class Option>
    //   52  111:checkcast       #85  <Class Option>
    //   53  114:astore_3        
                text.append((new StringBuilder(String.valueOf(option.synopsis()))).append("\n").toString());
    //   54  115:aload_1         
    //   55  116:new             #40  <Class StringBuilder>
    //   56  119:dup             
    //   57  120:aload_3         
    //   58  121:invokevirtual   #88  <Method String Option.synopsis()>
    //   59  124:invokestatic    #92  <Method String String.valueOf(Object)>
    //   60  127:invokespecial   #45  <Method void StringBuilder(String)>
    //   61  130:ldc1            #94  <String "\n">
    //   62  132:invokevirtual   #68  <Method StringBuilder StringBuilder.append(String)>
    //   63  135:invokevirtual   #73  <Method String StringBuilder.toString()>
    //   64  138:invokevirtual   #28  <Method StringBuffer StringBuffer.append(String)>
    //   65  141:pop             
            }

    //   66  142:aload_1         
    //   67  143:new             #40  <Class StringBuilder>
    //   68  146:dup             
    //   69  147:aload_3         
    //   70  148:invokevirtual   #97  <Method String Option.description()>
    //   71  151:invokestatic    #92  <Method String String.valueOf(Object)>
    //   72  154:invokespecial   #45  <Method void StringBuilder(String)>
    //   73  157:ldc1            #94  <String "\n">
    //   74  159:invokevirtual   #68  <Method StringBuilder StringBuilder.append(String)>
    //   75  162:invokevirtual   #73  <Method String StringBuilder.toString()>
    //   76  165:invokevirtual   #28  <Method StringBuffer StringBuffer.append(String)>
    //   77  168:pop             
    //   78  169:aload_2         
    //   79  170:invokeinterface #101 <Method boolean Enumeration.hasMoreElements()>
    //   80  175:ifne            102
        }
        System.out.println(text);
    //   81  178:getstatic       #107 <Field PrintStream System.out>
    //   82  181:aload_1         
    //   83  182:invokevirtual   #113 <Method void PrintStream.println(Object)>
        return text.toString();
    //   84  185:aload_1         
    //   85  186:invokevirtual   #114 <Method String StringBuffer.toString()>
    //   86  189:areturn         
    }

    public static String evaluate(String assigerString, String options[])
        throws Exception
    {
        rm.assignment.Assignment assiger;
        try
        {
            assiger = (rm.assignment.Assignment)(rm.assignment.Assignment)Class.forName(assigerString).newInstance();
    //    0    0:aload_0         
    //    1    1:invokestatic    #130 <Method Class Class.forName(String)>
    //    2    4:invokevirtual   #133 <Method Object Class.newInstance()>
    //    3    7:checkcast       #135 <Class rm.assignment.Assignment>
    //    4   10:checkcast       #135 <Class rm.assignment.Assignment>
    //    5   13:astore_2        
        }
    //*   6   14:goto            47
        catch(Exception e)
    //*   7   17:astore_3        
        {
            throw new Exception((new StringBuilder("Can't find class with name ")).append(assigerString).append('.').toString());
    //    8   18:new             #126 <Class Exception>
    //    9   21:dup             
    //   10   22:new             #40  <Class StringBuilder>
    //   11   25:dup             
    //   12   26:ldc1            #137 <String "Can't find class with name ">
    //   13   28:invokespecial   #45  <Method void StringBuilder(String)>
    //   14   31:aload_0         
    //   15   32:invokevirtual   #68  <Method StringBuilder StringBuilder.append(String)>
    //   16   35:bipush          46
    //   17   37:invokevirtual   #140 <Method StringBuilder StringBuilder.append(char)>
    //   18   40:invokevirtual   #73  <Method String StringBuilder.toString()>
    //   19   43:invokespecial   #141 <Method void Exception(String)>
    //   20   46:athrow          
        }
        return evaluate(assiger, options);
    //   21   47:aload_2         
    //   22   48:aload_1         
    //   23   49:invokestatic    #144 <Method String evaluate(rm.assignment.Assignment, String[])>
    //   24   52:areturn         
    }

    public static String evaluate(rm.assignment.Assignment assiger, String options[])
        throws Exception
    {
        String trainFileString = "";
    //    0    0:ldc1            #59  <String "">
    //    1    2:astore_2        
        String graphFileName = "";
    //    2    3:ldc1            #59  <String "">
    //    3    5:astore_3        
        if(Utils.getFlag('h', options))
    //*   4    6:bipush          104
    //*   5    8:aload_1         
    //*   6    9:invokestatic    #156 <Method boolean Utils.getFlag(char, String[])>
    //*   7   12:ifeq            42
            throw new Exception((new StringBuilder("\nHelp requested.\n")).append(makeOptionString(assiger)).toString());
    //    8   15:new             #126 <Class Exception>
    //    9   18:dup             
    //   10   19:new             #40  <Class StringBuilder>
    //   11   22:dup             
    //   12   23:ldc1            #158 <String "\nHelp requested.\n">
    //   13   25:invokespecial   #45  <Method void StringBuilder(String)>
    //   14   28:aload_0         
    //   15   29:invokestatic    #160 <Method String makeOptionString(rm.assignment.Assignment)>
    //   16   32:invokevirtual   #68  <Method StringBuilder StringBuilder.append(String)>
    //   17   35:invokevirtual   #73  <Method String StringBuilder.toString()>
    //   18   38:invokespecial   #141 <Method void Exception(String)>
    //   19   41:athrow          
        try
        {
            trainFileString = Utils.getOption('t', options);
    //   20   42:bipush          116
    //   21   44:aload_1         
    //   22   45:invokestatic    #164 <Method String Utils.getOption(char, String[])>
    //   23   48:astore_2        
            if(trainFileString.length() == 0)
    //*  24   49:aload_2         
    //*  25   50:invokevirtual   #168 <Method int String.length()>
    //*  26   53:ifne            66
                throw new Exception("No training file given!");
    //   27   56:new             #126 <Class Exception>
    //   28   59:dup             
    //   29   60:ldc1            #170 <String "No training file given!">
    //   30   62:invokespecial   #141 <Method void Exception(String)>
    //   31   65:athrow          
            rm.core.converters.ConverterUtils.DataSource loader = new rm.core.converters.ConverterUtils.DataSource(trainFileString);
    //   32   66:new             #172 <Class rm.core.converters.ConverterUtils$DataSource>
    //   33   69:dup             
    //   34   70:aload_2         
    //   35   71:invokespecial   #173 <Method void rm.core.converters.ConverterUtils$DataSource(String)>
    //   36   74:astore          5
            graphFileName = Utils.getOption('g', options);
    //   37   76:bipush          103
    //   38   78:aload_1         
    //   39   79:invokestatic    #164 <Method String Utils.getOption(char, String[])>
    //   40   82:astore_3        
            if(assiger instanceof OptionHandler)
    //*  41   83:aload_0         
    //*  42   84:instanceof      #38  <Class OptionHandler>
    //*  43   87:ifeq            100
                ((OptionHandler)assiger).setOptions(options);
    //   44   90:aload_0         
    //   45   91:checkcast       #38  <Class OptionHandler>
    //   46   94:aload_1         
    //   47   95:invokeinterface #177 <Method void OptionHandler.setOptions(String[])>
            Utils.checkForRemainingOptions(options);
    //   48  100:aload_1         
    //   49  101:invokestatic    #180 <Method void Utils.checkForRemainingOptions(String[])>
        }
    //*  50  104:goto            149
        catch(Exception e)
    //*  51  107:astore          6
        {
            throw new Exception((new StringBuilder("\nWeka exception: ")).append(e.getMessage()).append("\n").append(makeOptionString(assiger)).toString());
    //   52  109:new             #126 <Class Exception>
    //   53  112:dup             
    //   54  113:new             #40  <Class StringBuilder>
    //   55  116:dup             
    //   56  117:ldc1            #182 <String "\nWeka exception: ">
    //   57  119:invokespecial   #45  <Method void StringBuilder(String)>
    //   58  122:aload           6
    //   59  124:invokevirtual   #185 <Method String Exception.getMessage()>
    //   60  127:invokevirtual   #68  <Method StringBuilder StringBuilder.append(String)>
    //   61  130:ldc1            #94  <String "\n">
    //   62  132:invokevirtual   #68  <Method StringBuilder StringBuilder.append(String)>
    //   63  135:aload_0         
    //   64  136:invokestatic    #160 <Method String makeOptionString(rm.assignment.Assignment)>
    //   65  139:invokevirtual   #68  <Method StringBuilder StringBuilder.append(String)>
    //   66  142:invokevirtual   #73  <Method String StringBuilder.toString()>
    //   67  145:invokespecial   #141 <Method void Exception(String)>
    //   68  148:athrow          
        }
        AssignmentEvaluation eval = new AssignmentEvaluation();
    //   69  149:new             #2   <Class AssignmentEvaluation>
    //   70  152:dup             
    //   71  153:invokespecial   #186 <Method void AssignmentEvaluation()>
    //   72  156:astore          4
        if((assiger instanceof Drawable) && graphFileName.length() != 0)
    //*  73  158:aload_0         
    //*  74  159:instanceof      #188 <Class Drawable>
    //*  75  162:ifeq            218
    //*  76  165:aload_3         
    //*  77  166:invokevirtual   #168 <Method int String.length()>
    //*  78  169:ifeq            218
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(graphFileName));
    //   79  172:new             #190 <Class BufferedWriter>
    //   80  175:dup             
    //   81  176:new             #192 <Class FileWriter>
    //   82  179:dup             
    //   83  180:aload_3         
    //   84  181:invokespecial   #193 <Method void FileWriter(String)>
    //   85  184:invokespecial   #196 <Method void BufferedWriter(java.io.Writer)>
    //   86  187:astore          6
            writer.write(((Drawable)assiger).graph());
    //   87  189:aload           6
    //   88  191:aload_0         
    //   89  192:checkcast       #188 <Class Drawable>
    //   90  195:invokeinterface #199 <Method String Drawable.graph()>
    //   91  200:invokevirtual   #202 <Method void BufferedWriter.write(String)>
            writer.newLine();
    //   92  203:aload           6
    //   93  205:invokevirtual   #205 <Method void BufferedWriter.newLine()>
            writer.flush();
    //   94  208:aload           6
    //   95  210:invokevirtual   #208 <Method void BufferedWriter.flush()>
            writer.close();
    //   96  213:aload           6
    //   97  215:invokevirtual   #211 <Method void BufferedWriter.close()>
        }
        return "";
    //   98  218:ldc1            #59  <String "">
    //   99  220:areturn         
    }

    public String evaluate(rm.assignment.Assignment assiger, Assignment upa, Assignment pa)
        throws Exception
    {
        long startTime = System.currentTimeMillis();
    //    0    0:invokestatic    #223 <Method long System.currentTimeMillis()>
    //    1    3:lstore          4
        assiger.buildAssigns(upa, pa);
    //    2    5:aload_1         
    //    3    6:aload_2         
    //    4    7:aload_3         
    //    5    8:invokeinterface #227 <Method void Assignment.buildAssigns(Assignment, Assignment)>
        long endTime = System.currentTimeMillis();
    //    6   13:invokestatic    #223 <Method long System.currentTimeMillis()>
    //    7   16:lstore          6
        m_Result = new StringBuffer(assiger.toString());
    //    8   18:aload_0         
    //    9   19:new             #13  <Class StringBuffer>
    //   10   22:dup             
    //   11   23:aload_1         
    //   12   24:invokevirtual   #228 <Method String Object.toString()>
    //   13   27:invokespecial   #229 <Method void StringBuffer(String)>
    //   14   30:putfield        #16  <Field StringBuffer m_Result>
        m_Result.append("\n=== Evaluation ===\n\n");
    //   15   33:aload_0         
    //   16   34:getfield        #16  <Field StringBuffer m_Result>
    //   17   37:ldc1            #231 <String "\n=== Evaluation ===\n\n">
    //   18   39:invokevirtual   #28  <Method StringBuffer StringBuffer.append(String)>
    //   19   42:pop             
        m_Result.append((new StringBuilder("Elapsed time: ")).append((double)(endTime - startTime) / 1000D).append("s").toString());
    //   20   43:aload_0         
    //   21   44:getfield        #16  <Field StringBuffer m_Result>
    //   22   47:new             #40  <Class StringBuilder>
    //   23   50:dup             
    //   24   51:ldc1            #233 <String "Elapsed time: ">
    //   25   53:invokespecial   #45  <Method void StringBuilder(String)>
    //   26   56:lload           6
    //   27   58:lload           4
    //   28   60:lsub            
    //   29   61:l2d             
    //   30   62:ldc2w           #234 <Double 1000D>
    //   31   65:ddiv            
    //   32   66:invokevirtual   #238 <Method StringBuilder StringBuilder.append(double)>
    //   33   69:ldc1            #240 <String "s">
    //   34   71:invokevirtual   #68  <Method StringBuilder StringBuilder.append(String)>
    //   35   74:invokevirtual   #73  <Method String StringBuilder.toString()>
    //   36   77:invokevirtual   #28  <Method StringBuffer StringBuffer.append(String)>
    //   37   80:pop             
        m_Result.append("\n");
    //   38   81:aload_0         
    //   39   82:getfield        #16  <Field StringBuffer m_Result>
    //   40   85:ldc1            #94  <String "\n">
    //   41   87:invokevirtual   #28  <Method StringBuffer StringBuffer.append(String)>
    //   42   90:pop             
        return m_Result.toString();
    //   43   91:aload_0         
    //   44   92:getfield        #16  <Field StringBuffer m_Result>
    //   45   95:invokevirtual   #114 <Method String StringBuffer.toString()>
    //   46   98:areturn         
    }

    public boolean equals(Object obj)
    {
        if(obj == null || !obj.getClass().equals(getClass()))
    //*   0    0:aload_1         
    //*   1    1:ifnull          18
    //*   2    4:aload_1         
    //*   3    5:invokevirtual   #49  <Method Class Object.getClass()>
    //*   4    8:aload_0         
    //*   5    9:invokevirtual   #49  <Method Class Object.getClass()>
    //*   6   12:invokevirtual   #250 <Method boolean Object.equals(Object)>
    //*   7   15:ifne            20
            return false;
    //    8   18:iconst_0        
    //    9   19:ireturn         
        AssignmentEvaluation cmp = (AssignmentEvaluation)obj;
    //   10   20:aload_1         
    //   11   21:checkcast       #2   <Class AssignmentEvaluation>
    //   12   24:astore_2        
        String associatingResults1 = m_Result.toString().replaceAll("Elapsed time.*", "");
    //   13   25:aload_0         
    //   14   26:getfield        #16  <Field StringBuffer m_Result>
    //   15   29:invokevirtual   #114 <Method String StringBuffer.toString()>
    //   16   32:ldc1            #252 <String "Elapsed time.*">
    //   17   34:ldc1            #59  <String "">
    //   18   36:invokevirtual   #65  <Method String String.replaceAll(String, String)>
    //   19   39:astore_3        
        String associatingResults2 = cmp.m_Result.toString().replaceAll("Elapsed time.*", "");
    //   20   40:aload_2         
    //   21   41:getfield        #16  <Field StringBuffer m_Result>
    //   22   44:invokevirtual   #114 <Method String StringBuffer.toString()>
    //   23   47:ldc1            #252 <String "Elapsed time.*">
    //   24   49:ldc1            #59  <String "">
    //   25   51:invokevirtual   #65  <Method String String.replaceAll(String, String)>
    //   26   54:astore          4
        return associatingResults1.equals(associatingResults2);
    //   27   56:aload_3         
    //   28   57:aload           4
    //   29   59:invokevirtual   #253 <Method boolean String.equals(Object)>
    //   30   62:ifne            67
    //   31   65:iconst_0        
    //   32   66:ireturn         
    //   33   67:iconst_1        
    //   34   68:ireturn         
    }

    public String toSummaryString()
    {
        return toSummaryString("");
    //    0    0:aload_0         
    //    1    1:ldc1            #59  <String "">
    //    2    3:invokevirtual   #262 <Method String toSummaryString(String)>
    //    3    6:areturn         
    }

    public String toSummaryString(String title)
    {
        StringBuffer result = new StringBuffer(title);
    //    0    0:new             #13  <Class StringBuffer>
    //    1    3:dup             
    //    2    4:aload_1         
    //    3    5:invokespecial   #229 <Method void StringBuffer(String)>
    //    4    8:astore_2        
        if(title.length() != 0)
    //*   5    9:aload_1         
    //*   6   10:invokevirtual   #168 <Method int String.length()>
    //*   7   13:ifeq            23
            result.append("\n");
    //    8   16:aload_2         
    //    9   17:ldc1            #94  <String "\n">
    //   10   19:invokevirtual   #28  <Method StringBuffer StringBuffer.append(String)>
    //   11   22:pop             
        result.append(m_Result);
    //   12   23:aload_2         
    //   13   24:aload_0         
    //   14   25:getfield        #16  <Field StringBuffer m_Result>
    //   15   28:invokevirtual   #265 <Method StringBuffer StringBuffer.append(StringBuffer)>
    //   16   31:pop             
        return result.toString();
    //   17   32:aload_2         
    //   18   33:invokevirtual   #114 <Method String StringBuffer.toString()>
    //   19   36:areturn         
    }

    public String toString()
    {
        return toSummaryString();
    //    0    0:aload_0         
    //    1    1:invokevirtual   #269 <Method String toSummaryString()>
    //    2    4:areturn         
    }

    public static void main(String args[])
    {
        try
        {
            if(args.length == 0)
    //*   0    0:aload_0         
    //*   1    1:arraylength     
    //*   2    2:ifne            16
                throw new Exception("The first argument must be the class name of a kernel");
    //    3    5:new             #126 <Class Exception>
    //    4    8:dup             
    //    5    9:ldc2            #272 <String "The first argument must be the class name of a kernel">
    //    6   12:invokespecial   #141 <Method void Exception(String)>
    //    7   15:athrow          
            String Assiger = args[0];
    //    8   16:aload_0         
    //    9   17:iconst_0        
    //   10   18:aaload          
    //   11   19:astore_1        
            args[0] = "";
    //   12   20:aload_0         
    //   13   21:iconst_0        
    //   14   22:ldc1            #59  <String "">
    //   15   24:aastore         
            System.out.println(evaluate(Assiger, args));
    //   16   25:getstatic       #107 <Field PrintStream System.out>
    //   17   28:aload_1         
    //   18   29:aload_0         
    //   19   30:invokestatic    #274 <Method String evaluate(String, String[])>
    //   20   33:invokevirtual   #276 <Method void PrintStream.println(String)>
        }
    //*  21   36:goto            54
        catch(Exception ex)
    //*  22   39:astore_1        
        {
            ex.printStackTrace();
    //   23   40:aload_1         
    //   24   41:invokevirtual   #279 <Method void Exception.printStackTrace()>
            System.err.println(ex.getMessage());
    //   25   44:getstatic       #282 <Field PrintStream System.err>
    //   26   47:aload_1         
    //   27   48:invokevirtual   #185 <Method String Exception.getMessage()>
    //   28   51:invokevirtual   #276 <Method void PrintStream.println(String)>
        }
    //   29   54:return          
    }

    protected StringBuffer m_Result;
}
