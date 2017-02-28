// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   AttributeVisualizationPanel.java

package rm.core;

import java.awt.*;
import java.awt.event.*;
import java.io.FileReader;
import java.io.PrintStream;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import rm.gui.visualize.PrintableComponent;
import rm.gui.visualize.PrintablePanel;

// Referenced classes of package rm.core:
//            FastVector, Instances, Attribute, AttributeStats, 
//            Stats, SparseInstance, Utils, Instance

public class AttributeVisualizationPanel extends PrintablePanel
{
    private class BarCalc extends Thread
    {

        public void run()
        {
label0:
            {
                SparseInstance histClassCounts[];
                int histCounts[];
                int i;
                double tempClassCounts[];
                int k;
                Color pc;
                int tempAttValueIndex;
                int ija;
                int k;
                int numNonZero;
                int j;
                int numNonZero;
                int z;
                double nonZeroVals[];
                int z;
                double nonZeroVals[];
                int nonZeroIndices[];
                int nonZeroIndices[];
                int count;
                int count;
                int z;
                SparseInstance tempS;
                int z;
                SparseInstance tempS;
                synchronized(m_locker)
        //*   0    0:aload_0         
        //*   1    1:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //*   2    4:invokestatic    #34  <Method Integer AttributeVisualizationPanel.access$0(AttributeVisualizationPanel)>
        //*   3    7:dup             
        //*   4    8:astore_1        
        //*   5    9:monitorenter    
                {
                    if(m_data.attribute(m_attribIndex).numValues() <= m_panelWidth)
                        break label0;
        //    6   10:aload_0         
        //    7   11:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //    8   14:getfield        #38  <Field Instances AttributeVisualizationPanel.m_data>
        //    9   17:aload_0         
        //   10   18:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //   11   21:getfield        #41  <Field int AttributeVisualizationPanel.m_attribIndex>
        //   12   24:invokevirtual   #47  <Method Attribute Instances.attribute(int)>
        //   13   27:invokevirtual   #53  <Method int Attribute.numValues()>
        //   14   30:aload_0         
        //   15   31:getfield        #19  <Field int m_panelWidth>
        //   16   34:icmple          79
                    m_histBarClassCounts = null;
        //   17   37:aload_0         
        //   18   38:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //   19   41:aconst_null     
        //   20   42:putfield        #57  <Field SparseInstance[] AttributeVisualizationPanel.m_histBarClassCounts>
                    m_threadRun = false;
        //   21   45:aload_0         
        //   22   46:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //   23   49:iconst_0        
        //   24   50:invokestatic    #61  <Method void AttributeVisualizationPanel.access$1(AttributeVisualizationPanel, boolean)>
                    m_doneCurrentAttribute = true;
        //   25   53:aload_0         
        //   26   54:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //   27   57:iconst_1        
        //   28   58:invokestatic    #64  <Method void AttributeVisualizationPanel.access$2(AttributeVisualizationPanel, boolean)>
                    m_displayCurrentAttribute = false;
        //   29   61:aload_0         
        //   30   62:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //   31   65:iconst_0        
        //   32   66:invokestatic    #67  <Method void AttributeVisualizationPanel.access$3(AttributeVisualizationPanel, boolean)>
                    repaint();
        //   33   69:aload_0         
        //   34   70:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //   35   73:invokevirtual   #70  <Method void AttributeVisualizationPanel.repaint()>
                }
        //   36   76:aload_1         
        //   37   77:monitorexit     
        //   38   78:return          
        //   39   79:aload_0         
        //   40   80:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //   41   83:getfield        #73  <Field int AttributeVisualizationPanel.m_classIndex>
        //   42   86:iflt            904
        //   43   89:aload_0         
        //   44   90:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //   45   93:getfield        #38  <Field Instances AttributeVisualizationPanel.m_data>
        //   46   96:aload_0         
        //   47   97:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //   48  100:getfield        #73  <Field int AttributeVisualizationPanel.m_classIndex>
        //   49  103:invokevirtual   #47  <Method Attribute Instances.attribute(int)>
        //   50  106:invokevirtual   #77  <Method boolean Attribute.isNominal()>
        //   51  109:ifeq            904
        //   52  112:aload_0         
        //   53  113:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //   54  116:getfield        #38  <Field Instances AttributeVisualizationPanel.m_data>
        //   55  119:aload_0         
        //   56  120:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //   57  123:getfield        #41  <Field int AttributeVisualizationPanel.m_attribIndex>
        //   58  126:invokevirtual   #47  <Method Attribute Instances.attribute(int)>
        //   59  129:invokevirtual   #53  <Method int Attribute.numValues()>
        //   60  132:anewarray       SparseInstance[]
        //   61  135:astore_2        
        //   62  136:aload_0         
        //   63  137:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //   64  140:getfield        #83  <Field AttributeStats AttributeVisualizationPanel.m_as>
        //   65  143:getfield        #89  <Field int[] AttributeStats.nominalCounts>
        //   66  146:arraylength     
        //   67  147:ifle            245
        //   68  150:aload_0         
        //   69  151:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //   70  154:aload_0         
        //   71  155:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //   72  158:getfield        #83  <Field AttributeStats AttributeVisualizationPanel.m_as>
        //   73  161:getfield        #89  <Field int[] AttributeStats.nominalCounts>
        //   74  164:iconst_0        
        //   75  165:iaload          
        //   76  166:putfield        #92  <Field int AttributeVisualizationPanel.m_maxValue>
        //   77  169:iconst_0        
        //   78  170:istore_3        
        //   79  171:goto            218
        //   80  174:aload_0         
        //   81  175:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //   82  178:getfield        #83  <Field AttributeStats AttributeVisualizationPanel.m_as>
        //   83  181:getfield        #89  <Field int[] AttributeStats.nominalCounts>
        //   84  184:iload_3         
        //   85  185:iaload          
        //   86  186:aload_0         
        //   87  187:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //   88  190:getfield        #92  <Field int AttributeVisualizationPanel.m_maxValue>
        //   89  193:icmple          215
        //   90  196:aload_0         
        //   91  197:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //   92  200:aload_0         
        //   93  201:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //   94  204:getfield        #83  <Field AttributeStats AttributeVisualizationPanel.m_as>
        //   95  207:getfield        #89  <Field int[] AttributeStats.nominalCounts>
        //   96  210:iload_3         
        //   97  211:iaload          
        //   98  212:putfield        #92  <Field int AttributeVisualizationPanel.m_maxValue>
        //   99  215:iinc            3  1
        //  100  218:iload_3         
        //  101  219:aload_0         
        //  102  220:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  103  223:getfield        #38  <Field Instances AttributeVisualizationPanel.m_data>
        //  104  226:aload_0         
        //  105  227:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  106  230:getfield        #41  <Field int AttributeVisualizationPanel.m_attribIndex>
        //  107  233:invokevirtual   #47  <Method Attribute Instances.attribute(int)>
        //  108  236:invokevirtual   #53  <Method int Attribute.numValues()>
        //  109  239:icmplt          174
        //  110  242:goto            253
        //  111  245:aload_0         
        //  112  246:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  113  249:iconst_0        
        //  114  250:putfield        #92  <Field int AttributeVisualizationPanel.m_maxValue>
        //  115  253:aload_0         
        //  116  254:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  117  257:invokestatic    #96  <Method FastVector AttributeVisualizationPanel.access$4(AttributeVisualizationPanel)>
        //  118  260:invokevirtual   #101 <Method int FastVector.size()>
        //  119  263:ifne            279
        //  120  266:aload_0         
        //  121  267:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  122  270:invokestatic    #96  <Method FastVector AttributeVisualizationPanel.access$4(AttributeVisualizationPanel)>
        //  123  273:getstatic       #107 <Field Color Color.black>
        //  124  276:invokevirtual   #111 <Method void FastVector.addElement(Object)>
        //  125  279:aload_0         
        //  126  280:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  127  283:invokestatic    #96  <Method FastVector AttributeVisualizationPanel.access$4(AttributeVisualizationPanel)>
        //  128  286:invokevirtual   #101 <Method int FastVector.size()>
        //  129  289:istore_3        
        //  130  290:goto            357
        //  131  293:invokestatic    #115 <Method Color[] AttributeVisualizationPanel.access$5()>
        //  132  296:iload_3         
        //  133  297:iconst_1        
        //  134  298:isub            
        //  135  299:bipush          10
        //  136  301:irem            
        //  137  302:aaload          
        //  138  303:astore          4
        //  139  305:iload_3         
        //  140  306:iconst_1        
        //  141  307:isub            
        //  142  308:bipush          10
        //  143  310:idiv            
        //  144  311:istore          5
        //  145  313:iload           5
        //  146  315:iconst_2        
        //  147  316:imul            
        //  148  317:istore          5
        //  149  319:iconst_0        
        //  150  320:istore          6
        //  151  322:goto            335
        //  152  325:aload           4
        //  153  327:invokevirtual   #119 <Method Color Color.darker()>
        //  154  330:astore          4
        //  155  332:iinc            6  1
        //  156  335:iload           6
        //  157  337:iload           5
        //  158  339:icmplt          325
        //  159  342:aload_0         
        //  160  343:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  161  346:invokestatic    #96  <Method FastVector AttributeVisualizationPanel.access$4(AttributeVisualizationPanel)>
        //  162  349:aload           4
        //  163  351:invokevirtual   #111 <Method void FastVector.addElement(Object)>
        //  164  354:iinc            3  1
        //  165  357:iload_3         
        //  166  358:aload_0         
        //  167  359:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  168  362:getfield        #38  <Field Instances AttributeVisualizationPanel.m_data>
        //  169  365:aload_0         
        //  170  366:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  171  369:getfield        #73  <Field int AttributeVisualizationPanel.m_classIndex>
        //  172  372:invokevirtual   #47  <Method Attribute Instances.attribute(int)>
        //  173  375:invokevirtual   #53  <Method int Attribute.numValues()>
        //  174  378:iconst_1        
        //  175  379:iadd            
        //  176  380:icmplt          293
        //  177  383:aload_0         
        //  178  384:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  179  387:getfield        #38  <Field Instances AttributeVisualizationPanel.m_data>
        //  180  390:aload_0         
        //  181  391:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  182  394:getfield        #41  <Field int AttributeVisualizationPanel.m_attribIndex>
        //  183  397:invokevirtual   #123 <Method void Instances.sort(int)>
        //  184  400:aconst_null     
        //  185  401:checkcast       #125 <Class double[]>
        //  186  404:astore_3        
        //  187  405:iconst_m1       
        //  188  406:istore          4
        //  189  408:iconst_0        
        //  190  409:istore          5
        //  191  411:goto            731
        //  192  414:aload_0         
        //  193  415:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  194  418:getfield        #38  <Field Instances AttributeVisualizationPanel.m_data>
        //  195  421:iload           5
        //  196  423:invokevirtual   #129 <Method Instance Instances.instance(int)>
        //  197  426:aload_0         
        //  198  427:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  199  430:getfield        #41  <Field int AttributeVisualizationPanel.m_attribIndex>
        //  200  433:invokevirtual   #135 <Method boolean Instance.isMissing(int)>
        //  201  436:ifne            728
        //  202  439:aload_0         
        //  203  440:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  204  443:getfield        #38  <Field Instances AttributeVisualizationPanel.m_data>
        //  205  446:iload           5
        //  206  448:invokevirtual   #129 <Method Instance Instances.instance(int)>
        //  207  451:aload_0         
        //  208  452:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  209  455:getfield        #41  <Field int AttributeVisualizationPanel.m_attribIndex>
        //  210  458:invokevirtual   #139 <Method double Instance.value(int)>
        //  211  461:iload           4
        //  212  463:i2d             
        //  213  464:dcmpl           
        //  214  465:ifeq            634
        //  215  468:aload_3         
        //  216  469:ifnull          584
        //  217  472:iconst_0        
        //  218  473:istore          6
        //  219  475:iconst_0        
        //  220  476:istore          7
        //  221  478:goto            496
        //  222  481:aload_3         
        //  223  482:iload           7
        //  224  484:daload          
        //  225  485:dconst_0        
        //  226  486:dcmpl           
        //  227  487:ifle            493
        //  228  490:iinc            6  1
        //  229  493:iinc            7  1
        //  230  496:iload           7
        //  231  498:aload_3         
        //  232  499:arraylength     
        //  233  500:icmplt          481
        //  234  503:iload           6
        //  235  505:newarray        double[]
        //  236  507:astore          7
        //  237  509:iload           6
        //  238  511:newarray        int[]
        //  239  513:astore          8
        //  240  515:iconst_0        
        //  241  516:istore          9
        //  242  518:iconst_0        
        //  243  519:istore          10
        //  244  521:goto            555
        //  245  524:aload_3         
        //  246  525:iload           10
        //  247  527:daload          
        //  248  528:dconst_0        
        //  249  529:dcmpl           
        //  250  530:ifle            552
        //  251  533:aload           7
        //  252  535:iload           9
        //  253  537:aload_3         
        //  254  538:iload           10
        //  255  540:daload          
        //  256  541:dastore         
        //  257  542:aload           8
        //  258  544:iload           9
        //  259  546:iinc            9  1
        //  260  549:iload           10
        //  261  551:iastore         
        //  262  552:iinc            10  1
        //  263  555:iload           10
        //  264  557:aload_3         
        //  265  558:arraylength     
        //  266  559:icmplt          524
        //  267  562:new             #79  <Class SparseInstance>
        //  268  565:dup             
        //  269  566:dconst_1        
        //  270  567:aload           7
        //  271  569:aload           8
        //  272  571:aload_3         
        //  273  572:arraylength     
        //  274  573:invokespecial   #142 <Method void SparseInstance(double, double[], int[], int)>
        //  275  576:astore          10
        //  276  578:aload_2         
        //  277  579:iload           4
        //  278  581:aload           10
        //  279  583:aastore         
        //  280  584:aload_0         
        //  281  585:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  282  588:getfield        #38  <Field Instances AttributeVisualizationPanel.m_data>
        //  283  591:aload_0         
        //  284  592:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  285  595:getfield        #73  <Field int AttributeVisualizationPanel.m_classIndex>
        //  286  598:invokevirtual   #47  <Method Attribute Instances.attribute(int)>
        //  287  601:invokevirtual   #53  <Method int Attribute.numValues()>
        //  288  604:iconst_1        
        //  289  605:iadd            
        //  290  606:newarray        double[]
        //  291  608:astore_3        
        //  292  609:aload_0         
        //  293  610:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  294  613:getfield        #38  <Field Instances AttributeVisualizationPanel.m_data>
        //  295  616:iload           5
        //  296  618:invokevirtual   #129 <Method Instance Instances.instance(int)>
        //  297  621:aload_0         
        //  298  622:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  299  625:getfield        #41  <Field int AttributeVisualizationPanel.m_attribIndex>
        //  300  628:invokevirtual   #139 <Method double Instance.value(int)>
        //  301  631:d2i             
        //  302  632:istore          4
        //  303  634:aload_0         
        //  304  635:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  305  638:getfield        #38  <Field Instances AttributeVisualizationPanel.m_data>
        //  306  641:iload           5
        //  307  643:invokevirtual   #129 <Method Instance Instances.instance(int)>
        //  308  646:aload_0         
        //  309  647:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  310  650:getfield        #73  <Field int AttributeVisualizationPanel.m_classIndex>
        //  311  653:invokevirtual   #135 <Method boolean Instance.isMissing(int)>
        //  312  656:ifeq            683
        //  313  659:aload_3         
        //  314  660:iconst_0        
        //  315  661:dup2            
        //  316  662:daload          
        //  317  663:aload_0         
        //  318  664:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  319  667:getfield        #38  <Field Instances AttributeVisualizationPanel.m_data>
        //  320  670:iload           5
        //  321  672:invokevirtual   #129 <Method Instance Instances.instance(int)>
        //  322  675:invokevirtual   #146 <Method double Instance.weight()>
        //  323  678:dadd            
        //  324  679:dastore         
        //  325  680:goto            728
        //  326  683:aload_3         
        //  327  684:aload_0         
        //  328  685:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  329  688:getfield        #38  <Field Instances AttributeVisualizationPanel.m_data>
        //  330  691:iload           5
        //  331  693:invokevirtual   #129 <Method Instance Instances.instance(int)>
        //  332  696:aload_0         
        //  333  697:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  334  700:getfield        #73  <Field int AttributeVisualizationPanel.m_classIndex>
        //  335  703:invokevirtual   #139 <Method double Instance.value(int)>
        //  336  706:d2i             
        //  337  707:iconst_1        
        //  338  708:iadd            
        //  339  709:dup2            
        //  340  710:daload          
        //  341  711:aload_0         
        //  342  712:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  343  715:getfield        #38  <Field Instances AttributeVisualizationPanel.m_data>
        //  344  718:iload           5
        //  345  720:invokevirtual   #129 <Method Instance Instances.instance(int)>
        //  346  723:invokevirtual   #146 <Method double Instance.weight()>
        //  347  726:dadd            
        //  348  727:dastore         
        //  349  728:iinc            5  1
        //  350  731:iload           5
        //  351  733:aload_0         
        //  352  734:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  353  737:getfield        #38  <Field Instances AttributeVisualizationPanel.m_data>
        //  354  740:invokevirtual   #149 <Method int Instances.numInstances()>
        //  355  743:icmplt          414
        //  356  746:aload_3         
        //  357  747:ifnull          862
        //  358  750:iconst_0        
        //  359  751:istore          5
        //  360  753:iconst_0        
        //  361  754:istore          6
        //  362  756:goto            774
        //  363  759:aload_3         
        //  364  760:iload           6
        //  365  762:daload          
        //  366  763:dconst_0        
        //  367  764:dcmpl           
        //  368  765:ifle            771
        //  369  768:iinc            5  1
        //  370  771:iinc            6  1
        //  371  774:iload           6
        //  372  776:aload_3         
        //  373  777:arraylength     
        //  374  778:icmplt          759
        //  375  781:iload           5
        //  376  783:newarray        double[]
        //  377  785:astore          6
        //  378  787:iload           5
        //  379  789:newarray        int[]
        //  380  791:astore          7
        //  381  793:iconst_0        
        //  382  794:istore          8
        //  383  796:iconst_0        
        //  384  797:istore          9
        //  385  799:goto            833
        //  386  802:aload_3         
        //  387  803:iload           9
        //  388  805:daload          
        //  389  806:dconst_0        
        //  390  807:dcmpl           
        //  391  808:ifle            830
        //  392  811:aload           6
        //  393  813:iload           8
        //  394  815:aload_3         
        //  395  816:iload           9
        //  396  818:daload          
        //  397  819:dastore         
        //  398  820:aload           7
        //  399  822:iload           8
        //  400  824:iinc            8  1
        //  401  827:iload           9
        //  402  829:iastore         
        //  403  830:iinc            9  1
        //  404  833:iload           9
        //  405  835:aload_3         
        //  406  836:arraylength     
        //  407  837:icmplt          802
        //  408  840:new             #79  <Class SparseInstance>
        //  409  843:dup             
        //  410  844:dconst_1        
        //  411  845:aload           6
        //  412  847:aload           7
        //  413  849:aload_3         
        //  414  850:arraylength     
        //  415  851:invokespecial   #142 <Method void SparseInstance(double, double[], int[], int)>
        //  416  854:astore          9
        //  417  856:aload_2         
        //  418  857:iload           4
        //  419  859:aload           9
        //  420  861:aastore         
        //  421  862:aload_0         
        //  422  863:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  423  866:iconst_0        
        //  424  867:invokestatic    #61  <Method void AttributeVisualizationPanel.access$1(AttributeVisualizationPanel, boolean)>
        //  425  870:aload_0         
        //  426  871:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  427  874:iconst_1        
        //  428  875:invokestatic    #64  <Method void AttributeVisualizationPanel.access$2(AttributeVisualizationPanel, boolean)>
        //  429  878:aload_0         
        //  430  879:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  431  882:iconst_1        
        //  432  883:invokestatic    #67  <Method void AttributeVisualizationPanel.access$3(AttributeVisualizationPanel, boolean)>
        //  433  886:aload_0         
        //  434  887:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  435  890:aload_2         
        //  436  891:putfield        #57  <Field SparseInstance[] AttributeVisualizationPanel.m_histBarClassCounts>
        //  437  894:aload_0         
        //  438  895:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  439  898:invokevirtual   #70  <Method void AttributeVisualizationPanel.repaint()>
        //  440  901:goto            1157
        //  441  904:aload_0         
        //  442  905:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  443  908:getfield        #38  <Field Instances AttributeVisualizationPanel.m_data>
        //  444  911:aload_0         
        //  445  912:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  446  915:getfield        #41  <Field int AttributeVisualizationPanel.m_attribIndex>
        //  447  918:invokevirtual   #47  <Method Attribute Instances.attribute(int)>
        //  448  921:invokevirtual   #53  <Method int Attribute.numValues()>
        //  449  924:newarray        int[]
        //  450  926:astore_2        
        //  451  927:aload_0         
        //  452  928:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  453  931:getfield        #83  <Field AttributeStats AttributeVisualizationPanel.m_as>
        //  454  934:getfield        #89  <Field int[] AttributeStats.nominalCounts>
        //  455  937:arraylength     
        //  456  938:ifle            1036
        //  457  941:aload_0         
        //  458  942:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  459  945:aload_0         
        //  460  946:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  461  949:getfield        #83  <Field AttributeStats AttributeVisualizationPanel.m_as>
        //  462  952:getfield        #89  <Field int[] AttributeStats.nominalCounts>
        //  463  955:iconst_0        
        //  464  956:iaload          
        //  465  957:putfield        #92  <Field int AttributeVisualizationPanel.m_maxValue>
        //  466  960:iconst_0        
        //  467  961:istore_3        
        //  468  962:goto            1009
        //  469  965:aload_0         
        //  470  966:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  471  969:getfield        #83  <Field AttributeStats AttributeVisualizationPanel.m_as>
        //  472  972:getfield        #89  <Field int[] AttributeStats.nominalCounts>
        //  473  975:iload_3         
        //  474  976:iaload          
        //  475  977:aload_0         
        //  476  978:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  477  981:getfield        #92  <Field int AttributeVisualizationPanel.m_maxValue>
        //  478  984:icmple          1006
        //  479  987:aload_0         
        //  480  988:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  481  991:aload_0         
        //  482  992:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  483  995:getfield        #83  <Field AttributeStats AttributeVisualizationPanel.m_as>
        //  484  998:getfield        #89  <Field int[] AttributeStats.nominalCounts>
        //  485 1001:iload_3         
        //  486 1002:iaload          
        //  487 1003:putfield        #92  <Field int AttributeVisualizationPanel.m_maxValue>
        //  488 1006:iinc            3  1
        //  489 1009:iload_3         
        //  490 1010:aload_0         
        //  491 1011:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  492 1014:getfield        #38  <Field Instances AttributeVisualizationPanel.m_data>
        //  493 1017:aload_0         
        //  494 1018:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  495 1021:getfield        #41  <Field int AttributeVisualizationPanel.m_attribIndex>
        //  496 1024:invokevirtual   #47  <Method Attribute Instances.attribute(int)>
        //  497 1027:invokevirtual   #53  <Method int Attribute.numValues()>
        //  498 1030:icmplt          965
        //  499 1033:goto            1044
        //  500 1036:aload_0         
        //  501 1037:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  502 1040:iconst_0        
        //  503 1041:putfield        #92  <Field int AttributeVisualizationPanel.m_maxValue>
        //  504 1044:iconst_0        
        //  505 1045:istore_3        
        //  506 1046:goto            1104
        //  507 1049:aload_0         
        //  508 1050:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  509 1053:getfield        #38  <Field Instances AttributeVisualizationPanel.m_data>
        //  510 1056:iload_3         
        //  511 1057:invokevirtual   #129 <Method Instance Instances.instance(int)>
        //  512 1060:aload_0         
        //  513 1061:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  514 1064:getfield        #41  <Field int AttributeVisualizationPanel.m_attribIndex>
        //  515 1067:invokevirtual   #135 <Method boolean Instance.isMissing(int)>
        //  516 1070:ifne            1101
        //  517 1073:aload_2         
        //  518 1074:aload_0         
        //  519 1075:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  520 1078:getfield        #38  <Field Instances AttributeVisualizationPanel.m_data>
        //  521 1081:iload_3         
        //  522 1082:invokevirtual   #129 <Method Instance Instances.instance(int)>
        //  523 1085:aload_0         
        //  524 1086:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  525 1089:getfield        #41  <Field int AttributeVisualizationPanel.m_attribIndex>
        //  526 1092:invokevirtual   #139 <Method double Instance.value(int)>
        //  527 1095:d2i             
        //  528 1096:dup2            
        //  529 1097:iaload          
        //  530 1098:iconst_1        
        //  531 1099:iadd            
        //  532 1100:iastore         
        //  533 1101:iinc            3  1
        //  534 1104:iload_3         
        //  535 1105:aload_0         
        //  536 1106:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  537 1109:getfield        #38  <Field Instances AttributeVisualizationPanel.m_data>
        //  538 1112:invokevirtual   #149 <Method int Instances.numInstances()>
        //  539 1115:icmplt          1049
        //  540 1118:aload_0         
        //  541 1119:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  542 1122:iconst_0        
        //  543 1123:invokestatic    #61  <Method void AttributeVisualizationPanel.access$1(AttributeVisualizationPanel, boolean)>
        //  544 1126:aload_0         
        //  545 1127:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  546 1130:aload_2         
        //  547 1131:putfield        #152 <Field int[] AttributeVisualizationPanel.m_histBarCounts>
        //  548 1134:aload_0         
        //  549 1135:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  550 1138:iconst_1        
        //  551 1139:invokestatic    #64  <Method void AttributeVisualizationPanel.access$2(AttributeVisualizationPanel, boolean)>
        //  552 1142:aload_0         
        //  553 1143:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  554 1146:iconst_1        
        //  555 1147:invokestatic    #67  <Method void AttributeVisualizationPanel.access$3(AttributeVisualizationPanel, boolean)>
        //  556 1150:aload_0         
        //  557 1151:getfield        #14  <Field AttributeVisualizationPanel this$0>
        //  558 1154:invokevirtual   #70  <Method void AttributeVisualizationPanel.repaint()>
        //  559 1157:aload_1         
        //  560 1158:monitorexit     
        //  561 1159:goto            1165
        //  562 1162:aload_1         
        //  563 1163:monitorexit     
        //  564 1164:athrow          
                return;
            }
            if(m_classIndex >= 0 && m_data.attribute(m_classIndex).isNominal())
            {
                histClassCounts = new SparseInstance[m_data.attribute(m_attribIndex).numValues()];
                if(m_as.nominalCounts.length > 0)
                {
                    m_maxValue = m_as.nominalCounts[0];
                    for(i = 0; i < m_data.attribute(m_attribIndex).numValues(); i++)
                        if(m_as.nominalCounts[i] > m_maxValue)
                            m_maxValue = m_as.nominalCounts[i];

                } else
                {
                    m_maxValue = 0;
                }
                if(m_colorList.size() == 0)
                    m_colorList.addElement(Color.black);
                for(i = m_colorList.size(); i < m_data.attribute(m_classIndex).numValues() + 1; i++)
                {
                    pc = AttributeVisualizationPanel.m_defaultColors[(i - 1) % 10];
                    ija = (i - 1) / 10;
                    ija *= 2;
                    for(j = 0; j < ija; j++)
                        pc = pc.darker();

                    m_colorList.addElement(pc);
                }

                m_data.sort(m_attribIndex);
                tempClassCounts = (double[])null;
                tempAttValueIndex = -1;
                for(k = 0; k < m_data.numInstances(); k++)
                    if(!m_data.instance(k).isMissing(m_attribIndex))
                    {
                        if(m_data.instance(k).value(m_attribIndex) != (double)tempAttValueIndex)
                        {
                            if(tempClassCounts != null)
                            {
                                numNonZero = 0;
                                for(z = 0; z < tempClassCounts.length; z++)
                                    if(tempClassCounts[z] > 0.0D)
                                        numNonZero++;

                                nonZeroVals = new double[numNonZero];
                                nonZeroIndices = new int[numNonZero];
                                count = 0;
                                for(z = 0; z < tempClassCounts.length; z++)
                                    if(tempClassCounts[z] > 0.0D)
                                    {
                                        nonZeroVals[count] = tempClassCounts[z];
                                        nonZeroIndices[count++] = z;
                                    }

                                tempS = new SparseInstance(1.0D, nonZeroVals, nonZeroIndices, tempClassCounts.length);
                                histClassCounts[tempAttValueIndex] = tempS;
                            }
                            tempClassCounts = new double[m_data.attribute(m_classIndex).numValues() + 1];
                            tempAttValueIndex = (int)m_data.instance(k).value(m_attribIndex);
                        }
                        if(m_data.instance(k).isMissing(m_classIndex))
                            tempClassCounts[0] += m_data.instance(k).weight();
                        else
                            tempClassCounts[(int)m_data.instance(k).value(m_classIndex) + 1] += m_data.instance(k).weight();
                    }

                if(tempClassCounts != null)
                {
                    numNonZero = 0;
                    for(z = 0; z < tempClassCounts.length; z++)
                        if(tempClassCounts[z] > 0.0D)
                            numNonZero++;

                    nonZeroVals = new double[numNonZero];
                    nonZeroIndices = new int[numNonZero];
                    count = 0;
                    for(z = 0; z < tempClassCounts.length; z++)
                        if(tempClassCounts[z] > 0.0D)
                        {
                            nonZeroVals[count] = tempClassCounts[z];
                            nonZeroIndices[count++] = z;
                        }

                    tempS = new SparseInstance(1.0D, nonZeroVals, nonZeroIndices, tempClassCounts.length);
                    histClassCounts[tempAttValueIndex] = tempS;
                }
                m_threadRun = false;
                m_doneCurrentAttribute = true;
                m_displayCurrentAttribute = true;
                m_histBarClassCounts = histClassCounts;
                repaint();
            } else
            {
                histCounts = new int[m_data.attribute(m_attribIndex).numValues()];
                if(m_as.nominalCounts.length > 0)
                {
                    m_maxValue = m_as.nominalCounts[0];
                    for(tempClassCounts = 0; tempClassCounts < m_data.attribute(m_attribIndex).numValues(); tempClassCounts++)
                        if(m_as.nominalCounts[tempClassCounts] > m_maxValue)
                            m_maxValue = m_as.nominalCounts[tempClassCounts];

                } else
                {
                    m_maxValue = 0;
                }
                for(k = 0; k < m_data.numInstances(); k++)
                    if(!m_data.instance(k).isMissing(m_attribIndex))
                        histCounts[(int)m_data.instance(k).value(m_attribIndex)]++;

                m_threadRun = false;
                m_histBarCounts = histCounts;
                m_doneCurrentAttribute = true;
                m_displayCurrentAttribute = true;
                repaint();
            }
            integer;
            JVM INSTR monitorexit ;
        //  565 1165:return          
        }

