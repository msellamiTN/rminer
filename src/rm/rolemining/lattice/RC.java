// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   RC.java

package rm.rolemining.lattice;

import java.io.PrintStream;
import java.util.ArrayList;

public class RC
{

    public RC()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #9   <Method void Object()>
    //    2    4:return          
    }

    public static double ComputeRC(String s1, String s2)
    {
        String s3 = (new StringBuilder(String.valueOf(s1))).append(",").append(s2).toString();
    //    0    0:new             #17  <Class StringBuilder>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:invokestatic    #23  <Method String String.valueOf(Object)>
    //    4    8:invokespecial   #26  <Method void StringBuilder(String)>
    //    5   11:ldc1            #28  <String ",">
    //    6   13:invokevirtual   #32  <Method StringBuilder StringBuilder.append(String)>
    //    7   16:aload_1         
    //    8   17:invokevirtual   #32  <Method StringBuilder StringBuilder.append(String)>
    //    9   20:invokevirtual   #36  <Method String StringBuilder.toString()>
    //   10   23:astore_2        
        double rc = 0.0D;
    //   11   24:dconst_0        
    //   12   25:dstore_3        
        String perms1[] = (String[])null;
    //   13   26:aconst_null     
    //   14   27:checkcast       #38  <Class String[]>
    //   15   30:astore          5
        if(s1.length() > 1)
    //*  16   32:aload_0         
    //*  17   33:invokevirtual   #42  <Method int String.length()>
    //*  18   36:iconst_1        
    //*  19   37:icmple          51
            perms1 = s1.split(",");
    //   20   40:aload_0         
    //   21   41:ldc1            #28  <String ",">
    //   22   43:invokevirtual   #46  <Method String[] String.split(String)>
    //   23   46:astore          5
        else
    //*  24   48:goto            53
            return 1.0D;
    //   25   51:dconst_1        
    //   26   52:dreturn         
        String perms2[] = (String[])null;
    //   27   53:aconst_null     
    //   28   54:checkcast       #38  <Class String[]>
    //   29   57:astore          6
        if(s2.length() > 1)
    //*  30   59:aload_1         
    //*  31   60:invokevirtual   #42  <Method int String.length()>
    //*  32   63:iconst_1        
    //*  33   64:icmple          78
            perms2 = s2.split(",");
    //   34   67:aload_1         
    //   35   68:ldc1            #28  <String ",">
    //   36   70:invokevirtual   #46  <Method String[] String.split(String)>
    //   37   73:astore          6
        else
    //*  38   75:goto            80
            return 1.0D;
    //   39   78:dconst_1        
    //   40   79:dreturn         
        String perms3[] = (String[])null;
    //   41   80:aconst_null     
    //   42   81:checkcast       #38  <Class String[]>
    //   43   84:astore          7
        perms3 = s3.split(",");
    //   44   86:aload_2         
    //   45   87:ldc1            #28  <String ",">
    //   46   89:invokevirtual   #46  <Method String[] String.split(String)>
    //   47   92:astore          7
        double rf1[] = ComputeRF(perms1);
    //   48   94:aload           5
    //   49   96:invokestatic    #50  <Method double[] ComputeRF(String[])>
    //   50   99:astore          8
        double rf2[] = ComputeRF(perms2);
    //   51  101:aload           6
    //   52  103:invokestatic    #50  <Method double[] ComputeRF(String[])>
    //   53  106:astore          9
        double rf3[] = ComputeRF(perms3);
    //   54  108:aload           7
    //   55  110:invokestatic    #50  <Method double[] ComputeRF(String[])>
    //   56  113:astore          10
        double difrf[] = new double[2];
    //   57  115:iconst_2        
    //   58  116:newarray        double[]
    //   59  118:astore          11
        difrf[0] = rf3[0] - 0.5D * rf1[0] - 0.5D * rf2[0];
    //   60  120:aload           11
    //   61  122:iconst_0        
    //   62  123:aload           10
    //   63  125:iconst_0        
    //   64  126:daload          
    //   65  127:ldc2w           #51  <Double 0.5D>
    //   66  130:aload           8
    //   67  132:iconst_0        
    //   68  133:daload          
    //   69  134:dmul            
    //   70  135:dsub            
    //   71  136:ldc2w           #51  <Double 0.5D>
    //   72  139:aload           9
    //   73  141:iconst_0        
    //   74  142:daload          
    //   75  143:dmul            
    //   76  144:dsub            
    //   77  145:dastore         
        difrf[1] = rf3[1] - 0.5D * rf1[1] - 0.5D * rf2[1];
    //   78  146:aload           11
    //   79  148:iconst_1        
    //   80  149:aload           10
    //   81  151:iconst_1        
    //   82  152:daload          
    //   83  153:ldc2w           #51  <Double 0.5D>
    //   84  156:aload           8
    //   85  158:iconst_1        
    //   86  159:daload          
    //   87  160:dmul            
    //   88  161:dsub            
    //   89  162:ldc2w           #51  <Double 0.5D>
    //   90  165:aload           9
    //   91  167:iconst_1        
    //   92  168:daload          
    //   93  169:dmul            
    //   94  170:dsub            
    //   95  171:dastore         
        rc = 0.20000000000000001D * (difrf[0] / rf3[0]) + 0.80000000000000004D * (difrf[1] / rf3[1]);
    //   96  172:ldc2w           #53  <Double 0.20000000000000001D>
    //   97  175:aload           11
    //   98  177:iconst_0        
    //   99  178:daload          
    //  100  179:aload           10
    //  101  181:iconst_0        
    //  102  182:daload          
    //  103  183:ddiv            
    //  104  184:dmul            
    //  105  185:ldc2w           #55  <Double 0.80000000000000004D>
    //  106  188:aload           11
    //  107  190:iconst_1        
    //  108  191:daload          
    //  109  192:aload           10
    //  110  194:iconst_1        
    //  111  195:daload          
    //  112  196:ddiv            
    //  113  197:dmul            
    //  114  198:dadd            
    //  115  199:dstore_3        
        return rc;
    //  116  200:dload_3         
    //  117  201:dreturn         
    }

    public static void printRF(String perms, double rf[])
    {
        System.out.println(perms);
    //    0    0:getstatic       #78  <Field PrintStream System.out>
    //    1    3:aload_0         
    //    2    4:invokevirtual   #83  <Method void PrintStream.println(String)>
        System.out.println((new StringBuilder("OperC: ")).append(rf[0]).append("   RsC:").append(rf[1]).append("  Nperms:").append(rf[2]).toString());
    //    3    7:getstatic       #78  <Field PrintStream System.out>
    //    4   10:new             #17  <Class StringBuilder>
    //    5   13:dup             
    //    6   14:ldc1            #85  <String "OperC: ">
    //    7   16:invokespecial   #26  <Method void StringBuilder(String)>
    //    8   19:aload_1         
    //    9   20:iconst_0        
    //   10   21:daload          
    //   11   22:invokevirtual   #88  <Method StringBuilder StringBuilder.append(double)>
    //   12   25:ldc1            #90  <String "   RsC:">
    //   13   27:invokevirtual   #32  <Method StringBuilder StringBuilder.append(String)>
    //   14   30:aload_1         
    //   15   31:iconst_1        
    //   16   32:daload          
    //   17   33:invokevirtual   #88  <Method StringBuilder StringBuilder.append(double)>
    //   18   36:ldc1            #92  <String "  Nperms:">
    //   19   38:invokevirtual   #32  <Method StringBuilder StringBuilder.append(String)>
    //   20   41:aload_1         
    //   21   42:iconst_2        
    //   22   43:daload          
    //   23   44:invokevirtual   #88  <Method StringBuilder StringBuilder.append(double)>
    //   24   47:invokevirtual   #36  <Method String StringBuilder.toString()>
    //   25   50:invokevirtual   #83  <Method void PrintStream.println(String)>
    //   26   53:return          
    }

    public static double[] ComputeRF(String perms[])
    {
        double rf[] = new double[3];
    //    0    0:iconst_3        
    //    1    1:newarray        double[]
    //    2    3:astore_1        
        if(perms == null)
    //*   3    4:aload_0         
    //*   4    5:ifnonnull       26
        {
            rf[0] = 0.01D;
    //    5    8:aload_1         
    //    6    9:iconst_0        
    //    7   10:ldc2w           #95  <Double 0.01D>
    //    8   13:dastore         
            rf[1] = 0.01D;
    //    9   14:aload_1         
    //   10   15:iconst_1        
    //   11   16:ldc2w           #95  <Double 0.01D>
    //   12   19:dastore         
            rf[2] = 0.0D;
    //   13   20:aload_1         
    //   14   21:iconst_2        
    //   15   22:dconst_0        
    //   16   23:dastore         
            return rf;
    //   17   24:aload_1         
    //   18   25:areturn         
        }
        ArrayList op = new ArrayList();
    //   19   26:new             #98  <Class ArrayList>
    //   20   29:dup             
    //   21   30:invokespecial   #99  <Method void ArrayList()>
    //   22   33:astore_2        
        ArrayList nop = new ArrayList();
    //   23   34:new             #98  <Class ArrayList>
    //   24   37:dup             
    //   25   38:invokespecial   #99  <Method void ArrayList()>
    //   26   41:astore_3        
        ArrayList rs = new ArrayList();
    //   27   42:new             #98  <Class ArrayList>
    //   28   45:dup             
    //   29   46:invokespecial   #99  <Method void ArrayList()>
    //   30   49:astore          4
        ArrayList nrs = new ArrayList();
    //   31   51:new             #98  <Class ArrayList>
    //   32   54:dup             
    //   33   55:invokespecial   #99  <Method void ArrayList()>
    //   34   58:astore          5
        for(int i = 0; i < perms.length; i++)
    //*  35   60:iconst_0        
    //*  36   61:istore          6
    //*  37   63:goto            226
        {
            String attribute[] = perms[i].split("_");
    //   38   66:aload_0         
    //   39   67:iload           6
    //   40   69:aaload          
    //   41   70:ldc1            #101 <String "_">
    //   42   72:invokevirtual   #46  <Method String[] String.split(String)>
    //   43   75:astore          7
            if(!op.contains(attribute[0]))
    //*  44   77:aload_2         
    //*  45   78:aload           7
    //*  46   80:iconst_0        
    //*  47   81:aaload          
    //*  48   82:invokevirtual   #105 <Method boolean ArrayList.contains(Object)>
    //*  49   85:ifne            109
            {
                op.add(attribute[0]);
    //   50   88:aload_2         
    //   51   89:aload           7
    //   52   91:iconst_0        
    //   53   92:aaload          
    //   54   93:invokevirtual   #108 <Method boolean ArrayList.add(Object)>
    //   55   96:pop             
                nop.add(Integer.valueOf(1));
    //   56   97:aload_3         
    //   57   98:iconst_1        
    //   58   99:invokestatic    #113 <Method Integer Integer.valueOf(int)>
    //   59  102:invokevirtual   #108 <Method boolean ArrayList.add(Object)>
    //   60  105:pop             
            } else
    //*  61  106:goto            147
            {
                int j = op.indexOf(attribute[0]);
    //   62  109:aload_2         
    //   63  110:aload           7
    //   64  112:iconst_0        
    //   65  113:aaload          
    //   66  114:invokevirtual   #117 <Method int ArrayList.indexOf(Object)>
    //   67  117:istore          8
                Integer n = (Integer)nop.get(j);
    //   68  119:aload_3         
    //   69  120:iload           8
    //   70  122:invokevirtual   #121 <Method Object ArrayList.get(int)>
    //   71  125:checkcast       #110 <Class Integer>
    //   72  128:astore          9
                nop.set(j, Integer.valueOf(n.intValue() + 1));
    //   73  130:aload_3         
    //   74  131:iload           8
    //   75  133:aload           9
    //   76  135:invokevirtual   #124 <Method int Integer.intValue()>
    //   77  138:iconst_1        
    //   78  139:iadd            
    //   79  140:invokestatic    #113 <Method Integer Integer.valueOf(int)>
    //   80  143:invokevirtual   #128 <Method Object ArrayList.set(int, Object)>
    //   81  146:pop             
            }
            if(!rs.contains(attribute[1]))
    //*  82  147:aload           4
    //*  83  149:aload           7
    //*  84  151:iconst_1        
    //*  85  152:aaload          
    //*  86  153:invokevirtual   #105 <Method boolean ArrayList.contains(Object)>
    //*  87  156:ifne            182
            {
                rs.add(attribute[1]);
    //   88  159:aload           4
    //   89  161:aload           7
    //   90  163:iconst_1        
    //   91  164:aaload          
    //   92  165:invokevirtual   #108 <Method boolean ArrayList.add(Object)>
    //   93  168:pop             
                nrs.add(Integer.valueOf(1));
    //   94  169:aload           5
    //   95  171:iconst_1        
    //   96  172:invokestatic    #113 <Method Integer Integer.valueOf(int)>
    //   97  175:invokevirtual   #108 <Method boolean ArrayList.add(Object)>
    //   98  178:pop             
            } else
    //*  99  179:goto            223
            {
                int j = rs.indexOf(attribute[1]);
    //  100  182:aload           4
    //  101  184:aload           7
    //  102  186:iconst_1        
    //  103  187:aaload          
    //  104  188:invokevirtual   #117 <Method int ArrayList.indexOf(Object)>
    //  105  191:istore          8
                Integer n = (Integer)nrs.get(j);
    //  106  193:aload           5
    //  107  195:iload           8
    //  108  197:invokevirtual   #121 <Method Object ArrayList.get(int)>
    //  109  200:checkcast       #110 <Class Integer>
    //  110  203:astore          9
                nrs.set(j, Integer.valueOf(n.intValue() + 1));
    //  111  205:aload           5
    //  112  207:iload           8
    //  113  209:aload           9
    //  114  211:invokevirtual   #124 <Method int Integer.intValue()>
    //  115  214:iconst_1        
    //  116  215:iadd            
    //  117  216:invokestatic    #113 <Method Integer Integer.valueOf(int)>
    //  118  219:invokevirtual   #128 <Method Object ArrayList.set(int, Object)>
    //  119  222:pop             
            }
        }

    //  120  223:iinc            6  1
    //  121  226:iload           6
    //  122  228:aload_0         
    //  123  229:arraylength     
    //  124  230:icmplt          66
        double entop = 0.0D;
    //  125  233:dconst_0        
    //  126  234:dstore          6
        for(int i = 0; i < nop.size(); i++)
    //* 127  236:iconst_0        
    //* 128  237:istore          8
    //* 129  239:goto            284
        {
            double ei = ((Integer)nop.get(i)).intValue();
    //  130  242:aload_3         
    //  131  243:iload           8
    //  132  245:invokevirtual   #121 <Method Object ArrayList.get(int)>
    //  133  248:checkcast       #110 <Class Integer>
    //  134  251:invokevirtual   #124 <Method int Integer.intValue()>
    //  135  254:i2d             
    //  136  255:dstore          9
            ei /= perms.length;
    //  137  257:dload           9
    //  138  259:aload_0         
    //  139  260:arraylength     
    //  140  261:i2d             
    //  141  262:ddiv            
    //  142  263:dstore          9
            entop += ei * log(ei, 2D);
    //  143  265:dload           6
    //  144  267:dload           9
    //  145  269:dload           9
    //  146  271:ldc2w           #129 <Double 2D>
    //  147  274:invokestatic    #134 <Method double log(double, double)>
    //  148  277:dmul            
    //  149  278:dadd            
    //  150  279:dstore          6
        }

    //  151  281:iinc            8  1
    //  152  284:iload           8
    //  153  286:aload_3         
    //  154  287:invokevirtual   #137 <Method int ArrayList.size()>
    //  155  290:icmplt          242
        double entrs = 0.0D;
    //  156  293:dconst_0        
    //  157  294:dstore          8
        for(int i = 0; i < nrs.size(); i++)
    //* 158  296:iconst_0        
    //* 159  297:istore          10
    //* 160  299:goto            345
        {
            double ei = ((Integer)nrs.get(i)).intValue();
    //  161  302:aload           5
    //  162  304:iload           10
    //  163  306:invokevirtual   #121 <Method Object ArrayList.get(int)>
    //  164  309:checkcast       #110 <Class Integer>
    //  165  312:invokevirtual   #124 <Method int Integer.intValue()>
    //  166  315:i2d             
    //  167  316:dstore          11
            ei /= perms.length;
    //  168  318:dload           11
    //  169  320:aload_0         
    //  170  321:arraylength     
    //  171  322:i2d             
    //  172  323:ddiv            
    //  173  324:dstore          11
            entrs += ei * log(ei, 2D);
    //  174  326:dload           8
    //  175  328:dload           11
    //  176  330:dload           11
    //  177  332:ldc2w           #129 <Double 2D>
    //  178  335:invokestatic    #134 <Method double log(double, double)>
    //  179  338:dmul            
    //  180  339:dadd            
    //  181  340:dstore          8
        }

    //  182  342:iinc            10  1
    //  183  345:iload           10
    //  184  347:aload           5
    //  185  349:invokevirtual   #137 <Method int ArrayList.size()>
    //  186  352:icmplt          302
        rf[0] = -entop + 0.01D;
    //  187  355:aload_1         
    //  188  356:iconst_0        
    //  189  357:dload           6
    //  190  359:dneg            
    //  191  360:ldc2w           #95  <Double 0.01D>
    //  192  363:dadd            
    //  193  364:dastore         
        rf[1] = -entrs + 0.01D;
    //  194  365:aload_1         
    //  195  366:iconst_1        
    //  196  367:dload           8
    //  197  369:dneg            
    //  198  370:ldc2w           #95  <Double 0.01D>
    //  199  373:dadd            
    //  200  374:dastore         
        rf[2] = perms.length;
    //  201  375:aload_1         
    //  202  376:iconst_2        
    //  203  377:aload_0         
    //  204  378:arraylength     
    //  205  379:i2d             
    //  206  380:dastore         
        return rf;
    //  207  381:aload_1         
    //  208  382:areturn         
    }

    public static double log(double value, double base)
    {
        return Math.log(value) / Math.log(base);
    //    0    0:dload_0         
    //    1    1:invokestatic    #159 <Method double Math.log(double)>
    //    2    4:dload_2         
    //    3    5:invokestatic    #159 <Method double Math.log(double)>
    //    4    8:ddiv            
    //    5    9:dreturn         
    }

    public static void main(String args[])
    {
        String s1 = "viewGrade_GradeBook,create_ComputerAccount,obtain_StudentParkingPermit,register_Course,pay_Tuition";
    //    0    0:ldc1            #165 <String "viewGrade_GradeBook,create_ComputerAccount,obtain_StudentParkingPermit,register_Course,pay_Tuition">
    //    1    2:astore_1        
        String s2 = "AssignGrad_GradeBook";
    //    2    3:ldc1            #167 <String "AssignGrad_GradeBook">
    //    3    5:astore_2        
        ComputeRC(s1, s2);
    //    4    6:aload_1         
    //    5    7:aload_2         
    //    6    8:invokestatic    #169 <Method double ComputeRC(String, String)>
    //    7   11:pop2            
    //    8   12:return          
    }
}
