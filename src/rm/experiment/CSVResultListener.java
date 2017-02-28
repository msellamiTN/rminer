// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   CSVResultListener.java

package rm.experiment;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;
import rm.core.*;

// Referenced classes of package rm.experiment:
//            ResultListener, ResultProducer

public class CSVResultListener
    implements ResultListener, OptionHandler
{

    public CSVResultListener()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #21  <Method void Object()>
        m_OutputFile = null;
    //    2    4:aload_0         
    //    3    5:aconst_null     
    //    4    6:putfield        #23  <Field File m_OutputFile>
        m_OutputFileName = "";
    //    5    9:aload_0         
    //    6   10:ldc1            #25  <String "">
    //    7   12:putfield        #27  <Field String m_OutputFileName>
        m_Out = new PrintWriter(System.out, true);
    //    8   15:aload_0         
    //    9   16:new             #29  <Class PrintWriter>
    //   10   19:dup             
    //   11   20:getstatic       #35  <Field PrintStream System.out>
    //   12   23:iconst_1        
    //   13   24:invokespecial   #38  <Method void PrintWriter(java.io.OutputStream, boolean)>
    //   14   27:putfield        #40  <Field PrintWriter m_Out>
        File resultsFile;
        try
        {
            resultsFile = File.createTempFile("weka_experiment", ".csv");
    //   15   30:ldc1            #42  <String "weka_experiment">
    //   16   32:ldc1            #44  <String ".csv">
    //   17   34:invokestatic    #50  <Method File File.createTempFile(String, String)>
    //   18   37:astore_1        
            resultsFile.deleteOnExit();
    //   19   38:aload_1         
    //   20   39:invokevirtual   #53  <Method void File.deleteOnExit()>
        }
    //*  21   42:goto            64
        catch(Exception e)
    //*  22   45:astore_2        
        {
            System.err.println("Cannot create temp file, writing to standard out.");
    //   23   46:getstatic       #56  <Field PrintStream System.err>
    //   24   49:ldc1            #58  <String "Cannot create temp file, writing to standard out.">
    //   25   51:invokevirtual   #64  <Method void PrintStream.println(String)>
            resultsFile = new File("-");
    //   26   54:new             #46  <Class File>
    //   27   57:dup             
    //   28   58:ldc1            #66  <String "-">
    //   29   60:invokespecial   #68  <Method void File(String)>
    //   30   63:astore_1        
        }
        setOutputFile(resultsFile);
    //   31   64:aload_0         
    //   32   65:aload_1         
    //   33   66:invokevirtual   #72  <Method void setOutputFile(File)>
        setOutputFileName("");
    //   34   69:aload_0         
    //   35   70:ldc1            #25  <String "">
    //   36   72:invokevirtual   #75  <Method void setOutputFileName(String)>
    //   37   75:return          
    }

    public String globalInfo()
    {
        return "Takes results from a result producer and assembles them into comma separated value form.";
    //    0    0:ldc1            #88  <String "Takes results from a result producer and assembles them into comma separated value form.">
    //    1    2:areturn         
    }

    public Enumeration listOptions()
    {
        Vector newVector = new Vector(1);
    //    0    0:new             #92  <Class Vector>
    //    1    3:dup             
    //    2    4:iconst_1        
    //    3    5:invokespecial   #95  <Method void Vector(int)>
    //    4    8:astore_1        
        newVector.addElement(new Option("\tThe filename where output will be stored. Use - for stdout.\n\t(default temp file)", "O", 1, "-O <file name>"));
    //    5    9:aload_1         
    //    6   10:new             #97  <Class Option>
    //    7   13:dup             
    //    8   14:ldc1            #99  <String "\tThe filename where output will be stored. Use - for stdout.\n\t(default temp file)">
    //    9   16:ldc1            #101 <String "O">
    //   10   18:iconst_1        
    //   11   19:ldc1            #103 <String "-O <file name>">
    //   12   21:invokespecial   #106 <Method void Option(String, String, int, String)>
    //   13   24:invokevirtual   #110 <Method void Vector.addElement(Object)>
        return newVector.elements();
    //   14   27:aload_1         
    //   15   28:invokevirtual   #113 <Method Enumeration Vector.elements()>
    //   16   31:areturn         
    }

    public void setOptions(String options[])
        throws Exception
    {
        String fName = Utils.getOption('O', options);
    //    0    0:bipush          79
    //    1    2:aload_1         
    //    2    3:invokestatic    #124 <Method String Utils.getOption(char, String[])>
    //    3    6:astore_2        
        if(fName.length() != 0)
    //*   4    7:aload_2         
    //*   5    8:invokevirtual   #130 <Method int String.length()>
    //*   6   11:ifeq            29
        {
            setOutputFile(new File(fName));
    //    7   14:aload_0         
    //    8   15:new             #46  <Class File>
    //    9   18:dup             
    //   10   19:aload_2         
    //   11   20:invokespecial   #68  <Method void File(String)>
    //   12   23:invokevirtual   #72  <Method void setOutputFile(File)>
        } else
    //*  13   26:goto            74
        {
            File resultsFile;
            try
            {
                resultsFile = File.createTempFile("weka_experiment", null);
    //   14   29:ldc1            #42  <String "weka_experiment">
    //   15   31:aconst_null     
    //   16   32:invokestatic    #50  <Method File File.createTempFile(String, String)>
    //   17   35:astore_3        
                resultsFile.deleteOnExit();
    //   18   36:aload_3         
    //   19   37:invokevirtual   #53  <Method void File.deleteOnExit()>
            }
    //*  20   40:goto            63
            catch(Exception e)
    //*  21   43:astore          4
            {
                System.err.println("Cannot create temp file, writing to standard out.");
    //   22   45:getstatic       #56  <Field PrintStream System.err>
    //   23   48:ldc1            #58  <String "Cannot create temp file, writing to standard out.">
    //   24   50:invokevirtual   #64  <Method void PrintStream.println(String)>
                resultsFile = new File("-");
    //   25   53:new             #46  <Class File>
    //   26   56:dup             
    //   27   57:ldc1            #66  <String "-">
    //   28   59:invokespecial   #68  <Method void File(String)>
    //   29   62:astore_3        
            }
            setOutputFile(resultsFile);
    //   30   63:aload_0         
    //   31   64:aload_3         
    //   32   65:invokevirtual   #72  <Method void setOutputFile(File)>
            setOutputFileName("");
    //   33   68:aload_0         
    //   34   69:ldc1            #25  <String "">
    //   35   71:invokevirtual   #75  <Method void setOutputFileName(String)>
        }
    //   36   74:return          
    }

    public String[] getOptions()
    {
        String options[] = new String[2];
    //    0    0:iconst_2        
    //    1    1:anewarray       String[]
    //    2    4:astore_1        
        int current = 0;
    //    3    5:iconst_0        
    //    4    6:istore_2        
        options[current++] = "-O";
    //    5    7:aload_1         
    //    6    8:iload_2         
    //    7    9:iinc            2  1
    //    8   12:ldc1            #137 <String "-O">
    //    9   14:aastore         
        for(options[current++] = getOutputFile().getName(); current < options.length; options[current++] = "");
    //   10   15:aload_1         
    //   11   16:iload_2         
    //   12   17:iinc            2  1
    //   13   20:aload_0         
    //   14   21:invokevirtual   #141 <Method File getOutputFile()>
    //   15   24:invokevirtual   #144 <Method String File.getName()>
    //   16   27:aastore         
    //   17   28:goto            39
    //   18   31:aload_1         
    //   19   32:iload_2         
    //   20   33:iinc            2  1
    //   21   36:ldc1            #25  <String "">
    //   22   38:aastore         
    //   23   39:iload_2         
    //   24   40:aload_1         
    //   25   41:arraylength     
    //   26   42:icmplt          31
        return options;
    //   27   45:aload_1         
    //   28   46:areturn         
    }

    public String outputFileTipText()
    {
        return "File to save to. Use '-' to write to standard out.";
    //    0    0:ldc1            #149 <String "File to save to. Use '-' to write to standard out.">
    //    1    2:areturn         
    }

    public File getOutputFile()
    {
        return m_OutputFile;
    //    0    0:aload_0         
    //    1    1:getfield        #23  <Field File m_OutputFile>
    //    2    4:areturn         
    }

    public void setOutputFile(File newOutputFile)
    {
        m_OutputFile = newOutputFile;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #23  <Field File m_OutputFile>
        setOutputFileName(newOutputFile.getName());
    //    3    5:aload_0         
    //    4    6:aload_1         
    //    5    7:invokevirtual   #144 <Method String File.getName()>
    //    6   10:invokevirtual   #75  <Method void setOutputFileName(String)>
    //    7   13:return          
    }

    public String outputFileName()
    {
        return m_OutputFileName;
    //    0    0:aload_0         
    //    1    1:getfield        #27  <Field String m_OutputFileName>
    //    2    4:areturn         
    }

    public void setOutputFileName(String name)
    {
        m_OutputFileName = name;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #27  <Field String m_OutputFileName>
    //    3    5:return          
    }

    public void preProcess(ResultProducer rp)
        throws Exception
    {
        m_RP = rp;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #156 <Field ResultProducer m_RP>
        if(m_OutputFile == null || m_OutputFile.getName().equals("-"))
    //*   3    5:aload_0         
    //*   4    6:getfield        #23  <Field File m_OutputFile>
    //*   5    9:ifnull          27
    //*   6   12:aload_0         
    //*   7   13:getfield        #23  <Field File m_OutputFile>
    //*   8   16:invokevirtual   #144 <Method String File.getName()>
    //*   9   19:ldc1            #66  <String "-">
    //*  10   21:invokevirtual   #160 <Method boolean String.equals(Object)>
    //*  11   24:ifeq            45
            m_Out = new PrintWriter(System.out, true);
    //   12   27:aload_0         
    //   13   28:new             #29  <Class PrintWriter>
    //   14   31:dup             
    //   15   32:getstatic       #35  <Field PrintStream System.out>
    //   16   35:iconst_1        
    //   17   36:invokespecial   #38  <Method void PrintWriter(java.io.OutputStream, boolean)>
    //   18   39:putfield        #40  <Field PrintWriter m_Out>
        else
    //*  19   42:goto            75
            m_Out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(m_OutputFile)), true);
    //   20   45:aload_0         
    //   21   46:new             #29  <Class PrintWriter>
    //   22   49:dup             
    //   23   50:new             #162 <Class BufferedOutputStream>
    //   24   53:dup             
    //   25   54:new             #164 <Class FileOutputStream>
    //   26   57:dup             
    //   27   58:aload_0         
    //   28   59:getfield        #23  <Field File m_OutputFile>
    //   29   62:invokespecial   #166 <Method void FileOutputStream(File)>
    //   30   65:invokespecial   #169 <Method void BufferedOutputStream(java.io.OutputStream)>
    //   31   68:iconst_1        
    //   32   69:invokespecial   #38  <Method void PrintWriter(java.io.OutputStream, boolean)>
    //   33   72:putfield        #40  <Field PrintWriter m_Out>
        printResultNames(m_RP);
    //   34   75:aload_0         
    //   35   76:aload_0         
    //   36   77:getfield        #156 <Field ResultProducer m_RP>
    //   37   80:invokespecial   #172 <Method void printResultNames(ResultProducer)>
    //   38   83:return          
    }

    public void postProcess(ResultProducer rp)
        throws Exception
    {
        if(m_OutputFile != null && !m_OutputFile.getName().equals("-"))
    //*   0    0:aload_0         
    //*   1    1:getfield        #23  <Field File m_OutputFile>
    //*   2    4:ifnull          29
    //*   3    7:aload_0         
    //*   4    8:getfield        #23  <Field File m_OutputFile>
    //*   5   11:invokevirtual   #144 <Method String File.getName()>
    //*   6   14:ldc1            #66  <String "-">
    //*   7   16:invokevirtual   #160 <Method boolean String.equals(Object)>
    //*   8   19:ifne            29
            m_Out.close();
    //    9   22:aload_0         
    //   10   23:getfield        #40  <Field PrintWriter m_Out>
    //   11   26:invokevirtual   #177 <Method void PrintWriter.close()>
    //   12   29:return          
    }

    public String[] determineColumnConstraints(ResultProducer rp)
        throws Exception
    {
        return null;
    //    0    0:aconst_null     
    //    1    1:areturn         
    }

    public void acceptResult(ResultProducer rp, Object key[], Object result[])
        throws Exception
    {
        if(m_RP != rp)
    //*   0    0:aload_0         
    //*   1    1:getfield        #156 <Field ResultProducer m_RP>
    //*   2    4:aload_1         
    //*   3    5:if_acmpeq       18
            throw new Error("Unrecognized ResultProducer sending results!!");
    //    4    8:new             #183 <Class Error>
    //    5   11:dup             
    //    6   12:ldc1            #185 <String "Unrecognized ResultProducer sending results!!">
    //    7   14:invokespecial   #186 <Method void Error(String)>
    //    8   17:athrow          
        for(int i = 0; i < key.length; i++)
    //*   9   18:iconst_0        
    //*  10   19:istore          4
    //*  11   21:goto            77
        {
            if(i != 0)
    //*  12   24:iload           4
    //*  13   26:ifeq            38
                m_Out.print(',');
    //   14   29:aload_0         
    //   15   30:getfield        #40  <Field PrintWriter m_Out>
    //   16   33:bipush          44
    //   17   35:invokevirtual   #190 <Method void PrintWriter.print(char)>
            if(key[i] == null)
    //*  18   38:aload_2         
    //*  19   39:iload           4
    //*  20   41:aaload          
    //*  21   42:ifnonnull       57
                m_Out.print("?");
    //   22   45:aload_0         
    //   23   46:getfield        #40  <Field PrintWriter m_Out>
    //   24   49:ldc1            #192 <String "?">
    //   25   51:invokevirtual   #194 <Method void PrintWriter.print(String)>
            else
    //*  26   54:goto            74
                m_Out.print(Utils.quote(key[i].toString()));
    //   27   57:aload_0         
    //   28   58:getfield        #40  <Field PrintWriter m_Out>
    //   29   61:aload_2         
    //   30   62:iload           4
    //   31   64:aaload          
    //   32   65:invokevirtual   #197 <Method String Object.toString()>
    //   33   68:invokestatic    #201 <Method String Utils.quote(String)>
    //   34   71:invokevirtual   #194 <Method void PrintWriter.print(String)>
        }

    //   35   74:iinc            4  1
    //   36   77:iload           4
    //   37   79:aload_2         
    //   38   80:arraylength     
    //   39   81:icmplt          24
        for(int i = 0; i < result.length; i++)
    //*  40   84:iconst_0        
    //*  41   85:istore          4
    //*  42   87:goto            138
        {
            m_Out.print(',');
    //   43   90:aload_0         
    //   44   91:getfield        #40  <Field PrintWriter m_Out>
    //   45   94:bipush          44
    //   46   96:invokevirtual   #190 <Method void PrintWriter.print(char)>
            if(result[i] == null)
    //*  47   99:aload_3         
    //*  48  100:iload           4
    //*  49  102:aaload          
    //*  50  103:ifnonnull       118
                m_Out.print("?");
    //   51  106:aload_0         
    //   52  107:getfield        #40  <Field PrintWriter m_Out>
    //   53  110:ldc1            #192 <String "?">
    //   54  112:invokevirtual   #194 <Method void PrintWriter.print(String)>
            else
    //*  55  115:goto            135
                m_Out.print(Utils.quote(result[i].toString()));
    //   56  118:aload_0         
    //   57  119:getfield        #40  <Field PrintWriter m_Out>
    //   58  122:aload_3         
    //   59  123:iload           4
    //   60  125:aaload          
    //   61  126:invokevirtual   #197 <Method String Object.toString()>
    //   62  129:invokestatic    #201 <Method String Utils.quote(String)>
    //   63  132:invokevirtual   #194 <Method void PrintWriter.print(String)>
        }

    //   64  135:iinc            4  1
    //   65  138:iload           4
    //   66  140:aload_3         
    //   67  141:arraylength     
    //   68  142:icmplt          90
        m_Out.println("");
    //   69  145:aload_0         
    //   70  146:getfield        #40  <Field PrintWriter m_Out>
    //   71  149:ldc1            #25  <String "">
    //   72  151:invokevirtual   #202 <Method void PrintWriter.println(String)>
    //   73  154:return          
    }

    public boolean isResultRequired(ResultProducer rp, Object key[])
        throws Exception
    {
        return true;
    //    0    0:iconst_1        
    //    1    1:ireturn         
    }

    private void printResultNames(ResultProducer rp)
        throws Exception
    {
        String key[] = rp.getKeyNames();
    //    0    0:aload_1         
    //    1    1:invokeinterface #213 <Method String[] ResultProducer.getKeyNames()>
    //    2    6:astore_2        
        for(int i = 0; i < key.length; i++)
    //*   3    7:iconst_0        
    //*   4    8:istore_3        
    //*   5    9:goto            74
        {
            if(i != 0)
    //*   6   12:iload_3         
    //*   7   13:ifeq            25
                m_Out.print(',');
    //    8   16:aload_0         
    //    9   17:getfield        #40  <Field PrintWriter m_Out>
    //   10   20:bipush          44
    //   11   22:invokevirtual   #190 <Method void PrintWriter.print(char)>
            if(key[i] == null)
    //*  12   25:aload_2         
    //*  13   26:iload_3         
    //*  14   27:aaload          
    //*  15   28:ifnonnull       43
                m_Out.print("?");
    //   16   31:aload_0         
    //   17   32:getfield        #40  <Field PrintWriter m_Out>
    //   18   35:ldc1            #192 <String "?">
    //   19   37:invokevirtual   #194 <Method void PrintWriter.print(String)>
            else
    //*  20   40:goto            71
                m_Out.print((new StringBuilder("Key_")).append(key[i].toString()).toString());
    //   21   43:aload_0         
    //   22   44:getfield        #40  <Field PrintWriter m_Out>
    //   23   47:new             #215 <Class StringBuilder>
    //   24   50:dup             
    //   25   51:ldc1            #217 <String "Key_">
    //   26   53:invokespecial   #218 <Method void StringBuilder(String)>
    //   27   56:aload_2         
    //   28   57:iload_3         
    //   29   58:aaload          
    //   30   59:invokevirtual   #219 <Method String String.toString()>
    //   31   62:invokevirtual   #223 <Method StringBuilder StringBuilder.append(String)>
    //   32   65:invokevirtual   #224 <Method String StringBuilder.toString()>
    //   33   68:invokevirtual   #194 <Method void PrintWriter.print(String)>
        }

    //   34   71:iinc            3  1
    //   35   74:iload_3         
    //   36   75:aload_2         
    //   37   76:arraylength     
    //   38   77:icmplt          12
        String result[] = rp.getResultNames();
    //   39   80:aload_1         
    //   40   81:invokeinterface #227 <Method String[] ResultProducer.getResultNames()>
    //   41   86:astore_3        
        for(int i = 0; i < result.length; i++)
    //*  42   87:iconst_0        
    //*  43   88:istore          4
    //*  44   90:goto            138
        {
            m_Out.print(',');
    //   45   93:aload_0         
    //   46   94:getfield        #40  <Field PrintWriter m_Out>
    //   47   97:bipush          44
    //   48   99:invokevirtual   #190 <Method void PrintWriter.print(char)>
            if(result[i] == null)
    //*  49  102:aload_3         
    //*  50  103:iload           4
    //*  51  105:aaload          
    //*  52  106:ifnonnull       121
                m_Out.print("?");
    //   53  109:aload_0         
    //   54  110:getfield        #40  <Field PrintWriter m_Out>
    //   55  113:ldc1            #192 <String "?">
    //   56  115:invokevirtual   #194 <Method void PrintWriter.print(String)>
            else
    //*  57  118:goto            135
                m_Out.print(result[i].toString());
    //   58  121:aload_0         
    //   59  122:getfield        #40  <Field PrintWriter m_Out>
    //   60  125:aload_3         
    //   61  126:iload           4
    //   62  128:aaload          
    //   63  129:invokevirtual   #219 <Method String String.toString()>
    //   64  132:invokevirtual   #194 <Method void PrintWriter.print(String)>
        }

    //   65  135:iinc            4  1
    //   66  138:iload           4
    //   67  140:aload_3         
    //   68  141:arraylength     
    //   69  142:icmplt          93
        m_Out.println("");
    //   70  145:aload_0         
    //   71  146:getfield        #40  <Field PrintWriter m_Out>
    //   72  149:ldc1            #25  <String "">
    //   73  151:invokevirtual   #202 <Method void PrintWriter.println(String)>
    //   74  154:return          
    }

    protected ResultProducer m_RP;
    protected File m_OutputFile;
    protected String m_OutputFileName;
    protected transient PrintWriter m_Out;
}
