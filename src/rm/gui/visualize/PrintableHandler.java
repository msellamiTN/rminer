// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   PrintableHandler.java

package rm.gui.visualize;

import java.util.Hashtable;

// Referenced classes of package rm.gui.visualize:
//            JComponentWriter

public interface PrintableHandler
{

    public abstract Hashtable getWriters();

    public abstract JComponentWriter getWriter(String s);

    public abstract void setSaveDialogTitle(String s);

    public abstract String getSaveDialogTitle();

    public abstract void setScale(double d, double d1);

    public abstract double getXScale();

    public abstract double getYScale();

    public abstract void saveComponent();
}
