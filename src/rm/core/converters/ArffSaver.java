// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   ArffSaver.java

package rm.core.converters;

import java.io.*;
import rm.core.Assignment;
import rm.core.Capabilities;

// Referenced classes of package rm.core.converters:
//            AbstractFileSaver, BatchConverter, IncrementalConverter

public class ArffSaver extends AbstractFileSaver
    implements BatchConverter, IncrementalConverter
{

    public ArffSaver()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #18  <Method void AbstractFileSaver()>
        resetOptions();
    //    2    4:aload_0         
    //    3    5:invokevirtual   #21  <Method void resetOptions()>
    //    4    8:return          
    }

    public String globalInfo()
    {
        return "Writes to a destination that is in arff (attribute relation file format) format. ";
    //    0    0:ldc1            #29  <String "Writes to a destination that is in arff (attribute relation file format) format. ">
    //    1    2:areturn         
    }

    public String getFileDescription()
    {
        return "Ass data files";
    //    0    0:ldc1            #32  <String "Ass data files">
    //    1    2:areturn         
    }

    public void resetOptions()
    {
        super.resetOptions();
    //    0    0:aload_0         
    //    1    1:invokespecial   #33  <Method void AbstractFileSaver.resetOptions()>
        setFileExtension(".ass");
    //    2    4:aload_0         
    //    3    5:ldc1            #35  <String ".ass">
    //    4    7:invokevirtual   #39  <Method void setFileExtension(String)>
    //    5   10:return          
    }

    public Capabilities getCapabilities()
    {
        Capabilities result = super.getCapabilities();
    //    0    0:aload_0         
    //    1    1:invokespecial   #43  <Method Capabilities AbstractFileSaver.getCapabilities()>
    //    2    4:astore_1        
        result.enableAllAttributes();
    //    3    5:aload_1         
    //    4    6:invokevirtual   #48  <Method void Capabilities.enableAllAttributes()>
        result.enable(rm.core.Capabilities.Capability.MISSING_VALUES);
    //    5    9:aload_1         
    //    6   10:getstatic       #54  <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.MISSING_VALUES>
    //    7   13:invokevirtual   #58  <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enableAllClasses();
    //    8   16:aload_1         
    //    9   17:invokevirtual   #61  <Method void Capabilities.enableAllClasses()>
        result.enable(rm.core.Capabilities.Capability.MISSING_CLASS_VALUES);
    //   10   20:aload_1         
    //   11   21:getstatic       #64  <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.MISSING_CLASS_VALUES>
    //   12   24:invokevirtual   #58  <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enable(rm.core.Capabilities.Capability.NO_CLASS);
    //   13   27:aload_1         
    //   14   28:getstatic       #67  <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.NO_CLASS>
    //   15   31:invokevirtual   #58  <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        return result;
    //   16   34:aload_1         
    //   17   35:areturn         
    }

    public void writeIncremental(Assignment newassignment)
        throws IOException
    {
        int writeMode = getWriteMode();
    //    0    0:aload_0         
    //    1    1:invokevirtual   #78  <Method int getWriteMode()>
    //    2    4:istore_2        
        Assignment structure = getAssignment();
    //    3    5:aload_0         
    //    4    6:invokevirtual   #82  <Method Assignment getAssignment()>
    //    5    9:astore_3        
        PrintWriter outW = null;
    //    6   10:aconst_null     
    //    7   11:astore          4
        if(getRetrieval() == 1 || getRetrieval() == 0)
    //*   8   13:aload_0         
    //*   9   14:invokevirtual   #85  <Method int getRetrieval()>
    //*  10   17:iconst_1        
    //*  11   18:icmpeq          28
    //*  12   21:aload_0         
    //*  13   22:invokevirtual   #85  <Method int getRetrieval()>
    //*  14   25:ifne            38
            throw new IOException("Batch and incremental saving cannot be mixed.");
    //   15   28:new             #74  <Class IOException>
    //   16   31:dup             
    //   17   32:ldc1            #87  <String "Batch and incremental saving cannot be mixed.">
    //   18   34:invokespecial   #89  <Method void IOException(String)>
    //   19   37:athrow          
        if(getWriter() != null)
    //*  20   38:aload_0         
    //*  21   39:invokevirtual   #93  <Method java.io.BufferedWriter getWriter()>
    //*  22   42:ifnull          58
            outW = new PrintWriter(getWriter());
    //   23   45:new             #95  <Class PrintWriter>
    //   24   48:dup             
    //   25   49:aload_0         
    //   26   50:invokevirtual   #93  <Method java.io.BufferedWriter getWriter()>
    //   27   53:invokespecial   #98  <Method void PrintWriter(java.io.Writer)>
    //   28   56:astore          4
        if(writeMode == 1)
    //*  29   58:iload_2         
    //*  30   59:iconst_1        
    //*  31   60:icmpne          97
        {
            if(structure == null)
    //*  32   63:aload_3         
    //*  33   64:ifnonnull       87
            {
                setWriteMode(2);
    //   34   67:aload_0         
    //   35   68:iconst_2        
    //   36   69:invokevirtual   #102 <Method void setWriteMode(int)>
                if(newassignment != null)
    //*  37   72:aload_1         
    //*  38   73:ifnull          92
                    System.err.println("Structure(Header Information) has to be set in advance");
    //   39   76:getstatic       #108 <Field PrintStream System.err>
    //   40   79:ldc1            #110 <String "Structure(Header Information) has to be set in advance">
    //   41   81:invokevirtual   #115 <Method void PrintStream.println(String)>
            } else
    //*  42   84:goto            92
            {
                setWriteMode(3);
    //   43   87:aload_0         
    //   44   88:iconst_3        
    //   45   89:invokevirtual   #102 <Method void setWriteMode(int)>
            }
            writeMode = getWriteMode();
    //   46   92:aload_0         
    //   47   93:invokevirtual   #78  <Method int getWriteMode()>
    //   48   96:istore_2        
        }
        if(writeMode == 2)
    //*  49   97:iload_2         
    //*  50   98:iconst_2        
    //*  51   99:icmpne          116
        {
            if(outW != null)
    //*  52  102:aload           4
    //*  53  104:ifnull          112
                outW.close();
    //   54  107:aload           4
    //   55  109:invokevirtual   #118 <Method void PrintWriter.close()>
            cancel();
    //   56  112:aload_0         
    //   57  113:invokevirtual   #121 <Method void cancel()>
        }
        if(writeMode == 3)
    //*  58  116:iload_2         
    //*  59  117:iconst_3        
    //*  60  118:icmpne          189
        {
            setWriteMode(0);
    //   61  121:aload_0         
    //   62  122:iconst_0        
    //   63  123:invokevirtual   #102 <Method void setWriteMode(int)>
            Assignment header = new Assignment(newassignment);
    //   64  126:new             #123 <Class Assignment>
    //   65  129:dup             
    //   66  130:aload_1         
    //   67  131:invokespecial   #125 <Method void Assignment(Assignment)>
    //   68  134:astore          5
            if(retrieveFile() == null || outW == null)
    //*  69  136:aload_0         
    //*  70  137:invokevirtual   #129 <Method java.io.File retrieveFile()>
    //*  71  140:ifnull          148
    //*  72  143:aload           4
    //*  73  145:ifnonnull       162
            {
                System.out.println(header.toString());
    //   74  148:getstatic       #132 <Field PrintStream System.out>
    //   75  151:aload           5
    //   76  153:invokevirtual   #135 <Method String Assignment.toString()>
    //   77  156:invokevirtual   #115 <Method void PrintStream.println(String)>
            } else
    //*  78  159:goto            184
            {
                outW.print(header.toString());
    //   79  162:aload           4
    //   80  164:aload           5
    //   81  166:invokevirtual   #135 <Method String Assignment.toString()>
    //   82  169:invokevirtual   #138 <Method void PrintWriter.print(String)>
                outW.print("\n");
    //   83  172:aload           4
    //   84  174:ldc1            #140 <String "\n">
    //   85  176:invokevirtual   #138 <Method void PrintWriter.print(String)>
                outW.flush();
    //   86  179:aload           4
    //   87  181:invokevirtual   #143 <Method void PrintWriter.flush()>
            }
            writeMode = getWriteMode();
    //   88  184:aload_0         
    //   89  185:invokevirtual   #78  <Method int getWriteMode()>
    //   90  188:istore_2        
        }
        if(writeMode == 0)
    //*  91  189:iload_2         
    //*  92  190:ifne            302
        {
            if(structure == null)
    //*  93  193:aload_3         
    //*  94  194:ifnonnull       207
                throw new IOException("No instances information available.");
    //   95  197:new             #74  <Class IOException>
    //   96  200:dup             
    //   97  201:ldc1            #145 <String "No instances information available.">
    //   98  203:invokespecial   #89  <Method void IOException(String)>
    //   99  206:athrow          
            if(newassignment != null)
    //* 100  207:aload_1         
    //* 101  208:ifnull          271
            {
                if(retrieveFile() == null || outW == null)
    //* 102  211:aload_0         
    //* 103  212:invokevirtual   #129 <Method java.io.File retrieveFile()>
    //* 104  215:ifnull          223
    //* 105  218:aload           4
    //* 106  220:ifnonnull       233
                {
                    System.out.println(newassignment);
    //  107  223:getstatic       #132 <Field PrintStream System.out>
    //  108  226:aload_1         
    //  109  227:invokevirtual   #148 <Method void PrintStream.println(Object)>
                } else
    //* 110  230:goto            302
                {
                    outW.println(newassignment);
    //  111  233:aload           4
    //  112  235:aload_1         
    //  113  236:invokevirtual   #149 <Method void PrintWriter.println(Object)>
                    m_incrementalCounter++;
    //  114  239:aload_0         
    //  115  240:dup             
    //  116  241:getfield        #153 <Field int m_incrementalCounter>
    //  117  244:iconst_1        
    //  118  245:iadd            
    //  119  246:putfield        #153 <Field int m_incrementalCounter>
                    if(m_incrementalCounter > 100)
    //* 120  249:aload_0         
    //* 121  250:getfield        #153 <Field int m_incrementalCounter>
    //* 122  253:bipush          100
    //* 123  255:icmple          302
                    {
                        m_incrementalCounter = 0;
    //  124  258:aload_0         
    //  125  259:iconst_0        
    //  126  260:putfield        #153 <Field int m_incrementalCounter>
                        outW.flush();
    //  127  263:aload           4
    //  128  265:invokevirtual   #143 <Method void PrintWriter.flush()>
                    }
                }
            } else
    //* 129  268:goto            302
            {
                if(outW != null)
    //* 130  271:aload           4
    //* 131  273:ifnull          286
                {
                    outW.flush();
    //  132  276:aload           4
    //  133  278:invokevirtual   #143 <Method void PrintWriter.flush()>
                    outW.close();
    //  134  281:aload           4
    //  135  283:invokevirtual   #118 <Method void PrintWriter.close()>
                }
                m_incrementalCounter = 0;
    //  136  286:aload_0         
    //  137  287:iconst_0        
    //  138  288:putfield        #153 <Field int m_incrementalCounter>
                resetStructure();
    //  139  291:aload_0         
    //  140  292:invokevirtual   #156 <Method void resetStructure()>
                outW = null;
    //  141  295:aconst_null     
    //  142  296:astore          4
                resetWriter();
    //  143  298:aload_0         
    //  144  299:invokevirtual   #159 <Method void resetWriter()>
            }
        }
    //  145  302:return          
    }

    public void writeBatch()
        throws IOException
    {
        if(getAssignment() == null)
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #82  <Method Assignment getAssignment()>
    //*   2    4:ifnonnull       17
            throw new IOException("No instances to save");
    //    3    7:new             #74  <Class IOException>
    //    4   10:dup             
    //    5   11:ldc1            #169 <String "No instances to save">
    //    6   13:invokespecial   #89  <Method void IOException(String)>
    //    7   16:athrow          
        if(getRetrieval() == 2)
    //*   8   17:aload_0         
    //*   9   18:invokevirtual   #85  <Method int getRetrieval()>
    //*  10   21:iconst_2        
    //*  11   22:icmpne          35
            throw new IOException("Batch and incremental saving cannot be mixed.");
    //   12   25:new             #74  <Class IOException>
    //   13   28:dup             
    //   14   29:ldc1            #87  <String "Batch and incremental saving cannot be mixed.">
    //   15   31:invokespecial   #89  <Method void IOException(String)>
    //   16   34:athrow          
        setRetrieval(1);
    //   17   35:aload_0         
    //   18   36:iconst_1        
    //   19   37:invokevirtual   #172 <Method void setRetrieval(int)>
        setWriteMode(0);
    //   20   40:aload_0         
    //   21   41:iconst_0        
    //   22   42:invokevirtual   #102 <Method void setWriteMode(int)>
        if(retrieveFile() == null && getWriter() == null)
    //*  23   45:aload_0         
    //*  24   46:invokevirtual   #129 <Method java.io.File retrieveFile()>
    //*  25   49:ifnonnull       78
    //*  26   52:aload_0         
    //*  27   53:invokevirtual   #93  <Method java.io.BufferedWriter getWriter()>
    //*  28   56:ifnonnull       78
        {
            System.out.println(getAssignment().toString());
    //   29   59:getstatic       #132 <Field PrintStream System.out>
    //   30   62:aload_0         
    //   31   63:invokevirtual   #82  <Method Assignment getAssignment()>
    //   32   66:invokevirtual   #135 <Method String Assignment.toString()>
    //   33   69:invokevirtual   #115 <Method void PrintStream.println(String)>
            setWriteMode(1);
    //   34   72:aload_0         
    //   35   73:iconst_1        
    //   36   74:invokevirtual   #102 <Method void setWriteMode(int)>
            return;
    //   37   77:return          
        } else
        {
            PrintWriter outW = new PrintWriter(getWriter());
    //   38   78:new             #95  <Class PrintWriter>
    //   39   81:dup             
    //   40   82:aload_0         
    //   41   83:invokevirtual   #93  <Method java.io.BufferedWriter getWriter()>
    //   42   86:invokespecial   #98  <Method void PrintWriter(java.io.Writer)>
    //   43   89:astore_1        
            outW.print(getAssignment().toString());
    //   44   90:aload_1         
    //   45   91:aload_0         
    //   46   92:invokevirtual   #82  <Method Assignment getAssignment()>
    //   47   95:invokevirtual   #135 <Method String Assignment.toString()>
    //   48   98:invokevirtual   #138 <Method void PrintWriter.print(String)>
            outW.flush();
    //   49  101:aload_1         
    //   50  102:invokevirtual   #143 <Method void PrintWriter.flush()>
            outW.close();
    //   51  105:aload_1         
    //   52  106:invokevirtual   #118 <Method void PrintWriter.close()>
            setWriteMode(1);
    //   53  109:aload_0         
    //   54  110:iconst_1        
    //   55  111:invokevirtual   #102 <Method void setWriteMode(int)>
            outW = null;
    //   56  114:aconst_null     
    //   57  115:astore_1        
            resetWriter();
    //   58  116:aload_0         
    //   59  117:invokevirtual   #159 <Method void resetWriter()>
            setWriteMode(2);
    //   60  120:aload_0         
    //   61  121:iconst_2        
    //   62  122:invokevirtual   #102 <Method void setWriteMode(int)>
            return;
    //   63  125:return          
        }
    }

    public static void main(String args[])
    {
        AbstractFileSaver.runFileSaver(new ArffSaver(), args);
    //    0    0:new             #2   <Class ArffSaver>
    //    1    3:dup             
    //    2    4:invokespecial   #175 <Method void ArffSaver()>
    //    3    7:aload_0         
    //    4    8:invokestatic    #179 <Method void AbstractFileSaver.runFileSaver(AbstractFileSaver, String[])>
    //    5   11:return          
    }

    static final long serialVersionUID = 0x1edbef916c145df4L;
}
