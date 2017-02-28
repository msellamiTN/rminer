// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   Version.java

package rm.core;

import java.io.*;

// Referenced classes of package rm.core:
//            RevisionHandler, RevisionUtils

public class Version
    implements Comparable, RevisionHandler
{

    public Version()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #129 <Method void Object()>
    //    2    4:return          
    }

    private static void parseVersion(String version, int maj[], int min[], int rev[])
    {
        int major;
        int minor;
        int revision;
        major = 0;
    //    0    0:iconst_0        
    //    1    1:istore          4
        minor = 0;
    //    2    3:iconst_0        
    //    3    4:istore          5
        revision = 0;
    //    4    6:iconst_0        
    //    5    7:istore          6
        try
        {
            String tmpStr = version;
    //    6    9:aload_0         
    //    7   10:astore          7
            tmpStr = tmpStr.replace('-', '.');
    //    8   12:aload           7
    //    9   14:bipush          45
    //   10   16:bipush          46
    //   11   18:invokevirtual   #135 <Method String String.replace(char, char)>
    //   12   21:astore          7
            if(tmpStr.indexOf(".") > -1)
    //*  13   23:aload           7
    //*  14   25:ldc1            #108 <String ".">
    //*  15   27:invokevirtual   #139 <Method int String.indexOf(String)>
    //*  16   30:iconst_m1       
    //*  17   31:icmple          165
            {
                major = Integer.parseInt(tmpStr.substring(0, tmpStr.indexOf(".")));
    //   18   34:aload           7
    //   19   36:iconst_0        
    //   20   37:aload           7
    //   21   39:ldc1            #108 <String ".">
    //   22   41:invokevirtual   #139 <Method int String.indexOf(String)>
    //   23   44:invokevirtual   #143 <Method String String.substring(int, int)>
    //   24   47:invokestatic    #148 <Method int Integer.parseInt(String)>
    //   25   50:istore          4
                tmpStr = tmpStr.substring(tmpStr.indexOf(".") + 1);
    //   26   52:aload           7
    //   27   54:aload           7
    //   28   56:ldc1            #108 <String ".">
    //   29   58:invokevirtual   #139 <Method int String.indexOf(String)>
    //   30   61:iconst_1        
    //   31   62:iadd            
    //   32   63:invokevirtual   #150 <Method String String.substring(int)>
    //   33   66:astore          7
                if(tmpStr.indexOf(".") > -1)
    //*  34   68:aload           7
    //*  35   70:ldc1            #108 <String ".">
    //*  36   72:invokevirtual   #139 <Method int String.indexOf(String)>
    //*  37   75:iconst_m1       
    //*  38   76:icmple          139
                {
                    minor = Integer.parseInt(tmpStr.substring(0, tmpStr.indexOf(".")));
    //   39   79:aload           7
    //   40   81:iconst_0        
    //   41   82:aload           7
    //   42   84:ldc1            #108 <String ".">
    //   43   86:invokevirtual   #139 <Method int String.indexOf(String)>
    //   44   89:invokevirtual   #143 <Method String String.substring(int, int)>
    //   45   92:invokestatic    #148 <Method int Integer.parseInt(String)>
    //   46   95:istore          5
                    tmpStr = tmpStr.substring(tmpStr.indexOf(".") + 1);
    //   47   97:aload           7
    //   48   99:aload           7
    //   49  101:ldc1            #108 <String ".">
    //   50  103:invokevirtual   #139 <Method int String.indexOf(String)>
    //   51  106:iconst_1        
    //   52  107:iadd            
    //   53  108:invokevirtual   #150 <Method String String.substring(int)>
    //   54  111:astore          7
                    if(!tmpStr.equals(""))
    //*  55  113:aload           7
    //*  56  115:ldc1            #152 <String "">
    //*  57  117:invokevirtual   #156 <Method boolean String.equals(Object)>
    //*  58  120:ifne            133
                        revision = Integer.parseInt(tmpStr);
    //   59  123:aload           7
    //   60  125:invokestatic    #148 <Method int Integer.parseInt(String)>
    //   61  128:istore          6
                    else
    //*  62  130:goto            230
                        revision = 0;
    //   63  133:iconst_0        
    //   64  134:istore          6
                } else
    //*  65  136:goto            230
                if(!tmpStr.equals(""))
    //*  66  139:aload           7
    //*  67  141:ldc1            #152 <String "">
    //*  68  143:invokevirtual   #156 <Method boolean String.equals(Object)>
    //*  69  146:ifne            159
                    minor = Integer.parseInt(tmpStr);
    //   70  149:aload           7
    //   71  151:invokestatic    #148 <Method int Integer.parseInt(String)>
    //   72  154:istore          5
                else
    //*  73  156:goto            230
                    minor = 0;
    //   74  159:iconst_0        
    //   75  160:istore          5
            } else
    //*  76  162:goto            230
            if(!tmpStr.equals(""))
    //*  77  165:aload           7
    //*  78  167:ldc1            #152 <String "">
    //*  79  169:invokevirtual   #156 <Method boolean String.equals(Object)>
    //*  80  172:ifne            185
                major = Integer.parseInt(tmpStr);
    //   81  175:aload           7
    //   82  177:invokestatic    #148 <Method int Integer.parseInt(String)>
    //   83  180:istore          4
            else
    //*  84  182:goto            230
                major = 0;
    //   85  185:iconst_0        
    //   86  186:istore          4
        }
    //*  87  188:goto            230
        catch(Exception e)
    //*  88  191:astore          7
        {
            e.printStackTrace();
    //   89  193:aload           7
    //   90  195:invokevirtual   #159 <Method void Exception.printStackTrace()>
            major = -1;
    //   91  198:iconst_m1       
    //   92  199:istore          4
            minor = -1;
    //   93  201:iconst_m1       
    //   94  202:istore          5
            revision = -1;
    //   95  204:iconst_m1       
    //   96  205:istore          6
        }
        break MISSING_BLOCK_LABEL_230;
    //   97  207:goto            230
        Exception exception;
        exception;
    //   98  210:astore          8
        maj[0] = major;
    //   99  212:aload_1         
    //  100  213:iconst_0        
    //  101  214:iload           4
    //  102  216:iastore         
        min[0] = minor;
    //  103  217:aload_2         
    //  104  218:iconst_0        
    //  105  219:iload           5
    //  106  221:iastore         
        rev[0] = revision;
    //  107  222:aload_3         
    //  108  223:iconst_0        
    //  109  224:iload           6
    //  110  226:iastore         
        throw exception;
    //  111  227:aload           8
    //  112  229:athrow          
        maj[0] = major;
    //  113  230:aload_1         
    //  114  231:iconst_0        
    //  115  232:iload           4
    //  116  234:iastore         
        min[0] = minor;
    //  117  235:aload_2         
    //  118  236:iconst_0        
    //  119  237:iload           5
    //  120  239:iastore         
        rev[0] = revision;
    //  121  240:aload_3         
    //  122  241:iconst_0        
    //  123  242:iload           6
    //  124  244:iastore         
        return;
    //  125  245:return          
    }

    public int compareTo(Object o)
    {
        int maj[] = new int[1];
    //    0    0:iconst_1        
    //    1    1:newarray        int[]
    //    2    3:astore          6
        int min[] = new int[1];
    //    3    5:iconst_1        
    //    4    6:newarray        int[]
    //    5    8:astore          7
        int rev[] = new int[1];
    //    6   10:iconst_1        
    //    7   11:newarray        int[]
    //    8   13:astore          8
        int major;
        int minor;
        int revision;
        if(o instanceof String)
    //*   9   15:aload_1         
    //*  10   16:instanceof      #82  <Class String>
    //*  11   19:ifeq            55
        {
            parseVersion((String)o, maj, min, rev);
    //   12   22:aload_1         
    //   13   23:checkcast       #82  <Class String>
    //   14   26:aload           6
    //   15   28:aload           7
    //   16   30:aload           8
    //   17   32:invokestatic    #66  <Method void parseVersion(String, int[], int[], int[])>
            major = maj[0];
    //   18   35:aload           6
    //   19   37:iconst_0        
    //   20   38:iaload          
    //   21   39:istore_3        
            minor = min[0];
    //   22   40:aload           7
    //   23   42:iconst_0        
    //   24   43:iaload          
    //   25   44:istore          4
            revision = rev[0];
    //   26   46:aload           8
    //   27   48:iconst_0        
    //   28   49:iaload          
    //   29   50:istore          5
        } else
    //*  30   52:goto            94
        {
            System.out.println((new StringBuilder(String.valueOf(getClass().getName()))).append(": no version-string for comparTo povided!").toString());
    //   31   55:getstatic       #169 <Field PrintStream System.out>
    //   32   58:new             #77  <Class StringBuilder>
    //   33   61:dup             
    //   34   62:aload_0         
    //   35   63:invokevirtual   #36  <Method Class Object.getClass()>
    //   36   66:invokevirtual   #80  <Method String Class.getName()>
    //   37   69:invokestatic    #86  <Method String String.valueOf(Object)>
    //   38   72:invokespecial   #89  <Method void StringBuilder(String)>
    //   39   75:ldc1            #171 <String ": no version-string for comparTo povided!">
    //   40   77:invokevirtual   #95  <Method StringBuilder StringBuilder.append(String)>
    //   41   80:invokevirtual   #98  <Method String StringBuilder.toString()>
    //   42   83:invokevirtual   #103 <Method void PrintStream.println(String)>
            major = -1;
    //   43   86:iconst_m1       
    //   44   87:istore_3        
            minor = -1;
    //   45   88:iconst_m1       
    //   46   89:istore          4
            revision = -1;
    //   47   91:iconst_m1       
    //   48   92:istore          5
        }
        int result;
        if(MAJOR < major)
    //*  49   94:getstatic       #25  <Field int MAJOR>
    //*  50   97:iload_3         
    //*  51   98:icmpge          106
            result = -1;
    //   52  101:iconst_m1       
    //   53  102:istore_2        
        else
    //*  54  103:goto            172
        if(MAJOR == major)
    //*  55  106:getstatic       #25  <Field int MAJOR>
    //*  56  109:iload_3         
    //*  57  110:icmpne          170
        {
            if(MINOR < minor)
    //*  58  113:getstatic       #27  <Field int MINOR>
    //*  59  116:iload           4
    //*  60  118:icmpge          126
                result = -1;
    //   61  121:iconst_m1       
    //   62  122:istore_2        
            else
    //*  63  123:goto            172
            if(MINOR == minor)
    //*  64  126:getstatic       #27  <Field int MINOR>
    //*  65  129:iload           4
    //*  66  131:icmpne          165
            {
                if(REVISION < revision)
    //*  67  134:getstatic       #29  <Field int REVISION>
    //*  68  137:iload           5
    //*  69  139:icmpge          147
                    result = -1;
    //   70  142:iconst_m1       
    //   71  143:istore_2        
                else
    //*  72  144:goto            172
                if(REVISION == revision)
    //*  73  147:getstatic       #29  <Field int REVISION>
    //*  74  150:iload           5
    //*  75  152:icmpne          160
                    result = 0;
    //   76  155:iconst_0        
    //   77  156:istore_2        
                else
    //*  78  157:goto            172
                    result = 1;
    //   79  160:iconst_1        
    //   80  161:istore_2        
            } else
    //*  81  162:goto            172
            {
                result = 1;
    //   82  165:iconst_1        
    //   83  166:istore_2        
            }
        } else
    //*  84  167:goto            172
        {
            result = 1;
    //   85  170:iconst_1        
    //   86  171:istore_2        
        }
        return result;
    //   87  172:iload_2         
    //   88  173:ireturn         
    }

    public boolean equals(Object o)
    {
        return compareTo(o) == 0;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokevirtual   #176 <Method int compareTo(Object)>
    //    3    5:ifne            10
    //    4    8:iconst_1        
    //    5    9:ireturn         
    //    6   10:iconst_0        
    //    7   11:ireturn         
    }

    public boolean isOlder(Object o)
    {
        return compareTo(o) == -1;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokevirtual   #176 <Method int compareTo(Object)>
    //    3    5:iconst_m1       
    //    4    6:icmpne          11
    //    5    9:iconst_1        
    //    6   10:ireturn         
    //    7   11:iconst_0        
    //    8   12:ireturn         
    }

    public boolean isNewer(Object o)
    {
        return compareTo(o) == 1;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokevirtual   #176 <Method int compareTo(Object)>
    //    3    5:iconst_1        
    //    4    6:icmpne          11
    //    5    9:iconst_1        
    //    6   10:ireturn         
    //    7   11:iconst_0        
    //    8   12:ireturn         
    }

    public String toString()
    {
        return VERSION;
    //    0    0:getstatic       #113 <Field String VERSION>
    //    1    3:areturn         
    }

    public String getRevision()
    {
        return RevisionUtils.extract("$Revision: 1.8 $");
    //    0    0:ldc1            #181 <String "$Revision: 1.8 $">
    //    1    2:invokestatic    #187 <Method String RevisionUtils.extract(String)>
    //    2    5:areturn         
    }

    public static void main(String args[])
    {
        System.out.println((new StringBuilder(String.valueOf(VERSION))).append("\n").toString());
    //    0    0:getstatic       #169 <Field PrintStream System.out>
    //    1    3:new             #77  <Class StringBuilder>
    //    2    6:dup             
    //    3    7:getstatic       #113 <Field String VERSION>
    //    4   10:invokestatic    #86  <Method String String.valueOf(Object)>
    //    5   13:invokespecial   #89  <Method void StringBuilder(String)>
    //    6   16:ldc1            #191 <String "\n">
    //    7   18:invokevirtual   #95  <Method StringBuilder StringBuilder.append(String)>
    //    8   21:invokevirtual   #98  <Method String StringBuilder.toString()>
    //    9   24:invokevirtual   #103 <Method void PrintStream.println(String)>
        Version v = new Version();
    //   10   27:new             #2   <Class Version>
    //   11   30:dup             
    //   12   31:invokespecial   #32  <Method void Version()>
    //   13   34:astore_1        
        System.out.println((new StringBuilder("-1? ")).append(v.compareTo("5.0.1")).toString());
    //   14   35:getstatic       #169 <Field PrintStream System.out>
    //   15   38:new             #77  <Class StringBuilder>
    //   16   41:dup             
    //   17   42:ldc1            #193 <String "-1? ">
    //   18   44:invokespecial   #89  <Method void StringBuilder(String)>
    //   19   47:aload_1         
    //   20   48:ldc1            #195 <String "5.0.1">
    //   21   50:invokevirtual   #176 <Method int compareTo(Object)>
    //   22   53:invokevirtual   #111 <Method StringBuilder StringBuilder.append(int)>
    //   23   56:invokevirtual   #98  <Method String StringBuilder.toString()>
    //   24   59:invokevirtual   #103 <Method void PrintStream.println(String)>
        System.out.println((new StringBuilder(" 0? ")).append(v.compareTo(VERSION)).toString());
    //   25   62:getstatic       #169 <Field PrintStream System.out>
    //   26   65:new             #77  <Class StringBuilder>
    //   27   68:dup             
    //   28   69:ldc1            #197 <String " 0? ">
    //   29   71:invokespecial   #89  <Method void StringBuilder(String)>
    //   30   74:aload_1         
    //   31   75:getstatic       #113 <Field String VERSION>
    //   32   78:invokevirtual   #176 <Method int compareTo(Object)>
    //   33   81:invokevirtual   #111 <Method StringBuilder StringBuilder.append(int)>
    //   34   84:invokevirtual   #98  <Method String StringBuilder.toString()>
    //   35   87:invokevirtual   #103 <Method void PrintStream.println(String)>
        System.out.println((new StringBuilder("+1? ")).append(v.compareTo("3.4.0")).toString());
    //   36   90:getstatic       #169 <Field PrintStream System.out>
    //   37   93:new             #77  <Class StringBuilder>
    //   38   96:dup             
    //   39   97:ldc1            #199 <String "+1? ">
    //   40   99:invokespecial   #89  <Method void StringBuilder(String)>
    //   41  102:aload_1         
    //   42  103:ldc1            #201 <String "3.4.0">
    //   43  105:invokevirtual   #176 <Method int compareTo(Object)>
    //   44  108:invokevirtual   #111 <Method StringBuilder StringBuilder.append(int)>
    //   45  111:invokevirtual   #98  <Method String StringBuilder.toString()>
    //   46  114:invokevirtual   #103 <Method void PrintStream.println(String)>
        String tmpStr = "5.0.1";
    //   47  117:ldc1            #195 <String "5.0.1">
    //   48  119:astore_2        
        System.out.println((new StringBuilder("\ncomparing with ")).append(tmpStr).toString());
    //   49  120:getstatic       #169 <Field PrintStream System.out>
    //   50  123:new             #77  <Class StringBuilder>
    //   51  126:dup             
    //   52  127:ldc1            #203 <String "\ncomparing with ">
    //   53  129:invokespecial   #89  <Method void StringBuilder(String)>
    //   54  132:aload_2         
    //   55  133:invokevirtual   #95  <Method StringBuilder StringBuilder.append(String)>
    //   56  136:invokevirtual   #98  <Method String StringBuilder.toString()>
    //   57  139:invokevirtual   #103 <Method void PrintStream.println(String)>
        System.out.println((new StringBuilder("isOlder? ")).append(v.isOlder(tmpStr)).toString());
    //   58  142:getstatic       #169 <Field PrintStream System.out>
    //   59  145:new             #77  <Class StringBuilder>
    //   60  148:dup             
    //   61  149:ldc1            #205 <String "isOlder? ">
    //   62  151:invokespecial   #89  <Method void StringBuilder(String)>
    //   63  154:aload_1         
    //   64  155:aload_2         
    //   65  156:invokevirtual   #207 <Method boolean isOlder(Object)>
    //   66  159:invokevirtual   #210 <Method StringBuilder StringBuilder.append(boolean)>
    //   67  162:invokevirtual   #98  <Method String StringBuilder.toString()>
    //   68  165:invokevirtual   #103 <Method void PrintStream.println(String)>
        System.out.println((new StringBuilder("equals ? ")).append(v.equals(tmpStr)).toString());
    //   69  168:getstatic       #169 <Field PrintStream System.out>
    //   70  171:new             #77  <Class StringBuilder>
    //   71  174:dup             
    //   72  175:ldc1            #212 <String "equals ? ">
    //   73  177:invokespecial   #89  <Method void StringBuilder(String)>
    //   74  180:aload_1         
    //   75  181:aload_2         
    //   76  182:invokevirtual   #213 <Method boolean equals(Object)>
    //   77  185:invokevirtual   #210 <Method StringBuilder StringBuilder.append(boolean)>
    //   78  188:invokevirtual   #98  <Method String StringBuilder.toString()>
    //   79  191:invokevirtual   #103 <Method void PrintStream.println(String)>
        System.out.println((new StringBuilder("isNewer? ")).append(v.isNewer(tmpStr)).toString());
    //   80  194:getstatic       #169 <Field PrintStream System.out>
    //   81  197:new             #77  <Class StringBuilder>
    //   82  200:dup             
    //   83  201:ldc1            #215 <String "isNewer? ">
    //   84  203:invokespecial   #89  <Method void StringBuilder(String)>
    //   85  206:aload_1         
    //   86  207:aload_2         
    //   87  208:invokevirtual   #217 <Method boolean isNewer(Object)>
    //   88  211:invokevirtual   #210 <Method StringBuilder StringBuilder.append(boolean)>
    //   89  214:invokevirtual   #98  <Method String StringBuilder.toString()>
    //   90  217:invokevirtual   #103 <Method void PrintStream.println(String)>
        tmpStr = VERSION;
    //   91  220:getstatic       #113 <Field String VERSION>
    //   92  223:astore_2        
        System.out.println((new StringBuilder("\ncomparing with ")).append(tmpStr).toString());
    //   93  224:getstatic       #169 <Field PrintStream System.out>
    //   94  227:new             #77  <Class StringBuilder>
    //   95  230:dup             
    //   96  231:ldc1            #203 <String "\ncomparing with ">
    //   97  233:invokespecial   #89  <Method void StringBuilder(String)>
    //   98  236:aload_2         
    //   99  237:invokevirtual   #95  <Method StringBuilder StringBuilder.append(String)>
    //  100  240:invokevirtual   #98  <Method String StringBuilder.toString()>
    //  101  243:invokevirtual   #103 <Method void PrintStream.println(String)>
        System.out.println((new StringBuilder("isOlder? ")).append(v.isOlder(tmpStr)).toString());
    //  102  246:getstatic       #169 <Field PrintStream System.out>
    //  103  249:new             #77  <Class StringBuilder>
    //  104  252:dup             
    //  105  253:ldc1            #205 <String "isOlder? ">
    //  106  255:invokespecial   #89  <Method void StringBuilder(String)>
    //  107  258:aload_1         
    //  108  259:aload_2         
    //  109  260:invokevirtual   #207 <Method boolean isOlder(Object)>
    //  110  263:invokevirtual   #210 <Method StringBuilder StringBuilder.append(boolean)>
    //  111  266:invokevirtual   #98  <Method String StringBuilder.toString()>
    //  112  269:invokevirtual   #103 <Method void PrintStream.println(String)>
        System.out.println((new StringBuilder("equals ? ")).append(v.equals(tmpStr)).toString());
    //  113  272:getstatic       #169 <Field PrintStream System.out>
    //  114  275:new             #77  <Class StringBuilder>
    //  115  278:dup             
    //  116  279:ldc1            #212 <String "equals ? ">
    //  117  281:invokespecial   #89  <Method void StringBuilder(String)>
    //  118  284:aload_1         
    //  119  285:aload_2         
    //  120  286:invokevirtual   #213 <Method boolean equals(Object)>
    //  121  289:invokevirtual   #210 <Method StringBuilder StringBuilder.append(boolean)>
    //  122  292:invokevirtual   #98  <Method String StringBuilder.toString()>
    //  123  295:invokevirtual   #103 <Method void PrintStream.println(String)>
        System.out.println((new StringBuilder("isNewer? ")).append(v.isNewer(tmpStr)).toString());
    //  124  298:getstatic       #169 <Field PrintStream System.out>
    //  125  301:new             #77  <Class StringBuilder>
    //  126  304:dup             
    //  127  305:ldc1            #215 <String "isNewer? ">
    //  128  307:invokespecial   #89  <Method void StringBuilder(String)>
    //  129  310:aload_1         
    //  130  311:aload_2         
    //  131  312:invokevirtual   #217 <Method boolean isNewer(Object)>
    //  132  315:invokevirtual   #210 <Method StringBuilder StringBuilder.append(boolean)>
    //  133  318:invokevirtual   #98  <Method String StringBuilder.toString()>
    //  134  321:invokevirtual   #103 <Method void PrintStream.println(String)>
        tmpStr = "3.4.0";
    //  135  324:ldc1            #201 <String "3.4.0">
    //  136  326:astore_2        
        System.out.println((new StringBuilder("\ncomparing with ")).append(tmpStr).toString());
    //  137  327:getstatic       #169 <Field PrintStream System.out>
    //  138  330:new             #77  <Class StringBuilder>
    //  139  333:dup             
    //  140  334:ldc1            #203 <String "\ncomparing with ">
    //  141  336:invokespecial   #89  <Method void StringBuilder(String)>
    //  142  339:aload_2         
    //  143  340:invokevirtual   #95  <Method StringBuilder StringBuilder.append(String)>
    //  144  343:invokevirtual   #98  <Method String StringBuilder.toString()>
    //  145  346:invokevirtual   #103 <Method void PrintStream.println(String)>
        System.out.println((new StringBuilder("isOlder? ")).append(v.isOlder(tmpStr)).toString());
    //  146  349:getstatic       #169 <Field PrintStream System.out>
    //  147  352:new             #77  <Class StringBuilder>
    //  148  355:dup             
    //  149  356:ldc1            #205 <String "isOlder? ">
    //  150  358:invokespecial   #89  <Method void StringBuilder(String)>
    //  151  361:aload_1         
    //  152  362:aload_2         
    //  153  363:invokevirtual   #207 <Method boolean isOlder(Object)>
    //  154  366:invokevirtual   #210 <Method StringBuilder StringBuilder.append(boolean)>
    //  155  369:invokevirtual   #98  <Method String StringBuilder.toString()>
    //  156  372:invokevirtual   #103 <Method void PrintStream.println(String)>
        System.out.println((new StringBuilder("equals ? ")).append(v.equals(tmpStr)).toString());
    //  157  375:getstatic       #169 <Field PrintStream System.out>
    //  158  378:new             #77  <Class StringBuilder>
    //  159  381:dup             
    //  160  382:ldc1            #212 <String "equals ? ">
    //  161  384:invokespecial   #89  <Method void StringBuilder(String)>
    //  162  387:aload_1         
    //  163  388:aload_2         
    //  164  389:invokevirtual   #213 <Method boolean equals(Object)>
    //  165  392:invokevirtual   #210 <Method StringBuilder StringBuilder.append(boolean)>
    //  166  395:invokevirtual   #98  <Method String StringBuilder.toString()>
    //  167  398:invokevirtual   #103 <Method void PrintStream.println(String)>
        System.out.println((new StringBuilder("isNewer? ")).append(v.isNewer(tmpStr)).toString());
    //  168  401:getstatic       #169 <Field PrintStream System.out>
    //  169  404:new             #77  <Class StringBuilder>
    //  170  407:dup             
    //  171  408:ldc1            #215 <String "isNewer? ">
    //  172  410:invokespecial   #89  <Method void StringBuilder(String)>
    //  173  413:aload_1         
    //  174  414:aload_2         
    //  175  415:invokevirtual   #217 <Method boolean isNewer(Object)>
    //  176  418:invokevirtual   #210 <Method StringBuilder StringBuilder.append(boolean)>
    //  177  421:invokevirtual   #98  <Method String StringBuilder.toString()>
    //  178  424:invokevirtual   #103 <Method void PrintStream.println(String)>
        tmpStr = "3.4";
    //  179  427:ldc1            #219 <String "3.4">
    //  180  429:astore_2        
        System.out.println((new StringBuilder("\ncomparing with ")).append(tmpStr).toString());
    //  181  430:getstatic       #169 <Field PrintStream System.out>
    //  182  433:new             #77  <Class StringBuilder>
    //  183  436:dup             
    //  184  437:ldc1            #203 <String "\ncomparing with ">
    //  185  439:invokespecial   #89  <Method void StringBuilder(String)>
    //  186  442:aload_2         
    //  187  443:invokevirtual   #95  <Method StringBuilder StringBuilder.append(String)>
    //  188  446:invokevirtual   #98  <Method String StringBuilder.toString()>
    //  189  449:invokevirtual   #103 <Method void PrintStream.println(String)>
        System.out.println((new StringBuilder("isOlder? ")).append(v.isOlder(tmpStr)).toString());
    //  190  452:getstatic       #169 <Field PrintStream System.out>
    //  191  455:new             #77  <Class StringBuilder>
    //  192  458:dup             
    //  193  459:ldc1            #205 <String "isOlder? ">
    //  194  461:invokespecial   #89  <Method void StringBuilder(String)>
    //  195  464:aload_1         
    //  196  465:aload_2         
    //  197  466:invokevirtual   #207 <Method boolean isOlder(Object)>
    //  198  469:invokevirtual   #210 <Method StringBuilder StringBuilder.append(boolean)>
    //  199  472:invokevirtual   #98  <Method String StringBuilder.toString()>
    //  200  475:invokevirtual   #103 <Method void PrintStream.println(String)>
        System.out.println((new StringBuilder("equals ? ")).append(v.equals(tmpStr)).toString());
    //  201  478:getstatic       #169 <Field PrintStream System.out>
    //  202  481:new             #77  <Class StringBuilder>
    //  203  484:dup             
    //  204  485:ldc1            #212 <String "equals ? ">
    //  205  487:invokespecial   #89  <Method void StringBuilder(String)>
    //  206  490:aload_1         
    //  207  491:aload_2         
    //  208  492:invokevirtual   #213 <Method boolean equals(Object)>
    //  209  495:invokevirtual   #210 <Method StringBuilder StringBuilder.append(boolean)>
    //  210  498:invokevirtual   #98  <Method String StringBuilder.toString()>
    //  211  501:invokevirtual   #103 <Method void PrintStream.println(String)>
        System.out.println((new StringBuilder("isNewer? ")).append(v.isNewer(tmpStr)).toString());
    //  212  504:getstatic       #169 <Field PrintStream System.out>
    //  213  507:new             #77  <Class StringBuilder>
    //  214  510:dup             
    //  215  511:ldc1            #215 <String "isNewer? ">
    //  216  513:invokespecial   #89  <Method void StringBuilder(String)>
    //  217  516:aload_1         
    //  218  517:aload_2         
    //  219  518:invokevirtual   #217 <Method boolean isNewer(Object)>
    //  220  521:invokevirtual   #210 <Method StringBuilder StringBuilder.append(boolean)>
    //  221  524:invokevirtual   #98  <Method String StringBuilder.toString()>
    //  222  527:invokevirtual   #103 <Method void PrintStream.println(String)>
        tmpStr = "5";
    //  223  530:ldc1            #221 <String "5">
    //  224  532:astore_2        
        System.out.println((new StringBuilder("\ncomparing with ")).append(tmpStr).toString());
    //  225  533:getstatic       #169 <Field PrintStream System.out>
    //  226  536:new             #77  <Class StringBuilder>
    //  227  539:dup             
    //  228  540:ldc1            #203 <String "\ncomparing with ">
    //  229  542:invokespecial   #89  <Method void StringBuilder(String)>
    //  230  545:aload_2         
    //  231  546:invokevirtual   #95  <Method StringBuilder StringBuilder.append(String)>
    //  232  549:invokevirtual   #98  <Method String StringBuilder.toString()>
    //  233  552:invokevirtual   #103 <Method void PrintStream.println(String)>
        System.out.println((new StringBuilder("isOlder? ")).append(v.isOlder(tmpStr)).toString());
    //  234  555:getstatic       #169 <Field PrintStream System.out>
    //  235  558:new             #77  <Class StringBuilder>
    //  236  561:dup             
    //  237  562:ldc1            #205 <String "isOlder? ">
    //  238  564:invokespecial   #89  <Method void StringBuilder(String)>
    //  239  567:aload_1         
    //  240  568:aload_2         
    //  241  569:invokevirtual   #207 <Method boolean isOlder(Object)>
    //  242  572:invokevirtual   #210 <Method StringBuilder StringBuilder.append(boolean)>
    //  243  575:invokevirtual   #98  <Method String StringBuilder.toString()>
    //  244  578:invokevirtual   #103 <Method void PrintStream.println(String)>
        System.out.println((new StringBuilder("equals ? ")).append(v.equals(tmpStr)).toString());
    //  245  581:getstatic       #169 <Field PrintStream System.out>
    //  246  584:new             #77  <Class StringBuilder>
    //  247  587:dup             
    //  248  588:ldc1            #212 <String "equals ? ">
    //  249  590:invokespecial   #89  <Method void StringBuilder(String)>
    //  250  593:aload_1         
    //  251  594:aload_2         
    //  252  595:invokevirtual   #213 <Method boolean equals(Object)>
    //  253  598:invokevirtual   #210 <Method StringBuilder StringBuilder.append(boolean)>
    //  254  601:invokevirtual   #98  <Method String StringBuilder.toString()>
    //  255  604:invokevirtual   #103 <Method void PrintStream.println(String)>
        System.out.println((new StringBuilder("isNewer? ")).append(v.isNewer(tmpStr)).toString());
    //  256  607:getstatic       #169 <Field PrintStream System.out>
    //  257  610:new             #77  <Class StringBuilder>
    //  258  613:dup             
    //  259  614:ldc1            #215 <String "isNewer? ">
    //  260  616:invokespecial   #89  <Method void StringBuilder(String)>
    //  261  619:aload_1         
    //  262  620:aload_2         
    //  263  621:invokevirtual   #217 <Method boolean isNewer(Object)>
    //  264  624:invokevirtual   #210 <Method StringBuilder StringBuilder.append(boolean)>
    //  265  627:invokevirtual   #98  <Method String StringBuilder.toString()>
    //  266  630:invokevirtual   #103 <Method void PrintStream.println(String)>
    //  267  633:return          
    }

    public static final String VERSION_FILE = "weka/core/version.txt";
    public static int MAJOR;
    public static int MINOR;
    public static int REVISION;
    public static String VERSION;
    static Class class$0;

    static 
    {
        MAJOR = 3;
    //    0    0:iconst_3        
    //    1    1:putstatic       #25  <Field int MAJOR>
        MINOR = 4;
    //    2    4:iconst_4        
    //    3    5:putstatic       #27  <Field int MINOR>
        REVISION = 3;
    //    4    8:iconst_3        
    //    5    9:putstatic       #29  <Field int REVISION>
        try
        {
            java.io.InputStream inR = (new Version()).getClass().getClassLoader().getResourceAsStream("weka/core/version.txt");
    //    6   12:new             #2   <Class Version>
    //    7   15:dup             
    //    8   16:invokespecial   #32  <Method void Version()>
    //    9   19:invokevirtual   #36  <Method Class Object.getClass()>
    //   10   22:invokevirtual   #42  <Method ClassLoader Class.getClassLoader()>
    //   11   25:ldc1            #13  <String "weka/core/version.txt">
    //   12   27:invokevirtual   #48  <Method java.io.InputStream ClassLoader.getResourceAsStream(String)>
    //   13   30:astore_0        
            LineNumberReader lnr = new LineNumberReader(new InputStreamReader(inR));
    //   14   31:new             #50  <Class LineNumberReader>
    //   15   34:dup             
    //   16   35:new             #52  <Class InputStreamReader>
    //   17   38:dup             
    //   18   39:aload_0         
    //   19   40:invokespecial   #55  <Method void InputStreamReader(java.io.InputStream)>
    //   20   43:invokespecial   #58  <Method void LineNumberReader(java.io.Reader)>
    //   21   46:astore_1        
            String line = lnr.readLine();
    //   22   47:aload_1         
    //   23   48:invokevirtual   #62  <Method String LineNumberReader.readLine()>
    //   24   51:astore_2        
            int maj[] = new int[1];
    //   25   52:iconst_1        
    //   26   53:newarray        int[]
    //   27   55:astore_3        
            int min[] = new int[1];
    //   28   56:iconst_1        
    //   29   57:newarray        int[]
    //   30   59:astore          4
            int rev[] = new int[1];
    //   31   61:iconst_1        
    //   32   62:newarray        int[]
    //   33   64:astore          5
            parseVersion(line, maj, min, rev);
    //   34   66:aload_2         
    //   35   67:aload_3         
    //   36   68:aload           4
    //   37   70:aload           5
    //   38   72:invokestatic    #66  <Method void parseVersion(String, int[], int[], int[])>
            MAJOR = maj[0];
    //   39   75:aload_3         
    //   40   76:iconst_0        
    //   41   77:iaload          
    //   42   78:putstatic       #25  <Field int MAJOR>
            MINOR = min[0];
    //   43   81:aload           4
    //   44   83:iconst_0        
    //   45   84:iaload          
    //   46   85:putstatic       #27  <Field int MINOR>
            REVISION = rev[0];
    //   47   88:aload           5
    //   48   90:iconst_0        
    //   49   91:iaload          
    //   50   92:putstatic       #29  <Field int REVISION>
            lnr.close();
    //   51   95:aload_1         
    //   52   96:invokevirtual   #69  <Method void LineNumberReader.close()>
        }
    //*  53   99:goto            132
        catch(Exception e)
    //*  54  102:astore_0        
        {
            System.err.println((new StringBuilder(String.valueOf(rm/core/Version.getName()))).append(": Unable to load version information!").toString());
    //   55  103:getstatic       #75  <Field PrintStream System.err>
    //   56  106:new             #77  <Class StringBuilder>
    //   57  109:dup             
    //   58  110:ldc1            #2   <Class Version>
    //   59  112:invokevirtual   #80  <Method String Class.getName()>
    //   60  115:invokestatic    #86  <Method String String.valueOf(Object)>
    //   61  118:invokespecial   #89  <Method void StringBuilder(String)>
    //   62  121:ldc1            #91  <String ": Unable to load version information!">
    //   63  123:invokevirtual   #95  <Method StringBuilder StringBuilder.append(String)>
    //   64  126:invokevirtual   #98  <Method String StringBuilder.toString()>
    //   65  129:invokevirtual   #103 <Method void PrintStream.println(String)>
        }
        VERSION = (new StringBuilder(String.valueOf(MAJOR))).append(".").append(MINOR).append(".").append(REVISION).toString();
    //   66  132:new             #77  <Class StringBuilder>
    //   67  135:dup             
    //   68  136:getstatic       #25  <Field int MAJOR>
    //   69  139:invokestatic    #106 <Method String String.valueOf(int)>
    //   70  142:invokespecial   #89  <Method void StringBuilder(String)>
    //   71  145:ldc1            #108 <String ".">
    //   72  147:invokevirtual   #95  <Method StringBuilder StringBuilder.append(String)>
    //   73  150:getstatic       #27  <Field int MINOR>
    //   74  153:invokevirtual   #111 <Method StringBuilder StringBuilder.append(int)>
    //   75  156:ldc1            #108 <String ".">
    //   76  158:invokevirtual   #95  <Method StringBuilder StringBuilder.append(String)>
    //   77  161:getstatic       #29  <Field int REVISION>
    //   78  164:invokevirtual   #111 <Method StringBuilder StringBuilder.append(int)>
    //   79  167:invokevirtual   #98  <Method String StringBuilder.toString()>
    //   80  170:putstatic       #113 <Field String VERSION>
    //*  81  173:return          
    }
}
