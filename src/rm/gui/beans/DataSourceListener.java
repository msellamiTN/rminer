// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   DataSourceListener.java

package rm.gui.beans;

import java.util.EventListener;

// Referenced classes of package rm.gui.beans:
//            DataSetEvent

public interface DataSourceListener
    extends EventListener
{

    public abstract void acceptDataSet(DataSetEvent datasetevent);
}
