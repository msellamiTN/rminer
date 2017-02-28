// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   SerializedInstancesLoader.java

package rm.core.converters;

import java.io.*;
import rm.core.*;

// Referenced classes of package rm.core.converters:
//            AbstractFileLoader, BatchConverter, IncrementalConverter

public class SerializedInstancesLoader extends AbstractFileLoader
    implements BatchConverter, IncrementalConverter
{

    public SerializedInstancesLoader()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #31  <Method void AbstractFileLoader()>
        m_Dataset = null;
    //    2    4:aload_0         
    //    3    5:aconst_null     
    //    4    6:putfield        #33  <Field Instances m_Dataset>
        m_IncrementalIndex = 0;
    //    5    9:aload_0         
    //    6   10:iconst_0        
    //    7   11:putfield        #35  <Field int m_IncrementalIndex>
    //    8   14:return          
    }

    public String globalInfo()
    {
        return "Reads a source that contains serialized Instances.";
    //    0    0:ldc1            #41  <String "Reads a source that contains serialized Instances.">
    //    1    2:areturn         
    }

    public void reset()
    {
        m_Dataset = null;
    //    0    0:aload_0         
    //    1    1:aconst_null     
    //    2    2:putfield        #33  <Field Instances m_Dataset>
        m_IncrementalIndex = 0;
    //    3    5:aload_0         
    //    4    6:iconst_0        
    //    5    7:putfield        #35  <Field int m_IncrementalIndex>
    //    6   10:return          
    }

    public String getFileExtension()
    {
        return FILE_EXTENSION;
    //    0    0:getstatic       #26  <Field String FILE_EXTENSION>
    //    1    3:areturn         
    }

    public String[] getFileExtensions()
    {
        return (new String[] {
            getFileExtension()
        });
    //    0    0:iconst_1        
    //    1    1:anewarray       String[]
    //    2    4:dup             
    //    3    5:iconst_0        
    //    4    6:aload_0         
    //    5    7:invokevirtual   #49  <Method String getFileExtension()>
    //    6   10:aastore         
    //    7   11:areturn         
    }

    public String getFileDescription()
    {
        return "Binary serialized instances";
    //    0    0:ldc1            #52  <String "Binary serialized instances">
    //    1    2:areturn         
    }

    public void setSource(InputStream in)
        throws IOException
    {
        ObjectInputStream oi = new ObjectInputStream(new BufferedInputStream(in));
    //    0    0:new             #59  <Class ObjectInputStream>
    //    1    3:dup             
    //    2    4:new             #61  <Class BufferedInputStream>
    //    3    7:dup             
    //    4    8:aload_1         
    //    5    9:invokespecial   #63  <Method void BufferedInputStream(InputStream)>
    //    6   12:invokespecial   #64  <Method void ObjectInputStream(InputStream)>
    //    7   15:astore_2        
        try
        {
            m_Dataset = (Instances)oi.readObject();
    //    8   16:aload_0         
    //    9   17:aload_2         
    //   10   18:invokevirtual   #68  <Method Object ObjectInputStream.readObject()>
    //   11   21:checkcast       #70  <Class Instances>
    //   12   24:putfield        #33  <Field Instances m_Dataset>
        }
    //*  13   27:goto            41
        catch(ClassNotFoundException ex)
    //*  14   30:astore_3        
        {
            throw new IOException("Could not deserialize instances from this source.");
    //   15   31:new             #57  <Class IOException>
    //   16   34:dup             
    //   17   35:ldc1            #72  <String "Could not deserialize instances from this source.">
    //   18   37:invokespecial   #75  <Method void IOException(String)>
    //   19   40:athrow          
        }
        oi.close();
    //   20   41:aload_2         
    //   21   42:invokevirtual   #78  <Method void ObjectInputStream.close()>
    //   22   45:return          
    }

    public Instances getStructure()
        throws IOException
    {
        if(m_Dataset == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #33  <Field Instances m_Dataset>
    //*   2    4:ifnonnull       17
            throw new IOException("No source has been specified");
    //    3    7:new             #57  <Class IOException>
    //    4   10:dup             
    //    5   11:ldc1            #90  <String "No source has been specified">
    //    6   13:invokespecial   #75  <Method void IOException(String)>
    //    7   16:athrow          
        else
            return new Instances(m_Dataset, 0);
    //    8   17:new             #70  <Class Instances>
    //    9   20:dup             
    //   10   21:aload_0         
    //   11   22:getfield        #33  <Field Instances m_Dataset>
    //   12   25:iconst_0        
    //   13   26:invokespecial   #93  <Method void Instances(Instances, int)>
    //   14   29:areturn         
    }

    public Instances getDataSet()
        throws IOException
    {
        if(m_Dataset == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #33  <Field Instances m_Dataset>
    //*   2    4:ifnonnull       17
            throw new IOException("No source has been specified");
    //    3    7:new             #57  <Class IOException>
    //    4   10:dup             
    //    5   11:ldc1            #90  <String "No source has been specified">
    //    6   13:invokespecial   #75  <Method void IOException(String)>
    //    7   16:athrow          
        else
            return m_Dataset;
    //    8   17:aload_0         
    //    9   18:getfield        #33  <Field Instances m_Dataset>
    //   10   21:areturn         
    }

    public Instance getNextInstance(Instances structure)
        throws IOException
    {
        if(m_Dataset == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #33  <Field Instances m_Dataset>
    //*   2    4:ifnonnull       17
            throw new IOException("No source has been specified");
    //    3    7:new             #57  <Class IOException>
    //    4   10:dup             
    //    5   11:ldc1            #90  <String "No source has been specified">
    //    6   13:invokespecial   #75  <Method void IOException(String)>
    //    7   16:athrow          
        if(m_IncrementalIndex == m_Dataset.numInstances())
    //*   8   17:aload_0         
    //*   9   18:getfield        #35  <Field int m_IncrementalIndex>
    //*  10   21:aload_0         
    //*  11   22:getfield        #33  <Field Instances m_Dataset>
    //*  12   25:invokevirtual   #100 <Method int Instances.numInstances()>
    //*  13   28:icmpne          33
            return null;
    //   14   31:aconst_null     
    //   15   32:areturn         
        else
            return m_Dataset.instance(m_IncrementalIndex++);
    //   16   33:aload_0         
    //   17   34:getfield        #33  <Field Instances m_Dataset>
    //   18   37:aload_0         
    //   19   38:dup             
    //   20   39:getfield        #35  <Field int m_IncrementalIndex>
    //   21   42:dup_x1          
    //   22   43:iconst_1        
    //   23   44:iadd            
    //   24   45:putfield        #35  <Field int m_IncrementalIndex>
    //   25   48:invokevirtual   #104 <Method Instance Instances.instance(int)>
    //   26   51:areturn         
    }

    public String getRevision()
    {
        return RevisionUtils.extract("$Revision: 1.15 $");
    //    0    0:ldc1            #108 <String "$Revision: 1.15 $">
    //    1    2:invokestatic    #114 <Method String RevisionUtils.extract(String)>
    //    2    5:areturn         
    }

    public static void main(String args[])
    {
        AbstractFileLoader.runFileLoader(new SerializedInstancesLoader(), args);
    //    0    0:new             #2   <Class SerializedInstancesLoader>
    //    1    3:dup             
    //    2    4:invokespecial   #117 <Method void SerializedInstancesLoader()>
    //    3    7:aload_0         
    //    4    8:invokestatic    #121 <Method void AbstractFileLoader.runFileLoader(AbstractFileLoader, String[])>
    //    5   11:return          
    }

    static final long serialVersionUID = 0x212ed7e64a488d3bL;
    public static String FILE_EXTENSION = ".bsi";
    protected Instances m_Dataset;
    protected int m_IncrementalIndex;

    static 
    {
    //    0    0:ldc1            #24  <String ".bsi">
    //    1    2:putstatic       #26  <Field String FILE_EXTENSION>
    //*   2    5:return          
    }
}
