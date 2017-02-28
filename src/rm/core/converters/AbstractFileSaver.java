// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   AbstractFileSaver.java

package rm.core.converters;

import java.io.*;
import java.util.Enumeration;
import rm.core.*;

// Referenced classes of package rm.core.converters:
//            AbstractSaver, FileSourcedConverter, ArffLoader

public abstract class AbstractFileSaver extends AbstractSaver
    implements OptionHandler, FileSourcedConverter, EnvironmentHandler
{

    public AbstractFileSaver()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #29  <Method void AbstractSaver()>
        m_useRelativePath = false;
    //    2    4:aload_0         
    //    3    5:iconst_0        
    //    4    6:putfield        #31  <Field boolean m_useRelativePath>
    //    5    9:return          
    }

    public void resetOptions()
    {
        super.resetOptions();
    //    0    0:aload_0         
    //    1    1:invokespecial   #38  <Method void AbstractSaver.resetOptions()>
        m_outputFile = null;
    //    2    4:aload_0         
    //    3    5:aconst_null     
    //    4    6:putfield        #40  <Field File m_outputFile>
        m_writer = null;
    //    5    9:aload_0         
    //    6   10:aconst_null     
    //    7   11:putfield        #42  <Field BufferedWriter m_writer>
        m_prefix = "";
    //    8   14:aload_0         
    //    9   15:ldc1            #44  <String "">
    //   10   17:putfield        #46  <Field String m_prefix>
        m_dir = "";
    //   11   20:aload_0         
    //   12   21:ldc1            #44  <String "">
    //   13   23:putfield        #48  <Field String m_dir>
        m_incrementalCounter = 0;
    //   14   26:aload_0         
    //   15   27:iconst_0        
    //   16   28:putfield        #50  <Field int m_incrementalCounter>
    //   17   31:return          
    }

    public BufferedWriter getWriter()
    {
        return m_writer;
    //    0    0:aload_0         
    //    1    1:getfield        #42  <Field BufferedWriter m_writer>
    //    2    4:areturn         
    }

    public void resetWriter()
    {
        m_writer = null;
    //    0    0:aload_0         
    //    1    1:aconst_null     
    //    2    2:putfield        #42  <Field BufferedWriter m_writer>
    //    3    5:return          
    }

    public String getFileExtension()
    {
        return FILE_EXTENSION;
    //    0    0:aload_0         
    //    1    1:getfield        #57  <Field String FILE_EXTENSION>
    //    2    4:areturn         
    }

    public String[] getFileExtensions()
    {
        return (new String[] {
            getFileExtension()
        });
    //    0    0:iconst_1        
    //    1    1:anewarray       String[]
    //    2    4:dup             
    //    3    5:iconst_0        
    //    4    6:aload_0         
    //    5    7:invokevirtual   #63  <Method String getFileExtension()>
    //    6   10:aastore         
    //    7   11:areturn         
    }

    protected void setFileExtension(String ext)
    {
        FILE_EXTENSION = ext;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #57  <Field String FILE_EXTENSION>
    //    3    5:return          
    }

    public File retrieveFile()
    {
        return m_outputFile;
    //    0    0:aload_0         
    //    1    1:getfield        #40  <Field File m_outputFile>
    //    2    4:areturn         
    }

    public void setFile(File outputFile)
        throws IOException
    {
        m_outputFile = outputFile;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #40  <Field File m_outputFile>
        setDestination(outputFile);
    //    3    5:aload_0         
    //    4    6:aload_1         
    //    5    7:invokevirtual   #76  <Method void setDestination(File)>
    //    6   10:return          
    }

    public void setFilePrefix(String prefix)
    {
        m_prefix = prefix;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #46  <Field String m_prefix>
    //    3    5:return          
    }

    public String filePrefix()
    {
        return m_prefix;
    //    0    0:aload_0         
    //    1    1:getfield        #46  <Field String m_prefix>
    //    2    4:areturn         
    }

    public void setDir(String dir)
    {
        m_dir = dir;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #48  <Field String m_dir>
    //    3    5:return          
    }

    public String retrieveDir()
    {
        return m_dir;
    //    0    0:aload_0         
    //    1    1:getfield        #48  <Field String m_dir>
    //    2    4:areturn         
    }

    public void setEnvironment(Environment env)
    {
        m_env = env;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #87  <Field Environment m_env>
        if(m_outputFile != null)
    //*   3    5:aload_0         
    //*   4    6:getfield        #40  <Field File m_outputFile>
    //*   5    9:ifnull          24
            try
            {
                setFile(m_outputFile);
    //    6   12:aload_0         
    //    7   13:aload_0         
    //    8   14:getfield        #40  <Field File m_outputFile>
    //    9   17:invokevirtual   #89  <Method void setFile(File)>
            }
    //*  10   20:goto            24
            catch(IOException ioexception) { }
    //   11   23:astore_2        
    //   12   24:return          
    }

    public Enumeration listOptions()
    {
        FastVector newVector = new FastVector();
    //    0    0:new             #94  <Class FastVector>
    //    1    3:dup             
    //    2    4:invokespecial   #95  <Method void FastVector()>
    //    3    7:astore_1        
        newVector.addElement(new Option("\tThe input file", "i", 1, "-i <the input file>"));
    //    4    8:aload_1         
    //    5    9:new             #97  <Class Option>
    //    6   12:dup             
    //    7   13:ldc1            #99  <String "\tThe input file">
    //    8   15:ldc1            #101 <String "i">
    //    9   17:iconst_1        
    //   10   18:ldc1            #103 <String "-i <the input file>">
    //   11   20:invokespecial   #106 <Method void Option(String, String, int, String)>
    //   12   23:invokevirtual   #110 <Method void FastVector.addElement(Object)>
        newVector.addElement(new Option("\tThe output file", "o", 1, "-o <the output file>"));
    //   13   26:aload_1         
    //   14   27:new             #97  <Class Option>
    //   15   30:dup             
    //   16   31:ldc1            #112 <String "\tThe output file">
    //   17   33:ldc1            #114 <String "o">
    //   18   35:iconst_1        
    //   19   36:ldc1            #116 <String "-o <the output file>">
    //   20   38:invokespecial   #106 <Method void Option(String, String, int, String)>
    //   21   41:invokevirtual   #110 <Method void FastVector.addElement(Object)>
        return newVector.elements();
    //   22   44:aload_1         
    //   23   45:invokevirtual   #119 <Method Enumeration FastVector.elements()>
    //   24   48:areturn         
    }

    public void setOptions(String options[])
        throws Exception
    {
        String outputString = Utils.getOption('o', options);
    //    0    0:bipush          111
    //    1    2:aload_1         
    //    2    3:invokestatic    #131 <Method String Utils.getOption(char, String[])>
    //    3    6:astore_2        
        String inputString = Utils.getOption('i', options);
    //    4    7:bipush          105
    //    5    9:aload_1         
    //    6   10:invokestatic    #131 <Method String Utils.getOption(char, String[])>
    //    7   13:astore_3        
        ArffLoader loader = new ArffLoader();
    //    8   14:new             #133 <Class ArffLoader>
    //    9   17:dup             
    //   10   18:invokespecial   #134 <Method void ArffLoader()>
    //   11   21:astore          4
        resetOptions();
    //   12   23:aload_0         
    //   13   24:invokevirtual   #135 <Method void resetOptions()>
        if(outputString.length() != 0)
    //*  14   27:aload_2         
    //*  15   28:invokevirtual   #139 <Method int String.length()>
    //*  16   31:ifeq            166
        {
            if(!outputString.endsWith(FILE_EXTENSION))
    //*  17   34:aload_2         
    //*  18   35:aload_0         
    //*  19   36:getfield        #57  <Field String FILE_EXTENSION>
    //*  20   39:invokevirtual   #143 <Method boolean String.endsWith(String)>
    //*  21   42:ifne            112
                if(outputString.lastIndexOf('.') != -1)
    //*  22   45:aload_2         
    //*  23   46:bipush          46
    //*  24   48:invokevirtual   #147 <Method int String.lastIndexOf(int)>
    //*  25   51:iconst_m1       
    //*  26   52:icmpeq          90
                    outputString = (new StringBuilder(String.valueOf(outputString.substring(0, outputString.lastIndexOf('.'))))).append(FILE_EXTENSION).toString();
    //   27   55:new             #149 <Class StringBuilder>
    //   28   58:dup             
    //   29   59:aload_2         
    //   30   60:iconst_0        
    //   31   61:aload_2         
    //   32   62:bipush          46
    //   33   64:invokevirtual   #147 <Method int String.lastIndexOf(int)>
    //   34   67:invokevirtual   #153 <Method String String.substring(int, int)>
    //   35   70:invokestatic    #157 <Method String String.valueOf(Object)>
    //   36   73:invokespecial   #159 <Method void StringBuilder(String)>
    //   37   76:aload_0         
    //   38   77:getfield        #57  <Field String FILE_EXTENSION>
    //   39   80:invokevirtual   #163 <Method StringBuilder StringBuilder.append(String)>
    //   40   83:invokevirtual   #166 <Method String StringBuilder.toString()>
    //   41   86:astore_2        
                else
    //*  42   87:goto            112
                    outputString = (new StringBuilder(String.valueOf(outputString))).append(FILE_EXTENSION).toString();
    //   43   90:new             #149 <Class StringBuilder>
    //   44   93:dup             
    //   45   94:aload_2         
    //   46   95:invokestatic    #157 <Method String String.valueOf(Object)>
    //   47   98:invokespecial   #159 <Method void StringBuilder(String)>
    //   48  101:aload_0         
    //   49  102:getfield        #57  <Field String FILE_EXTENSION>
    //   50  105:invokevirtual   #163 <Method StringBuilder StringBuilder.append(String)>
    //   51  108:invokevirtual   #166 <Method String StringBuilder.toString()>
    //   52  111:astore_2        
            try
            {
                File output = new File(outputString);
    //   53  112:new             #168 <Class File>
    //   54  115:dup             
    //   55  116:aload_2         
    //   56  117:invokespecial   #169 <Method void File(String)>
    //   57  120:astore          5
                setFile(output);
    //   58  122:aload_0         
    //   59  123:aload           5
    //   60  125:invokevirtual   #89  <Method void setFile(File)>
            }
    //*  61  128:goto            166
            catch(Exception ex)
    //*  62  131:astore          5
            {
                throw new IOException((new StringBuilder("Cannot create output file (Reason: ")).append(ex.toString()).append("). Standard out is used.").toString());
    //   63  133:new             #73  <Class IOException>
    //   64  136:dup             
    //   65  137:new             #149 <Class StringBuilder>
    //   66  140:dup             
    //   67  141:ldc1            #171 <String "Cannot create output file (Reason: ">
    //   68  143:invokespecial   #159 <Method void StringBuilder(String)>
    //   69  146:aload           5
    //   70  148:invokevirtual   #172 <Method String Exception.toString()>
    //   71  151:invokevirtual   #163 <Method StringBuilder StringBuilder.append(String)>
    //   72  154:ldc1            #174 <String "). Standard out is used.">
    //   73  156:invokevirtual   #163 <Method StringBuilder StringBuilder.append(String)>
    //   74  159:invokevirtual   #166 <Method String StringBuilder.toString()>
    //   75  162:invokespecial   #175 <Method void IOException(String)>
    //   76  165:athrow          
            }
        }
    //   77  166:return          
    }

    public String[] getOptions()
    {
        String options[] = new String[10];
    //    0    0:bipush          10
    //    1    2:anewarray       String[]
    //    2    5:astore_1        
        int current = 0;
    //    3    6:iconst_0        
    //    4    7:istore_2        
        if(m_outputFile != null)
    //*   5    8:aload_0         
    //*   6    9:getfield        #40  <Field File m_outputFile>
    //*   7   12:ifnull          49
        {
            options[current++] = "-o";
    //    8   15:aload_1         
    //    9   16:iload_2         
    //   10   17:iinc            2  1
    //   11   20:ldc1            #187 <String "-o">
    //   12   22:aastore         
            options[current++] = (new StringBuilder()).append(m_outputFile).toString();
    //   13   23:aload_1         
    //   14   24:iload_2         
    //   15   25:iinc            2  1
    //   16   28:new             #149 <Class StringBuilder>
    //   17   31:dup             
    //   18   32:invokespecial   #188 <Method void StringBuilder()>
    //   19   35:aload_0         
    //   20   36:getfield        #40  <Field File m_outputFile>
    //   21   39:invokevirtual   #191 <Method StringBuilder StringBuilder.append(Object)>
    //   22   42:invokevirtual   #166 <Method String StringBuilder.toString()>
    //   23   45:aastore         
        } else
    //*  24   46:goto            65
        {
            options[current++] = "-o";
    //   25   49:aload_1         
    //   26   50:iload_2         
    //   27   51:iinc            2  1
    //   28   54:ldc1            #187 <String "-o">
    //   29   56:aastore         
            options[current++] = "";
    //   30   57:aload_1         
    //   31   58:iload_2         
    //   32   59:iinc            2  1
    //   33   62:ldc1            #44  <String "">
    //   34   64:aastore         
        }
        if(getAssignment() != null)
    //*  35   65:aload_0         
    //*  36   66:invokevirtual   #195 <Method Assignment getAssignment()>
    //*  37   69:ifnull          109
        {
            options[current++] = "-i";
    //   38   72:aload_1         
    //   39   73:iload_2         
    //   40   74:iinc            2  1
    //   41   77:ldc1            #197 <String "-i">
    //   42   79:aastore         
            options[current++] = (new StringBuilder()).append(getAssignment().getAssignementName()).toString();
    //   43   80:aload_1         
    //   44   81:iload_2         
    //   45   82:iinc            2  1
    //   46   85:new             #149 <Class StringBuilder>
    //   47   88:dup             
    //   48   89:invokespecial   #188 <Method void StringBuilder()>
    //   49   92:aload_0         
    //   50   93:invokevirtual   #195 <Method Assignment getAssignment()>
    //   51   96:invokevirtual   #202 <Method String Assignment.getAssignementName()>
    //   52   99:invokevirtual   #163 <Method StringBuilder StringBuilder.append(String)>
    //   53  102:invokevirtual   #166 <Method String StringBuilder.toString()>
    //   54  105:aastore         
        } else
    //*  55  106:goto            136
        {
            options[current++] = "-i";
    //   56  109:aload_1         
    //   57  110:iload_2         
    //   58  111:iinc            2  1
    //   59  114:ldc1            #197 <String "-i">
    //   60  116:aastore         
            options[current++] = "";
    //   61  117:aload_1         
    //   62  118:iload_2         
    //   63  119:iinc            2  1
    //   64  122:ldc1            #44  <String "">
    //   65  124:aastore         
        }
    //*  66  125:goto            136
        while(current < options.length) 
            options[current++] = "";
    //   67  128:aload_1         
    //   68  129:iload_2         
    //   69  130:iinc            2  1
    //   70  133:ldc1            #44  <String "">
    //   71  135:aastore         
    //   72  136:iload_2         
    //   73  137:aload_1         
    //   74  138:arraylength     
    //   75  139:icmplt          128
        return options;
    //   76  142:aload_1         
    //   77  143:areturn         
    }

    public void cancel()
    {
        if(getWriteMode() == 2)
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #207 <Method int getWriteMode()>
    //*   2    4:iconst_2        
    //*   3    5:icmpne          47
        {
            if(m_outputFile != null && m_outputFile.exists() && m_outputFile.delete())
    //*   4    8:aload_0         
    //*   5    9:getfield        #40  <Field File m_outputFile>
    //*   6   12:ifnull          43
    //*   7   15:aload_0         
    //*   8   16:getfield        #40  <Field File m_outputFile>
    //*   9   19:invokevirtual   #211 <Method boolean File.exists()>
    //*  10   22:ifeq            43
    //*  11   25:aload_0         
    //*  12   26:getfield        #40  <Field File m_outputFile>
    //*  13   29:invokevirtual   #214 <Method boolean File.delete()>
    //*  14   32:ifeq            43
                System.out.println("File deleted.");
    //   15   35:getstatic       #220 <Field PrintStream System.out>
    //   16   38:ldc1            #222 <String "File deleted.">
    //   17   40:invokevirtual   #227 <Method void PrintStream.println(String)>
            resetOptions();
    //   18   43:aload_0         
    //   19   44:invokevirtual   #135 <Method void resetOptions()>
        }
    //   20   47:return          
    }

    public void setDestination(File file)
        throws IOException
    {
        boolean success;
        String out;
        success = false;
    //    0    0:iconst_0        
    //    1    1:istore_2        
        String tempOut = file.getPath();
    //    2    2:aload_1         
    //    3    3:invokevirtual   #230 <Method String File.getPath()>
    //    4    6:astore_3        
        try
        {
            if(m_env == null)
    //*   5    7:aload_0         
    //*   6    8:getfield        #87  <Field Environment m_env>
    //*   7   11:ifnonnull       21
                m_env = Environment.getSystemWide();
    //    8   14:aload_0         
    //    9   15:invokestatic    #236 <Method Environment Environment.getSystemWide()>
    //   10   18:putfield        #87  <Field Environment m_env>
            tempOut = m_env.substitute(tempOut);
    //   11   21:aload_0         
    //   12   22:getfield        #87  <Field Environment m_env>
    //   13   25:aload_3         
    //   14   26:invokevirtual   #240 <Method String Environment.substitute(String)>
    //   15   29:astore_3        
        }
    //*  16   30:goto            35
        catch(Exception exception) { }
    //   17   33:astore          4
        file = new File(tempOut);
    //   18   35:new             #168 <Class File>
    //   19   38:dup             
    //   20   39:aload_3         
    //   21   40:invokespecial   #169 <Method void File(String)>
    //   22   43:astore_1        
        out = file.getAbsolutePath();
    //   23   44:aload_1         
    //   24   45:invokevirtual   #243 <Method String File.getAbsolutePath()>
    //   25   48:astore          4
        if(m_outputFile == null)
            break MISSING_BLOCK_LABEL_287;
    //   26   50:aload_0         
    //   27   51:getfield        #40  <Field File m_outputFile>
    //   28   54:ifnull          287
        try
        {
            if(file.exists() && !file.delete())
    //*  29   57:aload_1         
    //*  30   58:invokevirtual   #211 <Method boolean File.exists()>
    //*  31   61:ifeq            81
    //*  32   64:aload_1         
    //*  33   65:invokevirtual   #214 <Method boolean File.delete()>
    //*  34   68:ifne            81
                throw new IOException("File already exists.");
    //   35   71:new             #73  <Class IOException>
    //   36   74:dup             
    //   37   75:ldc1            #245 <String "File already exists.">
    //   38   77:invokespecial   #175 <Method void IOException(String)>
    //   39   80:athrow          
            if(out.lastIndexOf(File.separatorChar) == -1)
    //*  40   81:aload           4
    //*  41   83:getstatic       #249 <Field char File.separatorChar>
    //*  42   86:invokevirtual   #147 <Method int String.lastIndexOf(int)>
    //*  43   89:iconst_m1       
    //*  44   90:icmpne          101
            {
                success = file.createNewFile();
    //   45   93:aload_1         
    //   46   94:invokevirtual   #252 <Method boolean File.createNewFile()>
    //   47   97:istore_2        
            } else
    //*  48   98:goto            155
            {
                String outPath = out.substring(0, out.lastIndexOf(File.separatorChar));
    //   49  101:aload           4
    //   50  103:iconst_0        
    //   51  104:aload           4
    //   52  106:getstatic       #249 <Field char File.separatorChar>
    //   53  109:invokevirtual   #147 <Method int String.lastIndexOf(int)>
    //   54  112:invokevirtual   #153 <Method String String.substring(int, int)>
    //   55  115:astore          5
                File dir = new File(outPath);
    //   56  117:new             #168 <Class File>
    //   57  120:dup             
    //   58  121:aload           5
    //   59  123:invokespecial   #169 <Method void File(String)>
    //   60  126:astore          6
                if(dir.exists())
    //*  61  128:aload           6
    //*  62  130:invokevirtual   #211 <Method boolean File.exists()>
    //*  63  133:ifeq            144
                {
                    success = file.createNewFile();
    //   64  136:aload_1         
    //   65  137:invokevirtual   #252 <Method boolean File.createNewFile()>
    //   66  140:istore_2        
                } else
    //*  67  141:goto            155
                {
                    dir.mkdirs();
    //   68  144:aload           6
    //   69  146:invokevirtual   #255 <Method boolean File.mkdirs()>
    //   70  149:pop             
                    success = file.createNewFile();
    //   71  150:aload_1         
    //   72  151:invokevirtual   #252 <Method boolean File.createNewFile()>
    //   73  154:istore_2        
                }
            }
            if(success)
    //*  74  155:iload_2         
    //*  75  156:ifeq            269
            {
                if(m_useRelativePath)
    //*  76  159:aload_0         
    //*  77  160:getfield        #31  <Field boolean m_useRelativePath>
    //*  78  163:ifeq            187
                    try
                    {
                        m_outputFile = Utils.convertToRelativePath(file);
    //   79  166:aload_0         
    //   80  167:aload_1         
    //   81  168:invokestatic    #259 <Method File Utils.convertToRelativePath(File)>
    //   82  171:putfield        #40  <Field File m_outputFile>
                    }
    //*  83  174:goto            192
                    catch(Exception e)
    //*  84  177:astore          5
                    {
                        m_outputFile = file;
    //   85  179:aload_0         
    //   86  180:aload_1         
    //   87  181:putfield        #40  <Field File m_outputFile>
                    }
                else
    //*  88  184:goto            192
                    m_outputFile = file;
    //   89  187:aload_0         
    //   90  188:aload_1         
    //   91  189:putfield        #40  <Field File m_outputFile>
                setDestination(((OutputStream) (new FileOutputStream(m_outputFile))));
    //   92  192:aload_0         
    //   93  193:new             #261 <Class FileOutputStream>
    //   94  196:dup             
    //   95  197:aload_0         
    //   96  198:getfield        #40  <Field File m_outputFile>
    //   97  201:invokespecial   #263 <Method void FileOutputStream(File)>
    //   98  204:invokevirtual   #266 <Method void setDestination(OutputStream)>
            }
        }
    //*  99  207:goto            269
        catch(Exception ex)
    //* 100  210:astore          5
        {
            throw new IOException((new StringBuilder("Cannot create a new output file (Reason: ")).append(ex.toString()).append("). Standard out is used.").toString());
    //  101  212:new             #73  <Class IOException>
    //  102  215:dup             
    //  103  216:new             #149 <Class StringBuilder>
    //  104  219:dup             
    //  105  220:ldc2            #268 <String "Cannot create a new output file (Reason: ">
    //  106  223:invokespecial   #159 <Method void StringBuilder(String)>
    //  107  226:aload           5
    //  108  228:invokevirtual   #172 <Method String Exception.toString()>
    //  109  231:invokevirtual   #163 <Method StringBuilder StringBuilder.append(String)>
    //  110  234:ldc1            #174 <String "). Standard out is used.">
    //  111  236:invokevirtual   #163 <Method StringBuilder StringBuilder.append(String)>
    //  112  239:invokevirtual   #166 <Method String StringBuilder.toString()>
    //  113  242:invokespecial   #175 <Method void IOException(String)>
    //  114  245:athrow          
        }
        break MISSING_BLOCK_LABEL_269;
        Exception exception1;
        exception1;
    //  115  246:astore          7
        if(!success)
    //* 116  248:iload_2         
    //* 117  249:ifne            266
        {
            System.err.println("Cannot create a new output file. Standard out is used.");
    //  118  252:getstatic       #271 <Field PrintStream System.err>
    //  119  255:ldc2            #273 <String "Cannot create a new output file. Standard out is used.">
    //  120  258:invokevirtual   #227 <Method void PrintStream.println(String)>
            m_outputFile = null;
    //  121  261:aload_0         
    //  122  262:aconst_null     
    //  123  263:putfield        #40  <Field File m_outputFile>
        }
        throw exception1;
    //  124  266:aload           7
    //  125  268:athrow          
        if(!success)
    //* 126  269:iload_2         
    //* 127  270:ifne            287
        {
            System.err.println("Cannot create a new output file. Standard out is used.");
    //  128  273:getstatic       #271 <Field PrintStream System.err>
    //  129  276:ldc2            #273 <String "Cannot create a new output file. Standard out is used.">
    //  130  279:invokevirtual   #227 <Method void PrintStream.println(String)>
            m_outputFile = null;
    //  131  282:aload_0         
    //  132  283:aconst_null     
    //  133  284:putfield        #40  <Field File m_outputFile>
        }
    //  134  287:return          
    }

    public void setDestination(OutputStream output)
        throws IOException
    {
        m_writer = new BufferedWriter(new OutputStreamWriter(output));
    //    0    0:aload_0         
    //    1    1:new             #280 <Class BufferedWriter>
    //    2    4:dup             
    //    3    5:new             #282 <Class OutputStreamWriter>
    //    4    8:dup             
    //    5    9:aload_1         
    //    6   10:invokespecial   #284 <Method void OutputStreamWriter(OutputStream)>
    //    7   13:invokespecial   #287 <Method void BufferedWriter(java.io.Writer)>
    //    8   16:putfield        #42  <Field BufferedWriter m_writer>
    //    9   19:return          
    }

    public void setDirAndPrefix(String relationName, String add)
    {
        try
        {
            if(m_dir.equals(""))
    //*   0    0:aload_0         
    //*   1    1:getfield        #48  <Field String m_dir>
    //*   2    4:ldc1            #44  <String "">
    //*   3    6:invokevirtual   #294 <Method boolean String.equals(Object)>
    //*   4    9:ifeq            22
                setDir(System.getProperty("user.dir"));
    //    5   12:aload_0         
    //    6   13:ldc2            #296 <String "user.dir">
    //    7   16:invokestatic    #299 <Method String System.getProperty(String)>
    //    8   19:invokevirtual   #301 <Method void setDir(String)>
            if(m_prefix.equals(""))
    //*   9   22:aload_0         
    //*  10   23:getfield        #46  <Field String m_prefix>
    //*  11   26:ldc1            #44  <String "">
    //*  12   28:invokevirtual   #294 <Method boolean String.equals(Object)>
    //*  13   31:ifeq            104
            {
                if(relationName.length() == 0)
    //*  14   34:aload_1         
    //*  15   35:invokevirtual   #139 <Method int String.length()>
    //*  16   38:ifne            52
                    throw new IOException("[Saver] Empty filename!!");
    //   17   41:new             #73  <Class IOException>
    //   18   44:dup             
    //   19   45:ldc2            #303 <String "[Saver] Empty filename!!">
    //   20   48:invokespecial   #175 <Method void IOException(String)>
    //   21   51:athrow          
                setFile(new File((new StringBuilder(String.valueOf(m_dir))).append(File.separator).append(relationName).append(add).append(FILE_EXTENSION).toString()));
    //   22   52:aload_0         
    //   23   53:new             #168 <Class File>
    //   24   56:dup             
    //   25   57:new             #149 <Class StringBuilder>
    //   26   60:dup             
    //   27   61:aload_0         
    //   28   62:getfield        #48  <Field String m_dir>
    //   29   65:invokestatic    #157 <Method String String.valueOf(Object)>
    //   30   68:invokespecial   #159 <Method void StringBuilder(String)>
    //   31   71:getstatic       #306 <Field String File.separator>
    //   32   74:invokevirtual   #163 <Method StringBuilder StringBuilder.append(String)>
    //   33   77:aload_1         
    //   34   78:invokevirtual   #163 <Method StringBuilder StringBuilder.append(String)>
    //   35   81:aload_2         
    //   36   82:invokevirtual   #163 <Method StringBuilder StringBuilder.append(String)>
    //   37   85:aload_0         
    //   38   86:getfield        #57  <Field String FILE_EXTENSION>
    //   39   89:invokevirtual   #163 <Method StringBuilder StringBuilder.append(String)>
    //   40   92:invokevirtual   #166 <Method String StringBuilder.toString()>
    //   41   95:invokespecial   #169 <Method void File(String)>
    //   42   98:invokevirtual   #89  <Method void setFile(File)>
            } else
    //*  43  101:goto            202
            {
                if(relationName.length() > 0)
    //*  44  104:aload_1         
    //*  45  105:invokevirtual   #139 <Method int String.length()>
    //*  46  108:ifle            129
                    relationName = (new StringBuilder("_")).append(relationName).toString();
    //   47  111:new             #149 <Class StringBuilder>
    //   48  114:dup             
    //   49  115:ldc2            #308 <String "_">
    //   50  118:invokespecial   #159 <Method void StringBuilder(String)>
    //   51  121:aload_1         
    //   52  122:invokevirtual   #163 <Method StringBuilder StringBuilder.append(String)>
    //   53  125:invokevirtual   #166 <Method String StringBuilder.toString()>
    //   54  128:astore_1        
                setFile(new File((new StringBuilder(String.valueOf(m_dir))).append(File.separator).append(m_prefix).append(relationName).append(add).append(FILE_EXTENSION).toString()));
    //   55  129:aload_0         
    //   56  130:new             #168 <Class File>
    //   57  133:dup             
    //   58  134:new             #149 <Class StringBuilder>
    //   59  137:dup             
    //   60  138:aload_0         
    //   61  139:getfield        #48  <Field String m_dir>
    //   62  142:invokestatic    #157 <Method String String.valueOf(Object)>
    //   63  145:invokespecial   #159 <Method void StringBuilder(String)>
    //   64  148:getstatic       #306 <Field String File.separator>
    //   65  151:invokevirtual   #163 <Method StringBuilder StringBuilder.append(String)>
    //   66  154:aload_0         
    //   67  155:getfield        #46  <Field String m_prefix>
    //   68  158:invokevirtual   #163 <Method StringBuilder StringBuilder.append(String)>
    //   69  161:aload_1         
    //   70  162:invokevirtual   #163 <Method StringBuilder StringBuilder.append(String)>
    //   71  165:aload_2         
    //   72  166:invokevirtual   #163 <Method StringBuilder StringBuilder.append(String)>
    //   73  169:aload_0         
    //   74  170:getfield        #57  <Field String FILE_EXTENSION>
    //   75  173:invokevirtual   #163 <Method StringBuilder StringBuilder.append(String)>
    //   76  176:invokevirtual   #166 <Method String StringBuilder.toString()>
    //   77  179:invokespecial   #169 <Method void File(String)>
    //   78  182:invokevirtual   #89  <Method void setFile(File)>
            }
        }
    //*  79  185:goto            202
        catch(Exception ex)
    //*  80  188:astore_3        
        {
            System.err.println("File prefix and/or directory could not have been set.");
    //   81  189:getstatic       #271 <Field PrintStream System.err>
    //   82  192:ldc2            #310 <String "File prefix and/or directory could not have been set.">
    //   83  195:invokevirtual   #227 <Method void PrintStream.println(String)>
            ex.printStackTrace();
    //   84  198:aload_3         
    //   85  199:invokevirtual   #313 <Method void Exception.printStackTrace()>
        }
    //   86  202:return          
    }

    public abstract String getFileDescription();

    public String useRelativePathTipText()
    {
        return "Use relative rather than absolute paths";
    //    0    0:ldc2            #319 <String "Use relative rather than absolute paths">
    //    1    3:areturn         
    }

    public void setUseRelativePath(boolean rp)
    {
        m_useRelativePath = rp;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #31  <Field boolean m_useRelativePath>
    //    3    5:return          
    }

    public boolean getUseRelativePath()
    {
        return m_useRelativePath;
    //    0    0:aload_0         
    //    1    1:getfield        #31  <Field boolean m_useRelativePath>
    //    2    4:ireturn         
    }

    protected static String makeOptionStr(AbstractFileSaver saver)
    {
        StringBuffer result = new StringBuffer();
    //    0    0:new             #327 <Class StringBuffer>
    //    1    3:dup             
    //    2    4:invokespecial   #328 <Method void StringBuffer()>
    //    3    7:astore_1        
        result.append("\n");
    //    4    8:aload_1         
    //    5    9:ldc2            #330 <String "\n">
    //    6   12:invokevirtual   #333 <Method StringBuffer StringBuffer.append(String)>
    //    7   15:pop             
        result.append(saver.getClass().getName().replaceAll(".*\\.", ""));
    //    8   16:aload_1         
    //    9   17:aload_0         
    //   10   18:invokevirtual   #339 <Method Class Object.getClass()>
    //   11   21:invokevirtual   #344 <Method String Class.getName()>
    //   12   24:ldc2            #346 <String ".*\\.">
    //   13   27:ldc1            #44  <String "">
    //   14   29:invokevirtual   #350 <Method String String.replaceAll(String, String)>
    //   15   32:invokevirtual   #333 <Method StringBuffer StringBuffer.append(String)>
    //   16   35:pop             
        result.append(" options:\n\n");
    //   17   36:aload_1         
    //   18   37:ldc2            #352 <String " options:\n\n">
    //   19   40:invokevirtual   #333 <Method StringBuffer StringBuffer.append(String)>
    //   20   43:pop             
        Option option;
        for(Enumeration enm = saver.listOptions(); enm.hasMoreElements(); result.append((new StringBuilder(String.valueOf(option.description()))).append("\n").toString()))
    //*  21   44:aload_0         
    //*  22   45:invokevirtual   #354 <Method Enumeration listOptions()>
    //*  23   48:astore_3        
    //*  24   49:goto            121
        {
            option = (Option)(Option)enm.nextElement();
    //   25   52:aload_3         
    //   26   53:invokeinterface #360 <Method Object Enumeration.nextElement()>
    //   27   58:checkcast       #97  <Class Option>
    //   28   61:checkcast       #97  <Class Option>
    //   29   64:astore_2        
            result.append((new StringBuilder(String.valueOf(option.synopsis()))).append("\n").toString());
    //   30   65:aload_1         
    //   31   66:new             #149 <Class StringBuilder>
    //   32   69:dup             
    //   33   70:aload_2         
    //   34   71:invokevirtual   #363 <Method String Option.synopsis()>
    //   35   74:invokestatic    #157 <Method String String.valueOf(Object)>
    //   36   77:invokespecial   #159 <Method void StringBuilder(String)>
    //   37   80:ldc2            #330 <String "\n">
    //   38   83:invokevirtual   #163 <Method StringBuilder StringBuilder.append(String)>
    //   39   86:invokevirtual   #166 <Method String StringBuilder.toString()>
    //   40   89:invokevirtual   #333 <Method StringBuffer StringBuffer.append(String)>
    //   41   92:pop             
        }

    //   42   93:aload_1         
    //   43   94:new             #149 <Class StringBuilder>
    //   44   97:dup             
    //   45   98:aload_2         
    //   46   99:invokevirtual   #366 <Method String Option.description()>
    //   47  102:invokestatic    #157 <Method String String.valueOf(Object)>
    //   48  105:invokespecial   #159 <Method void StringBuilder(String)>
    //   49  108:ldc2            #330 <String "\n">
    //   50  111:invokevirtual   #163 <Method StringBuilder StringBuilder.append(String)>
    //   51  114:invokevirtual   #166 <Method String StringBuilder.toString()>
    //   52  117:invokevirtual   #333 <Method StringBuffer StringBuffer.append(String)>
    //   53  120:pop             
    //   54  121:aload_3         
    //   55  122:invokeinterface #369 <Method boolean Enumeration.hasMoreElements()>
    //   56  127:ifne            52
        return result.toString();
    //   57  130:aload_1         
    //   58  131:invokevirtual   #370 <Method String StringBuffer.toString()>
    //   59  134:areturn         
    }

    public static void runFileSaver(AbstractFileSaver saver, String options[])
    {
        try
        {
            String tmpOptions[] = (String[])options.clone();
    //    0    0:aload_1         
    //    1    1:invokevirtual   #383 <Method Object _5B_Ljava.lang.String_3B_.clone()>
    //    2    4:checkcast       #380 <Class String[]>
    //    3    7:astore_2        
            if(Utils.getFlag('h', tmpOptions))
    //*   4    8:bipush          104
    //*   5   10:aload_2         
    //*   6   11:invokestatic    #387 <Method boolean Utils.getFlag(char, String[])>
    //*   7   14:ifeq            48
            {
                System.err.println((new StringBuilder("\nHelp requested\n")).append(makeOptionStr(saver)).toString());
    //    8   17:getstatic       #271 <Field PrintStream System.err>
    //    9   20:new             #149 <Class StringBuilder>
    //   10   23:dup             
    //   11   24:ldc2            #389 <String "\nHelp requested\n">
    //   12   27:invokespecial   #159 <Method void StringBuilder(String)>
    //   13   30:aload_0         
    //   14   31:invokestatic    #391 <Method String makeOptionStr(AbstractFileSaver)>
    //   15   34:invokevirtual   #163 <Method StringBuilder StringBuilder.append(String)>
    //   16   37:invokevirtual   #166 <Method String StringBuilder.toString()>
    //   17   40:invokevirtual   #227 <Method void PrintStream.println(String)>
                return;
    //   18   43:return          
            }
        }
    //*  19   44:goto            48
        catch(Exception exception) { }
    //   20   47:astore_2        
        try
        {
            try
            {
                saver.setOptions(options);
    //   21   48:aload_0         
    //   22   49:aload_1         
    //   23   50:invokevirtual   #393 <Method void setOptions(String[])>
            }
    //*  24   53:goto            71
            catch(Exception ex)
    //*  25   56:astore_2        
            {
                System.err.println(makeOptionStr(saver));
    //   26   57:getstatic       #271 <Field PrintStream System.err>
    //   27   60:aload_0         
    //   28   61:invokestatic    #391 <Method String makeOptionStr(AbstractFileSaver)>
    //   29   64:invokevirtual   #227 <Method void PrintStream.println(String)>
                System.exit(1);
    //   30   67:iconst_1        
    //   31   68:invokestatic    #397 <Method void System.exit(int)>
            }
            saver.writeBatch();
    //   32   71:aload_0         
    //   33   72:invokevirtual   #400 <Method void writeBatch()>
        }
    //*  34   75:goto            83
        catch(Exception ex)
    //*  35   78:astore_2        
        {
            ex.printStackTrace();
    //   36   79:aload_2         
    //   37   80:invokevirtual   #313 <Method void Exception.printStackTrace()>
        }
    //   38   83:return          
    }

    private File m_outputFile;
    private transient BufferedWriter m_writer;
    private String FILE_EXTENSION;
    private String m_prefix;
    private String m_dir;
    protected int m_incrementalCounter;
    protected boolean m_useRelativePath;
    protected transient Environment m_env;
}
