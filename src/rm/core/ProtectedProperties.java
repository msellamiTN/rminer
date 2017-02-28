// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   ProtectedProperties.java

package rm.core;

import java.io.InputStream;
import java.util.*;

public class ProtectedProperties extends Properties
{

    public ProtectedProperties(Properties props)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #17  <Method void Properties()>
        closed = false;
    //    2    4:aload_0         
    //    3    5:iconst_0        
    //    4    6:putfield        #19  <Field boolean closed>
        String propName;
        String propValue;
        for(Enumeration propEnum = props.propertyNames(); propEnum.hasMoreElements(); super.setProperty(propName, propValue))
    //*   5    9:aload_1         
    //*   6   10:invokevirtual   #23  <Method Enumeration Properties.propertyNames()>
    //*   7   13:astore_2        
    //*   8   14:goto            45
        {
            propName = (String)(String)propEnum.nextElement();
    //    9   17:aload_2         
    //   10   18:invokeinterface #29  <Method Object Enumeration.nextElement()>
    //   11   23:checkcast       #31  <Class String>
    //   12   26:checkcast       #31  <Class String>
    //   13   29:astore_3        
            propValue = props.getProperty(propName);
    //   14   30:aload_1         
    //   15   31:aload_3         
    //   16   32:invokevirtual   #35  <Method String Properties.getProperty(String)>
    //   17   35:astore          4
        }

    //   18   37:aload_0         
    //   19   38:aload_3         
    //   20   39:aload           4
    //   21   41:invokespecial   #39  <Method Object Properties.setProperty(String, String)>
    //   22   44:pop             
    //   23   45:aload_2         
    //   24   46:invokeinterface #43  <Method boolean Enumeration.hasMoreElements()>
    //   25   51:ifne            17
        closed = true;
    //   26   54:aload_0         
    //   27   55:iconst_1        
    //   28   56:putfield        #19  <Field boolean closed>
    //   29   59:return          
    }

    public Object setProperty(String key, String value)
    {
        if(closed)
    //*   0    0:aload_0         
    //*   1    1:getfield        #19  <Field boolean closed>
    //*   2    4:ifeq            17
            throw new UnsupportedOperationException("ProtectedProperties cannot be modified!");
    //    3    7:new             #56  <Class UnsupportedOperationException>
    //    4   10:dup             
    //    5   11:ldc1            #58  <String "ProtectedProperties cannot be modified!">
    //    6   13:invokespecial   #61  <Method void UnsupportedOperationException(String)>
    //    7   16:athrow          
        else
            return super.setProperty(key, value);
    //    8   17:aload_0         
    //    9   18:aload_1         
    //   10   19:aload_2         
    //   11   20:invokespecial   #39  <Method Object Properties.setProperty(String, String)>
    //   12   23:areturn         
    }

    public void load(InputStream inStream)
    {
        throw new UnsupportedOperationException("ProtectedProperties cannot be modified!");
    //    0    0:new             #56  <Class UnsupportedOperationException>
    //    1    3:dup             
    //    2    4:ldc1            #58  <String "ProtectedProperties cannot be modified!">
    //    3    6:invokespecial   #61  <Method void UnsupportedOperationException(String)>
    //    4    9:athrow          
    }

    public void clear()
    {
        throw new UnsupportedOperationException("ProtectedProperties cannot be modified!");
    //    0    0:new             #56  <Class UnsupportedOperationException>
    //    1    3:dup             
    //    2    4:ldc1            #58  <String "ProtectedProperties cannot be modified!">
    //    3    6:invokespecial   #61  <Method void UnsupportedOperationException(String)>
    //    4    9:athrow          
    }

    public Object put(Object key, Object value)
    {
        if(closed)
    //*   0    0:aload_0         
    //*   1    1:getfield        #19  <Field boolean closed>
    //*   2    4:ifeq            17
            throw new UnsupportedOperationException("ProtectedProperties cannot be modified!");
    //    3    7:new             #56  <Class UnsupportedOperationException>
    //    4   10:dup             
    //    5   11:ldc1            #58  <String "ProtectedProperties cannot be modified!">
    //    6   13:invokespecial   #61  <Method void UnsupportedOperationException(String)>
    //    7   16:athrow          
        else
            return super.put(key, value);
    //    8   17:aload_0         
    //    9   18:aload_1         
    //   10   19:aload_2         
    //   11   20:invokespecial   #74  <Method Object Hashtable.put(Object, Object)>
    //   12   23:areturn         
    }

    public void putAll(Map t)
    {
        throw new UnsupportedOperationException("ProtectedProperties cannot be modified!");
    //    0    0:new             #56  <Class UnsupportedOperationException>
    //    1    3:dup             
    //    2    4:ldc1            #58  <String "ProtectedProperties cannot be modified!">
    //    3    6:invokespecial   #61  <Method void UnsupportedOperationException(String)>
    //    4    9:athrow          
    }

    public Object remove(Object key)
    {
        throw new UnsupportedOperationException("ProtectedProperties cannot be modified!");
    //    0    0:new             #56  <Class UnsupportedOperationException>
    //    1    3:dup             
    //    2    4:ldc1            #58  <String "ProtectedProperties cannot be modified!">
    //    3    6:invokespecial   #61  <Method void UnsupportedOperationException(String)>
    //    4    9:athrow          
    }

    private static final long serialVersionUID = 0x35cca885fb2d57d1L;
    private boolean closed;
}
