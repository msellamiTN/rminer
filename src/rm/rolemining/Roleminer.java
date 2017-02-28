// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   Roleminer.java

package rm.rolemining;

import rm.core.Assignment;
import rm.core.Capabilities;

public interface Roleminer
{

    public abstract void buildRoleminers(Assignment assignment)
        throws Exception;

    public abstract Capabilities getCapabilities();

    public abstract Assignment generateRoles();
}
