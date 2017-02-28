// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   AttributePanel.java

package rm.gui.visualize;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Properties;
import javax.swing.*;
import rm.core.*;

// Referenced classes of package rm.gui.visualize:
//            VisualizeUtils, Plot2D, AttributePanelListener, AttributePanelEvent

public class AttributePanel extends JScrollPane
{
    protected class AttributeSpacing extends JPanel
    {

        private double convertToPanel(double val)
        {
            double temp = (val - m_minVal) / (m_maxVal - m_minVal);
        //    0    0:dload_1         
        //    1    1:aload_0         
        //    2    2:getfield        #87  <Field double m_minVal>
        //    3    5:dsub            
        //    4    6:aload_0         
        //    5    7:getfield        #92  <Field double m_maxVal>
        //    6   10:aload_0         
        //    7   11:getfield        #87  <Field double m_minVal>
        //    8   14:dsub            
        //    9   15:ddiv            
        //   10   16:dstore_3        
            double temp2 = temp * (double)(getWidth() - 10);
        //   11   17:dload_3         
        //   12   18:aload_0         
        //   13   19:invokevirtual   #131 <Method int getWidth()>
        //   14   22:bipush          10
        //   15   24:isub            
        //   16   25:i2d             
        //   17   26:dmul            
        //   18   27:dstore          5
            return temp2 + 4D;
        //   19   29:dload           5
        //   20   31:ldc2w           #132 <Double 4D>
        //   21   34:dadd            
        //   22   35:dreturn         
        }

        public void paintComponent(Graphics gx)
        {
            super.paintComponent(gx);
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:invokespecial   #140 <Method void JPanel.paintComponent(Graphics)>
            int h = getWidth();
        //    3    5:aload_0         
        //    4    6:invokevirtual   #131 <Method int getWidth()>
        //    5    9:istore          4
            if(m_plotInstances != null && m_plotInstances.numAttributes() > 0 && m_plotInstances.numInstances() > 0)
        //*   6   11:aload_0         
        //*   7   12:getfield        #28  <Field AttributePanel this$0>
        //*   8   15:getfield        #63  <Field Instances AttributePanel.m_plotInstances>
        //*   9   18:ifnull          617
        //*  10   21:aload_0         
        //*  11   22:getfield        #28  <Field AttributePanel this$0>
        //*  12   25:getfield        #63  <Field Instances AttributePanel.m_plotInstances>
        //*  13   28:invokevirtual   #143 <Method int Instances.numAttributes()>
        //*  14   31:ifle            617
        //*  15   34:aload_0         
        //*  16   35:getfield        #28  <Field AttributePanel this$0>
        //*  17   38:getfield        #63  <Field Instances AttributePanel.m_plotInstances>
        //*  18   41:invokevirtual   #69  <Method int Instances.numInstances()>
        //*  19   44:ifle            617
            {
                if(m_oldWidth != h)
        //*  20   47:aload_0         
        //*  21   48:getfield        #33  <Field int m_oldWidth>
        //*  22   51:iload           4
        //*  23   53:icmpeq          258
                {
                    m_pointDrawn = new boolean[h][20];
        //   24   56:aload_0         
        //   25   57:iload           4
        //   26   59:bipush          20
        //   27   61:multianewarray  boolean[][]
        //   28   65:putfield        #146 <Field boolean[][] m_pointDrawn>
                    for(int noa = 0; noa < m_plotInstances.numInstances(); noa++)
        //*  29   68:iconst_0        
        //*  30   69:istore          5
        //*  31   71:goto            237
                        if(!m_plotInstances.instance(noa).isMissing(m_attribIndex) && !m_plotInstances.instance(noa).isMissing(m_cIndex))
        //*  32   74:aload_0         
        //*  33   75:getfield        #28  <Field AttributePanel this$0>
        //*  34   78:getfield        #63  <Field Instances AttributePanel.m_plotInstances>
        //*  35   81:iload           5
        //*  36   83:invokevirtual   #96  <Method Instance Instances.instance(int)>
        //*  37   86:aload_0         
        //*  38   87:getfield        #37  <Field int m_attribIndex>
        //*  39   90:invokevirtual   #102 <Method boolean Instance.isMissing(int)>
        //*  40   93:ifne            224
        //*  41   96:aload_0         
        //*  42   97:getfield        #28  <Field AttributePanel this$0>
        //*  43  100:getfield        #63  <Field Instances AttributePanel.m_plotInstances>
        //*  44  103:iload           5
        //*  45  105:invokevirtual   #96  <Method Instance Instances.instance(int)>
        //*  46  108:aload_0         
        //*  47  109:getfield        #28  <Field AttributePanel this$0>
        //*  48  112:getfield        #149 <Field int AttributePanel.m_cIndex>
        //*  49  115:invokevirtual   #102 <Method boolean Instance.isMissing(int)>
        //*  50  118:ifne            224
                        {
                            m_cached[noa] = (int)convertToPanel(m_plotInstances.instance(noa).value(m_attribIndex));
        //   51  121:aload_0         
        //   52  122:getfield        #71  <Field int[] m_cached>
        //   53  125:iload           5
        //   54  127:aload_0         
        //   55  128:aload_0         
        //   56  129:getfield        #28  <Field AttributePanel this$0>
        //   57  132:getfield        #63  <Field Instances AttributePanel.m_plotInstances>
        //   58  135:iload           5
        //   59  137:invokevirtual   #96  <Method Instance Instances.instance(int)>
        //   60  140:aload_0         
        //   61  141:getfield        #37  <Field int m_attribIndex>
        //   62  144:invokevirtual   #106 <Method double Instance.value(int)>
        //   63  147:invokespecial   #151 <Method double convertToPanel(double)>
        //   64  150:d2i             
        //   65  151:iastore         
                            if(m_pointDrawn[m_cached[noa] % h][m_heights[noa]])
        //*  66  152:aload_0         
        //*  67  153:getfield        #146 <Field boolean[][] m_pointDrawn>
        //*  68  156:aload_0         
        //*  69  157:getfield        #71  <Field int[] m_cached>
        //*  70  160:iload           5
        //*  71  162:iaload          
        //*  72  163:iload           4
        //*  73  165:irem            
        //*  74  166:aaload          
        //*  75  167:aload_0         
        //*  76  168:getfield        #28  <Field AttributePanel this$0>
        //*  77  171:getfield        #154 <Field int[] AttributePanel.m_heights>
        //*  78  174:iload           5
        //*  79  176:iaload          
        //*  80  177:baload          
        //*  81  178:ifeq            194
                                m_cached[noa] = -9000;
        //   82  181:aload_0         
        //   83  182:getfield        #71  <Field int[] m_cached>
        //   84  185:iload           5
        //   85  187:sipush          -9000
        //   86  190:iastore         
                            else
        //*  87  191:goto            234
                                m_pointDrawn[m_cached[noa] % h][m_heights[noa]] = true;
        //   88  194:aload_0         
        //   89  195:getfield        #146 <Field boolean[][] m_pointDrawn>
        //   90  198:aload_0         
        //   91  199:getfield        #71  <Field int[] m_cached>
        //   92  202:iload           5
        //   93  204:iaload          
        //   94  205:iload           4
        //   95  207:irem            
        //   96  208:aaload          
        //   97  209:aload_0         
        //   98  210:getfield        #28  <Field AttributePanel this$0>
        //   99  213:getfield        #154 <Field int[] AttributePanel.m_heights>
        //  100  216:iload           5
        //  101  218:iaload          
        //  102  219:iconst_1        
        //  103  220:bastore         
                        } else
        //* 104  221:goto            234
                        {
                            m_cached[noa] = -9000;
        //  105  224:aload_0         
        //  106  225:getfield        #71  <Field int[] m_cached>
        //  107  228:iload           5
        //  108  230:sipush          -9000
        //  109  233:iastore         
                        }

        //  110  234:iinc            5  1
        //  111  237:iload           5
        //  112  239:aload_0         
        //  113  240:getfield        #28  <Field AttributePanel this$0>
        //  114  243:getfield        #63  <Field Instances AttributePanel.m_plotInstances>
        //  115  246:invokevirtual   #69  <Method int Instances.numInstances()>
        //  116  249:icmplt          74
                    m_oldWidth = h;
        //  117  252:aload_0         
        //  118  253:iload           4
        //  119  255:putfield        #33  <Field int m_oldWidth>
                }
                if(m_plotInstances.attribute(m_cIndex).isNominal())
        //* 120  258:aload_0         
        //* 121  259:getfield        #28  <Field AttributePanel this$0>
        //* 122  262:getfield        #63  <Field Instances AttributePanel.m_plotInstances>
        //* 123  265:aload_0         
        //* 124  266:getfield        #28  <Field AttributePanel this$0>
        //* 125  269:getfield        #149 <Field int AttributePanel.m_cIndex>
        //* 126  272:invokevirtual   #79  <Method Attribute Instances.attribute(int)>
        //* 127  275:invokevirtual   #85  <Method boolean Attribute.isNominal()>
        //* 128  278:ifeq            436
                {
                    for(int noa = 0; noa < m_plotInstances.numInstances(); noa++)
        //* 129  281:iconst_0        
        //* 130  282:istore          5
        //* 131  284:goto            418
                        if(m_cached[noa] != -9000)
        //* 132  287:aload_0         
        //* 133  288:getfield        #71  <Field int[] m_cached>
        //* 134  291:iload           5
        //* 135  293:iaload          
        //* 136  294:sipush          -9000
        //* 137  297:icmpeq          415
                        {
                            int xp = m_cached[noa];
        //  138  300:aload_0         
        //  139  301:getfield        #71  <Field int[] m_cached>
        //  140  304:iload           5
        //  141  306:iaload          
        //  142  307:istore_2        
                            int yp = m_heights[noa];
        //  143  308:aload_0         
        //  144  309:getfield        #28  <Field AttributePanel this$0>
        //  145  312:getfield        #154 <Field int[] AttributePanel.m_heights>
        //  146  315:iload           5
        //  147  317:iaload          
        //  148  318:istore_3        
                            if(m_plotInstances.attribute(m_attribIndex).isNominal())
        //* 149  319:aload_0         
        //* 150  320:getfield        #28  <Field AttributePanel this$0>
        //* 151  323:getfield        #63  <Field Instances AttributePanel.m_plotInstances>
        //* 152  326:aload_0         
        //* 153  327:getfield        #37  <Field int m_attribIndex>
        //* 154  330:invokevirtual   #79  <Method Attribute Instances.attribute(int)>
        //* 155  333:invokevirtual   #85  <Method boolean Attribute.isNominal()>
        //* 156  336:ifeq            352
                                xp += (int)(Math.random() * 5D) - 2;
        //  157  339:iload_2         
        //  158  340:invokestatic    #160 <Method double Math.random()>
        //  159  343:ldc2w           #161 <Double 5D>
        //  160  346:dmul            
        //  161  347:d2i             
        //  162  348:iconst_2        
        //  163  349:isub            
        //  164  350:iadd            
        //  165  351:istore_2        
                            int ci = (int)m_plotInstances.instance(noa).value(m_cIndex);
        //  166  352:aload_0         
        //  167  353:getfield        #28  <Field AttributePanel this$0>
        //  168  356:getfield        #63  <Field Instances AttributePanel.m_plotInstances>
        //  169  359:iload           5
        //  170  361:invokevirtual   #96  <Method Instance Instances.instance(int)>
        //  171  364:aload_0         
        //  172  365:getfield        #28  <Field AttributePanel this$0>
        //  173  368:getfield        #149 <Field int AttributePanel.m_cIndex>
        //  174  371:invokevirtual   #106 <Method double Instance.value(int)>
        //  175  374:d2i             
        //  176  375:istore          6
                            gx.setColor((Color)m_colorList.elementAt(ci % m_colorList.size()));
        //  177  377:aload_1         
        //  178  378:aload_0         
        //  179  379:getfield        #28  <Field AttributePanel this$0>
        //  180  382:getfield        #166 <Field FastVector AttributePanel.m_colorList>
        //  181  385:iload           6
        //  182  387:aload_0         
        //  183  388:getfield        #28  <Field AttributePanel this$0>
        //  184  391:getfield        #166 <Field FastVector AttributePanel.m_colorList>
        //  185  394:invokevirtual   #171 <Method int FastVector.size()>
        //  186  397:irem            
        //  187  398:invokevirtual   #175 <Method Object FastVector.elementAt(int)>
        //  188  401:checkcast       #177 <Class Color>
        //  189  404:invokevirtual   #182 <Method void Graphics.setColor(Color)>
                            gx.drawRect(xp, yp, 1, 1);
        //  190  407:aload_1         
        //  191  408:iload_2         
        //  192  409:iload_3         
        //  193  410:iconst_1        
        //  194  411:iconst_1        
        //  195  412:invokevirtual   #186 <Method void Graphics.drawRect(int, int, int, int)>
                        }

        //  196  415:iinc            5  1
        //  197  418:iload           5
        //  198  420:aload_0         
        //  199  421:getfield        #28  <Field AttributePanel this$0>
        //  200  424:getfield        #63  <Field Instances AttributePanel.m_plotInstances>
        //  201  427:invokevirtual   #69  <Method int Instances.numInstances()>
        //  202  430:icmplt          287
                } else
        //* 203  433:goto            617
                {
                    for(int noa = 0; noa < m_plotInstances.numInstances(); noa++)
        //* 204  436:iconst_0        
        //* 205  437:istore          7
        //* 206  439:goto            602
                        if(m_cached[noa] != -9000)
        //* 207  442:aload_0         
        //* 208  443:getfield        #71  <Field int[] m_cached>
        //* 209  446:iload           7
        //* 210  448:iaload          
        //* 211  449:sipush          -9000
        //* 212  452:icmpeq          599
                        {
                            double r = (m_plotInstances.instance(noa).value(m_cIndex) - m_minC) / (m_maxC - m_minC);
        //  213  455:aload_0         
        //  214  456:getfield        #28  <Field AttributePanel this$0>
        //  215  459:getfield        #63  <Field Instances AttributePanel.m_plotInstances>
        //  216  462:iload           7
        //  217  464:invokevirtual   #96  <Method Instance Instances.instance(int)>
        //  218  467:aload_0         
        //  219  468:getfield        #28  <Field AttributePanel this$0>
        //  220  471:getfield        #149 <Field int AttributePanel.m_cIndex>
        //  221  474:invokevirtual   #106 <Method double Instance.value(int)>
        //  222  477:aload_0         
        //  223  478:getfield        #28  <Field AttributePanel this$0>
        //  224  481:getfield        #189 <Field double AttributePanel.m_minC>
        //  225  484:dsub            
        //  226  485:aload_0         
        //  227  486:getfield        #28  <Field AttributePanel this$0>
        //  228  489:getfield        #192 <Field double AttributePanel.m_maxC>
        //  229  492:aload_0         
        //  230  493:getfield        #28  <Field AttributePanel this$0>
        //  231  496:getfield        #189 <Field double AttributePanel.m_minC>
        //  232  499:dsub            
        //  233  500:ddiv            
        //  234  501:dstore          5
                            r = r * 240D + 15D;
        //  235  503:dload           5
        //  236  505:ldc2w           #193 <Double 240D>
        //  237  508:dmul            
        //  238  509:ldc2w           #195 <Double 15D>
        //  239  512:dadd            
        //  240  513:dstore          5
                            gx.setColor(new Color((int)r, 150, (int)(255D - r)));
        //  241  515:aload_1         
        //  242  516:new             #177 <Class Color>
        //  243  519:dup             
        //  244  520:dload           5
        //  245  522:d2i             
        //  246  523:sipush          150
        //  247  526:ldc2w           #197 <Double 255D>
        //  248  529:dload           5
        //  249  531:dsub            
        //  250  532:d2i             
        //  251  533:invokespecial   #201 <Method void Color(int, int, int)>
        //  252  536:invokevirtual   #182 <Method void Graphics.setColor(Color)>
                            int xp = m_cached[noa];
        //  253  539:aload_0         
        //  254  540:getfield        #71  <Field int[] m_cached>
        //  255  543:iload           7
        //  256  545:iaload          
        //  257  546:istore_2        
                            int yp = m_heights[noa];
        //  258  547:aload_0         
        //  259  548:getfield        #28  <Field AttributePanel this$0>
        //  260  551:getfield        #154 <Field int[] AttributePanel.m_heights>
        //  261  554:iload           7
        //  262  556:iaload          
        //  263  557:istore_3        
                            if(m_plotInstances.attribute(m_attribIndex).isNominal())
        //* 264  558:aload_0         
        //* 265  559:getfield        #28  <Field AttributePanel this$0>
        //* 266  562:getfield        #63  <Field Instances AttributePanel.m_plotInstances>
        //* 267  565:aload_0         
        //* 268  566:getfield        #37  <Field int m_attribIndex>
        //* 269  569:invokevirtual   #79  <Method Attribute Instances.attribute(int)>
        //* 270  572:invokevirtual   #85  <Method boolean Attribute.isNominal()>
        //* 271  575:ifeq            591
                                xp += (int)(Math.random() * 5D) - 2;
        //  272  578:iload_2         
        //  273  579:invokestatic    #160 <Method double Math.random()>
        //  274  582:ldc2w           #161 <Double 5D>
        //  275  585:dmul            
        //  276  586:d2i             
        //  277  587:iconst_2        
        //  278  588:isub            
        //  279  589:iadd            
        //  280  590:istore_2        
                            gx.drawRect(xp, yp, 1, 1);
        //  281  591:aload_1         
        //  282  592:iload_2         
        //  283  593:iload_3         
        //  284  594:iconst_1        
        //  285  595:iconst_1        
        //  286  596:invokevirtual   #186 <Method void Graphics.drawRect(int, int, int, int)>
                        }

        //  287  599:iinc            7  1
        //  288  602:iload           7
        //  289  604:aload_0         
        //  290  605:getfield        #28  <Field AttributePanel this$0>
        //  291  608:getfield        #63  <Field Instances AttributePanel.m_plotInstances>
        //  292  611:invokevirtual   #69  <Method int Instances.numInstances()>
        //  293  614:icmplt          442
                }
            }
        //  294  617:return          
        }

