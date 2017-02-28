// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   VisualizePanel.java

package rm.gui.visualize;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Properties;
import java.util.Random;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileFilter;
import rm.core.*;
import rm.gui.ExtensionFileFilter;
import rm.gui.Logger;

// Referenced classes of package rm.gui.visualize:
//            PrintablePanel, VisualizeUtils, AttributePanel, Plot2D, 
//            LegendPanel, ClassPanel, PlotData2D, VisualizePanelListener, 
//            Plot2DCompanion, VisualizePanelEvent, AttributePanelListener, AttributePanelEvent

public class VisualizePanel extends PrintablePanel
{
    protected class PlotPanel extends PrintablePanel
        implements Plot2DCompanion
    {

        public void removeAllPlots()
        {
            m_plot2D.removeAllPlots();
        //    0    0:aload_0         
        //    1    1:getfield        #48  <Field Plot2D m_plot2D>
        //    2    4:invokevirtual   #148 <Method void Plot2D.removeAllPlots()>
            m_legendPanel.setPlotList(m_plot2D.getPlots());
        //    3    7:aload_0         
        //    4    8:getfield        #40  <Field VisualizePanel this$0>
        //    5   11:getfield        #152 <Field LegendPanel VisualizePanel.m_legendPanel>
        //    6   14:aload_0         
        //    7   15:getfield        #48  <Field Plot2D m_plot2D>
        //    8   18:invokevirtual   #156 <Method FastVector Plot2D.getPlots()>
        //    9   21:invokevirtual   #162 <Method void LegendPanel.setPlotList(FastVector)>
        //   10   24:return          
        }

        public FastVector getShapes()
        {
            return m_shapes;
        //    0    0:aload_0         
        //    1    1:getfield        #97  <Field FastVector m_shapes>
        //    2    4:areturn         
        }

        public void cancelShapes()
        {
            if(m_splitListener == null)
        //*   0    0:aload_0         
        //*   1    1:getfield        #40  <Field VisualizePanel this$0>
        //*   2    4:getfield        #168 <Field VisualizePanelListener VisualizePanel.m_splitListener>
        //*   3    7:ifnonnull       83
            {
                m_submit.setText("Reset");
        //    4   10:aload_0         
        //    5   11:getfield        #40  <Field VisualizePanel this$0>
        //    6   14:getfield        #126 <Field JButton VisualizePanel.m_submit>
        //    7   17:ldc1            #170 <String "Reset">
        //    8   19:invokevirtual   #174 <Method void JButton.setText(String)>
                m_submit.setActionCommand("Reset");
        //    9   22:aload_0         
        //   10   23:getfield        #40  <Field VisualizePanel this$0>
        //   11   26:getfield        #126 <Field JButton VisualizePanel.m_submit>
        //   12   29:ldc1            #170 <String "Reset">
        //   13   31:invokevirtual   #177 <Method void JButton.setActionCommand(String)>
                if(m_originalPlot == null || m_originalPlot.m_plotInstances == m_plotInstances)
        //*  14   34:aload_0         
        //*  15   35:getfield        #52  <Field PlotData2D m_originalPlot>
        //*  16   38:ifnull          55
        //*  17   41:aload_0         
        //*  18   42:getfield        #52  <Field PlotData2D m_originalPlot>
        //*  19   45:getfield        #180 <Field Instances PlotData2D.m_plotInstances>
        //*  20   48:aload_0         
        //*  21   49:getfield        #50  <Field Instances m_plotInstances>
        //*  22   52:if_acmpne       69
                    m_submit.setEnabled(false);
        //   23   55:aload_0         
        //   24   56:getfield        #40  <Field VisualizePanel this$0>
        //   25   59:getfield        #126 <Field JButton VisualizePanel.m_submit>
        //   26   62:iconst_0        
        //   27   63:invokevirtual   #184 <Method void JButton.setEnabled(boolean)>
                else
        //*  28   66:goto            94
                    m_submit.setEnabled(true);
        //   29   69:aload_0         
        //   30   70:getfield        #40  <Field VisualizePanel this$0>
        //   31   73:getfield        #126 <Field JButton VisualizePanel.m_submit>
        //   32   76:iconst_1        
        //   33   77:invokevirtual   #184 <Method void JButton.setEnabled(boolean)>
            } else
        //*  34   80:goto            94
            {
                m_submit.setEnabled(false);
        //   35   83:aload_0         
        //   36   84:getfield        #40  <Field VisualizePanel this$0>
        //   37   87:getfield        #126 <Field JButton VisualizePanel.m_submit>
        //   38   90:iconst_0        
        //   39   91:invokevirtual   #184 <Method void JButton.setEnabled(boolean)>
            }
            m_createShape = false;
        //   40   94:aload_0         
        //   41   95:iconst_0        
        //   42   96:putfield        #95  <Field boolean m_createShape>
            m_shapePoints = null;
        //   43   99:aload_0         
        //   44  100:aconst_null     
        //   45  101:putfield        #99  <Field FastVector m_shapePoints>
            m_shapes = null;
        //   46  104:aload_0         
        //   47  105:aconst_null     
        //   48  106:putfield        #97  <Field FastVector m_shapes>
            repaint();
        //   49  109:aload_0         
        //   50  110:invokevirtual   #187 <Method void repaint()>
        //   51  113:return          
        }

        public void setShapes(FastVector v)
        {
            if(v != null)
        //*   0    0:aload_1         
        //*   1    1:ifnull          107
            {
                m_shapes = new FastVector(v.size());
        //    2    4:aload_0         
        //    3    5:new             #190 <Class FastVector>
        //    4    8:dup             
        //    5    9:aload_1         
        //    6   10:invokevirtual   #194 <Method int FastVector.size()>
        //    7   13:invokespecial   #197 <Method void FastVector(int)>
        //    8   16:putfield        #97  <Field FastVector m_shapes>
                for(int noa = 0; noa < v.size(); noa++)
        //*   9   19:iconst_0        
        //*  10   20:istore_3        
        //*  11   21:goto            96
                {
                    FastVector temp = new FastVector(((FastVector)v.elementAt(noa)).size());
        //   12   24:new             #190 <Class FastVector>
        //   13   27:dup             
        //   14   28:aload_1         
        //   15   29:iload_3         
        //   16   30:invokevirtual   #201 <Method Object FastVector.elementAt(int)>
        //   17   33:checkcast       #190 <Class FastVector>
        //   18   36:invokevirtual   #194 <Method int FastVector.size()>
        //   19   39:invokespecial   #197 <Method void FastVector(int)>
        //   20   42:astore_2        
                    m_shapes.addElement(temp);
        //   21   43:aload_0         
        //   22   44:getfield        #97  <Field FastVector m_shapes>
        //   23   47:aload_2         
        //   24   48:invokevirtual   #205 <Method void FastVector.addElement(Object)>
                    for(int nob = 0; nob < ((FastVector)v.elementAt(noa)).size(); nob++)
        //*  25   51:iconst_0        
        //*  26   52:istore          4
        //*  27   54:goto            77
                        temp.addElement(((FastVector)v.elementAt(noa)).elementAt(nob));
        //   28   57:aload_2         
        //   29   58:aload_1         
        //   30   59:iload_3         
        //   31   60:invokevirtual   #201 <Method Object FastVector.elementAt(int)>
        //   32   63:checkcast       #190 <Class FastVector>
        //   33   66:iload           4
        //   34   68:invokevirtual   #201 <Method Object FastVector.elementAt(int)>
        //   35   71:invokevirtual   #205 <Method void FastVector.addElement(Object)>

        //   36   74:iinc            4  1
        //   37   77:iload           4
        //   38   79:aload_1         
        //   39   80:iload_3         
        //   40   81:invokevirtual   #201 <Method Object FastVector.elementAt(int)>
        //   41   84:checkcast       #190 <Class FastVector>
        //   42   87:invokevirtual   #194 <Method int FastVector.size()>
        //   43   90:icmplt          57
                }

        //   44   93:iinc            3  1
        //   45   96:iload_3         
        //   46   97:aload_1         
        //   47   98:invokevirtual   #194 <Method int FastVector.size()>
        //   48  101:icmplt          24
            } else
        //*  49  104:goto            112
            {
                m_shapes = null;
        //   50  107:aload_0         
        //   51  108:aconst_null     
        //   52  109:putfield        #97  <Field FastVector m_shapes>
            }
            repaint();
        //   53  112:aload_0         
        //   54  113:invokevirtual   #187 <Method void repaint()>
        //   55  116:return          
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
        //    6    8:invokevirtual   #215 <Method Dimension getSize()>
        //    7   11:getfield        #218 <Field int Dimension.width>
        //    8   14:i2d             
        //    9   15:dcmpl           
        //   10   16:ifgt            38
        //   11   19:dload_3         
        //   12   20:dconst_0        
        //   13   21:dcmpg           
        //   14   22:iflt            38
        //   15   25:dload_3         
        //   16   26:aload_0         
        //   17   27:invokevirtual   #215 <Method Dimension getSize()>
        //   18   30:getfield        #221 <Field int Dimension.height>
        //   19   33:i2d             
        //   20   34:dcmpl           
        //   21   35:ifle            40
        //   22   38:iconst_0        
        //   23   39:ireturn         
        //   24   40:iconst_1        
        //   25   41:ireturn         
        }

        public boolean inSplit(Instance i)
        {
            if(m_shapes != null)
        //*   0    0:aload_0         
        //*   1    1:getfield        #97  <Field FastVector m_shapes>
        //*   2    4:ifnull          252
            {
                for(int noa = 0; noa < m_shapes.size(); noa++)
        //*   3    7:iconst_0        
        //*   4    8:istore          11
        //*   5   10:goto            240
                {
                    FastVector stmp = (FastVector)m_shapes.elementAt(noa);
        //    6   13:aload_0         
        //    7   14:getfield        #97  <Field FastVector m_shapes>
        //    8   17:iload           11
        //    9   19:invokevirtual   #201 <Method Object FastVector.elementAt(int)>
        //   10   22:checkcast       #190 <Class FastVector>
        //   11   25:astore_2        
                    if(((Double)stmp.elementAt(0)).intValue() == 1)
        //*  12   26:aload_2         
        //*  13   27:iconst_0        
        //*  14   28:invokevirtual   #201 <Method Object FastVector.elementAt(int)>
        //*  15   31:checkcast       #228 <Class Double>
        //*  16   34:invokevirtual   #231 <Method int Double.intValue()>
        //*  17   37:iconst_1        
        //*  18   38:icmpne          152
                    {
                        double x1 = ((Double)stmp.elementAt(1)).doubleValue();
        //   19   41:aload_2         
        //   20   42:iconst_1        
        //   21   43:invokevirtual   #201 <Method Object FastVector.elementAt(int)>
        //   22   46:checkcast       #228 <Class Double>
        //   23   49:invokevirtual   #235 <Method double Double.doubleValue()>
        //   24   52:dstore_3        
                        double y1 = ((Double)stmp.elementAt(2)).doubleValue();
        //   25   53:aload_2         
        //   26   54:iconst_2        
        //   27   55:invokevirtual   #201 <Method Object FastVector.elementAt(int)>
        //   28   58:checkcast       #228 <Class Double>
        //   29   61:invokevirtual   #235 <Method double Double.doubleValue()>
        //   30   64:dstore          5
                        double x2 = ((Double)stmp.elementAt(3)).doubleValue();
        //   31   66:aload_2         
        //   32   67:iconst_3        
        //   33   68:invokevirtual   #201 <Method Object FastVector.elementAt(int)>
        //   34   71:checkcast       #228 <Class Double>
        //   35   74:invokevirtual   #235 <Method double Double.doubleValue()>
        //   36   77:dstore          7
                        double y2 = ((Double)stmp.elementAt(4)).doubleValue();
        //   37   79:aload_2         
        //   38   80:iconst_4        
        //   39   81:invokevirtual   #201 <Method Object FastVector.elementAt(int)>
        //   40   84:checkcast       #228 <Class Double>
        //   41   87:invokevirtual   #235 <Method double Double.doubleValue()>
        //   42   90:dstore          9
                        if(i.value(m_xIndex) >= x1 && i.value(m_xIndex) <= x2 && i.value(m_yIndex) <= y1 && i.value(m_yIndex) >= y2)
        //*  43   92:aload_1         
        //*  44   93:aload_0         
        //*  45   94:getfield        #54  <Field int m_xIndex>
        //*  46   97:invokevirtual   #241 <Method double Instance.value(int)>
        //*  47  100:dload_3         
        //*  48  101:dcmpl           
        //*  49  102:iflt            237
        //*  50  105:aload_1         
        //*  51  106:aload_0         
        //*  52  107:getfield        #54  <Field int m_xIndex>
        //*  53  110:invokevirtual   #241 <Method double Instance.value(int)>
        //*  54  113:dload           7
        //*  55  115:dcmpg           
        //*  56  116:ifgt            237
        //*  57  119:aload_1         
        //*  58  120:aload_0         
        //*  59  121:getfield        #56  <Field int m_yIndex>
        //*  60  124:invokevirtual   #241 <Method double Instance.value(int)>
        //*  61  127:dload           5
        //*  62  129:dcmpg           
        //*  63  130:ifgt            237
        //*  64  133:aload_1         
        //*  65  134:aload_0         
        //*  66  135:getfield        #56  <Field int m_yIndex>
        //*  67  138:invokevirtual   #241 <Method double Instance.value(int)>
        //*  68  141:dload           9
        //*  69  143:dcmpl           
        //*  70  144:iflt            237
                            return true;
        //   71  147:iconst_1        
        //   72  148:ireturn         
                    } else
        //*  73  149:goto            237
                    if(((Double)stmp.elementAt(0)).intValue() == 2)
        //*  74  152:aload_2         
        //*  75  153:iconst_0        
        //*  76  154:invokevirtual   #201 <Method Object FastVector.elementAt(int)>
        //*  77  157:checkcast       #228 <Class Double>
        //*  78  160:invokevirtual   #231 <Method int Double.intValue()>
        //*  79  163:iconst_2        
        //*  80  164:icmpne          196
                    {
                        if(inPoly(stmp, i.value(m_xIndex), i.value(m_yIndex)))
        //*  81  167:aload_0         
        //*  82  168:aload_2         
        //*  83  169:aload_1         
        //*  84  170:aload_0         
        //*  85  171:getfield        #54  <Field int m_xIndex>
        //*  86  174:invokevirtual   #241 <Method double Instance.value(int)>
        //*  87  177:aload_1         
        //*  88  178:aload_0         
        //*  89  179:getfield        #56  <Field int m_yIndex>
        //*  90  182:invokevirtual   #241 <Method double Instance.value(int)>
        //*  91  185:invokespecial   #245 <Method boolean inPoly(FastVector, double, double)>
        //*  92  188:ifeq            237
                            return true;
        //   93  191:iconst_1        
        //   94  192:ireturn         
                    } else
        //*  95  193:goto            237
                    if(((Double)stmp.elementAt(0)).intValue() == 3 && inPolyline(stmp, i.value(m_xIndex), i.value(m_yIndex)))
        //*  96  196:aload_2         
        //*  97  197:iconst_0        
        //*  98  198:invokevirtual   #201 <Method Object FastVector.elementAt(int)>
        //*  99  201:checkcast       #228 <Class Double>
        //* 100  204:invokevirtual   #231 <Method int Double.intValue()>
        //* 101  207:iconst_3        
        //* 102  208:icmpne          237
        //* 103  211:aload_0         
        //* 104  212:aload_2         
        //* 105  213:aload_1         
        //* 106  214:aload_0         
        //* 107  215:getfield        #54  <Field int m_xIndex>
        //* 108  218:invokevirtual   #241 <Method double Instance.value(int)>
        //* 109  221:aload_1         
        //* 110  222:aload_0         
        //* 111  223:getfield        #56  <Field int m_yIndex>
        //* 112  226:invokevirtual   #241 <Method double Instance.value(int)>
        //* 113  229:invokespecial   #248 <Method boolean inPolyline(FastVector, double, double)>
        //* 114  232:ifeq            237
                        return true;
        //  115  235:iconst_1        
        //  116  236:ireturn         
                }

        //  117  237:iinc            11  1
        //  118  240:iload           11
        //  119  242:aload_0         
        //  120  243:getfield        #97  <Field FastVector m_shapes>
        //  121  246:invokevirtual   #194 <Method int FastVector.size()>
        //  122  249:icmplt          13
            }
            return false;
        //  123  252:iconst_0        
        //  124  253:ireturn         
        }

        private boolean inPolyline(FastVector ob, double x, double y)
        {
            int countx = 0;
        //    0    0:iconst_0        
        //    1    1:istore          6
            double y1;
            double y2;
            for(int noa = 1; noa < ob.size() - 4; noa += 2)
        //*   2    3:iconst_1        
        //*   3    4:istore          21
        //*   4    6:goto            343
            {
                y1 = ((Double)ob.elementAt(noa + 1)).doubleValue();
        //    5    9:aload_1         
        //    6   10:iload           21
        //    7   12:iconst_1        
        //    8   13:iadd            
        //    9   14:invokevirtual   #201 <Method Object FastVector.elementAt(int)>
        //   10   17:checkcast       #228 <Class Double>
        //   11   20:invokevirtual   #235 <Method double Double.doubleValue()>
        //   12   23:dstore          15
                y2 = ((Double)ob.elementAt(noa + 3)).doubleValue();
        //   13   25:aload_1         
        //   14   26:iload           21
        //   15   28:iconst_3        
        //   16   29:iadd            
        //   17   30:invokevirtual   #201 <Method Object FastVector.elementAt(int)>
        //   18   33:checkcast       #228 <Class Double>
        //   19   36:invokevirtual   #235 <Method double Double.doubleValue()>
        //   20   39:dstore          19
                double x1 = ((Double)ob.elementAt(noa)).doubleValue();
        //   21   41:aload_1         
        //   22   42:iload           21
        //   23   44:invokevirtual   #201 <Method Object FastVector.elementAt(int)>
        //   24   47:checkcast       #228 <Class Double>
        //   25   50:invokevirtual   #235 <Method double Double.doubleValue()>
        //   26   53:dstore          13
                double x2 = ((Double)ob.elementAt(noa + 2)).doubleValue();
        //   27   55:aload_1         
        //   28   56:iload           21
        //   29   58:iconst_2        
        //   30   59:iadd            
        //   31   60:invokevirtual   #201 <Method Object FastVector.elementAt(int)>
        //   32   63:checkcast       #228 <Class Double>
        //   33   66:invokevirtual   #235 <Method double Double.doubleValue()>
        //   34   69:dstore          17
                double vecy = y2 - y1;
        //   35   71:dload           19
        //   36   73:dload           15
        //   37   75:dsub            
        //   38   76:dstore          9
                double vecx = x2 - x1;
        //   39   78:dload           17
        //   40   80:dload           13
        //   41   82:dsub            
        //   42   83:dstore          7
                if(noa == 1 && noa == ob.size() - 6)
        //*  43   85:iload           21
        //*  44   87:iconst_1        
        //*  45   88:icmpne          139
        //*  46   91:iload           21
        //*  47   93:aload_1         
        //*  48   94:invokevirtual   #194 <Method int FastVector.size()>
        //*  49   97:bipush          6
        //*  50   99:isub            
        //*  51  100:icmpne          139
                {
                    if(vecy != 0.0D)
        //*  52  103:dload           9
        //*  53  105:dconst_0        
        //*  54  106:dcmpl           
        //*  55  107:ifeq            340
                    {
                        double change = (y - y1) / vecy;
        //   56  110:dload           4
        //   57  112:dload           15
        //   58  114:dsub            
        //   59  115:dload           9
        //   60  117:ddiv            
        //   61  118:dstore          11
                        if(vecx * change + x1 >= x)
        //*  62  120:dload           7
        //*  63  122:dload           11
        //*  64  124:dmul            
        //*  65  125:dload           13
        //*  66  127:dadd            
        //*  67  128:dload_2         
        //*  68  129:dcmpl           
        //*  69  130:iflt            340
                            countx++;
        //   70  133:iinc            6  1
                    }
                } else
        //*  71  136:goto            340
                if(noa == 1)
        //*  72  139:iload           21
        //*  73  141:iconst_1        
        //*  74  142:icmpne          204
                {
                    if(y < y2 && vecy > 0.0D || y > y2 && vecy < 0.0D)
        //*  75  145:dload           4
        //*  76  147:dload           19
        //*  77  149:dcmpg           
        //*  78  150:ifge            160
        //*  79  153:dload           9
        //*  80  155:dconst_0        
        //*  81  156:dcmpl           
        //*  82  157:ifgt            175
        //*  83  160:dload           4
        //*  84  162:dload           19
        //*  85  164:dcmpl           
        //*  86  165:ifle            340
        //*  87  168:dload           9
        //*  88  170:dconst_0        
        //*  89  171:dcmpg           
        //*  90  172:ifge            340
                    {
                        double change = (y - y1) / vecy;
        //   91  175:dload           4
        //   92  177:dload           15
        //   93  179:dsub            
        //   94  180:dload           9
        //   95  182:ddiv            
        //   96  183:dstore          11
                        if(vecx * change + x1 >= x)
        //*  97  185:dload           7
        //*  98  187:dload           11
        //*  99  189:dmul            
        //* 100  190:dload           13
        //* 101  192:dadd            
        //* 102  193:dload_2         
        //* 103  194:dcmpl           
        //* 104  195:iflt            340
                            countx++;
        //  105  198:iinc            6  1
                    }
                } else
        //* 106  201:goto            340
                if(noa == ob.size() - 6)
        //* 107  204:iload           21
        //* 108  206:aload_1         
        //* 109  207:invokevirtual   #194 <Method int FastVector.size()>
        //* 110  210:bipush          6
        //* 111  212:isub            
        //* 112  213:icmpne          275
                {
                    if(y <= y1 && vecy < 0.0D || y >= y1 && vecy > 0.0D)
        //* 113  216:dload           4
        //* 114  218:dload           15
        //* 115  220:dcmpg           
        //* 116  221:ifgt            231
        //* 117  224:dload           9
        //* 118  226:dconst_0        
        //* 119  227:dcmpg           
        //* 120  228:iflt            246
        //* 121  231:dload           4
        //* 122  233:dload           15
        //* 123  235:dcmpl           
        //* 124  236:iflt            340
        //* 125  239:dload           9
        //* 126  241:dconst_0        
        //* 127  242:dcmpl           
        //* 128  243:ifle            340
                    {
                        double change = (y - y1) / vecy;
        //  129  246:dload           4
        //  130  248:dload           15
        //  131  250:dsub            
        //  132  251:dload           9
        //  133  253:ddiv            
        //  134  254:dstore          11
                        if(vecx * change + x1 >= x)
        //* 135  256:dload           7
        //* 136  258:dload           11
        //* 137  260:dmul            
        //* 138  261:dload           13
        //* 139  263:dadd            
        //* 140  264:dload_2         
        //* 141  265:dcmpl           
        //* 142  266:iflt            340
                            countx++;
        //  143  269:iinc            6  1
                    }
                } else
        //* 144  272:goto            340
                if((y1 <= y && y < y2 || y2 < y && y <= y1) && vecy != 0.0D)
        //* 145  275:dload           15
        //* 146  277:dload           4
        //* 147  279:dcmpg           
        //* 148  280:ifgt            291
        //* 149  283:dload           4
        //* 150  285:dload           19
        //* 151  287:dcmpg           
        //* 152  288:iflt            307
        //* 153  291:dload           19
        //* 154  293:dload           4
        //* 155  295:dcmpg           
        //* 156  296:ifge            340
        //* 157  299:dload           4
        //* 158  301:dload           15
        //* 159  303:dcmpg           
        //* 160  304:ifgt            340
        //* 161  307:dload           9
        //* 162  309:dconst_0        
        //* 163  310:dcmpl           
        //* 164  311:ifeq            340
                {
                    double change = (y - y1) / vecy;
        //  165  314:dload           4
        //  166  316:dload           15
        //  167  318:dsub            
        //  168  319:dload           9
        //  169  321:ddiv            
        //  170  322:dstore          11
                    if(vecx * change + x1 >= x)
        //* 171  324:dload           7
        //* 172  326:dload           11
        //* 173  328:dmul            
        //* 174  329:dload           13
        //* 175  331:dadd            
        //* 176  332:dload_2         
        //* 177  333:dcmpl           
        //* 178  334:iflt            340
                        countx++;
        //  179  337:iinc            6  1
                }
            }

        //  180  340:iinc            21  2
        //  181  343:iload           21
        //  182  345:aload_1         
        //  183  346:invokevirtual   #194 <Method int FastVector.size()>
        //  184  349:iconst_4        
        //  185  350:isub            
        //  186  351:icmplt          9
            y1 = ((Double)ob.elementAt(ob.size() - 2)).doubleValue();
        //  187  354:aload_1         
        //  188  355:aload_1         
        //  189  356:invokevirtual   #194 <Method int FastVector.size()>
        //  190  359:iconst_2        
        //  191  360:isub            
        //  192  361:invokevirtual   #201 <Method Object FastVector.elementAt(int)>
        //  193  364:checkcast       #228 <Class Double>
        //  194  367:invokevirtual   #235 <Method double Double.doubleValue()>
        //  195  370:dstore          15
            y2 = ((Double)ob.elementAt(ob.size() - 1)).doubleValue();
        //  196  372:aload_1         
        //  197  373:aload_1         
        //  198  374:invokevirtual   #194 <Method int FastVector.size()>
        //  199  377:iconst_1        
        //  200  378:isub            
        //  201  379:invokevirtual   #201 <Method Object FastVector.elementAt(int)>
        //  202  382:checkcast       #228 <Class Double>
        //  203  385:invokevirtual   #235 <Method double Double.doubleValue()>
        //  204  388:dstore          19
            if(y1 > y2)
        //* 205  390:dload           15
        //* 206  392:dload           19
        //* 207  394:dcmpl           
        //* 208  395:ifle            420
            {
                if(y1 >= y && y > y2)
        //* 209  398:dload           15
        //* 210  400:dload           4
        //* 211  402:dcmpl           
        //* 212  403:iflt            439
        //* 213  406:dload           4
        //* 214  408:dload           19
        //* 215  410:dcmpl           
        //* 216  411:ifle            439
                    countx++;
        //  217  414:iinc            6  1
            } else
        //* 218  417:goto            439
            if(y1 >= y || y > y2)
        //* 219  420:dload           15
        //* 220  422:dload           4
        //* 221  424:dcmpl           
        //* 222  425:ifge            436
        //* 223  428:dload           4
        //* 224  430:dload           19
        //* 225  432:dcmpl           
        //* 226  433:ifle            439
                countx++;
        //  227  436:iinc            6  1
            return countx % 2 == 1;
        //  228  439:iload           6
        //  229  441:iconst_2        
        //  230  442:irem            
        //  231  443:iconst_1        
        //  232  444:icmpne          449
        //  233  447:iconst_1        
        //  234  448:ireturn         
        //  235  449:iconst_0        
        //  236  450:ireturn         
        }

        private boolean inPoly(FastVector ob, double x, double y)
        {
            int count = 0;
        //    0    0:iconst_0        
        //    1    1:istore          6
            for(int noa = 1; noa < ob.size() - 2; noa += 2)
        //*   2    3:iconst_1        
        //*   3    4:istore          21
        //*   4    6:goto            153
            {
                double y1 = ((Double)ob.elementAt(noa + 1)).doubleValue();
        //    5    9:aload_1         
        //    6   10:iload           21
        //    7   12:iconst_1        
        //    8   13:iadd            
        //    9   14:invokevirtual   #201 <Method Object FastVector.elementAt(int)>
        //   10   17:checkcast       #228 <Class Double>
        //   11   20:invokevirtual   #235 <Method double Double.doubleValue()>
        //   12   23:dstore          15
                double y2 = ((Double)ob.elementAt(noa + 3)).doubleValue();
        //   13   25:aload_1         
        //   14   26:iload           21
        //   15   28:iconst_3        
        //   16   29:iadd            
        //   17   30:invokevirtual   #201 <Method Object FastVector.elementAt(int)>
        //   18   33:checkcast       #228 <Class Double>
        //   19   36:invokevirtual   #235 <Method double Double.doubleValue()>
        //   20   39:dstore          19
                if(y1 <= y && y < y2 || y2 < y && y <= y1)
        //*  21   41:dload           15
        //*  22   43:dload           4
        //*  23   45:dcmpg           
        //*  24   46:ifgt            57
        //*  25   49:dload           4
        //*  26   51:dload           19
        //*  27   53:dcmpg           
        //*  28   54:iflt            73
        //*  29   57:dload           19
        //*  30   59:dload           4
        //*  31   61:dcmpg           
        //*  32   62:ifge            150
        //*  33   65:dload           4
        //*  34   67:dload           15
        //*  35   69:dcmpg           
        //*  36   70:ifgt            150
                {
                    double vecy = y2 - y1;
        //   37   73:dload           19
        //   38   75:dload           15
        //   39   77:dsub            
        //   40   78:dstore          9
                    if(vecy != 0.0D)
        //*  41   80:dload           9
        //*  42   82:dconst_0        
        //*  43   83:dcmpl           
        //*  44   84:ifeq            150
                    {
                        double x1 = ((Double)ob.elementAt(noa)).doubleValue();
        //   45   87:aload_1         
        //   46   88:iload           21
        //   47   90:invokevirtual   #201 <Method Object FastVector.elementAt(int)>
        //   48   93:checkcast       #228 <Class Double>
        //   49   96:invokevirtual   #235 <Method double Double.doubleValue()>
        //   50   99:dstore          13
                        double x2 = ((Double)ob.elementAt(noa + 2)).doubleValue();
        //   51  101:aload_1         
        //   52  102:iload           21
        //   53  104:iconst_2        
        //   54  105:iadd            
        //   55  106:invokevirtual   #201 <Method Object FastVector.elementAt(int)>
        //   56  109:checkcast       #228 <Class Double>
        //   57  112:invokevirtual   #235 <Method double Double.doubleValue()>
        //   58  115:dstore          17
                        double vecx = x2 - x1;
        //   59  117:dload           17
        //   60  119:dload           13
        //   61  121:dsub            
        //   62  122:dstore          7
                        double change = (y - y1) / vecy;
        //   63  124:dload           4
        //   64  126:dload           15
        //   65  128:dsub            
        //   66  129:dload           9
        //   67  131:ddiv            
        //   68  132:dstore          11
                        if(vecx * change + x1 >= x)
        //*  69  134:dload           7
        //*  70  136:dload           11
        //*  71  138:dmul            
        //*  72  139:dload           13
        //*  73  141:dadd            
        //*  74  142:dload_2         
        //*  75  143:dcmpl           
        //*  76  144:iflt            150
                            count++;
        //   77  147:iinc            6  1
                    }
                }
            }

        //   78  150:iinc            21  2
        //   79  153:iload           21
        //   80  155:aload_1         
        //   81  156:invokevirtual   #194 <Method int FastVector.size()>
        //   82  159:iconst_2        
        //   83  160:isub            
        //   84  161:icmplt          9
            return count % 2 == 1;
        //   85  164:iload           6
        //   86  166:iconst_2        
        //   87  167:irem            
        //   88  168:iconst_1        
        //   89  169:icmpne          174
        //   90  172:iconst_1        
        //   91  173:ireturn         
        //   92  174:iconst_0        
        //   93  175:ireturn         
        }

        public void setJitter(int j)
        {
            m_plot2D.setJitter(j);
        //    0    0:aload_0         
        //    1    1:getfield        #48  <Field Plot2D m_plot2D>
        //    2    4:iload_1         
        //    3    5:invokevirtual   #264 <Method void Plot2D.setJitter(int)>
        //    4    8:return          
        }

        public void setXindex(int x)
        {
            if(x != m_xIndex)
        //*   0    0:iload_1         
        //*   1    1:aload_0         
        //*   2    2:getfield        #54  <Field int m_xIndex>
        //*   3    5:icmpeq          12
                cancelShapes();
        //    4    8:aload_0         
        //    5    9:invokevirtual   #268 <Method void cancelShapes()>
            m_xIndex = x;
        //    6   12:aload_0         
        //    7   13:iload_1         
        //    8   14:putfield        #54  <Field int m_xIndex>
            m_plot2D.setXindex(x);
        //    9   17:aload_0         
        //   10   18:getfield        #48  <Field Plot2D m_plot2D>
        //   11   21:iload_1         
        //   12   22:invokevirtual   #270 <Method void Plot2D.setXindex(int)>
            if(m_showAttBars)
        //*  13   25:aload_0         
        //*  14   26:getfield        #40  <Field VisualizePanel this$0>
        //*  15   29:getfield        #273 <Field boolean VisualizePanel.m_showAttBars>
        //*  16   32:ifeq            46
                m_attrib.setX(x);
        //   17   35:aload_0         
        //   18   36:getfield        #40  <Field VisualizePanel this$0>
        //   19   39:getfield        #277 <Field AttributePanel VisualizePanel.m_attrib>
        //   20   42:iload_1         
        //   21   43:invokevirtual   #282 <Method void AttributePanel.setX(int)>
        //   22   46:return          
        }

        public void setYindex(int y)
        {
            if(y != m_yIndex)
        //*   0    0:iload_1         
        //*   1    1:aload_0         
        //*   2    2:getfield        #56  <Field int m_yIndex>
        //*   3    5:icmpeq          12
                cancelShapes();
        //    4    8:aload_0         
        //    5    9:invokevirtual   #268 <Method void cancelShapes()>
            m_yIndex = y;
        //    6   12:aload_0         
        //    7   13:iload_1         
        //    8   14:putfield        #56  <Field int m_yIndex>
            m_plot2D.setYindex(y);
        //    9   17:aload_0         
        //   10   18:getfield        #48  <Field Plot2D m_plot2D>
        //   11   21:iload_1         
        //   12   22:invokevirtual   #285 <Method void Plot2D.setYindex(int)>
            if(m_showAttBars)
        //*  13   25:aload_0         
        //*  14   26:getfield        #40  <Field VisualizePanel this$0>
        //*  15   29:getfield        #273 <Field boolean VisualizePanel.m_showAttBars>
        //*  16   32:ifeq            46
                m_attrib.setY(y);
        //   17   35:aload_0         
        //   18   36:getfield        #40  <Field VisualizePanel this$0>
        //   19   39:getfield        #277 <Field AttributePanel VisualizePanel.m_attrib>
        //   20   42:iload_1         
        //   21   43:invokevirtual   #288 <Method void AttributePanel.setY(int)>
        //   22   46:return          
        }

        public void setCindex(int c)
        {
            m_cIndex = c;
        //    0    0:aload_0         
        //    1    1:iload_1         
        //    2    2:putfield        #58  <Field int m_cIndex>
            m_plot2D.setCindex(c);
        //    3    5:aload_0         
        //    4    6:getfield        #48  <Field Plot2D m_plot2D>
        //    5    9:iload_1         
        //    6   10:invokevirtual   #291 <Method void Plot2D.setCindex(int)>
            if(m_showAttBars)
        //*   7   13:aload_0         
        //*   8   14:getfield        #40  <Field VisualizePanel this$0>
        //*   9   17:getfield        #273 <Field boolean VisualizePanel.m_showAttBars>
        //*  10   20:ifeq            48
                m_attrib.setCindex(c, m_plot2D.getMaxC(), m_plot2D.getMinC());
        //   11   23:aload_0         
        //   12   24:getfield        #40  <Field VisualizePanel this$0>
        //   13   27:getfield        #277 <Field AttributePanel VisualizePanel.m_attrib>
        //   14   30:iload_1         
        //   15   31:aload_0         
        //   16   32:getfield        #48  <Field Plot2D m_plot2D>
        //   17   35:invokevirtual   #294 <Method double Plot2D.getMaxC()>
        //   18   38:aload_0         
        //   19   39:getfield        #48  <Field Plot2D m_plot2D>
        //   20   42:invokevirtual   #297 <Method double Plot2D.getMinC()>
        //   21   45:invokevirtual   #300 <Method void AttributePanel.setCindex(int, double, double)>
            m_classPanel.setCindex(c);
        //   22   48:aload_0         
        //   23   49:getfield        #40  <Field VisualizePanel this$0>
        //   24   52:getfield        #304 <Field ClassPanel VisualizePanel.m_classPanel>
        //   25   55:iload_1         
        //   26   56:invokevirtual   #307 <Method void ClassPanel.setCindex(int)>
            repaint();
        //   27   59:aload_0         
        //   28   60:invokevirtual   #187 <Method void repaint()>
        //   29   63:return          
        }

        public void setSindex(int s)
        {
            if(s != m_sIndex)
        //*   0    0:iload_1         
        //*   1    1:aload_0         
        //*   2    2:getfield        #60  <Field int m_sIndex>
        //*   3    5:icmpeq          18
            {
                m_shapePoints = null;
        //    4    8:aload_0         
        //    5    9:aconst_null     
        //    6   10:putfield        #99  <Field FastVector m_shapePoints>
                m_createShape = false;
        //    7   13:aload_0         
        //    8   14:iconst_0        
        //    9   15:putfield        #95  <Field boolean m_createShape>
            }
            m_sIndex = s;
        //   10   18:aload_0         
        //   11   19:iload_1         
        //   12   20:putfield        #60  <Field int m_sIndex>
            repaint();
        //   13   23:aload_0         
        //   14   24:invokevirtual   #187 <Method void repaint()>
        //   15   27:return          
        }

        public void setMasterPlot(PlotData2D newPlot)
            throws Exception
        {
            m_plot2D.removeAllPlots();
        //    0    0:aload_0         
        //    1    1:getfield        #48  <Field Plot2D m_plot2D>
        //    2    4:invokevirtual   #148 <Method void Plot2D.removeAllPlots()>
            addPlot(newPlot);
        //    3    7:aload_0         
        //    4    8:aload_1         
        //    5    9:invokevirtual   #318 <Method void addPlot(PlotData2D)>
        //    6   12:return          
        }

        public void addPlot(PlotData2D newPlot)
            throws Exception
        {
            if(m_plot2D.getPlots().size() == 0)
        //*   0    0:aload_0         
        //*   1    1:getfield        #48  <Field Plot2D m_plot2D>
        //*   2    4:invokevirtual   #156 <Method FastVector Plot2D.getPlots()>
        //*   3    7:invokevirtual   #194 <Method int FastVector.size()>
        //*   4   10:ifne            436
            {
                m_plot2D.addPlot(newPlot);
        //    5   13:aload_0         
        //    6   14:getfield        #48  <Field Plot2D m_plot2D>
        //    7   17:aload_1         
        //    8   18:invokevirtual   #320 <Method void Plot2D.addPlot(PlotData2D)>
                if(m_plotSurround.getComponentCount() > 1 && m_plotSurround.getComponent(1) == m_attrib && m_showAttBars)
        //*   9   21:aload_0         
        //*  10   22:getfield        #40  <Field VisualizePanel this$0>
        //*  11   25:getfield        #324 <Field JPanel VisualizePanel.m_plotSurround>
        //*  12   28:invokevirtual   #329 <Method int JPanel.getComponentCount()>
        //*  13   31:iconst_1        
        //*  14   32:icmple          171
        //*  15   35:aload_0         
        //*  16   36:getfield        #40  <Field VisualizePanel this$0>
        //*  17   39:getfield        #324 <Field JPanel VisualizePanel.m_plotSurround>
        //*  18   42:iconst_1        
        //*  19   43:invokevirtual   #333 <Method Component JPanel.getComponent(int)>
        //*  20   46:aload_0         
        //*  21   47:getfield        #40  <Field VisualizePanel this$0>
        //*  22   50:getfield        #277 <Field AttributePanel VisualizePanel.m_attrib>
        //*  23   53:if_acmpne       171
        //*  24   56:aload_0         
        //*  25   57:getfield        #40  <Field VisualizePanel this$0>
        //*  26   60:getfield        #273 <Field boolean VisualizePanel.m_showAttBars>
        //*  27   63:ifeq            171
                    try
                    {
                        m_attrib.setInstances(newPlot.m_plotInstances);
        //   28   66:aload_0         
        //   29   67:getfield        #40  <Field VisualizePanel this$0>
        //   30   70:getfield        #277 <Field AttributePanel VisualizePanel.m_attrib>
        //   31   73:aload_1         
        //   32   74:getfield        #180 <Field Instances PlotData2D.m_plotInstances>
        //   33   77:invokevirtual   #337 <Method void AttributePanel.setInstances(Instances)>
                        m_attrib.setCindex(0);
        //   34   80:aload_0         
        //   35   81:getfield        #40  <Field VisualizePanel this$0>
        //   36   84:getfield        #277 <Field AttributePanel VisualizePanel.m_attrib>
        //   37   87:iconst_0        
        //   38   88:invokevirtual   #338 <Method void AttributePanel.setCindex(int)>
                        m_attrib.setX(0);
        //   39   91:aload_0         
        //   40   92:getfield        #40  <Field VisualizePanel this$0>
        //   41   95:getfield        #277 <Field AttributePanel VisualizePanel.m_attrib>
        //   42   98:iconst_0        
        //   43   99:invokevirtual   #282 <Method void AttributePanel.setX(int)>
                        m_attrib.setY(0);
        //   44  102:aload_0         
        //   45  103:getfield        #40  <Field VisualizePanel this$0>
        //   46  106:getfield        #277 <Field AttributePanel VisualizePanel.m_attrib>
        //   47  109:iconst_0        
        //   48  110:invokevirtual   #288 <Method void AttributePanel.setY(int)>
                    }
        //*  49  113:goto            344
                    catch(Exception ex)
        //*  50  116:astore_2        
                    {
                        m_plotSurround.remove(m_attrib);
        //   51  117:aload_0         
        //   52  118:getfield        #40  <Field VisualizePanel this$0>
        //   53  121:getfield        #324 <Field JPanel VisualizePanel.m_plotSurround>
        //   54  124:aload_0         
        //   55  125:getfield        #40  <Field VisualizePanel this$0>
        //   56  128:getfield        #277 <Field AttributePanel VisualizePanel.m_attrib>
        //   57  131:invokevirtual   #342 <Method void JPanel.remove(Component)>
                        System.err.println("Warning : data contains more attributes than can be displayed as attribute bars.");
        //   58  134:getstatic       #348 <Field PrintStream System.err>
        //   59  137:ldc2            #350 <String "Warning : data contains more attributes than can be displayed as attribute bars.">
        //   60  140:invokevirtual   #355 <Method void PrintStream.println(String)>
                        if(m_Log != null)
        //*  61  143:aload_0         
        //*  62  144:getfield        #40  <Field VisualizePanel this$0>
        //*  63  147:getfield        #359 <Field Logger VisualizePanel.m_Log>
        //*  64  150:ifnull          344
                            m_Log.logMessage("Warning : data contains more attributes than can be displayed as attribute bars.");
        //   65  153:aload_0         
        //   66  154:getfield        #40  <Field VisualizePanel this$0>
        //   67  157:getfield        #359 <Field Logger VisualizePanel.m_Log>
        //   68  160:ldc2            #350 <String "Warning : data contains more attributes than can be displayed as attribute bars.">
        //   69  163:invokeinterface #364 <Method void Logger.logMessage(String)>
                    }
                else
        //*  70  168:goto            344
                if(m_showAttBars)
        //*  71  171:aload_0         
        //*  72  172:getfield        #40  <Field VisualizePanel this$0>
        //*  73  175:getfield        #273 <Field boolean VisualizePanel.m_showAttBars>
        //*  74  178:ifeq            344
                    try
                    {
                        m_attrib.setInstances(newPlot.m_plotInstances);
        //   75  181:aload_0         
        //   76  182:getfield        #40  <Field VisualizePanel this$0>
        //   77  185:getfield        #277 <Field AttributePanel VisualizePanel.m_attrib>
        //   78  188:aload_1         
        //   79  189:getfield        #180 <Field Instances PlotData2D.m_plotInstances>
        //   80  192:invokevirtual   #337 <Method void AttributePanel.setInstances(Instances)>
                        m_attrib.setCindex(0);
        //   81  195:aload_0         
        //   82  196:getfield        #40  <Field VisualizePanel this$0>
        //   83  199:getfield        #277 <Field AttributePanel VisualizePanel.m_attrib>
        //   84  202:iconst_0        
        //   85  203:invokevirtual   #338 <Method void AttributePanel.setCindex(int)>
                        m_attrib.setX(0);
        //   86  206:aload_0         
        //   87  207:getfield        #40  <Field VisualizePanel this$0>
        //   88  210:getfield        #277 <Field AttributePanel VisualizePanel.m_attrib>
        //   89  213:iconst_0        
        //   90  214:invokevirtual   #282 <Method void AttributePanel.setX(int)>
                        m_attrib.setY(0);
        //   91  217:aload_0         
        //   92  218:getfield        #40  <Field VisualizePanel this$0>
        //   93  221:getfield        #277 <Field AttributePanel VisualizePanel.m_attrib>
        //   94  224:iconst_0        
        //   95  225:invokevirtual   #288 <Method void AttributePanel.setY(int)>
                        GridBagConstraints constraints = new GridBagConstraints();
        //   96  228:new             #366 <Class GridBagConstraints>
        //   97  231:dup             
        //   98  232:invokespecial   #367 <Method void GridBagConstraints()>
        //   99  235:astore_2        
                        constraints.fill = 1;
        //  100  236:aload_2         
        //  101  237:iconst_1        
        //  102  238:putfield        #370 <Field int GridBagConstraints.fill>
                        constraints.insets = new Insets(0, 0, 0, 0);
        //  103  241:aload_2         
        //  104  242:new             #372 <Class Insets>
        //  105  245:dup             
        //  106  246:iconst_0        
        //  107  247:iconst_0        
        //  108  248:iconst_0        
        //  109  249:iconst_0        
        //  110  250:invokespecial   #375 <Method void Insets(int, int, int, int)>
        //  111  253:putfield        #379 <Field Insets GridBagConstraints.insets>
                        constraints.gridx = 4;
        //  112  256:aload_2         
        //  113  257:iconst_4        
        //  114  258:putfield        #382 <Field int GridBagConstraints.gridx>
                        constraints.gridy = 0;
        //  115  261:aload_2         
        //  116  262:iconst_0        
        //  117  263:putfield        #385 <Field int GridBagConstraints.gridy>
                        constraints.weightx = 1.0D;
        //  118  266:aload_2         
        //  119  267:dconst_1        
        //  120  268:putfield        #388 <Field double GridBagConstraints.weightx>
                        constraints.gridwidth = 1;
        //  121  271:aload_2         
        //  122  272:iconst_1        
        //  123  273:putfield        #391 <Field int GridBagConstraints.gridwidth>
                        constraints.gridheight = 1;
        //  124  276:aload_2         
        //  125  277:iconst_1        
        //  126  278:putfield        #394 <Field int GridBagConstraints.gridheight>
                        constraints.weighty = 5D;
        //  127  281:aload_2         
        //  128  282:ldc2w           #395 <Double 5D>
        //  129  285:putfield        #399 <Field double GridBagConstraints.weighty>
                        m_plotSurround.add(m_attrib, constraints);
        //  130  288:aload_0         
        //  131  289:getfield        #40  <Field VisualizePanel this$0>
        //  132  292:getfield        #324 <Field JPanel VisualizePanel.m_plotSurround>
        //  133  295:aload_0         
        //  134  296:getfield        #40  <Field VisualizePanel this$0>
        //  135  299:getfield        #277 <Field AttributePanel VisualizePanel.m_attrib>
        //  136  302:aload_2         
        //  137  303:invokevirtual   #400 <Method void JPanel.add(Component, Object)>
                    }
        //* 138  306:goto            344
                    catch(Exception ex)
        //* 139  309:astore_2        
                    {
                        System.err.println("Warning : data contains more attributes than can be displayed as attribute bars.");
        //  140  310:getstatic       #348 <Field PrintStream System.err>
        //  141  313:ldc2            #350 <String "Warning : data contains more attributes than can be displayed as attribute bars.">
        //  142  316:invokevirtual   #355 <Method void PrintStream.println(String)>
                        if(m_Log != null)
        //* 143  319:aload_0         
        //* 144  320:getfield        #40  <Field VisualizePanel this$0>
        //* 145  323:getfield        #359 <Field Logger VisualizePanel.m_Log>
        //* 146  326:ifnull          344
                            m_Log.logMessage("Warning : data contains more attributes than can be displayed as attribute bars.");
        //  147  329:aload_0         
        //  148  330:getfield        #40  <Field VisualizePanel this$0>
        //  149  333:getfield        #359 <Field Logger VisualizePanel.m_Log>
        //  150  336:ldc2            #350 <String "Warning : data contains more attributes than can be displayed as attribute bars.">
        //  151  339:invokeinterface #364 <Method void Logger.logMessage(String)>
                    }
                m_classPanel.setInstances(newPlot.m_plotInstances);
        //  152  344:aload_0         
        //  153  345:getfield        #40  <Field VisualizePanel this$0>
        //  154  348:getfield        #304 <Field ClassPanel VisualizePanel.m_classPanel>
        //  155  351:aload_1         
        //  156  352:getfield        #180 <Field Instances PlotData2D.m_plotInstances>
        //  157  355:invokevirtual   #401 <Method void ClassPanel.setInstances(Instances)>
                plotReset(newPlot.m_plotInstances, newPlot.getCindex());
        //  158  358:aload_0         
        //  159  359:aload_1         
        //  160  360:getfield        #180 <Field Instances PlotData2D.m_plotInstances>
        //  161  363:aload_1         
        //  162  364:invokevirtual   #404 <Method int PlotData2D.getCindex()>
        //  163  367:invokespecial   #408 <Method void plotReset(Instances, int)>
                if(newPlot.m_useCustomColour && m_showClassPanel)
        //* 164  370:aload_1         
        //* 165  371:getfield        #411 <Field boolean PlotData2D.m_useCustomColour>
        //* 166  374:ifeq            524
        //* 167  377:aload_0         
        //* 168  378:getfield        #40  <Field VisualizePanel this$0>
        //* 169  381:getfield        #414 <Field boolean VisualizePanel.m_showClassPanel>
        //* 170  384:ifeq            524
                {
                    remove(m_classSurround);
        //  171  387:aload_0         
        //  172  388:getfield        #40  <Field VisualizePanel this$0>
        //  173  391:aload_0         
        //  174  392:getfield        #40  <Field VisualizePanel this$0>
        //  175  395:getfield        #417 <Field JPanel VisualizePanel.m_classSurround>
        //  176  398:invokevirtual   #418 <Method void VisualizePanel.remove(Component)>
                    switchToLegend();
        //  177  401:aload_0         
        //  178  402:invokevirtual   #421 <Method void switchToLegend()>
                    m_legendPanel.setPlotList(m_plot2D.getPlots());
        //  179  405:aload_0         
        //  180  406:getfield        #40  <Field VisualizePanel this$0>
        //  181  409:getfield        #152 <Field LegendPanel VisualizePanel.m_legendPanel>
        //  182  412:aload_0         
        //  183  413:getfield        #48  <Field Plot2D m_plot2D>
        //  184  416:invokevirtual   #156 <Method FastVector Plot2D.getPlots()>
        //  185  419:invokevirtual   #162 <Method void LegendPanel.setPlotList(FastVector)>
                    m_ColourCombo.setEnabled(false);
        //  186  422:aload_0         
        //  187  423:getfield        #40  <Field VisualizePanel this$0>
        //  188  426:getfield        #425 <Field JComboBox VisualizePanel.m_ColourCombo>
        //  189  429:iconst_0        
        //  190  430:invokevirtual   #428 <Method void JComboBox.setEnabled(boolean)>
                }
            } else
        //* 191  433:goto            524
            {
                if(!newPlot.m_useCustomColour && m_showClassPanel)
        //* 192  436:aload_1         
        //* 193  437:getfield        #411 <Field boolean PlotData2D.m_useCustomColour>
        //* 194  440:ifne            481
        //* 195  443:aload_0         
        //* 196  444:getfield        #40  <Field VisualizePanel this$0>
        //* 197  447:getfield        #414 <Field boolean VisualizePanel.m_showClassPanel>
        //* 198  450:ifeq            481
                {
                    add(m_classSurround, "South");
        //  199  453:aload_0         
        //  200  454:getfield        #40  <Field VisualizePanel this$0>
        //  201  457:aload_0         
        //  202  458:getfield        #40  <Field VisualizePanel this$0>
        //  203  461:getfield        #417 <Field JPanel VisualizePanel.m_classSurround>
        //  204  464:ldc2            #430 <String "South">
        //  205  467:invokevirtual   #431 <Method void VisualizePanel.add(Component, Object)>
                    m_ColourCombo.setEnabled(true);
        //  206  470:aload_0         
        //  207  471:getfield        #40  <Field VisualizePanel this$0>
        //  208  474:getfield        #425 <Field JComboBox VisualizePanel.m_ColourCombo>
        //  209  477:iconst_1        
        //  210  478:invokevirtual   #428 <Method void JComboBox.setEnabled(boolean)>
                }
                if(m_plot2D.getPlots().size() == 1)
        //* 211  481:aload_0         
        //* 212  482:getfield        #48  <Field Plot2D m_plot2D>
        //* 213  485:invokevirtual   #156 <Method FastVector Plot2D.getPlots()>
        //* 214  488:invokevirtual   #194 <Method int FastVector.size()>
        //* 215  491:iconst_1        
        //* 216  492:icmpne          499
                    switchToLegend();
        //  217  495:aload_0         
        //  218  496:invokevirtual   #421 <Method void switchToLegend()>
                m_plot2D.addPlot(newPlot);
        //  219  499:aload_0         
        //  220  500:getfield        #48  <Field Plot2D m_plot2D>
        //  221  503:aload_1         
        //  222  504:invokevirtual   #320 <Method void Plot2D.addPlot(PlotData2D)>
                m_legendPanel.setPlotList(m_plot2D.getPlots());
        //  223  507:aload_0         
        //  224  508:getfield        #40  <Field VisualizePanel this$0>
        //  225  511:getfield        #152 <Field LegendPanel VisualizePanel.m_legendPanel>
        //  226  514:aload_0         
        //  227  515:getfield        #48  <Field Plot2D m_plot2D>
        //  228  518:invokevirtual   #156 <Method FastVector Plot2D.getPlots()>
        //  229  521:invokevirtual   #162 <Method void LegendPanel.setPlotList(FastVector)>
            }
        //  230  524:return          
        }

        protected void switchToLegend()
        {
            if(m_plotSurround.getComponentCount() > 1 && m_plotSurround.getComponent(1) == m_attrib)
        //*   0    0:aload_0         
        //*   1    1:getfield        #40  <Field VisualizePanel this$0>
        //*   2    4:getfield        #324 <Field JPanel VisualizePanel.m_plotSurround>
        //*   3    7:invokevirtual   #329 <Method int JPanel.getComponentCount()>
        //*   4   10:iconst_1        
        //*   5   11:icmple          52
        //*   6   14:aload_0         
        //*   7   15:getfield        #40  <Field VisualizePanel this$0>
        //*   8   18:getfield        #324 <Field JPanel VisualizePanel.m_plotSurround>
        //*   9   21:iconst_1        
        //*  10   22:invokevirtual   #333 <Method Component JPanel.getComponent(int)>
        //*  11   25:aload_0         
        //*  12   26:getfield        #40  <Field VisualizePanel this$0>
        //*  13   29:getfield        #277 <Field AttributePanel VisualizePanel.m_attrib>
        //*  14   32:if_acmpne       52
                m_plotSurround.remove(m_attrib);
        //   15   35:aload_0         
        //   16   36:getfield        #40  <Field VisualizePanel this$0>
        //   17   39:getfield        #324 <Field JPanel VisualizePanel.m_plotSurround>
        //   18   42:aload_0         
        //   19   43:getfield        #40  <Field VisualizePanel this$0>
        //   20   46:getfield        #277 <Field AttributePanel VisualizePanel.m_attrib>
        //   21   49:invokevirtual   #342 <Method void JPanel.remove(Component)>
            if(m_plotSurround.getComponentCount() > 1 && m_plotSurround.getComponent(1) == m_legendPanel)
        //*  22   52:aload_0         
        //*  23   53:getfield        #40  <Field VisualizePanel this$0>
        //*  24   56:getfield        #324 <Field JPanel VisualizePanel.m_plotSurround>
        //*  25   59:invokevirtual   #329 <Method int JPanel.getComponentCount()>
        //*  26   62:iconst_1        
        //*  27   63:icmple          88
        //*  28   66:aload_0         
        //*  29   67:getfield        #40  <Field VisualizePanel this$0>
        //*  30   70:getfield        #324 <Field JPanel VisualizePanel.m_plotSurround>
        //*  31   73:iconst_1        
        //*  32   74:invokevirtual   #333 <Method Component JPanel.getComponent(int)>
        //*  33   77:aload_0         
        //*  34   78:getfield        #40  <Field VisualizePanel this$0>
        //*  35   81:getfield        #152 <Field LegendPanel VisualizePanel.m_legendPanel>
        //*  36   84:if_acmpne       88
            {
                return;
        //   37   87:return          
            } else
            {
                GridBagConstraints constraints = new GridBagConstraints();
        //   38   88:new             #366 <Class GridBagConstraints>
        //   39   91:dup             
        //   40   92:invokespecial   #367 <Method void GridBagConstraints()>
        //   41   95:astore_1        
                constraints.fill = 1;
        //   42   96:aload_1         
        //   43   97:iconst_1        
        //   44   98:putfield        #370 <Field int GridBagConstraints.fill>
                constraints.insets = new Insets(0, 0, 0, 0);
        //   45  101:aload_1         
        //   46  102:new             #372 <Class Insets>
        //   47  105:dup             
        //   48  106:iconst_0        
        //   49  107:iconst_0        
        //   50  108:iconst_0        
        //   51  109:iconst_0        
        //   52  110:invokespecial   #375 <Method void Insets(int, int, int, int)>
        //   53  113:putfield        #379 <Field Insets GridBagConstraints.insets>
                constraints.gridx = 4;
        //   54  116:aload_1         
        //   55  117:iconst_4        
        //   56  118:putfield        #382 <Field int GridBagConstraints.gridx>
                constraints.gridy = 0;
        //   57  121:aload_1         
        //   58  122:iconst_0        
        //   59  123:putfield        #385 <Field int GridBagConstraints.gridy>
                constraints.weightx = 1.0D;
        //   60  126:aload_1         
        //   61  127:dconst_1        
        //   62  128:putfield        #388 <Field double GridBagConstraints.weightx>
                constraints.gridwidth = 1;
        //   63  131:aload_1         
        //   64  132:iconst_1        
        //   65  133:putfield        #391 <Field int GridBagConstraints.gridwidth>
                constraints.gridheight = 1;
        //   66  136:aload_1         
        //   67  137:iconst_1        
        //   68  138:putfield        #394 <Field int GridBagConstraints.gridheight>
                constraints.weighty = 5D;
        //   69  141:aload_1         
        //   70  142:ldc2w           #395 <Double 5D>
        //   71  145:putfield        #399 <Field double GridBagConstraints.weighty>
                m_plotSurround.add(m_legendPanel, constraints);
        //   72  148:aload_0         
        //   73  149:getfield        #40  <Field VisualizePanel this$0>
        //   74  152:getfield        #324 <Field JPanel VisualizePanel.m_plotSurround>
        //   75  155:aload_0         
        //   76  156:getfield        #40  <Field VisualizePanel this$0>
        //   77  159:getfield        #152 <Field LegendPanel VisualizePanel.m_legendPanel>
        //   78  162:aload_1         
        //   79  163:invokevirtual   #400 <Method void JPanel.add(Component, Object)>
                setSindex(0);
        //   80  166:aload_0         
        //   81  167:iconst_0        
        //   82  168:invokevirtual   #437 <Method void setSindex(int)>
                m_ShapeCombo.setEnabled(false);
        //   83  171:aload_0         
        //   84  172:getfield        #40  <Field VisualizePanel this$0>
        //   85  175:getfield        #440 <Field JComboBox VisualizePanel.m_ShapeCombo>
        //   86  178:iconst_0        
        //   87  179:invokevirtual   #428 <Method void JComboBox.setEnabled(boolean)>
                return;
        //   88  182:return          
            }
        }

        protected void switchToBars()
        {
            if(m_plotSurround.getComponentCount() > 1 && m_plotSurround.getComponent(1) == m_legendPanel)
        //*   0    0:aload_0         
        //*   1    1:getfield        #40  <Field VisualizePanel this$0>
        //*   2    4:getfield        #324 <Field JPanel VisualizePanel.m_plotSurround>
        //*   3    7:invokevirtual   #329 <Method int JPanel.getComponentCount()>
        //*   4   10:iconst_1        
        //*   5   11:icmple          52
        //*   6   14:aload_0         
        //*   7   15:getfield        #40  <Field VisualizePanel this$0>
        //*   8   18:getfield        #324 <Field JPanel VisualizePanel.m_plotSurround>
        //*   9   21:iconst_1        
        //*  10   22:invokevirtual   #333 <Method Component JPanel.getComponent(int)>
        //*  11   25:aload_0         
        //*  12   26:getfield        #40  <Field VisualizePanel this$0>
        //*  13   29:getfield        #152 <Field LegendPanel VisualizePanel.m_legendPanel>
        //*  14   32:if_acmpne       52
                m_plotSurround.remove(m_legendPanel);
        //   15   35:aload_0         
        //   16   36:getfield        #40  <Field VisualizePanel this$0>
        //   17   39:getfield        #324 <Field JPanel VisualizePanel.m_plotSurround>
        //   18   42:aload_0         
        //   19   43:getfield        #40  <Field VisualizePanel this$0>
        //   20   46:getfield        #152 <Field LegendPanel VisualizePanel.m_legendPanel>
        //   21   49:invokevirtual   #342 <Method void JPanel.remove(Component)>
            if(m_plotSurround.getComponentCount() > 1 && m_plotSurround.getComponent(1) == m_attrib)
        //*  22   52:aload_0         
        //*  23   53:getfield        #40  <Field VisualizePanel this$0>
        //*  24   56:getfield        #324 <Field JPanel VisualizePanel.m_plotSurround>
        //*  25   59:invokevirtual   #329 <Method int JPanel.getComponentCount()>
        //*  26   62:iconst_1        
        //*  27   63:icmple          88
        //*  28   66:aload_0         
        //*  29   67:getfield        #40  <Field VisualizePanel this$0>
        //*  30   70:getfield        #324 <Field JPanel VisualizePanel.m_plotSurround>
        //*  31   73:iconst_1        
        //*  32   74:invokevirtual   #333 <Method Component JPanel.getComponent(int)>
        //*  33   77:aload_0         
        //*  34   78:getfield        #40  <Field VisualizePanel this$0>
        //*  35   81:getfield        #277 <Field AttributePanel VisualizePanel.m_attrib>
        //*  36   84:if_acmpne       88
                return;
        //   37   87:return          
            if(m_showAttBars)
        //*  38   88:aload_0         
        //*  39   89:getfield        #40  <Field VisualizePanel this$0>
        //*  40   92:getfield        #273 <Field boolean VisualizePanel.m_showAttBars>
        //*  41   95:ifeq            267
                try
                {
                    m_attrib.setInstances(m_plot2D.getMasterPlot().m_plotInstances);
        //   42   98:aload_0         
        //   43   99:getfield        #40  <Field VisualizePanel this$0>
        //   44  102:getfield        #277 <Field AttributePanel VisualizePanel.m_attrib>
        //   45  105:aload_0         
        //   46  106:getfield        #48  <Field Plot2D m_plot2D>
        //   47  109:invokevirtual   #445 <Method PlotData2D Plot2D.getMasterPlot()>
        //   48  112:getfield        #180 <Field Instances PlotData2D.m_plotInstances>
        //   49  115:invokevirtual   #337 <Method void AttributePanel.setInstances(Instances)>
                    m_attrib.setCindex(0);
        //   50  118:aload_0         
        //   51  119:getfield        #40  <Field VisualizePanel this$0>
        //   52  122:getfield        #277 <Field AttributePanel VisualizePanel.m_attrib>
        //   53  125:iconst_0        
        //   54  126:invokevirtual   #338 <Method void AttributePanel.setCindex(int)>
                    m_attrib.setX(0);
        //   55  129:aload_0         
        //   56  130:getfield        #40  <Field VisualizePanel this$0>
        //   57  133:getfield        #277 <Field AttributePanel VisualizePanel.m_attrib>
        //   58  136:iconst_0        
        //   59  137:invokevirtual   #282 <Method void AttributePanel.setX(int)>
                    m_attrib.setY(0);
        //   60  140:aload_0         
        //   61  141:getfield        #40  <Field VisualizePanel this$0>
        //   62  144:getfield        #277 <Field AttributePanel VisualizePanel.m_attrib>
        //   63  147:iconst_0        
        //   64  148:invokevirtual   #288 <Method void AttributePanel.setY(int)>
                    GridBagConstraints constraints = new GridBagConstraints();
        //   65  151:new             #366 <Class GridBagConstraints>
        //   66  154:dup             
        //   67  155:invokespecial   #367 <Method void GridBagConstraints()>
        //   68  158:astore_1        
                    constraints.fill = 1;
        //   69  159:aload_1         
        //   70  160:iconst_1        
        //   71  161:putfield        #370 <Field int GridBagConstraints.fill>
                    constraints.insets = new Insets(0, 0, 0, 0);
        //   72  164:aload_1         
        //   73  165:new             #372 <Class Insets>
        //   74  168:dup             
        //   75  169:iconst_0        
        //   76  170:iconst_0        
        //   77  171:iconst_0        
        //   78  172:iconst_0        
        //   79  173:invokespecial   #375 <Method void Insets(int, int, int, int)>
        //   80  176:putfield        #379 <Field Insets GridBagConstraints.insets>
                    constraints.gridx = 4;
        //   81  179:aload_1         
        //   82  180:iconst_4        
        //   83  181:putfield        #382 <Field int GridBagConstraints.gridx>
                    constraints.gridy = 0;
        //   84  184:aload_1         
        //   85  185:iconst_0        
        //   86  186:putfield        #385 <Field int GridBagConstraints.gridy>
                    constraints.weightx = 1.0D;
        //   87  189:aload_1         
        //   88  190:dconst_1        
        //   89  191:putfield        #388 <Field double GridBagConstraints.weightx>
                    constraints.gridwidth = 1;
        //   90  194:aload_1         
        //   91  195:iconst_1        
        //   92  196:putfield        #391 <Field int GridBagConstraints.gridwidth>
                    constraints.gridheight = 1;
        //   93  199:aload_1         
        //   94  200:iconst_1        
        //   95  201:putfield        #394 <Field int GridBagConstraints.gridheight>
                    constraints.weighty = 5D;
        //   96  204:aload_1         
        //   97  205:ldc2w           #395 <Double 5D>
        //   98  208:putfield        #399 <Field double GridBagConstraints.weighty>
                    m_plotSurround.add(m_attrib, constraints);
        //   99  211:aload_0         
        //  100  212:getfield        #40  <Field VisualizePanel this$0>
        //  101  215:getfield        #324 <Field JPanel VisualizePanel.m_plotSurround>
        //  102  218:aload_0         
        //  103  219:getfield        #40  <Field VisualizePanel this$0>
        //  104  222:getfield        #277 <Field AttributePanel VisualizePanel.m_attrib>
        //  105  225:aload_1         
        //  106  226:invokevirtual   #400 <Method void JPanel.add(Component, Object)>
                }
        //* 107  229:goto            267
                catch(Exception ex)
        //* 108  232:astore_1        
                {
                    System.err.println("Warning : data contains more attributes than can be displayed as attribute bars.");
        //  109  233:getstatic       #348 <Field PrintStream System.err>
        //  110  236:ldc2            #350 <String "Warning : data contains more attributes than can be displayed as attribute bars.">
        //  111  239:invokevirtual   #355 <Method void PrintStream.println(String)>
                    if(m_Log != null)
        //* 112  242:aload_0         
        //* 113  243:getfield        #40  <Field VisualizePanel this$0>
        //* 114  246:getfield        #359 <Field Logger VisualizePanel.m_Log>
        //* 115  249:ifnull          267
                        m_Log.logMessage("Warning : data contains more attributes than can be displayed as attribute bars.");
        //  116  252:aload_0         
        //  117  253:getfield        #40  <Field VisualizePanel this$0>
        //  118  256:getfield        #359 <Field Logger VisualizePanel.m_Log>
        //  119  259:ldc2            #350 <String "Warning : data contains more attributes than can be displayed as attribute bars.">
        //  120  262:invokeinterface #364 <Method void Logger.logMessage(String)>
                }
        //  121  267:return          
        }

        private void plotReset(Instances inst, int cIndex)
        {
            if(m_splitListener == null)
        //*   0    0:aload_0         
        //*   1    1:getfield        #40  <Field VisualizePanel this$0>
        //*   2    4:getfield        #168 <Field VisualizePanelListener VisualizePanel.m_splitListener>
        //*   3    7:ifnonnull       80
            {
                m_submit.setText("Reset");
        //    4   10:aload_0         
        //    5   11:getfield        #40  <Field VisualizePanel this$0>
        //    6   14:getfield        #126 <Field JButton VisualizePanel.m_submit>
        //    7   17:ldc1            #170 <String "Reset">
        //    8   19:invokevirtual   #174 <Method void JButton.setText(String)>
                m_submit.setActionCommand("Reset");
        //    9   22:aload_0         
        //   10   23:getfield        #40  <Field VisualizePanel this$0>
        //   11   26:getfield        #126 <Field JButton VisualizePanel.m_submit>
        //   12   29:ldc1            #170 <String "Reset">
        //   13   31:invokevirtual   #177 <Method void JButton.setActionCommand(String)>
                if(m_originalPlot == null || m_originalPlot.m_plotInstances == inst)
        //*  14   34:aload_0         
        //*  15   35:getfield        #52  <Field PlotData2D m_originalPlot>
        //*  16   38:ifnull          52
        //*  17   41:aload_0         
        //*  18   42:getfield        #52  <Field PlotData2D m_originalPlot>
        //*  19   45:getfield        #180 <Field Instances PlotData2D.m_plotInstances>
        //*  20   48:aload_1         
        //*  21   49:if_acmpne       66
                    m_submit.setEnabled(false);
        //   22   52:aload_0         
        //   23   53:getfield        #40  <Field VisualizePanel this$0>
        //   24   56:getfield        #126 <Field JButton VisualizePanel.m_submit>
        //   25   59:iconst_0        
        //   26   60:invokevirtual   #184 <Method void JButton.setEnabled(boolean)>
                else
        //*  27   63:goto            91
                    m_submit.setEnabled(true);
        //   28   66:aload_0         
        //   29   67:getfield        #40  <Field VisualizePanel this$0>
        //   30   70:getfield        #126 <Field JButton VisualizePanel.m_submit>
        //   31   73:iconst_1        
        //   32   74:invokevirtual   #184 <Method void JButton.setEnabled(boolean)>
            } else
        //*  33   77:goto            91
            {
                m_submit.setEnabled(false);
        //   34   80:aload_0         
        //   35   81:getfield        #40  <Field VisualizePanel this$0>
        //   36   84:getfield        #126 <Field JButton VisualizePanel.m_submit>
        //   37   87:iconst_0        
        //   38   88:invokevirtual   #184 <Method void JButton.setEnabled(boolean)>
            }
            m_plotInstances = inst;
        //   39   91:aload_0         
        //   40   92:aload_1         
        //   41   93:putfield        #50  <Field Instances m_plotInstances>
            if(m_splitListener != null)
        //*  42   96:aload_0         
        //*  43   97:getfield        #40  <Field VisualizePanel this$0>
        //*  44  100:getfield        #168 <Field VisualizePanelListener VisualizePanel.m_splitListener>
        //*  45  103:ifnull          120
                m_plotInstances.randomize(new Random());
        //   46  106:aload_0         
        //   47  107:getfield        #50  <Field Instances m_plotInstances>
        //   48  110:new             #447 <Class Random>
        //   49  113:dup             
        //   50  114:invokespecial   #448 <Method void Random()>
        //   51  117:invokevirtual   #454 <Method void Instances.randomize(Random)>
            m_xIndex = 0;
        //   52  120:aload_0         
        //   53  121:iconst_0        
        //   54  122:putfield        #54  <Field int m_xIndex>
            m_yIndex = 0;
        //   55  125:aload_0         
        //   56  126:iconst_0        
        //   57  127:putfield        #56  <Field int m_yIndex>
            m_cIndex = cIndex;
        //   58  130:aload_0         
        //   59  131:iload_2         
        //   60  132:putfield        #58  <Field int m_cIndex>
            cancelShapes();
        //   61  135:aload_0         
        //   62  136:invokevirtual   #268 <Method void cancelShapes()>
        //   63  139:return          
        }

        public void setColours(FastVector cols)
        {
            m_plot2D.setColours(cols);
        //    0    0:aload_0         
        //    1    1:getfield        #48  <Field Plot2D m_plot2D>
        //    2    4:aload_1         
        //    3    5:invokevirtual   #459 <Method void Plot2D.setColours(FastVector)>
            m_colorList = cols;
        //    4    8:aload_0         
        //    5    9:getfield        #40  <Field VisualizePanel this$0>
        //    6   12:aload_1         
        //    7   13:putfield        #462 <Field FastVector VisualizePanel.m_colorList>
        //    8   16:return          
        }

        private void drawShapes(Graphics gx)
        {
            if(m_shapes != null)
        //*   0    0:aload_0         
        //*   1    1:getfield        #97  <Field FastVector m_shapes>
        //*   2    4:ifnull          352
            {
                for(int noa = 0; noa < m_shapes.size(); noa++)
        //*   3    7:iconst_0        
        //*   4    8:istore          7
        //*   5   10:goto            340
                {
                    FastVector stmp = (FastVector)m_shapes.elementAt(noa);
        //    6   13:aload_0         
        //    7   14:getfield        #97  <Field FastVector m_shapes>
        //    8   17:iload           7
        //    9   19:invokevirtual   #201 <Method Object FastVector.elementAt(int)>
        //   10   22:checkcast       #190 <Class FastVector>
        //   11   25:astore_2        
                    if(((Double)stmp.elementAt(0)).intValue() == 1)
        //*  12   26:aload_2         
        //*  13   27:iconst_0        
        //*  14   28:invokevirtual   #201 <Method Object FastVector.elementAt(int)>
        //*  15   31:checkcast       #228 <Class Double>
        //*  16   34:invokevirtual   #231 <Method int Double.intValue()>
        //*  17   37:iconst_1        
        //*  18   38:icmpne          173
                    {
                        int x1 = (int)m_plot2D.convertToPanelX(((Double)stmp.elementAt(1)).doubleValue());
        //   19   41:aload_0         
        //   20   42:getfield        #48  <Field Plot2D m_plot2D>
        //   21   45:aload_2         
        //   22   46:iconst_1        
        //   23   47:invokevirtual   #201 <Method Object FastVector.elementAt(int)>
        //   24   50:checkcast       #228 <Class Double>
        //   25   53:invokevirtual   #235 <Method double Double.doubleValue()>
        //   26   56:invokevirtual   #469 <Method double Plot2D.convertToPanelX(double)>
        //   27   59:d2i             
        //   28   60:istore_3        
                        int y1 = (int)m_plot2D.convertToPanelY(((Double)stmp.elementAt(2)).doubleValue());
        //   29   61:aload_0         
        //   30   62:getfield        #48  <Field Plot2D m_plot2D>
        //   31   65:aload_2         
        //   32   66:iconst_2        
        //   33   67:invokevirtual   #201 <Method Object FastVector.elementAt(int)>
        //   34   70:checkcast       #228 <Class Double>
        //   35   73:invokevirtual   #235 <Method double Double.doubleValue()>
        //   36   76:invokevirtual   #472 <Method double Plot2D.convertToPanelY(double)>
        //   37   79:d2i             
        //   38   80:istore          4
                        int x2 = (int)m_plot2D.convertToPanelX(((Double)stmp.elementAt(3)).doubleValue());
        //   39   82:aload_0         
        //   40   83:getfield        #48  <Field Plot2D m_plot2D>
        //   41   86:aload_2         
        //   42   87:iconst_3        
        //   43   88:invokevirtual   #201 <Method Object FastVector.elementAt(int)>
        //   44   91:checkcast       #228 <Class Double>
        //   45   94:invokevirtual   #235 <Method double Double.doubleValue()>
        //   46   97:invokevirtual   #469 <Method double Plot2D.convertToPanelX(double)>
        //   47  100:d2i             
        //   48  101:istore          5
                        int y2 = (int)m_plot2D.convertToPanelY(((Double)stmp.elementAt(4)).doubleValue());
        //   49  103:aload_0         
        //   50  104:getfield        #48  <Field Plot2D m_plot2D>
        //   51  107:aload_2         
        //   52  108:iconst_4        
        //   53  109:invokevirtual   #201 <Method Object FastVector.elementAt(int)>
        //   54  112:checkcast       #228 <Class Double>
        //   55  115:invokevirtual   #235 <Method double Double.doubleValue()>
        //   56  118:invokevirtual   #472 <Method double Plot2D.convertToPanelY(double)>
        //   57  121:d2i             
        //   58  122:istore          6
                        gx.setColor(Color.gray);
        //   59  124:aload_1         
        //   60  125:getstatic       #478 <Field Color Color.gray>
        //   61  128:invokevirtual   #483 <Method void Graphics.setColor(Color)>
                        gx.fillRect(x1, y1, x2 - x1, y2 - y1);
        //   62  131:aload_1         
        //   63  132:iload_3         
        //   64  133:iload           4
        //   65  135:iload           5
        //   66  137:iload_3         
        //   67  138:isub            
        //   68  139:iload           6
        //   69  141:iload           4
        //   70  143:isub            
        //   71  144:invokevirtual   #486 <Method void Graphics.fillRect(int, int, int, int)>
                        gx.setColor(Color.black);
        //   72  147:aload_1         
        //   73  148:getstatic       #489 <Field Color Color.black>
        //   74  151:invokevirtual   #483 <Method void Graphics.setColor(Color)>
                        gx.drawRect(x1, y1, x2 - x1, y2 - y1);
        //   75  154:aload_1         
        //   76  155:iload_3         
        //   77  156:iload           4
        //   78  158:iload           5
        //   79  160:iload_3         
        //   80  161:isub            
        //   81  162:iload           6
        //   82  164:iload           4
        //   83  166:isub            
        //   84  167:invokevirtual   #492 <Method void Graphics.drawRect(int, int, int, int)>
                    } else
        //*  85  170:goto            337
                    if(((Double)stmp.elementAt(0)).intValue() == 2)
        //*  86  173:aload_2         
        //*  87  174:iconst_0        
        //*  88  175:invokevirtual   #201 <Method Object FastVector.elementAt(int)>
        //*  89  178:checkcast       #228 <Class Double>
        //*  90  181:invokevirtual   #231 <Method int Double.intValue()>
        //*  91  184:iconst_2        
        //*  92  185:icmpne          251
                    {
                        int ar1[] = getXCoords(stmp);
        //   93  188:aload_0         
        //   94  189:aload_2         
        //   95  190:invokespecial   #496 <Method int[] getXCoords(FastVector)>
        //   96  193:astore          8
                        int ar2[] = getYCoords(stmp);
        //   97  195:aload_0         
        //   98  196:aload_2         
        //   99  197:invokespecial   #499 <Method int[] getYCoords(FastVector)>
        //  100  200:astore          9
                        gx.setColor(Color.gray);
        //  101  202:aload_1         
        //  102  203:getstatic       #478 <Field Color Color.gray>
        //  103  206:invokevirtual   #483 <Method void Graphics.setColor(Color)>
                        gx.fillPolygon(ar1, ar2, (stmp.size() - 1) / 2);
        //  104  209:aload_1         
        //  105  210:aload           8
        //  106  212:aload           9
        //  107  214:aload_2         
        //  108  215:invokevirtual   #194 <Method int FastVector.size()>
        //  109  218:iconst_1        
        //  110  219:isub            
        //  111  220:iconst_2        
        //  112  221:idiv            
        //  113  222:invokevirtual   #503 <Method void Graphics.fillPolygon(int[], int[], int)>
                        gx.setColor(Color.black);
        //  114  225:aload_1         
        //  115  226:getstatic       #489 <Field Color Color.black>
        //  116  229:invokevirtual   #483 <Method void Graphics.setColor(Color)>
                        gx.drawPolyline(ar1, ar2, (stmp.size() - 1) / 2);
        //  117  232:aload_1         
        //  118  233:aload           8
        //  119  235:aload           9
        //  120  237:aload_2         
        //  121  238:invokevirtual   #194 <Method int FastVector.size()>
        //  122  241:iconst_1        
        //  123  242:isub            
        //  124  243:iconst_2        
        //  125  244:idiv            
        //  126  245:invokevirtual   #506 <Method void Graphics.drawPolyline(int[], int[], int)>
                    } else
        //* 127  248:goto            337
                    if(((Double)stmp.elementAt(0)).intValue() == 3)
        //* 128  251:aload_2         
        //* 129  252:iconst_0        
        //* 130  253:invokevirtual   #201 <Method Object FastVector.elementAt(int)>
        //* 131  256:checkcast       #228 <Class Double>
        //* 132  259:invokevirtual   #231 <Method int Double.intValue()>
        //* 133  262:iconst_3        
        //* 134  263:icmpne          337
                    {
                        FastVector tmp = makePolygon(stmp);
        //  135  266:aload_0         
        //  136  267:aload_2         
        //  137  268:invokespecial   #510 <Method FastVector makePolygon(FastVector)>
        //  138  271:astore          10
                        int ar1[] = getXCoords(tmp);
        //  139  273:aload_0         
        //  140  274:aload           10
        //  141  276:invokespecial   #496 <Method int[] getXCoords(FastVector)>
        //  142  279:astore          8
                        int ar2[] = getYCoords(tmp);
        //  143  281:aload_0         
        //  144  282:aload           10
        //  145  284:invokespecial   #499 <Method int[] getYCoords(FastVector)>
        //  146  287:astore          9
                        gx.setColor(Color.gray);
        //  147  289:aload_1         
        //  148  290:getstatic       #478 <Field Color Color.gray>
        //  149  293:invokevirtual   #483 <Method void Graphics.setColor(Color)>
                        gx.fillPolygon(ar1, ar2, (tmp.size() - 1) / 2);
        //  150  296:aload_1         
        //  151  297:aload           8
        //  152  299:aload           9
        //  153  301:aload           10
        //  154  303:invokevirtual   #194 <Method int FastVector.size()>
        //  155  306:iconst_1        
        //  156  307:isub            
        //  157  308:iconst_2        
        //  158  309:idiv            
        //  159  310:invokevirtual   #503 <Method void Graphics.fillPolygon(int[], int[], int)>
                        gx.setColor(Color.black);
        //  160  313:aload_1         
        //  161  314:getstatic       #489 <Field Color Color.black>
        //  162  317:invokevirtual   #483 <Method void Graphics.setColor(Color)>
                        gx.drawPolyline(ar1, ar2, (tmp.size() - 1) / 2);
        //  163  320:aload_1         
        //  164  321:aload           8
        //  165  323:aload           9
        //  166  325:aload           10
        //  167  327:invokevirtual   #194 <Method int FastVector.size()>
        //  168  330:iconst_1        
        //  169  331:isub            
        //  170  332:iconst_2        
        //  171  333:idiv            
        //  172  334:invokevirtual   #506 <Method void Graphics.drawPolyline(int[], int[], int)>
                    }
                }

        //  173  337:iinc            7  1
        //  174  340:iload           7
        //  175  342:aload_0         
        //  176  343:getfield        #97  <Field FastVector m_shapes>
        //  177  346:invokevirtual   #194 <Method int FastVector.size()>
        //  178  349:icmplt          13
            }
            if(m_shapePoints != null && (((Double)m_shapePoints.elementAt(0)).intValue() == 2 || ((Double)m_shapePoints.elementAt(0)).intValue() == 3))
        //* 179  352:aload_0         
        //* 180  353:getfield        #99  <Field FastVector m_shapePoints>
        //* 181  356:ifnull          612
        //* 182  359:aload_0         
        //* 183  360:getfield        #99  <Field FastVector m_shapePoints>
        //* 184  363:iconst_0        
        //* 185  364:invokevirtual   #201 <Method Object FastVector.elementAt(int)>
        //* 186  367:checkcast       #228 <Class Double>
        //* 187  370:invokevirtual   #231 <Method int Double.intValue()>
        //* 188  373:iconst_2        
        //* 189  374:icmpeq          395
        //* 190  377:aload_0         
        //* 191  378:getfield        #99  <Field FastVector m_shapePoints>
        //* 192  381:iconst_0        
        //* 193  382:invokevirtual   #201 <Method Object FastVector.elementAt(int)>
        //* 194  385:checkcast       #228 <Class Double>
        //* 195  388:invokevirtual   #231 <Method int Double.intValue()>
        //* 196  391:iconst_3        
        //* 197  392:icmpne          612
            {
                gx.setColor(Color.black);
        //  198  395:aload_1         
        //  199  396:getstatic       #489 <Field Color Color.black>
        //  200  399:invokevirtual   #483 <Method void Graphics.setColor(Color)>
                gx.setXORMode(Color.white);
        //  201  402:aload_1         
        //  202  403:getstatic       #513 <Field Color Color.white>
        //  203  406:invokevirtual   #516 <Method void Graphics.setXORMode(Color)>
                int ar1[] = getXCoords(m_shapePoints);
        //  204  409:aload_0         
        //  205  410:aload_0         
        //  206  411:getfield        #99  <Field FastVector m_shapePoints>
        //  207  414:invokespecial   #496 <Method int[] getXCoords(FastVector)>
        //  208  417:astore_2        
                int ar2[] = getYCoords(m_shapePoints);
        //  209  418:aload_0         
        //  210  419:aload_0         
        //  211  420:getfield        #99  <Field FastVector m_shapePoints>
        //  212  423:invokespecial   #499 <Method int[] getYCoords(FastVector)>
        //  213  426:astore_3        
                gx.drawPolyline(ar1, ar2, (m_shapePoints.size() - 1) / 2);
        //  214  427:aload_1         
        //  215  428:aload_2         
        //  216  429:aload_3         
        //  217  430:aload_0         
        //  218  431:getfield        #99  <Field FastVector m_shapePoints>
        //  219  434:invokevirtual   #194 <Method int FastVector.size()>
        //  220  437:iconst_1        
        //  221  438:isub            
        //  222  439:iconst_2        
        //  223  440:idiv            
        //  224  441:invokevirtual   #506 <Method void Graphics.drawPolyline(int[], int[], int)>
                m_newMousePos.width = (int)Math.ceil(m_plot2D.convertToPanelX(((Double)m_shapePoints.elementAt(m_shapePoints.size() - 2)).doubleValue()));
        //  225  444:aload_0         
        //  226  445:getfield        #104 <Field Dimension m_newMousePos>
        //  227  448:aload_0         
        //  228  449:getfield        #48  <Field Plot2D m_plot2D>
        //  229  452:aload_0         
        //  230  453:getfield        #99  <Field FastVector m_shapePoints>
        //  231  456:aload_0         
        //  232  457:getfield        #99  <Field FastVector m_shapePoints>
        //  233  460:invokevirtual   #194 <Method int FastVector.size()>
        //  234  463:iconst_2        
        //  235  464:isub            
        //  236  465:invokevirtual   #201 <Method Object FastVector.elementAt(int)>
        //  237  468:checkcast       #228 <Class Double>
        //  238  471:invokevirtual   #235 <Method double Double.doubleValue()>
        //  239  474:invokevirtual   #469 <Method double Plot2D.convertToPanelX(double)>
        //  240  477:invokestatic    #521 <Method double Math.ceil(double)>
        //  241  480:d2i             
        //  242  481:putfield        #218 <Field int Dimension.width>
                m_newMousePos.height = (int)Math.ceil(m_plot2D.convertToPanelY(((Double)m_shapePoints.elementAt(m_shapePoints.size() - 1)).doubleValue()));
        //  243  484:aload_0         
        //  244  485:getfield        #104 <Field Dimension m_newMousePos>
        //  245  488:aload_0         
        //  246  489:getfield        #48  <Field Plot2D m_plot2D>
        //  247  492:aload_0         
        //  248  493:getfield        #99  <Field FastVector m_shapePoints>
        //  249  496:aload_0         
        //  250  497:getfield        #99  <Field FastVector m_shapePoints>
        //  251  500:invokevirtual   #194 <Method int FastVector.size()>
        //  252  503:iconst_1        
        //  253  504:isub            
        //  254  505:invokevirtual   #201 <Method Object FastVector.elementAt(int)>
        //  255  508:checkcast       #228 <Class Double>
        //  256  511:invokevirtual   #235 <Method double Double.doubleValue()>
        //  257  514:invokevirtual   #472 <Method double Plot2D.convertToPanelY(double)>
        //  258  517:invokestatic    #521 <Method double Math.ceil(double)>
        //  259  520:d2i             
        //  260  521:putfield        #221 <Field int Dimension.height>
                gx.drawLine((int)Math.ceil(m_plot2D.convertToPanelX(((Double)m_shapePoints.elementAt(m_shapePoints.size() - 2)).doubleValue())), (int)Math.ceil(m_plot2D.convertToPanelY(((Double)m_shapePoints.elementAt(m_shapePoints.size() - 1)).doubleValue())), m_newMousePos.width, m_newMousePos.height);
        //  261  524:aload_1         
        //  262  525:aload_0         
        //  263  526:getfield        #48  <Field Plot2D m_plot2D>
        //  264  529:aload_0         
        //  265  530:getfield        #99  <Field FastVector m_shapePoints>
        //  266  533:aload_0         
        //  267  534:getfield        #99  <Field FastVector m_shapePoints>
        //  268  537:invokevirtual   #194 <Method int FastVector.size()>
        //  269  540:iconst_2        
        //  270  541:isub            
        //  271  542:invokevirtual   #201 <Method Object FastVector.elementAt(int)>
        //  272  545:checkcast       #228 <Class Double>
        //  273  548:invokevirtual   #235 <Method double Double.doubleValue()>
        //  274  551:invokevirtual   #469 <Method double Plot2D.convertToPanelX(double)>
        //  275  554:invokestatic    #521 <Method double Math.ceil(double)>
        //  276  557:d2i             
        //  277  558:aload_0         
        //  278  559:getfield        #48  <Field Plot2D m_plot2D>
        //  279  562:aload_0         
        //  280  563:getfield        #99  <Field FastVector m_shapePoints>
        //  281  566:aload_0         
        //  282  567:getfield        #99  <Field FastVector m_shapePoints>
        //  283  570:invokevirtual   #194 <Method int FastVector.size()>
        //  284  573:iconst_1        
        //  285  574:isub            
        //  286  575:invokevirtual   #201 <Method Object FastVector.elementAt(int)>
        //  287  578:checkcast       #228 <Class Double>
        //  288  581:invokevirtual   #235 <Method double Double.doubleValue()>
        //  289  584:invokevirtual   #472 <Method double Plot2D.convertToPanelY(double)>
        //  290  587:invokestatic    #521 <Method double Math.ceil(double)>
        //  291  590:d2i             
        //  292  591:aload_0         
        //  293  592:getfield        #104 <Field Dimension m_newMousePos>
        //  294  595:getfield        #218 <Field int Dimension.width>
        //  295  598:aload_0         
        //  296  599:getfield        #104 <Field Dimension m_newMousePos>
        //  297  602:getfield        #221 <Field int Dimension.height>
        //  298  605:invokevirtual   #524 <Method void Graphics.drawLine(int, int, int, int)>
                gx.setPaintMode();
        //  299  608:aload_1         
        //  300  609:invokevirtual   #527 <Method void Graphics.setPaintMode()>
            }
        //  301  612:return          
        }

        private double[] lineIntersect(double x1, double y1, double x2, double y2, double x, double y, double offset)
        {
            double xn = -100D;
        //    0    0:ldc2w           #536 <Double -100D>
        //    1    3:dstore          19
            double yn = -100D;
        //    2    5:ldc2w           #536 <Double -100D>
        //    3    8:dstore          21
            if(x == 0.0D)
        //*   4   10:dload           9
        //*   5   12:dconst_0        
        //*   6   13:dcmpl           
        //*   7   14:ifne            105
            {
                if(x1 <= offset && offset < x2 || x1 >= offset && offset > x2)
        //*   8   17:dload_1         
        //*   9   18:dload           13
        //*  10   20:dcmpg           
        //*  11   21:ifgt            32
        //*  12   24:dload           13
        //*  13   26:dload           5
        //*  14   28:dcmpg           
        //*  15   29:iflt            47
        //*  16   32:dload_1         
        //*  17   33:dload           13
        //*  18   35:dcmpl           
        //*  19   36:iflt            197
        //*  20   39:dload           13
        //*  21   41:dload           5
        //*  22   43:dcmpl           
        //*  23   44:ifle            197
                {
                    double xval = x1 - x2;
        //   24   47:dload_1         
        //   25   48:dload           5
        //   26   50:dsub            
        //   27   51:dstore          15
                    double change = (offset - x2) / xval;
        //   28   53:dload           13
        //   29   55:dload           5
        //   30   57:dsub            
        //   31   58:dload           15
        //   32   60:ddiv            
        //   33   61:dstore          23
                    yn = (y1 - y2) * change + y2;
        //   34   63:dload_3         
        //   35   64:dload           7
        //   36   66:dsub            
        //   37   67:dload           23
        //   38   69:dmul            
        //   39   70:dload           7
        //   40   72:dadd            
        //   41   73:dstore          21
                    if(0.0D <= yn && yn <= y)
        //*  42   75:dconst_0        
        //*  43   76:dload           21
        //*  44   78:dcmpg           
        //*  45   79:ifgt            97
        //*  46   82:dload           21
        //*  47   84:dload           11
        //*  48   86:dcmpg           
        //*  49   87:ifgt            97
                        xn = offset;
        //   50   90:dload           13
        //   51   92:dstore          19
                    else
        //*  52   94:goto            197
                        xn = -100D;
        //   53   97:ldc2w           #536 <Double -100D>
        //   54  100:dstore          19
                }
            } else
        //*  55  102:goto            197
            if(y == 0.0D && (y1 <= offset && offset < y2 || y1 >= offset && offset > y2))
        //*  56  105:dload           11
        //*  57  107:dconst_0        
        //*  58  108:dcmpl           
        //*  59  109:ifne            197
        //*  60  112:dload_3         
        //*  61  113:dload           13
        //*  62  115:dcmpg           
        //*  63  116:ifgt            127
        //*  64  119:dload           13
        //*  65  121:dload           7
        //*  66  123:dcmpg           
        //*  67  124:iflt            142
        //*  68  127:dload_3         
        //*  69  128:dload           13
        //*  70  130:dcmpl           
        //*  71  131:iflt            197
        //*  72  134:dload           13
        //*  73  136:dload           7
        //*  74  138:dcmpl           
        //*  75  139:ifle            197
            {
                double yval = y1 - y2;
        //   76  142:dload_3         
        //   77  143:dload           7
        //   78  145:dsub            
        //   79  146:dstore          17
                double change = (offset - y2) / yval;
        //   80  148:dload           13
        //   81  150:dload           7
        //   82  152:dsub            
        //   83  153:dload           17
        //   84  155:ddiv            
        //   85  156:dstore          23
                xn = (x1 - x2) * change + x2;
        //   86  158:dload_1         
        //   87  159:dload           5
        //   88  161:dsub            
        //   89  162:dload           23
        //   90  164:dmul            
        //   91  165:dload           5
        //   92  167:dadd            
        //   93  168:dstore          19
                if(0.0D <= xn && xn <= x)
        //*  94  170:dconst_0        
        //*  95  171:dload           19
        //*  96  173:dcmpg           
        //*  97  174:ifgt            192
        //*  98  177:dload           19
        //*  99  179:dload           9
        //* 100  181:dcmpg           
        //* 101  182:ifgt            192
                    yn = offset;
        //  102  185:dload           13
        //  103  187:dstore          21
                else
        //* 104  189:goto            197
                    xn = -100D;
        //  105  192:ldc2w           #536 <Double -100D>
        //  106  195:dstore          19
            }
            double ret[] = new double[2];
        //  107  197:iconst_2        
        //  108  198:newarray        double[]
        //  109  200:astore          25
            ret[0] = xn;
        //  110  202:aload           25
        //  111  204:iconst_0        
        //  112  205:dload           19
        //  113  207:dastore         
            ret[1] = yn;
        //  114  208:aload           25
        //  115  210:iconst_1        
        //  116  211:dload           21
        //  117  213:dastore         
            return ret;
        //  118  214:aload           25
        //  119  216:areturn         
        }

        private FastVector makePolygon(FastVector v)
        {
            FastVector building = new FastVector(v.size() + 10);
        //    0    0:new             #190 <Class FastVector>
        //    1    3:dup             
        //    2    4:aload_1         
        //    3    5:invokevirtual   #194 <Method int FastVector.size()>
        //    4    8:bipush          10
        //    5   10:iadd            
        //    6   11:invokespecial   #197 <Method void FastVector(int)>
        //    7   14:astore_2        
            int edge1 = 0;
        //    8   15:iconst_0        
        //    9   16:istore          11
            int edge2 = 0;
        //   10   18:iconst_0        
        //   11   19:istore          12
            for(int noa = 0; noa < v.size() - 2; noa++)
        //*  12   21:iconst_0        
        //*  13   22:istore          13
        //*  14   24:goto            53
                building.addElement(new Double(((Double)v.elementAt(noa)).doubleValue()));
        //   15   27:aload_2         
        //   16   28:new             #228 <Class Double>
        //   17   31:dup             
        //   18   32:aload_1         
        //   19   33:iload           13
        //   20   35:invokevirtual   #201 <Method Object FastVector.elementAt(int)>
        //   21   38:checkcast       #228 <Class Double>
        //   22   41:invokevirtual   #235 <Method double Double.doubleValue()>
        //   23   44:invokespecial   #547 <Method void Double(double)>
        //   24   47:invokevirtual   #205 <Method void FastVector.addElement(Object)>

        //   25   50:iinc            13  1
        //   26   53:iload           13
        //   27   55:aload_1         
        //   28   56:invokevirtual   #194 <Method int FastVector.size()>
        //   29   59:iconst_2        
        //   30   60:isub            
        //   31   61:icmplt          27
            double x1 = m_plot2D.convertToPanelX(((Double)v.elementAt(1)).doubleValue());
        //   32   64:aload_0         
        //   33   65:getfield        #48  <Field Plot2D m_plot2D>
        //   34   68:aload_1         
        //   35   69:iconst_1        
        //   36   70:invokevirtual   #201 <Method Object FastVector.elementAt(int)>
        //   37   73:checkcast       #228 <Class Double>
        //   38   76:invokevirtual   #235 <Method double Double.doubleValue()>
        //   39   79:invokevirtual   #469 <Method double Plot2D.convertToPanelX(double)>
        //   40   82:dstore_3        
            double y1 = m_plot2D.convertToPanelY(((Double)v.elementAt(2)).doubleValue());
        //   41   83:aload_0         
        //   42   84:getfield        #48  <Field Plot2D m_plot2D>
        //   43   87:aload_1         
        //   44   88:iconst_2        
        //   45   89:invokevirtual   #201 <Method Object FastVector.elementAt(int)>
        //   46   92:checkcast       #228 <Class Double>
        //   47   95:invokevirtual   #235 <Method double Double.doubleValue()>
        //   48   98:invokevirtual   #472 <Method double Plot2D.convertToPanelY(double)>
        //   49  101:dstore          5
            double x2 = m_plot2D.convertToPanelX(((Double)v.elementAt(3)).doubleValue());
        //   50  103:aload_0         
        //   51  104:getfield        #48  <Field Plot2D m_plot2D>
        //   52  107:aload_1         
        //   53  108:iconst_3        
        //   54  109:invokevirtual   #201 <Method Object FastVector.elementAt(int)>
        //   55  112:checkcast       #228 <Class Double>
        //   56  115:invokevirtual   #235 <Method double Double.doubleValue()>
        //   57  118:invokevirtual   #469 <Method double Plot2D.convertToPanelX(double)>
        //   58  121:dstore          7
            double y2 = m_plot2D.convertToPanelY(((Double)v.elementAt(4)).doubleValue());
        //   59  123:aload_0         
        //   60  124:getfield        #48  <Field Plot2D m_plot2D>
        //   61  127:aload_1         
        //   62  128:iconst_4        
        //   63  129:invokevirtual   #201 <Method Object FastVector.elementAt(int)>
        //   64  132:checkcast       #228 <Class Double>
        //   65  135:invokevirtual   #235 <Method double Double.doubleValue()>
        //   66  138:invokevirtual   #472 <Method double Plot2D.convertToPanelY(double)>
        //   67  141:dstore          9
            double new_coords[];
            if(x1 < 0.0D)
        //*  68  143:dload_3         
        //*  69  144:dconst_0        
        //*  70  145:dcmpg           
        //*  71  146:ifge            244
            {
                new_coords = lineIntersect(x1, y1, x2, y2, 0.0D, getHeight(), 0.0D);
        //   72  149:aload_0         
        //   73  150:dload_3         
        //   74  151:dload           5
        //   75  153:dload           7
        //   76  155:dload           9
        //   77  157:dconst_0        
        //   78  158:aload_0         
        //   79  159:invokevirtual   #550 <Method int getHeight()>
        //   80  162:i2d             
        //   81  163:dconst_0        
        //   82  164:invokespecial   #552 <Method double[] lineIntersect(double, double, double, double, double, double, double)>
        //   83  167:astore          13
                edge1 = 0;
        //   84  169:iconst_0        
        //   85  170:istore          11
                if(new_coords[0] < 0.0D)
        //*  86  172:aload           13
        //*  87  174:iconst_0        
        //*  88  175:daload          
        //*  89  176:dconst_0        
        //*  90  177:dcmpg           
        //*  91  178:ifge            413
                    if(y1 < 0.0D)
        //*  92  181:dload           5
        //*  93  183:dconst_0        
        //*  94  184:dcmpg           
        //*  95  185:ifge            214
                    {
                        new_coords = lineIntersect(x1, y1, x2, y2, getWidth(), 0.0D, 0.0D);
        //   96  188:aload_0         
        //   97  189:dload_3         
        //   98  190:dload           5
        //   99  192:dload           7
        //  100  194:dload           9
        //  101  196:aload_0         
        //  102  197:invokevirtual   #555 <Method int getWidth()>
        //  103  200:i2d             
        //  104  201:dconst_0        
        //  105  202:dconst_0        
        //  106  203:invokespecial   #552 <Method double[] lineIntersect(double, double, double, double, double, double, double)>
        //  107  206:astore          13
                        edge1 = 1;
        //  108  208:iconst_1        
        //  109  209:istore          11
                    } else
        //* 110  211:goto            413
                    {
                        new_coords = lineIntersect(x1, y1, x2, y2, getWidth(), 0.0D, getHeight());
        //  111  214:aload_0         
        //  112  215:dload_3         
        //  113  216:dload           5
        //  114  218:dload           7
        //  115  220:dload           9
        //  116  222:aload_0         
        //  117  223:invokevirtual   #555 <Method int getWidth()>
        //  118  226:i2d             
        //  119  227:dconst_0        
        //  120  228:aload_0         
        //  121  229:invokevirtual   #550 <Method int getHeight()>
        //  122  232:i2d             
        //  123  233:invokespecial   #552 <Method double[] lineIntersect(double, double, double, double, double, double, double)>
        //  124  236:astore          13
                        edge1 = 3;
        //  125  238:iconst_3        
        //  126  239:istore          11
                    }
            } else
        //* 127  241:goto            413
            if(x1 > (double)getWidth())
        //* 128  244:dload_3         
        //* 129  245:aload_0         
        //* 130  246:invokevirtual   #555 <Method int getWidth()>
        //* 131  249:i2d             
        //* 132  250:dcmpl           
        //* 133  251:ifle            353
            {
                new_coords = lineIntersect(x1, y1, x2, y2, 0.0D, getHeight(), getWidth());
        //  134  254:aload_0         
        //  135  255:dload_3         
        //  136  256:dload           5
        //  137  258:dload           7
        //  138  260:dload           9
        //  139  262:dconst_0        
        //  140  263:aload_0         
        //  141  264:invokevirtual   #550 <Method int getHeight()>
        //  142  267:i2d             
        //  143  268:aload_0         
        //  144  269:invokevirtual   #555 <Method int getWidth()>
        //  145  272:i2d             
        //  146  273:invokespecial   #552 <Method double[] lineIntersect(double, double, double, double, double, double, double)>
        //  147  276:astore          13
                edge1 = 2;
        //  148  278:iconst_2        
        //  149  279:istore          11
                if(new_coords[0] < 0.0D)
        //* 150  281:aload           13
        //* 151  283:iconst_0        
        //* 152  284:daload          
        //* 153  285:dconst_0        
        //* 154  286:dcmpg           
        //* 155  287:ifge            413
                    if(y1 < 0.0D)
        //* 156  290:dload           5
        //* 157  292:dconst_0        
        //* 158  293:dcmpg           
        //* 159  294:ifge            323
                    {
                        new_coords = lineIntersect(x1, y1, x2, y2, getWidth(), 0.0D, 0.0D);
        //  160  297:aload_0         
        //  161  298:dload_3         
        //  162  299:dload           5
        //  163  301:dload           7
        //  164  303:dload           9
        //  165  305:aload_0         
        //  166  306:invokevirtual   #555 <Method int getWidth()>
        //  167  309:i2d             
        //  168  310:dconst_0        
        //  169  311:dconst_0        
        //  170  312:invokespecial   #552 <Method double[] lineIntersect(double, double, double, double, double, double, double)>
        //  171  315:astore          13
                        edge1 = 1;
        //  172  317:iconst_1        
        //  173  318:istore          11
                    } else
        //* 174  320:goto            413
                    {
                        new_coords = lineIntersect(x1, y1, x2, y2, getWidth(), 0.0D, getHeight());
        //  175  323:aload_0         
        //  176  324:dload_3         
        //  177  325:dload           5
        //  178  327:dload           7
        //  179  329:dload           9
        //  180  331:aload_0         
        //  181  332:invokevirtual   #555 <Method int getWidth()>
        //  182  335:i2d             
        //  183  336:dconst_0        
        //  184  337:aload_0         
        //  185  338:invokevirtual   #550 <Method int getHeight()>
        //  186  341:i2d             
        //  187  342:invokespecial   #552 <Method double[] lineIntersect(double, double, double, double, double, double, double)>
        //  188  345:astore          13
                        edge1 = 3;
        //  189  347:iconst_3        
        //  190  348:istore          11
                    }
            } else
        //* 191  350:goto            413
            if(y1 < 0.0D)
        //* 192  353:dload           5
        //* 193  355:dconst_0        
        //* 194  356:dcmpg           
        //* 195  357:ifge            386
            {
                new_coords = lineIntersect(x1, y1, x2, y2, getWidth(), 0.0D, 0.0D);
        //  196  360:aload_0         
        //  197  361:dload_3         
        //  198  362:dload           5
        //  199  364:dload           7
        //  200  366:dload           9
        //  201  368:aload_0         
        //  202  369:invokevirtual   #555 <Method int getWidth()>
        //  203  372:i2d             
        //  204  373:dconst_0        
        //  205  374:dconst_0        
        //  206  375:invokespecial   #552 <Method double[] lineIntersect(double, double, double, double, double, double, double)>
        //  207  378:astore          13
                edge1 = 1;
        //  208  380:iconst_1        
        //  209  381:istore          11
            } else
        //* 210  383:goto            413
            {
                new_coords = lineIntersect(x1, y1, x2, y2, getWidth(), 0.0D, getHeight());
        //  211  386:aload_0         
        //  212  387:dload_3         
        //  213  388:dload           5
        //  214  390:dload           7
        //  215  392:dload           9
        //  216  394:aload_0         
        //  217  395:invokevirtual   #555 <Method int getWidth()>
        //  218  398:i2d             
        //  219  399:dconst_0        
        //  220  400:aload_0         
        //  221  401:invokevirtual   #550 <Method int getHeight()>
        //  222  404:i2d             
        //  223  405:invokespecial   #552 <Method double[] lineIntersect(double, double, double, double, double, double, double)>
        //  224  408:astore          13
                edge1 = 3;
        //  225  410:iconst_3        
        //  226  411:istore          11
            }
            building.setElementAt(new Double(m_plot2D.convertToAttribX(new_coords[0])), 1);
        //  227  413:aload_2         
        //  228  414:new             #228 <Class Double>
        //  229  417:dup             
        //  230  418:aload_0         
        //  231  419:getfield        #48  <Field Plot2D m_plot2D>
        //  232  422:aload           13
        //  233  424:iconst_0        
        //  234  425:daload          
        //  235  426:invokevirtual   #558 <Method double Plot2D.convertToAttribX(double)>
        //  236  429:invokespecial   #547 <Method void Double(double)>
        //  237  432:iconst_1        
        //  238  433:invokevirtual   #562 <Method void FastVector.setElementAt(Object, int)>
            building.setElementAt(new Double(m_plot2D.convertToAttribY(new_coords[1])), 2);
        //  239  436:aload_2         
        //  240  437:new             #228 <Class Double>
        //  241  440:dup             
        //  242  441:aload_0         
        //  243  442:getfield        #48  <Field Plot2D m_plot2D>
        //  244  445:aload           13
        //  245  447:iconst_1        
        //  246  448:daload          
        //  247  449:invokevirtual   #565 <Method double Plot2D.convertToAttribY(double)>
        //  248  452:invokespecial   #547 <Method void Double(double)>
        //  249  455:iconst_2        
        //  250  456:invokevirtual   #562 <Method void FastVector.setElementAt(Object, int)>
            x1 = m_plot2D.convertToPanelX(((Double)v.elementAt(v.size() - 4)).doubleValue());
        //  251  459:aload_0         
        //  252  460:getfield        #48  <Field Plot2D m_plot2D>
        //  253  463:aload_1         
        //  254  464:aload_1         
        //  255  465:invokevirtual   #194 <Method int FastVector.size()>
        //  256  468:iconst_4        
        //  257  469:isub            
        //  258  470:invokevirtual   #201 <Method Object FastVector.elementAt(int)>
        //  259  473:checkcast       #228 <Class Double>
        //  260  476:invokevirtual   #235 <Method double Double.doubleValue()>
        //  261  479:invokevirtual   #469 <Method double Plot2D.convertToPanelX(double)>
        //  262  482:dstore_3        
            y1 = m_plot2D.convertToPanelY(((Double)v.elementAt(v.size() - 3)).doubleValue());
        //  263  483:aload_0         
        //  264  484:getfield        #48  <Field Plot2D m_plot2D>
        //  265  487:aload_1         
        //  266  488:aload_1         
        //  267  489:invokevirtual   #194 <Method int FastVector.size()>
        //  268  492:iconst_3        
        //  269  493:isub            
        //  270  494:invokevirtual   #201 <Method Object FastVector.elementAt(int)>
        //  271  497:checkcast       #228 <Class Double>
        //  272  500:invokevirtual   #235 <Method double Double.doubleValue()>
        //  273  503:invokevirtual   #472 <Method double Plot2D.convertToPanelY(double)>
        //  274  506:dstore          5
            x2 = m_plot2D.convertToPanelX(((Double)v.elementAt(v.size() - 6)).doubleValue());
        //  275  508:aload_0         
        //  276  509:getfield        #48  <Field Plot2D m_plot2D>
        //  277  512:aload_1         
        //  278  513:aload_1         
        //  279  514:invokevirtual   #194 <Method int FastVector.size()>
        //  280  517:bipush          6
        //  281  519:isub            
        //  282  520:invokevirtual   #201 <Method Object FastVector.elementAt(int)>
        //  283  523:checkcast       #228 <Class Double>
        //  284  526:invokevirtual   #235 <Method double Double.doubleValue()>
        //  285  529:invokevirtual   #469 <Method double Plot2D.convertToPanelX(double)>
        //  286  532:dstore          7
            y2 = m_plot2D.convertToPanelY(((Double)v.elementAt(v.size() - 5)).doubleValue());
        //  287  534:aload_0         
        //  288  535:getfield        #48  <Field Plot2D m_plot2D>
        //  289  538:aload_1         
        //  290  539:aload_1         
        //  291  540:invokevirtual   #194 <Method int FastVector.size()>
        //  292  543:iconst_5        
        //  293  544:isub            
        //  294  545:invokevirtual   #201 <Method Object FastVector.elementAt(int)>
        //  295  548:checkcast       #228 <Class Double>
        //  296  551:invokevirtual   #235 <Method double Double.doubleValue()>
        //  297  554:invokevirtual   #472 <Method double Plot2D.convertToPanelY(double)>
        //  298  557:dstore          9
            if(x1 < 0.0D)
        //* 299  559:dload_3         
        //* 300  560:dconst_0        
        //* 301  561:dcmpg           
        //* 302  562:ifge            660
            {
                new_coords = lineIntersect(x1, y1, x2, y2, 0.0D, getHeight(), 0.0D);
        //  303  565:aload_0         
        //  304  566:dload_3         
        //  305  567:dload           5
        //  306  569:dload           7
        //  307  571:dload           9
        //  308  573:dconst_0        
        //  309  574:aload_0         
        //  310  575:invokevirtual   #550 <Method int getHeight()>
        //  311  578:i2d             
        //  312  579:dconst_0        
        //  313  580:invokespecial   #552 <Method double[] lineIntersect(double, double, double, double, double, double, double)>
        //  314  583:astore          13
                edge2 = 0;
        //  315  585:iconst_0        
        //  316  586:istore          12
                if(new_coords[0] < 0.0D)
        //* 317  588:aload           13
        //* 318  590:iconst_0        
        //* 319  591:daload          
        //* 320  592:dconst_0        
        //* 321  593:dcmpg           
        //* 322  594:ifge            829
                    if(y1 < 0.0D)
        //* 323  597:dload           5
        //* 324  599:dconst_0        
        //* 325  600:dcmpg           
        //* 326  601:ifge            630
                    {
                        new_coords = lineIntersect(x1, y1, x2, y2, getWidth(), 0.0D, 0.0D);
        //  327  604:aload_0         
        //  328  605:dload_3         
        //  329  606:dload           5
        //  330  608:dload           7
        //  331  610:dload           9
        //  332  612:aload_0         
        //  333  613:invokevirtual   #555 <Method int getWidth()>
        //  334  616:i2d             
        //  335  617:dconst_0        
        //  336  618:dconst_0        
        //  337  619:invokespecial   #552 <Method double[] lineIntersect(double, double, double, double, double, double, double)>
        //  338  622:astore          13
                        edge2 = 1;
        //  339  624:iconst_1        
        //  340  625:istore          12
                    } else
        //* 341  627:goto            829
                    {
                        new_coords = lineIntersect(x1, y1, x2, y2, getWidth(), 0.0D, getHeight());
        //  342  630:aload_0         
        //  343  631:dload_3         
        //  344  632:dload           5
        //  345  634:dload           7
        //  346  636:dload           9
        //  347  638:aload_0         
        //  348  639:invokevirtual   #555 <Method int getWidth()>
        //  349  642:i2d             
        //  350  643:dconst_0        
        //  351  644:aload_0         
        //  352  645:invokevirtual   #550 <Method int getHeight()>
        //  353  648:i2d             
        //  354  649:invokespecial   #552 <Method double[] lineIntersect(double, double, double, double, double, double, double)>
        //  355  652:astore          13
                        edge2 = 3;
        //  356  654:iconst_3        
        //  357  655:istore          12
                    }
            } else
        //* 358  657:goto            829
            if(x1 > (double)getWidth())
        //* 359  660:dload_3         
        //* 360  661:aload_0         
        //* 361  662:invokevirtual   #555 <Method int getWidth()>
        //* 362  665:i2d             
        //* 363  666:dcmpl           
        //* 364  667:ifle            769
            {
                new_coords = lineIntersect(x1, y1, x2, y2, 0.0D, getHeight(), getWidth());
        //  365  670:aload_0         
        //  366  671:dload_3         
        //  367  672:dload           5
        //  368  674:dload           7
        //  369  676:dload           9
        //  370  678:dconst_0        
        //  371  679:aload_0         
        //  372  680:invokevirtual   #550 <Method int getHeight()>
        //  373  683:i2d             
        //  374  684:aload_0         
        //  375  685:invokevirtual   #555 <Method int getWidth()>
        //  376  688:i2d             
        //  377  689:invokespecial   #552 <Method double[] lineIntersect(double, double, double, double, double, double, double)>
        //  378  692:astore          13
                edge2 = 2;
        //  379  694:iconst_2        
        //  380  695:istore          12
                if(new_coords[0] < 0.0D)
        //* 381  697:aload           13
        //* 382  699:iconst_0        
        //* 383  700:daload          
        //* 384  701:dconst_0        
        //* 385  702:dcmpg           
        //* 386  703:ifge            829
                    if(y1 < 0.0D)
        //* 387  706:dload           5
        //* 388  708:dconst_0        
        //* 389  709:dcmpg           
        //* 390  710:ifge            739
                    {
                        new_coords = lineIntersect(x1, y1, x2, y2, getWidth(), 0.0D, 0.0D);
        //  391  713:aload_0         
        //  392  714:dload_3         
        //  393  715:dload           5
        //  394  717:dload           7
        //  395  719:dload           9
        //  396  721:aload_0         
        //  397  722:invokevirtual   #555 <Method int getWidth()>
        //  398  725:i2d             
        //  399  726:dconst_0        
        //  400  727:dconst_0        
        //  401  728:invokespecial   #552 <Method double[] lineIntersect(double, double, double, double, double, double, double)>
        //  402  731:astore          13
                        edge2 = 1;
        //  403  733:iconst_1        
        //  404  734:istore          12
                    } else
        //* 405  736:goto            829
                    {
                        new_coords = lineIntersect(x1, y1, x2, y2, getWidth(), 0.0D, getHeight());
        //  406  739:aload_0         
        //  407  740:dload_3         
        //  408  741:dload           5
        //  409  743:dload           7
        //  410  745:dload           9
        //  411  747:aload_0         
        //  412  748:invokevirtual   #555 <Method int getWidth()>
        //  413  751:i2d             
        //  414  752:dconst_0        
        //  415  753:aload_0         
        //  416  754:invokevirtual   #550 <Method int getHeight()>
        //  417  757:i2d             
        //  418  758:invokespecial   #552 <Method double[] lineIntersect(double, double, double, double, double, double, double)>
        //  419  761:astore          13
                        edge2 = 3;
        //  420  763:iconst_3        
        //  421  764:istore          12
                    }
            } else
        //* 422  766:goto            829
            if(y1 < 0.0D)
        //* 423  769:dload           5
        //* 424  771:dconst_0        
        //* 425  772:dcmpg           
        //* 426  773:ifge            802
            {
                new_coords = lineIntersect(x1, y1, x2, y2, getWidth(), 0.0D, 0.0D);
        //  427  776:aload_0         
        //  428  777:dload_3         
        //  429  778:dload           5
        //  430  780:dload           7
        //  431  782:dload           9
        //  432  784:aload_0         
        //  433  785:invokevirtual   #555 <Method int getWidth()>
        //  434  788:i2d             
        //  435  789:dconst_0        
        //  436  790:dconst_0        
        //  437  791:invokespecial   #552 <Method double[] lineIntersect(double, double, double, double, double, double, double)>
        //  438  794:astore          13
                edge2 = 1;
        //  439  796:iconst_1        
        //  440  797:istore          12
            } else
        //* 441  799:goto            829
            {
                new_coords = lineIntersect(x1, y1, x2, y2, getWidth(), 0.0D, getHeight());
        //  442  802:aload_0         
        //  443  803:dload_3         
        //  444  804:dload           5
        //  445  806:dload           7
        //  446  808:dload           9
        //  447  810:aload_0         
        //  448  811:invokevirtual   #555 <Method int getWidth()>
        //  449  814:i2d             
        //  450  815:dconst_0        
        //  451  816:aload_0         
        //  452  817:invokevirtual   #550 <Method int getHeight()>
        //  453  820:i2d             
        //  454  821:invokespecial   #552 <Method double[] lineIntersect(double, double, double, double, double, double, double)>
        //  455  824:astore          13
                edge2 = 3;
        //  456  826:iconst_3        
        //  457  827:istore          12
            }
            building.setElementAt(new Double(m_plot2D.convertToAttribX(new_coords[0])), building.size() - 2);
        //  458  829:aload_2         
        //  459  830:new             #228 <Class Double>
        //  460  833:dup             
        //  461  834:aload_0         
        //  462  835:getfield        #48  <Field Plot2D m_plot2D>
        //  463  838:aload           13
        //  464  840:iconst_0        
        //  465  841:daload          
        //  466  842:invokevirtual   #558 <Method double Plot2D.convertToAttribX(double)>
        //  467  845:invokespecial   #547 <Method void Double(double)>
        //  468  848:aload_2         
        //  469  849:invokevirtual   #194 <Method int FastVector.size()>
        //  470  852:iconst_2        
        //  471  853:isub            
        //  472  854:invokevirtual   #562 <Method void FastVector.setElementAt(Object, int)>
            building.setElementAt(new Double(m_plot2D.convertToAttribY(new_coords[1])), building.size() - 1);
        //  473  857:aload_2         
        //  474  858:new             #228 <Class Double>
        //  475  861:dup             
        //  476  862:aload_0         
        //  477  863:getfield        #48  <Field Plot2D m_plot2D>
        //  478  866:aload           13
        //  479  868:iconst_1        
        //  480  869:daload          
        //  481  870:invokevirtual   #565 <Method double Plot2D.convertToAttribY(double)>
        //  482  873:invokespecial   #547 <Method void Double(double)>
        //  483  876:aload_2         
        //  484  877:invokevirtual   #194 <Method int FastVector.size()>
        //  485  880:iconst_1        
        //  486  881:isub            
        //  487  882:invokevirtual   #562 <Method void FastVector.setElementAt(Object, int)>
            int xp = getWidth() * (edge2 & 1 ^ (edge2 & 2) / 2);
        //  488  885:aload_0         
        //  489  886:invokevirtual   #555 <Method int getWidth()>
        //  490  889:iload           12
        //  491  891:iconst_1        
        //  492  892:iand            
        //  493  893:iload           12
        //  494  895:iconst_2        
        //  495  896:iand            
        //  496  897:iconst_2        
        //  497  898:idiv            
        //  498  899:ixor            
        //  499  900:imul            
        //  500  901:istore          14
            int yp = getHeight() * ((edge2 & 2) / 2);
        //  501  903:aload_0         
        //  502  904:invokevirtual   #550 <Method int getHeight()>
        //  503  907:iload           12
        //  504  909:iconst_2        
        //  505  910:iand            
        //  506  911:iconst_2        
        //  507  912:idiv            
        //  508  913:imul            
        //  509  914:istore          15
            if(inPolyline(v, m_plot2D.convertToAttribX(xp), m_plot2D.convertToAttribY(yp)))
        //* 510  916:aload_0         
        //* 511  917:aload_1         
        //* 512  918:aload_0         
        //* 513  919:getfield        #48  <Field Plot2D m_plot2D>
        //* 514  922:iload           14
        //* 515  924:i2d             
        //* 516  925:invokevirtual   #558 <Method double Plot2D.convertToAttribX(double)>
        //* 517  928:aload_0         
        //* 518  929:getfield        #48  <Field Plot2D m_plot2D>
        //* 519  932:iload           15
        //* 520  934:i2d             
        //* 521  935:invokevirtual   #565 <Method double Plot2D.convertToAttribY(double)>
        //* 522  938:invokespecial   #248 <Method boolean inPolyline(FastVector, double, double)>
        //* 523  941:ifeq            1088
            {
                building.addElement(new Double(m_plot2D.convertToAttribX(xp)));
        //  524  944:aload_2         
        //  525  945:new             #228 <Class Double>
        //  526  948:dup             
        //  527  949:aload_0         
        //  528  950:getfield        #48  <Field Plot2D m_plot2D>
        //  529  953:iload           14
        //  530  955:i2d             
        //  531  956:invokevirtual   #558 <Method double Plot2D.convertToAttribX(double)>
        //  532  959:invokespecial   #547 <Method void Double(double)>
        //  533  962:invokevirtual   #205 <Method void FastVector.addElement(Object)>
                building.addElement(new Double(m_plot2D.convertToAttribY(yp)));
        //  534  965:aload_2         
        //  535  966:new             #228 <Class Double>
        //  536  969:dup             
        //  537  970:aload_0         
        //  538  971:getfield        #48  <Field Plot2D m_plot2D>
        //  539  974:iload           15
        //  540  976:i2d             
        //  541  977:invokevirtual   #565 <Method double Plot2D.convertToAttribY(double)>
        //  542  980:invokespecial   #547 <Method void Double(double)>
        //  543  983:invokevirtual   #205 <Method void FastVector.addElement(Object)>
                for(int noa = (edge2 + 1) % 4; noa != edge1; noa = (noa + 1) % 4)
        //* 544  986:iload           12
        //* 545  988:iconst_1        
        //* 546  989:iadd            
        //* 547  990:iconst_4        
        //* 548  991:irem            
        //* 549  992:istore          16
        //* 550  994:goto            1078
                {
                    xp = getWidth() * (noa & 1 ^ (noa & 2) / 2);
        //  551  997:aload_0         
        //  552  998:invokevirtual   #555 <Method int getWidth()>
        //  553 1001:iload           16
        //  554 1003:iconst_1        
        //  555 1004:iand            
        //  556 1005:iload           16
        //  557 1007:iconst_2        
        //  558 1008:iand            
        //  559 1009:iconst_2        
        //  560 1010:idiv            
        //  561 1011:ixor            
        //  562 1012:imul            
        //  563 1013:istore          14
                    yp = getHeight() * ((noa & 2) / 2);
        //  564 1015:aload_0         
        //  565 1016:invokevirtual   #550 <Method int getHeight()>
        //  566 1019:iload           16
        //  567 1021:iconst_2        
        //  568 1022:iand            
        //  569 1023:iconst_2        
        //  570 1024:idiv            
        //  571 1025:imul            
        //  572 1026:istore          15
                    building.addElement(new Double(m_plot2D.convertToAttribX(xp)));
        //  573 1028:aload_2         
        //  574 1029:new             #228 <Class Double>
        //  575 1032:dup             
        //  576 1033:aload_0         
        //  577 1034:getfield        #48  <Field Plot2D m_plot2D>
        //  578 1037:iload           14
        //  579 1039:i2d             
        //  580 1040:invokevirtual   #558 <Method double Plot2D.convertToAttribX(double)>
        //  581 1043:invokespecial   #547 <Method void Double(double)>
        //  582 1046:invokevirtual   #205 <Method void FastVector.addElement(Object)>
                    building.addElement(new Double(m_plot2D.convertToAttribY(yp)));
        //  583 1049:aload_2         
        //  584 1050:new             #228 <Class Double>
        //  585 1053:dup             
        //  586 1054:aload_0         
        //  587 1055:getfield        #48  <Field Plot2D m_plot2D>
        //  588 1058:iload           15
        //  589 1060:i2d             
        //  590 1061:invokevirtual   #565 <Method double Plot2D.convertToAttribY(double)>
        //  591 1064:invokespecial   #547 <Method void Double(double)>
        //  592 1067:invokevirtual   #205 <Method void FastVector.addElement(Object)>
                }

        //  593 1070:iload           16
        //  594 1072:iconst_1        
        //  595 1073:iadd            
        //  596 1074:iconst_4        
        //  597 1075:irem            
        //  598 1076:istore          16
        //  599 1078:iload           16
        //  600 1080:iload           11
        //  601 1082:icmpne          997
            } else
        //* 602 1085:goto            1296
            {
                xp = getWidth() * ((edge2 & 2) / 2);
        //  603 1088:aload_0         
        //  604 1089:invokevirtual   #555 <Method int getWidth()>
        //  605 1092:iload           12
        //  606 1094:iconst_2        
        //  607 1095:iand            
        //  608 1096:iconst_2        
        //  609 1097:idiv            
        //  610 1098:imul            
        //  611 1099:istore          14
                yp = getHeight() * (1 & ~(edge2 & 1 ^ (edge2 & 2) / 2));
        //  612 1101:aload_0         
        //  613 1102:invokevirtual   #550 <Method int getHeight()>
        //  614 1105:iconst_1        
        //  615 1106:iload           12
        //  616 1108:iconst_1        
        //  617 1109:iand            
        //  618 1110:iload           12
        //  619 1112:iconst_2        
        //  620 1113:iand            
        //  621 1114:iconst_2        
        //  622 1115:idiv            
        //  623 1116:ixor            
        //  624 1117:iconst_m1       
        //  625 1118:ixor            
        //  626 1119:iand            
        //  627 1120:imul            
        //  628 1121:istore          15
                if(inPolyline(v, m_plot2D.convertToAttribX(xp), m_plot2D.convertToAttribY(yp)))
        //* 629 1123:aload_0         
        //* 630 1124:aload_1         
        //* 631 1125:aload_0         
        //* 632 1126:getfield        #48  <Field Plot2D m_plot2D>
        //* 633 1129:iload           14
        //* 634 1131:i2d             
        //* 635 1132:invokevirtual   #558 <Method double Plot2D.convertToAttribX(double)>
        //* 636 1135:aload_0         
        //* 637 1136:getfield        #48  <Field Plot2D m_plot2D>
        //* 638 1139:iload           15
        //* 639 1141:i2d             
        //* 640 1142:invokevirtual   #565 <Method double Plot2D.convertToAttribY(double)>
        //* 641 1145:invokespecial   #248 <Method boolean inPolyline(FastVector, double, double)>
        //* 642 1148:ifeq            1296
                {
                    building.addElement(new Double(m_plot2D.convertToAttribX(xp)));
        //  643 1151:aload_2         
        //  644 1152:new             #228 <Class Double>
        //  645 1155:dup             
        //  646 1156:aload_0         
        //  647 1157:getfield        #48  <Field Plot2D m_plot2D>
        //  648 1160:iload           14
        //  649 1162:i2d             
        //  650 1163:invokevirtual   #558 <Method double Plot2D.convertToAttribX(double)>
        //  651 1166:invokespecial   #547 <Method void Double(double)>
        //  652 1169:invokevirtual   #205 <Method void FastVector.addElement(Object)>
                    building.addElement(new Double(m_plot2D.convertToAttribY(yp)));
        //  653 1172:aload_2         
        //  654 1173:new             #228 <Class Double>
        //  655 1176:dup             
        //  656 1177:aload_0         
        //  657 1178:getfield        #48  <Field Plot2D m_plot2D>
        //  658 1181:iload           15
        //  659 1183:i2d             
        //  660 1184:invokevirtual   #565 <Method double Plot2D.convertToAttribY(double)>
        //  661 1187:invokespecial   #547 <Method void Double(double)>
        //  662 1190:invokevirtual   #205 <Method void FastVector.addElement(Object)>
                    for(int noa = (edge2 + 3) % 4; noa != edge1; noa = (noa + 3) % 4)
        //* 663 1193:iload           12
        //* 664 1195:iconst_3        
        //* 665 1196:iadd            
        //* 666 1197:iconst_4        
        //* 667 1198:irem            
        //* 668 1199:istore          16
        //* 669 1201:goto            1289
                    {
                        xp = getWidth() * ((noa & 2) / 2);
        //  670 1204:aload_0         
        //  671 1205:invokevirtual   #555 <Method int getWidth()>
        //  672 1208:iload           16
        //  673 1210:iconst_2        
        //  674 1211:iand            
        //  675 1212:iconst_2        
        //  676 1213:idiv            
        //  677 1214:imul            
        //  678 1215:istore          14
                        yp = getHeight() * (1 & ~(noa & 1 ^ (noa & 2) / 2));
        //  679 1217:aload_0         
        //  680 1218:invokevirtual   #550 <Method int getHeight()>
        //  681 1221:iconst_1        
        //  682 1222:iload           16
        //  683 1224:iconst_1        
        //  684 1225:iand            
        //  685 1226:iload           16
        //  686 1228:iconst_2        
        //  687 1229:iand            
        //  688 1230:iconst_2        
        //  689 1231:idiv            
        //  690 1232:ixor            
        //  691 1233:iconst_m1       
        //  692 1234:ixor            
        //  693 1235:iand            
        //  694 1236:imul            
        //  695 1237:istore          15
                        building.addElement(new Double(m_plot2D.convertToAttribX(xp)));
        //  696 1239:aload_2         
        //  697 1240:new             #228 <Class Double>
        //  698 1243:dup             
        //  699 1244:aload_0         
        //  700 1245:getfield        #48  <Field Plot2D m_plot2D>
        //  701 1248:iload           14
        //  702 1250:i2d             
        //  703 1251:invokevirtual   #558 <Method double Plot2D.convertToAttribX(double)>
        //  704 1254:invokespecial   #547 <Method void Double(double)>
        //  705 1257:invokevirtual   #205 <Method void FastVector.addElement(Object)>
                        building.addElement(new Double(m_plot2D.convertToAttribY(yp)));
        //  706 1260:aload_2         
        //  707 1261:new             #228 <Class Double>
        //  708 1264:dup             
        //  709 1265:aload_0         
        //  710 1266:getfield        #48  <Field Plot2D m_plot2D>
        //  711 1269:iload           15
        //  712 1271:i2d             
        //  713 1272:invokevirtual   #565 <Method double Plot2D.convertToAttribY(double)>
        //  714 1275:invokespecial   #547 <Method void Double(double)>
        //  715 1278:invokevirtual   #205 <Method void FastVector.addElement(Object)>
                    }

        //  716 1281:iload           16
        //  717 1283:iconst_3        
        //  718 1284:iadd            
        //  719 1285:iconst_4        
        //  720 1286:irem            
        //  721 1287:istore          16
        //  722 1289:iload           16
        //  723 1291:iload           11
        //  724 1293:icmpne          1204
                }
            }
            return building;
        //  725 1296:aload_2         
        //  726 1297:areturn         
        }

        private int[] getXCoords(FastVector v)
        {
            int cach = (v.size() - 1) / 2;
        //    0    0:aload_1         
        //    1    1:invokevirtual   #194 <Method int FastVector.size()>
        //    2    4:iconst_1        
        //    3    5:isub            
        //    4    6:iconst_2        
        //    5    7:idiv            
        //    6    8:istore_2        
            int ar[] = new int[cach];
        //    7    9:iload_2         
        //    8   10:newarray        int[]
        //    9   12:astore_3        
            for(int noa = 0; noa < cach; noa++)
        //*  10   13:iconst_0        
        //*  11   14:istore          4
        //*  12   16:goto            50
                ar[noa] = (int)m_plot2D.convertToPanelX(((Double)v.elementAt(noa * 2 + 1)).doubleValue());
        //   13   19:aload_3         
        //   14   20:iload           4
        //   15   22:aload_0         
        //   16   23:getfield        #48  <Field Plot2D m_plot2D>
        //   17   26:aload_1         
        //   18   27:iload           4
        //   19   29:iconst_2        
        //   20   30:imul            
        //   21   31:iconst_1        
        //   22   32:iadd            
        //   23   33:invokevirtual   #201 <Method Object FastVector.elementAt(int)>
        //   24   36:checkcast       #228 <Class Double>
        //   25   39:invokevirtual   #235 <Method double Double.doubleValue()>
        //   26   42:invokevirtual   #469 <Method double Plot2D.convertToPanelX(double)>
        //   27   45:d2i             
        //   28   46:iastore         

        //   29   47:iinc            4  1
        //   30   50:iload           4
        //   31   52:iload_2         
        //   32   53:icmplt          19
            return ar;
        //   33   56:aload_3         
        //   34   57:areturn         
        }

        private int[] getYCoords(FastVector v)
        {
            int cach = (v.size() - 1) / 2;
        //    0    0:aload_1         
        //    1    1:invokevirtual   #194 <Method int FastVector.size()>
        //    2    4:iconst_1        
        //    3    5:isub            
        //    4    6:iconst_2        
        //    5    7:idiv            
        //    6    8:istore_2        
            int ar[] = new int[cach];
        //    7    9:iload_2         
        //    8   10:newarray        int[]
        //    9   12:astore_3        
            for(int noa = 0; noa < cach; noa++)
        //*  10   13:iconst_0        
        //*  11   14:istore          4
        //*  12   16:goto            50
                ar[noa] = (int)m_plot2D.convertToPanelY(((Double)v.elementAt(noa * 2 + 2)).doubleValue());
        //   13   19:aload_3         
        //   14   20:iload           4
        //   15   22:aload_0         
        //   16   23:getfield        #48  <Field Plot2D m_plot2D>
        //   17   26:aload_1         
        //   18   27:iload           4
        //   19   29:iconst_2        
        //   20   30:imul            
        //   21   31:iconst_2        
        //   22   32:iadd            
        //   23   33:invokevirtual   #201 <Method Object FastVector.elementAt(int)>
        //   24   36:checkcast       #228 <Class Double>
        //   25   39:invokevirtual   #235 <Method double Double.doubleValue()>
        //   26   42:invokevirtual   #472 <Method double Plot2D.convertToPanelY(double)>
        //   27   45:d2i             
        //   28   46:iastore         

        //   29   47:iinc            4  1
        //   30   50:iload           4
        //   31   52:iload_2         
        //   32   53:icmplt          19
            return ar;
        //   33   56:aload_3         
        //   34   57:areturn         
        }

        public void prePlot(Graphics gx)
        {
            super.paintComponent(gx);
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:invokespecial   #577 <Method void PrintablePanel.paintComponent(Graphics)>
            if(m_plotInstances != null)
        //*   3    5:aload_0         
        //*   4    6:getfield        #50  <Field Instances m_plotInstances>
        //*   5    9:ifnull          17
                drawShapes(gx);
        //    6   12:aload_0         
        //    7   13:aload_1         
        //    8   14:invokespecial   #579 <Method void drawShapes(Graphics)>
        //    9   17:return          
        }

        private static final long serialVersionUID = 0xbd0edde5f52eb584L;
        protected Plot2D m_plot2D;
        protected Instances m_plotInstances;
        protected PlotData2D m_originalPlot;
        protected int m_xIndex;
        protected int m_yIndex;
        protected int m_cIndex;
        protected int m_sIndex;
        private int m_XaxisStart;
        private int m_YaxisStart;
        private int m_XaxisEnd;
        private int m_YaxisEnd;
        private boolean m_createShape;
        private FastVector m_shapes;
        private FastVector m_shapePoints;
        private Dimension m_newMousePos;
        final VisualizePanel this$0;


/*
        static void access$0(PlotPanel plotpanel, boolean flag)
        {
            plotpanel.m_createShape = flag;
        //    0    0:aload_0         
        //    1    1:iload_1         
        //    2    2:putfield        #95  <Field boolean m_createShape>
            return;
        //    3    5:return          
        }

*/


/*
        static void access$1(PlotPanel plotpanel, FastVector fastvector)
        {
            plotpanel.m_shapePoints = fastvector;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #99  <Field FastVector m_shapePoints>
            return;
        //    3    5:return          
        }

*/


/*
        static FastVector access$2(PlotPanel plotpanel)
        {
            return plotpanel.m_shapePoints;
        //    0    0:aload_0         
        //    1    1:getfield        #99  <Field FastVector m_shapePoints>
        //    2    4:areturn         
        }

*/


/*
        static boolean access$3(PlotPanel plotpanel)
        {
            return plotpanel.m_createShape;
        //    0    0:aload_0         
        //    1    1:getfield        #95  <Field boolean m_createShape>
        //    2    4:ireturn         
        }

*/


/*
        static Dimension access$4(PlotPanel plotpanel)
        {
            return plotpanel.m_newMousePos;
        //    0    0:aload_0         
        //    1    1:getfield        #104 <Field Dimension m_newMousePos>
        //    2    4:areturn         
        }

*/


/*
        static boolean access$5(PlotPanel plotpanel, FastVector fastvector, double d, double d1)
        {
            return plotpanel.inPolyline(fastvector, d, d1);
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:dload_2         
        //    3    3:dload           4
        //    4    5:invokespecial   #248 <Method boolean inPolyline(FastVector, double, double)>
        //    5    8:ireturn         
        }

*/


/*
        static FastVector access$6(PlotPanel plotpanel)
        {
            return plotpanel.m_shapes;
        //    0    0:aload_0         
        //    1    1:getfield        #97  <Field FastVector m_shapes>
        //    2    4:areturn         
        }

*/


/*
        static void access$7(PlotPanel plotpanel, FastVector fastvector)
        {
            plotpanel.m_shapes = fastvector;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #97  <Field FastVector m_shapes>
            return;
        //    3    5:return          
        }

*/


/*
        static boolean access$8(PlotPanel plotpanel, double d, double d1)
        {
            return plotpanel.checkPoints(d, d1);
        //    0    0:aload_0         
        //    1    1:dload_1         
        //    2    2:dload_3         
        //    3    3:invokespecial   #598 <Method boolean checkPoints(double, double)>
        //    4    6:ireturn         
        }

*/


/*
        static VisualizePanel access$9(PlotPanel plotpanel)
        {
            return plotpanel.this$0;
        //    0    0:aload_0         
        //    1    1:getfield        #40  <Field VisualizePanel this$0>
        //    2    4:areturn         
        }

*/

        public PlotPanel()
        {
            this$0 = VisualizePanel.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #40  <Field VisualizePanel this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #43  <Method void PrintablePanel()>
            m_plot2D = new Plot2D();
        //    5    9:aload_0         
        //    6   10:new             #45  <Class Plot2D>
        //    7   13:dup             
        //    8   14:invokespecial   #46  <Method void Plot2D()>
        //    9   17:putfield        #48  <Field Plot2D m_plot2D>
            m_plotInstances = null;
        //   10   20:aload_0         
        //   11   21:aconst_null     
        //   12   22:putfield        #50  <Field Instances m_plotInstances>
            m_originalPlot = null;
        //   13   25:aload_0         
        //   14   26:aconst_null     
        //   15   27:putfield        #52  <Field PlotData2D m_originalPlot>
            m_xIndex = 0;
        //   16   30:aload_0         
        //   17   31:iconst_0        
        //   18   32:putfield        #54  <Field int m_xIndex>
            m_yIndex = 0;
        //   19   35:aload_0         
        //   20   36:iconst_0        
        //   21   37:putfield        #56  <Field int m_yIndex>
            m_cIndex = 0;
        //   22   40:aload_0         
        //   23   41:iconst_0        
        //   24   42:putfield        #58  <Field int m_cIndex>
            m_sIndex = 0;
        //   25   45:aload_0         
        //   26   46:iconst_0        
        //   27   47:putfield        #60  <Field int m_sIndex>
            m_XaxisStart = 0;
        //   28   50:aload_0         
        //   29   51:iconst_0        
        //   30   52:putfield        #62  <Field int m_XaxisStart>
            m_YaxisStart = 0;
        //   31   55:aload_0         
        //   32   56:iconst_0        
        //   33   57:putfield        #64  <Field int m_YaxisStart>
            m_XaxisEnd = 0;
        //   34   60:aload_0         
        //   35   61:iconst_0        
        //   36   62:putfield        #66  <Field int m_XaxisEnd>
            m_YaxisEnd = 0;
        //   37   65:aload_0         
        //   38   66:iconst_0        
        //   39   67:putfield        #68  <Field int m_YaxisEnd>
            setBackground(m_plot2D.getBackground());
        //   40   70:aload_0         
        //   41   71:aload_0         
        //   42   72:getfield        #48  <Field Plot2D m_plot2D>
        //   43   75:invokevirtual   #72  <Method Color Plot2D.getBackground()>
        //   44   78:invokevirtual   #76  <Method void setBackground(Color)>
            setLayout(new BorderLayout());
        //   45   81:aload_0         
        //   46   82:new             #78  <Class BorderLayout>
        //   47   85:dup             
        //   48   86:invokespecial   #79  <Method void BorderLayout()>
        //   49   89:invokevirtual   #83  <Method void setLayout(java.awt.LayoutManager)>
            add(m_plot2D, "Center");
        //   50   92:aload_0         
        //   51   93:aload_0         
        //   52   94:getfield        #48  <Field Plot2D m_plot2D>
        //   53   97:ldc1            #85  <String "Center">
        //   54   99:invokevirtual   #89  <Method void add(Component, Object)>
            m_plot2D.setPlotCompanion(this);
        //   55  102:aload_0         
        //   56  103:getfield        #48  <Field Plot2D m_plot2D>
        //   57  106:aload_0         
        //   58  107:invokevirtual   #93  <Method void Plot2D.setPlotCompanion(Plot2DCompanion)>
            m_createShape = false;
        //   59  110:aload_0         
        //   60  111:iconst_0        
        //   61  112:putfield        #95  <Field boolean m_createShape>
            m_shapes = null;
        //   62  115:aload_0         
        //   63  116:aconst_null     
        //   64  117:putfield        #97  <Field FastVector m_shapes>
            m_shapePoints = null;
        //   65  120:aload_0         
        //   66  121:aconst_null     
        //   67  122:putfield        #99  <Field FastVector m_shapePoints>
            m_newMousePos = new Dimension();
        //   68  125:aload_0         
        //   69  126:new             #101 <Class Dimension>
        //   70  129:dup             
        //   71  130:invokespecial   #102 <Method void Dimension()>
        //   72  133:putfield        #104 <Field Dimension m_newMousePos>
            addMouseListener(new MouseAdapter() {

                public void mousePressed(MouseEvent e)
                {
                    if((e.getModifiers() & 0x10) == 16 && m_sIndex != 0 && m_sIndex == 1)
                //*   0    0:aload_1         
                //*   1    1:invokevirtual   #26  <Method int MouseEvent.getModifiers()>
                //*   2    4:bipush          16
                //*   3    6:iand            
                //*   4    7:bipush          16
                //*   5    9:icmpne          306
                //*   6   12:aload_0         
                //*   7   13:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //*   8   16:getfield        #32  <Field int VisualizePanel$PlotPanel.m_sIndex>
                //*   9   19:ifeq            306
                //*  10   22:aload_0         
                //*  11   23:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //*  12   26:getfield        #32  <Field int VisualizePanel$PlotPanel.m_sIndex>
                //*  13   29:iconst_1        
                //*  14   30:icmpne          306
                    {
                        m_createShape = true;
                //   15   33:aload_0         
                //   16   34:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   17   37:iconst_1        
                //   18   38:invokestatic    #36  <Method void VisualizePanel$PlotPanel.access$0(VisualizePanel$PlotPanel, boolean)>
                        m_shapePoints = new FastVector(5);
                //   19   41:aload_0         
                //   20   42:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   21   45:new             #38  <Class FastVector>
                //   22   48:dup             
                //   23   49:iconst_5        
                //   24   50:invokespecial   #41  <Method void FastVector(int)>
                //   25   53:invokestatic    #45  <Method void VisualizePanel$PlotPanel.access$1(VisualizePanel$PlotPanel, FastVector)>
                        m_shapePoints.addElement(new Double(m_sIndex));
                //   26   56:aload_0         
                //   27   57:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   28   60:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //   29   63:new             #51  <Class Double>
                //   30   66:dup             
                //   31   67:aload_0         
                //   32   68:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   33   71:getfield        #32  <Field int VisualizePanel$PlotPanel.m_sIndex>
                //   34   74:i2d             
                //   35   75:invokespecial   #54  <Method void Double(double)>
                //   36   78:invokevirtual   #58  <Method void FastVector.addElement(Object)>
                        m_shapePoints.addElement(new Double(e.getX()));
                //   37   81:aload_0         
                //   38   82:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   39   85:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //   40   88:new             #51  <Class Double>
                //   41   91:dup             
                //   42   92:aload_1         
                //   43   93:invokevirtual   #61  <Method int MouseEvent.getX()>
                //   44   96:i2d             
                //   45   97:invokespecial   #54  <Method void Double(double)>
                //   46  100:invokevirtual   #58  <Method void FastVector.addElement(Object)>
                        m_shapePoints.addElement(new Double(e.getY()));
                //   47  103:aload_0         
                //   48  104:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   49  107:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //   50  110:new             #51  <Class Double>
                //   51  113:dup             
                //   52  114:aload_1         
                //   53  115:invokevirtual   #64  <Method int MouseEvent.getY()>
                //   54  118:i2d             
                //   55  119:invokespecial   #54  <Method void Double(double)>
                //   56  122:invokevirtual   #58  <Method void FastVector.addElement(Object)>
                        m_shapePoints.addElement(new Double(e.getX()));
                //   57  125:aload_0         
                //   58  126:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   59  129:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //   60  132:new             #51  <Class Double>
                //   61  135:dup             
                //   62  136:aload_1         
                //   63  137:invokevirtual   #61  <Method int MouseEvent.getX()>
                //   64  140:i2d             
                //   65  141:invokespecial   #54  <Method void Double(double)>
                //   66  144:invokevirtual   #58  <Method void FastVector.addElement(Object)>
                        m_shapePoints.addElement(new Double(e.getY()));
                //   67  147:aload_0         
                //   68  148:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   69  151:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //   70  154:new             #51  <Class Double>
                //   71  157:dup             
                //   72  158:aload_1         
                //   73  159:invokevirtual   #64  <Method int MouseEvent.getY()>
                //   74  162:i2d             
                //   75  163:invokespecial   #54  <Method void Double(double)>
                //   76  166:invokevirtual   #58  <Method void FastVector.addElement(Object)>
                        Graphics g = m_plot2D.getGraphics();
                //   77  169:aload_0         
                //   78  170:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   79  173:getfield        #68  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //   80  176:invokevirtual   #74  <Method Graphics Plot2D.getGraphics()>
                //   81  179:astore_2        
                        g.setColor(Color.black);
                //   82  180:aload_2         
                //   83  181:getstatic       #80  <Field Color Color.black>
                //   84  184:invokevirtual   #86  <Method void Graphics.setColor(Color)>
                        g.setXORMode(Color.white);
                //   85  187:aload_2         
                //   86  188:getstatic       #89  <Field Color Color.white>
                //   87  191:invokevirtual   #92  <Method void Graphics.setXORMode(Color)>
                        g.drawRect(((Double)m_shapePoints.elementAt(1)).intValue(), ((Double)m_shapePoints.elementAt(2)).intValue(), ((Double)m_shapePoints.elementAt(3)).intValue() - ((Double)m_shapePoints.elementAt(1)).intValue(), ((Double)m_shapePoints.elementAt(4)).intValue() - ((Double)m_shapePoints.elementAt(2)).intValue());
                //   88  194:aload_2         
                //   89  195:aload_0         
                //   90  196:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   91  199:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //   92  202:iconst_1        
                //   93  203:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //   94  206:checkcast       #51  <Class Double>
                //   95  209:invokevirtual   #99  <Method int Double.intValue()>
                //   96  212:aload_0         
                //   97  213:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   98  216:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //   99  219:iconst_2        
                //  100  220:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //  101  223:checkcast       #51  <Class Double>
                //  102  226:invokevirtual   #99  <Method int Double.intValue()>
                //  103  229:aload_0         
                //  104  230:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  105  233:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  106  236:iconst_3        
                //  107  237:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //  108  240:checkcast       #51  <Class Double>
                //  109  243:invokevirtual   #99  <Method int Double.intValue()>
                //  110  246:aload_0         
                //  111  247:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  112  250:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  113  253:iconst_1        
                //  114  254:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //  115  257:checkcast       #51  <Class Double>
                //  116  260:invokevirtual   #99  <Method int Double.intValue()>
                //  117  263:isub            
                //  118  264:aload_0         
                //  119  265:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  120  268:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  121  271:iconst_4        
                //  122  272:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //  123  275:checkcast       #51  <Class Double>
                //  124  278:invokevirtual   #99  <Method int Double.intValue()>
                //  125  281:aload_0         
                //  126  282:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  127  285:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  128  288:iconst_2        
                //  129  289:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //  130  292:checkcast       #51  <Class Double>
                //  131  295:invokevirtual   #99  <Method int Double.intValue()>
                //  132  298:isub            
                //  133  299:invokevirtual   #103 <Method void Graphics.drawRect(int, int, int, int)>
                        g.dispose();
                //  134  302:aload_2         
                //  135  303:invokevirtual   #106 <Method void Graphics.dispose()>
                    }
                //  136  306:return          
                }

                public void mouseClicked(MouseEvent e)
                {
                    if((m_sIndex == 2 || m_sIndex == 3) && (m_createShape || (e.getModifiers() & 0x10) == 16))
                //*   0    0:aload_0         
                //*   1    1:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //*   2    4:getfield        #32  <Field int VisualizePanel$PlotPanel.m_sIndex>
                //*   3    7:iconst_2        
                //*   4    8:icmpeq          22
                //*   5   11:aload_0         
                //*   6   12:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //*   7   15:getfield        #32  <Field int VisualizePanel$PlotPanel.m_sIndex>
                //*   8   18:iconst_3        
                //*   9   19:icmpne          1788
                //*  10   22:aload_0         
                //*  11   23:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //*  12   26:invokestatic    #115 <Method boolean VisualizePanel$PlotPanel.access$3(VisualizePanel$PlotPanel)>
                //*  13   29:ifne            44
                //*  14   32:aload_1         
                //*  15   33:invokevirtual   #26  <Method int MouseEvent.getModifiers()>
                //*  16   36:bipush          16
                //*  17   38:iand            
                //*  18   39:bipush          16
                //*  19   41:icmpne          1788
                    {
                        if(m_createShape)
                //*  20   44:aload_0         
                //*  21   45:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //*  22   48:invokestatic    #115 <Method boolean VisualizePanel$PlotPanel.access$3(VisualizePanel$PlotPanel)>
                //*  23   51:ifeq            1517
                        {
                            Graphics g = m_plot2D.getGraphics();
                //   24   54:aload_0         
                //   25   55:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   26   58:getfield        #68  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //   27   61:invokevirtual   #74  <Method Graphics Plot2D.getGraphics()>
                //   28   64:astore_2        
                            g.setColor(Color.black);
                //   29   65:aload_2         
                //   30   66:getstatic       #80  <Field Color Color.black>
                //   31   69:invokevirtual   #86  <Method void Graphics.setColor(Color)>
                            g.setXORMode(Color.white);
                //   32   72:aload_2         
                //   33   73:getstatic       #89  <Field Color Color.white>
                //   34   76:invokevirtual   #92  <Method void Graphics.setXORMode(Color)>
                            if((e.getModifiers() & 0x10) == 16 && !e.isAltDown())
                //*  35   79:aload_1         
                //*  36   80:invokevirtual   #26  <Method int MouseEvent.getModifiers()>
                //*  37   83:bipush          16
                //*  38   85:iand            
                //*  39   86:bipush          16
                //*  40   88:icmpne          301
                //*  41   91:aload_1         
                //*  42   92:invokevirtual   #119 <Method boolean MouseEvent.isAltDown()>
                //*  43   95:ifne            301
                            {
                                m_shapePoints.addElement(new Double(m_plot2D.convertToAttribX(e.getX())));
                //   44   98:aload_0         
                //   45   99:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   46  102:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //   47  105:new             #51  <Class Double>
                //   48  108:dup             
                //   49  109:aload_0         
                //   50  110:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   51  113:getfield        #68  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //   52  116:aload_1         
                //   53  117:invokevirtual   #61  <Method int MouseEvent.getX()>
                //   54  120:i2d             
                //   55  121:invokevirtual   #123 <Method double Plot2D.convertToAttribX(double)>
                //   56  124:invokespecial   #54  <Method void Double(double)>
                //   57  127:invokevirtual   #58  <Method void FastVector.addElement(Object)>
                                m_shapePoints.addElement(new Double(m_plot2D.convertToAttribY(e.getY())));
                //   58  130:aload_0         
                //   59  131:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   60  134:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //   61  137:new             #51  <Class Double>
                //   62  140:dup             
                //   63  141:aload_0         
                //   64  142:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   65  145:getfield        #68  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //   66  148:aload_1         
                //   67  149:invokevirtual   #64  <Method int MouseEvent.getY()>
                //   68  152:i2d             
                //   69  153:invokevirtual   #126 <Method double Plot2D.convertToAttribY(double)>
                //   70  156:invokespecial   #54  <Method void Double(double)>
                //   71  159:invokevirtual   #58  <Method void FastVector.addElement(Object)>
                                m_newMousePos.width = e.getX();
                //   72  162:aload_0         
                //   73  163:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   74  166:invokestatic    #130 <Method Dimension VisualizePanel$PlotPanel.access$4(VisualizePanel$PlotPanel)>
                //   75  169:aload_1         
                //   76  170:invokevirtual   #61  <Method int MouseEvent.getX()>
                //   77  173:putfield        #135 <Field int Dimension.width>
                                m_newMousePos.height = e.getY();
                //   78  176:aload_0         
                //   79  177:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   80  180:invokestatic    #130 <Method Dimension VisualizePanel$PlotPanel.access$4(VisualizePanel$PlotPanel)>
                //   81  183:aload_1         
                //   82  184:invokevirtual   #64  <Method int MouseEvent.getY()>
                //   83  187:putfield        #138 <Field int Dimension.height>
                                g.drawLine((int)Math.ceil(m_plot2D.convertToPanelX(((Double)m_shapePoints.elementAt(m_shapePoints.size() - 2)).doubleValue())), (int)Math.ceil(m_plot2D.convertToPanelY(((Double)m_shapePoints.elementAt(m_shapePoints.size() - 1)).doubleValue())), m_newMousePos.width, m_newMousePos.height);
                //   84  190:aload_2         
                //   85  191:aload_0         
                //   86  192:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   87  195:getfield        #68  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //   88  198:aload_0         
                //   89  199:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   90  202:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //   91  205:aload_0         
                //   92  206:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   93  209:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //   94  212:invokevirtual   #141 <Method int FastVector.size()>
                //   95  215:iconst_2        
                //   96  216:isub            
                //   97  217:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //   98  220:checkcast       #51  <Class Double>
                //   99  223:invokevirtual   #145 <Method double Double.doubleValue()>
                //  100  226:invokevirtual   #148 <Method double Plot2D.convertToPanelX(double)>
                //  101  229:invokestatic    #153 <Method double Math.ceil(double)>
                //  102  232:d2i             
                //  103  233:aload_0         
                //  104  234:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  105  237:getfield        #68  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //  106  240:aload_0         
                //  107  241:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  108  244:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  109  247:aload_0         
                //  110  248:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  111  251:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  112  254:invokevirtual   #141 <Method int FastVector.size()>
                //  113  257:iconst_1        
                //  114  258:isub            
                //  115  259:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //  116  262:checkcast       #51  <Class Double>
                //  117  265:invokevirtual   #145 <Method double Double.doubleValue()>
                //  118  268:invokevirtual   #156 <Method double Plot2D.convertToPanelY(double)>
                //  119  271:invokestatic    #153 <Method double Math.ceil(double)>
                //  120  274:d2i             
                //  121  275:aload_0         
                //  122  276:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  123  279:invokestatic    #130 <Method Dimension VisualizePanel$PlotPanel.access$4(VisualizePanel$PlotPanel)>
                //  124  282:getfield        #135 <Field int Dimension.width>
                //  125  285:aload_0         
                //  126  286:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  127  289:invokestatic    #130 <Method Dimension VisualizePanel$PlotPanel.access$4(VisualizePanel$PlotPanel)>
                //  128  292:getfield        #138 <Field int Dimension.height>
                //  129  295:invokevirtual   #159 <Method void Graphics.drawLine(int, int, int, int)>
                            } else
                //* 130  298:goto            1510
                            if(m_sIndex == 3)
                //* 131  301:aload_0         
                //* 132  302:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //* 133  305:getfield        #32  <Field int VisualizePanel$PlotPanel.m_sIndex>
                //* 134  308:iconst_3        
                //* 135  309:icmpne          1344
                            {
                                m_createShape = false;
                //  136  312:aload_0         
                //  137  313:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  138  316:iconst_0        
                //  139  317:invokestatic    #36  <Method void VisualizePanel$PlotPanel.access$0(VisualizePanel$PlotPanel, boolean)>
                                if(m_shapePoints.size() >= 5)
                //* 140  320:aload_0         
                //* 141  321:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //* 142  324:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //* 143  327:invokevirtual   #141 <Method int FastVector.size()>
                //* 144  330:iconst_5        
                //* 145  331:icmplt          1326
                                {
                                    double cx = Math.ceil(m_plot2D.convertToPanelX(((Double)m_shapePoints.elementAt(m_shapePoints.size() - 4)).doubleValue()));
                //  146  334:aload_0         
                //  147  335:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  148  338:getfield        #68  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //  149  341:aload_0         
                //  150  342:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  151  345:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  152  348:aload_0         
                //  153  349:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  154  352:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  155  355:invokevirtual   #141 <Method int FastVector.size()>
                //  156  358:iconst_4        
                //  157  359:isub            
                //  158  360:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //  159  363:checkcast       #51  <Class Double>
                //  160  366:invokevirtual   #145 <Method double Double.doubleValue()>
                //  161  369:invokevirtual   #148 <Method double Plot2D.convertToPanelX(double)>
                //  162  372:invokestatic    #153 <Method double Math.ceil(double)>
                //  163  375:dstore_3        
                                    double cx2 = Math.ceil(m_plot2D.convertToPanelX(((Double)m_shapePoints.elementAt(m_shapePoints.size() - 2)).doubleValue())) - cx;
                //  164  376:aload_0         
                //  165  377:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  166  380:getfield        #68  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //  167  383:aload_0         
                //  168  384:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  169  387:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  170  390:aload_0         
                //  171  391:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  172  394:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  173  397:invokevirtual   #141 <Method int FastVector.size()>
                //  174  400:iconst_2        
                //  175  401:isub            
                //  176  402:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //  177  405:checkcast       #51  <Class Double>
                //  178  408:invokevirtual   #145 <Method double Double.doubleValue()>
                //  179  411:invokevirtual   #148 <Method double Plot2D.convertToPanelX(double)>
                //  180  414:invokestatic    #153 <Method double Math.ceil(double)>
                //  181  417:dload_3         
                //  182  418:dsub            
                //  183  419:dstore          5
                                    cx2 *= 50000D;
                //  184  421:dload           5
                //  185  423:ldc2w           #160 <Double 50000D>
                //  186  426:dmul            
                //  187  427:dstore          5
                                    double cy = Math.ceil(m_plot2D.convertToPanelY(((Double)m_shapePoints.elementAt(m_shapePoints.size() - 3)).doubleValue()));
                //  188  429:aload_0         
                //  189  430:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  190  433:getfield        #68  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //  191  436:aload_0         
                //  192  437:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  193  440:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  194  443:aload_0         
                //  195  444:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  196  447:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  197  450:invokevirtual   #141 <Method int FastVector.size()>
                //  198  453:iconst_3        
                //  199  454:isub            
                //  200  455:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //  201  458:checkcast       #51  <Class Double>
                //  202  461:invokevirtual   #145 <Method double Double.doubleValue()>
                //  203  464:invokevirtual   #156 <Method double Plot2D.convertToPanelY(double)>
                //  204  467:invokestatic    #153 <Method double Math.ceil(double)>
                //  205  470:dstore          7
                                    double cy2 = Math.ceil(m_plot2D.convertToPanelY(((Double)m_shapePoints.elementAt(m_shapePoints.size() - 1)).doubleValue())) - cy;
                //  206  472:aload_0         
                //  207  473:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  208  476:getfield        #68  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //  209  479:aload_0         
                //  210  480:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  211  483:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  212  486:aload_0         
                //  213  487:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  214  490:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  215  493:invokevirtual   #141 <Method int FastVector.size()>
                //  216  496:iconst_1        
                //  217  497:isub            
                //  218  498:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //  219  501:checkcast       #51  <Class Double>
                //  220  504:invokevirtual   #145 <Method double Double.doubleValue()>
                //  221  507:invokevirtual   #156 <Method double Plot2D.convertToPanelY(double)>
                //  222  510:invokestatic    #153 <Method double Math.ceil(double)>
                //  223  513:dload           7
                //  224  515:dsub            
                //  225  516:dstore          9
                                    cy2 *= 50000D;
                //  226  518:dload           9
                //  227  520:ldc2w           #160 <Double 50000D>
                //  228  523:dmul            
                //  229  524:dstore          9
                                    double cxa = Math.ceil(m_plot2D.convertToPanelX(((Double)m_shapePoints.elementAt(3)).doubleValue()));
                //  230  526:aload_0         
                //  231  527:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  232  530:getfield        #68  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //  233  533:aload_0         
                //  234  534:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  235  537:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  236  540:iconst_3        
                //  237  541:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //  238  544:checkcast       #51  <Class Double>
                //  239  547:invokevirtual   #145 <Method double Double.doubleValue()>
                //  240  550:invokevirtual   #148 <Method double Plot2D.convertToPanelX(double)>
                //  241  553:invokestatic    #153 <Method double Math.ceil(double)>
                //  242  556:dstore          11
                                    double cxa2 = Math.ceil(m_plot2D.convertToPanelX(((Double)m_shapePoints.elementAt(1)).doubleValue())) - cxa;
                //  243  558:aload_0         
                //  244  559:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  245  562:getfield        #68  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //  246  565:aload_0         
                //  247  566:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  248  569:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  249  572:iconst_1        
                //  250  573:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //  251  576:checkcast       #51  <Class Double>
                //  252  579:invokevirtual   #145 <Method double Double.doubleValue()>
                //  253  582:invokevirtual   #148 <Method double Plot2D.convertToPanelX(double)>
                //  254  585:invokestatic    #153 <Method double Math.ceil(double)>
                //  255  588:dload           11
                //  256  590:dsub            
                //  257  591:dstore          13
                                    cxa2 *= 50000D;
                //  258  593:dload           13
                //  259  595:ldc2w           #160 <Double 50000D>
                //  260  598:dmul            
                //  261  599:dstore          13
                                    double cya = Math.ceil(m_plot2D.convertToPanelY(((Double)m_shapePoints.elementAt(4)).doubleValue()));
                //  262  601:aload_0         
                //  263  602:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  264  605:getfield        #68  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //  265  608:aload_0         
                //  266  609:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  267  612:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  268  615:iconst_4        
                //  269  616:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //  270  619:checkcast       #51  <Class Double>
                //  271  622:invokevirtual   #145 <Method double Double.doubleValue()>
                //  272  625:invokevirtual   #156 <Method double Plot2D.convertToPanelY(double)>
                //  273  628:invokestatic    #153 <Method double Math.ceil(double)>
                //  274  631:dstore          15
                                    double cya2 = Math.ceil(m_plot2D.convertToPanelY(((Double)m_shapePoints.elementAt(2)).doubleValue())) - cya;
                //  275  633:aload_0         
                //  276  634:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  277  637:getfield        #68  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //  278  640:aload_0         
                //  279  641:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  280  644:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  281  647:iconst_2        
                //  282  648:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //  283  651:checkcast       #51  <Class Double>
                //  284  654:invokevirtual   #145 <Method double Double.doubleValue()>
                //  285  657:invokevirtual   #156 <Method double Plot2D.convertToPanelY(double)>
                //  286  660:invokestatic    #153 <Method double Math.ceil(double)>
                //  287  663:dload           15
                //  288  665:dsub            
                //  289  666:dstore          17
                                    cya2 *= 50000D;
                //  290  668:dload           17
                //  291  670:ldc2w           #160 <Double 50000D>
                //  292  673:dmul            
                //  293  674:dstore          17
                                    m_shapePoints.setElementAt(new Double(m_plot2D.convertToAttribX(cxa2 + cxa)), 1);
                //  294  676:aload_0         
                //  295  677:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  296  680:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  297  683:new             #51  <Class Double>
                //  298  686:dup             
                //  299  687:aload_0         
                //  300  688:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  301  691:getfield        #68  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //  302  694:dload           13
                //  303  696:dload           11
                //  304  698:dadd            
                //  305  699:invokevirtual   #123 <Method double Plot2D.convertToAttribX(double)>
                //  306  702:invokespecial   #54  <Method void Double(double)>
                //  307  705:iconst_1        
                //  308  706:invokevirtual   #165 <Method void FastVector.setElementAt(Object, int)>
                                    m_shapePoints.setElementAt(new Double(m_plot2D.convertToAttribY(cy2 + cy)), m_shapePoints.size() - 1);
                //  309  709:aload_0         
                //  310  710:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  311  713:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  312  716:new             #51  <Class Double>
                //  313  719:dup             
                //  314  720:aload_0         
                //  315  721:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  316  724:getfield        #68  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //  317  727:dload           9
                //  318  729:dload           7
                //  319  731:dadd            
                //  320  732:invokevirtual   #126 <Method double Plot2D.convertToAttribY(double)>
                //  321  735:invokespecial   #54  <Method void Double(double)>
                //  322  738:aload_0         
                //  323  739:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  324  742:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  325  745:invokevirtual   #141 <Method int FastVector.size()>
                //  326  748:iconst_1        
                //  327  749:isub            
                //  328  750:invokevirtual   #165 <Method void FastVector.setElementAt(Object, int)>
                                    m_shapePoints.setElementAt(new Double(m_plot2D.convertToAttribX(cx2 + cx)), m_shapePoints.size() - 2);
                //  329  753:aload_0         
                //  330  754:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  331  757:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  332  760:new             #51  <Class Double>
                //  333  763:dup             
                //  334  764:aload_0         
                //  335  765:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  336  768:getfield        #68  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //  337  771:dload           5
                //  338  773:dload_3         
                //  339  774:dadd            
                //  340  775:invokevirtual   #123 <Method double Plot2D.convertToAttribX(double)>
                //  341  778:invokespecial   #54  <Method void Double(double)>
                //  342  781:aload_0         
                //  343  782:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  344  785:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  345  788:invokevirtual   #141 <Method int FastVector.size()>
                //  346  791:iconst_2        
                //  347  792:isub            
                //  348  793:invokevirtual   #165 <Method void FastVector.setElementAt(Object, int)>
                                    m_shapePoints.setElementAt(new Double(m_plot2D.convertToAttribY(cya2 + cya)), 2);
                //  349  796:aload_0         
                //  350  797:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  351  800:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  352  803:new             #51  <Class Double>
                //  353  806:dup             
                //  354  807:aload_0         
                //  355  808:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  356  811:getfield        #68  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //  357  814:dload           17
                //  358  816:dload           15
                //  359  818:dadd            
                //  360  819:invokevirtual   #126 <Method double Plot2D.convertToAttribY(double)>
                //  361  822:invokespecial   #54  <Method void Double(double)>
                //  362  825:iconst_2        
                //  363  826:invokevirtual   #165 <Method void FastVector.setElementAt(Object, int)>
                                    cy = (1.0D / 0.0D);
                //  364  829:ldc2w           #166 <Double (1.0D / 0.0D)>
                //  365  832:dstore          7
                                    cy2 = (-1.0D / 0.0D);
                //  366  834:ldc2w           #168 <Double (-1.0D / 0.0D)>
                //  367  837:dstore          9
                                    if(((Double)m_shapePoints.elementAt(1)).doubleValue() > ((Double)m_shapePoints.elementAt(3)).doubleValue() && ((Double)m_shapePoints.elementAt(2)).doubleValue() == ((Double)m_shapePoints.elementAt(4)).doubleValue())
                //* 368  839:aload_0         
                //* 369  840:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //* 370  843:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //* 371  846:iconst_1        
                //* 372  847:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //* 373  850:checkcast       #51  <Class Double>
                //* 374  853:invokevirtual   #145 <Method double Double.doubleValue()>
                //* 375  856:aload_0         
                //* 376  857:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //* 377  860:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //* 378  863:iconst_3        
                //* 379  864:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //* 380  867:checkcast       #51  <Class Double>
                //* 381  870:invokevirtual   #145 <Method double Double.doubleValue()>
                //* 382  873:dcmpl           
                //* 383  874:ifle            934
                //* 384  877:aload_0         
                //* 385  878:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //* 386  881:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //* 387  884:iconst_2        
                //* 388  885:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //* 389  888:checkcast       #51  <Class Double>
                //* 390  891:invokevirtual   #145 <Method double Double.doubleValue()>
                //* 391  894:aload_0         
                //* 392  895:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //* 393  898:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //* 394  901:iconst_4        
                //* 395  902:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //* 396  905:checkcast       #51  <Class Double>
                //* 397  908:invokevirtual   #145 <Method double Double.doubleValue()>
                //* 398  911:dcmpl           
                //* 399  912:ifne            934
                                        cy = ((Double)m_shapePoints.elementAt(2)).doubleValue();
                //  400  915:aload_0         
                //  401  916:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  402  919:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  403  922:iconst_2        
                //  404  923:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //  405  926:checkcast       #51  <Class Double>
                //  406  929:invokevirtual   #145 <Method double Double.doubleValue()>
                //  407  932:dstore          7
                                    if(((Double)m_shapePoints.elementAt(m_shapePoints.size() - 2)).doubleValue() > ((Double)m_shapePoints.elementAt(m_shapePoints.size() - 4)).doubleValue() && ((Double)m_shapePoints.elementAt(m_shapePoints.size() - 3)).doubleValue() == ((Double)m_shapePoints.elementAt(m_shapePoints.size() - 1)).doubleValue())
                //* 408  934:aload_0         
                //* 409  935:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //* 410  938:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //* 411  941:aload_0         
                //* 412  942:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //* 413  945:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //* 414  948:invokevirtual   #141 <Method int FastVector.size()>
                //* 415  951:iconst_2        
                //* 416  952:isub            
                //* 417  953:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //* 418  956:checkcast       #51  <Class Double>
                //* 419  959:invokevirtual   #145 <Method double Double.doubleValue()>
                //* 420  962:aload_0         
                //* 421  963:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //* 422  966:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //* 423  969:aload_0         
                //* 424  970:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //* 425  973:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //* 426  976:invokevirtual   #141 <Method int FastVector.size()>
                //* 427  979:iconst_4        
                //* 428  980:isub            
                //* 429  981:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //* 430  984:checkcast       #51  <Class Double>
                //* 431  987:invokevirtual   #145 <Method double Double.doubleValue()>
                //* 432  990:dcmpl           
                //* 433  991:ifle            1072
                //* 434  994:aload_0         
                //* 435  995:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //* 436  998:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //* 437 1001:aload_0         
                //* 438 1002:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //* 439 1005:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //* 440 1008:invokevirtual   #141 <Method int FastVector.size()>
                //* 441 1011:iconst_3        
                //* 442 1012:isub            
                //* 443 1013:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //* 444 1016:checkcast       #51  <Class Double>
                //* 445 1019:invokevirtual   #145 <Method double Double.doubleValue()>
                //* 446 1022:aload_0         
                //* 447 1023:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //* 448 1026:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //* 449 1029:aload_0         
                //* 450 1030:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //* 451 1033:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //* 452 1036:invokevirtual   #141 <Method int FastVector.size()>
                //* 453 1039:iconst_1        
                //* 454 1040:isub            
                //* 455 1041:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //* 456 1044:checkcast       #51  <Class Double>
                //* 457 1047:invokevirtual   #145 <Method double Double.doubleValue()>
                //* 458 1050:dcmpl           
                //* 459 1051:ifne            1072
                                        cy2 = ((Double)m_shapePoints.lastElement()).doubleValue();
                //  460 1054:aload_0         
                //  461 1055:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  462 1058:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  463 1061:invokevirtual   #173 <Method Object FastVector.lastElement()>
                //  464 1064:checkcast       #51  <Class Double>
                //  465 1067:invokevirtual   #145 <Method double Double.doubleValue()>
                //  466 1070:dstore          9
                                    m_shapePoints.addElement(new Double(cy));
                //  467 1072:aload_0         
                //  468 1073:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  469 1076:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  470 1079:new             #51  <Class Double>
                //  471 1082:dup             
                //  472 1083:dload           7
                //  473 1085:invokespecial   #54  <Method void Double(double)>
                //  474 1088:invokevirtual   #58  <Method void FastVector.addElement(Object)>
                                    m_shapePoints.addElement(new Double(cy2));
                //  475 1091:aload_0         
                //  476 1092:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  477 1095:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  478 1098:new             #51  <Class Double>
                //  479 1101:dup             
                //  480 1102:dload           9
                //  481 1104:invokespecial   #54  <Method void Double(double)>
                //  482 1107:invokevirtual   #58  <Method void FastVector.addElement(Object)>
                                    if(!inPolyline(m_shapePoints, m_plot2D.convertToAttribX(e.getX()), m_plot2D.convertToAttribY(e.getY())))
                //* 483 1110:aload_0         
                //* 484 1111:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //* 485 1114:aload_0         
                //* 486 1115:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //* 487 1118:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //* 488 1121:aload_0         
                //* 489 1122:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //* 490 1125:getfield        #68  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //* 491 1128:aload_1         
                //* 492 1129:invokevirtual   #61  <Method int MouseEvent.getX()>
                //* 493 1132:i2d             
                //* 494 1133:invokevirtual   #123 <Method double Plot2D.convertToAttribX(double)>
                //* 495 1136:aload_0         
                //* 496 1137:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //* 497 1140:getfield        #68  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //* 498 1143:aload_1         
                //* 499 1144:invokevirtual   #64  <Method int MouseEvent.getY()>
                //* 500 1147:i2d             
                //* 501 1148:invokevirtual   #126 <Method double Plot2D.convertToAttribY(double)>
                //* 502 1151:invokestatic    #177 <Method boolean VisualizePanel$PlotPanel.access$5(VisualizePanel$PlotPanel, FastVector, double, double)>
                //* 503 1154:ifne            1240
                                    {
                                        Double tmp = (Double)m_shapePoints.elementAt(m_shapePoints.size() - 2);
                //  504 1157:aload_0         
                //  505 1158:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  506 1161:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  507 1164:aload_0         
                //  508 1165:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  509 1168:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  510 1171:invokevirtual   #141 <Method int FastVector.size()>
                //  511 1174:iconst_2        
                //  512 1175:isub            
                //  513 1176:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //  514 1179:checkcast       #51  <Class Double>
                //  515 1182:astore          19
                                        m_shapePoints.setElementAt(m_shapePoints.lastElement(), m_shapePoints.size() - 2);
                //  516 1184:aload_0         
                //  517 1185:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  518 1188:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  519 1191:aload_0         
                //  520 1192:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  521 1195:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  522 1198:invokevirtual   #173 <Method Object FastVector.lastElement()>
                //  523 1201:aload_0         
                //  524 1202:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  525 1205:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  526 1208:invokevirtual   #141 <Method int FastVector.size()>
                //  527 1211:iconst_2        
                //  528 1212:isub            
                //  529 1213:invokevirtual   #165 <Method void FastVector.setElementAt(Object, int)>
                                        m_shapePoints.setElementAt(tmp, m_shapePoints.size() - 1);
                //  530 1216:aload_0         
                //  531 1217:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  532 1220:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  533 1223:aload           19
                //  534 1225:aload_0         
                //  535 1226:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  536 1229:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  537 1232:invokevirtual   #141 <Method int FastVector.size()>
                //  538 1235:iconst_1        
                //  539 1236:isub            
                //  540 1237:invokevirtual   #165 <Method void FastVector.setElementAt(Object, int)>
                                    }
                                    if(m_shapes == null)
                //* 541 1240:aload_0         
                //* 542 1241:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //* 543 1244:invokestatic    #180 <Method FastVector VisualizePanel$PlotPanel.access$6(VisualizePanel$PlotPanel)>
                //* 544 1247:ifnonnull       1265
                                        m_shapes = new FastVector(4);
                //  545 1250:aload_0         
                //  546 1251:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  547 1254:new             #38  <Class FastVector>
                //  548 1257:dup             
                //  549 1258:iconst_4        
                //  550 1259:invokespecial   #41  <Method void FastVector(int)>
                //  551 1262:invokestatic    #183 <Method void VisualizePanel$PlotPanel.access$7(VisualizePanel$PlotPanel, FastVector)>
                                    m_shapes.addElement(m_shapePoints);
                //  552 1265:aload_0         
                //  553 1266:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  554 1269:invokestatic    #180 <Method FastVector VisualizePanel$PlotPanel.access$6(VisualizePanel$PlotPanel)>
                //  555 1272:aload_0         
                //  556 1273:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  557 1276:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  558 1279:invokevirtual   #58  <Method void FastVector.addElement(Object)>
                                    m_submit.setText("Submit");
                //  559 1282:aload_0         
                //  560 1283:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  561 1286:invokestatic    #187 <Method VisualizePanel VisualizePanel$PlotPanel.access$9(VisualizePanel$PlotPanel)>
                //  562 1289:getfield        #193 <Field JButton VisualizePanel.m_submit>
                //  563 1292:ldc1            #195 <String "Submit">
                //  564 1294:invokevirtual   #201 <Method void JButton.setText(String)>
                                    m_submit.setActionCommand("Submit");
                //  565 1297:aload_0         
                //  566 1298:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  567 1301:invokestatic    #187 <Method VisualizePanel VisualizePanel$PlotPanel.access$9(VisualizePanel$PlotPanel)>
                //  568 1304:getfield        #193 <Field JButton VisualizePanel.m_submit>
                //  569 1307:ldc1            #195 <String "Submit">
                //  570 1309:invokevirtual   #204 <Method void JButton.setActionCommand(String)>
                                    m_submit.setEnabled(true);
                //  571 1312:aload_0         
                //  572 1313:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  573 1316:invokestatic    #187 <Method VisualizePanel VisualizePanel$PlotPanel.access$9(VisualizePanel$PlotPanel)>
                //  574 1319:getfield        #193 <Field JButton VisualizePanel.m_submit>
                //  575 1322:iconst_1        
                //  576 1323:invokevirtual   #208 <Method void JButton.setEnabled(boolean)>
                                }
                                m_shapePoints = null;
                //  577 1326:aload_0         
                //  578 1327:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  579 1330:aconst_null     
                //  580 1331:invokestatic    #45  <Method void VisualizePanel$PlotPanel.access$1(VisualizePanel$PlotPanel, FastVector)>
                                repaint();
                //  581 1334:aload_0         
                //  582 1335:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  583 1338:invokevirtual   #211 <Method void VisualizePanel$PlotPanel.repaint()>
                            } else
                //* 584 1341:goto            1510
                            {
                                m_createShape = false;
                //  585 1344:aload_0         
                //  586 1345:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  587 1348:iconst_0        
                //  588 1349:invokestatic    #36  <Method void VisualizePanel$PlotPanel.access$0(VisualizePanel$PlotPanel, boolean)>
                                if(m_shapePoints.size() >= 7)
                //* 589 1352:aload_0         
                //* 590 1353:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //* 591 1356:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //* 592 1359:invokevirtual   #141 <Method int FastVector.size()>
                //* 593 1362:bipush          7
                //* 594 1364:icmplt          1495
                                {
                                    m_shapePoints.addElement(m_shapePoints.elementAt(1));
                //  595 1367:aload_0         
                //  596 1368:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  597 1371:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  598 1374:aload_0         
                //  599 1375:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  600 1378:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  601 1381:iconst_1        
                //  602 1382:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //  603 1385:invokevirtual   #58  <Method void FastVector.addElement(Object)>
                                    m_shapePoints.addElement(m_shapePoints.elementAt(2));
                //  604 1388:aload_0         
                //  605 1389:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  606 1392:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  607 1395:aload_0         
                //  608 1396:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  609 1399:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  610 1402:iconst_2        
                //  611 1403:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //  612 1406:invokevirtual   #58  <Method void FastVector.addElement(Object)>
                                    if(m_shapes == null)
                //* 613 1409:aload_0         
                //* 614 1410:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //* 615 1413:invokestatic    #180 <Method FastVector VisualizePanel$PlotPanel.access$6(VisualizePanel$PlotPanel)>
                //* 616 1416:ifnonnull       1434
                                        m_shapes = new FastVector(4);
                //  617 1419:aload_0         
                //  618 1420:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  619 1423:new             #38  <Class FastVector>
                //  620 1426:dup             
                //  621 1427:iconst_4        
                //  622 1428:invokespecial   #41  <Method void FastVector(int)>
                //  623 1431:invokestatic    #183 <Method void VisualizePanel$PlotPanel.access$7(VisualizePanel$PlotPanel, FastVector)>
                                    m_shapes.addElement(m_shapePoints);
                //  624 1434:aload_0         
                //  625 1435:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  626 1438:invokestatic    #180 <Method FastVector VisualizePanel$PlotPanel.access$6(VisualizePanel$PlotPanel)>
                //  627 1441:aload_0         
                //  628 1442:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  629 1445:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  630 1448:invokevirtual   #58  <Method void FastVector.addElement(Object)>
                                    m_submit.setText("Submit");
                //  631 1451:aload_0         
                //  632 1452:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  633 1455:invokestatic    #187 <Method VisualizePanel VisualizePanel$PlotPanel.access$9(VisualizePanel$PlotPanel)>
                //  634 1458:getfield        #193 <Field JButton VisualizePanel.m_submit>
                //  635 1461:ldc1            #195 <String "Submit">
                //  636 1463:invokevirtual   #201 <Method void JButton.setText(String)>
                                    m_submit.setActionCommand("Submit");
                //  637 1466:aload_0         
                //  638 1467:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  639 1470:invokestatic    #187 <Method VisualizePanel VisualizePanel$PlotPanel.access$9(VisualizePanel$PlotPanel)>
                //  640 1473:getfield        #193 <Field JButton VisualizePanel.m_submit>
                //  641 1476:ldc1            #195 <String "Submit">
                //  642 1478:invokevirtual   #204 <Method void JButton.setActionCommand(String)>
                                    m_submit.setEnabled(true);
                //  643 1481:aload_0         
                //  644 1482:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  645 1485:invokestatic    #187 <Method VisualizePanel VisualizePanel$PlotPanel.access$9(VisualizePanel$PlotPanel)>
                //  646 1488:getfield        #193 <Field JButton VisualizePanel.m_submit>
                //  647 1491:iconst_1        
                //  648 1492:invokevirtual   #208 <Method void JButton.setEnabled(boolean)>
                                }
                                m_shapePoints = null;
                //  649 1495:aload_0         
                //  650 1496:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  651 1499:aconst_null     
                //  652 1500:invokestatic    #45  <Method void VisualizePanel$PlotPanel.access$1(VisualizePanel$PlotPanel, FastVector)>
                                repaint();
                //  653 1503:aload_0         
                //  654 1504:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  655 1507:invokevirtual   #211 <Method void VisualizePanel$PlotPanel.repaint()>
                            }
                            g.dispose();
                //  656 1510:aload_2         
                //  657 1511:invokevirtual   #106 <Method void Graphics.dispose()>
                        } else
                //* 658 1514:goto            1841
                        if((e.getModifiers() & 0x10) == 16)
                //* 659 1517:aload_1         
                //* 660 1518:invokevirtual   #26  <Method int MouseEvent.getModifiers()>
                //* 661 1521:bipush          16
                //* 662 1523:iand            
                //* 663 1524:bipush          16
                //* 664 1526:icmpne          1841
                        {
                            m_createShape = true;
                //  665 1529:aload_0         
                //  666 1530:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  667 1533:iconst_1        
                //  668 1534:invokestatic    #36  <Method void VisualizePanel$PlotPanel.access$0(VisualizePanel$PlotPanel, boolean)>
                            m_shapePoints = new FastVector(17);
                //  669 1537:aload_0         
                //  670 1538:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  671 1541:new             #38  <Class FastVector>
                //  672 1544:dup             
                //  673 1545:bipush          17
                //  674 1547:invokespecial   #41  <Method void FastVector(int)>
                //  675 1550:invokestatic    #45  <Method void VisualizePanel$PlotPanel.access$1(VisualizePanel$PlotPanel, FastVector)>
                            m_shapePoints.addElement(new Double(m_sIndex));
                //  676 1553:aload_0         
                //  677 1554:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  678 1557:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  679 1560:new             #51  <Class Double>
                //  680 1563:dup             
                //  681 1564:aload_0         
                //  682 1565:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  683 1568:getfield        #32  <Field int VisualizePanel$PlotPanel.m_sIndex>
                //  684 1571:i2d             
                //  685 1572:invokespecial   #54  <Method void Double(double)>
                //  686 1575:invokevirtual   #58  <Method void FastVector.addElement(Object)>
                            m_shapePoints.addElement(new Double(m_plot2D.convertToAttribX(e.getX())));
                //  687 1578:aload_0         
                //  688 1579:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  689 1582:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  690 1585:new             #51  <Class Double>
                //  691 1588:dup             
                //  692 1589:aload_0         
                //  693 1590:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  694 1593:getfield        #68  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //  695 1596:aload_1         
                //  696 1597:invokevirtual   #61  <Method int MouseEvent.getX()>
                //  697 1600:i2d             
                //  698 1601:invokevirtual   #123 <Method double Plot2D.convertToAttribX(double)>
                //  699 1604:invokespecial   #54  <Method void Double(double)>
                //  700 1607:invokevirtual   #58  <Method void FastVector.addElement(Object)>
                            m_shapePoints.addElement(new Double(m_plot2D.convertToAttribY(e.getY())));
                //  701 1610:aload_0         
                //  702 1611:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  703 1614:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  704 1617:new             #51  <Class Double>
                //  705 1620:dup             
                //  706 1621:aload_0         
                //  707 1622:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  708 1625:getfield        #68  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //  709 1628:aload_1         
                //  710 1629:invokevirtual   #64  <Method int MouseEvent.getY()>
                //  711 1632:i2d             
                //  712 1633:invokevirtual   #126 <Method double Plot2D.convertToAttribY(double)>
                //  713 1636:invokespecial   #54  <Method void Double(double)>
                //  714 1639:invokevirtual   #58  <Method void FastVector.addElement(Object)>
                            m_newMousePos.width = e.getX();
                //  715 1642:aload_0         
                //  716 1643:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  717 1646:invokestatic    #130 <Method Dimension VisualizePanel$PlotPanel.access$4(VisualizePanel$PlotPanel)>
                //  718 1649:aload_1         
                //  719 1650:invokevirtual   #61  <Method int MouseEvent.getX()>
                //  720 1653:putfield        #135 <Field int Dimension.width>
                            m_newMousePos.height = e.getY();
                //  721 1656:aload_0         
                //  722 1657:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  723 1660:invokestatic    #130 <Method Dimension VisualizePanel$PlotPanel.access$4(VisualizePanel$PlotPanel)>
                //  724 1663:aload_1         
                //  725 1664:invokevirtual   #64  <Method int MouseEvent.getY()>
                //  726 1667:putfield        #138 <Field int Dimension.height>
                            Graphics g = m_plot2D.getGraphics();
                //  727 1670:aload_0         
                //  728 1671:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  729 1674:getfield        #68  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //  730 1677:invokevirtual   #74  <Method Graphics Plot2D.getGraphics()>
                //  731 1680:astore_2        
                            g.setColor(Color.black);
                //  732 1681:aload_2         
                //  733 1682:getstatic       #80  <Field Color Color.black>
                //  734 1685:invokevirtual   #86  <Method void Graphics.setColor(Color)>
                            g.setXORMode(Color.white);
                //  735 1688:aload_2         
                //  736 1689:getstatic       #89  <Field Color Color.white>
                //  737 1692:invokevirtual   #92  <Method void Graphics.setXORMode(Color)>
                            g.drawLine((int)Math.ceil(m_plot2D.convertToPanelX(((Double)m_shapePoints.elementAt(1)).doubleValue())), (int)Math.ceil(m_plot2D.convertToPanelY(((Double)m_shapePoints.elementAt(2)).doubleValue())), m_newMousePos.width, m_newMousePos.height);
                //  738 1695:aload_2         
                //  739 1696:aload_0         
                //  740 1697:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  741 1700:getfield        #68  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //  742 1703:aload_0         
                //  743 1704:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  744 1707:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  745 1710:iconst_1        
                //  746 1711:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //  747 1714:checkcast       #51  <Class Double>
                //  748 1717:invokevirtual   #145 <Method double Double.doubleValue()>
                //  749 1720:invokevirtual   #148 <Method double Plot2D.convertToPanelX(double)>
                //  750 1723:invokestatic    #153 <Method double Math.ceil(double)>
                //  751 1726:d2i             
                //  752 1727:aload_0         
                //  753 1728:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  754 1731:getfield        #68  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //  755 1734:aload_0         
                //  756 1735:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  757 1738:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  758 1741:iconst_2        
                //  759 1742:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //  760 1745:checkcast       #51  <Class Double>
                //  761 1748:invokevirtual   #145 <Method double Double.doubleValue()>
                //  762 1751:invokevirtual   #156 <Method double Plot2D.convertToPanelY(double)>
                //  763 1754:invokestatic    #153 <Method double Math.ceil(double)>
                //  764 1757:d2i             
                //  765 1758:aload_0         
                //  766 1759:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  767 1762:invokestatic    #130 <Method Dimension VisualizePanel$PlotPanel.access$4(VisualizePanel$PlotPanel)>
                //  768 1765:getfield        #135 <Field int Dimension.width>
                //  769 1768:aload_0         
                //  770 1769:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  771 1772:invokestatic    #130 <Method Dimension VisualizePanel$PlotPanel.access$4(VisualizePanel$PlotPanel)>
                //  772 1775:getfield        #138 <Field int Dimension.height>
                //  773 1778:invokevirtual   #159 <Method void Graphics.drawLine(int, int, int, int)>
                            g.dispose();
                //  774 1781:aload_2         
                //  775 1782:invokevirtual   #106 <Method void Graphics.dispose()>
                        }
                    } else
                //* 776 1785:goto            1841
                    if((e.getModifiers() & 0x10) == 16)
                //* 777 1788:aload_1         
                //* 778 1789:invokevirtual   #26  <Method int MouseEvent.getModifiers()>
                //* 779 1792:bipush          16
                //* 780 1794:iand            
                //* 781 1795:bipush          16
                //* 782 1797:icmpne          1822
                        m_plot2D.searchPoints(e.getX(), e.getY(), false);
                //  783 1800:aload_0         
                //  784 1801:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  785 1804:getfield        #68  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //  786 1807:aload_1         
                //  787 1808:invokevirtual   #61  <Method int MouseEvent.getX()>
                //  788 1811:aload_1         
                //  789 1812:invokevirtual   #64  <Method int MouseEvent.getY()>
                //  790 1815:iconst_0        
                //  791 1816:invokevirtual   #215 <Method void Plot2D.searchPoints(int, int, boolean)>
                    else
                //* 792 1819:goto            1841
                        m_plot2D.searchPoints(e.getX(), e.getY(), true);
                //  793 1822:aload_0         
                //  794 1823:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  795 1826:getfield        #68  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //  796 1829:aload_1         
                //  797 1830:invokevirtual   #61  <Method int MouseEvent.getX()>
                //  798 1833:aload_1         
                //  799 1834:invokevirtual   #64  <Method int MouseEvent.getY()>
                //  800 1837:iconst_1        
                //  801 1838:invokevirtual   #215 <Method void Plot2D.searchPoints(int, int, boolean)>
                //  802 1841:return          
                }

                public void mouseReleased(MouseEvent e)
                {
                    if(m_createShape && ((Double)m_shapePoints.elementAt(0)).intValue() == 1)
                //*   0    0:aload_0         
                //*   1    1:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //*   2    4:invokestatic    #115 <Method boolean VisualizePanel$PlotPanel.access$3(VisualizePanel$PlotPanel)>
                //*   3    7:ifeq            621
                //*   4   10:aload_0         
                //*   5   11:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //*   6   14:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //*   7   17:iconst_0        
                //*   8   18:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //*   9   21:checkcast       #51  <Class Double>
                //*  10   24:invokevirtual   #99  <Method int Double.intValue()>
                //*  11   27:iconst_1        
                //*  12   28:icmpne          621
                    {
                        m_createShape = false;
                //   13   31:aload_0         
                //   14   32:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   15   35:iconst_0        
                //   16   36:invokestatic    #36  <Method void VisualizePanel$PlotPanel.access$0(VisualizePanel$PlotPanel, boolean)>
                        Graphics g = m_plot2D.getGraphics();
                //   17   39:aload_0         
                //   18   40:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   19   43:getfield        #68  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //   20   46:invokevirtual   #74  <Method Graphics Plot2D.getGraphics()>
                //   21   49:astore_2        
                        g.setColor(Color.black);
                //   22   50:aload_2         
                //   23   51:getstatic       #80  <Field Color Color.black>
                //   24   54:invokevirtual   #86  <Method void Graphics.setColor(Color)>
                        g.setXORMode(Color.white);
                //   25   57:aload_2         
                //   26   58:getstatic       #89  <Field Color Color.white>
                //   27   61:invokevirtual   #92  <Method void Graphics.setXORMode(Color)>
                        g.drawRect(((Double)m_shapePoints.elementAt(1)).intValue(), ((Double)m_shapePoints.elementAt(2)).intValue(), ((Double)m_shapePoints.elementAt(3)).intValue() - ((Double)m_shapePoints.elementAt(1)).intValue(), ((Double)m_shapePoints.elementAt(4)).intValue() - ((Double)m_shapePoints.elementAt(2)).intValue());
                //   28   64:aload_2         
                //   29   65:aload_0         
                //   30   66:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   31   69:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //   32   72:iconst_1        
                //   33   73:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //   34   76:checkcast       #51  <Class Double>
                //   35   79:invokevirtual   #99  <Method int Double.intValue()>
                //   36   82:aload_0         
                //   37   83:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   38   86:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //   39   89:iconst_2        
                //   40   90:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //   41   93:checkcast       #51  <Class Double>
                //   42   96:invokevirtual   #99  <Method int Double.intValue()>
                //   43   99:aload_0         
                //   44  100:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   45  103:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //   46  106:iconst_3        
                //   47  107:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //   48  110:checkcast       #51  <Class Double>
                //   49  113:invokevirtual   #99  <Method int Double.intValue()>
                //   50  116:aload_0         
                //   51  117:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   52  120:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //   53  123:iconst_1        
                //   54  124:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //   55  127:checkcast       #51  <Class Double>
                //   56  130:invokevirtual   #99  <Method int Double.intValue()>
                //   57  133:isub            
                //   58  134:aload_0         
                //   59  135:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   60  138:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //   61  141:iconst_4        
                //   62  142:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //   63  145:checkcast       #51  <Class Double>
                //   64  148:invokevirtual   #99  <Method int Double.intValue()>
                //   65  151:aload_0         
                //   66  152:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   67  155:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //   68  158:iconst_2        
                //   69  159:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //   70  162:checkcast       #51  <Class Double>
                //   71  165:invokevirtual   #99  <Method int Double.intValue()>
                //   72  168:isub            
                //   73  169:invokevirtual   #103 <Method void Graphics.drawRect(int, int, int, int)>
                        g.dispose();
                //   74  172:aload_2         
                //   75  173:invokevirtual   #106 <Method void Graphics.dispose()>
                        if(checkPoints(((Double)m_shapePoints.elementAt(1)).doubleValue(), ((Double)m_shapePoints.elementAt(2)).doubleValue()) && checkPoints(((Double)m_shapePoints.elementAt(3)).doubleValue(), ((Double)m_shapePoints.elementAt(4)).doubleValue()) && ((Double)m_shapePoints.elementAt(1)).doubleValue() < ((Double)m_shapePoints.elementAt(3)).doubleValue() && ((Double)m_shapePoints.elementAt(2)).doubleValue() < ((Double)m_shapePoints.elementAt(4)).doubleValue())
                //*  76  176:aload_0         
                //*  77  177:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //*  78  180:aload_0         
                //*  79  181:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //*  80  184:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //*  81  187:iconst_1        
                //*  82  188:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //*  83  191:checkcast       #51  <Class Double>
                //*  84  194:invokevirtual   #145 <Method double Double.doubleValue()>
                //*  85  197:aload_0         
                //*  86  198:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //*  87  201:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //*  88  204:iconst_2        
                //*  89  205:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //*  90  208:checkcast       #51  <Class Double>
                //*  91  211:invokevirtual   #145 <Method double Double.doubleValue()>
                //*  92  214:invokestatic    #231 <Method boolean VisualizePanel$PlotPanel.access$8(VisualizePanel$PlotPanel, double, double)>
                //*  93  217:ifeq            613
                //*  94  220:aload_0         
                //*  95  221:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //*  96  224:aload_0         
                //*  97  225:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //*  98  228:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //*  99  231:iconst_3        
                //* 100  232:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //* 101  235:checkcast       #51  <Class Double>
                //* 102  238:invokevirtual   #145 <Method double Double.doubleValue()>
                //* 103  241:aload_0         
                //* 104  242:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //* 105  245:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //* 106  248:iconst_4        
                //* 107  249:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //* 108  252:checkcast       #51  <Class Double>
                //* 109  255:invokevirtual   #145 <Method double Double.doubleValue()>
                //* 110  258:invokestatic    #231 <Method boolean VisualizePanel$PlotPanel.access$8(VisualizePanel$PlotPanel, double, double)>
                //* 111  261:ifeq            613
                //* 112  264:aload_0         
                //* 113  265:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //* 114  268:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //* 115  271:iconst_1        
                //* 116  272:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //* 117  275:checkcast       #51  <Class Double>
                //* 118  278:invokevirtual   #145 <Method double Double.doubleValue()>
                //* 119  281:aload_0         
                //* 120  282:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //* 121  285:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //* 122  288:iconst_3        
                //* 123  289:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //* 124  292:checkcast       #51  <Class Double>
                //* 125  295:invokevirtual   #145 <Method double Double.doubleValue()>
                //* 126  298:dcmpg           
                //* 127  299:ifge            613
                //* 128  302:aload_0         
                //* 129  303:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //* 130  306:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //* 131  309:iconst_2        
                //* 132  310:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //* 133  313:checkcast       #51  <Class Double>
                //* 134  316:invokevirtual   #145 <Method double Double.doubleValue()>
                //* 135  319:aload_0         
                //* 136  320:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //* 137  323:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //* 138  326:iconst_4        
                //* 139  327:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //* 140  330:checkcast       #51  <Class Double>
                //* 141  333:invokevirtual   #145 <Method double Double.doubleValue()>
                //* 142  336:dcmpg           
                //* 143  337:ifge            613
                        {
                            if(m_shapes == null)
                //* 144  340:aload_0         
                //* 145  341:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //* 146  344:invokestatic    #180 <Method FastVector VisualizePanel$PlotPanel.access$6(VisualizePanel$PlotPanel)>
                //* 147  347:ifnonnull       365
                                m_shapes = new FastVector(2);
                //  148  350:aload_0         
                //  149  351:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  150  354:new             #38  <Class FastVector>
                //  151  357:dup             
                //  152  358:iconst_2        
                //  153  359:invokespecial   #41  <Method void FastVector(int)>
                //  154  362:invokestatic    #183 <Method void VisualizePanel$PlotPanel.access$7(VisualizePanel$PlotPanel, FastVector)>
                            m_shapePoints.setElementAt(new Double(m_plot2D.convertToAttribX(((Double)m_shapePoints.elementAt(1)).doubleValue())), 1);
                //  155  365:aload_0         
                //  156  366:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  157  369:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  158  372:new             #51  <Class Double>
                //  159  375:dup             
                //  160  376:aload_0         
                //  161  377:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  162  380:getfield        #68  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //  163  383:aload_0         
                //  164  384:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  165  387:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  166  390:iconst_1        
                //  167  391:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //  168  394:checkcast       #51  <Class Double>
                //  169  397:invokevirtual   #145 <Method double Double.doubleValue()>
                //  170  400:invokevirtual   #123 <Method double Plot2D.convertToAttribX(double)>
                //  171  403:invokespecial   #54  <Method void Double(double)>
                //  172  406:iconst_1        
                //  173  407:invokevirtual   #165 <Method void FastVector.setElementAt(Object, int)>
                            m_shapePoints.setElementAt(new Double(m_plot2D.convertToAttribY(((Double)m_shapePoints.elementAt(2)).doubleValue())), 2);
                //  174  410:aload_0         
                //  175  411:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  176  414:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  177  417:new             #51  <Class Double>
                //  178  420:dup             
                //  179  421:aload_0         
                //  180  422:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  181  425:getfield        #68  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //  182  428:aload_0         
                //  183  429:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  184  432:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  185  435:iconst_2        
                //  186  436:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //  187  439:checkcast       #51  <Class Double>
                //  188  442:invokevirtual   #145 <Method double Double.doubleValue()>
                //  189  445:invokevirtual   #126 <Method double Plot2D.convertToAttribY(double)>
                //  190  448:invokespecial   #54  <Method void Double(double)>
                //  191  451:iconst_2        
                //  192  452:invokevirtual   #165 <Method void FastVector.setElementAt(Object, int)>
                            m_shapePoints.setElementAt(new Double(m_plot2D.convertToAttribX(((Double)m_shapePoints.elementAt(3)).doubleValue())), 3);
                //  193  455:aload_0         
                //  194  456:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  195  459:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  196  462:new             #51  <Class Double>
                //  197  465:dup             
                //  198  466:aload_0         
                //  199  467:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  200  470:getfield        #68  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //  201  473:aload_0         
                //  202  474:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  203  477:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  204  480:iconst_3        
                //  205  481:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //  206  484:checkcast       #51  <Class Double>
                //  207  487:invokevirtual   #145 <Method double Double.doubleValue()>
                //  208  490:invokevirtual   #123 <Method double Plot2D.convertToAttribX(double)>
                //  209  493:invokespecial   #54  <Method void Double(double)>
                //  210  496:iconst_3        
                //  211  497:invokevirtual   #165 <Method void FastVector.setElementAt(Object, int)>
                            m_shapePoints.setElementAt(new Double(m_plot2D.convertToAttribY(((Double)m_shapePoints.elementAt(4)).doubleValue())), 4);
                //  212  500:aload_0         
                //  213  501:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  214  504:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  215  507:new             #51  <Class Double>
                //  216  510:dup             
                //  217  511:aload_0         
                //  218  512:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  219  515:getfield        #68  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //  220  518:aload_0         
                //  221  519:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  222  522:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  223  525:iconst_4        
                //  224  526:invokevirtual   #96  <Method Object FastVector.elementAt(int)>
                //  225  529:checkcast       #51  <Class Double>
                //  226  532:invokevirtual   #145 <Method double Double.doubleValue()>
                //  227  535:invokevirtual   #126 <Method double Plot2D.convertToAttribY(double)>
                //  228  538:invokespecial   #54  <Method void Double(double)>
                //  229  541:iconst_4        
                //  230  542:invokevirtual   #165 <Method void FastVector.setElementAt(Object, int)>
                            m_shapes.addElement(m_shapePoints);
                //  231  545:aload_0         
                //  232  546:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  233  549:invokestatic    #180 <Method FastVector VisualizePanel$PlotPanel.access$6(VisualizePanel$PlotPanel)>
                //  234  552:aload_0         
                //  235  553:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  236  556:invokestatic    #49  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  237  559:invokevirtual   #58  <Method void FastVector.addElement(Object)>
                            m_submit.setText("Submit");
                //  238  562:aload_0         
                //  239  563:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  240  566:invokestatic    #187 <Method VisualizePanel VisualizePanel$PlotPanel.access$9(VisualizePanel$PlotPanel)>
                //  241  569:getfield        #193 <Field JButton VisualizePanel.m_submit>
                //  242  572:ldc1            #195 <String "Submit">
                //  243  574:invokevirtual   #201 <Method void JButton.setText(String)>
                            m_submit.setActionCommand("Submit");
                //  244  577:aload_0         
                //  245  578:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  246  581:invokestatic    #187 <Method VisualizePanel VisualizePanel$PlotPanel.access$9(VisualizePanel$PlotPanel)>
                //  247  584:getfield        #193 <Field JButton VisualizePanel.m_submit>
                //  248  587:ldc1            #195 <String "Submit">
                //  249  589:invokevirtual   #204 <Method void JButton.setActionCommand(String)>
                            m_submit.setEnabled(true);
                //  250  592:aload_0         
                //  251  593:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  252  596:invokestatic    #187 <Method VisualizePanel VisualizePanel$PlotPanel.access$9(VisualizePanel$PlotPanel)>
                //  253  599:getfield        #193 <Field JButton VisualizePanel.m_submit>
                //  254  602:iconst_1        
                //  255  603:invokevirtual   #208 <Method void JButton.setEnabled(boolean)>
                            repaint();
                //  256  606:aload_0         
                //  257  607:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  258  610:invokevirtual   #211 <Method void VisualizePanel$PlotPanel.repaint()>
                        }
                        m_shapePoints = null;
                //  259  613:aload_0         
                //  260  614:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  261  617:aconst_null     
                //  262  618:invokestatic    #45  <Method void VisualizePanel$PlotPanel.access$1(VisualizePanel$PlotPanel, FastVector)>
                    }
                //  263  621:return          
                }

                final PlotPanel this$1;

                
                {
                    this$1 = PlotPanel.this;
                //    0    0:aload_0         
                //    1    1:aload_1         
                //    2    2:putfield        #11  <Field VisualizePanel$PlotPanel this$1>
                    super();
                //    3    5:aload_0         
                //    4    6:invokespecial   #14  <Method void MouseAdapter()>
                //    5    9:return          
                }
            }
);
        //   73  136:aload_0         
        //   74  137:new             #106 <Class VisualizePanel$1>
        //   75  140:dup             
        //   76  141:aload_0         
        //   77  142:invokespecial   #109 <Method void VisualizePanel$1(VisualizePanel$PlotPanel)>
        //   78  145:invokevirtual   #113 <Method void addMouseListener(java.awt.event.MouseListener)>
            addMouseMotionListener(new MouseMotionAdapter() {

                public void mouseDragged(MouseEvent e)
                {
                    if(m_createShape && ((Double)m_shapePoints.elementAt(0)).intValue() == 1)
                //*   0    0:aload_0         
                //*   1    1:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //*   2    4:invokestatic    #26  <Method boolean VisualizePanel$PlotPanel.access$3(VisualizePanel$PlotPanel)>
                //*   3    7:ifeq            322
                //*   4   10:aload_0         
                //*   5   11:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //*   6   14:invokestatic    #30  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //*   7   17:iconst_0        
                //*   8   18:invokevirtual   #36  <Method Object FastVector.elementAt(int)>
                //*   9   21:checkcast       #38  <Class Double>
                //*  10   24:invokevirtual   #42  <Method int Double.intValue()>
                //*  11   27:iconst_1        
                //*  12   28:icmpne          322
                    {
                        Graphics g = m_plot2D.getGraphics();
                //   13   31:aload_0         
                //   14   32:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   15   35:getfield        #46  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //   16   38:invokevirtual   #52  <Method Graphics Plot2D.getGraphics()>
                //   17   41:astore_2        
                        g.setColor(Color.black);
                //   18   42:aload_2         
                //   19   43:getstatic       #58  <Field Color Color.black>
                //   20   46:invokevirtual   #64  <Method void Graphics.setColor(Color)>
                        g.setXORMode(Color.white);
                //   21   49:aload_2         
                //   22   50:getstatic       #67  <Field Color Color.white>
                //   23   53:invokevirtual   #70  <Method void Graphics.setXORMode(Color)>
                        g.drawRect(((Double)m_shapePoints.elementAt(1)).intValue(), ((Double)m_shapePoints.elementAt(2)).intValue(), ((Double)m_shapePoints.elementAt(3)).intValue() - ((Double)m_shapePoints.elementAt(1)).intValue(), ((Double)m_shapePoints.elementAt(4)).intValue() - ((Double)m_shapePoints.elementAt(2)).intValue());
                //   24   56:aload_2         
                //   25   57:aload_0         
                //   26   58:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   27   61:invokestatic    #30  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //   28   64:iconst_1        
                //   29   65:invokevirtual   #36  <Method Object FastVector.elementAt(int)>
                //   30   68:checkcast       #38  <Class Double>
                //   31   71:invokevirtual   #42  <Method int Double.intValue()>
                //   32   74:aload_0         
                //   33   75:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   34   78:invokestatic    #30  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //   35   81:iconst_2        
                //   36   82:invokevirtual   #36  <Method Object FastVector.elementAt(int)>
                //   37   85:checkcast       #38  <Class Double>
                //   38   88:invokevirtual   #42  <Method int Double.intValue()>
                //   39   91:aload_0         
                //   40   92:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   41   95:invokestatic    #30  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //   42   98:iconst_3        
                //   43   99:invokevirtual   #36  <Method Object FastVector.elementAt(int)>
                //   44  102:checkcast       #38  <Class Double>
                //   45  105:invokevirtual   #42  <Method int Double.intValue()>
                //   46  108:aload_0         
                //   47  109:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   48  112:invokestatic    #30  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //   49  115:iconst_1        
                //   50  116:invokevirtual   #36  <Method Object FastVector.elementAt(int)>
                //   51  119:checkcast       #38  <Class Double>
                //   52  122:invokevirtual   #42  <Method int Double.intValue()>
                //   53  125:isub            
                //   54  126:aload_0         
                //   55  127:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   56  130:invokestatic    #30  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //   57  133:iconst_4        
                //   58  134:invokevirtual   #36  <Method Object FastVector.elementAt(int)>
                //   59  137:checkcast       #38  <Class Double>
                //   60  140:invokevirtual   #42  <Method int Double.intValue()>
                //   61  143:aload_0         
                //   62  144:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   63  147:invokestatic    #30  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //   64  150:iconst_2        
                //   65  151:invokevirtual   #36  <Method Object FastVector.elementAt(int)>
                //   66  154:checkcast       #38  <Class Double>
                //   67  157:invokevirtual   #42  <Method int Double.intValue()>
                //   68  160:isub            
                //   69  161:invokevirtual   #74  <Method void Graphics.drawRect(int, int, int, int)>
                        m_shapePoints.setElementAt(new Double(e.getX()), 3);
                //   70  164:aload_0         
                //   71  165:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   72  168:invokestatic    #30  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //   73  171:new             #38  <Class Double>
                //   74  174:dup             
                //   75  175:aload_1         
                //   76  176:invokevirtual   #79  <Method int MouseEvent.getX()>
                //   77  179:i2d             
                //   78  180:invokespecial   #82  <Method void Double(double)>
                //   79  183:iconst_3        
                //   80  184:invokevirtual   #86  <Method void FastVector.setElementAt(Object, int)>
                        m_shapePoints.setElementAt(new Double(e.getY()), 4);
                //   81  187:aload_0         
                //   82  188:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   83  191:invokestatic    #30  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //   84  194:new             #38  <Class Double>
                //   85  197:dup             
                //   86  198:aload_1         
                //   87  199:invokevirtual   #89  <Method int MouseEvent.getY()>
                //   88  202:i2d             
                //   89  203:invokespecial   #82  <Method void Double(double)>
                //   90  206:iconst_4        
                //   91  207:invokevirtual   #86  <Method void FastVector.setElementAt(Object, int)>
                        g.drawRect(((Double)m_shapePoints.elementAt(1)).intValue(), ((Double)m_shapePoints.elementAt(2)).intValue(), ((Double)m_shapePoints.elementAt(3)).intValue() - ((Double)m_shapePoints.elementAt(1)).intValue(), ((Double)m_shapePoints.elementAt(4)).intValue() - ((Double)m_shapePoints.elementAt(2)).intValue());
                //   92  210:aload_2         
                //   93  211:aload_0         
                //   94  212:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   95  215:invokestatic    #30  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //   96  218:iconst_1        
                //   97  219:invokevirtual   #36  <Method Object FastVector.elementAt(int)>
                //   98  222:checkcast       #38  <Class Double>
                //   99  225:invokevirtual   #42  <Method int Double.intValue()>
                //  100  228:aload_0         
                //  101  229:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  102  232:invokestatic    #30  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  103  235:iconst_2        
                //  104  236:invokevirtual   #36  <Method Object FastVector.elementAt(int)>
                //  105  239:checkcast       #38  <Class Double>
                //  106  242:invokevirtual   #42  <Method int Double.intValue()>
                //  107  245:aload_0         
                //  108  246:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  109  249:invokestatic    #30  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  110  252:iconst_3        
                //  111  253:invokevirtual   #36  <Method Object FastVector.elementAt(int)>
                //  112  256:checkcast       #38  <Class Double>
                //  113  259:invokevirtual   #42  <Method int Double.intValue()>
                //  114  262:aload_0         
                //  115  263:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  116  266:invokestatic    #30  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  117  269:iconst_1        
                //  118  270:invokevirtual   #36  <Method Object FastVector.elementAt(int)>
                //  119  273:checkcast       #38  <Class Double>
                //  120  276:invokevirtual   #42  <Method int Double.intValue()>
                //  121  279:isub            
                //  122  280:aload_0         
                //  123  281:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  124  284:invokestatic    #30  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  125  287:iconst_4        
                //  126  288:invokevirtual   #36  <Method Object FastVector.elementAt(int)>
                //  127  291:checkcast       #38  <Class Double>
                //  128  294:invokevirtual   #42  <Method int Double.intValue()>
                //  129  297:aload_0         
                //  130  298:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  131  301:invokestatic    #30  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  132  304:iconst_2        
                //  133  305:invokevirtual   #36  <Method Object FastVector.elementAt(int)>
                //  134  308:checkcast       #38  <Class Double>
                //  135  311:invokevirtual   #42  <Method int Double.intValue()>
                //  136  314:isub            
                //  137  315:invokevirtual   #74  <Method void Graphics.drawRect(int, int, int, int)>
                        g.dispose();
                //  138  318:aload_2         
                //  139  319:invokevirtual   #92  <Method void Graphics.dispose()>
                    }
                //  140  322:return          
                }

                public void mouseMoved(MouseEvent e)
                {
                    if(m_createShape && (((Double)m_shapePoints.elementAt(0)).intValue() == 2 || ((Double)m_shapePoints.elementAt(0)).intValue() == 3))
                //*   0    0:aload_0         
                //*   1    1:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //*   2    4:invokestatic    #26  <Method boolean VisualizePanel$PlotPanel.access$3(VisualizePanel$PlotPanel)>
                //*   3    7:ifeq            325
                //*   4   10:aload_0         
                //*   5   11:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //*   6   14:invokestatic    #30  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //*   7   17:iconst_0        
                //*   8   18:invokevirtual   #36  <Method Object FastVector.elementAt(int)>
                //*   9   21:checkcast       #38  <Class Double>
                //*  10   24:invokevirtual   #42  <Method int Double.intValue()>
                //*  11   27:iconst_2        
                //*  12   28:icmpeq          52
                //*  13   31:aload_0         
                //*  14   32:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //*  15   35:invokestatic    #30  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //*  16   38:iconst_0        
                //*  17   39:invokevirtual   #36  <Method Object FastVector.elementAt(int)>
                //*  18   42:checkcast       #38  <Class Double>
                //*  19   45:invokevirtual   #42  <Method int Double.intValue()>
                //*  20   48:iconst_3        
                //*  21   49:icmpne          325
                    {
                        Graphics g = m_plot2D.getGraphics();
                //   22   52:aload_0         
                //   23   53:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   24   56:getfield        #46  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //   25   59:invokevirtual   #52  <Method Graphics Plot2D.getGraphics()>
                //   26   62:astore_2        
                        g.setColor(Color.black);
                //   27   63:aload_2         
                //   28   64:getstatic       #58  <Field Color Color.black>
                //   29   67:invokevirtual   #64  <Method void Graphics.setColor(Color)>
                        g.setXORMode(Color.white);
                //   30   70:aload_2         
                //   31   71:getstatic       #67  <Field Color Color.white>
                //   32   74:invokevirtual   #70  <Method void Graphics.setXORMode(Color)>
                        g.drawLine((int)Math.ceil(m_plot2D.convertToPanelX(((Double)m_shapePoints.elementAt(m_shapePoints.size() - 2)).doubleValue())), (int)Math.ceil(m_plot2D.convertToPanelY(((Double)m_shapePoints.elementAt(m_shapePoints.size() - 1)).doubleValue())), m_newMousePos.width, m_newMousePos.height);
                //   33   77:aload_2         
                //   34   78:aload_0         
                //   35   79:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   36   82:getfield        #46  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //   37   85:aload_0         
                //   38   86:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   39   89:invokestatic    #30  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //   40   92:aload_0         
                //   41   93:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   42   96:invokestatic    #30  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //   43   99:invokevirtual   #100 <Method int FastVector.size()>
                //   44  102:iconst_2        
                //   45  103:isub            
                //   46  104:invokevirtual   #36  <Method Object FastVector.elementAt(int)>
                //   47  107:checkcast       #38  <Class Double>
                //   48  110:invokevirtual   #104 <Method double Double.doubleValue()>
                //   49  113:invokevirtual   #108 <Method double Plot2D.convertToPanelX(double)>
                //   50  116:invokestatic    #113 <Method double Math.ceil(double)>
                //   51  119:d2i             
                //   52  120:aload_0         
                //   53  121:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   54  124:getfield        #46  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //   55  127:aload_0         
                //   56  128:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   57  131:invokestatic    #30  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //   58  134:aload_0         
                //   59  135:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   60  138:invokestatic    #30  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //   61  141:invokevirtual   #100 <Method int FastVector.size()>
                //   62  144:iconst_1        
                //   63  145:isub            
                //   64  146:invokevirtual   #36  <Method Object FastVector.elementAt(int)>
                //   65  149:checkcast       #38  <Class Double>
                //   66  152:invokevirtual   #104 <Method double Double.doubleValue()>
                //   67  155:invokevirtual   #116 <Method double Plot2D.convertToPanelY(double)>
                //   68  158:invokestatic    #113 <Method double Math.ceil(double)>
                //   69  161:d2i             
                //   70  162:aload_0         
                //   71  163:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   72  166:invokestatic    #120 <Method Dimension VisualizePanel$PlotPanel.access$4(VisualizePanel$PlotPanel)>
                //   73  169:getfield        #126 <Field int Dimension.width>
                //   74  172:aload_0         
                //   75  173:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   76  176:invokestatic    #120 <Method Dimension VisualizePanel$PlotPanel.access$4(VisualizePanel$PlotPanel)>
                //   77  179:getfield        #129 <Field int Dimension.height>
                //   78  182:invokevirtual   #132 <Method void Graphics.drawLine(int, int, int, int)>
                        m_newMousePos.width = e.getX();
                //   79  185:aload_0         
                //   80  186:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   81  189:invokestatic    #120 <Method Dimension VisualizePanel$PlotPanel.access$4(VisualizePanel$PlotPanel)>
                //   82  192:aload_1         
                //   83  193:invokevirtual   #79  <Method int MouseEvent.getX()>
                //   84  196:putfield        #126 <Field int Dimension.width>
                        m_newMousePos.height = e.getY();
                //   85  199:aload_0         
                //   86  200:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   87  203:invokestatic    #120 <Method Dimension VisualizePanel$PlotPanel.access$4(VisualizePanel$PlotPanel)>
                //   88  206:aload_1         
                //   89  207:invokevirtual   #89  <Method int MouseEvent.getY()>
                //   90  210:putfield        #129 <Field int Dimension.height>
                        g.drawLine((int)Math.ceil(m_plot2D.convertToPanelX(((Double)m_shapePoints.elementAt(m_shapePoints.size() - 2)).doubleValue())), (int)Math.ceil(m_plot2D.convertToPanelY(((Double)m_shapePoints.elementAt(m_shapePoints.size() - 1)).doubleValue())), m_newMousePos.width, m_newMousePos.height);
                //   91  213:aload_2         
                //   92  214:aload_0         
                //   93  215:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   94  218:getfield        #46  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //   95  221:aload_0         
                //   96  222:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //   97  225:invokestatic    #30  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //   98  228:aload_0         
                //   99  229:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  100  232:invokestatic    #30  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  101  235:invokevirtual   #100 <Method int FastVector.size()>
                //  102  238:iconst_2        
                //  103  239:isub            
                //  104  240:invokevirtual   #36  <Method Object FastVector.elementAt(int)>
                //  105  243:checkcast       #38  <Class Double>
                //  106  246:invokevirtual   #104 <Method double Double.doubleValue()>
                //  107  249:invokevirtual   #108 <Method double Plot2D.convertToPanelX(double)>
                //  108  252:invokestatic    #113 <Method double Math.ceil(double)>
                //  109  255:d2i             
                //  110  256:aload_0         
                //  111  257:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  112  260:getfield        #46  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //  113  263:aload_0         
                //  114  264:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  115  267:invokestatic    #30  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  116  270:aload_0         
                //  117  271:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  118  274:invokestatic    #30  <Method FastVector VisualizePanel$PlotPanel.access$2(VisualizePanel$PlotPanel)>
                //  119  277:invokevirtual   #100 <Method int FastVector.size()>
                //  120  280:iconst_1        
                //  121  281:isub            
                //  122  282:invokevirtual   #36  <Method Object FastVector.elementAt(int)>
                //  123  285:checkcast       #38  <Class Double>
                //  124  288:invokevirtual   #104 <Method double Double.doubleValue()>
                //  125  291:invokevirtual   #116 <Method double Plot2D.convertToPanelY(double)>
                //  126  294:invokestatic    #113 <Method double Math.ceil(double)>
                //  127  297:d2i             
                //  128  298:aload_0         
                //  129  299:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  130  302:invokestatic    #120 <Method Dimension VisualizePanel$PlotPanel.access$4(VisualizePanel$PlotPanel)>
                //  131  305:getfield        #126 <Field int Dimension.width>
                //  132  308:aload_0         
                //  133  309:getfield        #11  <Field VisualizePanel$PlotPanel this$1>
                //  134  312:invokestatic    #120 <Method Dimension VisualizePanel$PlotPanel.access$4(VisualizePanel$PlotPanel)>
                //  135  315:getfield        #129 <Field int Dimension.height>
                //  136  318:invokevirtual   #132 <Method void Graphics.drawLine(int, int, int, int)>
                        g.dispose();
                //  137  321:aload_2         
                //  138  322:invokevirtual   #92  <Method void Graphics.dispose()>
                    }
                //  139  325:return          
                }

                final PlotPanel this$1;

                
                {
                    this$1 = PlotPanel.this;
                //    0    0:aload_0         
                //    1    1:aload_1         
                //    2    2:putfield        #11  <Field VisualizePanel$PlotPanel this$1>
                    super();
                //    3    5:aload_0         
                //    4    6:invokespecial   #14  <Method void MouseMotionAdapter()>
                //    5    9:return          
                }
            }
);
        //   79  148:aload_0         
        //   80  149:new             #115 <Class VisualizePanel$2>
        //   81  152:dup             
        //   82  153:aload_0         
        //   83  154:invokespecial   #116 <Method void VisualizePanel$2(VisualizePanel$PlotPanel)>
        //   84  157:invokevirtual   #120 <Method void addMouseMotionListener(java.awt.event.MouseMotionListener)>
            m_submit.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e)
                {
                    if(e.getActionCommand().equals("Submit"))
                //*   0    0:aload_1         
                //*   1    1:invokevirtual   #28  <Method String ActionEvent.getActionCommand()>
                //*   2    4:ldc1            #30  <String "Submit">
                //*   3    6:invokevirtual   #36  <Method boolean String.equals(Object)>
                //*   4    9:ifeq            760
                    {
                        if(m_splitListener != null && m_shapes != null)
                //*   5   12:aload_0         
                //*   6   13:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //*   7   16:invokestatic    #42  <Method VisualizePanel VisualizePanel$PlotPanel.access$9(VisualizePanel$PlotPanel)>
                //*   8   19:getfield        #48  <Field VisualizePanelListener VisualizePanel.m_splitListener>
                //*   9   22:ifnull          325
                //*  10   25:aload_0         
                //*  11   26:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //*  12   29:invokestatic    #52  <Method FastVector VisualizePanel$PlotPanel.access$6(VisualizePanel$PlotPanel)>
                //*  13   32:ifnull          325
                        {
                            Instances sub_set1 = new Instances(m_plot2D.getMasterPlot().m_plotInstances, 500);
                //   14   35:new             #54  <Class Instances>
                //   15   38:dup             
                //   16   39:aload_0         
                //   17   40:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //   18   43:getfield        #58  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //   19   46:invokevirtual   #64  <Method PlotData2D Plot2D.getMasterPlot()>
                //   20   49:getfield        #70  <Field Instances PlotData2D.m_plotInstances>
                //   21   52:sipush          500
                //   22   55:invokespecial   #73  <Method void Instances(Instances, int)>
                //   23   58:astore_2        
                            Instances sub_set2 = new Instances(m_plot2D.getMasterPlot().m_plotInstances, 500);
                //   24   59:new             #54  <Class Instances>
                //   25   62:dup             
                //   26   63:aload_0         
                //   27   64:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //   28   67:getfield        #58  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //   29   70:invokevirtual   #64  <Method PlotData2D Plot2D.getMasterPlot()>
                //   30   73:getfield        #70  <Field Instances PlotData2D.m_plotInstances>
                //   31   76:sipush          500
                //   32   79:invokespecial   #73  <Method void Instances(Instances, int)>
                //   33   82:astore_3        
                            if(m_plot2D.getMasterPlot().m_plotInstances != null)
                //*  34   83:aload_0         
                //*  35   84:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //*  36   87:getfield        #58  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //*  37   90:invokevirtual   #64  <Method PlotData2D Plot2D.getMasterPlot()>
                //*  38   93:getfield        #70  <Field Instances PlotData2D.m_plotInstances>
                //*  39   96:ifnull          883
                            {
                                for(int noa = 0; noa < m_plot2D.getMasterPlot().m_plotInstances.numInstances(); noa++)
                //*  40   99:iconst_0        
                //*  41  100:istore          4
                //*  42  102:goto            245
                                    if(!m_plot2D.getMasterPlot().m_plotInstances.instance(noa).isMissing(m_xIndex) && !m_plot2D.getMasterPlot().m_plotInstances.instance(noa).isMissing(m_yIndex))
                //*  43  105:aload_0         
                //*  44  106:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //*  45  109:getfield        #58  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //*  46  112:invokevirtual   #64  <Method PlotData2D Plot2D.getMasterPlot()>
                //*  47  115:getfield        #70  <Field Instances PlotData2D.m_plotInstances>
                //*  48  118:iload           4
                //*  49  120:invokevirtual   #77  <Method Instance Instances.instance(int)>
                //*  50  123:aload_0         
                //*  51  124:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //*  52  127:getfield        #81  <Field int VisualizePanel$PlotPanel.m_xIndex>
                //*  53  130:invokevirtual   #87  <Method boolean Instance.isMissing(int)>
                //*  54  133:ifne            242
                //*  55  136:aload_0         
                //*  56  137:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //*  57  140:getfield        #58  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //*  58  143:invokevirtual   #64  <Method PlotData2D Plot2D.getMasterPlot()>
                //*  59  146:getfield        #70  <Field Instances PlotData2D.m_plotInstances>
                //*  60  149:iload           4
                //*  61  151:invokevirtual   #77  <Method Instance Instances.instance(int)>
                //*  62  154:aload_0         
                //*  63  155:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //*  64  158:getfield        #90  <Field int VisualizePanel$PlotPanel.m_yIndex>
                //*  65  161:invokevirtual   #87  <Method boolean Instance.isMissing(int)>
                //*  66  164:ifne            242
                                        if(inSplit(m_plot2D.getMasterPlot().m_plotInstances.instance(noa)))
                //*  67  167:aload_0         
                //*  68  168:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //*  69  171:aload_0         
                //*  70  172:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //*  71  175:getfield        #58  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //*  72  178:invokevirtual   #64  <Method PlotData2D Plot2D.getMasterPlot()>
                //*  73  181:getfield        #70  <Field Instances PlotData2D.m_plotInstances>
                //*  74  184:iload           4
                //*  75  186:invokevirtual   #77  <Method Instance Instances.instance(int)>
                //*  76  189:invokevirtual   #94  <Method boolean VisualizePanel$PlotPanel.inSplit(Instance)>
                //*  77  192:ifeq            220
                                            sub_set1.add(m_plot2D.getMasterPlot().m_plotInstances.instance(noa));
                //   78  195:aload_2         
                //   79  196:aload_0         
                //   80  197:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //   81  200:getfield        #58  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //   82  203:invokevirtual   #64  <Method PlotData2D Plot2D.getMasterPlot()>
                //   83  206:getfield        #70  <Field Instances PlotData2D.m_plotInstances>
                //   84  209:iload           4
                //   85  211:invokevirtual   #77  <Method Instance Instances.instance(int)>
                //   86  214:invokevirtual   #98  <Method void Instances.add(Instance)>
                                        else
                //*  87  217:goto            242
                                            sub_set2.add(m_plot2D.getMasterPlot().m_plotInstances.instance(noa));
                //   88  220:aload_3         
                //   89  221:aload_0         
                //   90  222:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //   91  225:getfield        #58  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //   92  228:invokevirtual   #64  <Method PlotData2D Plot2D.getMasterPlot()>
                //   93  231:getfield        #70  <Field Instances PlotData2D.m_plotInstances>
                //   94  234:iload           4
                //   95  236:invokevirtual   #77  <Method Instance Instances.instance(int)>
                //   96  239:invokevirtual   #98  <Method void Instances.add(Instance)>

                //   97  242:iinc            4  1
                //   98  245:iload           4
                //   99  247:aload_0         
                //  100  248:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //  101  251:getfield        #58  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //  102  254:invokevirtual   #64  <Method PlotData2D Plot2D.getMasterPlot()>
                //  103  257:getfield        #70  <Field Instances PlotData2D.m_plotInstances>
                //  104  260:invokevirtual   #102 <Method int Instances.numInstances()>
                //  105  263:icmplt          105
                                FastVector tmp = m_shapes;
                //  106  266:aload_0         
                //  107  267:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //  108  270:invokestatic    #52  <Method FastVector VisualizePanel$PlotPanel.access$6(VisualizePanel$PlotPanel)>
                //  109  273:astore          4
                                cancelShapes();
                //  110  275:aload_0         
                //  111  276:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //  112  279:invokevirtual   #105 <Method void VisualizePanel$PlotPanel.cancelShapes()>
                                m_splitListener.userDataEvent(new VisualizePanelEvent(tmp, sub_set1, sub_set2, m_xIndex, m_yIndex));
                //  113  282:aload_0         
                //  114  283:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //  115  286:invokestatic    #42  <Method VisualizePanel VisualizePanel$PlotPanel.access$9(VisualizePanel$PlotPanel)>
                //  116  289:getfield        #48  <Field VisualizePanelListener VisualizePanel.m_splitListener>
                //  117  292:new             #107 <Class VisualizePanelEvent>
                //  118  295:dup             
                //  119  296:aload           4
                //  120  298:aload_2         
                //  121  299:aload_3         
                //  122  300:aload_0         
                //  123  301:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //  124  304:getfield        #81  <Field int VisualizePanel$PlotPanel.m_xIndex>
                //  125  307:aload_0         
                //  126  308:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //  127  311:getfield        #90  <Field int VisualizePanel$PlotPanel.m_yIndex>
                //  128  314:invokespecial   #110 <Method void VisualizePanelEvent(FastVector, Instances, Instances, int, int)>
                //  129  317:invokeinterface #116 <Method void VisualizePanelListener.userDataEvent(VisualizePanelEvent)>
                            }
                        } else
                //* 130  322:goto            883
                        if(m_shapes != null && m_plot2D.getMasterPlot().m_plotInstances != null)
                //* 131  325:aload_0         
                //* 132  326:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //* 133  329:invokestatic    #52  <Method FastVector VisualizePanel$PlotPanel.access$6(VisualizePanel$PlotPanel)>
                //* 134  332:ifnull          883
                //* 135  335:aload_0         
                //* 136  336:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //* 137  339:getfield        #58  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //* 138  342:invokevirtual   #64  <Method PlotData2D Plot2D.getMasterPlot()>
                //* 139  345:getfield        #70  <Field Instances PlotData2D.m_plotInstances>
                //* 140  348:ifnull          883
                        {
                            Instances sub_set1 = new Instances(m_plot2D.getMasterPlot().m_plotInstances, 500);
                //  141  351:new             #54  <Class Instances>
                //  142  354:dup             
                //  143  355:aload_0         
                //  144  356:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //  145  359:getfield        #58  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //  146  362:invokevirtual   #64  <Method PlotData2D Plot2D.getMasterPlot()>
                //  147  365:getfield        #70  <Field Instances PlotData2D.m_plotInstances>
                //  148  368:sipush          500
                //  149  371:invokespecial   #73  <Method void Instances(Instances, int)>
                //  150  374:astore_2        
                            int count = 0;
                //  151  375:iconst_0        
                //  152  376:istore_3        
                            for(int noa = 0; noa < m_plot2D.getMasterPlot().m_plotInstances.numInstances(); noa++)
                //* 153  377:iconst_0        
                //* 154  378:istore          4
                //* 155  380:goto            439
                                if(inSplit(m_plot2D.getMasterPlot().m_plotInstances.instance(noa)))
                //* 156  383:aload_0         
                //* 157  384:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //* 158  387:aload_0         
                //* 159  388:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //* 160  391:getfield        #58  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //* 161  394:invokevirtual   #64  <Method PlotData2D Plot2D.getMasterPlot()>
                //* 162  397:getfield        #70  <Field Instances PlotData2D.m_plotInstances>
                //* 163  400:iload           4
                //* 164  402:invokevirtual   #77  <Method Instance Instances.instance(int)>
                //* 165  405:invokevirtual   #94  <Method boolean VisualizePanel$PlotPanel.inSplit(Instance)>
                //* 166  408:ifeq            436
                                {
                                    sub_set1.add(m_plot2D.getMasterPlot().m_plotInstances.instance(noa));
                //  167  411:aload_2         
                //  168  412:aload_0         
                //  169  413:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //  170  416:getfield        #58  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //  171  419:invokevirtual   #64  <Method PlotData2D Plot2D.getMasterPlot()>
                //  172  422:getfield        #70  <Field Instances PlotData2D.m_plotInstances>
                //  173  425:iload           4
                //  174  427:invokevirtual   #77  <Method Instance Instances.instance(int)>
                //  175  430:invokevirtual   #98  <Method void Instances.add(Instance)>
                                    count++;
                //  176  433:iinc            3  1
                                }

                //  177  436:iinc            4  1
                //  178  439:iload           4
                //  179  441:aload_0         
                //  180  442:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //  181  445:getfield        #58  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //  182  448:invokevirtual   #64  <Method PlotData2D Plot2D.getMasterPlot()>
                //  183  451:getfield        #70  <Field Instances PlotData2D.m_plotInstances>
                //  184  454:invokevirtual   #102 <Method int Instances.numInstances()>
                //  185  457:icmplt          383
                            int nSizes[] = (int[])null;
                //  186  460:aconst_null     
                //  187  461:checkcast       #118 <Class int[]>
                //  188  464:astore          4
                            int nTypes[] = (int[])null;
                //  189  466:aconst_null     
                //  190  467:checkcast       #118 <Class int[]>
                //  191  470:astore          5
                            int x = m_xIndex;
                //  192  472:aload_0         
                //  193  473:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //  194  476:getfield        #81  <Field int VisualizePanel$PlotPanel.m_xIndex>
                //  195  479:istore          6
                            int y = m_yIndex;
                //  196  481:aload_0         
                //  197  482:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //  198  485:getfield        #90  <Field int VisualizePanel$PlotPanel.m_yIndex>
                //  199  488:istore          7
                            if(m_originalPlot == null)
                //* 200  490:aload_0         
                //* 201  491:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //* 202  494:getfield        #122 <Field PlotData2D VisualizePanel$PlotPanel.m_originalPlot>
                //* 203  497:ifnonnull       517
                                m_originalPlot = m_plot2D.getMasterPlot();
                //  204  500:aload_0         
                //  205  501:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //  206  504:aload_0         
                //  207  505:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //  208  508:getfield        #58  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //  209  511:invokevirtual   #64  <Method PlotData2D Plot2D.getMasterPlot()>
                //  210  514:putfield        #122 <Field PlotData2D VisualizePanel$PlotPanel.m_originalPlot>
                            if(count > 0)
                //* 211  517:iload_3         
                //* 212  518:ifle            634
                            {
                                nTypes = new int[count];
                //  213  521:iload_3         
                //  214  522:newarray        int[]
                //  215  524:astore          5
                                nSizes = new int[count];
                //  216  526:iload_3         
                //  217  527:newarray        int[]
                //  218  529:astore          4
                                count = 0;
                //  219  531:iconst_0        
                //  220  532:istore_3        
                                for(int noa = 0; noa < m_plot2D.getMasterPlot().m_plotInstances.numInstances(); noa++)
                //* 221  533:iconst_0        
                //* 222  534:istore          8
                //* 223  536:goto            613
                                    if(inSplit(m_plot2D.getMasterPlot().m_plotInstances.instance(noa)))
                //* 224  539:aload_0         
                //* 225  540:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //* 226  543:aload_0         
                //* 227  544:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //* 228  547:getfield        #58  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //* 229  550:invokevirtual   #64  <Method PlotData2D Plot2D.getMasterPlot()>
                //* 230  553:getfield        #70  <Field Instances PlotData2D.m_plotInstances>
                //* 231  556:iload           8
                //* 232  558:invokevirtual   #77  <Method Instance Instances.instance(int)>
                //* 233  561:invokevirtual   #94  <Method boolean VisualizePanel$PlotPanel.inSplit(Instance)>
                //* 234  564:ifeq            610
                                    {
                                        nTypes[count] = m_plot2D.getMasterPlot().m_shapeType[noa];
                //  235  567:aload           5
                //  236  569:iload_3         
                //  237  570:aload_0         
                //  238  571:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //  239  574:getfield        #58  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //  240  577:invokevirtual   #64  <Method PlotData2D Plot2D.getMasterPlot()>
                //  241  580:getfield        #125 <Field int[] PlotData2D.m_shapeType>
                //  242  583:iload           8
                //  243  585:iaload          
                //  244  586:iastore         
                                        nSizes[count] = m_plot2D.getMasterPlot().m_shapeSize[noa];
                //  245  587:aload           4
                //  246  589:iload_3         
                //  247  590:aload_0         
                //  248  591:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //  249  594:getfield        #58  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //  250  597:invokevirtual   #64  <Method PlotData2D Plot2D.getMasterPlot()>
                //  251  600:getfield        #128 <Field int[] PlotData2D.m_shapeSize>
                //  252  603:iload           8
                //  253  605:iaload          
                //  254  606:iastore         
                                        count++;
                //  255  607:iinc            3  1
                                    }

                //  256  610:iinc            8  1
                //  257  613:iload           8
                //  258  615:aload_0         
                //  259  616:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //  260  619:getfield        #58  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //  261  622:invokevirtual   #64  <Method PlotData2D Plot2D.getMasterPlot()>
                //  262  625:getfield        #70  <Field Instances PlotData2D.m_plotInstances>
                //  263  628:invokevirtual   #102 <Method int Instances.numInstances()>
                //  264  631:icmplt          539
                            }
                            cancelShapes();
                //  265  634:aload_0         
                //  266  635:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //  267  638:invokevirtual   #105 <Method void VisualizePanel$PlotPanel.cancelShapes()>
                            PlotData2D newPlot = new PlotData2D(sub_set1);
                //  268  641:new             #66  <Class PlotData2D>
                //  269  644:dup             
                //  270  645:aload_2         
                //  271  646:invokespecial   #131 <Method void PlotData2D(Instances)>
                //  272  649:astore          8
                            try
                            {
                                newPlot.setShapeSize(nSizes);
                //  273  651:aload           8
                //  274  653:aload           4
                //  275  655:invokevirtual   #135 <Method void PlotData2D.setShapeSize(int[])>
                                newPlot.setShapeType(nTypes);
                //  276  658:aload           8
                //  277  660:aload           5
                //  278  662:invokevirtual   #138 <Method void PlotData2D.setShapeType(int[])>
                                m_plot2D.removeAllPlots();
                //  279  665:aload_0         
                //  280  666:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //  281  669:getfield        #58  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //  282  672:invokevirtual   #141 <Method void Plot2D.removeAllPlots()>
                                addPlot(newPlot);
                //  283  675:aload_0         
                //  284  676:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //  285  679:invokestatic    #42  <Method VisualizePanel VisualizePanel$PlotPanel.access$9(VisualizePanel$PlotPanel)>
                //  286  682:aload           8
                //  287  684:invokevirtual   #145 <Method void VisualizePanel.addPlot(PlotData2D)>
                            }
                //* 288  687:goto            705
                            catch(Exception ex)
                //* 289  690:astore          9
                            {
                                System.err.println(ex);
                //  290  692:getstatic       #151 <Field PrintStream System.err>
                //  291  695:aload           9
                //  292  697:invokevirtual   #157 <Method void PrintStream.println(Object)>
                                ex.printStackTrace();
                //  293  700:aload           9
                //  294  702:invokevirtual   #162 <Method void Exception.printStackTrace()>
                            }
                            try
                            {
                                setXIndex(x);
                //  295  705:aload_0         
                //  296  706:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //  297  709:invokestatic    #42  <Method VisualizePanel VisualizePanel$PlotPanel.access$9(VisualizePanel$PlotPanel)>
                //  298  712:iload           6
                //  299  714:invokevirtual   #166 <Method void VisualizePanel.setXIndex(int)>
                                setYIndex(y);
                //  300  717:aload_0         
                //  301  718:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //  302  721:invokestatic    #42  <Method VisualizePanel VisualizePanel$PlotPanel.access$9(VisualizePanel$PlotPanel)>
                //  303  724:iload           7
                //  304  726:invokevirtual   #169 <Method void VisualizePanel.setYIndex(int)>
                            }
                //* 305  729:goto            883
                            catch(Exception er)
                //* 306  732:astore          9
                            {
                                System.out.println((new StringBuilder("Error : ")).append(er).toString());
                //  307  734:getstatic       #172 <Field PrintStream System.out>
                //  308  737:new             #174 <Class StringBuilder>
                //  309  740:dup             
                //  310  741:ldc1            #176 <String "Error : ">
                //  311  743:invokespecial   #179 <Method void StringBuilder(String)>
                //  312  746:aload           9
                //  313  748:invokevirtual   #183 <Method StringBuilder StringBuilder.append(Object)>
                //  314  751:invokevirtual   #186 <Method String StringBuilder.toString()>
                //  315  754:invokevirtual   #188 <Method void PrintStream.println(String)>
                            }
                        }
                    } else
                //* 316  757:goto            883
                    if(e.getActionCommand().equals("Reset"))
                //* 317  760:aload_1         
                //* 318  761:invokevirtual   #28  <Method String ActionEvent.getActionCommand()>
                //* 319  764:ldc1            #190 <String "Reset">
                //* 320  766:invokevirtual   #36  <Method boolean String.equals(Object)>
                //* 321  769:ifeq            883
                    {
                        int x = m_xIndex;
                //  322  772:aload_0         
                //  323  773:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //  324  776:getfield        #81  <Field int VisualizePanel$PlotPanel.m_xIndex>
                //  325  779:istore_2        
                        int y = m_yIndex;
                //  326  780:aload_0         
                //  327  781:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //  328  784:getfield        #90  <Field int VisualizePanel$PlotPanel.m_yIndex>
                //  329  787:istore_3        
                        m_plot2D.removeAllPlots();
                //  330  788:aload_0         
                //  331  789:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //  332  792:getfield        #58  <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
                //  333  795:invokevirtual   #141 <Method void Plot2D.removeAllPlots()>
                        try
                        {
                            addPlot(m_originalPlot);
                //  334  798:aload_0         
                //  335  799:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //  336  802:invokestatic    #42  <Method VisualizePanel VisualizePanel$PlotPanel.access$9(VisualizePanel$PlotPanel)>
                //  337  805:aload_0         
                //  338  806:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //  339  809:getfield        #122 <Field PlotData2D VisualizePanel$PlotPanel.m_originalPlot>
                //  340  812:invokevirtual   #145 <Method void VisualizePanel.addPlot(PlotData2D)>
                        }
                //* 341  815:goto            833
                        catch(Exception ex)
                //* 342  818:astore          4
                        {
                            System.err.println(ex);
                //  343  820:getstatic       #151 <Field PrintStream System.err>
                //  344  823:aload           4
                //  345  825:invokevirtual   #157 <Method void PrintStream.println(Object)>
                            ex.printStackTrace();
                //  346  828:aload           4
                //  347  830:invokevirtual   #162 <Method void Exception.printStackTrace()>
                        }
                        try
                        {
                            setXIndex(x);
                //  348  833:aload_0         
                //  349  834:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //  350  837:invokestatic    #42  <Method VisualizePanel VisualizePanel$PlotPanel.access$9(VisualizePanel$PlotPanel)>
                //  351  840:iload_2         
                //  352  841:invokevirtual   #166 <Method void VisualizePanel.setXIndex(int)>
                            setYIndex(y);
                //  353  844:aload_0         
                //  354  845:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //  355  848:invokestatic    #42  <Method VisualizePanel VisualizePanel$PlotPanel.access$9(VisualizePanel$PlotPanel)>
                //  356  851:iload_3         
                //  357  852:invokevirtual   #169 <Method void VisualizePanel.setYIndex(int)>
                        }
                //* 358  855:goto            883
                        catch(Exception er)
                //* 359  858:astore          4
                        {
                            System.out.println((new StringBuilder("Error : ")).append(er).toString());
                //  360  860:getstatic       #172 <Field PrintStream System.out>
                //  361  863:new             #174 <Class StringBuilder>
                //  362  866:dup             
                //  363  867:ldc1            #176 <String "Error : ">
                //  364  869:invokespecial   #179 <Method void StringBuilder(String)>
                //  365  872:aload           4
                //  366  874:invokevirtual   #183 <Method StringBuilder StringBuilder.append(Object)>
                //  367  877:invokevirtual   #186 <Method String StringBuilder.toString()>
                //  368  880:invokevirtual   #188 <Method void PrintStream.println(String)>
                        }
                    }
                //  369  883:return          
                }

                final PlotPanel this$1;

                
                {
                    this$1 = PlotPanel.this;
                //    0    0:aload_0         
                //    1    1:aload_1         
                //    2    2:putfield        #13  <Field VisualizePanel$PlotPanel this$1>
                    super();
                //    3    5:aload_0         
                //    4    6:invokespecial   #16  <Method void Object()>
                //    5    9:return          
                }
            }
);
        //   85  160:aload_1         
        //   86  161:getfield        #126 <Field JButton VisualizePanel.m_submit>
        //   87  164:new             #128 <Class VisualizePanel$3>
        //   88  167:dup             
        //   89  168:aload_0         
        //   90  169:invokespecial   #129 <Method void VisualizePanel$3(VisualizePanel$PlotPanel)>
        //   91  172:invokevirtual   #135 <Method void JButton.addActionListener(ActionListener)>
            m_cancel.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e)
                {
                    cancelShapes();
                //    0    0:aload_0         
                //    1    1:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //    2    4:invokevirtual   #27  <Method void VisualizePanel$PlotPanel.cancelShapes()>
                    repaint();
                //    3    7:aload_0         
                //    4    8:getfield        #13  <Field VisualizePanel$PlotPanel this$1>
                //    5   11:invokevirtual   #30  <Method void VisualizePanel$PlotPanel.repaint()>
                //    6   14:return          
                }

                final PlotPanel this$1;

                
                {
                    this$1 = PlotPanel.this;
                //    0    0:aload_0         
                //    1    1:aload_1         
                //    2    2:putfield        #13  <Field VisualizePanel$PlotPanel this$1>
                    super();
                //    3    5:aload_0         
                //    4    6:invokespecial   #16  <Method void Object()>
                //    5    9:return          
                }
            }
);
        //   92  175:aload_1         
        //   93  176:getfield        #138 <Field JButton VisualizePanel.m_cancel>
        //   94  179:new             #140 <Class VisualizePanel$4>
        //   95  182:dup             
        //   96  183:aload_0         
        //   97  184:invokespecial   #141 <Method void VisualizePanel$4(VisualizePanel$PlotPanel)>
        //   98  187:invokevirtual   #135 <Method void JButton.addActionListener(ActionListener)>
        //   99  190:return          
        }
    }


    public void setLog(Logger newLog)
    {
        m_Log = newLog;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #63  <Field Logger m_Log>
    //    3    5:return          
    }

    public void setShowAttBars(boolean sab)
    {
        if(!sab && m_showAttBars)
    //*   0    0:iload_1         
    //*   1    1:ifne            25
    //*   2    4:aload_0         
    //*   3    5:getfield        #72  <Field boolean m_showAttBars>
    //*   4    8:ifeq            25
            m_plotSurround.remove(m_attrib);
    //    5   11:aload_0         
    //    6   12:getfield        #74  <Field JPanel m_plotSurround>
    //    7   15:aload_0         
    //    8   16:getfield        #76  <Field AttributePanel m_attrib>
    //    9   19:invokevirtual   #82  <Method void JPanel.remove(Component)>
        else
    //*  10   22:goto            103
        if(sab && !m_showAttBars)
    //*  11   25:iload_1         
    //*  12   26:ifeq            103
    //*  13   29:aload_0         
    //*  14   30:getfield        #72  <Field boolean m_showAttBars>
    //*  15   33:ifne            103
        {
            GridBagConstraints constraints = new GridBagConstraints();
    //   16   36:new             #84  <Class GridBagConstraints>
    //   17   39:dup             
    //   18   40:invokespecial   #88  <Method void GridBagConstraints()>
    //   19   43:astore_2        
            constraints.insets = new Insets(0, 0, 0, 0);
    //   20   44:aload_2         
    //   21   45:new             #90  <Class Insets>
    //   22   48:dup             
    //   23   49:iconst_0        
    //   24   50:iconst_0        
    //   25   51:iconst_0        
    //   26   52:iconst_0        
    //   27   53:invokespecial   #93  <Method void Insets(int, int, int, int)>
    //   28   56:putfield        #97  <Field Insets GridBagConstraints.insets>
            constraints.gridx = 4;
    //   29   59:aload_2         
    //   30   60:iconst_4        
    //   31   61:putfield        #101 <Field int GridBagConstraints.gridx>
            constraints.gridy = 0;
    //   32   64:aload_2         
    //   33   65:iconst_0        
    //   34   66:putfield        #104 <Field int GridBagConstraints.gridy>
            constraints.weightx = 1.0D;
    //   35   69:aload_2         
    //   36   70:dconst_1        
    //   37   71:putfield        #108 <Field double GridBagConstraints.weightx>
            constraints.gridwidth = 1;
    //   38   74:aload_2         
    //   39   75:iconst_1        
    //   40   76:putfield        #111 <Field int GridBagConstraints.gridwidth>
            constraints.gridheight = 1;
    //   41   79:aload_2         
    //   42   80:iconst_1        
    //   43   81:putfield        #114 <Field int GridBagConstraints.gridheight>
            constraints.weighty = 5D;
    //   44   84:aload_2         
    //   45   85:ldc2w           #115 <Double 5D>
    //   46   88:putfield        #119 <Field double GridBagConstraints.weighty>
            m_plotSurround.add(m_attrib, constraints);
    //   47   91:aload_0         
    //   48   92:getfield        #74  <Field JPanel m_plotSurround>
    //   49   95:aload_0         
    //   50   96:getfield        #76  <Field AttributePanel m_attrib>
    //   51   99:aload_2         
    //   52  100:invokevirtual   #123 <Method void JPanel.add(Component, Object)>
        }
        m_showAttBars = sab;
    //   53  103:aload_0         
    //   54  104:iload_1         
    //   55  105:putfield        #72  <Field boolean m_showAttBars>
        repaint();
    //   56  108:aload_0         
    //   57  109:invokevirtual   #126 <Method void repaint()>
    //   58  112:return          
    }

    public boolean getShowAttBars()
    {
        return m_showAttBars;
    //    0    0:aload_0         
    //    1    1:getfield        #72  <Field boolean m_showAttBars>
    //    2    4:ireturn         
    }

    public void setShowClassPanel(boolean scp)
    {
        if(!scp && m_showClassPanel)
    //*   0    0:iload_1         
    //*   1    1:ifne            22
    //*   2    4:aload_0         
    //*   3    5:getfield        #134 <Field boolean m_showClassPanel>
    //*   4    8:ifeq            22
            remove(m_classSurround);
    //    5   11:aload_0         
    //    6   12:aload_0         
    //    7   13:getfield        #136 <Field JPanel m_classSurround>
    //    8   16:invokevirtual   #137 <Method void remove(Component)>
        else
    //*   9   19:goto            43
        if(scp && !m_showClassPanel)
    //*  10   22:iload_1         
    //*  11   23:ifeq            43
    //*  12   26:aload_0         
    //*  13   27:getfield        #134 <Field boolean m_showClassPanel>
    //*  14   30:ifne            43
            add(m_classSurround, "South");
    //   15   33:aload_0         
    //   16   34:aload_0         
    //   17   35:getfield        #136 <Field JPanel m_classSurround>
    //   18   38:ldc1            #139 <String "South">
    //   19   40:invokevirtual   #140 <Method void add(Component, Object)>
        m_showClassPanel = scp;
    //   20   43:aload_0         
    //   21   44:iload_1         
    //   22   45:putfield        #134 <Field boolean m_showClassPanel>
        repaint();
    //   23   48:aload_0         
    //   24   49:invokevirtual   #126 <Method void repaint()>
    //   25   52:return          
    }

    public boolean getShowClassPanel()
    {
        return m_showClassPanel;
    //    0    0:aload_0         
    //    1    1:getfield        #134 <Field boolean m_showClassPanel>
    //    2    4:ireturn         
    }

    public VisualizePanel(VisualizePanelListener ls)
    {
        this();
    //    0    0:aload_0         
    //    1    1:invokespecial   #144 <Method void VisualizePanel()>
        m_splitListener = ls;
    //    2    4:aload_0         
    //    3    5:aload_1         
    //    4    6:putfield        #146 <Field VisualizePanelListener m_splitListener>
    //    5    9:return          
    }

    private void setProperties(String relationName)
    {
        if(VisualizeUtils.VISUALIZE_PROPERTIES != null)
    //*   0    0:getstatic       #155 <Field Properties VisualizeUtils.VISUALIZE_PROPERTIES>
    //*   1    3:ifnull          219
        {
            String thisClass = getClass().getName();
    //    2    6:aload_0         
    //    3    7:invokevirtual   #161 <Method Class Object.getClass()>
    //    4   10:invokevirtual   #167 <Method String Class.getName()>
    //    5   13:astore_2        
            if(relationName == null)
    //*   6   14:aload_1         
    //*   7   15:ifnonnull       95
            {
                String showAttBars = (new StringBuilder(String.valueOf(thisClass))).append(".displayAttributeBars").toString();
    //    8   18:new             #169 <Class StringBuilder>
    //    9   21:dup             
    //   10   22:aload_2         
    //   11   23:invokestatic    #175 <Method String String.valueOf(Object)>
    //   12   26:invokespecial   #177 <Method void StringBuilder(String)>
    //   13   29:ldc1            #179 <String ".displayAttributeBars">
    //   14   31:invokevirtual   #183 <Method StringBuilder StringBuilder.append(String)>
    //   15   34:invokevirtual   #186 <Method String StringBuilder.toString()>
    //   16   37:astore_3        
                String val = VisualizeUtils.VISUALIZE_PROPERTIES.getProperty(showAttBars);
    //   17   38:getstatic       #155 <Field Properties VisualizeUtils.VISUALIZE_PROPERTIES>
    //   18   41:aload_3         
    //   19   42:invokevirtual   #192 <Method String Properties.getProperty(String)>
    //   20   45:astore          4
                if(val != null && m_showAttBars)
    //*  21   47:aload           4
    //*  22   49:ifnull          219
    //*  23   52:aload_0         
    //*  24   53:getfield        #72  <Field boolean m_showAttBars>
    //*  25   56:ifeq            219
                    if(val.compareTo("true") == 0 || val.compareTo("on") == 0)
    //*  26   59:aload           4
    //*  27   61:ldc1            #194 <String "true">
    //*  28   63:invokevirtual   #198 <Method int String.compareTo(String)>
    //*  29   66:ifeq            79
    //*  30   69:aload           4
    //*  31   71:ldc1            #200 <String "on">
    //*  32   73:invokevirtual   #198 <Method int String.compareTo(String)>
    //*  33   76:ifne            87
                        m_showAttBars = true;
    //   34   79:aload_0         
    //   35   80:iconst_1        
    //   36   81:putfield        #72  <Field boolean m_showAttBars>
                    else
    //*  37   84:goto            219
                        m_showAttBars = false;
    //   38   87:aload_0         
    //   39   88:iconst_0        
    //   40   89:putfield        #72  <Field boolean m_showAttBars>
            } else
    //*  41   92:goto            219
            {
                String xcolKey = (new StringBuilder(String.valueOf(thisClass))).append(".").append(relationName).append(".XDimension").toString();
    //   42   95:new             #169 <Class StringBuilder>
    //   43   98:dup             
    //   44   99:aload_2         
    //   45  100:invokestatic    #175 <Method String String.valueOf(Object)>
    //   46  103:invokespecial   #177 <Method void StringBuilder(String)>
    //   47  106:ldc1            #202 <String ".">
    //   48  108:invokevirtual   #183 <Method StringBuilder StringBuilder.append(String)>
    //   49  111:aload_1         
    //   50  112:invokevirtual   #183 <Method StringBuilder StringBuilder.append(String)>
    //   51  115:ldc1            #204 <String ".XDimension">
    //   52  117:invokevirtual   #183 <Method StringBuilder StringBuilder.append(String)>
    //   53  120:invokevirtual   #186 <Method String StringBuilder.toString()>
    //   54  123:astore_3        
                String ycolKey = (new StringBuilder(String.valueOf(thisClass))).append(".").append(relationName).append(".YDimension").toString();
    //   55  124:new             #169 <Class StringBuilder>
    //   56  127:dup             
    //   57  128:aload_2         
    //   58  129:invokestatic    #175 <Method String String.valueOf(Object)>
    //   59  132:invokespecial   #177 <Method void StringBuilder(String)>
    //   60  135:ldc1            #202 <String ".">
    //   61  137:invokevirtual   #183 <Method StringBuilder StringBuilder.append(String)>
    //   62  140:aload_1         
    //   63  141:invokevirtual   #183 <Method StringBuilder StringBuilder.append(String)>
    //   64  144:ldc1            #206 <String ".YDimension">
    //   65  146:invokevirtual   #183 <Method StringBuilder StringBuilder.append(String)>
    //   66  149:invokevirtual   #186 <Method String StringBuilder.toString()>
    //   67  152:astore          4
                String ccolKey = (new StringBuilder(String.valueOf(thisClass))).append(".").append(relationName).append(".ColourDimension").toString();
    //   68  154:new             #169 <Class StringBuilder>
    //   69  157:dup             
    //   70  158:aload_2         
    //   71  159:invokestatic    #175 <Method String String.valueOf(Object)>
    //   72  162:invokespecial   #177 <Method void StringBuilder(String)>
    //   73  165:ldc1            #202 <String ".">
    //   74  167:invokevirtual   #183 <Method StringBuilder StringBuilder.append(String)>
    //   75  170:aload_1         
    //   76  171:invokevirtual   #183 <Method StringBuilder StringBuilder.append(String)>
    //   77  174:ldc1            #208 <String ".ColourDimension">
    //   78  176:invokevirtual   #183 <Method StringBuilder StringBuilder.append(String)>
    //   79  179:invokevirtual   #186 <Method String StringBuilder.toString()>
    //   80  182:astore          5
                m_preferredXDimension = VisualizeUtils.VISUALIZE_PROPERTIES.getProperty(xcolKey);
    //   81  184:aload_0         
    //   82  185:getstatic       #155 <Field Properties VisualizeUtils.VISUALIZE_PROPERTIES>
    //   83  188:aload_3         
    //   84  189:invokevirtual   #192 <Method String Properties.getProperty(String)>
    //   85  192:putfield        #210 <Field String m_preferredXDimension>
                m_preferredYDimension = VisualizeUtils.VISUALIZE_PROPERTIES.getProperty(ycolKey);
    //   86  195:aload_0         
    //   87  196:getstatic       #155 <Field Properties VisualizeUtils.VISUALIZE_PROPERTIES>
    //   88  199:aload           4
    //   89  201:invokevirtual   #192 <Method String Properties.getProperty(String)>
    //   90  204:putfield        #212 <Field String m_preferredYDimension>
                m_preferredColourDimension = VisualizeUtils.VISUALIZE_PROPERTIES.getProperty(ccolKey);
    //   91  207:aload_0         
    //   92  208:getstatic       #155 <Field Properties VisualizeUtils.VISUALIZE_PROPERTIES>
    //   93  211:aload           5
    //   94  213:invokevirtual   #192 <Method String Properties.getProperty(String)>
    //   95  216:putfield        #214 <Field String m_preferredColourDimension>
            }
        }
    //   96  219:return          
    }

    public VisualizePanel()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #222 <Method void PrintablePanel()>
        m_DefaultColors = (new Color[] {
            Color.blue, Color.red, Color.green, Color.cyan, Color.pink, new Color(255, 0, 255), Color.orange, new Color(255, 0, 0), new Color(0, 255, 0), Color.white
        });
    //    2    4:aload_0         
    //    3    5:bipush          10
    //    4    7:anewarray       Color[]
    //    5   10:dup             
    //    6   11:iconst_0        
    //    7   12:getstatic       #228 <Field Color Color.blue>
    //    8   15:aastore         
    //    9   16:dup             
    //   10   17:iconst_1        
    //   11   18:getstatic       #231 <Field Color Color.red>
    //   12   21:aastore         
    //   13   22:dup             
    //   14   23:iconst_2        
    //   15   24:getstatic       #234 <Field Color Color.green>
    //   16   27:aastore         
    //   17   28:dup             
    //   18   29:iconst_3        
    //   19   30:getstatic       #237 <Field Color Color.cyan>
    //   20   33:aastore         
    //   21   34:dup             
    //   22   35:iconst_4        
    //   23   36:getstatic       #240 <Field Color Color.pink>
    //   24   39:aastore         
    //   25   40:dup             
    //   26   41:iconst_5        
    //   27   42:new             #224 <Class Color>
    //   28   45:dup             
    //   29   46:sipush          255
    //   30   49:iconst_0        
    //   31   50:sipush          255
    //   32   53:invokespecial   #243 <Method void Color(int, int, int)>
    //   33   56:aastore         
    //   34   57:dup             
    //   35   58:bipush          6
    //   36   60:getstatic       #246 <Field Color Color.orange>
    //   37   63:aastore         
    //   38   64:dup             
    //   39   65:bipush          7
    //   40   67:new             #224 <Class Color>
    //   41   70:dup             
    //   42   71:sipush          255
    //   43   74:iconst_0        
    //   44   75:iconst_0        
    //   45   76:invokespecial   #243 <Method void Color(int, int, int)>
    //   46   79:aastore         
    //   47   80:dup             
    //   48   81:bipush          8
    //   49   83:new             #224 <Class Color>
    //   50   86:dup             
    //   51   87:iconst_0        
    //   52   88:sipush          255
    //   53   91:iconst_0        
    //   54   92:invokespecial   #243 <Method void Color(int, int, int)>
    //   55   95:aastore         
    //   56   96:dup             
    //   57   97:bipush          9
    //   58   99:getstatic       #249 <Field Color Color.white>
    //   59  102:aastore         
    //   60  103:putfield        #251 <Field Color[] m_DefaultColors>
        m_XCombo = new JComboBox();
    //   61  106:aload_0         
    //   62  107:new             #253 <Class JComboBox>
    //   63  110:dup             
    //   64  111:invokespecial   #254 <Method void JComboBox()>
    //   65  114:putfield        #256 <Field JComboBox m_XCombo>
        m_YCombo = new JComboBox();
    //   66  117:aload_0         
    //   67  118:new             #253 <Class JComboBox>
    //   68  121:dup             
    //   69  122:invokespecial   #254 <Method void JComboBox()>
    //   70  125:putfield        #258 <Field JComboBox m_YCombo>
        m_ColourCombo = new JComboBox();
    //   71  128:aload_0         
    //   72  129:new             #253 <Class JComboBox>
    //   73  132:dup             
    //   74  133:invokespecial   #254 <Method void JComboBox()>
    //   75  136:putfield        #260 <Field JComboBox m_ColourCombo>
        m_ShapeCombo = new JComboBox();
    //   76  139:aload_0         
    //   77  140:new             #253 <Class JComboBox>
    //   78  143:dup             
    //   79  144:invokespecial   #254 <Method void JComboBox()>
    //   80  147:putfield        #262 <Field JComboBox m_ShapeCombo>
        m_submit = new JButton("Submit");
    //   81  150:aload_0         
    //   82  151:new             #264 <Class JButton>
    //   83  154:dup             
    //   84  155:ldc2            #266 <String "Submit">
    //   85  158:invokespecial   #267 <Method void JButton(String)>
    //   86  161:putfield        #269 <Field JButton m_submit>
        m_cancel = new JButton("Clear");
    //   87  164:aload_0         
    //   88  165:new             #264 <Class JButton>
    //   89  168:dup             
    //   90  169:ldc2            #271 <String "Clear">
    //   91  172:invokespecial   #267 <Method void JButton(String)>
    //   92  175:putfield        #273 <Field JButton m_cancel>
        m_openBut = new JButton("Open");
    //   93  178:aload_0         
    //   94  179:new             #264 <Class JButton>
    //   95  182:dup             
    //   96  183:ldc2            #275 <String "Open">
    //   97  186:invokespecial   #267 <Method void JButton(String)>
    //   98  189:putfield        #277 <Field JButton m_openBut>
        m_saveBut = new JButton("Save");
    //   99  192:aload_0         
    //  100  193:new             #264 <Class JButton>
    //  101  196:dup             
    //  102  197:ldc2            #279 <String "Save">
    //  103  200:invokespecial   #267 <Method void JButton(String)>
    //  104  203:putfield        #281 <Field JButton m_saveBut>
        COMBO_SIZE = new Dimension(250, m_saveBut.getPreferredSize().height);
    //  105  206:aload_0         
    //  106  207:new             #283 <Class Dimension>
    //  107  210:dup             
    //  108  211:sipush          250
    //  109  214:aload_0         
    //  110  215:getfield        #281 <Field JButton m_saveBut>
    //  111  218:invokevirtual   #287 <Method Dimension JButton.getPreferredSize()>
    //  112  221:getfield        #290 <Field int Dimension.height>
    //  113  224:invokespecial   #293 <Method void Dimension(int, int)>
    //  114  227:putfield        #295 <Field Dimension COMBO_SIZE>
        m_FileChooser = new JFileChooser(new File(System.getProperty("user.dir")));
    //  115  230:aload_0         
    //  116  231:new             #297 <Class JFileChooser>
    //  117  234:dup             
    //  118  235:new             #299 <Class File>
    //  119  238:dup             
    //  120  239:ldc2            #301 <String "user.dir">
    //  121  242:invokestatic    #304 <Method String System.getProperty(String)>
    //  122  245:invokespecial   #305 <Method void File(String)>
    //  123  248:invokespecial   #308 <Method void JFileChooser(File)>
    //  124  251:putfield        #310 <Field JFileChooser m_FileChooser>
        m_ArffFilter = new ExtensionFileFilter(".ass", "Arff data files");
    //  125  254:aload_0         
    //  126  255:new             #312 <Class ExtensionFileFilter>
    //  127  258:dup             
    //  128  259:ldc2            #314 <String ".ass">
    //  129  262:ldc2            #316 <String "Arff data files">
    //  130  265:invokespecial   #319 <Method void ExtensionFileFilter(String, String)>
    //  131  268:putfield        #321 <Field FileFilter m_ArffFilter>
        m_JitterLab = new JLabel("Jitter", 4);
    //  132  271:aload_0         
    //  133  272:new             #323 <Class JLabel>
    //  134  275:dup             
    //  135  276:ldc2            #325 <String "Jitter">
    //  136  279:iconst_4        
    //  137  280:invokespecial   #328 <Method void JLabel(String, int)>
    //  138  283:putfield        #330 <Field JLabel m_JitterLab>
        m_Jitter = new JSlider(0, 50, 0);
    //  139  286:aload_0         
    //  140  287:new             #332 <Class JSlider>
    //  141  290:dup             
    //  142  291:iconst_0        
    //  143  292:bipush          50
    //  144  294:iconst_0        
    //  145  295:invokespecial   #333 <Method void JSlider(int, int, int)>
    //  146  298:putfield        #335 <Field JSlider m_Jitter>
        m_plot = new PlotPanel();
    //  147  301:aload_0         
    //  148  302:new             #337 <Class VisualizePanel$PlotPanel>
    //  149  305:dup             
    //  150  306:aload_0         
    //  151  307:invokespecial   #340 <Method void VisualizePanel$PlotPanel(VisualizePanel)>
    //  152  310:putfield        #342 <Field VisualizePanel$PlotPanel m_plot>
        m_attrib = new AttributePanel(m_plot.m_plot2D.getBackground());
    //  153  313:aload_0         
    //  154  314:new             #344 <Class AttributePanel>
    //  155  317:dup             
    //  156  318:aload_0         
    //  157  319:getfield        #342 <Field VisualizePanel$PlotPanel m_plot>
    //  158  322:getfield        #348 <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
    //  159  325:invokevirtual   #354 <Method Color Plot2D.getBackground()>
    //  160  328:invokespecial   #357 <Method void AttributePanel(Color)>
    //  161  331:putfield        #76  <Field AttributePanel m_attrib>
        m_legendPanel = new LegendPanel();
    //  162  334:aload_0         
    //  163  335:new             #359 <Class LegendPanel>
    //  164  338:dup             
    //  165  339:invokespecial   #360 <Method void LegendPanel()>
    //  166  342:putfield        #362 <Field LegendPanel m_legendPanel>
        m_plotSurround = new JPanel();
    //  167  345:aload_0         
    //  168  346:new             #78  <Class JPanel>
    //  169  349:dup             
    //  170  350:invokespecial   #363 <Method void JPanel()>
    //  171  353:putfield        #74  <Field JPanel m_plotSurround>
        m_classSurround = new JPanel();
    //  172  356:aload_0         
    //  173  357:new             #78  <Class JPanel>
    //  174  360:dup             
    //  175  361:invokespecial   #363 <Method void JPanel()>
    //  176  364:putfield        #136 <Field JPanel m_classSurround>
        listener = null;
    //  177  367:aload_0         
    //  178  368:aconst_null     
    //  179  369:putfield        #365 <Field ActionListener listener>
        m_splitListener = null;
    //  180  372:aload_0         
    //  181  373:aconst_null     
    //  182  374:putfield        #146 <Field VisualizePanelListener m_splitListener>
        m_plotName = "";
    //  183  377:aload_0         
    //  184  378:ldc2            #367 <String "">
    //  185  381:putfield        #369 <Field String m_plotName>
        m_classPanel = new ClassPanel(m_plot.m_plot2D.getBackground());
    //  186  384:aload_0         
    //  187  385:new             #371 <Class ClassPanel>
    //  188  388:dup             
    //  189  389:aload_0         
    //  190  390:getfield        #342 <Field VisualizePanel$PlotPanel m_plot>
    //  191  393:getfield        #348 <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
    //  192  396:invokevirtual   #354 <Method Color Plot2D.getBackground()>
    //  193  399:invokespecial   #372 <Method void ClassPanel(Color)>
    //  194  402:putfield        #374 <Field ClassPanel m_classPanel>
        m_preferredXDimension = null;
    //  195  405:aload_0         
    //  196  406:aconst_null     
    //  197  407:putfield        #210 <Field String m_preferredXDimension>
        m_preferredYDimension = null;
    //  198  410:aload_0         
    //  199  411:aconst_null     
    //  200  412:putfield        #212 <Field String m_preferredYDimension>
        m_preferredColourDimension = null;
    //  201  415:aload_0         
    //  202  416:aconst_null     
    //  203  417:putfield        #214 <Field String m_preferredColourDimension>
        m_showAttBars = true;
    //  204  420:aload_0         
    //  205  421:iconst_1        
    //  206  422:putfield        #72  <Field boolean m_showAttBars>
        m_showClassPanel = true;
    //  207  425:aload_0         
    //  208  426:iconst_1        
    //  209  427:putfield        #134 <Field boolean m_showClassPanel>
        setProperties(null);
    //  210  430:aload_0         
    //  211  431:aconst_null     
    //  212  432:invokespecial   #376 <Method void setProperties(String)>
        m_FileChooser.setFileFilter(m_ArffFilter);
    //  213  435:aload_0         
    //  214  436:getfield        #310 <Field JFileChooser m_FileChooser>
    //  215  439:aload_0         
    //  216  440:getfield        #321 <Field FileFilter m_ArffFilter>
    //  217  443:invokevirtual   #380 <Method void JFileChooser.setFileFilter(FileFilter)>
        m_FileChooser.setFileSelectionMode(0);
    //  218  446:aload_0         
    //  219  447:getfield        #310 <Field JFileChooser m_FileChooser>
    //  220  450:iconst_0        
    //  221  451:invokevirtual   #384 <Method void JFileChooser.setFileSelectionMode(int)>
        m_XCombo.setToolTipText("Select the attribute for the x axis");
    //  222  454:aload_0         
    //  223  455:getfield        #256 <Field JComboBox m_XCombo>
    //  224  458:ldc2            #386 <String "Select the attribute for the x axis">
    //  225  461:invokevirtual   #389 <Method void JComboBox.setToolTipText(String)>
        m_YCombo.setToolTipText("Select the attribute for the y axis");
    //  226  464:aload_0         
    //  227  465:getfield        #258 <Field JComboBox m_YCombo>
    //  228  468:ldc2            #391 <String "Select the attribute for the y axis">
    //  229  471:invokevirtual   #389 <Method void JComboBox.setToolTipText(String)>
        m_ColourCombo.setToolTipText("Select the attribute to colour on");
    //  230  474:aload_0         
    //  231  475:getfield        #260 <Field JComboBox m_ColourCombo>
    //  232  478:ldc2            #393 <String "Select the attribute to colour on">
    //  233  481:invokevirtual   #389 <Method void JComboBox.setToolTipText(String)>
        m_ShapeCombo.setToolTipText("Select the shape to use for data selection");
    //  234  484:aload_0         
    //  235  485:getfield        #262 <Field JComboBox m_ShapeCombo>
    //  236  488:ldc2            #395 <String "Select the shape to use for data selection">
    //  237  491:invokevirtual   #389 <Method void JComboBox.setToolTipText(String)>
        m_XCombo.setPreferredSize(COMBO_SIZE);
    //  238  494:aload_0         
    //  239  495:getfield        #256 <Field JComboBox m_XCombo>
    //  240  498:aload_0         
    //  241  499:getfield        #295 <Field Dimension COMBO_SIZE>
    //  242  502:invokevirtual   #399 <Method void JComboBox.setPreferredSize(Dimension)>
        m_YCombo.setPreferredSize(COMBO_SIZE);
    //  243  505:aload_0         
    //  244  506:getfield        #258 <Field JComboBox m_YCombo>
    //  245  509:aload_0         
    //  246  510:getfield        #295 <Field Dimension COMBO_SIZE>
    //  247  513:invokevirtual   #399 <Method void JComboBox.setPreferredSize(Dimension)>
        m_ColourCombo.setPreferredSize(COMBO_SIZE);
    //  248  516:aload_0         
    //  249  517:getfield        #260 <Field JComboBox m_ColourCombo>
    //  250  520:aload_0         
    //  251  521:getfield        #295 <Field Dimension COMBO_SIZE>
    //  252  524:invokevirtual   #399 <Method void JComboBox.setPreferredSize(Dimension)>
        m_ShapeCombo.setPreferredSize(COMBO_SIZE);
    //  253  527:aload_0         
    //  254  528:getfield        #262 <Field JComboBox m_ShapeCombo>
    //  255  531:aload_0         
    //  256  532:getfield        #295 <Field Dimension COMBO_SIZE>
    //  257  535:invokevirtual   #399 <Method void JComboBox.setPreferredSize(Dimension)>
        m_XCombo.setMaximumSize(COMBO_SIZE);
    //  258  538:aload_0         
    //  259  539:getfield        #256 <Field JComboBox m_XCombo>
    //  260  542:aload_0         
    //  261  543:getfield        #295 <Field Dimension COMBO_SIZE>
    //  262  546:invokevirtual   #402 <Method void JComboBox.setMaximumSize(Dimension)>
        m_YCombo.setMaximumSize(COMBO_SIZE);
    //  263  549:aload_0         
    //  264  550:getfield        #258 <Field JComboBox m_YCombo>
    //  265  553:aload_0         
    //  266  554:getfield        #295 <Field Dimension COMBO_SIZE>
    //  267  557:invokevirtual   #402 <Method void JComboBox.setMaximumSize(Dimension)>
        m_ColourCombo.setMaximumSize(COMBO_SIZE);
    //  268  560:aload_0         
    //  269  561:getfield        #260 <Field JComboBox m_ColourCombo>
    //  270  564:aload_0         
    //  271  565:getfield        #295 <Field Dimension COMBO_SIZE>
    //  272  568:invokevirtual   #402 <Method void JComboBox.setMaximumSize(Dimension)>
        m_ShapeCombo.setMaximumSize(COMBO_SIZE);
    //  273  571:aload_0         
    //  274  572:getfield        #262 <Field JComboBox m_ShapeCombo>
    //  275  575:aload_0         
    //  276  576:getfield        #295 <Field Dimension COMBO_SIZE>
    //  277  579:invokevirtual   #402 <Method void JComboBox.setMaximumSize(Dimension)>
        m_XCombo.setMinimumSize(COMBO_SIZE);
    //  278  582:aload_0         
    //  279  583:getfield        #256 <Field JComboBox m_XCombo>
    //  280  586:aload_0         
    //  281  587:getfield        #295 <Field Dimension COMBO_SIZE>
    //  282  590:invokevirtual   #405 <Method void JComboBox.setMinimumSize(Dimension)>
        m_YCombo.setMinimumSize(COMBO_SIZE);
    //  283  593:aload_0         
    //  284  594:getfield        #258 <Field JComboBox m_YCombo>
    //  285  597:aload_0         
    //  286  598:getfield        #295 <Field Dimension COMBO_SIZE>
    //  287  601:invokevirtual   #405 <Method void JComboBox.setMinimumSize(Dimension)>
        m_ColourCombo.setMinimumSize(COMBO_SIZE);
    //  288  604:aload_0         
    //  289  605:getfield        #260 <Field JComboBox m_ColourCombo>
    //  290  608:aload_0         
    //  291  609:getfield        #295 <Field Dimension COMBO_SIZE>
    //  292  612:invokevirtual   #405 <Method void JComboBox.setMinimumSize(Dimension)>
        m_ShapeCombo.setMinimumSize(COMBO_SIZE);
    //  293  615:aload_0         
    //  294  616:getfield        #262 <Field JComboBox m_ShapeCombo>
    //  295  619:aload_0         
    //  296  620:getfield        #295 <Field Dimension COMBO_SIZE>
    //  297  623:invokevirtual   #405 <Method void JComboBox.setMinimumSize(Dimension)>
        m_XCombo.setEnabled(false);
    //  298  626:aload_0         
    //  299  627:getfield        #256 <Field JComboBox m_XCombo>
    //  300  630:iconst_0        
    //  301  631:invokevirtual   #408 <Method void JComboBox.setEnabled(boolean)>
        m_YCombo.setEnabled(false);
    //  302  634:aload_0         
    //  303  635:getfield        #258 <Field JComboBox m_YCombo>
    //  304  638:iconst_0        
    //  305  639:invokevirtual   #408 <Method void JComboBox.setEnabled(boolean)>
        m_ColourCombo.setEnabled(false);
    //  306  642:aload_0         
    //  307  643:getfield        #260 <Field JComboBox m_ColourCombo>
    //  308  646:iconst_0        
    //  309  647:invokevirtual   #408 <Method void JComboBox.setEnabled(boolean)>
        m_ShapeCombo.setEnabled(false);
    //  310  650:aload_0         
    //  311  651:getfield        #262 <Field JComboBox m_ShapeCombo>
    //  312  654:iconst_0        
    //  313  655:invokevirtual   #408 <Method void JComboBox.setEnabled(boolean)>
        m_classPanel.addRepaintNotify(this);
    //  314  658:aload_0         
    //  315  659:getfield        #374 <Field ClassPanel m_classPanel>
    //  316  662:aload_0         
    //  317  663:invokevirtual   #411 <Method void ClassPanel.addRepaintNotify(Component)>
        m_legendPanel.addRepaintNotify(this);
    //  318  666:aload_0         
    //  319  667:getfield        #362 <Field LegendPanel m_legendPanel>
    //  320  670:aload_0         
    //  321  671:invokevirtual   #412 <Method void LegendPanel.addRepaintNotify(Component)>
        for(int i = 0; i < m_DefaultColors.length; i++)
    //* 322  674:iconst_0        
    //* 323  675:istore_1        
    //* 324  676:goto            821
        {
            Color c = m_DefaultColors[i];
    //  325  679:aload_0         
    //  326  680:getfield        #251 <Field Color[] m_DefaultColors>
    //  327  683:iload_1         
    //  328  684:aaload          
    //  329  685:astore_2        
            if(c.equals(m_plot.m_plot2D.getBackground()))
    //* 330  686:aload_2         
    //* 331  687:aload_0         
    //* 332  688:getfield        #342 <Field VisualizePanel$PlotPanel m_plot>
    //* 333  691:getfield        #348 <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
    //* 334  694:invokevirtual   #354 <Method Color Plot2D.getBackground()>
    //* 335  697:invokevirtual   #416 <Method boolean Color.equals(Object)>
    //* 336  700:ifeq            818
            {
                int red = c.getRed();
    //  337  703:aload_2         
    //  338  704:invokevirtual   #420 <Method int Color.getRed()>
    //  339  707:istore_3        
                int blue = c.getBlue();
    //  340  708:aload_2         
    //  341  709:invokevirtual   #423 <Method int Color.getBlue()>
    //  342  712:istore          4
                int green = c.getGreen();
    //  343  714:aload_2         
    //  344  715:invokevirtual   #426 <Method int Color.getGreen()>
    //  345  718:istore          5
                red += red >= 128 ? -(red / 2) : (255 - red) / 2;
    //  346  720:iload_3         
    //  347  721:iload_3         
    //  348  722:sipush          128
    //  349  725:icmpge          738
    //  350  728:sipush          255
    //  351  731:iload_3         
    //  352  732:isub            
    //  353  733:iconst_2        
    //  354  734:idiv            
    //  355  735:goto            742
    //  356  738:iload_3         
    //  357  739:iconst_2        
    //  358  740:idiv            
    //  359  741:ineg            
    //  360  742:iadd            
    //  361  743:istore_3        
                blue += blue >= 128 ? -(blue / 2) : (blue - red) / 2;
    //  362  744:iload           4
    //  363  746:iload           4
    //  364  748:sipush          128
    //  365  751:icmpge          763
    //  366  754:iload           4
    //  367  756:iload_3         
    //  368  757:isub            
    //  369  758:iconst_2        
    //  370  759:idiv            
    //  371  760:goto            768
    //  372  763:iload           4
    //  373  765:iconst_2        
    //  374  766:idiv            
    //  375  767:ineg            
    //  376  768:iadd            
    //  377  769:istore          4
                green += green >= 128 ? -(green / 2) : (255 - green) / 2;
    //  378  771:iload           5
    //  379  773:iload           5
    //  380  775:sipush          128
    //  381  778:icmpge          792
    //  382  781:sipush          255
    //  383  784:iload           5
    //  384  786:isub            
    //  385  787:iconst_2        
    //  386  788:idiv            
    //  387  789:goto            797
    //  388  792:iload           5
    //  389  794:iconst_2        
    //  390  795:idiv            
    //  391  796:ineg            
    //  392  797:iadd            
    //  393  798:istore          5
                m_DefaultColors[i] = new Color(red, green, blue);
    //  394  800:aload_0         
    //  395  801:getfield        #251 <Field Color[] m_DefaultColors>
    //  396  804:iload_1         
    //  397  805:new             #224 <Class Color>
    //  398  808:dup             
    //  399  809:iload_3         
    //  400  810:iload           5
    //  401  812:iload           4
    //  402  814:invokespecial   #243 <Method void Color(int, int, int)>
    //  403  817:aastore         
            }
        }

    //  404  818:iinc            1  1
    //  405  821:iload_1         
    //  406  822:aload_0         
    //  407  823:getfield        #251 <Field Color[] m_DefaultColors>
    //  408  826:arraylength     
    //  409  827:icmplt          679
        m_classPanel.setDefaultColourList(m_DefaultColors);
    //  410  830:aload_0         
    //  411  831:getfield        #374 <Field ClassPanel m_classPanel>
    //  412  834:aload_0         
    //  413  835:getfield        #251 <Field Color[] m_DefaultColors>
    //  414  838:invokevirtual   #430 <Method void ClassPanel.setDefaultColourList(Color[])>
        m_attrib.setDefaultColourList(m_DefaultColors);
    //  415  841:aload_0         
    //  416  842:getfield        #76  <Field AttributePanel m_attrib>
    //  417  845:aload_0         
    //  418  846:getfield        #251 <Field Color[] m_DefaultColors>
    //  419  849:invokevirtual   #431 <Method void AttributePanel.setDefaultColourList(Color[])>
        m_colorList = new FastVector(10);
    //  420  852:aload_0         
    //  421  853:new             #433 <Class FastVector>
    //  422  856:dup             
    //  423  857:bipush          10
    //  424  859:invokespecial   #435 <Method void FastVector(int)>
    //  425  862:putfield        #437 <Field FastVector m_colorList>
        for(int noa = m_colorList.size(); noa < 10; noa++)
    //* 426  865:aload_0         
    //* 427  866:getfield        #437 <Field FastVector m_colorList>
    //* 428  869:invokevirtual   #440 <Method int FastVector.size()>
    //* 429  872:istore_1        
    //* 430  873:goto            926
        {
            Color pc = m_DefaultColors[noa % 10];
    //  431  876:aload_0         
    //  432  877:getfield        #251 <Field Color[] m_DefaultColors>
    //  433  880:iload_1         
    //  434  881:bipush          10
    //  435  883:irem            
    //  436  884:aaload          
    //  437  885:astore_2        
            int ija = noa / 10;
    //  438  886:iload_1         
    //  439  887:bipush          10
    //  440  889:idiv            
    //  441  890:istore_3        
            ija *= 2;
    //  442  891:iload_3         
    //  443  892:iconst_2        
    //  444  893:imul            
    //  445  894:istore_3        
            for(int j = 0; j < ija; j++)
    //* 446  895:iconst_0        
    //* 447  896:istore          4
    //* 448  898:goto            909
                pc = pc.darker();
    //  449  901:aload_2         
    //  450  902:invokevirtual   #443 <Method Color Color.darker()>
    //  451  905:astore_2        

    //  452  906:iinc            4  1
    //  453  909:iload           4
    //  454  911:iload_3         
    //  455  912:icmplt          901
            m_colorList.addElement(pc);
    //  456  915:aload_0         
    //  457  916:getfield        #437 <Field FastVector m_colorList>
    //  458  919:aload_2         
    //  459  920:invokevirtual   #447 <Method void FastVector.addElement(Object)>
        }

    //  460  923:iinc            1  1
    //  461  926:iload_1         
    //  462  927:bipush          10
    //  463  929:icmplt          876
        m_plot.setColours(m_colorList);
    //  464  932:aload_0         
    //  465  933:getfield        #342 <Field VisualizePanel$PlotPanel m_plot>
    //  466  936:aload_0         
    //  467  937:getfield        #437 <Field FastVector m_colorList>
    //  468  940:invokevirtual   #451 <Method void VisualizePanel$PlotPanel.setColours(FastVector)>
        m_classPanel.setColours(m_colorList);
    //  469  943:aload_0         
    //  470  944:getfield        #374 <Field ClassPanel m_classPanel>
    //  471  947:aload_0         
    //  472  948:getfield        #437 <Field FastVector m_colorList>
    //  473  951:invokevirtual   #452 <Method void ClassPanel.setColours(FastVector)>
        m_attrib.setColours(m_colorList);
    //  474  954:aload_0         
    //  475  955:getfield        #76  <Field AttributePanel m_attrib>
    //  476  958:aload_0         
    //  477  959:getfield        #437 <Field FastVector m_colorList>
    //  478  962:invokevirtual   #453 <Method void AttributePanel.setColours(FastVector)>
        m_attrib.addAttributePanelListener(new AttributePanelListener() {

            public void attributeSelectionChange(AttributePanelEvent e)
            {
                if(e.m_xChange)
            //*   0    0:aload_1         
            //*   1    1:getfield        #28  <Field boolean AttributePanelEvent.m_xChange>
            //*   2    4:ifeq            24
                    m_XCombo.setSelectedIndex(e.m_indexVal);
            //    3    7:aload_0         
            //    4    8:getfield        #13  <Field VisualizePanel this$0>
            //    5   11:getfield        #34  <Field JComboBox VisualizePanel.m_XCombo>
            //    6   14:aload_1         
            //    7   15:getfield        #38  <Field int AttributePanelEvent.m_indexVal>
            //    8   18:invokevirtual   #44  <Method void JComboBox.setSelectedIndex(int)>
                else
            //*   9   21:goto            38
                    m_YCombo.setSelectedIndex(e.m_indexVal);
            //   10   24:aload_0         
            //   11   25:getfield        #13  <Field VisualizePanel this$0>
            //   12   28:getfield        #47  <Field JComboBox VisualizePanel.m_YCombo>
            //   13   31:aload_1         
            //   14   32:getfield        #38  <Field int AttributePanelEvent.m_indexVal>
            //   15   35:invokevirtual   #44  <Method void JComboBox.setSelectedIndex(int)>
            //   16   38:return          
            }

            final VisualizePanel this$0;

            
            {
                this$0 = VisualizePanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field VisualizePanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //  479  965:aload_0         
    //  480  966:getfield        #76  <Field AttributePanel m_attrib>
    //  481  969:new             #455 <Class VisualizePanel$5>
    //  482  972:dup             
    //  483  973:aload_0         
    //  484  974:invokespecial   #456 <Method void VisualizePanel$5(VisualizePanel)>
    //  485  977:invokevirtual   #460 <Method void AttributePanel.addAttributePanelListener(AttributePanelListener)>
        m_XCombo.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                int selected = m_XCombo.getSelectedIndex();
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field VisualizePanel this$0>
            //    2    4:getfield        #28  <Field JComboBox VisualizePanel.m_XCombo>
            //    3    7:invokevirtual   #34  <Method int JComboBox.getSelectedIndex()>
            //    4   10:istore_2        
                if(selected < 0)
            //*   5   11:iload_2         
            //*   6   12:ifge            17
                    selected = 0;
            //    7   15:iconst_0        
            //    8   16:istore_2        
                m_plot.setXindex(selected);
            //    9   17:aload_0         
            //   10   18:getfield        #13  <Field VisualizePanel this$0>
            //   11   21:getfield        #38  <Field VisualizePanel$PlotPanel VisualizePanel.m_plot>
            //   12   24:iload_2         
            //   13   25:invokevirtual   #44  <Method void VisualizePanel$PlotPanel.setXindex(int)>
                if(listener != null)
            //*  14   28:aload_0         
            //*  15   29:getfield        #13  <Field VisualizePanel this$0>
            //*  16   32:getfield        #48  <Field ActionListener VisualizePanel.listener>
            //*  17   35:ifnull          51
                    listener.actionPerformed(e);
            //   18   38:aload_0         
            //   19   39:getfield        #13  <Field VisualizePanel this$0>
            //   20   42:getfield        #48  <Field ActionListener VisualizePanel.listener>
            //   21   45:aload_1         
            //   22   46:invokeinterface #50  <Method void ActionListener.actionPerformed(ActionEvent)>
            //   23   51:return          
            }

            final VisualizePanel this$0;

            
            {
                this$0 = VisualizePanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field VisualizePanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //  486  980:aload_0         
    //  487  981:getfield        #256 <Field JComboBox m_XCombo>
    //  488  984:new             #462 <Class VisualizePanel$6>
    //  489  987:dup             
    //  490  988:aload_0         
    //  491  989:invokespecial   #463 <Method void VisualizePanel$6(VisualizePanel)>
    //  492  992:invokevirtual   #467 <Method void JComboBox.addActionListener(ActionListener)>
        m_YCombo.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                int selected = m_YCombo.getSelectedIndex();
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field VisualizePanel this$0>
            //    2    4:getfield        #28  <Field JComboBox VisualizePanel.m_YCombo>
            //    3    7:invokevirtual   #34  <Method int JComboBox.getSelectedIndex()>
            //    4   10:istore_2        
                if(selected < 0)
            //*   5   11:iload_2         
            //*   6   12:ifge            17
                    selected = 0;
            //    7   15:iconst_0        
            //    8   16:istore_2        
                m_plot.setYindex(selected);
            //    9   17:aload_0         
            //   10   18:getfield        #13  <Field VisualizePanel this$0>
            //   11   21:getfield        #38  <Field VisualizePanel$PlotPanel VisualizePanel.m_plot>
            //   12   24:iload_2         
            //   13   25:invokevirtual   #44  <Method void VisualizePanel$PlotPanel.setYindex(int)>
                if(listener != null)
            //*  14   28:aload_0         
            //*  15   29:getfield        #13  <Field VisualizePanel this$0>
            //*  16   32:getfield        #48  <Field ActionListener VisualizePanel.listener>
            //*  17   35:ifnull          51
                    listener.actionPerformed(e);
            //   18   38:aload_0         
            //   19   39:getfield        #13  <Field VisualizePanel this$0>
            //   20   42:getfield        #48  <Field ActionListener VisualizePanel.listener>
            //   21   45:aload_1         
            //   22   46:invokeinterface #50  <Method void ActionListener.actionPerformed(ActionEvent)>
            //   23   51:return          
            }

            final VisualizePanel this$0;

            
            {
                this$0 = VisualizePanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field VisualizePanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //  493  995:aload_0         
    //  494  996:getfield        #258 <Field JComboBox m_YCombo>
    //  495  999:new             #469 <Class VisualizePanel$7>
    //  496 1002:dup             
    //  497 1003:aload_0         
    //  498 1004:invokespecial   #470 <Method void VisualizePanel$7(VisualizePanel)>
    //  499 1007:invokevirtual   #467 <Method void JComboBox.addActionListener(ActionListener)>
        m_ColourCombo.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                int selected = m_ColourCombo.getSelectedIndex();
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field VisualizePanel this$0>
            //    2    4:getfield        #28  <Field JComboBox VisualizePanel.m_ColourCombo>
            //    3    7:invokevirtual   #34  <Method int JComboBox.getSelectedIndex()>
            //    4   10:istore_2        
                if(selected < 0)
            //*   5   11:iload_2         
            //*   6   12:ifge            17
                    selected = 0;
            //    7   15:iconst_0        
            //    8   16:istore_2        
                m_plot.setCindex(selected);
            //    9   17:aload_0         
            //   10   18:getfield        #13  <Field VisualizePanel this$0>
            //   11   21:getfield        #38  <Field VisualizePanel$PlotPanel VisualizePanel.m_plot>
            //   12   24:iload_2         
            //   13   25:invokevirtual   #44  <Method void VisualizePanel$PlotPanel.setCindex(int)>
                if(listener != null)
            //*  14   28:aload_0         
            //*  15   29:getfield        #13  <Field VisualizePanel this$0>
            //*  16   32:getfield        #48  <Field ActionListener VisualizePanel.listener>
            //*  17   35:ifnull          51
                    listener.actionPerformed(e);
            //   18   38:aload_0         
            //   19   39:getfield        #13  <Field VisualizePanel this$0>
            //   20   42:getfield        #48  <Field ActionListener VisualizePanel.listener>
            //   21   45:aload_1         
            //   22   46:invokeinterface #50  <Method void ActionListener.actionPerformed(ActionEvent)>
            //   23   51:return          
            }

            final VisualizePanel this$0;

            
            {
                this$0 = VisualizePanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field VisualizePanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //  500 1010:aload_0         
    //  501 1011:getfield        #260 <Field JComboBox m_ColourCombo>
    //  502 1014:new             #472 <Class VisualizePanel$8>
    //  503 1017:dup             
    //  504 1018:aload_0         
    //  505 1019:invokespecial   #473 <Method void VisualizePanel$8(VisualizePanel)>
    //  506 1022:invokevirtual   #467 <Method void JComboBox.addActionListener(ActionListener)>
        m_ShapeCombo.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                int selected = m_ShapeCombo.getSelectedIndex();
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field VisualizePanel this$0>
            //    2    4:getfield        #28  <Field JComboBox VisualizePanel.m_ShapeCombo>
            //    3    7:invokevirtual   #34  <Method int JComboBox.getSelectedIndex()>
            //    4   10:istore_2        
                if(selected < 0)
            //*   5   11:iload_2         
            //*   6   12:ifge            17
                    selected = 0;
            //    7   15:iconst_0        
            //    8   16:istore_2        
                m_plot.setSindex(selected);
            //    9   17:aload_0         
            //   10   18:getfield        #13  <Field VisualizePanel this$0>
            //   11   21:getfield        #38  <Field VisualizePanel$PlotPanel VisualizePanel.m_plot>
            //   12   24:iload_2         
            //   13   25:invokevirtual   #44  <Method void VisualizePanel$PlotPanel.setSindex(int)>
                if(listener != null)
            //*  14   28:aload_0         
            //*  15   29:getfield        #13  <Field VisualizePanel this$0>
            //*  16   32:getfield        #48  <Field ActionListener VisualizePanel.listener>
            //*  17   35:ifnull          51
                    listener.actionPerformed(e);
            //   18   38:aload_0         
            //   19   39:getfield        #13  <Field VisualizePanel this$0>
            //   20   42:getfield        #48  <Field ActionListener VisualizePanel.listener>
            //   21   45:aload_1         
            //   22   46:invokeinterface #50  <Method void ActionListener.actionPerformed(ActionEvent)>
            //   23   51:return          
            }

            final VisualizePanel this$0;

            
            {
                this$0 = VisualizePanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field VisualizePanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //  507 1025:aload_0         
    //  508 1026:getfield        #262 <Field JComboBox m_ShapeCombo>
    //  509 1029:new             #475 <Class VisualizePanel$9>
    //  510 1032:dup             
    //  511 1033:aload_0         
    //  512 1034:invokespecial   #476 <Method void VisualizePanel$9(VisualizePanel)>
    //  513 1037:invokevirtual   #467 <Method void JComboBox.addActionListener(ActionListener)>
        m_Jitter.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent e)
            {
                m_plot.setJitter(m_Jitter.getValue());
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field VisualizePanel this$0>
            //    2    4:getfield        #28  <Field VisualizePanel$PlotPanel VisualizePanel.m_plot>
            //    3    7:aload_0         
            //    4    8:getfield        #13  <Field VisualizePanel this$0>
            //    5   11:getfield        #32  <Field JSlider VisualizePanel.m_Jitter>
            //    6   14:invokevirtual   #38  <Method int JSlider.getValue()>
            //    7   17:invokevirtual   #44  <Method void VisualizePanel$PlotPanel.setJitter(int)>
            //    8   20:return          
            }

            final VisualizePanel this$0;

            
            {
                this$0 = VisualizePanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field VisualizePanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //  514 1040:aload_0         
    //  515 1041:getfield        #335 <Field JSlider m_Jitter>
    //  516 1044:new             #478 <Class VisualizePanel$10>
    //  517 1047:dup             
    //  518 1048:aload_0         
    //  519 1049:invokespecial   #479 <Method void VisualizePanel$10(VisualizePanel)>
    //  520 1052:invokevirtual   #483 <Method void JSlider.addChangeListener(ChangeListener)>
        m_openBut.setToolTipText("Loads previously saved instances from a file");
    //  521 1055:aload_0         
    //  522 1056:getfield        #277 <Field JButton m_openBut>
    //  523 1059:ldc2            #485 <String "Loads previously saved instances from a file">
    //  524 1062:invokevirtual   #486 <Method void JButton.setToolTipText(String)>
        m_openBut.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                openVisibleInstances();
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field VisualizePanel this$0>
            //    2    4:invokevirtual   #27  <Method void VisualizePanel.openVisibleInstances()>
            //    3    7:return          
            }

            final VisualizePanel this$0;

            
            {
                this$0 = VisualizePanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field VisualizePanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //  525 1065:aload_0         
    //  526 1066:getfield        #277 <Field JButton m_openBut>
    //  527 1069:new             #488 <Class VisualizePanel$11>
    //  528 1072:dup             
    //  529 1073:aload_0         
    //  530 1074:invokespecial   #489 <Method void VisualizePanel$11(VisualizePanel)>
    //  531 1077:invokevirtual   #490 <Method void JButton.addActionListener(ActionListener)>
        m_saveBut.setEnabled(false);
    //  532 1080:aload_0         
    //  533 1081:getfield        #281 <Field JButton m_saveBut>
    //  534 1084:iconst_0        
    //  535 1085:invokevirtual   #491 <Method void JButton.setEnabled(boolean)>
        m_saveBut.setToolTipText("Save the visible instances to a file");
    //  536 1088:aload_0         
    //  537 1089:getfield        #281 <Field JButton m_saveBut>
    //  538 1092:ldc2            #493 <String "Save the visible instances to a file">
    //  539 1095:invokevirtual   #486 <Method void JButton.setToolTipText(String)>
        m_saveBut.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                saveVisibleInstances();
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field VisualizePanel this$0>
            //    2    4:invokestatic    #27  <Method void VisualizePanel.access$0(VisualizePanel)>
            //    3    7:return          
            }

            final VisualizePanel this$0;

            
            {
                this$0 = VisualizePanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field VisualizePanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //  540 1098:aload_0         
    //  541 1099:getfield        #281 <Field JButton m_saveBut>
    //  542 1102:new             #495 <Class VisualizePanel$12>
    //  543 1105:dup             
    //  544 1106:aload_0         
    //  545 1107:invokespecial   #496 <Method void VisualizePanel$12(VisualizePanel)>
    //  546 1110:invokevirtual   #490 <Method void JButton.addActionListener(ActionListener)>
        JPanel combos = new JPanel();
    //  547 1113:new             #78  <Class JPanel>
    //  548 1116:dup             
    //  549 1117:invokespecial   #363 <Method void JPanel()>
    //  550 1120:astore_1        
        GridBagLayout gb = new GridBagLayout();
    //  551 1121:new             #498 <Class GridBagLayout>
    //  552 1124:dup             
    //  553 1125:invokespecial   #499 <Method void GridBagLayout()>
    //  554 1128:astore_2        
        GridBagConstraints constraints = new GridBagConstraints();
    //  555 1129:new             #84  <Class GridBagConstraints>
    //  556 1132:dup             
    //  557 1133:invokespecial   #88  <Method void GridBagConstraints()>
    //  558 1136:astore_3        
        m_XCombo.setLightWeightPopupEnabled(false);
    //  559 1137:aload_0         
    //  560 1138:getfield        #256 <Field JComboBox m_XCombo>
    //  561 1141:iconst_0        
    //  562 1142:invokevirtual   #502 <Method void JComboBox.setLightWeightPopupEnabled(boolean)>
        m_YCombo.setLightWeightPopupEnabled(false);
    //  563 1145:aload_0         
    //  564 1146:getfield        #258 <Field JComboBox m_YCombo>
    //  565 1149:iconst_0        
    //  566 1150:invokevirtual   #502 <Method void JComboBox.setLightWeightPopupEnabled(boolean)>
        m_ColourCombo.setLightWeightPopupEnabled(false);
    //  567 1153:aload_0         
    //  568 1154:getfield        #260 <Field JComboBox m_ColourCombo>
    //  569 1157:iconst_0        
    //  570 1158:invokevirtual   #502 <Method void JComboBox.setLightWeightPopupEnabled(boolean)>
        m_ShapeCombo.setLightWeightPopupEnabled(false);
    //  571 1161:aload_0         
    //  572 1162:getfield        #262 <Field JComboBox m_ShapeCombo>
    //  573 1165:iconst_0        
    //  574 1166:invokevirtual   #502 <Method void JComboBox.setLightWeightPopupEnabled(boolean)>
        combos.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
    //  575 1169:aload_1         
    //  576 1170:bipush          10
    //  577 1172:iconst_5        
    //  578 1173:bipush          10
    //  579 1175:iconst_5        
    //  580 1176:invokestatic    #508 <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
    //  581 1179:invokevirtual   #512 <Method void JPanel.setBorder(javax.swing.border.Border)>
        combos.setLayout(gb);
    //  582 1182:aload_1         
    //  583 1183:aload_2         
    //  584 1184:invokevirtual   #516 <Method void JPanel.setLayout(java.awt.LayoutManager)>
        constraints.gridx = 0;
    //  585 1187:aload_3         
    //  586 1188:iconst_0        
    //  587 1189:putfield        #101 <Field int GridBagConstraints.gridx>
        constraints.gridy = 0;
    //  588 1192:aload_3         
    //  589 1193:iconst_0        
    //  590 1194:putfield        #104 <Field int GridBagConstraints.gridy>
        constraints.weightx = 5D;
    //  591 1197:aload_3         
    //  592 1198:ldc2w           #115 <Double 5D>
    //  593 1201:putfield        #108 <Field double GridBagConstraints.weightx>
        constraints.fill = 2;
    //  594 1204:aload_3         
    //  595 1205:iconst_2        
    //  596 1206:putfield        #519 <Field int GridBagConstraints.fill>
        constraints.gridwidth = 2;
    //  597 1209:aload_3         
    //  598 1210:iconst_2        
    //  599 1211:putfield        #111 <Field int GridBagConstraints.gridwidth>
        constraints.gridheight = 1;
    //  600 1214:aload_3         
    //  601 1215:iconst_1        
    //  602 1216:putfield        #114 <Field int GridBagConstraints.gridheight>
        constraints.insets = new Insets(0, 2, 0, 2);
    //  603 1219:aload_3         
    //  604 1220:new             #90  <Class Insets>
    //  605 1223:dup             
    //  606 1224:iconst_0        
    //  607 1225:iconst_2        
    //  608 1226:iconst_0        
    //  609 1227:iconst_2        
    //  610 1228:invokespecial   #93  <Method void Insets(int, int, int, int)>
    //  611 1231:putfield        #97  <Field Insets GridBagConstraints.insets>
        combos.add(m_XCombo, constraints);
    //  612 1234:aload_1         
    //  613 1235:aload_0         
    //  614 1236:getfield        #256 <Field JComboBox m_XCombo>
    //  615 1239:aload_3         
    //  616 1240:invokevirtual   #123 <Method void JPanel.add(Component, Object)>
        constraints.gridx = 2;
    //  617 1243:aload_3         
    //  618 1244:iconst_2        
    //  619 1245:putfield        #101 <Field int GridBagConstraints.gridx>
        constraints.gridy = 0;
    //  620 1248:aload_3         
    //  621 1249:iconst_0        
    //  622 1250:putfield        #104 <Field int GridBagConstraints.gridy>
        constraints.weightx = 5D;
    //  623 1253:aload_3         
    //  624 1254:ldc2w           #115 <Double 5D>
    //  625 1257:putfield        #108 <Field double GridBagConstraints.weightx>
        constraints.gridwidth = 2;
    //  626 1260:aload_3         
    //  627 1261:iconst_2        
    //  628 1262:putfield        #111 <Field int GridBagConstraints.gridwidth>
        constraints.gridheight = 1;
    //  629 1265:aload_3         
    //  630 1266:iconst_1        
    //  631 1267:putfield        #114 <Field int GridBagConstraints.gridheight>
        combos.add(m_YCombo, constraints);
    //  632 1270:aload_1         
    //  633 1271:aload_0         
    //  634 1272:getfield        #258 <Field JComboBox m_YCombo>
    //  635 1275:aload_3         
    //  636 1276:invokevirtual   #123 <Method void JPanel.add(Component, Object)>
        constraints.gridx = 0;
    //  637 1279:aload_3         
    //  638 1280:iconst_0        
    //  639 1281:putfield        #101 <Field int GridBagConstraints.gridx>
        constraints.gridy = 1;
    //  640 1284:aload_3         
    //  641 1285:iconst_1        
    //  642 1286:putfield        #104 <Field int GridBagConstraints.gridy>
        constraints.weightx = 5D;
    //  643 1289:aload_3         
    //  644 1290:ldc2w           #115 <Double 5D>
    //  645 1293:putfield        #108 <Field double GridBagConstraints.weightx>
        constraints.gridwidth = 2;
    //  646 1296:aload_3         
    //  647 1297:iconst_2        
    //  648 1298:putfield        #111 <Field int GridBagConstraints.gridwidth>
        constraints.gridheight = 1;
    //  649 1301:aload_3         
    //  650 1302:iconst_1        
    //  651 1303:putfield        #114 <Field int GridBagConstraints.gridheight>
        combos.add(m_ColourCombo, constraints);
    //  652 1306:aload_1         
    //  653 1307:aload_0         
    //  654 1308:getfield        #260 <Field JComboBox m_ColourCombo>
    //  655 1311:aload_3         
    //  656 1312:invokevirtual   #123 <Method void JPanel.add(Component, Object)>
        constraints.gridx = 2;
    //  657 1315:aload_3         
    //  658 1316:iconst_2        
    //  659 1317:putfield        #101 <Field int GridBagConstraints.gridx>
        constraints.gridy = 1;
    //  660 1320:aload_3         
    //  661 1321:iconst_1        
    //  662 1322:putfield        #104 <Field int GridBagConstraints.gridy>
        constraints.weightx = 5D;
    //  663 1325:aload_3         
    //  664 1326:ldc2w           #115 <Double 5D>
    //  665 1329:putfield        #108 <Field double GridBagConstraints.weightx>
        constraints.gridwidth = 2;
    //  666 1332:aload_3         
    //  667 1333:iconst_2        
    //  668 1334:putfield        #111 <Field int GridBagConstraints.gridwidth>
        constraints.gridheight = 1;
    //  669 1337:aload_3         
    //  670 1338:iconst_1        
    //  671 1339:putfield        #114 <Field int GridBagConstraints.gridheight>
        combos.add(m_ShapeCombo, constraints);
    //  672 1342:aload_1         
    //  673 1343:aload_0         
    //  674 1344:getfield        #262 <Field JComboBox m_ShapeCombo>
    //  675 1347:aload_3         
    //  676 1348:invokevirtual   #123 <Method void JPanel.add(Component, Object)>
        JPanel mbts = new JPanel();
    //  677 1351:new             #78  <Class JPanel>
    //  678 1354:dup             
    //  679 1355:invokespecial   #363 <Method void JPanel()>
    //  680 1358:astore          4
        mbts.setLayout(new GridLayout(1, 4));
    //  681 1360:aload           4
    //  682 1362:new             #521 <Class GridLayout>
    //  683 1365:dup             
    //  684 1366:iconst_1        
    //  685 1367:iconst_4        
    //  686 1368:invokespecial   #522 <Method void GridLayout(int, int)>
    //  687 1371:invokevirtual   #516 <Method void JPanel.setLayout(java.awt.LayoutManager)>
        mbts.add(m_submit);
    //  688 1374:aload           4
    //  689 1376:aload_0         
    //  690 1377:getfield        #269 <Field JButton m_submit>
    //  691 1380:invokevirtual   #525 <Method Component JPanel.add(Component)>
    //  692 1383:pop             
        mbts.add(m_cancel);
    //  693 1384:aload           4
    //  694 1386:aload_0         
    //  695 1387:getfield        #273 <Field JButton m_cancel>
    //  696 1390:invokevirtual   #525 <Method Component JPanel.add(Component)>
    //  697 1393:pop             
        mbts.add(m_openBut);
    //  698 1394:aload           4
    //  699 1396:aload_0         
    //  700 1397:getfield        #277 <Field JButton m_openBut>
    //  701 1400:invokevirtual   #525 <Method Component JPanel.add(Component)>
    //  702 1403:pop             
        mbts.add(m_saveBut);
    //  703 1404:aload           4
    //  704 1406:aload_0         
    //  705 1407:getfield        #281 <Field JButton m_saveBut>
    //  706 1410:invokevirtual   #525 <Method Component JPanel.add(Component)>
    //  707 1413:pop             
        constraints.gridx = 0;
    //  708 1414:aload_3         
    //  709 1415:iconst_0        
    //  710 1416:putfield        #101 <Field int GridBagConstraints.gridx>
        constraints.gridy = 2;
    //  711 1419:aload_3         
    //  712 1420:iconst_2        
    //  713 1421:putfield        #104 <Field int GridBagConstraints.gridy>
        constraints.weightx = 5D;
    //  714 1424:aload_3         
    //  715 1425:ldc2w           #115 <Double 5D>
    //  716 1428:putfield        #108 <Field double GridBagConstraints.weightx>
        constraints.gridwidth = 2;
    //  717 1431:aload_3         
    //  718 1432:iconst_2        
    //  719 1433:putfield        #111 <Field int GridBagConstraints.gridwidth>
        constraints.gridheight = 1;
    //  720 1436:aload_3         
    //  721 1437:iconst_1        
    //  722 1438:putfield        #114 <Field int GridBagConstraints.gridheight>
        combos.add(mbts, constraints);
    //  723 1441:aload_1         
    //  724 1442:aload           4
    //  725 1444:aload_3         
    //  726 1445:invokevirtual   #123 <Method void JPanel.add(Component, Object)>
        constraints.gridx = 2;
    //  727 1448:aload_3         
    //  728 1449:iconst_2        
    //  729 1450:putfield        #101 <Field int GridBagConstraints.gridx>
        constraints.gridy = 2;
    //  730 1453:aload_3         
    //  731 1454:iconst_2        
    //  732 1455:putfield        #104 <Field int GridBagConstraints.gridy>
        constraints.weightx = 5D;
    //  733 1458:aload_3         
    //  734 1459:ldc2w           #115 <Double 5D>
    //  735 1462:putfield        #108 <Field double GridBagConstraints.weightx>
        constraints.gridwidth = 1;
    //  736 1465:aload_3         
    //  737 1466:iconst_1        
    //  738 1467:putfield        #111 <Field int GridBagConstraints.gridwidth>
        constraints.gridheight = 1;
    //  739 1470:aload_3         
    //  740 1471:iconst_1        
    //  741 1472:putfield        #114 <Field int GridBagConstraints.gridheight>
        constraints.insets = new Insets(10, 0, 0, 5);
    //  742 1475:aload_3         
    //  743 1476:new             #90  <Class Insets>
    //  744 1479:dup             
    //  745 1480:bipush          10
    //  746 1482:iconst_0        
    //  747 1483:iconst_0        
    //  748 1484:iconst_5        
    //  749 1485:invokespecial   #93  <Method void Insets(int, int, int, int)>
    //  750 1488:putfield        #97  <Field Insets GridBagConstraints.insets>
        combos.add(m_JitterLab, constraints);
    //  751 1491:aload_1         
    //  752 1492:aload_0         
    //  753 1493:getfield        #330 <Field JLabel m_JitterLab>
    //  754 1496:aload_3         
    //  755 1497:invokevirtual   #123 <Method void JPanel.add(Component, Object)>
        constraints.gridx = 3;
    //  756 1500:aload_3         
    //  757 1501:iconst_3        
    //  758 1502:putfield        #101 <Field int GridBagConstraints.gridx>
        constraints.gridy = 2;
    //  759 1505:aload_3         
    //  760 1506:iconst_2        
    //  761 1507:putfield        #104 <Field int GridBagConstraints.gridy>
        constraints.weightx = 5D;
    //  762 1510:aload_3         
    //  763 1511:ldc2w           #115 <Double 5D>
    //  764 1514:putfield        #108 <Field double GridBagConstraints.weightx>
        constraints.insets = new Insets(10, 0, 0, 0);
    //  765 1517:aload_3         
    //  766 1518:new             #90  <Class Insets>
    //  767 1521:dup             
    //  768 1522:bipush          10
    //  769 1524:iconst_0        
    //  770 1525:iconst_0        
    //  771 1526:iconst_0        
    //  772 1527:invokespecial   #93  <Method void Insets(int, int, int, int)>
    //  773 1530:putfield        #97  <Field Insets GridBagConstraints.insets>
        combos.add(m_Jitter, constraints);
    //  774 1533:aload_1         
    //  775 1534:aload_0         
    //  776 1535:getfield        #335 <Field JSlider m_Jitter>
    //  777 1538:aload_3         
    //  778 1539:invokevirtual   #123 <Method void JPanel.add(Component, Object)>
        m_classSurround = new JPanel();
    //  779 1542:aload_0         
    //  780 1543:new             #78  <Class JPanel>
    //  781 1546:dup             
    //  782 1547:invokespecial   #363 <Method void JPanel()>
    //  783 1550:putfield        #136 <Field JPanel m_classSurround>
        m_classSurround.setBorder(BorderFactory.createTitledBorder("Class colour"));
    //  784 1553:aload_0         
    //  785 1554:getfield        #136 <Field JPanel m_classSurround>
    //  786 1557:ldc2            #527 <String "Class colour">
    //  787 1560:invokestatic    #531 <Method javax.swing.border.TitledBorder BorderFactory.createTitledBorder(String)>
    //  788 1563:invokevirtual   #512 <Method void JPanel.setBorder(javax.swing.border.Border)>
        m_classSurround.setLayout(new BorderLayout());
    //  789 1566:aload_0         
    //  790 1567:getfield        #136 <Field JPanel m_classSurround>
    //  791 1570:new             #533 <Class BorderLayout>
    //  792 1573:dup             
    //  793 1574:invokespecial   #534 <Method void BorderLayout()>
    //  794 1577:invokevirtual   #516 <Method void JPanel.setLayout(java.awt.LayoutManager)>
        m_classPanel.setBorder(BorderFactory.createEmptyBorder(15, 10, 10, 10));
    //  795 1580:aload_0         
    //  796 1581:getfield        #374 <Field ClassPanel m_classPanel>
    //  797 1584:bipush          15
    //  798 1586:bipush          10
    //  799 1588:bipush          10
    //  800 1590:bipush          10
    //  801 1592:invokestatic    #508 <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
    //  802 1595:invokevirtual   #535 <Method void ClassPanel.setBorder(javax.swing.border.Border)>
        m_classSurround.add(m_classPanel, "Center");
    //  803 1598:aload_0         
    //  804 1599:getfield        #136 <Field JPanel m_classSurround>
    //  805 1602:aload_0         
    //  806 1603:getfield        #374 <Field ClassPanel m_classPanel>
    //  807 1606:ldc2            #537 <String "Center">
    //  808 1609:invokevirtual   #123 <Method void JPanel.add(Component, Object)>
        GridBagLayout gb2 = new GridBagLayout();
    //  809 1612:new             #498 <Class GridBagLayout>
    //  810 1615:dup             
    //  811 1616:invokespecial   #499 <Method void GridBagLayout()>
    //  812 1619:astore          5
        m_plotSurround.setBorder(BorderFactory.createTitledBorder("Plot"));
    //  813 1621:aload_0         
    //  814 1622:getfield        #74  <Field JPanel m_plotSurround>
    //  815 1625:ldc2            #539 <String "Plot">
    //  816 1628:invokestatic    #531 <Method javax.swing.border.TitledBorder BorderFactory.createTitledBorder(String)>
    //  817 1631:invokevirtual   #512 <Method void JPanel.setBorder(javax.swing.border.Border)>
        m_plotSurround.setLayout(gb2);
    //  818 1634:aload_0         
    //  819 1635:getfield        #74  <Field JPanel m_plotSurround>
    //  820 1638:aload           5
    //  821 1640:invokevirtual   #516 <Method void JPanel.setLayout(java.awt.LayoutManager)>
        constraints.fill = 1;
    //  822 1643:aload_3         
    //  823 1644:iconst_1        
    //  824 1645:putfield        #519 <Field int GridBagConstraints.fill>
        constraints.insets = new Insets(0, 0, 0, 10);
    //  825 1648:aload_3         
    //  826 1649:new             #90  <Class Insets>
    //  827 1652:dup             
    //  828 1653:iconst_0        
    //  829 1654:iconst_0        
    //  830 1655:iconst_0        
    //  831 1656:bipush          10
    //  832 1658:invokespecial   #93  <Method void Insets(int, int, int, int)>
    //  833 1661:putfield        #97  <Field Insets GridBagConstraints.insets>
        constraints.gridx = 0;
    //  834 1664:aload_3         
    //  835 1665:iconst_0        
    //  836 1666:putfield        #101 <Field int GridBagConstraints.gridx>
        constraints.gridy = 0;
    //  837 1669:aload_3         
    //  838 1670:iconst_0        
    //  839 1671:putfield        #104 <Field int GridBagConstraints.gridy>
        constraints.weightx = 3D;
    //  840 1674:aload_3         
    //  841 1675:ldc2w           #540 <Double 3D>
    //  842 1678:putfield        #108 <Field double GridBagConstraints.weightx>
        constraints.gridwidth = 4;
    //  843 1681:aload_3         
    //  844 1682:iconst_4        
    //  845 1683:putfield        #111 <Field int GridBagConstraints.gridwidth>
        constraints.gridheight = 1;
    //  846 1686:aload_3         
    //  847 1687:iconst_1        
    //  848 1688:putfield        #114 <Field int GridBagConstraints.gridheight>
        constraints.weighty = 5D;
    //  849 1691:aload_3         
    //  850 1692:ldc2w           #115 <Double 5D>
    //  851 1695:putfield        #119 <Field double GridBagConstraints.weighty>
        m_plotSurround.add(m_plot, constraints);
    //  852 1698:aload_0         
    //  853 1699:getfield        #74  <Field JPanel m_plotSurround>
    //  854 1702:aload_0         
    //  855 1703:getfield        #342 <Field VisualizePanel$PlotPanel m_plot>
    //  856 1706:aload_3         
    //  857 1707:invokevirtual   #123 <Method void JPanel.add(Component, Object)>
        if(m_showAttBars)
    //* 858 1710:aload_0         
    //* 859 1711:getfield        #72  <Field boolean m_showAttBars>
    //* 860 1714:ifeq            1776
        {
            constraints.insets = new Insets(0, 0, 0, 0);
    //  861 1717:aload_3         
    //  862 1718:new             #90  <Class Insets>
    //  863 1721:dup             
    //  864 1722:iconst_0        
    //  865 1723:iconst_0        
    //  866 1724:iconst_0        
    //  867 1725:iconst_0        
    //  868 1726:invokespecial   #93  <Method void Insets(int, int, int, int)>
    //  869 1729:putfield        #97  <Field Insets GridBagConstraints.insets>
            constraints.gridx = 4;
    //  870 1732:aload_3         
    //  871 1733:iconst_4        
    //  872 1734:putfield        #101 <Field int GridBagConstraints.gridx>
            constraints.gridy = 0;
    //  873 1737:aload_3         
    //  874 1738:iconst_0        
    //  875 1739:putfield        #104 <Field int GridBagConstraints.gridy>
            constraints.weightx = 1.0D;
    //  876 1742:aload_3         
    //  877 1743:dconst_1        
    //  878 1744:putfield        #108 <Field double GridBagConstraints.weightx>
            constraints.gridwidth = 1;
    //  879 1747:aload_3         
    //  880 1748:iconst_1        
    //  881 1749:putfield        #111 <Field int GridBagConstraints.gridwidth>
            constraints.gridheight = 1;
    //  882 1752:aload_3         
    //  883 1753:iconst_1        
    //  884 1754:putfield        #114 <Field int GridBagConstraints.gridheight>
            constraints.weighty = 5D;
    //  885 1757:aload_3         
    //  886 1758:ldc2w           #115 <Double 5D>
    //  887 1761:putfield        #119 <Field double GridBagConstraints.weighty>
            m_plotSurround.add(m_attrib, constraints);
    //  888 1764:aload_0         
    //  889 1765:getfield        #74  <Field JPanel m_plotSurround>
    //  890 1768:aload_0         
    //  891 1769:getfield        #76  <Field AttributePanel m_attrib>
    //  892 1772:aload_3         
    //  893 1773:invokevirtual   #123 <Method void JPanel.add(Component, Object)>
        }
        setLayout(new BorderLayout());
    //  894 1776:aload_0         
    //  895 1777:new             #533 <Class BorderLayout>
    //  896 1780:dup             
    //  897 1781:invokespecial   #534 <Method void BorderLayout()>
    //  898 1784:invokevirtual   #542 <Method void setLayout(java.awt.LayoutManager)>
        add(combos, "North");
    //  899 1787:aload_0         
    //  900 1788:aload_1         
    //  901 1789:ldc2            #544 <String "North">
    //  902 1792:invokevirtual   #140 <Method void add(Component, Object)>
        add(m_plotSurround, "Center");
    //  903 1795:aload_0         
    //  904 1796:aload_0         
    //  905 1797:getfield        #74  <Field JPanel m_plotSurround>
    //  906 1800:ldc2            #537 <String "Center">
    //  907 1803:invokevirtual   #140 <Method void add(Component, Object)>
        add(m_classSurround, "South");
    //  908 1806:aload_0         
    //  909 1807:aload_0         
    //  910 1808:getfield        #136 <Field JPanel m_classSurround>
    //  911 1811:ldc1            #139 <String "South">
    //  912 1813:invokevirtual   #140 <Method void add(Component, Object)>
        String SNames[] = new String[4];
    //  913 1816:iconst_4        
    //  914 1817:anewarray       String[]
    //  915 1820:astore          6
        SNames[0] = "Select Instance";
    //  916 1822:aload           6
    //  917 1824:iconst_0        
    //  918 1825:ldc2            #546 <String "Select Instance">
    //  919 1828:aastore         
        SNames[1] = "Rectangle";
    //  920 1829:aload           6
    //  921 1831:iconst_1        
    //  922 1832:ldc2            #548 <String "Rectangle">
    //  923 1835:aastore         
        SNames[2] = "Polygon";
    //  924 1836:aload           6
    //  925 1838:iconst_2        
    //  926 1839:ldc2            #550 <String "Polygon">
    //  927 1842:aastore         
        SNames[3] = "Polyline";
    //  928 1843:aload           6
    //  929 1845:iconst_3        
    //  930 1846:ldc2            #552 <String "Polyline">
    //  931 1849:aastore         
        m_ShapeCombo.setModel(new DefaultComboBoxModel(SNames));
    //  932 1850:aload_0         
    //  933 1851:getfield        #262 <Field JComboBox m_ShapeCombo>
    //  934 1854:new             #554 <Class DefaultComboBoxModel>
    //  935 1857:dup             
    //  936 1858:aload           6
    //  937 1860:invokespecial   #557 <Method void DefaultComboBoxModel(Object[])>
    //  938 1863:invokevirtual   #561 <Method void JComboBox.setModel(javax.swing.ComboBoxModel)>
        m_ShapeCombo.setEnabled(true);
    //  939 1866:aload_0         
    //  940 1867:getfield        #262 <Field JComboBox m_ShapeCombo>
    //  941 1870:iconst_1        
    //  942 1871:invokevirtual   #408 <Method void JComboBox.setEnabled(boolean)>
    //  943 1874:return          
    }

    protected void openVisibleInstances(Instances insts)
        throws Exception
    {
        PlotData2D tempd = new PlotData2D(insts);
    //    0    0:new             #581 <Class PlotData2D>
    //    1    3:dup             
    //    2    4:aload_1         
    //    3    5:invokespecial   #583 <Method void PlotData2D(Instances)>
    //    4    8:astore_2        
        tempd.setPlotName(insts.relationName());
    //    5    9:aload_2         
    //    6   10:aload_1         
    //    7   11:invokevirtual   #587 <Method String Instances.relationName()>
    //    8   14:invokevirtual   #590 <Method void PlotData2D.setPlotName(String)>
        m_plot.m_plot2D.removeAllPlots();
    //    9   17:aload_0         
    //   10   18:getfield        #342 <Field VisualizePanel$PlotPanel m_plot>
    //   11   21:getfield        #348 <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
    //   12   24:invokevirtual   #593 <Method void Plot2D.removeAllPlots()>
        addPlot(tempd);
    //   13   27:aload_0         
    //   14   28:aload_2         
    //   15   29:invokevirtual   #597 <Method void addPlot(PlotData2D)>
        for(Component parent = getParent(); parent != null; parent = parent.getParent())
    //*  16   32:aload_0         
    //*  17   33:invokevirtual   #601 <Method Container getParent()>
    //*  18   36:astore_3        
    //*  19   37:goto            88
        {
            if(!(parent instanceof JFrame))
                continue;
    //   20   40:aload_3         
    //   21   41:instanceof      #603 <Class JFrame>
    //   22   44:ifeq            83
            ((JFrame)parent).setTitle((new StringBuilder("Weka Classifier Visualize: ")).append(insts.relationName()).append(" (display only)").toString());
    //   23   47:aload_3         
    //   24   48:checkcast       #603 <Class JFrame>
    //   25   51:new             #169 <Class StringBuilder>
    //   26   54:dup             
    //   27   55:ldc2            #605 <String "Weka Classifier Visualize: ">
    //   28   58:invokespecial   #177 <Method void StringBuilder(String)>
    //   29   61:aload_1         
    //   30   62:invokevirtual   #587 <Method String Instances.relationName()>
    //   31   65:invokevirtual   #183 <Method StringBuilder StringBuilder.append(String)>
    //   32   68:ldc2            #607 <String " (display only)">
    //   33   71:invokevirtual   #183 <Method StringBuilder StringBuilder.append(String)>
    //   34   74:invokevirtual   #186 <Method String StringBuilder.toString()>
    //   35   77:invokevirtual   #610 <Method void JFrame.setTitle(String)>
            break;
    //   36   80:goto            92
        }

    //   37   83:aload_3         
    //   38   84:invokevirtual   #613 <Method Container Component.getParent()>
    //   39   87:astore_3        
    //   40   88:aload_3         
    //   41   89:ifnonnull       40
    //   42   92:return          
    }

    protected void openVisibleInstances()
    {
        try
        {
            int returnVal = m_FileChooser.showOpenDialog(this);
    //    0    0:aload_0         
    //    1    1:getfield        #310 <Field JFileChooser m_FileChooser>
    //    2    4:aload_0         
    //    3    5:invokevirtual   #623 <Method int JFileChooser.showOpenDialog(Component)>
    //    4    8:istore_1        
            if(returnVal == 0)
    //*   5    9:iload_1         
    //*   6   10:ifne            134
            {
                File sFile = m_FileChooser.getSelectedFile();
    //    7   13:aload_0         
    //    8   14:getfield        #310 <Field JFileChooser m_FileChooser>
    //    9   17:invokevirtual   #627 <Method File JFileChooser.getSelectedFile()>
    //   10   20:astore_2        
                if(!sFile.getName().toLowerCase().endsWith(".ass"))
    //*  11   21:aload_2         
    //*  12   22:invokevirtual   #628 <Method String File.getName()>
    //*  13   25:invokevirtual   #631 <Method String String.toLowerCase()>
    //*  14   28:ldc2            #314 <String ".ass">
    //*  15   31:invokevirtual   #635 <Method boolean String.endsWith(String)>
    //*  16   34:ifne            72
                    sFile = new File(sFile.getParent(), (new StringBuilder(String.valueOf(sFile.getName()))).append(".ass").toString());
    //   17   37:new             #299 <Class File>
    //   18   40:dup             
    //   19   41:aload_2         
    //   20   42:invokevirtual   #637 <Method String File.getParent()>
    //   21   45:new             #169 <Class StringBuilder>
    //   22   48:dup             
    //   23   49:aload_2         
    //   24   50:invokevirtual   #628 <Method String File.getName()>
    //   25   53:invokestatic    #175 <Method String String.valueOf(Object)>
    //   26   56:invokespecial   #177 <Method void StringBuilder(String)>
    //   27   59:ldc2            #314 <String ".ass">
    //   28   62:invokevirtual   #183 <Method StringBuilder StringBuilder.append(String)>
    //   29   65:invokevirtual   #186 <Method String StringBuilder.toString()>
    //   30   68:invokespecial   #638 <Method void File(String, String)>
    //   31   71:astore_2        
                File selected = sFile;
    //   32   72:aload_2         
    //   33   73:astore_3        
                Instances insts = new Instances(new BufferedReader(new FileReader(selected)));
    //   34   74:new             #585 <Class Instances>
    //   35   77:dup             
    //   36   78:new             #640 <Class BufferedReader>
    //   37   81:dup             
    //   38   82:new             #642 <Class FileReader>
    //   39   85:dup             
    //   40   86:aload_3         
    //   41   87:invokespecial   #643 <Method void FileReader(File)>
    //   42   90:invokespecial   #646 <Method void BufferedReader(java.io.Reader)>
    //   43   93:invokespecial   #647 <Method void Instances(java.io.Reader)>
    //   44   96:astore          4
                openVisibleInstances(insts);
    //   45   98:aload_0         
    //   46   99:aload           4
    //   47  101:invokevirtual   #649 <Method void openVisibleInstances(Instances)>
            }
        }
    //*  48  104:goto            134
        catch(Exception ex)
    //*  49  107:astore_1        
        {
            ex.printStackTrace();
    //   50  108:aload_1         
    //   51  109:invokevirtual   #652 <Method void Exception.printStackTrace()>
            m_plot.m_plot2D.removeAllPlots();
    //   52  112:aload_0         
    //   53  113:getfield        #342 <Field VisualizePanel$PlotPanel m_plot>
    //   54  116:getfield        #348 <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
    //   55  119:invokevirtual   #593 <Method void Plot2D.removeAllPlots()>
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error loading file...", 0);
    //   56  122:aload_0         
    //   57  123:aload_1         
    //   58  124:invokevirtual   #655 <Method String Exception.getMessage()>
    //   59  127:ldc2            #657 <String "Error loading file...">
    //   60  130:iconst_0        
    //   61  131:invokestatic    #663 <Method void JOptionPane.showMessageDialog(Component, Object, String, int)>
        }
    //   62  134:return          
    }

    private void saveVisibleInstances()
    {
        FastVector plots = m_plot.m_plot2D.getPlots();
    //    0    0:aload_0         
    //    1    1:getfield        #342 <Field VisualizePanel$PlotPanel m_plot>
    //    2    4:getfield        #348 <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
    //    3    7:invokevirtual   #674 <Method FastVector Plot2D.getPlots()>
    //    4   10:astore_1        
        if(plots != null)
    //*   5   11:aload_1         
    //*   6   12:ifnull          227
        {
            PlotData2D master = (PlotData2D)plots.elementAt(0);
    //    7   15:aload_1         
    //    8   16:iconst_0        
    //    9   17:invokevirtual   #678 <Method Object FastVector.elementAt(int)>
    //   10   20:checkcast       #581 <Class PlotData2D>
    //   11   23:astore_2        
            Instances saveInsts = new Instances(master.getPlotInstances());
    //   12   24:new             #585 <Class Instances>
    //   13   27:dup             
    //   14   28:aload_2         
    //   15   29:invokevirtual   #682 <Method Instances PlotData2D.getPlotInstances()>
    //   16   32:invokespecial   #683 <Method void Instances(Instances)>
    //   17   35:astore_3        
            for(int i = 1; i < plots.size(); i++)
    //*  18   36:iconst_1        
    //*  19   37:istore          4
    //*  20   39:goto            93
            {
                PlotData2D temp = (PlotData2D)plots.elementAt(i);
    //   21   42:aload_1         
    //   22   43:iload           4
    //   23   45:invokevirtual   #678 <Method Object FastVector.elementAt(int)>
    //   24   48:checkcast       #581 <Class PlotData2D>
    //   25   51:astore          5
                Instances addInsts = temp.getPlotInstances();
    //   26   53:aload           5
    //   27   55:invokevirtual   #682 <Method Instances PlotData2D.getPlotInstances()>
    //   28   58:astore          6
                for(int j = 0; j < addInsts.numInstances(); j++)
    //*  29   60:iconst_0        
    //*  30   61:istore          7
    //*  31   63:goto            80
                    saveInsts.add(addInsts.instance(j));
    //   32   66:aload_3         
    //   33   67:aload           6
    //   34   69:iload           7
    //   35   71:invokevirtual   #687 <Method Instance Instances.instance(int)>
    //   36   74:invokevirtual   #690 <Method void Instances.add(Instance)>

    //   37   77:iinc            7  1
    //   38   80:iload           7
    //   39   82:aload           6
    //   40   84:invokevirtual   #693 <Method int Instances.numInstances()>
    //   41   87:icmplt          66
            }

    //   42   90:iinc            4  1
    //   43   93:iload           4
    //   44   95:aload_1         
    //   45   96:invokevirtual   #440 <Method int FastVector.size()>
    //   46   99:icmplt          42
            try
            {
                int returnVal = m_FileChooser.showSaveDialog(this);
    //   47  102:aload_0         
    //   48  103:getfield        #310 <Field JFileChooser m_FileChooser>
    //   49  106:aload_0         
    //   50  107:invokevirtual   #696 <Method int JFileChooser.showSaveDialog(Component)>
    //   51  110:istore          4
                if(returnVal == 0)
    //*  52  112:iload           4
    //*  53  114:ifne            227
                {
                    File sFile = m_FileChooser.getSelectedFile();
    //   54  117:aload_0         
    //   55  118:getfield        #310 <Field JFileChooser m_FileChooser>
    //   56  121:invokevirtual   #627 <Method File JFileChooser.getSelectedFile()>
    //   57  124:astore          5
                    if(!sFile.getName().toLowerCase().endsWith(".ass"))
    //*  58  126:aload           5
    //*  59  128:invokevirtual   #628 <Method String File.getName()>
    //*  60  131:invokevirtual   #631 <Method String String.toLowerCase()>
    //*  61  134:ldc2            #314 <String ".ass">
    //*  62  137:invokevirtual   #635 <Method boolean String.endsWith(String)>
    //*  63  140:ifne            181
                        sFile = new File(sFile.getParent(), (new StringBuilder(String.valueOf(sFile.getName()))).append(".ass").toString());
    //   64  143:new             #299 <Class File>
    //   65  146:dup             
    //   66  147:aload           5
    //   67  149:invokevirtual   #637 <Method String File.getParent()>
    //   68  152:new             #169 <Class StringBuilder>
    //   69  155:dup             
    //   70  156:aload           5
    //   71  158:invokevirtual   #628 <Method String File.getName()>
    //   72  161:invokestatic    #175 <Method String String.valueOf(Object)>
    //   73  164:invokespecial   #177 <Method void StringBuilder(String)>
    //   74  167:ldc2            #314 <String ".ass">
    //   75  170:invokevirtual   #183 <Method StringBuilder StringBuilder.append(String)>
    //   76  173:invokevirtual   #186 <Method String StringBuilder.toString()>
    //   77  176:invokespecial   #638 <Method void File(String, String)>
    //   78  179:astore          5
                    File selected = sFile;
    //   79  181:aload           5
    //   80  183:astore          6
                    Writer w = new BufferedWriter(new FileWriter(selected));
    //   81  185:new             #698 <Class BufferedWriter>
    //   82  188:dup             
    //   83  189:new             #700 <Class FileWriter>
    //   84  192:dup             
    //   85  193:aload           6
    //   86  195:invokespecial   #701 <Method void FileWriter(File)>
    //   87  198:invokespecial   #704 <Method void BufferedWriter(Writer)>
    //   88  201:astore          7
                    w.write(saveInsts.toString());
    //   89  203:aload           7
    //   90  205:aload_3         
    //   91  206:invokevirtual   #705 <Method String Instances.toString()>
    //   92  209:invokevirtual   #710 <Method void Writer.write(String)>
                    w.close();
    //   93  212:aload           7
    //   94  214:invokevirtual   #713 <Method void Writer.close()>
                }
            }
    //*  95  217:goto            227
            catch(Exception ex)
    //*  96  220:astore          4
            {
                ex.printStackTrace();
    //   97  222:aload           4
    //   98  224:invokevirtual   #652 <Method void Exception.printStackTrace()>
            }
        }
    //   99  227:return          
    }

    public void setColourIndex(int index)
    {
        if(index >= 0)
    //*   0    0:iload_1         
    //*   1    1:iflt            15
            m_ColourCombo.setSelectedIndex(index);
    //    2    4:aload_0         
    //    3    5:getfield        #260 <Field JComboBox m_ColourCombo>
    //    4    8:iload_1         
    //    5    9:invokevirtual   #724 <Method void JComboBox.setSelectedIndex(int)>
        else
    //*   6   12:goto            23
            m_ColourCombo.setSelectedIndex(0);
    //    7   15:aload_0         
    //    8   16:getfield        #260 <Field JComboBox m_ColourCombo>
    //    9   19:iconst_0        
    //   10   20:invokevirtual   #724 <Method void JComboBox.setSelectedIndex(int)>
        m_ColourCombo.setEnabled(false);
    //   11   23:aload_0         
    //   12   24:getfield        #260 <Field JComboBox m_ColourCombo>
    //   13   27:iconst_0        
    //   14   28:invokevirtual   #408 <Method void JComboBox.setEnabled(boolean)>
    //   15   31:return          
    }

    public void setXIndex(int index)
        throws Exception
    {
        if(index >= 0 && index < m_XCombo.getItemCount())
    //*   0    0:iload_1         
    //*   1    1:iflt            26
    //*   2    4:iload_1         
    //*   3    5:aload_0         
    //*   4    6:getfield        #256 <Field JComboBox m_XCombo>
    //*   5    9:invokevirtual   #729 <Method int JComboBox.getItemCount()>
    //*   6   12:icmpge          26
            m_XCombo.setSelectedIndex(index);
    //    7   15:aload_0         
    //    8   16:getfield        #256 <Field JComboBox m_XCombo>
    //    9   19:iload_1         
    //   10   20:invokevirtual   #724 <Method void JComboBox.setSelectedIndex(int)>
        else
    //*  11   23:goto            37
            throw new Exception("x index is out of range!");
    //   12   26:new             #579 <Class Exception>
    //   13   29:dup             
    //   14   30:ldc2            #731 <String "x index is out of range!">
    //   15   33:invokespecial   #732 <Method void Exception(String)>
    //   16   36:athrow          
    //   17   37:return          
    }

    public int getXIndex()
    {
        return m_XCombo.getSelectedIndex();
    //    0    0:aload_0         
    //    1    1:getfield        #256 <Field JComboBox m_XCombo>
    //    2    4:invokevirtual   #736 <Method int JComboBox.getSelectedIndex()>
    //    3    7:ireturn         
    }

    public void setYIndex(int index)
        throws Exception
    {
        if(index >= 0 && index < m_YCombo.getItemCount())
    //*   0    0:iload_1         
    //*   1    1:iflt            26
    //*   2    4:iload_1         
    //*   3    5:aload_0         
    //*   4    6:getfield        #258 <Field JComboBox m_YCombo>
    //*   5    9:invokevirtual   #729 <Method int JComboBox.getItemCount()>
    //*   6   12:icmpge          26
            m_YCombo.setSelectedIndex(index);
    //    7   15:aload_0         
    //    8   16:getfield        #258 <Field JComboBox m_YCombo>
    //    9   19:iload_1         
    //   10   20:invokevirtual   #724 <Method void JComboBox.setSelectedIndex(int)>
        else
    //*  11   23:goto            37
            throw new Exception("y index is out of range!");
    //   12   26:new             #579 <Class Exception>
    //   13   29:dup             
    //   14   30:ldc2            #739 <String "y index is out of range!">
    //   15   33:invokespecial   #732 <Method void Exception(String)>
    //   16   36:athrow          
    //   17   37:return          
    }

    public int getYIndex()
    {
        return m_YCombo.getSelectedIndex();
    //    0    0:aload_0         
    //    1    1:getfield        #258 <Field JComboBox m_YCombo>
    //    2    4:invokevirtual   #736 <Method int JComboBox.getSelectedIndex()>
    //    3    7:ireturn         
    }

    public int getCIndex()
    {
        return m_ColourCombo.getSelectedIndex();
    //    0    0:aload_0         
    //    1    1:getfield        #260 <Field JComboBox m_ColourCombo>
    //    2    4:invokevirtual   #736 <Method int JComboBox.getSelectedIndex()>
    //    3    7:ireturn         
    }

    public int getSIndex()
    {
        return m_ShapeCombo.getSelectedIndex();
    //    0    0:aload_0         
    //    1    1:getfield        #262 <Field JComboBox m_ShapeCombo>
    //    2    4:invokevirtual   #736 <Method int JComboBox.getSelectedIndex()>
    //    3    7:ireturn         
    }

    public void setSIndex(int index)
        throws Exception
    {
        if(index >= 0 && index < m_ShapeCombo.getItemCount())
    //*   0    0:iload_1         
    //*   1    1:iflt            26
    //*   2    4:iload_1         
    //*   3    5:aload_0         
    //*   4    6:getfield        #262 <Field JComboBox m_ShapeCombo>
    //*   5    9:invokevirtual   #729 <Method int JComboBox.getItemCount()>
    //*   6   12:icmpge          26
            m_ShapeCombo.setSelectedIndex(index);
    //    7   15:aload_0         
    //    8   16:getfield        #262 <Field JComboBox m_ShapeCombo>
    //    9   19:iload_1         
    //   10   20:invokevirtual   #724 <Method void JComboBox.setSelectedIndex(int)>
        else
    //*  11   23:goto            37
            throw new Exception("s index is out of range!");
    //   12   26:new             #579 <Class Exception>
    //   13   29:dup             
    //   14   30:ldc2            #745 <String "s index is out of range!">
    //   15   33:invokespecial   #732 <Method void Exception(String)>
    //   16   36:athrow          
    //   17   37:return          
    }

    public void addActionListener(ActionListener act)
    {
        listener = act;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #365 <Field ActionListener listener>
    //    3    5:return          
    }

    public void setName(String plotName)
    {
        m_plotName = plotName;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #369 <Field String m_plotName>
    //    3    5:return          
    }

    public String getName()
    {
        return m_plotName;
    //    0    0:aload_0         
    //    1    1:getfield        #369 <Field String m_plotName>
    //    2    4:areturn         
    }

    public Instances getInstances()
    {
        return m_plot.m_plotInstances;
    //    0    0:aload_0         
    //    1    1:getfield        #342 <Field VisualizePanel$PlotPanel m_plot>
    //    2    4:getfield        #752 <Field Instances VisualizePanel$PlotPanel.m_plotInstances>
    //    3    7:areturn         
    }

    protected void newColorAttribute(int a, Instances i)
    {
        if(i.attribute(a).isNominal())
    //*   0    0:aload_2         
    //*   1    1:iload_1         
    //*   2    2:invokevirtual   #758 <Method Attribute Instances.attribute(int)>
    //*   3    5:invokevirtual   #763 <Method boolean Attribute.isNominal()>
    //*   4    8:ifeq            125
        {
            for(int noa = m_colorList.size(); noa < i.attribute(a).numValues(); noa++)
    //*   5   11:aload_0         
    //*   6   12:getfield        #437 <Field FastVector m_colorList>
    //*   7   15:invokevirtual   #440 <Method int FastVector.size()>
    //*   8   18:istore_3        
    //*   9   19:goto            80
            {
                Color pc = m_DefaultColors[noa % 10];
    //   10   22:aload_0         
    //   11   23:getfield        #251 <Field Color[] m_DefaultColors>
    //   12   26:iload_3         
    //   13   27:bipush          10
    //   14   29:irem            
    //   15   30:aaload          
    //   16   31:astore          4
                int ija = noa / 10;
    //   17   33:iload_3         
    //   18   34:bipush          10
    //   19   36:idiv            
    //   20   37:istore          5
                ija *= 2;
    //   21   39:iload           5
    //   22   41:iconst_2        
    //   23   42:imul            
    //   24   43:istore          5
                for(int j = 0; j < ija; j++)
    //*  25   45:iconst_0        
    //*  26   46:istore          6
    //*  27   48:goto            61
                    pc = pc.brighter();
    //   28   51:aload           4
    //   29   53:invokevirtual   #766 <Method Color Color.brighter()>
    //   30   56:astore          4

    //   31   58:iinc            6  1
    //   32   61:iload           6
    //   33   63:iload           5
    //   34   65:icmplt          51
                m_colorList.addElement(pc);
    //   35   68:aload_0         
    //   36   69:getfield        #437 <Field FastVector m_colorList>
    //   37   72:aload           4
    //   38   74:invokevirtual   #447 <Method void FastVector.addElement(Object)>
            }

    //   39   77:iinc            3  1
    //   40   80:iload_3         
    //   41   81:aload_2         
    //   42   82:iload_1         
    //   43   83:invokevirtual   #758 <Method Attribute Instances.attribute(int)>
    //   44   86:invokevirtual   #769 <Method int Attribute.numValues()>
    //   45   89:icmplt          22
            m_plot.setColours(m_colorList);
    //   46   92:aload_0         
    //   47   93:getfield        #342 <Field VisualizePanel$PlotPanel m_plot>
    //   48   96:aload_0         
    //   49   97:getfield        #437 <Field FastVector m_colorList>
    //   50  100:invokevirtual   #451 <Method void VisualizePanel$PlotPanel.setColours(FastVector)>
            m_attrib.setColours(m_colorList);
    //   51  103:aload_0         
    //   52  104:getfield        #76  <Field AttributePanel m_attrib>
    //   53  107:aload_0         
    //   54  108:getfield        #437 <Field FastVector m_colorList>
    //   55  111:invokevirtual   #453 <Method void AttributePanel.setColours(FastVector)>
            m_classPanel.setColours(m_colorList);
    //   56  114:aload_0         
    //   57  115:getfield        #374 <Field ClassPanel m_classPanel>
    //   58  118:aload_0         
    //   59  119:getfield        #437 <Field FastVector m_colorList>
    //   60  122:invokevirtual   #452 <Method void ClassPanel.setColours(FastVector)>
        }
    //   61  125:return          
    }

    public void setShapes(FastVector l)
    {
        m_plot.setShapes(l);
    //    0    0:aload_0         
    //    1    1:getfield        #342 <Field VisualizePanel$PlotPanel m_plot>
    //    2    4:aload_1         
    //    3    5:invokevirtual   #773 <Method void VisualizePanel$PlotPanel.setShapes(FastVector)>
    //    4    8:return          
    }

    public void setInstances(Instances inst)
    {
        if(inst.numAttributes() > 0 && inst.numInstances() > 0)
    //*   0    0:aload_1         
    //*   1    1:invokevirtual   #778 <Method int Instances.numAttributes()>
    //*   2    4:ifle            25
    //*   3    7:aload_1         
    //*   4    8:invokevirtual   #693 <Method int Instances.numInstances()>
    //*   5   11:ifle            25
            newColorAttribute(inst.numAttributes() - 1, inst);
    //    6   14:aload_0         
    //    7   15:aload_1         
    //    8   16:invokevirtual   #778 <Method int Instances.numAttributes()>
    //    9   19:iconst_1        
    //   10   20:isub            
    //   11   21:aload_1         
    //   12   22:invokevirtual   #780 <Method void newColorAttribute(int, Instances)>
        PlotData2D temp = new PlotData2D(inst);
    //   13   25:new             #581 <Class PlotData2D>
    //   14   28:dup             
    //   15   29:aload_1         
    //   16   30:invokespecial   #583 <Method void PlotData2D(Instances)>
    //   17   33:astore_2        
        temp.setPlotName(inst.relationName());
    //   18   34:aload_2         
    //   19   35:aload_1         
    //   20   36:invokevirtual   #587 <Method String Instances.relationName()>
    //   21   39:invokevirtual   #590 <Method void PlotData2D.setPlotName(String)>
        try
        {
            setMasterPlot(temp);
    //   22   42:aload_0         
    //   23   43:aload_2         
    //   24   44:invokevirtual   #783 <Method void setMasterPlot(PlotData2D)>
        }
    //*  25   47:goto            62
        catch(Exception ex)
    //*  26   50:astore_3        
        {
            System.err.println(ex);
    //   27   51:getstatic       #787 <Field PrintStream System.err>
    //   28   54:aload_3         
    //   29   55:invokevirtual   #792 <Method void PrintStream.println(Object)>
            ex.printStackTrace();
    //   30   58:aload_3         
    //   31   59:invokevirtual   #652 <Method void Exception.printStackTrace()>
        }
    //   32   62:return          
    }

    public void setUpComboBoxes(Instances inst)
    {
        setProperties(inst.relationName());
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokevirtual   #587 <Method String Instances.relationName()>
    //    3    5:invokespecial   #376 <Method void setProperties(String)>
        int prefX = -1;
    //    4    8:iconst_m1       
    //    5    9:istore_2        
        int prefY = -1;
    //    6   10:iconst_m1       
    //    7   11:istore_3        
        if(inst.numAttributes() > 1)
    //*   8   12:aload_1         
    //*   9   13:invokevirtual   #778 <Method int Instances.numAttributes()>
    //*  10   16:iconst_1        
    //*  11   17:icmple          22
            prefY = 1;
    //   12   20:iconst_1        
    //   13   21:istore_3        
        int prefC = -1;
    //   14   22:iconst_m1       
    //   15   23:istore          4
        String XNames[] = new String[inst.numAttributes()];
    //   16   25:aload_1         
    //   17   26:invokevirtual   #778 <Method int Instances.numAttributes()>
    //   18   29:anewarray       String[]
    //   19   32:astore          5
        String YNames[] = new String[inst.numAttributes()];
    //   20   34:aload_1         
    //   21   35:invokevirtual   #778 <Method int Instances.numAttributes()>
    //   22   38:anewarray       String[]
    //   23   41:astore          6
        String CNames[] = new String[inst.numAttributes()];
    //   24   43:aload_1         
    //   25   44:invokevirtual   #778 <Method int Instances.numAttributes()>
    //   26   47:anewarray       String[]
    //   27   50:astore          7
        for(int i = 0; i < XNames.length; i++)
    //*  28   52:iconst_0        
    //*  29   53:istore          8
    //*  30   55:goto            349
        {
            String type = "";
    //   31   58:ldc2            #367 <String "">
    //   32   61:astore          9
            switch(inst.attribute(i).type())
    //*  33   63:aload_1         
    //*  34   64:iload           8
    //*  35   66:invokevirtual   #758 <Method Attribute Instances.attribute(int)>
    //*  36   69:invokevirtual   #797 <Method int Attribute.type()>
            {
    //*  37   72:tableswitch     0 4: default 148
    //                   0 116
    //                   1 108
    //                   2 124
    //                   3 132
    //                   4 140
            case 1: // '\001'
                type = " (Nom)";
    //   38  108:ldc2            #799 <String " (Nom)">
    //   39  111:astore          9
                break;

    //*  40  113:goto            153
            case 0: // '\0'
                type = " (Num)";
    //   41  116:ldc2            #801 <String " (Num)">
    //   42  119:astore          9
                break;

    //*  43  121:goto            153
            case 2: // '\002'
                type = " (Str)";
    //   44  124:ldc2            #803 <String " (Str)">
    //   45  127:astore          9
                break;

    //*  46  129:goto            153
            case 3: // '\003'
                type = " (Dat)";
    //   47  132:ldc2            #805 <String " (Dat)">
    //   48  135:astore          9
                break;

    //*  49  137:goto            153
            case 4: // '\004'
                type = " (Rel)";
    //   50  140:ldc2            #807 <String " (Rel)">
    //   51  143:astore          9
                break;

    //*  52  145:goto            153
            default:
                type = " (???)";
    //   53  148:ldc2            #809 <String " (???)">
    //   54  151:astore          9
                break;
            }
            XNames[i] = (new StringBuilder("X: ")).append(inst.attribute(i).name()).append(type).toString();
    //   55  153:aload           5
    //   56  155:iload           8
    //   57  157:new             #169 <Class StringBuilder>
    //   58  160:dup             
    //   59  161:ldc2            #811 <String "X: ">
    //   60  164:invokespecial   #177 <Method void StringBuilder(String)>
    //   61  167:aload_1         
    //   62  168:iload           8
    //   63  170:invokevirtual   #758 <Method Attribute Instances.attribute(int)>
    //   64  173:invokevirtual   #814 <Method String Attribute.name()>
    //   65  176:invokevirtual   #183 <Method StringBuilder StringBuilder.append(String)>
    //   66  179:aload           9
    //   67  181:invokevirtual   #183 <Method StringBuilder StringBuilder.append(String)>
    //   68  184:invokevirtual   #186 <Method String StringBuilder.toString()>
    //   69  187:aastore         
            YNames[i] = (new StringBuilder("Y: ")).append(inst.attribute(i).name()).append(type).toString();
    //   70  188:aload           6
    //   71  190:iload           8
    //   72  192:new             #169 <Class StringBuilder>
    //   73  195:dup             
    //   74  196:ldc2            #816 <String "Y: ">
    //   75  199:invokespecial   #177 <Method void StringBuilder(String)>
    //   76  202:aload_1         
    //   77  203:iload           8
    //   78  205:invokevirtual   #758 <Method Attribute Instances.attribute(int)>
    //   79  208:invokevirtual   #814 <Method String Attribute.name()>
    //   80  211:invokevirtual   #183 <Method StringBuilder StringBuilder.append(String)>
    //   81  214:aload           9
    //   82  216:invokevirtual   #183 <Method StringBuilder StringBuilder.append(String)>
    //   83  219:invokevirtual   #186 <Method String StringBuilder.toString()>
    //   84  222:aastore         
            CNames[i] = (new StringBuilder("Colour: ")).append(inst.attribute(i).name()).append(type).toString();
    //   85  223:aload           7
    //   86  225:iload           8
    //   87  227:new             #169 <Class StringBuilder>
    //   88  230:dup             
    //   89  231:ldc2            #818 <String "Colour: ">
    //   90  234:invokespecial   #177 <Method void StringBuilder(String)>
    //   91  237:aload_1         
    //   92  238:iload           8
    //   93  240:invokevirtual   #758 <Method Attribute Instances.attribute(int)>
    //   94  243:invokevirtual   #814 <Method String Attribute.name()>
    //   95  246:invokevirtual   #183 <Method StringBuilder StringBuilder.append(String)>
    //   96  249:aload           9
    //   97  251:invokevirtual   #183 <Method StringBuilder StringBuilder.append(String)>
    //   98  254:invokevirtual   #186 <Method String StringBuilder.toString()>
    //   99  257:aastore         
            if(m_preferredXDimension != null && m_preferredXDimension.compareTo(inst.attribute(i).name()) == 0)
    //* 100  258:aload_0         
    //* 101  259:getfield        #210 <Field String m_preferredXDimension>
    //* 102  262:ifnull          287
    //* 103  265:aload_0         
    //* 104  266:getfield        #210 <Field String m_preferredXDimension>
    //* 105  269:aload_1         
    //* 106  270:iload           8
    //* 107  272:invokevirtual   #758 <Method Attribute Instances.attribute(int)>
    //* 108  275:invokevirtual   #814 <Method String Attribute.name()>
    //* 109  278:invokevirtual   #198 <Method int String.compareTo(String)>
    //* 110  281:ifne            287
                prefX = i;
    //  111  284:iload           8
    //  112  286:istore_2        
            if(m_preferredYDimension != null && m_preferredYDimension.compareTo(inst.attribute(i).name()) == 0)
    //* 113  287:aload_0         
    //* 114  288:getfield        #212 <Field String m_preferredYDimension>
    //* 115  291:ifnull          316
    //* 116  294:aload_0         
    //* 117  295:getfield        #212 <Field String m_preferredYDimension>
    //* 118  298:aload_1         
    //* 119  299:iload           8
    //* 120  301:invokevirtual   #758 <Method Attribute Instances.attribute(int)>
    //* 121  304:invokevirtual   #814 <Method String Attribute.name()>
    //* 122  307:invokevirtual   #198 <Method int String.compareTo(String)>
    //* 123  310:ifne            316
                prefY = i;
    //  124  313:iload           8
    //  125  315:istore_3        
            if(m_preferredColourDimension != null && m_preferredColourDimension.compareTo(inst.attribute(i).name()) == 0)
    //* 126  316:aload_0         
    //* 127  317:getfield        #214 <Field String m_preferredColourDimension>
    //* 128  320:ifnull          346
    //* 129  323:aload_0         
    //* 130  324:getfield        #214 <Field String m_preferredColourDimension>
    //* 131  327:aload_1         
    //* 132  328:iload           8
    //* 133  330:invokevirtual   #758 <Method Attribute Instances.attribute(int)>
    //* 134  333:invokevirtual   #814 <Method String Attribute.name()>
    //* 135  336:invokevirtual   #198 <Method int String.compareTo(String)>
    //* 136  339:ifne            346
                prefC = i;
    //  137  342:iload           8
    //  138  344:istore          4
        }

    //  139  346:iinc            8  1
    //  140  349:iload           8
    //  141  351:aload           5
    //  142  353:arraylength     
    //  143  354:icmplt          58
        m_XCombo.setModel(new DefaultComboBoxModel(XNames));
    //  144  357:aload_0         
    //  145  358:getfield        #256 <Field JComboBox m_XCombo>
    //  146  361:new             #554 <Class DefaultComboBoxModel>
    //  147  364:dup             
    //  148  365:aload           5
    //  149  367:invokespecial   #557 <Method void DefaultComboBoxModel(Object[])>
    //  150  370:invokevirtual   #561 <Method void JComboBox.setModel(javax.swing.ComboBoxModel)>
        m_YCombo.setModel(new DefaultComboBoxModel(YNames));
    //  151  373:aload_0         
    //  152  374:getfield        #258 <Field JComboBox m_YCombo>
    //  153  377:new             #554 <Class DefaultComboBoxModel>
    //  154  380:dup             
    //  155  381:aload           6
    //  156  383:invokespecial   #557 <Method void DefaultComboBoxModel(Object[])>
    //  157  386:invokevirtual   #561 <Method void JComboBox.setModel(javax.swing.ComboBoxModel)>
        m_ColourCombo.setModel(new DefaultComboBoxModel(CNames));
    //  158  389:aload_0         
    //  159  390:getfield        #260 <Field JComboBox m_ColourCombo>
    //  160  393:new             #554 <Class DefaultComboBoxModel>
    //  161  396:dup             
    //  162  397:aload           7
    //  163  399:invokespecial   #557 <Method void DefaultComboBoxModel(Object[])>
    //  164  402:invokevirtual   #561 <Method void JComboBox.setModel(javax.swing.ComboBoxModel)>
        m_XCombo.setEnabled(true);
    //  165  405:aload_0         
    //  166  406:getfield        #256 <Field JComboBox m_XCombo>
    //  167  409:iconst_1        
    //  168  410:invokevirtual   #408 <Method void JComboBox.setEnabled(boolean)>
        m_YCombo.setEnabled(true);
    //  169  413:aload_0         
    //  170  414:getfield        #258 <Field JComboBox m_YCombo>
    //  171  417:iconst_1        
    //  172  418:invokevirtual   #408 <Method void JComboBox.setEnabled(boolean)>
        if(m_splitListener == null)
    //* 173  421:aload_0         
    //* 174  422:getfield        #146 <Field VisualizePanelListener m_splitListener>
    //* 175  425:ifnonnull       449
        {
            m_ColourCombo.setEnabled(true);
    //  176  428:aload_0         
    //  177  429:getfield        #260 <Field JComboBox m_ColourCombo>
    //  178  432:iconst_1        
    //  179  433:invokevirtual   #408 <Method void JComboBox.setEnabled(boolean)>
            m_ColourCombo.setSelectedIndex(inst.numAttributes() - 1);
    //  180  436:aload_0         
    //  181  437:getfield        #260 <Field JComboBox m_ColourCombo>
    //  182  440:aload_1         
    //  183  441:invokevirtual   #778 <Method int Instances.numAttributes()>
    //  184  444:iconst_1        
    //  185  445:isub            
    //  186  446:invokevirtual   #724 <Method void JComboBox.setSelectedIndex(int)>
        }
        m_plotSurround.setBorder(BorderFactory.createTitledBorder((new StringBuilder("Plot: ")).append(inst.relationName()).toString()));
    //  187  449:aload_0         
    //  188  450:getfield        #74  <Field JPanel m_plotSurround>
    //  189  453:new             #169 <Class StringBuilder>
    //  190  456:dup             
    //  191  457:ldc2            #820 <String "Plot: ">
    //  192  460:invokespecial   #177 <Method void StringBuilder(String)>
    //  193  463:aload_1         
    //  194  464:invokevirtual   #587 <Method String Instances.relationName()>
    //  195  467:invokevirtual   #183 <Method StringBuilder StringBuilder.append(String)>
    //  196  470:invokevirtual   #186 <Method String StringBuilder.toString()>
    //  197  473:invokestatic    #531 <Method javax.swing.border.TitledBorder BorderFactory.createTitledBorder(String)>
    //  198  476:invokevirtual   #512 <Method void JPanel.setBorder(javax.swing.border.Border)>
        try
        {
            if(prefX != -1)
    //* 199  479:iload_2         
    //* 200  480:iconst_m1       
    //* 201  481:icmpeq          489
                setXIndex(prefX);
    //  202  484:aload_0         
    //  203  485:iload_2         
    //  204  486:invokevirtual   #822 <Method void setXIndex(int)>
            if(prefY != -1)
    //* 205  489:iload_3         
    //* 206  490:iconst_m1       
    //* 207  491:icmpeq          499
                setYIndex(prefY);
    //  208  494:aload_0         
    //  209  495:iload_3         
    //  210  496:invokevirtual   #824 <Method void setYIndex(int)>
            if(prefC != -1)
    //* 211  499:iload           4
    //* 212  501:iconst_m1       
    //* 213  502:icmpeq          528
                m_ColourCombo.setSelectedIndex(prefC);
    //  214  505:aload_0         
    //  215  506:getfield        #260 <Field JComboBox m_ColourCombo>
    //  216  509:iload           4
    //  217  511:invokevirtual   #724 <Method void JComboBox.setSelectedIndex(int)>
        }
    //* 218  514:goto            528
        catch(Exception ex)
    //* 219  517:astore          8
        {
            System.err.println("Problem setting preferred Visualization dimensions");
    //  220  519:getstatic       #787 <Field PrintStream System.err>
    //  221  522:ldc2            #826 <String "Problem setting preferred Visualization dimensions">
    //  222  525:invokevirtual   #828 <Method void PrintStream.println(String)>
        }
    //  223  528:return          
    }

    public void removeAllPlots()
    {
        m_plot.removeAllPlots();
    //    0    0:aload_0         
    //    1    1:getfield        #342 <Field VisualizePanel$PlotPanel m_plot>
    //    2    4:invokevirtual   #835 <Method void VisualizePanel$PlotPanel.removeAllPlots()>
    //    3    7:return          
    }

    public void setMasterPlot(PlotData2D newPlot)
        throws Exception
    {
        m_plot.setMasterPlot(newPlot);
    //    0    0:aload_0         
    //    1    1:getfield        #342 <Field VisualizePanel$PlotPanel m_plot>
    //    2    4:aload_1         
    //    3    5:invokevirtual   #836 <Method void VisualizePanel$PlotPanel.setMasterPlot(PlotData2D)>
        setUpComboBoxes(newPlot.m_plotInstances);
    //    4    8:aload_0         
    //    5    9:aload_1         
    //    6   10:getfield        #837 <Field Instances PlotData2D.m_plotInstances>
    //    7   13:invokevirtual   #839 <Method void setUpComboBoxes(Instances)>
        m_saveBut.setEnabled(true);
    //    8   16:aload_0         
    //    9   17:getfield        #281 <Field JButton m_saveBut>
    //   10   20:iconst_1        
    //   11   21:invokevirtual   #491 <Method void JButton.setEnabled(boolean)>
        repaint();
    //   12   24:aload_0         
    //   13   25:invokevirtual   #126 <Method void repaint()>
    //   14   28:return          
    }

    public void addPlot(PlotData2D newPlot)
        throws Exception
    {
        m_plot.addPlot(newPlot);
    //    0    0:aload_0         
    //    1    1:getfield        #342 <Field VisualizePanel$PlotPanel m_plot>
    //    2    4:aload_1         
    //    3    5:invokevirtual   #841 <Method void VisualizePanel$PlotPanel.addPlot(PlotData2D)>
        if(m_plot.m_plot2D.getMasterPlot() != null)
    //*   4    8:aload_0         
    //*   5    9:getfield        #342 <Field VisualizePanel$PlotPanel m_plot>
    //*   6   12:getfield        #348 <Field Plot2D VisualizePanel$PlotPanel.m_plot2D>
    //*   7   15:invokevirtual   #845 <Method PlotData2D Plot2D.getMasterPlot()>
    //*   8   18:ifnull          29
            setUpComboBoxes(newPlot.m_plotInstances);
    //    9   21:aload_0         
    //   10   22:aload_1         
    //   11   23:getfield        #837 <Field Instances PlotData2D.m_plotInstances>
    //   12   26:invokevirtual   #839 <Method void setUpComboBoxes(Instances)>
        m_saveBut.setEnabled(true);
    //   13   29:aload_0         
    //   14   30:getfield        #281 <Field JButton m_saveBut>
    //   15   33:iconst_1        
    //   16   34:invokevirtual   #491 <Method void JButton.setEnabled(boolean)>
        repaint();
    //   17   37:aload_0         
    //   18   38:invokevirtual   #126 <Method void repaint()>
    //   19   41:return          
    }

    public PlotPanel getPlotPanel()
    {
        return m_plot;
    //    0    0:aload_0         
    //    1    1:getfield        #342 <Field VisualizePanel$PlotPanel m_plot>
    //    2    4:areturn         
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
                System.err.println("Usage : weka.gui.visualize.VisualizePanel <dataset> [<dataset> <dataset>...]");
    //    4    6:getstatic       #787 <Field PrintStream System.err>
    //    5    9:ldc2            #851 <String "Usage : weka.gui.visualize.VisualizePanel <dataset> [<dataset> <dataset>...]">
    //    6   12:invokevirtual   #828 <Method void PrintStream.println(String)>
                System.exit(1);
    //    7   15:iconst_1        
    //    8   16:invokestatic    #854 <Method void System.exit(int)>
            }
            final JFrame jf = new JFrame("Weka Explorer: Visualize");
    //    9   19:new             #603 <Class JFrame>
    //   10   22:dup             
    //   11   23:ldc2            #856 <String "Weka Explorer: Visualize">
    //   12   26:invokespecial   #857 <Method void JFrame(String)>
    //   13   29:astore_1        
            jf.setSize(500, 400);
    //   14   30:aload_1         
    //   15   31:sipush          500
    //   16   34:sipush          400
    //   17   37:invokevirtual   #860 <Method void JFrame.setSize(int, int)>
            jf.getContentPane().setLayout(new BorderLayout());
    //   18   40:aload_1         
    //   19   41:invokevirtual   #863 <Method Container JFrame.getContentPane()>
    //   20   44:new             #533 <Class BorderLayout>
    //   21   47:dup             
    //   22   48:invokespecial   #534 <Method void BorderLayout()>
    //   23   51:invokevirtual   #866 <Method void Container.setLayout(java.awt.LayoutManager)>
            VisualizePanel sp = new VisualizePanel();
    //   24   54:new             #2   <Class VisualizePanel>
    //   25   57:dup             
    //   26   58:invokespecial   #144 <Method void VisualizePanel()>
    //   27   61:astore_2        
            jf.getContentPane().add(sp, "Center");
    //   28   62:aload_1         
    //   29   63:invokevirtual   #863 <Method Container JFrame.getContentPane()>
    //   30   66:aload_2         
    //   31   67:ldc2            #537 <String "Center">
    //   32   70:invokevirtual   #867 <Method void Container.add(Component, Object)>
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
    //   34   74:new             #869 <Class VisualizePanel$13>
    //   35   77:dup             
    //   36   78:aload_1         
    //   37   79:invokespecial   #872 <Method void VisualizePanel$13(JFrame)>
    //   38   82:invokevirtual   #876 <Method void JFrame.addWindowListener(java.awt.event.WindowListener)>
            jf.setVisible(true);
    //   39   85:aload_1         
    //   40   86:iconst_1        
    //   41   87:invokevirtual   #879 <Method void JFrame.setVisible(boolean)>
            if(args.length >= 1)
    //*  42   90:aload_0         
    //*  43   91:arraylength     
    //*  44   92:iconst_1        
    //*  45   93:icmplt          283
            {
                for(int j = 0; j < args.length; j++)
    //*  46   96:iconst_0        
    //*  47   97:istore_3        
    //*  48   98:goto            259
                {
                    System.err.println((new StringBuilder("Loading instances from ")).append(args[j]).toString());
    //   49  101:getstatic       #787 <Field PrintStream System.err>
    //   50  104:new             #169 <Class StringBuilder>
    //   51  107:dup             
    //   52  108:ldc2            #881 <String "Loading instances from ">
    //   53  111:invokespecial   #177 <Method void StringBuilder(String)>
    //   54  114:aload_0         
    //   55  115:iload_3         
    //   56  116:aaload          
    //   57  117:invokevirtual   #183 <Method StringBuilder StringBuilder.append(String)>
    //   58  120:invokevirtual   #186 <Method String StringBuilder.toString()>
    //   59  123:invokevirtual   #828 <Method void PrintStream.println(String)>
                    java.io.Reader r = new BufferedReader(new FileReader(args[j]));
    //   60  126:new             #640 <Class BufferedReader>
    //   61  129:dup             
    //   62  130:new             #642 <Class FileReader>
    //   63  133:dup             
    //   64  134:aload_0         
    //   65  135:iload_3         
    //   66  136:aaload          
    //   67  137:invokespecial   #882 <Method void FileReader(String)>
    //   68  140:invokespecial   #646 <Method void BufferedReader(java.io.Reader)>
    //   69  143:astore          4
                    Instances i = new Instances(r);
    //   70  145:new             #585 <Class Instances>
    //   71  148:dup             
    //   72  149:aload           4
    //   73  151:invokespecial   #647 <Method void Instances(java.io.Reader)>
    //   74  154:astore          5
                    i.setClassIndex(i.numAttributes() - 1);
    //   75  156:aload           5
    //   76  158:aload           5
    //   77  160:invokevirtual   #778 <Method int Instances.numAttributes()>
    //   78  163:iconst_1        
    //   79  164:isub            
    //   80  165:invokevirtual   #885 <Method void Instances.setClassIndex(int)>
                    PlotData2D pd1 = new PlotData2D(i);
    //   81  168:new             #581 <Class PlotData2D>
    //   82  171:dup             
    //   83  172:aload           5
    //   84  174:invokespecial   #583 <Method void PlotData2D(Instances)>
    //   85  177:astore          6
                    if(j == 0)
    //*  86  179:iload_3         
    //*  87  180:ifne            200
                    {
                        pd1.setPlotName("Master plot");
    //   88  183:aload           6
    //   89  185:ldc2            #887 <String "Master plot">
    //   90  188:invokevirtual   #590 <Method void PlotData2D.setPlotName(String)>
                        sp.setMasterPlot(pd1);
    //   91  191:aload_2         
    //   92  192:aload           6
    //   93  194:invokevirtual   #783 <Method void setMasterPlot(PlotData2D)>
                    } else
    //*  94  197:goto            256
                    {
                        pd1.setPlotName((new StringBuilder("Plot ")).append(j + 1).toString());
    //   95  200:aload           6
    //   96  202:new             #169 <Class StringBuilder>
    //   97  205:dup             
    //   98  206:ldc2            #889 <String "Plot ">
    //   99  209:invokespecial   #177 <Method void StringBuilder(String)>
    //  100  212:iload_3         
    //  101  213:iconst_1        
    //  102  214:iadd            
    //  103  215:invokevirtual   #892 <Method StringBuilder StringBuilder.append(int)>
    //  104  218:invokevirtual   #186 <Method String StringBuilder.toString()>
    //  105  221:invokevirtual   #590 <Method void PlotData2D.setPlotName(String)>
                        pd1.m_useCustomColour = true;
    //  106  224:aload           6
    //  107  226:iconst_1        
    //  108  227:putfield        #895 <Field boolean PlotData2D.m_useCustomColour>
                        pd1.m_customColour = j % 2 != 0 ? Color.blue : Color.red;
    //  109  230:aload           6
    //  110  232:iload_3         
    //  111  233:iconst_2        
    //  112  234:irem            
    //  113  235:ifne            244
    //  114  238:getstatic       #231 <Field Color Color.red>
    //  115  241:goto            247
    //  116  244:getstatic       #228 <Field Color Color.blue>
    //  117  247:putfield        #898 <Field Color PlotData2D.m_customColour>
                        sp.addPlot(pd1);
    //  118  250:aload_2         
    //  119  251:aload           6
    //  120  253:invokevirtual   #597 <Method void addPlot(PlotData2D)>
                    }
                }

    //  121  256:iinc            3  1
    //  122  259:iload_3         
    //  123  260:aload_0         
    //  124  261:arraylength     
    //  125  262:icmplt          101
            }
        }
    //* 126  265:goto            283
        catch(Exception ex)
    //* 127  268:astore_1        
        {
            ex.printStackTrace();
    //  128  269:aload_1         
    //  129  270:invokevirtual   #652 <Method void Exception.printStackTrace()>
            System.err.println(ex.getMessage());
    //  130  273:getstatic       #787 <Field PrintStream System.err>
    //  131  276:aload_1         
    //  132  277:invokevirtual   #655 <Method String Exception.getMessage()>
    //  133  280:invokevirtual   #828 <Method void PrintStream.println(String)>
        }
    //  134  283:return          
    }

    private static final long serialVersionUID = 0x3550947ad3fc057L;
    protected Color m_DefaultColors[];
    protected JComboBox m_XCombo;
    protected JComboBox m_YCombo;
    protected JComboBox m_ColourCombo;
    protected JComboBox m_ShapeCombo;
    protected JButton m_submit;
    protected JButton m_cancel;
    protected JButton m_openBut;
    protected JButton m_saveBut;
    private Dimension COMBO_SIZE;
    protected JFileChooser m_FileChooser;
    protected FileFilter m_ArffFilter;
    protected JLabel m_JitterLab;
    protected JSlider m_Jitter;
    protected PlotPanel m_plot;
    protected AttributePanel m_attrib;
    protected LegendPanel m_legendPanel;
    protected JPanel m_plotSurround;
    protected JPanel m_classSurround;
    protected ActionListener listener;
    protected VisualizePanelListener m_splitListener;
    protected String m_plotName;
    protected ClassPanel m_classPanel;
    protected FastVector m_colorList;
    protected String m_preferredXDimension;
    protected String m_preferredYDimension;
    protected String m_preferredColourDimension;
    protected boolean m_showAttBars;
    protected boolean m_showClassPanel;
    protected Logger m_Log;


/*
    static void access$0(VisualizePanel visualizepanel)
    {
        visualizepanel.saveVisibleInstances();
    //    0    0:aload_0         
    //    1    1:invokespecial   #908 <Method void saveVisibleInstances()>
        return;
    //    2    4:return          
    }

*/
}
