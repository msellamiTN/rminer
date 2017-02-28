// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   ClassPanel.java

package rm.gui.visualize;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import rm.core.*;

// Referenced classes of package rm.gui.visualize:
//            Plot2D, VisualizeUtils

public class ClassPanel extends JPanel
{
    private class NomLabel extends JLabel
    {

        private static final long serialVersionUID = 0xbef5ce35dce0dbd1L;
        private int m_index;
        final ClassPanel this$0;


/*
        static int access$0(NomLabel nomlabel)
        {
            return nomlabel.m_index;
        //    0    0:aload_0         
        //    1    1:getfield        #23  <Field int m_index>
        //    2    4:ireturn         
        }

*/


/*
        static ClassPanel access$1(NomLabel nomlabel)
        {
            return nomlabel.this$0;
        //    0    0:aload_0         
        //    1    1:getfield        #18  <Field ClassPanel this$0>
        //    2    4:areturn         
        }

*/

        public NomLabel(String name, int id)
        {
            this$0 = ClassPanel.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #18  <Field ClassPanel this$0>
            super(name);
        //    3    5:aload_0         
        //    4    6:aload_2         
        //    5    7:invokespecial   #21  <Method void JLabel(String)>
            m_index = 0;
        //    6   10:aload_0         
        //    7   11:iconst_0        
        //    8   12:putfield        #23  <Field int m_index>
            m_index = id;
        //    9   15:aload_0         
        //   10   16:iload_3         
        //   11   17:putfield        #23  <Field int m_index>
            addMouseListener(new MouseAdapter() {

                public void mouseClicked(MouseEvent e)
                {
                    if((e.getModifiers() & 0x10) == 16)
                //*   0    0:aload_1         
                //*   1    1:invokevirtual   #26  <Method int MouseEvent.getModifiers()>
                //*   2    4:bipush          16
                //*   3    6:iand            
                //*   4    7:bipush          16
                //*   5    9:icmpne          231
                    {
                        Color tmp = JColorChooser.showDialog(_fld0, "Select new Color", (Color)m_colorList.elementAt(m_index));
                //    6   12:aload_0         
                //    7   13:getfield        #11  <Field ClassPanel$NomLabel this$1>
                //    8   16:invokestatic    #32  <Method ClassPanel ClassPanel$NomLabel.access$1(ClassPanel$NomLabel)>
                //    9   19:ldc1            #34  <String "Select new Color">
                //   10   21:aload_0         
                //   11   22:getfield        #11  <Field ClassPanel$NomLabel this$1>
                //   12   25:invokestatic    #32  <Method ClassPanel ClassPanel$NomLabel.access$1(ClassPanel$NomLabel)>
                //   13   28:invokestatic    #40  <Method FastVector ClassPanel.access$0(ClassPanel)>
                //   14   31:aload_0         
                //   15   32:getfield        #11  <Field ClassPanel$NomLabel this$1>
                //   16   35:invokestatic    #43  <Method int ClassPanel$NomLabel.access$0(ClassPanel$NomLabel)>
                //   17   38:invokevirtual   #49  <Method Object FastVector.elementAt(int)>
                //   18   41:checkcast       #51  <Class Color>
                //   19   44:invokestatic    #57  <Method Color JColorChooser.showDialog(Component, String, Color)>
                //   20   47:astore_2        
                        if(tmp != null)
                //*  21   48:aload_2         
                //*  22   49:ifnull          231
                        {
                            m_colorList.setElementAt(tmp, m_index);
                //   23   52:aload_0         
                //   24   53:getfield        #11  <Field ClassPanel$NomLabel this$1>
                //   25   56:invokestatic    #32  <Method ClassPanel ClassPanel$NomLabel.access$1(ClassPanel$NomLabel)>
                //   26   59:invokestatic    #40  <Method FastVector ClassPanel.access$0(ClassPanel)>
                //   27   62:aload_2         
                //   28   63:aload_0         
                //   29   64:getfield        #11  <Field ClassPanel$NomLabel this$1>
                //   30   67:invokestatic    #43  <Method int ClassPanel$NomLabel.access$0(ClassPanel$NomLabel)>
                //   31   70:invokevirtual   #61  <Method void FastVector.setElementAt(Object, int)>
                            m_oldWidth = -9000;
                //   32   73:aload_0         
                //   33   74:getfield        #11  <Field ClassPanel$NomLabel this$1>
                //   34   77:invokestatic    #32  <Method ClassPanel ClassPanel$NomLabel.access$1(ClassPanel$NomLabel)>
                //   35   80:sipush          -9000
                //   36   83:invokestatic    #64  <Method void ClassPanel.access$1(ClassPanel, int)>
                            repaint();
                //   37   86:aload_0         
                //   38   87:getfield        #11  <Field ClassPanel$NomLabel this$1>
                //   39   90:invokestatic    #32  <Method ClassPanel ClassPanel$NomLabel.access$1(ClassPanel$NomLabel)>
                //   40   93:invokevirtual   #67  <Method void ClassPanel.repaint()>
                            if(m_Repainters.size() > 0)
                //*  41   96:aload_0         
                //*  42   97:getfield        #11  <Field ClassPanel$NomLabel this$1>
                //*  43  100:invokestatic    #32  <Method ClassPanel ClassPanel$NomLabel.access$1(ClassPanel$NomLabel)>
                //*  44  103:invokestatic    #70  <Method FastVector ClassPanel.access$2(ClassPanel)>
                //*  45  106:invokevirtual   #73  <Method int FastVector.size()>
                //*  46  109:ifle            157
                            {
                                for(int i = 0; i < m_Repainters.size(); i++)
                //*  47  112:iconst_0        
                //*  48  113:istore_3        
                //*  49  114:goto            140
                                    ((Component)m_Repainters.elementAt(i)).repaint();
                //   50  117:aload_0         
                //   51  118:getfield        #11  <Field ClassPanel$NomLabel this$1>
                //   52  121:invokestatic    #32  <Method ClassPanel ClassPanel$NomLabel.access$1(ClassPanel$NomLabel)>
                //   53  124:invokestatic    #70  <Method FastVector ClassPanel.access$2(ClassPanel)>
                //   54  127:iload_3         
                //   55  128:invokevirtual   #49  <Method Object FastVector.elementAt(int)>
                //   56  131:checkcast       #75  <Class Component>
                //   57  134:invokevirtual   #76  <Method void Component.repaint()>

                //   58  137:iinc            3  1
                //   59  140:iload_3         
                //   60  141:aload_0         
                //   61  142:getfield        #11  <Field ClassPanel$NomLabel this$1>
                //   62  145:invokestatic    #32  <Method ClassPanel ClassPanel$NomLabel.access$1(ClassPanel$NomLabel)>
                //   63  148:invokestatic    #70  <Method FastVector ClassPanel.access$2(ClassPanel)>
                //   64  151:invokevirtual   #73  <Method int FastVector.size()>
                //   65  154:icmplt          117
                            }
                            if(m_ColourChangeListeners.size() > 0)
                //*  66  157:aload_0         
                //*  67  158:getfield        #11  <Field ClassPanel$NomLabel this$1>
                //*  68  161:invokestatic    #32  <Method ClassPanel ClassPanel$NomLabel.access$1(ClassPanel$NomLabel)>
                //*  69  164:invokestatic    #79  <Method FastVector ClassPanel.access$3(ClassPanel)>
                //*  70  167:invokevirtual   #73  <Method int FastVector.size()>
                //*  71  170:ifle            231
                            {
                                for(int i = 0; i < m_ColourChangeListeners.size(); i++)
                //*  72  173:iconst_0        
                //*  73  174:istore_3        
                //*  74  175:goto            214
                                    ((ActionListener)m_ColourChangeListeners.elementAt(i)).actionPerformed(new ActionEvent(this, 0, ""));
                //   75  178:aload_0         
                //   76  179:getfield        #11  <Field ClassPanel$NomLabel this$1>
                //   77  182:invokestatic    #32  <Method ClassPanel ClassPanel$NomLabel.access$1(ClassPanel$NomLabel)>
                //   78  185:invokestatic    #79  <Method FastVector ClassPanel.access$3(ClassPanel)>
                //   79  188:iload_3         
                //   80  189:invokevirtual   #49  <Method Object FastVector.elementAt(int)>
                //   81  192:checkcast       #81  <Class ActionListener>
                //   82  195:new             #83  <Class ActionEvent>
                //   83  198:dup             
                //   84  199:aload_0         
                //   85  200:iconst_0        
                //   86  201:ldc1            #85  <String "">
                //   87  203:invokespecial   #88  <Method void ActionEvent(Object, int, String)>
                //   88  206:invokeinterface #92  <Method void ActionListener.actionPerformed(ActionEvent)>

                //   89  211:iinc            3  1
                //   90  214:iload_3         
                //   91  215:aload_0         
                //   92  216:getfield        #11  <Field ClassPanel$NomLabel this$1>
                //   93  219:invokestatic    #32  <Method ClassPanel ClassPanel$NomLabel.access$1(ClassPanel$NomLabel)>
                //   94  222:invokestatic    #79  <Method FastVector ClassPanel.access$3(ClassPanel)>
                //   95  225:invokevirtual   #73  <Method int FastVector.size()>
                //   96  228:icmplt          178
                            }
                        }
                    }
                //   97  231:return          
                }

                final NomLabel this$1;

                
                {
                    this$1 = NomLabel.this;
                //    0    0:aload_0         
                //    1    1:aload_1         
                //    2    2:putfield        #11  <Field ClassPanel$NomLabel this$1>
                    super();
                //    3    5:aload_0         
                //    4    6:invokespecial   #14  <Method void MouseAdapter()>
                //    5    9:return          
                }
            }
);
        //   12   20:aload_0         
        //   13   21:new             #25  <Class ClassPanel$1>
        //   14   24:dup             
        //   15   25:aload_0         
        //   16   26:invokespecial   #28  <Method void ClassPanel$1(ClassPanel$NomLabel)>
        //   17   29:invokevirtual   #32  <Method void addMouseListener(java.awt.event.MouseListener)>
        //   18   32:return          
        }
    }


    public ClassPanel()
    {
        this(null);
    //    0    0:aload_0         
    //    1    1:aconst_null     
    //    2    2:invokespecial   #44  <Method void ClassPanel(Color)>
    //    3    5:return          
    }

