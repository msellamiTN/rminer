// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   AbstractSaver.java

package rm.core.converters;

import java.io.*;
import rm.core.*;

// Referenced classes of package rm.core.converters:
//            Saver

public abstract class AbstractSaver
    implements Saver, CapabilitiesHandler
{

    public AbstractSaver()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #29  <Method void Object()>
    //    2    4:return          
    }

    public void resetOptions()
    {
        m_assignment = null;
    //    0    0:aload_0         
    //    1    1:aconst_null     
    //    2    2:putfield        #36  <Field Assignment m_assignment>
        m_writeMode = 1;
    //    3    5:aload_0         
    //    4    6:iconst_1        
    //    5    7:putfield        #38  <Field int m_writeMode>
    //    6   10:return          
    }

    public void resetStructure()
    {
        m_assignment = null;
    //    0    0:aload_0         
    //    1    1:aconst_null     
    //    2    2:putfield        #36  <Field Assignment m_assignment>
        m_writeMode = 1;
    //    3    5:aload_0         
    //    4    6:iconst_1        
    //    5    7:putfield        #38  <Field int m_writeMode>
    //    6   10:return          
    }

    public void setRetrieval(int mode)
    {
        m_retrieval = mode;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #43  <Field int m_retrieval>
    //    3    5:return          
    }

    protected int getRetrieval()
    {
        return m_retrieval;
    //    0    0:aload_0         
    //    1    1:getfield        #43  <Field int m_retrieval>
    //    2    4:ireturn         
    }

    protected void setWriteMode(int mode)
    {
        m_writeMode = mode;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #38  <Field int m_writeMode>
    //    3    5:return          
    }

    public int getWriteMode()
    {
        return m_writeMode;
    //    0    0:aload_0         
    //    1    1:getfield        #38  <Field int m_writeMode>
    //    2    4:ireturn         
    }

    public void setAssignment(Assignment newAssignment)
    {
        m_assignment = newAssignment;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #36  <Field Assignment m_assignment>
    //    3    5:return          
    }

    public Assignment getAssignment()
    {
        return m_assignment;
    //    0    0:aload_0         
    //    1    1:getfield        #36  <Field Assignment m_assignment>
    //    2    4:areturn         
    }

    public void setInstances(Instances instances)
    {
        m_instances = instances;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #57  <Field Instances m_instances>
    //    3    5:return          
    }

    public Instances getInstances()
    {
        return m_instances;
    //    0    0:aload_0         
    //    1    1:getfield        #57  <Field Instances m_instances>
    //    2    4:areturn         
    }

    public void setDestination(File file)
        throws IOException
    {
        throw new IOException("Writing to a file not supported");
    //    0    0:new             #65  <Class IOException>
    //    1    3:dup             
    //    2    4:ldc1            #67  <String "Writing to a file not supported">
    //    3    6:invokespecial   #70  <Method void IOException(String)>
    //    4    9:athrow          
    }

    public void setDestination(OutputStream output)
        throws IOException
    {
        throw new IOException("Writing to an outputstream not supported");
    //    0    0:new             #65  <Class IOException>
    //    1    3:dup             
    //    2    4:ldc1            #75  <String "Writing to an outputstream not supported">
    //    3    6:invokespecial   #70  <Method void IOException(String)>
    //    4    9:athrow          
    }

    public Capabilities getCapabilities()
    {
        Capabilities result = new Capabilities(this);
    //    0    0:new             #81  <Class Capabilities>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:invokespecial   #84  <Method void Capabilities(CapabilitiesHandler)>
    //    4    8:astore_1        
        result.setMinimumNumberInstances(0);
    //    5    9:aload_1         
    //    6   10:iconst_0        
    //    7   11:invokevirtual   #87  <Method void Capabilities.setMinimumNumberInstances(int)>
        return result;
    //    8   14:aload_1         
    //    9   15:areturn         
    }

    public int setStructure(Assignment headerInfo)
    {
        if(m_writeMode == 1 && headerInfo != null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #38  <Field int m_writeMode>
    //*   2    4:iconst_1        
    //*   3    5:icmpne          25
    //*   4    8:aload_1         
    //*   5    9:ifnull          25
        {
            m_assignment = headerInfo;
    //    6   12:aload_0         
    //    7   13:aload_1         
    //    8   14:putfield        #36  <Field Assignment m_assignment>
            m_writeMode = 3;
    //    9   17:aload_0         
    //   10   18:iconst_3        
    //   11   19:putfield        #38  <Field int m_writeMode>
        } else
    //*  12   22:goto            63
        if(headerInfo == null || m_writeMode != 3)
    //*  13   25:aload_1         
    //*  14   26:ifnull          37
    //*  15   29:aload_0         
    //*  16   30:getfield        #38  <Field int m_writeMode>
    //*  17   33:iconst_3        
    //*  18   34:icmpeq          63
        {
            m_assignment = null;
    //   19   37:aload_0         
    //   20   38:aconst_null     
    //   21   39:putfield        #36  <Field Assignment m_assignment>
            if(m_writeMode != 1)
    //*  22   42:aload_0         
    //*  23   43:getfield        #38  <Field int m_writeMode>
    //*  24   46:iconst_1        
    //*  25   47:icmpeq          58
                System.err.println("A structure cannot be set up during an active incremental saving process.");
    //   26   50:getstatic       #97  <Field PrintStream System.err>
    //   27   53:ldc1            #99  <String "A structure cannot be set up during an active incremental saving process.">
    //   28   55:invokevirtual   #104 <Method void PrintStream.println(String)>
            m_writeMode = 2;
    //   29   58:aload_0         
    //   30   59:iconst_2        
    //   31   60:putfield        #38  <Field int m_writeMode>
        }
        return m_writeMode;
    //   32   63:aload_0         
    //   33   64:getfield        #38  <Field int m_writeMode>
    //   34   67:ireturn         
    }

    public void cancel()
    {
        if(m_writeMode == 2)
    //*   0    0:aload_0         
    //*   1    1:getfield        #38  <Field int m_writeMode>
    //*   2    4:iconst_2        
    //*   3    5:icmpne          12
            resetOptions();
    //    4    8:aload_0         
    //    5    9:invokevirtual   #108 <Method void resetOptions()>
    //    6   12:return          
    }

    public void writeIncremental(Instance i)
        throws IOException
    {
        throw new IOException("No Incremental saving possible.");
    //    0    0:new             #65  <Class IOException>
    //    1    3:dup             
    //    2    4:ldc1            #112 <String "No Incremental saving possible.">
    //    3    6:invokespecial   #70  <Method void IOException(String)>
    //    4    9:athrow          
    }

    public abstract void writeBatch()
        throws IOException;

    public String getFileExtension()
        throws Exception
    {
        throw new Exception("Saving in a file not supported.");
    //    0    0:new             #119 <Class Exception>
    //    1    3:dup             
    //    2    4:ldc1            #121 <String "Saving in a file not supported.">
    //    3    6:invokespecial   #122 <Method void Exception(String)>
    //    4    9:athrow          
    }

    public void setFile(File file)
        throws IOException
    {
        throw new IOException("Saving in a file not supported.");
    //    0    0:new             #65  <Class IOException>
    //    1    3:dup             
    //    2    4:ldc1            #121 <String "Saving in a file not supported.">
    //    3    6:invokespecial   #70  <Method void IOException(String)>
    //    4    9:athrow          
    }

    public void setFilePrefix(String prefix)
        throws Exception
    {
        throw new Exception("Saving in a file not supported.");
    //    0    0:new             #119 <Class Exception>
    //    1    3:dup             
    //    2    4:ldc1            #121 <String "Saving in a file not supported.">
    //    3    6:invokespecial   #122 <Method void Exception(String)>
    //    4    9:athrow          
    }

    public String filePrefix()
        throws Exception
    {
        throw new Exception("Saving in a file not supported.");
    //    0    0:new             #119 <Class Exception>
    //    1    3:dup             
    //    2    4:ldc1            #121 <String "Saving in a file not supported.">
    //    3    6:invokespecial   #122 <Method void Exception(String)>
    //    4    9:athrow          
    }

    public void setDir(String dir)
        throws IOException
    {
        throw new IOException("Saving in a file not supported.");
    //    0    0:new             #65  <Class IOException>
    //    1    3:dup             
    //    2    4:ldc1            #121 <String "Saving in a file not supported.">
    //    3    6:invokespecial   #70  <Method void IOException(String)>
    //    4    9:athrow          
    }

    public void setDirAndPrefix(String relationName, String add)
        throws IOException
    {
        throw new IOException("Saving in a file not supported.");
    //    0    0:new             #65  <Class IOException>
    //    1    3:dup             
    //    2    4:ldc1            #121 <String "Saving in a file not supported.">
    //    3    6:invokespecial   #70  <Method void IOException(String)>
    //    4    9:athrow          
    }

    public String retrieveDir()
        throws IOException
    {
        throw new IOException("Saving in a file not supported.");
    //    0    0:new             #65  <Class IOException>
    //    1    3:dup             
    //    2    4:ldc1            #121 <String "Saving in a file not supported.">
    //    3    6:invokespecial   #70  <Method void IOException(String)>
    //    4    9:athrow          
    }

    protected static final int WRITE = 0;
    protected static final int WAIT = 1;
    protected static final int CANCEL = 2;
    protected static final int STRUCTURE_READY = 3;
    private Assignment m_assignment;
    private Instances m_instances;
    protected int m_retrieval;
    private int m_writeMode;
}
