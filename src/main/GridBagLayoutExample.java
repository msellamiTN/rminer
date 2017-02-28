// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   GridBagLayoutExample.java

package main;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GridBagLayoutExample
{

    public GridBagLayoutExample()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #9   <Method void Object()>
    //    2    4:return          
    }

    public static void main(String args[])
    {
        JFrame f = new JFrame("GridBag Layout Example");
    //    0    0:new             #17  <Class JFrame>
    //    1    3:dup             
    //    2    4:ldc1            #19  <String "GridBag Layout Example">
    //    3    6:invokespecial   #22  <Method void JFrame(String)>
    //    4    9:astore_1        
        GridBagLayout gridbag = new GridBagLayout();
    //    5   10:new             #24  <Class GridBagLayout>
    //    6   13:dup             
    //    7   14:invokespecial   #25  <Method void GridBagLayout()>
    //    8   17:astore_2        
        GridBagConstraints c = new GridBagConstraints();
    //    9   18:new             #27  <Class GridBagConstraints>
    //   10   21:dup             
    //   11   22:invokespecial   #28  <Method void GridBagConstraints()>
    //   12   25:astore_3        
        f.setLayout(gridbag);
    //   13   26:aload_1         
    //   14   27:aload_2         
    //   15   28:invokevirtual   #32  <Method void JFrame.setLayout(java.awt.LayoutManager)>
        c.fill = 1;
    //   16   31:aload_3         
    //   17   32:iconst_1        
    //   18   33:putfield        #36  <Field int GridBagConstraints.fill>
        c.gridheight = 2;
    //   19   36:aload_3         
    //   20   37:iconst_2        
    //   21   38:putfield        #39  <Field int GridBagConstraints.gridheight>
        c.gridwidth = 1;
    //   22   41:aload_3         
    //   23   42:iconst_1        
    //   24   43:putfield        #42  <Field int GridBagConstraints.gridwidth>
        c.weightx = 0.0D;
    //   25   46:aload_3         
    //   26   47:dconst_0        
    //   27   48:putfield        #46  <Field double GridBagConstraints.weightx>
        c.weighty = 0.0D;
    //   28   51:aload_3         
    //   29   52:dconst_0        
    //   30   53:putfield        #49  <Field double GridBagConstraints.weighty>
        c.anchor = 16;
    //   31   56:aload_3         
    //   32   57:bipush          16
    //   33   59:putfield        #52  <Field int GridBagConstraints.anchor>
        JButton jButton1 = new JButton("\u6309\u94AE1");
    //   34   62:new             #54  <Class JButton>
    //   35   65:dup             
    //   36   66:ldc1            #56  <String "\u6309\u94AE1">
    //   37   68:invokespecial   #57  <Method void JButton(String)>
    //   38   71:astore          4
        gridbag.setConstraints(jButton1, c);
    //   39   73:aload_2         
    //   40   74:aload           4
    //   41   76:aload_3         
    //   42   77:invokevirtual   #61  <Method void GridBagLayout.setConstraints(java.awt.Component, GridBagConstraints)>
        f.add(jButton1);
    //   43   80:aload_1         
    //   44   81:aload           4
    //   45   83:invokevirtual   #65  <Method java.awt.Component JFrame.add(java.awt.Component)>
    //   46   86:pop             
        c.fill = 0;
    //   47   87:aload_3         
    //   48   88:iconst_0        
    //   49   89:putfield        #36  <Field int GridBagConstraints.fill>
        c.gridwidth = 0;
    //   50   92:aload_3         
    //   51   93:iconst_0        
    //   52   94:putfield        #42  <Field int GridBagConstraints.gridwidth>
        c.gridheight = 1;
    //   53   97:aload_3         
    //   54   98:iconst_1        
    //   55   99:putfield        #39  <Field int GridBagConstraints.gridheight>
        c.weightx = 1.0D;
    //   56  102:aload_3         
    //   57  103:dconst_1        
    //   58  104:putfield        #46  <Field double GridBagConstraints.weightx>
        c.weighty = 0.80000000000000004D;
    //   59  107:aload_3         
    //   60  108:ldc2w           #66  <Double 0.80000000000000004D>
    //   61  111:putfield        #49  <Field double GridBagConstraints.weighty>
        JButton jButton2 = new JButton("\u6309\u94AE2");
    //   62  114:new             #54  <Class JButton>
    //   63  117:dup             
    //   64  118:ldc1            #69  <String "\u6309\u94AE2">
    //   65  120:invokespecial   #57  <Method void JButton(String)>
    //   66  123:astore          5
        gridbag.setConstraints(jButton2, c);
    //   67  125:aload_2         
    //   68  126:aload           5
    //   69  128:aload_3         
    //   70  129:invokevirtual   #61  <Method void GridBagLayout.setConstraints(java.awt.Component, GridBagConstraints)>
        f.add(jButton2);
    //   71  132:aload_1         
    //   72  133:aload           5
    //   73  135:invokevirtual   #65  <Method java.awt.Component JFrame.add(java.awt.Component)>
    //   74  138:pop             
        c.fill = 1;
    //   75  139:aload_3         
    //   76  140:iconst_1        
    //   77  141:putfield        #36  <Field int GridBagConstraints.fill>
        c.gridwidth = 1;
    //   78  144:aload_3         
    //   79  145:iconst_1        
    //   80  146:putfield        #42  <Field int GridBagConstraints.gridwidth>
        c.gridheight = 1;
    //   81  149:aload_3         
    //   82  150:iconst_1        
    //   83  151:putfield        #39  <Field int GridBagConstraints.gridheight>
        c.weighty = 0.20000000000000001D;
    //   84  154:aload_3         
    //   85  155:ldc2w           #70  <Double 0.20000000000000001D>
    //   86  158:putfield        #49  <Field double GridBagConstraints.weighty>
        JButton jButton3 = new JButton("\u6309\u94AE3");
    //   87  161:new             #54  <Class JButton>
    //   88  164:dup             
    //   89  165:ldc1            #73  <String "\u6309\u94AE3">
    //   90  167:invokespecial   #57  <Method void JButton(String)>
    //   91  170:astore          6
        gridbag.setConstraints(jButton3, c);
    //   92  172:aload_2         
    //   93  173:aload           6
    //   94  175:aload_3         
    //   95  176:invokevirtual   #61  <Method void GridBagLayout.setConstraints(java.awt.Component, GridBagConstraints)>
        f.add(jButton3);
    //   96  179:aload_1         
    //   97  180:aload           6
    //   98  182:invokevirtual   #65  <Method java.awt.Component JFrame.add(java.awt.Component)>
    //   99  185:pop             
        f.setDefaultCloseOperation(3);
    //  100  186:aload_1         
    //  101  187:iconst_3        
    //  102  188:invokevirtual   #77  <Method void JFrame.setDefaultCloseOperation(int)>
        f.setSize(500, 500);
    //  103  191:aload_1         
    //  104  192:sipush          500
    //  105  195:sipush          500
    //  106  198:invokevirtual   #81  <Method void JFrame.setSize(int, int)>
        f.setVisible(true);
    //  107  201:aload_1         
    //  108  202:iconst_1        
    //  109  203:invokevirtual   #85  <Method void JFrame.setVisible(boolean)>
    //  110  206:return          
    }
}
