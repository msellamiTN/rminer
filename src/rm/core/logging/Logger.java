// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   Logger.java

package rm.core.logging;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Properties;
import rm.core.Utils;
import rm.gui.LogPanel;

// Referenced classes of package rm.core.logging:
//            ConsoleLogger

public abstract class Logger
{
    public static class Level extends Enum
    {

        public int getOrder()
        {
            return m_Order;
        //    0    0:aload_0         
        //    1    1:getfield        #57  <Field int m_Order>
        //    2    4:ireturn         
        }

        public static final Level[] values()
        {
            Level alevel[];
            int i;
            Level alevel1[];
            System.arraycopy(alevel = ENUM$VALUES, 0, alevel1 = new Level[i = alevel.length], 0, i);
        //    0    0:getstatic       #50  <Field Logger$Level[] ENUM$VALUES>
        //    1    3:dup             
        //    2    4:astore_0        
        //    3    5:iconst_0        
        //    4    6:aload_0         
        //    5    7:arraylength     
        //    6    8:dup             
        //    7    9:istore_1        
        //    8   10:anewarray       Level[]
        //    9   13:dup             
        //   10   14:astore_2        
        //   11   15:iconst_0        
        //   12   16:iload_1         
        //   13   17:invokestatic    #69  <Method void System.arraycopy(Object, int, Object, int, int)>
            return alevel1;
        //   14   20:aload_2         
        //   15   21:areturn         
        }

        public static final Level valueOf(String s)
        {
            Level alevel[];
            Level level;
            for(int i = (alevel = ENUM$VALUES).length; --i >= 0;)
        //*   0    0:getstatic       #50  <Field Logger$Level[] ENUM$VALUES>
        //*   1    3:dup             
        //*   2    4:astore_1        
        //*   3    5:arraylength     
        //*   4    6:istore_2        
        //*   5    7:goto            27
                if(s.equals((level = alevel[i]).name()))
        //*   6   10:aload_0         
        //*   7   11:aload_1         
        //*   8   12:iload_2         
        //*   9   13:aaload          
        //*  10   14:dup             
        //*  11   15:astore_3        
        //*  12   16:invokevirtual   #75  <Method String name()>
        //*  13   19:invokevirtual   #81  <Method boolean String.equals(Object)>
        //*  14   22:ifeq            27
                    return level;
        //   15   25:aload_3         
        //   16   26:areturn         

        //   17   27:iinc            2  -1
        //   18   30:iload_2         
        //   19   31:ifge            10
            throw new IllegalArgumentException(s);
        //   20   34:new             #83  <Class IllegalArgumentException>
        //   21   37:dup             
        //   22   38:aload_0         
        //   23   39:invokespecial   #86  <Method void IllegalArgumentException(String)>
        //   24   42:athrow          
        }

        public static final Level ALL;
        public static final Level FINEST;
        public static final Level FINER;
        public static final Level FINE;
        public static final Level INFO;
        public static final Level WARNING;
        public static final Level SEVERE;
        public static final Level OFF;
        private int m_Order;
        private static final Level ENUM$VALUES[];

