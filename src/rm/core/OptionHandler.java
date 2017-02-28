// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   OptionHandler.java

package rm.core;

import java.util.Enumeration;

public interface OptionHandler
{

    public abstract Enumeration listOptions();

    public abstract void setOptions(String as[])
        throws Exception;

    public abstract String[] getOptions();
}
