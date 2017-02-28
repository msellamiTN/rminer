// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   InstanceListener.java

package rm.gui.beans;

import java.util.EventListener;

// Referenced classes of package rm.gui.beans:
//            InstanceEvent

public interface InstanceListener
    extends EventListener
{

    public abstract void acceptInstance(InstanceEvent instanceevent);
}