        private static final long serialVersionUID = 0x6434c7e640954e1aL;
        protected double m_maxVal;
        protected double m_minVal;
        protected Attribute m_attrib;
        protected int m_attribIndex;
        protected int m_cached[];
        protected boolean m_pointDrawn[][];
        protected int m_oldWidth;
        final AttributePanel this$0;


/*
        static AttributePanel access$0(AttributeSpacing attributespacing)
        {
            return attributespacing.this$0;
        //    0    0:aload_0         
        //    1    1:getfield        #28  <Field AttributePanel this$0>
        //    2    4:areturn         
        }

*/

        public AttributeSpacing(Attribute a, int aind)
        {
            this$0 = AttributePanel.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #28  <Field AttributePanel this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #31  <Method void JPanel()>
            m_oldWidth = -9000;
        //    5    9:aload_0         
        //    6   10:sipush          -9000
        //    7   13:putfield        #33  <Field int m_oldWidth>
            m_attrib = a;
        //    8   16:aload_0         
        //    9   17:aload_2         
        //   10   18:putfield        #35  <Field Attribute m_attrib>
            m_attribIndex = aind;
        //   11   21:aload_0         
        //   12   22:iload_3         
        //   13   23:putfield        #37  <Field int m_attribIndex>
            setBackground(m_barColour);
        //   14   26:aload_0         
        //   15   27:aload_1         
        //   16   28:getfield        #43  <Field Color AttributePanel.m_barColour>
        //   17   31:invokevirtual   #47  <Method void setBackground(Color)>
            setPreferredSize(new Dimension(0, 20));
        //   18   34:aload_0         
        //   19   35:new             #49  <Class Dimension>
        //   20   38:dup             
        //   21   39:iconst_0        
        //   22   40:bipush          20
        //   23   42:invokespecial   #52  <Method void Dimension(int, int)>
        //   24   45:invokevirtual   #56  <Method void setPreferredSize(Dimension)>
            setMinimumSize(new Dimension(0, 20));
        //   25   48:aload_0         
        //   26   49:new             #49  <Class Dimension>
        //   27   52:dup             
        //   28   53:iconst_0        
        //   29   54:bipush          20
        //   30   56:invokespecial   #52  <Method void Dimension(int, int)>
        //   31   59:invokevirtual   #59  <Method void setMinimumSize(Dimension)>
            m_cached = new int[m_plotInstances.numInstances()];
        //   32   62:aload_0         
        //   33   63:aload_1         
        //   34   64:getfield        #63  <Field Instances AttributePanel.m_plotInstances>
        //   35   67:invokevirtual   #69  <Method int Instances.numInstances()>
        //   36   70:newarray        int[]
        //   37   72:putfield        #71  <Field int[] m_cached>
            double min = (1.0D / 0.0D);
        //   38   75:ldc2w           #72  <Double (1.0D / 0.0D)>
        //   39   78:dstore          4
            double max = (-1.0D / 0.0D);
        //   40   80:ldc2w           #74  <Double (-1.0D / 0.0D)>
        //   41   83:dstore          6
            if(m_plotInstances.attribute(m_attribIndex).isNominal())
        //*  42   85:aload_1         
        //*  43   86:getfield        #63  <Field Instances AttributePanel.m_plotInstances>
        //*  44   89:aload_0         
        //*  45   90:getfield        #37  <Field int m_attribIndex>
        //*  46   93:invokevirtual   #79  <Method Attribute Instances.attribute(int)>
        //*  47   96:invokevirtual   #85  <Method boolean Attribute.isNominal()>
        //*  48   99:ifeq            131
            {
                m_minVal = 0.0D;
        //   49  102:aload_0         
        //   50  103:dconst_0        
        //   51  104:putfield        #87  <Field double m_minVal>
                m_maxVal = m_plotInstances.attribute(m_attribIndex).numValues() - 1;
        //   52  107:aload_0         
        //   53  108:aload_1         
        //   54  109:getfield        #63  <Field Instances AttributePanel.m_plotInstances>
        //   55  112:aload_0         
        //   56  113:getfield        #37  <Field int m_attribIndex>
        //   57  116:invokevirtual   #79  <Method Attribute Instances.attribute(int)>
        //   58  119:invokevirtual   #90  <Method int Attribute.numValues()>
        //   59  122:iconst_1        
        //   60  123:isub            
        //   61  124:i2d             
        //   62  125:putfield        #92  <Field double m_maxVal>
            } else
        //*  63  128:goto            257
            {
                for(int i = 0; i < m_plotInstances.numInstances(); i++)
        //*  64  131:iconst_0        
        //*  65  132:istore          10
        //*  66  134:goto            201
                    if(!m_plotInstances.instance(i).isMissing(m_attribIndex))
        //*  67  137:aload_1         
        //*  68  138:getfield        #63  <Field Instances AttributePanel.m_plotInstances>
        //*  69  141:iload           10
        //*  70  143:invokevirtual   #96  <Method Instance Instances.instance(int)>
        //*  71  146:aload_0         
        //*  72  147:getfield        #37  <Field int m_attribIndex>
        //*  73  150:invokevirtual   #102 <Method boolean Instance.isMissing(int)>
        //*  74  153:ifne            198
                    {
                        double value = m_plotInstances.instance(i).value(m_attribIndex);
        //   75  156:aload_1         
        //   76  157:getfield        #63  <Field Instances AttributePanel.m_plotInstances>
        //   77  160:iload           10
        //   78  162:invokevirtual   #96  <Method Instance Instances.instance(int)>
        //   79  165:aload_0         
        //   80  166:getfield        #37  <Field int m_attribIndex>
        //   81  169:invokevirtual   #106 <Method double Instance.value(int)>
        //   82  172:dstore          8
                        if(value < min)
        //*  83  174:dload           8
        //*  84  176:dload           4
        //*  85  178:dcmpg           
        //*  86  179:ifge            186
                            min = value;
        //   87  182:dload           8
        //   88  184:dstore          4
                        if(value > max)
        //*  89  186:dload           8
        //*  90  188:dload           6
        //*  91  190:dcmpl           
        //*  92  191:ifle            198
                            max = value;
        //   93  194:dload           8
        //   94  196:dstore          6
                    }

        //   95  198:iinc            10  1
        //   96  201:iload           10
        //   97  203:aload_1         
        //   98  204:getfield        #63  <Field Instances AttributePanel.m_plotInstances>
        //   99  207:invokevirtual   #69  <Method int Instances.numInstances()>
        //  100  210:icmplt          137
                m_minVal = min;
        //  101  213:aload_0         
        //  102  214:dload           4
        //  103  216:putfield        #87  <Field double m_minVal>
                m_maxVal = max;
        //  104  219:aload_0         
        //  105  220:dload           6
        //  106  222:putfield        #92  <Field double m_maxVal>
                if(min == max)
        //* 107  225:dload           4
        //* 108  227:dload           6
        //* 109  229:dcmpl           
        //* 110  230:ifne            257
                {
                    m_maxVal += 0.050000000000000003D;
        //  111  233:aload_0         
        //  112  234:dup             
        //  113  235:getfield        #92  <Field double m_maxVal>
        //  114  238:ldc2w           #107 <Double 0.050000000000000003D>
        //  115  241:dadd            
        //  116  242:putfield        #92  <Field double m_maxVal>
                    m_minVal -= 0.050000000000000003D;
        //  117  245:aload_0         
        //  118  246:dup             
        //  119  247:getfield        #87  <Field double m_minVal>
        //  120  250:ldc2w           #107 <Double 0.050000000000000003D>
        //  121  253:dsub            
        //  122  254:putfield        #87  <Field double m_minVal>
                }
            }
            addMouseListener(new MouseAdapter() {

                public void mouseClicked(MouseEvent e)
                {
                    if((e.getModifiers() & 0x10) == 16)
                //*   0    0:aload_1         
                //*   1    1:invokevirtual   #26  <Method int MouseEvent.getModifiers()>
                //*   2    4:bipush          16
                //*   3    6:iand            
                //*   4    7:bipush          16
                //*   5    9:icmpne          113
                    {
                        setX(m_attribIndex);
                //    6   12:aload_0         
                //    7   13:getfield        #11  <Field AttributePanel$AttributeSpacing this$1>
                //    8   16:invokestatic    #32  <Method AttributePanel AttributePanel$AttributeSpacing.access$0(AttributePanel$AttributeSpacing)>
                //    9   19:aload_0         
                //   10   20:getfield        #11  <Field AttributePanel$AttributeSpacing this$1>
                //   11   23:getfield        #36  <Field int AttributePanel$AttributeSpacing.m_attribIndex>
                //   12   26:invokevirtual   #42  <Method void AttributePanel.setX(int)>
                        if(m_Listeners.size() > 0)
                //*  13   29:aload_0         
                //*  14   30:getfield        #11  <Field AttributePanel$AttributeSpacing this$1>
                //*  15   33:invokestatic    #32  <Method AttributePanel AttributePanel$AttributeSpacing.access$0(AttributePanel$AttributeSpacing)>
                //*  16   36:getfield        #46  <Field FastVector AttributePanel.m_Listeners>
                //*  17   39:invokevirtual   #51  <Method int FastVector.size()>
                //*  18   42:ifle            211
                        {
                            for(int i = 0; i < m_Listeners.size(); i++)
                //*  19   45:iconst_0        
                //*  20   46:istore_2        
                //*  21   47:goto            93
                            {
                                AttributePanelListener l = (AttributePanelListener)m_Listeners.elementAt(i);
                //   22   50:aload_0         
                //   23   51:getfield        #11  <Field AttributePanel$AttributeSpacing this$1>
                //   24   54:invokestatic    #32  <Method AttributePanel AttributePanel$AttributeSpacing.access$0(AttributePanel$AttributeSpacing)>
                //   25   57:getfield        #46  <Field FastVector AttributePanel.m_Listeners>
                //   26   60:iload_2         
                //   27   61:invokevirtual   #55  <Method Object FastVector.elementAt(int)>
                //   28   64:checkcast       #57  <Class AttributePanelListener>
                //   29   67:astore_3        
                                l.attributeSelectionChange(new AttributePanelEvent(true, false, m_attribIndex));
                //   30   68:aload_3         
                //   31   69:new             #59  <Class AttributePanelEvent>
                //   32   72:dup             
                //   33   73:iconst_1        
                //   34   74:iconst_0        
                //   35   75:aload_0         
                //   36   76:getfield        #11  <Field AttributePanel$AttributeSpacing this$1>
                //   37   79:getfield        #36  <Field int AttributePanel$AttributeSpacing.m_attribIndex>
                //   38   82:invokespecial   #62  <Method void AttributePanelEvent(boolean, boolean, int)>
                //   39   85:invokeinterface #66  <Method void AttributePanelListener.attributeSelectionChange(AttributePanelEvent)>
                            }

                //   40   90:iinc            2  1
                //   41   93:iload_2         
                //   42   94:aload_0         
                //   43   95:getfield        #11  <Field AttributePanel$AttributeSpacing this$1>
                //   44   98:invokestatic    #32  <Method AttributePanel AttributePanel$AttributeSpacing.access$0(AttributePanel$AttributeSpacing)>
                //   45  101:getfield        #46  <Field FastVector AttributePanel.m_Listeners>
                //   46  104:invokevirtual   #51  <Method int FastVector.size()>
                //   47  107:icmplt          50
                        }
                    } else
                //*  48  110:goto            211
                    {
                        setY(m_attribIndex);
                //   49  113:aload_0         
                //   50  114:getfield        #11  <Field AttributePanel$AttributeSpacing this$1>
                //   51  117:invokestatic    #32  <Method AttributePanel AttributePanel$AttributeSpacing.access$0(AttributePanel$AttributeSpacing)>
                //   52  120:aload_0         
                //   53  121:getfield        #11  <Field AttributePanel$AttributeSpacing this$1>
                //   54  124:getfield        #36  <Field int AttributePanel$AttributeSpacing.m_attribIndex>
                //   55  127:invokevirtual   #69  <Method void AttributePanel.setY(int)>
                        if(m_Listeners.size() > 0)
                //*  56  130:aload_0         
                //*  57  131:getfield        #11  <Field AttributePanel$AttributeSpacing this$1>
                //*  58  134:invokestatic    #32  <Method AttributePanel AttributePanel$AttributeSpacing.access$0(AttributePanel$AttributeSpacing)>
                //*  59  137:getfield        #46  <Field FastVector AttributePanel.m_Listeners>
                //*  60  140:invokevirtual   #51  <Method int FastVector.size()>
                //*  61  143:ifle            211
                        {
                            for(int i = 0; i < m_Listeners.size(); i++)
                //*  62  146:iconst_0        
                //*  63  147:istore_2        
                //*  64  148:goto            194
                            {
                                AttributePanelListener l = (AttributePanelListener)m_Listeners.elementAt(i);
                //   65  151:aload_0         
                //   66  152:getfield        #11  <Field AttributePanel$AttributeSpacing this$1>
                //   67  155:invokestatic    #32  <Method AttributePanel AttributePanel$AttributeSpacing.access$0(AttributePanel$AttributeSpacing)>
                //   68  158:getfield        #46  <Field FastVector AttributePanel.m_Listeners>
                //   69  161:iload_2         
                //   70  162:invokevirtual   #55  <Method Object FastVector.elementAt(int)>
                //   71  165:checkcast       #57  <Class AttributePanelListener>
                //   72  168:astore_3        
                                l.attributeSelectionChange(new AttributePanelEvent(false, true, m_attribIndex));
                //   73  169:aload_3         
                //   74  170:new             #59  <Class AttributePanelEvent>
                //   75  173:dup             
                //   76  174:iconst_0        
                //   77  175:iconst_1        
                //   78  176:aload_0         
                //   79  177:getfield        #11  <Field AttributePanel$AttributeSpacing this$1>
                //   80  180:getfield        #36  <Field int AttributePanel$AttributeSpacing.m_attribIndex>
                //   81  183:invokespecial   #62  <Method void AttributePanelEvent(boolean, boolean, int)>
                //   82  186:invokeinterface #66  <Method void AttributePanelListener.attributeSelectionChange(AttributePanelEvent)>
                            }

                //   83  191:iinc            2  1
                //   84  194:iload_2         
                //   85  195:aload_0         
                //   86  196:getfield        #11  <Field AttributePanel$AttributeSpacing this$1>
                //   87  199:invokestatic    #32  <Method AttributePanel AttributePanel$AttributeSpacing.access$0(AttributePanel$AttributeSpacing)>
                //   88  202:getfield        #46  <Field FastVector AttributePanel.m_Listeners>
                //   89  205:invokevirtual   #51  <Method int FastVector.size()>
                //   90  208:icmplt          151
                        }
                    }
                //   91  211:return          
                }

                final AttributeSpacing this$1;

                
                {
                    this$1 = AttributeSpacing.this;
                //    0    0:aload_0         
                //    1    1:aload_1         
                //    2    2:putfield        #11  <Field AttributePanel$AttributeSpacing this$1>
                    super();
                //    3    5:aload_0         
                //    4    6:invokespecial   #14  <Method void MouseAdapter()>
                //    5    9:return          
                }
            }
);
        //  123  257:aload_0         
        //  124  258:new             #110 <Class AttributePanel$1>
        //  125  261:dup             
        //  126  262:aload_0         
        //  127  263:invokespecial   #113 <Method void AttributePanel$1(AttributePanel$AttributeSpacing)>
        //  128  266:invokevirtual   #117 <Method void addMouseListener(java.awt.event.MouseListener)>
        //  129  269:return          
        }
    }


