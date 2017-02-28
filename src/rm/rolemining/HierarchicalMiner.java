// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   HierarchicalMiner.java

package rm.rolemining;

import java.io.*;
import java.util.*;
import rm.core.*;
import rm.core.converters.AssLoader;
import rm.rolemining.lattice.Concept;
import rm.rolemining.lattice.Context;
import rm.rolemining.lattice.IntegerSet;
import rm.rolemining.lattice.ReducedLattices;

public class HierarchicalMiner extends ReducedLattices
    implements OptionHandler
{

    public HierarchicalMiner()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #29  <Method void ReducedLattices()>
        log = new StringBuffer();
    //    2    4:aload_0         
    //    3    5:new             #31  <Class StringBuffer>
    //    4    8:dup             
    //    5    9:invokespecial   #32  <Method void StringBuffer()>
    //    6   12:putfield        #34  <Field StringBuffer log>
        resetOptions();
    //    7   15:aload_0         
    //    8   16:invokevirtual   #37  <Method void resetOptions()>
    //    9   19:return          
    }

    public void buildRoleminers(Assignment data)
        throws Exception
    {
        m_assignment = data;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #48  <Field Assignment m_assignment>
        Object set[] = m_assignment.getDimensionX().getDimensionAttribute().toArray();
    //    3    5:aload_0         
    //    4    6:getfield        #48  <Field Assignment m_assignment>
    //    5    9:invokevirtual   #54  <Method Dimension Assignment.getDimensionX()>
    //    6   12:invokevirtual   #60  <Method Attribute Dimension.getDimensionAttribute()>
    //    7   15:invokevirtual   #66  <Method Object[] Attribute.toArray()>
    //    8   18:astore_2        
        String userSet[] = new String[set.length];
    //    9   19:aload_2         
    //   10   20:arraylength     
    //   11   21:anewarray       String[]
    //   12   24:astore_3        
        noUsers = set.length;
    //   13   25:aload_0         
    //   14   26:aload_2         
    //   15   27:arraylength     
    //   16   28:putfield        #70  <Field int noUsers>
        for(int i = 0; i < set.length; i++)
    //*  17   31:iconst_0        
    //*  18   32:istore          4
    //*  19   34:goto            51
            userSet[i] = (String)set[i];
    //   20   37:aload_3         
    //   21   38:iload           4
    //   22   40:aload_2         
    //   23   41:iload           4
    //   24   43:aaload          
    //   25   44:checkcast       #68  <Class String>
    //   26   47:aastore         

    //   27   48:iinc            4  1
    //   28   51:iload           4
    //   29   53:aload_2         
    //   30   54:arraylength     
    //   31   55:icmplt          37
        set = m_assignment.getDimensionY().getDimensionAttribute().toArray();
    //   32   58:aload_0         
    //   33   59:getfield        #48  <Field Assignment m_assignment>
    //   34   62:invokevirtual   #73  <Method Dimension Assignment.getDimensionY()>
    //   35   65:invokevirtual   #60  <Method Attribute Dimension.getDimensionAttribute()>
    //   36   68:invokevirtual   #66  <Method Object[] Attribute.toArray()>
    //   37   71:astore_2        
        String permSet[] = new String[set.length];
    //   38   72:aload_2         
    //   39   73:arraylength     
    //   40   74:anewarray       String[]
    //   41   77:astore          4
        noPerms = set.length;
    //   42   79:aload_0         
    //   43   80:aload_2         
    //   44   81:arraylength     
    //   45   82:putfield        #75  <Field int noPerms>
        for(int i = 0; i < set.length; i++)
    //*  46   85:iconst_0        
    //*  47   86:istore          5
    //*  48   88:goto            106
            permSet[i] = (String)set[i];
    //   49   91:aload           4
    //   50   93:iload           5
    //   51   95:aload_2         
    //   52   96:iload           5
    //   53   98:aaload          
    //   54   99:checkcast       #68  <Class String>
    //   55  102:aastore         

    //   56  103:iinc            5  1
    //   57  106:iload           5
    //   58  108:aload_2         
    //   59  109:arraylength     
    //   60  110:icmplt          91
        Matrix mat = m_assignment.getAssignmentMatrix();
    //   61  113:aload_0         
    //   62  114:getfield        #48  <Field Assignment m_assignment>
    //   63  117:invokevirtual   #79  <Method Matrix Assignment.getAssignmentMatrix()>
    //   64  120:astore          5
        f_context = new Context(userSet, permSet, mat, log);
        
    //   65  122:aload_0         
    //   66  123:new             #81  <Class Context>
    //   67  126:dup             
    //   68  127:aload_3         
    //   69  128:aload           4
    //   70  130:aload           5
    //   71  132:aload_0         
    //   72  133:getfield        #34  <Field StringBuffer log>
    //   73  136:invokespecial   #84  <Method void Context(String[], String[], Matrix, StringBuffer)>
    //   74  139:putfield        #86  <Field Context f_context>
        int count1 = 0;
    //   75  142:iconst_0        
    //   76  143:istore          6
        for(int i = 0; i < mat.getRowDimension(); i++)
    //*  77  145:iconst_0        
    //*  78  146:istore          7
    //*  79  148:goto            189
        {
            for(int j = 0; j < mat.getColumnDimension(); j++)
    //*  80  151:iconst_0        
    //*  81  152:istore          8
    //*  82  154:goto            176
                if(mat.get(i, j) == 1)
    //*  83  157:aload           5
    //*  84  159:iload           7
    //*  85  161:iload           8
    //*  86  163:invokevirtual   #92  <Method byte Matrix.get(int, int)>
    //*  87  166:iconst_1        
    //*  88  167:icmpne          173
                    count1++;
    //   89  170:iinc            6  1

    //   90  173:iinc            8  1
    //   91  176:iload           8
    //   92  178:aload           5
    //   93  180:invokevirtual   #96  <Method int Matrix.getColumnDimension()>
    //   94  183:icmplt          157
        }

    //   95  186:iinc            7  1
    //   96  189:iload           7
    //   97  191:aload           5
    //   98  193:invokevirtual   #99  <Method int Matrix.getRowDimension()>
    //   99  196:icmplt          151
        log.append((new StringBuilder("1\u7684\u4E2A\u6570\u4E3A\uFF1A ")).append(count1).append("\n").toString());
    //  100  199:aload_0         
    //  101  200:getfield        #34  <Field StringBuffer log>
    //  102  203:new             #101 <Class StringBuilder>
    //  103  206:dup             
    //  104  207:ldc1            #103 <String "1\u7684\u4E2A\u6570\u4E3A\uFF1A ">
    //  105  209:invokespecial   #106 <Method void StringBuilder(String)>
    //  106  212:iload           6
    //  107  214:invokevirtual   #110 <Method StringBuilder StringBuilder.append(int)>
    //  108  217:ldc1            #112 <String "\n">
    //  109  219:invokevirtual   #115 <Method StringBuilder StringBuilder.append(String)>
    //  110  222:invokevirtual   #119 <Method String StringBuilder.toString()>
    //  111  225:invokevirtual   #122 <Method StringBuffer StringBuffer.append(String)>
    //  112  228:pop             
        setContext(f_context, log);
    //  113  229:aload_0         
    //  114  230:aload_0         
    //  115  231:getfield        #86  <Field Context f_context>
    //  116  234:aload_0         
    //  117  235:getfield        #34  <Field StringBuffer log>
    //  118  238:invokevirtual   #126 <Method void setContext(Context, StringBuffer)>
        setWeights(wr, wu, wp, wh);
    //  119  241:aload_0         
    //  120  242:aload_0         
    //  121  243:getfield        #128 <Field int wr>
    //  122  246:aload_0         
    //  123  247:getfield        #130 <Field int wu>
    //  124  250:aload_0         
    //  125  251:getfield        #132 <Field int wp>
    //  126  254:aload_0         
    //  127  255:getfield        #134 <Field int wh>
    //  128  258:invokevirtual   #138 <Method void setWeights(int, int, int, int)>
        ReduceEdges();
    //  129  261:aload_0         
    //  130  262:invokevirtual   #141 <Method int ReduceEdges()>
    //  131  265:pop             
        log.append("\n--------------------------------------------------------\n");
    //  132  266:aload_0         
    //  133  267:getfield        #34  <Field StringBuffer log>
    //  134  270:ldc1            #143 <String "\n--------------------------------------------------------\n">
    //  135  272:invokevirtual   #122 <Method StringBuffer StringBuffer.append(String)>
    //  136  275:pop             
        for(int i = 0; i < nodes.size(); i++)
    //* 137  276:iconst_0        
    //* 138  277:istore          7
    //* 139  279:goto            322
        {
            log.append((new StringBuilder(String.valueOf(i))).append("  :\n").toString());
    //  140  282:aload_0         
    //  141  283:getfield        #34  <Field StringBuffer log>
    //  142  286:new             #101 <Class StringBuilder>
    //  143  289:dup             
    //  144  290:iload           7
    //  145  292:invokestatic    #147 <Method String String.valueOf(int)>
    //  146  295:invokespecial   #106 <Method void StringBuilder(String)>
    //  147  298:ldc1            #149 <String "  :\n">
    //  148  300:invokevirtual   #115 <Method StringBuilder StringBuilder.append(String)>
    //  149  303:invokevirtual   #119 <Method String StringBuilder.toString()>
    //  150  306:invokevirtual   #122 <Method StringBuffer StringBuffer.append(String)>
    //  151  309:pop             
            PrintNode(Integer.valueOf(i));
    //  152  310:aload_0         
    //  153  311:iload           7
    //  154  313:invokestatic    #154 <Method Integer Integer.valueOf(int)>
    //  155  316:invokevirtual   #158 <Method void PrintNode(Integer)>
        }

    //  156  319:iinc            7  1
    //  157  322:iload           7
    //  158  324:aload_0         
    //  159  325:getfield        #162 <Field Vector nodes>
    //  160  328:invokevirtual   #167 <Method int Vector.size()>
    //  161  331:icmplt          282
        log.append("\n--------------------------------------------------------\n");
    //  162  334:aload_0         
    //  163  335:getfield        #34  <Field StringBuffer log>
    //  164  338:ldc1            #143 <String "\n--------------------------------------------------------\n">
    //  165  340:invokevirtual   #122 <Method StringBuffer StringBuffer.append(String)>
    //  166  343:pop             
        log.append("Ouput role set:\n");
    //  167  344:aload_0         
    //  168  345:getfield        #34  <Field StringBuffer log>
    //  169  348:ldc1            #169 <String "Ouput role set:\n">
    //  170  350:invokevirtual   #122 <Method StringBuffer StringBuffer.append(String)>
    //  171  353:pop             
        int beforedone = 0;
    //  172  354:iconst_0        
    //  173  355:istore          7
        for(int done = 1; done > 0;)
    //* 174  357:iconst_1        
    //* 175  358:istore          8
    //* 176  360:goto            914
        {
            done = 0;
    //  177  363:iconst_0        
    //  178  364:istore          8
            for(int i = 0; i < nodes.size();)
    //* 179  366:iconst_0        
    //* 180  367:istore          9
    //* 181  369:goto            902
            {
                log.append((new StringBuilder(String.valueOf(i))).append("  :\n").toString());
    //  182  372:aload_0         
    //  183  373:getfield        #34  <Field StringBuffer log>
    //  184  376:new             #101 <Class StringBuilder>
    //  185  379:dup             
    //  186  380:iload           9
    //  187  382:invokestatic    #147 <Method String String.valueOf(int)>
    //  188  385:invokespecial   #106 <Method void StringBuilder(String)>
    //  189  388:ldc1            #149 <String "  :\n">
    //  190  390:invokevirtual   #115 <Method StringBuilder StringBuilder.append(String)>
    //  191  393:invokevirtual   #119 <Method String StringBuilder.toString()>
    //  192  396:invokevirtual   #122 <Method StringBuffer StringBuffer.append(String)>
    //  193  399:pop             
                PrintNode(Integer.valueOf(i));
    //  194  400:aload_0         
    //  195  401:iload           9
    //  196  403:invokestatic    #154 <Method Integer Integer.valueOf(int)>
    //  197  406:invokevirtual   #158 <Method void PrintNode(Integer)>
                beforedone = done;
    //  198  409:iload           8
    //  199  411:istore          7
                ArrayList Jun = getJun(i);
    //  200  413:aload_0         
    //  201  414:iload           9
    //  202  416:invokevirtual   #173 <Method ArrayList getJun(int)>
    //  203  419:astore          10
                ArrayList Sen = getSen(i);
    //  204  421:aload_0         
    //  205  422:iload           9
    //  206  424:invokevirtual   #176 <Method ArrayList getSen(int)>
    //  207  427:astore          11
                ArrayList Thr = getThr(i);
    //  208  429:aload_0         
    //  209  430:iload           9
    //  210  432:invokevirtual   #179 <Method ArrayList getThr(int)>
    //  211  435:astore          12
                if(((Concept)nodes.get(i)).getNumberOfObjects() == 0 && ((Concept)nodes.get(i)).getNumberOfAttributes() == 0)
    //* 212  437:aload_0         
    //* 213  438:getfield        #162 <Field Vector nodes>
    //* 214  441:iload           9
    //* 215  443:invokevirtual   #182 <Method Object Vector.get(int)>
    //* 216  446:checkcast       #184 <Class Concept>
    //* 217  449:invokevirtual   #187 <Method int Concept.getNumberOfObjects()>
    //* 218  452:ifne            511
    //* 219  455:aload_0         
    //* 220  456:getfield        #162 <Field Vector nodes>
    //* 221  459:iload           9
    //* 222  461:invokevirtual   #182 <Method Object Vector.get(int)>
    //* 223  464:checkcast       #184 <Class Concept>
    //* 224  467:invokevirtual   #190 <Method int Concept.getNumberOfAttributes()>
    //* 225  470:ifne            511
                {
                    boolean judge = JudgeNoBoth(Jun, Sen, Thr);
    //  226  473:aload_0         
    //  227  474:aload           10
    //  228  476:aload           11
    //  229  478:aload           12
    //  230  480:invokevirtual   #194 <Method boolean JudgeNoBoth(ArrayList, ArrayList, ArrayList)>
    //  231  483:istore          13
                    if(judge)
    //* 232  485:iload           13
    //* 233  487:ifeq            892
                    {
                        Update(i, Thr);
    //  234  490:aload_0         
    //  235  491:iload           9
    //  236  493:aload           12
    //  237  495:invokevirtual   #198 <Method void Update(int, ArrayList)>
                        DeleteNode(i);
    //  238  498:aload_0         
    //  239  499:iload           9
    //  240  501:invokevirtual   #202 <Method int DeleteNode(int)>
    //  241  504:pop             
                        done++;
    //  242  505:iinc            8  1
                    }
                } else
    //* 243  508:goto            892
                if(((Concept)nodes.get(i)).getNumberOfObjects() > 0 && ((Concept)nodes.get(i)).getNumberOfAttributes() == 0)
    //* 244  511:aload_0         
    //* 245  512:getfield        #162 <Field Vector nodes>
    //* 246  515:iload           9
    //* 247  517:invokevirtual   #182 <Method Object Vector.get(int)>
    //* 248  520:checkcast       #184 <Class Concept>
    //* 249  523:invokevirtual   #187 <Method int Concept.getNumberOfObjects()>
    //* 250  526:ifle            703
    //* 251  529:aload_0         
    //* 252  530:getfield        #162 <Field Vector nodes>
    //* 253  533:iload           9
    //* 254  535:invokevirtual   #182 <Method Object Vector.get(int)>
    //* 255  538:checkcast       #184 <Class Concept>
    //* 256  541:invokevirtual   #190 <Method int Concept.getNumberOfAttributes()>
    //* 257  544:ifne            703
                {
                    boolean judge = JudgeNoPerm(Jun, Sen, Thr, ((Concept)nodes.get(i)).getNumberOfObjects());
    //  258  547:aload_0         
    //  259  548:aload           10
    //  260  550:aload           11
    //  261  552:aload           12
    //  262  554:aload_0         
    //  263  555:getfield        #162 <Field Vector nodes>
    //  264  558:iload           9
    //  265  560:invokevirtual   #182 <Method Object Vector.get(int)>
    //  266  563:checkcast       #184 <Class Concept>
    //  267  566:invokevirtual   #187 <Method int Concept.getNumberOfObjects()>
    //  268  569:invokevirtual   #206 <Method boolean JudgeNoPerm(ArrayList, ArrayList, ArrayList, int)>
    //  269  572:istore          13
                    if(Jun.size() > 0 && judge)
    //* 270  574:aload           10
    //* 271  576:invokevirtual   #209 <Method int ArrayList.size()>
    //* 272  579:ifle            892
    //* 273  582:iload           13
    //* 274  584:ifeq            892
                    {
                        Update(i, Thr);
    //  275  587:aload_0         
    //  276  588:iload           9
    //  277  590:aload           12
    //  278  592:invokevirtual   #198 <Method void Update(int, ArrayList)>
                        for(int j = 0; j < Jun.size(); j++)
    //* 279  595:iconst_0        
    //* 280  596:istore          14
    //* 281  598:goto            680
                            ((Concept)nodes.get(((Integer)(Integer)Jun.get(j)).intValue())).allObjects = ((Concept)nodes.get(((Integer)(Integer)Jun.get(j)).intValue())).allObjects.getUnion(((Concept)nodes.get(i)).allObjects);
    //  282  601:aload_0         
    //  283  602:getfield        #162 <Field Vector nodes>
    //  284  605:aload           10
    //  285  607:iload           14
    //  286  609:invokevirtual   #210 <Method Object ArrayList.get(int)>
    //  287  612:checkcast       #151 <Class Integer>
    //  288  615:checkcast       #151 <Class Integer>
    //  289  618:invokevirtual   #213 <Method int Integer.intValue()>
    //  290  621:invokevirtual   #182 <Method Object Vector.get(int)>
    //  291  624:checkcast       #184 <Class Concept>
    //  292  627:aload_0         
    //  293  628:getfield        #162 <Field Vector nodes>
    //  294  631:aload           10
    //  295  633:iload           14
    //  296  635:invokevirtual   #210 <Method Object ArrayList.get(int)>
    //  297  638:checkcast       #151 <Class Integer>
    //  298  641:checkcast       #151 <Class Integer>
    //  299  644:invokevirtual   #213 <Method int Integer.intValue()>
    //  300  647:invokevirtual   #182 <Method Object Vector.get(int)>
    //  301  650:checkcast       #184 <Class Concept>
    //  302  653:getfield        #217 <Field IntegerSet Concept.allObjects>
    //  303  656:aload_0         
    //  304  657:getfield        #162 <Field Vector nodes>
    //  305  660:iload           9
    //  306  662:invokevirtual   #182 <Method Object Vector.get(int)>
    //  307  665:checkcast       #184 <Class Concept>
    //  308  668:getfield        #217 <Field IntegerSet Concept.allObjects>
    //  309  671:invokevirtual   #223 <Method IntegerSet IntegerSet.getUnion(IntegerSet)>
    //  310  674:putfield        #217 <Field IntegerSet Concept.allObjects>

    //  311  677:iinc            14  1
    //  312  680:iload           14
    //  313  682:aload           10
    //  314  684:invokevirtual   #209 <Method int ArrayList.size()>
    //  315  687:icmplt          601
                        DeleteNode(i);
    //  316  690:aload_0         
    //  317  691:iload           9
    //  318  693:invokevirtual   #202 <Method int DeleteNode(int)>
    //  319  696:pop             
                        done++;
    //  320  697:iinc            8  1
                    }
                } else
    //* 321  700:goto            892
                if(((Concept)nodes.get(i)).getNumberOfObjects() == 0 && ((Concept)nodes.get(i)).getNumberOfAttributes() > 0)
    //* 322  703:aload_0         
    //* 323  704:getfield        #162 <Field Vector nodes>
    //* 324  707:iload           9
    //* 325  709:invokevirtual   #182 <Method Object Vector.get(int)>
    //* 326  712:checkcast       #184 <Class Concept>
    //* 327  715:invokevirtual   #187 <Method int Concept.getNumberOfObjects()>
    //* 328  718:ifne            892
    //* 329  721:aload_0         
    //* 330  722:getfield        #162 <Field Vector nodes>
    //* 331  725:iload           9
    //* 332  727:invokevirtual   #182 <Method Object Vector.get(int)>
    //* 333  730:checkcast       #184 <Class Concept>
    //* 334  733:invokevirtual   #190 <Method int Concept.getNumberOfAttributes()>
    //* 335  736:ifle            892
                {
                    boolean judge = JudgeNoUser(Jun, Sen, Thr, ((Concept)nodes.get(i)).getNumberOfAttributes());
    //  336  739:aload_0         
    //  337  740:aload           10
    //  338  742:aload           11
    //  339  744:aload           12
    //  340  746:aload_0         
    //  341  747:getfield        #162 <Field Vector nodes>
    //  342  750:iload           9
    //  343  752:invokevirtual   #182 <Method Object Vector.get(int)>
    //  344  755:checkcast       #184 <Class Concept>
    //  345  758:invokevirtual   #190 <Method int Concept.getNumberOfAttributes()>
    //  346  761:invokevirtual   #226 <Method boolean JudgeNoUser(ArrayList, ArrayList, ArrayList, int)>
    //  347  764:istore          13
                    if(Sen.size() > 0 && judge)
    //* 348  766:aload           11
    //* 349  768:invokevirtual   #209 <Method int ArrayList.size()>
    //* 350  771:ifle            892
    //* 351  774:iload           13
    //* 352  776:ifeq            892
                    {
                        Update(i, Thr);
    //  353  779:aload_0         
    //  354  780:iload           9
    //  355  782:aload           12
    //  356  784:invokevirtual   #198 <Method void Update(int, ArrayList)>
                        for(int j = 0; j < Sen.size(); j++)
    //* 357  787:iconst_0        
    //* 358  788:istore          14
    //* 359  790:goto            872
                            ((Concept)nodes.get(((Integer)(Integer)Sen.get(j)).intValue())).allAttributes = ((Concept)nodes.get(((Integer)(Integer)Sen.get(j)).intValue())).allAttributes.getUnion(((Concept)nodes.get(i)).allAttributes);
    //  360  793:aload_0         
    //  361  794:getfield        #162 <Field Vector nodes>
    //  362  797:aload           11
    //  363  799:iload           14
    //  364  801:invokevirtual   #210 <Method Object ArrayList.get(int)>
    //  365  804:checkcast       #151 <Class Integer>
    //  366  807:checkcast       #151 <Class Integer>
    //  367  810:invokevirtual   #213 <Method int Integer.intValue()>
    //  368  813:invokevirtual   #182 <Method Object Vector.get(int)>
    //  369  816:checkcast       #184 <Class Concept>
    //  370  819:aload_0         
    //  371  820:getfield        #162 <Field Vector nodes>
    //  372  823:aload           11
    //  373  825:iload           14
    //  374  827:invokevirtual   #210 <Method Object ArrayList.get(int)>
    //  375  830:checkcast       #151 <Class Integer>
    //  376  833:checkcast       #151 <Class Integer>
    //  377  836:invokevirtual   #213 <Method int Integer.intValue()>
    //  378  839:invokevirtual   #182 <Method Object Vector.get(int)>
    //  379  842:checkcast       #184 <Class Concept>
    //  380  845:getfield        #229 <Field IntegerSet Concept.allAttributes>
    //  381  848:aload_0         
    //  382  849:getfield        #162 <Field Vector nodes>
    //  383  852:iload           9
    //  384  854:invokevirtual   #182 <Method Object Vector.get(int)>
    //  385  857:checkcast       #184 <Class Concept>
    //  386  860:getfield        #229 <Field IntegerSet Concept.allAttributes>
    //  387  863:invokevirtual   #223 <Method IntegerSet IntegerSet.getUnion(IntegerSet)>
    //  388  866:putfield        #229 <Field IntegerSet Concept.allAttributes>

    //  389  869:iinc            14  1
    //  390  872:iload           14
    //  391  874:aload           11
    //  392  876:invokevirtual   #209 <Method int ArrayList.size()>
    //  393  879:icmplt          793
                        DeleteNode(i);
    //  394  882:aload_0         
    //  395  883:iload           9
    //  396  885:invokevirtual   #202 <Method int DeleteNode(int)>
    //  397  888:pop             
                        done++;
    //  398  889:iinc            8  1
                    }
                }
                if(beforedone == done)
    //* 399  892:iload           7
    //* 400  894:iload           8
    //* 401  896:icmpne          902
                    i++;
    //  402  899:iinc            9  1
            }

    //  403  902:iload           9
    //  404  904:aload_0         
    //  405  905:getfield        #162 <Field Vector nodes>
    //  406  908:invokevirtual   #167 <Method int Vector.size()>
    //  407  911:icmplt          372
        }

    //  408  914:iload           8
    //  409  916:ifgt            363
        minwsc = ComputeWSC();
    //  410  919:aload_0         
    //  411  920:aload_0         
    //  412  921:invokevirtual   #233 <Method rm.rolemining.lattice.ReducedLattices$WSC ComputeWSC()>
    //  413  924:putfield        #235 <Field rm.rolemining.lattice.ReducedLattices$WSC minwsc>
        log.append("\n--------------------------------------------------------\n");
    //  414  927:aload_0         
    //  415  928:getfield        #34  <Field StringBuffer log>
    //  416  931:ldc1            #143 <String "\n--------------------------------------------------------\n">
    //  417  933:invokevirtual   #122 <Method StringBuffer StringBuffer.append(String)>
    //  418  936:pop             
        log.append((new StringBuilder("All the roles : ")).append(nodes.size()).append("\n").toString());
    //  419  937:aload_0         
    //  420  938:getfield        #34  <Field StringBuffer log>
    //  421  941:new             #101 <Class StringBuilder>
    //  422  944:dup             
    //  423  945:ldc1            #237 <String "All the roles : ">
    //  424  947:invokespecial   #106 <Method void StringBuilder(String)>
    //  425  950:aload_0         
    //  426  951:getfield        #162 <Field Vector nodes>
    //  427  954:invokevirtual   #167 <Method int Vector.size()>
    //  428  957:invokevirtual   #110 <Method StringBuilder StringBuilder.append(int)>
    //  429  960:ldc1            #112 <String "\n">
    //  430  962:invokevirtual   #115 <Method StringBuilder StringBuilder.append(String)>
    //  431  965:invokevirtual   #119 <Method String StringBuilder.toString()>
    //  432  968:invokevirtual   #122 <Method StringBuffer StringBuffer.append(String)>
    //  433  971:pop             
        for(int i = 0; i < nodes.size(); i++)
    //* 434  972:iconst_0        
    //* 435  973:istore          9
    //* 436  975:goto            1018
        {
            log.append((new StringBuilder(String.valueOf(i))).append(" :  ").toString());
    //  437  978:aload_0         
    //  438  979:getfield        #34  <Field StringBuffer log>
    //  439  982:new             #101 <Class StringBuilder>
    //  440  985:dup             
    //  441  986:iload           9
    //  442  988:invokestatic    #147 <Method String String.valueOf(int)>
    //  443  991:invokespecial   #106 <Method void StringBuilder(String)>
    //  444  994:ldc1            #239 <String " :  ">
    //  445  996:invokevirtual   #115 <Method StringBuilder StringBuilder.append(String)>
    //  446  999:invokevirtual   #119 <Method String StringBuilder.toString()>
    //  447 1002:invokevirtual   #122 <Method StringBuffer StringBuffer.append(String)>
    //  448 1005:pop             
            PrintNode(Integer.valueOf(i));
    //  449 1006:aload_0         
    //  450 1007:iload           9
    //  451 1009:invokestatic    #154 <Method Integer Integer.valueOf(int)>
    //  452 1012:invokevirtual   #158 <Method void PrintNode(Integer)>
        }

    //  453 1015:iinc            9  1
    //  454 1018:iload           9
    //  455 1020:aload_0         
    //  456 1021:getfield        #162 <Field Vector nodes>
    //  457 1024:invokevirtual   #167 <Method int Vector.size()>
    //  458 1027:icmplt          978
        log.append("\n--------------------------------------------------------\n");
    //  459 1030:aload_0         
    //  460 1031:getfield        #34  <Field StringBuffer log>
    //  461 1034:ldc1            #143 <String "\n--------------------------------------------------------\n">
    //  462 1036:invokevirtual   #122 <Method StringBuffer StringBuffer.append(String)>
    //  463 1039:pop             
        log.append((new StringBuilder("The Number of edges is : ")).append(edges.size()).append("\n").toString());
    //  464 1040:aload_0         
    //  465 1041:getfield        #34  <Field StringBuffer log>
    //  466 1044:new             #101 <Class StringBuilder>
    //  467 1047:dup             
    //  468 1048:ldc1            #241 <String "The Number of edges is : ">
    //  469 1050:invokespecial   #106 <Method void StringBuilder(String)>
    //  470 1053:aload_0         
    //  471 1054:getfield        #244 <Field Vector edges>
    //  472 1057:invokevirtual   #167 <Method int Vector.size()>
    //  473 1060:invokevirtual   #110 <Method StringBuilder StringBuilder.append(int)>
    //  474 1063:ldc1            #112 <String "\n">
    //  475 1065:invokevirtual   #115 <Method StringBuilder StringBuilder.append(String)>
    //  476 1068:invokevirtual   #119 <Method String StringBuilder.toString()>
    //  477 1071:invokevirtual   #122 <Method StringBuffer StringBuffer.append(String)>
    //  478 1074:pop             
        for(int i = 0; i < edges.size(); i++)
    //* 479 1075:iconst_0        
    //* 480 1076:istore          9
    //* 481 1078:goto            1090
            PrintEdge(i);
    //  482 1081:aload_0         
    //  483 1082:iload           9
    //  484 1084:invokevirtual   #248 <Method void PrintEdge(int)>

    //  485 1087:iinc            9  1
    //  486 1090:iload           9
    //  487 1092:aload_0         
    //  488 1093:getfield        #244 <Field Vector edges>
    //  489 1096:invokevirtual   #167 <Method int Vector.size()>
    //  490 1099:icmplt          1081
        log.append("\n--------------------------------------------------------\n");
    //  491 1102:aload_0         
    //  492 1103:getfield        #34  <Field StringBuffer log>
    //  493 1106:ldc1            #143 <String "\n--------------------------------------------------------\n">
    //  494 1108:invokevirtual   #122 <Method StringBuffer StringBuffer.append(String)>
    //  495 1111:pop             
        log.append((new StringBuilder("minwsc: ")).append(minwsc.R).append(", ").append(minwsc.UA).append(", ").append(minwsc.PA).append(", ").append(minwsc.RH).append(", ").append(minwsc.wsc).append("\n").toString());
    //  496 1112:aload_0         
    //  497 1113:getfield        #34  <Field StringBuffer log>
    //  498 1116:new             #101 <Class StringBuilder>
    //  499 1119:dup             
    //  500 1120:ldc1            #250 <String "minwsc: ">
    //  501 1122:invokespecial   #106 <Method void StringBuilder(String)>
    //  502 1125:aload_0         
    //  503 1126:getfield        #235 <Field rm.rolemining.lattice.ReducedLattices$WSC minwsc>
    //  504 1129:getfield        #255 <Field int rm.rolemining.lattice.ReducedLattices$WSC.R>
    //  505 1132:invokevirtual   #110 <Method StringBuilder StringBuilder.append(int)>
    //  506 1135:ldc2            #257 <String ", ">
    //  507 1138:invokevirtual   #115 <Method StringBuilder StringBuilder.append(String)>
    //  508 1141:aload_0         
    //  509 1142:getfield        #235 <Field rm.rolemining.lattice.ReducedLattices$WSC minwsc>
    //  510 1145:getfield        #260 <Field int rm.rolemining.lattice.ReducedLattices$WSC.UA>
    //  511 1148:invokevirtual   #110 <Method StringBuilder StringBuilder.append(int)>
    //  512 1151:ldc2            #257 <String ", ">
    //  513 1154:invokevirtual   #115 <Method StringBuilder StringBuilder.append(String)>
    //  514 1157:aload_0         
    //  515 1158:getfield        #235 <Field rm.rolemining.lattice.ReducedLattices$WSC minwsc>
    //  516 1161:getfield        #263 <Field int rm.rolemining.lattice.ReducedLattices$WSC.PA>
    //  517 1164:invokevirtual   #110 <Method StringBuilder StringBuilder.append(int)>
    //  518 1167:ldc2            #257 <String ", ">
    //  519 1170:invokevirtual   #115 <Method StringBuilder StringBuilder.append(String)>
    //  520 1173:aload_0         
    //  521 1174:getfield        #235 <Field rm.rolemining.lattice.ReducedLattices$WSC minwsc>
    //  522 1177:getfield        #266 <Field int rm.rolemining.lattice.ReducedLattices$WSC.RH>
    //  523 1180:invokevirtual   #110 <Method StringBuilder StringBuilder.append(int)>
    //  524 1183:ldc2            #257 <String ", ">
    //  525 1186:invokevirtual   #115 <Method StringBuilder StringBuilder.append(String)>
    //  526 1189:aload_0         
    //  527 1190:getfield        #235 <Field rm.rolemining.lattice.ReducedLattices$WSC minwsc>
    //  528 1193:getfield        #269 <Field int rm.rolemining.lattice.ReducedLattices$WSC.wsc>
    //  529 1196:invokevirtual   #110 <Method StringBuilder StringBuilder.append(int)>
    //  530 1199:ldc1            #112 <String "\n">
    //  531 1201:invokevirtual   #115 <Method StringBuilder StringBuilder.append(String)>
    //  532 1204:invokevirtual   #119 <Method String StringBuilder.toString()>
    //  533 1207:invokevirtual   #122 <Method StringBuffer StringBuffer.append(String)>
    //  534 1210:pop             
    //  535 1211:return          
    }

    public void resetOptions()
    {
        wr = 1;
    //    0    0:aload_0         
    //    1    1:iconst_1        
    //    2    2:putfield        #128 <Field int wr>
        wu = 1;
    //    3    5:aload_0         
    //    4    6:iconst_1        
    //    5    7:putfield        #130 <Field int wu>
        wp = 1;
    //    6   10:aload_0         
    //    7   11:iconst_1        
    //    8   12:putfield        #132 <Field int wp>
        wh = 1;
    //    9   15:aload_0         
    //   10   16:iconst_1        
    //   11   17:putfield        #134 <Field int wh>
    //   12   20:return          
    }

    public String globalInfo()
    {
        return "HM use the theory of formal concept analysis \nprovides a solid theoretical foundation for mining \n roles from userpermission relation. \n";
    //    0    0:ldc2            #291 <String "HM use the theory of formal concept analysis \nprovides a solid theoretical foundation for mining \n roles from userpermission relation. \n">
    //    1    3:areturn         
    }

    public Capabilities getCapabilities()
    {
        Capabilities result = super.getCapabilities();
    //    0    0:aload_0         
    //    1    1:invokespecial   #295 <Method Capabilities ReducedLattices.getCapabilities()>
    //    2    4:astore_1        
        result.disableAll();
    //    3    5:aload_1         
    //    4    6:invokevirtual   #300 <Method void Capabilities.disableAll()>
        result.enable(rm.core.Capabilities.Capability.NOMINAL_ATTRIBUTES);
    //    5    9:aload_1         
    //    6   10:getstatic       #306 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.NOMINAL_ATTRIBUTES>
    //    7   13:invokevirtual   #310 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enable(rm.core.Capabilities.Capability.MISSING_VALUES);
    //    8   16:aload_1         
    //    9   17:getstatic       #313 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.MISSING_VALUES>
    //   10   20:invokevirtual   #310 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enable(rm.core.Capabilities.Capability.NO_CLASS);
    //   11   23:aload_1         
    //   12   24:getstatic       #316 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.NO_CLASS>
    //   13   27:invokevirtual   #310 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enable(rm.core.Capabilities.Capability.NOMINAL_CLASS);
    //   14   30:aload_1         
    //   15   31:getstatic       #319 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.NOMINAL_CLASS>
    //   16   34:invokevirtual   #310 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enable(rm.core.Capabilities.Capability.MISSING_CLASS_VALUES);
    //   17   37:aload_1         
    //   18   38:getstatic       #322 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.MISSING_CLASS_VALUES>
    //   19   41:invokevirtual   #310 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        return result;
    //   20   44:aload_1         
    //   21   45:areturn         
    }

    public Enumeration listOptions()
    {
        String string1 = (new StringBuilder("\tRequired weight of number of role for WSC. (default = ")).append(wr).append(")").toString();
    //    0    0:new             #101 <Class StringBuilder>
    //    1    3:dup             
    //    2    4:ldc2            #328 <String "\tRequired weight of number of role for WSC. (default = ">
    //    3    7:invokespecial   #106 <Method void StringBuilder(String)>
    //    4   10:aload_0         
    //    5   11:getfield        #128 <Field int wr>
    //    6   14:invokevirtual   #110 <Method StringBuilder StringBuilder.append(int)>
    //    7   17:ldc2            #330 <String ")">
    //    8   20:invokevirtual   #115 <Method StringBuilder StringBuilder.append(String)>
    //    9   23:invokevirtual   #119 <Method String StringBuilder.toString()>
    //   10   26:astore_1        
        String string2 = (new StringBuilder("\tRequired weight of number of user for WSC. (default = ")).append(wu).append(")").toString();
    //   11   27:new             #101 <Class StringBuilder>
    //   12   30:dup             
    //   13   31:ldc2            #332 <String "\tRequired weight of number of user for WSC. (default = ">
    //   14   34:invokespecial   #106 <Method void StringBuilder(String)>
    //   15   37:aload_0         
    //   16   38:getfield        #130 <Field int wu>
    //   17   41:invokevirtual   #110 <Method StringBuilder StringBuilder.append(int)>
    //   18   44:ldc2            #330 <String ")">
    //   19   47:invokevirtual   #115 <Method StringBuilder StringBuilder.append(String)>
    //   20   50:invokevirtual   #119 <Method String StringBuilder.toString()>
    //   21   53:astore_2        
        String string3 = (new StringBuilder("\tRequired weight of number of permission for WSC. (default = ")).append(wp).append(")").toString();
    //   22   54:new             #101 <Class StringBuilder>
    //   23   57:dup             
    //   24   58:ldc2            #334 <String "\tRequired weight of number of permission for WSC. (default = ">
    //   25   61:invokespecial   #106 <Method void StringBuilder(String)>
    //   26   64:aload_0         
    //   27   65:getfield        #132 <Field int wp>
    //   28   68:invokevirtual   #110 <Method StringBuilder StringBuilder.append(int)>
    //   29   71:ldc2            #330 <String ")">
    //   30   74:invokevirtual   #115 <Method StringBuilder StringBuilder.append(String)>
    //   31   77:invokevirtual   #119 <Method String StringBuilder.toString()>
    //   32   80:astore_3        
        String string4 = (new StringBuilder("\tRequired weight of number of roles' hierarchy for WSC. (default = ")).append(wh).append(")").toString();
    //   33   81:new             #101 <Class StringBuilder>
    //   34   84:dup             
    //   35   85:ldc2            #336 <String "\tRequired weight of number of roles' hierarchy for WSC. (default = ">
    //   36   88:invokespecial   #106 <Method void StringBuilder(String)>
    //   37   91:aload_0         
    //   38   92:getfield        #134 <Field int wh>
    //   39   95:invokevirtual   #110 <Method StringBuilder StringBuilder.append(int)>
    //   40   98:ldc2            #330 <String ")">
    //   41  101:invokevirtual   #115 <Method StringBuilder StringBuilder.append(String)>
    //   42  104:invokevirtual   #119 <Method String StringBuilder.toString()>
    //   43  107:astore          4
        FastVector newVector = new FastVector(4);
    //   44  109:new             #338 <Class FastVector>
    //   45  112:dup             
    //   46  113:iconst_4        
    //   47  114:invokespecial   #340 <Method void FastVector(int)>
    //   48  117:astore          5
        newVector.addElement(new Option(string1, "R", wr, "-R <required weight of number of role>"));
    //   49  119:aload           5
    //   50  121:new             #342 <Class Option>
    //   51  124:dup             
    //   52  125:aload_1         
    //   53  126:ldc2            #343 <String "R">
    //   54  129:aload_0         
    //   55  130:getfield        #128 <Field int wr>
    //   56  133:ldc2            #345 <String "-R <required weight of number of role>">
    //   57  136:invokespecial   #348 <Method void Option(String, String, int, String)>
    //   58  139:invokevirtual   #352 <Method void FastVector.addElement(Object)>
        newVector.addElement(new Option(string2, "U", wu, "-U <required weight of number of user>"));
    //   59  142:aload           5
    //   60  144:new             #342 <Class Option>
    //   61  147:dup             
    //   62  148:aload_2         
    //   63  149:ldc2            #354 <String "U">
    //   64  152:aload_0         
    //   65  153:getfield        #130 <Field int wu>
    //   66  156:ldc2            #356 <String "-U <required weight of number of user>">
    //   67  159:invokespecial   #348 <Method void Option(String, String, int, String)>
    //   68  162:invokevirtual   #352 <Method void FastVector.addElement(Object)>
        newVector.addElement(new Option(string3, "P", wp, "-P <required weight of number of permission>"));
    //   69  165:aload           5
    //   70  167:new             #342 <Class Option>
    //   71  170:dup             
    //   72  171:aload_3         
    //   73  172:ldc2            #358 <String "P">
    //   74  175:aload_0         
    //   75  176:getfield        #132 <Field int wp>
    //   76  179:ldc2            #360 <String "-P <required weight of number of permission>">
    //   77  182:invokespecial   #348 <Method void Option(String, String, int, String)>
    //   78  185:invokevirtual   #352 <Method void FastVector.addElement(Object)>
        newVector.addElement(new Option(string4, "H", wh, "-H <required weight of number of roles' hierarchy>"));
    //   79  188:aload           5
    //   80  190:new             #342 <Class Option>
    //   81  193:dup             
    //   82  194:aload           4
    //   83  196:ldc2            #362 <String "H">
    //   84  199:aload_0         
    //   85  200:getfield        #134 <Field int wh>
    //   86  203:ldc2            #364 <String "-H <required weight of number of roles' hierarchy>">
    //   87  206:invokespecial   #348 <Method void Option(String, String, int, String)>
    //   88  209:invokevirtual   #352 <Method void FastVector.addElement(Object)>
        return newVector.elements();
    //   89  212:aload           5
    //   90  214:invokevirtual   #367 <Method Enumeration FastVector.elements()>
    //   91  217:areturn         
    }

    public void setOptions(String options[])
        throws Exception
    {
        resetOptions();
    //    0    0:aload_0         
    //    1    1:invokevirtual   #37  <Method void resetOptions()>
        String s_wr = Utils.getOption('R', options);
    //    2    4:bipush          82
    //    3    6:aload_1         
    //    4    7:invokestatic    #382 <Method String Utils.getOption(char, String[])>
    //    5   10:astore_2        
        if(s_wr.length() != 0)
    //*   6   11:aload_2         
    //*   7   12:invokevirtual   #385 <Method int String.length()>
    //*   8   15:ifeq            26
            wr = Integer.parseInt(s_wr);
    //    9   18:aload_0         
    //   10   19:aload_2         
    //   11   20:invokestatic    #389 <Method int Integer.parseInt(String)>
    //   12   23:putfield        #128 <Field int wr>
        String s_wu = Utils.getOption('U', options);
    //   13   26:bipush          85
    //   14   28:aload_1         
    //   15   29:invokestatic    #382 <Method String Utils.getOption(char, String[])>
    //   16   32:astore_3        
        if(s_wu.length() != 0)
    //*  17   33:aload_3         
    //*  18   34:invokevirtual   #385 <Method int String.length()>
    //*  19   37:ifeq            48
            wu = Integer.parseInt(s_wu);
    //   20   40:aload_0         
    //   21   41:aload_3         
    //   22   42:invokestatic    #389 <Method int Integer.parseInt(String)>
    //   23   45:putfield        #130 <Field int wu>
        String s_wp = Utils.getOption('P', options);
    //   24   48:bipush          80
    //   25   50:aload_1         
    //   26   51:invokestatic    #382 <Method String Utils.getOption(char, String[])>
    //   27   54:astore          4
        if(s_wp.length() != 0)
    //*  28   56:aload           4
    //*  29   58:invokevirtual   #385 <Method int String.length()>
    //*  30   61:ifeq            73
            wp = Integer.parseInt(s_wp);
    //   31   64:aload_0         
    //   32   65:aload           4
    //   33   67:invokestatic    #389 <Method int Integer.parseInt(String)>
    //   34   70:putfield        #132 <Field int wp>
        String s_wh = Utils.getOption('H', options);
    //   35   73:bipush          72
    //   36   75:aload_1         
    //   37   76:invokestatic    #382 <Method String Utils.getOption(char, String[])>
    //   38   79:astore          5
        if(s_wu.length() != 0)
    //*  39   81:aload_3         
    //*  40   82:invokevirtual   #385 <Method int String.length()>
    //*  41   85:ifeq            97
            wh = Integer.parseInt(s_wh);
    //   42   88:aload_0         
    //   43   89:aload           5
    //   44   91:invokestatic    #389 <Method int Integer.parseInt(String)>
    //   45   94:putfield        #134 <Field int wh>
    //   46   97:return          
    }

    public String[] getOptions()
    {
        String options[] = new String[30];
    //    0    0:bipush          30
    //    1    2:anewarray       String[]
    //    2    5:astore_1        
        int current = 0;
    //    3    6:iconst_0        
    //    4    7:istore_2        
        options[current++] = "-R";
    //    5    8:aload_1         
    //    6    9:iload_2         
    //    7   10:iinc            2  1
    //    8   13:ldc2            #398 <String "-R">
    //    9   16:aastore         
        options[current++] = (new StringBuilder()).append(wr).toString();
    //   10   17:aload_1         
    //   11   18:iload_2         
    //   12   19:iinc            2  1
    //   13   22:new             #101 <Class StringBuilder>
    //   14   25:dup             
    //   15   26:invokespecial   #399 <Method void StringBuilder()>
    //   16   29:aload_0         
    //   17   30:getfield        #128 <Field int wr>
    //   18   33:invokevirtual   #110 <Method StringBuilder StringBuilder.append(int)>
    //   19   36:invokevirtual   #119 <Method String StringBuilder.toString()>
    //   20   39:aastore         
        options[current++] = "-U";
    //   21   40:aload_1         
    //   22   41:iload_2         
    //   23   42:iinc            2  1
    //   24   45:ldc2            #401 <String "-U">
    //   25   48:aastore         
        options[current++] = (new StringBuilder()).append(wu).toString();
    //   26   49:aload_1         
    //   27   50:iload_2         
    //   28   51:iinc            2  1
    //   29   54:new             #101 <Class StringBuilder>
    //   30   57:dup             
    //   31   58:invokespecial   #399 <Method void StringBuilder()>
    //   32   61:aload_0         
    //   33   62:getfield        #130 <Field int wu>
    //   34   65:invokevirtual   #110 <Method StringBuilder StringBuilder.append(int)>
    //   35   68:invokevirtual   #119 <Method String StringBuilder.toString()>
    //   36   71:aastore         
        options[current++] = "-P";
    //   37   72:aload_1         
    //   38   73:iload_2         
    //   39   74:iinc            2  1
    //   40   77:ldc2            #403 <String "-P">
    //   41   80:aastore         
        options[current++] = (new StringBuilder()).append(wp).toString();
    //   42   81:aload_1         
    //   43   82:iload_2         
    //   44   83:iinc            2  1
    //   45   86:new             #101 <Class StringBuilder>
    //   46   89:dup             
    //   47   90:invokespecial   #399 <Method void StringBuilder()>
    //   48   93:aload_0         
    //   49   94:getfield        #132 <Field int wp>
    //   50   97:invokevirtual   #110 <Method StringBuilder StringBuilder.append(int)>
    //   51  100:invokevirtual   #119 <Method String StringBuilder.toString()>
    //   52  103:aastore         
        options[current++] = "-H";
    //   53  104:aload_1         
    //   54  105:iload_2         
    //   55  106:iinc            2  1
    //   56  109:ldc2            #405 <String "-H">
    //   57  112:aastore         
        for(options[current++] = (new StringBuilder()).append(wh).toString(); current < options.length; options[current++] = "");
    //   58  113:aload_1         
    //   59  114:iload_2         
    //   60  115:iinc            2  1
    //   61  118:new             #101 <Class StringBuilder>
    //   62  121:dup             
    //   63  122:invokespecial   #399 <Method void StringBuilder()>
    //   64  125:aload_0         
    //   65  126:getfield        #134 <Field int wh>
    //   66  129:invokevirtual   #110 <Method StringBuilder StringBuilder.append(int)>
    //   67  132:invokevirtual   #119 <Method String StringBuilder.toString()>
    //   68  135:aastore         
    //   69  136:goto            148
    //   70  139:aload_1         
    //   71  140:iload_2         
    //   72  141:iinc            2  1
    //   73  144:ldc2            #407 <String "">
    //   74  147:aastore         
    //   75  148:iload_2         
    //   76  149:aload_1         
    //   77  150:arraylength     
    //   78  151:icmplt          139
        return options;
    //   79  154:aload_1         
    //   80  155:areturn         
    }

    public String toString()
    {
        return log.toString();
    //    0    0:aload_0         
    //    1    1:getfield        #34  <Field StringBuffer log>
    //    2    4:invokevirtual   #409 <Method String StringBuffer.toString()>
    //    3    7:areturn         
    }

    public Assignment generateRoles()
    {
        m_assroles = new Assignment();
    //    0    0:aload_0         
    //    1    1:new             #50  <Class Assignment>
    //    2    4:dup             
    //    3    5:invokespecial   #412 <Method void Assignment()>
    //    4    8:putfield        #414 <Field Assignment m_assroles>
        m_assroles.setAssignementName("role-permission");
    //    5   11:aload_0         
    //    6   12:getfield        #414 <Field Assignment m_assroles>
    //    7   15:ldc2            #416 <String "role-permission">
    //    8   18:invokevirtual   #419 <Method void Assignment.setAssignementName(String)>
        Matrix mat = new Matrix(nodes.size(), noPerms, (byte)0);
    //    9   21:new             #88  <Class Matrix>
    //   10   24:dup             
    //   11   25:aload_0         
    //   12   26:getfield        #162 <Field Vector nodes>
    //   13   29:invokevirtual   #167 <Method int Vector.size()>
    //   14   32:aload_0         
    //   15   33:getfield        #75  <Field int noPerms>
    //   16   36:iconst_0        
    //   17   37:invokespecial   #422 <Method void Matrix(int, int, byte)>
    //   18   40:astore_1        
        for(int i = 0; i < nodes.size(); i++)
    //*  19   41:iconst_0        
    //*  20   42:istore_2        
    //*  21   43:goto            99
        {
            IntegerSet upi = ((Concept)nodes.get(i)).allAttributes;
    //   22   46:aload_0         
    //   23   47:getfield        #162 <Field Vector nodes>
    //   24   50:iload_2         
    //   25   51:invokevirtual   #182 <Method Object Vector.get(int)>
    //   26   54:checkcast       #184 <Class Concept>
    //   27   57:getfield        #229 <Field IntegerSet Concept.allAttributes>
    //   28   60:astore_3        
            for(int j = 0; j < noPerms; j++)
    //*  29   61:iconst_0        
    //*  30   62:istore          4
    //*  31   64:goto            87
                if(upi.contains(j))
    //*  32   67:aload_3         
    //*  33   68:iload           4
    //*  34   70:invokevirtual   #426 <Method boolean IntegerSet.contains(int)>
    //*  35   73:ifeq            84
                    mat.set(i, j, (byte)1);
    //   36   76:aload_1         
    //   37   77:iload_2         
    //   38   78:iload           4
    //   39   80:iconst_1        
    //   40   81:invokevirtual   #428 <Method void Matrix.set(int, int, byte)>

    //   41   84:iinc            4  1
    //   42   87:iload           4
    //   43   89:aload_0         
    //   44   90:getfield        #75  <Field int noPerms>
    //   45   93:icmplt          67
        }

    //   46   96:iinc            2  1
    //   47   99:iload_2         
    //   48  100:aload_0         
    //   49  101:getfield        #162 <Field Vector nodes>
    //   50  104:invokevirtual   #167 <Method int Vector.size()>
    //   51  107:icmplt          46
        m_assroles.setAssignmentMatrix(mat);
    //   52  110:aload_0         
    //   53  111:getfield        #414 <Field Assignment m_assroles>
    //   54  114:aload_1         
    //   55  115:invokevirtual   #432 <Method void Assignment.setAssignmentMatrix(Matrix)>
        FastVector fv = new FastVector();
    //   56  118:new             #338 <Class FastVector>
    //   57  121:dup             
    //   58  122:invokespecial   #433 <Method void FastVector()>
    //   59  125:astore_2        
        for(int i = 0; i < nodes.size(); i++)
    //*  60  126:iconst_0        
    //*  61  127:istore_3        
    //*  62  128:goto            155
            fv.addElement((new StringBuilder("R")).append(i).toString());
    //   63  131:aload_2         
    //   64  132:new             #101 <Class StringBuilder>
    //   65  135:dup             
    //   66  136:ldc2            #343 <String "R">
    //   67  139:invokespecial   #106 <Method void StringBuilder(String)>
    //   68  142:iload_3         
    //   69  143:invokevirtual   #110 <Method StringBuilder StringBuilder.append(int)>
    //   70  146:invokevirtual   #119 <Method String StringBuilder.toString()>
    //   71  149:invokevirtual   #352 <Method void FastVector.addElement(Object)>

    //   72  152:iinc            3  1
    //   73  155:iload_3         
    //   74  156:aload_0         
    //   75  157:getfield        #162 <Field Vector nodes>
    //   76  160:invokevirtual   #167 <Method int Vector.size()>
    //   77  163:icmplt          131
        Attribute dxa = new Attribute("role", fv);
    //   78  166:new             #62  <Class Attribute>
    //   79  169:dup             
    //   80  170:ldc2            #435 <String "role">
    //   81  173:aload_2         
    //   82  174:invokespecial   #438 <Method void Attribute(String, FastVector)>
    //   83  177:astore_3        
        Dimension dx = new Dimension();
    //   84  178:new             #56  <Class Dimension>
    //   85  181:dup             
    //   86  182:invokespecial   #439 <Method void Dimension()>
    //   87  185:astore          4
        dx.setDimensionAttribute(dxa);
    //   88  187:aload           4
    //   89  189:aload_3         
    //   90  190:invokevirtual   #443 <Method void Dimension.setDimensionAttribute(Attribute)>
        StringBuffer parents[] = new StringBuffer[nodes.size()];
    //   91  193:aload_0         
    //   92  194:getfield        #162 <Field Vector nodes>
    //   93  197:invokevirtual   #167 <Method int Vector.size()>
    //   94  200:anewarray       StringBuffer[]
    //   95  203:astore          5
        for(int i = 0; i < nodes.size(); i++)
    //*  96  205:iconst_0        
    //*  97  206:istore          6
    //*  98  208:goto            226
            parents[i] = new StringBuffer();
    //   99  211:aload           5
    //  100  213:iload           6
    //  101  215:new             #31  <Class StringBuffer>
    //  102  218:dup             
    //  103  219:invokespecial   #32  <Method void StringBuffer()>
    //  104  222:aastore         

    //  105  223:iinc            6  1
    //  106  226:iload           6
    //  107  228:aload_0         
    //  108  229:getfield        #162 <Field Vector nodes>
    //  109  232:invokevirtual   #167 <Method int Vector.size()>
    //  110  235:icmplt          211
        for(int j = 0; j < edges.size(); j++)
    //* 111  238:iconst_0        
    //* 112  239:istore          6
    //* 113  241:goto            303
            parents[((rm.rolemining.lattice.ReducedLattices.LatticeEdge)edges.get(j)).to].append((new StringBuilder(String.valueOf(((rm.rolemining.lattice.ReducedLattices.LatticeEdge)edges.get(j)).from))).append("|").toString());
    //  114  244:aload           5
    //  115  246:aload_0         
    //  116  247:getfield        #244 <Field Vector edges>
    //  117  250:iload           6
    //  118  252:invokevirtual   #182 <Method Object Vector.get(int)>
    //  119  255:checkcast       #445 <Class rm.rolemining.lattice.ReducedLattices$LatticeEdge>
    //  120  258:getfield        #448 <Field int rm.rolemining.lattice.ReducedLattices$LatticeEdge.to>
    //  121  261:aaload          
    //  122  262:new             #101 <Class StringBuilder>
    //  123  265:dup             
    //  124  266:aload_0         
    //  125  267:getfield        #244 <Field Vector edges>
    //  126  270:iload           6
    //  127  272:invokevirtual   #182 <Method Object Vector.get(int)>
    //  128  275:checkcast       #445 <Class rm.rolemining.lattice.ReducedLattices$LatticeEdge>
    //  129  278:getfield        #451 <Field int rm.rolemining.lattice.ReducedLattices$LatticeEdge.from>
    //  130  281:invokestatic    #147 <Method String String.valueOf(int)>
    //  131  284:invokespecial   #106 <Method void StringBuilder(String)>
    //  132  287:ldc2            #453 <String "|">
    //  133  290:invokevirtual   #115 <Method StringBuilder StringBuilder.append(String)>
    //  134  293:invokevirtual   #119 <Method String StringBuilder.toString()>
    //  135  296:invokevirtual   #122 <Method StringBuffer StringBuffer.append(String)>
    //  136  299:pop             

    //  137  300:iinc            6  1
    //  138  303:iload           6
    //  139  305:aload_0         
    //  140  306:getfield        #244 <Field Vector edges>
    //  141  309:invokevirtual   #167 <Method int Vector.size()>
    //  142  312:icmplt          244
        for(int i = 0; i < nodes.size(); i++)
    //* 143  315:iconst_0        
    //* 144  316:istore          6
    //* 145  318:goto            355
            if(parents[i].length() > 1)
    //* 146  321:aload           5
    //* 147  323:iload           6
    //* 148  325:aaload          
    //* 149  326:invokevirtual   #454 <Method int StringBuffer.length()>
    //* 150  329:iconst_1        
    //* 151  330:icmple          352
                parents[i].deleteCharAt(parents[i].length() - 1);
    //  152  333:aload           5
    //  153  335:iload           6
    //  154  337:aaload          
    //  155  338:aload           5
    //  156  340:iload           6
    //  157  342:aaload          
    //  158  343:invokevirtual   #454 <Method int StringBuffer.length()>
    //  159  346:iconst_1        
    //  160  347:isub            
    //  161  348:invokevirtual   #458 <Method StringBuffer StringBuffer.deleteCharAt(int)>
    //  162  351:pop             

    //  163  352:iinc            6  1
    //  164  355:iload           6
    //  165  357:aload_0         
    //  166  358:getfield        #162 <Field Vector nodes>
    //  167  361:invokevirtual   #167 <Method int Vector.size()>
    //  168  364:icmplt          321
        Attribute att = new Attribute("parents", "");
    //  169  367:new             #62  <Class Attribute>
    //  170  370:dup             
    //  171  371:ldc2            #460 <String "parents">
    //  172  374:aconst_null     
    //  173  375:invokespecial   #438 <Method void Attribute(String, FastVector)>
    //  174  378:astore          6
        FastVector fv_atts = new FastVector();
    //  175  380:new             #338 <Class FastVector>
    //  176  383:dup             
    //  177  384:invokespecial   #433 <Method void FastVector()>
    //  178  387:astore          7
        fv_atts.addElement(att);
    //  179  389:aload           7
    //  180  391:aload           6
    //  181  393:invokevirtual   #352 <Method void FastVector.addElement(Object)>
        Instances insSet = new Instances("role", fv_atts, 0);
    //  182  396:new             #462 <Class Instances>
    //  183  399:dup             
    //  184  400:ldc2            #435 <String "role">
    //  185  403:aload           7
    //  186  405:iconst_0        
    //  187  406:invokespecial   #465 <Method void Instances(String, FastVector, int)>
    //  188  409:astore          8
        for(int i = 0; i < nodes.size(); i++)
    //* 189  411:iconst_0        
    //* 190  412:istore          9
    //* 191  414:goto            459
        {
            Instance insi = new Instance(1);
    //  192  417:new             #467 <Class Instance>
    //  193  420:dup             
    //  194  421:iconst_1        
    //  195  422:invokespecial   #468 <Method void Instance(int)>
    //  196  425:astore          10
            insi.setDataset(insSet);
    //  197  427:aload           10
    //  198  429:aload           8
    //  199  431:invokevirtual   #472 <Method void Instance.setDataset(Instances)>
            insi.setValue(att, parents[i].toString());
    //  200  434:aload           10
    //  201  436:aload           6
    //  202  438:aload           5
    //  203  440:iload           9
    //  204  442:aaload          
    //  205  443:invokevirtual   #409 <Method String StringBuffer.toString()>
    //  206  446:invokevirtual   #476 <Method void Instance.setValue(Attribute, String)>
            insSet.add(insi);
    //  207  449:aload           8
    //  208  451:aload           10
    //  209  453:invokevirtual   #480 <Method void Instances.add(Instance)>
        }

    //  210  456:iinc            9  1
    //  211  459:iload           9
    //  212  461:aload_0         
    //  213  462:getfield        #162 <Field Vector nodes>
    //  214  465:invokevirtual   #167 <Method int Vector.size()>
    //  215  468:icmplt          417
        dx.setDimensionInstances(insSet);
    //  216  471:aload           4
    //  217  473:aload           8
    //  218  475:invokevirtual   #483 <Method void Dimension.setDimensionInstances(Instances)>
        m_assroles.setDimensionX(dx);
    //  219  478:aload_0         
    //  220  479:getfield        #414 <Field Assignment m_assroles>
    //  221  482:aload           4
    //  222  484:invokevirtual   #487 <Method void Assignment.setDimensionX(Dimension)>
        Attribute dya = m_assignment.getDimensionY().getDimensionAttribute();
    //  223  487:aload_0         
    //  224  488:getfield        #48  <Field Assignment m_assignment>
    //  225  491:invokevirtual   #73  <Method Dimension Assignment.getDimensionY()>
    //  226  494:invokevirtual   #60  <Method Attribute Dimension.getDimensionAttribute()>
    //  227  497:astore          9
        Dimension dy = new Dimension();
    //  228  499:new             #56  <Class Dimension>
    //  229  502:dup             
    //  230  503:invokespecial   #439 <Method void Dimension()>
    //  231  506:astore          10
        dy.setDimensionAttribute(dya);
    //  232  508:aload           10
    //  233  510:aload           9
    //  234  512:invokevirtual   #443 <Method void Dimension.setDimensionAttribute(Attribute)>
        m_assroles.setDimensionY(dy);
    //  235  515:aload_0         
    //  236  516:getfield        #414 <Field Assignment m_assroles>
    //  237  519:aload           10
    //  238  521:invokevirtual   #490 <Method void Assignment.setDimensionY(Dimension)>
        return m_assroles;
    //  239  524:aload_0         
    //  240  525:getfield        #414 <Field Assignment m_assroles>
    //  241  528:areturn         
    }

    public int getWr()
    {
        return wr;
    //    0    0:aload_0         
    //    1    1:getfield        #128 <Field int wr>
    //    2    4:ireturn         
    }

    public void setWr(int wr)
    {
        this.wr = wr;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #128 <Field int wr>
    //    3    5:return          
    }

    public String wrTipText()
    {
        return "The required weight of number of role for WSC.";
    //    0    0:ldc2            #510 <String "The required weight of number of role for WSC.">
    //    1    3:areturn         
    }

    public int getWu()
    {
        return wu;
    //    0    0:aload_0         
    //    1    1:getfield        #130 <Field int wu>
    //    2    4:ireturn         
    }

    public void setWu(int wu)
    {
        this.wu = wu;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #130 <Field int wu>
    //    3    5:return          
    }

    public String wuTipText()
    {
        return "The required weight of number of user for WSC.";
    //    0    0:ldc2            #515 <String "The required weight of number of user for WSC.">
    //    1    3:areturn         
    }

    public int getWp()
    {
        return wp;
    //    0    0:aload_0         
    //    1    1:getfield        #132 <Field int wp>
    //    2    4:ireturn         
    }

    public void setWp(int wp)
    {
        this.wp = wp;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #132 <Field int wp>
    //    3    5:return          
    }

    public String wpTipText()
    {
        return "The required weight of number of permission for WSC.";
    //    0    0:ldc2            #520 <String "The required weight of number of permission for WSC.">
    //    1    3:areturn         
    }

    public int getWh()
    {
        return wh;
    //    0    0:aload_0         
    //    1    1:getfield        #134 <Field int wh>
    //    2    4:ireturn         
    }

    public void setWh(int wh)
    {
        this.wh = wh;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #134 <Field int wh>
    //    3    5:return          
    }

    public String whTipText()
    {
        return "The required weight of number of roles' hierarchy for WSC.";
    //    0    0:ldc2            #525 <String "The required weight of number of roles' hierarchy for WSC.">
    //    1    3:areturn         
    }

    public static void main(String args[])
    {
        Assignment Ass = null;
    //    0    0:aconst_null     
    //    1    1:astore_1        
        try
        {
            File file = new File((new StringBuilder(String.valueOf(System.getProperty("user.dir")))).append("\\datasets\\university_runningexample.ass").toString());
    //    2    2:new             #528 <Class File>
    //    3    5:dup             
    //    4    6:new             #101 <Class StringBuilder>
    //    5    9:dup             
    //    6   10:ldc2            #530 <String "user.dir">
    //    7   13:invokestatic    #536 <Method String System.getProperty(String)>
    //    8   16:invokestatic    #539 <Method String String.valueOf(Object)>
    //    9   19:invokespecial   #106 <Method void StringBuilder(String)>
    //   10   22:ldc2            #541 <String "\\datasets\\university_runningexample.ass">
    //   11   25:invokevirtual   #115 <Method StringBuilder StringBuilder.append(String)>
    //   12   28:invokevirtual   #119 <Method String StringBuilder.toString()>
    //   13   31:invokespecial   #542 <Method void File(String)>
    //   14   34:astore_2        
            AssLoader AL = new AssLoader(new FileReader(file));
    //   15   35:new             #544 <Class AssLoader>
    //   16   38:dup             
    //   17   39:new             #546 <Class FileReader>
    //   18   42:dup             
    //   19   43:aload_2         
    //   20   44:invokespecial   #549 <Method void FileReader(File)>
    //   21   47:invokespecial   #552 <Method void AssLoader(FileReader)>
    //   22   50:astore_3        
            Ass = AL.getData();
    //   23   51:aload_3         
    //   24   52:invokevirtual   #555 <Method Assignment AssLoader.getData()>
    //   25   55:astore_1        
            System.out.println(Ass.getAssignementName());
    //   26   56:getstatic       #559 <Field PrintStream System.out>
    //   27   59:aload_1         
    //   28   60:invokevirtual   #562 <Method String Assignment.getAssignementName()>
    //   29   63:invokevirtual   #567 <Method void PrintStream.println(String)>
            HierarchicalMiner hm = new HierarchicalMiner();
    //   30   66:new             #2   <Class HierarchicalMiner>
    //   31   69:dup             
    //   32   70:invokespecial   #568 <Method void HierarchicalMiner()>
    //   33   73:astore          4
            hm.buildRoleminers(Ass);
    //   34   75:aload           4
    //   35   77:aload_1         
    //   36   78:invokevirtual   #570 <Method void buildRoleminers(Assignment)>
            System.out.println(hm.toString());
    //   37   81:getstatic       #559 <Field PrintStream System.out>
    //   38   84:aload           4
    //   39   86:invokevirtual   #571 <Method String toString()>
    //   40   89:invokevirtual   #567 <Method void PrintStream.println(String)>
            System.out.println(hm.generateRoles());
    //   41   92:getstatic       #559 <Field PrintStream System.out>
    //   42   95:aload           4
    //   43   97:invokevirtual   #573 <Method Assignment generateRoles()>
    //   44  100:invokevirtual   #575 <Method void PrintStream.println(Object)>
        }
    //*  45  103:goto            111
        catch(Exception e)
    //*  46  106:astore_2        
        {
            e.printStackTrace();
    //   47  107:aload_2         
    //   48  108:invokevirtual   #578 <Method void Exception.printStackTrace()>
        }
    //   49  111:return          
    }

    private int wr;
    private int wu;
    private int wp;
    private int wh;
    private int noUsers;
    private int noPerms;
    private rm.rolemining.lattice.ReducedLattices.WSC beforewsc;
    private rm.rolemining.lattice.ReducedLattices.WSC afterwsc;
    private rm.rolemining.lattice.ReducedLattices.WSC minwsc;
    Assignment m_assignment;
    Assignment m_assroles;
    StringBuffer log;
    Context f_context;
}
