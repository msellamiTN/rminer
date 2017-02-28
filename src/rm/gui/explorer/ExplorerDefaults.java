// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   ExplorerDefaults.java

package rm.gui.explorer;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.Properties;
import rm.assignment.Assignment;
import rm.assignment.Greed;
import rm.core.Utils;
import rm.generate.Generate;
import rm.generate.RandomGenerateData;
import rm.rolemining.ORCA;
import rm.rolemining.Roleminer;

public class ExplorerDefaults
    implements Serializable
{

    public ExplorerDefaults()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #61  <Method void Object()>
    //    2    4:return          
    }

    public static String get(String property, String defaultValue)
    {
        return PROPERTIES.getProperty(property, defaultValue);
    //    0    0:getstatic       #32  <Field Properties PROPERTIES>
    //    1    3:aload_0         
    //    2    4:aload_1         
    //    3    5:invokevirtual   #68  <Method String Properties.getProperty(String, String)>
    //    4    8:areturn         
    }

    public static final Properties getProperties()
    {
        return PROPERTIES;
    //    0    0:getstatic       #32  <Field Properties PROPERTIES>
    //    1    3:areturn         
    }

    protected static Object getObject(String property, String defaultValue)
    {
        return getObject(property, defaultValue, java/lang/Object);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:ldc1            #4   <Class Object>
    //    3    4:invokestatic    #77  <Method Object getObject(String, String, Class)>
    //    4    7:areturn         
    }

    protected static Object getObject(String property, String defaultValue, Class cls)
    {
        Object result = null;
    //    0    0:aconst_null     
    //    1    1:astore_3        
        try
        {
            String tmpStr = get(property, defaultValue);
    //    2    2:aload_0         
    //    3    3:aload_1         
    //    4    4:invokestatic    #79  <Method String get(String, String)>
    //    5    7:astore          4
            String tmpOptions[] = Utils.splitOptions(tmpStr);
    //    6    9:aload           4
    //    7   11:invokestatic    #83  <Method String[] Utils.splitOptions(String)>
    //    8   14:astore          5
            if(tmpOptions.length != 0)
    //*   9   16:aload           5
    //*  10   18:arraylength     
    //*  11   19:ifeq            55
            {
                tmpStr = tmpOptions[0];
    //   12   22:aload           5
    //   13   24:iconst_0        
    //   14   25:aaload          
    //   15   26:astore          4
                tmpOptions[0] = "";
    //   16   28:aload           5
    //   17   30:iconst_0        
    //   18   31:ldc1            #85  <String "">
    //   19   33:aastore         
                result = Utils.forName(cls, tmpStr, tmpOptions);
    //   20   34:aload_2         
    //   21   35:aload           4
    //   22   37:aload           5
    //   23   39:invokestatic    #89  <Method Object Utils.forName(Class, String, String[])>
    //   24   42:astore_3        
            }
        }
    //*  25   43:goto            55
        catch(Exception e)
    //*  26   46:astore          6
        {
            e.printStackTrace();
    //   27   48:aload           6
    //   28   50:invokevirtual   #51  <Method void Exception.printStackTrace()>
            result = null;
    //   29   53:aconst_null     
    //   30   54:astore_3        
        }
        return result;
    //   31   55:aload_3         
    //   32   56:areturn         
    }

    public static boolean getInitGenericObjectEditorFilter()
    {
        return Boolean.parseBoolean(get("InitGenericObjectEditorFilter", "false"));
    //    0    0:ldc1            #99  <String "InitGenericObjectEditorFilter">
    //    1    2:ldc1            #101 <String "false">
    //    2    4:invokestatic    #79  <Method String get(String, String)>
    //    3    7:invokestatic    #107 <Method boolean Boolean.parseBoolean(String)>
    //    4   10:ireturn         
    }

    public static synchronized String getInitialDirectory()
    {
        String result = get("InitialDirectory", "%c");
    //    0    0:ldc1            #111 <String "InitialDirectory">
    //    1    2:ldc1            #113 <String "%c">
    //    2    4:invokestatic    #79  <Method String get(String, String)>
    //    3    7:astore_0        
        result = result.replaceAll("%t", System.getProperty("java.io.tmpdir"));
    //    4    8:aload_0         
    //    5    9:ldc1            #115 <String "%t">
    //    6   11:ldc1            #117 <String "java.io.tmpdir">
    //    7   13:invokestatic    #120 <Method String System.getProperty(String)>
    //    8   16:invokevirtual   #125 <Method String String.replaceAll(String, String)>
    //    9   19:astore_0        
        result = result.replaceAll("%h", System.getProperty("user.home"));
    //   10   20:aload_0         
    //   11   21:ldc1            #127 <String "%h">
    //   12   23:ldc1            #129 <String "user.home">
    //   13   25:invokestatic    #120 <Method String System.getProperty(String)>
    //   14   28:invokevirtual   #125 <Method String String.replaceAll(String, String)>
    //   15   31:astore_0        
        result = result.replaceAll("%c", System.getProperty("user.dir"));
    //   16   32:aload_0         
    //   17   33:ldc1            #113 <String "%c">
    //   18   35:ldc1            #131 <String "user.dir">
    //   19   37:invokestatic    #120 <Method String System.getProperty(String)>
    //   20   40:invokevirtual   #125 <Method String String.replaceAll(String, String)>
    //   21   43:astore_0        
        result = result.replaceAll("%%", System.getProperty("%"));
    //   22   44:aload_0         
    //   23   45:ldc1            #133 <String "%%">
    //   24   47:ldc1            #135 <String "%">
    //   25   49:invokestatic    #120 <Method String System.getProperty(String)>
    //   26   52:invokevirtual   #125 <Method String String.replaceAll(String, String)>
    //   27   55:astore_0        
        return result;
    //   28   56:aload_0         
    //   29   57:areturn         
    }

    public static Object getRoleminer()
    {
        Object result = getObject("RoleMiner", rm/rolemining/ORCA.getName(), rm/rolemining/Roleminer);
    //    0    0:ldc1            #139 <String "RoleMiner">
    //    1    2:ldc1            #141 <Class ORCA>
    //    2    4:invokevirtual   #146 <Method String Class.getName()>
    //    3    7:ldc1            #148 <Class Roleminer>
    //    4    9:invokestatic    #77  <Method Object getObject(String, String, Class)>
    //    5   12:astore_0        
        if(result == null)
    //*   6   13:aload_0         
    //*   7   14:ifnonnull       25
            result = new ORCA();
    //    8   17:new             #141 <Class ORCA>
    //    9   20:dup             
    //   10   21:invokespecial   #149 <Method void ORCA()>
    //   11   24:astore_0        
        return result;
    //   12   25:aload_0         
    //   13   26:areturn         
    }

    public static Object getAssigner()
    {
        Object result = getObject("Assignment", rm/assignment/Greed.getName(), rm/assignment/Assignment);
    //    0    0:ldc1            #152 <String "Assignment">
    //    1    2:ldc1            #154 <Class Greed>
    //    2    4:invokevirtual   #146 <Method String Class.getName()>
    //    3    7:ldc1            #156 <Class Assignment>
    //    4    9:invokestatic    #77  <Method Object getObject(String, String, Class)>
    //    5   12:astore_0        
        if(result == null)
    //*   6   13:aload_0         
    //*   7   14:ifnonnull       25
            result = new Greed();
    //    8   17:new             #154 <Class Greed>
    //    9   20:dup             
    //   10   21:invokespecial   #157 <Method void Greed()>
    //   11   24:astore_0        
        return result;
    //   12   25:aload_0         
    //   13   26:areturn         
    }

    public static Object getGenerater()
    {
        Object result = getObject("Generate", rm/generate/RandomGenerateData.getName(), rm/generate/Generate);
    //    0    0:ldc1            #160 <String "Generate">
    //    1    2:ldc1            #162 <Class RandomGenerateData>
    //    2    4:invokevirtual   #146 <Method String Class.getName()>
    //    3    7:ldc1            #164 <Class Generate>
    //    4    9:invokestatic    #77  <Method Object getObject(String, String, Class)>
    //    5   12:astore_0        
        if(result == null)
    //*   6   13:aload_0         
    //*   7   14:ifnonnull       25
            result = new RandomGenerateData();
    //    8   17:new             #162 <Class RandomGenerateData>
    //    9   20:dup             
    //   10   21:invokespecial   #165 <Method void RandomGenerateData()>
    //   11   24:astore_0        
        return result;
    //   12   25:aload_0         
    //   13   26:areturn         
    }

    public static final String PROPERTY_FILE = "rm/gui/explorer/Explorer.props";
    protected static Properties PROPERTIES;
    static Class class$0;
    static Class class$1;
    static Class class$2;
    static Class class$3;
    static Class class$4;
    static Class class$5;
    static Class class$6;

    static 
    {
        try
        {
            PROPERTIES = Utils.readProperties("rm/gui/explorer/Explorer.props");
    //    0    0:ldc1            #11  <String "rm/gui/explorer/Explorer.props">
    //    1    2:invokestatic    #30  <Method Properties Utils.readProperties(String)>
    //    2    5:putstatic       #32  <Field Properties PROPERTIES>
        }
    //*   3    8:goto            34
        catch(Exception e)
    //*   4   11:astore_0        
        {
            System.err.println("Problem reading properties. Fix before continuing.");
    //    5   12:getstatic       #38  <Field PrintStream System.err>
    //    6   15:ldc1            #40  <String "Problem reading properties. Fix before continuing.">
    //    7   17:invokevirtual   #46  <Method void PrintStream.println(String)>
            e.printStackTrace();
    //    8   20:aload_0         
    //    9   21:invokevirtual   #51  <Method void Exception.printStackTrace()>
            PROPERTIES = new Properties();
    //   10   24:new             #53  <Class Properties>
    //   11   27:dup             
    //   12   28:invokespecial   #56  <Method void Properties()>
    //   13   31:putstatic       #32  <Field Properties PROPERTIES>
        }
    //*  14   34:return          
    }
}
