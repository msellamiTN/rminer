// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   DataVisualizer.java

package rm.gui.beans;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeListener;
import java.beans.VetoableChangeListener;
import java.beans.beancontext.*;
import java.io.*;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import rm.core.Instances;
import rm.gui.visualize.PlotData2D;
import rm.gui.visualize.VisualizePanel;

// Referenced classes of package rm.gui.beans:
//            DataSourceListener, TrainingSetListener, TestSetListener, Visible, 
//            UserRequestAcceptor, BeanVisual, TrainingSetEvent, DataSetEvent, 
//            TestSetEvent

public class DataVisualizer extends JPanel
    implements DataSourceListener, TrainingSetListener, TestSetListener, Visible, UserRequestAcceptor, Serializable, BeanContextChild
{

    public DataVisualizer()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #45  <Method void JPanel()>
        m_framePoppedUp = false;
    //    2    4:aload_0         
    //    3    5:iconst_0        
    //    4    6:putfield        #47  <Field boolean m_framePoppedUp>
        m_beanContext = null;
    //    5    9:aload_0         
    //    6   10:aconst_null     
    //    7   11:putfield        #49  <Field BeanContext m_beanContext>
        m_dataSetListeners = new Vector();
    //    8   14:aload_0         
    //    9   15:new             #51  <Class Vector>
    //   10   18:dup             
    //   11   19:invokespecial   #52  <Method void Vector()>
    //   12   22:putfield        #54  <Field Vector m_dataSetListeners>
        m_bcSupport = new BeanContextChildSupport(this);
    //   13   25:aload_0         
    //   14   26:new             #56  <Class BeanContextChildSupport>
    //   15   29:dup             
    //   16   30:aload_0         
    //   17   31:invokespecial   #59  <Method void BeanContextChildSupport(BeanContextChild)>
    //   18   34:putfield        #61  <Field BeanContextChildSupport m_bcSupport>
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    //   19   37:invokestatic    #67  <Method GraphicsEnvironment GraphicsEnvironment.getLocalGraphicsEnvironment()>
    //   20   40:astore_1        
        if(!GraphicsEnvironment.isHeadless())
    //*  21   41:invokestatic    #71  <Method boolean GraphicsEnvironment.isHeadless()>
    //*  22   44:ifne            51
            appearanceFinal();
    //   23   47:aload_0         
    //   24   48:invokevirtual   #74  <Method void appearanceFinal()>
    //   25   51:return          
    }

    public String globalInfo()
    {
        return "Visualize incoming data/training/test sets in a 2D scatter plot.";
    //    0    0:ldc1            #84  <String "Visualize incoming data/training/test sets in a 2D scatter plot.">
    //    1    2:areturn         
    }

    protected void appearanceDesign()
    {
        m_visPanel = null;
    //    0    0:aload_0         
    //    1    1:aconst_null     
    //    2    2:putfield        #87  <Field VisualizePanel m_visPanel>
        removeAll();
    //    3    5:aload_0         
    //    4    6:invokevirtual   #90  <Method void removeAll()>
        m_visual = new BeanVisual("DataVisualizer", "weka/gui/beans/icons/DefaultDataVisualizer.gif", "weka/gui/beans/icons/DefaultDataVisualizer_animated.gif");
    //    5    9:aload_0         
    //    6   10:new             #92  <Class BeanVisual>
    //    7   13:dup             
    //    8   14:ldc1            #94  <String "DataVisualizer">
    //    9   16:ldc1            #96  <String "weka/gui/beans/icons/DefaultDataVisualizer.gif">
    //   10   18:ldc1            #98  <String "weka/gui/beans/icons/DefaultDataVisualizer_animated.gif">
    //   11   20:invokespecial   #101 <Method void BeanVisual(String, String, String)>
    //   12   23:putfield        #103 <Field BeanVisual m_visual>
        setLayout(new BorderLayout());
    //   13   26:aload_0         
    //   14   27:new             #105 <Class BorderLayout>
    //   15   30:dup             
    //   16   31:invokespecial   #106 <Method void BorderLayout()>
    //   17   34:invokevirtual   #110 <Method void setLayout(java.awt.LayoutManager)>
        add(m_visual, "Center");
    //   18   37:aload_0         
    //   19   38:aload_0         
    //   20   39:getfield        #103 <Field BeanVisual m_visual>
    //   21   42:ldc1            #112 <String "Center">
    //   22   44:invokevirtual   #116 <Method void add(java.awt.Component, Object)>
    //   23   47:return          
    }

    protected void appearanceFinal()
    {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    //    0    0:invokestatic    #67  <Method GraphicsEnvironment GraphicsEnvironment.getLocalGraphicsEnvironment()>
    //    1    3:astore_1        
        removeAll();
    //    2    4:aload_0         
    //    3    5:invokevirtual   #90  <Method void removeAll()>
        if(!GraphicsEnvironment.isHeadless())
    //*   4    8:invokestatic    #71  <Method boolean GraphicsEnvironment.isHeadless()>
    //*   5   11:ifne            29
        {
            setLayout(new BorderLayout());
    //    6   14:aload_0         
    //    7   15:new             #105 <Class BorderLayout>
    //    8   18:dup             
    //    9   19:invokespecial   #106 <Method void BorderLayout()>
    //   10   22:invokevirtual   #110 <Method void setLayout(java.awt.LayoutManager)>
            setUpFinal();
    //   11   25:aload_0         
    //   12   26:invokevirtual   #119 <Method void setUpFinal()>
        }
    //   13   29:return          
    }

    protected void setUpFinal()
    {
        if(m_visPanel == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #87  <Field VisualizePanel m_visPanel>
    //*   2    4:ifnonnull       18
            m_visPanel = new VisualizePanel();
    //    3    7:aload_0         
    //    4    8:new             #121 <Class VisualizePanel>
    //    5   11:dup             
    //    6   12:invokespecial   #122 <Method void VisualizePanel()>
    //    7   15:putfield        #87  <Field VisualizePanel m_visPanel>
        add(m_visPanel, "Center");
    //    8   18:aload_0         
    //    9   19:aload_0         
    //   10   20:getfield        #87  <Field VisualizePanel m_visPanel>
    //   11   23:ldc1            #112 <String "Center">
    //   12   25:invokevirtual   #116 <Method void add(java.awt.Component, Object)>
    //   13   28:return          
    }

    public void acceptTrainingSet(TrainingSetEvent e)
    {
        Instances trainingSet = e.getTrainingSet();
    //    0    0:aload_1         
    //    1    1:invokevirtual   #130 <Method Instances TrainingSetEvent.getTrainingSet()>
    //    2    4:astore_2        
        DataSetEvent dse = new DataSetEvent(this, trainingSet);
    //    3    5:new             #132 <Class DataSetEvent>
    //    4    8:dup             
    //    5    9:aload_0         
    //    6   10:aload_2         
    //    7   11:invokespecial   #135 <Method void DataSetEvent(Object, Instances)>
    //    8   14:astore_3        
        acceptDataSet(dse);
    //    9   15:aload_0         
    //   10   16:aload_3         
    //   11   17:invokevirtual   #139 <Method void acceptDataSet(DataSetEvent)>
    //   12   20:return          
    }

    public void acceptTestSet(TestSetEvent e)
    {
        Instances testSet = e.getTestSet();
    //    0    0:aload_1         
    //    1    1:invokevirtual   #151 <Method Instances TestSetEvent.getTestSet()>
    //    2    4:astore_2        
        DataSetEvent dse = new DataSetEvent(this, testSet);
    //    3    5:new             #132 <Class DataSetEvent>
    //    4    8:dup             
    //    5    9:aload_0         
    //    6   10:aload_2         
    //    7   11:invokespecial   #135 <Method void DataSetEvent(Object, Instances)>
    //    8   14:astore_3        
        acceptDataSet(dse);
    //    9   15:aload_0         
    //   10   16:aload_3         
    //   11   17:invokevirtual   #139 <Method void acceptDataSet(DataSetEvent)>
    //   12   20:return          
    }

    public synchronized void acceptDataSet(DataSetEvent e)
    {
        if(e.isStructureOnly())
    //*   0    0:aload_1         
    //*   1    1:invokevirtual   #156 <Method boolean DataSetEvent.isStructureOnly()>
    //*   2    4:ifeq            8
            return;
    //    3    7:return          
        m_visualizeDataSet = new Instances(e.getDataSet());
    //    4    8:aload_0         
    //    5    9:new             #158 <Class Instances>
    //    6   12:dup             
    //    7   13:aload_1         
    //    8   14:invokevirtual   #161 <Method Instances DataSetEvent.getDataSet()>
    //    9   17:invokespecial   #164 <Method void Instances(Instances)>
    //   10   20:putfield        #166 <Field Instances m_visualizeDataSet>
        if(m_visualizeDataSet.classIndex() < 0)
    //*  11   23:aload_0         
    //*  12   24:getfield        #166 <Field Instances m_visualizeDataSet>
    //*  13   27:invokevirtual   #170 <Method int Instances.classIndex()>
    //*  14   30:ifge            49
            m_visualizeDataSet.setClassIndex(m_visualizeDataSet.numAttributes() - 1);
    //   15   33:aload_0         
    //   16   34:getfield        #166 <Field Instances m_visualizeDataSet>
    //   17   37:aload_0         
    //   18   38:getfield        #166 <Field Instances m_visualizeDataSet>
    //   19   41:invokevirtual   #173 <Method int Instances.numAttributes()>
    //   20   44:iconst_1        
    //   21   45:isub            
    //   22   46:invokevirtual   #177 <Method void Instances.setClassIndex(int)>
        if(!m_design)
    //*  23   49:aload_0         
    //*  24   50:getfield        #179 <Field boolean m_design>
    //*  25   53:ifne            72
            try
            {
                setInstances(m_visualizeDataSet);
    //   26   56:aload_0         
    //   27   57:aload_0         
    //   28   58:getfield        #166 <Field Instances m_visualizeDataSet>
    //   29   61:invokevirtual   #182 <Method void setInstances(Instances)>
            }
    //*  30   64:goto            72
            catch(Exception ex)
    //*  31   67:astore_2        
            {
                ex.printStackTrace();
    //   32   68:aload_2         
    //   33   69:invokevirtual   #187 <Method void Exception.printStackTrace()>
            }
        notifyDataSetListeners(e);
    //   34   72:aload_0         
    //   35   73:aload_1         
    //   36   74:invokespecial   #190 <Method void notifyDataSetListeners(DataSetEvent)>
    //   37   77:return          
    }

    public void setVisual(BeanVisual newVisual)
    {
        m_visual = newVisual;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #103 <Field BeanVisual m_visual>
    //    3    5:return          
    }

    public BeanVisual getVisual()
    {
        return m_visual;
    //    0    0:aload_0         
    //    1    1:getfield        #103 <Field BeanVisual m_visual>
    //    2    4:areturn         
    }

    public void useDefaultVisual()
    {
        m_visual.loadIcons("weka/gui/beans/icons/DefaultDataVisualizer.gif", "weka/gui/beans/icons/DefaultDataVisualizer_animated.gif");
    //    0    0:aload_0         
    //    1    1:getfield        #103 <Field BeanVisual m_visual>
    //    2    4:ldc1            #96  <String "weka/gui/beans/icons/DefaultDataVisualizer.gif">
    //    3    6:ldc1            #98  <String "weka/gui/beans/icons/DefaultDataVisualizer_animated.gif">
    //    4    8:invokevirtual   #202 <Method boolean BeanVisual.loadIcons(String, String)>
    //    5   11:pop             
    //    6   12:return          
    }

    public Enumeration enumerateRequests()
    {
        Vector newVector = new Vector(0);
    //    0    0:new             #51  <Class Vector>
    //    1    3:dup             
    //    2    4:iconst_0        
    //    3    5:invokespecial   #206 <Method void Vector(int)>
    //    4    8:astore_1        
        if(m_visualizeDataSet != null)
    //*   5    9:aload_0         
    //*   6   10:getfield        #166 <Field Instances m_visualizeDataSet>
    //*   7   13:ifnull          22
            newVector.addElement("Show plot");
    //    8   16:aload_1         
    //    9   17:ldc1            #208 <String "Show plot">
    //   10   19:invokevirtual   #212 <Method void Vector.addElement(Object)>
        return newVector.elements();
    //   11   22:aload_1         
    //   12   23:invokevirtual   #215 <Method Enumeration Vector.elements()>
    //   13   26:areturn         
    }

    public void addPropertyChangeListener(String name, PropertyChangeListener pcl)
    {
        m_bcSupport.addPropertyChangeListener(name, pcl);
    //    0    0:aload_0         
    //    1    1:getfield        #61  <Field BeanContextChildSupport m_bcSupport>
    //    2    4:aload_1         
    //    3    5:aload_2         
    //    4    6:invokevirtual   #220 <Method void BeanContextChildSupport.addPropertyChangeListener(String, PropertyChangeListener)>
    //    5    9:return          
    }

    public void removePropertyChangeListener(String name, PropertyChangeListener pcl)
    {
        m_bcSupport.removePropertyChangeListener(name, pcl);
    //    0    0:aload_0         
    //    1    1:getfield        #61  <Field BeanContextChildSupport m_bcSupport>
    //    2    4:aload_1         
    //    3    5:aload_2         
    //    4    6:invokevirtual   #227 <Method void BeanContextChildSupport.removePropertyChangeListener(String, PropertyChangeListener)>
    //    5    9:return          
    }

    public void addVetoableChangeListener(String name, VetoableChangeListener vcl)
    {
        m_bcSupport.addVetoableChangeListener(name, vcl);
    //    0    0:aload_0         
    //    1    1:getfield        #61  <Field BeanContextChildSupport m_bcSupport>
    //    2    4:aload_1         
    //    3    5:aload_2         
    //    4    6:invokevirtual   #231 <Method void BeanContextChildSupport.addVetoableChangeListener(String, VetoableChangeListener)>
    //    5    9:return          
    }

    public void removeVetoableChangeListener(String name, VetoableChangeListener vcl)
    {
        m_bcSupport.removeVetoableChangeListener(name, vcl);
    //    0    0:aload_0         
    //    1    1:getfield        #61  <Field BeanContextChildSupport m_bcSupport>
    //    2    4:aload_1         
    //    3    5:aload_2         
    //    4    6:invokevirtual   #236 <Method void BeanContextChildSupport.removeVetoableChangeListener(String, VetoableChangeListener)>
    //    5    9:return          
    }

    public void setBeanContext(BeanContext bc)
    {
        m_beanContext = bc;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #49  <Field BeanContext m_beanContext>
        m_design = m_beanContext.isDesignTime();
    //    3    5:aload_0         
    //    4    6:aload_0         
    //    5    7:getfield        #49  <Field BeanContext m_beanContext>
    //    6   10:invokeinterface #243 <Method boolean BeanContext.isDesignTime()>
    //    7   15:putfield        #179 <Field boolean m_design>
        if(m_design)
    //*   8   18:aload_0         
    //*   9   19:getfield        #179 <Field boolean m_design>
    //*  10   22:ifeq            32
        {
            appearanceDesign();
    //   11   25:aload_0         
    //   12   26:invokevirtual   #245 <Method void appearanceDesign()>
        } else
    //*  13   29:goto            46
        {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    //   14   32:invokestatic    #67  <Method GraphicsEnvironment GraphicsEnvironment.getLocalGraphicsEnvironment()>
    //   15   35:astore_2        
            if(!GraphicsEnvironment.isHeadless())
    //*  16   36:invokestatic    #71  <Method boolean GraphicsEnvironment.isHeadless()>
    //*  17   39:ifne            46
                appearanceFinal();
    //   18   42:aload_0         
    //   19   43:invokevirtual   #74  <Method void appearanceFinal()>
        }
    //   20   46:return          
    }

    public BeanContext getBeanContext()
    {
        return m_beanContext;
    //    0    0:aload_0         
    //    1    1:getfield        #49  <Field BeanContext m_beanContext>
    //    2    4:areturn         
    }

    public void setInstances(Instances inst)
        throws Exception
    {
        if(m_design)
    //*   0    0:aload_0         
    //*   1    1:getfield        #179 <Field boolean m_design>
    //*   2    4:ifeq            17
            throw new Exception("This method is not to be used during design time. It is meant to be used if this bean is being used programatically as as stand alone component.");
    //    3    7:new             #184 <Class Exception>
    //    4   10:dup             
    //    5   11:ldc1            #251 <String "This method is not to be used during design time. It is meant to be used if this bean is being used programatically as as stand alone component.">
    //    6   13:invokespecial   #254 <Method void Exception(String)>
    //    7   16:athrow          
        m_visualizeDataSet = inst;
    //    8   17:aload_0         
    //    9   18:aload_1         
    //   10   19:putfield        #166 <Field Instances m_visualizeDataSet>
        PlotData2D pd1 = new PlotData2D(m_visualizeDataSet);
    //   11   22:new             #256 <Class PlotData2D>
    //   12   25:dup             
    //   13   26:aload_0         
    //   14   27:getfield        #166 <Field Instances m_visualizeDataSet>
    //   15   30:invokespecial   #257 <Method void PlotData2D(Instances)>
    //   16   33:astore_2        
        pd1.setPlotName(m_visualizeDataSet.relationName());
    //   17   34:aload_2         
    //   18   35:aload_0         
    //   19   36:getfield        #166 <Field Instances m_visualizeDataSet>
    //   20   39:invokevirtual   #260 <Method String Instances.relationName()>
    //   21   42:invokevirtual   #263 <Method void PlotData2D.setPlotName(String)>
        try
        {
            m_visPanel.setMasterPlot(pd1);
    //   22   45:aload_0         
    //   23   46:getfield        #87  <Field VisualizePanel m_visPanel>
    //   24   49:aload_2         
    //   25   50:invokevirtual   #267 <Method void VisualizePanel.setMasterPlot(PlotData2D)>
        }
    //*  26   53:goto            70
        catch(Exception ex)
    //*  27   56:astore_3        
        {
            System.err.println("Problem setting up visualization (DataVisualizer)");
    //   28   57:getstatic       #273 <Field PrintStream System.err>
    //   29   60:ldc2            #275 <String "Problem setting up visualization (DataVisualizer)">
    //   30   63:invokevirtual   #280 <Method void PrintStream.println(String)>
            ex.printStackTrace();
    //   31   66:aload_3         
    //   32   67:invokevirtual   #187 <Method void Exception.printStackTrace()>
        }
    //   33   70:return          
    }

    private void notifyDataSetListeners(DataSetEvent ge)
    {
        Vector l;
        synchronized(this)
    //*   0    0:aload_0         
    //*   1    1:dup             
    //*   2    2:astore_3        
    //*   3    3:monitorenter    
        {
            l = (Vector)m_dataSetListeners.clone();
    //    4    4:aload_0         
    //    5    5:getfield        #54  <Field Vector m_dataSetListeners>
    //    6    8:invokevirtual   #287 <Method Object Vector.clone()>
    //    7   11:checkcast       #51  <Class Vector>
    //    8   14:astore_2        
        }
    //    9   15:aload_3         
    //   10   16:monitorexit     
    //   11   17:goto            23
    //   12   20:aload_3         
    //   13   21:monitorexit     
    //   14   22:athrow          
        if(l.size() > 0)
    //*  15   23:aload_2         
    //*  16   24:invokevirtual   #290 <Method int Vector.size()>
    //*  17   27:ifle            63
        {
            for(int i = 0; i < l.size(); i++)
    //*  18   30:iconst_0        
    //*  19   31:istore_3        
    //*  20   32:goto            55
                ((DataSourceListener)(DataSourceListener)l.elementAt(i)).acceptDataSet(ge);
    //   21   35:aload_2         
    //   22   36:iload_3         
    //   23   37:invokevirtual   #294 <Method Object Vector.elementAt(int)>
    //   24   40:checkcast       #6   <Class DataSourceListener>
    //   25   43:checkcast       #6   <Class DataSourceListener>
    //   26   46:aload_1         
    //   27   47:invokeinterface #295 <Method void DataSourceListener.acceptDataSet(DataSetEvent)>

    //   28   52:iinc            3  1
    //   29   55:iload_3         
    //   30   56:aload_2         
    //   31   57:invokevirtual   #290 <Method int Vector.size()>
    //   32   60:icmplt          35
        }
    //   33   63:return          
    }

    public void performRequest(String request)
    {
        if(request.compareTo("Show plot") == 0)
    //*   0    0:aload_1         
    //*   1    1:ldc1            #208 <String "Show plot">
    //*   2    3:invokevirtual   #305 <Method int String.compareTo(String)>
    //*   3    6:ifne            178
            try
            {
                if(!m_framePoppedUp)
    //*   4    9:aload_0         
    //*   5   10:getfield        #47  <Field boolean m_framePoppedUp>
    //*   6   13:ifne            155
                {
                    m_framePoppedUp = true;
    //    7   16:aload_0         
    //    8   17:iconst_1        
    //    9   18:putfield        #47  <Field boolean m_framePoppedUp>
                    VisualizePanel vis = new VisualizePanel();
    //   10   21:new             #121 <Class VisualizePanel>
    //   11   24:dup             
    //   12   25:invokespecial   #122 <Method void VisualizePanel()>
    //   13   28:astore_2        
                    PlotData2D pd1 = new PlotData2D(m_visualizeDataSet);
    //   14   29:new             #256 <Class PlotData2D>
    //   15   32:dup             
    //   16   33:aload_0         
    //   17   34:getfield        #166 <Field Instances m_visualizeDataSet>
    //   18   37:invokespecial   #257 <Method void PlotData2D(Instances)>
    //   19   40:astore_3        
                    pd1.setPlotName(m_visualizeDataSet.relationName());
    //   20   41:aload_3         
    //   21   42:aload_0         
    //   22   43:getfield        #166 <Field Instances m_visualizeDataSet>
    //   23   46:invokevirtual   #260 <Method String Instances.relationName()>
    //   24   49:invokevirtual   #263 <Method void PlotData2D.setPlotName(String)>
                    try
                    {
                        vis.setMasterPlot(pd1);
    //   25   52:aload_2         
    //   26   53:aload_3         
    //   27   54:invokevirtual   #267 <Method void VisualizePanel.setMasterPlot(PlotData2D)>
                    }
    //*  28   57:goto            76
                    catch(Exception ex)
    //*  29   60:astore          4
                    {
                        System.err.println("Problem setting up visualization (DataVisualizer)");
    //   30   62:getstatic       #273 <Field PrintStream System.err>
    //   31   65:ldc2            #275 <String "Problem setting up visualization (DataVisualizer)">
    //   32   68:invokevirtual   #280 <Method void PrintStream.println(String)>
                        ex.printStackTrace();
    //   33   71:aload           4
    //   34   73:invokevirtual   #187 <Method void Exception.printStackTrace()>
                    }
                    final JFrame jf = new JFrame("Visualize");
    //   35   76:new             #307 <Class JFrame>
    //   36   79:dup             
    //   37   80:ldc2            #309 <String "Visualize">
    //   38   83:invokespecial   #310 <Method void JFrame(String)>
    //   39   86:astore          4
                    jf.setSize(800, 600);
    //   40   88:aload           4
    //   41   90:sipush          800
    //   42   93:sipush          600
    //   43   96:invokevirtual   #314 <Method void JFrame.setSize(int, int)>
                    jf.getContentPane().setLayout(new BorderLayout());
    //   44   99:aload           4
    //   45  101:invokevirtual   #318 <Method Container JFrame.getContentPane()>
    //   46  104:new             #105 <Class BorderLayout>
    //   47  107:dup             
    //   48  108:invokespecial   #106 <Method void BorderLayout()>
    //   49  111:invokevirtual   #321 <Method void Container.setLayout(java.awt.LayoutManager)>
                    jf.getContentPane().add(vis, "Center");
    //   50  114:aload           4
    //   51  116:invokevirtual   #318 <Method Container JFrame.getContentPane()>
    //   52  119:aload_2         
    //   53  120:ldc1            #112 <String "Center">
    //   54  122:invokevirtual   #322 <Method void Container.add(java.awt.Component, Object)>
                    jf.addWindowListener(new WindowAdapter() {

                        public void windowClosing(WindowEvent e)
                        {
                            jf.dispose();
                        //    0    0:aload_0         
                        //    1    1:getfield        #15  <Field JFrame val$jf>
                        //    2    4:invokevirtual   #29  <Method void JFrame.dispose()>
                            m_framePoppedUp = false;
                        //    3    7:aload_0         
                        //    4    8:getfield        #13  <Field DataVisualizer this$0>
                        //    5   11:iconst_0        
                        //    6   12:putfield        #35  <Field boolean DataVisualizer.m_framePoppedUp>
                        //    7   15:return          
                        }

                        final DataVisualizer this$0;
                        private final JFrame val$jf;

            
            {
                this$0 = DataVisualizer.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field DataVisualizer this$0>
                jf = jframe;
            //    3    5:aload_0         
            //    4    6:aload_2         
            //    5    7:putfield        #15  <Field JFrame val$jf>
                super();
            //    6   10:aload_0         
            //    7   11:invokespecial   #18  <Method void WindowAdapter()>
            //    8   14:return          
            }
                    }
);
    //   55  125:aload           4
    //   56  127:new             #324 <Class DataVisualizer$1>
    //   57  130:dup             
    //   58  131:aload_0         
    //   59  132:aload           4
    //   60  134:invokespecial   #327 <Method void DataVisualizer$1(DataVisualizer, JFrame)>
    //   61  137:invokevirtual   #331 <Method void JFrame.addWindowListener(java.awt.event.WindowListener)>
                    jf.setVisible(true);
    //   62  140:aload           4
    //   63  142:iconst_1        
    //   64  143:invokevirtual   #335 <Method void JFrame.setVisible(boolean)>
                    m_popupFrame = jf;
    //   65  146:aload_0         
    //   66  147:aload           4
    //   67  149:putfield        #337 <Field JFrame m_popupFrame>
                } else
    //*  68  152:goto            206
                {
                    m_popupFrame.toFront();
    //   69  155:aload_0         
    //   70  156:getfield        #337 <Field JFrame m_popupFrame>
    //   71  159:invokevirtual   #340 <Method void JFrame.toFront()>
                }
            }
    //*  72  162:goto            206
            catch(Exception ex)
    //*  73  165:astore_2        
            {
                ex.printStackTrace();
    //   74  166:aload_2         
    //   75  167:invokevirtual   #187 <Method void Exception.printStackTrace()>
                m_framePoppedUp = false;
    //   76  170:aload_0         
    //   77  171:iconst_0        
    //   78  172:putfield        #47  <Field boolean m_framePoppedUp>
            }
        else
    //*  79  175:goto            206
            throw new IllegalArgumentException((new StringBuilder(String.valueOf(request))).append(" not supported (DataVisualizer)").toString());
    //   80  178:new             #342 <Class IllegalArgumentException>
    //   81  181:dup             
    //   82  182:new             #344 <Class StringBuilder>
    //   83  185:dup             
    //   84  186:aload_1         
    //   85  187:invokestatic    #348 <Method String String.valueOf(Object)>
    //   86  190:invokespecial   #349 <Method void StringBuilder(String)>
    //   87  193:ldc2            #351 <String " not supported (DataVisualizer)">
    //   88  196:invokevirtual   #355 <Method StringBuilder StringBuilder.append(String)>
    //   89  199:invokevirtual   #358 <Method String StringBuilder.toString()>
    //   90  202:invokespecial   #359 <Method void IllegalArgumentException(String)>
    //   91  205:athrow          
    //   92  206:return          
    }

    public synchronized void addDataSourceListener(DataSourceListener dsl)
    {
        m_dataSetListeners.addElement(dsl);
    //    0    0:aload_0         
    //    1    1:getfield        #54  <Field Vector m_dataSetListeners>
    //    2    4:aload_1         
    //    3    5:invokevirtual   #212 <Method void Vector.addElement(Object)>
    //    4    8:return          
    }

    public synchronized void removeDataSourceListener(DataSourceListener dsl)
    {
        m_dataSetListeners.remove(dsl);
    //    0    0:aload_0         
    //    1    1:getfield        #54  <Field Vector m_dataSetListeners>
    //    2    4:aload_1         
    //    3    5:invokevirtual   #371 <Method boolean Vector.remove(Object)>
    //    4    8:pop             
    //    5    9:return          
    }

    public static void main(String args[])
    {
        try
        {
            if(args.length != 1)
    //*   0    0:aload_0         
    //*   1    1:arraylength     
    //*   2    2:iconst_1        
    //*   3    3:icmpeq          19
            {
                System.err.println("Usage: DataVisualizer <dataset>");
    //    4    6:getstatic       #273 <Field PrintStream System.err>
    //    5    9:ldc2            #375 <String "Usage: DataVisualizer <dataset>">
    //    6   12:invokevirtual   #280 <Method void PrintStream.println(String)>
                System.exit(1);
    //    7   15:iconst_1        
    //    8   16:invokestatic    #378 <Method void System.exit(int)>
            }
            java.io.Reader r = new BufferedReader(new FileReader(args[0]));
    //    9   19:new             #380 <Class BufferedReader>
    //   10   22:dup             
    //   11   23:new             #382 <Class FileReader>
    //   12   26:dup             
    //   13   27:aload_0         
    //   14   28:iconst_0        
    //   15   29:aaload          
    //   16   30:invokespecial   #383 <Method void FileReader(String)>
    //   17   33:invokespecial   #386 <Method void BufferedReader(java.io.Reader)>
    //   18   36:astore_1        
            Instances inst = new Instances(r);
    //   19   37:new             #158 <Class Instances>
    //   20   40:dup             
    //   21   41:aload_1         
    //   22   42:invokespecial   #387 <Method void Instances(java.io.Reader)>
    //   23   45:astore_2        
            final JFrame jf = new JFrame();
    //   24   46:new             #307 <Class JFrame>
    //   25   49:dup             
    //   26   50:invokespecial   #388 <Method void JFrame()>
    //   27   53:astore_3        
            jf.getContentPane().setLayout(new BorderLayout());
    //   28   54:aload_3         
    //   29   55:invokevirtual   #318 <Method Container JFrame.getContentPane()>
    //   30   58:new             #105 <Class BorderLayout>
    //   31   61:dup             
    //   32   62:invokespecial   #106 <Method void BorderLayout()>
    //   33   65:invokevirtual   #321 <Method void Container.setLayout(java.awt.LayoutManager)>
            DataVisualizer as = new DataVisualizer();
    //   34   68:new             #2   <Class DataVisualizer>
    //   35   71:dup             
    //   36   72:invokespecial   #389 <Method void DataVisualizer()>
    //   37   75:astore          4
            as.setInstances(inst);
    //   38   77:aload           4
    //   39   79:aload_2         
    //   40   80:invokevirtual   #182 <Method void setInstances(Instances)>
            jf.getContentPane().add(as, "Center");
    //   41   83:aload_3         
    //   42   84:invokevirtual   #318 <Method Container JFrame.getContentPane()>
    //   43   87:aload           4
    //   44   89:ldc1            #112 <String "Center">
    //   45   91:invokevirtual   #322 <Method void Container.add(java.awt.Component, Object)>
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
    //   46   94:aload_3         
    //   47   95:new             #391 <Class DataVisualizer$2>
    //   48   98:dup             
    //   49   99:aload_3         
    //   50  100:invokespecial   #394 <Method void DataVisualizer$2(JFrame)>
    //   51  103:invokevirtual   #331 <Method void JFrame.addWindowListener(java.awt.event.WindowListener)>
            jf.setSize(800, 600);
    //   52  106:aload_3         
    //   53  107:sipush          800
    //   54  110:sipush          600
    //   55  113:invokevirtual   #314 <Method void JFrame.setSize(int, int)>
            jf.setVisible(true);
    //   56  116:aload_3         
    //   57  117:iconst_1        
    //   58  118:invokevirtual   #335 <Method void JFrame.setVisible(boolean)>
        }
    //*  59  121:goto            139
        catch(Exception ex)
    //*  60  124:astore_1        
        {
            ex.printStackTrace();
    //   61  125:aload_1         
    //   62  126:invokevirtual   #187 <Method void Exception.printStackTrace()>
            System.err.println(ex.getMessage());
    //   63  129:getstatic       #273 <Field PrintStream System.err>
    //   64  132:aload_1         
    //   65  133:invokevirtual   #397 <Method String Exception.getMessage()>
    //   66  136:invokevirtual   #280 <Method void PrintStream.println(String)>
        }
    //   67  139:return          
    }

    private static final long serialVersionUID = 0x1b0c75aed869e134L;
    protected BeanVisual m_visual;
    protected transient Instances m_visualizeDataSet;
    protected transient JFrame m_popupFrame;
    protected boolean m_framePoppedUp;
    protected boolean m_design;
    protected transient BeanContext m_beanContext;
    private VisualizePanel m_visPanel;
    private Vector m_dataSetListeners;
    protected BeanContextChildSupport m_bcSupport;
}