    private void setProperties()
    {
        if(VisualizeUtils.VISUALIZE_PROPERTIES != null)
    //*   0    0:getstatic       #39  <Field Properties VisualizeUtils.VISUALIZE_PROPERTIES>
    //*   1    3:ifnull          58
        {
            String thisClass = getClass().getName();
    //    2    6:aload_0         
    //    3    7:invokevirtual   #45  <Method Class Object.getClass()>
    //    4   10:invokevirtual   #51  <Method String Class.getName()>
    //    5   13:astore_1        
            String barKey = (new StringBuilder(String.valueOf(thisClass))).append(".barColour").toString();
    //    6   14:new             #53  <Class StringBuilder>
    //    7   17:dup             
    //    8   18:aload_1         
    //    9   19:invokestatic    #59  <Method String String.valueOf(Object)>
    //   10   22:invokespecial   #63  <Method void StringBuilder(String)>
    //   11   25:ldc1            #65  <String ".barColour">
    //   12   27:invokevirtual   #69  <Method StringBuilder StringBuilder.append(String)>
    //   13   30:invokevirtual   #72  <Method String StringBuilder.toString()>
    //   14   33:astore_2        
            String barC = VisualizeUtils.VISUALIZE_PROPERTIES.getProperty(barKey);
    //   15   34:getstatic       #39  <Field Properties VisualizeUtils.VISUALIZE_PROPERTIES>
    //   16   37:aload_2         
    //   17   38:invokevirtual   #78  <Method String Properties.getProperty(String)>
    //   18   41:astore_3        
            if(barC != null)
    //*  19   42:aload_3         
    //*  20   43:ifnull          58
                m_barColour = VisualizeUtils.processColour(barC, m_barColour);
    //   21   46:aload_0         
    //   22   47:aload_3         
    //   23   48:aload_0         
    //   24   49:getfield        #80  <Field Color m_barColour>
    //   25   52:invokestatic    #84  <Method Color VisualizeUtils.processColour(String, Color)>
    //   26   55:putfield        #80  <Field Color m_barColour>
        }
    //   27   58:return          
    }

