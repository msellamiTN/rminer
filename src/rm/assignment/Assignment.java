// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   Assignment.java

package rm.assignment;

import rm.core.Capabilities;

public interface Assignment
{

    public abstract void buildAssigns(rm.core.Assignment assignment, rm.core.Assignment assignment1)
        throws Exception;

    public abstract Capabilities getCapabilities();

    public abstract rm.core.Assignment generateUA();
}
