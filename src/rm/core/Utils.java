// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   Utils.java

package rm.core;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Properties;
import java.util.Random;

// Referenced classes of package rm.core:
//            FastVector, OptionHandler

public final class Utils
{

    public Utils()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #29  <Method void Object()>
    //    2    4:return          
    }

    public static Properties readProperties(String resourceName)
        throws Exception
    {
        Properties defaultProps = new Properties();
    //    0    0:new             #38  <Class Properties>
    //    1    3:dup             
    //    2    4:invokespecial   #39  <Method void Properties()>
    //    3    7:astore_1        
        try
        {
            defaultProps.load((new Utils()).getClass().getClassLoader().getResourceAsStream(resourceName));
    //    4    8:aload_1         
    //    5    9:new             #2   <Class Utils>
    //    6   12:dup             
    //    7   13:invokespecial   #40  <Method void Utils()>
    //    8   16:invokevirtual   #44  <Method Class Object.getClass()>
    //    9   19:invokevirtual   #50  <Method ClassLoader Class.getClassLoader()>
    //   10   22:aload_0         
    //   11   23:invokevirtual   #56  <Method java.io.InputStream ClassLoader.getResourceAsStream(String)>
    //   12   26:invokevirtual   #60  <Method void Properties.load(java.io.InputStream)>
        }
    //*  13   29:goto            41
        catch(Exception ex)
    //*  14   32:astore_2        
        {
            System.err.println("Warning, unable to load properties file from system resource (Utils.java)");
    //   15   33:getstatic       #66  <Field PrintStream System.err>
    //   16   36:ldc1            #68  <String "Warning, unable to load properties file from system resource (Utils.java)">
    //   17   38:invokevirtual   #74  <Method void PrintStream.println(String)>
        }
        int slInd = resourceName.lastIndexOf('/');
    //   18   41:aload_0         
    //   19   42:bipush          47
    //   20   44:invokevirtual   #80  <Method int String.lastIndexOf(int)>
    //   21   47:istore_2        
        if(slInd != -1)
    //*  22   48:iload_2         
    //*  23   49:iconst_m1       
    //*  24   50:icmpeq          61
            resourceName = resourceName.substring(slInd + 1);
    //   25   53:aload_0         
    //   26   54:iload_2         
    //   27   55:iconst_1        
    //   28   56:iadd            
    //   29   57:invokevirtual   #84  <Method String String.substring(int)>
    //   30   60:astore_0        
        Properties userProps = new Properties(defaultProps);
    //   31   61:new             #38  <Class Properties>
    //   32   64:dup             
    //   33   65:aload_1         
    //   34   66:invokespecial   #87  <Method void Properties(Properties)>
    //   35   69:astore_3        
        File propFile = new File((new StringBuilder(String.valueOf(System.getProperties().getProperty("user.home")))).append(File.separatorChar).append(resourceName).toString());
    //   36   70:new             #89  <Class File>
    //   37   73:dup             
    //   38   74:new             #91  <Class StringBuilder>
    //   39   77:dup             
    //   40   78:invokestatic    #95  <Method Properties System.getProperties()>
    //   41   81:ldc1            #97  <String "user.home">
    //   42   83:invokevirtual   #101 <Method String Properties.getProperty(String)>
    //   43   86:invokestatic    #105 <Method String String.valueOf(Object)>
    //   44   89:invokespecial   #107 <Method void StringBuilder(String)>
    //   45   92:getstatic       #111 <Field char File.separatorChar>
    //   46   95:invokevirtual   #115 <Method StringBuilder StringBuilder.append(char)>
    //   47   98:aload_0         
    //   48   99:invokevirtual   #118 <Method StringBuilder StringBuilder.append(String)>
    //   49  102:invokevirtual   #122 <Method String StringBuilder.toString()>
    //   50  105:invokespecial   #123 <Method void File(String)>
    //   51  108:astore          4
        if(propFile.exists())
    //*  52  110:aload           4
    //*  53  112:invokevirtual   #127 <Method boolean File.exists()>
    //*  54  115:ifeq            161
            try
            {
                userProps.load(new FileInputStream(propFile));
    //   55  118:aload_3         
    //   56  119:new             #129 <Class FileInputStream>
    //   57  122:dup             
    //   58  123:aload           4
    //   59  125:invokespecial   #132 <Method void FileInputStream(File)>
    //   60  128:invokevirtual   #60  <Method void Properties.load(java.io.InputStream)>
            }
    //*  61  131:goto            161
            catch(Exception ex)
    //*  62  134:astore          5
            {
                throw new Exception((new StringBuilder("Problem reading user properties: ")).append(propFile).toString());
    //   63  136:new             #36  <Class Exception>
    //   64  139:dup             
    //   65  140:new             #91  <Class StringBuilder>
    //   66  143:dup             
    //   67  144:ldc1            #134 <String "Problem reading user properties: ">
    //   68  146:invokespecial   #107 <Method void StringBuilder(String)>
    //   69  149:aload           4
    //   70  151:invokevirtual   #137 <Method StringBuilder StringBuilder.append(Object)>
    //   71  154:invokevirtual   #122 <Method String StringBuilder.toString()>
    //   72  157:invokespecial   #138 <Method void Exception(String)>
    //   73  160:athrow          
            }
        Properties localProps = new Properties(userProps);
    //   74  161:new             #38  <Class Properties>
    //   75  164:dup             
    //   76  165:aload_3         
    //   77  166:invokespecial   #87  <Method void Properties(Properties)>
    //   78  169:astore          5
        propFile = new File(resourceName);
    //   79  171:new             #89  <Class File>
    //   80  174:dup             
    //   81  175:aload_0         
    //   82  176:invokespecial   #123 <Method void File(String)>
    //   83  179:astore          4
        if(propFile.exists())
    //*  84  181:aload           4
    //*  85  183:invokevirtual   #127 <Method boolean File.exists()>
    //*  86  186:ifeq            233
            try
            {
                localProps.load(new FileInputStream(propFile));
    //   87  189:aload           5
    //   88  191:new             #129 <Class FileInputStream>
    //   89  194:dup             
    //   90  195:aload           4
    //   91  197:invokespecial   #132 <Method void FileInputStream(File)>
    //   92  200:invokevirtual   #60  <Method void Properties.load(java.io.InputStream)>
            }
    //*  93  203:goto            233
            catch(Exception ex)
    //*  94  206:astore          6
            {
                throw new Exception((new StringBuilder("Problem reading local properties: ")).append(propFile).toString());
    //   95  208:new             #36  <Class Exception>
    //   96  211:dup             
    //   97  212:new             #91  <Class StringBuilder>
    //   98  215:dup             
    //   99  216:ldc1            #140 <String "Problem reading local properties: ">
    //  100  218:invokespecial   #107 <Method void StringBuilder(String)>
    //  101  221:aload           4
    //  102  223:invokevirtual   #137 <Method StringBuilder StringBuilder.append(Object)>
    //  103  226:invokevirtual   #122 <Method String StringBuilder.toString()>
    //  104  229:invokespecial   #138 <Method void Exception(String)>
    //  105  232:athrow          
            }
        return localProps;
    //  106  233:aload           5
    //  107  235:areturn         
    }

    public static final double correlation(double y1[], double y2[], int n)
    {
        double av1 = 0.0D;
    //    0    0:dconst_0        
    //    1    1:dstore          4
        double av2 = 0.0D;
    //    2    3:dconst_0        
    //    3    4:dstore          6
        double y11 = 0.0D;
    //    4    6:dconst_0        
    //    5    7:dstore          8
        double y22 = 0.0D;
    //    6    9:dconst_0        
    //    7   10:dstore          10
        double y12 = 0.0D;
    //    8   12:dconst_0        
    //    9   13:dstore          12
        if(n <= 1)
    //*  10   15:iload_2         
    //*  11   16:iconst_1        
    //*  12   17:icmpgt          22
            return 1.0D;
    //   13   20:dconst_1        
    //   14   21:dreturn         
        for(int i = 0; i < n; i++)
    //*  15   22:iconst_0        
    //*  16   23:istore_3        
    //*  17   24:goto            46
        {
            av1 += y1[i];
    //   18   27:dload           4
    //   19   29:aload_0         
    //   20   30:iload_3         
    //   21   31:daload          
    //   22   32:dadd            
    //   23   33:dstore          4
            av2 += y2[i];
    //   24   35:dload           6
    //   25   37:aload_1         
    //   26   38:iload_3         
    //   27   39:daload          
    //   28   40:dadd            
    //   29   41:dstore          6
        }

    //   30   43:iinc            3  1
    //   31   46:iload_3         
    //   32   47:iload_2         
    //   33   48:icmplt          27
        av1 /= n;
    //   34   51:dload           4
    //   35   53:iload_2         
    //   36   54:i2d             
    //   37   55:ddiv            
    //   38   56:dstore          4
        av2 /= n;
    //   39   58:dload           6
    //   40   60:iload_2         
    //   41   61:i2d             
    //   42   62:ddiv            
    //   43   63:dstore          6
        for(int i = 0; i < n; i++)
    //*  44   65:iconst_0        
    //*  45   66:istore_3        
    //*  46   67:goto            127
        {
            y11 += (y1[i] - av1) * (y1[i] - av1);
    //   47   70:dload           8
    //   48   72:aload_0         
    //   49   73:iload_3         
    //   50   74:daload          
    //   51   75:dload           4
    //   52   77:dsub            
    //   53   78:aload_0         
    //   54   79:iload_3         
    //   55   80:daload          
    //   56   81:dload           4
    //   57   83:dsub            
    //   58   84:dmul            
    //   59   85:dadd            
    //   60   86:dstore          8
            y22 += (y2[i] - av2) * (y2[i] - av2);
    //   61   88:dload           10
    //   62   90:aload_1         
    //   63   91:iload_3         
    //   64   92:daload          
    //   65   93:dload           6
    //   66   95:dsub            
    //   67   96:aload_1         
    //   68   97:iload_3         
    //   69   98:daload          
    //   70   99:dload           6
    //   71  101:dsub            
    //   72  102:dmul            
    //   73  103:dadd            
    //   74  104:dstore          10
            y12 += (y1[i] - av1) * (y2[i] - av2);
    //   75  106:dload           12
    //   76  108:aload_0         
    //   77  109:iload_3         
    //   78  110:daload          
    //   79  111:dload           4
    //   80  113:dsub            
    //   81  114:aload_1         
    //   82  115:iload_3         
    //   83  116:daload          
    //   84  117:dload           6
    //   85  119:dsub            
    //   86  120:dmul            
    //   87  121:dadd            
    //   88  122:dstore          12
        }

    //   89  124:iinc            3  1
    //   90  127:iload_3         
    //   91  128:iload_2         
    //   92  129:icmplt          70
        double c;
        if(y11 * y22 == 0.0D)
    //*  93  132:dload           8
    //*  94  134:dload           10
    //*  95  136:dmul            
    //*  96  137:dconst_0        
    //*  97  138:dcmpl           
    //*  98  139:ifne            148
            c = 1.0D;
    //   99  142:dconst_1        
    //  100  143:dstore          14
        else
    //* 101  145:goto            164
            c = y12 / Math.sqrt(Math.abs(y11 * y22));
    //  102  148:dload           12
    //  103  150:dload           8
    //  104  152:dload           10
    //  105  154:dmul            
    //  106  155:invokestatic    #157 <Method double Math.abs(double)>
    //  107  158:invokestatic    #160 <Method double Math.sqrt(double)>
    //  108  161:ddiv            
    //  109  162:dstore          14
        return c;
    //  110  164:dload           14
    //  111  166:dreturn         
    }

    public static String removeSubstring(String inString, String substring)
    {
        StringBuffer result = new StringBuffer();
    //    0    0:new             #175 <Class StringBuffer>
    //    1    3:dup             
    //    2    4:invokespecial   #176 <Method void StringBuffer()>
    //    3    7:astore_2        
        int oldLoc = 0;
    //    4    8:iconst_0        
    //    5    9:istore_3        
        for(int loc = 0; (loc = inString.indexOf(substring, oldLoc)) != -1;)
    //*   6   10:iconst_0        
    //*   7   11:istore          4
    //*   8   13:goto            36
        {
            result.append(inString.substring(oldLoc, loc));
    //    9   16:aload_2         
    //   10   17:aload_0         
    //   11   18:iload_3         
    //   12   19:iload           4
    //   13   21:invokevirtual   #179 <Method String String.substring(int, int)>
    //   14   24:invokevirtual   #182 <Method StringBuffer StringBuffer.append(String)>
    //   15   27:pop             
            oldLoc = loc + substring.length();
    //   16   28:iload           4
    //   17   30:aload_1         
    //   18   31:invokevirtual   #186 <Method int String.length()>
    //   19   34:iadd            
    //   20   35:istore_3        
        }

    //   21   36:aload_0         
    //   22   37:aload_1         
    //   23   38:iload_3         
    //   24   39:invokevirtual   #190 <Method int String.indexOf(String, int)>
    //   25   42:dup             
    //   26   43:istore          4
    //   27   45:iconst_m1       
    //   28   46:icmpne          16
        result.append(inString.substring(oldLoc));
    //   29   49:aload_2         
    //   30   50:aload_0         
    //   31   51:iload_3         
    //   32   52:invokevirtual   #84  <Method String String.substring(int)>
    //   33   55:invokevirtual   #182 <Method StringBuffer StringBuffer.append(String)>
    //   34   58:pop             
        return result.toString();
    //   35   59:aload_2         
    //   36   60:invokevirtual   #191 <Method String StringBuffer.toString()>
    //   37   63:areturn         
    }

    public static String replaceSubstring(String inString, String subString, String replaceString)
    {
        StringBuffer result = new StringBuffer();
    //    0    0:new             #175 <Class StringBuffer>
    //    1    3:dup             
    //    2    4:invokespecial   #176 <Method void StringBuffer()>
    //    3    7:astore_3        
        int oldLoc = 0;
    //    4    8:iconst_0        
    //    5    9:istore          4
        for(int loc = 0; (loc = inString.indexOf(subString, oldLoc)) != -1;)
    //*   6   11:iconst_0        
    //*   7   12:istore          5
    //*   8   14:goto            45
        {
            result.append(inString.substring(oldLoc, loc));
    //    9   17:aload_3         
    //   10   18:aload_0         
    //   11   19:iload           4
    //   12   21:iload           5
    //   13   23:invokevirtual   #179 <Method String String.substring(int, int)>
    //   14   26:invokevirtual   #182 <Method StringBuffer StringBuffer.append(String)>
    //   15   29:pop             
            result.append(replaceString);
    //   16   30:aload_3         
    //   17   31:aload_2         
    //   18   32:invokevirtual   #182 <Method StringBuffer StringBuffer.append(String)>
    //   19   35:pop             
            oldLoc = loc + subString.length();
    //   20   36:iload           5
    //   21   38:aload_1         
    //   22   39:invokevirtual   #186 <Method int String.length()>
    //   23   42:iadd            
    //   24   43:istore          4
        }

    //   25   45:aload_0         
    //   26   46:aload_1         
    //   27   47:iload           4
    //   28   49:invokevirtual   #190 <Method int String.indexOf(String, int)>
    //   29   52:dup             
    //   30   53:istore          5
    //   31   55:iconst_m1       
    //   32   56:icmpne          17
        result.append(inString.substring(oldLoc));
    //   33   59:aload_3         
    //   34   60:aload_0         
    //   35   61:iload           4
    //   36   63:invokevirtual   #84  <Method String String.substring(int)>
    //   37   66:invokevirtual   #182 <Method StringBuffer StringBuffer.append(String)>
    //   38   69:pop             
        return result.toString();
    //   39   70:aload_3         
    //   40   71:invokevirtual   #191 <Method String StringBuffer.toString()>
    //   41   74:areturn         
    }

    public static String padLeft(String inString, int length)
    {
        return fixStringLength(inString, length, false);
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:iconst_0        
    //    3    3:invokestatic    #206 <Method String fixStringLength(String, int, boolean)>
    //    4    6:areturn         
    }

    public static String padRight(String inString, int length)
    {
        return fixStringLength(inString, length, true);
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:iconst_1        
    //    3    3:invokestatic    #206 <Method String fixStringLength(String, int, boolean)>
    //    4    6:areturn         
    }

    private static String fixStringLength(String inString, int length, boolean right)
    {
        if(inString.length() < length)
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #186 <Method int String.length()>
    //*   2    4:iload_1         
    //*   3    5:icmpge          42
    //*   4    8:goto            31
            for(; inString.length() < length; inString = right ? inString.concat(" ") : " ".concat(inString));
    //    5   11:iload_2         
    //    6   12:ifeq            24
    //    7   15:aload_0         
    //    8   16:ldc1            #209 <String " ">
    //    9   18:invokevirtual   #212 <Method String String.concat(String)>
    //   10   21:goto            30
    //   11   24:ldc1            #209 <String " ">
    //   12   26:aload_0         
    //   13   27:invokevirtual   #212 <Method String String.concat(String)>
    //   14   30:astore_0        
    //   15   31:aload_0         
    //   16   32:invokevirtual   #186 <Method int String.length()>
    //   17   35:iload_1         
    //   18   36:icmplt          11
        else
    //*  19   39:goto            57
        if(inString.length() > length)
    //*  20   42:aload_0         
    //*  21   43:invokevirtual   #186 <Method int String.length()>
    //*  22   46:iload_1         
    //*  23   47:icmple          57
            inString = inString.substring(0, length);
    //   24   50:aload_0         
    //   25   51:iconst_0        
    //   26   52:iload_1         
    //   27   53:invokevirtual   #179 <Method String String.substring(int, int)>
    //   28   56:astore_0        
        return inString;
    //   29   57:aload_0         
    //   30   58:areturn         
    }

    public static String doubleToString(double value, int afterDecimalPoint)
    {
        double temp = value * Math.pow(10D, afterDecimalPoint);
    //    0    0:dload_0         
    //    1    1:ldc2w           #217 <Double 10D>
    //    2    4:iload_2         
    //    3    5:i2d             
    //    4    6:invokestatic    #222 <Method double Math.pow(double, double)>
    //    5    9:dmul            
    //    6   10:dstore          4
        if(Math.abs(temp) < 9.2233720368547758E+018D)
    //*   7   12:dload           4
    //*   8   14:invokestatic    #157 <Method double Math.abs(double)>
    //*   9   17:ldc2w           #223 <Double 9.2233720368547758E+018D>
    //*  10   20:dcmpg           
    //*  11   21:ifge            278
        {
            long precisionValue = temp <= 0.0D ? -(long)(Math.abs(temp) + 0.5D) : (long)(temp + 0.5D);
    //   12   24:dload           4
    //   13   26:dconst_0        
    //   14   27:dcmpl           
    //   15   28:ifle            41
    //   16   31:dload           4
    //   17   33:ldc2w           #225 <Double 0.5D>
    //   18   36:dadd            
    //   19   37:d2l             
    //   20   38:goto            52
    //   21   41:dload           4
    //   22   43:invokestatic    #157 <Method double Math.abs(double)>
    //   23   46:ldc2w           #225 <Double 0.5D>
    //   24   49:dadd            
    //   25   50:d2l             
    //   26   51:lneg            
    //   27   52:lstore          7
            StringBuffer stringBuffer;
            if(precisionValue == 0L)
    //*  28   54:lload           7
    //*  29   56:lconst_0        
    //*  30   57:lcmp            
    //*  31   58:ifne            76
                stringBuffer = new StringBuffer(String.valueOf(0));
    //   32   61:new             #175 <Class StringBuffer>
    //   33   64:dup             
    //   34   65:iconst_0        
    //   35   66:invokestatic    #228 <Method String String.valueOf(int)>
    //   36   69:invokespecial   #229 <Method void StringBuffer(String)>
    //   37   72:astore_3        
            else
    //*  38   73:goto            89
                stringBuffer = new StringBuffer(String.valueOf(precisionValue));
    //   39   76:new             #175 <Class StringBuffer>
    //   40   79:dup             
    //   41   80:lload           7
    //   42   82:invokestatic    #232 <Method String String.valueOf(long)>
    //   43   85:invokespecial   #229 <Method void StringBuffer(String)>
    //   44   88:astore_3        
            if(afterDecimalPoint == 0)
    //*  45   89:iload_2         
    //*  46   90:ifne            98
                return stringBuffer.toString();
    //   47   93:aload_3         
    //   48   94:invokevirtual   #191 <Method String StringBuffer.toString()>
    //   49   97:areturn         
            int dotPosition;
            for(dotPosition = stringBuffer.length() - afterDecimalPoint; precisionValue < 0L && dotPosition < 1 || dotPosition < 0; dotPosition++)
    //*  50   98:aload_3         
    //*  51   99:invokevirtual   #233 <Method int StringBuffer.length()>
    //*  52  102:iload_2         
    //*  53  103:isub            
    //*  54  104:istore          6
    //*  55  106:goto            138
                if(precisionValue < 0L)
    //*  56  109:lload           7
    //*  57  111:lconst_0        
    //*  58  112:lcmp            
    //*  59  113:ifge            127
                    stringBuffer.insert(1, '0');
    //   60  116:aload_3         
    //   61  117:iconst_1        
    //   62  118:bipush          48
    //   63  120:invokevirtual   #237 <Method StringBuffer StringBuffer.insert(int, char)>
    //   64  123:pop             
                else
    //*  65  124:goto            135
                    stringBuffer.insert(0, '0');
    //   66  127:aload_3         
    //   67  128:iconst_0        
    //   68  129:bipush          48
    //   69  131:invokevirtual   #237 <Method StringBuffer StringBuffer.insert(int, char)>
    //   70  134:pop             

    //   71  135:iinc            6  1
    //   72  138:lload           7
    //   73  140:lconst_0        
    //   74  141:lcmp            
    //   75  142:ifge            151
    //   76  145:iload           6
    //   77  147:iconst_1        
    //   78  148:icmplt          109
    //   79  151:iload           6
    //   80  153:iflt            109
            stringBuffer.insert(dotPosition, '.');
    //   81  156:aload_3         
    //   82  157:iload           6
    //   83  159:bipush          46
    //   84  161:invokevirtual   #237 <Method StringBuffer StringBuffer.insert(int, char)>
    //   85  164:pop             
            if(precisionValue < 0L && stringBuffer.charAt(1) == '.')
    //*  86  165:lload           7
    //*  87  167:lconst_0        
    //*  88  168:lcmp            
    //*  89  169:ifge            193
    //*  90  172:aload_3         
    //*  91  173:iconst_1        
    //*  92  174:invokevirtual   #241 <Method char StringBuffer.charAt(int)>
    //*  93  177:bipush          46
    //*  94  179:icmpne          193
                stringBuffer.insert(1, '0');
    //   95  182:aload_3         
    //   96  183:iconst_1        
    //   97  184:bipush          48
    //   98  186:invokevirtual   #237 <Method StringBuffer StringBuffer.insert(int, char)>
    //   99  189:pop             
            else
    //* 100  190:goto            211
            if(stringBuffer.charAt(0) == '.')
    //* 101  193:aload_3         
    //* 102  194:iconst_0        
    //* 103  195:invokevirtual   #241 <Method char StringBuffer.charAt(int)>
    //* 104  198:bipush          46
    //* 105  200:icmpne          211
                stringBuffer.insert(0, '0');
    //  106  203:aload_3         
    //  107  204:iconst_0        
    //  108  205:bipush          48
    //  109  207:invokevirtual   #237 <Method StringBuffer StringBuffer.insert(int, char)>
    //  110  210:pop             
            int currentPos;
            for(currentPos = stringBuffer.length() - 1; currentPos > dotPosition && stringBuffer.charAt(currentPos) == '0'; stringBuffer.setCharAt(currentPos--, ' '));
    //  111  211:aload_3         
    //  112  212:invokevirtual   #233 <Method int StringBuffer.length()>
    //  113  215:iconst_1        
    //  114  216:isub            
    //  115  217:istore          9
    //  116  219:goto            233
    //  117  222:aload_3         
    //  118  223:iload           9
    //  119  225:iinc            9  -1
    //  120  228:bipush          32
    //  121  230:invokevirtual   #245 <Method void StringBuffer.setCharAt(int, char)>
    //  122  233:iload           9
    //  123  235:iload           6
    //  124  237:icmple          251
    //  125  240:aload_3         
    //  126  241:iload           9
    //  127  243:invokevirtual   #241 <Method char StringBuffer.charAt(int)>
    //  128  246:bipush          48
    //  129  248:icmpeq          222
            if(stringBuffer.charAt(currentPos) == '.')
    //* 130  251:aload_3         
    //* 131  252:iload           9
    //* 132  254:invokevirtual   #241 <Method char StringBuffer.charAt(int)>
    //* 133  257:bipush          46
    //* 134  259:icmpne          270
                stringBuffer.setCharAt(currentPos, ' ');
    //  135  262:aload_3         
    //  136  263:iload           9
    //  137  265:bipush          32
    //  138  267:invokevirtual   #245 <Method void StringBuffer.setCharAt(int, char)>
            return stringBuffer.toString().trim();
    //  139  270:aload_3         
    //  140  271:invokevirtual   #191 <Method String StringBuffer.toString()>
    //  141  274:invokevirtual   #248 <Method String String.trim()>
    //  142  277:areturn         
        } else
        {
            return new String((new StringBuilder()).append(value).toString());
    //  143  278:new             #76  <Class String>
    //  144  281:dup             
    //  145  282:new             #91  <Class StringBuilder>
    //  146  285:dup             
    //  147  286:invokespecial   #249 <Method void StringBuilder()>
    //  148  289:dload_0         
    //  149  290:invokevirtual   #252 <Method StringBuilder StringBuilder.append(double)>
    //  150  293:invokevirtual   #122 <Method String StringBuilder.toString()>
    //  151  296:invokespecial   #253 <Method void String(String)>
    //  152  299:areturn         
        }
    }

    public static String doubleToString(double value, int width, int afterDecimalPoint)
    {
        String tempString = doubleToString(value, afterDecimalPoint);
    //    0    0:dload_0         
    //    1    1:iload_3         
    //    2    2:invokestatic    #264 <Method String doubleToString(double, int)>
    //    3    5:astore          4
        if(afterDecimalPoint >= width || tempString.indexOf('E') != -1)
    //*   4    7:iload_3         
    //*   5    8:iload_2         
    //*   6    9:icmpge          23
    //*   7   12:aload           4
    //*   8   14:bipush          69
    //*   9   16:invokevirtual   #266 <Method int String.indexOf(int)>
    //*  10   19:iconst_m1       
    //*  11   20:icmpeq          26
            return tempString;
    //   12   23:aload           4
    //   13   25:areturn         
        char result[] = new char[width];
    //   14   26:iload_2         
    //   15   27:newarray        char[]
    //   16   29:astore          5
        for(int i = 0; i < result.length; i++)
    //*  17   31:iconst_0        
    //*  18   32:istore          7
    //*  19   34:goto            47
            result[i] = ' ';
    //   20   37:aload           5
    //   21   39:iload           7
    //   22   41:bipush          32
    //   23   43:castore         

    //   24   44:iinc            7  1
    //   25   47:iload           7
    //   26   49:aload           5
    //   27   51:arraylength     
    //   28   52:icmplt          37
        int dotPosition;
        if(afterDecimalPoint > 0)
    //*  29   55:iload_3         
    //*  30   56:ifle            97
        {
            dotPosition = tempString.indexOf('.');
    //   31   59:aload           4
    //   32   61:bipush          46
    //   33   63:invokevirtual   #266 <Method int String.indexOf(int)>
    //   34   66:istore          6
            if(dotPosition == -1)
    //*  35   68:iload           6
    //*  36   70:iconst_m1       
    //*  37   71:icmpne          84
                dotPosition = tempString.length();
    //   38   74:aload           4
    //   39   76:invokevirtual   #186 <Method int String.length()>
    //   40   79:istore          6
            else
    //*  41   81:goto            104
                result[width - afterDecimalPoint - 1] = '.';
    //   42   84:aload           5
    //   43   86:iload_2         
    //   44   87:iload_3         
    //   45   88:isub            
    //   46   89:iconst_1        
    //   47   90:isub            
    //   48   91:bipush          46
    //   49   93:castore         
        } else
    //*  50   94:goto            104
        {
            dotPosition = tempString.length();
    //   51   97:aload           4
    //   52   99:invokevirtual   #186 <Method int String.length()>
    //   53  102:istore          6
        }
        int offset = width - afterDecimalPoint - dotPosition;
    //   54  104:iload_2         
    //   55  105:iload_3         
    //   56  106:isub            
    //   57  107:iload           6
    //   58  109:isub            
    //   59  110:istore          7
        if(afterDecimalPoint > 0)
    //*  60  112:iload_3         
    //*  61  113:ifle            119
            offset--;
    //   62  116:iinc            7  -1
        if(offset < 0)
    //*  63  119:iload           7
    //*  64  121:ifge            127
            return tempString;
    //   65  124:aload           4
    //   66  126:areturn         
        for(int i = 0; i < dotPosition; i++)
    //*  67  127:iconst_0        
    //*  68  128:istore          8
    //*  69  130:goto            151
            result[offset + i] = tempString.charAt(i);
    //   70  133:aload           5
    //   71  135:iload           7
    //   72  137:iload           8
    //   73  139:iadd            
    //   74  140:aload           4
    //   75  142:iload           8
    //   76  144:invokevirtual   #267 <Method char String.charAt(int)>
    //   77  147:castore         

    //   78  148:iinc            8  1
    //   79  151:iload           8
    //   80  153:iload           6
    //   81  155:icmplt          133
        for(int i = dotPosition + 1; i < tempString.length(); i++)
    //*  82  158:iload           6
    //*  83  160:iconst_1        
    //*  84  161:iadd            
    //*  85  162:istore          8
    //*  86  164:goto            185
            result[offset + i] = tempString.charAt(i);
    //   87  167:aload           5
    //   88  169:iload           7
    //   89  171:iload           8
    //   90  173:iadd            
    //   91  174:aload           4
    //   92  176:iload           8
    //   93  178:invokevirtual   #267 <Method char String.charAt(int)>
    //   94  181:castore         

    //   95  182:iinc            8  1
    //   96  185:iload           8
    //   97  187:aload           4
    //   98  189:invokevirtual   #186 <Method int String.length()>
    //   99  192:icmplt          167
        return new String(result);
    //  100  195:new             #76  <Class String>
    //  101  198:dup             
    //  102  199:aload           5
    //  103  201:invokespecial   #270 <Method void String(char[])>
    //  104  204:areturn         
    }

    public static Class getArrayClass(Class c)
    {
        if(c.getComponentType().isArray())
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #279 <Method Class Class.getComponentType()>
    //*   2    4:invokevirtual   #282 <Method boolean Class.isArray()>
    //*   3    7:ifeq            18
            return getArrayClass(c.getComponentType());
    //    4   10:aload_0         
    //    5   11:invokevirtual   #279 <Method Class Class.getComponentType()>
    //    6   14:invokestatic    #284 <Method Class getArrayClass(Class)>
    //    7   17:areturn         
        else
            return c.getComponentType();
    //    8   18:aload_0         
    //    9   19:invokevirtual   #279 <Method Class Class.getComponentType()>
    //   10   22:areturn         
    }

    public static int getArrayDimensions(Class array)
    {
        if(array.getComponentType().isArray())
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #279 <Method Class Class.getComponentType()>
    //*   2    4:invokevirtual   #282 <Method boolean Class.isArray()>
    //*   3    7:ifeq            20
            return 1 + getArrayDimensions(array.getComponentType());
    //    4   10:iconst_1        
    //    5   11:aload_0         
    //    6   12:invokevirtual   #279 <Method Class Class.getComponentType()>
    //    7   15:invokestatic    #289 <Method int getArrayDimensions(Class)>
    //    8   18:iadd            
    //    9   19:ireturn         
        else
            return 1;
    //   10   20:iconst_1        
    //   11   21:ireturn         
    }

    public static int getArrayDimensions(Object array)
    {
        return getArrayDimensions(array.getClass());
    //    0    0:aload_0         
    //    1    1:invokevirtual   #44  <Method Class Object.getClass()>
    //    2    4:invokestatic    #289 <Method int getArrayDimensions(Class)>
    //    3    7:ireturn         
    }

    public static String arrayToString(Object array)
    {
        String result = "";
    //    0    0:ldc2            #295 <String "">
    //    1    3:astore_1        
        int dimensions = getArrayDimensions(array);
    //    2    4:aload_0         
    //    3    5:invokestatic    #297 <Method int getArrayDimensions(Object)>
    //    4    8:istore_2        
        if(dimensions == 0)
    //*   5    9:iload_2         
    //*   6   10:ifne            20
            result = "null";
    //    7   13:ldc2            #299 <String "null">
    //    8   16:astore_1        
        else
    //*   9   17:goto            206
        if(dimensions == 1)
    //*  10   20:iload_2         
    //*  11   21:iconst_1        
    //*  12   22:icmpne          127
        {
            for(int i = 0; i < Array.getLength(array); i++)
    //*  13   25:iconst_0        
    //*  14   26:istore_3        
    //*  15   27:goto            116
            {
                if(i > 0)
    //*  16   30:iload_3         
    //*  17   31:ifle            55
                    result = (new StringBuilder(String.valueOf(result))).append(",").toString();
    //   18   34:new             #91  <Class StringBuilder>
    //   19   37:dup             
    //   20   38:aload_1         
    //   21   39:invokestatic    #105 <Method String String.valueOf(Object)>
    //   22   42:invokespecial   #107 <Method void StringBuilder(String)>
    //   23   45:ldc2            #301 <String ",">
    //   24   48:invokevirtual   #118 <Method StringBuilder StringBuilder.append(String)>
    //   25   51:invokevirtual   #122 <Method String StringBuilder.toString()>
    //   26   54:astore_1        
                if(Array.get(array, i) == null)
    //*  27   55:aload_0         
    //*  28   56:iload_3         
    //*  29   57:invokestatic    #307 <Method Object Array.get(Object, int)>
    //*  30   60:ifnonnull       87
                    result = (new StringBuilder(String.valueOf(result))).append("null").toString();
    //   31   63:new             #91  <Class StringBuilder>
    //   32   66:dup             
    //   33   67:aload_1         
    //   34   68:invokestatic    #105 <Method String String.valueOf(Object)>
    //   35   71:invokespecial   #107 <Method void StringBuilder(String)>
    //   36   74:ldc2            #299 <String "null">
    //   37   77:invokevirtual   #118 <Method StringBuilder StringBuilder.append(String)>
    //   38   80:invokevirtual   #122 <Method String StringBuilder.toString()>
    //   39   83:astore_1        
                else
    //*  40   84:goto            113
                    result = (new StringBuilder(String.valueOf(result))).append(Array.get(array, i).toString()).toString();
    //   41   87:new             #91  <Class StringBuilder>
    //   42   90:dup             
    //   43   91:aload_1         
    //   44   92:invokestatic    #105 <Method String String.valueOf(Object)>
    //   45   95:invokespecial   #107 <Method void StringBuilder(String)>
    //   46   98:aload_0         
    //   47   99:iload_3         
    //   48  100:invokestatic    #307 <Method Object Array.get(Object, int)>
    //   49  103:invokevirtual   #308 <Method String Object.toString()>
    //   50  106:invokevirtual   #118 <Method StringBuilder StringBuilder.append(String)>
    //   51  109:invokevirtual   #122 <Method String StringBuilder.toString()>
    //   52  112:astore_1        
            }

    //   53  113:iinc            3  1
    //   54  116:iload_3         
    //   55  117:aload_0         
    //   56  118:invokestatic    #311 <Method int Array.getLength(Object)>
    //   57  121:icmplt          30
        } else
    //*  58  124:goto            206
        {
            for(int i = 0; i < Array.getLength(array); i++)
    //*  59  127:iconst_0        
    //*  60  128:istore_3        
    //*  61  129:goto            198
            {
                if(i > 0)
    //*  62  132:iload_3         
    //*  63  133:ifle            157
                    result = (new StringBuilder(String.valueOf(result))).append(",").toString();
    //   64  136:new             #91  <Class StringBuilder>
    //   65  139:dup             
    //   66  140:aload_1         
    //   67  141:invokestatic    #105 <Method String String.valueOf(Object)>
    //   68  144:invokespecial   #107 <Method void StringBuilder(String)>
    //   69  147:ldc2            #301 <String ",">
    //   70  150:invokevirtual   #118 <Method StringBuilder StringBuilder.append(String)>
    //   71  153:invokevirtual   #122 <Method String StringBuilder.toString()>
    //   72  156:astore_1        
                result = (new StringBuilder(String.valueOf(result))).append("[").append(arrayToString(Array.get(array, i))).append("]").toString();
    //   73  157:new             #91  <Class StringBuilder>
    //   74  160:dup             
    //   75  161:aload_1         
    //   76  162:invokestatic    #105 <Method String String.valueOf(Object)>
    //   77  165:invokespecial   #107 <Method void StringBuilder(String)>
    //   78  168:ldc2            #313 <String "[">
    //   79  171:invokevirtual   #118 <Method StringBuilder StringBuilder.append(String)>
    //   80  174:aload_0         
    //   81  175:iload_3         
    //   82  176:invokestatic    #307 <Method Object Array.get(Object, int)>
    //   83  179:invokestatic    #315 <Method String arrayToString(Object)>
    //   84  182:invokevirtual   #118 <Method StringBuilder StringBuilder.append(String)>
    //   85  185:ldc2            #317 <String "]">
    //   86  188:invokevirtual   #118 <Method StringBuilder StringBuilder.append(String)>
    //   87  191:invokevirtual   #122 <Method String StringBuilder.toString()>
    //   88  194:astore_1        
            }

    //   89  195:iinc            3  1
    //   90  198:iload_3         
    //   91  199:aload_0         
    //   92  200:invokestatic    #311 <Method int Array.getLength(Object)>
    //   93  203:icmplt          132
        }
        return result;
    //   94  206:aload_1         
    //   95  207:areturn         
    }

    public static boolean eq(double a, double b)
    {
        return a - b < SMALL && b - a < SMALL;
    //    0    0:dload_0         
    //    1    1:dload_2         
    //    2    2:dsub            
    //    3    3:getstatic       #24  <Field double SMALL>
    //    4    6:dcmpg           
    //    5    7:ifge            22
    //    6   10:dload_2         
    //    7   11:dload_0         
    //    8   12:dsub            
    //    9   13:getstatic       #24  <Field double SMALL>
    //   10   16:dcmpg           
    //   11   17:ifge            22
    //   12   20:iconst_1        
    //   13   21:ireturn         
    //   14   22:iconst_0        
    //   15   23:ireturn         
    }

    public static void checkForRemainingOptions(String options[])
        throws Exception
    {
        int illegalOptionsFound = 0;
    //    0    0:iconst_0        
    //    1    1:istore_1        
        StringBuffer text = new StringBuffer();
    //    2    2:new             #175 <Class StringBuffer>
    //    3    5:dup             
    //    4    6:invokespecial   #176 <Method void StringBuffer()>
    //    5    9:astore_2        
        if(options == null)
    //*   6   10:aload_0         
    //*   7   11:ifnonnull       15
            return;
    //    8   14:return          
        for(int i = 0; i < options.length; i++)
    //*   9   15:iconst_0        
    //*  10   16:istore_3        
    //*  11   17:goto            61
            if(options[i].length() > 0)
    //*  12   20:aload_0         
    //*  13   21:iload_3         
    //*  14   22:aaload          
    //*  15   23:invokevirtual   #186 <Method int String.length()>
    //*  16   26:ifle            58
            {
                illegalOptionsFound++;
    //   17   29:iinc            1  1
                text.append((new StringBuilder(String.valueOf(options[i]))).append(' ').toString());
    //   18   32:aload_2         
    //   19   33:new             #91  <Class StringBuilder>
    //   20   36:dup             
    //   21   37:aload_0         
    //   22   38:iload_3         
    //   23   39:aaload          
    //   24   40:invokestatic    #105 <Method String String.valueOf(Object)>
    //   25   43:invokespecial   #107 <Method void StringBuilder(String)>
    //   26   46:bipush          32
    //   27   48:invokevirtual   #115 <Method StringBuilder StringBuilder.append(char)>
    //   28   51:invokevirtual   #122 <Method String StringBuilder.toString()>
    //   29   54:invokevirtual   #182 <Method StringBuffer StringBuffer.append(String)>
    //   30   57:pop             
            }

    //   31   58:iinc            3  1
    //   32   61:iload_3         
    //   33   62:aload_0         
    //   34   63:arraylength     
    //   35   64:icmplt          20
        if(illegalOptionsFound > 0)
    //*  36   67:iload_1         
    //*  37   68:ifle            96
            throw new Exception((new StringBuilder("Illegal options: ")).append(text).toString());
    //   38   71:new             #36  <Class Exception>
    //   39   74:dup             
    //   40   75:new             #91  <Class StringBuilder>
    //   41   78:dup             
    //   42   79:ldc2            #326 <String "Illegal options: ">
    //   43   82:invokespecial   #107 <Method void StringBuilder(String)>
    //   44   85:aload_2         
    //   45   86:invokevirtual   #137 <Method StringBuilder StringBuilder.append(Object)>
    //   46   89:invokevirtual   #122 <Method String StringBuilder.toString()>
    //   47   92:invokespecial   #138 <Method void Exception(String)>
    //   48   95:athrow          
        else
            return;
    //   49   96:return          
    }

    public static boolean getFlag(char flag, String options[])
        throws Exception
    {
        return getFlag((new StringBuilder()).append(flag).toString(), options);
    //    0    0:new             #91  <Class StringBuilder>
    //    1    3:dup             
    //    2    4:invokespecial   #249 <Method void StringBuilder()>
    //    3    7:iload_0         
    //    4    8:invokevirtual   #115 <Method StringBuilder StringBuilder.append(char)>
    //    5   11:invokevirtual   #122 <Method String StringBuilder.toString()>
    //    6   14:aload_1         
    //    7   15:invokestatic    #335 <Method boolean getFlag(String, String[])>
    //    8   18:ireturn         
    }

    public static boolean getFlag(String flag, String options[])
        throws Exception
    {
        int pos = getOptionPos(flag, options);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokestatic    #340 <Method int getOptionPos(String, String[])>
    //    3    5:istore_2        
        if(pos > -1)
    //*   4    6:iload_2         
    //*   5    7:iconst_m1       
    //*   6    8:icmple          17
            options[pos] = "";
    //    7   11:aload_1         
    //    8   12:iload_2         
    //    9   13:ldc2            #295 <String "">
    //   10   16:aastore         
        return pos > -1;
    //   11   17:iload_2         
    //   12   18:iconst_m1       
    //   13   19:icmple          24
    //   14   22:iconst_1        
    //   15   23:ireturn         
    //   16   24:iconst_0        
    //   17   25:ireturn         
    }

    public static String getOption(char flag, String options[])
        throws Exception
    {
        return getOption((new StringBuilder()).append(flag).toString(), options);
    //    0    0:new             #91  <Class StringBuilder>
    //    1    3:dup             
    //    2    4:invokespecial   #249 <Method void StringBuilder()>
    //    3    7:iload_0         
    //    4    8:invokevirtual   #115 <Method StringBuilder StringBuilder.append(char)>
    //    5   11:invokevirtual   #122 <Method String StringBuilder.toString()>
    //    6   14:aload_1         
    //    7   15:invokestatic    #346 <Method String getOption(String, String[])>
    //    8   18:areturn         
    }

    public static String getOption(String flag, String options[])
        throws Exception
    {
        int i = getOptionPos(flag, options);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokestatic    #340 <Method int getOptionPos(String, String[])>
    //    3    5:istore_3        
        if(i > -1)
    //*   4    6:iload_3         
    //*   5    7:iconst_m1       
    //*   6    8:icmple          121
        {
            if(options[i].equals((new StringBuilder("-")).append(flag).toString()))
    //*   7   11:aload_1         
    //*   8   12:iload_3         
    //*   9   13:aaload          
    //*  10   14:new             #91  <Class StringBuilder>
    //*  11   17:dup             
    //*  12   18:ldc2            #348 <String "-">
    //*  13   21:invokespecial   #107 <Method void StringBuilder(String)>
    //*  14   24:aload_0         
    //*  15   25:invokevirtual   #118 <Method StringBuilder StringBuilder.append(String)>
    //*  16   28:invokevirtual   #122 <Method String StringBuilder.toString()>
    //*  17   31:invokevirtual   #352 <Method boolean String.equals(Object)>
    //*  18   34:ifeq            105
                if(i + 1 == options.length)
    //*  19   37:iload_3         
    //*  20   38:iconst_1        
    //*  21   39:iadd            
    //*  22   40:aload_1         
    //*  23   41:arraylength     
    //*  24   42:icmpne          76
                {
                    throw new Exception((new StringBuilder("No value given for -")).append(flag).append(" option.").toString());
    //   25   45:new             #36  <Class Exception>
    //   26   48:dup             
    //   27   49:new             #91  <Class StringBuilder>
    //   28   52:dup             
    //   29   53:ldc2            #354 <String "No value given for -">
    //   30   56:invokespecial   #107 <Method void StringBuilder(String)>
    //   31   59:aload_0         
    //   32   60:invokevirtual   #118 <Method StringBuilder StringBuilder.append(String)>
    //   33   63:ldc2            #356 <String " option.">
    //   34   66:invokevirtual   #118 <Method StringBuilder StringBuilder.append(String)>
    //   35   69:invokevirtual   #122 <Method String StringBuilder.toString()>
    //   36   72:invokespecial   #138 <Method void Exception(String)>
    //   37   75:athrow          
                } else
                {
                    options[i] = "";
    //   38   76:aload_1         
    //   39   77:iload_3         
    //   40   78:ldc2            #295 <String "">
    //   41   81:aastore         
                    String newString = new String(options[i + 1]);
    //   42   82:new             #76  <Class String>
    //   43   85:dup             
    //   44   86:aload_1         
    //   45   87:iload_3         
    //   46   88:iconst_1        
    //   47   89:iadd            
    //   48   90:aaload          
    //   49   91:invokespecial   #253 <Method void String(String)>
    //   50   94:astore_2        
                    options[i + 1] = "";
    //   51   95:aload_1         
    //   52   96:iload_3         
    //   53   97:iconst_1        
    //   54   98:iadd            
    //   55   99:ldc2            #295 <String "">
    //   56  102:aastore         
                    return newString;
    //   57  103:aload_2         
    //   58  104:areturn         
                }
            if(options[i].charAt(1) == '-')
    //*  59  105:aload_1         
    //*  60  106:iload_3         
    //*  61  107:aaload          
    //*  62  108:iconst_1        
    //*  63  109:invokevirtual   #267 <Method char String.charAt(int)>
    //*  64  112:bipush          45
    //*  65  114:icmpne          121
                return "";
    //   66  117:ldc2            #295 <String "">
    //   67  120:areturn         
        }
        return "";
    //   68  121:ldc2            #295 <String "">
    //   69  124:areturn         
    }

    public static int getOptionPos(char flag, String options[])
    {
        return getOptionPos((new StringBuilder()).append(flag).toString(), options);
    //    0    0:new             #91  <Class StringBuilder>
    //    1    3:dup             
    //    2    4:invokespecial   #249 <Method void StringBuilder()>
    //    3    7:iload_0         
    //    4    8:invokevirtual   #115 <Method StringBuilder StringBuilder.append(char)>
    //    5   11:invokevirtual   #122 <Method String StringBuilder.toString()>
    //    6   14:aload_1         
    //    7   15:invokestatic    #340 <Method int getOptionPos(String, String[])>
    //    8   18:ireturn         
    }

    public static int getOptionPos(String flag, String options[])
    {
        if(options == null)
    //*   0    0:aload_1         
    //*   1    1:ifnonnull       6
            return -1;
    //    2    4:iconst_m1       
    //    3    5:ireturn         
        for(int i = 0; i < options.length; i++)
    //*   4    6:iconst_0        
    //*   5    7:istore_2        
    //*   6    8:goto            88
            if(options[i].length() > 0 && options[i].charAt(0) == '-')
    //*   7   11:aload_1         
    //*   8   12:iload_2         
    //*   9   13:aaload          
    //*  10   14:invokevirtual   #186 <Method int String.length()>
    //*  11   17:ifle            85
    //*  12   20:aload_1         
    //*  13   21:iload_2         
    //*  14   22:aaload          
    //*  15   23:iconst_0        
    //*  16   24:invokevirtual   #267 <Method char String.charAt(int)>
    //*  17   27:bipush          45
    //*  18   29:icmpne          85
                try
                {
                    Double.valueOf(options[i]);
    //   19   32:aload_1         
    //   20   33:iload_2         
    //   21   34:aaload          
    //   22   35:invokestatic    #363 <Method Double Double.valueOf(String)>
    //   23   38:pop             
                }
    //*  24   39:goto            85
                catch(NumberFormatException e)
    //*  25   42:astore_3        
                {
                    if(options[i].equals((new StringBuilder("-")).append(flag).toString()))
    //*  26   43:aload_1         
    //*  27   44:iload_2         
    //*  28   45:aaload          
    //*  29   46:new             #91  <Class StringBuilder>
    //*  30   49:dup             
    //*  31   50:ldc2            #348 <String "-">
    //*  32   53:invokespecial   #107 <Method void StringBuilder(String)>
    //*  33   56:aload_0         
    //*  34   57:invokevirtual   #118 <Method StringBuilder StringBuilder.append(String)>
    //*  35   60:invokevirtual   #122 <Method String StringBuilder.toString()>
    //*  36   63:invokevirtual   #352 <Method boolean String.equals(Object)>
    //*  37   66:ifeq            71
                        return i;
    //   38   69:iload_2         
    //   39   70:ireturn         
                    if(options[i].charAt(1) == '-')
    //*  40   71:aload_1         
    //*  41   72:iload_2         
    //*  42   73:aaload          
    //*  43   74:iconst_1        
    //*  44   75:invokevirtual   #267 <Method char String.charAt(int)>
    //*  45   78:bipush          45
    //*  46   80:icmpne          85
                        return -1;
    //   47   83:iconst_m1       
    //   48   84:ireturn         
                }

    //   49   85:iinc            2  1
    //   50   88:iload_2         
    //   51   89:aload_1         
    //   52   90:arraylength     
    //   53   91:icmplt          11
        return -1;
    //   54   94:iconst_m1       
    //   55   95:ireturn         
    }

    public static String quote(String string)
    {
        boolean quote = false;
    //    0    0:iconst_0        
    //    1    1:istore_1        
        if(string.indexOf('\n') != -1 || string.indexOf('\r') != -1 || string.indexOf('\'') != -1 || string.indexOf('"') != -1 || string.indexOf('\\') != -1 || string.indexOf('\t') != -1 || string.indexOf('%') != -1)
    //*   2    2:aload_0         
    //*   3    3:bipush          10
    //*   4    5:invokevirtual   #266 <Method int String.indexOf(int)>
    //*   5    8:iconst_m1       
    //*   6    9:icmpne          72
    //*   7   12:aload_0         
    //*   8   13:bipush          13
    //*   9   15:invokevirtual   #266 <Method int String.indexOf(int)>
    //*  10   18:iconst_m1       
    //*  11   19:icmpne          72
    //*  12   22:aload_0         
    //*  13   23:bipush          39
    //*  14   25:invokevirtual   #266 <Method int String.indexOf(int)>
    //*  15   28:iconst_m1       
    //*  16   29:icmpne          72
    //*  17   32:aload_0         
    //*  18   33:bipush          34
    //*  19   35:invokevirtual   #266 <Method int String.indexOf(int)>
    //*  20   38:iconst_m1       
    //*  21   39:icmpne          72
    //*  22   42:aload_0         
    //*  23   43:bipush          92
    //*  24   45:invokevirtual   #266 <Method int String.indexOf(int)>
    //*  25   48:iconst_m1       
    //*  26   49:icmpne          72
    //*  27   52:aload_0         
    //*  28   53:bipush          9
    //*  29   55:invokevirtual   #266 <Method int String.indexOf(int)>
    //*  30   58:iconst_m1       
    //*  31   59:icmpne          72
    //*  32   62:aload_0         
    //*  33   63:bipush          37
    //*  34   65:invokevirtual   #266 <Method int String.indexOf(int)>
    //*  35   68:iconst_m1       
    //*  36   69:icmpeq          79
        {
            string = backQuoteChars(string);
    //   37   72:aload_0         
    //   38   73:invokestatic    #371 <Method String backQuoteChars(String)>
    //   39   76:astore_0        
            quote = true;
    //   40   77:iconst_1        
    //   41   78:istore_1        
        }
        if(quote || string.indexOf('{') != -1 || string.indexOf('}') != -1 || string.indexOf(',') != -1 || string.equals("?") || string.indexOf(' ') != -1 || string.equals(""))
    //*  42   79:iload_1         
    //*  43   80:ifne            143
    //*  44   83:aload_0         
    //*  45   84:bipush          123
    //*  46   86:invokevirtual   #266 <Method int String.indexOf(int)>
    //*  47   89:iconst_m1       
    //*  48   90:icmpne          143
    //*  49   93:aload_0         
    //*  50   94:bipush          125
    //*  51   96:invokevirtual   #266 <Method int String.indexOf(int)>
    //*  52   99:iconst_m1       
    //*  53  100:icmpne          143
    //*  54  103:aload_0         
    //*  55  104:bipush          44
    //*  56  106:invokevirtual   #266 <Method int String.indexOf(int)>
    //*  57  109:iconst_m1       
    //*  58  110:icmpne          143
    //*  59  113:aload_0         
    //*  60  114:ldc2            #373 <String "?">
    //*  61  117:invokevirtual   #352 <Method boolean String.equals(Object)>
    //*  62  120:ifne            143
    //*  63  123:aload_0         
    //*  64  124:bipush          32
    //*  65  126:invokevirtual   #266 <Method int String.indexOf(int)>
    //*  66  129:iconst_m1       
    //*  67  130:icmpne          143
    //*  68  133:aload_0         
    //*  69  134:ldc2            #295 <String "">
    //*  70  137:invokevirtual   #352 <Method boolean String.equals(Object)>
    //*  71  140:ifeq            157
            string = "'".concat(string).concat("'");
    //   72  143:ldc2            #375 <String "'">
    //   73  146:aload_0         
    //   74  147:invokevirtual   #212 <Method String String.concat(String)>
    //   75  150:ldc2            #375 <String "'">
    //   76  153:invokevirtual   #212 <Method String String.concat(String)>
    //   77  156:astore_0        
        return string;
    //   78  157:aload_0         
    //   79  158:areturn         
    }

    public static String unquote(String string)
    {
        if(string.startsWith("'") && string.endsWith("'"))
    //*   0    0:aload_0         
    //*   1    1:ldc2            #375 <String "'">
    //*   2    4:invokevirtual   #381 <Method boolean String.startsWith(String)>
    //*   3    7:ifeq            114
    //*   4   10:aload_0         
    //*   5   11:ldc2            #375 <String "'">
    //*   6   14:invokevirtual   #384 <Method boolean String.endsWith(String)>
    //*   7   17:ifeq            114
        {
            string = string.substring(1, string.length() - 1);
    //    8   20:aload_0         
    //    9   21:iconst_1        
    //   10   22:aload_0         
    //   11   23:invokevirtual   #186 <Method int String.length()>
    //   12   26:iconst_1        
    //   13   27:isub            
    //   14   28:invokevirtual   #179 <Method String String.substring(int, int)>
    //   15   31:astore_0        
            if(string.indexOf("\\n") != -1 || string.indexOf("\\r") != -1 || string.indexOf("\\'") != -1 || string.indexOf("\\\"") != -1 || string.indexOf("\\\\") != -1 || string.indexOf("\\t") != -1 || string.indexOf("\\%") != -1)
    //*  16   32:aload_0         
    //*  17   33:ldc2            #386 <String "\\n">
    //*  18   36:invokevirtual   #389 <Method int String.indexOf(String)>
    //*  19   39:iconst_m1       
    //*  20   40:icmpne          109
    //*  21   43:aload_0         
    //*  22   44:ldc2            #391 <String "\\r">
    //*  23   47:invokevirtual   #389 <Method int String.indexOf(String)>
    //*  24   50:iconst_m1       
    //*  25   51:icmpne          109
    //*  26   54:aload_0         
    //*  27   55:ldc2            #393 <String "\\'">
    //*  28   58:invokevirtual   #389 <Method int String.indexOf(String)>
    //*  29   61:iconst_m1       
    //*  30   62:icmpne          109
    //*  31   65:aload_0         
    //*  32   66:ldc2            #395 <String "\\\"">
    //*  33   69:invokevirtual   #389 <Method int String.indexOf(String)>
    //*  34   72:iconst_m1       
    //*  35   73:icmpne          109
    //*  36   76:aload_0         
    //*  37   77:ldc2            #397 <String "\\\\">
    //*  38   80:invokevirtual   #389 <Method int String.indexOf(String)>
    //*  39   83:iconst_m1       
    //*  40   84:icmpne          109
    //*  41   87:aload_0         
    //*  42   88:ldc2            #399 <String "\\t">
    //*  43   91:invokevirtual   #389 <Method int String.indexOf(String)>
    //*  44   94:iconst_m1       
    //*  45   95:icmpne          109
    //*  46   98:aload_0         
    //*  47   99:ldc2            #401 <String "\\%">
    //*  48  102:invokevirtual   #389 <Method int String.indexOf(String)>
    //*  49  105:iconst_m1       
    //*  50  106:icmpeq          114
                string = unbackQuoteChars(string);
    //   51  109:aload_0         
    //   52  110:invokestatic    #404 <Method String unbackQuoteChars(String)>
    //   53  113:astore_0        
        }
        return string;
    //   54  114:aload_0         
    //   55  115:areturn         
    }

    public static String backQuoteChars(String string)
    {
        char charsFind[] = {
            '\\', '\'', '\t', '\n', '\r', '"', '%'
        };
    //    0    0:bipush          7
    //    1    2:newarray        char[]
    //    2    4:dup             
    //    3    5:iconst_0        
    //    4    6:bipush          92
    //    5    8:castore         
    //    6    9:dup             
    //    7   10:iconst_1        
    //    8   11:bipush          39
    //    9   13:castore         
    //   10   14:dup             
    //   11   15:iconst_2        
    //   12   16:bipush          9
    //   13   18:castore         
    //   14   19:dup             
    //   15   20:iconst_3        
    //   16   21:bipush          10
    //   17   23:castore         
    //   18   24:dup             
    //   19   25:iconst_4        
    //   20   26:bipush          13
    //   21   28:castore         
    //   22   29:dup             
    //   23   30:iconst_5        
    //   24   31:bipush          34
    //   25   33:castore         
    //   26   34:dup             
    //   27   35:bipush          6
    //   28   37:bipush          37
    //   29   39:castore         
    //   30   40:astore_3        
        String charsReplace[] = {
            "\\\\", "\\'", "\\t", "\\n", "\\r", "\\\"", "\\%"
        };
    //   31   41:bipush          7
    //   32   43:anewarray       String[]
    //   33   46:dup             
    //   34   47:iconst_0        
    //   35   48:ldc2            #397 <String "\\\\">
    //   36   51:aastore         
    //   37   52:dup             
    //   38   53:iconst_1        
    //   39   54:ldc2            #393 <String "\\'">
    //   40   57:aastore         
    //   41   58:dup             
    //   42   59:iconst_2        
    //   43   60:ldc2            #399 <String "\\t">
    //   44   63:aastore         
    //   45   64:dup             
    //   46   65:iconst_3        
    //   47   66:ldc2            #386 <String "\\n">
    //   48   69:aastore         
    //   49   70:dup             
    //   50   71:iconst_4        
    //   51   72:ldc2            #391 <String "\\r">
    //   52   75:aastore         
    //   53   76:dup             
    //   54   77:iconst_5        
    //   55   78:ldc2            #395 <String "\\\"">
    //   56   81:aastore         
    //   57   82:dup             
    //   58   83:bipush          6
    //   59   85:ldc2            #401 <String "\\%">
    //   60   88:aastore         
    //   61   89:astore          4
        for(int i = 0; i < charsFind.length; i++)
    //*  62   91:iconst_0        
    //*  63   92:istore          5
    //*  64   94:goto            198
            if(string.indexOf(charsFind[i]) != -1)
    //*  65   97:aload_0         
    //*  66   98:aload_3         
    //*  67   99:iload           5
    //*  68  101:caload          
    //*  69  102:invokevirtual   #266 <Method int String.indexOf(int)>
    //*  70  105:iconst_m1       
    //*  71  106:icmpeq          195
            {
                StringBuffer newStringBuffer = new StringBuffer();
    //   72  109:new             #175 <Class StringBuffer>
    //   73  112:dup             
    //   74  113:invokespecial   #176 <Method void StringBuffer()>
    //   75  116:astore_2        
    //*  76  117:goto            170
                int index;
                while((index = string.indexOf(charsFind[i])) != -1) 
                {
                    if(index > 0)
    //*  77  120:iload_1         
    //*  78  121:ifle            135
                        newStringBuffer.append(string.substring(0, index));
    //   79  124:aload_2         
    //   80  125:aload_0         
    //   81  126:iconst_0        
    //   82  127:iload_1         
    //   83  128:invokevirtual   #179 <Method String String.substring(int, int)>
    //   84  131:invokevirtual   #182 <Method StringBuffer StringBuffer.append(String)>
    //   85  134:pop             
                    newStringBuffer.append(charsReplace[i]);
    //   86  135:aload_2         
    //   87  136:aload           4
    //   88  138:iload           5
    //   89  140:aaload          
    //   90  141:invokevirtual   #182 <Method StringBuffer StringBuffer.append(String)>
    //   91  144:pop             
                    if(index + 1 < string.length())
    //*  92  145:iload_1         
    //*  93  146:iconst_1        
    //*  94  147:iadd            
    //*  95  148:aload_0         
    //*  96  149:invokevirtual   #186 <Method int String.length()>
    //*  97  152:icmpge          166
                        string = string.substring(index + 1);
    //   98  155:aload_0         
    //   99  156:iload_1         
    //  100  157:iconst_1        
    //  101  158:iadd            
    //  102  159:invokevirtual   #84  <Method String String.substring(int)>
    //  103  162:astore_0        
                    else
    //* 104  163:goto            170
                        string = "";
    //  105  166:ldc2            #295 <String "">
    //  106  169:astore_0        
                }
    //  107  170:aload_0         
    //  108  171:aload_3         
    //  109  172:iload           5
    //  110  174:caload          
    //  111  175:invokevirtual   #266 <Method int String.indexOf(int)>
    //  112  178:dup             
    //  113  179:istore_1        
    //  114  180:iconst_m1       
    //  115  181:icmpne          120
                newStringBuffer.append(string);
    //  116  184:aload_2         
    //  117  185:aload_0         
    //  118  186:invokevirtual   #182 <Method StringBuffer StringBuffer.append(String)>
    //  119  189:pop             
                string = newStringBuffer.toString();
    //  120  190:aload_2         
    //  121  191:invokevirtual   #191 <Method String StringBuffer.toString()>
    //  122  194:astore_0        
            }

    //  123  195:iinc            5  1
    //  124  198:iload           5
    //  125  200:aload_3         
    //  126  201:arraylength     
    //  127  202:icmplt          97
        return string;
    //  128  205:aload_0         
    //  129  206:areturn         
    }

    public static String convertNewLines(String string)
    {
        StringBuffer newStringBuffer = new StringBuffer();
    //    0    0:new             #175 <Class StringBuffer>
    //    1    3:dup             
    //    2    4:invokespecial   #176 <Method void StringBuffer()>
    //    3    7:astore_2        
    //*   4    8:goto            65
        int index;
        while((index = string.indexOf('\n')) != -1) 
        {
            if(index > 0)
    //*   5   11:iload_1         
    //*   6   12:ifle            26
                newStringBuffer.append(string.substring(0, index));
    //    7   15:aload_2         
    //    8   16:aload_0         
    //    9   17:iconst_0        
    //   10   18:iload_1         
    //   11   19:invokevirtual   #179 <Method String String.substring(int, int)>
    //   12   22:invokevirtual   #182 <Method StringBuffer StringBuffer.append(String)>
    //   13   25:pop             
            newStringBuffer.append('\\');
    //   14   26:aload_2         
    //   15   27:bipush          92
    //   16   29:invokevirtual   #412 <Method StringBuffer StringBuffer.append(char)>
    //   17   32:pop             
            newStringBuffer.append('n');
    //   18   33:aload_2         
    //   19   34:bipush          110
    //   20   36:invokevirtual   #412 <Method StringBuffer StringBuffer.append(char)>
    //   21   39:pop             
            if(index + 1 < string.length())
    //*  22   40:iload_1         
    //*  23   41:iconst_1        
    //*  24   42:iadd            
    //*  25   43:aload_0         
    //*  26   44:invokevirtual   #186 <Method int String.length()>
    //*  27   47:icmpge          61
                string = string.substring(index + 1);
    //   28   50:aload_0         
    //   29   51:iload_1         
    //   30   52:iconst_1        
    //   31   53:iadd            
    //   32   54:invokevirtual   #84  <Method String String.substring(int)>
    //   33   57:astore_0        
            else
    //*  34   58:goto            65
                string = "";
    //   35   61:ldc2            #295 <String "">
    //   36   64:astore_0        
        }
    //   37   65:aload_0         
    //   38   66:bipush          10
    //   39   68:invokevirtual   #266 <Method int String.indexOf(int)>
    //   40   71:dup             
    //   41   72:istore_1        
    //   42   73:iconst_m1       
    //   43   74:icmpne          11
        newStringBuffer.append(string);
    //   44   77:aload_2         
    //   45   78:aload_0         
    //   46   79:invokevirtual   #182 <Method StringBuffer StringBuffer.append(String)>
    //   47   82:pop             
        string = newStringBuffer.toString();
    //   48   83:aload_2         
    //   49   84:invokevirtual   #191 <Method String StringBuffer.toString()>
    //   50   87:astore_0        
        newStringBuffer = new StringBuffer();
    //   51   88:new             #175 <Class StringBuffer>
    //   52   91:dup             
    //   53   92:invokespecial   #176 <Method void StringBuffer()>
    //   54   95:astore_2        
    //*  55   96:goto            153
        while((index = string.indexOf('\r')) != -1) 
        {
            if(index > 0)
    //*  56   99:iload_1         
    //*  57  100:ifle            114
                newStringBuffer.append(string.substring(0, index));
    //   58  103:aload_2         
    //   59  104:aload_0         
    //   60  105:iconst_0        
    //   61  106:iload_1         
    //   62  107:invokevirtual   #179 <Method String String.substring(int, int)>
    //   63  110:invokevirtual   #182 <Method StringBuffer StringBuffer.append(String)>
    //   64  113:pop             
            newStringBuffer.append('\\');
    //   65  114:aload_2         
    //   66  115:bipush          92
    //   67  117:invokevirtual   #412 <Method StringBuffer StringBuffer.append(char)>
    //   68  120:pop             
            newStringBuffer.append('r');
    //   69  121:aload_2         
    //   70  122:bipush          114
    //   71  124:invokevirtual   #412 <Method StringBuffer StringBuffer.append(char)>
    //   72  127:pop             
            if(index + 1 < string.length())
    //*  73  128:iload_1         
    //*  74  129:iconst_1        
    //*  75  130:iadd            
    //*  76  131:aload_0         
    //*  77  132:invokevirtual   #186 <Method int String.length()>
    //*  78  135:icmpge          149
                string = string.substring(index + 1);
    //   79  138:aload_0         
    //   80  139:iload_1         
    //   81  140:iconst_1        
    //   82  141:iadd            
    //   83  142:invokevirtual   #84  <Method String String.substring(int)>
    //   84  145:astore_0        
            else
    //*  85  146:goto            153
                string = "";
    //   86  149:ldc2            #295 <String "">
    //   87  152:astore_0        
        }
    //   88  153:aload_0         
    //   89  154:bipush          13
    //   90  156:invokevirtual   #266 <Method int String.indexOf(int)>
    //   91  159:dup             
    //   92  160:istore_1        
    //   93  161:iconst_m1       
    //   94  162:icmpne          99
        newStringBuffer.append(string);
    //   95  165:aload_2         
    //   96  166:aload_0         
    //   97  167:invokevirtual   #182 <Method StringBuffer StringBuffer.append(String)>
    //   98  170:pop             
        return newStringBuffer.toString();
    //   99  171:aload_2         
    //  100  172:invokevirtual   #191 <Method String StringBuffer.toString()>
    //  101  175:areturn         
    }

    public static String revertNewLines(String string)
    {
        StringBuffer newStringBuffer = new StringBuffer();
    //    0    0:new             #175 <Class StringBuffer>
    //    1    3:dup             
    //    2    4:invokespecial   #176 <Method void StringBuffer()>
    //    3    7:astore_2        
    //*   4    8:goto            58
        int index;
        while((index = string.indexOf("\\n")) != -1) 
        {
            if(index > 0)
    //*   5   11:iload_1         
    //*   6   12:ifle            26
                newStringBuffer.append(string.substring(0, index));
    //    7   15:aload_2         
    //    8   16:aload_0         
    //    9   17:iconst_0        
    //   10   18:iload_1         
    //   11   19:invokevirtual   #179 <Method String String.substring(int, int)>
    //   12   22:invokevirtual   #182 <Method StringBuffer StringBuffer.append(String)>
    //   13   25:pop             
            newStringBuffer.append('\n');
    //   14   26:aload_2         
    //   15   27:bipush          10
    //   16   29:invokevirtual   #412 <Method StringBuffer StringBuffer.append(char)>
    //   17   32:pop             
            if(index + 2 < string.length())
    //*  18   33:iload_1         
    //*  19   34:iconst_2        
    //*  20   35:iadd            
    //*  21   36:aload_0         
    //*  22   37:invokevirtual   #186 <Method int String.length()>
    //*  23   40:icmpge          54
                string = string.substring(index + 2);
    //   24   43:aload_0         
    //   25   44:iload_1         
    //   26   45:iconst_2        
    //   27   46:iadd            
    //   28   47:invokevirtual   #84  <Method String String.substring(int)>
    //   29   50:astore_0        
            else
    //*  30   51:goto            58
                string = "";
    //   31   54:ldc2            #295 <String "">
    //   32   57:astore_0        
        }
    //   33   58:aload_0         
    //   34   59:ldc2            #386 <String "\\n">
    //   35   62:invokevirtual   #389 <Method int String.indexOf(String)>
    //   36   65:dup             
    //   37   66:istore_1        
    //   38   67:iconst_m1       
    //   39   68:icmpne          11
        newStringBuffer.append(string);
    //   40   71:aload_2         
    //   41   72:aload_0         
    //   42   73:invokevirtual   #182 <Method StringBuffer StringBuffer.append(String)>
    //   43   76:pop             
        string = newStringBuffer.toString();
    //   44   77:aload_2         
    //   45   78:invokevirtual   #191 <Method String StringBuffer.toString()>
    //   46   81:astore_0        
        newStringBuffer = new StringBuffer();
    //   47   82:new             #175 <Class StringBuffer>
    //   48   85:dup             
    //   49   86:invokespecial   #176 <Method void StringBuffer()>
    //   50   89:astore_2        
    //*  51   90:goto            140
        while((index = string.indexOf("\\r")) != -1) 
        {
            if(index > 0)
    //*  52   93:iload_1         
    //*  53   94:ifle            108
                newStringBuffer.append(string.substring(0, index));
    //   54   97:aload_2         
    //   55   98:aload_0         
    //   56   99:iconst_0        
    //   57  100:iload_1         
    //   58  101:invokevirtual   #179 <Method String String.substring(int, int)>
    //   59  104:invokevirtual   #182 <Method StringBuffer StringBuffer.append(String)>
    //   60  107:pop             
            newStringBuffer.append('\r');
    //   61  108:aload_2         
    //   62  109:bipush          13
    //   63  111:invokevirtual   #412 <Method StringBuffer StringBuffer.append(char)>
    //   64  114:pop             
            if(index + 2 < string.length())
    //*  65  115:iload_1         
    //*  66  116:iconst_2        
    //*  67  117:iadd            
    //*  68  118:aload_0         
    //*  69  119:invokevirtual   #186 <Method int String.length()>
    //*  70  122:icmpge          136
                string = string.substring(index + 2);
    //   71  125:aload_0         
    //   72  126:iload_1         
    //   73  127:iconst_2        
    //   74  128:iadd            
    //   75  129:invokevirtual   #84  <Method String String.substring(int)>
    //   76  132:astore_0        
            else
    //*  77  133:goto            140
                string = "";
    //   78  136:ldc2            #295 <String "">
    //   79  139:astore_0        
        }
    //   80  140:aload_0         
    //   81  141:ldc2            #391 <String "\\r">
    //   82  144:invokevirtual   #389 <Method int String.indexOf(String)>
    //   83  147:dup             
    //   84  148:istore_1        
    //   85  149:iconst_m1       
    //   86  150:icmpne          93
        newStringBuffer.append(string);
    //   87  153:aload_2         
    //   88  154:aload_0         
    //   89  155:invokevirtual   #182 <Method StringBuffer StringBuffer.append(String)>
    //   90  158:pop             
        return newStringBuffer.toString();
    //   91  159:aload_2         
    //   92  160:invokevirtual   #191 <Method String StringBuffer.toString()>
    //   93  163:areturn         
    }

    public static String[] partitionOptions(String options[])
    {
        for(int i = 0; i < options.length; i++)
    //*   0    0:iconst_0        
    //*   1    1:istore_1        
    //*   2    2:goto            67
            if(options[i].equals("--"))
    //*   3    5:aload_0         
    //*   4    6:iload_1         
    //*   5    7:aaload          
    //*   6    8:ldc2            #417 <String "--">
    //*   7   11:invokevirtual   #352 <Method boolean String.equals(Object)>
    //*   8   14:ifeq            64
            {
                options[i++] = "";
    //    9   17:aload_0         
    //   10   18:iload_1         
    //   11   19:iinc            1  1
    //   12   22:ldc2            #295 <String "">
    //   13   25:aastore         
                String result[] = new String[options.length - i];
    //   14   26:aload_0         
    //   15   27:arraylength     
    //   16   28:iload_1         
    //   17   29:isub            
    //   18   30:anewarray       String[]
    //   19   33:astore_2        
                for(int j = i; j < options.length; j++)
    //*  20   34:iload_1         
    //*  21   35:istore_3        
    //*  22   36:goto            56
                {
                    result[j - i] = options[j];
    //   23   39:aload_2         
    //   24   40:iload_3         
    //   25   41:iload_1         
    //   26   42:isub            
    //   27   43:aload_0         
    //   28   44:iload_3         
    //   29   45:aaload          
    //   30   46:aastore         
                    options[j] = "";
    //   31   47:aload_0         
    //   32   48:iload_3         
    //   33   49:ldc2            #295 <String "">
    //   34   52:aastore         
                }

    //   35   53:iinc            3  1
    //   36   56:iload_3         
    //   37   57:aload_0         
    //   38   58:arraylength     
    //   39   59:icmplt          39
                return result;
    //   40   62:aload_2         
    //   41   63:areturn         
            }

    //   42   64:iinc            1  1
    //   43   67:iload_1         
    //   44   68:aload_0         
    //   45   69:arraylength     
    //   46   70:icmplt          5
        return new String[0];
    //   47   73:iconst_0        
    //   48   74:anewarray       String[]
    //   49   77:areturn         
    }

    public static String unbackQuoteChars(String string)
    {
        String charsFind[] = {
            "\\\\", "\\'", "\\t", "\\n", "\\r", "\\\"", "\\%"
        };
    //    0    0:bipush          7
    //    1    2:anewarray       String[]
    //    2    5:dup             
    //    3    6:iconst_0        
    //    4    7:ldc2            #397 <String "\\\\">
    //    5   10:aastore         
    //    6   11:dup             
    //    7   12:iconst_1        
    //    8   13:ldc2            #393 <String "\\'">
    //    9   16:aastore         
    //   10   17:dup             
    //   11   18:iconst_2        
    //   12   19:ldc2            #399 <String "\\t">
    //   13   22:aastore         
    //   14   23:dup             
    //   15   24:iconst_3        
    //   16   25:ldc2            #386 <String "\\n">
    //   17   28:aastore         
    //   18   29:dup             
    //   19   30:iconst_4        
    //   20   31:ldc2            #391 <String "\\r">
    //   21   34:aastore         
    //   22   35:dup             
    //   23   36:iconst_5        
    //   24   37:ldc2            #395 <String "\\\"">
    //   25   40:aastore         
    //   26   41:dup             
    //   27   42:bipush          6
    //   28   44:ldc2            #401 <String "\\%">
    //   29   47:aastore         
    //   30   48:astore_3        
        char charsReplace[] = {
            '\\', '\'', '\t', '\n', '\r', '"', '%'
        };
    //   31   49:bipush          7
    //   32   51:newarray        char[]
    //   33   53:dup             
    //   34   54:iconst_0        
    //   35   55:bipush          92
    //   36   57:castore         
    //   37   58:dup             
    //   38   59:iconst_1        
    //   39   60:bipush          39
    //   40   62:castore         
    //   41   63:dup             
    //   42   64:iconst_2        
    //   43   65:bipush          9
    //   44   67:castore         
    //   45   68:dup             
    //   46   69:iconst_3        
    //   47   70:bipush          10
    //   48   72:castore         
    //   49   73:dup             
    //   50   74:iconst_4        
    //   51   75:bipush          13
    //   52   77:castore         
    //   53   78:dup             
    //   54   79:iconst_5        
    //   55   80:bipush          34
    //   56   82:castore         
    //   57   83:dup             
    //   58   84:bipush          6
    //   59   86:bipush          37
    //   60   88:castore         
    //   61   89:astore          4
        int pos[] = new int[charsFind.length];
    //   62   91:aload_3         
    //   63   92:arraylength     
    //   64   93:newarray        int[]
    //   65   95:astore          5
        String str = new String(string);
    //   66   97:new             #76  <Class String>
    //   67  100:dup             
    //   68  101:aload_0         
    //   69  102:invokespecial   #253 <Method void String(String)>
    //   70  105:astore          7
        StringBuffer newStringBuffer = new StringBuffer();
    //   71  107:new             #175 <Class StringBuffer>
    //   72  110:dup             
    //   73  111:invokespecial   #176 <Method void StringBuffer()>
    //   74  114:astore_2        
    //*  75  115:goto            249
        while(str.length() > 0) 
        {
            int curPos = str.length();
    //   76  118:aload           7
    //   77  120:invokevirtual   #186 <Method int String.length()>
    //   78  123:istore          6
            int index = -1;
    //   79  125:iconst_m1       
    //   80  126:istore_1        
            for(int i = 0; i < pos.length; i++)
    //*  81  127:iconst_0        
    //*  82  128:istore          8
    //*  83  130:goto            179
            {
                pos[i] = str.indexOf(charsFind[i]);
    //   84  133:aload           5
    //   85  135:iload           8
    //   86  137:aload           7
    //   87  139:aload_3         
    //   88  140:iload           8
    //   89  142:aaload          
    //   90  143:invokevirtual   #389 <Method int String.indexOf(String)>
    //   91  146:iastore         
                if(pos[i] > -1 && pos[i] < curPos)
    //*  92  147:aload           5
    //*  93  149:iload           8
    //*  94  151:iaload          
    //*  95  152:iconst_m1       
    //*  96  153:icmple          176
    //*  97  156:aload           5
    //*  98  158:iload           8
    //*  99  160:iaload          
    //* 100  161:iload           6
    //* 101  163:icmpge          176
                {
                    index = i;
    //  102  166:iload           8
    //  103  168:istore_1        
                    curPos = pos[i];
    //  104  169:aload           5
    //  105  171:iload           8
    //  106  173:iaload          
    //  107  174:istore          6
                }
            }

    //  108  176:iinc            8  1
    //  109  179:iload           8
    //  110  181:aload           5
    //  111  183:arraylength     
    //  112  184:icmplt          133
            if(index == -1)
    //* 113  187:iload_1         
    //* 114  188:iconst_m1       
    //* 115  189:icmpne          207
            {
                newStringBuffer.append(str);
    //  116  192:aload_2         
    //  117  193:aload           7
    //  118  195:invokevirtual   #182 <Method StringBuffer StringBuffer.append(String)>
    //  119  198:pop             
                str = "";
    //  120  199:ldc2            #295 <String "">
    //  121  202:astore          7
            } else
    //* 122  204:goto            249
            {
                newStringBuffer.append(str.substring(0, pos[index]));
    //  123  207:aload_2         
    //  124  208:aload           7
    //  125  210:iconst_0        
    //  126  211:aload           5
    //  127  213:iload_1         
    //  128  214:iaload          
    //  129  215:invokevirtual   #179 <Method String String.substring(int, int)>
    //  130  218:invokevirtual   #182 <Method StringBuffer StringBuffer.append(String)>
    //  131  221:pop             
                newStringBuffer.append(charsReplace[index]);
    //  132  222:aload_2         
    //  133  223:aload           4
    //  134  225:iload_1         
    //  135  226:caload          
    //  136  227:invokevirtual   #412 <Method StringBuffer StringBuffer.append(char)>
    //  137  230:pop             
                str = str.substring(pos[index] + charsFind[index].length());
    //  138  231:aload           7
    //  139  233:aload           5
    //  140  235:iload_1         
    //  141  236:iaload          
    //  142  237:aload_3         
    //  143  238:iload_1         
    //  144  239:aaload          
    //  145  240:invokevirtual   #186 <Method int String.length()>
    //  146  243:iadd            
    //  147  244:invokevirtual   #84  <Method String String.substring(int)>
    //  148  247:astore          7
            }
        }
    //  149  249:aload           7
    //  150  251:invokevirtual   #186 <Method int String.length()>
    //  151  254:ifgt            118
        return newStringBuffer.toString();
    //  152  257:aload_2         
    //  153  258:invokevirtual   #191 <Method String StringBuffer.toString()>
    //  154  261:areturn         
    }

    public static String[] splitOptions(String quotedOptionString)
        throws Exception
    {
        FastVector optionsVec = new FastVector();
    //    0    0:new             #425 <Class FastVector>
    //    1    3:dup             
    //    2    4:invokespecial   #426 <Method void FastVector()>
    //    3    7:astore_1        
        String str = new String(quotedOptionString);
    //    4    8:new             #76  <Class String>
    //    5   11:dup             
    //    6   12:aload_0         
    //    7   13:invokespecial   #253 <Method void String(String)>
    //    8   16:astore_2        
        do
        {
            int i;
            for(i = 0; i < str.length() && Character.isWhitespace(str.charAt(i)); i++);
    //    9   17:iconst_0        
    //   10   18:istore_3        
    //   11   19:goto            25
    //   12   22:iinc            3  1
    //   13   25:iload_3         
    //   14   26:aload_2         
    //   15   27:invokevirtual   #186 <Method int String.length()>
    //   16   30:icmpge          44
    //   17   33:aload_2         
    //   18   34:iload_3         
    //   19   35:invokevirtual   #267 <Method char String.charAt(int)>
    //   20   38:invokestatic    #432 <Method boolean Character.isWhitespace(char)>
    //   21   41:ifne            22
            str = str.substring(i);
    //   22   44:aload_2         
    //   23   45:iload_3         
    //   24   46:invokevirtual   #84  <Method String String.substring(int)>
    //   25   49:astore_2        
            if(str.length() == 0)
    //*  26   50:aload_2         
    //*  27   51:invokevirtual   #186 <Method int String.length()>
    //*  28   54:ifne            60
                break;
    //   29   57:goto            235
            if(str.charAt(0) == '"')
    //*  30   60:aload_2         
    //*  31   61:iconst_0        
    //*  32   62:invokevirtual   #267 <Method char String.charAt(int)>
    //*  33   65:bipush          34
    //*  34   67:icmpne          185
            {
                for(i = 1; i < str.length(); i++)
    //*  35   70:iconst_1        
    //*  36   71:istore_3        
    //*  37   72:goto            126
                {
                    if(str.charAt(i) == str.charAt(0))
    //*  38   75:aload_2         
    //*  39   76:iload_3         
    //*  40   77:invokevirtual   #267 <Method char String.charAt(int)>
    //*  41   80:aload_2         
    //*  42   81:iconst_0        
    //*  43   82:invokevirtual   #267 <Method char String.charAt(int)>
    //*  44   85:icmpne          91
                        break;
    //   45   88:goto            134
                    if(str.charAt(i) == '\\' && ++i >= str.length())
    //*  46   91:aload_2         
    //*  47   92:iload_3         
    //*  48   93:invokevirtual   #267 <Method char String.charAt(int)>
    //*  49   96:bipush          92
    //*  50   98:icmpne          123
    //*  51  101:iinc            3  1
    //*  52  104:iload_3         
    //*  53  105:aload_2         
    //*  54  106:invokevirtual   #186 <Method int String.length()>
    //*  55  109:icmplt          123
                        throw new Exception("String should not finish with \\");
    //   56  112:new             #36  <Class Exception>
    //   57  115:dup             
    //   58  116:ldc2            #434 <String "String should not finish with \\">
    //   59  119:invokespecial   #138 <Method void Exception(String)>
    //   60  122:athrow          
                }

    //   61  123:iinc            3  1
    //   62  126:iload_3         
    //   63  127:aload_2         
    //   64  128:invokevirtual   #186 <Method int String.length()>
    //   65  131:icmplt          75
                if(i >= str.length())
    //*  66  134:iload_3         
    //*  67  135:aload_2         
    //*  68  136:invokevirtual   #186 <Method int String.length()>
    //*  69  139:icmplt          153
                    throw new Exception("Quote parse error.");
    //   70  142:new             #36  <Class Exception>
    //   71  145:dup             
    //   72  146:ldc2            #436 <String "Quote parse error.">
    //   73  149:invokespecial   #138 <Method void Exception(String)>
    //   74  152:athrow          
                String optStr = str.substring(1, i);
    //   75  153:aload_2         
    //   76  154:iconst_1        
    //   77  155:iload_3         
    //   78  156:invokevirtual   #179 <Method String String.substring(int, int)>
    //   79  159:astore          4
                optStr = unbackQuoteChars(optStr);
    //   80  161:aload           4
    //   81  163:invokestatic    #404 <Method String unbackQuoteChars(String)>
    //   82  166:astore          4
                optionsVec.addElement(optStr);
    //   83  168:aload_1         
    //   84  169:aload           4
    //   85  171:invokevirtual   #440 <Method void FastVector.addElement(Object)>
                str = str.substring(i + 1);
    //   86  174:aload_2         
    //   87  175:iload_3         
    //   88  176:iconst_1        
    //   89  177:iadd            
    //   90  178:invokevirtual   #84  <Method String String.substring(int)>
    //   91  181:astore_2        
            } else
    //*  92  182:goto            232
            {
                for(i = 0; i < str.length() && !Character.isWhitespace(str.charAt(i)); i++);
    //   93  185:iconst_0        
    //   94  186:istore_3        
    //   95  187:goto            193
    //   96  190:iinc            3  1
    //   97  193:iload_3         
    //   98  194:aload_2         
    //   99  195:invokevirtual   #186 <Method int String.length()>
    //  100  198:icmpge          212
    //  101  201:aload_2         
    //  102  202:iload_3         
    //  103  203:invokevirtual   #267 <Method char String.charAt(int)>
    //  104  206:invokestatic    #432 <Method boolean Character.isWhitespace(char)>
    //  105  209:ifeq            190
                String optStr = str.substring(0, i);
    //  106  212:aload_2         
    //  107  213:iconst_0        
    //  108  214:iload_3         
    //  109  215:invokevirtual   #179 <Method String String.substring(int, int)>
    //  110  218:astore          4
                optionsVec.addElement(optStr);
    //  111  220:aload_1         
    //  112  221:aload           4
    //  113  223:invokevirtual   #440 <Method void FastVector.addElement(Object)>
                str = str.substring(i);
    //  114  226:aload_2         
    //  115  227:iload_3         
    //  116  228:invokevirtual   #84  <Method String String.substring(int)>
    //  117  231:astore_2        
            }
        } while(true);
    //  118  232:goto            17
        String options[] = new String[optionsVec.size()];
    //  119  235:aload_1         
    //  120  236:invokevirtual   #443 <Method int FastVector.size()>
    //  121  239:anewarray       String[]
    //  122  242:astore          4
        for(int i = 0; i < optionsVec.size(); i++)
    //* 123  244:iconst_0        
    //* 124  245:istore_3        
    //* 125  246:goto            264
            options[i] = (String)optionsVec.elementAt(i);
    //  126  249:aload           4
    //  127  251:iload_3         
    //  128  252:aload_1         
    //  129  253:iload_3         
    //  130  254:invokevirtual   #447 <Method Object FastVector.elementAt(int)>
    //  131  257:checkcast       #76  <Class String>
    //  132  260:aastore         

    //  133  261:iinc            3  1
    //  134  264:iload_3         
    //  135  265:aload_1         
    //  136  266:invokevirtual   #443 <Method int FastVector.size()>
    //  137  269:icmplt          249
        return options;
    //  138  272:aload           4
    //  139  274:areturn         
    }

    public static String joinOptions(String optionArray[])
    {
        String optionString = "";
    //    0    0:ldc2            #295 <String "">
    //    1    3:astore_1        
        for(int i = 0; i < optionArray.length; i++)
    //*   2    4:iconst_0        
    //*   3    5:istore_2        
    //*   4    6:goto            150
            if(!optionArray[i].equals(""))
    //*   5    9:aload_0         
    //*   6   10:iload_2         
    //*   7   11:aaload          
    //*   8   12:ldc2            #295 <String "">
    //*   9   15:invokevirtual   #352 <Method boolean String.equals(Object)>
    //*  10   18:ifeq            24
    //*  11   21:goto            147
            {
                boolean escape = false;
    //   12   24:iconst_0        
    //   13   25:istore_3        
                for(int n = 0; n < optionArray[i].length(); n++)
    //*  14   26:iconst_0        
    //*  15   27:istore          4
    //*  16   29:goto            54
                {
                    if(!Character.isWhitespace(optionArray[i].charAt(n)))
                        continue;
    //   17   32:aload_0         
    //   18   33:iload_2         
    //   19   34:aaload          
    //   20   35:iload           4
    //   21   37:invokevirtual   #267 <Method char String.charAt(int)>
    //   22   40:invokestatic    #432 <Method boolean Character.isWhitespace(char)>
    //   23   43:ifeq            51
                    escape = true;
    //   24   46:iconst_1        
    //   25   47:istore_3        
                    break;
    //   26   48:goto            65
                }

    //   27   51:iinc            4  1
    //   28   54:iload           4
    //   29   56:aload_0         
    //   30   57:iload_2         
    //   31   58:aaload          
    //   32   59:invokevirtual   #186 <Method int String.length()>
    //   33   62:icmplt          32
                if(escape)
    //*  34   65:iload_3         
    //*  35   66:ifeq            106
                    optionString = (new StringBuilder(String.valueOf(optionString))).append('"').append(backQuoteChars(optionArray[i])).append('"').toString();
    //   36   69:new             #91  <Class StringBuilder>
    //   37   72:dup             
    //   38   73:aload_1         
    //   39   74:invokestatic    #105 <Method String String.valueOf(Object)>
    //   40   77:invokespecial   #107 <Method void StringBuilder(String)>
    //   41   80:bipush          34
    //   42   82:invokevirtual   #115 <Method StringBuilder StringBuilder.append(char)>
    //   43   85:aload_0         
    //   44   86:iload_2         
    //   45   87:aaload          
    //   46   88:invokestatic    #371 <Method String backQuoteChars(String)>
    //   47   91:invokevirtual   #118 <Method StringBuilder StringBuilder.append(String)>
    //   48   94:bipush          34
    //   49   96:invokevirtual   #115 <Method StringBuilder StringBuilder.append(char)>
    //   50   99:invokevirtual   #122 <Method String StringBuilder.toString()>
    //   51  102:astore_1        
                else
    //*  52  103:goto            127
                    optionString = (new StringBuilder(String.valueOf(optionString))).append(optionArray[i]).toString();
    //   53  106:new             #91  <Class StringBuilder>
    //   54  109:dup             
    //   55  110:aload_1         
    //   56  111:invokestatic    #105 <Method String String.valueOf(Object)>
    //   57  114:invokespecial   #107 <Method void StringBuilder(String)>
    //   58  117:aload_0         
    //   59  118:iload_2         
    //   60  119:aaload          
    //   61  120:invokevirtual   #118 <Method StringBuilder StringBuilder.append(String)>
    //   62  123:invokevirtual   #122 <Method String StringBuilder.toString()>
    //   63  126:astore_1        
                optionString = (new StringBuilder(String.valueOf(optionString))).append(" ").toString();
    //   64  127:new             #91  <Class StringBuilder>
    //   65  130:dup             
    //   66  131:aload_1         
    //   67  132:invokestatic    #105 <Method String String.valueOf(Object)>
    //   68  135:invokespecial   #107 <Method void StringBuilder(String)>
    //   69  138:ldc1            #209 <String " ">
    //   70  140:invokevirtual   #118 <Method StringBuilder StringBuilder.append(String)>
    //   71  143:invokevirtual   #122 <Method String StringBuilder.toString()>
    //   72  146:astore_1        
            }

    //   73  147:iinc            2  1
    //   74  150:iload_2         
    //   75  151:aload_0         
    //   76  152:arraylength     
    //   77  153:icmplt          9
        return optionString.trim();
    //   78  156:aload_1         
    //   79  157:invokevirtual   #248 <Method String String.trim()>
    //   80  160:areturn         
    }

    public static Object forName(Class classType, String className, String options[])
        throws Exception
    {
        Class c = null;
    //    0    0:aconst_null     
    //    1    1:astore_3        
        try
        {
            c = Class.forName(className);
    //    2    2:aload_1         
    //    3    3:invokestatic    #461 <Method Class Class.forName(String)>
    //    4    6:astore_3        
        }
    //*   5    7:goto            37
        catch(Exception ex)
    //*   6   10:astore          4
        {
            throw new Exception((new StringBuilder("Can't find class called: ")).append(className).toString());
    //    7   12:new             #36  <Class Exception>
    //    8   15:dup             
    //    9   16:new             #91  <Class StringBuilder>
    //   10   19:dup             
    //   11   20:ldc2            #463 <String "Can't find class called: ">
    //   12   23:invokespecial   #107 <Method void StringBuilder(String)>
    //   13   26:aload_1         
    //   14   27:invokevirtual   #118 <Method StringBuilder StringBuilder.append(String)>
    //   15   30:invokevirtual   #122 <Method String StringBuilder.toString()>
    //   16   33:invokespecial   #138 <Method void Exception(String)>
    //   17   36:athrow          
        }
        if(!classType.isAssignableFrom(c))
    //*  18   37:aload_0         
    //*  19   38:aload_3         
    //*  20   39:invokevirtual   #467 <Method boolean Class.isAssignableFrom(Class)>
    //*  21   42:ifne            80
            throw new Exception((new StringBuilder(String.valueOf(classType.getName()))).append(" is not assignable from ").append(className).toString());
    //   22   45:new             #36  <Class Exception>
    //   23   48:dup             
    //   24   49:new             #91  <Class StringBuilder>
    //   25   52:dup             
    //   26   53:aload_0         
    //   27   54:invokevirtual   #470 <Method String Class.getName()>
    //   28   57:invokestatic    #105 <Method String String.valueOf(Object)>
    //   29   60:invokespecial   #107 <Method void StringBuilder(String)>
    //   30   63:ldc2            #472 <String " is not assignable from ">
    //   31   66:invokevirtual   #118 <Method StringBuilder StringBuilder.append(String)>
    //   32   69:aload_1         
    //   33   70:invokevirtual   #118 <Method StringBuilder StringBuilder.append(String)>
    //   34   73:invokevirtual   #122 <Method String StringBuilder.toString()>
    //   35   76:invokespecial   #138 <Method void Exception(String)>
    //   36   79:athrow          
        Object o = c.newInstance();
    //   37   80:aload_3         
    //   38   81:invokevirtual   #476 <Method Object Class.newInstance()>
    //   39   84:astore          4
        if((o instanceof OptionHandler) && options != null)
    //*  40   86:aload           4
    //*  41   88:instanceof      #478 <Class OptionHandler>
    //*  42   91:ifeq            113
    //*  43   94:aload_2         
    //*  44   95:ifnull          113
        {
            ((OptionHandler)o).setOptions(options);
    //   45   98:aload           4
    //   46  100:checkcast       #478 <Class OptionHandler>
    //   47  103:aload_2         
    //   48  104:invokeinterface #481 <Method void OptionHandler.setOptions(String[])>
            checkForRemainingOptions(options);
    //   49  109:aload_2         
    //   50  110:invokestatic    #483 <Method void checkForRemainingOptions(String[])>
        }
        return o;
    //   51  113:aload           4
    //   52  115:areturn         
    }

    public static double info(int counts[])
    {
        int total = 0;
    //    0    0:iconst_0        
    //    1    1:istore_1        
        double x = 0.0D;
    //    2    2:dconst_0        
    //    3    3:dstore_2        
        for(int j = 0; j < counts.length; j++)
    //*   4    4:iconst_0        
    //*   5    5:istore          4
    //*   6    7:goto            30
        {
            x -= xlogx(counts[j]);
    //    7   10:dload_2         
    //    8   11:aload_0         
    //    9   12:iload           4
    //   10   14:iaload          
    //   11   15:invokestatic    #492 <Method double xlogx(int)>
    //   12   18:dsub            
    //   13   19:dstore_2        
            total += counts[j];
    //   14   20:iload_1         
    //   15   21:aload_0         
    //   16   22:iload           4
    //   17   24:iaload          
    //   18   25:iadd            
    //   19   26:istore_1        
        }

    //   20   27:iinc            4  1
    //   21   30:iload           4
    //   22   32:aload_0         
    //   23   33:arraylength     
    //   24   34:icmplt          10
        return x + xlogx(total);
    //   25   37:dload_2         
    //   26   38:iload_1         
    //   27   39:invokestatic    #492 <Method double xlogx(int)>
    //   28   42:dadd            
    //   29   43:dreturn         
    }

    public static boolean smOrEq(double a, double b)
    {
        return a - b < SMALL;
    //    0    0:dload_0         
    //    1    1:dload_2         
    //    2    2:dsub            
    //    3    3:getstatic       #24  <Field double SMALL>
    //    4    6:dcmpg           
    //    5    7:ifge            12
    //    6   10:iconst_1        
    //    7   11:ireturn         
    //    8   12:iconst_0        
    //    9   13:ireturn         
    }

    public static boolean grOrEq(double a, double b)
    {
        return b - a < SMALL;
    //    0    0:dload_2         
    //    1    1:dload_0         
    //    2    2:dsub            
    //    3    3:getstatic       #24  <Field double SMALL>
    //    4    6:dcmpg           
    //    5    7:ifge            12
    //    6   10:iconst_1        
    //    7   11:ireturn         
    //    8   12:iconst_0        
    //    9   13:ireturn         
    }

    public static boolean sm(double a, double b)
    {
        return b - a > SMALL;
    //    0    0:dload_2         
    //    1    1:dload_0         
    //    2    2:dsub            
    //    3    3:getstatic       #24  <Field double SMALL>
    //    4    6:dcmpl           
    //    5    7:ifle            12
    //    6   10:iconst_1        
    //    7   11:ireturn         
    //    8   12:iconst_0        
    //    9   13:ireturn         
    }

    public static boolean gr(double a, double b)
    {
        return a - b > SMALL;
    //    0    0:dload_0         
    //    1    1:dload_2         
    //    2    2:dsub            
    //    3    3:getstatic       #24  <Field double SMALL>
    //    4    6:dcmpl           
    //    5    7:ifle            12
    //    6   10:iconst_1        
    //    7   11:ireturn         
    //    8   12:iconst_0        
    //    9   13:ireturn         
    }

    public static double kthSmallestValue(int array[], int k)
    {
        int index[] = new int[array.length];
    //    0    0:aload_0         
    //    1    1:arraylength     
    //    2    2:newarray        int[]
    //    3    4:astore_2        
        for(int i = 0; i < index.length; i++)
    //*   4    5:iconst_0        
    //*   5    6:istore_3        
    //*   6    7:goto            17
            index[i] = i;
    //    7   10:aload_2         
    //    8   11:iload_3         
    //    9   12:iload_3         
    //   10   13:iastore         

    //   11   14:iinc            3  1
    //   12   17:iload_3         
    //   13   18:aload_2         
    //   14   19:arraylength     
    //   15   20:icmplt          10
        return (double)array[index[select(array, index, 0, array.length - 1, k)]];
    //   16   23:aload_0         
    //   17   24:aload_2         
    //   18   25:aload_0         
    //   19   26:aload_2         
    //   20   27:iconst_0        
    //   21   28:aload_0         
    //   22   29:arraylength     
    //   23   30:iconst_1        
    //   24   31:isub            
    //   25   32:iload_1         
    //   26   33:invokestatic    #505 <Method int select(int[], int[], int, int, int)>
    //   27   36:iaload          
    //   28   37:iaload          
    //   29   38:i2d             
    //   30   39:dreturn         
    }

    public static double kthSmallestValue(double array[], int k)
    {
        int index[] = new int[array.length];
    //    0    0:aload_0         
    //    1    1:arraylength     
    //    2    2:newarray        int[]
    //    3    4:astore_2        
        for(int i = 0; i < index.length; i++)
    //*   4    5:iconst_0        
    //*   5    6:istore_3        
    //*   6    7:goto            17
            index[i] = i;
    //    7   10:aload_2         
    //    8   11:iload_3         
    //    9   12:iload_3         
    //   10   13:iastore         

    //   11   14:iinc            3  1
    //   12   17:iload_3         
    //   13   18:aload_2         
    //   14   19:arraylength     
    //   15   20:icmplt          10
        return array[index[select(array, index, 0, array.length - 1, k)]];
    //   16   23:aload_0         
    //   17   24:aload_2         
    //   18   25:aload_0         
    //   19   26:aload_2         
    //   20   27:iconst_0        
    //   21   28:aload_0         
    //   22   29:arraylength     
    //   23   30:iconst_1        
    //   24   31:isub            
    //   25   32:iload_1         
    //   26   33:invokestatic    #510 <Method int select(double[], int[], int, int, int)>
    //   27   36:iaload          
    //   28   37:daload          
    //   29   38:dreturn         
    }

    public static double log2(double a)
    {
        return Math.log(a) / log2;
    //    0    0:dload_0         
    //    1    1:invokestatic    #18  <Method double Math.log(double)>
    //    2    4:getstatic       #20  <Field double log2>
    //    3    7:ddiv            
    //    4    8:dreturn         
    }

    public static int maxIndex(double doubles[])
    {
        double maximum = 0.0D;
    //    0    0:dconst_0        
    //    1    1:dstore_1        
        int maxIndex = 0;
    //    2    2:iconst_0        
    //    3    3:istore_3        
        for(int i = 0; i < doubles.length; i++)
    //*   4    4:iconst_0        
    //*   5    5:istore          4
    //*   6    7:goto            35
            if(i == 0 || doubles[i] > maximum)
    //*   7   10:iload           4
    //*   8   12:ifeq            24
    //*   9   15:aload_0         
    //*  10   16:iload           4
    //*  11   18:daload          
    //*  12   19:dload_1         
    //*  13   20:dcmpl           
    //*  14   21:ifle            32
            {
                maxIndex = i;
    //   15   24:iload           4
    //   16   26:istore_3        
                maximum = doubles[i];
    //   17   27:aload_0         
    //   18   28:iload           4
    //   19   30:daload          
    //   20   31:dstore_1        
            }

    //   21   32:iinc            4  1
    //   22   35:iload           4
    //   23   37:aload_0         
    //   24   38:arraylength     
    //   25   39:icmplt          10
        return maxIndex;
    //   26   42:iload_3         
    //   27   43:ireturn         
    }

    public static int maxIndex(int ints[])
    {
        int maximum = 0;
    //    0    0:iconst_0        
    //    1    1:istore_1        
        int maxIndex = 0;
    //    2    2:iconst_0        
    //    3    3:istore_2        
        for(int i = 0; i < ints.length; i++)
    //*   4    4:iconst_0        
    //*   5    5:istore_3        
    //*   6    6:goto            29
            if(i == 0 || ints[i] > maximum)
    //*   7    9:iload_3         
    //*   8   10:ifeq            20
    //*   9   13:aload_0         
    //*  10   14:iload_3         
    //*  11   15:iaload          
    //*  12   16:iload_1         
    //*  13   17:icmple          26
            {
                maxIndex = i;
    //   14   20:iload_3         
    //   15   21:istore_2        
                maximum = ints[i];
    //   16   22:aload_0         
    //   17   23:iload_3         
    //   18   24:iaload          
    //   19   25:istore_1        
            }

    //   20   26:iinc            3  1
    //   21   29:iload_3         
    //   22   30:aload_0         
    //   23   31:arraylength     
    //   24   32:icmplt          9
        return maxIndex;
    //   25   35:iload_2         
    //   26   36:ireturn         
    }

    public static double mean(double vector[])
    {
        double sum = 0.0D;
    //    0    0:dconst_0        
    //    1    1:dstore_1        
        if(vector.length == 0)
    //*   2    2:aload_0         
    //*   3    3:arraylength     
    //*   4    4:ifne            9
            return 0.0D;
    //    5    7:dconst_0        
    //    6    8:dreturn         
        for(int i = 0; i < vector.length; i++)
    //*   7    9:iconst_0        
    //*   8   10:istore_3        
    //*   9   11:goto            23
            sum += vector[i];
    //   10   14:dload_1         
    //   11   15:aload_0         
    //   12   16:iload_3         
    //   13   17:daload          
    //   14   18:dadd            
    //   15   19:dstore_1        

    //   16   20:iinc            3  1
    //   17   23:iload_3         
    //   18   24:aload_0         
    //   19   25:arraylength     
    //   20   26:icmplt          14
        return sum / (double)vector.length;
    //   21   29:dload_1         
    //   22   30:aload_0         
    //   23   31:arraylength     
    //   24   32:i2d             
    //   25   33:ddiv            
    //   26   34:dreturn         
    }

    public static int minIndex(int ints[])
    {
        int minimum = 0;
    //    0    0:iconst_0        
    //    1    1:istore_1        
        int minIndex = 0;
    //    2    2:iconst_0        
    //    3    3:istore_2        
        for(int i = 0; i < ints.length; i++)
    //*   4    4:iconst_0        
    //*   5    5:istore_3        
    //*   6    6:goto            29
            if(i == 0 || ints[i] < minimum)
    //*   7    9:iload_3         
    //*   8   10:ifeq            20
    //*   9   13:aload_0         
    //*  10   14:iload_3         
    //*  11   15:iaload          
    //*  12   16:iload_1         
    //*  13   17:icmpge          26
            {
                minIndex = i;
    //   14   20:iload_3         
    //   15   21:istore_2        
                minimum = ints[i];
    //   16   22:aload_0         
    //   17   23:iload_3         
    //   18   24:iaload          
    //   19   25:istore_1        
            }

    //   20   26:iinc            3  1
    //   21   29:iload_3         
    //   22   30:aload_0         
    //   23   31:arraylength     
    //   24   32:icmplt          9
        return minIndex;
    //   25   35:iload_2         
    //   26   36:ireturn         
    }

    public static int minIndex(double doubles[])
    {
        double minimum = 0.0D;
    //    0    0:dconst_0        
    //    1    1:dstore_1        
        int minIndex = 0;
    //    2    2:iconst_0        
    //    3    3:istore_3        
        for(int i = 0; i < doubles.length; i++)
    //*   4    4:iconst_0        
    //*   5    5:istore          4
    //*   6    7:goto            35
            if(i == 0 || doubles[i] < minimum)
    //*   7   10:iload           4
    //*   8   12:ifeq            24
    //*   9   15:aload_0         
    //*  10   16:iload           4
    //*  11   18:daload          
    //*  12   19:dload_1         
    //*  13   20:dcmpg           
    //*  14   21:ifge            32
            {
                minIndex = i;
    //   15   24:iload           4
    //   16   26:istore_3        
                minimum = doubles[i];
    //   17   27:aload_0         
    //   18   28:iload           4
    //   19   30:daload          
    //   20   31:dstore_1        
            }

    //   21   32:iinc            4  1
    //   22   35:iload           4
    //   23   37:aload_0         
    //   24   38:arraylength     
    //   25   39:icmplt          10
        return minIndex;
    //   26   42:iload_3         
    //   27   43:ireturn         
    }

    public static void normalize(double doubles[])
    {
        double sum = 0.0D;
    //    0    0:dconst_0        
    //    1    1:dstore_1        
        for(int i = 0; i < doubles.length; i++)
    //*   2    2:iconst_0        
    //*   3    3:istore_3        
    //*   4    4:goto            16
            sum += doubles[i];
    //    5    7:dload_1         
    //    6    8:aload_0         
    //    7    9:iload_3         
    //    8   10:daload          
    //    9   11:dadd            
    //   10   12:dstore_1        

    //   11   13:iinc            3  1
    //   12   16:iload_3         
    //   13   17:aload_0         
    //   14   18:arraylength     
    //   15   19:icmplt          7
        normalize(doubles, sum);
    //   16   22:aload_0         
    //   17   23:dload_1         
    //   18   24:invokestatic    #527 <Method void normalize(double[], double)>
    //   19   27:return          
    }

    public static void normalize(double doubles[], double sum)
    {
        if(Double.isNaN(sum))
    //*   0    0:dload_1         
    //*   1    1:invokestatic    #531 <Method boolean Double.isNaN(double)>
    //*   2    4:ifeq            18
            throw new IllegalArgumentException("Can't normalize array. Sum is NaN.");
    //    3    7:new             #533 <Class IllegalArgumentException>
    //    4   10:dup             
    //    5   11:ldc2            #535 <String "Can't normalize array. Sum is NaN.">
    //    6   14:invokespecial   #536 <Method void IllegalArgumentException(String)>
    //    7   17:athrow          
        if(sum == 0.0D)
    //*   8   18:dload_1         
    //*   9   19:dconst_0        
    //*  10   20:dcmpl           
    //*  11   21:ifne            35
            throw new IllegalArgumentException("Can't normalize array. Sum is zero.");
    //   12   24:new             #533 <Class IllegalArgumentException>
    //   13   27:dup             
    //   14   28:ldc2            #538 <String "Can't normalize array. Sum is zero.">
    //   15   31:invokespecial   #536 <Method void IllegalArgumentException(String)>
    //   16   34:athrow          
        for(int i = 0; i < doubles.length; i++)
    //*  17   35:iconst_0        
    //*  18   36:istore_3        
    //*  19   37:goto            50
            doubles[i] /= sum;
    //   20   40:aload_0         
    //   21   41:iload_3         
    //   22   42:dup2            
    //   23   43:daload          
    //   24   44:dload_1         
    //   25   45:ddiv            
    //   26   46:dastore         

    //   27   47:iinc            3  1
    //   28   50:iload_3         
    //   29   51:aload_0         
    //   30   52:arraylength     
    //   31   53:icmplt          40
    //   32   56:return          
    }

    public static double[] logs2probs(double a[])
    {
        double max = a[maxIndex(a)];
    //    0    0:aload_0         
    //    1    1:aload_0         
    //    2    2:invokestatic    #542 <Method int maxIndex(double[])>
    //    3    5:daload          
    //    4    6:dstore_1        
        double sum = 0.0D;
    //    5    7:dconst_0        
    //    6    8:dstore_3        
        double result[] = new double[a.length];
    //    7    9:aload_0         
    //    8   10:arraylength     
    //    9   11:newarray        double[]
    //   10   13:astore          5
        for(int i = 0; i < a.length; i++)
    //*  11   15:iconst_0        
    //*  12   16:istore          6
    //*  13   18:goto            46
        {
            result[i] = Math.exp(a[i] - max);
    //   14   21:aload           5
    //   15   23:iload           6
    //   16   25:aload_0         
    //   17   26:iload           6
    //   18   28:daload          
    //   19   29:dload_1         
    //   20   30:dsub            
    //   21   31:invokestatic    #545 <Method double Math.exp(double)>
    //   22   34:dastore         
            sum += result[i];
    //   23   35:dload_3         
    //   24   36:aload           5
    //   25   38:iload           6
    //   26   40:daload          
    //   27   41:dadd            
    //   28   42:dstore_3        
        }

    //   29   43:iinc            6  1
    //   30   46:iload           6
    //   31   48:aload_0         
    //   32   49:arraylength     
    //   33   50:icmplt          21
        normalize(result, sum);
    //   34   53:aload           5
    //   35   55:dload_3         
    //   36   56:invokestatic    #527 <Method void normalize(double[], double)>
        return result;
    //   37   59:aload           5
    //   38   61:areturn         
    }

    public static double probToLogOdds(double prob)
    {
        if(gr(prob, 1.0D) || sm(prob, 0.0D))
    //*   0    0:dload_0         
    //*   1    1:dconst_1        
    //*   2    2:invokestatic    #549 <Method boolean gr(double, double)>
    //*   3    5:ifne            16
    //*   4    8:dload_0         
    //*   5    9:dconst_0        
    //*   6   10:invokestatic    #551 <Method boolean sm(double, double)>
    //*   7   13:ifeq            41
        {
            throw new IllegalArgumentException((new StringBuilder("probToLogOdds: probability must be in [0,1] ")).append(prob).toString());
    //    8   16:new             #533 <Class IllegalArgumentException>
    //    9   19:dup             
    //   10   20:new             #91  <Class StringBuilder>
    //   11   23:dup             
    //   12   24:ldc2            #553 <String "probToLogOdds: probability must be in [0,1] ">
    //   13   27:invokespecial   #107 <Method void StringBuilder(String)>
    //   14   30:dload_0         
    //   15   31:invokevirtual   #252 <Method StringBuilder StringBuilder.append(double)>
    //   16   34:invokevirtual   #122 <Method String StringBuilder.toString()>
    //   17   37:invokespecial   #536 <Method void IllegalArgumentException(String)>
    //   18   40:athrow          
        } else
        {
            double p = SMALL + (1.0D - 2D * SMALL) * prob;
    //   19   41:getstatic       #24  <Field double SMALL>
    //   20   44:dconst_1        
    //   21   45:ldc2w           #11  <Double 2D>
    //   22   48:getstatic       #24  <Field double SMALL>
    //   23   51:dmul            
    //   24   52:dsub            
    //   25   53:dload_0         
    //   26   54:dmul            
    //   27   55:dadd            
    //   28   56:dstore_2        
            return Math.log(p / (1.0D - p));
    //   29   57:dload_2         
    //   30   58:dconst_1        
    //   31   59:dload_2         
    //   32   60:dsub            
    //   33   61:ddiv            
    //   34   62:invokestatic    #18  <Method double Math.log(double)>
    //   35   65:dreturn         
        }
    }

    public static int round(double value)
    {
        int roundedValue = value <= 0.0D ? -(int)(Math.abs(value) + 0.5D) : (int)(value + 0.5D);
    //    0    0:dload_0         
    //    1    1:dconst_0        
    //    2    2:dcmpl           
    //    3    3:ifle            15
    //    4    6:dload_0         
    //    5    7:ldc2w           #225 <Double 0.5D>
    //    6   10:dadd            
    //    7   11:d2i             
    //    8   12:goto            25
    //    9   15:dload_0         
    //   10   16:invokestatic    #157 <Method double Math.abs(double)>
    //   11   19:ldc2w           #225 <Double 0.5D>
    //   12   22:dadd            
    //   13   23:d2i             
    //   14   24:ineg            
    //   15   25:istore_2        
        return roundedValue;
    //   16   26:iload_2         
    //   17   27:ireturn         
    }

    public static int probRound(double value, Random rand)
    {
        double lower;
        double prob;
        if(value >= 0.0D)
    //*   0    0:dload_0         
    //*   1    1:dconst_0        
    //*   2    2:dcmpl           
    //*   3    3:iflt            34
        {
            lower = Math.floor(value);
    //    4    6:dload_0         
    //    5    7:invokestatic    #563 <Method double Math.floor(double)>
    //    6   10:dstore_3        
            prob = value - lower;
    //    7   11:dload_0         
    //    8   12:dload_3         
    //    9   13:dsub            
    //   10   14:dstore          5
            if(rand.nextDouble() < prob)
    //*  11   16:aload_2         
    //*  12   17:invokevirtual   #569 <Method double Random.nextDouble()>
    //*  13   20:dload           5
    //*  14   22:dcmpg           
    //*  15   23:ifge            31
                return (int)lower + 1;
    //   16   26:dload_3         
    //   17   27:d2i             
    //   18   28:iconst_1        
    //   19   29:iadd            
    //   20   30:ireturn         
            else
                return (int)lower;
    //   21   31:dload_3         
    //   22   32:d2i             
    //   23   33:ireturn         
        }
        lower = Math.floor(Math.abs(value));
    //   24   34:dload_0         
    //   25   35:invokestatic    #157 <Method double Math.abs(double)>
    //   26   38:invokestatic    #563 <Method double Math.floor(double)>
    //   27   41:dstore_3        
        prob = Math.abs(value) - lower;
    //   28   42:dload_0         
    //   29   43:invokestatic    #157 <Method double Math.abs(double)>
    //   30   46:dload_3         
    //   31   47:dsub            
    //   32   48:dstore          5
        if(rand.nextDouble() < prob)
    //*  33   50:aload_2         
    //*  34   51:invokevirtual   #569 <Method double Random.nextDouble()>
    //*  35   54:dload           5
    //*  36   56:dcmpg           
    //*  37   57:ifge            66
            return -((int)lower + 1);
    //   38   60:dload_3         
    //   39   61:d2i             
    //   40   62:iconst_1        
    //   41   63:iadd            
    //   42   64:ineg            
    //   43   65:ireturn         
        else
            return -(int)lower;
    //   44   66:dload_3         
    //   45   67:d2i             
    //   46   68:ineg            
    //   47   69:ireturn         
    }

    public static double roundDouble(double value, int afterDecimalPoint)
    {
        double mask = Math.pow(10D, afterDecimalPoint);
    //    0    0:ldc2w           #217 <Double 10D>
    //    1    3:iload_2         
    //    2    4:i2d             
    //    3    5:invokestatic    #222 <Method double Math.pow(double, double)>
    //    4    8:dstore_3        
        return (double)Math.round(value * mask) / mask;
    //    5    9:dload_0         
    //    6   10:dload_3         
    //    7   11:dmul            
    //    8   12:invokestatic    #577 <Method long Math.round(double)>
    //    9   15:l2d             
    //   10   16:dload_3         
    //   11   17:ddiv            
    //   12   18:dreturn         
    }

    public static int[] sort(int array[])
    {
        int index[] = new int[array.length];
    //    0    0:aload_0         
    //    1    1:arraylength     
    //    2    2:newarray        int[]
    //    3    4:astore_1        
        int newIndex[] = new int[array.length];
    //    4    5:aload_0         
    //    5    6:arraylength     
    //    6    7:newarray        int[]
    //    7    9:astore_2        
        for(int i = 0; i < index.length; i++)
    //*   8   10:iconst_0        
    //*   9   11:istore          5
    //*  10   13:goto            25
            index[i] = i;
    //   11   16:aload_1         
    //   12   17:iload           5
    //   13   19:iload           5
    //   14   21:iastore         

    //   15   22:iinc            5  1
    //   16   25:iload           5
    //   17   27:aload_1         
    //   18   28:arraylength     
    //   19   29:icmplt          16
        quickSort(array, index, 0, array.length - 1);
    //   20   32:aload_0         
    //   21   33:aload_1         
    //   22   34:iconst_0        
    //   23   35:aload_0         
    //   24   36:arraylength     
    //   25   37:iconst_1        
    //   26   38:isub            
    //   27   39:invokestatic    #584 <Method void quickSort(int[], int[], int, int)>
        for(int i = 0; i < index.length;)
    //*  28   42:iconst_0        
    //*  29   43:istore          5
    //*  30   45:goto            184
        {
            int numEqual = 1;
    //   31   48:iconst_1        
    //   32   49:istore          4
            for(int j = i + 1; j < index.length && array[index[i]] == array[index[j]]; j++)
    //*  33   51:iload           5
    //*  34   53:iconst_1        
    //*  35   54:iadd            
    //*  36   55:istore          6
    //*  37   57:goto            66
                numEqual++;
    //   38   60:iinc            4  1

    //   39   63:iinc            6  1
    //   40   66:iload           6
    //   41   68:aload_1         
    //   42   69:arraylength     
    //   43   70:icmpge          88
    //   44   73:aload_0         
    //   45   74:aload_1         
    //   46   75:iload           5
    //   47   77:iaload          
    //   48   78:iaload          
    //   49   79:aload_0         
    //   50   80:aload_1         
    //   51   81:iload           6
    //   52   83:iaload          
    //   53   84:iaload          
    //   54   85:icmpeq          60
            if(numEqual > 1)
    //*  55   88:iload           4
    //*  56   90:iconst_1        
    //*  57   91:icmple          173
            {
                int helpIndex[] = new int[numEqual];
    //   58   94:iload           4
    //   59   96:newarray        int[]
    //   60   98:astore_3        
                for(int j = 0; j < numEqual; j++)
    //*  61   99:iconst_0        
    //*  62  100:istore          6
    //*  63  102:goto            117
                    helpIndex[j] = i + j;
    //   64  105:aload_3         
    //   65  106:iload           6
    //   66  108:iload           5
    //   67  110:iload           6
    //   68  112:iadd            
    //   69  113:iastore         

    //   70  114:iinc            6  1
    //   71  117:iload           6
    //   72  119:iload           4
    //   73  121:icmplt          105
                quickSort(index, helpIndex, 0, numEqual - 1);
    //   74  124:aload_1         
    //   75  125:aload_3         
    //   76  126:iconst_0        
    //   77  127:iload           4
    //   78  129:iconst_1        
    //   79  130:isub            
    //   80  131:invokestatic    #584 <Method void quickSort(int[], int[], int, int)>
                for(int j = 0; j < numEqual; j++)
    //*  81  134:iconst_0        
    //*  82  135:istore          6
    //*  83  137:goto            156
                    newIndex[i + j] = index[helpIndex[j]];
    //   84  140:aload_2         
    //   85  141:iload           5
    //   86  143:iload           6
    //   87  145:iadd            
    //   88  146:aload_1         
    //   89  147:aload_3         
    //   90  148:iload           6
    //   91  150:iaload          
    //   92  151:iaload          
    //   93  152:iastore         

    //   94  153:iinc            6  1
    //   95  156:iload           6
    //   96  158:iload           4
    //   97  160:icmplt          140
                i += numEqual;
    //   98  163:iload           5
    //   99  165:iload           4
    //  100  167:iadd            
    //  101  168:istore          5
            } else
    //* 102  170:goto            184
            {
                newIndex[i] = index[i];
    //  103  173:aload_2         
    //  104  174:iload           5
    //  105  176:aload_1         
    //  106  177:iload           5
    //  107  179:iaload          
    //  108  180:iastore         
                i++;
    //  109  181:iinc            5  1
            }
        }

    //  110  184:iload           5
    //  111  186:aload_1         
    //  112  187:arraylength     
    //  113  188:icmplt          48
        return newIndex;
    //  114  191:aload_2         
    //  115  192:areturn         
    }

    public static int[] sort(double array[])
    {
        int index[] = new int[array.length];
    //    0    0:aload_0         
    //    1    1:arraylength     
    //    2    2:newarray        int[]
    //    3    4:astore_1        
        array = (double[])array.clone();
    //    4    5:aload_0         
    //    5    6:invokevirtual   #592 <Method Object _5B_D.clone()>
    //    6    9:checkcast       #589 <Class double[]>
    //    7   12:astore_0        
        for(int i = 0; i < index.length; i++)
    //*   8   13:iconst_0        
    //*   9   14:istore_2        
    //*  10   15:goto            40
        {
            index[i] = i;
    //   11   18:aload_1         
    //   12   19:iload_2         
    //   13   20:iload_2         
    //   14   21:iastore         
            if(Double.isNaN(array[i]))
    //*  15   22:aload_0         
    //*  16   23:iload_2         
    //*  17   24:daload          
    //*  18   25:invokestatic    #531 <Method boolean Double.isNaN(double)>
    //*  19   28:ifeq            37
                array[i] = 1.7976931348623157E+308D;
    //   20   31:aload_0         
    //   21   32:iload_2         
    //   22   33:ldc2w           #593 <Double 1.7976931348623157E+308D>
    //   23   36:dastore         
        }

    //   24   37:iinc            2  1
    //   25   40:iload_2         
    //   26   41:aload_1         
    //   27   42:arraylength     
    //   28   43:icmplt          18
        quickSort(array, index, 0, array.length - 1);
    //   29   46:aload_0         
    //   30   47:aload_1         
    //   31   48:iconst_0        
    //   32   49:aload_0         
    //   33   50:arraylength     
    //   34   51:iconst_1        
    //   35   52:isub            
    //   36   53:invokestatic    #597 <Method void quickSort(double[], int[], int, int)>
        return index;
    //   37   56:aload_1         
    //   38   57:areturn         
    }

    public static int[] stableSort(double array[])
    {
        int index[] = new int[array.length];
    //    0    0:aload_0         
    //    1    1:arraylength     
    //    2    2:newarray        int[]
    //    3    4:astore_1        
        int newIndex[] = new int[array.length];
    //    4    5:aload_0         
    //    5    6:arraylength     
    //    6    7:newarray        int[]
    //    7    9:astore_2        
        array = (double[])array.clone();
    //    8   10:aload_0         
    //    9   11:invokevirtual   #592 <Method Object _5B_D.clone()>
    //   10   14:checkcast       #589 <Class double[]>
    //   11   17:astore_0        
        for(int i = 0; i < index.length; i++)
    //*  12   18:iconst_0        
    //*  13   19:istore          5
    //*  14   21:goto            50
        {
            index[i] = i;
    //   15   24:aload_1         
    //   16   25:iload           5
    //   17   27:iload           5
    //   18   29:iastore         
            if(Double.isNaN(array[i]))
    //*  19   30:aload_0         
    //*  20   31:iload           5
    //*  21   33:daload          
    //*  22   34:invokestatic    #531 <Method boolean Double.isNaN(double)>
    //*  23   37:ifeq            47
                array[i] = 1.7976931348623157E+308D;
    //   24   40:aload_0         
    //   25   41:iload           5
    //   26   43:ldc2w           #593 <Double 1.7976931348623157E+308D>
    //   27   46:dastore         
        }

    //   28   47:iinc            5  1
    //   29   50:iload           5
    //   30   52:aload_1         
    //   31   53:arraylength     
    //   32   54:icmplt          24
        quickSort(array, index, 0, array.length - 1);
    //   33   57:aload_0         
    //   34   58:aload_1         
    //   35   59:iconst_0        
    //   36   60:aload_0         
    //   37   61:arraylength     
    //   38   62:iconst_1        
    //   39   63:isub            
    //   40   64:invokestatic    #597 <Method void quickSort(double[], int[], int, int)>
        for(int i = 0; i < index.length;)
    //*  41   67:iconst_0        
    //*  42   68:istore          5
    //*  43   70:goto            212
        {
            int numEqual = 1;
    //   44   73:iconst_1        
    //   45   74:istore          4
            for(int j = i + 1; j < index.length && eq(array[index[i]], array[index[j]]); j++)
    //*  46   76:iload           5
    //*  47   78:iconst_1        
    //*  48   79:iadd            
    //*  49   80:istore          6
    //*  50   82:goto            91
                numEqual++;
    //   51   85:iinc            4  1

    //   52   88:iinc            6  1
    //   53   91:iload           6
    //   54   93:aload_1         
    //   55   94:arraylength     
    //   56   95:icmpge          116
    //   57   98:aload_0         
    //   58   99:aload_1         
    //   59  100:iload           5
    //   60  102:iaload          
    //   61  103:daload          
    //   62  104:aload_0         
    //   63  105:aload_1         
    //   64  106:iload           6
    //   65  108:iaload          
    //   66  109:daload          
    //   67  110:invokestatic    #600 <Method boolean eq(double, double)>
    //   68  113:ifne            85
            if(numEqual > 1)
    //*  69  116:iload           4
    //*  70  118:iconst_1        
    //*  71  119:icmple          201
            {
                int helpIndex[] = new int[numEqual];
    //   72  122:iload           4
    //   73  124:newarray        int[]
    //   74  126:astore_3        
                for(int j = 0; j < numEqual; j++)
    //*  75  127:iconst_0        
    //*  76  128:istore          6
    //*  77  130:goto            145
                    helpIndex[j] = i + j;
    //   78  133:aload_3         
    //   79  134:iload           6
    //   80  136:iload           5
    //   81  138:iload           6
    //   82  140:iadd            
    //   83  141:iastore         

    //   84  142:iinc            6  1
    //   85  145:iload           6
    //   86  147:iload           4
    //   87  149:icmplt          133
                quickSort(index, helpIndex, 0, numEqual - 1);
    //   88  152:aload_1         
    //   89  153:aload_3         
    //   90  154:iconst_0        
    //   91  155:iload           4
    //   92  157:iconst_1        
    //   93  158:isub            
    //   94  159:invokestatic    #584 <Method void quickSort(int[], int[], int, int)>
                for(int j = 0; j < numEqual; j++)
    //*  95  162:iconst_0        
    //*  96  163:istore          6
    //*  97  165:goto            184
                    newIndex[i + j] = index[helpIndex[j]];
    //   98  168:aload_2         
    //   99  169:iload           5
    //  100  171:iload           6
    //  101  173:iadd            
    //  102  174:aload_1         
    //  103  175:aload_3         
    //  104  176:iload           6
    //  105  178:iaload          
    //  106  179:iaload          
    //  107  180:iastore         

    //  108  181:iinc            6  1
    //  109  184:iload           6
    //  110  186:iload           4
    //  111  188:icmplt          168
                i += numEqual;
    //  112  191:iload           5
    //  113  193:iload           4
    //  114  195:iadd            
    //  115  196:istore          5
            } else
    //* 116  198:goto            212
            {
                newIndex[i] = index[i];
    //  117  201:aload_2         
    //  118  202:iload           5
    //  119  204:aload_1         
    //  120  205:iload           5
    //  121  207:iaload          
    //  122  208:iastore         
                i++;
    //  123  209:iinc            5  1
            }
        }

    //  124  212:iload           5
    //  125  214:aload_1         
    //  126  215:arraylength     
    //  127  216:icmplt          73
        return newIndex;
    //  128  219:aload_2         
    //  129  220:areturn         
    }

    public static double variance(double vector[])
    {
        double sum = 0.0D;
    //    0    0:dconst_0        
    //    1    1:dstore_1        
        double sumSquared = 0.0D;
    //    2    2:dconst_0        
    //    3    3:dstore_3        
        if(vector.length <= 1)
    //*   4    4:aload_0         
    //*   5    5:arraylength     
    //*   6    6:iconst_1        
    //*   7    7:icmpgt          12
            return 0.0D;
    //    8   10:dconst_0        
    //    9   11:dreturn         
        for(int i = 0; i < vector.length; i++)
    //*  10   12:iconst_0        
    //*  11   13:istore          5
    //*  12   15:goto            40
        {
            sum += vector[i];
    //   13   18:dload_1         
    //   14   19:aload_0         
    //   15   20:iload           5
    //   16   22:daload          
    //   17   23:dadd            
    //   18   24:dstore_1        
            sumSquared += vector[i] * vector[i];
    //   19   25:dload_3         
    //   20   26:aload_0         
    //   21   27:iload           5
    //   22   29:daload          
    //   23   30:aload_0         
    //   24   31:iload           5
    //   25   33:daload          
    //   26   34:dmul            
    //   27   35:dadd            
    //   28   36:dstore_3        
        }

    //   29   37:iinc            5  1
    //   30   40:iload           5
    //   31   42:aload_0         
    //   32   43:arraylength     
    //   33   44:icmplt          18
        double result = (sumSquared - (sum * sum) / (double)vector.length) / (double)(vector.length - 1);
    //   34   47:dload_3         
    //   35   48:dload_1         
    //   36   49:dload_1         
    //   37   50:dmul            
    //   38   51:aload_0         
    //   39   52:arraylength     
    //   40   53:i2d             
    //   41   54:ddiv            
    //   42   55:dsub            
    //   43   56:aload_0         
    //   44   57:arraylength     
    //   45   58:iconst_1        
    //   46   59:isub            
    //   47   60:i2d             
    //   48   61:ddiv            
    //   49   62:dstore          5
        if(result < 0.0D)
    //*  50   64:dload           5
    //*  51   66:dconst_0        
    //*  52   67:dcmpg           
    //*  53   68:ifge            73
            return 0.0D;
    //   54   71:dconst_0        
    //   55   72:dreturn         
        else
            return result;
    //   56   73:dload           5
    //   57   75:dreturn         
    }

    public static double sum(double doubles[])
    {
        double sum = 0.0D;
    //    0    0:dconst_0        
    //    1    1:dstore_1        
        for(int i = 0; i < doubles.length; i++)
    //*   2    2:iconst_0        
    //*   3    3:istore_3        
    //*   4    4:goto            16
            sum += doubles[i];
    //    5    7:dload_1         
    //    6    8:aload_0         
    //    7    9:iload_3         
    //    8   10:daload          
    //    9   11:dadd            
    //   10   12:dstore_1        

    //   11   13:iinc            3  1
    //   12   16:iload_3         
    //   13   17:aload_0         
    //   14   18:arraylength     
    //   15   19:icmplt          7
        return sum;
    //   16   22:dload_1         
    //   17   23:dreturn         
    }

    public static int sum(int ints[])
    {
        int sum = 0;
    //    0    0:iconst_0        
    //    1    1:istore_1        
        for(int i = 0; i < ints.length; i++)
    //*   2    2:iconst_0        
    //*   3    3:istore_2        
    //*   4    4:goto            16
            sum += ints[i];
    //    5    7:iload_1         
    //    6    8:aload_0         
    //    7    9:iload_2         
    //    8   10:iaload          
    //    9   11:iadd            
    //   10   12:istore_1        

    //   11   13:iinc            2  1
    //   12   16:iload_2         
    //   13   17:aload_0         
    //   14   18:arraylength     
    //   15   19:icmplt          7
        return sum;
    //   16   22:iload_1         
    //   17   23:ireturn         
    }

    public static double xlogx(int c)
    {
        if(c == 0)
    //*   0    0:iload_0         
    //*   1    1:ifne            6
            return 0.0D;
    //    2    4:dconst_0        
    //    3    5:dreturn         
        else
            return (double)c * log2(c);
    //    4    6:iload_0         
    //    5    7:i2d             
    //    6    8:iload_0         
    //    7    9:i2d             
    //    8   10:invokestatic    #604 <Method double log2(double)>
    //    9   13:dmul            
    //   10   14:dreturn         
    }

    private static int partition(double array[], int index[], int l, int r)
    {
        double pivot = array[index[(l + r) / 2]];
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:iload_2         
    //    3    3:iload_3         
    //    4    4:iadd            
    //    5    5:iconst_2        
    //    6    6:idiv            
    //    7    7:iaload          
    //    8    8:daload          
    //    9    9:dstore          4
    //*  10   11:goto            85
    //*  11   14:goto            20
        while(l < r) 
        {
            while(array[index[l]] < pivot && l < r) 
                l++;
    //   12   17:iinc            2  1
    //   13   20:aload_0         
    //   14   21:aload_1         
    //   15   22:iload_2         
    //   16   23:iaload          
    //   17   24:daload          
    //   18   25:dload           4
    //   19   27:dcmpg           
    //   20   28:ifge            42
    //   21   31:iload_2         
    //   22   32:iload_3         
    //   23   33:icmplt          17
    //*  24   36:goto            42
            for(; array[index[r]] > pivot && l < r; r--);
    //   25   39:iinc            3  -1
    //   26   42:aload_0         
    //   27   43:aload_1         
    //   28   44:iload_3         
    //   29   45:iaload          
    //   30   46:daload          
    //   31   47:dload           4
    //   32   49:dcmpl           
    //   33   50:ifle            58
    //   34   53:iload_2         
    //   35   54:iload_3         
    //   36   55:icmplt          39
            if(l < r)
    //*  37   58:iload_2         
    //*  38   59:iload_3         
    //*  39   60:icmpge          85
            {
                int help = index[l];
    //   40   63:aload_1         
    //   41   64:iload_2         
    //   42   65:iaload          
    //   43   66:istore          6
                index[l] = index[r];
    //   44   68:aload_1         
    //   45   69:iload_2         
    //   46   70:aload_1         
    //   47   71:iload_3         
    //   48   72:iaload          
    //   49   73:iastore         
                index[r] = help;
    //   50   74:aload_1         
    //   51   75:iload_3         
    //   52   76:iload           6
    //   53   78:iastore         
                l++;
    //   54   79:iinc            2  1
                r--;
    //   55   82:iinc            3  -1
            }
        }
    //   56   85:iload_2         
    //   57   86:iload_3         
    //   58   87:icmplt          14
        if(l == r && array[index[r]] > pivot)
    //*  59   90:iload_2         
    //*  60   91:iload_3         
    //*  61   92:icmpne          109
    //*  62   95:aload_0         
    //*  63   96:aload_1         
    //*  64   97:iload_3         
    //*  65   98:iaload          
    //*  66   99:daload          
    //*  67  100:dload           4
    //*  68  102:dcmpl           
    //*  69  103:ifle            109
            r--;
    //   70  106:iinc            3  -1
        return r;
    //   71  109:iload_3         
    //   72  110:ireturn         
    }

    private static int partition(int array[], int index[], int l, int r)
    {
        double pivot = array[index[(l + r) / 2]];
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:iload_2         
    //    3    3:iload_3         
    //    4    4:iadd            
    //    5    5:iconst_2        
    //    6    6:idiv            
    //    7    7:iaload          
    //    8    8:iaload          
    //    9    9:i2d             
    //   10   10:dstore          4
    //*  11   12:goto            88
    //*  12   15:goto            21
        while(l < r) 
        {
            while((double)array[index[l]] < pivot && l < r) 
                l++;
    //   13   18:iinc            2  1
    //   14   21:aload_0         
    //   15   22:aload_1         
    //   16   23:iload_2         
    //   17   24:iaload          
    //   18   25:iaload          
    //   19   26:i2d             
    //   20   27:dload           4
    //   21   29:dcmpg           
    //   22   30:ifge            44
    //   23   33:iload_2         
    //   24   34:iload_3         
    //   25   35:icmplt          18
    //*  26   38:goto            44
            for(; (double)array[index[r]] > pivot && l < r; r--);
    //   27   41:iinc            3  -1
    //   28   44:aload_0         
    //   29   45:aload_1         
    //   30   46:iload_3         
    //   31   47:iaload          
    //   32   48:iaload          
    //   33   49:i2d             
    //   34   50:dload           4
    //   35   52:dcmpl           
    //   36   53:ifle            61
    //   37   56:iload_2         
    //   38   57:iload_3         
    //   39   58:icmplt          41
            if(l < r)
    //*  40   61:iload_2         
    //*  41   62:iload_3         
    //*  42   63:icmpge          88
            {
                int help = index[l];
    //   43   66:aload_1         
    //   44   67:iload_2         
    //   45   68:iaload          
    //   46   69:istore          6
                index[l] = index[r];
    //   47   71:aload_1         
    //   48   72:iload_2         
    //   49   73:aload_1         
    //   50   74:iload_3         
    //   51   75:iaload          
    //   52   76:iastore         
                index[r] = help;
    //   53   77:aload_1         
    //   54   78:iload_3         
    //   55   79:iload           6
    //   56   81:iastore         
                l++;
    //   57   82:iinc            2  1
                r--;
    //   58   85:iinc            3  -1
            }
        }
    //   59   88:iload_2         
    //   60   89:iload_3         
    //   61   90:icmplt          15
        if(l == r && (double)array[index[r]] > pivot)
    //*  62   93:iload_2         
    //*  63   94:iload_3         
    //*  64   95:icmpne          113
    //*  65   98:aload_0         
    //*  66   99:aload_1         
    //*  67  100:iload_3         
    //*  68  101:iaload          
    //*  69  102:iaload          
    //*  70  103:i2d             
    //*  71  104:dload           4
    //*  72  106:dcmpl           
    //*  73  107:ifle            113
            r--;
    //   74  110:iinc            3  -1
        return r;
    //   75  113:iload_3         
    //   76  114:ireturn         
    }

    private static void quickSort(double array[], int index[], int left, int right)
    {
        if(left < right)
    //*   0    0:iload_2         
    //*   1    1:iload_3         
    //*   2    2:icmpge          32
        {
            int middle = partition(array, index, left, right);
    //    3    5:aload_0         
    //    4    6:aload_1         
    //    5    7:iload_2         
    //    6    8:iload_3         
    //    7    9:invokestatic    #613 <Method int partition(double[], int[], int, int)>
    //    8   12:istore          4
            quickSort(array, index, left, middle);
    //    9   14:aload_0         
    //   10   15:aload_1         
    //   11   16:iload_2         
    //   12   17:iload           4
    //   13   19:invokestatic    #597 <Method void quickSort(double[], int[], int, int)>
            quickSort(array, index, middle + 1, right);
    //   14   22:aload_0         
    //   15   23:aload_1         
    //   16   24:iload           4
    //   17   26:iconst_1        
    //   18   27:iadd            
    //   19   28:iload_3         
    //   20   29:invokestatic    #597 <Method void quickSort(double[], int[], int, int)>
        }
    //   21   32:return          
    }

    private static void quickSort(int array[], int index[], int left, int right)
    {
        if(left < right)
    //*   0    0:iload_2         
    //*   1    1:iload_3         
    //*   2    2:icmpge          32
        {
            int middle = partition(array, index, left, right);
    //    3    5:aload_0         
    //    4    6:aload_1         
    //    5    7:iload_2         
    //    6    8:iload_3         
    //    7    9:invokestatic    #617 <Method int partition(int[], int[], int, int)>
    //    8   12:istore          4
            quickSort(array, index, left, middle);
    //    9   14:aload_0         
    //   10   15:aload_1         
    //   11   16:iload_2         
    //   12   17:iload           4
    //   13   19:invokestatic    #584 <Method void quickSort(int[], int[], int, int)>
            quickSort(array, index, middle + 1, right);
    //   14   22:aload_0         
    //   15   23:aload_1         
    //   16   24:iload           4
    //   17   26:iconst_1        
    //   18   27:iadd            
    //   19   28:iload_3         
    //   20   29:invokestatic    #584 <Method void quickSort(int[], int[], int, int)>
        }
    //   21   32:return          
    }

    private static int select(double array[], int index[], int left, int right, int k)
    {
        if(left == right)
    //*   0    0:iload_2         
    //*   1    1:iload_3         
    //*   2    2:icmpne          7
            return left;
    //    3    5:iload_2         
    //    4    6:ireturn         
        int middle = partition(array, index, left, right);
    //    5    7:aload_0         
    //    6    8:aload_1         
    //    7    9:iload_2         
    //    8   10:iload_3         
    //    9   11:invokestatic    #613 <Method int partition(double[], int[], int, int)>
    //   10   14:istore          5
        if((middle - left) + 1 >= k)
    //*  11   16:iload           5
    //*  12   18:iload_2         
    //*  13   19:isub            
    //*  14   20:iconst_1        
    //*  15   21:iadd            
    //*  16   22:iload           4
    //*  17   24:icmplt          38
            return select(array, index, left, middle, k);
    //   18   27:aload_0         
    //   19   28:aload_1         
    //   20   29:iload_2         
    //   21   30:iload           5
    //   22   32:iload           4
    //   23   34:invokestatic    #510 <Method int select(double[], int[], int, int, int)>
    //   24   37:ireturn         
        else
            return select(array, index, middle + 1, right, k - ((middle - left) + 1));
    //   25   38:aload_0         
    //   26   39:aload_1         
    //   27   40:iload           5
    //   28   42:iconst_1        
    //   29   43:iadd            
    //   30   44:iload_3         
    //   31   45:iload           4
    //   32   47:iload           5
    //   33   49:iload_2         
    //   34   50:isub            
    //   35   51:iconst_1        
    //   36   52:iadd            
    //   37   53:isub            
    //   38   54:invokestatic    #510 <Method int select(double[], int[], int, int, int)>
    //   39   57:ireturn         
    }

    public static File convertToRelativePath(File absolute)
        throws Exception
    {
        File result = null;
    //    0    0:aconst_null     
    //    1    1:astore_1        
        if(File.separator.equals("\\"))
    //*   2    2:getstatic       #622 <Field String File.separator>
    //*   3    5:ldc2            #624 <String "\\">
    //*   4    8:invokevirtual   #352 <Method boolean String.equals(Object)>
    //*   5   11:ifeq            74
            try
            {
                String fileStr = absolute.getPath();
    //    6   14:aload_0         
    //    7   15:invokevirtual   #627 <Method String File.getPath()>
    //    8   18:astore_2        
                fileStr = (new StringBuilder(String.valueOf(fileStr.substring(0, 1).toLowerCase()))).append(fileStr.substring(1)).toString();
    //    9   19:new             #91  <Class StringBuilder>
    //   10   22:dup             
    //   11   23:aload_2         
    //   12   24:iconst_0        
    //   13   25:iconst_1        
    //   14   26:invokevirtual   #179 <Method String String.substring(int, int)>
    //   15   29:invokevirtual   #630 <Method String String.toLowerCase()>
    //   16   32:invokestatic    #105 <Method String String.valueOf(Object)>
    //   17   35:invokespecial   #107 <Method void StringBuilder(String)>
    //   18   38:aload_2         
    //   19   39:iconst_1        
    //   20   40:invokevirtual   #84  <Method String String.substring(int)>
    //   21   43:invokevirtual   #118 <Method StringBuilder StringBuilder.append(String)>
    //   22   46:invokevirtual   #122 <Method String StringBuilder.toString()>
    //   23   49:astore_2        
                result = createRelativePath(new File(fileStr));
    //   24   50:new             #89  <Class File>
    //   25   53:dup             
    //   26   54:aload_2         
    //   27   55:invokespecial   #123 <Method void File(String)>
    //   28   58:invokestatic    #633 <Method File createRelativePath(File)>
    //   29   61:astore_1        
            }
    //*  30   62:goto            79
            catch(Exception e)
    //*  31   65:astore_3        
            {
                result = createRelativePath(absolute);
    //   32   66:aload_0         
    //   33   67:invokestatic    #633 <Method File createRelativePath(File)>
    //   34   70:astore_1        
            }
        else
    //*  35   71:goto            79
            result = createRelativePath(absolute);
    //   36   74:aload_0         
    //   37   75:invokestatic    #633 <Method File createRelativePath(File)>
    //   38   78:astore_1        
        return result;
    //   39   79:aload_1         
    //   40   80:areturn         
    }

    protected static File createRelativePath(File absolute)
        throws Exception
    {
        File userDir = new File(System.getProperty("user.dir"));
    //    0    0:new             #89  <Class File>
    //    1    3:dup             
    //    2    4:ldc2            #637 <String "user.dir">
    //    3    7:invokestatic    #638 <Method String System.getProperty(String)>
    //    4   10:invokespecial   #123 <Method void File(String)>
    //    5   13:astore_1        
        String userPath = (new StringBuilder(String.valueOf(userDir.getAbsolutePath()))).append(File.separator).toString();
    //    6   14:new             #91  <Class StringBuilder>
    //    7   17:dup             
    //    8   18:aload_1         
    //    9   19:invokevirtual   #641 <Method String File.getAbsolutePath()>
    //   10   22:invokestatic    #105 <Method String String.valueOf(Object)>
    //   11   25:invokespecial   #107 <Method void StringBuilder(String)>
    //   12   28:getstatic       #622 <Field String File.separator>
    //   13   31:invokevirtual   #118 <Method StringBuilder StringBuilder.append(String)>
    //   14   34:invokevirtual   #122 <Method String StringBuilder.toString()>
    //   15   37:astore_2        
        String targetPath = (new StringBuilder(String.valueOf((new File(absolute.getParent())).getPath()))).append(File.separator).toString();
    //   16   38:new             #91  <Class StringBuilder>
    //   17   41:dup             
    //   18   42:new             #89  <Class File>
    //   19   45:dup             
    //   20   46:aload_0         
    //   21   47:invokevirtual   #644 <Method String File.getParent()>
    //   22   50:invokespecial   #123 <Method void File(String)>
    //   23   53:invokevirtual   #627 <Method String File.getPath()>
    //   24   56:invokestatic    #105 <Method String String.valueOf(Object)>
    //   25   59:invokespecial   #107 <Method void StringBuilder(String)>
    //   26   62:getstatic       #622 <Field String File.separator>
    //   27   65:invokevirtual   #118 <Method StringBuilder StringBuilder.append(String)>
    //   28   68:invokevirtual   #122 <Method String StringBuilder.toString()>
    //   29   71:astore_3        
        String fileName = absolute.getName();
    //   30   72:aload_0         
    //   31   73:invokevirtual   #645 <Method String File.getName()>
    //   32   76:astore          4
        StringBuffer relativePath = new StringBuffer();
    //   33   78:new             #175 <Class StringBuffer>
    //   34   81:dup             
    //   35   82:invokespecial   #176 <Method void StringBuffer()>
    //   36   85:astore          5
        int subdir = targetPath.indexOf(userPath);
    //   37   87:aload_3         
    //   38   88:aload_2         
    //   39   89:invokevirtual   #389 <Method int String.indexOf(String)>
    //   40   92:istore          6
        if(subdir == 0)
    //*  41   94:iload           6
    //*  42   96:ifne            150
        {
            if(userPath.length() == targetPath.length())
    //*  43   99:aload_2         
    //*  44  100:invokevirtual   #186 <Method int String.length()>
    //*  45  103:aload_3         
    //*  46  104:invokevirtual   #186 <Method int String.length()>
    //*  47  107:icmpne          121
            {
                relativePath.append(fileName);
    //   48  110:aload           5
    //   49  112:aload           4
    //   50  114:invokevirtual   #182 <Method StringBuffer StringBuffer.append(String)>
    //   51  117:pop             
            } else
    //*  52  118:goto            449
            {
                int ll = userPath.length();
    //   53  121:aload_2         
    //   54  122:invokevirtual   #186 <Method int String.length()>
    //   55  125:istore          7
                relativePath.append(targetPath.substring(ll));
    //   56  127:aload           5
    //   57  129:aload_3         
    //   58  130:iload           7
    //   59  132:invokevirtual   #84  <Method String String.substring(int)>
    //   60  135:invokevirtual   #182 <Method StringBuffer StringBuffer.append(String)>
    //   61  138:pop             
                relativePath.append(fileName);
    //   62  139:aload           5
    //   63  141:aload           4
    //   64  143:invokevirtual   #182 <Method StringBuffer StringBuffer.append(String)>
    //   65  146:pop             
            }
        } else
    //*  66  147:goto            449
        {
            int sepCount = 0;
    //   67  150:iconst_0        
    //   68  151:istore          7
            int ind;
            for(String temp = new String(userPath); temp.indexOf(File.separator) != -1; temp = temp.substring(ind + 1, temp.length()))
    //*  69  153:new             #76  <Class String>
    //*  70  156:dup             
    //*  71  157:aload_2         
    //*  72  158:invokespecial   #253 <Method void String(String)>
    //*  73  161:astore          8
    //*  74  163:goto            195
            {
                ind = temp.indexOf(File.separator);
    //   75  166:aload           8
    //   76  168:getstatic       #622 <Field String File.separator>
    //   77  171:invokevirtual   #389 <Method int String.indexOf(String)>
    //   78  174:istore          9
                sepCount++;
    //   79  176:iinc            7  1
            }

    //   80  179:aload           8
    //   81  181:iload           9
    //   82  183:iconst_1        
    //   83  184:iadd            
    //   84  185:aload           8
    //   85  187:invokevirtual   #186 <Method int String.length()>
    //   86  190:invokevirtual   #179 <Method String String.substring(int, int)>
    //   87  193:astore          8
    //   88  195:aload           8
    //   89  197:getstatic       #622 <Field String File.separator>
    //   90  200:invokevirtual   #389 <Method int String.indexOf(String)>
    //   91  203:iconst_m1       
    //   92  204:icmpne          166
            String targetTemp = new String(targetPath);
    //   93  207:new             #76  <Class String>
    //   94  210:dup             
    //   95  211:aload_3         
    //   96  212:invokespecial   #253 <Method void String(String)>
    //   97  215:astore          9
            String userTemp = new String(userPath);
    //   98  217:new             #76  <Class String>
    //   99  220:dup             
    //  100  221:aload_2         
    //  101  222:invokespecial   #253 <Method void String(String)>
    //  102  225:astore          10
            int tcount = 0;
    //  103  227:iconst_0        
    //  104  228:istore          11
    //* 105  230:goto            333
            while(targetTemp.indexOf(File.separator) != -1) 
            {
                int ind = targetTemp.indexOf(File.separator);
    //  106  233:aload           9
    //  107  235:getstatic       #622 <Field String File.separator>
    //  108  238:invokevirtual   #389 <Method int String.indexOf(String)>
    //  109  241:istore          12
                int ind2 = userTemp.indexOf(File.separator);
    //  110  243:aload           10
    //  111  245:getstatic       #622 <Field String File.separator>
    //  112  248:invokevirtual   #389 <Method int String.indexOf(String)>
    //  113  251:istore          13
                String tpart = targetTemp.substring(0, ind + 1);
    //  114  253:aload           9
    //  115  255:iconst_0        
    //  116  256:iload           12
    //  117  258:iconst_1        
    //  118  259:iadd            
    //  119  260:invokevirtual   #179 <Method String String.substring(int, int)>
    //  120  263:astore          14
                String upart = userTemp.substring(0, ind2 + 1);
    //  121  265:aload           10
    //  122  267:iconst_0        
    //  123  268:iload           13
    //  124  270:iconst_1        
    //  125  271:iadd            
    //  126  272:invokevirtual   #179 <Method String String.substring(int, int)>
    //  127  275:astore          15
                if(tpart.compareTo(upart) != 0)
    //* 128  277:aload           14
    //* 129  279:aload           15
    //* 130  281:invokevirtual   #648 <Method int String.compareTo(String)>
    //* 131  284:ifeq            298
                {
                    if(tcount == 0)
    //* 132  287:iload           11
    //* 133  289:ifne            345
                        tcount = -1;
    //  134  292:iconst_m1       
    //  135  293:istore          11
                    break;
    //  136  295:goto            345
                }
                tcount++;
    //  137  298:iinc            11  1
                targetTemp = targetTemp.substring(ind + 1, targetTemp.length());
    //  138  301:aload           9
    //  139  303:iload           12
    //  140  305:iconst_1        
    //  141  306:iadd            
    //  142  307:aload           9
    //  143  309:invokevirtual   #186 <Method int String.length()>
    //  144  312:invokevirtual   #179 <Method String String.substring(int, int)>
    //  145  315:astore          9
                userTemp = userTemp.substring(ind2 + 1, userTemp.length());
    //  146  317:aload           10
    //  147  319:iload           13
    //  148  321:iconst_1        
    //  149  322:iadd            
    //  150  323:aload           10
    //  151  325:invokevirtual   #186 <Method int String.length()>
    //  152  328:invokevirtual   #179 <Method String String.substring(int, int)>
    //  153  331:astore          10
            }
    //  154  333:aload           9
    //  155  335:getstatic       #622 <Field String File.separator>
    //  156  338:invokevirtual   #389 <Method int String.indexOf(String)>
    //  157  341:iconst_m1       
    //  158  342:icmpne          233
            if(tcount == -1)
    //* 159  345:iload           11
    //* 160  347:iconst_m1       
    //* 161  348:icmpne          362
                throw new Exception("Can't construct a path to file relative to user dir.");
    //  162  351:new             #36  <Class Exception>
    //  163  354:dup             
    //  164  355:ldc2            #650 <String "Can't construct a path to file relative to user dir.">
    //  165  358:invokespecial   #138 <Method void Exception(String)>
    //  166  361:athrow          
            if(targetTemp.indexOf(File.separator) == -1)
    //* 167  362:aload           9
    //* 168  364:getstatic       #622 <Field String File.separator>
    //* 169  367:invokevirtual   #389 <Method int String.indexOf(String)>
    //* 170  370:iconst_m1       
    //* 171  371:icmpne          379
                targetTemp = "";
    //  172  374:ldc2            #295 <String "">
    //  173  377:astore          9
            for(int i = 0; i < sepCount - tcount; i++)
    //* 174  379:iconst_0        
    //* 175  380:istore          12
    //* 176  382:goto            413
                relativePath.append((new StringBuilder("..")).append(File.separator).toString());
    //  177  385:aload           5
    //  178  387:new             #91  <Class StringBuilder>
    //  179  390:dup             
    //  180  391:ldc2            #652 <String "..">
    //  181  394:invokespecial   #107 <Method void StringBuilder(String)>
    //  182  397:getstatic       #622 <Field String File.separator>
    //  183  400:invokevirtual   #118 <Method StringBuilder StringBuilder.append(String)>
    //  184  403:invokevirtual   #122 <Method String StringBuilder.toString()>
    //  185  406:invokevirtual   #182 <Method StringBuffer StringBuffer.append(String)>
    //  186  409:pop             

    //  187  410:iinc            12  1
    //  188  413:iload           12
    //  189  415:iload           7
    //  190  417:iload           11
    //  191  419:isub            
    //  192  420:icmplt          385
            relativePath.append((new StringBuilder(String.valueOf(targetTemp))).append(fileName).toString());
    //  193  423:aload           5
    //  194  425:new             #91  <Class StringBuilder>
    //  195  428:dup             
    //  196  429:aload           9
    //  197  431:invokestatic    #105 <Method String String.valueOf(Object)>
    //  198  434:invokespecial   #107 <Method void StringBuilder(String)>
    //  199  437:aload           4
    //  200  439:invokevirtual   #118 <Method StringBuilder StringBuilder.append(String)>
    //  201  442:invokevirtual   #122 <Method String StringBuilder.toString()>
    //  202  445:invokevirtual   #182 <Method StringBuffer StringBuffer.append(String)>
    //  203  448:pop             
        }
        return new File(relativePath.toString());
    //  204  449:new             #89  <Class File>
    //  205  452:dup             
    //  206  453:aload           5
    //  207  455:invokevirtual   #191 <Method String StringBuffer.toString()>
    //  208  458:invokespecial   #123 <Method void File(String)>
    //  209  461:areturn         
    }

    private static int select(int array[], int index[], int left, int right, int k)
    {
        if(left == right)
    //*   0    0:iload_2         
    //*   1    1:iload_3         
    //*   2    2:icmpne          7
            return left;
    //    3    5:iload_2         
    //    4    6:ireturn         
        int middle = partition(array, index, left, right);
    //    5    7:aload_0         
    //    6    8:aload_1         
    //    7    9:iload_2         
    //    8   10:iload_3         
    //    9   11:invokestatic    #617 <Method int partition(int[], int[], int, int)>
    //   10   14:istore          5
        if((middle - left) + 1 >= k)
    //*  11   16:iload           5
    //*  12   18:iload_2         
    //*  13   19:isub            
    //*  14   20:iconst_1        
    //*  15   21:iadd            
    //*  16   22:iload           4
    //*  17   24:icmplt          38
            return select(array, index, left, middle, k);
    //   18   27:aload_0         
    //   19   28:aload_1         
    //   20   29:iload_2         
    //   21   30:iload           5
    //   22   32:iload           4
    //   23   34:invokestatic    #505 <Method int select(int[], int[], int, int, int)>
    //   24   37:ireturn         
        else
            return select(array, index, middle + 1, right, k - ((middle - left) + 1));
    //   25   38:aload_0         
    //   26   39:aload_1         
    //   27   40:iload           5
    //   28   42:iconst_1        
    //   29   43:iadd            
    //   30   44:iload_3         
    //   31   45:iload           4
    //   32   47:iload           5
    //   33   49:iload_2         
    //   34   50:isub            
    //   35   51:iconst_1        
    //   36   52:iadd            
    //   37   53:isub            
    //   38   54:invokestatic    #505 <Method int select(int[], int[], int, int, int)>
    //   39   57:ireturn         
    }

    public static void main(String ops[])
    {
        double doublesWithNaN[] = {
            4.5D, 6.7000000000000002D, (0.0D / 0.0D), 3.3999999999999999D, 4.7999999999999998D, 1.2D, 3.3999999999999999D
        };
    //    0    0:bipush          7
    //    1    2:newarray        double[]
    //    2    4:dup             
    //    3    5:iconst_0        
    //    4    6:ldc2w           #669 <Double 4.5D>
    //    5    9:dastore         
    //    6   10:dup             
    //    7   11:iconst_1        
    //    8   12:ldc2w           #671 <Double 6.7000000000000002D>
    //    9   15:dastore         
    //   10   16:dup             
    //   11   17:iconst_2        
    //   12   18:ldc2w           #673 <Double (0.0D / 0.0D)>
    //   13   21:dastore         
    //   14   22:dup             
    //   15   23:iconst_3        
    //   16   24:ldc2w           #675 <Double 3.3999999999999999D>
    //   17   27:dastore         
    //   18   28:dup             
    //   19   29:iconst_4        
    //   20   30:ldc2w           #677 <Double 4.7999999999999998D>
    //   21   33:dastore         
    //   22   34:dup             
    //   23   35:iconst_5        
    //   24   36:ldc2w           #679 <Double 1.2D>
    //   25   39:dastore         
    //   26   40:dup             
    //   27   41:bipush          6
    //   28   43:ldc2w           #675 <Double 3.3999999999999999D>
    //   29   46:dastore         
    //   30   47:astore_1        
        double doubles[] = {
            4.5D, 6.7000000000000002D, 6.7000000000000002D, 3.3999999999999999D, 4.7999999999999998D, 1.2D, 3.3999999999999999D, 6.7000000000000002D, 6.7000000000000002D, 3.3999999999999999D
        };
    //   31   48:bipush          10
    //   32   50:newarray        double[]
    //   33   52:dup             
    //   34   53:iconst_0        
    //   35   54:ldc2w           #669 <Double 4.5D>
    //   36   57:dastore         
    //   37   58:dup             
    //   38   59:iconst_1        
    //   39   60:ldc2w           #671 <Double 6.7000000000000002D>
    //   40   63:dastore         
    //   41   64:dup             
    //   42   65:iconst_2        
    //   43   66:ldc2w           #671 <Double 6.7000000000000002D>
    //   44   69:dastore         
    //   45   70:dup             
    //   46   71:iconst_3        
    //   47   72:ldc2w           #675 <Double 3.3999999999999999D>
    //   48   75:dastore         
    //   49   76:dup             
    //   50   77:iconst_4        
    //   51   78:ldc2w           #677 <Double 4.7999999999999998D>
    //   52   81:dastore         
    //   53   82:dup             
    //   54   83:iconst_5        
    //   55   84:ldc2w           #679 <Double 1.2D>
    //   56   87:dastore         
    //   57   88:dup             
    //   58   89:bipush          6
    //   59   91:ldc2w           #675 <Double 3.3999999999999999D>
    //   60   94:dastore         
    //   61   95:dup             
    //   62   96:bipush          7
    //   63   98:ldc2w           #671 <Double 6.7000000000000002D>
    //   64  101:dastore         
    //   65  102:dup             
    //   66  103:bipush          8
    //   67  105:ldc2w           #671 <Double 6.7000000000000002D>
    //   68  108:dastore         
    //   69  109:dup             
    //   70  110:bipush          9
    //   71  112:ldc2w           #675 <Double 3.3999999999999999D>
    //   72  115:dastore         
    //   73  116:astore_2        
        int ints[] = {
            12, 6, 2, 18, 16, 6, 7, 5, 18, 18, 
            17
        };
    //   74  117:bipush          11
    //   75  119:newarray        int[]
    //   76  121:dup             
    //   77  122:iconst_0        
    //   78  123:bipush          12
    //   79  125:iastore         
    //   80  126:dup             
    //   81  127:iconst_1        
    //   82  128:bipush          6
    //   83  130:iastore         
    //   84  131:dup             
    //   85  132:iconst_2        
    //   86  133:iconst_2        
    //   87  134:iastore         
    //   88  135:dup             
    //   89  136:iconst_3        
    //   90  137:bipush          18
    //   91  139:iastore         
    //   92  140:dup             
    //   93  141:iconst_4        
    //   94  142:bipush          16
    //   95  144:iastore         
    //   96  145:dup             
    //   97  146:iconst_5        
    //   98  147:bipush          6
    //   99  149:iastore         
    //  100  150:dup             
    //  101  151:bipush          6
    //  102  153:bipush          7
    //  103  155:iastore         
    //  104  156:dup             
    //  105  157:bipush          7
    //  106  159:iconst_5        
    //  107  160:iastore         
    //  108  161:dup             
    //  109  162:bipush          8
    //  110  164:bipush          18
    //  111  166:iastore         
    //  112  167:dup             
    //  113  168:bipush          9
    //  114  170:bipush          18
    //  115  172:iastore         
    //  116  173:dup             
    //  117  174:bipush          10
    //  118  176:bipush          17
    //  119  178:iastore         
    //  120  179:astore_3        
        try
        {
            System.out.println("First option split up:");
    //  121  180:getstatic       #683 <Field PrintStream System.out>
    //  122  183:ldc2            #685 <String "First option split up:">
    //  123  186:invokevirtual   #74  <Method void PrintStream.println(String)>
            if(ops.length > 0)
    //* 124  189:aload_0         
    //* 125  190:arraylength     
    //* 126  191:ifle            230
            {
                String firstOptionSplitUp[] = splitOptions(ops[0]);
    //  127  194:aload_0         
    //  128  195:iconst_0        
    //  129  196:aaload          
    //  130  197:invokestatic    #687 <Method String[] splitOptions(String)>
    //  131  200:astore          4
                for(int i = 0; i < firstOptionSplitUp.length; i++)
    //* 132  202:iconst_0        
    //* 133  203:istore          5
    //* 134  205:goto            222
                    System.out.println(firstOptionSplitUp[i]);
    //  135  208:getstatic       #683 <Field PrintStream System.out>
    //  136  211:aload           4
    //  137  213:iload           5
    //  138  215:aaload          
    //  139  216:invokevirtual   #74  <Method void PrintStream.println(String)>

    //  140  219:iinc            5  1
    //  141  222:iload           5
    //  142  224:aload           4
    //  143  226:arraylength     
    //  144  227:icmplt          208
            }
            System.out.println("Partitioned options: ");
    //  145  230:getstatic       #683 <Field PrintStream System.out>
    //  146  233:ldc2            #689 <String "Partitioned options: ">
    //  147  236:invokevirtual   #74  <Method void PrintStream.println(String)>
            String partitionedOptions[] = partitionOptions(ops);
    //  148  239:aload_0         
    //  149  240:invokestatic    #691 <Method String[] partitionOptions(String[])>
    //  150  243:astore          4
            for(int i = 0; i < partitionedOptions.length; i++)
    //* 151  245:iconst_0        
    //* 152  246:istore          5
    //* 153  248:goto            265
                System.out.println(partitionedOptions[i]);
    //  154  251:getstatic       #683 <Field PrintStream System.out>
    //  155  254:aload           4
    //  156  256:iload           5
    //  157  258:aaload          
    //  158  259:invokevirtual   #74  <Method void PrintStream.println(String)>

    //  159  262:iinc            5  1
    //  160  265:iload           5
    //  161  267:aload           4
    //  162  269:arraylength     
    //  163  270:icmplt          251
            System.out.println((new StringBuilder("Get position of flag -f: ")).append(getOptionPos('f', ops)).toString());
    //  164  273:getstatic       #683 <Field PrintStream System.out>
    //  165  276:new             #91  <Class StringBuilder>
    //  166  279:dup             
    //  167  280:ldc2            #693 <String "Get position of flag -f: ">
    //  168  283:invokespecial   #107 <Method void StringBuilder(String)>
    //  169  286:bipush          102
    //  170  288:aload_0         
    //  171  289:invokestatic    #695 <Method int getOptionPos(char, String[])>
    //  172  292:invokevirtual   #698 <Method StringBuilder StringBuilder.append(int)>
    //  173  295:invokevirtual   #122 <Method String StringBuilder.toString()>
    //  174  298:invokevirtual   #74  <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Get flag -f: ")).append(getFlag('f', ops)).toString());
    //  175  301:getstatic       #683 <Field PrintStream System.out>
    //  176  304:new             #91  <Class StringBuilder>
    //  177  307:dup             
    //  178  308:ldc2            #700 <String "Get flag -f: ">
    //  179  311:invokespecial   #107 <Method void StringBuilder(String)>
    //  180  314:bipush          102
    //  181  316:aload_0         
    //  182  317:invokestatic    #702 <Method boolean getFlag(char, String[])>
    //  183  320:invokevirtual   #705 <Method StringBuilder StringBuilder.append(boolean)>
    //  184  323:invokevirtual   #122 <Method String StringBuilder.toString()>
    //  185  326:invokevirtual   #74  <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Get position of option -o: ")).append(getOptionPos('o', ops)).toString());
    //  186  329:getstatic       #683 <Field PrintStream System.out>
    //  187  332:new             #91  <Class StringBuilder>
    //  188  335:dup             
    //  189  336:ldc2            #707 <String "Get position of option -o: ">
    //  190  339:invokespecial   #107 <Method void StringBuilder(String)>
    //  191  342:bipush          111
    //  192  344:aload_0         
    //  193  345:invokestatic    #695 <Method int getOptionPos(char, String[])>
    //  194  348:invokevirtual   #698 <Method StringBuilder StringBuilder.append(int)>
    //  195  351:invokevirtual   #122 <Method String StringBuilder.toString()>
    //  196  354:invokevirtual   #74  <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Get option -o: ")).append(getOption('o', ops)).toString());
    //  197  357:getstatic       #683 <Field PrintStream System.out>
    //  198  360:new             #91  <Class StringBuilder>
    //  199  363:dup             
    //  200  364:ldc2            #709 <String "Get option -o: ">
    //  201  367:invokespecial   #107 <Method void StringBuilder(String)>
    //  202  370:bipush          111
    //  203  372:aload_0         
    //  204  373:invokestatic    #711 <Method String getOption(char, String[])>
    //  205  376:invokevirtual   #118 <Method StringBuilder StringBuilder.append(String)>
    //  206  379:invokevirtual   #122 <Method String StringBuilder.toString()>
    //  207  382:invokevirtual   #74  <Method void PrintStream.println(String)>
            System.out.println("Checking for remaining options... ");
    //  208  385:getstatic       #683 <Field PrintStream System.out>
    //  209  388:ldc2            #713 <String "Checking for remaining options... ">
    //  210  391:invokevirtual   #74  <Method void PrintStream.println(String)>
            checkForRemainingOptions(ops);
    //  211  394:aload_0         
    //  212  395:invokestatic    #483 <Method void checkForRemainingOptions(String[])>
            System.out.println("Original array with NaN (doubles): ");
    //  213  398:getstatic       #683 <Field PrintStream System.out>
    //  214  401:ldc2            #715 <String "Original array with NaN (doubles): ">
    //  215  404:invokevirtual   #74  <Method void PrintStream.println(String)>
            for(int i = 0; i < doublesWithNaN.length; i++)
    //* 216  407:iconst_0        
    //* 217  408:istore          5
    //* 218  410:goto            444
                System.out.print((new StringBuilder(String.valueOf(doublesWithNaN[i]))).append(" ").toString());
    //  219  413:getstatic       #683 <Field PrintStream System.out>
    //  220  416:new             #91  <Class StringBuilder>
    //  221  419:dup             
    //  222  420:aload_1         
    //  223  421:iload           5
    //  224  423:daload          
    //  225  424:invokestatic    #718 <Method String String.valueOf(double)>
    //  226  427:invokespecial   #107 <Method void StringBuilder(String)>
    //  227  430:ldc1            #209 <String " ">
    //  228  432:invokevirtual   #118 <Method StringBuilder StringBuilder.append(String)>
    //  229  435:invokevirtual   #122 <Method String StringBuilder.toString()>
    //  230  438:invokevirtual   #721 <Method void PrintStream.print(String)>

    //  231  441:iinc            5  1
    //  232  444:iload           5
    //  233  446:aload_1         
    //  234  447:arraylength     
    //  235  448:icmplt          413
            System.out.println();
    //  236  451:getstatic       #683 <Field PrintStream System.out>
    //  237  454:invokevirtual   #723 <Method void PrintStream.println()>
            System.out.println("Original array (doubles): ");
    //  238  457:getstatic       #683 <Field PrintStream System.out>
    //  239  460:ldc2            #725 <String "Original array (doubles): ">
    //  240  463:invokevirtual   #74  <Method void PrintStream.println(String)>
            for(int i = 0; i < doubles.length; i++)
    //* 241  466:iconst_0        
    //* 242  467:istore          5
    //* 243  469:goto            503
                System.out.print((new StringBuilder(String.valueOf(doubles[i]))).append(" ").toString());
    //  244  472:getstatic       #683 <Field PrintStream System.out>
    //  245  475:new             #91  <Class StringBuilder>
    //  246  478:dup             
    //  247  479:aload_2         
    //  248  480:iload           5
    //  249  482:daload          
    //  250  483:invokestatic    #718 <Method String String.valueOf(double)>
    //  251  486:invokespecial   #107 <Method void StringBuilder(String)>
    //  252  489:ldc1            #209 <String " ">
    //  253  491:invokevirtual   #118 <Method StringBuilder StringBuilder.append(String)>
    //  254  494:invokevirtual   #122 <Method String StringBuilder.toString()>
    //  255  497:invokevirtual   #721 <Method void PrintStream.print(String)>

    //  256  500:iinc            5  1
    //  257  503:iload           5
    //  258  505:aload_2         
    //  259  506:arraylength     
    //  260  507:icmplt          472
            System.out.println();
    //  261  510:getstatic       #683 <Field PrintStream System.out>
    //  262  513:invokevirtual   #723 <Method void PrintStream.println()>
            System.out.println("Original array (ints): ");
    //  263  516:getstatic       #683 <Field PrintStream System.out>
    //  264  519:ldc2            #727 <String "Original array (ints): ">
    //  265  522:invokevirtual   #74  <Method void PrintStream.println(String)>
            for(int i = 0; i < ints.length; i++)
    //* 266  525:iconst_0        
    //* 267  526:istore          5
    //* 268  528:goto            562
                System.out.print((new StringBuilder(String.valueOf(ints[i]))).append(" ").toString());
    //  269  531:getstatic       #683 <Field PrintStream System.out>
    //  270  534:new             #91  <Class StringBuilder>
    //  271  537:dup             
    //  272  538:aload_3         
    //  273  539:iload           5
    //  274  541:iaload          
    //  275  542:invokestatic    #228 <Method String String.valueOf(int)>
    //  276  545:invokespecial   #107 <Method void StringBuilder(String)>
    //  277  548:ldc1            #209 <String " ">
    //  278  550:invokevirtual   #118 <Method StringBuilder StringBuilder.append(String)>
    //  279  553:invokevirtual   #122 <Method String StringBuilder.toString()>
    //  280  556:invokevirtual   #721 <Method void PrintStream.print(String)>

    //  281  559:iinc            5  1
    //  282  562:iload           5
    //  283  564:aload_3         
    //  284  565:arraylength     
    //  285  566:icmplt          531
            System.out.println();
    //  286  569:getstatic       #683 <Field PrintStream System.out>
    //  287  572:invokevirtual   #723 <Method void PrintStream.println()>
            System.out.println((new StringBuilder("Correlation: ")).append(correlation(doubles, doubles, doubles.length)).toString());
    //  288  575:getstatic       #683 <Field PrintStream System.out>
    //  289  578:new             #91  <Class StringBuilder>
    //  290  581:dup             
    //  291  582:ldc2            #729 <String "Correlation: ">
    //  292  585:invokespecial   #107 <Method void StringBuilder(String)>
    //  293  588:aload_2         
    //  294  589:aload_2         
    //  295  590:aload_2         
    //  296  591:arraylength     
    //  297  592:invokestatic    #731 <Method double correlation(double[], double[], int)>
    //  298  595:invokevirtual   #252 <Method StringBuilder StringBuilder.append(double)>
    //  299  598:invokevirtual   #122 <Method String StringBuilder.toString()>
    //  300  601:invokevirtual   #74  <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Mean: ")).append(mean(doubles)).toString());
    //  301  604:getstatic       #683 <Field PrintStream System.out>
    //  302  607:new             #91  <Class StringBuilder>
    //  303  610:dup             
    //  304  611:ldc2            #733 <String "Mean: ">
    //  305  614:invokespecial   #107 <Method void StringBuilder(String)>
    //  306  617:aload_2         
    //  307  618:invokestatic    #735 <Method double mean(double[])>
    //  308  621:invokevirtual   #252 <Method StringBuilder StringBuilder.append(double)>
    //  309  624:invokevirtual   #122 <Method String StringBuilder.toString()>
    //  310  627:invokevirtual   #74  <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Variance: ")).append(variance(doubles)).toString());
    //  311  630:getstatic       #683 <Field PrintStream System.out>
    //  312  633:new             #91  <Class StringBuilder>
    //  313  636:dup             
    //  314  637:ldc2            #737 <String "Variance: ">
    //  315  640:invokespecial   #107 <Method void StringBuilder(String)>
    //  316  643:aload_2         
    //  317  644:invokestatic    #739 <Method double variance(double[])>
    //  318  647:invokevirtual   #252 <Method StringBuilder StringBuilder.append(double)>
    //  319  650:invokevirtual   #122 <Method String StringBuilder.toString()>
    //  320  653:invokevirtual   #74  <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Sum (doubles): ")).append(sum(doubles)).toString());
    //  321  656:getstatic       #683 <Field PrintStream System.out>
    //  322  659:new             #91  <Class StringBuilder>
    //  323  662:dup             
    //  324  663:ldc2            #741 <String "Sum (doubles): ">
    //  325  666:invokespecial   #107 <Method void StringBuilder(String)>
    //  326  669:aload_2         
    //  327  670:invokestatic    #743 <Method double sum(double[])>
    //  328  673:invokevirtual   #252 <Method StringBuilder StringBuilder.append(double)>
    //  329  676:invokevirtual   #122 <Method String StringBuilder.toString()>
    //  330  679:invokevirtual   #74  <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Sum (ints): ")).append(sum(ints)).toString());
    //  331  682:getstatic       #683 <Field PrintStream System.out>
    //  332  685:new             #91  <Class StringBuilder>
    //  333  688:dup             
    //  334  689:ldc2            #745 <String "Sum (ints): ">
    //  335  692:invokespecial   #107 <Method void StringBuilder(String)>
    //  336  695:aload_3         
    //  337  696:invokestatic    #747 <Method int sum(int[])>
    //  338  699:invokevirtual   #698 <Method StringBuilder StringBuilder.append(int)>
    //  339  702:invokevirtual   #122 <Method String StringBuilder.toString()>
    //  340  705:invokevirtual   #74  <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Max index (doubles): ")).append(maxIndex(doubles)).toString());
    //  341  708:getstatic       #683 <Field PrintStream System.out>
    //  342  711:new             #91  <Class StringBuilder>
    //  343  714:dup             
    //  344  715:ldc2            #749 <String "Max index (doubles): ">
    //  345  718:invokespecial   #107 <Method void StringBuilder(String)>
    //  346  721:aload_2         
    //  347  722:invokestatic    #542 <Method int maxIndex(double[])>
    //  348  725:invokevirtual   #698 <Method StringBuilder StringBuilder.append(int)>
    //  349  728:invokevirtual   #122 <Method String StringBuilder.toString()>
    //  350  731:invokevirtual   #74  <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Max index (ints): ")).append(maxIndex(ints)).toString());
    //  351  734:getstatic       #683 <Field PrintStream System.out>
    //  352  737:new             #91  <Class StringBuilder>
    //  353  740:dup             
    //  354  741:ldc2            #751 <String "Max index (ints): ">
    //  355  744:invokespecial   #107 <Method void StringBuilder(String)>
    //  356  747:aload_3         
    //  357  748:invokestatic    #753 <Method int maxIndex(int[])>
    //  358  751:invokevirtual   #698 <Method StringBuilder StringBuilder.append(int)>
    //  359  754:invokevirtual   #122 <Method String StringBuilder.toString()>
    //  360  757:invokevirtual   #74  <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Min index (doubles): ")).append(minIndex(doubles)).toString());
    //  361  760:getstatic       #683 <Field PrintStream System.out>
    //  362  763:new             #91  <Class StringBuilder>
    //  363  766:dup             
    //  364  767:ldc2            #755 <String "Min index (doubles): ">
    //  365  770:invokespecial   #107 <Method void StringBuilder(String)>
    //  366  773:aload_2         
    //  367  774:invokestatic    #757 <Method int minIndex(double[])>
    //  368  777:invokevirtual   #698 <Method StringBuilder StringBuilder.append(int)>
    //  369  780:invokevirtual   #122 <Method String StringBuilder.toString()>
    //  370  783:invokevirtual   #74  <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Min index (ints): ")).append(minIndex(ints)).toString());
    //  371  786:getstatic       #683 <Field PrintStream System.out>
    //  372  789:new             #91  <Class StringBuilder>
    //  373  792:dup             
    //  374  793:ldc2            #759 <String "Min index (ints): ">
    //  375  796:invokespecial   #107 <Method void StringBuilder(String)>
    //  376  799:aload_3         
    //  377  800:invokestatic    #761 <Method int minIndex(int[])>
    //  378  803:invokevirtual   #698 <Method StringBuilder StringBuilder.append(int)>
    //  379  806:invokevirtual   #122 <Method String StringBuilder.toString()>
    //  380  809:invokevirtual   #74  <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Median (doubles): ")).append(kthSmallestValue(doubles, doubles.length / 2)).toString());
    //  381  812:getstatic       #683 <Field PrintStream System.out>
    //  382  815:new             #91  <Class StringBuilder>
    //  383  818:dup             
    //  384  819:ldc2            #763 <String "Median (doubles): ">
    //  385  822:invokespecial   #107 <Method void StringBuilder(String)>
    //  386  825:aload_2         
    //  387  826:aload_2         
    //  388  827:arraylength     
    //  389  828:iconst_2        
    //  390  829:idiv            
    //  391  830:invokestatic    #765 <Method double kthSmallestValue(double[], int)>
    //  392  833:invokevirtual   #252 <Method StringBuilder StringBuilder.append(double)>
    //  393  836:invokevirtual   #122 <Method String StringBuilder.toString()>
    //  394  839:invokevirtual   #74  <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Median (ints): ")).append(kthSmallestValue(ints, ints.length / 2)).toString());
    //  395  842:getstatic       #683 <Field PrintStream System.out>
    //  396  845:new             #91  <Class StringBuilder>
    //  397  848:dup             
    //  398  849:ldc2            #767 <String "Median (ints): ">
    //  399  852:invokespecial   #107 <Method void StringBuilder(String)>
    //  400  855:aload_3         
    //  401  856:aload_3         
    //  402  857:arraylength     
    //  403  858:iconst_2        
    //  404  859:idiv            
    //  405  860:invokestatic    #769 <Method double kthSmallestValue(int[], int)>
    //  406  863:invokevirtual   #252 <Method StringBuilder StringBuilder.append(double)>
    //  407  866:invokevirtual   #122 <Method String StringBuilder.toString()>
    //  408  869:invokevirtual   #74  <Method void PrintStream.println(String)>
            System.out.println("Sorted array with NaN (doubles): ");
    //  409  872:getstatic       #683 <Field PrintStream System.out>
    //  410  875:ldc2            #771 <String "Sorted array with NaN (doubles): ">
    //  411  878:invokevirtual   #74  <Method void PrintStream.println(String)>
            int sorted[] = sort(doublesWithNaN);
    //  412  881:aload_1         
    //  413  882:invokestatic    #773 <Method int[] sort(double[])>
    //  414  885:astore          5
            for(int i = 0; i < doublesWithNaN.length; i++)
    //* 415  887:iconst_0        
    //* 416  888:istore          6
    //* 417  890:goto            927
                System.out.print((new StringBuilder(String.valueOf(doublesWithNaN[sorted[i]]))).append(" ").toString());
    //  418  893:getstatic       #683 <Field PrintStream System.out>
    //  419  896:new             #91  <Class StringBuilder>
    //  420  899:dup             
    //  421  900:aload_1         
    //  422  901:aload           5
    //  423  903:iload           6
    //  424  905:iaload          
    //  425  906:daload          
    //  426  907:invokestatic    #718 <Method String String.valueOf(double)>
    //  427  910:invokespecial   #107 <Method void StringBuilder(String)>
    //  428  913:ldc1            #209 <String " ">
    //  429  915:invokevirtual   #118 <Method StringBuilder StringBuilder.append(String)>
    //  430  918:invokevirtual   #122 <Method String StringBuilder.toString()>
    //  431  921:invokevirtual   #721 <Method void PrintStream.print(String)>

    //  432  924:iinc            6  1
    //  433  927:iload           6
    //  434  929:aload_1         
    //  435  930:arraylength     
    //  436  931:icmplt          893
            System.out.println();
    //  437  934:getstatic       #683 <Field PrintStream System.out>
    //  438  937:invokevirtual   #723 <Method void PrintStream.println()>
            System.out.println("Sorted array (doubles): ");
    //  439  940:getstatic       #683 <Field PrintStream System.out>
    //  440  943:ldc2            #775 <String "Sorted array (doubles): ">
    //  441  946:invokevirtual   #74  <Method void PrintStream.println(String)>
            sorted = sort(doubles);
    //  442  949:aload_2         
    //  443  950:invokestatic    #773 <Method int[] sort(double[])>
    //  444  953:astore          5
            for(int i = 0; i < doubles.length; i++)
    //* 445  955:iconst_0        
    //* 446  956:istore          6
    //* 447  958:goto            995
                System.out.print((new StringBuilder(String.valueOf(doubles[sorted[i]]))).append(" ").toString());
    //  448  961:getstatic       #683 <Field PrintStream System.out>
    //  449  964:new             #91  <Class StringBuilder>
    //  450  967:dup             
    //  451  968:aload_2         
    //  452  969:aload           5
    //  453  971:iload           6
    //  454  973:iaload          
    //  455  974:daload          
    //  456  975:invokestatic    #718 <Method String String.valueOf(double)>
    //  457  978:invokespecial   #107 <Method void StringBuilder(String)>
    //  458  981:ldc1            #209 <String " ">
    //  459  983:invokevirtual   #118 <Method StringBuilder StringBuilder.append(String)>
    //  460  986:invokevirtual   #122 <Method String StringBuilder.toString()>
    //  461  989:invokevirtual   #721 <Method void PrintStream.print(String)>

    //  462  992:iinc            6  1
    //  463  995:iload           6
    //  464  997:aload_2         
    //  465  998:arraylength     
    //  466  999:icmplt          961
            System.out.println();
    //  467 1002:getstatic       #683 <Field PrintStream System.out>
    //  468 1005:invokevirtual   #723 <Method void PrintStream.println()>
            System.out.println("Sorted array (ints): ");
    //  469 1008:getstatic       #683 <Field PrintStream System.out>
    //  470 1011:ldc2            #777 <String "Sorted array (ints): ">
    //  471 1014:invokevirtual   #74  <Method void PrintStream.println(String)>
            sorted = sort(ints);
    //  472 1017:aload_3         
    //  473 1018:invokestatic    #779 <Method int[] sort(int[])>
    //  474 1021:astore          5
            for(int i = 0; i < ints.length; i++)
    //* 475 1023:iconst_0        
    //* 476 1024:istore          6
    //* 477 1026:goto            1063
                System.out.print((new StringBuilder(String.valueOf(ints[sorted[i]]))).append(" ").toString());
    //  478 1029:getstatic       #683 <Field PrintStream System.out>
    //  479 1032:new             #91  <Class StringBuilder>
    //  480 1035:dup             
    //  481 1036:aload_3         
    //  482 1037:aload           5
    //  483 1039:iload           6
    //  484 1041:iaload          
    //  485 1042:iaload          
    //  486 1043:invokestatic    #228 <Method String String.valueOf(int)>
    //  487 1046:invokespecial   #107 <Method void StringBuilder(String)>
    //  488 1049:ldc1            #209 <String " ">
    //  489 1051:invokevirtual   #118 <Method StringBuilder StringBuilder.append(String)>
    //  490 1054:invokevirtual   #122 <Method String StringBuilder.toString()>
    //  491 1057:invokevirtual   #721 <Method void PrintStream.print(String)>

    //  492 1060:iinc            6  1
    //  493 1063:iload           6
    //  494 1065:aload_3         
    //  495 1066:arraylength     
    //  496 1067:icmplt          1029
            System.out.println();
    //  497 1070:getstatic       #683 <Field PrintStream System.out>
    //  498 1073:invokevirtual   #723 <Method void PrintStream.println()>
            System.out.println("Indices from stable sort (doubles): ");
    //  499 1076:getstatic       #683 <Field PrintStream System.out>
    //  500 1079:ldc2            #781 <String "Indices from stable sort (doubles): ">
    //  501 1082:invokevirtual   #74  <Method void PrintStream.println(String)>
            sorted = stableSort(doubles);
    //  502 1085:aload_2         
    //  503 1086:invokestatic    #783 <Method int[] stableSort(double[])>
    //  504 1089:astore          5
            for(int i = 0; i < doubles.length; i++)
    //* 505 1091:iconst_0        
    //* 506 1092:istore          6
    //* 507 1094:goto            1129
                System.out.print((new StringBuilder(String.valueOf(sorted[i]))).append(" ").toString());
    //  508 1097:getstatic       #683 <Field PrintStream System.out>
    //  509 1100:new             #91  <Class StringBuilder>
    //  510 1103:dup             
    //  511 1104:aload           5
    //  512 1106:iload           6
    //  513 1108:iaload          
    //  514 1109:invokestatic    #228 <Method String String.valueOf(int)>
    //  515 1112:invokespecial   #107 <Method void StringBuilder(String)>
    //  516 1115:ldc1            #209 <String " ">
    //  517 1117:invokevirtual   #118 <Method StringBuilder StringBuilder.append(String)>
    //  518 1120:invokevirtual   #122 <Method String StringBuilder.toString()>
    //  519 1123:invokevirtual   #721 <Method void PrintStream.print(String)>

    //  520 1126:iinc            6  1
    //  521 1129:iload           6
    //  522 1131:aload_2         
    //  523 1132:arraylength     
    //  524 1133:icmplt          1097
            System.out.println();
    //  525 1136:getstatic       #683 <Field PrintStream System.out>
    //  526 1139:invokevirtual   #723 <Method void PrintStream.println()>
            System.out.println("Indices from sort (ints): ");
    //  527 1142:getstatic       #683 <Field PrintStream System.out>
    //  528 1145:ldc2            #785 <String "Indices from sort (ints): ">
    //  529 1148:invokevirtual   #74  <Method void PrintStream.println(String)>
            sorted = sort(ints);
    //  530 1151:aload_3         
    //  531 1152:invokestatic    #779 <Method int[] sort(int[])>
    //  532 1155:astore          5
            for(int i = 0; i < ints.length; i++)
    //* 533 1157:iconst_0        
    //* 534 1158:istore          6
    //* 535 1160:goto            1195
                System.out.print((new StringBuilder(String.valueOf(sorted[i]))).append(" ").toString());
    //  536 1163:getstatic       #683 <Field PrintStream System.out>
    //  537 1166:new             #91  <Class StringBuilder>
    //  538 1169:dup             
    //  539 1170:aload           5
    //  540 1172:iload           6
    //  541 1174:iaload          
    //  542 1175:invokestatic    #228 <Method String String.valueOf(int)>
    //  543 1178:invokespecial   #107 <Method void StringBuilder(String)>
    //  544 1181:ldc1            #209 <String " ">
    //  545 1183:invokevirtual   #118 <Method StringBuilder StringBuilder.append(String)>
    //  546 1186:invokevirtual   #122 <Method String StringBuilder.toString()>
    //  547 1189:invokevirtual   #721 <Method void PrintStream.print(String)>

    //  548 1192:iinc            6  1
    //  549 1195:iload           6
    //  550 1197:aload_3         
    //  551 1198:arraylength     
    //  552 1199:icmplt          1163
            System.out.println();
    //  553 1202:getstatic       #683 <Field PrintStream System.out>
    //  554 1205:invokevirtual   #723 <Method void PrintStream.println()>
            System.out.println("Normalized array (doubles): ");
    //  555 1208:getstatic       #683 <Field PrintStream System.out>
    //  556 1211:ldc2            #787 <String "Normalized array (doubles): ">
    //  557 1214:invokevirtual   #74  <Method void PrintStream.println(String)>
            normalize(doubles);
    //  558 1217:aload_2         
    //  559 1218:invokestatic    #789 <Method void normalize(double[])>
            for(int i = 0; i < doubles.length; i++)
    //* 560 1221:iconst_0        
    //* 561 1222:istore          6
    //* 562 1224:goto            1258
                System.out.print((new StringBuilder(String.valueOf(doubles[i]))).append(" ").toString());
    //  563 1227:getstatic       #683 <Field PrintStream System.out>
    //  564 1230:new             #91  <Class StringBuilder>
    //  565 1233:dup             
    //  566 1234:aload_2         
    //  567 1235:iload           6
    //  568 1237:daload          
    //  569 1238:invokestatic    #718 <Method String String.valueOf(double)>
    //  570 1241:invokespecial   #107 <Method void StringBuilder(String)>
    //  571 1244:ldc1            #209 <String " ">
    //  572 1246:invokevirtual   #118 <Method StringBuilder StringBuilder.append(String)>
    //  573 1249:invokevirtual   #122 <Method String StringBuilder.toString()>
    //  574 1252:invokevirtual   #721 <Method void PrintStream.print(String)>

    //  575 1255:iinc            6  1
    //  576 1258:iload           6
    //  577 1260:aload_2         
    //  578 1261:arraylength     
    //  579 1262:icmplt          1227
            System.out.println();
    //  580 1265:getstatic       #683 <Field PrintStream System.out>
    //  581 1268:invokevirtual   #723 <Method void PrintStream.println()>
            System.out.println("Normalized again (doubles): ");
    //  582 1271:getstatic       #683 <Field PrintStream System.out>
    //  583 1274:ldc2            #791 <String "Normalized again (doubles): ">
    //  584 1277:invokevirtual   #74  <Method void PrintStream.println(String)>
            normalize(doubles, sum(doubles));
    //  585 1280:aload_2         
    //  586 1281:aload_2         
    //  587 1282:invokestatic    #743 <Method double sum(double[])>
    //  588 1285:invokestatic    #527 <Method void normalize(double[], double)>
            for(int i = 0; i < doubles.length; i++)
    //* 589 1288:iconst_0        
    //* 590 1289:istore          6
    //* 591 1291:goto            1325
                System.out.print((new StringBuilder(String.valueOf(doubles[i]))).append(" ").toString());
    //  592 1294:getstatic       #683 <Field PrintStream System.out>
    //  593 1297:new             #91  <Class StringBuilder>
    //  594 1300:dup             
    //  595 1301:aload_2         
    //  596 1302:iload           6
    //  597 1304:daload          
    //  598 1305:invokestatic    #718 <Method String String.valueOf(double)>
    //  599 1308:invokespecial   #107 <Method void StringBuilder(String)>
    //  600 1311:ldc1            #209 <String " ">
    //  601 1313:invokevirtual   #118 <Method StringBuilder StringBuilder.append(String)>
    //  602 1316:invokevirtual   #122 <Method String StringBuilder.toString()>
    //  603 1319:invokevirtual   #721 <Method void PrintStream.print(String)>

    //  604 1322:iinc            6  1
    //  605 1325:iload           6
    //  606 1327:aload_2         
    //  607 1328:arraylength     
    //  608 1329:icmplt          1294
            System.out.println();
    //  609 1332:getstatic       #683 <Field PrintStream System.out>
    //  610 1335:invokevirtual   #723 <Method void PrintStream.println()>
            System.out.println((new StringBuilder("-4.58: ")).append(doubleToString(-4.5782653499999997D, 2)).toString());
    //  611 1338:getstatic       #683 <Field PrintStream System.out>
    //  612 1341:new             #91  <Class StringBuilder>
    //  613 1344:dup             
    //  614 1345:ldc2            #793 <String "-4.58: ">
    //  615 1348:invokespecial   #107 <Method void StringBuilder(String)>
    //  616 1351:ldc2w           #794 <Double -4.5782653499999997D>
    //  617 1354:iconst_2        
    //  618 1355:invokestatic    #264 <Method String doubleToString(double, int)>
    //  619 1358:invokevirtual   #118 <Method StringBuilder StringBuilder.append(String)>
    //  620 1361:invokevirtual   #122 <Method String StringBuilder.toString()>
    //  621 1364:invokevirtual   #74  <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("-6.78: ")).append(doubleToString(-6.78214234D, 6, 2)).toString());
    //  622 1367:getstatic       #683 <Field PrintStream System.out>
    //  623 1370:new             #91  <Class StringBuilder>
    //  624 1373:dup             
    //  625 1374:ldc2            #797 <String "-6.78: ">
    //  626 1377:invokespecial   #107 <Method void StringBuilder(String)>
    //  627 1380:ldc2w           #798 <Double -6.78214234D>
    //  628 1383:bipush          6
    //  629 1385:iconst_2        
    //  630 1386:invokestatic    #801 <Method String doubleToString(double, int, int)>
    //  631 1389:invokevirtual   #118 <Method StringBuilder StringBuilder.append(String)>
    //  632 1392:invokevirtual   #122 <Method String StringBuilder.toString()>
    //  633 1395:invokevirtual   #74  <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("5.70001 == 5.7 ? ")).append(eq(5.7000099999999998D, 5.7000000000000002D)).toString());
    //  634 1398:getstatic       #683 <Field PrintStream System.out>
    //  635 1401:new             #91  <Class StringBuilder>
    //  636 1404:dup             
    //  637 1405:ldc2            #803 <String "5.70001 == 5.7 ? ">
    //  638 1408:invokespecial   #107 <Method void StringBuilder(String)>
    //  639 1411:ldc2w           #804 <Double 5.7000099999999998D>
    //  640 1414:ldc2w           #806 <Double 5.7000000000000002D>
    //  641 1417:invokestatic    #600 <Method boolean eq(double, double)>
    //  642 1420:invokevirtual   #705 <Method StringBuilder StringBuilder.append(boolean)>
    //  643 1423:invokevirtual   #122 <Method String StringBuilder.toString()>
    //  644 1426:invokevirtual   #74  <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("5.70001 > 5.7 ? ")).append(gr(5.7000099999999998D, 5.7000000000000002D)).toString());
    //  645 1429:getstatic       #683 <Field PrintStream System.out>
    //  646 1432:new             #91  <Class StringBuilder>
    //  647 1435:dup             
    //  648 1436:ldc2            #809 <String "5.70001 > 5.7 ? ">
    //  649 1439:invokespecial   #107 <Method void StringBuilder(String)>
    //  650 1442:ldc2w           #804 <Double 5.7000099999999998D>
    //  651 1445:ldc2w           #806 <Double 5.7000000000000002D>
    //  652 1448:invokestatic    #549 <Method boolean gr(double, double)>
    //  653 1451:invokevirtual   #705 <Method StringBuilder StringBuilder.append(boolean)>
    //  654 1454:invokevirtual   #122 <Method String StringBuilder.toString()>
    //  655 1457:invokevirtual   #74  <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("5.70001 >= 5.7 ? ")).append(grOrEq(5.7000099999999998D, 5.7000000000000002D)).toString());
    //  656 1460:getstatic       #683 <Field PrintStream System.out>
    //  657 1463:new             #91  <Class StringBuilder>
    //  658 1466:dup             
    //  659 1467:ldc2            #811 <String "5.70001 >= 5.7 ? ">
    //  660 1470:invokespecial   #107 <Method void StringBuilder(String)>
    //  661 1473:ldc2w           #804 <Double 5.7000099999999998D>
    //  662 1476:ldc2w           #806 <Double 5.7000000000000002D>
    //  663 1479:invokestatic    #813 <Method boolean grOrEq(double, double)>
    //  664 1482:invokevirtual   #705 <Method StringBuilder StringBuilder.append(boolean)>
    //  665 1485:invokevirtual   #122 <Method String StringBuilder.toString()>
    //  666 1488:invokevirtual   #74  <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("5.7 < 5.70001 ? ")).append(sm(5.7000000000000002D, 5.7000099999999998D)).toString());
    //  667 1491:getstatic       #683 <Field PrintStream System.out>
    //  668 1494:new             #91  <Class StringBuilder>
    //  669 1497:dup             
    //  670 1498:ldc2            #815 <String "5.7 < 5.70001 ? ">
    //  671 1501:invokespecial   #107 <Method void StringBuilder(String)>
    //  672 1504:ldc2w           #806 <Double 5.7000000000000002D>
    //  673 1507:ldc2w           #804 <Double 5.7000099999999998D>
    //  674 1510:invokestatic    #551 <Method boolean sm(double, double)>
    //  675 1513:invokevirtual   #705 <Method StringBuilder StringBuilder.append(boolean)>
    //  676 1516:invokevirtual   #122 <Method String StringBuilder.toString()>
    //  677 1519:invokevirtual   #74  <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("5.7 <= 5.70001 ? ")).append(smOrEq(5.7000000000000002D, 5.7000099999999998D)).toString());
    //  678 1522:getstatic       #683 <Field PrintStream System.out>
    //  679 1525:new             #91  <Class StringBuilder>
    //  680 1528:dup             
    //  681 1529:ldc2            #817 <String "5.7 <= 5.70001 ? ">
    //  682 1532:invokespecial   #107 <Method void StringBuilder(String)>
    //  683 1535:ldc2w           #806 <Double 5.7000000000000002D>
    //  684 1538:ldc2w           #804 <Double 5.7000099999999998D>
    //  685 1541:invokestatic    #819 <Method boolean smOrEq(double, double)>
    //  686 1544:invokevirtual   #705 <Method StringBuilder StringBuilder.append(boolean)>
    //  687 1547:invokevirtual   #122 <Method String StringBuilder.toString()>
    //  688 1550:invokevirtual   #74  <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Info (ints): ")).append(info(ints)).toString());
    //  689 1553:getstatic       #683 <Field PrintStream System.out>
    //  690 1556:new             #91  <Class StringBuilder>
    //  691 1559:dup             
    //  692 1560:ldc2            #821 <String "Info (ints): ">
    //  693 1563:invokespecial   #107 <Method void StringBuilder(String)>
    //  694 1566:aload_3         
    //  695 1567:invokestatic    #823 <Method double info(int[])>
    //  696 1570:invokevirtual   #252 <Method StringBuilder StringBuilder.append(double)>
    //  697 1573:invokevirtual   #122 <Method String StringBuilder.toString()>
    //  698 1576:invokevirtual   #74  <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("log2(4.6): ")).append(log2(4.5999999999999996D)).toString());
    //  699 1579:getstatic       #683 <Field PrintStream System.out>
    //  700 1582:new             #91  <Class StringBuilder>
    //  701 1585:dup             
    //  702 1586:ldc2            #825 <String "log2(4.6): ">
    //  703 1589:invokespecial   #107 <Method void StringBuilder(String)>
    //  704 1592:ldc2w           #826 <Double 4.5999999999999996D>
    //  705 1595:invokestatic    #604 <Method double log2(double)>
    //  706 1598:invokevirtual   #252 <Method StringBuilder StringBuilder.append(double)>
    //  707 1601:invokevirtual   #122 <Method String StringBuilder.toString()>
    //  708 1604:invokevirtual   #74  <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("5 * log(5): ")).append(xlogx(5)).toString());
    //  709 1607:getstatic       #683 <Field PrintStream System.out>
    //  710 1610:new             #91  <Class StringBuilder>
    //  711 1613:dup             
    //  712 1614:ldc2            #829 <String "5 * log(5): ">
    //  713 1617:invokespecial   #107 <Method void StringBuilder(String)>
    //  714 1620:iconst_5        
    //  715 1621:invokestatic    #492 <Method double xlogx(int)>
    //  716 1624:invokevirtual   #252 <Method StringBuilder StringBuilder.append(double)>
    //  717 1627:invokevirtual   #122 <Method String StringBuilder.toString()>
    //  718 1630:invokevirtual   #74  <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("5.5 rounded: ")).append(round(5.5D)).toString());
    //  719 1633:getstatic       #683 <Field PrintStream System.out>
    //  720 1636:new             #91  <Class StringBuilder>
    //  721 1639:dup             
    //  722 1640:ldc2            #831 <String "5.5 rounded: ">
    //  723 1643:invokespecial   #107 <Method void StringBuilder(String)>
    //  724 1646:ldc2w           #832 <Double 5.5D>
    //  725 1649:invokestatic    #835 <Method int round(double)>
    //  726 1652:invokevirtual   #698 <Method StringBuilder StringBuilder.append(int)>
    //  727 1655:invokevirtual   #122 <Method String StringBuilder.toString()>
    //  728 1658:invokevirtual   #74  <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("5.55555 rounded to 2 decimal places: ")).append(roundDouble(5.5555500000000002D, 2)).toString());
    //  729 1661:getstatic       #683 <Field PrintStream System.out>
    //  730 1664:new             #91  <Class StringBuilder>
    //  731 1667:dup             
    //  732 1668:ldc2            #837 <String "5.55555 rounded to 2 decimal places: ">
    //  733 1671:invokespecial   #107 <Method void StringBuilder(String)>
    //  734 1674:ldc2w           #838 <Double 5.5555500000000002D>
    //  735 1677:iconst_2        
    //  736 1678:invokestatic    #841 <Method double roundDouble(double, int)>
    //  737 1681:invokevirtual   #252 <Method StringBuilder StringBuilder.append(double)>
    //  738 1684:invokevirtual   #122 <Method String StringBuilder.toString()>
    //  739 1687:invokevirtual   #74  <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Array-Dimensions of 'new int[][]': ")).append(getArrayDimensions(new int[0][])).toString());
    //  740 1690:getstatic       #683 <Field PrintStream System.out>
    //  741 1693:new             #91  <Class StringBuilder>
    //  742 1696:dup             
    //  743 1697:ldc2            #843 <String "Array-Dimensions of 'new int[][]': ">
    //  744 1700:invokespecial   #107 <Method void StringBuilder(String)>
    //  745 1703:iconst_0        
    //  746 1704:anewarray       int[][]
    //  747 1707:invokestatic    #297 <Method int getArrayDimensions(Object)>
    //  748 1710:invokevirtual   #698 <Method StringBuilder StringBuilder.append(int)>
    //  749 1713:invokevirtual   #122 <Method String StringBuilder.toString()>
    //  750 1716:invokevirtual   #74  <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Array-Dimensions of 'new int[][]{{1,2,3},{4,5,6}}': ")).append(getArrayDimensions(new int[][] {
                new int[] {
                    1, 2, 3
                }, new int[] {
                    4, 5, 6
                }
            })).toString());
    //  751 1719:getstatic       #683 <Field PrintStream System.out>
    //  752 1722:new             #91  <Class StringBuilder>
    //  753 1725:dup             
    //  754 1726:ldc2            #846 <String "Array-Dimensions of 'new int[][]{{1,2,3},{4,5,6}}': ">
    //  755 1729:invokespecial   #107 <Method void StringBuilder(String)>
    //  756 1732:iconst_2        
    //  757 1733:anewarray       int[][]
    //  758 1736:dup             
    //  759 1737:iconst_0        
    //  760 1738:iconst_3        
    //  761 1739:newarray        int[]
    //  762 1741:dup             
    //  763 1742:iconst_0        
    //  764 1743:iconst_1        
    //  765 1744:iastore         
    //  766 1745:dup             
    //  767 1746:iconst_1        
    //  768 1747:iconst_2        
    //  769 1748:iastore         
    //  770 1749:dup             
    //  771 1750:iconst_2        
    //  772 1751:iconst_3        
    //  773 1752:iastore         
    //  774 1753:aastore         
    //  775 1754:dup             
    //  776 1755:iconst_1        
    //  777 1756:iconst_3        
    //  778 1757:newarray        int[]
    //  779 1759:dup             
    //  780 1760:iconst_0        
    //  781 1761:iconst_4        
    //  782 1762:iastore         
    //  783 1763:dup             
    //  784 1764:iconst_1        
    //  785 1765:iconst_5        
    //  786 1766:iastore         
    //  787 1767:dup             
    //  788 1768:iconst_2        
    //  789 1769:bipush          6
    //  790 1771:iastore         
    //  791 1772:aastore         
    //  792 1773:invokestatic    #297 <Method int getArrayDimensions(Object)>
    //  793 1776:invokevirtual   #698 <Method StringBuilder StringBuilder.append(int)>
    //  794 1779:invokevirtual   #122 <Method String StringBuilder.toString()>
    //  795 1782:invokevirtual   #74  <Method void PrintStream.println(String)>
            String s[][][] = new String[3][4][];
    //  796 1785:iconst_3        
    //  797 1786:iconst_4        
    //  798 1787:multianewarray  String[][][]
    //  799 1791:astore          6
            System.out.println((new StringBuilder("Array-Dimensions of 'new String[3][4][]': ")).append(getArrayDimensions(s)).toString());
    //  800 1793:getstatic       #683 <Field PrintStream System.out>
    //  801 1796:new             #91  <Class StringBuilder>
    //  802 1799:dup             
    //  803 1800:ldc2            #850 <String "Array-Dimensions of 'new String[3][4][]': ">
    //  804 1803:invokespecial   #107 <Method void StringBuilder(String)>
    //  805 1806:aload           6
    //  806 1808:invokestatic    #297 <Method int getArrayDimensions(Object)>
    //  807 1811:invokevirtual   #698 <Method StringBuilder StringBuilder.append(int)>
    //  808 1814:invokevirtual   #122 <Method String StringBuilder.toString()>
    //  809 1817:invokevirtual   #74  <Method void PrintStream.println(String)>
        }
    //* 810 1820:goto            1830
        catch(Exception e)
    //* 811 1823:astore          4
        {
            e.printStackTrace();
    //  812 1825:aload           4
    //  813 1827:invokevirtual   #853 <Method void Exception.printStackTrace()>
        }
    //  814 1830:return          
    }

    public static double log2 = Math.log(2D);
    public static double SMALL = 9.9999999999999995E-007D;

    static 
    {
    //    0    0:ldc2w           #11  <Double 2D>
    //    1    3:invokestatic    #18  <Method double Math.log(double)>
    //    2    6:putstatic       #20  <Field double log2>
    //    3    9:ldc2w           #21  <Double 9.9999999999999995E-007D>
    //    4   12:putstatic       #24  <Field double SMALL>
    //*   5   15:return          
    }
}
