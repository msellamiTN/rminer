// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   LegendPanel.java

package rm.gui.visualize;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import rm.core.FastVector;
import rm.core.Instances;

// Referenced classes of package rm.gui.visualize:
//            PlotData2D, Plot2D

public class LegendPanel extends JScrollPane
{
    protected class LegendEntry extends JPanel
    {

        private static final long serialVersionUID = 0x35d87e9c5e5e8f76L;
        private PlotData2D m_plotData;
        private int m_dataIndex;
        private JLabel m_legendText;
        private JPanel m_pointShape;
        final LegendPanel this$0;


/*
        static PlotData2D access$0(LegendEntry legendentry)
        {
            return legendentry.m_plotData;
        //    0    0:aload_0         
        //    1    1:getfield        #29  <Field PlotData2D m_plotData>
        //    2    4:areturn         
        }

*/


/*
        static JLabel access$1(LegendEntry legendentry)
        {
            return legendentry.m_legendText;
        //    0    0:aload_0         
        //    1    1:getfield        #67  <Field JLabel m_legendText>
        //    2    4:areturn         
        }

*/


/*
        static int access$2(LegendEntry legendentry)
        {
            return legendentry.m_dataIndex;
        //    0    0:aload_0         
        //    1    1:getfield        #41  <Field int m_dataIndex>
        //    2    4:ireturn         
        }

*/


/*
        static LegendPanel access$3(LegendEntry legendentry)
        {
            return legendentry.this$0;
        //    0    0:aload_0         
        //    1    1:getfield        #24  <Field LegendPanel this$0>
        //    2    4:areturn         
        }

*/

