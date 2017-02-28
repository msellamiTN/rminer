// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   PropertyPanel.java

package rm.gui;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import java.beans.*;
import javax.swing.*;
import rm.core.OptionHandler;
import rm.core.Utils;

// Referenced classes of package rm.gui:
//            CustomPanelSupplier, PropertyDialog

public class PropertyPanel extends JPanel
{

    public PropertyPanel(PropertyEditor pe)
    {
        this(pe, false);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:iconst_0        
    //    3    3:invokespecial   #20  <Method void PropertyPanel(PropertyEditor, boolean)>
    //    4    6:return          
    }

    public PropertyPanel(PropertyEditor pe, boolean ignoreCustomPanel)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #28  <Method void JPanel()>
        m_HasCustomPanel = false;
    //    2    4:aload_0         
    //    3    5:iconst_0        
    //    4    6:putfield        #30  <Field boolean m_HasCustomPanel>
        m_Editor = pe;
    //    5    9:aload_0         
    //    6   10:aload_1         
    //    7   11:putfield        #32  <Field PropertyEditor m_Editor>
        if(!ignoreCustomPanel && (m_Editor instanceof CustomPanelSupplier))
    //*   8   14:iload_2         
    //*   9   15:ifne            73
    //*  10   18:aload_0         
    //*  11   19:getfield        #32  <Field PropertyEditor m_Editor>
    //*  12   22:instanceof      #34  <Class CustomPanelSupplier>
    //*  13   25:ifeq            73
        {
            setLayout(new BorderLayout());
    //   14   28:aload_0         
    //   15   29:new             #36  <Class BorderLayout>
    //   16   32:dup             
    //   17   33:invokespecial   #37  <Method void BorderLayout()>
    //   18   36:invokevirtual   #41  <Method void setLayout(java.awt.LayoutManager)>
            m_CustomPanel = ((CustomPanelSupplier)m_Editor).getCustomPanel();
    //   19   39:aload_0         
    //   20   40:aload_0         
    //   21   41:getfield        #32  <Field PropertyEditor m_Editor>
    //   22   44:checkcast       #34  <Class CustomPanelSupplier>
    //   23   47:invokeinterface #45  <Method JPanel CustomPanelSupplier.getCustomPanel()>
    //   24   52:putfield        #47  <Field JPanel m_CustomPanel>
            add(m_CustomPanel, "Center");
    //   25   55:aload_0         
    //   26   56:aload_0         
    //   27   57:getfield        #47  <Field JPanel m_CustomPanel>
    //   28   60:ldc1            #49  <String "Center">
    //   29   62:invokevirtual   #53  <Method void add(Component, Object)>
            m_HasCustomPanel = true;
    //   30   65:aload_0         
    //   31   66:iconst_1        
    //   32   67:putfield        #30  <Field boolean m_HasCustomPanel>
        } else
    //*  33   70:goto            77
        {
            createDefaultPanel();
    //   34   73:aload_0         
    //   35   74:invokevirtual   #56  <Method void createDefaultPanel()>
        }
    //   36   77:return          
    }

    protected void createDefaultPanel()
    {
        setBorder(BorderFactory.createEtchedBorder());
    //    0    0:aload_0         
    //    1    1:invokestatic    #63  <Method javax.swing.border.Border BorderFactory.createEtchedBorder()>
    //    2    4:invokevirtual   #67  <Method void setBorder(javax.swing.border.Border)>
        setToolTipText("Left-click to edit properties for this object, right-click/Alt+Shift+left-click for menu");
    //    3    7:aload_0         
    //    4    8:ldc1            #69  <String "Left-click to edit properties for this object, right-click/Alt+Shift+left-click for menu">
    //    5   10:invokevirtual   #73  <Method void setToolTipText(String)>
        setOpaque(true);
    //    6   13:aload_0         
    //    7   14:iconst_1        
    //    8   15:invokevirtual   #77  <Method void setOpaque(boolean)>
        final Component comp = this;
    //    9   18:aload_0         
    //   10   19:astore_1        
        addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent evt)
            {
                if(evt.getClickCount() == 1)
            //*   0    0:aload_1         
            //*   1    1:invokevirtual   #30  <Method int MouseEvent.getClickCount()>
            //*   2    4:iconst_1        
            //*   3    5:icmpne          197
                    if(evt.getButton() == 1 && !evt.isAltDown() && !evt.isShiftDown())
            //*   4    8:aload_1         
            //*   5    9:invokevirtual   #33  <Method int MouseEvent.getButton()>
            //*   6   12:iconst_1        
            //*   7   13:icmpne          40
            //*   8   16:aload_1         
            //*   9   17:invokevirtual   #37  <Method boolean MouseEvent.isAltDown()>
            //*  10   20:ifne            40
            //*  11   23:aload_1         
            //*  12   24:invokevirtual   #40  <Method boolean MouseEvent.isShiftDown()>
            //*  13   27:ifne            40
                        showPropertyDialog();
            //   14   30:aload_0         
            //   15   31:getfield        #13  <Field PropertyPanel this$0>
            //   16   34:invokevirtual   #45  <Method void PropertyPanel.showPropertyDialog()>
                    else
            //*  17   37:goto            197
                    if(evt.getButton() == 3 || evt.getButton() == 1 && evt.isAltDown() && evt.isShiftDown())
            //*  18   40:aload_1         
            //*  19   41:invokevirtual   #33  <Method int MouseEvent.getButton()>
            //*  20   44:iconst_3        
            //*  21   45:icmpeq          70
            //*  22   48:aload_1         
            //*  23   49:invokevirtual   #33  <Method int MouseEvent.getButton()>
            //*  24   52:iconst_1        
            //*  25   53:icmpne          197
            //*  26   56:aload_1         
            //*  27   57:invokevirtual   #37  <Method boolean MouseEvent.isAltDown()>
            //*  28   60:ifeq            197
            //*  29   63:aload_1         
            //*  30   64:invokevirtual   #40  <Method boolean MouseEvent.isShiftDown()>
            //*  31   67:ifeq            197
                    {
                        JPopupMenu menu = new JPopupMenu();
            //   32   70:new             #47  <Class JPopupMenu>
            //   33   73:dup             
            //   34   74:invokespecial   #48  <Method void JPopupMenu()>
            //   35   77:astore_2        
                        JMenuItem item;
                        if(m_Editor.getValue() != null)
            //*  36   78:aload_0         
            //*  37   79:getfield        #13  <Field PropertyPanel this$0>
            //*  38   82:invokestatic    #52  <Method PropertyEditor PropertyPanel.access$0(PropertyPanel)>
            //*  39   85:invokeinterface #58  <Method Object PropertyEditor.getValue()>
            //*  40   90:ifnull          149
                        {
                            item = new JMenuItem("Show properties...");
            //   41   93:new             #60  <Class JMenuItem>
            //   42   96:dup             
            //   43   97:ldc1            #62  <String "Show properties...">
            //   44   99:invokespecial   #65  <Method void JMenuItem(String)>
            //   45  102:astore_3        
                            item.addActionListener(new ActionListener() {

                                public void actionPerformed(ActionEvent e)
                                {
                                    showPropertyDialog();
                                //    0    0:aload_0         
                                //    1    1:getfield        #13  <Field PropertyPanel$1 this$1>
                                //    2    4:invokestatic    #28  <Method PropertyPanel PropertyPanel$1.access$0(PropertyPanel$1)>
                                //    3    7:invokevirtual   #33  <Method void PropertyPanel.showPropertyDialog()>
                                //    4   10:return          
                                }

                                final _cls1 this$1;

                    
                    {
                        this$1 = _cls1.this;
                    //    0    0:aload_0         
                    //    1    1:aload_1         
                    //    2    2:putfield        #13  <Field PropertyPanel$1 this$1>
                        super();
                    //    3    5:aload_0         
                    //    4    6:invokespecial   #16  <Method void Object()>
                    //    5    9:return          
                    }
                            }
);
            //   46  103:aload_3         
            //   47  104:new             #67  <Class PropertyPanel$2>
            //   48  107:dup             
            //   49  108:aload_0         
            //   50  109:invokespecial   #70  <Method void PropertyPanel$2(PropertyPanel$1)>
            //   51  112:invokevirtual   #74  <Method void JMenuItem.addActionListener(ActionListener)>
                            menu.add(item);
            //   52  115:aload_2         
            //   53  116:aload_3         
            //   54  117:invokevirtual   #78  <Method JMenuItem JPopupMenu.add(JMenuItem)>
            //   55  120:pop             
                            item = new JMenuItem("Copy configuration to clipboard");
            //   56  121:new             #60  <Class JMenuItem>
            //   57  124:dup             
            //   58  125:ldc1            #80  <String "Copy configuration to clipboard">
            //   59  127:invokespecial   #65  <Method void JMenuItem(String)>
            //   60  130:astore_3        
                            item.addActionListener(new ActionListener() {

                                public void actionPerformed(ActionEvent e)
                                {
                                    String str = m_Editor.getValue().getClass().getName();
                                //    0    0:aload_0         
                                //    1    1:getfield        #13  <Field PropertyPanel$1 this$1>
                                //    2    4:invokestatic    #28  <Method PropertyPanel PropertyPanel$1.access$0(PropertyPanel$1)>
                                //    3    7:invokestatic    #33  <Method PropertyEditor PropertyPanel.access$0(PropertyPanel)>
                                //    4   10:invokeinterface #39  <Method Object PropertyEditor.getValue()>
                                //    5   15:invokevirtual   #43  <Method Class Object.getClass()>
                                //    6   18:invokevirtual   #49  <Method String Class.getName()>
                                //    7   21:astore_2        
                                    if(m_Editor.getValue() instanceof OptionHandler)
                                //*   8   22:aload_0         
                                //*   9   23:getfield        #13  <Field PropertyPanel$1 this$1>
                                //*  10   26:invokestatic    #28  <Method PropertyPanel PropertyPanel$1.access$0(PropertyPanel$1)>
                                //*  11   29:invokestatic    #33  <Method PropertyEditor PropertyPanel.access$0(PropertyPanel)>
                                //*  12   32:invokeinterface #39  <Method Object PropertyEditor.getValue()>
                                //*  13   37:instanceof      #51  <Class OptionHandler>
                                //*  14   40:ifeq            92
                                        str = (new StringBuilder(String.valueOf(str))).append(" ").append(Utils.joinOptions(((OptionHandler)m_Editor.getValue()).getOptions())).toString();
                                //   15   43:new             #53  <Class StringBuilder>
                                //   16   46:dup             
                                //   17   47:aload_2         
                                //   18   48:invokestatic    #59  <Method String String.valueOf(Object)>
                                //   19   51:invokespecial   #62  <Method void StringBuilder(String)>
                                //   20   54:ldc1            #64  <String " ">
                                //   21   56:invokevirtual   #68  <Method StringBuilder StringBuilder.append(String)>
                                //   22   59:aload_0         
                                //   23   60:getfield        #13  <Field PropertyPanel$1 this$1>
                                //   24   63:invokestatic    #28  <Method PropertyPanel PropertyPanel$1.access$0(PropertyPanel$1)>
                                //   25   66:invokestatic    #33  <Method PropertyEditor PropertyPanel.access$0(PropertyPanel)>
                                //   26   69:invokeinterface #39  <Method Object PropertyEditor.getValue()>
                                //   27   74:checkcast       #51  <Class OptionHandler>
                                //   28   77:invokeinterface #72  <Method String[] OptionHandler.getOptions()>
                                //   29   82:invokestatic    #78  <Method String Utils.joinOptions(String[])>
                                //   30   85:invokevirtual   #68  <Method StringBuilder StringBuilder.append(String)>
                                //   31   88:invokevirtual   #81  <Method String StringBuilder.toString()>
                                //   32   91:astore_2        
                                    StringSelection selection = new StringSelection(str.trim());
                                //   33   92:new             #83  <Class StringSelection>
                                //   34   95:dup             
                                //   35   96:aload_2         
                                //   36   97:invokevirtual   #86  <Method String String.trim()>
                                //   37  100:invokespecial   #87  <Method void StringSelection(String)>
                                //   38  103:astore_3        
                                    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                                //   39  104:invokestatic    #93  <Method Toolkit Toolkit.getDefaultToolkit()>
                                //   40  107:invokevirtual   #97  <Method Clipboard Toolkit.getSystemClipboard()>
                                //   41  110:astore          4
                                    clipboard.setContents(selection, selection);
                                //   42  112:aload           4
                                //   43  114:aload_3         
                                //   44  115:aload_3         
                                //   45  116:invokevirtual   #103 <Method void Clipboard.setContents(java.awt.datatransfer.Transferable, java.awt.datatransfer.ClipboardOwner)>
                                //   46  119:return          
                                }

                                final _cls1 this$1;

                    
                    {
                        this$1 = _cls1.this;
                    //    0    0:aload_0         
                    //    1    1:aload_1         
                    //    2    2:putfield        #13  <Field PropertyPanel$1 this$1>
                        super();
                    //    3    5:aload_0         
                    //    4    6:invokespecial   #16  <Method void Object()>
                    //    5    9:return          
                    }
                            }
);
            //   61  131:aload_3         
            //   62  132:new             #82  <Class PropertyPanel$3>
            //   63  135:dup             
            //   64  136:aload_0         
            //   65  137:invokespecial   #83  <Method void PropertyPanel$3(PropertyPanel$1)>
            //   66  140:invokevirtual   #74  <Method void JMenuItem.addActionListener(ActionListener)>
                            menu.add(item);
            //   67  143:aload_2         
            //   68  144:aload_3         
            //   69  145:invokevirtual   #78  <Method JMenuItem JPopupMenu.add(JMenuItem)>
            //   70  148:pop             
                        }
                        item = new JMenuItem("Enter configuration...");
            //   71  149:new             #60  <Class JMenuItem>
            //   72  152:dup             
            //   73  153:ldc1            #85  <String "Enter configuration...">
            //   74  155:invokespecial   #65  <Method void JMenuItem(String)>
            //   75  158:astore_3        
                        item.addActionListener(new ActionListener() {

                            public void actionPerformed(ActionEvent e)
                            {
                                String str = JOptionPane.showInputDialog(comp, "Configuration (<classname> [<options>])");
                            //    0    0:aload_0         
                            //    1    1:getfield        #17  <Field Component val$comp>
                            //    2    4:ldc1            #28  <String "Configuration (<classname> [<options>])">
                            //    3    6:invokestatic    #34  <Method String JOptionPane.showInputDialog(Component, Object)>
                            //    4    9:astore_2        
                                if(str != null)
                            //*   5   10:aload_2         
                            //*   6   11:ifnull          86
                                    try
                                    {
                                        String options[] = Utils.splitOptions(str);
                            //    7   14:aload_2         
                            //    8   15:invokestatic    #40  <Method String[] Utils.splitOptions(String)>
                            //    9   18:astore_3        
                                        String classname = options[0];
                            //   10   19:aload_3         
                            //   11   20:iconst_0        
                            //   12   21:aaload          
                            //   13   22:astore          4
                                        options[0] = "";
                            //   14   24:aload_3         
                            //   15   25:iconst_0        
                            //   16   26:ldc1            #42  <String "">
                            //   17   28:aastore         
                                        m_Editor.setValue(Utils.forName(java/lang/Object, classname, options));
                            //   18   29:aload_0         
                            //   19   30:getfield        #15  <Field PropertyPanel$1 this$1>
                            //   20   33:invokestatic    #48  <Method PropertyPanel PropertyPanel$1.access$0(PropertyPanel$1)>
                            //   21   36:invokestatic    #53  <Method PropertyEditor PropertyPanel.access$0(PropertyPanel)>
                            //   22   39:ldc1            #4   <Class Object>
                            //   23   41:aload           4
                            //   24   43:aload_3         
                            //   25   44:invokestatic    #57  <Method Object Utils.forName(Class, String, String[])>
                            //   26   47:invokeinterface #63  <Method void PropertyEditor.setValue(Object)>
                                    }
                            //*  27   52:goto            86
                                    catch(Exception ex)
                            //*  28   55:astore_3        
                                    {
                                        ex.printStackTrace();
                            //   29   56:aload_3         
                            //   30   57:invokevirtual   #68  <Method void Exception.printStackTrace()>
                                        JOptionPane.showMessageDialog(comp, (new StringBuilder("Error parsing commandline:\n")).append(ex).toString(), "Error...", 0);
                            //   31   60:aload_0         
                            //   32   61:getfield        #17  <Field Component val$comp>
                            //   33   64:new             #70  <Class StringBuilder>
                            //   34   67:dup             
                            //   35   68:ldc1            #72  <String "Error parsing commandline:\n">
                            //   36   70:invokespecial   #75  <Method void StringBuilder(String)>
                            //   37   73:aload_3         
                            //   38   74:invokevirtual   #79  <Method StringBuilder StringBuilder.append(Object)>
                            //   39   77:invokevirtual   #83  <Method String StringBuilder.toString()>
                            //   40   80:ldc1            #85  <String "Error...">
                            //   41   82:iconst_0        
                            //   42   83:invokestatic    #89  <Method void JOptionPane.showMessageDialog(Component, Object, String, int)>
                                    }
                            //   43   86:return          
                            }

                            final _cls1 this$1;
                            private final Component val$comp;

                    
                    {
                        this$1 = _cls1.this;
                    //    0    0:aload_0         
                    //    1    1:aload_1         
                    //    2    2:putfield        #15  <Field PropertyPanel$1 this$1>
                        comp = component;
                    //    3    5:aload_0         
                    //    4    6:aload_2         
                    //    5    7:putfield        #17  <Field Component val$comp>
                        super();
                    //    6   10:aload_0         
                    //    7   11:invokespecial   #20  <Method void Object()>
                    //    8   14:return          
                    }
                        }
);
            //   76  159:aload_3         
            //   77  160:new             #87  <Class PropertyPanel$4>
            //   78  163:dup             
            //   79  164:aload_0         
            //   80  165:aload_0         
            //   81  166:getfield        #15  <Field Component val$comp>
            //   82  169:invokespecial   #90  <Method void PropertyPanel$4(PropertyPanel$1, Component)>
            //   83  172:invokevirtual   #74  <Method void JMenuItem.addActionListener(ActionListener)>
                        menu.add(item);
            //   84  175:aload_2         
            //   85  176:aload_3         
            //   86  177:invokevirtual   #78  <Method JMenuItem JPopupMenu.add(JMenuItem)>
            //   87  180:pop             
                        menu.show(comp, evt.getX(), evt.getY());
            //   88  181:aload_2         
            //   89  182:aload_0         
            //   90  183:getfield        #15  <Field Component val$comp>
            //   91  186:aload_1         
            //   92  187:invokevirtual   #93  <Method int MouseEvent.getX()>
            //   93  190:aload_1         
            //   94  191:invokevirtual   #96  <Method int MouseEvent.getY()>
            //   95  194:invokevirtual   #100 <Method void JPopupMenu.show(Component, int, int)>
                    }
            //   96  197:return          
            }

            final PropertyPanel this$0;
            private final Component val$comp;


