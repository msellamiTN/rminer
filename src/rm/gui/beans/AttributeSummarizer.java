// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   AttributeSummarizer.java

package rm.gui.beans;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.beancontext.BeanContextChildSupport;
import java.io.*;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.*;
import rm.core.Attribute;
import rm.core.Instances;
import rm.gui.AttributeVisualizationPanel;

// Referenced classes of package rm.gui.beans:
//            DataVisualizer, BeanVisual

public class AttributeSummarizer extends DataVisualizer
{

    public AttributeSummarizer()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #18  <Method void DataVisualizer()>
        m_gridWidth = 4;
    //    2    4:aload_0         
    //    3    5:iconst_4        
    //    4    6:putfield        #20  <Field int m_gridWidth>
        m_maxPlots = 100;
    //    5    9:aload_0         
    //    6   10:bipush          100
    //    7   12:putfield        #22  <Field int m_maxPlots>
        m_coloringIndex = -1;
    //    8   15:aload_0         
    //    9   16:iconst_m1       
    //   10   17:putfield        #24  <Field int m_coloringIndex>
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    //   11   20:invokestatic    #30  <Method GraphicsEnvironment GraphicsEnvironment.getLocalGraphicsEnvironment()>
    //   12   23:astore_1        
        if(!GraphicsEnvironment.isHeadless())
    //*  13   24:invokestatic    #34  <Method boolean GraphicsEnvironment.isHeadless()>
    //*  14   27:ifne            34
            appearanceFinal();
    //   15   30:aload_0         
    //   16   31:invokevirtual   #37  <Method void appearanceFinal()>
    //   17   34:return          
    }

    public String globalInfo()
    {
        return "Plot summary bar charts for incoming data/training/test sets.";
    //    0    0:ldc1            #47  <String "Plot summary bar charts for incoming data/training/test sets.">
    //    1    2:areturn         
    }

    public void setColoringIndex(int ci)
    {
        m_coloringIndex = ci;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #24  <Field int m_coloringIndex>
    //    3    5:return          
    }

    public int getColoringIndex()
    {
        return m_coloringIndex;
    //    0    0:aload_0         
    //    1    1:getfield        #24  <Field int m_coloringIndex>
    //    2    4:ireturn         
    }

    public void setGridWidth(int gw)
    {
        if(gw > 0)
    //*   0    0:iload_1         
    //*   1    1:ifle            37
        {
            m_bcSupport.firePropertyChange("gridWidth", new Integer(m_gridWidth), new Integer(gw));
    //    2    4:aload_0         
    //    3    5:getfield        #57  <Field BeanContextChildSupport m_bcSupport>
    //    4    8:ldc1            #59  <String "gridWidth">
    //    5   10:new             #61  <Class Integer>
    //    6   13:dup             
    //    7   14:aload_0         
    //    8   15:getfield        #20  <Field int m_gridWidth>
    //    9   18:invokespecial   #63  <Method void Integer(int)>
    //   10   21:new             #61  <Class Integer>
    //   11   24:dup             
    //   12   25:iload_1         
    //   13   26:invokespecial   #63  <Method void Integer(int)>
    //   14   29:invokevirtual   #69  <Method void BeanContextChildSupport.firePropertyChange(String, Object, Object)>
            m_gridWidth = gw;
    //   15   32:aload_0         
    //   16   33:iload_1         
    //   17   34:putfield        #20  <Field int m_gridWidth>
        }
    //   18   37:return          
    }

    public int getGridWidth()
    {
        return m_gridWidth;
    //    0    0:aload_0         
    //    1    1:getfield        #20  <Field int m_gridWidth>
    //    2    4:ireturn         
    }

    public void setMaxPlots(int mp)
    {
        if(mp > 0)
    //*   0    0:iload_1         
    //*   1    1:ifle            37
        {
            m_bcSupport.firePropertyChange("maxPlots", new Integer(m_maxPlots), new Integer(mp));
    //    2    4:aload_0         
    //    3    5:getfield        #57  <Field BeanContextChildSupport m_bcSupport>
    //    4    8:ldc1            #74  <String "maxPlots">
    //    5   10:new             #61  <Class Integer>
    //    6   13:dup             
    //    7   14:aload_0         
    //    8   15:getfield        #22  <Field int m_maxPlots>
    //    9   18:invokespecial   #63  <Method void Integer(int)>
    //   10   21:new             #61  <Class Integer>
    //   11   24:dup             
    //   12   25:iload_1         
    //   13   26:invokespecial   #63  <Method void Integer(int)>
    //   14   29:invokevirtual   #69  <Method void BeanContextChildSupport.firePropertyChange(String, Object, Object)>
            m_maxPlots = mp;
    //   15   32:aload_0         
    //   16   33:iload_1         
    //   17   34:putfield        #22  <Field int m_maxPlots>
        }
    //   18   37:return          
    }

    public int getMaxPlots()
    {
        return m_maxPlots;
    //    0    0:aload_0         
    //    1    1:getfield        #22  <Field int m_maxPlots>
    //    2    4:ireturn         
    }

    public void setDesign(boolean design)
    {
        m_design = true;
    //    0    0:aload_0         
    //    1    1:iconst_1        
    //    2    2:putfield        #82  <Field boolean m_design>
        appearanceDesign();
    //    3    5:aload_0         
    //    4    6:invokevirtual   #85  <Method void appearanceDesign()>
    //    5    9:return          
    }

    protected void appearanceDesign()
    {
        removeAll();
    //    0    0:aload_0         
    //    1    1:invokevirtual   #89  <Method void removeAll()>
        m_visual = new BeanVisual("AttributeSummarizer", "weka/gui/beans/icons/AttributeSummarizer.gif", "weka/gui/beans/icons/AttributeSummarizer_animated.gif");
    //    2    4:aload_0         
    //    3    5:new             #91  <Class BeanVisual>
    //    4    8:dup             
    //    5    9:ldc1            #93  <String "AttributeSummarizer">
    //    6   11:ldc1            #95  <String "weka/gui/beans/icons/AttributeSummarizer.gif">
    //    7   13:ldc1            #97  <String "weka/gui/beans/icons/AttributeSummarizer_animated.gif">
    //    8   15:invokespecial   #100 <Method void BeanVisual(String, String, String)>
    //    9   18:putfield        #104 <Field BeanVisual m_visual>
        setLayout(new BorderLayout());
    //   10   21:aload_0         
    //   11   22:new             #106 <Class BorderLayout>
    //   12   25:dup             
    //   13   26:invokespecial   #107 <Method void BorderLayout()>
    //   14   29:invokevirtual   #111 <Method void setLayout(java.awt.LayoutManager)>
        add(m_visual, "Center");
    //   15   32:aload_0         
    //   16   33:aload_0         
    //   17   34:getfield        #104 <Field BeanVisual m_visual>
    //   18   37:ldc1            #113 <String "Center">
    //   19   39:invokevirtual   #117 <Method void add(java.awt.Component, Object)>
    //   20   42:return          
    }

    protected void appearanceFinal()
    {
        removeAll();
    //    0    0:aload_0         
    //    1    1:invokevirtual   #89  <Method void removeAll()>
        setLayout(new BorderLayout());
    //    2    4:aload_0         
    //    3    5:new             #106 <Class BorderLayout>
    //    4    8:dup             
    //    5    9:invokespecial   #107 <Method void BorderLayout()>
    //    6   12:invokevirtual   #111 <Method void setLayout(java.awt.LayoutManager)>
    //    7   15:return          
    }

    protected void setUpFinal()
    {
        removeAll();
    //    0    0:aload_0         
    //    1    1:invokevirtual   #89  <Method void removeAll()>
        JScrollPane hp = makePanel();
    //    2    4:aload_0         
    //    3    5:invokespecial   #122 <Method JScrollPane makePanel()>
    //    4    8:astore_1        
        add(hp, "Center");
    //    5    9:aload_0         
    //    6   10:aload_1         
    //    7   11:ldc1            #113 <String "Center">
    //    8   13:invokevirtual   #117 <Method void add(java.awt.Component, Object)>
    //    9   16:return          
    }

    public void useDefaultVisual()
    {
        m_visual.loadIcons("weka/gui/beans/icons/DefaultDataVisualizer.gif", "weka/gui/beans/icons/DefaultDataVisualizer_animated.gif");
    //    0    0:aload_0         
    //    1    1:getfield        #104 <Field BeanVisual m_visual>
    //    2    4:ldc1            #127 <String "weka/gui/beans/icons/DefaultDataVisualizer.gif">
    //    3    6:ldc1            #129 <String "weka/gui/beans/icons/DefaultDataVisualizer_animated.gif">
    //    4    8:invokevirtual   #133 <Method boolean BeanVisual.loadIcons(String, String)>
    //    5   11:pop             
    //    6   12:return          
    }

    public Enumeration enumerateRequests()
    {
        Vector newVector = new Vector(0);
    //    0    0:new             #137 <Class Vector>
    //    1    3:dup             
    //    2    4:iconst_0        
    //    3    5:invokespecial   #138 <Method void Vector(int)>
    //    4    8:astore_1        
        if(m_visualizeDataSet != null)
    //*   5    9:aload_0         
    //*   6   10:getfield        #142 <Field Instances m_visualizeDataSet>
    //*   7   13:ifnull          22
            newVector.addElement("Show summaries");
    //    8   16:aload_1         
    //    9   17:ldc1            #144 <String "Show summaries">
    //   10   19:invokevirtual   #148 <Method void Vector.addElement(Object)>
        return newVector.elements();
    //   11   22:aload_1         
    //   12   23:invokevirtual   #151 <Method Enumeration Vector.elements()>
    //   13   26:areturn         
    }

    private JScrollPane makePanel()
    {
        String fontFamily = getFont().getFamily();
    //    0    0:aload_0         
    //    1    1:invokevirtual   #157 <Method Font getFont()>
    //    2    4:invokevirtual   #162 <Method String Font.getFamily()>
    //    3    7:astore_1        
        Font newFont = new Font(fontFamily, 0, 10);
    //    4    8:new             #159 <Class Font>
    //    5   11:dup             
    //    6   12:aload_1         
    //    7   13:iconst_0        
    //    8   14:bipush          10
    //    9   16:invokespecial   #165 <Method void Font(String, int, int)>
    //   10   19:astore_2        
        JPanel hp = new JPanel();
    //   11   20:new             #167 <Class JPanel>
    //   12   23:dup             
    //   13   24:invokespecial   #168 <Method void JPanel()>
    //   14   27:astore_3        
        hp.setFont(newFont);
    //   15   28:aload_3         
    //   16   29:aload_2         
    //   17   30:invokevirtual   #172 <Method void JPanel.setFont(Font)>
        int numPlots = Math.min(m_visualizeDataSet.numAttributes(), m_maxPlots);
    //   18   33:aload_0         
    //   19   34:getfield        #142 <Field Instances m_visualizeDataSet>
    //   20   37:invokevirtual   #177 <Method int Instances.numAttributes()>
    //   21   40:aload_0         
    //   22   41:getfield        #22  <Field int m_maxPlots>
    //   23   44:invokestatic    #183 <Method int Math.min(int, int)>
    //   24   47:istore          4
        int gridHeight = numPlots / m_gridWidth;
    //   25   49:iload           4
    //   26   51:aload_0         
    //   27   52:getfield        #20  <Field int m_gridWidth>
    //   28   55:idiv            
    //   29   56:istore          5
        if(numPlots % m_gridWidth != 0)
    //*  30   58:iload           4
    //*  31   60:aload_0         
    //*  32   61:getfield        #20  <Field int m_gridWidth>
    //*  33   64:irem            
    //*  34   65:ifeq            71
            gridHeight++;
    //   35   68:iinc            5  1
        hp.setLayout(new GridLayout(gridHeight, 4));
    //   36   71:aload_3         
    //   37   72:new             #185 <Class GridLayout>
    //   38   75:dup             
    //   39   76:iload           5
    //   40   78:iconst_4        
    //   41   79:invokespecial   #188 <Method void GridLayout(int, int)>
    //   42   82:invokevirtual   #189 <Method void JPanel.setLayout(java.awt.LayoutManager)>
        for(int i = 0; i < numPlots; i++)
    //*  43   85:iconst_0        
    //*  44   86:istore          6
    //*  45   88:goto            217
        {
            JPanel temp = new JPanel();
    //   46   91:new             #167 <Class JPanel>
    //   47   94:dup             
    //   48   95:invokespecial   #168 <Method void JPanel()>
    //   49   98:astore          7
            temp.setLayout(new BorderLayout());
    //   50  100:aload           7
    //   51  102:new             #106 <Class BorderLayout>
    //   52  105:dup             
    //   53  106:invokespecial   #107 <Method void BorderLayout()>
    //   54  109:invokevirtual   #189 <Method void JPanel.setLayout(java.awt.LayoutManager)>
            temp.setBorder(BorderFactory.createTitledBorder(m_visualizeDataSet.attribute(i).name()));
    //   55  112:aload           7
    //   56  114:aload_0         
    //   57  115:getfield        #142 <Field Instances m_visualizeDataSet>
    //   58  118:iload           6
    //   59  120:invokevirtual   #193 <Method Attribute Instances.attribute(int)>
    //   60  123:invokevirtual   #198 <Method String Attribute.name()>
    //   61  126:invokestatic    #204 <Method javax.swing.border.TitledBorder BorderFactory.createTitledBorder(String)>
    //   62  129:invokevirtual   #208 <Method void JPanel.setBorder(javax.swing.border.Border)>
            AttributeVisualizationPanel ap = new AttributeVisualizationPanel();
    //   63  132:new             #210 <Class AttributeVisualizationPanel>
    //   64  135:dup             
    //   65  136:invokespecial   #211 <Method void AttributeVisualizationPanel()>
    //   66  139:astore          8
            ap.setInstances(m_visualizeDataSet);
    //   67  141:aload           8
    //   68  143:aload_0         
    //   69  144:getfield        #142 <Field Instances m_visualizeDataSet>
    //   70  147:invokevirtual   #215 <Method void AttributeVisualizationPanel.setInstances(Instances)>
            if(m_coloringIndex < 0 && m_visualizeDataSet.classIndex() >= 0)
    //*  71  150:aload_0         
    //*  72  151:getfield        #24  <Field int m_coloringIndex>
    //*  73  154:ifge            182
    //*  74  157:aload_0         
    //*  75  158:getfield        #142 <Field Instances m_visualizeDataSet>
    //*  76  161:invokevirtual   #218 <Method int Instances.classIndex()>
    //*  77  164:iflt            182
                ap.setColoringIndex(m_visualizeDataSet.classIndex());
    //   78  167:aload           8
    //   79  169:aload_0         
    //   80  170:getfield        #142 <Field Instances m_visualizeDataSet>
    //   81  173:invokevirtual   #218 <Method int Instances.classIndex()>
    //   82  176:invokevirtual   #220 <Method void AttributeVisualizationPanel.setColoringIndex(int)>
            else
    //*  83  179:goto            191
                ap.setColoringIndex(m_coloringIndex);
    //   84  182:aload           8
    //   85  184:aload_0         
    //   86  185:getfield        #24  <Field int m_coloringIndex>
    //   87  188:invokevirtual   #220 <Method void AttributeVisualizationPanel.setColoringIndex(int)>
            temp.add(ap, "Center");
    //   88  191:aload           7
    //   89  193:aload           8
    //   90  195:ldc1            #113 <String "Center">
    //   91  197:invokevirtual   #221 <Method void JPanel.add(java.awt.Component, Object)>
            ap.setAttribute(i);
    //   92  200:aload           8
    //   93  202:iload           6
    //   94  204:invokevirtual   #224 <Method void AttributeVisualizationPanel.setAttribute(int)>
            hp.add(temp);
    //   95  207:aload_3         
    //   96  208:aload           7
    //   97  210:invokevirtual   #227 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //   98  213:pop             
        }

    //   99  214:iinc            6  1
    //  100  217:iload           6
    //  101  219:iload           4
    //  102  221:icmplt          91
        Dimension d = new Dimension(830, gridHeight * 100);
    //  103  224:new             #229 <Class Dimension>
    //  104  227:dup             
    //  105  228:sipush          830
    //  106  231:iload           5
    //  107  233:bipush          100
    //  108  235:imul            
    //  109  236:invokespecial   #230 <Method void Dimension(int, int)>
    //  110  239:astore          6
        hp.setMinimumSize(d);
    //  111  241:aload_3         
    //  112  242:aload           6
    //  113  244:invokevirtual   #234 <Method void JPanel.setMinimumSize(Dimension)>
        hp.setMaximumSize(d);
    //  114  247:aload_3         
    //  115  248:aload           6
    //  116  250:invokevirtual   #237 <Method void JPanel.setMaximumSize(Dimension)>
        hp.setPreferredSize(d);
    //  117  253:aload_3         
    //  118  254:aload           6
    //  119  256:invokevirtual   #240 <Method void JPanel.setPreferredSize(Dimension)>
        JScrollPane scroller = new JScrollPane(hp);
    //  120  259:new             #242 <Class JScrollPane>
    //  121  262:dup             
    //  122  263:aload_3         
    //  123  264:invokespecial   #245 <Method void JScrollPane(java.awt.Component)>
    //  124  267:astore          7
        return scroller;
    //  125  269:aload           7
    //  126  271:areturn         
    }

    public void setInstances(Instances inst)
        throws Exception
    {
        if(m_design)
    //*   0    0:aload_0         
    //*   1    1:getfield        #82  <Field boolean m_design>
    //*   2    4:ifeq            18
        {
            throw new Exception("This method is not to be used during design time. It is meant to be used if this bean is being used programatically as as stand alone component.");
    //    3    7:new             #262 <Class Exception>
    //    4   10:dup             
    //    5   11:ldc2            #264 <String "This method is not to be used during design time. It is meant to be used if this bean is being used programatically as as stand alone component.">
    //    6   14:invokespecial   #267 <Method void Exception(String)>
    //    7   17:athrow          
        } else
        {
            m_visualizeDataSet = inst;
    //    8   18:aload_0         
    //    9   19:aload_1         
    //   10   20:putfield        #142 <Field Instances m_visualizeDataSet>
            setUpFinal();
    //   11   23:aload_0         
    //   12   24:invokevirtual   #269 <Method void setUpFinal()>
            return;
    //   13   27:return          
        }
    }

    public void performRequest(String request)
    {
        if(!m_design)
    //*   0    0:aload_0         
    //*   1    1:getfield        #82  <Field boolean m_design>
    //*   2    4:ifne            12
        {
            setUpFinal();
    //    3    7:aload_0         
    //    4    8:invokevirtual   #269 <Method void setUpFinal()>
            return;
    //    5   11:return          
        }
        if(request.compareTo("Show summaries") == 0)
    //*   6   12:aload_1         
    //*   7   13:ldc1            #144 <String "Show summaries">
    //*   8   15:invokevirtual   #277 <Method int String.compareTo(String)>
    //*   9   18:ifne            132
            try
            {
                if(!m_framePoppedUp)
    //*  10   21:aload_0         
    //*  11   22:getfield        #280 <Field boolean m_framePoppedUp>
    //*  12   25:ifne            109
                {
                    m_framePoppedUp = true;
    //   13   28:aload_0         
    //   14   29:iconst_1        
    //   15   30:putfield        #280 <Field boolean m_framePoppedUp>
                    JScrollPane holderP = makePanel();
    //   16   33:aload_0         
    //   17   34:invokespecial   #122 <Method JScrollPane makePanel()>
    //   18   37:astore_2        
                    final JFrame jf = new JFrame("Visualize");
    //   19   38:new             #282 <Class JFrame>
    //   20   41:dup             
    //   21   42:ldc2            #284 <String "Visualize">
    //   22   45:invokespecial   #285 <Method void JFrame(String)>
    //   23   48:astore_3        
                    jf.setSize(800, 600);
    //   24   49:aload_3         
    //   25   50:sipush          800
    //   26   53:sipush          600
    //   27   56:invokevirtual   #288 <Method void JFrame.setSize(int, int)>
                    jf.getContentPane().setLayout(new BorderLayout());
    //   28   59:aload_3         
    //   29   60:invokevirtual   #292 <Method Container JFrame.getContentPane()>
    //   30   63:new             #106 <Class BorderLayout>
    //   31   66:dup             
    //   32   67:invokespecial   #107 <Method void BorderLayout()>
    //   33   70:invokevirtual   #295 <Method void Container.setLayout(java.awt.LayoutManager)>
                    jf.getContentPane().add(holderP, "Center");
    //   34   73:aload_3         
    //   35   74:invokevirtual   #292 <Method Container JFrame.getContentPane()>
    //   36   77:aload_2         
    //   37   78:ldc1            #113 <String "Center">
    //   38   80:invokevirtual   #296 <Method void Container.add(java.awt.Component, Object)>
                    jf.addWindowListener(new WindowAdapter() {

                        public void windowClosing(WindowEvent e)
                        {
                            jf.dispose();
                        //    0    0:aload_0         
                        //    1    1:getfield        #15  <Field JFrame val$jf>
                        //    2    4:invokevirtual   #29  <Method void JFrame.dispose()>
                            m_framePoppedUp = false;
                        //    3    7:aload_0         
                        //    4    8:getfield        #13  <Field AttributeSummarizer this$0>
                        //    5   11:iconst_0        
                        //    6   12:putfield        #35  <Field boolean AttributeSummarizer.m_framePoppedUp>
                        //    7   15:return          
                        }

                        final AttributeSummarizer this$0;
                        private final JFrame val$jf;

            
            {
                this$0 = AttributeSummarizer.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field AttributeSummarizer this$0>
                jf = jframe;
            //    3    5:aload_0         
            //    4    6:aload_2         
            //    5    7:putfield        #15  <Field JFrame val$jf>
                super();
            //    6   10:aload_0         
            //    7   11:invokespecial   #18  <Method void WindowAdapter()>
            //    8   14:return          
            }
                    }
);
    //   39   83:aload_3         
    //   40   84:new             #298 <Class AttributeSummarizer$1>
    //   41   87:dup             
    //   42   88:aload_0         
    //   43   89:aload_3         
    //   44   90:invokespecial   #301 <Method void AttributeSummarizer$1(AttributeSummarizer, JFrame)>
    //   45   93:invokevirtual   #305 <Method void JFrame.addWindowListener(java.awt.event.WindowListener)>
                    jf.setVisible(true);
    //   46   96:aload_3         
    //   47   97:iconst_1        
    //   48   98:invokevirtual   #308 <Method void JFrame.setVisible(boolean)>
                    m_popupFrame = jf;
    //   49  101:aload_0         
    //   50  102:aload_3         
    //   51  103:putfield        #312 <Field JFrame m_popupFrame>
                } else
    //*  52  106:goto            160
                {
                    m_popupFrame.toFront();
    //   53  109:aload_0         
    //   54  110:getfield        #312 <Field JFrame m_popupFrame>
    //   55  113:invokevirtual   #315 <Method void JFrame.toFront()>
                }
            }
    //*  56  116:goto            160
            catch(Exception ex)
    //*  57  119:astore_2        
            {
                ex.printStackTrace();
    //   58  120:aload_2         
    //   59  121:invokevirtual   #318 <Method void Exception.printStackTrace()>
                m_framePoppedUp = false;
    //   60  124:aload_0         
    //   61  125:iconst_0        
    //   62  126:putfield        #280 <Field boolean m_framePoppedUp>
            }
        else
    //*  63  129:goto            160
            throw new IllegalArgumentException((new StringBuilder(String.valueOf(request))).append(" not supported (AttributeSummarizer)").toString());
    //   64  132:new             #320 <Class IllegalArgumentException>
    //   65  135:dup             
    //   66  136:new             #322 <Class StringBuilder>
    //   67  139:dup             
    //   68  140:aload_1         
    //   69  141:invokestatic    #326 <Method String String.valueOf(Object)>
    //   70  144:invokespecial   #327 <Method void StringBuilder(String)>
    //   71  147:ldc2            #329 <String " not supported (AttributeSummarizer)">
    //   72  150:invokevirtual   #333 <Method StringBuilder StringBuilder.append(String)>
    //   73  153:invokevirtual   #336 <Method String StringBuilder.toString()>
    //   74  156:invokespecial   #337 <Method void IllegalArgumentException(String)>
    //   75  159:athrow          
    //   76  160:return          
    }

    public static void main(String args[])
    {
        try
        {
            if(args.length != 1)
    //*   0    0:aload_0         
    //*   1    1:arraylength     
    //*   2    2:iconst_1        
    //*   3    3:icmpeq          19
            {
                System.err.println("Usage: AttributeSummarizer <dataset>");
    //    4    6:getstatic       #350 <Field PrintStream System.err>
    //    5    9:ldc2            #352 <String "Usage: AttributeSummarizer <dataset>">
    //    6   12:invokevirtual   #357 <Method void PrintStream.println(String)>
                System.exit(1);
    //    7   15:iconst_1        
    //    8   16:invokestatic    #360 <Method void System.exit(int)>
            }
            java.io.Reader r = new BufferedReader(new FileReader(args[0]));
    //    9   19:new             #362 <Class BufferedReader>
    //   10   22:dup             
    //   11   23:new             #364 <Class FileReader>
    //   12   26:dup             
    //   13   27:aload_0         
    //   14   28:iconst_0        
    //   15   29:aaload          
    //   16   30:invokespecial   #365 <Method void FileReader(String)>
    //   17   33:invokespecial   #368 <Method void BufferedReader(java.io.Reader)>
    //   18   36:astore_1        
            Instances inst = new Instances(r);
    //   19   37:new             #174 <Class Instances>
    //   20   40:dup             
    //   21   41:aload_1         
    //   22   42:invokespecial   #369 <Method void Instances(java.io.Reader)>
    //   23   45:astore_2        
            final JFrame jf = new JFrame();
    //   24   46:new             #282 <Class JFrame>
    //   25   49:dup             
    //   26   50:invokespecial   #370 <Method void JFrame()>
    //   27   53:astore_3        
            jf.getContentPane().setLayout(new BorderLayout());
    //   28   54:aload_3         
    //   29   55:invokevirtual   #292 <Method Container JFrame.getContentPane()>
    //   30   58:new             #106 <Class BorderLayout>
    //   31   61:dup             
    //   32   62:invokespecial   #107 <Method void BorderLayout()>
    //   33   65:invokevirtual   #295 <Method void Container.setLayout(java.awt.LayoutManager)>
            AttributeSummarizer as = new AttributeSummarizer();
    //   34   68:new             #2   <Class AttributeSummarizer>
    //   35   71:dup             
    //   36   72:invokespecial   #371 <Method void AttributeSummarizer()>
    //   37   75:astore          4
            as.setInstances(inst);
    //   38   77:aload           4
    //   39   79:aload_2         
    //   40   80:invokevirtual   #372 <Method void setInstances(Instances)>
            jf.getContentPane().add(as, "Center");
    //   41   83:aload_3         
    //   42   84:invokevirtual   #292 <Method Container JFrame.getContentPane()>
    //   43   87:aload           4
    //   44   89:ldc1            #113 <String "Center">
    //   45   91:invokevirtual   #296 <Method void Container.add(java.awt.Component, Object)>
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
    //   46   94:aload_3         
    //   47   95:new             #374 <Class AttributeSummarizer$2>
    //   48   98:dup             
    //   49   99:aload_3         
    //   50  100:invokespecial   #377 <Method void AttributeSummarizer$2(JFrame)>
    //   51  103:invokevirtual   #305 <Method void JFrame.addWindowListener(java.awt.event.WindowListener)>
            jf.setSize(830, 600);
    //   52  106:aload_3         
    //   53  107:sipush          830
    //   54  110:sipush          600
    //   55  113:invokevirtual   #288 <Method void JFrame.setSize(int, int)>
            jf.setVisible(true);
    //   56  116:aload_3         
    //   57  117:iconst_1        
    //   58  118:invokevirtual   #308 <Method void JFrame.setVisible(boolean)>
        }
    //*  59  121:goto            139
        catch(Exception ex)
    //*  60  124:astore_1        
        {
            ex.printStackTrace();
    //   61  125:aload_1         
    //   62  126:invokevirtual   #318 <Method void Exception.printStackTrace()>
            System.err.println(ex.getMessage());
    //   63  129:getstatic       #350 <Field PrintStream System.err>
    //   64  132:aload_1         
    //   65  133:invokevirtual   #380 <Method String Exception.getMessage()>
    //   66  136:invokevirtual   #357 <Method void PrintStream.println(String)>
        }
    //   67  139:return          
    }

    private static final long serialVersionUID = 0xfbea3db8eda029aaL;
    protected int m_gridWidth;
    protected int m_maxPlots;
    protected int m_coloringIndex;
}