        public LegendEntry(PlotData2D data, int dataIndex)
        {
            this$0 = LegendPanel.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #24  <Field LegendPanel this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #27  <Method void JPanel()>
            m_plotData = null;
        //    5    9:aload_0         
        //    6   10:aconst_null     
        //    7   11:putfield        #29  <Field PlotData2D m_plotData>
            ToolTipManager.sharedInstance().setDismissDelay(5000);
        //    8   14:invokestatic    #35  <Method ToolTipManager ToolTipManager.sharedInstance()>
        //    9   17:sipush          5000
        //   10   20:invokevirtual   #39  <Method void ToolTipManager.setDismissDelay(int)>
            m_plotData = data;
        //   11   23:aload_0         
        //   12   24:aload_2         
        //   13   25:putfield        #29  <Field PlotData2D m_plotData>
            m_dataIndex = dataIndex;
        //   14   28:aload_0         
        //   15   29:iload_3         
        //   16   30:putfield        #41  <Field int m_dataIndex>
            if(m_plotData.m_useCustomColour)
        //*  17   33:aload_0         
        //*  18   34:getfield        #29  <Field PlotData2D m_plotData>
        //*  19   37:getfield        #47  <Field boolean PlotData2D.m_useCustomColour>
        //*  20   40:ifeq            55
                addMouseListener(new MouseAdapter() {

                    public void mouseClicked(MouseEvent e)
                    {
                        if((e.getModifiers() & 0x10) == 16)
                    //*   0    0:aload_1         
                    //*   1    1:invokevirtual   #26  <Method int MouseEvent.getModifiers()>
                    //*   2    4:bipush          16
                    //*   3    6:iand            
                    //*   4    7:bipush          16
                    //*   5    9:icmpne          132
                        {
                            Color tmp = JColorChooser.showDialog(_fld0, "Select new Color", m_plotData.m_customColour);
                    //    6   12:aload_0         
                    //    7   13:getfield        #11  <Field LegendPanel$LegendEntry this$1>
                    //    8   16:invokestatic    #32  <Method LegendPanel LegendPanel$LegendEntry.access$3(LegendPanel$LegendEntry)>
                    //    9   19:ldc1            #34  <String "Select new Color">
                    //   10   21:aload_0         
                    //   11   22:getfield        #11  <Field LegendPanel$LegendEntry this$1>
                    //   12   25:invokestatic    #38  <Method PlotData2D LegendPanel$LegendEntry.access$0(LegendPanel$LegendEntry)>
                    //   13   28:getfield        #44  <Field Color PlotData2D.m_customColour>
                    //   14   31:invokestatic    #50  <Method Color JColorChooser.showDialog(Component, String, Color)>
                    //   15   34:astore_2        
                            if(tmp != null)
                    //*  16   35:aload_2         
                    //*  17   36:ifnull          132
                            {
                                m_plotData.m_customColour = tmp;
                    //   18   39:aload_0         
                    //   19   40:getfield        #11  <Field LegendPanel$LegendEntry this$1>
                    //   20   43:invokestatic    #38  <Method PlotData2D LegendPanel$LegendEntry.access$0(LegendPanel$LegendEntry)>
                    //   21   46:aload_2         
                    //   22   47:putfield        #44  <Field Color PlotData2D.m_customColour>
                                m_legendText.setForeground(tmp);
                    //   23   50:aload_0         
                    //   24   51:getfield        #11  <Field LegendPanel$LegendEntry this$1>
                    //   25   54:invokestatic    #54  <Method JLabel LegendPanel$LegendEntry.access$1(LegendPanel$LegendEntry)>
                    //   26   57:aload_2         
                    //   27   58:invokevirtual   #60  <Method void JLabel.setForeground(Color)>
                                if(m_Repainters.size() > 0)
                    //*  28   61:aload_0         
                    //*  29   62:getfield        #11  <Field LegendPanel$LegendEntry this$1>
                    //*  30   65:invokestatic    #32  <Method LegendPanel LegendPanel$LegendEntry.access$3(LegendPanel$LegendEntry)>
                    //*  31   68:getfield        #66  <Field FastVector LegendPanel.m_Repainters>
                    //*  32   71:invokevirtual   #71  <Method int FastVector.size()>
                    //*  33   74:ifle            122
                                {
                                    for(int i = 0; i < m_Repainters.size(); i++)
                    //*  34   77:iconst_0        
                    //*  35   78:istore_3        
                    //*  36   79:goto            105
                                        ((Component)m_Repainters.elementAt(i)).repaint();
                    //   37   82:aload_0         
                    //   38   83:getfield        #11  <Field LegendPanel$LegendEntry this$1>
                    //   39   86:invokestatic    #32  <Method LegendPanel LegendPanel$LegendEntry.access$3(LegendPanel$LegendEntry)>
                    //   40   89:getfield        #66  <Field FastVector LegendPanel.m_Repainters>
                    //   41   92:iload_3         
                    //   42   93:invokevirtual   #75  <Method Object FastVector.elementAt(int)>
                    //   43   96:checkcast       #77  <Class Component>
                    //   44   99:invokevirtual   #80  <Method void Component.repaint()>

                    //   45  102:iinc            3  1
                    //   46  105:iload_3         
                    //   47  106:aload_0         
                    //   48  107:getfield        #11  <Field LegendPanel$LegendEntry this$1>
                    //   49  110:invokestatic    #32  <Method LegendPanel LegendPanel$LegendEntry.access$3(LegendPanel$LegendEntry)>
                    //   50  113:getfield        #66  <Field FastVector LegendPanel.m_Repainters>
                    //   51  116:invokevirtual   #71  <Method int FastVector.size()>
                    //   52  119:icmplt          82
                                }
                                repaint();
                    //   53  122:aload_0         
                    //   54  123:getfield        #11  <Field LegendPanel$LegendEntry this$1>
                    //   55  126:invokestatic    #32  <Method LegendPanel LegendPanel$LegendEntry.access$3(LegendPanel$LegendEntry)>
                    //   56  129:invokevirtual   #81  <Method void LegendPanel.repaint()>
                            }
                        }
                    //   57  132:return          
                    }

                    final LegendEntry this$1;

                
                {
                    this$1 = LegendEntry.this;
                //    0    0:aload_0         
                //    1    1:aload_1         
                //    2    2:putfield        #11  <Field LegendPanel$LegendEntry this$1>
                    super();
                //    3    5:aload_0         
                //    4    6:invokespecial   #14  <Method void MouseAdapter()>
                //    5    9:return          
                }
                }
);
        //   21   43:aload_0         
        //   22   44:new             #49  <Class LegendPanel$1>
        //   23   47:dup             
        //   24   48:aload_0         
        //   25   49:invokespecial   #52  <Method void LegendPanel$1(LegendPanel$LegendEntry)>
        //   26   52:invokevirtual   #56  <Method void addMouseListener(java.awt.event.MouseListener)>
            m_legendText = new JLabel(m_plotData.m_plotName);
        //   27   55:aload_0         
        //   28   56:new             #58  <Class JLabel>
        //   29   59:dup             
        //   30   60:aload_0         
        //   31   61:getfield        #29  <Field PlotData2D m_plotData>
        //   32   64:getfield        #62  <Field String PlotData2D.m_plotName>
        //   33   67:invokespecial   #65  <Method void JLabel(String)>
        //   34   70:putfield        #67  <Field JLabel m_legendText>
            m_legendText.setToolTipText(m_plotData.getPlotNameHTML());
        //   35   73:aload_0         
        //   36   74:getfield        #67  <Field JLabel m_legendText>
        //   37   77:aload_0         
        //   38   78:getfield        #29  <Field PlotData2D m_plotData>
        //   39   81:invokevirtual   #71  <Method String PlotData2D.getPlotNameHTML()>
        //   40   84:invokevirtual   #74  <Method void JLabel.setToolTipText(String)>
            if(m_plotData.m_useCustomColour)
        //*  41   87:aload_0         
        //*  42   88:getfield        #29  <Field PlotData2D m_plotData>
        //*  43   91:getfield        #47  <Field boolean PlotData2D.m_useCustomColour>
        //*  44   94:ifeq            111
                m_legendText.setForeground(m_plotData.m_customColour);
        //   45   97:aload_0         
        //   46   98:getfield        #67  <Field JLabel m_legendText>
        //   47  101:aload_0         
        //   48  102:getfield        #29  <Field PlotData2D m_plotData>
        //   49  105:getfield        #78  <Field Color PlotData2D.m_customColour>
        //   50  108:invokevirtual   #82  <Method void JLabel.setForeground(Color)>
            setLayout(new BorderLayout());
        //   51  111:aload_0         
        //   52  112:new             #84  <Class BorderLayout>
        //   53  115:dup             
        //   54  116:invokespecial   #85  <Method void BorderLayout()>
        //   55  119:invokevirtual   #89  <Method void setLayout(java.awt.LayoutManager)>
            add(m_legendText, "Center");
        //   56  122:aload_0         
        //   57  123:aload_0         
        //   58  124:getfield        #67  <Field JLabel m_legendText>
        //   59  127:ldc1            #91  <String "Center">
        //   60  129:invokevirtual   #95  <Method void add(Component, Object)>
            m_pointShape = new JPanel() {

                public void paintComponent(Graphics gx)
                {
                    super.paintComponent(gx);
                //    0    0:aload_0         
                //    1    1:aload_1         
                //    2    2:invokespecial   #27  <Method void JPanel.paintComponent(Graphics)>
                    if(!m_plotData.m_useCustomColour)
                //*   3    5:aload_0         
                //*   4    6:getfield        #16  <Field LegendPanel$LegendEntry this$1>
                //*   5    9:invokestatic    #33  <Method PlotData2D LegendPanel$LegendEntry.access$0(LegendPanel$LegendEntry)>
                //*   6   12:getfield        #39  <Field boolean PlotData2D.m_useCustomColour>
                //*   7   15:ifne            28
                        gx.setColor(Color.black);
                //    8   18:aload_1         
                //    9   19:getstatic       #45  <Field Color Color.black>
                //   10   22:invokevirtual   #51  <Method void Graphics.setColor(Color)>
                    else
                //*  11   25:goto            42
                        gx.setColor(m_plotData.m_customColour);
                //   12   28:aload_1         
                //   13   29:aload_0         
                //   14   30:getfield        #16  <Field LegendPanel$LegendEntry this$1>
                //   15   33:invokestatic    #33  <Method PlotData2D LegendPanel$LegendEntry.access$0(LegendPanel$LegendEntry)>
                //   16   36:getfield        #54  <Field Color PlotData2D.m_customColour>
                //   17   39:invokevirtual   #51  <Method void Graphics.setColor(Color)>
                    Plot2D.drawDataPoint(10D, 10D, 3, m_dataIndex, gx);
                //   18   42:ldc2w           #55  <Double 10D>
                //   19   45:ldc2w           #55  <Double 10D>
                //   20   48:iconst_3        
                //   21   49:aload_0         
                //   22   50:getfield        #16  <Field LegendPanel$LegendEntry this$1>
                //   23   53:invokestatic    #60  <Method int LegendPanel$LegendEntry.access$2(LegendPanel$LegendEntry)>
                //   24   56:aload_1         
                //   25   57:invokestatic    #66  <Method void Plot2D.drawDataPoint(double, double, int, int, Graphics)>
                //   26   60:return          
                }

                private static final long serialVersionUID = 0x9e2eed829b57e1d2L;
                final LegendEntry this$1;

                
                {
                    this$1 = LegendEntry.this;
                //    0    0:aload_0         
                //    1    1:aload_1         
                //    2    2:putfield        #16  <Field LegendPanel$LegendEntry this$1>
                    super();
                //    3    5:aload_0         
                //    4    6:invokespecial   #19  <Method void JPanel()>
                //    5    9:return          
                }
            }
;
        //   61  132:aload_0         
        //   62  133:new             #97  <Class LegendPanel$2>
        //   63  136:dup             
        //   64  137:aload_0         
        //   65  138:invokespecial   #98  <Method void LegendPanel$2(LegendPanel$LegendEntry)>
        //   66  141:putfield        #100 <Field JPanel m_pointShape>
            m_pointShape.setPreferredSize(new Dimension(20, 20));
        //   67  144:aload_0         
        //   68  145:getfield        #100 <Field JPanel m_pointShape>
        //   69  148:new             #102 <Class Dimension>
        //   70  151:dup             
        //   71  152:bipush          20
        //   72  154:bipush          20
        //   73  156:invokespecial   #105 <Method void Dimension(int, int)>
        //   74  159:invokevirtual   #109 <Method void JPanel.setPreferredSize(Dimension)>
            m_pointShape.setMinimumSize(new Dimension(20, 20));
        //   75  162:aload_0         
        //   76  163:getfield        #100 <Field JPanel m_pointShape>
        //   77  166:new             #102 <Class Dimension>
        //   78  169:dup             
        //   79  170:bipush          20
        //   80  172:bipush          20
        //   81  174:invokespecial   #105 <Method void Dimension(int, int)>
        //   82  177:invokevirtual   #112 <Method void JPanel.setMinimumSize(Dimension)>
            add(m_pointShape, "West");
        //   83  180:aload_0         
        //   84  181:aload_0         
        //   85  182:getfield        #100 <Field JPanel m_pointShape>
        //   86  185:ldc1            #114 <String "West">
        //   87  187:invokevirtual   #95  <Method void add(Component, Object)>
        //   88  190:return          
        }
    }


