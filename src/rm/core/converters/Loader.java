// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   Loader.java

package rm.core.converters;

import java.io.*;
import rm.core.Instance;
import rm.core.Instances;

public interface Loader
    extends Serializable
{

    public abstract void reset()
        throws Exception;

    public abstract void setSource(File file)
        throws IOException;

    public abstract void setSource(InputStream inputstream)
        throws IOException;

    public abstract Instances getStructure()
        throws IOException;

    public abstract Instances getDataSet()
        throws IOException;

    public abstract Instance getNextInstance(Instances instances)
        throws IOException;
}
