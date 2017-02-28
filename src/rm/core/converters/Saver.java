// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   Saver.java

package rm.core.converters;

import java.io.*;
import rm.core.*;

public interface Saver
    extends Serializable
{

    public abstract void setDestination(File file)
        throws IOException;

    public abstract void setDestination(OutputStream outputstream)
        throws IOException;

    public abstract void setRetrieval(int i);

    public abstract String getFileExtension()
        throws Exception;

    public abstract void setFile(File file)
        throws IOException;

    public abstract void setFilePrefix(String s)
        throws Exception;

    public abstract String filePrefix()
        throws Exception;

    public abstract void setDir(String s)
        throws IOException;

    public abstract void setDirAndPrefix(String s, String s1)
        throws IOException;

    public abstract String retrieveDir()
        throws IOException;

    public abstract void setAssignment(Assignment assignment);

    public abstract void setInstances(Instances instances);

    public abstract void writeBatch()
        throws IOException;

    public abstract void writeIncremental(Instance instance)
        throws IOException;

    public abstract int getWriteMode();

    public static final int NONE = 0;
    public static final int BATCH = 1;
    public static final int INCREMENTAL = 2;
}
