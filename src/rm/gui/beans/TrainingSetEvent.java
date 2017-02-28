// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   TrainingSetEvent.java

package rm.gui.beans;

import java.util.EventObject;
import rm.core.Instances;

public class TrainingSetEvent extends EventObject
{

    public TrainingSetEvent(Object source, Instances trainSet)
    {
        super(source);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokespecial   #24  <Method void EventObject(Object)>
        m_runNumber = 1;
    //    3    5:aload_0         
    //    4    6:iconst_1        
    //    5    7:putfield        #26  <Field int m_runNumber>
        m_maxRunNumber = 1;
    //    6   10:aload_0         
    //    7   11:iconst_1        
    //    8   12:putfield        #28  <Field int m_maxRunNumber>
        m_trainingSet = trainSet;
    //    9   15:aload_0         
    //   10   16:aload_2         
    //   11   17:putfield        #30  <Field Instances m_trainingSet>
        if(m_trainingSet != null && m_trainingSet.numInstances() == 0)
    //*  12   20:aload_0         
    //*  13   21:getfield        #30  <Field Instances m_trainingSet>
    //*  14   24:ifnull          42
    //*  15   27:aload_0         
    //*  16   28:getfield        #30  <Field Instances m_trainingSet>
    //*  17   31:invokevirtual   #36  <Method int Instances.numInstances()>
    //*  18   34:ifne            42
            m_structureOnly = true;
    //   19   37:aload_0         
    //   20   38:iconst_1        
    //   21   39:putfield        #38  <Field boolean m_structureOnly>
    //   22   42:return          
    }

    public TrainingSetEvent(Object source, Instances trainSet, int setNum, int maxSetNum)
    {
        this(source, trainSet);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:aload_2         
    //    3    3:invokespecial   #48  <Method void TrainingSetEvent(Object, Instances)>
        m_setNumber = setNum;
    //    4    6:aload_0         
    //    5    7:iload_3         
    //    6    8:putfield        #50  <Field int m_setNumber>
        m_maxSetNumber = maxSetNum;
    //    7   11:aload_0         
    //    8   12:iload           4
    //    9   14:putfield        #52  <Field int m_maxSetNumber>
    //   10   17:return          
    }

    public TrainingSetEvent(Object source, Instances trainSet, int runNum, int maxRunNum, int setNum, int maxSetNum)
    {
        this(source, trainSet, setNum, maxSetNum);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:aload_2         
    //    3    3:iload           5
    //    4    5:iload           6
    //    5    7:invokespecial   #57  <Method void TrainingSetEvent(Object, Instances, int, int)>
        m_runNumber = runNum;
    //    6   10:aload_0         
    //    7   11:iload_3         
    //    8   12:putfield        #26  <Field int m_runNumber>
        m_maxRunNumber = maxRunNum;
    //    9   15:aload_0         
    //   10   16:iload           4
    //   11   18:putfield        #28  <Field int m_maxRunNumber>
    //   12   21:return          
    }

    public Instances getTrainingSet()
    {
        return m_trainingSet;
    //    0    0:aload_0         
    //    1    1:getfield        #30  <Field Instances m_trainingSet>
    //    2    4:areturn         
    }

    public int getRunNumber()
    {
        return m_runNumber;
    //    0    0:aload_0         
    //    1    1:getfield        #26  <Field int m_runNumber>
    //    2    4:ireturn         
    }

    public int getMaxRunNumber()
    {
        return m_maxRunNumber;
    //    0    0:aload_0         
    //    1    1:getfield        #28  <Field int m_maxRunNumber>
    //    2    4:ireturn         
    }

    public int getSetNumber()
    {
        return m_setNumber;
    //    0    0:aload_0         
    //    1    1:getfield        #50  <Field int m_setNumber>
    //    2    4:ireturn         
    }

    public int getMaxSetNumber()
    {
        return m_maxSetNumber;
    //    0    0:aload_0         
    //    1    1:getfield        #52  <Field int m_maxSetNumber>
    //    2    4:ireturn         
    }

    public boolean isStructureOnly()
    {
        return m_structureOnly;
    //    0    0:aload_0         
    //    1    1:getfield        #38  <Field boolean m_structureOnly>
    //    2    4:ireturn         
    }

    private static final long serialVersionUID = 0x517ec19575f34d56L;
    protected Instances m_trainingSet;
    private boolean m_structureOnly;
    protected int m_runNumber;
    protected int m_maxRunNumber;
    protected int m_setNumber;
    protected int m_maxSetNumber;
}
