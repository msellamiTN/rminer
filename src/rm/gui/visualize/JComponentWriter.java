// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   JComponentWriter.java

package rm.gui.visualize;

import java.io.File;
import javax.swing.JComponent;

public abstract class JComponentWriter
{

    public JComponentWriter()
    {
        this(null);
    //    0    0:aload_0         
    //    1    1:aconst_null     
    //    2    2:invokespecial   #28  <Method void JComponentWriter(JComponent)>
    //    3    5:return          
    }

    public JComponentWriter(JComponent c)
    {
        this(c, null);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:aconst_null     
    //    3    3:invokespecial   #35  <Method void JComponentWriter(JComponent, File)>
    //    4    6:return          
    }

    public JComponentWriter(JComponent c, File f)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #38  <Method void Object()>
        component = c;
    //    2    4:aload_0         
    //    3    5:aload_1         
    //    4    6:putfield        #40  <Field JComponent component>
        outputFile = f;
    //    5    9:aload_0         
    //    6   10:aload_2         
    //    7   11:putfield        #42  <Field File outputFile>
        initialize();
    //    8   14:aload_0         
    //    9   15:invokevirtual   #45  <Method void initialize()>
    //   10   18:return          
    }

    protected void initialize()
    {
        m_xScale = 1.0D;
    //    0    0:aload_0         
    //    1    1:dconst_1        
    //    2    2:putfield        #48  <Field double m_xScale>
        m_yScale = 1.0D;
    //    3    5:aload_0         
    //    4    6:dconst_1        
    //    5    7:putfield        #50  <Field double m_yScale>
        m_ScalingEnabled = true;
    //    6   10:aload_0         
    //    7   11:iconst_1        
    //    8   12:putfield        #52  <Field boolean m_ScalingEnabled>
        m_UseCustomDimensions = false;
    //    9   15:aload_0         
    //   10   16:iconst_0        
    //   11   17:putfield        #54  <Field boolean m_UseCustomDimensions>
        m_CustomWidth = -1;
    //   12   20:aload_0         
    //   13   21:iconst_m1       
    //   14   22:putfield        #56  <Field int m_CustomWidth>
        m_CustomHeight = -1;
    //   15   25:aload_0         
    //   16   26:iconst_m1       
    //   17   27:putfield        #58  <Field int m_CustomHeight>
    //   18   30:return          
    }

    public void setComponent(JComponent c)
    {
        component = c;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #40  <Field JComponent component>
    //    3    5:return          
    }

    public JComponent getComponent()
    {
        return component;
    //    0    0:aload_0         
    //    1    1:getfield        #40  <Field JComponent component>
    //    2    4:areturn         
    }

    public void setFile(File f)
    {
        outputFile = f;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #42  <Field File outputFile>
    //    3    5:return          
    }

    public File getFile()
    {
        return outputFile;
    //    0    0:aload_0         
    //    1    1:getfield        #42  <Field File outputFile>
    //    2    4:areturn         
    }

    public abstract String getDescription();

    public abstract String getExtension();

    public boolean getScalingEnabled()
    {
        return m_ScalingEnabled;
    //    0    0:aload_0         
    //    1    1:getfield        #52  <Field boolean m_ScalingEnabled>
    //    2    4:ireturn         
    }

    public void setScalingEnabled(boolean enabled)
    {
        m_ScalingEnabled = enabled;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #52  <Field boolean m_ScalingEnabled>
    //    3    5:return          
    }

    public void setScale(double x, double y)
    {
        if(getScalingEnabled())
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #77  <Method boolean getScalingEnabled()>
    //*   2    4:ifeq            20
        {
            m_xScale = x;
    //    3    7:aload_0         
    //    4    8:dload_1         
    //    5    9:putfield        #48  <Field double m_xScale>
            m_yScale = y;
    //    6   12:aload_0         
    //    7   13:dload_3         
    //    8   14:putfield        #50  <Field double m_yScale>
        } else
    //*   9   17:goto            30
        {
            m_xScale = 1.0D;
    //   10   20:aload_0         
    //   11   21:dconst_1        
    //   12   22:putfield        #48  <Field double m_xScale>
            m_yScale = 1.0D;
    //   13   25:aload_0         
    //   14   26:dconst_1        
    //   15   27:putfield        #50  <Field double m_yScale>
        }
    //   16   30:return          
    }

    public double getXScale()
    {
        return m_xScale;
    //    0    0:aload_0         
    //    1    1:getfield        #48  <Field double m_xScale>
    //    2    4:dreturn         
    }

    public double getYScale()
    {
        return m_xScale;
    //    0    0:aload_0         
    //    1    1:getfield        #48  <Field double m_xScale>
    //    2    4:dreturn         
    }

    public boolean getUseCustomDimensions()
    {
        return m_UseCustomDimensions;
    //    0    0:aload_0         
    //    1    1:getfield        #54  <Field boolean m_UseCustomDimensions>
    //    2    4:ireturn         
    }

    public void setUseCustomDimensions(boolean value)
    {
        m_UseCustomDimensions = value;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #54  <Field boolean m_UseCustomDimensions>
    //    3    5:return          
    }

    public void setCustomWidth(int value)
    {
        m_CustomWidth = value;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #56  <Field int m_CustomWidth>
    //    3    5:return          
    }

    public int getCustomWidth()
    {
        return m_CustomWidth;
    //    0    0:aload_0         
    //    1    1:getfield        #56  <Field int m_CustomWidth>
    //    2    4:ireturn         
    }

    public void setCustomHeight(int value)
    {
        m_CustomHeight = value;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #58  <Field int m_CustomHeight>
    //    3    5:return          
    }

    public int getCustomHeight()
    {
        return m_CustomHeight;
    //    0    0:aload_0         
    //    1    1:getfield        #58  <Field int m_CustomHeight>
    //    2    4:ireturn         
    }

    protected abstract void generateOutput()
        throws Exception;

    public void toOutput()
        throws Exception
    {
        if(getFile() == null)
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #98  <Method File getFile()>
    //*   2    4:ifnonnull       17
            throw new Exception("The file is not set!");
    //    3    7:new             #95  <Class Exception>
    //    4   10:dup             
    //    5   11:ldc1            #100 <String "The file is not set!">
    //    6   13:invokespecial   #103 <Method void Exception(String)>
    //    7   16:athrow          
        if(getComponent() == null)
    //*   8   17:aload_0         
    //*   9   18:invokevirtual   #105 <Method JComponent getComponent()>
    //*  10   21:ifnonnull       34
            throw new Exception("The component is not set!");
    //   11   24:new             #95  <Class Exception>
    //   12   27:dup             
    //   13   28:ldc1            #107 <String "The component is not set!">
    //   14   30:invokespecial   #103 <Method void Exception(String)>
    //   15   33:athrow          
        int oldWidth = getComponent().getWidth();
    //   16   34:aload_0         
    //   17   35:invokevirtual   #105 <Method JComponent getComponent()>
    //   18   38:invokevirtual   #112 <Method int JComponent.getWidth()>
    //   19   41:istore_1        
        int oldHeight = getComponent().getHeight();
    //   20   42:aload_0         
    //   21   43:invokevirtual   #105 <Method JComponent getComponent()>
    //   22   46:invokevirtual   #115 <Method int JComponent.getHeight()>
    //   23   49:istore_2        
        if(getUseCustomDimensions())
    //*  24   50:aload_0         
    //*  25   51:invokevirtual   #117 <Method boolean getUseCustomDimensions()>
    //*  26   54:ifeq            72
            getComponent().setSize(getCustomWidth(), getCustomHeight());
    //   27   57:aload_0         
    //   28   58:invokevirtual   #105 <Method JComponent getComponent()>
    //   29   61:aload_0         
    //   30   62:invokevirtual   #119 <Method int getCustomWidth()>
    //   31   65:aload_0         
    //   32   66:invokevirtual   #121 <Method int getCustomHeight()>
    //   33   69:invokevirtual   #125 <Method void JComponent.setSize(int, int)>
        generateOutput();
    //   34   72:aload_0         
    //   35   73:invokevirtual   #127 <Method void generateOutput()>
        if(getUseCustomDimensions())
    //*  36   76:aload_0         
    //*  37   77:invokevirtual   #117 <Method boolean getUseCustomDimensions()>
    //*  38   80:ifeq            92
            getComponent().setSize(oldWidth, oldHeight);
    //   39   83:aload_0         
    //   40   84:invokevirtual   #105 <Method JComponent getComponent()>
    //   41   87:iload_1         
    //   42   88:iload_2         
    //   43   89:invokevirtual   #125 <Method void JComponent.setSize(int, int)>
    //   44   92:return          
    }

    public static void toOutput(JComponentWriter writer, JComponent comp, File file)
        throws Exception
    {
        toOutput(writer, comp, file, -1, -1);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:aload_2         
    //    3    3:iconst_m1       
    //    4    4:iconst_m1       
    //    5    5:invokestatic    #133 <Method void toOutput(JComponentWriter, JComponent, File, int, int)>
    //    6    8:return          
    }

    public static void toOutput(JComponentWriter writer, JComponent comp, File file, int width, int height)
        throws Exception
    {
        writer.setComponent(comp);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokevirtual   #138 <Method void setComponent(JComponent)>
        writer.setFile(file);
    //    3    5:aload_0         
    //    4    6:aload_2         
    //    5    7:invokevirtual   #140 <Method void setFile(File)>
        if(width != -1 && height != -1)
    //*   6   10:iload_3         
    //*   7   11:iconst_m1       
    //*   8   12:icmpeq          37
    //*   9   15:iload           4
    //*  10   17:iconst_m1       
    //*  11   18:icmpeq          37
        {
            writer.setUseCustomDimensions(true);
    //   12   21:aload_0         
    //   13   22:iconst_1        
    //   14   23:invokevirtual   #142 <Method void setUseCustomDimensions(boolean)>
            writer.setCustomWidth(width);
    //   15   26:aload_0         
    //   16   27:iload_3         
    //   17   28:invokevirtual   #144 <Method void setCustomWidth(int)>
            writer.setCustomHeight(height);
    //   18   31:aload_0         
    //   19   32:iload           4
    //   20   34:invokevirtual   #146 <Method void setCustomHeight(int)>
        }
        writer.toOutput();
    //   21   37:aload_0         
    //   22   38:invokevirtual   #148 <Method void toOutput()>
    //   23   41:return          
    }

    protected static final boolean DEBUG = false;
    private JComponent component;
    private File outputFile;
    protected double m_xScale;
    protected double m_yScale;
    protected boolean m_ScalingEnabled;
    protected boolean m_UseCustomDimensions;
    protected int m_CustomWidth;
    protected int m_CustomHeight;
    static Class class$0;
}
