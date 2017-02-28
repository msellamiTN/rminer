// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   LookAndFeel.java

package rm.gui;

import java.io.PrintStream;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import rm.core.Utils;

public class LookAndFeel
{

    public LookAndFeel()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #79  <Method void Object()>
    //    2    4:return          
    }

    public static boolean setLookAndFeel(String classname)
    {
        boolean result;
        try
        {
            UIManager.setLookAndFeel(classname);
    //    0    0:aload_0         
    //    1    1:invokestatic    #87  <Method void UIManager.setLookAndFeel(String)>
            result = true;
    //    2    4:iconst_1        
    //    3    5:istore_1        
        }
    //*   4    6:goto            16
        catch(Exception e)
    //*   5    9:astore_2        
        {
            e.printStackTrace();
    //    6   10:aload_2         
    //    7   11:invokevirtual   #90  <Method void Exception.printStackTrace()>
            result = false;
    //    8   14:iconst_0        
    //    9   15:istore_1        
        }
        return result;
    //   10   16:iload_1         
    //   11   17:ireturn         
    }

    public static boolean setLookAndFeel()
    {
        String classname = LOOKANDFEEL_PROPERTIES.getProperty("Theme", "");
    //    0    0:getstatic       #23  <Field Properties LOOKANDFEEL_PROPERTIES>
    //    1    3:ldc1            #97  <String "Theme">
    //    2    5:ldc1            #99  <String "">
    //    3    7:invokevirtual   #102 <Method String Properties.getProperty(String, String)>
    //    4   10:astore_0        
        if(classname.equals(""))
    //*   5   11:aload_0         
    //*   6   12:ldc1            #99  <String "">
    //*   7   14:invokevirtual   #108 <Method boolean String.equals(Object)>
    //*   8   17:ifeq            39
        {
            if(System.getProperty("os.name").equalsIgnoreCase("linux"))
    //*   9   20:ldc1            #110 <String "os.name">
    //*  10   22:invokestatic    #111 <Method String System.getProperty(String)>
    //*  11   25:ldc1            #113 <String "linux">
    //*  12   27:invokevirtual   #116 <Method boolean String.equalsIgnoreCase(String)>
    //*  13   30:ifeq            35
                return true;
    //   14   33:iconst_1        
    //   15   34:ireturn         
            classname = getSystemLookAndFeel();
    //   16   35:invokestatic    #119 <Method String getSystemLookAndFeel()>
    //   17   38:astore_0        
        }
        return setLookAndFeel(classname);
    //   18   39:aload_0         
    //   19   40:invokestatic    #121 <Method boolean setLookAndFeel(String)>
    //   20   43:ireturn         
    }

    public static String getSystemLookAndFeel()
    {
        return UIManager.getSystemLookAndFeelClassName();
    //    0    0:invokestatic    #124 <Method String UIManager.getSystemLookAndFeelClassName()>
    //    1    3:areturn         
    }

    public static String[] getInstalledLookAndFeels()
    {
        javax.swing.UIManager.LookAndFeelInfo laf[] = UIManager.getInstalledLookAndFeels();
    //    0    0:invokestatic    #129 <Method javax.swing.UIManager$LookAndFeelInfo[] UIManager.getInstalledLookAndFeels()>
    //    1    3:astore_1        
        String result[] = new String[laf.length];
    //    2    4:aload_1         
    //    3    5:arraylength     
    //    4    6:anewarray       String[]
    //    5    9:astore_0        
        for(int i = 0; i < laf.length; i++)
    //*   6   10:iconst_0        
    //*   7   11:istore_2        
    //*   8   12:goto            27
            result[i] = laf[i].getClassName();
    //    9   15:aload_0         
    //   10   16:iload_2         
    //   11   17:aload_1         
    //   12   18:iload_2         
    //   13   19:aaload          
    //   14   20:invokevirtual   #134 <Method String javax.swing.UIManager$LookAndFeelInfo.getClassName()>
    //   15   23:aastore         

    //   16   24:iinc            2  1
    //   17   27:iload_2         
    //   18   28:aload_1         
    //   19   29:arraylength     
    //   20   30:icmplt          15
        return result;
    //   21   33:aload_0         
    //   22   34:areturn         
    }

    public static void main(String args[])
    {
        System.out.println("\nInstalled Look and Feel themes:");
    //    0    0:getstatic       #145 <Field PrintStream System.out>
    //    1    3:ldc1            #147 <String "\nInstalled Look and Feel themes:">
    //    2    5:invokevirtual   #152 <Method void PrintStream.println(String)>
        String list[] = getInstalledLookAndFeels();
    //    3    8:invokestatic    #154 <Method String[] getInstalledLookAndFeels()>
    //    4   11:astore_1        
        for(int i = 0; i < list.length; i++)
    //*   5   12:iconst_0        
    //*   6   13:istore_2        
    //*   7   14:goto            53
            System.out.println((new StringBuilder(String.valueOf(i + 1))).append(". ").append(list[i]).toString());
    //    8   17:getstatic       #145 <Field PrintStream System.out>
    //    9   20:new             #25  <Class StringBuilder>
    //   10   23:dup             
    //   11   24:iload_2         
    //   12   25:iconst_1        
    //   13   26:iadd            
    //   14   27:invokestatic    #158 <Method String String.valueOf(int)>
    //   15   30:invokespecial   #31  <Method void StringBuilder(String)>
    //   16   33:ldc1            #160 <String ". ">
    //   17   35:invokevirtual   #35  <Method StringBuilder StringBuilder.append(String)>
    //   18   38:aload_1         
    //   19   39:iload_2         
    //   20   40:aaload          
    //   21   41:invokevirtual   #35  <Method StringBuilder StringBuilder.append(String)>
    //   22   44:invokevirtual   #63  <Method String StringBuilder.toString()>
    //   23   47:invokevirtual   #152 <Method void PrintStream.println(String)>

    //   24   50:iinc            2  1
    //   25   53:iload_2         
    //   26   54:aload_1         
    //   27   55:arraylength     
    //   28   56:icmplt          17
        System.out.println((new StringBuilder("\nNote: a theme can be set in '")).append(PROPERTY_FILE).append("'.").toString());
    //   29   59:getstatic       #145 <Field PrintStream System.out>
    //   30   62:new             #25  <Class StringBuilder>
    //   31   65:dup             
    //   32   66:ldc1            #162 <String "\nNote: a theme can be set in '">
    //   33   68:invokespecial   #31  <Method void StringBuilder(String)>
    //   34   71:getstatic       #15  <Field String PROPERTY_FILE>
    //   35   74:invokevirtual   #35  <Method StringBuilder StringBuilder.append(String)>
    //   36   77:ldc1            #164 <String "'.">
    //   37   79:invokevirtual   #35  <Method StringBuilder StringBuilder.append(String)>
    //   38   82:invokevirtual   #63  <Method String StringBuilder.toString()>
    //   39   85:invokevirtual   #152 <Method void PrintStream.println(String)>
    //   40   88:return          
    }

    public static String PROPERTY_FILE;
    protected static Properties LOOKANDFEEL_PROPERTIES;

    static 
    {
        PROPERTY_FILE = "weka/gui/LookAndFeel.props";
    //    0    0:ldc1            #13  <String "weka/gui/LookAndFeel.props">
    //    1    2:putstatic       #15  <Field String PROPERTY_FILE>
        try
        {
            LOOKANDFEEL_PROPERTIES = Utils.readProperties(PROPERTY_FILE);
    //    2    5:getstatic       #15  <Field String PROPERTY_FILE>
    //    3    8:invokestatic    #21  <Method Properties Utils.readProperties(String)>
    //    4   11:putstatic       #23  <Field Properties LOOKANDFEEL_PROPERTIES>
        }
    //*   5   14:goto            79
        catch(Exception ex)
    //*   6   17:astore_0        
        {
            JOptionPane.showMessageDialog(null, (new StringBuilder("LookAndFeel: Could not read a LookAndFeel configuration file.\nAn example file is included in the Weka distribution.\nThis file should be named \"")).append(PROPERTY_FILE).append("\"  and\n").append("should be placed either in your user home (which is set\n").append("to \"").append(System.getProperties().getProperty("user.home")).append("\")\n").append("or the directory that java was started from\n").toString(), "LookAndFeel", 0);
    //    7   18:aconst_null     
    //    8   19:new             #25  <Class StringBuilder>
    //    9   22:dup             
    //   10   23:ldc1            #27  <String "LookAndFeel: Could not read a LookAndFeel configuration file.\nAn example file is included in the Weka distribution.\nThis file should be named \"">
    //   11   25:invokespecial   #31  <Method void StringBuilder(String)>
    //   12   28:getstatic       #15  <Field String PROPERTY_FILE>
    //   13   31:invokevirtual   #35  <Method StringBuilder StringBuilder.append(String)>
    //   14   34:ldc1            #37  <String "\"  and\n">
    //   15   36:invokevirtual   #35  <Method StringBuilder StringBuilder.append(String)>
    //   16   39:ldc1            #39  <String "should be placed either in your user home (which is set\n">
    //   17   41:invokevirtual   #35  <Method StringBuilder StringBuilder.append(String)>
    //   18   44:ldc1            #41  <String "to \"">
    //   19   46:invokevirtual   #35  <Method StringBuilder StringBuilder.append(String)>
    //   20   49:invokestatic    #47  <Method Properties System.getProperties()>
    //   21   52:ldc1            #49  <String "user.home">
    //   22   54:invokevirtual   #55  <Method String Properties.getProperty(String)>
    //   23   57:invokevirtual   #35  <Method StringBuilder StringBuilder.append(String)>
    //   24   60:ldc1            #57  <String "\")\n">
    //   25   62:invokevirtual   #35  <Method StringBuilder StringBuilder.append(String)>
    //   26   65:ldc1            #59  <String "or the directory that java was started from\n">
    //   27   67:invokevirtual   #35  <Method StringBuilder StringBuilder.append(String)>
    //   28   70:invokevirtual   #63  <Method String StringBuilder.toString()>
    //   29   73:ldc1            #65  <String "LookAndFeel">
    //   30   75:iconst_0        
    //   31   76:invokestatic    #71  <Method void JOptionPane.showMessageDialog(java.awt.Component, Object, String, int)>
        }
    //*  32   79:return          
    }
}
