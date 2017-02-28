// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   ClassDiscovery.java

package rm.core;

import java.io.File;
import java.io.PrintStream;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ClassDiscovery
{
    public static class StringCompare
        implements Comparator
    {

        private String fillUp(String s, int len)
        {
        //*   0    0:goto            23
            for(; s.length() < len; s = (new StringBuilder(String.valueOf(s))).append(" ").toString());
        //    1    3:new             #19  <Class StringBuilder>
        //    2    6:dup             
        //    3    7:aload_1         
        //    4    8:invokestatic    #25  <Method String String.valueOf(Object)>
        //    5   11:invokespecial   #28  <Method void StringBuilder(String)>
        //    6   14:ldc1            #30  <String " ">
        //    7   16:invokevirtual   #34  <Method StringBuilder StringBuilder.append(String)>
        //    8   19:invokevirtual   #38  <Method String StringBuilder.toString()>
        //    9   22:astore_1        
        //   10   23:aload_1         
        //   11   24:invokevirtual   #42  <Method int String.length()>
        //   12   27:iload_2         
        //   13   28:icmplt          3
            return s;
        //   14   31:aload_1         
        //   15   32:areturn         
        }

        private int charGroup(char c)
        {
            int result = 0;
        //    0    0:iconst_0        
        //    1    1:istore_2        
            if(c >= 'a' && c <= 'z')
        //*   2    2:iload_1         
        //*   3    3:bipush          97
        //*   4    5:icmplt          19
        //*   5    8:iload_1         
        //*   6    9:bipush          122
        //*   7   11:icmpgt          19
                result = 2;
        //    8   14:iconst_2        
        //    9   15:istore_2        
            else
        //*  10   16:goto            33
            if(c >= '0' && c <= '9')
        //*  11   19:iload_1         
        //*  12   20:bipush          48
        //*  13   22:icmplt          33
        //*  14   25:iload_1         
        //*  15   26:bipush          57
        //*  16   28:icmpgt          33
                result = 1;
        //   17   31:iconst_1        
        //   18   32:istore_2        
            return result;
        //   19   33:iload_2         
        //   20   34:ireturn         
        }

        public int compare(Object o1, Object o2)
        {
            int result = 0;
        //    0    0:iconst_0        
        //    1    1:istore          6
            String s1 = o1.toString().toLowerCase();
        //    2    3:aload_1         
        //    3    4:invokevirtual   #54  <Method String Object.toString()>
        //    4    7:invokevirtual   #57  <Method String String.toLowerCase()>
        //    5   10:astore_3        
            String s2 = o2.toString().toLowerCase();
        //    6   11:aload_2         
        //    7   12:invokevirtual   #54  <Method String Object.toString()>
        //    8   15:invokevirtual   #57  <Method String String.toLowerCase()>
        //    9   18:astore          4
            s1 = fillUp(s1, s2.length());
        //   10   20:aload_0         
        //   11   21:aload_3         
        //   12   22:aload           4
        //   13   24:invokevirtual   #42  <Method int String.length()>
        //   14   27:invokespecial   #59  <Method String fillUp(String, int)>
        //   15   30:astore_3        
            s2 = fillUp(s2, s1.length());
        //   16   31:aload_0         
        //   17   32:aload           4
        //   18   34:aload_3         
        //   19   35:invokevirtual   #42  <Method int String.length()>
        //   20   38:invokespecial   #59  <Method String fillUp(String, int)>
        //   21   41:astore          4
            for(int i = 0; i < s1.length(); i++)
        //*  22   43:iconst_0        
        //*  23   44:istore          5
        //*  24   46:goto            153
            {
                if(s1.charAt(i) == s2.charAt(i))
        //*  25   49:aload_3         
        //*  26   50:iload           5
        //*  27   52:invokevirtual   #63  <Method char String.charAt(int)>
        //*  28   55:aload           4
        //*  29   57:iload           5
        //*  30   59:invokevirtual   #63  <Method char String.charAt(int)>
        //*  31   62:icmpne          71
                {
                    result = 0;
        //   32   65:iconst_0        
        //   33   66:istore          6
                    continue;
        //   34   68:goto            150
                }
                int v1 = charGroup(s1.charAt(i));
        //   35   71:aload_0         
        //   36   72:aload_3         
        //   37   73:iload           5
        //   38   75:invokevirtual   #63  <Method char String.charAt(int)>
        //   39   78:invokespecial   #65  <Method int charGroup(char)>
        //   40   81:istore          7
                int v2 = charGroup(s2.charAt(i));
        //   41   83:aload_0         
        //   42   84:aload           4
        //   43   86:iload           5
        //   44   88:invokevirtual   #63  <Method char String.charAt(int)>
        //   45   91:invokespecial   #65  <Method int charGroup(char)>
        //   46   94:istore          8
                if(v1 != v2)
        //*  47   96:iload           7
        //*  48   98:iload           8
        //*  49  100:icmpeq          122
                {
                    if(v1 < v2)
        //*  50  103:iload           7
        //*  51  105:iload           8
        //*  52  107:icmpge          116
                        result = -1;
        //   53  110:iconst_m1       
        //   54  111:istore          6
                    else
        //*  55  113:goto            162
                        result = 1;
        //   56  116:iconst_1        
        //   57  117:istore          6
                } else
        //*  58  119:goto            162
                if(s1.charAt(i) < s2.charAt(i))
        //*  59  122:aload_3         
        //*  60  123:iload           5
        //*  61  125:invokevirtual   #63  <Method char String.charAt(int)>
        //*  62  128:aload           4
        //*  63  130:iload           5
        //*  64  132:invokevirtual   #63  <Method char String.charAt(int)>
        //*  65  135:icmpge          144
                    result = -1;
        //   66  138:iconst_m1       
        //   67  139:istore          6
                else
        //*  68  141:goto            162
                    result = 1;
        //   69  144:iconst_1        
        //   70  145:istore          6
                break;
        //   71  147:goto            162
            }

        //   72  150:iinc            5  1
        //   73  153:iload           5
        //   74  155:aload_3         
        //   75  156:invokevirtual   #42  <Method int String.length()>
        //   76  159:icmplt          49
            return result;
        //   77  162:iload           6
        //   78  164:ireturn         
        }

        public boolean equals(Object obj)
        {
            return obj instanceof StringCompare;
        //    0    0:aload_1         
        //    1    1:instanceof      #2   <Class ClassDiscovery$StringCompare>
        //    2    4:ireturn         
        }

        public StringCompare()
        {
        //    0    0:aload_0         
        //    1    1:invokespecial   #11  <Method void Object()>
        //    2    4:return          
        }
    }


    public ClassDiscovery()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #20  <Method void Object()>
    //    2    4:return          
    }

    public static boolean isSubclass(String superclass, String otherclass)
    {
        try
        {
            return isSubclass(Class.forName(superclass), Class.forName(otherclass));
    //    0    0:aload_0         
    //    1    1:invokestatic    #32  <Method Class Class.forName(String)>
    //    2    4:aload_1         
    //    3    5:invokestatic    #32  <Method Class Class.forName(String)>
    //    4    8:invokestatic    #35  <Method boolean isSubclass(Class, Class)>
    //    5   11:ireturn         
        }
        catch(Exception e)
    //*   6   12:astore_2        
        {
            return false;
    //    7   13:iconst_0        
    //    8   14:ireturn         
        }
    }

    public static boolean isSubclass(Class superclass, Class otherclass)
    {
        boolean result = false;
    //    0    0:iconst_0        
    //    1    1:istore_3        
        Class currentclass = otherclass;
    //    2    2:aload_1         
    //    3    3:astore_2        
        do
        {
            result = currentclass.equals(superclass);
    //    4    4:aload_2         
    //    5    5:aload_0         
    //    6    6:invokevirtual   #46  <Method boolean Object.equals(Object)>
    //    7    9:istore_3        
            if(currentclass.equals(java/lang/Object))
    //*   8   10:aload_2         
    //*   9   11:ldc1            #4   <Class Object>
    //*  10   13:invokevirtual   #46  <Method boolean Object.equals(Object)>
    //*  11   16:ifeq            22
                break;
    //   12   19:goto            35
            if(!result)
    //*  13   22:iload_3         
    //*  14   23:ifne            31
                currentclass = currentclass.getSuperclass();
    //   15   26:aload_2         
    //   16   27:invokevirtual   #50  <Method Class Class.getSuperclass()>
    //   17   30:astore_2        
        } while(!result);
    //   18   31:iload_3         
    //   19   32:ifeq            4
        return result;
    //   20   35:iload_3         
    //   21   36:ireturn         
    }

    public static boolean hasInterface(String intf, String cls)
    {
        try
        {
            return hasInterface(Class.forName(intf), Class.forName(cls));
    //    0    0:aload_0         
    //    1    1:invokestatic    #32  <Method Class Class.forName(String)>
    //    2    4:aload_1         
    //    3    5:invokestatic    #32  <Method Class Class.forName(String)>
    //    4    8:invokestatic    #55  <Method boolean hasInterface(Class, Class)>
    //    5   11:ireturn         
        }
        catch(Exception e)
    //*   6   12:astore_2        
        {
            return false;
    //    7   13:iconst_0        
    //    8   14:ireturn         
        }
    }

    public static boolean hasInterface(Class intf, Class cls)
    {
        boolean result = false;
    //    0    0:iconst_0        
    //    1    1:istore          4
        Class currentclass = cls;
    //    2    3:aload_1         
    //    3    4:astore          5
        do
        {
            Class intfs[] = currentclass.getInterfaces();
    //    4    6:aload           5
    //    5    8:invokevirtual   #61  <Method Class[] Class.getInterfaces()>
    //    6   11:astore_2        
            for(int i = 0; i < intfs.length; i++)
    //*   7   12:iconst_0        
    //*   8   13:istore_3        
    //*   9   14:goto            36
            {
                if(!intfs[i].equals(intf))
                    continue;
    //   10   17:aload_2         
    //   11   18:iload_3         
    //   12   19:aaload          
    //   13   20:aload_0         
    //   14   21:invokevirtual   #46  <Method boolean Object.equals(Object)>
    //   15   24:ifeq            33
                result = true;
    //   16   27:iconst_1        
    //   17   28:istore          4
                break;
    //   18   30:goto            42
            }

    //   19   33:iinc            3  1
    //   20   36:iload_3         
    //   21   37:aload_2         
    //   22   38:arraylength     
    //   23   39:icmplt          17
            if(result)
                continue;
    //   24   42:iload           4
    //   25   44:ifne            72
            currentclass = currentclass.getSuperclass();
    //   26   47:aload           5
    //   27   49:invokevirtual   #50  <Method Class Class.getSuperclass()>
    //   28   52:astore          5
            if(currentclass == null || currentclass.equals(java/lang/Object))
    //*  29   54:aload           5
    //*  30   56:ifnull          77
    //*  31   59:aload           5
    //*  32   61:ldc1            #4   <Class Object>
    //*  33   63:invokevirtual   #46  <Method boolean Object.equals(Object)>
    //*  34   66:ifeq            72
                break;
    //   35   69:goto            77
        } while(!result);
    //   36   72:iload           4
    //   37   74:ifeq            6
        return result;
    //   38   77:iload           4
    //   39   79:ireturn         
    }

    protected static URL getURL(String classpathPart, String pkgname)
    {
        URL result = null;
    //    0    0:aconst_null     
    //    1    1:astore_3        
        String urlStr = null;
    //    2    2:aconst_null     
    //    3    3:astore_2        
        try
        {
            File classpathFile = new File(classpathPart);
    //    4    4:new             #69  <Class File>
    //    5    7:dup             
    //    6    8:aload_0         
    //    7    9:invokespecial   #72  <Method void File(String)>
    //    8   12:astore          4
            if(classpathFile.isDirectory())
    //*   9   14:aload           4
    //*  10   16:invokevirtual   #76  <Method boolean File.isDirectory()>
    //*  11   19:ifeq            81
            {
                File file = new File((new StringBuilder(String.valueOf(classpathPart))).append(pkgname).toString());
    //   12   22:new             #69  <Class File>
    //   13   25:dup             
    //   14   26:new             #78  <Class StringBuilder>
    //   15   29:dup             
    //   16   30:aload_0         
    //   17   31:invokestatic    #84  <Method String String.valueOf(Object)>
    //   18   34:invokespecial   #85  <Method void StringBuilder(String)>
    //   19   37:aload_1         
    //   20   38:invokevirtual   #89  <Method StringBuilder StringBuilder.append(String)>
    //   21   41:invokevirtual   #93  <Method String StringBuilder.toString()>
    //   22   44:invokespecial   #72  <Method void File(String)>
    //   23   47:astore          5
                if(file.exists())
    //*  24   49:aload           5
    //*  25   51:invokevirtual   #96  <Method boolean File.exists()>
    //*  26   54:ifeq            170
                    urlStr = (new StringBuilder("file:")).append(classpathPart).append(pkgname).toString();
    //   27   57:new             #78  <Class StringBuilder>
    //   28   60:dup             
    //   29   61:ldc1            #98  <String "file:">
    //   30   63:invokespecial   #85  <Method void StringBuilder(String)>
    //   31   66:aload_0         
    //   32   67:invokevirtual   #89  <Method StringBuilder StringBuilder.append(String)>
    //   33   70:aload_1         
    //   34   71:invokevirtual   #89  <Method StringBuilder StringBuilder.append(String)>
    //   35   74:invokevirtual   #93  <Method String StringBuilder.toString()>
    //   36   77:astore_2        
            } else
    //*  37   78:goto            170
            {
                JarFile jarfile = new JarFile(classpathPart);
    //   38   81:new             #100 <Class JarFile>
    //   39   84:dup             
    //   40   85:aload_0         
    //   41   86:invokespecial   #101 <Method void JarFile(String)>
    //   42   89:astore          6
                Enumeration enm = jarfile.entries();
    //   43   91:aload           6
    //   44   93:invokevirtual   #105 <Method Enumeration JarFile.entries()>
    //   45   96:astore          7
                String pkgnameTmp = pkgname.substring(1);
    //   46   98:aload_1         
    //   47   99:iconst_1        
    //   48  100:invokevirtual   #109 <Method String String.substring(int)>
    //   49  103:astore          8
    //*  50  105:goto            155
                while(enm.hasMoreElements()) 
                    if(enm.nextElement().toString().startsWith(pkgnameTmp))
    //*  51  108:aload           7
    //*  52  110:invokeinterface #115 <Method Object Enumeration.nextElement()>
    //*  53  115:invokevirtual   #116 <Method String Object.toString()>
    //*  54  118:aload           8
    //*  55  120:invokevirtual   #120 <Method boolean String.startsWith(String)>
    //*  56  123:ifeq            155
                    {
                        urlStr = (new StringBuilder("jar:file:")).append(classpathPart).append("!").append(pkgname).toString();
    //   57  126:new             #78  <Class StringBuilder>
    //   58  129:dup             
    //   59  130:ldc1            #122 <String "jar:file:">
    //   60  132:invokespecial   #85  <Method void StringBuilder(String)>
    //   61  135:aload_0         
    //   62  136:invokevirtual   #89  <Method StringBuilder StringBuilder.append(String)>
    //   63  139:ldc1            #124 <String "!">
    //   64  141:invokevirtual   #89  <Method StringBuilder StringBuilder.append(String)>
    //   65  144:aload_1         
    //   66  145:invokevirtual   #89  <Method StringBuilder StringBuilder.append(String)>
    //   67  148:invokevirtual   #93  <Method String StringBuilder.toString()>
    //   68  151:astore_2        
                        break;
    //   69  152:goto            170
                    }
    //   70  155:aload           7
    //   71  157:invokeinterface #127 <Method boolean Enumeration.hasMoreElements()>
    //   72  162:ifne            108
            }
        }
    //*  73  165:goto            170
        catch(Exception exception) { }
    //   74  168:astore          9
        if(urlStr != null)
    //*  75  170:aload_2         
    //*  76  171:ifnull          222
            try
            {
                result = new URL(urlStr);
    //   77  174:new             #129 <Class URL>
    //   78  177:dup             
    //   79  178:aload_2         
    //   80  179:invokespecial   #130 <Method void URL(String)>
    //   81  182:astore_3        
            }
    //*  82  183:goto            222
            catch(Exception e)
    //*  83  186:astore          9
            {
                System.err.println((new StringBuilder("Trying to create URL from '")).append(urlStr).append("' generates this exception:\n").append(e).toString());
    //   84  188:getstatic       #136 <Field PrintStream System.err>
    //   85  191:new             #78  <Class StringBuilder>
    //   86  194:dup             
    //   87  195:ldc1            #138 <String "Trying to create URL from '">
    //   88  197:invokespecial   #85  <Method void StringBuilder(String)>
    //   89  200:aload_2         
    //   90  201:invokevirtual   #89  <Method StringBuilder StringBuilder.append(String)>
    //   91  204:ldc1            #140 <String "' generates this exception:\n">
    //   92  206:invokevirtual   #89  <Method StringBuilder StringBuilder.append(String)>
    //   93  209:aload           9
    //   94  211:invokevirtual   #143 <Method StringBuilder StringBuilder.append(Object)>
    //   95  214:invokevirtual   #93  <Method String StringBuilder.toString()>
    //   96  217:invokevirtual   #148 <Method void PrintStream.println(String)>
                result = null;
    //   97  220:aconst_null     
    //   98  221:astore_3        
            }
        return result;
    //   99  222:aload_3         
    //  100  223:areturn         
    }

    public static Vector find(String classname, String pkgnames[])
    {
        Vector result = new Vector();
    //    0    0:new             #164 <Class Vector>
    //    1    3:dup             
    //    2    4:invokespecial   #165 <Method void Vector()>
    //    3    7:astore_2        
        try
        {
            Class cls = Class.forName(classname);
    //    4    8:aload_0         
    //    5    9:invokestatic    #32  <Method Class Class.forName(String)>
    //    6   12:astore_3        
            result = find(cls, pkgnames);
    //    7   13:aload_3         
    //    8   14:aload_1         
    //    9   15:invokestatic    #168 <Method Vector find(Class, String[])>
    //   10   18:astore_2        
        }
    //*  11   19:goto            29
        catch(Exception e)
    //*  12   22:astore          4
        {
            e.printStackTrace();
    //   13   24:aload           4
    //   14   26:invokevirtual   #171 <Method void Exception.printStackTrace()>
        }
        return result;
    //   15   29:aload_2         
    //   16   30:areturn         
    }

    public static Vector find(String classname, String pkgname)
    {
        Vector result = new Vector();
    //    0    0:new             #164 <Class Vector>
    //    1    3:dup             
    //    2    4:invokespecial   #165 <Method void Vector()>
    //    3    7:astore_2        
        try
        {
            Class cls = Class.forName(classname);
    //    4    8:aload_0         
    //    5    9:invokestatic    #32  <Method Class Class.forName(String)>
    //    6   12:astore_3        
            result = find(cls, pkgname);
    //    7   13:aload_3         
    //    8   14:aload_1         
    //    9   15:invokestatic    #179 <Method Vector find(Class, String)>
    //   10   18:astore_2        
        }
    //*  11   19:goto            29
        catch(Exception e)
    //*  12   22:astore          4
        {
            e.printStackTrace();
    //   13   24:aload           4
    //   14   26:invokevirtual   #171 <Method void Exception.printStackTrace()>
        }
        return result;
    //   15   29:aload_2         
    //   16   30:areturn         
    }

    public static Vector find(Class cls, String pkgnames[])
    {
        Vector result = new Vector();
    //    0    0:new             #164 <Class Vector>
    //    1    3:dup             
    //    2    4:invokespecial   #165 <Method void Vector()>
    //    3    7:astore_2        
        HashSet names = new HashSet();
    //    4    8:new             #181 <Class HashSet>
    //    5   11:dup             
    //    6   12:invokespecial   #182 <Method void HashSet()>
    //    7   15:astore          4
        for(int i = 0; i < pkgnames.length; i++)
    //*   8   17:iconst_0        
    //*   9   18:istore_3        
    //*  10   19:goto            38
            names.addAll(find(cls, pkgnames[i]));
    //   11   22:aload           4
    //   12   24:aload_0         
    //   13   25:aload_1         
    //   14   26:iload_3         
    //   15   27:aaload          
    //   16   28:invokestatic    #179 <Method Vector find(Class, String)>
    //   17   31:invokevirtual   #188 <Method boolean AbstractCollection.addAll(java.util.Collection)>
    //   18   34:pop             

    //   19   35:iinc            3  1
    //   20   38:iload_3         
    //   21   39:aload_1         
    //   22   40:arraylength     
    //   23   41:icmplt          22
        result.addAll(names);
    //   24   44:aload_2         
    //   25   45:aload           4
    //   26   47:invokevirtual   #189 <Method boolean Vector.addAll(java.util.Collection)>
    //   27   50:pop             
        Collections.sort(result, new StringCompare());
    //   28   51:aload_2         
    //   29   52:new             #191 <Class ClassDiscovery$StringCompare>
    //   30   55:dup             
    //   31   56:invokespecial   #192 <Method void ClassDiscovery$StringCompare()>
    //   32   59:invokestatic    #198 <Method void Collections.sort(java.util.List, Comparator)>
        return result;
    //   33   62:aload_2         
    //   34   63:areturn         
    }

    public static Vector find(Class cls, String pkgname)
    {
        Vector result = getCache(cls, pkgname);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokestatic    #203 <Method Vector getCache(Class, String)>
    //    3    5:astore_2        
        if(result == null)
    //*   4    6:aload_2         
    //*   5    7:ifnonnull       571
        {
            result = new Vector();
    //    6   10:new             #164 <Class Vector>
    //    7   13:dup             
    //    8   14:invokespecial   #165 <Method void Vector()>
    //    9   17:astore_2        
            String pkgpath = pkgname.replaceAll("\\.", "/");
    //   10   18:aload_1         
    //   11   19:ldc1            #205 <String "\\.">
    //   12   21:ldc1            #207 <String "/">
    //   13   23:invokevirtual   #211 <Method String String.replaceAll(String, String)>
    //   14   26:astore          5
            for(StringTokenizer tok = new StringTokenizer(System.getProperty("java.class.path"), System.getProperty("path.separator")); tok.hasMoreTokens();)
    //*  15   28:new             #213 <Class StringTokenizer>
    //*  16   31:dup             
    //*  17   32:ldc1            #215 <String "java.class.path">
    //*  18   34:invokestatic    #219 <Method String System.getProperty(String)>
    //*  19   37:ldc1            #221 <String "path.separator">
    //*  20   39:invokestatic    #219 <Method String System.getProperty(String)>
    //*  21   42:invokespecial   #224 <Method void StringTokenizer(String, String)>
    //*  22   45:astore_3        
    //*  23   46:goto            394
            {
                String part = tok.nextToken();
    //   24   49:aload_3         
    //   25   50:invokevirtual   #227 <Method String StringTokenizer.nextToken()>
    //   26   53:astore          4
                URL url = getURL(part, (new StringBuilder("/")).append(pkgpath).toString());
    //   27   55:aload           4
    //   28   57:new             #78  <Class StringBuilder>
    //   29   60:dup             
    //   30   61:ldc1            #207 <String "/">
    //   31   63:invokespecial   #85  <Method void StringBuilder(String)>
    //   32   66:aload           5
    //   33   68:invokevirtual   #89  <Method StringBuilder StringBuilder.append(String)>
    //   34   71:invokevirtual   #93  <Method String StringBuilder.toString()>
    //   35   74:invokestatic    #229 <Method URL getURL(String, String)>
    //   36   77:astore          8
                if(url != null)
    //*  37   79:aload           8
    //*  38   81:ifnonnull       87
    //*  39   84:goto            394
                {
                    File dir = new File((new StringBuilder(String.valueOf(part))).append("/").append(pkgpath).toString());
    //   40   87:new             #69  <Class File>
    //   41   90:dup             
    //   42   91:new             #78  <Class StringBuilder>
    //   43   94:dup             
    //   44   95:aload           4
    //   45   97:invokestatic    #84  <Method String String.valueOf(Object)>
    //   46  100:invokespecial   #85  <Method void StringBuilder(String)>
    //   47  103:ldc1            #207 <String "/">
    //   48  105:invokevirtual   #89  <Method StringBuilder StringBuilder.append(String)>
    //   49  108:aload           5
    //   50  110:invokevirtual   #89  <Method StringBuilder StringBuilder.append(String)>
    //   51  113:invokevirtual   #93  <Method String StringBuilder.toString()>
    //   52  116:invokespecial   #72  <Method void File(String)>
    //   53  119:astore          6
                    if(dir.exists())
    //*  54  121:aload           6
    //*  55  123:invokevirtual   #96  <Method boolean File.exists()>
    //*  56  126:ifeq            249
                    {
                        File files[] = dir.listFiles();
    //   57  129:aload           6
    //   58  131:invokevirtual   #233 <Method File[] File.listFiles()>
    //   59  134:astore          7
                        for(int i = 0; i < files.length; i++)
    //*  60  136:iconst_0        
    //*  61  137:istore          9
    //*  62  139:goto            238
                            if(files[i].isFile() && files[i].getName().endsWith(".class"))
    //*  63  142:aload           7
    //*  64  144:iload           9
    //*  65  146:aaload          
    //*  66  147:invokevirtual   #236 <Method boolean File.isFile()>
    //*  67  150:ifeq            235
    //*  68  153:aload           7
    //*  69  155:iload           9
    //*  70  157:aaload          
    //*  71  158:invokevirtual   #239 <Method String File.getName()>
    //*  72  161:ldc1            #241 <String ".class">
    //*  73  163:invokevirtual   #244 <Method boolean String.endsWith(String)>
    //*  74  166:ifne            172
    //*  75  169:goto            235
                                try
                                {
                                    String classname = (new StringBuilder(String.valueOf(pkgname))).append(".").append(files[i].getName().replaceAll(".*/", "").replaceAll("\\.class", "")).toString();
    //   76  172:new             #78  <Class StringBuilder>
    //   77  175:dup             
    //   78  176:aload_1         
    //   79  177:invokestatic    #84  <Method String String.valueOf(Object)>
    //   80  180:invokespecial   #85  <Method void StringBuilder(String)>
    //   81  183:ldc1            #246 <String ".">
    //   82  185:invokevirtual   #89  <Method StringBuilder StringBuilder.append(String)>
    //   83  188:aload           7
    //   84  190:iload           9
    //   85  192:aaload          
    //   86  193:invokevirtual   #239 <Method String File.getName()>
    //   87  196:ldc1            #248 <String ".*/">
    //   88  198:ldc1            #250 <String "">
    //   89  200:invokevirtual   #211 <Method String String.replaceAll(String, String)>
    //   90  203:ldc1            #252 <String "\\.class">
    //   91  205:ldc1            #250 <String "">
    //   92  207:invokevirtual   #211 <Method String String.replaceAll(String, String)>
    //   93  210:invokevirtual   #89  <Method StringBuilder StringBuilder.append(String)>
    //   94  213:invokevirtual   #93  <Method String StringBuilder.toString()>
    //   95  216:astore          11
                                    result.add(classname);
    //   96  218:aload_2         
    //   97  219:aload           11
    //   98  221:invokevirtual   #255 <Method boolean Vector.add(Object)>
    //   99  224:pop             
                                }
    //* 100  225:goto            235
                                catch(Exception e)
    //* 101  228:astore          15
                                {
                                    e.printStackTrace();
    //  102  230:aload           15
    //  103  232:invokevirtual   #171 <Method void Exception.printStackTrace()>
                                }

    //  104  235:iinc            9  1
    //  105  238:iload           9
    //  106  240:aload           7
    //  107  242:arraylength     
    //  108  243:icmplt          142
                    } else
    //* 109  246:goto            394
                    {
                        try
                        {
                            JarFile jar = new JarFile(part);
    //  110  249:new             #100 <Class JarFile>
    //  111  252:dup             
    //  112  253:aload           4
    //  113  255:invokespecial   #101 <Method void JarFile(String)>
    //  114  258:astore          12
                            for(Enumeration enm = jar.entries(); enm.hasMoreElements();)
    //* 115  260:aload           12
    //* 116  262:invokevirtual   #105 <Method Enumeration JarFile.entries()>
    //* 117  265:astore          14
    //* 118  267:goto            374
                            {
                                JarEntry entry = (JarEntry)(JarEntry)enm.nextElement();
    //  119  270:aload           14
    //  120  272:invokeinterface #115 <Method Object Enumeration.nextElement()>
    //  121  277:checkcast       #257 <Class JarEntry>
    //  122  280:checkcast       #257 <Class JarEntry>
    //  123  283:astore          13
                                if(!entry.isDirectory() && entry.getName().endsWith(".class"))
    //* 124  285:aload           13
    //* 125  287:invokevirtual   #258 <Method boolean JarEntry.isDirectory()>
    //* 126  290:ifne            374
    //* 127  293:aload           13
    //* 128  295:invokevirtual   #259 <Method String JarEntry.getName()>
    //* 129  298:ldc1            #241 <String ".class">
    //* 130  300:invokevirtual   #244 <Method boolean String.endsWith(String)>
    //* 131  303:ifne            309
    //* 132  306:goto            374
                                {
                                    String classname = entry.getName().replaceAll("\\.class", "");
    //  133  309:aload           13
    //  134  311:invokevirtual   #259 <Method String JarEntry.getName()>
    //  135  314:ldc1            #252 <String "\\.class">
    //  136  316:ldc1            #250 <String "">
    //  137  318:invokevirtual   #211 <Method String String.replaceAll(String, String)>
    //  138  321:astore          11
                                    if(classname.startsWith(pkgpath) && classname.substring(pkgpath.length() + 1).indexOf("/") <= -1)
    //* 139  323:aload           11
    //* 140  325:aload           5
    //* 141  327:invokevirtual   #120 <Method boolean String.startsWith(String)>
    //* 142  330:ifne            336
    //* 143  333:goto            374
    //* 144  336:aload           11
    //* 145  338:aload           5
    //* 146  340:invokevirtual   #263 <Method int String.length()>
    //* 147  343:iconst_1        
    //* 148  344:iadd            
    //* 149  345:invokevirtual   #109 <Method String String.substring(int)>
    //* 150  348:ldc1            #207 <String "/">
    //* 151  350:invokevirtual   #267 <Method int String.indexOf(String)>
    //* 152  353:iconst_m1       
    //* 153  354:icmple          360
    //* 154  357:goto            374
                                        result.add(classname.replaceAll("/", "."));
    //  155  360:aload_2         
    //  156  361:aload           11
    //  157  363:ldc1            #207 <String "/">
    //  158  365:ldc1            #246 <String ".">
    //  159  367:invokevirtual   #211 <Method String String.replaceAll(String, String)>
    //  160  370:invokevirtual   #255 <Method boolean Vector.add(Object)>
    //  161  373:pop             
                                }
                            }

    //  162  374:aload           14
    //  163  376:invokeinterface #127 <Method boolean Enumeration.hasMoreElements()>
    //  164  381:ifne            270
                        }
    //* 165  384:goto            394
                        catch(Exception e)
    //* 166  387:astore          15
                        {
                            e.printStackTrace();
    //  167  389:aload           15
    //  168  391:invokevirtual   #171 <Method void Exception.printStackTrace()>
                        }
                    }
                }
            }

    //  169  394:aload_3         
    //  170  395:invokevirtual   #270 <Method boolean StringTokenizer.hasMoreTokens()>
    //  171  398:ifne            49
            for(int i = 0; i < result.size();)
    //* 172  401:iconst_0        
    //* 173  402:istore          9
    //* 174  404:goto            545
                try
                {
                    Class clsNew = Class.forName((String)(String)result.get(i));
    //  175  407:aload_2         
    //  176  408:iload           9
    //  177  410:invokevirtual   #274 <Method Object Vector.get(int)>
    //  178  413:checkcast       #80  <Class String>
    //  179  416:checkcast       #80  <Class String>
    //  180  419:invokestatic    #32  <Method Class Class.forName(String)>
    //  181  422:astore          10
                    if(Modifier.isAbstract(clsNew.getModifiers()))
    //* 182  424:aload           10
    //* 183  426:invokevirtual   #277 <Method int Class.getModifiers()>
    //* 184  429:invokestatic    #283 <Method boolean Modifier.isAbstract(int)>
    //* 185  432:ifeq            445
                        result.remove(i);
    //  186  435:aload_2         
    //  187  436:iload           9
    //  188  438:invokevirtual   #286 <Method Object Vector.remove(int)>
    //  189  441:pop             
                    else
    //* 190  442:goto            545
                    if(cls.isInterface() && !hasInterface(cls, clsNew))
    //* 191  445:aload_0         
    //* 192  446:invokevirtual   #289 <Method boolean Class.isInterface()>
    //* 193  449:ifeq            471
    //* 194  452:aload_0         
    //* 195  453:aload           10
    //* 196  455:invokestatic    #55  <Method boolean hasInterface(Class, Class)>
    //* 197  458:ifne            471
                        result.remove(i);
    //  198  461:aload_2         
    //  199  462:iload           9
    //  200  464:invokevirtual   #286 <Method Object Vector.remove(int)>
    //  201  467:pop             
                    else
    //* 202  468:goto            545
                    if(!cls.isInterface() && !isSubclass(cls, clsNew))
    //* 203  471:aload_0         
    //* 204  472:invokevirtual   #289 <Method boolean Class.isInterface()>
    //* 205  475:ifne            497
    //* 206  478:aload_0         
    //* 207  479:aload           10
    //* 208  481:invokestatic    #35  <Method boolean isSubclass(Class, Class)>
    //* 209  484:ifne            497
                        result.remove(i);
    //  210  487:aload_2         
    //  211  488:iload           9
    //  212  490:invokevirtual   #286 <Method Object Vector.remove(int)>
    //  213  493:pop             
                    else
    //* 214  494:goto            545
                        i++;
    //  215  497:iinc            9  1
                }
    //* 216  500:goto            545
                catch(Throwable e)
    //* 217  503:astore          15
                {
                    System.err.println((new StringBuilder("Checking class: ")).append(result.get(i)).toString());
    //  218  505:getstatic       #136 <Field PrintStream System.err>
    //  219  508:new             #78  <Class StringBuilder>
    //  220  511:dup             
    //  221  512:ldc2            #291 <String "Checking class: ">
    //  222  515:invokespecial   #85  <Method void StringBuilder(String)>
    //  223  518:aload_2         
    //  224  519:iload           9
    //  225  521:invokevirtual   #274 <Method Object Vector.get(int)>
    //  226  524:invokevirtual   #143 <Method StringBuilder StringBuilder.append(Object)>
    //  227  527:invokevirtual   #93  <Method String StringBuilder.toString()>
    //  228  530:invokevirtual   #148 <Method void PrintStream.println(String)>
                    e.printStackTrace();
    //  229  533:aload           15
    //  230  535:invokevirtual   #294 <Method void Throwable.printStackTrace()>
                    result.remove(i);
    //  231  538:aload_2         
    //  232  539:iload           9
    //  233  541:invokevirtual   #286 <Method Object Vector.remove(int)>
    //  234  544:pop             
                }

    //  235  545:iload           9
    //  236  547:aload_2         
    //  237  548:invokevirtual   #297 <Method int Vector.size()>
    //  238  551:icmplt          407
            Collections.sort(result, new StringCompare());
    //  239  554:aload_2         
    //  240  555:new             #191 <Class ClassDiscovery$StringCompare>
    //  241  558:dup             
    //  242  559:invokespecial   #192 <Method void ClassDiscovery$StringCompare()>
    //  243  562:invokestatic    #198 <Method void Collections.sort(java.util.List, Comparator)>
            addCache(cls, pkgname, result);
    //  244  565:aload_0         
    //  245  566:aload_1         
    //  246  567:aload_2         
    //  247  568:invokestatic    #301 <Method void addCache(Class, String, Vector)>
        }
        return result;
    //  248  571:aload_2         
    //  249  572:areturn         
    }

    protected static HashSet getSubDirectories(String prefix, File dir, HashSet list)
    {
        String newPrefix;
        if(prefix == null)
    //*   0    0:aload_0         
    //*   1    1:ifnonnull       11
            newPrefix = "";
    //    2    4:ldc1            #250 <String "">
    //    3    6:astore          5
        else
    //*   4    8:goto            55
        if(prefix.length() == 0)
    //*   5   11:aload_0         
    //*   6   12:invokevirtual   #263 <Method int String.length()>
    //*   7   15:ifne            27
            newPrefix = dir.getName();
    //    8   18:aload_1         
    //    9   19:invokevirtual   #239 <Method String File.getName()>
    //   10   22:astore          5
        else
    //*  11   24:goto            55
            newPrefix = (new StringBuilder(String.valueOf(prefix))).append(".").append(dir.getName()).toString();
    //   12   27:new             #78  <Class StringBuilder>
    //   13   30:dup             
    //   14   31:aload_0         
    //   15   32:invokestatic    #84  <Method String String.valueOf(Object)>
    //   16   35:invokespecial   #85  <Method void StringBuilder(String)>
    //   17   38:ldc1            #246 <String ".">
    //   18   40:invokevirtual   #89  <Method StringBuilder StringBuilder.append(String)>
    //   19   43:aload_1         
    //   20   44:invokevirtual   #239 <Method String File.getName()>
    //   21   47:invokevirtual   #89  <Method StringBuilder StringBuilder.append(String)>
    //   22   50:invokevirtual   #93  <Method String StringBuilder.toString()>
    //   23   53:astore          5
        if(newPrefix.length() != 0)
    //*  24   55:aload           5
    //*  25   57:invokevirtual   #263 <Method int String.length()>
    //*  26   60:ifeq            70
            list.add(newPrefix);
    //   27   63:aload_2         
    //   28   64:aload           5
    //   29   66:invokevirtual   #317 <Method boolean HashSet.add(Object)>
    //   30   69:pop             
        File files[] = dir.listFiles();
    //   31   70:aload_1         
    //   32   71:invokevirtual   #233 <Method File[] File.listFiles()>
    //   33   74:astore_3        
        if(files != null)
    //*  34   75:aload_3         
    //*  35   76:ifnull          116
        {
            for(int i = 0; i < files.length; i++)
    //*  36   79:iconst_0        
    //*  37   80:istore          4
    //*  38   82:goto            109
                if(files[i].isDirectory())
    //*  39   85:aload_3         
    //*  40   86:iload           4
    //*  41   88:aaload          
    //*  42   89:invokevirtual   #76  <Method boolean File.isDirectory()>
    //*  43   92:ifeq            106
                    list = getSubDirectories(newPrefix, files[i], list);
    //   44   95:aload           5
    //   45   97:aload_3         
    //   46   98:iload           4
    //   47  100:aaload          
    //   48  101:aload_2         
    //   49  102:invokestatic    #319 <Method HashSet getSubDirectories(String, File, HashSet)>
    //   50  105:astore_2        

    //   51  106:iinc            4  1
    //   52  109:iload           4
    //   53  111:aload_3         
    //   54  112:arraylength     
    //   55  113:icmplt          85
        }
        return list;
    //   56  116:aload_2         
    //   57  117:areturn         
    }

    public static Vector findPackages()
    {
        Vector result = new Vector();
    //    0    0:new             #164 <Class Vector>
    //    1    3:dup             
    //    2    4:invokespecial   #165 <Method void Vector()>
    //    3    7:astore_0        
        HashSet set = new HashSet();
    //    4    8:new             #181 <Class HashSet>
    //    5   11:dup             
    //    6   12:invokespecial   #182 <Method void HashSet()>
    //    7   15:astore          7
        for(StringTokenizer tok = new StringTokenizer(System.getProperty("java.class.path"), System.getProperty("path.separator")); tok.hasMoreTokens();)
    //*   8   17:new             #213 <Class StringTokenizer>
    //*   9   20:dup             
    //*  10   21:ldc1            #215 <String "java.class.path">
    //*  11   23:invokestatic    #219 <Method String System.getProperty(String)>
    //*  12   26:ldc1            #221 <String "path.separator">
    //*  13   28:invokestatic    #219 <Method String System.getProperty(String)>
    //*  14   31:invokespecial   #224 <Method void StringTokenizer(String, String)>
    //*  15   34:astore_1        
    //*  16   35:goto            167
        {
            String part = tok.nextToken();
    //   17   38:aload_1         
    //   18   39:invokevirtual   #227 <Method String StringTokenizer.nextToken()>
    //   19   42:astore_2        
            File file = new File(part);
    //   20   43:new             #69  <Class File>
    //   21   46:dup             
    //   22   47:aload_2         
    //   23   48:invokespecial   #72  <Method void File(String)>
    //   24   51:astore_3        
            if(file.isDirectory())
    //*  25   52:aload_3         
    //*  26   53:invokevirtual   #76  <Method boolean File.isDirectory()>
    //*  27   56:ifeq            71
                set = getSubDirectories(null, file, set);
    //   28   59:aconst_null     
    //   29   60:aload_3         
    //   30   61:aload           7
    //   31   63:invokestatic    #319 <Method HashSet getSubDirectories(String, File, HashSet)>
    //   32   66:astore          7
            else
    //*  33   68:goto            167
            if(file.exists())
    //*  34   71:aload_3         
    //*  35   72:invokevirtual   #96  <Method boolean File.exists()>
    //*  36   75:ifeq            167
                try
                {
                    JarFile jar = new JarFile(part);
    //   37   78:new             #100 <Class JarFile>
    //   38   81:dup             
    //   39   82:aload_2         
    //   40   83:invokespecial   #101 <Method void JarFile(String)>
    //   41   86:astore          4
                    for(Enumeration enm = jar.entries(); enm.hasMoreElements();)
    //*  42   88:aload           4
    //*  43   90:invokevirtual   #105 <Method Enumeration JarFile.entries()>
    //*  44   93:astore          6
    //*  45   95:goto            147
                    {
                        JarEntry entry = (JarEntry)(JarEntry)enm.nextElement();
    //   46   98:aload           6
    //   47  100:invokeinterface #115 <Method Object Enumeration.nextElement()>
    //   48  105:checkcast       #257 <Class JarEntry>
    //   49  108:checkcast       #257 <Class JarEntry>
    //   50  111:astore          5
                        if(entry.isDirectory())
    //*  51  113:aload           5
    //*  52  115:invokevirtual   #258 <Method boolean JarEntry.isDirectory()>
    //*  53  118:ifeq            147
                            set.add(entry.getName().replaceAll("/", ".").replaceAll("\\.$", ""));
    //   54  121:aload           7
    //   55  123:aload           5
    //   56  125:invokevirtual   #259 <Method String JarEntry.getName()>
    //   57  128:ldc1            #207 <String "/">
    //   58  130:ldc1            #246 <String ".">
    //   59  132:invokevirtual   #211 <Method String String.replaceAll(String, String)>
    //   60  135:ldc2            #326 <String "\\.$">
    //   61  138:ldc1            #250 <String "">
    //   62  140:invokevirtual   #211 <Method String String.replaceAll(String, String)>
    //   63  143:invokevirtual   #317 <Method boolean HashSet.add(Object)>
    //   64  146:pop             
                    }

    //   65  147:aload           6
    //   66  149:invokeinterface #127 <Method boolean Enumeration.hasMoreElements()>
    //   67  154:ifne            98
                }
    //*  68  157:goto            167
                catch(Exception e)
    //*  69  160:astore          8
                {
                    e.printStackTrace();
    //   70  162:aload           8
    //   71  164:invokevirtual   #171 <Method void Exception.printStackTrace()>
                }
        }

    //   72  167:aload_1         
    //   73  168:invokevirtual   #270 <Method boolean StringTokenizer.hasMoreTokens()>
    //   74  171:ifne            38
        set.remove("META-INF");
    //   75  174:aload           7
    //   76  176:ldc2            #328 <String "META-INF">
    //   77  179:invokevirtual   #330 <Method boolean HashSet.remove(Object)>
    //   78  182:pop             
        result.addAll(set);
    //   79  183:aload_0         
    //   80  184:aload           7
    //   81  186:invokevirtual   #189 <Method boolean Vector.addAll(java.util.Collection)>
    //   82  189:pop             
        Collections.sort(result, new StringCompare());
    //   83  190:aload_0         
    //   84  191:new             #191 <Class ClassDiscovery$StringCompare>
    //   85  194:dup             
    //   86  195:invokespecial   #192 <Method void ClassDiscovery$StringCompare()>
    //   87  198:invokestatic    #198 <Method void Collections.sort(java.util.List, Comparator)>
        return result;
    //   88  201:aload_0         
    //   89  202:areturn         
    }

    protected static void initCache()
    {
        if(m_Cache == null)
    //*   0    0:getstatic       #334 <Field Hashtable m_Cache>
    //*   1    3:ifnonnull       16
            m_Cache = new Hashtable();
    //    2    6:new             #336 <Class Hashtable>
    //    3    9:dup             
    //    4   10:invokespecial   #337 <Method void Hashtable()>
    //    5   13:putstatic       #334 <Field Hashtable m_Cache>
    //    6   16:return          
    }

    protected static void addCache(Class cls, String pkgname, Vector classnames)
    {
        initCache();
    //    0    0:invokestatic    #339 <Method void initCache()>
        m_Cache.put((new StringBuilder(String.valueOf(cls.getName()))).append("-").append(pkgname).toString(), classnames);
    //    1    3:getstatic       #334 <Field Hashtable m_Cache>
    //    2    6:new             #78  <Class StringBuilder>
    //    3    9:dup             
    //    4   10:aload_0         
    //    5   11:invokevirtual   #340 <Method String Class.getName()>
    //    6   14:invokestatic    #84  <Method String String.valueOf(Object)>
    //    7   17:invokespecial   #85  <Method void StringBuilder(String)>
    //    8   20:ldc2            #342 <String "-">
    //    9   23:invokevirtual   #89  <Method StringBuilder StringBuilder.append(String)>
    //   10   26:aload_1         
    //   11   27:invokevirtual   #89  <Method StringBuilder StringBuilder.append(String)>
    //   12   30:invokevirtual   #93  <Method String StringBuilder.toString()>
    //   13   33:aload_2         
    //   14   34:invokevirtual   #346 <Method Object Hashtable.put(Object, Object)>
    //   15   37:pop             
    //   16   38:return          
    }

    protected static Vector getCache(Class cls, String pkgname)
    {
        initCache();
    //    0    0:invokestatic    #339 <Method void initCache()>
        return (Vector)m_Cache.get((new StringBuilder(String.valueOf(cls.getName()))).append("-").append(pkgname).toString());
    //    1    3:getstatic       #334 <Field Hashtable m_Cache>
    //    2    6:new             #78  <Class StringBuilder>
    //    3    9:dup             
    //    4   10:aload_0         
    //    5   11:invokevirtual   #340 <Method String Class.getName()>
    //    6   14:invokestatic    #84  <Method String String.valueOf(Object)>
    //    7   17:invokespecial   #85  <Method void StringBuilder(String)>
    //    8   20:ldc2            #342 <String "-">
    //    9   23:invokevirtual   #89  <Method StringBuilder StringBuilder.append(String)>
    //   10   26:aload_1         
    //   11   27:invokevirtual   #89  <Method StringBuilder StringBuilder.append(String)>
    //   12   30:invokevirtual   #93  <Method String StringBuilder.toString()>
    //   13   33:invokevirtual   #350 <Method Object Hashtable.get(Object)>
    //   14   36:checkcast       #164 <Class Vector>
    //   15   39:areturn         
    }

    public static void clearCache()
    {
        initCache();
    //    0    0:invokestatic    #339 <Method void initCache()>
        m_Cache.clear();
    //    1    3:getstatic       #334 <Field Hashtable m_Cache>
    //    2    6:invokevirtual   #354 <Method void Hashtable.clear()>
    //    3    9:return          
    }

    public static void main(String args[])
    {
        if(args.length == 1 && args[0].equals("packages"))
    //*   0    0:aload_0         
    //*   1    1:arraylength     
    //*   2    2:iconst_1        
    //*   3    3:icmpne          52
    //*   4    6:aload_0         
    //*   5    7:iconst_0        
    //*   6    8:aaload          
    //*   7    9:ldc2            #358 <String "packages">
    //*   8   12:invokevirtual   #359 <Method boolean String.equals(Object)>
    //*   9   15:ifeq            52
        {
            Vector list = findPackages();
    //   10   18:invokestatic    #361 <Method Vector findPackages()>
    //   11   21:astore_1        
            for(int i = 0; i < list.size(); i++)
    //*  12   22:iconst_0        
    //*  13   23:istore_3        
    //*  14   24:goto            41
                System.out.println(list.get(i));
    //   15   27:getstatic       #364 <Field PrintStream System.out>
    //   16   30:aload_1         
    //   17   31:iload_3         
    //   18   32:invokevirtual   #274 <Method Object Vector.get(int)>
    //   19   35:invokevirtual   #367 <Method void PrintStream.println(Object)>

    //   20   38:iinc            3  1
    //   21   41:iload_3         
    //   22   42:aload_1         
    //   23   43:invokevirtual   #297 <Method int Vector.size()>
    //   24   46:icmplt          27
        } else
    //*  25   49:goto            352
        if(args.length == 2)
    //*  26   52:aload_0         
    //*  27   53:arraylength     
    //*  28   54:iconst_2        
    //*  29   55:icmpne          246
        {
            Vector packages = new Vector();
    //   30   58:new             #164 <Class Vector>
    //   31   61:dup             
    //   32   62:invokespecial   #165 <Method void Vector()>
    //   33   65:astore_2        
            for(StringTokenizer tok = new StringTokenizer(args[1], ","); tok.hasMoreTokens(); packages.add(tok.nextToken()));
    //   34   66:new             #213 <Class StringTokenizer>
    //   35   69:dup             
    //   36   70:aload_0         
    //   37   71:iconst_1        
    //   38   72:aaload          
    //   39   73:ldc2            #369 <String ",">
    //   40   76:invokespecial   #224 <Method void StringTokenizer(String, String)>
    //   41   79:astore          4
    //   42   81:goto            94
    //   43   84:aload_2         
    //   44   85:aload           4
    //   45   87:invokevirtual   #227 <Method String StringTokenizer.nextToken()>
    //   46   90:invokevirtual   #255 <Method boolean Vector.add(Object)>
    //   47   93:pop             
    //   48   94:aload           4
    //   49   96:invokevirtual   #270 <Method boolean StringTokenizer.hasMoreTokens()>
    //   50   99:ifne            84
            Vector list = find(args[0], (String[])(String[])packages.toArray(new String[packages.size()]));
    //   51  102:aload_0         
    //   52  103:iconst_0        
    //   53  104:aaload          
    //   54  105:aload_2         
    //   55  106:aload_2         
    //   56  107:invokevirtual   #297 <Method int Vector.size()>
    //   57  110:anewarray       String[]
    //   58  113:invokevirtual   #373 <Method Object[] Vector.toArray(Object[])>
    //   59  116:checkcast       #374 <Class String[]>
    //   60  119:checkcast       #374 <Class String[]>
    //   61  122:invokestatic    #376 <Method Vector find(String, String[])>
    //   62  125:astore_1        
            System.out.println((new StringBuilder("Searching for '")).append(args[0]).append("' in '").append(args[1]).append("':\n").append("  ").append(list.size()).append(" found.").toString());
    //   63  126:getstatic       #364 <Field PrintStream System.out>
    //   64  129:new             #78  <Class StringBuilder>
    //   65  132:dup             
    //   66  133:ldc2            #378 <String "Searching for '">
    //   67  136:invokespecial   #85  <Method void StringBuilder(String)>
    //   68  139:aload_0         
    //   69  140:iconst_0        
    //   70  141:aaload          
    //   71  142:invokevirtual   #89  <Method StringBuilder StringBuilder.append(String)>
    //   72  145:ldc2            #380 <String "' in '">
    //   73  148:invokevirtual   #89  <Method StringBuilder StringBuilder.append(String)>
    //   74  151:aload_0         
    //   75  152:iconst_1        
    //   76  153:aaload          
    //   77  154:invokevirtual   #89  <Method StringBuilder StringBuilder.append(String)>
    //   78  157:ldc2            #382 <String "':\n">
    //   79  160:invokevirtual   #89  <Method StringBuilder StringBuilder.append(String)>
    //   80  163:ldc2            #384 <String "  ">
    //   81  166:invokevirtual   #89  <Method StringBuilder StringBuilder.append(String)>
    //   82  169:aload_1         
    //   83  170:invokevirtual   #297 <Method int Vector.size()>
    //   84  173:invokevirtual   #387 <Method StringBuilder StringBuilder.append(int)>
    //   85  176:ldc2            #389 <String " found.">
    //   86  179:invokevirtual   #89  <Method StringBuilder StringBuilder.append(String)>
    //   87  182:invokevirtual   #93  <Method String StringBuilder.toString()>
    //   88  185:invokevirtual   #148 <Method void PrintStream.println(String)>
            for(int i = 0; i < list.size(); i++)
    //*  89  188:iconst_0        
    //*  90  189:istore_3        
    //*  91  190:goto            235
                System.out.println((new StringBuilder("  ")).append(i + 1).append(". ").append(list.get(i)).toString());
    //   92  193:getstatic       #364 <Field PrintStream System.out>
    //   93  196:new             #78  <Class StringBuilder>
    //   94  199:dup             
    //   95  200:ldc2            #384 <String "  ">
    //   96  203:invokespecial   #85  <Method void StringBuilder(String)>
    //   97  206:iload_3         
    //   98  207:iconst_1        
    //   99  208:iadd            
    //  100  209:invokevirtual   #387 <Method StringBuilder StringBuilder.append(int)>
    //  101  212:ldc2            #391 <String ". ">
    //  102  215:invokevirtual   #89  <Method StringBuilder StringBuilder.append(String)>
    //  103  218:aload_1         
    //  104  219:iload_3         
    //  105  220:invokevirtual   #274 <Method Object Vector.get(int)>
    //  106  223:invokevirtual   #143 <Method StringBuilder StringBuilder.append(Object)>
    //  107  226:invokevirtual   #93  <Method String StringBuilder.toString()>
    //  108  229:invokevirtual   #148 <Method void PrintStream.println(String)>

    //  109  232:iinc            3  1
    //  110  235:iload_3         
    //  111  236:aload_1         
    //  112  237:invokevirtual   #297 <Method int Vector.size()>
    //  113  240:icmplt          193
        } else
    //* 114  243:goto            352
        {
            System.out.println("\nUsage:");
    //  115  246:getstatic       #364 <Field PrintStream System.out>
    //  116  249:ldc2            #393 <String "\nUsage:">
    //  117  252:invokevirtual   #148 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder(String.valueOf(rm/core/ClassDiscovery.getName()))).append(" packages").toString());
    //  118  255:getstatic       #364 <Field PrintStream System.out>
    //  119  258:new             #78  <Class StringBuilder>
    //  120  261:dup             
    //  121  262:ldc1            #2   <Class ClassDiscovery>
    //  122  264:invokevirtual   #340 <Method String Class.getName()>
    //  123  267:invokestatic    #84  <Method String String.valueOf(Object)>
    //  124  270:invokespecial   #85  <Method void StringBuilder(String)>
    //  125  273:ldc2            #395 <String " packages">
    //  126  276:invokevirtual   #89  <Method StringBuilder StringBuilder.append(String)>
    //  127  279:invokevirtual   #93  <Method String StringBuilder.toString()>
    //  128  282:invokevirtual   #148 <Method void PrintStream.println(String)>
            System.out.println("\tlists all packages in the classpath");
    //  129  285:getstatic       #364 <Field PrintStream System.out>
    //  130  288:ldc2            #397 <String "\tlists all packages in the classpath">
    //  131  291:invokevirtual   #148 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder(String.valueOf(rm/core/ClassDiscovery.getName()))).append(" <classname> <packagename(s)>").toString());
    //  132  294:getstatic       #364 <Field PrintStream System.out>
    //  133  297:new             #78  <Class StringBuilder>
    //  134  300:dup             
    //  135  301:ldc1            #2   <Class ClassDiscovery>
    //  136  303:invokevirtual   #340 <Method String Class.getName()>
    //  137  306:invokestatic    #84  <Method String String.valueOf(Object)>
    //  138  309:invokespecial   #85  <Method void StringBuilder(String)>
    //  139  312:ldc2            #399 <String " <classname> <packagename(s)>">
    //  140  315:invokevirtual   #89  <Method StringBuilder StringBuilder.append(String)>
    //  141  318:invokevirtual   #93  <Method String StringBuilder.toString()>
    //  142  321:invokevirtual   #148 <Method void PrintStream.println(String)>
            System.out.println("\tlists classes derived from/implementing 'classname' that");
    //  143  324:getstatic       #364 <Field PrintStream System.out>
    //  144  327:ldc2            #401 <String "\tlists classes derived from/implementing 'classname' that">
    //  145  330:invokevirtual   #148 <Method void PrintStream.println(String)>
            System.out.println("\tcan be found in 'packagename(s)' (comma-separated list");
    //  146  333:getstatic       #364 <Field PrintStream System.out>
    //  147  336:ldc2            #403 <String "\tcan be found in 'packagename(s)' (comma-separated list">
    //  148  339:invokevirtual   #148 <Method void PrintStream.println(String)>
            System.out.println();
    //  149  342:getstatic       #364 <Field PrintStream System.out>
    //  150  345:invokevirtual   #405 <Method void PrintStream.println()>
            System.exit(1);
    //  151  348:iconst_1        
    //  152  349:invokestatic    #409 <Method void System.exit(int)>
        }
    //  153  352:return          
    }

    public static final boolean VERBOSE = false;
    protected static Hashtable m_Cache;
    static Class class$0;
    static Class class$1;
}