        static 
        {
            ALL = new Level("ALL", 0, 0);
        //    0    0:new             #2   <Class Logger$Level>
        //    1    3:dup             
        //    2    4:ldc1            #21  <String "ALL">
        //    3    6:iconst_0        
        //    4    7:iconst_0        
        //    5    8:invokespecial   #25  <Method void Logger$Level(String, int, int)>
        //    6   11:putstatic       #27  <Field Logger$Level ALL>
            FINEST = new Level("FINEST", 1, 1);
        //    7   14:new             #2   <Class Logger$Level>
        //    8   17:dup             
        //    9   18:ldc1            #28  <String "FINEST">
        //   10   20:iconst_1        
        //   11   21:iconst_1        
        //   12   22:invokespecial   #25  <Method void Logger$Level(String, int, int)>
        //   13   25:putstatic       #30  <Field Logger$Level FINEST>
            FINER = new Level("FINER", 2, 2);
        //   14   28:new             #2   <Class Logger$Level>
        //   15   31:dup             
        //   16   32:ldc1            #31  <String "FINER">
        //   17   34:iconst_2        
        //   18   35:iconst_2        
        //   19   36:invokespecial   #25  <Method void Logger$Level(String, int, int)>
        //   20   39:putstatic       #33  <Field Logger$Level FINER>
            FINE = new Level("FINE", 3, 3);
        //   21   42:new             #2   <Class Logger$Level>
        //   22   45:dup             
        //   23   46:ldc1            #34  <String "FINE">
        //   24   48:iconst_3        
        //   25   49:iconst_3        
        //   26   50:invokespecial   #25  <Method void Logger$Level(String, int, int)>
        //   27   53:putstatic       #36  <Field Logger$Level FINE>
            INFO = new Level("INFO", 4, 4);
        //   28   56:new             #2   <Class Logger$Level>
        //   29   59:dup             
        //   30   60:ldc1            #37  <String "INFO">
        //   31   62:iconst_4        
        //   32   63:iconst_4        
        //   33   64:invokespecial   #25  <Method void Logger$Level(String, int, int)>
        //   34   67:putstatic       #39  <Field Logger$Level INFO>
            WARNING = new Level("WARNING", 5, 5);
        //   35   70:new             #2   <Class Logger$Level>
        //   36   73:dup             
        //   37   74:ldc1            #40  <String "WARNING">
        //   38   76:iconst_5        
        //   39   77:iconst_5        
        //   40   78:invokespecial   #25  <Method void Logger$Level(String, int, int)>
        //   41   81:putstatic       #42  <Field Logger$Level WARNING>
            SEVERE = new Level("SEVERE", 6, 6);
        //   42   84:new             #2   <Class Logger$Level>
        //   43   87:dup             
        //   44   88:ldc1            #43  <String "SEVERE">
        //   45   90:bipush          6
        //   46   92:bipush          6
        //   47   94:invokespecial   #25  <Method void Logger$Level(String, int, int)>
        //   48   97:putstatic       #45  <Field Logger$Level SEVERE>
            OFF = new Level("OFF", 7, 10);
        //   49  100:new             #2   <Class Logger$Level>
        //   50  103:dup             
        //   51  104:ldc1            #46  <String "OFF">
        //   52  106:bipush          7
        //   53  108:bipush          10
        //   54  110:invokespecial   #25  <Method void Logger$Level(String, int, int)>
        //   55  113:putstatic       #48  <Field Logger$Level OFF>
            ENUM$VALUES = (new Level[] {
                ALL, FINEST, FINER, FINE, INFO, WARNING, SEVERE, OFF
            });
        //   56  116:bipush          8
        //   57  118:anewarray       Level[]
        //   58  121:dup             
        //   59  122:iconst_0        
        //   60  123:getstatic       #27  <Field Logger$Level ALL>
        //   61  126:aastore         
        //   62  127:dup             
        //   63  128:iconst_1        
        //   64  129:getstatic       #30  <Field Logger$Level FINEST>
        //   65  132:aastore         
        //   66  133:dup             
        //   67  134:iconst_2        
        //   68  135:getstatic       #33  <Field Logger$Level FINER>
        //   69  138:aastore         
        //   70  139:dup             
        //   71  140:iconst_3        
        //   72  141:getstatic       #36  <Field Logger$Level FINE>
        //   73  144:aastore         
        //   74  145:dup             
        //   75  146:iconst_4        
        //   76  147:getstatic       #39  <Field Logger$Level INFO>
        //   77  150:aastore         
        //   78  151:dup             
        //   79  152:iconst_5        
        //   80  153:getstatic       #42  <Field Logger$Level WARNING>
        //   81  156:aastore         
        //   82  157:dup             
        //   83  158:bipush          6
        //   84  160:getstatic       #45  <Field Logger$Level SEVERE>
        //   85  163:aastore         
        //   86  164:dup             
        //   87  165:bipush          7
        //   88  167:getstatic       #48  <Field Logger$Level OFF>
        //   89  170:aastore         
        //   90  171:putstatic       #50  <Field Logger$Level[] ENUM$VALUES>
        //*  91  174:return          
        }

        private Level(String s, int i, int order)
        {
            super(s, i);
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:iload_2         
        //    3    3:invokespecial   #55  <Method void Enum(String, int)>
            m_Order = order;
        //    4    6:aload_0         
        //    5    7:iload_3         
        //    6    8:putfield        #57  <Field int m_Order>
        //    7   11:return          
        }
    }