    public AttributePanel()
    {
        this(null);
    //    0    0:aload_0         
    //    1    1:aconst_null     
    //    2    2:invokespecial   #95  <Method void AttributePanel(Color)>
    //    3    5:return          
    }

    public AttributePanel(Color background)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #97  <Method void JScrollPane()>
        m_plotInstances = null;
    //    2    4:aload_0         
    //    3    5:aconst_null     
    //    4    6:putfield        #99  <Field Instances m_plotInstances>
        m_DefaultColors = (new Color[] {
            Color.blue, Color.red, Color.green, Color.cyan, Color.pink, new Color(255, 0, 255), Color.orange, new Color(255, 0, 0), new Color(0, 255, 0), Color.white
        });
    //    5    9:aload_0         
    //    6   10:bipush          10
    //    7   12:anewarray       Color[]
    //    8   15:dup             
    //    9   16:iconst_0        
    //   10   17:getstatic       #104 <Field Color Color.blue>
    //   11   20:aastore         
    //   12   21:dup             
    //   13   22:iconst_1        
    //   14   23:getstatic       #107 <Field Color Color.red>
    //   15   26:aastore         
    //   16   27:dup             
    //   17   28:iconst_2        
    //   18   29:getstatic       #110 <Field Color Color.green>
    //   19   32:aastore         
    //   20   33:dup             
    //   21   34:iconst_3        
    //   22   35:getstatic       #113 <Field Color Color.cyan>
    //   23   38:aastore         
    //   24   39:dup             
    //   25   40:iconst_4        
    //   26   41:getstatic       #116 <Field Color Color.pink>
    //   27   44:aastore         
    //   28   45:dup             
    //   29   46:iconst_5        
    //   30   47:new             #101 <Class Color>
    //   31   50:dup             
    //   32   51:sipush          255
    //   33   54:iconst_0        
    //   34   55:sipush          255
    //   35   58:invokespecial   #119 <Method void Color(int, int, int)>
    //   36   61:aastore         
    //   37   62:dup             
    //   38   63:bipush          6
    //   39   65:getstatic       #122 <Field Color Color.orange>
    //   40   68:aastore         
    //   41   69:dup             
    //   42   70:bipush          7
    //   43   72:new             #101 <Class Color>
    //   44   75:dup             
    //   45   76:sipush          255
    //   46   79:iconst_0        
    //   47   80:iconst_0        
    //   48   81:invokespecial   #119 <Method void Color(int, int, int)>
    //   49   84:aastore         
    //   50   85:dup             
    //   51   86:bipush          8
    //   52   88:new             #101 <Class Color>
    //   53   91:dup             
    //   54   92:iconst_0        
    //   55   93:sipush          255
    //   56   96:iconst_0        
    //   57   97:invokespecial   #119 <Method void Color(int, int, int)>
    //   58  100:aastore         
    //   59  101:dup             
    //   60  102:bipush          9
    //   61  104:getstatic       #125 <Field Color Color.white>
    //   62  107:aastore         
    //   63  108:putfield        #127 <Field Color[] m_DefaultColors>
        m_backgroundColor = null;
    //   64  111:aload_0         
    //   65  112:aconst_null     
    //   66  113:putfield        #129 <Field Color m_backgroundColor>
        m_Listeners = new FastVector();
    //   67  116:aload_0         
    //   68  117:new             #131 <Class FastVector>
    //   69  120:dup             
    //   70  121:invokespecial   #132 <Method void FastVector()>
    //   71  124:putfield        #134 <Field FastVector m_Listeners>
        m_span = null;
    //   72  127:aload_0         
    //   73  128:aconst_null     
    //   74  129:putfield        #136 <Field JPanel m_span>
        m_barColour = Color.black;
    //   75  132:aload_0         
    //   76  133:getstatic       #139 <Field Color Color.black>
    //   77  136:putfield        #80  <Field Color m_barColour>
        m_backgroundColor = background;
    //   78  139:aload_0         
    //   79  140:aload_1         
    //   80  141:putfield        #129 <Field Color m_backgroundColor>
        setProperties();
    //   81  144:aload_0         
    //   82  145:invokespecial   #141 <Method void setProperties()>
        setBackground(Color.blue);
    //   83  148:aload_0         
    //   84  149:getstatic       #104 <Field Color Color.blue>
    //   85  152:invokevirtual   #144 <Method void setBackground(Color)>
        setVerticalScrollBarPolicy(22);
    //   86  155:aload_0         
    //   87  156:bipush          22
    //   88  158:invokevirtual   #148 <Method void setVerticalScrollBarPolicy(int)>
        m_colorList = new FastVector(10);
    //   89  161:aload_0         
    //   90  162:new             #131 <Class FastVector>
    //   91  165:dup             
    //   92  166:bipush          10
    //   93  168:invokespecial   #150 <Method void FastVector(int)>
    //   94  171:putfield        #152 <Field FastVector m_colorList>
        for(int noa = m_colorList.size(); noa < 10; noa++)
    //*  95  174:aload_0         
    //*  96  175:getfield        #152 <Field FastVector m_colorList>
    //*  97  178:invokevirtual   #156 <Method int FastVector.size()>
    //*  98  181:istore_2        
    //*  99  182:goto            239
        {
            Color pc = m_DefaultColors[noa % 10];
    //  100  185:aload_0         
    //  101  186:getfield        #127 <Field Color[] m_DefaultColors>
    //  102  189:iload_2         
    //  103  190:bipush          10
    //  104  192:irem            
    //  105  193:aaload          
    //  106  194:astore_3        
            int ija = noa / 10;
    //  107  195:iload_2         
    //  108  196:bipush          10
    //  109  198:idiv            
    //  110  199:istore          4
            ija *= 2;
    //  111  201:iload           4
    //  112  203:iconst_2        
    //  113  204:imul            
    //  114  205:istore          4
            for(int j = 0; j < ija; j++)
    //* 115  207:iconst_0        
    //* 116  208:istore          5
    //* 117  210:goto            221
                pc = pc.darker();
    //  118  213:aload_3         
    //  119  214:invokevirtual   #160 <Method Color Color.darker()>
    //  120  217:astore_3        

    //  121  218:iinc            5  1
    //  122  221:iload           5
    //  123  223:iload           4
    //  124  225:icmplt          213
            m_colorList.addElement(pc);
    //  125  228:aload_0         
    //  126  229:getfield        #152 <Field FastVector m_colorList>
    //  127  232:aload_3         
    //  128  233:invokevirtual   #164 <Method void FastVector.addElement(Object)>
        }

