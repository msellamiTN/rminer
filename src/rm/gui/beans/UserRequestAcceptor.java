// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   UserRequestAcceptor.java

package rm.gui.beans;

import java.util.Enumeration;

public interface UserRequestAcceptor
{

    public abstract Enumeration enumerateRequests();

    public abstract void performRequest(String s);
}
