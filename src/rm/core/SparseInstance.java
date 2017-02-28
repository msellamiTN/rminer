// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   SparseInstance.java

package rm.core;

import java.io.PrintStream;
import java.util.Enumeration;

// Referenced classes of package rm.core:
//            Instance, UnassignedDatasetException, Instances, Utils, 
//            Attribute, FastVector

public class SparseInstance extends Instance
{

    protected SparseInstance()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #13  <Method void Instance()>
    //    2    4:return          
    }

    public SparseInstance(Instance instance)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #13  <Method void Instance()>
        m_Weight = instance.m_Weight;
    //    2    4:aload_0         
    //    3    5:aload_1         
    //    4    6:getfield        #22  <Field double Instance.m_Weight>
    //    5    9:putfield        #23  <Field double m_Weight>
        m_Dataset = null;
    //    6   12:aload_0         
    //    7   13:aconst_null     
    //    8   14:putfield        #27  <Field Instances m_Dataset>
        m_NumAttributes = instance.numAttributes();
    //    9   17:aload_0         
    //   10   18:aload_1         
    //   11   19:invokevirtual   #31  <Method int Instance.numAttributes()>
    //   12   22:putfield        #33  <Field int m_NumAttributes>
        if(instance instanceof SparseInstance)
    //*  13   25:aload_1         
    //*  14   26:instanceof      #2   <Class SparseInstance>
    //*  15   29:ifeq            57
        {
            m_AttValues = ((SparseInstance)instance).m_AttValues;
    //   16   32:aload_0         
    //   17   33:aload_1         
    //   18   34:checkcast       #2   <Class SparseInstance>
    //   19   37:getfield        #37  <Field double[] m_AttValues>
    //   20   40:putfield        #37  <Field double[] m_AttValues>
            m_Indices = ((SparseInstance)instance).m_Indices;
    //   21   43:aload_0         
    //   22   44:aload_1         
    //   23   45:checkcast       #2   <Class SparseInstance>
    //   24   48:getfield        #39  <Field int[] m_Indices>
    //   25   51:putfield        #39  <Field int[] m_Indices>
        } else
    //*  26   54:goto            162
        {
            double tempValues[] = new double[instance.numAttributes()];
    //   27   57:aload_1         
    //   28   58:invokevirtual   #31  <Method int Instance.numAttributes()>
    //   29   61:newarray        double[]
    //   30   63:astore_2        
            int tempIndices[] = new int[instance.numAttributes()];
    //   31   64:aload_1         
    //   32   65:invokevirtual   #31  <Method int Instance.numAttributes()>
    //   33   68:newarray        int[]
    //   34   70:astore_3        
            int vals = 0;
    //   35   71:iconst_0        
    //   36   72:istore          4
            for(int i = 0; i < instance.numAttributes(); i++)
    //*  37   74:iconst_0        
    //*  38   75:istore          5
    //*  39   77:goto            113
                if(instance.value(i) != 0.0D)
    //*  40   80:aload_1         
    //*  41   81:iload           5
    //*  42   83:invokevirtual   #43  <Method double Instance.value(int)>
    //*  43   86:dconst_0        
    //*  44   87:dcmpl           
    //*  45   88:ifeq            110
                {
                    tempValues[vals] = instance.value(i);
    //   46   91:aload_2         
    //   47   92:iload           4
    //   48   94:aload_1         
    //   49   95:iload           5
    //   50   97:invokevirtual   #43  <Method double Instance.value(int)>
    //   51  100:dastore         
                    tempIndices[vals] = i;
    //   52  101:aload_3         
    //   53  102:iload           4
    //   54  104:iload           5
    //   55  106:iastore         
                    vals++;
    //   56  107:iinc            4  1
                }

    //   57  110:iinc            5  1
    //   58  113:iload           5
    //   59  115:aload_1         
    //   60  116:invokevirtual   #31  <Method int Instance.numAttributes()>
    //   61  119:icmplt          80
            m_AttValues = new double[vals];
    //   62  122:aload_0         
    //   63  123:iload           4
    //   64  125:newarray        double[]
    //   65  127:putfield        #37  <Field double[] m_AttValues>
            m_Indices = new int[vals];
    //   66  130:aload_0         
    //   67  131:iload           4
    //   68  133:newarray        int[]
    //   69  135:putfield        #39  <Field int[] m_Indices>
            System.arraycopy(tempValues, 0, m_AttValues, 0, vals);
    //   70  138:aload_2         
    //   71  139:iconst_0        
    //   72  140:aload_0         
    //   73  141:getfield        #37  <Field double[] m_AttValues>
    //   74  144:iconst_0        
    //   75  145:iload           4
    //   76  147:invokestatic    #49  <Method void System.arraycopy(Object, int, Object, int, int)>
            System.arraycopy(tempIndices, 0, m_Indices, 0, vals);
    //   77  150:aload_3         
    //   78  151:iconst_0        
    //   79  152:aload_0         
    //   80  153:getfield        #39  <Field int[] m_Indices>
    //   81  156:iconst_0        
    //   82  157:iload           4
    //   83  159:invokestatic    #49  <Method void System.arraycopy(Object, int, Object, int, int)>
        }
    //   84  162:return          
    }

    public SparseInstance(SparseInstance instance)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #13  <Method void Instance()>
        m_AttValues = instance.m_AttValues;
    //    2    4:aload_0         
    //    3    5:aload_1         
    //    4    6:getfield        #37  <Field double[] m_AttValues>
    //    5    9:putfield        #37  <Field double[] m_AttValues>
        m_Indices = instance.m_Indices;
    //    6   12:aload_0         
    //    7   13:aload_1         
    //    8   14:getfield        #39  <Field int[] m_Indices>
    //    9   17:putfield        #39  <Field int[] m_Indices>
        m_Weight = instance.m_Weight;
    //   10   20:aload_0         
    //   11   21:aload_1         
    //   12   22:getfield        #23  <Field double m_Weight>
    //   13   25:putfield        #23  <Field double m_Weight>
        m_NumAttributes = instance.m_NumAttributes;
    //   14   28:aload_0         
    //   15   29:aload_1         
    //   16   30:getfield        #33  <Field int m_NumAttributes>
    //   17   33:putfield        #33  <Field int m_NumAttributes>
        m_Dataset = null;
    //   18   36:aload_0         
    //   19   37:aconst_null     
    //   20   38:putfield        #27  <Field Instances m_Dataset>
    //   21   41:return          
    }

    public SparseInstance(double weight, double attValues[])
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #13  <Method void Instance()>
        m_Weight = weight;
    //    2    4:aload_0         
    //    3    5:dload_1         
    //    4    6:putfield        #23  <Field double m_Weight>
        m_Dataset = null;
    //    5    9:aload_0         
    //    6   10:aconst_null     
    //    7   11:putfield        #27  <Field Instances m_Dataset>
        m_NumAttributes = attValues.length;
    //    8   14:aload_0         
    //    9   15:aload_3         
    //   10   16:arraylength     
    //   11   17:putfield        #33  <Field int m_NumAttributes>
        double tempValues[] = new double[m_NumAttributes];
    //   12   20:aload_0         
    //   13   21:getfield        #33  <Field int m_NumAttributes>
    //   14   24:newarray        double[]
    //   15   26:astore          4
        int tempIndices[] = new int[m_NumAttributes];
    //   16   28:aload_0         
    //   17   29:getfield        #33  <Field int m_NumAttributes>
    //   18   32:newarray        int[]
    //   19   34:astore          5
        int vals = 0;
    //   20   36:iconst_0        
    //   21   37:istore          6
        for(int i = 0; i < m_NumAttributes; i++)
    //*  22   39:iconst_0        
    //*  23   40:istore          7
    //*  24   42:goto            76
            if(attValues[i] != 0.0D)
    //*  25   45:aload_3         
    //*  26   46:iload           7
    //*  27   48:daload          
    //*  28   49:dconst_0        
    //*  29   50:dcmpl           
    //*  30   51:ifeq            73
            {
                tempValues[vals] = attValues[i];
    //   31   54:aload           4
    //   32   56:iload           6
    //   33   58:aload_3         
    //   34   59:iload           7
    //   35   61:daload          
    //   36   62:dastore         
                tempIndices[vals] = i;
    //   37   63:aload           5
    //   38   65:iload           6
    //   39   67:iload           7
    //   40   69:iastore         
                vals++;
    //   41   70:iinc            6  1
            }

    //   42   73:iinc            7  1
    //   43   76:iload           7
    //   44   78:aload_0         
    //   45   79:getfield        #33  <Field int m_NumAttributes>
    //   46   82:icmplt          45
        m_AttValues = new double[vals];
    //   47   85:aload_0         
    //   48   86:iload           6
    //   49   88:newarray        double[]
    //   50   90:putfield        #37  <Field double[] m_AttValues>
        m_Indices = new int[vals];
    //   51   93:aload_0         
    //   52   94:iload           6
    //   53   96:newarray        int[]
    //   54   98:putfield        #39  <Field int[] m_Indices>
        System.arraycopy(tempValues, 0, m_AttValues, 0, vals);
    //   55  101:aload           4
    //   56  103:iconst_0        
    //   57  104:aload_0         
    //   58  105:getfield        #37  <Field double[] m_AttValues>
    //   59  108:iconst_0        
    //   60  109:iload           6
    //   61  111:invokestatic    #49  <Method void System.arraycopy(Object, int, Object, int, int)>
        System.arraycopy(tempIndices, 0, m_Indices, 0, vals);
    //   62  114:aload           5
    //   63  116:iconst_0        
    //   64  117:aload_0         
    //   65  118:getfield        #39  <Field int[] m_Indices>
    //   66  121:iconst_0        
    //   67  122:iload           6
    //   68  124:invokestatic    #49  <Method void System.arraycopy(Object, int, Object, int, int)>
    //   69  127:return          
    }

    public SparseInstance(double weight, double attValues[], int indices[], int maxNumValues)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #13  <Method void Instance()>
        int vals = 0;
    //    2    4:iconst_0        
    //    3    5:istore          6
        m_AttValues = new double[attValues.length];
    //    4    7:aload_0         
    //    5    8:aload_3         
    //    6    9:arraylength     
    //    7   10:newarray        double[]
    //    8   12:putfield        #37  <Field double[] m_AttValues>
        m_Indices = new int[indices.length];
    //    9   15:aload_0         
    //   10   16:aload           4
    //   11   18:arraylength     
    //   12   19:newarray        int[]
    //   13   21:putfield        #39  <Field int[] m_Indices>
        for(int i = 0; i < attValues.length; i++)
    //*  14   24:iconst_0        
    //*  15   25:istore          7
    //*  16   27:goto            68
            if(attValues[i] != 0.0D)
    //*  17   30:aload_3         
    //*  18   31:iload           7
    //*  19   33:daload          
    //*  20   34:dconst_0        
    //*  21   35:dcmpl           
    //*  22   36:ifeq            65
            {
                m_AttValues[vals] = attValues[i];
    //   23   39:aload_0         
    //   24   40:getfield        #37  <Field double[] m_AttValues>
    //   25   43:iload           6
    //   26   45:aload_3         
    //   27   46:iload           7
    //   28   48:daload          
    //   29   49:dastore         
                m_Indices[vals] = indices[i];
    //   30   50:aload_0         
    //   31   51:getfield        #39  <Field int[] m_Indices>
    //   32   54:iload           6
    //   33   56:aload           4
    //   34   58:iload           7
    //   35   60:iaload          
    //   36   61:iastore         
                vals++;
    //   37   62:iinc            6  1
            }

    //   38   65:iinc            7  1
    //   39   68:iload           7
    //   40   70:aload_3         
    //   41   71:arraylength     
    //   42   72:icmplt          30
        if(vals != attValues.length)
    //*  43   75:iload           6
    //*  44   77:aload_3         
    //*  45   78:arraylength     
    //*  46   79:icmpeq          132
        {
            double newVals[] = new double[vals];
    //   47   82:iload           6
    //   48   84:newarray        double[]
    //   49   86:astore          7
            System.arraycopy(m_AttValues, 0, newVals, 0, vals);
    //   50   88:aload_0         
    //   51   89:getfield        #37  <Field double[] m_AttValues>
    //   52   92:iconst_0        
    //   53   93:aload           7
    //   54   95:iconst_0        
    //   55   96:iload           6
    //   56   98:invokestatic    #49  <Method void System.arraycopy(Object, int, Object, int, int)>
            m_AttValues = newVals;
    //   57  101:aload_0         
    //   58  102:aload           7
    //   59  104:putfield        #37  <Field double[] m_AttValues>
            int newIndices[] = new int[vals];
    //   60  107:iload           6
    //   61  109:newarray        int[]
    //   62  111:astore          8
            System.arraycopy(m_Indices, 0, newIndices, 0, vals);
    //   63  113:aload_0         
    //   64  114:getfield        #39  <Field int[] m_Indices>
    //   65  117:iconst_0        
    //   66  118:aload           8
    //   67  120:iconst_0        
    //   68  121:iload           6
    //   69  123:invokestatic    #49  <Method void System.arraycopy(Object, int, Object, int, int)>
            m_Indices = newIndices;
    //   70  126:aload_0         
    //   71  127:aload           8
    //   72  129:putfield        #39  <Field int[] m_Indices>
        }
        m_Weight = weight;
    //   73  132:aload_0         
    //   74  133:dload_1         
    //   75  134:putfield        #23  <Field double m_Weight>
        m_NumAttributes = maxNumValues;
    //   76  137:aload_0         
    //   77  138:iload           5
    //   78  140:putfield        #33  <Field int m_NumAttributes>
        m_Dataset = null;
    //   79  143:aload_0         
    //   80  144:aconst_null     
    //   81  145:putfield        #27  <Field Instances m_Dataset>
    //   82  148:return          
    }

    public SparseInstance(int numAttributes)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #13  <Method void Instance()>
        m_AttValues = new double[numAttributes];
    //    2    4:aload_0         
    //    3    5:iload_1         
    //    4    6:newarray        double[]
    //    5    8:putfield        #37  <Field double[] m_AttValues>
        m_NumAttributes = numAttributes;
    //    6   11:aload_0         
    //    7   12:iload_1         
    //    8   13:putfield        #33  <Field int m_NumAttributes>
        m_Indices = new int[numAttributes];
    //    9   16:aload_0         
    //   10   17:iload_1         
    //   11   18:newarray        int[]
    //   12   20:putfield        #39  <Field int[] m_Indices>
        for(int i = 0; i < m_AttValues.length; i++)
    //*  13   23:iconst_0        
    //*  14   24:istore_2        
    //*  15   25:goto            47
        {
            m_AttValues[i] = (0.0D / 0.0D);
    //   16   28:aload_0         
    //   17   29:getfield        #37  <Field double[] m_AttValues>
    //   18   32:iload_2         
    //   19   33:ldc2w           #66  <Double (0.0D / 0.0D)>
    //   20   36:dastore         
            m_Indices[i] = i;
    //   21   37:aload_0         
    //   22   38:getfield        #39  <Field int[] m_Indices>
    //   23   41:iload_2         
    //   24   42:iload_2         
    //   25   43:iastore         
        }

    //   26   44:iinc            2  1
    //   27   47:iload_2         
    //   28   48:aload_0         
    //   29   49:getfield        #37  <Field double[] m_AttValues>
    //   30   52:arraylength     
    //   31   53:icmplt          28
        m_Weight = 1.0D;
    //   32   56:aload_0         
    //   33   57:dconst_1        
    //   34   58:putfield        #23  <Field double m_Weight>
        m_Dataset = null;
    //   35   61:aload_0         
    //   36   62:aconst_null     
    //   37   63:putfield        #27  <Field Instances m_Dataset>
    //   38   66:return          
    }

    public Attribute attributeSparse(int indexOfIndex)
    {
        if(m_Dataset == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #27  <Field Instances m_Dataset>
    //*   2    4:ifnonnull       17
            throw new UnassignedDatasetException("Instance doesn't have access to a dataset!");
    //    3    7:new             #71  <Class UnassignedDatasetException>
    //    4   10:dup             
    //    5   11:ldc1            #73  <String "Instance doesn't have access to a dataset!">
    //    6   13:invokespecial   #76  <Method void UnassignedDatasetException(String)>
    //    7   16:athrow          
        else
            return m_Dataset.attribute(m_Indices[indexOfIndex]);
    //    8   17:aload_0         
    //    9   18:getfield        #27  <Field Instances m_Dataset>
    //   10   21:aload_0         
    //   11   22:getfield        #39  <Field int[] m_Indices>
    //   12   25:iload_1         
    //   13   26:iaload          
    //   14   27:invokevirtual   #81  <Method Attribute Instances.attribute(int)>
    //   15   30:areturn         
    }

    public Object copy()
    {
        Instance result = new SparseInstance(this);
    //    0    0:new             #2   <Class SparseInstance>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:invokespecial   #86  <Method void SparseInstance(SparseInstance)>
    //    4    8:astore_1        
        result.m_Dataset = m_Dataset;
    //    5    9:aload_1         
    //    6   10:aload_0         
    //    7   11:getfield        #27  <Field Instances m_Dataset>
    //    8   14:putfield        #87  <Field Instances Instance.m_Dataset>
        return result;
    //    9   17:aload_1         
    //   10   18:areturn         
    }

    public int index(int position)
    {
        return m_Indices[position];
    //    0    0:aload_0         
    //    1    1:getfield        #39  <Field int[] m_Indices>
    //    2    4:iload_1         
    //    3    5:iaload          
    //    4    6:ireturn         
    }

    public boolean isMissing(int attIndex)
    {
        return Double.isNaN(value(attIndex));
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:invokevirtual   #94  <Method double value(int)>
    //    3    5:invokestatic    #100 <Method boolean Double.isNaN(double)>
    //    4    8:ifeq            13
    //    5   11:iconst_1        
    //    6   12:ireturn         
    //    7   13:iconst_0        
    //    8   14:ireturn         
    }

    public int locateIndex(int index)
    {
        int min = 0;
    //    0    0:iconst_0        
    //    1    1:istore_2        
        int max = m_Indices.length - 1;
    //    2    2:aload_0         
    //    3    3:getfield        #39  <Field int[] m_Indices>
    //    4    6:arraylength     
    //    5    7:iconst_1        
    //    6    8:isub            
    //    7    9:istore_3        
        if(max == -1)
    //*   8   10:iload_3         
    //*   9   11:iconst_m1       
    //*  10   12:icmpne          68
            return -1;
    //   11   15:iconst_m1       
    //   12   16:ireturn         
    //*  13   17:goto            68
        while(m_Indices[min] <= index && m_Indices[max] >= index) 
        {
            int current = (max + min) / 2;
    //   14   20:iload_3         
    //   15   21:iload_2         
    //   16   22:iadd            
    //   17   23:iconst_2        
    //   18   24:idiv            
    //   19   25:istore          4
            if(m_Indices[current] > index)
    //*  20   27:aload_0         
    //*  21   28:getfield        #39  <Field int[] m_Indices>
    //*  22   31:iload           4
    //*  23   33:iaload          
    //*  24   34:iload_1         
    //*  25   35:icmple          46
                max = current - 1;
    //   26   38:iload           4
    //   27   40:iconst_1        
    //   28   41:isub            
    //   29   42:istore_3        
            else
    //*  30   43:goto            68
            if(m_Indices[current] < index)
    //*  31   46:aload_0         
    //*  32   47:getfield        #39  <Field int[] m_Indices>
    //*  33   50:iload           4
    //*  34   52:iaload          
    //*  35   53:iload_1         
    //*  36   54:icmpge          65
                min = current + 1;
    //   37   57:iload           4
    //   38   59:iconst_1        
    //   39   60:iadd            
    //   40   61:istore_2        
            else
    //*  41   62:goto            68
                return current;
    //   42   65:iload           4
    //   43   67:ireturn         
        }
    //   44   68:aload_0         
    //   45   69:getfield        #39  <Field int[] m_Indices>
    //   46   72:iload_2         
    //   47   73:iaload          
    //   48   74:iload_1         
    //   49   75:icmpgt          88
    //   50   78:aload_0         
    //   51   79:getfield        #39  <Field int[] m_Indices>
    //   52   82:iload_3         
    //   53   83:iaload          
    //   54   84:iload_1         
    //   55   85:icmpge          20
        if(m_Indices[max] < index)
    //*  56   88:aload_0         
    //*  57   89:getfield        #39  <Field int[] m_Indices>
    //*  58   92:iload_3         
    //*  59   93:iaload          
    //*  60   94:iload_1         
    //*  61   95:icmpge          100
            return max;
    //   62   98:iload_3         
    //   63   99:ireturn         
        else
            return min - 1;
    //   64  100:iload_2         
    //   65  101:iconst_1        
    //   66  102:isub            
    //   67  103:ireturn         
    }

    public Instance mergeInstance(Instance inst)
    {
        double values[] = new double[numValues() + inst.numValues()];
    //    0    0:aload_0         
    //    1    1:invokevirtual   #110 <Method int numValues()>
    //    2    4:aload_1         
    //    3    5:invokevirtual   #111 <Method int Instance.numValues()>
    //    4    8:iadd            
    //    5    9:newarray        double[]
    //    6   11:astore_2        
        int indices[] = new int[numValues() + inst.numValues()];
    //    7   12:aload_0         
    //    8   13:invokevirtual   #110 <Method int numValues()>
    //    9   16:aload_1         
    //   10   17:invokevirtual   #111 <Method int Instance.numValues()>
    //   11   20:iadd            
    //   12   21:newarray        int[]
    //   13   23:astore_3        
        int m = 0;
    //   14   24:iconst_0        
    //   15   25:istore          4
        for(int j = 0; j < numValues();)
    //*  16   27:iconst_0        
    //*  17   28:istore          5
    //*  18   30:goto            59
        {
            values[m] = valueSparse(j);
    //   19   33:aload_2         
    //   20   34:iload           4
    //   21   36:aload_0         
    //   22   37:iload           5
    //   23   39:invokevirtual   #114 <Method double valueSparse(int)>
    //   24   42:dastore         
            indices[m] = index(j);
    //   25   43:aload_3         
    //   26   44:iload           4
    //   27   46:aload_0         
    //   28   47:iload           5
    //   29   49:invokevirtual   #116 <Method int index(int)>
    //   30   52:iastore         
            j++;
    //   31   53:iinc            5  1
            m++;
    //   32   56:iinc            4  1
        }

    //   33   59:iload           5
    //   34   61:aload_0         
    //   35   62:invokevirtual   #110 <Method int numValues()>
    //   36   65:icmplt          33
        for(int j = 0; j < inst.numValues();)
    //*  37   68:iconst_0        
    //*  38   69:istore          5
    //*  39   71:goto            105
        {
            values[m] = inst.valueSparse(j);
    //   40   74:aload_2         
    //   41   75:iload           4
    //   42   77:aload_1         
    //   43   78:iload           5
    //   44   80:invokevirtual   #117 <Method double Instance.valueSparse(int)>
    //   45   83:dastore         
            indices[m] = numAttributes() + inst.index(j);
    //   46   84:aload_3         
    //   47   85:iload           4
    //   48   87:aload_0         
    //   49   88:invokevirtual   #118 <Method int numAttributes()>
    //   50   91:aload_1         
    //   51   92:iload           5
    //   52   94:invokevirtual   #119 <Method int Instance.index(int)>
    //   53   97:iadd            
    //   54   98:iastore         
            j++;
    //   55   99:iinc            5  1
            m++;
    //   56  102:iinc            4  1
        }

    //   57  105:iload           5
    //   58  107:aload_1         
    //   59  108:invokevirtual   #111 <Method int Instance.numValues()>
    //   60  111:icmplt          74
        return new SparseInstance(1.0D, values, indices, numAttributes() + inst.numAttributes());
    //   61  114:new             #2   <Class SparseInstance>
    //   62  117:dup             
    //   63  118:dconst_1        
    //   64  119:aload_2         
    //   65  120:aload_3         
    //   66  121:aload_0         
    //   67  122:invokevirtual   #118 <Method int numAttributes()>
    //   68  125:aload_1         
    //   69  126:invokevirtual   #31  <Method int Instance.numAttributes()>
    //   70  129:iadd            
    //   71  130:invokespecial   #121 <Method void SparseInstance(double, double[], int[], int)>
    //   72  133:areturn         
    }

    public int numAttributes()
    {
        return m_NumAttributes;
    //    0    0:aload_0         
    //    1    1:getfield        #33  <Field int m_NumAttributes>
    //    2    4:ireturn         
    }

    public int numValues()
    {
        return m_Indices.length;
    //    0    0:aload_0         
    //    1    1:getfield        #39  <Field int[] m_Indices>
    //    2    4:arraylength     
    //    3    5:ireturn         
    }

    public void replaceMissingValues(double array[])
    {
        if(array == null || array.length != m_NumAttributes)
    //*   0    0:aload_1         
    //*   1    1:ifnull          13
    //*   2    4:aload_1         
    //*   3    5:arraylength     
    //*   4    6:aload_0         
    //*   5    7:getfield        #33  <Field int m_NumAttributes>
    //*   6   10:icmpeq          23
            throw new IllegalArgumentException("Unequal number of attributes!");
    //    7   13:new             #129 <Class IllegalArgumentException>
    //    8   16:dup             
    //    9   17:ldc1            #131 <String "Unequal number of attributes!">
    //   10   19:invokespecial   #132 <Method void IllegalArgumentException(String)>
    //   11   22:athrow          
        double tempValues[] = new double[m_AttValues.length];
    //   12   23:aload_0         
    //   13   24:getfield        #37  <Field double[] m_AttValues>
    //   14   27:arraylength     
    //   15   28:newarray        double[]
    //   16   30:astore_2        
        int tempIndices[] = new int[m_AttValues.length];
    //   17   31:aload_0         
    //   18   32:getfield        #37  <Field double[] m_AttValues>
    //   19   35:arraylength     
    //   20   36:newarray        int[]
    //   21   38:astore_3        
        int vals = 0;
    //   22   39:iconst_0        
    //   23   40:istore          4
        for(int i = 0; i < m_AttValues.length; i++)
    //*  24   42:iconst_0        
    //*  25   43:istore          5
    //*  26   45:goto            133
            if(Instance.isMissingValue(m_AttValues[i]))
    //*  27   48:aload_0         
    //*  28   49:getfield        #37  <Field double[] m_AttValues>
    //*  29   52:iload           5
    //*  30   54:daload          
    //*  31   55:invokestatic    #135 <Method boolean Instance.isMissingValue(double)>
    //*  32   58:ifeq            105
            {
                if(array[m_Indices[i]] != 0.0D)
    //*  33   61:aload_1         
    //*  34   62:aload_0         
    //*  35   63:getfield        #39  <Field int[] m_Indices>
    //*  36   66:iload           5
    //*  37   68:iaload          
    //*  38   69:daload          
    //*  39   70:dconst_0        
    //*  40   71:dcmpl           
    //*  41   72:ifeq            130
                {
                    tempValues[vals] = array[m_Indices[i]];
    //   42   75:aload_2         
    //   43   76:iload           4
    //   44   78:aload_1         
    //   45   79:aload_0         
    //   46   80:getfield        #39  <Field int[] m_Indices>
    //   47   83:iload           5
    //   48   85:iaload          
    //   49   86:daload          
    //   50   87:dastore         
                    tempIndices[vals] = m_Indices[i];
    //   51   88:aload_3         
    //   52   89:iload           4
    //   53   91:aload_0         
    //   54   92:getfield        #39  <Field int[] m_Indices>
    //   55   95:iload           5
    //   56   97:iaload          
    //   57   98:iastore         
                    vals++;
    //   58   99:iinc            4  1
                }
            } else
    //*  59  102:goto            130
            {
                tempValues[vals] = m_AttValues[i];
    //   60  105:aload_2         
    //   61  106:iload           4
    //   62  108:aload_0         
    //   63  109:getfield        #37  <Field double[] m_AttValues>
    //   64  112:iload           5
    //   65  114:daload          
    //   66  115:dastore         
                tempIndices[vals] = m_Indices[i];
    //   67  116:aload_3         
    //   68  117:iload           4
    //   69  119:aload_0         
    //   70  120:getfield        #39  <Field int[] m_Indices>
    //   71  123:iload           5
    //   72  125:iaload          
    //   73  126:iastore         
                vals++;
    //   74  127:iinc            4  1
            }

    //   75  130:iinc            5  1
    //   76  133:iload           5
    //   77  135:aload_0         
    //   78  136:getfield        #37  <Field double[] m_AttValues>
    //   79  139:arraylength     
    //   80  140:icmplt          48
        m_AttValues = new double[vals];
    //   81  143:aload_0         
    //   82  144:iload           4
    //   83  146:newarray        double[]
    //   84  148:putfield        #37  <Field double[] m_AttValues>
        m_Indices = new int[vals];
    //   85  151:aload_0         
    //   86  152:iload           4
    //   87  154:newarray        int[]
    //   88  156:putfield        #39  <Field int[] m_Indices>
        System.arraycopy(tempValues, 0, m_AttValues, 0, vals);
    //   89  159:aload_2         
    //   90  160:iconst_0        
    //   91  161:aload_0         
    //   92  162:getfield        #37  <Field double[] m_AttValues>
    //   93  165:iconst_0        
    //   94  166:iload           4
    //   95  168:invokestatic    #49  <Method void System.arraycopy(Object, int, Object, int, int)>
        System.arraycopy(tempIndices, 0, m_Indices, 0, vals);
    //   96  171:aload_3         
    //   97  172:iconst_0        
    //   98  173:aload_0         
    //   99  174:getfield        #39  <Field int[] m_Indices>
    //  100  177:iconst_0        
    //  101  178:iload           4
    //  102  180:invokestatic    #49  <Method void System.arraycopy(Object, int, Object, int, int)>
    //  103  183:return          
    }

    public void setValue(int attIndex, double value)
    {
        int index = locateIndex(attIndex);
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:invokevirtual   #140 <Method int locateIndex(int)>
    //    3    5:istore          4
        if(index >= 0 && m_Indices[index] == attIndex)
    //*   4    7:iload           4
    //*   5    9:iflt            182
    //*   6   12:aload_0         
    //*   7   13:getfield        #39  <Field int[] m_Indices>
    //*   8   16:iload           4
    //*   9   18:iaload          
    //*  10   19:iload_1         
    //*  11   20:icmpne          182
        {
            if(value != 0.0D)
    //*  12   23:dload_2         
    //*  13   24:dconst_0        
    //*  14   25:dcmpl           
    //*  15   26:ifeq            69
            {
                double tempValues[] = new double[m_AttValues.length];
    //   16   29:aload_0         
    //   17   30:getfield        #37  <Field double[] m_AttValues>
    //   18   33:arraylength     
    //   19   34:newarray        double[]
    //   20   36:astore          5
                System.arraycopy(m_AttValues, 0, tempValues, 0, m_AttValues.length);
    //   21   38:aload_0         
    //   22   39:getfield        #37  <Field double[] m_AttValues>
    //   23   42:iconst_0        
    //   24   43:aload           5
    //   25   45:iconst_0        
    //   26   46:aload_0         
    //   27   47:getfield        #37  <Field double[] m_AttValues>
    //   28   50:arraylength     
    //   29   51:invokestatic    #49  <Method void System.arraycopy(Object, int, Object, int, int)>
                tempValues[index] = value;
    //   30   54:aload           5
    //   31   56:iload           4
    //   32   58:dload_2         
    //   33   59:dastore         
                m_AttValues = tempValues;
    //   34   60:aload_0         
    //   35   61:aload           5
    //   36   63:putfield        #37  <Field double[] m_AttValues>
            } else
    //*  37   66:goto            322
            {
                double tempValues[] = new double[m_AttValues.length - 1];
    //   38   69:aload_0         
    //   39   70:getfield        #37  <Field double[] m_AttValues>
    //   40   73:arraylength     
    //   41   74:iconst_1        
    //   42   75:isub            
    //   43   76:newarray        double[]
    //   44   78:astore          5
                int tempIndices[] = new int[m_Indices.length - 1];
    //   45   80:aload_0         
    //   46   81:getfield        #39  <Field int[] m_Indices>
    //   47   84:arraylength     
    //   48   85:iconst_1        
    //   49   86:isub            
    //   50   87:newarray        int[]
    //   51   89:astore          6
                System.arraycopy(m_AttValues, 0, tempValues, 0, index);
    //   52   91:aload_0         
    //   53   92:getfield        #37  <Field double[] m_AttValues>
    //   54   95:iconst_0        
    //   55   96:aload           5
    //   56   98:iconst_0        
    //   57   99:iload           4
    //   58  101:invokestatic    #49  <Method void System.arraycopy(Object, int, Object, int, int)>
                System.arraycopy(m_Indices, 0, tempIndices, 0, index);
    //   59  104:aload_0         
    //   60  105:getfield        #39  <Field int[] m_Indices>
    //   61  108:iconst_0        
    //   62  109:aload           6
    //   63  111:iconst_0        
    //   64  112:iload           4
    //   65  114:invokestatic    #49  <Method void System.arraycopy(Object, int, Object, int, int)>
                System.arraycopy(m_AttValues, index + 1, tempValues, index, m_AttValues.length - index - 1);
    //   66  117:aload_0         
    //   67  118:getfield        #37  <Field double[] m_AttValues>
    //   68  121:iload           4
    //   69  123:iconst_1        
    //   70  124:iadd            
    //   71  125:aload           5
    //   72  127:iload           4
    //   73  129:aload_0         
    //   74  130:getfield        #37  <Field double[] m_AttValues>
    //   75  133:arraylength     
    //   76  134:iload           4
    //   77  136:isub            
    //   78  137:iconst_1        
    //   79  138:isub            
    //   80  139:invokestatic    #49  <Method void System.arraycopy(Object, int, Object, int, int)>
                System.arraycopy(m_Indices, index + 1, tempIndices, index, m_Indices.length - index - 1);
    //   81  142:aload_0         
    //   82  143:getfield        #39  <Field int[] m_Indices>
    //   83  146:iload           4
    //   84  148:iconst_1        
    //   85  149:iadd            
    //   86  150:aload           6
    //   87  152:iload           4
    //   88  154:aload_0         
    //   89  155:getfield        #39  <Field int[] m_Indices>
    //   90  158:arraylength     
    //   91  159:iload           4
    //   92  161:isub            
    //   93  162:iconst_1        
    //   94  163:isub            
    //   95  164:invokestatic    #49  <Method void System.arraycopy(Object, int, Object, int, int)>
                m_AttValues = tempValues;
    //   96  167:aload_0         
    //   97  168:aload           5
    //   98  170:putfield        #37  <Field double[] m_AttValues>
                m_Indices = tempIndices;
    //   99  173:aload_0         
    //  100  174:aload           6
    //  101  176:putfield        #39  <Field int[] m_Indices>
            }
        } else
    //* 102  179:goto            322
        if(value != 0.0D)
    //* 103  182:dload_2         
    //* 104  183:dconst_0        
    //* 105  184:dcmpl           
    //* 106  185:ifeq            322
        {
            double tempValues[] = new double[m_AttValues.length + 1];
    //  107  188:aload_0         
    //  108  189:getfield        #37  <Field double[] m_AttValues>
    //  109  192:arraylength     
    //  110  193:iconst_1        
    //  111  194:iadd            
    //  112  195:newarray        double[]
    //  113  197:astore          5
            int tempIndices[] = new int[m_Indices.length + 1];
    //  114  199:aload_0         
    //  115  200:getfield        #39  <Field int[] m_Indices>
    //  116  203:arraylength     
    //  117  204:iconst_1        
    //  118  205:iadd            
    //  119  206:newarray        int[]
    //  120  208:astore          6
            System.arraycopy(m_AttValues, 0, tempValues, 0, index + 1);
    //  121  210:aload_0         
    //  122  211:getfield        #37  <Field double[] m_AttValues>
    //  123  214:iconst_0        
    //  124  215:aload           5
    //  125  217:iconst_0        
    //  126  218:iload           4
    //  127  220:iconst_1        
    //  128  221:iadd            
    //  129  222:invokestatic    #49  <Method void System.arraycopy(Object, int, Object, int, int)>
            System.arraycopy(m_Indices, 0, tempIndices, 0, index + 1);
    //  130  225:aload_0         
    //  131  226:getfield        #39  <Field int[] m_Indices>
    //  132  229:iconst_0        
    //  133  230:aload           6
    //  134  232:iconst_0        
    //  135  233:iload           4
    //  136  235:iconst_1        
    //  137  236:iadd            
    //  138  237:invokestatic    #49  <Method void System.arraycopy(Object, int, Object, int, int)>
            tempIndices[index + 1] = attIndex;
    //  139  240:aload           6
    //  140  242:iload           4
    //  141  244:iconst_1        
    //  142  245:iadd            
    //  143  246:iload_1         
    //  144  247:iastore         
            tempValues[index + 1] = value;
    //  145  248:aload           5
    //  146  250:iload           4
    //  147  252:iconst_1        
    //  148  253:iadd            
    //  149  254:dload_2         
    //  150  255:dastore         
            System.arraycopy(m_AttValues, index + 1, tempValues, index + 2, m_AttValues.length - index - 1);
    //  151  256:aload_0         
    //  152  257:getfield        #37  <Field double[] m_AttValues>
    //  153  260:iload           4
    //  154  262:iconst_1        
    //  155  263:iadd            
    //  156  264:aload           5
    //  157  266:iload           4
    //  158  268:iconst_2        
    //  159  269:iadd            
    //  160  270:aload_0         
    //  161  271:getfield        #37  <Field double[] m_AttValues>
    //  162  274:arraylength     
    //  163  275:iload           4
    //  164  277:isub            
    //  165  278:iconst_1        
    //  166  279:isub            
    //  167  280:invokestatic    #49  <Method void System.arraycopy(Object, int, Object, int, int)>
            System.arraycopy(m_Indices, index + 1, tempIndices, index + 2, m_Indices.length - index - 1);
    //  168  283:aload_0         
    //  169  284:getfield        #39  <Field int[] m_Indices>
    //  170  287:iload           4
    //  171  289:iconst_1        
    //  172  290:iadd            
    //  173  291:aload           6
    //  174  293:iload           4
    //  175  295:iconst_2        
    //  176  296:iadd            
    //  177  297:aload_0         
    //  178  298:getfield        #39  <Field int[] m_Indices>
    //  179  301:arraylength     
    //  180  302:iload           4
    //  181  304:isub            
    //  182  305:iconst_1        
    //  183  306:isub            
    //  184  307:invokestatic    #49  <Method void System.arraycopy(Object, int, Object, int, int)>
            m_AttValues = tempValues;
    //  185  310:aload_0         
    //  186  311:aload           5
    //  187  313:putfield        #37  <Field double[] m_AttValues>
            m_Indices = tempIndices;
    //  188  316:aload_0         
    //  189  317:aload           6
    //  190  319:putfield        #39  <Field int[] m_Indices>
        }
    //  191  322:return          
    }

    public void setValueSparse(int indexOfIndex, double value)
    {
        if(value != 0.0D)
    //*   0    0:dload_2         
    //*   1    1:dconst_0        
    //*   2    2:dcmpl           
    //*   3    3:ifeq            47
        {
            double tempValues[] = new double[m_AttValues.length];
    //    4    6:aload_0         
    //    5    7:getfield        #37  <Field double[] m_AttValues>
    //    6   10:arraylength     
    //    7   11:newarray        double[]
    //    8   13:astore          4
            System.arraycopy(m_AttValues, 0, tempValues, 0, m_AttValues.length);
    //    9   15:aload_0         
    //   10   16:getfield        #37  <Field double[] m_AttValues>
    //   11   19:iconst_0        
    //   12   20:aload           4
    //   13   22:iconst_0        
    //   14   23:aload_0         
    //   15   24:getfield        #37  <Field double[] m_AttValues>
    //   16   27:arraylength     
    //   17   28:invokestatic    #49  <Method void System.arraycopy(Object, int, Object, int, int)>
            m_AttValues = tempValues;
    //   18   31:aload_0         
    //   19   32:aload           4
    //   20   34:putfield        #37  <Field double[] m_AttValues>
            m_AttValues[indexOfIndex] = value;
    //   21   37:aload_0         
    //   22   38:getfield        #37  <Field double[] m_AttValues>
    //   23   41:iload_1         
    //   24   42:dload_2         
    //   25   43:dastore         
        } else
    //*  26   44:goto            149
        {
            double tempValues[] = new double[m_AttValues.length - 1];
    //   27   47:aload_0         
    //   28   48:getfield        #37  <Field double[] m_AttValues>
    //   29   51:arraylength     
    //   30   52:iconst_1        
    //   31   53:isub            
    //   32   54:newarray        double[]
    //   33   56:astore          4
            int tempIndices[] = new int[m_Indices.length - 1];
    //   34   58:aload_0         
    //   35   59:getfield        #39  <Field int[] m_Indices>
    //   36   62:arraylength     
    //   37   63:iconst_1        
    //   38   64:isub            
    //   39   65:newarray        int[]
    //   40   67:astore          5
            System.arraycopy(m_AttValues, 0, tempValues, 0, indexOfIndex);
    //   41   69:aload_0         
    //   42   70:getfield        #37  <Field double[] m_AttValues>
    //   43   73:iconst_0        
    //   44   74:aload           4
    //   45   76:iconst_0        
    //   46   77:iload_1         
    //   47   78:invokestatic    #49  <Method void System.arraycopy(Object, int, Object, int, int)>
            System.arraycopy(m_Indices, 0, tempIndices, 0, indexOfIndex);
    //   48   81:aload_0         
    //   49   82:getfield        #39  <Field int[] m_Indices>
    //   50   85:iconst_0        
    //   51   86:aload           5
    //   52   88:iconst_0        
    //   53   89:iload_1         
    //   54   90:invokestatic    #49  <Method void System.arraycopy(Object, int, Object, int, int)>
            System.arraycopy(m_AttValues, indexOfIndex + 1, tempValues, indexOfIndex, m_AttValues.length - indexOfIndex - 1);
    //   55   93:aload_0         
    //   56   94:getfield        #37  <Field double[] m_AttValues>
    //   57   97:iload_1         
    //   58   98:iconst_1        
    //   59   99:iadd            
    //   60  100:aload           4
    //   61  102:iload_1         
    //   62  103:aload_0         
    //   63  104:getfield        #37  <Field double[] m_AttValues>
    //   64  107:arraylength     
    //   65  108:iload_1         
    //   66  109:isub            
    //   67  110:iconst_1        
    //   68  111:isub            
    //   69  112:invokestatic    #49  <Method void System.arraycopy(Object, int, Object, int, int)>
            System.arraycopy(m_Indices, indexOfIndex + 1, tempIndices, indexOfIndex, m_Indices.length - indexOfIndex - 1);
    //   70  115:aload_0         
    //   71  116:getfield        #39  <Field int[] m_Indices>
    //   72  119:iload_1         
    //   73  120:iconst_1        
    //   74  121:iadd            
    //   75  122:aload           5
    //   76  124:iload_1         
    //   77  125:aload_0         
    //   78  126:getfield        #39  <Field int[] m_Indices>
    //   79  129:arraylength     
    //   80  130:iload_1         
    //   81  131:isub            
    //   82  132:iconst_1        
    //   83  133:isub            
    //   84  134:invokestatic    #49  <Method void System.arraycopy(Object, int, Object, int, int)>
            m_AttValues = tempValues;
    //   85  137:aload_0         
    //   86  138:aload           4
    //   87  140:putfield        #37  <Field double[] m_AttValues>
            m_Indices = tempIndices;
    //   88  143:aload_0         
    //   89  144:aload           5
    //   90  146:putfield        #39  <Field int[] m_Indices>
        }
    //   91  149:return          
    }

    public double[] toDoubleArray()
    {
        double newValues[] = new double[m_NumAttributes];
    //    0    0:aload_0         
    //    1    1:getfield        #33  <Field int m_NumAttributes>
    //    2    4:newarray        double[]
    //    3    6:astore_1        
        for(int i = 0; i < m_AttValues.length; i++)
    //*   4    7:iconst_0        
    //*   5    8:istore_2        
    //*   6    9:goto            29
            newValues[m_Indices[i]] = m_AttValues[i];
    //    7   12:aload_1         
    //    8   13:aload_0         
    //    9   14:getfield        #39  <Field int[] m_Indices>
    //   10   17:iload_2         
    //   11   18:iaload          
    //   12   19:aload_0         
    //   13   20:getfield        #37  <Field double[] m_AttValues>
    //   14   23:iload_2         
    //   15   24:daload          
    //   16   25:dastore         

    //   17   26:iinc            2  1
    //   18   29:iload_2         
    //   19   30:aload_0         
    //   20   31:getfield        #37  <Field double[] m_AttValues>
    //   21   34:arraylength     
    //   22   35:icmplt          12
        return newValues;
    //   23   38:aload_1         
    //   24   39:areturn         
    }

    public String toString()
    {
        StringBuffer text = new StringBuffer();
    //    0    0:new             #148 <Class StringBuffer>
    //    1    3:dup             
    //    2    4:invokespecial   #149 <Method void StringBuffer()>
    //    3    7:astore_1        
        text.append('{');
    //    4    8:aload_1         
    //    5    9:bipush          123
    //    6   11:invokevirtual   #153 <Method StringBuffer StringBuffer.append(char)>
    //    7   14:pop             
        for(int i = 0; i < m_Indices.length; i++)
    //*   8   15:iconst_0        
    //*   9   16:istore_2        
    //*  10   17:goto            513
        {
            if(i > 0)
    //*  11   20:iload_2         
    //*  12   21:ifle            31
                text.append(",");
    //   13   24:aload_1         
    //   14   25:ldc1            #155 <String ",">
    //   15   27:invokevirtual   #158 <Method StringBuffer StringBuffer.append(String)>
    //   16   30:pop             
            if(Instance.isMissingValue(m_AttValues[i]))
    //*  17   31:aload_0         
    //*  18   32:getfield        #37  <Field double[] m_AttValues>
    //*  19   35:iload_2         
    //*  20   36:daload          
    //*  21   37:invokestatic    #135 <Method boolean Instance.isMissingValue(double)>
    //*  22   40:ifeq            75
                text.append((new StringBuilder(String.valueOf(m_Indices[i]))).append(" ?").toString());
    //   23   43:aload_1         
    //   24   44:new             #160 <Class StringBuilder>
    //   25   47:dup             
    //   26   48:aload_0         
    //   27   49:getfield        #39  <Field int[] m_Indices>
    //   28   52:iload_2         
    //   29   53:iaload          
    //   30   54:invokestatic    #166 <Method String String.valueOf(int)>
    //   31   57:invokespecial   #167 <Method void StringBuilder(String)>
    //   32   60:ldc1            #169 <String " ?">
    //   33   62:invokevirtual   #172 <Method StringBuilder StringBuilder.append(String)>
    //   34   65:invokevirtual   #174 <Method String StringBuilder.toString()>
    //   35   68:invokevirtual   #158 <Method StringBuffer StringBuffer.append(String)>
    //   36   71:pop             
            else
    //*  37   72:goto            510
            if(m_Dataset == null)
    //*  38   75:aload_0         
    //*  39   76:getfield        #27  <Field Instances m_Dataset>
    //*  40   79:ifnonnull       128
                text.append((new StringBuilder(String.valueOf(m_Indices[i]))).append(" ").append(Utils.doubleToString(m_AttValues[i], 6)).toString());
    //   41   82:aload_1         
    //   42   83:new             #160 <Class StringBuilder>
    //   43   86:dup             
    //   44   87:aload_0         
    //   45   88:getfield        #39  <Field int[] m_Indices>
    //   46   91:iload_2         
    //   47   92:iaload          
    //   48   93:invokestatic    #166 <Method String String.valueOf(int)>
    //   49   96:invokespecial   #167 <Method void StringBuilder(String)>
    //   50   99:ldc1            #176 <String " ">
    //   51  101:invokevirtual   #172 <Method StringBuilder StringBuilder.append(String)>
    //   52  104:aload_0         
    //   53  105:getfield        #37  <Field double[] m_AttValues>
    //   54  108:iload_2         
    //   55  109:daload          
    //   56  110:bipush          6
    //   57  112:invokestatic    #182 <Method String Utils.doubleToString(double, int)>
    //   58  115:invokevirtual   #172 <Method StringBuilder StringBuilder.append(String)>
    //   59  118:invokevirtual   #174 <Method String StringBuilder.toString()>
    //   60  121:invokevirtual   #158 <Method StringBuffer StringBuffer.append(String)>
    //   61  124:pop             
            else
    //*  62  125:goto            510
            if(m_Dataset.attribute(m_Indices[i]).isNominal() || m_Dataset.attribute(m_Indices[i]).isString() || m_Dataset.attribute(m_Indices[i]).isDate())
    //*  63  128:aload_0         
    //*  64  129:getfield        #27  <Field Instances m_Dataset>
    //*  65  132:aload_0         
    //*  66  133:getfield        #39  <Field int[] m_Indices>
    //*  67  136:iload_2         
    //*  68  137:iaload          
    //*  69  138:invokevirtual   #81  <Method Attribute Instances.attribute(int)>
    //*  70  141:invokevirtual   #188 <Method boolean Attribute.isNominal()>
    //*  71  144:ifne            185
    //*  72  147:aload_0         
    //*  73  148:getfield        #27  <Field Instances m_Dataset>
    //*  74  151:aload_0         
    //*  75  152:getfield        #39  <Field int[] m_Indices>
    //*  76  155:iload_2         
    //*  77  156:iaload          
    //*  78  157:invokevirtual   #81  <Method Attribute Instances.attribute(int)>
    //*  79  160:invokevirtual   #191 <Method boolean Attribute.isString()>
    //*  80  163:ifne            185
    //*  81  166:aload_0         
    //*  82  167:getfield        #27  <Field Instances m_Dataset>
    //*  83  170:aload_0         
    //*  84  171:getfield        #39  <Field int[] m_Indices>
    //*  85  174:iload_2         
    //*  86  175:iaload          
    //*  87  176:invokevirtual   #81  <Method Attribute Instances.attribute(int)>
    //*  88  179:invokevirtual   #194 <Method boolean Attribute.isDate()>
    //*  89  182:ifeq            309
                try
                {
                    text.append((new StringBuilder(String.valueOf(m_Indices[i]))).append(" ").append(Utils.quote(stringValue(m_Indices[i]))).toString());
    //   90  185:aload_1         
    //   91  186:new             #160 <Class StringBuilder>
    //   92  189:dup             
    //   93  190:aload_0         
    //   94  191:getfield        #39  <Field int[] m_Indices>
    //   95  194:iload_2         
    //   96  195:iaload          
    //   97  196:invokestatic    #166 <Method String String.valueOf(int)>
    //   98  199:invokespecial   #167 <Method void StringBuilder(String)>
    //   99  202:ldc1            #176 <String " ">
    //  100  204:invokevirtual   #172 <Method StringBuilder StringBuilder.append(String)>
    //  101  207:aload_0         
    //  102  208:aload_0         
    //  103  209:getfield        #39  <Field int[] m_Indices>
    //  104  212:iload_2         
    //  105  213:iaload          
    //  106  214:invokevirtual   #197 <Method String stringValue(int)>
    //  107  217:invokestatic    #201 <Method String Utils.quote(String)>
    //  108  220:invokevirtual   #172 <Method StringBuilder StringBuilder.append(String)>
    //  109  223:invokevirtual   #174 <Method String StringBuilder.toString()>
    //  110  226:invokevirtual   #158 <Method StringBuffer StringBuffer.append(String)>
    //  111  229:pop             
                }
    //* 112  230:goto            510
                catch(Exception e)
    //* 113  233:astore_3        
                {
                    e.printStackTrace();
    //  114  234:aload_3         
    //  115  235:invokevirtual   #206 <Method void Exception.printStackTrace()>
                    System.err.println(new Instances(m_Dataset, 0));
    //  116  238:getstatic       #210 <Field PrintStream System.err>
    //  117  241:new             #78  <Class Instances>
    //  118  244:dup             
    //  119  245:aload_0         
    //  120  246:getfield        #27  <Field Instances m_Dataset>
    //  121  249:iconst_0        
    //  122  250:invokespecial   #213 <Method void Instances(Instances, int)>
    //  123  253:invokevirtual   #219 <Method void PrintStream.println(Object)>
                    System.err.println((new StringBuilder("Att:")).append(m_Indices[i]).append(" Val:").append(valueSparse(i)).toString());
    //  124  256:getstatic       #210 <Field PrintStream System.err>
    //  125  259:new             #160 <Class StringBuilder>
    //  126  262:dup             
    //  127  263:ldc1            #221 <String "Att:">
    //  128  265:invokespecial   #167 <Method void StringBuilder(String)>
    //  129  268:aload_0         
    //  130  269:getfield        #39  <Field int[] m_Indices>
    //  131  272:iload_2         
    //  132  273:iaload          
    //  133  274:invokevirtual   #224 <Method StringBuilder StringBuilder.append(int)>
    //  134  277:ldc1            #226 <String " Val:">
    //  135  279:invokevirtual   #172 <Method StringBuilder StringBuilder.append(String)>
    //  136  282:aload_0         
    //  137  283:iload_2         
    //  138  284:invokevirtual   #114 <Method double valueSparse(int)>
    //  139  287:invokevirtual   #229 <Method StringBuilder StringBuilder.append(double)>
    //  140  290:invokevirtual   #174 <Method String StringBuilder.toString()>
    //  141  293:invokevirtual   #231 <Method void PrintStream.println(String)>
                    throw new Error("This should never happen!");
    //  142  296:new             #233 <Class Error>
    //  143  299:dup             
    //  144  300:ldc1            #235 <String "This should never happen!">
    //  145  302:invokespecial   #236 <Method void Error(String)>
    //  146  305:athrow          
                }
            else
    //* 147  306:goto            510
            if(m_Dataset.attribute(m_Indices[i]).isRelationValued())
    //* 148  309:aload_0         
    //* 149  310:getfield        #27  <Field Instances m_Dataset>
    //* 150  313:aload_0         
    //* 151  314:getfield        #39  <Field int[] m_Indices>
    //* 152  317:iload_2         
    //* 153  318:iaload          
    //* 154  319:invokevirtual   #81  <Method Attribute Instances.attribute(int)>
    //* 155  322:invokevirtual   #239 <Method boolean Attribute.isRelationValued()>
    //* 156  325:ifeq            467
                try
                {
                    text.append((new StringBuilder(String.valueOf(m_Indices[i]))).append(" ").append(Utils.quote(m_Dataset.attribute(m_Indices[i]).relation((int)valueSparse(i)).stringWithoutHeader())).toString());
    //  157  328:aload_1         
    //  158  329:new             #160 <Class StringBuilder>
    //  159  332:dup             
    //  160  333:aload_0         
    //  161  334:getfield        #39  <Field int[] m_Indices>
    //  162  337:iload_2         
    //  163  338:iaload          
    //  164  339:invokestatic    #166 <Method String String.valueOf(int)>
    //  165  342:invokespecial   #167 <Method void StringBuilder(String)>
    //  166  345:ldc1            #176 <String " ">
    //  167  347:invokevirtual   #172 <Method StringBuilder StringBuilder.append(String)>
    //  168  350:aload_0         
    //  169  351:getfield        #27  <Field Instances m_Dataset>
    //  170  354:aload_0         
    //  171  355:getfield        #39  <Field int[] m_Indices>
    //  172  358:iload_2         
    //  173  359:iaload          
    //  174  360:invokevirtual   #81  <Method Attribute Instances.attribute(int)>
    //  175  363:aload_0         
    //  176  364:iload_2         
    //  177  365:invokevirtual   #114 <Method double valueSparse(int)>
    //  178  368:d2i             
    //  179  369:invokevirtual   #243 <Method Instances Attribute.relation(int)>
    //  180  372:invokevirtual   #246 <Method String Instances.stringWithoutHeader()>
    //  181  375:invokestatic    #201 <Method String Utils.quote(String)>
    //  182  378:invokevirtual   #172 <Method StringBuilder StringBuilder.append(String)>
    //  183  381:invokevirtual   #174 <Method String StringBuilder.toString()>
    //  184  384:invokevirtual   #158 <Method StringBuffer StringBuffer.append(String)>
    //  185  387:pop             
                }
    //* 186  388:goto            510
                catch(Exception e)
    //* 187  391:astore_3        
                {
                    e.printStackTrace();
    //  188  392:aload_3         
    //  189  393:invokevirtual   #206 <Method void Exception.printStackTrace()>
                    System.err.println(new Instances(m_Dataset, 0));
    //  190  396:getstatic       #210 <Field PrintStream System.err>
    //  191  399:new             #78  <Class Instances>
    //  192  402:dup             
    //  193  403:aload_0         
    //  194  404:getfield        #27  <Field Instances m_Dataset>
    //  195  407:iconst_0        
    //  196  408:invokespecial   #213 <Method void Instances(Instances, int)>
    //  197  411:invokevirtual   #219 <Method void PrintStream.println(Object)>
                    System.err.println((new StringBuilder("Att:")).append(m_Indices[i]).append(" Val:").append(valueSparse(i)).toString());
    //  198  414:getstatic       #210 <Field PrintStream System.err>
    //  199  417:new             #160 <Class StringBuilder>
    //  200  420:dup             
    //  201  421:ldc1            #221 <String "Att:">
    //  202  423:invokespecial   #167 <Method void StringBuilder(String)>
    //  203  426:aload_0         
    //  204  427:getfield        #39  <Field int[] m_Indices>
    //  205  430:iload_2         
    //  206  431:iaload          
    //  207  432:invokevirtual   #224 <Method StringBuilder StringBuilder.append(int)>
    //  208  435:ldc1            #226 <String " Val:">
    //  209  437:invokevirtual   #172 <Method StringBuilder StringBuilder.append(String)>
    //  210  440:aload_0         
    //  211  441:iload_2         
    //  212  442:invokevirtual   #114 <Method double valueSparse(int)>
    //  213  445:invokevirtual   #229 <Method StringBuilder StringBuilder.append(double)>
    //  214  448:invokevirtual   #174 <Method String StringBuilder.toString()>
    //  215  451:invokevirtual   #231 <Method void PrintStream.println(String)>
                    throw new Error("This should never happen!");
    //  216  454:new             #233 <Class Error>
    //  217  457:dup             
    //  218  458:ldc1            #235 <String "This should never happen!">
    //  219  460:invokespecial   #236 <Method void Error(String)>
    //  220  463:athrow          
                }
            else
    //* 221  464:goto            510
                text.append((new StringBuilder(String.valueOf(m_Indices[i]))).append(" ").append(Utils.doubleToString(m_AttValues[i], 6)).toString());
    //  222  467:aload_1         
    //  223  468:new             #160 <Class StringBuilder>
    //  224  471:dup             
    //  225  472:aload_0         
    //  226  473:getfield        #39  <Field int[] m_Indices>
    //  227  476:iload_2         
    //  228  477:iaload          
    //  229  478:invokestatic    #166 <Method String String.valueOf(int)>
    //  230  481:invokespecial   #167 <Method void StringBuilder(String)>
    //  231  484:ldc1            #176 <String " ">
    //  232  486:invokevirtual   #172 <Method StringBuilder StringBuilder.append(String)>
    //  233  489:aload_0         
    //  234  490:getfield        #37  <Field double[] m_AttValues>
    //  235  493:iload_2         
    //  236  494:daload          
    //  237  495:bipush          6
    //  238  497:invokestatic    #182 <Method String Utils.doubleToString(double, int)>
    //  239  500:invokevirtual   #172 <Method StringBuilder StringBuilder.append(String)>
    //  240  503:invokevirtual   #174 <Method String StringBuilder.toString()>
    //  241  506:invokevirtual   #158 <Method StringBuffer StringBuffer.append(String)>
    //  242  509:pop             
        }

    //  243  510:iinc            2  1
    //  244  513:iload_2         
    //  245  514:aload_0         
    //  246  515:getfield        #39  <Field int[] m_Indices>
    //  247  518:arraylength     
    //  248  519:icmplt          20
        text.append('}');
    //  249  522:aload_1         
    //  250  523:bipush          125
    //  251  525:invokevirtual   #153 <Method StringBuffer StringBuffer.append(char)>
    //  252  528:pop             
        if(m_Weight != 1.0D)
    //* 253  529:aload_0         
    //* 254  530:getfield        #23  <Field double m_Weight>
    //* 255  533:dconst_1        
    //* 256  534:dcmpl           
    //* 257  535:ifeq            572
            text.append((new StringBuilder(",{")).append(Utils.doubleToString(m_Weight, 6)).append("}").toString());
    //  258  538:aload_1         
    //  259  539:new             #160 <Class StringBuilder>
    //  260  542:dup             
    //  261  543:ldc1            #248 <String ",{">
    //  262  545:invokespecial   #167 <Method void StringBuilder(String)>
    //  263  548:aload_0         
    //  264  549:getfield        #23  <Field double m_Weight>
    //  265  552:bipush          6
    //  266  554:invokestatic    #182 <Method String Utils.doubleToString(double, int)>
    //  267  557:invokevirtual   #172 <Method StringBuilder StringBuilder.append(String)>
    //  268  560:ldc1            #250 <String "}">
    //  269  562:invokevirtual   #172 <Method StringBuilder StringBuilder.append(String)>
    //  270  565:invokevirtual   #174 <Method String StringBuilder.toString()>
    //  271  568:invokevirtual   #158 <Method StringBuffer StringBuffer.append(String)>
    //  272  571:pop             
        return text.toString();
    //  273  572:aload_1         
    //  274  573:invokevirtual   #251 <Method String StringBuffer.toString()>
    //  275  576:areturn         
    }

    public double value(int attIndex)
    {
        int index = locateIndex(attIndex);
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:invokevirtual   #140 <Method int locateIndex(int)>
    //    3    5:istore_2        
        if(index >= 0 && m_Indices[index] == attIndex)
    //*   4    6:iload_2         
    //*   5    7:iflt            27
    //*   6   10:aload_0         
    //*   7   11:getfield        #39  <Field int[] m_Indices>
    //*   8   14:iload_2         
    //*   9   15:iaload          
    //*  10   16:iload_1         
    //*  11   17:icmpne          27
            return m_AttValues[index];
    //   12   20:aload_0         
    //   13   21:getfield        #37  <Field double[] m_AttValues>
    //   14   24:iload_2         
    //   15   25:daload          
    //   16   26:dreturn         
        else
            return 0.0D;
    //   17   27:dconst_0        
    //   18   28:dreturn         
    }

    void forceDeleteAttributeAt(int position)
    {
        int index = locateIndex(position);
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:invokevirtual   #140 <Method int locateIndex(int)>
    //    3    5:istore_2        
        m_NumAttributes--;
    //    4    6:aload_0         
    //    5    7:dup             
    //    6    8:getfield        #33  <Field int m_NumAttributes>
    //    7   11:iconst_1        
    //    8   12:isub            
    //    9   13:putfield        #33  <Field int m_NumAttributes>
        if(index >= 0 && m_Indices[index] == position)
    //*  10   16:iload_2         
    //*  11   17:iflt            138
    //*  12   20:aload_0         
    //*  13   21:getfield        #39  <Field int[] m_Indices>
    //*  14   24:iload_2         
    //*  15   25:iaload          
    //*  16   26:iload_1         
    //*  17   27:icmpne          138
        {
            int tempIndices[] = new int[m_Indices.length - 1];
    //   18   30:aload_0         
    //   19   31:getfield        #39  <Field int[] m_Indices>
    //   20   34:arraylength     
    //   21   35:iconst_1        
    //   22   36:isub            
    //   23   37:newarray        int[]
    //   24   39:astore_3        
            double tempValues[] = new double[m_AttValues.length - 1];
    //   25   40:aload_0         
    //   26   41:getfield        #37  <Field double[] m_AttValues>
    //   27   44:arraylength     
    //   28   45:iconst_1        
    //   29   46:isub            
    //   30   47:newarray        double[]
    //   31   49:astore          4
            System.arraycopy(m_Indices, 0, tempIndices, 0, index);
    //   32   51:aload_0         
    //   33   52:getfield        #39  <Field int[] m_Indices>
    //   34   55:iconst_0        
    //   35   56:aload_3         
    //   36   57:iconst_0        
    //   37   58:iload_2         
    //   38   59:invokestatic    #49  <Method void System.arraycopy(Object, int, Object, int, int)>
            System.arraycopy(m_AttValues, 0, tempValues, 0, index);
    //   39   62:aload_0         
    //   40   63:getfield        #37  <Field double[] m_AttValues>
    //   41   66:iconst_0        
    //   42   67:aload           4
    //   43   69:iconst_0        
    //   44   70:iload_2         
    //   45   71:invokestatic    #49  <Method void System.arraycopy(Object, int, Object, int, int)>
            for(int i = index; i < m_Indices.length - 1; i++)
    //*  46   74:iload_2         
    //*  47   75:istore          5
    //*  48   77:goto            112
            {
                tempIndices[i] = m_Indices[i + 1] - 1;
    //   49   80:aload_3         
    //   50   81:iload           5
    //   51   83:aload_0         
    //   52   84:getfield        #39  <Field int[] m_Indices>
    //   53   87:iload           5
    //   54   89:iconst_1        
    //   55   90:iadd            
    //   56   91:iaload          
    //   57   92:iconst_1        
    //   58   93:isub            
    //   59   94:iastore         
                tempValues[i] = m_AttValues[i + 1];
    //   60   95:aload           4
    //   61   97:iload           5
    //   62   99:aload_0         
    //   63  100:getfield        #37  <Field double[] m_AttValues>
    //   64  103:iload           5
    //   65  105:iconst_1        
    //   66  106:iadd            
    //   67  107:daload          
    //   68  108:dastore         
            }

    //   69  109:iinc            5  1
    //   70  112:iload           5
    //   71  114:aload_0         
    //   72  115:getfield        #39  <Field int[] m_Indices>
    //   73  118:arraylength     
    //   74  119:iconst_1        
    //   75  120:isub            
    //   76  121:icmplt          80
            m_Indices = tempIndices;
    //   77  124:aload_0         
    //   78  125:aload_3         
    //   79  126:putfield        #39  <Field int[] m_Indices>
            m_AttValues = tempValues;
    //   80  129:aload_0         
    //   81  130:aload           4
    //   82  132:putfield        #37  <Field double[] m_AttValues>
        } else
    //*  83  135:goto            239
        {
            int tempIndices[] = new int[m_Indices.length];
    //   84  138:aload_0         
    //   85  139:getfield        #39  <Field int[] m_Indices>
    //   86  142:arraylength     
    //   87  143:newarray        int[]
    //   88  145:astore_3        
            double tempValues[] = new double[m_AttValues.length];
    //   89  146:aload_0         
    //   90  147:getfield        #37  <Field double[] m_AttValues>
    //   91  150:arraylength     
    //   92  151:newarray        double[]
    //   93  153:astore          4
            System.arraycopy(m_Indices, 0, tempIndices, 0, index + 1);
    //   94  155:aload_0         
    //   95  156:getfield        #39  <Field int[] m_Indices>
    //   96  159:iconst_0        
    //   97  160:aload_3         
    //   98  161:iconst_0        
    //   99  162:iload_2         
    //  100  163:iconst_1        
    //  101  164:iadd            
    //  102  165:invokestatic    #49  <Method void System.arraycopy(Object, int, Object, int, int)>
            System.arraycopy(m_AttValues, 0, tempValues, 0, index + 1);
    //  103  168:aload_0         
    //  104  169:getfield        #37  <Field double[] m_AttValues>
    //  105  172:iconst_0        
    //  106  173:aload           4
    //  107  175:iconst_0        
    //  108  176:iload_2         
    //  109  177:iconst_1        
    //  110  178:iadd            
    //  111  179:invokestatic    #49  <Method void System.arraycopy(Object, int, Object, int, int)>
            for(int i = index + 1; i < m_Indices.length; i++)
    //* 112  182:iload_2         
    //* 113  183:iconst_1        
    //* 114  184:iadd            
    //* 115  185:istore          5
    //* 116  187:goto            218
            {
                tempIndices[i] = m_Indices[i] - 1;
    //  117  190:aload_3         
    //  118  191:iload           5
    //  119  193:aload_0         
    //  120  194:getfield        #39  <Field int[] m_Indices>
    //  121  197:iload           5
    //  122  199:iaload          
    //  123  200:iconst_1        
    //  124  201:isub            
    //  125  202:iastore         
                tempValues[i] = m_AttValues[i];
    //  126  203:aload           4
    //  127  205:iload           5
    //  128  207:aload_0         
    //  129  208:getfield        #37  <Field double[] m_AttValues>
    //  130  211:iload           5
    //  131  213:daload          
    //  132  214:dastore         
            }

    //  133  215:iinc            5  1
    //  134  218:iload           5
    //  135  220:aload_0         
    //  136  221:getfield        #39  <Field int[] m_Indices>
    //  137  224:arraylength     
    //  138  225:icmplt          190
            m_Indices = tempIndices;
    //  139  228:aload_0         
    //  140  229:aload_3         
    //  141  230:putfield        #39  <Field int[] m_Indices>
            m_AttValues = tempValues;
    //  142  233:aload_0         
    //  143  234:aload           4
    //  144  236:putfield        #37  <Field double[] m_AttValues>
        }
    //  145  239:return          
    }

    void forceInsertAttributeAt(int position)
    {
        int index = locateIndex(position);
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:invokevirtual   #140 <Method int locateIndex(int)>
    //    3    5:istore_2        
        m_NumAttributes++;
    //    4    6:aload_0         
    //    5    7:dup             
    //    6    8:getfield        #33  <Field int m_NumAttributes>
    //    7   11:iconst_1        
    //    8   12:iadd            
    //    9   13:putfield        #33  <Field int m_NumAttributes>
        if(index >= 0 && m_Indices[index] == position)
    //*  10   16:iload_2         
    //*  11   17:iflt            147
    //*  12   20:aload_0         
    //*  13   21:getfield        #39  <Field int[] m_Indices>
    //*  14   24:iload_2         
    //*  15   25:iaload          
    //*  16   26:iload_1         
    //*  17   27:icmpne          147
        {
            int tempIndices[] = new int[m_Indices.length + 1];
    //   18   30:aload_0         
    //   19   31:getfield        #39  <Field int[] m_Indices>
    //   20   34:arraylength     
    //   21   35:iconst_1        
    //   22   36:iadd            
    //   23   37:newarray        int[]
    //   24   39:astore_3        
            double tempValues[] = new double[m_AttValues.length + 1];
    //   25   40:aload_0         
    //   26   41:getfield        #37  <Field double[] m_AttValues>
    //   27   44:arraylength     
    //   28   45:iconst_1        
    //   29   46:iadd            
    //   30   47:newarray        double[]
    //   31   49:astore          4
            System.arraycopy(m_Indices, 0, tempIndices, 0, index);
    //   32   51:aload_0         
    //   33   52:getfield        #39  <Field int[] m_Indices>
    //   34   55:iconst_0        
    //   35   56:aload_3         
    //   36   57:iconst_0        
    //   37   58:iload_2         
    //   38   59:invokestatic    #49  <Method void System.arraycopy(Object, int, Object, int, int)>
            System.arraycopy(m_AttValues, 0, tempValues, 0, index);
    //   39   62:aload_0         
    //   40   63:getfield        #37  <Field double[] m_AttValues>
    //   41   66:iconst_0        
    //   42   67:aload           4
    //   43   69:iconst_0        
    //   44   70:iload_2         
    //   45   71:invokestatic    #49  <Method void System.arraycopy(Object, int, Object, int, int)>
            tempIndices[index] = position;
    //   46   74:aload_3         
    //   47   75:iload_2         
    //   48   76:iload_1         
    //   49   77:iastore         
            tempValues[index] = (0.0D / 0.0D);
    //   50   78:aload           4
    //   51   80:iload_2         
    //   52   81:ldc2w           #258 <Double (0.0D / 0.0D)>
    //   53   84:dastore         
            for(int i = index; i < m_Indices.length; i++)
    //*  54   85:iload_2         
    //*  55   86:istore          5
    //*  56   88:goto            123
            {
                tempIndices[i + 1] = m_Indices[i] + 1;
    //   57   91:aload_3         
    //   58   92:iload           5
    //   59   94:iconst_1        
    //   60   95:iadd            
    //   61   96:aload_0         
    //   62   97:getfield        #39  <Field int[] m_Indices>
    //   63  100:iload           5
    //   64  102:iaload          
    //   65  103:iconst_1        
    //   66  104:iadd            
    //   67  105:iastore         
                tempValues[i + 1] = m_AttValues[i];
    //   68  106:aload           4
    //   69  108:iload           5
    //   70  110:iconst_1        
    //   71  111:iadd            
    //   72  112:aload_0         
    //   73  113:getfield        #37  <Field double[] m_AttValues>
    //   74  116:iload           5
    //   75  118:daload          
    //   76  119:dastore         
            }

    //   77  120:iinc            5  1
    //   78  123:iload           5
    //   79  125:aload_0         
    //   80  126:getfield        #39  <Field int[] m_Indices>
    //   81  129:arraylength     
    //   82  130:icmplt          91
            m_Indices = tempIndices;
    //   83  133:aload_0         
    //   84  134:aload_3         
    //   85  135:putfield        #39  <Field int[] m_Indices>
            m_AttValues = tempValues;
    //   86  138:aload_0         
    //   87  139:aload           4
    //   88  141:putfield        #37  <Field double[] m_AttValues>
        } else
    //*  89  144:goto            271
        {
            int tempIndices[] = new int[m_Indices.length + 1];
    //   90  147:aload_0         
    //   91  148:getfield        #39  <Field int[] m_Indices>
    //   92  151:arraylength     
    //   93  152:iconst_1        
    //   94  153:iadd            
    //   95  154:newarray        int[]
    //   96  156:astore_3        
            double tempValues[] = new double[m_AttValues.length + 1];
    //   97  157:aload_0         
    //   98  158:getfield        #37  <Field double[] m_AttValues>
    //   99  161:arraylength     
    //  100  162:iconst_1        
    //  101  163:iadd            
    //  102  164:newarray        double[]
    //  103  166:astore          4
            System.arraycopy(m_Indices, 0, tempIndices, 0, index + 1);
    //  104  168:aload_0         
    //  105  169:getfield        #39  <Field int[] m_Indices>
    //  106  172:iconst_0        
    //  107  173:aload_3         
    //  108  174:iconst_0        
    //  109  175:iload_2         
    //  110  176:iconst_1        
    //  111  177:iadd            
    //  112  178:invokestatic    #49  <Method void System.arraycopy(Object, int, Object, int, int)>
            System.arraycopy(m_AttValues, 0, tempValues, 0, index + 1);
    //  113  181:aload_0         
    //  114  182:getfield        #37  <Field double[] m_AttValues>
    //  115  185:iconst_0        
    //  116  186:aload           4
    //  117  188:iconst_0        
    //  118  189:iload_2         
    //  119  190:iconst_1        
    //  120  191:iadd            
    //  121  192:invokestatic    #49  <Method void System.arraycopy(Object, int, Object, int, int)>
            tempIndices[index + 1] = position;
    //  122  195:aload_3         
    //  123  196:iload_2         
    //  124  197:iconst_1        
    //  125  198:iadd            
    //  126  199:iload_1         
    //  127  200:iastore         
            tempValues[index + 1] = (0.0D / 0.0D);
    //  128  201:aload           4
    //  129  203:iload_2         
    //  130  204:iconst_1        
    //  131  205:iadd            
    //  132  206:ldc2w           #260 <Double (0.0D / 0.0D)>
    //  133  209:dastore         
            for(int i = index + 1; i < m_Indices.length; i++)
    //* 134  210:iload_2         
    //* 135  211:iconst_1        
    //* 136  212:iadd            
    //* 137  213:istore          5
    //* 138  215:goto            250
            {
                tempIndices[i + 1] = m_Indices[i] + 1;
    //  139  218:aload_3         
    //  140  219:iload           5
    //  141  221:iconst_1        
    //  142  222:iadd            
    //  143  223:aload_0         
    //  144  224:getfield        #39  <Field int[] m_Indices>
    //  145  227:iload           5
    //  146  229:iaload          
    //  147  230:iconst_1        
    //  148  231:iadd            
    //  149  232:iastore         
                tempValues[i + 1] = m_AttValues[i];
    //  150  233:aload           4
    //  151  235:iload           5
    //  152  237:iconst_1        
    //  153  238:iadd            
    //  154  239:aload_0         
    //  155  240:getfield        #37  <Field double[] m_AttValues>
    //  156  243:iload           5
    //  157  245:daload          
    //  158  246:dastore         
            }

    //  159  247:iinc            5  1
    //  160  250:iload           5
    //  161  252:aload_0         
    //  162  253:getfield        #39  <Field int[] m_Indices>
    //  163  256:arraylength     
    //  164  257:icmplt          218
            m_Indices = tempIndices;
    //  165  260:aload_0         
    //  166  261:aload_3         
    //  167  262:putfield        #39  <Field int[] m_Indices>
            m_AttValues = tempValues;
    //  168  265:aload_0         
    //  169  266:aload           4
    //  170  268:putfield        #37  <Field double[] m_AttValues>
        }
    //  171  271:return          
    }

    public static void main(String options[])
    {
        try
        {
            Attribute length = new Attribute("length");
    //    0    0:new             #184 <Class Attribute>
    //    1    3:dup             
    //    2    4:ldc2            #265 <String "length">
    //    3    7:invokespecial   #266 <Method void Attribute(String)>
    //    4   10:astore_1        
            Attribute weight = new Attribute("weight");
    //    5   11:new             #184 <Class Attribute>
    //    6   14:dup             
    //    7   15:ldc2            #267 <String "weight">
    //    8   18:invokespecial   #266 <Method void Attribute(String)>
    //    9   21:astore_2        
            FastVector my_nominal_values = new FastVector(3);
    //   10   22:new             #269 <Class FastVector>
    //   11   25:dup             
    //   12   26:iconst_3        
    //   13   27:invokespecial   #271 <Method void FastVector(int)>
    //   14   30:astore_3        
            my_nominal_values.addElement("first");
    //   15   31:aload_3         
    //   16   32:ldc2            #273 <String "first">
    //   17   35:invokevirtual   #276 <Method void FastVector.addElement(Object)>
            my_nominal_values.addElement("second");
    //   18   38:aload_3         
    //   19   39:ldc2            #278 <String "second">
    //   20   42:invokevirtual   #276 <Method void FastVector.addElement(Object)>
            my_nominal_values.addElement("third");
    //   21   45:aload_3         
    //   22   46:ldc2            #280 <String "third">
    //   23   49:invokevirtual   #276 <Method void FastVector.addElement(Object)>
            Attribute position = new Attribute("position", my_nominal_values);
    //   24   52:new             #184 <Class Attribute>
    //   25   55:dup             
    //   26   56:ldc2            #281 <String "position">
    //   27   59:aload_3         
    //   28   60:invokespecial   #284 <Method void Attribute(String, FastVector)>
    //   29   63:astore          4
            FastVector attributes = new FastVector(3);
    //   30   65:new             #269 <Class FastVector>
    //   31   68:dup             
    //   32   69:iconst_3        
    //   33   70:invokespecial   #271 <Method void FastVector(int)>
    //   34   73:astore          5
            attributes.addElement(length);
    //   35   75:aload           5
    //   36   77:aload_1         
    //   37   78:invokevirtual   #276 <Method void FastVector.addElement(Object)>
            attributes.addElement(weight);
    //   38   81:aload           5
    //   39   83:aload_2         
    //   40   84:invokevirtual   #276 <Method void FastVector.addElement(Object)>
            attributes.addElement(position);
    //   41   87:aload           5
    //   42   89:aload           4
    //   43   91:invokevirtual   #276 <Method void FastVector.addElement(Object)>
            Instances race = new Instances("race", attributes, 0);
    //   44   94:new             #78  <Class Instances>
    //   45   97:dup             
    //   46   98:ldc2            #286 <String "race">
    //   47  101:aload           5
    //   48  103:iconst_0        
    //   49  104:invokespecial   #289 <Method void Instances(String, FastVector, int)>
    //   50  107:astore          6
            race.setClassIndex(position.index());
    //   51  109:aload           6
    //   52  111:aload           4
    //   53  113:invokevirtual   #291 <Method int Attribute.index()>
    //   54  116:invokevirtual   #294 <Method void Instances.setClassIndex(int)>
            SparseInstance inst = new SparseInstance(3);
    //   55  119:new             #2   <Class SparseInstance>
    //   56  122:dup             
    //   57  123:iconst_3        
    //   58  124:invokespecial   #295 <Method void SparseInstance(int)>
    //   59  127:astore          7
            inst.setValue(length, 5.2999999999999998D);
    //   60  129:aload           7
    //   61  131:aload_1         
    //   62  132:ldc2w           #296 <Double 5.2999999999999998D>
    //   63  135:invokevirtual   #300 <Method void setValue(Attribute, double)>
            inst.setValue(weight, 300D);
    //   64  138:aload           7
    //   65  140:aload_2         
    //   66  141:ldc2w           #301 <Double 300D>
    //   67  144:invokevirtual   #300 <Method void setValue(Attribute, double)>
            inst.setValue(position, "first");
    //   68  147:aload           7
    //   69  149:aload           4
    //   70  151:ldc2            #273 <String "first">
    //   71  154:invokevirtual   #305 <Method void setValue(Attribute, String)>
            inst.setDataset(race);
    //   72  157:aload           7
    //   73  159:aload           6
    //   74  161:invokevirtual   #309 <Method void setDataset(Instances)>
            System.out.println((new StringBuilder("The instance: ")).append(inst).toString());
    //   75  164:getstatic       #312 <Field PrintStream System.out>
    //   76  167:new             #160 <Class StringBuilder>
    //   77  170:dup             
    //   78  171:ldc2            #314 <String "The instance: ">
    //   79  174:invokespecial   #167 <Method void StringBuilder(String)>
    //   80  177:aload           7
    //   81  179:invokevirtual   #317 <Method StringBuilder StringBuilder.append(Object)>
    //   82  182:invokevirtual   #174 <Method String StringBuilder.toString()>
    //   83  185:invokevirtual   #231 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("First attribute: ")).append(inst.attribute(0)).toString());
    //   84  188:getstatic       #312 <Field PrintStream System.out>
    //   85  191:new             #160 <Class StringBuilder>
    //   86  194:dup             
    //   87  195:ldc2            #319 <String "First attribute: ">
    //   88  198:invokespecial   #167 <Method void StringBuilder(String)>
    //   89  201:aload           7
    //   90  203:iconst_0        
    //   91  204:invokevirtual   #320 <Method Attribute attribute(int)>
    //   92  207:invokevirtual   #317 <Method StringBuilder StringBuilder.append(Object)>
    //   93  210:invokevirtual   #174 <Method String StringBuilder.toString()>
    //   94  213:invokevirtual   #231 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Class attribute: ")).append(inst.classAttribute()).toString());
    //   95  216:getstatic       #312 <Field PrintStream System.out>
    //   96  219:new             #160 <Class StringBuilder>
    //   97  222:dup             
    //   98  223:ldc2            #322 <String "Class attribute: ">
    //   99  226:invokespecial   #167 <Method void StringBuilder(String)>
    //  100  229:aload           7
    //  101  231:invokevirtual   #326 <Method Attribute classAttribute()>
    //  102  234:invokevirtual   #317 <Method StringBuilder StringBuilder.append(Object)>
    //  103  237:invokevirtual   #174 <Method String StringBuilder.toString()>
    //  104  240:invokevirtual   #231 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Class index: ")).append(inst.classIndex()).toString());
    //  105  243:getstatic       #312 <Field PrintStream System.out>
    //  106  246:new             #160 <Class StringBuilder>
    //  107  249:dup             
    //  108  250:ldc2            #328 <String "Class index: ">
    //  109  253:invokespecial   #167 <Method void StringBuilder(String)>
    //  110  256:aload           7
    //  111  258:invokevirtual   #331 <Method int classIndex()>
    //  112  261:invokevirtual   #224 <Method StringBuilder StringBuilder.append(int)>
    //  113  264:invokevirtual   #174 <Method String StringBuilder.toString()>
    //  114  267:invokevirtual   #231 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Class is missing: ")).append(inst.classIsMissing()).toString());
    //  115  270:getstatic       #312 <Field PrintStream System.out>
    //  116  273:new             #160 <Class StringBuilder>
    //  117  276:dup             
    //  118  277:ldc2            #333 <String "Class is missing: ">
    //  119  280:invokespecial   #167 <Method void StringBuilder(String)>
    //  120  283:aload           7
    //  121  285:invokevirtual   #336 <Method boolean classIsMissing()>
    //  122  288:invokevirtual   #339 <Method StringBuilder StringBuilder.append(boolean)>
    //  123  291:invokevirtual   #174 <Method String StringBuilder.toString()>
    //  124  294:invokevirtual   #231 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Class value (internal format): ")).append(inst.classValue()).toString());
    //  125  297:getstatic       #312 <Field PrintStream System.out>
    //  126  300:new             #160 <Class StringBuilder>
    //  127  303:dup             
    //  128  304:ldc2            #341 <String "Class value (internal format): ">
    //  129  307:invokespecial   #167 <Method void StringBuilder(String)>
    //  130  310:aload           7
    //  131  312:invokevirtual   #345 <Method double classValue()>
    //  132  315:invokevirtual   #229 <Method StringBuilder StringBuilder.append(double)>
    //  133  318:invokevirtual   #174 <Method String StringBuilder.toString()>
    //  134  321:invokevirtual   #231 <Method void PrintStream.println(String)>
            SparseInstance copy = (SparseInstance)inst.copy();
    //  135  324:aload           7
    //  136  326:invokevirtual   #347 <Method Object copy()>
    //  137  329:checkcast       #2   <Class SparseInstance>
    //  138  332:astore          8
            System.out.println((new StringBuilder("Shallow copy: ")).append(copy).toString());
    //  139  334:getstatic       #312 <Field PrintStream System.out>
    //  140  337:new             #160 <Class StringBuilder>
    //  141  340:dup             
    //  142  341:ldc2            #349 <String "Shallow copy: ">
    //  143  344:invokespecial   #167 <Method void StringBuilder(String)>
    //  144  347:aload           8
    //  145  349:invokevirtual   #317 <Method StringBuilder StringBuilder.append(Object)>
    //  146  352:invokevirtual   #174 <Method String StringBuilder.toString()>
    //  147  355:invokevirtual   #231 <Method void PrintStream.println(String)>
            copy.setDataset(inst.dataset());
    //  148  358:aload           8
    //  149  360:aload           7
    //  150  362:invokevirtual   #353 <Method Instances dataset()>
    //  151  365:invokevirtual   #309 <Method void setDataset(Instances)>
            System.out.println((new StringBuilder("Shallow copy with dataset set: ")).append(copy).toString());
    //  152  368:getstatic       #312 <Field PrintStream System.out>
    //  153  371:new             #160 <Class StringBuilder>
    //  154  374:dup             
    //  155  375:ldc2            #355 <String "Shallow copy with dataset set: ">
    //  156  378:invokespecial   #167 <Method void StringBuilder(String)>
    //  157  381:aload           8
    //  158  383:invokevirtual   #317 <Method StringBuilder StringBuilder.append(Object)>
    //  159  386:invokevirtual   #174 <Method String StringBuilder.toString()>
    //  160  389:invokevirtual   #231 <Method void PrintStream.println(String)>
            System.out.print("All stored values in internal format: ");
    //  161  392:getstatic       #312 <Field PrintStream System.out>
    //  162  395:ldc2            #357 <String "All stored values in internal format: ">
    //  163  398:invokevirtual   #360 <Method void PrintStream.print(String)>
            for(int i = 0; i < inst.numValues(); i++)
    //* 164  401:iconst_0        
    //* 165  402:istore          9
    //* 166  404:goto            436
            {
                if(i > 0)
    //* 167  407:iload           9
    //* 168  409:ifle            420
                    System.out.print(",");
    //  169  412:getstatic       #312 <Field PrintStream System.out>
    //  170  415:ldc1            #155 <String ",">
    //  171  417:invokevirtual   #360 <Method void PrintStream.print(String)>
                System.out.print(inst.valueSparse(i));
    //  172  420:getstatic       #312 <Field PrintStream System.out>
    //  173  423:aload           7
    //  174  425:iload           9
    //  175  427:invokevirtual   #114 <Method double valueSparse(int)>
    //  176  430:invokevirtual   #363 <Method void PrintStream.print(double)>
            }

    //  177  433:iinc            9  1
    //  178  436:iload           9
    //  179  438:aload           7
    //  180  440:invokevirtual   #110 <Method int numValues()>
    //  181  443:icmplt          407
            System.out.println();
    //  182  446:getstatic       #312 <Field PrintStream System.out>
    //  183  449:invokevirtual   #365 <Method void PrintStream.println()>
            System.out.print("All values set to zero: ");
    //  184  452:getstatic       #312 <Field PrintStream System.out>
    //  185  455:ldc2            #367 <String "All values set to zero: ">
    //  186  458:invokevirtual   #360 <Method void PrintStream.print(String)>
    //* 187  461:goto            471
            for(; inst.numValues() > 0; inst.setValueSparse(0, 0.0D));
    //  188  464:aload           7
    //  189  466:iconst_0        
    //  190  467:dconst_0        
    //  191  468:invokevirtual   #369 <Method void setValueSparse(int, double)>
    //  192  471:aload           7
    //  193  473:invokevirtual   #110 <Method int numValues()>
    //  194  476:ifgt            464
            for(int i = 0; i < inst.numValues(); i++)
    //* 195  479:iconst_0        
    //* 196  480:istore          9
    //* 197  482:goto            514
            {
                if(i > 0)
    //* 198  485:iload           9
    //* 199  487:ifle            498
                    System.out.print(",");
    //  200  490:getstatic       #312 <Field PrintStream System.out>
    //  201  493:ldc1            #155 <String ",">
    //  202  495:invokevirtual   #360 <Method void PrintStream.print(String)>
                System.out.print(inst.valueSparse(i));
    //  203  498:getstatic       #312 <Field PrintStream System.out>
    //  204  501:aload           7
    //  205  503:iload           9
    //  206  505:invokevirtual   #114 <Method double valueSparse(int)>
    //  207  508:invokevirtual   #363 <Method void PrintStream.print(double)>
            }

    //  208  511:iinc            9  1
    //  209  514:iload           9
    //  210  516:aload           7
    //  211  518:invokevirtual   #110 <Method int numValues()>
    //  212  521:icmplt          485
            System.out.println();
    //  213  524:getstatic       #312 <Field PrintStream System.out>
    //  214  527:invokevirtual   #365 <Method void PrintStream.println()>
            System.out.print("All values set to one: ");
    //  215  530:getstatic       #312 <Field PrintStream System.out>
    //  216  533:ldc2            #371 <String "All values set to one: ">
    //  217  536:invokevirtual   #360 <Method void PrintStream.print(String)>
            for(int i = 0; i < inst.numAttributes(); i++)
    //* 218  539:iconst_0        
    //* 219  540:istore          9
    //* 220  542:goto            556
                inst.setValue(i, 1.0D);
    //  221  545:aload           7
    //  222  547:iload           9
    //  223  549:dconst_1        
    //  224  550:invokevirtual   #373 <Method void setValue(int, double)>

    //  225  553:iinc            9  1
    //  226  556:iload           9
    //  227  558:aload           7
    //  228  560:invokevirtual   #118 <Method int numAttributes()>
    //  229  563:icmplt          545
            for(int i = 0; i < inst.numValues(); i++)
    //* 230  566:iconst_0        
    //* 231  567:istore          9
    //* 232  569:goto            601
            {
                if(i > 0)
    //* 233  572:iload           9
    //* 234  574:ifle            585
                    System.out.print(",");
    //  235  577:getstatic       #312 <Field PrintStream System.out>
    //  236  580:ldc1            #155 <String ",">
    //  237  582:invokevirtual   #360 <Method void PrintStream.print(String)>
                System.out.print(inst.valueSparse(i));
    //  238  585:getstatic       #312 <Field PrintStream System.out>
    //  239  588:aload           7
    //  240  590:iload           9
    //  241  592:invokevirtual   #114 <Method double valueSparse(int)>
    //  242  595:invokevirtual   #363 <Method void PrintStream.print(double)>
            }

    //  243  598:iinc            9  1
    //  244  601:iload           9
    //  245  603:aload           7
    //  246  605:invokevirtual   #110 <Method int numValues()>
    //  247  608:icmplt          572
            System.out.println();
    //  248  611:getstatic       #312 <Field PrintStream System.out>
    //  249  614:invokevirtual   #365 <Method void PrintStream.println()>
            copy.setDataset(null);
    //  250  617:aload           8
    //  251  619:aconst_null     
    //  252  620:invokevirtual   #309 <Method void setDataset(Instances)>
            copy.deleteAttributeAt(0);
    //  253  623:aload           8
    //  254  625:iconst_0        
    //  255  626:invokevirtual   #376 <Method void deleteAttributeAt(int)>
            copy.insertAttributeAt(0);
    //  256  629:aload           8
    //  257  631:iconst_0        
    //  258  632:invokevirtual   #379 <Method void insertAttributeAt(int)>
            copy.setDataset(inst.dataset());
    //  259  635:aload           8
    //  260  637:aload           7
    //  261  639:invokevirtual   #353 <Method Instances dataset()>
    //  262  642:invokevirtual   #309 <Method void setDataset(Instances)>
            System.out.println((new StringBuilder("Copy with first attribute deleted and inserted: ")).append(copy).toString());
    //  263  645:getstatic       #312 <Field PrintStream System.out>
    //  264  648:new             #160 <Class StringBuilder>
    //  265  651:dup             
    //  266  652:ldc2            #381 <String "Copy with first attribute deleted and inserted: ">
    //  267  655:invokespecial   #167 <Method void StringBuilder(String)>
    //  268  658:aload           8
    //  269  660:invokevirtual   #317 <Method StringBuilder StringBuilder.append(Object)>
    //  270  663:invokevirtual   #174 <Method String StringBuilder.toString()>
    //  271  666:invokevirtual   #231 <Method void PrintStream.println(String)>
            copy.setDataset(null);
    //  272  669:aload           8
    //  273  671:aconst_null     
    //  274  672:invokevirtual   #309 <Method void setDataset(Instances)>
            copy.deleteAttributeAt(1);
    //  275  675:aload           8
    //  276  677:iconst_1        
    //  277  678:invokevirtual   #376 <Method void deleteAttributeAt(int)>
            copy.insertAttributeAt(1);
    //  278  681:aload           8
    //  279  683:iconst_1        
    //  280  684:invokevirtual   #379 <Method void insertAttributeAt(int)>
            copy.setDataset(inst.dataset());
    //  281  687:aload           8
    //  282  689:aload           7
    //  283  691:invokevirtual   #353 <Method Instances dataset()>
    //  284  694:invokevirtual   #309 <Method void setDataset(Instances)>
            System.out.println((new StringBuilder("Copy with second attribute deleted and inserted: ")).append(copy).toString());
    //  285  697:getstatic       #312 <Field PrintStream System.out>
    //  286  700:new             #160 <Class StringBuilder>
    //  287  703:dup             
    //  288  704:ldc2            #383 <String "Copy with second attribute deleted and inserted: ">
    //  289  707:invokespecial   #167 <Method void StringBuilder(String)>
    //  290  710:aload           8
    //  291  712:invokevirtual   #317 <Method StringBuilder StringBuilder.append(Object)>
    //  292  715:invokevirtual   #174 <Method String StringBuilder.toString()>
    //  293  718:invokevirtual   #231 <Method void PrintStream.println(String)>
            copy.setDataset(null);
    //  294  721:aload           8
    //  295  723:aconst_null     
    //  296  724:invokevirtual   #309 <Method void setDataset(Instances)>
            copy.deleteAttributeAt(2);
    //  297  727:aload           8
    //  298  729:iconst_2        
    //  299  730:invokevirtual   #376 <Method void deleteAttributeAt(int)>
            copy.insertAttributeAt(2);
    //  300  733:aload           8
    //  301  735:iconst_2        
    //  302  736:invokevirtual   #379 <Method void insertAttributeAt(int)>
            copy.setDataset(inst.dataset());
    //  303  739:aload           8
    //  304  741:aload           7
    //  305  743:invokevirtual   #353 <Method Instances dataset()>
    //  306  746:invokevirtual   #309 <Method void setDataset(Instances)>
            System.out.println((new StringBuilder("Copy with third attribute deleted and inserted: ")).append(copy).toString());
    //  307  749:getstatic       #312 <Field PrintStream System.out>
    //  308  752:new             #160 <Class StringBuilder>
    //  309  755:dup             
    //  310  756:ldc2            #385 <String "Copy with third attribute deleted and inserted: ">
    //  311  759:invokespecial   #167 <Method void StringBuilder(String)>
    //  312  762:aload           8
    //  313  764:invokevirtual   #317 <Method StringBuilder StringBuilder.append(Object)>
    //  314  767:invokevirtual   #174 <Method String StringBuilder.toString()>
    //  315  770:invokevirtual   #231 <Method void PrintStream.println(String)>
            System.out.println("Enumerating attributes (leaving out class):");
    //  316  773:getstatic       #312 <Field PrintStream System.out>
    //  317  776:ldc2            #387 <String "Enumerating attributes (leaving out class):">
    //  318  779:invokevirtual   #231 <Method void PrintStream.println(String)>
            Attribute att;
            for(Enumeration enu = inst.enumerateAttributes(); enu.hasMoreElements(); System.out.println(att))
    //* 319  782:aload           7
    //* 320  784:invokevirtual   #391 <Method Enumeration enumerateAttributes()>
    //* 321  787:astore          9
    //* 322  789:goto            815
                att = (Attribute)(Attribute)enu.nextElement();
    //  323  792:aload           9
    //  324  794:invokeinterface #396 <Method Object Enumeration.nextElement()>
    //  325  799:checkcast       #184 <Class Attribute>
    //  326  802:checkcast       #184 <Class Attribute>
    //  327  805:astore          10

    //  328  807:getstatic       #312 <Field PrintStream System.out>
    //  329  810:aload           10
    //  330  812:invokevirtual   #219 <Method void PrintStream.println(Object)>
    //  331  815:aload           9
    //  332  817:invokeinterface #399 <Method boolean Enumeration.hasMoreElements()>
    //  333  822:ifne            792
            System.out.println((new StringBuilder("Header of original and copy equivalent: ")).append(inst.equalHeaders(copy)).toString());
    //  334  825:getstatic       #312 <Field PrintStream System.out>
    //  335  828:new             #160 <Class StringBuilder>
    //  336  831:dup             
    //  337  832:ldc2            #401 <String "Header of original and copy equivalent: ">
    //  338  835:invokespecial   #167 <Method void StringBuilder(String)>
    //  339  838:aload           7
    //  340  840:aload           8
    //  341  842:invokevirtual   #405 <Method boolean equalHeaders(Instance)>
    //  342  845:invokevirtual   #339 <Method StringBuilder StringBuilder.append(boolean)>
    //  343  848:invokevirtual   #174 <Method String StringBuilder.toString()>
    //  344  851:invokevirtual   #231 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Length of copy missing: ")).append(copy.isMissing(length)).toString());
    //  345  854:getstatic       #312 <Field PrintStream System.out>
    //  346  857:new             #160 <Class StringBuilder>
    //  347  860:dup             
    //  348  861:ldc2            #407 <String "Length of copy missing: ">
    //  349  864:invokespecial   #167 <Method void StringBuilder(String)>
    //  350  867:aload           8
    //  351  869:aload_1         
    //  352  870:invokevirtual   #410 <Method boolean isMissing(Attribute)>
    //  353  873:invokevirtual   #339 <Method StringBuilder StringBuilder.append(boolean)>
    //  354  876:invokevirtual   #174 <Method String StringBuilder.toString()>
    //  355  879:invokevirtual   #231 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Weight of copy missing: ")).append(copy.isMissing(weight.index())).toString());
    //  356  882:getstatic       #312 <Field PrintStream System.out>
    //  357  885:new             #160 <Class StringBuilder>
    //  358  888:dup             
    //  359  889:ldc2            #412 <String "Weight of copy missing: ">
    //  360  892:invokespecial   #167 <Method void StringBuilder(String)>
    //  361  895:aload           8
    //  362  897:aload_2         
    //  363  898:invokevirtual   #291 <Method int Attribute.index()>
    //  364  901:invokevirtual   #414 <Method boolean isMissing(int)>
    //  365  904:invokevirtual   #339 <Method StringBuilder StringBuilder.append(boolean)>
    //  366  907:invokevirtual   #174 <Method String StringBuilder.toString()>
    //  367  910:invokevirtual   #231 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Length of copy missing: ")).append(Instance.isMissingValue(copy.value(length))).toString());
    //  368  913:getstatic       #312 <Field PrintStream System.out>
    //  369  916:new             #160 <Class StringBuilder>
    //  370  919:dup             
    //  371  920:ldc2            #407 <String "Length of copy missing: ">
    //  372  923:invokespecial   #167 <Method void StringBuilder(String)>
    //  373  926:aload           8
    //  374  928:aload_1         
    //  375  929:invokevirtual   #417 <Method double value(Attribute)>
    //  376  932:invokestatic    #135 <Method boolean Instance.isMissingValue(double)>
    //  377  935:invokevirtual   #339 <Method StringBuilder StringBuilder.append(boolean)>
    //  378  938:invokevirtual   #174 <Method String StringBuilder.toString()>
    //  379  941:invokevirtual   #231 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Missing value coded as: ")).append(Instance.missingValue()).toString());
    //  380  944:getstatic       #312 <Field PrintStream System.out>
    //  381  947:new             #160 <Class StringBuilder>
    //  382  950:dup             
    //  383  951:ldc2            #419 <String "Missing value coded as: ">
    //  384  954:invokespecial   #167 <Method void StringBuilder(String)>
    //  385  957:invokestatic    #422 <Method double Instance.missingValue()>
    //  386  960:invokevirtual   #229 <Method StringBuilder StringBuilder.append(double)>
    //  387  963:invokevirtual   #174 <Method String StringBuilder.toString()>
    //  388  966:invokevirtual   #231 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Number of attributes: ")).append(copy.numAttributes()).toString());
    //  389  969:getstatic       #312 <Field PrintStream System.out>
    //  390  972:new             #160 <Class StringBuilder>
    //  391  975:dup             
    //  392  976:ldc2            #424 <String "Number of attributes: ">
    //  393  979:invokespecial   #167 <Method void StringBuilder(String)>
    //  394  982:aload           8
    //  395  984:invokevirtual   #118 <Method int numAttributes()>
    //  396  987:invokevirtual   #224 <Method StringBuilder StringBuilder.append(int)>
    //  397  990:invokevirtual   #174 <Method String StringBuilder.toString()>
    //  398  993:invokevirtual   #231 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Number of classes: ")).append(copy.numClasses()).toString());
    //  399  996:getstatic       #312 <Field PrintStream System.out>
    //  400  999:new             #160 <Class StringBuilder>
    //  401 1002:dup             
    //  402 1003:ldc2            #426 <String "Number of classes: ">
    //  403 1006:invokespecial   #167 <Method void StringBuilder(String)>
    //  404 1009:aload           8
    //  405 1011:invokevirtual   #429 <Method int numClasses()>
    //  406 1014:invokevirtual   #224 <Method StringBuilder StringBuilder.append(int)>
    //  407 1017:invokevirtual   #174 <Method String StringBuilder.toString()>
    //  408 1020:invokevirtual   #231 <Method void PrintStream.println(String)>
            double meansAndModes[] = {
                2D, 3D, 0.0D
            };
    //  409 1023:iconst_3        
    //  410 1024:newarray        double[]
    //  411 1026:dup             
    //  412 1027:iconst_0        
    //  413 1028:ldc2w           #430 <Double 2D>
    //  414 1031:dastore         
    //  415 1032:dup             
    //  416 1033:iconst_1        
    //  417 1034:ldc2w           #432 <Double 3D>
    //  418 1037:dastore         
    //  419 1038:dup             
    //  420 1039:iconst_2        
    //  421 1040:dconst_0        
    //  422 1041:dastore         
    //  423 1042:astore          10
            copy.replaceMissingValues(meansAndModes);
    //  424 1044:aload           8
    //  425 1046:aload           10
    //  426 1048:invokevirtual   #435 <Method void replaceMissingValues(double[])>
            System.out.println((new StringBuilder("Copy with missing value replaced: ")).append(copy).toString());
    //  427 1051:getstatic       #312 <Field PrintStream System.out>
    //  428 1054:new             #160 <Class StringBuilder>
    //  429 1057:dup             
    //  430 1058:ldc2            #437 <String "Copy with missing value replaced: ">
    //  431 1061:invokespecial   #167 <Method void StringBuilder(String)>
    //  432 1064:aload           8
    //  433 1066:invokevirtual   #317 <Method StringBuilder StringBuilder.append(Object)>
    //  434 1069:invokevirtual   #174 <Method String StringBuilder.toString()>
    //  435 1072:invokevirtual   #231 <Method void PrintStream.println(String)>
            copy.setClassMissing();
    //  436 1075:aload           8
    //  437 1077:invokevirtual   #440 <Method void setClassMissing()>
            System.out.println((new StringBuilder("Copy with missing class: ")).append(copy).toString());
    //  438 1080:getstatic       #312 <Field PrintStream System.out>
    //  439 1083:new             #160 <Class StringBuilder>
    //  440 1086:dup             
    //  441 1087:ldc2            #442 <String "Copy with missing class: ">
    //  442 1090:invokespecial   #167 <Method void StringBuilder(String)>
    //  443 1093:aload           8
    //  444 1095:invokevirtual   #317 <Method StringBuilder StringBuilder.append(Object)>
    //  445 1098:invokevirtual   #174 <Method String StringBuilder.toString()>
    //  446 1101:invokevirtual   #231 <Method void PrintStream.println(String)>
            copy.setClassValue(0.0D);
    //  447 1104:aload           8
    //  448 1106:dconst_0        
    //  449 1107:invokevirtual   #445 <Method void setClassValue(double)>
            System.out.println((new StringBuilder("Copy with class value set to first value: ")).append(copy).toString());
    //  450 1110:getstatic       #312 <Field PrintStream System.out>
    //  451 1113:new             #160 <Class StringBuilder>
    //  452 1116:dup             
    //  453 1117:ldc2            #447 <String "Copy with class value set to first value: ">
    //  454 1120:invokespecial   #167 <Method void StringBuilder(String)>
    //  455 1123:aload           8
    //  456 1125:invokevirtual   #317 <Method StringBuilder StringBuilder.append(Object)>
    //  457 1128:invokevirtual   #174 <Method String StringBuilder.toString()>
    //  458 1131:invokevirtual   #231 <Method void PrintStream.println(String)>
            copy.setClassValue("third");
    //  459 1134:aload           8
    //  460 1136:ldc2            #280 <String "third">
    //  461 1139:invokevirtual   #449 <Method void setClassValue(String)>
            System.out.println((new StringBuilder("Copy with class value set to \"third\": ")).append(copy).toString());
    //  462 1142:getstatic       #312 <Field PrintStream System.out>
    //  463 1145:new             #160 <Class StringBuilder>
    //  464 1148:dup             
    //  465 1149:ldc2            #451 <String "Copy with class value set to \"third\": ">
    //  466 1152:invokespecial   #167 <Method void StringBuilder(String)>
    //  467 1155:aload           8
    //  468 1157:invokevirtual   #317 <Method StringBuilder StringBuilder.append(Object)>
    //  469 1160:invokevirtual   #174 <Method String StringBuilder.toString()>
    //  470 1163:invokevirtual   #231 <Method void PrintStream.println(String)>
            copy.setMissing(1);
    //  471 1166:aload           8
    //  472 1168:iconst_1        
    //  473 1169:invokevirtual   #454 <Method void setMissing(int)>
            System.out.println((new StringBuilder("Copy with second attribute set to be missing: ")).append(copy).toString());
    //  474 1172:getstatic       #312 <Field PrintStream System.out>
    //  475 1175:new             #160 <Class StringBuilder>
    //  476 1178:dup             
    //  477 1179:ldc2            #456 <String "Copy with second attribute set to be missing: ">
    //  478 1182:invokespecial   #167 <Method void StringBuilder(String)>
    //  479 1185:aload           8
    //  480 1187:invokevirtual   #317 <Method StringBuilder StringBuilder.append(Object)>
    //  481 1190:invokevirtual   #174 <Method String StringBuilder.toString()>
    //  482 1193:invokevirtual   #231 <Method void PrintStream.println(String)>
            copy.setMissing(length);
    //  483 1196:aload           8
    //  484 1198:aload_1         
    //  485 1199:invokevirtual   #459 <Method void setMissing(Attribute)>
            System.out.println((new StringBuilder("Copy with length set to be missing: ")).append(copy).toString());
    //  486 1202:getstatic       #312 <Field PrintStream System.out>
    //  487 1205:new             #160 <Class StringBuilder>
    //  488 1208:dup             
    //  489 1209:ldc2            #461 <String "Copy with length set to be missing: ">
    //  490 1212:invokespecial   #167 <Method void StringBuilder(String)>
    //  491 1215:aload           8
    //  492 1217:invokevirtual   #317 <Method StringBuilder StringBuilder.append(Object)>
    //  493 1220:invokevirtual   #174 <Method String StringBuilder.toString()>
    //  494 1223:invokevirtual   #231 <Method void PrintStream.println(String)>
            copy.setValue(0, 0.0D);
    //  495 1226:aload           8
    //  496 1228:iconst_0        
    //  497 1229:dconst_0        
    //  498 1230:invokevirtual   #373 <Method void setValue(int, double)>
            System.out.println((new StringBuilder("Copy with first attribute set to 0: ")).append(copy).toString());
    //  499 1233:getstatic       #312 <Field PrintStream System.out>
    //  500 1236:new             #160 <Class StringBuilder>
    //  501 1239:dup             
    //  502 1240:ldc2            #463 <String "Copy with first attribute set to 0: ">
    //  503 1243:invokespecial   #167 <Method void StringBuilder(String)>
    //  504 1246:aload           8
    //  505 1248:invokevirtual   #317 <Method StringBuilder StringBuilder.append(Object)>
    //  506 1251:invokevirtual   #174 <Method String StringBuilder.toString()>
    //  507 1254:invokevirtual   #231 <Method void PrintStream.println(String)>
            copy.setValue(weight, 1.0D);
    //  508 1257:aload           8
    //  509 1259:aload_2         
    //  510 1260:dconst_1        
    //  511 1261:invokevirtual   #300 <Method void setValue(Attribute, double)>
            System.out.println((new StringBuilder("Copy with weight attribute set to 1: ")).append(copy).toString());
    //  512 1264:getstatic       #312 <Field PrintStream System.out>
    //  513 1267:new             #160 <Class StringBuilder>
    //  514 1270:dup             
    //  515 1271:ldc2            #465 <String "Copy with weight attribute set to 1: ">
    //  516 1274:invokespecial   #167 <Method void StringBuilder(String)>
    //  517 1277:aload           8
    //  518 1279:invokevirtual   #317 <Method StringBuilder StringBuilder.append(Object)>
    //  519 1282:invokevirtual   #174 <Method String StringBuilder.toString()>
    //  520 1285:invokevirtual   #231 <Method void PrintStream.println(String)>
            copy.setValue(position, "second");
    //  521 1288:aload           8
    //  522 1290:aload           4
    //  523 1292:ldc2            #278 <String "second">
    //  524 1295:invokevirtual   #305 <Method void setValue(Attribute, String)>
            System.out.println((new StringBuilder("Copy with position set to \"second\": ")).append(copy).toString());
    //  525 1298:getstatic       #312 <Field PrintStream System.out>
    //  526 1301:new             #160 <Class StringBuilder>
    //  527 1304:dup             
    //  528 1305:ldc2            #467 <String "Copy with position set to \"second\": ">
    //  529 1308:invokespecial   #167 <Method void StringBuilder(String)>
    //  530 1311:aload           8
    //  531 1313:invokevirtual   #317 <Method StringBuilder StringBuilder.append(Object)>
    //  532 1316:invokevirtual   #174 <Method String StringBuilder.toString()>
    //  533 1319:invokevirtual   #231 <Method void PrintStream.println(String)>
            copy.setValue(2, "first");
    //  534 1322:aload           8
    //  535 1324:iconst_2        
    //  536 1325:ldc2            #273 <String "first">
    //  537 1328:invokevirtual   #470 <Method void setValue(int, String)>
            System.out.println((new StringBuilder("Copy with last attribute set to \"first\": ")).append(copy).toString());
    //  538 1331:getstatic       #312 <Field PrintStream System.out>
    //  539 1334:new             #160 <Class StringBuilder>
    //  540 1337:dup             
    //  541 1338:ldc2            #472 <String "Copy with last attribute set to \"first\": ">
    //  542 1341:invokespecial   #167 <Method void StringBuilder(String)>
    //  543 1344:aload           8
    //  544 1346:invokevirtual   #317 <Method StringBuilder StringBuilder.append(Object)>
    //  545 1349:invokevirtual   #174 <Method String StringBuilder.toString()>
    //  546 1352:invokevirtual   #231 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Current weight of instance copy: ")).append(copy.weight()).toString());
    //  547 1355:getstatic       #312 <Field PrintStream System.out>
    //  548 1358:new             #160 <Class StringBuilder>
    //  549 1361:dup             
    //  550 1362:ldc2            #474 <String "Current weight of instance copy: ">
    //  551 1365:invokespecial   #167 <Method void StringBuilder(String)>
    //  552 1368:aload           8
    //  553 1370:invokevirtual   #476 <Method double weight()>
    //  554 1373:invokevirtual   #229 <Method StringBuilder StringBuilder.append(double)>
    //  555 1376:invokevirtual   #174 <Method String StringBuilder.toString()>
    //  556 1379:invokevirtual   #231 <Method void PrintStream.println(String)>
            copy.setWeight(2D);
    //  557 1382:aload           8
    //  558 1384:ldc2w           #430 <Double 2D>
    //  559 1387:invokevirtual   #479 <Method void setWeight(double)>
            System.out.println((new StringBuilder("Current weight of instance copy (set to 2): ")).append(copy.weight()).toString());
    //  560 1390:getstatic       #312 <Field PrintStream System.out>
    //  561 1393:new             #160 <Class StringBuilder>
    //  562 1396:dup             
    //  563 1397:ldc2            #481 <String "Current weight of instance copy (set to 2): ">
    //  564 1400:invokespecial   #167 <Method void StringBuilder(String)>
    //  565 1403:aload           8
    //  566 1405:invokevirtual   #476 <Method double weight()>
    //  567 1408:invokevirtual   #229 <Method StringBuilder StringBuilder.append(double)>
    //  568 1411:invokevirtual   #174 <Method String StringBuilder.toString()>
    //  569 1414:invokevirtual   #231 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Last value of copy: ")).append(copy.toString(2)).toString());
    //  570 1417:getstatic       #312 <Field PrintStream System.out>
    //  571 1420:new             #160 <Class StringBuilder>
    //  572 1423:dup             
    //  573 1424:ldc2            #483 <String "Last value of copy: ">
    //  574 1427:invokespecial   #167 <Method void StringBuilder(String)>
    //  575 1430:aload           8
    //  576 1432:iconst_2        
    //  577 1433:invokevirtual   #485 <Method String toString(int)>
    //  578 1436:invokevirtual   #172 <Method StringBuilder StringBuilder.append(String)>
    //  579 1439:invokevirtual   #174 <Method String StringBuilder.toString()>
    //  580 1442:invokevirtual   #231 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Value of position for copy: ")).append(copy.toString(position)).toString());
    //  581 1445:getstatic       #312 <Field PrintStream System.out>
    //  582 1448:new             #160 <Class StringBuilder>
    //  583 1451:dup             
    //  584 1452:ldc2            #487 <String "Value of position for copy: ">
    //  585 1455:invokespecial   #167 <Method void StringBuilder(String)>
    //  586 1458:aload           8
    //  587 1460:aload           4
    //  588 1462:invokevirtual   #490 <Method String toString(Attribute)>
    //  589 1465:invokevirtual   #172 <Method StringBuilder StringBuilder.append(String)>
    //  590 1468:invokevirtual   #174 <Method String StringBuilder.toString()>
    //  591 1471:invokevirtual   #231 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Last value of copy (internal format): ")).append(copy.value(2)).toString());
    //  592 1474:getstatic       #312 <Field PrintStream System.out>
    //  593 1477:new             #160 <Class StringBuilder>
    //  594 1480:dup             
    //  595 1481:ldc2            #492 <String "Last value of copy (internal format): ">
    //  596 1484:invokespecial   #167 <Method void StringBuilder(String)>
    //  597 1487:aload           8
    //  598 1489:iconst_2        
    //  599 1490:invokevirtual   #94  <Method double value(int)>
    //  600 1493:invokevirtual   #229 <Method StringBuilder StringBuilder.append(double)>
    //  601 1496:invokevirtual   #174 <Method String StringBuilder.toString()>
    //  602 1499:invokevirtual   #231 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Value of position for copy (internal format): ")).append(copy.value(position)).toString());
    //  603 1502:getstatic       #312 <Field PrintStream System.out>
    //  604 1505:new             #160 <Class StringBuilder>
    //  605 1508:dup             
    //  606 1509:ldc2            #494 <String "Value of position for copy (internal format): ">
    //  607 1512:invokespecial   #167 <Method void StringBuilder(String)>
    //  608 1515:aload           8
    //  609 1517:aload           4
    //  610 1519:invokevirtual   #417 <Method double value(Attribute)>
    //  611 1522:invokevirtual   #229 <Method StringBuilder StringBuilder.append(double)>
    //  612 1525:invokevirtual   #174 <Method String StringBuilder.toString()>
    //  613 1528:invokevirtual   #231 <Method void PrintStream.println(String)>
        }
    //* 614 1531:goto            1539
        catch(Exception e)
    //* 615 1534:astore_1        
        {
            e.printStackTrace();
    //  616 1535:aload_1         
    //  617 1536:invokevirtual   #206 <Method void Exception.printStackTrace()>
        }
    //  618 1539:return          
    }

    protected int m_Indices[];
    protected int m_NumAttributes;
}
