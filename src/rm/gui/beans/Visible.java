// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   Visible.java

package rm.gui.beans;


// Referenced classes of package rm.gui.beans:
//            BeanVisual

public interface Visible
{

    public abstract void useDefaultVisual();

    public abstract void setVisual(BeanVisual beanvisual);

    public abstract BeanVisual getVisual();
}
