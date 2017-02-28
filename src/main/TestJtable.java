// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   TestJtable.java

package main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TestJtable extends JFrame
    implements ActionListener
{

    public TestJtable()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #25  <Method void JFrame()>
    //    2    4:aload_0         
    //    3    5:iconst_3        
    //    4    6:anewarray       String[]
    //    5    9:dup             
    //    6   10:iconst_0        
    //    7   11:ldc1            #29  <String "\u7F16\u53F7">
    //    8   13:aastore         
    //    9   14:dup             
    //   10   15:iconst_1        
    //   11   16:ldc1            #31  <String "\u59D3\u540D">
    //   12   18:aastore         
    //   13   19:dup             
    //   14   20:iconst_2        
    //   15   21:ldc1            #33  <String "\u73ED\u7EA7">
    //   16   23:aastore         
    //   17   24:putfield        #35  <Field String[] Names>
        data = new Object[100][8];
    //   18   27:aload_0         
    //   19   28:bipush          100
    //   20   30:bipush          8
    //   21   32:multianewarray  Object[][]
    //   22   36:putfield        #38  <Field Object[][] data>
        jPanel = new JPanel(new BorderLayout());
    //   23   39:aload_0         
    //   24   40:new             #40  <Class JPanel>
    //   25   43:dup             
    //   26   44:new             #42  <Class BorderLayout>
    //   27   47:dup             
    //   28   48:invokespecial   #43  <Method void BorderLayout()>
    //   29   51:invokespecial   #46  <Method void JPanel(java.awt.LayoutManager)>
    //   30   54:putfield        #48  <Field JPanel jPanel>
        jButton = new JButton("\u66F4\u65B0\u8868\u683C");
    //   31   57:aload_0         
    //   32   58:new             #50  <Class JButton>
    //   33   61:dup             
    //   34   62:ldc1            #52  <String "\u66F4\u65B0\u8868\u683C">
    //   35   64:invokespecial   #55  <Method void JButton(String)>
    //   36   67:putfield        #57  <Field JButton jButton>
        jButton.addActionListener(this);
    //   37   70:aload_0         
    //   38   71:getfield        #57  <Field JButton jButton>
    //   39   74:aload_0         
    //   40   75:invokevirtual   #61  <Method void JButton.addActionListener(ActionListener)>
        for(int i = 0; i < 100; i++)
    //*  41   78:iconst_0        
    //*  42   79:istore_1        
    //*  43   80:goto            110
        {
            for(int j = 0; j < 8; j++)
    //*  44   83:iconst_0        
    //*  45   84:istore_2        
    //*  46   85:goto            101
                data[i][j] = "\u539F\u59CB";
    //   47   88:aload_0         
    //   48   89:getfield        #38  <Field Object[][] data>
    //   49   92:iload_1         
    //   50   93:aaload          
    //   51   94:iload_2         
    //   52   95:ldc1            #63  <String "\u539F\u59CB">
    //   53   97:aastore         

    //   54   98:iinc            2  1
    //   55  101:iload_2         
    //   56  102:bipush          8
    //   57  104:icmplt          88
        }

    //   58  107:iinc            1  1
    //   59  110:iload_1         
    //   60  111:bipush          100
    //   61  113:icmplt          83
        jTable = new JTable(data, Names);
    //   62  116:aload_0         
    //   63  117:new             #65  <Class JTable>
    //   64  120:dup             
    //   65  121:aload_0         
    //   66  122:getfield        #38  <Field Object[][] data>
    //   67  125:aload_0         
    //   68  126:getfield        #35  <Field String[] Names>
    //   69  129:invokespecial   #68  <Method void JTable(Object[][], Object[])>
    //   70  132:putfield        #70  <Field JTable jTable>
        jScrollPane = new JScrollPane(jTable);
    //   71  135:aload_0         
    //   72  136:new             #72  <Class JScrollPane>
    //   73  139:dup             
    //   74  140:aload_0         
    //   75  141:getfield        #70  <Field JTable jTable>
    //   76  144:invokespecial   #75  <Method void JScrollPane(java.awt.Component)>
    //   77  147:putfield        #77  <Field JScrollPane jScrollPane>
        jPanel.add(jButton, "North");
    //   78  150:aload_0         
    //   79  151:getfield        #48  <Field JPanel jPanel>
    //   80  154:aload_0         
    //   81  155:getfield        #57  <Field JButton jButton>
    //   82  158:ldc1            #79  <String "North">
    //   83  160:invokevirtual   #83  <Method void JPanel.add(java.awt.Component, Object)>
        jPanel.add(jScrollPane, "Center");
    //   84  163:aload_0         
    //   85  164:getfield        #48  <Field JPanel jPanel>
    //   86  167:aload_0         
    //   87  168:getfield        #77  <Field JScrollPane jScrollPane>
    //   88  171:ldc1            #85  <String "Center">
    //   89  173:invokevirtual   #83  <Method void JPanel.add(java.awt.Component, Object)>
        add(jPanel);
    //   90  176:aload_0         
    //   91  177:aload_0         
    //   92  178:getfield        #48  <Field JPanel jPanel>
    //   93  181:invokevirtual   #88  <Method java.awt.Component add(java.awt.Component)>
    //   94  184:pop             
        setLocation(100, 100);
    //   95  185:aload_0         
    //   96  186:bipush          100
    //   97  188:bipush          100
    //   98  190:invokevirtual   #92  <Method void setLocation(int, int)>
        setSize(600, 400);
    //   99  193:aload_0         
    //  100  194:sipush          600
    //  101  197:sipush          400
    //  102  200:invokevirtual   #95  <Method void setSize(int, int)>
        setVisible(true);
    //  103  203:aload_0         
    //  104  204:iconst_1        
    //  105  205:invokevirtual   #99  <Method void setVisible(boolean)>
    //  106  208:return          
    }

    public void actionPerformed(ActionEvent event)
    {
        if(jButton.equals(event.getSource()))
    //*   0    0:aload_0         
    //*   1    1:getfield        #57  <Field JButton jButton>
    //*   2    4:aload_1         
    //*   3    5:invokevirtual   #114 <Method Object ActionEvent.getSource()>
    //*   4    8:invokevirtual   #120 <Method boolean Object.equals(Object)>
    //*   5   11:ifeq            94
        {
            jTable.repaint();
    //    6   14:aload_0         
    //    7   15:getfield        #70  <Field JTable jTable>
    //    8   18:invokevirtual   #123 <Method void JTable.repaint()>
            for(int i = 0; i < 100; i++)
    //*   9   21:iconst_0        
    //*  10   22:istore_2        
    //*  11   23:goto            51
            {
                for(int j = 0; j < 5; j++)
    //*  12   26:iconst_0        
    //*  13   27:istore_3        
    //*  14   28:goto            43
                    data[i][j] = null;
    //   15   31:aload_0         
    //   16   32:getfield        #38  <Field Object[][] data>
    //   17   35:iload_2         
    //   18   36:aaload          
    //   19   37:iload_3         
    //   20   38:aconst_null     
    //   21   39:aastore         

    //   22   40:iinc            3  1
    //   23   43:iload_3         
    //   24   44:iconst_5        
    //   25   45:icmplt          31
            }

    //   26   48:iinc            2  1
    //   27   51:iload_2         
    //   28   52:bipush          100
    //   29   54:icmplt          26
            for(int i = 0; i < 8; i++)
    //*  30   57:iconst_0        
    //*  31   58:istore_2        
    //*  32   59:goto            88
            {
                for(int j = 0; j < 5; j++)
    //*  33   62:iconst_0        
    //*  34   63:istore_3        
    //*  35   64:goto            80
                    data[i][j] = "\u91CD\u7ED8";
    //   36   67:aload_0         
    //   37   68:getfield        #38  <Field Object[][] data>
    //   38   71:iload_2         
    //   39   72:aaload          
    //   40   73:iload_3         
    //   41   74:ldc1            #125 <String "\u91CD\u7ED8">
    //   42   76:aastore         

    //   43   77:iinc            3  1
    //   44   80:iload_3         
    //   45   81:iconst_5        
    //   46   82:icmplt          67
            }

    //   47   85:iinc            2  1
    //   48   88:iload_2         
    //   49   89:bipush          8
    //   50   91:icmplt          62
        }
    //   51   94:return          
    }

    public static void main(String args[])
    {
        new TestJtable();
    //    0    0:new             #2   <Class TestJtable>
    //    1    3:invokespecial   #130 <Method void TestJtable()>
    //    2    6:return          
    }

    JFrame jFrame;
    JScrollPane jScrollPane;
    JTable jTable;
    JPanel jPanel;
    JButton jButton;
    String Names[] = {
        "\u7F16\u53F7", "\u59D3\u540D", "\u73ED\u7EA7"
    };
    Object data[][];
}
