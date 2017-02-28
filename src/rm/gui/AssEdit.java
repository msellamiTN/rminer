// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   AssEdit.java

package rm.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class AssEdit extends JFrame
{
    class Listen
        implements ActionListener
    {

        public void actionPerformed(ActionEvent e)
        {
            Object source = e.getSource();
        //    0    0:aload_1         
        //    1    1:invokevirtual   #28  <Method Object ActionEvent.getSource()>
        //    2    4:astore_2        
            if(source == newFiles)
        //*   3    5:aload_2         
        //*   4    6:aload_0         
        //*   5    7:getfield        #13  <Field AssEdit this$0>
        //*   6   10:getfield        #34  <Field JMenuItem AssEdit.newFiles>
        //*   7   13:if_acmpne       47
            {
                text.setText("");
        //    8   16:aload_0         
        //    9   17:getfield        #13  <Field AssEdit this$0>
        //   10   20:getfield        #38  <Field JTextArea AssEdit.text>
        //   11   23:ldc1            #40  <String "">
        //   12   25:invokevirtual   #46  <Method void JTextArea.setText(String)>
                Path = null;
        //   13   28:aload_0         
        //   14   29:getfield        #13  <Field AssEdit this$0>
        //   15   32:aconst_null     
        //   16   33:putfield        #50  <Field String AssEdit.Path>
                Opened = false;
        //   17   36:aload_0         
        //   18   37:getfield        #13  <Field AssEdit this$0>
        //   19   40:iconst_0        
        //   20   41:putfield        #54  <Field boolean AssEdit.Opened>
            } else
        //*  21   44:goto            320
            if(source == Exit)
        //*  22   47:aload_2         
        //*  23   48:aload_0         
        //*  24   49:getfield        #13  <Field AssEdit this$0>
        //*  25   52:getfield        #57  <Field JMenuItem AssEdit.Exit>
        //*  26   55:if_acmpne       65
                System.exit(0);
        //   27   58:iconst_0        
        //   28   59:invokestatic    #63  <Method void System.exit(int)>
            else
        //*  29   62:goto            320
            if(source == Open)
        //*  30   65:aload_2         
        //*  31   66:aload_0         
        //*  32   67:getfield        #13  <Field AssEdit this$0>
        //*  33   70:getfield        #66  <Field JMenuItem AssEdit.Open>
        //*  34   73:if_acmpne       161
            {
                FileDialog openFile = new FileDialog(th, "Open File...", 0);
        //   35   76:new             #68  <Class FileDialog>
        //   36   79:dup             
        //   37   80:aload_0         
        //   38   81:getfield        #13  <Field AssEdit this$0>
        //   39   84:getfield        #72  <Field JFrame AssEdit.th>
        //   40   87:ldc1            #74  <String "Open File...">
        //   41   89:iconst_0        
        //   42   90:invokespecial   #77  <Method void FileDialog(java.awt.Frame, String, int)>
        //   43   93:astore_3        
                openFile.setVisible(true);
        //   44   94:aload_3         
        //   45   95:iconst_1        
        //   46   96:invokevirtual   #81  <Method void FileDialog.setVisible(boolean)>
                String filePath = (new StringBuilder(String.valueOf(openFile.getDirectory()))).append(openFile.getFile()).toString();
        //   47   99:new             #83  <Class StringBuilder>
        //   48  102:dup             
        //   49  103:aload_3         
        //   50  104:invokevirtual   #87  <Method String FileDialog.getDirectory()>
        //   51  107:invokestatic    #93  <Method String String.valueOf(Object)>
        //   52  110:invokespecial   #95  <Method void StringBuilder(String)>
        //   53  113:aload_3         
        //   54  114:invokevirtual   #98  <Method String FileDialog.getFile()>
        //   55  117:invokevirtual   #102 <Method StringBuilder StringBuilder.append(String)>
        //   56  120:invokevirtual   #105 <Method String StringBuilder.toString()>
        //   57  123:astore          4
                ReadFile(filePath);
        //   58  125:aload_0         
        //   59  126:getfield        #13  <Field AssEdit this$0>
        //   60  129:aload           4
        //   61  131:invokevirtual   #108 <Method void AssEdit.ReadFile(String)>
                if(openFile.getFile() != null)
        //*  62  134:aload_3         
        //*  63  135:invokevirtual   #98  <Method String FileDialog.getFile()>
        //*  64  138:ifnull          320
                {
                    Path = filePath;
        //   65  141:aload_0         
        //   66  142:getfield        #13  <Field AssEdit this$0>
        //   67  145:aload           4
        //   68  147:putfield        #50  <Field String AssEdit.Path>
                    Opened = true;
        //   69  150:aload_0         
        //   70  151:getfield        #13  <Field AssEdit this$0>
        //   71  154:iconst_1        
        //   72  155:putfield        #54  <Field boolean AssEdit.Opened>
                }
            } else
        //*  73  158:goto            320
            if(source == Save || source == SaveAs)
        //*  74  161:aload_2         
        //*  75  162:aload_0         
        //*  76  163:getfield        #13  <Field AssEdit this$0>
        //*  77  166:getfield        #111 <Field JMenuItem AssEdit.Save>
        //*  78  169:if_acmpeq       183
        //*  79  172:aload_2         
        //*  80  173:aload_0         
        //*  81  174:getfield        #13  <Field AssEdit this$0>
        //*  82  177:getfield        #114 <Field JMenuItem AssEdit.SaveAs>
        //*  83  180:if_acmpne       320
            {
                String savePath = Path;
        //   84  183:aload_0         
        //   85  184:getfield        #13  <Field AssEdit this$0>
        //   86  187:getfield        #50  <Field String AssEdit.Path>
        //   87  190:astore_3        
                if(savePath == null || source == SaveAs)
        //*  88  191:aload_3         
        //*  89  192:ifnull          206
        //*  90  195:aload_2         
        //*  91  196:aload_0         
        //*  92  197:getfield        #13  <Field AssEdit this$0>
        //*  93  200:getfield        #114 <Field JMenuItem AssEdit.SaveAs>
        //*  94  203:if_acmpne       258
                {
                    FileDialog saveFile = new FileDialog(th, "Save File...", 1);
        //   95  206:new             #68  <Class FileDialog>
        //   96  209:dup             
        //   97  210:aload_0         
        //   98  211:getfield        #13  <Field AssEdit this$0>
        //   99  214:getfield        #72  <Field JFrame AssEdit.th>
        //  100  217:ldc1            #116 <String "Save File...">
        //  101  219:iconst_1        
        //  102  220:invokespecial   #77  <Method void FileDialog(java.awt.Frame, String, int)>
        //  103  223:astore          4
                    saveFile.setVisible(true);
        //  104  225:aload           4
        //  105  227:iconst_1        
        //  106  228:invokevirtual   #81  <Method void FileDialog.setVisible(boolean)>
                    savePath = (new StringBuilder(String.valueOf(saveFile.getDirectory()))).append(saveFile.getFile()).toString();
        //  107  231:new             #83  <Class StringBuilder>
        //  108  234:dup             
        //  109  235:aload           4
        //  110  237:invokevirtual   #87  <Method String FileDialog.getDirectory()>
        //  111  240:invokestatic    #93  <Method String String.valueOf(Object)>
        //  112  243:invokespecial   #95  <Method void StringBuilder(String)>
        //  113  246:aload           4
        //  114  248:invokevirtual   #98  <Method String FileDialog.getFile()>
        //  115  251:invokevirtual   #102 <Method StringBuilder StringBuilder.append(String)>
        //  116  254:invokevirtual   #105 <Method String StringBuilder.toString()>
        //  117  257:astore_3        
                }
                try
                {
                    FileOutputStream fos = new FileOutputStream(savePath);
        //  118  258:new             #118 <Class FileOutputStream>
        //  119  261:dup             
        //  120  262:aload_3         
        //  121  263:invokespecial   #119 <Method void FileOutputStream(String)>
        //  122  266:astore          4
                    fos.write(text.getText().getBytes());
        //  123  268:aload           4
        //  124  270:aload_0         
        //  125  271:getfield        #13  <Field AssEdit this$0>
        //  126  274:getfield        #38  <Field JTextArea AssEdit.text>
        //  127  277:invokevirtual   #122 <Method String JTextArea.getText()>
        //  128  280:invokevirtual   #126 <Method byte[] String.getBytes()>
        //  129  283:invokevirtual   #130 <Method void FileOutputStream.write(byte[])>
                    fos.close();
        //  130  286:aload           4
        //  131  288:invokevirtual   #133 <Method void FileOutputStream.close()>
                }
        //* 132  291:goto            301
                catch(Exception ex)
        //* 133  294:astore          4
                {
                    ex.printStackTrace();
        //  134  296:aload           4
        //  135  298:invokevirtual   #138 <Method void Exception.printStackTrace()>
                }
                if(source == Save)
        //* 136  301:aload_2         
        //* 137  302:aload_0         
        //* 138  303:getfield        #13  <Field AssEdit this$0>
        //* 139  306:getfield        #111 <Field JMenuItem AssEdit.Save>
        //* 140  309:if_acmpne       320
                    Path = savePath;
        //  141  312:aload_0         
        //  142  313:getfield        #13  <Field AssEdit this$0>
        //  143  316:aload_3         
        //  144  317:putfield        #50  <Field String AssEdit.Path>
            }
        //  145  320:return          
        }

        final AssEdit this$0;

        Listen()
        {
            this$0 = AssEdit.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #13  <Field AssEdit this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #16  <Method void Object()>
        //    5    9:return          
        }
    }


    public AssEdit(String Path)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #34  <Method void JFrame()>
        Menub = new JMenuBar();
    //    2    4:aload_0         
    //    3    5:new             #36  <Class JMenuBar>
    //    4    8:dup             
    //    5    9:invokespecial   #37  <Method void JMenuBar()>
    //    6   12:putfield        #39  <Field JMenuBar Menub>
        text = new JTextArea();
    //    7   15:aload_0         
    //    8   16:new             #41  <Class JTextArea>
    //    9   19:dup             
    //   10   20:invokespecial   #42  <Method void JTextArea()>
    //   11   23:putfield        #44  <Field JTextArea text>
        Files = new JMenu("File");
    //   12   26:aload_0         
    //   13   27:new             #46  <Class JMenu>
    //   14   30:dup             
    //   15   31:ldc1            #48  <String "File">
    //   16   33:invokespecial   #50  <Method void JMenu(String)>
    //   17   36:putfield        #52  <Field JMenu Files>
        newFiles = new JMenuItem("NewFile");
    //   18   39:aload_0         
    //   19   40:new             #54  <Class JMenuItem>
    //   20   43:dup             
    //   21   44:ldc1            #56  <String "NewFile">
    //   22   46:invokespecial   #57  <Method void JMenuItem(String)>
    //   23   49:putfield        #59  <Field JMenuItem newFiles>
        Open = new JMenuItem("Open");
    //   24   52:aload_0         
    //   25   53:new             #54  <Class JMenuItem>
    //   26   56:dup             
    //   27   57:ldc1            #60  <String "Open">
    //   28   59:invokespecial   #57  <Method void JMenuItem(String)>
    //   29   62:putfield        #62  <Field JMenuItem Open>
        Save = new JMenuItem("Save");
    //   30   65:aload_0         
    //   31   66:new             #54  <Class JMenuItem>
    //   32   69:dup             
    //   33   70:ldc1            #63  <String "Save">
    //   34   72:invokespecial   #57  <Method void JMenuItem(String)>
    //   35   75:putfield        #65  <Field JMenuItem Save>
        SaveAs = new JMenuItem("SaveAs");
    //   36   78:aload_0         
    //   37   79:new             #54  <Class JMenuItem>
    //   38   82:dup             
    //   39   83:ldc1            #66  <String "SaveAs">
    //   40   85:invokespecial   #57  <Method void JMenuItem(String)>
    //   41   88:putfield        #68  <Field JMenuItem SaveAs>
        Exit = new JMenuItem("Exit");
    //   42   91:aload_0         
    //   43   92:new             #54  <Class JMenuItem>
    //   44   95:dup             
    //   45   96:ldc1            #69  <String "Exit">
    //   46   98:invokespecial   #57  <Method void JMenuItem(String)>
    //   47  101:putfield        #71  <Field JMenuItem Exit>
    //   48  104:aload_0         
    //   49  105:sipush          800
    //   50  108:putfield        #73  <Field int DEFAULT_WIDTH>
    //   51  111:aload_0         
    //   52  112:sipush          600
    //   53  115:putfield        #75  <Field int DEFAULT_HEIGHT>
        th = this;
    //   54  118:aload_0         
    //   55  119:aload_0         
    //   56  120:putfield        #77  <Field JFrame th>
        this.Path = null;
    //   57  123:aload_0         
    //   58  124:aconst_null     
    //   59  125:putfield        #79  <Field String Path>
        Opened = false;
    //   60  128:aload_0         
    //   61  129:iconst_0        
    //   62  130:putfield        #81  <Field boolean Opened>
        this.Path = Path;
    //   63  133:aload_0         
    //   64  134:aload_1         
    //   65  135:putfield        #79  <Field String Path>
        init();
    //   66  138:aload_0         
    //   67  139:invokevirtual   #84  <Method void init()>
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    //   68  142:invokestatic    #90  <Method Toolkit Toolkit.getDefaultToolkit()>
    //   69  145:invokevirtual   #94  <Method Dimension Toolkit.getScreenSize()>
    //   70  148:astore          4
        setMinimumSize(new Dimension(250, 150));
    //   71  150:aload_0         
    //   72  151:new             #96  <Class Dimension>
    //   73  154:dup             
    //   74  155:sipush          250
    //   75  158:sipush          150
    //   76  161:invokespecial   #99  <Method void Dimension(int, int)>
    //   77  164:invokevirtual   #103 <Method void setMinimumSize(Dimension)>
        setDefaultCloseOperation(2);
    //   78  167:aload_0         
    //   79  168:iconst_2        
    //   80  169:invokevirtual   #107 <Method void setDefaultCloseOperation(int)>
    //   81  172:return          
    }

    void init()
    {
        Toolkit tk = Toolkit.getDefaultToolkit();
    //    0    0:invokestatic    #90  <Method Toolkit Toolkit.getDefaultToolkit()>
    //    1    3:astore_1        
        java.net.URL Imagepath = getClass().getClassLoader().getResource("images/Icon.png");
    //    2    4:aload_0         
    //    3    5:invokevirtual   #119 <Method Class Object.getClass()>
    //    4    8:invokevirtual   #125 <Method ClassLoader Class.getClassLoader()>
    //    5   11:ldc1            #127 <String "images/Icon.png">
    //    6   13:invokevirtual   #133 <Method java.net.URL ClassLoader.getResource(String)>
    //    7   16:astore_2        
        java.awt.Image img = tk.getImage(Imagepath);
    //    8   17:aload_1         
    //    9   18:aload_2         
    //   10   19:invokevirtual   #137 <Method java.awt.Image Toolkit.getImage(java.net.URL)>
    //   11   22:astore_3        
        setIconImage(img);
    //   12   23:aload_0         
    //   13   24:aload_3         
    //   14   25:invokevirtual   #141 <Method void setIconImage(java.awt.Image)>
        setTitle("Assigment Editor");
    //   15   28:aload_0         
    //   16   29:ldc1            #143 <String "Assigment Editor">
    //   17   31:invokevirtual   #146 <Method void setTitle(String)>
        Files.setMnemonic('F');
    //   18   34:aload_0         
    //   19   35:getfield        #52  <Field JMenu Files>
    //   20   38:bipush          70
    //   21   40:invokevirtual   #150 <Method void JMenu.setMnemonic(char)>
        newFiles.setMnemonic('N');
    //   22   43:aload_0         
    //   23   44:getfield        #59  <Field JMenuItem newFiles>
    //   24   47:bipush          78
    //   25   49:invokevirtual   #151 <Method void JMenuItem.setMnemonic(char)>
        Open.setMnemonic('O');
    //   26   52:aload_0         
    //   27   53:getfield        #62  <Field JMenuItem Open>
    //   28   56:bipush          79
    //   29   58:invokevirtual   #151 <Method void JMenuItem.setMnemonic(char)>
        Save.setMnemonic('S');
    //   30   61:aload_0         
    //   31   62:getfield        #65  <Field JMenuItem Save>
    //   32   65:bipush          83
    //   33   67:invokevirtual   #151 <Method void JMenuItem.setMnemonic(char)>
        SaveAs.setMnemonic('A');
    //   34   70:aload_0         
    //   35   71:getfield        #68  <Field JMenuItem SaveAs>
    //   36   74:bipush          65
    //   37   76:invokevirtual   #151 <Method void JMenuItem.setMnemonic(char)>
        Exit.setMnemonic('X');
    //   38   79:aload_0         
    //   39   80:getfield        #71  <Field JMenuItem Exit>
    //   40   83:bipush          88
    //   41   85:invokevirtual   #151 <Method void JMenuItem.setMnemonic(char)>
        newFiles.setAccelerator(KeyStroke.getKeyStroke(78, 2));
    //   42   88:aload_0         
    //   43   89:getfield        #59  <Field JMenuItem newFiles>
    //   44   92:bipush          78
    //   45   94:iconst_2        
    //   46   95:invokestatic    #157 <Method KeyStroke KeyStroke.getKeyStroke(int, int)>
    //   47   98:invokevirtual   #161 <Method void JMenuItem.setAccelerator(KeyStroke)>
        Open.setAccelerator(KeyStroke.getKeyStroke(79, 2));
    //   48  101:aload_0         
    //   49  102:getfield        #62  <Field JMenuItem Open>
    //   50  105:bipush          79
    //   51  107:iconst_2        
    //   52  108:invokestatic    #157 <Method KeyStroke KeyStroke.getKeyStroke(int, int)>
    //   53  111:invokevirtual   #161 <Method void JMenuItem.setAccelerator(KeyStroke)>
        Save.setAccelerator(KeyStroke.getKeyStroke(83, 2));
    //   54  114:aload_0         
    //   55  115:getfield        #65  <Field JMenuItem Save>
    //   56  118:bipush          83
    //   57  120:iconst_2        
    //   58  121:invokestatic    #157 <Method KeyStroke KeyStroke.getKeyStroke(int, int)>
    //   59  124:invokevirtual   #161 <Method void JMenuItem.setAccelerator(KeyStroke)>
        Exit.setAccelerator(KeyStroke.getKeyStroke(81, 2));
    //   60  127:aload_0         
    //   61  128:getfield        #71  <Field JMenuItem Exit>
    //   62  131:bipush          81
    //   63  133:iconst_2        
    //   64  134:invokestatic    #157 <Method KeyStroke KeyStroke.getKeyStroke(int, int)>
    //   65  137:invokevirtual   #161 <Method void JMenuItem.setAccelerator(KeyStroke)>
        Files.add(newFiles);
    //   66  140:aload_0         
    //   67  141:getfield        #52  <Field JMenu Files>
    //   68  144:aload_0         
    //   69  145:getfield        #59  <Field JMenuItem newFiles>
    //   70  148:invokevirtual   #165 <Method JMenuItem JMenu.add(JMenuItem)>
    //   71  151:pop             
        Files.add(Open);
    //   72  152:aload_0         
    //   73  153:getfield        #52  <Field JMenu Files>
    //   74  156:aload_0         
    //   75  157:getfield        #62  <Field JMenuItem Open>
    //   76  160:invokevirtual   #165 <Method JMenuItem JMenu.add(JMenuItem)>
    //   77  163:pop             
        Files.add(Save);
    //   78  164:aload_0         
    //   79  165:getfield        #52  <Field JMenu Files>
    //   80  168:aload_0         
    //   81  169:getfield        #65  <Field JMenuItem Save>
    //   82  172:invokevirtual   #165 <Method JMenuItem JMenu.add(JMenuItem)>
    //   83  175:pop             
        Files.add(SaveAs);
    //   84  176:aload_0         
    //   85  177:getfield        #52  <Field JMenu Files>
    //   86  180:aload_0         
    //   87  181:getfield        #68  <Field JMenuItem SaveAs>
    //   88  184:invokevirtual   #165 <Method JMenuItem JMenu.add(JMenuItem)>
    //   89  187:pop             
        Files.add(Exit);
    //   90  188:aload_0         
    //   91  189:getfield        #52  <Field JMenu Files>
    //   92  192:aload_0         
    //   93  193:getfield        #71  <Field JMenuItem Exit>
    //   94  196:invokevirtual   #165 <Method JMenuItem JMenu.add(JMenuItem)>
    //   95  199:pop             
        Menub.add(Files);
    //   96  200:aload_0         
    //   97  201:getfield        #39  <Field JMenuBar Menub>
    //   98  204:aload_0         
    //   99  205:getfield        #52  <Field JMenu Files>
    //  100  208:invokevirtual   #168 <Method JMenu JMenuBar.add(JMenu)>
    //  101  211:pop             
        setJMenuBar(Menub);
    //  102  212:aload_0         
    //  103  213:aload_0         
    //  104  214:getfield        #39  <Field JMenuBar Menub>
    //  105  217:invokevirtual   #172 <Method void setJMenuBar(JMenuBar)>
        getContentPane().add(new JScrollPane(text));
    //  106  220:aload_0         
    //  107  221:invokevirtual   #176 <Method Container getContentPane()>
    //  108  224:new             #178 <Class JScrollPane>
    //  109  227:dup             
    //  110  228:aload_0         
    //  111  229:getfield        #44  <Field JTextArea text>
    //  112  232:invokespecial   #181 <Method void JScrollPane(java.awt.Component)>
    //  113  235:invokevirtual   #186 <Method java.awt.Component Container.add(java.awt.Component)>
    //  114  238:pop             
        if(Path != null && Path.length() > 0)
    //* 115  239:aload_0         
    //* 116  240:getfield        #79  <Field String Path>
    //* 117  243:ifnull          264
    //* 118  246:aload_0         
    //* 119  247:getfield        #79  <Field String Path>
    //* 120  250:invokevirtual   #192 <Method int String.length()>
    //* 121  253:ifle            264
            ReadFile(Path);
    //  122  256:aload_0         
    //  123  257:aload_0         
    //  124  258:getfield        #79  <Field String Path>
    //  125  261:invokevirtual   #195 <Method void ReadFile(String)>
        Listen listen = new Listen();
    //  126  264:new             #197 <Class AssEdit$Listen>
    //  127  267:dup             
    //  128  268:aload_0         
    //  129  269:invokespecial   #200 <Method void AssEdit$Listen(AssEdit)>
    //  130  272:astore          4
        newFiles.addActionListener(listen);
    //  131  274:aload_0         
    //  132  275:getfield        #59  <Field JMenuItem newFiles>
    //  133  278:aload           4
    //  134  280:invokevirtual   #204 <Method void JMenuItem.addActionListener(ActionListener)>
        Open.addActionListener(listen);
    //  135  283:aload_0         
    //  136  284:getfield        #62  <Field JMenuItem Open>
    //  137  287:aload           4
    //  138  289:invokevirtual   #204 <Method void JMenuItem.addActionListener(ActionListener)>
        Save.addActionListener(listen);
    //  139  292:aload_0         
    //  140  293:getfield        #65  <Field JMenuItem Save>
    //  141  296:aload           4
    //  142  298:invokevirtual   #204 <Method void JMenuItem.addActionListener(ActionListener)>
        SaveAs.addActionListener(listen);
    //  143  301:aload_0         
    //  144  302:getfield        #68  <Field JMenuItem SaveAs>
    //  145  305:aload           4
    //  146  307:invokevirtual   #204 <Method void JMenuItem.addActionListener(ActionListener)>
        Exit.addActionListener(listen);
    //  147  310:aload_0         
    //  148  311:getfield        #71  <Field JMenuItem Exit>
    //  149  314:aload           4
    //  150  316:invokevirtual   #204 <Method void JMenuItem.addActionListener(ActionListener)>
    //  151  319:return          
    }

    void ReadFile(String filePath)
    {
        try
        {
            FileInputStream fis = new FileInputStream(filePath);
    //    0    0:new             #214 <Class FileInputStream>
    //    1    3:dup             
    //    2    4:aload_1         
    //    3    5:invokespecial   #215 <Method void FileInputStream(String)>
    //    4    8:astore_2        
            byte content[] = new byte[fis.available()];
    //    5    9:aload_2         
    //    6   10:invokevirtual   #218 <Method int FileInputStream.available()>
    //    7   13:newarray        byte[]
    //    8   15:astore_3        
            fis.read(content);
    //    9   16:aload_2         
    //   10   17:aload_3         
    //   11   18:invokevirtual   #222 <Method int FileInputStream.read(byte[])>
    //   12   21:pop             
            text.setText(new String(content));
    //   13   22:aload_0         
    //   14   23:getfield        #44  <Field JTextArea text>
    //   15   26:new             #188 <Class String>
    //   16   29:dup             
    //   17   30:aload_3         
    //   18   31:invokespecial   #225 <Method void String(byte[])>
    //   19   34:invokevirtual   #228 <Method void JTextArea.setText(String)>
            text.setCaretPosition(0);
    //   20   37:aload_0         
    //   21   38:getfield        #44  <Field JTextArea text>
    //   22   41:iconst_0        
    //   23   42:invokevirtual   #231 <Method void JTextArea.setCaretPosition(int)>
            fis.close();
    //   24   45:aload_2         
    //   25   46:invokevirtual   #234 <Method void FileInputStream.close()>
        }
    //*  26   49:goto            57
        catch(Exception ex)
    //*  27   52:astore_2        
        {
            ex.printStackTrace();
    //   28   53:aload_2         
    //   29   54:invokevirtual   #239 <Method void Exception.printStackTrace()>
        }
    //   30   57:return          
    }

    public static void main(String args[])
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    //    0    0:invokestatic    #254 <Method String UIManager.getSystemLookAndFeelClassName()>
    //    1    3:invokestatic    #257 <Method void UIManager.setLookAndFeel(String)>
        }
    //*   2    6:goto            33
        catch(Exception e)
    //*   3    9:astore_1        
        {
            System.err.println((new StringBuilder("Couldn't use the system look and feel:")).append(e).toString());
    //    4   10:getstatic       #263 <Field PrintStream System.err>
    //    5   13:new             #265 <Class StringBuilder>
    //    6   16:dup             
    //    7   17:ldc2            #267 <String "Couldn't use the system look and feel:">
    //    8   20:invokespecial   #268 <Method void StringBuilder(String)>
    //    9   23:aload_1         
    //   10   24:invokevirtual   #272 <Method StringBuilder StringBuilder.append(Object)>
    //   11   27:invokevirtual   #275 <Method String StringBuilder.toString()>
    //   12   30:invokevirtual   #280 <Method void PrintStream.println(String)>
        }
        JFrame.setDefaultLookAndFeelDecorated(true);
    //   13   33:iconst_1        
    //   14   34:invokestatic    #284 <Method void JFrame.setDefaultLookAndFeelDecorated(boolean)>
        JDialog.setDefaultLookAndFeelDecorated(true);
    //   15   37:iconst_1        
    //   16   38:invokestatic    #287 <Method void JDialog.setDefaultLookAndFeelDecorated(boolean)>
        AssEdit note = new AssEdit("E:\\RBACreator\\RMiner0.1\\datasets\\orca_user_permission.ass");
    //   17   41:new             #2   <Class AssEdit>
    //   18   44:dup             
    //   19   45:ldc2            #289 <String "E:\\RBACreator\\RMiner0.1\\datasets\\orca_user_permission.ass">
    //   20   48:invokespecial   #290 <Method void AssEdit(String)>
    //   21   51:astore_1        
        note.setVisible(true);
    //   22   52:aload_1         
    //   23   53:iconst_1        
    //   24   54:invokevirtual   #293 <Method void setVisible(boolean)>
    //   25   57:return          
    }

    JMenuBar Menub;
    JTextArea text;
    JMenu Files;
    JMenuItem newFiles;
    JMenuItem Open;
    JMenuItem Save;
    JMenuItem SaveAs;
    JMenuItem Exit;
    final int DEFAULT_WIDTH = 800;
    final int DEFAULT_HEIGHT = 600;
    JFrame th;
    String Path;
    boolean Opened;
}
