// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   SysErrLog.java

package rm.gui;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

// Referenced classes of package rm.gui:
//            Logger

public class SysErrLog
    implements Logger
{

    public SysErrLog()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #11  <Method void Object()>
    //    2    4:return          
    }

    protected static String getTimestamp()
    {
        return (new SimpleDateFormat("yyyy.MM.dd hh:mm:ss")).format(new Date());
    //    0    0:new             #19  <Class SimpleDateFormat>
    //    1    3:dup             
    //    2    4:ldc1            #21  <String "yyyy.MM.dd hh:mm:ss">
    //    3    6:invokespecial   #24  <Method void SimpleDateFormat(String)>
    //    4    9:new             #26  <Class Date>
    //    5   12:dup             
    //    6   13:invokespecial   #27  <Method void Date()>
    //    7   16:invokevirtual   #31  <Method String SimpleDateFormat.format(Date)>
    //    8   19:areturn         
    }

    public void logMessage(String message)
    {
        System.err.println((new StringBuilder("LOG ")).append(getTimestamp()).append(": ").append(message).toString());
    //    0    0:getstatic       #38  <Field PrintStream System.err>
    //    1    3:new             #40  <Class StringBuilder>
    //    2    6:dup             
    //    3    7:ldc1            #42  <String "LOG ">
    //    4    9:invokespecial   #43  <Method void StringBuilder(String)>
    //    5   12:invokestatic    #45  <Method String getTimestamp()>
    //    6   15:invokevirtual   #49  <Method StringBuilder StringBuilder.append(String)>
    //    7   18:ldc1            #51  <String ": ">
    //    8   20:invokevirtual   #49  <Method StringBuilder StringBuilder.append(String)>
    //    9   23:aload_1         
    //   10   24:invokevirtual   #49  <Method StringBuilder StringBuilder.append(String)>
    //   11   27:invokevirtual   #54  <Method String StringBuilder.toString()>
    //   12   30:invokevirtual   #59  <Method void PrintStream.println(String)>
    //   13   33:return          
    }

    public void statusMessage(String message)
    {
        System.err.println((new StringBuilder("STATUS: ")).append(message).toString());
    //    0    0:getstatic       #38  <Field PrintStream System.err>
    //    1    3:new             #40  <Class StringBuilder>
    //    2    6:dup             
    //    3    7:ldc1            #64  <String "STATUS: ">
    //    4    9:invokespecial   #43  <Method void StringBuilder(String)>
    //    5   12:aload_1         
    //    6   13:invokevirtual   #49  <Method StringBuilder StringBuilder.append(String)>
    //    7   16:invokevirtual   #54  <Method String StringBuilder.toString()>
    //    8   19:invokevirtual   #59  <Method void PrintStream.println(String)>
    //    9   22:return          
    }
}
