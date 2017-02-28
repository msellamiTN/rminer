// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   AssignmentViewer.java

package rm.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import rm.core.Assignment;
import rm.gui.graph.EditPanel;

public class AssignmentViewer extends JFrame
{

    public AssignmentViewer(Assignment newAssignment)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #29  <Method void JFrame()>
        m_Result = 1;
    //    2    4:aload_0         
    //    3    5:iconst_1        
    //    4    6:putfield        #31  <Field int m_Result>
        m_OkButton = new JButton("OK");
    //    5    9:aload_0         
    //    6   10:new             #33  <Class JButton>
    //    7   13:dup             
    //    8   14:ldc1            #35  <String "OK">
    //    9   16:invokespecial   #38  <Method void JButton(String)>
    //   10   19:putfield        #40  <Field JButton m_OkButton>
        m_CancelButton = new JButton("Cancel");
    //   11   22:aload_0         
    //   12   23:new             #33  <Class JButton>
    //   13   26:dup             
    //   14   27:ldc1            #42  <String "Cancel">
    //   15   29:invokespecial   #38  <Method void JButton(String)>
    //   16   32:putfield        #44  <Field JButton m_CancelButton>
        m_UndoButton = new JButton("Undo");
    //   17   35:aload_0         
    //   18   36:new             #33  <Class JButton>
    //   19   39:dup             
    //   20   40:ldc1            #46  <String "Undo">
    //   21   42:invokespecial   #38  <Method void JButton(String)>
    //   22   45:putfield        #48  <Field JButton m_UndoButton>
    //   23   48:aload_0         
    //   24   49:sipush          800
    //   25   52:putfield        #50  <Field int DEFAULT_WIDTH>
    //   26   55:aload_0         
    //   27   56:sipush          600
    //   28   59:putfield        #52  <Field int DEFAULT_HEIGHT>
        setTitle("Viewer");
    //   29   62:aload_0         
    //   30   63:ldc1            #54  <String "Viewer">
    //   31   65:invokevirtual   #57  <Method void setTitle(String)>
        m_Assignment = newAssignment;
    //   32   68:aload_0         
    //   33   69:aload_1         
    //   34   70:putfield        #59  <Field Assignment m_Assignment>
        getContentPane().setLayout(new BorderLayout());
    //   35   73:aload_0         
    //   36   74:invokevirtual   #63  <Method Container getContentPane()>
    //   37   77:new             #65  <Class BorderLayout>
    //   38   80:dup             
    //   39   81:invokespecial   #66  <Method void BorderLayout()>
    //   40   84:invokevirtual   #72  <Method void Container.setLayout(java.awt.LayoutManager)>
        UPAPanel = new EditPanel(m_Assignment, m_UndoButton);
    //   41   87:aload_0         
    //   42   88:new             #74  <Class EditPanel>
    //   43   91:dup             
    //   44   92:aload_0         
    //   45   93:getfield        #59  <Field Assignment m_Assignment>
    //   46   96:aload_0         
    //   47   97:getfield        #48  <Field JButton m_UndoButton>
    //   48  100:invokespecial   #77  <Method void EditPanel(Assignment, JButton)>
    //   49  103:putfield        #79  <Field EditPanel UPAPanel>
        getContentPane().add(UPAPanel, "Center");
    //   50  106:aload_0         
    //   51  107:invokevirtual   #63  <Method Container getContentPane()>
    //   52  110:aload_0         
    //   53  111:getfield        #79  <Field EditPanel UPAPanel>
    //   54  114:ldc1            #81  <String "Center">
    //   55  116:invokevirtual   #85  <Method void Container.add(java.awt.Component, Object)>
        JPanel panel = new JPanel(new FlowLayout(2));
    //   56  119:new             #87  <Class JPanel>
    //   57  122:dup             
    //   58  123:new             #89  <Class FlowLayout>
    //   59  126:dup             
    //   60  127:iconst_2        
    //   61  128:invokespecial   #92  <Method void FlowLayout(int)>
    //   62  131:invokespecial   #94  <Method void JPanel(java.awt.LayoutManager)>
    //   63  134:astore_2        
        panel.setSize(800, 600);
    //   64  135:aload_2         
    //   65  136:sipush          800
    //   66  139:sipush          600
    //   67  142:invokevirtual   #98  <Method void JPanel.setSize(int, int)>
        m_UndoButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                undo();
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field AssignmentViewer this$0>
            //    2    4:invokestatic    #27  <Method void AssignmentViewer.access$0(AssignmentViewer)>
                UPAPanel.updateUI();
            //    3    7:aload_0         
            //    4    8:getfield        #13  <Field AssignmentViewer this$0>
            //    5   11:getfield        #31  <Field EditPanel AssignmentViewer.UPAPanel>
            //    6   14:invokevirtual   #36  <Method void EditPanel.updateUI()>
            //    7   17:return          
            }

            final AssignmentViewer this$0;

            
            {
                this$0 = AssignmentViewer.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field AssignmentViewer this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //   68  145:aload_0         
    //   69  146:getfield        #48  <Field JButton m_UndoButton>
    //   70  149:new             #100 <Class AssignmentViewer$1>
    //   71  152:dup             
    //   72  153:aload_0         
    //   73  154:invokespecial   #103 <Method void AssignmentViewer$1(AssignmentViewer)>
    //   74  157:invokevirtual   #107 <Method void JButton.addActionListener(ActionListener)>
        getContentPane().add(panel, "South");
    //   75  160:aload_0         
    //   76  161:invokevirtual   #63  <Method Container getContentPane()>
    //   77  164:aload_2         
    //   78  165:ldc1            #109 <String "South">
    //   79  167:invokevirtual   #85  <Method void Container.add(java.awt.Component, Object)>
        m_CancelButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                m_Result = 1;
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field AssignmentViewer this$0>
            //    2    4:iconst_1        
            //    3    5:putfield        #28  <Field int AssignmentViewer.m_Result>
                setVisible(false);
            //    4    8:aload_0         
            //    5    9:getfield        #13  <Field AssignmentViewer this$0>
            //    6   12:iconst_0        
            //    7   13:invokevirtual   #32  <Method void AssignmentViewer.setVisible(boolean)>
            //    8   16:return          
            }

            final AssignmentViewer this$0;

            
            {
                this$0 = AssignmentViewer.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field AssignmentViewer this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //   80  170:aload_0         
    //   81  171:getfield        #44  <Field JButton m_CancelButton>
    //   82  174:new             #111 <Class AssignmentViewer$2>
    //   83  177:dup             
    //   84  178:aload_0         
    //   85  179:invokespecial   #112 <Method void AssignmentViewer$2(AssignmentViewer)>
    //   86  182:invokevirtual   #107 <Method void JButton.addActionListener(ActionListener)>
        m_OkButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                m_Assignment.setAssignmentMatrix(UPAPanel.getMatrix());
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field AssignmentViewer this$0>
            //    2    4:getfield        #28  <Field Assignment AssignmentViewer.m_Assignment>
            //    3    7:aload_0         
            //    4    8:getfield        #13  <Field AssignmentViewer this$0>
            //    5   11:getfield        #32  <Field EditPanel AssignmentViewer.UPAPanel>
            //    6   14:invokevirtual   #38  <Method rm.core.Matrix EditPanel.getMatrix()>
            //    7   17:invokevirtual   #44  <Method void Assignment.setAssignmentMatrix(rm.core.Matrix)>
                m_Result = 0;
            //    8   20:aload_0         
            //    9   21:getfield        #13  <Field AssignmentViewer this$0>
            //   10   24:iconst_0        
            //   11   25:putfield        #48  <Field int AssignmentViewer.m_Result>
                setVisible(false);
            //   12   28:aload_0         
            //   13   29:getfield        #13  <Field AssignmentViewer this$0>
            //   14   32:iconst_0        
            //   15   33:invokevirtual   #52  <Method void AssignmentViewer.setVisible(boolean)>
            //   16   36:return          
            }

            final AssignmentViewer this$0;

            
            {
                this$0 = AssignmentViewer.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field AssignmentViewer this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //   87  185:aload_0         
    //   88  186:getfield        #40  <Field JButton m_OkButton>
    //   89  189:new             #114 <Class AssignmentViewer$3>
    //   90  192:dup             
    //   91  193:aload_0         
    //   92  194:invokespecial   #115 <Method void AssignmentViewer$3(AssignmentViewer)>
    //   93  197:invokevirtual   #107 <Method void JButton.addActionListener(ActionListener)>
        panel.add(m_UndoButton);
    //   94  200:aload_2         
    //   95  201:aload_0         
    //   96  202:getfield        #48  <Field JButton m_UndoButton>
    //   97  205:invokevirtual   #118 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //   98  208:pop             
        panel.add(m_OkButton);
    //   99  209:aload_2         
    //  100  210:aload_0         
    //  101  211:getfield        #40  <Field JButton m_OkButton>
    //  102  214:invokevirtual   #118 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  103  217:pop             
        panel.add(m_CancelButton);
    //  104  218:aload_2         
    //  105  219:aload_0         
    //  106  220:getfield        #44  <Field JButton m_CancelButton>
    //  107  223:invokevirtual   #118 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  108  226:pop             
        Toolkit tk = Toolkit.getDefaultToolkit();
    //  109  227:invokestatic    #124 <Method Toolkit Toolkit.getDefaultToolkit()>
    //  110  230:astore_3        
        java.net.URL Imagepath = getClass().getClassLoader().getResource("images/Icon.png");
    //  111  231:aload_0         
    //  112  232:invokevirtual   #130 <Method Class Object.getClass()>
    //  113  235:invokevirtual   #136 <Method ClassLoader Class.getClassLoader()>
    //  114  238:ldc1            #138 <String "images/Icon.png">
    //  115  240:invokevirtual   #144 <Method java.net.URL ClassLoader.getResource(String)>
    //  116  243:astore          4
        java.awt.Image img = tk.getImage(Imagepath);
    //  117  245:aload_3         
    //  118  246:aload           4
    //  119  248:invokevirtual   #148 <Method java.awt.Image Toolkit.getImage(java.net.URL)>
    //  120  251:astore          5
        setIconImage(img);
    //  121  253:aload_0         
    //  122  254:aload           5
    //  123  256:invokevirtual   #152 <Method void setIconImage(java.awt.Image)>
        pack();
    //  124  259:aload_0         
    //  125  260:invokevirtual   #155 <Method void pack()>
    //  126  263:return          
    }

    public void setAssignment(Assignment assign)
    {
        m_Assignment = assign;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #59  <Field Assignment m_Assignment>
    //    3    5:return          
    }

    public Assignment getAssignment()
    {
        return m_Assignment;
    //    0    0:aload_0         
    //    1    1:getfield        #59  <Field Assignment m_Assignment>
    //    2    4:areturn         
    }

    private void undo()
    {
        UPAPanel.undo();
    //    0    0:aload_0         
    //    1    1:getfield        #79  <Field EditPanel UPAPanel>
    //    2    4:invokevirtual   #175 <Method void EditPanel.undo()>
    //    3    7:return          
    }

    protected void setButtons()
    {
        m_OkButton.setEnabled(true);
    //    0    0:aload_0         
    //    1    1:getfield        #40  <Field JButton m_OkButton>
    //    2    4:iconst_1        
    //    3    5:invokevirtual   #180 <Method void JButton.setEnabled(boolean)>
        m_CancelButton.setEnabled(true);
    //    4    8:aload_0         
    //    5    9:getfield        #44  <Field JButton m_CancelButton>
    //    6   12:iconst_1        
    //    7   13:invokevirtual   #180 <Method void JButton.setEnabled(boolean)>
        m_UndoButton.setEnabled(false);
    //    8   16:aload_0         
    //    9   17:getfield        #48  <Field JButton m_UndoButton>
    //   10   20:iconst_0        
    //   11   21:invokevirtual   #180 <Method void JButton.setEnabled(boolean)>
    //   12   24:return          
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
    //    5    7:invokevirtual   #185 <Method void setVisible(boolean)>
        setButtons();
    //    6   10:aload_0         
    //    7   11:invokevirtual   #187 <Method void setButtons()>
        return m_Result;
    //    8   14:aload_0         
    //    9   15:getfield        #31  <Field int m_Result>
    //   10   18:ireturn         
    }

    public static final int APPROVE_OPTION = 0;
    public static final int CANCEL_OPTION = 1;
    protected int m_Result;
    protected JButton m_OkButton;
    protected JButton m_CancelButton;
    protected JButton m_UndoButton;
    protected Assignment m_Assignment;
    protected EditPanel UPAPanel;
    final int DEFAULT_WIDTH = 800;
    final int DEFAULT_HEIGHT = 600;


/*
    static void access$0(AssignmentViewer assignmentviewer)
    {
        assignmentviewer.undo();
    //    0    0:aload_0         
    //    1    1:invokespecial   #189 <Method void undo()>
        return;
    //    2    4:return          
    }

*/
}
