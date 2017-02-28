// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   VisualizePanelEvent.java

package rm.gui.visualize;

import rm.core.FastVector;
import rm.core.Instances;

public class VisualizePanelEvent
{

    public VisualizePanelEvent(FastVector ar, Instances i, Instances i2, int at1, int at2)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #42  <Method void Object()>
        m_values = ar;
    //    2    4:aload_0         
    //    3    5:aload_1         
    //    4    6:putfield        #44  <Field FastVector m_values>
        m_inst = i;
    //    5    9:aload_0         
    //    6   10:aload_2         
    //    7   11:putfield        #46  <Field Instances m_inst>
        m_inst2 = i2;
    //    8   14:aload_0         
    //    9   15:aload_3         
    //   10   16:putfield        #48  <Field Instances m_inst2>
        m_attrib1 = at1;
    //   11   19:aload_0         
    //   12   20:iload           4
    //   13   22:putfield        #50  <Field int m_attrib1>
        m_attrib2 = at2;
    //   14   25:aload_0         
    //   15   26:iload           5
    //   16   28:putfield        #52  <Field int m_attrib2>
    //   17   31:return          
    }

    public FastVector getValues()
    {
        return m_values;
    //    0    0:aload_0         
    //    1    1:getfield        #44  <Field FastVector m_values>
    //    2    4:areturn         
    }

    public Instances getInstances1()
    {
        return m_inst;
    //    0    0:aload_0         
    //    1    1:getfield        #46  <Field Instances m_inst>
    //    2    4:areturn         
    }

    public Instances getInstances2()
    {
        return m_inst2;
    //    0    0:aload_0         
    //    1    1:getfield        #48  <Field Instances m_inst2>
    //    2    4:areturn         
    }

    public int getAttribute1()
    {
        return m_attrib1;
    //    0    0:aload_0         
    //    1    1:getfield        #50  <Field int m_attrib1>
    //    2    4:ireturn         
    }

    public int getAttribute2()
    {
        return m_attrib2;
    //    0    0:aload_0         
    //    1    1:getfield        #52  <Field int m_attrib2>
    //    2    4:ireturn         
    }

    public static int NONE = 0;
    public static int RECTANGLE = 1;
    public static int OVAL = 2;
    public static int POLYGON = 3;
    public static int LINE = 4;
    public static int VLINE = 5;
    public static int HLINE = 6;
    private FastVector m_values;
    private Instances m_inst;
    private Instances m_inst2;
    private int m_attrib1;
    private int m_attrib2;

    static 
    {
    //    0    0:iconst_0        
    //    1    1:putstatic       #24  <Field int NONE>
    //    2    4:iconst_1        
    //    3    5:putstatic       #26  <Field int RECTANGLE>
    //    4    8:iconst_2        
    //    5    9:putstatic       #28  <Field int OVAL>
    //    6   12:iconst_3        
    //    7   13:putstatic       #30  <Field int POLYGON>
    //    8   16:iconst_4        
    //    9   17:putstatic       #32  <Field int LINE>
    //   10   20:iconst_5        
    //   11   21:putstatic       #34  <Field int VLINE>
    //   12   24:bipush          6
    //   13   26:putstatic       #36  <Field int HLINE>
    //*  14   29:return          
    }
}
