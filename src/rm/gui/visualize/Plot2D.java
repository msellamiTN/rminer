// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   Plot2D.java

package rm.gui.visualize;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Properties;
import java.util.Random;
import javax.swing.*;
import rm.core.*;

// Referenced classes of package rm.gui.visualize:
//            VisualizeUtils, PlotData2D, Plot2DCompanion

public class Plot2D extends JPanel
{

    public Plot2D()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #85  <Method void JPanel()>
        m_axisColour = Color.green;
    //    2    4:aload_0         
    //    3    5:getstatic       #90  <Field Color Color.green>
    //    4    8:putfield        #92  <Field Color m_axisColour>
        m_backgroundColour = Color.black;
    //    5   11:aload_0         
    //    6   12:getstatic       #95  <Field Color Color.black>
    //    7   15:putfield        #97  <Field Color m_backgroundColour>
        m_plots = new FastVector();
    //    8   18:aload_0         
    //    9   19:new             #99  <Class FastVector>
    //   10   22:dup             
    //   11   23:invokespecial   #100 <Method void FastVector()>
    //   12   26:putfield        #102 <Field FastVector m_plots>
        m_masterPlot = null;
    //   13   29:aload_0         
    //   14   30:aconst_null     
    //   15   31:putfield        #104 <Field PlotData2D m_masterPlot>
        m_masterName = "master plot";
    //   16   34:aload_0         
    //   17   35:ldc1            #106 <String "master plot">
    //   18   37:putfield        #108 <Field String m_masterName>
        m_plotInstances = null;
    //   19   40:aload_0         
    //   20   41:aconst_null     
    //   21   42:putfield        #110 <Field Instances m_plotInstances>
        m_plotCompanion = null;
    //   22   45:aload_0         
    //   23   46:aconst_null     
    //   24   47:putfield        #112 <Field Plot2DCompanion m_plotCompanion>
        m_InstanceInfo = null;
    //   25   50:aload_0         
    //   26   51:aconst_null     
    //   27   52:putfield        #114 <Field JFrame m_InstanceInfo>
        m_InstanceInfoText = new JTextArea();
    //   28   55:aload_0         
    //   29   56:new             #116 <Class JTextArea>
    //   30   59:dup             
    //   31   60:invokespecial   #117 <Method void JTextArea()>
    //   32   63:putfield        #119 <Field JTextArea m_InstanceInfoText>
        m_DefaultColors = (new Color[] {
            Color.blue, Color.red, Color.green, Color.cyan, Color.pink, new Color(255, 0, 255), Color.orange, new Color(255, 0, 0), new Color(0, 255, 0), Color.white
        });
    //   33   66:aload_0         
    //   34   67:bipush          10
    //   35   69:anewarray       Color[]
    //   36   72:dup             
    //   37   73:iconst_0        
    //   38   74:getstatic       #122 <Field Color Color.blue>
    //   39   77:aastore         
    //   40   78:dup             
    //   41   79:iconst_1        
    //   42   80:getstatic       #125 <Field Color Color.red>
    //   43   83:aastore         
    //   44   84:dup             
    //   45   85:iconst_2        
    //   46   86:getstatic       #90  <Field Color Color.green>
    //   47   89:aastore         
    //   48   90:dup             
    //   49   91:iconst_3        
    //   50   92:getstatic       #128 <Field Color Color.cyan>
    //   51   95:aastore         
    //   52   96:dup             
    //   53   97:iconst_4        
    //   54   98:getstatic       #131 <Field Color Color.pink>
    //   55  101:aastore         
    //   56  102:dup             
    //   57  103:iconst_5        
    //   58  104:new             #87  <Class Color>
    //   59  107:dup             
    //   60  108:sipush          255
    //   61  111:iconst_0        
    //   62  112:sipush          255
    //   63  115:invokespecial   #134 <Method void Color(int, int, int)>
    //   64  118:aastore         
    //   65  119:dup             
    //   66  120:bipush          6
    //   67  122:getstatic       #137 <Field Color Color.orange>
    //   68  125:aastore         
    //   69  126:dup             
    //   70  127:bipush          7
    //   71  129:new             #87  <Class Color>
    //   72  132:dup             
    //   73  133:sipush          255
    //   74  136:iconst_0        
    //   75  137:iconst_0        
    //   76  138:invokespecial   #134 <Method void Color(int, int, int)>
    //   77  141:aastore         
    //   78  142:dup             
    //   79  143:bipush          8
    //   80  145:new             #87  <Class Color>
    //   81  148:dup             
    //   82  149:iconst_0        
    //   83  150:sipush          255
    //   84  153:iconst_0        
    //   85  154:invokespecial   #134 <Method void Color(int, int, int)>
    //   86  157:aastore         
    //   87  158:dup             
    //   88  159:bipush          9
    //   89  161:getstatic       #140 <Field Color Color.white>
    //   90  164:aastore         
    //   91  165:putfield        #142 <Field Color[] m_DefaultColors>
        m_xIndex = 0;
    //   92  168:aload_0         
    //   93  169:iconst_0        
    //   94  170:putfield        #144 <Field int m_xIndex>
        m_yIndex = 0;
    //   95  173:aload_0         
    //   96  174:iconst_0        
    //   97  175:putfield        #146 <Field int m_yIndex>
        m_cIndex = 0;
    //   98  178:aload_0         
    //   99  179:iconst_0        
    //  100  180:putfield        #148 <Field int m_cIndex>
        m_sIndex = 0;
    //  101  183:aload_0         
    //  102  184:iconst_0        
    //  103  185:putfield        #150 <Field int m_sIndex>
    //  104  188:aload_0         
    //  105  189:iconst_5        
    //  106  190:putfield        #152 <Field int m_axisPad>
    //  107  193:aload_0         
    //  108  194:iconst_5        
    //  109  195:putfield        #154 <Field int m_tickSize>
        m_XaxisStart = 0;
    //  110  198:aload_0         
    //  111  199:iconst_0        
    //  112  200:putfield        #156 <Field int m_XaxisStart>
        m_YaxisStart = 0;
    //  113  203:aload_0         
    //  114  204:iconst_0        
    //  115  205:putfield        #158 <Field int m_YaxisStart>
        m_XaxisEnd = 0;
    //  116  208:aload_0         
    //  117  209:iconst_0        
    //  118  210:putfield        #160 <Field int m_XaxisEnd>
        m_YaxisEnd = 0;
    //  119  213:aload_0         
    //  120  214:iconst_0        
    //  121  215:putfield        #162 <Field int m_YaxisEnd>
        m_plotResize = true;
    //  122  218:aload_0         
    //  123  219:iconst_1        
    //  124  220:putfield        #164 <Field boolean m_plotResize>
        m_axisChanged = false;
    //  125  223:aload_0         
    //  126  224:iconst_0        
    //  127  225:putfield        #166 <Field boolean m_axisChanged>
        m_labelMetrics = null;
    //  128  228:aload_0         
    //  129  229:aconst_null     
    //  130  230:putfield        #168 <Field FontMetrics m_labelMetrics>
        m_JitterVal = 0;
    //  131  233:aload_0         
    //  132  234:iconst_0        
    //  133  235:putfield        #170 <Field int m_JitterVal>
        m_JRand = new Random(0L);
    //  134  238:aload_0         
    //  135  239:new             #172 <Class Random>
    //  136  242:dup             
    //  137  243:lconst_0        
    //  138  244:invokespecial   #175 <Method void Random(long)>
    //  139  247:putfield        #177 <Field Random m_JRand>
        m_pointLookup = null;
    //  140  250:aload_0         
    //  141  251:aconst_null     
    //  142  252:putfield        #179 <Field double[][] m_pointLookup>
        setProperties();
    //  143  255:aload_0         
    //  144  256:invokespecial   #182 <Method void setProperties()>
        setBackground(m_backgroundColour);
    //  145  259:aload_0         
    //  146  260:aload_0         
    //  147  261:getfield        #97  <Field Color m_backgroundColour>
    //  148  264:invokevirtual   #186 <Method void setBackground(Color)>
        m_InstanceInfoText.setFont(new Font("Monospaced", 0, 12));
    //  149  267:aload_0         
    //  150  268:getfield        #119 <Field JTextArea m_InstanceInfoText>
    //  151  271:new             #188 <Class Font>
    //  152  274:dup             
    //  153  275:ldc1            #190 <String "Monospaced">
    //  154  277:iconst_0        
    //  155  278:bipush          12
    //  156  280:invokespecial   #193 <Method void Font(String, int, int)>
    //  157  283:invokevirtual   #197 <Method void JTextArea.setFont(Font)>
        m_InstanceInfoText.setEditable(false);
    //  158  286:aload_0         
    //  159  287:getfield        #119 <Field JTextArea m_InstanceInfoText>
    //  160  290:iconst_0        
    //  161  291:invokevirtual   #201 <Method void JTextArea.setEditable(boolean)>
        m_drawnPoints = new int[getWidth()][getHeight()];
    //  162  294:aload_0         
    //  163  295:aload_0         
    //  164  296:invokevirtual   #205 <Method int getWidth()>
    //  165  299:aload_0         
    //  166  300:invokevirtual   #208 <Method int getHeight()>
    //  167  303:multianewarray  int[][]
    //  168  307:putfield        #211 <Field int[][] m_drawnPoints>
        m_colorList = new FastVector(10);
    //  169  310:aload_0         
    //  170  311:new             #99  <Class FastVector>
    //  171  314:dup             
    //  172  315:bipush          10
    //  173  317:invokespecial   #214 <Method void FastVector(int)>
    //  174  320:putfield        #216 <Field FastVector m_colorList>
        for(int noa = m_colorList.size(); noa < 10; noa++)
    //* 175  323:aload_0         
    //* 176  324:getfield        #216 <Field FastVector m_colorList>
    //* 177  327:invokevirtual   #219 <Method int FastVector.size()>
    //* 178  330:istore_1        
    //* 179  331:goto            384
        {
            Color pc = m_DefaultColors[noa % 10];
    //  180  334:aload_0         
    //  181  335:getfield        #142 <Field Color[] m_DefaultColors>
    //  182  338:iload_1         
    //  183  339:bipush          10
    //  184  341:irem            
    //  185  342:aaload          
    //  186  343:astore_2        
            int ija = noa / 10;
    //  187  344:iload_1         
    //  188  345:bipush          10
    //  189  347:idiv            
    //  190  348:istore_3        
            ija *= 2;
    //  191  349:iload_3         
    //  192  350:iconst_2        
    //  193  351:imul            
    //  194  352:istore_3        
            for(int j = 0; j < ija; j++)
    //* 195  353:iconst_0        
    //* 196  354:istore          4
    //* 197  356:goto            367
                pc = pc.darker();
    //  198  359:aload_2         
    //  199  360:invokevirtual   #223 <Method Color Color.darker()>
    //  200  363:astore_2        

    //  201  364:iinc            4  1
    //  202  367:iload           4
    //  203  369:iload_3         
    //  204  370:icmplt          359
            m_colorList.addElement(pc);
    //  205  373:aload_0         
    //  206  374:getfield        #216 <Field FastVector m_colorList>
    //  207  377:aload_2         
    //  208  378:invokevirtual   #227 <Method void FastVector.addElement(Object)>
        }

