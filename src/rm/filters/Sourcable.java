// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   Sourcable.java

package rm.filters;

import rm.core.Instances;

public interface Sourcable
{

    public abstract String toSource(String s, Instances instances)
        throws Exception;
}
