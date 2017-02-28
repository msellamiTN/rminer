// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   EigenvalueDecomposition.java

package rm.core.matrix;

import java.io.Serializable;

// Referenced classes of package rm.core.matrix:
//            Maths, Matrix

public class EigenvalueDecomposition
    implements Serializable
{

    private void tred2()
    {
        for(int j = 0; j < n; j++)
    //*   0    0:iconst_0        
    //*   1    1:istore_1        
    //*   2    2:goto            27
            d[j] = V[n - 1][j];
    //    3    5:aload_0         
    //    4    6:getfield        #25  <Field double[] d>
    //    5    9:iload_1         
    //    6   10:aload_0         
    //    7   11:getfield        #27  <Field double[][] V>
    //    8   14:aload_0         
    //    9   15:getfield        #29  <Field int n>
    //   10   18:iconst_1        
    //   11   19:isub            
    //   12   20:aaload          
    //   13   21:iload_1         
    //   14   22:daload          
    //   15   23:dastore         

    //   16   24:iinc            1  1
    //   17   27:iload_1         
    //   18   28:aload_0         
    //   19   29:getfield        #29  <Field int n>
    //   20   32:icmplt          5
        for(int i = n - 1; i > 0; i--)
    //*  21   35:aload_0         
    //*  22   36:getfield        #29  <Field int n>
    //*  23   39:iconst_1        
    //*  24   40:isub            
    //*  25   41:istore_1        
    //*  26   42:goto            637
        {
            double scale = 0.0D;
    //   27   45:dconst_0        
    //   28   46:dstore_2        
            double h = 0.0D;
    //   29   47:dconst_0        
    //   30   48:dstore          4
            for(int k = 0; k < i; k++)
    //*  31   50:iconst_0        
    //*  32   51:istore          6
    //*  33   53:goto            72
                scale += Math.abs(d[k]);
    //   34   56:dload_2         
    //   35   57:aload_0         
    //   36   58:getfield        #25  <Field double[] d>
    //   37   61:iload           6
    //   38   63:daload          
    //   39   64:invokestatic    #35  <Method double Math.abs(double)>
    //   40   67:dadd            
    //   41   68:dstore_2        

    //   42   69:iinc            6  1
    //   43   72:iload           6
    //   44   74:iload_1         
    //   45   75:icmplt          56
            if(scale == 0.0D)
    //*  46   78:dload_2         
    //*  47   79:dconst_0        
    //*  48   80:dcmpl           
    //*  49   81:ifne            154
            {
                e[i] = d[i - 1];
    //   50   84:aload_0         
    //   51   85:getfield        #37  <Field double[] e>
    //   52   88:iload_1         
    //   53   89:aload_0         
    //   54   90:getfield        #25  <Field double[] d>
    //   55   93:iload_1         
    //   56   94:iconst_1        
    //   57   95:isub            
    //   58   96:daload          
    //   59   97:dastore         
                for(int j = 0; j < i; j++)
    //*  60   98:iconst_0        
    //*  61   99:istore          6
    //*  62  101:goto            145
                {
                    d[j] = V[i - 1][j];
    //   63  104:aload_0         
    //   64  105:getfield        #25  <Field double[] d>
    //   65  108:iload           6
    //   66  110:aload_0         
    //   67  111:getfield        #27  <Field double[][] V>
    //   68  114:iload_1         
    //   69  115:iconst_1        
    //   70  116:isub            
    //   71  117:aaload          
    //   72  118:iload           6
    //   73  120:daload          
    //   74  121:dastore         
                    V[i][j] = 0.0D;
    //   75  122:aload_0         
    //   76  123:getfield        #27  <Field double[][] V>
    //   77  126:iload_1         
    //   78  127:aaload          
    //   79  128:iload           6
    //   80  130:dconst_0        
    //   81  131:dastore         
                    V[j][i] = 0.0D;
    //   82  132:aload_0         
    //   83  133:getfield        #27  <Field double[][] V>
    //   84  136:iload           6
    //   85  138:aaload          
    //   86  139:iload_1         
    //   87  140:dconst_0        
    //   88  141:dastore         
                }

    //   89  142:iinc            6  1
    //   90  145:iload           6
    //   91  147:iload_1         
    //   92  148:icmplt          104
            } else
    //*  93  151:goto            626
            {
                for(int k = 0; k < i; k++)
    //*  94  154:iconst_0        
    //*  95  155:istore          6
    //*  96  157:goto            194
                {
                    d[k] /= scale;
    //   97  160:aload_0         
    //   98  161:getfield        #25  <Field double[] d>
    //   99  164:iload           6
    //  100  166:dup2            
    //  101  167:daload          
    //  102  168:dload_2         
    //  103  169:ddiv            
    //  104  170:dastore         
                    h += d[k] * d[k];
    //  105  171:dload           4
    //  106  173:aload_0         
    //  107  174:getfield        #25  <Field double[] d>
    //  108  177:iload           6
    //  109  179:daload          
    //  110  180:aload_0         
    //  111  181:getfield        #25  <Field double[] d>
    //  112  184:iload           6
    //  113  186:daload          
    //  114  187:dmul            
    //  115  188:dadd            
    //  116  189:dstore          4
                }

    //  117  191:iinc            6  1
    //  118  194:iload           6
    //  119  196:iload_1         
    //  120  197:icmplt          160
                double f = d[i - 1];
    //  121  200:aload_0         
    //  122  201:getfield        #25  <Field double[] d>
    //  123  204:iload_1         
    //  124  205:iconst_1        
    //  125  206:isub            
    //  126  207:daload          
    //  127  208:dstore          6
                double g = Math.sqrt(h);
    //  128  210:dload           4
    //  129  212:invokestatic    #40  <Method double Math.sqrt(double)>
    //  130  215:dstore          8
                if(f > 0.0D)
    //* 131  217:dload           6
    //* 132  219:dconst_0        
    //* 133  220:dcmpl           
    //* 134  221:ifle            229
                    g = -g;
    //  135  224:dload           8
    //  136  226:dneg            
    //  137  227:dstore          8
                e[i] = scale * g;
    //  138  229:aload_0         
    //  139  230:getfield        #37  <Field double[] e>
    //  140  233:iload_1         
    //  141  234:dload_2         
    //  142  235:dload           8
    //  143  237:dmul            
    //  144  238:dastore         
                h -= f * g;
    //  145  239:dload           4
    //  146  241:dload           6
    //  147  243:dload           8
    //  148  245:dmul            
    //  149  246:dsub            
    //  150  247:dstore          4
                d[i - 1] = f - g;
    //  151  249:aload_0         
    //  152  250:getfield        #25  <Field double[] d>
    //  153  253:iload_1         
    //  154  254:iconst_1        
    //  155  255:isub            
    //  156  256:dload           6
    //  157  258:dload           8
    //  158  260:dsub            
    //  159  261:dastore         
                for(int j = 0; j < i; j++)
    //* 160  262:iconst_0        
    //* 161  263:istore          10
    //* 162  265:goto            279
                    e[j] = 0.0D;
    //  163  268:aload_0         
    //  164  269:getfield        #37  <Field double[] e>
    //  165  272:iload           10
    //  166  274:dconst_0        
    //  167  275:dastore         

    //  168  276:iinc            10  1
    //  169  279:iload           10
    //  170  281:iload_1         
    //  171  282:icmplt          268
                for(int j = 0; j < i; j++)
    //* 172  285:iconst_0        
    //* 173  286:istore          10
    //* 174  288:goto            412
                {
                    f = d[j];
    //  175  291:aload_0         
    //  176  292:getfield        #25  <Field double[] d>
    //  177  295:iload           10
    //  178  297:daload          
    //  179  298:dstore          6
                    V[j][i] = f;
    //  180  300:aload_0         
    //  181  301:getfield        #27  <Field double[][] V>
    //  182  304:iload           10
    //  183  306:aaload          
    //  184  307:iload_1         
    //  185  308:dload           6
    //  186  310:dastore         
                    g = e[j] + V[j][j] * f;
    //  187  311:aload_0         
    //  188  312:getfield        #37  <Field double[] e>
    //  189  315:iload           10
    //  190  317:daload          
    //  191  318:aload_0         
    //  192  319:getfield        #27  <Field double[][] V>
    //  193  322:iload           10
    //  194  324:aaload          
    //  195  325:iload           10
    //  196  327:daload          
    //  197  328:dload           6
    //  198  330:dmul            
    //  199  331:dadd            
    //  200  332:dstore          8
                    for(int k = j + 1; k <= i - 1; k++)
    //* 201  334:iload           10
    //* 202  336:iconst_1        
    //* 203  337:iadd            
    //* 204  338:istore          11
    //* 205  340:goto            392
                    {
                        g += V[k][j] * d[k];
    //  206  343:dload           8
    //  207  345:aload_0         
    //  208  346:getfield        #27  <Field double[][] V>
    //  209  349:iload           11
    //  210  351:aaload          
    //  211  352:iload           10
    //  212  354:daload          
    //  213  355:aload_0         
    //  214  356:getfield        #25  <Field double[] d>
    //  215  359:iload           11
    //  216  361:daload          
    //  217  362:dmul            
    //  218  363:dadd            
    //  219  364:dstore          8
                        e[k] += V[k][j] * f;
    //  220  366:aload_0         
    //  221  367:getfield        #37  <Field double[] e>
    //  222  370:iload           11
    //  223  372:dup2            
    //  224  373:daload          
    //  225  374:aload_0         
    //  226  375:getfield        #27  <Field double[][] V>
    //  227  378:iload           11
    //  228  380:aaload          
    //  229  381:iload           10
    //  230  383:daload          
    //  231  384:dload           6
    //  232  386:dmul            
    //  233  387:dadd            
    //  234  388:dastore         
                    }

    //  235  389:iinc            11  1
    //  236  392:iload           11
    //  237  394:iload_1         
    //  238  395:iconst_1        
    //  239  396:isub            
    //  240  397:icmple          343
                    e[j] = g;
    //  241  400:aload_0         
    //  242  401:getfield        #37  <Field double[] e>
    //  243  404:iload           10
    //  244  406:dload           8
    //  245  408:dastore         
                }

    //  246  409:iinc            10  1
    //  247  412:iload           10
    //  248  414:iload_1         
    //  249  415:icmplt          291
                f = 0.0D;
    //  250  418:dconst_0        
    //  251  419:dstore          6
                for(int j = 0; j < i; j++)
    //* 252  421:iconst_0        
    //* 253  422:istore          10
    //* 254  424:goto            462
                {
                    e[j] /= h;
    //  255  427:aload_0         
    //  256  428:getfield        #37  <Field double[] e>
    //  257  431:iload           10
    //  258  433:dup2            
    //  259  434:daload          
    //  260  435:dload           4
    //  261  437:ddiv            
    //  262  438:dastore         
                    f += e[j] * d[j];
    //  263  439:dload           6
    //  264  441:aload_0         
    //  265  442:getfield        #37  <Field double[] e>
    //  266  445:iload           10
    //  267  447:daload          
    //  268  448:aload_0         
    //  269  449:getfield        #25  <Field double[] d>
    //  270  452:iload           10
    //  271  454:daload          
    //  272  455:dmul            
    //  273  456:dadd            
    //  274  457:dstore          6
                }

    //  275  459:iinc            10  1
    //  276  462:iload           10
    //  277  464:iload_1         
    //  278  465:icmplt          427
                double hh = f / (h + h);
    //  279  468:dload           6
    //  280  470:dload           4
    //  281  472:dload           4
    //  282  474:dadd            
    //  283  475:ddiv            
    //  284  476:dstore          10
                for(int j = 0; j < i; j++)
    //* 285  478:iconst_0        
    //* 286  479:istore          12
    //* 287  481:goto            507
                    e[j] -= hh * d[j];
    //  288  484:aload_0         
    //  289  485:getfield        #37  <Field double[] e>
    //  290  488:iload           12
    //  291  490:dup2            
    //  292  491:daload          
    //  293  492:dload           10
    //  294  494:aload_0         
    //  295  495:getfield        #25  <Field double[] d>
    //  296  498:iload           12
    //  297  500:daload          
    //  298  501:dmul            
    //  299  502:dsub            
    //  300  503:dastore         

    //  301  504:iinc            12  1
    //  302  507:iload           12
    //  303  509:iload_1         
    //  304  510:icmplt          484
                for(int j = 0; j < i; j++)
    //* 305  513:iconst_0        
    //* 306  514:istore          12
    //* 307  516:goto            620
                {
                    f = d[j];
    //  308  519:aload_0         
    //  309  520:getfield        #25  <Field double[] d>
    //  310  523:iload           12
    //  311  525:daload          
    //  312  526:dstore          6
                    g = e[j];
    //  313  528:aload_0         
    //  314  529:getfield        #37  <Field double[] e>
    //  315  532:iload           12
    //  316  534:daload          
    //  317  535:dstore          8
                    for(int k = j; k <= i - 1; k++)
    //* 318  537:iload           12
    //* 319  539:istore          13
    //* 320  541:goto            581
                        V[k][j] -= f * e[k] + g * d[k];
    //  321  544:aload_0         
    //  322  545:getfield        #27  <Field double[][] V>
    //  323  548:iload           13
    //  324  550:aaload          
    //  325  551:iload           12
    //  326  553:dup2            
    //  327  554:daload          
    //  328  555:dload           6
    //  329  557:aload_0         
    //  330  558:getfield        #37  <Field double[] e>
    //  331  561:iload           13
    //  332  563:daload          
    //  333  564:dmul            
    //  334  565:dload           8
    //  335  567:aload_0         
    //  336  568:getfield        #25  <Field double[] d>
    //  337  571:iload           13
    //  338  573:daload          
    //  339  574:dmul            
    //  340  575:dadd            
    //  341  576:dsub            
    //  342  577:dastore         

    //  343  578:iinc            13  1
    //  344  581:iload           13
    //  345  583:iload_1         
    //  346  584:iconst_1        
    //  347  585:isub            
    //  348  586:icmple          544
                    d[j] = V[i - 1][j];
    //  349  589:aload_0         
    //  350  590:getfield        #25  <Field double[] d>
    //  351  593:iload           12
    //  352  595:aload_0         
    //  353  596:getfield        #27  <Field double[][] V>
    //  354  599:iload_1         
    //  355  600:iconst_1        
    //  356  601:isub            
    //  357  602:aaload          
    //  358  603:iload           12
    //  359  605:daload          
    //  360  606:dastore         
                    V[i][j] = 0.0D;
    //  361  607:aload_0         
    //  362  608:getfield        #27  <Field double[][] V>
    //  363  611:iload_1         
    //  364  612:aaload          
    //  365  613:iload           12
    //  366  615:dconst_0        
    //  367  616:dastore         
                }

    //  368  617:iinc            12  1
    //  369  620:iload           12
    //  370  622:iload_1         
    //  371  623:icmplt          519
            }
            d[i] = h;
    //  372  626:aload_0         
    //  373  627:getfield        #25  <Field double[] d>
    //  374  630:iload_1         
    //  375  631:dload           4
    //  376  633:dastore         
        }

    //  377  634:iinc            1  -1
    //  378  637:iload_1         
    //  379  638:ifgt            45
        for(int i = 0; i < n - 1; i++)
    //* 380  641:iconst_0        
    //* 381  642:istore_1        
    //* 382  643:goto            854
        {
            V[n - 1][i] = V[i][i];
    //  383  646:aload_0         
    //  384  647:getfield        #27  <Field double[][] V>
    //  385  650:aload_0         
    //  386  651:getfield        #29  <Field int n>
    //  387  654:iconst_1        
    //  388  655:isub            
    //  389  656:aaload          
    //  390  657:iload_1         
    //  391  658:aload_0         
    //  392  659:getfield        #27  <Field double[][] V>
    //  393  662:iload_1         
    //  394  663:aaload          
    //  395  664:iload_1         
    //  396  665:daload          
    //  397  666:dastore         
            V[i][i] = 1.0D;
    //  398  667:aload_0         
    //  399  668:getfield        #27  <Field double[][] V>
    //  400  671:iload_1         
    //  401  672:aaload          
    //  402  673:iload_1         
    //  403  674:dconst_1        
    //  404  675:dastore         
            double h = d[i + 1];
    //  405  676:aload_0         
    //  406  677:getfield        #25  <Field double[] d>
    //  407  680:iload_1         
    //  408  681:iconst_1        
    //  409  682:iadd            
    //  410  683:daload          
    //  411  684:dstore_2        
            if(h != 0.0D)
    //* 412  685:dload_2         
    //* 413  686:dconst_0        
    //* 414  687:dcmpl           
    //* 415  688:ifeq            824
            {
                for(int k = 0; k <= i; k++)
    //* 416  691:iconst_0        
    //* 417  692:istore          4
    //* 418  694:goto            720
                    d[k] = V[k][i + 1] / h;
    //  419  697:aload_0         
    //  420  698:getfield        #25  <Field double[] d>
    //  421  701:iload           4
    //  422  703:aload_0         
    //  423  704:getfield        #27  <Field double[][] V>
    //  424  707:iload           4
    //  425  709:aaload          
    //  426  710:iload_1         
    //  427  711:iconst_1        
    //  428  712:iadd            
    //  429  713:daload          
    //  430  714:dload_2         
    //  431  715:ddiv            
    //  432  716:dastore         

    //  433  717:iinc            4  1
    //  434  720:iload           4
    //  435  722:iload_1         
    //  436  723:icmple          697
                for(int j = 0; j <= i; j++)
    //* 437  726:iconst_0        
    //* 438  727:istore          4
    //* 439  729:goto            818
                {
                    double g = 0.0D;
    //  440  732:dconst_0        
    //  441  733:dstore          5
                    for(int k = 0; k <= i; k++)
    //* 442  735:iconst_0        
    //* 443  736:istore          7
    //* 444  738:goto            771
                        g += V[k][i + 1] * V[k][j];
    //  445  741:dload           5
    //  446  743:aload_0         
    //  447  744:getfield        #27  <Field double[][] V>
    //  448  747:iload           7
    //  449  749:aaload          
    //  450  750:iload_1         
    //  451  751:iconst_1        
    //  452  752:iadd            
    //  453  753:daload          
    //  454  754:aload_0         
    //  455  755:getfield        #27  <Field double[][] V>
    //  456  758:iload           7
    //  457  760:aaload          
    //  458  761:iload           4
    //  459  763:daload          
    //  460  764:dmul            
    //  461  765:dadd            
    //  462  766:dstore          5

    //  463  768:iinc            7  1
    //  464  771:iload           7
    //  465  773:iload_1         
    //  466  774:icmple          741
                    for(int k = 0; k <= i; k++)
    //* 467  777:iconst_0        
    //* 468  778:istore          7
    //* 469  780:goto            809
                        V[k][j] -= g * d[k];
    //  470  783:aload_0         
    //  471  784:getfield        #27  <Field double[][] V>
    //  472  787:iload           7
    //  473  789:aaload          
    //  474  790:iload           4
    //  475  792:dup2            
    //  476  793:daload          
    //  477  794:dload           5
    //  478  796:aload_0         
    //  479  797:getfield        #25  <Field double[] d>
    //  480  800:iload           7
    //  481  802:daload          
    //  482  803:dmul            
    //  483  804:dsub            
    //  484  805:dastore         

    //  485  806:iinc            7  1
    //  486  809:iload           7
    //  487  811:iload_1         
    //  488  812:icmple          783
                }

    //  489  815:iinc            4  1
    //  490  818:iload           4
    //  491  820:iload_1         
    //  492  821:icmple          732
            }
            for(int k = 0; k <= i; k++)
    //* 493  824:iconst_0        
    //* 494  825:istore          4
    //* 495  827:goto            845
                V[k][i + 1] = 0.0D;
    //  496  830:aload_0         
    //  497  831:getfield        #27  <Field double[][] V>
    //  498  834:iload           4
    //  499  836:aaload          
    //  500  837:iload_1         
    //  501  838:iconst_1        
    //  502  839:iadd            
    //  503  840:dconst_0        
    //  504  841:dastore         

    //  505  842:iinc            4  1
    //  506  845:iload           4
    //  507  847:iload_1         
    //  508  848:icmple          830
        }

    //  509  851:iinc            1  1
    //  510  854:iload_1         
    //  511  855:aload_0         
    //  512  856:getfield        #29  <Field int n>
    //  513  859:iconst_1        
    //  514  860:isub            
    //  515  861:icmplt          646
        for(int j = 0; j < n; j++)
    //* 516  864:iconst_0        
    //* 517  865:istore_1        
    //* 518  866:goto            905
        {
            d[j] = V[n - 1][j];
    //  519  869:aload_0         
    //  520  870:getfield        #25  <Field double[] d>
    //  521  873:iload_1         
    //  522  874:aload_0         
    //  523  875:getfield        #27  <Field double[][] V>
    //  524  878:aload_0         
    //  525  879:getfield        #29  <Field int n>
    //  526  882:iconst_1        
    //  527  883:isub            
    //  528  884:aaload          
    //  529  885:iload_1         
    //  530  886:daload          
    //  531  887:dastore         
            V[n - 1][j] = 0.0D;
    //  532  888:aload_0         
    //  533  889:getfield        #27  <Field double[][] V>
    //  534  892:aload_0         
    //  535  893:getfield        #29  <Field int n>
    //  536  896:iconst_1        
    //  537  897:isub            
    //  538  898:aaload          
    //  539  899:iload_1         
    //  540  900:dconst_0        
    //  541  901:dastore         
        }

    //  542  902:iinc            1  1
    //  543  905:iload_1         
    //  544  906:aload_0         
    //  545  907:getfield        #29  <Field int n>
    //  546  910:icmplt          869
        V[n - 1][n - 1] = 1.0D;
    //  547  913:aload_0         
    //  548  914:getfield        #27  <Field double[][] V>
    //  549  917:aload_0         
    //  550  918:getfield        #29  <Field int n>
    //  551  921:iconst_1        
    //  552  922:isub            
    //  553  923:aaload          
    //  554  924:aload_0         
    //  555  925:getfield        #29  <Field int n>
    //  556  928:iconst_1        
    //  557  929:isub            
    //  558  930:dconst_1        
    //  559  931:dastore         
        e[0] = 0.0D;
    //  560  932:aload_0         
    //  561  933:getfield        #37  <Field double[] e>
    //  562  936:iconst_0        
    //  563  937:dconst_0        
    //  564  938:dastore         
    //  565  939:return          
    }

    private void tql2()
    {
        for(int i = 1; i < n; i++)
    //*   0    0:iconst_1        
    //*   1    1:istore_1        
    //*   2    2:goto            22
            e[i - 1] = e[i];
    //    3    5:aload_0         
    //    4    6:getfield        #37  <Field double[] e>
    //    5    9:iload_1         
    //    6   10:iconst_1        
    //    7   11:isub            
    //    8   12:aload_0         
    //    9   13:getfield        #37  <Field double[] e>
    //   10   16:iload_1         
    //   11   17:daload          
    //   12   18:dastore         

    //   13   19:iinc            1  1
    //   14   22:iload_1         
    //   15   23:aload_0         
    //   16   24:getfield        #29  <Field int n>
    //   17   27:icmplt          5
        e[n - 1] = 0.0D;
    //   18   30:aload_0         
    //   19   31:getfield        #37  <Field double[] e>
    //   20   34:aload_0         
    //   21   35:getfield        #29  <Field int n>
    //   22   38:iconst_1        
    //   23   39:isub            
    //   24   40:dconst_0        
    //   25   41:dastore         
        double f = 0.0D;
    //   26   42:dconst_0        
    //   27   43:dstore_1        
        double tst1 = 0.0D;
    //   28   44:dconst_0        
    //   29   45:dstore_3        
        double eps = Math.pow(2D, -52D);
    //   30   46:ldc2w           #54  <Double 2D>
    //   31   49:ldc2w           #56  <Double -52D>
    //   32   52:invokestatic    #61  <Method double Math.pow(double, double)>
    //   33   55:dstore          5
        for(int l = 0; l < n; l++)
    //*  34   57:iconst_0        
    //*  35   58:istore          7
    //*  36   60:goto            669
        {
            tst1 = Math.max(tst1, Math.abs(d[l]) + Math.abs(e[l]));
    //   37   63:dload_3         
    //   38   64:aload_0         
    //   39   65:getfield        #25  <Field double[] d>
    //   40   68:iload           7
    //   41   70:daload          
    //   42   71:invokestatic    #35  <Method double Math.abs(double)>
    //   43   74:aload_0         
    //   44   75:getfield        #37  <Field double[] e>
    //   45   78:iload           7
    //   46   80:daload          
    //   47   81:invokestatic    #35  <Method double Math.abs(double)>
    //   48   84:dadd            
    //   49   85:invokestatic    #64  <Method double Math.max(double, double)>
    //   50   88:dstore_3        
            int m;
            for(m = l; m < n; m++)
    //*  51   89:iload           7
    //*  52   91:istore          8
    //*  53   93:goto            120
                if(Math.abs(e[m]) <= eps * tst1)
    //*  54   96:aload_0         
    //*  55   97:getfield        #37  <Field double[] e>
    //*  56  100:iload           8
    //*  57  102:daload          
    //*  58  103:invokestatic    #35  <Method double Math.abs(double)>
    //*  59  106:dload           5
    //*  60  108:dload_3         
    //*  61  109:dmul            
    //*  62  110:dcmpg           
    //*  63  111:ifgt            117
                    break;
    //   64  114:goto            129

    //   65  117:iinc            8  1
    //   66  120:iload           8
    //   67  122:aload_0         
    //   68  123:getfield        #29  <Field int n>
    //   69  126:icmplt          96
            if(m > l)
    //*  70  129:iload           8
    //*  71  131:iload           7
    //*  72  133:icmple          642
            {
                int iter = 0;
    //   73  136:iconst_0        
    //   74  137:istore          9
                do
                {
                    iter++;
    //   75  139:iinc            9  1
                    double g = d[l];
    //   76  142:aload_0         
    //   77  143:getfield        #25  <Field double[] d>
    //   78  146:iload           7
    //   79  148:daload          
    //   80  149:dstore          10
                    double p = (d[l + 1] - g) / (2D * e[l]);
    //   81  151:aload_0         
    //   82  152:getfield        #25  <Field double[] d>
    //   83  155:iload           7
    //   84  157:iconst_1        
    //   85  158:iadd            
    //   86  159:daload          
    //   87  160:dload           10
    //   88  162:dsub            
    //   89  163:ldc2w           #54  <Double 2D>
    //   90  166:aload_0         
    //   91  167:getfield        #37  <Field double[] e>
    //   92  170:iload           7
    //   93  172:daload          
    //   94  173:dmul            
    //   95  174:ddiv            
    //   96  175:dstore          12
                    double r = Maths.hypot(p, 1.0D);
    //   97  177:dload           12
    //   98  179:dconst_1        
    //   99  180:invokestatic    #69  <Method double Maths.hypot(double, double)>
    //  100  183:dstore          14
                    if(p < 0.0D)
    //* 101  185:dload           12
    //* 102  187:dconst_0        
    //* 103  188:dcmpg           
    //* 104  189:ifge            197
                        r = -r;
    //  105  192:dload           14
    //  106  194:dneg            
    //  107  195:dstore          14
                    d[l] = e[l] / (p + r);
    //  108  197:aload_0         
    //  109  198:getfield        #25  <Field double[] d>
    //  110  201:iload           7
    //  111  203:aload_0         
    //  112  204:getfield        #37  <Field double[] e>
    //  113  207:iload           7
    //  114  209:daload          
    //  115  210:dload           12
    //  116  212:dload           14
    //  117  214:dadd            
    //  118  215:ddiv            
    //  119  216:dastore         
                    d[l + 1] = e[l] * (p + r);
    //  120  217:aload_0         
    //  121  218:getfield        #25  <Field double[] d>
    //  122  221:iload           7
    //  123  223:iconst_1        
    //  124  224:iadd            
    //  125  225:aload_0         
    //  126  226:getfield        #37  <Field double[] e>
    //  127  229:iload           7
    //  128  231:daload          
    //  129  232:dload           12
    //  130  234:dload           14
    //  131  236:dadd            
    //  132  237:dmul            
    //  133  238:dastore         
                    double dl1 = d[l + 1];
    //  134  239:aload_0         
    //  135  240:getfield        #25  <Field double[] d>
    //  136  243:iload           7
    //  137  245:iconst_1        
    //  138  246:iadd            
    //  139  247:daload          
    //  140  248:dstore          16
                    double h = g - d[l];
    //  141  250:dload           10
    //  142  252:aload_0         
    //  143  253:getfield        #25  <Field double[] d>
    //  144  256:iload           7
    //  145  258:daload          
    //  146  259:dsub            
    //  147  260:dstore          18
                    for(int i = l + 2; i < n; i++)
    //* 148  262:iload           7
    //* 149  264:iconst_2        
    //* 150  265:iadd            
    //* 151  266:istore          20
    //* 152  268:goto            286
                        d[i] -= h;
    //  153  271:aload_0         
    //  154  272:getfield        #25  <Field double[] d>
    //  155  275:iload           20
    //  156  277:dup2            
    //  157  278:daload          
    //  158  279:dload           18
    //  159  281:dsub            
    //  160  282:dastore         

    //  161  283:iinc            20  1
    //  162  286:iload           20
    //  163  288:aload_0         
    //  164  289:getfield        #29  <Field int n>
    //  165  292:icmplt          271
                    f += h;
    //  166  295:dload_1         
    //  167  296:dload           18
    //  168  298:dadd            
    //  169  299:dstore_1        
                    p = d[m];
    //  170  300:aload_0         
    //  171  301:getfield        #25  <Field double[] d>
    //  172  304:iload           8
    //  173  306:daload          
    //  174  307:dstore          12
                    double c = 1.0D;
    //  175  309:dconst_1        
    //  176  310:dstore          20
                    double c2 = c;
    //  177  312:dload           20
    //  178  314:dstore          22
                    double c3 = c;
    //  179  316:dload           20
    //  180  318:dstore          24
                    double el1 = e[l + 1];
    //  181  320:aload_0         
    //  182  321:getfield        #37  <Field double[] e>
    //  183  324:iload           7
    //  184  326:iconst_1        
    //  185  327:iadd            
    //  186  328:daload          
    //  187  329:dstore          26
                    double s = 0.0D;
    //  188  331:dconst_0        
    //  189  332:dstore          28
                    double s2 = 0.0D;
    //  190  334:dconst_0        
    //  191  335:dstore          30
                    for(int i = m - 1; i >= l; i--)
    //* 192  337:iload           8
    //* 193  339:iconst_1        
    //* 194  340:isub            
    //* 195  341:istore          32
    //* 196  343:goto            568
                    {
                        c3 = c2;
    //  197  346:dload           22
    //  198  348:dstore          24
                        c2 = c;
    //  199  350:dload           20
    //  200  352:dstore          22
                        s2 = s;
    //  201  354:dload           28
    //  202  356:dstore          30
                        g = c * e[i];
    //  203  358:dload           20
    //  204  360:aload_0         
    //  205  361:getfield        #37  <Field double[] e>
    //  206  364:iload           32
    //  207  366:daload          
    //  208  367:dmul            
    //  209  368:dstore          10
                        h = c * p;
    //  210  370:dload           20
    //  211  372:dload           12
    //  212  374:dmul            
    //  213  375:dstore          18
                        r = Maths.hypot(p, e[i]);
    //  214  377:dload           12
    //  215  379:aload_0         
    //  216  380:getfield        #37  <Field double[] e>
    //  217  383:iload           32
    //  218  385:daload          
    //  219  386:invokestatic    #69  <Method double Maths.hypot(double, double)>
    //  220  389:dstore          14
                        e[i + 1] = s * r;
    //  221  391:aload_0         
    //  222  392:getfield        #37  <Field double[] e>
    //  223  395:iload           32
    //  224  397:iconst_1        
    //  225  398:iadd            
    //  226  399:dload           28
    //  227  401:dload           14
    //  228  403:dmul            
    //  229  404:dastore         
                        s = e[i] / r;
    //  230  405:aload_0         
    //  231  406:getfield        #37  <Field double[] e>
    //  232  409:iload           32
    //  233  411:daload          
    //  234  412:dload           14
    //  235  414:ddiv            
    //  236  415:dstore          28
                        c = p / r;
    //  237  417:dload           12
    //  238  419:dload           14
    //  239  421:ddiv            
    //  240  422:dstore          20
                        p = c * d[i] - s * g;
    //  241  424:dload           20
    //  242  426:aload_0         
    //  243  427:getfield        #25  <Field double[] d>
    //  244  430:iload           32
    //  245  432:daload          
    //  246  433:dmul            
    //  247  434:dload           28
    //  248  436:dload           10
    //  249  438:dmul            
    //  250  439:dsub            
    //  251  440:dstore          12
                        d[i + 1] = h + s * (c * g + s * d[i]);
    //  252  442:aload_0         
    //  253  443:getfield        #25  <Field double[] d>
    //  254  446:iload           32
    //  255  448:iconst_1        
    //  256  449:iadd            
    //  257  450:dload           18
    //  258  452:dload           28
    //  259  454:dload           20
    //  260  456:dload           10
    //  261  458:dmul            
    //  262  459:dload           28
    //  263  461:aload_0         
    //  264  462:getfield        #25  <Field double[] d>
    //  265  465:iload           32
    //  266  467:daload          
    //  267  468:dmul            
    //  268  469:dadd            
    //  269  470:dmul            
    //  270  471:dadd            
    //  271  472:dastore         
                        for(int k = 0; k < n; k++)
    //* 272  473:iconst_0        
    //* 273  474:istore          33
    //* 274  476:goto            556
                        {
                            h = V[k][i + 1];
    //  275  479:aload_0         
    //  276  480:getfield        #27  <Field double[][] V>
    //  277  483:iload           33
    //  278  485:aaload          
    //  279  486:iload           32
    //  280  488:iconst_1        
    //  281  489:iadd            
    //  282  490:daload          
    //  283  491:dstore          18
                            V[k][i + 1] = s * V[k][i] + c * h;
    //  284  493:aload_0         
    //  285  494:getfield        #27  <Field double[][] V>
    //  286  497:iload           33
    //  287  499:aaload          
    //  288  500:iload           32
    //  289  502:iconst_1        
    //  290  503:iadd            
    //  291  504:dload           28
    //  292  506:aload_0         
    //  293  507:getfield        #27  <Field double[][] V>
    //  294  510:iload           33
    //  295  512:aaload          
    //  296  513:iload           32
    //  297  515:daload          
    //  298  516:dmul            
    //  299  517:dload           20
    //  300  519:dload           18
    //  301  521:dmul            
    //  302  522:dadd            
    //  303  523:dastore         
                            V[k][i] = c * V[k][i] - s * h;
    //  304  524:aload_0         
    //  305  525:getfield        #27  <Field double[][] V>
    //  306  528:iload           33
    //  307  530:aaload          
    //  308  531:iload           32
    //  309  533:dload           20
    //  310  535:aload_0         
    //  311  536:getfield        #27  <Field double[][] V>
    //  312  539:iload           33
    //  313  541:aaload          
    //  314  542:iload           32
    //  315  544:daload          
    //  316  545:dmul            
    //  317  546:dload           28
    //  318  548:dload           18
    //  319  550:dmul            
    //  320  551:dsub            
    //  321  552:dastore         
                        }

    //  322  553:iinc            33  1
    //  323  556:iload           33
    //  324  558:aload_0         
    //  325  559:getfield        #29  <Field int n>
    //  326  562:icmplt          479
                    }

    //  327  565:iinc            32  -1
    //  328  568:iload           32
    //  329  570:iload           7
    //  330  572:icmpge          346
                    p = (-s * s2 * c3 * el1 * e[l]) / dl1;
    //  331  575:dload           28
    //  332  577:dneg            
    //  333  578:dload           30
    //  334  580:dmul            
    //  335  581:dload           24
    //  336  583:dmul            
    //  337  584:dload           26
    //  338  586:dmul            
    //  339  587:aload_0         
    //  340  588:getfield        #37  <Field double[] e>
    //  341  591:iload           7
    //  342  593:daload          
    //  343  594:dmul            
    //  344  595:dload           16
    //  345  597:ddiv            
    //  346  598:dstore          12
                    e[l] = s * p;
    //  347  600:aload_0         
    //  348  601:getfield        #37  <Field double[] e>
    //  349  604:iload           7
    //  350  606:dload           28
    //  351  608:dload           12
    //  352  610:dmul            
    //  353  611:dastore         
                    d[l] = c * p;
    //  354  612:aload_0         
    //  355  613:getfield        #25  <Field double[] d>
    //  356  616:iload           7
    //  357  618:dload           20
    //  358  620:dload           12
    //  359  622:dmul            
    //  360  623:dastore         
                } while(Math.abs(e[l]) > eps * tst1);
    //  361  624:aload_0         
    //  362  625:getfield        #37  <Field double[] e>
    //  363  628:iload           7
    //  364  630:daload          
    //  365  631:invokestatic    #35  <Method double Math.abs(double)>
    //  366  634:dload           5
    //  367  636:dload_3         
    //  368  637:dmul            
    //  369  638:dcmpl           
    //  370  639:ifgt            139
            }
            d[l] = d[l] + f;
    //  371  642:aload_0         
    //  372  643:getfield        #25  <Field double[] d>
    //  373  646:iload           7
    //  374  648:aload_0         
    //  375  649:getfield        #25  <Field double[] d>
    //  376  652:iload           7
    //  377  654:daload          
    //  378  655:dload_1         
    //  379  656:dadd            
    //  380  657:dastore         
            e[l] = 0.0D;
    //  381  658:aload_0         
    //  382  659:getfield        #37  <Field double[] e>
    //  383  662:iload           7
    //  384  664:dconst_0        
    //  385  665:dastore         
        }

    //  386  666:iinc            7  1
    //  387  669:iload           7
    //  388  671:aload_0         
    //  389  672:getfield        #29  <Field int n>
    //  390  675:icmplt          63
        for(int i = 0; i < n - 1; i++)
    //* 391  678:iconst_0        
    //* 392  679:istore          7
    //* 393  681:goto            839
        {
            int k = i;
    //  394  684:iload           7
    //  395  686:istore          8
            double p = d[i];
    //  396  688:aload_0         
    //  397  689:getfield        #25  <Field double[] d>
    //  398  692:iload           7
    //  399  694:daload          
    //  400  695:dstore          9
            for(int j = i + 1; j < n; j++)
    //* 401  697:iload           7
    //* 402  699:iconst_1        
    //* 403  700:iadd            
    //* 404  701:istore          11
    //* 405  703:goto            735
                if(d[j] < p)
    //* 406  706:aload_0         
    //* 407  707:getfield        #25  <Field double[] d>
    //* 408  710:iload           11
    //* 409  712:daload          
    //* 410  713:dload           9
    //* 411  715:dcmpg           
    //* 412  716:ifge            732
                {
                    k = j;
    //  413  719:iload           11
    //  414  721:istore          8
                    p = d[j];
    //  415  723:aload_0         
    //  416  724:getfield        #25  <Field double[] d>
    //  417  727:iload           11
    //  418  729:daload          
    //  419  730:dstore          9
                }

    //  420  732:iinc            11  1
    //  421  735:iload           11
    //  422  737:aload_0         
    //  423  738:getfield        #29  <Field int n>
    //  424  741:icmplt          706
            if(k != i)
    //* 425  744:iload           8
    //* 426  746:iload           7
    //* 427  748:icmpeq          836
            {
                d[k] = d[i];
    //  428  751:aload_0         
    //  429  752:getfield        #25  <Field double[] d>
    //  430  755:iload           8
    //  431  757:aload_0         
    //  432  758:getfield        #25  <Field double[] d>
    //  433  761:iload           7
    //  434  763:daload          
    //  435  764:dastore         
                d[i] = p;
    //  436  765:aload_0         
    //  437  766:getfield        #25  <Field double[] d>
    //  438  769:iload           7
    //  439  771:dload           9
    //  440  773:dastore         
                for(int j = 0; j < n; j++)
    //* 441  774:iconst_0        
    //* 442  775:istore          11
    //* 443  777:goto            827
                {
                    p = V[j][i];
    //  444  780:aload_0         
    //  445  781:getfield        #27  <Field double[][] V>
    //  446  784:iload           11
    //  447  786:aaload          
    //  448  787:iload           7
    //  449  789:daload          
    //  450  790:dstore          9
                    V[j][i] = V[j][k];
    //  451  792:aload_0         
    //  452  793:getfield        #27  <Field double[][] V>
    //  453  796:iload           11
    //  454  798:aaload          
    //  455  799:iload           7
    //  456  801:aload_0         
    //  457  802:getfield        #27  <Field double[][] V>
    //  458  805:iload           11
    //  459  807:aaload          
    //  460  808:iload           8
    //  461  810:daload          
    //  462  811:dastore         
                    V[j][k] = p;
    //  463  812:aload_0         
    //  464  813:getfield        #27  <Field double[][] V>
    //  465  816:iload           11
    //  466  818:aaload          
    //  467  819:iload           8
    //  468  821:dload           9
    //  469  823:dastore         
                }

    //  470  824:iinc            11  1
    //  471  827:iload           11
    //  472  829:aload_0         
    //  473  830:getfield        #29  <Field int n>
    //  474  833:icmplt          780
            }
        }

    //  475  836:iinc            7  1
    //  476  839:iload           7
    //  477  841:aload_0         
    //  478  842:getfield        #29  <Field int n>
    //  479  845:iconst_1        
    //  480  846:isub            
    //  481  847:icmplt          684
    //  482  850:return          
    }

    private void orthes()
    {
        int low = 0;
    //    0    0:iconst_0        
    //    1    1:istore_1        
        int high = n - 1;
    //    2    2:aload_0         
    //    3    3:getfield        #29  <Field int n>
    //    4    6:iconst_1        
    //    5    7:isub            
    //    6    8:istore_2        
        for(int m = low + 1; m <= high - 1; m++)
    //*   7    9:iload_1         
    //*   8   10:iconst_1        
    //*   9   11:iadd            
    //*  10   12:istore_3        
    //*  11   13:goto            409
        {
            double scale = 0.0D;
    //   12   16:dconst_0        
    //   13   17:dstore          4
            for(int i = m; i <= high; i++)
    //*  14   19:iload_3         
    //*  15   20:istore          6
    //*  16   22:goto            47
                scale += Math.abs(H[i][m - 1]);
    //   17   25:dload           4
    //   18   27:aload_0         
    //   19   28:getfield        #86  <Field double[][] H>
    //   20   31:iload           6
    //   21   33:aaload          
    //   22   34:iload_3         
    //   23   35:iconst_1        
    //   24   36:isub            
    //   25   37:daload          
    //   26   38:invokestatic    #35  <Method double Math.abs(double)>
    //   27   41:dadd            
    //   28   42:dstore          4

    //   29   44:iinc            6  1
    //   30   47:iload           6
    //   31   49:iload_2         
    //   32   50:icmple          25
            if(scale != 0.0D)
    //*  33   53:dload           4
    //*  34   55:dconst_0        
    //*  35   56:dcmpl           
    //*  36   57:ifeq            406
            {
                double h = 0.0D;
    //   37   60:dconst_0        
    //   38   61:dstore          6
                for(int i = high; i >= m; i--)
    //*  39   63:iload_2         
    //*  40   64:istore          8
    //*  41   66:goto            113
                {
                    ort[i] = H[i][m - 1] / scale;
    //   42   69:aload_0         
    //   43   70:getfield        #88  <Field double[] ort>
    //   44   73:iload           8
    //   45   75:aload_0         
    //   46   76:getfield        #86  <Field double[][] H>
    //   47   79:iload           8
    //   48   81:aaload          
    //   49   82:iload_3         
    //   50   83:iconst_1        
    //   51   84:isub            
    //   52   85:daload          
    //   53   86:dload           4
    //   54   88:ddiv            
    //   55   89:dastore         
                    h += ort[i] * ort[i];
    //   56   90:dload           6
    //   57   92:aload_0         
    //   58   93:getfield        #88  <Field double[] ort>
    //   59   96:iload           8
    //   60   98:daload          
    //   61   99:aload_0         
    //   62  100:getfield        #88  <Field double[] ort>
    //   63  103:iload           8
    //   64  105:daload          
    //   65  106:dmul            
    //   66  107:dadd            
    //   67  108:dstore          6
                }

    //   68  110:iinc            8  -1
    //   69  113:iload           8
    //   70  115:iload_3         
    //   71  116:icmpge          69
                double g = Math.sqrt(h);
    //   72  119:dload           6
    //   73  121:invokestatic    #40  <Method double Math.sqrt(double)>
    //   74  124:dstore          8
                if(ort[m] > 0.0D)
    //*  75  126:aload_0         
    //*  76  127:getfield        #88  <Field double[] ort>
    //*  77  130:iload_3         
    //*  78  131:daload          
    //*  79  132:dconst_0        
    //*  80  133:dcmpl           
    //*  81  134:ifle            142
                    g = -g;
    //   82  137:dload           8
    //   83  139:dneg            
    //   84  140:dstore          8
                h -= ort[m] * g;
    //   85  142:dload           6
    //   86  144:aload_0         
    //   87  145:getfield        #88  <Field double[] ort>
    //   88  148:iload_3         
    //   89  149:daload          
    //   90  150:dload           8
    //   91  152:dmul            
    //   92  153:dsub            
    //   93  154:dstore          6
                ort[m] = ort[m] - g;
    //   94  156:aload_0         
    //   95  157:getfield        #88  <Field double[] ort>
    //   96  160:iload_3         
    //   97  161:aload_0         
    //   98  162:getfield        #88  <Field double[] ort>
    //   99  165:iload_3         
    //  100  166:daload          
    //  101  167:dload           8
    //  102  169:dsub            
    //  103  170:dastore         
                for(int j = m; j < n; j++)
    //* 104  171:iload_3         
    //* 105  172:istore          10
    //* 106  174:goto            266
                {
                    double f = 0.0D;
    //  107  177:dconst_0        
    //  108  178:dstore          11
                    for(int i = high; i >= m; i--)
    //* 109  180:iload_2         
    //* 110  181:istore          13
    //* 111  183:goto            212
                        f += ort[i] * H[i][j];
    //  112  186:dload           11
    //  113  188:aload_0         
    //  114  189:getfield        #88  <Field double[] ort>
    //  115  192:iload           13
    //  116  194:daload          
    //  117  195:aload_0         
    //  118  196:getfield        #86  <Field double[][] H>
    //  119  199:iload           13
    //  120  201:aaload          
    //  121  202:iload           10
    //  122  204:daload          
    //  123  205:dmul            
    //  124  206:dadd            
    //  125  207:dstore          11

    //  126  209:iinc            13  -1
    //  127  212:iload           13
    //  128  214:iload_3         
    //  129  215:icmpge          186
                    f /= h;
    //  130  218:dload           11
    //  131  220:dload           6
    //  132  222:ddiv            
    //  133  223:dstore          11
                    for(int i = m; i <= high; i++)
    //* 134  225:iload_3         
    //* 135  226:istore          13
    //* 136  228:goto            257
                        H[i][j] -= f * ort[i];
    //  137  231:aload_0         
    //  138  232:getfield        #86  <Field double[][] H>
    //  139  235:iload           13
    //  140  237:aaload          
    //  141  238:iload           10
    //  142  240:dup2            
    //  143  241:daload          
    //  144  242:dload           11
    //  145  244:aload_0         
    //  146  245:getfield        #88  <Field double[] ort>
    //  147  248:iload           13
    //  148  250:daload          
    //  149  251:dmul            
    //  150  252:dsub            
    //  151  253:dastore         

    //  152  254:iinc            13  1
    //  153  257:iload           13
    //  154  259:iload_2         
    //  155  260:icmple          231
                }

    //  156  263:iinc            10  1
    //  157  266:iload           10
    //  158  268:aload_0         
    //  159  269:getfield        #29  <Field int n>
    //  160  272:icmplt          177
                for(int i = 0; i <= high; i++)
    //* 161  275:iconst_0        
    //* 162  276:istore          10
    //* 163  278:goto            370
                {
                    double f = 0.0D;
    //  164  281:dconst_0        
    //  165  282:dstore          11
                    for(int j = high; j >= m; j--)
    //* 166  284:iload_2         
    //* 167  285:istore          13
    //* 168  287:goto            316
                        f += ort[j] * H[i][j];
    //  169  290:dload           11
    //  170  292:aload_0         
    //  171  293:getfield        #88  <Field double[] ort>
    //  172  296:iload           13
    //  173  298:daload          
    //  174  299:aload_0         
    //  175  300:getfield        #86  <Field double[][] H>
    //  176  303:iload           10
    //  177  305:aaload          
    //  178  306:iload           13
    //  179  308:daload          
    //  180  309:dmul            
    //  181  310:dadd            
    //  182  311:dstore          11

    //  183  313:iinc            13  -1
    //  184  316:iload           13
    //  185  318:iload_3         
    //  186  319:icmpge          290
                    f /= h;
    //  187  322:dload           11
    //  188  324:dload           6
    //  189  326:ddiv            
    //  190  327:dstore          11
                    for(int j = m; j <= high; j++)
    //* 191  329:iload_3         
    //* 192  330:istore          13
    //* 193  332:goto            361
                        H[i][j] -= f * ort[j];
    //  194  335:aload_0         
    //  195  336:getfield        #86  <Field double[][] H>
    //  196  339:iload           10
    //  197  341:aaload          
    //  198  342:iload           13
    //  199  344:dup2            
    //  200  345:daload          
    //  201  346:dload           11
    //  202  348:aload_0         
    //  203  349:getfield        #88  <Field double[] ort>
    //  204  352:iload           13
    //  205  354:daload          
    //  206  355:dmul            
    //  207  356:dsub            
    //  208  357:dastore         

    //  209  358:iinc            13  1
    //  210  361:iload           13
    //  211  363:iload_2         
    //  212  364:icmple          335
                }

    //  213  367:iinc            10  1
    //  214  370:iload           10
    //  215  372:iload_2         
    //  216  373:icmple          281
                ort[m] = scale * ort[m];
    //  217  376:aload_0         
    //  218  377:getfield        #88  <Field double[] ort>
    //  219  380:iload_3         
    //  220  381:dload           4
    //  221  383:aload_0         
    //  222  384:getfield        #88  <Field double[] ort>
    //  223  387:iload_3         
    //  224  388:daload          
    //  225  389:dmul            
    //  226  390:dastore         
                H[m][m - 1] = scale * g;
    //  227  391:aload_0         
    //  228  392:getfield        #86  <Field double[][] H>
    //  229  395:iload_3         
    //  230  396:aaload          
    //  231  397:iload_3         
    //  232  398:iconst_1        
    //  233  399:isub            
    //  234  400:dload           4
    //  235  402:dload           8
    //  236  404:dmul            
    //  237  405:dastore         
            }
        }

    //  238  406:iinc            3  1
    //  239  409:iload_3         
    //  240  410:iload_2         
    //  241  411:iconst_1        
    //  242  412:isub            
    //  243  413:icmple          16
        for(int i = 0; i < n; i++)
    //* 244  416:iconst_0        
    //* 245  417:istore_3        
    //* 246  418:goto            462
        {
            for(int j = 0; j < n; j++)
    //* 247  421:iconst_0        
    //* 248  422:istore          4
    //* 249  424:goto            450
                V[i][j] = i != j ? 0.0D : 1.0D;
    //  250  427:aload_0         
    //  251  428:getfield        #27  <Field double[][] V>
    //  252  431:iload_3         
    //  253  432:aaload          
    //  254  433:iload           4
    //  255  435:iload_3         
    //  256  436:iload           4
    //  257  438:icmpne          445
    //  258  441:dconst_1        
    //  259  442:goto            446
    //  260  445:dconst_0        
    //  261  446:dastore         

    //  262  447:iinc            4  1
    //  263  450:iload           4
    //  264  452:aload_0         
    //  265  453:getfield        #29  <Field int n>
    //  266  456:icmplt          427
        }

    //  267  459:iinc            3  1
    //  268  462:iload_3         
    //  269  463:aload_0         
    //  270  464:getfield        #29  <Field int n>
    //  271  467:icmplt          421
        for(int m = high - 1; m >= low + 1; m--)
    //* 272  470:iload_2         
    //* 273  471:iconst_1        
    //* 274  472:isub            
    //* 275  473:istore_3        
    //* 276  474:goto            646
            if(H[m][m - 1] != 0.0D)
    //* 277  477:aload_0         
    //* 278  478:getfield        #86  <Field double[][] H>
    //* 279  481:iload_3         
    //* 280  482:aaload          
    //* 281  483:iload_3         
    //* 282  484:iconst_1        
    //* 283  485:isub            
    //* 284  486:daload          
    //* 285  487:dconst_0        
    //* 286  488:dcmpl           
    //* 287  489:ifeq            643
            {
                for(int i = m + 1; i <= high; i++)
    //* 288  492:iload_3         
    //* 289  493:iconst_1        
    //* 290  494:iadd            
    //* 291  495:istore          4
    //* 292  497:goto            521
                    ort[i] = H[i][m - 1];
    //  293  500:aload_0         
    //  294  501:getfield        #88  <Field double[] ort>
    //  295  504:iload           4
    //  296  506:aload_0         
    //  297  507:getfield        #86  <Field double[][] H>
    //  298  510:iload           4
    //  299  512:aaload          
    //  300  513:iload_3         
    //  301  514:iconst_1        
    //  302  515:isub            
    //  303  516:daload          
    //  304  517:dastore         

    //  305  518:iinc            4  1
    //  306  521:iload           4
    //  307  523:iload_2         
    //  308  524:icmple          500
                for(int j = m; j <= high; j++)
    //* 309  527:iload_3         
    //* 310  528:istore          4
    //* 311  530:goto            637
                {
                    double g = 0.0D;
    //  312  533:dconst_0        
    //  313  534:dstore          5
                    for(int i = m; i <= high; i++)
    //* 314  536:iload_3         
    //* 315  537:istore          7
    //* 316  539:goto            568
                        g += ort[i] * V[i][j];
    //  317  542:dload           5
    //  318  544:aload_0         
    //  319  545:getfield        #88  <Field double[] ort>
    //  320  548:iload           7
    //  321  550:daload          
    //  322  551:aload_0         
    //  323  552:getfield        #27  <Field double[][] V>
    //  324  555:iload           7
    //  325  557:aaload          
    //  326  558:iload           4
    //  327  560:daload          
    //  328  561:dmul            
    //  329  562:dadd            
    //  330  563:dstore          5

    //  331  565:iinc            7  1
    //  332  568:iload           7
    //  333  570:iload_2         
    //  334  571:icmple          542
                    g = g / ort[m] / H[m][m - 1];
    //  335  574:dload           5
    //  336  576:aload_0         
    //  337  577:getfield        #88  <Field double[] ort>
    //  338  580:iload_3         
    //  339  581:daload          
    //  340  582:ddiv            
    //  341  583:aload_0         
    //  342  584:getfield        #86  <Field double[][] H>
    //  343  587:iload_3         
    //  344  588:aaload          
    //  345  589:iload_3         
    //  346  590:iconst_1        
    //  347  591:isub            
    //  348  592:daload          
    //  349  593:ddiv            
    //  350  594:dstore          5
                    for(int i = m; i <= high; i++)
    //* 351  596:iload_3         
    //* 352  597:istore          7
    //* 353  599:goto            628
                        V[i][j] += g * ort[i];
    //  354  602:aload_0         
    //  355  603:getfield        #27  <Field double[][] V>
    //  356  606:iload           7
    //  357  608:aaload          
    //  358  609:iload           4
    //  359  611:dup2            
    //  360  612:daload          
    //  361  613:dload           5
    //  362  615:aload_0         
    //  363  616:getfield        #88  <Field double[] ort>
    //  364  619:iload           7
    //  365  621:daload          
    //  366  622:dmul            
    //  367  623:dadd            
    //  368  624:dastore         

    //  369  625:iinc            7  1
    //  370  628:iload           7
    //  371  630:iload_2         
    //  372  631:icmple          602
                }

    //  373  634:iinc            4  1
    //  374  637:iload           4
    //  375  639:iload_2         
    //  376  640:icmple          533
            }

    //  377  643:iinc            3  -1
    //  378  646:iload_3         
    //  379  647:iload_1         
    //  380  648:iconst_1        
    //  381  649:iadd            
    //  382  650:icmpge          477
    //  383  653:return          
    }

    private void cdiv(double xr, double xi, double yr, double yi)
    {
        if(Math.abs(yr) > Math.abs(yi))
    //*   0    0:dload           5
    //*   1    2:invokestatic    #35  <Method double Math.abs(double)>
    //*   2    5:dload           7
    //*   3    7:invokestatic    #35  <Method double Math.abs(double)>
    //*   4   10:dcmpl           
    //*   5   11:ifle            60
        {
            double r = yi / yr;
    //    6   14:dload           7
    //    7   16:dload           5
    //    8   18:ddiv            
    //    9   19:dstore          9
            double d = yr + r * yi;
    //   10   21:dload           5
    //   11   23:dload           9
    //   12   25:dload           7
    //   13   27:dmul            
    //   14   28:dadd            
    //   15   29:dstore          11
            cdivr = (xr + r * xi) / d;
    //   16   31:aload_0         
    //   17   32:dload_1         
    //   18   33:dload           9
    //   19   35:dload_3         
    //   20   36:dmul            
    //   21   37:dadd            
    //   22   38:dload           11
    //   23   40:ddiv            
    //   24   41:putfield        #94  <Field double cdivr>
            cdivi = (xi - r * xr) / d;
    //   25   44:aload_0         
    //   26   45:dload_3         
    //   27   46:dload           9
    //   28   48:dload_1         
    //   29   49:dmul            
    //   30   50:dsub            
    //   31   51:dload           11
    //   32   53:ddiv            
    //   33   54:putfield        #96  <Field double cdivi>
        } else
    //*  34   57:goto            103
        {
            double r = yr / yi;
    //   35   60:dload           5
    //   36   62:dload           7
    //   37   64:ddiv            
    //   38   65:dstore          9
            double d = yi + r * yr;
    //   39   67:dload           7
    //   40   69:dload           9
    //   41   71:dload           5
    //   42   73:dmul            
    //   43   74:dadd            
    //   44   75:dstore          11
            cdivr = (r * xr + xi) / d;
    //   45   77:aload_0         
    //   46   78:dload           9
    //   47   80:dload_1         
    //   48   81:dmul            
    //   49   82:dload_3         
    //   50   83:dadd            
    //   51   84:dload           11
    //   52   86:ddiv            
    //   53   87:putfield        #94  <Field double cdivr>
            cdivi = (r * xi - xr) / d;
    //   54   90:aload_0         
    //   55   91:dload           9
    //   56   93:dload_3         
    //   57   94:dmul            
    //   58   95:dload_1         
    //   59   96:dsub            
    //   60   97:dload           11
    //   61   99:ddiv            
    //   62  100:putfield        #96  <Field double cdivi>
        }
    //   63  103:return          
    }

    private void hqr2()
    {
        int nn = this.n;
    //    0    0:aload_0         
    //    1    1:getfield        #29  <Field int n>
    //    2    4:istore_1        
        int n = nn - 1;
    //    3    5:iload_1         
    //    4    6:iconst_1        
    //    5    7:isub            
    //    6    8:istore_2        
        int low = 0;
    //    7    9:iconst_0        
    //    8   10:istore_3        
        int high = nn - 1;
    //    9   11:iload_1         
    //   10   12:iconst_1        
    //   11   13:isub            
    //   12   14:istore          4
        double eps = Math.pow(2D, -52D);
    //   13   16:ldc2w           #54  <Double 2D>
    //   14   19:ldc2w           #56  <Double -52D>
    //   15   22:invokestatic    #61  <Method double Math.pow(double, double)>
    //   16   25:dstore          5
        double exshift = 0.0D;
    //   17   27:dconst_0        
    //   18   28:dstore          7
        double p = 0.0D;
    //   19   30:dconst_0        
    //   20   31:dstore          9
        double q = 0.0D;
    //   21   33:dconst_0        
    //   22   34:dstore          11
        double r = 0.0D;
    //   23   36:dconst_0        
    //   24   37:dstore          13
        double s = 0.0D;
    //   25   39:dconst_0        
    //   26   40:dstore          15
        double z = 0.0D;
    //   27   42:dconst_0        
    //   28   43:dstore          17
        double norm = 0.0D;
    //   29   45:dconst_0        
    //   30   46:dstore          27
        for(int i = 0; i < nn; i++)
    //*  31   48:iconst_0        
    //*  32   49:istore          29
    //*  33   51:goto            149
        {
            if((i < low) | (i > high))
    //*  34   54:iload           29
    //*  35   56:iload_3         
    //*  36   57:icmpge          64
    //*  37   60:iconst_1        
    //*  38   61:goto            65
    //*  39   64:iconst_0        
    //*  40   65:iload           29
    //*  41   67:iload           4
    //*  42   69:icmple          76
    //*  43   72:iconst_1        
    //*  44   73:goto            77
    //*  45   76:iconst_0        
    //*  46   77:ior             
    //*  47   78:ifeq            106
            {
                d[i] = H[i][i];
    //   48   81:aload_0         
    //   49   82:getfield        #25  <Field double[] d>
    //   50   85:iload           29
    //   51   87:aload_0         
    //   52   88:getfield        #86  <Field double[][] H>
    //   53   91:iload           29
    //   54   93:aaload          
    //   55   94:iload           29
    //   56   96:daload          
    //   57   97:dastore         
                e[i] = 0.0D;
    //   58   98:aload_0         
    //   59   99:getfield        #37  <Field double[] e>
    //   60  102:iload           29
    //   61  104:dconst_0        
    //   62  105:dastore         
            }
            for(int j = Math.max(i - 1, 0); j < nn; j++)
    //*  63  106:iload           29
    //*  64  108:iconst_1        
    //*  65  109:isub            
    //*  66  110:iconst_0        
    //*  67  111:invokestatic    #104 <Method int Math.max(int, int)>
    //*  68  114:istore          30
    //*  69  116:goto            140
                norm += Math.abs(H[i][j]);
    //   70  119:dload           27
    //   71  121:aload_0         
    //   72  122:getfield        #86  <Field double[][] H>
    //   73  125:iload           29
    //   74  127:aaload          
    //   75  128:iload           30
    //   76  130:daload          
    //   77  131:invokestatic    #35  <Method double Math.abs(double)>
    //   78  134:dadd            
    //   79  135:dstore          27

    //   80  137:iinc            30  1
    //   81  140:iload           30
    //   82  142:iload_1         
    //   83  143:icmplt          119
        }

    //   84  146:iinc            29  1
    //   85  149:iload           29
    //   86  151:iload_1         
    //   87  152:icmplt          54
        int iter = 0;
    //   88  155:iconst_0        
    //   89  156:istore          29
    //*  90  158:goto            2266
        while(n >= low) 
        {
            int l;
            for(l = n; l > low; l--)
    //*  91  161:iload_2         
    //*  92  162:istore          30
    //*  93  164:goto            241
            {
                s = Math.abs(H[l - 1][l - 1]) + Math.abs(H[l][l]);
    //   94  167:aload_0         
    //   95  168:getfield        #86  <Field double[][] H>
    //   96  171:iload           30
    //   97  173:iconst_1        
    //   98  174:isub            
    //   99  175:aaload          
    //  100  176:iload           30
    //  101  178:iconst_1        
    //  102  179:isub            
    //  103  180:daload          
    //  104  181:invokestatic    #35  <Method double Math.abs(double)>
    //  105  184:aload_0         
    //  106  185:getfield        #86  <Field double[][] H>
    //  107  188:iload           30
    //  108  190:aaload          
    //  109  191:iload           30
    //  110  193:daload          
    //  111  194:invokestatic    #35  <Method double Math.abs(double)>
    //  112  197:dadd            
    //  113  198:dstore          15
                if(s == 0.0D)
    //* 114  200:dload           15
    //* 115  202:dconst_0        
    //* 116  203:dcmpl           
    //* 117  204:ifne            211
                    s = norm;
    //  118  207:dload           27
    //  119  209:dstore          15
                if(Math.abs(H[l][l - 1]) < eps * s)
    //* 120  211:aload_0         
    //* 121  212:getfield        #86  <Field double[][] H>
    //* 122  215:iload           30
    //* 123  217:aaload          
    //* 124  218:iload           30
    //* 125  220:iconst_1        
    //* 126  221:isub            
    //* 127  222:daload          
    //* 128  223:invokestatic    #35  <Method double Math.abs(double)>
    //* 129  226:dload           5
    //* 130  228:dload           15
    //* 131  230:dmul            
    //* 132  231:dcmpg           
    //* 133  232:ifge            238
                    break;
    //  134  235:goto            247
            }

    //  135  238:iinc            30  -1
    //  136  241:iload           30
    //  137  243:iload_3         
    //  138  244:icmpgt          167
            if(l == n)
    //* 139  247:iload           30
    //* 140  249:iload_2         
    //* 141  250:icmpne          302
            {
                H[n][n] = H[n][n] + exshift;
    //  142  253:aload_0         
    //  143  254:getfield        #86  <Field double[][] H>
    //  144  257:iload_2         
    //  145  258:aaload          
    //  146  259:iload_2         
    //  147  260:aload_0         
    //  148  261:getfield        #86  <Field double[][] H>
    //  149  264:iload_2         
    //  150  265:aaload          
    //  151  266:iload_2         
    //  152  267:daload          
    //  153  268:dload           7
    //  154  270:dadd            
    //  155  271:dastore         
                d[n] = H[n][n];
    //  156  272:aload_0         
    //  157  273:getfield        #25  <Field double[] d>
    //  158  276:iload_2         
    //  159  277:aload_0         
    //  160  278:getfield        #86  <Field double[][] H>
    //  161  281:iload_2         
    //  162  282:aaload          
    //  163  283:iload_2         
    //  164  284:daload          
    //  165  285:dastore         
                e[n] = 0.0D;
    //  166  286:aload_0         
    //  167  287:getfield        #37  <Field double[] e>
    //  168  290:iload_2         
    //  169  291:dconst_0        
    //  170  292:dastore         
                n--;
    //  171  293:iinc            2  -1
                iter = 0;
    //  172  296:iconst_0        
    //  173  297:istore          29
            } else
    //* 174  299:goto            2266
            if(l == n - 1)
    //* 175  302:iload           30
    //* 176  304:iload_2         
    //* 177  305:iconst_1        
    //* 178  306:isub            
    //* 179  307:icmpne          910
            {
                double w = H[n][n - 1] * H[n - 1][n];
    //  180  310:aload_0         
    //  181  311:getfield        #86  <Field double[][] H>
    //  182  314:iload_2         
    //  183  315:aaload          
    //  184  316:iload_2         
    //  185  317:iconst_1        
    //  186  318:isub            
    //  187  319:daload          
    //  188  320:aload_0         
    //  189  321:getfield        #86  <Field double[][] H>
    //  190  324:iload_2         
    //  191  325:iconst_1        
    //  192  326:isub            
    //  193  327:aaload          
    //  194  328:iload_2         
    //  195  329:daload          
    //  196  330:dmul            
    //  197  331:dstore          21
                p = (H[n - 1][n - 1] - H[n][n]) / 2D;
    //  198  333:aload_0         
    //  199  334:getfield        #86  <Field double[][] H>
    //  200  337:iload_2         
    //  201  338:iconst_1        
    //  202  339:isub            
    //  203  340:aaload          
    //  204  341:iload_2         
    //  205  342:iconst_1        
    //  206  343:isub            
    //  207  344:daload          
    //  208  345:aload_0         
    //  209  346:getfield        #86  <Field double[][] H>
    //  210  349:iload_2         
    //  211  350:aaload          
    //  212  351:iload_2         
    //  213  352:daload          
    //  214  353:dsub            
    //  215  354:ldc2w           #54  <Double 2D>
    //  216  357:ddiv            
    //  217  358:dstore          9
                q = p * p + w;
    //  218  360:dload           9
    //  219  362:dload           9
    //  220  364:dmul            
    //  221  365:dload           21
    //  222  367:dadd            
    //  223  368:dstore          11
                z = Math.sqrt(Math.abs(q));
    //  224  370:dload           11
    //  225  372:invokestatic    #35  <Method double Math.abs(double)>
    //  226  375:invokestatic    #40  <Method double Math.sqrt(double)>
    //  227  378:dstore          17
                H[n][n] = H[n][n] + exshift;
    //  228  380:aload_0         
    //  229  381:getfield        #86  <Field double[][] H>
    //  230  384:iload_2         
    //  231  385:aaload          
    //  232  386:iload_2         
    //  233  387:aload_0         
    //  234  388:getfield        #86  <Field double[][] H>
    //  235  391:iload_2         
    //  236  392:aaload          
    //  237  393:iload_2         
    //  238  394:daload          
    //  239  395:dload           7
    //  240  397:dadd            
    //  241  398:dastore         
                H[n - 1][n - 1] = H[n - 1][n - 1] + exshift;
    //  242  399:aload_0         
    //  243  400:getfield        #86  <Field double[][] H>
    //  244  403:iload_2         
    //  245  404:iconst_1        
    //  246  405:isub            
    //  247  406:aaload          
    //  248  407:iload_2         
    //  249  408:iconst_1        
    //  250  409:isub            
    //  251  410:aload_0         
    //  252  411:getfield        #86  <Field double[][] H>
    //  253  414:iload_2         
    //  254  415:iconst_1        
    //  255  416:isub            
    //  256  417:aaload          
    //  257  418:iload_2         
    //  258  419:iconst_1        
    //  259  420:isub            
    //  260  421:daload          
    //  261  422:dload           7
    //  262  424:dadd            
    //  263  425:dastore         
                double x = H[n][n];
    //  264  426:aload_0         
    //  265  427:getfield        #86  <Field double[][] H>
    //  266  430:iload_2         
    //  267  431:aaload          
    //  268  432:iload_2         
    //  269  433:daload          
    //  270  434:dstore          23
                if(q >= 0.0D)
    //* 271  436:dload           11
    //* 272  438:dconst_0        
    //* 273  439:dcmpl           
    //* 274  440:iflt            858
                {
                    if(p >= 0.0D)
    //* 275  443:dload           9
    //* 276  445:dconst_0        
    //* 277  446:dcmpl           
    //* 278  447:iflt            460
                        z = p + z;
    //  279  450:dload           9
    //  280  452:dload           17
    //  281  454:dadd            
    //  282  455:dstore          17
                    else
    //* 283  457:goto            467
                        z = p - z;
    //  284  460:dload           9
    //  285  462:dload           17
    //  286  464:dsub            
    //  287  465:dstore          17
                    d[n - 1] = x + z;
    //  288  467:aload_0         
    //  289  468:getfield        #25  <Field double[] d>
    //  290  471:iload_2         
    //  291  472:iconst_1        
    //  292  473:isub            
    //  293  474:dload           23
    //  294  476:dload           17
    //  295  478:dadd            
    //  296  479:dastore         
                    d[n] = d[n - 1];
    //  297  480:aload_0         
    //  298  481:getfield        #25  <Field double[] d>
    //  299  484:iload_2         
    //  300  485:aload_0         
    //  301  486:getfield        #25  <Field double[] d>
    //  302  489:iload_2         
    //  303  490:iconst_1        
    //  304  491:isub            
    //  305  492:daload          
    //  306  493:dastore         
                    if(z != 0.0D)
    //* 307  494:dload           17
    //* 308  496:dconst_0        
    //* 309  497:dcmpl           
    //* 310  498:ifeq            515
                        d[n] = x - w / z;
    //  311  501:aload_0         
    //  312  502:getfield        #25  <Field double[] d>
    //  313  505:iload_2         
    //  314  506:dload           23
    //  315  508:dload           21
    //  316  510:dload           17
    //  317  512:ddiv            
    //  318  513:dsub            
    //  319  514:dastore         
                    e[n - 1] = 0.0D;
    //  320  515:aload_0         
    //  321  516:getfield        #37  <Field double[] e>
    //  322  519:iload_2         
    //  323  520:iconst_1        
    //  324  521:isub            
    //  325  522:dconst_0        
    //  326  523:dastore         
                    e[n] = 0.0D;
    //  327  524:aload_0         
    //  328  525:getfield        #37  <Field double[] e>
    //  329  528:iload_2         
    //  330  529:dconst_0        
    //  331  530:dastore         
                    x = H[n][n - 1];
    //  332  531:aload_0         
    //  333  532:getfield        #86  <Field double[][] H>
    //  334  535:iload_2         
    //  335  536:aaload          
    //  336  537:iload_2         
    //  337  538:iconst_1        
    //  338  539:isub            
    //  339  540:daload          
    //  340  541:dstore          23
                    s = Math.abs(x) + Math.abs(z);
    //  341  543:dload           23
    //  342  545:invokestatic    #35  <Method double Math.abs(double)>
    //  343  548:dload           17
    //  344  550:invokestatic    #35  <Method double Math.abs(double)>
    //  345  553:dadd            
    //  346  554:dstore          15
                    p = x / s;
    //  347  556:dload           23
    //  348  558:dload           15
    //  349  560:ddiv            
    //  350  561:dstore          9
                    q = z / s;
    //  351  563:dload           17
    //  352  565:dload           15
    //  353  567:ddiv            
    //  354  568:dstore          11
                    r = Math.sqrt(p * p + q * q);
    //  355  570:dload           9
    //  356  572:dload           9
    //  357  574:dmul            
    //  358  575:dload           11
    //  359  577:dload           11
    //  360  579:dmul            
    //  361  580:dadd            
    //  362  581:invokestatic    #40  <Method double Math.sqrt(double)>
    //  363  584:dstore          13
                    p /= r;
    //  364  586:dload           9
    //  365  588:dload           13
    //  366  590:ddiv            
    //  367  591:dstore          9
                    q /= r;
    //  368  593:dload           11
    //  369  595:dload           13
    //  370  597:ddiv            
    //  371  598:dstore          11
                    for(int j = n - 1; j < nn; j++)
    //* 372  600:iload_2         
    //* 373  601:iconst_1        
    //* 374  602:isub            
    //* 375  603:istore          31
    //* 376  605:goto            680
                    {
                        z = H[n - 1][j];
    //  377  608:aload_0         
    //  378  609:getfield        #86  <Field double[][] H>
    //  379  612:iload_2         
    //  380  613:iconst_1        
    //  381  614:isub            
    //  382  615:aaload          
    //  383  616:iload           31
    //  384  618:daload          
    //  385  619:dstore          17
                        H[n - 1][j] = q * z + p * H[n][j];
    //  386  621:aload_0         
    //  387  622:getfield        #86  <Field double[][] H>
    //  388  625:iload_2         
    //  389  626:iconst_1        
    //  390  627:isub            
    //  391  628:aaload          
    //  392  629:iload           31
    //  393  631:dload           11
    //  394  633:dload           17
    //  395  635:dmul            
    //  396  636:dload           9
    //  397  638:aload_0         
    //  398  639:getfield        #86  <Field double[][] H>
    //  399  642:iload_2         
    //  400  643:aaload          
    //  401  644:iload           31
    //  402  646:daload          
    //  403  647:dmul            
    //  404  648:dadd            
    //  405  649:dastore         
                        H[n][j] = q * H[n][j] - p * z;
    //  406  650:aload_0         
    //  407  651:getfield        #86  <Field double[][] H>
    //  408  654:iload_2         
    //  409  655:aaload          
    //  410  656:iload           31
    //  411  658:dload           11
    //  412  660:aload_0         
    //  413  661:getfield        #86  <Field double[][] H>
    //  414  664:iload_2         
    //  415  665:aaload          
    //  416  666:iload           31
    //  417  668:daload          
    //  418  669:dmul            
    //  419  670:dload           9
    //  420  672:dload           17
    //  421  674:dmul            
    //  422  675:dsub            
    //  423  676:dastore         
                    }

    //  424  677:iinc            31  1
    //  425  680:iload           31
    //  426  682:iload_1         
    //  427  683:icmplt          608
                    for(int i = 0; i <= n; i++)
    //* 428  686:iconst_0        
    //* 429  687:istore          31
    //* 430  689:goto            764
                    {
                        z = H[i][n - 1];
    //  431  692:aload_0         
    //  432  693:getfield        #86  <Field double[][] H>
    //  433  696:iload           31
    //  434  698:aaload          
    //  435  699:iload_2         
    //  436  700:iconst_1        
    //  437  701:isub            
    //  438  702:daload          
    //  439  703:dstore          17
                        H[i][n - 1] = q * z + p * H[i][n];
    //  440  705:aload_0         
    //  441  706:getfield        #86  <Field double[][] H>
    //  442  709:iload           31
    //  443  711:aaload          
    //  444  712:iload_2         
    //  445  713:iconst_1        
    //  446  714:isub            
    //  447  715:dload           11
    //  448  717:dload           17
    //  449  719:dmul            
    //  450  720:dload           9
    //  451  722:aload_0         
    //  452  723:getfield        #86  <Field double[][] H>
    //  453  726:iload           31
    //  454  728:aaload          
    //  455  729:iload_2         
    //  456  730:daload          
    //  457  731:dmul            
    //  458  732:dadd            
    //  459  733:dastore         
                        H[i][n] = q * H[i][n] - p * z;
    //  460  734:aload_0         
    //  461  735:getfield        #86  <Field double[][] H>
    //  462  738:iload           31
    //  463  740:aaload          
    //  464  741:iload_2         
    //  465  742:dload           11
    //  466  744:aload_0         
    //  467  745:getfield        #86  <Field double[][] H>
    //  468  748:iload           31
    //  469  750:aaload          
    //  470  751:iload_2         
    //  471  752:daload          
    //  472  753:dmul            
    //  473  754:dload           9
    //  474  756:dload           17
    //  475  758:dmul            
    //  476  759:dsub            
    //  477  760:dastore         
                    }

    //  478  761:iinc            31  1
    //  479  764:iload           31
    //  480  766:iload_2         
    //  481  767:icmple          692
                    for(int i = low; i <= high; i++)
    //* 482  770:iload_3         
    //* 483  771:istore          31
    //* 484  773:goto            848
                    {
                        z = V[i][n - 1];
    //  485  776:aload_0         
    //  486  777:getfield        #27  <Field double[][] V>
    //  487  780:iload           31
    //  488  782:aaload          
    //  489  783:iload_2         
    //  490  784:iconst_1        
    //  491  785:isub            
    //  492  786:daload          
    //  493  787:dstore          17
                        V[i][n - 1] = q * z + p * V[i][n];
    //  494  789:aload_0         
    //  495  790:getfield        #27  <Field double[][] V>
    //  496  793:iload           31
    //  497  795:aaload          
    //  498  796:iload_2         
    //  499  797:iconst_1        
    //  500  798:isub            
    //  501  799:dload           11
    //  502  801:dload           17
    //  503  803:dmul            
    //  504  804:dload           9
    //  505  806:aload_0         
    //  506  807:getfield        #27  <Field double[][] V>
    //  507  810:iload           31
    //  508  812:aaload          
    //  509  813:iload_2         
    //  510  814:daload          
    //  511  815:dmul            
    //  512  816:dadd            
    //  513  817:dastore         
                        V[i][n] = q * V[i][n] - p * z;
    //  514  818:aload_0         
    //  515  819:getfield        #27  <Field double[][] V>
    //  516  822:iload           31
    //  517  824:aaload          
    //  518  825:iload_2         
    //  519  826:dload           11
    //  520  828:aload_0         
    //  521  829:getfield        #27  <Field double[][] V>
    //  522  832:iload           31
    //  523  834:aaload          
    //  524  835:iload_2         
    //  525  836:daload          
    //  526  837:dmul            
    //  527  838:dload           9
    //  528  840:dload           17
    //  529  842:dmul            
    //  530  843:dsub            
    //  531  844:dastore         
                    }

    //  532  845:iinc            31  1
    //  533  848:iload           31
    //  534  850:iload           4
    //  535  852:icmple          776
                } else
    //* 536  855:goto            901
                {
                    d[n - 1] = x + p;
    //  537  858:aload_0         
    //  538  859:getfield        #25  <Field double[] d>
    //  539  862:iload_2         
    //  540  863:iconst_1        
    //  541  864:isub            
    //  542  865:dload           23
    //  543  867:dload           9
    //  544  869:dadd            
    //  545  870:dastore         
                    d[n] = x + p;
    //  546  871:aload_0         
    //  547  872:getfield        #25  <Field double[] d>
    //  548  875:iload_2         
    //  549  876:dload           23
    //  550  878:dload           9
    //  551  880:dadd            
    //  552  881:dastore         
                    e[n - 1] = z;
    //  553  882:aload_0         
    //  554  883:getfield        #37  <Field double[] e>
    //  555  886:iload_2         
    //  556  887:iconst_1        
    //  557  888:isub            
    //  558  889:dload           17
    //  559  891:dastore         
                    e[n] = -z;
    //  560  892:aload_0         
    //  561  893:getfield        #37  <Field double[] e>
    //  562  896:iload_2         
    //  563  897:dload           17
    //  564  899:dneg            
    //  565  900:dastore         
                }
                n -= 2;
    //  566  901:iinc            2  -2
                iter = 0;
    //  567  904:iconst_0        
    //  568  905:istore          29
            } else
    //* 569  907:goto            2266
            {
                double x = H[n][n];
    //  570  910:aload_0         
    //  571  911:getfield        #86  <Field double[][] H>
    //  572  914:iload_2         
    //  573  915:aaload          
    //  574  916:iload_2         
    //  575  917:daload          
    //  576  918:dstore          23
                double y = 0.0D;
    //  577  920:dconst_0        
    //  578  921:dstore          25
                double w = 0.0D;
    //  579  923:dconst_0        
    //  580  924:dstore          21
                if(l < n)
    //* 581  926:iload           30
    //* 582  928:iload_2         
    //* 583  929:icmpge          969
                {
                    y = H[n - 1][n - 1];
    //  584  932:aload_0         
    //  585  933:getfield        #86  <Field double[][] H>
    //  586  936:iload_2         
    //  587  937:iconst_1        
    //  588  938:isub            
    //  589  939:aaload          
    //  590  940:iload_2         
    //  591  941:iconst_1        
    //  592  942:isub            
    //  593  943:daload          
    //  594  944:dstore          25
                    w = H[n][n - 1] * H[n - 1][n];
    //  595  946:aload_0         
    //  596  947:getfield        #86  <Field double[][] H>
    //  597  950:iload_2         
    //  598  951:aaload          
    //  599  952:iload_2         
    //  600  953:iconst_1        
    //  601  954:isub            
    //  602  955:daload          
    //  603  956:aload_0         
    //  604  957:getfield        #86  <Field double[][] H>
    //  605  960:iload_2         
    //  606  961:iconst_1        
    //  607  962:isub            
    //  608  963:aaload          
    //  609  964:iload_2         
    //  610  965:daload          
    //  611  966:dmul            
    //  612  967:dstore          21
                }
                if(iter == 10)
    //* 613  969:iload           29
    //* 614  971:bipush          10
    //* 615  973:icmpne          1066
                {
                    exshift += x;
    //  616  976:dload           7
    //  617  978:dload           23
    //  618  980:dadd            
    //  619  981:dstore          7
                    for(int i = low; i <= n; i++)
    //* 620  983:iload_3         
    //* 621  984:istore          31
    //* 622  986:goto            1007
                        H[i][i] -= x;
    //  623  989:aload_0         
    //  624  990:getfield        #86  <Field double[][] H>
    //  625  993:iload           31
    //  626  995:aaload          
    //  627  996:iload           31
    //  628  998:dup2            
    //  629  999:daload          
    //  630 1000:dload           23
    //  631 1002:dsub            
    //  632 1003:dastore         

    //  633 1004:iinc            31  1
    //  634 1007:iload           31
    //  635 1009:iload_2         
    //  636 1010:icmple          989
                    s = Math.abs(H[n][n - 1]) + Math.abs(H[n - 1][n - 2]);
    //  637 1013:aload_0         
    //  638 1014:getfield        #86  <Field double[][] H>
    //  639 1017:iload_2         
    //  640 1018:aaload          
    //  641 1019:iload_2         
    //  642 1020:iconst_1        
    //  643 1021:isub            
    //  644 1022:daload          
    //  645 1023:invokestatic    #35  <Method double Math.abs(double)>
    //  646 1026:aload_0         
    //  647 1027:getfield        #86  <Field double[][] H>
    //  648 1030:iload_2         
    //  649 1031:iconst_1        
    //  650 1032:isub            
    //  651 1033:aaload          
    //  652 1034:iload_2         
    //  653 1035:iconst_2        
    //  654 1036:isub            
    //  655 1037:daload          
    //  656 1038:invokestatic    #35  <Method double Math.abs(double)>
    //  657 1041:dadd            
    //  658 1042:dstore          15
                    x = y = 0.75D * s;
    //  659 1044:ldc2w           #105 <Double 0.75D>
    //  660 1047:dload           15
    //  661 1049:dmul            
    //  662 1050:dup2            
    //  663 1051:dstore          25
    //  664 1053:dstore          23
                    w = -0.4375D * s * s;
    //  665 1055:ldc2w           #107 <Double -0.4375D>
    //  666 1058:dload           15
    //  667 1060:dmul            
    //  668 1061:dload           15
    //  669 1063:dmul            
    //  670 1064:dstore          21
                }
                if(iter == 30)
    //* 671 1066:iload           29
    //* 672 1068:bipush          30
    //* 673 1070:icmpne          1189
                {
                    s = (y - x) / 2D;
    //  674 1073:dload           25
    //  675 1075:dload           23
    //  676 1077:dsub            
    //  677 1078:ldc2w           #54  <Double 2D>
    //  678 1081:ddiv            
    //  679 1082:dstore          15
                    s = s * s + w;
    //  680 1084:dload           15
    //  681 1086:dload           15
    //  682 1088:dmul            
    //  683 1089:dload           21
    //  684 1091:dadd            
    //  685 1092:dstore          15
                    if(s > 0.0D)
    //* 686 1094:dload           15
    //* 687 1096:dconst_0        
    //* 688 1097:dcmpl           
    //* 689 1098:ifle            1189
                    {
                        s = Math.sqrt(s);
    //  690 1101:dload           15
    //  691 1103:invokestatic    #40  <Method double Math.sqrt(double)>
    //  692 1106:dstore          15
                        if(y < x)
    //* 693 1108:dload           25
    //* 694 1110:dload           23
    //* 695 1112:dcmpg           
    //* 696 1113:ifge            1121
                            s = -s;
    //  697 1116:dload           15
    //  698 1118:dneg            
    //  699 1119:dstore          15
                        s = x - w / ((y - x) / 2D + s);
    //  700 1121:dload           23
    //  701 1123:dload           21
    //  702 1125:dload           25
    //  703 1127:dload           23
    //  704 1129:dsub            
    //  705 1130:ldc2w           #54  <Double 2D>
    //  706 1133:ddiv            
    //  707 1134:dload           15
    //  708 1136:dadd            
    //  709 1137:ddiv            
    //  710 1138:dsub            
    //  711 1139:dstore          15
                        for(int i = low; i <= n; i++)
    //* 712 1141:iload_3         
    //* 713 1142:istore          31
    //* 714 1144:goto            1165
                            H[i][i] -= s;
    //  715 1147:aload_0         
    //  716 1148:getfield        #86  <Field double[][] H>
    //  717 1151:iload           31
    //  718 1153:aaload          
    //  719 1154:iload           31
    //  720 1156:dup2            
    //  721 1157:daload          
    //  722 1158:dload           15
    //  723 1160:dsub            
    //  724 1161:dastore         

    //  725 1162:iinc            31  1
    //  726 1165:iload           31
    //  727 1167:iload_2         
    //  728 1168:icmple          1147
                        exshift += s;
    //  729 1171:dload           7
    //  730 1173:dload           15
    //  731 1175:dadd            
    //  732 1176:dstore          7
                        x = y = w = 0.96399999999999997D;
    //  733 1178:ldc2w           #109 <Double 0.96399999999999997D>
    //  734 1181:dup2            
    //  735 1182:dstore          21
    //  736 1184:dup2            
    //  737 1185:dstore          25
    //  738 1187:dstore          23
                    }
                }
                iter++;
    //  739 1189:iinc            29  1
                int m;
                for(m = n - 2; m >= l; m--)
    //* 740 1192:iload_2         
    //* 741 1193:iconst_2        
    //* 742 1194:isub            
    //* 743 1195:istore          31
    //* 744 1197:goto            1440
                {
                    z = H[m][m];
    //  745 1200:aload_0         
    //  746 1201:getfield        #86  <Field double[][] H>
    //  747 1204:iload           31
    //  748 1206:aaload          
    //  749 1207:iload           31
    //  750 1209:daload          
    //  751 1210:dstore          17
                    r = x - z;
    //  752 1212:dload           23
    //  753 1214:dload           17
    //  754 1216:dsub            
    //  755 1217:dstore          13
                    s = y - z;
    //  756 1219:dload           25
    //  757 1221:dload           17
    //  758 1223:dsub            
    //  759 1224:dstore          15
                    p = (r * s - w) / H[m + 1][m] + H[m][m + 1];
    //  760 1226:dload           13
    //  761 1228:dload           15
    //  762 1230:dmul            
    //  763 1231:dload           21
    //  764 1233:dsub            
    //  765 1234:aload_0         
    //  766 1235:getfield        #86  <Field double[][] H>
    //  767 1238:iload           31
    //  768 1240:iconst_1        
    //  769 1241:iadd            
    //  770 1242:aaload          
    //  771 1243:iload           31
    //  772 1245:daload          
    //  773 1246:ddiv            
    //  774 1247:aload_0         
    //  775 1248:getfield        #86  <Field double[][] H>
    //  776 1251:iload           31
    //  777 1253:aaload          
    //  778 1254:iload           31
    //  779 1256:iconst_1        
    //  780 1257:iadd            
    //  781 1258:daload          
    //  782 1259:dadd            
    //  783 1260:dstore          9
                    q = H[m + 1][m + 1] - z - r - s;
    //  784 1262:aload_0         
    //  785 1263:getfield        #86  <Field double[][] H>
    //  786 1266:iload           31
    //  787 1268:iconst_1        
    //  788 1269:iadd            
    //  789 1270:aaload          
    //  790 1271:iload           31
    //  791 1273:iconst_1        
    //  792 1274:iadd            
    //  793 1275:daload          
    //  794 1276:dload           17
    //  795 1278:dsub            
    //  796 1279:dload           13
    //  797 1281:dsub            
    //  798 1282:dload           15
    //  799 1284:dsub            
    //  800 1285:dstore          11
                    r = H[m + 2][m + 1];
    //  801 1287:aload_0         
    //  802 1288:getfield        #86  <Field double[][] H>
    //  803 1291:iload           31
    //  804 1293:iconst_2        
    //  805 1294:iadd            
    //  806 1295:aaload          
    //  807 1296:iload           31
    //  808 1298:iconst_1        
    //  809 1299:iadd            
    //  810 1300:daload          
    //  811 1301:dstore          13
                    s = Math.abs(p) + Math.abs(q) + Math.abs(r);
    //  812 1303:dload           9
    //  813 1305:invokestatic    #35  <Method double Math.abs(double)>
    //  814 1308:dload           11
    //  815 1310:invokestatic    #35  <Method double Math.abs(double)>
    //  816 1313:dadd            
    //  817 1314:dload           13
    //  818 1316:invokestatic    #35  <Method double Math.abs(double)>
    //  819 1319:dadd            
    //  820 1320:dstore          15
                    p /= s;
    //  821 1322:dload           9
    //  822 1324:dload           15
    //  823 1326:ddiv            
    //  824 1327:dstore          9
                    q /= s;
    //  825 1329:dload           11
    //  826 1331:dload           15
    //  827 1333:ddiv            
    //  828 1334:dstore          11
                    r /= s;
    //  829 1336:dload           13
    //  830 1338:dload           15
    //  831 1340:ddiv            
    //  832 1341:dstore          13
                    if(m == l || Math.abs(H[m][m - 1]) * (Math.abs(q) + Math.abs(r)) < eps * (Math.abs(p) * (Math.abs(H[m - 1][m - 1]) + Math.abs(z) + Math.abs(H[m + 1][m + 1]))))
    //* 833 1343:iload           31
    //* 834 1345:iload           30
    //* 835 1347:icmpne          1353
    //* 836 1350:goto            1447
    //* 837 1353:aload_0         
    //* 838 1354:getfield        #86  <Field double[][] H>
    //* 839 1357:iload           31
    //* 840 1359:aaload          
    //* 841 1360:iload           31
    //* 842 1362:iconst_1        
    //* 843 1363:isub            
    //* 844 1364:daload          
    //* 845 1365:invokestatic    #35  <Method double Math.abs(double)>
    //* 846 1368:dload           11
    //* 847 1370:invokestatic    #35  <Method double Math.abs(double)>
    //* 848 1373:dload           13
    //* 849 1375:invokestatic    #35  <Method double Math.abs(double)>
    //* 850 1378:dadd            
    //* 851 1379:dmul            
    //* 852 1380:dload           5
    //* 853 1382:dload           9
    //* 854 1384:invokestatic    #35  <Method double Math.abs(double)>
    //* 855 1387:aload_0         
    //* 856 1388:getfield        #86  <Field double[][] H>
    //* 857 1391:iload           31
    //* 858 1393:iconst_1        
    //* 859 1394:isub            
    //* 860 1395:aaload          
    //* 861 1396:iload           31
    //* 862 1398:iconst_1        
    //* 863 1399:isub            
    //* 864 1400:daload          
    //* 865 1401:invokestatic    #35  <Method double Math.abs(double)>
    //* 866 1404:dload           17
    //* 867 1406:invokestatic    #35  <Method double Math.abs(double)>
    //* 868 1409:dadd            
    //* 869 1410:aload_0         
    //* 870 1411:getfield        #86  <Field double[][] H>
    //* 871 1414:iload           31
    //* 872 1416:iconst_1        
    //* 873 1417:iadd            
    //* 874 1418:aaload          
    //* 875 1419:iload           31
    //* 876 1421:iconst_1        
    //* 877 1422:iadd            
    //* 878 1423:daload          
    //* 879 1424:invokestatic    #35  <Method double Math.abs(double)>
    //* 880 1427:dadd            
    //* 881 1428:dmul            
    //* 882 1429:dmul            
    //* 883 1430:dcmpg           
    //* 884 1431:ifge            1437
                        break;
    //  885 1434:goto            1447
                }

    //  886 1437:iinc            31  -1
    //  887 1440:iload           31
    //  888 1442:iload           30
    //  889 1444:icmpge          1200
                for(int i = m + 2; i <= n; i++)
    //* 890 1447:iload           31
    //* 891 1449:iconst_2        
    //* 892 1450:iadd            
    //* 893 1451:istore          32
    //* 894 1453:goto            1494
                {
                    H[i][i - 2] = 0.0D;
    //  895 1456:aload_0         
    //  896 1457:getfield        #86  <Field double[][] H>
    //  897 1460:iload           32
    //  898 1462:aaload          
    //  899 1463:iload           32
    //  900 1465:iconst_2        
    //  901 1466:isub            
    //  902 1467:dconst_0        
    //  903 1468:dastore         
                    if(i > m + 2)
    //* 904 1469:iload           32
    //* 905 1471:iload           31
    //* 906 1473:iconst_2        
    //* 907 1474:iadd            
    //* 908 1475:icmple          1491
                        H[i][i - 3] = 0.0D;
    //  909 1478:aload_0         
    //  910 1479:getfield        #86  <Field double[][] H>
    //  911 1482:iload           32
    //  912 1484:aaload          
    //  913 1485:iload           32
    //  914 1487:iconst_3        
    //  915 1488:isub            
    //  916 1489:dconst_0        
    //  917 1490:dastore         
                }

    //  918 1491:iinc            32  1
    //  919 1494:iload           32
    //  920 1496:iload_2         
    //  921 1497:icmple          1456
                for(int k = m; k <= n - 1; k++)
    //* 922 1500:iload           31
    //* 923 1502:istore          32
    //* 924 1504:goto            2258
                {
                    boolean notlast = k != n - 1;
    //  925 1507:iload           32
    //  926 1509:iload_2         
    //  927 1510:iconst_1        
    //  928 1511:isub            
    //  929 1512:icmpeq          1519
    //  930 1515:iconst_1        
    //  931 1516:goto            1520
    //  932 1519:iconst_0        
    //  933 1520:istore          33
                    if(k != m)
    //* 934 1522:iload           32
    //* 935 1524:iload           31
    //* 936 1526:icmpeq          1631
                    {
                        p = H[k][k - 1];
    //  937 1529:aload_0         
    //  938 1530:getfield        #86  <Field double[][] H>
    //  939 1533:iload           32
    //  940 1535:aaload          
    //  941 1536:iload           32
    //  942 1538:iconst_1        
    //  943 1539:isub            
    //  944 1540:daload          
    //  945 1541:dstore          9
                        q = H[k + 1][k - 1];
    //  946 1543:aload_0         
    //  947 1544:getfield        #86  <Field double[][] H>
    //  948 1547:iload           32
    //  949 1549:iconst_1        
    //  950 1550:iadd            
    //  951 1551:aaload          
    //  952 1552:iload           32
    //  953 1554:iconst_1        
    //  954 1555:isub            
    //  955 1556:daload          
    //  956 1557:dstore          11
                        r = notlast ? H[k + 2][k - 1] : 0.0D;
    //  957 1559:iload           33
    //  958 1561:ifeq            1581
    //  959 1564:aload_0         
    //  960 1565:getfield        #86  <Field double[][] H>
    //  961 1568:iload           32
    //  962 1570:iconst_2        
    //  963 1571:iadd            
    //  964 1572:aaload          
    //  965 1573:iload           32
    //  966 1575:iconst_1        
    //  967 1576:isub            
    //  968 1577:daload          
    //  969 1578:goto            1582
    //  970 1581:dconst_0        
    //  971 1582:dstore          13
                        x = Math.abs(p) + Math.abs(q) + Math.abs(r);
    //  972 1584:dload           9
    //  973 1586:invokestatic    #35  <Method double Math.abs(double)>
    //  974 1589:dload           11
    //  975 1591:invokestatic    #35  <Method double Math.abs(double)>
    //  976 1594:dadd            
    //  977 1595:dload           13
    //  978 1597:invokestatic    #35  <Method double Math.abs(double)>
    //  979 1600:dadd            
    //  980 1601:dstore          23
                        if(x != 0.0D)
    //* 981 1603:dload           23
    //* 982 1605:dconst_0        
    //* 983 1606:dcmpl           
    //* 984 1607:ifeq            1631
                        {
                            p /= x;
    //  985 1610:dload           9
    //  986 1612:dload           23
    //  987 1614:ddiv            
    //  988 1615:dstore          9
                            q /= x;
    //  989 1617:dload           11
    //  990 1619:dload           23
    //  991 1621:ddiv            
    //  992 1622:dstore          11
                            r /= x;
    //  993 1624:dload           13
    //  994 1626:dload           23
    //  995 1628:ddiv            
    //  996 1629:dstore          13
                        }
                    }
                    if(x == 0.0D)
    //* 997 1631:dload           23
    //* 998 1633:dconst_0        
    //* 999 1634:dcmpl           
    //*1000 1635:ifne            1641
                        break;
    // 1001 1638:goto            2266
                    s = Math.sqrt(p * p + q * q + r * r);
    // 1002 1641:dload           9
    // 1003 1643:dload           9
    // 1004 1645:dmul            
    // 1005 1646:dload           11
    // 1006 1648:dload           11
    // 1007 1650:dmul            
    // 1008 1651:dadd            
    // 1009 1652:dload           13
    // 1010 1654:dload           13
    // 1011 1656:dmul            
    // 1012 1657:dadd            
    // 1013 1658:invokestatic    #40  <Method double Math.sqrt(double)>
    // 1014 1661:dstore          15
                    if(p < 0.0D)
    //*1015 1663:dload           9
    //*1016 1665:dconst_0        
    //*1017 1666:dcmpg           
    //*1018 1667:ifge            1675
                        s = -s;
    // 1019 1670:dload           15
    // 1020 1672:dneg            
    // 1021 1673:dstore          15
                    if(s != 0.0D)
    //*1022 1675:dload           15
    //*1023 1677:dconst_0        
    //*1024 1678:dcmpl           
    //*1025 1679:ifeq            2255
                    {
                        if(k != m)
    //*1026 1682:iload           32
    //*1027 1684:iload           31
    //*1028 1686:icmpeq          1710
                            H[k][k - 1] = -s * x;
    // 1029 1689:aload_0         
    // 1030 1690:getfield        #86  <Field double[][] H>
    // 1031 1693:iload           32
    // 1032 1695:aaload          
    // 1033 1696:iload           32
    // 1034 1698:iconst_1        
    // 1035 1699:isub            
    // 1036 1700:dload           15
    // 1037 1702:dneg            
    // 1038 1703:dload           23
    // 1039 1705:dmul            
    // 1040 1706:dastore         
                        else
    //*1041 1707:goto            1742
                        if(l != m)
    //*1042 1710:iload           30
    //*1043 1712:iload           31
    //*1044 1714:icmpeq          1742
                            H[k][k - 1] = -H[k][k - 1];
    // 1045 1717:aload_0         
    // 1046 1718:getfield        #86  <Field double[][] H>
    // 1047 1721:iload           32
    // 1048 1723:aaload          
    // 1049 1724:iload           32
    // 1050 1726:iconst_1        
    // 1051 1727:isub            
    // 1052 1728:aload_0         
    // 1053 1729:getfield        #86  <Field double[][] H>
    // 1054 1732:iload           32
    // 1055 1734:aaload          
    // 1056 1735:iload           32
    // 1057 1737:iconst_1        
    // 1058 1738:isub            
    // 1059 1739:daload          
    // 1060 1740:dneg            
    // 1061 1741:dastore         
                        p += s;
    // 1062 1742:dload           9
    // 1063 1744:dload           15
    // 1064 1746:dadd            
    // 1065 1747:dstore          9
                        x = p / s;
    // 1066 1749:dload           9
    // 1067 1751:dload           15
    // 1068 1753:ddiv            
    // 1069 1754:dstore          23
                        y = q / s;
    // 1070 1756:dload           11
    // 1071 1758:dload           15
    // 1072 1760:ddiv            
    // 1073 1761:dstore          25
                        z = r / s;
    // 1074 1763:dload           13
    // 1075 1765:dload           15
    // 1076 1767:ddiv            
    // 1077 1768:dstore          17
                        q /= p;
    // 1078 1770:dload           11
    // 1079 1772:dload           9
    // 1080 1774:ddiv            
    // 1081 1775:dstore          11
                        r /= p;
    // 1082 1777:dload           13
    // 1083 1779:dload           9
    // 1084 1781:ddiv            
    // 1085 1782:dstore          13
                        for(int j = k; j < nn; j++)
    //*1086 1784:iload           32
    //*1087 1786:istore          34
    //*1088 1788:goto            1933
                        {
                            p = H[k][j] + q * H[k + 1][j];
    // 1089 1791:aload_0         
    // 1090 1792:getfield        #86  <Field double[][] H>
    // 1091 1795:iload           32
    // 1092 1797:aaload          
    // 1093 1798:iload           34
    // 1094 1800:daload          
    // 1095 1801:dload           11
    // 1096 1803:aload_0         
    // 1097 1804:getfield        #86  <Field double[][] H>
    // 1098 1807:iload           32
    // 1099 1809:iconst_1        
    // 1100 1810:iadd            
    // 1101 1811:aaload          
    // 1102 1812:iload           34
    // 1103 1814:daload          
    // 1104 1815:dmul            
    // 1105 1816:dadd            
    // 1106 1817:dstore          9
                            if(notlast)
    //*1107 1819:iload           33
    //*1108 1821:ifeq            1874
                            {
                                p += r * H[k + 2][j];
    // 1109 1824:dload           9
    // 1110 1826:dload           13
    // 1111 1828:aload_0         
    // 1112 1829:getfield        #86  <Field double[][] H>
    // 1113 1832:iload           32
    // 1114 1834:iconst_2        
    // 1115 1835:iadd            
    // 1116 1836:aaload          
    // 1117 1837:iload           34
    // 1118 1839:daload          
    // 1119 1840:dmul            
    // 1120 1841:dadd            
    // 1121 1842:dstore          9
                                H[k + 2][j] = H[k + 2][j] - p * z;
    // 1122 1844:aload_0         
    // 1123 1845:getfield        #86  <Field double[][] H>
    // 1124 1848:iload           32
    // 1125 1850:iconst_2        
    // 1126 1851:iadd            
    // 1127 1852:aaload          
    // 1128 1853:iload           34
    // 1129 1855:aload_0         
    // 1130 1856:getfield        #86  <Field double[][] H>
    // 1131 1859:iload           32
    // 1132 1861:iconst_2        
    // 1133 1862:iadd            
    // 1134 1863:aaload          
    // 1135 1864:iload           34
    // 1136 1866:daload          
    // 1137 1867:dload           9
    // 1138 1869:dload           17
    // 1139 1871:dmul            
    // 1140 1872:dsub            
    // 1141 1873:dastore         
                            }
                            H[k][j] = H[k][j] - p * x;
    // 1142 1874:aload_0         
    // 1143 1875:getfield        #86  <Field double[][] H>
    // 1144 1878:iload           32
    // 1145 1880:aaload          
    // 1146 1881:iload           34
    // 1147 1883:aload_0         
    // 1148 1884:getfield        #86  <Field double[][] H>
    // 1149 1887:iload           32
    // 1150 1889:aaload          
    // 1151 1890:iload           34
    // 1152 1892:daload          
    // 1153 1893:dload           9
    // 1154 1895:dload           23
    // 1155 1897:dmul            
    // 1156 1898:dsub            
    // 1157 1899:dastore         
                            H[k + 1][j] = H[k + 1][j] - p * y;
    // 1158 1900:aload_0         
    // 1159 1901:getfield        #86  <Field double[][] H>
    // 1160 1904:iload           32
    // 1161 1906:iconst_1        
    // 1162 1907:iadd            
    // 1163 1908:aaload          
    // 1164 1909:iload           34
    // 1165 1911:aload_0         
    // 1166 1912:getfield        #86  <Field double[][] H>
    // 1167 1915:iload           32
    // 1168 1917:iconst_1        
    // 1169 1918:iadd            
    // 1170 1919:aaload          
    // 1171 1920:iload           34
    // 1172 1922:daload          
    // 1173 1923:dload           9
    // 1174 1925:dload           25
    // 1175 1927:dmul            
    // 1176 1928:dsub            
    // 1177 1929:dastore         
                        }

    // 1178 1930:iinc            34  1
    // 1179 1933:iload           34
    // 1180 1935:iload_1         
    // 1181 1936:icmplt          1791
                        for(int i = 0; i <= Math.min(n, k + 3); i++)
    //*1182 1939:iconst_0        
    //*1183 1940:istore          34
    //*1184 1942:goto            2087
                        {
                            p = x * H[i][k] + y * H[i][k + 1];
    // 1185 1945:dload           23
    // 1186 1947:aload_0         
    // 1187 1948:getfield        #86  <Field double[][] H>
    // 1188 1951:iload           34
    // 1189 1953:aaload          
    // 1190 1954:iload           32
    // 1191 1956:daload          
    // 1192 1957:dmul            
    // 1193 1958:dload           25
    // 1194 1960:aload_0         
    // 1195 1961:getfield        #86  <Field double[][] H>
    // 1196 1964:iload           34
    // 1197 1966:aaload          
    // 1198 1967:iload           32
    // 1199 1969:iconst_1        
    // 1200 1970:iadd            
    // 1201 1971:daload          
    // 1202 1972:dmul            
    // 1203 1973:dadd            
    // 1204 1974:dstore          9
                            if(notlast)
    //*1205 1976:iload           33
    //*1206 1978:ifeq            2031
                            {
                                p += z * H[i][k + 2];
    // 1207 1981:dload           9
    // 1208 1983:dload           17
    // 1209 1985:aload_0         
    // 1210 1986:getfield        #86  <Field double[][] H>
    // 1211 1989:iload           34
    // 1212 1991:aaload          
    // 1213 1992:iload           32
    // 1214 1994:iconst_2        
    // 1215 1995:iadd            
    // 1216 1996:daload          
    // 1217 1997:dmul            
    // 1218 1998:dadd            
    // 1219 1999:dstore          9
                                H[i][k + 2] = H[i][k + 2] - p * r;
    // 1220 2001:aload_0         
    // 1221 2002:getfield        #86  <Field double[][] H>
    // 1222 2005:iload           34
    // 1223 2007:aaload          
    // 1224 2008:iload           32
    // 1225 2010:iconst_2        
    // 1226 2011:iadd            
    // 1227 2012:aload_0         
    // 1228 2013:getfield        #86  <Field double[][] H>
    // 1229 2016:iload           34
    // 1230 2018:aaload          
    // 1231 2019:iload           32
    // 1232 2021:iconst_2        
    // 1233 2022:iadd            
    // 1234 2023:daload          
    // 1235 2024:dload           9
    // 1236 2026:dload           13
    // 1237 2028:dmul            
    // 1238 2029:dsub            
    // 1239 2030:dastore         
                            }
                            H[i][k] = H[i][k] - p;
    // 1240 2031:aload_0         
    // 1241 2032:getfield        #86  <Field double[][] H>
    // 1242 2035:iload           34
    // 1243 2037:aaload          
    // 1244 2038:iload           32
    // 1245 2040:aload_0         
    // 1246 2041:getfield        #86  <Field double[][] H>
    // 1247 2044:iload           34
    // 1248 2046:aaload          
    // 1249 2047:iload           32
    // 1250 2049:daload          
    // 1251 2050:dload           9
    // 1252 2052:dsub            
    // 1253 2053:dastore         
                            H[i][k + 1] = H[i][k + 1] - p * q;
    // 1254 2054:aload_0         
    // 1255 2055:getfield        #86  <Field double[][] H>
    // 1256 2058:iload           34
    // 1257 2060:aaload          
    // 1258 2061:iload           32
    // 1259 2063:iconst_1        
    // 1260 2064:iadd            
    // 1261 2065:aload_0         
    // 1262 2066:getfield        #86  <Field double[][] H>
    // 1263 2069:iload           34
    // 1264 2071:aaload          
    // 1265 2072:iload           32
    // 1266 2074:iconst_1        
    // 1267 2075:iadd            
    // 1268 2076:daload          
    // 1269 2077:dload           9
    // 1270 2079:dload           11
    // 1271 2081:dmul            
    // 1272 2082:dsub            
    // 1273 2083:dastore         
                        }

    // 1274 2084:iinc            34  1
    // 1275 2087:iload           34
    // 1276 2089:iload_2         
    // 1277 2090:iload           32
    // 1278 2092:iconst_3        
    // 1279 2093:iadd            
    // 1280 2094:invokestatic    #113 <Method int Math.min(int, int)>
    // 1281 2097:icmple          1945
                        for(int i = low; i <= high; i++)
    //*1282 2100:iload_3         
    //*1283 2101:istore          34
    //*1284 2103:goto            2248
                        {
                            p = x * V[i][k] + y * V[i][k + 1];
    // 1285 2106:dload           23
    // 1286 2108:aload_0         
    // 1287 2109:getfield        #27  <Field double[][] V>
    // 1288 2112:iload           34
    // 1289 2114:aaload          
    // 1290 2115:iload           32
    // 1291 2117:daload          
    // 1292 2118:dmul            
    // 1293 2119:dload           25
    // 1294 2121:aload_0         
    // 1295 2122:getfield        #27  <Field double[][] V>
    // 1296 2125:iload           34
    // 1297 2127:aaload          
    // 1298 2128:iload           32
    // 1299 2130:iconst_1        
    // 1300 2131:iadd            
    // 1301 2132:daload          
    // 1302 2133:dmul            
    // 1303 2134:dadd            
    // 1304 2135:dstore          9
                            if(notlast)
    //*1305 2137:iload           33
    //*1306 2139:ifeq            2192
                            {
                                p += z * V[i][k + 2];
    // 1307 2142:dload           9
    // 1308 2144:dload           17
    // 1309 2146:aload_0         
    // 1310 2147:getfield        #27  <Field double[][] V>
    // 1311 2150:iload           34
    // 1312 2152:aaload          
    // 1313 2153:iload           32
    // 1314 2155:iconst_2        
    // 1315 2156:iadd            
    // 1316 2157:daload          
    // 1317 2158:dmul            
    // 1318 2159:dadd            
    // 1319 2160:dstore          9
                                V[i][k + 2] = V[i][k + 2] - p * r;
    // 1320 2162:aload_0         
    // 1321 2163:getfield        #27  <Field double[][] V>
    // 1322 2166:iload           34
    // 1323 2168:aaload          
    // 1324 2169:iload           32
    // 1325 2171:iconst_2        
    // 1326 2172:iadd            
    // 1327 2173:aload_0         
    // 1328 2174:getfield        #27  <Field double[][] V>
    // 1329 2177:iload           34
    // 1330 2179:aaload          
    // 1331 2180:iload           32
    // 1332 2182:iconst_2        
    // 1333 2183:iadd            
    // 1334 2184:daload          
    // 1335 2185:dload           9
    // 1336 2187:dload           13
    // 1337 2189:dmul            
    // 1338 2190:dsub            
    // 1339 2191:dastore         
                            }
                            V[i][k] = V[i][k] - p;
    // 1340 2192:aload_0         
    // 1341 2193:getfield        #27  <Field double[][] V>
    // 1342 2196:iload           34
    // 1343 2198:aaload          
    // 1344 2199:iload           32
    // 1345 2201:aload_0         
    // 1346 2202:getfield        #27  <Field double[][] V>
    // 1347 2205:iload           34
    // 1348 2207:aaload          
    // 1349 2208:iload           32
    // 1350 2210:daload          
    // 1351 2211:dload           9
    // 1352 2213:dsub            
    // 1353 2214:dastore         
                            V[i][k + 1] = V[i][k + 1] - p * q;
    // 1354 2215:aload_0         
    // 1355 2216:getfield        #27  <Field double[][] V>
    // 1356 2219:iload           34
    // 1357 2221:aaload          
    // 1358 2222:iload           32
    // 1359 2224:iconst_1        
    // 1360 2225:iadd            
    // 1361 2226:aload_0         
    // 1362 2227:getfield        #27  <Field double[][] V>
    // 1363 2230:iload           34
    // 1364 2232:aaload          
    // 1365 2233:iload           32
    // 1366 2235:iconst_1        
    // 1367 2236:iadd            
    // 1368 2237:daload          
    // 1369 2238:dload           9
    // 1370 2240:dload           11
    // 1371 2242:dmul            
    // 1372 2243:dsub            
    // 1373 2244:dastore         
                        }

    // 1374 2245:iinc            34  1
    // 1375 2248:iload           34
    // 1376 2250:iload           4
    // 1377 2252:icmple          2106
                    }
                }

    // 1378 2255:iinc            32  1
    // 1379 2258:iload           32
    // 1380 2260:iload_2         
    // 1381 2261:iconst_1        
    // 1382 2262:isub            
    // 1383 2263:icmple          1507
            }
        }
    // 1384 2266:iload_2         
    // 1385 2267:iload_3         
    // 1386 2268:icmpge          161
        if(norm == 0.0D)
    //*1387 2271:dload           27
    //*1388 2273:dconst_0        
    //*1389 2274:dcmpl           
    //*1390 2275:ifne            2279
            return;
    // 1391 2278:return          
        for(n = nn - 1; n >= 0; n--)
    //*1392 2279:iload_1         
    //*1393 2280:iconst_1        
    //*1394 2281:isub            
    //*1395 2282:istore_2        
    //*1396 2283:goto            3609
        {
            p = d[n];
    // 1397 2286:aload_0         
    // 1398 2287:getfield        #25  <Field double[] d>
    // 1399 2290:iload_2         
    // 1400 2291:daload          
    // 1401 2292:dstore          9
            q = e[n];
    // 1402 2294:aload_0         
    // 1403 2295:getfield        #37  <Field double[] e>
    // 1404 2298:iload_2         
    // 1405 2299:daload          
    // 1406 2300:dstore          11
            if(q == 0.0D)
    //*1407 2302:dload           11
    //*1408 2304:dconst_0        
    //*1409 2305:dcmpl           
    //*1410 2306:ifne            2705
            {
                int l = n;
    // 1411 2309:iload_2         
    // 1412 2310:istore          30
                H[n][n] = 1.0D;
    // 1413 2312:aload_0         
    // 1414 2313:getfield        #86  <Field double[][] H>
    // 1415 2316:iload_2         
    // 1416 2317:aaload          
    // 1417 2318:iload_2         
    // 1418 2319:dconst_1        
    // 1419 2320:dastore         
                for(int i = n - 1; i >= 0; i--)
    //*1420 2321:iload_2         
    //*1421 2322:iconst_1        
    //*1422 2323:isub            
    //*1423 2324:istore          31
    //*1424 2326:goto            2697
                {
                    double w = H[i][i] - p;
    // 1425 2329:aload_0         
    // 1426 2330:getfield        #86  <Field double[][] H>
    // 1427 2333:iload           31
    // 1428 2335:aaload          
    // 1429 2336:iload           31
    // 1430 2338:daload          
    // 1431 2339:dload           9
    // 1432 2341:dsub            
    // 1433 2342:dstore          21
                    r = 0.0D;
    // 1434 2344:dconst_0        
    // 1435 2345:dstore          13
                    for(int j = l; j <= n; j++)
    //*1436 2347:iload           30
    //*1437 2349:istore          32
    //*1438 2351:goto            2382
                        r += H[i][j] * H[j][n];
    // 1439 2354:dload           13
    // 1440 2356:aload_0         
    // 1441 2357:getfield        #86  <Field double[][] H>
    // 1442 2360:iload           31
    // 1443 2362:aaload          
    // 1444 2363:iload           32
    // 1445 2365:daload          
    // 1446 2366:aload_0         
    // 1447 2367:getfield        #86  <Field double[][] H>
    // 1448 2370:iload           32
    // 1449 2372:aaload          
    // 1450 2373:iload_2         
    // 1451 2374:daload          
    // 1452 2375:dmul            
    // 1453 2376:dadd            
    // 1454 2377:dstore          13

    // 1455 2379:iinc            32  1
    // 1456 2382:iload           32
    // 1457 2384:iload_2         
    // 1458 2385:icmple          2354
                    if(e[i] < 0.0D)
    //*1459 2388:aload_0         
    //*1460 2389:getfield        #37  <Field double[] e>
    //*1461 2392:iload           31
    //*1462 2394:daload          
    //*1463 2395:dconst_0        
    //*1464 2396:dcmpg           
    //*1465 2397:ifge            2411
                    {
                        z = w;
    // 1466 2400:dload           21
    // 1467 2402:dstore          17
                        s = r;
    // 1468 2404:dload           13
    // 1469 2406:dstore          15
                    } else
    //*1470 2408:goto            2694
                    {
                        l = i;
    // 1471 2411:iload           31
    // 1472 2413:istore          30
                        double t;
                        if(e[i] == 0.0D)
    //*1473 2415:aload_0         
    //*1474 2416:getfield        #37  <Field double[] e>
    //*1475 2419:iload           31
    //*1476 2421:daload          
    //*1477 2422:dconst_0        
    //*1478 2423:dcmpl           
    //*1479 2424:ifne            2473
                        {
                            if(w != 0.0D)
    //*1480 2427:dload           21
    //*1481 2429:dconst_0        
    //*1482 2430:dcmpl           
    //*1483 2431:ifeq            2452
                                H[i][n] = -r / w;
    // 1484 2434:aload_0         
    // 1485 2435:getfield        #86  <Field double[][] H>
    // 1486 2438:iload           31
    // 1487 2440:aaload          
    // 1488 2441:iload_2         
    // 1489 2442:dload           13
    // 1490 2444:dneg            
    // 1491 2445:dload           21
    // 1492 2447:ddiv            
    // 1493 2448:dastore         
                            else
    //*1494 2449:goto            2630
                                H[i][n] = -r / (eps * norm);
    // 1495 2452:aload_0         
    // 1496 2453:getfield        #86  <Field double[][] H>
    // 1497 2456:iload           31
    // 1498 2458:aaload          
    // 1499 2459:iload_2         
    // 1500 2460:dload           13
    // 1501 2462:dneg            
    // 1502 2463:dload           5
    // 1503 2465:dload           27
    // 1504 2467:dmul            
    // 1505 2468:ddiv            
    // 1506 2469:dastore         
                        } else
    //*1507 2470:goto            2630
                        {
                            double x = H[i][i + 1];
    // 1508 2473:aload_0         
    // 1509 2474:getfield        #86  <Field double[][] H>
    // 1510 2477:iload           31
    // 1511 2479:aaload          
    // 1512 2480:iload           31
    // 1513 2482:iconst_1        
    // 1514 2483:iadd            
    // 1515 2484:daload          
    // 1516 2485:dstore          23
                            double y = H[i + 1][i];
    // 1517 2487:aload_0         
    // 1518 2488:getfield        #86  <Field double[][] H>
    // 1519 2491:iload           31
    // 1520 2493:iconst_1        
    // 1521 2494:iadd            
    // 1522 2495:aaload          
    // 1523 2496:iload           31
    // 1524 2498:daload          
    // 1525 2499:dstore          25
                            q = (d[i] - p) * (d[i] - p) + e[i] * e[i];
    // 1526 2501:aload_0         
    // 1527 2502:getfield        #25  <Field double[] d>
    // 1528 2505:iload           31
    // 1529 2507:daload          
    // 1530 2508:dload           9
    // 1531 2510:dsub            
    // 1532 2511:aload_0         
    // 1533 2512:getfield        #25  <Field double[] d>
    // 1534 2515:iload           31
    // 1535 2517:daload          
    // 1536 2518:dload           9
    // 1537 2520:dsub            
    // 1538 2521:dmul            
    // 1539 2522:aload_0         
    // 1540 2523:getfield        #37  <Field double[] e>
    // 1541 2526:iload           31
    // 1542 2528:daload          
    // 1543 2529:aload_0         
    // 1544 2530:getfield        #37  <Field double[] e>
    // 1545 2533:iload           31
    // 1546 2535:daload          
    // 1547 2536:dmul            
    // 1548 2537:dadd            
    // 1549 2538:dstore          11
                            t = (x * s - z * r) / q;
    // 1550 2540:dload           23
    // 1551 2542:dload           15
    // 1552 2544:dmul            
    // 1553 2545:dload           17
    // 1554 2547:dload           13
    // 1555 2549:dmul            
    // 1556 2550:dsub            
    // 1557 2551:dload           11
    // 1558 2553:ddiv            
    // 1559 2554:dstore          19
                            H[i][n] = t;
    // 1560 2556:aload_0         
    // 1561 2557:getfield        #86  <Field double[][] H>
    // 1562 2560:iload           31
    // 1563 2562:aaload          
    // 1564 2563:iload_2         
    // 1565 2564:dload           19
    // 1566 2566:dastore         
                            if(Math.abs(x) > Math.abs(z))
    //*1567 2567:dload           23
    //*1568 2569:invokestatic    #35  <Method double Math.abs(double)>
    //*1569 2572:dload           17
    //*1570 2574:invokestatic    #35  <Method double Math.abs(double)>
    //*1571 2577:dcmpl           
    //*1572 2578:ifle            2607
                                H[i + 1][n] = (-r - w * t) / x;
    // 1573 2581:aload_0         
    // 1574 2582:getfield        #86  <Field double[][] H>
    // 1575 2585:iload           31
    // 1576 2587:iconst_1        
    // 1577 2588:iadd            
    // 1578 2589:aaload          
    // 1579 2590:iload_2         
    // 1580 2591:dload           13
    // 1581 2593:dneg            
    // 1582 2594:dload           21
    // 1583 2596:dload           19
    // 1584 2598:dmul            
    // 1585 2599:dsub            
    // 1586 2600:dload           23
    // 1587 2602:ddiv            
    // 1588 2603:dastore         
                            else
    //*1589 2604:goto            2630
                                H[i + 1][n] = (-s - y * t) / z;
    // 1590 2607:aload_0         
    // 1591 2608:getfield        #86  <Field double[][] H>
    // 1592 2611:iload           31
    // 1593 2613:iconst_1        
    // 1594 2614:iadd            
    // 1595 2615:aaload          
    // 1596 2616:iload_2         
    // 1597 2617:dload           15
    // 1598 2619:dneg            
    // 1599 2620:dload           25
    // 1600 2622:dload           19
    // 1601 2624:dmul            
    // 1602 2625:dsub            
    // 1603 2626:dload           17
    // 1604 2628:ddiv            
    // 1605 2629:dastore         
                        }
                        t = Math.abs(H[i][n]);
    // 1606 2630:aload_0         
    // 1607 2631:getfield        #86  <Field double[][] H>
    // 1608 2634:iload           31
    // 1609 2636:aaload          
    // 1610 2637:iload_2         
    // 1611 2638:daload          
    // 1612 2639:invokestatic    #35  <Method double Math.abs(double)>
    // 1613 2642:dstore          19
                        if(eps * t * t > 1.0D)
    //*1614 2644:dload           5
    //*1615 2646:dload           19
    //*1616 2648:dmul            
    //*1617 2649:dload           19
    //*1618 2651:dmul            
    //*1619 2652:dconst_1        
    //*1620 2653:dcmpl           
    //*1621 2654:ifle            2694
                        {
                            for(int j = i; j <= n; j++)
    //*1622 2657:iload           31
    //*1623 2659:istore          32
    //*1624 2661:goto            2688
                                H[j][n] = H[j][n] / t;
    // 1625 2664:aload_0         
    // 1626 2665:getfield        #86  <Field double[][] H>
    // 1627 2668:iload           32
    // 1628 2670:aaload          
    // 1629 2671:iload_2         
    // 1630 2672:aload_0         
    // 1631 2673:getfield        #86  <Field double[][] H>
    // 1632 2676:iload           32
    // 1633 2678:aaload          
    // 1634 2679:iload_2         
    // 1635 2680:daload          
    // 1636 2681:dload           19
    // 1637 2683:ddiv            
    // 1638 2684:dastore         

    // 1639 2685:iinc            32  1
    // 1640 2688:iload           32
    // 1641 2690:iload_2         
    // 1642 2691:icmple          2664
                        }
                    }
                }

    // 1643 2694:iinc            31  -1
    // 1644 2697:iload           31
    // 1645 2699:ifge            2329
            } else
    //*1646 2702:goto            3606
            if(q < 0.0D)
    //*1647 2705:dload           11
    //*1648 2707:dconst_0        
    //*1649 2708:dcmpg           
    //*1650 2709:ifge            3606
            {
                int l = n - 1;
    // 1651 2712:iload_2         
    // 1652 2713:iconst_1        
    // 1653 2714:isub            
    // 1654 2715:istore          30
                if(Math.abs(H[n][n - 1]) > Math.abs(H[n - 1][n]))
    //*1655 2717:aload_0         
    //*1656 2718:getfield        #86  <Field double[][] H>
    //*1657 2721:iload_2         
    //*1658 2722:aaload          
    //*1659 2723:iload_2         
    //*1660 2724:iconst_1        
    //*1661 2725:isub            
    //*1662 2726:daload          
    //*1663 2727:invokestatic    #35  <Method double Math.abs(double)>
    //*1664 2730:aload_0         
    //*1665 2731:getfield        #86  <Field double[][] H>
    //*1666 2734:iload_2         
    //*1667 2735:iconst_1        
    //*1668 2736:isub            
    //*1669 2737:aaload          
    //*1670 2738:iload_2         
    //*1671 2739:daload          
    //*1672 2740:invokestatic    #35  <Method double Math.abs(double)>
    //*1673 2743:dcmpl           
    //*1674 2744:ifle            2808
                {
                    H[n - 1][n - 1] = q / H[n][n - 1];
    // 1675 2747:aload_0         
    // 1676 2748:getfield        #86  <Field double[][] H>
    // 1677 2751:iload_2         
    // 1678 2752:iconst_1        
    // 1679 2753:isub            
    // 1680 2754:aaload          
    // 1681 2755:iload_2         
    // 1682 2756:iconst_1        
    // 1683 2757:isub            
    // 1684 2758:dload           11
    // 1685 2760:aload_0         
    // 1686 2761:getfield        #86  <Field double[][] H>
    // 1687 2764:iload_2         
    // 1688 2765:aaload          
    // 1689 2766:iload_2         
    // 1690 2767:iconst_1        
    // 1691 2768:isub            
    // 1692 2769:daload          
    // 1693 2770:ddiv            
    // 1694 2771:dastore         
                    H[n - 1][n] = -(H[n][n] - p) / H[n][n - 1];
    // 1695 2772:aload_0         
    // 1696 2773:getfield        #86  <Field double[][] H>
    // 1697 2776:iload_2         
    // 1698 2777:iconst_1        
    // 1699 2778:isub            
    // 1700 2779:aaload          
    // 1701 2780:iload_2         
    // 1702 2781:aload_0         
    // 1703 2782:getfield        #86  <Field double[][] H>
    // 1704 2785:iload_2         
    // 1705 2786:aaload          
    // 1706 2787:iload_2         
    // 1707 2788:daload          
    // 1708 2789:dload           9
    // 1709 2791:dsub            
    // 1710 2792:dneg            
    // 1711 2793:aload_0         
    // 1712 2794:getfield        #86  <Field double[][] H>
    // 1713 2797:iload_2         
    // 1714 2798:aaload          
    // 1715 2799:iload_2         
    // 1716 2800:iconst_1        
    // 1717 2801:isub            
    // 1718 2802:daload          
    // 1719 2803:ddiv            
    // 1720 2804:dastore         
                } else
    //*1721 2805:goto            2871
                {
                    cdiv(0.0D, -H[n - 1][n], H[n - 1][n - 1] - p, q);
    // 1722 2808:aload_0         
    // 1723 2809:dconst_0        
    // 1724 2810:aload_0         
    // 1725 2811:getfield        #86  <Field double[][] H>
    // 1726 2814:iload_2         
    // 1727 2815:iconst_1        
    // 1728 2816:isub            
    // 1729 2817:aaload          
    // 1730 2818:iload_2         
    // 1731 2819:daload          
    // 1732 2820:dneg            
    // 1733 2821:aload_0         
    // 1734 2822:getfield        #86  <Field double[][] H>
    // 1735 2825:iload_2         
    // 1736 2826:iconst_1        
    // 1737 2827:isub            
    // 1738 2828:aaload          
    // 1739 2829:iload_2         
    // 1740 2830:iconst_1        
    // 1741 2831:isub            
    // 1742 2832:daload          
    // 1743 2833:dload           9
    // 1744 2835:dsub            
    // 1745 2836:dload           11
    // 1746 2838:invokespecial   #115 <Method void cdiv(double, double, double, double)>
                    H[n - 1][n - 1] = cdivr;
    // 1747 2841:aload_0         
    // 1748 2842:getfield        #86  <Field double[][] H>
    // 1749 2845:iload_2         
    // 1750 2846:iconst_1        
    // 1751 2847:isub            
    // 1752 2848:aaload          
    // 1753 2849:iload_2         
    // 1754 2850:iconst_1        
    // 1755 2851:isub            
    // 1756 2852:aload_0         
    // 1757 2853:getfield        #94  <Field double cdivr>
    // 1758 2856:dastore         
                    H[n - 1][n] = cdivi;
    // 1759 2857:aload_0         
    // 1760 2858:getfield        #86  <Field double[][] H>
    // 1761 2861:iload_2         
    // 1762 2862:iconst_1        
    // 1763 2863:isub            
    // 1764 2864:aaload          
    // 1765 2865:iload_2         
    // 1766 2866:aload_0         
    // 1767 2867:getfield        #96  <Field double cdivi>
    // 1768 2870:dastore         
                }
                H[n][n - 1] = 0.0D;
    // 1769 2871:aload_0         
    // 1770 2872:getfield        #86  <Field double[][] H>
    // 1771 2875:iload_2         
    // 1772 2876:aaload          
    // 1773 2877:iload_2         
    // 1774 2878:iconst_1        
    // 1775 2879:isub            
    // 1776 2880:dconst_0        
    // 1777 2881:dastore         
                H[n][n] = 1.0D;
    // 1778 2882:aload_0         
    // 1779 2883:getfield        #86  <Field double[][] H>
    // 1780 2886:iload_2         
    // 1781 2887:aaload          
    // 1782 2888:iload_2         
    // 1783 2889:dconst_1        
    // 1784 2890:dastore         
                for(int i = n - 2; i >= 0; i--)
    //*1785 2891:iload_2         
    //*1786 2892:iconst_2        
    //*1787 2893:isub            
    //*1788 2894:istore          31
    //*1789 2896:goto            3601
                {
                    double ra = 0.0D;
    // 1790 2899:dconst_0        
    // 1791 2900:dstore          32
                    double sa = 0.0D;
    // 1792 2902:dconst_0        
    // 1793 2903:dstore          34
                    for(int j = l; j <= n; j++)
    //*1794 2905:iload           30
    //*1795 2907:istore          40
    //*1796 2909:goto            2967
                    {
                        ra += H[i][j] * H[j][n - 1];
    // 1797 2912:dload           32
    // 1798 2914:aload_0         
    // 1799 2915:getfield        #86  <Field double[][] H>
    // 1800 2918:iload           31
    // 1801 2920:aaload          
    // 1802 2921:iload           40
    // 1803 2923:daload          
    // 1804 2924:aload_0         
    // 1805 2925:getfield        #86  <Field double[][] H>
    // 1806 2928:iload           40
    // 1807 2930:aaload          
    // 1808 2931:iload_2         
    // 1809 2932:iconst_1        
    // 1810 2933:isub            
    // 1811 2934:daload          
    // 1812 2935:dmul            
    // 1813 2936:dadd            
    // 1814 2937:dstore          32
                        sa += H[i][j] * H[j][n];
    // 1815 2939:dload           34
    // 1816 2941:aload_0         
    // 1817 2942:getfield        #86  <Field double[][] H>
    // 1818 2945:iload           31
    // 1819 2947:aaload          
    // 1820 2948:iload           40
    // 1821 2950:daload          
    // 1822 2951:aload_0         
    // 1823 2952:getfield        #86  <Field double[][] H>
    // 1824 2955:iload           40
    // 1825 2957:aaload          
    // 1826 2958:iload_2         
    // 1827 2959:daload          
    // 1828 2960:dmul            
    // 1829 2961:dadd            
    // 1830 2962:dstore          34
                    }

    // 1831 2964:iinc            40  1
    // 1832 2967:iload           40
    // 1833 2969:iload_2         
    // 1834 2970:icmple          2912
                    double w = H[i][i] - p;
    // 1835 2973:aload_0         
    // 1836 2974:getfield        #86  <Field double[][] H>
    // 1837 2977:iload           31
    // 1838 2979:aaload          
    // 1839 2980:iload           31
    // 1840 2982:daload          
    // 1841 2983:dload           9
    // 1842 2985:dsub            
    // 1843 2986:dstore          21
                    if(e[i] < 0.0D)
    //*1844 2988:aload_0         
    //*1845 2989:getfield        #37  <Field double[] e>
    //*1846 2992:iload           31
    //*1847 2994:daload          
    //*1848 2995:dconst_0        
    //*1849 2996:dcmpg           
    //*1850 2997:ifge            3015
                    {
                        z = w;
    // 1851 3000:dload           21
    // 1852 3002:dstore          17
                        r = ra;
    // 1853 3004:dload           32
    // 1854 3006:dstore          13
                        s = sa;
    // 1855 3008:dload           34
    // 1856 3010:dstore          15
                    } else
    //*1857 3012:goto            3598
                    {
                        l = i;
    // 1858 3015:iload           31
    // 1859 3017:istore          30
                        if(e[i] == 0.0D)
    //*1860 3019:aload_0         
    //*1861 3020:getfield        #37  <Field double[] e>
    //*1862 3023:iload           31
    //*1863 3025:daload          
    //*1864 3026:dconst_0        
    //*1865 3027:dcmpl           
    //*1866 3028:ifne            3076
                        {
                            cdiv(-ra, -sa, w, q);
    // 1867 3031:aload_0         
    // 1868 3032:dload           32
    // 1869 3034:dneg            
    // 1870 3035:dload           34
    // 1871 3037:dneg            
    // 1872 3038:dload           21
    // 1873 3040:dload           11
    // 1874 3042:invokespecial   #115 <Method void cdiv(double, double, double, double)>
                            H[i][n - 1] = cdivr;
    // 1875 3045:aload_0         
    // 1876 3046:getfield        #86  <Field double[][] H>
    // 1877 3049:iload           31
    // 1878 3051:aaload          
    // 1879 3052:iload_2         
    // 1880 3053:iconst_1        
    // 1881 3054:isub            
    // 1882 3055:aload_0         
    // 1883 3056:getfield        #94  <Field double cdivr>
    // 1884 3059:dastore         
                            H[i][n] = cdivi;
    // 1885 3060:aload_0         
    // 1886 3061:getfield        #86  <Field double[][] H>
    // 1887 3064:iload           31
    // 1888 3066:aaload          
    // 1889 3067:iload_2         
    // 1890 3068:aload_0         
    // 1891 3069:getfield        #96  <Field double cdivi>
    // 1892 3072:dastore         
                        } else
    //*1893 3073:goto            3492
                        {
                            double x = H[i][i + 1];
    // 1894 3076:aload_0         
    // 1895 3077:getfield        #86  <Field double[][] H>
    // 1896 3080:iload           31
    // 1897 3082:aaload          
    // 1898 3083:iload           31
    // 1899 3085:iconst_1        
    // 1900 3086:iadd            
    // 1901 3087:daload          
    // 1902 3088:dstore          23
                            double y = H[i + 1][i];
    // 1903 3090:aload_0         
    // 1904 3091:getfield        #86  <Field double[][] H>
    // 1905 3094:iload           31
    // 1906 3096:iconst_1        
    // 1907 3097:iadd            
    // 1908 3098:aaload          
    // 1909 3099:iload           31
    // 1910 3101:daload          
    // 1911 3102:dstore          25
                            double vr = ((d[i] - p) * (d[i] - p) + e[i] * e[i]) - q * q;
    // 1912 3104:aload_0         
    // 1913 3105:getfield        #25  <Field double[] d>
    // 1914 3108:iload           31
    // 1915 3110:daload          
    // 1916 3111:dload           9
    // 1917 3113:dsub            
    // 1918 3114:aload_0         
    // 1919 3115:getfield        #25  <Field double[] d>
    // 1920 3118:iload           31
    // 1921 3120:daload          
    // 1922 3121:dload           9
    // 1923 3123:dsub            
    // 1924 3124:dmul            
    // 1925 3125:aload_0         
    // 1926 3126:getfield        #37  <Field double[] e>
    // 1927 3129:iload           31
    // 1928 3131:daload          
    // 1929 3132:aload_0         
    // 1930 3133:getfield        #37  <Field double[] e>
    // 1931 3136:iload           31
    // 1932 3138:daload          
    // 1933 3139:dmul            
    // 1934 3140:dadd            
    // 1935 3141:dload           11
    // 1936 3143:dload           11
    // 1937 3145:dmul            
    // 1938 3146:dsub            
    // 1939 3147:dstore          36
                            double vi = (d[i] - p) * 2D * q;
    // 1940 3149:aload_0         
    // 1941 3150:getfield        #25  <Field double[] d>
    // 1942 3153:iload           31
    // 1943 3155:daload          
    // 1944 3156:dload           9
    // 1945 3158:dsub            
    // 1946 3159:ldc2w           #54  <Double 2D>
    // 1947 3162:dmul            
    // 1948 3163:dload           11
    // 1949 3165:dmul            
    // 1950 3166:dstore          38
                            if((vr == 0.0D) & (vi == 0.0D))
    //*1951 3168:dload           36
    //*1952 3170:dconst_0        
    //*1953 3171:dcmpl           
    //*1954 3172:ifne            3179
    //*1955 3175:iconst_1        
    //*1956 3176:goto            3180
    //*1957 3179:iconst_0        
    //*1958 3180:dload           38
    //*1959 3182:dconst_0        
    //*1960 3183:dcmpl           
    //*1961 3184:ifne            3191
    //*1962 3187:iconst_1        
    //*1963 3188:goto            3192
    //*1964 3191:iconst_0        
    //*1965 3192:iand            
    //*1966 3193:ifeq            3233
                                vr = eps * norm * (Math.abs(w) + Math.abs(q) + Math.abs(x) + Math.abs(y) + Math.abs(z));
    // 1967 3196:dload           5
    // 1968 3198:dload           27
    // 1969 3200:dmul            
    // 1970 3201:dload           21
    // 1971 3203:invokestatic    #35  <Method double Math.abs(double)>
    // 1972 3206:dload           11
    // 1973 3208:invokestatic    #35  <Method double Math.abs(double)>
    // 1974 3211:dadd            
    // 1975 3212:dload           23
    // 1976 3214:invokestatic    #35  <Method double Math.abs(double)>
    // 1977 3217:dadd            
    // 1978 3218:dload           25
    // 1979 3220:invokestatic    #35  <Method double Math.abs(double)>
    // 1980 3223:dadd            
    // 1981 3224:dload           17
    // 1982 3226:invokestatic    #35  <Method double Math.abs(double)>
    // 1983 3229:dadd            
    // 1984 3230:dmul            
    // 1985 3231:dstore          36
                            cdiv((x * r - z * ra) + q * sa, x * s - z * sa - q * ra, vr, vi);
    // 1986 3233:aload_0         
    // 1987 3234:dload           23
    // 1988 3236:dload           13
    // 1989 3238:dmul            
    // 1990 3239:dload           17
    // 1991 3241:dload           32
    // 1992 3243:dmul            
    // 1993 3244:dsub            
    // 1994 3245:dload           11
    // 1995 3247:dload           34
    // 1996 3249:dmul            
    // 1997 3250:dadd            
    // 1998 3251:dload           23
    // 1999 3253:dload           15
    // 2000 3255:dmul            
    // 2001 3256:dload           17
    // 2002 3258:dload           34
    // 2003 3260:dmul            
    // 2004 3261:dsub            
    // 2005 3262:dload           11
    // 2006 3264:dload           32
    // 2007 3266:dmul            
    // 2008 3267:dsub            
    // 2009 3268:dload           36
    // 2010 3270:dload           38
    // 2011 3272:invokespecial   #115 <Method void cdiv(double, double, double, double)>
                            H[i][n - 1] = cdivr;
    // 2012 3275:aload_0         
    // 2013 3276:getfield        #86  <Field double[][] H>
    // 2014 3279:iload           31
    // 2015 3281:aaload          
    // 2016 3282:iload_2         
    // 2017 3283:iconst_1        
    // 2018 3284:isub            
    // 2019 3285:aload_0         
    // 2020 3286:getfield        #94  <Field double cdivr>
    // 2021 3289:dastore         
                            H[i][n] = cdivi;
    // 2022 3290:aload_0         
    // 2023 3291:getfield        #86  <Field double[][] H>
    // 2024 3294:iload           31
    // 2025 3296:aaload          
    // 2026 3297:iload_2         
    // 2027 3298:aload_0         
    // 2028 3299:getfield        #96  <Field double cdivi>
    // 2029 3302:dastore         
                            if(Math.abs(x) > Math.abs(z) + Math.abs(q))
    //*2030 3303:dload           23
    //*2031 3305:invokestatic    #35  <Method double Math.abs(double)>
    //*2032 3308:dload           17
    //*2033 3310:invokestatic    #35  <Method double Math.abs(double)>
    //*2034 3313:dload           11
    //*2035 3315:invokestatic    #35  <Method double Math.abs(double)>
    //*2036 3318:dadd            
    //*2037 3319:dcmpl           
    //*2038 3320:ifle            3418
                            {
                                H[i + 1][n - 1] = ((-ra - w * H[i][n - 1]) + q * H[i][n]) / x;
    // 2039 3323:aload_0         
    // 2040 3324:getfield        #86  <Field double[][] H>
    // 2041 3327:iload           31
    // 2042 3329:iconst_1        
    // 2043 3330:iadd            
    // 2044 3331:aaload          
    // 2045 3332:iload_2         
    // 2046 3333:iconst_1        
    // 2047 3334:isub            
    // 2048 3335:dload           32
    // 2049 3337:dneg            
    // 2050 3338:dload           21
    // 2051 3340:aload_0         
    // 2052 3341:getfield        #86  <Field double[][] H>
    // 2053 3344:iload           31
    // 2054 3346:aaload          
    // 2055 3347:iload_2         
    // 2056 3348:iconst_1        
    // 2057 3349:isub            
    // 2058 3350:daload          
    // 2059 3351:dmul            
    // 2060 3352:dsub            
    // 2061 3353:dload           11
    // 2062 3355:aload_0         
    // 2063 3356:getfield        #86  <Field double[][] H>
    // 2064 3359:iload           31
    // 2065 3361:aaload          
    // 2066 3362:iload_2         
    // 2067 3363:daload          
    // 2068 3364:dmul            
    // 2069 3365:dadd            
    // 2070 3366:dload           23
    // 2071 3368:ddiv            
    // 2072 3369:dastore         
                                H[i + 1][n] = (-sa - w * H[i][n] - q * H[i][n - 1]) / x;
    // 2073 3370:aload_0         
    // 2074 3371:getfield        #86  <Field double[][] H>
    // 2075 3374:iload           31
    // 2076 3376:iconst_1        
    // 2077 3377:iadd            
    // 2078 3378:aaload          
    // 2079 3379:iload_2         
    // 2080 3380:dload           34
    // 2081 3382:dneg            
    // 2082 3383:dload           21
    // 2083 3385:aload_0         
    // 2084 3386:getfield        #86  <Field double[][] H>
    // 2085 3389:iload           31
    // 2086 3391:aaload          
    // 2087 3392:iload_2         
    // 2088 3393:daload          
    // 2089 3394:dmul            
    // 2090 3395:dsub            
    // 2091 3396:dload           11
    // 2092 3398:aload_0         
    // 2093 3399:getfield        #86  <Field double[][] H>
    // 2094 3402:iload           31
    // 2095 3404:aaload          
    // 2096 3405:iload_2         
    // 2097 3406:iconst_1        
    // 2098 3407:isub            
    // 2099 3408:daload          
    // 2100 3409:dmul            
    // 2101 3410:dsub            
    // 2102 3411:dload           23
    // 2103 3413:ddiv            
    // 2104 3414:dastore         
                            } else
    //*2105 3415:goto            3492
                            {
                                cdiv(-r - y * H[i][n - 1], -s - y * H[i][n], z, q);
    // 2106 3418:aload_0         
    // 2107 3419:dload           13
    // 2108 3421:dneg            
    // 2109 3422:dload           25
    // 2110 3424:aload_0         
    // 2111 3425:getfield        #86  <Field double[][] H>
    // 2112 3428:iload           31
    // 2113 3430:aaload          
    // 2114 3431:iload_2         
    // 2115 3432:iconst_1        
    // 2116 3433:isub            
    // 2117 3434:daload          
    // 2118 3435:dmul            
    // 2119 3436:dsub            
    // 2120 3437:dload           15
    // 2121 3439:dneg            
    // 2122 3440:dload           25
    // 2123 3442:aload_0         
    // 2124 3443:getfield        #86  <Field double[][] H>
    // 2125 3446:iload           31
    // 2126 3448:aaload          
    // 2127 3449:iload_2         
    // 2128 3450:daload          
    // 2129 3451:dmul            
    // 2130 3452:dsub            
    // 2131 3453:dload           17
    // 2132 3455:dload           11
    // 2133 3457:invokespecial   #115 <Method void cdiv(double, double, double, double)>
                                H[i + 1][n - 1] = cdivr;
    // 2134 3460:aload_0         
    // 2135 3461:getfield        #86  <Field double[][] H>
    // 2136 3464:iload           31
    // 2137 3466:iconst_1        
    // 2138 3467:iadd            
    // 2139 3468:aaload          
    // 2140 3469:iload_2         
    // 2141 3470:iconst_1        
    // 2142 3471:isub            
    // 2143 3472:aload_0         
    // 2144 3473:getfield        #94  <Field double cdivr>
    // 2145 3476:dastore         
                                H[i + 1][n] = cdivi;
    // 2146 3477:aload_0         
    // 2147 3478:getfield        #86  <Field double[][] H>
    // 2148 3481:iload           31
    // 2149 3483:iconst_1        
    // 2150 3484:iadd            
    // 2151 3485:aaload          
    // 2152 3486:iload_2         
    // 2153 3487:aload_0         
    // 2154 3488:getfield        #96  <Field double cdivi>
    // 2155 3491:dastore         
                            }
                        }
                        double t = Math.max(Math.abs(H[i][n - 1]), Math.abs(H[i][n]));
    // 2156 3492:aload_0         
    // 2157 3493:getfield        #86  <Field double[][] H>
    // 2158 3496:iload           31
    // 2159 3498:aaload          
    // 2160 3499:iload_2         
    // 2161 3500:iconst_1        
    // 2162 3501:isub            
    // 2163 3502:daload          
    // 2164 3503:invokestatic    #35  <Method double Math.abs(double)>
    // 2165 3506:aload_0         
    // 2166 3507:getfield        #86  <Field double[][] H>
    // 2167 3510:iload           31
    // 2168 3512:aaload          
    // 2169 3513:iload_2         
    // 2170 3514:daload          
    // 2171 3515:invokestatic    #35  <Method double Math.abs(double)>
    // 2172 3518:invokestatic    #64  <Method double Math.max(double, double)>
    // 2173 3521:dstore          19
                        if(eps * t * t > 1.0D)
    //*2174 3523:dload           5
    //*2175 3525:dload           19
    //*2176 3527:dmul            
    //*2177 3528:dload           19
    //*2178 3530:dmul            
    //*2179 3531:dconst_1        
    //*2180 3532:dcmpl           
    //*2181 3533:ifle            3598
                        {
                            for(int j = i; j <= n; j++)
    //*2182 3536:iload           31
    //*2183 3538:istore          40
    //*2184 3540:goto            3592
                            {
                                H[j][n - 1] = H[j][n - 1] / t;
    // 2185 3543:aload_0         
    // 2186 3544:getfield        #86  <Field double[][] H>
    // 2187 3547:iload           40
    // 2188 3549:aaload          
    // 2189 3550:iload_2         
    // 2190 3551:iconst_1        
    // 2191 3552:isub            
    // 2192 3553:aload_0         
    // 2193 3554:getfield        #86  <Field double[][] H>
    // 2194 3557:iload           40
    // 2195 3559:aaload          
    // 2196 3560:iload_2         
    // 2197 3561:iconst_1        
    // 2198 3562:isub            
    // 2199 3563:daload          
    // 2200 3564:dload           19
    // 2201 3566:ddiv            
    // 2202 3567:dastore         
                                H[j][n] = H[j][n] / t;
    // 2203 3568:aload_0         
    // 2204 3569:getfield        #86  <Field double[][] H>
    // 2205 3572:iload           40
    // 2206 3574:aaload          
    // 2207 3575:iload_2         
    // 2208 3576:aload_0         
    // 2209 3577:getfield        #86  <Field double[][] H>
    // 2210 3580:iload           40
    // 2211 3582:aaload          
    // 2212 3583:iload_2         
    // 2213 3584:daload          
    // 2214 3585:dload           19
    // 2215 3587:ddiv            
    // 2216 3588:dastore         
                            }

    // 2217 3589:iinc            40  1
    // 2218 3592:iload           40
    // 2219 3594:iload_2         
    // 2220 3595:icmple          3543
                        }
                    }
                }

    // 2221 3598:iinc            31  -1
    // 2222 3601:iload           31
    // 2223 3603:ifge            2899
            }
        }

    // 2224 3606:iinc            2  -1
    // 2225 3609:iload_2         
    // 2226 3610:ifge            2286
        for(int i = 0; i < nn; i++)
    //*2227 3613:iconst_0        
    //*2228 3614:istore          30
    //*2229 3616:goto            3685
            if((i < low) | (i > high))
    //*2230 3619:iload           30
    //*2231 3621:iload_3         
    //*2232 3622:icmpge          3629
    //*2233 3625:iconst_1        
    //*2234 3626:goto            3630
    //*2235 3629:iconst_0        
    //*2236 3630:iload           30
    //*2237 3632:iload           4
    //*2238 3634:icmple          3641
    //*2239 3637:iconst_1        
    //*2240 3638:goto            3642
    //*2241 3641:iconst_0        
    //*2242 3642:ior             
    //*2243 3643:ifeq            3682
            {
                for(int j = i; j < nn; j++)
    //*2244 3646:iload           30
    //*2245 3648:istore          31
    //*2246 3650:goto            3676
                    V[i][j] = H[i][j];
    // 2247 3653:aload_0         
    // 2248 3654:getfield        #27  <Field double[][] V>
    // 2249 3657:iload           30
    // 2250 3659:aaload          
    // 2251 3660:iload           31
    // 2252 3662:aload_0         
    // 2253 3663:getfield        #86  <Field double[][] H>
    // 2254 3666:iload           30
    // 2255 3668:aaload          
    // 2256 3669:iload           31
    // 2257 3671:daload          
    // 2258 3672:dastore         

    // 2259 3673:iinc            31  1
    // 2260 3676:iload           31
    // 2261 3678:iload_1         
    // 2262 3679:icmplt          3653
            }

    // 2263 3682:iinc            30  1
    // 2264 3685:iload           30
    // 2265 3687:iload_1         
    // 2266 3688:icmplt          3619
        for(int j = nn - 1; j >= low; j--)
    //*2267 3691:iload_1         
    //*2268 3692:iconst_1        
    //*2269 3693:isub            
    //*2270 3694:istore          30
    //*2271 3696:goto            3780
        {
            for(int i = low; i <= high; i++)
    //*2272 3699:iload_3         
    //*2273 3700:istore          31
    //*2274 3702:goto            3770
            {
                z = 0.0D;
    // 2275 3705:dconst_0        
    // 2276 3706:dstore          17
                for(int k = low; k <= Math.min(j, high); k++)
    //*2277 3708:iload_3         
    //*2278 3709:istore          32
    //*2279 3711:goto            3743
                    z += V[i][k] * H[k][j];
    // 2280 3714:dload           17
    // 2281 3716:aload_0         
    // 2282 3717:getfield        #27  <Field double[][] V>
    // 2283 3720:iload           31
    // 2284 3722:aaload          
    // 2285 3723:iload           32
    // 2286 3725:daload          
    // 2287 3726:aload_0         
    // 2288 3727:getfield        #86  <Field double[][] H>
    // 2289 3730:iload           32
    // 2290 3732:aaload          
    // 2291 3733:iload           30
    // 2292 3735:daload          
    // 2293 3736:dmul            
    // 2294 3737:dadd            
    // 2295 3738:dstore          17

    // 2296 3740:iinc            32  1
    // 2297 3743:iload           32
    // 2298 3745:iload           30
    // 2299 3747:iload           4
    // 2300 3749:invokestatic    #113 <Method int Math.min(int, int)>
    // 2301 3752:icmple          3714
                V[i][j] = z;
    // 2302 3755:aload_0         
    // 2303 3756:getfield        #27  <Field double[][] V>
    // 2304 3759:iload           31
    // 2305 3761:aaload          
    // 2306 3762:iload           30
    // 2307 3764:dload           17
    // 2308 3766:dastore         
            }

    // 2309 3767:iinc            31  1
    // 2310 3770:iload           31
    // 2311 3772:iload           4
    // 2312 3774:icmple          3705
        }

    // 2313 3777:iinc            30  -1
    // 2314 3780:iload           30
    // 2315 3782:iload_3         
    // 2316 3783:icmpge          3699
    // 2317 3786:return          
    }

    public EigenvalueDecomposition(Matrix Arg)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #133 <Method void Object()>
        double A[][] = Arg.getArray();
    //    2    4:aload_1         
    //    3    5:invokevirtual   #139 <Method double[][] Matrix.getArray()>
    //    4    8:astore_2        
        n = Arg.getColumnDimension();
    //    5    9:aload_0         
    //    6   10:aload_1         
    //    7   11:invokevirtual   #143 <Method int Matrix.getColumnDimension()>
    //    8   14:putfield        #29  <Field int n>
        V = new double[n][n];
    //    9   17:aload_0         
    //   10   18:aload_0         
    //   11   19:getfield        #29  <Field int n>
    //   12   22:aload_0         
    //   13   23:getfield        #29  <Field int n>
    //   14   26:multianewarray  double[][]
    //   15   30:putfield        #27  <Field double[][] V>
        d = new double[n];
    //   16   33:aload_0         
    //   17   34:aload_0         
    //   18   35:getfield        #29  <Field int n>
    //   19   38:newarray        double[]
    //   20   40:putfield        #25  <Field double[] d>
        e = new double[n];
    //   21   43:aload_0         
    //   22   44:aload_0         
    //   23   45:getfield        #29  <Field int n>
    //   24   48:newarray        double[]
    //   25   50:putfield        #37  <Field double[] e>
        issymmetric = true;
    //   26   53:aload_0         
    //   27   54:iconst_1        
    //   28   55:putfield        #146 <Field boolean issymmetric>
        for(int j = 0; (j < n) & issymmetric; j++)
    //*  29   58:iconst_0        
    //*  30   59:istore_3        
    //*  31   60:goto            122
        {
            for(int i = 0; (i < n) & issymmetric; i++)
    //*  32   63:iconst_0        
    //*  33   64:istore          4
    //*  34   66:goto            97
                issymmetric = A[i][j] == A[j][i];
    //   35   69:aload_0         
    //   36   70:aload_2         
    //   37   71:iload           4
    //   38   73:aaload          
    //   39   74:iload_3         
    //   40   75:daload          
    //   41   76:aload_2         
    //   42   77:iload_3         
    //   43   78:aaload          
    //   44   79:iload           4
    //   45   81:daload          
    //   46   82:dcmpl           
    //   47   83:ifne            90
    //   48   86:iconst_1        
    //   49   87:goto            91
    //   50   90:iconst_0        
    //   51   91:putfield        #146 <Field boolean issymmetric>

    //   52   94:iinc            4  1
    //   53   97:iload           4
    //   54   99:aload_0         
    //   55  100:getfield        #29  <Field int n>
    //   56  103:icmpge          110
    //   57  106:iconst_1        
    //   58  107:goto            111
    //   59  110:iconst_0        
    //   60  111:aload_0         
    //   61  112:getfield        #146 <Field boolean issymmetric>
    //   62  115:iand            
    //   63  116:ifne            69
        }

    //   64  119:iinc            3  1
    //   65  122:iload_3         
    //   66  123:aload_0         
    //   67  124:getfield        #29  <Field int n>
    //   68  127:icmpge          134
    //   69  130:iconst_1        
    //   70  131:goto            135
    //   71  134:iconst_0        
    //   72  135:aload_0         
    //   73  136:getfield        #146 <Field boolean issymmetric>
    //   74  139:iand            
    //   75  140:ifne            63
        if(issymmetric)
    //*  76  143:aload_0         
    //*  77  144:getfield        #146 <Field boolean issymmetric>
    //*  78  147:ifeq            210
        {
            for(int i = 0; i < n; i++)
    //*  79  150:iconst_0        
    //*  80  151:istore_3        
    //*  81  152:goto            191
            {
                for(int j = 0; j < n; j++)
    //*  82  155:iconst_0        
    //*  83  156:istore          4
    //*  84  158:goto            179
                    V[i][j] = A[i][j];
    //   85  161:aload_0         
    //   86  162:getfield        #27  <Field double[][] V>
    //   87  165:iload_3         
    //   88  166:aaload          
    //   89  167:iload           4
    //   90  169:aload_2         
    //   91  170:iload_3         
    //   92  171:aaload          
    //   93  172:iload           4
    //   94  174:daload          
    //   95  175:dastore         

    //   96  176:iinc            4  1
    //   97  179:iload           4
    //   98  181:aload_0         
    //   99  182:getfield        #29  <Field int n>
    //  100  185:icmplt          161
            }

    //  101  188:iinc            3  1
    //  102  191:iload_3         
    //  103  192:aload_0         
    //  104  193:getfield        #29  <Field int n>
    //  105  196:icmplt          155
            tred2();
    //  106  199:aload_0         
    //  107  200:invokespecial   #148 <Method void tred2()>
            tql2();
    //  108  203:aload_0         
    //  109  204:invokespecial   #150 <Method void tql2()>
        } else
    //* 110  207:goto            293
        {
            H = new double[n][n];
    //  111  210:aload_0         
    //  112  211:aload_0         
    //  113  212:getfield        #29  <Field int n>
    //  114  215:aload_0         
    //  115  216:getfield        #29  <Field int n>
    //  116  219:multianewarray  double[][]
    //  117  223:putfield        #86  <Field double[][] H>
            ort = new double[n];
    //  118  226:aload_0         
    //  119  227:aload_0         
    //  120  228:getfield        #29  <Field int n>
    //  121  231:newarray        double[]
    //  122  233:putfield        #88  <Field double[] ort>
            for(int j = 0; j < n; j++)
    //* 123  236:iconst_0        
    //* 124  237:istore_3        
    //* 125  238:goto            277
            {
                for(int i = 0; i < n; i++)
    //* 126  241:iconst_0        
    //* 127  242:istore          4
    //* 128  244:goto            265
                    H[i][j] = A[i][j];
    //  129  247:aload_0         
    //  130  248:getfield        #86  <Field double[][] H>
    //  131  251:iload           4
    //  132  253:aaload          
    //  133  254:iload_3         
    //  134  255:aload_2         
    //  135  256:iload           4
    //  136  258:aaload          
    //  137  259:iload_3         
    //  138  260:daload          
    //  139  261:dastore         

    //  140  262:iinc            4  1
    //  141  265:iload           4
    //  142  267:aload_0         
    //  143  268:getfield        #29  <Field int n>
    //  144  271:icmplt          247
            }

    //  145  274:iinc            3  1
    //  146  277:iload_3         
    //  147  278:aload_0         
    //  148  279:getfield        #29  <Field int n>
    //  149  282:icmplt          241
            orthes();
    //  150  285:aload_0         
    //  151  286:invokespecial   #152 <Method void orthes()>
            hqr2();
    //  152  289:aload_0         
    //  153  290:invokespecial   #154 <Method void hqr2()>
        }
    //  154  293:return          
    }

    public Matrix getV()
    {
        return new Matrix(V, n, n);
    //    0    0:new             #135 <Class Matrix>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:getfield        #27  <Field double[][] V>
    //    4    8:aload_0         
    //    5    9:getfield        #29  <Field int n>
    //    6   12:aload_0         
    //    7   13:getfield        #29  <Field int n>
    //    8   16:invokespecial   #162 <Method void Matrix(double[][], int, int)>
    //    9   19:areturn         
    }

    public double[] getRealEigenvalues()
    {
        return d;
    //    0    0:aload_0         
    //    1    1:getfield        #25  <Field double[] d>
    //    2    4:areturn         
    }

    public double[] getImagEigenvalues()
    {
        return e;
    //    0    0:aload_0         
    //    1    1:getfield        #37  <Field double[] e>
    //    2    4:areturn         
    }

    public Matrix getD()
    {
        Matrix X = new Matrix(n, n);
    //    0    0:new             #135 <Class Matrix>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:getfield        #29  <Field int n>
    //    4    8:aload_0         
    //    5    9:getfield        #29  <Field int n>
    //    6   12:invokespecial   #169 <Method void Matrix(int, int)>
    //    7   15:astore_1        
        double D[][] = X.getArray();
    //    8   16:aload_1         
    //    9   17:invokevirtual   #139 <Method double[][] Matrix.getArray()>
    //   10   20:astore_2        
        for(int i = 0; i < n; i++)
    //*  11   21:iconst_0        
    //*  12   22:istore_3        
    //*  13   23:goto            116
        {
            for(int j = 0; j < n; j++)
    //*  14   26:iconst_0        
    //*  15   27:istore          4
    //*  16   29:goto            42
                D[i][j] = 0.0D;
    //   17   32:aload_2         
    //   18   33:iload_3         
    //   19   34:aaload          
    //   20   35:iload           4
    //   21   37:dconst_0        
    //   22   38:dastore         

    //   23   39:iinc            4  1
    //   24   42:iload           4
    //   25   44:aload_0         
    //   26   45:getfield        #29  <Field int n>
    //   27   48:icmplt          32
            D[i][i] = d[i];
    //   28   51:aload_2         
    //   29   52:iload_3         
    //   30   53:aaload          
    //   31   54:iload_3         
    //   32   55:aload_0         
    //   33   56:getfield        #25  <Field double[] d>
    //   34   59:iload_3         
    //   35   60:daload          
    //   36   61:dastore         
            if(e[i] > 0.0D)
    //*  37   62:aload_0         
    //*  38   63:getfield        #37  <Field double[] e>
    //*  39   66:iload_3         
    //*  40   67:daload          
    //*  41   68:dconst_0        
    //*  42   69:dcmpl           
    //*  43   70:ifle            89
                D[i][i + 1] = e[i];
    //   44   73:aload_2         
    //   45   74:iload_3         
    //   46   75:aaload          
    //   47   76:iload_3         
    //   48   77:iconst_1        
    //   49   78:iadd            
    //   50   79:aload_0         
    //   51   80:getfield        #37  <Field double[] e>
    //   52   83:iload_3         
    //   53   84:daload          
    //   54   85:dastore         
            else
    //*  55   86:goto            113
            if(e[i] < 0.0D)
    //*  56   89:aload_0         
    //*  57   90:getfield        #37  <Field double[] e>
    //*  58   93:iload_3         
    //*  59   94:daload          
    //*  60   95:dconst_0        
    //*  61   96:dcmpg           
    //*  62   97:ifge            113
                D[i][i - 1] = e[i];
    //   63  100:aload_2         
    //   64  101:iload_3         
    //   65  102:aaload          
    //   66  103:iload_3         
    //   67  104:iconst_1        
    //   68  105:isub            
    //   69  106:aload_0         
    //   70  107:getfield        #37  <Field double[] e>
    //   71  110:iload_3         
    //   72  111:daload          
    //   73  112:dastore         
        }

    //   74  113:iinc            3  1
    //   75  116:iload_3         
    //   76  117:aload_0         
    //   77  118:getfield        #29  <Field int n>
    //   78  121:icmplt          26
        return X;
    //   79  124:aload_1         
    //   80  125:areturn         
    }

    private int n;
    private boolean issymmetric;
    private double d[];
    private double e[];
    private double V[][];
    private double H[][];
    private double ort[];
    private transient double cdivr;
    private transient double cdivi;
}