    public ClassPanel(Color background)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #50  <Method void JPanel()>
        m_isEnabled = false;
    //    2    4:aload_0         
    //    3    5:iconst_0        
    //    4    6:putfield        #52  <Field boolean m_isEnabled>
        m_isNumeric = false;
    //    5    9:aload_0         
    //    6   10:iconst_0        
    //    7   11:putfield        #54  <Field boolean m_isNumeric>
    //    8   14:aload_0         
    //    9   15:iconst_5        
    //   10   16:putfield        #56  <Field int m_spectrumHeight>
    //   11   19:aload_0         
    //   12   20:iconst_5        
    //   13   21:putfield        #58  <Field int m_tickSize>
        m_labelMetrics = null;
    //   14   24:aload_0         
    //   15   25:aconst_null     
    //   16   26:putfield        #60  <Field FontMetrics m_labelMetrics>
        m_labelFont = null;
    //   17   29:aload_0         
    //   18   30:aconst_null     
    //   19   31:putfield        #62  <Field Font m_labelFont>
        m_HorizontalPad = 0;
    //   20   34:aload_0         
    //   21   35:iconst_0        
    //   22   36:putfield        #64  <Field int m_HorizontalPad>
        m_oldWidth = -9000;
    //   23   39:aload_0         
    //   24   40:sipush          -9000
    //   25   43:putfield        #66  <Field int m_oldWidth>
        m_Instances = null;
    //   26   46:aload_0         
    //   27   47:aconst_null     
    //   28   48:putfield        #68  <Field Instances m_Instances>
        m_Repainters = new FastVector();
    //   29   51:aload_0         
    //   30   52:new             #70  <Class FastVector>
    //   31   55:dup             
    //   32   56:invokespecial   #71  <Method void FastVector()>
    //   33   59:putfield        #73  <Field FastVector m_Repainters>
        m_ColourChangeListeners = new FastVector();
    //   34   62:aload_0         
    //   35   63:new             #70  <Class FastVector>
    //   36   66:dup             
    //   37   67:invokespecial   #71  <Method void FastVector()>
    //   38   70:putfield        #75  <Field FastVector m_ColourChangeListeners>
        m_DefaultColors = (new Color[] {
            Color.blue, Color.red, Color.green, Color.cyan, Color.pink, new Color(255, 0, 255), Color.orange, new Color(255, 0, 0), new Color(0, 255, 0), Color.white
        });
    //   39   73:aload_0         
    //   40   74:bipush          10
    //   41   76:anewarray       Color[]
    //   42   79:dup             
    //   43   80:iconst_0        
    //   44   81:getstatic       #80  <Field Color Color.blue>
    //   45   84:aastore         
    //   46   85:dup             
    //   47   86:iconst_1        
    //   48   87:getstatic       #83  <Field Color Color.red>
    //   49   90:aastore         
    //   50   91:dup             
    //   51   92:iconst_2        
    //   52   93:getstatic       #86  <Field Color Color.green>
    //   53   96:aastore         
    //   54   97:dup             
    //   55   98:iconst_3        
    //   56   99:getstatic       #89  <Field Color Color.cyan>
    //   57  102:aastore         
    //   58  103:dup             
    //   59  104:iconst_4        
    //   60  105:getstatic       #92  <Field Color Color.pink>
    //   61  108:aastore         
    //   62  109:dup             
    //   63  110:iconst_5        
    //   64  111:new             #77  <Class Color>
    //   65  114:dup             
    //   66  115:sipush          255
    //   67  118:iconst_0        
    //   68  119:sipush          255
    //   69  122:invokespecial   #95  <Method void Color(int, int, int)>
    //   70  125:aastore         
    //   71  126:dup             
    //   72  127:bipush          6
    //   73  129:getstatic       #98  <Field Color Color.orange>
    //   74  132:aastore         
    //   75  133:dup             
    //   76  134:bipush          7
    //   77  136:new             #77  <Class Color>
    //   78  139:dup             
    //   79  140:sipush          255
    //   80  143:iconst_0        
    //   81  144:iconst_0        
    //   82  145:invokespecial   #95  <Method void Color(int, int, int)>
    //   83  148:aastore         
    //   84  149:dup             
    //   85  150:bipush          8
    //   86  152:new             #77  <Class Color>
    //   87  155:dup             
    //   88  156:iconst_0        
    //   89  157:sipush          255
    //   90  160:iconst_0        
    //   91  161:invokespecial   #95  <Method void Color(int, int, int)>
    //   92  164:aastore         
    //   93  165:dup             
    //   94  166:bipush          9
    //   95  168:getstatic       #101 <Field Color Color.white>
    //   96  171:aastore         
    //   97  172:putfield        #103 <Field Color[] m_DefaultColors>
        m_backgroundColor = null;
    //   98  175:aload_0         
    //   99  176:aconst_null     
    //  100  177:putfield        #105 <Field Color m_backgroundColor>
        m_backgroundColor = background;
    //  101  180:aload_0         
    //  102  181:aload_1         
    //  103  182:putfield        #105 <Field Color m_backgroundColor>
        m_colorList = new FastVector(10);
    //  104  185:aload_0         
    //  105  186:new             #70  <Class FastVector>
    //  106  189:dup             
    //  107  190:bipush          10
    //  108  192:invokespecial   #108 <Method void FastVector(int)>
    //  109  195:putfield        #110 <Field FastVector m_colorList>
        for(int noa = m_colorList.size(); noa < 10; noa++)
    //* 110  198:aload_0         
    //* 111  199:getfield        #110 <Field FastVector m_colorList>
    //* 112  202:invokevirtual   #114 <Method int FastVector.size()>
    //* 113  205:istore_2        
    //* 114  206:goto            263
        {
            Color pc = m_DefaultColors[noa % 10];
    //  115  209:aload_0         
    //  116  210:getfield        #103 <Field Color[] m_DefaultColors>
    //  117  213:iload_2         
    //  118  214:bipush          10
    //  119  216:irem            
    //  120  217:aaload          
    //  121  218:astore_3        
            int ija = noa / 10;
    //  122  219:iload_2         
    //  123  220:bipush          10
    //  124  222:idiv            
    //  125  223:istore          4
            ija *= 2;
    //  126  225:iload           4
    //  127  227:iconst_2        
    //  128  228:imul            
    //  129  229:istore          4
            for(int j = 0; j < ija; j++)
    //* 130  231:iconst_0        
    //* 131  232:istore          5
    //* 132  234:goto            245
                pc = pc.darker();
    //  133  237:aload_3         
    //  134  238:invokevirtual   #118 <Method Color Color.darker()>
    //  135  241:astore_3        

    //  136  242:iinc            5  1
    //  137  245:iload           5
    //  138  247:iload           4
    //  139  249:icmplt          237
            m_colorList.addElement(pc);
    //  140  252:aload_0         
    //  141  253:getfield        #110 <Field FastVector m_colorList>
    //  142  256:aload_3         
    //  143  257:invokevirtual   #122 <Method void FastVector.addElement(Object)>
        }

