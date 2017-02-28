// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   DataExchangeTest.java

package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

// Referenced classes of package main:
//            User

class PasswordChooser extends JPanel
{

    public PasswordChooser()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #21  <Method void JPanel()>
        setLayout(new BorderLayout());
    //    2    4:aload_0         
    //    3    5:new             #23  <Class BorderLayout>
    //    4    8:dup             
    //    5    9:invokespecial   #24  <Method void BorderLayout()>
    //    6   12:invokevirtual   #28  <Method void setLayout(java.awt.LayoutManager)>
        JPanel panel = new JPanel();
    //    7   15:new             #4   <Class JPanel>
    //    8   18:dup             
    //    9   19:invokespecial   #21  <Method void JPanel()>
    //   10   22:astore_1        
        panel.setLayout(new GridLayout(2, 2));
    //   11   23:aload_1         
    //   12   24:new             #30  <Class GridLayout>
    //   13   27:dup             
    //   14   28:iconst_2        
    //   15   29:iconst_2        
    //   16   30:invokespecial   #33  <Method void GridLayout(int, int)>
    //   17   33:invokevirtual   #34  <Method void JPanel.setLayout(java.awt.LayoutManager)>
        panel.add(new JLabel("User name:"));
    //   18   36:aload_1         
    //   19   37:new             #36  <Class JLabel>
    //   20   40:dup             
    //   21   41:ldc1            #38  <String "User name:">
    //   22   43:invokespecial   #41  <Method void JLabel(String)>
    //   23   46:invokevirtual   #45  <Method Component JPanel.add(Component)>
    //   24   49:pop             
        panel.add(username = new JTextField(""));
    //   25   50:aload_1         
    //   26   51:aload_0         
    //   27   52:new             #47  <Class JTextField>
    //   28   55:dup             
    //   29   56:ldc1            #49  <String "">
    //   30   58:invokespecial   #50  <Method void JTextField(String)>
    //   31   61:dup_x1          
    //   32   62:putfield        #52  <Field JTextField username>
    //   33   65:invokevirtual   #45  <Method Component JPanel.add(Component)>
    //   34   68:pop             
        panel.add(new JLabel("Password:"));
    //   35   69:aload_1         
    //   36   70:new             #36  <Class JLabel>
    //   37   73:dup             
    //   38   74:ldc1            #54  <String "Password:">
    //   39   76:invokespecial   #41  <Method void JLabel(String)>
    //   40   79:invokevirtual   #45  <Method Component JPanel.add(Component)>
    //   41   82:pop             
        panel.add(password = new JPasswordField(""));
    //   42   83:aload_1         
    //   43   84:aload_0         
    //   44   85:new             #56  <Class JPasswordField>
    //   45   88:dup             
    //   46   89:ldc1            #49  <String "">
    //   47   91:invokespecial   #57  <Method void JPasswordField(String)>
    //   48   94:dup_x1          
    //   49   95:putfield        #59  <Field JPasswordField password>
    //   50   98:invokevirtual   #45  <Method Component JPanel.add(Component)>
    //   51  101:pop             
        add(panel, "Center");
    //   52  102:aload_0         
    //   53  103:aload_1         
    //   54  104:ldc1            #61  <String "Center">
    //   55  106:invokevirtual   #64  <Method void add(Component, Object)>
        okButton = new JButton("Ok");
    //   56  109:aload_0         
    //   57  110:new             #66  <Class JButton>
    //   58  113:dup             
    //   59  114:ldc1            #68  <String "Ok">
    //   60  116:invokespecial   #69  <Method void JButton(String)>
    //   61  119:putfield        #71  <Field JButton okButton>
        okButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event)
            {
                ok = true;
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field PasswordChooser this$0>
            //    2    4:iconst_1        
            //    3    5:invokestatic    #28  <Method void PasswordChooser.access$0(PasswordChooser, boolean)>
                dialog.setVisible(false);
            //    4    8:aload_0         
            //    5    9:getfield        #13  <Field PasswordChooser this$0>
            //    6   12:invokestatic    #32  <Method JDialog PasswordChooser.access$1(PasswordChooser)>
            //    7   15:iconst_0        
            //    8   16:invokevirtual   #38  <Method void JDialog.setVisible(boolean)>
            //    9   19:return          
            }

            final PasswordChooser this$0;

            
            {
                this$0 = PasswordChooser.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field PasswordChooser this$0>
//                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //   62  122:aload_0         
    //   63  123:getfield        #71  <Field JButton okButton>
    //   64  126:new             #73  <Class PasswordChooser$1>
    //   65  129:dup             
    //   66  130:aload_0         
    //   67  131:invokespecial   #76  <Method void PasswordChooser$1(PasswordChooser)>
    //   68  134:invokevirtual   #80  <Method void JButton.addActionListener(ActionListener)>
        JButton cancelButton = new JButton("Cancel");
    //   69  137:new             #66  <Class JButton>
    //   70  140:dup             
    //   71  141:ldc1            #82  <String "Cancel">
    //   72  143:invokespecial   #69  <Method void JButton(String)>
    //   73  146:astore_2        
        cancelButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event)
            {
                dialog.setVisible(false);
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field PasswordChooser this$0>
            //    2    4:invokestatic    #28  <Method JDialog PasswordChooser.access$1(PasswordChooser)>
            //    3    7:iconst_0        
            //    4    8:invokevirtual   #34  <Method void JDialog.setVisible(boolean)>
            //    5   11:return          
            }

            final PasswordChooser this$0;

            
            {
                this$0 = PasswordChooser.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field PasswordChooser this$0>
//                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //   74  147:aload_2         
    //   75  148:new             #84  <Class PasswordChooser$2>
    //   76  151:dup             
    //   77  152:aload_0         
    //   78  153:invokespecial   #85  <Method void PasswordChooser$2(PasswordChooser)>
    //   79  156:invokevirtual   #80  <Method void JButton.addActionListener(ActionListener)>
        JPanel buttonPanel = new JPanel();
    //   80  159:new             #4   <Class JPanel>
    //   81  162:dup             
    //   82  163:invokespecial   #21  <Method void JPanel()>
    //   83  166:astore_3        
        buttonPanel.add(okButton);
    //   84  167:aload_3         
    //   85  168:aload_0         
    //   86  169:getfield        #71  <Field JButton okButton>
    //   87  172:invokevirtual   #45  <Method Component JPanel.add(Component)>
    //   88  175:pop             
        buttonPanel.add(cancelButton);
    //   89  176:aload_3         
    //   90  177:aload_2         
    //   91  178:invokevirtual   #45  <Method Component JPanel.add(Component)>
    //   92  181:pop             
        add(buttonPanel, "South");
    //   93  182:aload_0         
    //   94  183:aload_3         
    //   95  184:ldc1            #87  <String "South">
    //   96  186:invokevirtual   #64  <Method void add(Component, Object)>
    //   97  189:return          
    }

    public void setUser(User u)
    {
        username.setText(u.getName());
    //    0    0:aload_0         
    //    1    1:getfield        #52  <Field JTextField username>
    //    2    4:aload_1         
    //    3    5:invokevirtual   #103 <Method String User.getName()>
    //    4    8:invokevirtual   #106 <Method void JTextField.setText(String)>
    //    5   11:return          
    }

    public User getUser()
    {
        return new User(username.getText(), password.getPassword());
    //    0    0:new             #99  <Class User>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:getfield        #52  <Field JTextField username>
    //    4    8:invokevirtual   #113 <Method String JTextField.getText()>
    //    5   11:aload_0         
    //    6   12:getfield        #59  <Field JPasswordField password>
    //    7   15:invokevirtual   #117 <Method char[] JPasswordField.getPassword()>
    //    8   18:invokespecial   #120 <Method void User(String, char[])>
    //    9   21:areturn         
    }

    public boolean showDialog(Component parent, String title)
    {
        ok = false;
    //    0    0:aload_0         
    //    1    1:iconst_0        
    //    2    2:putfield        #124 <Field boolean ok>
        Frame owner = null;
    //    3    5:aconst_null     
    //    4    6:astore_3        
        if(parent instanceof Frame)
    //*   5    7:aload_1         
    //*   6    8:instanceof      #126 <Class Frame>
    //*   7   11:ifeq            22
            owner = (Frame)parent;
    //    8   14:aload_1         
    //    9   15:checkcast       #126 <Class Frame>
    //   10   18:astore_3        
        else
    //*  11   19:goto            32
            owner = (Frame)SwingUtilities.getAncestorOfClass(Frame, parent);
    //   12   22:ldc1            #126 <Class Frame>
    //   13   24:aload_1         
    //   14   25:invokestatic    #132 <Method java.awt.Container SwingUtilities.getAncestorOfClass(Class, Component)>
    //   15   28:checkcast       #126 <Class Frame>
    //   16   31:astore_3        
        if(dialog == null || dialog.getOwner() != owner)
    //*  17   32:aload_0         
    //*  18   33:getfield        #134 <Field JDialog dialog>
    //*  19   36:ifnull          50
    //*  20   39:aload_0         
    //*  21   40:getfield        #134 <Field JDialog dialog>
    //*  22   43:invokevirtual   #140 <Method java.awt.Window JDialog.getOwner()>
    //*  23   46:aload_3         
    //*  24   47:if_acmpeq       93
        {
            dialog = new JDialog(owner, true);
    //   25   50:aload_0         
    //   26   51:new             #136 <Class JDialog>
    //   27   54:dup             
    //   28   55:aload_3         
    //   29   56:iconst_1        
    //   30   57:invokespecial   #143 <Method void JDialog(Frame, boolean)>
    //   31   60:putfield        #134 <Field JDialog dialog>
            dialog.add(this);
    //   32   63:aload_0         
    //   33   64:getfield        #134 <Field JDialog dialog>
    //   34   67:aload_0         
    //   35   68:invokevirtual   #144 <Method Component JDialog.add(Component)>
    //   36   71:pop             
            dialog.getRootPane().setDefaultButton(okButton);
    //   37   72:aload_0         
    //   38   73:getfield        #134 <Field JDialog dialog>
    //   39   76:invokevirtual   #148 <Method JRootPane JDialog.getRootPane()>
    //   40   79:aload_0         
    //   41   80:getfield        #71  <Field JButton okButton>
    //   42   83:invokevirtual   #154 <Method void JRootPane.setDefaultButton(JButton)>
            dialog.pack();
    //   43   86:aload_0         
    //   44   87:getfield        #134 <Field JDialog dialog>
    //   45   90:invokevirtual   #157 <Method void JDialog.pack()>
        }
        dialog.setTitle(title);
    //   46   93:aload_0         
    //   47   94:getfield        #134 <Field JDialog dialog>
    //   48   97:aload_2         
    //   49   98:invokevirtual   #160 <Method void JDialog.setTitle(String)>
        dialog.setVisible(true);
    //   50  101:aload_0         
    //   51  102:getfield        #134 <Field JDialog dialog>
    //   52  105:iconst_1        
    //   53  106:invokevirtual   #164 <Method void JDialog.setVisible(boolean)>
        return ok;
    //   54  109:aload_0         
    //   55  110:getfield        #124 <Field boolean ok>
    //   56  113:ireturn         
    }

    private JTextField username;
    private JPasswordField password;
    private JButton okButton;
    private boolean ok;
    private JDialog dialog;
    static Class class$0;


/*
    static void access$0(PasswordChooser passwordchooser, boolean flag)
    {
        passwordchooser.ok = flag;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #124 <Field boolean ok>
        return;
    //    3    5:return          
    }

*/


/*
    static JDialog access$1(PasswordChooser passwordchooser)
    {
        return passwordchooser.dialog;
    //    0    0:aload_0         
    //    1    1:getfield        #134 <Field JDialog dialog>
    //    2    4:areturn         
    }

*/
}