    public LegendPanel()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #19  <Method void JScrollPane()>
        m_span = null;
    //    2    4:aload_0         
    //    3    5:aconst_null     
    //    4    6:putfield        #21  <Field JPanel m_span>
        m_Repainters = new FastVector();
    //    5    9:aload_0         
    //    6   10:new             #23  <Class FastVector>
    //    7   13:dup             
    //    8   14:invokespecial   #24  <Method void FastVector()>
    //    9   17:putfield        #26  <Field FastVector m_Repainters>
        setBackground(Color.blue);
    //   10   20:aload_0         
    //   11   21:getstatic       #32  <Field Color Color.blue>
    //   12   24:invokevirtual   #36  <Method void setBackground(Color)>
        setVerticalScrollBarPolicy(22);
    //   13   27:aload_0         
    //   14   28:bipush          22
    //   15   30:invokevirtual   #40  <Method void setVerticalScrollBarPolicy(int)>
    //   16   33:return          
    }

    public void setPlotList(FastVector pl)
    {
        m_plots = pl;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #48  <Field FastVector m_plots>
        updateLegends();
    //    3    5:aload_0         
    //    4    6:invokespecial   #51  <Method void updateLegends()>
    //    5    9:return          
    }

    public void addRepaintNotify(Component c)
    {
        m_Repainters.addElement(c);
    //    0    0:aload_0         
    //    1    1:getfield        #26  <Field FastVector m_Repainters>
    //    2    4:aload_1         
    //    3    5:invokevirtual   #58  <Method void FastVector.addElement(Object)>
    //    4    8:return          
    }

    private void updateLegends()
    {
        if(m_span == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #21  <Field JPanel m_span>
    //*   2    4:ifnonnull       18
            m_span = new JPanel();
    //    3    7:aload_0         
    //    4    8:new             #62  <Class JPanel>
    //    5   11:dup             
    //    6   12:invokespecial   #63  <Method void JPanel()>
    //    7   15:putfield        #21  <Field JPanel m_span>
        JPanel padder = new JPanel();
    //    8   18:new             #62  <Class JPanel>
    //    9   21:dup             
    //   10   22:invokespecial   #63  <Method void JPanel()>
    //   11   25:astore_1        
        JPanel padd2 = new JPanel();
    //   12   26:new             #62  <Class JPanel>
    //   13   29:dup             
    //   14   30:invokespecial   #63  <Method void JPanel()>
    //   15   33:astore_2        
        m_span.setPreferredSize(new Dimension(m_span.getPreferredSize().width, (m_plots.size() + 1) * 20));
    //   16   34:aload_0         
    //   17   35:getfield        #21  <Field JPanel m_span>
    //   18   38:new             #65  <Class Dimension>
    //   19   41:dup             
    //   20   42:aload_0         
    //   21   43:getfield        #21  <Field JPanel m_span>
    //   22   46:invokevirtual   #69  <Method Dimension JPanel.getPreferredSize()>
    //   23   49:getfield        #73  <Field int Dimension.width>
    //   24   52:aload_0         
    //   25   53:getfield        #48  <Field FastVector m_plots>
    //   26   56:invokevirtual   #77  <Method int FastVector.size()>
    //   27   59:iconst_1        
    //   28   60:iadd            
    //   29   61:bipush          20
    //   30   63:imul            
    //   31   64:invokespecial   #80  <Method void Dimension(int, int)>
    //   32   67:invokevirtual   #84  <Method void JPanel.setPreferredSize(Dimension)>
        m_span.setMaximumSize(new Dimension(m_span.getPreferredSize().width, (m_plots.size() + 1) * 20));
    //   33   70:aload_0         
    //   34   71:getfield        #21  <Field JPanel m_span>
    //   35   74:new             #65  <Class Dimension>
    //   36   77:dup             
    //   37   78:aload_0         
    //   38   79:getfield        #21  <Field JPanel m_span>
    //   39   82:invokevirtual   #69  <Method Dimension JPanel.getPreferredSize()>
    //   40   85:getfield        #73  <Field int Dimension.width>
    //   41   88:aload_0         
    //   42   89:getfield        #48  <Field FastVector m_plots>
    //   43   92:invokevirtual   #77  <Method int FastVector.size()>
    //   44   95:iconst_1        
    //   45   96:iadd            
    //   46   97:bipush          20
    //   47   99:imul            
    //   48  100:invokespecial   #80  <Method void Dimension(int, int)>
    //   49  103:invokevirtual   #87  <Method void JPanel.setMaximumSize(Dimension)>
        GridBagLayout gb = new GridBagLayout();
    //   50  106:new             #89  <Class GridBagLayout>
    //   51  109:dup             
    //   52  110:invokespecial   #90  <Method void GridBagLayout()>
    //   53  113:astore          4
        GridBagLayout gb2 = new GridBagLayout();
    //   54  115:new             #89  <Class GridBagLayout>
    //   55  118:dup             
    //   56  119:invokespecial   #90  <Method void GridBagLayout()>
    //   57  122:astore          5
        GridBagConstraints constraints = new GridBagConstraints();
    //   58  124:new             #92  <Class GridBagConstraints>
    //   59  127:dup             
    //   60  128:invokespecial   #93  <Method void GridBagConstraints()>
    //   61  131:astore          6
        m_span.removeAll();
    //   62  133:aload_0         
    //   63  134:getfield        #21  <Field JPanel m_span>
    //   64  137:invokevirtual   #96  <Method void JPanel.removeAll()>
        padder.setLayout(gb);
    //   65  140:aload_1         
    //   66  141:aload           4
    //   67  143:invokevirtual   #100 <Method void JPanel.setLayout(java.awt.LayoutManager)>
        m_span.setLayout(gb2);
    //   68  146:aload_0         
    //   69  147:getfield        #21  <Field JPanel m_span>
    //   70  150:aload           5
    //   71  152:invokevirtual   #100 <Method void JPanel.setLayout(java.awt.LayoutManager)>
        constraints.anchor = 10;
    //   72  155:aload           6
    //   73  157:bipush          10
    //   74  159:putfield        #103 <Field int GridBagConstraints.anchor>
        constraints.gridx = 0;
    //   75  162:aload           6
    //   76  164:iconst_0        
    //   77  165:putfield        #106 <Field int GridBagConstraints.gridx>
        constraints.gridy = 0;
    //   78  168:aload           6
    //   79  170:iconst_0        
    //   80  171:putfield        #109 <Field int GridBagConstraints.gridy>
        constraints.weightx = 5D;
    //   81  174:aload           6
    //   82  176:ldc2w           #110 <Double 5D>
    //   83  179:putfield        #115 <Field double GridBagConstraints.weightx>
        constraints.fill = 2;
    //   84  182:aload           6
    //   85  184:iconst_2        
    //   86  185:putfield        #118 <Field int GridBagConstraints.fill>
        constraints.gridwidth = 1;
    //   87  188:aload           6
    //   88  190:iconst_1        
    //   89  191:putfield        #121 <Field int GridBagConstraints.gridwidth>
        constraints.gridheight = 1;
    //   90  194:aload           6
    //   91  196:iconst_1        
    //   92  197:putfield        #124 <Field int GridBagConstraints.gridheight>
        constraints.insets = new Insets(0, 0, 0, 0);
    //   93  200:aload           6
    //   94  202:new             #126 <Class Insets>
    //   95  205:dup             
    //   96  206:iconst_0        
    //   97  207:iconst_0        
    //   98  208:iconst_0        
    //   99  209:iconst_0        
    //  100  210:invokespecial   #129 <Method void Insets(int, int, int, int)>
    //  101  213:putfield        #133 <Field Insets GridBagConstraints.insets>
        padder.add(m_span, constraints);
    //  102  216:aload_1         
    //  103  217:aload_0         
    //  104  218:getfield        #21  <Field JPanel m_span>
    //  105  221:aload           6
    //  106  223:invokevirtual   #137 <Method void JPanel.add(Component, Object)>
        constraints.gridx = 0;
    //  107  226:aload           6
    //  108  228:iconst_0        
    //  109  229:putfield        #106 <Field int GridBagConstraints.gridx>
        constraints.gridy = 1;
    //  110  232:aload           6
    //  111  234:iconst_1        
    //  112  235:putfield        #109 <Field int GridBagConstraints.gridy>
        constraints.weightx = 5D;
    //  113  238:aload           6
    //  114  240:ldc2w           #110 <Double 5D>
    //  115  243:putfield        #115 <Field double GridBagConstraints.weightx>
        constraints.fill = 1;
    //  116  246:aload           6
    //  117  248:iconst_1        
    //  118  249:putfield        #118 <Field int GridBagConstraints.fill>
        constraints.gridwidth = 1;
    //  119  252:aload           6
    //  120  254:iconst_1        
    //  121  255:putfield        #121 <Field int GridBagConstraints.gridwidth>
        constraints.gridheight = 1;
    //  122  258:aload           6
    //  123  260:iconst_1        
    //  124  261:putfield        #124 <Field int GridBagConstraints.gridheight>
        constraints.weighty = 5D;
    //  125  264:aload           6
    //  126  266:ldc2w           #110 <Double 5D>
    //  127  269:putfield        #140 <Field double GridBagConstraints.weighty>
        constraints.insets = new Insets(0, 0, 0, 0);
    //  128  272:aload           6
    //  129  274:new             #126 <Class Insets>
    //  130  277:dup             
    //  131  278:iconst_0        
    //  132  279:iconst_0        
    //  133  280:iconst_0        
    //  134  281:iconst_0        
    //  135  282:invokespecial   #129 <Method void Insets(int, int, int, int)>
    //  136  285:putfield        #133 <Field Insets GridBagConstraints.insets>
        padder.add(padd2, constraints);
    //  137  288:aload_1         
    //  138  289:aload_2         
    //  139  290:aload           6
    //  140  292:invokevirtual   #137 <Method void JPanel.add(Component, Object)>
        constraints.weighty = 0.0D;
    //  141  295:aload           6
    //  142  297:dconst_0        
    //  143  298:putfield        #140 <Field double GridBagConstraints.weighty>
        setViewportView(padder);
    //  144  301:aload_0         
    //  145  302:aload_1         
    //  146  303:invokevirtual   #143 <Method void setViewportView(Component)>
        constraints.anchor = 10;
    //  147  306:aload           6
    //  148  308:bipush          10
    //  149  310:putfield        #103 <Field int GridBagConstraints.anchor>
        constraints.gridx = 0;
    //  150  313:aload           6
    //  151  315:iconst_0        
    //  152  316:putfield        #106 <Field int GridBagConstraints.gridx>
        constraints.gridy = 0;
    //  153  319:aload           6
    //  154  321:iconst_0        
    //  155  322:putfield        #109 <Field int GridBagConstraints.gridy>
        constraints.weightx = 5D;
    //  156  325:aload           6
    //  157  327:ldc2w           #110 <Double 5D>
    //  158  330:putfield        #115 <Field double GridBagConstraints.weightx>
        constraints.fill = 2;
    //  159  333:aload           6
    //  160  335:iconst_2        
    //  161  336:putfield        #118 <Field int GridBagConstraints.fill>
        constraints.gridwidth = 1;
    //  162  339:aload           6
    //  163  341:iconst_1        
    //  164  342:putfield        #121 <Field int GridBagConstraints.gridwidth>
        constraints.gridheight = 1;
    //  165  345:aload           6
    //  166  347:iconst_1        
    //  167  348:putfield        #124 <Field int GridBagConstraints.gridheight>
        constraints.weighty = 5D;
    //  168  351:aload           6
    //  169  353:ldc2w           #110 <Double 5D>
    //  170  356:putfield        #140 <Field double GridBagConstraints.weighty>
        constraints.insets = new Insets(2, 4, 2, 4);
    //  171  359:aload           6
    //  172  361:new             #126 <Class Insets>
    //  173  364:dup             
    //  174  365:iconst_2        
    //  175  366:iconst_4        
    //  176  367:iconst_2        
    //  177  368:iconst_4        
    //  178  369:invokespecial   #129 <Method void Insets(int, int, int, int)>
    //  179  372:putfield        #133 <Field Insets GridBagConstraints.insets>
        for(int i = 0; i < m_plots.size(); i++)
    //* 180  375:iconst_0        
    //* 181  376:istore          7
    //* 182  378:goto            424
        {
            LegendEntry tmp = new LegendEntry((PlotData2D)m_plots.elementAt(i), i);
    //  183  381:new             #145 <Class LegendPanel$LegendEntry>
    //  184  384:dup             
    //  185  385:aload_0         
    //  186  386:aload_0         
    //  187  387:getfield        #48  <Field FastVector m_plots>
    //  188  390:iload           7
    //  189  392:invokevirtual   #149 <Method Object FastVector.elementAt(int)>
    //  190  395:checkcast       #151 <Class PlotData2D>
    //  191  398:iload           7
    //  192  400:invokespecial   #154 <Method void LegendPanel$LegendEntry(LegendPanel, PlotData2D, int)>
    //  193  403:astore_3        
            constraints.gridy = i;
    //  194  404:aload           6
    //  195  406:iload           7
    //  196  408:putfield        #109 <Field int GridBagConstraints.gridy>
            m_span.add(tmp, constraints);
    //  197  411:aload_0         
    //  198  412:getfield        #21  <Field JPanel m_span>
    //  199  415:aload_3         
    //  200  416:aload           6
    //  201  418:invokevirtual   #137 <Method void JPanel.add(Component, Object)>
        }

    //  202  421:iinc            7  1
    //  203  424:iload           7
    //  204  426:aload_0         
    //  205  427:getfield        #48  <Field FastVector m_plots>
    //  206  430:invokevirtual   #77  <Method int FastVector.size()>
    //  207  433:icmplt          381
    //  208  436:return          
    }

    public static void main(String args[])
    {
        try
        {
            if(args.length < 1)
    //*   0    0:aload_0         
    //*   1    1:arraylength     
    //*   2    2:iconst_1        
    //*   3    3:icmpge          18
            {
                System.err.println("Usage : weka.gui.visualize.LegendPanel <dataset> [dataset2], [dataset3],...");
    //    4    6:getstatic       #172 <Field PrintStream System.err>
    //    5    9:ldc1            #174 <String "Usage : weka.gui.visualize.LegendPanel <dataset> [dataset2], [dataset3],...">
    //    6   11:invokevirtual   #180 <Method void PrintStream.println(String)>
                System.exit(1);
    //    7   14:iconst_1        
    //    8   15:invokestatic    #183 <Method void System.exit(int)>
            }
            final JFrame jf = new JFrame("Weka Explorer: Legend");
    //    9   18:new             #185 <Class JFrame>
    //   10   21:dup             
    //   11   22:ldc1            #187 <String "Weka Explorer: Legend">
    //   12   24:invokespecial   #189 <Method void JFrame(String)>
    //   13   27:astore_1        
            jf.setSize(100, 100);
    //   14   28:aload_1         
    //   15   29:bipush          100
    //   16   31:bipush          100
    //   17   33:invokevirtual   #192 <Method void JFrame.setSize(int, int)>
            jf.getContentPane().setLayout(new BorderLayout());
    //   18   36:aload_1         
    //   19   37:invokevirtual   #196 <Method Container JFrame.getContentPane()>
    //   20   40:new             #198 <Class BorderLayout>
    //   21   43:dup             
    //   22   44:invokespecial   #199 <Method void BorderLayout()>
    //   23   47:invokevirtual   #202 <Method void Container.setLayout(java.awt.LayoutManager)>
            LegendPanel p2 = new LegendPanel();
    //   24   50:new             #2   <Class LegendPanel>
    //   25   53:dup             
    //   26   54:invokespecial   #203 <Method void LegendPanel()>
    //   27   57:astore_2        
            jf.getContentPane().add(p2, "Center");
    //   28   58:aload_1         
    //   29   59:invokevirtual   #196 <Method Container JFrame.getContentPane()>
    //   30   62:aload_2         
    //   31   63:ldc1            #205 <String "Center">
    //   32   65:invokevirtual   #206 <Method void Container.add(Component, Object)>
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
    //   33   68:aload_1         
    //   34   69:new             #208 <Class LegendPanel$3>
    //   35   72:dup             
    //   36   73:aload_1         
    //   37   74:invokespecial   #211 <Method void LegendPanel$3(JFrame)>
    //   38   77:invokevirtual   #215 <Method void JFrame.addWindowListener(java.awt.event.WindowListener)>
            FastVector plotList = new FastVector();
    //   39   80:new             #23  <Class FastVector>
    //   40   83:dup             
    //   41   84:invokespecial   #24  <Method void FastVector()>
    //   42   87:astore_3        
            for(int j = 0; j < args.length; j++)
    //*  43   88:iconst_0        
    //*  44   89:istore          4
    //*  45   91:goto            200
            {
                System.err.println((new StringBuilder("Loading instances from ")).append(args[j]).toString());
    //   46   94:getstatic       #172 <Field PrintStream System.err>
    //   47   97:new             #217 <Class StringBuilder>
    //   48  100:dup             
    //   49  101:ldc1            #219 <String "Loading instances from ">
    //   50  103:invokespecial   #220 <Method void StringBuilder(String)>
    //   51  106:aload_0         
    //   52  107:iload           4
    //   53  109:aaload          
    //   54  110:invokevirtual   #224 <Method StringBuilder StringBuilder.append(String)>
    //   55  113:invokevirtual   #228 <Method String StringBuilder.toString()>
    //   56  116:invokevirtual   #180 <Method void PrintStream.println(String)>
                java.io.Reader r = new BufferedReader(new FileReader(args[j]));
    //   57  119:new             #230 <Class BufferedReader>
    //   58  122:dup             
    //   59  123:new             #232 <Class FileReader>
    //   60  126:dup             
    //   61  127:aload_0         
    //   62  128:iload           4
    //   63  130:aaload          
    //   64  131:invokespecial   #233 <Method void FileReader(String)>
    //   65  134:invokespecial   #236 <Method void BufferedReader(java.io.Reader)>
    //   66  137:astore          5
                Instances i = new Instances(r);
    //   67  139:new             #238 <Class Instances>
    //   68  142:dup             
    //   69  143:aload           5
    //   70  145:invokespecial   #239 <Method void Instances(java.io.Reader)>
    //   71  148:astore          6
                PlotData2D tmp = new PlotData2D(i);
    //   72  150:new             #151 <Class PlotData2D>
    //   73  153:dup             
    //   74  154:aload           6
    //   75  156:invokespecial   #242 <Method void PlotData2D(Instances)>
    //   76  159:astore          7
                if(j != 1)
    //*  77  161:iload           4
    //*  78  163:iconst_1        
    //*  79  164:icmpeq          181
                {
                    tmp.m_useCustomColour = true;
    //   80  167:aload           7
    //   81  169:iconst_1        
    //   82  170:putfield        #246 <Field boolean PlotData2D.m_useCustomColour>
                    tmp.m_customColour = Color.red;
    //   83  173:aload           7
    //   84  175:getstatic       #249 <Field Color Color.red>
    //   85  178:putfield        #252 <Field Color PlotData2D.m_customColour>
                }
                tmp.setPlotName(i.relationName());
    //   86  181:aload           7
    //   87  183:aload           6
    //   88  185:invokevirtual   #255 <Method String Instances.relationName()>
    //   89  188:invokevirtual   #258 <Method void PlotData2D.setPlotName(String)>
                plotList.addElement(tmp);
    //   90  191:aload_3         
    //   91  192:aload           7
    //   92  194:invokevirtual   #58  <Method void FastVector.addElement(Object)>
            }

    //   93  197:iinc            4  1
    //   94  200:iload           4
    //   95  202:aload_0         
    //   96  203:arraylength     
    //   97  204:icmplt          94
            p2.setPlotList(plotList);
    //   98  207:aload_2         
    //   99  208:aload_3         
    //  100  209:invokevirtual   #260 <Method void setPlotList(FastVector)>
            jf.setVisible(true);
    //  101  212:aload_1         
    //  102  213:iconst_1        
    //  103  214:invokevirtual   #264 <Method void JFrame.setVisible(boolean)>
        }
    //* 104  217:goto            235
        catch(Exception ex)
    //* 105  220:astore_1        
        {
            System.err.println(ex.getMessage());
    //  106  221:getstatic       #172 <Field PrintStream System.err>
    //  107  224:aload_1         
    //  108  225:invokevirtual   #269 <Method String Exception.getMessage()>
    //  109  228:invokevirtual   #180 <Method void PrintStream.println(String)>
            ex.printStackTrace();
    //  110  231:aload_1         
    //  111  232:invokevirtual   #272 <Method void Exception.printStackTrace()>
        }
    //  112  235:return          
    }

    private static final long serialVersionUID = 0xee7b1c0a2b74445fL;
    protected FastVector m_plots;
    protected JPanel m_span;
    protected FastVector m_Repainters;
}
