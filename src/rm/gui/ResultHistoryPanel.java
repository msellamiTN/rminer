// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   ResultHistoryPanel.java

package rm.gui;

import java.awt.*;
import java.awt.event.*;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.Hashtable;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.JTextComponent;
import rm.gui.visualize.PrintableComponent;

public class ResultHistoryPanel extends JPanel
{
    public static class RMouseAdapter extends MouseAdapter
        implements Serializable
    {

        static final long serialVersionUID = 0x833645fd9609a8f3L;

        public RMouseAdapter()
        {
        //    0    0:aload_0         
        //    1    1:invokespecial   #16  <Method void MouseAdapter()>
        //    2    4:return          
        }
    }

    public static class RKeyAdapter extends KeyAdapter
        implements Serializable
    {

        static final long serialVersionUID = 0x879b07045df06a11L;

        public RKeyAdapter()
        {
        //    0    0:aload_0         
        //    1    1:invokespecial   #16  <Method void KeyAdapter()>
        //    2    4:return          
        }
    }


    public ResultHistoryPanel(JTextComponent text)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #31  <Method void JPanel()>
        m_Model = new DefaultListModel();
    //    2    4:aload_0         
    //    3    5:new             #33  <Class DefaultListModel>
    //    4    8:dup             
    //    5    9:invokespecial   #34  <Method void DefaultListModel()>
    //    6   12:putfield        #36  <Field DefaultListModel m_Model>
        m_List = new JList(m_Model);
    //    7   15:aload_0         
    //    8   16:new             #38  <Class JList>
    //    9   19:dup             
    //   10   20:aload_0         
    //   11   21:getfield        #36  <Field DefaultListModel m_Model>
    //   12   24:invokespecial   #41  <Method void JList(javax.swing.ListModel)>
    //   13   27:putfield        #43  <Field JList m_List>
        m_Results = new Hashtable();
    //   14   30:aload_0         
    //   15   31:new             #45  <Class Hashtable>
    //   16   34:dup             
    //   17   35:invokespecial   #46  <Method void Hashtable()>
    //   18   38:putfield        #48  <Field Hashtable m_Results>
        m_FramedOutput = new Hashtable();
    //   19   41:aload_0         
    //   20   42:new             #45  <Class Hashtable>
    //   21   45:dup             
    //   22   46:invokespecial   #46  <Method void Hashtable()>
    //   23   49:putfield        #50  <Field Hashtable m_FramedOutput>
        m_Objs = new Hashtable();
    //   24   52:aload_0         
    //   25   53:new             #45  <Class Hashtable>
    //   26   56:dup             
    //   27   57:invokespecial   #46  <Method void Hashtable()>
    //   28   60:putfield        #52  <Field Hashtable m_Objs>
        m_HandleRightClicks = true;
    //   29   63:aload_0         
    //   30   64:iconst_1        
    //   31   65:putfield        #54  <Field boolean m_HandleRightClicks>
        m_Printer = null;
    //   32   68:aload_0         
    //   33   69:aconst_null     
    //   34   70:putfield        #56  <Field PrintableComponent m_Printer>
        m_SingleText = text;
    //   35   73:aload_0         
    //   36   74:aload_1         
    //   37   75:putfield        #58  <Field JTextComponent m_SingleText>
        if(text != null)
    //*  38   78:aload_1         
    //*  39   79:ifnull          97
            m_Printer = new PrintableComponent(m_SingleText);
    //   40   82:aload_0         
    //   41   83:new             #60  <Class PrintableComponent>
    //   42   86:dup             
    //   43   87:aload_0         
    //   44   88:getfield        #58  <Field JTextComponent m_SingleText>
    //   45   91:invokespecial   #63  <Method void PrintableComponent(javax.swing.JComponent)>
    //   46   94:putfield        #56  <Field PrintableComponent m_Printer>
        m_List.setSelectionMode(0);
    //   47   97:aload_0         
    //   48   98:getfield        #43  <Field JList m_List>
    //   49  101:iconst_0        
    //   50  102:invokevirtual   #67  <Method void JList.setSelectionMode(int)>
        m_List.addMouseListener(new RMouseAdapter() {

            public void mouseClicked(MouseEvent e)
            {
                if((e.getModifiers() & 0x10) == 16)
            //*   0    0:aload_1         
            //*   1    1:invokevirtual   #31  <Method int MouseEvent.getModifiers()>
            //*   2    4:bipush          16
            //*   3    6:iand            
            //*   4    7:bipush          16
            //*   5    9:icmpne          87
                {
                    if((e.getModifiers() & 0x40) == 0 && (e.getModifiers() & 0x80) == 0)
            //*   6   12:aload_1         
            //*   7   13:invokevirtual   #31  <Method int MouseEvent.getModifiers()>
            //*   8   16:bipush          64
            //*   9   18:iand            
            //*  10   19:ifne            140
            //*  11   22:aload_1         
            //*  12   23:invokevirtual   #31  <Method int MouseEvent.getModifiers()>
            //*  13   26:sipush          128
            //*  14   29:iand            
            //*  15   30:ifne            140
                    {
                        int index = m_List.locationToIndex(e.getPoint());
            //   16   33:aload_0         
            //   17   34:getfield        #16  <Field ResultHistoryPanel this$0>
            //   18   37:getfield        #37  <Field JList ResultHistoryPanel.m_List>
            //   19   40:aload_1         
            //   20   41:invokevirtual   #41  <Method Point MouseEvent.getPoint()>
            //   21   44:invokevirtual   #47  <Method int JList.locationToIndex(Point)>
            //   22   47:istore_2        
                        if(index != -1 && m_SingleText != null)
            //*  23   48:iload_2         
            //*  24   49:iconst_m1       
            //*  25   50:icmpeq          140
            //*  26   53:aload_0         
            //*  27   54:getfield        #16  <Field ResultHistoryPanel this$0>
            //*  28   57:getfield        #51  <Field JTextComponent ResultHistoryPanel.m_SingleText>
            //*  29   60:ifnull          140
                            setSingle((String)m_Model.elementAt(index));
            //   30   63:aload_0         
            //   31   64:getfield        #16  <Field ResultHistoryPanel this$0>
            //   32   67:aload_0         
            //   33   68:getfield        #16  <Field ResultHistoryPanel this$0>
            //   34   71:getfield        #55  <Field DefaultListModel ResultHistoryPanel.m_Model>
            //   35   74:iload_2         
            //   36   75:invokevirtual   #61  <Method Object DefaultListModel.elementAt(int)>
            //   37   78:checkcast       #63  <Class String>
            //   38   81:invokevirtual   #67  <Method void ResultHistoryPanel.setSingle(String)>
                    }
                } else
            //*  39   84:goto            140
                if(m_HandleRightClicks)
            //*  40   87:aload_0         
            //*  41   88:getfield        #16  <Field ResultHistoryPanel this$0>
            //*  42   91:getfield        #71  <Field boolean ResultHistoryPanel.m_HandleRightClicks>
            //*  43   94:ifeq            140
                {
                    int index = m_List.locationToIndex(e.getPoint());
            //   44   97:aload_0         
            //   45   98:getfield        #16  <Field ResultHistoryPanel this$0>
            //   46  101:getfield        #37  <Field JList ResultHistoryPanel.m_List>
            //   47  104:aload_1         
            //   48  105:invokevirtual   #41  <Method Point MouseEvent.getPoint()>
            //   49  108:invokevirtual   #47  <Method int JList.locationToIndex(Point)>
            //   50  111:istore_2        
                    if(index != -1)
            //*  51  112:iload_2         
            //*  52  113:iconst_m1       
            //*  53  114:icmpeq          140
                    {
                        String name = (String)m_Model.elementAt(index);
            //   54  117:aload_0         
            //   55  118:getfield        #16  <Field ResultHistoryPanel this$0>
            //   56  121:getfield        #55  <Field DefaultListModel ResultHistoryPanel.m_Model>
            //   57  124:iload_2         
            //   58  125:invokevirtual   #61  <Method Object DefaultListModel.elementAt(int)>
            //   59  128:checkcast       #63  <Class String>
            //   60  131:astore_3        
                        openFrame(name);
            //   61  132:aload_0         
            //   62  133:getfield        #16  <Field ResultHistoryPanel this$0>
            //   63  136:aload_3         
            //   64  137:invokevirtual   #74  <Method void ResultHistoryPanel.openFrame(String)>
                    }
                }
            //   65  140:return          
            }

            private static final long serialVersionUID = 0x82e2e02cecccb3d1L;
            final ResultHistoryPanel this$0;

            
            {
                this$0 = ResultHistoryPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #16  <Field ResultHistoryPanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #19  <Method void ResultHistoryPanel$RMouseAdapter()>
            //    5    9:return          
            }
        }
);
    //   51  105:aload_0         
    //   52  106:getfield        #43  <Field JList m_List>
    //   53  109:new             #69  <Class ResultHistoryPanel$1>
    //   54  112:dup             
    //   55  113:aload_0         
    //   56  114:invokespecial   #72  <Method void ResultHistoryPanel$1(ResultHistoryPanel)>
    //   57  117:invokevirtual   #76  <Method void JList.addMouseListener(java.awt.event.MouseListener)>
        m_List.addKeyListener(new RKeyAdapter() {

            public void keyReleased(KeyEvent e)
            {
                if(e.getKeyCode() == 127)
            //*   0    0:aload_1         
            //*   1    1:invokevirtual   #31  <Method int KeyEvent.getKeyCode()>
            //*   2    4:bipush          127
            //*   3    6:icmpne          46
                {
                    int selected = m_List.getSelectedIndex();
            //    4    9:aload_0         
            //    5   10:getfield        #16  <Field ResultHistoryPanel this$0>
            //    6   13:getfield        #37  <Field JList ResultHistoryPanel.m_List>
            //    7   16:invokevirtual   #42  <Method int JList.getSelectedIndex()>
            //    8   19:istore_2        
                    if(selected != -1)
            //*   9   20:iload_2         
            //*  10   21:iconst_m1       
            //*  11   22:icmpeq          46
                        removeResult((String)m_Model.elementAt(selected));
            //   12   25:aload_0         
            //   13   26:getfield        #16  <Field ResultHistoryPanel this$0>
            //   14   29:aload_0         
            //   15   30:getfield        #16  <Field ResultHistoryPanel this$0>
            //   16   33:getfield        #46  <Field DefaultListModel ResultHistoryPanel.m_Model>
            //   17   36:iload_2         
            //   18   37:invokevirtual   #52  <Method Object DefaultListModel.elementAt(int)>
            //   19   40:checkcast       #54  <Class String>
            //   20   43:invokevirtual   #58  <Method void ResultHistoryPanel.removeResult(String)>
                }
            //   21   46:return          
            }

            private static final long serialVersionUID = 0x6dc86329e13304c8L;
            final ResultHistoryPanel this$0;

            
            {
                this$0 = ResultHistoryPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #16  <Field ResultHistoryPanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #19  <Method void ResultHistoryPanel$RKeyAdapter()>
            //    5    9:return          
            }
        }
);
    //   58  120:aload_0         
    //   59  121:getfield        #43  <Field JList m_List>
    //   60  124:new             #78  <Class ResultHistoryPanel$2>
    //   61  127:dup             
    //   62  128:aload_0         
    //   63  129:invokespecial   #79  <Method void ResultHistoryPanel$2(ResultHistoryPanel)>
    //   64  132:invokevirtual   #83  <Method void JList.addKeyListener(java.awt.event.KeyListener)>
        m_List.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e)
            {
                if(!e.getValueIsAdjusting())
            //*   0    0:aload_1         
            //*   1    1:invokevirtual   #28  <Method boolean ListSelectionEvent.getValueIsAdjusting()>
            //*   2    4:ifne            83
                {
                    ListSelectionModel lm = (ListSelectionModel)e.getSource();
            //    3    7:aload_1         
            //    4    8:invokevirtual   #32  <Method Object ListSelectionEvent.getSource()>
            //    5   11:checkcast       #34  <Class ListSelectionModel>
            //    6   14:astore_2        
                    for(int i = e.getFirstIndex(); i <= e.getLastIndex(); i++)
            //*   7   15:aload_1         
            //*   8   16:invokevirtual   #38  <Method int ListSelectionEvent.getFirstIndex()>
            //*   9   19:istore_3        
            //*  10   20:goto            75
                    {
                        if(!lm.isSelectedIndex(i))
                            continue;
            //   11   23:aload_2         
            //   12   24:iload_3         
            //   13   25:invokeinterface #42  <Method boolean ListSelectionModel.isSelectedIndex(int)>
            //   14   30:ifeq            72
                        if(i != -1 && m_SingleText != null)
            //*  15   33:iload_3         
            //*  16   34:iconst_m1       
            //*  17   35:icmpeq          83
            //*  18   38:aload_0         
            //*  19   39:getfield        #13  <Field ResultHistoryPanel this$0>
            //*  20   42:getfield        #48  <Field JTextComponent ResultHistoryPanel.m_SingleText>
            //*  21   45:ifnull          83
                            setSingle((String)m_Model.elementAt(i));
            //   22   48:aload_0         
            //   23   49:getfield        #13  <Field ResultHistoryPanel this$0>
            //   24   52:aload_0         
            //   25   53:getfield        #13  <Field ResultHistoryPanel this$0>
            //   26   56:getfield        #52  <Field DefaultListModel ResultHistoryPanel.m_Model>
            //   27   59:iload_3         
            //   28   60:invokevirtual   #58  <Method Object DefaultListModel.elementAt(int)>
            //   29   63:checkcast       #60  <Class String>
            //   30   66:invokevirtual   #64  <Method void ResultHistoryPanel.setSingle(String)>
                        break;
            //   31   69:goto            83
                    }

            //   32   72:iinc            3  1
            //   33   75:iload_3         
            //   34   76:aload_1         
            //   35   77:invokevirtual   #67  <Method int ListSelectionEvent.getLastIndex()>
            //   36   80:icmple          23
                }
            //   37   83:return          
            }

            final ResultHistoryPanel this$0;

            
            {
                this$0 = ResultHistoryPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field ResultHistoryPanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //   65  135:aload_0         
    //   66  136:getfield        #43  <Field JList m_List>
    //   67  139:invokevirtual   #87  <Method ListSelectionModel JList.getSelectionModel()>
    //   68  142:new             #89  <Class ResultHistoryPanel$3>
    //   69  145:dup             
    //   70  146:aload_0         
    //   71  147:invokespecial   #90  <Method void ResultHistoryPanel$3(ResultHistoryPanel)>
    //   72  150:invokeinterface #96  <Method void ListSelectionModel.addListSelectionListener(ListSelectionListener)>
        setLayout(new BorderLayout());
    //   73  155:aload_0         
    //   74  156:new             #98  <Class BorderLayout>
    //   75  159:dup             
    //   76  160:invokespecial   #99  <Method void BorderLayout()>
    //   77  163:invokevirtual   #103 <Method void setLayout(java.awt.LayoutManager)>
        JScrollPane js = new JScrollPane(m_List);
    //   78  166:new             #105 <Class JScrollPane>
    //   79  169:dup             
    //   80  170:aload_0         
    //   81  171:getfield        #43  <Field JList m_List>
    //   82  174:invokespecial   #108 <Method void JScrollPane(java.awt.Component)>
    //   83  177:astore_2        
        js.getViewport().addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent e)
            {
                JViewport vp = (JViewport)e.getSource();
            //    0    0:aload_1         
            //    1    1:invokevirtual   #30  <Method Object ChangeEvent.getSource()>
            //    2    4:checkcast       #32  <Class JViewport>
            //    3    7:astore_2        
                int h = vp.getViewSize().height;
            //    4    8:aload_2         
            //    5    9:invokevirtual   #36  <Method Dimension JViewport.getViewSize()>
            //    6   12:getfield        #41  <Field int Dimension.height>
            //    7   15:istore_3        
                if(h != lastHeight)
            //*   8   16:iload_3         
            //*   9   17:aload_0         
            //*  10   18:getfield        #43  <Field int lastHeight>
            //*  11   21:icmpeq          54
                {
                    lastHeight = h;
            //   12   24:aload_0         
            //   13   25:iload_3         
            //   14   26:putfield        #43  <Field int lastHeight>
                    int x = h - vp.getExtentSize().height;
            //   15   29:iload_3         
            //   16   30:aload_2         
            //   17   31:invokevirtual   #46  <Method Dimension JViewport.getExtentSize()>
            //   18   34:getfield        #41  <Field int Dimension.height>
            //   19   37:isub            
            //   20   38:istore          4
                    vp.setViewPosition(new Point(0, x));
            //   21   40:aload_2         
            //   22   41:new             #48  <Class Point>
            //   23   44:dup             
            //   24   45:iconst_0        
            //   25   46:iload           4
            //   26   48:invokespecial   #51  <Method void Point(int, int)>
            //   27   51:invokevirtual   #55  <Method void JViewport.setViewPosition(Point)>
                }
            //   28   54:return          
            }

            private int lastHeight;
            final ResultHistoryPanel this$0;

            
            {
                this$0 = ResultHistoryPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #15  <Field ResultHistoryPanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #18  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //   84  178:aload_2         
    //   85  179:invokevirtual   #112 <Method JViewport JScrollPane.getViewport()>
    //   86  182:new             #114 <Class ResultHistoryPanel$4>
    //   87  185:dup             
    //   88  186:aload_0         
    //   89  187:invokespecial   #115 <Method void ResultHistoryPanel$4(ResultHistoryPanel)>
    //   90  190:invokevirtual   #121 <Method void JViewport.addChangeListener(ChangeListener)>
        add(js, "Center");
    //   91  193:aload_0         
    //   92  194:aload_2         
    //   93  195:ldc1            #123 <String "Center">
    //   94  197:invokevirtual   #127 <Method void add(java.awt.Component, Object)>
    //   95  200:return          
    }

    public void addResult(String name, StringBuffer result)
    {
        m_Model.addElement(name);
    //    0    0:aload_0         
    //    1    1:getfield        #36  <Field DefaultListModel m_Model>
    //    2    4:aload_1         
    //    3    5:invokevirtual   #140 <Method void DefaultListModel.addElement(Object)>
        m_Results.put(name, result);
    //    4    8:aload_0         
    //    5    9:getfield        #48  <Field Hashtable m_Results>
    //    6   12:aload_1         
    //    7   13:aload_2         
    //    8   14:invokevirtual   #144 <Method Object Hashtable.put(Object, Object)>
    //    9   17:pop             
    //   10   18:return          
    }

    public void removeResult(String name)
    {
        StringBuffer buff = (StringBuffer)(StringBuffer)m_Results.get(name);
    //    0    0:aload_0         
    //    1    1:getfield        #48  <Field Hashtable m_Results>
    //    2    4:aload_1         
    //    3    5:invokevirtual   #153 <Method Object Hashtable.get(Object)>
    //    4    8:checkcast       #155 <Class StringBuffer>
    //    5   11:checkcast       #155 <Class StringBuffer>
    //    6   14:astore_2        
        if(buff != null)
    //*   7   15:aload_2         
    //*   8   16:ifnull          49
        {
            m_Results.remove(name);
    //    9   19:aload_0         
    //   10   20:getfield        #48  <Field Hashtable m_Results>
    //   11   23:aload_1         
    //   12   24:invokevirtual   #158 <Method Object Hashtable.remove(Object)>
    //   13   27:pop             
            m_Model.removeElement(name);
    //   14   28:aload_0         
    //   15   29:getfield        #36  <Field DefaultListModel m_Model>
    //   16   32:aload_1         
    //   17   33:invokevirtual   #162 <Method boolean DefaultListModel.removeElement(Object)>
    //   18   36:pop             
            m_Objs.remove(name);
    //   19   37:aload_0         
    //   20   38:getfield        #52  <Field Hashtable m_Objs>
    //   21   41:aload_1         
    //   22   42:invokevirtual   #158 <Method Object Hashtable.remove(Object)>
    //   23   45:pop             
            System.gc();
    //   24   46:invokestatic    #167 <Method void System.gc()>
        }
    //   25   49:return          
    }

    public void clearResults()
    {
        m_Results.clear();
    //    0    0:aload_0         
    //    1    1:getfield        #48  <Field Hashtable m_Results>
    //    2    4:invokevirtual   #172 <Method void Hashtable.clear()>
        m_Model.clear();
    //    3    7:aload_0         
    //    4    8:getfield        #36  <Field DefaultListModel m_Model>
    //    5   11:invokevirtual   #173 <Method void DefaultListModel.clear()>
        m_Objs.clear();
    //    6   14:aload_0         
    //    7   15:getfield        #52  <Field Hashtable m_Objs>
    //    8   18:invokevirtual   #172 <Method void Hashtable.clear()>
        System.gc();
    //    9   21:invokestatic    #167 <Method void System.gc()>
    //   10   24:return          
    }

    public void addObject(String name, Object o)
    {
        m_Objs.put(name, o);
    //    0    0:aload_0         
    //    1    1:getfield        #52  <Field Hashtable m_Objs>
    //    2    4:aload_1         
    //    3    5:aload_2         
    //    4    6:invokevirtual   #144 <Method Object Hashtable.put(Object, Object)>
    //    5    9:pop             
    //    6   10:return          
    }

    public Object getNamedObject(String name)
    {
        Object v = null;
    //    0    0:aconst_null     
    //    1    1:astore_2        
        v = m_Objs.get(name);
    //    2    2:aload_0         
    //    3    3:getfield        #52  <Field Hashtable m_Objs>
    //    4    6:aload_1         
    //    5    7:invokevirtual   #153 <Method Object Hashtable.get(Object)>
    //    6   10:astore_2        
        return v;
    //    7   11:aload_2         
    //    8   12:areturn         
    }

    public Object getSelectedObject()
    {
        Object v = null;
    //    0    0:aconst_null     
    //    1    1:astore_1        
        int index = m_List.getSelectedIndex();
    //    2    2:aload_0         
    //    3    3:getfield        #43  <Field JList m_List>
    //    4    6:invokevirtual   #186 <Method int JList.getSelectedIndex()>
    //    5    9:istore_2        
        if(index != -1)
    //*   6   10:iload_2         
    //*   7   11:iconst_m1       
    //*   8   12:icmpeq          36
        {
            String name = (String)m_Model.elementAt(index);
    //    9   15:aload_0         
    //   10   16:getfield        #36  <Field DefaultListModel m_Model>
    //   11   19:iload_2         
    //   12   20:invokevirtual   #190 <Method Object DefaultListModel.elementAt(int)>
    //   13   23:checkcast       #192 <Class String>
    //   14   26:astore_3        
            v = m_Objs.get(name);
    //   15   27:aload_0         
    //   16   28:getfield        #52  <Field Hashtable m_Objs>
    //   17   31:aload_3         
    //   18   32:invokevirtual   #153 <Method Object Hashtable.get(Object)>
    //   19   35:astore_1        
        }
        return v;
    //   20   36:aload_1         
    //   21   37:areturn         
    }

    public StringBuffer getNamedBuffer(String name)
    {
        StringBuffer b = null;
    //    0    0:aconst_null     
    //    1    1:astore_2        
        b = (StringBuffer)(StringBuffer)m_Results.get(name);
    //    2    2:aload_0         
    //    3    3:getfield        #48  <Field Hashtable m_Results>
    //    4    6:aload_1         
    //    5    7:invokevirtual   #153 <Method Object Hashtable.get(Object)>
    //    6   10:checkcast       #155 <Class StringBuffer>
    //    7   13:checkcast       #155 <Class StringBuffer>
    //    8   16:astore_2        
        return b;
    //    9   17:aload_2         
    //   10   18:areturn         
    }

    public StringBuffer getSelectedBuffer()
    {
        StringBuffer b = null;
    //    0    0:aconst_null     
    //    1    1:astore_1        
        int index = m_List.getSelectedIndex();
    //    2    2:aload_0         
    //    3    3:getfield        #43  <Field JList m_List>
    //    4    6:invokevirtual   #186 <Method int JList.getSelectedIndex()>
    //    5    9:istore_2        
        if(index != -1)
    //*   6   10:iload_2         
    //*   7   11:iconst_m1       
    //*   8   12:icmpeq          42
        {
            String name = (String)m_Model.elementAt(index);
    //    9   15:aload_0         
    //   10   16:getfield        #36  <Field DefaultListModel m_Model>
    //   11   19:iload_2         
    //   12   20:invokevirtual   #190 <Method Object DefaultListModel.elementAt(int)>
    //   13   23:checkcast       #192 <Class String>
    //   14   26:astore_3        
            b = (StringBuffer)(StringBuffer)m_Results.get(name);
    //   15   27:aload_0         
    //   16   28:getfield        #48  <Field Hashtable m_Results>
    //   17   31:aload_3         
    //   18   32:invokevirtual   #153 <Method Object Hashtable.get(Object)>
    //   19   35:checkcast       #155 <Class StringBuffer>
    //   20   38:checkcast       #155 <Class StringBuffer>
    //   21   41:astore_1        
        }
        return b;
    //   22   42:aload_1         
    //   23   43:areturn         
    }

    public String getSelectedName()
    {
        int index = m_List.getSelectedIndex();
    //    0    0:aload_0         
    //    1    1:getfield        #43  <Field JList m_List>
    //    2    4:invokevirtual   #186 <Method int JList.getSelectedIndex()>
    //    3    7:istore_1        
        if(index != -1)
    //*   4    8:iload_1         
    //*   5    9:iconst_m1       
    //*   6   10:icmpeq          25
            return (String)m_Model.elementAt(index);
    //    7   13:aload_0         
    //    8   14:getfield        #36  <Field DefaultListModel m_Model>
    //    9   17:iload_1         
    //   10   18:invokevirtual   #190 <Method Object DefaultListModel.elementAt(int)>
    //   11   21:checkcast       #192 <Class String>
    //   12   24:areturn         
        else
            return null;
    //   13   25:aconst_null     
    //   14   26:areturn         
    }

    public String getNameAtIndex(int index)
    {
        if(index != -1)
    //*   0    0:iload_1         
    //*   1    1:iconst_m1       
    //*   2    2:icmpeq          17
            return (String)m_Model.elementAt(index);
    //    3    5:aload_0         
    //    4    6:getfield        #36  <Field DefaultListModel m_Model>
    //    5    9:iload_1         
    //    6   10:invokevirtual   #190 <Method Object DefaultListModel.elementAt(int)>
    //    7   13:checkcast       #192 <Class String>
    //    8   16:areturn         
        else
            return null;
    //    9   17:aconst_null     
    //   10   18:areturn         
    }

    public void setSingle(String name)
    {
        StringBuffer buff = (StringBuffer)(StringBuffer)m_Results.get(name);
    //    0    0:aload_0         
    //    1    1:getfield        #48  <Field Hashtable m_Results>
    //    2    4:aload_1         
    //    3    5:invokevirtual   #153 <Method Object Hashtable.get(Object)>
    //    4    8:checkcast       #155 <Class StringBuffer>
    //    5   11:checkcast       #155 <Class StringBuffer>
    //    6   14:astore_2        
        if(buff != null)
    //*   7   15:aload_2         
    //*   8   16:ifnull          44
        {
            m_SingleName = name;
    //    9   19:aload_0         
    //   10   20:aload_1         
    //   11   21:putfield        #206 <Field String m_SingleName>
            m_SingleText.setText(buff.toString());
    //   12   24:aload_0         
    //   13   25:getfield        #58  <Field JTextComponent m_SingleText>
    //   14   28:aload_2         
    //   15   29:invokevirtual   #209 <Method String StringBuffer.toString()>
    //   16   32:invokevirtual   #214 <Method void JTextComponent.setText(String)>
            m_List.setSelectedValue(name, true);
    //   17   35:aload_0         
    //   18   36:getfield        #43  <Field JList m_List>
    //   19   39:aload_1         
    //   20   40:iconst_1        
    //   21   41:invokevirtual   #218 <Method void JList.setSelectedValue(Object, boolean)>
        }
    //   22   44:return          
    }

    public void openFrame(String name)
    {
        StringBuffer buff = (StringBuffer)(StringBuffer)m_Results.get(name);
    //    0    0:aload_0         
    //    1    1:getfield        #48  <Field Hashtable m_Results>
    //    2    4:aload_1         
    //    3    5:invokevirtual   #153 <Method Object Hashtable.get(Object)>
    //    4    8:checkcast       #155 <Class StringBuffer>
    //    5   11:checkcast       #155 <Class StringBuffer>
    //    6   14:astore_2        
        JTextComponent currentText = (JTextComponent)(JTextComponent)m_FramedOutput.get(name);
    //    7   15:aload_0         
    //    8   16:getfield        #50  <Field Hashtable m_FramedOutput>
    //    9   19:aload_1         
    //   10   20:invokevirtual   #153 <Method Object Hashtable.get(Object)>
    //   11   23:checkcast       #211 <Class JTextComponent>
    //   12   26:checkcast       #211 <Class JTextComponent>
    //   13   29:astore_3        
        if(buff != null && currentText == null)
    //*  14   30:aload_2         
    //*  15   31:ifnull          183
    //*  16   34:aload_3         
    //*  17   35:ifnonnull       183
        {
            JTextArea ta = new JTextArea();
    //   18   38:new             #221 <Class JTextArea>
    //   19   41:dup             
    //   20   42:invokespecial   #222 <Method void JTextArea()>
    //   21   45:astore          4
            ta.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    //   22   47:aload           4
    //   23   49:iconst_5        
    //   24   50:iconst_5        
    //   25   51:iconst_5        
    //   26   52:iconst_5        
    //   27   53:invokestatic    #228 <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
    //   28   56:invokevirtual   #232 <Method void JTextArea.setBorder(javax.swing.border.Border)>
            ta.setFont(new Font("Monospaced", 0, 12));
    //   29   59:aload           4
    //   30   61:new             #234 <Class Font>
    //   31   64:dup             
    //   32   65:ldc1            #236 <String "Monospaced">
    //   33   67:iconst_0        
    //   34   68:bipush          12
    //   35   70:invokespecial   #239 <Method void Font(String, int, int)>
    //   36   73:invokevirtual   #243 <Method void JTextArea.setFont(Font)>
            ta.setEditable(false);
    //   37   76:aload           4
    //   38   78:iconst_0        
    //   39   79:invokevirtual   #247 <Method void JTextArea.setEditable(boolean)>
            ta.setText(buff.toString());
    //   40   82:aload           4
    //   41   84:aload_2         
    //   42   85:invokevirtual   #209 <Method String StringBuffer.toString()>
    //   43   88:invokevirtual   #248 <Method void JTextArea.setText(String)>
            m_FramedOutput.put(name, ta);
    //   44   91:aload_0         
    //   45   92:getfield        #50  <Field Hashtable m_FramedOutput>
    //   46   95:aload_1         
    //   47   96:aload           4
    //   48   98:invokevirtual   #144 <Method Object Hashtable.put(Object, Object)>
    //   49  101:pop             
            final JFrame jf = new JFrame(name);
    //   50  102:new             #250 <Class JFrame>
    //   51  105:dup             
    //   52  106:aload_1         
    //   53  107:invokespecial   #252 <Method void JFrame(String)>
    //   54  110:astore          5
            jf.addWindowListener(new WindowAdapter() {

                public void windowClosing(WindowEvent e)
                {
                    m_FramedOutput.remove(jf.getTitle());
                //    0    0:aload_0         
                //    1    1:getfield        #13  <Field ResultHistoryPanel this$0>
                //    2    4:getfield        #30  <Field Hashtable ResultHistoryPanel.m_FramedOutput>
                //    3    7:aload_0         
                //    4    8:getfield        #15  <Field JFrame val$jf>
                //    5   11:invokevirtual   #36  <Method String JFrame.getTitle()>
                //    6   14:invokevirtual   #42  <Method Object Hashtable.remove(Object)>
                //    7   17:pop             
                    jf.dispose();
                //    8   18:aload_0         
                //    9   19:getfield        #15  <Field JFrame val$jf>
                //   10   22:invokevirtual   #45  <Method void JFrame.dispose()>
                //   11   25:return          
                }

                final ResultHistoryPanel this$0;
                private final JFrame val$jf;

            
            {
                this$0 = ResultHistoryPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field ResultHistoryPanel this$0>
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
    //   55  112:aload           5
    //   56  114:new             #254 <Class ResultHistoryPanel$5>
    //   57  117:dup             
    //   58  118:aload_0         
    //   59  119:aload           5
    //   60  121:invokespecial   #257 <Method void ResultHistoryPanel$5(ResultHistoryPanel, JFrame)>
    //   61  124:invokevirtual   #261 <Method void JFrame.addWindowListener(java.awt.event.WindowListener)>
            jf.getContentPane().setLayout(new BorderLayout());
    //   62  127:aload           5
    //   63  129:invokevirtual   #265 <Method Container JFrame.getContentPane()>
    //   64  132:new             #98  <Class BorderLayout>
    //   65  135:dup             
    //   66  136:invokespecial   #99  <Method void BorderLayout()>
    //   67  139:invokevirtual   #268 <Method void Container.setLayout(java.awt.LayoutManager)>
            jf.getContentPane().add(new JScrollPane(ta), "Center");
    //   68  142:aload           5
    //   69  144:invokevirtual   #265 <Method Container JFrame.getContentPane()>
    //   70  147:new             #105 <Class JScrollPane>
    //   71  150:dup             
    //   72  151:aload           4
    //   73  153:invokespecial   #108 <Method void JScrollPane(java.awt.Component)>
    //   74  156:ldc1            #123 <String "Center">
    //   75  158:invokevirtual   #269 <Method void Container.add(java.awt.Component, Object)>
            jf.pack();
    //   76  161:aload           5
    //   77  163:invokevirtual   #272 <Method void JFrame.pack()>
            jf.setSize(450, 350);
    //   78  166:aload           5
    //   79  168:sipush          450
    //   80  171:sipush          350
    //   81  174:invokevirtual   #276 <Method void JFrame.setSize(int, int)>
            jf.setVisible(true);
    //   82  177:aload           5
    //   83  179:iconst_1        
    //   84  180:invokevirtual   #279 <Method void JFrame.setVisible(boolean)>
        }
    //   85  183:return          
    }

    public void updateResult(String name)
    {
        StringBuffer buff = (StringBuffer)(StringBuffer)m_Results.get(name);
    //    0    0:aload_0         
    //    1    1:getfield        #48  <Field Hashtable m_Results>
    //    2    4:aload_1         
    //    3    5:invokevirtual   #153 <Method Object Hashtable.get(Object)>
    //    4    8:checkcast       #155 <Class StringBuffer>
    //    5   11:checkcast       #155 <Class StringBuffer>
    //    6   14:astore_2        
        if(buff == null)
    //*   7   15:aload_2         
    //*   8   16:ifnonnull       20
            return;
    //    9   19:return          
        if(m_SingleName == name)
    //*  10   20:aload_0         
    //*  11   21:getfield        #206 <Field String m_SingleName>
    //*  12   24:aload_1         
    //*  13   25:if_acmpne       39
            m_SingleText.setText(buff.toString());
    //   14   28:aload_0         
    //   15   29:getfield        #58  <Field JTextComponent m_SingleText>
    //   16   32:aload_2         
    //   17   33:invokevirtual   #209 <Method String StringBuffer.toString()>
    //   18   36:invokevirtual   #214 <Method void JTextComponent.setText(String)>
        JTextComponent currentText = (JTextComponent)(JTextComponent)m_FramedOutput.get(name);
    //   19   39:aload_0         
    //   20   40:getfield        #50  <Field Hashtable m_FramedOutput>
    //   21   43:aload_1         
    //   22   44:invokevirtual   #153 <Method Object Hashtable.get(Object)>
    //   23   47:checkcast       #211 <Class JTextComponent>
    //   24   50:checkcast       #211 <Class JTextComponent>
    //   25   53:astore_3        
        if(currentText != null)
    //*  26   54:aload_3         
    //*  27   55:ifnull          66
            currentText.setText(buff.toString());
    //   28   58:aload_3         
    //   29   59:aload_2         
    //   30   60:invokevirtual   #209 <Method String StringBuffer.toString()>
    //   31   63:invokevirtual   #214 <Method void JTextComponent.setText(String)>
    //   32   66:return          
    }

    public ListSelectionModel getSelectionModel()
    {
        return m_List.getSelectionModel();
    //    0    0:aload_0         
    //    1    1:getfield        #43  <Field JList m_List>
    //    2    4:invokevirtual   #87  <Method ListSelectionModel JList.getSelectionModel()>
    //    3    7:areturn         
    }

    public JList getList()
    {
        return m_List;
    //    0    0:aload_0         
    //    1    1:getfield        #43  <Field JList m_List>
    //    2    4:areturn         
    }

    public void setHandleRightClicks(boolean tf)
    {
        m_HandleRightClicks = tf;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #54  <Field boolean m_HandleRightClicks>
    //    3    5:return          
    }

    public static void main(String args[])
    {
        try
        {
            final JFrame jf = new JFrame("Weka Explorer: Classifier");
    //    0    0:new             #250 <Class JFrame>
    //    1    3:dup             
    //    2    4:ldc2            #293 <String "Weka Explorer: Classifier">
    //    3    7:invokespecial   #252 <Method void JFrame(String)>
    //    4   10:astore_1        
            jf.getContentPane().setLayout(new BorderLayout());
    //    5   11:aload_1         
    //    6   12:invokevirtual   #265 <Method Container JFrame.getContentPane()>
    //    7   15:new             #98  <Class BorderLayout>
    //    8   18:dup             
    //    9   19:invokespecial   #99  <Method void BorderLayout()>
    //   10   22:invokevirtual   #268 <Method void Container.setLayout(java.awt.LayoutManager)>
            ResultHistoryPanel jd = new ResultHistoryPanel(null);
    //   11   25:new             #2   <Class ResultHistoryPanel>
    //   12   28:dup             
    //   13   29:aconst_null     
    //   14   30:invokespecial   #295 <Method void ResultHistoryPanel(JTextComponent)>
    //   15   33:astore_2        
            jd.addResult("blah", new StringBuffer("Nothing to see here"));
    //   16   34:aload_2         
    //   17   35:ldc2            #297 <String "blah">
    //   18   38:new             #155 <Class StringBuffer>
    //   19   41:dup             
    //   20   42:ldc2            #299 <String "Nothing to see here">
    //   21   45:invokespecial   #300 <Method void StringBuffer(String)>
    //   22   48:invokevirtual   #302 <Method void addResult(String, StringBuffer)>
            jd.addResult("blah1", new StringBuffer("Nothing to see here1"));
    //   23   51:aload_2         
    //   24   52:ldc2            #304 <String "blah1">
    //   25   55:new             #155 <Class StringBuffer>
    //   26   58:dup             
    //   27   59:ldc2            #306 <String "Nothing to see here1">
    //   28   62:invokespecial   #300 <Method void StringBuffer(String)>
    //   29   65:invokevirtual   #302 <Method void addResult(String, StringBuffer)>
            jd.addResult("blah2", new StringBuffer("Nothing to see here2"));
    //   30   68:aload_2         
    //   31   69:ldc2            #308 <String "blah2">
    //   32   72:new             #155 <Class StringBuffer>
    //   33   75:dup             
    //   34   76:ldc2            #310 <String "Nothing to see here2">
    //   35   79:invokespecial   #300 <Method void StringBuffer(String)>
    //   36   82:invokevirtual   #302 <Method void addResult(String, StringBuffer)>
            jd.addResult("blah3", new StringBuffer("Nothing to see here3"));
    //   37   85:aload_2         
    //   38   86:ldc2            #312 <String "blah3">
    //   39   89:new             #155 <Class StringBuffer>
    //   40   92:dup             
    //   41   93:ldc2            #314 <String "Nothing to see here3">
    //   42   96:invokespecial   #300 <Method void StringBuffer(String)>
    //   43   99:invokevirtual   #302 <Method void addResult(String, StringBuffer)>
            jf.getContentPane().add(jd, "Center");
    //   44  102:aload_1         
    //   45  103:invokevirtual   #265 <Method Container JFrame.getContentPane()>
    //   46  106:aload_2         
    //   47  107:ldc1            #123 <String "Center">
    //   48  109:invokevirtual   #269 <Method void Container.add(java.awt.Component, Object)>
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
    //   49  112:aload_1         
    //   50  113:new             #316 <Class ResultHistoryPanel$6>
    //   51  116:dup             
    //   52  117:aload_1         
    //   53  118:invokespecial   #319 <Method void ResultHistoryPanel$6(JFrame)>
    //   54  121:invokevirtual   #261 <Method void JFrame.addWindowListener(java.awt.event.WindowListener)>
            jf.pack();
    //   55  124:aload_1         
    //   56  125:invokevirtual   #272 <Method void JFrame.pack()>
            jf.setVisible(true);
    //   57  128:aload_1         
    //   58  129:iconst_1        
    //   59  130:invokevirtual   #279 <Method void JFrame.setVisible(boolean)>
        }
    //*  60  133:goto            151
        catch(Exception ex)
    //*  61  136:astore_1        
        {
            ex.printStackTrace();
    //   62  137:aload_1         
    //   63  138:invokevirtual   #324 <Method void Exception.printStackTrace()>
            System.err.println(ex.getMessage());
    //   64  141:getstatic       #328 <Field PrintStream System.err>
    //   65  144:aload_1         
    //   66  145:invokevirtual   #331 <Method String Exception.getMessage()>
    //   67  148:invokevirtual   #336 <Method void PrintStream.println(String)>
        }
    //   68  151:return          
    }

    static final long serialVersionUID = 0x3ba241e39273ec6dL;
    protected JTextComponent m_SingleText;
    protected String m_SingleName;
    protected DefaultListModel m_Model;
    protected JList m_List;
    protected Hashtable m_Results;
    protected Hashtable m_FramedOutput;
    protected Hashtable m_Objs;
    protected boolean m_HandleRightClicks;
    protected PrintableComponent m_Printer;
}