        private int m_panelWidth;
        private int m_panelHeight;
        final AttributeVisualizationPanel this$0;

        public BarCalc(int panelWidth, int panelHeight)
        {
            this$0 = AttributeVisualizationPanel.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #14  <Field AttributeVisualizationPanel this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #17  <Method void Thread()>
            m_panelWidth = panelWidth;
        //    5    9:aload_0         
        //    6   10:iload_2         
        //    7   11:putfield        #19  <Field int m_panelWidth>
            m_panelHeight = panelHeight;
        //    8   14:aload_0         
        //    9   15:iload_3         
        //   10   16:putfield        #21  <Field int m_panelHeight>
        //   11   19:return          
        }
    }

    private class HistCalc extends Thread
    {

        public void run()
        {
            synchronized(m_locker)
        //*   0    0:aload_0         
        //*   1    1:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //*   2    4:invokestatic    #25  <Method Integer AttributeVisualizationPanel.access$0(AttributeVisualizationPanel)>
        //*   3    7:dup             
        //*   4    8:astore_1        
        //*   5    9:monitorenter    
            {
                if(m_classIndex >= 0 && m_data.attribute(m_classIndex).isNominal())
        //*   6   10:aload_0         
        //*   7   11:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //*   8   14:getfield        #29  <Field int AttributeVisualizationPanel.m_classIndex>
        //*   9   17:iflt            1110
        //*  10   20:aload_0         
        //*  11   21:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //*  12   24:getfield        #33  <Field Instances AttributeVisualizationPanel.m_data>
        //*  13   27:aload_0         
        //*  14   28:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //*  15   31:getfield        #29  <Field int AttributeVisualizationPanel.m_classIndex>
        //*  16   34:invokevirtual   #39  <Method Attribute Instances.attribute(int)>
        //*  17   37:invokevirtual   #45  <Method boolean Attribute.isNominal()>
        //*  18   40:ifeq            1110
                {
                    double intervalWidth = 0.0D;
        //   19   43:dconst_0        
        //   20   44:dstore_3        
                    intervalWidth = 3.4900000000000002D * m_as.numericStats.stdDev * Math.pow(m_data.numInstances(), -0.33333333333333331D);
        //   21   45:ldc2w           #46  <Double 3.4900000000000002D>
        //   22   48:aload_0         
        //   23   49:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //   24   52:getfield        #51  <Field AttributeStats AttributeVisualizationPanel.m_as>
        //   25   55:getfield        #57  <Field Stats AttributeStats.numericStats>
        //   26   58:getfield        #63  <Field double Stats.stdDev>
        //   27   61:dmul            
        //   28   62:aload_0         
        //   29   63:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //   30   66:getfield        #33  <Field Instances AttributeVisualizationPanel.m_data>
        //   31   69:invokevirtual   #67  <Method int Instances.numInstances()>
        //   32   72:i2d             
        //   33   73:ldc2w           #68  <Double -0.33333333333333331D>
        //   34   76:invokestatic    #75  <Method double Math.pow(double, double)>
        //   35   79:dmul            
        //   36   80:dstore_3        
                    int intervals = Math.max(1, (int)Math.round((m_as.numericStats.max - m_as.numericStats.min) / intervalWidth));
        //   37   81:iconst_1        
        //   38   82:aload_0         
        //   39   83:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //   40   86:getfield        #51  <Field AttributeStats AttributeVisualizationPanel.m_as>
        //   41   89:getfield        #57  <Field Stats AttributeStats.numericStats>
        //   42   92:getfield        #78  <Field double Stats.max>
        //   43   95:aload_0         
        //   44   96:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //   45   99:getfield        #51  <Field AttributeStats AttributeVisualizationPanel.m_as>
        //   46  102:getfield        #57  <Field Stats AttributeStats.numericStats>
        //   47  105:getfield        #81  <Field double Stats.min>
        //   48  108:dsub            
        //   49  109:dload_3         
        //   50  110:ddiv            
        //   51  111:invokestatic    #85  <Method long Math.round(double)>
        //   52  114:l2i             
        //   53  115:invokestatic    #88  <Method int Math.max(int, int)>
        //   54  118:istore_2        
                    if(intervals > getWidth())
        //*  55  119:iload_2         
        //*  56  120:aload_0         
        //*  57  121:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //*  58  124:invokevirtual   #91  <Method int AttributeVisualizationPanel.getWidth()>
        //*  59  127:icmple          148
                    {
                        intervals = getWidth() - 6;
        //   60  130:aload_0         
        //   61  131:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //   62  134:invokevirtual   #91  <Method int AttributeVisualizationPanel.getWidth()>
        //   63  137:bipush          6
        //   64  139:isub            
        //   65  140:istore_2        
                        if(intervals < 1)
        //*  66  141:iload_2         
        //*  67  142:iconst_1        
        //*  68  143:icmpge          148
                            intervals = 1;
        //   69  146:iconst_1        
        //   70  147:istore_2        
                    }
                    int histClassCounts[][] = new int[intervals][m_data.attribute(m_classIndex).numValues() + 1];
        //   71  148:iload_2         
        //   72  149:aload_0         
        //   73  150:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //   74  153:getfield        #33  <Field Instances AttributeVisualizationPanel.m_data>
        //   75  156:aload_0         
        //   76  157:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //   77  160:getfield        #29  <Field int AttributeVisualizationPanel.m_classIndex>
        //   78  163:invokevirtual   #39  <Method Attribute Instances.attribute(int)>
        //   79  166:invokevirtual   #94  <Method int Attribute.numValues()>
        //   80  169:iconst_1        
        //   81  170:iadd            
        //   82  171:multianewarray  int[][]
        //   83  175:astore          5
                    double barRange = (m_as.numericStats.max - m_as.numericStats.min) / (double)histClassCounts.length;
        //   84  177:aload_0         
        //   85  178:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //   86  181:getfield        #51  <Field AttributeStats AttributeVisualizationPanel.m_as>
        //   87  184:getfield        #57  <Field Stats AttributeStats.numericStats>
        //   88  187:getfield        #78  <Field double Stats.max>
        //   89  190:aload_0         
        //   90  191:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //   91  194:getfield        #51  <Field AttributeStats AttributeVisualizationPanel.m_as>
        //   92  197:getfield        #57  <Field Stats AttributeStats.numericStats>
        //   93  200:getfield        #81  <Field double Stats.min>
        //   94  203:dsub            
        //   95  204:aload           5
        //   96  206:arraylength     
        //   97  207:i2d             
        //   98  208:ddiv            
        //   99  209:dstore          6
                    m_maxValue = 0;
        //  100  211:aload_0         
        //  101  212:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  102  215:iconst_0        
        //  103  216:putfield        #99  <Field int AttributeVisualizationPanel.m_maxValue>
                    if(m_colorList.size() == 0)
        //* 104  219:aload_0         
        //* 105  220:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //* 106  223:invokestatic    #103 <Method FastVector AttributeVisualizationPanel.access$4(AttributeVisualizationPanel)>
        //* 107  226:invokevirtual   #108 <Method int FastVector.size()>
        //* 108  229:ifne            245
                        m_colorList.addElement(Color.black);
        //  109  232:aload_0         
        //  110  233:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  111  236:invokestatic    #103 <Method FastVector AttributeVisualizationPanel.access$4(AttributeVisualizationPanel)>
        //  112  239:getstatic       #114 <Field Color Color.black>
        //  113  242:invokevirtual   #118 <Method void FastVector.addElement(Object)>
                    for(int i = m_colorList.size(); i < m_data.attribute(m_classIndex).numValues() + 1; i++)
        //* 114  245:aload_0         
        //* 115  246:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //* 116  249:invokestatic    #103 <Method FastVector AttributeVisualizationPanel.access$4(AttributeVisualizationPanel)>
        //* 117  252:invokevirtual   #108 <Method int FastVector.size()>
        //* 118  255:istore          8
        //* 119  257:goto            326
                    {
                        Color pc = AttributeVisualizationPanel.m_defaultColors[(i - 1) % 10];
        //  120  260:invokestatic    #122 <Method Color[] AttributeVisualizationPanel.access$5()>
        //  121  263:iload           8
        //  122  265:iconst_1        
        //  123  266:isub            
        //  124  267:bipush          10
        //  125  269:irem            
        //  126  270:aaload          
        //  127  271:astore          9
                        int ija = (i - 1) / 10;
        //  128  273:iload           8
        //  129  275:iconst_1        
        //  130  276:isub            
        //  131  277:bipush          10
        //  132  279:idiv            
        //  133  280:istore          10
                        ija *= 2;
        //  134  282:iload           10
        //  135  284:iconst_2        
        //  136  285:imul            
        //  137  286:istore          10
                        for(int j = 0; j < ija; j++)
        //* 138  288:iconst_0        
        //* 139  289:istore          11
        //* 140  291:goto            304
                            pc = pc.darker();
        //  141  294:aload           9
        //  142  296:invokevirtual   #126 <Method Color Color.darker()>
        //  143  299:astore          9

        //  144  301:iinc            11  1
        //  145  304:iload           11
        //  146  306:iload           10
        //  147  308:icmplt          294
                        m_colorList.addElement(pc);
        //  148  311:aload_0         
        //  149  312:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  150  315:invokestatic    #103 <Method FastVector AttributeVisualizationPanel.access$4(AttributeVisualizationPanel)>
        //  151  318:aload           9
        //  152  320:invokevirtual   #118 <Method void FastVector.addElement(Object)>
                    }

        //  153  323:iinc            8  1
        //  154  326:iload           8
        //  155  328:aload_0         
        //  156  329:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  157  332:getfield        #33  <Field Instances AttributeVisualizationPanel.m_data>
        //  158  335:aload_0         
        //  159  336:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  160  339:getfield        #29  <Field int AttributeVisualizationPanel.m_classIndex>
        //  161  342:invokevirtual   #39  <Method Attribute Instances.attribute(int)>
        //  162  345:invokevirtual   #94  <Method int Attribute.numValues()>
        //  163  348:iconst_1        
        //  164  349:iadd            
        //  165  350:icmplt          260
                    for(int k = 0; k < m_data.numInstances(); k++)
        //* 166  353:iconst_0        
        //* 167  354:istore          8
        //* 168  356:goto            841
                    {
                        int t = 0;
        //  169  359:iconst_0        
        //  170  360:istore          9
                        try
                        {
                            if(!m_data.instance(k).isMissing(m_attribIndex))
        //* 171  362:aload_0         
        //* 172  363:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //* 173  366:getfield        #33  <Field Instances AttributeVisualizationPanel.m_data>
        //* 174  369:iload           8
        //* 175  371:invokevirtual   #130 <Method Instance Instances.instance(int)>
        //* 176  374:aload_0         
        //* 177  375:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //* 178  378:getfield        #133 <Field int AttributeVisualizationPanel.m_attribIndex>
        //* 179  381:invokevirtual   #139 <Method boolean Instance.isMissing(int)>
        //* 180  384:ifne            838
                            {
                                t = (int)Math.ceil((float)((m_data.instance(k).value(m_attribIndex) - m_as.numericStats.min) / barRange));
        //  181  387:aload_0         
        //  182  388:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  183  391:getfield        #33  <Field Instances AttributeVisualizationPanel.m_data>
        //  184  394:iload           8
        //  185  396:invokevirtual   #130 <Method Instance Instances.instance(int)>
        //  186  399:aload_0         
        //  187  400:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  188  403:getfield        #133 <Field int AttributeVisualizationPanel.m_attribIndex>
        //  189  406:invokevirtual   #143 <Method double Instance.value(int)>
        //  190  409:aload_0         
        //  191  410:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  192  413:getfield        #51  <Field AttributeStats AttributeVisualizationPanel.m_as>
        //  193  416:getfield        #57  <Field Stats AttributeStats.numericStats>
        //  194  419:getfield        #81  <Field double Stats.min>
        //  195  422:dsub            
        //  196  423:dload           6
        //  197  425:ddiv            
        //  198  426:d2f             
        //  199  427:f2d             
        //  200  428:invokestatic    #147 <Method double Math.ceil(double)>
        //  201  431:d2i             
        //  202  432:istore          9
                                if(t == 0)
        //* 203  434:iload           9
        //* 204  436:ifne            516
                                {
                                    if(m_data.instance(k).isMissing(m_classIndex))
        //* 205  439:aload_0         
        //* 206  440:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //* 207  443:getfield        #33  <Field Instances AttributeVisualizationPanel.m_data>
        //* 208  446:iload           8
        //* 209  448:invokevirtual   #130 <Method Instance Instances.instance(int)>
        //* 210  451:aload_0         
        //* 211  452:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //* 212  455:getfield        #29  <Field int AttributeVisualizationPanel.m_classIndex>
        //* 213  458:invokevirtual   #139 <Method boolean Instance.isMissing(int)>
        //* 214  461:ifeq            478
                                        histClassCounts[t][0]++;
        //  215  464:aload           5
        //  216  466:iload           9
        //  217  468:aaload          
        //  218  469:iconst_0        
        //  219  470:dup2            
        //  220  471:iaload          
        //  221  472:iconst_1        
        //  222  473:iadd            
        //  223  474:iastore         
                                    else
        //* 224  475:goto            838
                                        histClassCounts[t][(int)m_data.instance(k).value(m_classIndex) + 1]++;
        //  225  478:aload           5
        //  226  480:iload           9
        //  227  482:aaload          
        //  228  483:aload_0         
        //  229  484:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  230  487:getfield        #33  <Field Instances AttributeVisualizationPanel.m_data>
        //  231  490:iload           8
        //  232  492:invokevirtual   #130 <Method Instance Instances.instance(int)>
        //  233  495:aload_0         
        //  234  496:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  235  499:getfield        #29  <Field int AttributeVisualizationPanel.m_classIndex>
        //  236  502:invokevirtual   #143 <Method double Instance.value(int)>
        //  237  505:d2i             
        //  238  506:iconst_1        
        //  239  507:iadd            
        //  240  508:dup2            
        //  241  509:iaload          
        //  242  510:iconst_1        
        //  243  511:iadd            
        //  244  512:iastore         
                                } else
        //* 245  513:goto            838
                                if(m_data.instance(k).isMissing(m_classIndex))
        //* 246  516:aload_0         
        //* 247  517:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //* 248  520:getfield        #33  <Field Instances AttributeVisualizationPanel.m_data>
        //* 249  523:iload           8
        //* 250  525:invokevirtual   #130 <Method Instance Instances.instance(int)>
        //* 251  528:aload_0         
        //* 252  529:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //* 253  532:getfield        #29  <Field int AttributeVisualizationPanel.m_classIndex>
        //* 254  535:invokevirtual   #139 <Method boolean Instance.isMissing(int)>
        //* 255  538:ifeq            557
                                    histClassCounts[t - 1][0]++;
        //  256  541:aload           5
        //  257  543:iload           9
        //  258  545:iconst_1        
        //  259  546:isub            
        //  260  547:aaload          
        //  261  548:iconst_0        
        //  262  549:dup2            
        //  263  550:iaload          
        //  264  551:iconst_1        
        //  265  552:iadd            
        //  266  553:iastore         
                                else
        //* 267  554:goto            838
                                    histClassCounts[t - 1][(int)m_data.instance(k).value(m_classIndex) + 1]++;
        //  268  557:aload           5
        //  269  559:iload           9
        //  270  561:iconst_1        
        //  271  562:isub            
        //  272  563:aaload          
        //  273  564:aload_0         
        //  274  565:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  275  568:getfield        #33  <Field Instances AttributeVisualizationPanel.m_data>
        //  276  571:iload           8
        //  277  573:invokevirtual   #130 <Method Instance Instances.instance(int)>
        //  278  576:aload_0         
        //  279  577:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  280  580:getfield        #29  <Field int AttributeVisualizationPanel.m_classIndex>
        //  281  583:invokevirtual   #143 <Method double Instance.value(int)>
        //  282  586:d2i             
        //  283  587:iconst_1        
        //  284  588:iadd            
        //  285  589:dup2            
        //  286  590:iaload          
        //  287  591:iconst_1        
        //  288  592:iadd            
        //  289  593:iastore         
                            }
                        }
        //* 290  594:goto            838
                        catch(ArrayIndexOutOfBoundsException ae)
        //* 291  597:astore          10
                        {
                            System.out.println((new StringBuilder("t:")).append(t).append(" barRange:").append(barRange).append(" histLength:").append(histClassCounts.length).append(" value:").append(m_data.instance(k).value(m_attribIndex)).append(" min:").append(m_as.numericStats.min).append(" sumResult:").append(m_data.instance(k).value(m_attribIndex) - m_as.numericStats.min).append(" divideResult:").append((float)((m_data.instance(k).value(m_attribIndex) - m_as.numericStats.min) / barRange)).append(" finalResult:").append(Math.ceil((float)((m_data.instance(k).value(m_attribIndex) - m_as.numericStats.min) / barRange))).toString());
        //  292  599:getstatic       #153 <Field PrintStream System.out>
        //  293  602:new             #155 <Class StringBuilder>
        //  294  605:dup             
        //  295  606:ldc1            #157 <String "t:">
        //  296  608:invokespecial   #160 <Method void StringBuilder(String)>
        //  297  611:iload           9
        //  298  613:invokevirtual   #164 <Method StringBuilder StringBuilder.append(int)>
        //  299  616:ldc1            #166 <String " barRange:">
        //  300  618:invokevirtual   #169 <Method StringBuilder StringBuilder.append(String)>
        //  301  621:dload           6
        //  302  623:invokevirtual   #172 <Method StringBuilder StringBuilder.append(double)>
        //  303  626:ldc1            #174 <String " histLength:">
        //  304  628:invokevirtual   #169 <Method StringBuilder StringBuilder.append(String)>
        //  305  631:aload           5
        //  306  633:arraylength     
        //  307  634:invokevirtual   #164 <Method StringBuilder StringBuilder.append(int)>
        //  308  637:ldc1            #176 <String " value:">
        //  309  639:invokevirtual   #169 <Method StringBuilder StringBuilder.append(String)>
        //  310  642:aload_0         
        //  311  643:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  312  646:getfield        #33  <Field Instances AttributeVisualizationPanel.m_data>
        //  313  649:iload           8
        //  314  651:invokevirtual   #130 <Method Instance Instances.instance(int)>
        //  315  654:aload_0         
        //  316  655:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  317  658:getfield        #133 <Field int AttributeVisualizationPanel.m_attribIndex>
        //  318  661:invokevirtual   #143 <Method double Instance.value(int)>
        //  319  664:invokevirtual   #172 <Method StringBuilder StringBuilder.append(double)>
        //  320  667:ldc1            #178 <String " min:">
        //  321  669:invokevirtual   #169 <Method StringBuilder StringBuilder.append(String)>
        //  322  672:aload_0         
        //  323  673:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  324  676:getfield        #51  <Field AttributeStats AttributeVisualizationPanel.m_as>
        //  325  679:getfield        #57  <Field Stats AttributeStats.numericStats>
        //  326  682:getfield        #81  <Field double Stats.min>
        //  327  685:invokevirtual   #172 <Method StringBuilder StringBuilder.append(double)>
        //  328  688:ldc1            #180 <String " sumResult:">
        //  329  690:invokevirtual   #169 <Method StringBuilder StringBuilder.append(String)>
        //  330  693:aload_0         
        //  331  694:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  332  697:getfield        #33  <Field Instances AttributeVisualizationPanel.m_data>
        //  333  700:iload           8
        //  334  702:invokevirtual   #130 <Method Instance Instances.instance(int)>
        //  335  705:aload_0         
        //  336  706:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  337  709:getfield        #133 <Field int AttributeVisualizationPanel.m_attribIndex>
        //  338  712:invokevirtual   #143 <Method double Instance.value(int)>
        //  339  715:aload_0         
        //  340  716:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  341  719:getfield        #51  <Field AttributeStats AttributeVisualizationPanel.m_as>
        //  342  722:getfield        #57  <Field Stats AttributeStats.numericStats>
        //  343  725:getfield        #81  <Field double Stats.min>
        //  344  728:dsub            
        //  345  729:invokevirtual   #172 <Method StringBuilder StringBuilder.append(double)>
        //  346  732:ldc1            #182 <String " divideResult:">
        //  347  734:invokevirtual   #169 <Method StringBuilder StringBuilder.append(String)>
        //  348  737:aload_0         
        //  349  738:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  350  741:getfield        #33  <Field Instances AttributeVisualizationPanel.m_data>
        //  351  744:iload           8
        //  352  746:invokevirtual   #130 <Method Instance Instances.instance(int)>
        //  353  749:aload_0         
        //  354  750:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  355  753:getfield        #133 <Field int AttributeVisualizationPanel.m_attribIndex>
        //  356  756:invokevirtual   #143 <Method double Instance.value(int)>
        //  357  759:aload_0         
        //  358  760:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  359  763:getfield        #51  <Field AttributeStats AttributeVisualizationPanel.m_as>
        //  360  766:getfield        #57  <Field Stats AttributeStats.numericStats>
        //  361  769:getfield        #81  <Field double Stats.min>
        //  362  772:dsub            
        //  363  773:dload           6
        //  364  775:ddiv            
        //  365  776:d2f             
        //  366  777:invokevirtual   #185 <Method StringBuilder StringBuilder.append(float)>
        //  367  780:ldc1            #187 <String " finalResult:">
        //  368  782:invokevirtual   #169 <Method StringBuilder StringBuilder.append(String)>
        //  369  785:aload_0         
        //  370  786:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  371  789:getfield        #33  <Field Instances AttributeVisualizationPanel.m_data>
        //  372  792:iload           8
        //  373  794:invokevirtual   #130 <Method Instance Instances.instance(int)>
        //  374  797:aload_0         
        //  375  798:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  376  801:getfield        #133 <Field int AttributeVisualizationPanel.m_attribIndex>
        //  377  804:invokevirtual   #143 <Method double Instance.value(int)>
        //  378  807:aload_0         
        //  379  808:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  380  811:getfield        #51  <Field AttributeStats AttributeVisualizationPanel.m_as>
        //  381  814:getfield        #57  <Field Stats AttributeStats.numericStats>
        //  382  817:getfield        #81  <Field double Stats.min>
        //  383  820:dsub            
        //  384  821:dload           6
        //  385  823:ddiv            
        //  386  824:d2f             
        //  387  825:f2d             
        //  388  826:invokestatic    #147 <Method double Math.ceil(double)>
        //  389  829:invokevirtual   #172 <Method StringBuilder StringBuilder.append(double)>
        //  390  832:invokevirtual   #191 <Method String StringBuilder.toString()>
        //  391  835:invokevirtual   #196 <Method void PrintStream.println(String)>
                        }
                    }

        //  392  838:iinc            8  1
        //  393  841:iload           8
        //  394  843:aload_0         
        //  395  844:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  396  847:getfield        #33  <Field Instances AttributeVisualizationPanel.m_data>
        //  397  850:invokevirtual   #67  <Method int Instances.numInstances()>
        //  398  853:icmplt          359
                    for(int i = 0; i < histClassCounts.length; i++)
        //* 399  856:iconst_0        
        //* 400  857:istore          8
        //* 401  859:goto            922
                    {
                        int sum = 0;
        //  402  862:iconst_0        
        //  403  863:istore          9
                        for(int j = 0; j < histClassCounts[i].length; j++)
        //* 404  865:iconst_0        
        //* 405  866:istore          10
        //* 406  868:goto            887
                            sum += histClassCounts[i][j];
        //  407  871:iload           9
        //  408  873:aload           5
        //  409  875:iload           8
        //  410  877:aaload          
        //  411  878:iload           10
        //  412  880:iaload          
        //  413  881:iadd            
        //  414  882:istore          9

        //  415  884:iinc            10  1
        //  416  887:iload           10
        //  417  889:aload           5
        //  418  891:iload           8
        //  419  893:aaload          
        //  420  894:arraylength     
        //  421  895:icmplt          871
                        if(m_maxValue < sum)
        //* 422  898:aload_0         
        //* 423  899:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //* 424  902:getfield        #99  <Field int AttributeVisualizationPanel.m_maxValue>
        //* 425  905:iload           9
        //* 426  907:icmpge          919
                            m_maxValue = sum;
        //  427  910:aload_0         
        //  428  911:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  429  914:iload           9
        //  430  916:putfield        #99  <Field int AttributeVisualizationPanel.m_maxValue>
                    }

        //  431  919:iinc            8  1
        //  432  922:iload           8
        //  433  924:aload           5
        //  434  926:arraylength     
        //  435  927:icmplt          862
                    SparseInstance histClassCountsSparse[] = new SparseInstance[histClassCounts.length];
        //  436  930:aload           5
        //  437  932:arraylength     
        //  438  933:anewarray       SparseInstance[]
        //  439  936:astore          8
                    for(int i = 0; i < histClassCounts.length; i++)
        //* 440  938:iconst_0        
        //* 441  939:istore          9
        //* 442  941:goto            1081
                    {
                        int numSparseValues = 0;
        //  443  944:iconst_0        
        //  444  945:istore          10
                        for(int j = 0; j < histClassCounts[i].length; j++)
        //* 445  947:iconst_0        
        //* 446  948:istore          11
        //* 447  950:goto            970
                            if(histClassCounts[i][j] > 0)
        //* 448  953:aload           5
        //* 449  955:iload           9
        //* 450  957:aaload          
        //* 451  958:iload           11
        //* 452  960:iaload          
        //* 453  961:ifle            967
                                numSparseValues++;
        //  454  964:iinc            10  1

        //  455  967:iinc            11  1
        //  456  970:iload           11
        //  457  972:aload           5
        //  458  974:iload           9
        //  459  976:aaload          
        //  460  977:arraylength     
        //  461  978:icmplt          953
                        double sparseValues[] = new double[numSparseValues];
        //  462  981:iload           10
        //  463  983:newarray        double[]
        //  464  985:astore          11
                        int sparseIndices[] = new int[numSparseValues];
        //  465  987:iload           10
        //  466  989:newarray        int[]
        //  467  991:astore          12
                        int count = 0;
        //  468  993:iconst_0        
        //  469  994:istore          13
                        for(int j = 0; j < histClassCounts[i].length; j++)
        //* 470  996:iconst_0        
        //* 471  997:istore          14
        //* 472  999:goto            1040
                            if(histClassCounts[i][j] > 0)
        //* 473 1002:aload           5
        //* 474 1004:iload           9
        //* 475 1006:aaload          
        //* 476 1007:iload           14
        //* 477 1009:iaload          
        //* 478 1010:ifle            1037
                            {
                                sparseValues[count] = histClassCounts[i][j];
        //  479 1013:aload           11
        //  480 1015:iload           13
        //  481 1017:aload           5
        //  482 1019:iload           9
        //  483 1021:aaload          
        //  484 1022:iload           14
        //  485 1024:iaload          
        //  486 1025:i2d             
        //  487 1026:dastore         
                                sparseIndices[count++] = j;
        //  488 1027:aload           12
        //  489 1029:iload           13
        //  490 1031:iinc            13  1
        //  491 1034:iload           14
        //  492 1036:iastore         
                            }

        //  493 1037:iinc            14  1
        //  494 1040:iload           14
        //  495 1042:aload           5
        //  496 1044:iload           9
        //  497 1046:aaload          
        //  498 1047:arraylength     
        //  499 1048:icmplt          1002
                        SparseInstance tempS = new SparseInstance(1.0D, sparseValues, sparseIndices, histClassCounts[i].length);
        //  500 1051:new             #198 <Class SparseInstance>
        //  501 1054:dup             
        //  502 1055:dconst_1        
        //  503 1056:aload           11
        //  504 1058:aload           12
        //  505 1060:aload           5
        //  506 1062:iload           9
        //  507 1064:aaload          
        //  508 1065:arraylength     
        //  509 1066:invokespecial   #201 <Method void SparseInstance(double, double[], int[], int)>
        //  510 1069:astore          14
                        histClassCountsSparse[i] = tempS;
        //  511 1071:aload           8
        //  512 1073:iload           9
        //  513 1075:aload           14
        //  514 1077:aastore         
                    }

        //  515 1078:iinc            9  1
        //  516 1081:iload           9
        //  517 1083:aload           5
        //  518 1085:arraylength     
        //  519 1086:icmplt          944
                    m_histBarClassCounts = histClassCountsSparse;
        //  520 1089:aload_0         
        //  521 1090:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  522 1093:aload           8
        //  523 1095:putfield        #205 <Field SparseInstance[] AttributeVisualizationPanel.m_histBarClassCounts>
                    m_barRange = barRange;
        //  524 1098:aload_0         
        //  525 1099:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  526 1102:dload           6
        //  527 1104:putfield        #208 <Field double AttributeVisualizationPanel.m_barRange>
                } else
        //* 528 1107:goto            1715
                {
                    double intervalWidth = 3.4900000000000002D * m_as.numericStats.stdDev * Math.pow(m_data.numInstances(), -0.33333333333333331D);
        //  529 1110:ldc2w           #46  <Double 3.4900000000000002D>
        //  530 1113:aload_0         
        //  531 1114:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  532 1117:getfield        #51  <Field AttributeStats AttributeVisualizationPanel.m_as>
        //  533 1120:getfield        #57  <Field Stats AttributeStats.numericStats>
        //  534 1123:getfield        #63  <Field double Stats.stdDev>
        //  535 1126:dmul            
        //  536 1127:aload_0         
        //  537 1128:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  538 1131:getfield        #33  <Field Instances AttributeVisualizationPanel.m_data>
        //  539 1134:invokevirtual   #67  <Method int Instances.numInstances()>
        //  540 1137:i2d             
        //  541 1138:ldc2w           #68  <Double -0.33333333333333331D>
        //  542 1141:invokestatic    #75  <Method double Math.pow(double, double)>
        //  543 1144:dmul            
        //  544 1145:dstore_3        
                    int intervals = Math.max(1, (int)Math.round((m_as.numericStats.max - m_as.numericStats.min) / intervalWidth));
        //  545 1146:iconst_1        
        //  546 1147:aload_0         
        //  547 1148:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  548 1151:getfield        #51  <Field AttributeStats AttributeVisualizationPanel.m_as>
        //  549 1154:getfield        #57  <Field Stats AttributeStats.numericStats>
        //  550 1157:getfield        #78  <Field double Stats.max>
        //  551 1160:aload_0         
        //  552 1161:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  553 1164:getfield        #51  <Field AttributeStats AttributeVisualizationPanel.m_as>
        //  554 1167:getfield        #57  <Field Stats AttributeStats.numericStats>
        //  555 1170:getfield        #81  <Field double Stats.min>
        //  556 1173:dsub            
        //  557 1174:dload_3         
        //  558 1175:ddiv            
        //  559 1176:invokestatic    #85  <Method long Math.round(double)>
        //  560 1179:l2i             
        //  561 1180:invokestatic    #88  <Method int Math.max(int, int)>
        //  562 1183:istore_2        
                    if(intervals > getWidth())
        //* 563 1184:iload_2         
        //* 564 1185:aload_0         
        //* 565 1186:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //* 566 1189:invokevirtual   #91  <Method int AttributeVisualizationPanel.getWidth()>
        //* 567 1192:icmple          1213
                    {
                        intervals = getWidth() - 6;
        //  568 1195:aload_0         
        //  569 1196:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  570 1199:invokevirtual   #91  <Method int AttributeVisualizationPanel.getWidth()>
        //  571 1202:bipush          6
        //  572 1204:isub            
        //  573 1205:istore_2        
                        if(intervals < 1)
        //* 574 1206:iload_2         
        //* 575 1207:iconst_1        
        //* 576 1208:icmpge          1213
                            intervals = 1;
        //  577 1211:iconst_1        
        //  578 1212:istore_2        
                    }
                    int histCounts[] = new int[intervals];
        //  579 1213:iload_2         
        //  580 1214:newarray        int[]
        //  581 1216:astore          5
                    double barRange = (m_as.numericStats.max - m_as.numericStats.min) / (double)histCounts.length;
        //  582 1218:aload_0         
        //  583 1219:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  584 1222:getfield        #51  <Field AttributeStats AttributeVisualizationPanel.m_as>
        //  585 1225:getfield        #57  <Field Stats AttributeStats.numericStats>
        //  586 1228:getfield        #78  <Field double Stats.max>
        //  587 1231:aload_0         
        //  588 1232:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  589 1235:getfield        #51  <Field AttributeStats AttributeVisualizationPanel.m_as>
        //  590 1238:getfield        #57  <Field Stats AttributeStats.numericStats>
        //  591 1241:getfield        #81  <Field double Stats.min>
        //  592 1244:dsub            
        //  593 1245:aload           5
        //  594 1247:arraylength     
        //  595 1248:i2d             
        //  596 1249:ddiv            
        //  597 1250:dstore          6
                    m_maxValue = 0;
        //  598 1252:aload_0         
        //  599 1253:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  600 1256:iconst_0        
        //  601 1257:putfield        #99  <Field int AttributeVisualizationPanel.m_maxValue>
                    for(int k = 0; k < m_data.numInstances(); k++)
        //* 602 1260:iconst_0        
        //* 603 1261:istore          8
        //* 604 1263:goto            1682
                    {
                        int t = 0;
        //  605 1266:iconst_0        
        //  606 1267:istore          9
                        if(!m_data.instance(k).isMissing(m_attribIndex))
        //* 607 1269:aload_0         
        //* 608 1270:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //* 609 1273:getfield        #33  <Field Instances AttributeVisualizationPanel.m_data>
        //* 610 1276:iload           8
        //* 611 1278:invokevirtual   #130 <Method Instance Instances.instance(int)>
        //* 612 1281:aload_0         
        //* 613 1282:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //* 614 1285:getfield        #133 <Field int AttributeVisualizationPanel.m_attribIndex>
        //* 615 1288:invokevirtual   #139 <Method boolean Instance.isMissing(int)>
        //* 616 1291:ifeq            1297
        //* 617 1294:goto            1679
                            try
                            {
                                t = (int)Math.ceil((float)((m_data.instance(k).value(m_attribIndex) - m_as.numericStats.min) / barRange));
        //  618 1297:aload_0         
        //  619 1298:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  620 1301:getfield        #33  <Field Instances AttributeVisualizationPanel.m_data>
        //  621 1304:iload           8
        //  622 1306:invokevirtual   #130 <Method Instance Instances.instance(int)>
        //  623 1309:aload_0         
        //  624 1310:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  625 1313:getfield        #133 <Field int AttributeVisualizationPanel.m_attribIndex>
        //  626 1316:invokevirtual   #143 <Method double Instance.value(int)>
        //  627 1319:aload_0         
        //  628 1320:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  629 1323:getfield        #51  <Field AttributeStats AttributeVisualizationPanel.m_as>
        //  630 1326:getfield        #57  <Field Stats AttributeStats.numericStats>
        //  631 1329:getfield        #81  <Field double Stats.min>
        //  632 1332:dsub            
        //  633 1333:dload           6
        //  634 1335:ddiv            
        //  635 1336:d2f             
        //  636 1337:f2d             
        //  637 1338:invokestatic    #147 <Method double Math.ceil(double)>
        //  638 1341:d2i             
        //  639 1342:istore          9
                                if(t == 0)
        //* 640 1344:iload           9
        //* 641 1346:ifne            1388
                                {
                                    histCounts[t]++;
        //  642 1349:aload           5
        //  643 1351:iload           9
        //  644 1353:dup2            
        //  645 1354:iaload          
        //  646 1355:iconst_1        
        //  647 1356:iadd            
        //  648 1357:iastore         
                                    if(histCounts[t] > m_maxValue)
        //* 649 1358:aload           5
        //* 650 1360:iload           9
        //* 651 1362:iaload          
        //* 652 1363:aload_0         
        //* 653 1364:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //* 654 1367:getfield        #99  <Field int AttributeVisualizationPanel.m_maxValue>
        //* 655 1370:icmple          1679
                                        m_maxValue = histCounts[t];
        //  656 1373:aload_0         
        //  657 1374:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  658 1377:aload           5
        //  659 1379:iload           9
        //  660 1381:iaload          
        //  661 1382:putfield        #99  <Field int AttributeVisualizationPanel.m_maxValue>
                                } else
        //* 662 1385:goto            1679
                                {
                                    histCounts[t - 1]++;
        //  663 1388:aload           5
        //  664 1390:iload           9
        //  665 1392:iconst_1        
        //  666 1393:isub            
        //  667 1394:dup2            
        //  668 1395:iaload          
        //  669 1396:iconst_1        
        //  670 1397:iadd            
        //  671 1398:iastore         
                                    if(histCounts[t - 1] > m_maxValue)
        //* 672 1399:aload           5
        //* 673 1401:iload           9
        //* 674 1403:iconst_1        
        //* 675 1404:isub            
        //* 676 1405:iaload          
        //* 677 1406:aload_0         
        //* 678 1407:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //* 679 1410:getfield        #99  <Field int AttributeVisualizationPanel.m_maxValue>
        //* 680 1413:icmple          1679
                                        m_maxValue = histCounts[t - 1];
        //  681 1416:aload_0         
        //  682 1417:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  683 1420:aload           5
        //  684 1422:iload           9
        //  685 1424:iconst_1        
        //  686 1425:isub            
        //  687 1426:iaload          
        //  688 1427:putfield        #99  <Field int AttributeVisualizationPanel.m_maxValue>
                                }
                            }
        //* 689 1430:goto            1679
                            catch(ArrayIndexOutOfBoundsException ae)
        //* 690 1433:astore          10
                            {
                                ae.printStackTrace();
        //  691 1435:aload           10
        //  692 1437:invokevirtual   #213 <Method void ArrayIndexOutOfBoundsException.printStackTrace()>
                                System.out.println((new StringBuilder("t:")).append(t).append(" barRange:").append(barRange).append(" histLength:").append(histCounts.length).append(" value:").append(m_data.instance(k).value(m_attribIndex)).append(" min:").append(m_as.numericStats.min).append(" sumResult:").append(m_data.instance(k).value(m_attribIndex) - m_as.numericStats.min).append(" divideResult:").append((float)((m_data.instance(k).value(m_attribIndex) - m_as.numericStats.min) / barRange)).append(" finalResult:").append(Math.ceil((float)((m_data.instance(k).value(m_attribIndex) - m_as.numericStats.min) / barRange))).toString());
        //  693 1440:getstatic       #153 <Field PrintStream System.out>
        //  694 1443:new             #155 <Class StringBuilder>
        //  695 1446:dup             
        //  696 1447:ldc1            #157 <String "t:">
        //  697 1449:invokespecial   #160 <Method void StringBuilder(String)>
        //  698 1452:iload           9
        //  699 1454:invokevirtual   #164 <Method StringBuilder StringBuilder.append(int)>
        //  700 1457:ldc1            #166 <String " barRange:">
        //  701 1459:invokevirtual   #169 <Method StringBuilder StringBuilder.append(String)>
        //  702 1462:dload           6
        //  703 1464:invokevirtual   #172 <Method StringBuilder StringBuilder.append(double)>
        //  704 1467:ldc1            #174 <String " histLength:">
        //  705 1469:invokevirtual   #169 <Method StringBuilder StringBuilder.append(String)>
        //  706 1472:aload           5
        //  707 1474:arraylength     
        //  708 1475:invokevirtual   #164 <Method StringBuilder StringBuilder.append(int)>
        //  709 1478:ldc1            #176 <String " value:">
        //  710 1480:invokevirtual   #169 <Method StringBuilder StringBuilder.append(String)>
        //  711 1483:aload_0         
        //  712 1484:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  713 1487:getfield        #33  <Field Instances AttributeVisualizationPanel.m_data>
        //  714 1490:iload           8
        //  715 1492:invokevirtual   #130 <Method Instance Instances.instance(int)>
        //  716 1495:aload_0         
        //  717 1496:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  718 1499:getfield        #133 <Field int AttributeVisualizationPanel.m_attribIndex>
        //  719 1502:invokevirtual   #143 <Method double Instance.value(int)>
        //  720 1505:invokevirtual   #172 <Method StringBuilder StringBuilder.append(double)>
        //  721 1508:ldc1            #178 <String " min:">
        //  722 1510:invokevirtual   #169 <Method StringBuilder StringBuilder.append(String)>
        //  723 1513:aload_0         
        //  724 1514:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  725 1517:getfield        #51  <Field AttributeStats AttributeVisualizationPanel.m_as>
        //  726 1520:getfield        #57  <Field Stats AttributeStats.numericStats>
        //  727 1523:getfield        #81  <Field double Stats.min>
        //  728 1526:invokevirtual   #172 <Method StringBuilder StringBuilder.append(double)>
        //  729 1529:ldc1            #180 <String " sumResult:">
        //  730 1531:invokevirtual   #169 <Method StringBuilder StringBuilder.append(String)>
        //  731 1534:aload_0         
        //  732 1535:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  733 1538:getfield        #33  <Field Instances AttributeVisualizationPanel.m_data>
        //  734 1541:iload           8
        //  735 1543:invokevirtual   #130 <Method Instance Instances.instance(int)>
        //  736 1546:aload_0         
        //  737 1547:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  738 1550:getfield        #133 <Field int AttributeVisualizationPanel.m_attribIndex>
        //  739 1553:invokevirtual   #143 <Method double Instance.value(int)>
        //  740 1556:aload_0         
        //  741 1557:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  742 1560:getfield        #51  <Field AttributeStats AttributeVisualizationPanel.m_as>
        //  743 1563:getfield        #57  <Field Stats AttributeStats.numericStats>
        //  744 1566:getfield        #81  <Field double Stats.min>
        //  745 1569:dsub            
        //  746 1570:invokevirtual   #172 <Method StringBuilder StringBuilder.append(double)>
        //  747 1573:ldc1            #182 <String " divideResult:">
        //  748 1575:invokevirtual   #169 <Method StringBuilder StringBuilder.append(String)>
        //  749 1578:aload_0         
        //  750 1579:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  751 1582:getfield        #33  <Field Instances AttributeVisualizationPanel.m_data>
        //  752 1585:iload           8
        //  753 1587:invokevirtual   #130 <Method Instance Instances.instance(int)>
        //  754 1590:aload_0         
        //  755 1591:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  756 1594:getfield        #133 <Field int AttributeVisualizationPanel.m_attribIndex>
        //  757 1597:invokevirtual   #143 <Method double Instance.value(int)>
        //  758 1600:aload_0         
        //  759 1601:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  760 1604:getfield        #51  <Field AttributeStats AttributeVisualizationPanel.m_as>
        //  761 1607:getfield        #57  <Field Stats AttributeStats.numericStats>
        //  762 1610:getfield        #81  <Field double Stats.min>
        //  763 1613:dsub            
        //  764 1614:dload           6
        //  765 1616:ddiv            
        //  766 1617:d2f             
        //  767 1618:invokevirtual   #185 <Method StringBuilder StringBuilder.append(float)>
        //  768 1621:ldc1            #187 <String " finalResult:">
        //  769 1623:invokevirtual   #169 <Method StringBuilder StringBuilder.append(String)>
        //  770 1626:aload_0         
        //  771 1627:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  772 1630:getfield        #33  <Field Instances AttributeVisualizationPanel.m_data>
        //  773 1633:iload           8
        //  774 1635:invokevirtual   #130 <Method Instance Instances.instance(int)>
        //  775 1638:aload_0         
        //  776 1639:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  777 1642:getfield        #133 <Field int AttributeVisualizationPanel.m_attribIndex>
        //  778 1645:invokevirtual   #143 <Method double Instance.value(int)>
        //  779 1648:aload_0         
        //  780 1649:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  781 1652:getfield        #51  <Field AttributeStats AttributeVisualizationPanel.m_as>
        //  782 1655:getfield        #57  <Field Stats AttributeStats.numericStats>
        //  783 1658:getfield        #81  <Field double Stats.min>
        //  784 1661:dsub            
        //  785 1662:dload           6
        //  786 1664:ddiv            
        //  787 1665:d2f             
        //  788 1666:f2d             
        //  789 1667:invokestatic    #147 <Method double Math.ceil(double)>
        //  790 1670:invokevirtual   #172 <Method StringBuilder StringBuilder.append(double)>
        //  791 1673:invokevirtual   #191 <Method String StringBuilder.toString()>
        //  792 1676:invokevirtual   #196 <Method void PrintStream.println(String)>
                            }
                    }

        //  793 1679:iinc            8  1
        //  794 1682:iload           8
        //  795 1684:aload_0         
        //  796 1685:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  797 1688:getfield        #33  <Field Instances AttributeVisualizationPanel.m_data>
        //  798 1691:invokevirtual   #67  <Method int Instances.numInstances()>
        //  799 1694:icmplt          1266
                    m_histBarCounts = histCounts;
        //  800 1697:aload_0         
        //  801 1698:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  802 1701:aload           5
        //  803 1703:putfield        #217 <Field int[] AttributeVisualizationPanel.m_histBarCounts>
                    m_barRange = barRange;
        //  804 1706:aload_0         
        //  805 1707:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  806 1710:dload           6
        //  807 1712:putfield        #208 <Field double AttributeVisualizationPanel.m_barRange>
                }
                m_threadRun = false;
        //  808 1715:aload_0         
        //  809 1716:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  810 1719:iconst_0        
        //  811 1720:invokestatic    #221 <Method void AttributeVisualizationPanel.access$1(AttributeVisualizationPanel, boolean)>
                m_displayCurrentAttribute = true;
        //  812 1723:aload_0         
        //  813 1724:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  814 1727:iconst_1        
        //  815 1728:invokestatic    #224 <Method void AttributeVisualizationPanel.access$3(AttributeVisualizationPanel, boolean)>
                m_doneCurrentAttribute = true;
        //  816 1731:aload_0         
        //  817 1732:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  818 1735:iconst_1        
        //  819 1736:invokestatic    #227 <Method void AttributeVisualizationPanel.access$2(AttributeVisualizationPanel, boolean)>
                repaint();
        //  820 1739:aload_0         
        //  821 1740:getfield        #11  <Field AttributeVisualizationPanel this$0>
        //  822 1743:invokevirtual   #230 <Method void AttributeVisualizationPanel.repaint()>
            }
        //  823 1746:aload_1         
        //  824 1747:monitorexit     
        //  825 1748:goto            1754
        //  826 1751:aload_1         
        //  827 1752:monitorexit     
        //  828 1753:athrow          
        //  829 1754:return          
        }

