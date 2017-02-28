// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   Drawable.java

package rm.core;


public interface Drawable
{

    public abstract int graphType();

    public abstract String graph()
        throws Exception;

    public static final int NOT_DRAWABLE = 0;
    public static final int TREE = 1;
    public static final int BayesNet = 2;
    public static final int Newick = 3;
}
