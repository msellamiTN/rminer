// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   BeanVisual.java

package rm.gui.beans;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.*;
import javax.swing.*;

public class BeanVisual extends JPanel
{

    public BeanVisual(String visualName, String iconPath, String animatedIconPath)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #43  <Method void JPanel()>
        m_stationary = true;
    //    2    4:aload_0         
    //    3    5:iconst_1        
    //    4    6:putfield        #45  <Field boolean m_stationary>
        m_pcs = new PropertyChangeSupport(this);
    //    5    9:aload_0         
    //    6   10:new             #47  <Class PropertyChangeSupport>
    //    7   13:dup             
    //    8   14:aload_0         
    //    9   15:invokespecial   #50  <Method void PropertyChangeSupport(Object)>
    //   10   18:putfield        #52  <Field PropertyChangeSupport m_pcs>
        m_displayConnectors = false;
    //   11   21:aload_0         
    //   12   22:iconst_0        
    //   13   23:putfield        #54  <Field boolean m_displayConnectors>
        m_connectorColor = Color.blue;
    //   14   26:aload_0         
    //   15   27:getstatic       #59  <Field Color Color.blue>
    //   16   30:putfield        #61  <Field Color m_connectorColor>
        loadIcons(iconPath, animatedIconPath);
    //   17   33:aload_0         
    //   18   34:aload_2         
    //   19   35:aload_3         
    //   20   36:invokevirtual   #65  <Method boolean loadIcons(String, String)>
    //   21   39:pop             
        m_visualName = visualName;
    //   22   40:aload_0         
    //   23   41:aload_1         
    //   24   42:putfield        #67  <Field String m_visualName>
        m_visualLabel = new JLabel(m_icon);
    //   25   45:aload_0         
    //   26   46:new             #69  <Class JLabel>
    //   27   49:dup             
    //   28   50:aload_0         
    //   29   51:getfield        #71  <Field ImageIcon m_icon>
    //   30   54:invokespecial   #74  <Method void JLabel(javax.swing.Icon)>
    //   31   57:putfield        #76  <Field JLabel m_visualLabel>
        setLayout(new BorderLayout());
    //   32   60:aload_0         
    //   33   61:new             #78  <Class BorderLayout>
    //   34   64:dup             
    //   35   65:invokespecial   #79  <Method void BorderLayout()>
    //   36   68:invokevirtual   #83  <Method void setLayout(java.awt.LayoutManager)>
        add(m_visualLabel, "Center");
    //   37   71:aload_0         
    //   38   72:aload_0         
    //   39   73:getfield        #76  <Field JLabel m_visualLabel>
    //   40   76:ldc1            #85  <String "Center">
    //   41   78:invokevirtual   #89  <Method void add(java.awt.Component, Object)>
        Dimension d = m_visualLabel.getPreferredSize();
    //   42   81:aload_0         
    //   43   82:getfield        #76  <Field JLabel m_visualLabel>
    //   44   85:invokevirtual   #93  <Method Dimension JLabel.getPreferredSize()>
    //   45   88:astore          4
        Dimension d2 = new Dimension((int)d.getWidth() + 10, (int)d.getHeight() + 10);
    //   46   90:new             #95  <Class Dimension>
    //   47   93:dup             
    //   48   94:aload           4
    //   49   96:invokevirtual   #99  <Method double Dimension.getWidth()>
    //   50   99:d2i             
    //   51  100:bipush          10
    //   52  102:iadd            
    //   53  103:aload           4
    //   54  105:invokevirtual   #102 <Method double Dimension.getHeight()>
    //   55  108:d2i             
    //   56  109:bipush          10
    //   57  111:iadd            
    //   58  112:invokespecial   #105 <Method void Dimension(int, int)>
    //   59  115:astore          5
        setMinimumSize(d2);
    //   60  117:aload_0         
    //   61  118:aload           5
    //   62  120:invokevirtual   #109 <Method void setMinimumSize(Dimension)>
        setPreferredSize(d2);
    //   63  123:aload_0         
    //   64  124:aload           5
    //   65  126:invokevirtual   #112 <Method void setPreferredSize(Dimension)>
        setMaximumSize(d2);
    //   66  129:aload_0         
    //   67  130:aload           5
    //   68  132:invokevirtual   #115 <Method void setMaximumSize(Dimension)>
    //   69  135:return          
    }

    public void scale(int factor)
    {
        if(m_icon != null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #71  <Field ImageIcon m_icon>
    //*   2    4:ifnull          153
        {
            removeAll();
    //    3    7:aload_0         
    //    4    8:invokevirtual   #130 <Method void removeAll()>
            Image pic = m_icon.getImage();
    //    5   11:aload_0         
    //    6   12:getfield        #71  <Field ImageIcon m_icon>
    //    7   15:invokevirtual   #136 <Method Image ImageIcon.getImage()>
    //    8   18:astore_2        
            int width = m_icon.getIconWidth();
    //    9   19:aload_0         
    //   10   20:getfield        #71  <Field ImageIcon m_icon>
    //   11   23:invokevirtual   #140 <Method int ImageIcon.getIconWidth()>
    //   12   26:istore_3        
            int height = m_icon.getIconHeight();
    //   13   27:aload_0         
    //   14   28:getfield        #71  <Field ImageIcon m_icon>
    //   15   31:invokevirtual   #143 <Method int ImageIcon.getIconHeight()>
    //   16   34:istore          4
            int reduction = width / factor;
    //   17   36:iload_3         
    //   18   37:iload_1         
    //   19   38:idiv            
    //   20   39:istore          5
            width -= reduction;
    //   21   41:iload_3         
    //   22   42:iload           5
    //   23   44:isub            
    //   24   45:istore_3        
            height -= reduction;
    //   25   46:iload           4
    //   26   48:iload           5
    //   27   50:isub            
    //   28   51:istore          4
            pic = pic.getScaledInstance(width, height, 4);
    //   29   53:aload_2         
    //   30   54:iload_3         
    //   31   55:iload           4
    //   32   57:iconst_4        
    //   33   58:invokevirtual   #149 <Method Image Image.getScaledInstance(int, int, int)>
    //   34   61:astore_2        
            m_icon = new ImageIcon(pic);
    //   35   62:aload_0         
    //   36   63:new             #132 <Class ImageIcon>
    //   37   66:dup             
    //   38   67:aload_2         
    //   39   68:invokespecial   #152 <Method void ImageIcon(Image)>
    //   40   71:putfield        #71  <Field ImageIcon m_icon>
            m_visualLabel = new JLabel(m_icon);
    //   41   74:aload_0         
    //   42   75:new             #69  <Class JLabel>
    //   43   78:dup             
    //   44   79:aload_0         
    //   45   80:getfield        #71  <Field ImageIcon m_icon>
    //   46   83:invokespecial   #74  <Method void JLabel(javax.swing.Icon)>
    //   47   86:putfield        #76  <Field JLabel m_visualLabel>
            add(m_visualLabel, "Center");
    //   48   89:aload_0         
    //   49   90:aload_0         
    //   50   91:getfield        #76  <Field JLabel m_visualLabel>
    //   51   94:ldc1            #85  <String "Center">
    //   52   96:invokevirtual   #89  <Method void add(java.awt.Component, Object)>
            Dimension d = m_visualLabel.getPreferredSize();
    //   53   99:aload_0         
    //   54  100:getfield        #76  <Field JLabel m_visualLabel>
    //   55  103:invokevirtual   #93  <Method Dimension JLabel.getPreferredSize()>
    //   56  106:astore          6
            Dimension d2 = new Dimension((int)d.getWidth() + 10, (int)d.getHeight() + 10);
    //   57  108:new             #95  <Class Dimension>
    //   58  111:dup             
    //   59  112:aload           6
    //   60  114:invokevirtual   #99  <Method double Dimension.getWidth()>
    //   61  117:d2i             
    //   62  118:bipush          10
    //   63  120:iadd            
    //   64  121:aload           6
    //   65  123:invokevirtual   #102 <Method double Dimension.getHeight()>
    //   66  126:d2i             
    //   67  127:bipush          10
    //   68  129:iadd            
    //   69  130:invokespecial   #105 <Method void Dimension(int, int)>
    //   70  133:astore          7
            setMinimumSize(d2);
    //   71  135:aload_0         
    //   72  136:aload           7
    //   73  138:invokevirtual   #109 <Method void setMinimumSize(Dimension)>
            setPreferredSize(d2);
    //   74  141:aload_0         
    //   75  142:aload           7
    //   76  144:invokevirtual   #112 <Method void setPreferredSize(Dimension)>
            setMaximumSize(d2);
    //   77  147:aload_0         
    //   78  148:aload           7
    //   79  150:invokevirtual   #115 <Method void setMaximumSize(Dimension)>
        }
    //   80  153:return          
    }

    public boolean loadIcons(String iconPath, String animatedIconPath)
    {
        boolean success = true;
    //    0    0:iconst_1        
    //    1    1:istore_3        
        java.net.URL imageURL = getClass().getClassLoader().getResource(iconPath);
    //    2    2:aload_0         
    //    3    3:invokevirtual   #164 <Method Class Object.getClass()>
    //    4    6:invokevirtual   #170 <Method ClassLoader Class.getClassLoader()>
    //    5    9:aload_1         
    //    6   10:invokevirtual   #176 <Method java.net.URL ClassLoader.getResource(String)>
    //    7   13:astore          4
        if(imageURL != null)
    //*   8   15:aload           4
    //*   9   17:ifnull          61
        {
            Image pic = Toolkit.getDefaultToolkit().getImage(imageURL);
    //   10   20:invokestatic    #182 <Method Toolkit Toolkit.getDefaultToolkit()>
    //   11   23:aload           4
    //   12   25:invokevirtual   #185 <Method Image Toolkit.getImage(java.net.URL)>
    //   13   28:astore          5
            m_icon = new ImageIcon(pic);
    //   14   30:aload_0         
    //   15   31:new             #132 <Class ImageIcon>
    //   16   34:dup             
    //   17   35:aload           5
    //   18   37:invokespecial   #152 <Method void ImageIcon(Image)>
    //   19   40:putfield        #71  <Field ImageIcon m_icon>
            if(m_visualLabel != null)
    //*  20   43:aload_0         
    //*  21   44:getfield        #76  <Field JLabel m_visualLabel>
    //*  22   47:ifnull          61
                m_visualLabel.setIcon(m_icon);
    //   23   50:aload_0         
    //   24   51:getfield        #76  <Field JLabel m_visualLabel>
    //   25   54:aload_0         
    //   26   55:getfield        #71  <Field ImageIcon m_icon>
    //   27   58:invokevirtual   #188 <Method void JLabel.setIcon(javax.swing.Icon)>
        }
        imageURL = getClass().getClassLoader().getResource(animatedIconPath);
    //   28   61:aload_0         
    //   29   62:invokevirtual   #164 <Method Class Object.getClass()>
    //   30   65:invokevirtual   #170 <Method ClassLoader Class.getClassLoader()>
    //   31   68:aload_2         
    //   32   69:invokevirtual   #176 <Method java.net.URL ClassLoader.getResource(String)>
    //   33   72:astore          4
        if(imageURL == null)
    //*  34   74:aload           4
    //*  35   76:ifnonnull       84
        {
            success = false;
    //   36   79:iconst_0        
    //   37   80:istore_3        
        } else
    //*  38   81:goto            107
        {
            Image pic2 = Toolkit.getDefaultToolkit().getImage(imageURL);
    //   39   84:invokestatic    #182 <Method Toolkit Toolkit.getDefaultToolkit()>
    //   40   87:aload           4
    //   41   89:invokevirtual   #185 <Method Image Toolkit.getImage(java.net.URL)>
    //   42   92:astore          5
            m_animatedIcon = new ImageIcon(pic2);
    //   43   94:aload_0         
    //   44   95:new             #132 <Class ImageIcon>
    //   45   98:dup             
    //   46   99:aload           5
    //   47  101:invokespecial   #152 <Method void ImageIcon(Image)>
    //   48  104:putfield        #190 <Field ImageIcon m_animatedIcon>
        }
        m_iconPath = iconPath;
    //   49  107:aload_0         
    //   50  108:aload_1         
    //   51  109:putfield        #192 <Field String m_iconPath>
        m_animatedIconPath = animatedIconPath;
    //   52  112:aload_0         
    //   53  113:aload_2         
    //   54  114:putfield        #194 <Field String m_animatedIconPath>
        return success;
    //   55  117:iload_3         
    //   56  118:ireturn         
    }

    public void setText(String text)
    {
        m_visualName = text;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #67  <Field String m_visualName>
        m_pcs.firePropertyChange("label", null, null);
    //    3    5:aload_0         
    //    4    6:getfield        #52  <Field PropertyChangeSupport m_pcs>
    //    5    9:ldc1            #202 <String "label">
    //    6   11:aconst_null     
    //    7   12:aconst_null     
    //    8   13:invokevirtual   #206 <Method void PropertyChangeSupport.firePropertyChange(String, Object, Object)>
    //    9   16:return          
    }

    public String getText()
    {
        return m_visualName;
    //    0    0:aload_0         
    //    1    1:getfield        #67  <Field String m_visualName>
    //    2    4:areturn         
    }

    public void setStatic()
    {
        m_visualLabel.setIcon(m_icon);
    //    0    0:aload_0         
    //    1    1:getfield        #76  <Field JLabel m_visualLabel>
    //    2    4:aload_0         
    //    3    5:getfield        #71  <Field ImageIcon m_icon>
    //    4    8:invokevirtual   #188 <Method void JLabel.setIcon(javax.swing.Icon)>
    //    5   11:return          
    }

    public void setAnimated()
    {
        m_visualLabel.setIcon(m_animatedIcon);
    //    0    0:aload_0         
    //    1    1:getfield        #76  <Field JLabel m_visualLabel>
    //    2    4:aload_0         
    //    3    5:getfield        #190 <Field ImageIcon m_animatedIcon>
    //    4    8:invokevirtual   #188 <Method void JLabel.setIcon(javax.swing.Icon)>
    //    5   11:return          
    }

    public Point getClosestConnectorPoint(Point pt)
    {
        int sourceX = getParent().getX();
    //    0    0:aload_0         
    //    1    1:invokevirtual   #217 <Method Container getParent()>
    //    2    4:invokevirtual   #222 <Method int Container.getX()>
    //    3    7:istore_2        
        int sourceY = getParent().getY();
    //    4    8:aload_0         
    //    5    9:invokevirtual   #217 <Method Container getParent()>
    //    6   12:invokevirtual   #225 <Method int Container.getY()>
    //    7   15:istore_3        
        int sourceWidth = getWidth();
    //    8   16:aload_0         
    //    9   17:invokevirtual   #227 <Method int getWidth()>
    //   10   20:istore          4
        int sourceHeight = getHeight();
    //   11   22:aload_0         
    //   12   23:invokevirtual   #229 <Method int getHeight()>
    //   13   26:istore          5
        int sourceMidX = sourceX + sourceWidth / 2;
    //   14   28:iload_2         
    //   15   29:iload           4
    //   16   31:iconst_2        
    //   17   32:idiv            
    //   18   33:iadd            
    //   19   34:istore          6
        int sourceMidY = sourceY + sourceHeight / 2;
    //   20   36:iload_3         
    //   21   37:iload           5
    //   22   39:iconst_2        
    //   23   40:idiv            
    //   24   41:iadd            
    //   25   42:istore          7
        int x = (int)pt.getX();
    //   26   44:aload_1         
    //   27   45:invokevirtual   #233 <Method double Point.getX()>
    //   28   48:d2i             
    //   29   49:istore          8
        int y = (int)pt.getY();
    //   30   51:aload_1         
    //   31   52:invokevirtual   #235 <Method double Point.getY()>
    //   32   55:d2i             
    //   33   56:istore          9
        Point closest = new Point();
    //   34   58:new             #231 <Class Point>
    //   35   61:dup             
    //   36   62:invokespecial   #236 <Method void Point()>
    //   37   65:astore          10
        int cx = Math.abs(x - sourceMidX) >= Math.abs(y - sourceMidY) ? x >= sourceMidX ? sourceX + sourceWidth : sourceX : sourceMidX;
    //   38   67:iload           8
    //   39   69:iload           6
    //   40   71:isub            
    //   41   72:invokestatic    #242 <Method int Math.abs(int)>
    //   42   75:iload           9
    //   43   77:iload           7
    //   44   79:isub            
    //   45   80:invokestatic    #242 <Method int Math.abs(int)>
    //   46   83:icmpge          91
    //   47   86:iload           6
    //   48   88:goto            106
    //   49   91:iload           8
    //   50   93:iload           6
    //   51   95:icmpge          102
    //   52   98:iload_2         
    //   53   99:goto            106
    //   54  102:iload_2         
    //   55  103:iload           4
    //   56  105:iadd            
    //   57  106:istore          11
        int cy = Math.abs(y - sourceMidY) >= Math.abs(x - sourceMidX) ? y >= sourceMidY ? sourceY + sourceHeight : sourceY : sourceMidY;
    //   58  108:iload           9
    //   59  110:iload           7
    //   60  112:isub            
    //   61  113:invokestatic    #242 <Method int Math.abs(int)>
    //   62  116:iload           8
    //   63  118:iload           6
    //   64  120:isub            
    //   65  121:invokestatic    #242 <Method int Math.abs(int)>
    //   66  124:icmpge          132
    //   67  127:iload           7
    //   68  129:goto            147
    //   69  132:iload           9
    //   70  134:iload           7
    //   71  136:icmpge          143
    //   72  139:iload_3         
    //   73  140:goto            147
    //   74  143:iload_3         
    //   75  144:iload           5
    //   76  146:iadd            
    //   77  147:istore          12
        closest.setLocation(cx, cy);
    //   78  149:aload           10
    //   79  151:iload           11
    //   80  153:iload           12
    //   81  155:invokevirtual   #245 <Method void Point.setLocation(int, int)>
        return closest;
    //   82  158:aload           10
    //   83  160:areturn         
    }

    public Point getConnectorPoint(int compassPoint)
    {
        int sourceX = getParent().getX();
    //    0    0:aload_0         
    //    1    1:invokevirtual   #217 <Method Container getParent()>
    //    2    4:invokevirtual   #222 <Method int Container.getX()>
    //    3    7:istore_2        
        int sourceY = getParent().getY();
    //    4    8:aload_0         
    //    5    9:invokevirtual   #217 <Method Container getParent()>
    //    6   12:invokevirtual   #225 <Method int Container.getY()>
    //    7   15:istore_3        
        int sourceWidth = getWidth();
    //    8   16:aload_0         
    //    9   17:invokevirtual   #227 <Method int getWidth()>
    //   10   20:istore          4
        int sourceHeight = getHeight();
    //   11   22:aload_0         
    //   12   23:invokevirtual   #229 <Method int getHeight()>
    //   13   26:istore          5
        int sourceMidX = sourceX + sourceWidth / 2;
    //   14   28:iload_2         
    //   15   29:iload           4
    //   16   31:iconst_2        
    //   17   32:idiv            
    //   18   33:iadd            
    //   19   34:istore          6
        int sourceMidY = sourceY + sourceHeight / 2;
    //   20   36:iload_3         
    //   21   37:iload           5
    //   22   39:iconst_2        
    //   23   40:idiv            
    //   24   41:iadd            
    //   25   42:istore          7
        switch(compassPoint)
    //*  26   44:iload_1         
        {
    //*  27   45:tableswitch     0 3: default 126
    //                   0 76
    //                   1 87
    //                   2 112
    //                   3 101
        case 0: // '\0'
            return new Point(sourceMidX, sourceY);
    //   28   76:new             #231 <Class Point>
    //   29   79:dup             
    //   30   80:iload           6
    //   31   82:iload_3         
    //   32   83:invokespecial   #261 <Method void Point(int, int)>
    //   33   86:areturn         

        case 1: // '\001'
            return new Point(sourceMidX, sourceY + sourceHeight);
    //   34   87:new             #231 <Class Point>
    //   35   90:dup             
    //   36   91:iload           6
    //   37   93:iload_3         
    //   38   94:iload           5
    //   39   96:iadd            
    //   40   97:invokespecial   #261 <Method void Point(int, int)>
    //   41  100:areturn         

        case 3: // '\003'
            return new Point(sourceX, sourceMidY);
    //   42  101:new             #231 <Class Point>
    //   43  104:dup             
    //   44  105:iload_2         
    //   45  106:iload           7
    //   46  108:invokespecial   #261 <Method void Point(int, int)>
    //   47  111:areturn         

        case 2: // '\002'
            return new Point(sourceX + sourceWidth, sourceMidY);
    //   48  112:new             #231 <Class Point>
    //   49  115:dup             
    //   50  116:iload_2         
    //   51  117:iload           4
    //   52  119:iadd            
    //   53  120:iload           7
    //   54  122:invokespecial   #261 <Method void Point(int, int)>
    //   55  125:areturn         
        }
        System.err.println("Unrecognised connectorPoint (BeanVisual)");
    //   56  126:getstatic       #267 <Field PrintStream System.err>
    //   57  129:ldc2            #269 <String "Unrecognised connectorPoint (BeanVisual)">
    //   58  132:invokevirtual   #274 <Method void PrintStream.println(String)>
        return new Point(sourceX, sourceY);
    //   59  135:new             #231 <Class Point>
    //   60  138:dup             
    //   61  139:iload_2         
    //   62  140:iload_3         
    //   63  141:invokespecial   #261 <Method void Point(int, int)>
    //   64  144:areturn         
    }

    public ImageIcon getStaticIcon()
    {
        return m_icon;
    //    0    0:aload_0         
    //    1    1:getfield        #71  <Field ImageIcon m_icon>
    //    2    4:areturn         
    }

    public ImageIcon getAnimatedIcon()
    {
        return m_animatedIcon;
    //    0    0:aload_0         
    //    1    1:getfield        #190 <Field ImageIcon m_animatedIcon>
    //    2    4:areturn         
    }

    public String getIconPath()
    {
        return m_iconPath;
    //    0    0:aload_0         
    //    1    1:getfield        #192 <Field String m_iconPath>
    //    2    4:areturn         
    }

    public String getAnimatedIconPath()
    {
        return m_animatedIconPath;
    //    0    0:aload_0         
    //    1    1:getfield        #194 <Field String m_animatedIconPath>
    //    2    4:areturn         
    }

    public void setDisplayConnectors(boolean dc)
    {
        m_displayConnectors = dc;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #54  <Field boolean m_displayConnectors>
        m_connectorColor = Color.blue;
    //    3    5:aload_0         
    //    4    6:getstatic       #59  <Field Color Color.blue>
    //    5    9:putfield        #61  <Field Color m_connectorColor>
        repaint();
    //    6   12:aload_0         
    //    7   13:invokevirtual   #285 <Method void repaint()>
    //    8   16:return          
    }

    public void setDisplayConnectors(boolean dc, Color c)
    {
        setDisplayConnectors(dc);
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:invokevirtual   #289 <Method void setDisplayConnectors(boolean)>
        m_connectorColor = c;
    //    3    5:aload_0         
    //    4    6:aload_2         
    //    5    7:putfield        #61  <Field Color m_connectorColor>
    //    6   10:return          
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl)
    {
        m_pcs.addPropertyChangeListener(pcl);
    //    0    0:aload_0         
    //    1    1:getfield        #52  <Field PropertyChangeSupport m_pcs>
    //    2    4:aload_1         
    //    3    5:invokevirtual   #294 <Method void PropertyChangeSupport.addPropertyChangeListener(PropertyChangeListener)>
    //    4    8:return          
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl)
    {
        m_pcs.removePropertyChangeListener(pcl);
    //    0    0:aload_0         
    //    1    1:getfield        #52  <Field PropertyChangeSupport m_pcs>
    //    2    4:aload_1         
    //    3    5:invokevirtual   #299 <Method void PropertyChangeSupport.removePropertyChangeListener(PropertyChangeListener)>
    //    4    8:return          
    }

    public void paintComponent(Graphics gx)
    {
        super.paintComponent(gx);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokespecial   #303 <Method void JPanel.paintComponent(Graphics)>
        if(m_displayConnectors)
    //*   3    5:aload_0         
    //*   4    6:getfield        #54  <Field boolean m_displayConnectors>
    //*   5    9:ifeq            92
        {
            gx.setColor(m_connectorColor);
    //    6   12:aload_1         
    //    7   13:aload_0         
    //    8   14:getfield        #61  <Field Color m_connectorColor>
    //    9   17:invokevirtual   #309 <Method void Graphics.setColor(Color)>
            int midx = (int)((double)getWidth() / 2D);
    //   10   20:aload_0         
    //   11   21:invokevirtual   #227 <Method int getWidth()>
    //   12   24:i2d             
    //   13   25:ldc2w           #310 <Double 2D>
    //   14   28:ddiv            
    //   15   29:d2i             
    //   16   30:istore_2        
            int midy = (int)((double)getHeight() / 2D);
    //   17   31:aload_0         
    //   18   32:invokevirtual   #229 <Method int getHeight()>
    //   19   35:i2d             
    //   20   36:ldc2w           #310 <Double 2D>
    //   21   39:ddiv            
    //   22   40:d2i             
    //   23   41:istore_3        
            gx.fillOval(midx - 2, 0, 5, 5);
    //   24   42:aload_1         
    //   25   43:iload_2         
    //   26   44:iconst_2        
    //   27   45:isub            
    //   28   46:iconst_0        
    //   29   47:iconst_5        
    //   30   48:iconst_5        
    //   31   49:invokevirtual   #315 <Method void Graphics.fillOval(int, int, int, int)>
            gx.fillOval(midx - 2, getHeight() - 5, 5, 5);
    //   32   52:aload_1         
    //   33   53:iload_2         
    //   34   54:iconst_2        
    //   35   55:isub            
    //   36   56:aload_0         
    //   37   57:invokevirtual   #229 <Method int getHeight()>
    //   38   60:iconst_5        
    //   39   61:isub            
    //   40   62:iconst_5        
    //   41   63:iconst_5        
    //   42   64:invokevirtual   #315 <Method void Graphics.fillOval(int, int, int, int)>
            gx.fillOval(0, midy - 2, 5, 5);
    //   43   67:aload_1         
    //   44   68:iconst_0        
    //   45   69:iload_3         
    //   46   70:iconst_2        
    //   47   71:isub            
    //   48   72:iconst_5        
    //   49   73:iconst_5        
    //   50   74:invokevirtual   #315 <Method void Graphics.fillOval(int, int, int, int)>
            gx.fillOval(getWidth() - 5, midy - 2, 5, 5);
    //   51   77:aload_1         
    //   52   78:aload_0         
    //   53   79:invokevirtual   #227 <Method int getWidth()>
    //   54   82:iconst_5        
    //   55   83:isub            
    //   56   84:iload_3         
    //   57   85:iconst_2        
    //   58   86:isub            
    //   59   87:iconst_5        
    //   60   88:iconst_5        
    //   61   89:invokevirtual   #315 <Method void Graphics.fillOval(int, int, int, int)>
        }
    //   62   92:return          
    }

    private void readObject(ObjectInputStream ois)
        throws IOException, ClassNotFoundException
    {
        try
        {
            ois.defaultReadObject();
    //    0    0:aload_1         
    //    1    1:invokevirtual   #331 <Method void ObjectInputStream.defaultReadObject()>
            remove(m_visualLabel);
    //    2    4:aload_0         
    //    3    5:aload_0         
    //    4    6:getfield        #76  <Field JLabel m_visualLabel>
    //    5    9:invokevirtual   #335 <Method void remove(java.awt.Component)>
            m_visualLabel = new JLabel(m_icon);
    //    6   12:aload_0         
    //    7   13:new             #69  <Class JLabel>
    //    8   16:dup             
    //    9   17:aload_0         
    //   10   18:getfield        #71  <Field ImageIcon m_icon>
    //   11   21:invokespecial   #74  <Method void JLabel(javax.swing.Icon)>
    //   12   24:putfield        #76  <Field JLabel m_visualLabel>
            loadIcons(m_iconPath, m_animatedIconPath);
    //   13   27:aload_0         
    //   14   28:aload_0         
    //   15   29:getfield        #192 <Field String m_iconPath>
    //   16   32:aload_0         
    //   17   33:getfield        #194 <Field String m_animatedIconPath>
    //   18   36:invokevirtual   #65  <Method boolean loadIcons(String, String)>
    //   19   39:pop             
            add(m_visualLabel, "Center");
    //   20   40:aload_0         
    //   21   41:aload_0         
    //   22   42:getfield        #76  <Field JLabel m_visualLabel>
    //   23   45:ldc1            #85  <String "Center">
    //   24   47:invokevirtual   #89  <Method void add(java.awt.Component, Object)>
            Dimension d = m_visualLabel.getPreferredSize();
    //   25   50:aload_0         
    //   26   51:getfield        #76  <Field JLabel m_visualLabel>
    //   27   54:invokevirtual   #93  <Method Dimension JLabel.getPreferredSize()>
    //   28   57:astore_2        
            Dimension d2 = new Dimension((int)d.getWidth() + 10, (int)d.getHeight() + 10);
    //   29   58:new             #95  <Class Dimension>
    //   30   61:dup             
    //   31   62:aload_2         
    //   32   63:invokevirtual   #99  <Method double Dimension.getWidth()>
    //   33   66:d2i             
    //   34   67:bipush          10
    //   35   69:iadd            
    //   36   70:aload_2         
    //   37   71:invokevirtual   #102 <Method double Dimension.getHeight()>
    //   38   74:d2i             
    //   39   75:bipush          10
    //   40   77:iadd            
    //   41   78:invokespecial   #105 <Method void Dimension(int, int)>
    //   42   81:astore_3        
            setMinimumSize(d2);
    //   43   82:aload_0         
    //   44   83:aload_3         
    //   45   84:invokevirtual   #109 <Method void setMinimumSize(Dimension)>
            setPreferredSize(d2);
    //   46   87:aload_0         
    //   47   88:aload_3         
    //   48   89:invokevirtual   #112 <Method void setPreferredSize(Dimension)>
            setMaximumSize(d2);
    //   49   92:aload_0         
    //   50   93:aload_3         
    //   51   94:invokevirtual   #115 <Method void setMaximumSize(Dimension)>
        }
    //*  52   97:goto            105
        catch(Exception ex)
    //*  53  100:astore_2        
        {
            ex.printStackTrace();
    //   54  101:aload_2         
    //   55  102:invokevirtual   #340 <Method void Exception.printStackTrace()>
        }
    //   56  105:return          
    }

    private static final long serialVersionUID = 0xa354d92ca69381f2L;
    public static final String ICON_PATH = "weka/gui/beans/icons/";
    public static final int NORTH_CONNECTOR = 0;
    public static final int SOUTH_CONNECTOR = 1;
    public static final int EAST_CONNECTOR = 2;
    public static final int WEST_CONNECTOR = 3;
    protected String m_iconPath;
    protected String m_animatedIconPath;
    protected transient ImageIcon m_icon;
    protected transient ImageIcon m_animatedIcon;
    protected String m_visualName;
    protected JLabel m_visualLabel;
    private boolean m_stationary;
    private PropertyChangeSupport m_pcs;
    private boolean m_displayConnectors;
    private Color m_connectorColor;
}
