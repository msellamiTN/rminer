// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   DataSource.java

package rm.gui.beans;


// Referenced classes of package rm.gui.beans:
//            DataSourceListener, InstanceListener

public interface DataSource
{

    public abstract void addDataSourceListener(DataSourceListener datasourcelistener);

    public abstract void removeDataSourceListener(DataSourceListener datasourcelistener);

    public abstract void addInstanceListener(InstanceListener instancelistener);

    public abstract void removeInstanceListener(InstanceListener instancelistener);
}
