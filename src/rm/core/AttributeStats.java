// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   AttributeStats.java

package rm.core;

import java.io.Serializable;

// Referenced classes of package rm.core:
//            Utils, Stats

public class AttributeStats
    implements Serializable
{

    public AttributeStats()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #22  <Method void Object()>
        intCount = 0;
    //    2    4:aload_0         
    //    3    5:iconst_0        
    //    4    6:putfield        #24  <Field int intCount>
        realCount = 0;
    //    5    9:aload_0         
    //    6   10:iconst_0        
    //    7   11:putfield        #26  <Field int realCount>
        missingCount = 0;
    //    8   14:aload_0         
    //    9   15:iconst_0        
    //   10   16:putfield        #28  <Field int missingCount>
        distinctCount = 0;
    //   11   19:aload_0         
    //   12   20:iconst_0        
    //   13   21:putfield        #30  <Field int distinctCount>
        uniqueCount = 0;
    //   14   24:aload_0         
    //   15   25:iconst_0        
    //   16   26:putfield        #32  <Field int uniqueCount>
        totalCount = 0;
    //   17   29:aload_0         
    //   18   30:iconst_0        
    //   19   31:putfield        #34  <Field int totalCount>
    //   20   34:return          
    }

    protected void addDistinct(double value, int count)
    {
        if(count > 0)
    //*   0    0:iload_3         
    //*   1    1:ifle            91
        {
            if(count == 1)
    //*   2    4:iload_3         
    //*   3    5:iconst_1        
    //*   4    6:icmpne          19
                uniqueCount++;
    //    5    9:aload_0         
    //    6   10:dup             
    //    7   11:getfield        #32  <Field int uniqueCount>
    //    8   14:iconst_1        
    //    9   15:iadd            
    //   10   16:putfield        #32  <Field int uniqueCount>
            if(Utils.eq(value, (int)value))
    //*  11   19:dload_1         
    //*  12   20:dload_1         
    //*  13   21:d2i             
    //*  14   22:i2d             
    //*  15   23:invokestatic    #46  <Method boolean Utils.eq(double, double)>
    //*  16   26:ifeq            42
                intCount += count;
    //   17   29:aload_0         
    //   18   30:dup             
    //   19   31:getfield        #24  <Field int intCount>
    //   20   34:iload_3         
    //   21   35:iadd            
    //   22   36:putfield        #24  <Field int intCount>
            else
    //*  23   39:goto            52
                realCount += count;
    //   24   42:aload_0         
    //   25   43:dup             
    //   26   44:getfield        #26  <Field int realCount>
    //   27   47:iload_3         
    //   28   48:iadd            
    //   29   49:putfield        #26  <Field int realCount>
            if(nominalCounts != null)
    //*  30   52:aload_0         
    //*  31   53:getfield        #48  <Field int[] nominalCounts>
    //*  32   56:ifnull          67
                nominalCounts[(int)value] = count;
    //   33   59:aload_0         
    //   34   60:getfield        #48  <Field int[] nominalCounts>
    //   35   63:dload_1         
    //   36   64:d2i             
    //   37   65:iload_3         
    //   38   66:iastore         
            if(numericStats != null)
    //*  39   67:aload_0         
    //*  40   68:getfield        #50  <Field Stats numericStats>
    //*  41   71:ifnull          91
            {
                numericStats.add(value, count);
    //   42   74:aload_0         
    //   43   75:getfield        #50  <Field Stats numericStats>
    //   44   78:dload_1         
    //   45   79:iload_3         
    //   46   80:i2d             
    //   47   81:invokevirtual   #56  <Method void Stats.add(double, double)>
                numericStats.calculateDerived();
    //   48   84:aload_0         
    //   49   85:getfield        #50  <Field Stats numericStats>
    //   50   88:invokevirtual   #59  <Method void Stats.calculateDerived()>
            }
        }
        distinctCount++;
    //   51   91:aload_0         
    //   52   92:dup             
    //   53   93:getfield        #30  <Field int distinctCount>
    //   54   96:iconst_1        
    //   55   97:iadd            
    //   56   98:putfield        #30  <Field int distinctCount>
    //   57  101:return          
    }

    public String toString()
    {
        StringBuffer sb = new StringBuffer();
    //    0    0:new             #66  <Class StringBuffer>
    //    1    3:dup             
    //    2    4:invokespecial   #67  <Method void StringBuffer()>
    //    3    7:astore_1        
        sb.append(Utils.padLeft("Type", 4)).append(Utils.padLeft("Nom", 5));
    //    4    8:aload_1         
    //    5    9:ldc1            #69  <String "Type">
    //    6   11:iconst_4        
    //    7   12:invokestatic    #73  <Method String Utils.padLeft(String, int)>
    //    8   15:invokevirtual   #77  <Method StringBuffer StringBuffer.append(String)>
    //    9   18:ldc1            #79  <String "Nom">
    //   10   20:iconst_5        
    //   11   21:invokestatic    #73  <Method String Utils.padLeft(String, int)>
    //   12   24:invokevirtual   #77  <Method StringBuffer StringBuffer.append(String)>
    //   13   27:pop             
        sb.append(Utils.padLeft("Int", 5)).append(Utils.padLeft("Real", 5));
    //   14   28:aload_1         
    //   15   29:ldc1            #81  <String "Int">
    //   16   31:iconst_5        
    //   17   32:invokestatic    #73  <Method String Utils.padLeft(String, int)>
    //   18   35:invokevirtual   #77  <Method StringBuffer StringBuffer.append(String)>
    //   19   38:ldc1            #83  <String "Real">
    //   20   40:iconst_5        
    //   21   41:invokestatic    #73  <Method String Utils.padLeft(String, int)>
    //   22   44:invokevirtual   #77  <Method StringBuffer StringBuffer.append(String)>
    //   23   47:pop             
        sb.append(Utils.padLeft("Missing", 12));
    //   24   48:aload_1         
    //   25   49:ldc1            #85  <String "Missing">
    //   26   51:bipush          12
    //   27   53:invokestatic    #73  <Method String Utils.padLeft(String, int)>
    //   28   56:invokevirtual   #77  <Method StringBuffer StringBuffer.append(String)>
    //   29   59:pop             
        sb.append(Utils.padLeft("Unique", 12));
    //   30   60:aload_1         
    //   31   61:ldc1            #87  <String "Unique">
    //   32   63:bipush          12
    //   33   65:invokestatic    #73  <Method String Utils.padLeft(String, int)>
    //   34   68:invokevirtual   #77  <Method StringBuffer StringBuffer.append(String)>
    //   35   71:pop             
        sb.append(Utils.padLeft("Dist", 6));
    //   36   72:aload_1         
    //   37   73:ldc1            #89  <String "Dist">
    //   38   75:bipush          6
    //   39   77:invokestatic    #73  <Method String Utils.padLeft(String, int)>
    //   40   80:invokevirtual   #77  <Method StringBuffer StringBuffer.append(String)>
    //   41   83:pop             
        if(nominalCounts != null)
    //*  42   84:aload_0         
    //*  43   85:getfield        #48  <Field int[] nominalCounts>
    //*  44   88:ifnull          145
        {
            sb.append(' ');
    //   45   91:aload_1         
    //   46   92:bipush          32
    //   47   94:invokevirtual   #92  <Method StringBuffer StringBuffer.append(char)>
    //   48   97:pop             
            for(int i = 0; i < nominalCounts.length; i++)
    //*  49   98:iconst_0        
    //*  50   99:istore_2        
    //*  51  100:goto            136
                sb.append(Utils.padLeft((new StringBuilder("C[")).append(i).append("]").toString(), 5));
    //   52  103:aload_1         
    //   53  104:new             #94  <Class StringBuilder>
    //   54  107:dup             
    //   55  108:ldc1            #96  <String "C[">
    //   56  110:invokespecial   #99  <Method void StringBuilder(String)>
    //   57  113:iload_2         
    //   58  114:invokevirtual   #102 <Method StringBuilder StringBuilder.append(int)>
    //   59  117:ldc1            #104 <String "]">
    //   60  119:invokevirtual   #107 <Method StringBuilder StringBuilder.append(String)>
    //   61  122:invokevirtual   #109 <Method String StringBuilder.toString()>
    //   62  125:iconst_5        
    //   63  126:invokestatic    #73  <Method String Utils.padLeft(String, int)>
    //   64  129:invokevirtual   #77  <Method StringBuffer StringBuffer.append(String)>
    //   65  132:pop             

    //   66  133:iinc            2  1
    //   67  136:iload_2         
    //   68  137:aload_0         
    //   69  138:getfield        #48  <Field int[] nominalCounts>
    //   70  141:arraylength     
    //   71  142:icmplt          103
        }
        sb.append('\n');
    //   72  145:aload_1         
    //   73  146:bipush          10
    //   74  148:invokevirtual   #92  <Method StringBuffer StringBuffer.append(char)>
    //   75  151:pop             
        long percent = Math.round((100D * (double)intCount) / (double)totalCount);
    //   76  152:ldc2w           #110 <Double 100D>
    //   77  155:aload_0         
    //   78  156:getfield        #24  <Field int intCount>
    //   79  159:i2d             
    //   80  160:dmul            
    //   81  161:aload_0         
    //   82  162:getfield        #34  <Field int totalCount>
    //   83  165:i2d             
    //   84  166:ddiv            
    //   85  167:invokestatic    #117 <Method long Math.round(double)>
    //   86  170:lstore_2        
        if(nominalCounts != null)
    //*  87  171:aload_0         
    //*  88  172:getfield        #48  <Field int[] nominalCounts>
    //*  89  175:ifnull          241
        {
            sb.append(Utils.padLeft("Nom", 4)).append(' ');
    //   90  178:aload_1         
    //   91  179:ldc1            #79  <String "Nom">
    //   92  181:iconst_4        
    //   93  182:invokestatic    #73  <Method String Utils.padLeft(String, int)>
    //   94  185:invokevirtual   #77  <Method StringBuffer StringBuffer.append(String)>
    //   95  188:bipush          32
    //   96  190:invokevirtual   #92  <Method StringBuffer StringBuffer.append(char)>
    //   97  193:pop             
            sb.append(Utils.padLeft((new StringBuilder()).append(percent).toString(), 3)).append("% ");
    //   98  194:aload_1         
    //   99  195:new             #94  <Class StringBuilder>
    //  100  198:dup             
    //  101  199:invokespecial   #118 <Method void StringBuilder()>
    //  102  202:lload_2         
    //  103  203:invokevirtual   #121 <Method StringBuilder StringBuilder.append(long)>
    //  104  206:invokevirtual   #109 <Method String StringBuilder.toString()>
    //  105  209:iconst_3        
    //  106  210:invokestatic    #73  <Method String Utils.padLeft(String, int)>
    //  107  213:invokevirtual   #77  <Method StringBuffer StringBuffer.append(String)>
    //  108  216:ldc1            #123 <String "% ">
    //  109  218:invokevirtual   #77  <Method StringBuffer StringBuffer.append(String)>
    //  110  221:pop             
            sb.append(Utils.padLeft("0", 3)).append("% ");
    //  111  222:aload_1         
    //  112  223:ldc1            #125 <String "0">
    //  113  225:iconst_3        
    //  114  226:invokestatic    #73  <Method String Utils.padLeft(String, int)>
    //  115  229:invokevirtual   #77  <Method StringBuffer StringBuffer.append(String)>
    //  116  232:ldc1            #123 <String "% ">
    //  117  234:invokevirtual   #77  <Method StringBuffer StringBuffer.append(String)>
    //  118  237:pop             
        } else
    //* 119  238:goto            301
        {
            sb.append(Utils.padLeft("Num", 4)).append(' ');
    //  120  241:aload_1         
    //  121  242:ldc1            #127 <String "Num">
    //  122  244:iconst_4        
    //  123  245:invokestatic    #73  <Method String Utils.padLeft(String, int)>
    //  124  248:invokevirtual   #77  <Method StringBuffer StringBuffer.append(String)>
    //  125  251:bipush          32
    //  126  253:invokevirtual   #92  <Method StringBuffer StringBuffer.append(char)>
    //  127  256:pop             
            sb.append(Utils.padLeft("0", 3)).append("% ");
    //  128  257:aload_1         
    //  129  258:ldc1            #125 <String "0">
    //  130  260:iconst_3        
    //  131  261:invokestatic    #73  <Method String Utils.padLeft(String, int)>
    //  132  264:invokevirtual   #77  <Method StringBuffer StringBuffer.append(String)>
    //  133  267:ldc1            #123 <String "% ">
    //  134  269:invokevirtual   #77  <Method StringBuffer StringBuffer.append(String)>
    //  135  272:pop             
            sb.append(Utils.padLeft((new StringBuilder()).append(percent).toString(), 3)).append("% ");
    //  136  273:aload_1         
    //  137  274:new             #94  <Class StringBuilder>
    //  138  277:dup             
    //  139  278:invokespecial   #118 <Method void StringBuilder()>
    //  140  281:lload_2         
    //  141  282:invokevirtual   #121 <Method StringBuilder StringBuilder.append(long)>
    //  142  285:invokevirtual   #109 <Method String StringBuilder.toString()>
    //  143  288:iconst_3        
    //  144  289:invokestatic    #73  <Method String Utils.padLeft(String, int)>
    //  145  292:invokevirtual   #77  <Method StringBuffer StringBuffer.append(String)>
    //  146  295:ldc1            #123 <String "% ">
    //  147  297:invokevirtual   #77  <Method StringBuffer StringBuffer.append(String)>
    //  148  300:pop             
        }
        percent = Math.round((100D * (double)realCount) / (double)totalCount);
    //  149  301:ldc2w           #110 <Double 100D>
    //  150  304:aload_0         
    //  151  305:getfield        #26  <Field int realCount>
    //  152  308:i2d             
    //  153  309:dmul            
    //  154  310:aload_0         
    //  155  311:getfield        #34  <Field int totalCount>
    //  156  314:i2d             
    //  157  315:ddiv            
    //  158  316:invokestatic    #117 <Method long Math.round(double)>
    //  159  319:lstore_2        
        sb.append(Utils.padLeft((new StringBuilder()).append(percent).toString(), 3)).append("% ");
    //  160  320:aload_1         
    //  161  321:new             #94  <Class StringBuilder>
    //  162  324:dup             
    //  163  325:invokespecial   #118 <Method void StringBuilder()>
    //  164  328:lload_2         
    //  165  329:invokevirtual   #121 <Method StringBuilder StringBuilder.append(long)>
    //  166  332:invokevirtual   #109 <Method String StringBuilder.toString()>
    //  167  335:iconst_3        
    //  168  336:invokestatic    #73  <Method String Utils.padLeft(String, int)>
    //  169  339:invokevirtual   #77  <Method StringBuffer StringBuffer.append(String)>
    //  170  342:ldc1            #123 <String "% ">
    //  171  344:invokevirtual   #77  <Method StringBuffer StringBuffer.append(String)>
    //  172  347:pop             
        sb.append(Utils.padLeft((new StringBuilder()).append(missingCount).toString(), 5)).append(" /");
    //  173  348:aload_1         
    //  174  349:new             #94  <Class StringBuilder>
    //  175  352:dup             
    //  176  353:invokespecial   #118 <Method void StringBuilder()>
    //  177  356:aload_0         
    //  178  357:getfield        #28  <Field int missingCount>
    //  179  360:invokevirtual   #102 <Method StringBuilder StringBuilder.append(int)>
    //  180  363:invokevirtual   #109 <Method String StringBuilder.toString()>
    //  181  366:iconst_5        
    //  182  367:invokestatic    #73  <Method String Utils.padLeft(String, int)>
    //  183  370:invokevirtual   #77  <Method StringBuffer StringBuffer.append(String)>
    //  184  373:ldc1            #129 <String " /">
    //  185  375:invokevirtual   #77  <Method StringBuffer StringBuffer.append(String)>
    //  186  378:pop             
        percent = Math.round((100D * (double)missingCount) / (double)totalCount);
    //  187  379:ldc2w           #110 <Double 100D>
    //  188  382:aload_0         
    //  189  383:getfield        #28  <Field int missingCount>
    //  190  386:i2d             
    //  191  387:dmul            
    //  192  388:aload_0         
    //  193  389:getfield        #34  <Field int totalCount>
    //  194  392:i2d             
    //  195  393:ddiv            
    //  196  394:invokestatic    #117 <Method long Math.round(double)>
    //  197  397:lstore_2        
        sb.append(Utils.padLeft((new StringBuilder()).append(percent).toString(), 3)).append("% ");
    //  198  398:aload_1         
    //  199  399:new             #94  <Class StringBuilder>
    //  200  402:dup             
    //  201  403:invokespecial   #118 <Method void StringBuilder()>
    //  202  406:lload_2         
    //  203  407:invokevirtual   #121 <Method StringBuilder StringBuilder.append(long)>
    //  204  410:invokevirtual   #109 <Method String StringBuilder.toString()>
    //  205  413:iconst_3        
    //  206  414:invokestatic    #73  <Method String Utils.padLeft(String, int)>
    //  207  417:invokevirtual   #77  <Method StringBuffer StringBuffer.append(String)>
    //  208  420:ldc1            #123 <String "% ">
    //  209  422:invokevirtual   #77  <Method StringBuffer StringBuffer.append(String)>
    //  210  425:pop             
        sb.append(Utils.padLeft((new StringBuilder()).append(uniqueCount).toString(), 5)).append(" /");
    //  211  426:aload_1         
    //  212  427:new             #94  <Class StringBuilder>
    //  213  430:dup             
    //  214  431:invokespecial   #118 <Method void StringBuilder()>
    //  215  434:aload_0         
    //  216  435:getfield        #32  <Field int uniqueCount>
    //  217  438:invokevirtual   #102 <Method StringBuilder StringBuilder.append(int)>
    //  218  441:invokevirtual   #109 <Method String StringBuilder.toString()>
    //  219  444:iconst_5        
    //  220  445:invokestatic    #73  <Method String Utils.padLeft(String, int)>
    //  221  448:invokevirtual   #77  <Method StringBuffer StringBuffer.append(String)>
    //  222  451:ldc1            #129 <String " /">
    //  223  453:invokevirtual   #77  <Method StringBuffer StringBuffer.append(String)>
    //  224  456:pop             
        percent = Math.round((100D * (double)uniqueCount) / (double)totalCount);
    //  225  457:ldc2w           #110 <Double 100D>
    //  226  460:aload_0         
    //  227  461:getfield        #32  <Field int uniqueCount>
    //  228  464:i2d             
    //  229  465:dmul            
    //  230  466:aload_0         
    //  231  467:getfield        #34  <Field int totalCount>
    //  232  470:i2d             
    //  233  471:ddiv            
    //  234  472:invokestatic    #117 <Method long Math.round(double)>
    //  235  475:lstore_2        
        sb.append(Utils.padLeft((new StringBuilder()).append(percent).toString(), 3)).append("% ");
    //  236  476:aload_1         
    //  237  477:new             #94  <Class StringBuilder>
    //  238  480:dup             
    //  239  481:invokespecial   #118 <Method void StringBuilder()>
    //  240  484:lload_2         
    //  241  485:invokevirtual   #121 <Method StringBuilder StringBuilder.append(long)>
    //  242  488:invokevirtual   #109 <Method String StringBuilder.toString()>
    //  243  491:iconst_3        
    //  244  492:invokestatic    #73  <Method String Utils.padLeft(String, int)>
    //  245  495:invokevirtual   #77  <Method StringBuffer StringBuffer.append(String)>
    //  246  498:ldc1            #123 <String "% ">
    //  247  500:invokevirtual   #77  <Method StringBuffer StringBuffer.append(String)>
    //  248  503:pop             
        sb.append(Utils.padLeft((new StringBuilder()).append(distinctCount).toString(), 5)).append(' ');
    //  249  504:aload_1         
    //  250  505:new             #94  <Class StringBuilder>
    //  251  508:dup             
    //  252  509:invokespecial   #118 <Method void StringBuilder()>
    //  253  512:aload_0         
    //  254  513:getfield        #30  <Field int distinctCount>
    //  255  516:invokevirtual   #102 <Method StringBuilder StringBuilder.append(int)>
    //  256  519:invokevirtual   #109 <Method String StringBuilder.toString()>
    //  257  522:iconst_5        
    //  258  523:invokestatic    #73  <Method String Utils.padLeft(String, int)>
    //  259  526:invokevirtual   #77  <Method StringBuffer StringBuffer.append(String)>
    //  260  529:bipush          32
    //  261  531:invokevirtual   #92  <Method StringBuffer StringBuffer.append(char)>
    //  262  534:pop             
        if(nominalCounts != null)
    //* 263  535:aload_0         
    //* 264  536:getfield        #48  <Field int[] nominalCounts>
    //* 265  539:ifnull          590
        {
            for(int i = 0; i < nominalCounts.length; i++)
    //* 266  542:iconst_0        
    //* 267  543:istore          4
    //* 268  545:goto            580
                sb.append(Utils.padLeft((new StringBuilder()).append(nominalCounts[i]).toString(), 5));
    //  269  548:aload_1         
    //  270  549:new             #94  <Class StringBuilder>
    //  271  552:dup             
    //  272  553:invokespecial   #118 <Method void StringBuilder()>
    //  273  556:aload_0         
    //  274  557:getfield        #48  <Field int[] nominalCounts>
    //  275  560:iload           4
    //  276  562:iaload          
    //  277  563:invokevirtual   #102 <Method StringBuilder StringBuilder.append(int)>
    //  278  566:invokevirtual   #109 <Method String StringBuilder.toString()>
    //  279  569:iconst_5        
    //  280  570:invokestatic    #73  <Method String Utils.padLeft(String, int)>
    //  281  573:invokevirtual   #77  <Method StringBuffer StringBuffer.append(String)>
    //  282  576:pop             

    //  283  577:iinc            4  1
    //  284  580:iload           4
    //  285  582:aload_0         
    //  286  583:getfield        #48  <Field int[] nominalCounts>
    //  287  586:arraylength     
    //  288  587:icmplt          548
        }
        sb.append('\n');
    //  289  590:aload_1         
    //  290  591:bipush          10
    //  291  593:invokevirtual   #92  <Method StringBuffer StringBuffer.append(char)>
    //  292  596:pop             
        return sb.toString();
    //  293  597:aload_1         
    //  294  598:invokevirtual   #130 <Method String StringBuffer.toString()>
    //  295  601:areturn         
    }

    public int intCount;
    public int realCount;
    public int missingCount;
    public int distinctCount;
    public int uniqueCount;
    public int totalCount;
    public Stats numericStats;
    public int nominalCounts[];
}
