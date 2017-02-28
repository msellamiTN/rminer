// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   Environment.java

package rm.core;

import java.io.PrintStream;
import java.util.*;

public class Environment
{

    public Environment()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #21  <Method void Object()>
        m_envVars = new TreeMap();
    //    2    4:aload_0         
    //    3    5:new             #23  <Class TreeMap>
    //    4    8:dup             
    //    5    9:invokespecial   #24  <Method void TreeMap()>
    //    6   12:putfield        #26  <Field Map m_envVars>
        Map env = System.getenv();
    //    7   15:invokestatic    #32  <Method Map System.getenv()>
    //    8   18:astore_1        
        Set keys = env.keySet();
    //    9   19:aload_1         
    //   10   20:invokeinterface #38  <Method Set Map.keySet()>
    //   11   25:astore_2        
        String kv;
        String value;
        for(Iterator i = keys.iterator(); i.hasNext(); m_envVars.put(kv, value))
    //*  12   26:aload_2         
    //*  13   27:invokeinterface #44  <Method Iterator Set.iterator()>
    //*  14   32:astore_3        
    //*  15   33:goto            74
        {
            kv = (String)i.next();
    //   16   36:aload_3         
    //   17   37:invokeinterface #50  <Method Object Iterator.next()>
    //   18   42:checkcast       #52  <Class String>
    //   19   45:astore          4
            value = (String)env.get(kv);
    //   20   47:aload_1         
    //   21   48:aload           4
    //   22   50:invokeinterface #56  <Method Object Map.get(Object)>
    //   23   55:checkcast       #52  <Class String>
    //   24   58:astore          5
        }

    //   25   60:aload_0         
    //   26   61:getfield        #26  <Field Map m_envVars>
    //   27   64:aload           4
    //   28   66:aload           5
    //   29   68:invokeinterface #60  <Method Object Map.put(Object, Object)>
    //   30   73:pop             
    //   31   74:aload_3         
    //   32   75:invokeinterface #64  <Method boolean Iterator.hasNext()>
    //   33   80:ifne            36
        Properties jvmProps = System.getProperties();
    //   34   83:invokestatic    #68  <Method Properties System.getProperties()>
    //   35   86:astore          4
        String kv;
        String value;
        for(Enumeration pKeys = jvmProps.propertyNames(); pKeys.hasMoreElements(); m_envVars.put(kv, value))
    //*  36   88:aload           4
    //*  37   90:invokevirtual   #74  <Method Enumeration Properties.propertyNames()>
    //*  38   93:astore          5
    //*  39   95:goto            136
        {
            kv = (String)(String)pKeys.nextElement();
    //   40   98:aload           5
    //   41  100:invokeinterface #79  <Method Object Enumeration.nextElement()>
    //   42  105:checkcast       #52  <Class String>
    //   43  108:checkcast       #52  <Class String>
    //   44  111:astore          6
            value = jvmProps.getProperty(kv);
    //   45  113:aload           4
    //   46  115:aload           6
    //   47  117:invokevirtual   #83  <Method String Properties.getProperty(String)>
    //   48  120:astore          7
        }

