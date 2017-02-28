// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   Stats.java

package rm.core;

import java.io.*;
import java.util.StringTokenizer;

// Referenced classes of package rm.core:
//            Utils

public class Stats
    implements Serializable
{

    public Stats()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #19  <Method void Object()>
        count = 0.0D;
    //    2    4:aload_0         
    //    3    5:dconst_0        
    //    4    6:putfield        #21  <Field double count>
        sum = 0.0D;
    //    5    9:aload_0         
    //    6   10:dconst_0        
    //    7   11:putfield        #23  <Field double sum>
        sumSq = 0.0D;
    //    8   14:aload_0         
    //    9   15:dconst_0        
    //   10   16:putfield        #25  <Field double sumSq>
        stdDev = (0.0D / 0.0D);
    //   11   19:aload_0         
    //   12   20:ldc2w           #26  <Double (0.0D / 0.0D)>
    //   13   23:putfield        #29  <Field double stdDev>
        mean = (0.0D / 0.0D);
    //   14   26:aload_0         
    //   15   27:ldc2w           #30  <Double (0.0D / 0.0D)>
    //   16   30:putfield        #33  <Field double mean>
        min = (0.0D / 0.0D);
    //   17   33:aload_0         
    //   18   34:ldc2w           #34  <Double (0.0D / 0.0D)>
    //   19   37:putfield        #37  <Field double min>
        max = (0.0D / 0.0D);
    //   20   40:aload_0         
    //   21   41:ldc2w           #38  <Double (0.0D / 0.0D)>
    //   22   44:putfield        #41  <Field double max>
    //   23   47:return          
    }

    public void add(double value)
    {
        add(value, 1.0D);
    //    0    0:aload_0         
    //    1    1:dload_1         
    //    2    2:dconst_1        
    //    3    3:invokevirtual   #50  <Method void add(double, double)>
    //    4    6:return          
    }

    public void add(double value, double n)
    {
        sum += value * n;
    //    0    0:aload_0         
    //    1    1:dup             
    //    2    2:getfield        #23  <Field double sum>
    //    3    5:dload_1         
    //    4    6:dload_3         
    //    5    7:dmul            
    //    6    8:dadd            
    //    7    9:putfield        #23  <Field double sum>
        sumSq += value * value * n;
    //    8   12:aload_0         
    //    9   13:dup             
    //   10   14:getfield        #25  <Field double sumSq>
    //   11   17:dload_1         
    //   12   18:dload_1         
    //   13   19:dmul            
    //   14   20:dload_3         
    //   15   21:dmul            
    //   16   22:dadd            
    //   17   23:putfield        #25  <Field double sumSq>
        count += n;
    //   18   26:aload_0         
    //   19   27:dup             
    //   20   28:getfield        #21  <Field double count>
    //   21   31:dload_3         
    //   22   32:dadd            
    //   23   33:putfield        #21  <Field double count>
        if(Double.isNaN(min))
    //*  24   36:aload_0         
    //*  25   37:getfield        #37  <Field double min>
    //*  26   40:invokestatic    #57  <Method boolean Double.isNaN(double)>
    //*  27   43:ifeq            59
            min = max = value;
    //   28   46:aload_0         
    //   29   47:aload_0         
    //   30   48:dload_1         
    //   31   49:dup2_x1         
    //   32   50:putfield        #41  <Field double max>
    //   33   53:putfield        #37  <Field double min>
        else
    //*  34   56:goto            90
        if(value < min)
    //*  35   59:dload_1         
    //*  36   60:aload_0         
    //*  37   61:getfield        #37  <Field double min>
    //*  38   64:dcmpg           
    //*  39   65:ifge            76
            min = value;
    //   40   68:aload_0         
    //   41   69:dload_1         
    //   42   70:putfield        #37  <Field double min>
        else
    //*  43   73:goto            90
        if(value > max)
    //*  44   76:dload_1         
    //*  45   77:aload_0         
    //*  46   78:getfield        #41  <Field double max>
    //*  47   81:dcmpl           
    //*  48   82:ifle            90
            max = value;
    //   49   85:aload_0         
    //   50   86:dload_1         
    //   51   87:putfield        #41  <Field double max>
    //   52   90:return          
    }

    public void subtract(double value)
    {
        subtract(value, 1.0D);
    //    0    0:aload_0         
    //    1    1:dload_1         
    //    2    2:dconst_1        
    //    3    3:invokevirtual   #61  <Method void subtract(double, double)>
    //    4    6:return          
    }

    public void subtract(double value, double n)
    {
        sum -= value * n;
    //    0    0:aload_0         
    //    1    1:dup             
    //    2    2:getfield        #23  <Field double sum>
    //    3    5:dload_1         
    //    4    6:dload_3         
    //    5    7:dmul            
    //    6    8:dsub            
    //    7    9:putfield        #23  <Field double sum>
        sumSq -= value * value * n;
    //    8   12:aload_0         
    //    9   13:dup             
    //   10   14:getfield        #25  <Field double sumSq>
    //   11   17:dload_1         
    //   12   18:dload_1         
    //   13   19:dmul            
    //   14   20:dload_3         
    //   15   21:dmul            
    //   16   22:dsub            
    //   17   23:putfield        #25  <Field double sumSq>
        count -= n;
    //   18   26:aload_0         
    //   19   27:dup             
    //   20   28:getfield        #21  <Field double count>
    //   21   31:dload_3         
    //   22   32:dsub            
    //   23   33:putfield        #21  <Field double count>
    //   24   36:return          
    }

    public void calculateDerived()
    {
        mean = (0.0D / 0.0D);
    //    0    0:aload_0         
    //    1    1:ldc2w           #63  <Double (0.0D / 0.0D)>
    //    2    4:putfield        #33  <Field double mean>
        stdDev = (0.0D / 0.0D);
    //    3    7:aload_0         
    //    4    8:ldc2w           #65  <Double (0.0D / 0.0D)>
    //    5   11:putfield        #29  <Field double stdDev>
        if(count > 0.0D)
    //*   6   14:aload_0         
    //*   7   15:getfield        #21  <Field double count>
    //*   8   18:dconst_0        
    //*   9   19:dcmpl           
    //*  10   20:ifle            115
        {
            mean = sum / count;
    //   11   23:aload_0         
    //   12   24:aload_0         
    //   13   25:getfield        #23  <Field double sum>
    //   14   28:aload_0         
    //   15   29:getfield        #21  <Field double count>
    //   16   32:ddiv            
    //   17   33:putfield        #33  <Field double mean>
            stdDev = (1.0D / 0.0D);
    //   18   36:aload_0         
    //   19   37:ldc2w           #67  <Double (1.0D / 0.0D)>
    //   20   40:putfield        #29  <Field double stdDev>
            if(count > 1.0D)
    //*  21   43:aload_0         
    //*  22   44:getfield        #21  <Field double count>
    //*  23   47:dconst_1        
    //*  24   48:dcmpl           
    //*  25   49:ifle            115
            {
                stdDev = sumSq - (sum * sum) / count;
    //   26   52:aload_0         
    //   27   53:aload_0         
    //   28   54:getfield        #25  <Field double sumSq>
    //   29   57:aload_0         
    //   30   58:getfield        #23  <Field double sum>
    //   31   61:aload_0         
    //   32   62:getfield        #23  <Field double sum>
    //   33   65:dmul            
    //   34   66:aload_0         
    //   35   67:getfield        #21  <Field double count>
    //   36   70:ddiv            
    //   37   71:dsub            
    //   38   72:putfield        #29  <Field double stdDev>
                stdDev /= count - 1.0D;
    //   39   75:aload_0         
    //   40   76:dup             
    //   41   77:getfield        #29  <Field double stdDev>
    //   42   80:aload_0         
    //   43   81:getfield        #21  <Field double count>
    //   44   84:dconst_1        
    //   45   85:dsub            
    //   46   86:ddiv            
    //   47   87:putfield        #29  <Field double stdDev>
                if(stdDev < 0.0D)
    //*  48   90:aload_0         
    //*  49   91:getfield        #29  <Field double stdDev>
    //*  50   94:dconst_0        
    //*  51   95:dcmpg           
    //*  52   96:ifge            104
                    stdDev = 0.0D;
    //   53   99:aload_0         
    //   54  100:dconst_0        
    //   55  101:putfield        #29  <Field double stdDev>
                stdDev = Math.sqrt(stdDev);
    //   56  104:aload_0         
    //   57  105:aload_0         
    //   58  106:getfield        #29  <Field double stdDev>
    //   59  109:invokestatic    #74  <Method double Math.sqrt(double)>
    //   60  112:putfield        #29  <Field double stdDev>
            }
        }
    //   61  115:return          
    }

    public String toString()
    {
        calculateDerived();
    //    0    0:aload_0         
    //    1    1:invokevirtual   #78  <Method void calculateDerived()>
        return (new StringBuilder("Count   ")).append(Utils.doubleToString(count, 8)).append('\n').append("Min     ").append(Utils.doubleToString(min, 8)).append('\n').append("Max     ").append(Utils.doubleToString(max, 8)).append('\n').append("Sum     ").append(Utils.doubleToString(sum, 8)).append('\n').append("SumSq   ").append(Utils.doubleToString(sumSq, 8)).append('\n').append("Mean    ").append(Utils.doubleToString(mean, 8)).append('\n').append("StdDev  ").append(Utils.doubleToString(stdDev, 8)).append('\n').toString();
    //    2    4:new             #80  <Class StringBuilder>
    //    3    7:dup             
    //    4    8:ldc1            #82  <String "Count   ">
    //    5   10:invokespecial   #85  <Method void StringBuilder(String)>
    //    6   13:aload_0         
    //    7   14:getfield        #21  <Field double count>
    //    8   17:bipush          8
    //    9   19:invokestatic    #91  <Method String Utils.doubleToString(double, int)>
    //   10   22:invokevirtual   #95  <Method StringBuilder StringBuilder.append(String)>
    //   11   25:bipush          10
    //   12   27:invokevirtual   #98  <Method StringBuilder StringBuilder.append(char)>
    //   13   30:ldc1            #100 <String "Min     ">
    //   14   32:invokevirtual   #95  <Method StringBuilder StringBuilder.append(String)>
    //   15   35:aload_0         
    //   16   36:getfield        #37  <Field double min>
    //   17   39:bipush          8
    //   18   41:invokestatic    #91  <Method String Utils.doubleToString(double, int)>
    //   19   44:invokevirtual   #95  <Method StringBuilder StringBuilder.append(String)>
    //   20   47:bipush          10
    //   21   49:invokevirtual   #98  <Method StringBuilder StringBuilder.append(char)>
    //   22   52:ldc1            #102 <String "Max     ">
    //   23   54:invokevirtual   #95  <Method StringBuilder StringBuilder.append(String)>
    //   24   57:aload_0         
    //   25   58:getfield        #41  <Field double max>
    //   26   61:bipush          8
    //   27   63:invokestatic    #91  <Method String Utils.doubleToString(double, int)>
    //   28   66:invokevirtual   #95  <Method StringBuilder StringBuilder.append(String)>
    //   29   69:bipush          10
    //   30   71:invokevirtual   #98  <Method StringBuilder StringBuilder.append(char)>
    //   31   74:ldc1            #104 <String "Sum     ">
    //   32   76:invokevirtual   #95  <Method StringBuilder StringBuilder.append(String)>
    //   33   79:aload_0         
    //   34   80:getfield        #23  <Field double sum>
    //   35   83:bipush          8
    //   36   85:invokestatic    #91  <Method String Utils.doubleToString(double, int)>
    //   37   88:invokevirtual   #95  <Method StringBuilder StringBuilder.append(String)>
    //   38   91:bipush          10
    //   39   93:invokevirtual   #98  <Method StringBuilder StringBuilder.append(char)>
    //   40   96:ldc1            #106 <String "SumSq   ">
    //   41   98:invokevirtual   #95  <Method StringBuilder StringBuilder.append(String)>
    //   42  101:aload_0         
    //   43  102:getfield        #25  <Field double sumSq>
    //   44  105:bipush          8
    //   45  107:invokestatic    #91  <Method String Utils.doubleToString(double, int)>
    //   46  110:invokevirtual   #95  <Method StringBuilder StringBuilder.append(String)>
    //   47  113:bipush          10
    //   48  115:invokevirtual   #98  <Method StringBuilder StringBuilder.append(char)>
    //   49  118:ldc1            #108 <String "Mean    ">
    //   50  120:invokevirtual   #95  <Method StringBuilder StringBuilder.append(String)>
    //   51  123:aload_0         
    //   52  124:getfield        #33  <Field double mean>
    //   53  127:bipush          8
    //   54  129:invokestatic    #91  <Method String Utils.doubleToString(double, int)>
    //   55  132:invokevirtual   #95  <Method StringBuilder StringBuilder.append(String)>
    //   56  135:bipush          10
    //   57  137:invokevirtual   #98  <Method StringBuilder StringBuilder.append(char)>
    //   58  140:ldc1            #110 <String "StdDev  ">
    //   59  142:invokevirtual   #95  <Method StringBuilder StringBuilder.append(String)>
    //   60  145:aload_0         
    //   61  146:getfield        #29  <Field double stdDev>
    //   62  149:bipush          8
    //   63  151:invokestatic    #91  <Method String Utils.doubleToString(double, int)>
    //   64  154:invokevirtual   #95  <Method StringBuilder StringBuilder.append(String)>
    //   65  157:bipush          10
    //   66  159:invokevirtual   #98  <Method StringBuilder StringBuilder.append(char)>
    //   67  162:invokevirtual   #112 <Method String StringBuilder.toString()>
    //   68  165:areturn         
    }

    public static void main(String args[])
    {
        try
        {
            Stats ps = new Stats();
    //    0    0:new             #2   <Class Stats>
    //    1    3:dup             
    //    2    4:invokespecial   #115 <Method void Stats()>
    //    3    7:astore_1        
            LineNumberReader r = new LineNumberReader(new InputStreamReader(System.in));
    //    4    8:new             #117 <Class LineNumberReader>
    //    5   11:dup             
    //    6   12:new             #119 <Class InputStreamReader>
    //    7   15:dup             
    //    8   16:getstatic       #125 <Field java.io.InputStream System.in>
    //    9   19:invokespecial   #128 <Method void InputStreamReader(java.io.InputStream)>
    //   10   22:invokespecial   #131 <Method void LineNumberReader(java.io.Reader)>
    //   11   25:astore_2        
    //*  12   26:goto            167
            String line;
            while((line = r.readLine()) != null) 
            {
                line = line.trim();
    //   13   29:aload_3         
    //   14   30:invokevirtual   #136 <Method String String.trim()>
    //   15   33:astore_3        
                if(!line.equals("") && !line.startsWith("@") && !line.startsWith("%"))
    //*  16   34:aload_3         
    //*  17   35:ldc1            #138 <String "">
    //*  18   37:invokevirtual   #142 <Method boolean String.equals(Object)>
    //*  19   40:ifne            167
    //*  20   43:aload_3         
    //*  21   44:ldc1            #144 <String "@">
    //*  22   46:invokevirtual   #148 <Method boolean String.startsWith(String)>
    //*  23   49:ifne            167
    //*  24   52:aload_3         
    //*  25   53:ldc1            #150 <String "%">
    //*  26   55:invokevirtual   #148 <Method boolean String.startsWith(String)>
    //*  27   58:ifeq            64
    //*  28   61:goto            167
                {
                    StringTokenizer s = new StringTokenizer(line, " ,\t\n\r\f");
    //   29   64:new             #152 <Class StringTokenizer>
    //   30   67:dup             
    //   31   68:aload_3         
    //   32   69:ldc1            #154 <String " ,\t\n\r\f">
    //   33   71:invokespecial   #157 <Method void StringTokenizer(String, String)>
    //   34   74:astore          4
                    int count = 0;
    //   35   76:iconst_0        
    //   36   77:istore          5
                    double v1 = 0.0D;
    //   37   79:dconst_0        
    //   38   80:dstore          6
    //*  39   82:goto            147
                    for(; s.hasMoreTokens(); count++)
                    {
                        double val = (new Double(s.nextToken())).doubleValue();
    //   40   85:new             #53  <Class Double>
    //   41   88:dup             
    //   42   89:aload           4
    //   43   91:invokevirtual   #160 <Method String StringTokenizer.nextToken()>
    //   44   94:invokespecial   #161 <Method void Double(String)>
    //   45   97:invokevirtual   #165 <Method double Double.doubleValue()>
    //   46  100:dstore          8
                        if(count == 0)
    //*  47  102:iload           5
    //*  48  104:ifne            114
                        {
                            v1 = val;
    //   49  107:dload           8
    //   50  109:dstore          6
                            continue;
    //   51  111:goto            144
                        }
                        System.err.println((new StringBuilder("MSG: Too many values in line \"")).append(line).append("\", skipped.").toString());
    //   52  114:getstatic       #169 <Field PrintStream System.err>
    //   53  117:new             #80  <Class StringBuilder>
    //   54  120:dup             
    //   55  121:ldc1            #171 <String "MSG: Too many values in line \"">
    //   56  123:invokespecial   #85  <Method void StringBuilder(String)>
    //   57  126:aload_3         
    //   58  127:invokevirtual   #95  <Method StringBuilder StringBuilder.append(String)>
    //   59  130:ldc1            #173 <String "\", skipped.">
    //   60  132:invokevirtual   #95  <Method StringBuilder StringBuilder.append(String)>
    //   61  135:invokevirtual   #112 <Method String StringBuilder.toString()>
    //   62  138:invokevirtual   #178 <Method void PrintStream.println(String)>
                        break;
    //   63  141:goto            155
                    }

    //   64  144:iinc            5  1
    //   65  147:aload           4
    //   66  149:invokevirtual   #182 <Method boolean StringTokenizer.hasMoreTokens()>
    //   67  152:ifne            85
                    if(count == 1)
    //*  68  155:iload           5
    //*  69  157:iconst_1        
    //*  70  158:icmpne          167
                        ps.add(v1);
    //   71  161:aload_1         
    //   72  162:dload           6
    //   73  164:invokevirtual   #184 <Method void add(double)>
                }
            }
    //   74  167:aload_2         
    //   75  168:invokevirtual   #187 <Method String LineNumberReader.readLine()>
    //   76  171:dup             
    //   77  172:astore_3        
    //   78  173:ifnonnull       29
            ps.calculateDerived();
    //   79  176:aload_1         
    //   80  177:invokevirtual   #78  <Method void calculateDerived()>
            System.err.println(ps);
    //   81  180:getstatic       #169 <Field PrintStream System.err>
    //   82  183:aload_1         
    //   83  184:invokevirtual   #190 <Method void PrintStream.println(Object)>
        }
    //*  84  187:goto            205
        catch(Exception ex)
    //*  85  190:astore_1        
        {
            ex.printStackTrace();
    //   86  191:aload_1         
    //   87  192:invokevirtual   #195 <Method void Exception.printStackTrace()>
            System.err.println(ex.getMessage());
    //   88  195:getstatic       #169 <Field PrintStream System.err>
    //   89  198:aload_1         
    //   90  199:invokevirtual   #198 <Method String Exception.getMessage()>
    //   91  202:invokevirtual   #178 <Method void PrintStream.println(String)>
        }
    //   92  205:return          
    }

    public double count;
    public double sum;
    public double sumSq;
    public double stdDev;
    public double mean;
    public double min;
    public double max;
}
