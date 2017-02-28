// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   ConverterUtils.java

package rm.core.converters;

import java.io.*;
import java.net.URL;
import java.util.*;
import rm.core.*;
import rm.gui.GenericObjectEditor;
import rm.gui.GenericPropertiesCreator;

// Referenced classes of package rm.core.converters:
//            ArffLoader, SerializedInstancesLoader, ArffSaver, Loader, 
//            FileSourcedConverter, URLSourcedLoader, Saver, AbstractFileLoader, 
//            AbstractFileSaver, IncrementalConverter

public class ConverterUtils
    implements Serializable
{
    public static class DataSource
        implements Serializable
    {

        protected void initBatchBuffer()
        {
            try
            {
                if(!isIncremental())
        //*   0    0:aload_0         
        //*   1    1:invokevirtual   #132 <Method boolean isIncremental()>
        //*   2    4:ifne            23
                    m_BatchBuffer = m_Loader.getDataSet();
        //    3    7:aload_0         
        //    4    8:aload_0         
        //    5    9:getfield        #69  <Field Loader m_Loader>
        //    6   12:invokeinterface #136 <Method Instances Loader.getDataSet()>
        //    7   17:putfield        #112 <Field Instances m_BatchBuffer>
                else
        //*   8   20:goto            36
                    m_BatchBuffer = null;
        //    9   23:aload_0         
        //   10   24:aconst_null     
        //   11   25:putfield        #112 <Field Instances m_BatchBuffer>
            }
        //*  12   28:goto            36
            catch(Exception e)
        //*  13   31:astore_1        
            {
                e.printStackTrace();
        //   14   32:aload_1         
        //   15   33:invokevirtual   #139 <Method void Exception.printStackTrace()>
            }
        //   16   36:return          
        }

        public static boolean isArff(String location)
        {
            return location.toLowerCase().endsWith(ArffLoader.FILE_EXTENSION.toLowerCase()) || location.toLowerCase().endsWith(ArffLoader.FILE_EXTENSION_COMPRESSED.toLowerCase());
        //    0    0:aload_0         
        //    1    1:invokevirtual   #142 <Method String String.toLowerCase()>
        //    2    4:getstatic       #145 <Field String ArffLoader.FILE_EXTENSION>
        //    3    7:invokevirtual   #142 <Method String String.toLowerCase()>
        //    4   10:invokevirtual   #148 <Method boolean String.endsWith(String)>
        //    5   13:ifne            32
        //    6   16:aload_0         
        //    7   17:invokevirtual   #142 <Method String String.toLowerCase()>
        //    8   20:getstatic       #151 <Field String ArffLoader.FILE_EXTENSION_COMPRESSED>
        //    9   23:invokevirtual   #142 <Method String String.toLowerCase()>
        //   10   26:invokevirtual   #148 <Method boolean String.endsWith(String)>
        //   11   29:ifeq            34
        //   12   32:iconst_1        
        //   13   33:ireturn         
        //   14   34:iconst_0        
        //   15   35:ireturn         
        }

        public boolean isIncremental()
        {
            return m_Incremental;
        //    0    0:aload_0         
        //    1    1:getfield        #100 <Field boolean m_Incremental>
        //    2    4:ireturn         
        }

        public Loader getLoader()
        {
            return m_Loader;
        //    0    0:aload_0         
        //    1    1:getfield        #69  <Field Loader m_Loader>
        //    2    4:areturn         
        }

        public Instances getDataSet()
            throws Exception
        {
            Instances result = null;
        //    0    0:aconst_null     
        //    1    1:astore_1        
            reset();
        //    2    2:aload_0         
        //    3    3:invokevirtual   #103 <Method void reset()>
            try
            {
                if(m_BatchBuffer == null)
        //*   4    6:aload_0         
        //*   5    7:getfield        #112 <Field Instances m_BatchBuffer>
        //*   6   10:ifnonnull       26
                    result = m_Loader.getDataSet();
        //    7   13:aload_0         
        //    8   14:getfield        #69  <Field Loader m_Loader>
        //    9   17:invokeinterface #136 <Method Instances Loader.getDataSet()>
        //   10   22:astore_1        
                else
        //*  11   23:goto            41
                    result = m_BatchBuffer;
        //   12   26:aload_0         
        //   13   27:getfield        #112 <Field Instances m_BatchBuffer>
        //   14   30:astore_1        
            }
        //*  15   31:goto            41
            catch(Exception e)
        //*  16   34:astore_2        
            {
                e.printStackTrace();
        //   17   35:aload_2         
        //   18   36:invokevirtual   #139 <Method void Exception.printStackTrace()>
                result = null;
        //   19   39:aconst_null     
        //   20   40:astore_1        
            }
            return result;
        //   21   41:aload_1         
        //   22   42:areturn         
        }

        public Instances getDataSet(int classIndex)
            throws Exception
        {
            Instances result = getDataSet();
        //    0    0:aload_0         
        //    1    1:invokevirtual   #156 <Method Instances getDataSet()>
        //    2    4:astore_2        
            if(result != null)
        //*   3    5:aload_2         
        //*   4    6:ifnull          14
                result.setClassIndex(classIndex);
        //    5    9:aload_2         
        //    6   10:iload_1         
        //    7   11:invokevirtual   #162 <Method void Instances.setClassIndex(int)>
            return result;
        //    8   14:aload_2         
        //    9   15:areturn         
        }

        public void reset()
            throws Exception
        {
            if(m_File != null)
        //*   0    0:aload_0         
        //*   1    1:getfield        #61  <Field File m_File>
        //*   2    4:ifnull          24
                ((AbstractFileLoader)m_Loader).setFile(m_File);
        //    3    7:aload_0         
        //    4    8:getfield        #69  <Field Loader m_Loader>
        //    5   11:checkcast       #165 <Class AbstractFileLoader>
        //    6   14:aload_0         
        //    7   15:getfield        #61  <Field File m_File>
        //    8   18:invokevirtual   #169 <Method void AbstractFileLoader.setFile(File)>
            else
        //*   9   21:goto            69
            if(m_URL != null)
        //*  10   24:aload_0         
        //*  11   25:getfield        #56  <Field URL m_URL>
        //*  12   28:ifnull          53
                ((URLSourcedLoader)m_Loader).setURL(m_URL.toString());
        //   13   31:aload_0         
        //   14   32:getfield        #69  <Field Loader m_Loader>
        //   15   35:checkcast       #171 <Class URLSourcedLoader>
        //   16   38:aload_0         
        //   17   39:getfield        #56  <Field URL m_URL>
        //   18   42:invokevirtual   #172 <Method String URL.toString()>
        //   19   45:invokeinterface #175 <Method void URLSourcedLoader.setURL(String)>
            else
        //*  20   50:goto            69
            if(m_Loader != null)
        //*  21   53:aload_0         
        //*  22   54:getfield        #69  <Field Loader m_Loader>
        //*  23   57:ifnull          69
                m_Loader.reset();
        //   24   60:aload_0         
        //   25   61:getfield        #69  <Field Loader m_Loader>
        //   26   64:invokeinterface #176 <Method void Loader.reset()>
            m_BatchCounter = 0;
        //   27   69:aload_0         
        //   28   70:iconst_0        
        //   29   71:putfield        #178 <Field int m_BatchCounter>
            m_IncrementalBuffer = null;
        //   30   74:aload_0         
        //   31   75:aconst_null     
        //   32   76:putfield        #180 <Field Instance m_IncrementalBuffer>
            if(m_Loader != null)
        //*  33   79:aload_0         
        //*  34   80:getfield        #69  <Field Loader m_Loader>
        //*  35   83:ifnull          114
                if(!isIncremental())
        //*  36   86:aload_0         
        //*  37   87:invokevirtual   #132 <Method boolean isIncremental()>
        //*  38   90:ifne            109
                    m_BatchBuffer = m_Loader.getDataSet();
        //   39   93:aload_0         
        //   40   94:aload_0         
        //   41   95:getfield        #69  <Field Loader m_Loader>
        //   42   98:invokeinterface #136 <Method Instances Loader.getDataSet()>
        //   43  103:putfield        #112 <Field Instances m_BatchBuffer>
                else
        //*  44  106:goto            114
                    m_BatchBuffer = null;
        //   45  109:aload_0         
        //   46  110:aconst_null     
        //   47  111:putfield        #112 <Field Instances m_BatchBuffer>
        //   48  114:return          
        }

        public Instances getStructure()
            throws Exception
        {
            if(m_BatchBuffer == null)
        //*   0    0:aload_0         
        //*   1    1:getfield        #112 <Field Instances m_BatchBuffer>
        //*   2    4:ifnonnull       17
                return m_Loader.getStructure();
        //    3    7:aload_0         
        //    4    8:getfield        #69  <Field Loader m_Loader>
        //    5   11:invokeinterface #183 <Method Instances Loader.getStructure()>
        //    6   16:areturn         
            else
                return new Instances(m_BatchBuffer, 0);
        //    7   17:new             #158 <Class Instances>
        //    8   20:dup             
        //    9   21:aload_0         
        //   10   22:getfield        #112 <Field Instances m_BatchBuffer>
        //   11   25:iconst_0        
        //   12   26:invokespecial   #186 <Method void Instances(Instances, int)>
        //   13   29:areturn         
        }

        public Instances getStructure(int classIndex)
            throws Exception
        {
            Instances result = getStructure();
        //    0    0:aload_0         
        //    1    1:invokevirtual   #187 <Method Instances getStructure()>
        //    2    4:astore_2        
            if(result != null)
        //*   3    5:aload_2         
        //*   4    6:ifnull          14
                result.setClassIndex(classIndex);
        //    5    9:aload_2         
        //    6   10:iload_1         
        //    7   11:invokevirtual   #162 <Method void Instances.setClassIndex(int)>
            return result;
        //    8   14:aload_2         
        //    9   15:areturn         
        }

        public boolean hasMoreElements(Instances structure)
        {
            boolean result = false;
        //    0    0:iconst_0        
        //    1    1:istore_2        
            if(isIncremental())
        //*   2    2:aload_0         
        //*   3    3:invokevirtual   #132 <Method boolean isIncremental()>
        //*   4    6:ifeq            61
            {
                if(m_IncrementalBuffer != null)
        //*   5    9:aload_0         
        //*   6   10:getfield        #180 <Field Instance m_IncrementalBuffer>
        //*   7   13:ifnull          21
                    result = true;
        //    8   16:iconst_1        
        //    9   17:istore_2        
                else
        //*  10   18:goto            81
                    try
                    {
                        m_IncrementalBuffer = m_Loader.getNextInstance(structure);
        //   11   21:aload_0         
        //   12   22:aload_0         
        //   13   23:getfield        #69  <Field Loader m_Loader>
        //   14   26:aload_1         
        //   15   27:invokeinterface #193 <Method Instance Loader.getNextInstance(Instances)>
        //   16   32:putfield        #180 <Field Instance m_IncrementalBuffer>
                        result = m_IncrementalBuffer != null;
        //   17   35:aload_0         
        //   18   36:getfield        #180 <Field Instance m_IncrementalBuffer>
        //   19   39:ifnull          46
        //   20   42:iconst_1        
        //   21   43:goto            47
        //   22   46:iconst_0        
        //   23   47:istore_2        
                    }
        //*  24   48:goto            81
                    catch(Exception e)
        //*  25   51:astore_3        
                    {
                        e.printStackTrace();
        //   26   52:aload_3         
        //   27   53:invokevirtual   #139 <Method void Exception.printStackTrace()>
                        result = false;
        //   28   56:iconst_0        
        //   29   57:istore_2        
                    }
            } else
        //*  30   58:goto            81
            {
                result = m_BatchCounter < m_BatchBuffer.numInstances();
        //   31   61:aload_0         
        //   32   62:getfield        #178 <Field int m_BatchCounter>
        //   33   65:aload_0         
        //   34   66:getfield        #112 <Field Instances m_BatchBuffer>
        //   35   69:invokevirtual   #197 <Method int Instances.numInstances()>
        //   36   72:icmpge          79
        //   37   75:iconst_1        
        //   38   76:goto            80
        //   39   79:iconst_0        
        //   40   80:istore_2        
            }
            return result;
        //   41   81:iload_2         
        //   42   82:ireturn         
        }

        public Instance nextElement(Instances dataset)
        {
            Instance result = null;
        //    0    0:aconst_null     
        //    1    1:astore_2        
            if(isIncremental())
        //*   2    2:aload_0         
        //*   3    3:invokevirtual   #132 <Method boolean isIncremental()>
        //*   4    6:ifeq            53
            {
                if(m_IncrementalBuffer != null)
        //*   5    9:aload_0         
        //*   6   10:getfield        #180 <Field Instance m_IncrementalBuffer>
        //*   7   13:ifnull          29
                {
                    result = m_IncrementalBuffer;
        //    8   16:aload_0         
        //    9   17:getfield        #180 <Field Instance m_IncrementalBuffer>
        //   10   20:astore_2        
                    m_IncrementalBuffer = null;
        //   11   21:aload_0         
        //   12   22:aconst_null     
        //   13   23:putfield        #180 <Field Instance m_IncrementalBuffer>
                } else
        //*  14   26:goto            89
                {
                    try
                    {
                        result = m_Loader.getNextInstance(dataset);
        //   15   29:aload_0         
        //   16   30:getfield        #69  <Field Loader m_Loader>
        //   17   33:aload_1         
        //   18   34:invokeinterface #193 <Method Instance Loader.getNextInstance(Instances)>
        //   19   39:astore_2        
                    }
        //*  20   40:goto            89
                    catch(Exception e)
        //*  21   43:astore_3        
                    {
                        e.printStackTrace();
        //   22   44:aload_3         
        //   23   45:invokevirtual   #139 <Method void Exception.printStackTrace()>
                        result = null;
        //   24   48:aconst_null     
        //   25   49:astore_2        
                    }
                }
            } else
        //*  26   50:goto            89
            if(m_BatchCounter < m_BatchBuffer.numInstances())
        //*  27   53:aload_0         
        //*  28   54:getfield        #178 <Field int m_BatchCounter>
        //*  29   57:aload_0         
        //*  30   58:getfield        #112 <Field Instances m_BatchBuffer>
        //*  31   61:invokevirtual   #197 <Method int Instances.numInstances()>
        //*  32   64:icmpge          89
            {
                result = m_BatchBuffer.instance(m_BatchCounter);
        //   33   67:aload_0         
        //   34   68:getfield        #112 <Field Instances m_BatchBuffer>
        //   35   71:aload_0         
        //   36   72:getfield        #178 <Field int m_BatchCounter>
        //   37   75:invokevirtual   #203 <Method Instance Instances.instance(int)>
        //   38   78:astore_2        
                m_BatchCounter++;
        //   39   79:aload_0         
        //   40   80:dup             
        //   41   81:getfield        #178 <Field int m_BatchCounter>
        //   42   84:iconst_1        
        //   43   85:iadd            
        //   44   86:putfield        #178 <Field int m_BatchCounter>
            }
            if(result != null)
        //*  45   89:aload_2         
        //*  46   90:ifnull          98
                result.setDataset(dataset);
        //   47   93:aload_2         
        //   48   94:aload_1         
        //   49   95:invokevirtual   #208 <Method void Instance.setDataset(Instances)>
            return result;
        //   50   98:aload_2         
        //   51   99:areturn         
        }

        public static Instances read(String location)
            throws Exception
        {
            DataSource source = new DataSource(location);
        //    0    0:new             #2   <Class ConverterUtils$DataSource>
        //    1    3:dup             
        //    2    4:aload_0         
        //    3    5:invokespecial   #212 <Method void ConverterUtils$DataSource(String)>
        //    4    8:astore_1        
            Instances result = source.getDataSet();
        //    5    9:aload_1         
        //    6   10:invokevirtual   #156 <Method Instances getDataSet()>
        //    7   13:astore_2        
            return result;
        //    8   14:aload_2         
        //    9   15:areturn         
        }

        public static Instances read(InputStream stream)
            throws Exception
        {
            DataSource source = new DataSource(stream);
        //    0    0:new             #2   <Class ConverterUtils$DataSource>
        //    1    3:dup             
        //    2    4:aload_0         
        //    3    5:invokespecial   #216 <Method void ConverterUtils$DataSource(InputStream)>
        //    4    8:astore_1        
            Instances result = source.getDataSet();
        //    5    9:aload_1         
        //    6   10:invokevirtual   #156 <Method Instances getDataSet()>
        //    7   13:astore_2        
            return result;
        //    8   14:aload_2         
        //    9   15:areturn         
        }

        public static Instances read(Loader loader)
            throws Exception
        {
            DataSource source = new DataSource(loader);
        //    0    0:new             #2   <Class ConverterUtils$DataSource>
        //    1    3:dup             
        //    2    4:aload_0         
        //    3    5:invokespecial   #219 <Method void ConverterUtils$DataSource(Loader)>
        //    4    8:astore_1        
            Instances result = source.getDataSet();
        //    5    9:aload_1         
        //    6   10:invokevirtual   #156 <Method Instances getDataSet()>
        //    7   13:astore_2        
            return result;
        //    8   14:aload_2         
        //    9   15:areturn         
        }

        public static void main(String args[])
            throws Exception
        {
            if(args.length != 1)
        //*   0    0:aload_0         
        //*   1    1:arraylength     
        //*   2    2:iconst_1        
        //*   3    3:icmpeq          41
            {
                System.out.println((new StringBuilder("\nUsage: ")).append(rm/core/converters/ConverterUtils$DataSource.getName()).append(" <file>\n").toString());
        //    4    6:getstatic       #227 <Field PrintStream System.out>
        //    5    9:new             #82  <Class StringBuilder>
        //    6   12:dup             
        //    7   13:ldc1            #229 <String "\nUsage: ">
        //    8   15:invokespecial   #85  <Method void StringBuilder(String)>
        //    9   18:ldc1            #2   <Class ConverterUtils$DataSource>
        //   10   20:invokevirtual   #234 <Method String Class.getName()>
        //   11   23:invokevirtual   #89  <Method StringBuilder StringBuilder.append(String)>
        //   12   26:ldc1            #236 <String " <file>\n">
        //   13   28:invokevirtual   #89  <Method StringBuilder StringBuilder.append(String)>
        //   14   31:invokevirtual   #95  <Method String StringBuilder.toString()>
        //   15   34:invokevirtual   #241 <Method void PrintStream.println(String)>
                System.exit(1);
        //   16   37:iconst_1        
        //   17   38:invokestatic    #244 <Method void System.exit(int)>
            }
            DataSource loader = new DataSource(args[0]);
        //   18   41:new             #2   <Class ConverterUtils$DataSource>
        //   19   44:dup             
        //   20   45:aload_0         
        //   21   46:iconst_0        
        //   22   47:aaload          
        //   23   48:invokespecial   #212 <Method void ConverterUtils$DataSource(String)>
        //   24   51:astore_1        
            System.out.println((new StringBuilder("Incremental? ")).append(loader.isIncremental()).toString());
        //   25   52:getstatic       #227 <Field PrintStream System.out>
        //   26   55:new             #82  <Class StringBuilder>
        //   27   58:dup             
        //   28   59:ldc1            #246 <String "Incremental? ">
        //   29   61:invokespecial   #85  <Method void StringBuilder(String)>
        //   30   64:aload_1         
        //   31   65:invokevirtual   #132 <Method boolean isIncremental()>
        //   32   68:invokevirtual   #249 <Method StringBuilder StringBuilder.append(boolean)>
        //   33   71:invokevirtual   #95  <Method String StringBuilder.toString()>
        //   34   74:invokevirtual   #241 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Loader: ")).append(loader.getLoader().getClass().getName()).toString());
        //   35   77:getstatic       #227 <Field PrintStream System.out>
        //   36   80:new             #82  <Class StringBuilder>
        //   37   83:dup             
        //   38   84:ldc1            #251 <String "Loader: ">
        //   39   86:invokespecial   #85  <Method void StringBuilder(String)>
        //   40   89:aload_1         
        //   41   90:invokevirtual   #253 <Method Loader getLoader()>
        //   42   93:invokevirtual   #257 <Method Class Object.getClass()>
        //   43   96:invokevirtual   #234 <Method String Class.getName()>
        //   44   99:invokevirtual   #89  <Method StringBuilder StringBuilder.append(String)>
        //   45  102:invokevirtual   #95  <Method String StringBuilder.toString()>
        //   46  105:invokevirtual   #241 <Method void PrintStream.println(String)>
            System.out.println("Data:\n");
        //   47  108:getstatic       #227 <Field PrintStream System.out>
        //   48  111:ldc2            #259 <String "Data:\n">
        //   49  114:invokevirtual   #241 <Method void PrintStream.println(String)>
            Instances structure = loader.getStructure();
        //   50  117:aload_1         
        //   51  118:invokevirtual   #187 <Method Instances getStructure()>
        //   52  121:astore_2        
            System.out.println(structure);
        //   53  122:getstatic       #227 <Field PrintStream System.out>
        //   54  125:aload_2         
        //   55  126:invokevirtual   #262 <Method void PrintStream.println(Object)>
        //*  56  129:goto            143
            for(; loader.hasMoreElements(structure); System.out.println(loader.nextElement(structure)));
        //   57  132:getstatic       #227 <Field PrintStream System.out>
        //   58  135:aload_1         
        //   59  136:aload_2         
        //   60  137:invokevirtual   #264 <Method Instance nextElement(Instances)>
        //   61  140:invokevirtual   #262 <Method void PrintStream.println(Object)>
        //   62  143:aload_1         
        //   63  144:aload_2         
        //   64  145:invokevirtual   #266 <Method boolean hasMoreElements(Instances)>
        //   65  148:ifne            132
            Instances inst = loader.getDataSet();
        //   66  151:aload_1         
        //   67  152:invokevirtual   #156 <Method Instances getDataSet()>
        //   68  155:astore_3        
            loader = new DataSource(inst);
        //   69  156:new             #2   <Class ConverterUtils$DataSource>
        //   70  159:dup             
        //   71  160:aload_3         
        //   72  161:invokespecial   #268 <Method void ConverterUtils$DataSource(Instances)>
        //   73  164:astore_1        
            System.out.println("\n\nProxy-Data:\n");
        //   74  165:getstatic       #227 <Field PrintStream System.out>
        //   75  168:ldc2            #270 <String "\n\nProxy-Data:\n">
        //   76  171:invokevirtual   #241 <Method void PrintStream.println(String)>
            System.out.println(loader.getStructure());
        //   77  174:getstatic       #227 <Field PrintStream System.out>
        //   78  177:aload_1         
        //   79  178:invokevirtual   #187 <Method Instances getStructure()>
        //   80  181:invokevirtual   #262 <Method void PrintStream.println(Object)>
        //*  81  184:goto            198
            for(; loader.hasMoreElements(structure); System.out.println(loader.nextElement(inst)));
        //   82  187:getstatic       #227 <Field PrintStream System.out>
        //   83  190:aload_1         
        //   84  191:aload_3         
        //   85  192:invokevirtual   #264 <Method Instance nextElement(Instances)>
        //   86  195:invokevirtual   #262 <Method void PrintStream.println(Object)>
        //   87  198:aload_1         
        //   88  199:aload_2         
        //   89  200:invokevirtual   #266 <Method boolean hasMoreElements(Instances)>
        //   90  203:ifne            187
        //   91  206:return          
        }

        private static final long serialVersionUID = 0xf77dc06dead47bacL;
        protected File m_File;
        protected URL m_URL;
        protected Loader m_Loader;
        protected boolean m_Incremental;
        protected int m_BatchCounter;
        protected Instance m_IncrementalBuffer;
        protected Instances m_BatchBuffer;
        static Class class$0;

        public DataSource(String location)
            throws Exception
        {
        //    0    0:aload_0         
        //    1    1:invokespecial   #36  <Method void Object()>
            if(location.startsWith("http://") || location.startsWith("https://") || location.startsWith("ftp://") || location.startsWith("file://"))
        //*   2    4:aload_1         
        //*   3    5:ldc1            #38  <String "http://">
        //*   4    7:invokevirtual   #44  <Method boolean String.startsWith(String)>
        //*   5   10:ifne            40
        //*   6   13:aload_1         
        //*   7   14:ldc1            #46  <String "https://">
        //*   8   16:invokevirtual   #44  <Method boolean String.startsWith(String)>
        //*   9   19:ifne            40
        //*  10   22:aload_1         
        //*  11   23:ldc1            #48  <String "ftp://">
        //*  12   25:invokevirtual   #44  <Method boolean String.startsWith(String)>
        //*  13   28:ifne            40
        //*  14   31:aload_1         
        //*  15   32:ldc1            #50  <String "file://">
        //*  16   34:invokevirtual   #44  <Method boolean String.startsWith(String)>
        //*  17   37:ifeq            55
                m_URL = new URL(location);
        //   18   40:aload_0         
        //   19   41:new             #52  <Class URL>
        //   20   44:dup             
        //   21   45:aload_1         
        //   22   46:invokespecial   #54  <Method void URL(String)>
        //   23   49:putfield        #56  <Field URL m_URL>
            else
        //*  24   52:goto            67
                m_File = new File(location);
        //   25   55:aload_0         
        //   26   56:new             #58  <Class File>
        //   27   59:dup             
        //   28   60:aload_1         
        //   29   61:invokespecial   #59  <Method void File(String)>
        //   30   64:putfield        #61  <Field File m_File>
            if(isArff(location))
        //*  31   67:aload_1         
        //*  32   68:invokestatic    #64  <Method boolean isArff(String)>
        //*  33   71:ifeq            88
            {
                m_Loader = new ArffLoader();
        //   34   74:aload_0         
        //   35   75:new             #66  <Class ArffLoader>
        //   36   78:dup             
        //   37   79:invokespecial   #67  <Method void ArffLoader()>
        //   38   82:putfield        #69  <Field Loader m_Loader>
            } else
        //*  39   85:goto            150
            {
                if(m_File != null)
        //*  40   88:aload_0         
        //*  41   89:getfield        #61  <Field File m_File>
        //*  42   92:ifnull          106
                    m_Loader = ConverterUtils.getLoaderForFile(location);
        //   43   95:aload_0         
        //   44   96:aload_1         
        //   45   97:invokestatic    #75  <Method AbstractFileLoader ConverterUtils.getLoaderForFile(String)>
        //   46  100:putfield        #69  <Field Loader m_Loader>
                else
        //*  47  103:goto            114
                    m_Loader = ConverterUtils.getURLLoaderForFile(location);
        //   48  106:aload_0         
        //   49  107:aload_1         
        //   50  108:invokestatic    #78  <Method AbstractFileLoader ConverterUtils.getURLLoaderForFile(String)>
        //   51  111:putfield        #69  <Field Loader m_Loader>
                if(m_Loader == null)
        //*  52  114:aload_0         
        //*  53  115:getfield        #69  <Field Loader m_Loader>
        //*  54  118:ifnonnull       150
                    throw new IllegalArgumentException((new StringBuilder("No suitable converter found for '")).append(location).append("'!").toString());
        //   55  121:new             #80  <Class IllegalArgumentException>
        //   56  124:dup             
        //   57  125:new             #82  <Class StringBuilder>
        //   58  128:dup             
        //   59  129:ldc1            #84  <String "No suitable converter found for '">
        //   60  131:invokespecial   #85  <Method void StringBuilder(String)>
        //   61  134:aload_1         
        //   62  135:invokevirtual   #89  <Method StringBuilder StringBuilder.append(String)>
        //   63  138:ldc1            #91  <String "'!">
        //   64  140:invokevirtual   #89  <Method StringBuilder StringBuilder.append(String)>
        //   65  143:invokevirtual   #95  <Method String StringBuilder.toString()>
        //   66  146:invokespecial   #96  <Method void IllegalArgumentException(String)>
        //   67  149:athrow          
            }
            m_Incremental = m_Loader instanceof IncrementalConverter;
        //   68  150:aload_0         
        //   69  151:aload_0         
        //   70  152:getfield        #69  <Field Loader m_Loader>
        //   71  155:instanceof      #98  <Class IncrementalConverter>
        //   72  158:putfield        #100 <Field boolean m_Incremental>
            reset();
        //   73  161:aload_0         
        //   74  162:invokevirtual   #103 <Method void reset()>
        //   75  165:return          
        }

        public DataSource(Instances inst)
        {
        //    0    0:aload_0         
        //    1    1:invokespecial   #36  <Method void Object()>
            m_BatchBuffer = inst;
        //    2    4:aload_0         
        //    3    5:aload_1         
        //    4    6:putfield        #112 <Field Instances m_BatchBuffer>
            m_Loader = null;
        //    5    9:aload_0         
        //    6   10:aconst_null     
        //    7   11:putfield        #69  <Field Loader m_Loader>
            m_File = null;
        //    8   14:aload_0         
        //    9   15:aconst_null     
        //   10   16:putfield        #61  <Field File m_File>
            m_URL = null;
        //   11   19:aload_0         
        //   12   20:aconst_null     
        //   13   21:putfield        #56  <Field URL m_URL>
            m_Incremental = false;
        //   14   24:aload_0         
        //   15   25:iconst_0        
        //   16   26:putfield        #100 <Field boolean m_Incremental>
        //   17   29:return          
        }

        public DataSource(Loader loader)
        {
        //    0    0:aload_0         
        //    1    1:invokespecial   #36  <Method void Object()>
            m_BatchBuffer = null;
        //    2    4:aload_0         
        //    3    5:aconst_null     
        //    4    6:putfield        #112 <Field Instances m_BatchBuffer>
            m_Loader = loader;
        //    5    9:aload_0         
        //    6   10:aload_1         
        //    7   11:putfield        #69  <Field Loader m_Loader>
            m_File = null;
        //    8   14:aload_0         
        //    9   15:aconst_null     
        //   10   16:putfield        #61  <Field File m_File>
            m_URL = null;
        //   11   19:aload_0         
        //   12   20:aconst_null     
        //   13   21:putfield        #56  <Field URL m_URL>
            m_Incremental = m_Loader instanceof IncrementalConverter;
        //   14   24:aload_0         
        //   15   25:aload_0         
        //   16   26:getfield        #69  <Field Loader m_Loader>
        //   17   29:instanceof      #98  <Class IncrementalConverter>
        //   18   32:putfield        #100 <Field boolean m_Incremental>
            initBatchBuffer();
        //   19   35:aload_0         
        //   20   36:invokevirtual   #117 <Method void initBatchBuffer()>
        //   21   39:return          
        }

        public DataSource(InputStream stream)
        {
        //    0    0:aload_0         
        //    1    1:invokespecial   #36  <Method void Object()>
            m_BatchBuffer = null;
        //    2    4:aload_0         
        //    3    5:aconst_null     
        //    4    6:putfield        #112 <Field Instances m_BatchBuffer>
            m_Loader = new ArffLoader();
        //    5    9:aload_0         
        //    6   10:new             #66  <Class ArffLoader>
        //    7   13:dup             
        //    8   14:invokespecial   #67  <Method void ArffLoader()>
        //    9   17:putfield        #69  <Field Loader m_Loader>
            try
            {
                m_Loader.setSource(stream);
        //   10   20:aload_0         
        //   11   21:getfield        #69  <Field Loader m_Loader>
        //   12   24:aload_1         
        //   13   25:invokeinterface #124 <Method void Loader.setSource(InputStream)>
            }
        //*  14   30:goto            39
            catch(Exception e)
        //*  15   33:astore_2        
            {
                m_Loader = null;
        //   16   34:aload_0         
        //   17   35:aconst_null     
        //   18   36:putfield        #69  <Field Loader m_Loader>
            }
            m_File = null;
        //   19   39:aload_0         
        //   20   40:aconst_null     
        //   21   41:putfield        #61  <Field File m_File>
            m_URL = null;
        //   22   44:aload_0         
        //   23   45:aconst_null     
        //   24   46:putfield        #56  <Field URL m_URL>
            m_Incremental = m_Loader instanceof IncrementalConverter;
        //   25   49:aload_0         
        //   26   50:aload_0         
        //   27   51:getfield        #69  <Field Loader m_Loader>
        //   28   54:instanceof      #98  <Class IncrementalConverter>
        //   29   57:putfield        #100 <Field boolean m_Incremental>
            initBatchBuffer();
        //   30   60:aload_0         
        //   31   61:invokevirtual   #117 <Method void initBatchBuffer()>
        //   32   64:return          
        }
    }

    public static class DataSink
        implements Serializable
    {

        public void write(Instances data)
            throws Exception
        {
            if(m_Saver != null)
        //*   0    0:aload_0         
        //*   1    1:getfield        #28  <Field Saver m_Saver>
        //*   2    4:ifnull          29
            {
                m_Saver.setInstances(data);
        //    3    7:aload_0         
        //    4    8:getfield        #28  <Field Saver m_Saver>
        //    5   11:aload_1         
        //    6   12:invokeinterface #72  <Method void Saver.setInstances(Instances)>
                m_Saver.writeBatch();
        //    7   17:aload_0         
        //    8   18:getfield        #28  <Field Saver m_Saver>
        //    9   21:invokeinterface #75  <Method void Saver.writeBatch()>
            } else
        //*  10   26:goto            50
            {
                m_Stream.write(data.toString().getBytes());
        //   11   29:aload_0         
        //   12   30:getfield        #30  <Field OutputStream m_Stream>
        //   13   33:aload_1         
        //   14   34:invokevirtual   #81  <Method String Instances.toString()>
        //   15   37:invokevirtual   #87  <Method byte[] String.getBytes()>
        //   16   40:invokevirtual   #92  <Method void OutputStream.write(byte[])>
                m_Stream.flush();
        //   17   43:aload_0         
        //   18   44:getfield        #30  <Field OutputStream m_Stream>
        //   19   47:invokevirtual   #95  <Method void OutputStream.flush()>
            }
        //   20   50:return          
        }

        public static void write(String filename, Instances data)
            throws Exception
        {
            DataSink sink = new DataSink(filename);
        //    0    0:new             #2   <Class ConverterUtils$DataSink>
        //    1    3:dup             
        //    2    4:aload_0         
        //    3    5:invokespecial   #99  <Method void ConverterUtils$DataSink(String)>
        //    4    8:astore_2        
            sink.write(data);
        //    5    9:aload_2         
        //    6   10:aload_1         
        //    7   11:invokevirtual   #101 <Method void write(Instances)>
        //    8   14:return          
        }

        public static void write(Saver saver, Instances data)
            throws Exception
        {
            DataSink sink = new DataSink(saver);
        //    0    0:new             #2   <Class ConverterUtils$DataSink>
        //    1    3:dup             
        //    2    4:aload_0         
        //    3    5:invokespecial   #105 <Method void ConverterUtils$DataSink(Saver)>
        //    4    8:astore_2        
            sink.write(data);
        //    5    9:aload_2         
        //    6   10:aload_1         
        //    7   11:invokevirtual   #101 <Method void write(Instances)>
        //    8   14:return          
        }

        public static void write(OutputStream stream, Instances data)
            throws Exception
        {
            DataSink sink = new DataSink(stream);
        //    0    0:new             #2   <Class ConverterUtils$DataSink>
        //    1    3:dup             
        //    2    4:aload_0         
        //    3    5:invokespecial   #108 <Method void ConverterUtils$DataSink(OutputStream)>
        //    4    8:astore_2        
            sink.write(data);
        //    5    9:aload_2         
        //    6   10:aload_1         
        //    7   11:invokevirtual   #101 <Method void write(Instances)>
        //    8   14:return          
        }

        public static void main(String args[])
            throws Exception
        {
            if(args.length != 2)
        //*   0    0:aload_0         
        //*   1    1:arraylength     
        //*   2    2:iconst_2        
        //*   3    3:icmpeq          41
            {
                System.out.println((new StringBuilder("\nUsage: ")).append(rm/core/converters/ConverterUtils$DataSource.getName()).append(" <input-file> <output-file>\n").toString());
        //    4    6:getstatic       #116 <Field PrintStream System.out>
        //    5    9:new             #118 <Class StringBuilder>
        //    6   12:dup             
        //    7   13:ldc1            #120 <String "\nUsage: ">
        //    8   15:invokespecial   #121 <Method void StringBuilder(String)>
        //    9   18:ldc1            #32  <Class ConverterUtils$DataSource>
        //   10   20:invokevirtual   #126 <Method String Class.getName()>
        //   11   23:invokevirtual   #130 <Method StringBuilder StringBuilder.append(String)>
        //   12   26:ldc1            #132 <String " <input-file> <output-file>\n">
        //   13   28:invokevirtual   #130 <Method StringBuilder StringBuilder.append(String)>
        //   14   31:invokevirtual   #133 <Method String StringBuilder.toString()>
        //   15   34:invokevirtual   #138 <Method void PrintStream.println(String)>
                System.exit(1);
        //   16   37:iconst_1        
        //   17   38:invokestatic    #142 <Method void System.exit(int)>
            }
            Instances data = DataSource.read(args[0]);
        //   18   41:aload_0         
        //   19   42:iconst_0        
        //   20   43:aaload          
        //   21   44:invokestatic    #146 <Method Instances ConverterUtils$DataSource.read(String)>
        //   22   47:astore_1        
            write(args[1], data);
        //   23   48:aload_0         
        //   24   49:iconst_1        
        //   25   50:aaload          
        //   26   51:aload_1         
        //   27   52:invokestatic    #148 <Method void write(String, Instances)>
        //   28   55:return          
        }

        private static final long serialVersionUID = 0xeb1d48960f1719bcL;
        protected Saver m_Saver;
        protected OutputStream m_Stream;
        static Class class$0;

        public DataSink(String filename)
            throws Exception
        {
        //    0    0:aload_0         
        //    1    1:invokespecial   #26  <Method void Object()>
            m_Saver = null;
        //    2    4:aload_0         
        //    3    5:aconst_null     
        //    4    6:putfield        #28  <Field Saver m_Saver>
            m_Stream = null;
        //    5    9:aload_0         
        //    6   10:aconst_null     
        //    7   11:putfield        #30  <Field OutputStream m_Stream>
            m_Stream = null;
        //    8   14:aload_0         
        //    9   15:aconst_null     
        //   10   16:putfield        #30  <Field OutputStream m_Stream>
            if(DataSource.isArff(filename))
        //*  11   19:aload_1         
        //*  12   20:invokestatic    #36  <Method boolean ConverterUtils$DataSource.isArff(String)>
        //*  13   23:ifeq            40
                m_Saver = new ArffSaver();
        //   14   26:aload_0         
        //   15   27:new             #38  <Class ArffSaver>
        //   16   30:dup             
        //   17   31:invokespecial   #39  <Method void ArffSaver()>
        //   18   34:putfield        #28  <Field Saver m_Saver>
            else
        //*  19   37:goto            48
                m_Saver = ConverterUtils.getSaverForFile(filename);
        //   20   40:aload_0         
        //   21   41:aload_1         
        //   22   42:invokestatic    #45  <Method AbstractFileSaver ConverterUtils.getSaverForFile(String)>
        //   23   45:putfield        #28  <Field Saver m_Saver>
            ((AbstractFileSaver)m_Saver).setFile(new File(filename));
        //   24   48:aload_0         
        //   25   49:getfield        #28  <Field Saver m_Saver>
        //   26   52:checkcast       #47  <Class AbstractFileSaver>
        //   27   55:new             #49  <Class File>
        //   28   58:dup             
        //   29   59:aload_1         
        //   30   60:invokespecial   #51  <Method void File(String)>
        //   31   63:invokevirtual   #55  <Method void AbstractFileSaver.setFile(File)>
        //   32   66:return          
        }

        public DataSink(Saver saver)
        {
        //    0    0:aload_0         
        //    1    1:invokespecial   #26  <Method void Object()>
            m_Saver = null;
        //    2    4:aload_0         
        //    3    5:aconst_null     
        //    4    6:putfield        #28  <Field Saver m_Saver>
            m_Stream = null;
        //    5    9:aload_0         
        //    6   10:aconst_null     
        //    7   11:putfield        #30  <Field OutputStream m_Stream>
            m_Saver = saver;
        //    8   14:aload_0         
        //    9   15:aload_1         
        //   10   16:putfield        #28  <Field Saver m_Saver>
            m_Stream = null;
        //   11   19:aload_0         
        //   12   20:aconst_null     
        //   13   21:putfield        #30  <Field OutputStream m_Stream>
        //   14   24:return          
        }

        public DataSink(OutputStream stream)
        {
        //    0    0:aload_0         
        //    1    1:invokespecial   #26  <Method void Object()>
            m_Saver = null;
        //    2    4:aload_0         
        //    3    5:aconst_null     
        //    4    6:putfield        #28  <Field Saver m_Saver>
            m_Stream = null;
        //    5    9:aload_0         
        //    6   10:aconst_null     
        //    7   11:putfield        #30  <Field OutputStream m_Stream>
            m_Saver = null;
        //    8   14:aload_0         
        //    9   15:aconst_null     
        //   10   16:putfield        #28  <Field Saver m_Saver>
            m_Stream = stream;
        //   11   19:aload_0         
        //   12   20:aload_1         
        //   13   21:putfield        #30  <Field OutputStream m_Stream>
        //   14   24:return          
        }
    }


    public ConverterUtils()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #135 <Method void Object()>
    //    2    4:return          
    }

    protected static Hashtable getFileConverters(String classnames, String intf[])
    {
        Vector list = new Vector();
    //    0    0:new             #118 <Class Vector>
    //    1    3:dup             
    //    2    4:invokespecial   #139 <Method void Vector()>
    //    3    7:astore_2        
        String names[] = classnames.split(",");
    //    4    8:aload_0         
    //    5    9:ldc1            #50  <String ",">
    //    6   11:invokevirtual   #143 <Method String[] String.split(String)>
    //    7   14:astore_3        
        for(int i = 0; i < names.length; i++)
    //*   8   15:iconst_0        
    //*   9   16:istore          4
    //*  10   18:goto            33
            list.add(names[i]);
    //   11   21:aload_2         
    //   12   22:aload_3         
    //   13   23:iload           4
    //   14   25:aaload          
    //   15   26:invokevirtual   #147 <Method boolean Vector.add(Object)>
    //   16   29:pop             

    //   17   30:iinc            4  1
    //   18   33:iload           4
    //   19   35:aload_3         
    //   20   36:arraylength     
    //   21   37:icmplt          21
        return getFileConverters(list, intf);
    //   22   40:aload_2         
    //   23   41:aload_1         
    //   24   42:invokestatic    #122 <Method Hashtable getFileConverters(Vector, String[])>
    //   25   45:areturn         
    }

    protected static Hashtable getFileConverters(Vector classnames, String intf[])
    {
        Hashtable result = new Hashtable();
    //    0    0:new             #79  <Class Hashtable>
    //    1    3:dup             
    //    2    4:invokespecial   #80  <Method void Hashtable()>
    //    3    7:astore_2        
        for(int i = 0; i < classnames.size(); i++)
    //*   4    8:iconst_0        
    //*   5    9:istore          7
    //*   6   11:goto            138
        {
            String classname = (String)(String)classnames.get(i);
    //    7   14:aload_0         
    //    8   15:iload           7
    //    9   17:invokevirtual   #158 <Method Object Vector.get(int)>
    //   10   20:checkcast       #40  <Class String>
    //   11   23:checkcast       #40  <Class String>
    //   12   26:astore_3        
            for(int n = 0; n < intf.length; n++)
    //*  13   27:iconst_0        
    //*  14   28:istore          8
    //*  15   30:goto            47
                if(ClassDiscovery.hasInterface(intf[n], classname));
    //   16   33:aload_1         
    //   17   34:iload           8
    //   18   36:aaload          
    //   19   37:aload_3         
    //   20   38:invokestatic    #164 <Method boolean ClassDiscovery.hasInterface(String, String)>
    //   21   41:ifne            44

    //   22   44:iinc            8  1
    //   23   47:iload           8
    //   24   49:aload_1         
    //   25   50:arraylength     
    //   26   51:icmplt          33
            String ext[];
            FileSourcedConverter converter;
            try
            {
                Class cls = Class.forName(classname);
    //   27   54:aload_3         
    //   28   55:invokestatic    #168 <Method Class Class.forName(String)>
    //   29   58:astore          4
                converter = (FileSourcedConverter)(FileSourcedConverter)cls.newInstance();
    //   30   60:aload           4
    //   31   62:invokevirtual   #172 <Method Object Class.newInstance()>
    //   32   65:checkcast       #96  <Class FileSourcedConverter>
    //   33   68:checkcast       #96  <Class FileSourcedConverter>
    //   34   71:astore          6
                ext = converter.getFileExtensions();
    //   35   73:aload           6
    //   36   75:invokeinterface #176 <Method String[] FileSourcedConverter.getFileExtensions()>
    //   37   80:astore          5
            }
    //*  38   82:goto            99
            catch(Exception e)
    //*  39   85:astore          9
            {
                Class cls = null;
    //   40   87:aconst_null     
    //   41   88:astore          4
                converter = null;
    //   42   90:aconst_null     
    //   43   91:astore          6
                ext = new String[0];
    //   44   93:iconst_0        
    //   45   94:anewarray       String[]
    //   46   97:astore          5
            }
            if(converter != null)
    //*  47   99:aload           6
    //*  48  101:ifnonnull       107
    //*  49  104:goto            135
            {
                for(int n = 0; n < ext.length; n++)
    //*  50  107:iconst_0        
    //*  51  108:istore          8
    //*  52  110:goto            127
                    result.put(ext[n], classname);
    //   53  113:aload_2         
    //   54  114:aload           5
    //   55  116:iload           8
    //   56  118:aaload          
    //   57  119:aload_3         
    //   58  120:invokevirtual   #180 <Method Object Hashtable.put(Object, Object)>
    //   59  123:pop             

    //   60  124:iinc            8  1
    //   61  127:iload           8
    //   62  129:aload           5
    //   63  131:arraylength     
    //   64  132:icmplt          113
            }
        }

    //   65  135:iinc            7  1
    //   66  138:iload           7
    //   67  140:aload_0         
    //   68  141:invokevirtual   #119 <Method int Vector.size()>
    //   69  144:icmplt          14
        return result;
    //   70  147:aload_2         
    //   71  148:areturn         
    }

    public static void getFirstToken(StreamTokenizer tokenizer)
        throws IOException
    {
        while(tokenizer.nextToken() == 10) ;
    //    0    0:aload_0         
    //    1    1:invokevirtual   #200 <Method int StreamTokenizer.nextToken()>
    //    2    4:bipush          10
    //    3    6:icmpeq          0
        if(tokenizer.ttype == 39 || tokenizer.ttype == 34)
    //*   4    9:aload_0         
    //*   5   10:getfield        #203 <Field int StreamTokenizer.ttype>
    //*   6   13:bipush          39
    //*   7   15:icmpeq          27
    //*   8   18:aload_0         
    //*   9   19:getfield        #203 <Field int StreamTokenizer.ttype>
    //*  10   22:bipush          34
    //*  11   24:icmpne          36
            tokenizer.ttype = -3;
    //   12   27:aload_0         
    //   13   28:bipush          -3
    //   14   30:putfield        #203 <Field int StreamTokenizer.ttype>
        else
    //*  15   33:goto            63
        if(tokenizer.ttype == -3 && tokenizer.sval.equals("?"))
    //*  16   36:aload_0         
    //*  17   37:getfield        #203 <Field int StreamTokenizer.ttype>
    //*  18   40:bipush          -3
    //*  19   42:icmpne          63
    //*  20   45:aload_0         
    //*  21   46:getfield        #206 <Field String StreamTokenizer.sval>
    //*  22   49:ldc1            #208 <String "?">
    //*  23   51:invokevirtual   #211 <Method boolean String.equals(Object)>
    //*  24   54:ifeq            63
            tokenizer.ttype = 63;
    //   25   57:aload_0         
    //   26   58:bipush          63
    //   27   60:putfield        #203 <Field int StreamTokenizer.ttype>
    //   28   63:return          
    }

    public static void getToken(StreamTokenizer tokenizer)
        throws IOException
    {
        tokenizer.nextToken();
    //    0    0:aload_0         
    //    1    1:invokevirtual   #200 <Method int StreamTokenizer.nextToken()>
    //    2    4:pop             
        if(tokenizer.ttype == 10)
    //*   3    5:aload_0         
    //*   4    6:getfield        #203 <Field int StreamTokenizer.ttype>
    //*   5    9:bipush          10
    //*   6   11:icmpne          15
            return;
    //    7   14:return          
        if(tokenizer.ttype == 39 || tokenizer.ttype == 34)
    //*   8   15:aload_0         
    //*   9   16:getfield        #203 <Field int StreamTokenizer.ttype>
    //*  10   19:bipush          39
    //*  11   21:icmpeq          33
    //*  12   24:aload_0         
    //*  13   25:getfield        #203 <Field int StreamTokenizer.ttype>
    //*  14   28:bipush          34
    //*  15   30:icmpne          42
            tokenizer.ttype = -3;
    //   16   33:aload_0         
    //   17   34:bipush          -3
    //   18   36:putfield        #203 <Field int StreamTokenizer.ttype>
        else
    //*  19   39:goto            69
        if(tokenizer.ttype == -3 && tokenizer.sval.equals("?"))
    //*  20   42:aload_0         
    //*  21   43:getfield        #203 <Field int StreamTokenizer.ttype>
    //*  22   46:bipush          -3
    //*  23   48:icmpne          69
    //*  24   51:aload_0         
    //*  25   52:getfield        #206 <Field String StreamTokenizer.sval>
    //*  26   55:ldc1            #208 <String "?">
    //*  27   57:invokevirtual   #211 <Method boolean String.equals(Object)>
    //*  28   60:ifeq            69
            tokenizer.ttype = 63;
    //   29   63:aload_0         
    //   30   64:bipush          63
    //   31   66:putfield        #203 <Field int StreamTokenizer.ttype>
    //   32   69:return          
    }

    public static void errms(StreamTokenizer tokenizer, String theMsg)
        throws IOException
    {
        throw new IOException((new StringBuilder(String.valueOf(theMsg))).append(", read ").append(tokenizer.toString()).toString());
    //    0    0:new             #195 <Class IOException>
    //    1    3:dup             
    //    2    4:new             #30  <Class StringBuilder>
    //    3    7:dup             
    //    4    8:aload_1         
    //    5    9:invokestatic    #44  <Method String String.valueOf(Object)>
    //    6   12:invokespecial   #48  <Method void StringBuilder(String)>
    //    7   15:ldc1            #218 <String ", read ">
    //    8   17:invokevirtual   #54  <Method StringBuilder StringBuilder.append(String)>
    //    9   20:aload_0         
    //   10   21:invokevirtual   #219 <Method String StreamTokenizer.toString()>
    //   11   24:invokevirtual   #54  <Method StringBuilder StringBuilder.append(String)>
    //   12   27:invokevirtual   #59  <Method String StringBuilder.toString()>
    //   13   30:invokespecial   #220 <Method void IOException(String)>
    //   14   33:athrow          
    }

    protected static Vector getConverters(Hashtable ht)
    {
        Vector result = new Vector();
    //    0    0:new             #118 <Class Vector>
    //    1    3:dup             
    //    2    4:invokespecial   #139 <Method void Vector()>
    //    3    7:astore_1        
        for(Enumeration enm = ht.elements(); enm.hasMoreElements();)
    //*   4    8:aload_0         
    //*   5    9:invokevirtual   #228 <Method Enumeration Hashtable.elements()>
    //*   6   12:astore_2        
    //*   7   13:goto            40
        {
            String converter = (String)enm.nextElement();
    //    8   16:aload_2         
    //    9   17:invokeinterface #233 <Method Object Enumeration.nextElement()>
    //   10   22:checkcast       #40  <Class String>
    //   11   25:astore_3        
            if(!result.contains(converter))
    //*  12   26:aload_1         
    //*  13   27:aload_3         
    //*  14   28:invokevirtual   #236 <Method boolean Vector.contains(Object)>
    //*  15   31:ifne            40
                result.add(converter);
    //   16   34:aload_1         
    //   17   35:aload_3         
    //   18   36:invokevirtual   #147 <Method boolean Vector.add(Object)>
    //   19   39:pop             
        }

    //   20   40:aload_2         
    //   21   41:invokeinterface #240 <Method boolean Enumeration.hasMoreElements()>
    //   22   46:ifne            16
        Collections.sort(result);
    //   23   49:aload_1         
    //   24   50:invokestatic    #246 <Method void Collections.sort(java.util.List)>
        return result;
    //   25   53:aload_1         
    //   26   54:areturn         
    }

    protected static Object getConverterForFile(String filename, Hashtable ht)
    {
        Object result = null;
    //    0    0:aconst_null     
    //    1    1:astore_2        
        int index = filename.lastIndexOf('.');
    //    2    2:aload_0         
    //    3    3:bipush          46
    //    4    5:invokevirtual   #258 <Method int String.lastIndexOf(int)>
    //    5    8:istore          4
        if(index > -1)
    //*   6   10:iload           4
    //*   7   12:iconst_m1       
    //*   8   13:icmple          101
        {
            String extension = filename.substring(index).toLowerCase();
    //    9   16:aload_0         
    //   10   17:iload           4
    //   11   19:invokevirtual   #262 <Method String String.substring(int)>
    //   12   22:invokevirtual   #265 <Method String String.toLowerCase()>
    //   13   25:astore_3        
            result = getConverterForExtension(extension, ht);
    //   14   26:aload_3         
    //   15   27:aload_1         
    //   16   28:invokestatic    #268 <Method Object getConverterForExtension(String, Hashtable)>
    //   17   31:astore_2        
            if(result == null)
    //*  18   32:aload_2         
    //*  19   33:ifnonnull       59
                System.out.println((new StringBuilder("+++++++++++++extension+++++++++++++++")).append(extension).toString());
    //   20   36:getstatic       #274 <Field PrintStream System.out>
    //   21   39:new             #30  <Class StringBuilder>
    //   22   42:dup             
    //   23   43:ldc2            #276 <String "+++++++++++++extension+++++++++++++++">
    //   24   46:invokespecial   #48  <Method void StringBuilder(String)>
    //   25   49:aload_3         
    //   26   50:invokevirtual   #54  <Method StringBuilder StringBuilder.append(String)>
    //   27   53:invokevirtual   #59  <Method String StringBuilder.toString()>
    //   28   56:invokevirtual   #281 <Method void PrintStream.println(String)>
            if(extension.equals(".gz") && result == null)
    //*  29   59:aload_3         
    //*  30   60:ldc2            #283 <String ".gz">
    //*  31   63:invokevirtual   #211 <Method boolean String.equals(Object)>
    //*  32   66:ifeq            101
    //*  33   69:aload_2         
    //*  34   70:ifnonnull       101
            {
                index = filename.lastIndexOf('.', index - 1);
    //   35   73:aload_0         
    //   36   74:bipush          46
    //   37   76:iload           4
    //   38   78:iconst_1        
    //   39   79:isub            
    //   40   80:invokevirtual   #286 <Method int String.lastIndexOf(int, int)>
    //   41   83:istore          4
                extension = filename.substring(index).toLowerCase();
    //   42   85:aload_0         
    //   43   86:iload           4
    //   44   88:invokevirtual   #262 <Method String String.substring(int)>
    //   45   91:invokevirtual   #265 <Method String String.toLowerCase()>
    //   46   94:astore_3        
                result = getConverterForExtension(extension, ht);
    //   47   95:aload_3         
    //   48   96:aload_1         
    //   49   97:invokestatic    #268 <Method Object getConverterForExtension(String, Hashtable)>
    //   50  100:astore_2        
            }
        }
        return result;
    //   51  101:aload_2         
    //   52  102:areturn         
    }

    protected static Object getConverterForExtension(String extension, Hashtable ht)
    {
        Object result = null;
    //    0    0:aconst_null     
    //    1    1:astore_2        
        String classname = (String)ht.get(extension);
    //    2    2:aload_1         
    //    3    3:aload_0         
    //    4    4:invokevirtual   #293 <Method Object Hashtable.get(Object)>
    //    5    7:checkcast       #40  <Class String>
    //    6   10:astore_3        
        if(classname != null)
    //*   7   11:aload_3         
    //*   8   12:ifnull          35
            try
            {
                result = Class.forName(classname).newInstance();
    //    9   15:aload_3         
    //   10   16:invokestatic    #168 <Method Class Class.forName(String)>
    //   11   19:invokevirtual   #172 <Method Object Class.newInstance()>
    //   12   22:astore_2        
            }
    //*  13   23:goto            35
            catch(Exception e)
    //*  14   26:astore          4
            {
                result = null;
    //   15   28:aconst_null     
    //   16   29:astore_2        
                e.printStackTrace();
    //   17   30:aload           4
    //   18   32:invokevirtual   #296 <Method void Exception.printStackTrace()>
            }
        return result;
    //   19   35:aload_2         
    //   20   36:areturn         
    }

    public static boolean isCoreFileLoader(String classname)
    {
        String classnames[] = CORE_FILE_LOADERS.split(",");
    //    0    0:getstatic       #61  <Field String CORE_FILE_LOADERS>
    //    1    3:ldc1            #50  <String ",">
    //    2    5:invokevirtual   #143 <Method String[] String.split(String)>
    //    3    8:astore_2        
        boolean result = Arrays.binarySearch(classnames, classname) >= 0;
    //    4    9:aload_2         
    //    5   10:aload_0         
    //    6   11:invokestatic    #304 <Method int Arrays.binarySearch(Object[], Object)>
    //    7   14:iflt            21
    //    8   17:iconst_1        
    //    9   18:goto            22
    //   10   21:iconst_0        
    //   11   22:istore_1        
        return result;
    //   12   23:iload_1         
    //   13   24:ireturn         
    }

    public static Vector getFileLoaders()
    {
        return getConverters(m_FileLoaders);
    //    0    0:getstatic       #82  <Field Hashtable m_FileLoaders>
    //    1    3:invokestatic    #310 <Method Vector getConverters(Hashtable)>
    //    2    6:areturn         
    }

    public static AbstractFileLoader getLoaderForFile(String filename)
    {
        return (AbstractFileLoader)getConverterForFile(filename, m_FileLoaders);
    //    0    0:aload_0         
    //    1    1:getstatic       #82  <Field Hashtable m_FileLoaders>
    //    2    4:invokestatic    #314 <Method Object getConverterForFile(String, Hashtable)>
    //    3    7:checkcast       #110 <Class AbstractFileLoader>
    //    4   10:areturn         
    }

    public static AbstractFileLoader getLoaderForFile(File file)
    {
        return getLoaderForFile(file.getAbsolutePath());
    //    0    0:aload_0         
    //    1    1:invokevirtual   #320 <Method String File.getAbsolutePath()>
    //    2    4:invokestatic    #322 <Method AbstractFileLoader getLoaderForFile(String)>
    //    3    7:areturn         
    }

    public static AbstractFileLoader getLoaderForExtension(String extension)
    {
        return (AbstractFileLoader)getConverterForExtension(extension, m_FileLoaders);
    //    0    0:aload_0         
    //    1    1:getstatic       #82  <Field Hashtable m_FileLoaders>
    //    2    4:invokestatic    #268 <Method Object getConverterForExtension(String, Hashtable)>
    //    3    7:checkcast       #110 <Class AbstractFileLoader>
    //    4   10:areturn         
    }

    public static Vector getURLFileLoaders()
    {
        return getConverters(m_URLFileLoaders);
    //    0    0:getstatic       #84  <Field Hashtable m_URLFileLoaders>
    //    1    3:invokestatic    #310 <Method Vector getConverters(Hashtable)>
    //    2    6:areturn         
    }

    public static AbstractFileLoader getURLLoaderForFile(String filename)
    {
        return (AbstractFileLoader)getConverterForFile(filename, m_URLFileLoaders);
    //    0    0:aload_0         
    //    1    1:getstatic       #84  <Field Hashtable m_URLFileLoaders>
    //    2    4:invokestatic    #314 <Method Object getConverterForFile(String, Hashtable)>
    //    3    7:checkcast       #110 <Class AbstractFileLoader>
    //    4   10:areturn         
    }

    public static AbstractFileLoader getURLLoaderForFile(File file)
    {
        return getURLLoaderForFile(file.getAbsolutePath());
    //    0    0:aload_0         
    //    1    1:invokevirtual   #320 <Method String File.getAbsolutePath()>
    //    2    4:invokestatic    #329 <Method AbstractFileLoader getURLLoaderForFile(String)>
    //    3    7:areturn         
    }

    public static AbstractFileLoader getURLLoaderForExtension(String extension)
    {
        return (AbstractFileLoader)getConverterForExtension(extension, m_URLFileLoaders);
    //    0    0:aload_0         
    //    1    1:getstatic       #84  <Field Hashtable m_URLFileLoaders>
    //    2    4:invokestatic    #268 <Method Object getConverterForExtension(String, Hashtable)>
    //    3    7:checkcast       #110 <Class AbstractFileLoader>
    //    4   10:areturn         
    }

    public static boolean isCoreFileSaver(String classname)
    {
        String classnames[] = CORE_FILE_SAVERS.split(",");
    //    0    0:getstatic       #65  <Field String CORE_FILE_SAVERS>
    //    1    3:ldc1            #50  <String ",">
    //    2    5:invokevirtual   #143 <Method String[] String.split(String)>
    //    3    8:astore_2        
        boolean result = Arrays.binarySearch(classnames, classname) >= 0;
    //    4    9:aload_2         
    //    5   10:aload_0         
    //    6   11:invokestatic    #304 <Method int Arrays.binarySearch(Object[], Object)>
    //    7   14:iflt            21
    //    8   17:iconst_1        
    //    9   18:goto            22
    //   10   21:iconst_0        
    //   11   22:istore_1        
        return result;
    //   12   23:iload_1         
    //   13   24:ireturn         
    }

    public static Vector getFileSavers()
    {
        return getConverters(m_FileSavers);
    //    0    0:getstatic       #86  <Field Hashtable m_FileSavers>
    //    1    3:invokestatic    #310 <Method Vector getConverters(Hashtable)>
    //    2    6:areturn         
    }

    public static AbstractFileSaver getSaverForFile(String filename)
    {
        return (AbstractFileSaver)getConverterForFile(filename, m_FileSavers);
    //    0    0:aload_0         
    //    1    1:getstatic       #86  <Field Hashtable m_FileSavers>
    //    2    4:invokestatic    #314 <Method Object getConverterForFile(String, Hashtable)>
    //    3    7:checkcast       #124 <Class AbstractFileSaver>
    //    4   10:areturn         
    }

    public static AbstractFileSaver getSaverForFile(File file)
    {
        return getSaverForFile(file.getAbsolutePath());
    //    0    0:aload_0         
    //    1    1:invokevirtual   #320 <Method String File.getAbsolutePath()>
    //    2    4:invokestatic    #337 <Method AbstractFileSaver getSaverForFile(String)>
    //    3    7:areturn         
    }

    public static AbstractFileSaver getSaverForExtension(String extension)
    {
        return (AbstractFileSaver)getConverterForExtension(extension, m_FileSavers);
    //    0    0:aload_0         
    //    1    1:getstatic       #86  <Field Hashtable m_FileSavers>
    //    2    4:invokestatic    #268 <Method Object getConverterForExtension(String, Hashtable)>
    //    3    7:checkcast       #124 <Class AbstractFileSaver>
    //    4   10:areturn         
    }

    public static final String CORE_FILE_LOADERS;
    public static final String CORE_FILE_SAVERS;
    protected static Hashtable m_FileLoaders;
    protected static Hashtable m_URLFileLoaders;
    protected static Hashtable m_FileSavers;
    static Class class$0;
    static Class class$1;
    static Class class$2;
    static Class class$3;
    static Class class$4;
    static Class class$5;
    static Class class$6;
    static Class class$7;
    static Class class$8;

    static 
    {
        CORE_FILE_LOADERS = (new StringBuilder(String.valueOf(rm/core/converters/ArffLoader.getName()))).append(",").append(rm/core/converters/SerializedInstancesLoader.getName()).append(",").toString();
    //    0    0:new             #30  <Class StringBuilder>
    //    1    3:dup             
    //    2    4:ldc1            #32  <Class ArffLoader>
    //    3    6:invokevirtual   #38  <Method String Class.getName()>
    //    4    9:invokestatic    #44  <Method String String.valueOf(Object)>
    //    5   12:invokespecial   #48  <Method void StringBuilder(String)>
    //    6   15:ldc1            #50  <String ",">
    //    7   17:invokevirtual   #54  <Method StringBuilder StringBuilder.append(String)>
    //    8   20:ldc1            #56  <Class SerializedInstancesLoader>
    //    9   22:invokevirtual   #38  <Method String Class.getName()>
    //   10   25:invokevirtual   #54  <Method StringBuilder StringBuilder.append(String)>
    //   11   28:ldc1            #50  <String ",">
    //   12   30:invokevirtual   #54  <Method StringBuilder StringBuilder.append(String)>
    //   13   33:invokevirtual   #59  <Method String StringBuilder.toString()>
    //   14   36:putstatic       #61  <Field String CORE_FILE_LOADERS>
        CORE_FILE_SAVERS = (new StringBuilder(String.valueOf(rm/core/converters/ArffSaver.getName()))).append(",").toString();
    //   15   39:new             #30  <Class StringBuilder>
    //   16   42:dup             
    //   17   43:ldc1            #63  <Class ArffSaver>
    //   18   45:invokevirtual   #38  <Method String Class.getName()>
    //   19   48:invokestatic    #44  <Method String String.valueOf(Object)>
    //   20   51:invokespecial   #48  <Method void StringBuilder(String)>
    //   21   54:ldc1            #50  <String ",">
    //   22   56:invokevirtual   #54  <Method StringBuilder StringBuilder.append(String)>
    //   23   59:invokevirtual   #59  <Method String StringBuilder.toString()>
    //   24   62:putstatic       #65  <Field String CORE_FILE_SAVERS>
        try
        {
            GenericPropertiesCreator creator = new GenericPropertiesCreator();
    //   25   65:new             #67  <Class GenericPropertiesCreator>
    //   26   68:dup             
    //   27   69:invokespecial   #69  <Method void GenericPropertiesCreator()>
    //   28   72:astore_1        
            creator.execute(false);
    //   29   73:aload_1         
    //   30   74:iconst_0        
    //   31   75:invokevirtual   #73  <Method void GenericPropertiesCreator.execute(boolean)>
            Properties props = creator.getOutputProperties();
    //   32   78:aload_1         
    //   33   79:invokevirtual   #77  <Method Properties GenericPropertiesCreator.getOutputProperties()>
    //   34   82:astore_2        
            m_FileLoaders = new Hashtable();
    //   35   83:new             #79  <Class Hashtable>
    //   36   86:dup             
    //   37   87:invokespecial   #80  <Method void Hashtable()>
    //   38   90:putstatic       #82  <Field Hashtable m_FileLoaders>
            m_URLFileLoaders = new Hashtable();
    //   39   93:new             #79  <Class Hashtable>
    //   40   96:dup             
    //   41   97:invokespecial   #80  <Method void Hashtable()>
    //   42  100:putstatic       #84  <Field Hashtable m_URLFileLoaders>
            m_FileSavers = new Hashtable();
    //   43  103:new             #79  <Class Hashtable>
    //   44  106:dup             
    //   45  107:invokespecial   #80  <Method void Hashtable()>
    //   46  110:putstatic       #86  <Field Hashtable m_FileSavers>
            m_FileLoaders = getFileConverters(props.getProperty(rm/core/converters/Loader.getName(), CORE_FILE_LOADERS), new String[] {
                rm/core/converters/FileSourcedConverter.getName()
            });
    //   47  113:aload_2         
    //   48  114:ldc1            #88  <Class Loader>
    //   49  116:invokevirtual   #38  <Method String Class.getName()>
    //   50  119:getstatic       #61  <Field String CORE_FILE_LOADERS>
    //   51  122:invokevirtual   #94  <Method String Properties.getProperty(String, String)>
    //   52  125:iconst_1        
    //   53  126:anewarray       String[]
    //   54  129:dup             
    //   55  130:iconst_0        
    //   56  131:ldc1            #96  <Class FileSourcedConverter>
    //   57  133:invokevirtual   #38  <Method String Class.getName()>
    //   58  136:aastore         
    //   59  137:invokestatic    #100 <Method Hashtable getFileConverters(String, String[])>
    //   60  140:putstatic       #82  <Field Hashtable m_FileLoaders>
            m_URLFileLoaders = getFileConverters(props.getProperty(rm/core/converters/Loader.getName(), CORE_FILE_LOADERS), new String[] {
                rm/core/converters/FileSourcedConverter.getName(), rm/core/converters/URLSourcedLoader.getName()
            });
    //   61  143:aload_2         
    //   62  144:ldc1            #88  <Class Loader>
    //   63  146:invokevirtual   #38  <Method String Class.getName()>
    //   64  149:getstatic       #61  <Field String CORE_FILE_LOADERS>
    //   65  152:invokevirtual   #94  <Method String Properties.getProperty(String, String)>
    //   66  155:iconst_2        
    //   67  156:anewarray       String[]
    //   68  159:dup             
    //   69  160:iconst_0        
    //   70  161:ldc1            #96  <Class FileSourcedConverter>
    //   71  163:invokevirtual   #38  <Method String Class.getName()>
    //   72  166:aastore         
    //   73  167:dup             
    //   74  168:iconst_1        
    //   75  169:ldc1            #102 <Class URLSourcedLoader>
    //   76  171:invokevirtual   #38  <Method String Class.getName()>
    //   77  174:aastore         
    //   78  175:invokestatic    #100 <Method Hashtable getFileConverters(String, String[])>
    //   79  178:putstatic       #84  <Field Hashtable m_URLFileLoaders>
            m_FileSavers = getFileConverters(props.getProperty(rm/core/converters/Saver.getName(), CORE_FILE_SAVERS), new String[] {
                rm/core/converters/FileSourcedConverter.getName()
            });
    //   80  181:aload_2         
    //   81  182:ldc1            #104 <Class Saver>
    //   82  184:invokevirtual   #38  <Method String Class.getName()>
    //   83  187:getstatic       #65  <Field String CORE_FILE_SAVERS>
    //   84  190:invokevirtual   #94  <Method String Properties.getProperty(String, String)>
    //   85  193:iconst_1        
    //   86  194:anewarray       String[]
    //   87  197:dup             
    //   88  198:iconst_0        
    //   89  199:ldc1            #96  <Class FileSourcedConverter>
    //   90  201:invokevirtual   #38  <Method String Class.getName()>
    //   91  204:aastore         
    //   92  205:invokestatic    #100 <Method Hashtable getFileConverters(String, String[])>
    //   93  208:putstatic       #86  <Field Hashtable m_FileSavers>
        }
    //*  94  211:goto            441
        catch(Exception exception) { }
    //   95  214:astore_1        
        break MISSING_BLOCK_LABEL_441;
    //   96  215:goto            441
        Exception exception1;
        exception1;
    //   97  218:astore_3        
        if(m_FileLoaders.size() == 0)
    //*  98  219:getstatic       #82  <Field Hashtable m_FileLoaders>
    //*  99  222:invokevirtual   #108 <Method int Hashtable.size()>
    //* 100  225:ifne            287
        {
            Vector classnames = GenericObjectEditor.getClassnames(rm/core/converters/AbstractFileLoader.getName());
    //  101  228:ldc1            #110 <Class AbstractFileLoader>
    //  102  230:invokevirtual   #38  <Method String Class.getName()>
    //  103  233:invokestatic    #116 <Method Vector GenericObjectEditor.getClassnames(String)>
    //  104  236:astore_0        
            if(classnames.size() > 0)
    //* 105  237:aload_0         
    //* 106  238:invokevirtual   #119 <Method int Vector.size()>
    //* 107  241:ifle            266
                m_FileLoaders = getFileConverters(classnames, new String[] {
                    rm/core/converters/FileSourcedConverter.getName()
                });
    //  108  244:aload_0         
    //  109  245:iconst_1        
    //  110  246:anewarray       String[]
    //  111  249:dup             
    //  112  250:iconst_0        
    //  113  251:ldc1            #96  <Class FileSourcedConverter>
    //  114  253:invokevirtual   #38  <Method String Class.getName()>
    //  115  256:aastore         
    //  116  257:invokestatic    #122 <Method Hashtable getFileConverters(Vector, String[])>
    //  117  260:putstatic       #82  <Field Hashtable m_FileLoaders>
            else
    //* 118  263:goto            287
                m_FileLoaders = getFileConverters(CORE_FILE_LOADERS, new String[] {
                    rm/core/converters/FileSourcedConverter.getName()
                });
    //  119  266:getstatic       #61  <Field String CORE_FILE_LOADERS>
    //  120  269:iconst_1        
    //  121  270:anewarray       String[]
    //  122  273:dup             
    //  123  274:iconst_0        
    //  124  275:ldc1            #96  <Class FileSourcedConverter>
    //  125  277:invokevirtual   #38  <Method String Class.getName()>
    //  126  280:aastore         
    //  127  281:invokestatic    #100 <Method Hashtable getFileConverters(String, String[])>
    //  128  284:putstatic       #82  <Field Hashtable m_FileLoaders>
        }
        if(m_URLFileLoaders.size() == 0)
    //* 129  287:getstatic       #84  <Field Hashtable m_URLFileLoaders>
    //* 130  290:invokevirtual   #108 <Method int Hashtable.size()>
    //* 131  293:ifne            371
        {
            Vector classnames = GenericObjectEditor.getClassnames(rm/core/converters/AbstractFileLoader.getName());
    //  132  296:ldc1            #110 <Class AbstractFileLoader>
    //  133  298:invokevirtual   #38  <Method String Class.getName()>
    //  134  301:invokestatic    #116 <Method Vector GenericObjectEditor.getClassnames(String)>
    //  135  304:astore_0        
            if(classnames.size() > 0)
    //* 136  305:aload_0         
    //* 137  306:invokevirtual   #119 <Method int Vector.size()>
    //* 138  309:ifle            342
                m_URLFileLoaders = getFileConverters(classnames, new String[] {
                    rm/core/converters/FileSourcedConverter.getName(), rm/core/converters/URLSourcedLoader.getName()
                });
    //  139  312:aload_0         
    //  140  313:iconst_2        
    //  141  314:anewarray       String[]
    //  142  317:dup             
    //  143  318:iconst_0        
    //  144  319:ldc1            #96  <Class FileSourcedConverter>
    //  145  321:invokevirtual   #38  <Method String Class.getName()>
    //  146  324:aastore         
    //  147  325:dup             
    //  148  326:iconst_1        
    //  149  327:ldc1            #102 <Class URLSourcedLoader>
    //  150  329:invokevirtual   #38  <Method String Class.getName()>
    //  151  332:aastore         
    //  152  333:invokestatic    #122 <Method Hashtable getFileConverters(Vector, String[])>
    //  153  336:putstatic       #84  <Field Hashtable m_URLFileLoaders>
            else
    //* 154  339:goto            371
                m_URLFileLoaders = getFileConverters(CORE_FILE_LOADERS, new String[] {
                    rm/core/converters/FileSourcedConverter.getName(), rm/core/converters/URLSourcedLoader.getName()
                });
    //  155  342:getstatic       #61  <Field String CORE_FILE_LOADERS>
    //  156  345:iconst_2        
    //  157  346:anewarray       String[]
    //  158  349:dup             
    //  159  350:iconst_0        
    //  160  351:ldc1            #96  <Class FileSourcedConverter>
    //  161  353:invokevirtual   #38  <Method String Class.getName()>
    //  162  356:aastore         
    //  163  357:dup             
    //  164  358:iconst_1        
    //  165  359:ldc1            #102 <Class URLSourcedLoader>
    //  166  361:invokevirtual   #38  <Method String Class.getName()>
    //  167  364:aastore         
    //  168  365:invokestatic    #100 <Method Hashtable getFileConverters(String, String[])>
    //  169  368:putstatic       #84  <Field Hashtable m_URLFileLoaders>
        }
        if(m_FileSavers.size() == 0)
    //* 170  371:getstatic       #86  <Field Hashtable m_FileSavers>
    //* 171  374:invokevirtual   #108 <Method int Hashtable.size()>
    //* 172  377:ifne            439
        {
            Vector classnames = GenericObjectEditor.getClassnames(rm/core/converters/AbstractFileSaver.getName());
    //  173  380:ldc1            #124 <Class AbstractFileSaver>
    //  174  382:invokevirtual   #38  <Method String Class.getName()>
    //  175  385:invokestatic    #116 <Method Vector GenericObjectEditor.getClassnames(String)>
    //  176  388:astore_0        
            if(classnames.size() > 0)
    //* 177  389:aload_0         
    //* 178  390:invokevirtual   #119 <Method int Vector.size()>
    //* 179  393:ifle            418
                m_FileSavers = getFileConverters(classnames, new String[] {
                    rm/core/converters/FileSourcedConverter.getName()
                });
    //  180  396:aload_0         
    //  181  397:iconst_1        
    //  182  398:anewarray       String[]
    //  183  401:dup             
    //  184  402:iconst_0        
    //  185  403:ldc1            #96  <Class FileSourcedConverter>
    //  186  405:invokevirtual   #38  <Method String Class.getName()>
    //  187  408:aastore         
    //  188  409:invokestatic    #122 <Method Hashtable getFileConverters(Vector, String[])>
    //  189  412:putstatic       #86  <Field Hashtable m_FileSavers>
            else
    //* 190  415:goto            439
                m_FileSavers = getFileConverters(CORE_FILE_SAVERS, new String[] {
                    rm/core/converters/FileSourcedConverter.getName()
                });
    //  191  418:getstatic       #65  <Field String CORE_FILE_SAVERS>
    //  192  421:iconst_1        
    //  193  422:anewarray       String[]
    //  194  425:dup             
    //  195  426:iconst_0        
    //  196  427:ldc1            #96  <Class FileSourcedConverter>
    //  197  429:invokevirtual   #38  <Method String Class.getName()>
    //  198  432:aastore         
    //  199  433:invokestatic    #100 <Method Hashtable getFileConverters(String, String[])>
    //  200  436:putstatic       #86  <Field Hashtable m_FileSavers>
        }
        throw exception1;
    //  201  439:aload_3         
    //  202  440:athrow          
        if(m_FileLoaders.size() == 0)
    //* 203  441:getstatic       #82  <Field Hashtable m_FileLoaders>
    //* 204  444:invokevirtual   #108 <Method int Hashtable.size()>
    //* 205  447:ifne            509
        {
            Vector classnames = GenericObjectEditor.getClassnames(rm/core/converters/AbstractFileLoader.getName());
    //  206  450:ldc1            #110 <Class AbstractFileLoader>
    //  207  452:invokevirtual   #38  <Method String Class.getName()>
    //  208  455:invokestatic    #116 <Method Vector GenericObjectEditor.getClassnames(String)>
    //  209  458:astore_0        
            if(classnames.size() > 0)
    //* 210  459:aload_0         
    //* 211  460:invokevirtual   #119 <Method int Vector.size()>
    //* 212  463:ifle            488
                m_FileLoaders = getFileConverters(classnames, new String[] {
                    rm/core/converters/FileSourcedConverter.getName()
                });
    //  213  466:aload_0         
    //  214  467:iconst_1        
    //  215  468:anewarray       String[]
    //  216  471:dup             
    //  217  472:iconst_0        
    //  218  473:ldc1            #96  <Class FileSourcedConverter>
    //  219  475:invokevirtual   #38  <Method String Class.getName()>
    //  220  478:aastore         
    //  221  479:invokestatic    #122 <Method Hashtable getFileConverters(Vector, String[])>
    //  222  482:putstatic       #82  <Field Hashtable m_FileLoaders>
            else
    //* 223  485:goto            509
                m_FileLoaders = getFileConverters(CORE_FILE_LOADERS, new String[] {
                    rm/core/converters/FileSourcedConverter.getName()
                });
    //  224  488:getstatic       #61  <Field String CORE_FILE_LOADERS>
    //  225  491:iconst_1        
    //  226  492:anewarray       String[]
    //  227  495:dup             
    //  228  496:iconst_0        
    //  229  497:ldc1            #96  <Class FileSourcedConverter>
    //  230  499:invokevirtual   #38  <Method String Class.getName()>
    //  231  502:aastore         
    //  232  503:invokestatic    #100 <Method Hashtable getFileConverters(String, String[])>
    //  233  506:putstatic       #82  <Field Hashtable m_FileLoaders>
        }
        if(m_URLFileLoaders.size() == 0)
    //* 234  509:getstatic       #84  <Field Hashtable m_URLFileLoaders>
    //* 235  512:invokevirtual   #108 <Method int Hashtable.size()>
    //* 236  515:ifne            593
        {
            Vector classnames = GenericObjectEditor.getClassnames(rm/core/converters/AbstractFileLoader.getName());
    //  237  518:ldc1            #110 <Class AbstractFileLoader>
    //  238  520:invokevirtual   #38  <Method String Class.getName()>
    //  239  523:invokestatic    #116 <Method Vector GenericObjectEditor.getClassnames(String)>
    //  240  526:astore_0        
            if(classnames.size() > 0)
    //* 241  527:aload_0         
    //* 242  528:invokevirtual   #119 <Method int Vector.size()>
    //* 243  531:ifle            564
                m_URLFileLoaders = getFileConverters(classnames, new String[] {
                    rm/core/converters/FileSourcedConverter.getName(), rm/core/converters/URLSourcedLoader.getName()
                });
    //  244  534:aload_0         
    //  245  535:iconst_2        
    //  246  536:anewarray       String[]
    //  247  539:dup             
    //  248  540:iconst_0        
    //  249  541:ldc1            #96  <Class FileSourcedConverter>
    //  250  543:invokevirtual   #38  <Method String Class.getName()>
    //  251  546:aastore         
    //  252  547:dup             
    //  253  548:iconst_1        
    //  254  549:ldc1            #102 <Class URLSourcedLoader>
    //  255  551:invokevirtual   #38  <Method String Class.getName()>
    //  256  554:aastore         
    //  257  555:invokestatic    #122 <Method Hashtable getFileConverters(Vector, String[])>
    //  258  558:putstatic       #84  <Field Hashtable m_URLFileLoaders>
            else
    //* 259  561:goto            593
                m_URLFileLoaders = getFileConverters(CORE_FILE_LOADERS, new String[] {
                    rm/core/converters/FileSourcedConverter.getName(), rm/core/converters/URLSourcedLoader.getName()
                });
    //  260  564:getstatic       #61  <Field String CORE_FILE_LOADERS>
    //  261  567:iconst_2        
    //  262  568:anewarray       String[]
    //  263  571:dup             
    //  264  572:iconst_0        
    //  265  573:ldc1            #96  <Class FileSourcedConverter>
    //  266  575:invokevirtual   #38  <Method String Class.getName()>
    //  267  578:aastore         
    //  268  579:dup             
    //  269  580:iconst_1        
    //  270  581:ldc1            #102 <Class URLSourcedLoader>
    //  271  583:invokevirtual   #38  <Method String Class.getName()>
    //  272  586:aastore         
    //  273  587:invokestatic    #100 <Method Hashtable getFileConverters(String, String[])>
    //  274  590:putstatic       #84  <Field Hashtable m_URLFileLoaders>
        }
        if(m_FileSavers.size() == 0)
    //* 275  593:getstatic       #86  <Field Hashtable m_FileSavers>
    //* 276  596:invokevirtual   #108 <Method int Hashtable.size()>
    //* 277  599:ifne            661
        {
            Vector classnames = GenericObjectEditor.getClassnames(rm/core/converters/AbstractFileSaver.getName());
    //  278  602:ldc1            #124 <Class AbstractFileSaver>
    //  279  604:invokevirtual   #38  <Method String Class.getName()>
    //  280  607:invokestatic    #116 <Method Vector GenericObjectEditor.getClassnames(String)>
    //  281  610:astore_0        
            if(classnames.size() > 0)
    //* 282  611:aload_0         
    //* 283  612:invokevirtual   #119 <Method int Vector.size()>
    //* 284  615:ifle            640
                m_FileSavers = getFileConverters(classnames, new String[] {
                    rm/core/converters/FileSourcedConverter.getName()
                });
    //  285  618:aload_0         
    //  286  619:iconst_1        
    //  287  620:anewarray       String[]
    //  288  623:dup             
    //  289  624:iconst_0        
    //  290  625:ldc1            #96  <Class FileSourcedConverter>
    //  291  627:invokevirtual   #38  <Method String Class.getName()>
    //  292  630:aastore         
    //  293  631:invokestatic    #122 <Method Hashtable getFileConverters(Vector, String[])>
    //  294  634:putstatic       #86  <Field Hashtable m_FileSavers>
            else
    //* 295  637:goto            661
                m_FileSavers = getFileConverters(CORE_FILE_SAVERS, new String[] {
                    rm/core/converters/FileSourcedConverter.getName()
                });
    //  296  640:getstatic       #65  <Field String CORE_FILE_SAVERS>
    //  297  643:iconst_1        
    //  298  644:anewarray       String[]
    //  299  647:dup             
    //  300  648:iconst_0        
    //  301  649:ldc1            #96  <Class FileSourcedConverter>
    //  302  651:invokevirtual   #38  <Method String Class.getName()>
    //  303  654:aastore         
    //  304  655:invokestatic    #100 <Method Hashtable getFileConverters(String, String[])>
    //  305  658:putstatic       #86  <Field Hashtable m_FileSavers>
        }
    //  306  661:return          
    }
}
