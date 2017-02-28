// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   AdditionalMeasureProducer.java

package rm.core;

import java.util.Enumeration;

public interface AdditionalMeasureProducer
{

    public abstract Enumeration enumerateMeasures();

    public abstract double getMeasure(String s);
}
