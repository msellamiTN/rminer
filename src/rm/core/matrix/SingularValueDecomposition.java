// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   SingularValueDecomposition.java

package rm.core.matrix;

import java.io.Serializable;

// Referenced classes of package rm.core.matrix:
//            Matrix, Maths

public class SingularValueDecomposition
    implements Serializable
{

    public SingularValueDecomposition(Matrix Arg)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #20  <Method void Object()>
        double A[][] = Arg.getArrayCopy();
    //    2    4:aload_1         
    //    3    5:invokevirtual   #26  <Method double[][] Matrix.getArrayCopy()>
    //    4    8:astore_2        
        m = Arg.getRowDimension();
    //    5    9:aload_0         
    //    6   10:aload_1         
    //    7   11:invokevirtual   #30  <Method int Matrix.getRowDimension()>
    //    8   14:putfield        #32  <Field int m>
        n = Arg.getColumnDimension();
    //    9   17:aload_0         
    //   10   18:aload_1         
    //   11   19:invokevirtual   #35  <Method int Matrix.getColumnDimension()>
    //   12   22:putfield        #37  <Field int n>
        int nu = Math.min(m, n);
    //   13   25:aload_0         
    //   14   26:getfield        #32  <Field int m>
    //   15   29:aload_0         
    //   16   30:getfield        #37  <Field int n>
    //   17   33:invokestatic    #43  <Method int Math.min(int, int)>
    //   18   36:istore_3        
        s = new double[Math.min(m + 1, n)];
    //   19   37:aload_0         
    //   20   38:aload_0         
    //   21   39:getfield        #32  <Field int m>
    //   22   42:iconst_1        
    //   23   43:iadd            
    //   24   44:aload_0         
    //   25   45:getfield        #37  <Field int n>
    //   26   48:invokestatic    #43  <Method int Math.min(int, int)>
    //   27   51:newarray        double[]
    //   28   53:putfield        #45  <Field double[] s>
        U = new double[m][nu];
    //   29   56:aload_0         
    //   30   57:aload_0         
    //   31   58:getfield        #32  <Field int m>
    //   32   61:iload_3         
    //   33   62:multianewarray  double[][]
    //   34   66:putfield        #48  <Field double[][] U>
        V = new double[n][n];
    //   35   69:aload_0         
    //   36   70:aload_0         
    //   37   71:getfield        #37  <Field int n>
    //   38   74:aload_0         
    //   39   75:getfield        #37  <Field int n>
    //   40   78:multianewarray  double[][]
    //   41   82:putfield        #50  <Field double[][] V>
        double e[] = new double[n];
    //   42   85:aload_0         
    //   43   86:getfield        #37  <Field int n>
    //   44   89:newarray        double[]
    //   45   91:astore          4
        double work[] = new double[m];
    //   46   93:aload_0         
    //   47   94:getfield        #32  <Field int m>
    //   48   97:newarray        double[]
    //   49   99:astore          5
        boolean wantu = true;
    //   50  101:iconst_1        
    //   51  102:istore          6
        boolean wantv = true;
    //   52  104:iconst_1        
    //   53  105:istore          7
        int nct = Math.min(m - 1, n);
    //   54  107:aload_0         
    //   55  108:getfield        #32  <Field int m>
    //   56  111:iconst_1        
    //   57  112:isub            
    //   58  113:aload_0         
    //   59  114:getfield        #37  <Field int n>
    //   60  117:invokestatic    #43  <Method int Math.min(int, int)>
    //   61  120:istore          8
        int nrt = Math.max(0, Math.min(n - 2, m));
    //   62  122:iconst_0        
    //   63  123:aload_0         
    //   64  124:getfield        #37  <Field int n>
    //   65  127:iconst_2        
    //   66  128:isub            
    //   67  129:aload_0         
    //   68  130:getfield        #32  <Field int m>
    //   69  133:invokestatic    #43  <Method int Math.min(int, int)>
    //   70  136:invokestatic    #53  <Method int Math.max(int, int)>
    //   71  139:istore          9
        for(int k = 0; k < Math.max(nct, nrt); k++)
    //*  72  141:iconst_0        
    //*  73  142:istore          10
    //*  74  144:goto            906
        {
            if(k < nct)
    //*  75  147:iload           10
    //*  76  149:iload           8
    //*  77  151:icmpge          306
            {
                s[k] = 0.0D;
    //   78  154:aload_0         
    //   79  155:getfield        #45  <Field double[] s>
    //   80  158:iload           10
    //   81  160:dconst_0        
    //   82  161:dastore         
                for(int i = k; i < m; i++)
    //*  83  162:iload           10
    //*  84  164:istore          11
    //*  85  166:goto            196
                    s[k] = Maths.hypot(s[k], A[i][k]);
    //   86  169:aload_0         
    //   87  170:getfield        #45  <Field double[] s>
    //   88  173:iload           10
    //   89  175:aload_0         
    //   90  176:getfield        #45  <Field double[] s>
    //   91  179:iload           10
    //   92  181:daload          
    //   93  182:aload_2         
    //   94  183:iload           11
    //   95  185:aaload          
    //   96  186:iload           10
    //   97  188:daload          
    //   98  189:invokestatic    #59  <Method double Maths.hypot(double, double)>
    //   99  192:dastore         

    //  100  193:iinc            11  1
    //  101  196:iload           11
    //  102  198:aload_0         
    //  103  199:getfield        #32  <Field int m>
    //  104  202:icmplt          169
                if(s[k] != 0.0D)
    //* 105  205:aload_0         
    //* 106  206:getfield        #45  <Field double[] s>
    //* 107  209:iload           10
    //* 108  211:daload          
    //* 109  212:dconst_0        
    //* 110  213:dcmpl           
    //* 111  214:ifeq            291
                {
                    if(A[k][k] < 0.0D)
    //* 112  217:aload_2         
    //* 113  218:iload           10
    //* 114  220:aaload          
    //* 115  221:iload           10
    //* 116  223:daload          
    //* 117  224:dconst_0        
    //* 118  225:dcmpg           
    //* 119  226:ifge            244
                        s[k] = -s[k];
    //  120  229:aload_0         
    //  121  230:getfield        #45  <Field double[] s>
    //  122  233:iload           10
    //  123  235:aload_0         
    //  124  236:getfield        #45  <Field double[] s>
    //  125  239:iload           10
    //  126  241:daload          
    //  127  242:dneg            
    //  128  243:dastore         
                    for(int i = k; i < m; i++)
    //* 129  244:iload           10
    //* 130  246:istore          11
    //* 131  248:goto            271
                        A[i][k] /= s[k];
    //  132  251:aload_2         
    //  133  252:iload           11
    //  134  254:aaload          
    //  135  255:iload           10
    //  136  257:dup2            
    //  137  258:daload          
    //  138  259:aload_0         
    //  139  260:getfield        #45  <Field double[] s>
    //  140  263:iload           10
    //  141  265:daload          
    //  142  266:ddiv            
    //  143  267:dastore         

    //  144  268:iinc            11  1
    //  145  271:iload           11
    //  146  273:aload_0         
    //  147  274:getfield        #32  <Field int m>
    //  148  277:icmplt          251
                    A[k][k]++;
    //  149  280:aload_2         
    //  150  281:iload           10
    //  151  283:aaload          
    //  152  284:iload           10
    //  153  286:dup2            
    //  154  287:daload          
    //  155  288:dconst_1        
    //  156  289:dadd            
    //  157  290:dastore         
                }
                s[k] = -s[k];
    //  158  291:aload_0         
    //  159  292:getfield        #45  <Field double[] s>
    //  160  295:iload           10
    //  161  297:aload_0         
    //  162  298:getfield        #45  <Field double[] s>
    //  163  301:iload           10
    //  164  303:daload          
    //  165  304:dneg            
    //  166  305:dastore         
            }
            for(int j = k + 1; j < n; j++)
    //* 167  306:iload           10
    //* 168  308:iconst_1        
    //* 169  309:iadd            
    //* 170  310:istore          11
    //* 171  312:goto            457
            {
                if((k < nct) & (s[k] != 0.0D))
    //* 172  315:iload           10
    //* 173  317:iload           8
    //* 174  319:icmpge          326
    //* 175  322:iconst_1        
    //* 176  323:goto            327
    //* 177  326:iconst_0        
    //* 178  327:aload_0         
    //* 179  328:getfield        #45  <Field double[] s>
    //* 180  331:iload           10
    //* 181  333:daload          
    //* 182  334:dconst_0        
    //* 183  335:dcmpl           
    //* 184  336:ifeq            343
    //* 185  339:iconst_1        
    //* 186  340:goto            344
    //* 187  343:iconst_0        
    //* 188  344:iand            
    //* 189  345:ifeq            442
                {
                    double t = 0.0D;
    //  190  348:dconst_0        
    //  191  349:dstore          12
                    for(int i = k; i < m; i++)
    //* 192  351:iload           10
    //* 193  353:istore          14
    //* 194  355:goto            381
                        t += A[i][k] * A[i][j];
    //  195  358:dload           12
    //  196  360:aload_2         
    //  197  361:iload           14
    //  198  363:aaload          
    //  199  364:iload           10
    //  200  366:daload          
    //  201  367:aload_2         
    //  202  368:iload           14
    //  203  370:aaload          
    //  204  371:iload           11
    //  205  373:daload          
    //  206  374:dmul            
    //  207  375:dadd            
    //  208  376:dstore          12

    //  209  378:iinc            14  1
    //  210  381:iload           14
    //  211  383:aload_0         
    //  212  384:getfield        #32  <Field int m>
    //  213  387:icmplt          358
                    t = -t / A[k][k];
    //  214  390:dload           12
    //  215  392:dneg            
    //  216  393:aload_2         
    //  217  394:iload           10
    //  218  396:aaload          
    //  219  397:iload           10
    //  220  399:daload          
    //  221  400:ddiv            
    //  222  401:dstore          12
                    for(int i = k; i < m; i++)
    //* 223  403:iload           10
    //* 224  405:istore          14
    //* 225  407:goto            433
                        A[i][j] += t * A[i][k];
    //  226  410:aload_2         
    //  227  411:iload           14
    //  228  413:aaload          
    //  229  414:iload           11
    //  230  416:dup2            
    //  231  417:daload          
    //  232  418:dload           12
    //  233  420:aload_2         
    //  234  421:iload           14
    //  235  423:aaload          
    //  236  424:iload           10
    //  237  426:daload          
    //  238  427:dmul            
    //  239  428:dadd            
    //  240  429:dastore         

    //  241  430:iinc            14  1
    //  242  433:iload           14
    //  243  435:aload_0         
    //  244  436:getfield        #32  <Field int m>
    //  245  439:icmplt          410
                }
                e[j] = A[k][j];
    //  246  442:aload           4
    //  247  444:iload           11
    //  248  446:aload_2         
    //  249  447:iload           10
    //  250  449:aaload          
    //  251  450:iload           11
    //  252  452:daload          
    //  253  453:dastore         
            }

    //  254  454:iinc            11  1
    //  255  457:iload           11
    //  256  459:aload_0         
    //  257  460:getfield        #37  <Field int n>
    //  258  463:icmplt          315
            if(wantu & (k < nct))
    //* 259  466:iload           6
    //* 260  468:iload           10
    //* 261  470:iload           8
    //* 262  472:icmpge          479
    //* 263  475:iconst_1        
    //* 264  476:goto            480
    //* 265  479:iconst_0        
    //* 266  480:iand            
    //* 267  481:ifeq            520
            {
                for(int i = k; i < m; i++)
    //* 268  484:iload           10
    //* 269  486:istore          11
    //* 270  488:goto            511
                    U[i][k] = A[i][k];
    //  271  491:aload_0         
    //  272  492:getfield        #48  <Field double[][] U>
    //  273  495:iload           11
    //  274  497:aaload          
    //  275  498:iload           10
    //  276  500:aload_2         
    //  277  501:iload           11
    //  278  503:aaload          
    //  279  504:iload           10
    //  280  506:daload          
    //  281  507:dastore         

    //  282  508:iinc            11  1
    //  283  511:iload           11
    //  284  513:aload_0         
    //  285  514:getfield        #32  <Field int m>
    //  286  517:icmplt          491
            }
            if(k < nrt)
    //* 287  520:iload           10
    //* 288  522:iload           9
    //* 289  524:icmpge          903
            {
                e[k] = 0.0D;
    //  290  527:aload           4
    //  291  529:iload           10
    //  292  531:dconst_0        
    //  293  532:dastore         
                for(int i = k + 1; i < n; i++)
    //* 294  533:iload           10
    //* 295  535:iconst_1        
    //* 296  536:iadd            
    //* 297  537:istore          11
    //* 298  539:goto            563
                    e[k] = Maths.hypot(e[k], e[i]);
    //  299  542:aload           4
    //  300  544:iload           10
    //  301  546:aload           4
    //  302  548:iload           10
    //  303  550:daload          
    //  304  551:aload           4
    //  305  553:iload           11
    //  306  555:daload          
    //  307  556:invokestatic    #59  <Method double Maths.hypot(double, double)>
    //  308  559:dastore         

    //  309  560:iinc            11  1
    //  310  563:iload           11
    //  311  565:aload_0         
    //  312  566:getfield        #37  <Field int n>
    //  313  569:icmplt          542
                if(e[k] != 0.0D)
    //* 314  572:aload           4
    //* 315  574:iload           10
    //* 316  576:daload          
    //* 317  577:dconst_0        
    //* 318  578:dcmpl           
    //* 319  579:ifeq            650
                {
                    if(e[k + 1] < 0.0D)
    //* 320  582:aload           4
    //* 321  584:iload           10
    //* 322  586:iconst_1        
    //* 323  587:iadd            
    //* 324  588:daload          
    //* 325  589:dconst_0        
    //* 326  590:dcmpg           
    //* 327  591:ifge            605
                        e[k] = -e[k];
    //  328  594:aload           4
    //  329  596:iload           10
    //  330  598:aload           4
    //  331  600:iload           10
    //  332  602:daload          
    //  333  603:dneg            
    //  334  604:dastore         
                    for(int i = k + 1; i < n; i++)
    //* 335  605:iload           10
    //* 336  607:iconst_1        
    //* 337  608:iadd            
    //* 338  609:istore          11
    //* 339  611:goto            630
                        e[i] /= e[k];
    //  340  614:aload           4
    //  341  616:iload           11
    //  342  618:dup2            
    //  343  619:daload          
    //  344  620:aload           4
    //  345  622:iload           10
    //  346  624:daload          
    //  347  625:ddiv            
    //  348  626:dastore         

    //  349  627:iinc            11  1
    //  350  630:iload           11
    //  351  632:aload_0         
    //  352  633:getfield        #37  <Field int n>
    //  353  636:icmplt          614
                    e[k + 1]++;
    //  354  639:aload           4
    //  355  641:iload           10
    //  356  643:iconst_1        
    //  357  644:iadd            
    //  358  645:dup2            
    //  359  646:daload          
    //  360  647:dconst_1        
    //  361  648:dadd            
    //  362  649:dastore         
                }
                e[k] = -e[k];
    //  363  650:aload           4
    //  364  652:iload           10
    //  365  654:aload           4
    //  366  656:iload           10
    //  367  658:daload          
    //  368  659:dneg            
    //  369  660:dastore         
                if((k + 1 < m) & (e[k] != 0.0D))
    //* 370  661:iload           10
    //* 371  663:iconst_1        
    //* 372  664:iadd            
    //* 373  665:aload_0         
    //* 374  666:getfield        #32  <Field int m>
    //* 375  669:icmpge          676
    //* 376  672:iconst_1        
    //* 377  673:goto            677
    //* 378  676:iconst_0        
    //* 379  677:aload           4
    //* 380  679:iload           10
    //* 381  681:daload          
    //* 382  682:dconst_0        
    //* 383  683:dcmpl           
    //* 384  684:ifeq            691
    //* 385  687:iconst_1        
    //* 386  688:goto            692
    //* 387  691:iconst_0        
    //* 388  692:iand            
    //* 389  693:ifeq            862
                {
                    for(int i = k + 1; i < m; i++)
    //* 390  696:iload           10
    //* 391  698:iconst_1        
    //* 392  699:iadd            
    //* 393  700:istore          11
    //* 394  702:goto            714
                        work[i] = 0.0D;
    //  395  705:aload           5
    //  396  707:iload           11
    //  397  709:dconst_0        
    //  398  710:dastore         

    //  399  711:iinc            11  1
    //  400  714:iload           11
    //  401  716:aload_0         
    //  402  717:getfield        #32  <Field int m>
    //  403  720:icmplt          705
                    for(int j = k + 1; j < n; j++)
    //* 404  723:iload           10
    //* 405  725:iconst_1        
    //* 406  726:iadd            
    //* 407  727:istore          11
    //* 408  729:goto            777
                    {
                        for(int i = k + 1; i < m; i++)
    //* 409  732:iload           10
    //* 410  734:iconst_1        
    //* 411  735:iadd            
    //* 412  736:istore          12
    //* 413  738:goto            765
                            work[i] += e[j] * A[i][j];
    //  414  741:aload           5
    //  415  743:iload           12
    //  416  745:dup2            
    //  417  746:daload          
    //  418  747:aload           4
    //  419  749:iload           11
    //  420  751:daload          
    //  421  752:aload_2         
    //  422  753:iload           12
    //  423  755:aaload          
    //  424  756:iload           11
    //  425  758:daload          
    //  426  759:dmul            
    //  427  760:dadd            
    //  428  761:dastore         

    //  429  762:iinc            12  1
    //  430  765:iload           12
    //  431  767:aload_0         
    //  432  768:getfield        #32  <Field int m>
    //  433  771:icmplt          741
                    }

    //  434  774:iinc            11  1
    //  435  777:iload           11
    //  436  779:aload_0         
    //  437  780:getfield        #37  <Field int n>
    //  438  783:icmplt          732
                    for(int j = k + 1; j < n; j++)
    //* 439  786:iload           10
    //* 440  788:iconst_1        
    //* 441  789:iadd            
    //* 442  790:istore          11
    //* 443  792:goto            853
                    {
                        double t = -e[j] / e[k + 1];
    //  444  795:aload           4
    //  445  797:iload           11
    //  446  799:daload          
    //  447  800:dneg            
    //  448  801:aload           4
    //  449  803:iload           10
    //  450  805:iconst_1        
    //  451  806:iadd            
    //  452  807:daload          
    //  453  808:ddiv            
    //  454  809:dstore          12
                        for(int i = k + 1; i < m; i++)
    //* 455  811:iload           10
    //* 456  813:iconst_1        
    //* 457  814:iadd            
    //* 458  815:istore          14
    //* 459  817:goto            841
                            A[i][j] += t * work[i];
    //  460  820:aload_2         
    //  461  821:iload           14
    //  462  823:aaload          
    //  463  824:iload           11
    //  464  826:dup2            
    //  465  827:daload          
    //  466  828:dload           12
    //  467  830:aload           5
    //  468  832:iload           14
    //  469  834:daload          
    //  470  835:dmul            
    //  471  836:dadd            
    //  472  837:dastore         

    //  473  838:iinc            14  1
    //  474  841:iload           14
    //  475  843:aload_0         
    //  476  844:getfield        #32  <Field int m>
    //  477  847:icmplt          820
                    }

    //  478  850:iinc            11  1
    //  479  853:iload           11
    //  480  855:aload_0         
    //  481  856:getfield        #37  <Field int n>
    //  482  859:icmplt          795
                }
                if(wantv)
    //* 483  862:iload           7
    //* 484  864:ifeq            903
                {
                    for(int i = k + 1; i < n; i++)
    //* 485  867:iload           10
    //* 486  869:iconst_1        
    //* 487  870:iadd            
    //* 488  871:istore          11
    //* 489  873:goto            894
                        V[i][k] = e[i];
    //  490  876:aload_0         
    //  491  877:getfield        #50  <Field double[][] V>
    //  492  880:iload           11
    //  493  882:aaload          
    //  494  883:iload           10
    //  495  885:aload           4
    //  496  887:iload           11
    //  497  889:daload          
    //  498  890:dastore         

    //  499  891:iinc            11  1
    //  500  894:iload           11
    //  501  896:aload_0         
    //  502  897:getfield        #37  <Field int n>
    //  503  900:icmplt          876
                }
            }
        }

    //  504  903:iinc            10  1
    //  505  906:iload           10
    //  506  908:iload           8
    //  507  910:iload           9
    //  508  912:invokestatic    #53  <Method int Math.max(int, int)>
    //  509  915:icmplt          147
        int p = Math.min(n, m + 1);
    //  510  918:aload_0         
    //  511  919:getfield        #37  <Field int n>
    //  512  922:aload_0         
    //  513  923:getfield        #32  <Field int m>
    //  514  926:iconst_1        
    //  515  927:iadd            
    //  516  928:invokestatic    #43  <Method int Math.min(int, int)>
    //  517  931:istore          10
        if(nct < n)
    //* 518  933:iload           8
    //* 519  935:aload_0         
    //* 520  936:getfield        #37  <Field int n>
    //* 521  939:icmpge          956
            s[nct] = A[nct][nct];
    //  522  942:aload_0         
    //  523  943:getfield        #45  <Field double[] s>
    //  524  946:iload           8
    //  525  948:aload_2         
    //  526  949:iload           8
    //  527  951:aaload          
    //  528  952:iload           8
    //  529  954:daload          
    //  530  955:dastore         
        if(m < p)
    //* 531  956:aload_0         
    //* 532  957:getfield        #32  <Field int m>
    //* 533  960:iload           10
    //* 534  962:icmpge          975
            s[p - 1] = 0.0D;
    //  535  965:aload_0         
    //  536  966:getfield        #45  <Field double[] s>
    //  537  969:iload           10
    //  538  971:iconst_1        
    //  539  972:isub            
    //  540  973:dconst_0        
    //  541  974:dastore         
        if(nrt + 1 < p)
    //* 542  975:iload           9
    //* 543  977:iconst_1        
    //* 544  978:iadd            
    //* 545  979:iload           10
    //* 546  981:icmpge          998
            e[nrt] = A[nrt][p - 1];
    //  547  984:aload           4
    //  548  986:iload           9
    //  549  988:aload_2         
    //  550  989:iload           9
    //  551  991:aaload          
    //  552  992:iload           10
    //  553  994:iconst_1        
    //  554  995:isub            
    //  555  996:daload          
    //  556  997:dastore         
        e[p - 1] = 0.0D;
    //  557  998:aload           4
    //  558 1000:iload           10
    //  559 1002:iconst_1        
    //  560 1003:isub            
    //  561 1004:dconst_0        
    //  562 1005:dastore         
        if(wantu)
    //* 563 1006:iload           6
    //* 564 1008:ifeq            1357
        {
            for(int j = nct; j < nu; j++)
    //* 565 1011:iload           8
    //* 566 1013:istore          11
    //* 567 1015:goto            1061
            {
                for(int i = 0; i < m; i++)
    //* 568 1018:iconst_0        
    //* 569 1019:istore          12
    //* 570 1021:goto            1038
                    U[i][j] = 0.0D;
    //  571 1024:aload_0         
    //  572 1025:getfield        #48  <Field double[][] U>
    //  573 1028:iload           12
    //  574 1030:aaload          
    //  575 1031:iload           11
    //  576 1033:dconst_0        
    //  577 1034:dastore         

    //  578 1035:iinc            12  1
    //  579 1038:iload           12
    //  580 1040:aload_0         
    //  581 1041:getfield        #32  <Field int m>
    //  582 1044:icmplt          1024
                U[j][j] = 1.0D;
    //  583 1047:aload_0         
    //  584 1048:getfield        #48  <Field double[][] U>
    //  585 1051:iload           11
    //  586 1053:aaload          
    //  587 1054:iload           11
    //  588 1056:dconst_1        
    //  589 1057:dastore         
            }

    //  590 1058:iinc            11  1
    //  591 1061:iload           11
    //  592 1063:iload_3         
    //  593 1064:icmplt          1018
            for(int k = nct - 1; k >= 0; k--)
    //* 594 1067:iload           8
    //* 595 1069:iconst_1        
    //* 596 1070:isub            
    //* 597 1071:istore          11
    //* 598 1073:goto            1352
                if(s[k] != 0.0D)
    //* 599 1076:aload_0         
    //* 600 1077:getfield        #45  <Field double[] s>
    //* 601 1080:iload           11
    //* 602 1082:daload          
    //* 603 1083:dconst_0        
    //* 604 1084:dcmpl           
    //* 605 1085:ifeq            1309
                {
                    for(int j = k + 1; j < nu; j++)
    //* 606 1088:iload           11
    //* 607 1090:iconst_1        
    //* 608 1091:iadd            
    //* 609 1092:istore          12
    //* 610 1094:goto            1209
                    {
                        double t = 0.0D;
    //  611 1097:dconst_0        
    //  612 1098:dstore          13
                        for(int i = k; i < m; i++)
    //* 613 1100:iload           11
    //* 614 1102:istore          15
    //* 615 1104:goto            1136
                            t += U[i][k] * U[i][j];
    //  616 1107:dload           13
    //  617 1109:aload_0         
    //  618 1110:getfield        #48  <Field double[][] U>
    //  619 1113:iload           15
    //  620 1115:aaload          
    //  621 1116:iload           11
    //  622 1118:daload          
    //  623 1119:aload_0         
    //  624 1120:getfield        #48  <Field double[][] U>
    //  625 1123:iload           15
    //  626 1125:aaload          
    //  627 1126:iload           12
    //  628 1128:daload          
    //  629 1129:dmul            
    //  630 1130:dadd            
    //  631 1131:dstore          13

    //  632 1133:iinc            15  1
    //  633 1136:iload           15
    //  634 1138:aload_0         
    //  635 1139:getfield        #32  <Field int m>
    //  636 1142:icmplt          1107
                        t = -t / U[k][k];
    //  637 1145:dload           13
    //  638 1147:dneg            
    //  639 1148:aload_0         
    //  640 1149:getfield        #48  <Field double[][] U>
    //  641 1152:iload           11
    //  642 1154:aaload          
    //  643 1155:iload           11
    //  644 1157:daload          
    //  645 1158:ddiv            
    //  646 1159:dstore          13
                        for(int i = k; i < m; i++)
    //* 647 1161:iload           11
    //* 648 1163:istore          15
    //* 649 1165:goto            1197
                            U[i][j] += t * U[i][k];
    //  650 1168:aload_0         
    //  651 1169:getfield        #48  <Field double[][] U>
    //  652 1172:iload           15
    //  653 1174:aaload          
    //  654 1175:iload           12
    //  655 1177:dup2            
    //  656 1178:daload          
    //  657 1179:dload           13
    //  658 1181:aload_0         
    //  659 1182:getfield        #48  <Field double[][] U>
    //  660 1185:iload           15
    //  661 1187:aaload          
    //  662 1188:iload           11
    //  663 1190:daload          
    //  664 1191:dmul            
    //  665 1192:dadd            
    //  666 1193:dastore         

    //  667 1194:iinc            15  1
    //  668 1197:iload           15
    //  669 1199:aload_0         
    //  670 1200:getfield        #32  <Field int m>
    //  671 1203:icmplt          1168
                    }

    //  672 1206:iinc            12  1
    //  673 1209:iload           12
    //  674 1211:iload_3         
    //  675 1212:icmplt          1097
                    for(int i = k; i < m; i++)
    //* 676 1215:iload           11
    //* 677 1217:istore          12
    //* 678 1219:goto            1246
                        U[i][k] = -U[i][k];
    //  679 1222:aload_0         
    //  680 1223:getfield        #48  <Field double[][] U>
    //  681 1226:iload           12
    //  682 1228:aaload          
    //  683 1229:iload           11
    //  684 1231:aload_0         
    //  685 1232:getfield        #48  <Field double[][] U>
    //  686 1235:iload           12
    //  687 1237:aaload          
    //  688 1238:iload           11
    //  689 1240:daload          
    //  690 1241:dneg            
    //  691 1242:dastore         

    //  692 1243:iinc            12  1
    //  693 1246:iload           12
    //  694 1248:aload_0         
    //  695 1249:getfield        #32  <Field int m>
    //  696 1252:icmplt          1222
                    U[k][k] = 1.0D + U[k][k];
    //  697 1255:aload_0         
    //  698 1256:getfield        #48  <Field double[][] U>
    //  699 1259:iload           11
    //  700 1261:aaload          
    //  701 1262:iload           11
    //  702 1264:dconst_1        
    //  703 1265:aload_0         
    //  704 1266:getfield        #48  <Field double[][] U>
    //  705 1269:iload           11
    //  706 1271:aaload          
    //  707 1272:iload           11
    //  708 1274:daload          
    //  709 1275:dadd            
    //  710 1276:dastore         
                    for(int i = 0; i < k - 1; i++)
    //* 711 1277:iconst_0        
    //* 712 1278:istore          12
    //* 713 1280:goto            1297
                        U[i][k] = 0.0D;
    //  714 1283:aload_0         
    //  715 1284:getfield        #48  <Field double[][] U>
    //  716 1287:iload           12
    //  717 1289:aaload          
    //  718 1290:iload           11
    //  719 1292:dconst_0        
    //  720 1293:dastore         

    //  721 1294:iinc            12  1
    //  722 1297:iload           12
    //  723 1299:iload           11
    //  724 1301:iconst_1        
    //  725 1302:isub            
    //  726 1303:icmplt          1283
                } else
    //* 727 1306:goto            1349
                {
                    for(int i = 0; i < m; i++)
    //* 728 1309:iconst_0        
    //* 729 1310:istore          12
    //* 730 1312:goto            1329
                        U[i][k] = 0.0D;
    //  731 1315:aload_0         
    //  732 1316:getfield        #48  <Field double[][] U>
    //  733 1319:iload           12
    //  734 1321:aaload          
    //  735 1322:iload           11
    //  736 1324:dconst_0        
    //  737 1325:dastore         

    //  738 1326:iinc            12  1
    //  739 1329:iload           12
    //  740 1331:aload_0         
    //  741 1332:getfield        #32  <Field int m>
    //  742 1335:icmplt          1315
                    U[k][k] = 1.0D;
    //  743 1338:aload_0         
    //  744 1339:getfield        #48  <Field double[][] U>
    //  745 1342:iload           11
    //  746 1344:aaload          
    //  747 1345:iload           11
    //  748 1347:dconst_1        
    //  749 1348:dastore         
                }

    //  750 1349:iinc            11  -1
    //  751 1352:iload           11
    //  752 1354:ifge            1076
        }
        if(wantv)
    //* 753 1357:iload           7
    //* 754 1359:ifeq            1585
        {
            for(int k = n - 1; k >= 0; k--)
    //* 755 1362:aload_0         
    //* 756 1363:getfield        #37  <Field int n>
    //* 757 1366:iconst_1        
    //* 758 1367:isub            
    //* 759 1368:istore          11
    //* 760 1370:goto            1580
            {
                if((k < nrt) & (e[k] != 0.0D))
    //* 761 1373:iload           11
    //* 762 1375:iload           9
    //* 763 1377:icmpge          1384
    //* 764 1380:iconst_1        
    //* 765 1381:goto            1385
    //* 766 1384:iconst_0        
    //* 767 1385:aload           4
    //* 768 1387:iload           11
    //* 769 1389:daload          
    //* 770 1390:dconst_0        
    //* 771 1391:dcmpl           
    //* 772 1392:ifeq            1399
    //* 773 1395:iconst_1        
    //* 774 1396:goto            1400
    //* 775 1399:iconst_0        
    //* 776 1400:iand            
    //* 777 1401:ifeq            1537
                {
                    for(int j = k + 1; j < nu; j++)
    //* 778 1404:iload           11
    //* 779 1406:iconst_1        
    //* 780 1407:iadd            
    //* 781 1408:istore          12
    //* 782 1410:goto            1531
                    {
                        double t = 0.0D;
    //  783 1413:dconst_0        
    //  784 1414:dstore          13
                        for(int i = k + 1; i < n; i++)
    //* 785 1416:iload           11
    //* 786 1418:iconst_1        
    //* 787 1419:iadd            
    //* 788 1420:istore          15
    //* 789 1422:goto            1454
                            t += V[i][k] * V[i][j];
    //  790 1425:dload           13
    //  791 1427:aload_0         
    //  792 1428:getfield        #50  <Field double[][] V>
    //  793 1431:iload           15
    //  794 1433:aaload          
    //  795 1434:iload           11
    //  796 1436:daload          
    //  797 1437:aload_0         
    //  798 1438:getfield        #50  <Field double[][] V>
    //  799 1441:iload           15
    //  800 1443:aaload          
    //  801 1444:iload           12
    //  802 1446:daload          
    //  803 1447:dmul            
    //  804 1448:dadd            
    //  805 1449:dstore          13

    //  806 1451:iinc            15  1
    //  807 1454:iload           15
    //  808 1456:aload_0         
    //  809 1457:getfield        #37  <Field int n>
    //  810 1460:icmplt          1425
                        t = -t / V[k + 1][k];
    //  811 1463:dload           13
    //  812 1465:dneg            
    //  813 1466:aload_0         
    //  814 1467:getfield        #50  <Field double[][] V>
    //  815 1470:iload           11
    //  816 1472:iconst_1        
    //  817 1473:iadd            
    //  818 1474:aaload          
    //  819 1475:iload           11
    //  820 1477:daload          
    //  821 1478:ddiv            
    //  822 1479:dstore          13
                        for(int i = k + 1; i < n; i++)
    //* 823 1481:iload           11
    //* 824 1483:iconst_1        
    //* 825 1484:iadd            
    //* 826 1485:istore          15
    //* 827 1487:goto            1519
                            V[i][j] += t * V[i][k];
    //  828 1490:aload_0         
    //  829 1491:getfield        #50  <Field double[][] V>
    //  830 1494:iload           15
    //  831 1496:aaload          
    //  832 1497:iload           12
    //  833 1499:dup2            
    //  834 1500:daload          
    //  835 1501:dload           13
    //  836 1503:aload_0         
    //  837 1504:getfield        #50  <Field double[][] V>
    //  838 1507:iload           15
    //  839 1509:aaload          
    //  840 1510:iload           11
    //  841 1512:daload          
    //  842 1513:dmul            
    //  843 1514:dadd            
    //  844 1515:dastore         

    //  845 1516:iinc            15  1
    //  846 1519:iload           15
    //  847 1521:aload_0         
    //  848 1522:getfield        #37  <Field int n>
    //  849 1525:icmplt          1490
                    }

    //  850 1528:iinc            12  1
    //  851 1531:iload           12
    //  852 1533:iload_3         
    //  853 1534:icmplt          1413
                }
                for(int i = 0; i < n; i++)
    //* 854 1537:iconst_0        
    //* 855 1538:istore          12
    //* 856 1540:goto            1557
                    V[i][k] = 0.0D;
    //  857 1543:aload_0         
    //  858 1544:getfield        #50  <Field double[][] V>
    //  859 1547:iload           12
    //  860 1549:aaload          
    //  861 1550:iload           11
    //  862 1552:dconst_0        
    //  863 1553:dastore         

    //  864 1554:iinc            12  1
    //  865 1557:iload           12
    //  866 1559:aload_0         
    //  867 1560:getfield        #37  <Field int n>
    //  868 1563:icmplt          1543
                V[k][k] = 1.0D;
    //  869 1566:aload_0         
    //  870 1567:getfield        #50  <Field double[][] V>
    //  871 1570:iload           11
    //  872 1572:aaload          
    //  873 1573:iload           11
    //  874 1575:dconst_1        
    //  875 1576:dastore         
            }

    //  876 1577:iinc            11  -1
    //  877 1580:iload           11
    //  878 1582:ifge            1373
        }
        int pp = p - 1;
    //  879 1585:iload           10
    //  880 1587:iconst_1        
    //  881 1588:isub            
    //  882 1589:istore          11
        int iter = 0;
    //  883 1591:iconst_0        
    //  884 1592:istore          12
        double eps = Math.pow(2D, -52D);
    //  885 1594:ldc2w           #60  <Double 2D>
    //  886 1597:ldc2w           #62  <Double -52D>
    //  887 1600:invokestatic    #66  <Method double Math.pow(double, double)>
    //  888 1603:dstore          13
        double tiny = Math.pow(2D, -966D);
    //  889 1605:ldc2w           #60  <Double 2D>
    //  890 1608:ldc2w           #67  <Double -966D>
    //  891 1611:invokestatic    #66  <Method double Math.pow(double, double)>
    //  892 1614:dstore          15
    //* 893 1616:goto            3400
        while(p > 0) 
        {
            int k;
            for(k = p - 2; k >= -1; k--)
    //* 894 1619:iload           10
    //* 895 1621:iconst_2        
    //* 896 1622:isub            
    //* 897 1623:istore          17
    //* 898 1625:goto            1690
            {
                if(k == -1)
    //* 899 1628:iload           17
    //* 900 1630:iconst_m1       
    //* 901 1631:icmpne          1637
                    break;
    //  902 1634:goto            1696
                if(Math.abs(e[k]) > tiny + eps * (Math.abs(s[k]) + Math.abs(s[k + 1])))
                    continue;
    //  903 1637:aload           4
    //  904 1639:iload           17
    //  905 1641:daload          
    //  906 1642:invokestatic    #72  <Method double Math.abs(double)>
    //  907 1645:dload           15
    //  908 1647:dload           13
    //  909 1649:aload_0         
    //  910 1650:getfield        #45  <Field double[] s>
    //  911 1653:iload           17
    //  912 1655:daload          
    //  913 1656:invokestatic    #72  <Method double Math.abs(double)>
    //  914 1659:aload_0         
    //  915 1660:getfield        #45  <Field double[] s>
    //  916 1663:iload           17
    //  917 1665:iconst_1        
    //  918 1666:iadd            
    //  919 1667:daload          
    //  920 1668:invokestatic    #72  <Method double Math.abs(double)>
    //  921 1671:dadd            
    //  922 1672:dmul            
    //  923 1673:dadd            
    //  924 1674:dcmpg           
    //  925 1675:ifgt            1687
                e[k] = 0.0D;
    //  926 1678:aload           4
    //  927 1680:iload           17
    //  928 1682:dconst_0        
    //  929 1683:dastore         
                break;
    //  930 1684:goto            1696
            }

    //  931 1687:iinc            17  -1
    //  932 1690:iload           17
    //  933 1692:iconst_m1       
    //  934 1693:icmpge          1628
            int kase;
            if(k == p - 2)
    //* 935 1696:iload           17
    //* 936 1698:iload           10
    //* 937 1700:iconst_2        
    //* 938 1701:isub            
    //* 939 1702:icmpne          1711
            {
                kase = 4;
    //  940 1705:iconst_4        
    //  941 1706:istore          18
            } else
    //* 942 1708:goto            1853
            {
                int ks;
                for(ks = p - 1; ks >= k; ks--)
    //* 943 1711:iload           10
    //* 944 1713:iconst_1        
    //* 945 1714:isub            
    //* 946 1715:istore          19
    //* 947 1717:goto            1811
                {
                    if(ks == k)
    //* 948 1720:iload           19
    //* 949 1722:iload           17
    //* 950 1724:icmpne          1730
                        break;
    //  951 1727:goto            1818
                    double t = (ks == p ? 0.0D : Math.abs(e[ks])) + (ks == k + 1 ? 0.0D : Math.abs(e[ks - 1]));
    //  952 1730:iload           19
    //  953 1732:iload           10
    //  954 1734:icmpeq          1748
    //  955 1737:aload           4
    //  956 1739:iload           19
    //  957 1741:daload          
    //  958 1742:invokestatic    #72  <Method double Math.abs(double)>
    //  959 1745:goto            1749
    //  960 1748:dconst_0        
    //  961 1749:iload           19
    //  962 1751:iload           17
    //  963 1753:iconst_1        
    //  964 1754:iadd            
    //  965 1755:icmpeq          1771
    //  966 1758:aload           4
    //  967 1760:iload           19
    //  968 1762:iconst_1        
    //  969 1763:isub            
    //  970 1764:daload          
    //  971 1765:invokestatic    #72  <Method double Math.abs(double)>
    //  972 1768:goto            1772
    //  973 1771:dconst_0        
    //  974 1772:dadd            
    //  975 1773:dstore          20
                    if(Math.abs(s[ks]) > tiny + eps * t)
                        continue;
    //  976 1775:aload_0         
    //  977 1776:getfield        #45  <Field double[] s>
    //  978 1779:iload           19
    //  979 1781:daload          
    //  980 1782:invokestatic    #72  <Method double Math.abs(double)>
    //  981 1785:dload           15
    //  982 1787:dload           13
    //  983 1789:dload           20
    //  984 1791:dmul            
    //  985 1792:dadd            
    //  986 1793:dcmpg           
    //  987 1794:ifgt            1808
                    s[ks] = 0.0D;
    //  988 1797:aload_0         
    //  989 1798:getfield        #45  <Field double[] s>
    //  990 1801:iload           19
    //  991 1803:dconst_0        
    //  992 1804:dastore         
                    break;
    //  993 1805:goto            1818
                }

    //  994 1808:iinc            19  -1
    //  995 1811:iload           19
    //  996 1813:iload           17
    //  997 1815:icmpge          1720
                if(ks == k)
    //* 998 1818:iload           19
    //* 999 1820:iload           17
    //*1000 1822:icmpne          1831
                    kase = 3;
    // 1001 1825:iconst_3        
    // 1002 1826:istore          18
                else
    //*1003 1828:goto            1853
                if(ks == p - 1)
    //*1004 1831:iload           19
    //*1005 1833:iload           10
    //*1006 1835:iconst_1        
    //*1007 1836:isub            
    //*1008 1837:icmpne          1846
                {
                    kase = 1;
    // 1009 1840:iconst_1        
    // 1010 1841:istore          18
                } else
    //*1011 1843:goto            1853
                {
                    kase = 2;
    // 1012 1846:iconst_2        
    // 1013 1847:istore          18
                    k = ks;
    // 1014 1849:iload           19
    // 1015 1851:istore          17
                }
            }
            k++;
    // 1016 1853:iinc            17  1
            switch(kase)
    //*1017 1856:iload           18
            {
            default:
                break;

    //*1018 1858:tableswitch     1 4: default 3400
    //                   1 1888
    //                   2 2114
    //                   3 2325
    //                   4 3073
            case 1: // '\001'
            {
                double f = e[p - 2];
    // 1019 1888:aload           4
    // 1020 1890:iload           10
    // 1021 1892:iconst_2        
    // 1022 1893:isub            
    // 1023 1894:daload          
    // 1024 1895:dstore          19
                e[p - 2] = 0.0D;
    // 1025 1897:aload           4
    // 1026 1899:iload           10
    // 1027 1901:iconst_2        
    // 1028 1902:isub            
    // 1029 1903:dconst_0        
    // 1030 1904:dastore         
                for(int j = p - 2; j >= k; j--)
    //*1031 1905:iload           10
    //*1032 1907:iconst_2        
    //*1033 1908:isub            
    //*1034 1909:istore          21
    //*1035 1911:goto            2104
                {
                    double t = Maths.hypot(s[j], f);
    // 1036 1914:aload_0         
    // 1037 1915:getfield        #45  <Field double[] s>
    // 1038 1918:iload           21
    // 1039 1920:daload          
    // 1040 1921:dload           19
    // 1041 1923:invokestatic    #59  <Method double Maths.hypot(double, double)>
    // 1042 1926:dstore          22
                    double cs = s[j] / t;
    // 1043 1928:aload_0         
    // 1044 1929:getfield        #45  <Field double[] s>
    // 1045 1932:iload           21
    // 1046 1934:daload          
    // 1047 1935:dload           22
    // 1048 1937:ddiv            
    // 1049 1938:dstore          24
                    double sn = f / t;
    // 1050 1940:dload           19
    // 1051 1942:dload           22
    // 1052 1944:ddiv            
    // 1053 1945:dstore          26
                    s[j] = t;
    // 1054 1947:aload_0         
    // 1055 1948:getfield        #45  <Field double[] s>
    // 1056 1951:iload           21
    // 1057 1953:dload           22
    // 1058 1955:dastore         
                    if(j != k)
    //*1059 1956:iload           21
    //*1060 1958:iload           17
    //*1061 1960:icmpeq          1993
                    {
                        f = -sn * e[j - 1];
    // 1062 1963:dload           26
    // 1063 1965:dneg            
    // 1064 1966:aload           4
    // 1065 1968:iload           21
    // 1066 1970:iconst_1        
    // 1067 1971:isub            
    // 1068 1972:daload          
    // 1069 1973:dmul            
    // 1070 1974:dstore          19
                        e[j - 1] = cs * e[j - 1];
    // 1071 1976:aload           4
    // 1072 1978:iload           21
    // 1073 1980:iconst_1        
    // 1074 1981:isub            
    // 1075 1982:dload           24
    // 1076 1984:aload           4
    // 1077 1986:iload           21
    // 1078 1988:iconst_1        
    // 1079 1989:isub            
    // 1080 1990:daload          
    // 1081 1991:dmul            
    // 1082 1992:dastore         
                    }
                    if(wantv)
    //*1083 1993:iload           7
    //*1084 1995:ifeq            2101
                    {
                        for(int i = 0; i < n; i++)
    //*1085 1998:iconst_0        
    //*1086 1999:istore          28
    //*1087 2001:goto            2092
                        {
                            t = cs * V[i][j] + sn * V[i][p - 1];
    // 1088 2004:dload           24
    // 1089 2006:aload_0         
    // 1090 2007:getfield        #50  <Field double[][] V>
    // 1091 2010:iload           28
    // 1092 2012:aaload          
    // 1093 2013:iload           21
    // 1094 2015:daload          
    // 1095 2016:dmul            
    // 1096 2017:dload           26
    // 1097 2019:aload_0         
    // 1098 2020:getfield        #50  <Field double[][] V>
    // 1099 2023:iload           28
    // 1100 2025:aaload          
    // 1101 2026:iload           10
    // 1102 2028:iconst_1        
    // 1103 2029:isub            
    // 1104 2030:daload          
    // 1105 2031:dmul            
    // 1106 2032:dadd            
    // 1107 2033:dstore          22
                            V[i][p - 1] = -sn * V[i][j] + cs * V[i][p - 1];
    // 1108 2035:aload_0         
    // 1109 2036:getfield        #50  <Field double[][] V>
    // 1110 2039:iload           28
    // 1111 2041:aaload          
    // 1112 2042:iload           10
    // 1113 2044:iconst_1        
    // 1114 2045:isub            
    // 1115 2046:dload           26
    // 1116 2048:dneg            
    // 1117 2049:aload_0         
    // 1118 2050:getfield        #50  <Field double[][] V>
    // 1119 2053:iload           28
    // 1120 2055:aaload          
    // 1121 2056:iload           21
    // 1122 2058:daload          
    // 1123 2059:dmul            
    // 1124 2060:dload           24
    // 1125 2062:aload_0         
    // 1126 2063:getfield        #50  <Field double[][] V>
    // 1127 2066:iload           28
    // 1128 2068:aaload          
    // 1129 2069:iload           10
    // 1130 2071:iconst_1        
    // 1131 2072:isub            
    // 1132 2073:daload          
    // 1133 2074:dmul            
    // 1134 2075:dadd            
    // 1135 2076:dastore         
                            V[i][j] = t;
    // 1136 2077:aload_0         
    // 1137 2078:getfield        #50  <Field double[][] V>
    // 1138 2081:iload           28
    // 1139 2083:aaload          
    // 1140 2084:iload           21
    // 1141 2086:dload           22
    // 1142 2088:dastore         
                        }

    // 1143 2089:iinc            28  1
    // 1144 2092:iload           28
    // 1145 2094:aload_0         
    // 1146 2095:getfield        #37  <Field int n>
    // 1147 2098:icmplt          2004
                    }
                }

    // 1148 2101:iinc            21  -1
    // 1149 2104:iload           21
    // 1150 2106:iload           17
    // 1151 2108:icmpge          1914
                break;
    // 1152 2111:goto            3400
            }

            case 2: // '\002'
            {
                double f = e[k - 1];
    // 1153 2114:aload           4
    // 1154 2116:iload           17
    // 1155 2118:iconst_1        
    // 1156 2119:isub            
    // 1157 2120:daload          
    // 1158 2121:dstore          19
                e[k - 1] = 0.0D;
    // 1159 2123:aload           4
    // 1160 2125:iload           17
    // 1161 2127:iconst_1        
    // 1162 2128:isub            
    // 1163 2129:dconst_0        
    // 1164 2130:dastore         
                for(int j = k; j < p; j++)
    //*1165 2131:iload           17
    //*1166 2133:istore          21
    //*1167 2135:goto            2315
                {
                    double t = Maths.hypot(s[j], f);
    // 1168 2138:aload_0         
    // 1169 2139:getfield        #45  <Field double[] s>
    // 1170 2142:iload           21
    // 1171 2144:daload          
    // 1172 2145:dload           19
    // 1173 2147:invokestatic    #59  <Method double Maths.hypot(double, double)>
    // 1174 2150:dstore          22
                    double cs = s[j] / t;
    // 1175 2152:aload_0         
    // 1176 2153:getfield        #45  <Field double[] s>
    // 1177 2156:iload           21
    // 1178 2158:daload          
    // 1179 2159:dload           22
    // 1180 2161:ddiv            
    // 1181 2162:dstore          24
                    double sn = f / t;
    // 1182 2164:dload           19
    // 1183 2166:dload           22
    // 1184 2168:ddiv            
    // 1185 2169:dstore          26
                    s[j] = t;
    // 1186 2171:aload_0         
    // 1187 2172:getfield        #45  <Field double[] s>
    // 1188 2175:iload           21
    // 1189 2177:dload           22
    // 1190 2179:dastore         
                    f = -sn * e[j];
    // 1191 2180:dload           26
    // 1192 2182:dneg            
    // 1193 2183:aload           4
    // 1194 2185:iload           21
    // 1195 2187:daload          
    // 1196 2188:dmul            
    // 1197 2189:dstore          19
                    e[j] = cs * e[j];
    // 1198 2191:aload           4
    // 1199 2193:iload           21
    // 1200 2195:dload           24
    // 1201 2197:aload           4
    // 1202 2199:iload           21
    // 1203 2201:daload          
    // 1204 2202:dmul            
    // 1205 2203:dastore         
                    if(wantu)
    //*1206 2204:iload           6
    //*1207 2206:ifeq            2312
                    {
                        for(int i = 0; i < m; i++)
    //*1208 2209:iconst_0        
    //*1209 2210:istore          28
    //*1210 2212:goto            2303
                        {
                            t = cs * U[i][j] + sn * U[i][k - 1];
    // 1211 2215:dload           24
    // 1212 2217:aload_0         
    // 1213 2218:getfield        #48  <Field double[][] U>
    // 1214 2221:iload           28
    // 1215 2223:aaload          
    // 1216 2224:iload           21
    // 1217 2226:daload          
    // 1218 2227:dmul            
    // 1219 2228:dload           26
    // 1220 2230:aload_0         
    // 1221 2231:getfield        #48  <Field double[][] U>
    // 1222 2234:iload           28
    // 1223 2236:aaload          
    // 1224 2237:iload           17
    // 1225 2239:iconst_1        
    // 1226 2240:isub            
    // 1227 2241:daload          
    // 1228 2242:dmul            
    // 1229 2243:dadd            
    // 1230 2244:dstore          22
                            U[i][k - 1] = -sn * U[i][j] + cs * U[i][k - 1];
    // 1231 2246:aload_0         
    // 1232 2247:getfield        #48  <Field double[][] U>
    // 1233 2250:iload           28
    // 1234 2252:aaload          
    // 1235 2253:iload           17
    // 1236 2255:iconst_1        
    // 1237 2256:isub            
    // 1238 2257:dload           26
    // 1239 2259:dneg            
    // 1240 2260:aload_0         
    // 1241 2261:getfield        #48  <Field double[][] U>
    // 1242 2264:iload           28
    // 1243 2266:aaload          
    // 1244 2267:iload           21
    // 1245 2269:daload          
    // 1246 2270:dmul            
    // 1247 2271:dload           24
    // 1248 2273:aload_0         
    // 1249 2274:getfield        #48  <Field double[][] U>
    // 1250 2277:iload           28
    // 1251 2279:aaload          
    // 1252 2280:iload           17
    // 1253 2282:iconst_1        
    // 1254 2283:isub            
    // 1255 2284:daload          
    // 1256 2285:dmul            
    // 1257 2286:dadd            
    // 1258 2287:dastore         
                            U[i][j] = t;
    // 1259 2288:aload_0         
    // 1260 2289:getfield        #48  <Field double[][] U>
    // 1261 2292:iload           28
    // 1262 2294:aaload          
    // 1263 2295:iload           21
    // 1264 2297:dload           22
    // 1265 2299:dastore         
                        }

    // 1266 2300:iinc            28  1
    // 1267 2303:iload           28
    // 1268 2305:aload_0         
    // 1269 2306:getfield        #32  <Field int m>
    // 1270 2309:icmplt          2215
                    }
                }

    // 1271 2312:iinc            21  1
    // 1272 2315:iload           21
    // 1273 2317:iload           10
    // 1274 2319:icmplt          2138
                break;
    // 1275 2322:goto            3400
            }

            case 3: // '\003'
            {
                double scale = Math.max(Math.max(Math.max(Math.max(Math.abs(s[p - 1]), Math.abs(s[p - 2])), Math.abs(e[p - 2])), Math.abs(s[k])), Math.abs(e[k]));
    // 1276 2325:aload_0         
    // 1277 2326:getfield        #45  <Field double[] s>
    // 1278 2329:iload           10
    // 1279 2331:iconst_1        
    // 1280 2332:isub            
    // 1281 2333:daload          
    // 1282 2334:invokestatic    #72  <Method double Math.abs(double)>
    // 1283 2337:aload_0         
    // 1284 2338:getfield        #45  <Field double[] s>
    // 1285 2341:iload           10
    // 1286 2343:iconst_2        
    // 1287 2344:isub            
    // 1288 2345:daload          
    // 1289 2346:invokestatic    #72  <Method double Math.abs(double)>
    // 1290 2349:invokestatic    #74  <Method double Math.max(double, double)>
    // 1291 2352:aload           4
    // 1292 2354:iload           10
    // 1293 2356:iconst_2        
    // 1294 2357:isub            
    // 1295 2358:daload          
    // 1296 2359:invokestatic    #72  <Method double Math.abs(double)>
    // 1297 2362:invokestatic    #74  <Method double Math.max(double, double)>
    // 1298 2365:aload_0         
    // 1299 2366:getfield        #45  <Field double[] s>
    // 1300 2369:iload           17
    // 1301 2371:daload          
    // 1302 2372:invokestatic    #72  <Method double Math.abs(double)>
    // 1303 2375:invokestatic    #74  <Method double Math.max(double, double)>
    // 1304 2378:aload           4
    // 1305 2380:iload           17
    // 1306 2382:daload          
    // 1307 2383:invokestatic    #72  <Method double Math.abs(double)>
    // 1308 2386:invokestatic    #74  <Method double Math.max(double, double)>
    // 1309 2389:dstore          19
                double sp = s[p - 1] / scale;
    // 1310 2391:aload_0         
    // 1311 2392:getfield        #45  <Field double[] s>
    // 1312 2395:iload           10
    // 1313 2397:iconst_1        
    // 1314 2398:isub            
    // 1315 2399:daload          
    // 1316 2400:dload           19
    // 1317 2402:ddiv            
    // 1318 2403:dstore          21
                double spm1 = s[p - 2] / scale;
    // 1319 2405:aload_0         
    // 1320 2406:getfield        #45  <Field double[] s>
    // 1321 2409:iload           10
    // 1322 2411:iconst_2        
    // 1323 2412:isub            
    // 1324 2413:daload          
    // 1325 2414:dload           19
    // 1326 2416:ddiv            
    // 1327 2417:dstore          23
                double epm1 = e[p - 2] / scale;
    // 1328 2419:aload           4
    // 1329 2421:iload           10
    // 1330 2423:iconst_2        
    // 1331 2424:isub            
    // 1332 2425:daload          
    // 1333 2426:dload           19
    // 1334 2428:ddiv            
    // 1335 2429:dstore          25
                double sk = s[k] / scale;
    // 1336 2431:aload_0         
    // 1337 2432:getfield        #45  <Field double[] s>
    // 1338 2435:iload           17
    // 1339 2437:daload          
    // 1340 2438:dload           19
    // 1341 2440:ddiv            
    // 1342 2441:dstore          27
                double ek = e[k] / scale;
    // 1343 2443:aload           4
    // 1344 2445:iload           17
    // 1345 2447:daload          
    // 1346 2448:dload           19
    // 1347 2450:ddiv            
    // 1348 2451:dstore          29
                double b = ((spm1 + sp) * (spm1 - sp) + epm1 * epm1) / 2D;
    // 1349 2453:dload           23
    // 1350 2455:dload           21
    // 1351 2457:dadd            
    // 1352 2458:dload           23
    // 1353 2460:dload           21
    // 1354 2462:dsub            
    // 1355 2463:dmul            
    // 1356 2464:dload           25
    // 1357 2466:dload           25
    // 1358 2468:dmul            
    // 1359 2469:dadd            
    // 1360 2470:ldc2w           #60  <Double 2D>
    // 1361 2473:ddiv            
    // 1362 2474:dstore          31
                double c = sp * epm1 * (sp * epm1);
    // 1363 2476:dload           21
    // 1364 2478:dload           25
    // 1365 2480:dmul            
    // 1366 2481:dload           21
    // 1367 2483:dload           25
    // 1368 2485:dmul            
    // 1369 2486:dmul            
    // 1370 2487:dstore          33
                double shift = 0.0D;
    // 1371 2489:dconst_0        
    // 1372 2490:dstore          35
                if((b != 0.0D) | (c != 0.0D))
    //*1373 2492:dload           31
    //*1374 2494:dconst_0        
    //*1375 2495:dcmpl           
    //*1376 2496:ifeq            2503
    //*1377 2499:iconst_1        
    //*1378 2500:goto            2504
    //*1379 2503:iconst_0        
    //*1380 2504:dload           33
    //*1381 2506:dconst_0        
    //*1382 2507:dcmpl           
    //*1383 2508:ifeq            2515
    //*1384 2511:iconst_1        
    //*1385 2512:goto            2516
    //*1386 2515:iconst_0        
    //*1387 2516:ior             
    //*1388 2517:ifeq            2555
                {
                    shift = Math.sqrt(b * b + c);
    // 1389 2520:dload           31
    // 1390 2522:dload           31
    // 1391 2524:dmul            
    // 1392 2525:dload           33
    // 1393 2527:dadd            
    // 1394 2528:invokestatic    #77  <Method double Math.sqrt(double)>
    // 1395 2531:dstore          35
                    if(b < 0.0D)
    //*1396 2533:dload           31
    //*1397 2535:dconst_0        
    //*1398 2536:dcmpg           
    //*1399 2537:ifge            2545
                        shift = -shift;
    // 1400 2540:dload           35
    // 1401 2542:dneg            
    // 1402 2543:dstore          35
                    shift = c / (b + shift);
    // 1403 2545:dload           33
    // 1404 2547:dload           31
    // 1405 2549:dload           35
    // 1406 2551:dadd            
    // 1407 2552:ddiv            
    // 1408 2553:dstore          35
                }
                double f = (sk + sp) * (sk - sp) + shift;
    // 1409 2555:dload           27
    // 1410 2557:dload           21
    // 1411 2559:dadd            
    // 1412 2560:dload           27
    // 1413 2562:dload           21
    // 1414 2564:dsub            
    // 1415 2565:dmul            
    // 1416 2566:dload           35
    // 1417 2568:dadd            
    // 1418 2569:dstore          37
                double g = sk * ek;
    // 1419 2571:dload           27
    // 1420 2573:dload           29
    // 1421 2575:dmul            
    // 1422 2576:dstore          39
                for(int j = k; j < p - 1; j++)
    //*1423 2578:iload           17
    //*1424 2580:istore          41
    //*1425 2582:goto            3049
                {
                    double t = Maths.hypot(f, g);
    // 1426 2585:dload           37
    // 1427 2587:dload           39
    // 1428 2589:invokestatic    #59  <Method double Maths.hypot(double, double)>
    // 1429 2592:dstore          42
                    double cs = f / t;
    // 1430 2594:dload           37
    // 1431 2596:dload           42
    // 1432 2598:ddiv            
    // 1433 2599:dstore          44
                    double sn = g / t;
    // 1434 2601:dload           39
    // 1435 2603:dload           42
    // 1436 2605:ddiv            
    // 1437 2606:dstore          46
                    if(j != k)
    //*1438 2608:iload           41
    //*1439 2610:iload           17
    //*1440 2612:icmpeq          2624
                        e[j - 1] = t;
    // 1441 2615:aload           4
    // 1442 2617:iload           41
    // 1443 2619:iconst_1        
    // 1444 2620:isub            
    // 1445 2621:dload           42
    // 1446 2623:dastore         
                    f = cs * s[j] + sn * e[j];
    // 1447 2624:dload           44
    // 1448 2626:aload_0         
    // 1449 2627:getfield        #45  <Field double[] s>
    // 1450 2630:iload           41
    // 1451 2632:daload          
    // 1452 2633:dmul            
    // 1453 2634:dload           46
    // 1454 2636:aload           4
    // 1455 2638:iload           41
    // 1456 2640:daload          
    // 1457 2641:dmul            
    // 1458 2642:dadd            
    // 1459 2643:dstore          37
                    e[j] = cs * e[j] - sn * s[j];
    // 1460 2645:aload           4
    // 1461 2647:iload           41
    // 1462 2649:dload           44
    // 1463 2651:aload           4
    // 1464 2653:iload           41
    // 1465 2655:daload          
    // 1466 2656:dmul            
    // 1467 2657:dload           46
    // 1468 2659:aload_0         
    // 1469 2660:getfield        #45  <Field double[] s>
    // 1470 2663:iload           41
    // 1471 2665:daload          
    // 1472 2666:dmul            
    // 1473 2667:dsub            
    // 1474 2668:dastore         
                    g = sn * s[j + 1];
    // 1475 2669:dload           46
    // 1476 2671:aload_0         
    // 1477 2672:getfield        #45  <Field double[] s>
    // 1478 2675:iload           41
    // 1479 2677:iconst_1        
    // 1480 2678:iadd            
    // 1481 2679:daload          
    // 1482 2680:dmul            
    // 1483 2681:dstore          39
                    s[j + 1] = cs * s[j + 1];
    // 1484 2683:aload_0         
    // 1485 2684:getfield        #45  <Field double[] s>
    // 1486 2687:iload           41
    // 1487 2689:iconst_1        
    // 1488 2690:iadd            
    // 1489 2691:dload           44
    // 1490 2693:aload_0         
    // 1491 2694:getfield        #45  <Field double[] s>
    // 1492 2697:iload           41
    // 1493 2699:iconst_1        
    // 1494 2700:iadd            
    // 1495 2701:daload          
    // 1496 2702:dmul            
    // 1497 2703:dastore         
                    if(wantv)
    //*1498 2704:iload           7
    //*1499 2706:ifeq            2812
                    {
                        for(int i = 0; i < n; i++)
    //*1500 2709:iconst_0        
    //*1501 2710:istore          48
    //*1502 2712:goto            2803
                        {
                            t = cs * V[i][j] + sn * V[i][j + 1];
    // 1503 2715:dload           44
    // 1504 2717:aload_0         
    // 1505 2718:getfield        #50  <Field double[][] V>
    // 1506 2721:iload           48
    // 1507 2723:aaload          
    // 1508 2724:iload           41
    // 1509 2726:daload          
    // 1510 2727:dmul            
    // 1511 2728:dload           46
    // 1512 2730:aload_0         
    // 1513 2731:getfield        #50  <Field double[][] V>
    // 1514 2734:iload           48
    // 1515 2736:aaload          
    // 1516 2737:iload           41
    // 1517 2739:iconst_1        
    // 1518 2740:iadd            
    // 1519 2741:daload          
    // 1520 2742:dmul            
    // 1521 2743:dadd            
    // 1522 2744:dstore          42
                            V[i][j + 1] = -sn * V[i][j] + cs * V[i][j + 1];
    // 1523 2746:aload_0         
    // 1524 2747:getfield        #50  <Field double[][] V>
    // 1525 2750:iload           48
    // 1526 2752:aaload          
    // 1527 2753:iload           41
    // 1528 2755:iconst_1        
    // 1529 2756:iadd            
    // 1530 2757:dload           46
    // 1531 2759:dneg            
    // 1532 2760:aload_0         
    // 1533 2761:getfield        #50  <Field double[][] V>
    // 1534 2764:iload           48
    // 1535 2766:aaload          
    // 1536 2767:iload           41
    // 1537 2769:daload          
    // 1538 2770:dmul            
    // 1539 2771:dload           44
    // 1540 2773:aload_0         
    // 1541 2774:getfield        #50  <Field double[][] V>
    // 1542 2777:iload           48
    // 1543 2779:aaload          
    // 1544 2780:iload           41
    // 1545 2782:iconst_1        
    // 1546 2783:iadd            
    // 1547 2784:daload          
    // 1548 2785:dmul            
    // 1549 2786:dadd            
    // 1550 2787:dastore         
                            V[i][j] = t;
    // 1551 2788:aload_0         
    // 1552 2789:getfield        #50  <Field double[][] V>
    // 1553 2792:iload           48
    // 1554 2794:aaload          
    // 1555 2795:iload           41
    // 1556 2797:dload           42
    // 1557 2799:dastore         
                        }

    // 1558 2800:iinc            48  1
    // 1559 2803:iload           48
    // 1560 2805:aload_0         
    // 1561 2806:getfield        #37  <Field int n>
    // 1562 2809:icmplt          2715
                    }
                    t = Maths.hypot(f, g);
    // 1563 2812:dload           37
    // 1564 2814:dload           39
    // 1565 2816:invokestatic    #59  <Method double Maths.hypot(double, double)>
    // 1566 2819:dstore          42
                    cs = f / t;
    // 1567 2821:dload           37
    // 1568 2823:dload           42
    // 1569 2825:ddiv            
    // 1570 2826:dstore          44
                    sn = g / t;
    // 1571 2828:dload           39
    // 1572 2830:dload           42
    // 1573 2832:ddiv            
    // 1574 2833:dstore          46
                    s[j] = t;
    // 1575 2835:aload_0         
    // 1576 2836:getfield        #45  <Field double[] s>
    // 1577 2839:iload           41
    // 1578 2841:dload           42
    // 1579 2843:dastore         
                    f = cs * e[j] + sn * s[j + 1];
    // 1580 2844:dload           44
    // 1581 2846:aload           4
    // 1582 2848:iload           41
    // 1583 2850:daload          
    // 1584 2851:dmul            
    // 1585 2852:dload           46
    // 1586 2854:aload_0         
    // 1587 2855:getfield        #45  <Field double[] s>
    // 1588 2858:iload           41
    // 1589 2860:iconst_1        
    // 1590 2861:iadd            
    // 1591 2862:daload          
    // 1592 2863:dmul            
    // 1593 2864:dadd            
    // 1594 2865:dstore          37
                    s[j + 1] = -sn * e[j] + cs * s[j + 1];
    // 1595 2867:aload_0         
    // 1596 2868:getfield        #45  <Field double[] s>
    // 1597 2871:iload           41
    // 1598 2873:iconst_1        
    // 1599 2874:iadd            
    // 1600 2875:dload           46
    // 1601 2877:dneg            
    // 1602 2878:aload           4
    // 1603 2880:iload           41
    // 1604 2882:daload          
    // 1605 2883:dmul            
    // 1606 2884:dload           44
    // 1607 2886:aload_0         
    // 1608 2887:getfield        #45  <Field double[] s>
    // 1609 2890:iload           41
    // 1610 2892:iconst_1        
    // 1611 2893:iadd            
    // 1612 2894:daload          
    // 1613 2895:dmul            
    // 1614 2896:dadd            
    // 1615 2897:dastore         
                    g = sn * e[j + 1];
    // 1616 2898:dload           46
    // 1617 2900:aload           4
    // 1618 2902:iload           41
    // 1619 2904:iconst_1        
    // 1620 2905:iadd            
    // 1621 2906:daload          
    // 1622 2907:dmul            
    // 1623 2908:dstore          39
                    e[j + 1] = cs * e[j + 1];
    // 1624 2910:aload           4
    // 1625 2912:iload           41
    // 1626 2914:iconst_1        
    // 1627 2915:iadd            
    // 1628 2916:dload           44
    // 1629 2918:aload           4
    // 1630 2920:iload           41
    // 1631 2922:iconst_1        
    // 1632 2923:iadd            
    // 1633 2924:daload          
    // 1634 2925:dmul            
    // 1635 2926:dastore         
                    if(wantu && j < m - 1)
    //*1636 2927:iload           6
    //*1637 2929:ifeq            3046
    //*1638 2932:iload           41
    //*1639 2934:aload_0         
    //*1640 2935:getfield        #32  <Field int m>
    //*1641 2938:iconst_1        
    //*1642 2939:isub            
    //*1643 2940:icmpge          3046
                    {
                        for(int i = 0; i < m; i++)
    //*1644 2943:iconst_0        
    //*1645 2944:istore          48
    //*1646 2946:goto            3037
                        {
                            t = cs * U[i][j] + sn * U[i][j + 1];
    // 1647 2949:dload           44
    // 1648 2951:aload_0         
    // 1649 2952:getfield        #48  <Field double[][] U>
    // 1650 2955:iload           48
    // 1651 2957:aaload          
    // 1652 2958:iload           41
    // 1653 2960:daload          
    // 1654 2961:dmul            
    // 1655 2962:dload           46
    // 1656 2964:aload_0         
    // 1657 2965:getfield        #48  <Field double[][] U>
    // 1658 2968:iload           48
    // 1659 2970:aaload          
    // 1660 2971:iload           41
    // 1661 2973:iconst_1        
    // 1662 2974:iadd            
    // 1663 2975:daload          
    // 1664 2976:dmul            
    // 1665 2977:dadd            
    // 1666 2978:dstore          42
                            U[i][j + 1] = -sn * U[i][j] + cs * U[i][j + 1];
    // 1667 2980:aload_0         
    // 1668 2981:getfield        #48  <Field double[][] U>
    // 1669 2984:iload           48
    // 1670 2986:aaload          
    // 1671 2987:iload           41
    // 1672 2989:iconst_1        
    // 1673 2990:iadd            
    // 1674 2991:dload           46
    // 1675 2993:dneg            
    // 1676 2994:aload_0         
    // 1677 2995:getfield        #48  <Field double[][] U>
    // 1678 2998:iload           48
    // 1679 3000:aaload          
    // 1680 3001:iload           41
    // 1681 3003:daload          
    // 1682 3004:dmul            
    // 1683 3005:dload           44
    // 1684 3007:aload_0         
    // 1685 3008:getfield        #48  <Field double[][] U>
    // 1686 3011:iload           48
    // 1687 3013:aaload          
    // 1688 3014:iload           41
    // 1689 3016:iconst_1        
    // 1690 3017:iadd            
    // 1691 3018:daload          
    // 1692 3019:dmul            
    // 1693 3020:dadd            
    // 1694 3021:dastore         
                            U[i][j] = t;
    // 1695 3022:aload_0         
    // 1696 3023:getfield        #48  <Field double[][] U>
    // 1697 3026:iload           48
    // 1698 3028:aaload          
    // 1699 3029:iload           41
    // 1700 3031:dload           42
    // 1701 3033:dastore         
                        }

    // 1702 3034:iinc            48  1
    // 1703 3037:iload           48
    // 1704 3039:aload_0         
    // 1705 3040:getfield        #32  <Field int m>
    // 1706 3043:icmplt          2949
                    }
                }

    // 1707 3046:iinc            41  1
    // 1708 3049:iload           41
    // 1709 3051:iload           10
    // 1710 3053:iconst_1        
    // 1711 3054:isub            
    // 1712 3055:icmplt          2585
                e[p - 2] = f;
    // 1713 3058:aload           4
    // 1714 3060:iload           10
    // 1715 3062:iconst_2        
    // 1716 3063:isub            
    // 1717 3064:dload           37
    // 1718 3066:dastore         
                iter++;
    // 1719 3067:iinc            12  1
                break;
    // 1720 3070:goto            3400
            }

            case 4: // '\004'
            {
                if(s[k] <= 0.0D)
    //*1721 3073:aload_0         
    //*1722 3074:getfield        #45  <Field double[] s>
    //*1723 3077:iload           17
    //*1724 3079:daload          
    //*1725 3080:dconst_0        
    //*1726 3081:dcmpg           
    //*1727 3082:ifgt            3387
                {
                    s[k] = s[k] >= 0.0D ? 0.0D : -s[k];
    // 1728 3085:aload_0         
    // 1729 3086:getfield        #45  <Field double[] s>
    // 1730 3089:iload           17
    // 1731 3091:aload_0         
    // 1732 3092:getfield        #45  <Field double[] s>
    // 1733 3095:iload           17
    // 1734 3097:daload          
    // 1735 3098:dconst_0        
    // 1736 3099:dcmpg           
    // 1737 3100:ifge            3114
    // 1738 3103:aload_0         
    // 1739 3104:getfield        #45  <Field double[] s>
    // 1740 3107:iload           17
    // 1741 3109:daload          
    // 1742 3110:dneg            
    // 1743 3111:goto            3115
    // 1744 3114:dconst_0        
    // 1745 3115:dastore         
                    if(wantv)
    //*1746 3116:iload           7
    //*1747 3118:ifeq            3387
                    {
                        for(int i = 0; i <= pp; i++)
    //*1748 3121:iconst_0        
    //*1749 3122:istore          19
    //*1750 3124:goto            3151
                            V[i][k] = -V[i][k];
    // 1751 3127:aload_0         
    // 1752 3128:getfield        #50  <Field double[][] V>
    // 1753 3131:iload           19
    // 1754 3133:aaload          
    // 1755 3134:iload           17
    // 1756 3136:aload_0         
    // 1757 3137:getfield        #50  <Field double[][] V>
    // 1758 3140:iload           19
    // 1759 3142:aaload          
    // 1760 3143:iload           17
    // 1761 3145:daload          
    // 1762 3146:dneg            
    // 1763 3147:dastore         

    // 1764 3148:iinc            19  1
    // 1765 3151:iload           19
    // 1766 3153:iload           11
    // 1767 3155:icmple          3127
                    }
                }
    //*1768 3158:goto            3387
                for(; k < pp; k++)
                {
                    if(s[k] >= s[k + 1])
    //*1769 3161:aload_0         
    //*1770 3162:getfield        #45  <Field double[] s>
    //*1771 3165:iload           17
    //*1772 3167:daload          
    //*1773 3168:aload_0         
    //*1774 3169:getfield        #45  <Field double[] s>
    //*1775 3172:iload           17
    //*1776 3174:iconst_1        
    //*1777 3175:iadd            
    //*1778 3176:daload          
    //*1779 3177:dcmpl           
    //*1780 3178:iflt            3184
                        break;
    // 1781 3181:goto            3394
                    double t = s[k];
    // 1782 3184:aload_0         
    // 1783 3185:getfield        #45  <Field double[] s>
    // 1784 3188:iload           17
    // 1785 3190:daload          
    // 1786 3191:dstore          19
                    s[k] = s[k + 1];
    // 1787 3193:aload_0         
    // 1788 3194:getfield        #45  <Field double[] s>
    // 1789 3197:iload           17
    // 1790 3199:aload_0         
    // 1791 3200:getfield        #45  <Field double[] s>
    // 1792 3203:iload           17
    // 1793 3205:iconst_1        
    // 1794 3206:iadd            
    // 1795 3207:daload          
    // 1796 3208:dastore         
                    s[k + 1] = t;
    // 1797 3209:aload_0         
    // 1798 3210:getfield        #45  <Field double[] s>
    // 1799 3213:iload           17
    // 1800 3215:iconst_1        
    // 1801 3216:iadd            
    // 1802 3217:dload           19
    // 1803 3219:dastore         
                    if(wantv && k < n - 1)
    //*1804 3220:iload           7
    //*1805 3222:ifeq            3302
    //*1806 3225:iload           17
    //*1807 3227:aload_0         
    //*1808 3228:getfield        #37  <Field int n>
    //*1809 3231:iconst_1        
    //*1810 3232:isub            
    //*1811 3233:icmpge          3302
                    {
                        for(int i = 0; i < n; i++)
    //*1812 3236:iconst_0        
    //*1813 3237:istore          21
    //*1814 3239:goto            3293
                        {
                            t = V[i][k + 1];
    // 1815 3242:aload_0         
    // 1816 3243:getfield        #50  <Field double[][] V>
    // 1817 3246:iload           21
    // 1818 3248:aaload          
    // 1819 3249:iload           17
    // 1820 3251:iconst_1        
    // 1821 3252:iadd            
    // 1822 3253:daload          
    // 1823 3254:dstore          19
                            V[i][k + 1] = V[i][k];
    // 1824 3256:aload_0         
    // 1825 3257:getfield        #50  <Field double[][] V>
    // 1826 3260:iload           21
    // 1827 3262:aaload          
    // 1828 3263:iload           17
    // 1829 3265:iconst_1        
    // 1830 3266:iadd            
    // 1831 3267:aload_0         
    // 1832 3268:getfield        #50  <Field double[][] V>
    // 1833 3271:iload           21
    // 1834 3273:aaload          
    // 1835 3274:iload           17
    // 1836 3276:daload          
    // 1837 3277:dastore         
                            V[i][k] = t;
    // 1838 3278:aload_0         
    // 1839 3279:getfield        #50  <Field double[][] V>
    // 1840 3282:iload           21
    // 1841 3284:aaload          
    // 1842 3285:iload           17
    // 1843 3287:dload           19
    // 1844 3289:dastore         
                        }

    // 1845 3290:iinc            21  1
    // 1846 3293:iload           21
    // 1847 3295:aload_0         
    // 1848 3296:getfield        #37  <Field int n>
    // 1849 3299:icmplt          3242
                    }
                    if(wantu && k < m - 1)
    //*1850 3302:iload           6
    //*1851 3304:ifeq            3384
    //*1852 3307:iload           17
    //*1853 3309:aload_0         
    //*1854 3310:getfield        #32  <Field int m>
    //*1855 3313:iconst_1        
    //*1856 3314:isub            
    //*1857 3315:icmpge          3384
                    {
                        for(int i = 0; i < m; i++)
    //*1858 3318:iconst_0        
    //*1859 3319:istore          21
    //*1860 3321:goto            3375
                        {
                            t = U[i][k + 1];
    // 1861 3324:aload_0         
    // 1862 3325:getfield        #48  <Field double[][] U>
    // 1863 3328:iload           21
    // 1864 3330:aaload          
    // 1865 3331:iload           17
    // 1866 3333:iconst_1        
    // 1867 3334:iadd            
    // 1868 3335:daload          
    // 1869 3336:dstore          19
                            U[i][k + 1] = U[i][k];
    // 1870 3338:aload_0         
    // 1871 3339:getfield        #48  <Field double[][] U>
    // 1872 3342:iload           21
    // 1873 3344:aaload          
    // 1874 3345:iload           17
    // 1875 3347:iconst_1        
    // 1876 3348:iadd            
    // 1877 3349:aload_0         
    // 1878 3350:getfield        #48  <Field double[][] U>
    // 1879 3353:iload           21
    // 1880 3355:aaload          
    // 1881 3356:iload           17
    // 1882 3358:daload          
    // 1883 3359:dastore         
                            U[i][k] = t;
    // 1884 3360:aload_0         
    // 1885 3361:getfield        #48  <Field double[][] U>
    // 1886 3364:iload           21
    // 1887 3366:aaload          
    // 1888 3367:iload           17
    // 1889 3369:dload           19
    // 1890 3371:dastore         
                        }

    // 1891 3372:iinc            21  1
    // 1892 3375:iload           21
    // 1893 3377:aload_0         
    // 1894 3378:getfield        #32  <Field int m>
    // 1895 3381:icmplt          3324
                    }
                }

    // 1896 3384:iinc            17  1
    // 1897 3387:iload           17
    // 1898 3389:iload           11
    // 1899 3391:icmplt          3161
                iter = 0;
    // 1900 3394:iconst_0        
    // 1901 3395:istore          12
                p--;
    // 1902 3397:iinc            10  -1
                break;
            }
            }
        }
    // 1903 3400:iload           10
    // 1904 3402:ifgt            1619
    // 1905 3405:return          
    }

    public Matrix getU()
    {
        return new Matrix(U, m, Math.min(m + 1, n));
    //    0    0:new             #22  <Class Matrix>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:getfield        #48  <Field double[][] U>
    //    4    8:aload_0         
    //    5    9:getfield        #32  <Field int m>
    //    6   12:aload_0         
    //    7   13:getfield        #32  <Field int m>
    //    8   16:iconst_1        
    //    9   17:iadd            
    //   10   18:aload_0         
    //   11   19:getfield        #37  <Field int n>
    //   12   22:invokestatic    #43  <Method int Math.min(int, int)>
    //   13   25:invokespecial   #122 <Method void Matrix(double[][], int, int)>
    //   14   28:areturn         
    }

    public Matrix getV()
    {
        return new Matrix(V, n, n);
    //    0    0:new             #22  <Class Matrix>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:getfield        #50  <Field double[][] V>
    //    4    8:aload_0         
    //    5    9:getfield        #37  <Field int n>
    //    6   12:aload_0         
    //    7   13:getfield        #37  <Field int n>
    //    8   16:invokespecial   #122 <Method void Matrix(double[][], int, int)>
    //    9   19:areturn         
    }

    public double[] getSingularValues()
    {
        return s;
    //    0    0:aload_0         
    //    1    1:getfield        #45  <Field double[] s>
    //    2    4:areturn         
    }

    public Matrix getS()
    {
        Matrix X = new Matrix(n, n);
    //    0    0:new             #22  <Class Matrix>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:getfield        #37  <Field int n>
    //    4    8:aload_0         
    //    5    9:getfield        #37  <Field int n>
    //    6   12:invokespecial   #129 <Method void Matrix(int, int)>
    //    7   15:astore_1        
        double S[][] = X.getArray();
    //    8   16:aload_1         
    //    9   17:invokevirtual   #132 <Method double[][] Matrix.getArray()>
    //   10   20:astore_2        
        for(int i = 0; i < n; i++)
    //*  11   21:iconst_0        
    //*  12   22:istore_3        
    //*  13   23:goto            65
        {
            for(int j = 0; j < n; j++)
    //*  14   26:iconst_0        
    //*  15   27:istore          4
    //*  16   29:goto            42
                S[i][j] = 0.0D;
    //   17   32:aload_2         
    //   18   33:iload_3         
    //   19   34:aaload          
    //   20   35:iload           4
    //   21   37:dconst_0        
    //   22   38:dastore         

    //   23   39:iinc            4  1
    //   24   42:iload           4
    //   25   44:aload_0         
    //   26   45:getfield        #37  <Field int n>
    //   27   48:icmplt          32
            S[i][i] = s[i];
    //   28   51:aload_2         
    //   29   52:iload_3         
    //   30   53:aaload          
    //   31   54:iload_3         
    //   32   55:aload_0         
    //   33   56:getfield        #45  <Field double[] s>
    //   34   59:iload_3         
    //   35   60:daload          
    //   36   61:dastore         
        }

    //   37   62:iinc            3  1
    //   38   65:iload_3         
    //   39   66:aload_0         
    //   40   67:getfield        #37  <Field int n>
    //   41   70:icmplt          26
        return X;
    //   42   73:aload_1         
    //   43   74:areturn         
    }

    public double norm2()
    {
        return s[0];
    //    0    0:aload_0         
    //    1    1:getfield        #45  <Field double[] s>
    //    2    4:iconst_0        
    //    3    5:daload          
    //    4    6:dreturn         
    }

    public double cond()
    {
        return s[0] / s[Math.min(m, n) - 1];
    //    0    0:aload_0         
    //    1    1:getfield        #45  <Field double[] s>
    //    2    4:iconst_0        
    //    3    5:daload          
    //    4    6:aload_0         
    //    5    7:getfield        #45  <Field double[] s>
    //    6   10:aload_0         
    //    7   11:getfield        #32  <Field int m>
    //    8   14:aload_0         
    //    9   15:getfield        #37  <Field int n>
    //   10   18:invokestatic    #43  <Method int Math.min(int, int)>
    //   11   21:iconst_1        
    //   12   22:isub            
    //   13   23:daload          
    //   14   24:ddiv            
    //   15   25:dreturn         
    }

    public int rank()
    {
        double eps = Math.pow(2D, -52D);
    //    0    0:ldc2w           #60  <Double 2D>
    //    1    3:ldc2w           #62  <Double -52D>
    //    2    6:invokestatic    #66  <Method double Math.pow(double, double)>
    //    3    9:dstore_1        
        double tol = (double)Math.max(m, n) * s[0] * eps;
    //    4   10:aload_0         
    //    5   11:getfield        #32  <Field int m>
    //    6   14:aload_0         
    //    7   15:getfield        #37  <Field int n>
    //    8   18:invokestatic    #53  <Method int Math.max(int, int)>
    //    9   21:i2d             
    //   10   22:aload_0         
    //   11   23:getfield        #45  <Field double[] s>
    //   12   26:iconst_0        
    //   13   27:daload          
    //   14   28:dmul            
    //   15   29:dload_1         
    //   16   30:dmul            
    //   17   31:dstore_3        
        int r = 0;
    //   18   32:iconst_0        
    //   19   33:istore          5
        for(int i = 0; i < s.length; i++)
    //*  20   35:iconst_0        
    //*  21   36:istore          6
    //*  22   38:goto            59
            if(s[i] > tol)
    //*  23   41:aload_0         
    //*  24   42:getfield        #45  <Field double[] s>
    //*  25   45:iload           6
    //*  26   47:daload          
    //*  27   48:dload_3         
    //*  28   49:dcmpl           
    //*  29   50:ifle            56
                r++;
    //   30   53:iinc            5  1

    //   31   56:iinc            6  1
    //   32   59:iload           6
    //   33   61:aload_0         
    //   34   62:getfield        #45  <Field double[] s>
    //   35   65:arraylength     
    //   36   66:icmplt          41
        return r;
    //   37   69:iload           5
    //   38   71:ireturn         
    }

    private double U[][];
    private double V[][];
    private double s[];
    private int m;
    private int n;
}
