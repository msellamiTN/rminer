// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   Generate.java

package rm.generate;


public interface Generate
{

    public abstract void buildGeneraters()
        throws Exception;

    public abstract String getUPAString();
}