    //  209  381:iinc            1  1
    //  210  384:iload_1         
    //  211  385:bipush          10
    //  212  387:icmplt          334
    //  213  390:return          
    }

    private void setProperties()
    {
        if(VisualizeUtils.VISUALIZE_PROPERTIES != null)
    //*   0    0:getstatic       #241 <Field Properties VisualizeUtils.VISUALIZE_PROPERTIES>
    //*   1    3:ifnull          110
        {
            String thisClass = getClass().getName();
    //    2    6:aload_0         
    //    3    7:invokevirtual   #247 <Method Class Object.getClass()>
    //    4   10:invokevirtual   #253 <Method String Class.getName()>
    //    5   13:astore_1        
            String axisKey = (new StringBuilder(String.valueOf(thisClass))).append(".axisColour").toString();
    //    6   14:new             #255 <Class StringBuilder>
    //    7   17:dup             
    //    8   18:aload_1         
    //    9   19:invokestatic    #261 <Method String String.valueOf(Object)>
    //   10   22:invokespecial   #264 <Method void StringBuilder(String)>
    //   11   25:ldc2            #266 <String ".axisColour">
    //   12   28:invokevirtual   #270 <Method StringBuilder StringBuilder.append(String)>
    //   13   31:invokevirtual   #273 <Method String StringBuilder.toString()>
    //   14   34:astore_2        
            String backgroundKey = (new StringBuilder(String.valueOf(thisClass))).append(".backgroundColour").toString();
    //   15   35:new             #255 <Class StringBuilder>
    //   16   38:dup             
    //   17   39:aload_1         
    //   18   40:invokestatic    #261 <Method String String.valueOf(Object)>
    //   19   43:invokespecial   #264 <Method void StringBuilder(String)>
    //   20   46:ldc2            #275 <String ".backgroundColour">
    //   21   49:invokevirtual   #270 <Method StringBuilder StringBuilder.append(String)>
    //   22   52:invokevirtual   #273 <Method String StringBuilder.toString()>
    //   23   55:astore_3        
            String axisColour = VisualizeUtils.VISUALIZE_PROPERTIES.getProperty(axisKey);
    //   24   56:getstatic       #241 <Field Properties VisualizeUtils.VISUALIZE_PROPERTIES>
    //   25   59:aload_2         
    //   26   60:invokevirtual   #281 <Method String Properties.getProperty(String)>
    //   27   63:astore          4
            if(axisColour != null)
    //*  28   65:aload           4
    //*  29   67:ifnull          83
                m_axisColour = VisualizeUtils.processColour(axisColour, m_axisColour);
    //   30   70:aload_0         
    //   31   71:aload           4
    //   32   73:aload_0         
    //   33   74:getfield        #92  <Field Color m_axisColour>
    //   34   77:invokestatic    #285 <Method Color VisualizeUtils.processColour(String, Color)>
    //   35   80:putfield        #92  <Field Color m_axisColour>
            String backgroundColour = VisualizeUtils.VISUALIZE_PROPERTIES.getProperty(backgroundKey);
    //   36   83:getstatic       #241 <Field Properties VisualizeUtils.VISUALIZE_PROPERTIES>
    //   37   86:aload_3         
    //   38   87:invokevirtual   #281 <Method String Properties.getProperty(String)>
    //   39   90:astore          5
            if(backgroundColour != null)
    //*  40   92:aload           5
    //*  41   94:ifnull          110
                m_backgroundColour = VisualizeUtils.processColour(backgroundColour, m_backgroundColour);
    //   42   97:aload_0         
    //   43   98:aload           5
    //   44  100:aload_0         
    //   45  101:getfield        #97  <Field Color m_backgroundColour>
    //   46  104:invokestatic    #285 <Method Color VisualizeUtils.processColour(String, Color)>
    //   47  107:putfield        #97  <Field Color m_backgroundColour>
        }
    //   48  110:return          
    }

    private boolean checkPoints(double x1, double y1)
    {
        return x1 >= 0.0D && x1 <= (double)getSize().width && y1 >= 0.0D && y1 <= (double)getSize().height;
    //    0    0:dload_1         
    //    1    1:dconst_0        
    //    2    2:dcmpg           
    //    3    3:iflt            38
    //    4    6:dload_1         
    //    5    7:aload_0         
    //    6    8:invokevirtual   #296 <Method Dimension getSize()>
    //    7   11:getfield        #301 <Field int Dimension.width>
    //    8   14:i2d             
    //    9   15:dcmpl           
    //   10   16:ifgt            38
    //   11   19:dload_3         
    //   12   20:dconst_0        
    //   13   21:dcmpg           
    //   14   22:iflt            38
    //   15   25:dload_3         
    //   16   26:aload_0         
    //   17   27:invokevirtual   #296 <Method Dimension getSize()>
    //   18   30:getfield        #304 <Field int Dimension.height>
    //   19   33:i2d             
    //   20   34:dcmpl           
    //   21   35:ifle            40
    //   22   38:iconst_0        
    //   23   39:ireturn         
    //   24   40:iconst_1        
    //   25   41:ireturn         
    }

    public void setPlotCompanion(Plot2DCompanion p)
    {
        m_plotCompanion = p;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #112 <Field Plot2DCompanion m_plotCompanion>
    //    3    5:return          
    }

    public void setJitter(int j)
    {
        if(m_plotInstances.numAttributes() > 0 && m_plotInstances.numInstances() > 0 && j >= 0)
    //*   0    0:aload_0         
    //*   1    1:getfield        #110 <Field Instances m_plotInstances>
    //*   2    4:invokevirtual   #315 <Method int Instances.numAttributes()>
    //*   3    7:ifle            83
    //*   4   10:aload_0         
    //*   5   11:getfield        #110 <Field Instances m_plotInstances>
    //*   6   14:invokevirtual   #318 <Method int Instances.numInstances()>
    //*   7   17:ifle            83
    //*   8   20:iload_1         
    //*   9   21:iflt            83
        {
            m_JitterVal = j;
    //   10   24:aload_0         
    //   11   25:iload_1         
    //   12   26:putfield        #170 <Field int m_JitterVal>
            m_JRand = new Random(m_JitterVal);
    //   13   29:aload_0         
    //   14   30:new             #172 <Class Random>
    //   15   33:dup             
    //   16   34:aload_0         
    //   17   35:getfield        #170 <Field int m_JitterVal>
    //   18   38:i2l             
    //   19   39:invokespecial   #175 <Method void Random(long)>
    //   20   42:putfield        #177 <Field Random m_JRand>
            m_drawnPoints = new int[(m_XaxisEnd - m_XaxisStart) + 1][(m_YaxisEnd - m_YaxisStart) + 1];
    //   21   45:aload_0         
    //   22   46:aload_0         
    //   23   47:getfield        #160 <Field int m_XaxisEnd>
    //   24   50:aload_0         
    //   25   51:getfield        #156 <Field int m_XaxisStart>
    //   26   54:isub            
    //   27   55:iconst_1        
    //   28   56:iadd            
    //   29   57:aload_0         
    //   30   58:getfield        #162 <Field int m_YaxisEnd>
    //   31   61:aload_0         
    //   32   62:getfield        #158 <Field int m_YaxisStart>
    //   33   65:isub            
    //   34   66:iconst_1        
    //   35   67:iadd            
    //   36   68:multianewarray  int[][]
    //   37   72:putfield        #211 <Field int[][] m_drawnPoints>
            updatePturb();
    //   38   75:aload_0         
    //   39   76:invokespecial   #321 <Method void updatePturb()>
            repaint();
    //   40   79:aload_0         
    //   41   80:invokevirtual   #324 <Method void repaint()>
        }
    //   42   83:return          
    }

    public void setColours(FastVector cols)
    {
        m_colorList = cols;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #216 <Field FastVector m_colorList>
    //    3    5:return          
    }

    public void setXindex(int x)
    {
        m_xIndex = x;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #144 <Field int m_xIndex>
        for(int i = 0; i < m_plots.size(); i++)
    //*   3    5:iconst_0        
    //*   4    6:istore_2        
    //*   5    7:goto            31
            ((PlotData2D)m_plots.elementAt(i)).setXindex(m_xIndex);
    //    6   10:aload_0         
    //    7   11:getfield        #102 <Field FastVector m_plots>
    //    8   14:iload_2         
    //    9   15:invokevirtual   #332 <Method Object FastVector.elementAt(int)>
    //   10   18:checkcast       #334 <Class PlotData2D>
    //   11   21:aload_0         
    //   12   22:getfield        #144 <Field int m_xIndex>
    //   13   25:invokevirtual   #336 <Method void PlotData2D.setXindex(int)>

    //   14   28:iinc            2  1
    //   15   31:iload_2         
    //   16   32:aload_0         
    //   17   33:getfield        #102 <Field FastVector m_plots>
    //   18   36:invokevirtual   #219 <Method int FastVector.size()>
    //   19   39:icmplt          10
        determineBounds();
    //   20   42:aload_0         
    //   21   43:invokevirtual   #339 <Method void determineBounds()>
        if(m_JitterVal != 0)
    //*  22   46:aload_0         
    //*  23   47:getfield        #170 <Field int m_JitterVal>
    //*  24   50:ifeq            57
            updatePturb();
    //   25   53:aload_0         
    //   26   54:invokespecial   #321 <Method void updatePturb()>
        m_axisChanged = true;
    //   27   57:aload_0         
    //   28   58:iconst_1        
    //   29   59:putfield        #166 <Field boolean m_axisChanged>
        repaint();
    //   30   62:aload_0         
    //   31   63:invokevirtual   #324 <Method void repaint()>
    //   32   66:return          
    }

    public void setYindex(int y)
    {
        m_yIndex = y;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #146 <Field int m_yIndex>
        for(int i = 0; i < m_plots.size(); i++)
    //*   3    5:iconst_0        
    //*   4    6:istore_2        
    //*   5    7:goto            31
            ((PlotData2D)m_plots.elementAt(i)).setYindex(m_yIndex);
    //    6   10:aload_0         
    //    7   11:getfield        #102 <Field FastVector m_plots>
    //    8   14:iload_2         
    //    9   15:invokevirtual   #332 <Method Object FastVector.elementAt(int)>
    //   10   18:checkcast       #334 <Class PlotData2D>
    //   11   21:aload_0         
    //   12   22:getfield        #146 <Field int m_yIndex>
    //   13   25:invokevirtual   #344 <Method void PlotData2D.setYindex(int)>

    //   14   28:iinc            2  1
    //   15   31:iload_2         
    //   16   32:aload_0         
    //   17   33:getfield        #102 <Field FastVector m_plots>
    //   18   36:invokevirtual   #219 <Method int FastVector.size()>
    //   19   39:icmplt          10
        determineBounds();
    //   20   42:aload_0         
    //   21   43:invokevirtual   #339 <Method void determineBounds()>
        if(m_JitterVal != 0)
    //*  22   46:aload_0         
    //*  23   47:getfield        #170 <Field int m_JitterVal>
    //*  24   50:ifeq            57
            updatePturb();
    //   25   53:aload_0         
    //   26   54:invokespecial   #321 <Method void updatePturb()>
        m_axisChanged = true;
    //   27   57:aload_0         
    //   28   58:iconst_1        
    //   29   59:putfield        #166 <Field boolean m_axisChanged>
        repaint();
    //   30   62:aload_0         
    //   31   63:invokevirtual   #324 <Method void repaint()>
    //   32   66:return          
    }

    public void setCindex(int c)
    {
        m_cIndex = c;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #148 <Field int m_cIndex>
        for(int i = 0; i < m_plots.size(); i++)
    //*   3    5:iconst_0        
    //*   4    6:istore_2        
    //*   5    7:goto            31
            ((PlotData2D)m_plots.elementAt(i)).setCindex(m_cIndex);
    //    6   10:aload_0         
    //    7   11:getfield        #102 <Field FastVector m_plots>
    //    8   14:iload_2         
    //    9   15:invokevirtual   #332 <Method Object FastVector.elementAt(int)>
    //   10   18:checkcast       #334 <Class PlotData2D>
    //   11   21:aload_0         
    //   12   22:getfield        #148 <Field int m_cIndex>
    //   13   25:invokevirtual   #348 <Method void PlotData2D.setCindex(int)>

    //   14   28:iinc            2  1
    //   15   31:iload_2         
    //   16   32:aload_0         
    //   17   33:getfield        #102 <Field FastVector m_plots>
    //   18   36:invokevirtual   #219 <Method int FastVector.size()>
    //   19   39:icmplt          10
        determineBounds();
    //   20   42:aload_0         
    //   21   43:invokevirtual   #339 <Method void determineBounds()>
        m_axisChanged = true;
    //   22   46:aload_0         
    //   23   47:iconst_1        
    //   24   48:putfield        #166 <Field boolean m_axisChanged>
        repaint();
    //   25   51:aload_0         
    //   26   52:invokevirtual   #324 <Method void repaint()>
    //   27   55:return          
    }

    public FastVector getPlots()
    {
        return m_plots;
    //    0    0:aload_0         
    //    1    1:getfield        #102 <Field FastVector m_plots>
    //    2    4:areturn         
    }

    public PlotData2D getMasterPlot()
    {
        return m_masterPlot;
    //    0    0:aload_0         
    //    1    1:getfield        #104 <Field PlotData2D m_masterPlot>
    //    2    4:areturn         
    }

    public double getMaxX()
    {
        return m_maxX;
    //    0    0:aload_0         
    //    1    1:getfield        #357 <Field double m_maxX>
    //    2    4:dreturn         
    }

    public double getMaxY()
    {
        return m_maxY;
    //    0    0:aload_0         
    //    1    1:getfield        #360 <Field double m_maxY>
    //    2    4:dreturn         
    }

    public double getMinX()
    {
        return m_minX;
    //    0    0:aload_0         
    //    1    1:getfield        #363 <Field double m_minX>
    //    2    4:dreturn         
    }

    public double getMinY()
    {
        return m_minY;
    //    0    0:aload_0         
    //    1    1:getfield        #366 <Field double m_minY>
    //    2    4:dreturn         
    }

    public double getMaxC()
    {
        return m_maxC;
    //    0    0:aload_0         
    //    1    1:getfield        #369 <Field double m_maxC>
    //    2    4:dreturn         
    }

    public double getMinC()
    {
        return m_minC;
    //    0    0:aload_0         
    //    1    1:getfield        #372 <Field double m_minC>
    //    2    4:dreturn         
    }

    public void setInstances(Instances inst)
        throws Exception
    {
        PlotData2D tempPlot = new PlotData2D(inst);
    //    0    0:new             #334 <Class PlotData2D>
    //    1    3:dup             
    //    2    4:aload_1         
    //    3    5:invokespecial   #379 <Method void PlotData2D(Instances)>
    //    4    8:astore_2        
        tempPlot.setPlotName("master plot");
    //    5    9:aload_2         
    //    6   10:ldc1            #106 <String "master plot">
    //    7   12:invokevirtual   #382 <Method void PlotData2D.setPlotName(String)>
        setMasterPlot(tempPlot);
    //    8   15:aload_0         
    //    9   16:aload_2         
    //   10   17:invokevirtual   #386 <Method void setMasterPlot(PlotData2D)>
    //   11   20:return          
    }

    public void setMasterPlot(PlotData2D master)
        throws Exception
    {
        if(master.m_plotInstances == null)
    //*   0    0:aload_1         
    //*   1    1:getfield        #389 <Field Instances PlotData2D.m_plotInstances>
    //*   2    4:ifnonnull       18
        {
            throw new Exception("No instances in plot data!");
    //    3    7:new             #377 <Class Exception>
    //    4   10:dup             
    //    5   11:ldc2            #391 <String "No instances in plot data!">
    //    6   14:invokespecial   #392 <Method void Exception(String)>
    //    7   17:athrow          
        } else
        {
            removeAllPlots();
    //    8   18:aload_0         
    //    9   19:invokevirtual   #395 <Method void removeAllPlots()>
            m_masterPlot = master;
    //   10   22:aload_0         
    //   11   23:aload_1         
    //   12   24:putfield        #104 <Field PlotData2D m_masterPlot>
            m_plots.addElement(m_masterPlot);
    //   13   27:aload_0         
    //   14   28:getfield        #102 <Field FastVector m_plots>
    //   15   31:aload_0         
    //   16   32:getfield        #104 <Field PlotData2D m_masterPlot>
    //   17   35:invokevirtual   #227 <Method void FastVector.addElement(Object)>
            m_plotInstances = m_masterPlot.m_plotInstances;
    //   18   38:aload_0         
    //   19   39:aload_0         
    //   20   40:getfield        #104 <Field PlotData2D m_masterPlot>
    //   21   43:getfield        #389 <Field Instances PlotData2D.m_plotInstances>
    //   22   46:putfield        #110 <Field Instances m_plotInstances>
            m_xIndex = 0;
    //   23   49:aload_0         
    //   24   50:iconst_0        
    //   25   51:putfield        #144 <Field int m_xIndex>
            m_yIndex = 0;
    //   26   54:aload_0         
    //   27   55:iconst_0        
    //   28   56:putfield        #146 <Field int m_yIndex>
            m_cIndex = 0;
    //   29   59:aload_0         
    //   30   60:iconst_0        
    //   31   61:putfield        #148 <Field int m_cIndex>
            determineBounds();
    //   32   64:aload_0         
    //   33   65:invokevirtual   #339 <Method void determineBounds()>
            return;
    //   34   68:return          
        }
    }

    public void removeAllPlots()
    {
        m_masterPlot = null;
    //    0    0:aload_0         
    //    1    1:aconst_null     
    //    2    2:putfield        #104 <Field PlotData2D m_masterPlot>
        m_plotInstances = null;
    //    3    5:aload_0         
    //    4    6:aconst_null     
    //    5    7:putfield        #110 <Field Instances m_plotInstances>
        m_plots = new FastVector();
    //    6   10:aload_0         
    //    7   11:new             #99  <Class FastVector>
    //    8   14:dup             
    //    9   15:invokespecial   #100 <Method void FastVector()>
    //   10   18:putfield        #102 <Field FastVector m_plots>
        m_xIndex = 0;
    //   11   21:aload_0         
    //   12   22:iconst_0        
    //   13   23:putfield        #144 <Field int m_xIndex>
        m_yIndex = 0;
    //   14   26:aload_0         
    //   15   27:iconst_0        
    //   16   28:putfield        #146 <Field int m_yIndex>
        m_cIndex = 0;
    //   17   31:aload_0         
    //   18   32:iconst_0        
    //   19   33:putfield        #148 <Field int m_cIndex>
    //   20   36:return          
    }

    public void addPlot(PlotData2D newPlot)
        throws Exception
    {
        if(newPlot.m_plotInstances == null)
    //*   0    0:aload_1         
    //*   1    1:getfield        #389 <Field Instances PlotData2D.m_plotInstances>
    //*   2    4:ifnonnull       18
            throw new Exception("No instances in plot data!");
    //    3    7:new             #377 <Class Exception>
    //    4   10:dup             
    //    5   11:ldc2            #391 <String "No instances in plot data!">
    //    6   14:invokespecial   #392 <Method void Exception(String)>
    //    7   17:athrow          
        if(m_masterPlot != null)
    //*   8   18:aload_0         
    //*   9   19:getfield        #104 <Field PlotData2D m_masterPlot>
    //*  10   22:ifnull          56
        {
            if(!m_masterPlot.m_plotInstances.equalHeaders(newPlot.m_plotInstances))
    //*  11   25:aload_0         
    //*  12   26:getfield        #104 <Field PlotData2D m_masterPlot>
    //*  13   29:getfield        #389 <Field Instances PlotData2D.m_plotInstances>
    //*  14   32:aload_1         
    //*  15   33:getfield        #389 <Field Instances PlotData2D.m_plotInstances>
    //*  16   36:invokevirtual   #401 <Method boolean Instances.equalHeaders(Instances)>
    //*  17   39:ifne            72
                throw new Exception("Plot2D :Plot data's instances are incompatable  with master plot");
    //   18   42:new             #377 <Class Exception>
    //   19   45:dup             
    //   20   46:ldc2            #403 <String "Plot2D :Plot data's instances are incompatable  with master plot">
    //   21   49:invokespecial   #392 <Method void Exception(String)>
    //   22   52:athrow          
        } else
    //*  23   53:goto            72
        {
            m_masterPlot = newPlot;
    //   24   56:aload_0         
    //   25   57:aload_1         
    //   26   58:putfield        #104 <Field PlotData2D m_masterPlot>
            m_plotInstances = m_masterPlot.m_plotInstances;
    //   27   61:aload_0         
    //   28   62:aload_0         
    //   29   63:getfield        #104 <Field PlotData2D m_masterPlot>
    //   30   66:getfield        #389 <Field Instances PlotData2D.m_plotInstances>
    //   31   69:putfield        #110 <Field Instances m_plotInstances>
        }
        m_plots.addElement(newPlot);
    //   32   72:aload_0         
    //   33   73:getfield        #102 <Field FastVector m_plots>
    //   34   76:aload_1         
    //   35   77:invokevirtual   #227 <Method void FastVector.addElement(Object)>
        setXindex(m_xIndex);
    //   36   80:aload_0         
    //   37   81:aload_0         
    //   38   82:getfield        #144 <Field int m_xIndex>
    //   39   85:invokevirtual   #404 <Method void setXindex(int)>
        setYindex(m_yIndex);
    //   40   88:aload_0         
    //   41   89:aload_0         
    //   42   90:getfield        #146 <Field int m_yIndex>
    //   43   93:invokevirtual   #405 <Method void setYindex(int)>
        setCindex(m_cIndex);
    //   44   96:aload_0         
    //   45   97:aload_0         
    //   46   98:getfield        #148 <Field int m_cIndex>
    //   47  101:invokevirtual   #406 <Method void setCindex(int)>
    //   48  104:return          
    }

    private void setFonts(Graphics gx)
    {
        if(m_labelMetrics == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #168 <Field FontMetrics m_labelMetrics>
    //*   2    4:ifnonnull       35
        {
            m_labelFont = new Font("Monospaced", 0, 12);
    //    3    7:aload_0         
    //    4    8:new             #188 <Class Font>
    //    5   11:dup             
    //    6   12:ldc1            #190 <String "Monospaced">
    //    7   14:iconst_0        
    //    8   15:bipush          12
    //    9   17:invokespecial   #193 <Method void Font(String, int, int)>
    //   10   20:putfield        #411 <Field Font m_labelFont>
            m_labelMetrics = gx.getFontMetrics(m_labelFont);
    //   11   23:aload_0         
    //   12   24:aload_1         
    //   13   25:aload_0         
    //   14   26:getfield        #411 <Field Font m_labelFont>
    //   15   29:invokevirtual   #417 <Method FontMetrics Graphics.getFontMetrics(Font)>
    //   16   32:putfield        #168 <Field FontMetrics m_labelMetrics>
        }
        gx.setFont(m_labelFont);
    //   17   35:aload_1         
    //   18   36:aload_0         
    //   19   37:getfield        #411 <Field Font m_labelFont>
    //   20   40:invokevirtual   #418 <Method void Graphics.setFont(Font)>
    //   21   43:return          
    }

    public void searchPoints(int x, int y, final boolean newFrame)
    {
        if(m_masterPlot.m_plotInstances != null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #104 <Field PlotData2D m_masterPlot>
    //*   2    4:getfield        #389 <Field Instances PlotData2D.m_plotInstances>
    //*   3    7:ifnull          704
        {
            int longest = 0;
    //    4   10:iconst_0        
    //    5   11:istore          4
            for(int j = 0; j < m_masterPlot.m_plotInstances.numAttributes(); j++)
    //*   6   13:iconst_0        
    //*   7   14:istore          5
    //*   8   16:goto            65
                if(m_masterPlot.m_plotInstances.attribute(j).name().length() > longest)
    //*   9   19:aload_0         
    //*  10   20:getfield        #104 <Field PlotData2D m_masterPlot>
    //*  11   23:getfield        #389 <Field Instances PlotData2D.m_plotInstances>
    //*  12   26:iload           5
    //*  13   28:invokevirtual   #426 <Method Attribute Instances.attribute(int)>
    //*  14   31:invokevirtual   #431 <Method String Attribute.name()>
    //*  15   34:invokevirtual   #434 <Method int String.length()>
    //*  16   37:iload           4
    //*  17   39:icmple          62
                    longest = m_masterPlot.m_plotInstances.attribute(j).name().length();
    //   18   42:aload_0         
    //   19   43:getfield        #104 <Field PlotData2D m_masterPlot>
    //   20   46:getfield        #389 <Field Instances PlotData2D.m_plotInstances>
    //   21   49:iload           5
    //   22   51:invokevirtual   #426 <Method Attribute Instances.attribute(int)>
    //   23   54:invokevirtual   #431 <Method String Attribute.name()>
    //   24   57:invokevirtual   #434 <Method int String.length()>
    //   25   60:istore          4

    //   26   62:iinc            5  1
    //   27   65:iload           5
    //   28   67:aload_0         
    //   29   68:getfield        #104 <Field PlotData2D m_masterPlot>
    //   30   71:getfield        #389 <Field Instances PlotData2D.m_plotInstances>
    //   31   74:invokevirtual   #315 <Method int Instances.numAttributes()>
    //   32   77:icmplt          19
            StringBuffer insts = new StringBuffer();
    //   33   80:new             #436 <Class StringBuffer>
    //   34   83:dup             
    //   35   84:invokespecial   #437 <Method void StringBuffer()>
    //   36   87:astore          5
            for(int jj = 0; jj < m_plots.size(); jj++)
    //*  37   89:iconst_0        
    //*  38   90:istore          6
    //*  39   92:goto            504
            {
                PlotData2D temp_plot = (PlotData2D)m_plots.elementAt(jj);
    //   40   95:aload_0         
    //   41   96:getfield        #102 <Field FastVector m_plots>
    //   42   99:iload           6
    //   43  101:invokevirtual   #332 <Method Object FastVector.elementAt(int)>
    //   44  104:checkcast       #334 <Class PlotData2D>
    //   45  107:astore          7
                for(int i = 0; i < temp_plot.m_plotInstances.numInstances(); i++)
    //*  46  109:iconst_0        
    //*  47  110:istore          8
    //*  48  112:goto            488
                    if(temp_plot.m_pointLookup[i][0] != (-1.0D / 0.0D))
    //*  49  115:aload           7
    //*  50  117:getfield        #438 <Field double[][] PlotData2D.m_pointLookup>
    //*  51  120:iload           8
    //*  52  122:aaload          
    //*  53  123:iconst_0        
    //*  54  124:daload          
    //*  55  125:ldc2w           #439 <Double (-1.0D / 0.0D)>
    //*  56  128:dcmpl           
    //*  57  129:ifeq            485
                    {
                        double px = temp_plot.m_pointLookup[i][0] + temp_plot.m_pointLookup[i][2];
    //   58  132:aload           7
    //   59  134:getfield        #438 <Field double[][] PlotData2D.m_pointLookup>
    //   60  137:iload           8
    //   61  139:aaload          
    //   62  140:iconst_0        
    //   63  141:daload          
    //   64  142:aload           7
    //   65  144:getfield        #438 <Field double[][] PlotData2D.m_pointLookup>
    //   66  147:iload           8
    //   67  149:aaload          
    //   68  150:iconst_2        
    //   69  151:daload          
    //   70  152:dadd            
    //   71  153:dstore          9
                        double py = temp_plot.m_pointLookup[i][1] + temp_plot.m_pointLookup[i][3];
    //   72  155:aload           7
    //   73  157:getfield        #438 <Field double[][] PlotData2D.m_pointLookup>
    //   74  160:iload           8
    //   75  162:aaload          
    //   76  163:iconst_1        
    //   77  164:daload          
    //   78  165:aload           7
    //   79  167:getfield        #438 <Field double[][] PlotData2D.m_pointLookup>
    //   80  170:iload           8
    //   81  172:aaload          
    //   82  173:iconst_3        
    //   83  174:daload          
    //   84  175:dadd            
    //   85  176:dstore          11
                        double size = temp_plot.m_shapeSize[i];
    //   86  178:aload           7
    //   87  180:getfield        #444 <Field int[] PlotData2D.m_shapeSize>
    //   88  183:iload           8
    //   89  185:iaload          
    //   90  186:i2d             
    //   91  187:dstore          13
                        if((double)x >= px - size && (double)x <= px + size && (double)y >= py - size && (double)y <= py + size)
    //*  92  189:iload_1         
    //*  93  190:i2d             
    //*  94  191:dload           9
    //*  95  193:dload           13
    //*  96  195:dsub            
    //*  97  196:dcmpl           
    //*  98  197:iflt            485
    //*  99  200:iload_1         
    //* 100  201:i2d             
    //* 101  202:dload           9
    //* 102  204:dload           13
    //* 103  206:dadd            
    //* 104  207:dcmpg           
    //* 105  208:ifgt            485
    //* 106  211:iload_2         
    //* 107  212:i2d             
    //* 108  213:dload           11
    //* 109  215:dload           13
    //* 110  217:dsub            
    //* 111  218:dcmpl           
    //* 112  219:iflt            485
    //* 113  222:iload_2         
    //* 114  223:i2d             
    //* 115  224:dload           11
    //* 116  226:dload           13
    //* 117  228:dadd            
    //* 118  229:dcmpg           
    //* 119  230:ifgt            485
                        {
                            insts.append((new StringBuilder("\nPlot : ")).append(temp_plot.m_plotName).append("\nInstance: ").append(i + 1).append("\n").toString());
    //  120  233:aload           5
    //  121  235:new             #255 <Class StringBuilder>
    //  122  238:dup             
    //  123  239:ldc2            #446 <String "\nPlot : ">
    //  124  242:invokespecial   #264 <Method void StringBuilder(String)>
    //  125  245:aload           7
    //  126  247:getfield        #449 <Field String PlotData2D.m_plotName>
    //  127  250:invokevirtual   #270 <Method StringBuilder StringBuilder.append(String)>
    //  128  253:ldc2            #451 <String "\nInstance: ">
    //  129  256:invokevirtual   #270 <Method StringBuilder StringBuilder.append(String)>
    //  130  259:iload           8
    //  131  261:iconst_1        
    //  132  262:iadd            
    //  133  263:invokevirtual   #454 <Method StringBuilder StringBuilder.append(int)>
    //  134  266:ldc2            #456 <String "\n">
    //  135  269:invokevirtual   #270 <Method StringBuilder StringBuilder.append(String)>
    //  136  272:invokevirtual   #273 <Method String StringBuilder.toString()>
    //  137  275:invokevirtual   #459 <Method StringBuffer StringBuffer.append(String)>
    //  138  278:pop             
                            for(int j = 0; j < temp_plot.m_plotInstances.numAttributes(); j++)
    //* 139  279:iconst_0        
    //* 140  280:istore          15
    //* 141  282:goto            472
                            {
                                for(int k = 0; k < longest - temp_plot.m_plotInstances.attribute(j).name().length(); k++)
    //* 142  285:iconst_0        
    //* 143  286:istore          16
    //* 144  288:goto            303
                                    insts.append(" ");
    //  145  291:aload           5
    //  146  293:ldc2            #461 <String " ">
    //  147  296:invokevirtual   #459 <Method StringBuffer StringBuffer.append(String)>
    //  148  299:pop             

    //  149  300:iinc            16  1
    //  150  303:iload           16
    //  151  305:iload           4
    //  152  307:aload           7
    //  153  309:getfield        #389 <Field Instances PlotData2D.m_plotInstances>
    //  154  312:iload           15
    //  155  314:invokevirtual   #426 <Method Attribute Instances.attribute(int)>
    //  156  317:invokevirtual   #431 <Method String Attribute.name()>
    //  157  320:invokevirtual   #434 <Method int String.length()>
    //  158  323:isub            
    //  159  324:icmplt          291
                                insts.append(temp_plot.m_plotInstances.attribute(j).name());
    //  160  327:aload           5
    //  161  329:aload           7
    //  162  331:getfield        #389 <Field Instances PlotData2D.m_plotInstances>
    //  163  334:iload           15
    //  164  336:invokevirtual   #426 <Method Attribute Instances.attribute(int)>
    //  165  339:invokevirtual   #431 <Method String Attribute.name()>
    //  166  342:invokevirtual   #459 <Method StringBuffer StringBuffer.append(String)>
    //  167  345:pop             
                                insts.append(" : ");
    //  168  346:aload           5
    //  169  348:ldc2            #463 <String " : ">
    //  170  351:invokevirtual   #459 <Method StringBuffer StringBuffer.append(String)>
    //  171  354:pop             
                                if(temp_plot.m_plotInstances.instance(i).isMissing(j))
    //* 172  355:aload           7
    //* 173  357:getfield        #389 <Field Instances PlotData2D.m_plotInstances>
    //* 174  360:iload           8
    //* 175  362:invokevirtual   #467 <Method Instance Instances.instance(int)>
    //* 176  365:iload           15
    //* 177  367:invokevirtual   #473 <Method boolean Instance.isMissing(int)>
    //* 178  370:ifeq            385
                                    insts.append("Missing");
    //  179  373:aload           5
    //  180  375:ldc2            #475 <String "Missing">
    //  181  378:invokevirtual   #459 <Method StringBuffer StringBuffer.append(String)>
    //  182  381:pop             
                                else
    //* 183  382:goto            460
                                if(temp_plot.m_plotInstances.attribute(j).isNominal())
    //* 184  385:aload           7
    //* 185  387:getfield        #389 <Field Instances PlotData2D.m_plotInstances>
    //* 186  390:iload           15
    //* 187  392:invokevirtual   #426 <Method Attribute Instances.attribute(int)>
    //* 188  395:invokevirtual   #479 <Method boolean Attribute.isNominal()>
    //* 189  398:ifeq            439
                                    insts.append(temp_plot.m_plotInstances.attribute(j).value((int)temp_plot.m_plotInstances.instance(i).value(j)));
    //  190  401:aload           5
    //  191  403:aload           7
    //  192  405:getfield        #389 <Field Instances PlotData2D.m_plotInstances>
    //  193  408:iload           15
    //  194  410:invokevirtual   #426 <Method Attribute Instances.attribute(int)>
    //  195  413:aload           7
    //  196  415:getfield        #389 <Field Instances PlotData2D.m_plotInstances>
    //  197  418:iload           8
    //  198  420:invokevirtual   #467 <Method Instance Instances.instance(int)>
    //  199  423:iload           15
    //  200  425:invokevirtual   #483 <Method double Instance.value(int)>
    //  201  428:d2i             
    //  202  429:invokevirtual   #486 <Method String Attribute.value(int)>
    //  203  432:invokevirtual   #459 <Method StringBuffer StringBuffer.append(String)>
    //  204  435:pop             
                                else
    //* 205  436:goto            460
                                    insts.append(temp_plot.m_plotInstances.instance(i).value(j));
    //  206  439:aload           5
    //  207  441:aload           7
    //  208  443:getfield        #389 <Field Instances PlotData2D.m_plotInstances>
    //  209  446:iload           8
    //  210  448:invokevirtual   #467 <Method Instance Instances.instance(int)>
    //  211  451:iload           15
    //  212  453:invokevirtual   #483 <Method double Instance.value(int)>
    //  213  456:invokevirtual   #489 <Method StringBuffer StringBuffer.append(double)>
    //  214  459:pop             
                                insts.append("\n");
    //  215  460:aload           5
    //  216  462:ldc2            #456 <String "\n">
    //  217  465:invokevirtual   #459 <Method StringBuffer StringBuffer.append(String)>
    //  218  468:pop             
                            }

    //  219  469:iinc            15  1
    //  220  472:iload           15
    //  221  474:aload           7
    //  222  476:getfield        #389 <Field Instances PlotData2D.m_plotInstances>
    //  223  479:invokevirtual   #315 <Method int Instances.numAttributes()>
    //  224  482:icmplt          285
                        }
                    }

    //  225  485:iinc            8  1
    //  226  488:iload           8
    //  227  490:aload           7
    //  228  492:getfield        #389 <Field Instances PlotData2D.m_plotInstances>
    //  229  495:invokevirtual   #318 <Method int Instances.numInstances()>
    //  230  498:icmplt          115
            }

    //  231  501:iinc            6  1
    //  232  504:iload           6
    //  233  506:aload_0         
    //  234  507:getfield        #102 <Field FastVector m_plots>
    //  235  510:invokevirtual   #219 <Method int FastVector.size()>
    //  236  513:icmplt          95
            if(insts.length() > 0)
    //* 237  516:aload           5
    //* 238  518:invokevirtual   #490 <Method int StringBuffer.length()>
    //* 239  521:ifle            704
                if(newFrame || m_InstanceInfo == null)
    //* 240  524:iload_3         
    //* 241  525:ifne            535
    //* 242  528:aload_0         
    //* 243  529:getfield        #114 <Field JFrame m_InstanceInfo>
    //* 244  532:ifnonnull       692
                {
                    JTextArea jt = new JTextArea();
    //  245  535:new             #116 <Class JTextArea>
    //  246  538:dup             
    //  247  539:invokespecial   #117 <Method void JTextArea()>
    //  248  542:astore          6
                    jt.setFont(new Font("Monospaced", 0, 12));
    //  249  544:aload           6
    //  250  546:new             #188 <Class Font>
    //  251  549:dup             
    //  252  550:ldc1            #190 <String "Monospaced">
    //  253  552:iconst_0        
    //  254  553:bipush          12
    //  255  555:invokespecial   #193 <Method void Font(String, int, int)>
    //  256  558:invokevirtual   #197 <Method void JTextArea.setFont(Font)>
                    jt.setEditable(false);
    //  257  561:aload           6
    //  258  563:iconst_0        
    //  259  564:invokevirtual   #201 <Method void JTextArea.setEditable(boolean)>
                    jt.setText(insts.toString());
    //  260  567:aload           6
    //  261  569:aload           5
    //  262  571:invokevirtual   #491 <Method String StringBuffer.toString()>
    //  263  574:invokevirtual   #494 <Method void JTextArea.setText(String)>
                    final JFrame jf = new JFrame("Weka : Instance info");
    //  264  577:new             #496 <Class JFrame>
    //  265  580:dup             
    //  266  581:ldc2            #498 <String "Weka : Instance info">
    //  267  584:invokespecial   #499 <Method void JFrame(String)>
    //  268  587:astore          7
                    final JFrame testf = m_InstanceInfo;
    //  269  589:aload_0         
    //  270  590:getfield        #114 <Field JFrame m_InstanceInfo>
    //  271  593:astore          8
                    jf.addWindowListener(new WindowAdapter() {

                        public void windowClosing(WindowEvent e)
                        {
                            if(!newFrame || testf == null)
                        //*   0    0:aload_0         
                        //*   1    1:getfield        #18  <Field boolean val$newFrame>
                        //*   2    4:ifeq            14
                        //*   3    7:aload_0         
                        //*   4    8:getfield        #20  <Field JFrame val$testf>
                        //*   5   11:ifnonnull       22
                                m_InstanceInfo = null;
                        //    6   14:aload_0         
                        //    7   15:getfield        #16  <Field Plot2D this$0>
                        //    8   18:aconst_null     
                        //    9   19:putfield        #36  <Field JFrame Plot2D.m_InstanceInfo>
                            jf.dispose();
                        //   10   22:aload_0         
                        //   11   23:getfield        #22  <Field JFrame val$jf>
                        //   12   26:invokevirtual   #41  <Method void JFrame.dispose()>
                        //   13   29:return          
                        }

                        final Plot2D this$0;
                        private final boolean val$newFrame;
                        private final JFrame val$testf;
                        private final JFrame val$jf;

            
            {
                this$0 = Plot2D.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #16  <Field Plot2D this$0>
                newFrame = flag;
            //    3    5:aload_0         
            //    4    6:iload_2         
            //    5    7:putfield        #18  <Field boolean val$newFrame>
                testf = jframe;
            //    6   10:aload_0         
            //    7   11:aload_3         
            //    8   12:putfield        #20  <Field JFrame val$testf>
                jf = jframe1;
            //    9   15:aload_0         
            //   10   16:aload           4
            //   11   18:putfield        #22  <Field JFrame val$jf>
                super();
            //   12   21:aload_0         
            //   13   22:invokespecial   #25  <Method void WindowAdapter()>
            //   14   25:return          
            }
                    }
);
    //  272  595:aload           7
    //  273  597:new             #501 <Class Plot2D$1>
    //  274  600:dup             
    //  275  601:aload_0         
    //  276  602:iload_3         
    //  277  603:aload           8
    //  278  605:aload           7
    //  279  607:invokespecial   #504 <Method void Plot2D$1(Plot2D, boolean, JFrame, JFrame)>
    //  280  610:invokevirtual   #508 <Method void JFrame.addWindowListener(java.awt.event.WindowListener)>
                    jf.getContentPane().setLayout(new BorderLayout());
    //  281  613:aload           7
    //  282  615:invokevirtual   #512 <Method Container JFrame.getContentPane()>
    //  283  618:new             #514 <Class BorderLayout>
    //  284  621:dup             
    //  285  622:invokespecial   #515 <Method void BorderLayout()>
    //  286  625:invokevirtual   #521 <Method void Container.setLayout(java.awt.LayoutManager)>
                    jf.getContentPane().add(new JScrollPane(jt), "Center");
    //  287  628:aload           7
    //  288  630:invokevirtual   #512 <Method Container JFrame.getContentPane()>
    //  289  633:new             #523 <Class JScrollPane>
    //  290  636:dup             
    //  291  637:aload           6
    //  292  639:invokespecial   #526 <Method void JScrollPane(java.awt.Component)>
    //  293  642:ldc2            #528 <String "Center">
    //  294  645:invokevirtual   #532 <Method void Container.add(java.awt.Component, Object)>
                    jf.pack();
    //  295  648:aload           7
    //  296  650:invokevirtual   #535 <Method void JFrame.pack()>
                    jf.setSize(320, 400);
    //  297  653:aload           7
    //  298  655:sipush          320
    //  299  658:sipush          400
    //  300  661:invokevirtual   #539 <Method void JFrame.setSize(int, int)>
                    jf.setVisible(true);
    //  301  664:aload           7
    //  302  666:iconst_1        
    //  303  667:invokevirtual   #542 <Method void JFrame.setVisible(boolean)>
                    if(m_InstanceInfo == null)
    //* 304  670:aload_0         
    //* 305  671:getfield        #114 <Field JFrame m_InstanceInfo>
    //* 306  674:ifnonnull       704
                    {
                        m_InstanceInfo = jf;
    //  307  677:aload_0         
    //  308  678:aload           7
    //  309  680:putfield        #114 <Field JFrame m_InstanceInfo>
                        m_InstanceInfoText = jt;
    //  310  683:aload_0         
    //  311  684:aload           6
    //  312  686:putfield        #119 <Field JTextArea m_InstanceInfoText>
                    }
                } else
    //* 313  689:goto            704
                {
                    m_InstanceInfoText.setText(insts.toString());
    //  314  692:aload_0         
    //  315  693:getfield        #119 <Field JTextArea m_InstanceInfoText>
    //  316  696:aload           5
    //  317  698:invokevirtual   #491 <Method String StringBuffer.toString()>
    //  318  701:invokevirtual   #494 <Method void JTextArea.setText(String)>
                }
        }
    //  319  704:return          
    }

    public void determineBounds()
    {
        m_minX = ((PlotData2D)m_plots.elementAt(0)).m_minX;
    //    0    0:aload_0         
    //    1    1:aload_0         
    //    2    2:getfield        #102 <Field FastVector m_plots>
    //    3    5:iconst_0        
    //    4    6:invokevirtual   #332 <Method Object FastVector.elementAt(int)>
    //    5    9:checkcast       #334 <Class PlotData2D>
    //    6   12:getfield        #555 <Field double PlotData2D.m_minX>
    //    7   15:putfield        #363 <Field double m_minX>
        m_maxX = ((PlotData2D)m_plots.elementAt(0)).m_maxX;
    //    8   18:aload_0         
    //    9   19:aload_0         
    //   10   20:getfield        #102 <Field FastVector m_plots>
    //   11   23:iconst_0        
    //   12   24:invokevirtual   #332 <Method Object FastVector.elementAt(int)>
    //   13   27:checkcast       #334 <Class PlotData2D>
    //   14   30:getfield        #556 <Field double PlotData2D.m_maxX>
    //   15   33:putfield        #357 <Field double m_maxX>
        m_minY = ((PlotData2D)m_plots.elementAt(0)).m_minY;
    //   16   36:aload_0         
    //   17   37:aload_0         
    //   18   38:getfield        #102 <Field FastVector m_plots>
    //   19   41:iconst_0        
    //   20   42:invokevirtual   #332 <Method Object FastVector.elementAt(int)>
    //   21   45:checkcast       #334 <Class PlotData2D>
    //   22   48:getfield        #557 <Field double PlotData2D.m_minY>
    //   23   51:putfield        #366 <Field double m_minY>
        m_maxY = ((PlotData2D)m_plots.elementAt(0)).m_maxY;
    //   24   54:aload_0         
    //   25   55:aload_0         
    //   26   56:getfield        #102 <Field FastVector m_plots>
    //   27   59:iconst_0        
    //   28   60:invokevirtual   #332 <Method Object FastVector.elementAt(int)>
    //   29   63:checkcast       #334 <Class PlotData2D>
    //   30   66:getfield        #558 <Field double PlotData2D.m_maxY>
    //   31   69:putfield        #360 <Field double m_maxY>
        m_minC = ((PlotData2D)m_plots.elementAt(0)).m_minC;
    //   32   72:aload_0         
    //   33   73:aload_0         
    //   34   74:getfield        #102 <Field FastVector m_plots>
    //   35   77:iconst_0        
    //   36   78:invokevirtual   #332 <Method Object FastVector.elementAt(int)>
    //   37   81:checkcast       #334 <Class PlotData2D>
    //   38   84:getfield        #559 <Field double PlotData2D.m_minC>
    //   39   87:putfield        #372 <Field double m_minC>
        m_maxC = ((PlotData2D)m_plots.elementAt(0)).m_maxC;
    //   40   90:aload_0         
    //   41   91:aload_0         
    //   42   92:getfield        #102 <Field FastVector m_plots>
    //   43   95:iconst_0        
    //   44   96:invokevirtual   #332 <Method Object FastVector.elementAt(int)>
    //   45   99:checkcast       #334 <Class PlotData2D>
    //   46  102:getfield        #560 <Field double PlotData2D.m_maxC>
    //   47  105:putfield        #369 <Field double m_maxC>
        for(int i = 1; i < m_plots.size(); i++)
    //*  48  108:iconst_1        
    //*  49  109:istore          7
    //*  50  111:goto            297
        {
            double value = ((PlotData2D)m_plots.elementAt(i)).m_minX;
    //   51  114:aload_0         
    //   52  115:getfield        #102 <Field FastVector m_plots>
    //   53  118:iload           7
    //   54  120:invokevirtual   #332 <Method Object FastVector.elementAt(int)>
    //   55  123:checkcast       #334 <Class PlotData2D>
    //   56  126:getfield        #555 <Field double PlotData2D.m_minX>
    //   57  129:dstore_1        
            if(value < m_minX)
    //*  58  130:dload_1         
    //*  59  131:aload_0         
    //*  60  132:getfield        #363 <Field double m_minX>
    //*  61  135:dcmpg           
    //*  62  136:ifge            144
                m_minX = value;
    //   63  139:aload_0         
    //   64  140:dload_1         
    //   65  141:putfield        #363 <Field double m_minX>
            value = ((PlotData2D)m_plots.elementAt(i)).m_maxX;
    //   66  144:aload_0         
    //   67  145:getfield        #102 <Field FastVector m_plots>
    //   68  148:iload           7
    //   69  150:invokevirtual   #332 <Method Object FastVector.elementAt(int)>
    //   70  153:checkcast       #334 <Class PlotData2D>
    //   71  156:getfield        #556 <Field double PlotData2D.m_maxX>
    //   72  159:dstore_1        
            if(value > m_maxX)
    //*  73  160:dload_1         
    //*  74  161:aload_0         
    //*  75  162:getfield        #357 <Field double m_maxX>
    //*  76  165:dcmpl           
    //*  77  166:ifle            174
                m_maxX = value;
    //   78  169:aload_0         
    //   79  170:dload_1         
    //   80  171:putfield        #357 <Field double m_maxX>
            value = ((PlotData2D)m_plots.elementAt(i)).m_minY;
    //   81  174:aload_0         
    //   82  175:getfield        #102 <Field FastVector m_plots>
    //   83  178:iload           7
    //   84  180:invokevirtual   #332 <Method Object FastVector.elementAt(int)>
    //   85  183:checkcast       #334 <Class PlotData2D>
    //   86  186:getfield        #557 <Field double PlotData2D.m_minY>
    //   87  189:dstore_1        
            if(value < m_minY)
    //*  88  190:dload_1         
    //*  89  191:aload_0         
    //*  90  192:getfield        #366 <Field double m_minY>
    //*  91  195:dcmpg           
    //*  92  196:ifge            204
                m_minY = value;
    //   93  199:aload_0         
    //   94  200:dload_1         
    //   95  201:putfield        #366 <Field double m_minY>
            value = ((PlotData2D)m_plots.elementAt(i)).m_maxY;
    //   96  204:aload_0         
    //   97  205:getfield        #102 <Field FastVector m_plots>
    //   98  208:iload           7
    //   99  210:invokevirtual   #332 <Method Object FastVector.elementAt(int)>
    //  100  213:checkcast       #334 <Class PlotData2D>
    //  101  216:getfield        #558 <Field double PlotData2D.m_maxY>
    //  102  219:dstore_1        
            if(value > m_maxY)
    //* 103  220:dload_1         
    //* 104  221:aload_0         
    //* 105  222:getfield        #360 <Field double m_maxY>
    //* 106  225:dcmpl           
    //* 107  226:ifle            234
                m_maxY = value;
    //  108  229:aload_0         
    //  109  230:dload_1         
    //  110  231:putfield        #360 <Field double m_maxY>
            value = ((PlotData2D)m_plots.elementAt(i)).m_minC;
    //  111  234:aload_0         
    //  112  235:getfield        #102 <Field FastVector m_plots>
    //  113  238:iload           7
    //  114  240:invokevirtual   #332 <Method Object FastVector.elementAt(int)>
    //  115  243:checkcast       #334 <Class PlotData2D>
    //  116  246:getfield        #559 <Field double PlotData2D.m_minC>
    //  117  249:dstore_1        
            if(value < m_minC)
    //* 118  250:dload_1         
    //* 119  251:aload_0         
    //* 120  252:getfield        #372 <Field double m_minC>
    //* 121  255:dcmpg           
    //* 122  256:ifge            264
                m_minC = value;
    //  123  259:aload_0         
    //  124  260:dload_1         
    //  125  261:putfield        #372 <Field double m_minC>
            value = ((PlotData2D)m_plots.elementAt(i)).m_maxC;
    //  126  264:aload_0         
    //  127  265:getfield        #102 <Field FastVector m_plots>
    //  128  268:iload           7
    //  129  270:invokevirtual   #332 <Method Object FastVector.elementAt(int)>
    //  130  273:checkcast       #334 <Class PlotData2D>
    //  131  276:getfield        #560 <Field double PlotData2D.m_maxC>
    //  132  279:dstore_1        
            if(value > m_maxC)
    //* 133  280:dload_1         
    //* 134  281:aload_0         
    //* 135  282:getfield        #369 <Field double m_maxC>
    //* 136  285:dcmpl           
    //* 137  286:ifle            294
                m_maxC = value;
    //  138  289:aload_0         
    //  139  290:dload_1         
    //  140  291:putfield        #369 <Field double m_maxC>
        }

    //  141  294:iinc            7  1
    //  142  297:iload           7
    //  143  299:aload_0         
    //  144  300:getfield        #102 <Field FastVector m_plots>
    //  145  303:invokevirtual   #219 <Method int FastVector.size()>
    //  146  306:icmplt          114
        fillLookup();
    //  147  309:aload_0         
    //  148  310:invokespecial   #563 <Method void fillLookup()>
        repaint();
    //  149  313:aload_0         
    //  150  314:invokevirtual   #324 <Method void repaint()>
    //  151  317:return          
    }

    public double convertToAttribX(double scx)
    {
        double temp = m_XaxisEnd - m_XaxisStart;
    //    0    0:aload_0         
    //    1    1:getfield        #160 <Field int m_XaxisEnd>
    //    2    4:aload_0         
    //    3    5:getfield        #156 <Field int m_XaxisStart>
    //    4    8:isub            
    //    5    9:i2d             
    //    6   10:dstore_3        
        double temp2 = ((scx - (double)m_XaxisStart) * (m_maxX - m_minX)) / temp;
    //    7   11:dload_1         
    //    8   12:aload_0         
    //    9   13:getfield        #156 <Field int m_XaxisStart>
    //   10   16:i2d             
    //   11   17:dsub            
    //   12   18:aload_0         
    //   13   19:getfield        #357 <Field double m_maxX>
    //   14   22:aload_0         
    //   15   23:getfield        #363 <Field double m_minX>
    //   16   26:dsub            
    //   17   27:dmul            
    //   18   28:dload_3         
    //   19   29:ddiv            
    //   20   30:dstore          5
        temp2 += m_minX;
    //   21   32:dload           5
    //   22   34:aload_0         
    //   23   35:getfield        #363 <Field double m_minX>
    //   24   38:dadd            
    //   25   39:dstore          5
        return temp2;
    //   26   41:dload           5
    //   27   43:dreturn         
    }

    public double convertToAttribY(double scy)
    {
        double temp = m_YaxisEnd - m_YaxisStart;
    //    0    0:aload_0         
    //    1    1:getfield        #162 <Field int m_YaxisEnd>
    //    2    4:aload_0         
    //    3    5:getfield        #158 <Field int m_YaxisStart>
    //    4    8:isub            
    //    5    9:i2d             
    //    6   10:dstore_3        
        double temp2 = ((scy - (double)m_YaxisEnd) * (m_maxY - m_minY)) / temp;
    //    7   11:dload_1         
    //    8   12:aload_0         
    //    9   13:getfield        #162 <Field int m_YaxisEnd>
    //   10   16:i2d             
    //   11   17:dsub            
    //   12   18:aload_0         
    //   13   19:getfield        #360 <Field double m_maxY>
    //   14   22:aload_0         
    //   15   23:getfield        #366 <Field double m_minY>
    //   16   26:dsub            
    //   17   27:dmul            
    //   18   28:dload_3         
    //   19   29:ddiv            
    //   20   30:dstore          5
        temp2 = -(temp2 - m_minY);
    //   21   32:dload           5
    //   22   34:aload_0         
    //   23   35:getfield        #366 <Field double m_minY>
    //   24   38:dsub            
    //   25   39:dneg            
    //   26   40:dstore          5
        return temp2;
    //   27   42:dload           5
    //   28   44:dreturn         
    }

    int pturbX(double xvalP, double xj)
    {
        int xpturb = 0;
    //    0    0:iconst_0        
    //    1    1:istore          5
        if(m_JitterVal > 0)
    //*   2    3:aload_0         
    //*   3    4:getfield        #170 <Field int m_JitterVal>
    //*   4    7:ifle            58
        {
            xpturb = (int)((double)m_JitterVal * (xj / 2D));
    //    5   10:aload_0         
    //    6   11:getfield        #170 <Field int m_JitterVal>
    //    7   14:i2d             
    //    8   15:dload_3         
    //    9   16:ldc2w           #573 <Double 2D>
    //   10   19:ddiv            
    //   11   20:dmul            
    //   12   21:d2i             
    //   13   22:istore          5
            if(xvalP + (double)xpturb < (double)m_XaxisStart || xvalP + (double)xpturb > (double)m_XaxisEnd)
    //*  14   24:dload_1         
    //*  15   25:iload           5
    //*  16   27:i2d             
    //*  17   28:dadd            
    //*  18   29:aload_0         
    //*  19   30:getfield        #156 <Field int m_XaxisStart>
    //*  20   33:i2d             
    //*  21   34:dcmpg           
    //*  22   35:iflt            52
    //*  23   38:dload_1         
    //*  24   39:iload           5
    //*  25   41:i2d             
    //*  26   42:dadd            
    //*  27   43:aload_0         
    //*  28   44:getfield        #160 <Field int m_XaxisEnd>
    //*  29   47:i2d             
    //*  30   48:dcmpl           
    //*  31   49:ifle            58
                xpturb *= -1;
    //   32   52:iload           5
    //   33   54:iconst_m1       
    //   34   55:imul            
    //   35   56:istore          5
        }
        return xpturb;
    //   36   58:iload           5
    //   37   60:ireturn         
    }

    public double convertToPanelX(double xval)
    {
        double temp = (xval - m_minX) / (m_maxX - m_minX);
    //    0    0:dload_1         
    //    1    1:aload_0         
    //    2    2:getfield        #363 <Field double m_minX>
    //    3    5:dsub            
    //    4    6:aload_0         
    //    5    7:getfield        #357 <Field double m_maxX>
    //    6   10:aload_0         
    //    7   11:getfield        #363 <Field double m_minX>
    //    8   14:dsub            
    //    9   15:ddiv            
    //   10   16:dstore_3        
        double temp2 = temp * (double)(m_XaxisEnd - m_XaxisStart);
    //   11   17:dload_3         
    //   12   18:aload_0         
    //   13   19:getfield        #160 <Field int m_XaxisEnd>
    //   14   22:aload_0         
    //   15   23:getfield        #156 <Field int m_XaxisStart>
    //   16   26:isub            
    //   17   27:i2d             
    //   18   28:dmul            
    //   19   29:dstore          5
        temp2 += m_XaxisStart;
    //   20   31:dload           5
    //   21   33:aload_0         
    //   22   34:getfield        #156 <Field int m_XaxisStart>
    //   23   37:i2d             
    //   24   38:dadd            
    //   25   39:dstore          5
        return temp2;
    //   26   41:dload           5
    //   27   43:dreturn         
    }

    int pturbY(double yvalP, double yj)
    {
        int ypturb = 0;
    //    0    0:iconst_0        
    //    1    1:istore          5
        if(m_JitterVal > 0)
    //*   2    3:aload_0         
    //*   3    4:getfield        #170 <Field int m_JitterVal>
    //*   4    7:ifle            58
        {
            ypturb = (int)((double)m_JitterVal * (yj / 2D));
    //    5   10:aload_0         
    //    6   11:getfield        #170 <Field int m_JitterVal>
    //    7   14:i2d             
    //    8   15:dload_3         
    //    9   16:ldc2w           #573 <Double 2D>
    //   10   19:ddiv            
    //   11   20:dmul            
    //   12   21:d2i             
    //   13   22:istore          5
            if(yvalP + (double)ypturb < (double)m_YaxisStart || yvalP + (double)ypturb > (double)m_YaxisEnd)
    //*  14   24:dload_1         
    //*  15   25:iload           5
    //*  16   27:i2d             
    //*  17   28:dadd            
    //*  18   29:aload_0         
    //*  19   30:getfield        #158 <Field int m_YaxisStart>
    //*  20   33:i2d             
    //*  21   34:dcmpg           
    //*  22   35:iflt            52
    //*  23   38:dload_1         
    //*  24   39:iload           5
    //*  25   41:i2d             
    //*  26   42:dadd            
    //*  27   43:aload_0         
    //*  28   44:getfield        #162 <Field int m_YaxisEnd>
    //*  29   47:i2d             
    //*  30   48:dcmpl           
    //*  31   49:ifle            58
                ypturb *= -1;
    //   32   52:iload           5
    //   33   54:iconst_m1       
    //   34   55:imul            
    //   35   56:istore          5
        }
        return ypturb;
    //   36   58:iload           5
    //   37   60:ireturn         
    }

    public double convertToPanelY(double yval)
    {
        double temp = (yval - m_minY) / (m_maxY - m_minY);
    //    0    0:dload_1         
    //    1    1:aload_0         
    //    2    2:getfield        #366 <Field double m_minY>
    //    3    5:dsub            
    //    4    6:aload_0         
    //    5    7:getfield        #360 <Field double m_maxY>
    //    6   10:aload_0         
    //    7   11:getfield        #366 <Field double m_minY>
    //    8   14:dsub            
    //    9   15:ddiv            
    //   10   16:dstore_3        
        double temp2 = temp * (double)(m_YaxisEnd - m_YaxisStart);
    //   11   17:dload_3         
    //   12   18:aload_0         
    //   13   19:getfield        #162 <Field int m_YaxisEnd>
    //   14   22:aload_0         
    //   15   23:getfield        #158 <Field int m_YaxisStart>
    //   16   26:isub            
    //   17   27:i2d             
    //   18   28:dmul            
    //   19   29:dstore          5
        temp2 = (double)m_YaxisEnd - temp2;
    //   20   31:aload_0         
    //   21   32:getfield        #162 <Field int m_YaxisEnd>
    //   22   35:i2d             
    //   23   36:dload           5
    //   24   38:dsub            
    //   25   39:dstore          5
        return temp2;
    //   26   41:dload           5
    //   27   43:dreturn         
    }

    private static void drawX(Graphics gx, double x, double y, int size)
    {
        gx.drawLine((int)(x - (double)size), (int)(y - (double)size), (int)(x + (double)size), (int)(y + (double)size));
    //    0    0:aload_0         
    //    1    1:dload_1         
    //    2    2:iload           5
    //    3    4:i2d             
    //    4    5:dsub            
    //    5    6:d2i             
    //    6    7:dload_3         
    //    7    8:iload           5
    //    8   10:i2d             
    //    9   11:dsub            
    //   10   12:d2i             
    //   11   13:dload_1         
    //   12   14:iload           5
    //   13   16:i2d             
    //   14   17:dadd            
    //   15   18:d2i             
    //   16   19:dload_3         
    //   17   20:iload           5
    //   18   22:i2d             
    //   19   23:dadd            
    //   20   24:d2i             
    //   21   25:invokevirtual   #591 <Method void Graphics.drawLine(int, int, int, int)>
        gx.drawLine((int)(x + (double)size), (int)(y - (double)size), (int)(x - (double)size), (int)(y + (double)size));
    //   22   28:aload_0         
    //   23   29:dload_1         
    //   24   30:iload           5
    //   25   32:i2d             
    //   26   33:dadd            
    //   27   34:d2i             
    //   28   35:dload_3         
    //   29   36:iload           5
    //   30   38:i2d             
    //   31   39:dsub            
    //   32   40:d2i             
    //   33   41:dload_1         
    //   34   42:iload           5
    //   35   44:i2d             
    //   36   45:dsub            
    //   37   46:d2i             
    //   38   47:dload_3         
    //   39   48:iload           5
    //   40   50:i2d             
    //   41   51:dadd            
    //   42   52:d2i             
    //   43   53:invokevirtual   #591 <Method void Graphics.drawLine(int, int, int, int)>
    //   44   56:return          
    }

    private static void drawPlus(Graphics gx, double x, double y, int size)
    {
        gx.drawLine((int)(x - (double)size), (int)y, (int)(x + (double)size), (int)y);
    //    0    0:aload_0         
    //    1    1:dload_1         
    //    2    2:iload           5
    //    3    4:i2d             
    //    4    5:dsub            
    //    5    6:d2i             
    //    6    7:dload_3         
    //    7    8:d2i             
    //    8    9:dload_1         
    //    9   10:iload           5
    //   10   12:i2d             
    //   11   13:dadd            
    //   12   14:d2i             
    //   13   15:dload_3         
    //   14   16:d2i             
    //   15   17:invokevirtual   #591 <Method void Graphics.drawLine(int, int, int, int)>
        gx.drawLine((int)x, (int)(y - (double)size), (int)x, (int)(y + (double)size));
    //   16   20:aload_0         
    //   17   21:dload_1         
    //   18   22:d2i             
    //   19   23:dload_3         
    //   20   24:iload           5
    //   21   26:i2d             
    //   22   27:dsub            
    //   23   28:d2i             
    //   24   29:dload_1         
    //   25   30:d2i             
    //   26   31:dload_3         
    //   27   32:iload           5
    //   28   34:i2d             
    //   29   35:dadd            
    //   30   36:d2i             
    //   31   37:invokevirtual   #591 <Method void Graphics.drawLine(int, int, int, int)>
    //   32   40:return          
    }

    private static void drawDiamond(Graphics gx, double x, double y, int size)
    {
        gx.drawLine((int)(x - (double)size), (int)y, (int)x, (int)(y - (double)size));
    //    0    0:aload_0         
    //    1    1:dload_1         
    //    2    2:iload           5
    //    3    4:i2d             
    //    4    5:dsub            
    //    5    6:d2i             
    //    6    7:dload_3         
    //    7    8:d2i             
    //    8    9:dload_1         
    //    9   10:d2i             
    //   10   11:dload_3         
    //   11   12:iload           5
    //   12   14:i2d             
    //   13   15:dsub            
    //   14   16:d2i             
    //   15   17:invokevirtual   #591 <Method void Graphics.drawLine(int, int, int, int)>
        gx.drawLine((int)x, (int)(y - (double)size), (int)(x + (double)size), (int)y);
    //   16   20:aload_0         
    //   17   21:dload_1         
    //   18   22:d2i             
    //   19   23:dload_3         
    //   20   24:iload           5
    //   21   26:i2d             
    //   22   27:dsub            
    //   23   28:d2i             
    //   24   29:dload_1         
    //   25   30:iload           5
    //   26   32:i2d             
    //   27   33:dadd            
    //   28   34:d2i             
    //   29   35:dload_3         
    //   30   36:d2i             
    //   31   37:invokevirtual   #591 <Method void Graphics.drawLine(int, int, int, int)>
        gx.drawLine((int)(x + (double)size), (int)y, (int)x, (int)(y + (double)size));
    //   32   40:aload_0         
    //   33   41:dload_1         
    //   34   42:iload           5
    //   35   44:i2d             
    //   36   45:dadd            
    //   37   46:d2i             
    //   38   47:dload_3         
    //   39   48:d2i             
    //   40   49:dload_1         
    //   41   50:d2i             
    //   42   51:dload_3         
    //   43   52:iload           5
    //   44   54:i2d             
    //   45   55:dadd            
    //   46   56:d2i             
    //   47   57:invokevirtual   #591 <Method void Graphics.drawLine(int, int, int, int)>
        gx.drawLine((int)x, (int)(y + (double)size), (int)(x - (double)size), (int)y);
    //   48   60:aload_0         
    //   49   61:dload_1         
    //   50   62:d2i             
    //   51   63:dload_3         
    //   52   64:iload           5
    //   53   66:i2d             
    //   54   67:dadd            
    //   55   68:d2i             
    //   56   69:dload_1         
    //   57   70:iload           5
    //   58   72:i2d             
    //   59   73:dsub            
    //   60   74:d2i             
    //   61   75:dload_3         
    //   62   76:d2i             
    //   63   77:invokevirtual   #591 <Method void Graphics.drawLine(int, int, int, int)>
    //   64   80:return          
    }

    private static void drawTriangleUp(Graphics gx, double x, double y, int size)
    {
        gx.drawLine((int)x, (int)(y - (double)size), (int)(x - (double)size), (int)(y + (double)size));
    //    0    0:aload_0         
    //    1    1:dload_1         
    //    2    2:d2i             
    //    3    3:dload_3         
    //    4    4:iload           5
    //    5    6:i2d             
    //    6    7:dsub            
    //    7    8:d2i             
    //    8    9:dload_1         
    //    9   10:iload           5
    //   10   12:i2d             
    //   11   13:dsub            
    //   12   14:d2i             
    //   13   15:dload_3         
    //   14   16:iload           5
    //   15   18:i2d             
    //   16   19:dadd            
    //   17   20:d2i             
    //   18   21:invokevirtual   #591 <Method void Graphics.drawLine(int, int, int, int)>
        gx.drawLine((int)(x - (double)size), (int)(y + (double)size), (int)(x + (double)size), (int)(y + (double)size));
    //   19   24:aload_0         
    //   20   25:dload_1         
    //   21   26:iload           5
    //   22   28:i2d             
    //   23   29:dsub            
    //   24   30:d2i             
    //   25   31:dload_3         
    //   26   32:iload           5
    //   27   34:i2d             
    //   28   35:dadd            
    //   29   36:d2i             
    //   30   37:dload_1         
    //   31   38:iload           5
    //   32   40:i2d             
    //   33   41:dadd            
    //   34   42:d2i             
    //   35   43:dload_3         
    //   36   44:iload           5
    //   37   46:i2d             
    //   38   47:dadd            
    //   39   48:d2i             
    //   40   49:invokevirtual   #591 <Method void Graphics.drawLine(int, int, int, int)>
        gx.drawLine((int)(x + (double)size), (int)(y + (double)size), (int)x, (int)(y - (double)size));
    //   41   52:aload_0         
    //   42   53:dload_1         
    //   43   54:iload           5
    //   44   56:i2d             
    //   45   57:dadd            
    //   46   58:d2i             
    //   47   59:dload_3         
    //   48   60:iload           5
    //   49   62:i2d             
    //   50   63:dadd            
    //   51   64:d2i             
    //   52   65:dload_1         
    //   53   66:d2i             
    //   54   67:dload_3         
    //   55   68:iload           5
    //   56   70:i2d             
    //   57   71:dsub            
    //   58   72:d2i             
    //   59   73:invokevirtual   #591 <Method void Graphics.drawLine(int, int, int, int)>
    //   60   76:return          
    }

    private static void drawTriangleDown(Graphics gx, double x, double y, int size)
    {
        gx.drawLine((int)x, (int)(y + (double)size), (int)(x - (double)size), (int)(y - (double)size));
    //    0    0:aload_0         
    //    1    1:dload_1         
    //    2    2:d2i             
    //    3    3:dload_3         
    //    4    4:iload           5
    //    5    6:i2d             
    //    6    7:dadd            
    //    7    8:d2i             
    //    8    9:dload_1         
    //    9   10:iload           5
    //   10   12:i2d             
    //   11   13:dsub            
    //   12   14:d2i             
    //   13   15:dload_3         
    //   14   16:iload           5
    //   15   18:i2d             
    //   16   19:dsub            
    //   17   20:d2i             
    //   18   21:invokevirtual   #591 <Method void Graphics.drawLine(int, int, int, int)>
        gx.drawLine((int)(x - (double)size), (int)(y - (double)size), (int)(x + (double)size), (int)(y - (double)size));
    //   19   24:aload_0         
    //   20   25:dload_1         
    //   21   26:iload           5
    //   22   28:i2d             
    //   23   29:dsub            
    //   24   30:d2i             
    //   25   31:dload_3         
    //   26   32:iload           5
    //   27   34:i2d             
    //   28   35:dsub            
    //   29   36:d2i             
    //   30   37:dload_1         
    //   31   38:iload           5
    //   32   40:i2d             
    //   33   41:dadd            
    //   34   42:d2i             
    //   35   43:dload_3         
    //   36   44:iload           5
    //   37   46:i2d             
    //   38   47:dsub            
    //   39   48:d2i             
    //   40   49:invokevirtual   #591 <Method void Graphics.drawLine(int, int, int, int)>
        gx.drawLine((int)(x + (double)size), (int)(y - (double)size), (int)x, (int)(y + (double)size));
    //   41   52:aload_0         
    //   42   53:dload_1         
    //   43   54:iload           5
    //   44   56:i2d             
    //   45   57:dadd            
    //   46   58:d2i             
    //   47   59:dload_3         
    //   48   60:iload           5
    //   49   62:i2d             
    //   50   63:dsub            
    //   51   64:d2i             
    //   52   65:dload_1         
    //   53   66:d2i             
    //   54   67:dload_3         
    //   55   68:iload           5
    //   56   70:i2d             
    //   57   71:dadd            
    //   58   72:d2i             
    //   59   73:invokevirtual   #591 <Method void Graphics.drawLine(int, int, int, int)>
    //   60   76:return          
    }

    protected static void drawDataPoint(double x, double y, double xprev, double yprev, 
            int size, int shape, Graphics gx)
    {
        drawDataPoint(x, y, size, shape, gx);
    //    0    0:dload_0         
    //    1    1:dload_2         
    //    2    2:iload           8
    //    3    4:iload           9
    //    4    6:aload           10
    //    5    8:invokestatic    #600 <Method void drawDataPoint(double, double, int, int, Graphics)>
        gx.drawLine((int)x, (int)y, (int)xprev, (int)yprev);
    //    6   11:aload           10
    //    7   13:dload_0         
    //    8   14:d2i             
    //    9   15:dload_2         
    //   10   16:d2i             
    //   11   17:dload           4
    //   12   19:d2i             
    //   13   20:dload           6
    //   14   22:d2i             
    //   15   23:invokevirtual   #591 <Method void Graphics.drawLine(int, int, int, int)>
    //   16   26:return          
    }

    protected static void drawDataPoint(double x, double y, int size, int shape, Graphics gx)
    {
        Font lf = new Font("Monospaced", 0, 12);
    //    0    0:new             #188 <Class Font>
    //    1    3:dup             
    //    2    4:ldc1            #190 <String "Monospaced">
    //    3    6:iconst_0        
    //    4    7:bipush          12
    //    5    9:invokespecial   #193 <Method void Font(String, int, int)>
    //    6   12:astore          7
        FontMetrics fm = gx.getFontMetrics(lf);
    //    7   14:aload           6
    //    8   16:aload           7
    //    9   18:invokevirtual   #417 <Method FontMetrics Graphics.getFontMetrics(Font)>
    //   10   21:astore          8
        if(size == 0)
    //*  11   23:iload           4
    //*  12   25:ifne            31
            size = 1;
    //   13   28:iconst_1        
    //   14   29:istore          4
        if(shape != 1000 && shape != 2000)
    //*  15   31:iload           5
    //*  16   33:sipush          1000
    //*  17   36:icmpeq          53
    //*  18   39:iload           5
    //*  19   41:sipush          2000
    //*  20   44:icmpeq          53
            shape %= 5;
    //   21   47:iload           5
    //   22   49:iconst_5        
    //   23   50:irem            
    //   24   51:istore          5
        switch(shape)
    //*  25   53:iload           5
        {
    //*  26   55:lookupswitch    7: default 249
    //                   0: 120
    //                   1: 132
    //                   2: 144
    //                   3: 156
    //                   4: 168
    //                   1000: 180
    //                   2000: 208
        case 0: // '\0'
            drawX(gx, x, y, size);
    //   27  120:aload           6
    //   28  122:dload_0         
    //   29  123:dload_2         
    //   30  124:iload           4
    //   31  126:invokestatic    #605 <Method void drawX(Graphics, double, double, int)>
            break;

    //*  32  129:goto            249
        case 1: // '\001'
            drawPlus(gx, x, y, size);
    //   33  132:aload           6
    //   34  134:dload_0         
    //   35  135:dload_2         
    //   36  136:iload           4
    //   37  138:invokestatic    #607 <Method void drawPlus(Graphics, double, double, int)>
            break;

    //*  38  141:goto            249
        case 2: // '\002'
            drawDiamond(gx, x, y, size);
    //   39  144:aload           6
    //   40  146:dload_0         
    //   41  147:dload_2         
    //   42  148:iload           4
    //   43  150:invokestatic    #609 <Method void drawDiamond(Graphics, double, double, int)>
            break;

    //*  44  153:goto            249
        case 3: // '\003'
            drawTriangleUp(gx, x, y, size);
    //   45  156:aload           6
    //   46  158:dload_0         
    //   47  159:dload_2         
    //   48  160:iload           4
    //   49  162:invokestatic    #611 <Method void drawTriangleUp(Graphics, double, double, int)>
            break;

    //*  50  165:goto            249
        case 4: // '\004'
            drawTriangleDown(gx, x, y, size);
    //   51  168:aload           6
    //   52  170:dload_0         
    //   53  171:dload_2         
    //   54  172:iload           4
    //   55  174:invokestatic    #613 <Method void drawTriangleDown(Graphics, double, double, int)>
            break;

    //*  56  177:goto            249
        case 1000: 
            gx.drawRect((int)(x - (double)size), (int)(y - (double)size), size * 2, size * 2);
    //   57  180:aload           6
    //   58  182:dload_0         
    //   59  183:iload           4
    //   60  185:i2d             
    //   61  186:dsub            
    //   62  187:d2i             
    //   63  188:dload_2         
    //   64  189:iload           4
    //   65  191:i2d             
    //   66  192:dsub            
    //   67  193:d2i             
    //   68  194:iload           4
    //   69  196:iconst_2        
    //   70  197:imul            
    //   71  198:iload           4
    //   72  200:iconst_2        
    //   73  201:imul            
    //   74  202:invokevirtual   #616 <Method void Graphics.drawRect(int, int, int, int)>
            break;

    //*  75  205:goto            249
        case 2000: 
            int hf = fm.getAscent();
    //   76  208:aload           8
    //   77  210:invokevirtual   #621 <Method int FontMetrics.getAscent()>
    //   78  213:istore          9
            int width = fm.stringWidth("M");
    //   79  215:aload           8
    //   80  217:ldc2            #623 <String "M">
    //   81  220:invokevirtual   #627 <Method int FontMetrics.stringWidth(String)>
    //   82  223:istore          10
            gx.drawString("M", (int)(x - (double)(width / 2)), (int)(y + (double)(hf / 2)));
    //   83  225:aload           6
    //   84  227:ldc2            #623 <String "M">
    //   85  230:dload_0         
    //   86  231:iload           10
    //   87  233:iconst_2        
    //   88  234:idiv            
    //   89  235:i2d             
    //   90  236:dsub            
    //   91  237:d2i             
    //   92  238:dload_2         
    //   93  239:iload           9
    //   94  241:iconst_2        
    //   95  242:idiv            
    //   96  243:i2d             
    //   97  244:dadd            
    //   98  245:d2i             
    //   99  246:invokevirtual   #630 <Method void Graphics.drawString(String, int, int)>
            break;
        }
    //  100  249:return          
    }

    private void updatePturb()
    {
        double xj = 0.0D;
    //    0    0:dconst_0        
    //    1    1:dstore_1        
        double yj = 0.0D;
    //    2    2:dconst_0        
    //    3    3:dstore_3        
        for(int j = 0; j < m_plots.size(); j++)
    //*   4    4:iconst_0        
    //*   5    5:istore          5
    //*   6    7:goto            164
        {
            PlotData2D temp_plot = (PlotData2D)m_plots.elementAt(j);
    //    7   10:aload_0         
    //    8   11:getfield        #102 <Field FastVector m_plots>
    //    9   14:iload           5
    //   10   16:invokevirtual   #332 <Method Object FastVector.elementAt(int)>
    //   11   19:checkcast       #334 <Class PlotData2D>
    //   12   22:astore          6
            for(int i = 0; i < temp_plot.m_plotInstances.numInstances(); i++)
    //*  13   24:iconst_0        
    //*  14   25:istore          7
    //*  15   27:goto            148
                if(!temp_plot.m_plotInstances.instance(i).isMissing(m_xIndex) && !temp_plot.m_plotInstances.instance(i).isMissing(m_yIndex))
    //*  16   30:aload           6
    //*  17   32:getfield        #389 <Field Instances PlotData2D.m_plotInstances>
    //*  18   35:iload           7
    //*  19   37:invokevirtual   #467 <Method Instance Instances.instance(int)>
    //*  20   40:aload_0         
    //*  21   41:getfield        #144 <Field int m_xIndex>
    //*  22   44:invokevirtual   #473 <Method boolean Instance.isMissing(int)>
    //*  23   47:ifne            145
    //*  24   50:aload           6
    //*  25   52:getfield        #389 <Field Instances PlotData2D.m_plotInstances>
    //*  26   55:iload           7
    //*  27   57:invokevirtual   #467 <Method Instance Instances.instance(int)>
    //*  28   60:aload_0         
    //*  29   61:getfield        #146 <Field int m_yIndex>
    //*  30   64:invokevirtual   #473 <Method boolean Instance.isMissing(int)>
    //*  31   67:ifne            145
                {
                    if(m_JitterVal > 0)
    //*  32   70:aload_0         
    //*  33   71:getfield        #170 <Field int m_JitterVal>
    //*  34   74:ifle            93
                    {
                        xj = m_JRand.nextGaussian();
    //   35   77:aload_0         
    //   36   78:getfield        #177 <Field Random m_JRand>
    //   37   81:invokevirtual   #636 <Method double Random.nextGaussian()>
    //   38   84:dstore_1        
                        yj = m_JRand.nextGaussian();
    //   39   85:aload_0         
    //   40   86:getfield        #177 <Field Random m_JRand>
    //   41   89:invokevirtual   #636 <Method double Random.nextGaussian()>
    //   42   92:dstore_3        
                    }
                    temp_plot.m_pointLookup[i][2] = pturbX(temp_plot.m_pointLookup[i][0], xj);
    //   43   93:aload           6
    //   44   95:getfield        #438 <Field double[][] PlotData2D.m_pointLookup>
    //   45   98:iload           7
    //   46  100:aaload          
    //   47  101:iconst_2        
    //   48  102:aload_0         
    //   49  103:aload           6
    //   50  105:getfield        #438 <Field double[][] PlotData2D.m_pointLookup>
    //   51  108:iload           7
    //   52  110:aaload          
    //   53  111:iconst_0        
    //   54  112:daload          
    //   55  113:dload_1         
    //   56  114:invokevirtual   #638 <Method int pturbX(double, double)>
    //   57  117:i2d             
    //   58  118:dastore         
                    temp_plot.m_pointLookup[i][3] = pturbY(temp_plot.m_pointLookup[i][1], yj);
    //   59  119:aload           6
    //   60  121:getfield        #438 <Field double[][] PlotData2D.m_pointLookup>
    //   61  124:iload           7
    //   62  126:aaload          
    //   63  127:iconst_3        
    //   64  128:aload_0         
    //   65  129:aload           6
    //   66  131:getfield        #438 <Field double[][] PlotData2D.m_pointLookup>
    //   67  134:iload           7
    //   68  136:aaload          
    //   69  137:iconst_1        
    //   70  138:daload          
    //   71  139:dload_3         
    //   72  140:invokevirtual   #640 <Method int pturbY(double, double)>
    //   73  143:i2d             
    //   74  144:dastore         
                }

    //   75  145:iinc            7  1
    //   76  148:iload           7
    //   77  150:aload           6
    //   78  152:getfield        #389 <Field Instances PlotData2D.m_plotInstances>
    //   79  155:invokevirtual   #318 <Method int Instances.numInstances()>
    //   80  158:icmplt          30
        }

    //   81  161:iinc            5  1
    //   82  164:iload           5
    //   83  166:aload_0         
    //   84  167:getfield        #102 <Field FastVector m_plots>
    //   85  170:invokevirtual   #219 <Method int FastVector.size()>
    //   86  173:icmplt          10
    //   87  176:return          
    }

    private void fillLookup()
    {
        for(int j = 0; j < m_plots.size(); j++)
    //*   0    0:iconst_0        
    //*   1    1:istore_1        
    //*   2    2:goto            182
        {
            PlotData2D temp_plot = (PlotData2D)m_plots.elementAt(j);
    //    3    5:aload_0         
    //    4    6:getfield        #102 <Field FastVector m_plots>
    //    5    9:iload_1         
    //    6   10:invokevirtual   #332 <Method Object FastVector.elementAt(int)>
    //    7   13:checkcast       #334 <Class PlotData2D>
    //    8   16:astore_2        
            if(temp_plot.m_plotInstances.numInstances() > 0 && temp_plot.m_plotInstances.numAttributes() > 0)
    //*   9   17:aload_2         
    //*  10   18:getfield        #389 <Field Instances PlotData2D.m_plotInstances>
    //*  11   21:invokevirtual   #318 <Method int Instances.numInstances()>
    //*  12   24:ifle            179
    //*  13   27:aload_2         
    //*  14   28:getfield        #389 <Field Instances PlotData2D.m_plotInstances>
    //*  15   31:invokevirtual   #315 <Method int Instances.numAttributes()>
    //*  16   34:ifle            179
            {
                for(int i = 0; i < temp_plot.m_plotInstances.numInstances(); i++)
    //*  17   37:iconst_0        
    //*  18   38:istore_3        
    //*  19   39:goto            168
                    if(temp_plot.m_plotInstances.instance(i).isMissing(m_xIndex) || temp_plot.m_plotInstances.instance(i).isMissing(m_yIndex))
    //*  20   42:aload_2         
    //*  21   43:getfield        #389 <Field Instances PlotData2D.m_plotInstances>
    //*  22   46:iload_3         
    //*  23   47:invokevirtual   #467 <Method Instance Instances.instance(int)>
    //*  24   50:aload_0         
    //*  25   51:getfield        #144 <Field int m_xIndex>
    //*  26   54:invokevirtual   #473 <Method boolean Instance.isMissing(int)>
    //*  27   57:ifne            78
    //*  28   60:aload_2         
    //*  29   61:getfield        #389 <Field Instances PlotData2D.m_plotInstances>
    //*  30   64:iload_3         
    //*  31   65:invokevirtual   #467 <Method Instance Instances.instance(int)>
    //*  32   68:aload_0         
    //*  33   69:getfield        #146 <Field int m_yIndex>
    //*  34   72:invokevirtual   #473 <Method boolean Instance.isMissing(int)>
    //*  35   75:ifeq            103
                    {
                        temp_plot.m_pointLookup[i][0] = (-1.0D / 0.0D);
    //   36   78:aload_2         
    //   37   79:getfield        #438 <Field double[][] PlotData2D.m_pointLookup>
    //   38   82:iload_3         
    //   39   83:aaload          
    //   40   84:iconst_0        
    //   41   85:ldc2w           #439 <Double (-1.0D / 0.0D)>
    //   42   88:dastore         
                        temp_plot.m_pointLookup[i][1] = (-1.0D / 0.0D);
    //   43   89:aload_2         
    //   44   90:getfield        #438 <Field double[][] PlotData2D.m_pointLookup>
    //   45   93:iload_3         
    //   46   94:aaload          
    //   47   95:iconst_1        
    //   48   96:ldc2w           #439 <Double (-1.0D / 0.0D)>
    //   49   99:dastore         
                    } else
    //*  50  100:goto            165
                    {
                        double x = convertToPanelX(temp_plot.m_plotInstances.instance(i).value(m_xIndex));
    //   51  103:aload_0         
    //   52  104:aload_2         
    //   53  105:getfield        #389 <Field Instances PlotData2D.m_plotInstances>
    //   54  108:iload_3         
    //   55  109:invokevirtual   #467 <Method Instance Instances.instance(int)>
    //   56  112:aload_0         
    //   57  113:getfield        #144 <Field int m_xIndex>
    //   58  116:invokevirtual   #483 <Method double Instance.value(int)>
    //   59  119:invokevirtual   #642 <Method double convertToPanelX(double)>
    //   60  122:dstore          4
                        double y = convertToPanelY(temp_plot.m_plotInstances.instance(i).value(m_yIndex));
    //   61  124:aload_0         
    //   62  125:aload_2         
    //   63  126:getfield        #389 <Field Instances PlotData2D.m_plotInstances>
    //   64  129:iload_3         
    //   65  130:invokevirtual   #467 <Method Instance Instances.instance(int)>
    //   66  133:aload_0         
    //   67  134:getfield        #146 <Field int m_yIndex>
    //   68  137:invokevirtual   #483 <Method double Instance.value(int)>
    //   69  140:invokevirtual   #644 <Method double convertToPanelY(double)>
    //   70  143:dstore          6
                        temp_plot.m_pointLookup[i][0] = x;
    //   71  145:aload_2         
    //   72  146:getfield        #438 <Field double[][] PlotData2D.m_pointLookup>
    //   73  149:iload_3         
    //   74  150:aaload          
    //   75  151:iconst_0        
    //   76  152:dload           4
    //   77  154:dastore         
                        temp_plot.m_pointLookup[i][1] = y;
    //   78  155:aload_2         
    //   79  156:getfield        #438 <Field double[][] PlotData2D.m_pointLookup>
    //   80  159:iload_3         
    //   81  160:aaload          
    //   82  161:iconst_1        
    //   83  162:dload           6
    //   84  164:dastore         
                    }

    //   85  165:iinc            3  1
    //   86  168:iload_3         
    //   87  169:aload_2         
    //   88  170:getfield        #389 <Field Instances PlotData2D.m_plotInstances>
    //   89  173:invokevirtual   #318 <Method int Instances.numInstances()>
    //   90  176:icmplt          42
            }
        }

    //   91  179:iinc            1  1
    //   92  182:iload_1         
    //   93  183:aload_0         
    //   94  184:getfield        #102 <Field FastVector m_plots>
    //   95  187:invokevirtual   #219 <Method int FastVector.size()>
    //   96  190:icmplt          5
    //   97  193:return          
    }

    private void paintData(Graphics gx)
    {
        for(int j = 0; j < m_plots.size(); j++)
    //*   0    0:iconst_0        
    //*   1    1:istore_2        
    //*   2    2:goto            945
        {
            PlotData2D temp_plot = (PlotData2D)m_plots.elementAt(j);
    //    3    5:aload_0         
    //    4    6:getfield        #102 <Field FastVector m_plots>
    //    5    9:iload_2         
    //    6   10:invokevirtual   #332 <Method Object FastVector.elementAt(int)>
    //    7   13:checkcast       #334 <Class PlotData2D>
    //    8   16:astore_3        
            for(int i = 0; i < temp_plot.m_plotInstances.numInstances(); i++)
    //*   9   17:iconst_0        
    //*  10   18:istore          4
    //*  11   20:goto            930
                if(!temp_plot.m_plotInstances.instance(i).isMissing(m_xIndex) && !temp_plot.m_plotInstances.instance(i).isMissing(m_yIndex))
    //*  12   23:aload_3         
    //*  13   24:getfield        #389 <Field Instances PlotData2D.m_plotInstances>
    //*  14   27:iload           4
    //*  15   29:invokevirtual   #467 <Method Instance Instances.instance(int)>
    //*  16   32:aload_0         
    //*  17   33:getfield        #144 <Field int m_xIndex>
    //*  18   36:invokevirtual   #473 <Method boolean Instance.isMissing(int)>
    //*  19   39:ifne            927
    //*  20   42:aload_3         
    //*  21   43:getfield        #389 <Field Instances PlotData2D.m_plotInstances>
    //*  22   46:iload           4
    //*  23   48:invokevirtual   #467 <Method Instance Instances.instance(int)>
    //*  24   51:aload_0         
    //*  25   52:getfield        #146 <Field int m_yIndex>
    //*  26   55:invokevirtual   #473 <Method boolean Instance.isMissing(int)>
    //*  27   58:ifne            927
                {
                    double x = temp_plot.m_pointLookup[i][0] + temp_plot.m_pointLookup[i][2];
    //   28   61:aload_3         
    //   29   62:getfield        #438 <Field double[][] PlotData2D.m_pointLookup>
    //   30   65:iload           4
    //   31   67:aaload          
    //   32   68:iconst_0        
    //   33   69:daload          
    //   34   70:aload_3         
    //   35   71:getfield        #438 <Field double[][] PlotData2D.m_pointLookup>
    //   36   74:iload           4
    //   37   76:aaload          
    //   38   77:iconst_2        
    //   39   78:daload          
    //   40   79:dadd            
    //   41   80:dstore          5
                    double y = temp_plot.m_pointLookup[i][1] + temp_plot.m_pointLookup[i][3];
    //   42   82:aload_3         
    //   43   83:getfield        #438 <Field double[][] PlotData2D.m_pointLookup>
    //   44   86:iload           4
    //   45   88:aaload          
    //   46   89:iconst_1        
    //   47   90:daload          
    //   48   91:aload_3         
    //   49   92:getfield        #438 <Field double[][] PlotData2D.m_pointLookup>
    //   50   95:iload           4
    //   51   97:aaload          
    //   52   98:iconst_3        
    //   53   99:daload          
    //   54  100:dadd            
    //   55  101:dstore          7
                    double prevx = 0.0D;
    //   56  103:dconst_0        
    //   57  104:dstore          9
                    double prevy = 0.0D;
    //   58  106:dconst_0        
    //   59  107:dstore          11
                    if(i > 0)
    //*  60  109:iload           4
    //*  61  111:ifle            164
                    {
                        prevx = temp_plot.m_pointLookup[i - 1][0] + temp_plot.m_pointLookup[i - 1][2];
    //   62  114:aload_3         
    //   63  115:getfield        #438 <Field double[][] PlotData2D.m_pointLookup>
    //   64  118:iload           4
    //   65  120:iconst_1        
    //   66  121:isub            
    //   67  122:aaload          
    //   68  123:iconst_0        
    //   69  124:daload          
    //   70  125:aload_3         
    //   71  126:getfield        #438 <Field double[][] PlotData2D.m_pointLookup>
    //   72  129:iload           4
    //   73  131:iconst_1        
    //   74  132:isub            
    //   75  133:aaload          
    //   76  134:iconst_2        
    //   77  135:daload          
    //   78  136:dadd            
    //   79  137:dstore          9
                        prevy = temp_plot.m_pointLookup[i - 1][1] + temp_plot.m_pointLookup[i - 1][3];
    //   80  139:aload_3         
    //   81  140:getfield        #438 <Field double[][] PlotData2D.m_pointLookup>
    //   82  143:iload           4
    //   83  145:iconst_1        
    //   84  146:isub            
    //   85  147:aaload          
    //   86  148:iconst_1        
    //   87  149:daload          
    //   88  150:aload_3         
    //   89  151:getfield        #438 <Field double[][] PlotData2D.m_pointLookup>
    //   90  154:iload           4
    //   91  156:iconst_1        
    //   92  157:isub            
    //   93  158:aaload          
    //   94  159:iconst_3        
    //   95  160:daload          
    //   96  161:dadd            
    //   97  162:dstore          11
                    }
                    int x_range = (int)x - m_XaxisStart;
    //   98  164:dload           5
    //   99  166:d2i             
    //  100  167:aload_0         
    //  101  168:getfield        #156 <Field int m_XaxisStart>
    //  102  171:isub            
    //  103  172:istore          13
                    int y_range = (int)y - m_YaxisStart;
    //  104  174:dload           7
    //  105  176:d2i             
    //  106  177:aload_0         
    //  107  178:getfield        #158 <Field int m_YaxisStart>
    //  108  181:isub            
    //  109  182:istore          14
                    if(x_range >= 0 && y_range >= 0 && (m_drawnPoints[x_range][y_range] == i || m_drawnPoints[x_range][y_range] == 0 || temp_plot.m_shapeSize[i] == temp_plot.m_alwaysDisplayPointsOfThisSize || temp_plot.m_displayAllPoints))
    //* 110  184:iload           13
    //* 111  186:iflt            927
    //* 112  189:iload           14
    //* 113  191:iflt            927
    //* 114  194:aload_0         
    //* 115  195:getfield        #211 <Field int[][] m_drawnPoints>
    //* 116  198:iload           13
    //* 117  200:aaload          
    //* 118  201:iload           14
    //* 119  203:iaload          
    //* 120  204:iload           4
    //* 121  206:icmpeq          243
    //* 122  209:aload_0         
    //* 123  210:getfield        #211 <Field int[][] m_drawnPoints>
    //* 124  213:iload           13
    //* 125  215:aaload          
    //* 126  216:iload           14
    //* 127  218:iaload          
    //* 128  219:ifeq            243
    //* 129  222:aload_3         
    //* 130  223:getfield        #444 <Field int[] PlotData2D.m_shapeSize>
    //* 131  226:iload           4
    //* 132  228:iaload          
    //* 133  229:aload_3         
    //* 134  230:getfield        #648 <Field int PlotData2D.m_alwaysDisplayPointsOfThisSize>
    //* 135  233:icmpeq          243
    //* 136  236:aload_3         
    //* 137  237:getfield        #651 <Field boolean PlotData2D.m_displayAllPoints>
    //* 138  240:ifeq            927
                    {
                        m_drawnPoints[x_range][y_range] = i;
    //  139  243:aload_0         
    //  140  244:getfield        #211 <Field int[][] m_drawnPoints>
    //  141  247:iload           13
    //  142  249:aaload          
    //  143  250:iload           14
    //  144  252:iload           4
    //  145  254:iastore         
                        if(temp_plot.m_plotInstances.attribute(m_cIndex).isNominal())
    //* 146  255:aload_3         
    //* 147  256:getfield        #389 <Field Instances PlotData2D.m_plotInstances>
    //* 148  259:aload_0         
    //* 149  260:getfield        #148 <Field int m_cIndex>
    //* 150  263:invokevirtual   #426 <Method Attribute Instances.attribute(int)>
    //* 151  266:invokevirtual   #479 <Method boolean Attribute.isNominal()>
    //* 152  269:ifeq            607
                        {
                            if(temp_plot.m_plotInstances.attribute(m_cIndex).numValues() > m_colorList.size() && !temp_plot.m_useCustomColour)
    //* 153  272:aload_3         
    //* 154  273:getfield        #389 <Field Instances PlotData2D.m_plotInstances>
    //* 155  276:aload_0         
    //* 156  277:getfield        #148 <Field int m_cIndex>
    //* 157  280:invokevirtual   #426 <Method Attribute Instances.attribute(int)>
    //* 158  283:invokevirtual   #654 <Method int Attribute.numValues()>
    //* 159  286:aload_0         
    //* 160  287:getfield        #216 <Field FastVector m_colorList>
    //* 161  290:invokevirtual   #219 <Method int FastVector.size()>
    //* 162  293:icmple          321
    //* 163  296:aload_3         
    //* 164  297:getfield        #657 <Field boolean PlotData2D.m_useCustomColour>
    //* 165  300:ifne            321
                                extendColourMap(temp_plot.m_plotInstances.attribute(m_cIndex).numValues());
    //  166  303:aload_0         
    //  167  304:aload_3         
    //  168  305:getfield        #389 <Field Instances PlotData2D.m_plotInstances>
    //  169  308:aload_0         
    //  170  309:getfield        #148 <Field int m_cIndex>
    //  171  312:invokevirtual   #426 <Method Attribute Instances.attribute(int)>
    //  172  315:invokevirtual   #654 <Method int Attribute.numValues()>
    //  173  318:invokespecial   #660 <Method void extendColourMap(int)>
                            Color ci;
                            if(temp_plot.m_plotInstances.instance(i).isMissing(m_cIndex))
    //* 174  321:aload_3         
    //* 175  322:getfield        #389 <Field Instances PlotData2D.m_plotInstances>
    //* 176  325:iload           4
    //* 177  327:invokevirtual   #467 <Method Instance Instances.instance(int)>
    //* 178  330:aload_0         
    //* 179  331:getfield        #148 <Field int m_cIndex>
    //* 180  334:invokevirtual   #473 <Method boolean Instance.isMissing(int)>
    //* 181  337:ifeq            348
                            {
                                ci = Color.gray;
    //  182  340:getstatic       #663 <Field Color Color.gray>
    //  183  343:astore          15
                            } else
    //* 184  345:goto            381
                            {
                                int ind = (int)temp_plot.m_plotInstances.instance(i).value(m_cIndex);
    //  185  348:aload_3         
    //  186  349:getfield        #389 <Field Instances PlotData2D.m_plotInstances>
    //  187  352:iload           4
    //  188  354:invokevirtual   #467 <Method Instance Instances.instance(int)>
    //  189  357:aload_0         
    //  190  358:getfield        #148 <Field int m_cIndex>
    //  191  361:invokevirtual   #483 <Method double Instance.value(int)>
    //  192  364:d2i             
    //  193  365:istore          16
                                ci = (Color)m_colorList.elementAt(ind);
    //  194  367:aload_0         
    //  195  368:getfield        #216 <Field FastVector m_colorList>
    //  196  371:iload           16
    //  197  373:invokevirtual   #332 <Method Object FastVector.elementAt(int)>
    //  198  376:checkcast       #87  <Class Color>
    //  199  379:astore          15
                            }
                            if(!temp_plot.m_useCustomColour)
    //* 200  381:aload_3         
    //* 201  382:getfield        #657 <Field boolean PlotData2D.m_useCustomColour>
    //* 202  385:ifne            397
                                gx.setColor(ci);
    //  203  388:aload_1         
    //  204  389:aload           15
    //  205  391:invokevirtual   #666 <Method void Graphics.setColor(Color)>
                            else
    //* 206  394:goto            405
                                gx.setColor(temp_plot.m_customColour);
    //  207  397:aload_1         
    //  208  398:aload_3         
    //  209  399:getfield        #669 <Field Color PlotData2D.m_customColour>
    //  210  402:invokevirtual   #666 <Method void Graphics.setColor(Color)>
                            if(temp_plot.m_plotInstances.instance(i).isMissing(m_cIndex))
    //* 211  405:aload_3         
    //* 212  406:getfield        #389 <Field Instances PlotData2D.m_plotInstances>
    //* 213  409:iload           4
    //* 214  411:invokevirtual   #467 <Method Instance Instances.instance(int)>
    //* 215  414:aload_0         
    //* 216  415:getfield        #148 <Field int m_cIndex>
    //* 217  418:invokevirtual   #473 <Method boolean Instance.isMissing(int)>
    //* 218  421:ifeq            480
                            {
                                if(temp_plot.m_connectPoints[i])
    //* 219  424:aload_3         
    //* 220  425:getfield        #673 <Field boolean[] PlotData2D.m_connectPoints>
    //* 221  428:iload           4
    //* 222  430:baload          
    //* 223  431:ifeq            459
                                    drawDataPoint(x, y, prevx, prevy, temp_plot.m_shapeSize[i], 2000, gx);
    //  224  434:dload           5
    //  225  436:dload           7
    //  226  438:dload           9
    //  227  440:dload           11
    //  228  442:aload_3         
    //  229  443:getfield        #444 <Field int[] PlotData2D.m_shapeSize>
    //  230  446:iload           4
    //  231  448:iaload          
    //  232  449:sipush          2000
    //  233  452:aload_1         
    //  234  453:invokestatic    #675 <Method void drawDataPoint(double, double, double, double, int, int, Graphics)>
                                else
    //* 235  456:goto            927
                                    drawDataPoint(x, y, temp_plot.m_shapeSize[i], 2000, gx);
    //  236  459:dload           5
    //  237  461:dload           7
    //  238  463:aload_3         
    //  239  464:getfield        #444 <Field int[] PlotData2D.m_shapeSize>
    //  240  467:iload           4
    //  241  469:iaload          
    //  242  470:sipush          2000
    //  243  473:aload_1         
    //  244  474:invokestatic    #600 <Method void drawDataPoint(double, double, int, int, Graphics)>
                            } else
    //* 245  477:goto            927
                            if(temp_plot.m_shapeType[i] == -1)
    //* 246  480:aload_3         
    //* 247  481:getfield        #678 <Field int[] PlotData2D.m_shapeType>
    //* 248  484:iload           4
    //* 249  486:iaload          
    //* 250  487:iconst_m1       
    //* 251  488:icmpne          543
                            {
                                if(temp_plot.m_connectPoints[i])
    //* 252  491:aload_3         
    //* 253  492:getfield        #673 <Field boolean[] PlotData2D.m_connectPoints>
    //* 254  495:iload           4
    //* 255  497:baload          
    //* 256  498:ifeq            524
                                    drawDataPoint(x, y, prevx, prevy, temp_plot.m_shapeSize[i], j, gx);
    //  257  501:dload           5
    //  258  503:dload           7
    //  259  505:dload           9
    //  260  507:dload           11
    //  261  509:aload_3         
    //  262  510:getfield        #444 <Field int[] PlotData2D.m_shapeSize>
    //  263  513:iload           4
    //  264  515:iaload          
    //  265  516:iload_2         
    //  266  517:aload_1         
    //  267  518:invokestatic    #675 <Method void drawDataPoint(double, double, double, double, int, int, Graphics)>
                                else
    //* 268  521:goto            927
                                    drawDataPoint(x, y, temp_plot.m_shapeSize[i], j, gx);
    //  269  524:dload           5
    //  270  526:dload           7
    //  271  528:aload_3         
    //  272  529:getfield        #444 <Field int[] PlotData2D.m_shapeSize>
    //  273  532:iload           4
    //  274  534:iaload          
    //  275  535:iload_2         
    //  276  536:aload_1         
    //  277  537:invokestatic    #600 <Method void drawDataPoint(double, double, int, int, Graphics)>
                            } else
    //* 278  540:goto            927
                            if(temp_plot.m_connectPoints[i])
    //* 279  543:aload_3         
    //* 280  544:getfield        #673 <Field boolean[] PlotData2D.m_connectPoints>
    //* 281  547:iload           4
    //* 282  549:baload          
    //* 283  550:ifeq            582
                                drawDataPoint(x, y, prevx, prevy, temp_plot.m_shapeSize[i], temp_plot.m_shapeType[i], gx);
    //  284  553:dload           5
    //  285  555:dload           7
    //  286  557:dload           9
    //  287  559:dload           11
    //  288  561:aload_3         
    //  289  562:getfield        #444 <Field int[] PlotData2D.m_shapeSize>
    //  290  565:iload           4
    //  291  567:iaload          
    //  292  568:aload_3         
    //  293  569:getfield        #678 <Field int[] PlotData2D.m_shapeType>
    //  294  572:iload           4
    //  295  574:iaload          
    //  296  575:aload_1         
    //  297  576:invokestatic    #675 <Method void drawDataPoint(double, double, double, double, int, int, Graphics)>
                            else
    //* 298  579:goto            927
                                drawDataPoint(x, y, temp_plot.m_shapeSize[i], temp_plot.m_shapeType[i], gx);
    //  299  582:dload           5
    //  300  584:dload           7
    //  301  586:aload_3         
    //  302  587:getfield        #444 <Field int[] PlotData2D.m_shapeSize>
    //  303  590:iload           4
    //  304  592:iaload          
    //  305  593:aload_3         
    //  306  594:getfield        #678 <Field int[] PlotData2D.m_shapeType>
    //  307  597:iload           4
    //  308  599:iaload          
    //  309  600:aload_1         
    //  310  601:invokestatic    #600 <Method void drawDataPoint(double, double, int, int, Graphics)>
                        } else
    //* 311  604:goto            927
                        {
                            Color ci = null;
    //  312  607:aconst_null     
    //  313  608:astore          17
                            if(!temp_plot.m_plotInstances.instance(i).isMissing(m_cIndex))
    //* 314  610:aload_3         
    //* 315  611:getfield        #389 <Field Instances PlotData2D.m_plotInstances>
    //* 316  614:iload           4
    //* 317  616:invokevirtual   #467 <Method Instance Instances.instance(int)>
    //* 318  619:aload_0         
    //* 319  620:getfield        #148 <Field int m_cIndex>
    //* 320  623:invokevirtual   #473 <Method boolean Instance.isMissing(int)>
    //* 321  626:ifne            699
                            {
                                double r = (temp_plot.m_plotInstances.instance(i).value(m_cIndex) - m_minC) / (m_maxC - m_minC);
    //  322  629:aload_3         
    //  323  630:getfield        #389 <Field Instances PlotData2D.m_plotInstances>
    //  324  633:iload           4
    //  325  635:invokevirtual   #467 <Method Instance Instances.instance(int)>
    //  326  638:aload_0         
    //  327  639:getfield        #148 <Field int m_cIndex>
    //  328  642:invokevirtual   #483 <Method double Instance.value(int)>
    //  329  645:aload_0         
    //  330  646:getfield        #372 <Field double m_minC>
    //  331  649:dsub            
    //  332  650:aload_0         
    //  333  651:getfield        #369 <Field double m_maxC>
    //  334  654:aload_0         
    //  335  655:getfield        #372 <Field double m_minC>
    //  336  658:dsub            
    //  337  659:ddiv            
    //  338  660:dstore          15
                                r = r * 240D + 15D;
    //  339  662:dload           15
    //  340  664:ldc2w           #679 <Double 240D>
    //  341  667:dmul            
    //  342  668:ldc2w           #681 <Double 15D>
    //  343  671:dadd            
    //  344  672:dstore          15
                                ci = new Color((int)r, 150, (int)(255D - r));
    //  345  674:new             #87  <Class Color>
    //  346  677:dup             
    //  347  678:dload           15
    //  348  680:d2i             
    //  349  681:sipush          150
    //  350  684:ldc2w           #683 <Double 255D>
    //  351  687:dload           15
    //  352  689:dsub            
    //  353  690:d2i             
    //  354  691:invokespecial   #134 <Method void Color(int, int, int)>
    //  355  694:astore          17
                            } else
    //* 356  696:goto            704
                            {
                                ci = Color.gray;
    //  357  699:getstatic       #663 <Field Color Color.gray>
    //  358  702:astore          17
                            }
                            if(!temp_plot.m_useCustomColour)
    //* 359  704:aload_3         
    //* 360  705:getfield        #657 <Field boolean PlotData2D.m_useCustomColour>
    //* 361  708:ifne            720
                                gx.setColor(ci);
    //  362  711:aload_1         
    //  363  712:aload           17
    //  364  714:invokevirtual   #666 <Method void Graphics.setColor(Color)>
                            else
    //* 365  717:goto            728
                                gx.setColor(temp_plot.m_customColour);
    //  366  720:aload_1         
    //  367  721:aload_3         
    //  368  722:getfield        #669 <Field Color PlotData2D.m_customColour>
    //  369  725:invokevirtual   #666 <Method void Graphics.setColor(Color)>
                            if(temp_plot.m_plotInstances.instance(i).isMissing(m_cIndex))
    //* 370  728:aload_3         
    //* 371  729:getfield        #389 <Field Instances PlotData2D.m_plotInstances>
    //* 372  732:iload           4
    //* 373  734:invokevirtual   #467 <Method Instance Instances.instance(int)>
    //* 374  737:aload_0         
    //* 375  738:getfield        #148 <Field int m_cIndex>
    //* 376  741:invokevirtual   #473 <Method boolean Instance.isMissing(int)>
    //* 377  744:ifeq            803
                            {
                                if(temp_plot.m_connectPoints[i])
    //* 378  747:aload_3         
    //* 379  748:getfield        #673 <Field boolean[] PlotData2D.m_connectPoints>
    //* 380  751:iload           4
    //* 381  753:baload          
    //* 382  754:ifeq            782
                                    drawDataPoint(x, y, prevx, prevy, temp_plot.m_shapeSize[i], 2000, gx);
    //  383  757:dload           5
    //  384  759:dload           7
    //  385  761:dload           9
    //  386  763:dload           11
    //  387  765:aload_3         
    //  388  766:getfield        #444 <Field int[] PlotData2D.m_shapeSize>
    //  389  769:iload           4
    //  390  771:iaload          
    //  391  772:sipush          2000
    //  392  775:aload_1         
    //  393  776:invokestatic    #675 <Method void drawDataPoint(double, double, double, double, int, int, Graphics)>
                                else
    //* 394  779:goto            927
                                    drawDataPoint(x, y, temp_plot.m_shapeSize[i], 2000, gx);
    //  395  782:dload           5
    //  396  784:dload           7
    //  397  786:aload_3         
    //  398  787:getfield        #444 <Field int[] PlotData2D.m_shapeSize>
    //  399  790:iload           4
    //  400  792:iaload          
    //  401  793:sipush          2000
    //  402  796:aload_1         
    //  403  797:invokestatic    #600 <Method void drawDataPoint(double, double, int, int, Graphics)>
                            } else
    //* 404  800:goto            927
                            if(temp_plot.m_shapeType[i] == -1)
    //* 405  803:aload_3         
    //* 406  804:getfield        #678 <Field int[] PlotData2D.m_shapeType>
    //* 407  807:iload           4
    //* 408  809:iaload          
    //* 409  810:iconst_m1       
    //* 410  811:icmpne          866
                            {
                                if(temp_plot.m_connectPoints[i])
    //* 411  814:aload_3         
    //* 412  815:getfield        #673 <Field boolean[] PlotData2D.m_connectPoints>
    //* 413  818:iload           4
    //* 414  820:baload          
    //* 415  821:ifeq            847
                                    drawDataPoint(x, y, prevx, prevy, temp_plot.m_shapeSize[i], j, gx);
    //  416  824:dload           5
    //  417  826:dload           7
    //  418  828:dload           9
    //  419  830:dload           11
    //  420  832:aload_3         
    //  421  833:getfield        #444 <Field int[] PlotData2D.m_shapeSize>
    //  422  836:iload           4
    //  423  838:iaload          
    //  424  839:iload_2         
    //  425  840:aload_1         
    //  426  841:invokestatic    #675 <Method void drawDataPoint(double, double, double, double, int, int, Graphics)>
                                else
    //* 427  844:goto            927
                                    drawDataPoint(x, y, temp_plot.m_shapeSize[i], j, gx);
    //  428  847:dload           5
    //  429  849:dload           7
    //  430  851:aload_3         
    //  431  852:getfield        #444 <Field int[] PlotData2D.m_shapeSize>
    //  432  855:iload           4
    //  433  857:iaload          
    //  434  858:iload_2         
    //  435  859:aload_1         
    //  436  860:invokestatic    #600 <Method void drawDataPoint(double, double, int, int, Graphics)>
                            } else
    //* 437  863:goto            927
                            if(temp_plot.m_connectPoints[i])
    //* 438  866:aload_3         
    //* 439  867:getfield        #673 <Field boolean[] PlotData2D.m_connectPoints>
    //* 440  870:iload           4
    //* 441  872:baload          
    //* 442  873:ifeq            905
                                drawDataPoint(x, y, prevx, prevy, temp_plot.m_shapeSize[i], temp_plot.m_shapeType[i], gx);
    //  443  876:dload           5
    //  444  878:dload           7
    //  445  880:dload           9
    //  446  882:dload           11
    //  447  884:aload_3         
    //  448  885:getfield        #444 <Field int[] PlotData2D.m_shapeSize>
    //  449  888:iload           4
    //  450  890:iaload          
    //  451  891:aload_3         
    //  452  892:getfield        #678 <Field int[] PlotData2D.m_shapeType>
    //  453  895:iload           4
    //  454  897:iaload          
    //  455  898:aload_1         
    //  456  899:invokestatic    #675 <Method void drawDataPoint(double, double, double, double, int, int, Graphics)>
                            else
    //* 457  902:goto            927
                                drawDataPoint(x, y, temp_plot.m_shapeSize[i], temp_plot.m_shapeType[i], gx);
    //  458  905:dload           5
    //  459  907:dload           7
    //  460  909:aload_3         
    //  461  910:getfield        #444 <Field int[] PlotData2D.m_shapeSize>
    //  462  913:iload           4
    //  463  915:iaload          
    //  464  916:aload_3         
    //  465  917:getfield        #678 <Field int[] PlotData2D.m_shapeType>
    //  466  920:iload           4
    //  467  922:iaload          
    //  468  923:aload_1         
    //  469  924:invokestatic    #600 <Method void drawDataPoint(double, double, int, int, Graphics)>
                        }
                    }
                }

    //  470  927:iinc            4  1
    //  471  930:iload           4
    //  472  932:aload_3         
    //  473  933:getfield        #389 <Field Instances PlotData2D.m_plotInstances>
    //  474  936:invokevirtual   #318 <Method int Instances.numInstances()>
    //  475  939:icmplt          23
        }

    //  476  942:iinc            2  1
    //  477  945:iload_2         
    //  478  946:aload_0         
    //  479  947:getfield        #102 <Field FastVector m_plots>
    //  480  950:invokevirtual   #219 <Method int FastVector.size()>
    //  481  953:icmplt          5
    //  482  956:return          
    }

    private void paintAxis(Graphics gx)
    {
        setFonts(gx);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokespecial   #694 <Method void setFonts(Graphics)>
        int mxs = m_XaxisStart;
    //    3    5:aload_0         
    //    4    6:getfield        #156 <Field int m_XaxisStart>
    //    5    9:istore_2        
        int mxe = m_XaxisEnd;
    //    6   10:aload_0         
    //    7   11:getfield        #160 <Field int m_XaxisEnd>
    //    8   14:istore_3        
        int mys = m_YaxisStart;
    //    9   15:aload_0         
    //   10   16:getfield        #158 <Field int m_YaxisStart>
    //   11   19:istore          4
        int mye = m_YaxisEnd;
    //   12   21:aload_0         
    //   13   22:getfield        #162 <Field int m_YaxisEnd>
    //   14   25:istore          5
        m_plotResize = false;
    //   15   27:aload_0         
    //   16   28:iconst_0        
    //   17   29:putfield        #164 <Field boolean m_plotResize>
        int h = getHeight();
    //   18   32:aload_0         
    //   19   33:invokevirtual   #208 <Method int getHeight()>
    //   20   36:istore          6
        int w = getWidth();
    //   21   38:aload_0         
    //   22   39:invokevirtual   #205 <Method int getWidth()>
    //   23   42:istore          7
        int hf = m_labelMetrics.getAscent();
    //   24   44:aload_0         
    //   25   45:getfield        #168 <Field FontMetrics m_labelMetrics>
    //   26   48:invokevirtual   #621 <Method int FontMetrics.getAscent()>
    //   27   51:istore          8
        int mswx = 0;
    //   28   53:iconst_0        
    //   29   54:istore          9
        int mswy = 0;
    //   30   56:iconst_0        
    //   31   57:istore          10
        int precisionXmax = 1;
    //   32   59:iconst_1        
    //   33   60:istore          11
        int precisionXmin = 1;
    //   34   62:iconst_1        
    //   35   63:istore          12
        int precisionXmid = 1;
    //   36   65:iconst_1        
    //   37   66:istore          13
        int whole = (int)Math.abs(m_maxX);
    //   38   68:aload_0         
    //   39   69:getfield        #357 <Field double m_maxX>
    //   40   72:invokestatic    #699 <Method double Math.abs(double)>
    //   41   75:d2i             
    //   42   76:istore          14
        double decimal = Math.abs(m_maxX) - (double)whole;
    //   43   78:aload_0         
    //   44   79:getfield        #357 <Field double m_maxX>
    //   45   82:invokestatic    #699 <Method double Math.abs(double)>
    //   46   85:iload           14
    //   47   87:i2d             
    //   48   88:dsub            
    //   49   89:dstore          15
        int nondecimal = whole <= 0 ? 1 : (int)(Math.log(whole) / Math.log(10D));
    //   50   91:iload           14
    //   51   93:ifle            113
    //   52   96:iload           14
    //   53   98:i2d             
    //   54   99:invokestatic    #702 <Method double Math.log(double)>
    //   55  102:ldc2w           #703 <Double 10D>
    //   56  105:invokestatic    #702 <Method double Math.log(double)>
    //   57  108:ddiv            
    //   58  109:d2i             
    //   59  110:goto            114
    //   60  113:iconst_1        
    //   61  114:istore          17
        precisionXmax = decimal <= 0.0D ? 1 : (int)Math.abs(Math.log(Math.abs(m_maxX)) / Math.log(10D)) + 2;
    //   62  116:dload           15
    //   63  118:dconst_0        
    //   64  119:dcmpl           
    //   65  120:ifle            149
    //   66  123:aload_0         
    //   67  124:getfield        #357 <Field double m_maxX>
    //   68  127:invokestatic    #699 <Method double Math.abs(double)>
    //   69  130:invokestatic    #702 <Method double Math.log(double)>
    //   70  133:ldc2w           #703 <Double 10D>
    //   71  136:invokestatic    #702 <Method double Math.log(double)>
    //   72  139:ddiv            
    //   73  140:invokestatic    #699 <Method double Math.abs(double)>
    //   74  143:d2i             
    //   75  144:iconst_2        
    //   76  145:iadd            
    //   77  146:goto            150
    //   78  149:iconst_1        
    //   79  150:istore          11
        if(precisionXmax > VisualizeUtils.MAX_PRECISION)
    //*  80  152:iload           11
    //*  81  154:getstatic       #707 <Field int VisualizeUtils.MAX_PRECISION>
    //*  82  157:icmple          163
            precisionXmax = 1;
    //   83  160:iconst_1        
    //   84  161:istore          11
        String maxStringX = Utils.doubleToString(m_maxX, nondecimal + 1 + precisionXmax, precisionXmax);
    //   85  163:aload_0         
    //   86  164:getfield        #357 <Field double m_maxX>
    //   87  167:iload           17
    //   88  169:iconst_1        
    //   89  170:iadd            
    //   90  171:iload           11
    //   91  173:iadd            
    //   92  174:iload           11
    //   93  176:invokestatic    #713 <Method String Utils.doubleToString(double, int, int)>
    //   94  179:astore          18
        whole = (int)Math.abs(m_minX);
    //   95  181:aload_0         
    //   96  182:getfield        #363 <Field double m_minX>
    //   97  185:invokestatic    #699 <Method double Math.abs(double)>
    //   98  188:d2i             
    //   99  189:istore          14
        decimal = Math.abs(m_minX) - (double)whole;
    //  100  191:aload_0         
    //  101  192:getfield        #363 <Field double m_minX>
    //  102  195:invokestatic    #699 <Method double Math.abs(double)>
    //  103  198:iload           14
    //  104  200:i2d             
    //  105  201:dsub            
    //  106  202:dstore          15
        nondecimal = whole <= 0 ? 1 : (int)(Math.log(whole) / Math.log(10D));
    //  107  204:iload           14
    //  108  206:ifle            226
    //  109  209:iload           14
    //  110  211:i2d             
    //  111  212:invokestatic    #702 <Method double Math.log(double)>
    //  112  215:ldc2w           #703 <Double 10D>
    //  113  218:invokestatic    #702 <Method double Math.log(double)>
    //  114  221:ddiv            
    //  115  222:d2i             
    //  116  223:goto            227
    //  117  226:iconst_1        
    //  118  227:istore          17
        precisionXmin = decimal <= 0.0D ? 1 : (int)Math.abs(Math.log(Math.abs(m_minX)) / Math.log(10D)) + 2;
    //  119  229:dload           15
    //  120  231:dconst_0        
    //  121  232:dcmpl           
    //  122  233:ifle            262
    //  123  236:aload_0         
    //  124  237:getfield        #363 <Field double m_minX>
    //  125  240:invokestatic    #699 <Method double Math.abs(double)>
    //  126  243:invokestatic    #702 <Method double Math.log(double)>
    //  127  246:ldc2w           #703 <Double 10D>
    //  128  249:invokestatic    #702 <Method double Math.log(double)>
    //  129  252:ddiv            
    //  130  253:invokestatic    #699 <Method double Math.abs(double)>
    //  131  256:d2i             
    //  132  257:iconst_2        
    //  133  258:iadd            
    //  134  259:goto            263
    //  135  262:iconst_1        
    //  136  263:istore          12
        if(precisionXmin > VisualizeUtils.MAX_PRECISION)
    //* 137  265:iload           12
    //* 138  267:getstatic       #707 <Field int VisualizeUtils.MAX_PRECISION>
    //* 139  270:icmple          276
            precisionXmin = 1;
    //  140  273:iconst_1        
    //  141  274:istore          12
        String minStringX = Utils.doubleToString(m_minX, nondecimal + 1 + precisionXmin, precisionXmin);
    //  142  276:aload_0         
    //  143  277:getfield        #363 <Field double m_minX>
    //  144  280:iload           17
    //  145  282:iconst_1        
    //  146  283:iadd            
    //  147  284:iload           12
    //  148  286:iadd            
    //  149  287:iload           12
    //  150  289:invokestatic    #713 <Method String Utils.doubleToString(double, int, int)>
    //  151  292:astore          19
        mswx = m_labelMetrics.stringWidth(maxStringX);
    //  152  294:aload_0         
    //  153  295:getfield        #168 <Field FontMetrics m_labelMetrics>
    //  154  298:aload           18
    //  155  300:invokevirtual   #627 <Method int FontMetrics.stringWidth(String)>
    //  156  303:istore          9
        int precisionYmax = 1;
    //  157  305:iconst_1        
    //  158  306:istore          20
        int precisionYmin = 1;
    //  159  308:iconst_1        
    //  160  309:istore          21
        int precisionYmid = 1;
    //  161  311:iconst_1        
    //  162  312:istore          22
        whole = (int)Math.abs(m_maxY);
    //  163  314:aload_0         
    //  164  315:getfield        #360 <Field double m_maxY>
    //  165  318:invokestatic    #699 <Method double Math.abs(double)>
    //  166  321:d2i             
    //  167  322:istore          14
        decimal = Math.abs(m_maxY) - (double)whole;
    //  168  324:aload_0         
    //  169  325:getfield        #360 <Field double m_maxY>
    //  170  328:invokestatic    #699 <Method double Math.abs(double)>
    //  171  331:iload           14
    //  172  333:i2d             
    //  173  334:dsub            
    //  174  335:dstore          15
        nondecimal = whole <= 0 ? 1 : (int)(Math.log(whole) / Math.log(10D));
    //  175  337:iload           14
    //  176  339:ifle            359
    //  177  342:iload           14
    //  178  344:i2d             
    //  179  345:invokestatic    #702 <Method double Math.log(double)>
    //  180  348:ldc2w           #703 <Double 10D>
    //  181  351:invokestatic    #702 <Method double Math.log(double)>
    //  182  354:ddiv            
    //  183  355:d2i             
    //  184  356:goto            360
    //  185  359:iconst_1        
    //  186  360:istore          17
        precisionYmax = decimal <= 0.0D ? 1 : (int)Math.abs(Math.log(Math.abs(m_maxY)) / Math.log(10D)) + 2;
    //  187  362:dload           15
    //  188  364:dconst_0        
    //  189  365:dcmpl           
    //  190  366:ifle            395
    //  191  369:aload_0         
    //  192  370:getfield        #360 <Field double m_maxY>
    //  193  373:invokestatic    #699 <Method double Math.abs(double)>
    //  194  376:invokestatic    #702 <Method double Math.log(double)>
    //  195  379:ldc2w           #703 <Double 10D>
    //  196  382:invokestatic    #702 <Method double Math.log(double)>
    //  197  385:ddiv            
    //  198  386:invokestatic    #699 <Method double Math.abs(double)>
    //  199  389:d2i             
    //  200  390:iconst_2        
    //  201  391:iadd            
    //  202  392:goto            396
    //  203  395:iconst_1        
    //  204  396:istore          20
        if(precisionYmax > VisualizeUtils.MAX_PRECISION)
    //* 205  398:iload           20
    //* 206  400:getstatic       #707 <Field int VisualizeUtils.MAX_PRECISION>
    //* 207  403:icmple          409
            precisionYmax = 1;
    //  208  406:iconst_1        
    //  209  407:istore          20
        String maxStringY = Utils.doubleToString(m_maxY, nondecimal + 1 + precisionYmax, precisionYmax);
    //  210  409:aload_0         
    //  211  410:getfield        #360 <Field double m_maxY>
    //  212  413:iload           17
    //  213  415:iconst_1        
    //  214  416:iadd            
    //  215  417:iload           20
    //  216  419:iadd            
    //  217  420:iload           20
    //  218  422:invokestatic    #713 <Method String Utils.doubleToString(double, int, int)>
    //  219  425:astore          23
        whole = (int)Math.abs(m_minY);
    //  220  427:aload_0         
    //  221  428:getfield        #366 <Field double m_minY>
    //  222  431:invokestatic    #699 <Method double Math.abs(double)>
    //  223  434:d2i             
    //  224  435:istore          14
        decimal = Math.abs(m_minY) - (double)whole;
    //  225  437:aload_0         
    //  226  438:getfield        #366 <Field double m_minY>
    //  227  441:invokestatic    #699 <Method double Math.abs(double)>
    //  228  444:iload           14
    //  229  446:i2d             
    //  230  447:dsub            
    //  231  448:dstore          15
        nondecimal = whole <= 0 ? 1 : (int)(Math.log(whole) / Math.log(10D));
    //  232  450:iload           14
    //  233  452:ifle            472
    //  234  455:iload           14
    //  235  457:i2d             
    //  236  458:invokestatic    #702 <Method double Math.log(double)>
    //  237  461:ldc2w           #703 <Double 10D>
    //  238  464:invokestatic    #702 <Method double Math.log(double)>
    //  239  467:ddiv            
    //  240  468:d2i             
    //  241  469:goto            473
    //  242  472:iconst_1        
    //  243  473:istore          17
        precisionYmin = decimal <= 0.0D ? 1 : (int)Math.abs(Math.log(Math.abs(m_minY)) / Math.log(10D)) + 2;
    //  244  475:dload           15
    //  245  477:dconst_0        
    //  246  478:dcmpl           
    //  247  479:ifle            508
    //  248  482:aload_0         
    //  249  483:getfield        #366 <Field double m_minY>
    //  250  486:invokestatic    #699 <Method double Math.abs(double)>
    //  251  489:invokestatic    #702 <Method double Math.log(double)>
    //  252  492:ldc2w           #703 <Double 10D>
    //  253  495:invokestatic    #702 <Method double Math.log(double)>
    //  254  498:ddiv            
    //  255  499:invokestatic    #699 <Method double Math.abs(double)>
    //  256  502:d2i             
    //  257  503:iconst_2        
    //  258  504:iadd            
    //  259  505:goto            509
    //  260  508:iconst_1        
    //  261  509:istore          21
        if(precisionYmin > VisualizeUtils.MAX_PRECISION)
    //* 262  511:iload           21
    //* 263  513:getstatic       #707 <Field int VisualizeUtils.MAX_PRECISION>
    //* 264  516:icmple          522
            precisionYmin = 1;
    //  265  519:iconst_1        
    //  266  520:istore          21
        String minStringY = Utils.doubleToString(m_minY, nondecimal + 1 + precisionYmin, precisionYmin);
    //  267  522:aload_0         
    //  268  523:getfield        #366 <Field double m_minY>
    //  269  526:iload           17
    //  270  528:iconst_1        
    //  271  529:iadd            
    //  272  530:iload           21
    //  273  532:iadd            
    //  274  533:iload           21
    //  275  535:invokestatic    #713 <Method String Utils.doubleToString(double, int, int)>
    //  276  538:astore          24
        if(m_plotInstances.attribute(m_yIndex).isNumeric())
    //* 277  540:aload_0         
    //* 278  541:getfield        #110 <Field Instances m_plotInstances>
    //* 279  544:aload_0         
    //* 280  545:getfield        #146 <Field int m_yIndex>
    //* 281  548:invokevirtual   #426 <Method Attribute Instances.attribute(int)>
    //* 282  551:invokevirtual   #716 <Method boolean Attribute.isNumeric()>
    //* 283  554:ifeq            619
        {
            mswy = m_labelMetrics.stringWidth(maxStringY) <= m_labelMetrics.stringWidth(minStringY) ? m_labelMetrics.stringWidth(minStringY) : m_labelMetrics.stringWidth(maxStringY);
    //  284  557:aload_0         
    //  285  558:getfield        #168 <Field FontMetrics m_labelMetrics>
    //  286  561:aload           23
    //  287  563:invokevirtual   #627 <Method int FontMetrics.stringWidth(String)>
    //  288  566:aload_0         
    //  289  567:getfield        #168 <Field FontMetrics m_labelMetrics>
    //  290  570:aload           24
    //  291  572:invokevirtual   #627 <Method int FontMetrics.stringWidth(String)>
    //  292  575:icmple          590
    //  293  578:aload_0         
    //  294  579:getfield        #168 <Field FontMetrics m_labelMetrics>
    //  295  582:aload           23
    //  296  584:invokevirtual   #627 <Method int FontMetrics.stringWidth(String)>
    //  297  587:goto            599
    //  298  590:aload_0         
    //  299  591:getfield        #168 <Field FontMetrics m_labelMetrics>
    //  300  594:aload           24
    //  301  596:invokevirtual   #627 <Method int FontMetrics.stringWidth(String)>
    //  302  599:istore          10
            mswy += m_labelMetrics.stringWidth("M");
    //  303  601:iload           10
    //  304  603:aload_0         
    //  305  604:getfield        #168 <Field FontMetrics m_labelMetrics>
    //  306  607:ldc2            #623 <String "M">
    //  307  610:invokevirtual   #627 <Method int FontMetrics.stringWidth(String)>
    //  308  613:iadd            
    //  309  614:istore          10
        } else
    //* 310  616:goto            631
        {
            mswy = m_labelMetrics.stringWidth("MM");
    //  311  619:aload_0         
    //  312  620:getfield        #168 <Field FontMetrics m_labelMetrics>
    //  313  623:ldc2            #718 <String "MM">
    //  314  626:invokevirtual   #627 <Method int FontMetrics.stringWidth(String)>
    //  315  629:istore          10
        }
        m_YaxisStart = 5;
    //  316  631:aload_0         
    //  317  632:iconst_5        
    //  318  633:putfield        #158 <Field int m_YaxisStart>
        m_XaxisStart = 10 + mswy;
    //  319  636:aload_0         
    //  320  637:bipush          10
    //  321  639:iload           10
    //  322  641:iadd            
    //  323  642:putfield        #156 <Field int m_XaxisStart>
        m_XaxisEnd = w - 5 - mswx / 2;
    //  324  645:aload_0         
    //  325  646:iload           7
    //  326  648:iconst_5        
    //  327  649:isub            
    //  328  650:iload           9
    //  329  652:iconst_2        
    //  330  653:idiv            
    //  331  654:isub            
    //  332  655:putfield        #160 <Field int m_XaxisEnd>
        m_YaxisEnd = h - 5 - 2 * hf - 5;
    //  333  658:aload_0         
    //  334  659:iload           6
    //  335  661:iconst_5        
    //  336  662:isub            
    //  337  663:iconst_2        
    //  338  664:iload           8
    //  339  666:imul            
    //  340  667:isub            
    //  341  668:iconst_5        
    //  342  669:isub            
    //  343  670:putfield        #162 <Field int m_YaxisEnd>
        gx.setColor(m_axisColour);
    //  344  673:aload_1         
    //  345  674:aload_0         
    //  346  675:getfield        #92  <Field Color m_axisColour>
    //  347  678:invokevirtual   #666 <Method void Graphics.setColor(Color)>
        if(m_plotInstances.attribute(m_xIndex).isNumeric())
    //* 348  681:aload_0         
    //* 349  682:getfield        #110 <Field Instances m_plotInstances>
    //* 350  685:aload_0         
    //* 351  686:getfield        #144 <Field int m_xIndex>
    //* 352  689:invokevirtual   #426 <Method Attribute Instances.attribute(int)>
    //* 353  692:invokevirtual   #716 <Method boolean Attribute.isNumeric()>
    //* 354  695:ifeq            999
        {
            if(w > 2 * mswx)
    //* 355  698:iload           7
    //* 356  700:iconst_2        
    //* 357  701:iload           9
    //* 358  703:imul            
    //* 359  704:icmple          1355
            {
                gx.drawString(maxStringX, m_XaxisEnd - mswx / 2, m_YaxisEnd + hf + 5);
    //  360  707:aload_1         
    //  361  708:aload           18
    //  362  710:aload_0         
    //  363  711:getfield        #160 <Field int m_XaxisEnd>
    //  364  714:iload           9
    //  365  716:iconst_2        
    //  366  717:idiv            
    //  367  718:isub            
    //  368  719:aload_0         
    //  369  720:getfield        #162 <Field int m_YaxisEnd>
    //  370  723:iload           8
    //  371  725:iadd            
    //  372  726:iconst_5        
    //  373  727:iadd            
    //  374  728:invokevirtual   #630 <Method void Graphics.drawString(String, int, int)>
                mswx = m_labelMetrics.stringWidth(minStringX);
    //  375  731:aload_0         
    //  376  732:getfield        #168 <Field FontMetrics m_labelMetrics>
    //  377  735:aload           19
    //  378  737:invokevirtual   #627 <Method int FontMetrics.stringWidth(String)>
    //  379  740:istore          9
                gx.drawString(minStringX, m_XaxisStart - mswx / 2, m_YaxisEnd + hf + 5);
    //  380  742:aload_1         
    //  381  743:aload           19
    //  382  745:aload_0         
    //  383  746:getfield        #156 <Field int m_XaxisStart>
    //  384  749:iload           9
    //  385  751:iconst_2        
    //  386  752:idiv            
    //  387  753:isub            
    //  388  754:aload_0         
    //  389  755:getfield        #162 <Field int m_YaxisEnd>
    //  390  758:iload           8
    //  391  760:iadd            
    //  392  761:iconst_5        
    //  393  762:iadd            
    //  394  763:invokevirtual   #630 <Method void Graphics.drawString(String, int, int)>
                if(w > 3 * mswx && m_plotInstances.attribute(m_xIndex).isNumeric())
    //* 395  766:iload           7
    //* 396  768:iconst_3        
    //* 397  769:iload           9
    //* 398  771:imul            
    //* 399  772:icmple          1355
    //* 400  775:aload_0         
    //* 401  776:getfield        #110 <Field Instances m_plotInstances>
    //* 402  779:aload_0         
    //* 403  780:getfield        #144 <Field int m_xIndex>
    //* 404  783:invokevirtual   #426 <Method Attribute Instances.attribute(int)>
    //* 405  786:invokevirtual   #716 <Method boolean Attribute.isNumeric()>
    //* 406  789:ifeq            1355
                {
                    double mid = m_minX + (m_maxX - m_minX) / 2D;
    //  407  792:aload_0         
    //  408  793:getfield        #363 <Field double m_minX>
    //  409  796:aload_0         
    //  410  797:getfield        #357 <Field double m_maxX>
    //  411  800:aload_0         
    //  412  801:getfield        #363 <Field double m_minX>
    //  413  804:dsub            
    //  414  805:ldc2w           #573 <Double 2D>
    //  415  808:ddiv            
    //  416  809:dadd            
    //  417  810:dstore          25
                    whole = (int)Math.abs(mid);
    //  418  812:dload           25
    //  419  814:invokestatic    #699 <Method double Math.abs(double)>
    //  420  817:d2i             
    //  421  818:istore          14
                    decimal = Math.abs(mid) - (double)whole;
    //  422  820:dload           25
    //  423  822:invokestatic    #699 <Method double Math.abs(double)>
    //  424  825:iload           14
    //  425  827:i2d             
    //  426  828:dsub            
    //  427  829:dstore          15
                    nondecimal = whole <= 0 ? 1 : (int)(Math.log(whole) / Math.log(10D));
    //  428  831:iload           14
    //  429  833:ifle            853
    //  430  836:iload           14
    //  431  838:i2d             
    //  432  839:invokestatic    #702 <Method double Math.log(double)>
    //  433  842:ldc2w           #703 <Double 10D>
    //  434  845:invokestatic    #702 <Method double Math.log(double)>
    //  435  848:ddiv            
    //  436  849:d2i             
    //  437  850:goto            854
    //  438  853:iconst_1        
    //  439  854:istore          17
                    precisionXmid = decimal <= 0.0D ? 1 : (int)Math.abs(Math.log(Math.abs(mid)) / Math.log(10D)) + 2;
    //  440  856:dload           15
    //  441  858:dconst_0        
    //  442  859:dcmpl           
    //  443  860:ifle            887
    //  444  863:dload           25
    //  445  865:invokestatic    #699 <Method double Math.abs(double)>
    //  446  868:invokestatic    #702 <Method double Math.log(double)>
    //  447  871:ldc2w           #703 <Double 10D>
    //  448  874:invokestatic    #702 <Method double Math.log(double)>
    //  449  877:ddiv            
    //  450  878:invokestatic    #699 <Method double Math.abs(double)>
    //  451  881:d2i             
    //  452  882:iconst_2        
    //  453  883:iadd            
    //  454  884:goto            888
    //  455  887:iconst_1        
    //  456  888:istore          13
                    if(precisionXmid > VisualizeUtils.MAX_PRECISION)
    //* 457  890:iload           13
    //* 458  892:getstatic       #707 <Field int VisualizeUtils.MAX_PRECISION>
    //* 459  895:icmple          901
                        precisionXmid = 1;
    //  460  898:iconst_1        
    //  461  899:istore          13
                    String maxString = Utils.doubleToString(mid, nondecimal + 1 + precisionXmid, precisionXmid);
    //  462  901:dload           25
    //  463  903:iload           17
    //  464  905:iconst_1        
    //  465  906:iadd            
    //  466  907:iload           13
    //  467  909:iadd            
    //  468  910:iload           13
    //  469  912:invokestatic    #713 <Method String Utils.doubleToString(double, int, int)>
    //  470  915:astore          27
                    int sw = m_labelMetrics.stringWidth(maxString);
    //  471  917:aload_0         
    //  472  918:getfield        #168 <Field FontMetrics m_labelMetrics>
    //  473  921:aload           27
    //  474  923:invokevirtual   #627 <Method int FontMetrics.stringWidth(String)>
    //  475  926:istore          28
                    double mx = (double)m_XaxisStart + (double)(m_XaxisEnd - m_XaxisStart) / 2D;
    //  476  928:aload_0         
    //  477  929:getfield        #156 <Field int m_XaxisStart>
    //  478  932:i2d             
    //  479  933:aload_0         
    //  480  934:getfield        #160 <Field int m_XaxisEnd>
    //  481  937:aload_0         
    //  482  938:getfield        #156 <Field int m_XaxisStart>
    //  483  941:isub            
    //  484  942:i2d             
    //  485  943:ldc2w           #573 <Double 2D>
    //  486  946:ddiv            
    //  487  947:dadd            
    //  488  948:dstore          29
                    gx.drawString(maxString, (int)(mx - (double)sw / 2D), m_YaxisEnd + hf + 5);
    //  489  950:aload_1         
    //  490  951:aload           27
    //  491  953:dload           29
    //  492  955:iload           28
    //  493  957:i2d             
    //  494  958:ldc2w           #573 <Double 2D>
    //  495  961:ddiv            
    //  496  962:dsub            
    //  497  963:d2i             
    //  498  964:aload_0         
    //  499  965:getfield        #162 <Field int m_YaxisEnd>
    //  500  968:iload           8
    //  501  970:iadd            
    //  502  971:iconst_5        
    //  503  972:iadd            
    //  504  973:invokevirtual   #630 <Method void Graphics.drawString(String, int, int)>
                    gx.drawLine((int)mx, m_YaxisEnd, (int)mx, m_YaxisEnd + 5);
    //  505  976:aload_1         
    //  506  977:dload           29
    //  507  979:d2i             
    //  508  980:aload_0         
    //  509  981:getfield        #162 <Field int m_YaxisEnd>
    //  510  984:dload           29
    //  511  986:d2i             
    //  512  987:aload_0         
    //  513  988:getfield        #162 <Field int m_YaxisEnd>
    //  514  991:iconst_5        
    //  515  992:iadd            
    //  516  993:invokevirtual   #591 <Method void Graphics.drawLine(int, int, int, int)>
                }
            }
        } else
    //* 517  996:goto            1355
        {
            int numValues = m_plotInstances.attribute(m_xIndex).numValues();
    //  518  999:aload_0         
    //  519 1000:getfield        #110 <Field Instances m_plotInstances>
    //  520 1003:aload_0         
    //  521 1004:getfield        #144 <Field int m_xIndex>
    //  522 1007:invokevirtual   #426 <Method Attribute Instances.attribute(int)>
    //  523 1010:invokevirtual   #654 <Method int Attribute.numValues()>
    //  524 1013:istore          25
            int div = numValues % 2 <= 0 ? numValues / 2 : numValues / 2 + 1;
    //  525 1015:iload           25
    //  526 1017:iconst_2        
    //  527 1018:irem            
    //  528 1019:ifle            1031
    //  529 1022:iload           25
    //  530 1024:iconst_2        
    //  531 1025:idiv            
    //  532 1026:iconst_1        
    //  533 1027:iadd            
    //  534 1028:goto            1035
    //  535 1031:iload           25
    //  536 1033:iconst_2        
    //  537 1034:idiv            
    //  538 1035:istore          26
            int maxXStringWidth = (m_XaxisEnd - m_XaxisStart) / numValues;
    //  539 1037:aload_0         
    //  540 1038:getfield        #160 <Field int m_XaxisEnd>
    //  541 1041:aload_0         
    //  542 1042:getfield        #156 <Field int m_XaxisStart>
    //  543 1045:isub            
    //  544 1046:iload           25
    //  545 1048:idiv            
    //  546 1049:istore          27
            for(int i = 0; i < numValues; i++)
    //* 547 1051:iconst_0        
    //* 548 1052:istore          28
    //* 549 1054:goto            1348
            {
                String val = m_plotInstances.attribute(m_xIndex).value(i);
    //  550 1057:aload_0         
    //  551 1058:getfield        #110 <Field Instances m_plotInstances>
    //  552 1061:aload_0         
    //  553 1062:getfield        #144 <Field int m_xIndex>
    //  554 1065:invokevirtual   #426 <Method Attribute Instances.attribute(int)>
    //  555 1068:iload           28
    //  556 1070:invokevirtual   #486 <Method String Attribute.value(int)>
    //  557 1073:astore          29
                int sw = m_labelMetrics.stringWidth(val);
    //  558 1075:aload_0         
    //  559 1076:getfield        #168 <Field FontMetrics m_labelMetrics>
    //  560 1079:aload           29
    //  561 1081:invokevirtual   #627 <Method int FontMetrics.stringWidth(String)>
    //  562 1084:istore          30
                if(sw > maxXStringWidth)
    //* 563 1086:iload           30
    //* 564 1088:iload           27
    //* 565 1090:icmple          1148
                {
                    int incr = sw / val.length();
    //  566 1093:iload           30
    //  567 1095:aload           29
    //  568 1097:invokevirtual   #434 <Method int String.length()>
    //  569 1100:idiv            
    //  570 1101:istore          32
                    int rm = (sw - maxXStringWidth) / incr;
    //  571 1103:iload           30
    //  572 1105:iload           27
    //  573 1107:isub            
    //  574 1108:iload           32
    //  575 1110:idiv            
    //  576 1111:istore          31
                    if(rm == 0)
    //* 577 1113:iload           31
    //* 578 1115:ifne            1121
                        rm = 1;
    //  579 1118:iconst_1        
    //  580 1119:istore          31
                    val = val.substring(0, val.length() - rm);
    //  581 1121:aload           29
    //  582 1123:iconst_0        
    //  583 1124:aload           29
    //  584 1126:invokevirtual   #434 <Method int String.length()>
    //  585 1129:iload           31
    //  586 1131:isub            
    //  587 1132:invokevirtual   #722 <Method String String.substring(int, int)>
    //  588 1135:astore          29
                    sw = m_labelMetrics.stringWidth(val);
    //  589 1137:aload_0         
    //  590 1138:getfield        #168 <Field FontMetrics m_labelMetrics>
    //  591 1141:aload           29
    //  592 1143:invokevirtual   #627 <Method int FontMetrics.stringWidth(String)>
    //  593 1146:istore          30
                }
                if(i == 0)
    //* 594 1148:iload           28
    //* 595 1150:ifne            1179
                    gx.drawString(val, (int)convertToPanelX(i), m_YaxisEnd + hf + 5);
    //  596 1153:aload_1         
    //  597 1154:aload           29
    //  598 1156:aload_0         
    //  599 1157:iload           28
    //  600 1159:i2d             
    //  601 1160:invokevirtual   #642 <Method double convertToPanelX(double)>
    //  602 1163:d2i             
    //  603 1164:aload_0         
    //  604 1165:getfield        #162 <Field int m_YaxisEnd>
    //  605 1168:iload           8
    //  606 1170:iadd            
    //  607 1171:iconst_5        
    //  608 1172:iadd            
    //  609 1173:invokevirtual   #630 <Method void Graphics.drawString(String, int, int)>
                else
    //* 610 1176:goto            1315
                if(i == numValues - 1)
    //* 611 1179:iload           28
    //* 612 1181:iload           25
    //* 613 1183:iconst_1        
    //* 614 1184:isub            
    //* 615 1185:icmpne          1247
                {
                    if(i % 2 == 0)
    //* 616 1188:iload           28
    //* 617 1190:iconst_2        
    //* 618 1191:irem            
    //* 619 1192:ifne            1220
                        gx.drawString(val, m_XaxisEnd - sw, m_YaxisEnd + hf + 5);
    //  620 1195:aload_1         
    //  621 1196:aload           29
    //  622 1198:aload_0         
    //  623 1199:getfield        #160 <Field int m_XaxisEnd>
    //  624 1202:iload           30
    //  625 1204:isub            
    //  626 1205:aload_0         
    //  627 1206:getfield        #162 <Field int m_YaxisEnd>
    //  628 1209:iload           8
    //  629 1211:iadd            
    //  630 1212:iconst_5        
    //  631 1213:iadd            
    //  632 1214:invokevirtual   #630 <Method void Graphics.drawString(String, int, int)>
                    else
    //* 633 1217:goto            1315
                        gx.drawString(val, m_XaxisEnd - sw, m_YaxisEnd + 2 * hf + 5);
    //  634 1220:aload_1         
    //  635 1221:aload           29
    //  636 1223:aload_0         
    //  637 1224:getfield        #160 <Field int m_XaxisEnd>
    //  638 1227:iload           30
    //  639 1229:isub            
    //  640 1230:aload_0         
    //  641 1231:getfield        #162 <Field int m_YaxisEnd>
    //  642 1234:iconst_2        
    //  643 1235:iload           8
    //  644 1237:imul            
    //  645 1238:iadd            
    //  646 1239:iconst_5        
    //  647 1240:iadd            
    //  648 1241:invokevirtual   #630 <Method void Graphics.drawString(String, int, int)>
                } else
    //* 649 1244:goto            1315
                if(i % 2 == 0)
    //* 650 1247:iload           28
    //* 651 1249:iconst_2        
    //* 652 1250:irem            
    //* 653 1251:ifne            1285
                    gx.drawString(val, (int)convertToPanelX(i) - sw / 2, m_YaxisEnd + hf + 5);
    //  654 1254:aload_1         
    //  655 1255:aload           29
    //  656 1257:aload_0         
    //  657 1258:iload           28
    //  658 1260:i2d             
    //  659 1261:invokevirtual   #642 <Method double convertToPanelX(double)>
    //  660 1264:d2i             
    //  661 1265:iload           30
    //  662 1267:iconst_2        
    //  663 1268:idiv            
    //  664 1269:isub            
    //  665 1270:aload_0         
    //  666 1271:getfield        #162 <Field int m_YaxisEnd>
    //  667 1274:iload           8
    //  668 1276:iadd            
    //  669 1277:iconst_5        
    //  670 1278:iadd            
    //  671 1279:invokevirtual   #630 <Method void Graphics.drawString(String, int, int)>
                else
    //* 672 1282:goto            1315
                    gx.drawString(val, (int)convertToPanelX(i) - sw / 2, m_YaxisEnd + 2 * hf + 5);
    //  673 1285:aload_1         
    //  674 1286:aload           29
    //  675 1288:aload_0         
    //  676 1289:iload           28
    //  677 1291:i2d             
    //  678 1292:invokevirtual   #642 <Method double convertToPanelX(double)>
    //  679 1295:d2i             
    //  680 1296:iload           30
    //  681 1298:iconst_2        
    //  682 1299:idiv            
    //  683 1300:isub            
    //  684 1301:aload_0         
    //  685 1302:getfield        #162 <Field int m_YaxisEnd>
    //  686 1305:iconst_2        
    //  687 1306:iload           8
    //  688 1308:imul            
    //  689 1309:iadd            
    //  690 1310:iconst_5        
    //  691 1311:iadd            
    //  692 1312:invokevirtual   #630 <Method void Graphics.drawString(String, int, int)>
                gx.drawLine((int)convertToPanelX(i), m_YaxisEnd, (int)convertToPanelX(i), m_YaxisEnd + 5);
    //  693 1315:aload_1         
    //  694 1316:aload_0         
    //  695 1317:iload           28
    //  696 1319:i2d             
    //  697 1320:invokevirtual   #642 <Method double convertToPanelX(double)>
    //  698 1323:d2i             
    //  699 1324:aload_0         
    //  700 1325:getfield        #162 <Field int m_YaxisEnd>
    //  701 1328:aload_0         
    //  702 1329:iload           28
    //  703 1331:i2d             
    //  704 1332:invokevirtual   #642 <Method double convertToPanelX(double)>
    //  705 1335:d2i             
    //  706 1336:aload_0         
    //  707 1337:getfield        #162 <Field int m_YaxisEnd>
    //  708 1340:iconst_5        
    //  709 1341:iadd            
    //  710 1342:invokevirtual   #591 <Method void Graphics.drawLine(int, int, int, int)>
            }

    //  711 1345:iinc            28  1
    //  712 1348:iload           28
    //  713 1350:iload           25
    //  714 1352:icmplt          1057
        }
        if(m_plotInstances.attribute(m_yIndex).isNumeric())
    //* 715 1355:aload_0         
    //* 716 1356:getfield        #110 <Field Instances m_plotInstances>
    //* 717 1359:aload_0         
    //* 718 1360:getfield        #146 <Field int m_yIndex>
    //* 719 1363:invokevirtual   #426 <Method Attribute Instances.attribute(int)>
    //* 720 1366:invokevirtual   #716 <Method boolean Attribute.isNumeric()>
    //* 721 1369:ifeq            1657
        {
            if(h > 2 * hf)
    //* 722 1372:iload           6
    //* 723 1374:iconst_2        
    //* 724 1375:iload           8
    //* 725 1377:imul            
    //* 726 1378:icmple          2132
            {
                gx.drawString(maxStringY, m_XaxisStart - mswy - 5, m_YaxisStart + hf);
    //  727 1381:aload_1         
    //  728 1382:aload           23
    //  729 1384:aload_0         
    //  730 1385:getfield        #156 <Field int m_XaxisStart>
    //  731 1388:iload           10
    //  732 1390:isub            
    //  733 1391:iconst_5        
    //  734 1392:isub            
    //  735 1393:aload_0         
    //  736 1394:getfield        #158 <Field int m_YaxisStart>
    //  737 1397:iload           8
    //  738 1399:iadd            
    //  739 1400:invokevirtual   #630 <Method void Graphics.drawString(String, int, int)>
                gx.drawString(minStringY, m_XaxisStart - mswy - 5, m_YaxisEnd);
    //  740 1403:aload_1         
    //  741 1404:aload           24
    //  742 1406:aload_0         
    //  743 1407:getfield        #156 <Field int m_XaxisStart>
    //  744 1410:iload           10
    //  745 1412:isub            
    //  746 1413:iconst_5        
    //  747 1414:isub            
    //  748 1415:aload_0         
    //  749 1416:getfield        #162 <Field int m_YaxisEnd>
    //  750 1419:invokevirtual   #630 <Method void Graphics.drawString(String, int, int)>
                if(w > 3 * hf && m_plotInstances.attribute(m_yIndex).isNumeric())
    //* 751 1422:iload           7
    //* 752 1424:iconst_3        
    //* 753 1425:iload           8
    //* 754 1427:imul            
    //* 755 1428:icmple          2132
    //* 756 1431:aload_0         
    //* 757 1432:getfield        #110 <Field Instances m_plotInstances>
    //* 758 1435:aload_0         
    //* 759 1436:getfield        #146 <Field int m_yIndex>
    //* 760 1439:invokevirtual   #426 <Method Attribute Instances.attribute(int)>
    //* 761 1442:invokevirtual   #716 <Method boolean Attribute.isNumeric()>
    //* 762 1445:ifeq            2132
                {
                    double mid = m_minY + (m_maxY - m_minY) / 2D;
    //  763 1448:aload_0         
    //  764 1449:getfield        #366 <Field double m_minY>
    //  765 1452:aload_0         
    //  766 1453:getfield        #360 <Field double m_maxY>
    //  767 1456:aload_0         
    //  768 1457:getfield        #366 <Field double m_minY>
    //  769 1460:dsub            
    //  770 1461:ldc2w           #573 <Double 2D>
    //  771 1464:ddiv            
    //  772 1465:dadd            
    //  773 1466:dstore          25
                    whole = (int)Math.abs(mid);
    //  774 1468:dload           25
    //  775 1470:invokestatic    #699 <Method double Math.abs(double)>
    //  776 1473:d2i             
    //  777 1474:istore          14
                    decimal = Math.abs(mid) - (double)whole;
    //  778 1476:dload           25
    //  779 1478:invokestatic    #699 <Method double Math.abs(double)>
    //  780 1481:iload           14
    //  781 1483:i2d             
    //  782 1484:dsub            
    //  783 1485:dstore          15
                    nondecimal = whole <= 0 ? 1 : (int)(Math.log(whole) / Math.log(10D));
    //  784 1487:iload           14
    //  785 1489:ifle            1509
    //  786 1492:iload           14
    //  787 1494:i2d             
    //  788 1495:invokestatic    #702 <Method double Math.log(double)>
    //  789 1498:ldc2w           #703 <Double 10D>
    //  790 1501:invokestatic    #702 <Method double Math.log(double)>
    //  791 1504:ddiv            
    //  792 1505:d2i             
    //  793 1506:goto            1510
    //  794 1509:iconst_1        
    //  795 1510:istore          17
                    precisionYmid = decimal <= 0.0D ? 1 : (int)Math.abs(Math.log(Math.abs(mid)) / Math.log(10D)) + 2;
    //  796 1512:dload           15
    //  797 1514:dconst_0        
    //  798 1515:dcmpl           
    //  799 1516:ifle            1543
    //  800 1519:dload           25
    //  801 1521:invokestatic    #699 <Method double Math.abs(double)>
    //  802 1524:invokestatic    #702 <Method double Math.log(double)>
    //  803 1527:ldc2w           #703 <Double 10D>
    //  804 1530:invokestatic    #702 <Method double Math.log(double)>
    //  805 1533:ddiv            
    //  806 1534:invokestatic    #699 <Method double Math.abs(double)>
    //  807 1537:d2i             
    //  808 1538:iconst_2        
    //  809 1539:iadd            
    //  810 1540:goto            1544
    //  811 1543:iconst_1        
    //  812 1544:istore          22
                    if(precisionYmid > VisualizeUtils.MAX_PRECISION)
    //* 813 1546:iload           22
    //* 814 1548:getstatic       #707 <Field int VisualizeUtils.MAX_PRECISION>
    //* 815 1551:icmple          1557
                        precisionYmid = 1;
    //  816 1554:iconst_1        
    //  817 1555:istore          22
                    String maxString = Utils.doubleToString(mid, nondecimal + 1 + precisionYmid, precisionYmid);
    //  818 1557:dload           25
    //  819 1559:iload           17
    //  820 1561:iconst_1        
    //  821 1562:iadd            
    //  822 1563:iload           22
    //  823 1565:iadd            
    //  824 1566:iload           22
    //  825 1568:invokestatic    #713 <Method String Utils.doubleToString(double, int, int)>
    //  826 1571:astore          27
                    int sw = m_labelMetrics.stringWidth(maxString);
    //  827 1573:aload_0         
    //  828 1574:getfield        #168 <Field FontMetrics m_labelMetrics>
    //  829 1577:aload           27
    //  830 1579:invokevirtual   #627 <Method int FontMetrics.stringWidth(String)>
    //  831 1582:istore          28
                    double mx = (double)m_YaxisStart + (double)(m_YaxisEnd - m_YaxisStart) / 2D;
    //  832 1584:aload_0         
    //  833 1585:getfield        #158 <Field int m_YaxisStart>
    //  834 1588:i2d             
    //  835 1589:aload_0         
    //  836 1590:getfield        #162 <Field int m_YaxisEnd>
    //  837 1593:aload_0         
    //  838 1594:getfield        #158 <Field int m_YaxisStart>
    //  839 1597:isub            
    //  840 1598:i2d             
    //  841 1599:ldc2w           #573 <Double 2D>
    //  842 1602:ddiv            
    //  843 1603:dadd            
    //  844 1604:dstore          29
                    gx.drawString(maxString, m_XaxisStart - sw - 5 - 1, (int)(mx + (double)hf / 2D));
    //  845 1606:aload_1         
    //  846 1607:aload           27
    //  847 1609:aload_0         
    //  848 1610:getfield        #156 <Field int m_XaxisStart>
    //  849 1613:iload           28
    //  850 1615:isub            
    //  851 1616:iconst_5        
    //  852 1617:isub            
    //  853 1618:iconst_1        
    //  854 1619:isub            
    //  855 1620:dload           29
    //  856 1622:iload           8
    //  857 1624:i2d             
    //  858 1625:ldc2w           #573 <Double 2D>
    //  859 1628:ddiv            
    //  860 1629:dadd            
    //  861 1630:d2i             
    //  862 1631:invokevirtual   #630 <Method void Graphics.drawString(String, int, int)>
                    gx.drawLine(m_XaxisStart - 5, (int)mx, m_XaxisStart, (int)mx);
    //  863 1634:aload_1         
    //  864 1635:aload_0         
    //  865 1636:getfield        #156 <Field int m_XaxisStart>
    //  866 1639:iconst_5        
    //  867 1640:isub            
    //  868 1641:dload           29
    //  869 1643:d2i             
    //  870 1644:aload_0         
    //  871 1645:getfield        #156 <Field int m_XaxisStart>
    //  872 1648:dload           29
    //  873 1650:d2i             
    //  874 1651:invokevirtual   #591 <Method void Graphics.drawLine(int, int, int, int)>
                }
            }
        } else
    //* 875 1654:goto            2132
        {
            int numValues = m_plotInstances.attribute(m_yIndex).numValues();
    //  876 1657:aload_0         
    //  877 1658:getfield        #110 <Field Instances m_plotInstances>
    //  878 1661:aload_0         
    //  879 1662:getfield        #146 <Field int m_yIndex>
    //  880 1665:invokevirtual   #426 <Method Attribute Instances.attribute(int)>
    //  881 1668:invokevirtual   #654 <Method int Attribute.numValues()>
    //  882 1671:istore          25
            int div = numValues % 2 != 0 ? numValues / 2 + 1 : numValues / 2;
    //  883 1673:iload           25
    //  884 1675:iconst_2        
    //  885 1676:irem            
    //  886 1677:ifne            1687
    //  887 1680:iload           25
    //  888 1682:iconst_2        
    //  889 1683:idiv            
    //  890 1684:goto            1693
    //  891 1687:iload           25
    //  892 1689:iconst_2        
    //  893 1690:idiv            
    //  894 1691:iconst_1        
    //  895 1692:iadd            
    //  896 1693:istore          26
            int maxYStringHeight = (m_YaxisEnd - m_XaxisStart) / div;
    //  897 1695:aload_0         
    //  898 1696:getfield        #162 <Field int m_YaxisEnd>
    //  899 1699:aload_0         
    //  900 1700:getfield        #156 <Field int m_XaxisStart>
    //  901 1703:isub            
    //  902 1704:iload           26
    //  903 1706:idiv            
    //  904 1707:istore          27
            int sw = m_labelMetrics.stringWidth("M");
    //  905 1709:aload_0         
    //  906 1710:getfield        #168 <Field FontMetrics m_labelMetrics>
    //  907 1713:ldc2            #623 <String "M">
    //  908 1716:invokevirtual   #627 <Method int FontMetrics.stringWidth(String)>
    //  909 1719:istore          28
            for(int i = 0; i < numValues; i++)
    //* 910 1721:iconst_0        
    //* 911 1722:istore          29
    //* 912 1724:goto            2125
            {
                if(maxYStringHeight >= 2 * hf)
    //* 913 1727:iload           27
    //* 914 1729:iconst_2        
    //* 915 1730:iload           8
    //* 916 1732:imul            
    //* 917 1733:icmplt          2092
                {
                    String val = m_plotInstances.attribute(m_yIndex).value(i);
    //  918 1736:aload_0         
    //  919 1737:getfield        #110 <Field Instances m_plotInstances>
    //  920 1740:aload_0         
    //  921 1741:getfield        #146 <Field int m_yIndex>
    //  922 1744:invokevirtual   #426 <Method Attribute Instances.attribute(int)>
    //  923 1747:iload           29
    //  924 1749:invokevirtual   #486 <Method String Attribute.value(int)>
    //  925 1752:astore          30
                    int numPrint = maxYStringHeight / hf <= val.length() ? maxYStringHeight / hf : val.length();
    //  926 1754:iload           27
    //  927 1756:iload           8
    //  928 1758:idiv            
    //  929 1759:aload           30
    //  930 1761:invokevirtual   #434 <Method int String.length()>
    //  931 1764:icmple          1775
    //  932 1767:aload           30
    //  933 1769:invokevirtual   #434 <Method int String.length()>
    //  934 1772:goto            1780
    //  935 1775:iload           27
    //  936 1777:iload           8
    //  937 1779:idiv            
    //  938 1780:istore          31
                    for(int j = 0; j < numPrint; j++)
    //* 939 1782:iconst_0        
    //* 940 1783:istore          32
    //* 941 1785:goto            2085
                    {
                        String ll = val.substring(j, j + 1);
    //  942 1788:aload           30
    //  943 1790:iload           32
    //  944 1792:iload           32
    //  945 1794:iconst_1        
    //  946 1795:iadd            
    //  947 1796:invokevirtual   #722 <Method String String.substring(int, int)>
    //  948 1799:astore          33
                        if(val.charAt(j) == '_' || val.charAt(j) == '-')
    //* 949 1801:aload           30
    //* 950 1803:iload           32
    //* 951 1805:invokevirtual   #726 <Method char String.charAt(int)>
    //* 952 1808:bipush          95
    //* 953 1810:icmpeq          1825
    //* 954 1813:aload           30
    //* 955 1815:iload           32
    //* 956 1817:invokevirtual   #726 <Method char String.charAt(int)>
    //* 957 1820:bipush          45
    //* 958 1822:icmpne          1830
                            ll = "|";
    //  959 1825:ldc2            #728 <String "|">
    //  960 1828:astore          33
                        if(i == 0)
    //* 961 1830:iload           29
    //* 962 1832:ifne            1882
                            gx.drawString(ll, m_XaxisStart - sw - 5 - 1, ((int)convertToPanelY(i) - (numPrint - 1) * hf) + j * hf + hf / 2);
    //  963 1835:aload_1         
    //  964 1836:aload           33
    //  965 1838:aload_0         
    //  966 1839:getfield        #156 <Field int m_XaxisStart>
    //  967 1842:iload           28
    //  968 1844:isub            
    //  969 1845:iconst_5        
    //  970 1846:isub            
    //  971 1847:iconst_1        
    //  972 1848:isub            
    //  973 1849:aload_0         
    //  974 1850:iload           29
    //  975 1852:i2d             
    //  976 1853:invokevirtual   #644 <Method double convertToPanelY(double)>
    //  977 1856:d2i             
    //  978 1857:iload           31
    //  979 1859:iconst_1        
    //  980 1860:isub            
    //  981 1861:iload           8
    //  982 1863:imul            
    //  983 1864:isub            
    //  984 1865:iload           32
    //  985 1867:iload           8
    //  986 1869:imul            
    //  987 1870:iadd            
    //  988 1871:iload           8
    //  989 1873:iconst_2        
    //  990 1874:idiv            
    //  991 1875:iadd            
    //  992 1876:invokevirtual   #630 <Method void Graphics.drawString(String, int, int)>
                        else
    //* 993 1879:goto            2082
                        if(i == numValues - 1)
    //* 994 1882:iload           29
    //* 995 1884:iload           25
    //* 996 1886:iconst_1        
    //* 997 1887:isub            
    //* 998 1888:icmpne          1978
                        {
                            if(i % 2 == 0)
    //* 999 1891:iload           29
    //*1000 1893:iconst_2        
    //*1001 1894:irem            
    //*1002 1895:ifne            1937
                                gx.drawString(ll, m_XaxisStart - sw - 5 - 1, (int)convertToPanelY(i) + j * hf + hf / 2);
    // 1003 1898:aload_1         
    // 1004 1899:aload           33
    // 1005 1901:aload_0         
    // 1006 1902:getfield        #156 <Field int m_XaxisStart>
    // 1007 1905:iload           28
    // 1008 1907:isub            
    // 1009 1908:iconst_5        
    // 1010 1909:isub            
    // 1011 1910:iconst_1        
    // 1012 1911:isub            
    // 1013 1912:aload_0         
    // 1014 1913:iload           29
    // 1015 1915:i2d             
    // 1016 1916:invokevirtual   #644 <Method double convertToPanelY(double)>
    // 1017 1919:d2i             
    // 1018 1920:iload           32
    // 1019 1922:iload           8
    // 1020 1924:imul            
    // 1021 1925:iadd            
    // 1022 1926:iload           8
    // 1023 1928:iconst_2        
    // 1024 1929:idiv            
    // 1025 1930:iadd            
    // 1026 1931:invokevirtual   #630 <Method void Graphics.drawString(String, int, int)>
                            else
    //*1027 1934:goto            2082
                                gx.drawString(ll, m_XaxisStart - 2 * sw - 5 - 1, (int)convertToPanelY(i) + j * hf + hf / 2);
    // 1028 1937:aload_1         
    // 1029 1938:aload           33
    // 1030 1940:aload_0         
    // 1031 1941:getfield        #156 <Field int m_XaxisStart>
    // 1032 1944:iconst_2        
    // 1033 1945:iload           28
    // 1034 1947:imul            
    // 1035 1948:isub            
    // 1036 1949:iconst_5        
    // 1037 1950:isub            
    // 1038 1951:iconst_1        
    // 1039 1952:isub            
    // 1040 1953:aload_0         
    // 1041 1954:iload           29
    // 1042 1956:i2d             
    // 1043 1957:invokevirtual   #644 <Method double convertToPanelY(double)>
    // 1044 1960:d2i             
    // 1045 1961:iload           32
    // 1046 1963:iload           8
    // 1047 1965:imul            
    // 1048 1966:iadd            
    // 1049 1967:iload           8
    // 1050 1969:iconst_2        
    // 1051 1970:idiv            
    // 1052 1971:iadd            
    // 1053 1972:invokevirtual   #630 <Method void Graphics.drawString(String, int, int)>
                        } else
    //*1054 1975:goto            2082
                        if(i % 2 == 0)
    //*1055 1978:iload           29
    //*1056 1980:iconst_2        
    //*1057 1981:irem            
    //*1058 1982:ifne            2034
                            gx.drawString(ll, m_XaxisStart - sw - 5 - 1, ((int)convertToPanelY(i) - ((numPrint - 1) * hf) / 2) + j * hf + hf / 2);
    // 1059 1985:aload_1         
    // 1060 1986:aload           33
    // 1061 1988:aload_0         
    // 1062 1989:getfield        #156 <Field int m_XaxisStart>
    // 1063 1992:iload           28
    // 1064 1994:isub            
    // 1065 1995:iconst_5        
    // 1066 1996:isub            
    // 1067 1997:iconst_1        
    // 1068 1998:isub            
    // 1069 1999:aload_0         
    // 1070 2000:iload           29
    // 1071 2002:i2d             
    // 1072 2003:invokevirtual   #644 <Method double convertToPanelY(double)>
    // 1073 2006:d2i             
    // 1074 2007:iload           31
    // 1075 2009:iconst_1        
    // 1076 2010:isub            
    // 1077 2011:iload           8
    // 1078 2013:imul            
    // 1079 2014:iconst_2        
    // 1080 2015:idiv            
    // 1081 2016:isub            
    // 1082 2017:iload           32
    // 1083 2019:iload           8
    // 1084 2021:imul            
    // 1085 2022:iadd            
    // 1086 2023:iload           8
    // 1087 2025:iconst_2        
    // 1088 2026:idiv            
    // 1089 2027:iadd            
    // 1090 2028:invokevirtual   #630 <Method void Graphics.drawString(String, int, int)>
                        else
    //*1091 2031:goto            2082
                            gx.drawString(ll, m_XaxisStart - 2 * sw - 5 - 1, ((int)convertToPanelY(i) - ((numPrint - 1) * hf) / 2) + j * hf + hf / 2);
    // 1092 2034:aload_1         
    // 1093 2035:aload           33
    // 1094 2037:aload_0         
    // 1095 2038:getfield        #156 <Field int m_XaxisStart>
    // 1096 2041:iconst_2        
    // 1097 2042:iload           28
    // 1098 2044:imul            
    // 1099 2045:isub            
    // 1100 2046:iconst_5        
    // 1101 2047:isub            
    // 1102 2048:iconst_1        
    // 1103 2049:isub            
    // 1104 2050:aload_0         
    // 1105 2051:iload           29
    // 1106 2053:i2d             
    // 1107 2054:invokevirtual   #644 <Method double convertToPanelY(double)>
    // 1108 2057:d2i             
    // 1109 2058:iload           31
    // 1110 2060:iconst_1        
    // 1111 2061:isub            
    // 1112 2062:iload           8
    // 1113 2064:imul            
    // 1114 2065:iconst_2        
    // 1115 2066:idiv            
    // 1116 2067:isub            
    // 1117 2068:iload           32
    // 1118 2070:iload           8
    // 1119 2072:imul            
    // 1120 2073:iadd            
    // 1121 2074:iload           8
    // 1122 2076:iconst_2        
    // 1123 2077:idiv            
    // 1124 2078:iadd            
    // 1125 2079:invokevirtual   #630 <Method void Graphics.drawString(String, int, int)>
                    }

    // 1126 2082:iinc            32  1
    // 1127 2085:iload           32
    // 1128 2087:iload           31
    // 1129 2089:icmplt          1788
                }
                gx.drawLine(m_XaxisStart - 5, (int)convertToPanelY(i), m_XaxisStart, (int)convertToPanelY(i));
    // 1130 2092:aload_1         
    // 1131 2093:aload_0         
    // 1132 2094:getfield        #156 <Field int m_XaxisStart>
    // 1133 2097:iconst_5        
    // 1134 2098:isub            
    // 1135 2099:aload_0         
    // 1136 2100:iload           29
    // 1137 2102:i2d             
    // 1138 2103:invokevirtual   #644 <Method double convertToPanelY(double)>
    // 1139 2106:d2i             
    // 1140 2107:aload_0         
    // 1141 2108:getfield        #156 <Field int m_XaxisStart>
    // 1142 2111:aload_0         
    // 1143 2112:iload           29
    // 1144 2114:i2d             
    // 1145 2115:invokevirtual   #644 <Method double convertToPanelY(double)>
    // 1146 2118:d2i             
    // 1147 2119:invokevirtual   #591 <Method void Graphics.drawLine(int, int, int, int)>
            }

    // 1148 2122:iinc            29  1
    // 1149 2125:iload           29
    // 1150 2127:iload           25
    // 1151 2129:icmplt          1727
        }
        gx.drawLine(m_XaxisStart, m_YaxisStart, m_XaxisStart, m_YaxisEnd);
    // 1152 2132:aload_1         
    // 1153 2133:aload_0         
    // 1154 2134:getfield        #156 <Field int m_XaxisStart>
    // 1155 2137:aload_0         
    // 1156 2138:getfield        #158 <Field int m_YaxisStart>
    // 1157 2141:aload_0         
    // 1158 2142:getfield        #156 <Field int m_XaxisStart>
    // 1159 2145:aload_0         
    // 1160 2146:getfield        #162 <Field int m_YaxisEnd>
    // 1161 2149:invokevirtual   #591 <Method void Graphics.drawLine(int, int, int, int)>
        gx.drawLine(m_XaxisStart, m_YaxisEnd, m_XaxisEnd, m_YaxisEnd);
    // 1162 2152:aload_1         
    // 1163 2153:aload_0         
    // 1164 2154:getfield        #156 <Field int m_XaxisStart>
    // 1165 2157:aload_0         
    // 1166 2158:getfield        #162 <Field int m_YaxisEnd>
    // 1167 2161:aload_0         
    // 1168 2162:getfield        #160 <Field int m_XaxisEnd>
    // 1169 2165:aload_0         
    // 1170 2166:getfield        #162 <Field int m_YaxisEnd>
    // 1171 2169:invokevirtual   #591 <Method void Graphics.drawLine(int, int, int, int)>
        if(m_XaxisStart != mxs || m_XaxisEnd != mxe || m_YaxisStart != mys || m_YaxisEnd != mye)
    //*1172 2172:aload_0         
    //*1173 2173:getfield        #156 <Field int m_XaxisStart>
    //*1174 2176:iload_2         
    //*1175 2177:icmpne          2206
    //*1176 2180:aload_0         
    //*1177 2181:getfield        #160 <Field int m_XaxisEnd>
    //*1178 2184:iload_3         
    //*1179 2185:icmpne          2206
    //*1180 2188:aload_0         
    //*1181 2189:getfield        #158 <Field int m_YaxisStart>
    //*1182 2192:iload           4
    //*1183 2194:icmpne          2206
    //*1184 2197:aload_0         
    //*1185 2198:getfield        #162 <Field int m_YaxisEnd>
    //*1186 2201:iload           5
    //*1187 2203:icmpeq          2211
            m_plotResize = true;
    // 1188 2206:aload_0         
    // 1189 2207:iconst_1        
    // 1190 2208:putfield        #164 <Field boolean m_plotResize>
    // 1191 2211:return          
    }

    private void extendColourMap(int highest)
    {
        for(int i = m_colorList.size(); i < highest; i++)
    //*   0    0:aload_0         
    //*   1    1:getfield        #216 <Field FastVector m_colorList>
    //*   2    4:invokevirtual   #219 <Method int FastVector.size()>
    //*   3    7:istore_2        
    //*   4    8:goto            65
        {
            Color pc = m_DefaultColors[i % 10];
    //    5   11:aload_0         
    //    6   12:getfield        #142 <Field Color[] m_DefaultColors>
    //    7   15:iload_2         
    //    8   16:bipush          10
    //    9   18:irem            
    //   10   19:aaload          
    //   11   20:astore_3        
            int ija = i / 10;
    //   12   21:iload_2         
    //   13   22:bipush          10
    //   14   24:idiv            
    //   15   25:istore          4
            ija *= 2;
    //   16   27:iload           4
    //   17   29:iconst_2        
    //   18   30:imul            
    //   19   31:istore          4
            for(int j = 0; j < ija; j++)
    //*  20   33:iconst_0        
    //*  21   34:istore          5
    //*  22   36:goto            47
                pc = pc.brighter();
    //   23   39:aload_3         
    //   24   40:invokevirtual   #764 <Method Color Color.brighter()>
    //   25   43:astore_3        

    //   26   44:iinc            5  1
    //   27   47:iload           5
    //   28   49:iload           4
    //   29   51:icmplt          39
            m_colorList.addElement(pc);
    //   30   54:aload_0         
    //   31   55:getfield        #216 <Field FastVector m_colorList>
    //   32   58:aload_3         
    //   33   59:invokevirtual   #227 <Method void FastVector.addElement(Object)>
        }

    //   34   62:iinc            2  1
    //   35   65:iload_2         
    //   36   66:iload_1         
    //   37   67:icmplt          11
    //   38   70:return          
    }

    public void paintComponent(Graphics gx)
    {
        super.paintComponent(gx);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokespecial   #768 <Method void JPanel.paintComponent(Graphics)>
        if(m_plotInstances != null && m_plotInstances.numInstances() > 0 && m_plotInstances.numAttributes() > 0)
    //*   3    5:aload_0         
    //*   4    6:getfield        #110 <Field Instances m_plotInstances>
    //*   5    9:ifnull          155
    //*   6   12:aload_0         
    //*   7   13:getfield        #110 <Field Instances m_plotInstances>
    //*   8   16:invokevirtual   #318 <Method int Instances.numInstances()>
    //*   9   19:ifle            155
    //*  10   22:aload_0         
    //*  11   23:getfield        #110 <Field Instances m_plotInstances>
    //*  12   26:invokevirtual   #315 <Method int Instances.numAttributes()>
    //*  13   29:ifle            155
        {
            if(m_plotCompanion != null)
    //*  14   32:aload_0         
    //*  15   33:getfield        #112 <Field Plot2DCompanion m_plotCompanion>
    //*  16   36:ifnull          49
                m_plotCompanion.prePlot(gx);
    //   17   39:aload_0         
    //   18   40:getfield        #112 <Field Plot2DCompanion m_plotCompanion>
    //   19   43:aload_1         
    //   20   44:invokeinterface #773 <Method void Plot2DCompanion.prePlot(Graphics)>
            m_JRand = new Random(m_JitterVal);
    //   21   49:aload_0         
    //   22   50:new             #172 <Class Random>
    //   23   53:dup             
    //   24   54:aload_0         
    //   25   55:getfield        #170 <Field int m_JitterVal>
    //   26   58:i2l             
    //   27   59:invokespecial   #175 <Method void Random(long)>
    //   28   62:putfield        #177 <Field Random m_JRand>
            paintAxis(gx);
    //   29   65:aload_0         
    //   30   66:aload_1         
    //   31   67:invokespecial   #775 <Method void paintAxis(Graphics)>
            if(m_axisChanged || m_plotResize)
    //*  32   70:aload_0         
    //*  33   71:getfield        #166 <Field boolean m_axisChanged>
    //*  34   74:ifne            84
    //*  35   77:aload_0         
    //*  36   78:getfield        #164 <Field boolean m_plotResize>
    //*  37   81:ifeq            150
            {
                int x_range = m_XaxisEnd - m_XaxisStart;
    //   38   84:aload_0         
    //   39   85:getfield        #160 <Field int m_XaxisEnd>
    //   40   88:aload_0         
    //   41   89:getfield        #156 <Field int m_XaxisStart>
    //   42   92:isub            
    //   43   93:istore_2        
                int y_range = m_YaxisEnd - m_YaxisStart;
    //   44   94:aload_0         
    //   45   95:getfield        #162 <Field int m_YaxisEnd>
    //   46   98:aload_0         
    //   47   99:getfield        #158 <Field int m_YaxisStart>
    //   48  102:isub            
    //   49  103:istore_3        
                if(x_range < 10)
    //*  50  104:iload_2         
    //*  51  105:bipush          10
    //*  52  107:icmpge          113
                    x_range = 10;
    //   53  110:bipush          10
    //   54  112:istore_2        
                if(y_range < 10)
    //*  55  113:iload_3         
    //*  56  114:bipush          10
    //*  57  116:icmpge          122
                    y_range = 10;
    //   58  119:bipush          10
    //   59  121:istore_3        
                m_drawnPoints = new int[x_range + 1][y_range + 1];
    //   60  122:aload_0         
    //   61  123:iload_2         
    //   62  124:iconst_1        
    //   63  125:iadd            
    //   64  126:iload_3         
    //   65  127:iconst_1        
    //   66  128:iadd            
    //   67  129:multianewarray  int[][]
    //   68  133:putfield        #211 <Field int[][] m_drawnPoints>
                fillLookup();
    //   69  136:aload_0         
    //   70  137:invokespecial   #563 <Method void fillLookup()>
                m_plotResize = false;
    //   71  140:aload_0         
    //   72  141:iconst_0        
    //   73  142:putfield        #164 <Field boolean m_plotResize>
                m_axisChanged = false;
    //   74  145:aload_0         
    //   75  146:iconst_0        
    //   76  147:putfield        #166 <Field boolean m_axisChanged>
            }
            paintData(gx);
    //   77  150:aload_0         
    //   78  151:aload_1         
    //   79  152:invokespecial   #777 <Method void paintData(Graphics)>
        }
    //   80  155:return          
    }

    protected static Color checkAgainstBackground(Color c, Color background)
    {
        if(background == null)
    //*   0    0:aload_1         
    //*   1    1:ifnonnull       6
            return c;
    //    2    4:aload_0         
    //    3    5:areturn         
        if(c.equals(background))
    //*   4    6:aload_0         
    //*   5    7:aload_1         
    //*   6    8:invokevirtual   #783 <Method boolean Color.equals(Object)>
    //*   7   11:ifeq            117
        {
            int red = c.getRed();
    //    8   14:aload_0         
    //    9   15:invokevirtual   #786 <Method int Color.getRed()>
    //   10   18:istore_2        
            int blue = c.getBlue();
    //   11   19:aload_0         
    //   12   20:invokevirtual   #789 <Method int Color.getBlue()>
    //   13   23:istore_3        
            int green = c.getGreen();
    //   14   24:aload_0         
    //   15   25:invokevirtual   #792 <Method int Color.getGreen()>
    //   16   28:istore          4
            red += red >= 128 ? -(red / 2) : (255 - red) / 2;
    //   17   30:iload_2         
    //   18   31:iload_2         
    //   19   32:sipush          128
    //   20   35:icmpge          48
    //   21   38:sipush          255
    //   22   41:iload_2         
    //   23   42:isub            
    //   24   43:iconst_2        
    //   25   44:idiv            
    //   26   45:goto            52
    //   27   48:iload_2         
    //   28   49:iconst_2        
    //   29   50:idiv            
    //   30   51:ineg            
    //   31   52:iadd            
    //   32   53:istore_2        
            blue += blue >= 128 ? -(blue / 2) : (blue - red) / 2;
    //   33   54:iload_3         
    //   34   55:iload_3         
    //   35   56:sipush          128
    //   36   59:icmpge          70
    //   37   62:iload_3         
    //   38   63:iload_2         
    //   39   64:isub            
    //   40   65:iconst_2        
    //   41   66:idiv            
    //   42   67:goto            74
    //   43   70:iload_3         
    //   44   71:iconst_2        
    //   45   72:idiv            
    //   46   73:ineg            
    //   47   74:iadd            
    //   48   75:istore_3        
            green += green >= 128 ? -(green / 2) : (255 - green) / 2;
    //   49   76:iload           4
    //   50   78:iload           4
    //   51   80:sipush          128
    //   52   83:icmpge          97
    //   53   86:sipush          255
    //   54   89:iload           4
    //   55   91:isub            
    //   56   92:iconst_2        
    //   57   93:idiv            
    //   58   94:goto            102
    //   59   97:iload           4
    //   60   99:iconst_2        
    //   61  100:idiv            
    //   62  101:ineg            
    //   63  102:iadd            
    //   64  103:istore          4
            c = new Color(red, green, blue);
    //   65  105:new             #87  <Class Color>
    //   66  108:dup             
    //   67  109:iload_2         
    //   68  110:iload           4
    //   69  112:iload_3         
    //   70  113:invokespecial   #134 <Method void Color(int, int, int)>
    //   71  116:astore_0        
        }
        return c;
    //   72  117:aload_0         
    //   73  118:areturn         
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
                System.err.println("Usage : weka.gui.visualize.Plot2D <dataset> [<dataset> <dataset>...]");
    //    4    6:getstatic       #801 <Field PrintStream System.err>
    //    5    9:ldc2            #803 <String "Usage : weka.gui.visualize.Plot2D <dataset> [<dataset> <dataset>...]">
    //    6   12:invokevirtual   #808 <Method void PrintStream.println(String)>
                System.exit(1);
    //    7   15:iconst_1        
    //    8   16:invokestatic    #811 <Method void System.exit(int)>
            }
            final JFrame jf = new JFrame("Weka Explorer: Visualize");
    //    9   19:new             #496 <Class JFrame>
    //   10   22:dup             
    //   11   23:ldc2            #813 <String "Weka Explorer: Visualize">
    //   12   26:invokespecial   #499 <Method void JFrame(String)>
    //   13   29:astore_1        
            jf.setSize(500, 400);
    //   14   30:aload_1         
    //   15   31:sipush          500
    //   16   34:sipush          400
    //   17   37:invokevirtual   #539 <Method void JFrame.setSize(int, int)>
            jf.getContentPane().setLayout(new BorderLayout());
    //   18   40:aload_1         
    //   19   41:invokevirtual   #512 <Method Container JFrame.getContentPane()>
    //   20   44:new             #514 <Class BorderLayout>
    //   21   47:dup             
    //   22   48:invokespecial   #515 <Method void BorderLayout()>
    //   23   51:invokevirtual   #521 <Method void Container.setLayout(java.awt.LayoutManager)>
            final Plot2D p2 = new Plot2D();
    //   24   54:new             #2   <Class Plot2D>
    //   25   57:dup             
    //   26   58:invokespecial   #814 <Method void Plot2D()>
    //   27   61:astore_2        
            jf.getContentPane().add(p2, "Center");
    //   28   62:aload_1         
    //   29   63:invokevirtual   #512 <Method Container JFrame.getContentPane()>
    //   30   66:aload_2         
    //   31   67:ldc2            #528 <String "Center">
    //   32   70:invokevirtual   #532 <Method void Container.add(java.awt.Component, Object)>
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
    //   33   73:aload_1         
    //   34   74:new             #816 <Class Plot2D$2>
    //   35   77:dup             
    //   36   78:aload_1         
    //   37   79:invokespecial   #819 <Method void Plot2D$2(JFrame)>
    //   38   82:invokevirtual   #508 <Method void JFrame.addWindowListener(java.awt.event.WindowListener)>
            p2.addMouseListener(new MouseAdapter() {

                public void mouseClicked(MouseEvent e)
                {
                    if((e.getModifiers() & 0x10) == 16)
                //*   0    0:aload_1         
                //*   1    1:invokevirtual   #26  <Method int MouseEvent.getModifiers()>
                //*   2    4:bipush          16
                //*   3    6:iand            
                //*   4    7:bipush          16
                //*   5    9:icmpne          31
                        p2.searchPoints(e.getX(), e.getY(), false);
                //    6   12:aload_0         
                //    7   13:getfield        #11  <Field Plot2D val$p2>
                //    8   16:aload_1         
                //    9   17:invokevirtual   #29  <Method int MouseEvent.getX()>
                //   10   20:aload_1         
                //   11   21:invokevirtual   #32  <Method int MouseEvent.getY()>
                //   12   24:iconst_0        
                //   13   25:invokevirtual   #38  <Method void Plot2D.searchPoints(int, int, boolean)>
                    else
                //*  14   28:goto            47
                        p2.searchPoints(e.getX(), e.getY(), true);
                //   15   31:aload_0         
                //   16   32:getfield        #11  <Field Plot2D val$p2>
                //   17   35:aload_1         
                //   18   36:invokevirtual   #29  <Method int MouseEvent.getX()>
                //   19   39:aload_1         
                //   20   40:invokevirtual   #32  <Method int MouseEvent.getY()>
                //   21   43:iconst_1        
                //   22   44:invokevirtual   #38  <Method void Plot2D.searchPoints(int, int, boolean)>
                //   23   47:return          
                }

                private final Plot2D val$p2;

            
            {
                p2 = plot2d;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #11  <Field Plot2D val$p2>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #14  <Method void MouseAdapter()>
            //    5    9:return          
            }
            }
);
    //   39   85:aload_2         
    //   40   86:new             #821 <Class Plot2D$3>
    //   41   89:dup             
    //   42   90:aload_2         
    //   43   91:invokespecial   #824 <Method void Plot2D$3(Plot2D)>
    //   44   94:invokevirtual   #828 <Method void addMouseListener(java.awt.event.MouseListener)>
            jf.setVisible(true);
    //   45   97:aload_1         
    //   46   98:iconst_1        
    //   47   99:invokevirtual   #542 <Method void JFrame.setVisible(boolean)>
            if(args.length >= 1)
    //*  48  102:aload_0         
    //*  49  103:arraylength     
    //*  50  104:iconst_1        
    //*  51  105:icmplt          314
            {
                for(int j = 0; j < args.length; j++)
    //*  52  108:iconst_0        
    //*  53  109:istore_3        
    //*  54  110:goto            290
                {
                    System.err.println((new StringBuilder("Loading instances from ")).append(args[j]).toString());
    //   55  113:getstatic       #801 <Field PrintStream System.err>
    //   56  116:new             #255 <Class StringBuilder>
    //   57  119:dup             
    //   58  120:ldc2            #830 <String "Loading instances from ">
    //   59  123:invokespecial   #264 <Method void StringBuilder(String)>
    //   60  126:aload_0         
    //   61  127:iload_3         
    //   62  128:aaload          
    //   63  129:invokevirtual   #270 <Method StringBuilder StringBuilder.append(String)>
    //   64  132:invokevirtual   #273 <Method String StringBuilder.toString()>
    //   65  135:invokevirtual   #808 <Method void PrintStream.println(String)>
                    java.io.Reader r = new BufferedReader(new FileReader(args[j]));
    //   66  138:new             #832 <Class BufferedReader>
    //   67  141:dup             
    //   68  142:new             #834 <Class FileReader>
    //   69  145:dup             
    //   70  146:aload_0         
    //   71  147:iload_3         
    //   72  148:aaload          
    //   73  149:invokespecial   #835 <Method void FileReader(String)>
    //   74  152:invokespecial   #838 <Method void BufferedReader(java.io.Reader)>
    //   75  155:astore          4
                    Instances i = new Instances(r);
    //   76  157:new             #312 <Class Instances>
    //   77  160:dup             
    //   78  161:aload           4
    //   79  163:invokespecial   #839 <Method void Instances(java.io.Reader)>
    //   80  166:astore          5
                    i.setClassIndex(i.numAttributes() - 1);
    //   81  168:aload           5
    //   82  170:aload           5
    //   83  172:invokevirtual   #315 <Method int Instances.numAttributes()>
    //   84  175:iconst_1        
    //   85  176:isub            
    //   86  177:invokevirtual   #842 <Method void Instances.setClassIndex(int)>
                    PlotData2D pd1 = new PlotData2D(i);
    //   87  180:new             #334 <Class PlotData2D>
    //   88  183:dup             
    //   89  184:aload           5
    //   90  186:invokespecial   #379 <Method void PlotData2D(Instances)>
    //   91  189:astore          6
                    if(j == 0)
    //*  92  191:iload_3         
    //*  93  192:ifne            231
                    {
                        pd1.setPlotName("Master plot");
    //   94  195:aload           6
    //   95  197:ldc2            #844 <String "Master plot">
    //   96  200:invokevirtual   #382 <Method void PlotData2D.setPlotName(String)>
                        p2.setMasterPlot(pd1);
    //   97  203:aload_2         
    //   98  204:aload           6
    //   99  206:invokevirtual   #386 <Method void setMasterPlot(PlotData2D)>
                        p2.setXindex(2);
    //  100  209:aload_2         
    //  101  210:iconst_2        
    //  102  211:invokevirtual   #404 <Method void setXindex(int)>
                        p2.setYindex(3);
    //  103  214:aload_2         
    //  104  215:iconst_3        
    //  105  216:invokevirtual   #405 <Method void setYindex(int)>
                        p2.setCindex(i.classIndex());
    //  106  219:aload_2         
    //  107  220:aload           5
    //  108  222:invokevirtual   #847 <Method int Instances.classIndex()>
    //  109  225:invokevirtual   #406 <Method void setCindex(int)>
                    } else
    //* 110  228:goto            287
                    {
                        pd1.setPlotName((new StringBuilder("Plot ")).append(j + 1).toString());
    //  111  231:aload           6
    //  112  233:new             #255 <Class StringBuilder>
    //  113  236:dup             
    //  114  237:ldc2            #849 <String "Plot ">
    //  115  240:invokespecial   #264 <Method void StringBuilder(String)>
    //  116  243:iload_3         
    //  117  244:iconst_1        
    //  118  245:iadd            
    //  119  246:invokevirtual   #454 <Method StringBuilder StringBuilder.append(int)>
    //  120  249:invokevirtual   #273 <Method String StringBuilder.toString()>
    //  121  252:invokevirtual   #382 <Method void PlotData2D.setPlotName(String)>
                        pd1.m_useCustomColour = true;
    //  122  255:aload           6
    //  123  257:iconst_1        
    //  124  258:putfield        #657 <Field boolean PlotData2D.m_useCustomColour>
                        pd1.m_customColour = j % 2 != 0 ? Color.blue : Color.red;
    //  125  261:aload           6
    //  126  263:iload_3         
    //  127  264:iconst_2        
    //  128  265:irem            
    //  129  266:ifne            275
    //  130  269:getstatic       #125 <Field Color Color.red>
    //  131  272:goto            278
    //  132  275:getstatic       #122 <Field Color Color.blue>
    //  133  278:putfield        #669 <Field Color PlotData2D.m_customColour>
                        p2.addPlot(pd1);
    //  134  281:aload_2         
    //  135  282:aload           6
    //  136  284:invokevirtual   #851 <Method void addPlot(PlotData2D)>
                    }
                }

    //  137  287:iinc            3  1
    //  138  290:iload_3         
    //  139  291:aload_0         
    //  140  292:arraylength     
    //  141  293:icmplt          113
            }
        }
    //* 142  296:goto            314
        catch(Exception ex)
    //* 143  299:astore_1        
        {
            ex.printStackTrace();
    //  144  300:aload_1         
    //  145  301:invokevirtual   #854 <Method void Exception.printStackTrace()>
            System.err.println(ex.getMessage());
    //  146  304:getstatic       #801 <Field PrintStream System.err>
    //  147  307:aload_1         
    //  148  308:invokevirtual   #857 <Method String Exception.getMessage()>
    //  149  311:invokevirtual   #808 <Method void PrintStream.println(String)>
        }
    //  150  314:return          
    }

    private static final long serialVersionUID = 0xe8c7bba6f15a4226L;
    public static final int MAX_SHAPES = 5;
    public static final int ERROR_SHAPE = 1000;
    public static final int MISSING_SHAPE = 2000;
    public static final int CONST_AUTOMATIC_SHAPE = -1;
    public static final int X_SHAPE = 0;
    public static final int PLUS_SHAPE = 1;
    public static final int DIAMOND_SHAPE = 2;
    public static final int TRIANGLEUP_SHAPE = 3;
    public static final int TRIANGLEDOWN_SHAPE = 4;
    public static final int DEFAULT_SHAPE_SIZE = 2;
    protected Color m_axisColour;
    protected Color m_backgroundColour;
    protected FastVector m_plots;
    protected PlotData2D m_masterPlot;
    protected String m_masterName;
    protected Instances m_plotInstances;
    protected Plot2DCompanion m_plotCompanion;
    protected JFrame m_InstanceInfo;
    protected JTextArea m_InstanceInfoText;
    protected FastVector m_colorList;
    protected Color m_DefaultColors[];
    protected int m_xIndex;
    protected int m_yIndex;
    protected int m_cIndex;
    protected int m_sIndex;
    protected double m_maxX;
    protected double m_minX;
    protected double m_maxY;
    protected double m_minY;
    protected double m_maxC;
    protected double m_minC;
    protected final int m_axisPad = 5;
    protected final int m_tickSize = 5;
    protected int m_XaxisStart;
    protected int m_YaxisStart;
    protected int m_XaxisEnd;
    protected int m_YaxisEnd;
    protected boolean m_plotResize;
    protected boolean m_axisChanged;
    protected int m_drawnPoints[][];
    protected Font m_labelFont;
    protected FontMetrics m_labelMetrics;
    protected int m_JitterVal;
    protected Random m_JRand;
    protected double m_pointLookup[][];
}
