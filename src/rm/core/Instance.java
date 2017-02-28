// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   Instance.java

package rm.core;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.Enumeration;

// Referenced classes of package rm.core:
//            UnassignedDatasetException, Instances, UnassignedClassException, Attribute, 
//            Utils, FastVector

public class Instance
    implements Serializable
{

    public Instance(Instance instance)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #22  <Method void Object()>
        m_AttValues = instance.m_AttValues;
    //    2    4:aload_0         
    //    3    5:aload_1         
    //    4    6:getfield        #24  <Field double[] m_AttValues>
    //    5    9:putfield        #24  <Field double[] m_AttValues>
        m_Weight = instance.m_Weight;
    //    6   12:aload_0         
    //    7   13:aload_1         
    //    8   14:getfield        #26  <Field double m_Weight>
    //    9   17:putfield        #26  <Field double m_Weight>
        m_Dataset = null;
    //   10   20:aload_0         
    //   11   21:aconst_null     
    //   12   22:putfield        #28  <Field Instances m_Dataset>
    //   13   25:return          
    }

    public Instance(double weight, double attValues[])
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #22  <Method void Object()>
        m_AttValues = attValues;
    //    2    4:aload_0         
    //    3    5:aload_3         
    //    4    6:putfield        #24  <Field double[] m_AttValues>
        m_Weight = weight;
    //    5    9:aload_0         
    //    6   10:dload_1         
    //    7   11:putfield        #26  <Field double m_Weight>
        m_Dataset = null;
    //    8   14:aload_0         
    //    9   15:aconst_null     
    //   10   16:putfield        #28  <Field Instances m_Dataset>
    //   11   19:return          
    }

    public Instance(int numAttributes)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #22  <Method void Object()>
        m_AttValues = new double[numAttributes];
    //    2    4:aload_0         
    //    3    5:iload_1         
    //    4    6:newarray        double[]
    //    5    8:putfield        #24  <Field double[] m_AttValues>
        for(int i = 0; i < m_AttValues.length; i++)
    //*   6   11:iconst_0        
    //*   7   12:istore_2        
    //*   8   13:goto            28
            m_AttValues[i] = (0.0D / 0.0D);
    //    9   16:aload_0         
    //   10   17:getfield        #24  <Field double[] m_AttValues>
    //   11   20:iload_2         
    //   12   21:ldc2w           #38  <Double (0.0D / 0.0D)>
    //   13   24:dastore         

    //   14   25:iinc            2  1
    //   15   28:iload_2         
    //   16   29:aload_0         
    //   17   30:getfield        #24  <Field double[] m_AttValues>
    //   18   33:arraylength     
    //   19   34:icmplt          16
        m_Weight = 1.0D;
    //   20   37:aload_0         
    //   21   38:dconst_1        
    //   22   39:putfield        #26  <Field double m_Weight>
        m_Dataset = null;
    //   23   42:aload_0         
    //   24   43:aconst_null     
    //   25   44:putfield        #28  <Field Instances m_Dataset>
    //   26   47:return          
    }

    public Attribute attribute(int index)
    {
        if(m_Dataset == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #28  <Field Instances m_Dataset>
    //*   2    4:ifnonnull       17
            throw new UnassignedDatasetException("Instance doesn't have access to a dataset!");
    //    3    7:new             #46  <Class UnassignedDatasetException>
    //    4   10:dup             
    //    5   11:ldc1            #48  <String "Instance doesn't have access to a dataset!">
    //    6   13:invokespecial   #51  <Method void UnassignedDatasetException(String)>
    //    7   16:athrow          
        else
            return m_Dataset.attribute(index);
    //    8   17:aload_0         
    //    9   18:getfield        #28  <Field Instances m_Dataset>
    //   10   21:iload_1         
    //   11   22:invokevirtual   #55  <Method Attribute Instances.attribute(int)>
    //   12   25:areturn         
    }

    public Attribute attributeSparse(int indexOfIndex)
    {
        if(m_Dataset == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #28  <Field Instances m_Dataset>
    //*   2    4:ifnonnull       17
            throw new UnassignedDatasetException("Instance doesn't have access to a dataset!");
    //    3    7:new             #46  <Class UnassignedDatasetException>
    //    4   10:dup             
    //    5   11:ldc1            #48  <String "Instance doesn't have access to a dataset!">
    //    6   13:invokespecial   #51  <Method void UnassignedDatasetException(String)>
    //    7   16:athrow          
        else
            return m_Dataset.attribute(indexOfIndex);
    //    8   17:aload_0         
    //    9   18:getfield        #28  <Field Instances m_Dataset>
    //   10   21:iload_1         
    //   11   22:invokevirtual   #55  <Method Attribute Instances.attribute(int)>
    //   12   25:areturn         
    }

    public Attribute classAttribute()
    {
        if(m_Dataset == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #28  <Field Instances m_Dataset>
    //*   2    4:ifnonnull       17
            throw new UnassignedDatasetException("Instance doesn't have access to a dataset!");
    //    3    7:new             #46  <Class UnassignedDatasetException>
    //    4   10:dup             
    //    5   11:ldc1            #48  <String "Instance doesn't have access to a dataset!">
    //    6   13:invokespecial   #51  <Method void UnassignedDatasetException(String)>
    //    7   16:athrow          
        else
            return m_Dataset.classAttribute();
    //    8   17:aload_0         
    //    9   18:getfield        #28  <Field Instances m_Dataset>
    //   10   21:invokevirtual   #62  <Method Attribute Instances.classAttribute()>
    //   11   24:areturn         
    }

    public int classIndex()
    {
        if(m_Dataset == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #28  <Field Instances m_Dataset>
    //*   2    4:ifnonnull       17
            throw new UnassignedDatasetException("Instance doesn't have access to a dataset!");
    //    3    7:new             #46  <Class UnassignedDatasetException>
    //    4   10:dup             
    //    5   11:ldc1            #48  <String "Instance doesn't have access to a dataset!">
    //    6   13:invokespecial   #51  <Method void UnassignedDatasetException(String)>
    //    7   16:athrow          
        else
            return m_Dataset.classIndex();
    //    8   17:aload_0         
    //    9   18:getfield        #28  <Field Instances m_Dataset>
    //   10   21:invokevirtual   #66  <Method int Instances.classIndex()>
    //   11   24:ireturn         
    }

    public boolean classIsMissing()
    {
        if(classIndex() < 0)
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #69  <Method int classIndex()>
    //*   2    4:ifge            17
            throw new UnassignedClassException("Class is not set!");
    //    3    7:new             #71  <Class UnassignedClassException>
    //    4   10:dup             
    //    5   11:ldc1            #73  <String "Class is not set!">
    //    6   13:invokespecial   #74  <Method void UnassignedClassException(String)>
    //    7   16:athrow          
        else
            return isMissing(classIndex());
    //    8   17:aload_0         
    //    9   18:aload_0         
    //   10   19:invokevirtual   #69  <Method int classIndex()>
    //   11   22:invokevirtual   #78  <Method boolean isMissing(int)>
    //   12   25:ireturn         
    }

    public double classValue()
    {
        if(classIndex() < 0)
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #69  <Method int classIndex()>
    //*   2    4:ifge            17
            throw new UnassignedClassException("Class is not set!");
    //    3    7:new             #71  <Class UnassignedClassException>
    //    4   10:dup             
    //    5   11:ldc1            #73  <String "Class is not set!">
    //    6   13:invokespecial   #74  <Method void UnassignedClassException(String)>
    //    7   16:athrow          
        else
            return value(classIndex());
    //    8   17:aload_0         
    //    9   18:aload_0         
    //   10   19:invokevirtual   #69  <Method int classIndex()>
    //   11   22:invokevirtual   #84  <Method double value(int)>
    //   12   25:dreturn         
    }

    public Object copy()
    {
        Instance result = new Instance(this);
    //    0    0:new             #2   <Class Instance>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:invokespecial   #88  <Method void Instance(Instance)>
    //    4    8:astore_1        
        result.m_Dataset = m_Dataset;
    //    5    9:aload_1         
    //    6   10:aload_0         
    //    7   11:getfield        #28  <Field Instances m_Dataset>
    //    8   14:putfield        #28  <Field Instances m_Dataset>
        return result;
    //    9   17:aload_1         
    //   10   18:areturn         
    }

    public Instances dataset()
    {
        return m_Dataset;
    //    0    0:aload_0         
    //    1    1:getfield        #28  <Field Instances m_Dataset>
    //    2    4:areturn         
    }

    public void deleteAttributeAt(int position)
    {
        if(m_Dataset != null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #28  <Field Instances m_Dataset>
    //*   2    4:ifnull          17
        {
            throw new RuntimeException("Instance has access to a dataset!");
    //    3    7:new             #94  <Class RuntimeException>
    //    4   10:dup             
    //    5   11:ldc1            #96  <String "Instance has access to a dataset!">
    //    6   13:invokespecial   #97  <Method void RuntimeException(String)>
    //    7   16:athrow          
        } else
        {
            forceDeleteAttributeAt(position);
    //    8   17:aload_0         
    //    9   18:iload_1         
    //   10   19:invokevirtual   #100 <Method void forceDeleteAttributeAt(int)>
            return;
    //   11   22:return          
        }
    }

    public Enumeration enumerateAttributes()
    {
        if(m_Dataset == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #28  <Field Instances m_Dataset>
    //*   2    4:ifnonnull       17
            throw new UnassignedDatasetException("Instance doesn't have access to a dataset!");
    //    3    7:new             #46  <Class UnassignedDatasetException>
    //    4   10:dup             
    //    5   11:ldc1            #48  <String "Instance doesn't have access to a dataset!">
    //    6   13:invokespecial   #51  <Method void UnassignedDatasetException(String)>
    //    7   16:athrow          
        else
            return m_Dataset.enumerateAttributes();
    //    8   17:aload_0         
    //    9   18:getfield        #28  <Field Instances m_Dataset>
    //   10   21:invokevirtual   #105 <Method Enumeration Instances.enumerateAttributes()>
    //   11   24:areturn         
    }

    public boolean equalHeaders(Instance inst)
    {
        if(m_Dataset == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #28  <Field Instances m_Dataset>
    //*   2    4:ifnonnull       17
            throw new UnassignedDatasetException("Instance doesn't have access to a dataset!");
    //    3    7:new             #46  <Class UnassignedDatasetException>
    //    4   10:dup             
    //    5   11:ldc1            #48  <String "Instance doesn't have access to a dataset!">
    //    6   13:invokespecial   #51  <Method void UnassignedDatasetException(String)>
    //    7   16:athrow          
        else
            return m_Dataset.equalHeaders(inst.m_Dataset);
    //    8   17:aload_0         
    //    9   18:getfield        #28  <Field Instances m_Dataset>
    //   10   21:aload_1         
    //   11   22:getfield        #28  <Field Instances m_Dataset>
    //   12   25:invokevirtual   #110 <Method boolean Instances.equalHeaders(Instances)>
    //   13   28:ireturn         
    }

    public boolean hasMissingValue()
    {
        if(m_Dataset == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #28  <Field Instances m_Dataset>
    //*   2    4:ifnonnull       17
            throw new UnassignedDatasetException("Instance doesn't have access to a dataset!");
    //    3    7:new             #46  <Class UnassignedDatasetException>
    //    4   10:dup             
    //    5   11:ldc1            #48  <String "Instance doesn't have access to a dataset!">
    //    6   13:invokespecial   #51  <Method void UnassignedDatasetException(String)>
    //    7   16:athrow          
        for(int i = 0; i < numAttributes(); i++)
    //*   8   17:iconst_0        
    //*   9   18:istore_1        
    //*  10   19:goto            43
            if(i != classIndex() && isMissing(i))
    //*  11   22:iload_1         
    //*  12   23:aload_0         
    //*  13   24:invokevirtual   #69  <Method int classIndex()>
    //*  14   27:icmpeq          40
    //*  15   30:aload_0         
    //*  16   31:iload_1         
    //*  17   32:invokevirtual   #78  <Method boolean isMissing(int)>
    //*  18   35:ifeq            40
                return true;
    //   19   38:iconst_1        
    //   20   39:ireturn         

    //   21   40:iinc            1  1
    //   22   43:iload_1         
    //   23   44:aload_0         
    //   24   45:invokevirtual   #114 <Method int numAttributes()>
    //   25   48:icmplt          22
        return false;
    //   26   51:iconst_0        
    //   27   52:ireturn         
    }

    public int index(int position)
    {
        return position;
    //    0    0:iload_1         
    //    1    1:ireturn         
    }

    public void insertAttributeAt(int position)
    {
        if(m_Dataset != null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #28  <Field Instances m_Dataset>
    //*   2    4:ifnull          17
            throw new RuntimeException("Instance has accesss to a dataset!");
    //    3    7:new             #94  <Class RuntimeException>
    //    4   10:dup             
    //    5   11:ldc1            #118 <String "Instance has accesss to a dataset!">
    //    6   13:invokespecial   #97  <Method void RuntimeException(String)>
    //    7   16:athrow          
        if(position < 0 || position > numAttributes())
    //*   8   17:iload_1         
    //*   9   18:iflt            29
    //*  10   21:iload_1         
    //*  11   22:aload_0         
    //*  12   23:invokevirtual   #114 <Method int numAttributes()>
    //*  13   26:icmple          39
        {
            throw new IllegalArgumentException("Can't insert attribute: index out of range");
    //   14   29:new             #120 <Class IllegalArgumentException>
    //   15   32:dup             
    //   16   33:ldc1            #122 <String "Can't insert attribute: index out of range">
    //   17   35:invokespecial   #123 <Method void IllegalArgumentException(String)>
    //   18   38:athrow          
        } else
        {
            forceInsertAttributeAt(position);
    //   19   39:aload_0         
    //   20   40:iload_1         
    //   21   41:invokevirtual   #126 <Method void forceInsertAttributeAt(int)>
            return;
    //   22   44:return          
        }
    }

    public boolean isMissing(int attIndex)
    {
        return Double.isNaN(m_AttValues[attIndex]);
    //    0    0:aload_0         
    //    1    1:getfield        #24  <Field double[] m_AttValues>
    //    2    4:iload_1         
    //    3    5:daload          
    //    4    6:invokestatic    #132 <Method boolean Double.isNaN(double)>
    //    5    9:ifeq            14
    //    6   12:iconst_1        
    //    7   13:ireturn         
    //    8   14:iconst_0        
    //    9   15:ireturn         
    }

    public boolean isMissingSparse(int indexOfIndex)
    {
        return Double.isNaN(m_AttValues[indexOfIndex]);
    //    0    0:aload_0         
    //    1    1:getfield        #24  <Field double[] m_AttValues>
    //    2    4:iload_1         
    //    3    5:daload          
    //    4    6:invokestatic    #132 <Method boolean Double.isNaN(double)>
    //    5    9:ifeq            14
    //    6   12:iconst_1        
    //    7   13:ireturn         
    //    8   14:iconst_0        
    //    9   15:ireturn         
    }

    public boolean isMissing(Attribute att)
    {
        return isMissing(att.index());
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokevirtual   #139 <Method int Attribute.index()>
    //    3    5:invokevirtual   #78  <Method boolean isMissing(int)>
    //    4    8:ireturn         
    }

    public static boolean isMissingValue(double val)
    {
        return Double.isNaN(val);
    //    0    0:dload_0         
    //    1    1:invokestatic    #132 <Method boolean Double.isNaN(double)>
    //    2    4:ireturn         
    }

    public Instance mergeInstance(Instance inst)
    {
        int m = 0;
    //    0    0:iconst_0        
    //    1    1:istore_2        
        double newVals[] = new double[numAttributes() + inst.numAttributes()];
    //    2    2:aload_0         
    //    3    3:invokevirtual   #114 <Method int numAttributes()>
    //    4    6:aload_1         
    //    5    7:invokevirtual   #114 <Method int numAttributes()>
    //    6   10:iadd            
    //    7   11:newarray        double[]
    //    8   13:astore_3        
        for(int j = 0; j < numAttributes();)
    //*   9   14:iconst_0        
    //*  10   15:istore          4
    //*  11   17:goto            35
        {
            newVals[m] = value(j);
    //   12   20:aload_3         
    //   13   21:iload_2         
    //   14   22:aload_0         
    //   15   23:iload           4
    //   16   25:invokevirtual   #84  <Method double value(int)>
    //   17   28:dastore         
            j++;
    //   18   29:iinc            4  1
            m++;
    //   19   32:iinc            2  1
        }

    //   20   35:iload           4
    //   21   37:aload_0         
    //   22   38:invokevirtual   #114 <Method int numAttributes()>
    //   23   41:icmplt          20
        for(int j = 0; j < inst.numAttributes();)
    //*  24   44:iconst_0        
    //*  25   45:istore          4
    //*  26   47:goto            65
        {
            newVals[m] = inst.value(j);
    //   27   50:aload_3         
    //   28   51:iload_2         
    //   29   52:aload_1         
    //   30   53:iload           4
    //   31   55:invokevirtual   #84  <Method double value(int)>
    //   32   58:dastore         
            j++;
    //   33   59:iinc            4  1
            m++;
    //   34   62:iinc            2  1
        }

    //   35   65:iload           4
    //   36   67:aload_1         
    //   37   68:invokevirtual   #114 <Method int numAttributes()>
    //   38   71:icmplt          50
        return new Instance(1.0D, newVals);
    //   39   74:new             #2   <Class Instance>
    //   40   77:dup             
    //   41   78:dconst_1        
    //   42   79:aload_3         
    //   43   80:invokespecial   #147 <Method void Instance(double, double[])>
    //   44   83:areturn         
    }

    public static double missingValue()
    {
        return (0.0D / 0.0D);
    //    0    0:ldc2w           #152 <Double (0.0D / 0.0D)>
    //    1    3:dreturn         
    }

    public int numAttributes()
    {
        return m_AttValues.length;
    //    0    0:aload_0         
    //    1    1:getfield        #24  <Field double[] m_AttValues>
    //    2    4:arraylength     
    //    3    5:ireturn         
    }

    public int numClasses()
    {
        if(m_Dataset == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #28  <Field Instances m_Dataset>
    //*   2    4:ifnonnull       17
            throw new UnassignedDatasetException("Instance doesn't have access to a dataset!");
    //    3    7:new             #46  <Class UnassignedDatasetException>
    //    4   10:dup             
    //    5   11:ldc1            #48  <String "Instance doesn't have access to a dataset!">
    //    6   13:invokespecial   #51  <Method void UnassignedDatasetException(String)>
    //    7   16:athrow          
        else
            return m_Dataset.numClasses();
    //    8   17:aload_0         
    //    9   18:getfield        #28  <Field Instances m_Dataset>
    //   10   21:invokevirtual   #156 <Method int Instances.numClasses()>
    //   11   24:ireturn         
    }

    public int numValues()
    {
        return m_AttValues.length;
    //    0    0:aload_0         
    //    1    1:getfield        #24  <Field double[] m_AttValues>
    //    2    4:arraylength     
    //    3    5:ireturn         
    }

    public void replaceMissingValues(double array[])
    {
        if(array == null || array.length != m_AttValues.length)
    //*   0    0:aload_1         
    //*   1    1:ifnull          14
    //*   2    4:aload_1         
    //*   3    5:arraylength     
    //*   4    6:aload_0         
    //*   5    7:getfield        #24  <Field double[] m_AttValues>
    //*   6   10:arraylength     
    //*   7   11:icmpeq          24
            throw new IllegalArgumentException("Unequal number of attributes!");
    //    8   14:new             #120 <Class IllegalArgumentException>
    //    9   17:dup             
    //   10   18:ldc1            #161 <String "Unequal number of attributes!">
    //   11   20:invokespecial   #123 <Method void IllegalArgumentException(String)>
    //   12   23:athrow          
        freshAttributeVector();
    //   13   24:aload_0         
    //   14   25:invokespecial   #164 <Method void freshAttributeVector()>
        for(int i = 0; i < m_AttValues.length; i++)
    //*  15   28:iconst_0        
    //*  16   29:istore_2        
    //*  17   30:goto            53
            if(isMissing(i))
    //*  18   33:aload_0         
    //*  19   34:iload_2         
    //*  20   35:invokevirtual   #78  <Method boolean isMissing(int)>
    //*  21   38:ifeq            50
                m_AttValues[i] = array[i];
    //   22   41:aload_0         
    //   23   42:getfield        #24  <Field double[] m_AttValues>
    //   24   45:iload_2         
    //   25   46:aload_1         
    //   26   47:iload_2         
    //   27   48:daload          
    //   28   49:dastore         

    //   29   50:iinc            2  1
    //   30   53:iload_2         
    //   31   54:aload_0         
    //   32   55:getfield        #24  <Field double[] m_AttValues>
    //   33   58:arraylength     
    //   34   59:icmplt          33
    //   35   62:return          
    }

    public void setClassMissing()
    {
        if(classIndex() < 0)
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #69  <Method int classIndex()>
    //*   2    4:ifge            17
        {
            throw new UnassignedClassException("Class is not set!");
    //    3    7:new             #71  <Class UnassignedClassException>
    //    4   10:dup             
    //    5   11:ldc1            #73  <String "Class is not set!">
    //    6   13:invokespecial   #74  <Method void UnassignedClassException(String)>
    //    7   16:athrow          
        } else
        {
            setMissing(classIndex());
    //    8   17:aload_0         
    //    9   18:aload_0         
    //   10   19:invokevirtual   #69  <Method int classIndex()>
    //   11   22:invokevirtual   #169 <Method void setMissing(int)>
            return;
    //   12   25:return          
        }
    }

    public void setClassValue(double value)
    {
        if(classIndex() < 0)
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #69  <Method int classIndex()>
    //*   2    4:ifge            17
        {
            throw new UnassignedClassException("Class is not set!");
    //    3    7:new             #71  <Class UnassignedClassException>
    //    4   10:dup             
    //    5   11:ldc1            #73  <String "Class is not set!">
    //    6   13:invokespecial   #74  <Method void UnassignedClassException(String)>
    //    7   16:athrow          
        } else
        {
            setValue(classIndex(), value);
    //    8   17:aload_0         
    //    9   18:aload_0         
    //   10   19:invokevirtual   #69  <Method int classIndex()>
    //   11   22:dload_1         
    //   12   23:invokevirtual   #175 <Method void setValue(int, double)>
            return;
    //   13   26:return          
        }
    }

    public final void setClassValue(String value)
    {
        if(classIndex() < 0)
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #69  <Method int classIndex()>
    //*   2    4:ifge            17
        {
            throw new UnassignedClassException("Class is not set!");
    //    3    7:new             #71  <Class UnassignedClassException>
    //    4   10:dup             
    //    5   11:ldc1            #73  <String "Class is not set!">
    //    6   13:invokespecial   #74  <Method void UnassignedClassException(String)>
    //    7   16:athrow          
        } else
        {
            setValue(classIndex(), value);
    //    8   17:aload_0         
    //    9   18:aload_0         
    //   10   19:invokevirtual   #69  <Method int classIndex()>
    //   11   22:aload_1         
    //   12   23:invokevirtual   #178 <Method void setValue(int, String)>
            return;
    //   13   26:return          
        }
    }

    public final void setDataset(Instances instances)
    {
        m_Dataset = instances;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #28  <Field Instances m_Dataset>
    //    3    5:return          
    }

    public final void setMissing(int attIndex)
    {
        setValue(attIndex, (0.0D / 0.0D));
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:ldc2w           #183 <Double (0.0D / 0.0D)>
    //    3    5:invokevirtual   #175 <Method void setValue(int, double)>
    //    4    8:return          
    }

    public final void setMissing(Attribute att)
    {
        setMissing(att.index());
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokevirtual   #139 <Method int Attribute.index()>
    //    3    5:invokevirtual   #169 <Method void setMissing(int)>
    //    4    8:return          
    }

    public void setValue(int attIndex, double value)
    {
        freshAttributeVector();
    //    0    0:aload_0         
    //    1    1:invokespecial   #164 <Method void freshAttributeVector()>
        m_AttValues[attIndex] = value;
    //    2    4:aload_0         
    //    3    5:getfield        #24  <Field double[] m_AttValues>
    //    4    8:iload_1         
    //    5    9:dload_2         
    //    6   10:dastore         
    //    7   11:return          
    }

    public void setValueSparse(int indexOfIndex, double value)
    {
        freshAttributeVector();
    //    0    0:aload_0         
    //    1    1:invokespecial   #164 <Method void freshAttributeVector()>
        m_AttValues[indexOfIndex] = value;
    //    2    4:aload_0         
    //    3    5:getfield        #24  <Field double[] m_AttValues>
    //    4    8:iload_1         
    //    5    9:dload_2         
    //    6   10:dastore         
    //    7   11:return          
    }

    public final void setValue(int attIndex, String value)
    {
        if(m_Dataset == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #28  <Field Instances m_Dataset>
    //*   2    4:ifnonnull       17
            throw new UnassignedDatasetException("Instance doesn't have access to a dataset!");
    //    3    7:new             #46  <Class UnassignedDatasetException>
    //    4   10:dup             
    //    5   11:ldc1            #48  <String "Instance doesn't have access to a dataset!">
    //    6   13:invokespecial   #51  <Method void UnassignedDatasetException(String)>
    //    7   16:athrow          
        if(!attribute(attIndex).isNominal() && !attribute(attIndex).isString())
    //*   8   17:aload_0         
    //*   9   18:iload_1         
    //*  10   19:invokevirtual   #187 <Method Attribute attribute(int)>
    //*  11   22:invokevirtual   #190 <Method boolean Attribute.isNominal()>
    //*  12   25:ifne            49
    //*  13   28:aload_0         
    //*  14   29:iload_1         
    //*  15   30:invokevirtual   #187 <Method Attribute attribute(int)>
    //*  16   33:invokevirtual   #193 <Method boolean Attribute.isString()>
    //*  17   36:ifne            49
            throw new IllegalArgumentException("Attribute neither nominal nor string!");
    //   18   39:new             #120 <Class IllegalArgumentException>
    //   19   42:dup             
    //   20   43:ldc1            #195 <String "Attribute neither nominal nor string!">
    //   21   45:invokespecial   #123 <Method void IllegalArgumentException(String)>
    //   22   48:athrow          
        int valIndex = attribute(attIndex).indexOfValue(value);
    //   23   49:aload_0         
    //   24   50:iload_1         
    //   25   51:invokevirtual   #187 <Method Attribute attribute(int)>
    //   26   54:aload_2         
    //   27   55:invokevirtual   #199 <Method int Attribute.indexOfValue(String)>
    //   28   58:istore_3        
        if(valIndex == -1)
    //*  29   59:iload_3         
    //*  30   60:iconst_m1       
    //*  31   61:icmpne          104
        {
            if(attribute(attIndex).isNominal())
    //*  32   64:aload_0         
    //*  33   65:iload_1         
    //*  34   66:invokevirtual   #187 <Method Attribute attribute(int)>
    //*  35   69:invokevirtual   #190 <Method boolean Attribute.isNominal()>
    //*  36   72:ifeq            85
                throw new IllegalArgumentException("Value not defined for given nominal attribute!");
    //   37   75:new             #120 <Class IllegalArgumentException>
    //   38   78:dup             
    //   39   79:ldc1            #201 <String "Value not defined for given nominal attribute!">
    //   40   81:invokespecial   #123 <Method void IllegalArgumentException(String)>
    //   41   84:athrow          
            attribute(attIndex).forceAddValue(value);
    //   42   85:aload_0         
    //   43   86:iload_1         
    //   44   87:invokevirtual   #187 <Method Attribute attribute(int)>
    //   45   90:aload_2         
    //   46   91:invokevirtual   #204 <Method void Attribute.forceAddValue(String)>
            valIndex = attribute(attIndex).indexOfValue(value);
    //   47   94:aload_0         
    //   48   95:iload_1         
    //   49   96:invokevirtual   #187 <Method Attribute attribute(int)>
    //   50   99:aload_2         
    //   51  100:invokevirtual   #199 <Method int Attribute.indexOfValue(String)>
    //   52  103:istore_3        
        }
        setValue(attIndex, valIndex);
    //   53  104:aload_0         
    //   54  105:iload_1         
    //   55  106:iload_3         
    //   56  107:i2d             
    //   57  108:invokevirtual   #175 <Method void setValue(int, double)>
    //   58  111:return          
    }

    public final void setValue(Attribute att, double value)
    {
        setValue(att.index(), value);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokevirtual   #139 <Method int Attribute.index()>
    //    3    5:dload_2         
    //    4    6:invokevirtual   #175 <Method void setValue(int, double)>
    //    5    9:return          
    }

    public final void setValue(Attribute att, String value)
    {
        if(!att.isNominal() && !att.isString())
    //*   0    0:aload_1         
    //*   1    1:invokevirtual   #190 <Method boolean Attribute.isNominal()>
    //*   2    4:ifne            24
    //*   3    7:aload_1         
    //*   4    8:invokevirtual   #193 <Method boolean Attribute.isString()>
    //*   5   11:ifne            24
            throw new IllegalArgumentException("Attribute neither nominal nor string!");
    //    6   14:new             #120 <Class IllegalArgumentException>
    //    7   17:dup             
    //    8   18:ldc1            #195 <String "Attribute neither nominal nor string!">
    //    9   20:invokespecial   #123 <Method void IllegalArgumentException(String)>
    //   10   23:athrow          
        int valIndex = att.indexOfValue(value);
    //   11   24:aload_1         
    //   12   25:aload_2         
    //   13   26:invokevirtual   #199 <Method int Attribute.indexOfValue(String)>
    //   14   29:istore_3        
        if(valIndex == -1)
    //*  15   30:iload_3         
    //*  16   31:iconst_m1       
    //*  17   32:icmpne          63
        {
            if(att.isNominal())
    //*  18   35:aload_1         
    //*  19   36:invokevirtual   #190 <Method boolean Attribute.isNominal()>
    //*  20   39:ifeq            52
                throw new IllegalArgumentException("Value not defined for given nominal attribute!");
    //   21   42:new             #120 <Class IllegalArgumentException>
    //   22   45:dup             
    //   23   46:ldc1            #201 <String "Value not defined for given nominal attribute!">
    //   24   48:invokespecial   #123 <Method void IllegalArgumentException(String)>
    //   25   51:athrow          
            att.forceAddValue(value);
    //   26   52:aload_1         
    //   27   53:aload_2         
    //   28   54:invokevirtual   #204 <Method void Attribute.forceAddValue(String)>
            valIndex = att.indexOfValue(value);
    //   29   57:aload_1         
    //   30   58:aload_2         
    //   31   59:invokevirtual   #199 <Method int Attribute.indexOfValue(String)>
    //   32   62:istore_3        
        }
        setValue(att.index(), valIndex);
    //   33   63:aload_0         
    //   34   64:aload_1         
    //   35   65:invokevirtual   #139 <Method int Attribute.index()>
    //   36   68:iload_3         
    //   37   69:i2d             
    //   38   70:invokevirtual   #175 <Method void setValue(int, double)>
    //   39   73:return          
    }

    public final void setWeight(double weight)
    {
        m_Weight = weight;
    //    0    0:aload_0         
    //    1    1:dload_1         
    //    2    2:putfield        #26  <Field double m_Weight>
    //    3    5:return          
    }

    public final Instances relationalValue(int attIndex)
    {
        if(m_Dataset == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #28  <Field Instances m_Dataset>
    //*   2    4:ifnonnull       17
            throw new UnassignedDatasetException("Instance doesn't have access to a dataset!");
    //    3    7:new             #46  <Class UnassignedDatasetException>
    //    4   10:dup             
    //    5   11:ldc1            #48  <String "Instance doesn't have access to a dataset!">
    //    6   13:invokespecial   #51  <Method void UnassignedDatasetException(String)>
    //    7   16:athrow          
        else
            return relationalValue(m_Dataset.attribute(attIndex));
    //    8   17:aload_0         
    //    9   18:aload_0         
    //   10   19:getfield        #28  <Field Instances m_Dataset>
    //   11   22:iload_1         
    //   12   23:invokevirtual   #55  <Method Attribute Instances.attribute(int)>
    //   13   26:invokevirtual   #213 <Method Instances relationalValue(Attribute)>
    //   14   29:areturn         
    }

    public final Instances relationalValue(Attribute att)
    {
        int attIndex = att.index();
    //    0    0:aload_1         
    //    1    1:invokevirtual   #139 <Method int Attribute.index()>
    //    2    4:istore_2        
        if(att.isRelationValued())
    //*   3    5:aload_1         
    //*   4    6:invokevirtual   #216 <Method boolean Attribute.isRelationValued()>
    //*   5    9:ifeq            23
            return att.relation((int)value(attIndex));
    //    6   12:aload_1         
    //    7   13:aload_0         
    //    8   14:iload_2         
    //    9   15:invokevirtual   #84  <Method double value(int)>
    //   10   18:d2i             
    //   11   19:invokevirtual   #219 <Method Instances Attribute.relation(int)>
    //   12   22:areturn         
        else
            throw new IllegalArgumentException("Attribute isn't relation-valued!");
    //   13   23:new             #120 <Class IllegalArgumentException>
    //   14   26:dup             
    //   15   27:ldc1            #221 <String "Attribute isn't relation-valued!">
    //   16   29:invokespecial   #123 <Method void IllegalArgumentException(String)>
    //   17   32:athrow          
    }

    public final String stringValue(int attIndex)
    {
        if(m_Dataset == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #28  <Field Instances m_Dataset>
    //*   2    4:ifnonnull       17
            throw new UnassignedDatasetException("Instance doesn't have access to a dataset!");
    //    3    7:new             #46  <Class UnassignedDatasetException>
    //    4   10:dup             
    //    5   11:ldc1            #48  <String "Instance doesn't have access to a dataset!">
    //    6   13:invokespecial   #51  <Method void UnassignedDatasetException(String)>
    //    7   16:athrow          
        else
            return stringValue(m_Dataset.attribute(attIndex));
    //    8   17:aload_0         
    //    9   18:aload_0         
    //   10   19:getfield        #28  <Field Instances m_Dataset>
    //   11   22:iload_1         
    //   12   23:invokevirtual   #55  <Method Attribute Instances.attribute(int)>
    //   13   26:invokevirtual   #226 <Method String stringValue(Attribute)>
    //   14   29:areturn         
    }

    public final String stringValue(Attribute att)
    {
        int attIndex = att.index();
    //    0    0:aload_1         
    //    1    1:invokevirtual   #139 <Method int Attribute.index()>
    //    2    4:istore_2        
        switch(att.type())
    //*   3    5:aload_1         
    //*   4    6:invokevirtual   #229 <Method int Attribute.type()>
        {
    //*   5    9:tableswitch     1 4: default 75
    //                   1 40
    //                   2 40
    //                   3 51
    //                   4 61
        case 1: // '\001'
        case 2: // '\002'
            return att.value((int)value(attIndex));
    //    6   40:aload_1         
    //    7   41:aload_0         
    //    8   42:iload_2         
    //    9   43:invokevirtual   #84  <Method double value(int)>
    //   10   46:d2i             
    //   11   47:invokevirtual   #231 <Method String Attribute.value(int)>
    //   12   50:areturn         

        case 3: // '\003'
            return att.formatDate(value(attIndex));
    //   13   51:aload_1         
    //   14   52:aload_0         
    //   15   53:iload_2         
    //   16   54:invokevirtual   #84  <Method double value(int)>
    //   17   57:invokevirtual   #235 <Method String Attribute.formatDate(double)>
    //   18   60:areturn         

        case 4: // '\004'
            return att.relation((int)value(attIndex)).stringWithoutHeader();
    //   19   61:aload_1         
    //   20   62:aload_0         
    //   21   63:iload_2         
    //   22   64:invokevirtual   #84  <Method double value(int)>
    //   23   67:d2i             
    //   24   68:invokevirtual   #219 <Method Instances Attribute.relation(int)>
    //   25   71:invokevirtual   #239 <Method String Instances.stringWithoutHeader()>
    //   26   74:areturn         
        }
        throw new IllegalArgumentException("Attribute isn't nominal, string or date!");
    //   27   75:new             #120 <Class IllegalArgumentException>
    //   28   78:dup             
    //   29   79:ldc1            #241 <String "Attribute isn't nominal, string or date!">
    //   30   81:invokespecial   #123 <Method void IllegalArgumentException(String)>
    //   31   84:athrow          
    }

    public double[] toDoubleArray()
    {
        double newValues[] = new double[m_AttValues.length];
    //    0    0:aload_0         
    //    1    1:getfield        #24  <Field double[] m_AttValues>
    //    2    4:arraylength     
    //    3    5:newarray        double[]
    //    4    7:astore_1        
        System.arraycopy(m_AttValues, 0, newValues, 0, m_AttValues.length);
    //    5    8:aload_0         
    //    6    9:getfield        #24  <Field double[] m_AttValues>
    //    7   12:iconst_0        
    //    8   13:aload_1         
    //    9   14:iconst_0        
    //   10   15:aload_0         
    //   11   16:getfield        #24  <Field double[] m_AttValues>
    //   12   19:arraylength     
    //   13   20:invokestatic    #249 <Method void System.arraycopy(Object, int, Object, int, int)>
        return newValues;
    //   14   23:aload_1         
    //   15   24:areturn         
    }

    public String toString()
    {
        StringBuffer text = new StringBuffer();
    //    0    0:new             #253 <Class StringBuffer>
    //    1    3:dup             
    //    2    4:invokespecial   #254 <Method void StringBuffer()>
    //    3    7:astore_1        
        for(int i = 0; i < m_AttValues.length; i++)
    //*   4    8:iconst_0        
    //*   5    9:istore_2        
    //*   6   10:goto            38
        {
            if(i > 0)
    //*   7   13:iload_2         
    //*   8   14:ifle            25
                text.append(",");
    //    9   17:aload_1         
    //   10   18:ldc2            #256 <String ",">
    //   11   21:invokevirtual   #260 <Method StringBuffer StringBuffer.append(String)>
    //   12   24:pop             
            text.append(toString(i));
    //   13   25:aload_1         
    //   14   26:aload_0         
    //   15   27:iload_2         
    //   16   28:invokevirtual   #262 <Method String toString(int)>
    //   17   31:invokevirtual   #260 <Method StringBuffer StringBuffer.append(String)>
    //   18   34:pop             
        }

    //   19   35:iinc            2  1
    //   20   38:iload_2         
    //   21   39:aload_0         
    //   22   40:getfield        #24  <Field double[] m_AttValues>
    //   23   43:arraylength     
    //   24   44:icmplt          13
        if(m_Weight != 1.0D)
    //*  25   47:aload_0         
    //*  26   48:getfield        #26  <Field double m_Weight>
    //*  27   51:dconst_1        
    //*  28   52:dcmpl           
    //*  29   53:ifeq            92
            text.append((new StringBuilder(",{")).append(Utils.doubleToString(m_Weight, 6)).append("}").toString());
    //   30   56:aload_1         
    //   31   57:new             #264 <Class StringBuilder>
    //   32   60:dup             
    //   33   61:ldc2            #266 <String ",{">
    //   34   64:invokespecial   #267 <Method void StringBuilder(String)>
    //   35   67:aload_0         
    //   36   68:getfield        #26  <Field double m_Weight>
    //   37   71:bipush          6
    //   38   73:invokestatic    #273 <Method String Utils.doubleToString(double, int)>
    //   39   76:invokevirtual   #276 <Method StringBuilder StringBuilder.append(String)>
    //   40   79:ldc2            #278 <String "}">
    //   41   82:invokevirtual   #276 <Method StringBuilder StringBuilder.append(String)>
    //   42   85:invokevirtual   #280 <Method String StringBuilder.toString()>
    //   43   88:invokevirtual   #260 <Method StringBuffer StringBuffer.append(String)>
    //   44   91:pop             
        return text.toString();
    //   45   92:aload_1         
    //   46   93:invokevirtual   #281 <Method String StringBuffer.toString()>
    //   47   96:areturn         
    }

    protected String toStringNoWeight()
    {
        StringBuffer text = new StringBuffer();
    //    0    0:new             #253 <Class StringBuffer>
    //    1    3:dup             
    //    2    4:invokespecial   #254 <Method void StringBuffer()>
    //    3    7:astore_1        
        for(int i = 0; i < m_AttValues.length; i++)
    //*   4    8:iconst_0        
    //*   5    9:istore_2        
    //*   6   10:goto            38
        {
            if(i > 0)
    //*   7   13:iload_2         
    //*   8   14:ifle            25
                text.append(",");
    //    9   17:aload_1         
    //   10   18:ldc2            #256 <String ",">
    //   11   21:invokevirtual   #260 <Method StringBuffer StringBuffer.append(String)>
    //   12   24:pop             
            text.append(toString(i));
    //   13   25:aload_1         
    //   14   26:aload_0         
    //   15   27:iload_2         
    //   16   28:invokevirtual   #262 <Method String toString(int)>
    //   17   31:invokevirtual   #260 <Method StringBuffer StringBuffer.append(String)>
    //   18   34:pop             
        }

    //   19   35:iinc            2  1
    //   20   38:iload_2         
    //   21   39:aload_0         
    //   22   40:getfield        #24  <Field double[] m_AttValues>
    //   23   43:arraylength     
    //   24   44:icmplt          13
        return text.toString();
    //   25   47:aload_1         
    //   26   48:invokevirtual   #281 <Method String StringBuffer.toString()>
    //   27   51:areturn         
    }

    public final String toString(int attIndex)
    {
        StringBuffer text = new StringBuffer();
    //    0    0:new             #253 <Class StringBuffer>
    //    1    3:dup             
    //    2    4:invokespecial   #254 <Method void StringBuffer()>
    //    3    7:astore_2        
        if(isMissing(attIndex))
    //*   4    8:aload_0         
    //*   5    9:iload_1         
    //*   6   10:invokevirtual   #78  <Method boolean isMissing(int)>
    //*   7   13:ifeq            27
            text.append("?");
    //    8   16:aload_2         
    //    9   17:ldc2            #286 <String "?">
    //   10   20:invokevirtual   #260 <Method StringBuffer StringBuffer.append(String)>
    //   11   23:pop             
        else
    //*  12   24:goto            145
        if(m_Dataset == null)
    //*  13   27:aload_0         
    //*  14   28:getfield        #28  <Field Instances m_Dataset>
    //*  15   31:ifnonnull       53
            text.append(Utils.doubleToString(m_AttValues[attIndex], 6));
    //   16   34:aload_2         
    //   17   35:aload_0         
    //   18   36:getfield        #24  <Field double[] m_AttValues>
    //   19   39:iload_1         
    //   20   40:daload          
    //   21   41:bipush          6
    //   22   43:invokestatic    #273 <Method String Utils.doubleToString(double, int)>
    //   23   46:invokevirtual   #260 <Method StringBuffer StringBuffer.append(String)>
    //   24   49:pop             
        else
    //*  25   50:goto            145
            switch(m_Dataset.attribute(attIndex).type())
    //*  26   53:aload_0         
    //*  27   54:getfield        #28  <Field Instances m_Dataset>
    //*  28   57:iload_1         
    //*  29   58:invokevirtual   #55  <Method Attribute Instances.attribute(int)>
    //*  30   61:invokevirtual   #229 <Method int Attribute.type()>
            {
    //*  31   64:tableswitch     0 4: default 134
    //                   0 116
    //                   1 100
    //                   2 100
    //                   3 100
    //                   4 100
            case 1: // '\001'
            case 2: // '\002'
            case 3: // '\003'
            case 4: // '\004'
                text.append(Utils.quote(stringValue(attIndex)));
    //   32  100:aload_2         
    //   33  101:aload_0         
    //   34  102:iload_1         
    //   35  103:invokevirtual   #288 <Method String stringValue(int)>
    //   36  106:invokestatic    #292 <Method String Utils.quote(String)>
    //   37  109:invokevirtual   #260 <Method StringBuffer StringBuffer.append(String)>
    //   38  112:pop             
                break;

    //*  39  113:goto            145
            case 0: // '\0'
                text.append(Utils.doubleToString(value(attIndex), 6));
    //   40  116:aload_2         
    //   41  117:aload_0         
    //   42  118:iload_1         
    //   43  119:invokevirtual   #84  <Method double value(int)>
    //   44  122:bipush          6
    //   45  124:invokestatic    #273 <Method String Utils.doubleToString(double, int)>
    //   46  127:invokevirtual   #260 <Method StringBuffer StringBuffer.append(String)>
    //   47  130:pop             
                break;

    //*  48  131:goto            145
            default:
                throw new IllegalStateException("Unknown attribute type");
    //   49  134:new             #294 <Class IllegalStateException>
    //   50  137:dup             
    //   51  138:ldc2            #296 <String "Unknown attribute type">
    //   52  141:invokespecial   #297 <Method void IllegalStateException(String)>
    //   53  144:athrow          
            }
        return text.toString();
    //   54  145:aload_2         
    //   55  146:invokevirtual   #281 <Method String StringBuffer.toString()>
    //   56  149:areturn         
    }

    public final String toString(Attribute att)
    {
        return toString(att.index());
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokevirtual   #139 <Method int Attribute.index()>
    //    3    5:invokevirtual   #262 <Method String toString(int)>
    //    4    8:areturn         
    }

    public double value(int attIndex)
    {
        return m_AttValues[attIndex];
    //    0    0:aload_0         
    //    1    1:getfield        #24  <Field double[] m_AttValues>
    //    2    4:iload_1         
    //    3    5:daload          
    //    4    6:dreturn         
    }

    public double valueSparse(int indexOfIndex)
    {
        return m_AttValues[indexOfIndex];
    //    0    0:aload_0         
    //    1    1:getfield        #24  <Field double[] m_AttValues>
    //    2    4:iload_1         
    //    3    5:daload          
    //    4    6:dreturn         
    }

    public double value(Attribute att)
    {
        return value(att.index());
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokevirtual   #139 <Method int Attribute.index()>
    //    3    5:invokevirtual   #84  <Method double value(int)>
    //    4    8:dreturn         
    }

    public final double weight()
    {
        return m_Weight;
    //    0    0:aload_0         
    //    1    1:getfield        #26  <Field double m_Weight>
    //    2    4:dreturn         
    }

    void forceDeleteAttributeAt(int position)
    {
        double newValues[] = new double[m_AttValues.length - 1];
    //    0    0:aload_0         
    //    1    1:getfield        #24  <Field double[] m_AttValues>
    //    2    4:arraylength     
    //    3    5:iconst_1        
    //    4    6:isub            
    //    5    7:newarray        double[]
    //    6    9:astore_2        
        System.arraycopy(m_AttValues, 0, newValues, 0, position);
    //    7   10:aload_0         
    //    8   11:getfield        #24  <Field double[] m_AttValues>
    //    9   14:iconst_0        
    //   10   15:aload_2         
    //   11   16:iconst_0        
    //   12   17:iload_1         
    //   13   18:invokestatic    #249 <Method void System.arraycopy(Object, int, Object, int, int)>
        if(position < m_AttValues.length - 1)
    //*  14   21:iload_1         
    //*  15   22:aload_0         
    //*  16   23:getfield        #24  <Field double[] m_AttValues>
    //*  17   26:arraylength     
    //*  18   27:iconst_1        
    //*  19   28:isub            
    //*  20   29:icmpge          53
            System.arraycopy(m_AttValues, position + 1, newValues, position, m_AttValues.length - (position + 1));
    //   21   32:aload_0         
    //   22   33:getfield        #24  <Field double[] m_AttValues>
    //   23   36:iload_1         
    //   24   37:iconst_1        
    //   25   38:iadd            
    //   26   39:aload_2         
    //   27   40:iload_1         
    //   28   41:aload_0         
    //   29   42:getfield        #24  <Field double[] m_AttValues>
    //   30   45:arraylength     
    //   31   46:iload_1         
    //   32   47:iconst_1        
    //   33   48:iadd            
    //   34   49:isub            
    //   35   50:invokestatic    #249 <Method void System.arraycopy(Object, int, Object, int, int)>
        m_AttValues = newValues;
    //   36   53:aload_0         
    //   37   54:aload_2         
    //   38   55:putfield        #24  <Field double[] m_AttValues>
    //   39   58:return          
    }

    void forceInsertAttributeAt(int position)
    {
        double newValues[] = new double[m_AttValues.length + 1];
    //    0    0:aload_0         
    //    1    1:getfield        #24  <Field double[] m_AttValues>
    //    2    4:arraylength     
    //    3    5:iconst_1        
    //    4    6:iadd            
    //    5    7:newarray        double[]
    //    6    9:astore_2        
        System.arraycopy(m_AttValues, 0, newValues, 0, position);
    //    7   10:aload_0         
    //    8   11:getfield        #24  <Field double[] m_AttValues>
    //    9   14:iconst_0        
    //   10   15:aload_2         
    //   11   16:iconst_0        
    //   12   17:iload_1         
    //   13   18:invokestatic    #249 <Method void System.arraycopy(Object, int, Object, int, int)>
        newValues[position] = (0.0D / 0.0D);
    //   14   21:aload_2         
    //   15   22:iload_1         
    //   16   23:ldc2w           #300 <Double (0.0D / 0.0D)>
    //   17   26:dastore         
        System.arraycopy(m_AttValues, position, newValues, position + 1, m_AttValues.length - position);
    //   18   27:aload_0         
    //   19   28:getfield        #24  <Field double[] m_AttValues>
    //   20   31:iload_1         
    //   21   32:aload_2         
    //   22   33:iload_1         
    //   23   34:iconst_1        
    //   24   35:iadd            
    //   25   36:aload_0         
    //   26   37:getfield        #24  <Field double[] m_AttValues>
    //   27   40:arraylength     
    //   28   41:iload_1         
    //   29   42:isub            
    //   30   43:invokestatic    #249 <Method void System.arraycopy(Object, int, Object, int, int)>
        m_AttValues = newValues;
    //   31   46:aload_0         
    //   32   47:aload_2         
    //   33   48:putfield        #24  <Field double[] m_AttValues>
    //   34   51:return          
    }

    protected Instance()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #22  <Method void Object()>
    //    2    4:return          
    }

    private void freshAttributeVector()
    {
        m_AttValues = toDoubleArray();
    //    0    0:aload_0         
    //    1    1:aload_0         
    //    2    2:invokevirtual   #303 <Method double[] toDoubleArray()>
    //    3    5:putfield        #24  <Field double[] m_AttValues>
    //    4    8:return          
    }

    public static void main(String options[])
    {
        try
        {
            Attribute length = new Attribute("length");
    //    0    0:new             #137 <Class Attribute>
    //    1    3:dup             
    //    2    4:ldc2            #307 <String "length">
    //    3    7:invokespecial   #308 <Method void Attribute(String)>
    //    4   10:astore_1        
            Attribute weight = new Attribute("weight");
    //    5   11:new             #137 <Class Attribute>
    //    6   14:dup             
    //    7   15:ldc2            #309 <String "weight">
    //    8   18:invokespecial   #308 <Method void Attribute(String)>
    //    9   21:astore_2        
            FastVector my_nominal_values = new FastVector(3);
    //   10   22:new             #311 <Class FastVector>
    //   11   25:dup             
    //   12   26:iconst_3        
    //   13   27:invokespecial   #313 <Method void FastVector(int)>
    //   14   30:astore_3        
            my_nominal_values.addElement("first");
    //   15   31:aload_3         
    //   16   32:ldc2            #315 <String "first">
    //   17   35:invokevirtual   #319 <Method void FastVector.addElement(Object)>
            my_nominal_values.addElement("second");
    //   18   38:aload_3         
    //   19   39:ldc2            #321 <String "second">
    //   20   42:invokevirtual   #319 <Method void FastVector.addElement(Object)>
            my_nominal_values.addElement("third");
    //   21   45:aload_3         
    //   22   46:ldc2            #323 <String "third">
    //   23   49:invokevirtual   #319 <Method void FastVector.addElement(Object)>
            Attribute position = new Attribute("position", my_nominal_values);
    //   24   52:new             #137 <Class Attribute>
    //   25   55:dup             
    //   26   56:ldc2            #324 <String "position">
    //   27   59:aload_3         
    //   28   60:invokespecial   #327 <Method void Attribute(String, FastVector)>
    //   29   63:astore          4
            FastVector attributes = new FastVector(3);
    //   30   65:new             #311 <Class FastVector>
    //   31   68:dup             
    //   32   69:iconst_3        
    //   33   70:invokespecial   #313 <Method void FastVector(int)>
    //   34   73:astore          5
            attributes.addElement(length);
    //   35   75:aload           5
    //   36   77:aload_1         
    //   37   78:invokevirtual   #319 <Method void FastVector.addElement(Object)>
            attributes.addElement(weight);
    //   38   81:aload           5
    //   39   83:aload_2         
    //   40   84:invokevirtual   #319 <Method void FastVector.addElement(Object)>
            attributes.addElement(position);
    //   41   87:aload           5
    //   42   89:aload           4
    //   43   91:invokevirtual   #319 <Method void FastVector.addElement(Object)>
            Instances race = new Instances("race", attributes, 0);
    //   44   94:new             #53  <Class Instances>
    //   45   97:dup             
    //   46   98:ldc2            #329 <String "race">
    //   47  101:aload           5
    //   48  103:iconst_0        
    //   49  104:invokespecial   #332 <Method void Instances(String, FastVector, int)>
    //   50  107:astore          6
            race.setClassIndex(position.index());
    //   51  109:aload           6
    //   52  111:aload           4
    //   53  113:invokevirtual   #139 <Method int Attribute.index()>
    //   54  116:invokevirtual   #335 <Method void Instances.setClassIndex(int)>
            Instance inst = new Instance(3);
    //   55  119:new             #2   <Class Instance>
    //   56  122:dup             
    //   57  123:iconst_3        
    //   58  124:invokespecial   #336 <Method void Instance(int)>
    //   59  127:astore          7
            inst.setValue(length, 5.2999999999999998D);
    //   60  129:aload           7
    //   61  131:aload_1         
    //   62  132:ldc2w           #337 <Double 5.2999999999999998D>
    //   63  135:invokevirtual   #340 <Method void setValue(Attribute, double)>
            inst.setValue(weight, 300D);
    //   64  138:aload           7
    //   65  140:aload_2         
    //   66  141:ldc2w           #341 <Double 300D>
    //   67  144:invokevirtual   #340 <Method void setValue(Attribute, double)>
            inst.setValue(position, "first");
    //   68  147:aload           7
    //   69  149:aload           4
    //   70  151:ldc2            #315 <String "first">
    //   71  154:invokevirtual   #344 <Method void setValue(Attribute, String)>
            inst.setDataset(race);
    //   72  157:aload           7
    //   73  159:aload           6
    //   74  161:invokevirtual   #346 <Method void setDataset(Instances)>
            System.out.println((new StringBuilder("The instance: ")).append(inst).toString());
    //   75  164:getstatic       #350 <Field PrintStream System.out>
    //   76  167:new             #264 <Class StringBuilder>
    //   77  170:dup             
    //   78  171:ldc2            #352 <String "The instance: ">
    //   79  174:invokespecial   #267 <Method void StringBuilder(String)>
    //   80  177:aload           7
    //   81  179:invokevirtual   #355 <Method StringBuilder StringBuilder.append(Object)>
    //   82  182:invokevirtual   #280 <Method String StringBuilder.toString()>
    //   83  185:invokevirtual   #360 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("First attribute: ")).append(inst.attribute(0)).toString());
    //   84  188:getstatic       #350 <Field PrintStream System.out>
    //   85  191:new             #264 <Class StringBuilder>
    //   86  194:dup             
    //   87  195:ldc2            #362 <String "First attribute: ">
    //   88  198:invokespecial   #267 <Method void StringBuilder(String)>
    //   89  201:aload           7
    //   90  203:iconst_0        
    //   91  204:invokevirtual   #187 <Method Attribute attribute(int)>
    //   92  207:invokevirtual   #355 <Method StringBuilder StringBuilder.append(Object)>
    //   93  210:invokevirtual   #280 <Method String StringBuilder.toString()>
    //   94  213:invokevirtual   #360 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Class attribute: ")).append(inst.classAttribute()).toString());
    //   95  216:getstatic       #350 <Field PrintStream System.out>
    //   96  219:new             #264 <Class StringBuilder>
    //   97  222:dup             
    //   98  223:ldc2            #364 <String "Class attribute: ">
    //   99  226:invokespecial   #267 <Method void StringBuilder(String)>
    //  100  229:aload           7
    //  101  231:invokevirtual   #365 <Method Attribute classAttribute()>
    //  102  234:invokevirtual   #355 <Method StringBuilder StringBuilder.append(Object)>
    //  103  237:invokevirtual   #280 <Method String StringBuilder.toString()>
    //  104  240:invokevirtual   #360 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Class index: ")).append(inst.classIndex()).toString());
    //  105  243:getstatic       #350 <Field PrintStream System.out>
    //  106  246:new             #264 <Class StringBuilder>
    //  107  249:dup             
    //  108  250:ldc2            #367 <String "Class index: ">
    //  109  253:invokespecial   #267 <Method void StringBuilder(String)>
    //  110  256:aload           7
    //  111  258:invokevirtual   #69  <Method int classIndex()>
    //  112  261:invokevirtual   #370 <Method StringBuilder StringBuilder.append(int)>
    //  113  264:invokevirtual   #280 <Method String StringBuilder.toString()>
    //  114  267:invokevirtual   #360 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Class is missing: ")).append(inst.classIsMissing()).toString());
    //  115  270:getstatic       #350 <Field PrintStream System.out>
    //  116  273:new             #264 <Class StringBuilder>
    //  117  276:dup             
    //  118  277:ldc2            #372 <String "Class is missing: ">
    //  119  280:invokespecial   #267 <Method void StringBuilder(String)>
    //  120  283:aload           7
    //  121  285:invokevirtual   #374 <Method boolean classIsMissing()>
    //  122  288:invokevirtual   #377 <Method StringBuilder StringBuilder.append(boolean)>
    //  123  291:invokevirtual   #280 <Method String StringBuilder.toString()>
    //  124  294:invokevirtual   #360 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Class value (internal format): ")).append(inst.classValue()).toString());
    //  125  297:getstatic       #350 <Field PrintStream System.out>
    //  126  300:new             #264 <Class StringBuilder>
    //  127  303:dup             
    //  128  304:ldc2            #379 <String "Class value (internal format): ">
    //  129  307:invokespecial   #267 <Method void StringBuilder(String)>
    //  130  310:aload           7
    //  131  312:invokevirtual   #381 <Method double classValue()>
    //  132  315:invokevirtual   #384 <Method StringBuilder StringBuilder.append(double)>
    //  133  318:invokevirtual   #280 <Method String StringBuilder.toString()>
    //  134  321:invokevirtual   #360 <Method void PrintStream.println(String)>
            Instance copy = (Instance)inst.copy();
    //  135  324:aload           7
    //  136  326:invokevirtual   #386 <Method Object copy()>
    //  137  329:checkcast       #2   <Class Instance>
    //  138  332:astore          8
            System.out.println((new StringBuilder("Shallow copy: ")).append(copy).toString());
    //  139  334:getstatic       #350 <Field PrintStream System.out>
    //  140  337:new             #264 <Class StringBuilder>
    //  141  340:dup             
    //  142  341:ldc2            #388 <String "Shallow copy: ">
    //  143  344:invokespecial   #267 <Method void StringBuilder(String)>
    //  144  347:aload           8
    //  145  349:invokevirtual   #355 <Method StringBuilder StringBuilder.append(Object)>
    //  146  352:invokevirtual   #280 <Method String StringBuilder.toString()>
    //  147  355:invokevirtual   #360 <Method void PrintStream.println(String)>
            copy.setDataset(inst.dataset());
    //  148  358:aload           8
    //  149  360:aload           7
    //  150  362:invokevirtual   #390 <Method Instances dataset()>
    //  151  365:invokevirtual   #346 <Method void setDataset(Instances)>
            System.out.println((new StringBuilder("Shallow copy with dataset set: ")).append(copy).toString());
    //  152  368:getstatic       #350 <Field PrintStream System.out>
    //  153  371:new             #264 <Class StringBuilder>
    //  154  374:dup             
    //  155  375:ldc2            #392 <String "Shallow copy with dataset set: ">
    //  156  378:invokespecial   #267 <Method void StringBuilder(String)>
    //  157  381:aload           8
    //  158  383:invokevirtual   #355 <Method StringBuilder StringBuilder.append(Object)>
    //  159  386:invokevirtual   #280 <Method String StringBuilder.toString()>
    //  160  389:invokevirtual   #360 <Method void PrintStream.println(String)>
            copy.setDataset(null);
    //  161  392:aload           8
    //  162  394:aconst_null     
    //  163  395:invokevirtual   #346 <Method void setDataset(Instances)>
            copy.deleteAttributeAt(0);
    //  164  398:aload           8
    //  165  400:iconst_0        
    //  166  401:invokevirtual   #394 <Method void deleteAttributeAt(int)>
            copy.insertAttributeAt(0);
    //  167  404:aload           8
    //  168  406:iconst_0        
    //  169  407:invokevirtual   #396 <Method void insertAttributeAt(int)>
            copy.setDataset(inst.dataset());
    //  170  410:aload           8
    //  171  412:aload           7
    //  172  414:invokevirtual   #390 <Method Instances dataset()>
    //  173  417:invokevirtual   #346 <Method void setDataset(Instances)>
            System.out.println((new StringBuilder("Copy with first attribute deleted and inserted: ")).append(copy).toString());
    //  174  420:getstatic       #350 <Field PrintStream System.out>
    //  175  423:new             #264 <Class StringBuilder>
    //  176  426:dup             
    //  177  427:ldc2            #398 <String "Copy with first attribute deleted and inserted: ">
    //  178  430:invokespecial   #267 <Method void StringBuilder(String)>
    //  179  433:aload           8
    //  180  435:invokevirtual   #355 <Method StringBuilder StringBuilder.append(Object)>
    //  181  438:invokevirtual   #280 <Method String StringBuilder.toString()>
    //  182  441:invokevirtual   #360 <Method void PrintStream.println(String)>
            System.out.println("Enumerating attributes (leaving out class):");
    //  183  444:getstatic       #350 <Field PrintStream System.out>
    //  184  447:ldc2            #400 <String "Enumerating attributes (leaving out class):">
    //  185  450:invokevirtual   #360 <Method void PrintStream.println(String)>
            Attribute att;
            for(Enumeration enu = inst.enumerateAttributes(); enu.hasMoreElements(); System.out.println(att))
    //* 186  453:aload           7
    //* 187  455:invokevirtual   #401 <Method Enumeration enumerateAttributes()>
    //* 188  458:astore          9
    //* 189  460:goto            486
                att = (Attribute)(Attribute)enu.nextElement();
    //  190  463:aload           9
    //  191  465:invokeinterface #406 <Method Object Enumeration.nextElement()>
    //  192  470:checkcast       #137 <Class Attribute>
    //  193  473:checkcast       #137 <Class Attribute>
    //  194  476:astore          10

    //  195  478:getstatic       #350 <Field PrintStream System.out>
    //  196  481:aload           10
    //  197  483:invokevirtual   #408 <Method void PrintStream.println(Object)>
    //  198  486:aload           9
    //  199  488:invokeinterface #411 <Method boolean Enumeration.hasMoreElements()>
    //  200  493:ifne            463
            System.out.println((new StringBuilder("Header of original and copy equivalent: ")).append(inst.equalHeaders(copy)).toString());
    //  201  496:getstatic       #350 <Field PrintStream System.out>
    //  202  499:new             #264 <Class StringBuilder>
    //  203  502:dup             
    //  204  503:ldc2            #413 <String "Header of original and copy equivalent: ">
    //  205  506:invokespecial   #267 <Method void StringBuilder(String)>
    //  206  509:aload           7
    //  207  511:aload           8
    //  208  513:invokevirtual   #415 <Method boolean equalHeaders(Instance)>
    //  209  516:invokevirtual   #377 <Method StringBuilder StringBuilder.append(boolean)>
    //  210  519:invokevirtual   #280 <Method String StringBuilder.toString()>
    //  211  522:invokevirtual   #360 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Length of copy missing: ")).append(copy.isMissing(length)).toString());
    //  212  525:getstatic       #350 <Field PrintStream System.out>
    //  213  528:new             #264 <Class StringBuilder>
    //  214  531:dup             
    //  215  532:ldc2            #417 <String "Length of copy missing: ">
    //  216  535:invokespecial   #267 <Method void StringBuilder(String)>
    //  217  538:aload           8
    //  218  540:aload_1         
    //  219  541:invokevirtual   #419 <Method boolean isMissing(Attribute)>
    //  220  544:invokevirtual   #377 <Method StringBuilder StringBuilder.append(boolean)>
    //  221  547:invokevirtual   #280 <Method String StringBuilder.toString()>
    //  222  550:invokevirtual   #360 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Weight of copy missing: ")).append(copy.isMissing(weight.index())).toString());
    //  223  553:getstatic       #350 <Field PrintStream System.out>
    //  224  556:new             #264 <Class StringBuilder>
    //  225  559:dup             
    //  226  560:ldc2            #421 <String "Weight of copy missing: ">
    //  227  563:invokespecial   #267 <Method void StringBuilder(String)>
    //  228  566:aload           8
    //  229  568:aload_2         
    //  230  569:invokevirtual   #139 <Method int Attribute.index()>
    //  231  572:invokevirtual   #78  <Method boolean isMissing(int)>
    //  232  575:invokevirtual   #377 <Method StringBuilder StringBuilder.append(boolean)>
    //  233  578:invokevirtual   #280 <Method String StringBuilder.toString()>
    //  234  581:invokevirtual   #360 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Length of copy missing: ")).append(isMissingValue(copy.value(length))).toString());
    //  235  584:getstatic       #350 <Field PrintStream System.out>
    //  236  587:new             #264 <Class StringBuilder>
    //  237  590:dup             
    //  238  591:ldc2            #417 <String "Length of copy missing: ">
    //  239  594:invokespecial   #267 <Method void StringBuilder(String)>
    //  240  597:aload           8
    //  241  599:aload_1         
    //  242  600:invokevirtual   #423 <Method double value(Attribute)>
    //  243  603:invokestatic    #425 <Method boolean isMissingValue(double)>
    //  244  606:invokevirtual   #377 <Method StringBuilder StringBuilder.append(boolean)>
    //  245  609:invokevirtual   #280 <Method String StringBuilder.toString()>
    //  246  612:invokevirtual   #360 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Missing value coded as: ")).append(missingValue()).toString());
    //  247  615:getstatic       #350 <Field PrintStream System.out>
    //  248  618:new             #264 <Class StringBuilder>
    //  249  621:dup             
    //  250  622:ldc2            #427 <String "Missing value coded as: ">
    //  251  625:invokespecial   #267 <Method void StringBuilder(String)>
    //  252  628:invokestatic    #429 <Method double missingValue()>
    //  253  631:invokevirtual   #384 <Method StringBuilder StringBuilder.append(double)>
    //  254  634:invokevirtual   #280 <Method String StringBuilder.toString()>
    //  255  637:invokevirtual   #360 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Number of attributes: ")).append(copy.numAttributes()).toString());
    //  256  640:getstatic       #350 <Field PrintStream System.out>
    //  257  643:new             #264 <Class StringBuilder>
    //  258  646:dup             
    //  259  647:ldc2            #431 <String "Number of attributes: ">
    //  260  650:invokespecial   #267 <Method void StringBuilder(String)>
    //  261  653:aload           8
    //  262  655:invokevirtual   #114 <Method int numAttributes()>
    //  263  658:invokevirtual   #370 <Method StringBuilder StringBuilder.append(int)>
    //  264  661:invokevirtual   #280 <Method String StringBuilder.toString()>
    //  265  664:invokevirtual   #360 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Number of classes: ")).append(copy.numClasses()).toString());
    //  266  667:getstatic       #350 <Field PrintStream System.out>
    //  267  670:new             #264 <Class StringBuilder>
    //  268  673:dup             
    //  269  674:ldc2            #433 <String "Number of classes: ">
    //  270  677:invokespecial   #267 <Method void StringBuilder(String)>
    //  271  680:aload           8
    //  272  682:invokevirtual   #434 <Method int numClasses()>
    //  273  685:invokevirtual   #370 <Method StringBuilder StringBuilder.append(int)>
    //  274  688:invokevirtual   #280 <Method String StringBuilder.toString()>
    //  275  691:invokevirtual   #360 <Method void PrintStream.println(String)>
            double meansAndModes[] = {
                2D, 3D, 0.0D
            };
    //  276  694:iconst_3        
    //  277  695:newarray        double[]
    //  278  697:dup             
    //  279  698:iconst_0        
    //  280  699:ldc2w           #435 <Double 2D>
    //  281  702:dastore         
    //  282  703:dup             
    //  283  704:iconst_1        
    //  284  705:ldc2w           #437 <Double 3D>
    //  285  708:dastore         
    //  286  709:dup             
    //  287  710:iconst_2        
    //  288  711:dconst_0        
    //  289  712:dastore         
    //  290  713:astore          10
            copy.replaceMissingValues(meansAndModes);
    //  291  715:aload           8
    //  292  717:aload           10
    //  293  719:invokevirtual   #440 <Method void replaceMissingValues(double[])>
            System.out.println((new StringBuilder("Copy with missing value replaced: ")).append(copy).toString());
    //  294  722:getstatic       #350 <Field PrintStream System.out>
    //  295  725:new             #264 <Class StringBuilder>
    //  296  728:dup             
    //  297  729:ldc2            #442 <String "Copy with missing value replaced: ">
    //  298  732:invokespecial   #267 <Method void StringBuilder(String)>
    //  299  735:aload           8
    //  300  737:invokevirtual   #355 <Method StringBuilder StringBuilder.append(Object)>
    //  301  740:invokevirtual   #280 <Method String StringBuilder.toString()>
    //  302  743:invokevirtual   #360 <Method void PrintStream.println(String)>
            copy.setClassMissing();
    //  303  746:aload           8
    //  304  748:invokevirtual   #444 <Method void setClassMissing()>
            System.out.println((new StringBuilder("Copy with missing class: ")).append(copy).toString());
    //  305  751:getstatic       #350 <Field PrintStream System.out>
    //  306  754:new             #264 <Class StringBuilder>
    //  307  757:dup             
    //  308  758:ldc2            #446 <String "Copy with missing class: ">
    //  309  761:invokespecial   #267 <Method void StringBuilder(String)>
    //  310  764:aload           8
    //  311  766:invokevirtual   #355 <Method StringBuilder StringBuilder.append(Object)>
    //  312  769:invokevirtual   #280 <Method String StringBuilder.toString()>
    //  313  772:invokevirtual   #360 <Method void PrintStream.println(String)>
            copy.setClassValue(0.0D);
    //  314  775:aload           8
    //  315  777:dconst_0        
    //  316  778:invokevirtual   #448 <Method void setClassValue(double)>
            System.out.println((new StringBuilder("Copy with class value set to first value: ")).append(copy).toString());
    //  317  781:getstatic       #350 <Field PrintStream System.out>
    //  318  784:new             #264 <Class StringBuilder>
    //  319  787:dup             
    //  320  788:ldc2            #450 <String "Copy with class value set to first value: ">
    //  321  791:invokespecial   #267 <Method void StringBuilder(String)>
    //  322  794:aload           8
    //  323  796:invokevirtual   #355 <Method StringBuilder StringBuilder.append(Object)>
    //  324  799:invokevirtual   #280 <Method String StringBuilder.toString()>
    //  325  802:invokevirtual   #360 <Method void PrintStream.println(String)>
            copy.setClassValue("third");
    //  326  805:aload           8
    //  327  807:ldc2            #323 <String "third">
    //  328  810:invokevirtual   #452 <Method void setClassValue(String)>
            System.out.println((new StringBuilder("Copy with class value set to \"third\": ")).append(copy).toString());
    //  329  813:getstatic       #350 <Field PrintStream System.out>
    //  330  816:new             #264 <Class StringBuilder>
    //  331  819:dup             
    //  332  820:ldc2            #454 <String "Copy with class value set to \"third\": ">
    //  333  823:invokespecial   #267 <Method void StringBuilder(String)>
    //  334  826:aload           8
    //  335  828:invokevirtual   #355 <Method StringBuilder StringBuilder.append(Object)>
    //  336  831:invokevirtual   #280 <Method String StringBuilder.toString()>
    //  337  834:invokevirtual   #360 <Method void PrintStream.println(String)>
            copy.setMissing(1);
    //  338  837:aload           8
    //  339  839:iconst_1        
    //  340  840:invokevirtual   #169 <Method void setMissing(int)>
            System.out.println((new StringBuilder("Copy with second attribute set to be missing: ")).append(copy).toString());
    //  341  843:getstatic       #350 <Field PrintStream System.out>
    //  342  846:new             #264 <Class StringBuilder>
    //  343  849:dup             
    //  344  850:ldc2            #456 <String "Copy with second attribute set to be missing: ">
    //  345  853:invokespecial   #267 <Method void StringBuilder(String)>
    //  346  856:aload           8
    //  347  858:invokevirtual   #355 <Method StringBuilder StringBuilder.append(Object)>
    //  348  861:invokevirtual   #280 <Method String StringBuilder.toString()>
    //  349  864:invokevirtual   #360 <Method void PrintStream.println(String)>
            copy.setMissing(length);
    //  350  867:aload           8
    //  351  869:aload_1         
    //  352  870:invokevirtual   #458 <Method void setMissing(Attribute)>
            System.out.println((new StringBuilder("Copy with length set to be missing: ")).append(copy).toString());
    //  353  873:getstatic       #350 <Field PrintStream System.out>
    //  354  876:new             #264 <Class StringBuilder>
    //  355  879:dup             
    //  356  880:ldc2            #460 <String "Copy with length set to be missing: ">
    //  357  883:invokespecial   #267 <Method void StringBuilder(String)>
    //  358  886:aload           8
    //  359  888:invokevirtual   #355 <Method StringBuilder StringBuilder.append(Object)>
    //  360  891:invokevirtual   #280 <Method String StringBuilder.toString()>
    //  361  894:invokevirtual   #360 <Method void PrintStream.println(String)>
            copy.setValue(0, 0.0D);
    //  362  897:aload           8
    //  363  899:iconst_0        
    //  364  900:dconst_0        
    //  365  901:invokevirtual   #175 <Method void setValue(int, double)>
            System.out.println((new StringBuilder("Copy with first attribute set to 0: ")).append(copy).toString());
    //  366  904:getstatic       #350 <Field PrintStream System.out>
    //  367  907:new             #264 <Class StringBuilder>
    //  368  910:dup             
    //  369  911:ldc2            #462 <String "Copy with first attribute set to 0: ">
    //  370  914:invokespecial   #267 <Method void StringBuilder(String)>
    //  371  917:aload           8
    //  372  919:invokevirtual   #355 <Method StringBuilder StringBuilder.append(Object)>
    //  373  922:invokevirtual   #280 <Method String StringBuilder.toString()>
    //  374  925:invokevirtual   #360 <Method void PrintStream.println(String)>
            copy.setValue(weight, 1.0D);
    //  375  928:aload           8
    //  376  930:aload_2         
    //  377  931:dconst_1        
    //  378  932:invokevirtual   #340 <Method void setValue(Attribute, double)>
            System.out.println((new StringBuilder("Copy with weight attribute set to 1: ")).append(copy).toString());
    //  379  935:getstatic       #350 <Field PrintStream System.out>
    //  380  938:new             #264 <Class StringBuilder>
    //  381  941:dup             
    //  382  942:ldc2            #464 <String "Copy with weight attribute set to 1: ">
    //  383  945:invokespecial   #267 <Method void StringBuilder(String)>
    //  384  948:aload           8
    //  385  950:invokevirtual   #355 <Method StringBuilder StringBuilder.append(Object)>
    //  386  953:invokevirtual   #280 <Method String StringBuilder.toString()>
    //  387  956:invokevirtual   #360 <Method void PrintStream.println(String)>
            copy.setValue(position, "second");
    //  388  959:aload           8
    //  389  961:aload           4
    //  390  963:ldc2            #321 <String "second">
    //  391  966:invokevirtual   #344 <Method void setValue(Attribute, String)>
            System.out.println((new StringBuilder("Copy with position set to \"second\": ")).append(copy).toString());
    //  392  969:getstatic       #350 <Field PrintStream System.out>
    //  393  972:new             #264 <Class StringBuilder>
    //  394  975:dup             
    //  395  976:ldc2            #466 <String "Copy with position set to \"second\": ">
    //  396  979:invokespecial   #267 <Method void StringBuilder(String)>
    //  397  982:aload           8
    //  398  984:invokevirtual   #355 <Method StringBuilder StringBuilder.append(Object)>
    //  399  987:invokevirtual   #280 <Method String StringBuilder.toString()>
    //  400  990:invokevirtual   #360 <Method void PrintStream.println(String)>
            copy.setValue(2, "first");
    //  401  993:aload           8
    //  402  995:iconst_2        
    //  403  996:ldc2            #315 <String "first">
    //  404  999:invokevirtual   #178 <Method void setValue(int, String)>
            System.out.println((new StringBuilder("Copy with last attribute set to \"first\": ")).append(copy).toString());
    //  405 1002:getstatic       #350 <Field PrintStream System.out>
    //  406 1005:new             #264 <Class StringBuilder>
    //  407 1008:dup             
    //  408 1009:ldc2            #468 <String "Copy with last attribute set to \"first\": ">
    //  409 1012:invokespecial   #267 <Method void StringBuilder(String)>
    //  410 1015:aload           8
    //  411 1017:invokevirtual   #355 <Method StringBuilder StringBuilder.append(Object)>
    //  412 1020:invokevirtual   #280 <Method String StringBuilder.toString()>
    //  413 1023:invokevirtual   #360 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Current weight of instance copy: ")).append(copy.weight()).toString());
    //  414 1026:getstatic       #350 <Field PrintStream System.out>
    //  415 1029:new             #264 <Class StringBuilder>
    //  416 1032:dup             
    //  417 1033:ldc2            #470 <String "Current weight of instance copy: ">
    //  418 1036:invokespecial   #267 <Method void StringBuilder(String)>
    //  419 1039:aload           8
    //  420 1041:invokevirtual   #472 <Method double weight()>
    //  421 1044:invokevirtual   #384 <Method StringBuilder StringBuilder.append(double)>
    //  422 1047:invokevirtual   #280 <Method String StringBuilder.toString()>
    //  423 1050:invokevirtual   #360 <Method void PrintStream.println(String)>
            copy.setWeight(2D);
    //  424 1053:aload           8
    //  425 1055:ldc2w           #435 <Double 2D>
    //  426 1058:invokevirtual   #474 <Method void setWeight(double)>
            System.out.println((new StringBuilder("Current weight of instance copy (set to 2): ")).append(copy.weight()).toString());
    //  427 1061:getstatic       #350 <Field PrintStream System.out>
    //  428 1064:new             #264 <Class StringBuilder>
    //  429 1067:dup             
    //  430 1068:ldc2            #476 <String "Current weight of instance copy (set to 2): ">
    //  431 1071:invokespecial   #267 <Method void StringBuilder(String)>
    //  432 1074:aload           8
    //  433 1076:invokevirtual   #472 <Method double weight()>
    //  434 1079:invokevirtual   #384 <Method StringBuilder StringBuilder.append(double)>
    //  435 1082:invokevirtual   #280 <Method String StringBuilder.toString()>
    //  436 1085:invokevirtual   #360 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Last value of copy: ")).append(copy.toString(2)).toString());
    //  437 1088:getstatic       #350 <Field PrintStream System.out>
    //  438 1091:new             #264 <Class StringBuilder>
    //  439 1094:dup             
    //  440 1095:ldc2            #478 <String "Last value of copy: ">
    //  441 1098:invokespecial   #267 <Method void StringBuilder(String)>
    //  442 1101:aload           8
    //  443 1103:iconst_2        
    //  444 1104:invokevirtual   #262 <Method String toString(int)>
    //  445 1107:invokevirtual   #276 <Method StringBuilder StringBuilder.append(String)>
    //  446 1110:invokevirtual   #280 <Method String StringBuilder.toString()>
    //  447 1113:invokevirtual   #360 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Value of position for copy: ")).append(copy.toString(position)).toString());
    //  448 1116:getstatic       #350 <Field PrintStream System.out>
    //  449 1119:new             #264 <Class StringBuilder>
    //  450 1122:dup             
    //  451 1123:ldc2            #480 <String "Value of position for copy: ">
    //  452 1126:invokespecial   #267 <Method void StringBuilder(String)>
    //  453 1129:aload           8
    //  454 1131:aload           4
    //  455 1133:invokevirtual   #482 <Method String toString(Attribute)>
    //  456 1136:invokevirtual   #276 <Method StringBuilder StringBuilder.append(String)>
    //  457 1139:invokevirtual   #280 <Method String StringBuilder.toString()>
    //  458 1142:invokevirtual   #360 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Last value of copy (internal format): ")).append(copy.value(2)).toString());
    //  459 1145:getstatic       #350 <Field PrintStream System.out>
    //  460 1148:new             #264 <Class StringBuilder>
    //  461 1151:dup             
    //  462 1152:ldc2            #484 <String "Last value of copy (internal format): ">
    //  463 1155:invokespecial   #267 <Method void StringBuilder(String)>
    //  464 1158:aload           8
    //  465 1160:iconst_2        
    //  466 1161:invokevirtual   #84  <Method double value(int)>
    //  467 1164:invokevirtual   #384 <Method StringBuilder StringBuilder.append(double)>
    //  468 1167:invokevirtual   #280 <Method String StringBuilder.toString()>
    //  469 1170:invokevirtual   #360 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Value of position for copy (internal format): ")).append(copy.value(position)).toString());
    //  470 1173:getstatic       #350 <Field PrintStream System.out>
    //  471 1176:new             #264 <Class StringBuilder>
    //  472 1179:dup             
    //  473 1180:ldc2            #486 <String "Value of position for copy (internal format): ">
    //  474 1183:invokespecial   #267 <Method void StringBuilder(String)>
    //  475 1186:aload           8
    //  476 1188:aload           4
    //  477 1190:invokevirtual   #423 <Method double value(Attribute)>
    //  478 1193:invokevirtual   #384 <Method StringBuilder StringBuilder.append(double)>
    //  479 1196:invokevirtual   #280 <Method String StringBuilder.toString()>
    //  480 1199:invokevirtual   #360 <Method void PrintStream.println(String)>
        }
    //* 481 1202:goto            1210
        catch(Exception e)
    //* 482 1205:astore_1        
        {
            e.printStackTrace();
    //  483 1206:aload_1         
    //  484 1207:invokevirtual   #491 <Method void Exception.printStackTrace()>
        }
    //  485 1210:return          
    }

    protected static final double MISSING_VALUE = (0.0D / 0.0D);
    protected Instances m_Dataset;
    protected double m_AttValues[];
    protected double m_Weight;
}