    //   49  122:aload_0         
    //   50  123:getfield        #26  <Field Map m_envVars>
    //   51  126:aload           6
    //   52  128:aload           7
    //   53  130:invokeinterface #60  <Method Object Map.put(Object, Object)>
    //   54  135:pop             
    //   55  136:aload           5
    //   56  138:invokeinterface #86  <Method boolean Enumeration.hasMoreElements()>
    //   57  143:ifne            98
    //   58  146:return          
    }

    public static Environment getSystemWide()
    {
        return m_systemWide;
    //    0    0:getstatic       #18  <Field Environment m_systemWide>
    //    1    3:areturn         
    }

    public static boolean containsEnvVariables(String source)
    {
        return source.indexOf("${") >= 0;
    //    0    0:aload_0         
    //    1    1:ldc1            #108 <String "${">
    //    2    3:invokevirtual   #112 <Method int String.indexOf(String)>
    //    3    6:iflt            11
    //    4    9:iconst_1        
    //    5   10:ireturn         
    //    6   11:iconst_0        
    //    7   12:ireturn         
    }

    public String substitute(String source)
        throws Exception
    {
        for(int index = source.indexOf("${"); index >= 0; index = source.indexOf("${"))
    //*   0    0:aload_1         
    //*   1    1:ldc1            #108 <String "${">
    //*   2    3:invokevirtual   #112 <Method int String.indexOf(String)>
    //*   3    6:istore_2        
    //*   4    7:goto            139
        {
            index += 2;
    //    5   10:iinc            2  2
            int endIndex = source.indexOf('}');
    //    6   13:aload_1         
    //    7   14:bipush          125
    //    8   16:invokevirtual   #120 <Method int String.indexOf(int)>
    //    9   19:istore_3        
            if(endIndex < 0 || endIndex <= index + 1)
                break;
    //   10   20:iload_3         
    //   11   21:iflt            143
    //   12   24:iload_3         
    //   13   25:iload_2         
    //   14   26:iconst_1        
    //   15   27:iadd            
    //   16   28:icmple          143
            String key = source.substring(index, endIndex);
    //   17   31:aload_1         
    //   18   32:iload_2         
    //   19   33:iload_3         
    //   20   34:invokevirtual   #124 <Method String String.substring(int, int)>
    //   21   37:astore          4
            String replace = (String)m_envVars.get(key);
    //   22   39:aload_0         
    //   23   40:getfield        #26  <Field Map m_envVars>
    //   24   43:aload           4
    //   25   45:invokeinterface #56  <Method Object Map.get(Object)>
    //   26   50:checkcast       #52  <Class String>
    //   27   53:astore          5
            if(replace != null)
    //*  28   55:aload           5
    //*  29   57:ifnull          96
            {
                String toReplace = (new StringBuilder("${")).append(key).append("}").toString();
    //   30   60:new             #126 <Class StringBuilder>
    //   31   63:dup             
    //   32   64:ldc1            #108 <String "${">
    //   33   66:invokespecial   #129 <Method void StringBuilder(String)>
    //   34   69:aload           4
    //   35   71:invokevirtual   #133 <Method StringBuilder StringBuilder.append(String)>
    //   36   74:ldc1            #135 <String "}">
    //   37   76:invokevirtual   #133 <Method StringBuilder StringBuilder.append(String)>
    //   38   79:invokevirtual   #139 <Method String StringBuilder.toString()>
    //   39   82:astore          6
                source = source.replace(toReplace, replace);
    //   40   84:aload_1         
    //   41   85:aload           6
    //   42   87:aload           5
    //   43   89:invokevirtual   #143 <Method String String.replace(CharSequence, CharSequence)>
    //   44   92:astore_1        
            } else
    //*  45   93:goto            132
            {
                throw new Exception((new StringBuilder("[Environment] Variable ")).append(key).append(" doesn't seem to be set.").toString());
    //   46   96:new             #117 <Class Exception>
    //   47   99:dup             
    //   48  100:new             #126 <Class StringBuilder>
    //   49  103:dup             
    //   50  104:ldc1            #145 <String "[Environment] Variable ">
    //   51  106:invokespecial   #129 <Method void StringBuilder(String)>
    //   52  109:aload           4
    //   53  111:invokevirtual   #133 <Method StringBuilder StringBuilder.append(String)>
    //   54  114:ldc1            #147 <String " doesn't seem to be set.">
    //   55  116:invokevirtual   #133 <Method StringBuilder StringBuilder.append(String)>
    //   56  119:invokevirtual   #139 <Method String StringBuilder.toString()>
    //   57  122:invokespecial   #148 <Method void Exception(String)>
    //   58  125:athrow          
            }
        }

    //   59  126:goto            132
    //   60  129:goto            143
    //   61  132:aload_1         
    //   62  133:ldc1            #108 <String "${">
    //   63  135:invokevirtual   #112 <Method int String.indexOf(String)>
    //   64  138:istore_2        
    //   65  139:iload_2         
    //   66  140:ifge            10
        return source;
    //   67  143:aload_1         
    //   68  144:areturn         
    }

    public void addVariable(String key, String value)
    {
        m_envVars.put(key, value);
    //    0    0:aload_0         
    //    1    1:getfield        #26  <Field Map m_envVars>
    //    2    4:aload_1         
    //    3    5:aload_2         
    //    4    6:invokeinterface #60  <Method Object Map.put(Object, Object)>
    //    5   11:pop             
    //    6   12:return          
    }

    public void removeVariable(String key)
    {
        m_envVars.remove(key);
    //    0    0:aload_0         
    //    1    1:getfield        #26  <Field Map m_envVars>
    //    2    4:aload_1         
    //    3    5:invokeinterface #159 <Method Object Map.remove(Object)>
    //    4   10:pop             
    //    5   11:return          
    }

    public Set getVariableNames()
    {
        return m_envVars.keySet();
    //    0    0:aload_0         
    //    1    1:getfield        #26  <Field Map m_envVars>
    //    2    4:invokeinterface #38  <Method Set Map.keySet()>
    //    3    9:areturn         
    }

    public String getVariableValue(String key)
    {
        return (String)m_envVars.get(key);
    //    0    0:aload_0         
    //    1    1:getfield        #26  <Field Map m_envVars>
    //    2    4:aload_1         
    //    3    5:invokeinterface #56  <Method Object Map.get(Object)>
    //    4   10:checkcast       #52  <Class String>
    //    5   13:areturn         
    }

    public static void main(String args[])
    {
        Environment t = new Environment();
    //    0    0:new             #2   <Class Environment>
    //    1    3:dup             
    //    2    4:invokespecial   #16  <Method void Environment()>
    //    3    7:astore_1        
        if(args.length == 0)
    //*   4    8:aload_0         
    //*   5    9:arraylength     
    //*   6   10:ifne            24
            System.err.println("Usage: java weka.core.Environment <string> <string> ...");
    //    7   13:getstatic       #168 <Field PrintStream System.err>
    //    8   16:ldc1            #170 <String "Usage: java weka.core.Environment <string> <string> ...">
    //    9   18:invokevirtual   #175 <Method void PrintStream.println(String)>
        else
    //*  10   21:goto            87
            try
            {
                for(int i = 0; i < args.length; i++)
    //*  11   24:iconst_0        
    //*  12   25:istore_2        
    //*  13   26:goto            73
                {
                    String newS = t.substitute(args[i]);
    //   14   29:aload_1         
    //   15   30:aload_0         
    //   16   31:iload_2         
    //   17   32:aaload          
    //   18   33:invokevirtual   #177 <Method String substitute(String)>
    //   19   36:astore_3        
                    System.out.println((new StringBuilder("Original string:\n")).append(args[i]).append("\n\nNew string:\n").append(newS).toString());
    //   20   37:getstatic       #180 <Field PrintStream System.out>
    //   21   40:new             #126 <Class StringBuilder>
    //   22   43:dup             
    //   23   44:ldc1            #182 <String "Original string:\n">
    //   24   46:invokespecial   #129 <Method void StringBuilder(String)>
    //   25   49:aload_0         
    //   26   50:iload_2         
    //   27   51:aaload          
    //   28   52:invokevirtual   #133 <Method StringBuilder StringBuilder.append(String)>
    //   29   55:ldc1            #184 <String "\n\nNew string:\n">
    //   30   57:invokevirtual   #133 <Method StringBuilder StringBuilder.append(String)>
    //   31   60:aload_3         
    //   32   61:invokevirtual   #133 <Method StringBuilder StringBuilder.append(String)>
    //   33   64:invokevirtual   #139 <Method String StringBuilder.toString()>
    //   34   67:invokevirtual   #175 <Method void PrintStream.println(String)>
                }

    //   35   70:iinc            2  1
    //   36   73:iload_2         
    //   37   74:aload_0         
    //   38   75:arraylength     
    //   39   76:icmplt          29
            }
    //*  40   79:goto            87
            catch(Exception ex)
    //*  41   82:astore_2        
            {
                ex.printStackTrace();
    //   42   83:aload_2         
    //   43   84:invokevirtual   #187 <Method void Exception.printStackTrace()>
            }
    //   44   87:return          
    }

    private static Environment m_systemWide = new Environment();
    private Map m_envVars;

    static 
    {
    //    0    0:new             #2   <Class Environment>
    //    1    3:dup             
    //    2    4:invokespecial   #16  <Method void Environment()>
    //    3    7:putstatic       #18  <Field Environment m_systemWide>
    //*   4   10:return          
    }
}
