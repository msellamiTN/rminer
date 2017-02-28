// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   ViewerDialog.java

package rm.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import rm.core.Instances;
import rm.gui.arffviewer.ArffPanel;
import rm.gui.arffviewer.ArffTable;

public class ViewerDialog extends JDialog
    implements ChangeListener
{

    public ViewerDialog(Frame parent)
    {
        super(parent, true);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:iconst_1        
    //    3    3:invokespecial   #29  <Method void JDialog(Frame, boolean)>
        m_Result = 1;
    //    4    6:aload_0         
    //    5    7:iconst_1        
    //    6    8:putfield        #31  <Field int m_Result>
        m_OkButton = new JButton("OK");
    //    7   11:aload_0         
    //    8   12:new             #33  <Class JButton>
    //    9   15:dup             
    //   10   16:ldc1            #35  <String "OK">
    //   11   18:invokespecial   #38  <Method void JButton(String)>
    //   12   21:putfield        #40  <Field JButton m_OkButton>
        m_CancelButton = new JButton("Cancel");
    //   13   24:aload_0         
    //   14   25:new             #33  <Class JButton>
    //   15   28:dup             
    //   16   29:ldc1            #42  <String "Cancel">
    //   17   31:invokespecial   #38  <Method void JButton(String)>
    //   18   34:putfield        #44  <Field JButton m_CancelButton>
        m_UndoButton = new JButton("Undo");
    //   19   37:aload_0         
    //   20   38:new             #33  <Class JButton>
    //   21   41:dup             
    //   22   42:ldc1            #46  <String "Undo">
    //   23   44:invokespecial   #38  <Method void JButton(String)>
    //   24   47:putfield        #48  <Field JButton m_UndoButton>
        m_ArffPanel = new ArffPanel();
    //   25   50:aload_0         
    //   26   51:new             #50  <Class ArffPanel>
    //   27   54:dup             
    //   28   55:invokespecial   #53  <Method void ArffPanel()>
    //   29   58:putfield        #55  <Field ArffPanel m_ArffPanel>
        createDialog();
    //   30   61:aload_0         
    //   31   62:invokevirtual   #58  <Method void createDialog()>
    //   32   65:return          
    }

    protected void createDialog()
    {
        setTitle("Viewer");
    //    0    0:aload_0         
    //    1    1:ldc1            #66  <String "Viewer">
    //    2    3:invokevirtual   #69  <Method void setTitle(String)>
        Toolkit tk = Toolkit.getDefaultToolkit();
    //    3    6:invokestatic    #75  <Method Toolkit Toolkit.getDefaultToolkit()>
    //    4    9:astore_2        
        java.net.URL Imagepath = getClass().getClassLoader().getResource("images/Icon.png");
    //    5   10:aload_0         
    //    6   11:invokevirtual   #81  <Method Class Object.getClass()>
    //    7   14:invokevirtual   #87  <Method ClassLoader Class.getClassLoader()>
    //    8   17:ldc1            #89  <String "images/Icon.png">
    //    9   19:invokevirtual   #95  <Method java.net.URL ClassLoader.getResource(String)>
    //   10   22:astore_3        
        java.awt.Image img = tk.getImage(Imagepath);
    //   11   23:aload_2         
    //   12   24:aload_3         
    //   13   25:invokevirtual   #99  <Method java.awt.Image Toolkit.getImage(java.net.URL)>
    //   14   28:astore          4
        setIconImage(img);
    //   15   30:aload_0         
    //   16   31:aload           4
    //   17   33:invokevirtual   #103 <Method void setIconImage(java.awt.Image)>
        getContentPane().setLayout(new BorderLayout());
    //   18   36:aload_0         
    //   19   37:invokevirtual   #107 <Method Container getContentPane()>
    //   20   40:new             #109 <Class BorderLayout>
    //   21   43:dup             
    //   22   44:invokespecial   #110 <Method void BorderLayout()>
    //   23   47:invokevirtual   #116 <Method void Container.setLayout(java.awt.LayoutManager)>
        m_ArffPanel.addChangeListener(this);
    //   24   50:aload_0         
    //   25   51:getfield        #55  <Field ArffPanel m_ArffPanel>
    //   26   54:aload_0         
    //   27   55:invokevirtual   #120 <Method void ArffPanel.addChangeListener(ChangeListener)>
        getContentPane().add(m_ArffPanel, "Center");
    //   28   58:aload_0         
    //   29   59:invokevirtual   #107 <Method Container getContentPane()>
    //   30   62:aload_0         
    //   31   63:getfield        #55  <Field ArffPanel m_ArffPanel>
    //   32   66:ldc1            #122 <String "Center">
    //   33   68:invokevirtual   #126 <Method void Container.add(java.awt.Component, Object)>
        JPanel panel = new JPanel(new FlowLayout(2));
    //   34   71:new             #128 <Class JPanel>
    //   35   74:dup             
    //   36   75:new             #130 <Class FlowLayout>
    //   37   78:dup             
    //   38   79:iconst_2        
    //   39   80:invokespecial   #133 <Method void FlowLayout(int)>
    //   40   83:invokespecial   #135 <Method void JPanel(java.awt.LayoutManager)>
    //   41   86:astore_1        
        getContentPane().add(panel, "South");
    //   42   87:aload_0         
    //   43   88:invokevirtual   #107 <Method Container getContentPane()>
    //   44   91:aload_1         
    //   45   92:ldc1            #137 <String "South">
    //   46   94:invokevirtual   #126 <Method void Container.add(java.awt.Component, Object)>
        m_UndoButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                undo();
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field ViewerDialog this$0>
            //    2    4:invokestatic    #27  <Method void ViewerDialog.access$0(ViewerDialog)>
            //    3    7:return          
            }

            final ViewerDialog this$0;

            
            {
                this$0 = ViewerDialog.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field ViewerDialog this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //   47   97:aload_0         
    //   48   98:getfield        #48  <Field JButton m_UndoButton>
    //   49  101:new             #139 <Class ViewerDialog$1>
    //   50  104:dup             
    //   51  105:aload_0         
    //   52  106:invokespecial   #142 <Method void ViewerDialog$1(ViewerDialog)>
    //   53  109:invokevirtual   #146 <Method void JButton.addActionListener(ActionListener)>
        getContentPane().add(panel, "South");
    //   54  112:aload_0         
    //   55  113:invokevirtual   #107 <Method Container getContentPane()>
    //   56  116:aload_1         
    //   57  117:ldc1            #137 <String "South">
    //   58  119:invokevirtual   #126 <Method void Container.add(java.awt.Component, Object)>
        m_CancelButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                m_Result = 1;
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field ViewerDialog this$0>
            //    2    4:iconst_1        
            //    3    5:putfield        #28  <Field int ViewerDialog.m_Result>
                setVisible(false);
            //    4    8:aload_0         
            //    5    9:getfield        #13  <Field ViewerDialog this$0>
            //    6   12:iconst_0        
            //    7   13:invokevirtual   #32  <Method void ViewerDialog.setVisible(boolean)>
            //    8   16:return          
            }

            final ViewerDialog this$0;

            
            {
                this$0 = ViewerDialog.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field ViewerDialog this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //   59  122:aload_0         
    //   60  123:getfield        #44  <Field JButton m_CancelButton>
    //   61  126:new             #148 <Class ViewerDialog$2>
    //   62  129:dup             
    //   63  130:aload_0         
    //   64  131:invokespecial   #149 <Method void ViewerDialog$2(ViewerDialog)>
    //   65  134:invokevirtual   #146 <Method void JButton.addActionListener(ActionListener)>
        m_OkButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                m_Result = 0;
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field ViewerDialog this$0>
            //    2    4:iconst_0        
            //    3    5:putfield        #28  <Field int ViewerDialog.m_Result>
                setVisible(false);
            //    4    8:aload_0         
            //    5    9:getfield        #13  <Field ViewerDialog this$0>
            //    6   12:iconst_0        
            //    7   13:invokevirtual   #32  <Method void ViewerDialog.setVisible(boolean)>
            //    8   16:return          
            }

            final ViewerDialog this$0;

            
            {
                this$0 = ViewerDialog.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field ViewerDialog this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //   66  137:aload_0         
    //   67  138:getfield        #40  <Field JButton m_OkButton>
    //   68  141:new             #151 <Class ViewerDialog$3>
    //   69  144:dup             
    //   70  145:aload_0         
    //   71  146:invokespecial   #152 <Method void ViewerDialog$3(ViewerDialog)>
    //   72  149:invokevirtual   #146 <Method void JButton.addActionListener(ActionListener)>
        panel.add(m_UndoButton);
    //   73  152:aload_1         
    //   74  153:aload_0         
    //   75  154:getfield        #48  <Field JButton m_UndoButton>
    //   76  157:invokevirtual   #155 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //   77  160:pop             
        panel.add(m_OkButton);
    //   78  161:aload_1         
    //   79  162:aload_0         
    //   80  163:getfield        #40  <Field JButton m_OkButton>
    //   81  166:invokevirtual   #155 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //   82  169:pop             
        panel.add(m_CancelButton);
    //   83  170:aload_1         
    //   84  171:aload_0         
    //   85  172:getfield        #44  <Field JButton m_CancelButton>
    //   86  175:invokevirtual   #155 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //   87  178:pop             
        pack();
    //   88  179:aload_0         
    //   89  180:invokevirtual   #158 <Method void pack()>
    //   90  183:return          
    }

    public void setInstances(Instances inst)
    {
        m_ArffPanel.setInstances(new Instances(inst));
    //    0    0:aload_0         
    //    1    1:getfield        #55  <Field ArffPanel m_ArffPanel>
    //    2    4:new             #170 <Class Instances>
    //    3    7:dup             
    //    4    8:aload_1         
    //    5    9:invokespecial   #172 <Method void Instances(Instances)>
    //    6   12:invokevirtual   #174 <Method void ArffPanel.setInstances(Instances)>
    //    7   15:return          
    }

    public Instances getInstances()
    {
        return m_ArffPanel.getInstances();
    //    0    0:aload_0         
    //    1    1:getfield        #55  <Field ArffPanel m_ArffPanel>
    //    2    4:invokevirtual   #180 <Method Instances ArffPanel.getInstances()>
    //    3    7:areturn         
    }

    protected void setButtons()
    {
        m_OkButton.setEnabled(true);
    //    0    0:aload_0         
    //    1    1:getfield        #40  <Field JButton m_OkButton>
    //    2    4:iconst_1        
    //    3    5:invokevirtual   #185 <Method void JButton.setEnabled(boolean)>
        m_CancelButton.setEnabled(true);
    //    4    8:aload_0         
    //    5    9:getfield        #44  <Field JButton m_CancelButton>
    //    6   12:iconst_1        
    //    7   13:invokevirtual   #185 <Method void JButton.setEnabled(boolean)>
        m_UndoButton.setEnabled(m_ArffPanel.canUndo());
    //    8   16:aload_0         
    //    9   17:getfield        #48  <Field JButton m_UndoButton>
    //   10   20:aload_0         
    //   11   21:getfield        #55  <Field ArffPanel m_ArffPanel>
    //   12   24:invokevirtual   #189 <Method boolean ArffPanel.canUndo()>
    //   13   27:invokevirtual   #185 <Method void JButton.setEnabled(boolean)>
    //   14   30:return          
    }

    public boolean isChanged()
    {
        return m_ArffPanel.isChanged();
    //    0    0:aload_0         
    //    1    1:getfield        #55  <Field ArffPanel m_ArffPanel>
    //    2    4:invokevirtual   #192 <Method boolean ArffPanel.isChanged()>
    //    3    7:ireturn         
    }

    private void undo()
    {
        m_ArffPanel.undo();
    //    0    0:aload_0         
    //    1    1:getfield        #55  <Field ArffPanel m_ArffPanel>
    //    2    4:invokevirtual   #195 <Method void ArffPanel.undo()>
        m_ArffPanel.m_TableArff.updateUI();
    //    3    7:aload_0         
    //    4    8:getfield        #55  <Field ArffPanel m_ArffPanel>
    //    5   11:getfield        #199 <Field ArffTable ArffPanel.m_TableArff>
    //    6   14:invokevirtual   #204 <Method void ArffTable.updateUI()>
    //    7   17:return          
    }

    public void stateChanged(ChangeEvent e)
    {
        setButtons();
    //    0    0:aload_0         
    //    1    1:invokevirtual   #208 <Method void setButtons()>
    //    2    4:return          
    }

    public int showDialog()
    {
        m_Result = 1;
    //    0    0:aload_0         
    //    1    1:iconst_1        
    //    2    2:putfield        #31  <Field int m_Result>
        setVisible(true);
    //    3    5:aload_0         
    //    4    6:iconst_1        
    //    5    7:invokevirtual   #215 <Method void setVisible(boolean)>
        setButtons();
    //    6   10:aload_0         
    //    7   11:invokevirtual   #208 <Method void setButtons()>
        return m_Result;
    //    8   14:aload_0         
    //    9   15:getfield        #31  <Field int m_Result>
    //   10   18:ireturn         
    }

    public int showDialog(Instances inst)
    {
        setInstances(inst);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokevirtual   #217 <Method void setInstances(Instances)>
        return showDialog();
    //    3    5:aload_0         
    //    4    6:invokevirtual   #219 <Method int showDialog()>
    //    5    9:ireturn         
    }

    private static final long serialVersionUID = 0x5da4b635ff077a88L;
    public static final int APPROVE_OPTION = 0;
    public static final int CANCEL_OPTION = 1;
    protected int m_Result;
    protected JButton m_OkButton;
    protected JButton m_CancelButton;
    protected JButton m_UndoButton;
    protected ArffPanel m_ArffPanel;


/*
    static void access$0(ViewerDialog viewerdialog)
    {
        viewerdialog.undo();
    //    0    0:aload_0         
    //    1    1:invokespecial   #221 <Method void undo()>
        return;
    //    2    4:return          
    }

*/
}
