// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   DataExchangeTest.java

package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

// Referenced classes of package main:
//            PasswordChooser, User

class DataExchangeFrame extends JFrame
{
    private class ConnectAction
        implements ActionListener
    {

        public void actionPerformed(ActionEvent event)
        {
            if(dialog == null)
        //*   0    0:aload_0         
        //*   1    1:getfield        #13  <Field DataExchangeFrame this$0>
        //*   2    4:invokestatic    #28  <Method PasswordChooser DataExchangeFrame.access$0(DataExchangeFrame)>
        //*   3    7:ifnonnull       24
                dialog = new PasswordChooser();
        //    4   10:aload_0         
        //    5   11:getfield        #13  <Field DataExchangeFrame this$0>
        //    6   14:new             #30  <Class PasswordChooser>
        //    7   17:dup             
        //    8   18:invokespecial   #31  <Method void PasswordChooser()>
        //    9   21:invokestatic    #35  <Method void DataExchangeFrame.access$1(DataExchangeFrame, PasswordChooser)>
            dialog.setUser(new User("yourname", null));
        //   10   24:aload_0         
        //   11   25:getfield        #13  <Field DataExchangeFrame this$0>
        //   12   28:invokestatic    #28  <Method PasswordChooser DataExchangeFrame.access$0(DataExchangeFrame)>
        //   13   31:new             #37  <Class User>
        //   14   34:dup             
        //   15   35:ldc1            #39  <String "yourname">
        //   16   37:aconst_null     
        //   17   38:invokespecial   #42  <Method void User(String, char[])>
        //   18   41:invokevirtual   #46  <Method void PasswordChooser.setUser(User)>
            if(dialog.showDialog(DataExchangeFrame.this, "Connect"))
        //*  19   44:aload_0         
        //*  20   45:getfield        #13  <Field DataExchangeFrame this$0>
        //*  21   48:invokestatic    #28  <Method PasswordChooser DataExchangeFrame.access$0(DataExchangeFrame)>
        //*  22   51:aload_0         
        //*  23   52:getfield        #13  <Field DataExchangeFrame this$0>
        //*  24   55:ldc1            #48  <String "Connect">
        //*  25   57:invokevirtual   #52  <Method boolean PasswordChooser.showDialog(java.awt.Component, String)>
        //*  26   60:ifeq            127
            {
                User u = dialog.getUser();
        //   27   63:aload_0         
        //   28   64:getfield        #13  <Field DataExchangeFrame this$0>
        //   29   67:invokestatic    #28  <Method PasswordChooser DataExchangeFrame.access$0(DataExchangeFrame)>
        //   30   70:invokevirtual   #56  <Method User PasswordChooser.getUser()>
        //   31   73:astore_2        
                textArea.append((new StringBuilder("user name = ")).append(u.getName()).append(", password = ").append(new String(u.getPassword())).append("\n").toString());
        //   32   74:aload_0         
        //   33   75:getfield        #13  <Field DataExchangeFrame this$0>
        //   34   78:invokestatic    #60  <Method JTextArea DataExchangeFrame.access$2(DataExchangeFrame)>
        //   35   81:new             #62  <Class StringBuilder>
        //   36   84:dup             
        //   37   85:ldc1            #64  <String "user name = ">
        //   38   87:invokespecial   #67  <Method void StringBuilder(String)>
        //   39   90:aload_2         
        //   40   91:invokevirtual   #71  <Method String User.getName()>
        //   41   94:invokevirtual   #75  <Method StringBuilder StringBuilder.append(String)>
        //   42   97:ldc1            #77  <String ", password = ">
        //   43   99:invokevirtual   #75  <Method StringBuilder StringBuilder.append(String)>
        //   44  102:new             #79  <Class String>
        //   45  105:dup             
        //   46  106:aload_2         
        //   47  107:invokevirtual   #83  <Method char[] User.getPassword()>
        //   48  110:invokespecial   #86  <Method void String(char[])>
        //   49  113:invokevirtual   #75  <Method StringBuilder StringBuilder.append(String)>
        //   50  116:ldc1            #88  <String "\n">
        //   51  118:invokevirtual   #75  <Method StringBuilder StringBuilder.append(String)>
        //   52  121:invokevirtual   #91  <Method String StringBuilder.toString()>
        //   53  124:invokevirtual   #95  <Method void JTextArea.append(String)>
            }
        //   54  127:return          
        }

        final DataExchangeFrame this$0;

        ConnectAction()
        {super();
            this$0 = DataExchangeFrame.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #13  <Field DataExchangeFrame this$0>
            
        //    3    5:aload_0         
        //    4    6:invokespecial   #16  <Method void Object()>
        //    5    9:return          
        }
    }


