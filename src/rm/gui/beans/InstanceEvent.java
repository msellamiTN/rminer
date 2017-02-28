// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   InstanceEvent.java

package rm.gui.beans;

import java.util.EventObject;
import rm.core.Instance;
import rm.core.Instances;

public class InstanceEvent extends EventObject
{

    public InstanceEvent(Object source, Instance instance, int status)
    {
        super(source);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokespecial   #27  <Method void EventObject(Object)>
        m_instance = instance;
    //    3    5:aload_0         
    //    4    6:aload_2         
    //    5    7:putfield        #29  <Field Instance m_instance>
        m_status = status;
    //    6   10:aload_0         
    //    7   11:iload_3         
    //    8   12:putfield        #31  <Field int m_status>
    //    9   15:return          
    }

    public InstanceEvent(Object source, Instances structure)
    {
        super(source);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokespecial   #27  <Method void EventObject(Object)>
        m_structure = structure;
    //    3    5:aload_0         
    //    4    6:aload_2         
    //    5    7:putfield        #42  <Field Instances m_structure>
        m_status = 0;
    //    6   10:aload_0         
    //    7   11:iconst_0        
    //    8   12:putfield        #31  <Field int m_status>
    //    9   15:return          
    }

    public InstanceEvent(Object source)
    {
        super(source);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokespecial   #27  <Method void EventObject(Object)>
    //    3    5:return          
    }

    public Instance getInstance()
    {
        return m_instance;
    //    0    0:aload_0         
    //    1    1:getfield        #29  <Field Instance m_instance>
    //    2    4:areturn         
    }

    public void setInstance(Instance i)
    {
        m_instance = i;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #29  <Field Instance m_instance>
    //    3    5:return          
    }

    public int getStatus()
    {
        return m_status;
    //    0    0:aload_0         
    //    1    1:getfield        #31  <Field int m_status>
    //    2    4:ireturn         
    }

    public void setStatus(int s)
    {
        m_status = s;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #31  <Field int m_status>
    //    3    5:return          
    }

    public void setStructure(Instances structure)
    {
        m_structure = structure;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #42  <Field Instances m_structure>
        m_instance = null;
    //    3    5:aload_0         
    //    4    6:aconst_null     
    //    5    7:putfield        #29  <Field Instance m_instance>
        m_status = 0;
    //    6   10:aload_0         
    //    7   11:iconst_0        
    //    8   12:putfield        #31  <Field int m_status>
    //    9   15:return          
    }

    public Instances getStructure()
    {
        return m_structure;
    //    0    0:aload_0         
    //    1    1:getfield        #42  <Field Instances m_structure>
    //    2    4:areturn         
    }

    private static final long serialVersionUID = 0x54b9093556130dcaL;
    public static final int FORMAT_AVAILABLE = 0;
    public static final int INSTANCE_AVAILABLE = 1;
    public static final int BATCH_FINISHED = 2;
    private Instances m_structure;
    private Instance m_instance;
    private int m_status;
}
