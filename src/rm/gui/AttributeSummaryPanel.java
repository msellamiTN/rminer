// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   AttributeSummaryPanel.java

package rm.gui;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.table.*;
import rm.core.*;

public class AttributeSummaryPanel extends JPanel
{

    public AttributeSummaryPanel()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #30  <Method void JPanel()>
        m_AttributeNameLab = new JLabel("None");
    //    2    4:aload_0         
    //    3    5:new             #32  <Class JLabel>
    //    4    8:dup             
    //    5    9:ldc1            #13  <String "None">
    //    6   11:invokespecial   #35  <Method void JLabel(String)>
    //    7   14:putfield        #37  <Field JLabel m_AttributeNameLab>
        m_AttributeTypeLab = new JLabel("None");
    //    8   17:aload_0         
    //    9   18:new             #32  <Class JLabel>
    //   10   21:dup             
    //   11   22:ldc1            #13  <String "None">
    //   12   24:invokespecial   #35  <Method void JLabel(String)>
    //   13   27:putfield        #39  <Field JLabel m_AttributeTypeLab>
        m_MissingLab = new JLabel("None");
    //   14   30:aload_0         
    //   15   31:new             #32  <Class JLabel>
    //   16   34:dup             
    //   17   35:ldc1            #13  <String "None">
    //   18   37:invokespecial   #35  <Method void JLabel(String)>
    //   19   40:putfield        #41  <Field JLabel m_MissingLab>
        m_UniqueLab = new JLabel("None");
    //   20   43:aload_0         
    //   21   44:new             #32  <Class JLabel>
    //   22   47:dup             
    //   23   48:ldc1            #13  <String "None">
    //   24   50:invokespecial   #35  <Method void JLabel(String)>
    //   25   53:putfield        #43  <Field JLabel m_UniqueLab>
        m_DistinctLab = new JLabel("None");
    //   26   56:aload_0         
    //   27   57:new             #32  <Class JLabel>
    //   28   60:dup             
    //   29   61:ldc1            #13  <String "None">
    //   30   63:invokespecial   #35  <Method void JLabel(String)>
    //   31   66:putfield        #45  <Field JLabel m_DistinctLab>
        m_StatsTable = new JTable() {

            public boolean isCellEditable(int row, int column)
            {
                return false;
            //    0    0:iconst_0        
            //    1    1:ireturn         
            }

            private static final long serialVersionUID = 0x636fb37b61a12542L;
            final AttributeSummaryPanel this$0;

            
            {
                this$0 = AttributeSummaryPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #16  <Field AttributeSummaryPanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #19  <Method void JTable()>
            //    5    9:return          
            }
        }
;
    //   32   69:aload_0         
    //   33   70:new             #47  <Class AttributeSummaryPanel$1>
    //   34   73:dup             
    //   35   74:aload_0         
    //   36   75:invokespecial   #50  <Method void AttributeSummaryPanel$1(AttributeSummaryPanel)>
    //   37   78:putfield        #52  <Field JTable m_StatsTable>
        JPanel simple = new JPanel();
    //   38   81:new             #4   <Class JPanel>
    //   39   84:dup             
    //   40   85:invokespecial   #30  <Method void JPanel()>
    //   41   88:astore_1        
        GridBagLayout gbL = new GridBagLayout();
    //   42   89:new             #54  <Class GridBagLayout>
    //   43   92:dup             
    //   44   93:invokespecial   #55  <Method void GridBagLayout()>
    //   45   96:astore_2        
        simple.setLayout(gbL);
    //   46   97:aload_1         
    //   47   98:aload_2         
    //   48   99:invokevirtual   #59  <Method void JPanel.setLayout(java.awt.LayoutManager)>
        JLabel lab = new JLabel("Name:", 4);
    //   49  102:new             #32  <Class JLabel>
    //   50  105:dup             
    //   51  106:ldc1            #61  <String "Name:">
    //   52  108:iconst_4        
    //   53  109:invokespecial   #64  <Method void JLabel(String, int)>
    //   54  112:astore_3        
        lab.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
    //   55  113:aload_3         
    //   56  114:iconst_0        
    //   57  115:bipush          10
    //   58  117:iconst_0        
    //   59  118:iconst_0        
    //   60  119:invokestatic    #70  <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
    //   61  122:invokevirtual   #74  <Method void JLabel.setBorder(javax.swing.border.Border)>
        GridBagConstraints gbC = new GridBagConstraints();
    //   62  125:new             #76  <Class GridBagConstraints>
    //   63  128:dup             
    //   64  129:invokespecial   #77  <Method void GridBagConstraints()>
    //   65  132:astore          4
        gbC.anchor = 13;
    //   66  134:aload           4
    //   67  136:bipush          13
    //   68  138:putfield        #81  <Field int GridBagConstraints.anchor>
        gbC.fill = 2;
    //   69  141:aload           4
    //   70  143:iconst_2        
    //   71  144:putfield        #84  <Field int GridBagConstraints.fill>
        gbC.gridy = 0;
    //   72  147:aload           4
    //   73  149:iconst_0        
    //   74  150:putfield        #87  <Field int GridBagConstraints.gridy>
        gbC.gridx = 0;
    //   75  153:aload           4
    //   76  155:iconst_0        
    //   77  156:putfield        #90  <Field int GridBagConstraints.gridx>
        gbL.setConstraints(lab, gbC);
    //   78  159:aload_2         
    //   79  160:aload_3         
    //   80  161:aload           4
    //   81  163:invokevirtual   #94  <Method void GridBagLayout.setConstraints(java.awt.Component, GridBagConstraints)>
        simple.add(lab);
    //   82  166:aload_1         
    //   83  167:aload_3         
    //   84  168:invokevirtual   #98  <Method java.awt.Component JPanel.add(java.awt.Component)>
    //   85  171:pop             
        gbC = new GridBagConstraints();
    //   86  172:new             #76  <Class GridBagConstraints>
    //   87  175:dup             
    //   88  176:invokespecial   #77  <Method void GridBagConstraints()>
    //   89  179:astore          4
        gbC.anchor = 17;
    //   90  181:aload           4
    //   91  183:bipush          17
    //   92  185:putfield        #81  <Field int GridBagConstraints.anchor>
        gbC.fill = 2;
    //   93  188:aload           4
    //   94  190:iconst_2        
    //   95  191:putfield        #84  <Field int GridBagConstraints.fill>
        gbC.gridy = 0;
    //   96  194:aload           4
    //   97  196:iconst_0        
    //   98  197:putfield        #87  <Field int GridBagConstraints.gridy>
        gbC.gridx = 1;
    //   99  200:aload           4
    //  100  202:iconst_1        
    //  101  203:putfield        #90  <Field int GridBagConstraints.gridx>
        gbC.weightx = 100D;
    //  102  206:aload           4
    //  103  208:ldc2w           #99  <Double 100D>
    //  104  211:putfield        #104 <Field double GridBagConstraints.weightx>
        gbC.gridwidth = 3;
    //  105  214:aload           4
    //  106  216:iconst_3        
    //  107  217:putfield        #107 <Field int GridBagConstraints.gridwidth>
        gbL.setConstraints(m_AttributeNameLab, gbC);
    //  108  220:aload_2         
    //  109  221:aload_0         
    //  110  222:getfield        #37  <Field JLabel m_AttributeNameLab>
    //  111  225:aload           4
    //  112  227:invokevirtual   #94  <Method void GridBagLayout.setConstraints(java.awt.Component, GridBagConstraints)>
        simple.add(m_AttributeNameLab);
    //  113  230:aload_1         
    //  114  231:aload_0         
    //  115  232:getfield        #37  <Field JLabel m_AttributeNameLab>
    //  116  235:invokevirtual   #98  <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  117  238:pop             
        m_AttributeNameLab.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 10));
    //  118  239:aload_0         
    //  119  240:getfield        #37  <Field JLabel m_AttributeNameLab>
    //  120  243:iconst_0        
    //  121  244:iconst_5        
    //  122  245:iconst_0        
    //  123  246:bipush          10
    //  124  248:invokestatic    #70  <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
    //  125  251:invokevirtual   #74  <Method void JLabel.setBorder(javax.swing.border.Border)>
        lab = new JLabel("Type:", 4);
    //  126  254:new             #32  <Class JLabel>
    //  127  257:dup             
    //  128  258:ldc1            #109 <String "Type:">
    //  129  260:iconst_4        
    //  130  261:invokespecial   #64  <Method void JLabel(String, int)>
    //  131  264:astore_3        
        lab.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
    //  132  265:aload_3         
    //  133  266:iconst_0        
    //  134  267:bipush          10
    //  135  269:iconst_0        
    //  136  270:iconst_0        
    //  137  271:invokestatic    #70  <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
    //  138  274:invokevirtual   #74  <Method void JLabel.setBorder(javax.swing.border.Border)>
        gbC = new GridBagConstraints();
    //  139  277:new             #76  <Class GridBagConstraints>
    //  140  280:dup             
    //  141  281:invokespecial   #77  <Method void GridBagConstraints()>
    //  142  284:astore          4
        gbC.anchor = 13;
    //  143  286:aload           4
    //  144  288:bipush          13
    //  145  290:putfield        #81  <Field int GridBagConstraints.anchor>
        gbC.fill = 2;
    //  146  293:aload           4
    //  147  295:iconst_2        
    //  148  296:putfield        #84  <Field int GridBagConstraints.fill>
        gbC.gridy = 0;
    //  149  299:aload           4
    //  150  301:iconst_0        
    //  151  302:putfield        #87  <Field int GridBagConstraints.gridy>
        gbC.gridx = 4;
    //  152  305:aload           4
    //  153  307:iconst_4        
    //  154  308:putfield        #90  <Field int GridBagConstraints.gridx>
        gbL.setConstraints(lab, gbC);
    //  155  311:aload_2         
    //  156  312:aload_3         
    //  157  313:aload           4
    //  158  315:invokevirtual   #94  <Method void GridBagLayout.setConstraints(java.awt.Component, GridBagConstraints)>
        simple.add(lab);
    //  159  318:aload_1         
    //  160  319:aload_3         
    //  161  320:invokevirtual   #98  <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  162  323:pop             
        gbC = new GridBagConstraints();
    //  163  324:new             #76  <Class GridBagConstraints>
    //  164  327:dup             
    //  165  328:invokespecial   #77  <Method void GridBagConstraints()>
    //  166  331:astore          4
        gbC.anchor = 17;
    //  167  333:aload           4
    //  168  335:bipush          17
    //  169  337:putfield        #81  <Field int GridBagConstraints.anchor>
        gbC.fill = 2;
    //  170  340:aload           4
    //  171  342:iconst_2        
    //  172  343:putfield        #84  <Field int GridBagConstraints.fill>
        gbC.gridy = 0;
    //  173  346:aload           4
    //  174  348:iconst_0        
    //  175  349:putfield        #87  <Field int GridBagConstraints.gridy>
        gbC.gridx = 5;
    //  176  352:aload           4
    //  177  354:iconst_5        
    //  178  355:putfield        #90  <Field int GridBagConstraints.gridx>
        gbC.weightx = 100D;
    //  179  358:aload           4
    //  180  360:ldc2w           #99  <Double 100D>
    //  181  363:putfield        #104 <Field double GridBagConstraints.weightx>
        gbL.setConstraints(m_AttributeTypeLab, gbC);
    //  182  366:aload_2         
    //  183  367:aload_0         
    //  184  368:getfield        #39  <Field JLabel m_AttributeTypeLab>
    //  185  371:aload           4
    //  186  373:invokevirtual   #94  <Method void GridBagLayout.setConstraints(java.awt.Component, GridBagConstraints)>
        simple.add(m_AttributeTypeLab);
    //  187  376:aload_1         
    //  188  377:aload_0         
    //  189  378:getfield        #39  <Field JLabel m_AttributeTypeLab>
    //  190  381:invokevirtual   #98  <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  191  384:pop             
        m_AttributeTypeLab.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 10));
    //  192  385:aload_0         
    //  193  386:getfield        #39  <Field JLabel m_AttributeTypeLab>
    //  194  389:iconst_0        
    //  195  390:iconst_5        
    //  196  391:iconst_0        
    //  197  392:bipush          10
    //  198  394:invokestatic    #70  <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
    //  199  397:invokevirtual   #74  <Method void JLabel.setBorder(javax.swing.border.Border)>
        lab = new JLabel("Missing:", 4);
    //  200  400:new             #32  <Class JLabel>
    //  201  403:dup             
    //  202  404:ldc1            #111 <String "Missing:">
    //  203  406:iconst_4        
    //  204  407:invokespecial   #64  <Method void JLabel(String, int)>
    //  205  410:astore_3        
        lab.setBorder(BorderFactory.createEmptyBorder(0, 10, 5, 0));
    //  206  411:aload_3         
    //  207  412:iconst_0        
    //  208  413:bipush          10
    //  209  415:iconst_5        
    //  210  416:iconst_0        
    //  211  417:invokestatic    #70  <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
    //  212  420:invokevirtual   #74  <Method void JLabel.setBorder(javax.swing.border.Border)>
        gbC = new GridBagConstraints();
    //  213  423:new             #76  <Class GridBagConstraints>
    //  214  426:dup             
    //  215  427:invokespecial   #77  <Method void GridBagConstraints()>
    //  216  430:astore          4
        gbC.anchor = 13;
    //  217  432:aload           4
    //  218  434:bipush          13
    //  219  436:putfield        #81  <Field int GridBagConstraints.anchor>
        gbC.fill = 2;
    //  220  439:aload           4
    //  221  441:iconst_2        
    //  222  442:putfield        #84  <Field int GridBagConstraints.fill>
        gbC.gridy = 1;
    //  223  445:aload           4
    //  224  447:iconst_1        
    //  225  448:putfield        #87  <Field int GridBagConstraints.gridy>
        gbC.gridx = 0;
    //  226  451:aload           4
    //  227  453:iconst_0        
    //  228  454:putfield        #90  <Field int GridBagConstraints.gridx>
        gbL.setConstraints(lab, gbC);
    //  229  457:aload_2         
    //  230  458:aload_3         
    //  231  459:aload           4
    //  232  461:invokevirtual   #94  <Method void GridBagLayout.setConstraints(java.awt.Component, GridBagConstraints)>
        simple.add(lab);
    //  233  464:aload_1         
    //  234  465:aload_3         
    //  235  466:invokevirtual   #98  <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  236  469:pop             
        gbC = new GridBagConstraints();
    //  237  470:new             #76  <Class GridBagConstraints>
    //  238  473:dup             
    //  239  474:invokespecial   #77  <Method void GridBagConstraints()>
    //  240  477:astore          4
        gbC.anchor = 17;
    //  241  479:aload           4
    //  242  481:bipush          17
    //  243  483:putfield        #81  <Field int GridBagConstraints.anchor>
        gbC.fill = 2;
    //  244  486:aload           4
    //  245  488:iconst_2        
    //  246  489:putfield        #84  <Field int GridBagConstraints.fill>
        gbC.gridy = 1;
    //  247  492:aload           4
    //  248  494:iconst_1        
    //  249  495:putfield        #87  <Field int GridBagConstraints.gridy>
        gbC.gridx = 1;
    //  250  498:aload           4
    //  251  500:iconst_1        
    //  252  501:putfield        #90  <Field int GridBagConstraints.gridx>
        gbC.weightx = 100D;
    //  253  504:aload           4
    //  254  506:ldc2w           #99  <Double 100D>
    //  255  509:putfield        #104 <Field double GridBagConstraints.weightx>
        gbL.setConstraints(m_MissingLab, gbC);
    //  256  512:aload_2         
    //  257  513:aload_0         
    //  258  514:getfield        #41  <Field JLabel m_MissingLab>
    //  259  517:aload           4
    //  260  519:invokevirtual   #94  <Method void GridBagLayout.setConstraints(java.awt.Component, GridBagConstraints)>
        simple.add(m_MissingLab);
    //  261  522:aload_1         
    //  262  523:aload_0         
    //  263  524:getfield        #41  <Field JLabel m_MissingLab>
    //  264  527:invokevirtual   #98  <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  265  530:pop             
        m_MissingLab.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 10));
    //  266  531:aload_0         
    //  267  532:getfield        #41  <Field JLabel m_MissingLab>
    //  268  535:iconst_0        
    //  269  536:iconst_5        
    //  270  537:iconst_5        
    //  271  538:bipush          10
    //  272  540:invokestatic    #70  <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
    //  273  543:invokevirtual   #74  <Method void JLabel.setBorder(javax.swing.border.Border)>
        lab = new JLabel("Distinct:", 4);
    //  274  546:new             #32  <Class JLabel>
    //  275  549:dup             
    //  276  550:ldc1            #113 <String "Distinct:">
    //  277  552:iconst_4        
    //  278  553:invokespecial   #64  <Method void JLabel(String, int)>
    //  279  556:astore_3        
        lab.setBorder(BorderFactory.createEmptyBorder(0, 10, 5, 0));
    //  280  557:aload_3         
    //  281  558:iconst_0        
    //  282  559:bipush          10
    //  283  561:iconst_5        
    //  284  562:iconst_0        
    //  285  563:invokestatic    #70  <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
    //  286  566:invokevirtual   #74  <Method void JLabel.setBorder(javax.swing.border.Border)>
        gbC = new GridBagConstraints();
    //  287  569:new             #76  <Class GridBagConstraints>
    //  288  572:dup             
    //  289  573:invokespecial   #77  <Method void GridBagConstraints()>
    //  290  576:astore          4
        gbC.anchor = 13;
    //  291  578:aload           4
    //  292  580:bipush          13
    //  293  582:putfield        #81  <Field int GridBagConstraints.anchor>
        gbC.fill = 2;
    //  294  585:aload           4
    //  295  587:iconst_2        
    //  296  588:putfield        #84  <Field int GridBagConstraints.fill>
        gbC.gridy = 1;
    //  297  591:aload           4
    //  298  593:iconst_1        
    //  299  594:putfield        #87  <Field int GridBagConstraints.gridy>
        gbC.gridx = 2;
    //  300  597:aload           4
    //  301  599:iconst_2        
    //  302  600:putfield        #90  <Field int GridBagConstraints.gridx>
        gbL.setConstraints(lab, gbC);
    //  303  603:aload_2         
    //  304  604:aload_3         
    //  305  605:aload           4
    //  306  607:invokevirtual   #94  <Method void GridBagLayout.setConstraints(java.awt.Component, GridBagConstraints)>
        simple.add(lab);
    //  307  610:aload_1         
    //  308  611:aload_3         
    //  309  612:invokevirtual   #98  <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  310  615:pop             
        gbC = new GridBagConstraints();
    //  311  616:new             #76  <Class GridBagConstraints>
    //  312  619:dup             
    //  313  620:invokespecial   #77  <Method void GridBagConstraints()>
    //  314  623:astore          4
        gbC.anchor = 17;
    //  315  625:aload           4
    //  316  627:bipush          17
    //  317  629:putfield        #81  <Field int GridBagConstraints.anchor>
        gbC.fill = 2;
    //  318  632:aload           4
    //  319  634:iconst_2        
    //  320  635:putfield        #84  <Field int GridBagConstraints.fill>
        gbC.gridy = 1;
    //  321  638:aload           4
    //  322  640:iconst_1        
    //  323  641:putfield        #87  <Field int GridBagConstraints.gridy>
        gbC.gridx = 3;
    //  324  644:aload           4
    //  325  646:iconst_3        
    //  326  647:putfield        #90  <Field int GridBagConstraints.gridx>
        gbC.weightx = 100D;
    //  327  650:aload           4
    //  328  652:ldc2w           #99  <Double 100D>
    //  329  655:putfield        #104 <Field double GridBagConstraints.weightx>
        gbL.setConstraints(m_DistinctLab, gbC);
    //  330  658:aload_2         
    //  331  659:aload_0         
    //  332  660:getfield        #45  <Field JLabel m_DistinctLab>
    //  333  663:aload           4
    //  334  665:invokevirtual   #94  <Method void GridBagLayout.setConstraints(java.awt.Component, GridBagConstraints)>
        simple.add(m_DistinctLab);
    //  335  668:aload_1         
    //  336  669:aload_0         
    //  337  670:getfield        #45  <Field JLabel m_DistinctLab>
    //  338  673:invokevirtual   #98  <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  339  676:pop             
        m_DistinctLab.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 10));
    //  340  677:aload_0         
    //  341  678:getfield        #45  <Field JLabel m_DistinctLab>
    //  342  681:iconst_0        
    //  343  682:iconst_5        
    //  344  683:iconst_5        
    //  345  684:bipush          10
    //  346  686:invokestatic    #70  <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
    //  347  689:invokevirtual   #74  <Method void JLabel.setBorder(javax.swing.border.Border)>
        lab = new JLabel("Unique:", 4);
    //  348  692:new             #32  <Class JLabel>
    //  349  695:dup             
    //  350  696:ldc1            #115 <String "Unique:">
    //  351  698:iconst_4        
    //  352  699:invokespecial   #64  <Method void JLabel(String, int)>
    //  353  702:astore_3        
        lab.setBorder(BorderFactory.createEmptyBorder(0, 10, 5, 0));
    //  354  703:aload_3         
    //  355  704:iconst_0        
    //  356  705:bipush          10
    //  357  707:iconst_5        
    //  358  708:iconst_0        
    //  359  709:invokestatic    #70  <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
    //  360  712:invokevirtual   #74  <Method void JLabel.setBorder(javax.swing.border.Border)>
        gbC = new GridBagConstraints();
    //  361  715:new             #76  <Class GridBagConstraints>
    //  362  718:dup             
    //  363  719:invokespecial   #77  <Method void GridBagConstraints()>
    //  364  722:astore          4
        gbC.anchor = 13;
    //  365  724:aload           4
    //  366  726:bipush          13
    //  367  728:putfield        #81  <Field int GridBagConstraints.anchor>
        gbC.fill = 2;
    //  368  731:aload           4
    //  369  733:iconst_2        
    //  370  734:putfield        #84  <Field int GridBagConstraints.fill>
        gbC.gridy = 1;
    //  371  737:aload           4
    //  372  739:iconst_1        
    //  373  740:putfield        #87  <Field int GridBagConstraints.gridy>
        gbC.gridx = 4;
    //  374  743:aload           4
    //  375  745:iconst_4        
    //  376  746:putfield        #90  <Field int GridBagConstraints.gridx>
        gbL.setConstraints(lab, gbC);
    //  377  749:aload_2         
    //  378  750:aload_3         
    //  379  751:aload           4
    //  380  753:invokevirtual   #94  <Method void GridBagLayout.setConstraints(java.awt.Component, GridBagConstraints)>
        simple.add(lab);
    //  381  756:aload_1         
    //  382  757:aload_3         
    //  383  758:invokevirtual   #98  <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  384  761:pop             
        gbC = new GridBagConstraints();
    //  385  762:new             #76  <Class GridBagConstraints>
    //  386  765:dup             
    //  387  766:invokespecial   #77  <Method void GridBagConstraints()>
    //  388  769:astore          4
        gbC.anchor = 17;
    //  389  771:aload           4
    //  390  773:bipush          17
    //  391  775:putfield        #81  <Field int GridBagConstraints.anchor>
        gbC.fill = 2;
    //  392  778:aload           4
    //  393  780:iconst_2        
    //  394  781:putfield        #84  <Field int GridBagConstraints.fill>
        gbC.gridy = 1;
    //  395  784:aload           4
    //  396  786:iconst_1        
    //  397  787:putfield        #87  <Field int GridBagConstraints.gridy>
        gbC.gridx = 5;
    //  398  790:aload           4
    //  399  792:iconst_5        
    //  400  793:putfield        #90  <Field int GridBagConstraints.gridx>
        gbC.weightx = 100D;
    //  401  796:aload           4
    //  402  798:ldc2w           #99  <Double 100D>
    //  403  801:putfield        #104 <Field double GridBagConstraints.weightx>
        gbL.setConstraints(m_UniqueLab, gbC);
    //  404  804:aload_2         
    //  405  805:aload_0         
    //  406  806:getfield        #43  <Field JLabel m_UniqueLab>
    //  407  809:aload           4
    //  408  811:invokevirtual   #94  <Method void GridBagLayout.setConstraints(java.awt.Component, GridBagConstraints)>
        simple.add(m_UniqueLab);
    //  409  814:aload_1         
    //  410  815:aload_0         
    //  411  816:getfield        #43  <Field JLabel m_UniqueLab>
    //  412  819:invokevirtual   #98  <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  413  822:pop             
        m_UniqueLab.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 10));
    //  414  823:aload_0         
    //  415  824:getfield        #43  <Field JLabel m_UniqueLab>
    //  416  827:iconst_0        
    //  417  828:iconst_5        
    //  418  829:iconst_5        
    //  419  830:bipush          10
    //  420  832:invokestatic    #70  <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
    //  421  835:invokevirtual   #74  <Method void JLabel.setBorder(javax.swing.border.Border)>
        setLayout(new BorderLayout());
    //  422  838:aload_0         
    //  423  839:new             #117 <Class BorderLayout>
    //  424  842:dup             
    //  425  843:invokespecial   #118 <Method void BorderLayout()>
    //  426  846:invokevirtual   #119 <Method void setLayout(java.awt.LayoutManager)>
        add(simple, "North");
    //  427  849:aload_0         
    //  428  850:aload_1         
    //  429  851:ldc1            #121 <String "North">
    //  430  853:invokevirtual   #124 <Method void add(java.awt.Component, Object)>
        add(new JScrollPane(m_StatsTable), "Center");
    //  431  856:aload_0         
    //  432  857:new             #126 <Class JScrollPane>
    //  433  860:dup             
    //  434  861:aload_0         
    //  435  862:getfield        #52  <Field JTable m_StatsTable>
    //  436  865:invokespecial   #129 <Method void JScrollPane(java.awt.Component)>
    //  437  868:ldc1            #131 <String "Center">
    //  438  870:invokevirtual   #124 <Method void add(java.awt.Component, Object)>
        m_StatsTable.getSelectionModel().setSelectionMode(0);
    //  439  873:aload_0         
    //  440  874:getfield        #52  <Field JTable m_StatsTable>
    //  441  877:invokevirtual   #137 <Method ListSelectionModel JTable.getSelectionModel()>
    //  442  880:iconst_0        
    //  443  881:invokeinterface #143 <Method void ListSelectionModel.setSelectionMode(int)>
    //  444  886:return          
    }

    public void setInstances(Instances inst)
    {
        m_Instances = inst;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #158 <Field Instances m_Instances>
        m_AttributeStats = new AttributeStats[inst.numAttributes()];
    //    3    5:aload_0         
    //    4    6:aload_1         
    //    5    7:invokevirtual   #164 <Method int Instances.numAttributes()>
    //    6   10:anewarray       AttributeStats[]
    //    7   13:putfield        #168 <Field AttributeStats[] m_AttributeStats>
        m_AttributeNameLab.setText("None");
    //    8   16:aload_0         
    //    9   17:getfield        #37  <Field JLabel m_AttributeNameLab>
    //   10   20:ldc1            #13  <String "None">
    //   11   22:invokevirtual   #171 <Method void JLabel.setText(String)>
        m_AttributeTypeLab.setText("None");
    //   12   25:aload_0         
    //   13   26:getfield        #39  <Field JLabel m_AttributeTypeLab>
    //   14   29:ldc1            #13  <String "None">
    //   15   31:invokevirtual   #171 <Method void JLabel.setText(String)>
        m_MissingLab.setText("None");
    //   16   34:aload_0         
    //   17   35:getfield        #41  <Field JLabel m_MissingLab>
    //   18   38:ldc1            #13  <String "None">
    //   19   40:invokevirtual   #171 <Method void JLabel.setText(String)>
        m_UniqueLab.setText("None");
    //   20   43:aload_0         
    //   21   44:getfield        #43  <Field JLabel m_UniqueLab>
    //   22   47:ldc1            #13  <String "None">
    //   23   49:invokevirtual   #171 <Method void JLabel.setText(String)>
        m_DistinctLab.setText("None");
    //   24   52:aload_0         
    //   25   53:getfield        #45  <Field JLabel m_DistinctLab>
    //   26   56:ldc1            #13  <String "None">
    //   27   58:invokevirtual   #171 <Method void JLabel.setText(String)>
        m_StatsTable.setModel(new DefaultTableModel());
    //   28   61:aload_0         
    //   29   62:getfield        #52  <Field JTable m_StatsTable>
    //   30   65:new             #173 <Class DefaultTableModel>
    //   31   68:dup             
    //   32   69:invokespecial   #174 <Method void DefaultTableModel()>
    //   33   72:invokevirtual   #178 <Method void JTable.setModel(javax.swing.table.TableModel)>
    //   34   75:return          
    }

    public void setAttribute(final int index)
    {
        setHeader(index);
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:invokevirtual   #183 <Method void setHeader(int)>
        if(m_AttributeStats[index] == null)
    //*   3    5:aload_0         
    //*   4    6:getfield        #168 <Field AttributeStats[] m_AttributeStats>
    //*   5    9:iload_1         
    //*   6   10:aaload          
    //*   7   11:ifnonnull       36
        {
            Thread t = new Thread() {

                public void run()
                {
                    m_AttributeStats[index] = m_Instances.attributeStats(index);
                //    0    0:aload_0         
                //    1    1:getfield        #13  <Field AttributeSummaryPanel this$0>
                //    2    4:getfield        #29  <Field AttributeStats[] AttributeSummaryPanel.m_AttributeStats>
                //    3    7:aload_0         
                //    4    8:getfield        #15  <Field int val$index>
                //    5   11:aload_0         
                //    6   12:getfield        #13  <Field AttributeSummaryPanel this$0>
                //    7   15:getfield        #33  <Field Instances AttributeSummaryPanel.m_Instances>
                //    8   18:aload_0         
                //    9   19:getfield        #15  <Field int val$index>
                //   10   22:invokevirtual   #39  <Method AttributeStats Instances.attributeStats(int)>
                //   11   25:aastore         
                    SwingUtilities.invokeLater(new Runnable() {

                        public void run()
                        {
                            setDerived(index);
                        //    0    0:aload_0         
                        //    1    1:getfield        #15  <Field AttributeSummaryPanel$2 this$1>
                        //    2    4:invokestatic    #31  <Method AttributeSummaryPanel AttributeSummaryPanel$2.access$0(AttributeSummaryPanel$2)>
                        //    3    7:aload_0         
                        //    4    8:getfield        #17  <Field int val$index>
                        //    5   11:invokevirtual   #37  <Method void AttributeSummaryPanel.setDerived(int)>
                            m_StatsTable.sizeColumnsToFit(-1);
                        //    6   14:aload_0         
                        //    7   15:getfield        #15  <Field AttributeSummaryPanel$2 this$1>
                        //    8   18:invokestatic    #31  <Method AttributeSummaryPanel AttributeSummaryPanel$2.access$0(AttributeSummaryPanel$2)>
                        //    9   21:getfield        #41  <Field JTable AttributeSummaryPanel.m_StatsTable>
                        //   10   24:iconst_m1       
                        //   11   25:invokevirtual   #46  <Method void JTable.sizeColumnsToFit(int)>
                            m_StatsTable.revalidate();
                        //   12   28:aload_0         
                        //   13   29:getfield        #15  <Field AttributeSummaryPanel$2 this$1>
                        //   14   32:invokestatic    #31  <Method AttributeSummaryPanel AttributeSummaryPanel$2.access$0(AttributeSummaryPanel$2)>
                        //   15   35:getfield        #41  <Field JTable AttributeSummaryPanel.m_StatsTable>
                        //   16   38:invokevirtual   #49  <Method void JTable.revalidate()>
                            m_StatsTable.repaint();
                        //   17   41:aload_0         
                        //   18   42:getfield        #15  <Field AttributeSummaryPanel$2 this$1>
                        //   19   45:invokestatic    #31  <Method AttributeSummaryPanel AttributeSummaryPanel$2.access$0(AttributeSummaryPanel$2)>
                        //   20   48:getfield        #41  <Field JTable AttributeSummaryPanel.m_StatsTable>
                        //   21   51:invokevirtual   #52  <Method void JTable.repaint()>
                        //   22   54:return          
                        }

                        final _cls2 this$1;
                        private final int val$index;

                    
                    {
                        this$1 = _cls2.this;
                    //    0    0:aload_0         
                    //    1    1:aload_1         
                    //    2    2:putfield        #15  <Field AttributeSummaryPanel$2 this$1>
                        index = i;
                    //    3    5:aload_0         
                    //    4    6:iload_2         
                    //    5    7:putfield        #17  <Field int val$index>
                        super();
                    //    6   10:aload_0         
                    //    7   11:invokespecial   #20  <Method void Object()>
                    //    8   14:return          
                    }
                    }
);
                //   12   26:new             #41  <Class AttributeSummaryPanel$3>
                //   13   29:dup             
                //   14   30:aload_0         
                //   15   31:aload_0         
                //   16   32:getfield        #15  <Field int val$index>
                //   17   35:invokespecial   #44  <Method void AttributeSummaryPanel$3(AttributeSummaryPanel$2, int)>
                //   18   38:invokestatic    #50  <Method void SwingUtilities.invokeLater(Runnable)>
                //   19   41:return          
                }

                final AttributeSummaryPanel this$0;
                private final int val$index;


/*
            static AttributeSummaryPanel access$0(_cls2 _pcls2)
            {
                return _pcls2.this$0;
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field AttributeSummaryPanel this$0>
            //    2    4:areturn         
            }

*/

            
            {
                this$0 = AttributeSummaryPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field AttributeSummaryPanel this$0>
                index = i;
            //    3    5:aload_0         
            //    4    6:iload_2         
            //    5    7:putfield        #15  <Field int val$index>
                super();
            //    6   10:aload_0         
            //    7   11:invokespecial   #18  <Method void Thread()>
            //    8   14:return          
            }
            }
;
    //    8   14:new             #185 <Class AttributeSummaryPanel$2>
    //    9   17:dup             
    //   10   18:aload_0         
    //   11   19:iload_1         
    //   12   20:invokespecial   #188 <Method void AttributeSummaryPanel$2(AttributeSummaryPanel, int)>
    //   13   23:astore_2        
            t.setPriority(1);
    //   14   24:aload_2         
    //   15   25:iconst_1        
    //   16   26:invokevirtual   #193 <Method void Thread.setPriority(int)>
            t.start();
    //   17   29:aload_2         
    //   18   30:invokevirtual   #196 <Method void Thread.start()>
        } else
    //*  19   33:goto            41
        {
            setDerived(index);
    //   20   36:aload_0         
    //   21   37:iload_1         
    //   22   38:invokevirtual   #199 <Method void setDerived(int)>
        }
    //   23   41:return          
    }

    protected void setDerived(int index)
    {
        AttributeStats as = m_AttributeStats[index];
    //    0    0:aload_0         
    //    1    1:getfield        #168 <Field AttributeStats[] m_AttributeStats>
    //    2    4:iload_1         
    //    3    5:aaload          
    //    4    6:astore_2        
        long percent = Math.round((100D * (double)as.missingCount) / (double)as.totalCount);
    //    5    7:ldc2w           #99  <Double 100D>
    //    6   10:aload_2         
    //    7   11:getfield        #205 <Field int AttributeStats.missingCount>
    //    8   14:i2d             
    //    9   15:dmul            
    //   10   16:aload_2         
    //   11   17:getfield        #208 <Field int AttributeStats.totalCount>
    //   12   20:i2d             
    //   13   21:ddiv            
    //   14   22:invokestatic    #214 <Method long Math.round(double)>
    //   15   25:lstore_3        
        m_MissingLab.setText((new StringBuilder()).append(as.missingCount).append(" (").append(percent).append("%)").toString());
    //   16   26:aload_0         
    //   17   27:getfield        #41  <Field JLabel m_MissingLab>
    //   18   30:new             #216 <Class StringBuilder>
    //   19   33:dup             
    //   20   34:invokespecial   #217 <Method void StringBuilder()>
    //   21   37:aload_2         
    //   22   38:getfield        #205 <Field int AttributeStats.missingCount>
    //   23   41:invokevirtual   #221 <Method StringBuilder StringBuilder.append(int)>
    //   24   44:ldc1            #223 <String " (">
    //   25   46:invokevirtual   #226 <Method StringBuilder StringBuilder.append(String)>
    //   26   49:lload_3         
    //   27   50:invokevirtual   #229 <Method StringBuilder StringBuilder.append(long)>
    //   28   53:ldc1            #231 <String "%)">
    //   29   55:invokevirtual   #226 <Method StringBuilder StringBuilder.append(String)>
    //   30   58:invokevirtual   #235 <Method String StringBuilder.toString()>
    //   31   61:invokevirtual   #171 <Method void JLabel.setText(String)>
        percent = Math.round((100D * (double)as.uniqueCount) / (double)as.totalCount);
    //   32   64:ldc2w           #99  <Double 100D>
    //   33   67:aload_2         
    //   34   68:getfield        #238 <Field int AttributeStats.uniqueCount>
    //   35   71:i2d             
    //   36   72:dmul            
    //   37   73:aload_2         
    //   38   74:getfield        #208 <Field int AttributeStats.totalCount>
    //   39   77:i2d             
    //   40   78:ddiv            
    //   41   79:invokestatic    #214 <Method long Math.round(double)>
    //   42   82:lstore_3        
        m_UniqueLab.setText((new StringBuilder()).append(as.uniqueCount).append(" (").append(percent).append("%)").toString());
    //   43   83:aload_0         
    //   44   84:getfield        #43  <Field JLabel m_UniqueLab>
    //   45   87:new             #216 <Class StringBuilder>
    //   46   90:dup             
    //   47   91:invokespecial   #217 <Method void StringBuilder()>
    //   48   94:aload_2         
    //   49   95:getfield        #238 <Field int AttributeStats.uniqueCount>
    //   50   98:invokevirtual   #221 <Method StringBuilder StringBuilder.append(int)>
    //   51  101:ldc1            #223 <String " (">
    //   52  103:invokevirtual   #226 <Method StringBuilder StringBuilder.append(String)>
    //   53  106:lload_3         
    //   54  107:invokevirtual   #229 <Method StringBuilder StringBuilder.append(long)>
    //   55  110:ldc1            #231 <String "%)">
    //   56  112:invokevirtual   #226 <Method StringBuilder StringBuilder.append(String)>
    //   57  115:invokevirtual   #235 <Method String StringBuilder.toString()>
    //   58  118:invokevirtual   #171 <Method void JLabel.setText(String)>
        m_DistinctLab.setText((new StringBuilder()).append(as.distinctCount).toString());
    //   59  121:aload_0         
    //   60  122:getfield        #45  <Field JLabel m_DistinctLab>
    //   61  125:new             #216 <Class StringBuilder>
    //   62  128:dup             
    //   63  129:invokespecial   #217 <Method void StringBuilder()>
    //   64  132:aload_2         
    //   65  133:getfield        #241 <Field int AttributeStats.distinctCount>
    //   66  136:invokevirtual   #221 <Method StringBuilder StringBuilder.append(int)>
    //   67  139:invokevirtual   #235 <Method String StringBuilder.toString()>
    //   68  142:invokevirtual   #171 <Method void JLabel.setText(String)>
        setTable(as, index);
    //   69  145:aload_0         
    //   70  146:aload_2         
    //   71  147:iload_1         
    //   72  148:invokevirtual   #245 <Method void setTable(AttributeStats, int)>
    //   73  151:return          
    }

    protected void setTable(AttributeStats as, int index)
    {
        if(as.nominalCounts != null)
    //*   0    0:aload_1         
    //*   1    1:getfield        #252 <Field int[] AttributeStats.nominalCounts>
    //*   2    4:ifnull          195
        {
            Attribute att = m_Instances.attribute(index);
    //    3    7:aload_0         
    //    4    8:getfield        #158 <Field Instances m_Instances>
    //    5   11:iload_2         
    //    6   12:invokevirtual   #256 <Method Attribute Instances.attribute(int)>
    //    7   15:astore_3        
            Object colNames[] = {
                "No.", "Label", "Count"
            };
    //    8   16:iconst_3        
    //    9   17:anewarray       Object[]
    //   10   20:dup             
    //   11   21:iconst_0        
    //   12   22:ldc2            #260 <String "No.">
    //   13   25:aastore         
    //   14   26:dup             
    //   15   27:iconst_1        
    //   16   28:ldc2            #262 <String "Label">
    //   17   31:aastore         
    //   18   32:dup             
    //   19   33:iconst_2        
    //   20   34:ldc2            #264 <String "Count">
    //   21   37:aastore         
    //   22   38:astore          4
            Object data[][] = new Object[as.nominalCounts.length][3];
    //   23   40:aload_1         
    //   24   41:getfield        #252 <Field int[] AttributeStats.nominalCounts>
    //   25   44:arraylength     
    //   26   45:iconst_3        
    //   27   46:multianewarray  Object[][]
    //   28   50:astore          5
            for(int i = 0; i < as.nominalCounts.length; i++)
    //*  29   52:iconst_0        
    //*  30   53:istore          6
    //*  31   55:goto            113
            {
                data[i][0] = new Integer(i + 1);
    //   32   58:aload           5
    //   33   60:iload           6
    //   34   62:aaload          
    //   35   63:iconst_0        
    //   36   64:new             #268 <Class Integer>
    //   37   67:dup             
    //   38   68:iload           6
    //   39   70:iconst_1        
    //   40   71:iadd            
    //   41   72:invokespecial   #270 <Method void Integer(int)>
    //   42   75:aastore         
                data[i][1] = att.value(i);
    //   43   76:aload           5
    //   44   78:iload           6
    //   45   80:aaload          
    //   46   81:iconst_1        
    //   47   82:aload_3         
    //   48   83:iload           6
    //   49   85:invokevirtual   #276 <Method String Attribute.value(int)>
    //   50   88:aastore         
                data[i][2] = new Integer(as.nominalCounts[i]);
    //   51   89:aload           5
    //   52   91:iload           6
    //   53   93:aaload          
    //   54   94:iconst_2        
    //   55   95:new             #268 <Class Integer>
    //   56   98:dup             
    //   57   99:aload_1         
    //   58  100:getfield        #252 <Field int[] AttributeStats.nominalCounts>
    //   59  103:iload           6
    //   60  105:iaload          
    //   61  106:invokespecial   #270 <Method void Integer(int)>
    //   62  109:aastore         
            }

    //   63  110:iinc            6  1
    //   64  113:iload           6
    //   65  115:aload_1         
    //   66  116:getfield        #252 <Field int[] AttributeStats.nominalCounts>
    //   67  119:arraylength     
    //   68  120:icmplt          58
            m_StatsTable.setModel(new DefaultTableModel(data, colNames));
    //   69  123:aload_0         
    //   70  124:getfield        #52  <Field JTable m_StatsTable>
    //   71  127:new             #173 <Class DefaultTableModel>
    //   72  130:dup             
    //   73  131:aload           5
    //   74  133:aload           4
    //   75  135:invokespecial   #279 <Method void DefaultTableModel(Object[][], Object[])>
    //   76  138:invokevirtual   #178 <Method void JTable.setModel(javax.swing.table.TableModel)>
            m_StatsTable.getColumnModel().getColumn(0).setMaxWidth(60);
    //   77  141:aload_0         
    //   78  142:getfield        #52  <Field JTable m_StatsTable>
    //   79  145:invokevirtual   #283 <Method TableColumnModel JTable.getColumnModel()>
    //   80  148:iconst_0        
    //   81  149:invokeinterface #289 <Method TableColumn TableColumnModel.getColumn(int)>
    //   82  154:bipush          60
    //   83  156:invokevirtual   #294 <Method void TableColumn.setMaxWidth(int)>
            DefaultTableCellRenderer tempR = new DefaultTableCellRenderer();
    //   84  159:new             #296 <Class DefaultTableCellRenderer>
    //   85  162:dup             
    //   86  163:invokespecial   #297 <Method void DefaultTableCellRenderer()>
    //   87  166:astore          6
            tempR.setHorizontalAlignment(4);
    //   88  168:aload           6
    //   89  170:iconst_4        
    //   90  171:invokevirtual   #300 <Method void DefaultTableCellRenderer.setHorizontalAlignment(int)>
            m_StatsTable.getColumnModel().getColumn(0).setCellRenderer(tempR);
    //   91  174:aload_0         
    //   92  175:getfield        #52  <Field JTable m_StatsTable>
    //   93  178:invokevirtual   #283 <Method TableColumnModel JTable.getColumnModel()>
    //   94  181:iconst_0        
    //   95  182:invokeinterface #289 <Method TableColumn TableColumnModel.getColumn(int)>
    //   96  187:aload           6
    //   97  189:invokevirtual   #304 <Method void TableColumn.setCellRenderer(javax.swing.table.TableCellRenderer)>
        } else
    //*  98  192:goto            365
        if(as.numericStats != null)
    //*  99  195:aload_1         
    //* 100  196:getfield        #308 <Field Stats AttributeStats.numericStats>
    //* 101  199:ifnull          351
        {
            Object colNames[] = {
                "Statistic", "Value"
            };
    //  102  202:iconst_2        
    //  103  203:anewarray       Object[]
    //  104  206:dup             
    //  105  207:iconst_0        
    //  106  208:ldc2            #310 <String "Statistic">
    //  107  211:aastore         
    //  108  212:dup             
    //  109  213:iconst_1        
    //  110  214:ldc2            #312 <String "Value">
    //  111  217:aastore         
    //  112  218:astore_3        
            Object data[][] = new Object[4][2];
    //  113  219:iconst_4        
    //  114  220:iconst_2        
    //  115  221:multianewarray  Object[][]
    //  116  225:astore          4
            data[0][0] = "Minimum";
    //  117  227:aload           4
    //  118  229:iconst_0        
    //  119  230:aaload          
    //  120  231:iconst_0        
    //  121  232:ldc2            #314 <String "Minimum">
    //  122  235:aastore         
            data[0][1] = Utils.doubleToString(as.numericStats.min, 3);
    //  123  236:aload           4
    //  124  238:iconst_0        
    //  125  239:aaload          
    //  126  240:iconst_1        
    //  127  241:aload_1         
    //  128  242:getfield        #308 <Field Stats AttributeStats.numericStats>
    //  129  245:getfield        #319 <Field double Stats.min>
    //  130  248:iconst_3        
    //  131  249:invokestatic    #325 <Method String Utils.doubleToString(double, int)>
    //  132  252:aastore         
            data[1][0] = "Maximum";
    //  133  253:aload           4
    //  134  255:iconst_1        
    //  135  256:aaload          
    //  136  257:iconst_0        
    //  137  258:ldc2            #327 <String "Maximum">
    //  138  261:aastore         
            data[1][1] = Utils.doubleToString(as.numericStats.max, 3);
    //  139  262:aload           4
    //  140  264:iconst_1        
    //  141  265:aaload          
    //  142  266:iconst_1        
    //  143  267:aload_1         
    //  144  268:getfield        #308 <Field Stats AttributeStats.numericStats>
    //  145  271:getfield        #330 <Field double Stats.max>
    //  146  274:iconst_3        
    //  147  275:invokestatic    #325 <Method String Utils.doubleToString(double, int)>
    //  148  278:aastore         
            data[2][0] = "Mean";
    //  149  279:aload           4
    //  150  281:iconst_2        
    //  151  282:aaload          
    //  152  283:iconst_0        
    //  153  284:ldc2            #332 <String "Mean">
    //  154  287:aastore         
            data[2][1] = Utils.doubleToString(as.numericStats.mean, 3);
    //  155  288:aload           4
    //  156  290:iconst_2        
    //  157  291:aaload          
    //  158  292:iconst_1        
    //  159  293:aload_1         
    //  160  294:getfield        #308 <Field Stats AttributeStats.numericStats>
    //  161  297:getfield        #335 <Field double Stats.mean>
    //  162  300:iconst_3        
    //  163  301:invokestatic    #325 <Method String Utils.doubleToString(double, int)>
    //  164  304:aastore         
            data[3][0] = "StdDev";
    //  165  305:aload           4
    //  166  307:iconst_3        
    //  167  308:aaload          
    //  168  309:iconst_0        
    //  169  310:ldc2            #337 <String "StdDev">
    //  170  313:aastore         
            data[3][1] = Utils.doubleToString(as.numericStats.stdDev, 3);
    //  171  314:aload           4
    //  172  316:iconst_3        
    //  173  317:aaload          
    //  174  318:iconst_1        
    //  175  319:aload_1         
    //  176  320:getfield        #308 <Field Stats AttributeStats.numericStats>
    //  177  323:getfield        #340 <Field double Stats.stdDev>
    //  178  326:iconst_3        
    //  179  327:invokestatic    #325 <Method String Utils.doubleToString(double, int)>
    //  180  330:aastore         
            m_StatsTable.setModel(new DefaultTableModel(data, colNames));
    //  181  331:aload_0         
    //  182  332:getfield        #52  <Field JTable m_StatsTable>
    //  183  335:new             #173 <Class DefaultTableModel>
    //  184  338:dup             
    //  185  339:aload           4
    //  186  341:aload_3         
    //  187  342:invokespecial   #279 <Method void DefaultTableModel(Object[][], Object[])>
    //  188  345:invokevirtual   #178 <Method void JTable.setModel(javax.swing.table.TableModel)>
        } else
    //* 189  348:goto            365
        {
            m_StatsTable.setModel(new DefaultTableModel());
    //  190  351:aload_0         
    //  191  352:getfield        #52  <Field JTable m_StatsTable>
    //  192  355:new             #173 <Class DefaultTableModel>
    //  193  358:dup             
    //  194  359:invokespecial   #174 <Method void DefaultTableModel()>
    //  195  362:invokevirtual   #178 <Method void JTable.setModel(javax.swing.table.TableModel)>
        }
        m_StatsTable.getColumnModel().setColumnMargin(4);
    //  196  365:aload_0         
    //  197  366:getfield        #52  <Field JTable m_StatsTable>
    //  198  369:invokevirtual   #283 <Method TableColumnModel JTable.getColumnModel()>
    //  199  372:iconst_4        
    //  200  373:invokeinterface #343 <Method void TableColumnModel.setColumnMargin(int)>
    //  201  378:return          
    }

    protected void setHeader(int index)
    {
        Attribute att = m_Instances.attribute(index);
    //    0    0:aload_0         
    //    1    1:getfield        #158 <Field Instances m_Instances>
    //    2    4:iload_1         
    //    3    5:invokevirtual   #256 <Method Attribute Instances.attribute(int)>
    //    4    8:astore_2        
        m_AttributeNameLab.setText(att.name());
    //    5    9:aload_0         
    //    6   10:getfield        #37  <Field JLabel m_AttributeNameLab>
    //    7   13:aload_2         
    //    8   14:invokevirtual   #354 <Method String Attribute.name()>
    //    9   17:invokevirtual   #171 <Method void JLabel.setText(String)>
        switch(att.type())
    //*  10   20:aload_2         
    //*  11   21:invokevirtual   #357 <Method int Attribute.type()>
        {
    //*  12   24:tableswitch     0 4: default 125
    //                   0 73
    //                   1 60
    //                   2 86
    //                   3 99
    //                   4 112
        case 1: // '\001'
            m_AttributeTypeLab.setText("Nominal");
    //   13   60:aload_0         
    //   14   61:getfield        #39  <Field JLabel m_AttributeTypeLab>
    //   15   64:ldc2            #359 <String "Nominal">
    //   16   67:invokevirtual   #171 <Method void JLabel.setText(String)>
            break;

    //*  17   70:goto            135
        case 0: // '\0'
            m_AttributeTypeLab.setText("Numeric");
    //   18   73:aload_0         
    //   19   74:getfield        #39  <Field JLabel m_AttributeTypeLab>
    //   20   77:ldc2            #361 <String "Numeric">
    //   21   80:invokevirtual   #171 <Method void JLabel.setText(String)>
            break;

    //*  22   83:goto            135
        case 2: // '\002'
            m_AttributeTypeLab.setText("String");
    //   23   86:aload_0         
    //   24   87:getfield        #39  <Field JLabel m_AttributeTypeLab>
    //   25   90:ldc2            #363 <String "String">
    //   26   93:invokevirtual   #171 <Method void JLabel.setText(String)>
            break;

    //*  27   96:goto            135
        case 3: // '\003'
            m_AttributeTypeLab.setText("Date");
    //   28   99:aload_0         
    //   29  100:getfield        #39  <Field JLabel m_AttributeTypeLab>
    //   30  103:ldc2            #365 <String "Date">
    //   31  106:invokevirtual   #171 <Method void JLabel.setText(String)>
            break;

    //*  32  109:goto            135
        case 4: // '\004'
            m_AttributeTypeLab.setText("Relational");
    //   33  112:aload_0         
    //   34  113:getfield        #39  <Field JLabel m_AttributeTypeLab>
    //   35  116:ldc2            #367 <String "Relational">
    //   36  119:invokevirtual   #171 <Method void JLabel.setText(String)>
            break;

    //*  37  122:goto            135
        default:
            m_AttributeTypeLab.setText("Unknown");
    //   38  125:aload_0         
    //   39  126:getfield        #39  <Field JLabel m_AttributeTypeLab>
    //   40  129:ldc2            #369 <String "Unknown">
    //   41  132:invokevirtual   #171 <Method void JLabel.setText(String)>
            break;
        }
        m_MissingLab.setText("...");
    //   42  135:aload_0         
    //   43  136:getfield        #41  <Field JLabel m_MissingLab>
    //   44  139:ldc2            #371 <String "...">
    //   45  142:invokevirtual   #171 <Method void JLabel.setText(String)>
        m_UniqueLab.setText("...");
    //   46  145:aload_0         
    //   47  146:getfield        #43  <Field JLabel m_UniqueLab>
    //   48  149:ldc2            #371 <String "...">
    //   49  152:invokevirtual   #171 <Method void JLabel.setText(String)>
        m_DistinctLab.setText("...");
    //   50  155:aload_0         
    //   51  156:getfield        #45  <Field JLabel m_DistinctLab>
    //   52  159:ldc2            #371 <String "...">
    //   53  162:invokevirtual   #171 <Method void JLabel.setText(String)>
    //   54  165:return          
    }

    public static void main(String args[])
    {
        try
        {
            final JFrame jf = new JFrame("Attribute Panel");
    //    0    0:new             #375 <Class JFrame>
    //    1    3:dup             
    //    2    4:ldc2            #377 <String "Attribute Panel">
    //    3    7:invokespecial   #378 <Method void JFrame(String)>
    //    4   10:astore_1        
            jf.getContentPane().setLayout(new BorderLayout());
    //    5   11:aload_1         
    //    6   12:invokevirtual   #382 <Method Container JFrame.getContentPane()>
    //    7   15:new             #117 <Class BorderLayout>
    //    8   18:dup             
    //    9   19:invokespecial   #118 <Method void BorderLayout()>
    //   10   22:invokevirtual   #385 <Method void Container.setLayout(java.awt.LayoutManager)>
            final AttributeSummaryPanel p = new AttributeSummaryPanel();
    //   11   25:new             #2   <Class AttributeSummaryPanel>
    //   12   28:dup             
    //   13   29:invokespecial   #386 <Method void AttributeSummaryPanel()>
    //   14   32:astore_2        
            p.setBorder(BorderFactory.createTitledBorder("Attribute"));
    //   15   33:aload_2         
    //   16   34:ldc2            #388 <String "Attribute">
    //   17   37:invokestatic    #392 <Method javax.swing.border.TitledBorder BorderFactory.createTitledBorder(String)>
    //   18   40:invokevirtual   #393 <Method void setBorder(javax.swing.border.Border)>
            jf.getContentPane().add(p, "Center");
    //   19   43:aload_1         
    //   20   44:invokevirtual   #382 <Method Container JFrame.getContentPane()>
    //   21   47:aload_2         
    //   22   48:ldc1            #131 <String "Center">
    //   23   50:invokevirtual   #394 <Method void Container.add(java.awt.Component, Object)>
            final JComboBox j = new JComboBox();
    //   24   53:new             #396 <Class JComboBox>
    //   25   56:dup             
    //   26   57:invokespecial   #397 <Method void JComboBox()>
    //   27   60:astore_3        
            j.setEnabled(false);
    //   28   61:aload_3         
    //   29   62:iconst_0        
    //   30   63:invokevirtual   #401 <Method void JComboBox.setEnabled(boolean)>
            j.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e)
                {
                    p.setAttribute(j.getSelectedIndex());
                //    0    0:aload_0         
                //    1    1:getfield        #15  <Field AttributeSummaryPanel val$p>
                //    2    4:aload_0         
                //    3    5:getfield        #17  <Field JComboBox val$j>
                //    4    8:invokevirtual   #32  <Method int JComboBox.getSelectedIndex()>
                //    5   11:invokevirtual   #38  <Method void AttributeSummaryPanel.setAttribute(int)>
                //    6   14:return          
                }

                private final AttributeSummaryPanel val$p;
                private final JComboBox val$j;

            
            {
                p = attributesummarypanel;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #15  <Field AttributeSummaryPanel val$p>
                j = jcombobox;
            //    3    5:aload_0         
            //    4    6:aload_2         
            //    5    7:putfield        #17  <Field JComboBox val$j>
                super();
            //    6   10:aload_0         
            //    7   11:invokespecial   #20  <Method void Object()>
            //    8   14:return          
            }
            }
);
    //   31   66:aload_3         
    //   32   67:new             #403 <Class AttributeSummaryPanel$4>
    //   33   70:dup             
    //   34   71:aload_2         
    //   35   72:aload_3         
    //   36   73:invokespecial   #406 <Method void AttributeSummaryPanel$4(AttributeSummaryPanel, JComboBox)>
    //   37   76:invokevirtual   #410 <Method void JComboBox.addActionListener(ActionListener)>
            jf.getContentPane().add(j, "North");
    //   38   79:aload_1         
    //   39   80:invokevirtual   #382 <Method Container JFrame.getContentPane()>
    //   40   83:aload_3         
    //   41   84:ldc1            #121 <String "North">
    //   42   86:invokevirtual   #394 <Method void Container.add(java.awt.Component, Object)>
            jf.addWindowListener(new WindowAdapter() {

                public void windowClosing(WindowEvent e)
                {
                    jf.dispose();
                //    0    0:aload_0         
                //    1    1:getfield        #11  <Field JFrame val$jf>
                //    2    4:invokevirtual   #25  <Method void JFrame.dispose()>
                    System.exit(0);
                //    3    7:iconst_0        
                //    4    8:invokestatic    #31  <Method void System.exit(int)>
                //    5   11:return          
                }

                private final JFrame val$jf;

            
            {
                jf = jframe;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #11  <Field JFrame val$jf>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #14  <Method void WindowAdapter()>
            //    5    9:return          
            }
            }
);
    //   43   89:aload_1         
    //   44   90:new             #412 <Class AttributeSummaryPanel$5>
    //   45   93:dup             
    //   46   94:aload_1         
    //   47   95:invokespecial   #415 <Method void AttributeSummaryPanel$5(JFrame)>
    //   48   98:invokevirtual   #419 <Method void JFrame.addWindowListener(java.awt.event.WindowListener)>
            jf.pack();
    //   49  101:aload_1         
    //   50  102:invokevirtual   #422 <Method void JFrame.pack()>
            jf.setVisible(true);
    //   51  105:aload_1         
    //   52  106:iconst_1        
    //   53  107:invokevirtual   #425 <Method void JFrame.setVisible(boolean)>
            if(args.length == 1)
    //*  54  110:aload_0         
    //*  55  111:arraylength     
    //*  56  112:iconst_1        
    //*  57  113:icmpne          235
            {
                java.io.Reader r = new BufferedReader(new FileReader(args[0]));
    //   58  116:new             #427 <Class BufferedReader>
    //   59  119:dup             
    //   60  120:new             #429 <Class FileReader>
    //   61  123:dup             
    //   62  124:aload_0         
    //   63  125:iconst_0        
    //   64  126:aaload          
    //   65  127:invokespecial   #430 <Method void FileReader(String)>
    //   66  130:invokespecial   #433 <Method void BufferedReader(java.io.Reader)>
    //   67  133:astore          4
                Instances inst = new Instances(r);
    //   68  135:new             #160 <Class Instances>
    //   69  138:dup             
    //   70  139:aload           4
    //   71  141:invokespecial   #434 <Method void Instances(java.io.Reader)>
    //   72  144:astore          5
                p.setInstances(inst);
    //   73  146:aload_2         
    //   74  147:aload           5
    //   75  149:invokevirtual   #436 <Method void setInstances(Instances)>
                p.setAttribute(0);
    //   76  152:aload_2         
    //   77  153:iconst_0        
    //   78  154:invokevirtual   #438 <Method void setAttribute(int)>
                String names[] = new String[inst.numAttributes()];
    //   79  157:aload           5
    //   80  159:invokevirtual   #164 <Method int Instances.numAttributes()>
    //   81  162:anewarray       String[]
    //   82  165:astore          6
                for(int i = 0; i < names.length; i++)
    //*  83  167:iconst_0        
    //*  84  168:istore          7
    //*  85  170:goto            191
                    names[i] = inst.attribute(i).name();
    //   86  173:aload           6
    //   87  175:iload           7
    //   88  177:aload           5
    //   89  179:iload           7
    //   90  181:invokevirtual   #256 <Method Attribute Instances.attribute(int)>
    //   91  184:invokevirtual   #354 <Method String Attribute.name()>
    //   92  187:aastore         

    //   93  188:iinc            7  1
    //   94  191:iload           7
    //   95  193:aload           6
    //   96  195:arraylength     
    //   97  196:icmplt          173
                j.setModel(new DefaultComboBoxModel(names));
    //   98  199:aload_3         
    //   99  200:new             #442 <Class DefaultComboBoxModel>
    //  100  203:dup             
    //  101  204:aload           6
    //  102  206:invokespecial   #445 <Method void DefaultComboBoxModel(Object[])>
    //  103  209:invokevirtual   #448 <Method void JComboBox.setModel(javax.swing.ComboBoxModel)>
                j.setEnabled(true);
    //  104  212:aload_3         
    //  105  213:iconst_1        
    //  106  214:invokevirtual   #401 <Method void JComboBox.setEnabled(boolean)>
            }
        }
    //* 107  217:goto            235
        catch(Exception ex)
    //* 108  220:astore_1        
        {
            ex.printStackTrace();
    //  109  221:aload_1         
    //  110  222:invokevirtual   #453 <Method void Exception.printStackTrace()>
            System.err.println(ex.getMessage());
    //  111  225:getstatic       #459 <Field PrintStream System.err>
    //  112  228:aload_1         
    //  113  229:invokevirtual   #462 <Method String Exception.getMessage()>
    //  114  232:invokevirtual   #467 <Method void PrintStream.println(String)>
        }
    //  115  235:return          
    }

    static final long serialVersionUID = 0xb4930b46ffdd7938L;
    protected static final String NO_SOURCE = "None";
    protected JLabel m_AttributeNameLab;
    protected JLabel m_AttributeTypeLab;
    protected JLabel m_MissingLab;
    protected JLabel m_UniqueLab;
    protected JLabel m_DistinctLab;
    protected JTable m_StatsTable;
    protected Instances m_Instances;
    protected AttributeStats m_AttributeStats[];
}
