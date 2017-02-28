// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   PlotData2D.java

package rm.gui.visualize;

import java.awt.Color;
import rm.core.*;

public class PlotData2D
{

    public PlotData2D(Instances insts)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #39  <Method void Object()>
        m_plotInstances = null;
    //    2    4:aload_0         
    //    3    5:aconst_null     
    //    4    6:putfield        #41  <Field Instances m_plotInstances>
        m_plotName = "new plot";
    //    5    9:aload_0         
    //    6   10:ldc1            #43  <String "new plot">
    //    7   12:putfield        #45  <Field String m_plotName>
        m_plotNameHTML = null;
    //    8   15:aload_0         
    //    9   16:aconst_null     
    //   10   17:putfield        #47  <Field String m_plotNameHTML>
        m_useCustomColour = false;
    //   11   20:aload_0         
    //   12   21:iconst_0        
    //   13   22:putfield        #49  <Field boolean m_useCustomColour>
        m_customColour = null;
    //   14   25:aload_0         
    //   15   26:aconst_null     
    //   16   27:putfield        #51  <Field Color m_customColour>
        m_displayAllPoints = false;
    //   17   30:aload_0         
    //   18   31:iconst_0        
    //   19   32:putfield        #53  <Field boolean m_displayAllPoints>
        m_alwaysDisplayPointsOfThisSize = -1;
    //   20   35:aload_0         
    //   21   36:iconst_m1       
    //   22   37:putfield        #55  <Field int m_alwaysDisplayPointsOfThisSize>
        m_plotInstances = insts;
    //   23   40:aload_0         
    //   24   41:aload_1         
    //   25   42:putfield        #41  <Field Instances m_plotInstances>
        m_xIndex = m_yIndex = m_cIndex = 0;
    //   26   45:aload_0         
    //   27   46:aload_0         
    //   28   47:aload_0         
    //   29   48:iconst_0        
    //   30   49:dup_x1          
    //   31   50:putfield        #57  <Field int m_cIndex>
    //   32   53:dup_x1          
    //   33   54:putfield        #59  <Field int m_yIndex>
    //   34   57:putfield        #61  <Field int m_xIndex>
        m_pointLookup = new double[m_plotInstances.numInstances()][4];
    //   35   60:aload_0         
    //   36   61:aload_0         
    //   37   62:getfield        #41  <Field Instances m_plotInstances>
    //   38   65:invokevirtual   #67  <Method int Instances.numInstances()>
    //   39   68:iconst_4        
    //   40   69:multianewarray  double[][]
    //   41   73:putfield        #70  <Field double[][] m_pointLookup>
        m_shapeSize = new int[m_plotInstances.numInstances()];
    //   42   76:aload_0         
    //   43   77:aload_0         
    //   44   78:getfield        #41  <Field Instances m_plotInstances>
    //   45   81:invokevirtual   #67  <Method int Instances.numInstances()>
    //   46   84:newarray        int[]
    //   47   86:putfield        #72  <Field int[] m_shapeSize>
        m_shapeType = new int[m_plotInstances.numInstances()];
    //   48   89:aload_0         
    //   49   90:aload_0         
    //   50   91:getfield        #41  <Field Instances m_plotInstances>
    //   51   94:invokevirtual   #67  <Method int Instances.numInstances()>
    //   52   97:newarray        int[]
    //   53   99:putfield        #74  <Field int[] m_shapeType>
        m_connectPoints = new boolean[m_plotInstances.numInstances()];
    //   54  102:aload_0         
    //   55  103:aload_0         
    //   56  104:getfield        #41  <Field Instances m_plotInstances>
    //   57  107:invokevirtual   #67  <Method int Instances.numInstances()>
    //   58  110:newarray        boolean[]
    //   59  112:putfield        #76  <Field boolean[] m_connectPoints>
        for(int i = 0; i < m_plotInstances.numInstances(); i++)
    //*  60  115:iconst_0        
    //*  61  116:istore_2        
    //*  62  117:goto            137
        {
            m_shapeSize[i] = 2;
    //   63  120:aload_0         
    //   64  121:getfield        #72  <Field int[] m_shapeSize>
    //   65  124:iload_2         
    //   66  125:iconst_2        
    //   67  126:iastore         
            m_shapeType[i] = -1;
    //   68  127:aload_0         
    //   69  128:getfield        #74  <Field int[] m_shapeType>
    //   70  131:iload_2         
    //   71  132:iconst_m1       
    //   72  133:iastore         
        }

