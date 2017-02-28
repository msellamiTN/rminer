// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   AbstractGenerate.java

package rm.generate;

import java.io.Serializable;
import rm.core.SerializedObject;
import rm.core.Utils;

// Referenced classes of package rm.generate:
//            Generate

public abstract class AbstractGenerate
    implements Cloneable, Generate, Serializable
{

    public AbstractGenerate()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #17  <Method void Object()>
    //    2    4:return          
    }

    public static Generate forName(String generaterName, String options[])
        throws Exception
    {
        return (Generate)Utils.forName(rm/generate/Generate, generaterName, options);
    //    0    0:ldc1            #8   <Class Generate>
    //    1    2:aload_0         
    //    2    3:aload_1         
    //    3    4:invokestatic    #31  <Method Object Utils.forName(Class, String, String[])>
    //    4    7:checkcast       #8   <Class Generate>
    //    5   10:areturn         
    }

    public static Generate makeCopy(Generate model)
        throws Exception
    {
        return (Generate)(new SerializedObject(model)).getObject();
    //    0    0:new             #39  <Class SerializedObject>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:invokespecial   #42  <Method void SerializedObject(Object)>
    //    4    8:invokevirtual   #46  <Method Object SerializedObject.getObject()>
    //    5   11:checkcast       #8   <Class Generate>
    //    6   14:areturn         
    }

    public static Generate[] makeCopies(Generate model, int num)
        throws Exception
    {
        if(model == null)
    //*   0    0:aload_0         
    //*   1    1:ifnonnull       14
            throw new Exception("No model associator set");
    //    2    4:new             #26  <Class Exception>
    //    3    7:dup             
    //    4    8:ldc1            #52  <String "No model associator set">
    //    5   10:invokespecial   #55  <Method void Exception(String)>
    //    6   13:athrow          
        Generate generters[] = new Generate[num];
    //    7   14:iload_1         
    //    8   15:anewarray       Generate[]
    //    9   18:astore_2        
        SerializedObject so = new SerializedObject(model);
    //   10   19:new             #39  <Class SerializedObject>
    //   11   22:dup             
    //   12   23:aload_0         
    //   13   24:invokespecial   #42  <Method void SerializedObject(Object)>
    //   14   27:astore_3        
        for(int i = 0; i < generters.length; i++)
    //*  15   28:iconst_0        
    //*  16   29:istore          4
    //*  17   31:goto            48
            generters[i] = (Generate)so.getObject();
    //   18   34:aload_2         
    //   19   35:iload           4
    //   20   37:aload_3         
    //   21   38:invokevirtual   #46  <Method Object SerializedObject.getObject()>
    //   22   41:checkcast       #8   <Class Generate>
    //   23   44:aastore         

    //   24   45:iinc            4  1
    //   25   48:iload           4
    //   26   50:aload_2         
    //   27   51:arraylength     
    //   28   52:icmplt          34
        return generters;
    //   29   55:aload_2         
    //   30   56:areturn         
    }

    static Class class$0;
}
