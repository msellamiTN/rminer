// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   RMinerTaskMonitor.java

package rm.gui;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.PrintStream;
import javax.swing.*;

// Referenced classes of package rm.gui:
//            TaskLogger

public class RMinerTaskMonitor extends JPanel
    implements TaskLogger
{

    public RMinerTaskMonitor()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #25  <Method void JPanel()>
        m_ActiveTasks = 0;
    //    2    4:aload_0         
    //    3    5:iconst_0        
    //    4    6:putfield        #27  <Field int m_ActiveTasks>
        m_animating = false;
    //    5    9:aload_0         
    //    6   10:iconst_0        
    //    7   11:putfield        #29  <Field boolean m_animating>
        java.awt.Image pic = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/rminer_stationary.gif"));
    //    8   14:invokestatic    #35  <Method Toolkit Toolkit.getDefaultToolkit()>
    //    9   17:ldc1            #37  <String "images/rminer_stationary.gif">
    //   10   19:invokestatic    #43  <Method java.net.URL ClassLoader.getSystemResource(String)>
    //   11   22:invokevirtual   #47  <Method java.awt.Image Toolkit.getImage(java.net.URL)>
    //   12   25:astore_1        
        java.awt.Image pic2 = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/rminer_animated.gif"));
    //   13   26:invokestatic    #35  <Method Toolkit Toolkit.getDefaultToolkit()>
    //   14   29:ldc1            #49  <String "images/rminer_animated.gif">
    //   15   31:invokestatic    #43  <Method java.net.URL ClassLoader.getSystemResource(String)>
    //   16   34:invokevirtual   #47  <Method java.awt.Image Toolkit.getImage(java.net.URL)>
    //   17   37:astore_2        
        m_iconStationary = new ImageIcon(pic);
    //   18   38:aload_0         
    //   19   39:new             #51  <Class ImageIcon>
    //   20   42:dup             
    //   21   43:aload_1         
    //   22   44:invokespecial   #54  <Method void ImageIcon(java.awt.Image)>
    //   23   47:putfield        #56  <Field ImageIcon m_iconStationary>
        m_iconAnimated = new ImageIcon(pic2);
    //   24   50:aload_0         
    //   25   51:new             #51  <Class ImageIcon>
    //   26   54:dup             
    //   27   55:aload_2         
    //   28   56:invokespecial   #54  <Method void ImageIcon(java.awt.Image)>
    //   29   59:putfield        #58  <Field ImageIcon m_iconAnimated>
        m_MonitorLabel = new JLabel((new StringBuilder(" x ")).append(m_ActiveTasks).toString(), m_iconStationary, 0);
    //   30   62:aload_0         
    //   31   63:new             #60  <Class JLabel>
    //   32   66:dup             
    //   33   67:new             #62  <Class StringBuilder>
    //   34   70:dup             
    //   35   71:ldc1            #64  <String " x ">
    //   36   73:invokespecial   #67  <Method void StringBuilder(String)>
    //   37   76:aload_0         
    //   38   77:getfield        #27  <Field int m_ActiveTasks>
    //   39   80:invokevirtual   #71  <Method StringBuilder StringBuilder.append(int)>
    //   40   83:invokevirtual   #75  <Method String StringBuilder.toString()>
    //   41   86:aload_0         
    //   42   87:getfield        #56  <Field ImageIcon m_iconStationary>
    //   43   90:iconst_0        
    //   44   91:invokespecial   #78  <Method void JLabel(String, javax.swing.Icon, int)>
    //   45   94:putfield        #80  <Field JLabel m_MonitorLabel>
        setLayout(new BorderLayout());
    //   46   97:aload_0         
    //   47   98:new             #82  <Class BorderLayout>
    //   48  101:dup             
    //   49  102:invokespecial   #83  <Method void BorderLayout()>
    //   50  105:invokevirtual   #87  <Method void setLayout(java.awt.LayoutManager)>
        Dimension d = m_MonitorLabel.getPreferredSize();
    //   51  108:aload_0         
    //   52  109:getfield        #80  <Field JLabel m_MonitorLabel>
    //   53  112:invokevirtual   #91  <Method Dimension JLabel.getPreferredSize()>
    //   54  115:astore_3        
        m_MonitorLabel.setPreferredSize(new Dimension(d.width + 15, d.height));
    //   55  116:aload_0         
    //   56  117:getfield        #80  <Field JLabel m_MonitorLabel>
    //   57  120:new             #93  <Class Dimension>
    //   58  123:dup             
    //   59  124:aload_3         
    //   60  125:getfield        #96  <Field int Dimension.width>
    //   61  128:bipush          15
    //   62  130:iadd            
    //   63  131:aload_3         
    //   64  132:getfield        #99  <Field int Dimension.height>
    //   65  135:invokespecial   #102 <Method void Dimension(int, int)>
    //   66  138:invokevirtual   #106 <Method void JLabel.setPreferredSize(Dimension)>
        m_MonitorLabel.setMinimumSize(new Dimension(d.width + 15, d.height));
    //   67  141:aload_0         
    //   68  142:getfield        #80  <Field JLabel m_MonitorLabel>
    //   69  145:new             #93  <Class Dimension>
    //   70  148:dup             
    //   71  149:aload_3         
    //   72  150:getfield        #96  <Field int Dimension.width>
    //   73  153:bipush          15
    //   74  155:iadd            
    //   75  156:aload_3         
    //   76  157:getfield        #99  <Field int Dimension.height>
    //   77  160:invokespecial   #102 <Method void Dimension(int, int)>
    //   78  163:invokevirtual   #109 <Method void JLabel.setMinimumSize(Dimension)>
        add(m_MonitorLabel, "Center");
    //   79  166:aload_0         
    //   80  167:aload_0         
    //   81  168:getfield        #80  <Field JLabel m_MonitorLabel>
    //   82  171:ldc1            #111 <String "Center">
    //   83  173:invokevirtual   #115 <Method void add(java.awt.Component, Object)>
    //   84  176:return          
    }

    public synchronized void taskStarted()
    {
        m_ActiveTasks++;
    //    0    0:aload_0         
    //    1    1:dup             
    //    2    2:getfield        #27  <Field int m_ActiveTasks>
    //    3    5:iconst_1        
    //    4    6:iadd            
    //    5    7:putfield        #27  <Field int m_ActiveTasks>
        updateMonitor();
    //    6   10:aload_0         
    //    7   11:invokespecial   #128 <Method void updateMonitor()>
    //    8   14:return          
    }

    public synchronized void taskFinished()
    {
        m_ActiveTasks--;
    //    0    0:aload_0         
    //    1    1:dup             
    //    2    2:getfield        #27  <Field int m_ActiveTasks>
    //    3    5:iconst_1        
    //    4    6:isub            
    //    5    7:putfield        #27  <Field int m_ActiveTasks>
        if(m_ActiveTasks < 0)
    //*   6   10:aload_0         
    //*   7   11:getfield        #27  <Field int m_ActiveTasks>
    //*   8   14:ifge            22
            m_ActiveTasks = 0;
    //    9   17:aload_0         
    //   10   18:iconst_0        
    //   11   19:putfield        #27  <Field int m_ActiveTasks>
        updateMonitor();
    //   12   22:aload_0         
    //   13   23:invokespecial   #128 <Method void updateMonitor()>
    //   14   26:return          
    }

    private void updateMonitor()
    {
        m_MonitorLabel.setText((new StringBuilder(" x ")).append(m_ActiveTasks).toString());
    //    0    0:aload_0         
    //    1    1:getfield        #80  <Field JLabel m_MonitorLabel>
    //    2    4:new             #62  <Class StringBuilder>
    //    3    7:dup             
    //    4    8:ldc1            #64  <String " x ">
    //    5   10:invokespecial   #67  <Method void StringBuilder(String)>
    //    6   13:aload_0         
    //    7   14:getfield        #27  <Field int m_ActiveTasks>
    //    8   17:invokevirtual   #71  <Method StringBuilder StringBuilder.append(int)>
    //    9   20:invokevirtual   #75  <Method String StringBuilder.toString()>
    //   10   23:invokevirtual   #132 <Method void JLabel.setText(String)>
        if(m_ActiveTasks > 0 && !m_animating)
    //*  11   26:aload_0         
    //*  12   27:getfield        #27  <Field int m_ActiveTasks>
    //*  13   30:ifle            56
    //*  14   33:aload_0         
    //*  15   34:getfield        #29  <Field boolean m_animating>
    //*  16   37:ifne            56
        {
            m_MonitorLabel.setIcon(m_iconAnimated);
    //   17   40:aload_0         
    //   18   41:getfield        #80  <Field JLabel m_MonitorLabel>
    //   19   44:aload_0         
    //   20   45:getfield        #58  <Field ImageIcon m_iconAnimated>
    //   21   48:invokevirtual   #136 <Method void JLabel.setIcon(javax.swing.Icon)>
            m_animating = true;
    //   22   51:aload_0         
    //   23   52:iconst_1        
    //   24   53:putfield        #29  <Field boolean m_animating>
        }
        if(m_ActiveTasks == 0 && m_animating)
    //*  25   56:aload_0         
    //*  26   57:getfield        #27  <Field int m_ActiveTasks>
    //*  27   60:ifne            86
    //*  28   63:aload_0         
    //*  29   64:getfield        #29  <Field boolean m_animating>
    //*  30   67:ifeq            86
        {
            m_MonitorLabel.setIcon(m_iconStationary);
    //   31   70:aload_0         
    //   32   71:getfield        #80  <Field JLabel m_MonitorLabel>
    //   33   74:aload_0         
    //   34   75:getfield        #56  <Field ImageIcon m_iconStationary>
    //   35   78:invokevirtual   #136 <Method void JLabel.setIcon(javax.swing.Icon)>
            m_animating = false;
    //   36   81:aload_0         
    //   37   82:iconst_0        
    //   38   83:putfield        #29  <Field boolean m_animating>
        }
    //   39   86:return          
    }

    public static void main(String args[])
    {
        try
        {
            final JFrame jf = new JFrame();
    //    0    0:new             #140 <Class JFrame>
    //    1    3:dup             
    //    2    4:invokespecial   #141 <Method void JFrame()>
    //    3    7:astore_1        
            jf.getContentPane().setLayout(new BorderLayout());
    //    4    8:aload_1         
    //    5    9:invokevirtual   #145 <Method Container JFrame.getContentPane()>
    //    6   12:new             #82  <Class BorderLayout>
    //    7   15:dup             
    //    8   16:invokespecial   #83  <Method void BorderLayout()>
    //    9   19:invokevirtual   #148 <Method void Container.setLayout(java.awt.LayoutManager)>
            RMinerTaskMonitor tm = new RMinerTaskMonitor();
    //   10   22:new             #2   <Class RMinerTaskMonitor>
    //   11   25:dup             
    //   12   26:invokespecial   #149 <Method void RMinerTaskMonitor()>
    //   13   29:astore_2        
            tm.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("RMiner Tasks"), BorderFactory.createEmptyBorder(0, 5, 5, 5)));
    //   14   30:aload_2         
    //   15   31:ldc1            #151 <String "RMiner Tasks">
    //   16   33:invokestatic    #157 <Method javax.swing.border.TitledBorder BorderFactory.createTitledBorder(String)>
    //   17   36:iconst_0        
    //   18   37:iconst_5        
    //   19   38:iconst_5        
    //   20   39:iconst_5        
    //   21   40:invokestatic    #161 <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
    //   22   43:invokestatic    #165 <Method javax.swing.border.CompoundBorder BorderFactory.createCompoundBorder(javax.swing.border.Border, javax.swing.border.Border)>
    //   23   46:invokevirtual   #169 <Method void setBorder(javax.swing.border.Border)>
            jf.getContentPane().add(tm, "Center");
    //   24   49:aload_1         
    //   25   50:invokevirtual   #145 <Method Container JFrame.getContentPane()>
    //   26   53:aload_2         
    //   27   54:ldc1            #111 <String "Center">
    //   28   56:invokevirtual   #170 <Method void Container.add(java.awt.Component, Object)>
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
    //   29   59:aload_1         
    //   30   60:new             #172 <Class RMinerTaskMonitor$1>
    //   31   63:dup             
    //   32   64:aload_1         
    //   33   65:invokespecial   #175 <Method void RMinerTaskMonitor$1(JFrame)>
    //   34   68:invokevirtual   #179 <Method void JFrame.addWindowListener(java.awt.event.WindowListener)>
            jf.pack();
    //   35   71:aload_1         
    //   36   72:invokevirtual   #182 <Method void JFrame.pack()>
            jf.setVisible(true);
    //   37   75:aload_1         
    //   38   76:iconst_1        
    //   39   77:invokevirtual   #186 <Method void JFrame.setVisible(boolean)>
            tm.taskStarted();
    //   40   80:aload_2         
    //   41   81:invokevirtual   #188 <Method void taskStarted()>
        }
    //*  42   84:goto            102
        catch(Exception ex)
    //*  43   87:astore_1        
        {
            ex.printStackTrace();
    //   44   88:aload_1         
    //   45   89:invokevirtual   #193 <Method void Exception.printStackTrace()>
            System.err.println(ex.getMessage());
    //   46   92:getstatic       #199 <Field PrintStream System.err>
    //   47   95:aload_1         
    //   48   96:invokevirtual   #202 <Method String Exception.getMessage()>
    //   49   99:invokevirtual   #207 <Method void PrintStream.println(String)>
        }
    //   50  102:return          
    }

    private static final long serialVersionUID = 0x70de115b3f0c4caL;
    private int m_ActiveTasks;
    private JLabel m_MonitorLabel;
    private ImageIcon m_iconStationary;
    private ImageIcon m_iconAnimated;
    private boolean m_animating;
}
