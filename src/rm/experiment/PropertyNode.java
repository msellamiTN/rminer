// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   PropertyNode.java

package rm.experiment;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.*;
import java.lang.reflect.Method;

public class PropertyNode
    implements Serializable
{

    public PropertyNode(Object pValue)
    {
        this(pValue, null, null);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:aconst_null     
    //    3    3:aconst_null     
    //    4    4:invokespecial   #23  <Method void PropertyNode(Object, PropertyDescriptor, Class)>
    //    5    7:return          
    }

    public PropertyNode(Object pValue, PropertyDescriptor prop, Class pClass)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #31  <Method void Object()>
        value = pValue;
    //    2    4:aload_0         
    //    3    5:aload_1         
    //    4    6:putfield        #33  <Field Object value>
        property = prop;
    //    5    9:aload_0         
    //    6   10:aload_2         
    //    7   11:putfield        #35  <Field PropertyDescriptor property>
        parentClass = pClass;
    //    8   14:aload_0         
    //    9   15:aload_3         
    //   10   16:putfield        #37  <Field Class parentClass>
    //   11   19:return          
    }

    public String toString()
    {
        if(property == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #35  <Field PropertyDescriptor property>
    //*   2    4:ifnonnull       10
            return "Available properties";
    //    3    7:ldc1            #43  <String "Available properties">
    //    4    9:areturn         
        else
            return property.getDisplayName();
    //    5   10:aload_0         
    //    6   11:getfield        #35  <Field PropertyDescriptor property>
    //    7   14:invokevirtual   #48  <Method String PropertyDescriptor.getDisplayName()>
    //    8   17:areturn         
    }

    private void writeObject(ObjectOutputStream out)
        throws IOException
    {
        try
        {
            out.writeObject(value);
    //    0    0:aload_1         
    //    1    1:aload_0         
    //    2    2:getfield        #33  <Field Object value>
    //    3    5:invokevirtual   #57  <Method void ObjectOutputStream.writeObject(Object)>
        }
    //*   4    8:goto            39
        catch(Exception ex)
    //*   5   11:astore_2        
        {
            throw new IOException((new StringBuilder("Can't serialize object: ")).append(ex.getMessage()).toString());
    //    6   12:new             #53  <Class IOException>
    //    7   15:dup             
    //    8   16:new             #59  <Class StringBuilder>
    //    9   19:dup             
    //   10   20:ldc1            #61  <String "Can't serialize object: ">
    //   11   22:invokespecial   #64  <Method void StringBuilder(String)>
    //   12   25:aload_2         
    //   13   26:invokevirtual   #69  <Method String Exception.getMessage()>
    //   14   29:invokevirtual   #73  <Method StringBuilder StringBuilder.append(String)>
    //   15   32:invokevirtual   #75  <Method String StringBuilder.toString()>
    //   16   35:invokespecial   #76  <Method void IOException(String)>
    //   17   38:athrow          
        }
        out.writeObject(parentClass);
    //   18   39:aload_1         
    //   19   40:aload_0         
    //   20   41:getfield        #37  <Field Class parentClass>
    //   21   44:invokevirtual   #57  <Method void ObjectOutputStream.writeObject(Object)>
        out.writeObject(property.getDisplayName());
    //   22   47:aload_1         
    //   23   48:aload_0         
    //   24   49:getfield        #35  <Field PropertyDescriptor property>
    //   25   52:invokevirtual   #48  <Method String PropertyDescriptor.getDisplayName()>
    //   26   55:invokevirtual   #57  <Method void ObjectOutputStream.writeObject(Object)>
        out.writeObject(property.getReadMethod().getName());
    //   27   58:aload_1         
    //   28   59:aload_0         
    //   29   60:getfield        #35  <Field PropertyDescriptor property>
    //   30   63:invokevirtual   #80  <Method Method PropertyDescriptor.getReadMethod()>
    //   31   66:invokevirtual   #85  <Method String Method.getName()>
    //   32   69:invokevirtual   #57  <Method void ObjectOutputStream.writeObject(Object)>
        out.writeObject(property.getWriteMethod().getName());
    //   33   72:aload_1         
    //   34   73:aload_0         
    //   35   74:getfield        #35  <Field PropertyDescriptor property>
    //   36   77:invokevirtual   #88  <Method Method PropertyDescriptor.getWriteMethod()>
    //   37   80:invokevirtual   #85  <Method String Method.getName()>
    //   38   83:invokevirtual   #57  <Method void ObjectOutputStream.writeObject(Object)>
    //   39   86:return          
    }

    private void readObject(ObjectInputStream in)
        throws IOException, ClassNotFoundException
    {
        value = in.readObject();
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokevirtual   #101 <Method Object ObjectInputStream.readObject()>
    //    3    5:putfield        #33  <Field Object value>
        parentClass = (Class)in.readObject();
    //    4    8:aload_0         
    //    5    9:aload_1         
    //    6   10:invokevirtual   #101 <Method Object ObjectInputStream.readObject()>
    //    7   13:checkcast       #103 <Class Class>
    //    8   16:putfield        #37  <Field Class parentClass>
        String name = (String)in.readObject();
    //    9   19:aload_1         
    //   10   20:invokevirtual   #101 <Method Object ObjectInputStream.readObject()>
    //   11   23:checkcast       #105 <Class String>
    //   12   26:astore_2        
        String getter = (String)in.readObject();
    //   13   27:aload_1         
    //   14   28:invokevirtual   #101 <Method Object ObjectInputStream.readObject()>
    //   15   31:checkcast       #105 <Class String>
    //   16   34:astore_3        
        String setter = (String)in.readObject();
    //   17   35:aload_1         
    //   18   36:invokevirtual   #101 <Method Object ObjectInputStream.readObject()>
    //   19   39:checkcast       #105 <Class String>
    //   20   42:astore          4
        try
        {
            property = new PropertyDescriptor(name, parentClass, getter, setter);
    //   21   44:aload_0         
    //   22   45:new             #45  <Class PropertyDescriptor>
    //   23   48:dup             
    //   24   49:aload_2         
    //   25   50:aload_0         
    //   26   51:getfield        #37  <Field Class parentClass>
    //   27   54:aload_3         
    //   28   55:aload           4
    //   29   57:invokespecial   #108 <Method void PropertyDescriptor(String, Class, String, String)>
    //   30   60:putfield        #35  <Field PropertyDescriptor property>
        }
    //*  31   63:goto            107
        catch(IntrospectionException ex)
    //*  32   66:astore          5
        {
            throw new ClassNotFoundException((new StringBuilder("Couldn't create property descriptor: ")).append(parentClass.getName()).append("::").append(name).toString());
    //   33   68:new             #96  <Class ClassNotFoundException>
    //   34   71:dup             
    //   35   72:new             #59  <Class StringBuilder>
    //   36   75:dup             
    //   37   76:ldc1            #110 <String "Couldn't create property descriptor: ">
    //   38   78:invokespecial   #64  <Method void StringBuilder(String)>
    //   39   81:aload_0         
    //   40   82:getfield        #37  <Field Class parentClass>
    //   41   85:invokevirtual   #111 <Method String Class.getName()>
    //   42   88:invokevirtual   #73  <Method StringBuilder StringBuilder.append(String)>
    //   43   91:ldc1            #113 <String "::">
    //   44   93:invokevirtual   #73  <Method StringBuilder StringBuilder.append(String)>
    //   45   96:aload_2         
    //   46   97:invokevirtual   #73  <Method StringBuilder StringBuilder.append(String)>
    //   47  100:invokevirtual   #75  <Method String StringBuilder.toString()>
    //   48  103:invokespecial   #114 <Method void ClassNotFoundException(String)>
    //   49  106:athrow          
        }
    //   50  107:return          
    }

    private static final long serialVersionUID = 0x8702da72acfa8aa8L;
    public Object value;
    public Class parentClass;
    public PropertyDescriptor property;
}
