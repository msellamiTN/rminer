// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   Memory.java

package rm.core;

import java.io.PrintStream;
import javax.swing.JOptionPane;

// Referenced classes of package rm.core:
//            Utils

public class Memory
{

    public Memory()
    {
        this(false);
    //    0    0:aload_0         
    //    1    1:iconst_0        
    //    2    2:invokespecial   #36  <Method void Memory(boolean)>
    //    3    5:return          
    }

    public Memory(boolean useGUI)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #40  <Method void Object()>
        m_UseGUI = false;
    //    2    4:aload_0         
    //    3    5:iconst_0        
    //    4    6:putfield        #42  <Field boolean m_UseGUI>
        m_UseGUI = useGUI;
    //    5    9:aload_0         
    //    6   10:iload_1         
    //    7   11:putfield        #42  <Field boolean m_UseGUI>
        m_Runtime = Runtime.getRuntime();
    //    8   14:aload_0         
    //    9   15:invokestatic    #24  <Method Runtime Runtime.getRuntime()>
    //   10   18:putfield        #44  <Field Runtime m_Runtime>
        m_Max = m_Runtime.maxMemory();
    //   11   21:aload_0         
    //   12   22:aload_0         
    //   13   23:getfield        #44  <Field Runtime m_Runtime>
    //   14   26:invokevirtual   #47  <Method long Runtime.maxMemory()>
    //   15   29:putfield        #49  <Field long m_Max>
        m_Total = m_Runtime.totalMemory();
    //   16   32:aload_0         
    //   17   33:aload_0         
    //   18   34:getfield        #44  <Field Runtime m_Runtime>
    //   19   37:invokevirtual   #28  <Method long Runtime.totalMemory()>
    //   20   40:putfield        #51  <Field long m_Total>
    //   21   43:return          
    }

    public boolean isEnabled()
    {
        return m_Enabled;
    //    0    0:getstatic       #18  <Field boolean m_Enabled>
    //    1    3:ireturn         
    }

    public void setEnabled(boolean value)
    {
        m_Enabled = value;
    //    0    0:iload_1         
    //    1    1:putstatic       #18  <Field boolean m_Enabled>
    //    2    4:return          
    }

    public boolean getUseGUI()
    {
        return m_UseGUI;
    //    0    0:aload_0         
    //    1    1:getfield        #42  <Field boolean m_UseGUI>
    //    2    4:ireturn         
    }

    public long getInitial()
    {
        return m_Initial;
    //    0    0:getstatic       #30  <Field long m_Initial>
    //    1    3:lreturn         
    }

    public long getCurrent()
    {
        m_Runtime = Runtime.getRuntime();
    //    0    0:aload_0         
    //    1    1:invokestatic    #24  <Method Runtime Runtime.getRuntime()>
    //    2    4:putfield        #44  <Field Runtime m_Runtime>
        m_Total = m_Runtime.totalMemory();
    //    3    7:aload_0         
    //    4    8:aload_0         
    //    5    9:getfield        #44  <Field Runtime m_Runtime>
    //    6   12:invokevirtual   #28  <Method long Runtime.totalMemory()>
    //    7   15:putfield        #51  <Field long m_Total>
        return m_Total;
    //    8   18:aload_0         
    //    9   19:getfield        #51  <Field long m_Total>
    //   10   22:lreturn         
    }

    public long getMax()
    {
        return m_Max;
    //    0    0:aload_0         
    //    1    1:getfield        #49  <Field long m_Max>
    //    2    4:lreturn         
    }

    public boolean isOutOfMemory()
    {
        if(isEnabled())
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #63  <Method boolean isEnabled()>
    //*   2    4:ifeq            32
            return getMax() - getCurrent() < getInitial() + 0x30d40L;
    //    3    7:aload_0         
    //    4    8:invokevirtual   #65  <Method long getMax()>
    //    5   11:aload_0         
    //    6   12:invokevirtual   #67  <Method long getCurrent()>
    //    7   15:lsub            
    //    8   16:aload_0         
    //    9   17:invokevirtual   #69  <Method long getInitial()>
    //   10   20:ldc2w           #70  <Long 0x30d40L>
    //   11   23:ladd            
    //   12   24:lcmp            
    //   13   25:ifge            30
    //   14   28:iconst_1        
    //   15   29:ireturn         
    //   16   30:iconst_0        
    //   17   31:ireturn         
        else
            return false;
    //   18   32:iconst_0        
    //   19   33:ireturn         
    }

    public static double toMegaByte(long bytes)
    {
        return (double)bytes / 1048576D;
    //    0    0:lload_0         
    //    1    1:l2d             
    //    2    2:ldc2w           #74  <Double 1048576D>
    //    3    5:ddiv            
    //    4    6:dreturn         
    }

    public void showOutOfMemory()
    {
        if(!isEnabled())
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #63  <Method boolean isEnabled()>
    //*   2    4:ifne            8
            return;
    //    3    7:return          
        System.gc();
    //    4    8:invokestatic    #82  <Method void System.gc()>
        String msg = (new StringBuilder("Not enough memory. Please load a smaller dataset or use larger heap size.\n- initial JVM size:   ")).append(Utils.doubleToString(toMegaByte(m_Initial), 1)).append("MB\n").append("- total memory used:  ").append(Utils.doubleToString(toMegaByte(m_Total), 1)).append("MB\n").append("- max. memory avail.: ").append(Utils.doubleToString(toMegaByte(m_Max), 1)).append("MB\n").append("\n").append("Note:\n").append("The Java heap size can be specified with the -Xmx option.\n").append("E.g., to use 128MB as heap size, the command line looks like this:\n").append("   java -Xmx128m -classpath ...\n").append("This does NOT work in the SimpleCLI, the java command refers\n").append("to the one with which Weka is started.").toString();
    //    5   11:new             #84  <Class StringBuilder>
    //    6   14:dup             
    //    7   15:ldc1            #86  <String "Not enough memory. Please load a smaller dataset or use larger heap size.\n- initial JVM size:   ">
    //    8   17:invokespecial   #89  <Method void StringBuilder(String)>
    //    9   20:getstatic       #30  <Field long m_Initial>
    //   10   23:invokestatic    #91  <Method double toMegaByte(long)>
    //   11   26:iconst_1        
    //   12   27:invokestatic    #97  <Method String Utils.doubleToString(double, int)>
    //   13   30:invokevirtual   #101 <Method StringBuilder StringBuilder.append(String)>
    //   14   33:ldc1            #103 <String "MB\n">
    //   15   35:invokevirtual   #101 <Method StringBuilder StringBuilder.append(String)>
    //   16   38:ldc1            #105 <String "- total memory used:  ">
    //   17   40:invokevirtual   #101 <Method StringBuilder StringBuilder.append(String)>
    //   18   43:aload_0         
    //   19   44:getfield        #51  <Field long m_Total>
    //   20   47:invokestatic    #91  <Method double toMegaByte(long)>
    //   21   50:iconst_1        
    //   22   51:invokestatic    #97  <Method String Utils.doubleToString(double, int)>
    //   23   54:invokevirtual   #101 <Method StringBuilder StringBuilder.append(String)>
    //   24   57:ldc1            #103 <String "MB\n">
    //   25   59:invokevirtual   #101 <Method StringBuilder StringBuilder.append(String)>
    //   26   62:ldc1            #107 <String "- max. memory avail.: ">
    //   27   64:invokevirtual   #101 <Method StringBuilder StringBuilder.append(String)>
    //   28   67:aload_0         
    //   29   68:getfield        #49  <Field long m_Max>
    //   30   71:invokestatic    #91  <Method double toMegaByte(long)>
    //   31   74:iconst_1        
    //   32   75:invokestatic    #97  <Method String Utils.doubleToString(double, int)>
    //   33   78:invokevirtual   #101 <Method StringBuilder StringBuilder.append(String)>
    //   34   81:ldc1            #103 <String "MB\n">
    //   35   83:invokevirtual   #101 <Method StringBuilder StringBuilder.append(String)>
    //   36   86:ldc1            #109 <String "\n">
    //   37   88:invokevirtual   #101 <Method StringBuilder StringBuilder.append(String)>
    //   38   91:ldc1            #111 <String "Note:\n">
    //   39   93:invokevirtual   #101 <Method StringBuilder StringBuilder.append(String)>
    //   40   96:ldc1            #113 <String "The Java heap size can be specified with the -Xmx option.\n">
    //   41   98:invokevirtual   #101 <Method StringBuilder StringBuilder.append(String)>
    //   42  101:ldc1            #115 <String "E.g., to use 128MB as heap size, the command line looks like this:\n">
    //   43  103:invokevirtual   #101 <Method StringBuilder StringBuilder.append(String)>
    //   44  106:ldc1            #117 <String "   java -Xmx128m -classpath ...\n">
    //   45  108:invokevirtual   #101 <Method StringBuilder StringBuilder.append(String)>
    //   46  111:ldc1            #119 <String "This does NOT work in the SimpleCLI, the java command refers\n">
    //   47  113:invokevirtual   #101 <Method StringBuilder StringBuilder.append(String)>
    //   48  116:ldc1            #121 <String "to the one with which Weka is started.">
    //   49  118:invokevirtual   #101 <Method StringBuilder StringBuilder.append(String)>
    //   50  121:invokevirtual   #125 <Method String StringBuilder.toString()>
    //   51  124:astore_1        
        System.err.println(msg);
    //   52  125:getstatic       #129 <Field PrintStream System.err>
    //   53  128:aload_1         
    //   54  129:invokevirtual   #134 <Method void PrintStream.println(String)>
        if(getUseGUI())
    //*  55  132:aload_0         
    //*  56  133:invokevirtual   #136 <Method boolean getUseGUI()>
    //*  57  136:ifeq            147
            JOptionPane.showMessageDialog(null, msg, "OutOfMemory", 2);
    //   58  139:aconst_null     
    //   59  140:aload_1         
    //   60  141:ldc1            #138 <String "OutOfMemory">
    //   61  143:iconst_2        
    //   62  144:invokestatic    #144 <Method void JOptionPane.showMessageDialog(java.awt.Component, Object, String, int)>
    //   63  147:return          
    }

    public void stopThreads()
    {
        Thread thGroup[] = new Thread[Thread.activeCount()];
    //    0    0:invokestatic    #153 <Method int Thread.activeCount()>
    //    1    3:anewarray       Thread[]
    //    2    6:astore_2        
        Thread.enumerate(thGroup);
    //    3    7:aload_2         
    //    4    8:invokestatic    #157 <Method int Thread.enumerate(Thread[])>
    //    5   11:pop             
        for(int i = 0; i < thGroup.length; i++)
    //*   6   12:iconst_0        
    //*   7   13:istore_1        
    //*   8   14:goto            70
        {
            Thread t = thGroup[i];
    //    9   17:aload_2         
    //   10   18:iload_1         
    //   11   19:aaload          
    //   12   20:astore_3        
            if(t != null && t != Thread.currentThread())
    //*  13   21:aload_3         
    //*  14   22:ifnull          67
    //*  15   25:aload_3         
    //*  16   26:invokestatic    #161 <Method Thread Thread.currentThread()>
    //*  17   29:if_acmpeq       67
                if(t.getName().startsWith("Thread"))
    //*  18   32:aload_3         
    //*  19   33:invokevirtual   #164 <Method String Thread.getName()>
    //*  20   36:ldc1            #166 <String "Thread">
    //*  21   38:invokevirtual   #172 <Method boolean String.startsWith(String)>
    //*  22   41:ifeq            51
                    t.stop();
    //   23   44:aload_3         
    //   24   45:invokevirtual   #175 <Method void Thread.stop()>
                else
    //*  25   48:goto            67
                if(t.getName().startsWith("AWT-EventQueue"))
    //*  26   51:aload_3         
    //*  27   52:invokevirtual   #164 <Method String Thread.getName()>
    //*  28   55:ldc1            #177 <String "AWT-EventQueue">
    //*  29   57:invokevirtual   #172 <Method boolean String.startsWith(String)>
    //*  30   60:ifeq            67
                    t.stop();
    //   31   63:aload_3         
    //   32   64:invokevirtual   #175 <Method void Thread.stop()>
        }

    //   33   67:iinc            1  1
    //   34   70:iload_1         
    //   35   71:aload_2         
    //   36   72:arraylength     
    //   37   73:icmplt          17
        thGroup = (Thread[])null;
    //   38   76:aconst_null     
    //   39   77:checkcast       #179 <Class Thread[]>
    //   40   80:astore_2        
        System.gc();
    //   41   81:invokestatic    #82  <Method void System.gc()>
    //   42   84:return          
    }

    public static void main(String args[])
    {
        Memory mem = new Memory();
    //    0    0:new             #2   <Class Memory>
    //    1    3:dup             
    //    2    4:invokespecial   #187 <Method void Memory()>
    //    3    7:astore_1        
        System.out.println((new StringBuilder("Initial memory: ")).append(Utils.doubleToString(toMegaByte(mem.getInitial()), 1)).append("MB").append(" (").append(mem.getInitial()).append(")").toString());
    //    4    8:getstatic       #190 <Field PrintStream System.out>
    //    5   11:new             #84  <Class StringBuilder>
    //    6   14:dup             
    //    7   15:ldc1            #192 <String "Initial memory: ">
    //    8   17:invokespecial   #89  <Method void StringBuilder(String)>
    //    9   20:aload_1         
    //   10   21:invokevirtual   #69  <Method long getInitial()>
    //   11   24:invokestatic    #91  <Method double toMegaByte(long)>
    //   12   27:iconst_1        
    //   13   28:invokestatic    #97  <Method String Utils.doubleToString(double, int)>
    //   14   31:invokevirtual   #101 <Method StringBuilder StringBuilder.append(String)>
    //   15   34:ldc1            #194 <String "MB">
    //   16   36:invokevirtual   #101 <Method StringBuilder StringBuilder.append(String)>
    //   17   39:ldc1            #196 <String " (">
    //   18   41:invokevirtual   #101 <Method StringBuilder StringBuilder.append(String)>
    //   19   44:aload_1         
    //   20   45:invokevirtual   #69  <Method long getInitial()>
    //   21   48:invokevirtual   #199 <Method StringBuilder StringBuilder.append(long)>
    //   22   51:ldc1            #201 <String ")">
    //   23   53:invokevirtual   #101 <Method StringBuilder StringBuilder.append(String)>
    //   24   56:invokevirtual   #125 <Method String StringBuilder.toString()>
    //   25   59:invokevirtual   #134 <Method void PrintStream.println(String)>
        System.out.println((new StringBuilder("Max memory: ")).append(Utils.doubleToString(toMegaByte(mem.getMax()), 1)).append("MB").append(" (").append(mem.getMax()).append(")").toString());
    //   26   62:getstatic       #190 <Field PrintStream System.out>
    //   27   65:new             #84  <Class StringBuilder>
    //   28   68:dup             
    //   29   69:ldc1            #203 <String "Max memory: ">
    //   30   71:invokespecial   #89  <Method void StringBuilder(String)>
    //   31   74:aload_1         
    //   32   75:invokevirtual   #65  <Method long getMax()>
    //   33   78:invokestatic    #91  <Method double toMegaByte(long)>
    //   34   81:iconst_1        
    //   35   82:invokestatic    #97  <Method String Utils.doubleToString(double, int)>
    //   36   85:invokevirtual   #101 <Method StringBuilder StringBuilder.append(String)>
    //   37   88:ldc1            #194 <String "MB">
    //   38   90:invokevirtual   #101 <Method StringBuilder StringBuilder.append(String)>
    //   39   93:ldc1            #196 <String " (">
    //   40   95:invokevirtual   #101 <Method StringBuilder StringBuilder.append(String)>
    //   41   98:aload_1         
    //   42   99:invokevirtual   #65  <Method long getMax()>
    //   43  102:invokevirtual   #199 <Method StringBuilder StringBuilder.append(long)>
    //   44  105:ldc1            #201 <String ")">
    //   45  107:invokevirtual   #101 <Method StringBuilder StringBuilder.append(String)>
    //   46  110:invokevirtual   #125 <Method String StringBuilder.toString()>
    //   47  113:invokevirtual   #134 <Method void PrintStream.println(String)>
    //   48  116:return          
    }

    protected static boolean m_Enabled = true;
    protected boolean m_UseGUI;
    protected static long m_Initial = Runtime.getRuntime().totalMemory();
    protected long m_Total;
    protected long m_Max;
    protected Runtime m_Runtime;

    static 
    {
    //    0    0:iconst_1        
    //    1    1:putstatic       #18  <Field boolean m_Enabled>
    //    2    4:invokestatic    #24  <Method Runtime Runtime.getRuntime()>
    //    3    7:invokevirtual   #28  <Method long Runtime.totalMemory()>
    //    4   10:putstatic       #30  <Field long m_Initial>
    //*   5   13:return          
    }
}
