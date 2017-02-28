// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   ResultProducer.java

package rm.experiment;

import java.io.Serializable;
import rm.core.Instances;

// Referenced classes of package rm.experiment:
//            ResultListener

public interface ResultProducer
    extends Serializable
{

    public abstract void setInstances(Instances instances);

    public abstract void setResultListener(ResultListener resultlistener);

    public abstract void setAdditionalMeasures(String as[]);

    public abstract void preProcess()
        throws Exception;

    public abstract void postProcess()
        throws Exception;

    public abstract void doRun(int i)
        throws Exception;

    public abstract void doRunKeys(int i)
        throws Exception;

    public abstract String[] getKeyNames()
        throws Exception;

    public abstract Object[] getKeyTypes()
        throws Exception;

    public abstract String[] getResultNames()
        throws Exception;

    public abstract Object[] getResultTypes()
        throws Exception;

    public abstract String getCompatibilityState();
}