    public Logger()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #70  <Method void Object()>
        initialize();
    //    2    4:aload_0         
    //    3    5:invokevirtual   #73  <Method void initialize()>
    //    4    8:return          
    }

    protected void initialize()
    {
        m_MinLevel = Level.valueOf(m_Properties.getProperty("MinLevel", "INFO"));
    //    0    0:aload_0         
    //    1    1:getstatic       #32  <Field Properties m_Properties>
    //    2    4:ldc1            #76  <String "MinLevel">
    //    3    6:ldc1            #78  <String "INFO">
    //    4    8:invokevirtual   #82  <Method String Properties.getProperty(String, String)>
    //    5   11:invokestatic    #88  <Method Logger$Level Logger$Level.valueOf(String)>
    //    6   14:putfield        #90  <Field Logger$Level m_MinLevel>
    //    7   17:return          
    }

    public Level getMinLevel()
    {
        return m_MinLevel;
    //    0    0:aload_0         
    //    1    1:getfield        #90  <Field Logger$Level m_MinLevel>
    //    2    4:areturn         
    }

    protected static String[] getLocation()
    {
        String result[] = new String[3];
    //    0    0:iconst_3        
    //    1    1:anewarray       String[]
    //    2    4:astore_0        
        Throwable t = new Throwable();
    //    3    5:new             #98  <Class Throwable>
    //    4    8:dup             
    //    5    9:invokespecial   #99  <Method void Throwable()>
    //    6   12:astore_1        
        t.fillInStackTrace();
    //    7   13:aload_1         
    //    8   14:invokevirtual   #103 <Method Throwable Throwable.fillInStackTrace()>
    //    9   17:pop             
        StackTraceElement trace[] = t.getStackTrace();
    //   10   18:aload_1         
    //   11   19:invokevirtual   #107 <Method StackTraceElement[] Throwable.getStackTrace()>
    //   12   22:astore_2        
        for(int i = 0; i < trace.length; i++)
    //*  13   23:iconst_0        
    //*  14   24:istore_3        
    //*  15   25:goto            114
        {
            if(trace[i].getClassName().equals(rm/core/logging/Logger.getName()) || trace[i].getClassName().equals(rm/gui/LogPanel.getName()))
    //*  16   28:aload_2         
    //*  17   29:iload_3         
    //*  18   30:aaload          
    //*  19   31:invokevirtual   #112 <Method String StackTraceElement.getClassName()>
    //*  20   34:ldc1            #2   <Class Logger>
    //*  21   36:invokevirtual   #117 <Method String Class.getName()>
    //*  22   39:invokevirtual   #121 <Method boolean String.equals(Object)>
    //*  23   42:ifeq            48
    //*  24   45:goto            111
    //*  25   48:aload_2         
    //*  26   49:iload_3         
    //*  27   50:aaload          
    //*  28   51:invokevirtual   #112 <Method String StackTraceElement.getClassName()>
    //*  29   54:ldc1            #123 <Class LogPanel>
    //*  30   56:invokevirtual   #117 <Method String Class.getName()>
    //*  31   59:invokevirtual   #121 <Method boolean String.equals(Object)>
    //*  32   62:ifeq            68
                continue;
    //   33   65:goto            111
            result[0] = trace[i].getClassName();
    //   34   68:aload_0         
    //   35   69:iconst_0        
    //   36   70:aload_2         
    //   37   71:iload_3         
    //   38   72:aaload          
    //   39   73:invokevirtual   #112 <Method String StackTraceElement.getClassName()>
    //   40   76:aastore         
            result[1] = trace[i].getMethodName();
    //   41   77:aload_0         
    //   42   78:iconst_1        
    //   43   79:aload_2         
    //   44   80:iload_3         
    //   45   81:aaload          
    //   46   82:invokevirtual   #126 <Method String StackTraceElement.getMethodName()>
    //   47   85:aastore         
            result[2] = (new StringBuilder()).append(trace[i].getLineNumber()).toString();
    //   48   86:aload_0         
    //   49   87:iconst_2        
    //   50   88:new             #40  <Class StringBuilder>
    //   51   91:dup             
    //   52   92:invokespecial   #127 <Method void StringBuilder()>
    //   53   95:aload_2         
    //   54   96:iload_3         
    //   55   97:aaload          
    //   56   98:invokevirtual   #131 <Method int StackTraceElement.getLineNumber()>
    //   57  101:invokevirtual   #134 <Method StringBuilder StringBuilder.append(int)>
    //   58  104:invokevirtual   #54  <Method String StringBuilder.toString()>
    //   59  107:aastore         
            break;
    //   60  108:goto            120
        }

    //   61  111:iinc            3  1
    //   62  114:iload_3         
    //   63  115:aload_2         
    //   64  116:arraylength     
    //   65  117:icmplt          28
        return result;
    //   66  120:aload_0         
    //   67  121:areturn         
    }

    protected abstract void doLog(Level level, String s, String s1, String s2, int i);

    public static Logger getSingleton()
    {
        if(m_Singleton == null)
    //*   0    0:getstatic       #148 <Field Logger m_Singleton>
    //*   1    3:ifnonnull       64
        {
            String classname = m_Properties.getProperty("Logger", rm/core/logging/ConsoleLogger.getName());
    //    2    6:getstatic       #32  <Field Properties m_Properties>
    //    3    9:ldc1            #150 <String "Logger">
    //    4   11:ldc1            #152 <Class ConsoleLogger>
    //    5   13:invokevirtual   #117 <Method String Class.getName()>
    //    6   16:invokevirtual   #82  <Method String Properties.getProperty(String, String)>
    //    7   19:astore_0        
            try
            {
                m_Singleton = (Logger)(Logger)Class.forName(classname).newInstance();
    //    8   20:aload_0         
    //    9   21:invokestatic    #156 <Method Class Class.forName(String)>
    //   10   24:invokevirtual   #160 <Method Object Class.newInstance()>
    //   11   27:checkcast       #2   <Class Logger>
    //   12   30:checkcast       #2   <Class Logger>
    //   13   33:putstatic       #148 <Field Logger m_Singleton>
            }
    //*  14   36:goto            44
            catch(Exception e)
    //*  15   39:astore_1        
            {
                e.printStackTrace();
    //   16   40:aload_1         
    //   17   41:invokevirtual   #163 <Method void Exception.printStackTrace()>
            }
            m_DateFormat = new SimpleDateFormat(m_Properties.getProperty("DateFormat", "yyyy-MM-dd HH:mm:ss"));
    //   18   44:new             #165 <Class SimpleDateFormat>
    //   19   47:dup             
    //   20   48:getstatic       #32  <Field Properties m_Properties>
    //   21   51:ldc1            #167 <String "DateFormat">
    //   22   53:ldc1            #169 <String "yyyy-MM-dd HH:mm:ss">
    //   23   55:invokevirtual   #82  <Method String Properties.getProperty(String, String)>
    //   24   58:invokespecial   #170 <Method void SimpleDateFormat(String)>
    //   25   61:putstatic       #172 <Field SimpleDateFormat m_DateFormat>
        }
        return m_Singleton;
    //   26   64:getstatic       #148 <Field Logger m_Singleton>
    //   27   67:areturn         
    }

    public static void log(Level level, String msg)
    {
label0:
        {
            Logger logger = getSingleton();
    //    0    0:invokestatic    #177 <Method Logger getSingleton()>
    //    1    3:astore_2        
            if(logger == null)
    //*   2    4:aload_2         
    //*   3    5:ifnonnull       9
                return;
    //    4    8:return          
            String location[];
            synchronized(logger)
    //*   5    9:aload_2         
    //*   6   10:dup             
    //*   7   11:astore          5
    //*   8   13:monitorenter    
            {
                boolean log = false;
    //    9   14:iconst_0        
    //   10   15:istore_3        
                if(logger.getMinLevel() == Level.ALL)
    //*  11   16:aload_2         
    //*  12   17:invokevirtual   #179 <Method Logger$Level getMinLevel()>
    //*  13   20:getstatic       #182 <Field Logger$Level Logger$Level.ALL>
    //*  14   23:if_acmpne       31
                    log = true;
    //   15   26:iconst_1        
    //   16   27:istore_3        
                else
    //*  17   28:goto            47
                if(level.getOrder() >= logger.getMinLevel().getOrder())
    //*  18   31:aload_0         
    //*  19   32:invokevirtual   #185 <Method int Logger$Level.getOrder()>
    //*  20   35:aload_2         
    //*  21   36:invokevirtual   #179 <Method Logger$Level getMinLevel()>
    //*  22   39:invokevirtual   #185 <Method int Logger$Level.getOrder()>
    //*  23   42:icmplt          47
                    log = true;
    //   24   45:iconst_1        
    //   25   46:istore_3        
                if(log)
                    break label0;
    //   26   47:iload_3         
    //   27   48:ifne            55
            }
    //   28   51:aload           5
    //   29   53:monitorexit     
    //   30   54:return          
    //   31   55:invokestatic    #187 <Method String[] getLocation()>
    //   32   58:astore          4
    //   33   60:aload_2         
    //   34   61:aload_0         
    //   35   62:aload_1         
    //   36   63:aload           4
    //   37   65:iconst_0        
    //   38   66:aaload          
    //   39   67:aload           4
    //   40   69:iconst_1        
    //   41   70:aaload          
    //   42   71:aload           4
    //   43   73:iconst_2        
    //   44   74:aaload          
    //   45   75:invokestatic    #193 <Method int Integer.parseInt(String)>
    //   46   78:invokevirtual   #195 <Method void doLog(Logger$Level, String, String, String, int)>
    //   47   81:aload           5
    //   48   83:monitorexit     
    //   49   84:goto            91
    //   50   87:aload           5
    //   51   89:monitorexit     
    //   52   90:athrow          
            return;
        }
        location = getLocation();
        logger.doLog(level, msg, location[0], location[1], Integer.parseInt(location[2]));
        logger1;
        JVM INSTR monitorexit ;
    //   53   91:return          
    }

    public static void log(Level level, Throwable t)
    {
        StringWriter swriter = new StringWriter();
    //    0    0:new             #203 <Class StringWriter>
    //    1    3:dup             
    //    2    4:invokespecial   #204 <Method void StringWriter()>
    //    3    7:astore_2        
        PrintWriter pwriter = new PrintWriter(swriter);
    //    4    8:new             #206 <Class PrintWriter>
    //    5   11:dup             
    //    6   12:aload_2         
    //    7   13:invokespecial   #209 <Method void PrintWriter(java.io.Writer)>
    //    8   16:astore_3        
        t.printStackTrace(pwriter);
    //    9   17:aload_1         
    //   10   18:aload_3         
    //   11   19:invokevirtual   #212 <Method void Throwable.printStackTrace(PrintWriter)>
        pwriter.close();
    //   12   22:aload_3         
    //   13   23:invokevirtual   #215 <Method void PrintWriter.close()>
        log(level, swriter.toString());
    //   14   26:aload_0         
    //   15   27:aload_2         
    //   16   28:invokevirtual   #216 <Method String StringWriter.toString()>
    //   17   31:invokestatic    #218 <Method void log(Logger$Level, String)>
    //   18   34:return          
    }

    public static final String PROPERTIES_FILE = "rm/core/logging/Logging.props";
    protected Level m_MinLevel;
    protected static Logger m_Singleton;
    protected static Properties m_Properties;
    protected static SimpleDateFormat m_DateFormat;
    static Class class$0;
    static Class class$1;
    static Class class$2;

    static 
    {
        try
        {
            m_Properties = Utils.readProperties("rm/core/logging/Logging.props");
    //    0    0:ldc1            #9   <String "rm/core/logging/Logging.props">
    //    1    2:invokestatic    #30  <Method Properties Utils.readProperties(String)>
    //    2    5:putstatic       #32  <Field Properties m_Properties>
        }
    //*   3    8:goto            44
        catch(Exception e)
    //*   4   11:astore_0        
        {
            System.err.println((new StringBuilder("Error reading the logging properties 'rm/core/logging/Logging.props': ")).append(e).toString());
    //    5   12:getstatic       #38  <Field PrintStream System.err>
    //    6   15:new             #40  <Class StringBuilder>
    //    7   18:dup             
    //    8   19:ldc1            #42  <String "Error reading the logging properties 'rm/core/logging/Logging.props': ">
    //    9   21:invokespecial   #46  <Method void StringBuilder(String)>
    //   10   24:aload_0         
    //   11   25:invokevirtual   #50  <Method StringBuilder StringBuilder.append(Object)>
    //   12   28:invokevirtual   #54  <Method String StringBuilder.toString()>
    //   13   31:invokevirtual   #59  <Method void PrintStream.println(String)>
            m_Properties = new Properties();
    //   14   34:new             #61  <Class Properties>
    //   15   37:dup             
    //   16   38:invokespecial   #63  <Method void Properties()>
    //   17   41:putstatic       #32  <Field Properties m_Properties>
        }
    //*  18   44:return          
    }
}
