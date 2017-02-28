// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   AbstractRoleminer.java

package rm.rolemining;

import java.io.PrintStream;
import java.io.Serializable;
import rm.core.*;

// Referenced classes of package rm.rolemining:
//            Roleminer, RoleminerEvaluation

public abstract class AbstractRoleminer
    implements Cloneable, Roleminer, Serializable, CapabilitiesHandler
{

    public AbstractRoleminer()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #19  <Method void Object()>
    //    2    4:return          
    }

    public static Roleminer forName(String associatorName, String options[])
        throws Exception
    {
        return (Roleminer)Utils.forName(rm/rolemining/Roleminer, associatorName, options);
    //    0    0:ldc1            #8   <Class Roleminer>
    //    1    2:aload_0         
    //    2    3:aload_1         
    //    3    4:invokestatic    #33  <Method Object Utils.forName(Class, String, String[])>
    //    4    7:checkcast       #8   <Class Roleminer>
    //    5   10:areturn         
    }

    public static Roleminer makeCopy(Roleminer model)
        throws Exception
    {
        return (Roleminer)(new SerializedObject(model)).getObject();
    //    0    0:new             #41  <Class SerializedObject>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:invokespecial   #44  <Method void SerializedObject(Object)>
    //    4    8:invokevirtual   #48  <Method Object SerializedObject.getObject()>
    //    5   11:checkcast       #8   <Class Roleminer>
    //    6   14:areturn         
    }

    public static Roleminer[] makeCopies(Roleminer model, int num)
        throws Exception
    {
        if(model == null)
    //*   0    0:aload_0         
    //*   1    1:ifnonnull       14
            throw new Exception("No model associator set");
    //    2    4:new             #28  <Class Exception>
    //    3    7:dup             
    //    4    8:ldc1            #54  <String "No model associator set">
    //    5   10:invokespecial   #57  <Method void Exception(String)>
    //    6   13:athrow          
        Roleminer associators[] = new Roleminer[num];
    //    7   14:iload_1         
    //    8   15:anewarray       Roleminer[]
    //    9   18:astore_2        
        SerializedObject so = new SerializedObject(model);
    //   10   19:new             #41  <Class SerializedObject>
    //   11   22:dup             
    //   12   23:aload_0         
    //   13   24:invokespecial   #44  <Method void SerializedObject(Object)>
    //   14   27:astore_3        
        for(int i = 0; i < associators.length; i++)
    //*  15   28:iconst_0        
    //*  16   29:istore          4
    //*  17   31:goto            48
            associators[i] = (Roleminer)so.getObject();
    //   18   34:aload_2         
    //   19   35:iload           4
    //   20   37:aload_3         
    //   21   38:invokevirtual   #48  <Method Object SerializedObject.getObject()>
    //   22   41:checkcast       #8   <Class Roleminer>
    //   23   44:aastore         

    //   24   45:iinc            4  1
    //   25   48:iload           4
    //   26   50:aload_2         
    //   27   51:arraylength     
    //   28   52:icmplt          34
        return associators;
    //   29   55:aload_2         
    //   30   56:areturn         
    }

    public Capabilities getCapabilities()
    {
        Capabilities result = new Capabilities(this);
    //    0    0:new             #68  <Class Capabilities>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:invokespecial   #71  <Method void Capabilities(CapabilitiesHandler)>
    //    4    8:astore_1        
        result.enableAll();
    //    5    9:aload_1         
    //    6   10:invokevirtual   #74  <Method void Capabilities.enableAll()>
        return result;
    //    7   13:aload_1         
    //    8   14:areturn         
    }

    protected static void runRoleminer(Roleminer miner, String options[])
    {
        try
        {
            System.out.println(RoleminerEvaluation.evaluate(miner, options));
    //    0    0:getstatic       #84  <Field PrintStream System.out>
    //    1    3:aload_0         
    //    2    4:aload_1         
    //    3    5:invokestatic    #90  <Method String RoleminerEvaluation.evaluate(Roleminer, String[])>
    //    4    8:invokevirtual   #95  <Method void PrintStream.println(String)>
        }
    //*   5   11:goto            52
        catch(Exception e)
    //*   6   14:astore_2        
        {
            if(e.getMessage() != null && e.getMessage().indexOf("General options") == -1)
    //*   7   15:aload_2         
    //*   8   16:invokevirtual   #99  <Method String Exception.getMessage()>
    //*   9   19:ifnull          42
    //*  10   22:aload_2         
    //*  11   23:invokevirtual   #99  <Method String Exception.getMessage()>
    //*  12   26:ldc1            #101 <String "General options">
    //*  13   28:invokevirtual   #107 <Method int String.indexOf(String)>
    //*  14   31:iconst_m1       
    //*  15   32:icmpne          42
                e.printStackTrace();
    //   16   35:aload_2         
    //   17   36:invokevirtual   #110 <Method void Exception.printStackTrace()>
            else
    //*  18   39:goto            52
                System.err.println(e.getMessage());
    //   19   42:getstatic       #113 <Field PrintStream System.err>
    //   20   45:aload_2         
    //   21   46:invokevirtual   #99  <Method String Exception.getMessage()>
    //   22   49:invokevirtual   #95  <Method void PrintStream.println(String)>
        }
    //   23   52:return          
    }

    static Class class$0;
}