        final AttributeVisualizationPanel this$0;

        HistCalc()
        {
            this$0 = AttributeVisualizationPanel.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #11  <Field AttributeVisualizationPanel this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #14  <Method void Thread()>
        //    5    9:return          
        }
    }


    public AttributeVisualizationPanel()
    {
        this(false);
    //    0    0:aload_0         
    //    1    1:iconst_0        
    //    2    2:invokespecial   #69  <Method void AttributeVisualizationPanel(boolean)>
    //    3    5:return          
    }

    public AttributeVisualizationPanel(boolean showColouringOption)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #73  <Method void PrintablePanel()>
        m_threadRun = false;
    //    2    4:aload_0         
    //    3    5:iconst_0        
    //    4    6:putfield        #75  <Field boolean m_threadRun>
        m_doneCurrentAttribute = false;
    //    5    9:aload_0         
    //    6   10:iconst_0        
    //    7   11:putfield        #77  <Field boolean m_doneCurrentAttribute>
        m_displayCurrentAttribute = false;
    //    8   14:aload_0         
    //    9   15:iconst_0        
    //   10   16:putfield        #79  <Field boolean m_displayCurrentAttribute>
        m_locker = new Integer(1);
    //   11   19:aload_0         
    //   12   20:new             #81  <Class Integer>
    //   13   23:dup             
    //   14   24:iconst_1        
    //   15   25:invokespecial   #84  <Method void Integer(int)>
    //   16   28:putfield        #86  <Field Integer m_locker>
        m_colorList = new FastVector();
    //   17   31:aload_0         
    //   18   32:new             #88  <Class FastVector>
    //   19   35:dup             
    //   20   36:invokespecial   #89  <Method void FastVector()>
    //   21   39:putfield        #91  <Field FastVector m_colorList>
        setFont(new Font("Default", 0, 9));
    //   22   42:aload_0         
    //   23   43:new             #93  <Class Font>
    //   24   46:dup             
    //   25   47:ldc1            #95  <String "Default">
    //   26   49:iconst_0        
    //   27   50:bipush          9
    //   28   52:invokespecial   #98  <Method void Font(String, int, int)>
    //   29   55:invokevirtual   #102 <Method void setFont(Font)>
        m_fm = getFontMetrics(getFont());
    //   30   58:aload_0         
    //   31   59:aload_0         
    //   32   60:aload_0         
    //   33   61:invokevirtual   #106 <Method Font getFont()>
    //   34   64:invokevirtual   #110 <Method FontMetrics getFontMetrics(Font)>
    //   35   67:putfield        #112 <Field FontMetrics m_fm>
        setToolTipText("");
    //   36   70:aload_0         
    //   37   71:ldc1            #114 <String "">
    //   38   73:invokevirtual   #118 <Method void setToolTipText(String)>
        FlowLayout fl = new FlowLayout(0);
    //   39   76:new             #120 <Class FlowLayout>
    //   40   79:dup             
    //   41   80:iconst_0        
    //   42   81:invokespecial   #121 <Method void FlowLayout(int)>
    //   43   84:astore_2        
        setLayout(fl);
    //   44   85:aload_0         
    //   45   86:aload_2         
    //   46   87:invokevirtual   #125 <Method void setLayout(java.awt.LayoutManager)>
        addComponentListener(new ComponentAdapter() {

            public void componentResized(ComponentEvent ce)
            {
                Instances _tmp = m_data;
            //    0    0:aload_0         
            //    1    1:getfield        #11  <Field AttributeVisualizationPanel this$0>
            //    2    4:getfield        #26  <Field Instances AttributeVisualizationPanel.m_data>
            //    3    7:pop             
            //    4    8:return          
            }

            final AttributeVisualizationPanel this$0;

            
            {
                this$0 = AttributeVisualizationPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #11  <Field AttributeVisualizationPanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #14  <Method void ComponentAdapter()>
            //    5    9:return          
            }
        }
);
    //   47   90:aload_0         
    //   48   91:new             #127 <Class AttributeVisualizationPanel$1>
    //   49   94:dup             
    //   50   95:aload_0         
    //   51   96:invokespecial   #130 <Method void AttributeVisualizationPanel$1(AttributeVisualizationPanel)>
    //   52   99:invokevirtual   #134 <Method void addComponentListener(java.awt.event.ComponentListener)>
        m_colorAttrib = new JComboBox();
    //   53  102:aload_0         
    //   54  103:new             #136 <Class JComboBox>
    //   55  106:dup             
    //   56  107:invokespecial   #137 <Method void JComboBox()>
    //   57  110:putfield        #139 <Field JComboBox m_colorAttrib>
        m_colorAttrib.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent ie)
            {
                if(ie.getStateChange() == 1)
            //*   0    0:aload_1         
            //*   1    1:invokevirtual   #28  <Method int ItemEvent.getStateChange()>
            //*   2    4:iconst_1        
            //*   3    5:icmpne          51
                {
                    m_classIndex = m_colorAttrib.getSelectedIndex() - 1;
            //    4    8:aload_0         
            //    5    9:getfield        #13  <Field AttributeVisualizationPanel this$0>
            //    6   12:aload_0         
            //    7   13:getfield        #13  <Field AttributeVisualizationPanel this$0>
            //    8   16:getfield        #34  <Field JComboBox AttributeVisualizationPanel.m_colorAttrib>
            //    9   19:invokevirtual   #39  <Method int JComboBox.getSelectedIndex()>
            //   10   22:iconst_1        
            //   11   23:isub            
            //   12   24:putfield        #43  <Field int AttributeVisualizationPanel.m_classIndex>
                    if(m_as != null)
            //*  13   27:aload_0         
            //*  14   28:getfield        #13  <Field AttributeVisualizationPanel this$0>
            //*  15   31:getfield        #47  <Field AttributeStats AttributeVisualizationPanel.m_as>
            //*  16   34:ifnull          51
                        setAttribute(m_attribIndex);
            //   17   37:aload_0         
            //   18   38:getfield        #13  <Field AttributeVisualizationPanel this$0>
            //   19   41:aload_0         
            //   20   42:getfield        #13  <Field AttributeVisualizationPanel this$0>
            //   21   45:getfield        #50  <Field int AttributeVisualizationPanel.m_attribIndex>
            //   22   48:invokevirtual   #54  <Method void AttributeVisualizationPanel.setAttribute(int)>
                }
            //   23   51:return          
            }

            final AttributeVisualizationPanel this$0;

            
            {
                this$0 = AttributeVisualizationPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field AttributeVisualizationPanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //   58  113:aload_0         
    //   59  114:getfield        #139 <Field JComboBox m_colorAttrib>
    //   60  117:new             #141 <Class AttributeVisualizationPanel$2>
    //   61  120:dup             
    //   62  121:aload_0         
    //   63  122:invokespecial   #142 <Method void AttributeVisualizationPanel$2(AttributeVisualizationPanel)>
    //   64  125:invokevirtual   #146 <Method void JComboBox.addItemListener(ItemListener)>
        if(showColouringOption)
    //*  65  128:iload_1         
    //*  66  129:ifeq            145
        {
            add(m_colorAttrib);
    //   67  132:aload_0         
    //   68  133:aload_0         
    //   69  134:getfield        #139 <Field JComboBox m_colorAttrib>
    //   70  137:invokevirtual   #150 <Method java.awt.Component add(java.awt.Component)>
    //   71  140:pop             
            validate();
    //   72  141:aload_0         
    //   73  142:invokevirtual   #153 <Method void validate()>
        }
    //   74  145:return          
    }

    public void setInstances(Instances newins)
    {
        m_attribIndex = 0;
    //    0    0:aload_0         
    //    1    1:iconst_0        
    //    2    2:putfield        #160 <Field int m_attribIndex>
        m_as = null;
    //    3    5:aload_0         
    //    4    6:aconst_null     
    //    5    7:putfield        #162 <Field AttributeStats m_as>
        m_data = new Instances(newins);
    //    6   10:aload_0         
    //    7   11:new             #164 <Class Instances>
    //    8   14:dup             
    //    9   15:aload_1         
    //   10   16:invokespecial   #166 <Method void Instances(Instances)>
    //   11   19:putfield        #168 <Field Instances m_data>
        if(m_colorAttrib != null)
    //*  12   22:aload_0         
    //*  13   23:getfield        #139 <Field JComboBox m_colorAttrib>
    //*  14   26:ifnull          239
        {
            m_colorAttrib.removeAllItems();
    //   15   29:aload_0         
    //   16   30:getfield        #139 <Field JComboBox m_colorAttrib>
    //   17   33:invokevirtual   #171 <Method void JComboBox.removeAllItems()>
            m_colorAttrib.addItem("No class");
    //   18   36:aload_0         
    //   19   37:getfield        #139 <Field JComboBox m_colorAttrib>
    //   20   40:ldc1            #173 <String "No class">
    //   21   42:invokevirtual   #177 <Method void JComboBox.addItem(Object)>
            for(int i = 0; i < m_data.numAttributes(); i++)
    //*  22   45:iconst_0        
    //*  23   46:istore_2        
    //*  24   47:goto            185
            {
                String type = "";
    //   25   50:ldc1            #114 <String "">
    //   26   52:astore_3        
                switch(m_data.attribute(i).type())
    //*  27   53:aload_0         
    //*  28   54:getfield        #168 <Field Instances m_data>
    //*  29   57:iload_2         
    //*  30   58:invokevirtual   #181 <Method Attribute Instances.attribute(int)>
    //*  31   61:invokevirtual   #187 <Method int Attribute.type()>
                {
    //*  32   64:tableswitch     0 4: default 130
    //                   0 106
    //                   1 100
    //                   2 112
    //                   3 118
    //                   4 124
                case 1: // '\001'
                    type = "(Nom) ";
    //   33  100:ldc1            #189 <String "(Nom) ">
    //   34  102:astore_3        
                    break;

    //*  35  103:goto            133
                case 0: // '\0'
                    type = "(Num) ";
    //   36  106:ldc1            #191 <String "(Num) ">
    //   37  108:astore_3        
                    break;

    //*  38  109:goto            133
                case 2: // '\002'
                    type = "(Str) ";
    //   39  112:ldc1            #193 <String "(Str) ">
    //   40  114:astore_3        
                    break;

    //*  41  115:goto            133
                case 3: // '\003'
                    type = "(Dat) ";
    //   42  118:ldc1            #195 <String "(Dat) ">
    //   43  120:astore_3        
                    break;

    //*  44  121:goto            133
                case 4: // '\004'
                    type = "(Rel) ";
    //   45  124:ldc1            #197 <String "(Rel) ">
    //   46  126:astore_3        
                    break;

    //*  47  127:goto            133
                default:
                    type = "(???) ";
    //   48  130:ldc1            #199 <String "(???) ">
    //   49  132:astore_3        
                    break;
                }
                m_colorAttrib.addItem(new String((new StringBuilder("Class: ")).append(m_data.attribute(i).name()).append(" ").append(type).toString()));
    //   50  133:aload_0         
    //   51  134:getfield        #139 <Field JComboBox m_colorAttrib>
    //   52  137:new             #201 <Class String>
    //   53  140:dup             
    //   54  141:new             #203 <Class StringBuilder>
    //   55  144:dup             
    //   56  145:ldc1            #205 <String "Class: ">
    //   57  147:invokespecial   #207 <Method void StringBuilder(String)>
    //   58  150:aload_0         
    //   59  151:getfield        #168 <Field Instances m_data>
    //   60  154:iload_2         
    //   61  155:invokevirtual   #181 <Method Attribute Instances.attribute(int)>
    //   62  158:invokevirtual   #211 <Method String Attribute.name()>
    //   63  161:invokevirtual   #215 <Method StringBuilder StringBuilder.append(String)>
    //   64  164:ldc1            #217 <String " ">
    //   65  166:invokevirtual   #215 <Method StringBuilder StringBuilder.append(String)>
    //   66  169:aload_3         
    //   67  170:invokevirtual   #215 <Method StringBuilder StringBuilder.append(String)>
    //   68  173:invokevirtual   #220 <Method String StringBuilder.toString()>
    //   69  176:invokespecial   #221 <Method void String(String)>
    //   70  179:invokevirtual   #177 <Method void JComboBox.addItem(Object)>
            }

    //   71  182:iinc            2  1
    //   72  185:iload_2         
    //   73  186:aload_0         
    //   74  187:getfield        #168 <Field Instances m_data>
    //   75  190:invokevirtual   #224 <Method int Instances.numAttributes()>
    //   76  193:icmplt          50
            if(m_data.classIndex() >= 0)
    //*  77  196:aload_0         
    //*  78  197:getfield        #168 <Field Instances m_data>
    //*  79  200:invokevirtual   #227 <Method int Instances.classIndex()>
    //*  80  203:iflt            225
                m_colorAttrib.setSelectedIndex(m_data.classIndex() + 1);
    //   81  206:aload_0         
    //   82  207:getfield        #139 <Field JComboBox m_colorAttrib>
    //   83  210:aload_0         
    //   84  211:getfield        #168 <Field Instances m_data>
    //   85  214:invokevirtual   #227 <Method int Instances.classIndex()>
    //   86  217:iconst_1        
    //   87  218:iadd            
    //   88  219:invokevirtual   #230 <Method void JComboBox.setSelectedIndex(int)>
            else
    //*  89  222:goto            239
                m_colorAttrib.setSelectedIndex(m_data.numAttributes());
    //   90  225:aload_0         
    //   91  226:getfield        #139 <Field JComboBox m_colorAttrib>
    //   92  229:aload_0         
    //   93  230:getfield        #168 <Field Instances m_data>
    //   94  233:invokevirtual   #224 <Method int Instances.numAttributes()>
    //   95  236:invokevirtual   #230 <Method void JComboBox.setSelectedIndex(int)>
        }
        if(m_data.classIndex() >= 0)
    //*  96  239:aload_0         
    //*  97  240:getfield        #168 <Field Instances m_data>
    //*  98  243:invokevirtual   #227 <Method int Instances.classIndex()>
    //*  99  246:iflt            263
            m_classIndex = m_data.classIndex();
    //  100  249:aload_0         
    //  101  250:aload_0         
    //  102  251:getfield        #168 <Field Instances m_data>
    //  103  254:invokevirtual   #227 <Method int Instances.classIndex()>
    //  104  257:putfield        #232 <Field int m_classIndex>
        else
    //* 105  260:goto            276
            m_classIndex = m_data.numAttributes() - 1;
    //  106  263:aload_0         
    //  107  264:aload_0         
    //  108  265:getfield        #168 <Field Instances m_data>
    //  109  268:invokevirtual   #224 <Method int Instances.numAttributes()>
    //  110  271:iconst_1        
    //  111  272:isub            
    //  112  273:putfield        #232 <Field int m_classIndex>
    //  113  276:return          
    }

    public JComboBox getColorBox()
    {
        return m_colorAttrib;
    //    0    0:aload_0         
    //    1    1:getfield        #139 <Field JComboBox m_colorAttrib>
    //    2    4:areturn         
    }

    public int getColoringIndex()
    {
        return m_classIndex;
    //    0    0:aload_0         
    //    1    1:getfield        #232 <Field int m_classIndex>
    //    2    4:ireturn         
    }

    public void setColoringIndex(int ci)
    {
        m_classIndex = ci;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #232 <Field int m_classIndex>
        if(m_colorAttrib != null)
    //*   3    5:aload_0         
    //*   4    6:getfield        #139 <Field JComboBox m_colorAttrib>
    //*   5    9:ifnull          25
            m_colorAttrib.setSelectedIndex(ci + 1);
    //    6   12:aload_0         
    //    7   13:getfield        #139 <Field JComboBox m_colorAttrib>
    //    8   16:iload_1         
    //    9   17:iconst_1        
    //   10   18:iadd            
    //   11   19:invokevirtual   #230 <Method void JComboBox.setSelectedIndex(int)>
        else
    //*  12   22:goto            33
            setAttribute(m_attribIndex);
    //   13   25:aload_0         
    //   14   26:aload_0         
    //   15   27:getfield        #160 <Field int m_attribIndex>
    //   16   30:invokevirtual   #242 <Method void setAttribute(int)>
    //   17   33:return          
    }

    public void setAttribute(int index)
    {
        synchronized(m_locker)
    //*   0    0:aload_0         
    //*   1    1:getfield        #86  <Field Integer m_locker>
    //*   2    4:dup             
    //*   3    5:astore_2        
    //*   4    6:monitorenter    
        {
            m_threadRun = false;
    //    5    7:aload_0         
    //    6    8:iconst_0        
    //    7    9:putfield        #75  <Field boolean m_threadRun>
            m_doneCurrentAttribute = false;
    //    8   12:aload_0         
    //    9   13:iconst_0        
    //   10   14:putfield        #77  <Field boolean m_doneCurrentAttribute>
            m_displayCurrentAttribute = true;
    //   11   17:aload_0         
    //   12   18:iconst_1        
    //   13   19:putfield        #79  <Field boolean m_displayCurrentAttribute>
            m_attribIndex = index;
    //   14   22:aload_0         
    //   15   23:iload_1         
    //   16   24:putfield        #160 <Field int m_attribIndex>
            m_as = m_data.attributeStats(m_attribIndex);
    //   17   27:aload_0         
    //   18   28:aload_0         
    //   19   29:getfield        #168 <Field Instances m_data>
    //   20   32:aload_0         
    //   21   33:getfield        #160 <Field int m_attribIndex>
    //   22   36:invokevirtual   #247 <Method AttributeStats Instances.attributeStats(int)>
    //   23   39:putfield        #162 <Field AttributeStats m_as>
        }
    //   24   42:aload_2         
    //   25   43:monitorexit     
    //   26   44:goto            50
    //   27   47:aload_2         
    //   28   48:monitorexit     
    //   29   49:athrow          
        repaint();
    //   30   50:aload_0         
    //   31   51:invokevirtual   #250 <Method void repaint()>
    //   32   54:return          
    }

    public void calcGraph(int panelWidth, int panelHeight)
    {
        synchronized(m_locker)
    //*   0    0:aload_0         
    //*   1    1:getfield        #86  <Field Integer m_locker>
    //*   2    4:dup             
    //*   3    5:astore_3        
    //*   4    6:monitorenter    
        {
            m_threadRun = true;
    //    5    7:aload_0         
    //    6    8:iconst_1        
    //    7    9:putfield        #75  <Field boolean m_threadRun>
            if(m_as.nominalCounts != null)
    //*   8   12:aload_0         
    //*   9   13:getfield        #162 <Field AttributeStats m_as>
    //*  10   16:getfield        #258 <Field int[] AttributeStats.nominalCounts>
    //*  11   19:ifnull          59
            {
                m_hc = new BarCalc(panelWidth, panelHeight);
    //   12   22:aload_0         
    //   13   23:new             #260 <Class AttributeVisualizationPanel$BarCalc>
    //   14   26:dup             
    //   15   27:aload_0         
    //   16   28:iload_1         
    //   17   29:iload_2         
    //   18   30:invokespecial   #263 <Method void AttributeVisualizationPanel$BarCalc(AttributeVisualizationPanel, int, int)>
    //   19   33:putfield        #265 <Field Thread m_hc>
    //*  20   36:aload_0         
    //*  21   37:getfield        #265 <Field Thread m_hc>
                Thread _tmp = m_hc;
    //   22   40:aload_0         
    //   23   41:getfield        #265 <Field Thread m_hc>
    //   24   44:pop             
                m_hc.setPriority(1);
    //   25   45:iconst_1        
    //   26   46:invokevirtual   #270 <Method void Thread.setPriority(int)>
                m_hc.start();
    //   27   49:aload_0         
    //   28   50:getfield        #265 <Field Thread m_hc>
    //   29   53:invokevirtual   #273 <Method void Thread.start()>
            } else
    //*  30   56:goto            128
            if(m_as.numericStats != null)
    //*  31   59:aload_0         
    //*  32   60:getfield        #162 <Field AttributeStats m_as>
    //*  33   63:getfield        #277 <Field Stats AttributeStats.numericStats>
    //*  34   66:ifnull          104
            {
                m_hc = new HistCalc();
    //   35   69:aload_0         
    //   36   70:new             #279 <Class AttributeVisualizationPanel$HistCalc>
    //   37   73:dup             
    //   38   74:aload_0         
    //   39   75:invokespecial   #280 <Method void AttributeVisualizationPanel$HistCalc(AttributeVisualizationPanel)>
    //   40   78:putfield        #265 <Field Thread m_hc>
    //*  41   81:aload_0         
    //*  42   82:getfield        #265 <Field Thread m_hc>
                Thread _tmp1 = m_hc;
    //   43   85:aload_0         
    //   44   86:getfield        #265 <Field Thread m_hc>
    //   45   89:pop             
                m_hc.setPriority(1);
    //   46   90:iconst_1        
    //   47   91:invokevirtual   #270 <Method void Thread.setPriority(int)>
                m_hc.start();
    //   48   94:aload_0         
    //   49   95:getfield        #265 <Field Thread m_hc>
    //   50   98:invokevirtual   #273 <Method void Thread.start()>
            } else
    //*  51  101:goto            128
            {
                m_histBarCounts = null;
    //   52  104:aload_0         
    //   53  105:aconst_null     
    //   54  106:putfield        #282 <Field int[] m_histBarCounts>
                m_histBarClassCounts = null;
    //   55  109:aload_0         
    //   56  110:aconst_null     
    //   57  111:putfield        #284 <Field SparseInstance[] m_histBarClassCounts>
                m_doneCurrentAttribute = true;
    //   58  114:aload_0         
    //   59  115:iconst_1        
    //   60  116:putfield        #77  <Field boolean m_doneCurrentAttribute>
                m_threadRun = false;
    //   61  119:aload_0         
    //   62  120:iconst_0        
    //   63  121:putfield        #75  <Field boolean m_threadRun>
                repaint();
    //   64  124:aload_0         
    //   65  125:invokevirtual   #250 <Method void repaint()>
            }
        }
    //   66  128:aload_3         
    //   67  129:monitorexit     
    //   68  130:goto            136
    //   69  133:aload_3         
    //   70  134:monitorexit     
    //   71  135:athrow          
    //   72  136:return          
    }

    public String getToolTipText(MouseEvent ev)
    {
        if(m_as != null && m_as.nominalCounts != null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #162 <Field AttributeStats m_as>
    //*   2    4:ifnull          426
    //*   3    7:aload_0         
    //*   4    8:getfield        #162 <Field AttributeStats m_as>
    //*   5   11:getfield        #258 <Field int[] AttributeStats.nominalCounts>
    //*   6   14:ifnull          426
        {
            float intervalWidth = (float)getWidth() / (float)m_as.nominalCounts.length;
    //    7   17:aload_0         
    //    8   18:invokevirtual   #291 <Method int getWidth()>
    //    9   21:i2f             
    //   10   22:aload_0         
    //   11   23:getfield        #162 <Field AttributeStats m_as>
    //   12   26:getfield        #258 <Field int[] AttributeStats.nominalCounts>
    //   13   29:arraylength     
    //   14   30:i2f             
    //   15   31:fdiv            
    //   16   32:fstore_2        
            int x = 0;
    //   17   33:iconst_0        
    //   18   34:istore          5
            int y = 0;
    //   19   36:iconst_0        
    //   20   37:istore          6
            int barWidth;
            if(intervalWidth > 5F)
    //*  21   39:fload_2         
    //*  22   40:ldc2            #292 <Float 5F>
    //*  23   43:fcmpl           
    //*  24   44:ifle            62
                barWidth = (int)Math.floor(intervalWidth * 0.8F);
    //   25   47:fload_2         
    //   26   48:ldc2            #293 <Float 0.8F>
    //   27   51:fmul            
    //   28   52:f2d             
    //   29   53:invokestatic    #299 <Method double Math.floor(double)>
    //   30   56:d2i             
    //   31   57:istore          4
            else
    //*  32   59:goto            65
                barWidth = 1;
    //   33   62:iconst_1        
    //   34   63:istore          4
            x += (int)(Math.floor(intervalWidth * 0.1F) >= 1.0D ? Math.floor(intervalWidth * 0.1F) : 1.0D);
    //   35   65:iload           5
    //   36   67:fload_2         
    //   37   68:ldc2            #300 <Float 0.1F>
    //   38   71:fmul            
    //   39   72:f2d             
    //   40   73:invokestatic    #299 <Method double Math.floor(double)>
    //   41   76:dconst_1        
    //   42   77:dcmpg           
    //   43   78:ifge            85
    //   44   81:dconst_1        
    //   45   82:goto            94
    //   46   85:fload_2         
    //   47   86:ldc2            #300 <Float 0.1F>
    //   48   89:fmul            
    //   49   90:f2d             
    //   50   91:invokestatic    #299 <Method double Math.floor(double)>
    //   51   94:d2i             
    //   52   95:iadd            
    //   53   96:istore          5
            if(getWidth() - (m_as.nominalCounts.length * barWidth + (int)(Math.floor(intervalWidth * 0.2F) >= 1.0D ? Math.floor(intervalWidth * 0.2F) : 1.0D) * m_as.nominalCounts.length) > 2)
    //*  54   98:aload_0         
    //*  55   99:invokevirtual   #291 <Method int getWidth()>
    //*  56  102:aload_0         
    //*  57  103:getfield        #162 <Field AttributeStats m_as>
    //*  58  106:getfield        #258 <Field int[] AttributeStats.nominalCounts>
    //*  59  109:arraylength     
    //*  60  110:iload           4
    //*  61  112:imul            
    //*  62  113:fload_2         
    //*  63  114:ldc2            #301 <Float 0.2F>
    //*  64  117:fmul            
    //*  65  118:f2d             
    //*  66  119:invokestatic    #299 <Method double Math.floor(double)>
    //*  67  122:dconst_1        
    //*  68  123:dcmpg           
    //*  69  124:ifge            131
    //*  70  127:dconst_1        
    //*  71  128:goto            140
    //*  72  131:fload_2         
    //*  73  132:ldc2            #301 <Float 0.2F>
    //*  74  135:fmul            
    //*  75  136:f2d             
    //*  76  137:invokestatic    #299 <Method double Math.floor(double)>
    //*  77  140:d2i             
    //*  78  141:aload_0         
    //*  79  142:getfield        #162 <Field AttributeStats m_as>
    //*  80  145:getfield        #258 <Field int[] AttributeStats.nominalCounts>
    //*  81  148:arraylength     
    //*  82  149:imul            
    //*  83  150:iadd            
    //*  84  151:isub            
    //*  85  152:iconst_2        
    //*  86  153:icmple          217
                x += (getWidth() - (m_as.nominalCounts.length * barWidth + (int)(Math.floor(intervalWidth * 0.2F) >= 1.0D ? Math.floor(intervalWidth * 0.2F) : 1.0D) * m_as.nominalCounts.length)) / 2;
    //   87  156:iload           5
    //   88  158:aload_0         
    //   89  159:invokevirtual   #291 <Method int getWidth()>
    //   90  162:aload_0         
    //   91  163:getfield        #162 <Field AttributeStats m_as>
    //   92  166:getfield        #258 <Field int[] AttributeStats.nominalCounts>
    //   93  169:arraylength     
    //   94  170:iload           4
    //   95  172:imul            
    //   96  173:fload_2         
    //   97  174:ldc2            #301 <Float 0.2F>
    //   98  177:fmul            
    //   99  178:f2d             
    //  100  179:invokestatic    #299 <Method double Math.floor(double)>
    //  101  182:dconst_1        
    //  102  183:dcmpg           
    //  103  184:ifge            191
    //  104  187:dconst_1        
    //  105  188:goto            200
    //  106  191:fload_2         
    //  107  192:ldc2            #301 <Float 0.2F>
    //  108  195:fmul            
    //  109  196:f2d             
    //  110  197:invokestatic    #299 <Method double Math.floor(double)>
    //  111  200:d2i             
    //  112  201:aload_0         
    //  113  202:getfield        #162 <Field AttributeStats m_as>
    //  114  205:getfield        #258 <Field int[] AttributeStats.nominalCounts>
    //  115  208:arraylength     
    //  116  209:imul            
    //  117  210:iadd            
    //  118  211:isub            
    //  119  212:iconst_2        
    //  120  213:idiv            
    //  121  214:iadd            
    //  122  215:istore          5
            for(int i = 0; i < m_as.nominalCounts.length; i++)
    //* 123  217:iconst_0        
    //* 124  218:istore          7
    //* 125  220:goto            410
            {
                float heightRatio = ((float)getHeight() - (float)m_fm.getHeight()) / (float)m_maxValue;
    //  126  223:aload_0         
    //  127  224:invokevirtual   #304 <Method int getHeight()>
    //  128  227:i2f             
    //  129  228:aload_0         
    //  130  229:getfield        #112 <Field FontMetrics m_fm>
    //  131  232:invokevirtual   #307 <Method int FontMetrics.getHeight()>
    //  132  235:i2f             
    //  133  236:fsub            
    //  134  237:aload_0         
    //  135  238:getfield        #309 <Field int m_maxValue>
    //  136  241:i2f             
    //  137  242:fdiv            
    //  138  243:fstore_3        
                y = getHeight() - Math.round((float)m_as.nominalCounts[i] * heightRatio);
    //  139  244:aload_0         
    //  140  245:invokevirtual   #304 <Method int getHeight()>
    //  141  248:aload_0         
    //  142  249:getfield        #162 <Field AttributeStats m_as>
    //  143  252:getfield        #258 <Field int[] AttributeStats.nominalCounts>
    //  144  255:iload           7
    //  145  257:iaload          
    //  146  258:i2f             
    //  147  259:fload_3         
    //  148  260:fmul            
    //  149  261:invokestatic    #313 <Method int Math.round(float)>
    //  150  264:isub            
    //  151  265:istore          6
                if(ev.getX() >= x && ev.getX() <= x + barWidth && ev.getY() >= getHeight() - Math.round((float)m_as.nominalCounts[i] * heightRatio))
    //* 152  267:aload_1         
    //* 153  268:invokevirtual   #318 <Method int MouseEvent.getX()>
    //* 154  271:iload           5
    //* 155  273:icmplt          371
    //* 156  276:aload_1         
    //* 157  277:invokevirtual   #318 <Method int MouseEvent.getX()>
    //* 158  280:iload           5
    //* 159  282:iload           4
    //* 160  284:iadd            
    //* 161  285:icmpgt          371
    //* 162  288:aload_1         
    //* 163  289:invokevirtual   #321 <Method int MouseEvent.getY()>
    //* 164  292:aload_0         
    //* 165  293:invokevirtual   #304 <Method int getHeight()>
    //* 166  296:aload_0         
    //* 167  297:getfield        #162 <Field AttributeStats m_as>
    //* 168  300:getfield        #258 <Field int[] AttributeStats.nominalCounts>
    //* 169  303:iload           7
    //* 170  305:iaload          
    //* 171  306:i2f             
    //* 172  307:fload_3         
    //* 173  308:fmul            
    //* 174  309:invokestatic    #313 <Method int Math.round(float)>
    //* 175  312:isub            
    //* 176  313:icmplt          371
                    return (new StringBuilder(String.valueOf(m_data.attribute(m_attribIndex).value(i)))).append(" [").append(m_as.nominalCounts[i]).append("]").toString();
    //  177  316:new             #203 <Class StringBuilder>
    //  178  319:dup             
    //  179  320:aload_0         
    //  180  321:getfield        #168 <Field Instances m_data>
    //  181  324:aload_0         
    //  182  325:getfield        #160 <Field int m_attribIndex>
    //  183  328:invokevirtual   #181 <Method Attribute Instances.attribute(int)>
    //  184  331:iload           7
    //  185  333:invokevirtual   #325 <Method String Attribute.value(int)>
    //  186  336:invokestatic    #329 <Method String String.valueOf(Object)>
    //  187  339:invokespecial   #207 <Method void StringBuilder(String)>
    //  188  342:ldc2            #331 <String " [">
    //  189  345:invokevirtual   #215 <Method StringBuilder StringBuilder.append(String)>
    //  190  348:aload_0         
    //  191  349:getfield        #162 <Field AttributeStats m_as>
    //  192  352:getfield        #258 <Field int[] AttributeStats.nominalCounts>
    //  193  355:iload           7
    //  194  357:iaload          
    //  195  358:invokevirtual   #334 <Method StringBuilder StringBuilder.append(int)>
    //  196  361:ldc2            #336 <String "]">
    //  197  364:invokevirtual   #215 <Method StringBuilder StringBuilder.append(String)>
    //  198  367:invokevirtual   #220 <Method String StringBuilder.toString()>
    //  199  370:areturn         
                x = x + barWidth + (int)(Math.floor(intervalWidth * 0.2F) >= 1.0D ? Math.floor(intervalWidth * 0.2F) : 1.0D);
    //  200  371:iload           5
    //  201  373:iload           4
    //  202  375:iadd            
    //  203  376:fload_2         
    //  204  377:ldc2            #301 <Float 0.2F>
    //  205  380:fmul            
    //  206  381:f2d             
    //  207  382:invokestatic    #299 <Method double Math.floor(double)>
    //  208  385:dconst_1        
    //  209  386:dcmpg           
    //  210  387:ifge            394
    //  211  390:dconst_1        
    //  212  391:goto            403
    //  213  394:fload_2         
    //  214  395:ldc2            #301 <Float 0.2F>
    //  215  398:fmul            
    //  216  399:f2d             
    //  217  400:invokestatic    #299 <Method double Math.floor(double)>
    //  218  403:d2i             
    //  219  404:iadd            
    //  220  405:istore          5
            }

    //  221  407:iinc            7  1
    //  222  410:iload           7
    //  223  412:aload_0         
    //  224  413:getfield        #162 <Field AttributeStats m_as>
    //  225  416:getfield        #258 <Field int[] AttributeStats.nominalCounts>
    //  226  419:arraylength     
    //  227  420:icmplt          223
        } else
    //* 228  423:goto            1221
        if(!m_threadRun && (m_histBarCounts != null || m_histBarClassCounts != null))
    //* 229  426:aload_0         
    //* 230  427:getfield        #75  <Field boolean m_threadRun>
    //* 231  430:ifne            1221
    //* 232  433:aload_0         
    //* 233  434:getfield        #282 <Field int[] m_histBarCounts>
    //* 234  437:ifnonnull       447
    //* 235  440:aload_0         
    //* 236  441:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //* 237  444:ifnull          1221
        {
            int x = 0;
    //  238  447:iconst_0        
    //  239  448:istore          4
            int y = 0;
    //  240  450:iconst_0        
    //  241  451:istore          5
            double bar = m_as.numericStats.min;
    //  242  453:aload_0         
    //  243  454:getfield        #162 <Field AttributeStats m_as>
    //  244  457:getfield        #277 <Field Stats AttributeStats.numericStats>
    //  245  460:getfield        #341 <Field double Stats.min>
    //  246  463:dstore          7
            if(m_classIndex >= 0 && m_data.attribute(m_classIndex).isNominal())
    //* 247  465:aload_0         
    //* 248  466:getfield        #232 <Field int m_classIndex>
    //* 249  469:iflt            891
    //* 250  472:aload_0         
    //* 251  473:getfield        #168 <Field Instances m_data>
    //* 252  476:aload_0         
    //* 253  477:getfield        #232 <Field int m_classIndex>
    //* 254  480:invokevirtual   #181 <Method Attribute Instances.attribute(int)>
    //* 255  483:invokevirtual   #345 <Method boolean Attribute.isNominal()>
    //* 256  486:ifeq            891
            {
                int barWidth = (getWidth() - 6) / m_histBarClassCounts.length >= 1 ? (getWidth() - 6) / m_histBarClassCounts.length : 1;
    //  257  489:aload_0         
    //  258  490:invokevirtual   #291 <Method int getWidth()>
    //  259  493:bipush          6
    //  260  495:isub            
    //  261  496:aload_0         
    //  262  497:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //  263  500:arraylength     
    //  264  501:idiv            
    //  265  502:iconst_1        
    //  266  503:icmpge          510
    //  267  506:iconst_1        
    //  268  507:goto            523
    //  269  510:aload_0         
    //  270  511:invokevirtual   #291 <Method int getWidth()>
    //  271  514:bipush          6
    //  272  516:isub            
    //  273  517:aload_0         
    //  274  518:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //  275  521:arraylength     
    //  276  522:idiv            
    //  277  523:istore          6
                x = 3;
    //  278  525:iconst_3        
    //  279  526:istore          4
                if(getWidth() - (x + m_histBarClassCounts.length * barWidth) > 5)
    //* 280  528:aload_0         
    //* 281  529:invokevirtual   #291 <Method int getWidth()>
    //* 282  532:iload           4
    //* 283  534:aload_0         
    //* 284  535:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //* 285  538:arraylength     
    //* 286  539:iload           6
    //* 287  541:imul            
    //* 288  542:iadd            
    //* 289  543:isub            
    //* 290  544:iconst_5        
    //* 291  545:icmple          571
                    x += (getWidth() - (x + m_histBarClassCounts.length * barWidth)) / 2;
    //  292  548:iload           4
    //  293  550:aload_0         
    //  294  551:invokevirtual   #291 <Method int getWidth()>
    //  295  554:iload           4
    //  296  556:aload_0         
    //  297  557:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //  298  560:arraylength     
    //  299  561:iload           6
    //  300  563:imul            
    //  301  564:iadd            
    //  302  565:isub            
    //  303  566:iconst_2        
    //  304  567:idiv            
    //  305  568:iadd            
    //  306  569:istore          4
                float heightRatio = ((float)getHeight() - (float)m_fm.getHeight()) / (float)m_maxValue;
    //  307  571:aload_0         
    //  308  572:invokevirtual   #304 <Method int getHeight()>
    //  309  575:i2f             
    //  310  576:aload_0         
    //  311  577:getfield        #112 <Field FontMetrics m_fm>
    //  312  580:invokevirtual   #307 <Method int FontMetrics.getHeight()>
    //  313  583:i2f             
    //  314  584:fsub            
    //  315  585:aload_0         
    //  316  586:getfield        #309 <Field int m_maxValue>
    //  317  589:i2f             
    //  318  590:fdiv            
    //  319  591:fstore_2        
                if(ev.getX() - x >= 0)
    //* 320  592:aload_1         
    //* 321  593:invokevirtual   #318 <Method int MouseEvent.getX()>
    //* 322  596:iload           4
    //* 323  598:isub            
    //* 324  599:iflt            1221
                {
                    int temp = (int)((double)(ev.getX() - x) / ((double)barWidth + 1E-010D));
    //  325  602:aload_1         
    //  326  603:invokevirtual   #318 <Method int MouseEvent.getX()>
    //  327  606:iload           4
    //  328  608:isub            
    //  329  609:i2d             
    //  330  610:iload           6
    //  331  612:i2d             
    //  332  613:ldc2w           #346 <Double 1E-010D>
    //  333  616:dadd            
    //  334  617:ddiv            
    //  335  618:d2i             
    //  336  619:istore          9
                    if(temp == 0)
    //* 337  621:iload           9
    //* 338  623:ifne            757
                    {
                        int sum = 0;
    //  339  626:iconst_0        
    //  340  627:istore          10
                        for(int k = 0; k < m_histBarClassCounts[0].numValues(); k++)
    //* 341  629:iconst_0        
    //* 342  630:istore          11
    //* 343  632:goto            656
                            sum = (int)((double)sum + m_histBarClassCounts[0].valueSparse(k));
    //  344  635:iload           10
    //  345  637:i2d             
    //  346  638:aload_0         
    //  347  639:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //  348  642:iconst_0        
    //  349  643:aaload          
    //  350  644:iload           11
    //  351  646:invokevirtual   #353 <Method double SparseInstance.valueSparse(int)>
    //  352  649:dadd            
    //  353  650:d2i             
    //  354  651:istore          10

    //  355  653:iinc            11  1
    //  356  656:iload           11
    //  357  658:aload_0         
    //  358  659:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //  359  662:iconst_0        
    //  360  663:aaload          
    //  361  664:invokevirtual   #356 <Method int SparseInstance.numValues()>
    //  362  667:icmplt          635
                        return (new StringBuilder("<html><center><font face=Dialog size=-1>")).append(sum).append("<br>").append("[").append(Utils.doubleToString(bar + m_barRange * (double)temp, 3)).append(", ").append(Utils.doubleToString(bar + m_barRange * (double)(temp + 1), 3)).append("]").append("</font></center></html>").toString();
    //  363  670:new             #203 <Class StringBuilder>
    //  364  673:dup             
    //  365  674:ldc2            #358 <String "<html><center><font face=Dialog size=-1>">
    //  366  677:invokespecial   #207 <Method void StringBuilder(String)>
    //  367  680:iload           10
    //  368  682:invokevirtual   #334 <Method StringBuilder StringBuilder.append(int)>
    //  369  685:ldc2            #360 <String "<br>">
    //  370  688:invokevirtual   #215 <Method StringBuilder StringBuilder.append(String)>
    //  371  691:ldc2            #362 <String "[">
    //  372  694:invokevirtual   #215 <Method StringBuilder StringBuilder.append(String)>
    //  373  697:dload           7
    //  374  699:aload_0         
    //  375  700:getfield        #364 <Field double m_barRange>
    //  376  703:iload           9
    //  377  705:i2d             
    //  378  706:dmul            
    //  379  707:dadd            
    //  380  708:iconst_3        
    //  381  709:invokestatic    #370 <Method String Utils.doubleToString(double, int)>
    //  382  712:invokevirtual   #215 <Method StringBuilder StringBuilder.append(String)>
    //  383  715:ldc2            #372 <String ", ">
    //  384  718:invokevirtual   #215 <Method StringBuilder StringBuilder.append(String)>
    //  385  721:dload           7
    //  386  723:aload_0         
    //  387  724:getfield        #364 <Field double m_barRange>
    //  388  727:iload           9
    //  389  729:iconst_1        
    //  390  730:iadd            
    //  391  731:i2d             
    //  392  732:dmul            
    //  393  733:dadd            
    //  394  734:iconst_3        
    //  395  735:invokestatic    #370 <Method String Utils.doubleToString(double, int)>
    //  396  738:invokevirtual   #215 <Method StringBuilder StringBuilder.append(String)>
    //  397  741:ldc2            #336 <String "]">
    //  398  744:invokevirtual   #215 <Method StringBuilder StringBuilder.append(String)>
    //  399  747:ldc2            #374 <String "</font></center></html>">
    //  400  750:invokevirtual   #215 <Method StringBuilder StringBuilder.append(String)>
    //  401  753:invokevirtual   #220 <Method String StringBuilder.toString()>
    //  402  756:areturn         
                    }
                    if(temp < m_histBarClassCounts.length)
    //* 403  757:iload           9
    //* 404  759:aload_0         
    //* 405  760:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //* 406  763:arraylength     
    //* 407  764:icmpge          1221
                    {
                        int sum = 0;
    //  408  767:iconst_0        
    //  409  768:istore          10
                        for(int k = 0; k < m_histBarClassCounts[temp].numValues(); k++)
    //* 410  770:iconst_0        
    //* 411  771:istore          11
    //* 412  773:goto            798
                            sum = (int)((double)sum + m_histBarClassCounts[temp].valueSparse(k));
    //  413  776:iload           10
    //  414  778:i2d             
    //  415  779:aload_0         
    //  416  780:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //  417  783:iload           9
    //  418  785:aaload          
    //  419  786:iload           11
    //  420  788:invokevirtual   #353 <Method double SparseInstance.valueSparse(int)>
    //  421  791:dadd            
    //  422  792:d2i             
    //  423  793:istore          10

    //  424  795:iinc            11  1
    //  425  798:iload           11
    //  426  800:aload_0         
    //  427  801:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //  428  804:iload           9
    //  429  806:aaload          
    //  430  807:invokevirtual   #356 <Method int SparseInstance.numValues()>
    //  431  810:icmplt          776
                        return (new StringBuilder("<html><center><font face=Dialog size=-1>")).append(sum).append("<br>(").append(Utils.doubleToString(bar + m_barRange * (double)temp, 3)).append(", ").append(Utils.doubleToString(bar + m_barRange * (double)(temp + 1), 3)).append("]</font></center></html>").toString();
    //  432  813:new             #203 <Class StringBuilder>
    //  433  816:dup             
    //  434  817:ldc2            #358 <String "<html><center><font face=Dialog size=-1>">
    //  435  820:invokespecial   #207 <Method void StringBuilder(String)>
    //  436  823:iload           10
    //  437  825:invokevirtual   #334 <Method StringBuilder StringBuilder.append(int)>
    //  438  828:ldc2            #376 <String "<br>(">
    //  439  831:invokevirtual   #215 <Method StringBuilder StringBuilder.append(String)>
    //  440  834:dload           7
    //  441  836:aload_0         
    //  442  837:getfield        #364 <Field double m_barRange>
    //  443  840:iload           9
    //  444  842:i2d             
    //  445  843:dmul            
    //  446  844:dadd            
    //  447  845:iconst_3        
    //  448  846:invokestatic    #370 <Method String Utils.doubleToString(double, int)>
    //  449  849:invokevirtual   #215 <Method StringBuilder StringBuilder.append(String)>
    //  450  852:ldc2            #372 <String ", ">
    //  451  855:invokevirtual   #215 <Method StringBuilder StringBuilder.append(String)>
    //  452  858:dload           7
    //  453  860:aload_0         
    //  454  861:getfield        #364 <Field double m_barRange>
    //  455  864:iload           9
    //  456  866:iconst_1        
    //  457  867:iadd            
    //  458  868:i2d             
    //  459  869:dmul            
    //  460  870:dadd            
    //  461  871:iconst_3        
    //  462  872:invokestatic    #370 <Method String Utils.doubleToString(double, int)>
    //  463  875:invokevirtual   #215 <Method StringBuilder StringBuilder.append(String)>
    //  464  878:ldc2            #378 <String "]</font></center></html>">
    //  465  881:invokevirtual   #215 <Method StringBuilder StringBuilder.append(String)>
    //  466  884:invokevirtual   #220 <Method String StringBuilder.toString()>
    //  467  887:areturn         
                    }
                }
            } else
    //* 468  888:goto            1221
            {
                int barWidth = (getWidth() - 6) / m_histBarCounts.length >= 1 ? (getWidth() - 6) / m_histBarCounts.length : 1;
    //  469  891:aload_0         
    //  470  892:invokevirtual   #291 <Method int getWidth()>
    //  471  895:bipush          6
    //  472  897:isub            
    //  473  898:aload_0         
    //  474  899:getfield        #282 <Field int[] m_histBarCounts>
    //  475  902:arraylength     
    //  476  903:idiv            
    //  477  904:iconst_1        
    //  478  905:icmpge          912
    //  479  908:iconst_1        
    //  480  909:goto            925
    //  481  912:aload_0         
    //  482  913:invokevirtual   #291 <Method int getWidth()>
    //  483  916:bipush          6
    //  484  918:isub            
    //  485  919:aload_0         
    //  486  920:getfield        #282 <Field int[] m_histBarCounts>
    //  487  923:arraylength     
    //  488  924:idiv            
    //  489  925:istore          6
                x = 3;
    //  490  927:iconst_3        
    //  491  928:istore          4
                if(getWidth() - (x + m_histBarCounts.length * barWidth) > 5)
    //* 492  930:aload_0         
    //* 493  931:invokevirtual   #291 <Method int getWidth()>
    //* 494  934:iload           4
    //* 495  936:aload_0         
    //* 496  937:getfield        #282 <Field int[] m_histBarCounts>
    //* 497  940:arraylength     
    //* 498  941:iload           6
    //* 499  943:imul            
    //* 500  944:iadd            
    //* 501  945:isub            
    //* 502  946:iconst_5        
    //* 503  947:icmple          973
                    x += (getWidth() - (x + m_histBarCounts.length * barWidth)) / 2;
    //  504  950:iload           4
    //  505  952:aload_0         
    //  506  953:invokevirtual   #291 <Method int getWidth()>
    //  507  956:iload           4
    //  508  958:aload_0         
    //  509  959:getfield        #282 <Field int[] m_histBarCounts>
    //  510  962:arraylength     
    //  511  963:iload           6
    //  512  965:imul            
    //  513  966:iadd            
    //  514  967:isub            
    //  515  968:iconst_2        
    //  516  969:idiv            
    //  517  970:iadd            
    //  518  971:istore          4
                float heightRatio = ((float)getHeight() - (float)m_fm.getHeight()) / (float)m_maxValue;
    //  519  973:aload_0         
    //  520  974:invokevirtual   #304 <Method int getHeight()>
    //  521  977:i2f             
    //  522  978:aload_0         
    //  523  979:getfield        #112 <Field FontMetrics m_fm>
    //  524  982:invokevirtual   #307 <Method int FontMetrics.getHeight()>
    //  525  985:i2f             
    //  526  986:fsub            
    //  527  987:aload_0         
    //  528  988:getfield        #309 <Field int m_maxValue>
    //  529  991:i2f             
    //  530  992:fdiv            
    //  531  993:fstore_2        
                if(ev.getX() - x >= 0)
    //* 532  994:aload_1         
    //* 533  995:invokevirtual   #318 <Method int MouseEvent.getX()>
    //* 534  998:iload           4
    //* 535 1000:isub            
    //* 536 1001:iflt            1221
                {
                    int temp = (int)((double)(ev.getX() - x) / ((double)barWidth + 1E-010D));
    //  537 1004:aload_1         
    //  538 1005:invokevirtual   #318 <Method int MouseEvent.getX()>
    //  539 1008:iload           4
    //  540 1010:isub            
    //  541 1011:i2d             
    //  542 1012:iload           6
    //  543 1014:i2d             
    //  544 1015:ldc2w           #346 <Double 1E-010D>
    //  545 1018:dadd            
    //  546 1019:ddiv            
    //  547 1020:d2i             
    //  548 1021:istore          9
                    if(temp == 0)
    //* 549 1023:iload           9
    //* 550 1025:ifne            1119
                        return (new StringBuilder("<html><center><font face=Dialog size=-1>")).append(m_histBarCounts[0]).append("<br>").append("[").append(Utils.doubleToString(bar + m_barRange * (double)temp, 3)).append(", ").append(Utils.doubleToString(bar + m_barRange * (double)(temp + 1), 3)).append("]").append("</font></center></html>").toString();
    //  551 1028:new             #203 <Class StringBuilder>
    //  552 1031:dup             
    //  553 1032:ldc2            #358 <String "<html><center><font face=Dialog size=-1>">
    //  554 1035:invokespecial   #207 <Method void StringBuilder(String)>
    //  555 1038:aload_0         
    //  556 1039:getfield        #282 <Field int[] m_histBarCounts>
    //  557 1042:iconst_0        
    //  558 1043:iaload          
    //  559 1044:invokevirtual   #334 <Method StringBuilder StringBuilder.append(int)>
    //  560 1047:ldc2            #360 <String "<br>">
    //  561 1050:invokevirtual   #215 <Method StringBuilder StringBuilder.append(String)>
    //  562 1053:ldc2            #362 <String "[">
    //  563 1056:invokevirtual   #215 <Method StringBuilder StringBuilder.append(String)>
    //  564 1059:dload           7
    //  565 1061:aload_0         
    //  566 1062:getfield        #364 <Field double m_barRange>
    //  567 1065:iload           9
    //  568 1067:i2d             
    //  569 1068:dmul            
    //  570 1069:dadd            
    //  571 1070:iconst_3        
    //  572 1071:invokestatic    #370 <Method String Utils.doubleToString(double, int)>
    //  573 1074:invokevirtual   #215 <Method StringBuilder StringBuilder.append(String)>
    //  574 1077:ldc2            #372 <String ", ">
    //  575 1080:invokevirtual   #215 <Method StringBuilder StringBuilder.append(String)>
    //  576 1083:dload           7
    //  577 1085:aload_0         
    //  578 1086:getfield        #364 <Field double m_barRange>
    //  579 1089:iload           9
    //  580 1091:iconst_1        
    //  581 1092:iadd            
    //  582 1093:i2d             
    //  583 1094:dmul            
    //  584 1095:dadd            
    //  585 1096:iconst_3        
    //  586 1097:invokestatic    #370 <Method String Utils.doubleToString(double, int)>
    //  587 1100:invokevirtual   #215 <Method StringBuilder StringBuilder.append(String)>
    //  588 1103:ldc2            #336 <String "]">
    //  589 1106:invokevirtual   #215 <Method StringBuilder StringBuilder.append(String)>
    //  590 1109:ldc2            #374 <String "</font></center></html>">
    //  591 1112:invokevirtual   #215 <Method StringBuilder StringBuilder.append(String)>
    //  592 1115:invokevirtual   #220 <Method String StringBuilder.toString()>
    //  593 1118:areturn         
                    if(temp < m_histBarCounts.length)
    //* 594 1119:iload           9
    //* 595 1121:aload_0         
    //* 596 1122:getfield        #282 <Field int[] m_histBarCounts>
    //* 597 1125:arraylength     
    //* 598 1126:icmpge          1221
                        return (new StringBuilder("<html><center><font face=Dialog size=-1>")).append(m_histBarCounts[temp]).append("<br>").append("(").append(Utils.doubleToString(bar + m_barRange * (double)temp, 3)).append(", ").append(Utils.doubleToString(bar + m_barRange * (double)(temp + 1), 3)).append("]").append("</font></center></html>").toString();
    //  599 1129:new             #203 <Class StringBuilder>
    //  600 1132:dup             
    //  601 1133:ldc2            #358 <String "<html><center><font face=Dialog size=-1>">
    //  602 1136:invokespecial   #207 <Method void StringBuilder(String)>
    //  603 1139:aload_0         
    //  604 1140:getfield        #282 <Field int[] m_histBarCounts>
    //  605 1143:iload           9
    //  606 1145:iaload          
    //  607 1146:invokevirtual   #334 <Method StringBuilder StringBuilder.append(int)>
    //  608 1149:ldc2            #360 <String "<br>">
    //  609 1152:invokevirtual   #215 <Method StringBuilder StringBuilder.append(String)>
    //  610 1155:ldc2            #380 <String "(">
    //  611 1158:invokevirtual   #215 <Method StringBuilder StringBuilder.append(String)>
    //  612 1161:dload           7
    //  613 1163:aload_0         
    //  614 1164:getfield        #364 <Field double m_barRange>
    //  615 1167:iload           9
    //  616 1169:i2d             
    //  617 1170:dmul            
    //  618 1171:dadd            
    //  619 1172:iconst_3        
    //  620 1173:invokestatic    #370 <Method String Utils.doubleToString(double, int)>
    //  621 1176:invokevirtual   #215 <Method StringBuilder StringBuilder.append(String)>
    //  622 1179:ldc2            #372 <String ", ">
    //  623 1182:invokevirtual   #215 <Method StringBuilder StringBuilder.append(String)>
    //  624 1185:dload           7
    //  625 1187:aload_0         
    //  626 1188:getfield        #364 <Field double m_barRange>
    //  627 1191:iload           9
    //  628 1193:iconst_1        
    //  629 1194:iadd            
    //  630 1195:i2d             
    //  631 1196:dmul            
    //  632 1197:dadd            
    //  633 1198:iconst_3        
    //  634 1199:invokestatic    #370 <Method String Utils.doubleToString(double, int)>
    //  635 1202:invokevirtual   #215 <Method StringBuilder StringBuilder.append(String)>
    //  636 1205:ldc2            #336 <String "]">
    //  637 1208:invokevirtual   #215 <Method StringBuilder StringBuilder.append(String)>
    //  638 1211:ldc2            #374 <String "</font></center></html>">
    //  639 1214:invokevirtual   #215 <Method StringBuilder StringBuilder.append(String)>
    //  640 1217:invokevirtual   #220 <Method String StringBuilder.toString()>
    //  641 1220:areturn         
                }
            }
        }
        return PrintableComponent.getToolTipText(m_Printer);
    //  642 1221:aload_0         
    //  643 1222:getfield        #384 <Field PrintableComponent m_Printer>
    //  644 1225:invokestatic    #389 <Method String PrintableComponent.getToolTipText(PrintableComponent)>
    //  645 1228:areturn         
    }

    public void paintComponent(Graphics g)
    {
        g.clearRect(0, 0, getWidth(), getHeight());
    //    0    0:aload_1         
    //    1    1:iconst_0        
    //    2    2:iconst_0        
    //    3    3:aload_0         
    //    4    4:invokevirtual   #291 <Method int getWidth()>
    //    5    7:aload_0         
    //    6    8:invokevirtual   #304 <Method int getHeight()>
    //    7   11:invokevirtual   #409 <Method void Graphics.clearRect(int, int, int, int)>
        if(m_as != null)
    //*   8   14:aload_0         
    //*   9   15:getfield        #162 <Field AttributeStats m_as>
    //*  10   18:ifnull          2918
        {
            if(!m_doneCurrentAttribute && !m_threadRun)
    //*  11   21:aload_0         
    //*  12   22:getfield        #77  <Field boolean m_doneCurrentAttribute>
    //*  13   25:ifne            47
    //*  14   28:aload_0         
    //*  15   29:getfield        #75  <Field boolean m_threadRun>
    //*  16   32:ifne            47
                calcGraph(getWidth(), getHeight());
    //   17   35:aload_0         
    //   18   36:aload_0         
    //   19   37:invokevirtual   #291 <Method int getWidth()>
    //   20   40:aload_0         
    //   21   41:invokevirtual   #304 <Method int getHeight()>
    //   22   44:invokevirtual   #411 <Method void calcGraph(int, int)>
            if(!m_threadRun && m_displayCurrentAttribute)
    //*  23   47:aload_0         
    //*  24   48:getfield        #75  <Field boolean m_threadRun>
    //*  25   51:ifne            2789
    //*  26   54:aload_0         
    //*  27   55:getfield        #79  <Field boolean m_displayCurrentAttribute>
    //*  28   58:ifeq            2789
            {
                int buttonHeight = 0;
    //   29   61:iconst_0        
    //   30   62:istore_2        
                if(m_colorAttrib != null)
    //*  31   63:aload_0         
    //*  32   64:getfield        #139 <Field JComboBox m_colorAttrib>
    //*  33   67:ifnull          89
                    buttonHeight = m_colorAttrib.getHeight() + m_colorAttrib.getLocation().y;
    //   34   70:aload_0         
    //   35   71:getfield        #139 <Field JComboBox m_colorAttrib>
    //   36   74:invokevirtual   #412 <Method int JComboBox.getHeight()>
    //   37   77:aload_0         
    //   38   78:getfield        #139 <Field JComboBox m_colorAttrib>
    //   39   81:invokevirtual   #416 <Method Point JComboBox.getLocation()>
    //   40   84:getfield        #420 <Field int Point.y>
    //   41   87:iadd            
    //   42   88:istore_2        
                if(m_as.nominalCounts != null && (m_histBarClassCounts != null || m_histBarCounts != null))
    //*  43   89:aload_0         
    //*  44   90:getfield        #162 <Field AttributeStats m_as>
    //*  45   93:getfield        #258 <Field int[] AttributeStats.nominalCounts>
    //*  46   96:ifnull          950
    //*  47   99:aload_0         
    //*  48  100:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //*  49  103:ifnonnull       113
    //*  50  106:aload_0         
    //*  51  107:getfield        #282 <Field int[] m_histBarCounts>
    //*  52  110:ifnull          950
                {
                    int x = 0;
    //   53  113:iconst_0        
    //   54  114:istore          5
                    int y = 0;
    //   55  116:iconst_0        
    //   56  117:istore          6
                    if(m_classIndex >= 0 && m_data.attribute(m_classIndex).isNominal())
    //*  57  119:aload_0         
    //*  58  120:getfield        #232 <Field int m_classIndex>
    //*  59  123:iflt            591
    //*  60  126:aload_0         
    //*  61  127:getfield        #168 <Field Instances m_data>
    //*  62  130:aload_0         
    //*  63  131:getfield        #232 <Field int m_classIndex>
    //*  64  134:invokevirtual   #181 <Method Attribute Instances.attribute(int)>
    //*  65  137:invokevirtual   #345 <Method boolean Attribute.isNominal()>
    //*  66  140:ifeq            591
                    {
                        float intervalWidth = (float)getWidth() / (float)m_histBarClassCounts.length;
    //   67  143:aload_0         
    //   68  144:invokevirtual   #291 <Method int getWidth()>
    //   69  147:i2f             
    //   70  148:aload_0         
    //   71  149:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //   72  152:arraylength     
    //   73  153:i2f             
    //   74  154:fdiv            
    //   75  155:fstore          4
                        int barWidth;
                        if(intervalWidth > 5F)
    //*  76  157:fload           4
    //*  77  159:ldc2            #292 <Float 5F>
    //*  78  162:fcmpl           
    //*  79  163:ifle            182
                            barWidth = (int)Math.floor(intervalWidth * 0.8F);
    //   80  166:fload           4
    //   81  168:ldc2            #293 <Float 0.8F>
    //   82  171:fmul            
    //   83  172:f2d             
    //   84  173:invokestatic    #299 <Method double Math.floor(double)>
    //   85  176:d2i             
    //   86  177:istore          8
                        else
    //*  87  179:goto            185
                            barWidth = 1;
    //   88  182:iconst_1        
    //   89  183:istore          8
                        x += (int)(Math.floor(intervalWidth * 0.1F) >= 1.0D ? Math.floor(intervalWidth * 0.1F) : 1.0D);
    //   90  185:iload           5
    //   91  187:fload           4
    //   92  189:ldc2            #300 <Float 0.1F>
    //   93  192:fmul            
    //   94  193:f2d             
    //   95  194:invokestatic    #299 <Method double Math.floor(double)>
    //   96  197:dconst_1        
    //   97  198:dcmpg           
    //   98  199:ifge            206
    //   99  202:dconst_1        
    //  100  203:goto            216
    //  101  206:fload           4
    //  102  208:ldc2            #300 <Float 0.1F>
    //  103  211:fmul            
    //  104  212:f2d             
    //  105  213:invokestatic    #299 <Method double Math.floor(double)>
    //  106  216:d2i             
    //  107  217:iadd            
    //  108  218:istore          5
                        if(getWidth() - (m_histBarClassCounts.length * barWidth + (int)(Math.floor(intervalWidth * 0.2F) >= 1.0D ? Math.floor(intervalWidth * 0.2F) : 1.0D) * m_histBarClassCounts.length) > 2)
    //* 109  220:aload_0         
    //* 110  221:invokevirtual   #291 <Method int getWidth()>
    //* 111  224:aload_0         
    //* 112  225:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //* 113  228:arraylength     
    //* 114  229:iload           8
    //* 115  231:imul            
    //* 116  232:fload           4
    //* 117  234:ldc2            #301 <Float 0.2F>
    //* 118  237:fmul            
    //* 119  238:f2d             
    //* 120  239:invokestatic    #299 <Method double Math.floor(double)>
    //* 121  242:dconst_1        
    //* 122  243:dcmpg           
    //* 123  244:ifge            251
    //* 124  247:dconst_1        
    //* 125  248:goto            261
    //* 126  251:fload           4
    //* 127  253:ldc2            #301 <Float 0.2F>
    //* 128  256:fmul            
    //* 129  257:f2d             
    //* 130  258:invokestatic    #299 <Method double Math.floor(double)>
    //* 131  261:d2i             
    //* 132  262:aload_0         
    //* 133  263:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //* 134  266:arraylength     
    //* 135  267:imul            
    //* 136  268:iadd            
    //* 137  269:isub            
    //* 138  270:iconst_2        
    //* 139  271:icmple          331
                            x += (getWidth() - (m_histBarClassCounts.length * barWidth + (int)(Math.floor(intervalWidth * 0.2F) >= 1.0D ? Math.floor(intervalWidth * 0.2F) : 1.0D) * m_histBarClassCounts.length)) / 2;
    //  140  274:iload           5
    //  141  276:aload_0         
    //  142  277:invokevirtual   #291 <Method int getWidth()>
    //  143  280:aload_0         
    //  144  281:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //  145  284:arraylength     
    //  146  285:iload           8
    //  147  287:imul            
    //  148  288:fload           4
    //  149  290:ldc2            #301 <Float 0.2F>
    //  150  293:fmul            
    //  151  294:f2d             
    //  152  295:invokestatic    #299 <Method double Math.floor(double)>
    //  153  298:dconst_1        
    //  154  299:dcmpg           
    //  155  300:ifge            307
    //  156  303:dconst_1        
    //  157  304:goto            317
    //  158  307:fload           4
    //  159  309:ldc2            #301 <Float 0.2F>
    //  160  312:fmul            
    //  161  313:f2d             
    //  162  314:invokestatic    #299 <Method double Math.floor(double)>
    //  163  317:d2i             
    //  164  318:aload_0         
    //  165  319:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //  166  322:arraylength     
    //  167  323:imul            
    //  168  324:iadd            
    //  169  325:isub            
    //  170  326:iconst_2        
    //  171  327:idiv            
    //  172  328:iadd            
    //  173  329:istore          5
                        int sum = 0;
    //  174  331:iconst_0        
    //  175  332:istore          9
                        for(int i = 0; i < m_histBarClassCounts.length; i++)
    //* 176  334:iconst_0        
    //* 177  335:istore          10
    //* 178  337:goto            578
                        {
                            float heightRatio = ((float)getHeight() - (float)m_fm.getHeight() - (float)buttonHeight) / (float)m_maxValue;
    //  179  340:aload_0         
    //  180  341:invokevirtual   #304 <Method int getHeight()>
    //  181  344:i2f             
    //  182  345:aload_0         
    //  183  346:getfield        #112 <Field FontMetrics m_fm>
    //  184  349:invokevirtual   #307 <Method int FontMetrics.getHeight()>
    //  185  352:i2f             
    //  186  353:fsub            
    //  187  354:iload_2         
    //  188  355:i2f             
    //  189  356:fsub            
    //  190  357:aload_0         
    //  191  358:getfield        #309 <Field int m_maxValue>
    //  192  361:i2f             
    //  193  362:fdiv            
    //  194  363:fstore_3        
                            y = getHeight();
    //  195  364:aload_0         
    //  196  365:invokevirtual   #304 <Method int getHeight()>
    //  197  368:istore          6
                            if(m_histBarClassCounts[i] != null)
    //* 198  370:aload_0         
    //* 199  371:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //* 200  374:iload           10
    //* 201  376:aaload          
    //* 202  377:ifnull          500
                            {
                                for(int j = 0; j < m_histBarClassCounts[i].numAttributes(); j++)
    //* 203  380:iconst_0        
    //* 204  381:istore          11
    //* 205  383:goto            485
                                {
                                    sum = (int)((double)sum + m_histBarClassCounts[i].value(j));
    //  206  386:iload           9
    //  207  388:i2d             
    //  208  389:aload_0         
    //  209  390:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //  210  393:iload           10
    //  211  395:aaload          
    //  212  396:iload           11
    //  213  398:invokevirtual   #422 <Method double SparseInstance.value(int)>
    //  214  401:dadd            
    //  215  402:d2i             
    //  216  403:istore          9
                                    y = (int)((long)y - Math.round(m_histBarClassCounts[i].value(j) * (double)heightRatio));
    //  217  405:iload           6
    //  218  407:i2l             
    //  219  408:aload_0         
    //  220  409:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //  221  412:iload           10
    //  222  414:aaload          
    //  223  415:iload           11
    //  224  417:invokevirtual   #422 <Method double SparseInstance.value(int)>
    //  225  420:fload_3         
    //  226  421:f2d             
    //  227  422:dmul            
    //  228  423:invokestatic    #425 <Method long Math.round(double)>
    //  229  426:lsub            
    //  230  427:l2i             
    //  231  428:istore          6
                                    g.setColor((Color)m_colorList.elementAt(j));
    //  232  430:aload_1         
    //  233  431:aload_0         
    //  234  432:getfield        #91  <Field FastVector m_colorList>
    //  235  435:iload           11
    //  236  437:invokevirtual   #429 <Method Object FastVector.elementAt(int)>
    //  237  440:checkcast       #39  <Class Color>
    //  238  443:invokevirtual   #433 <Method void Graphics.setColor(Color)>
                                    g.fillRect(x, y, barWidth, (int)Math.round(m_histBarClassCounts[i].value(j) * (double)heightRatio));
    //  239  446:aload_1         
    //  240  447:iload           5
    //  241  449:iload           6
    //  242  451:iload           8
    //  243  453:aload_0         
    //  244  454:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //  245  457:iload           10
    //  246  459:aaload          
    //  247  460:iload           11
    //  248  462:invokevirtual   #422 <Method double SparseInstance.value(int)>
    //  249  465:fload_3         
    //  250  466:f2d             
    //  251  467:dmul            
    //  252  468:invokestatic    #425 <Method long Math.round(double)>
    //  253  471:l2i             
    //  254  472:invokevirtual   #436 <Method void Graphics.fillRect(int, int, int, int)>
                                    g.setColor(Color.black);
    //  255  475:aload_1         
    //  256  476:getstatic       #439 <Field Color Color.black>
    //  257  479:invokevirtual   #433 <Method void Graphics.setColor(Color)>
                                }

    //  258  482:iinc            11  1
    //  259  485:iload           11
    //  260  487:aload_0         
    //  261  488:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //  262  491:iload           10
    //  263  493:aaload          
    //  264  494:invokevirtual   #440 <Method int SparseInstance.numAttributes()>
    //  265  497:icmplt          386
                            }
                            if((float)m_fm.stringWidth(Integer.toString(sum)) < intervalWidth)
    //* 266  500:aload_0         
    //* 267  501:getfield        #112 <Field FontMetrics m_fm>
    //* 268  504:iload           9
    //* 269  506:invokestatic    #442 <Method String Integer.toString(int)>
    //* 270  509:invokevirtual   #446 <Method int FontMetrics.stringWidth(String)>
    //* 271  512:i2f             
    //* 272  513:fload           4
    //* 273  515:fcmpg           
    //* 274  516:ifge            534
                                g.drawString(Integer.toString(sum), x, y - 1);
    //  275  519:aload_1         
    //  276  520:iload           9
    //  277  522:invokestatic    #442 <Method String Integer.toString(int)>
    //  278  525:iload           5
    //  279  527:iload           6
    //  280  529:iconst_1        
    //  281  530:isub            
    //  282  531:invokevirtual   #449 <Method void Graphics.drawString(String, int, int)>
                            x = x + barWidth + (int)(Math.floor(intervalWidth * 0.2F) >= 1.0D ? Math.floor(intervalWidth * 0.2F) : 1.0D);
    //  283  534:iload           5
    //  284  536:iload           8
    //  285  538:iadd            
    //  286  539:fload           4
    //  287  541:ldc2            #301 <Float 0.2F>
    //  288  544:fmul            
    //  289  545:f2d             
    //  290  546:invokestatic    #299 <Method double Math.floor(double)>
    //  291  549:dconst_1        
    //  292  550:dcmpg           
    //  293  551:ifge            558
    //  294  554:dconst_1        
    //  295  555:goto            568
    //  296  558:fload           4
    //  297  560:ldc2            #301 <Float 0.2F>
    //  298  563:fmul            
    //  299  564:f2d             
    //  300  565:invokestatic    #299 <Method double Math.floor(double)>
    //  301  568:d2i             
    //  302  569:iadd            
    //  303  570:istore          5
                            sum = 0;
    //  304  572:iconst_0        
    //  305  573:istore          9
                        }

    //  306  575:iinc            10  1
    //  307  578:iload           10
    //  308  580:aload_0         
    //  309  581:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //  310  584:arraylength     
    //  311  585:icmplt          340
                    } else
    //* 312  588:goto            2918
                    {
                        float intervalWidth = (float)getWidth() / (float)m_histBarCounts.length;
    //  313  591:aload_0         
    //  314  592:invokevirtual   #291 <Method int getWidth()>
    //  315  595:i2f             
    //  316  596:aload_0         
    //  317  597:getfield        #282 <Field int[] m_histBarCounts>
    //  318  600:arraylength     
    //  319  601:i2f             
    //  320  602:fdiv            
    //  321  603:fstore          4
                        int barWidth;
                        if(intervalWidth > 5F)
    //* 322  605:fload           4
    //* 323  607:ldc2            #292 <Float 5F>
    //* 324  610:fcmpl           
    //* 325  611:ifle            630
                            barWidth = (int)Math.floor(intervalWidth * 0.8F);
    //  326  614:fload           4
    //  327  616:ldc2            #293 <Float 0.8F>
    //  328  619:fmul            
    //  329  620:f2d             
    //  330  621:invokestatic    #299 <Method double Math.floor(double)>
    //  331  624:d2i             
    //  332  625:istore          8
                        else
    //* 333  627:goto            633
                            barWidth = 1;
    //  334  630:iconst_1        
    //  335  631:istore          8
                        x += (int)(Math.floor(intervalWidth * 0.1F) >= 1.0D ? Math.floor(intervalWidth * 0.1F) : 1.0D);
    //  336  633:iload           5
    //  337  635:fload           4
    //  338  637:ldc2            #300 <Float 0.1F>
    //  339  640:fmul            
    //  340  641:f2d             
    //  341  642:invokestatic    #299 <Method double Math.floor(double)>
    //  342  645:dconst_1        
    //  343  646:dcmpg           
    //  344  647:ifge            654
    //  345  650:dconst_1        
    //  346  651:goto            664
    //  347  654:fload           4
    //  348  656:ldc2            #300 <Float 0.1F>
    //  349  659:fmul            
    //  350  660:f2d             
    //  351  661:invokestatic    #299 <Method double Math.floor(double)>
    //  352  664:d2i             
    //  353  665:iadd            
    //  354  666:istore          5
                        if(getWidth() - (m_histBarCounts.length * barWidth + (int)(Math.floor(intervalWidth * 0.2F) >= 1.0D ? Math.floor(intervalWidth * 0.2F) : 1.0D) * m_histBarCounts.length) > 2)
    //* 355  668:aload_0         
    //* 356  669:invokevirtual   #291 <Method int getWidth()>
    //* 357  672:aload_0         
    //* 358  673:getfield        #282 <Field int[] m_histBarCounts>
    //* 359  676:arraylength     
    //* 360  677:iload           8
    //* 361  679:imul            
    //* 362  680:fload           4
    //* 363  682:ldc2            #301 <Float 0.2F>
    //* 364  685:fmul            
    //* 365  686:f2d             
    //* 366  687:invokestatic    #299 <Method double Math.floor(double)>
    //* 367  690:dconst_1        
    //* 368  691:dcmpg           
    //* 369  692:ifge            699
    //* 370  695:dconst_1        
    //* 371  696:goto            709
    //* 372  699:fload           4
    //* 373  701:ldc2            #301 <Float 0.2F>
    //* 374  704:fmul            
    //* 375  705:f2d             
    //* 376  706:invokestatic    #299 <Method double Math.floor(double)>
    //* 377  709:d2i             
    //* 378  710:aload_0         
    //* 379  711:getfield        #282 <Field int[] m_histBarCounts>
    //* 380  714:arraylength     
    //* 381  715:imul            
    //* 382  716:iadd            
    //* 383  717:isub            
    //* 384  718:iconst_2        
    //* 385  719:icmple          779
                            x += (getWidth() - (m_histBarCounts.length * barWidth + (int)(Math.floor(intervalWidth * 0.2F) >= 1.0D ? Math.floor(intervalWidth * 0.2F) : 1.0D) * m_histBarCounts.length)) / 2;
    //  386  722:iload           5
    //  387  724:aload_0         
    //  388  725:invokevirtual   #291 <Method int getWidth()>
    //  389  728:aload_0         
    //  390  729:getfield        #282 <Field int[] m_histBarCounts>
    //  391  732:arraylength     
    //  392  733:iload           8
    //  393  735:imul            
    //  394  736:fload           4
    //  395  738:ldc2            #301 <Float 0.2F>
    //  396  741:fmul            
    //  397  742:f2d             
    //  398  743:invokestatic    #299 <Method double Math.floor(double)>
    //  399  746:dconst_1        
    //  400  747:dcmpg           
    //  401  748:ifge            755
    //  402  751:dconst_1        
    //  403  752:goto            765
    //  404  755:fload           4
    //  405  757:ldc2            #301 <Float 0.2F>
    //  406  760:fmul            
    //  407  761:f2d             
    //  408  762:invokestatic    #299 <Method double Math.floor(double)>
    //  409  765:d2i             
    //  410  766:aload_0         
    //  411  767:getfield        #282 <Field int[] m_histBarCounts>
    //  412  770:arraylength     
    //  413  771:imul            
    //  414  772:iadd            
    //  415  773:isub            
    //  416  774:iconst_2        
    //  417  775:idiv            
    //  418  776:iadd            
    //  419  777:istore          5
                        for(int i = 0; i < m_histBarCounts.length; i++)
    //* 420  779:iconst_0        
    //* 421  780:istore          9
    //* 422  782:goto            937
                        {
                            float heightRatio = ((float)getHeight() - (float)m_fm.getHeight() - (float)buttonHeight) / (float)m_maxValue;
    //  423  785:aload_0         
    //  424  786:invokevirtual   #304 <Method int getHeight()>
    //  425  789:i2f             
    //  426  790:aload_0         
    //  427  791:getfield        #112 <Field FontMetrics m_fm>
    //  428  794:invokevirtual   #307 <Method int FontMetrics.getHeight()>
    //  429  797:i2f             
    //  430  798:fsub            
    //  431  799:iload_2         
    //  432  800:i2f             
    //  433  801:fsub            
    //  434  802:aload_0         
    //  435  803:getfield        #309 <Field int m_maxValue>
    //  436  806:i2f             
    //  437  807:fdiv            
    //  438  808:fstore_3        
                            y = getHeight() - Math.round((float)m_histBarCounts[i] * heightRatio);
    //  439  809:aload_0         
    //  440  810:invokevirtual   #304 <Method int getHeight()>
    //  441  813:aload_0         
    //  442  814:getfield        #282 <Field int[] m_histBarCounts>
    //  443  817:iload           9
    //  444  819:iaload          
    //  445  820:i2f             
    //  446  821:fload_3         
    //  447  822:fmul            
    //  448  823:invokestatic    #313 <Method int Math.round(float)>
    //  449  826:isub            
    //  450  827:istore          6
                            g.fillRect(x, y, barWidth, Math.round((float)m_histBarCounts[i] * heightRatio));
    //  451  829:aload_1         
    //  452  830:iload           5
    //  453  832:iload           6
    //  454  834:iload           8
    //  455  836:aload_0         
    //  456  837:getfield        #282 <Field int[] m_histBarCounts>
    //  457  840:iload           9
    //  458  842:iaload          
    //  459  843:i2f             
    //  460  844:fload_3         
    //  461  845:fmul            
    //  462  846:invokestatic    #313 <Method int Math.round(float)>
    //  463  849:invokevirtual   #436 <Method void Graphics.fillRect(int, int, int, int)>
                            if((float)m_fm.stringWidth(Integer.toString(m_histBarCounts[i])) < intervalWidth)
    //* 464  852:aload_0         
    //* 465  853:getfield        #112 <Field FontMetrics m_fm>
    //* 466  856:aload_0         
    //* 467  857:getfield        #282 <Field int[] m_histBarCounts>
    //* 468  860:iload           9
    //* 469  862:iaload          
    //* 470  863:invokestatic    #442 <Method String Integer.toString(int)>
    //* 471  866:invokevirtual   #446 <Method int FontMetrics.stringWidth(String)>
    //* 472  869:i2f             
    //* 473  870:fload           4
    //* 474  872:fcmpg           
    //* 475  873:ifge            896
                                g.drawString(Integer.toString(m_histBarCounts[i]), x, y - 1);
    //  476  876:aload_1         
    //  477  877:aload_0         
    //  478  878:getfield        #282 <Field int[] m_histBarCounts>
    //  479  881:iload           9
    //  480  883:iaload          
    //  481  884:invokestatic    #442 <Method String Integer.toString(int)>
    //  482  887:iload           5
    //  483  889:iload           6
    //  484  891:iconst_1        
    //  485  892:isub            
    //  486  893:invokevirtual   #449 <Method void Graphics.drawString(String, int, int)>
                            x = x + barWidth + (int)(Math.floor(intervalWidth * 0.2F) >= 1.0D ? Math.floor(intervalWidth * 0.2F) : 1.0D);
    //  487  896:iload           5
    //  488  898:iload           8
    //  489  900:iadd            
    //  490  901:fload           4
    //  491  903:ldc2            #301 <Float 0.2F>
    //  492  906:fmul            
    //  493  907:f2d             
    //  494  908:invokestatic    #299 <Method double Math.floor(double)>
    //  495  911:dconst_1        
    //  496  912:dcmpg           
    //  497  913:ifge            920
    //  498  916:dconst_1        
    //  499  917:goto            930
    //  500  920:fload           4
    //  501  922:ldc2            #301 <Float 0.2F>
    //  502  925:fmul            
    //  503  926:f2d             
    //  504  927:invokestatic    #299 <Method double Math.floor(double)>
    //  505  930:d2i             
    //  506  931:iadd            
    //  507  932:istore          5
                        }

    //  508  934:iinc            9  1
    //  509  937:iload           9
    //  510  939:aload_0         
    //  511  940:getfield        #282 <Field int[] m_histBarCounts>
    //  512  943:arraylength     
    //  513  944:icmplt          785
                    }
                } else
    //* 514  947:goto            2918
                if(m_as.numericStats != null && (m_histBarClassCounts != null || m_histBarCounts != null))
    //* 515  950:aload_0         
    //* 516  951:getfield        #162 <Field AttributeStats m_as>
    //* 517  954:getfield        #277 <Field Stats AttributeStats.numericStats>
    //* 518  957:ifnull          2730
    //* 519  960:aload_0         
    //* 520  961:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //* 521  964:ifnonnull       974
    //* 522  967:aload_0         
    //* 523  968:getfield        #282 <Field int[] m_histBarCounts>
    //* 524  971:ifnull          2730
                {
                    int x = 0;
    //  525  974:iconst_0        
    //  526  975:istore          5
                    int y = 0;
    //  527  977:iconst_0        
    //  528  978:istore          6
                    if(m_classIndex >= 0 && m_data.attribute(m_classIndex).isNominal())
    //* 529  980:aload_0         
    //* 530  981:getfield        #232 <Field int m_classIndex>
    //* 531  984:iflt            1921
    //* 532  987:aload_0         
    //* 533  988:getfield        #168 <Field Instances m_data>
    //* 534  991:aload_0         
    //* 535  992:getfield        #232 <Field int m_classIndex>
    //* 536  995:invokevirtual   #181 <Method Attribute Instances.attribute(int)>
    //* 537  998:invokevirtual   #345 <Method boolean Attribute.isNominal()>
    //* 538 1001:ifeq            1921
                    {
                        int barWidth = (getWidth() - 6) / m_histBarClassCounts.length >= 1 ? (getWidth() - 6) / m_histBarClassCounts.length : 1;
    //  539 1004:aload_0         
    //  540 1005:invokevirtual   #291 <Method int getWidth()>
    //  541 1008:bipush          6
    //  542 1010:isub            
    //  543 1011:aload_0         
    //  544 1012:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //  545 1015:arraylength     
    //  546 1016:idiv            
    //  547 1017:iconst_1        
    //  548 1018:icmpge          1025
    //  549 1021:iconst_1        
    //  550 1022:goto            1038
    //  551 1025:aload_0         
    //  552 1026:invokevirtual   #291 <Method int getWidth()>
    //  553 1029:bipush          6
    //  554 1031:isub            
    //  555 1032:aload_0         
    //  556 1033:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //  557 1036:arraylength     
    //  558 1037:idiv            
    //  559 1038:istore          7
                        x = 3;
    //  560 1040:iconst_3        
    //  561 1041:istore          5
                        if(getWidth() - (x + m_histBarClassCounts.length * barWidth) > 5)
    //* 562 1043:aload_0         
    //* 563 1044:invokevirtual   #291 <Method int getWidth()>
    //* 564 1047:iload           5
    //* 565 1049:aload_0         
    //* 566 1050:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //* 567 1053:arraylength     
    //* 568 1054:iload           7
    //* 569 1056:imul            
    //* 570 1057:iadd            
    //* 571 1058:isub            
    //* 572 1059:iconst_5        
    //* 573 1060:icmple          1086
                            x += (getWidth() - (x + m_histBarClassCounts.length * barWidth)) / 2;
    //  574 1063:iload           5
    //  575 1065:aload_0         
    //  576 1066:invokevirtual   #291 <Method int getWidth()>
    //  577 1069:iload           5
    //  578 1071:aload_0         
    //  579 1072:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //  580 1075:arraylength     
    //  581 1076:iload           7
    //  582 1078:imul            
    //  583 1079:iadd            
    //  584 1080:isub            
    //  585 1081:iconst_2        
    //  586 1082:idiv            
    //  587 1083:iadd            
    //  588 1084:istore          5
                        for(int i = 0; i < m_histBarClassCounts.length; i++)
    //* 589 1086:iconst_0        
    //* 590 1087:istore          8
    //* 591 1089:goto            1406
                            if(m_histBarClassCounts[i] != null)
    //* 592 1092:aload_0         
    //* 593 1093:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //* 594 1096:iload           8
    //* 595 1098:aaload          
    //* 596 1099:ifnull          1403
                            {
                                float heightRatio = ((float)getHeight() - (float)m_fm.getHeight() - (float)buttonHeight - 19F) / (float)m_maxValue;
    //  597 1102:aload_0         
    //  598 1103:invokevirtual   #304 <Method int getHeight()>
    //  599 1106:i2f             
    //  600 1107:aload_0         
    //  601 1108:getfield        #112 <Field FontMetrics m_fm>
    //  602 1111:invokevirtual   #307 <Method int FontMetrics.getHeight()>
    //  603 1114:i2f             
    //  604 1115:fsub            
    //  605 1116:iload_2         
    //  606 1117:i2f             
    //  607 1118:fsub            
    //  608 1119:ldc2            #450 <Float 19F>
    //  609 1122:fsub            
    //  610 1123:aload_0         
    //  611 1124:getfield        #309 <Field int m_maxValue>
    //  612 1127:i2f             
    //  613 1128:fdiv            
    //  614 1129:fstore_3        
                                y = getHeight() - 19;
    //  615 1130:aload_0         
    //  616 1131:invokevirtual   #304 <Method int getHeight()>
    //  617 1134:bipush          19
    //  618 1136:isub            
    //  619 1137:istore          6
                                int sum = 0;
    //  620 1139:iconst_0        
    //  621 1140:istore          9
                                for(int j = 0; j < m_histBarClassCounts[i].numValues(); j++)
    //* 622 1142:iconst_0        
    //* 623 1143:istore          10
    //* 624 1145:goto            1319
                                {
                                    y = (int)((long)y - Math.round(m_histBarClassCounts[i].valueSparse(j) * (double)heightRatio));
    //  625 1148:iload           6
    //  626 1150:i2l             
    //  627 1151:aload_0         
    //  628 1152:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //  629 1155:iload           8
    //  630 1157:aaload          
    //  631 1158:iload           10
    //  632 1160:invokevirtual   #353 <Method double SparseInstance.valueSparse(int)>
    //  633 1163:fload_3         
    //  634 1164:f2d             
    //  635 1165:dmul            
    //  636 1166:invokestatic    #425 <Method long Math.round(double)>
    //  637 1169:lsub            
    //  638 1170:l2i             
    //  639 1171:istore          6
                                    g.setColor((Color)m_colorList.elementAt(m_histBarClassCounts[i].index(j)));
    //  640 1173:aload_1         
    //  641 1174:aload_0         
    //  642 1175:getfield        #91  <Field FastVector m_colorList>
    //  643 1178:aload_0         
    //  644 1179:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //  645 1182:iload           8
    //  646 1184:aaload          
    //  647 1185:iload           10
    //  648 1187:invokevirtual   #453 <Method int SparseInstance.index(int)>
    //  649 1190:invokevirtual   #429 <Method Object FastVector.elementAt(int)>
    //  650 1193:checkcast       #39  <Class Color>
    //  651 1196:invokevirtual   #433 <Method void Graphics.setColor(Color)>
                                    if(barWidth > 1)
    //* 652 1199:iload           7
    //* 653 1201:iconst_1        
    //* 654 1202:icmple          1237
                                        g.fillRect(x, y, barWidth, (int)Math.round(m_histBarClassCounts[i].valueSparse(j) * (double)heightRatio));
    //  655 1205:aload_1         
    //  656 1206:iload           5
    //  657 1208:iload           6
    //  658 1210:iload           7
    //  659 1212:aload_0         
    //  660 1213:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //  661 1216:iload           8
    //  662 1218:aaload          
    //  663 1219:iload           10
    //  664 1221:invokevirtual   #353 <Method double SparseInstance.valueSparse(int)>
    //  665 1224:fload_3         
    //  666 1225:f2d             
    //  667 1226:dmul            
    //  668 1227:invokestatic    #425 <Method long Math.round(double)>
    //  669 1230:l2i             
    //  670 1231:invokevirtual   #436 <Method void Graphics.fillRect(int, int, int, int)>
                                    else
    //* 671 1234:goto            1290
                                    if(m_histBarClassCounts[i].valueSparse(j) * (double)heightRatio > 0.0D)
    //* 672 1237:aload_0         
    //* 673 1238:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //* 674 1241:iload           8
    //* 675 1243:aaload          
    //* 676 1244:iload           10
    //* 677 1246:invokevirtual   #353 <Method double SparseInstance.valueSparse(int)>
    //* 678 1249:fload_3         
    //* 679 1250:f2d             
    //* 680 1251:dmul            
    //* 681 1252:dconst_0        
    //* 682 1253:dcmpl           
    //* 683 1254:ifle            1290
                                        g.drawLine(x, y, x, (int)((long)y + Math.round(m_histBarClassCounts[i].valueSparse(j) * (double)heightRatio)));
    //  684 1257:aload_1         
    //  685 1258:iload           5
    //  686 1260:iload           6
    //  687 1262:iload           5
    //  688 1264:iload           6
    //  689 1266:i2l             
    //  690 1267:aload_0         
    //  691 1268:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //  692 1271:iload           8
    //  693 1273:aaload          
    //  694 1274:iload           10
    //  695 1276:invokevirtual   #353 <Method double SparseInstance.valueSparse(int)>
    //  696 1279:fload_3         
    //  697 1280:f2d             
    //  698 1281:dmul            
    //  699 1282:invokestatic    #425 <Method long Math.round(double)>
    //  700 1285:ladd            
    //  701 1286:l2i             
    //  702 1287:invokevirtual   #456 <Method void Graphics.drawLine(int, int, int, int)>
                                    g.setColor(Color.black);
    //  703 1290:aload_1         
    //  704 1291:getstatic       #439 <Field Color Color.black>
    //  705 1294:invokevirtual   #433 <Method void Graphics.setColor(Color)>
                                    sum = (int)((double)sum + m_histBarClassCounts[i].valueSparse(j));
    //  706 1297:iload           9
    //  707 1299:i2d             
    //  708 1300:aload_0         
    //  709 1301:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //  710 1304:iload           8
    //  711 1306:aaload          
    //  712 1307:iload           10
    //  713 1309:invokevirtual   #353 <Method double SparseInstance.valueSparse(int)>
    //  714 1312:dadd            
    //  715 1313:d2i             
    //  716 1314:istore          9
                                }

    //  717 1316:iinc            10  1
    //  718 1319:iload           10
    //  719 1321:aload_0         
    //  720 1322:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //  721 1325:iload           8
    //  722 1327:aaload          
    //  723 1328:invokevirtual   #356 <Method int SparseInstance.numValues()>
    //  724 1331:icmplt          1148
                                if(m_fm.stringWidth((new StringBuilder(" ")).append(Integer.toString(sum)).toString()) < barWidth)
    //* 725 1334:aload_0         
    //* 726 1335:getfield        #112 <Field FontMetrics m_fm>
    //* 727 1338:new             #203 <Class StringBuilder>
    //* 728 1341:dup             
    //* 729 1342:ldc1            #217 <String " ">
    //* 730 1344:invokespecial   #207 <Method void StringBuilder(String)>
    //* 731 1347:iload           9
    //* 732 1349:invokestatic    #442 <Method String Integer.toString(int)>
    //* 733 1352:invokevirtual   #215 <Method StringBuilder StringBuilder.append(String)>
    //* 734 1355:invokevirtual   #220 <Method String StringBuilder.toString()>
    //* 735 1358:invokevirtual   #446 <Method int FontMetrics.stringWidth(String)>
    //* 736 1361:iload           7
    //* 737 1363:icmpge          1396
                                    g.drawString((new StringBuilder(" ")).append(Integer.toString(sum)).toString(), x, y - 1);
    //  738 1366:aload_1         
    //  739 1367:new             #203 <Class StringBuilder>
    //  740 1370:dup             
    //  741 1371:ldc1            #217 <String " ">
    //  742 1373:invokespecial   #207 <Method void StringBuilder(String)>
    //  743 1376:iload           9
    //  744 1378:invokestatic    #442 <Method String Integer.toString(int)>
    //  745 1381:invokevirtual   #215 <Method StringBuilder StringBuilder.append(String)>
    //  746 1384:invokevirtual   #220 <Method String StringBuilder.toString()>
    //  747 1387:iload           5
    //  748 1389:iload           6
    //  749 1391:iconst_1        
    //  750 1392:isub            
    //  751 1393:invokevirtual   #449 <Method void Graphics.drawString(String, int, int)>
                                x += barWidth;
    //  752 1396:iload           5
    //  753 1398:iload           7
    //  754 1400:iadd            
    //  755 1401:istore          5
                            }

    //  756 1403:iinc            8  1
    //  757 1406:iload           8
    //  758 1408:aload_0         
    //  759 1409:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //  760 1412:arraylength     
    //  761 1413:icmplt          1092
                        x = 3;
    //  762 1416:iconst_3        
    //  763 1417:istore          5
                        if(getWidth() - (x + m_histBarClassCounts.length * barWidth) > 5)
    //* 764 1419:aload_0         
    //* 765 1420:invokevirtual   #291 <Method int getWidth()>
    //* 766 1423:iload           5
    //* 767 1425:aload_0         
    //* 768 1426:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //* 769 1429:arraylength     
    //* 770 1430:iload           7
    //* 771 1432:imul            
    //* 772 1433:iadd            
    //* 773 1434:isub            
    //* 774 1435:iconst_5        
    //* 775 1436:icmple          1462
                            x += (getWidth() - (x + m_histBarClassCounts.length * barWidth)) / 2;
    //  776 1439:iload           5
    //  777 1441:aload_0         
    //  778 1442:invokevirtual   #291 <Method int getWidth()>
    //  779 1445:iload           5
    //  780 1447:aload_0         
    //  781 1448:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //  782 1451:arraylength     
    //  783 1452:iload           7
    //  784 1454:imul            
    //  785 1455:iadd            
    //  786 1456:isub            
    //  787 1457:iconst_2        
    //  788 1458:idiv            
    //  789 1459:iadd            
    //  790 1460:istore          5
                        g.drawLine(x, getHeight() - 17, barWidth != 1 ? x + barWidth * m_histBarClassCounts.length : (x + barWidth * m_histBarClassCounts.length) - 1, getHeight() - 17);
    //  791 1462:aload_1         
    //  792 1463:iload           5
    //  793 1465:aload_0         
    //  794 1466:invokevirtual   #304 <Method int getHeight()>
    //  795 1469:bipush          17
    //  796 1471:isub            
    //  797 1472:iload           7
    //  798 1474:iconst_1        
    //  799 1475:icmpne          1494
    //  800 1478:iload           5
    //  801 1480:iload           7
    //  802 1482:aload_0         
    //  803 1483:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //  804 1486:arraylength     
    //  805 1487:imul            
    //  806 1488:iadd            
    //  807 1489:iconst_1        
    //  808 1490:isub            
    //  809 1491:goto            1505
    //  810 1494:iload           5
    //  811 1496:iload           7
    //  812 1498:aload_0         
    //  813 1499:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //  814 1502:arraylength     
    //  815 1503:imul            
    //  816 1504:iadd            
    //  817 1505:aload_0         
    //  818 1506:invokevirtual   #304 <Method int getHeight()>
    //  819 1509:bipush          17
    //  820 1511:isub            
    //  821 1512:invokevirtual   #456 <Method void Graphics.drawLine(int, int, int, int)>
                        g.drawLine(x, getHeight() - 16, x, getHeight() - 12);
    //  822 1515:aload_1         
    //  823 1516:iload           5
    //  824 1518:aload_0         
    //  825 1519:invokevirtual   #304 <Method int getHeight()>
    //  826 1522:bipush          16
    //  827 1524:isub            
    //  828 1525:iload           5
    //  829 1527:aload_0         
    //  830 1528:invokevirtual   #304 <Method int getHeight()>
    //  831 1531:bipush          12
    //  832 1533:isub            
    //  833 1534:invokevirtual   #456 <Method void Graphics.drawLine(int, int, int, int)>
                        g.drawString(Utils.doubleToString(m_as.numericStats.min, 2), x, (getHeight() - 12) + m_fm.getHeight());
    //  834 1537:aload_1         
    //  835 1538:aload_0         
    //  836 1539:getfield        #162 <Field AttributeStats m_as>
    //  837 1542:getfield        #277 <Field Stats AttributeStats.numericStats>
    //  838 1545:getfield        #341 <Field double Stats.min>
    //  839 1548:iconst_2        
    //  840 1549:invokestatic    #370 <Method String Utils.doubleToString(double, int)>
    //  841 1552:iload           5
    //  842 1554:aload_0         
    //  843 1555:invokevirtual   #304 <Method int getHeight()>
    //  844 1558:bipush          12
    //  845 1560:isub            
    //  846 1561:aload_0         
    //  847 1562:getfield        #112 <Field FontMetrics m_fm>
    //  848 1565:invokevirtual   #307 <Method int FontMetrics.getHeight()>
    //  849 1568:iadd            
    //  850 1569:invokevirtual   #449 <Method void Graphics.drawString(String, int, int)>
                        g.drawLine(x + (barWidth * m_histBarClassCounts.length) / 2, getHeight() - 16, x + (barWidth * m_histBarClassCounts.length) / 2, getHeight() - 12);
    //  851 1572:aload_1         
    //  852 1573:iload           5
    //  853 1575:iload           7
    //  854 1577:aload_0         
    //  855 1578:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //  856 1581:arraylength     
    //  857 1582:imul            
    //  858 1583:iconst_2        
    //  859 1584:idiv            
    //  860 1585:iadd            
    //  861 1586:aload_0         
    //  862 1587:invokevirtual   #304 <Method int getHeight()>
    //  863 1590:bipush          16
    //  864 1592:isub            
    //  865 1593:iload           5
    //  866 1595:iload           7
    //  867 1597:aload_0         
    //  868 1598:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //  869 1601:arraylength     
    //  870 1602:imul            
    //  871 1603:iconst_2        
    //  872 1604:idiv            
    //  873 1605:iadd            
    //  874 1606:aload_0         
    //  875 1607:invokevirtual   #304 <Method int getHeight()>
    //  876 1610:bipush          12
    //  877 1612:isub            
    //  878 1613:invokevirtual   #456 <Method void Graphics.drawLine(int, int, int, int)>
                        g.drawString(Utils.doubleToString(m_as.numericStats.max / 2D + m_as.numericStats.min / 2D, 2), (x + (barWidth * m_histBarClassCounts.length) / 2) - m_fm.stringWidth(Utils.doubleToString(m_as.numericStats.max / 2D + m_as.numericStats.min / 2D, 2)) / 2, (getHeight() - 12) + m_fm.getHeight());
    //  879 1616:aload_1         
    //  880 1617:aload_0         
    //  881 1618:getfield        #162 <Field AttributeStats m_as>
    //  882 1621:getfield        #277 <Field Stats AttributeStats.numericStats>
    //  883 1624:getfield        #459 <Field double Stats.max>
    //  884 1627:ldc2w           #460 <Double 2D>
    //  885 1630:ddiv            
    //  886 1631:aload_0         
    //  887 1632:getfield        #162 <Field AttributeStats m_as>
    //  888 1635:getfield        #277 <Field Stats AttributeStats.numericStats>
    //  889 1638:getfield        #341 <Field double Stats.min>
    //  890 1641:ldc2w           #460 <Double 2D>
    //  891 1644:ddiv            
    //  892 1645:dadd            
    //  893 1646:iconst_2        
    //  894 1647:invokestatic    #370 <Method String Utils.doubleToString(double, int)>
    //  895 1650:iload           5
    //  896 1652:iload           7
    //  897 1654:aload_0         
    //  898 1655:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //  899 1658:arraylength     
    //  900 1659:imul            
    //  901 1660:iconst_2        
    //  902 1661:idiv            
    //  903 1662:iadd            
    //  904 1663:aload_0         
    //  905 1664:getfield        #112 <Field FontMetrics m_fm>
    //  906 1667:aload_0         
    //  907 1668:getfield        #162 <Field AttributeStats m_as>
    //  908 1671:getfield        #277 <Field Stats AttributeStats.numericStats>
    //  909 1674:getfield        #459 <Field double Stats.max>
    //  910 1677:ldc2w           #460 <Double 2D>
    //  911 1680:ddiv            
    //  912 1681:aload_0         
    //  913 1682:getfield        #162 <Field AttributeStats m_as>
    //  914 1685:getfield        #277 <Field Stats AttributeStats.numericStats>
    //  915 1688:getfield        #341 <Field double Stats.min>
    //  916 1691:ldc2w           #460 <Double 2D>
    //  917 1694:ddiv            
    //  918 1695:dadd            
    //  919 1696:iconst_2        
    //  920 1697:invokestatic    #370 <Method String Utils.doubleToString(double, int)>
    //  921 1700:invokevirtual   #446 <Method int FontMetrics.stringWidth(String)>
    //  922 1703:iconst_2        
    //  923 1704:idiv            
    //  924 1705:isub            
    //  925 1706:aload_0         
    //  926 1707:invokevirtual   #304 <Method int getHeight()>
    //  927 1710:bipush          12
    //  928 1712:isub            
    //  929 1713:aload_0         
    //  930 1714:getfield        #112 <Field FontMetrics m_fm>
    //  931 1717:invokevirtual   #307 <Method int FontMetrics.getHeight()>
    //  932 1720:iadd            
    //  933 1721:invokevirtual   #449 <Method void Graphics.drawString(String, int, int)>
                        g.drawLine(barWidth != 1 ? x + barWidth * m_histBarClassCounts.length : (x + barWidth * m_histBarClassCounts.length) - 1, getHeight() - 16, barWidth != 1 ? x + barWidth * m_histBarClassCounts.length : (x + barWidth * m_histBarClassCounts.length) - 1, getHeight() - 12);
    //  934 1724:aload_1         
    //  935 1725:iload           7
    //  936 1727:iconst_1        
    //  937 1728:icmpne          1747
    //  938 1731:iload           5
    //  939 1733:iload           7
    //  940 1735:aload_0         
    //  941 1736:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //  942 1739:arraylength     
    //  943 1740:imul            
    //  944 1741:iadd            
    //  945 1742:iconst_1        
    //  946 1743:isub            
    //  947 1744:goto            1758
    //  948 1747:iload           5
    //  949 1749:iload           7
    //  950 1751:aload_0         
    //  951 1752:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //  952 1755:arraylength     
    //  953 1756:imul            
    //  954 1757:iadd            
    //  955 1758:aload_0         
    //  956 1759:invokevirtual   #304 <Method int getHeight()>
    //  957 1762:bipush          16
    //  958 1764:isub            
    //  959 1765:iload           7
    //  960 1767:iconst_1        
    //  961 1768:icmpne          1787
    //  962 1771:iload           5
    //  963 1773:iload           7
    //  964 1775:aload_0         
    //  965 1776:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //  966 1779:arraylength     
    //  967 1780:imul            
    //  968 1781:iadd            
    //  969 1782:iconst_1        
    //  970 1783:isub            
    //  971 1784:goto            1798
    //  972 1787:iload           5
    //  973 1789:iload           7
    //  974 1791:aload_0         
    //  975 1792:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //  976 1795:arraylength     
    //  977 1796:imul            
    //  978 1797:iadd            
    //  979 1798:aload_0         
    //  980 1799:invokevirtual   #304 <Method int getHeight()>
    //  981 1802:bipush          12
    //  982 1804:isub            
    //  983 1805:invokevirtual   #456 <Method void Graphics.drawLine(int, int, int, int)>
                        g.drawString(Utils.doubleToString(m_as.numericStats.max, 2), barWidth != 1 ? (x + barWidth * m_histBarClassCounts.length) - m_fm.stringWidth(Utils.doubleToString(m_as.numericStats.max, 2)) : (x + barWidth * m_histBarClassCounts.length) - m_fm.stringWidth(Utils.doubleToString(m_as.numericStats.max, 2)) - 1, (getHeight() - 12) + m_fm.getHeight());
    //  984 1808:aload_1         
    //  985 1809:aload_0         
    //  986 1810:getfield        #162 <Field AttributeStats m_as>
    //  987 1813:getfield        #277 <Field Stats AttributeStats.numericStats>
    //  988 1816:getfield        #459 <Field double Stats.max>
    //  989 1819:iconst_2        
    //  990 1820:invokestatic    #370 <Method String Utils.doubleToString(double, int)>
    //  991 1823:iload           7
    //  992 1825:iconst_1        
    //  993 1826:icmpne          1867
    //  994 1829:iload           5
    //  995 1831:iload           7
    //  996 1833:aload_0         
    //  997 1834:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    //  998 1837:arraylength     
    //  999 1838:imul            
    // 1000 1839:iadd            
    // 1001 1840:aload_0         
    // 1002 1841:getfield        #112 <Field FontMetrics m_fm>
    // 1003 1844:aload_0         
    // 1004 1845:getfield        #162 <Field AttributeStats m_as>
    // 1005 1848:getfield        #277 <Field Stats AttributeStats.numericStats>
    // 1006 1851:getfield        #459 <Field double Stats.max>
    // 1007 1854:iconst_2        
    // 1008 1855:invokestatic    #370 <Method String Utils.doubleToString(double, int)>
    // 1009 1858:invokevirtual   #446 <Method int FontMetrics.stringWidth(String)>
    // 1010 1861:isub            
    // 1011 1862:iconst_1        
    // 1012 1863:isub            
    // 1013 1864:goto            1900
    // 1014 1867:iload           5
    // 1015 1869:iload           7
    // 1016 1871:aload_0         
    // 1017 1872:getfield        #284 <Field SparseInstance[] m_histBarClassCounts>
    // 1018 1875:arraylength     
    // 1019 1876:imul            
    // 1020 1877:iadd            
    // 1021 1878:aload_0         
    // 1022 1879:getfield        #112 <Field FontMetrics m_fm>
    // 1023 1882:aload_0         
    // 1024 1883:getfield        #162 <Field AttributeStats m_as>
    // 1025 1886:getfield        #277 <Field Stats AttributeStats.numericStats>
    // 1026 1889:getfield        #459 <Field double Stats.max>
    // 1027 1892:iconst_2        
    // 1028 1893:invokestatic    #370 <Method String Utils.doubleToString(double, int)>
    // 1029 1896:invokevirtual   #446 <Method int FontMetrics.stringWidth(String)>
    // 1030 1899:isub            
    // 1031 1900:aload_0         
    // 1032 1901:invokevirtual   #304 <Method int getHeight()>
    // 1033 1904:bipush          12
    // 1034 1906:isub            
    // 1035 1907:aload_0         
    // 1036 1908:getfield        #112 <Field FontMetrics m_fm>
    // 1037 1911:invokevirtual   #307 <Method int FontMetrics.getHeight()>
    // 1038 1914:iadd            
    // 1039 1915:invokevirtual   #449 <Method void Graphics.drawString(String, int, int)>
                    } else
    //*1040 1918:goto            2918
                    {
                        int barWidth = (getWidth() - 6) / m_histBarCounts.length >= 1 ? (getWidth() - 6) / m_histBarCounts.length : 1;
    // 1041 1921:aload_0         
    // 1042 1922:invokevirtual   #291 <Method int getWidth()>
    // 1043 1925:bipush          6
    // 1044 1927:isub            
    // 1045 1928:aload_0         
    // 1046 1929:getfield        #282 <Field int[] m_histBarCounts>
    // 1047 1932:arraylength     
    // 1048 1933:idiv            
    // 1049 1934:iconst_1        
    // 1050 1935:icmpge          1942
    // 1051 1938:iconst_1        
    // 1052 1939:goto            1955
    // 1053 1942:aload_0         
    // 1054 1943:invokevirtual   #291 <Method int getWidth()>
    // 1055 1946:bipush          6
    // 1056 1948:isub            
    // 1057 1949:aload_0         
    // 1058 1950:getfield        #282 <Field int[] m_histBarCounts>
    // 1059 1953:arraylength     
    // 1060 1954:idiv            
    // 1061 1955:istore          7
                        x = 3;
    // 1062 1957:iconst_3        
    // 1063 1958:istore          5
                        if(getWidth() - (x + m_histBarCounts.length * barWidth) > 5)
    //*1064 1960:aload_0         
    //*1065 1961:invokevirtual   #291 <Method int getWidth()>
    //*1066 1964:iload           5
    //*1067 1966:aload_0         
    //*1068 1967:getfield        #282 <Field int[] m_histBarCounts>
    //*1069 1970:arraylength     
    //*1070 1971:iload           7
    //*1071 1973:imul            
    //*1072 1974:iadd            
    //*1073 1975:isub            
    //*1074 1976:iconst_5        
    //*1075 1977:icmple          2003
                            x += (getWidth() - (x + m_histBarCounts.length * barWidth)) / 2;
    // 1076 1980:iload           5
    // 1077 1982:aload_0         
    // 1078 1983:invokevirtual   #291 <Method int getWidth()>
    // 1079 1986:iload           5
    // 1080 1988:aload_0         
    // 1081 1989:getfield        #282 <Field int[] m_histBarCounts>
    // 1082 1992:arraylength     
    // 1083 1993:iload           7
    // 1084 1995:imul            
    // 1085 1996:iadd            
    // 1086 1997:isub            
    // 1087 1998:iconst_2        
    // 1088 1999:idiv            
    // 1089 2000:iadd            
    // 1090 2001:istore          5
                        for(int i = 0; i < m_histBarCounts.length; i++)
    //*1091 2003:iconst_0        
    //*1092 2004:istore          8
    //*1093 2006:goto            2215
                        {
                            float heightRatio = ((float)getHeight() - (float)m_fm.getHeight() - (float)buttonHeight - 19F) / (float)m_maxValue;
    // 1094 2009:aload_0         
    // 1095 2010:invokevirtual   #304 <Method int getHeight()>
    // 1096 2013:i2f             
    // 1097 2014:aload_0         
    // 1098 2015:getfield        #112 <Field FontMetrics m_fm>
    // 1099 2018:invokevirtual   #307 <Method int FontMetrics.getHeight()>
    // 1100 2021:i2f             
    // 1101 2022:fsub            
    // 1102 2023:iload_2         
    // 1103 2024:i2f             
    // 1104 2025:fsub            
    // 1105 2026:ldc2            #450 <Float 19F>
    // 1106 2029:fsub            
    // 1107 2030:aload_0         
    // 1108 2031:getfield        #309 <Field int m_maxValue>
    // 1109 2034:i2f             
    // 1110 2035:fdiv            
    // 1111 2036:fstore_3        
                            y = getHeight() - Math.round((float)m_histBarCounts[i] * heightRatio) - 19;
    // 1112 2037:aload_0         
    // 1113 2038:invokevirtual   #304 <Method int getHeight()>
    // 1114 2041:aload_0         
    // 1115 2042:getfield        #282 <Field int[] m_histBarCounts>
    // 1116 2045:iload           8
    // 1117 2047:iaload          
    // 1118 2048:i2f             
    // 1119 2049:fload_3         
    // 1120 2050:fmul            
    // 1121 2051:invokestatic    #313 <Method int Math.round(float)>
    // 1122 2054:isub            
    // 1123 2055:bipush          19
    // 1124 2057:isub            
    // 1125 2058:istore          6
                            if(barWidth > 1)
    //*1126 2060:iload           7
    //*1127 2062:iconst_1        
    //*1128 2063:icmple          2092
                                g.drawRect(x, y, barWidth, Math.round((float)m_histBarCounts[i] * heightRatio));
    // 1129 2066:aload_1         
    // 1130 2067:iload           5
    // 1131 2069:iload           6
    // 1132 2071:iload           7
    // 1133 2073:aload_0         
    // 1134 2074:getfield        #282 <Field int[] m_histBarCounts>
    // 1135 2077:iload           8
    // 1136 2079:iaload          
    // 1137 2080:i2f             
    // 1138 2081:fload_3         
    // 1139 2082:fmul            
    // 1140 2083:invokestatic    #313 <Method int Math.round(float)>
    // 1141 2086:invokevirtual   #464 <Method void Graphics.drawRect(int, int, int, int)>
                            else
    //*1142 2089:goto            2133
                            if((float)m_histBarCounts[i] * heightRatio > 0.0F)
    //*1143 2092:aload_0         
    //*1144 2093:getfield        #282 <Field int[] m_histBarCounts>
    //*1145 2096:iload           8
    //*1146 2098:iaload          
    //*1147 2099:i2f             
    //*1148 2100:fload_3         
    //*1149 2101:fmul            
    //*1150 2102:fconst_0        
    //*1151 2103:fcmpl           
    //*1152 2104:ifle            2133
                                g.drawLine(x, y, x, y + Math.round((float)m_histBarCounts[i] * heightRatio));
    // 1153 2107:aload_1         
    // 1154 2108:iload           5
    // 1155 2110:iload           6
    // 1156 2112:iload           5
    // 1157 2114:iload           6
    // 1158 2116:aload_0         
    // 1159 2117:getfield        #282 <Field int[] m_histBarCounts>
    // 1160 2120:iload           8
    // 1161 2122:iaload          
    // 1162 2123:i2f             
    // 1163 2124:fload_3         
    // 1164 2125:fmul            
    // 1165 2126:invokestatic    #313 <Method int Math.round(float)>
    // 1166 2129:iadd            
    // 1167 2130:invokevirtual   #456 <Method void Graphics.drawLine(int, int, int, int)>
                            if(m_fm.stringWidth((new StringBuilder(" ")).append(Integer.toString(m_histBarCounts[i])).toString()) < barWidth)
    //*1168 2133:aload_0         
    //*1169 2134:getfield        #112 <Field FontMetrics m_fm>
    //*1170 2137:new             #203 <Class StringBuilder>
    //*1171 2140:dup             
    //*1172 2141:ldc1            #217 <String " ">
    //*1173 2143:invokespecial   #207 <Method void StringBuilder(String)>
    //*1174 2146:aload_0         
    //*1175 2147:getfield        #282 <Field int[] m_histBarCounts>
    //*1176 2150:iload           8
    //*1177 2152:iaload          
    //*1178 2153:invokestatic    #442 <Method String Integer.toString(int)>
    //*1179 2156:invokevirtual   #215 <Method StringBuilder StringBuilder.append(String)>
    //*1180 2159:invokevirtual   #220 <Method String StringBuilder.toString()>
    //*1181 2162:invokevirtual   #446 <Method int FontMetrics.stringWidth(String)>
    //*1182 2165:iload           7
    //*1183 2167:icmpge          2205
                                g.drawString((new StringBuilder(" ")).append(Integer.toString(m_histBarCounts[i])).toString(), x, y - 1);
    // 1184 2170:aload_1         
    // 1185 2171:new             #203 <Class StringBuilder>
    // 1186 2174:dup             
    // 1187 2175:ldc1            #217 <String " ">
    // 1188 2177:invokespecial   #207 <Method void StringBuilder(String)>
    // 1189 2180:aload_0         
    // 1190 2181:getfield        #282 <Field int[] m_histBarCounts>
    // 1191 2184:iload           8
    // 1192 2186:iaload          
    // 1193 2187:invokestatic    #442 <Method String Integer.toString(int)>
    // 1194 2190:invokevirtual   #215 <Method StringBuilder StringBuilder.append(String)>
    // 1195 2193:invokevirtual   #220 <Method String StringBuilder.toString()>
    // 1196 2196:iload           5
    // 1197 2198:iload           6
    // 1198 2200:iconst_1        
    // 1199 2201:isub            
    // 1200 2202:invokevirtual   #449 <Method void Graphics.drawString(String, int, int)>
                            x += barWidth;
    // 1201 2205:iload           5
    // 1202 2207:iload           7
    // 1203 2209:iadd            
    // 1204 2210:istore          5
                        }

    // 1205 2212:iinc            8  1
    // 1206 2215:iload           8
    // 1207 2217:aload_0         
    // 1208 2218:getfield        #282 <Field int[] m_histBarCounts>
    // 1209 2221:arraylength     
    // 1210 2222:icmplt          2009
                        x = 3;
    // 1211 2225:iconst_3        
    // 1212 2226:istore          5
                        if(getWidth() - (x + m_histBarCounts.length * barWidth) > 5)
    //*1213 2228:aload_0         
    //*1214 2229:invokevirtual   #291 <Method int getWidth()>
    //*1215 2232:iload           5
    //*1216 2234:aload_0         
    //*1217 2235:getfield        #282 <Field int[] m_histBarCounts>
    //*1218 2238:arraylength     
    //*1219 2239:iload           7
    //*1220 2241:imul            
    //*1221 2242:iadd            
    //*1222 2243:isub            
    //*1223 2244:iconst_5        
    //*1224 2245:icmple          2271
                            x += (getWidth() - (x + m_histBarCounts.length * barWidth)) / 2;
    // 1225 2248:iload           5
    // 1226 2250:aload_0         
    // 1227 2251:invokevirtual   #291 <Method int getWidth()>
    // 1228 2254:iload           5
    // 1229 2256:aload_0         
    // 1230 2257:getfield        #282 <Field int[] m_histBarCounts>
    // 1231 2260:arraylength     
    // 1232 2261:iload           7
    // 1233 2263:imul            
    // 1234 2264:iadd            
    // 1235 2265:isub            
    // 1236 2266:iconst_2        
    // 1237 2267:idiv            
    // 1238 2268:iadd            
    // 1239 2269:istore          5
                        g.drawLine(x, getHeight() - 17, barWidth != 1 ? x + barWidth * m_histBarCounts.length : (x + barWidth * m_histBarCounts.length) - 1, getHeight() - 17);
    // 1240 2271:aload_1         
    // 1241 2272:iload           5
    // 1242 2274:aload_0         
    // 1243 2275:invokevirtual   #304 <Method int getHeight()>
    // 1244 2278:bipush          17
    // 1245 2280:isub            
    // 1246 2281:iload           7
    // 1247 2283:iconst_1        
    // 1248 2284:icmpne          2303
    // 1249 2287:iload           5
    // 1250 2289:iload           7
    // 1251 2291:aload_0         
    // 1252 2292:getfield        #282 <Field int[] m_histBarCounts>
    // 1253 2295:arraylength     
    // 1254 2296:imul            
    // 1255 2297:iadd            
    // 1256 2298:iconst_1        
    // 1257 2299:isub            
    // 1258 2300:goto            2314
    // 1259 2303:iload           5
    // 1260 2305:iload           7
    // 1261 2307:aload_0         
    // 1262 2308:getfield        #282 <Field int[] m_histBarCounts>
    // 1263 2311:arraylength     
    // 1264 2312:imul            
    // 1265 2313:iadd            
    // 1266 2314:aload_0         
    // 1267 2315:invokevirtual   #304 <Method int getHeight()>
    // 1268 2318:bipush          17
    // 1269 2320:isub            
    // 1270 2321:invokevirtual   #456 <Method void Graphics.drawLine(int, int, int, int)>
                        g.drawLine(x, getHeight() - 16, x, getHeight() - 12);
    // 1271 2324:aload_1         
    // 1272 2325:iload           5
    // 1273 2327:aload_0         
    // 1274 2328:invokevirtual   #304 <Method int getHeight()>
    // 1275 2331:bipush          16
    // 1276 2333:isub            
    // 1277 2334:iload           5
    // 1278 2336:aload_0         
    // 1279 2337:invokevirtual   #304 <Method int getHeight()>
    // 1280 2340:bipush          12
    // 1281 2342:isub            
    // 1282 2343:invokevirtual   #456 <Method void Graphics.drawLine(int, int, int, int)>
                        g.drawString(Utils.doubleToString(m_as.numericStats.min, 2), x, (getHeight() - 12) + m_fm.getHeight());
    // 1283 2346:aload_1         
    // 1284 2347:aload_0         
    // 1285 2348:getfield        #162 <Field AttributeStats m_as>
    // 1286 2351:getfield        #277 <Field Stats AttributeStats.numericStats>
    // 1287 2354:getfield        #341 <Field double Stats.min>
    // 1288 2357:iconst_2        
    // 1289 2358:invokestatic    #370 <Method String Utils.doubleToString(double, int)>
    // 1290 2361:iload           5
    // 1291 2363:aload_0         
    // 1292 2364:invokevirtual   #304 <Method int getHeight()>
    // 1293 2367:bipush          12
    // 1294 2369:isub            
    // 1295 2370:aload_0         
    // 1296 2371:getfield        #112 <Field FontMetrics m_fm>
    // 1297 2374:invokevirtual   #307 <Method int FontMetrics.getHeight()>
    // 1298 2377:iadd            
    // 1299 2378:invokevirtual   #449 <Method void Graphics.drawString(String, int, int)>
                        g.drawLine(x + (barWidth * m_histBarCounts.length) / 2, getHeight() - 16, x + (barWidth * m_histBarCounts.length) / 2, getHeight() - 12);
    // 1300 2381:aload_1         
    // 1301 2382:iload           5
    // 1302 2384:iload           7
    // 1303 2386:aload_0         
    // 1304 2387:getfield        #282 <Field int[] m_histBarCounts>
    // 1305 2390:arraylength     
    // 1306 2391:imul            
    // 1307 2392:iconst_2        
    // 1308 2393:idiv            
    // 1309 2394:iadd            
    // 1310 2395:aload_0         
    // 1311 2396:invokevirtual   #304 <Method int getHeight()>
    // 1312 2399:bipush          16
    // 1313 2401:isub            
    // 1314 2402:iload           5
    // 1315 2404:iload           7
    // 1316 2406:aload_0         
    // 1317 2407:getfield        #282 <Field int[] m_histBarCounts>
    // 1318 2410:arraylength     
    // 1319 2411:imul            
    // 1320 2412:iconst_2        
    // 1321 2413:idiv            
    // 1322 2414:iadd            
    // 1323 2415:aload_0         
    // 1324 2416:invokevirtual   #304 <Method int getHeight()>
    // 1325 2419:bipush          12
    // 1326 2421:isub            
    // 1327 2422:invokevirtual   #456 <Method void Graphics.drawLine(int, int, int, int)>
                        g.drawString(Utils.doubleToString(m_as.numericStats.max / 2D + m_as.numericStats.min / 2D, 2), (x + (barWidth * m_histBarCounts.length) / 2) - m_fm.stringWidth(Utils.doubleToString(m_as.numericStats.max / 2D + m_as.numericStats.min / 2D, 2)) / 2, (getHeight() - 12) + m_fm.getHeight());
    // 1328 2425:aload_1         
    // 1329 2426:aload_0         
    // 1330 2427:getfield        #162 <Field AttributeStats m_as>
    // 1331 2430:getfield        #277 <Field Stats AttributeStats.numericStats>
    // 1332 2433:getfield        #459 <Field double Stats.max>
    // 1333 2436:ldc2w           #460 <Double 2D>
    // 1334 2439:ddiv            
    // 1335 2440:aload_0         
    // 1336 2441:getfield        #162 <Field AttributeStats m_as>
    // 1337 2444:getfield        #277 <Field Stats AttributeStats.numericStats>
    // 1338 2447:getfield        #341 <Field double Stats.min>
    // 1339 2450:ldc2w           #460 <Double 2D>
    // 1340 2453:ddiv            
    // 1341 2454:dadd            
    // 1342 2455:iconst_2        
    // 1343 2456:invokestatic    #370 <Method String Utils.doubleToString(double, int)>
    // 1344 2459:iload           5
    // 1345 2461:iload           7
    // 1346 2463:aload_0         
    // 1347 2464:getfield        #282 <Field int[] m_histBarCounts>
    // 1348 2467:arraylength     
    // 1349 2468:imul            
    // 1350 2469:iconst_2        
    // 1351 2470:idiv            
    // 1352 2471:iadd            
    // 1353 2472:aload_0         
    // 1354 2473:getfield        #112 <Field FontMetrics m_fm>
    // 1355 2476:aload_0         
    // 1356 2477:getfield        #162 <Field AttributeStats m_as>
    // 1357 2480:getfield        #277 <Field Stats AttributeStats.numericStats>
    // 1358 2483:getfield        #459 <Field double Stats.max>
    // 1359 2486:ldc2w           #460 <Double 2D>
    // 1360 2489:ddiv            
    // 1361 2490:aload_0         
    // 1362 2491:getfield        #162 <Field AttributeStats m_as>
    // 1363 2494:getfield        #277 <Field Stats AttributeStats.numericStats>
    // 1364 2497:getfield        #341 <Field double Stats.min>
    // 1365 2500:ldc2w           #460 <Double 2D>
    // 1366 2503:ddiv            
    // 1367 2504:dadd            
    // 1368 2505:iconst_2        
    // 1369 2506:invokestatic    #370 <Method String Utils.doubleToString(double, int)>
    // 1370 2509:invokevirtual   #446 <Method int FontMetrics.stringWidth(String)>
    // 1371 2512:iconst_2        
    // 1372 2513:idiv            
    // 1373 2514:isub            
    // 1374 2515:aload_0         
    // 1375 2516:invokevirtual   #304 <Method int getHeight()>
    // 1376 2519:bipush          12
    // 1377 2521:isub            
    // 1378 2522:aload_0         
    // 1379 2523:getfield        #112 <Field FontMetrics m_fm>
    // 1380 2526:invokevirtual   #307 <Method int FontMetrics.getHeight()>
    // 1381 2529:iadd            
    // 1382 2530:invokevirtual   #449 <Method void Graphics.drawString(String, int, int)>
                        g.drawLine(barWidth != 1 ? x + barWidth * m_histBarCounts.length : (x + barWidth * m_histBarCounts.length) - 1, getHeight() - 16, barWidth != 1 ? x + barWidth * m_histBarCounts.length : (x + barWidth * m_histBarCounts.length) - 1, getHeight() - 12);
    // 1383 2533:aload_1         
    // 1384 2534:iload           7
    // 1385 2536:iconst_1        
    // 1386 2537:icmpne          2556
    // 1387 2540:iload           5
    // 1388 2542:iload           7
    // 1389 2544:aload_0         
    // 1390 2545:getfield        #282 <Field int[] m_histBarCounts>
    // 1391 2548:arraylength     
    // 1392 2549:imul            
    // 1393 2550:iadd            
    // 1394 2551:iconst_1        
    // 1395 2552:isub            
    // 1396 2553:goto            2567
    // 1397 2556:iload           5
    // 1398 2558:iload           7
    // 1399 2560:aload_0         
    // 1400 2561:getfield        #282 <Field int[] m_histBarCounts>
    // 1401 2564:arraylength     
    // 1402 2565:imul            
    // 1403 2566:iadd            
    // 1404 2567:aload_0         
    // 1405 2568:invokevirtual   #304 <Method int getHeight()>
    // 1406 2571:bipush          16
    // 1407 2573:isub            
    // 1408 2574:iload           7
    // 1409 2576:iconst_1        
    // 1410 2577:icmpne          2596
    // 1411 2580:iload           5
    // 1412 2582:iload           7
    // 1413 2584:aload_0         
    // 1414 2585:getfield        #282 <Field int[] m_histBarCounts>
    // 1415 2588:arraylength     
    // 1416 2589:imul            
    // 1417 2590:iadd            
    // 1418 2591:iconst_1        
    // 1419 2592:isub            
    // 1420 2593:goto            2607
    // 1421 2596:iload           5
    // 1422 2598:iload           7
    // 1423 2600:aload_0         
    // 1424 2601:getfield        #282 <Field int[] m_histBarCounts>
    // 1425 2604:arraylength     
    // 1426 2605:imul            
    // 1427 2606:iadd            
    // 1428 2607:aload_0         
    // 1429 2608:invokevirtual   #304 <Method int getHeight()>
    // 1430 2611:bipush          12
    // 1431 2613:isub            
    // 1432 2614:invokevirtual   #456 <Method void Graphics.drawLine(int, int, int, int)>
                        g.drawString(Utils.doubleToString(m_as.numericStats.max, 2), barWidth != 1 ? (x + barWidth * m_histBarCounts.length) - m_fm.stringWidth(Utils.doubleToString(m_as.numericStats.max, 2)) : (x + barWidth * m_histBarCounts.length) - m_fm.stringWidth(Utils.doubleToString(m_as.numericStats.max, 2)) - 1, (getHeight() - 12) + m_fm.getHeight());
    // 1433 2617:aload_1         
    // 1434 2618:aload_0         
    // 1435 2619:getfield        #162 <Field AttributeStats m_as>
    // 1436 2622:getfield        #277 <Field Stats AttributeStats.numericStats>
    // 1437 2625:getfield        #459 <Field double Stats.max>
    // 1438 2628:iconst_2        
    // 1439 2629:invokestatic    #370 <Method String Utils.doubleToString(double, int)>
    // 1440 2632:iload           7
    // 1441 2634:iconst_1        
    // 1442 2635:icmpne          2676
    // 1443 2638:iload           5
    // 1444 2640:iload           7
    // 1445 2642:aload_0         
    // 1446 2643:getfield        #282 <Field int[] m_histBarCounts>
    // 1447 2646:arraylength     
    // 1448 2647:imul            
    // 1449 2648:iadd            
    // 1450 2649:aload_0         
    // 1451 2650:getfield        #112 <Field FontMetrics m_fm>
    // 1452 2653:aload_0         
    // 1453 2654:getfield        #162 <Field AttributeStats m_as>
    // 1454 2657:getfield        #277 <Field Stats AttributeStats.numericStats>
    // 1455 2660:getfield        #459 <Field double Stats.max>
    // 1456 2663:iconst_2        
    // 1457 2664:invokestatic    #370 <Method String Utils.doubleToString(double, int)>
    // 1458 2667:invokevirtual   #446 <Method int FontMetrics.stringWidth(String)>
    // 1459 2670:isub            
    // 1460 2671:iconst_1        
    // 1461 2672:isub            
    // 1462 2673:goto            2709
    // 1463 2676:iload           5
    // 1464 2678:iload           7
    // 1465 2680:aload_0         
    // 1466 2681:getfield        #282 <Field int[] m_histBarCounts>
    // 1467 2684:arraylength     
    // 1468 2685:imul            
    // 1469 2686:iadd            
    // 1470 2687:aload_0         
    // 1471 2688:getfield        #112 <Field FontMetrics m_fm>
    // 1472 2691:aload_0         
    // 1473 2692:getfield        #162 <Field AttributeStats m_as>
    // 1474 2695:getfield        #277 <Field Stats AttributeStats.numericStats>
    // 1475 2698:getfield        #459 <Field double Stats.max>
    // 1476 2701:iconst_2        
    // 1477 2702:invokestatic    #370 <Method String Utils.doubleToString(double, int)>
    // 1478 2705:invokevirtual   #446 <Method int FontMetrics.stringWidth(String)>
    // 1479 2708:isub            
    // 1480 2709:aload_0         
    // 1481 2710:invokevirtual   #304 <Method int getHeight()>
    // 1482 2713:bipush          12
    // 1483 2715:isub            
    // 1484 2716:aload_0         
    // 1485 2717:getfield        #112 <Field FontMetrics m_fm>
    // 1486 2720:invokevirtual   #307 <Method int FontMetrics.getHeight()>
    // 1487 2723:iadd            
    // 1488 2724:invokevirtual   #449 <Method void Graphics.drawString(String, int, int)>
                    }
                } else
    //*1489 2727:goto            2918
                {
                    g.clearRect(0, 0, getWidth(), getHeight());
    // 1490 2730:aload_1         
    // 1491 2731:iconst_0        
    // 1492 2732:iconst_0        
    // 1493 2733:aload_0         
    // 1494 2734:invokevirtual   #291 <Method int getWidth()>
    // 1495 2737:aload_0         
    // 1496 2738:invokevirtual   #304 <Method int getHeight()>
    // 1497 2741:invokevirtual   #409 <Method void Graphics.clearRect(int, int, int, int)>
                    g.drawString("Attribute is neither numeric nor nominal.", getWidth() / 2 - m_fm.stringWidth("Attribute is neither numeric nor nominal.") / 2, getHeight() / 2 - m_fm.getHeight() / 2);
    // 1498 2744:aload_1         
    // 1499 2745:ldc2            #466 <String "Attribute is neither numeric nor nominal.">
    // 1500 2748:aload_0         
    // 1501 2749:invokevirtual   #291 <Method int getWidth()>
    // 1502 2752:iconst_2        
    // 1503 2753:idiv            
    // 1504 2754:aload_0         
    // 1505 2755:getfield        #112 <Field FontMetrics m_fm>
    // 1506 2758:ldc2            #466 <String "Attribute is neither numeric nor nominal.">
    // 1507 2761:invokevirtual   #446 <Method int FontMetrics.stringWidth(String)>
    // 1508 2764:iconst_2        
    // 1509 2765:idiv            
    // 1510 2766:isub            
    // 1511 2767:aload_0         
    // 1512 2768:invokevirtual   #304 <Method int getHeight()>
    // 1513 2771:iconst_2        
    // 1514 2772:idiv            
    // 1515 2773:aload_0         
    // 1516 2774:getfield        #112 <Field FontMetrics m_fm>
    // 1517 2777:invokevirtual   #307 <Method int FontMetrics.getHeight()>
    // 1518 2780:iconst_2        
    // 1519 2781:idiv            
    // 1520 2782:isub            
    // 1521 2783:invokevirtual   #449 <Method void Graphics.drawString(String, int, int)>
                }
            } else
    //*1522 2786:goto            2918
            if(m_displayCurrentAttribute)
    //*1523 2789:aload_0         
    //*1524 2790:getfield        #79  <Field boolean m_displayCurrentAttribute>
    //*1525 2793:ifeq            2855
            {
                g.clearRect(0, 0, getWidth(), getHeight());
    // 1526 2796:aload_1         
    // 1527 2797:iconst_0        
    // 1528 2798:iconst_0        
    // 1529 2799:aload_0         
    // 1530 2800:invokevirtual   #291 <Method int getWidth()>
    // 1531 2803:aload_0         
    // 1532 2804:invokevirtual   #304 <Method int getHeight()>
    // 1533 2807:invokevirtual   #409 <Method void Graphics.clearRect(int, int, int, int)>
                g.drawString("Calculating. Please Wait...", getWidth() / 2 - m_fm.stringWidth("Calculating. Please Wait...") / 2, getHeight() / 2 - m_fm.getHeight() / 2);
    // 1534 2810:aload_1         
    // 1535 2811:ldc2            #468 <String "Calculating. Please Wait...">
    // 1536 2814:aload_0         
    // 1537 2815:invokevirtual   #291 <Method int getWidth()>
    // 1538 2818:iconst_2        
    // 1539 2819:idiv            
    // 1540 2820:aload_0         
    // 1541 2821:getfield        #112 <Field FontMetrics m_fm>
    // 1542 2824:ldc2            #468 <String "Calculating. Please Wait...">
    // 1543 2827:invokevirtual   #446 <Method int FontMetrics.stringWidth(String)>
    // 1544 2830:iconst_2        
    // 1545 2831:idiv            
    // 1546 2832:isub            
    // 1547 2833:aload_0         
    // 1548 2834:invokevirtual   #304 <Method int getHeight()>
    // 1549 2837:iconst_2        
    // 1550 2838:idiv            
    // 1551 2839:aload_0         
    // 1552 2840:getfield        #112 <Field FontMetrics m_fm>
    // 1553 2843:invokevirtual   #307 <Method int FontMetrics.getHeight()>
    // 1554 2846:iconst_2        
    // 1555 2847:idiv            
    // 1556 2848:isub            
    // 1557 2849:invokevirtual   #449 <Method void Graphics.drawString(String, int, int)>
            } else
    //*1558 2852:goto            2918
            if(!m_displayCurrentAttribute)
    //*1559 2855:aload_0         
    //*1560 2856:getfield        #79  <Field boolean m_displayCurrentAttribute>
    //*1561 2859:ifne            2918
            {
                g.clearRect(0, 0, getWidth(), getHeight());
    // 1562 2862:aload_1         
    // 1563 2863:iconst_0        
    // 1564 2864:iconst_0        
    // 1565 2865:aload_0         
    // 1566 2866:invokevirtual   #291 <Method int getWidth()>
    // 1567 2869:aload_0         
    // 1568 2870:invokevirtual   #304 <Method int getHeight()>
    // 1569 2873:invokevirtual   #409 <Method void Graphics.clearRect(int, int, int, int)>
                g.drawString("Too many values to display.", getWidth() / 2 - m_fm.stringWidth("Too many values to display.") / 2, getHeight() / 2 - m_fm.getHeight() / 2);
    // 1570 2876:aload_1         
    // 1571 2877:ldc2            #470 <String "Too many values to display.">
    // 1572 2880:aload_0         
    // 1573 2881:invokevirtual   #291 <Method int getWidth()>
    // 1574 2884:iconst_2        
    // 1575 2885:idiv            
    // 1576 2886:aload_0         
    // 1577 2887:getfield        #112 <Field FontMetrics m_fm>
    // 1578 2890:ldc2            #470 <String "Too many values to display.">
    // 1579 2893:invokevirtual   #446 <Method int FontMetrics.stringWidth(String)>
    // 1580 2896:iconst_2        
    // 1581 2897:idiv            
    // 1582 2898:isub            
    // 1583 2899:aload_0         
    // 1584 2900:invokevirtual   #304 <Method int getHeight()>
    // 1585 2903:iconst_2        
    // 1586 2904:idiv            
    // 1587 2905:aload_0         
    // 1588 2906:getfield        #112 <Field FontMetrics m_fm>
    // 1589 2909:invokevirtual   #307 <Method int FontMetrics.getHeight()>
    // 1590 2912:iconst_2        
    // 1591 2913:idiv            
    // 1592 2914:isub            
    // 1593 2915:invokevirtual   #449 <Method void Graphics.drawString(String, int, int)>
            }
        }
    // 1594 2918:return          
    }

    public static void main(String args[])
    {
        if(args.length != 3)
    //*   0    0:aload_0         
    //*   1    1:arraylength     
    //*   2    2:iconst_3        
    //*   3    3:icmpeq          220
        {
            JFrame jf = new JFrame("AttribVisualization");
    //    4    6:new             #478 <Class JFrame>
    //    5    9:dup             
    //    6   10:ldc2            #480 <String "AttribVisualization">
    //    7   13:invokespecial   #481 <Method void JFrame(String)>
    //    8   16:astore_1        
            AttributeVisualizationPanel ap = new AttributeVisualizationPanel();
    //    9   17:new             #2   <Class AttributeVisualizationPanel>
    //   10   20:dup             
    //   11   21:invokespecial   #482 <Method void AttributeVisualizationPanel()>
    //   12   24:astore_2        
            try
            {
                Instances ins = new Instances(new FileReader(args[0]));
    //   13   25:new             #164 <Class Instances>
    //   14   28:dup             
    //   15   29:new             #484 <Class FileReader>
    //   16   32:dup             
    //   17   33:aload_0         
    //   18   34:iconst_0        
    //   19   35:aaload          
    //   20   36:invokespecial   #485 <Method void FileReader(String)>
    //   21   39:invokespecial   #488 <Method void Instances(java.io.Reader)>
    //   22   42:astore_3        
                ap.setInstances(ins);
    //   23   43:aload_2         
    //   24   44:aload_3         
    //   25   45:invokevirtual   #490 <Method void setInstances(Instances)>
                System.out.println((new StringBuilder("Loaded: ")).append(args[0]).append("\nRelation: ").append(ap.m_data.relationName()).append("\nAttributes: ").append(ap.m_data.numAttributes()).toString());
    //   26   48:getstatic       #496 <Field PrintStream System.out>
    //   27   51:new             #203 <Class StringBuilder>
    //   28   54:dup             
    //   29   55:ldc2            #498 <String "Loaded: ">
    //   30   58:invokespecial   #207 <Method void StringBuilder(String)>
    //   31   61:aload_0         
    //   32   62:iconst_0        
    //   33   63:aaload          
    //   34   64:invokevirtual   #215 <Method StringBuilder StringBuilder.append(String)>
    //   35   67:ldc2            #500 <String "\nRelation: ">
    //   36   70:invokevirtual   #215 <Method StringBuilder StringBuilder.append(String)>
    //   37   73:aload_2         
    //   38   74:getfield        #168 <Field Instances m_data>
    //   39   77:invokevirtual   #503 <Method String Instances.relationName()>
    //   40   80:invokevirtual   #215 <Method StringBuilder StringBuilder.append(String)>
    //   41   83:ldc2            #505 <String "\nAttributes: ">
    //   42   86:invokevirtual   #215 <Method StringBuilder StringBuilder.append(String)>
    //   43   89:aload_2         
    //   44   90:getfield        #168 <Field Instances m_data>
    //   45   93:invokevirtual   #224 <Method int Instances.numAttributes()>
    //   46   96:invokevirtual   #334 <Method StringBuilder StringBuilder.append(int)>
    //   47   99:invokevirtual   #220 <Method String StringBuilder.toString()>
    //   48  102:invokevirtual   #510 <Method void PrintStream.println(String)>
                ap.setAttribute(Integer.parseInt(args[1]));
    //   49  105:aload_2         
    //   50  106:aload_0         
    //   51  107:iconst_1        
    //   52  108:aaload          
    //   53  109:invokestatic    #513 <Method int Integer.parseInt(String)>
    //   54  112:invokevirtual   #242 <Method void setAttribute(int)>
            }
    //*  55  115:goto            127
            catch(Exception ex)
    //*  56  118:astore_3        
            {
                ex.printStackTrace();
    //   57  119:aload_3         
    //   58  120:invokevirtual   #518 <Method void Exception.printStackTrace()>
                System.exit(-1);
    //   59  123:iconst_m1       
    //   60  124:invokestatic    #521 <Method void System.exit(int)>
            }
            System.out.println("The attributes are: ");
    //   61  127:getstatic       #496 <Field PrintStream System.out>
    //   62  130:ldc2            #523 <String "The attributes are: ">
    //   63  133:invokevirtual   #510 <Method void PrintStream.println(String)>
            for(int i = 0; i < ap.m_data.numAttributes(); i++)
    //*  64  136:iconst_0        
    //*  65  137:istore_3        
    //*  66  138:goto            161
                System.out.println(ap.m_data.attribute(i).name());
    //   67  141:getstatic       #496 <Field PrintStream System.out>
    //   68  144:aload_2         
    //   69  145:getfield        #168 <Field Instances m_data>
    //   70  148:iload_3         
    //   71  149:invokevirtual   #181 <Method Attribute Instances.attribute(int)>
    //   72  152:invokevirtual   #211 <Method String Attribute.name()>
    //   73  155:invokevirtual   #510 <Method void PrintStream.println(String)>

    //   74  158:iinc            3  1
    //   75  161:iload_3         
    //   76  162:aload_2         
    //   77  163:getfield        #168 <Field Instances m_data>
    //   78  166:invokevirtual   #224 <Method int Instances.numAttributes()>
    //   79  169:icmplt          141
            jf.setSize(500, 300);
    //   80  172:aload_1         
    //   81  173:sipush          500
    //   82  176:sipush          300
    //   83  179:invokevirtual   #526 <Method void JFrame.setSize(int, int)>
            jf.getContentPane().setLayout(new BorderLayout());
    //   84  182:aload_1         
    //   85  183:invokevirtual   #530 <Method Container JFrame.getContentPane()>
    //   86  186:new             #532 <Class BorderLayout>
    //   87  189:dup             
    //   88  190:invokespecial   #533 <Method void BorderLayout()>
    //   89  193:invokevirtual   #536 <Method void Container.setLayout(java.awt.LayoutManager)>
            jf.getContentPane().add(ap, "Center");
    //   90  196:aload_1         
    //   91  197:invokevirtual   #530 <Method Container JFrame.getContentPane()>
    //   92  200:aload_2         
    //   93  201:ldc2            #538 <String "Center">
    //   94  204:invokevirtual   #541 <Method void Container.add(java.awt.Component, Object)>
            jf.setDefaultCloseOperation(3);
    //   95  207:aload_1         
    //   96  208:iconst_3        
    //   97  209:invokevirtual   #544 <Method void JFrame.setDefaultCloseOperation(int)>
            jf.setVisible(true);
    //   98  212:aload_1         
    //   99  213:iconst_1        
    //  100  214:invokevirtual   #547 <Method void JFrame.setVisible(boolean)>
        } else
    //* 101  217:goto            229
        {
            System.out.println("Usage: java AttributeVisualizationPanel [arff file] [index of attribute]");
    //  102  220:getstatic       #496 <Field PrintStream System.out>
    //  103  223:ldc2            #549 <String "Usage: java AttributeVisualizationPanel [arff file] [index of attribute]">
    //  104  226:invokevirtual   #510 <Method void PrintStream.println(String)>
        }
    //  105  229:return          
    }

    protected Instances m_data;
    protected AttributeStats m_as;
    protected int m_attribIndex;
    protected int m_maxValue;
    protected int m_histBarCounts[];
    SparseInstance m_histBarClassCounts[];
    protected double m_barRange;
    protected int m_classIndex;
    private Thread m_hc;
    private boolean m_threadRun;
    private boolean m_doneCurrentAttribute;
    private boolean m_displayCurrentAttribute;
    protected JComboBox m_colorAttrib;
    private FontMetrics m_fm;
    private Integer m_locker;
    private FastVector m_colorList;
    private static final Color m_defaultColors[];

    static 
    {
        m_defaultColors = (new Color[] {
            Color.blue, Color.red, Color.cyan, new Color(75, 123, 130), Color.pink, Color.green, Color.orange, new Color(255, 0, 255), new Color(255, 0, 0), new Color(0, 255, 0)
        });
    //    0    0:bipush          10
    //    1    2:anewarray       Color[]
    //    2    5:dup             
    //    3    6:iconst_0        
    //    4    7:getstatic       #43  <Field Color Color.blue>
    //    5   10:aastore         
    //    6   11:dup             
    //    7   12:iconst_1        
    //    8   13:getstatic       #46  <Field Color Color.red>
    //    9   16:aastore         
    //   10   17:dup             
    //   11   18:iconst_2        
    //   12   19:getstatic       #49  <Field Color Color.cyan>
    //   13   22:aastore         
    //   14   23:dup             
    //   15   24:iconst_3        
    //   16   25:new             #39  <Class Color>
    //   17   28:dup             
    //   18   29:bipush          75
    //   19   31:bipush          123
    //   20   33:sipush          130
    //   21   36:invokespecial   #53  <Method void Color(int, int, int)>
    //   22   39:aastore         
    //   23   40:dup             
    //   24   41:iconst_4        
    //   25   42:getstatic       #56  <Field Color Color.pink>
    //   26   45:aastore         
    //   27   46:dup             
    //   28   47:iconst_5        
    //   29   48:getstatic       #59  <Field Color Color.green>
    //   30   51:aastore         
    //   31   52:dup             
    //   32   53:bipush          6
    //   33   55:getstatic       #62  <Field Color Color.orange>
    //   34   58:aastore         
    //   35   59:dup             
    //   36   60:bipush          7
    //   37   62:new             #39  <Class Color>
    //   38   65:dup             
    //   39   66:sipush          255
    //   40   69:iconst_0        
    //   41   70:sipush          255
    //   42   73:invokespecial   #53  <Method void Color(int, int, int)>
    //   43   76:aastore         
    //   44   77:dup             
    //   45   78:bipush          8
    //   46   80:new             #39  <Class Color>
    //   47   83:dup             
    //   48   84:sipush          255
    //   49   87:iconst_0        
    //   50   88:iconst_0        
    //   51   89:invokespecial   #53  <Method void Color(int, int, int)>
    //   52   92:aastore         
    //   53   93:dup             
    //   54   94:bipush          9
    //   55   96:new             #39  <Class Color>
    //   56   99:dup             
    //   57  100:iconst_0        
    //   58  101:sipush          255
    //   59  104:iconst_0        
    //   60  105:invokespecial   #53  <Method void Color(int, int, int)>
    //   61  108:aastore         
    //   62  109:putstatic       #64  <Field Color[] m_defaultColors>
    //*  63  112:return          
    }


/*
    static Integer access$0(AttributeVisualizationPanel attributevisualizationpanel)
    {
        return attributevisualizationpanel.m_locker;
    //    0    0:aload_0         
    //    1    1:getfield        #86  <Field Integer m_locker>
    //    2    4:areturn         
    }

*/


/*
    static void access$1(AttributeVisualizationPanel attributevisualizationpanel, boolean flag)
    {
        attributevisualizationpanel.m_threadRun = flag;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #75  <Field boolean m_threadRun>
        return;
    //    3    5:return          
    }

*/


/*
    static void access$2(AttributeVisualizationPanel attributevisualizationpanel, boolean flag)
    {
        attributevisualizationpanel.m_doneCurrentAttribute = flag;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #77  <Field boolean m_doneCurrentAttribute>
        return;
    //    3    5:return          
    }

*/


/*
    static void access$3(AttributeVisualizationPanel attributevisualizationpanel, boolean flag)
    {
        attributevisualizationpanel.m_displayCurrentAttribute = flag;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #79  <Field boolean m_displayCurrentAttribute>
        return;
    //    3    5:return          
    }

*/


/*
    static FastVector access$4(AttributeVisualizationPanel attributevisualizationpanel)
    {
        return attributevisualizationpanel.m_colorList;
    //    0    0:aload_0         
    //    1    1:getfield        #91  <Field FastVector m_colorList>
    //    2    4:areturn         
    }

*/


/*
    static Color[] access$5()
    {
        return m_defaultColors;
    //    0    0:getstatic       #64  <Field Color[] m_defaultColors>
    //    1    3:areturn         
    }

*/
}