    //  129  236:iinc            2  1
    //  130  239:iload_2         
    //  131  240:bipush          10
    //  132  242:icmplt          185
    //  133  245:return          
    }

    public void addAttributePanelListener(AttributePanelListener a)
    {
        m_Listeners.addElement(a);
    //    0    0:aload_0         
    //    1    1:getfield        #134 <Field FastVector m_Listeners>
    //    2    4:aload_1         
    //    3    5:invokevirtual   #164 <Method void FastVector.addElement(Object)>
    //    4    8:return          
    }

    public void setCindex(int c, double h, double l)
    {
        m_cIndex = c;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #177 <Field int m_cIndex>
        m_maxC = h;
    //    3    5:aload_0         
    //    4    6:dload_2         
    //    5    7:putfield        #179 <Field double m_maxC>
        m_minC = l;
    //    6   10:aload_0         
    //    7   11:dload           4
    //    8   13:putfield        #181 <Field double m_minC>
        if(m_span != null)
    //*   9   16:aload_0         
    //*  10   17:getfield        #136 <Field JPanel m_span>
    //*  11   20:ifnull          96
        {
            if(m_plotInstances.numAttributes() > 0 && m_cIndex < m_plotInstances.numAttributes() && m_plotInstances.attribute(m_cIndex).isNominal() && m_plotInstances.attribute(m_cIndex).numValues() > m_colorList.size())
    //*  12   23:aload_0         
    //*  13   24:getfield        #99  <Field Instances m_plotInstances>
    //*  14   27:invokevirtual   #186 <Method int Instances.numAttributes()>
    //*  15   30:ifle            92
    //*  16   33:aload_0         
    //*  17   34:getfield        #177 <Field int m_cIndex>
    //*  18   37:aload_0         
    //*  19   38:getfield        #99  <Field Instances m_plotInstances>
    //*  20   41:invokevirtual   #186 <Method int Instances.numAttributes()>
    //*  21   44:icmpge          92
    //*  22   47:aload_0         
    //*  23   48:getfield        #99  <Field Instances m_plotInstances>
    //*  24   51:aload_0         
    //*  25   52:getfield        #177 <Field int m_cIndex>
    //*  26   55:invokevirtual   #190 <Method Attribute Instances.attribute(int)>
    //*  27   58:invokevirtual   #196 <Method boolean Attribute.isNominal()>
    //*  28   61:ifeq            92
    //*  29   64:aload_0         
    //*  30   65:getfield        #99  <Field Instances m_plotInstances>
    //*  31   68:aload_0         
    //*  32   69:getfield        #177 <Field int m_cIndex>
    //*  33   72:invokevirtual   #190 <Method Attribute Instances.attribute(int)>
    //*  34   75:invokevirtual   #199 <Method int Attribute.numValues()>
    //*  35   78:aload_0         
    //*  36   79:getfield        #152 <Field FastVector m_colorList>
    //*  37   82:invokevirtual   #156 <Method int FastVector.size()>
    //*  38   85:icmple          92
                extendColourMap();
    //   39   88:aload_0         
    //   40   89:invokespecial   #202 <Method void extendColourMap()>
            repaint();
    //   41   92:aload_0         
    //   42   93:invokevirtual   #205 <Method void repaint()>
        }
    //   43   96:return          
    }

    public void setCindex(int c)
    {
        m_cIndex = c;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #177 <Field int m_cIndex>
        if(m_span != null)
    //*   3    5:aload_0         
    //*   4    6:getfield        #136 <Field JPanel m_span>
    //*   5    9:ifnull          178
        {
            if(m_cIndex < m_plotInstances.numAttributes() && m_plotInstances.attribute(m_cIndex).isNumeric())
    //*   6   12:aload_0         
    //*   7   13:getfield        #177 <Field int m_cIndex>
    //*   8   16:aload_0         
    //*   9   17:getfield        #99  <Field Instances m_plotInstances>
    //*  10   20:invokevirtual   #186 <Method int Instances.numAttributes()>
    //*  11   23:icmpge          146
    //*  12   26:aload_0         
    //*  13   27:getfield        #99  <Field Instances m_plotInstances>
    //*  14   30:aload_0         
    //*  15   31:getfield        #177 <Field int m_cIndex>
    //*  16   34:invokevirtual   #190 <Method Attribute Instances.attribute(int)>
    //*  17   37:invokevirtual   #211 <Method boolean Attribute.isNumeric()>
    //*  18   40:ifeq            146
            {
                double min = (1.0D / 0.0D);
    //   19   43:ldc2w           #212 <Double (1.0D / 0.0D)>
    //   20   46:dstore_2        
                double max = (-1.0D / 0.0D);
    //   21   47:ldc2w           #214 <Double (-1.0D / 0.0D)>
    //   22   50:dstore          4
                for(int i = 0; i < m_plotInstances.numInstances(); i++)
    //*  23   52:iconst_0        
    //*  24   53:istore          8
    //*  25   55:goto            120
                    if(!m_plotInstances.instance(i).isMissing(m_cIndex))
    //*  26   58:aload_0         
    //*  27   59:getfield        #99  <Field Instances m_plotInstances>
    //*  28   62:iload           8
    //*  29   64:invokevirtual   #219 <Method Instance Instances.instance(int)>
    //*  30   67:aload_0         
    //*  31   68:getfield        #177 <Field int m_cIndex>
    //*  32   71:invokevirtual   #225 <Method boolean Instance.isMissing(int)>
    //*  33   74:ifne            117
                    {
                        double value = m_plotInstances.instance(i).value(m_cIndex);
    //   34   77:aload_0         
    //   35   78:getfield        #99  <Field Instances m_plotInstances>
    //   36   81:iload           8
    //   37   83:invokevirtual   #219 <Method Instance Instances.instance(int)>
    //   38   86:aload_0         
    //   39   87:getfield        #177 <Field int m_cIndex>
    //   40   90:invokevirtual   #229 <Method double Instance.value(int)>
    //   41   93:dstore          6
                        if(value < min)
    //*  42   95:dload           6
    //*  43   97:dload_2         
    //*  44   98:dcmpg           
    //*  45   99:ifge            105
                            min = value;
    //   46  102:dload           6
    //   47  104:dstore_2        
                        if(value > max)
    //*  48  105:dload           6
    //*  49  107:dload           4
    //*  50  109:dcmpl           
    //*  51  110:ifle            117
                            max = value;
    //   52  113:dload           6
    //   53  115:dstore          4
                    }

    //   54  117:iinc            8  1
    //   55  120:iload           8
    //   56  122:aload_0         
    //   57  123:getfield        #99  <Field Instances m_plotInstances>
    //   58  126:invokevirtual   #232 <Method int Instances.numInstances()>
    //   59  129:icmplt          58
                m_minC = min;
    //   60  132:aload_0         
    //   61  133:dload_2         
    //   62  134:putfield        #181 <Field double m_minC>
                m_maxC = max;
    //   63  137:aload_0         
    //   64  138:dload           4
    //   65  140:putfield        #179 <Field double m_maxC>
            } else
    //*  66  143:goto            174
            if(m_plotInstances.attribute(m_cIndex).numValues() > m_colorList.size())
    //*  67  146:aload_0         
    //*  68  147:getfield        #99  <Field Instances m_plotInstances>
    //*  69  150:aload_0         
    //*  70  151:getfield        #177 <Field int m_cIndex>
    //*  71  154:invokevirtual   #190 <Method Attribute Instances.attribute(int)>
    //*  72  157:invokevirtual   #199 <Method int Attribute.numValues()>
    //*  73  160:aload_0         
    //*  74  161:getfield        #152 <Field FastVector m_colorList>
    //*  75  164:invokevirtual   #156 <Method int FastVector.size()>
    //*  76  167:icmple          174
                extendColourMap();
    //   77  170:aload_0         
    //   78  171:invokespecial   #202 <Method void extendColourMap()>
            repaint();
    //   79  174:aload_0         
    //   80  175:invokevirtual   #205 <Method void repaint()>
        }
    //   81  178:return          
    }

    private void extendColourMap()
    {
        if(m_plotInstances.attribute(m_cIndex).isNominal())
    //*   0    0:aload_0         
    //*   1    1:getfield        #99  <Field Instances m_plotInstances>
    //*   2    4:aload_0         
    //*   3    5:getfield        #177 <Field int m_cIndex>
    //*   4    8:invokevirtual   #190 <Method Attribute Instances.attribute(int)>
    //*   5   11:invokevirtual   #196 <Method boolean Attribute.isNominal()>
    //*   6   14:ifeq            112
        {
            for(int i = m_colorList.size(); i < m_plotInstances.attribute(m_cIndex).numValues(); i++)
    //*   7   17:aload_0         
    //*   8   18:getfield        #152 <Field FastVector m_colorList>
    //*   9   21:invokevirtual   #156 <Method int FastVector.size()>
    //*  10   24:istore_1        
    //*  11   25:goto            94
            {
                Color pc = m_DefaultColors[i % 10];
    //   12   28:aload_0         
    //   13   29:getfield        #127 <Field Color[] m_DefaultColors>
    //   14   32:iload_1         
    //   15   33:bipush          10
    //   16   35:irem            
    //   17   36:aaload          
    //   18   37:astore_2        
                int ija = i / 10;
    //   19   38:iload_1         
    //   20   39:bipush          10
    //   21   41:idiv            
    //   22   42:istore_3        
                ija *= 2;
    //   23   43:iload_3         
    //   24   44:iconst_2        
    //   25   45:imul            
    //   26   46:istore_3        
                for(int j = 0; j < ija; j++)
    //*  27   47:iconst_0        
    //*  28   48:istore          4
    //*  29   50:goto            61
                    pc = pc.brighter();
    //   30   53:aload_2         
    //   31   54:invokevirtual   #238 <Method Color Color.brighter()>
    //   32   57:astore_2        

    //   33   58:iinc            4  1
    //   34   61:iload           4
    //   35   63:iload_3         
    //   36   64:icmplt          53
                if(m_backgroundColor != null)
    //*  37   67:aload_0         
    //*  38   68:getfield        #129 <Field Color m_backgroundColor>
    //*  39   71:ifnull          83
                    pc = Plot2D.checkAgainstBackground(pc, m_backgroundColor);
    //   40   74:aload_2         
    //   41   75:aload_0         
    //   42   76:getfield        #129 <Field Color m_backgroundColor>
    //   43   79:invokestatic    #244 <Method Color Plot2D.checkAgainstBackground(Color, Color)>
    //   44   82:astore_2        
                m_colorList.addElement(pc);
    //   45   83:aload_0         
    //   46   84:getfield        #152 <Field FastVector m_colorList>
    //   47   87:aload_2         
    //   48   88:invokevirtual   #164 <Method void FastVector.addElement(Object)>
            }

    //   49   91:iinc            1  1
    //   50   94:iload_1         
    //   51   95:aload_0         
    //   52   96:getfield        #99  <Field Instances m_plotInstances>
    //   53   99:aload_0         
    //   54  100:getfield        #177 <Field int m_cIndex>
    //   55  103:invokevirtual   #190 <Method Attribute Instances.attribute(int)>
    //   56  106:invokevirtual   #199 <Method int Attribute.numValues()>
    //   57  109:icmplt          28
        }
    //   58  112:return          
    }

    public void setColours(FastVector cols)
    {
        m_colorList = cols;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #152 <Field FastVector m_colorList>
    //    3    5:return          
    }

    protected void setDefaultColourList(Color list[])
    {
        m_DefaultColors = list;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #127 <Field Color[] m_DefaultColors>
    //    3    5:return          
    }

    public void setInstances(Instances ins)
        throws Exception
    {
        if(ins.numAttributes() > 512)
    //*   0    0:aload_1         
    //*   1    1:invokevirtual   #186 <Method int Instances.numAttributes()>
    //*   2    4:sipush          512
    //*   3    7:icmple          21
            throw new Exception("Can't display more than 512 attributes!");
    //    4   10:new             #255 <Class Exception>
    //    5   13:dup             
    //    6   14:ldc2            #257 <String "Can't display more than 512 attributes!">
    //    7   17:invokespecial   #258 <Method void Exception(String)>
    //    8   20:athrow          
        if(m_span == null)
    //*   9   21:aload_0         
    //*  10   22:getfield        #136 <Field JPanel m_span>
    //*  11   25:ifnonnull       40
            m_span = new JPanel() {

                public void paintComponent(Graphics gx)
                {
                    super.paintComponent(gx);
                //    0    0:aload_0         
                //    1    1:aload_1         
                //    2    2:invokespecial   #27  <Method void JPanel.paintComponent(Graphics)>
                    gx.setColor(Color.red);
                //    3    5:aload_1         
                //    4    6:getstatic       #33  <Field Color Color.red>
                //    5    9:invokevirtual   #39  <Method void Graphics.setColor(Color)>
                    if(m_yIndex != m_xIndex)
                //*   6   12:aload_0         
                //*   7   13:getfield        #16  <Field AttributePanel this$0>
                //*   8   16:getfield        #45  <Field int AttributePanel.m_yIndex>
                //*   9   19:aload_0         
                //*  10   20:getfield        #16  <Field AttributePanel this$0>
                //*  11   23:getfield        #48  <Field int AttributePanel.m_xIndex>
                //*  12   26:icmpeq          72
                    {
                        gx.drawString("X", 5, m_xIndex * 20 + 16);
                //   13   29:aload_1         
                //   14   30:ldc1            #50  <String "X">
                //   15   32:iconst_5        
                //   16   33:aload_0         
                //   17   34:getfield        #16  <Field AttributePanel this$0>
                //   18   37:getfield        #48  <Field int AttributePanel.m_xIndex>
                //   19   40:bipush          20
                //   20   42:imul            
                //   21   43:bipush          16
                //   22   45:iadd            
                //   23   46:invokevirtual   #54  <Method void Graphics.drawString(String, int, int)>
                        gx.drawString("Y", 5, m_yIndex * 20 + 16);
                //   24   49:aload_1         
                //   25   50:ldc1            #56  <String "Y">
                //   26   52:iconst_5        
                //   27   53:aload_0         
                //   28   54:getfield        #16  <Field AttributePanel this$0>
                //   29   57:getfield        #45  <Field int AttributePanel.m_yIndex>
                //   30   60:bipush          20
                //   31   62:imul            
                //   32   63:bipush          16
                //   33   65:iadd            
                //   34   66:invokevirtual   #54  <Method void Graphics.drawString(String, int, int)>
                    } else
                //*  35   69:goto            92
                    {
                        gx.drawString("B", 5, m_xIndex * 20 + 16);
                //   36   72:aload_1         
                //   37   73:ldc1            #58  <String "B">
                //   38   75:iconst_5        
                //   39   76:aload_0         
                //   40   77:getfield        #16  <Field AttributePanel this$0>
                //   41   80:getfield        #48  <Field int AttributePanel.m_xIndex>
                //   42   83:bipush          20
                //   43   85:imul            
                //   44   86:bipush          16
                //   45   88:iadd            
                //   46   89:invokevirtual   #54  <Method void Graphics.drawString(String, int, int)>
                    }
                //   47   92:return          
                }

                private static final long serialVersionUID = 0x62a32f38d1366612L;
                final AttributePanel this$0;

            
            {
                this$0 = AttributePanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #16  <Field AttributePanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #19  <Method void JPanel()>
            //    5    9:return          
            }
            }
;
    //   12   28:aload_0         
    //   13   29:new             #260 <Class AttributePanel$2>
    //   14   32:dup             
    //   15   33:aload_0         
    //   16   34:invokespecial   #263 <Method void AttributePanel$2(AttributePanel)>
    //   17   37:putfield        #136 <Field JPanel m_span>
        m_span.removeAll();
    //   18   40:aload_0         
    //   19   41:getfield        #136 <Field JPanel m_span>
    //   20   44:invokevirtual   #268 <Method void JPanel.removeAll()>
        m_plotInstances = ins;
    //   21   47:aload_0         
    //   22   48:aload_1         
    //   23   49:putfield        #99  <Field Instances m_plotInstances>
        if(ins.numInstances() > 0 && ins.numAttributes() > 0)
    //*  24   52:aload_1         
    //*  25   53:invokevirtual   #232 <Method int Instances.numInstances()>
    //*  26   56:ifle            518
    //*  27   59:aload_1         
    //*  28   60:invokevirtual   #186 <Method int Instances.numAttributes()>
    //*  29   63:ifle            518
        {
            JPanel padder = new JPanel();
    //   30   66:new             #265 <Class JPanel>
    //   31   69:dup             
    //   32   70:invokespecial   #269 <Method void JPanel()>
    //   33   73:astore_2        
            JPanel padd2 = new JPanel();
    //   34   74:new             #265 <Class JPanel>
    //   35   77:dup             
    //   36   78:invokespecial   #269 <Method void JPanel()>
    //   37   81:astore_3        
            m_heights = new int[ins.numInstances()];
    //   38   82:aload_0         
    //   39   83:aload_1         
    //   40   84:invokevirtual   #232 <Method int Instances.numInstances()>
    //   41   87:newarray        int[]
    //   42   89:putfield        #271 <Field int[] m_heights>
            m_cIndex = ins.numAttributes() - 1;
    //   43   92:aload_0         
    //   44   93:aload_1         
    //   45   94:invokevirtual   #186 <Method int Instances.numAttributes()>
    //   46   97:iconst_1        
    //   47   98:isub            
    //   48   99:putfield        #177 <Field int m_cIndex>
            for(int noa = 0; noa < ins.numInstances(); noa++)
    //*  49  102:iconst_0        
    //*  50  103:istore          4
    //*  51  105:goto            126
                m_heights[noa] = (int)(Math.random() * 19D);
    //   52  108:aload_0         
    //   53  109:getfield        #271 <Field int[] m_heights>
    //   54  112:iload           4
    //   55  114:invokestatic    #277 <Method double Math.random()>
    //   56  117:ldc2w           #278 <Double 19D>
    //   57  120:dmul            
    //   58  121:d2i             
    //   59  122:iastore         

    //   60  123:iinc            4  1
    //   61  126:iload           4
    //   62  128:aload_1         
    //   63  129:invokevirtual   #232 <Method int Instances.numInstances()>
    //   64  132:icmplt          108
            m_span.setPreferredSize(new Dimension(m_span.getPreferredSize().width, (m_cIndex + 1) * 20));
    //   65  135:aload_0         
    //   66  136:getfield        #136 <Field JPanel m_span>
    //   67  139:new             #281 <Class Dimension>
    //   68  142:dup             
    //   69  143:aload_0         
    //   70  144:getfield        #136 <Field JPanel m_span>
    //   71  147:invokevirtual   #285 <Method Dimension JPanel.getPreferredSize()>
    //   72  150:getfield        #288 <Field int Dimension.width>
    //   73  153:aload_0         
    //   74  154:getfield        #177 <Field int m_cIndex>
    //   75  157:iconst_1        
    //   76  158:iadd            
    //   77  159:bipush          20
    //   78  161:imul            
    //   79  162:invokespecial   #291 <Method void Dimension(int, int)>
    //   80  165:invokevirtual   #295 <Method void JPanel.setPreferredSize(Dimension)>
            m_span.setMaximumSize(new Dimension(m_span.getMaximumSize().width, (m_cIndex + 1) * 20));
    //   81  168:aload_0         
    //   82  169:getfield        #136 <Field JPanel m_span>
    //   83  172:new             #281 <Class Dimension>
    //   84  175:dup             
    //   85  176:aload_0         
    //   86  177:getfield        #136 <Field JPanel m_span>
    //   87  180:invokevirtual   #298 <Method Dimension JPanel.getMaximumSize()>
    //   88  183:getfield        #288 <Field int Dimension.width>
    //   89  186:aload_0         
    //   90  187:getfield        #177 <Field int m_cIndex>
    //   91  190:iconst_1        
    //   92  191:iadd            
    //   93  192:bipush          20
    //   94  194:imul            
    //   95  195:invokespecial   #291 <Method void Dimension(int, int)>
    //   96  198:invokevirtual   #301 <Method void JPanel.setMaximumSize(Dimension)>
            GridBagLayout gb = new GridBagLayout();
    //   97  201:new             #303 <Class GridBagLayout>
    //   98  204:dup             
    //   99  205:invokespecial   #304 <Method void GridBagLayout()>
    //  100  208:astore          5
            GridBagLayout gb2 = new GridBagLayout();
    //  101  210:new             #303 <Class GridBagLayout>
    //  102  213:dup             
    //  103  214:invokespecial   #304 <Method void GridBagLayout()>
    //  104  217:astore          6
            GridBagConstraints constraints = new GridBagConstraints();
    //  105  219:new             #306 <Class GridBagConstraints>
    //  106  222:dup             
    //  107  223:invokespecial   #307 <Method void GridBagConstraints()>
    //  108  226:astore          7
            padder.setLayout(gb);
    //  109  228:aload_2         
    //  110  229:aload           5
    //  111  231:invokevirtual   #311 <Method void JPanel.setLayout(java.awt.LayoutManager)>
            m_span.setLayout(gb2);
    //  112  234:aload_0         
    //  113  235:getfield        #136 <Field JPanel m_span>
    //  114  238:aload           6
    //  115  240:invokevirtual   #311 <Method void JPanel.setLayout(java.awt.LayoutManager)>
            constraints.anchor = 10;
    //  116  243:aload           7
    //  117  245:bipush          10
    //  118  247:putfield        #314 <Field int GridBagConstraints.anchor>
            constraints.gridx = 0;
    //  119  250:aload           7
    //  120  252:iconst_0        
    //  121  253:putfield        #317 <Field int GridBagConstraints.gridx>
            constraints.gridy = 0;
    //  122  256:aload           7
    //  123  258:iconst_0        
    //  124  259:putfield        #320 <Field int GridBagConstraints.gridy>
            constraints.weightx = 5D;
    //  125  262:aload           7
    //  126  264:ldc2w           #321 <Double 5D>
    //  127  267:putfield        #325 <Field double GridBagConstraints.weightx>
            constraints.fill = 2;
    //  128  270:aload           7
    //  129  272:iconst_2        
    //  130  273:putfield        #328 <Field int GridBagConstraints.fill>
            constraints.gridwidth = 1;
    //  131  276:aload           7
    //  132  278:iconst_1        
    //  133  279:putfield        #331 <Field int GridBagConstraints.gridwidth>
            constraints.gridheight = 1;
    //  134  282:aload           7
    //  135  284:iconst_1        
    //  136  285:putfield        #334 <Field int GridBagConstraints.gridheight>
            constraints.insets = new Insets(0, 0, 0, 0);
    //  137  288:aload           7
    //  138  290:new             #336 <Class Insets>
    //  139  293:dup             
    //  140  294:iconst_0        
    //  141  295:iconst_0        
    //  142  296:iconst_0        
    //  143  297:iconst_0        
    //  144  298:invokespecial   #339 <Method void Insets(int, int, int, int)>
    //  145  301:putfield        #343 <Field Insets GridBagConstraints.insets>
            padder.add(m_span, constraints);
    //  146  304:aload_2         
    //  147  305:aload_0         
    //  148  306:getfield        #136 <Field JPanel m_span>
    //  149  309:aload           7
    //  150  311:invokevirtual   #347 <Method void JPanel.add(java.awt.Component, Object)>
            constraints.gridx = 0;
    //  151  314:aload           7
    //  152  316:iconst_0        
    //  153  317:putfield        #317 <Field int GridBagConstraints.gridx>
            constraints.gridy = 1;
    //  154  320:aload           7
    //  155  322:iconst_1        
    //  156  323:putfield        #320 <Field int GridBagConstraints.gridy>
            constraints.weightx = 5D;
    //  157  326:aload           7
    //  158  328:ldc2w           #321 <Double 5D>
    //  159  331:putfield        #325 <Field double GridBagConstraints.weightx>
            constraints.fill = 1;
    //  160  334:aload           7
    //  161  336:iconst_1        
    //  162  337:putfield        #328 <Field int GridBagConstraints.fill>
            constraints.gridwidth = 1;
    //  163  340:aload           7
    //  164  342:iconst_1        
    //  165  343:putfield        #331 <Field int GridBagConstraints.gridwidth>
            constraints.gridheight = 1;
    //  166  346:aload           7
    //  167  348:iconst_1        
    //  168  349:putfield        #334 <Field int GridBagConstraints.gridheight>
            constraints.weighty = 5D;
    //  169  352:aload           7
    //  170  354:ldc2w           #321 <Double 5D>
    //  171  357:putfield        #350 <Field double GridBagConstraints.weighty>
            constraints.insets = new Insets(0, 0, 0, 0);
    //  172  360:aload           7
    //  173  362:new             #336 <Class Insets>
    //  174  365:dup             
    //  175  366:iconst_0        
    //  176  367:iconst_0        
    //  177  368:iconst_0        
    //  178  369:iconst_0        
    //  179  370:invokespecial   #339 <Method void Insets(int, int, int, int)>
    //  180  373:putfield        #343 <Field Insets GridBagConstraints.insets>
            padder.add(padd2, constraints);
    //  181  376:aload_2         
    //  182  377:aload_3         
    //  183  378:aload           7
    //  184  380:invokevirtual   #347 <Method void JPanel.add(java.awt.Component, Object)>
            constraints.weighty = 0.0D;
    //  185  383:aload           7
    //  186  385:dconst_0        
    //  187  386:putfield        #350 <Field double GridBagConstraints.weighty>
            setViewportView(padder);
    //  188  389:aload_0         
    //  189  390:aload_2         
    //  190  391:invokevirtual   #354 <Method void setViewportView(java.awt.Component)>
            constraints.anchor = 10;
    //  191  394:aload           7
    //  192  396:bipush          10
    //  193  398:putfield        #314 <Field int GridBagConstraints.anchor>
            constraints.gridx = 0;
    //  194  401:aload           7
    //  195  403:iconst_0        
    //  196  404:putfield        #317 <Field int GridBagConstraints.gridx>
            constraints.gridy = 0;
    //  197  407:aload           7
    //  198  409:iconst_0        
    //  199  410:putfield        #320 <Field int GridBagConstraints.gridy>
            constraints.weightx = 5D;
    //  200  413:aload           7
    //  201  415:ldc2w           #321 <Double 5D>
    //  202  418:putfield        #325 <Field double GridBagConstraints.weightx>
            constraints.fill = 2;
    //  203  421:aload           7
    //  204  423:iconst_2        
    //  205  424:putfield        #328 <Field int GridBagConstraints.fill>
            constraints.gridwidth = 1;
    //  206  427:aload           7
    //  207  429:iconst_1        
    //  208  430:putfield        #331 <Field int GridBagConstraints.gridwidth>
            constraints.gridheight = 1;
    //  209  433:aload           7
    //  210  435:iconst_1        
    //  211  436:putfield        #334 <Field int GridBagConstraints.gridheight>
            constraints.weighty = 5D;
    //  212  439:aload           7
    //  213  441:ldc2w           #321 <Double 5D>
    //  214  444:putfield        #350 <Field double GridBagConstraints.weighty>
            constraints.insets = new Insets(2, 20, 2, 4);
    //  215  447:aload           7
    //  216  449:new             #336 <Class Insets>
    //  217  452:dup             
    //  218  453:iconst_2        
    //  219  454:bipush          20
    //  220  456:iconst_2        
    //  221  457:iconst_4        
    //  222  458:invokespecial   #339 <Method void Insets(int, int, int, int)>
    //  223  461:putfield        #343 <Field Insets GridBagConstraints.insets>
            for(int noa = 0; noa < ins.numAttributes(); noa++)
    //* 224  464:iconst_0        
    //* 225  465:istore          8
    //* 226  467:goto            509
            {
                AttributeSpacing tmp = new AttributeSpacing(ins.attribute(noa), noa);
    //  227  470:new             #356 <Class AttributePanel$AttributeSpacing>
    //  228  473:dup             
    //  229  474:aload_0         
    //  230  475:aload_1         
    //  231  476:iload           8
    //  232  478:invokevirtual   #190 <Method Attribute Instances.attribute(int)>
    //  233  481:iload           8
    //  234  483:invokespecial   #359 <Method void AttributePanel$AttributeSpacing(AttributePanel, Attribute, int)>
    //  235  486:astore          4
                constraints.gridy = noa;
    //  236  488:aload           7
    //  237  490:iload           8
    //  238  492:putfield        #320 <Field int GridBagConstraints.gridy>
                m_span.add(tmp, constraints);
    //  239  495:aload_0         
    //  240  496:getfield        #136 <Field JPanel m_span>
    //  241  499:aload           4
    //  242  501:aload           7
    //  243  503:invokevirtual   #347 <Method void JPanel.add(java.awt.Component, Object)>
            }

    //  244  506:iinc            8  1
    //  245  509:iload           8
    //  246  511:aload_1         
    //  247  512:invokevirtual   #186 <Method int Instances.numAttributes()>
    //  248  515:icmplt          470
        }
    //  249  518:return          
    }

    public void setX(int x)
    {
        if(m_span != null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #136 <Field JPanel m_span>
    //*   2    4:ifnull          19
        {
            m_xIndex = x;
    //    3    7:aload_0         
    //    4    8:iload_1         
    //    5    9:putfield        #372 <Field int m_xIndex>
            m_span.repaint();
    //    6   12:aload_0         
    //    7   13:getfield        #136 <Field JPanel m_span>
    //    8   16:invokevirtual   #373 <Method void JPanel.repaint()>
        }
    //    9   19:return          
    }

    public void setY(int y)
    {
        if(m_span != null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #136 <Field JPanel m_span>
    //*   2    4:ifnull          19
        {
            m_yIndex = y;
    //    3    7:aload_0         
    //    4    8:iload_1         
    //    5    9:putfield        #377 <Field int m_yIndex>
            m_span.repaint();
    //    6   12:aload_0         
    //    7   13:getfield        #136 <Field JPanel m_span>
    //    8   16:invokevirtual   #373 <Method void JPanel.repaint()>
        }
    //    9   19:return          
    }

    public static void main(String args[])
    {
        try
        {
            if(args.length < 1)
    //*   0    0:aload_0         
    //*   1    1:arraylength     
    //*   2    2:iconst_1        
    //*   3    3:icmpge          19
            {
                System.err.println("Usage : weka.gui.visualize.AttributePanel <dataset> [class col]");
    //    4    6:getstatic       #386 <Field PrintStream System.err>
    //    5    9:ldc2            #388 <String "Usage : weka.gui.visualize.AttributePanel <dataset> [class col]">
    //    6   12:invokevirtual   #393 <Method void PrintStream.println(String)>
                System.exit(1);
    //    7   15:iconst_1        
    //    8   16:invokestatic    #396 <Method void System.exit(int)>
            }
            final JFrame jf = new JFrame("Weka Explorer: Attribute");
    //    9   19:new             #398 <Class JFrame>
    //   10   22:dup             
    //   11   23:ldc2            #400 <String "Weka Explorer: Attribute">
    //   12   26:invokespecial   #401 <Method void JFrame(String)>
    //   13   29:astore_1        
            jf.setSize(100, 100);
    //   14   30:aload_1         
    //   15   31:bipush          100
    //   16   33:bipush          100
    //   17   35:invokevirtual   #404 <Method void JFrame.setSize(int, int)>
            jf.getContentPane().setLayout(new BorderLayout());
    //   18   38:aload_1         
    //   19   39:invokevirtual   #408 <Method Container JFrame.getContentPane()>
    //   20   42:new             #410 <Class BorderLayout>
    //   21   45:dup             
    //   22   46:invokespecial   #411 <Method void BorderLayout()>
    //   23   49:invokevirtual   #414 <Method void Container.setLayout(java.awt.LayoutManager)>
            AttributePanel p2 = new AttributePanel();
    //   24   52:new             #2   <Class AttributePanel>
    //   25   55:dup             
    //   26   56:invokespecial   #415 <Method void AttributePanel()>
    //   27   59:astore_2        
            p2.addAttributePanelListener(new AttributePanelListener() {

                public void attributeSelectionChange(AttributePanelEvent e)
                {
                    if(e.m_xChange)
                //*   0    0:aload_1         
                //*   1    1:getfield        #23  <Field boolean AttributePanelEvent.m_xChange>
                //*   2    4:ifeq            35
                        System.err.println((new StringBuilder("X index changed to : ")).append(e.m_indexVal).toString());
                //    3    7:getstatic       #29  <Field PrintStream System.err>
                //    4   10:new             #31  <Class StringBuilder>
                //    5   13:dup             
                //    6   14:ldc1            #33  <String "X index changed to : ">
                //    7   16:invokespecial   #36  <Method void StringBuilder(String)>
                //    8   19:aload_1         
                //    9   20:getfield        #40  <Field int AttributePanelEvent.m_indexVal>
                //   10   23:invokevirtual   #44  <Method StringBuilder StringBuilder.append(int)>
                //   11   26:invokevirtual   #48  <Method String StringBuilder.toString()>
                //   12   29:invokevirtual   #53  <Method void PrintStream.println(String)>
                    else
                //*  13   32:goto            60
                        System.err.println((new StringBuilder("Y index changed to : ")).append(e.m_indexVal).toString());
                //   14   35:getstatic       #29  <Field PrintStream System.err>
                //   15   38:new             #31  <Class StringBuilder>
                //   16   41:dup             
                //   17   42:ldc1            #55  <String "Y index changed to : ">
                //   18   44:invokespecial   #36  <Method void StringBuilder(String)>
                //   19   47:aload_1         
                //   20   48:getfield        #40  <Field int AttributePanelEvent.m_indexVal>
                //   21   51:invokevirtual   #44  <Method StringBuilder StringBuilder.append(int)>
                //   22   54:invokevirtual   #48  <Method String StringBuilder.toString()>
                //   23   57:invokevirtual   #53  <Method void PrintStream.println(String)>
                //   24   60:return          
                }

            }
);
    //   28   60:aload_2         
    //   29   61:new             #417 <Class AttributePanel$3>
    //   30   64:dup             
    //   31   65:invokespecial   #418 <Method void AttributePanel$3()>
    //   32   68:invokevirtual   #420 <Method void addAttributePanelListener(AttributePanelListener)>
            jf.getContentPane().add(p2, "Center");
    //   33   71:aload_1         
    //   34   72:invokevirtual   #408 <Method Container JFrame.getContentPane()>
    //   35   75:aload_2         
    //   36   76:ldc2            #422 <String "Center">
    //   37   79:invokevirtual   #423 <Method void Container.add(java.awt.Component, Object)>
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
    //   38   82:aload_1         
    //   39   83:new             #425 <Class AttributePanel$4>
    //   40   86:dup             
    //   41   87:aload_1         
    //   42   88:invokespecial   #428 <Method void AttributePanel$4(JFrame)>
    //   43   91:invokevirtual   #432 <Method void JFrame.addWindowListener(java.awt.event.WindowListener)>
            if(args.length >= 1)
    //*  44   94:aload_0         
    //*  45   95:arraylength     
    //*  46   96:iconst_1        
    //*  47   97:icmplt          171
            {
                System.err.println((new StringBuilder("Loading instances from ")).append(args[0]).toString());
    //   48  100:getstatic       #386 <Field PrintStream System.err>
    //   49  103:new             #53  <Class StringBuilder>
    //   50  106:dup             
    //   51  107:ldc2            #434 <String "Loading instances from ">
    //   52  110:invokespecial   #63  <Method void StringBuilder(String)>
    //   53  113:aload_0         
    //   54  114:iconst_0        
    //   55  115:aaload          
    //   56  116:invokevirtual   #69  <Method StringBuilder StringBuilder.append(String)>
    //   57  119:invokevirtual   #72  <Method String StringBuilder.toString()>
    //   58  122:invokevirtual   #393 <Method void PrintStream.println(String)>
                java.io.Reader r = new BufferedReader(new FileReader(args[0]));
    //   59  125:new             #436 <Class BufferedReader>
    //   60  128:dup             
    //   61  129:new             #438 <Class FileReader>
    //   62  132:dup             
    //   63  133:aload_0         
    //   64  134:iconst_0        
    //   65  135:aaload          
    //   66  136:invokespecial   #439 <Method void FileReader(String)>
    //   67  139:invokespecial   #442 <Method void BufferedReader(java.io.Reader)>
    //   68  142:astore_3        
                Instances i = new Instances(r);
    //   69  143:new             #183 <Class Instances>
    //   70  146:dup             
    //   71  147:aload_3         
    //   72  148:invokespecial   #443 <Method void Instances(java.io.Reader)>
    //   73  151:astore          4
                i.setClassIndex(i.numAttributes() - 1);
    //   74  153:aload           4
    //   75  155:aload           4
    //   76  157:invokevirtual   #186 <Method int Instances.numAttributes()>
    //   77  160:iconst_1        
    //   78  161:isub            
    //   79  162:invokevirtual   #446 <Method void Instances.setClassIndex(int)>
                p2.setInstances(i);
    //   80  165:aload_2         
    //   81  166:aload           4
    //   82  168:invokevirtual   #448 <Method void setInstances(Instances)>
            }
            if(args.length > 1)
    //*  83  171:aload_0         
    //*  84  172:arraylength     
    //*  85  173:iconst_1        
    //*  86  174:icmple          192
                p2.setCindex(Integer.parseInt(args[1]) - 1);
    //   87  177:aload_2         
    //   88  178:aload_0         
    //   89  179:iconst_1        
    //   90  180:aaload          
    //   91  181:invokestatic    #454 <Method int Integer.parseInt(String)>
    //   92  184:iconst_1        
    //   93  185:isub            
    //   94  186:invokevirtual   #456 <Method void setCindex(int)>
            else
    //*  95  189:goto            197
                p2.setCindex(0);
    //   96  192:aload_2         
    //   97  193:iconst_0        
    //   98  194:invokevirtual   #456 <Method void setCindex(int)>
            jf.setVisible(true);
    //   99  197:aload_1         
    //  100  198:iconst_1        
    //  101  199:invokevirtual   #460 <Method void JFrame.setVisible(boolean)>
        }
    //* 102  202:goto            220
        catch(Exception ex)
    //* 103  205:astore_1        
        {
            ex.printStackTrace();
    //  104  206:aload_1         
    //  105  207:invokevirtual   #463 <Method void Exception.printStackTrace()>
            System.err.println(ex.getMessage());
    //  106  210:getstatic       #386 <Field PrintStream System.err>
    //  107  213:aload_1         
    //  108  214:invokevirtual   #466 <Method String Exception.getMessage()>
    //  109  217:invokevirtual   #393 <Method void PrintStream.println(String)>
        }
    //  110  220:return          
    }

    private static final long serialVersionUID = 0x3108e93422fd67b6L;
    protected Instances m_plotInstances;
    protected double m_maxC;
    protected double m_minC;
    protected int m_cIndex;
    protected int m_xIndex;
    protected int m_yIndex;
    protected FastVector m_colorList;
    protected Color m_DefaultColors[];
    protected Color m_backgroundColor;
    protected FastVector m_Listeners;
    protected int m_heights[];
    protected JPanel m_span;
    protected Color m_barColour;
}
