// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   HPEdgeMinimization.java

package rm.rolemining;

import java.io.*;
import java.util.Iterator;
import java.util.Vector;
import rm.core.*;
import rm.core.converters.AssLoader;

// Referenced classes of package rm.rolemining:
//            HPRoleMinimization

public class HPEdgeMinimization extends HPRoleMinimization
{

    public HPEdgeMinimization()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #9   <Method void HPRoleMinimization()>
    //    2    4:return          
    }

    public void buildRoleminers(Assignment data)
        throws Exception
    {
        super.setShould(false);
    //    0    0:aload_0         
    //    1    1:iconst_0        
    //    2    2:invokespecial   #22  <Method void HPRoleMinimization.setShould(boolean)>
        super.buildRoleminers(data);
    //    3    5:aload_0         
    //    4    6:aload_1         
    //    5    7:invokespecial   #24  <Method void HPRoleMinimization.buildRoleminers(Assignment)>
        Vector subSet = new Vector();
    //    6   10:new             #26  <Class Vector>
    //    7   13:dup             
    //    8   14:invokespecial   #27  <Method void Vector()>
    //    9   17:astore_2        
        do
        {
            subSet.clear();
    //   10   18:aload_2         
    //   11   19:invokevirtual   #30  <Method void Vector.clear()>
            int indexSubSet = 0;
    //   12   22:iconst_0        
    //   13   23:istore_3        
            for(int index = 0; index < roles.size(); index++)
    //*  14   24:iconst_0        
    //*  15   25:istore          4
    //*  16   27:goto            386
            {
                for(int jndex = 0; jndex < roles.size(); jndex++)
    //*  17   30:iconst_0        
    //*  18   31:istore          5
    //*  19   33:goto            371
                    if(index != jndex)
    //*  20   36:iload           4
    //*  21   38:iload           5
    //*  22   40:icmpeq          368
                        if(((HPRoleMinimization.Role)roles.get(index)).getPerList().containsAll(((HPRoleMinimization.Role)roles.get(jndex)).getPerList()))
    //*  23   43:aload_0         
    //*  24   44:getfield        #34  <Field Vector roles>
    //*  25   47:iload           4
    //*  26   49:invokevirtual   #38  <Method Object Vector.get(int)>
    //*  27   52:checkcast       #40  <Class HPRoleMinimization$Role>
    //*  28   55:invokevirtual   #44  <Method Vector HPRoleMinimization$Role.getPerList()>
    //*  29   58:aload_0         
    //*  30   59:getfield        #34  <Field Vector roles>
    //*  31   62:iload           5
    //*  32   64:invokevirtual   #38  <Method Object Vector.get(int)>
    //*  33   67:checkcast       #40  <Class HPRoleMinimization$Role>
    //*  34   70:invokevirtual   #44  <Method Vector HPRoleMinimization$Role.getPerList()>
    //*  35   73:invokevirtual   #48  <Method boolean Vector.containsAll(java.util.Collection)>
    //*  36   76:ifeq            207
                        {
                            if(((HPRoleMinimization.Role)roles.get(jndex)).getPerList().size() > ((HPRoleMinimization.Role)roles.get(index)).getUseList().size())
    //*  37   79:aload_0         
    //*  38   80:getfield        #34  <Field Vector roles>
    //*  39   83:iload           5
    //*  40   85:invokevirtual   #38  <Method Object Vector.get(int)>
    //*  41   88:checkcast       #40  <Class HPRoleMinimization$Role>
    //*  42   91:invokevirtual   #44  <Method Vector HPRoleMinimization$Role.getPerList()>
    //*  43   94:invokevirtual   #52  <Method int Vector.size()>
    //*  44   97:aload_0         
    //*  45   98:getfield        #34  <Field Vector roles>
    //*  46  101:iload           4
    //*  47  103:invokevirtual   #38  <Method Object Vector.get(int)>
    //*  48  106:checkcast       #40  <Class HPRoleMinimization$Role>
    //*  49  109:invokevirtual   #55  <Method Vector HPRoleMinimization$Role.getUseList()>
    //*  50  112:invokevirtual   #52  <Method int Vector.size()>
    //*  51  115:icmple          368
                            {
                                int reduce = ((HPRoleMinimization.Role)roles.get(jndex)).getPerList().size() - ((HPRoleMinimization.Role)roles.get(index)).getUseList().size();
    //   52  118:aload_0         
    //   53  119:getfield        #34  <Field Vector roles>
    //   54  122:iload           5
    //   55  124:invokevirtual   #38  <Method Object Vector.get(int)>
    //   56  127:checkcast       #40  <Class HPRoleMinimization$Role>
    //   57  130:invokevirtual   #44  <Method Vector HPRoleMinimization$Role.getPerList()>
    //   58  133:invokevirtual   #52  <Method int Vector.size()>
    //   59  136:aload_0         
    //   60  137:getfield        #34  <Field Vector roles>
    //   61  140:iload           4
    //   62  142:invokevirtual   #38  <Method Object Vector.get(int)>
    //   63  145:checkcast       #40  <Class HPRoleMinimization$Role>
    //   64  148:invokevirtual   #55  <Method Vector HPRoleMinimization$Role.getUseList()>
    //   65  151:invokevirtual   #52  <Method int Vector.size()>
    //   66  154:isub            
    //   67  155:istore          6
                                HPRoleMinimization.FourTuples ft = new HPRoleMinimization.FourTuples(this);
    //   68  157:new             #57  <Class HPRoleMinimization$FourTuples>
    //   69  160:dup             
    //   70  161:aload_0         
    //   71  162:invokespecial   #60  <Method void HPRoleMinimization$FourTuples(HPRoleMinimization)>
    //   72  165:astore          7
                                ft.setReduce(reduce);
    //   73  167:aload           7
    //   74  169:iload           6
    //   75  171:invokevirtual   #64  <Method void HPRoleMinimization$FourTuples.setReduce(int)>
                                ft.setIndex(index);
    //   76  174:aload           7
    //   77  176:iload           4
    //   78  178:invokevirtual   #67  <Method void HPRoleMinimization$FourTuples.setIndex(int)>
                                ft.setJndex(jndex);
    //   79  181:aload           7
    //   80  183:iload           5
    //   81  185:invokevirtual   #70  <Method void HPRoleMinimization$FourTuples.setJndex(int)>
                                ft.setOrder(1);
    //   82  188:aload           7
    //   83  190:iconst_1        
    //   84  191:invokevirtual   #73  <Method void HPRoleMinimization$FourTuples.setOrder(int)>
                                subSet.add(indexSubSet++, ft);
    //   85  194:aload_2         
    //   86  195:iload_3         
    //   87  196:iinc            3  1
    //   88  199:aload           7
    //   89  201:invokevirtual   #77  <Method void Vector.add(int, Object)>
                            }
                        } else
    //*  90  204:goto            368
                        if(((HPRoleMinimization.Role)roles.get(jndex)).getPerList().containsAll(((HPRoleMinimization.Role)roles.get(index)).getPerList()) && ((HPRoleMinimization.Role)roles.get(index)).getPerList().size() > ((HPRoleMinimization.Role)roles.get(jndex)).getUseList().size())
    //*  91  207:aload_0         
    //*  92  208:getfield        #34  <Field Vector roles>
    //*  93  211:iload           5
    //*  94  213:invokevirtual   #38  <Method Object Vector.get(int)>
    //*  95  216:checkcast       #40  <Class HPRoleMinimization$Role>
    //*  96  219:invokevirtual   #44  <Method Vector HPRoleMinimization$Role.getPerList()>
    //*  97  222:aload_0         
    //*  98  223:getfield        #34  <Field Vector roles>
    //*  99  226:iload           4
    //* 100  228:invokevirtual   #38  <Method Object Vector.get(int)>
    //* 101  231:checkcast       #40  <Class HPRoleMinimization$Role>
    //* 102  234:invokevirtual   #44  <Method Vector HPRoleMinimization$Role.getPerList()>
    //* 103  237:invokevirtual   #48  <Method boolean Vector.containsAll(java.util.Collection)>
    //* 104  240:ifeq            368
    //* 105  243:aload_0         
    //* 106  244:getfield        #34  <Field Vector roles>
    //* 107  247:iload           4
    //* 108  249:invokevirtual   #38  <Method Object Vector.get(int)>
    //* 109  252:checkcast       #40  <Class HPRoleMinimization$Role>
    //* 110  255:invokevirtual   #44  <Method Vector HPRoleMinimization$Role.getPerList()>
    //* 111  258:invokevirtual   #52  <Method int Vector.size()>
    //* 112  261:aload_0         
    //* 113  262:getfield        #34  <Field Vector roles>
    //* 114  265:iload           5
    //* 115  267:invokevirtual   #38  <Method Object Vector.get(int)>
    //* 116  270:checkcast       #40  <Class HPRoleMinimization$Role>
    //* 117  273:invokevirtual   #55  <Method Vector HPRoleMinimization$Role.getUseList()>
    //* 118  276:invokevirtual   #52  <Method int Vector.size()>
    //* 119  279:icmple          368
                        {
                            int reduce = ((HPRoleMinimization.Role)roles.get(index)).getPerList().size() - ((HPRoleMinimization.Role)roles.get(jndex)).getUseList().size();
    //  120  282:aload_0         
    //  121  283:getfield        #34  <Field Vector roles>
    //  122  286:iload           4
    //  123  288:invokevirtual   #38  <Method Object Vector.get(int)>
    //  124  291:checkcast       #40  <Class HPRoleMinimization$Role>
    //  125  294:invokevirtual   #44  <Method Vector HPRoleMinimization$Role.getPerList()>
    //  126  297:invokevirtual   #52  <Method int Vector.size()>
    //  127  300:aload_0         
    //  128  301:getfield        #34  <Field Vector roles>
    //  129  304:iload           5
    //  130  306:invokevirtual   #38  <Method Object Vector.get(int)>
    //  131  309:checkcast       #40  <Class HPRoleMinimization$Role>
    //  132  312:invokevirtual   #55  <Method Vector HPRoleMinimization$Role.getUseList()>
    //  133  315:invokevirtual   #52  <Method int Vector.size()>
    //  134  318:isub            
    //  135  319:istore          6
                            HPRoleMinimization.FourTuples ft = new HPRoleMinimization.FourTuples(this);
    //  136  321:new             #57  <Class HPRoleMinimization$FourTuples>
    //  137  324:dup             
    //  138  325:aload_0         
    //  139  326:invokespecial   #60  <Method void HPRoleMinimization$FourTuples(HPRoleMinimization)>
    //  140  329:astore          7
                            ft.setReduce(reduce);
    //  141  331:aload           7
    //  142  333:iload           6
    //  143  335:invokevirtual   #64  <Method void HPRoleMinimization$FourTuples.setReduce(int)>
                            ft.setIndex(index);
    //  144  338:aload           7
    //  145  340:iload           4
    //  146  342:invokevirtual   #67  <Method void HPRoleMinimization$FourTuples.setIndex(int)>
                            ft.setJndex(jndex);
    //  147  345:aload           7
    //  148  347:iload           5
    //  149  349:invokevirtual   #70  <Method void HPRoleMinimization$FourTuples.setJndex(int)>
                            ft.setOrder(0);
    //  150  352:aload           7
    //  151  354:iconst_0        
    //  152  355:invokevirtual   #73  <Method void HPRoleMinimization$FourTuples.setOrder(int)>
                            subSet.add(indexSubSet++, ft);
    //  153  358:aload_2         
    //  154  359:iload_3         
    //  155  360:iinc            3  1
    //  156  363:aload           7
    //  157  365:invokevirtual   #77  <Method void Vector.add(int, Object)>
                        }

    //  158  368:iinc            5  1
    //  159  371:iload           5
    //  160  373:aload_0         
    //  161  374:getfield        #34  <Field Vector roles>
    //  162  377:invokevirtual   #52  <Method int Vector.size()>
    //  163  380:icmplt          36
            }

    //  164  383:iinc            4  1
    //  165  386:iload           4
    //  166  388:aload_0         
    //  167  389:getfield        #34  <Field Vector roles>
    //  168  392:invokevirtual   #52  <Method int Vector.size()>
    //  169  395:icmplt          30
            int indexReduce = getMaxReduce(subSet);
    //  170  398:aload_0         
    //  171  399:aload_2         
    //  172  400:invokespecial   #81  <Method int getMaxReduce(Vector)>
    //  173  403:istore          4
            if(indexReduce > data.getAssignmentMatrix().getRowDimension())
    //* 174  405:iload           4
    //* 175  407:aload_1         
    //* 176  408:invokevirtual   #87  <Method Matrix Assignment.getAssignmentMatrix()>
    //* 177  411:invokevirtual   #92  <Method int Matrix.getRowDimension()>
    //* 178  414:icmple          420
                break;
    //  179  417:goto            455
            WSC -= ((HPRoleMinimization.FourTuples)subSet.get(indexReduce)).getReduce();
    //  180  420:aload_0         
    //  181  421:dup             
    //  182  422:getfield        #96  <Field int WSC>
    //  183  425:aload_2         
    //  184  426:iload           4
    //  185  428:invokevirtual   #38  <Method Object Vector.get(int)>
    //  186  431:checkcast       #57  <Class HPRoleMinimization$FourTuples>
    //  187  434:invokevirtual   #99  <Method int HPRoleMinimization$FourTuples.getReduce()>
    //  188  437:isub            
    //  189  438:putfield        #96  <Field int WSC>
            updateRoleState(subSet, indexReduce);
    //  190  441:aload_0         
    //  191  442:aload_2         
    //  192  443:iload           4
    //  193  445:invokespecial   #103 <Method void updateRoleState(Vector, int)>
        } while(subSet.size() != 0);
    //  194  448:aload_2         
    //  195  449:invokevirtual   #52  <Method int Vector.size()>
    //  196  452:ifne            18
        Vector intersectSet = new Vector();
    //  197  455:new             #26  <Class Vector>
    //  198  458:dup             
    //  199  459:invokespecial   #27  <Method void Vector()>
    //  200  462:astore_3        
        do
        {
            intersectSet.clear();
    //  201  463:aload_3         
    //  202  464:invokevirtual   #30  <Method void Vector.clear()>
            int indexIntersectSet = 0;
    //  203  467:iconst_0        
    //  204  468:istore          4
            for(int index = 0; index < roles.size(); index++)
    //* 205  470:iconst_0        
    //* 206  471:istore          5
    //* 207  473:goto            653
            {
                for(int jndex = 0; jndex < roles.size(); jndex++)
    //* 208  476:iconst_0        
    //* 209  477:istore          6
    //* 210  479:goto            638
                    if(index != jndex)
    //* 211  482:iload           5
    //* 212  484:iload           6
    //* 213  486:icmpeq          635
                    {
                        Vector commonPermissions = intersectRoles((HPRoleMinimization.Role)roles.get(index), (HPRoleMinimization.Role)roles.get(jndex));
    //  214  489:aload_0         
    //  215  490:aload_0         
    //  216  491:getfield        #34  <Field Vector roles>
    //  217  494:iload           5
    //  218  496:invokevirtual   #38  <Method Object Vector.get(int)>
    //  219  499:checkcast       #40  <Class HPRoleMinimization$Role>
    //  220  502:aload_0         
    //  221  503:getfield        #34  <Field Vector roles>
    //  222  506:iload           6
    //  223  508:invokevirtual   #38  <Method Object Vector.get(int)>
    //  224  511:checkcast       #40  <Class HPRoleMinimization$Role>
    //  225  514:invokespecial   #107 <Method Vector intersectRoles(HPRoleMinimization$Role, HPRoleMinimization$Role)>
    //  226  517:astore          7
                        if(commonPermissions.size() > 0)
    //* 227  519:aload           7
    //* 228  521:invokevirtual   #52  <Method int Vector.size()>
    //* 229  524:ifle            635
                        {
                            Vector allUsers = getAllUsers((HPRoleMinimization.Role)roles.get(index), (HPRoleMinimization.Role)roles.get(jndex));
    //  230  527:aload_0         
    //  231  528:aload_0         
    //  232  529:getfield        #34  <Field Vector roles>
    //  233  532:iload           5
    //  234  534:invokevirtual   #38  <Method Object Vector.get(int)>
    //  235  537:checkcast       #40  <Class HPRoleMinimization$Role>
    //  236  540:aload_0         
    //  237  541:getfield        #34  <Field Vector roles>
    //  238  544:iload           6
    //  239  546:invokevirtual   #38  <Method Object Vector.get(int)>
    //  240  549:checkcast       #40  <Class HPRoleMinimization$Role>
    //  241  552:invokespecial   #110 <Method Vector getAllUsers(HPRoleMinimization$Role, HPRoleMinimization$Role)>
    //  242  555:astore          8
                            if(allUsers.size() + 1 < commonPermissions.size())
    //* 243  557:aload           8
    //* 244  559:invokevirtual   #52  <Method int Vector.size()>
    //* 245  562:iconst_1        
    //* 246  563:iadd            
    //* 247  564:aload           7
    //* 248  566:invokevirtual   #52  <Method int Vector.size()>
    //* 249  569:icmpge          635
                            {
                                int reduce = commonPermissions.size() - allUsers.size() - 1;
    //  250  572:aload           7
    //  251  574:invokevirtual   #52  <Method int Vector.size()>
    //  252  577:aload           8
    //  253  579:invokevirtual   #52  <Method int Vector.size()>
    //  254  582:isub            
    //  255  583:iconst_1        
    //  256  584:isub            
    //  257  585:istore          9
                                HPRoleMinimization.FourTuples ft = new HPRoleMinimization.FourTuples(this);
    //  258  587:new             #57  <Class HPRoleMinimization$FourTuples>
    //  259  590:dup             
    //  260  591:aload_0         
    //  261  592:invokespecial   #60  <Method void HPRoleMinimization$FourTuples(HPRoleMinimization)>
    //  262  595:astore          10
                                ft.setReduce(reduce);
    //  263  597:aload           10
    //  264  599:iload           9
    //  265  601:invokevirtual   #64  <Method void HPRoleMinimization$FourTuples.setReduce(int)>
                                ft.setIndex(index);
    //  266  604:aload           10
    //  267  606:iload           5
    //  268  608:invokevirtual   #67  <Method void HPRoleMinimization$FourTuples.setIndex(int)>
                                ft.setJndex(jndex);
    //  269  611:aload           10
    //  270  613:iload           6
    //  271  615:invokevirtual   #70  <Method void HPRoleMinimization$FourTuples.setJndex(int)>
                                ft.setOrder(2);
    //  272  618:aload           10
    //  273  620:iconst_2        
    //  274  621:invokevirtual   #73  <Method void HPRoleMinimization$FourTuples.setOrder(int)>
                                intersectSet.add(indexIntersectSet++, ft);
    //  275  624:aload_3         
    //  276  625:iload           4
    //  277  627:iinc            4  1
    //  278  630:aload           10
    //  279  632:invokevirtual   #77  <Method void Vector.add(int, Object)>
                            }
                        }
                    }

    //  280  635:iinc            6  1
    //  281  638:iload           6
    //  282  640:aload_0         
    //  283  641:getfield        #34  <Field Vector roles>
    //  284  644:invokevirtual   #52  <Method int Vector.size()>
    //  285  647:icmplt          482
            }

    //  286  650:iinc            5  1
    //  287  653:iload           5
    //  288  655:aload_0         
    //  289  656:getfield        #34  <Field Vector roles>
    //  290  659:invokevirtual   #52  <Method int Vector.size()>
    //  291  662:icmplt          476
            int indexMaxReduce = getMaxReduce(intersectSet);
    //  292  665:aload_0         
    //  293  666:aload_3         
    //  294  667:invokespecial   #81  <Method int getMaxReduce(Vector)>
    //  295  670:istore          5
            if(indexMaxReduce > data.getAssignmentMatrix().getRowDimension())
    //* 296  672:iload           5
    //* 297  674:aload_1         
    //* 298  675:invokevirtual   #87  <Method Matrix Assignment.getAssignmentMatrix()>
    //* 299  678:invokevirtual   #92  <Method int Matrix.getRowDimension()>
    //* 300  681:icmple          687
                break;
    //  301  684:goto            722
            WSC -= ((HPRoleMinimization.FourTuples)intersectSet.get(indexMaxReduce)).getReduce();
    //  302  687:aload_0         
    //  303  688:dup             
    //  304  689:getfield        #96  <Field int WSC>
    //  305  692:aload_3         
    //  306  693:iload           5
    //  307  695:invokevirtual   #38  <Method Object Vector.get(int)>
    //  308  698:checkcast       #57  <Class HPRoleMinimization$FourTuples>
    //  309  701:invokevirtual   #99  <Method int HPRoleMinimization$FourTuples.getReduce()>
    //  310  704:isub            
    //  311  705:putfield        #96  <Field int WSC>
            updateRoleState(intersectSet, indexMaxReduce);
    //  312  708:aload_0         
    //  313  709:aload_3         
    //  314  710:iload           5
    //  315  712:invokespecial   #103 <Method void updateRoleState(Vector, int)>
        } while(intersectSet.size() != 0);
    //  316  715:aload_3         
    //  317  716:invokevirtual   #52  <Method int Vector.size()>
    //  318  719:ifne            463
        printRoleandWSC(roles, WSC);
    //  319  722:aload_0         
    //  320  723:aload_0         
    //  321  724:getfield        #34  <Field Vector roles>
    //  322  727:aload_0         
    //  323  728:getfield        #96  <Field int WSC>
    //  324  731:invokespecial   #113 <Method void printRoleandWSC(Vector, int)>
    //  325  734:return          
    }

    private void printRoleandWSC(Vector roles2, int wsc2)
    {
        log.append("\n--------------------------------------------------------");
    //    0    0:aload_0         
    //    1    1:getfield        #137 <Field StringBuffer log>
    //    2    4:ldc1            #139 <String "\n--------------------------------------------------------">
    //    3    6:invokevirtual   #145 <Method StringBuffer StringBuffer.append(String)>
    //    4    9:pop             
        for(int indexRole = 0; indexRole < roles2.size(); indexRole++)
    //*   5   10:iconst_0        
    //*   6   11:istore_3        
    //*   7   12:goto            285
        {
            HPRoleMinimization.Role role = (HPRoleMinimization.Role)roles2.get(indexRole);
    //    8   15:aload_1         
    //    9   16:iload_3         
    //   10   17:invokevirtual   #38  <Method Object Vector.get(int)>
    //   11   20:checkcast       #40  <Class HPRoleMinimization$Role>
    //   12   23:astore          4
            log.append((new StringBuilder("\nThe users of role")).append(indexRole).append(" are: \n").toString());
    //   13   25:aload_0         
    //   14   26:getfield        #137 <Field StringBuffer log>
    //   15   29:new             #147 <Class StringBuilder>
    //   16   32:dup             
    //   17   33:ldc1            #149 <String "\nThe users of role">
    //   18   35:invokespecial   #152 <Method void StringBuilder(String)>
    //   19   38:iload_3         
    //   20   39:invokevirtual   #155 <Method StringBuilder StringBuilder.append(int)>
    //   21   42:ldc1            #157 <String " are: \n">
    //   22   44:invokevirtual   #160 <Method StringBuilder StringBuilder.append(String)>
    //   23   47:invokevirtual   #164 <Method String StringBuilder.toString()>
    //   24   50:invokevirtual   #145 <Method StringBuffer StringBuffer.append(String)>
    //   25   53:pop             
            for(int index = 0; index < role.getUseList().size(); index++)
    //*  26   54:iconst_0        
    //*  27   55:istore          5
    //*  28   57:goto            159
                if(index != role.getUseList().size() - 1)
    //*  29   60:iload           5
    //*  30   62:aload           4
    //*  31   64:invokevirtual   #55  <Method Vector HPRoleMinimization$Role.getUseList()>
    //*  32   67:invokevirtual   #52  <Method int Vector.size()>
    //*  33   70:iconst_1        
    //*  34   71:isub            
    //*  35   72:icmpeq          117
                    log.append((new StringBuilder(String.valueOf((String)role.getUseList().get(index)))).append(", ").toString());
    //   36   75:aload_0         
    //   37   76:getfield        #137 <Field StringBuffer log>
    //   38   79:new             #147 <Class StringBuilder>
    //   39   82:dup             
    //   40   83:aload           4
    //   41   85:invokevirtual   #55  <Method Vector HPRoleMinimization$Role.getUseList()>
    //   42   88:iload           5
    //   43   90:invokevirtual   #38  <Method Object Vector.get(int)>
    //   44   93:checkcast       #166 <Class String>
    //   45   96:invokestatic    #170 <Method String String.valueOf(Object)>
    //   46   99:invokespecial   #152 <Method void StringBuilder(String)>
    //   47  102:ldc1            #172 <String ", ">
    //   48  104:invokevirtual   #160 <Method StringBuilder StringBuilder.append(String)>
    //   49  107:invokevirtual   #164 <Method String StringBuilder.toString()>
    //   50  110:invokevirtual   #145 <Method StringBuffer StringBuffer.append(String)>
    //   51  113:pop             
                else
    //*  52  114:goto            156
                    log.append((new StringBuilder(String.valueOf((String)role.getUseList().get(index)))).append("\n").toString());
    //   53  117:aload_0         
    //   54  118:getfield        #137 <Field StringBuffer log>
    //   55  121:new             #147 <Class StringBuilder>
    //   56  124:dup             
    //   57  125:aload           4
    //   58  127:invokevirtual   #55  <Method Vector HPRoleMinimization$Role.getUseList()>
    //   59  130:iload           5
    //   60  132:invokevirtual   #38  <Method Object Vector.get(int)>
    //   61  135:checkcast       #166 <Class String>
    //   62  138:invokestatic    #170 <Method String String.valueOf(Object)>
    //   63  141:invokespecial   #152 <Method void StringBuilder(String)>
    //   64  144:ldc1            #174 <String "\n">
    //   65  146:invokevirtual   #160 <Method StringBuilder StringBuilder.append(String)>
    //   66  149:invokevirtual   #164 <Method String StringBuilder.toString()>
    //   67  152:invokevirtual   #145 <Method StringBuffer StringBuffer.append(String)>
    //   68  155:pop             

    //   69  156:iinc            5  1
    //   70  159:iload           5
    //   71  161:aload           4
    //   72  163:invokevirtual   #55  <Method Vector HPRoleMinimization$Role.getUseList()>
    //   73  166:invokevirtual   #52  <Method int Vector.size()>
    //   74  169:icmplt          60
            log.append("The permissions are: \n");
    //   75  172:aload_0         
    //   76  173:getfield        #137 <Field StringBuffer log>
    //   77  176:ldc1            #176 <String "The permissions are: \n">
    //   78  178:invokevirtual   #145 <Method StringBuffer StringBuffer.append(String)>
    //   79  181:pop             
            for(int index = 0; index < role.getPerList().size(); index++)
    //*  80  182:iconst_0        
    //*  81  183:istore          5
    //*  82  185:goto            269
                if(index != role.getPerList().size() - 1)
    //*  83  188:iload           5
    //*  84  190:aload           4
    //*  85  192:invokevirtual   #44  <Method Vector HPRoleMinimization$Role.getPerList()>
    //*  86  195:invokevirtual   #52  <Method int Vector.size()>
    //*  87  198:iconst_1        
    //*  88  199:isub            
    //*  89  200:icmpeq          245
                    log.append((new StringBuilder(String.valueOf((String)role.getPerList().get(index)))).append(", ").toString());
    //   90  203:aload_0         
    //   91  204:getfield        #137 <Field StringBuffer log>
    //   92  207:new             #147 <Class StringBuilder>
    //   93  210:dup             
    //   94  211:aload           4
    //   95  213:invokevirtual   #44  <Method Vector HPRoleMinimization$Role.getPerList()>
    //   96  216:iload           5
    //   97  218:invokevirtual   #38  <Method Object Vector.get(int)>
    //   98  221:checkcast       #166 <Class String>
    //   99  224:invokestatic    #170 <Method String String.valueOf(Object)>
    //  100  227:invokespecial   #152 <Method void StringBuilder(String)>
    //  101  230:ldc1            #172 <String ", ">
    //  102  232:invokevirtual   #160 <Method StringBuilder StringBuilder.append(String)>
    //  103  235:invokevirtual   #164 <Method String StringBuilder.toString()>
    //  104  238:invokevirtual   #145 <Method StringBuffer StringBuffer.append(String)>
    //  105  241:pop             
                else
    //* 106  242:goto            266
                    log.append((String)role.getPerList().get(index));
    //  107  245:aload_0         
    //  108  246:getfield        #137 <Field StringBuffer log>
    //  109  249:aload           4
    //  110  251:invokevirtual   #44  <Method Vector HPRoleMinimization$Role.getPerList()>
    //  111  254:iload           5
    //  112  256:invokevirtual   #38  <Method Object Vector.get(int)>
    //  113  259:checkcast       #166 <Class String>
    //  114  262:invokevirtual   #145 <Method StringBuffer StringBuffer.append(String)>
    //  115  265:pop             

    //  116  266:iinc            5  1
    //  117  269:iload           5
    //  118  271:aload           4
    //  119  273:invokevirtual   #44  <Method Vector HPRoleMinimization$Role.getPerList()>
    //  120  276:invokevirtual   #52  <Method int Vector.size()>
    //  121  279:icmplt          188
        }

    //  122  282:iinc            3  1
    //  123  285:iload_3         
    //  124  286:aload_1         
    //  125  287:invokevirtual   #52  <Method int Vector.size()>
    //  126  290:icmplt          15
        log.append("\n--------------------------------------------------------\n");
    //  127  293:aload_0         
    //  128  294:getfield        #137 <Field StringBuffer log>
    //  129  297:ldc1            #178 <String "\n--------------------------------------------------------\n">
    //  130  299:invokevirtual   #145 <Method StringBuffer StringBuffer.append(String)>
    //  131  302:pop             
    //  132  303:return          
    }

    private void updateRoleState(Vector subSet, int indexReduce)
    {
        HPRoleMinimization.FourTuples ft = (HPRoleMinimization.FourTuples)subSet.get(indexReduce);
    //    0    0:aload_1         
    //    1    1:iload_2         
    //    2    2:invokevirtual   #38  <Method Object Vector.get(int)>
    //    3    5:checkcast       #57  <Class HPRoleMinimization$FourTuples>
    //    4    8:astore_3        
        if(ft.getOrder() == 0)
    //*   5    9:aload_3         
    //*   6   10:invokevirtual   #188 <Method int HPRoleMinimization$FourTuples.getOrder()>
    //*   7   13:ifne            43
        {
            reducePermissions(ft.getIndex(), ft.getJndex());
    //    8   16:aload_0         
    //    9   17:aload_3         
    //   10   18:invokevirtual   #191 <Method int HPRoleMinimization$FourTuples.getIndex()>
    //   11   21:aload_3         
    //   12   22:invokevirtual   #194 <Method int HPRoleMinimization$FourTuples.getJndex()>
    //   13   25:invokespecial   #198 <Method void reducePermissions(int, int)>
            updateRoleSet(ft.getIndex(), ft.getJndex());
    //   14   28:aload_0         
    //   15   29:aload_3         
    //   16   30:invokevirtual   #191 <Method int HPRoleMinimization$FourTuples.getIndex()>
    //   17   33:aload_3         
    //   18   34:invokevirtual   #194 <Method int HPRoleMinimization$FourTuples.getJndex()>
    //   19   37:invokespecial   #201 <Method void updateRoleSet(int, int)>
        } else
    //*  20   40:goto            233
        if(ft.getOrder() == 1)
    //*  21   43:aload_3         
    //*  22   44:invokevirtual   #188 <Method int HPRoleMinimization$FourTuples.getOrder()>
    //*  23   47:iconst_1        
    //*  24   48:icmpne          78
        {
            reducePermissions(ft.getJndex(), ft.getIndex());
    //   25   51:aload_0         
    //   26   52:aload_3         
    //   27   53:invokevirtual   #194 <Method int HPRoleMinimization$FourTuples.getJndex()>
    //   28   56:aload_3         
    //   29   57:invokevirtual   #191 <Method int HPRoleMinimization$FourTuples.getIndex()>
    //   30   60:invokespecial   #198 <Method void reducePermissions(int, int)>
            updateRoleSet(ft.getJndex(), ft.getIndex());
    //   31   63:aload_0         
    //   32   64:aload_3         
    //   33   65:invokevirtual   #194 <Method int HPRoleMinimization$FourTuples.getJndex()>
    //   34   68:aload_3         
    //   35   69:invokevirtual   #191 <Method int HPRoleMinimization$FourTuples.getIndex()>
    //   36   72:invokespecial   #201 <Method void updateRoleSet(int, int)>
        } else
    //*  37   75:goto            233
        {
            HPRoleMinimization.Role role = new HPRoleMinimization.Role(this);
    //   38   78:new             #40  <Class HPRoleMinimization$Role>
    //   39   81:dup             
    //   40   82:aload_0         
    //   41   83:invokespecial   #202 <Method void HPRoleMinimization$Role(HPRoleMinimization)>
    //   42   86:astore          4
            role.setRoleName((new StringBuilder("role")).append(numberOfRoles).toString());
    //   43   88:aload           4
    //   44   90:new             #147 <Class StringBuilder>
    //   45   93:dup             
    //   46   94:ldc1            #203 <String "role">
    //   47   96:invokespecial   #152 <Method void StringBuilder(String)>
    //   48   99:aload_0         
    //   49  100:getfield        #206 <Field int numberOfRoles>
    //   50  103:invokevirtual   #155 <Method StringBuilder StringBuilder.append(int)>
    //   51  106:invokevirtual   #164 <Method String StringBuilder.toString()>
    //   52  109:invokevirtual   #209 <Method void HPRoleMinimization$Role.setRoleName(String)>
            role.setUseList(getAllUsers((HPRoleMinimization.Role)roles.get(ft.getIndex()), (HPRoleMinimization.Role)roles.get(ft.getJndex())));
    //   53  112:aload           4
    //   54  114:aload_0         
    //   55  115:aload_0         
    //   56  116:getfield        #34  <Field Vector roles>
    //   57  119:aload_3         
    //   58  120:invokevirtual   #191 <Method int HPRoleMinimization$FourTuples.getIndex()>
    //   59  123:invokevirtual   #38  <Method Object Vector.get(int)>
    //   60  126:checkcast       #40  <Class HPRoleMinimization$Role>
    //   61  129:aload_0         
    //   62  130:getfield        #34  <Field Vector roles>
    //   63  133:aload_3         
    //   64  134:invokevirtual   #194 <Method int HPRoleMinimization$FourTuples.getJndex()>
    //   65  137:invokevirtual   #38  <Method Object Vector.get(int)>
    //   66  140:checkcast       #40  <Class HPRoleMinimization$Role>
    //   67  143:invokespecial   #110 <Method Vector getAllUsers(HPRoleMinimization$Role, HPRoleMinimization$Role)>
    //   68  146:invokevirtual   #213 <Method void HPRoleMinimization$Role.setUseList(Vector)>
            role.setPerList(intersectRoles((HPRoleMinimization.Role)roles.get(ft.getIndex()), (HPRoleMinimization.Role)roles.get(ft.getJndex())));
    //   69  149:aload           4
    //   70  151:aload_0         
    //   71  152:aload_0         
    //   72  153:getfield        #34  <Field Vector roles>
    //   73  156:aload_3         
    //   74  157:invokevirtual   #191 <Method int HPRoleMinimization$FourTuples.getIndex()>
    //   75  160:invokevirtual   #38  <Method Object Vector.get(int)>
    //   76  163:checkcast       #40  <Class HPRoleMinimization$Role>
    //   77  166:aload_0         
    //   78  167:getfield        #34  <Field Vector roles>
    //   79  170:aload_3         
    //   80  171:invokevirtual   #194 <Method int HPRoleMinimization$FourTuples.getJndex()>
    //   81  174:invokevirtual   #38  <Method Object Vector.get(int)>
    //   82  177:checkcast       #40  <Class HPRoleMinimization$Role>
    //   83  180:invokespecial   #107 <Method Vector intersectRoles(HPRoleMinimization$Role, HPRoleMinimization$Role)>
    //   84  183:invokevirtual   #216 <Method void HPRoleMinimization$Role.setPerList(Vector)>
            roles.add(numberOfRoles, role);
    //   85  186:aload_0         
    //   86  187:getfield        #34  <Field Vector roles>
    //   87  190:aload_0         
    //   88  191:getfield        #206 <Field int numberOfRoles>
    //   89  194:aload           4
    //   90  196:invokevirtual   #77  <Method void Vector.add(int, Object)>
            reducePermissions(numberOfRoles, ft.getIndex());
    //   91  199:aload_0         
    //   92  200:aload_0         
    //   93  201:getfield        #206 <Field int numberOfRoles>
    //   94  204:aload_3         
    //   95  205:invokevirtual   #191 <Method int HPRoleMinimization$FourTuples.getIndex()>
    //   96  208:invokespecial   #198 <Method void reducePermissions(int, int)>
            reducePermissions(numberOfRoles, ft.getJndex());
    //   97  211:aload_0         
    //   98  212:aload_0         
    //   99  213:getfield        #206 <Field int numberOfRoles>
    //  100  216:aload_3         
    //  101  217:invokevirtual   #194 <Method int HPRoleMinimization$FourTuples.getJndex()>
    //  102  220:invokespecial   #198 <Method void reducePermissions(int, int)>
            numberOfRoles++;
    //  103  223:aload_0         
    //  104  224:dup             
    //  105  225:getfield        #206 <Field int numberOfRoles>
    //  106  228:iconst_1        
    //  107  229:iadd            
    //  108  230:putfield        #206 <Field int numberOfRoles>
        }
    //  109  233:return          
    }

    private void updateRoleSet(int jndex, int index)
    {
        Vector indexUsers = (Vector)((HPRoleMinimization.Role)roles.get(index)).getUseList().clone();
    //    0    0:aload_0         
    //    1    1:getfield        #34  <Field Vector roles>
    //    2    4:iload_2         
    //    3    5:invokevirtual   #38  <Method Object Vector.get(int)>
    //    4    8:checkcast       #40  <Class HPRoleMinimization$Role>
    //    5   11:invokevirtual   #55  <Method Vector HPRoleMinimization$Role.getUseList()>
    //    6   14:invokevirtual   #220 <Method Object Vector.clone()>
    //    7   17:checkcast       #26  <Class Vector>
    //    8   20:astore_3        
        for(Iterator iterator = indexUsers.iterator(); iterator.hasNext();)
    //*   9   21:aload_3         
    //*  10   22:invokevirtual   #224 <Method Iterator Vector.iterator()>
    //*  11   25:astore          5
    //*  12   27:goto            94
        {
            String oneuser = (String)iterator.next();
    //   13   30:aload           5
    //   14   32:invokeinterface #229 <Method Object Iterator.next()>
    //   15   37:checkcast       #166 <Class String>
    //   16   40:astore          4
            if(!((HPRoleMinimization.Role)roles.get(jndex)).getUseList().contains(oneuser))
    //*  17   42:aload_0         
    //*  18   43:getfield        #34  <Field Vector roles>
    //*  19   46:iload_1         
    //*  20   47:invokevirtual   #38  <Method Object Vector.get(int)>
    //*  21   50:checkcast       #40  <Class HPRoleMinimization$Role>
    //*  22   53:invokevirtual   #55  <Method Vector HPRoleMinimization$Role.getUseList()>
    //*  23   56:aload           4
    //*  24   58:invokevirtual   #233 <Method boolean Vector.contains(Object)>
    //*  25   61:ifne            94
            {
                WSC++;
    //   26   64:aload_0         
    //   27   65:dup             
    //   28   66:getfield        #96  <Field int WSC>
    //   29   69:iconst_1        
    //   30   70:iadd            
    //   31   71:putfield        #96  <Field int WSC>
                ((HPRoleMinimization.Role)roles.get(jndex)).getUseList().add(oneuser);
    //   32   74:aload_0         
    //   33   75:getfield        #34  <Field Vector roles>
    //   34   78:iload_1         
    //   35   79:invokevirtual   #38  <Method Object Vector.get(int)>
    //   36   82:checkcast       #40  <Class HPRoleMinimization$Role>
    //   37   85:invokevirtual   #55  <Method Vector HPRoleMinimization$Role.getUseList()>
    //   38   88:aload           4
    //   39   90:invokevirtual   #235 <Method boolean Vector.add(Object)>
    //   40   93:pop             
            }
        }

    //   41   94:aload           5
    //   42   96:invokeinterface #239 <Method boolean Iterator.hasNext()>
    //   43  101:ifne            30
    //   44  104:return          
    }

    private void reducePermissions(int index, int jndex)
    {
        Vector pers = (Vector)((HPRoleMinimization.Role)roles.get(jndex)).getPerList().clone();
    //    0    0:aload_0         
    //    1    1:getfield        #34  <Field Vector roles>
    //    2    4:iload_2         
    //    3    5:invokevirtual   #38  <Method Object Vector.get(int)>
    //    4    8:checkcast       #40  <Class HPRoleMinimization$Role>
    //    5   11:invokevirtual   #44  <Method Vector HPRoleMinimization$Role.getPerList()>
    //    6   14:invokevirtual   #220 <Method Object Vector.clone()>
    //    7   17:checkcast       #26  <Class Vector>
    //    8   20:astore_3        
        for(int i = 0; i < pers.size(); i++)
    //*   9   21:iconst_0        
    //*  10   22:istore          4
    //*  11   24:goto            63
            if(((HPRoleMinimization.Role)roles.get(index)).getPerList().contains(pers.get(i)))
    //*  12   27:aload_0         
    //*  13   28:getfield        #34  <Field Vector roles>
    //*  14   31:iload_1         
    //*  15   32:invokevirtual   #38  <Method Object Vector.get(int)>
    //*  16   35:checkcast       #40  <Class HPRoleMinimization$Role>
    //*  17   38:invokevirtual   #44  <Method Vector HPRoleMinimization$Role.getPerList()>
    //*  18   41:aload_3         
    //*  19   42:iload           4
    //*  20   44:invokevirtual   #38  <Method Object Vector.get(int)>
    //*  21   47:invokevirtual   #233 <Method boolean Vector.contains(Object)>
    //*  22   50:ifeq            60
                pers.remove(i);
    //   23   53:aload_3         
    //   24   54:iload           4
    //   25   56:invokevirtual   #245 <Method Object Vector.remove(int)>
    //   26   59:pop             

    //   27   60:iinc            4  1
    //   28   63:iload           4
    //   29   65:aload_3         
    //   30   66:invokevirtual   #52  <Method int Vector.size()>
    //   31   69:icmplt          27
        ((HPRoleMinimization.Role)roles.get(jndex)).setPerList((Vector)pers.clone());
    //   32   72:aload_0         
    //   33   73:getfield        #34  <Field Vector roles>
    //   34   76:iload_2         
    //   35   77:invokevirtual   #38  <Method Object Vector.get(int)>
    //   36   80:checkcast       #40  <Class HPRoleMinimization$Role>
    //   37   83:aload_3         
    //   38   84:invokevirtual   #220 <Method Object Vector.clone()>
    //   39   87:checkcast       #26  <Class Vector>
    //   40   90:invokevirtual   #216 <Method void HPRoleMinimization$Role.setPerList(Vector)>
    //   41   93:return          
    }

    private int getMaxReduce(Vector subSet)
    {
        int index = 0x7fffffff;
    //    0    0:ldc1            #249 <Int 0x7fffffff>
    //    1    2:istore_2        
        int max = 0;
    //    2    3:iconst_0        
    //    3    4:istore_3        
        for(int i = 0; i < subSet.size(); i++)
    //*   4    5:iconst_0        
    //*   5    6:istore          4
    //*   6    8:goto            46
            if(((HPRoleMinimization.FourTuples)subSet.get(i)).getReduce() > max)
    //*   7   11:aload_1         
    //*   8   12:iload           4
    //*   9   14:invokevirtual   #38  <Method Object Vector.get(int)>
    //*  10   17:checkcast       #57  <Class HPRoleMinimization$FourTuples>
    //*  11   20:invokevirtual   #99  <Method int HPRoleMinimization$FourTuples.getReduce()>
    //*  12   23:iload_3         
    //*  13   24:icmple          43
            {
                max = ((HPRoleMinimization.FourTuples)subSet.get(i)).getReduce();
    //   14   27:aload_1         
    //   15   28:iload           4
    //   16   30:invokevirtual   #38  <Method Object Vector.get(int)>
    //   17   33:checkcast       #57  <Class HPRoleMinimization$FourTuples>
    //   18   36:invokevirtual   #99  <Method int HPRoleMinimization$FourTuples.getReduce()>
    //   19   39:istore_3        
                index = i;
    //   20   40:iload           4
    //   21   42:istore_2        
            }

    //   22   43:iinc            4  1
    //   23   46:iload           4
    //   24   48:aload_1         
    //   25   49:invokevirtual   #52  <Method int Vector.size()>
    //   26   52:icmplt          11
        return index;
    //   27   55:iload_2         
    //   28   56:ireturn         
    }

    private Vector getAllUsers(HPRoleMinimization.Role role, HPRoleMinimization.Role role2)
    {
        Vector allUsers = (Vector)role.getUseList().clone();
    //    0    0:aload_1         
    //    1    1:invokevirtual   #55  <Method Vector HPRoleMinimization$Role.getUseList()>
    //    2    4:invokevirtual   #220 <Method Object Vector.clone()>
    //    3    7:checkcast       #26  <Class Vector>
    //    4   10:astore_3        
        Vector role2users = (Vector)role2.getUseList().clone();
    //    5   11:aload_2         
    //    6   12:invokevirtual   #55  <Method Vector HPRoleMinimization$Role.getUseList()>
    //    7   15:invokevirtual   #220 <Method Object Vector.clone()>
    //    8   18:checkcast       #26  <Class Vector>
    //    9   21:astore          4
        for(Iterator iterator = role2users.iterator(); iterator.hasNext();)
    //*  10   23:aload           4
    //*  11   25:invokevirtual   #224 <Method Iterator Vector.iterator()>
    //*  12   28:astore          6
    //*  13   30:goto            61
        {
            String userB = (String)iterator.next();
    //   14   33:aload           6
    //   15   35:invokeinterface #229 <Method Object Iterator.next()>
    //   16   40:checkcast       #166 <Class String>
    //   17   43:astore          5
            if(!allUsers.contains(userB))
    //*  18   45:aload_3         
    //*  19   46:aload           5
    //*  20   48:invokevirtual   #233 <Method boolean Vector.contains(Object)>
    //*  21   51:ifne            61
                allUsers.add(userB);
    //   22   54:aload_3         
    //   23   55:aload           5
    //   24   57:invokevirtual   #235 <Method boolean Vector.add(Object)>
    //   25   60:pop             
        }

    //   26   61:aload           6
    //   27   63:invokeinterface #239 <Method boolean Iterator.hasNext()>
    //   28   68:ifne            33
        return allUsers;
    //   29   71:aload_3         
    //   30   72:areturn         
    }

    private Vector intersectRoles(HPRoleMinimization.Role role, HPRoleMinimization.Role role2)
    {
        Vector commonPermissions = new Vector();
    //    0    0:new             #26  <Class Vector>
    //    1    3:dup             
    //    2    4:invokespecial   #27  <Method void Vector()>
    //    3    7:astore_3        
        Vector rolePers = (Vector)role.getPerList().clone();
    //    4    8:aload_1         
    //    5    9:invokevirtual   #44  <Method Vector HPRoleMinimization$Role.getPerList()>
    //    6   12:invokevirtual   #220 <Method Object Vector.clone()>
    //    7   15:checkcast       #26  <Class Vector>
    //    8   18:astore          4
        Vector role2Pers = (Vector)role2.getPerList().clone();
    //    9   20:aload_2         
    //   10   21:invokevirtual   #44  <Method Vector HPRoleMinimization$Role.getPerList()>
    //   11   24:invokevirtual   #220 <Method Object Vector.clone()>
    //   12   27:checkcast       #26  <Class Vector>
    //   13   30:astore          5
        for(Iterator iterator = rolePers.iterator(); iterator.hasNext();)
    //*  14   32:aload           4
    //*  15   34:invokevirtual   #224 <Method Iterator Vector.iterator()>
    //*  16   37:astore          7
    //*  17   39:goto            71
        {
            String perA = (String)iterator.next();
    //   18   42:aload           7
    //   19   44:invokeinterface #229 <Method Object Iterator.next()>
    //   20   49:checkcast       #166 <Class String>
    //   21   52:astore          6
            if(role2Pers.contains(perA))
    //*  22   54:aload           5
    //*  23   56:aload           6
    //*  24   58:invokevirtual   #233 <Method boolean Vector.contains(Object)>
    //*  25   61:ifeq            71
                commonPermissions.add(perA);
    //   26   64:aload_3         
    //   27   65:aload           6
    //   28   67:invokevirtual   #235 <Method boolean Vector.add(Object)>
    //   29   70:pop             
        }

    //   30   71:aload           7
    //   31   73:invokeinterface #239 <Method boolean Iterator.hasNext()>
    //   32   78:ifne            42
        return commonPermissions;
    //   33   81:aload_3         
    //   34   82:areturn         
    }

    public String globalInfo()
    {
        return "HPe first gets roles by the HPr,then HPe greedily improves the onjective \nfunction which minimizes the edges using several transformations \n until no further improvement is possible. \n";
    //    0    0:ldc2            #260 <String "HPe first gets roles by the HPr,then HPe greedily improves the onjective \nfunction which minimizes the edges using several transformations \n until no further improvement is possible. \n">
    //    1    3:areturn         
    }

    public Capabilities getCapabilities()
    {
        Capabilities result = super.getCapabilities();
    //    0    0:aload_0         
    //    1    1:invokespecial   #264 <Method Capabilities HPRoleMinimization.getCapabilities()>
    //    2    4:astore_1        
        result.disableAll();
    //    3    5:aload_1         
    //    4    6:invokevirtual   #269 <Method void Capabilities.disableAll()>
        result.enable(rm.core.Capabilities.Capability.NOMINAL_ATTRIBUTES);
    //    5    9:aload_1         
    //    6   10:getstatic       #275 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.NOMINAL_ATTRIBUTES>
    //    7   13:invokevirtual   #279 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enable(rm.core.Capabilities.Capability.MISSING_VALUES);
    //    8   16:aload_1         
    //    9   17:getstatic       #282 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.MISSING_VALUES>
    //   10   20:invokevirtual   #279 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enable(rm.core.Capabilities.Capability.NO_CLASS);
    //   11   23:aload_1         
    //   12   24:getstatic       #285 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.NO_CLASS>
    //   13   27:invokevirtual   #279 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enable(rm.core.Capabilities.Capability.NOMINAL_CLASS);
    //   14   30:aload_1         
    //   15   31:getstatic       #288 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.NOMINAL_CLASS>
    //   16   34:invokevirtual   #279 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enable(rm.core.Capabilities.Capability.MISSING_CLASS_VALUES);
    //   17   37:aload_1         
    //   18   38:getstatic       #291 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.MISSING_CLASS_VALUES>
    //   19   41:invokevirtual   #279 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        return result;
    //   20   44:aload_1         
    //   21   45:areturn         
    }

    public static void main(String args[])
    {
        Assignment Ass = null;
    //    0    0:aconst_null     
    //    1    1:astore_1        
        try
        {
            File file = new File((new StringBuilder(String.valueOf(System.getProperty("user.dir")))).append("\\datasets\\university_large.ass").toString());
    //    2    2:new             #297 <Class File>
    //    3    5:dup             
    //    4    6:new             #147 <Class StringBuilder>
    //    5    9:dup             
    //    6   10:ldc2            #299 <String "user.dir">
    //    7   13:invokestatic    #305 <Method String System.getProperty(String)>
    //    8   16:invokestatic    #170 <Method String String.valueOf(Object)>
    //    9   19:invokespecial   #152 <Method void StringBuilder(String)>
    //   10   22:ldc2            #307 <String "\\datasets\\university_large.ass">
    //   11   25:invokevirtual   #160 <Method StringBuilder StringBuilder.append(String)>
    //   12   28:invokevirtual   #164 <Method String StringBuilder.toString()>
    //   13   31:invokespecial   #308 <Method void File(String)>
    //   14   34:astore_2        
            AssLoader AL = new AssLoader(new FileReader(file));
    //   15   35:new             #310 <Class AssLoader>
    //   16   38:dup             
    //   17   39:new             #312 <Class FileReader>
    //   18   42:dup             
    //   19   43:aload_2         
    //   20   44:invokespecial   #315 <Method void FileReader(File)>
    //   21   47:invokespecial   #318 <Method void AssLoader(FileReader)>
    //   22   50:astore_3        
            Ass = AL.getData();
    //   23   51:aload_3         
    //   24   52:invokevirtual   #322 <Method Assignment AssLoader.getData()>
    //   25   55:astore_1        
            System.out.println(Ass.getAssignementName());
    //   26   56:getstatic       #326 <Field PrintStream System.out>
    //   27   59:aload_1         
    //   28   60:invokevirtual   #329 <Method String Assignment.getAssignementName()>
    //   29   63:invokevirtual   #334 <Method void PrintStream.println(String)>
            HPEdgeMinimization HPe = new HPEdgeMinimization();
    //   30   66:new             #2   <Class HPEdgeMinimization>
    //   31   69:dup             
    //   32   70:invokespecial   #335 <Method void HPEdgeMinimization()>
    //   33   73:astore          4
            HPe.buildRoleminers(Ass);
    //   34   75:aload           4
    //   35   77:aload_1         
    //   36   78:invokevirtual   #336 <Method void buildRoleminers(Assignment)>
            System.out.println(HPe.toString());
    //   37   81:getstatic       #326 <Field PrintStream System.out>
    //   38   84:aload           4
    //   39   86:invokevirtual   #337 <Method String toString()>
    //   40   89:invokevirtual   #334 <Method void PrintStream.println(String)>
            System.out.println(HPe.generateRoles());
    //   41   92:getstatic       #326 <Field PrintStream System.out>
    //   42   95:aload           4
    //   43   97:invokevirtual   #340 <Method Assignment generateRoles()>
    //   44  100:invokevirtual   #343 <Method void PrintStream.println(Object)>
        }
    //*  45  103:goto            111
        catch(Exception e)
    //*  46  106:astore_2        
        {
            e.printStackTrace();
    //   47  107:aload_2         
    //   48  108:invokevirtual   #346 <Method void Exception.printStackTrace()>
        }
    //   49  111:return          
    }
}
