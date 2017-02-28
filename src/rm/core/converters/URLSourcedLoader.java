// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   URLSourcedLoader.java

package rm.core.converters;


public interface URLSourcedLoader
{

    public abstract void setURL(String s)
        throws Exception;

    public abstract String retrieveURL();
}
