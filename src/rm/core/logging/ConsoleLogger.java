// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   ConsoleLogger.java

package rm.core.logging;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

// Referenced classes of package rm.core.logging:
//            Logger

public class ConsoleLogger extends Logger
{

    public ConsoleLogger()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #9   <Method void Logger()>
    //    2    4:return          
    }

    protected void doLog(Logger.Level level, String msg, String cls, String method, int lineno)
    {
        System.err.println((new StringBuilder(String.valueOf(Logger.m_DateFormat.format(new Date())))).append(" ").append(cls).append(" ").append(method).append("\n").append(level).append(": ").append(msg).toString());
    //    0    0:getstatic       #21  <Field PrintStream System.err>
    //    1    3:new             #23  <Class StringBuilder>
    //    2    6:dup             
    //    3    7:getstatic       #27  <Field SimpleDateFormat Logger.m_DateFormat>
    //    4   10:new             #29  <Class Date>
    //    5   13:dup             
    //    6   14:invokespecial   #30  <Method void Date()>
    //    7   17:invokevirtual   #36  <Method String SimpleDateFormat.format(Date)>
    //    8   20:invokestatic    #42  <Method String String.valueOf(Object)>
    //    9   23:invokespecial   #45  <Method void StringBuilder(String)>
    //   10   26:ldc1            #47  <String " ">
    //   11   28:invokevirtual   #51  <Method StringBuilder StringBuilder.append(String)>
    //   12   31:aload_3         
    //   13   32:invokevirtual   #51  <Method StringBuilder StringBuilder.append(String)>
    //   14   35:ldc1            #47  <String " ">
    //   15   37:invokevirtual   #51  <Method StringBuilder StringBuilder.append(String)>
    //   16   40:aload           4
    //   17   42:invokevirtual   #51  <Method StringBuilder StringBuilder.append(String)>
    //   18   45:ldc1            #53  <String "\n">
    //   19   47:invokevirtual   #51  <Method StringBuilder StringBuilder.append(String)>
    //   20   50:aload_1         
    //   21   51:invokevirtual   #56  <Method StringBuilder StringBuilder.append(Object)>
    //   22   54:ldc1            #58  <String ": ">
    //   23   56:invokevirtual   #51  <Method StringBuilder StringBuilder.append(String)>
    //   24   59:aload_2         
    //   25   60:invokevirtual   #51  <Method StringBuilder StringBuilder.append(String)>
    //   26   63:invokevirtual   #62  <Method String StringBuilder.toString()>
    //   27   66:invokevirtual   #67  <Method void PrintStream.println(String)>
    //   28   69:return          
    }
}
