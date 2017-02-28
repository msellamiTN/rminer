// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   SerializedObject.java

package rm.core;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class SerializedObject
    implements Serializable
{

    public SerializedObject(Object toStore)
        throws Exception
    {
        this(toStore, false);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:iconst_0        
    //    3    3:invokespecial   #20  <Method void SerializedObject(Object, boolean)>
    //    4    6:return          
    }

    public SerializedObject(Object toStore, boolean compress)
        throws Exception
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #29  <Method void Object()>
        ByteArrayOutputStream ostream = new ByteArrayOutputStream();
    //    2    4:new             #31  <Class ByteArrayOutputStream>
    //    3    7:dup             
    //    4    8:invokespecial   #32  <Method void ByteArrayOutputStream()>
    //    5   11:astore_3        
        java.io.OutputStream os = ostream;
    //    6   12:aload_3         
    //    7   13:astore          4
        ObjectOutputStream p;
        if(!compress)
    //*   8   15:iload_2         
    //*   9   16:ifne            40
            p = new ObjectOutputStream(new BufferedOutputStream(os));
    //   10   19:new             #34  <Class ObjectOutputStream>
    //   11   22:dup             
    //   12   23:new             #36  <Class BufferedOutputStream>
    //   13   26:dup             
    //   14   27:aload           4
    //   15   29:invokespecial   #39  <Method void BufferedOutputStream(java.io.OutputStream)>
    //   16   32:invokespecial   #40  <Method void ObjectOutputStream(java.io.OutputStream)>
    //   17   35:astore          5
        else
    //*  18   37:goto            65
            p = new ObjectOutputStream(new BufferedOutputStream(new GZIPOutputStream(os)));
    //   19   40:new             #34  <Class ObjectOutputStream>
    //   20   43:dup             
    //   21   44:new             #36  <Class BufferedOutputStream>
    //   22   47:dup             
    //   23   48:new             #42  <Class GZIPOutputStream>
    //   24   51:dup             
    //   25   52:aload           4
    //   26   54:invokespecial   #43  <Method void GZIPOutputStream(java.io.OutputStream)>
    //   27   57:invokespecial   #39  <Method void BufferedOutputStream(java.io.OutputStream)>
    //   28   60:invokespecial   #40  <Method void ObjectOutputStream(java.io.OutputStream)>
    //   29   63:astore          5
        p.writeObject(toStore);
    //   30   65:aload           5
    //   31   67:aload_1         
    //   32   68:invokevirtual   #46  <Method void ObjectOutputStream.writeObject(Object)>
        p.flush();
    //   33   71:aload           5
    //   34   73:invokevirtual   #49  <Method void ObjectOutputStream.flush()>
        p.close();
    //   35   76:aload           5
    //   36   78:invokevirtual   #52  <Method void ObjectOutputStream.close()>
        m_storedObjectArray = ostream.toByteArray();
    //   37   81:aload_0         
    //   38   82:aload_3         
    //   39   83:invokevirtual   #56  <Method byte[] ByteArrayOutputStream.toByteArray()>
    //   40   86:putfield        #58  <Field byte[] m_storedObjectArray>
        m_isCompressed = compress;
    //   41   89:aload_0         
    //   42   90:iload_2         
    //   43   91:putfield        #60  <Field boolean m_isCompressed>
    //   44   94:return          
    }

    public final boolean equals(Object compareTo)
    {
        if(compareTo == null)
    //*   0    0:aload_1         
    //*   1    1:ifnonnull       6
            return false;
    //    2    4:iconst_0        
    //    3    5:ireturn         
        if(!compareTo.getClass().equals(getClass()))
    //*   4    6:aload_1         
    //*   5    7:invokevirtual   #73  <Method Class Object.getClass()>
    //*   6   10:aload_0         
    //*   7   11:invokevirtual   #73  <Method Class Object.getClass()>
    //*   8   14:invokevirtual   #75  <Method boolean Object.equals(Object)>
    //*   9   17:ifne            22
            return false;
    //   10   20:iconst_0        
    //   11   21:ireturn         
        byte compareArray[] = ((SerializedObject)compareTo).m_storedObjectArray;
    //   12   22:aload_1         
    //   13   23:checkcast       #2   <Class SerializedObject>
    //   14   26:getfield        #58  <Field byte[] m_storedObjectArray>
    //   15   29:astore_2        
        if(compareArray.length != m_storedObjectArray.length)
    //*  16   30:aload_2         
    //*  17   31:arraylength     
    //*  18   32:aload_0         
    //*  19   33:getfield        #58  <Field byte[] m_storedObjectArray>
    //*  20   36:arraylength     
    //*  21   37:icmpeq          42
            return false;
    //   22   40:iconst_0        
    //   23   41:ireturn         
        for(int i = 0; i < compareArray.length; i++)
    //*  24   42:iconst_0        
    //*  25   43:istore_3        
    //*  26   44:goto            64
            if(compareArray[i] != m_storedObjectArray[i])
    //*  27   47:aload_2         
    //*  28   48:iload_3         
    //*  29   49:baload          
    //*  30   50:aload_0         
    //*  31   51:getfield        #58  <Field byte[] m_storedObjectArray>
    //*  32   54:iload_3         
    //*  33   55:baload          
    //*  34   56:icmpeq          61
                return false;
    //   35   59:iconst_0        
    //   36   60:ireturn         

    //   37   61:iinc            3  1
    //   38   64:iload_3         
    //   39   65:aload_2         
    //   40   66:arraylength     
    //   41   67:icmplt          47
        return true;
    //   42   70:iconst_1        
    //   43   71:ireturn         
    }

    public int hashCode()
    {
        return m_storedObjectArray.length;
    //    0    0:aload_0         
    //    1    1:getfield        #58  <Field byte[] m_storedObjectArray>
    //    2    4:arraylength     
    //    3    5:ireturn         
    }

    public Object getObject()
    {
        try
        {
            ByteArrayInputStream istream = new ByteArrayInputStream(m_storedObjectArray);
    //    0    0:new             #85  <Class ByteArrayInputStream>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:getfield        #58  <Field byte[] m_storedObjectArray>
    //    4    8:invokespecial   #88  <Method void ByteArrayInputStream(byte[])>
    //    5   11:astore_1        
            Object toReturn = null;
    //    6   12:aconst_null     
    //    7   13:astore_3        
            ObjectInputStream p;
            if(!m_isCompressed)
    //*   8   14:aload_0         
    //*   9   15:getfield        #60  <Field boolean m_isCompressed>
    //*  10   18:ifne            40
                p = new ObjectInputStream(new BufferedInputStream(istream));
    //   11   21:new             #90  <Class ObjectInputStream>
    //   12   24:dup             
    //   13   25:new             #92  <Class BufferedInputStream>
    //   14   28:dup             
    //   15   29:aload_1         
    //   16   30:invokespecial   #95  <Method void BufferedInputStream(java.io.InputStream)>
    //   17   33:invokespecial   #96  <Method void ObjectInputStream(java.io.InputStream)>
    //   18   36:astore_2        
            else
    //*  19   37:goto            63
                p = new ObjectInputStream(new BufferedInputStream(new GZIPInputStream(istream)));
    //   20   40:new             #90  <Class ObjectInputStream>
    //   21   43:dup             
    //   22   44:new             #92  <Class BufferedInputStream>
    //   23   47:dup             
    //   24   48:new             #98  <Class GZIPInputStream>
    //   25   51:dup             
    //   26   52:aload_1         
    //   27   53:invokespecial   #99  <Method void GZIPInputStream(java.io.InputStream)>
    //   28   56:invokespecial   #95  <Method void BufferedInputStream(java.io.InputStream)>
    //   29   59:invokespecial   #96  <Method void ObjectInputStream(java.io.InputStream)>
    //   30   62:astore_2        
            toReturn = p.readObject();
    //   31   63:aload_2         
    //   32   64:invokevirtual   #102 <Method Object ObjectInputStream.readObject()>
    //   33   67:astore_3        
            istream.close();
    //   34   68:aload_1         
    //   35   69:invokevirtual   #103 <Method void ByteArrayInputStream.close()>
            return toReturn;
    //   36   72:aload_3         
    //   37   73:areturn         
        }
        catch(Exception e)
    //*  38   74:astore_1        
        {
            e.printStackTrace();
    //   39   75:aload_1         
    //   40   76:invokevirtual   #106 <Method void Exception.printStackTrace()>
        }
        return null;
    //   41   79:aconst_null     
    //   42   80:areturn         
    }

    private byte m_storedObjectArray[];
    private boolean m_isCompressed;
    private boolean m_isJython;
}