    //  144  260:iinc            2  1
    //  145  263:iload_2         
    //  146  264:bipush          10
    //  147  266:icmplt          209
    //  148  269:return          
    }

    public void addRepaintNotify(Component c)
    {
        m_Repainters.addElement(c);
    //    0    0:aload_0         
    //    1    1:getfield        #73  <Field FastVector m_Repainters>
    //    2    4:aload_1         
    //    3    5:invokevirtual   #122 <Method void FastVector.addElement(Object)>
    //    4    8:return          
    }

    public void addActionListener(ActionListener a)
    {
        m_ColourChangeListeners.addElement(a);
    //    0    0:aload_0         
    //    1    1:getfield        #75  <Field FastVector m_ColourChangeListeners>
    //    2    4:aload_1         
    //    3    5:invokevirtual   #122 <Method void FastVector.addElement(Object)>
    //    4    8:return          
    }

    private void setFonts(Graphics gx)
    {
        if(m_labelMetrics == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #60  <Field FontMetrics m_labelMetrics>
    //*   2    4:ifnonnull       81
        {
            m_labelFont = new Font("Monospaced", 0, 12);
    //    3    7:aload_0         
    //    4    8:new             #139 <Class Font>
    //    5   11:dup             
    //    6   12:ldc1            #141 <String "Monospaced">
    //    7   14:iconst_0        
    //    8   15:bipush          12
    //    9   17:invokespecial   #144 <Method void Font(String, int, int)>
    //   10   20:putfield        #62  <Field Font m_labelFont>
            m_labelMetrics = gx.getFontMetrics(m_labelFont);
    //   11   23:aload_0         
    //   12   24:aload_1         
    //   13   25:aload_0         
    //   14   26:getfield        #62  <Field Font m_labelFont>
    //   15   29:invokevirtual   #150 <Method FontMetrics Graphics.getFontMetrics(Font)>
    //   16   32:putfield        #60  <Field FontMetrics m_labelMetrics>
            int hf = m_labelMetrics.getAscent();
    //   17   35:aload_0         
    //   18   36:getfield        #60  <Field FontMetrics m_labelMetrics>
    //   19   39:invokevirtual   #155 <Method int FontMetrics.getAscent()>
    //   20   42:istore_2        
            if(getHeight() < 3 * hf)
    //*  21   43:aload_0         
    //*  22   44:invokevirtual   #158 <Method int getHeight()>
    //*  23   47:iconst_3        
    //*  24   48:iload_2         
    //*  25   49:imul            
    //*  26   50:icmpge          81
            {
                m_labelFont = new Font("Monospaced", 0, 11);
    //   27   53:aload_0         
    //   28   54:new             #139 <Class Font>
    //   29   57:dup             
    //   30   58:ldc1            #141 <String "Monospaced">
    //   31   60:iconst_0        
    //   32   61:bipush          11
    //   33   63:invokespecial   #144 <Method void Font(String, int, int)>
    //   34   66:putfield        #62  <Field Font m_labelFont>
                m_labelMetrics = gx.getFontMetrics(m_labelFont);
    //   35   69:aload_0         
    //   36   70:aload_1         
    //   37   71:aload_0         
    //   38   72:getfield        #62  <Field Font m_labelFont>
    //   39   75:invokevirtual   #150 <Method FontMetrics Graphics.getFontMetrics(Font)>
    //   40   78:putfield        #60  <Field FontMetrics m_labelMetrics>
            }
        }
        gx.setFont(m_labelFont);
    //   41   81:aload_1         
    //   42   82:aload_0         
    //   43   83:getfield        #62  <Field Font m_labelFont>
    //   44   86:invokevirtual   #162 <Method void Graphics.setFont(Font)>
    //   45   89:return          
    }

    public void setOn(boolean e)
    {
        m_isEnabled = e;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #52  <Field boolean m_isEnabled>
    //    3    5:return          
    }

    public void setInstances(Instances insts)
    {
        m_Instances = insts;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #68  <Field Instances m_Instances>
    //    3    5:return          
    }

    public void setCindex(int cIndex)
    {
        if(m_Instances.numAttributes() > 0)
    //*   0    0:aload_0         
    //*   1    1:getfield        #68  <Field Instances m_Instances>
    //*   2    4:invokevirtual   #177 <Method int Instances.numAttributes()>
    //*   3    7:ifle            71
        {
            m_cIndex = cIndex;
    //    4   10:aload_0         
    //    5   11:iload_1         
    //    6   12:putfield        #179 <Field int m_cIndex>
            if(m_Instances.attribute(m_cIndex).isNumeric())
    //*   7   15:aload_0         
    //*   8   16:getfield        #68  <Field Instances m_Instances>
    //*   9   19:aload_0         
    //*  10   20:getfield        #179 <Field int m_cIndex>
    //*  11   23:invokevirtual   #183 <Method Attribute Instances.attribute(int)>
    //*  12   26:invokevirtual   #189 <Method boolean Attribute.isNumeric()>
    //*  13   29:ifeq            39
            {
                setNumeric();
    //   14   32:aload_0         
    //   15   33:invokevirtual   #192 <Method void setNumeric()>
            } else
    //*  16   36:goto            71
            {
                if(m_Instances.attribute(m_cIndex).numValues() > m_colorList.size())
    //*  17   39:aload_0         
    //*  18   40:getfield        #68  <Field Instances m_Instances>
    //*  19   43:aload_0         
    //*  20   44:getfield        #179 <Field int m_cIndex>
    //*  21   47:invokevirtual   #183 <Method Attribute Instances.attribute(int)>
    //*  22   50:invokevirtual   #195 <Method int Attribute.numValues()>
    //*  23   53:aload_0         
    //*  24   54:getfield        #110 <Field FastVector m_colorList>
    //*  25   57:invokevirtual   #114 <Method int FastVector.size()>
    //*  26   60:icmple          67
                    extendColourMap();
    //   27   63:aload_0         
    //   28   64:invokespecial   #198 <Method void extendColourMap()>
                setNominal();
    //   29   67:aload_0         
    //   30   68:invokevirtual   #201 <Method void setNominal()>
            }
        }
    //   31   71:return          
    }

    private void extendColourMap()
    {
        if(m_Instances.attribute(m_cIndex).isNominal())
    //*   0    0:aload_0         
    //*   1    1:getfield        #68  <Field Instances m_Instances>
    //*   2    4:aload_0         
    //*   3    5:getfield        #179 <Field int m_cIndex>
    //*   4    8:invokevirtual   #183 <Method Attribute Instances.attribute(int)>
    //*   5   11:invokevirtual   #205 <Method boolean Attribute.isNominal()>
    //*   6   14:ifeq            112
        {
            for(int i = m_colorList.size(); i < m_Instances.attribute(m_cIndex).numValues(); i++)
    //*   7   17:aload_0         
    //*   8   18:getfield        #110 <Field FastVector m_colorList>
    //*   9   21:invokevirtual   #114 <Method int FastVector.size()>
    //*  10   24:istore_1        
    //*  11   25:goto            94
            {
                Color pc = m_DefaultColors[i % 10];
    //   12   28:aload_0         
    //   13   29:getfield        #103 <Field Color[] m_DefaultColors>
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
    //   31   54:invokevirtual   #208 <Method Color Color.brighter()>
    //   32   57:astore_2        

    //   33   58:iinc            4  1
    //   34   61:iload           4
    //   35   63:iload_3         
    //   36   64:icmplt          53
                if(m_backgroundColor != null)
    //*  37   67:aload_0         
    //*  38   68:getfield        #105 <Field Color m_backgroundColor>
    //*  39   71:ifnull          83
                    pc = Plot2D.checkAgainstBackground(pc, m_backgroundColor);
    //   40   74:aload_2         
    //   41   75:aload_0         
    //   42   76:getfield        #105 <Field Color m_backgroundColor>
    //   43   79:invokestatic    #214 <Method Color Plot2D.checkAgainstBackground(Color, Color)>
    //   44   82:astore_2        
                m_colorList.addElement(pc);
    //   45   83:aload_0         
    //   46   84:getfield        #110 <Field FastVector m_colorList>
    //   47   87:aload_2         
    //   48   88:invokevirtual   #122 <Method void FastVector.addElement(Object)>
            }

    //   49   91:iinc            1  1
    //   50   94:iload_1         
    //   51   95:aload_0         
    //   52   96:getfield        #68  <Field Instances m_Instances>
    //   53   99:aload_0         
    //   54  100:getfield        #179 <Field int m_cIndex>
    //   55  103:invokevirtual   #183 <Method Attribute Instances.attribute(int)>
    //   56  106:invokevirtual   #195 <Method int Attribute.numValues()>
    //   57  109:icmplt          28
        }
    //   58  112:return          
    }

    protected void setDefaultColourList(Color list[])
    {
        m_DefaultColors = list;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #103 <Field Color[] m_DefaultColors>
    //    3    5:return          
    }

    public void setColours(FastVector cols)
    {
        m_colorList = cols;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #110 <Field FastVector m_colorList>
    //    3    5:return          
    }

    protected void setNominal()
    {
        m_isNumeric = false;
    //    0    0:aload_0         
    //    1    1:iconst_0        
    //    2    2:putfield        #54  <Field boolean m_isNumeric>
        m_HorizontalPad = 0;
    //    3    5:aload_0         
    //    4    6:iconst_0        
    //    5    7:putfield        #64  <Field int m_HorizontalPad>
        setOn(true);
    //    6   10:aload_0         
    //    7   11:iconst_1        
    //    8   12:invokevirtual   #223 <Method void setOn(boolean)>
        m_oldWidth = -9000;
    //    9   15:aload_0         
    //   10   16:sipush          -9000
    //   11   19:putfield        #66  <Field int m_oldWidth>
        repaint();
    //   12   22:aload_0         
    //   13   23:invokevirtual   #226 <Method void repaint()>
    //   14   26:return          
    }

    protected void setNumeric()
    {
        m_isNumeric = true;
    //    0    0:aload_0         
    //    1    1:iconst_1        
    //    2    2:putfield        #54  <Field boolean m_isNumeric>
        double min = (1.0D / 0.0D);
    //    3    5:ldc2w           #227 <Double (1.0D / 0.0D)>
    //    4    8:dstore_1        
        double max = (-1.0D / 0.0D);
    //    5    9:ldc2w           #229 <Double (-1.0D / 0.0D)>
    //    6   12:dstore_3        
        for(int i = 0; i < m_Instances.numInstances(); i++)
    //*   7   13:iconst_0        
    //*   8   14:istore          7
    //*   9   16:goto            79
            if(!m_Instances.instance(i).isMissing(m_cIndex))
    //*  10   19:aload_0         
    //*  11   20:getfield        #68  <Field Instances m_Instances>
    //*  12   23:iload           7
    //*  13   25:invokevirtual   #234 <Method Instance Instances.instance(int)>
    //*  14   28:aload_0         
    //*  15   29:getfield        #179 <Field int m_cIndex>
    //*  16   32:invokevirtual   #240 <Method boolean Instance.isMissing(int)>
    //*  17   35:ifne            76
            {
                double value = m_Instances.instance(i).value(m_cIndex);
    //   18   38:aload_0         
    //   19   39:getfield        #68  <Field Instances m_Instances>
    //   20   42:iload           7
    //   21   44:invokevirtual   #234 <Method Instance Instances.instance(int)>
    //   22   47:aload_0         
    //   23   48:getfield        #179 <Field int m_cIndex>
    //   24   51:invokevirtual   #244 <Method double Instance.value(int)>
    //   25   54:dstore          5
                if(value < min)
    //*  26   56:dload           5
    //*  27   58:dload_1         
    //*  28   59:dcmpg           
    //*  29   60:ifge            66
                    min = value;
    //   30   63:dload           5
    //   31   65:dstore_1        
                if(value > max)
    //*  32   66:dload           5
    //*  33   68:dload_3         
    //*  34   69:dcmpl           
    //*  35   70:ifle            76
                    max = value;
    //   36   73:dload           5
    //   37   75:dstore_3        
            }

    //   38   76:iinc            7  1
    //   39   79:iload           7
    //   40   81:aload_0         
    //   41   82:getfield        #68  <Field Instances m_Instances>
    //   42   85:invokevirtual   #247 <Method int Instances.numInstances()>
    //   43   88:icmplt          19
        if(min == (1.0D / 0.0D))
    //*  44   91:dload_1         
    //*  45   92:ldc2w           #227 <Double (1.0D / 0.0D)>
    //*  46   95:dcmpl           
    //*  47   96:ifne            103
            min = max = 0.0D;
    //   48   99:dconst_0        
    //   49  100:dup2            
    //   50  101:dstore_3        
    //   51  102:dstore_1        
        m_minC = min;
    //   52  103:aload_0         
    //   53  104:dload_1         
    //   54  105:putfield        #249 <Field double m_minC>
        m_maxC = max;
    //   55  108:aload_0         
    //   56  109:dload_3         
    //   57  110:putfield        #251 <Field double m_maxC>
        int whole = (int)Math.abs(m_maxC);
    //   58  113:aload_0         
    //   59  114:getfield        #251 <Field double m_maxC>
    //   60  117:invokestatic    #257 <Method double Math.abs(double)>
    //   61  120:d2i             
    //   62  121:istore          7
        double decimal = Math.abs(m_maxC) - (double)whole;
    //   63  123:aload_0         
    //   64  124:getfield        #251 <Field double m_maxC>
    //   65  127:invokestatic    #257 <Method double Math.abs(double)>
    //   66  130:iload           7
    //   67  132:i2d             
    //   68  133:dsub            
    //   69  134:dstore          8
        int nondecimal = whole <= 0 ? 1 : (int)(Math.log(whole) / Math.log(10D));
    //   70  136:iload           7
    //   71  138:ifle            158
    //   72  141:iload           7
    //   73  143:i2d             
    //   74  144:invokestatic    #260 <Method double Math.log(double)>
    //   75  147:ldc2w           #261 <Double 10D>
    //   76  150:invokestatic    #260 <Method double Math.log(double)>
    //   77  153:ddiv            
    //   78  154:d2i             
    //   79  155:goto            159
    //   80  158:iconst_1        
    //   81  159:istore          10
        m_precisionC = decimal <= 0.0D ? 1 : (int)Math.abs(Math.log(Math.abs(m_maxC)) / Math.log(10D)) + 2;
    //   82  161:aload_0         
    //   83  162:dload           8
    //   84  164:dconst_0        
    //   85  165:dcmpl           
    //   86  166:ifle            195
    //   87  169:aload_0         
    //   88  170:getfield        #251 <Field double m_maxC>
    //   89  173:invokestatic    #257 <Method double Math.abs(double)>
    //   90  176:invokestatic    #260 <Method double Math.log(double)>
    //   91  179:ldc2w           #261 <Double 10D>
    //   92  182:invokestatic    #260 <Method double Math.log(double)>
    //   93  185:ddiv            
    //   94  186:invokestatic    #257 <Method double Math.abs(double)>
    //   95  189:d2i             
    //   96  190:iconst_2        
    //   97  191:iadd            
    //   98  192:goto            196
    //   99  195:iconst_1        
    //  100  196:putfield        #264 <Field int m_precisionC>
        if(m_precisionC > VisualizeUtils.MAX_PRECISION)
    //* 101  199:aload_0         
    //* 102  200:getfield        #264 <Field int m_precisionC>
    //* 103  203:getstatic       #269 <Field int VisualizeUtils.MAX_PRECISION>
    //* 104  206:icmple          214
            m_precisionC = 1;
    //  105  209:aload_0         
    //  106  210:iconst_1        
    //  107  211:putfield        #264 <Field int m_precisionC>
        String maxStringC = Utils.doubleToString(m_maxC, nondecimal + 1 + m_precisionC, m_precisionC);
    //  108  214:aload_0         
    //  109  215:getfield        #251 <Field double m_maxC>
    //  110  218:iload           10
    //  111  220:iconst_1        
    //  112  221:iadd            
    //  113  222:aload_0         
    //  114  223:getfield        #264 <Field int m_precisionC>
    //  115  226:iadd            
    //  116  227:aload_0         
    //  117  228:getfield        #264 <Field int m_precisionC>
    //  118  231:invokestatic    #275 <Method String Utils.doubleToString(double, int, int)>
    //  119  234:astore          11
        if(m_labelMetrics != null)
    //* 120  236:aload_0         
    //* 121  237:getfield        #60  <Field FontMetrics m_labelMetrics>
    //* 122  240:ifnull          256
            m_HorizontalPad = m_labelMetrics.stringWidth(maxStringC);
    //  123  243:aload_0         
    //  124  244:aload_0         
    //  125  245:getfield        #60  <Field FontMetrics m_labelMetrics>
    //  126  248:aload           11
    //  127  250:invokevirtual   #279 <Method int FontMetrics.stringWidth(String)>
    //  128  253:putfield        #64  <Field int m_HorizontalPad>
        whole = (int)Math.abs(m_minC);
    //  129  256:aload_0         
    //  130  257:getfield        #249 <Field double m_minC>
    //  131  260:invokestatic    #257 <Method double Math.abs(double)>
    //  132  263:d2i             
    //  133  264:istore          7
        decimal = Math.abs(m_minC) - (double)whole;
    //  134  266:aload_0         
    //  135  267:getfield        #249 <Field double m_minC>
    //  136  270:invokestatic    #257 <Method double Math.abs(double)>
    //  137  273:iload           7
    //  138  275:i2d             
    //  139  276:dsub            
    //  140  277:dstore          8
        nondecimal = whole <= 0 ? 1 : (int)(Math.log(whole) / Math.log(10D));
    //  141  279:iload           7
    //  142  281:ifle            301
    //  143  284:iload           7
    //  144  286:i2d             
    //  145  287:invokestatic    #260 <Method double Math.log(double)>
    //  146  290:ldc2w           #261 <Double 10D>
    //  147  293:invokestatic    #260 <Method double Math.log(double)>
    //  148  296:ddiv            
    //  149  297:d2i             
    //  150  298:goto            302
    //  151  301:iconst_1        
    //  152  302:istore          10
        m_precisionC = decimal <= 0.0D ? 1 : (int)Math.abs(Math.log(Math.abs(m_minC)) / Math.log(10D)) + 2;
    //  153  304:aload_0         
    //  154  305:dload           8
    //  155  307:dconst_0        
    //  156  308:dcmpl           
    //  157  309:ifle            338
    //  158  312:aload_0         
    //  159  313:getfield        #249 <Field double m_minC>
    //  160  316:invokestatic    #257 <Method double Math.abs(double)>
    //  161  319:invokestatic    #260 <Method double Math.log(double)>
    //  162  322:ldc2w           #261 <Double 10D>
    //  163  325:invokestatic    #260 <Method double Math.log(double)>
    //  164  328:ddiv            
    //  165  329:invokestatic    #257 <Method double Math.abs(double)>
    //  166  332:d2i             
    //  167  333:iconst_2        
    //  168  334:iadd            
    //  169  335:goto            339
    //  170  338:iconst_1        
    //  171  339:putfield        #264 <Field int m_precisionC>
        if(m_precisionC > VisualizeUtils.MAX_PRECISION)
    //* 172  342:aload_0         
    //* 173  343:getfield        #264 <Field int m_precisionC>
    //* 174  346:getstatic       #269 <Field int VisualizeUtils.MAX_PRECISION>
    //* 175  349:icmple          357
            m_precisionC = 1;
    //  176  352:aload_0         
    //  177  353:iconst_1        
    //  178  354:putfield        #264 <Field int m_precisionC>
        maxStringC = Utils.doubleToString(m_minC, nondecimal + 1 + m_precisionC, m_precisionC);
    //  179  357:aload_0         
    //  180  358:getfield        #249 <Field double m_minC>
    //  181  361:iload           10
    //  182  363:iconst_1        
    //  183  364:iadd            
    //  184  365:aload_0         
    //  185  366:getfield        #264 <Field int m_precisionC>
    //  186  369:iadd            
    //  187  370:aload_0         
    //  188  371:getfield        #264 <Field int m_precisionC>
    //  189  374:invokestatic    #275 <Method String Utils.doubleToString(double, int, int)>
    //  190  377:astore          11
        if(m_labelMetrics != null && m_labelMetrics.stringWidth(maxStringC) > m_HorizontalPad)
    //* 191  379:aload_0         
    //* 192  380:getfield        #60  <Field FontMetrics m_labelMetrics>
    //* 193  383:ifnull          415
    //* 194  386:aload_0         
    //* 195  387:getfield        #60  <Field FontMetrics m_labelMetrics>
    //* 196  390:aload           11
    //* 197  392:invokevirtual   #279 <Method int FontMetrics.stringWidth(String)>
    //* 198  395:aload_0         
    //* 199  396:getfield        #64  <Field int m_HorizontalPad>
    //* 200  399:icmple          415
            m_HorizontalPad = m_labelMetrics.stringWidth(maxStringC);
    //  201  402:aload_0         
    //  202  403:aload_0         
    //  203  404:getfield        #60  <Field FontMetrics m_labelMetrics>
    //  204  407:aload           11
    //  205  409:invokevirtual   #279 <Method int FontMetrics.stringWidth(String)>
    //  206  412:putfield        #64  <Field int m_HorizontalPad>
        setOn(true);
    //  207  415:aload_0         
    //  208  416:iconst_1        
    //  209  417:invokevirtual   #223 <Method void setOn(boolean)>
        repaint();
    //  210  420:aload_0         
    //  211  421:invokevirtual   #226 <Method void repaint()>
    //  212  424:return          
    }

    protected void paintNominal(Graphics gx)
    {
        setFonts(gx);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokespecial   #289 <Method void setFonts(Graphics)>
        int numClasses = m_Instances.attribute(m_cIndex).numValues();
    //    3    5:aload_0         
    //    4    6:getfield        #68  <Field Instances m_Instances>
    //    5    9:aload_0         
    //    6   10:getfield        #179 <Field int m_cIndex>
    //    7   13:invokevirtual   #183 <Method Attribute Instances.attribute(int)>
    //    8   16:invokevirtual   #195 <Method int Attribute.numValues()>
    //    9   19:istore_2        
        int maxLabelLen = 0;
    //   10   20:iconst_0        
    //   11   21:istore_3        
        int idx = 0;
    //   12   22:iconst_0        
    //   13   23:istore          4
        int w = getWidth();
    //   14   25:aload_0         
    //   15   26:invokevirtual   #292 <Method int getWidth()>
    //   16   29:istore          6
        int hf = m_labelMetrics.getAscent();
    //   17   31:aload_0         
    //   18   32:getfield        #60  <Field FontMetrics m_labelMetrics>
    //   19   35:invokevirtual   #155 <Method int FontMetrics.getAscent()>
    //   20   38:istore          7
        for(int i = 0; i < numClasses; i++)
    //*  21   40:iconst_0        
    //*  22   41:istore          8
    //*  23   43:goto            96
            if(m_Instances.attribute(m_cIndex).value(i).length() > maxLabelLen)
    //*  24   46:aload_0         
    //*  25   47:getfield        #68  <Field Instances m_Instances>
    //*  26   50:aload_0         
    //*  27   51:getfield        #179 <Field int m_cIndex>
    //*  28   54:invokevirtual   #183 <Method Attribute Instances.attribute(int)>
    //*  29   57:iload           8
    //*  30   59:invokevirtual   #295 <Method String Attribute.value(int)>
    //*  31   62:invokevirtual   #300 <Method int String.length()>
    //*  32   65:iload_3         
    //*  33   66:icmple          93
            {
                maxLabelLen = m_Instances.attribute(m_cIndex).value(i).length();
    //   34   69:aload_0         
    //   35   70:getfield        #68  <Field Instances m_Instances>
    //   36   73:aload_0         
    //   37   74:getfield        #179 <Field int m_cIndex>
    //   38   77:invokevirtual   #183 <Method Attribute Instances.attribute(int)>
    //   39   80:iload           8
    //   40   82:invokevirtual   #295 <Method String Attribute.value(int)>
    //   41   85:invokevirtual   #300 <Method int String.length()>
    //   42   88:istore_3        
                idx = i;
    //   43   89:iload           8
    //   44   91:istore          4
            }

    //   45   93:iinc            8  1
    //   46   96:iload           8
    //   47   98:iload_2         
    //   48   99:icmplt          46
        maxLabelLen = m_labelMetrics.stringWidth(m_Instances.attribute(m_cIndex).value(idx));
    //   49  102:aload_0         
    //   50  103:getfield        #60  <Field FontMetrics m_labelMetrics>
    //   51  106:aload_0         
    //   52  107:getfield        #68  <Field Instances m_Instances>
    //   53  110:aload_0         
    //   54  111:getfield        #179 <Field int m_cIndex>
    //   55  114:invokevirtual   #183 <Method Attribute Instances.attribute(int)>
    //   56  117:iload           4
    //   57  119:invokevirtual   #295 <Method String Attribute.value(int)>
    //   58  122:invokevirtual   #279 <Method int FontMetrics.stringWidth(String)>
    //   59  125:istore_3        
        int legendHeight;
        if((w - 2 * m_HorizontalPad) / (maxLabelLen + 5) >= numClasses)
    //*  60  126:iload           6
    //*  61  128:iconst_2        
    //*  62  129:aload_0         
    //*  63  130:getfield        #64  <Field int m_HorizontalPad>
    //*  64  133:imul            
    //*  65  134:isub            
    //*  66  135:iload_3         
    //*  67  136:iconst_5        
    //*  68  137:iadd            
    //*  69  138:idiv            
    //*  70  139:iload_2         
    //*  71  140:icmplt          149
            legendHeight = 1;
    //   72  143:iconst_1        
    //   73  144:istore          5
        else
    //*  74  146:goto            152
            legendHeight = 2;
    //   75  149:iconst_2        
    //   76  150:istore          5
        int x = m_HorizontalPad;
    //   77  152:aload_0         
    //   78  153:getfield        #64  <Field int m_HorizontalPad>
    //   79  156:istore          8
        int y = 1 + hf;
    //   80  158:iconst_1        
    //   81  159:iload           7
    //   82  161:iadd            
    //   83  162:istore          9
        int numToDo = legendHeight != 1 ? numClasses / 2 : numClasses;
    //   84  164:iload           5
    //   85  166:iconst_1        
    //   86  167:icmpne          174
    //   87  170:iload_2         
    //   88  171:goto            177
    //   89  174:iload_2         
    //   90  175:iconst_2        
    //   91  176:idiv            
    //   92  177:istore          13
        for(int i = 0; i < numToDo; i++)
    //*  93  179:iconst_0        
    //*  94  180:istore          14
    //*  95  182:goto            576
        {
            gx.setColor((Color)m_colorList.elementAt(i));
    //   96  185:aload_1         
    //   97  186:aload_0         
    //   98  187:getfield        #110 <Field FastVector m_colorList>
    //   99  190:iload           14
    //  100  192:invokevirtual   #304 <Method Object FastVector.elementAt(int)>
    //  101  195:checkcast       #77  <Class Color>
    //  102  198:invokevirtual   #307 <Method void Graphics.setColor(Color)>
            if(numToDo * maxLabelLen > w - m_HorizontalPad * 2)
    //* 103  201:iload           13
    //* 104  203:iload_3         
    //* 105  204:imul            
    //* 106  205:iload           6
    //* 107  207:aload_0         
    //* 108  208:getfield        #64  <Field int m_HorizontalPad>
    //* 109  211:iconst_2        
    //* 110  212:imul            
    //* 111  213:isub            
    //* 112  214:icmple          452
            {
                String val = m_Instances.attribute(m_cIndex).value(i);
    //  113  217:aload_0         
    //  114  218:getfield        #68  <Field Instances m_Instances>
    //  115  221:aload_0         
    //  116  222:getfield        #179 <Field int m_cIndex>
    //  117  225:invokevirtual   #183 <Method Attribute Instances.attribute(int)>
    //  118  228:iload           14
    //  119  230:invokevirtual   #295 <Method String Attribute.value(int)>
    //  120  233:astore          15
                int sw = m_labelMetrics.stringWidth(val);
    //  121  235:aload_0         
    //  122  236:getfield        #60  <Field FontMetrics m_labelMetrics>
    //  123  239:aload           15
    //  124  241:invokevirtual   #279 <Method int FontMetrics.stringWidth(String)>
    //  125  244:istore          16
                int rm = 0;
    //  126  246:iconst_0        
    //  127  247:istore          17
                if(sw > (w - m_HorizontalPad * 2) / numToDo)
    //* 128  249:iload           16
    //* 129  251:iload           6
    //* 130  253:aload_0         
    //* 131  254:getfield        #64  <Field int m_HorizontalPad>
    //* 132  257:iconst_2        
    //* 133  258:imul            
    //* 134  259:isub            
    //* 135  260:iload           13
    //* 136  262:idiv            
    //* 137  263:icmple          350
                {
                    int incr = sw / val.length();
    //  138  266:iload           16
    //  139  268:aload           15
    //  140  270:invokevirtual   #300 <Method int String.length()>
    //  141  273:idiv            
    //  142  274:istore          18
                    rm = (sw - (w - m_HorizontalPad * 2) / numToDo) / incr;
    //  143  276:iload           16
    //  144  278:iload           6
    //  145  280:aload_0         
    //  146  281:getfield        #64  <Field int m_HorizontalPad>
    //  147  284:iconst_2        
    //  148  285:imul            
    //  149  286:isub            
    //  150  287:iload           13
    //  151  289:idiv            
    //  152  290:isub            
    //  153  291:iload           18
    //  154  293:idiv            
    //  155  294:istore          17
                    if(rm <= 0)
    //* 156  296:iload           17
    //* 157  298:ifgt            304
                        rm = 0;
    //  158  301:iconst_0        
    //  159  302:istore          17
                    if(rm >= val.length())
    //* 160  304:iload           17
    //* 161  306:aload           15
    //* 162  308:invokevirtual   #300 <Method int String.length()>
    //* 163  311:icmplt          323
                        rm = val.length() - 1;
    //  164  314:aload           15
    //  165  316:invokevirtual   #300 <Method int String.length()>
    //  166  319:iconst_1        
    //  167  320:isub            
    //  168  321:istore          17
                    val = val.substring(0, val.length() - rm);
    //  169  323:aload           15
    //  170  325:iconst_0        
    //  171  326:aload           15
    //  172  328:invokevirtual   #300 <Method int String.length()>
    //  173  331:iload           17
    //  174  333:isub            
    //  175  334:invokevirtual   #311 <Method String String.substring(int, int)>
    //  176  337:astore          15
                    sw = m_labelMetrics.stringWidth(val);
    //  177  339:aload_0         
    //  178  340:getfield        #60  <Field FontMetrics m_labelMetrics>
    //  179  343:aload           15
    //  180  345:invokevirtual   #279 <Method int FontMetrics.stringWidth(String)>
    //  181  348:istore          16
                }
                NomLabel jj = new NomLabel(val, i);
    //  182  350:new             #313 <Class ClassPanel$NomLabel>
    //  183  353:dup             
    //  184  354:aload_0         
    //  185  355:aload           15
    //  186  357:iload           14
    //  187  359:invokespecial   #316 <Method void ClassPanel$NomLabel(ClassPanel, String, int)>
    //  188  362:astore          18
                jj.setFont(gx.getFont());
    //  189  364:aload           18
    //  190  366:aload_1         
    //  191  367:invokevirtual   #320 <Method Font Graphics.getFont()>
    //  192  370:invokevirtual   #321 <Method void ClassPanel$NomLabel.setFont(Font)>
                jj.setSize(m_labelMetrics.stringWidth(jj.getText()), m_labelMetrics.getAscent() + 4);
    //  193  373:aload           18
    //  194  375:aload_0         
    //  195  376:getfield        #60  <Field FontMetrics m_labelMetrics>
    //  196  379:aload           18
    //  197  381:invokevirtual   #325 <Method String ClassPanel$NomLabel.getText()>
    //  198  384:invokevirtual   #279 <Method int FontMetrics.stringWidth(String)>
    //  199  387:aload_0         
    //  200  388:getfield        #60  <Field FontMetrics m_labelMetrics>
    //  201  391:invokevirtual   #155 <Method int FontMetrics.getAscent()>
    //  202  394:iconst_4        
    //  203  395:iadd            
    //  204  396:invokevirtual   #329 <Method void ClassPanel$NomLabel.setSize(int, int)>
                add(jj);
    //  205  399:aload_0         
    //  206  400:aload           18
    //  207  402:invokevirtual   #333 <Method Component add(Component)>
    //  208  405:pop             
                jj.setLocation(x, y);
    //  209  406:aload           18
    //  210  408:iload           8
    //  211  410:iload           9
    //  212  412:invokevirtual   #336 <Method void ClassPanel$NomLabel.setLocation(int, int)>
                jj.setForeground((Color)m_colorList.elementAt(i % m_colorList.size()));
    //  213  415:aload           18
    //  214  417:aload_0         
    //  215  418:getfield        #110 <Field FastVector m_colorList>
    //  216  421:iload           14
    //  217  423:aload_0         
    //  218  424:getfield        #110 <Field FastVector m_colorList>
    //  219  427:invokevirtual   #114 <Method int FastVector.size()>
    //  220  430:irem            
    //  221  431:invokevirtual   #304 <Method Object FastVector.elementAt(int)>
    //  222  434:checkcast       #77  <Class Color>
    //  223  437:invokevirtual   #339 <Method void ClassPanel$NomLabel.setForeground(Color)>
                x += sw + 2;
    //  224  440:iload           8
    //  225  442:iload           16
    //  226  444:iconst_2        
    //  227  445:iadd            
    //  228  446:iadd            
    //  229  447:istore          8
            } else
    //* 230  449:goto            573
            {
                NomLabel jj = new NomLabel(m_Instances.attribute(m_cIndex).value(i), i);
    //  231  452:new             #313 <Class ClassPanel$NomLabel>
    //  232  455:dup             
    //  233  456:aload_0         
    //  234  457:aload_0         
    //  235  458:getfield        #68  <Field Instances m_Instances>
    //  236  461:aload_0         
    //  237  462:getfield        #179 <Field int m_cIndex>
    //  238  465:invokevirtual   #183 <Method Attribute Instances.attribute(int)>
    //  239  468:iload           14
    //  240  470:invokevirtual   #295 <Method String Attribute.value(int)>
    //  241  473:iload           14
    //  242  475:invokespecial   #316 <Method void ClassPanel$NomLabel(ClassPanel, String, int)>
    //  243  478:astore          15
                jj.setFont(gx.getFont());
    //  244  480:aload           15
    //  245  482:aload_1         
    //  246  483:invokevirtual   #320 <Method Font Graphics.getFont()>
    //  247  486:invokevirtual   #321 <Method void ClassPanel$NomLabel.setFont(Font)>
                jj.setSize(m_labelMetrics.stringWidth(jj.getText()), m_labelMetrics.getAscent() + 4);
    //  248  489:aload           15
    //  249  491:aload_0         
    //  250  492:getfield        #60  <Field FontMetrics m_labelMetrics>
    //  251  495:aload           15
    //  252  497:invokevirtual   #325 <Method String ClassPanel$NomLabel.getText()>
    //  253  500:invokevirtual   #279 <Method int FontMetrics.stringWidth(String)>
    //  254  503:aload_0         
    //  255  504:getfield        #60  <Field FontMetrics m_labelMetrics>
    //  256  507:invokevirtual   #155 <Method int FontMetrics.getAscent()>
    //  257  510:iconst_4        
    //  258  511:iadd            
    //  259  512:invokevirtual   #329 <Method void ClassPanel$NomLabel.setSize(int, int)>
                add(jj);
    //  260  515:aload_0         
    //  261  516:aload           15
    //  262  518:invokevirtual   #333 <Method Component add(Component)>
    //  263  521:pop             
                jj.setLocation(x, y);
    //  264  522:aload           15
    //  265  524:iload           8
    //  266  526:iload           9
    //  267  528:invokevirtual   #336 <Method void ClassPanel$NomLabel.setLocation(int, int)>
                jj.setForeground((Color)m_colorList.elementAt(i % m_colorList.size()));
    //  268  531:aload           15
    //  269  533:aload_0         
    //  270  534:getfield        #110 <Field FastVector m_colorList>
    //  271  537:iload           14
    //  272  539:aload_0         
    //  273  540:getfield        #110 <Field FastVector m_colorList>
    //  274  543:invokevirtual   #114 <Method int FastVector.size()>
    //  275  546:irem            
    //  276  547:invokevirtual   #304 <Method Object FastVector.elementAt(int)>
    //  277  550:checkcast       #77  <Class Color>
    //  278  553:invokevirtual   #339 <Method void ClassPanel$NomLabel.setForeground(Color)>
                x += (w - m_HorizontalPad * 2) / numToDo;
    //  279  556:iload           8
    //  280  558:iload           6
    //  281  560:aload_0         
    //  282  561:getfield        #64  <Field int m_HorizontalPad>
    //  283  564:iconst_2        
    //  284  565:imul            
    //  285  566:isub            
    //  286  567:iload           13
    //  287  569:idiv            
    //  288  570:iadd            
    //  289  571:istore          8
            }
        }

    //  290  573:iinc            14  1
    //  291  576:iload           14
    //  292  578:iload           13
    //  293  580:icmplt          185
        x = m_HorizontalPad;
    //  294  583:aload_0         
    //  295  584:getfield        #64  <Field int m_HorizontalPad>
    //  296  587:istore          8
        y = 1 + hf + 5 + hf;
    //  297  589:iconst_1        
    //  298  590:iload           7
    //  299  592:iadd            
    //  300  593:iconst_5        
    //  301  594:iadd            
    //  302  595:iload           7
    //  303  597:iadd            
    //  304  598:istore          9
        for(int i = numToDo; i < numClasses; i++)
    //* 305  600:iload           13
    //* 306  602:istore          14
    //* 307  604:goto            1010
        {
            gx.setColor((Color)m_colorList.elementAt(i));
    //  308  607:aload_1         
    //  309  608:aload_0         
    //  310  609:getfield        #110 <Field FastVector m_colorList>
    //  311  612:iload           14
    //  312  614:invokevirtual   #304 <Method Object FastVector.elementAt(int)>
    //  313  617:checkcast       #77  <Class Color>
    //  314  620:invokevirtual   #307 <Method void Graphics.setColor(Color)>
            if(((numClasses - numToDo) + 1) * maxLabelLen > w - m_HorizontalPad * 2)
    //* 315  623:iload_2         
    //* 316  624:iload           13
    //* 317  626:isub            
    //* 318  627:iconst_1        
    //* 319  628:iadd            
    //* 320  629:iload_3         
    //* 321  630:imul            
    //* 322  631:iload           6
    //* 323  633:aload_0         
    //* 324  634:getfield        #64  <Field int m_HorizontalPad>
    //* 325  637:iconst_2        
    //* 326  638:imul            
    //* 327  639:isub            
    //* 328  640:icmple          884
            {
                String val = m_Instances.attribute(m_cIndex).value(i);
    //  329  643:aload_0         
    //  330  644:getfield        #68  <Field Instances m_Instances>
    //  331  647:aload_0         
    //  332  648:getfield        #179 <Field int m_cIndex>
    //  333  651:invokevirtual   #183 <Method Attribute Instances.attribute(int)>
    //  334  654:iload           14
    //  335  656:invokevirtual   #295 <Method String Attribute.value(int)>
    //  336  659:astore          15
                int sw = m_labelMetrics.stringWidth(val);
    //  337  661:aload_0         
    //  338  662:getfield        #60  <Field FontMetrics m_labelMetrics>
    //  339  665:aload           15
    //  340  667:invokevirtual   #279 <Method int FontMetrics.stringWidth(String)>
    //  341  670:istore          16
                int rm = 0;
    //  342  672:iconst_0        
    //  343  673:istore          17
                if(sw > (w - m_HorizontalPad * 2) / ((numClasses - numToDo) + 1))
    //* 344  675:iload           16
    //* 345  677:iload           6
    //* 346  679:aload_0         
    //* 347  680:getfield        #64  <Field int m_HorizontalPad>
    //* 348  683:iconst_2        
    //* 349  684:imul            
    //* 350  685:isub            
    //* 351  686:iload_2         
    //* 352  687:iload           13
    //* 353  689:isub            
    //* 354  690:iconst_1        
    //* 355  691:iadd            
    //* 356  692:idiv            
    //* 357  693:icmple          782
                {
                    int incr = sw / val.length();
    //  358  696:iload           16
    //  359  698:aload           15
    //  360  700:invokevirtual   #300 <Method int String.length()>
    //  361  703:idiv            
    //  362  704:istore          18
                    rm = (sw - (w - m_HorizontalPad * 2) / (numClasses - numToDo)) / incr;
    //  363  706:iload           16
    //  364  708:iload           6
    //  365  710:aload_0         
    //  366  711:getfield        #64  <Field int m_HorizontalPad>
    //  367  714:iconst_2        
    //  368  715:imul            
    //  369  716:isub            
    //  370  717:iload_2         
    //  371  718:iload           13
    //  372  720:isub            
    //  373  721:idiv            
    //  374  722:isub            
    //  375  723:iload           18
    //  376  725:idiv            
    //  377  726:istore          17
                    if(rm <= 0)
    //* 378  728:iload           17
    //* 379  730:ifgt            736
                        rm = 0;
    //  380  733:iconst_0        
    //  381  734:istore          17
                    if(rm >= val.length())
    //* 382  736:iload           17
    //* 383  738:aload           15
    //* 384  740:invokevirtual   #300 <Method int String.length()>
    //* 385  743:icmplt          755
                        rm = val.length() - 1;
    //  386  746:aload           15
    //  387  748:invokevirtual   #300 <Method int String.length()>
    //  388  751:iconst_1        
    //  389  752:isub            
    //  390  753:istore          17
                    val = val.substring(0, val.length() - rm);
    //  391  755:aload           15
    //  392  757:iconst_0        
    //  393  758:aload           15
    //  394  760:invokevirtual   #300 <Method int String.length()>
    //  395  763:iload           17
    //  396  765:isub            
    //  397  766:invokevirtual   #311 <Method String String.substring(int, int)>
    //  398  769:astore          15
                    sw = m_labelMetrics.stringWidth(val);
    //  399  771:aload_0         
    //  400  772:getfield        #60  <Field FontMetrics m_labelMetrics>
    //  401  775:aload           15
    //  402  777:invokevirtual   #279 <Method int FontMetrics.stringWidth(String)>
    //  403  780:istore          16
                }
                NomLabel jj = new NomLabel(val, i);
    //  404  782:new             #313 <Class ClassPanel$NomLabel>
    //  405  785:dup             
    //  406  786:aload_0         
    //  407  787:aload           15
    //  408  789:iload           14
    //  409  791:invokespecial   #316 <Method void ClassPanel$NomLabel(ClassPanel, String, int)>
    //  410  794:astore          18
                jj.setFont(gx.getFont());
    //  411  796:aload           18
    //  412  798:aload_1         
    //  413  799:invokevirtual   #320 <Method Font Graphics.getFont()>
    //  414  802:invokevirtual   #321 <Method void ClassPanel$NomLabel.setFont(Font)>
                jj.setSize(m_labelMetrics.stringWidth(jj.getText()), m_labelMetrics.getAscent() + 4);
    //  415  805:aload           18
    //  416  807:aload_0         
    //  417  808:getfield        #60  <Field FontMetrics m_labelMetrics>
    //  418  811:aload           18
    //  419  813:invokevirtual   #325 <Method String ClassPanel$NomLabel.getText()>
    //  420  816:invokevirtual   #279 <Method int FontMetrics.stringWidth(String)>
    //  421  819:aload_0         
    //  422  820:getfield        #60  <Field FontMetrics m_labelMetrics>
    //  423  823:invokevirtual   #155 <Method int FontMetrics.getAscent()>
    //  424  826:iconst_4        
    //  425  827:iadd            
    //  426  828:invokevirtual   #329 <Method void ClassPanel$NomLabel.setSize(int, int)>
                add(jj);
    //  427  831:aload_0         
    //  428  832:aload           18
    //  429  834:invokevirtual   #333 <Method Component add(Component)>
    //  430  837:pop             
                jj.setLocation(x, y);
    //  431  838:aload           18
    //  432  840:iload           8
    //  433  842:iload           9
    //  434  844:invokevirtual   #336 <Method void ClassPanel$NomLabel.setLocation(int, int)>
                jj.setForeground((Color)m_colorList.elementAt(i % m_colorList.size()));
    //  435  847:aload           18
    //  436  849:aload_0         
    //  437  850:getfield        #110 <Field FastVector m_colorList>
    //  438  853:iload           14
    //  439  855:aload_0         
    //  440  856:getfield        #110 <Field FastVector m_colorList>
    //  441  859:invokevirtual   #114 <Method int FastVector.size()>
    //  442  862:irem            
    //  443  863:invokevirtual   #304 <Method Object FastVector.elementAt(int)>
    //  444  866:checkcast       #77  <Class Color>
    //  445  869:invokevirtual   #339 <Method void ClassPanel$NomLabel.setForeground(Color)>
                x += sw + 2;
    //  446  872:iload           8
    //  447  874:iload           16
    //  448  876:iconst_2        
    //  449  877:iadd            
    //  450  878:iadd            
    //  451  879:istore          8
            } else
    //* 452  881:goto            1007
            {
                NomLabel jj = new NomLabel(m_Instances.attribute(m_cIndex).value(i), i);
    //  453  884:new             #313 <Class ClassPanel$NomLabel>
    //  454  887:dup             
    //  455  888:aload_0         
    //  456  889:aload_0         
    //  457  890:getfield        #68  <Field Instances m_Instances>
    //  458  893:aload_0         
    //  459  894:getfield        #179 <Field int m_cIndex>
    //  460  897:invokevirtual   #183 <Method Attribute Instances.attribute(int)>
    //  461  900:iload           14
    //  462  902:invokevirtual   #295 <Method String Attribute.value(int)>
    //  463  905:iload           14
    //  464  907:invokespecial   #316 <Method void ClassPanel$NomLabel(ClassPanel, String, int)>
    //  465  910:astore          15
                jj.setFont(gx.getFont());
    //  466  912:aload           15
    //  467  914:aload_1         
    //  468  915:invokevirtual   #320 <Method Font Graphics.getFont()>
    //  469  918:invokevirtual   #321 <Method void ClassPanel$NomLabel.setFont(Font)>
                jj.setSize(m_labelMetrics.stringWidth(jj.getText()), m_labelMetrics.getAscent() + 4);
    //  470  921:aload           15
    //  471  923:aload_0         
    //  472  924:getfield        #60  <Field FontMetrics m_labelMetrics>
    //  473  927:aload           15
    //  474  929:invokevirtual   #325 <Method String ClassPanel$NomLabel.getText()>
    //  475  932:invokevirtual   #279 <Method int FontMetrics.stringWidth(String)>
    //  476  935:aload_0         
    //  477  936:getfield        #60  <Field FontMetrics m_labelMetrics>
    //  478  939:invokevirtual   #155 <Method int FontMetrics.getAscent()>
    //  479  942:iconst_4        
    //  480  943:iadd            
    //  481  944:invokevirtual   #329 <Method void ClassPanel$NomLabel.setSize(int, int)>
                add(jj);
    //  482  947:aload_0         
    //  483  948:aload           15
    //  484  950:invokevirtual   #333 <Method Component add(Component)>
    //  485  953:pop             
                jj.setLocation(x, y);
    //  486  954:aload           15
    //  487  956:iload           8
    //  488  958:iload           9
    //  489  960:invokevirtual   #336 <Method void ClassPanel$NomLabel.setLocation(int, int)>
                jj.setForeground((Color)m_colorList.elementAt(i % m_colorList.size()));
    //  490  963:aload           15
    //  491  965:aload_0         
    //  492  966:getfield        #110 <Field FastVector m_colorList>
    //  493  969:iload           14
    //  494  971:aload_0         
    //  495  972:getfield        #110 <Field FastVector m_colorList>
    //  496  975:invokevirtual   #114 <Method int FastVector.size()>
    //  497  978:irem            
    //  498  979:invokevirtual   #304 <Method Object FastVector.elementAt(int)>
    //  499  982:checkcast       #77  <Class Color>
    //  500  985:invokevirtual   #339 <Method void ClassPanel$NomLabel.setForeground(Color)>
                x += (w - m_HorizontalPad * 2) / (numClasses - numToDo);
    //  501  988:iload           8
    //  502  990:iload           6
    //  503  992:aload_0         
    //  504  993:getfield        #64  <Field int m_HorizontalPad>
    //  505  996:iconst_2        
    //  506  997:imul            
    //  507  998:isub            
    //  508  999:iload_2         
    //  509 1000:iload           13
    //  510 1002:isub            
    //  511 1003:idiv            
    //  512 1004:iadd            
    //  513 1005:istore          8
            }
        }

    //  514 1007:iinc            14  1
    //  515 1010:iload           14
    //  516 1012:iload_2         
    //  517 1013:icmplt          607
    //  518 1016:return          
    }

    protected void paintNumeric(Graphics gx)
    {
        setFonts(gx);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokespecial   #289 <Method void setFonts(Graphics)>
        if(m_HorizontalPad == 0)
    //*   3    5:aload_0         
    //*   4    6:getfield        #64  <Field int m_HorizontalPad>
    //*   5    9:ifne            20
            setCindex(m_cIndex);
    //    6   12:aload_0         
    //    7   13:aload_0         
    //    8   14:getfield        #179 <Field int m_cIndex>
    //    9   17:invokevirtual   #356 <Method void setCindex(int)>
        int w = getWidth();
    //   10   20:aload_0         
    //   11   21:invokevirtual   #292 <Method int getWidth()>
    //   12   24:istore_2        
        double rs = 15D;
    //   13   25:ldc2w           #357 <Double 15D>
    //   14   28:dstore_3        
        double incr = 240D / (double)(w - m_HorizontalPad * 2);
    //   15   29:ldc2w           #359 <Double 240D>
    //   16   32:iload_2         
    //   17   33:aload_0         
    //   18   34:getfield        #64  <Field int m_HorizontalPad>
    //   19   37:iconst_2        
    //   20   38:imul            
    //   21   39:isub            
    //   22   40:i2d             
    //   23   41:ddiv            
    //   24   42:dstore          5
        int hf = m_labelMetrics.getAscent();
    //   25   44:aload_0         
    //   26   45:getfield        #60  <Field FontMetrics m_labelMetrics>
    //   27   48:invokevirtual   #155 <Method int FontMetrics.getAscent()>
    //   28   51:istore          7
        for(int i = m_HorizontalPad; i < w - m_HorizontalPad; i++)
    //*  29   53:aload_0         
    //*  30   54:getfield        #64  <Field int m_HorizontalPad>
    //*  31   57:istore          8
    //*  32   59:goto            106
        {
            Color c = new Color((int)rs, 150, (int)(255D - rs));
    //   33   62:new             #77  <Class Color>
    //   34   65:dup             
    //   35   66:dload_3         
    //   36   67:d2i             
    //   37   68:sipush          150
    //   38   71:ldc2w           #361 <Double 255D>
    //   39   74:dload_3         
    //   40   75:dsub            
    //   41   76:d2i             
    //   42   77:invokespecial   #95  <Method void Color(int, int, int)>
    //   43   80:astore          9
            gx.setColor(c);
    //   44   82:aload_1         
    //   45   83:aload           9
    //   46   85:invokevirtual   #307 <Method void Graphics.setColor(Color)>
            gx.drawLine(i, 0, i, 5);
    //   47   88:aload_1         
    //   48   89:iload           8
    //   49   91:iconst_0        
    //   50   92:iload           8
    //   51   94:iconst_5        
    //   52   95:invokevirtual   #366 <Method void Graphics.drawLine(int, int, int, int)>
            rs += incr;
    //   53   98:dload_3         
    //   54   99:dload           5
    //   55  101:dadd            
    //   56  102:dstore_3        
        }

    //   57  103:iinc            8  1
    //   58  106:iload           8
    //   59  108:iload_2         
    //   60  109:aload_0         
    //   61  110:getfield        #64  <Field int m_HorizontalPad>
    //   62  113:isub            
    //   63  114:icmplt          62
        int whole = (int)Math.abs(m_maxC);
    //   64  117:aload_0         
    //   65  118:getfield        #251 <Field double m_maxC>
    //   66  121:invokestatic    #257 <Method double Math.abs(double)>
    //   67  124:d2i             
    //   68  125:istore          8
        double decimal = Math.abs(m_maxC) - (double)whole;
    //   69  127:aload_0         
    //   70  128:getfield        #251 <Field double m_maxC>
    //   71  131:invokestatic    #257 <Method double Math.abs(double)>
    //   72  134:iload           8
    //   73  136:i2d             
    //   74  137:dsub            
    //   75  138:dstore          9
        int nondecimal = whole <= 0 ? 1 : (int)(Math.log(whole) / Math.log(10D));
    //   76  140:iload           8
    //   77  142:ifle            162
    //   78  145:iload           8
    //   79  147:i2d             
    //   80  148:invokestatic    #260 <Method double Math.log(double)>
    //   81  151:ldc2w           #261 <Double 10D>
    //   82  154:invokestatic    #260 <Method double Math.log(double)>
    //   83  157:ddiv            
    //   84  158:d2i             
    //   85  159:goto            163
    //   86  162:iconst_1        
    //   87  163:istore          11
        m_precisionC = decimal <= 0.0D ? 1 : (int)Math.abs(Math.log(Math.abs(m_maxC)) / Math.log(10D)) + 2;
    //   88  165:aload_0         
    //   89  166:dload           9
    //   90  168:dconst_0        
    //   91  169:dcmpl           
    //   92  170:ifle            199
    //   93  173:aload_0         
    //   94  174:getfield        #251 <Field double m_maxC>
    //   95  177:invokestatic    #257 <Method double Math.abs(double)>
    //   96  180:invokestatic    #260 <Method double Math.log(double)>
    //   97  183:ldc2w           #261 <Double 10D>
    //   98  186:invokestatic    #260 <Method double Math.log(double)>
    //   99  189:ddiv            
    //  100  190:invokestatic    #257 <Method double Math.abs(double)>
    //  101  193:d2i             
    //  102  194:iconst_2        
    //  103  195:iadd            
    //  104  196:goto            200
    //  105  199:iconst_1        
    //  106  200:putfield        #264 <Field int m_precisionC>
        if(m_precisionC > VisualizeUtils.MAX_PRECISION)
    //* 107  203:aload_0         
    //* 108  204:getfield        #264 <Field int m_precisionC>
    //* 109  207:getstatic       #269 <Field int VisualizeUtils.MAX_PRECISION>
    //* 110  210:icmple          218
            m_precisionC = 1;
    //  111  213:aload_0         
    //  112  214:iconst_1        
    //  113  215:putfield        #264 <Field int m_precisionC>
        String maxStringC = Utils.doubleToString(m_maxC, nondecimal + 1 + m_precisionC, m_precisionC);
    //  114  218:aload_0         
    //  115  219:getfield        #251 <Field double m_maxC>
    //  116  222:iload           11
    //  117  224:iconst_1        
    //  118  225:iadd            
    //  119  226:aload_0         
    //  120  227:getfield        #264 <Field int m_precisionC>
    //  121  230:iadd            
    //  122  231:aload_0         
    //  123  232:getfield        #264 <Field int m_precisionC>
    //  124  235:invokestatic    #275 <Method String Utils.doubleToString(double, int, int)>
    //  125  238:astore          12
        int mswc = m_labelMetrics.stringWidth(maxStringC);
    //  126  240:aload_0         
    //  127  241:getfield        #60  <Field FontMetrics m_labelMetrics>
    //  128  244:aload           12
    //  129  246:invokevirtual   #279 <Method int FontMetrics.stringWidth(String)>
    //  130  249:istore          13
        int tmsc = mswc;
    //  131  251:iload           13
    //  132  253:istore          14
        if(w > 2 * tmsc)
    //* 133  255:iload_2         
    //* 134  256:iconst_2        
    //* 135  257:iload           14
    //* 136  259:imul            
    //* 137  260:icmple          723
        {
            gx.setColor(Color.black);
    //  138  263:aload_1         
    //  139  264:getstatic       #369 <Field Color Color.black>
    //  140  267:invokevirtual   #307 <Method void Graphics.setColor(Color)>
            gx.drawLine(m_HorizontalPad, 10, w - m_HorizontalPad, 10);
    //  141  270:aload_1         
    //  142  271:aload_0         
    //  143  272:getfield        #64  <Field int m_HorizontalPad>
    //  144  275:bipush          10
    //  145  277:iload_2         
    //  146  278:aload_0         
    //  147  279:getfield        #64  <Field int m_HorizontalPad>
    //  148  282:isub            
    //  149  283:bipush          10
    //  150  285:invokevirtual   #366 <Method void Graphics.drawLine(int, int, int, int)>
            gx.drawLine(w - m_HorizontalPad, 10, w - m_HorizontalPad, 15);
    //  151  288:aload_1         
    //  152  289:iload_2         
    //  153  290:aload_0         
    //  154  291:getfield        #64  <Field int m_HorizontalPad>
    //  155  294:isub            
    //  156  295:bipush          10
    //  157  297:iload_2         
    //  158  298:aload_0         
    //  159  299:getfield        #64  <Field int m_HorizontalPad>
    //  160  302:isub            
    //  161  303:bipush          15
    //  162  305:invokevirtual   #366 <Method void Graphics.drawLine(int, int, int, int)>
            gx.drawString(maxStringC, w - m_HorizontalPad - mswc / 2, 15 + hf);
    //  163  308:aload_1         
    //  164  309:aload           12
    //  165  311:iload_2         
    //  166  312:aload_0         
    //  167  313:getfield        #64  <Field int m_HorizontalPad>
    //  168  316:isub            
    //  169  317:iload           13
    //  170  319:iconst_2        
    //  171  320:idiv            
    //  172  321:isub            
    //  173  322:bipush          15
    //  174  324:iload           7
    //  175  326:iadd            
    //  176  327:invokevirtual   #372 <Method void Graphics.drawString(String, int, int)>
            gx.drawLine(m_HorizontalPad, 10, m_HorizontalPad, 15);
    //  177  330:aload_1         
    //  178  331:aload_0         
    //  179  332:getfield        #64  <Field int m_HorizontalPad>
    //  180  335:bipush          10
    //  181  337:aload_0         
    //  182  338:getfield        #64  <Field int m_HorizontalPad>
    //  183  341:bipush          15
    //  184  343:invokevirtual   #366 <Method void Graphics.drawLine(int, int, int, int)>
            whole = (int)Math.abs(m_minC);
    //  185  346:aload_0         
    //  186  347:getfield        #249 <Field double m_minC>
    //  187  350:invokestatic    #257 <Method double Math.abs(double)>
    //  188  353:d2i             
    //  189  354:istore          8
            decimal = Math.abs(m_minC) - (double)whole;
    //  190  356:aload_0         
    //  191  357:getfield        #249 <Field double m_minC>
    //  192  360:invokestatic    #257 <Method double Math.abs(double)>
    //  193  363:iload           8
    //  194  365:i2d             
    //  195  366:dsub            
    //  196  367:dstore          9
            nondecimal = whole <= 0 ? 1 : (int)(Math.log(whole) / Math.log(10D));
    //  197  369:iload           8
    //  198  371:ifle            391
    //  199  374:iload           8
    //  200  376:i2d             
    //  201  377:invokestatic    #260 <Method double Math.log(double)>
    //  202  380:ldc2w           #261 <Double 10D>
    //  203  383:invokestatic    #260 <Method double Math.log(double)>
    //  204  386:ddiv            
    //  205  387:d2i             
    //  206  388:goto            392
    //  207  391:iconst_1        
    //  208  392:istore          11
            m_precisionC = decimal <= 0.0D ? 1 : (int)Math.abs(Math.log(Math.abs(m_minC)) / Math.log(10D)) + 2;
    //  209  394:aload_0         
    //  210  395:dload           9
    //  211  397:dconst_0        
    //  212  398:dcmpl           
    //  213  399:ifle            428
    //  214  402:aload_0         
    //  215  403:getfield        #249 <Field double m_minC>
    //  216  406:invokestatic    #257 <Method double Math.abs(double)>
    //  217  409:invokestatic    #260 <Method double Math.log(double)>
    //  218  412:ldc2w           #261 <Double 10D>
    //  219  415:invokestatic    #260 <Method double Math.log(double)>
    //  220  418:ddiv            
    //  221  419:invokestatic    #257 <Method double Math.abs(double)>
    //  222  422:d2i             
    //  223  423:iconst_2        
    //  224  424:iadd            
    //  225  425:goto            429
    //  226  428:iconst_1        
    //  227  429:putfield        #264 <Field int m_precisionC>
            if(m_precisionC > VisualizeUtils.MAX_PRECISION)
    //* 228  432:aload_0         
    //* 229  433:getfield        #264 <Field int m_precisionC>
    //* 230  436:getstatic       #269 <Field int VisualizeUtils.MAX_PRECISION>
    //* 231  439:icmple          447
                m_precisionC = 1;
    //  232  442:aload_0         
    //  233  443:iconst_1        
    //  234  444:putfield        #264 <Field int m_precisionC>
            maxStringC = Utils.doubleToString(m_minC, nondecimal + 1 + m_precisionC, m_precisionC);
    //  235  447:aload_0         
    //  236  448:getfield        #249 <Field double m_minC>
    //  237  451:iload           11
    //  238  453:iconst_1        
    //  239  454:iadd            
    //  240  455:aload_0         
    //  241  456:getfield        #264 <Field int m_precisionC>
    //  242  459:iadd            
    //  243  460:aload_0         
    //  244  461:getfield        #264 <Field int m_precisionC>
    //  245  464:invokestatic    #275 <Method String Utils.doubleToString(double, int, int)>
    //  246  467:astore          12
            mswc = m_labelMetrics.stringWidth(maxStringC);
    //  247  469:aload_0         
    //  248  470:getfield        #60  <Field FontMetrics m_labelMetrics>
    //  249  473:aload           12
    //  250  475:invokevirtual   #279 <Method int FontMetrics.stringWidth(String)>
    //  251  478:istore          13
            gx.drawString(maxStringC, m_HorizontalPad - mswc / 2, 15 + hf);
    //  252  480:aload_1         
    //  253  481:aload           12
    //  254  483:aload_0         
    //  255  484:getfield        #64  <Field int m_HorizontalPad>
    //  256  487:iload           13
    //  257  489:iconst_2        
    //  258  490:idiv            
    //  259  491:isub            
    //  260  492:bipush          15
    //  261  494:iload           7
    //  262  496:iadd            
    //  263  497:invokevirtual   #372 <Method void Graphics.drawString(String, int, int)>
            if(w > 3 * tmsc)
    //* 264  500:iload_2         
    //* 265  501:iconst_3        
    //* 266  502:iload           14
    //* 267  504:imul            
    //* 268  505:icmple          723
            {
                double mid = m_minC + (m_maxC - m_minC) / 2D;
    //  269  508:aload_0         
    //  270  509:getfield        #249 <Field double m_minC>
    //  271  512:aload_0         
    //  272  513:getfield        #251 <Field double m_maxC>
    //  273  516:aload_0         
    //  274  517:getfield        #249 <Field double m_minC>
    //  275  520:dsub            
    //  276  521:ldc2w           #373 <Double 2D>
    //  277  524:ddiv            
    //  278  525:dadd            
    //  279  526:dstore          15
                gx.drawLine(m_HorizontalPad + (w - 2 * m_HorizontalPad) / 2, 10, m_HorizontalPad + (w - 2 * m_HorizontalPad) / 2, 15);
    //  280  528:aload_1         
    //  281  529:aload_0         
    //  282  530:getfield        #64  <Field int m_HorizontalPad>
    //  283  533:iload_2         
    //  284  534:iconst_2        
    //  285  535:aload_0         
    //  286  536:getfield        #64  <Field int m_HorizontalPad>
    //  287  539:imul            
    //  288  540:isub            
    //  289  541:iconst_2        
    //  290  542:idiv            
    //  291  543:iadd            
    //  292  544:bipush          10
    //  293  546:aload_0         
    //  294  547:getfield        #64  <Field int m_HorizontalPad>
    //  295  550:iload_2         
    //  296  551:iconst_2        
    //  297  552:aload_0         
    //  298  553:getfield        #64  <Field int m_HorizontalPad>
    //  299  556:imul            
    //  300  557:isub            
    //  301  558:iconst_2        
    //  302  559:idiv            
    //  303  560:iadd            
    //  304  561:bipush          15
    //  305  563:invokevirtual   #366 <Method void Graphics.drawLine(int, int, int, int)>
                whole = (int)Math.abs(mid);
    //  306  566:dload           15
    //  307  568:invokestatic    #257 <Method double Math.abs(double)>
    //  308  571:d2i             
    //  309  572:istore          8
                decimal = Math.abs(mid) - (double)whole;
    //  310  574:dload           15
    //  311  576:invokestatic    #257 <Method double Math.abs(double)>
    //  312  579:iload           8
    //  313  581:i2d             
    //  314  582:dsub            
    //  315  583:dstore          9
                nondecimal = whole <= 0 ? 1 : (int)(Math.log(whole) / Math.log(10D));
    //  316  585:iload           8
    //  317  587:ifle            607
    //  318  590:iload           8
    //  319  592:i2d             
    //  320  593:invokestatic    #260 <Method double Math.log(double)>
    //  321  596:ldc2w           #261 <Double 10D>
    //  322  599:invokestatic    #260 <Method double Math.log(double)>
    //  323  602:ddiv            
    //  324  603:d2i             
    //  325  604:goto            608
    //  326  607:iconst_1        
    //  327  608:istore          11
                m_precisionC = decimal <= 0.0D ? 1 : (int)Math.abs(Math.log(Math.abs(mid)) / Math.log(10D)) + 2;
    //  328  610:aload_0         
    //  329  611:dload           9
    //  330  613:dconst_0        
    //  331  614:dcmpl           
    //  332  615:ifle            642
    //  333  618:dload           15
    //  334  620:invokestatic    #257 <Method double Math.abs(double)>
    //  335  623:invokestatic    #260 <Method double Math.log(double)>
    //  336  626:ldc2w           #261 <Double 10D>
    //  337  629:invokestatic    #260 <Method double Math.log(double)>
    //  338  632:ddiv            
    //  339  633:invokestatic    #257 <Method double Math.abs(double)>
    //  340  636:d2i             
    //  341  637:iconst_2        
    //  342  638:iadd            
    //  343  639:goto            643
    //  344  642:iconst_1        
    //  345  643:putfield        #264 <Field int m_precisionC>
                if(m_precisionC > VisualizeUtils.MAX_PRECISION)
    //* 346  646:aload_0         
    //* 347  647:getfield        #264 <Field int m_precisionC>
    //* 348  650:getstatic       #269 <Field int VisualizeUtils.MAX_PRECISION>
    //* 349  653:icmple          661
                    m_precisionC = 1;
    //  350  656:aload_0         
    //  351  657:iconst_1        
    //  352  658:putfield        #264 <Field int m_precisionC>
                maxStringC = Utils.doubleToString(mid, nondecimal + 1 + m_precisionC, m_precisionC);
    //  353  661:dload           15
    //  354  663:iload           11
    //  355  665:iconst_1        
    //  356  666:iadd            
    //  357  667:aload_0         
    //  358  668:getfield        #264 <Field int m_precisionC>
    //  359  671:iadd            
    //  360  672:aload_0         
    //  361  673:getfield        #264 <Field int m_precisionC>
    //  362  676:invokestatic    #275 <Method String Utils.doubleToString(double, int, int)>
    //  363  679:astore          12
                mswc = m_labelMetrics.stringWidth(maxStringC);
    //  364  681:aload_0         
    //  365  682:getfield        #60  <Field FontMetrics m_labelMetrics>
    //  366  685:aload           12
    //  367  687:invokevirtual   #279 <Method int FontMetrics.stringWidth(String)>
    //  368  690:istore          13
                gx.drawString(maxStringC, (m_HorizontalPad + (w - 2 * m_HorizontalPad) / 2) - mswc / 2, 15 + hf);
    //  369  692:aload_1         
    //  370  693:aload           12
    //  371  695:aload_0         
    //  372  696:getfield        #64  <Field int m_HorizontalPad>
    //  373  699:iload_2         
    //  374  700:iconst_2        
    //  375  701:aload_0         
    //  376  702:getfield        #64  <Field int m_HorizontalPad>
    //  377  705:imul            
    //  378  706:isub            
    //  379  707:iconst_2        
    //  380  708:idiv            
    //  381  709:iadd            
    //  382  710:iload           13
    //  383  712:iconst_2        
    //  384  713:idiv            
    //  385  714:isub            
    //  386  715:bipush          15
    //  387  717:iload           7
    //  388  719:iadd            
    //  389  720:invokevirtual   #372 <Method void Graphics.drawString(String, int, int)>
            }
        }
    //  390  723:return          
    }

    public void paintComponent(Graphics gx)
    {
        super.paintComponent(gx);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokespecial   #381 <Method void JPanel.paintComponent(Graphics)>
        if(m_isEnabled)
    //*   3    5:aload_0         
    //*   4    6:getfield        #52  <Field boolean m_isEnabled>
    //*   5    9:ifeq            93
            if(m_isNumeric)
    //*   6   12:aload_0         
    //*   7   13:getfield        #54  <Field boolean m_isNumeric>
    //*   8   16:ifeq            38
            {
                m_oldWidth = -9000;
    //    9   19:aload_0         
    //   10   20:sipush          -9000
    //   11   23:putfield        #66  <Field int m_oldWidth>
                removeAll();
    //   12   26:aload_0         
    //   13   27:invokevirtual   #384 <Method void removeAll()>
                paintNumeric(gx);
    //   14   30:aload_0         
    //   15   31:aload_1         
    //   16   32:invokevirtual   #386 <Method void paintNumeric(Graphics)>
            } else
    //*  17   35:goto            93
            if(m_Instances != null && m_Instances.numInstances() > 0 && m_Instances.numAttributes() > 0 && m_oldWidth != getWidth())
    //*  18   38:aload_0         
    //*  19   39:getfield        #68  <Field Instances m_Instances>
    //*  20   42:ifnull          93
    //*  21   45:aload_0         
    //*  22   46:getfield        #68  <Field Instances m_Instances>
    //*  23   49:invokevirtual   #247 <Method int Instances.numInstances()>
    //*  24   52:ifle            93
    //*  25   55:aload_0         
    //*  26   56:getfield        #68  <Field Instances m_Instances>
    //*  27   59:invokevirtual   #177 <Method int Instances.numAttributes()>
    //*  28   62:ifle            93
    //*  29   65:aload_0         
    //*  30   66:getfield        #66  <Field int m_oldWidth>
    //*  31   69:aload_0         
    //*  32   70:invokevirtual   #292 <Method int getWidth()>
    //*  33   73:icmpeq          93
            {
                removeAll();
    //   34   76:aload_0         
    //   35   77:invokevirtual   #384 <Method void removeAll()>
                m_oldWidth = getWidth();
    //   36   80:aload_0         
    //   37   81:aload_0         
    //   38   82:invokevirtual   #292 <Method int getWidth()>
    //   39   85:putfield        #66  <Field int m_oldWidth>
                paintNominal(gx);
    //   40   88:aload_0         
    //   41   89:aload_1         
    //   42   90:invokevirtual   #388 <Method void paintNominal(Graphics)>
            }
    //   43   93:return          
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
                System.err.println("Usage : weka.gui.visualize.ClassPanel <dataset> [class col]");
    //    4    6:getstatic       #396 <Field PrintStream System.err>
    //    5    9:ldc2            #398 <String "Usage : weka.gui.visualize.ClassPanel <dataset> [class col]">
    //    6   12:invokevirtual   #404 <Method void PrintStream.println(String)>
                System.exit(1);
    //    7   15:iconst_1        
    //    8   16:invokestatic    #407 <Method void System.exit(int)>
            }
            final JFrame jf = new JFrame("Weka Explorer: Class");
    //    9   19:new             #409 <Class JFrame>
    //   10   22:dup             
    //   11   23:ldc2            #411 <String "Weka Explorer: Class">
    //   12   26:invokespecial   #413 <Method void JFrame(String)>
    //   13   29:astore_1        
            jf.setSize(500, 100);
    //   14   30:aload_1         
    //   15   31:sipush          500
    //   16   34:bipush          100
    //   17   36:invokevirtual   #414 <Method void JFrame.setSize(int, int)>
            jf.getContentPane().setLayout(new BorderLayout());
    //   18   39:aload_1         
    //   19   40:invokevirtual   #418 <Method Container JFrame.getContentPane()>
    //   20   43:new             #420 <Class BorderLayout>
    //   21   46:dup             
    //   22   47:invokespecial   #421 <Method void BorderLayout()>
    //   23   50:invokevirtual   #427 <Method void Container.setLayout(java.awt.LayoutManager)>
            ClassPanel p2 = new ClassPanel();
    //   24   53:new             #2   <Class ClassPanel>
    //   25   56:dup             
    //   26   57:invokespecial   #428 <Method void ClassPanel()>
    //   27   60:astore_2        
            jf.getContentPane().add(p2, "Center");
    //   28   61:aload_1         
    //   29   62:invokevirtual   #418 <Method Container JFrame.getContentPane()>
    //   30   65:aload_2         
    //   31   66:ldc2            #430 <String "Center">
    //   32   69:invokevirtual   #433 <Method void Container.add(Component, Object)>
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
    //   33   72:aload_1         
    //   34   73:new             #435 <Class ClassPanel$2>
    //   35   76:dup             
    //   36   77:aload_1         
    //   37   78:invokespecial   #438 <Method void ClassPanel$2(JFrame)>
    //   38   81:invokevirtual   #442 <Method void JFrame.addWindowListener(java.awt.event.WindowListener)>
            if(args.length >= 1)
    //*  39   84:aload_0         
    //*  40   85:arraylength     
    //*  41   86:iconst_1        
    //*  42   87:icmplt          161
            {
                System.err.println((new StringBuilder("Loading instances from ")).append(args[0]).toString());
    //   43   90:getstatic       #396 <Field PrintStream System.err>
    //   44   93:new             #444 <Class StringBuilder>
    //   45   96:dup             
    //   46   97:ldc2            #446 <String "Loading instances from ">
    //   47  100:invokespecial   #447 <Method void StringBuilder(String)>
    //   48  103:aload_0         
    //   49  104:iconst_0        
    //   50  105:aaload          
    //   51  106:invokevirtual   #451 <Method StringBuilder StringBuilder.append(String)>
    //   52  109:invokevirtual   #454 <Method String StringBuilder.toString()>
    //   53  112:invokevirtual   #404 <Method void PrintStream.println(String)>
                java.io.Reader r = new BufferedReader(new FileReader(args[0]));
    //   54  115:new             #456 <Class BufferedReader>
    //   55  118:dup             
    //   56  119:new             #458 <Class FileReader>
    //   57  122:dup             
    //   58  123:aload_0         
    //   59  124:iconst_0        
    //   60  125:aaload          
    //   61  126:invokespecial   #459 <Method void FileReader(String)>
    //   62  129:invokespecial   #462 <Method void BufferedReader(java.io.Reader)>
    //   63  132:astore_3        
                Instances i = new Instances(r);
    //   64  133:new             #174 <Class Instances>
    //   65  136:dup             
    //   66  137:aload_3         
    //   67  138:invokespecial   #463 <Method void Instances(java.io.Reader)>
    //   68  141:astore          4
                i.setClassIndex(i.numAttributes() - 1);
    //   69  143:aload           4
    //   70  145:aload           4
    //   71  147:invokevirtual   #177 <Method int Instances.numAttributes()>
    //   72  150:iconst_1        
    //   73  151:isub            
    //   74  152:invokevirtual   #466 <Method void Instances.setClassIndex(int)>
                p2.setInstances(i);
    //   75  155:aload_2         
    //   76  156:aload           4
    //   77  158:invokevirtual   #468 <Method void setInstances(Instances)>
            }
            if(args.length > 1)
    //*  78  161:aload_0         
    //*  79  162:arraylength     
    //*  80  163:iconst_1        
    //*  81  164:icmple          182
                p2.setCindex(Integer.parseInt(args[1]) - 1);
    //   82  167:aload_2         
    //   83  168:aload_0         
    //   84  169:iconst_1        
    //   85  170:aaload          
    //   86  171:invokestatic    #473 <Method int Integer.parseInt(String)>
    //   87  174:iconst_1        
    //   88  175:isub            
    //   89  176:invokevirtual   #356 <Method void setCindex(int)>
            else
    //*  90  179:goto            187
                p2.setCindex(0);
    //   91  182:aload_2         
    //   92  183:iconst_0        
    //   93  184:invokevirtual   #356 <Method void setCindex(int)>
            jf.setVisible(true);
    //   94  187:aload_1         
    //   95  188:iconst_1        
    //   96  189:invokevirtual   #476 <Method void JFrame.setVisible(boolean)>
        }
    //*  97  192:goto            210
        catch(Exception ex)
    //*  98  195:astore_1        
        {
            ex.printStackTrace();
    //   99  196:aload_1         
    //  100  197:invokevirtual   #481 <Method void Exception.printStackTrace()>
            System.err.println(ex.getMessage());
    //  101  200:getstatic       #396 <Field PrintStream System.err>
    //  102  203:aload_1         
    //  103  204:invokevirtual   #484 <Method String Exception.getMessage()>
    //  104  207:invokevirtual   #404 <Method void PrintStream.println(String)>
        }
    //  105  210:return          
    }

    private static final long serialVersionUID = 0x9166ff3ff08de10aL;
    private boolean m_isEnabled;
    private boolean m_isNumeric;
    private final int m_spectrumHeight = 5;
    private double m_maxC;
    private double m_minC;
    private final int m_tickSize = 5;
    private FontMetrics m_labelMetrics;
    private Font m_labelFont;
    private int m_HorizontalPad;
    private int m_precisionC;
    private int m_fieldWidthC;
    private int m_oldWidth;
    private Instances m_Instances;
    private int m_cIndex;
    private FastVector m_colorList;
    private FastVector m_Repainters;
    private FastVector m_ColourChangeListeners;
    protected Color m_DefaultColors[];
    protected Color m_backgroundColor;


/*
    static FastVector access$0(ClassPanel classpanel)
    {
        return classpanel.m_colorList;
    //    0    0:aload_0         
    //    1    1:getfield        #110 <Field FastVector m_colorList>
    //    2    4:areturn         
    }

*/


/*
    static void access$1(ClassPanel classpanel, int i)
    {
        classpanel.m_oldWidth = i;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #66  <Field int m_oldWidth>
        return;
    //    3    5:return          
    }

*/


/*
    static FastVector access$2(ClassPanel classpanel)
    {
        return classpanel.m_Repainters;
    //    0    0:aload_0         
    //    1    1:getfield        #73  <Field FastVector m_Repainters>
    //    2    4:areturn         
    }

*/


/*
    static FastVector access$3(ClassPanel classpanel)
    {
        return classpanel.m_ColourChangeListeners;
    //    0    0:aload_0         
    //    1    1:getfield        #75  <Field FastVector m_ColourChangeListeners>
    //    2    4:areturn         
    }

*/
}
