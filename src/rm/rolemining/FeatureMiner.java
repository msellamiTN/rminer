// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   FeatureMiner.java

package rm.rolemining;

import java.io.*;
import java.util.*;
import rm.core.*;
import rm.core.converters.AssLoader;
import rm.rolemining.lattice.Concept;
import rm.rolemining.lattice.Context;
import rm.rolemining.lattice.IntegerSet;
import rm.rolemining.lattice.RC;
import rm.rolemining.lattice.ReducedLattices;

public class FeatureMiner extends ReducedLattices
    implements OptionHandler
{

    public FeatureMiner()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #43  <Method void ReducedLattices()>
        Copynodes = new Vector();
    //    2    4:aload_0         
    //    3    5:new             #45  <Class Vector>
    //    4    8:dup             
    //    5    9:invokespecial   #46  <Method void Vector()>
    //    6   12:putfield        #48  <Field Vector Copynodes>
        Copyedges = new Vector();
    //    7   15:aload_0         
    //    8   16:new             #45  <Class Vector>
    //    9   19:dup             
    //   10   20:invokespecial   #46  <Method void Vector()>
    //   11   23:putfield        #50  <Field Vector Copyedges>
        log = new StringBuffer();
    //   12   26:aload_0         
    //   13   27:new             #52  <Class StringBuffer>
    //   14   30:dup             
    //   15   31:invokespecial   #53  <Method void StringBuffer()>
    //   16   34:putfield        #55  <Field StringBuffer log>
        resetOptions();
    //   17   37:aload_0         
    //   18   38:invokevirtual   #58  <Method void resetOptions()>
    //   19   41:return          
    }

    public void buildRoleminers(Assignment data)
    {
        m_assignment = data;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #66  <Field Assignment m_assignment>
        Object set[] = m_assignment.getDimensionX().getDimensionAttribute().toArray();
    //    3    5:aload_0         
    //    4    6:getfield        #66  <Field Assignment m_assignment>
    //    5    9:invokevirtual   #72  <Method Dimension Assignment.getDimensionX()>
    //    6   12:invokevirtual   #78  <Method Attribute Dimension.getDimensionAttribute()>
    //    7   15:invokevirtual   #84  <Method Object[] Attribute.toArray()>
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
    //   16   28:putfield        #88  <Field int noUsers>
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
    //   25   44:checkcast       #86  <Class String>
    //   26   47:aastore         

    //   27   48:iinc            4  1
    //   28   51:iload           4
    //   29   53:aload_2         
    //   30   54:arraylength     
    //   31   55:icmplt          37
        set = m_assignment.getDimensionY().getDimensionAttribute().toArray();
    //   32   58:aload_0         
    //   33   59:getfield        #66  <Field Assignment m_assignment>
    //   34   62:invokevirtual   #91  <Method Dimension Assignment.getDimensionY()>
    //   35   65:invokevirtual   #78  <Method Attribute Dimension.getDimensionAttribute()>
    //   36   68:invokevirtual   #84  <Method Object[] Attribute.toArray()>
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
    //   45   82:putfield        #93  <Field int noPerms>
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
    //   54   99:checkcast       #86  <Class String>
    //   55  102:aastore         

    //   56  103:iinc            5  1
    //   57  106:iload           5
    //   58  108:aload_2         
    //   59  109:arraylength     
    //   60  110:icmplt          91
        Matrix mat = m_assignment.getAssignmentMatrix();
    //   61  113:aload_0         
    //   62  114:getfield        #66  <Field Assignment m_assignment>
    //   63  117:invokevirtual   #97  <Method Matrix Assignment.getAssignmentMatrix()>
    //   64  120:astore          5
        f_context = new Context(userSet, permSet, mat, log);
    //   65  122:aload_0         
    //   66  123:new             #99  <Class Context>
    //   67  126:dup             
    //   68  127:aload_3         
    //   69  128:aload           4
    //   70  130:aload           5
    //   71  132:aload_0         
    //   72  133:getfield        #55  <Field StringBuffer log>
    //   73  136:invokespecial   #102 <Method void Context(String[], String[], Matrix, StringBuffer)>
    //   74  139:putfield        #104 <Field Context f_context>
        setContext(f_context, log);
    //   75  142:aload_0         
    //   76  143:aload_0         
    //   77  144:getfield        #104 <Field Context f_context>
    //   78  147:aload_0         
    //   79  148:getfield        #55  <Field StringBuffer log>
    //   80  151:invokevirtual   #108 <Method void setContext(Context, StringBuffer)>
        setWeights(wr, wu, wp, wh);
    //   81  154:aload_0         
    //   82  155:aload_0         
    //   83  156:getfield        #110 <Field int wr>
    //   84  159:aload_0         
    //   85  160:getfield        #112 <Field int wu>
    //   86  163:aload_0         
    //   87  164:getfield        #114 <Field int wp>
    //   88  167:aload_0         
    //   89  168:getfield        #116 <Field int wh>
    //   90  171:invokevirtual   #120 <Method void setWeights(int, int, int, int)>
        ReduceEdges();
    //   91  174:aload_0         
    //   92  175:invokevirtual   #124 <Method int ReduceEdges()>
    //   93  178:pop             
        Copynodesflags = new boolean[nodes.size()];
    //   94  179:aload_0         
    //   95  180:aload_0         
    //   96  181:getfield        #127 <Field Vector nodes>
    //   97  184:invokevirtual   #130 <Method int Vector.size()>
    //   98  187:newarray        boolean[]
    //   99  189:putfield        #132 <Field boolean[] Copynodesflags>
        nodesflags = new boolean[nodes.size()];
    //  100  192:aload_0         
    //  101  193:aload_0         
    //  102  194:getfield        #127 <Field Vector nodes>
    //  103  197:invokevirtual   #130 <Method int Vector.size()>
    //  104  200:newarray        boolean[]
    //  105  202:putfield        #134 <Field boolean[] nodesflags>
        for(int i = 0; i < nodes.size(); i++)
    //* 106  205:iconst_0        
    //* 107  206:istore          6
    //* 108  208:goto            230
        {
            nodesflags[i] = false;
    //  109  211:aload_0         
    //  110  212:getfield        #134 <Field boolean[] nodesflags>
    //  111  215:iload           6
    //  112  217:iconst_0        
    //  113  218:bastore         
            Copynodesflags[i] = false;
    //  114  219:aload_0         
    //  115  220:getfield        #132 <Field boolean[] Copynodesflags>
    //  116  223:iload           6
    //  117  225:iconst_0        
    //  118  226:bastore         
        }

    //  119  227:iinc            6  1
    //  120  230:iload           6
    //  121  232:aload_0         
    //  122  233:getfield        #127 <Field Vector nodes>
    //  123  236:invokevirtual   #130 <Method int Vector.size()>
    //  124  239:icmplt          211
        beforewsc = ComputeWSC();
    //  125  242:aload_0         
    //  126  243:aload_0         
    //  127  244:invokevirtual   #138 <Method rm.rolemining.lattice.ReducedLattices$WSC ComputeWSC()>
    //  128  247:putfield        #140 <Field rm.rolemining.lattice.ReducedLattices$WSC beforewsc>
        CopyState();
    //  129  250:aload_0         
    //  130  251:invokespecial   #143 <Method void CopyState()>
        int beforedone = 0;
    //  131  254:iconst_0        
    //  132  255:istore          6
        int done = 1;
    //  133  257:iconst_1        
    //  134  258:istore          7
        log.append("Begin Generate Roles. \n");
    //  135  260:aload_0         
    //  136  261:getfield        #55  <Field StringBuffer log>
    //  137  264:ldc1            #145 <String "Begin Generate Roles. \n">
    //  138  266:invokevirtual   #149 <Method StringBuffer StringBuffer.append(String)>
    //  139  269:pop             
        ArrayList Exeseq = NodesSort();
    //  140  270:aload_0         
    //  141  271:invokespecial   #153 <Method ArrayList NodesSort()>
    //  142  274:astore          8
        int HaveDone = 0;
    //  143  276:iconst_0        
    //  144  277:istore          9
    //* 145  279:goto            1006
        while(done > 0) 
        {
            done = 0;
    //  146  282:iconst_0        
    //  147  283:istore          7
            for(int i = 0; i < Exeseq.size(); i++)
    //* 148  285:iconst_0        
    //* 149  286:istore          10
    //* 150  288:goto            996
            {
                int curnode = ((Integer)(Integer)Exeseq.get(i)).intValue();
    //  151  291:aload           8
    //  152  293:iload           10
    //  153  295:invokevirtual   #159 <Method Object ArrayList.get(int)>
    //  154  298:checkcast       #161 <Class Integer>
    //  155  301:checkcast       #161 <Class Integer>
    //  156  304:invokevirtual   #164 <Method int Integer.intValue()>
    //  157  307:istore          11
                if(!nodesflags[curnode])
    //* 158  309:aload_0         
    //* 159  310:getfield        #134 <Field boolean[] nodesflags>
    //* 160  313:iload           11
    //* 161  315:baload          
    //* 162  316:ifne            993
                {
                    log.append((new StringBuilder(String.valueOf(curnode))).append("  :\n").toString());
    //  163  319:aload_0         
    //  164  320:getfield        #55  <Field StringBuffer log>
    //  165  323:new             #166 <Class StringBuilder>
    //  166  326:dup             
    //  167  327:iload           11
    //  168  329:invokestatic    #170 <Method String String.valueOf(int)>
    //  169  332:invokespecial   #173 <Method void StringBuilder(String)>
    //  170  335:ldc1            #175 <String "  :\n">
    //  171  337:invokevirtual   #178 <Method StringBuilder StringBuilder.append(String)>
    //  172  340:invokevirtual   #182 <Method String StringBuilder.toString()>
    //  173  343:invokevirtual   #149 <Method StringBuffer StringBuffer.append(String)>
    //  174  346:pop             
                    PrintNode(Integer.valueOf(curnode));
    //  175  347:aload_0         
    //  176  348:iload           11
    //  177  350:invokestatic    #185 <Method Integer Integer.valueOf(int)>
    //  178  353:invokevirtual   #189 <Method void PrintNode(Integer)>
                    beforedone = done;
    //  179  356:iload           7
    //  180  358:istore          6
                    HaveDone = 0;
    //  181  360:iconst_0        
    //  182  361:istore          9
                    ArrayList Jun = getJun(curnode);
    //  183  363:aload_0         
    //  184  364:iload           11
    //  185  366:invokevirtual   #193 <Method ArrayList getJun(int)>
    //  186  369:astore          12
                    ArrayList Sen = getSen(curnode);
    //  187  371:aload_0         
    //  188  372:iload           11
    //  189  374:invokevirtual   #196 <Method ArrayList getSen(int)>
    //  190  377:astore          13
                    ArrayList Thr = getThr(curnode);
    //  191  379:aload_0         
    //  192  380:iload           11
    //  193  382:invokevirtual   #199 <Method ArrayList getThr(int)>
    //  194  385:astore          14
                    if(((Concept)nodes.get(curnode)).getNumberOfObjects() == 0 && ((Concept)nodes.get(curnode)).getNumberOfAttributes() == 0)
    //* 195  387:aload_0         
    //* 196  388:getfield        #127 <Field Vector nodes>
    //* 197  391:iload           11
    //* 198  393:invokevirtual   #200 <Method Object Vector.get(int)>
    //* 199  396:checkcast       #202 <Class Concept>
    //* 200  399:invokevirtual   #205 <Method int Concept.getNumberOfObjects()>
    //* 201  402:ifne            444
    //* 202  405:aload_0         
    //* 203  406:getfield        #127 <Field Vector nodes>
    //* 204  409:iload           11
    //* 205  411:invokevirtual   #200 <Method Object Vector.get(int)>
    //* 206  414:checkcast       #202 <Class Concept>
    //* 207  417:invokevirtual   #208 <Method int Concept.getNumberOfAttributes()>
    //* 208  420:ifne            444
                    {
                        Update(curnode, Thr);
    //  209  423:aload_0         
    //  210  424:iload           11
    //  211  426:aload           14
    //  212  428:invokevirtual   #212 <Method void Update(int, ArrayList)>
                        DeleteNode(curnode);
    //  213  431:aload_0         
    //  214  432:iload           11
    //  215  434:invokevirtual   #216 <Method int DeleteNode(int)>
    //  216  437:pop             
                        HaveDone = 1;
    //  217  438:iconst_1        
    //  218  439:istore          9
                    } else
    //* 219  441:goto            930
                    if(((Concept)nodes.get(curnode)).getNumberOfObjects() == 0 && ((Concept)nodes.get(curnode)).getNumberOfAttributes() > 0)
    //* 220  444:aload_0         
    //* 221  445:getfield        #127 <Field Vector nodes>
    //* 222  448:iload           11
    //* 223  450:invokevirtual   #200 <Method Object Vector.get(int)>
    //* 224  453:checkcast       #202 <Class Concept>
    //* 225  456:invokevirtual   #205 <Method int Concept.getNumberOfObjects()>
    //* 226  459:ifne            694
    //* 227  462:aload_0         
    //* 228  463:getfield        #127 <Field Vector nodes>
    //* 229  466:iload           11
    //* 230  468:invokevirtual   #200 <Method Object Vector.get(int)>
    //* 231  471:checkcast       #202 <Class Concept>
    //* 232  474:invokevirtual   #208 <Method int Concept.getNumberOfAttributes()>
    //* 233  477:ifle            694
                    {
                        String rcur = TranslateAttributelist(((Concept)nodes.get(curnode)).allAttributes);
    //  234  480:aload_0         
    //  235  481:aload_0         
    //  236  482:getfield        #127 <Field Vector nodes>
    //  237  485:iload           11
    //  238  487:invokevirtual   #200 <Method Object Vector.get(int)>
    //  239  490:checkcast       #202 <Class Concept>
    //  240  493:getfield        #220 <Field IntegerSet Concept.allAttributes>
    //  241  496:invokevirtual   #224 <Method String TranslateAttributelist(IntegerSet)>
    //  242  499:astore          15
                        int Counter = 0;
    //  243  501:iconst_0        
    //  244  502:istore          16
                        for(int j = 0; j < Sen.size(); j++)
    //* 245  504:iconst_0        
    //* 246  505:istore          17
    //* 247  507:goto            653
                        {
                            String rsen_j = TranslateAttributelist(((Concept)nodes.get(((Integer)Sen.get(j)).intValue())).allAttributes);
    //  248  510:aload_0         
    //  249  511:aload_0         
    //  250  512:getfield        #127 <Field Vector nodes>
    //  251  515:aload           13
    //  252  517:iload           17
    //  253  519:invokevirtual   #159 <Method Object ArrayList.get(int)>
    //  254  522:checkcast       #161 <Class Integer>
    //  255  525:invokevirtual   #164 <Method int Integer.intValue()>
    //  256  528:invokevirtual   #200 <Method Object Vector.get(int)>
    //  257  531:checkcast       #202 <Class Concept>
    //  258  534:getfield        #220 <Field IntegerSet Concept.allAttributes>
    //  259  537:invokevirtual   #224 <Method String TranslateAttributelist(IntegerSet)>
    //  260  540:astore          18
                            if(RC.ComputeRC(rcur, rsen_j) < t)
    //* 261  542:aload           15
    //* 262  544:aload           18
    //* 263  546:invokestatic    #230 <Method double RC.ComputeRC(String, String)>
    //* 264  549:aload_0         
    //* 265  550:getfield        #232 <Field double t>
    //* 266  553:dcmpg           
    //* 267  554:ifge            650
                            {
                                DeleteEdge(((Integer)Sen.get(j)).intValue(), curnode);
    //  268  557:aload_0         
    //  269  558:aload           13
    //  270  560:iload           17
    //  271  562:invokevirtual   #159 <Method Object ArrayList.get(int)>
    //  272  565:checkcast       #161 <Class Integer>
    //  273  568:invokevirtual   #164 <Method int Integer.intValue()>
    //  274  571:iload           11
    //  275  573:invokevirtual   #236 <Method int DeleteEdge(int, int)>
    //  276  576:pop             
                                ((Concept)nodes.get(((Integer)Sen.get(j)).intValue())).allAttributes = ((Concept)nodes.get(((Integer)Sen.get(j)).intValue())).allAttributes.getUnion(((Concept)nodes.get(curnode)).allAttributes);
    //  277  577:aload_0         
    //  278  578:getfield        #127 <Field Vector nodes>
    //  279  581:aload           13
    //  280  583:iload           17
    //  281  585:invokevirtual   #159 <Method Object ArrayList.get(int)>
    //  282  588:checkcast       #161 <Class Integer>
    //  283  591:invokevirtual   #164 <Method int Integer.intValue()>
    //  284  594:invokevirtual   #200 <Method Object Vector.get(int)>
    //  285  597:checkcast       #202 <Class Concept>
    //  286  600:aload_0         
    //  287  601:getfield        #127 <Field Vector nodes>
    //  288  604:aload           13
    //  289  606:iload           17
    //  290  608:invokevirtual   #159 <Method Object ArrayList.get(int)>
    //  291  611:checkcast       #161 <Class Integer>
    //  292  614:invokevirtual   #164 <Method int Integer.intValue()>
    //  293  617:invokevirtual   #200 <Method Object Vector.get(int)>
    //  294  620:checkcast       #202 <Class Concept>
    //  295  623:getfield        #220 <Field IntegerSet Concept.allAttributes>
    //  296  626:aload_0         
    //  297  627:getfield        #127 <Field Vector nodes>
    //  298  630:iload           11
    //  299  632:invokevirtual   #200 <Method Object Vector.get(int)>
    //  300  635:checkcast       #202 <Class Concept>
    //  301  638:getfield        #220 <Field IntegerSet Concept.allAttributes>
    //  302  641:invokevirtual   #242 <Method IntegerSet IntegerSet.getUnion(IntegerSet)>
    //  303  644:putfield        #220 <Field IntegerSet Concept.allAttributes>
                                Counter++;
    //  304  647:iinc            16  1
                            }
                        }

    //  305  650:iinc            17  1
    //  306  653:iload           17
    //  307  655:aload           13
    //  308  657:invokevirtual   #243 <Method int ArrayList.size()>
    //  309  660:icmplt          510
                        if(Counter == Sen.size())
    //* 310  663:iload           16
    //* 311  665:aload           13
    //* 312  667:invokevirtual   #243 <Method int ArrayList.size()>
    //* 313  670:icmpne          930
                        {
                            Update(curnode, Thr);
    //  314  673:aload_0         
    //  315  674:iload           11
    //  316  676:aload           14
    //  317  678:invokevirtual   #212 <Method void Update(int, ArrayList)>
                            DeleteNode(curnode);
    //  318  681:aload_0         
    //  319  682:iload           11
    //  320  684:invokevirtual   #216 <Method int DeleteNode(int)>
    //  321  687:pop             
                            HaveDone = 1;
    //  322  688:iconst_1        
    //  323  689:istore          9
                        }
                    } else
    //* 324  691:goto            930
                    if(((Concept)nodes.get(curnode)).getNumberOfObjects() > 0 && ((Concept)nodes.get(curnode)).getNumberOfAttributes() == 0)
    //* 325  694:aload_0         
    //* 326  695:getfield        #127 <Field Vector nodes>
    //* 327  698:iload           11
    //* 328  700:invokevirtual   #200 <Method Object Vector.get(int)>
    //* 329  703:checkcast       #202 <Class Concept>
    //* 330  706:invokevirtual   #205 <Method int Concept.getNumberOfObjects()>
    //* 331  709:ifle            930
    //* 332  712:aload_0         
    //* 333  713:getfield        #127 <Field Vector nodes>
    //* 334  716:iload           11
    //* 335  718:invokevirtual   #200 <Method Object Vector.get(int)>
    //* 336  721:checkcast       #202 <Class Concept>
    //* 337  724:invokevirtual   #208 <Method int Concept.getNumberOfAttributes()>
    //* 338  727:ifne            930
                    {
                        int Counter = 0;
    //  339  730:iconst_0        
    //  340  731:istore          15
                        for(int j = 0; j < Jun.size(); j++)
    //* 341  733:iconst_0        
    //* 342  734:istore          16
    //* 343  736:goto            892
                        {
                            String rcur = TranslateAttributelist(((Concept)nodes.get(((Integer)Jun.get(j)).intValue())).allAttributes);
    //  344  739:aload_0         
    //  345  740:aload_0         
    //  346  741:getfield        #127 <Field Vector nodes>
    //  347  744:aload           12
    //  348  746:iload           16
    //  349  748:invokevirtual   #159 <Method Object ArrayList.get(int)>
    //  350  751:checkcast       #161 <Class Integer>
    //  351  754:invokevirtual   #164 <Method int Integer.intValue()>
    //  352  757:invokevirtual   #200 <Method Object Vector.get(int)>
    //  353  760:checkcast       #202 <Class Concept>
    //  354  763:getfield        #220 <Field IntegerSet Concept.allAttributes>
    //  355  766:invokevirtual   #224 <Method String TranslateAttributelist(IntegerSet)>
    //  356  769:astore          17
                            String rjun_j = ExceptCurrJun(Jun, j);
    //  357  771:aload_0         
    //  358  772:aload           12
    //  359  774:iload           16
    //  360  776:invokevirtual   #247 <Method String ExceptCurrJun(ArrayList, int)>
    //  361  779:astore          18
                            if(RC.ComputeRC(rcur, rjun_j) > t)
    //* 362  781:aload           17
    //* 363  783:aload           18
    //* 364  785:invokestatic    #230 <Method double RC.ComputeRC(String, String)>
    //* 365  788:aload_0         
    //* 366  789:getfield        #232 <Field double t>
    //* 367  792:dcmpl           
    //* 368  793:ifle            889
                            {
                                DeleteEdge(curnode, ((Integer)Jun.get(j)).intValue());
    //  369  796:aload_0         
    //  370  797:iload           11
    //  371  799:aload           12
    //  372  801:iload           16
    //  373  803:invokevirtual   #159 <Method Object ArrayList.get(int)>
    //  374  806:checkcast       #161 <Class Integer>
    //  375  809:invokevirtual   #164 <Method int Integer.intValue()>
    //  376  812:invokevirtual   #236 <Method int DeleteEdge(int, int)>
    //  377  815:pop             
                                ((Concept)nodes.get(((Integer)Jun.get(j)).intValue())).allObjects = ((Concept)nodes.get(((Integer)Jun.get(j)).intValue())).allObjects.getUnion(((Concept)nodes.get(curnode)).allObjects);
    //  378  816:aload_0         
    //  379  817:getfield        #127 <Field Vector nodes>
    //  380  820:aload           12
    //  381  822:iload           16
    //  382  824:invokevirtual   #159 <Method Object ArrayList.get(int)>
    //  383  827:checkcast       #161 <Class Integer>
    //  384  830:invokevirtual   #164 <Method int Integer.intValue()>
    //  385  833:invokevirtual   #200 <Method Object Vector.get(int)>
    //  386  836:checkcast       #202 <Class Concept>
    //  387  839:aload_0         
    //  388  840:getfield        #127 <Field Vector nodes>
    //  389  843:aload           12
    //  390  845:iload           16
    //  391  847:invokevirtual   #159 <Method Object ArrayList.get(int)>
    //  392  850:checkcast       #161 <Class Integer>
    //  393  853:invokevirtual   #164 <Method int Integer.intValue()>
    //  394  856:invokevirtual   #200 <Method Object Vector.get(int)>
    //  395  859:checkcast       #202 <Class Concept>
    //  396  862:getfield        #250 <Field IntegerSet Concept.allObjects>
    //  397  865:aload_0         
    //  398  866:getfield        #127 <Field Vector nodes>
    //  399  869:iload           11
    //  400  871:invokevirtual   #200 <Method Object Vector.get(int)>
    //  401  874:checkcast       #202 <Class Concept>
    //  402  877:getfield        #250 <Field IntegerSet Concept.allObjects>
    //  403  880:invokevirtual   #242 <Method IntegerSet IntegerSet.getUnion(IntegerSet)>
    //  404  883:putfield        #250 <Field IntegerSet Concept.allObjects>
                                Counter++;
    //  405  886:iinc            15  1
                            }
                        }

    //  406  889:iinc            16  1
    //  407  892:iload           16
    //  408  894:aload           12
    //  409  896:invokevirtual   #243 <Method int ArrayList.size()>
    //  410  899:icmplt          739
                        if(Counter == Jun.size())
    //* 411  902:iload           15
    //* 412  904:aload           12
    //* 413  906:invokevirtual   #243 <Method int ArrayList.size()>
    //* 414  909:icmpne          930
                        {
                            Update(curnode, Thr);
    //  415  912:aload_0         
    //  416  913:iload           11
    //  417  915:aload           14
    //  418  917:invokevirtual   #212 <Method void Update(int, ArrayList)>
                            DeleteNode(curnode);
    //  419  920:aload_0         
    //  420  921:iload           11
    //  421  923:invokevirtual   #216 <Method int DeleteNode(int)>
    //  422  926:pop             
                            HaveDone = 1;
    //  423  927:iconst_1        
    //  424  928:istore          9
                        }
                    }
                    afterwsc = ComputeWSC();
    //  425  930:aload_0         
    //  426  931:aload_0         
    //  427  932:invokevirtual   #138 <Method rm.rolemining.lattice.ReducedLattices$WSC ComputeWSC()>
    //  428  935:putfield        #252 <Field rm.rolemining.lattice.ReducedLattices$WSC afterwsc>
                    if((1.0D - a) * (double)afterwsc.wsc < (double)beforewsc.wsc && HaveDone == 1)
    //* 429  938:dconst_1        
    //* 430  939:aload_0         
    //* 431  940:getfield        #254 <Field double a>
    //* 432  943:dsub            
    //* 433  944:aload_0         
    //* 434  945:getfield        #252 <Field rm.rolemining.lattice.ReducedLattices$WSC afterwsc>
    //* 435  948:getfield        #259 <Field int rm.rolemining.lattice.ReducedLattices$WSC.wsc>
    //* 436  951:i2d             
    //* 437  952:dmul            
    //* 438  953:aload_0         
    //* 439  954:getfield        #140 <Field rm.rolemining.lattice.ReducedLattices$WSC beforewsc>
    //* 440  957:getfield        #259 <Field int rm.rolemining.lattice.ReducedLattices$WSC.wsc>
    //* 441  960:i2d             
    //* 442  961:dcmpg           
    //* 443  962:ifge            989
    //* 444  965:iload           9
    //* 445  967:iconst_1        
    //* 446  968:icmpne          989
                    {
                        beforewsc = afterwsc;
    //  447  971:aload_0         
    //  448  972:aload_0         
    //  449  973:getfield        #252 <Field rm.rolemining.lattice.ReducedLattices$WSC afterwsc>
    //  450  976:putfield        #140 <Field rm.rolemining.lattice.ReducedLattices$WSC beforewsc>
                        CopyState();
    //  451  979:aload_0         
    //  452  980:invokespecial   #143 <Method void CopyState()>
                        done++;
    //  453  983:iinc            7  1
                    } else
    //* 454  986:goto            993
                    {
                        ReturnsState();
    //  455  989:aload_0         
    //  456  990:invokespecial   #262 <Method void ReturnsState()>
                    }
                }
            }

    //  457  993:iinc            10  1
    //  458  996:iload           10
    //  459  998:aload           8
    //  460 1000:invokevirtual   #243 <Method int ArrayList.size()>
    //  461 1003:icmplt          291
        }
    //  462 1006:iload           7
    //  463 1008:ifgt            282
        minwsc = beforewsc;
    //  464 1011:aload_0         
    //  465 1012:aload_0         
    //  466 1013:getfield        #140 <Field rm.rolemining.lattice.ReducedLattices$WSC beforewsc>
    //  467 1016:putfield        #264 <Field rm.rolemining.lattice.ReducedLattices$WSC minwsc>
        log.append("\n--------------------------------------------------------\n");
    //  468 1019:aload_0         
    //  469 1020:getfield        #55  <Field StringBuffer log>
    //  470 1023:ldc2            #266 <String "\n--------------------------------------------------------\n">
    //  471 1026:invokevirtual   #149 <Method StringBuffer StringBuffer.append(String)>
    //  472 1029:pop             
        for(int i = 0; i < nnodes; i++)
    //* 473 1030:iconst_0        
    //* 474 1031:istore          10
    //* 475 1033:goto            1086
            if(!nodesflags[i])
    //* 476 1036:aload_0         
    //* 477 1037:getfield        #134 <Field boolean[] nodesflags>
    //* 478 1040:iload           10
    //* 479 1042:baload          
    //* 480 1043:ifne            1083
            {
                log.append((new StringBuilder(String.valueOf(i))).append("  :\n").toString());
    //  481 1046:aload_0         
    //  482 1047:getfield        #55  <Field StringBuffer log>
    //  483 1050:new             #166 <Class StringBuilder>
    //  484 1053:dup             
    //  485 1054:iload           10
    //  486 1056:invokestatic    #170 <Method String String.valueOf(int)>
    //  487 1059:invokespecial   #173 <Method void StringBuilder(String)>
    //  488 1062:ldc1            #175 <String "  :\n">
    //  489 1064:invokevirtual   #178 <Method StringBuilder StringBuilder.append(String)>
    //  490 1067:invokevirtual   #182 <Method String StringBuilder.toString()>
    //  491 1070:invokevirtual   #149 <Method StringBuffer StringBuffer.append(String)>
    //  492 1073:pop             
                PrintNode(Integer.valueOf(i));
    //  493 1074:aload_0         
    //  494 1075:iload           10
    //  495 1077:invokestatic    #185 <Method Integer Integer.valueOf(int)>
    //  496 1080:invokevirtual   #189 <Method void PrintNode(Integer)>
            }

    //  497 1083:iinc            10  1
    //  498 1086:iload           10
    //  499 1088:aload_0         
    //  500 1089:getfield        #269 <Field int nnodes>
    //  501 1092:icmplt          1036
        log.append("\n--------------------------------------------------------\n");
    //  502 1095:aload_0         
    //  503 1096:getfield        #55  <Field StringBuffer log>
    //  504 1099:ldc2            #266 <String "\n--------------------------------------------------------\n">
    //  505 1102:invokevirtual   #149 <Method StringBuffer StringBuffer.append(String)>
    //  506 1105:pop             
        log.append((new StringBuilder("The Number of edges is : ")).append(nedges).append("\n").toString());
    //  507 1106:aload_0         
    //  508 1107:getfield        #55  <Field StringBuffer log>
    //  509 1110:new             #166 <Class StringBuilder>
    //  510 1113:dup             
    //  511 1114:ldc2            #271 <String "The Number of edges is : ">
    //  512 1117:invokespecial   #173 <Method void StringBuilder(String)>
    //  513 1120:aload_0         
    //  514 1121:getfield        #274 <Field int nedges>
    //  515 1124:invokevirtual   #277 <Method StringBuilder StringBuilder.append(int)>
    //  516 1127:ldc2            #279 <String "\n">
    //  517 1130:invokevirtual   #178 <Method StringBuilder StringBuilder.append(String)>
    //  518 1133:invokevirtual   #182 <Method String StringBuilder.toString()>
    //  519 1136:invokevirtual   #149 <Method StringBuffer StringBuffer.append(String)>
    //  520 1139:pop             
        for(int i = 0; i < nedges; i++)
    //* 521 1140:iconst_0        
    //* 522 1141:istore          10
    //* 523 1143:goto            1166
        {
            PrintEdge(i);
    //  524 1146:aload_0         
    //  525 1147:iload           10
    //  526 1149:invokevirtual   #283 <Method void PrintEdge(int)>
            log.append("\n");
    //  527 1152:aload_0         
    //  528 1153:getfield        #55  <Field StringBuffer log>
    //  529 1156:ldc2            #279 <String "\n">
    //  530 1159:invokevirtual   #149 <Method StringBuffer StringBuffer.append(String)>
    //  531 1162:pop             
        }

    //  532 1163:iinc            10  1
    //  533 1166:iload           10
    //  534 1168:aload_0         
    //  535 1169:getfield        #274 <Field int nedges>
    //  536 1172:icmplt          1146
        log.append("\n--------------------------------------------------------\n");
    //  537 1175:aload_0         
    //  538 1176:getfield        #55  <Field StringBuffer log>
    //  539 1179:ldc2            #266 <String "\n--------------------------------------------------------\n">
    //  540 1182:invokevirtual   #149 <Method StringBuffer StringBuffer.append(String)>
    //  541 1185:pop             
        log.append((new StringBuilder("minwsc: ")).append(minwsc.R).append(", ").append(minwsc.UA).append(", ").append(minwsc.PA).append(", ").append(minwsc.RH).append(", ").append(minwsc.wsc).append("\n").toString());
    //  542 1186:aload_0         
    //  543 1187:getfield        #55  <Field StringBuffer log>
    //  544 1190:new             #166 <Class StringBuilder>
    //  545 1193:dup             
    //  546 1194:ldc2            #285 <String "minwsc: ">
    //  547 1197:invokespecial   #173 <Method void StringBuilder(String)>
    //  548 1200:aload_0         
    //  549 1201:getfield        #264 <Field rm.rolemining.lattice.ReducedLattices$WSC minwsc>
    //  550 1204:getfield        #288 <Field int rm.rolemining.lattice.ReducedLattices$WSC.R>
    //  551 1207:invokevirtual   #277 <Method StringBuilder StringBuilder.append(int)>
    //  552 1210:ldc2            #290 <String ", ">
    //  553 1213:invokevirtual   #178 <Method StringBuilder StringBuilder.append(String)>
    //  554 1216:aload_0         
    //  555 1217:getfield        #264 <Field rm.rolemining.lattice.ReducedLattices$WSC minwsc>
    //  556 1220:getfield        #293 <Field int rm.rolemining.lattice.ReducedLattices$WSC.UA>
    //  557 1223:invokevirtual   #277 <Method StringBuilder StringBuilder.append(int)>
    //  558 1226:ldc2            #290 <String ", ">
    //  559 1229:invokevirtual   #178 <Method StringBuilder StringBuilder.append(String)>
    //  560 1232:aload_0         
    //  561 1233:getfield        #264 <Field rm.rolemining.lattice.ReducedLattices$WSC minwsc>
    //  562 1236:getfield        #296 <Field int rm.rolemining.lattice.ReducedLattices$WSC.PA>
    //  563 1239:invokevirtual   #277 <Method StringBuilder StringBuilder.append(int)>
    //  564 1242:ldc2            #290 <String ", ">
    //  565 1245:invokevirtual   #178 <Method StringBuilder StringBuilder.append(String)>
    //  566 1248:aload_0         
    //  567 1249:getfield        #264 <Field rm.rolemining.lattice.ReducedLattices$WSC minwsc>
    //  568 1252:getfield        #299 <Field int rm.rolemining.lattice.ReducedLattices$WSC.RH>
    //  569 1255:invokevirtual   #277 <Method StringBuilder StringBuilder.append(int)>
    //  570 1258:ldc2            #290 <String ", ">
    //  571 1261:invokevirtual   #178 <Method StringBuilder StringBuilder.append(String)>
    //  572 1264:aload_0         
    //  573 1265:getfield        #264 <Field rm.rolemining.lattice.ReducedLattices$WSC minwsc>
    //  574 1268:getfield        #259 <Field int rm.rolemining.lattice.ReducedLattices$WSC.wsc>
    //  575 1271:invokevirtual   #277 <Method StringBuilder StringBuilder.append(int)>
    //  576 1274:ldc2            #279 <String "\n">
    //  577 1277:invokevirtual   #178 <Method StringBuilder StringBuilder.append(String)>
    //  578 1280:invokevirtual   #182 <Method String StringBuilder.toString()>
    //  579 1283:invokevirtual   #149 <Method StringBuffer StringBuffer.append(String)>
    //  580 1286:pop             
        CopyState();
    //  581 1287:aload_0         
    //  582 1288:invokespecial   #143 <Method void CopyState()>
        nodes.removeAllElements();
    //  583 1291:aload_0         
    //  584 1292:getfield        #127 <Field Vector nodes>
    //  585 1295:invokevirtual   #302 <Method void Vector.removeAllElements()>
        for(int i = 0; i < Copynodes.size(); i++)
    //* 586 1298:iconst_0        
    //* 587 1299:istore          10
    //* 588 1301:goto            1457
            if(!nodesflags[i])
    //* 589 1304:aload_0         
    //* 590 1305:getfield        #134 <Field boolean[] nodesflags>
    //* 591 1308:iload           10
    //* 592 1310:baload          
    //* 593 1311:ifne            1454
            {
                nodes.add((Concept)Copynodes.get(i));
    //  594 1314:aload_0         
    //  595 1315:getfield        #127 <Field Vector nodes>
    //  596 1318:aload_0         
    //  597 1319:getfield        #48  <Field Vector Copynodes>
    //  598 1322:iload           10
    //  599 1324:invokevirtual   #200 <Method Object Vector.get(int)>
    //  600 1327:checkcast       #202 <Class Concept>
    //  601 1330:invokevirtual   #306 <Method boolean Vector.add(Object)>
    //  602 1333:pop             
                for(int k = 0; k < nedges; k++)
    //* 603 1334:iconst_0        
    //* 604 1335:istore          11
    //* 605 1337:goto            1445
                {
                    if(((rm.rolemining.lattice.ReducedLattices.LatticeEdge)edges.get(k)).from == i)
    //* 606 1340:aload_0         
    //* 607 1341:getfield        #309 <Field Vector edges>
    //* 608 1344:iload           11
    //* 609 1346:invokevirtual   #200 <Method Object Vector.get(int)>
    //* 610 1349:checkcast       #311 <Class rm.rolemining.lattice.ReducedLattices$LatticeEdge>
    //* 611 1352:getfield        #314 <Field int rm.rolemining.lattice.ReducedLattices$LatticeEdge.from>
    //* 612 1355:iload           10
    //* 613 1357:icmpne          1391
                        ((rm.rolemining.lattice.ReducedLattices.LatticeEdge)edges.get(k)).from = nodes.indexOf(Copynodes.get(i));
    //  614 1360:aload_0         
    //  615 1361:getfield        #309 <Field Vector edges>
    //  616 1364:iload           11
    //  617 1366:invokevirtual   #200 <Method Object Vector.get(int)>
    //  618 1369:checkcast       #311 <Class rm.rolemining.lattice.ReducedLattices$LatticeEdge>
    //  619 1372:aload_0         
    //  620 1373:getfield        #127 <Field Vector nodes>
    //  621 1376:aload_0         
    //  622 1377:getfield        #48  <Field Vector Copynodes>
    //  623 1380:iload           10
    //  624 1382:invokevirtual   #200 <Method Object Vector.get(int)>
    //  625 1385:invokevirtual   #318 <Method int Vector.indexOf(Object)>
    //  626 1388:putfield        #314 <Field int rm.rolemining.lattice.ReducedLattices$LatticeEdge.from>
                    if(((rm.rolemining.lattice.ReducedLattices.LatticeEdge)edges.get(k)).to == i)
    //* 627 1391:aload_0         
    //* 628 1392:getfield        #309 <Field Vector edges>
    //* 629 1395:iload           11
    //* 630 1397:invokevirtual   #200 <Method Object Vector.get(int)>
    //* 631 1400:checkcast       #311 <Class rm.rolemining.lattice.ReducedLattices$LatticeEdge>
    //* 632 1403:getfield        #321 <Field int rm.rolemining.lattice.ReducedLattices$LatticeEdge.to>
    //* 633 1406:iload           10
    //* 634 1408:icmpne          1442
                        ((rm.rolemining.lattice.ReducedLattices.LatticeEdge)edges.get(k)).to = nodes.indexOf(Copynodes.get(i));
    //  635 1411:aload_0         
    //  636 1412:getfield        #309 <Field Vector edges>
    //  637 1415:iload           11
    //  638 1417:invokevirtual   #200 <Method Object Vector.get(int)>
    //  639 1420:checkcast       #311 <Class rm.rolemining.lattice.ReducedLattices$LatticeEdge>
    //  640 1423:aload_0         
    //  641 1424:getfield        #127 <Field Vector nodes>
    //  642 1427:aload_0         
    //  643 1428:getfield        #48  <Field Vector Copynodes>
    //  644 1431:iload           10
    //  645 1433:invokevirtual   #200 <Method Object Vector.get(int)>
    //  646 1436:invokevirtual   #318 <Method int Vector.indexOf(Object)>
    //  647 1439:putfield        #321 <Field int rm.rolemining.lattice.ReducedLattices$LatticeEdge.to>
                }

    //  648 1442:iinc            11  1
    //  649 1445:iload           11
    //  650 1447:aload_0         
    //  651 1448:getfield        #274 <Field int nedges>
    //  652 1451:icmplt          1340
            }

    //  653 1454:iinc            10  1
    //  654 1457:iload           10
    //  655 1459:aload_0         
    //  656 1460:getfield        #48  <Field Vector Copynodes>
    //  657 1463:invokevirtual   #130 <Method int Vector.size()>
    //  658 1466:icmplt          1304
    //  659 1469:return          
    }

    String ExceptCurrJun(ArrayList Jun, int j)
    {
        String rjun_j = "";
    //    0    0:ldc2            #352 <String "">
    //    1    3:astore_3        
        Concept node = ((Concept)nodes.get(((Integer)Jun.get(0)).intValue())).Copy();
    //    2    4:aload_0         
    //    3    5:getfield        #127 <Field Vector nodes>
    //    4    8:aload_1         
    //    5    9:iconst_0        
    //    6   10:invokevirtual   #159 <Method Object ArrayList.get(int)>
    //    7   13:checkcast       #161 <Class Integer>
    //    8   16:invokevirtual   #164 <Method int Integer.intValue()>
    //    9   19:invokevirtual   #200 <Method Object Vector.get(int)>
    //   10   22:checkcast       #202 <Class Concept>
    //   11   25:invokevirtual   #356 <Method Concept Concept.Copy()>
    //   12   28:astore          4
        for(int i = 1; i < Jun.size(); i++)
    //*  13   30:iconst_1        
    //*  14   31:istore          5
    //*  15   33:goto            77
            node.allAttributes = ((Concept)nodes.get(((Integer)Jun.get(i)).intValue())).allAttributes.getUnion(node.allAttributes);
    //   16   36:aload           4
    //   17   38:aload_0         
    //   18   39:getfield        #127 <Field Vector nodes>
    //   19   42:aload_1         
    //   20   43:iload           5
    //   21   45:invokevirtual   #159 <Method Object ArrayList.get(int)>
    //   22   48:checkcast       #161 <Class Integer>
    //   23   51:invokevirtual   #164 <Method int Integer.intValue()>
    //   24   54:invokevirtual   #200 <Method Object Vector.get(int)>
    //   25   57:checkcast       #202 <Class Concept>
    //   26   60:getfield        #220 <Field IntegerSet Concept.allAttributes>
    //   27   63:aload           4
    //   28   65:getfield        #220 <Field IntegerSet Concept.allAttributes>
    //   29   68:invokevirtual   #242 <Method IntegerSet IntegerSet.getUnion(IntegerSet)>
    //   30   71:putfield        #220 <Field IntegerSet Concept.allAttributes>

    //   31   74:iinc            5  1
    //   32   77:iload           5
    //   33   79:aload_1         
    //   34   80:invokevirtual   #243 <Method int ArrayList.size()>
    //   35   83:icmplt          36
        node.allAttributes = node.allAttributes.getDifference(((Concept)nodes.get(((Integer)Jun.get(j)).intValue())).allAttributes);
    //   36   86:aload           4
    //   37   88:aload           4
    //   38   90:getfield        #220 <Field IntegerSet Concept.allAttributes>
    //   39   93:aload_0         
    //   40   94:getfield        #127 <Field Vector nodes>
    //   41   97:aload_1         
    //   42   98:iload_2         
    //   43   99:invokevirtual   #159 <Method Object ArrayList.get(int)>
    //   44  102:checkcast       #161 <Class Integer>
    //   45  105:invokevirtual   #164 <Method int Integer.intValue()>
    //   46  108:invokevirtual   #200 <Method Object Vector.get(int)>
    //   47  111:checkcast       #202 <Class Concept>
    //   48  114:getfield        #220 <Field IntegerSet Concept.allAttributes>
    //   49  117:invokevirtual   #359 <Method IntegerSet IntegerSet.getDifference(IntegerSet)>
    //   50  120:putfield        #220 <Field IntegerSet Concept.allAttributes>
        rjun_j = TranslateAttributelist(node.allAttributes);
    //   51  123:aload_0         
    //   52  124:aload           4
    //   53  126:getfield        #220 <Field IntegerSet Concept.allAttributes>
    //   54  129:invokevirtual   #224 <Method String TranslateAttributelist(IntegerSet)>
    //   55  132:astore_3        
        return rjun_j;
    //   56  133:aload_3         
    //   57  134:areturn         
    }

    void PrintCopyNode(Integer node)
    {
        int k = ((Concept)Copynodes.get(node.intValue())).allObjects.getSize();
    //    0    0:aload_0         
    //    1    1:getfield        #48  <Field Vector Copynodes>
    //    2    4:aload_1         
    //    3    5:invokevirtual   #164 <Method int Integer.intValue()>
    //    4    8:invokevirtual   #200 <Method Object Vector.get(int)>
    //    5   11:checkcast       #202 <Class Concept>
    //    6   14:getfield        #250 <Field IntegerSet Concept.allObjects>
    //    7   17:invokevirtual   #365 <Method int IntegerSet.getSize()>
    //    8   20:istore_2        
        log.append((new StringBuilder("{{")).append(k).append("};{").append(TranslateAttributelist(((Concept)Copynodes.get(node.intValue())).allAttributes)).append("}}\n").toString());
    //    9   21:aload_0         
    //   10   22:getfield        #55  <Field StringBuffer log>
    //   11   25:new             #166 <Class StringBuilder>
    //   12   28:dup             
    //   13   29:ldc2            #367 <String "{{">
    //   14   32:invokespecial   #173 <Method void StringBuilder(String)>
    //   15   35:iload_2         
    //   16   36:invokevirtual   #277 <Method StringBuilder StringBuilder.append(int)>
    //   17   39:ldc2            #369 <String "};{">
    //   18   42:invokevirtual   #178 <Method StringBuilder StringBuilder.append(String)>
    //   19   45:aload_0         
    //   20   46:aload_0         
    //   21   47:getfield        #48  <Field Vector Copynodes>
    //   22   50:aload_1         
    //   23   51:invokevirtual   #164 <Method int Integer.intValue()>
    //   24   54:invokevirtual   #200 <Method Object Vector.get(int)>
    //   25   57:checkcast       #202 <Class Concept>
    //   26   60:getfield        #220 <Field IntegerSet Concept.allAttributes>
    //   27   63:invokevirtual   #224 <Method String TranslateAttributelist(IntegerSet)>
    //   28   66:invokevirtual   #178 <Method StringBuilder StringBuilder.append(String)>
    //   29   69:ldc2            #371 <String "}}\n">
    //   30   72:invokevirtual   #178 <Method StringBuilder StringBuilder.append(String)>
    //   31   75:invokevirtual   #182 <Method String StringBuilder.toString()>
    //   32   78:invokevirtual   #149 <Method StringBuffer StringBuffer.append(String)>
    //   33   81:pop             
    //   34   82:return          
    }

    protected rm.rolemining.lattice.ReducedLattices.WSC ComputeWSC()
    {
        rm.rolemining.lattice.ReducedLattices.WSC wsc = new rm.rolemining.lattice.ReducedLattices.WSC(this);
    //    0    0:new             #256 <Class rm.rolemining.lattice.ReducedLattices$WSC>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:invokespecial   #375 <Method void rm.rolemining.lattice.ReducedLattices$WSC(ReducedLattices)>
    //    4    8:astore_1        
        int R = 0;
    //    5    9:iconst_0        
    //    6   10:istore_2        
        int UA = 0;
    //    7   11:iconst_0        
    //    8   12:istore_3        
        int PA = 0;
    //    9   13:iconst_0        
    //   10   14:istore          4
        int RH = 0;
    //   11   16:iconst_0        
    //   12   17:istore          5
        for(int i = 0; i < nodes.size(); i++)
    //*  13   19:iconst_0        
    //*  14   20:istore          6
    //*  15   22:goto            79
            if(!nodesflags[i])
    //*  16   25:aload_0         
    //*  17   26:getfield        #134 <Field boolean[] nodesflags>
    //*  18   29:iload           6
    //*  19   31:baload          
    //*  20   32:ifne            76
            {
                UA += ((Concept)nodes.get(i)).getNumberOfObjects();
    //   21   35:iload_3         
    //   22   36:aload_0         
    //   23   37:getfield        #127 <Field Vector nodes>
    //   24   40:iload           6
    //   25   42:invokevirtual   #200 <Method Object Vector.get(int)>
    //   26   45:checkcast       #202 <Class Concept>
    //   27   48:invokevirtual   #205 <Method int Concept.getNumberOfObjects()>
    //   28   51:iadd            
    //   29   52:istore_3        
                PA += ((Concept)nodes.get(i)).getNumberOfAttributes();
    //   30   53:iload           4
    //   31   55:aload_0         
    //   32   56:getfield        #127 <Field Vector nodes>
    //   33   59:iload           6
    //   34   61:invokevirtual   #200 <Method Object Vector.get(int)>
    //   35   64:checkcast       #202 <Class Concept>
    //   36   67:invokevirtual   #208 <Method int Concept.getNumberOfAttributes()>
    //   37   70:iadd            
    //   38   71:istore          4
                R++;
    //   39   73:iinc            2  1
            }

    //   40   76:iinc            6  1
    //   41   79:iload           6
    //   42   81:aload_0         
    //   43   82:getfield        #127 <Field Vector nodes>
    //   44   85:invokevirtual   #130 <Method int Vector.size()>
    //   45   88:icmplt          25
        RH += edges.size();
    //   46   91:iload           5
    //   47   93:aload_0         
    //   48   94:getfield        #309 <Field Vector edges>
    //   49   97:invokevirtual   #130 <Method int Vector.size()>
    //   50  100:iadd            
    //   51  101:istore          5
        wsc.wsc = wr * R + wu * UA + wp * PA + wh * RH;
    //   52  103:aload_1         
    //   53  104:aload_0         
    //   54  105:getfield        #110 <Field int wr>
    //   55  108:iload_2         
    //   56  109:imul            
    //   57  110:aload_0         
    //   58  111:getfield        #112 <Field int wu>
    //   59  114:iload_3         
    //   60  115:imul            
    //   61  116:iadd            
    //   62  117:aload_0         
    //   63  118:getfield        #114 <Field int wp>
    //   64  121:iload           4
    //   65  123:imul            
    //   66  124:iadd            
    //   67  125:aload_0         
    //   68  126:getfield        #116 <Field int wh>
    //   69  129:iload           5
    //   70  131:imul            
    //   71  132:iadd            
    //   72  133:putfield        #259 <Field int rm.rolemining.lattice.ReducedLattices$WSC.wsc>
        wsc.R = R;
    //   73  136:aload_1         
    //   74  137:iload_2         
    //   75  138:putfield        #288 <Field int rm.rolemining.lattice.ReducedLattices$WSC.R>
        wsc.UA = UA;
    //   76  141:aload_1         
    //   77  142:iload_3         
    //   78  143:putfield        #293 <Field int rm.rolemining.lattice.ReducedLattices$WSC.UA>
        wsc.PA = PA;
    //   79  146:aload_1         
    //   80  147:iload           4
    //   81  149:putfield        #296 <Field int rm.rolemining.lattice.ReducedLattices$WSC.PA>
        wsc.RH = RH;
    //   82  152:aload_1         
    //   83  153:iload           5
    //   84  155:putfield        #299 <Field int rm.rolemining.lattice.ReducedLattices$WSC.RH>
        return wsc;
    //   85  158:aload_1         
    //   86  159:areturn         
    }

    boolean isMatched(Concept rs1[], int nrs1, Concept curnode)
    {
        for(int i = 0; i < nrs1; i++)
    //*   0    0:iconst_0        
    //*   1    1:istore          4
    //*   2    3:goto            22
            if(rs1[i].equals(curnode))
    //*   3    6:aload_1         
    //*   4    7:iload           4
    //*   5    9:aaload          
    //*   6   10:aload_3         
    //*   7   11:invokevirtual   #381 <Method boolean Concept.equals(Concept)>
    //*   8   14:ifeq            19
                return true;
    //    9   17:iconst_1        
    //   10   18:ireturn         

    //   11   19:iinc            4  1
    //   12   22:iload           4
    //   13   24:iload_2         
    //   14   25:icmplt          6
        return false;
    //   15   28:iconst_0        
    //   16   29:ireturn         
    }

    protected int DeleteNode(int node)
    {
        nodesflags[node] = true;
    //    0    0:aload_0         
    //    1    1:getfield        #134 <Field boolean[] nodesflags>
    //    2    4:iload_1         
    //    3    5:iconst_1        
    //    4    6:bastore         
        return node;
    //    5    7:iload_1         
    //    6    8:ireturn         
    }

    protected void Update(int node, ArrayList Thr)
    {
        for(int i = 0; i < nedges;)
    //*   0    0:iconst_0        
    //*   1    1:istore_3        
    //*   2    2:goto            69
            if(((rm.rolemining.lattice.ReducedLattices.LatticeEdge)edges.get(i)).from == node || ((rm.rolemining.lattice.ReducedLattices.LatticeEdge)edges.get(i)).to == node)
    //*   3    5:aload_0         
    //*   4    6:getfield        #309 <Field Vector edges>
    //*   5    9:iload_3         
    //*   6   10:invokevirtual   #200 <Method Object Vector.get(int)>
    //*   7   13:checkcast       #311 <Class rm.rolemining.lattice.ReducedLattices$LatticeEdge>
    //*   8   16:getfield        #314 <Field int rm.rolemining.lattice.ReducedLattices$LatticeEdge.from>
    //*   9   19:iload_1         
    //*  10   20:icmpeq          41
    //*  11   23:aload_0         
    //*  12   24:getfield        #309 <Field Vector edges>
    //*  13   27:iload_3         
    //*  14   28:invokevirtual   #200 <Method Object Vector.get(int)>
    //*  15   31:checkcast       #311 <Class rm.rolemining.lattice.ReducedLattices$LatticeEdge>
    //*  16   34:getfield        #321 <Field int rm.rolemining.lattice.ReducedLattices$LatticeEdge.to>
    //*  17   37:iload_1         
    //*  18   38:icmpne          66
            {
                log.append("Delete edge :\n");
    //   19   41:aload_0         
    //   20   42:getfield        #55  <Field StringBuffer log>
    //   21   45:ldc2            #387 <String "Delete edge :\n">
    //   22   48:invokevirtual   #149 <Method StringBuffer StringBuffer.append(String)>
    //   23   51:pop             
                PrintEdge(i);
    //   24   52:aload_0         
    //   25   53:iload_3         
    //   26   54:invokevirtual   #283 <Method void PrintEdge(int)>
                DeleteEdge(i);
    //   27   57:aload_0         
    //   28   58:iload_3         
    //   29   59:invokevirtual   #389 <Method int DeleteEdge(int)>
    //   30   62:pop             
            } else
    //*  31   63:goto            69
            {
                i++;
    //   32   66:iinc            3  1
            }

    //   33   69:iload_3         
    //   34   70:aload_0         
    //   35   71:getfield        #274 <Field int nedges>
    //   36   74:icmplt          5
        int noedge = 0;
    //   37   77:iconst_0        
    //   38   78:istore_3        
        if(Thr.size() > 0)
    //*  39   79:aload_2         
    //*  40   80:invokevirtual   #243 <Method int ArrayList.size()>
    //*  41   83:ifle            149
        {
            for(int i = 0; i < Thr.size(); i++)
    //*  42   86:iconst_0        
    //*  43   87:istore          4
    //*  44   89:goto            140
            {
                noedge = addEdge(((rm.rolemining.lattice.ReducedLattices.ThrEdge)Thr.get(i)).r_low, ((rm.rolemining.lattice.ReducedLattices.ThrEdge)Thr.get(i)).r_super);
    //   45   92:aload_0         
    //   46   93:aload_2         
    //   47   94:iload           4
    //   48   96:invokevirtual   #159 <Method Object ArrayList.get(int)>
    //   49   99:checkcast       #391 <Class rm.rolemining.lattice.ReducedLattices$ThrEdge>
    //   50  102:getfield        #394 <Field int rm.rolemining.lattice.ReducedLattices$ThrEdge.r_low>
    //   51  105:aload_2         
    //   52  106:iload           4
    //   53  108:invokevirtual   #159 <Method Object ArrayList.get(int)>
    //   54  111:checkcast       #391 <Class rm.rolemining.lattice.ReducedLattices$ThrEdge>
    //   55  114:getfield        #397 <Field int rm.rolemining.lattice.ReducedLattices$ThrEdge.r_super>
    //   56  117:invokevirtual   #400 <Method int addEdge(int, int)>
    //   57  120:istore_3        
                log.append("Add edge :");
    //   58  121:aload_0         
    //   59  122:getfield        #55  <Field StringBuffer log>
    //   60  125:ldc2            #402 <String "Add edge :">
    //   61  128:invokevirtual   #149 <Method StringBuffer StringBuffer.append(String)>
    //   62  131:pop             
                PrintEdge(noedge);
    //   63  132:aload_0         
    //   64  133:iload_3         
    //   65  134:invokevirtual   #283 <Method void PrintEdge(int)>
            }

    //   66  137:iinc            4  1
    //   67  140:iload           4
    //   68  142:aload_2         
    //   69  143:invokevirtual   #243 <Method int ArrayList.size()>
    //   70  146:icmplt          92
        }
    //   71  149:return          
    }

    private void CopyState()
    {
        Copynodes.removeAllElements();
    //    0    0:aload_0         
    //    1    1:getfield        #48  <Field Vector Copynodes>
    //    2    4:invokevirtual   #302 <Method void Vector.removeAllElements()>
        for(int i = 0; i < nodes.size(); i++)
    //*   3    7:iconst_0        
    //*   4    8:istore_1        
    //*   5    9:goto            51
        {
            Concept node = ((Concept)nodes.get(i)).Copy();
    //    6   12:aload_0         
    //    7   13:getfield        #127 <Field Vector nodes>
    //    8   16:iload_1         
    //    9   17:invokevirtual   #200 <Method Object Vector.get(int)>
    //   10   20:checkcast       #202 <Class Concept>
    //   11   23:invokevirtual   #356 <Method Concept Concept.Copy()>
    //   12   26:astore_2        
            Copynodes.add(node);
    //   13   27:aload_0         
    //   14   28:getfield        #48  <Field Vector Copynodes>
    //   15   31:aload_2         
    //   16   32:invokevirtual   #306 <Method boolean Vector.add(Object)>
    //   17   35:pop             
            Copynodesflags[i] = nodesflags[i];
    //   18   36:aload_0         
    //   19   37:getfield        #132 <Field boolean[] Copynodesflags>
    //   20   40:iload_1         
    //   21   41:aload_0         
    //   22   42:getfield        #134 <Field boolean[] nodesflags>
    //   23   45:iload_1         
    //   24   46:baload          
    //   25   47:bastore         
        }

    //   26   48:iinc            1  1
    //   27   51:iload_1         
    //   28   52:aload_0         
    //   29   53:getfield        #127 <Field Vector nodes>
    //   30   56:invokevirtual   #130 <Method int Vector.size()>
    //   31   59:icmplt          12
        Copyedges.removeAllElements();
    //   32   62:aload_0         
    //   33   63:getfield        #50  <Field Vector Copyedges>
    //   34   66:invokevirtual   #302 <Method void Vector.removeAllElements()>
        for(int j = 0; j < edges.size(); j++)
    //*  35   69:iconst_0        
    //*  36   70:istore_1        
    //*  37   71:goto            131
        {
            rm.rolemining.lattice.ReducedLattices.LatticeEdge edge = new rm.rolemining.lattice.ReducedLattices.LatticeEdge(this);
    //   38   74:new             #311 <Class rm.rolemining.lattice.ReducedLattices$LatticeEdge>
    //   39   77:dup             
    //   40   78:aload_0         
    //   41   79:invokespecial   #404 <Method void rm.rolemining.lattice.ReducedLattices$LatticeEdge(ReducedLattices)>
    //   42   82:astore_2        
            edge.from = ((rm.rolemining.lattice.ReducedLattices.LatticeEdge)edges.get(j)).from;
    //   43   83:aload_2         
    //   44   84:aload_0         
    //   45   85:getfield        #309 <Field Vector edges>
    //   46   88:iload_1         
    //   47   89:invokevirtual   #200 <Method Object Vector.get(int)>
    //   48   92:checkcast       #311 <Class rm.rolemining.lattice.ReducedLattices$LatticeEdge>
    //   49   95:getfield        #314 <Field int rm.rolemining.lattice.ReducedLattices$LatticeEdge.from>
    //   50   98:putfield        #314 <Field int rm.rolemining.lattice.ReducedLattices$LatticeEdge.from>
            edge.to = ((rm.rolemining.lattice.ReducedLattices.LatticeEdge)edges.get(j)).to;
    //   51  101:aload_2         
    //   52  102:aload_0         
    //   53  103:getfield        #309 <Field Vector edges>
    //   54  106:iload_1         
    //   55  107:invokevirtual   #200 <Method Object Vector.get(int)>
    //   56  110:checkcast       #311 <Class rm.rolemining.lattice.ReducedLattices$LatticeEdge>
    //   57  113:getfield        #321 <Field int rm.rolemining.lattice.ReducedLattices$LatticeEdge.to>
    //   58  116:putfield        #321 <Field int rm.rolemining.lattice.ReducedLattices$LatticeEdge.to>
            Copyedges.add(edge);
    //   59  119:aload_0         
    //   60  120:getfield        #50  <Field Vector Copyedges>
    //   61  123:aload_2         
    //   62  124:invokevirtual   #306 <Method boolean Vector.add(Object)>
    //   63  127:pop             
        }

    //   64  128:iinc            1  1
    //   65  131:iload_1         
    //   66  132:aload_0         
    //   67  133:getfield        #309 <Field Vector edges>
    //   68  136:invokevirtual   #130 <Method int Vector.size()>
    //   69  139:icmplt          74
    //   70  142:return          
    }

    private void ReturnsState()
    {
        nodes.removeAllElements();
    //    0    0:aload_0         
    //    1    1:getfield        #127 <Field Vector nodes>
    //    2    4:invokevirtual   #302 <Method void Vector.removeAllElements()>
        for(int i = 0; i < Copynodes.size(); i++)
    //*   3    7:iconst_0        
    //*   4    8:istore_1        
    //*   5    9:goto            51
        {
            Concept node = ((Concept)Copynodes.get(i)).Copy();
    //    6   12:aload_0         
    //    7   13:getfield        #48  <Field Vector Copynodes>
    //    8   16:iload_1         
    //    9   17:invokevirtual   #200 <Method Object Vector.get(int)>
    //   10   20:checkcast       #202 <Class Concept>
    //   11   23:invokevirtual   #356 <Method Concept Concept.Copy()>
    //   12   26:astore_2        
            nodes.add(node);
    //   13   27:aload_0         
    //   14   28:getfield        #127 <Field Vector nodes>
    //   15   31:aload_2         
    //   16   32:invokevirtual   #306 <Method boolean Vector.add(Object)>
    //   17   35:pop             
            nodesflags[i] = Copynodesflags[i];
    //   18   36:aload_0         
    //   19   37:getfield        #134 <Field boolean[] nodesflags>
    //   20   40:iload_1         
    //   21   41:aload_0         
    //   22   42:getfield        #132 <Field boolean[] Copynodesflags>
    //   23   45:iload_1         
    //   24   46:baload          
    //   25   47:bastore         
        }

    //   26   48:iinc            1  1
    //   27   51:iload_1         
    //   28   52:aload_0         
    //   29   53:getfield        #48  <Field Vector Copynodes>
    //   30   56:invokevirtual   #130 <Method int Vector.size()>
    //   31   59:icmplt          12
        nnodes = nodes.size();
    //   32   62:aload_0         
    //   33   63:aload_0         
    //   34   64:getfield        #127 <Field Vector nodes>
    //   35   67:invokevirtual   #130 <Method int Vector.size()>
    //   36   70:putfield        #269 <Field int nnodes>
        edges.removeAllElements();
    //   37   73:aload_0         
    //   38   74:getfield        #309 <Field Vector edges>
    //   39   77:invokevirtual   #302 <Method void Vector.removeAllElements()>
        for(int j = 0; j < Copyedges.size(); j++)
    //*  40   80:iconst_0        
    //*  41   81:istore_1        
    //*  42   82:goto            107
            edges.add((rm.rolemining.lattice.ReducedLattices.LatticeEdge)Copyedges.get(j));
    //   43   85:aload_0         
    //   44   86:getfield        #309 <Field Vector edges>
    //   45   89:aload_0         
    //   46   90:getfield        #50  <Field Vector Copyedges>
    //   47   93:iload_1         
    //   48   94:invokevirtual   #200 <Method Object Vector.get(int)>
    //   49   97:checkcast       #311 <Class rm.rolemining.lattice.ReducedLattices$LatticeEdge>
    //   50  100:invokevirtual   #306 <Method boolean Vector.add(Object)>
    //   51  103:pop             

    //   52  104:iinc            1  1
    //   53  107:iload_1         
    //   54  108:aload_0         
    //   55  109:getfield        #50  <Field Vector Copyedges>
    //   56  112:invokevirtual   #130 <Method int Vector.size()>
    //   57  115:icmplt          85
        nedges = edges.size();
    //   58  118:aload_0         
    //   59  119:aload_0         
    //   60  120:getfield        #309 <Field Vector edges>
    //   61  123:invokevirtual   #130 <Method int Vector.size()>
    //   62  126:putfield        #274 <Field int nedges>
    //   63  129:return          
    }

    private ArrayList NodesSort()
    {
        ArrayList Ordernodes = new ArrayList();
    //    0    0:new             #155 <Class ArrayList>
    //    1    3:dup             
    //    2    4:invokespecial   #407 <Method void ArrayList()>
    //    3    7:astore_1        
        for(int i = 0; i < nnodes; i++)
    //*   4    8:iconst_0        
    //*   5    9:istore_2        
    //*   6   10:goto            59
            if(((Concept)nodes.get(i)).getNumberOfObjects() == 0 && ((Concept)nodes.get(i)).getNumberOfAttributes() == 0)
    //*   7   13:aload_0         
    //*   8   14:getfield        #127 <Field Vector nodes>
    //*   9   17:iload_2         
    //*  10   18:invokevirtual   #200 <Method Object Vector.get(int)>
    //*  11   21:checkcast       #202 <Class Concept>
    //*  12   24:invokevirtual   #205 <Method int Concept.getNumberOfObjects()>
    //*  13   27:ifne            56
    //*  14   30:aload_0         
    //*  15   31:getfield        #127 <Field Vector nodes>
    //*  16   34:iload_2         
    //*  17   35:invokevirtual   #200 <Method Object Vector.get(int)>
    //*  18   38:checkcast       #202 <Class Concept>
    //*  19   41:invokevirtual   #208 <Method int Concept.getNumberOfAttributes()>
    //*  20   44:ifne            56
                Ordernodes.add(Integer.valueOf(i));
    //   21   47:aload_1         
    //   22   48:iload_2         
    //   23   49:invokestatic    #185 <Method Integer Integer.valueOf(int)>
    //   24   52:invokevirtual   #408 <Method boolean ArrayList.add(Object)>
    //   25   55:pop             

    //   26   56:iinc            2  1
    //   27   59:iload_2         
    //   28   60:aload_0         
    //   29   61:getfield        #269 <Field int nnodes>
    //   30   64:icmplt          13
        for(int i = 0; i < nnodes; i++)
    //*  31   67:iconst_0        
    //*  32   68:istore_2        
    //*  33   69:goto            118
            if(((Concept)nodes.get(i)).getNumberOfObjects() > 0 && ((Concept)nodes.get(i)).getNumberOfAttributes() == 0)
    //*  34   72:aload_0         
    //*  35   73:getfield        #127 <Field Vector nodes>
    //*  36   76:iload_2         
    //*  37   77:invokevirtual   #200 <Method Object Vector.get(int)>
    //*  38   80:checkcast       #202 <Class Concept>
    //*  39   83:invokevirtual   #205 <Method int Concept.getNumberOfObjects()>
    //*  40   86:ifle            115
    //*  41   89:aload_0         
    //*  42   90:getfield        #127 <Field Vector nodes>
    //*  43   93:iload_2         
    //*  44   94:invokevirtual   #200 <Method Object Vector.get(int)>
    //*  45   97:checkcast       #202 <Class Concept>
    //*  46  100:invokevirtual   #208 <Method int Concept.getNumberOfAttributes()>
    //*  47  103:ifne            115
                Ordernodes.add(Integer.valueOf(i));
    //   48  106:aload_1         
    //   49  107:iload_2         
    //   50  108:invokestatic    #185 <Method Integer Integer.valueOf(int)>
    //   51  111:invokevirtual   #408 <Method boolean ArrayList.add(Object)>
    //   52  114:pop             

    //   53  115:iinc            2  1
    //   54  118:iload_2         
    //   55  119:aload_0         
    //   56  120:getfield        #269 <Field int nnodes>
    //   57  123:icmplt          72
        for(int i = 0; i < nnodes; i++)
    //*  58  126:iconst_0        
    //*  59  127:istore_2        
    //*  60  128:goto            177
            if(((Concept)nodes.get(i)).getNumberOfObjects() == 0 && ((Concept)nodes.get(i)).getNumberOfAttributes() > 0)
    //*  61  131:aload_0         
    //*  62  132:getfield        #127 <Field Vector nodes>
    //*  63  135:iload_2         
    //*  64  136:invokevirtual   #200 <Method Object Vector.get(int)>
    //*  65  139:checkcast       #202 <Class Concept>
    //*  66  142:invokevirtual   #205 <Method int Concept.getNumberOfObjects()>
    //*  67  145:ifne            174
    //*  68  148:aload_0         
    //*  69  149:getfield        #127 <Field Vector nodes>
    //*  70  152:iload_2         
    //*  71  153:invokevirtual   #200 <Method Object Vector.get(int)>
    //*  72  156:checkcast       #202 <Class Concept>
    //*  73  159:invokevirtual   #208 <Method int Concept.getNumberOfAttributes()>
    //*  74  162:ifle            174
                Ordernodes.add(Integer.valueOf(i));
    //   75  165:aload_1         
    //   76  166:iload_2         
    //   77  167:invokestatic    #185 <Method Integer Integer.valueOf(int)>
    //   78  170:invokevirtual   #408 <Method boolean ArrayList.add(Object)>
    //   79  173:pop             

    //   80  174:iinc            2  1
    //   81  177:iload_2         
    //   82  178:aload_0         
    //   83  179:getfield        #269 <Field int nnodes>
    //   84  182:icmplt          131
        for(int i = 0; i < nnodes; i++)
    //*  85  185:iconst_0        
    //*  86  186:istore_2        
    //*  87  187:goto            236
            if(((Concept)nodes.get(i)).getNumberOfObjects() > 0 && ((Concept)nodes.get(i)).getNumberOfAttributes() > 0)
    //*  88  190:aload_0         
    //*  89  191:getfield        #127 <Field Vector nodes>
    //*  90  194:iload_2         
    //*  91  195:invokevirtual   #200 <Method Object Vector.get(int)>
    //*  92  198:checkcast       #202 <Class Concept>
    //*  93  201:invokevirtual   #205 <Method int Concept.getNumberOfObjects()>
    //*  94  204:ifle            233
    //*  95  207:aload_0         
    //*  96  208:getfield        #127 <Field Vector nodes>
    //*  97  211:iload_2         
    //*  98  212:invokevirtual   #200 <Method Object Vector.get(int)>
    //*  99  215:checkcast       #202 <Class Concept>
    //* 100  218:invokevirtual   #208 <Method int Concept.getNumberOfAttributes()>
    //* 101  221:ifle            233
                Ordernodes.add(Integer.valueOf(i));
    //  102  224:aload_1         
    //  103  225:iload_2         
    //  104  226:invokestatic    #185 <Method Integer Integer.valueOf(int)>
    //  105  229:invokevirtual   #408 <Method boolean ArrayList.add(Object)>
    //  106  232:pop             

    //  107  233:iinc            2  1
    //  108  236:iload_2         
    //  109  237:aload_0         
    //  110  238:getfield        #269 <Field int nnodes>
    //  111  241:icmplt          190
        return Ordernodes;
    //  112  244:aload_1         
    //  113  245:areturn         
    }

    public void resetOptions()
    {
        wr = 1;
    //    0    0:aload_0         
    //    1    1:iconst_1        
    //    2    2:putfield        #110 <Field int wr>
        wu = 1;
    //    3    5:aload_0         
    //    4    6:iconst_1        
    //    5    7:putfield        #112 <Field int wu>
        wp = 1;
    //    6   10:aload_0         
    //    7   11:iconst_1        
    //    8   12:putfield        #114 <Field int wp>
        wh = 1;
    //    9   15:aload_0         
    //   10   16:iconst_1        
    //   11   17:putfield        #116 <Field int wh>
        t = 0.5D;
    //   12   20:aload_0         
    //   13   21:ldc2w           #410 <Double 0.5D>
    //   14   24:putfield        #232 <Field double t>
        a = 0.10000000000000001D;
    //   15   27:aload_0         
    //   16   28:ldc2w           #412 <Double 0.10000000000000001D>
    //   17   31:putfield        #254 <Field double a>
    //   18   34:return          
    }

    public String globalInfo()
    {
        return "FeatureMiner which use the theory of formal concept analysis\ncan reduce the composite roles. \n";
    //    0    0:ldc2            #416 <String "FeatureMiner which use the theory of formal concept analysis\ncan reduce the composite roles. \n">
    //    1    3:areturn         
    }

    public Enumeration listOptions()
    {
        String string1 = (new StringBuilder("\tRequired weight of number of role for WSC. (default = ")).append(wr).append(")").toString();
    //    0    0:new             #166 <Class StringBuilder>
    //    1    3:dup             
    //    2    4:ldc2            #420 <String "\tRequired weight of number of role for WSC. (default = ">
    //    3    7:invokespecial   #173 <Method void StringBuilder(String)>
    //    4   10:aload_0         
    //    5   11:getfield        #110 <Field int wr>
    //    6   14:invokevirtual   #277 <Method StringBuilder StringBuilder.append(int)>
    //    7   17:ldc2            #422 <String ")">
    //    8   20:invokevirtual   #178 <Method StringBuilder StringBuilder.append(String)>
    //    9   23:invokevirtual   #182 <Method String StringBuilder.toString()>
    //   10   26:astore_1        
        String string2 = (new StringBuilder("\tRequired weight of number of user for WSC. (default = ")).append(wu).append(")").toString();
    //   11   27:new             #166 <Class StringBuilder>
    //   12   30:dup             
    //   13   31:ldc2            #424 <String "\tRequired weight of number of user for WSC. (default = ">
    //   14   34:invokespecial   #173 <Method void StringBuilder(String)>
    //   15   37:aload_0         
    //   16   38:getfield        #112 <Field int wu>
    //   17   41:invokevirtual   #277 <Method StringBuilder StringBuilder.append(int)>
    //   18   44:ldc2            #422 <String ")">
    //   19   47:invokevirtual   #178 <Method StringBuilder StringBuilder.append(String)>
    //   20   50:invokevirtual   #182 <Method String StringBuilder.toString()>
    //   21   53:astore_2        
        String string3 = (new StringBuilder("\tRequired weight of number of permission for WSC. (default = ")).append(wp).append(")").toString();
    //   22   54:new             #166 <Class StringBuilder>
    //   23   57:dup             
    //   24   58:ldc2            #426 <String "\tRequired weight of number of permission for WSC. (default = ">
    //   25   61:invokespecial   #173 <Method void StringBuilder(String)>
    //   26   64:aload_0         
    //   27   65:getfield        #114 <Field int wp>
    //   28   68:invokevirtual   #277 <Method StringBuilder StringBuilder.append(int)>
    //   29   71:ldc2            #422 <String ")">
    //   30   74:invokevirtual   #178 <Method StringBuilder StringBuilder.append(String)>
    //   31   77:invokevirtual   #182 <Method String StringBuilder.toString()>
    //   32   80:astore_3        
        String string4 = (new StringBuilder("\tRequired weight of number of roles' hierarchy for WSC. (default = ")).append(wh).append(")").toString();
    //   33   81:new             #166 <Class StringBuilder>
    //   34   84:dup             
    //   35   85:ldc2            #428 <String "\tRequired weight of number of roles' hierarchy for WSC. (default = ">
    //   36   88:invokespecial   #173 <Method void StringBuilder(String)>
    //   37   91:aload_0         
    //   38   92:getfield        #116 <Field int wh>
    //   39   95:invokevirtual   #277 <Method StringBuilder StringBuilder.append(int)>
    //   40   98:ldc2            #422 <String ")">
    //   41  101:invokevirtual   #178 <Method StringBuilder StringBuilder.append(String)>
    //   42  104:invokevirtual   #182 <Method String StringBuilder.toString()>
    //   43  107:astore          4
        String string5 = (new StringBuilder("\tRequired RC threshold. (default = ")).append(t).append(")").toString();
    //   44  109:new             #166 <Class StringBuilder>
    //   45  112:dup             
    //   46  113:ldc2            #430 <String "\tRequired RC threshold. (default = ">
    //   47  116:invokespecial   #173 <Method void StringBuilder(String)>
    //   48  119:aload_0         
    //   49  120:getfield        #232 <Field double t>
    //   50  123:invokevirtual   #433 <Method StringBuilder StringBuilder.append(double)>
    //   51  126:ldc2            #422 <String ")">
    //   52  129:invokevirtual   #178 <Method StringBuilder StringBuilder.append(String)>
    //   53  132:invokevirtual   #182 <Method String StringBuilder.toString()>
    //   54  135:astore          5
        String string6 = (new StringBuilder("\tRequired most increasement of WSC for a merging operation. (default = ")).append(a).append(")").toString();
    //   55  137:new             #166 <Class StringBuilder>
    //   56  140:dup             
    //   57  141:ldc2            #435 <String "\tRequired most increasement of WSC for a merging operation. (default = ">
    //   58  144:invokespecial   #173 <Method void StringBuilder(String)>
    //   59  147:aload_0         
    //   60  148:getfield        #254 <Field double a>
    //   61  151:invokevirtual   #433 <Method StringBuilder StringBuilder.append(double)>
    //   62  154:ldc2            #422 <String ")">
    //   63  157:invokevirtual   #178 <Method StringBuilder StringBuilder.append(String)>
    //   64  160:invokevirtual   #182 <Method String StringBuilder.toString()>
    //   65  163:astore          6
        FastVector newVector = new FastVector(6);
    //   66  165:new             #437 <Class FastVector>
    //   67  168:dup             
    //   68  169:bipush          6
    //   69  171:invokespecial   #439 <Method void FastVector(int)>
    //   70  174:astore          7
        newVector.addElement(new Option(string1, "R", wr, "-R <required weight of number of role>"));
    //   71  176:aload           7
    //   72  178:new             #441 <Class Option>
    //   73  181:dup             
    //   74  182:aload_1         
    //   75  183:ldc2            #442 <String "R">
    //   76  186:aload_0         
    //   77  187:getfield        #110 <Field int wr>
    //   78  190:ldc2            #444 <String "-R <required weight of number of role>">
    //   79  193:invokespecial   #447 <Method void Option(String, String, int, String)>
    //   80  196:invokevirtual   #451 <Method void FastVector.addElement(Object)>
        newVector.addElement(new Option(string2, "U", wu, "-U <required weight of number of user>"));
    //   81  199:aload           7
    //   82  201:new             #441 <Class Option>
    //   83  204:dup             
    //   84  205:aload_2         
    //   85  206:ldc2            #453 <String "U">
    //   86  209:aload_0         
    //   87  210:getfield        #112 <Field int wu>
    //   88  213:ldc2            #455 <String "-U <required weight of number of user>">
    //   89  216:invokespecial   #447 <Method void Option(String, String, int, String)>
    //   90  219:invokevirtual   #451 <Method void FastVector.addElement(Object)>
        newVector.addElement(new Option(string3, "P", wp, "-P <required weight of number of permission>"));
    //   91  222:aload           7
    //   92  224:new             #441 <Class Option>
    //   93  227:dup             
    //   94  228:aload_3         
    //   95  229:ldc2            #457 <String "P">
    //   96  232:aload_0         
    //   97  233:getfield        #114 <Field int wp>
    //   98  236:ldc2            #459 <String "-P <required weight of number of permission>">
    //   99  239:invokespecial   #447 <Method void Option(String, String, int, String)>
    //  100  242:invokevirtual   #451 <Method void FastVector.addElement(Object)>
        newVector.addElement(new Option(string4, "H", wh, "-H <required weight of number of roles' hierarchy>"));
    //  101  245:aload           7
    //  102  247:new             #441 <Class Option>
    //  103  250:dup             
    //  104  251:aload           4
    //  105  253:ldc2            #461 <String "H">
    //  106  256:aload_0         
    //  107  257:getfield        #116 <Field int wh>
    //  108  260:ldc2            #463 <String "-H <required weight of number of roles' hierarchy>">
    //  109  263:invokespecial   #447 <Method void Option(String, String, int, String)>
    //  110  266:invokevirtual   #451 <Method void FastVector.addElement(Object)>
        newVector.addElement(new Option(string5, "T", wh, "-T <required RC threshold.>"));
    //  111  269:aload           7
    //  112  271:new             #441 <Class Option>
    //  113  274:dup             
    //  114  275:aload           5
    //  115  277:ldc2            #465 <String "T">
    //  116  280:aload_0         
    //  117  281:getfield        #116 <Field int wh>
    //  118  284:ldc2            #467 <String "-T <required RC threshold.>">
    //  119  287:invokespecial   #447 <Method void Option(String, String, int, String)>
    //  120  290:invokevirtual   #451 <Method void FastVector.addElement(Object)>
        newVector.addElement(new Option(string6, "A", wh, "-A <required most increasement of WSC for a merging operation.>"));
    //  121  293:aload           7
    //  122  295:new             #441 <Class Option>
    //  123  298:dup             
    //  124  299:aload           6
    //  125  301:ldc2            #469 <String "A">
    //  126  304:aload_0         
    //  127  305:getfield        #116 <Field int wh>
    //  128  308:ldc2            #471 <String "-A <required most increasement of WSC for a merging operation.>">
    //  129  311:invokespecial   #447 <Method void Option(String, String, int, String)>
    //  130  314:invokevirtual   #451 <Method void FastVector.addElement(Object)>
        return newVector.elements();
    //  131  317:aload           7
    //  132  319:invokevirtual   #474 <Method Enumeration FastVector.elements()>
    //  133  322:areturn         
    }

    public void setOptions(String options[])
        throws Exception
    {
        resetOptions();
    //    0    0:aload_0         
    //    1    1:invokevirtual   #58  <Method void resetOptions()>
        String s_wr = Utils.getOption('R', options);
    //    2    4:bipush          82
    //    3    6:aload_1         
    //    4    7:invokestatic    #493 <Method String Utils.getOption(char, String[])>
    //    5   10:astore_2        
        if(s_wr.length() != 0)
    //*   6   11:aload_2         
    //*   7   12:invokevirtual   #496 <Method int String.length()>
    //*   8   15:ifeq            26
            wr = Integer.parseInt(s_wr);
    //    9   18:aload_0         
    //   10   19:aload_2         
    //   11   20:invokestatic    #500 <Method int Integer.parseInt(String)>
    //   12   23:putfield        #110 <Field int wr>
        String s_wu = Utils.getOption('U', options);
    //   13   26:bipush          85
    //   14   28:aload_1         
    //   15   29:invokestatic    #493 <Method String Utils.getOption(char, String[])>
    //   16   32:astore_3        
        if(s_wu.length() != 0)
    //*  17   33:aload_3         
    //*  18   34:invokevirtual   #496 <Method int String.length()>
    //*  19   37:ifeq            48
            wu = Integer.parseInt(s_wu);
    //   20   40:aload_0         
    //   21   41:aload_3         
    //   22   42:invokestatic    #500 <Method int Integer.parseInt(String)>
    //   23   45:putfield        #112 <Field int wu>
        String s_wp = Utils.getOption('P', options);
    //   24   48:bipush          80
    //   25   50:aload_1         
    //   26   51:invokestatic    #493 <Method String Utils.getOption(char, String[])>
    //   27   54:astore          4
        if(s_wp.length() != 0)
    //*  28   56:aload           4
    //*  29   58:invokevirtual   #496 <Method int String.length()>
    //*  30   61:ifeq            73
            wp = Integer.parseInt(s_wp);
    //   31   64:aload_0         
    //   32   65:aload           4
    //   33   67:invokestatic    #500 <Method int Integer.parseInt(String)>
    //   34   70:putfield        #114 <Field int wp>
        String s_wh = Utils.getOption('H', options);
    //   35   73:bipush          72
    //   36   75:aload_1         
    //   37   76:invokestatic    #493 <Method String Utils.getOption(char, String[])>
    //   38   79:astore          5
        if(s_wu.length() != 0)
    //*  39   81:aload_3         
    //*  40   82:invokevirtual   #496 <Method int String.length()>
    //*  41   85:ifeq            97
            wh = Integer.parseInt(s_wh);
    //   42   88:aload_0         
    //   43   89:aload           5
    //   44   91:invokestatic    #500 <Method int Integer.parseInt(String)>
    //   45   94:putfield        #116 <Field int wh>
        String s_t = Utils.getOption('T', options);
    //   46   97:bipush          84
    //   47   99:aload_1         
    //   48  100:invokestatic    #493 <Method String Utils.getOption(char, String[])>
    //   49  103:astore          6
        if(s_t.length() != 0)
    //*  50  105:aload           6
    //*  51  107:invokevirtual   #496 <Method int String.length()>
    //*  52  110:ifeq            122
            t = Double.parseDouble(s_t);
    //   53  113:aload_0         
    //   54  114:aload           6
    //   55  116:invokestatic    #506 <Method double Double.parseDouble(String)>
    //   56  119:putfield        #232 <Field double t>
        String s_a = Utils.getOption('A', options);
    //   57  122:bipush          65
    //   58  124:aload_1         
    //   59  125:invokestatic    #493 <Method String Utils.getOption(char, String[])>
    //   60  128:astore          7
        if(s_a.length() != 0)
    //*  61  130:aload           7
    //*  62  132:invokevirtual   #496 <Method int String.length()>
    //*  63  135:ifeq            147
            a = Double.parseDouble(s_a);
    //   64  138:aload_0         
    //   65  139:aload           7
    //   66  141:invokestatic    #506 <Method double Double.parseDouble(String)>
    //   67  144:putfield        #254 <Field double a>
    //   68  147:return          
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
    //    8   13:ldc2            #517 <String "-R">
    //    9   16:aastore         
        options[current++] = (new StringBuilder()).append(wr).toString();
    //   10   17:aload_1         
    //   11   18:iload_2         
    //   12   19:iinc            2  1
    //   13   22:new             #166 <Class StringBuilder>
    //   14   25:dup             
    //   15   26:invokespecial   #518 <Method void StringBuilder()>
    //   16   29:aload_0         
    //   17   30:getfield        #110 <Field int wr>
    //   18   33:invokevirtual   #277 <Method StringBuilder StringBuilder.append(int)>
    //   19   36:invokevirtual   #182 <Method String StringBuilder.toString()>
    //   20   39:aastore         
        options[current++] = "-U";
    //   21   40:aload_1         
    //   22   41:iload_2         
    //   23   42:iinc            2  1
    //   24   45:ldc2            #520 <String "-U">
    //   25   48:aastore         
        options[current++] = (new StringBuilder()).append(wu).toString();
    //   26   49:aload_1         
    //   27   50:iload_2         
    //   28   51:iinc            2  1
    //   29   54:new             #166 <Class StringBuilder>
    //   30   57:dup             
    //   31   58:invokespecial   #518 <Method void StringBuilder()>
    //   32   61:aload_0         
    //   33   62:getfield        #112 <Field int wu>
    //   34   65:invokevirtual   #277 <Method StringBuilder StringBuilder.append(int)>
    //   35   68:invokevirtual   #182 <Method String StringBuilder.toString()>
    //   36   71:aastore         
        options[current++] = "-P";
    //   37   72:aload_1         
    //   38   73:iload_2         
    //   39   74:iinc            2  1
    //   40   77:ldc2            #522 <String "-P">
    //   41   80:aastore         
        options[current++] = (new StringBuilder()).append(wp).toString();
    //   42   81:aload_1         
    //   43   82:iload_2         
    //   44   83:iinc            2  1
    //   45   86:new             #166 <Class StringBuilder>
    //   46   89:dup             
    //   47   90:invokespecial   #518 <Method void StringBuilder()>
    //   48   93:aload_0         
    //   49   94:getfield        #114 <Field int wp>
    //   50   97:invokevirtual   #277 <Method StringBuilder StringBuilder.append(int)>
    //   51  100:invokevirtual   #182 <Method String StringBuilder.toString()>
    //   52  103:aastore         
        options[current++] = "-H";
    //   53  104:aload_1         
    //   54  105:iload_2         
    //   55  106:iinc            2  1
    //   56  109:ldc2            #524 <String "-H">
    //   57  112:aastore         
        options[current++] = (new StringBuilder()).append(wh).toString();
    //   58  113:aload_1         
    //   59  114:iload_2         
    //   60  115:iinc            2  1
    //   61  118:new             #166 <Class StringBuilder>
    //   62  121:dup             
    //   63  122:invokespecial   #518 <Method void StringBuilder()>
    //   64  125:aload_0         
    //   65  126:getfield        #116 <Field int wh>
    //   66  129:invokevirtual   #277 <Method StringBuilder StringBuilder.append(int)>
    //   67  132:invokevirtual   #182 <Method String StringBuilder.toString()>
    //   68  135:aastore         
        options[current++] = "-T";
    //   69  136:aload_1         
    //   70  137:iload_2         
    //   71  138:iinc            2  1
    //   72  141:ldc2            #526 <String "-T">
    //   73  144:aastore         
        options[current++] = (new StringBuilder()).append(t).toString();
    //   74  145:aload_1         
    //   75  146:iload_2         
    //   76  147:iinc            2  1
    //   77  150:new             #166 <Class StringBuilder>
    //   78  153:dup             
    //   79  154:invokespecial   #518 <Method void StringBuilder()>
    //   80  157:aload_0         
    //   81  158:getfield        #232 <Field double t>
    //   82  161:invokevirtual   #433 <Method StringBuilder StringBuilder.append(double)>
    //   83  164:invokevirtual   #182 <Method String StringBuilder.toString()>
    //   84  167:aastore         
        options[current++] = "-A";
    //   85  168:aload_1         
    //   86  169:iload_2         
    //   87  170:iinc            2  1
    //   88  173:ldc2            #528 <String "-A">
    //   89  176:aastore         
        for(options[current++] = (new StringBuilder()).append(a).toString(); current < options.length; options[current++] = "");
    //   90  177:aload_1         
    //   91  178:iload_2         
    //   92  179:iinc            2  1
    //   93  182:new             #166 <Class StringBuilder>
    //   94  185:dup             
    //   95  186:invokespecial   #518 <Method void StringBuilder()>
    //   96  189:aload_0         
    //   97  190:getfield        #254 <Field double a>
    //   98  193:invokevirtual   #433 <Method StringBuilder StringBuilder.append(double)>
    //   99  196:invokevirtual   #182 <Method String StringBuilder.toString()>
    //  100  199:aastore         
    //  101  200:goto            212
    //  102  203:aload_1         
    //  103  204:iload_2         
    //  104  205:iinc            2  1
    //  105  208:ldc2            #352 <String "">
    //  106  211:aastore         
    //  107  212:iload_2         
    //  108  213:aload_1         
    //  109  214:arraylength     
    //  110  215:icmplt          203
        return options;
    //  111  218:aload_1         
    //  112  219:areturn         
    }

    public Assignment generateRoles()
    {
        m_assroles = new Assignment();
    //    0    0:aload_0         
    //    1    1:new             #68  <Class Assignment>
    //    2    4:dup             
    //    3    5:invokespecial   #532 <Method void Assignment()>
    //    4    8:putfield        #534 <Field Assignment m_assroles>
        m_assroles.setAssignementName("role-permission");
    //    5   11:aload_0         
    //    6   12:getfield        #534 <Field Assignment m_assroles>
    //    7   15:ldc2            #536 <String "role-permission">
    //    8   18:invokevirtual   #539 <Method void Assignment.setAssignementName(String)>
        Matrix mat = new Matrix(nodes.size(), noPerms, (byte)0);
    //    9   21:new             #541 <Class Matrix>
    //   10   24:dup             
    //   11   25:aload_0         
    //   12   26:getfield        #127 <Field Vector nodes>
    //   13   29:invokevirtual   #130 <Method int Vector.size()>
    //   14   32:aload_0         
    //   15   33:getfield        #93  <Field int noPerms>
    //   16   36:iconst_0        
    //   17   37:invokespecial   #544 <Method void Matrix(int, int, byte)>
    //   18   40:astore_1        
        for(int i = 0; i < nodes.size(); i++)
    //*  19   41:iconst_0        
    //*  20   42:istore_2        
    //*  21   43:goto            99
        {
            IntegerSet upi = ((Concept)nodes.get(i)).allAttributes;
    //   22   46:aload_0         
    //   23   47:getfield        #127 <Field Vector nodes>
    //   24   50:iload_2         
    //   25   51:invokevirtual   #200 <Method Object Vector.get(int)>
    //   26   54:checkcast       #202 <Class Concept>
    //   27   57:getfield        #220 <Field IntegerSet Concept.allAttributes>
    //   28   60:astore_3        
            for(int j = 0; j < noPerms; j++)
    //*  29   61:iconst_0        
    //*  30   62:istore          4
    //*  31   64:goto            87
                if(upi.contains(j))
    //*  32   67:aload_3         
    //*  33   68:iload           4
    //*  34   70:invokevirtual   #548 <Method boolean IntegerSet.contains(int)>
    //*  35   73:ifeq            84
                    mat.set(i, j, (byte)1);
    //   36   76:aload_1         
    //   37   77:iload_2         
    //   38   78:iload           4
    //   39   80:iconst_1        
    //   40   81:invokevirtual   #550 <Method void Matrix.set(int, int, byte)>

    //   41   84:iinc            4  1
    //   42   87:iload           4
    //   43   89:aload_0         
    //   44   90:getfield        #93  <Field int noPerms>
    //   45   93:icmplt          67
        }

    //   46   96:iinc            2  1
    //   47   99:iload_2         
    //   48  100:aload_0         
    //   49  101:getfield        #127 <Field Vector nodes>
    //   50  104:invokevirtual   #130 <Method int Vector.size()>
    //   51  107:icmplt          46
        m_assroles.setAssignmentMatrix(mat);
    //   52  110:aload_0         
    //   53  111:getfield        #534 <Field Assignment m_assroles>
    //   54  114:aload_1         
    //   55  115:invokevirtual   #554 <Method void Assignment.setAssignmentMatrix(Matrix)>
        FastVector fv = new FastVector();
    //   56  118:new             #437 <Class FastVector>
    //   57  121:dup             
    //   58  122:invokespecial   #555 <Method void FastVector()>
    //   59  125:astore_2        
        for(int i = 0; i < nodes.size(); i++)
    //*  60  126:iconst_0        
    //*  61  127:istore_3        
    //*  62  128:goto            155
            fv.addElement((new StringBuilder("R")).append(i).toString());
    //   63  131:aload_2         
    //   64  132:new             #166 <Class StringBuilder>
    //   65  135:dup             
    //   66  136:ldc2            #442 <String "R">
    //   67  139:invokespecial   #173 <Method void StringBuilder(String)>
    //   68  142:iload_3         
    //   69  143:invokevirtual   #277 <Method StringBuilder StringBuilder.append(int)>
    //   70  146:invokevirtual   #182 <Method String StringBuilder.toString()>
    //   71  149:invokevirtual   #451 <Method void FastVector.addElement(Object)>

    //   72  152:iinc            3  1
    //   73  155:iload_3         
    //   74  156:aload_0         
    //   75  157:getfield        #127 <Field Vector nodes>
    //   76  160:invokevirtual   #130 <Method int Vector.size()>
    //   77  163:icmplt          131
        Attribute dxa = new Attribute("role", fv);
    //   78  166:new             #80  <Class Attribute>
    //   79  169:dup             
    //   80  170:ldc2            #557 <String "role">
    //   81  173:aload_2         
    //   82  174:invokespecial   #560 <Method void Attribute(String, FastVector)>
    //   83  177:astore_3        
        Dimension dx = new Dimension();
    //   84  178:new             #74  <Class Dimension>
    //   85  181:dup             
    //   86  182:invokespecial   #561 <Method void Dimension()>
    //   87  185:astore          4
        dx.setDimensionAttribute(dxa);
    //   88  187:aload           4
    //   89  189:aload_3         
    //   90  190:invokevirtual   #565 <Method void Dimension.setDimensionAttribute(Attribute)>
        StringBuffer parents[] = new StringBuffer[nnodes];
    //   91  193:aload_0         
    //   92  194:getfield        #269 <Field int nnodes>
    //   93  197:anewarray       StringBuffer[]
    //   94  200:astore          5
        for(int i = 0; i < nodes.size(); i++)
    //*  95  202:iconst_0        
    //*  96  203:istore          6
    //*  97  205:goto            223
            parents[i] = new StringBuffer();
    //   98  208:aload           5
    //   99  210:iload           6
    //  100  212:new             #52  <Class StringBuffer>
    //  101  215:dup             
    //  102  216:invokespecial   #53  <Method void StringBuffer()>
    //  103  219:aastore         

    //  104  220:iinc            6  1
    //  105  223:iload           6
    //  106  225:aload_0         
    //  107  226:getfield        #127 <Field Vector nodes>
    //  108  229:invokevirtual   #130 <Method int Vector.size()>
    //  109  232:icmplt          208
        for(int j = 0; j < edges.size(); j++)
    //* 110  235:iconst_0        
    //* 111  236:istore          6
    //* 112  238:goto            300
            parents[((rm.rolemining.lattice.ReducedLattices.LatticeEdge)edges.get(j)).to].append((new StringBuilder(String.valueOf(((rm.rolemining.lattice.ReducedLattices.LatticeEdge)edges.get(j)).from))).append("|").toString());
    //  113  241:aload           5
    //  114  243:aload_0         
    //  115  244:getfield        #309 <Field Vector edges>
    //  116  247:iload           6
    //  117  249:invokevirtual   #200 <Method Object Vector.get(int)>
    //  118  252:checkcast       #311 <Class rm.rolemining.lattice.ReducedLattices$LatticeEdge>
    //  119  255:getfield        #321 <Field int rm.rolemining.lattice.ReducedLattices$LatticeEdge.to>
    //  120  258:aaload          
    //  121  259:new             #166 <Class StringBuilder>
    //  122  262:dup             
    //  123  263:aload_0         
    //  124  264:getfield        #309 <Field Vector edges>
    //  125  267:iload           6
    //  126  269:invokevirtual   #200 <Method Object Vector.get(int)>
    //  127  272:checkcast       #311 <Class rm.rolemining.lattice.ReducedLattices$LatticeEdge>
    //  128  275:getfield        #314 <Field int rm.rolemining.lattice.ReducedLattices$LatticeEdge.from>
    //  129  278:invokestatic    #170 <Method String String.valueOf(int)>
    //  130  281:invokespecial   #173 <Method void StringBuilder(String)>
    //  131  284:ldc2            #567 <String "|">
    //  132  287:invokevirtual   #178 <Method StringBuilder StringBuilder.append(String)>
    //  133  290:invokevirtual   #182 <Method String StringBuilder.toString()>
    //  134  293:invokevirtual   #149 <Method StringBuffer StringBuffer.append(String)>
    //  135  296:pop             

    //  136  297:iinc            6  1
    //  137  300:iload           6
    //  138  302:aload_0         
    //  139  303:getfield        #309 <Field Vector edges>
    //  140  306:invokevirtual   #130 <Method int Vector.size()>
    //  141  309:icmplt          241
        for(int i = 0; i < nodes.size(); i++)
    //* 142  312:iconst_0        
    //* 143  313:istore          6
    //* 144  315:goto            352
            if(parents[i].length() > 1)
    //* 145  318:aload           5
    //* 146  320:iload           6
    //* 147  322:aaload          
    //* 148  323:invokevirtual   #568 <Method int StringBuffer.length()>
    //* 149  326:iconst_1        
    //* 150  327:icmple          349
                parents[i].deleteCharAt(parents[i].length() - 1);
    //  151  330:aload           5
    //  152  332:iload           6
    //  153  334:aaload          
    //  154  335:aload           5
    //  155  337:iload           6
    //  156  339:aaload          
    //  157  340:invokevirtual   #568 <Method int StringBuffer.length()>
    //  158  343:iconst_1        
    //  159  344:isub            
    //  160  345:invokevirtual   #572 <Method StringBuffer StringBuffer.deleteCharAt(int)>
    //  161  348:pop             

    //  162  349:iinc            6  1
    //  163  352:iload           6
    //  164  354:aload_0         
    //  165  355:getfield        #127 <Field Vector nodes>
    //  166  358:invokevirtual   #130 <Method int Vector.size()>
    //  167  361:icmplt          318
        Attribute att = new Attribute("parents", null);
    //  168  364:new             #80  <Class Attribute>
    //  169  367:dup             
    //  170  368:ldc2            #574 <String "parents">
    //  171  371:aconst_null     
    //  172  372:invokespecial   #560 <Method void Attribute(String, FastVector)>
    //  173  375:astore          6
        FastVector fv_atts = new FastVector();
    //  174  377:new             #437 <Class FastVector>
    //  175  380:dup             
    //  176  381:invokespecial   #555 <Method void FastVector()>
    //  177  384:astore          7
        fv_atts.addElement(att);
    //  178  386:aload           7
    //  179  388:aload           6
    //  180  390:invokevirtual   #451 <Method void FastVector.addElement(Object)>
        Instances insSet = new Instances("role", fv_atts, 0);
    //  181  393:new             #576 <Class Instances>
    //  182  396:dup             
    //  183  397:ldc2            #557 <String "role">
    //  184  400:aload           7
    //  185  402:iconst_0        
    //  186  403:invokespecial   #579 <Method void Instances(String, FastVector, int)>
    //  187  406:astore          8
        for(int i = 0; i < nodes.size(); i++)
    //* 188  408:iconst_0        
    //* 189  409:istore          9
    //* 190  411:goto            456
        {
            Instance insi = new Instance(1);
    //  191  414:new             #581 <Class Instance>
    //  192  417:dup             
    //  193  418:iconst_1        
    //  194  419:invokespecial   #582 <Method void Instance(int)>
    //  195  422:astore          10
            insi.setDataset(insSet);
    //  196  424:aload           10
    //  197  426:aload           8
    //  198  428:invokevirtual   #586 <Method void Instance.setDataset(Instances)>
            insi.setValue(att, parents[i].toString());
    //  199  431:aload           10
    //  200  433:aload           6
    //  201  435:aload           5
    //  202  437:iload           9
    //  203  439:aaload          
    //  204  440:invokevirtual   #587 <Method String StringBuffer.toString()>
    //  205  443:invokevirtual   #591 <Method void Instance.setValue(Attribute, String)>
            insSet.add(insi);
    //  206  446:aload           8
    //  207  448:aload           10
    //  208  450:invokevirtual   #594 <Method void Instances.add(Instance)>
        }

    //  209  453:iinc            9  1
    //  210  456:iload           9
    //  211  458:aload_0         
    //  212  459:getfield        #127 <Field Vector nodes>
    //  213  462:invokevirtual   #130 <Method int Vector.size()>
    //  214  465:icmplt          414
        dx.setDimensionInstances(insSet);
    //  215  468:aload           4
    //  216  470:aload           8
    //  217  472:invokevirtual   #597 <Method void Dimension.setDimensionInstances(Instances)>
        m_assroles.setDimensionX(dx);
    //  218  475:aload_0         
    //  219  476:getfield        #534 <Field Assignment m_assroles>
    //  220  479:aload           4
    //  221  481:invokevirtual   #601 <Method void Assignment.setDimensionX(Dimension)>
        Attribute dya = m_assignment.getDimensionY().getDimensionAttribute();
    //  222  484:aload_0         
    //  223  485:getfield        #66  <Field Assignment m_assignment>
    //  224  488:invokevirtual   #91  <Method Dimension Assignment.getDimensionY()>
    //  225  491:invokevirtual   #78  <Method Attribute Dimension.getDimensionAttribute()>
    //  226  494:astore          9
        Dimension dy = new Dimension();
    //  227  496:new             #74  <Class Dimension>
    //  228  499:dup             
    //  229  500:invokespecial   #561 <Method void Dimension()>
    //  230  503:astore          10
        dy.setDimensionAttribute(dya);
    //  231  505:aload           10
    //  232  507:aload           9
    //  233  509:invokevirtual   #565 <Method void Dimension.setDimensionAttribute(Attribute)>
        m_assroles.setDimensionY(dy);
    //  234  512:aload_0         
    //  235  513:getfield        #534 <Field Assignment m_assroles>
    //  236  516:aload           10
    //  237  518:invokevirtual   #604 <Method void Assignment.setDimensionY(Dimension)>
        return m_assroles;
    //  238  521:aload_0         
    //  239  522:getfield        #534 <Field Assignment m_assroles>
    //  240  525:areturn         
    }

    public String toString()
    {
        return log.toString();
    //    0    0:aload_0         
    //    1    1:getfield        #55  <Field StringBuffer log>
    //    2    4:invokevirtual   #587 <Method String StringBuffer.toString()>
    //    3    7:areturn         
    }

    public int getWr()
    {
        return wr;
    //    0    0:aload_0         
    //    1    1:getfield        #110 <Field int wr>
    //    2    4:ireturn         
    }

    public void setWr(int wr)
    {
        this.wr = wr;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #110 <Field int wr>
    //    3    5:return          
    }

    public String wrTipText()
    {
        return "The required weight of number of role for WSC.";
    //    0    0:ldc2            #624 <String "The required weight of number of role for WSC.">
    //    1    3:areturn         
    }

    public int getWu()
    {
        return wu;
    //    0    0:aload_0         
    //    1    1:getfield        #112 <Field int wu>
    //    2    4:ireturn         
    }

    public void setWu(int wu)
    {
        this.wu = wu;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #112 <Field int wu>
    //    3    5:return          
    }

    public String wuTipText()
    {
        return "The required weight of number of user for WSC.";
    //    0    0:ldc2            #629 <String "The required weight of number of user for WSC.">
    //    1    3:areturn         
    }

    public int getWp()
    {
        return wp;
    //    0    0:aload_0         
    //    1    1:getfield        #114 <Field int wp>
    //    2    4:ireturn         
    }

    public void setWp(int wp)
    {
        this.wp = wp;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #114 <Field int wp>
    //    3    5:return          
    }

    public String wpTipText()
    {
        return "The required weight of number of permission for WSC.";
    //    0    0:ldc2            #634 <String "The required weight of number of permission for WSC.">
    //    1    3:areturn         
    }

    public int getWh()
    {
        return wh;
    //    0    0:aload_0         
    //    1    1:getfield        #116 <Field int wh>
    //    2    4:ireturn         
    }

    public void setWh(int wh)
    {
        this.wh = wh;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #116 <Field int wh>
    //    3    5:return          
    }

    public String whTipText()
    {
        return "The required weight of number of roles' hierarchy for WSC.";
    //    0    0:ldc2            #639 <String "The required weight of number of roles' hierarchy for WSC.">
    //    1    3:areturn         
    }

    public double getT()
    {
        return t;
    //    0    0:aload_0         
    //    1    1:getfield        #232 <Field double t>
    //    2    4:dreturn         
    }

    public void setT(double t)
    {
        this.t = t;
    //    0    0:aload_0         
    //    1    1:dload_1         
    //    2    2:putfield        #232 <Field double t>
    //    3    5:return          
    }

    public String tTipText()
    {
        return "The required RC threshold.";
    //    0    0:ldc2            #646 <String "The required RC threshold.">
    //    1    3:areturn         
    }

    public double getA()
    {
        return a;
    //    0    0:aload_0         
    //    1    1:getfield        #254 <Field double a>
    //    2    4:dreturn         
    }

    public void setA(double a)
    {
        this.a = a;
    //    0    0:aload_0         
    //    1    1:dload_1         
    //    2    2:putfield        #254 <Field double a>
    //    3    5:return          
    }

    public String aTipText()
    {
        return "The required most increasement of WSC for a merging operation.";
    //    0    0:ldc2            #651 <String "The required most increasement of WSC for a merging operation.">
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
    //    2    2:new             #654 <Class File>
    //    3    5:dup             
    //    4    6:new             #166 <Class StringBuilder>
    //    5    9:dup             
    //    6   10:ldc2            #656 <String "user.dir">
    //    7   13:invokestatic    #662 <Method String System.getProperty(String)>
    //    8   16:invokestatic    #665 <Method String String.valueOf(Object)>
    //    9   19:invokespecial   #173 <Method void StringBuilder(String)>
    //   10   22:ldc2            #667 <String "\\datasets\\university_runningexample.ass">
    //   11   25:invokevirtual   #178 <Method StringBuilder StringBuilder.append(String)>
    //   12   28:invokevirtual   #182 <Method String StringBuilder.toString()>
    //   13   31:invokespecial   #668 <Method void File(String)>
    //   14   34:astore_2        
            AssLoader AL = new AssLoader(new FileReader(file));
    //   15   35:new             #670 <Class AssLoader>
    //   16   38:dup             
    //   17   39:new             #672 <Class FileReader>
    //   18   42:dup             
    //   19   43:aload_2         
    //   20   44:invokespecial   #675 <Method void FileReader(File)>
    //   21   47:invokespecial   #678 <Method void AssLoader(FileReader)>
    //   22   50:astore_3        
            Ass = AL.getData();
    //   23   51:aload_3         
    //   24   52:invokevirtual   #681 <Method Assignment AssLoader.getData()>
    //   25   55:astore_1        
            System.out.println(Ass.getAssignementName());
    //   26   56:getstatic       #685 <Field PrintStream System.out>
    //   27   59:aload_1         
    //   28   60:invokevirtual   #688 <Method String Assignment.getAssignementName()>
    //   29   63:invokevirtual   #693 <Method void PrintStream.println(String)>
            FeatureMiner fm = new FeatureMiner();
    //   30   66:new             #2   <Class FeatureMiner>
    //   31   69:dup             
    //   32   70:invokespecial   #694 <Method void FeatureMiner()>
    //   33   73:astore          4
            fm.buildRoleminers(Ass);
    //   34   75:aload           4
    //   35   77:aload_1         
    //   36   78:invokevirtual   #696 <Method void buildRoleminers(Assignment)>
            System.out.println(fm.toString());
    //   37   81:getstatic       #685 <Field PrintStream System.out>
    //   38   84:aload           4
    //   39   86:invokevirtual   #697 <Method String toString()>
    //   40   89:invokevirtual   #693 <Method void PrintStream.println(String)>
            System.out.println(fm.generateRoles());
    //   41   92:getstatic       #685 <Field PrintStream System.out>
    //   42   95:aload           4
    //   43   97:invokevirtual   #699 <Method Assignment generateRoles()>
    //   44  100:invokevirtual   #701 <Method void PrintStream.println(Object)>
        }
    //*  45  103:goto            111
        catch(Exception e)
    //*  46  106:astore_2        
        {
            e.printStackTrace();
    //   47  107:aload_2         
    //   48  108:invokevirtual   #704 <Method void Exception.printStackTrace()>
        }
    //   49  111:return          
    }

    private int wr;
    private int wu;
    private int wp;
    private int wh;
    private int noUsers;
    private int noPerms;
    private double t;
    private double a;
    private Vector Copynodes;
    private Vector Copyedges;
    private boolean Copynodesflags[];
    private boolean nodesflags[];
    private rm.rolemining.lattice.ReducedLattices.WSC beforewsc;
    private rm.rolemining.lattice.ReducedLattices.WSC afterwsc;
    private rm.rolemining.lattice.ReducedLattices.WSC minwsc;
    private Assignment m_assignment;
    private Assignment m_assroles;
    private StringBuffer log;
    private Context f_context;
    private double beforesim;
    private double aftersim;
}
