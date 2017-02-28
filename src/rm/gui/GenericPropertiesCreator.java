// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   GenericPropertiesCreator.java

package rm.gui;

import java.io.*;
import java.util.*;
import rm.core.ClassDiscovery;
import rm.core.Utils;

public class GenericPropertiesCreator
{

    public GenericPropertiesCreator()
        throws Exception
    {
        this(CREATOR_FILE);
    //    0    0:aload_0         
    //    1    1:getstatic       #35  <Field String CREATOR_FILE>
    //    2    4:invokespecial   #64  <Method void GenericPropertiesCreator(String)>
        m_ExplicitPropsFile = false;
    //    3    7:aload_0         
    //    4    8:iconst_0        
    //    5    9:putfield        #66  <Field boolean m_ExplicitPropsFile>
    //    6   12:return          
    }

    public GenericPropertiesCreator(String filename)
        throws Exception
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #70  <Method void Object()>
        m_InputFilename = filename;
    //    2    4:aload_0         
    //    3    5:aload_1         
    //    4    6:putfield        #72  <Field String m_InputFilename>
        m_OutputFilename = PROPERTY_FILE;
    //    5    9:aload_0         
    //    6   10:getstatic       #55  <Field String PROPERTY_FILE>
    //    7   13:putfield        #74  <Field String m_OutputFilename>
        m_InputProperties = null;
    //    8   16:aload_0         
    //    9   17:aconst_null     
    //   10   18:putfield        #76  <Field Properties m_InputProperties>
        m_OutputProperties = null;
    //   11   21:aload_0         
    //   12   22:aconst_null     
    //   13   23:putfield        #78  <Field Properties m_OutputProperties>
        m_ExplicitPropsFile = true;
    //   14   26:aload_0         
    //   15   27:iconst_1        
    //   16   28:putfield        #66  <Field boolean m_ExplicitPropsFile>
        m_Excludes = new Hashtable();
    //   17   31:aload_0         
    //   18   32:new             #80  <Class Hashtable>
    //   19   35:dup             
    //   20   36:invokespecial   #81  <Method void Hashtable()>
    //   21   39:putfield        #83  <Field Hashtable m_Excludes>
    //   22   42:return          
    }

    public void setExplicitPropsFile(boolean value)
    {
        m_ExplicitPropsFile = value;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #66  <Field boolean m_ExplicitPropsFile>
    //    3    5:return          
    }

    public boolean getExplicitPropsFile()
    {
        return m_ExplicitPropsFile;
    //    0    0:aload_0         
    //    1    1:getfield        #66  <Field boolean m_ExplicitPropsFile>
    //    2    4:ireturn         
    }

    public String getOutputFilename()
    {
        return m_OutputFilename;
    //    0    0:aload_0         
    //    1    1:getfield        #74  <Field String m_OutputFilename>
    //    2    4:areturn         
    }

    public void setOutputFilename(String filename)
    {
        m_OutputFilename = filename;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #74  <Field String m_OutputFilename>
    //    3    5:return          
    }

    public String getInputFilename()
    {
        return m_InputFilename;
    //    0    0:aload_0         
    //    1    1:getfield        #72  <Field String m_InputFilename>
    //    2    4:areturn         
    }

    public void setInputFilename(String filename)
    {
        m_InputFilename = filename;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #72  <Field String m_InputFilename>
        setExplicitPropsFile(true);
    //    3    5:aload_0         
    //    4    6:iconst_1        
    //    5    7:invokevirtual   #96  <Method void setExplicitPropsFile(boolean)>
    //    6   10:return          
    }

    public Properties getInputProperties()
    {
        return m_InputProperties;
    //    0    0:aload_0         
    //    1    1:getfield        #76  <Field Properties m_InputProperties>
    //    2    4:areturn         
    }

    public Properties getOutputProperties()
    {
        return m_OutputProperties;
    //    0    0:aload_0         
    //    1    1:getfield        #78  <Field Properties m_OutputProperties>
    //    2    4:areturn         
    }

    protected void loadInputProperties()
    {
        m_InputProperties = new Properties();
    //    0    0:aload_0         
    //    1    1:new             #102 <Class Properties>
    //    2    4:dup             
    //    3    5:invokespecial   #103 <Method void Properties()>
    //    4    8:putfield        #76  <Field Properties m_InputProperties>
        try
        {
            File f = new File(getInputFilename());
    //    5   11:new             #105 <Class File>
    //    6   14:dup             
    //    7   15:aload_0         
    //    8   16:invokevirtual   #107 <Method String getInputFilename()>
    //    9   19:invokespecial   #108 <Method void File(String)>
    //   10   22:astore_1        
            if(getExplicitPropsFile() && f.exists())
    //*  11   23:aload_0         
    //*  12   24:invokevirtual   #110 <Method boolean getExplicitPropsFile()>
    //*  13   27:ifeq            58
    //*  14   30:aload_1         
    //*  15   31:invokevirtual   #113 <Method boolean File.exists()>
    //*  16   34:ifeq            58
                m_InputProperties.load(new FileInputStream(getInputFilename()));
    //   17   37:aload_0         
    //   18   38:getfield        #76  <Field Properties m_InputProperties>
    //   19   41:new             #115 <Class FileInputStream>
    //   20   44:dup             
    //   21   45:aload_0         
    //   22   46:invokevirtual   #107 <Method String getInputFilename()>
    //   23   49:invokespecial   #116 <Method void FileInputStream(String)>
    //   24   52:invokevirtual   #120 <Method void Properties.load(java.io.InputStream)>
            else
    //*  25   55:goto            69
                m_InputProperties = Utils.readProperties(getInputFilename());
    //   26   58:aload_0         
    //   27   59:aload_0         
    //   28   60:invokevirtual   #107 <Method String getInputFilename()>
    //   29   63:invokestatic    #126 <Method Properties Utils.readProperties(String)>
    //   30   66:putfield        #76  <Field Properties m_InputProperties>
            m_Excludes.clear();
    //   31   69:aload_0         
    //   32   70:getfield        #83  <Field Hashtable m_Excludes>
    //   33   73:invokevirtual   #129 <Method void Hashtable.clear()>
            Properties p = Utils.readProperties(EXCLUDE_FILE);
    //   34   76:getstatic       #39  <Field String EXCLUDE_FILE>
    //   35   79:invokestatic    #126 <Method Properties Utils.readProperties(String)>
    //   36   82:astore_2        
            for(Enumeration enm = p.propertyNames(); enm.hasMoreElements();)
    //*  37   83:aload_2         
    //*  38   84:invokevirtual   #133 <Method Enumeration Properties.propertyNames()>
    //*  39   87:astore_3        
    //*  40   88:goto            358
            {
                String name = enm.nextElement().toString();
    //   41   91:aload_3         
    //   42   92:invokeinterface #139 <Method Object Enumeration.nextElement()>
    //   43   97:invokevirtual   #142 <Method String Object.toString()>
    //   44  100:astore          4
                Hashtable t = new Hashtable();
    //   45  102:new             #80  <Class Hashtable>
    //   46  105:dup             
    //   47  106:invokespecial   #81  <Method void Hashtable()>
    //   48  109:astore          5
                m_Excludes.put(name, t);
    //   49  111:aload_0         
    //   50  112:getfield        #83  <Field Hashtable m_Excludes>
    //   51  115:aload           4
    //   52  117:aload           5
    //   53  119:invokevirtual   #146 <Method Object Hashtable.put(Object, Object)>
    //   54  122:pop             
                t.put(EXCLUDE_INTERFACE, new Vector());
    //   55  123:aload           5
    //   56  125:getstatic       #43  <Field String EXCLUDE_INTERFACE>
    //   57  128:new             #148 <Class Vector>
    //   58  131:dup             
    //   59  132:invokespecial   #149 <Method void Vector()>
    //   60  135:invokevirtual   #146 <Method Object Hashtable.put(Object, Object)>
    //   61  138:pop             
                t.put(EXCLUDE_CLASS, new Vector());
    //   62  139:aload           5
    //   63  141:getstatic       #47  <Field String EXCLUDE_CLASS>
    //   64  144:new             #148 <Class Vector>
    //   65  147:dup             
    //   66  148:invokespecial   #149 <Method void Vector()>
    //   67  151:invokevirtual   #146 <Method Object Hashtable.put(Object, Object)>
    //   68  154:pop             
                t.put(EXCLUDE_SUPERCLASS, new Vector());
    //   69  155:aload           5
    //   70  157:getstatic       #51  <Field String EXCLUDE_SUPERCLASS>
    //   71  160:new             #148 <Class Vector>
    //   72  163:dup             
    //   73  164:invokespecial   #149 <Method void Vector()>
    //   74  167:invokevirtual   #146 <Method Object Hashtable.put(Object, Object)>
    //   75  170:pop             
                String item;
                Vector list;
                for(StringTokenizer tok = new StringTokenizer(p.getProperty(name), ","); tok.hasMoreTokens(); list.add(item.substring(item.indexOf(":") + 1)))
    //*  76  171:new             #151 <Class StringTokenizer>
    //*  77  174:dup             
    //*  78  175:aload_2         
    //*  79  176:aload           4
    //*  80  178:invokevirtual   #155 <Method String Properties.getProperty(String)>
    //*  81  181:ldc1            #157 <String ",">
    //*  82  183:invokespecial   #160 <Method void StringTokenizer(String, String)>
    //*  83  186:astore          6
    //*  84  188:goto            350
                {
                    item = tok.nextToken();
    //   85  191:aload           6
    //   86  193:invokevirtual   #163 <Method String StringTokenizer.nextToken()>
    //   87  196:astore          7
                    list = new Vector();
    //   88  198:new             #148 <Class Vector>
    //   89  201:dup             
    //   90  202:invokespecial   #149 <Method void Vector()>
    //   91  205:astore          8
                    if(item.startsWith((new StringBuilder(String.valueOf(EXCLUDE_INTERFACE))).append(":").toString()))
    //*  92  207:aload           7
    //*  93  209:new             #165 <Class StringBuilder>
    //*  94  212:dup             
    //*  95  213:getstatic       #43  <Field String EXCLUDE_INTERFACE>
    //*  96  216:invokestatic    #171 <Method String String.valueOf(Object)>
    //*  97  219:invokespecial   #172 <Method void StringBuilder(String)>
    //*  98  222:ldc1            #174 <String ":">
    //*  99  224:invokevirtual   #178 <Method StringBuilder StringBuilder.append(String)>
    //* 100  227:invokevirtual   #179 <Method String StringBuilder.toString()>
    //* 101  230:invokevirtual   #183 <Method boolean String.startsWith(String)>
    //* 102  233:ifeq            255
                        list = (Vector)(Vector)t.get(EXCLUDE_INTERFACE);
    //  103  236:aload           5
    //  104  238:getstatic       #43  <Field String EXCLUDE_INTERFACE>
    //  105  241:invokevirtual   #187 <Method Object Hashtable.get(Object)>
    //  106  244:checkcast       #148 <Class Vector>
    //  107  247:checkcast       #148 <Class Vector>
    //  108  250:astore          8
                    else
    //* 109  252:goto            330
                    if(item.startsWith((new StringBuilder(String.valueOf(EXCLUDE_CLASS))).append(":").toString()))
    //* 110  255:aload           7
    //* 111  257:new             #165 <Class StringBuilder>
    //* 112  260:dup             
    //* 113  261:getstatic       #47  <Field String EXCLUDE_CLASS>
    //* 114  264:invokestatic    #171 <Method String String.valueOf(Object)>
    //* 115  267:invokespecial   #172 <Method void StringBuilder(String)>
    //* 116  270:ldc1            #174 <String ":">
    //* 117  272:invokevirtual   #178 <Method StringBuilder StringBuilder.append(String)>
    //* 118  275:invokevirtual   #179 <Method String StringBuilder.toString()>
    //* 119  278:invokevirtual   #183 <Method boolean String.startsWith(String)>
    //* 120  281:ifeq            303
                        list = (Vector)(Vector)t.get(EXCLUDE_CLASS);
    //  121  284:aload           5
    //  122  286:getstatic       #47  <Field String EXCLUDE_CLASS>
    //  123  289:invokevirtual   #187 <Method Object Hashtable.get(Object)>
    //  124  292:checkcast       #148 <Class Vector>
    //  125  295:checkcast       #148 <Class Vector>
    //  126  298:astore          8
                    else
    //* 127  300:goto            330
                    if(item.startsWith(EXCLUDE_SUPERCLASS))
    //* 128  303:aload           7
    //* 129  305:getstatic       #51  <Field String EXCLUDE_SUPERCLASS>
    //* 130  308:invokevirtual   #183 <Method boolean String.startsWith(String)>
    //* 131  311:ifeq            330
                        list = (Vector)(Vector)t.get(EXCLUDE_SUPERCLASS);
    //  132  314:aload           5
    //  133  316:getstatic       #51  <Field String EXCLUDE_SUPERCLASS>
    //  134  319:invokevirtual   #187 <Method Object Hashtable.get(Object)>
    //  135  322:checkcast       #148 <Class Vector>
    //  136  325:checkcast       #148 <Class Vector>
    //  137  328:astore          8
                }

    //  138  330:aload           8
    //  139  332:aload           7
    //  140  334:aload           7
    //  141  336:ldc1            #174 <String ":">
    //  142  338:invokevirtual   #191 <Method int String.indexOf(String)>
    //  143  341:iconst_1        
    //  144  342:iadd            
    //  145  343:invokevirtual   #195 <Method String String.substring(int)>
    //  146  346:invokevirtual   #199 <Method boolean Vector.add(Object)>
    //  147  349:pop             
    //  148  350:aload           6
    //  149  352:invokevirtual   #202 <Method boolean StringTokenizer.hasMoreTokens()>
    //  150  355:ifne            191
            }

    //  151  358:aload_3         
    //  152  359:invokeinterface #205 <Method boolean Enumeration.hasMoreElements()>
    //  153  364:ifne            91
        }
    //* 154  367:goto            375
        catch(Exception e)
    //* 155  370:astore_1        
        {
            e.printStackTrace();
    //  156  371:aload_1         
    //  157  372:invokevirtual   #208 <Method void Exception.printStackTrace()>
        }
    //  158  375:return          
    }

    public boolean useDynamic()
    {
        if(getInputProperties() == null)
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #225 <Method Properties getInputProperties()>
    //*   2    4:ifnonnull       11
            loadInputProperties();
    //    3    7:aload_0         
    //    4    8:invokevirtual   #227 <Method void loadInputProperties()>
        if(!ClassLoader.getSystemClassLoader().equals(getClass().getClassLoader()))
    //*   5   11:invokestatic    #233 <Method ClassLoader ClassLoader.getSystemClassLoader()>
    //*   6   14:aload_0         
    //*   7   15:invokevirtual   #237 <Method Class Object.getClass()>
    //*   8   18:invokevirtual   #242 <Method ClassLoader Class.getClassLoader()>
    //*   9   21:invokevirtual   #245 <Method boolean Object.equals(Object)>
    //*  10   24:ifne            55
        {
            if(Boolean.parseBoolean(getInputProperties().getProperty("UseDynamic", "true")))
    //*  11   27:aload_0         
    //*  12   28:invokevirtual   #225 <Method Properties getInputProperties()>
    //*  13   31:ldc1            #12  <String "UseDynamic">
    //*  14   33:ldc1            #247 <String "true">
    //*  15   35:invokevirtual   #250 <Method String Properties.getProperty(String, String)>
    //*  16   38:invokestatic    #255 <Method boolean Boolean.parseBoolean(String)>
    //*  17   41:ifeq            53
                System.out.println("[GenericPropertiesCreator] classloader in use is not the system classloader: using static entries in weka/gui/GenericObjectEditor.props rather than dynamic class discovery.");
    //   18   44:getstatic       #261 <Field PrintStream System.out>
    //   19   47:ldc2            #263 <String "[GenericPropertiesCreator] classloader in use is not the system classloader: using static entries in weka/gui/GenericObjectEditor.props rather than dynamic class discovery.">
    //   20   50:invokevirtual   #268 <Method void PrintStream.println(String)>
            return false;
    //   21   53:iconst_0        
    //   22   54:ireturn         
        } else
        {
            return Boolean.parseBoolean(getInputProperties().getProperty("UseDynamic", "true"));
    //   23   55:aload_0         
    //   24   56:invokevirtual   #225 <Method Properties getInputProperties()>
    //   25   59:ldc1            #12  <String "UseDynamic">
    //   26   61:ldc1            #247 <String "true">
    //   27   63:invokevirtual   #250 <Method String Properties.getProperty(String, String)>
    //   28   66:invokestatic    #255 <Method boolean Boolean.parseBoolean(String)>
    //   29   69:ireturn         
        }
    }

    protected boolean isValidClassname(String classname)
    {
        return classname.indexOf("$") == -1;
    //    0    0:aload_1         
    //    1    1:ldc2            #271 <String "$">
    //    2    4:invokevirtual   #191 <Method int String.indexOf(String)>
    //    3    7:iconst_m1       
    //    4    8:icmpne          13
    //    5   11:iconst_1        
    //    6   12:ireturn         
    //    7   13:iconst_0        
    //    8   14:ireturn         
    }

    protected boolean isValidClassname(String key, String classname)
    {
        boolean result = true;
    //    0    0:iconst_1        
    //    1    1:istore_3        
        if(m_Excludes.containsKey(key))
    //*   2    2:aload_0         
    //*   3    3:getfield        #83  <Field Hashtable m_Excludes>
    //*   4    6:aload_1         
    //*   5    7:invokevirtual   #276 <Method boolean Hashtable.containsKey(Object)>
    //*   6   10:ifeq            303
        {
            Class clsCurrent;
            try
            {
                clsCurrent = Class.forName(classname);
    //    7   13:aload_2         
    //    8   14:invokestatic    #280 <Method Class Class.forName(String)>
    //    9   17:astore          5
            }
    //*  10   19:goto            27
            catch(Exception e)
    //*  11   22:astore          8
            {
                clsCurrent = null;
    //   12   24:aconst_null     
    //   13   25:astore          5
            }
            if(clsCurrent != null && result)
    //*  14   27:aload           5
    //*  15   29:ifnull          118
    //*  16   32:iload_3         
    //*  17   33:ifeq            118
            {
                Vector list = (Vector)(Vector)((Hashtable)(Hashtable)m_Excludes.get(key)).get(EXCLUDE_INTERFACE);
    //   18   36:aload_0         
    //   19   37:getfield        #83  <Field Hashtable m_Excludes>
    //   20   40:aload_1         
    //   21   41:invokevirtual   #187 <Method Object Hashtable.get(Object)>
    //   22   44:checkcast       #80  <Class Hashtable>
    //   23   47:checkcast       #80  <Class Hashtable>
    //   24   50:getstatic       #43  <Field String EXCLUDE_INTERFACE>
    //   25   53:invokevirtual   #187 <Method Object Hashtable.get(Object)>
    //   26   56:checkcast       #148 <Class Vector>
    //   27   59:checkcast       #148 <Class Vector>
    //   28   62:astore          6
                for(int i = 0; i < list.size();)
    //*  29   64:iconst_0        
    //*  30   65:istore          7
    //*  31   67:goto            108
                    try
                    {
                        Class cls = Class.forName(list.get(i).toString());
    //   32   70:aload           6
    //   33   72:iload           7
    //   34   74:invokevirtual   #283 <Method Object Vector.get(int)>
    //   35   77:invokevirtual   #142 <Method String Object.toString()>
    //   36   80:invokestatic    #280 <Method Class Class.forName(String)>
    //   37   83:astore          4
                        if(!ClassDiscovery.hasInterface(cls, clsCurrent))
                            continue;
    //   38   85:aload           4
    //   39   87:aload           5
    //   40   89:invokestatic    #289 <Method boolean ClassDiscovery.hasInterface(Class, Class)>
    //   41   92:ifeq            105
                        result = false;
    //   42   95:iconst_0        
    //   43   96:istore_3        
                        break;
    //   44   97:goto            118
                    }
    //*  45  100:goto            105
                    catch(Exception exception)
    //*  46  103:astore          8
                    {
                        i++;
    //   47  105:iinc            7  1
                    }

    //   48  108:iload           7
    //   49  110:aload           6
    //   50  112:invokevirtual   #293 <Method int Vector.size()>
    //   51  115:icmplt          70
            }
            if(clsCurrent != null && result)
    //*  52  118:aload           5
    //*  53  120:ifnull          209
    //*  54  123:iload_3         
    //*  55  124:ifeq            209
            {
                Vector list = (Vector)(Vector)((Hashtable)(Hashtable)m_Excludes.get(key)).get(EXCLUDE_SUPERCLASS);
    //   56  127:aload_0         
    //   57  128:getfield        #83  <Field Hashtable m_Excludes>
    //   58  131:aload_1         
    //   59  132:invokevirtual   #187 <Method Object Hashtable.get(Object)>
    //   60  135:checkcast       #80  <Class Hashtable>
    //   61  138:checkcast       #80  <Class Hashtable>
    //   62  141:getstatic       #51  <Field String EXCLUDE_SUPERCLASS>
    //   63  144:invokevirtual   #187 <Method Object Hashtable.get(Object)>
    //   64  147:checkcast       #148 <Class Vector>
    //   65  150:checkcast       #148 <Class Vector>
    //   66  153:astore          6
                for(int i = 0; i < list.size();)
    //*  67  155:iconst_0        
    //*  68  156:istore          7
    //*  69  158:goto            199
                    try
                    {
                        Class cls = Class.forName(list.get(i).toString());
    //   70  161:aload           6
    //   71  163:iload           7
    //   72  165:invokevirtual   #283 <Method Object Vector.get(int)>
    //   73  168:invokevirtual   #142 <Method String Object.toString()>
    //   74  171:invokestatic    #280 <Method Class Class.forName(String)>
    //   75  174:astore          4
                        if(!ClassDiscovery.isSubclass(cls, clsCurrent))
                            continue;
    //   76  176:aload           4
    //   77  178:aload           5
    //   78  180:invokestatic    #296 <Method boolean ClassDiscovery.isSubclass(Class, Class)>
    //   79  183:ifeq            196
                        result = false;
    //   80  186:iconst_0        
    //   81  187:istore_3        
                        break;
    //   82  188:goto            209
                    }
    //*  83  191:goto            196
                    catch(Exception exception1)
    //*  84  194:astore          8
                    {
                        i++;
    //   85  196:iinc            7  1
                    }

    //   86  199:iload           7
    //   87  201:aload           6
    //   88  203:invokevirtual   #293 <Method int Vector.size()>
    //   89  206:icmplt          161
            }
            if(clsCurrent != null && result)
    //*  90  209:aload           5
    //*  91  211:ifnull          303
    //*  92  214:iload_3         
    //*  93  215:ifeq            303
            {
                Vector list = (Vector)(Vector)((Hashtable)(Hashtable)m_Excludes.get(key)).get(EXCLUDE_CLASS);
    //   94  218:aload_0         
    //   95  219:getfield        #83  <Field Hashtable m_Excludes>
    //   96  222:aload_1         
    //   97  223:invokevirtual   #187 <Method Object Hashtable.get(Object)>
    //   98  226:checkcast       #80  <Class Hashtable>
    //   99  229:checkcast       #80  <Class Hashtable>
    //  100  232:getstatic       #47  <Field String EXCLUDE_CLASS>
    //  101  235:invokevirtual   #187 <Method Object Hashtable.get(Object)>
    //  102  238:checkcast       #148 <Class Vector>
    //  103  241:checkcast       #148 <Class Vector>
    //  104  244:astore          6
                for(int i = 0; i < list.size(); i++)
    //* 105  246:iconst_0        
    //* 106  247:istore          7
    //* 107  249:goto            293
                    try
                    {
                        Class cls = Class.forName(list.get(i).toString());
    //  108  252:aload           6
    //  109  254:iload           7
    //  110  256:invokevirtual   #283 <Method Object Vector.get(int)>
    //  111  259:invokevirtual   #142 <Method String Object.toString()>
    //  112  262:invokestatic    #280 <Method Class Class.forName(String)>
    //  113  265:astore          4
                        if(cls.getName().equals(clsCurrent.getName()))
    //* 114  267:aload           4
    //* 115  269:invokevirtual   #299 <Method String Class.getName()>
    //* 116  272:aload           5
    //* 117  274:invokevirtual   #299 <Method String Class.getName()>
    //* 118  277:invokevirtual   #300 <Method boolean String.equals(Object)>
    //* 119  280:ifeq            290
                            result = false;
    //  120  283:iconst_0        
    //  121  284:istore_3        
                    }
    //* 122  285:goto            290
                    catch(Exception exception2) { }
    //  123  288:astore          8

    //  124  290:iinc            7  1
    //  125  293:iload           7
    //  126  295:aload           6
    //  127  297:invokevirtual   #293 <Method int Vector.size()>
    //  128  300:icmplt          252
            }
        }
        return result;
    //  129  303:iload_3         
    //  130  304:ireturn         
    }

    protected void generateOutputProperties()
        throws Exception
    {
        m_OutputProperties = new Properties();
    //    0    0:aload_0         
    //    1    1:new             #102 <Class Properties>
    //    2    4:dup             
    //    3    5:invokespecial   #103 <Method void Properties()>
    //    4    8:putfield        #78  <Field Properties m_OutputProperties>
        for(Enumeration keys = m_InputProperties.propertyNames(); keys.hasMoreElements();)
    //*   5   11:aload_0         
    //*   6   12:getfield        #76  <Field Properties m_InputProperties>
    //*   7   15:invokevirtual   #133 <Method Enumeration Properties.propertyNames()>
    //*   8   18:astore_1        
    //*   9   19:goto            345
        {
            String key = keys.nextElement().toString();
    //   10   22:aload_1         
    //   11   23:invokeinterface #139 <Method Object Enumeration.nextElement()>
    //   12   28:invokevirtual   #142 <Method String Object.toString()>
    //   13   31:astore_2        
            if(!key.equals("UseDynamic"))
    //*  14   32:aload_2         
    //*  15   33:ldc1            #12  <String "UseDynamic">
    //*  16   35:invokevirtual   #300 <Method boolean String.equals(Object)>
    //*  17   38:ifeq            44
    //*  18   41:goto            345
            {
                StringTokenizer tok = new StringTokenizer(m_InputProperties.getProperty(key), ",");
    //   19   44:new             #151 <Class StringTokenizer>
    //   20   47:dup             
    //   21   48:aload_0         
    //   22   49:getfield        #76  <Field Properties m_InputProperties>
    //   23   52:aload_2         
    //   24   53:invokevirtual   #155 <Method String Properties.getProperty(String)>
    //   25   56:ldc1            #157 <String ",">
    //   26   58:invokespecial   #160 <Method void StringTokenizer(String, String)>
    //   27   61:astore          5
                HashSet names = new HashSet();
    //   28   63:new             #308 <Class HashSet>
    //   29   66:dup             
    //   30   67:invokespecial   #309 <Method void HashSet()>
    //   31   70:astore          7
    //*  32   72:goto            217
                Vector classes;
                while(tok.hasMoreTokens()) 
                {
                    String pkg = tok.nextToken().trim();
    //   33   75:aload           5
    //   34   77:invokevirtual   #163 <Method String StringTokenizer.nextToken()>
    //   35   80:invokevirtual   #312 <Method String String.trim()>
    //   36   83:astore          4
                    try
                    {
                        classes = ClassDiscovery.find(Class.forName(key), pkg);
    //   37   85:aload_2         
    //   38   86:invokestatic    #280 <Method Class Class.forName(String)>
    //   39   89:aload           4
    //   40   91:invokestatic    #316 <Method Vector ClassDiscovery.find(Class, String)>
    //   41   94:astore          6
                    }
    //*  42   96:goto            144
                    catch(Exception e)
    //*  43   99:astore          9
                    {
                        System.out.println((new StringBuilder("Problem with '")).append(key).append("': ").append(e).toString());
    //   44  101:getstatic       #261 <Field PrintStream System.out>
    //   45  104:new             #165 <Class StringBuilder>
    //   46  107:dup             
    //   47  108:ldc2            #318 <String "Problem with '">
    //   48  111:invokespecial   #172 <Method void StringBuilder(String)>
    //   49  114:aload_2         
    //   50  115:invokevirtual   #178 <Method StringBuilder StringBuilder.append(String)>
    //   51  118:ldc2            #320 <String "': ">
    //   52  121:invokevirtual   #178 <Method StringBuilder StringBuilder.append(String)>
    //   53  124:aload           9
    //   54  126:invokevirtual   #323 <Method StringBuilder StringBuilder.append(Object)>
    //   55  129:invokevirtual   #179 <Method String StringBuilder.toString()>
    //   56  132:invokevirtual   #268 <Method void PrintStream.println(String)>
                        classes = new Vector();
    //   57  135:new             #148 <Class Vector>
    //   58  138:dup             
    //   59  139:invokespecial   #149 <Method void Vector()>
    //   60  142:astore          6
                    }
                    for(int i = 0; i < classes.size(); i++)
    //*  61  144:iconst_0        
    //*  62  145:istore          8
    //*  63  147:goto            207
                        if(isValidClassname(classes.get(i).toString()) && isValidClassname(key, classes.get(i).toString()))
    //*  64  150:aload_0         
    //*  65  151:aload           6
    //*  66  153:iload           8
    //*  67  155:invokevirtual   #283 <Method Object Vector.get(int)>
    //*  68  158:invokevirtual   #142 <Method String Object.toString()>
    //*  69  161:invokevirtual   #325 <Method boolean isValidClassname(String)>
    //*  70  164:ifne            170
    //*  71  167:goto            204
    //*  72  170:aload_0         
    //*  73  171:aload_2         
    //*  74  172:aload           6
    //*  75  174:iload           8
    //*  76  176:invokevirtual   #283 <Method Object Vector.get(int)>
    //*  77  179:invokevirtual   #142 <Method String Object.toString()>
    //*  78  182:invokevirtual   #327 <Method boolean isValidClassname(String, String)>
    //*  79  185:ifne            191
    //*  80  188:goto            204
                            names.add(classes.get(i));
    //   81  191:aload           7
    //   82  193:aload           6
    //   83  195:iload           8
    //   84  197:invokevirtual   #283 <Method Object Vector.get(int)>
    //   85  200:invokevirtual   #328 <Method boolean HashSet.add(Object)>
    //   86  203:pop             

    //   87  204:iinc            8  1
    //   88  207:iload           8
    //   89  209:aload           6
    //   90  211:invokevirtual   #293 <Method int Vector.size()>
    //   91  214:icmplt          150
                }
    //   92  217:aload           5
    //   93  219:invokevirtual   #202 <Method boolean StringTokenizer.hasMoreTokens()>
    //   94  222:ifne            75
                String value = "";
    //   95  225:ldc2            #330 <String "">
    //   96  228:astore_3        
                classes = new Vector();
    //   97  229:new             #148 <Class Vector>
    //   98  232:dup             
    //   99  233:invokespecial   #149 <Method void Vector()>
    //  100  236:astore          6
                classes.addAll(names);
    //  101  238:aload           6
    //  102  240:aload           7
    //  103  242:invokevirtual   #334 <Method boolean Vector.addAll(java.util.Collection)>
    //  104  245:pop             
                Collections.sort(classes, new rm.core.ClassDiscovery.StringCompare());
    //  105  246:aload           6
    //  106  248:new             #336 <Class rm.core.ClassDiscovery$StringCompare>
    //  107  251:dup             
    //  108  252:invokespecial   #337 <Method void rm.core.ClassDiscovery$StringCompare()>
    //  109  255:invokestatic    #343 <Method void Collections.sort(java.util.List, java.util.Comparator)>
                for(int i = 0; i < classes.size(); i++)
    //* 110  258:iconst_0        
    //* 111  259:istore          8
    //* 112  261:goto            325
                {
                    if(!value.equals(""))
    //* 113  264:aload_3         
    //* 114  265:ldc2            #330 <String "">
    //* 115  268:invokevirtual   #300 <Method boolean String.equals(Object)>
    //* 116  271:ifne            294
                        value = (new StringBuilder(String.valueOf(value))).append(",").toString();
    //  117  274:new             #165 <Class StringBuilder>
    //  118  277:dup             
    //  119  278:aload_3         
    //  120  279:invokestatic    #171 <Method String String.valueOf(Object)>
    //  121  282:invokespecial   #172 <Method void StringBuilder(String)>
    //  122  285:ldc1            #157 <String ",">
    //  123  287:invokevirtual   #178 <Method StringBuilder StringBuilder.append(String)>
    //  124  290:invokevirtual   #179 <Method String StringBuilder.toString()>
    //  125  293:astore_3        
                    value = (new StringBuilder(String.valueOf(value))).append(classes.get(i).toString()).toString();
    //  126  294:new             #165 <Class StringBuilder>
    //  127  297:dup             
    //  128  298:aload_3         
    //  129  299:invokestatic    #171 <Method String String.valueOf(Object)>
    //  130  302:invokespecial   #172 <Method void StringBuilder(String)>
    //  131  305:aload           6
    //  132  307:iload           8
    //  133  309:invokevirtual   #283 <Method Object Vector.get(int)>
    //  134  312:invokevirtual   #142 <Method String Object.toString()>
    //  135  315:invokevirtual   #178 <Method StringBuilder StringBuilder.append(String)>
    //  136  318:invokevirtual   #179 <Method String StringBuilder.toString()>
    //  137  321:astore_3        
                }

    //  138  322:iinc            8  1
    //  139  325:iload           8
    //  140  327:aload           6
    //  141  329:invokevirtual   #293 <Method int Vector.size()>
    //  142  332:icmplt          264
                m_OutputProperties.setProperty(key, value);
    //  143  335:aload_0         
    //  144  336:getfield        #78  <Field Properties m_OutputProperties>
    //  145  339:aload_2         
    //  146  340:aload_3         
    //  147  341:invokevirtual   #347 <Method Object Properties.setProperty(String, String)>
    //  148  344:pop             
            }
        }

    //  149  345:aload_1         
    //  150  346:invokeinterface #205 <Method boolean Enumeration.hasMoreElements()>
    //  151  351:ifne            22
    //  152  354:return          
    }

    protected void storeOutputProperties()
        throws Exception
    {
        m_OutputProperties.store(new FileOutputStream(getOutputFilename()), " Customises the list of options given by the GenericObjectEditor\n# for various superclasses.");
    //    0    0:aload_0         
    //    1    1:getfield        #78  <Field Properties m_OutputProperties>
    //    2    4:new             #355 <Class FileOutputStream>
    //    3    7:dup             
    //    4    8:aload_0         
    //    5    9:invokevirtual   #357 <Method String getOutputFilename()>
    //    6   12:invokespecial   #358 <Method void FileOutputStream(String)>
    //    7   15:ldc2            #360 <String " Customises the list of options given by the GenericObjectEditor\n# for various superclasses.">
    //    8   18:invokevirtual   #364 <Method void Properties.store(java.io.OutputStream, String)>
    //    9   21:return          
    }

    public void execute()
        throws Exception
    {
        execute(true);
    //    0    0:aload_0         
    //    1    1:iconst_1        
    //    2    2:invokevirtual   #367 <Method void execute(boolean)>
    //    3    5:return          
    }

    public void execute(boolean store)
        throws Exception
    {
        loadInputProperties();
    //    0    0:aload_0         
    //    1    1:invokevirtual   #227 <Method void loadInputProperties()>
        generateOutputProperties();
    //    2    4:aload_0         
    //    3    5:invokevirtual   #369 <Method void generateOutputProperties()>
        if(store)
    //*   4    8:iload_1         
    //*   5    9:ifeq            16
            storeOutputProperties();
    //    6   12:aload_0         
    //    7   13:invokevirtual   #371 <Method void storeOutputProperties()>
    //    8   16:return          
    }

    public static void main(String args[])
        throws Exception
    {
        GenericPropertiesCreator c = null;
    //    0    0:aconst_null     
    //    1    1:astore_1        
        if(args.length == 0)
    //*   2    2:aload_0         
    //*   3    3:arraylength     
    //*   4    4:ifne            18
            c = new GenericPropertiesCreator();
    //    5    7:new             #2   <Class GenericPropertiesCreator>
    //    6   10:dup             
    //    7   11:invokespecial   #374 <Method void GenericPropertiesCreator()>
    //    8   14:astore_1        
        else
    //*   9   15:goto            106
        if(args.length == 1)
    //*  10   18:aload_0         
    //*  11   19:arraylength     
    //*  12   20:iconst_1        
    //*  13   21:icmpne          42
        {
            c = new GenericPropertiesCreator();
    //   14   24:new             #2   <Class GenericPropertiesCreator>
    //   15   27:dup             
    //   16   28:invokespecial   #374 <Method void GenericPropertiesCreator()>
    //   17   31:astore_1        
            c.setOutputFilename(args[0]);
    //   18   32:aload_1         
    //   19   33:aload_0         
    //   20   34:iconst_0        
    //   21   35:aaload          
    //   22   36:invokevirtual   #376 <Method void setOutputFilename(String)>
        } else
    //*  23   39:goto            106
        if(args.length == 2)
    //*  24   42:aload_0         
    //*  25   43:arraylength     
    //*  26   44:iconst_2        
    //*  27   45:icmpne          69
        {
            c = new GenericPropertiesCreator(args[0]);
    //   28   48:new             #2   <Class GenericPropertiesCreator>
    //   29   51:dup             
    //   30   52:aload_0         
    //   31   53:iconst_0        
    //   32   54:aaload          
    //   33   55:invokespecial   #64  <Method void GenericPropertiesCreator(String)>
    //   34   58:astore_1        
            c.setOutputFilename(args[1]);
    //   35   59:aload_1         
    //   36   60:aload_0         
    //   37   61:iconst_1        
    //   38   62:aaload          
    //   39   63:invokevirtual   #376 <Method void setOutputFilename(String)>
        } else
    //*  40   66:goto            106
        {
            System.out.println((new StringBuilder("usage: ")).append(rm/gui/GenericPropertiesCreator.getName()).append(" [<input.props>] [<output.props>]").toString());
    //   41   69:getstatic       #261 <Field PrintStream System.out>
    //   42   72:new             #165 <Class StringBuilder>
    //   43   75:dup             
    //   44   76:ldc2            #378 <String "usage: ">
    //   45   79:invokespecial   #172 <Method void StringBuilder(String)>
    //   46   82:ldc1            #2   <Class GenericPropertiesCreator>
    //   47   84:invokevirtual   #299 <Method String Class.getName()>
    //   48   87:invokevirtual   #178 <Method StringBuilder StringBuilder.append(String)>
    //   49   90:ldc2            #380 <String " [<input.props>] [<output.props>]">
    //   50   93:invokevirtual   #178 <Method StringBuilder StringBuilder.append(String)>
    //   51   96:invokevirtual   #179 <Method String StringBuilder.toString()>
    //   52   99:invokevirtual   #268 <Method void PrintStream.println(String)>
            System.exit(1);
    //   53  102:iconst_1        
    //   54  103:invokestatic    #384 <Method void System.exit(int)>
        }
        c.execute(true);
    //   55  106:aload_1         
    //   56  107:iconst_1        
    //   57  108:invokevirtual   #367 <Method void execute(boolean)>
    //   58  111:return          
    }

    public static final boolean VERBOSE = false;
    public static final String USE_DYNAMIC = "UseDynamic";
    protected static String CREATOR_FILE = "rm/gui/GenericPropertiesCreator.props";
    protected static String EXCLUDE_FILE = "rm/gui/GenericPropertiesCreator.excludes";
    protected static String EXCLUDE_INTERFACE = "I";
    protected static String EXCLUDE_CLASS = "C";
    protected static String EXCLUDE_SUPERCLASS = "S";
    protected static String PROPERTY_FILE = "rm/gui/GenericObjectEditor.props";
    protected String m_InputFilename;
    protected String m_OutputFilename;
    protected Properties m_InputProperties;
    protected Properties m_OutputProperties;
    protected boolean m_ExplicitPropsFile;
    protected Hashtable m_Excludes;
    static Class class$0;

    static 
    {
    //    0    0:ldc1            #33  <String "rm/gui/GenericPropertiesCreator.props">
    //    1    2:putstatic       #35  <Field String CREATOR_FILE>
    //    2    5:ldc1            #37  <String "rm/gui/GenericPropertiesCreator.excludes">
    //    3    7:putstatic       #39  <Field String EXCLUDE_FILE>
    //    4   10:ldc1            #41  <String "I">
    //    5   12:putstatic       #43  <Field String EXCLUDE_INTERFACE>
    //    6   15:ldc1            #45  <String "C">
    //    7   17:putstatic       #47  <Field String EXCLUDE_CLASS>
    //    8   20:ldc1            #49  <String "S">
    //    9   22:putstatic       #51  <Field String EXCLUDE_SUPERCLASS>
    //   10   25:ldc1            #53  <String "rm/gui/GenericObjectEditor.props">
    //   11   27:putstatic       #55  <Field String PROPERTY_FILE>
    //*  12   30:return          
    }
}
