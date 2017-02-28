// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   runningExample.java

package main;

import java.io.*;
import java.util.Vector;
import rm.core.*;
import rm.core.converters.AssLoader;

public class runningExample
{

    public runningExample()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #46  <Method void Object()>
    //    2    4:return          
    }

    public static void main(String args[])
        throws Exception
    {
        File file = new File((new StringBuilder(String.valueOf(System.getProperty("user.dir")))).append("\\datasets\\university_large.ass").toString());
    //    0    0:new             #55  <Class File>
    //    1    3:dup             
    //    2    4:new             #57  <Class StringBuilder>
    //    3    7:dup             
    //    4    8:ldc1            #59  <String "user.dir">
    //    5   10:invokestatic    #65  <Method String System.getProperty(String)>
    //    6   13:invokestatic    #69  <Method String String.valueOf(Object)>
    //    7   16:invokespecial   #72  <Method void StringBuilder(String)>
    //    8   19:ldc1            #74  <String "\\datasets\\university_large.ass">
    //    9   21:invokevirtual   #78  <Method StringBuilder StringBuilder.append(String)>
    //   10   24:invokevirtual   #82  <Method String StringBuilder.toString()>
    //   11   27:invokespecial   #83  <Method void File(String)>
    //   12   30:astore_1        
        AssLoader AL = new AssLoader(new FileReader(file));
    //   13   31:new             #85  <Class AssLoader>
    //   14   34:dup             
    //   15   35:new             #87  <Class FileReader>
    //   16   38:dup             
    //   17   39:aload_1         
    //   18   40:invokespecial   #90  <Method void FileReader(File)>
    //   19   43:invokespecial   #93  <Method void AssLoader(FileReader)>
    //   20   46:astore_2        
        Assignment Ass = AL.getData();
    //   21   47:aload_2         
    //   22   48:invokevirtual   #97  <Method Assignment AssLoader.getData()>
    //   23   51:astore_3        
        Object userset[] = Ass.getDimensionX().getDimensionAttribute().toArray();
    //   24   52:aload_3         
    //   25   53:invokevirtual   #103 <Method Dimension Assignment.getDimensionX()>
    //   26   56:invokevirtual   #109 <Method Attribute Dimension.getDimensionAttribute()>
    //   27   59:invokevirtual   #115 <Method Object[] Attribute.toArray()>
    //   28   62:astore          4
        Object permset[] = Ass.getDimensionY().getDimensionAttribute().toArray();
    //   29   64:aload_3         
    //   30   65:invokevirtual   #118 <Method Dimension Assignment.getDimensionY()>
    //   31   68:invokevirtual   #109 <Method Attribute Dimension.getDimensionAttribute()>
    //   32   71:invokevirtual   #115 <Method Object[] Attribute.toArray()>
    //   33   74:astore          5
        Matrix mat = Ass.getAssignmentMatrix();
    //   34   76:aload_3         
    //   35   77:invokevirtual   #122 <Method Matrix Assignment.getAssignmentMatrix()>
    //   36   80:astore          6
        Vector vi_user = new Vector();
    //   37   82:new             #124 <Class Vector>
    //   38   85:dup             
    //   39   86:invokespecial   #125 <Method void Vector()>
    //   40   89:astore          7
        for(int i = 0; i < userset.length; i++)
    //*  41   91:iconst_0        
    //*  42   92:istore          8
    //*  43   94:goto            207
        {
            int n = 0;
    //   44   97:iconst_0        
    //   45   98:istore          9
            int j;
            for(j = 0; j < permset.length; j++)
    //*  46  100:iconst_0        
    //*  47  101:istore          10
    //*  48  103:goto            172
            {
                if(mat.get(i, j) == 1 && findPerm((String)permset[j]))
    //*  49  106:aload           6
    //*  50  108:iload           8
    //*  51  110:iload           10
    //*  52  112:invokevirtual   #131 <Method byte Matrix.get(int, int)>
    //*  53  115:iconst_1        
    //*  54  116:icmpne          139
    //*  55  119:aload           5
    //*  56  121:iload           10
    //*  57  123:aaload          
    //*  58  124:checkcast       #11  <Class String>
    //*  59  127:invokestatic    #135 <Method boolean findPerm(String)>
    //*  60  130:ifeq            139
                {
                    n++;
    //   61  133:iinc            9  1
                    continue;
    //   62  136:goto            169
                }
                if(mat.get(i, j) == 1 && !findPerm((String)permset[j]))
    //*  63  139:aload           6
    //*  64  141:iload           8
    //*  65  143:iload           10
    //*  66  145:invokevirtual   #131 <Method byte Matrix.get(int, int)>
    //*  67  148:iconst_1        
    //*  68  149:icmpne          169
    //*  69  152:aload           5
    //*  70  154:iload           10
    //*  71  156:aaload          
    //*  72  157:checkcast       #11  <Class String>
    //*  73  160:invokestatic    #135 <Method boolean findPerm(String)>
    //*  74  163:ifne            169
                    break;
    //   75  166:goto            180
            }

    //   76  169:iinc            10  1
    //   77  172:iload           10
    //   78  174:aload           5
    //   79  176:arraylength     
    //   80  177:icmplt          106
            if(n > 0 && j == permset.length)
    //*  81  180:iload           9
    //*  82  182:ifle            204
    //*  83  185:iload           10
    //*  84  187:aload           5
    //*  85  189:arraylength     
    //*  86  190:icmpne          204
                vi_user.add(Integer.valueOf(i));
    //   87  193:aload           7
    //   88  195:iload           8
    //   89  197:invokestatic    #140 <Method Integer Integer.valueOf(int)>
    //   90  200:invokevirtual   #144 <Method boolean Vector.add(Object)>
    //   91  203:pop             
        }

    //   92  204:iinc            8  1
    //   93  207:iload           8
    //   94  209:aload           4
    //   95  211:arraylength     
    //   96  212:icmplt          97
        Matrix smallmat = new Matrix(vi_user.size(), selectedPerms.length, (byte)0);
    //   97  215:new             #127 <Class Matrix>
    //   98  218:dup             
    //   99  219:aload           7
    //  100  221:invokevirtual   #148 <Method int Vector.size()>
    //  101  224:getstatic       #41  <Field String[] selectedPerms>
    //  102  227:arraylength     
    //  103  228:iconst_0        
    //  104  229:invokespecial   #151 <Method void Matrix(int, int, byte)>
    //  105  232:astore          8
        StringBuffer text = new StringBuffer();
    //  106  234:new             #153 <Class StringBuffer>
    //  107  237:dup             
    //  108  238:invokespecial   #154 <Method void StringBuffer()>
    //  109  241:astore          9
        text.append("@assignment university-runningexample\n");
    //  110  243:aload           9
    //  111  245:ldc1            #156 <String "@assignment university-runningexample\n">
    //  112  247:invokevirtual   #159 <Method StringBuffer StringBuffer.append(String)>
    //  113  250:pop             
        text.append("@dimension user {");
    //  114  251:aload           9
    //  115  253:ldc1            #161 <String "@dimension user {">
    //  116  255:invokevirtual   #159 <Method StringBuffer StringBuffer.append(String)>
    //  117  258:pop             
        for(int i = 0; i < vi_user.size() - 1; i++)
    //* 118  259:iconst_0        
    //* 119  260:istore          10
    //* 120  262:goto            308
            text.append((new StringBuilder()).append(userset[((Integer)vi_user.get(i)).intValue()]).append(",").toString());
    //  121  265:aload           9
    //  122  267:new             #57  <Class StringBuilder>
    //  123  270:dup             
    //  124  271:invokespecial   #162 <Method void StringBuilder()>
    //  125  274:aload           4
    //  126  276:aload           7
    //  127  278:iload           10
    //  128  280:invokevirtual   #165 <Method Object Vector.get(int)>
    //  129  283:checkcast       #137 <Class Integer>
    //  130  286:invokevirtual   #168 <Method int Integer.intValue()>
    //  131  289:aaload          
    //  132  290:invokevirtual   #171 <Method StringBuilder StringBuilder.append(Object)>
    //  133  293:ldc1            #173 <String ",">
    //  134  295:invokevirtual   #78  <Method StringBuilder StringBuilder.append(String)>
    //  135  298:invokevirtual   #82  <Method String StringBuilder.toString()>
    //  136  301:invokevirtual   #159 <Method StringBuffer StringBuffer.append(String)>
    //  137  304:pop             

    //  138  305:iinc            10  1
    //  139  308:iload           10
    //  140  310:aload           7
    //  141  312:invokevirtual   #148 <Method int Vector.size()>
    //  142  315:iconst_1        
    //  143  316:isub            
    //  144  317:icmplt          265
        text.append((new StringBuilder()).append(userset[((Integer)vi_user.get(vi_user.size() - 1)).intValue()]).append("}\n").toString());
    //  145  320:aload           9
    //  146  322:new             #57  <Class StringBuilder>
    //  147  325:dup             
    //  148  326:invokespecial   #162 <Method void StringBuilder()>
    //  149  329:aload           4
    //  150  331:aload           7
    //  151  333:aload           7
    //  152  335:invokevirtual   #148 <Method int Vector.size()>
    //  153  338:iconst_1        
    //  154  339:isub            
    //  155  340:invokevirtual   #165 <Method Object Vector.get(int)>
    //  156  343:checkcast       #137 <Class Integer>
    //  157  346:invokevirtual   #168 <Method int Integer.intValue()>
    //  158  349:aaload          
    //  159  350:invokevirtual   #171 <Method StringBuilder StringBuilder.append(Object)>
    //  160  353:ldc1            #175 <String "}\n">
    //  161  355:invokevirtual   #78  <Method StringBuilder StringBuilder.append(String)>
    //  162  358:invokevirtual   #82  <Method String StringBuilder.toString()>
    //  163  361:invokevirtual   #159 <Method StringBuffer StringBuffer.append(String)>
    //  164  364:pop             
        text.append("@dimension permission {");
    //  165  365:aload           9
    //  166  367:ldc1            #177 <String "@dimension permission {">
    //  167  369:invokevirtual   #159 <Method StringBuffer StringBuffer.append(String)>
    //  168  372:pop             
        for(int i = 0; i < selectedPerms.length - 1; i++)
    //* 169  373:iconst_0        
    //* 170  374:istore          10
    //* 171  376:goto            412
            text.append((new StringBuilder(String.valueOf(selectedPerms[i]))).append(",").toString());
    //  172  379:aload           9
    //  173  381:new             #57  <Class StringBuilder>
    //  174  384:dup             
    //  175  385:getstatic       #41  <Field String[] selectedPerms>
    //  176  388:iload           10
    //  177  390:aaload          
    //  178  391:invokestatic    #69  <Method String String.valueOf(Object)>
    //  179  394:invokespecial   #72  <Method void StringBuilder(String)>
    //  180  397:ldc1            #173 <String ",">
    //  181  399:invokevirtual   #78  <Method StringBuilder StringBuilder.append(String)>
    //  182  402:invokevirtual   #82  <Method String StringBuilder.toString()>
    //  183  405:invokevirtual   #159 <Method StringBuffer StringBuffer.append(String)>
    //  184  408:pop             

    //  185  409:iinc            10  1
    //  186  412:iload           10
    //  187  414:getstatic       #41  <Field String[] selectedPerms>
    //  188  417:arraylength     
    //  189  418:iconst_1        
    //  190  419:isub            
    //  191  420:icmplt          379
        text.append((new StringBuilder(String.valueOf(selectedPerms[selectedPerms.length - 1]))).append("}\n").toString());
    //  192  423:aload           9
    //  193  425:new             #57  <Class StringBuilder>
    //  194  428:dup             
    //  195  429:getstatic       #41  <Field String[] selectedPerms>
    //  196  432:getstatic       #41  <Field String[] selectedPerms>
    //  197  435:arraylength     
    //  198  436:iconst_1        
    //  199  437:isub            
    //  200  438:aaload          
    //  201  439:invokestatic    #69  <Method String String.valueOf(Object)>
    //  202  442:invokespecial   #72  <Method void StringBuilder(String)>
    //  203  445:ldc1            #175 <String "}\n">
    //  204  447:invokevirtual   #78  <Method StringBuilder StringBuilder.append(String)>
    //  205  450:invokevirtual   #82  <Method String StringBuilder.toString()>
    //  206  453:invokevirtual   #159 <Method StringBuffer StringBuffer.append(String)>
    //  207  456:pop             
        text.append("@matrix\n");
    //  208  457:aload           9
    //  209  459:ldc1            #179 <String "@matrix\n">
    //  210  461:invokevirtual   #159 <Method StringBuffer StringBuffer.append(String)>
    //  211  464:pop             
        for(int i = 0; i < vi_user.size(); i++)
    //* 212  465:iconst_0        
    //* 213  466:istore          10
    //* 214  468:goto            566
        {
            for(int j = 0; j < selectedPerms.length; j++)
    //* 215  471:iconst_0        
    //* 216  472:istore          11
    //* 217  474:goto            554
            {
                int k = -1;
    //  218  477:iconst_m1       
    //  219  478:istore          12
                for(k = 0; k < permset.length; k++)
    //* 220  480:iconst_0        
    //* 221  481:istore          12
    //* 222  483:goto            509
                    if(selectedPerms[j].equals(permset[k]))
    //* 223  486:getstatic       #41  <Field String[] selectedPerms>
    //* 224  489:iload           11
    //* 225  491:aaload          
    //* 226  492:aload           5
    //* 227  494:iload           12
    //* 228  496:aaload          
    //* 229  497:invokevirtual   #182 <Method boolean String.equals(Object)>
    //* 230  500:ifeq            506
                        break;
    //  231  503:goto            517

    //  232  506:iinc            12  1
    //  233  509:iload           12
    //  234  511:aload           5
    //  235  513:arraylength     
    //  236  514:icmplt          486
                if(mat.get(((Integer)vi_user.get(i)).intValue(), k) == 1)
    //* 237  517:aload           6
    //* 238  519:aload           7
    //* 239  521:iload           10
    //* 240  523:invokevirtual   #165 <Method Object Vector.get(int)>
    //* 241  526:checkcast       #137 <Class Integer>
    //* 242  529:invokevirtual   #168 <Method int Integer.intValue()>
    //* 243  532:iload           12
    //* 244  534:invokevirtual   #131 <Method byte Matrix.get(int, int)>
    //* 245  537:iconst_1        
    //* 246  538:icmpne          551
                    smallmat.set(i, j, (byte)1);
    //  247  541:aload           8
    //  248  543:iload           10
    //  249  545:iload           11
    //  250  547:iconst_1        
    //  251  548:invokevirtual   #185 <Method void Matrix.set(int, int, byte)>
            }

    //  252  551:iinc            11  1
    //  253  554:iload           11
    //  254  556:getstatic       #41  <Field String[] selectedPerms>
    //  255  559:arraylength     
    //  256  560:icmplt          477
        }

    //  257  563:iinc            10  1
    //  258  566:iload           10
    //  259  568:aload           7
    //  260  570:invokevirtual   #148 <Method int Vector.size()>
    //  261  573:icmplt          471
        for(int i = 0; i < vi_user.size(); i++)
    //* 262  576:iconst_0        
    //* 263  577:istore          10
    //* 264  579:goto            657
        {
            for(int j = 0; j < selectedPerms.length; j++)
    //* 265  582:iconst_0        
    //* 266  583:istore          11
    //* 267  585:goto            624
                text.append((new StringBuilder(String.valueOf(smallmat.get(i, j)))).append(",").toString());
    //  268  588:aload           9
    //  269  590:new             #57  <Class StringBuilder>
    //  270  593:dup             
    //  271  594:aload           8
    //  272  596:iload           10
    //  273  598:iload           11
    //  274  600:invokevirtual   #131 <Method byte Matrix.get(int, int)>
    //  275  603:invokestatic    #188 <Method String String.valueOf(int)>
    //  276  606:invokespecial   #72  <Method void StringBuilder(String)>
    //  277  609:ldc1            #173 <String ",">
    //  278  611:invokevirtual   #78  <Method StringBuilder StringBuilder.append(String)>
    //  279  614:invokevirtual   #82  <Method String StringBuilder.toString()>
    //  280  617:invokevirtual   #159 <Method StringBuffer StringBuffer.append(String)>
    //  281  620:pop             

    //  282  621:iinc            11  1
    //  283  624:iload           11
    //  284  626:getstatic       #41  <Field String[] selectedPerms>
    //  285  629:arraylength     
    //  286  630:icmplt          588
            text.deleteCharAt(text.length() - 1);
    //  287  633:aload           9
    //  288  635:aload           9
    //  289  637:invokevirtual   #191 <Method int StringBuffer.length()>
    //  290  640:iconst_1        
    //  291  641:isub            
    //  292  642:invokevirtual   #195 <Method StringBuffer StringBuffer.deleteCharAt(int)>
    //  293  645:pop             
            text.append('\n');
    //  294  646:aload           9
    //  295  648:bipush          10
    //  296  650:invokevirtual   #198 <Method StringBuffer StringBuffer.append(char)>
    //  297  653:pop             
        }

    //  298  654:iinc            10  1
    //  299  657:iload           10
    //  300  659:aload           7
    //  301  661:invokevirtual   #148 <Method int Vector.size()>
    //  302  664:icmplt          582
        text.append('\n');
    //  303  667:aload           9
    //  304  669:bipush          10
    //  305  671:invokevirtual   #198 <Method StringBuffer StringBuffer.append(char)>
    //  306  674:pop             
        Vector v_p = new Vector();
    //  307  675:new             #124 <Class Vector>
    //  308  678:dup             
    //  309  679:invokespecial   #125 <Method void Vector()>
    //  310  682:astore          10
        for(int i = 0; i < vi_user.size(); i++)
    //* 311  684:iconst_0        
    //* 312  685:istore          11
    //* 313  687:goto            735
        {
            String pi = getPosition((String)userset[((Integer)vi_user.get(i)).intValue()]);
    //  314  690:aload           4
    //  315  692:aload           7
    //  316  694:iload           11
    //  317  696:invokevirtual   #165 <Method Object Vector.get(int)>
    //  318  699:checkcast       #137 <Class Integer>
    //  319  702:invokevirtual   #168 <Method int Integer.intValue()>
    //  320  705:aaload          
    //  321  706:checkcast       #11  <Class String>
    //  322  709:invokestatic    #201 <Method String getPosition(String)>
    //  323  712:astore          12
            if(!v_p.contains(pi))
    //* 324  714:aload           10
    //* 325  716:aload           12
    //* 326  718:invokevirtual   #204 <Method boolean Vector.contains(Object)>
    //* 327  721:ifne            732
                v_p.add(pi);
    //  328  724:aload           10
    //  329  726:aload           12
    //  330  728:invokevirtual   #144 <Method boolean Vector.add(Object)>
    //  331  731:pop             
        }

    //  332  732:iinc            11  1
    //  333  735:iload           11
    //  334  737:aload           7
    //  335  739:invokevirtual   #148 <Method int Vector.size()>
    //  336  742:icmplt          690
        text.append("@atributesof user\n");
    //  337  745:aload           9
    //  338  747:ldc1            #206 <String "@atributesof user\n">
    //  339  749:invokevirtual   #159 <Method StringBuffer StringBuffer.append(String)>
    //  340  752:pop             
        text.append("@attribute post {");
    //  341  753:aload           9
    //  342  755:ldc1            #208 <String "@attribute post {">
    //  343  757:invokevirtual   #159 <Method StringBuffer StringBuffer.append(String)>
    //  344  760:pop             
        for(int j = 0; j < v_p.size(); j++)
    //* 345  761:iconst_0        
    //* 346  762:istore          11
    //* 347  764:goto            804
            text.append((new StringBuilder(String.valueOf((String)v_p.get(j)))).append(",").toString());
    //  348  767:aload           9
    //  349  769:new             #57  <Class StringBuilder>
    //  350  772:dup             
    //  351  773:aload           10
    //  352  775:iload           11
    //  353  777:invokevirtual   #165 <Method Object Vector.get(int)>
    //  354  780:checkcast       #11  <Class String>
    //  355  783:invokestatic    #69  <Method String String.valueOf(Object)>
    //  356  786:invokespecial   #72  <Method void StringBuilder(String)>
    //  357  789:ldc1            #173 <String ",">
    //  358  791:invokevirtual   #78  <Method StringBuilder StringBuilder.append(String)>
    //  359  794:invokevirtual   #82  <Method String StringBuilder.toString()>
    //  360  797:invokevirtual   #159 <Method StringBuffer StringBuffer.append(String)>
    //  361  800:pop             

    //  362  801:iinc            11  1
    //  363  804:iload           11
    //  364  806:aload           10
    //  365  808:invokevirtual   #148 <Method int Vector.size()>
    //  366  811:icmplt          767
        text.deleteCharAt(text.length() - 1);
    //  367  814:aload           9
    //  368  816:aload           9
    //  369  818:invokevirtual   #191 <Method int StringBuffer.length()>
    //  370  821:iconst_1        
    //  371  822:isub            
    //  372  823:invokevirtual   #195 <Method StringBuffer StringBuffer.deleteCharAt(int)>
    //  373  826:pop             
        text.append("}\n");
    //  374  827:aload           9
    //  375  829:ldc1            #175 <String "}\n">
    //  376  831:invokevirtual   #159 <Method StringBuffer StringBuffer.append(String)>
    //  377  834:pop             
        text.append("@data\n");
    //  378  835:aload           9
    //  379  837:ldc1            #210 <String "@data\n">
    //  380  839:invokevirtual   #159 <Method StringBuffer StringBuffer.append(String)>
    //  381  842:pop             
        for(int i = 0; i < vi_user.size(); i++)
    //* 382  843:iconst_0        
    //* 383  844:istore          11
    //* 384  846:goto            902
        {
            String pi = getPosition((String)userset[((Integer)vi_user.get(i)).intValue()]);
    //  385  849:aload           4
    //  386  851:aload           7
    //  387  853:iload           11
    //  388  855:invokevirtual   #165 <Method Object Vector.get(int)>
    //  389  858:checkcast       #137 <Class Integer>
    //  390  861:invokevirtual   #168 <Method int Integer.intValue()>
    //  391  864:aaload          
    //  392  865:checkcast       #11  <Class String>
    //  393  868:invokestatic    #201 <Method String getPosition(String)>
    //  394  871:astore          12
            text.append((new StringBuilder(String.valueOf(pi))).append("\n").toString());
    //  395  873:aload           9
    //  396  875:new             #57  <Class StringBuilder>
    //  397  878:dup             
    //  398  879:aload           12
    //  399  881:invokestatic    #69  <Method String String.valueOf(Object)>
    //  400  884:invokespecial   #72  <Method void StringBuilder(String)>
    //  401  887:ldc1            #212 <String "\n">
    //  402  889:invokevirtual   #78  <Method StringBuilder StringBuilder.append(String)>
    //  403  892:invokevirtual   #82  <Method String StringBuilder.toString()>
    //  404  895:invokevirtual   #159 <Method StringBuffer StringBuffer.append(String)>
    //  405  898:pop             
        }

    //  406  899:iinc            11  1
    //  407  902:iload           11
    //  408  904:aload           7
    //  409  906:invokevirtual   #148 <Method int Vector.size()>
    //  410  909:icmplt          849
        Vector v_op = new Vector();
    //  411  912:new             #124 <Class Vector>
    //  412  915:dup             
    //  413  916:invokespecial   #125 <Method void Vector()>
    //  414  919:astore          11
        Vector v_rs = new Vector();
    //  415  921:new             #124 <Class Vector>
    //  416  924:dup             
    //  417  925:invokespecial   #125 <Method void Vector()>
    //  418  928:astore          12
        for(int j = 0; j < selectedPerms.length; j++)
    //* 419  930:iconst_0        
    //* 420  931:istore          13
    //* 421  933:goto            996
        {
            String opandrs[] = selectedPerms[j].split("_");
    //  422  936:getstatic       #41  <Field String[] selectedPerms>
    //  423  939:iload           13
    //  424  941:aaload          
    //  425  942:ldc1            #214 <String "_">
    //  426  944:invokevirtual   #218 <Method String[] String.split(String)>
    //  427  947:astore          14
            if(!v_op.contains(opandrs[0]))
    //* 428  949:aload           11
    //* 429  951:aload           14
    //* 430  953:iconst_0        
    //* 431  954:aaload          
    //* 432  955:invokevirtual   #204 <Method boolean Vector.contains(Object)>
    //* 433  958:ifne            971
                v_op.add(opandrs[0]);
    //  434  961:aload           11
    //  435  963:aload           14
    //  436  965:iconst_0        
    //  437  966:aaload          
    //  438  967:invokevirtual   #144 <Method boolean Vector.add(Object)>
    //  439  970:pop             
            if(!v_rs.contains(opandrs[1]))
    //* 440  971:aload           12
    //* 441  973:aload           14
    //* 442  975:iconst_1        
    //* 443  976:aaload          
    //* 444  977:invokevirtual   #204 <Method boolean Vector.contains(Object)>
    //* 445  980:ifne            993
                v_rs.add(opandrs[1]);
    //  446  983:aload           12
    //  447  985:aload           14
    //  448  987:iconst_1        
    //  449  988:aaload          
    //  450  989:invokevirtual   #144 <Method boolean Vector.add(Object)>
    //  451  992:pop             
        }

    //  452  993:iinc            13  1
    //  453  996:iload           13
    //  454  998:getstatic       #41  <Field String[] selectedPerms>
    //  455 1001:arraylength     
    //  456 1002:icmplt          936
        text.append("\n@atributesof permission\n");
    //  457 1005:aload           9
    //  458 1007:ldc1            #220 <String "\n@atributesof permission\n">
    //  459 1009:invokevirtual   #159 <Method StringBuffer StringBuffer.append(String)>
    //  460 1012:pop             
        text.append("@attribute operation {");
    //  461 1013:aload           9
    //  462 1015:ldc1            #222 <String "@attribute operation {">
    //  463 1017:invokevirtual   #159 <Method StringBuffer StringBuffer.append(String)>
    //  464 1020:pop             
        for(int j = 0; j < v_op.size(); j++)
    //* 465 1021:iconst_0        
    //* 466 1022:istore          13
    //* 467 1024:goto            1064
            text.append((new StringBuilder(String.valueOf((String)v_op.get(j)))).append(",").toString());
    //  468 1027:aload           9
    //  469 1029:new             #57  <Class StringBuilder>
    //  470 1032:dup             
    //  471 1033:aload           11
    //  472 1035:iload           13
    //  473 1037:invokevirtual   #165 <Method Object Vector.get(int)>
    //  474 1040:checkcast       #11  <Class String>
    //  475 1043:invokestatic    #69  <Method String String.valueOf(Object)>
    //  476 1046:invokespecial   #72  <Method void StringBuilder(String)>
    //  477 1049:ldc1            #173 <String ",">
    //  478 1051:invokevirtual   #78  <Method StringBuilder StringBuilder.append(String)>
    //  479 1054:invokevirtual   #82  <Method String StringBuilder.toString()>
    //  480 1057:invokevirtual   #159 <Method StringBuffer StringBuffer.append(String)>
    //  481 1060:pop             

    //  482 1061:iinc            13  1
    //  483 1064:iload           13
    //  484 1066:aload           11
    //  485 1068:invokevirtual   #148 <Method int Vector.size()>
    //  486 1071:icmplt          1027
        text.deleteCharAt(text.length() - 1);
    //  487 1074:aload           9
    //  488 1076:aload           9
    //  489 1078:invokevirtual   #191 <Method int StringBuffer.length()>
    //  490 1081:iconst_1        
    //  491 1082:isub            
    //  492 1083:invokevirtual   #195 <Method StringBuffer StringBuffer.deleteCharAt(int)>
    //  493 1086:pop             
        text.append("}\n");
    //  494 1087:aload           9
    //  495 1089:ldc1            #175 <String "}\n">
    //  496 1091:invokevirtual   #159 <Method StringBuffer StringBuffer.append(String)>
    //  497 1094:pop             
        text.append("@attribute resource {");
    //  498 1095:aload           9
    //  499 1097:ldc1            #224 <String "@attribute resource {">
    //  500 1099:invokevirtual   #159 <Method StringBuffer StringBuffer.append(String)>
    //  501 1102:pop             
        for(int j = 0; j < v_rs.size(); j++)
    //* 502 1103:iconst_0        
    //* 503 1104:istore          13
    //* 504 1106:goto            1146
            text.append((new StringBuilder(String.valueOf((String)v_rs.get(j)))).append(",").toString());
    //  505 1109:aload           9
    //  506 1111:new             #57  <Class StringBuilder>
    //  507 1114:dup             
    //  508 1115:aload           12
    //  509 1117:iload           13
    //  510 1119:invokevirtual   #165 <Method Object Vector.get(int)>
    //  511 1122:checkcast       #11  <Class String>
    //  512 1125:invokestatic    #69  <Method String String.valueOf(Object)>
    //  513 1128:invokespecial   #72  <Method void StringBuilder(String)>
    //  514 1131:ldc1            #173 <String ",">
    //  515 1133:invokevirtual   #78  <Method StringBuilder StringBuilder.append(String)>
    //  516 1136:invokevirtual   #82  <Method String StringBuilder.toString()>
    //  517 1139:invokevirtual   #159 <Method StringBuffer StringBuffer.append(String)>
    //  518 1142:pop             

    //  519 1143:iinc            13  1
    //  520 1146:iload           13
    //  521 1148:aload           12
    //  522 1150:invokevirtual   #148 <Method int Vector.size()>
    //  523 1153:icmplt          1109
        text.deleteCharAt(text.length() - 1);
    //  524 1156:aload           9
    //  525 1158:aload           9
    //  526 1160:invokevirtual   #191 <Method int StringBuffer.length()>
    //  527 1163:iconst_1        
    //  528 1164:isub            
    //  529 1165:invokevirtual   #195 <Method StringBuffer StringBuffer.deleteCharAt(int)>
    //  530 1168:pop             
        text.append("}\n");
    //  531 1169:aload           9
    //  532 1171:ldc1            #175 <String "}\n">
    //  533 1173:invokevirtual   #159 <Method StringBuffer StringBuffer.append(String)>
    //  534 1176:pop             
        text.append("@data\n");
    //  535 1177:aload           9
    //  536 1179:ldc1            #210 <String "@data\n">
    //  537 1181:invokevirtual   #159 <Method StringBuffer StringBuffer.append(String)>
    //  538 1184:pop             
        for(int j = 0; j < selectedPerms.length; j++)
    //* 539 1185:iconst_0        
    //* 540 1186:istore          13
    //* 541 1188:goto            1247
        {
            String opandrs[] = selectedPerms[j].split("_");
    //  542 1191:getstatic       #41  <Field String[] selectedPerms>
    //  543 1194:iload           13
    //  544 1196:aaload          
    //  545 1197:ldc1            #214 <String "_">
    //  546 1199:invokevirtual   #218 <Method String[] String.split(String)>
    //  547 1202:astore          14
            text.append((new StringBuilder(String.valueOf(opandrs[0]))).append(",").append(opandrs[1]).append("\n").toString());
    //  548 1204:aload           9
    //  549 1206:new             #57  <Class StringBuilder>
    //  550 1209:dup             
    //  551 1210:aload           14
    //  552 1212:iconst_0        
    //  553 1213:aaload          
    //  554 1214:invokestatic    #69  <Method String String.valueOf(Object)>
    //  555 1217:invokespecial   #72  <Method void StringBuilder(String)>
    //  556 1220:ldc1            #173 <String ",">
    //  557 1222:invokevirtual   #78  <Method StringBuilder StringBuilder.append(String)>
    //  558 1225:aload           14
    //  559 1227:iconst_1        
    //  560 1228:aaload          
    //  561 1229:invokevirtual   #78  <Method StringBuilder StringBuilder.append(String)>
    //  562 1232:ldc1            #212 <String "\n">
    //  563 1234:invokevirtual   #78  <Method StringBuilder StringBuilder.append(String)>
    //  564 1237:invokevirtual   #82  <Method String StringBuilder.toString()>
    //  565 1240:invokevirtual   #159 <Method StringBuffer StringBuffer.append(String)>
    //  566 1243:pop             
        }

    //  567 1244:iinc            13  1
    //  568 1247:iload           13
    //  569 1249:getstatic       #41  <Field String[] selectedPerms>
    //  570 1252:arraylength     
    //  571 1253:icmplt          1191
        System.out.println(text.toString());
    //  572 1256:getstatic       #228 <Field PrintStream System.out>
    //  573 1259:aload           9
    //  574 1261:invokevirtual   #229 <Method String StringBuffer.toString()>
    //  575 1264:invokevirtual   #234 <Method void PrintStream.println(String)>
        File output = new File((new StringBuilder(String.valueOf(System.getProperty("user.dir")))).append("\\datasets\\university_runningexample.ass").toString());
    //  576 1267:new             #55  <Class File>
    //  577 1270:dup             
    //  578 1271:new             #57  <Class StringBuilder>
    //  579 1274:dup             
    //  580 1275:ldc1            #59  <String "user.dir">
    //  581 1277:invokestatic    #65  <Method String System.getProperty(String)>
    //  582 1280:invokestatic    #69  <Method String String.valueOf(Object)>
    //  583 1283:invokespecial   #72  <Method void StringBuilder(String)>
    //  584 1286:ldc1            #236 <String "\\datasets\\university_runningexample.ass">
    //  585 1288:invokevirtual   #78  <Method StringBuilder StringBuilder.append(String)>
    //  586 1291:invokevirtual   #82  <Method String StringBuilder.toString()>
    //  587 1294:invokespecial   #83  <Method void File(String)>
    //  588 1297:astore          13
        FileWriter fw = new FileWriter(output);
    //  589 1299:new             #238 <Class FileWriter>
    //  590 1302:dup             
    //  591 1303:aload           13
    //  592 1305:invokespecial   #239 <Method void FileWriter(File)>
    //  593 1308:astore          14
        fw.append(text.toString());
    //  594 1310:aload           14
    //  595 1312:aload           9
    //  596 1314:invokevirtual   #229 <Method String StringBuffer.toString()>
    //  597 1317:invokevirtual   #242 <Method java.io.Writer FileWriter.append(CharSequence)>
    //  598 1320:pop             
        fw.close();
    //  599 1321:aload           14
    //  600 1323:invokevirtual   #245 <Method void FileWriter.close()>
    //  601 1326:return          
    }

    private static boolean findPerm(String perm)
    {
        int k = 0;
    //    0    0:iconst_0        
    //    1    1:istore_1        
        for(k = 0; k < selectedPerms.length; k++)
    //*   2    2:iconst_0        
    //*   3    3:istore_1        
    //*   4    4:goto            25
            if(selectedPerms[k].equals(perm))
    //*   5    7:getstatic       #41  <Field String[] selectedPerms>
    //*   6   10:iload_1         
    //*   7   11:aaload          
    //*   8   12:aload_0         
    //*   9   13:invokevirtual   #182 <Method boolean String.equals(Object)>
    //*  10   16:ifeq            22
                break;
    //   11   19:goto            33

    //   12   22:iinc            1  1
    //   13   25:iload_1         
    //   14   26:getstatic       #41  <Field String[] selectedPerms>
    //   15   29:arraylength     
    //   16   30:icmplt          7
        return k < selectedPerms.length;
    //   17   33:iload_1         
    //   18   34:getstatic       #41  <Field String[] selectedPerms>
    //   19   37:arraylength     
    //   20   38:icmpge          43
    //   21   41:iconst_1        
    //   22   42:ireturn         
    //   23   43:iconst_0        
    //   24   44:ireturn         
    }

    private static String getPosition(String ui)
    {
        StringBuffer p = new StringBuffer();
    //    0    0:new             #153 <Class StringBuffer>
    //    1    3:dup             
    //    2    4:invokespecial   #154 <Method void StringBuffer()>
    //    3    7:astore_1        
        for(int i = 0; i < ui.length(); i++)
    //*   4    8:iconst_0        
    //*   5    9:istore_2        
    //*   6   10:goto            46
            if(ui.charAt(i) < '0' || ui.charAt(i) > '9')
    //*   7   13:aload_0         
    //*   8   14:iload_2         
    //*   9   15:invokevirtual   #284 <Method char String.charAt(int)>
    //*  10   18:bipush          48
    //*  11   20:icmplt          33
    //*  12   23:aload_0         
    //*  13   24:iload_2         
    //*  14   25:invokevirtual   #284 <Method char String.charAt(int)>
    //*  15   28:bipush          57
    //*  16   30:icmple          43
                p.append(ui.charAt(i));
    //   17   33:aload_1         
    //   18   34:aload_0         
    //   19   35:iload_2         
    //   20   36:invokevirtual   #284 <Method char String.charAt(int)>
    //   21   39:invokevirtual   #198 <Method StringBuffer StringBuffer.append(char)>
    //   22   42:pop             

    //   23   43:iinc            2  1
    //   24   46:iload_2         
    //   25   47:aload_0         
    //   26   48:invokevirtual   #285 <Method int String.length()>
    //   27   51:icmplt          13
        return p.toString();
    //   28   54:aload_1         
    //   29   55:invokevirtual   #229 <Method String StringBuffer.toString()>
    //   30   58:areturn         
    }

    private static String selectedPerms[] = {
        "viewGrade_GradeBook", "create_ComputerAccount", "obtain_StudentParkingPermit", "register_Course", "pay_Tuition", "register_GradClass", "withdraw_GradClass", "enroll_StudentHealthInsur", "register_UndergradClass", "withdraw_UndergradClass", 
        "register_UndergradHonorsClass", "withdraw_UndergradHonorsClass", "assignGrade_GradeBook", "reserveRoom_RoomSchedule"
    };

    static 
    {
    //    0    0:bipush          14
    //    1    2:anewarray       String[]
    //    2    5:dup             
    //    3    6:iconst_0        
    //    4    7:ldc1            #13  <String "viewGrade_GradeBook">
    //    5    9:aastore         
    //    6   10:dup             
    //    7   11:iconst_1        
    //    8   12:ldc1            #15  <String "create_ComputerAccount">
    //    9   14:aastore         
    //   10   15:dup             
    //   11   16:iconst_2        
    //   12   17:ldc1            #17  <String "obtain_StudentParkingPermit">
    //   13   19:aastore         
    //   14   20:dup             
    //   15   21:iconst_3        
    //   16   22:ldc1            #19  <String "register_Course">
    //   17   24:aastore         
    //   18   25:dup             
    //   19   26:iconst_4        
    //   20   27:ldc1            #21  <String "pay_Tuition">
    //   21   29:aastore         
    //   22   30:dup             
    //   23   31:iconst_5        
    //   24   32:ldc1            #23  <String "register_GradClass">
    //   25   34:aastore         
    //   26   35:dup             
    //   27   36:bipush          6
    //   28   38:ldc1            #25  <String "withdraw_GradClass">
    //   29   40:aastore         
    //   30   41:dup             
    //   31   42:bipush          7
    //   32   44:ldc1            #27  <String "enroll_StudentHealthInsur">
    //   33   46:aastore         
    //   34   47:dup             
    //   35   48:bipush          8
    //   36   50:ldc1            #29  <String "register_UndergradClass">
    //   37   52:aastore         
    //   38   53:dup             
    //   39   54:bipush          9
    //   40   56:ldc1            #31  <String "withdraw_UndergradClass">
    //   41   58:aastore         
    //   42   59:dup             
    //   43   60:bipush          10
    //   44   62:ldc1            #33  <String "register_UndergradHonorsClass">
    //   45   64:aastore         
    //   46   65:dup             
    //   47   66:bipush          11
    //   48   68:ldc1            #35  <String "withdraw_UndergradHonorsClass">
    //   49   70:aastore         
    //   50   71:dup             
    //   51   72:bipush          12
    //   52   74:ldc1            #37  <String "assignGrade_GradeBook">
    //   53   76:aastore         
    //   54   77:dup             
    //   55   78:bipush          13
    //   56   80:ldc1            #39  <String "reserveRoom_RoomSchedule">
    //   57   82:aastore         
    //   58   83:putstatic       #41  <Field String[] selectedPerms>
    //*  59   86:return          
    }
}
