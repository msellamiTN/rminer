// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   SplitEvaluator.java

package rm.experiment;

import java.io.Serializable;
import rm.core.Instances;

public interface SplitEvaluator
    extends Serializable
{

    public abstract void setAdditionalMeasures(String as[]);

    public abstract String[] getKeyNames();

    public abstract Object[] getKeyTypes();

    public abstract String[] getResultNames();

    public abstract Object[] getResultTypes();

    public abstract Object[] getKey();

    public abstract Object[] getResult(Instances instances, Instances instances1)
        throws Exception;

    public abstract String getRawResultOutput();
}