/*
            static PropertyPanel access$0(_cls1 _pcls1)
            {
                return _pcls1.this$0;
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field PropertyPanel this$0>
            //    2    4:areturn         
            }

*/

            
            {
                this$0 = PropertyPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field PropertyPanel this$0>
                comp = component;
            //    3    5:aload_0         
            //    4    6:aload_2         
            //    5    7:putfield        #15  <Field Component val$comp>
                super();
            //    6   10:aload_0         
            //    7   11:invokespecial   #18  <Method void MouseAdapter()>
            //    8   14:return          
            }
        }
);
    //   11   20:aload_0         
    //   12   21:new             #79  <Class PropertyPanel$1>
    //   13   24:dup             
    //   14   25:aload_0         
    //   15   26:aload_1         
    //   16   27:invokespecial   #82  <Method void PropertyPanel$1(PropertyPanel, Component)>
    //   17   30:invokevirtual   #86  <Method void addMouseListener(java.awt.event.MouseListener)>
        Dimension newPref = getPreferredSize();
    //   18   33:aload_0         
    //   19   34:invokevirtual   #90  <Method Dimension getPreferredSize()>
    //   20   37:astore_2        
        newPref.height = (getFontMetrics(getFont()).getHeight() * 5) / 4;
    //   21   38:aload_2         
    //   22   39:aload_0         
    //   23   40:aload_0         
    //   24   41:invokevirtual   #94  <Method java.awt.Font getFont()>
    //   25   44:invokevirtual   #98  <Method FontMetrics getFontMetrics(java.awt.Font)>
    //   26   47:invokevirtual   #104 <Method int FontMetrics.getHeight()>
    //   27   50:iconst_5        
    //   28   51:imul            
    //   29   52:iconst_4        
    //   30   53:idiv            
    //   31   54:putfield        #110 <Field int Dimension.height>
        newPref.width = newPref.height * 5;
    //   32   57:aload_2         
    //   33   58:aload_2         
    //   34   59:getfield        #110 <Field int Dimension.height>
    //   35   62:iconst_5        
    //   36   63:imul            
    //   37   64:putfield        #113 <Field int Dimension.width>
        setPreferredSize(newPref);
    //   38   67:aload_0         
    //   39   68:aload_2         
    //   40   69:invokevirtual   #117 <Method void setPreferredSize(Dimension)>
        m_Editor.addPropertyChangeListener(new PropertyChangeListener() {

            public void propertyChange(PropertyChangeEvent evt)
            {
                repaint();
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field PropertyPanel this$0>
            //    2    4:invokevirtual   #27  <Method void PropertyPanel.repaint()>
            //    3    7:return          
            }

            final PropertyPanel this$0;

            
            {
                this$0 = PropertyPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field PropertyPanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //   41   72:aload_0         
    //   42   73:getfield        #32  <Field PropertyEditor m_Editor>
    //   43   76:new             #119 <Class PropertyPanel$5>
    //   44   79:dup             
    //   45   80:aload_0         
    //   46   81:invokespecial   #122 <Method void PropertyPanel$5(PropertyPanel)>
    //   47   84:invokeinterface #128 <Method void PropertyEditor.addPropertyChangeListener(PropertyChangeListener)>
    //   48   89:return          
    }

    public void showPropertyDialog()
    {
        if(m_Editor.getValue() != null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #32  <Field PropertyEditor m_Editor>
    //*   2    4:invokeinterface #137 <Method Object PropertyEditor.getValue()>
    //*   3    9:ifnull          124
        {
            if(m_PD == null)
    //*   4   12:aload_0         
    //*   5   13:getfield        #139 <Field PropertyDialog m_PD>
    //*   6   16:ifnonnull       98
            {
                int x = getLocationOnScreen().x;
    //    7   19:aload_0         
    //    8   20:invokevirtual   #143 <Method Point getLocationOnScreen()>
    //    9   23:getfield        #148 <Field int Point.x>
    //   10   26:istore_1        
                int y = getLocationOnScreen().y;
    //   11   27:aload_0         
    //   12   28:invokevirtual   #143 <Method Point getLocationOnScreen()>
    //   13   31:getfield        #151 <Field int Point.y>
    //   14   34:istore_2        
                if(PropertyDialog.getParentDialog(this) != null)
    //*  15   35:aload_0         
    //*  16   36:invokestatic    #157 <Method java.awt.Dialog PropertyDialog.getParentDialog(java.awt.Container)>
    //*  17   39:ifnull          66
                    m_PD = new PropertyDialog(PropertyDialog.getParentDialog(this), m_Editor, x, y);
    //   18   42:aload_0         
    //   19   43:new             #153 <Class PropertyDialog>
    //   20   46:dup             
    //   21   47:aload_0         
    //   22   48:invokestatic    #157 <Method java.awt.Dialog PropertyDialog.getParentDialog(java.awt.Container)>
    //   23   51:aload_0         
    //   24   52:getfield        #32  <Field PropertyEditor m_Editor>
    //   25   55:iload_1         
    //   26   56:iload_2         
    //   27   57:invokespecial   #160 <Method void PropertyDialog(java.awt.Dialog, PropertyEditor, int, int)>
    //   28   60:putfield        #139 <Field PropertyDialog m_PD>
                else
    //*  29   63:goto            87
                    m_PD = new PropertyDialog(PropertyDialog.getParentFrame(this), m_Editor, x, y);
    //   30   66:aload_0         
    //   31   67:new             #153 <Class PropertyDialog>
    //   32   70:dup             
    //   33   71:aload_0         
    //   34   72:invokestatic    #164 <Method java.awt.Frame PropertyDialog.getParentFrame(java.awt.Container)>
    //   35   75:aload_0         
    //   36   76:getfield        #32  <Field PropertyEditor m_Editor>
    //   37   79:iload_1         
    //   38   80:iload_2         
    //   39   81:invokespecial   #167 <Method void PropertyDialog(java.awt.Frame, PropertyEditor, int, int)>
    //   40   84:putfield        #139 <Field PropertyDialog m_PD>
                m_PD.setVisible(true);
    //   41   87:aload_0         
    //   42   88:getfield        #139 <Field PropertyDialog m_PD>
    //   43   91:iconst_1        
    //   44   92:invokevirtual   #170 <Method void PropertyDialog.setVisible(boolean)>
            } else
    //*  45   95:goto            106
            {
                m_PD.setVisible(true);
    //   46   98:aload_0         
    //   47   99:getfield        #139 <Field PropertyDialog m_PD>
    //   48  102:iconst_1        
    //   49  103:invokevirtual   #170 <Method void PropertyDialog.setVisible(boolean)>
            }
            m_Editor.setValue(m_Editor.getValue());
    //   50  106:aload_0         
    //   51  107:getfield        #32  <Field PropertyEditor m_Editor>
    //   52  110:aload_0         
    //   53  111:getfield        #32  <Field PropertyEditor m_Editor>
    //   54  114:invokeinterface #137 <Method Object PropertyEditor.getValue()>
    //   55  119:invokeinterface #174 <Method void PropertyEditor.setValue(Object)>
        }
    //   56  124:return          
    }

    public void removeNotify()
    {
        super.removeNotify();
    //    0    0:aload_0         
    //    1    1:invokespecial   #177 <Method void JPanel.removeNotify()>
        if(m_PD != null)
    //*   2    4:aload_0         
    //*   3    5:getfield        #139 <Field PropertyDialog m_PD>
    //*   4    8:ifnull          23
        {
            m_PD.dispose();
    //    5   11:aload_0         
    //    6   12:getfield        #139 <Field PropertyDialog m_PD>
    //    7   15:invokevirtual   #180 <Method void PropertyDialog.dispose()>
            m_PD = null;
    //    8   18:aload_0         
    //    9   19:aconst_null     
    //   10   20:putfield        #139 <Field PropertyDialog m_PD>
        }
    //   11   23:return          
    }

    public void setEnabled(boolean enabled)
    {
        super.setEnabled(enabled);
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:invokespecial   #183 <Method void JPanel.setEnabled(boolean)>
        if(m_HasCustomPanel)
    //*   3    5:aload_0         
    //*   4    6:getfield        #30  <Field boolean m_HasCustomPanel>
    //*   5    9:ifeq            20
            m_CustomPanel.setEnabled(enabled);
    //    6   12:aload_0         
    //    7   13:getfield        #47  <Field JPanel m_CustomPanel>
    //    8   16:iload_1         
    //    9   17:invokevirtual   #183 <Method void JPanel.setEnabled(boolean)>
    //   10   20:return          
    }

    public void paintComponent(Graphics g)
    {
        if(!m_HasCustomPanel)
    //*   0    0:aload_0         
    //*   1    1:getfield        #30  <Field boolean m_HasCustomPanel>
    //*   2    4:ifne            123
        {
            Insets i = getInsets();
    //    3    7:aload_0         
    //    4    8:invokevirtual   #190 <Method Insets getInsets()>
    //    5   11:astore_2        
            Rectangle box = new Rectangle(i.left, i.top, getSize().width - i.left - i.right - 1, getSize().height - i.top - i.bottom - 1);
    //    6   12:new             #192 <Class Rectangle>
    //    7   15:dup             
    //    8   16:aload_2         
    //    9   17:getfield        #197 <Field int Insets.left>
    //   10   20:aload_2         
    //   11   21:getfield        #200 <Field int Insets.top>
    //   12   24:aload_0         
    //   13   25:invokevirtual   #203 <Method Dimension getSize()>
    //   14   28:getfield        #113 <Field int Dimension.width>
    //   15   31:aload_2         
    //   16   32:getfield        #197 <Field int Insets.left>
    //   17   35:isub            
    //   18   36:aload_2         
    //   19   37:getfield        #206 <Field int Insets.right>
    //   20   40:isub            
    //   21   41:iconst_1        
    //   22   42:isub            
    //   23   43:aload_0         
    //   24   44:invokevirtual   #203 <Method Dimension getSize()>
    //   25   47:getfield        #110 <Field int Dimension.height>
    //   26   50:aload_2         
    //   27   51:getfield        #200 <Field int Insets.top>
    //   28   54:isub            
    //   29   55:aload_2         
    //   30   56:getfield        #209 <Field int Insets.bottom>
    //   31   59:isub            
    //   32   60:iconst_1        
    //   33   61:isub            
    //   34   62:invokespecial   #212 <Method void Rectangle(int, int, int, int)>
    //   35   65:astore_3        
            g.clearRect(i.left, i.top, getSize().width - i.right - i.left, getSize().height - i.bottom - i.top);
    //   36   66:aload_1         
    //   37   67:aload_2         
    //   38   68:getfield        #197 <Field int Insets.left>
    //   39   71:aload_2         
    //   40   72:getfield        #200 <Field int Insets.top>
    //   41   75:aload_0         
    //   42   76:invokevirtual   #203 <Method Dimension getSize()>
    //   43   79:getfield        #113 <Field int Dimension.width>
    //   44   82:aload_2         
    //   45   83:getfield        #206 <Field int Insets.right>
    //   46   86:isub            
    //   47   87:aload_2         
    //   48   88:getfield        #197 <Field int Insets.left>
    //   49   91:isub            
    //   50   92:aload_0         
    //   51   93:invokevirtual   #203 <Method Dimension getSize()>
    //   52   96:getfield        #110 <Field int Dimension.height>
    //   53   99:aload_2         
    //   54  100:getfield        #209 <Field int Insets.bottom>
    //   55  103:isub            
    //   56  104:aload_2         
    //   57  105:getfield        #200 <Field int Insets.top>
    //   58  108:isub            
    //   59  109:invokevirtual   #217 <Method void Graphics.clearRect(int, int, int, int)>
            m_Editor.paintValue(g, box);
    //   60  112:aload_0         
    //   61  113:getfield        #32  <Field PropertyEditor m_Editor>
    //   62  116:aload_1         
    //   63  117:aload_3         
    //   64  118:invokeinterface #221 <Method void PropertyEditor.paintValue(Graphics, Rectangle)>
        }
    //   65  123:return          
    }

    private PropertyEditor m_Editor;
    private PropertyDialog m_PD;
    private boolean m_HasCustomPanel;
    private JPanel m_CustomPanel;
    static Class class$0;


/*
    static PropertyEditor access$0(PropertyPanel propertypanel)
    {
        return propertypanel.m_Editor;
    //    0    0:aload_0         
    //    1    1:getfield        #32  <Field PropertyEditor m_Editor>
    //    2    4:areturn         
    }

*/
}
