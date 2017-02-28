// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   SaveBuffer.java

package rm.gui;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

// Referenced classes of package rm.gui:
//            Logger, LogPanel

public class SaveBuffer
{

    public SaveBuffer(Logger log, Component parent)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #16  <Method void Object()>
        m_lastvisitedDirectory = null;
    //    2    4:aload_0         
    //    3    5:aconst_null     
    //    4    6:putfield        #18  <Field String m_lastvisitedDirectory>
        m_Log = log;
    //    5    9:aload_0         
    //    6   10:aload_1         
    //    7   11:putfield        #20  <Field Logger m_Log>
        m_parentComponent = parent;
    //    8   14:aload_0         
    //    9   15:aload_2         
    //   10   16:putfield        #22  <Field Component m_parentComponent>
    //   11   19:return          
    }

    public boolean save(StringBuffer buf)
    {
        if(buf != null)
    //*   0    0:aload_1         
    //*   1    1:ifnull          266
        {
            JFileChooser fileChooser;
            if(m_lastvisitedDirectory == null)
    //*   2    4:aload_0         
    //*   3    5:getfield        #18  <Field String m_lastvisitedDirectory>
    //*   4    8:ifnonnull       34
                fileChooser = new JFileChooser(new File(System.getProperty("user.dir")));
    //    5   11:new             #32  <Class JFileChooser>
    //    6   14:dup             
    //    7   15:new             #34  <Class File>
    //    8   18:dup             
    //    9   19:ldc1            #36  <String "user.dir">
    //   10   21:invokestatic    #42  <Method String System.getProperty(String)>
    //   11   24:invokespecial   #45  <Method void File(String)>
    //   12   27:invokespecial   #48  <Method void JFileChooser(File)>
    //   13   30:astore_2        
            else
    //*  14   31:goto            46
                fileChooser = new JFileChooser(m_lastvisitedDirectory);
    //   15   34:new             #32  <Class JFileChooser>
    //   16   37:dup             
    //   17   38:aload_0         
    //   18   39:getfield        #18  <Field String m_lastvisitedDirectory>
    //   19   42:invokespecial   #49  <Method void JFileChooser(String)>
    //   20   45:astore_2        
            fileChooser.setFileSelectionMode(0);
    //   21   46:aload_2         
    //   22   47:iconst_0        
    //   23   48:invokevirtual   #53  <Method void JFileChooser.setFileSelectionMode(int)>
            int returnVal = fileChooser.showSaveDialog(m_parentComponent);
    //   24   51:aload_2         
    //   25   52:aload_0         
    //   26   53:getfield        #22  <Field Component m_parentComponent>
    //   27   56:invokevirtual   #57  <Method int JFileChooser.showSaveDialog(Component)>
    //   28   59:istore_3        
            if(returnVal == 0)
    //*  29   60:iload_3         
    //*  30   61:ifne            264
            {
                File sFile = fileChooser.getSelectedFile();
    //   31   64:aload_2         
    //   32   65:invokevirtual   #61  <Method File JFileChooser.getSelectedFile()>
    //   33   68:astore          4
                m_lastvisitedDirectory = sFile.getPath();
    //   34   70:aload_0         
    //   35   71:aload           4
    //   36   73:invokevirtual   #65  <Method String File.getPath()>
    //   37   76:putfield        #18  <Field String m_lastvisitedDirectory>
                if(sFile.exists())
    //*  38   79:aload           4
    //*  39   81:invokevirtual   #69  <Method boolean File.exists()>
    //*  40   84:ifeq            252
                {
                    Object options[] = new String[4];
    //   41   87:iconst_4        
    //   42   88:anewarray       String[]
    //   43   91:astore          5
                    options[0] = "Append";
    //   44   93:aload           5
    //   45   95:iconst_0        
    //   46   96:ldc1            #73  <String "Append">
    //   47   98:aastore         
                    options[1] = "Overwrite";
    //   48   99:aload           5
    //   49  101:iconst_1        
    //   50  102:ldc1            #75  <String "Overwrite">
    //   51  104:aastore         
                    options[2] = "Choose new name";
    //   52  105:aload           5
    //   53  107:iconst_2        
    //   54  108:ldc1            #77  <String "Choose new name">
    //   55  110:aastore         
                    options[3] = "Cancel";
    //   56  111:aload           5
    //   57  113:iconst_3        
    //   58  114:ldc1            #79  <String "Cancel">
    //   59  116:aastore         
                    JOptionPane jop = new JOptionPane("File exists", 3, 1, null, options);
    //   60  117:new             #81  <Class JOptionPane>
    //   61  120:dup             
    //   62  121:ldc1            #83  <String "File exists">
    //   63  123:iconst_3        
    //   64  124:iconst_1        
    //   65  125:aconst_null     
    //   66  126:aload           5
    //   67  128:invokespecial   #86  <Method void JOptionPane(Object, int, int, javax.swing.Icon, Object[])>
    //   68  131:astore          6
                    JDialog dialog = jop.createDialog(m_parentComponent, "File query");
    //   69  133:aload           6
    //   70  135:aload_0         
    //   71  136:getfield        #22  <Field Component m_parentComponent>
    //   72  139:ldc1            #88  <String "File query">
    //   73  141:invokevirtual   #92  <Method JDialog JOptionPane.createDialog(Component, String)>
    //   74  144:astore          7
                    dialog.setVisible(true);
    //   75  146:aload           7
    //   76  148:iconst_1        
    //   77  149:invokevirtual   #98  <Method void JDialog.setVisible(boolean)>
                    Object selectedValue = jop.getValue();
    //   78  152:aload           6
    //   79  154:invokevirtual   #102 <Method Object JOptionPane.getValue()>
    //   80  157:astore          8
                    if(selectedValue != null)
    //*  81  159:aload           8
    //*  82  161:ifnull          266
                    {
                        for(int i = 0; i < 4; i++)
    //*  83  164:iconst_0        
    //*  84  165:istore          9
    //*  85  167:goto            243
                            if(options[i].equals(selectedValue))
    //*  86  170:aload           5
    //*  87  172:iload           9
    //*  88  174:aaload          
    //*  89  175:aload           8
    //*  90  177:invokevirtual   #106 <Method boolean Object.equals(Object)>
    //*  91  180:ifeq            240
                                switch(i)
    //*  92  183:iload           9
                                {
    //*  93  185:tableswitch     0 3: default 240
    //                   0 216
    //                   1 225
    //                   2 234
    //                   3 240
                                case 0: // '\0'
                                    return saveOverwriteAppend(buf, sFile, true);
    //   94  216:aload_0         
    //   95  217:aload_1         
    //   96  218:aload           4
    //   97  220:iconst_1        
    //   98  221:invokespecial   #110 <Method boolean saveOverwriteAppend(StringBuffer, File, boolean)>
    //   99  224:ireturn         

                                case 1: // '\001'
                                    return saveOverwriteAppend(buf, sFile, false);
    //  100  225:aload_0         
    //  101  226:aload_1         
    //  102  227:aload           4
    //  103  229:iconst_0        
    //  104  230:invokespecial   #110 <Method boolean saveOverwriteAppend(StringBuffer, File, boolean)>
    //  105  233:ireturn         

                                case 2: // '\002'
                                    return save(buf);
    //  106  234:aload_0         
    //  107  235:aload_1         
    //  108  236:invokevirtual   #112 <Method boolean save(StringBuffer)>
    //  109  239:ireturn         
                                }

    //  110  240:iinc            9  1
    //  111  243:iload           9
    //  112  245:iconst_4        
    //  113  246:icmplt          170
                    }
                } else
    //* 114  249:goto            266
                {
                    saveOverwriteAppend(buf, sFile, false);
    //  115  252:aload_0         
    //  116  253:aload_1         
    //  117  254:aload           4
    //  118  256:iconst_0        
    //  119  257:invokespecial   #110 <Method boolean saveOverwriteAppend(StringBuffer, File, boolean)>
    //  120  260:pop             
                }
            } else
    //* 121  261:goto            266
            {
                return false;
    //  122  264:iconst_0        
    //  123  265:ireturn         
            }
        }
        return false;
    //  124  266:iconst_0        
    //  125  267:ireturn         
    }

    private boolean saveOverwriteAppend(StringBuffer buf, File sFile, boolean append)
    {
        try
        {
            String path = sFile.getPath();
    //    0    0:aload_2         
    //    1    1:invokevirtual   #65  <Method String File.getPath()>
    //    2    4:astore          4
            if(m_Log != null)
    //*   3    6:aload_0         
    //*   4    7:getfield        #20  <Field Logger m_Log>
    //*   5   10:ifnull          42
                if(append)
    //*   6   13:iload_3         
    //*   7   14:ifeq            31
                    m_Log.statusMessage("Appending to file...");
    //    8   17:aload_0         
    //    9   18:getfield        #20  <Field Logger m_Log>
    //   10   21:ldc1            #131 <String "Appending to file...">
    //   11   23:invokeinterface #136 <Method void Logger.statusMessage(String)>
                else
    //*  12   28:goto            42
                    m_Log.statusMessage("Saving to file...");
    //   13   31:aload_0         
    //   14   32:getfield        #20  <Field Logger m_Log>
    //   15   35:ldc1            #138 <String "Saving to file...">
    //   16   37:invokeinterface #136 <Method void Logger.statusMessage(String)>
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path, append)));
    //   17   42:new             #140 <Class PrintWriter>
    //   18   45:dup             
    //   19   46:new             #142 <Class BufferedWriter>
    //   20   49:dup             
    //   21   50:new             #144 <Class FileWriter>
    //   22   53:dup             
    //   23   54:aload           4
    //   24   56:iload_3         
    //   25   57:invokespecial   #147 <Method void FileWriter(String, boolean)>
    //   26   60:invokespecial   #150 <Method void BufferedWriter(java.io.Writer)>
    //   27   63:invokespecial   #151 <Method void PrintWriter(java.io.Writer)>
    //   28   66:astore          5
            out.write(buf.toString(), 0, buf.toString().length());
    //   29   68:aload           5
    //   30   70:aload_1         
    //   31   71:invokevirtual   #156 <Method String StringBuffer.toString()>
    //   32   74:iconst_0        
    //   33   75:aload_1         
    //   34   76:invokevirtual   #156 <Method String StringBuffer.toString()>
    //   35   79:invokevirtual   #160 <Method int String.length()>
    //   36   82:invokevirtual   #164 <Method void PrintWriter.write(String, int, int)>
            out.close();
    //   37   85:aload           5
    //   38   87:invokevirtual   #167 <Method void PrintWriter.close()>
            if(m_Log != null)
    //*  39   90:aload_0         
    //*  40   91:getfield        #20  <Field Logger m_Log>
    //*  41   94:ifnull          141
                m_Log.statusMessage("OK");
    //   42   97:aload_0         
    //   43   98:getfield        #20  <Field Logger m_Log>
    //   44  101:ldc1            #169 <String "OK">
    //   45  103:invokeinterface #136 <Method void Logger.statusMessage(String)>
        }
    //*  46  108:goto            141
        catch(Exception ex)
    //*  47  111:astore          4
        {
            ex.printStackTrace();
    //   48  113:aload           4
    //   49  115:invokevirtual   #174 <Method void Exception.printStackTrace()>
            if(m_Log != null)
    //*  50  118:aload_0         
    //*  51  119:getfield        #20  <Field Logger m_Log>
    //*  52  122:ifnull          139
                m_Log.logMessage(ex.getMessage());
    //   53  125:aload_0         
    //   54  126:getfield        #20  <Field Logger m_Log>
    //   55  129:aload           4
    //   56  131:invokevirtual   #177 <Method String Exception.getMessage()>
    //   57  134:invokeinterface #180 <Method void Logger.logMessage(String)>
            return false;
    //   58  139:iconst_0        
    //   59  140:ireturn         
        }
        return true;
    //   60  141:iconst_1        
    //   61  142:ireturn         
    }

    public static void main(String args[])
    {
        try
        {
            final JFrame jf = new JFrame("SaveBuffer test");
    //    0    0:new             #191 <Class JFrame>
    //    1    3:dup             
    //    2    4:ldc1            #193 <String "SaveBuffer test">
    //    3    6:invokespecial   #194 <Method void JFrame(String)>
    //    4    9:astore_1        
            jf.getContentPane().setLayout(new BorderLayout());
    //    5   10:aload_1         
    //    6   11:invokevirtual   #198 <Method Container JFrame.getContentPane()>
    //    7   14:new             #200 <Class BorderLayout>
    //    8   17:dup             
    //    9   18:invokespecial   #201 <Method void BorderLayout()>
    //   10   21:invokevirtual   #207 <Method void Container.setLayout(java.awt.LayoutManager)>
            LogPanel lp = new LogPanel();
    //   11   24:new             #209 <Class LogPanel>
    //   12   27:dup             
    //   13   28:invokespecial   #210 <Method void LogPanel()>
    //   14   31:astore_2        
            JButton jb = new JButton("Save");
    //   15   32:new             #212 <Class JButton>
    //   16   35:dup             
    //   17   36:ldc1            #214 <String "Save">
    //   18   38:invokespecial   #215 <Method void JButton(String)>
    //   19   41:astore_3        
            jf.getContentPane().add(jb, "South");
    //   20   42:aload_1         
    //   21   43:invokevirtual   #198 <Method Container JFrame.getContentPane()>
    //   22   46:aload_3         
    //   23   47:ldc1            #217 <String "South">
    //   24   49:invokevirtual   #221 <Method void Container.add(Component, Object)>
            jf.getContentPane().add(lp, "Center");
    //   25   52:aload_1         
    //   26   53:invokevirtual   #198 <Method Container JFrame.getContentPane()>
    //   27   56:aload_2         
    //   28   57:ldc1            #223 <String "Center">
    //   29   59:invokevirtual   #221 <Method void Container.add(Component, Object)>
            final SaveBuffer svb = new SaveBuffer(lp, jf);
    //   30   62:new             #2   <Class SaveBuffer>
    //   31   65:dup             
    //   32   66:aload_2         
    //   33   67:aload_1         
    //   34   68:invokespecial   #225 <Method void SaveBuffer(Logger, Component)>
    //   35   71:astore          4
            jb.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e)
                {
                    svb.save(new StringBuffer("A bit of test text"));
                //    0    0:aload_0         
                //    1    1:getfield        #13  <Field SaveBuffer val$svb>
                //    2    4:new             #24  <Class StringBuffer>
                //    3    7:dup             
                //    4    8:ldc1            #26  <String "A bit of test text">
                //    5   10:invokespecial   #29  <Method void StringBuffer(String)>
                //    6   13:invokevirtual   #35  <Method boolean SaveBuffer.save(StringBuffer)>
                //    7   16:pop             
                //    8   17:return          
                }

                private final SaveBuffer val$svb;

            
            {
                svb = savebuffer;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field SaveBuffer val$svb>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
            }
);
    //   36   73:aload_3         
    //   37   74:new             #227 <Class SaveBuffer$1>
    //   38   77:dup             
    //   39   78:aload           4
    //   40   80:invokespecial   #230 <Method void SaveBuffer$1(SaveBuffer)>
    //   41   83:invokevirtual   #234 <Method void JButton.addActionListener(ActionListener)>
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
    //   42   86:aload_1         
    //   43   87:new             #236 <Class SaveBuffer$2>
    //   44   90:dup             
    //   45   91:aload_1         
    //   46   92:invokespecial   #239 <Method void SaveBuffer$2(JFrame)>
    //   47   95:invokevirtual   #243 <Method void JFrame.addWindowListener(java.awt.event.WindowListener)>
            jf.pack();
    //   48   98:aload_1         
    //   49   99:invokevirtual   #246 <Method void JFrame.pack()>
            jf.setVisible(true);
    //   50  102:aload_1         
    //   51  103:iconst_1        
    //   52  104:invokevirtual   #247 <Method void JFrame.setVisible(boolean)>
        }
    //*  53  107:goto            125
        catch(Exception ex)
    //*  54  110:astore_1        
        {
            ex.printStackTrace();
    //   55  111:aload_1         
    //   56  112:invokevirtual   #174 <Method void Exception.printStackTrace()>
            System.err.println(ex.getMessage());
    //   57  115:getstatic       #251 <Field PrintStream System.err>
    //   58  118:aload_1         
    //   59  119:invokevirtual   #177 <Method String Exception.getMessage()>
    //   60  122:invokevirtual   #256 <Method void PrintStream.println(String)>
        }
    //   61  125:return          
    }

    private Logger m_Log;
    private Component m_parentComponent;
    private String m_lastvisitedDirectory;
}