    //   73  134:iinc            2  1
    //   74  137:iload_2         
    //   75  138:aload_0         
    //   76  139:getfield        #41  <Field Instances m_plotInstances>
    //   77  142:invokevirtual   #67  <Method int Instances.numInstances()>
    //   78  145:icmplt          120
        determineBounds();
    //   79  148:aload_0         
    //   80  149:invokespecial   #79  <Method void determineBounds()>
    //   81  152:return          
    }

    public Instances getPlotInstances()
    {
        return new Instances(m_plotInstances);
    //    0    0:new             #63  <Class Instances>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:getfield        #41  <Field Instances m_plotInstances>
    //    4    8:invokespecial   #89  <Method void Instances(Instances)>
    //    5   11:areturn         
    }

    public void setPlotName(String name)
    {
        m_plotName = name;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #45  <Field String m_plotName>
    //    3    5:return          
    }

    public String getPlotName()
    {
        return m_plotName;
    //    0    0:aload_0         
    //    1    1:getfield        #45  <Field String m_plotName>
    //    2    4:areturn         
    }

    public void setPlotNameHTML(String name)
    {
        m_plotNameHTML = name;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #47  <Field String m_plotNameHTML>
    //    3    5:return          
    }

    public String getPlotNameHTML()
    {
        if(m_plotNameHTML == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #47  <Field String m_plotNameHTML>
    //*   2    4:ifnonnull       12
            return m_plotName;
    //    3    7:aload_0         
    //    4    8:getfield        #45  <Field String m_plotName>
    //    5   11:areturn         
        else
            return m_plotNameHTML;
    //    6   12:aload_0         
    //    7   13:getfield        #47  <Field String m_plotNameHTML>
    //    8   16:areturn         
    }

    public void setShapeType(int st[])
        throws Exception
    {
        m_shapeType = st;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #74  <Field int[] m_shapeType>
        if(m_shapeType.length != m_plotInstances.numInstances())
    //*   3    5:aload_0         
    //*   4    6:getfield        #74  <Field int[] m_shapeType>
    //*   5    9:arraylength     
    //*   6   10:aload_0         
    //*   7   11:getfield        #41  <Field Instances m_plotInstances>
    //*   8   14:invokevirtual   #67  <Method int Instances.numInstances()>
    //*   9   17:icmpeq          30
            throw new Exception("PlotData2D: Shape type array must have the same number of entries as number of data points!");
    //   10   20:new             #101 <Class Exception>
    //   11   23:dup             
    //   12   24:ldc1            #103 <String "PlotData2D: Shape type array must have the same number of entries as number of data points!">
    //   13   26:invokespecial   #105 <Method void Exception(String)>
    //   14   29:athrow          
        for(int i = 0; i < st.length; i++)
    //*  15   30:iconst_0        
    //*  16   31:istore_2        
    //*  17   32:goto            57
            if(m_shapeType[i] == 1000)
    //*  18   35:aload_0         
    //*  19   36:getfield        #74  <Field int[] m_shapeType>
    //*  20   39:iload_2         
    //*  21   40:iaload          
    //*  22   41:sipush          1000
    //*  23   44:icmpne          54
                m_shapeSize[i] = 3;
    //   24   47:aload_0         
    //   25   48:getfield        #72  <Field int[] m_shapeSize>
    //   26   51:iload_2         
    //   27   52:iconst_3        
    //   28   53:iastore         

    //   29   54:iinc            2  1
    //   30   57:iload_2         
    //   31   58:aload_1         
    //   32   59:arraylength     
    //   33   60:icmplt          35
    //   34   63:return          
    }

    public void setShapeType(FastVector st)
        throws Exception
    {
        if(st.size() != m_plotInstances.numInstances())
    //*   0    0:aload_1         
    //*   1    1:invokevirtual   #112 <Method int FastVector.size()>
    //*   2    4:aload_0         
    //*   3    5:getfield        #41  <Field Instances m_plotInstances>
    //*   4    8:invokevirtual   #67  <Method int Instances.numInstances()>
    //*   5   11:icmpeq          24
            throw new Exception("PlotData2D: Shape type vector must have the same number of entries as number of data points!");
    //    6   14:new             #101 <Class Exception>
    //    7   17:dup             
    //    8   18:ldc1            #114 <String "PlotData2D: Shape type vector must have the same number of entries as number of data points!">
    //    9   20:invokespecial   #105 <Method void Exception(String)>
    //   10   23:athrow          
        m_shapeType = new int[st.size()];
    //   11   24:aload_0         
    //   12   25:aload_1         
    //   13   26:invokevirtual   #112 <Method int FastVector.size()>
    //   14   29:newarray        int[]
    //   15   31:putfield        #74  <Field int[] m_shapeType>
        for(int i = 0; i < st.size(); i++)
    //*  16   34:iconst_0        
    //*  17   35:istore_2        
    //*  18   36:goto            78
        {
            m_shapeType[i] = ((Integer)st.elementAt(i)).intValue();
    //   19   39:aload_0         
    //   20   40:getfield        #74  <Field int[] m_shapeType>
    //   21   43:iload_2         
    //   22   44:aload_1         
    //   23   45:iload_2         
    //   24   46:invokevirtual   #118 <Method Object FastVector.elementAt(int)>
    //   25   49:checkcast       #120 <Class Integer>
    //   26   52:invokevirtual   #123 <Method int Integer.intValue()>
    //   27   55:iastore         
            if(m_shapeType[i] == 1000)
    //*  28   56:aload_0         
    //*  29   57:getfield        #74  <Field int[] m_shapeType>
    //*  30   60:iload_2         
    //*  31   61:iaload          
    //*  32   62:sipush          1000
    //*  33   65:icmpne          75
                m_shapeSize[i] = 3;
    //   34   68:aload_0         
    //   35   69:getfield        #72  <Field int[] m_shapeSize>
    //   36   72:iload_2         
    //   37   73:iconst_3        
    //   38   74:iastore         
        }

    //   39   75:iinc            2  1
    //   40   78:iload_2         
    //   41   79:aload_1         
    //   42   80:invokevirtual   #112 <Method int FastVector.size()>
    //   43   83:icmplt          39
    //   44   86:return          
    }

    public void setShapeSize(int ss[])
        throws Exception
    {
        m_shapeSize = ss;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #72  <Field int[] m_shapeSize>
        if(m_shapeType.length != m_plotInstances.numInstances())
    //*   3    5:aload_0         
    //*   4    6:getfield        #74  <Field int[] m_shapeType>
    //*   5    9:arraylength     
    //*   6   10:aload_0         
    //*   7   11:getfield        #41  <Field Instances m_plotInstances>
    //*   8   14:invokevirtual   #67  <Method int Instances.numInstances()>
    //*   9   17:icmpeq          30
            throw new Exception("PlotData2D: Shape size array must have the same number of entries as number of data points!");
    //   10   20:new             #101 <Class Exception>
    //   11   23:dup             
    //   12   24:ldc1            #127 <String "PlotData2D: Shape size array must have the same number of entries as number of data points!">
    //   13   26:invokespecial   #105 <Method void Exception(String)>
    //   14   29:athrow          
        else
            return;
    //   15   30:return          
    }

    public void setShapeSize(FastVector ss)
        throws Exception
    {
        if(ss.size() != m_plotInstances.numInstances())
    //*   0    0:aload_1         
    //*   1    1:invokevirtual   #112 <Method int FastVector.size()>
    //*   2    4:aload_0         
    //*   3    5:getfield        #41  <Field Instances m_plotInstances>
    //*   4    8:invokevirtual   #67  <Method int Instances.numInstances()>
    //*   5   11:icmpeq          24
            throw new Exception("PlotData2D: Shape size vector must have the same number of entries as number of data points!");
    //    6   14:new             #101 <Class Exception>
    //    7   17:dup             
    //    8   18:ldc1            #130 <String "PlotData2D: Shape size vector must have the same number of entries as number of data points!">
    //    9   20:invokespecial   #105 <Method void Exception(String)>
    //   10   23:athrow          
        m_shapeSize = new int[ss.size()];
    //   11   24:aload_0         
    //   12   25:aload_1         
    //   13   26:invokevirtual   #112 <Method int FastVector.size()>
    //   14   29:newarray        int[]
    //   15   31:putfield        #72  <Field int[] m_shapeSize>
        for(int i = 0; i < ss.size(); i++)
    //*  16   34:iconst_0        
    //*  17   35:istore_2        
    //*  18   36:goto            59
            m_shapeSize[i] = ((Integer)ss.elementAt(i)).intValue();
    //   19   39:aload_0         
    //   20   40:getfield        #72  <Field int[] m_shapeSize>
    //   21   43:iload_2         
    //   22   44:aload_1         
    //   23   45:iload_2         
    //   24   46:invokevirtual   #118 <Method Object FastVector.elementAt(int)>
    //   25   49:checkcast       #120 <Class Integer>
    //   26   52:invokevirtual   #123 <Method int Integer.intValue()>
    //   27   55:iastore         

    //   28   56:iinc            2  1
    //   29   59:iload_2         
    //   30   60:aload_1         
    //   31   61:invokevirtual   #112 <Method int FastVector.size()>
    //   32   64:icmplt          39
    //   33   67:return          
    }

    public void setConnectPoints(boolean cp[])
        throws Exception
    {
        m_connectPoints = cp;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #76  <Field boolean[] m_connectPoints>
        if(m_connectPoints.length != m_plotInstances.numInstances())
    //*   3    5:aload_0         
    //*   4    6:getfield        #76  <Field boolean[] m_connectPoints>
    //*   5    9:arraylength     
    //*   6   10:aload_0         
    //*   7   11:getfield        #41  <Field Instances m_plotInstances>
    //*   8   14:invokevirtual   #67  <Method int Instances.numInstances()>
    //*   9   17:icmpeq          30
        {
            throw new Exception("PlotData2D: connect points array must have the same number of entries as number of data points!");
    //   10   20:new             #101 <Class Exception>
    //   11   23:dup             
    //   12   24:ldc1            #134 <String "PlotData2D: connect points array must have the same number of entries as number of data points!">
    //   13   26:invokespecial   #105 <Method void Exception(String)>
    //   14   29:athrow          
        } else
        {
            m_connectPoints[0] = false;
    //   15   30:aload_0         
    //   16   31:getfield        #76  <Field boolean[] m_connectPoints>
    //   17   34:iconst_0        
    //   18   35:iconst_0        
    //   19   36:bastore         
            return;
    //   20   37:return          
        }
    }

    public void setConnectPoints(FastVector cp)
        throws Exception
    {
        if(cp.size() != m_plotInstances.numInstances())
    //*   0    0:aload_1         
    //*   1    1:invokevirtual   #112 <Method int FastVector.size()>
    //*   2    4:aload_0         
    //*   3    5:getfield        #41  <Field Instances m_plotInstances>
    //*   4    8:invokevirtual   #67  <Method int Instances.numInstances()>
    //*   5   11:icmpeq          24
            throw new Exception("PlotData2D: connect points array must have the same number of entries as number of data points!");
    //    6   14:new             #101 <Class Exception>
    //    7   17:dup             
    //    8   18:ldc1            #134 <String "PlotData2D: connect points array must have the same number of entries as number of data points!">
    //    9   20:invokespecial   #105 <Method void Exception(String)>
    //   10   23:athrow          
        m_shapeSize = new int[cp.size()];
    //   11   24:aload_0         
    //   12   25:aload_1         
    //   13   26:invokevirtual   #112 <Method int FastVector.size()>
    //   14   29:newarray        int[]
    //   15   31:putfield        #72  <Field int[] m_shapeSize>
        for(int i = 0; i < cp.size(); i++)
    //*  16   34:iconst_0        
    //*  17   35:istore_2        
    //*  18   36:goto            59
            m_connectPoints[i] = ((Boolean)cp.elementAt(i)).booleanValue();
    //   19   39:aload_0         
    //   20   40:getfield        #76  <Field boolean[] m_connectPoints>
    //   21   43:iload_2         
    //   22   44:aload_1         
    //   23   45:iload_2         
    //   24   46:invokevirtual   #118 <Method Object FastVector.elementAt(int)>
    //   25   49:checkcast       #137 <Class Boolean>
    //   26   52:invokevirtual   #141 <Method boolean Boolean.booleanValue()>
    //   27   55:bastore         

    //   28   56:iinc            2  1
    //   29   59:iload_2         
    //   30   60:aload_1         
    //   31   61:invokevirtual   #112 <Method int FastVector.size()>
    //   32   64:icmplt          39
        m_connectPoints[0] = false;
    //   33   67:aload_0         
    //   34   68:getfield        #76  <Field boolean[] m_connectPoints>
    //   35   71:iconst_0        
    //   36   72:iconst_0        
    //   37   73:bastore         
    //   38   74:return          
    }

    public void setCustomColour(Color c)
    {
        m_customColour = c;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #51  <Field Color m_customColour>
        if(c != null)
    //*   3    5:aload_1         
    //*   4    6:ifnull          17
            m_useCustomColour = true;
    //    5    9:aload_0         
    //    6   10:iconst_1        
    //    7   11:putfield        #49  <Field boolean m_useCustomColour>
        else
    //*   8   14:goto            22
            m_useCustomColour = false;
    //    9   17:aload_0         
    //   10   18:iconst_0        
    //   11   19:putfield        #49  <Field boolean m_useCustomColour>
    //   12   22:return          
    }

    public void setXindex(int x)
    {
        m_xIndex = x;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #61  <Field int m_xIndex>
        determineBounds();
    //    3    5:aload_0         
    //    4    6:invokespecial   #79  <Method void determineBounds()>
    //    5    9:return          
    }

    public void setYindex(int y)
    {
        m_yIndex = y;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #59  <Field int m_yIndex>
        determineBounds();
    //    3    5:aload_0         
    //    4    6:invokespecial   #79  <Method void determineBounds()>
    //    5    9:return          
    }

    public void setCindex(int c)
    {
        m_cIndex = c;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #57  <Field int m_cIndex>
        determineBounds();
    //    3    5:aload_0         
    //    4    6:invokespecial   #79  <Method void determineBounds()>
    //    5    9:return          
    }

    public int getXindex()
    {
        return m_xIndex;
    //    0    0:aload_0         
    //    1    1:getfield        #61  <Field int m_xIndex>
    //    2    4:ireturn         
    }

    public int getYindex()
    {
        return m_yIndex;
    //    0    0:aload_0         
    //    1    1:getfield        #59  <Field int m_yIndex>
    //    2    4:ireturn         
    }

    public int getCindex()
    {
        return m_cIndex;
    //    0    0:aload_0         
    //    1    1:getfield        #57  <Field int m_cIndex>
    //    2    4:ireturn         
    }

    private void determineBounds()
    {
        if(m_plotInstances != null && m_plotInstances.numAttributes() > 0 && m_plotInstances.numInstances() > 0)
    //*   0    0:aload_0         
    //*   1    1:getfield        #41  <Field Instances m_plotInstances>
    //*   2    4:ifnull          505
    //*   3    7:aload_0         
    //*   4    8:getfield        #41  <Field Instances m_plotInstances>
    //*   5   11:invokevirtual   #156 <Method int Instances.numAttributes()>
    //*   6   14:ifle            505
    //*   7   17:aload_0         
    //*   8   18:getfield        #41  <Field Instances m_plotInstances>
    //*   9   21:invokevirtual   #67  <Method int Instances.numInstances()>
    //*  10   24:ifle            505
        {
            double min = (1.0D / 0.0D);
    //   11   27:ldc2w           #157 <Double (1.0D / 0.0D)>
    //   12   30:dstore_3        
            double max = (-1.0D / 0.0D);
    //   13   31:ldc2w           #159 <Double (-1.0D / 0.0D)>
    //   14   34:dstore          5
            if(m_plotInstances.attribute(m_xIndex).isNominal())
    //*  15   36:aload_0         
    //*  16   37:getfield        #41  <Field Instances m_plotInstances>
    //*  17   40:aload_0         
    //*  18   41:getfield        #61  <Field int m_xIndex>
    //*  19   44:invokevirtual   #164 <Method Attribute Instances.attribute(int)>
    //*  20   47:invokevirtual   #169 <Method boolean Attribute.isNominal()>
    //*  21   50:ifeq            82
            {
                m_minX = 0.0D;
    //   22   53:aload_0         
    //   23   54:dconst_0        
    //   24   55:putfield        #171 <Field double m_minX>
                m_maxX = m_plotInstances.attribute(m_xIndex).numValues() - 1;
    //   25   58:aload_0         
    //   26   59:aload_0         
    //   27   60:getfield        #41  <Field Instances m_plotInstances>
    //   28   63:aload_0         
    //   29   64:getfield        #61  <Field int m_xIndex>
    //   30   67:invokevirtual   #164 <Method Attribute Instances.attribute(int)>
    //   31   70:invokevirtual   #174 <Method int Attribute.numValues()>
    //   32   73:iconst_1        
    //   33   74:isub            
    //   34   75:i2d             
    //   35   76:putfield        #176 <Field double m_maxX>
            } else
    //*  36   79:goto            212
            {
                for(int i = 0; i < m_plotInstances.numInstances(); i++)
    //*  37   82:iconst_0        
    //*  38   83:istore          7
    //*  39   85:goto            145
                    if(!m_plotInstances.instance(i).isMissing(m_xIndex))
    //*  40   88:aload_0         
    //*  41   89:getfield        #41  <Field Instances m_plotInstances>
    //*  42   92:iload           7
    //*  43   94:invokevirtual   #180 <Method Instance Instances.instance(int)>
    //*  44   97:aload_0         
    //*  45   98:getfield        #61  <Field int m_xIndex>
    //*  46  101:invokevirtual   #186 <Method boolean Instance.isMissing(int)>
    //*  47  104:ifne            142
                    {
                        double value = m_plotInstances.instance(i).value(m_xIndex);
    //   48  107:aload_0         
    //   49  108:getfield        #41  <Field Instances m_plotInstances>
    //   50  111:iload           7
    //   51  113:invokevirtual   #180 <Method Instance Instances.instance(int)>
    //   52  116:aload_0         
    //   53  117:getfield        #61  <Field int m_xIndex>
    //   54  120:invokevirtual   #190 <Method double Instance.value(int)>
    //   55  123:dstore_1        
                        if(value < min)
    //*  56  124:dload_1         
    //*  57  125:dload_3         
    //*  58  126:dcmpg           
    //*  59  127:ifge            132
                            min = value;
    //   60  130:dload_1         
    //   61  131:dstore_3        
                        if(value > max)
    //*  62  132:dload_1         
    //*  63  133:dload           5
    //*  64  135:dcmpl           
    //*  65  136:ifle            142
                            max = value;
    //   66  139:dload_1         
    //   67  140:dstore          5
                    }

    //   68  142:iinc            7  1
    //   69  145:iload           7
    //   70  147:aload_0         
    //   71  148:getfield        #41  <Field Instances m_plotInstances>
    //   72  151:invokevirtual   #67  <Method int Instances.numInstances()>
    //   73  154:icmplt          88
                if(min == (1.0D / 0.0D))
    //*  74  157:dload_3         
    //*  75  158:ldc2w           #157 <Double (1.0D / 0.0D)>
    //*  76  161:dcmpl           
    //*  77  162:ifne            170
                    min = max = 0.0D;
    //   78  165:dconst_0        
    //   79  166:dup2            
    //   80  167:dstore          5
    //   81  169:dstore_3        
                m_minX = min;
    //   82  170:aload_0         
    //   83  171:dload_3         
    //   84  172:putfield        #171 <Field double m_minX>
                m_maxX = max;
    //   85  175:aload_0         
    //   86  176:dload           5
    //   87  178:putfield        #176 <Field double m_maxX>
                if(min == max)
    //*  88  181:dload_3         
    //*  89  182:dload           5
    //*  90  184:dcmpl           
    //*  91  185:ifne            212
                {
                    m_maxX += 0.050000000000000003D;
    //   92  188:aload_0         
    //   93  189:dup             
    //   94  190:getfield        #176 <Field double m_maxX>
    //   95  193:ldc2w           #191 <Double 0.050000000000000003D>
    //   96  196:dadd            
    //   97  197:putfield        #176 <Field double m_maxX>
                    m_minX -= 0.050000000000000003D;
    //   98  200:aload_0         
    //   99  201:dup             
    //  100  202:getfield        #171 <Field double m_minX>
    //  101  205:ldc2w           #191 <Double 0.050000000000000003D>
    //  102  208:dsub            
    //  103  209:putfield        #171 <Field double m_minX>
                }
            }
            min = (1.0D / 0.0D);
    //  104  212:ldc2w           #157 <Double (1.0D / 0.0D)>
    //  105  215:dstore_3        
            max = (-1.0D / 0.0D);
    //  106  216:ldc2w           #159 <Double (-1.0D / 0.0D)>
    //  107  219:dstore          5
            if(m_plotInstances.attribute(m_yIndex).isNominal())
    //* 108  221:aload_0         
    //* 109  222:getfield        #41  <Field Instances m_plotInstances>
    //* 110  225:aload_0         
    //* 111  226:getfield        #59  <Field int m_yIndex>
    //* 112  229:invokevirtual   #164 <Method Attribute Instances.attribute(int)>
    //* 113  232:invokevirtual   #169 <Method boolean Attribute.isNominal()>
    //* 114  235:ifeq            267
            {
                m_minY = 0.0D;
    //  115  238:aload_0         
    //  116  239:dconst_0        
    //  117  240:putfield        #194 <Field double m_minY>
                m_maxY = m_plotInstances.attribute(m_yIndex).numValues() - 1;
    //  118  243:aload_0         
    //  119  244:aload_0         
    //  120  245:getfield        #41  <Field Instances m_plotInstances>
    //  121  248:aload_0         
    //  122  249:getfield        #59  <Field int m_yIndex>
    //  123  252:invokevirtual   #164 <Method Attribute Instances.attribute(int)>
    //  124  255:invokevirtual   #174 <Method int Attribute.numValues()>
    //  125  258:iconst_1        
    //  126  259:isub            
    //  127  260:i2d             
    //  128  261:putfield        #196 <Field double m_maxY>
            } else
    //* 129  264:goto            397
            {
                for(int i = 0; i < m_plotInstances.numInstances(); i++)
    //* 130  267:iconst_0        
    //* 131  268:istore          7
    //* 132  270:goto            330
                    if(!m_plotInstances.instance(i).isMissing(m_yIndex))
    //* 133  273:aload_0         
    //* 134  274:getfield        #41  <Field Instances m_plotInstances>
    //* 135  277:iload           7
    //* 136  279:invokevirtual   #180 <Method Instance Instances.instance(int)>
    //* 137  282:aload_0         
    //* 138  283:getfield        #59  <Field int m_yIndex>
    //* 139  286:invokevirtual   #186 <Method boolean Instance.isMissing(int)>
    //* 140  289:ifne            327
                    {
                        double value = m_plotInstances.instance(i).value(m_yIndex);
    //  141  292:aload_0         
    //  142  293:getfield        #41  <Field Instances m_plotInstances>
    //  143  296:iload           7
    //  144  298:invokevirtual   #180 <Method Instance Instances.instance(int)>
    //  145  301:aload_0         
    //  146  302:getfield        #59  <Field int m_yIndex>
    //  147  305:invokevirtual   #190 <Method double Instance.value(int)>
    //  148  308:dstore_1        
                        if(value < min)
    //* 149  309:dload_1         
    //* 150  310:dload_3         
    //* 151  311:dcmpg           
    //* 152  312:ifge            317
                            min = value;
    //  153  315:dload_1         
    //  154  316:dstore_3        
                        if(value > max)
    //* 155  317:dload_1         
    //* 156  318:dload           5
    //* 157  320:dcmpl           
    //* 158  321:ifle            327
                            max = value;
    //  159  324:dload_1         
    //  160  325:dstore          5
                    }

    //  161  327:iinc            7  1
    //  162  330:iload           7
    //  163  332:aload_0         
    //  164  333:getfield        #41  <Field Instances m_plotInstances>
    //  165  336:invokevirtual   #67  <Method int Instances.numInstances()>
    //  166  339:icmplt          273
                if(min == (1.0D / 0.0D))
    //* 167  342:dload_3         
    //* 168  343:ldc2w           #157 <Double (1.0D / 0.0D)>
    //* 169  346:dcmpl           
    //* 170  347:ifne            355
                    min = max = 0.0D;
    //  171  350:dconst_0        
    //  172  351:dup2            
    //  173  352:dstore          5
    //  174  354:dstore_3        
                m_minY = min;
    //  175  355:aload_0         
    //  176  356:dload_3         
    //  177  357:putfield        #194 <Field double m_minY>
                m_maxY = max;
    //  178  360:aload_0         
    //  179  361:dload           5
    //  180  363:putfield        #196 <Field double m_maxY>
                if(min == max)
    //* 181  366:dload_3         
    //* 182  367:dload           5
    //* 183  369:dcmpl           
    //* 184  370:ifne            397
                {
                    m_maxY += 0.050000000000000003D;
    //  185  373:aload_0         
    //  186  374:dup             
    //  187  375:getfield        #196 <Field double m_maxY>
    //  188  378:ldc2w           #191 <Double 0.050000000000000003D>
    //  189  381:dadd            
    //  190  382:putfield        #196 <Field double m_maxY>
                    m_minY -= 0.050000000000000003D;
    //  191  385:aload_0         
    //  192  386:dup             
    //  193  387:getfield        #194 <Field double m_minY>
    //  194  390:ldc2w           #191 <Double 0.050000000000000003D>
    //  195  393:dsub            
    //  196  394:putfield        #194 <Field double m_minY>
                }
            }
            min = (1.0D / 0.0D);
    //  197  397:ldc2w           #157 <Double (1.0D / 0.0D)>
    //  198  400:dstore_3        
            max = (-1.0D / 0.0D);
    //  199  401:ldc2w           #159 <Double (-1.0D / 0.0D)>
    //  200  404:dstore          5
            for(int i = 0; i < m_plotInstances.numInstances(); i++)
    //* 201  406:iconst_0        
    //* 202  407:istore          7
    //* 203  409:goto            469
                if(!m_plotInstances.instance(i).isMissing(m_cIndex))
    //* 204  412:aload_0         
    //* 205  413:getfield        #41  <Field Instances m_plotInstances>
    //* 206  416:iload           7
    //* 207  418:invokevirtual   #180 <Method Instance Instances.instance(int)>
    //* 208  421:aload_0         
    //* 209  422:getfield        #57  <Field int m_cIndex>
    //* 210  425:invokevirtual   #186 <Method boolean Instance.isMissing(int)>
    //* 211  428:ifne            466
                {
                    double value = m_plotInstances.instance(i).value(m_cIndex);
    //  212  431:aload_0         
    //  213  432:getfield        #41  <Field Instances m_plotInstances>
    //  214  435:iload           7
    //  215  437:invokevirtual   #180 <Method Instance Instances.instance(int)>
    //  216  440:aload_0         
    //  217  441:getfield        #57  <Field int m_cIndex>
    //  218  444:invokevirtual   #190 <Method double Instance.value(int)>
    //  219  447:dstore_1        
                    if(value < min)
    //* 220  448:dload_1         
    //* 221  449:dload_3         
    //* 222  450:dcmpg           
    //* 223  451:ifge            456
                        min = value;
    //  224  454:dload_1         
    //  225  455:dstore_3        
                    if(value > max)
    //* 226  456:dload_1         
    //* 227  457:dload           5
    //* 228  459:dcmpl           
    //* 229  460:ifle            466
                        max = value;
    //  230  463:dload_1         
    //  231  464:dstore          5
                }

    //  232  466:iinc            7  1
    //  233  469:iload           7
    //  234  471:aload_0         
    //  235  472:getfield        #41  <Field Instances m_plotInstances>
    //  236  475:invokevirtual   #67  <Method int Instances.numInstances()>
    //  237  478:icmplt          412
            if(min == (1.0D / 0.0D))
    //* 238  481:dload_3         
    //* 239  482:ldc2w           #157 <Double (1.0D / 0.0D)>
    //* 240  485:dcmpl           
    //* 241  486:ifne            494
                min = max = 0.0D;
    //  242  489:dconst_0        
    //  243  490:dup2            
    //  244  491:dstore          5
    //  245  493:dstore_3        
            m_minC = min;
    //  246  494:aload_0         
    //  247  495:dload_3         
    //  248  496:putfield        #198 <Field double m_minC>
            m_maxC = max;
    //  249  499:aload_0         
    //  250  500:dload           5
    //  251  502:putfield        #200 <Field double m_maxC>
        }
    //  252  505:return          
    }

    protected Instances m_plotInstances;
    protected String m_plotName;
    protected String m_plotNameHTML;
    public boolean m_useCustomColour;
    public Color m_customColour;
    public boolean m_displayAllPoints;
    public int m_alwaysDisplayPointsOfThisSize;
    protected double m_pointLookup[][];
    protected int m_shapeSize[];
    protected int m_shapeType[];
    protected boolean m_connectPoints[];
    private int m_xIndex;
    private int m_yIndex;
    private int m_cIndex;
    protected double m_maxX;
    protected double m_minX;
    protected double m_maxY;
    protected double m_minY;
    protected double m_maxC;
    protected double m_minC;
}