    public DataExchangeFrame()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #19  <Method void JFrame()>
        dialog = null;
    //    2    4:aload_0         
    //    3    5:aconst_null     
    //    4    6:putfield        #21  <Field PasswordChooser dialog>
        setTitle("DataExchangeTest");
    //    5    9:aload_0         
    //    6   10:ldc1            #23  <String "DataExchangeTest">
    //    7   12:invokevirtual   #27  <Method void setTitle(String)>
        setSize(300, 200);
    //    8   15:aload_0         
    //    9   16:sipush          300
    //   10   19:sipush          200
    //   11   22:invokevirtual   #31  <Method void setSize(int, int)>
        JMenuBar mbar = new JMenuBar();
    //   12   25:new             #33  <Class JMenuBar>
    //   13   28:dup             
    //   14   29:invokespecial   #34  <Method void JMenuBar()>
    //   15   32:astore_1        
        setJMenuBar(mbar);
    //   16   33:aload_0         
    //   17   34:aload_1         
    //   18   35:invokevirtual   #38  <Method void setJMenuBar(JMenuBar)>
        JMenu fileMenu = new JMenu("File");
    //   19   38:new             #40  <Class JMenu>
    //   20   41:dup             
    //   21   42:ldc1            #42  <String "File">
    //   22   44:invokespecial   #44  <Method void JMenu(String)>
    //   23   47:astore_2        
        mbar.add(fileMenu);
    //   24   48:aload_1         
    //   25   49:aload_2         
    //   26   50:invokevirtual   #48  <Method JMenu JMenuBar.add(JMenu)>
    //   27   53:pop             
        JMenuItem connectItem = new JMenuItem("Connect");
    //   28   54:new             #50  <Class JMenuItem>
    //   29   57:dup             
    //   30   58:ldc1            #52  <String "Connect">
    //   31   60:invokespecial   #53  <Method void JMenuItem(String)>
    //   32   63:astore_3        
        connectItem.addActionListener(new ConnectAction());
    //   33   64:aload_3         
    //   34   65:new             #55  <Class DataExchangeFrame$ConnectAction>
    //   35   68:dup             
    //   36   69:aload_0         
    //   37   70:invokespecial   #58  <Method void DataExchangeFrame$ConnectAction(DataExchangeFrame)>
    //   38   73:invokevirtual   #62  <Method void JMenuItem.addActionListener(ActionListener)>
        fileMenu.add(connectItem);
    //   39   76:aload_2         
    //   40   77:aload_3         
    //   41   78:invokevirtual   #65  <Method JMenuItem JMenu.add(JMenuItem)>
    //   42   81:pop             
        JMenuItem exitItem = new JMenuItem("Exit");
    //   43   82:new             #50  <Class JMenuItem>
    //   44   85:dup             
    //   45   86:ldc1            #67  <String "Exit">
    //   46   88:invokespecial   #53  <Method void JMenuItem(String)>
    //   47   91:astore          4
        exitItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event)
            {
                System.exit(0);
            //    0    0:iconst_0        
            //    1    1:invokestatic    #28  <Method void System.exit(int)>
            //    2    4:return          
            }

            final DataExchangeFrame this$0;

            
            {
                this$0 = DataExchangeFrame.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field DataExchangeFrame this$0>
              //  super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //   48   93:aload           4
    //   49   95:new             #69  <Class DataExchangeFrame$1>
    //   50   98:dup             
    //   51   99:aload_0         
    //   52  100:invokespecial   #70  <Method void DataExchangeFrame$1(DataExchangeFrame)>
    //   53  103:invokevirtual   #62  <Method void JMenuItem.addActionListener(ActionListener)>
        fileMenu.add(exitItem);
    //   54  106:aload_2         
    //   55  107:aload           4
    //   56  109:invokevirtual   #65  <Method JMenuItem JMenu.add(JMenuItem)>
    //   57  112:pop             
        textArea = new JTextArea();
    //   58  113:aload_0         
    //   59  114:new             #72  <Class JTextArea>
    //   60  117:dup             
    //   61  118:invokespecial   #73  <Method void JTextArea()>
    //   62  121:putfield        #75  <Field JTextArea textArea>
        add(new JScrollPane(textArea), "Center");
    //   63  124:aload_0         
    //   64  125:new             #77  <Class JScrollPane>
    //   65  128:dup             
    //   66  129:aload_0         
    //   67  130:getfield        #75  <Field JTextArea textArea>
    //   68  133:invokespecial   #80  <Method void JScrollPane(java.awt.Component)>
    //   69  136:ldc1            #82  <String "Center">
    //   70  138:invokevirtual   #85  <Method void add(java.awt.Component, Object)>
    //   71  141:return          
    }

    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 200;
    private PasswordChooser dialog;
    private JTextArea textArea;


/*
    static PasswordChooser access$0(DataExchangeFrame dataexchangeframe)
    {
        return dataexchangeframe.dialog;
    //    0    0:aload_0         
    //    1    1:getfield        #21  <Field PasswordChooser dialog>
    //    2    4:areturn         
    }

*/


/*
    static void access$1(DataExchangeFrame dataexchangeframe, PasswordChooser passwordchooser)
    {
        dataexchangeframe.dialog = passwordchooser;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #21  <Field PasswordChooser dialog>
        return;
    //    3    5:return          
    }

*/


/*
    static JTextArea access$2(DataExchangeFrame dataexchangeframe)
    {
        return dataexchangeframe.textArea;
    //    0    0:aload_0         
    //    1    1:getfield        #75  <Field JTextArea textArea>
    //    2    4:areturn         
    }

*/
}
