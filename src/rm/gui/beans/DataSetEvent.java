// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   DataSetEvent.java

package rm.gui.beans;

import java.util.EventObject;
import rm.core.Instances;

public class DataSetEvent extends EventObject
{

    public DataSetEvent(Object source, Instances dataSet)
    {
        super(source);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokespecial   #19  <Method void EventObject(Object)>
        m_dataSet = dataSet;
    //    3    5:aload_0         
    //    4    6:aload_2         
    //    5    7:putfield        #21  <Field Instances m_dataSet>
        if(m_dataSet != null && m_dataSet.numInstances() == 0)
    //*   6   10:aload_0         
    //*   7   11:getfield        #21  <Field Instances m_dataSet>
    //*   8   14:ifnull          32
    //*   9   17:aload_0         
    //*  10   18:getfield        #21  <Field Instances m_dataSet>
    //*  11   21:invokevirtual   #27  <Method int Instances.numInstances()>
    //*  12   24:ifne            32
            m_structureOnly = true;
    //   13   27:aload_0         
    //   14   28:iconst_1        
    //   15   29:putfield        #29  <Field boolean m_structureOnly>
    //   16   32:return          
    }

    public Instances getDataSet()
    {
        return m_dataSet;
    //    0    0:aload_0         
    //    1    1:getfield        #21  <Field Instances m_dataSet>
    //    2    4:areturn         
    }

    public boolean isStructureOnly()
    {
        return m_structureOnly;
    //    0    0:aload_0         
    //    1    1:getfield        #29  <Field boolean m_structureOnly>
    //    2    4:ireturn         
    }

    private static final long serialVersionUID = 0xb9114de6febafd57L;
    private Instances m_dataSet;
    private boolean m_structureOnly;
}
