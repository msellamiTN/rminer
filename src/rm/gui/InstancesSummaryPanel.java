// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   InstancesSummaryPanel.java

package rm.gui;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import javax.swing.*;
import rm.core.Instances;

public class InstancesSummaryPanel extends JPanel
{

    public InstancesSummaryPanel()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #19  <Method void JPanel()>
        m_DimensionNameLab = new JLabel("None");
    //    2    4:aload_0         
    //    3    5:new             #21  <Class JLabel>
    //    4    8:dup             
    //    5    9:ldc1            #9   <String "None">
    //    6   11:invokespecial   #24  <Method void JLabel(String)>
    //    7   14:putfield        #26  <Field JLabel m_DimensionNameLab>
        m_NumAttributesLab = new JLabel("None");
    //    8   17:aload_0         
    //    9   18:new             #21  <Class JLabel>
    //   10   21:dup             
    //   11   22:ldc1            #9   <String "None">
    //   12   24:invokespecial   #24  <Method void JLabel(String)>
    //   13   27:putfield        #28  <Field JLabel m_NumAttributesLab>
        GridBagLayout gbLayout = new GridBagLayout();
    //   14   30:new             #30  <Class GridBagLayout>
    //   15   33:dup             
    //   16   34:invokespecial   #31  <Method void GridBagLayout()>
    //   17   37:astore_1        
        setLayout(gbLayout);
    //   18   38:aload_0         
    //   19   39:aload_1         
    //   20   40:invokevirtual   #35  <Method void setLayout(java.awt.LayoutManager)>
        JLabel lab = new JLabel("Dimension:", 4);
    //   21   43:new             #21  <Class JLabel>
    //   22   46:dup             
    //   23   47:ldc1            #37  <String "Dimension:">
    //   24   49:iconst_4        
    //   25   50:invokespecial   #40  <Method void JLabel(String, int)>
    //   26   53:astore_2        
        lab.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
    //   27   54:aload_2         
    //   28   55:iconst_0        
    //   29   56:bipush          10
    //   30   58:iconst_0        
    //   31   59:iconst_0        
    //   32   60:invokestatic    #46  <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
    //   33   63:invokevirtual   #50  <Method void JLabel.setBorder(javax.swing.border.Border)>
        GridBagConstraints gbConstraints = new GridBagConstraints();
    //   34   66:new             #52  <Class GridBagConstraints>
    //   35   69:dup             
    //   36   70:invokespecial   #53  <Method void GridBagConstraints()>
    //   37   73:astore_3        
        gbConstraints.anchor = 13;
    //   38   74:aload_3         
    //   39   75:bipush          13
    //   40   77:putfield        #57  <Field int GridBagConstraints.anchor>
        gbConstraints.fill = 2;
    //   41   80:aload_3         
    //   42   81:iconst_2        
    //   43   82:putfield        #60  <Field int GridBagConstraints.fill>
        gbConstraints.gridy = 0;
    //   44   85:aload_3         
    //   45   86:iconst_0        
    //   46   87:putfield        #63  <Field int GridBagConstraints.gridy>
        gbConstraints.gridx = 0;
    //   47   90:aload_3         
    //   48   91:iconst_0        
    //   49   92:putfield        #66  <Field int GridBagConstraints.gridx>
        gbLayout.setConstraints(lab, gbConstraints);
    //   50   95:aload_1         
    //   51   96:aload_2         
    //   52   97:aload_3         
    //   53   98:invokevirtual   #70  <Method void GridBagLayout.setConstraints(java.awt.Component, GridBagConstraints)>
        add(lab);
    //   54  101:aload_0         
    //   55  102:aload_2         
    //   56  103:invokevirtual   #74  <Method java.awt.Component add(java.awt.Component)>
    //   57  106:pop             
        gbConstraints = new GridBagConstraints();
    //   58  107:new             #52  <Class GridBagConstraints>
    //   59  110:dup             
    //   60  111:invokespecial   #53  <Method void GridBagConstraints()>
    //   61  114:astore_3        
        gbConstraints.anchor = 17;
    //   62  115:aload_3         
    //   63  116:bipush          17
    //   64  118:putfield        #57  <Field int GridBagConstraints.anchor>
        gbConstraints.fill = 2;
    //   65  121:aload_3         
    //   66  122:iconst_2        
    //   67  123:putfield        #60  <Field int GridBagConstraints.fill>
        gbConstraints.gridy = 0;
    //   68  126:aload_3         
    //   69  127:iconst_0        
    //   70  128:putfield        #63  <Field int GridBagConstraints.gridy>
        gbConstraints.gridx = 1;
    //   71  131:aload_3         
    //   72  132:iconst_1        
    //   73  133:putfield        #66  <Field int GridBagConstraints.gridx>
        gbConstraints.weightx = 100D;
    //   74  136:aload_3         
    //   75  137:ldc2w           #75  <Double 100D>
    //   76  140:putfield        #80  <Field double GridBagConstraints.weightx>
        gbConstraints.gridwidth = 3;
    //   77  143:aload_3         
    //   78  144:iconst_3        
    //   79  145:putfield        #83  <Field int GridBagConstraints.gridwidth>
        gbLayout.setConstraints(m_DimensionNameLab, gbConstraints);
    //   80  148:aload_1         
    //   81  149:aload_0         
    //   82  150:getfield        #26  <Field JLabel m_DimensionNameLab>
    //   83  153:aload_3         
    //   84  154:invokevirtual   #70  <Method void GridBagLayout.setConstraints(java.awt.Component, GridBagConstraints)>
        add(m_DimensionNameLab);
    //   85  157:aload_0         
    //   86  158:aload_0         
    //   87  159:getfield        #26  <Field JLabel m_DimensionNameLab>
    //   88  162:invokevirtual   #74  <Method java.awt.Component add(java.awt.Component)>
    //   89  165:pop             
        m_DimensionNameLab.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 10));
    //   90  166:aload_0         
    //   91  167:getfield        #26  <Field JLabel m_DimensionNameLab>
    //   92  170:iconst_0        
    //   93  171:iconst_5        
    //   94  172:iconst_0        
    //   95  173:bipush          10
    //   96  175:invokestatic    #46  <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
    //   97  178:invokevirtual   #50  <Method void JLabel.setBorder(javax.swing.border.Border)>
        lab = new JLabel("Attributes:", 4);
    //   98  181:new             #21  <Class JLabel>
    //   99  184:dup             
    //  100  185:ldc1            #85  <String "Attributes:">
    //  101  187:iconst_4        
    //  102  188:invokespecial   #40  <Method void JLabel(String, int)>
    //  103  191:astore_2        
        lab.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
    //  104  192:aload_2         
    //  105  193:iconst_0        
    //  106  194:bipush          10
    //  107  196:iconst_0        
    //  108  197:iconst_0        
    //  109  198:invokestatic    #46  <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
    //  110  201:invokevirtual   #50  <Method void JLabel.setBorder(javax.swing.border.Border)>
        gbConstraints = new GridBagConstraints();
    //  111  204:new             #52  <Class GridBagConstraints>
    //  112  207:dup             
    //  113  208:invokespecial   #53  <Method void GridBagConstraints()>
    //  114  211:astore_3        
        gbConstraints.anchor = 13;
    //  115  212:aload_3         
    //  116  213:bipush          13
    //  117  215:putfield        #57  <Field int GridBagConstraints.anchor>
        gbConstraints.fill = 2;
    //  118  218:aload_3         
    //  119  219:iconst_2        
    //  120  220:putfield        #60  <Field int GridBagConstraints.fill>
        gbConstraints.gridy = 1;
    //  121  223:aload_3         
    //  122  224:iconst_1        
    //  123  225:putfield        #63  <Field int GridBagConstraints.gridy>
        gbConstraints.gridx = 0;
    //  124  228:aload_3         
    //  125  229:iconst_0        
    //  126  230:putfield        #66  <Field int GridBagConstraints.gridx>
        gbLayout.setConstraints(lab, gbConstraints);
    //  127  233:aload_1         
    //  128  234:aload_2         
    //  129  235:aload_3         
    //  130  236:invokevirtual   #70  <Method void GridBagLayout.setConstraints(java.awt.Component, GridBagConstraints)>
        add(lab);
    //  131  239:aload_0         
    //  132  240:aload_2         
    //  133  241:invokevirtual   #74  <Method java.awt.Component add(java.awt.Component)>
    //  134  244:pop             
        gbConstraints = new GridBagConstraints();
    //  135  245:new             #52  <Class GridBagConstraints>
    //  136  248:dup             
    //  137  249:invokespecial   #53  <Method void GridBagConstraints()>
    //  138  252:astore_3        
        gbConstraints.anchor = 17;
    //  139  253:aload_3         
    //  140  254:bipush          17
    //  141  256:putfield        #57  <Field int GridBagConstraints.anchor>
        gbConstraints.fill = 2;
    //  142  259:aload_3         
    //  143  260:iconst_2        
    //  144  261:putfield        #60  <Field int GridBagConstraints.fill>
        gbConstraints.gridy = 1;
    //  145  264:aload_3         
    //  146  265:iconst_1        
    //  147  266:putfield        #63  <Field int GridBagConstraints.gridy>
        gbConstraints.gridx = 1;
    //  148  269:aload_3         
    //  149  270:iconst_1        
    //  150  271:putfield        #66  <Field int GridBagConstraints.gridx>
        gbConstraints.weightx = 100D;
    //  151  274:aload_3         
    //  152  275:ldc2w           #75  <Double 100D>
    //  153  278:putfield        #80  <Field double GridBagConstraints.weightx>
        gbLayout.setConstraints(m_NumAttributesLab, gbConstraints);
    //  154  281:aload_1         
    //  155  282:aload_0         
    //  156  283:getfield        #28  <Field JLabel m_NumAttributesLab>
    //  157  286:aload_3         
    //  158  287:invokevirtual   #70  <Method void GridBagLayout.setConstraints(java.awt.Component, GridBagConstraints)>
        add(m_NumAttributesLab);
    //  159  290:aload_0         
    //  160  291:aload_0         
    //  161  292:getfield        #28  <Field JLabel m_NumAttributesLab>
    //  162  295:invokevirtual   #74  <Method java.awt.Component add(java.awt.Component)>
    //  163  298:pop             
        m_NumAttributesLab.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 10));
    //  164  299:aload_0         
    //  165  300:getfield        #28  <Field JLabel m_NumAttributesLab>
    //  166  303:iconst_0        
    //  167  304:iconst_5        
    //  168  305:iconst_0        
    //  169  306:bipush          10
    //  170  308:invokestatic    #46  <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
    //  171  311:invokevirtual   #50  <Method void JLabel.setBorder(javax.swing.border.Border)>
    //  172  314:return          
    }

    public void setInstances(Instances inst)
    {
        m_Instances = inst;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #98  <Field Instances m_Instances>
        m_DimensionNameLab.setText(m_Instances.relationName());
    //    3    5:aload_0         
    //    4    6:getfield        #26  <Field JLabel m_DimensionNameLab>
    //    5    9:aload_0         
    //    6   10:getfield        #98  <Field Instances m_Instances>
    //    7   13:invokevirtual   #104 <Method String Instances.relationName()>
    //    8   16:invokevirtual   #107 <Method void JLabel.setText(String)>
        m_NumAttributesLab.setText((new StringBuilder()).append(m_Instances.numAttributes()).toString());
    //    9   19:aload_0         
    //   10   20:getfield        #28  <Field JLabel m_NumAttributesLab>
    //   11   23:new             #109 <Class StringBuilder>
    //   12   26:dup             
    //   13   27:invokespecial   #110 <Method void StringBuilder()>
    //   14   30:aload_0         
    //   15   31:getfield        #98  <Field Instances m_Instances>
    //   16   34:invokevirtual   #114 <Method int Instances.numAttributes()>
    //   17   37:invokevirtual   #118 <Method StringBuilder StringBuilder.append(int)>
    //   18   40:invokevirtual   #121 <Method String StringBuilder.toString()>
    //   19   43:invokevirtual   #107 <Method void JLabel.setText(String)>
    //   20   46:return          
    }

    public static void main(String args[])
    {
        try
        {
            final JFrame jf = new JFrame("Instances Panel");
    //    0    0:new             #126 <Class JFrame>
    //    1    3:dup             
    //    2    4:ldc1            #128 <String "Instances Panel">
    //    3    6:invokespecial   #129 <Method void JFrame(String)>
    //    4    9:astore_1        
            jf.getContentPane().setLayout(new BorderLayout());
    //    5   10:aload_1         
    //    6   11:invokevirtual   #133 <Method Container JFrame.getContentPane()>
    //    7   14:new             #135 <Class BorderLayout>
    //    8   17:dup             
    //    9   18:invokespecial   #136 <Method void BorderLayout()>
    //   10   21:invokevirtual   #139 <Method void Container.setLayout(java.awt.LayoutManager)>
            InstancesSummaryPanel p = new InstancesSummaryPanel();
    //   11   24:new             #2   <Class InstancesSummaryPanel>
    //   12   27:dup             
    //   13   28:invokespecial   #140 <Method void InstancesSummaryPanel()>
    //   14   31:astore_2        
            p.setBorder(BorderFactory.createTitledBorder("Relation"));
    //   15   32:aload_2         
    //   16   33:ldc1            #142 <String "Relation">
    //   17   35:invokestatic    #146 <Method javax.swing.border.TitledBorder BorderFactory.createTitledBorder(String)>
    //   18   38:invokevirtual   #147 <Method void setBorder(javax.swing.border.Border)>
            jf.getContentPane().add(p, "Center");
    //   19   41:aload_1         
    //   20   42:invokevirtual   #133 <Method Container JFrame.getContentPane()>
    //   21   45:aload_2         
    //   22   46:ldc1            #149 <String "Center">
    //   23   48:invokevirtual   #152 <Method void Container.add(java.awt.Component, Object)>
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
    //   24   51:aload_1         
    //   25   52:new             #154 <Class InstancesSummaryPanel$1>
    //   26   55:dup             
    //   27   56:aload_1         
    //   28   57:invokespecial   #157 <Method void InstancesSummaryPanel$1(JFrame)>
    //   29   60:invokevirtual   #161 <Method void JFrame.addWindowListener(java.awt.event.WindowListener)>
            jf.pack();
    //   30   63:aload_1         
    //   31   64:invokevirtual   #164 <Method void JFrame.pack()>
            jf.setVisible(true);
    //   32   67:aload_1         
    //   33   68:iconst_1        
    //   34   69:invokevirtual   #168 <Method void JFrame.setVisible(boolean)>
            if(args.length == 1)
    //*  35   72:aload_0         
    //*  36   73:arraylength     
    //*  37   74:iconst_1        
    //*  38   75:icmpne          130
            {
                java.io.Reader r = new BufferedReader(new FileReader(args[0]));
    //   39   78:new             #170 <Class BufferedReader>
    //   40   81:dup             
    //   41   82:new             #172 <Class FileReader>
    //   42   85:dup             
    //   43   86:aload_0         
    //   44   87:iconst_0        
    //   45   88:aaload          
    //   46   89:invokespecial   #173 <Method void FileReader(String)>
    //   47   92:invokespecial   #176 <Method void BufferedReader(java.io.Reader)>
    //   48   95:astore_3        
                Instances i = new Instances(r);
    //   49   96:new             #100 <Class Instances>
    //   50   99:dup             
    //   51  100:aload_3         
    //   52  101:invokespecial   #177 <Method void Instances(java.io.Reader)>
    //   53  104:astore          4
                p.setInstances(i);
    //   54  106:aload_2         
    //   55  107:aload           4
    //   56  109:invokevirtual   #179 <Method void setInstances(Instances)>
            }
        }
    //*  57  112:goto            130
        catch(Exception ex)
    //*  58  115:astore_1        
        {
            ex.printStackTrace();
    //   59  116:aload_1         
    //   60  117:invokevirtual   #184 <Method void Exception.printStackTrace()>
            System.err.println(ex.getMessage());
    //   61  120:getstatic       #190 <Field PrintStream System.err>
    //   62  123:aload_1         
    //   63  124:invokevirtual   #193 <Method String Exception.getMessage()>
    //   64  127:invokevirtual   #198 <Method void PrintStream.println(String)>
        }
    //   65  130:return          
    }

    protected static final String NO_SOURCE = "None";
    protected JLabel m_DimensionNameLab;
    protected JLabel m_NumAttributesLab;
    protected Instances m_Instances;
}
