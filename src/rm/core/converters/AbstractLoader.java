// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   AbstractLoader.java

package rm.core.converters;

import java.io.*;
import rm.core.Instance;
import rm.core.Instances;

// Referenced classes of package rm.core.converters:
//            Loader

public abstract class AbstractLoader
    implements Loader
{

    public AbstractLoader()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #20  <Method void Object()>
    //    2    4:return          
    }

    protected void setRetrieval(int mode)
    {
        m_retrieval = mode;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #28  <Field int m_retrieval>
    //    3    5:return          
    }

    protected int getRetrieval()
    {
        return m_retrieval;
    //    0    0:aload_0         
    //    1    1:getfield        #28  <Field int m_retrieval>
    //    2    4:ireturn         
    }

    public void setSource(File file)
        throws IOException
    {
        throw new IOException("Setting File as source not supported");
    //    0    0:new             #36  <Class IOException>
    //    1    3:dup             
    //    2    4:ldc1            #38  <String "Setting File as source not supported">
    //    3    6:invokespecial   #41  <Method void IOException(String)>
    //    4    9:athrow          
    }

    public void reset()
        throws Exception
    {
        m_retrieval = 0;
    //    0    0:aload_0         
    //    1    1:iconst_0        
    //    2    2:putfield        #28  <Field int m_retrieval>
    //    3    5:return          
    }

    public void setSource(InputStream input)
        throws IOException
    {
        throw new IOException("Setting InputStream as source not supported");
    //    0    0:new             #36  <Class IOException>
    //    1    3:dup             
    //    2    4:ldc1            #49  <String "Setting InputStream as source not supported">
    //    3    6:invokespecial   #41  <Method void IOException(String)>
    //    4    9:athrow          
    }

    public abstract Instances getStructure()
        throws IOException;

    public abstract Instances getDataSet()
        throws IOException;

    public abstract Instance getNextInstance(Instances instances)
        throws IOException;

    protected static final int NONE = 0;
    protected static final int BATCH = 1;
    protected static final int INCREMENTAL = 2;
    protected int m_retrieval;
}
