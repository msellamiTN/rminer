// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   ComponentHelper.java

package rm.gui;

import java.awt.Component;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

// Referenced classes of package rm.gui:
//            Loader

public class ComponentHelper
{

    public ComponentHelper()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #22  <Method void Object()>
    //    2    4:return          
    }

    public static ImageIcon getImageIcon(String dir, String filename)
    {
        ImageIcon result = null;
    //    0    0:aconst_null     
    //    1    1:astore_3        
        java.net.URL url = Loader.getURL(dir, filename);
    //    2    2:aload_0         
    //    3    3:aload_1         
    //    4    4:invokestatic    #32  <Method java.net.URL Loader.getURL(String, String)>
    //    5    7:astore_2        
        if(url == null)
    //*   6    8:aload_2         
    //*   7    9:ifnonnull       48
        {
            for(int i = 0; i < IMAGES.length; i++)
    //*   8   12:iconst_0        
    //*   9   13:istore          4
    //*  10   15:goto            39
            {
                url = Loader.getURL(IMAGES[i], filename);
    //   11   18:getstatic       #17  <Field String[] IMAGES>
    //   12   21:iload           4
    //   13   23:aaload          
    //   14   24:aload_1         
    //   15   25:invokestatic    #32  <Method java.net.URL Loader.getURL(String, String)>
    //   16   28:astore_2        
                if(url != null)
    //*  17   29:aload_2         
    //*  18   30:ifnull          36
                    break;
    //   19   33:goto            48
            }

    //   20   36:iinc            4  1
    //   21   39:iload           4
    //   22   41:getstatic       #17  <Field String[] IMAGES>
    //   23   44:arraylength     
    //   24   45:icmplt          18
        }
        if(url != null)
    //*  25   48:aload_2         
    //*  26   49:ifnull          61
            result = new ImageIcon(url);
    //   27   52:new             #34  <Class ImageIcon>
    //   28   55:dup             
    //   29   56:aload_2         
    //   30   57:invokespecial   #37  <Method void ImageIcon(java.net.URL)>
    //   31   60:astore_3        
        return result;
    //   32   61:aload_3         
    //   33   62:areturn         
    }

    public static ImageIcon getImageIcon(String filename)
    {
        return getImageIcon("", filename);
    //    0    0:ldc1            #49  <String "">
    //    1    2:aload_0         
    //    2    3:invokestatic    #51  <Method ImageIcon getImageIcon(String, String)>
    //    3    6:areturn         
    }

    public static Image getImage(String dir, String filename)
    {
        Image result = null;
    //    0    0:aconst_null     
    //    1    1:astore_3        
        ImageIcon img = getImageIcon(dir, filename);
    //    2    2:aload_0         
    //    3    3:aload_1         
    //    4    4:invokestatic    #51  <Method ImageIcon getImageIcon(String, String)>
    //    5    7:astore_2        
        if(img != null)
    //*   6    8:aload_2         
    //*   7    9:ifnull          17
            result = img.getImage();
    //    8   12:aload_2         
    //    9   13:invokevirtual   #56  <Method Image ImageIcon.getImage()>
    //   10   16:astore_3        
        return result;
    //   11   17:aload_3         
    //   12   18:areturn         
    }

    public static Image getImage(String filename)
    {
        Image result = null;
    //    0    0:aconst_null     
    //    1    1:astore_2        
        ImageIcon img = getImageIcon(filename);
    //    2    2:aload_0         
    //    3    3:invokestatic    #61  <Method ImageIcon getImageIcon(String)>
    //    4    6:astore_1        
        if(img != null)
    //*   5    7:aload_1         
    //*   6    8:ifnull          16
            result = img.getImage();
    //    7   11:aload_1         
    //    8   12:invokevirtual   #56  <Method Image ImageIcon.getImage()>
    //    9   15:astore_2        
        return result;
    //   10   16:aload_2         
    //   11   17:areturn         
    }

    public static int showMessageBox(Component parent, String title, String msg, int buttons, int messageType)
    {
        String icon;
        switch(messageType)
    //*   0    0:iload           4
        {
    //*   1    2:tableswitch     0 3: default 60
    //                   0 32
    //                   1 39
    //                   2 46
    //                   3 53
        case 0: // '\0'
            icon = "weka/gui/images/error.gif";
    //    2   32:ldc1            #65  <String "weka/gui/images/error.gif">
    //    3   34:astore          5
            break;

    //*   4   36:goto            64
        case 1: // '\001'
            icon = "weka/gui/images/information.gif";
    //    5   39:ldc1            #67  <String "weka/gui/images/information.gif">
    //    6   41:astore          5
            break;

    //*   7   43:goto            64
        case 2: // '\002'
            icon = "weka/gui/images/information.gif";
    //    8   46:ldc1            #67  <String "weka/gui/images/information.gif">
    //    9   48:astore          5
            break;

    //*  10   50:goto            64
        case 3: // '\003'
            icon = "weka/gui/images/question.gif";
    //   11   53:ldc1            #69  <String "weka/gui/images/question.gif">
    //   12   55:astore          5
            break;

    //*  13   57:goto            64
        default:
            icon = "weka/gui/images/information.gif";
    //   14   60:ldc1            #67  <String "weka/gui/images/information.gif">
    //   15   62:astore          5
            break;
        }
        return JOptionPane.showConfirmDialog(parent, msg, title, buttons, messageType, getImageIcon(icon));
    //   16   64:aload_0         
    //   17   65:aload_2         
    //   18   66:aload_1         
    //   19   67:iload_3         
    //   20   68:iload           4
    //   21   70:aload           5
    //   22   72:invokestatic    #61  <Method ImageIcon getImageIcon(String)>
    //   23   75:invokestatic    #75  <Method int JOptionPane.showConfirmDialog(Component, Object, String, int, int, javax.swing.Icon)>
    //   24   78:ireturn         
    }

    public static String showInputBox(Component parent, String title, String msg, Object initialValue)
    {
        if(title == null)
    //*   0    0:aload_1         
    //*   1    1:ifnonnull       7
            title = "Input...";
    //    2    4:ldc1            #86  <String "Input...">
    //    3    6:astore_1        
        Object result = JOptionPane.showInputDialog(parent, msg, title, 3, getImageIcon("question.gif"), null, initialValue);
    //    4    7:aload_0         
    //    5    8:aload_2         
    //    6    9:aload_1         
    //    7   10:iconst_3        
    //    8   11:ldc1            #88  <String "question.gif">
    //    9   13:invokestatic    #61  <Method ImageIcon getImageIcon(String)>
    //   10   16:aconst_null     
    //   11   17:aload_3         
    //   12   18:invokestatic    #92  <Method Object JOptionPane.showInputDialog(Component, Object, String, int, javax.swing.Icon, Object[], Object)>
    //   13   21:astore          4
        if(result != null)
    //*  14   23:aload           4
    //*  15   25:ifnull          34
            return result.toString();
    //   16   28:aload           4
    //   17   30:invokevirtual   #96  <Method String Object.toString()>
    //   18   33:areturn         
        else
            return null;
    //   19   34:aconst_null     
    //   20   35:areturn         
    }

    public static final String IMAGES[] = {
        "weka/gui/", "weka/gui/images/"
    };

    static 
    {
    //    0    0:iconst_2        
    //    1    1:anewarray       String[]
    //    2    4:dup             
    //    3    5:iconst_0        
    //    4    6:ldc1            #13  <String "weka/gui/">
    //    5    8:aastore         
    //    6    9:dup             
    //    7   10:iconst_1        
    //    8   11:ldc1            #15  <String "weka/gui/images/">
    //    9   13:aastore         
    //   10   14:putstatic       #17  <Field String[] IMAGES>
    //*  11   17:return          
    }
}
