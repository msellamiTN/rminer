// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   AbstractFileLoader.java

package rm.core.converters;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.GZIPInputStream;
import rm.core.*;

// Referenced classes of package rm.core.converters:
//            AbstractLoader, FileSourcedConverter, IncrementalConverter

public abstract class AbstractFileLoader extends AbstractLoader
    implements FileSourcedConverter
{

    public AbstractFileLoader()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #27  <Method void AbstractLoader()>
        m_File = (new File(System.getProperty("user.dir"))).getAbsolutePath();
    //    2    4:aload_0         
    //    3    5:new             #29  <Class File>
    //    4    8:dup             
    //    5    9:ldc1            #31  <String "user.dir">
    //    6   11:invokestatic    #37  <Method String System.getProperty(String)>
    //    7   14:invokespecial   #40  <Method void File(String)>
    //    8   17:invokevirtual   #44  <Method String File.getAbsolutePath()>
    //    9   20:putfield        #46  <Field String m_File>
        m_structure = null;
    //   10   23:aload_0         
    //   11   24:aconst_null     
    //   12   25:putfield        #48  <Field Instances m_structure>
        m_sourceFile = null;
    //   13   28:aload_0         
    //   14   29:aconst_null     
    //   15   30:putfield        #50  <Field File m_sourceFile>
        m_useRelativePath = false;
    //   16   33:aload_0         
    //   17   34:iconst_0        
    //   18   35:putfield        #52  <Field boolean m_useRelativePath>
    //   19   38:return          
    }

    public File retrieveFile()
    {
        return new File(m_File);
    //    0    0:new             #29  <Class File>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:getfield        #46  <Field String m_File>
    //    4    8:invokespecial   #40  <Method void File(String)>
    //    5   11:areturn         
    }

    public void setFile(File file)
        throws IOException
    {
        m_structure = null;
    //    0    0:aload_0         
    //    1    1:aconst_null     
    //    2    2:putfield        #48  <Field Instances m_structure>
        setRetrieval(0);
    //    3    5:aload_0         
    //    4    6:iconst_0        
    //    5    7:invokevirtual   #65  <Method void setRetrieval(int)>
        setSource(file);
    //    6   10:aload_0         
    //    7   11:aload_1         
    //    8   12:invokevirtual   #68  <Method void setSource(File)>
    //    9   15:return          
    }

    public void reset()
        throws IOException
    {
        m_structure = null;
    //    0    0:aload_0         
    //    1    1:aconst_null     
    //    2    2:putfield        #48  <Field Instances m_structure>
        setRetrieval(0);
    //    3    5:aload_0         
    //    4    6:iconst_0        
    //    5    7:invokevirtual   #65  <Method void setRetrieval(int)>
    //    6   10:return          
    }

    public void setSource(File file)
        throws IOException
    {
        File original = file;
    //    0    0:aload_1         
    //    1    1:astore_2        
        m_structure = null;
    //    2    2:aload_0         
    //    3    3:aconst_null     
    //    4    4:putfield        #48  <Field Instances m_structure>
        setRetrieval(0);
    //    5    7:aload_0         
    //    6    8:iconst_0        
    //    7    9:invokevirtual   #65  <Method void setRetrieval(int)>
        if(file == null)
    //*   8   12:aload_1         
    //*   9   13:ifnonnull       26
            throw new IOException("Source file object is null!");
    //   10   16:new             #61  <Class IOException>
    //   11   19:dup             
    //   12   20:ldc1            #72  <String "Source file object is null!">
    //   13   22:invokespecial   #73  <Method void IOException(String)>
    //   14   25:athrow          
        String fName = file.getPath();
    //   15   26:aload_1         
    //   16   27:invokevirtual   #76  <Method String File.getPath()>
    //   17   30:astore_3        
        file = new File(fName);
    //   18   31:new             #29  <Class File>
    //   19   34:dup             
    //   20   35:aload_3         
    //   21   36:invokespecial   #40  <Method void File(String)>
    //   22   39:astore_1        
        if(file.exists())
    //*  23   40:aload_1         
    //*  24   41:invokevirtual   #80  <Method boolean File.exists()>
    //*  25   44:ifeq            114
            if(file.getName().endsWith((new StringBuilder(String.valueOf(getFileExtension()))).append(FILE_EXTENSION_COMPRESSED).toString()))
    //*  26   47:aload_1         
    //*  27   48:invokevirtual   #83  <Method String File.getName()>
    //*  28   51:new             #85  <Class StringBuilder>
    //*  29   54:dup             
    //*  30   55:aload_0         
    //*  31   56:invokevirtual   #88  <Method String getFileExtension()>
    //*  32   59:invokestatic    #94  <Method String String.valueOf(Object)>
    //*  33   62:invokespecial   #95  <Method void StringBuilder(String)>
    //*  34   65:getstatic       #22  <Field String FILE_EXTENSION_COMPRESSED>
    //*  35   68:invokevirtual   #99  <Method StringBuilder StringBuilder.append(String)>
    //*  36   71:invokevirtual   #102 <Method String StringBuilder.toString()>
    //*  37   74:invokevirtual   #106 <Method boolean String.endsWith(String)>
    //*  38   77:ifeq            102
                setSource(((java.io.InputStream) (new GZIPInputStream(new FileInputStream(file)))));
    //   39   80:aload_0         
    //   40   81:new             #108 <Class GZIPInputStream>
    //   41   84:dup             
    //   42   85:new             #110 <Class FileInputStream>
    //   43   88:dup             
    //   44   89:aload_1         
    //   45   90:invokespecial   #112 <Method void FileInputStream(File)>
    //   46   93:invokespecial   #115 <Method void GZIPInputStream(java.io.InputStream)>
    //   47   96:invokevirtual   #117 <Method void setSource(java.io.InputStream)>
            else
    //*  48   99:goto            114
                setSource(((java.io.InputStream) (new FileInputStream(file))));
    //   49  102:aload_0         
    //   50  103:new             #110 <Class FileInputStream>
    //   51  106:dup             
    //   52  107:aload_1         
    //   53  108:invokespecial   #112 <Method void FileInputStream(File)>
    //   54  111:invokevirtual   #117 <Method void setSource(java.io.InputStream)>
        if(m_useRelativePath)
    //*  55  114:aload_0         
    //*  56  115:getfield        #52  <Field boolean m_useRelativePath>
    //*  57  118:ifeq            164
        {
            try
            {
                m_sourceFile = Utils.convertToRelativePath(original);
    //   58  121:aload_0         
    //   59  122:aload_2         
    //   60  123:invokestatic    #123 <Method File Utils.convertToRelativePath(File)>
    //   61  126:putfield        #50  <Field File m_sourceFile>
                m_File = m_sourceFile.getPath();
    //   62  129:aload_0         
    //   63  130:aload_0         
    //   64  131:getfield        #50  <Field File m_sourceFile>
    //   65  134:invokevirtual   #76  <Method String File.getPath()>
    //   66  137:putfield        #46  <Field String m_File>
            }
    //*  67  140:goto            180
            catch(Exception ex)
    //*  68  143:astore          4
            {
                m_sourceFile = original;
    //   69  145:aload_0         
    //   70  146:aload_2         
    //   71  147:putfield        #50  <Field File m_sourceFile>
                m_File = m_sourceFile.getPath();
    //   72  150:aload_0         
    //   73  151:aload_0         
    //   74  152:getfield        #50  <Field File m_sourceFile>
    //   75  155:invokevirtual   #76  <Method String File.getPath()>
    //   76  158:putfield        #46  <Field String m_File>
            }
        } else
    //*  77  161:goto            180
        {
            m_sourceFile = original;
    //   78  164:aload_0         
    //   79  165:aload_2         
    //   80  166:putfield        #50  <Field File m_sourceFile>
            m_File = m_sourceFile.getPath();
    //   81  169:aload_0         
    //   82  170:aload_0         
    //   83  171:getfield        #50  <Field File m_sourceFile>
    //   84  174:invokevirtual   #76  <Method String File.getPath()>
    //   85  177:putfield        #46  <Field String m_File>
        }
    //   86  180:return          
    }

    public String useRelativePathTipText()
    {
        return "Use relative rather than absolute paths";
    //    0    0:ldc1            #132 <String "Use relative rather than absolute paths">
    //    1    2:areturn         
    }

    public void setUseRelativePath(boolean rp)
    {
        m_useRelativePath = rp;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #52  <Field boolean m_useRelativePath>
    //    3    5:return          
    }

    public boolean getUseRelativePath()
    {
        return m_useRelativePath;
    //    0    0:aload_0         
    //    1    1:getfield        #52  <Field boolean m_useRelativePath>
    //    2    4:ireturn         
    }

    protected static String makeOptionStr(AbstractFileLoader loader)
    {
        StringBuffer result = new StringBuffer("\nUsage:\n");
    //    0    0:new             #140 <Class StringBuffer>
    //    1    3:dup             
    //    2    4:ldc1            #142 <String "\nUsage:\n">
    //    3    6:invokespecial   #143 <Method void StringBuffer(String)>
    //    4    9:astore_1        
        result.append((new StringBuilder("\t")).append(loader.getClass().getName().replaceAll(".*\\.", "")).toString());
    //    5   10:aload_1         
    //    6   11:new             #85  <Class StringBuilder>
    //    7   14:dup             
    //    8   15:ldc1            #145 <String "\t">
    //    9   17:invokespecial   #95  <Method void StringBuilder(String)>
    //   10   20:aload_0         
    //   11   21:invokevirtual   #151 <Method Class Object.getClass()>
    //   12   24:invokevirtual   #154 <Method String Class.getName()>
    //   13   27:ldc1            #156 <String ".*\\.">
    //   14   29:ldc1            #158 <String "">
    //   15   31:invokevirtual   #162 <Method String String.replaceAll(String, String)>
    //   16   34:invokevirtual   #99  <Method StringBuilder StringBuilder.append(String)>
    //   17   37:invokevirtual   #102 <Method String StringBuilder.toString()>
    //   18   40:invokevirtual   #165 <Method StringBuffer StringBuffer.append(String)>
    //   19   43:pop             
        if(loader instanceof OptionHandler)
    //*  20   44:aload_0         
    //*  21   45:instanceof      #167 <Class OptionHandler>
    //*  22   48:ifeq            58
            result.append(" [options]");
    //   23   51:aload_1         
    //   24   52:ldc1            #169 <String " [options]">
    //   25   54:invokevirtual   #165 <Method StringBuffer StringBuffer.append(String)>
    //   26   57:pop             
        result.append(" <");
    //   27   58:aload_1         
    //   28   59:ldc1            #171 <String " <">
    //   29   61:invokevirtual   #165 <Method StringBuffer StringBuffer.append(String)>
    //   30   64:pop             
        String ext[] = loader.getFileExtensions();
    //   31   65:aload_0         
    //   32   66:invokevirtual   #175 <Method String[] getFileExtensions()>
    //   33   69:astore_3        
        for(int i = 0; i < ext.length; i++)
    //*  34   70:iconst_0        
    //*  35   71:istore          4
    //*  36   73:goto            115
        {
            if(i > 0)
    //*  37   76:iload           4
    //*  38   78:ifle            88
                result.append(" | ");
    //   39   81:aload_1         
    //   40   82:ldc1            #177 <String " | ">
    //   41   84:invokevirtual   #165 <Method StringBuffer StringBuffer.append(String)>
    //   42   87:pop             
            result.append((new StringBuilder("file")).append(ext[i]).toString());
    //   43   88:aload_1         
    //   44   89:new             #85  <Class StringBuilder>
    //   45   92:dup             
    //   46   93:ldc1            #178 <String "file">
    //   47   95:invokespecial   #95  <Method void StringBuilder(String)>
    //   48   98:aload_3         
    //   49   99:iload           4
    //   50  101:aaload          
    //   51  102:invokevirtual   #99  <Method StringBuilder StringBuilder.append(String)>
    //   52  105:invokevirtual   #102 <Method String StringBuilder.toString()>
    //   53  108:invokevirtual   #165 <Method StringBuffer StringBuffer.append(String)>
    //   54  111:pop             
        }

    //   55  112:iinc            4  1
    //   56  115:iload           4
    //   57  117:aload_3         
    //   58  118:arraylength     
    //   59  119:icmplt          76
        result.append(">\n");
    //   60  122:aload_1         
    //   61  123:ldc1            #180 <String ">\n">
    //   62  125:invokevirtual   #165 <Method StringBuffer StringBuffer.append(String)>
    //   63  128:pop             
        if(loader instanceof OptionHandler)
    //*  64  129:aload_0         
    //*  65  130:instanceof      #167 <Class OptionHandler>
    //*  66  133:ifeq            235
        {
            result.append("\nOptions:\n\n");
    //   67  136:aload_1         
    //   68  137:ldc1            #182 <String "\nOptions:\n\n">
    //   69  139:invokevirtual   #165 <Method StringBuffer StringBuffer.append(String)>
    //   70  142:pop             
            Option option;
            for(Enumeration enm = ((OptionHandler)loader).listOptions(); enm.hasMoreElements(); result.append((new StringBuilder(String.valueOf(option.description()))).append("\n").toString()))
    //*  71  143:aload_0         
    //*  72  144:checkcast       #167 <Class OptionHandler>
    //*  73  147:invokeinterface #186 <Method Enumeration OptionHandler.listOptions()>
    //*  74  152:astore          4
    //*  75  154:goto            225
            {
                option = (Option)(Option)enm.nextElement();
    //   76  157:aload           4
    //   77  159:invokeinterface #192 <Method Object Enumeration.nextElement()>
    //   78  164:checkcast       #194 <Class Option>
    //   79  167:checkcast       #194 <Class Option>
    //   80  170:astore_2        
                result.append((new StringBuilder(String.valueOf(option.synopsis()))).append("\n").toString());
    //   81  171:aload_1         
    //   82  172:new             #85  <Class StringBuilder>
    //   83  175:dup             
    //   84  176:aload_2         
    //   85  177:invokevirtual   #197 <Method String Option.synopsis()>
    //   86  180:invokestatic    #94  <Method String String.valueOf(Object)>
    //   87  183:invokespecial   #95  <Method void StringBuilder(String)>
    //   88  186:ldc1            #199 <String "\n">
    //   89  188:invokevirtual   #99  <Method StringBuilder StringBuilder.append(String)>
    //   90  191:invokevirtual   #102 <Method String StringBuilder.toString()>
    //   91  194:invokevirtual   #165 <Method StringBuffer StringBuffer.append(String)>
    //   92  197:pop             
            }

    //   93  198:aload_1         
    //   94  199:new             #85  <Class StringBuilder>
    //   95  202:dup             
    //   96  203:aload_2         
    //   97  204:invokevirtual   #202 <Method String Option.description()>
    //   98  207:invokestatic    #94  <Method String String.valueOf(Object)>
    //   99  210:invokespecial   #95  <Method void StringBuilder(String)>
    //  100  213:ldc1            #199 <String "\n">
    //  101  215:invokevirtual   #99  <Method StringBuilder StringBuilder.append(String)>
    //  102  218:invokevirtual   #102 <Method String StringBuilder.toString()>
    //  103  221:invokevirtual   #165 <Method StringBuffer StringBuffer.append(String)>
    //  104  224:pop             
    //  105  225:aload           4
    //  106  227:invokeinterface #205 <Method boolean Enumeration.hasMoreElements()>
    //  107  232:ifne            157
        }
        return result.toString();
    //  108  235:aload_1         
    //  109  236:invokevirtual   #206 <Method String StringBuffer.toString()>
    //  110  239:areturn         
    }

    public static void runFileLoader(AbstractFileLoader loader, String options[])
    {
        try
        {
            String tmpOptions[] = (String[])options.clone();
    //    0    0:aload_1         
    //    1    1:invokevirtual   #223 <Method Object _5B_Ljava.lang.String_3B_.clone()>
    //    2    4:checkcast       #220 <Class String[]>
    //    3    7:astore_2        
            if(Utils.getFlag('h', tmpOptions))
    //*   4    8:bipush          104
    //*   5   10:aload_2         
    //*   6   11:invokestatic    #227 <Method boolean Utils.getFlag(char, String[])>
    //*   7   14:ifeq            47
            {
                System.err.println((new StringBuilder("\nHelp requested\n")).append(makeOptionStr(loader)).toString());
    //    8   17:getstatic       #231 <Field PrintStream System.err>
    //    9   20:new             #85  <Class StringBuilder>
    //   10   23:dup             
    //   11   24:ldc1            #233 <String "\nHelp requested\n">
    //   12   26:invokespecial   #95  <Method void StringBuilder(String)>
    //   13   29:aload_0         
    //   14   30:invokestatic    #235 <Method String makeOptionStr(AbstractFileLoader)>
    //   15   33:invokevirtual   #99  <Method StringBuilder StringBuilder.append(String)>
    //   16   36:invokevirtual   #102 <Method String StringBuilder.toString()>
    //   17   39:invokevirtual   #240 <Method void PrintStream.println(String)>
                return;
    //   18   42:return          
            }
        }
    //*  19   43:goto            47
        catch(Exception exception) { }
    //   20   46:astore_2        
        if(options.length > 0)
    //*  21   47:aload_1         
    //*  22   48:arraylength     
    //*  23   49:ifle            202
        {
            if(loader instanceof OptionHandler)
    //*  24   52:aload_0         
    //*  25   53:instanceof      #167 <Class OptionHandler>
    //*  26   56:ifeq            124
                try
                {
                    ((OptionHandler)loader).setOptions(options);
    //   27   59:aload_0         
    //   28   60:checkcast       #167 <Class OptionHandler>
    //   29   63:aload_1         
    //   30   64:invokeinterface #244 <Method void OptionHandler.setOptions(String[])>
                    for(int i = 0; i < options.length; i++)
    //*  31   69:iconst_0        
    //*  32   70:istore_2        
    //*  33   71:goto            100
                    {
                        if(options[i].length() <= 0)
                            continue;
    //   34   74:aload_1         
    //   35   75:iload_2         
    //   36   76:aaload          
    //   37   77:invokevirtual   #248 <Method int String.length()>
    //   38   80:ifle            97
                        options = (new String[] {
                            options[i]
                        });
    //   39   83:iconst_1        
    //   40   84:anewarray       String[]
    //   41   87:dup             
    //   42   88:iconst_0        
    //   43   89:aload_1         
    //   44   90:iload_2         
    //   45   91:aaload          
    //   46   92:aastore         
    //   47   93:astore_1        
                        break;
    //   48   94:goto            124
                    }

    //   49   97:iinc            2  1
    //   50  100:iload_2         
    //   51  101:aload_1         
    //   52  102:arraylength     
    //   53  103:icmplt          74
                }
    //*  54  106:goto            124
                catch(Exception ex)
    //*  55  109:astore_2        
                {
                    System.err.println(makeOptionStr(loader));
    //   56  110:getstatic       #231 <Field PrintStream System.err>
    //   57  113:aload_0         
    //   58  114:invokestatic    #235 <Method String makeOptionStr(AbstractFileLoader)>
    //   59  117:invokevirtual   #240 <Method void PrintStream.println(String)>
                    System.exit(1);
    //   60  120:iconst_1        
    //   61  121:invokestatic    #251 <Method void System.exit(int)>
                }
            try
            {
                loader.setFile(new File(options[0]));
    //   62  124:aload_0         
    //   63  125:new             #29  <Class File>
    //   64  128:dup             
    //   65  129:aload_1         
    //   66  130:iconst_0        
    //   67  131:aaload          
    //   68  132:invokespecial   #40  <Method void File(String)>
    //   69  135:invokevirtual   #253 <Method void setFile(File)>
                if(loader instanceof IncrementalConverter)
    //*  70  138:aload_0         
    //*  71  139:instanceof      #255 <Class IncrementalConverter>
    //*  72  142:ifeq            181
                {
                    Instances structure = loader.getStructure();
    //   73  145:aload_0         
    //   74  146:invokevirtual   #259 <Method Instances getStructure()>
    //   75  149:astore_2        
                    System.out.println(structure);
    //   76  150:getstatic       #262 <Field PrintStream System.out>
    //   77  153:aload_2         
    //   78  154:invokevirtual   #265 <Method void PrintStream.println(Object)>
                    rm.core.Instance temp;
                    do
                    {
                        temp = loader.getNextInstance(structure);
    //   79  157:aload_0         
    //   80  158:aload_2         
    //   81  159:invokevirtual   #269 <Method rm.core.Instance getNextInstance(Instances)>
    //   82  162:astore_3        
                        if(temp != null)
    //*  83  163:aload_3         
    //*  84  164:ifnull          174
                            System.out.println(temp);
    //   85  167:getstatic       #262 <Field PrintStream System.out>
    //   86  170:aload_3         
    //   87  171:invokevirtual   #265 <Method void PrintStream.println(Object)>
                    } while(temp != null);
    //   88  174:aload_3         
    //   89  175:ifnonnull       157
                } else
    //*  90  178:goto            212
                {
                    System.out.println(loader.getDataSet());
    //   91  181:getstatic       #262 <Field PrintStream System.out>
    //   92  184:aload_0         
    //   93  185:invokevirtual   #272 <Method Instances getDataSet()>
    //   94  188:invokevirtual   #265 <Method void PrintStream.println(Object)>
                }
            }
    //*  95  191:goto            212
            catch(Exception ex)
    //*  96  194:astore_2        
            {
                ex.printStackTrace();
    //   97  195:aload_2         
    //   98  196:invokevirtual   #275 <Method void Exception.printStackTrace()>
            }
        } else
    //*  99  199:goto            212
        {
            System.err.println(makeOptionStr(loader));
    //  100  202:getstatic       #231 <Field PrintStream System.err>
    //  101  205:aload_0         
    //  102  206:invokestatic    #235 <Method String makeOptionStr(AbstractFileLoader)>
    //  103  209:invokevirtual   #240 <Method void PrintStream.println(String)>
        }
    //  104  212:return          
    }

    protected String m_File;
    protected Instances m_structure;
    protected File m_sourceFile;
    public static String FILE_EXTENSION_COMPRESSED = ".gz";
    protected boolean m_useRelativePath;

    static 
    {
    //    0    0:ldc1            #20  <String ".gz">
    //    1    2:putstatic       #22  <Field String FILE_EXTENSION_COMPRESSED>
    //*   2    5:return          
    }
}
