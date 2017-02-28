// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   ResultListener.java

package rm.experiment;

import java.io.Serializable;

// Referenced classes of package rm.experiment:
//            ResultProducer

public interface ResultListener
    extends Serializable
{

    public abstract String[] determineColumnConstraints(ResultProducer resultproducer)
        throws Exception;

    public abstract void preProcess(ResultProducer resultproducer)
        throws Exception;

    public abstract void postProcess(ResultProducer resultproducer)
        throws Exception;

    public abstract void acceptResult(ResultProducer resultproducer, Object aobj[], Object aobj1[])
        throws Exception;

    public abstract boolean isResultRequired(ResultProducer resultproducer, Object aobj[])
        throws Exception;
}
