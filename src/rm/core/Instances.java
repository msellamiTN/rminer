// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   Instances.java

package rm.core;

import java.io.*;
import java.util.*;

// Referenced classes of package rm.core:
//            FastVector, Attribute, Instance, Utils, 
//            UnassignedClassException, AttributeStats, Stats

public class Instances
    implements Serializable
{

    public Instances(Reader reader)
        throws IOException
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #37  <Method void Object()>
        m_Lines = 0;
    //    2    4:aload_0         
    //    3    5:iconst_0        
    //    4    6:putfield        #39  <Field int m_Lines>
        rm.core.converters.ArffLoader.ArffReader ass = new rm.core.converters.ArffLoader.ArffReader(reader);
    //    5    9:new             #41  <Class rm.core.converters.ArffLoader$ArffReader>
    //    6   12:dup             
    //    7   13:aload_1         
    //    8   14:invokespecial   #43  <Method void rm.core.converters.ArffLoader$ArffReader(Reader)>
    //    9   17:astore_2        
        Instances dataset = ass.getData();
    //   10   18:aload_2         
    //   11   19:invokevirtual   #47  <Method Instances rm.core.converters.ArffLoader$ArffReader.getData()>
    //   12   22:astore_3        
        initialize(dataset, dataset.numInstances());
    //   13   23:aload_0         
    //   14   24:aload_3         
    //   15   25:aload_3         
    //   16   26:invokevirtual   #51  <Method int numInstances()>
    //   17   29:invokevirtual   #55  <Method void initialize(Instances, int)>
        dataset.copyInstances(0, this, dataset.numInstances());
    //   18   32:aload_3         
    //   19   33:iconst_0        
    //   20   34:aload_0         
    //   21   35:aload_3         
    //   22   36:invokevirtual   #51  <Method int numInstances()>
    //   23   39:invokevirtual   #59  <Method void copyInstances(int, Instances, int)>
        compactify();
    //   24   42:aload_0         
    //   25   43:invokevirtual   #62  <Method void compactify()>
    //   26   46:return          
    }

    public Instances(Instances dataset)
    {
        this(dataset, dataset.numInstances());
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:aload_1         
    //    3    3:invokevirtual   #51  <Method int numInstances()>
    //    4    6:invokespecial   #74  <Method void Instances(Instances, int)>
        dataset.copyInstances(0, this, dataset.numInstances());
    //    5    9:aload_1         
    //    6   10:iconst_0        
    //    7   11:aload_0         
    //    8   12:aload_1         
    //    9   13:invokevirtual   #51  <Method int numInstances()>
    //   10   16:invokevirtual   #59  <Method void copyInstances(int, Instances, int)>
    //   11   19:return          
    }

    public Instances(Instances dataset, int capacity)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #37  <Method void Object()>
        m_Lines = 0;
    //    2    4:aload_0         
    //    3    5:iconst_0        
    //    4    6:putfield        #39  <Field int m_Lines>
        initialize(dataset, capacity);
    //    5    9:aload_0         
    //    6   10:aload_1         
    //    7   11:iload_2         
    //    8   12:invokevirtual   #55  <Method void initialize(Instances, int)>
    //    9   15:return          
    }

    protected void initialize(Instances dataset, int capacity)
    {
        if(capacity < 0)
    //*   0    0:iload_2         
    //*   1    1:ifge            6
            capacity = 0;
    //    2    4:iconst_0        
    //    3    5:istore_2        
        m_ClassIndex = dataset.m_ClassIndex;
    //    4    6:aload_0         
    //    5    7:aload_1         
    //    6    8:getfield        #77  <Field int m_ClassIndex>
    //    7   11:putfield        #77  <Field int m_ClassIndex>
        m_DimensionName = dataset.m_DimensionName;
    //    8   14:aload_0         
    //    9   15:aload_1         
    //   10   16:getfield        #79  <Field String m_DimensionName>
    //   11   19:putfield        #79  <Field String m_DimensionName>
        m_Attributes = dataset.m_Attributes;
    //   12   22:aload_0         
    //   13   23:aload_1         
    //   14   24:getfield        #81  <Field FastVector m_Attributes>
    //   15   27:putfield        #81  <Field FastVector m_Attributes>
        m_Instances = new FastVector(capacity);
    //   16   30:aload_0         
    //   17   31:new             #83  <Class FastVector>
    //   18   34:dup             
    //   19   35:iload_2         
    //   20   36:invokespecial   #86  <Method void FastVector(int)>
    //   21   39:putfield        #88  <Field FastVector m_Instances>
    //   22   42:return          
    }

    public Instances(Instances source, int first, int toCopy)
    {
        this(source, toCopy);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:iload_3         
    //    3    3:invokespecial   #74  <Method void Instances(Instances, int)>
        if(first < 0 || first + toCopy > source.numInstances())
    //*   4    6:iload_2         
    //*   5    7:iflt            20
    //*   6   10:iload_2         
    //*   7   11:iload_3         
    //*   8   12:iadd            
    //*   9   13:aload_1         
    //*  10   14:invokevirtual   #51  <Method int numInstances()>
    //*  11   17:icmple          30
        {
            throw new IllegalArgumentException("Parameters first and/or toCopy out of range");
    //   12   20:new             #91  <Class IllegalArgumentException>
    //   13   23:dup             
    //   14   24:ldc1            #93  <String "Parameters first and/or toCopy out of range">
    //   15   26:invokespecial   #96  <Method void IllegalArgumentException(String)>
    //   16   29:athrow          
        } else
        {
            source.copyInstances(first, this, toCopy);
    //   17   30:aload_1         
    //   18   31:iload_2         
    //   19   32:aload_0         
    //   20   33:iload_3         
    //   21   34:invokevirtual   #59  <Method void copyInstances(int, Instances, int)>
            return;
    //   22   37:return          
        }
    }

    public Instances(String name, FastVector attInfo, int capacity)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #37  <Method void Object()>
        m_Lines = 0;
    //    2    4:aload_0         
    //    3    5:iconst_0        
    //    4    6:putfield        #39  <Field int m_Lines>
        HashSet names = new HashSet();
    //    5    9:new             #102 <Class HashSet>
    //    6   12:dup             
    //    7   13:invokespecial   #103 <Method void HashSet()>
    //    8   16:astore          4
        StringBuffer nonUniqueNames = new StringBuffer();
    //    9   18:new             #105 <Class StringBuffer>
    //   10   21:dup             
    //   11   22:invokespecial   #106 <Method void StringBuffer()>
    //   12   25:astore          5
        for(int i = 0; i < attInfo.size(); i++)
    //*  13   27:iconst_0        
    //*  14   28:istore          6
    //*  15   30:goto            112
        {
            if(names.contains(((Attribute)attInfo.elementAt(i)).name()))
    //*  16   33:aload           4
    //*  17   35:aload_2         
    //*  18   36:iload           6
    //*  19   38:invokevirtual   #110 <Method Object FastVector.elementAt(int)>
    //*  20   41:checkcast       #112 <Class Attribute>
    //*  21   44:invokevirtual   #116 <Method String Attribute.name()>
    //*  22   47:invokevirtual   #120 <Method boolean HashSet.contains(Object)>
    //*  23   50:ifeq            91
                nonUniqueNames.append((new StringBuilder("'")).append(((Attribute)attInfo.elementAt(i)).name()).append("' ").toString());
    //   24   53:aload           5
    //   25   55:new             #122 <Class StringBuilder>
    //   26   58:dup             
    //   27   59:ldc1            #124 <String "'">
    //   28   61:invokespecial   #125 <Method void StringBuilder(String)>
    //   29   64:aload_2         
    //   30   65:iload           6
    //   31   67:invokevirtual   #110 <Method Object FastVector.elementAt(int)>
    //   32   70:checkcast       #112 <Class Attribute>
    //   33   73:invokevirtual   #116 <Method String Attribute.name()>
    //   34   76:invokevirtual   #129 <Method StringBuilder StringBuilder.append(String)>
    //   35   79:ldc1            #131 <String "' ">
    //   36   81:invokevirtual   #129 <Method StringBuilder StringBuilder.append(String)>
    //   37   84:invokevirtual   #134 <Method String StringBuilder.toString()>
    //   38   87:invokevirtual   #137 <Method StringBuffer StringBuffer.append(String)>
    //   39   90:pop             
            names.add(((Attribute)attInfo.elementAt(i)).name());
    //   40   91:aload           4
    //   41   93:aload_2         
    //   42   94:iload           6
    //   43   96:invokevirtual   #110 <Method Object FastVector.elementAt(int)>
    //   44   99:checkcast       #112 <Class Attribute>
    //   45  102:invokevirtual   #116 <Method String Attribute.name()>
    //   46  105:invokevirtual   #140 <Method boolean HashSet.add(Object)>
    //   47  108:pop             
        }

    //   48  109:iinc            6  1
    //   49  112:iload           6
    //   50  114:aload_2         
    //   51  115:invokevirtual   #143 <Method int FastVector.size()>
    //   52  118:icmplt          33
        if(names.size() != attInfo.size())
    //*  53  121:aload           4
    //*  54  123:invokevirtual   #144 <Method int HashSet.size()>
    //*  55  126:aload_2         
    //*  56  127:invokevirtual   #143 <Method int FastVector.size()>
    //*  57  130:icmpeq          161
            throw new IllegalArgumentException((new StringBuilder("Attribute names are not unique! Causes: ")).append(nonUniqueNames.toString()).toString());
    //   58  133:new             #91  <Class IllegalArgumentException>
    //   59  136:dup             
    //   60  137:new             #122 <Class StringBuilder>
    //   61  140:dup             
    //   62  141:ldc1            #146 <String "Attribute names are not unique! Causes: ">
    //   63  143:invokespecial   #125 <Method void StringBuilder(String)>
    //   64  146:aload           5
    //   65  148:invokevirtual   #147 <Method String StringBuffer.toString()>
    //   66  151:invokevirtual   #129 <Method StringBuilder StringBuilder.append(String)>
    //   67  154:invokevirtual   #134 <Method String StringBuilder.toString()>
    //   68  157:invokespecial   #96  <Method void IllegalArgumentException(String)>
    //   69  160:athrow          
        names.clear();
    //   70  161:aload           4
    //   71  163:invokevirtual   #150 <Method void HashSet.clear()>
        m_DimensionName = name;
    //   72  166:aload_0         
    //   73  167:aload_1         
    //   74  168:putfield        #79  <Field String m_DimensionName>
        m_ClassIndex = -1;
    //   75  171:aload_0         
    //   76  172:iconst_m1       
    //   77  173:putfield        #77  <Field int m_ClassIndex>
        m_Attributes = attInfo;
    //   78  176:aload_0         
    //   79  177:aload_2         
    //   80  178:putfield        #81  <Field FastVector m_Attributes>
        for(int i = 0; i < numAttributes(); i++)
    //*  81  181:iconst_0        
    //*  82  182:istore          6
    //*  83  184:goto            201
            attribute(i).setIndex(i);
    //   84  187:aload_0         
    //   85  188:iload           6
    //   86  190:invokevirtual   #154 <Method Attribute attribute(int)>
    //   87  193:iload           6
    //   88  195:invokevirtual   #157 <Method void Attribute.setIndex(int)>

    //   89  198:iinc            6  1
    //   90  201:iload           6
    //   91  203:aload_0         
    //   92  204:invokevirtual   #160 <Method int numAttributes()>
    //   93  207:icmplt          187
        m_Instances = new FastVector(capacity);
    //   94  210:aload_0         
    //   95  211:new             #83  <Class FastVector>
    //   96  214:dup             
    //   97  215:iload_3         
    //   98  216:invokespecial   #86  <Method void FastVector(int)>
    //   99  219:putfield        #88  <Field FastVector m_Instances>
    //  100  222:return          
    }

    public Instances stringFreeStructure()
    {
        FastVector newAtts = new FastVector();
    //    0    0:new             #83  <Class FastVector>
    //    1    3:dup             
    //    2    4:invokespecial   #170 <Method void FastVector()>
    //    3    7:astore_1        
        for(int i = 0; i < m_Attributes.size(); i++)
    //*   4    8:iconst_0        
    //*   5    9:istore_2        
    //*   6   10:goto            53
        {
            Attribute att = (Attribute)m_Attributes.elementAt(i);
    //    7   13:aload_0         
    //    8   14:getfield        #81  <Field FastVector m_Attributes>
    //    9   17:iload_2         
    //   10   18:invokevirtual   #110 <Method Object FastVector.elementAt(int)>
    //   11   21:checkcast       #112 <Class Attribute>
    //   12   24:astore_3        
            if(att.type() == 2)
    //*  13   25:aload_3         
    //*  14   26:invokevirtual   #173 <Method int Attribute.type()>
    //*  15   29:iconst_2        
    //*  16   30:icmpne          50
                newAtts.addElement(new Attribute(att.name(), null, i));
    //   17   33:aload_1         
    //   18   34:new             #112 <Class Attribute>
    //   19   37:dup             
    //   20   38:aload_3         
    //   21   39:invokevirtual   #116 <Method String Attribute.name()>
    //   22   42:aconst_null     
    //   23   43:iload_2         
    //   24   44:invokespecial   #175 <Method void Attribute(String, FastVector, int)>
    //   25   47:invokevirtual   #179 <Method void FastVector.addElement(Object)>
        }

    //   26   50:iinc            2  1
    //   27   53:iload_2         
    //   28   54:aload_0         
    //   29   55:getfield        #81  <Field FastVector m_Attributes>
    //   30   58:invokevirtual   #143 <Method int FastVector.size()>
    //   31   61:icmplt          13
        if(newAtts.size() == 0)
    //*  32   64:aload_1         
    //*  33   65:invokevirtual   #143 <Method int FastVector.size()>
    //*  34   68:ifne            81
            return new Instances(this, 0);
    //   35   71:new             #2   <Class Instances>
    //   36   74:dup             
    //   37   75:aload_0         
    //   38   76:iconst_0        
    //   39   77:invokespecial   #74  <Method void Instances(Instances, int)>
    //   40   80:areturn         
        FastVector atts = (FastVector)m_Attributes.copy();
    //   41   81:aload_0         
    //   42   82:getfield        #81  <Field FastVector m_Attributes>
    //   43   85:invokevirtual   #183 <Method Object FastVector.copy()>
    //   44   88:checkcast       #83  <Class FastVector>
    //   45   91:astore_2        
        for(int i = 0; i < newAtts.size(); i++)
    //*  46   92:iconst_0        
    //*  47   93:istore_3        
    //*  48   94:goto            120
            atts.setElementAt(newAtts.elementAt(i), ((Attribute)newAtts.elementAt(i)).index());
    //   49   97:aload_2         
    //   50   98:aload_1         
    //   51   99:iload_3         
    //   52  100:invokevirtual   #110 <Method Object FastVector.elementAt(int)>
    //   53  103:aload_1         
    //   54  104:iload_3         
    //   55  105:invokevirtual   #110 <Method Object FastVector.elementAt(int)>
    //   56  108:checkcast       #112 <Class Attribute>
    //   57  111:invokevirtual   #186 <Method int Attribute.index()>
    //   58  114:invokevirtual   #190 <Method void FastVector.setElementAt(Object, int)>

    //   59  117:iinc            3  1
    //   60  120:iload_3         
    //   61  121:aload_1         
    //   62  122:invokevirtual   #143 <Method int FastVector.size()>
    //   63  125:icmplt          97
        Instances result = new Instances(this, 0);
    //   64  128:new             #2   <Class Instances>
    //   65  131:dup             
    //   66  132:aload_0         
    //   67  133:iconst_0        
    //   68  134:invokespecial   #74  <Method void Instances(Instances, int)>
    //   69  137:astore_3        
        result.m_Attributes = atts;
    //   70  138:aload_3         
    //   71  139:aload_2         
    //   72  140:putfield        #81  <Field FastVector m_Attributes>
        return result;
    //   73  143:aload_3         
    //   74  144:areturn         
    }

    public void add(Instance instance)
    {
        Instance newInstance = (Instance)instance.copy();
    //    0    0:aload_1         
    //    1    1:invokevirtual   #199 <Method Object Instance.copy()>
    //    2    4:checkcast       #198 <Class Instance>
    //    3    7:astore_2        
        newInstance.setDataset(this);
    //    4    8:aload_2         
    //    5    9:aload_0         
    //    6   10:invokevirtual   #202 <Method void Instance.setDataset(Instances)>
        m_Instances.addElement(newInstance);
    //    7   13:aload_0         
    //    8   14:getfield        #88  <Field FastVector m_Instances>
    //    9   17:aload_2         
    //   10   18:invokevirtual   #179 <Method void FastVector.addElement(Object)>
    //   11   21:return          
    }

    public Attribute attribute(int index)
    {
        return (Attribute)m_Attributes.elementAt(index);
    //    0    0:aload_0         
    //    1    1:getfield        #81  <Field FastVector m_Attributes>
    //    2    4:iload_1         
    //    3    5:invokevirtual   #110 <Method Object FastVector.elementAt(int)>
    //    4    8:checkcast       #112 <Class Attribute>
    //    5   11:areturn         
    }

    public Attribute attribute(String name)
    {
        for(int i = 0; i < numAttributes(); i++)
    //*   0    0:iconst_0        
    //*   1    1:istore_2        
    //*   2    2:goto            29
            if(attribute(i).name().equals(name))
    //*   3    5:aload_0         
    //*   4    6:iload_2         
    //*   5    7:invokevirtual   #154 <Method Attribute attribute(int)>
    //*   6   10:invokevirtual   #116 <Method String Attribute.name()>
    //*   7   13:aload_1         
    //*   8   14:invokevirtual   #211 <Method boolean String.equals(Object)>
    //*   9   17:ifeq            26
                return attribute(i);
    //   10   20:aload_0         
    //   11   21:iload_2         
    //   12   22:invokevirtual   #154 <Method Attribute attribute(int)>
    //   13   25:areturn         

    //   14   26:iinc            2  1
    //   15   29:iload_2         
    //   16   30:aload_0         
    //   17   31:invokevirtual   #160 <Method int numAttributes()>
    //   18   34:icmplt          5
        return null;
    //   19   37:aconst_null     
    //   20   38:areturn         
    }

    public boolean checkForAttributeType(int attType)
    {
        for(int i = 0; i < m_Attributes.size();)
    //*   0    0:iconst_0        
    //*   1    1:istore_2        
    //*   2    2:goto            22
            if(attribute(i++).type() == attType)
    //*   3    5:aload_0         
    //*   4    6:iload_2         
    //*   5    7:iinc            2  1
    //*   6   10:invokevirtual   #154 <Method Attribute attribute(int)>
    //*   7   13:invokevirtual   #173 <Method int Attribute.type()>
    //*   8   16:iload_1         
    //*   9   17:icmpne          22
                return true;
    //   10   20:iconst_1        
    //   11   21:ireturn         

    //   12   22:iload_2         
    //   13   23:aload_0         
    //   14   24:getfield        #81  <Field FastVector m_Attributes>
    //   15   27:invokevirtual   #143 <Method int FastVector.size()>
    //   16   30:icmplt          5
        return false;
    //   17   33:iconst_0        
    //   18   34:ireturn         
    }

    public boolean checkForStringAttributes()
    {
        return checkForAttributeType(2);
    //    0    0:aload_0         
    //    1    1:iconst_2        
    //    2    2:invokevirtual   #218 <Method boolean checkForAttributeType(int)>
    //    3    5:ireturn         
    }

    public boolean checkInstance(Instance instance)
    {
        if(instance.numAttributes() != numAttributes())
    //*   0    0:aload_1         
    //*   1    1:invokevirtual   #221 <Method int Instance.numAttributes()>
    //*   2    4:aload_0         
    //*   3    5:invokevirtual   #160 <Method int numAttributes()>
    //*   4    8:icmpeq          13
            return false;
    //    5   11:iconst_0        
    //    6   12:ireturn         
        for(int i = 0; i < numAttributes(); i++)
    //*   7   13:iconst_0        
    //*   8   14:istore_2        
    //*   9   15:goto            108
            if(!instance.isMissing(i) && (attribute(i).isNominal() || attribute(i).isString()))
    //*  10   18:aload_1         
    //*  11   19:iload_2         
    //*  12   20:invokevirtual   #224 <Method boolean Instance.isMissing(int)>
    //*  13   23:ifeq            29
    //*  14   26:goto            105
    //*  15   29:aload_0         
    //*  16   30:iload_2         
    //*  17   31:invokevirtual   #154 <Method Attribute attribute(int)>
    //*  18   34:invokevirtual   #227 <Method boolean Attribute.isNominal()>
    //*  19   37:ifne            51
    //*  20   40:aload_0         
    //*  21   41:iload_2         
    //*  22   42:invokevirtual   #154 <Method Attribute attribute(int)>
    //*  23   45:invokevirtual   #230 <Method boolean Attribute.isString()>
    //*  24   48:ifeq            105
            {
                if(!Utils.eq(instance.value(i), (int)instance.value(i)))
    //*  25   51:aload_1         
    //*  26   52:iload_2         
    //*  27   53:invokevirtual   #234 <Method double Instance.value(int)>
    //*  28   56:aload_1         
    //*  29   57:iload_2         
    //*  30   58:invokevirtual   #234 <Method double Instance.value(int)>
    //*  31   61:d2i             
    //*  32   62:i2d             
    //*  33   63:invokestatic    #240 <Method boolean Utils.eq(double, double)>
    //*  34   66:ifne            71
                    return false;
    //   35   69:iconst_0        
    //   36   70:ireturn         
                if(Utils.sm(instance.value(i), 0.0D) || Utils.gr(instance.value(i), attribute(i).numValues()))
    //*  37   71:aload_1         
    //*  38   72:iload_2         
    //*  39   73:invokevirtual   #234 <Method double Instance.value(int)>
    //*  40   76:dconst_0        
    //*  41   77:invokestatic    #243 <Method boolean Utils.sm(double, double)>
    //*  42   80:ifne            103
    //*  43   83:aload_1         
    //*  44   84:iload_2         
    //*  45   85:invokevirtual   #234 <Method double Instance.value(int)>
    //*  46   88:aload_0         
    //*  47   89:iload_2         
    //*  48   90:invokevirtual   #154 <Method Attribute attribute(int)>
    //*  49   93:invokevirtual   #246 <Method int Attribute.numValues()>
    //*  50   96:i2d             
    //*  51   97:invokestatic    #249 <Method boolean Utils.gr(double, double)>
    //*  52  100:ifeq            105
                    return false;
    //   53  103:iconst_0        
    //   54  104:ireturn         
            }

    //   55  105:iinc            2  1
    //   56  108:iload_2         
    //   57  109:aload_0         
    //   58  110:invokevirtual   #160 <Method int numAttributes()>
    //   59  113:icmplt          18
        return true;
    //   60  116:iconst_1        
    //   61  117:ireturn         
    }

    public Attribute classAttribute()
    {
        if(m_ClassIndex < 0)
    //*   0    0:aload_0         
    //*   1    1:getfield        #77  <Field int m_ClassIndex>
    //*   2    4:ifge            17
            throw new UnassignedClassException("Class index is negative (not set)!");
    //    3    7:new             #253 <Class UnassignedClassException>
    //    4   10:dup             
    //    5   11:ldc1            #255 <String "Class index is negative (not set)!">
    //    6   13:invokespecial   #256 <Method void UnassignedClassException(String)>
    //    7   16:athrow          
        else
            return attribute(m_ClassIndex);
    //    8   17:aload_0         
    //    9   18:aload_0         
    //   10   19:getfield        #77  <Field int m_ClassIndex>
    //   11   22:invokevirtual   #154 <Method Attribute attribute(int)>
    //   12   25:areturn         
    }

    public int classIndex()
    {
        return m_ClassIndex;
    //    0    0:aload_0         
    //    1    1:getfield        #77  <Field int m_ClassIndex>
    //    2    4:ireturn         
    }

    public void compactify()
    {
        m_Instances.trimToSize();
    //    0    0:aload_0         
    //    1    1:getfield        #88  <Field FastVector m_Instances>
    //    2    4:invokevirtual   #260 <Method void FastVector.trimToSize()>
    //    3    7:return          
    }

    public void delete()
    {
        m_Instances = new FastVector();
    //    0    0:aload_0         
    //    1    1:new             #83  <Class FastVector>
    //    2    4:dup             
    //    3    5:invokespecial   #170 <Method void FastVector()>
    //    4    8:putfield        #88  <Field FastVector m_Instances>
    //    5   11:return          
    }

    public void delete(int index)
    {
        m_Instances.removeElementAt(index);
    //    0    0:aload_0         
    //    1    1:getfield        #88  <Field FastVector m_Instances>
    //    2    4:iload_1         
    //    3    5:invokevirtual   #264 <Method void FastVector.removeElementAt(int)>
    //    4    8:return          
    }

    public void deleteAttributeAt(int position)
    {
        if(position < 0 || position >= m_Attributes.size())
    //*   0    0:iload_1         
    //*   1    1:iflt            15
    //*   2    4:iload_1         
    //*   3    5:aload_0         
    //*   4    6:getfield        #81  <Field FastVector m_Attributes>
    //*   5    9:invokevirtual   #143 <Method int FastVector.size()>
    //*   6   12:icmplt          26
            throw new IllegalArgumentException("Index out of range");
    //    7   15:new             #91  <Class IllegalArgumentException>
    //    8   18:dup             
    //    9   19:ldc2            #267 <String "Index out of range">
    //   10   22:invokespecial   #96  <Method void IllegalArgumentException(String)>
    //   11   25:athrow          
        if(position == m_ClassIndex)
    //*  12   26:iload_1         
    //*  13   27:aload_0         
    //*  14   28:getfield        #77  <Field int m_ClassIndex>
    //*  15   31:icmpne          45
            throw new IllegalArgumentException("Can't delete class attribute");
    //   16   34:new             #91  <Class IllegalArgumentException>
    //   17   37:dup             
    //   18   38:ldc2            #269 <String "Can't delete class attribute">
    //   19   41:invokespecial   #96  <Method void IllegalArgumentException(String)>
    //   20   44:athrow          
        freshAttributeInfo();
    //   21   45:aload_0         
    //   22   46:invokevirtual   #272 <Method void freshAttributeInfo()>
        if(m_ClassIndex > position)
    //*  23   49:aload_0         
    //*  24   50:getfield        #77  <Field int m_ClassIndex>
    //*  25   53:iload_1         
    //*  26   54:icmple          67
            m_ClassIndex--;
    //   27   57:aload_0         
    //   28   58:dup             
    //   29   59:getfield        #77  <Field int m_ClassIndex>
    //   30   62:iconst_1        
    //   31   63:isub            
    //   32   64:putfield        #77  <Field int m_ClassIndex>
        m_Attributes.removeElementAt(position);
    //   33   67:aload_0         
    //   34   68:getfield        #81  <Field FastVector m_Attributes>
    //   35   71:iload_1         
    //   36   72:invokevirtual   #264 <Method void FastVector.removeElementAt(int)>
        for(int i = position; i < m_Attributes.size(); i++)
    //*  37   75:iload_1         
    //*  38   76:istore_2        
    //*  39   77:goto            105
        {
            Attribute current = (Attribute)m_Attributes.elementAt(i);
    //   40   80:aload_0         
    //   41   81:getfield        #81  <Field FastVector m_Attributes>
    //   42   84:iload_2         
    //   43   85:invokevirtual   #110 <Method Object FastVector.elementAt(int)>
    //   44   88:checkcast       #112 <Class Attribute>
    //   45   91:astore_3        
            current.setIndex(current.index() - 1);
    //   46   92:aload_3         
    //   47   93:aload_3         
    //   48   94:invokevirtual   #186 <Method int Attribute.index()>
    //   49   97:iconst_1        
    //   50   98:isub            
    //   51   99:invokevirtual   #157 <Method void Attribute.setIndex(int)>
        }

    //   52  102:iinc            2  1
    //   53  105:iload_2         
    //   54  106:aload_0         
    //   55  107:getfield        #81  <Field FastVector m_Attributes>
    //   56  110:invokevirtual   #143 <Method int FastVector.size()>
    //   57  113:icmplt          80
        for(int i = 0; i < numInstances(); i++)
    //*  58  116:iconst_0        
    //*  59  117:istore_2        
    //*  60  118:goto            133
            instance(i).forceDeleteAttributeAt(position);
    //   61  121:aload_0         
    //   62  122:iload_2         
    //   63  123:invokevirtual   #275 <Method Instance instance(int)>
    //   64  126:iload_1         
    //   65  127:invokevirtual   #278 <Method void Instance.forceDeleteAttributeAt(int)>

    //   66  130:iinc            2  1
    //   67  133:iload_2         
    //   68  134:aload_0         
    //   69  135:invokevirtual   #51  <Method int numInstances()>
    //   70  138:icmplt          121
    //   71  141:return          
    }

    public void deleteAttributeType(int attType)
    {
        for(int i = 0; i < m_Attributes.size();)
    //*   0    0:iconst_0        
    //*   1    1:istore_2        
    //*   2    2:goto            28
            if(attribute(i).type() == attType)
    //*   3    5:aload_0         
    //*   4    6:iload_2         
    //*   5    7:invokevirtual   #154 <Method Attribute attribute(int)>
    //*   6   10:invokevirtual   #173 <Method int Attribute.type()>
    //*   7   13:iload_1         
    //*   8   14:icmpne          25
                deleteAttributeAt(i);
    //    9   17:aload_0         
    //   10   18:iload_2         
    //   11   19:invokevirtual   #283 <Method void deleteAttributeAt(int)>
            else
    //*  12   22:goto            28
                i++;
    //   13   25:iinc            2  1

    //   14   28:iload_2         
    //   15   29:aload_0         
    //   16   30:getfield        #81  <Field FastVector m_Attributes>
    //   17   33:invokevirtual   #143 <Method int FastVector.size()>
    //   18   36:icmplt          5
    //   19   39:return          
    }

    public void deleteStringAttributes()
    {
        deleteAttributeType(2);
    //    0    0:aload_0         
    //    1    1:iconst_2        
    //    2    2:invokevirtual   #286 <Method void deleteAttributeType(int)>
    //    3    5:return          
    }

    public void deleteWithMissing(int attIndex)
    {
        FastVector newInstances = new FastVector(numInstances());
    //    0    0:new             #83  <Class FastVector>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:invokevirtual   #51  <Method int numInstances()>
    //    4    8:invokespecial   #86  <Method void FastVector(int)>
    //    5   11:astore_2        
        for(int i = 0; i < numInstances(); i++)
    //*   6   12:iconst_0        
    //*   7   13:istore_3        
    //*   8   14:goto            41
            if(!instance(i).isMissing(attIndex))
    //*   9   17:aload_0         
    //*  10   18:iload_3         
    //*  11   19:invokevirtual   #275 <Method Instance instance(int)>
    //*  12   22:iload_1         
    //*  13   23:invokevirtual   #224 <Method boolean Instance.isMissing(int)>
    //*  14   26:ifne            38
                newInstances.addElement(instance(i));
    //   15   29:aload_2         
    //   16   30:aload_0         
    //   17   31:iload_3         
    //   18   32:invokevirtual   #275 <Method Instance instance(int)>
    //   19   35:invokevirtual   #179 <Method void FastVector.addElement(Object)>

    //   20   38:iinc            3  1
    //   21   41:iload_3         
    //   22   42:aload_0         
    //   23   43:invokevirtual   #51  <Method int numInstances()>
    //   24   46:icmplt          17
        m_Instances = newInstances;
    //   25   49:aload_0         
    //   26   50:aload_2         
    //   27   51:putfield        #88  <Field FastVector m_Instances>
    //   28   54:return          
    }

    public void deleteWithMissing(Attribute att)
    {
        deleteWithMissing(att.index());
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokevirtual   #186 <Method int Attribute.index()>
    //    3    5:invokevirtual   #292 <Method void deleteWithMissing(int)>
    //    4    8:return          
    }

    public void deleteWithMissingClass()
    {
        if(m_ClassIndex < 0)
    //*   0    0:aload_0         
    //*   1    1:getfield        #77  <Field int m_ClassIndex>
    //*   2    4:ifge            17
        {
            throw new UnassignedClassException("Class index is negative (not set)!");
    //    3    7:new             #253 <Class UnassignedClassException>
    //    4   10:dup             
    //    5   11:ldc1            #255 <String "Class index is negative (not set)!">
    //    6   13:invokespecial   #256 <Method void UnassignedClassException(String)>
    //    7   16:athrow          
        } else
        {
            deleteWithMissing(m_ClassIndex);
    //    8   17:aload_0         
    //    9   18:aload_0         
    //   10   19:getfield        #77  <Field int m_ClassIndex>
    //   11   22:invokevirtual   #292 <Method void deleteWithMissing(int)>
            return;
    //   12   25:return          
        }
    }

    public Enumeration enumerateAttributes()
    {
        return m_Attributes.elements(m_ClassIndex);
    //    0    0:aload_0         
    //    1    1:getfield        #81  <Field FastVector m_Attributes>
    //    2    4:aload_0         
    //    3    5:getfield        #77  <Field int m_ClassIndex>
    //    4    8:invokevirtual   #299 <Method Enumeration FastVector.elements(int)>
    //    5   11:areturn         
    }

    public Enumeration enumerateInstances()
    {
        return m_Instances.elements();
    //    0    0:aload_0         
    //    1    1:getfield        #88  <Field FastVector m_Instances>
    //    2    4:invokevirtual   #302 <Method Enumeration FastVector.elements()>
    //    3    7:areturn         
    }

    public boolean equalHeaders(Instances dataset)
    {
        if(m_ClassIndex != dataset.m_ClassIndex)
    //*   0    0:aload_0         
    //*   1    1:getfield        #77  <Field int m_ClassIndex>
    //*   2    4:aload_1         
    //*   3    5:getfield        #77  <Field int m_ClassIndex>
    //*   4    8:icmpeq          13
            return false;
    //    5   11:iconst_0        
    //    6   12:ireturn         
        if(m_Attributes.size() != dataset.m_Attributes.size())
    //*   7   13:aload_0         
    //*   8   14:getfield        #81  <Field FastVector m_Attributes>
    //*   9   17:invokevirtual   #143 <Method int FastVector.size()>
    //*  10   20:aload_1         
    //*  11   21:getfield        #81  <Field FastVector m_Attributes>
    //*  12   24:invokevirtual   #143 <Method int FastVector.size()>
    //*  13   27:icmpeq          32
            return false;
    //   14   30:iconst_0        
    //   15   31:ireturn         
        for(int i = 0; i < m_Attributes.size(); i++)
    //*  16   32:iconst_0        
    //*  17   33:istore_2        
    //*  18   34:goto            58
            if(!attribute(i).equals(dataset.attribute(i)))
    //*  19   37:aload_0         
    //*  20   38:iload_2         
    //*  21   39:invokevirtual   #154 <Method Attribute attribute(int)>
    //*  22   42:aload_1         
    //*  23   43:iload_2         
    //*  24   44:invokevirtual   #154 <Method Attribute attribute(int)>
    //*  25   47:invokevirtual   #305 <Method boolean Attribute.equals(Object)>
    //*  26   50:ifne            55
                return false;
    //   27   53:iconst_0        
    //   28   54:ireturn         

    //   29   55:iinc            2  1
    //   30   58:iload_2         
    //   31   59:aload_0         
    //   32   60:getfield        #81  <Field FastVector m_Attributes>
    //   33   63:invokevirtual   #143 <Method int FastVector.size()>
    //   34   66:icmplt          37
        return true;
    //   35   69:iconst_1        
    //   36   70:ireturn         
    }

    public Instance firstInstance()
    {
        return (Instance)m_Instances.firstElement();
    //    0    0:aload_0         
    //    1    1:getfield        #88  <Field FastVector m_Instances>
    //    2    4:invokevirtual   #310 <Method Object FastVector.firstElement()>
    //    3    7:checkcast       #198 <Class Instance>
    //    4   10:areturn         
    }

    public Random getRandomNumberGenerator(long seed)
    {
        Random r = new Random(seed);
    //    0    0:new             #314 <Class Random>
    //    1    3:dup             
    //    2    4:lload_1         
    //    3    5:invokespecial   #317 <Method void Random(long)>
    //    4    8:astore_3        
        r.setSeed((long)instance(r.nextInt(numInstances())).toStringNoWeight().hashCode() + seed);
    //    5    9:aload_3         
    //    6   10:aload_0         
    //    7   11:aload_3         
    //    8   12:aload_0         
    //    9   13:invokevirtual   #51  <Method int numInstances()>
    //   10   16:invokevirtual   #321 <Method int Random.nextInt(int)>
    //   11   19:invokevirtual   #275 <Method Instance instance(int)>
    //   12   22:invokevirtual   #324 <Method String Instance.toStringNoWeight()>
    //   13   25:invokevirtual   #327 <Method int String.hashCode()>
    //   14   28:i2l             
    //   15   29:lload_1         
    //   16   30:ladd            
    //   17   31:invokevirtual   #330 <Method void Random.setSeed(long)>
        return r;
    //   18   34:aload_3         
    //   19   35:areturn         
    }

    public void insertAttributeAt(Attribute att, int position)
    {
        if(position < 0 || position > m_Attributes.size())
    //*   0    0:iload_2         
    //*   1    1:iflt            15
    //*   2    4:iload_2         
    //*   3    5:aload_0         
    //*   4    6:getfield        #81  <Field FastVector m_Attributes>
    //*   5    9:invokevirtual   #143 <Method int FastVector.size()>
    //*   6   12:icmple          26
            throw new IllegalArgumentException("Index out of range");
    //    7   15:new             #91  <Class IllegalArgumentException>
    //    8   18:dup             
    //    9   19:ldc2            #267 <String "Index out of range">
    //   10   22:invokespecial   #96  <Method void IllegalArgumentException(String)>
    //   11   25:athrow          
        att = (Attribute)att.copy();
    //   12   26:aload_1         
    //   13   27:invokevirtual   #337 <Method Object Attribute.copy()>
    //   14   30:checkcast       #112 <Class Attribute>
    //   15   33:astore_1        
        freshAttributeInfo();
    //   16   34:aload_0         
    //   17   35:invokevirtual   #272 <Method void freshAttributeInfo()>
        att.setIndex(position);
    //   18   38:aload_1         
    //   19   39:iload_2         
    //   20   40:invokevirtual   #157 <Method void Attribute.setIndex(int)>
        m_Attributes.insertElementAt(att, position);
    //   21   43:aload_0         
    //   22   44:getfield        #81  <Field FastVector m_Attributes>
    //   23   47:aload_1         
    //   24   48:iload_2         
    //   25   49:invokevirtual   #340 <Method void FastVector.insertElementAt(Object, int)>
        for(int i = position + 1; i < m_Attributes.size(); i++)
    //*  26   52:iload_2         
    //*  27   53:iconst_1        
    //*  28   54:iadd            
    //*  29   55:istore_3        
    //*  30   56:goto            87
        {
            Attribute current = (Attribute)m_Attributes.elementAt(i);
    //   31   59:aload_0         
    //   32   60:getfield        #81  <Field FastVector m_Attributes>
    //   33   63:iload_3         
    //   34   64:invokevirtual   #110 <Method Object FastVector.elementAt(int)>
    //   35   67:checkcast       #112 <Class Attribute>
    //   36   70:astore          4
            current.setIndex(current.index() + 1);
    //   37   72:aload           4
    //   38   74:aload           4
    //   39   76:invokevirtual   #186 <Method int Attribute.index()>
    //   40   79:iconst_1        
    //   41   80:iadd            
    //   42   81:invokevirtual   #157 <Method void Attribute.setIndex(int)>
        }

    //   43   84:iinc            3  1
    //   44   87:iload_3         
    //   45   88:aload_0         
    //   46   89:getfield        #81  <Field FastVector m_Attributes>
    //   47   92:invokevirtual   #143 <Method int FastVector.size()>
    //   48   95:icmplt          59
        for(int i = 0; i < numInstances(); i++)
    //*  49   98:iconst_0        
    //*  50   99:istore_3        
    //*  51  100:goto            115
            instance(i).forceInsertAttributeAt(position);
    //   52  103:aload_0         
    //   53  104:iload_3         
    //   54  105:invokevirtual   #275 <Method Instance instance(int)>
    //   55  108:iload_2         
    //   56  109:invokevirtual   #343 <Method void Instance.forceInsertAttributeAt(int)>

    //   57  112:iinc            3  1
    //   58  115:iload_3         
    //   59  116:aload_0         
    //   60  117:invokevirtual   #51  <Method int numInstances()>
    //   61  120:icmplt          103
        if(m_ClassIndex >= position)
    //*  62  123:aload_0         
    //*  63  124:getfield        #77  <Field int m_ClassIndex>
    //*  64  127:iload_2         
    //*  65  128:icmplt          141
            m_ClassIndex++;
    //   66  131:aload_0         
    //   67  132:dup             
    //   68  133:getfield        #77  <Field int m_ClassIndex>
    //   69  136:iconst_1        
    //   70  137:iadd            
    //   71  138:putfield        #77  <Field int m_ClassIndex>
    //   72  141:return          
    }

    public Instance instance(int index)
    {
        return (Instance)m_Instances.elementAt(index);
    //    0    0:aload_0         
    //    1    1:getfield        #88  <Field FastVector m_Instances>
    //    2    4:iload_1         
    //    3    5:invokevirtual   #110 <Method Object FastVector.elementAt(int)>
    //    4    8:checkcast       #198 <Class Instance>
    //    5   11:areturn         
    }

    public double kthSmallestValue(Attribute att, int k)
    {
        return kthSmallestValue(att.index(), k);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokevirtual   #186 <Method int Attribute.index()>
    //    3    5:iload_2         
    //    4    6:invokevirtual   #348 <Method double kthSmallestValue(int, int)>
    //    5    9:dreturn         
    }

    public double kthSmallestValue(int attIndex, int k)
    {
        if(!attribute(attIndex).isNumeric())
    //*   0    0:aload_0         
    //*   1    1:iload_1         
    //*   2    2:invokevirtual   #154 <Method Attribute attribute(int)>
    //*   3    5:invokevirtual   #352 <Method boolean Attribute.isNumeric()>
    //*   4    8:ifne            22
            throw new IllegalArgumentException("Instances: attribute must be numeric to compute kth-smallest value.");
    //    5   11:new             #91  <Class IllegalArgumentException>
    //    6   14:dup             
    //    7   15:ldc2            #354 <String "Instances: attribute must be numeric to compute kth-smallest value.">
    //    8   18:invokespecial   #96  <Method void IllegalArgumentException(String)>
    //    9   21:athrow          
        int j = numInstances() - 1;
    //   10   22:aload_0         
    //   11   23:invokevirtual   #51  <Method int numInstances()>
    //   12   26:iconst_1        
    //   13   27:isub            
    //   14   28:istore          4
        for(int i = 0; i <= j;)
    //*  15   30:iconst_0        
    //*  16   31:istore_3        
    //*  17   32:goto            79
            if(instance(j).isMissing(attIndex))
    //*  18   35:aload_0         
    //*  19   36:iload           4
    //*  20   38:invokevirtual   #275 <Method Instance instance(int)>
    //*  21   41:iload_1         
    //*  22   42:invokevirtual   #224 <Method boolean Instance.isMissing(int)>
    //*  23   45:ifeq            54
            {
                j--;
    //   24   48:iinc            4  -1
            } else
    //*  25   51:goto            79
            {
                if(instance(i).isMissing(attIndex))
    //*  26   54:aload_0         
    //*  27   55:iload_3         
    //*  28   56:invokevirtual   #275 <Method Instance instance(int)>
    //*  29   59:iload_1         
    //*  30   60:invokevirtual   #224 <Method boolean Instance.isMissing(int)>
    //*  31   63:ifeq            76
                {
                    swap(i, j);
    //   32   66:aload_0         
    //   33   67:iload_3         
    //   34   68:iload           4
    //   35   70:invokevirtual   #358 <Method void swap(int, int)>
                    j--;
    //   36   73:iinc            4  -1
                }
                i++;
    //   37   76:iinc            3  1
            }

    //   38   79:iload_3         
    //   39   80:iload           4
    //   40   82:icmple          35
        if(k < 1 || k > j + 1)
    //*  41   85:iload_2         
    //*  42   86:iconst_1        
    //*  43   87:icmplt          98
    //*  44   90:iload_2         
    //*  45   91:iload           4
    //*  46   93:iconst_1        
    //*  47   94:iadd            
    //*  48   95:icmple          109
            throw new IllegalArgumentException("Instances: value for k for computing kth-smallest value too large.");
    //   49   98:new             #91  <Class IllegalArgumentException>
    //   50  101:dup             
    //   51  102:ldc2            #360 <String "Instances: value for k for computing kth-smallest value too large.">
    //   52  105:invokespecial   #96  <Method void IllegalArgumentException(String)>
    //   53  108:athrow          
        else
            return instance(select(attIndex, 0, j, k)).value(attIndex);
    //   54  109:aload_0         
    //   55  110:aload_0         
    //   56  111:iload_1         
    //   57  112:iconst_0        
    //   58  113:iload           4
    //   59  115:iload_2         
    //   60  116:invokevirtual   #364 <Method int select(int, int, int, int)>
    //   61  119:invokevirtual   #275 <Method Instance instance(int)>
    //   62  122:iload_1         
    //   63  123:invokevirtual   #234 <Method double Instance.value(int)>
    //   64  126:dreturn         
    }

    public Instance lastInstance()
    {
        return (Instance)m_Instances.lastElement();
    //    0    0:aload_0         
    //    1    1:getfield        #88  <Field FastVector m_Instances>
    //    2    4:invokevirtual   #369 <Method Object FastVector.lastElement()>
    //    3    7:checkcast       #198 <Class Instance>
    //    4   10:areturn         
    }

    public double meanOrMode(int attIndex)
    {
        if(attribute(attIndex).isNumeric())
    //*   0    0:aload_0         
    //*   1    1:iload_1         
    //*   2    2:invokevirtual   #154 <Method Attribute attribute(int)>
    //*   3    5:invokevirtual   #352 <Method boolean Attribute.isNumeric()>
    //*   4    8:ifeq            98
        {
            double found;
            double result = found = 0.0D;
    //    5   11:dconst_0        
    //    6   12:dup2            
    //    7   13:dstore          4
    //    8   15:dstore_2        
            for(int j = 0; j < numInstances(); j++)
    //*   9   16:iconst_0        
    //*  10   17:istore          7
    //*  11   19:goto            75
                if(!instance(j).isMissing(attIndex))
    //*  12   22:aload_0         
    //*  13   23:iload           7
    //*  14   25:invokevirtual   #275 <Method Instance instance(int)>
    //*  15   28:iload_1         
    //*  16   29:invokevirtual   #224 <Method boolean Instance.isMissing(int)>
    //*  17   32:ifne            72
                {
                    found += instance(j).weight();
    //   18   35:dload           4
    //   19   37:aload_0         
    //   20   38:iload           7
    //   21   40:invokevirtual   #275 <Method Instance instance(int)>
    //   22   43:invokevirtual   #374 <Method double Instance.weight()>
    //   23   46:dadd            
    //   24   47:dstore          4
                    result += instance(j).weight() * instance(j).value(attIndex);
    //   25   49:dload_2         
    //   26   50:aload_0         
    //   27   51:iload           7
    //   28   53:invokevirtual   #275 <Method Instance instance(int)>
    //   29   56:invokevirtual   #374 <Method double Instance.weight()>
    //   30   59:aload_0         
    //   31   60:iload           7
    //   32   62:invokevirtual   #275 <Method Instance instance(int)>
    //   33   65:iload_1         
    //   34   66:invokevirtual   #234 <Method double Instance.value(int)>
    //   35   69:dmul            
    //   36   70:dadd            
    //   37   71:dstore_2        
                }

    //   38   72:iinc            7  1
    //   39   75:iload           7
    //   40   77:aload_0         
    //   41   78:invokevirtual   #51  <Method int numInstances()>
    //   42   81:icmplt          22
            if(found <= 0.0D)
    //*  43   84:dload           4
    //*  44   86:dconst_0        
    //*  45   87:dcmpg           
    //*  46   88:ifgt            93
                return 0.0D;
    //   47   91:dconst_0        
    //   48   92:dreturn         
            else
                return result / found;
    //   49   93:dload_2         
    //   50   94:dload           4
    //   51   96:ddiv            
    //   52   97:dreturn         
        }
        if(attribute(attIndex).isNominal())
    //*  53   98:aload_0         
    //*  54   99:iload_1         
    //*  55  100:invokevirtual   #154 <Method Attribute attribute(int)>
    //*  56  103:invokevirtual   #227 <Method boolean Attribute.isNominal()>
    //*  57  106:ifeq            187
        {
            int counts[] = new int[attribute(attIndex).numValues()];
    //   58  109:aload_0         
    //   59  110:iload_1         
    //   60  111:invokevirtual   #154 <Method Attribute attribute(int)>
    //   61  114:invokevirtual   #246 <Method int Attribute.numValues()>
    //   62  117:newarray        int[]
    //   63  119:astore          6
            for(int j = 0; j < numInstances(); j++)
    //*  64  121:iconst_0        
    //*  65  122:istore          7
    //*  66  124:goto            171
                if(!instance(j).isMissing(attIndex))
    //*  67  127:aload_0         
    //*  68  128:iload           7
    //*  69  130:invokevirtual   #275 <Method Instance instance(int)>
    //*  70  133:iload_1         
    //*  71  134:invokevirtual   #224 <Method boolean Instance.isMissing(int)>
    //*  72  137:ifne            168
                    counts[(int)instance(j).value(attIndex)] += instance(j).weight();
    //   73  140:aload           6
    //   74  142:aload_0         
    //   75  143:iload           7
    //   76  145:invokevirtual   #275 <Method Instance instance(int)>
    //   77  148:iload_1         
    //   78  149:invokevirtual   #234 <Method double Instance.value(int)>
    //   79  152:d2i             
    //   80  153:dup2            
    //   81  154:iaload          
    //   82  155:i2d             
    //   83  156:aload_0         
    //   84  157:iload           7
    //   85  159:invokevirtual   #275 <Method Instance instance(int)>
    //   86  162:invokevirtual   #374 <Method double Instance.weight()>
    //   87  165:dadd            
    //   88  166:d2i             
    //   89  167:iastore         

    //   90  168:iinc            7  1
    //   91  171:iload           7
    //   92  173:aload_0         
    //   93  174:invokevirtual   #51  <Method int numInstances()>
    //   94  177:icmplt          127
            return (double)Utils.maxIndex(counts);
    //   95  180:aload           6
    //   96  182:invokestatic    #378 <Method int Utils.maxIndex(int[])>
    //   97  185:i2d             
    //   98  186:dreturn         
        } else
        {
            return 0.0D;
    //   99  187:dconst_0        
    //  100  188:dreturn         
        }
    }

    public double meanOrMode(Attribute att)
    {
        return meanOrMode(att.index());
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokevirtual   #186 <Method int Attribute.index()>
    //    3    5:invokevirtual   #385 <Method double meanOrMode(int)>
    //    4    8:dreturn         
    }

    public int numAttributes()
    {
        return m_Attributes.size();
    //    0    0:aload_0         
    //    1    1:getfield        #81  <Field FastVector m_Attributes>
    //    2    4:invokevirtual   #143 <Method int FastVector.size()>
    //    3    7:ireturn         
    }

    public int numClasses()
    {
        if(m_ClassIndex < 0)
    //*   0    0:aload_0         
    //*   1    1:getfield        #77  <Field int m_ClassIndex>
    //*   2    4:ifge            17
            throw new UnassignedClassException("Class index is negative (not set)!");
    //    3    7:new             #253 <Class UnassignedClassException>
    //    4   10:dup             
    //    5   11:ldc1            #255 <String "Class index is negative (not set)!">
    //    6   13:invokespecial   #256 <Method void UnassignedClassException(String)>
    //    7   16:athrow          
        if(!classAttribute().isNominal())
    //*   8   17:aload_0         
    //*   9   18:invokevirtual   #388 <Method Attribute classAttribute()>
    //*  10   21:invokevirtual   #227 <Method boolean Attribute.isNominal()>
    //*  11   24:ifne            29
            return 1;
    //   12   27:iconst_1        
    //   13   28:ireturn         
        else
            return classAttribute().numValues();
    //   14   29:aload_0         
    //   15   30:invokevirtual   #388 <Method Attribute classAttribute()>
    //   16   33:invokevirtual   #246 <Method int Attribute.numValues()>
    //   17   36:ireturn         
    }

    public int numDistinctValues(int attIndex)
    {
        if(attribute(attIndex).isNumeric())
    //*   0    0:aload_0         
    //*   1    1:iload_1         
    //*   2    2:invokevirtual   #154 <Method Attribute attribute(int)>
    //*   3    5:invokevirtual   #352 <Method boolean Attribute.isNumeric()>
    //*   4    8:ifeq            97
        {
            double attVals[] = attributeToDoubleArray(attIndex);
    //    5   11:aload_0         
    //    6   12:iload_1         
    //    7   13:invokevirtual   #393 <Method double[] attributeToDoubleArray(int)>
    //    8   16:astore_2        
            int sorted[] = Utils.sort(attVals);
    //    9   17:aload_2         
    //   10   18:invokestatic    #397 <Method int[] Utils.sort(double[])>
    //   11   21:astore_3        
            double prev = 0.0D;
    //   12   22:dconst_0        
    //   13   23:dstore          4
            int counter = 0;
    //   14   25:iconst_0        
    //   15   26:istore          6
            for(int i = 0; i < sorted.length; i++)
    //*  16   28:iconst_0        
    //*  17   29:istore          7
    //*  18   31:goto            87
            {
                Instance current = instance(sorted[i]);
    //   19   34:aload_0         
    //   20   35:aload_3         
    //   21   36:iload           7
    //   22   38:iaload          
    //   23   39:invokevirtual   #275 <Method Instance instance(int)>
    //   24   42:astore          8
                if(current.isMissing(attIndex))
    //*  25   44:aload           8
    //*  26   46:iload_1         
    //*  27   47:invokevirtual   #224 <Method boolean Instance.isMissing(int)>
    //*  28   50:ifeq            56
                    break;
    //   29   53:goto            94
                if(i == 0 || current.value(attIndex) > prev)
    //*  30   56:iload           7
    //*  31   58:ifeq            73
    //*  32   61:aload           8
    //*  33   63:iload_1         
    //*  34   64:invokevirtual   #234 <Method double Instance.value(int)>
    //*  35   67:dload           4
    //*  36   69:dcmpl           
    //*  37   70:ifle            84
                {
                    prev = current.value(attIndex);
    //   38   73:aload           8
    //   39   75:iload_1         
    //   40   76:invokevirtual   #234 <Method double Instance.value(int)>
    //   41   79:dstore          4
                    counter++;
    //   42   81:iinc            6  1
                }
            }

    //   43   84:iinc            7  1
    //   44   87:iload           7
    //   45   89:aload_3         
    //   46   90:arraylength     
    //   47   91:icmplt          34
            return counter;
    //   48   94:iload           6
    //   49   96:ireturn         
        } else
        {
            return attribute(attIndex).numValues();
    //   50   97:aload_0         
    //   51   98:iload_1         
    //   52   99:invokevirtual   #154 <Method Attribute attribute(int)>
    //   53  102:invokevirtual   #246 <Method int Attribute.numValues()>
    //   54  105:ireturn         
        }
    }

    public int numDistinctValues(Attribute att)
    {
        return numDistinctValues(att.index());
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokevirtual   #186 <Method int Attribute.index()>
    //    3    5:invokevirtual   #405 <Method int numDistinctValues(int)>
    //    4    8:ireturn         
    }

    public int numInstances()
    {
        return m_Instances.size();
    //    0    0:aload_0         
    //    1    1:getfield        #88  <Field FastVector m_Instances>
    //    2    4:invokevirtual   #143 <Method int FastVector.size()>
    //    3    7:ireturn         
    }

    public void randomize(Random random)
    {
        for(int j = numInstances() - 1; j > 0; j--)
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #51  <Method int numInstances()>
    //*   2    4:iconst_1        
    //*   3    5:isub            
    //*   4    6:istore_2        
    //*   5    7:goto            25
            swap(j, random.nextInt(j + 1));
    //    6   10:aload_0         
    //    7   11:iload_2         
    //    8   12:aload_1         
    //    9   13:iload_2         
    //   10   14:iconst_1        
    //   11   15:iadd            
    //   12   16:invokevirtual   #321 <Method int Random.nextInt(int)>
    //   13   19:invokevirtual   #358 <Method void swap(int, int)>

    //   14   22:iinc            2  -1
    //   15   25:iload_2         
    //   16   26:ifgt            10
    //   17   29:return          
    }

    /**
     * @deprecated Method readInstance is deprecated
     */

    public boolean readInstance(Reader reader)
        throws IOException
    {
        rm.core.converters.ArffLoader.ArffReader ass = new rm.core.converters.ArffLoader.ArffReader(reader, this, m_Lines, 1);
    //    0    0:new             #41  <Class rm.core.converters.ArffLoader$ArffReader>
    //    1    3:dup             
    //    2    4:aload_1         
    //    3    5:aload_0         
    //    4    6:aload_0         
    //    5    7:getfield        #39  <Field int m_Lines>
    //    6   10:iconst_1        
    //    7   11:invokespecial   #416 <Method void rm.core.converters.ArffLoader$ArffReader(Reader, Instances, int, int)>
    //    8   14:astore_2        
        Instance inst = ass.readInstance(ass.getData(), false);
    //    9   15:aload_2         
    //   10   16:aload_2         
    //   11   17:invokevirtual   #47  <Method Instances rm.core.converters.ArffLoader$ArffReader.getData()>
    //   12   20:iconst_0        
    //   13   21:invokevirtual   #419 <Method Instance rm.core.converters.ArffLoader$ArffReader.readInstance(Instances, boolean)>
    //   14   24:astore_3        
        m_Lines = ass.getLineNo();
    //   15   25:aload_0         
    //   16   26:aload_2         
    //   17   27:invokevirtual   #422 <Method int rm.core.converters.ArffLoader$ArffReader.getLineNo()>
    //   18   30:putfield        #39  <Field int m_Lines>
        if(inst != null)
    //*  19   33:aload_3         
    //*  20   34:ifnull          44
        {
            add(inst);
    //   21   37:aload_0         
    //   22   38:aload_3         
    //   23   39:invokevirtual   #424 <Method void add(Instance)>
            return true;
    //   24   42:iconst_1        
    //   25   43:ireturn         
        } else
        {
            return false;
    //   26   44:iconst_0        
    //   27   45:ireturn         
        }
    }

    public String relationName()
    {
        return m_DimensionName;
    //    0    0:aload_0         
    //    1    1:getfield        #79  <Field String m_DimensionName>
    //    2    4:areturn         
    }

    public void renameAttribute(int att, String name)
    {
        Attribute newAtt = attribute(att).copy(name);
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:invokevirtual   #154 <Method Attribute attribute(int)>
    //    3    5:aload_2         
    //    4    6:invokevirtual   #430 <Method Attribute Attribute.copy(String)>
    //    5    9:astore_3        
        FastVector newVec = new FastVector(numAttributes());
    //    6   10:new             #83  <Class FastVector>
    //    7   13:dup             
    //    8   14:aload_0         
    //    9   15:invokevirtual   #160 <Method int numAttributes()>
    //   10   18:invokespecial   #86  <Method void FastVector(int)>
    //   11   21:astore          4
        for(int i = 0; i < numAttributes(); i++)
    //*  12   23:iconst_0        
    //*  13   24:istore          5
    //*  14   26:goto            58
            if(i == att)
    //*  15   29:iload           5
    //*  16   31:iload_1         
    //*  17   32:icmpne          44
                newVec.addElement(newAtt);
    //   18   35:aload           4
    //   19   37:aload_3         
    //   20   38:invokevirtual   #179 <Method void FastVector.addElement(Object)>
            else
    //*  21   41:goto            55
                newVec.addElement(attribute(i));
    //   22   44:aload           4
    //   23   46:aload_0         
    //   24   47:iload           5
    //   25   49:invokevirtual   #154 <Method Attribute attribute(int)>
    //   26   52:invokevirtual   #179 <Method void FastVector.addElement(Object)>

    //   27   55:iinc            5  1
    //   28   58:iload           5
    //   29   60:aload_0         
    //   30   61:invokevirtual   #160 <Method int numAttributes()>
    //   31   64:icmplt          29
        m_Attributes = newVec;
    //   32   67:aload_0         
    //   33   68:aload           4
    //   34   70:putfield        #81  <Field FastVector m_Attributes>
    //   35   73:return          
    }

    public void renameAttribute(Attribute att, String name)
    {
        renameAttribute(att.index(), name);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokevirtual   #186 <Method int Attribute.index()>
    //    3    5:aload_2         
    //    4    6:invokevirtual   #435 <Method void renameAttribute(int, String)>
    //    5    9:return          
    }

    public void renameAttributeValue(int att, int val, String name)
    {
        Attribute newAtt = (Attribute)attribute(att).copy();
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:invokevirtual   #154 <Method Attribute attribute(int)>
    //    3    5:invokevirtual   #337 <Method Object Attribute.copy()>
    //    4    8:checkcast       #112 <Class Attribute>
    //    5   11:astore          4
        FastVector newVec = new FastVector(numAttributes());
    //    6   13:new             #83  <Class FastVector>
    //    7   16:dup             
    //    8   17:aload_0         
    //    9   18:invokevirtual   #160 <Method int numAttributes()>
    //   10   21:invokespecial   #86  <Method void FastVector(int)>
    //   11   24:astore          5
        newAtt.setValue(val, name);
    //   12   26:aload           4
    //   13   28:iload_2         
    //   14   29:aload_3         
    //   15   30:invokevirtual   #440 <Method void Attribute.setValue(int, String)>
        for(int i = 0; i < numAttributes(); i++)
    //*  16   33:iconst_0        
    //*  17   34:istore          6
    //*  18   36:goto            69
            if(i == att)
    //*  19   39:iload           6
    //*  20   41:iload_1         
    //*  21   42:icmpne          55
                newVec.addElement(newAtt);
    //   22   45:aload           5
    //   23   47:aload           4
    //   24   49:invokevirtual   #179 <Method void FastVector.addElement(Object)>
            else
    //*  25   52:goto            66
                newVec.addElement(attribute(i));
    //   26   55:aload           5
    //   27   57:aload_0         
    //   28   58:iload           6
    //   29   60:invokevirtual   #154 <Method Attribute attribute(int)>
    //   30   63:invokevirtual   #179 <Method void FastVector.addElement(Object)>

    //   31   66:iinc            6  1
    //   32   69:iload           6
    //   33   71:aload_0         
    //   34   72:invokevirtual   #160 <Method int numAttributes()>
    //   35   75:icmplt          39
        m_Attributes = newVec;
    //   36   78:aload_0         
    //   37   79:aload           5
    //   38   81:putfield        #81  <Field FastVector m_Attributes>
    //   39   84:return          
    }

    public void renameAttributeValue(Attribute att, String val, String name)
    {
        int v = att.indexOfValue(val);
    //    0    0:aload_1         
    //    1    1:aload_2         
    //    2    2:invokevirtual   #446 <Method int Attribute.indexOfValue(String)>
    //    3    5:istore          4
        if(v == -1)
    //*   4    7:iload           4
    //*   5    9:iconst_m1       
    //*   6   10:icmpne          41
        {
            throw new IllegalArgumentException((new StringBuilder(String.valueOf(val))).append(" not found").toString());
    //    7   13:new             #91  <Class IllegalArgumentException>
    //    8   16:dup             
    //    9   17:new             #122 <Class StringBuilder>
    //   10   20:dup             
    //   11   21:aload_2         
    //   12   22:invokestatic    #450 <Method String String.valueOf(Object)>
    //   13   25:invokespecial   #125 <Method void StringBuilder(String)>
    //   14   28:ldc2            #452 <String " not found">
    //   15   31:invokevirtual   #129 <Method StringBuilder StringBuilder.append(String)>
    //   16   34:invokevirtual   #134 <Method String StringBuilder.toString()>
    //   17   37:invokespecial   #96  <Method void IllegalArgumentException(String)>
    //   18   40:athrow          
        } else
        {
            renameAttributeValue(att.index(), v, name);
    //   19   41:aload_0         
    //   20   42:aload_1         
    //   21   43:invokevirtual   #186 <Method int Attribute.index()>
    //   22   46:iload           4
    //   23   48:aload_3         
    //   24   49:invokevirtual   #454 <Method void renameAttributeValue(int, int, String)>
            return;
    //   25   52:return          
        }
    }

    public Instances resample(Random random)
    {
        Instances newData;
        for(newData = new Instances(this, numInstances()); newData.numInstances() < numInstances(); newData.add(instance(random.nextInt(numInstances()))));
    //    0    0:new             #2   <Class Instances>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:aload_0         
    //    4    6:invokevirtual   #51  <Method int numInstances()>
    //    5    9:invokespecial   #74  <Method void Instances(Instances, int)>
    //    6   12:astore_2        
    //    7   13:goto            32
    //    8   16:aload_2         
    //    9   17:aload_0         
    //   10   18:aload_1         
    //   11   19:aload_0         
    //   12   20:invokevirtual   #51  <Method int numInstances()>
    //   13   23:invokevirtual   #321 <Method int Random.nextInt(int)>
    //   14   26:invokevirtual   #275 <Method Instance instance(int)>
    //   15   29:invokevirtual   #424 <Method void add(Instance)>
    //   16   32:aload_2         
    //   17   33:invokevirtual   #51  <Method int numInstances()>
    //   18   36:aload_0         
    //   19   37:invokevirtual   #51  <Method int numInstances()>
    //   20   40:icmplt          16
        return newData;
    //   21   43:aload_2         
    //   22   44:areturn         
    }

    public Instances resampleWithWeights(Random random)
    {
        double weights[] = new double[numInstances()];
    //    0    0:aload_0         
    //    1    1:invokevirtual   #51  <Method int numInstances()>
    //    2    4:newarray        double[]
    //    3    6:astore_2        
        for(int i = 0; i < weights.length; i++)
    //*   4    7:iconst_0        
    //*   5    8:istore_3        
    //*   6    9:goto            26
            weights[i] = instance(i).weight();
    //    7   12:aload_2         
    //    8   13:iload_3         
    //    9   14:aload_0         
    //   10   15:iload_3         
    //   11   16:invokevirtual   #275 <Method Instance instance(int)>
    //   12   19:invokevirtual   #374 <Method double Instance.weight()>
    //   13   22:dastore         

    //   14   23:iinc            3  1
    //   15   26:iload_3         
    //   16   27:aload_2         
    //   17   28:arraylength     
    //   18   29:icmplt          12
        return resampleWithWeights(random, weights);
    //   19   32:aload_0         
    //   20   33:aload_1         
    //   21   34:aload_2         
    //   22   35:invokevirtual   #462 <Method Instances resampleWithWeights(Random, double[])>
    //   23   38:areturn         
    }

    public Instances resampleWithWeights(Random random, double weights[])
    {
        if(weights.length != numInstances())
    //*   0    0:aload_2         
    //*   1    1:arraylength     
    //*   2    2:aload_0         
    //*   3    3:invokevirtual   #51  <Method int numInstances()>
    //*   4    6:icmpeq          20
            throw new IllegalArgumentException("weights.length != numInstances.");
    //    5    9:new             #91  <Class IllegalArgumentException>
    //    6   12:dup             
    //    7   13:ldc2            #465 <String "weights.length != numInstances.">
    //    8   16:invokespecial   #96  <Method void IllegalArgumentException(String)>
    //    9   19:athrow          
        Instances newData = new Instances(this, numInstances());
    //   10   20:new             #2   <Class Instances>
    //   11   23:dup             
    //   12   24:aload_0         
    //   13   25:aload_0         
    //   14   26:invokevirtual   #51  <Method int numInstances()>
    //   15   29:invokespecial   #74  <Method void Instances(Instances, int)>
    //   16   32:astore_3        
        if(numInstances() == 0)
    //*  17   33:aload_0         
    //*  18   34:invokevirtual   #51  <Method int numInstances()>
    //*  19   37:ifne            42
            return newData;
    //   20   40:aload_3         
    //   21   41:areturn         
        double probabilities[] = new double[numInstances()];
    //   22   42:aload_0         
    //   23   43:invokevirtual   #51  <Method int numInstances()>
    //   24   46:newarray        double[]
    //   25   48:astore          4
        double sumProbs = 0.0D;
    //   26   50:dconst_0        
    //   27   51:dstore          5
        double sumOfWeights = Utils.sum(weights);
    //   28   53:aload_2         
    //   29   54:invokestatic    #469 <Method double Utils.sum(double[])>
    //   30   57:dstore          7
        for(int i = 0; i < numInstances(); i++)
    //*  31   59:iconst_0        
    //*  32   60:istore          9
    //*  33   62:goto            84
        {
            sumProbs += random.nextDouble();
    //   34   65:dload           5
    //   35   67:aload_1         
    //   36   68:invokevirtual   #472 <Method double Random.nextDouble()>
    //   37   71:dadd            
    //   38   72:dstore          5
            probabilities[i] = sumProbs;
    //   39   74:aload           4
    //   40   76:iload           9
    //   41   78:dload           5
    //   42   80:dastore         
        }

    //   43   81:iinc            9  1
    //   44   84:iload           9
    //   45   86:aload_0         
    //   46   87:invokevirtual   #51  <Method int numInstances()>
    //   47   90:icmplt          65
        Utils.normalize(probabilities, sumProbs / sumOfWeights);
    //   48   93:aload           4
    //   49   95:dload           5
    //   50   97:dload           7
    //   51   99:ddiv            
    //   52  100:invokestatic    #476 <Method void Utils.normalize(double[], double)>
        probabilities[numInstances() - 1] = sumOfWeights;
    //   53  103:aload           4
    //   54  105:aload_0         
    //   55  106:invokevirtual   #51  <Method int numInstances()>
    //   56  109:iconst_1        
    //   57  110:isub            
    //   58  111:dload           7
    //   59  113:dastore         
        int k = 0;
    //   60  114:iconst_0        
    //   61  115:istore          9
        int l = 0;
    //   62  117:iconst_0        
    //   63  118:istore          10
        sumProbs = 0.0D;
    //   64  120:dconst_0        
    //   65  121:dstore          5
    //*  66  123:goto            204
        for(; k < numInstances() && l < numInstances(); l++)
        {
            if(weights[l] < 0.0D)
    //*  67  126:aload_2         
    //*  68  127:iload           10
    //*  69  129:daload          
    //*  70  130:dconst_0        
    //*  71  131:dcmpg           
    //*  72  132:ifge            146
                throw new IllegalArgumentException("Weights have to be positive.");
    //   73  135:new             #91  <Class IllegalArgumentException>
    //   74  138:dup             
    //   75  139:ldc2            #478 <String "Weights have to be positive.">
    //   76  142:invokespecial   #96  <Method void IllegalArgumentException(String)>
    //   77  145:athrow          
            for(sumProbs += weights[l]; k < numInstances() && probabilities[k] <= sumProbs; k++)
    //*  78  146:dload           5
    //*  79  148:aload_2         
    //*  80  149:iload           10
    //*  81  151:daload          
    //*  82  152:dadd            
    //*  83  153:dstore          5
    //*  84  155:goto            181
            {
                newData.add(instance(l));
    //   85  158:aload_3         
    //   86  159:aload_0         
    //   87  160:iload           10
    //   88  162:invokevirtual   #275 <Method Instance instance(int)>
    //   89  165:invokevirtual   #424 <Method void add(Instance)>
                newData.instance(k).setWeight(1.0D);
    //   90  168:aload_3         
    //   91  169:iload           9
    //   92  171:invokevirtual   #275 <Method Instance instance(int)>
    //   93  174:dconst_1        
    //   94  175:invokevirtual   #482 <Method void Instance.setWeight(double)>
            }

    //   95  178:iinc            9  1
    //   96  181:iload           9
    //   97  183:aload_0         
    //   98  184:invokevirtual   #51  <Method int numInstances()>
    //   99  187:icmpge          201
    //  100  190:aload           4
    //  101  192:iload           9
    //  102  194:daload          
    //  103  195:dload           5
    //  104  197:dcmpg           
    //  105  198:ifle            158
        }

    //  106  201:iinc            10  1
    //  107  204:iload           9
    //  108  206:aload_0         
    //  109  207:invokevirtual   #51  <Method int numInstances()>
    //  110  210:icmpge          222
    //  111  213:iload           10
    //  112  215:aload_0         
    //  113  216:invokevirtual   #51  <Method int numInstances()>
    //  114  219:icmplt          126
        return newData;
    //  115  222:aload_3         
    //  116  223:areturn         
    }

    public void setClass(Attribute att)
    {
        m_ClassIndex = att.index();
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokevirtual   #186 <Method int Attribute.index()>
    //    3    5:putfield        #77  <Field int m_ClassIndex>
    //    4    8:return          
    }

    public void setClassIndex(int classIndex)
    {
        if(classIndex >= numAttributes())
    //*   0    0:iload_1         
    //*   1    1:aload_0         
    //*   2    2:invokevirtual   #160 <Method int numAttributes()>
    //*   3    5:icmplt          33
        {
            throw new IllegalArgumentException((new StringBuilder("Invalid class index: ")).append(classIndex).toString());
    //    4    8:new             #91  <Class IllegalArgumentException>
    //    5   11:dup             
    //    6   12:new             #122 <Class StringBuilder>
    //    7   15:dup             
    //    8   16:ldc2            #490 <String "Invalid class index: ">
    //    9   19:invokespecial   #125 <Method void StringBuilder(String)>
    //   10   22:iload_1         
    //   11   23:invokevirtual   #493 <Method StringBuilder StringBuilder.append(int)>
    //   12   26:invokevirtual   #134 <Method String StringBuilder.toString()>
    //   13   29:invokespecial   #96  <Method void IllegalArgumentException(String)>
    //   14   32:athrow          
        } else
        {
            m_ClassIndex = classIndex;
    //   15   33:aload_0         
    //   16   34:iload_1         
    //   17   35:putfield        #77  <Field int m_ClassIndex>
            return;
    //   18   38:return          
        }
    }

    public void setRelationName(String newName)
    {
        m_DimensionName = newName;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #79  <Field String m_DimensionName>
    //    3    5:return          
    }

    public void sort(int attIndex)
    {
        int j = numInstances() - 1;
    //    0    0:aload_0         
    //    1    1:invokevirtual   #51  <Method int numInstances()>
    //    2    4:iconst_1        
    //    3    5:isub            
    //    4    6:istore_3        
        for(int i = 0; i <= j;)
    //*   5    7:iconst_0        
    //*   6    8:istore_2        
    //*   7    9:goto            54
            if(instance(j).isMissing(attIndex))
    //*   8   12:aload_0         
    //*   9   13:iload_3         
    //*  10   14:invokevirtual   #275 <Method Instance instance(int)>
    //*  11   17:iload_1         
    //*  12   18:invokevirtual   #224 <Method boolean Instance.isMissing(int)>
    //*  13   21:ifeq            30
            {
                j--;
    //   14   24:iinc            3  -1
            } else
    //*  15   27:goto            54
            {
                if(instance(i).isMissing(attIndex))
    //*  16   30:aload_0         
    //*  17   31:iload_2         
    //*  18   32:invokevirtual   #275 <Method Instance instance(int)>
    //*  19   35:iload_1         
    //*  20   36:invokevirtual   #224 <Method boolean Instance.isMissing(int)>
    //*  21   39:ifeq            51
                {
                    swap(i, j);
    //   22   42:aload_0         
    //   23   43:iload_2         
    //   24   44:iload_3         
    //   25   45:invokevirtual   #358 <Method void swap(int, int)>
                    j--;
    //   26   48:iinc            3  -1
                }
                i++;
    //   27   51:iinc            2  1
            }

    //   28   54:iload_2         
    //   29   55:iload_3         
    //   30   56:icmple          12
        quickSort(attIndex, 0, j);
    //   31   59:aload_0         
    //   32   60:iload_1         
    //   33   61:iconst_0        
    //   34   62:iload_3         
    //   35   63:invokevirtual   #499 <Method void quickSort(int, int, int)>
    //   36   66:return          
    }

    public void sort(Attribute att)
    {
        sort(att.index());
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokevirtual   #186 <Method int Attribute.index()>
    //    3    5:invokevirtual   #501 <Method void sort(int)>
    //    4    8:return          
    }

    public void stratify(int numFolds)
    {
        if(numFolds <= 1)
    //*   0    0:iload_1         
    //*   1    1:iconst_1        
    //*   2    2:icmpgt          16
            throw new IllegalArgumentException("Number of folds must be greater than 1");
    //    3    5:new             #91  <Class IllegalArgumentException>
    //    4    8:dup             
    //    5    9:ldc2            #504 <String "Number of folds must be greater than 1">
    //    6   12:invokespecial   #96  <Method void IllegalArgumentException(String)>
    //    7   15:athrow          
        if(m_ClassIndex < 0)
    //*   8   16:aload_0         
    //*   9   17:getfield        #77  <Field int m_ClassIndex>
    //*  10   20:ifge            33
            throw new UnassignedClassException("Class index is negative (not set)!");
    //   11   23:new             #253 <Class UnassignedClassException>
    //   12   26:dup             
    //   13   27:ldc1            #255 <String "Class index is negative (not set)!">
    //   14   29:invokespecial   #256 <Method void UnassignedClassException(String)>
    //   15   32:athrow          
        if(classAttribute().isNominal())
    //*  16   33:aload_0         
    //*  17   34:invokevirtual   #388 <Method Attribute classAttribute()>
    //*  18   37:invokevirtual   #227 <Method boolean Attribute.isNominal()>
    //*  19   40:ifeq            136
        {
            for(int index = 1; index < numInstances(); index++)
    //*  20   43:iconst_1        
    //*  21   44:istore_2        
    //*  22   45:goto            123
            {
                Instance instance1 = instance(index - 1);
    //   23   48:aload_0         
    //   24   49:iload_2         
    //   25   50:iconst_1        
    //   26   51:isub            
    //   27   52:invokevirtual   #275 <Method Instance instance(int)>
    //   28   55:astore_3        
                for(int j = index; j < numInstances(); j++)
    //*  29   56:iload_2         
    //*  30   57:istore          4
    //*  31   59:goto            111
                {
                    Instance instance2 = instance(j);
    //   32   62:aload_0         
    //   33   63:iload           4
    //   34   65:invokevirtual   #275 <Method Instance instance(int)>
    //   35   68:astore          5
                    if(instance1.classValue() == instance2.classValue() || instance1.classIsMissing() && instance2.classIsMissing())
    //*  36   70:aload_3         
    //*  37   71:invokevirtual   #507 <Method double Instance.classValue()>
    //*  38   74:aload           5
    //*  39   76:invokevirtual   #507 <Method double Instance.classValue()>
    //*  40   79:dcmpl           
    //*  41   80:ifeq            98
    //*  42   83:aload_3         
    //*  43   84:invokevirtual   #510 <Method boolean Instance.classIsMissing()>
    //*  44   87:ifeq            108
    //*  45   90:aload           5
    //*  46   92:invokevirtual   #510 <Method boolean Instance.classIsMissing()>
    //*  47   95:ifeq            108
                    {
                        swap(index, j);
    //   48   98:aload_0         
    //   49   99:iload_2         
    //   50  100:iload           4
    //   51  102:invokevirtual   #358 <Method void swap(int, int)>
                        index++;
    //   52  105:iinc            2  1
                    }
                }

    //   53  108:iinc            4  1
    //   54  111:iload           4
    //   55  113:aload_0         
    //   56  114:invokevirtual   #51  <Method int numInstances()>
    //   57  117:icmplt          62
            }

    //   58  120:iinc            2  1
    //   59  123:iload_2         
    //   60  124:aload_0         
    //   61  125:invokevirtual   #51  <Method int numInstances()>
    //   62  128:icmplt          48
            stratStep(numFolds);
    //   63  131:aload_0         
    //   64  132:iload_1         
    //   65  133:invokevirtual   #513 <Method void stratStep(int)>
        }
    //   66  136:return          
    }

    public double sumOfWeights()
    {
        double sum = 0.0D;
    //    0    0:dconst_0        
    //    1    1:dstore_1        
        for(int i = 0; i < numInstances(); i++)
    //*   2    2:iconst_0        
    //*   3    3:istore_3        
    //*   4    4:goto            21
            sum += instance(i).weight();
    //    5    7:dload_1         
    //    6    8:aload_0         
    //    7    9:iload_3         
    //    8   10:invokevirtual   #275 <Method Instance instance(int)>
    //    9   13:invokevirtual   #374 <Method double Instance.weight()>
    //   10   16:dadd            
    //   11   17:dstore_1        

    //   12   18:iinc            3  1
    //   13   21:iload_3         
    //   14   22:aload_0         
    //   15   23:invokevirtual   #51  <Method int numInstances()>
    //   16   26:icmplt          7
        return sum;
    //   17   29:dload_1         
    //   18   30:dreturn         
    }

    public Instances testCV(int numFolds, int numFold)
    {
        if(numFolds < 2)
    //*   0    0:iload_1         
    //*   1    1:iconst_2        
    //*   2    2:icmpge          16
            throw new IllegalArgumentException("Number of folds must be at least 2!");
    //    3    5:new             #91  <Class IllegalArgumentException>
    //    4    8:dup             
    //    5    9:ldc2            #520 <String "Number of folds must be at least 2!">
    //    6   12:invokespecial   #96  <Method void IllegalArgumentException(String)>
    //    7   15:athrow          
        if(numFolds > numInstances())
    //*   8   16:iload_1         
    //*   9   17:aload_0         
    //*  10   18:invokevirtual   #51  <Method int numInstances()>
    //*  11   21:icmple          35
            throw new IllegalArgumentException("Can't have more folds than instances!");
    //   12   24:new             #91  <Class IllegalArgumentException>
    //   13   27:dup             
    //   14   28:ldc2            #522 <String "Can't have more folds than instances!">
    //   15   31:invokespecial   #96  <Method void IllegalArgumentException(String)>
    //   16   34:athrow          
        int numInstForFold = numInstances() / numFolds;
    //   17   35:aload_0         
    //   18   36:invokevirtual   #51  <Method int numInstances()>
    //   19   39:iload_1         
    //   20   40:idiv            
    //   21   41:istore_3        
        int offset;
        if(numFold < numInstances() % numFolds)
    //*  22   42:iload_2         
    //*  23   43:aload_0         
    //*  24   44:invokevirtual   #51  <Method int numInstances()>
    //*  25   47:iload_1         
    //*  26   48:irem            
    //*  27   49:icmpge          61
        {
            numInstForFold++;
    //   28   52:iinc            3  1
            offset = numFold;
    //   29   55:iload_2         
    //   30   56:istore          5
        } else
    //*  31   58:goto            69
        {
            offset = numInstances() % numFolds;
    //   32   61:aload_0         
    //   33   62:invokevirtual   #51  <Method int numInstances()>
    //   34   65:iload_1         
    //   35   66:irem            
    //   36   67:istore          5
        }
        Instances test = new Instances(this, numInstForFold);
    //   37   69:new             #2   <Class Instances>
    //   38   72:dup             
    //   39   73:aload_0         
    //   40   74:iload_3         
    //   41   75:invokespecial   #74  <Method void Instances(Instances, int)>
    //   42   78:astore          6
        int first = numFold * (numInstances() / numFolds) + offset;
    //   43   80:iload_2         
    //   44   81:aload_0         
    //   45   82:invokevirtual   #51  <Method int numInstances()>
    //   46   85:iload_1         
    //   47   86:idiv            
    //   48   87:imul            
    //   49   88:iload           5
    //   50   90:iadd            
    //   51   91:istore          4
        copyInstances(first, test, numInstForFold);
    //   52   93:aload_0         
    //   53   94:iload           4
    //   54   96:aload           6
    //   55   98:iload_3         
    //   56   99:invokevirtual   #59  <Method void copyInstances(int, Instances, int)>
        return test;
    //   57  102:aload           6
    //   58  104:areturn         
    }

    public String toString()
    {
        StringBuffer text = new StringBuffer();
    //    0    0:new             #105 <Class StringBuffer>
    //    1    3:dup             
    //    2    4:invokespecial   #106 <Method void StringBuffer()>
    //    3    7:astore_1        
        text.append("@atributesof").append(" ").append(Utils.quote(m_DimensionName)).append("\n");
    //    4    8:aload_1         
    //    5    9:ldc1            #17  <String "@atributesof">
    //    6   11:invokevirtual   #137 <Method StringBuffer StringBuffer.append(String)>
    //    7   14:ldc2            #528 <String " ">
    //    8   17:invokevirtual   #137 <Method StringBuffer StringBuffer.append(String)>
    //    9   20:aload_0         
    //   10   21:getfield        #79  <Field String m_DimensionName>
    //   11   24:invokestatic    #532 <Method String Utils.quote(String)>
    //   12   27:invokevirtual   #137 <Method StringBuffer StringBuffer.append(String)>
    //   13   30:ldc2            #534 <String "\n">
    //   14   33:invokevirtual   #137 <Method StringBuffer StringBuffer.append(String)>
    //   15   36:pop             
        for(int i = 0; i < numAttributes(); i++)
    //*  16   37:iconst_0        
    //*  17   38:istore_2        
    //*  18   39:goto            61
            text.append(attribute(i)).append("\n");
    //   19   42:aload_1         
    //   20   43:aload_0         
    //   21   44:iload_2         
    //   22   45:invokevirtual   #154 <Method Attribute attribute(int)>
    //   23   48:invokevirtual   #537 <Method StringBuffer StringBuffer.append(Object)>
    //   24   51:ldc2            #534 <String "\n">
    //   25   54:invokevirtual   #137 <Method StringBuffer StringBuffer.append(String)>
    //   26   57:pop             

    //   27   58:iinc            2  1
    //   28   61:iload_2         
    //   29   62:aload_0         
    //   30   63:invokevirtual   #160 <Method int numAttributes()>
    //   31   66:icmplt          42
        text.append("\n").append("@data").append("\n");
    //   32   69:aload_1         
    //   33   70:ldc2            #534 <String "\n">
    //   34   73:invokevirtual   #137 <Method StringBuffer StringBuffer.append(String)>
    //   35   76:ldc1            #20  <String "@data">
    //   36   78:invokevirtual   #137 <Method StringBuffer StringBuffer.append(String)>
    //   37   81:ldc2            #534 <String "\n">
    //   38   84:invokevirtual   #137 <Method StringBuffer StringBuffer.append(String)>
    //   39   87:pop             
        text.append(stringWithoutHeader());
    //   40   88:aload_1         
    //   41   89:aload_0         
    //   42   90:invokevirtual   #540 <Method String stringWithoutHeader()>
    //   43   93:invokevirtual   #137 <Method StringBuffer StringBuffer.append(String)>
    //   44   96:pop             
        return text.toString();
    //   45   97:aload_1         
    //   46   98:invokevirtual   #147 <Method String StringBuffer.toString()>
    //   47  101:areturn         
    }

    protected String stringWithoutHeader()
    {
        StringBuffer text = new StringBuffer();
    //    0    0:new             #105 <Class StringBuffer>
    //    1    3:dup             
    //    2    4:invokespecial   #106 <Method void StringBuffer()>
    //    3    7:astore_1        
        for(int i = 0; i < numInstances(); i++)
    //*   4    8:iconst_0        
    //*   5    9:istore_2        
    //*   6   10:goto            43
        {
            text.append(instance(i));
    //    7   13:aload_1         
    //    8   14:aload_0         
    //    9   15:iload_2         
    //   10   16:invokevirtual   #275 <Method Instance instance(int)>
    //   11   19:invokevirtual   #537 <Method StringBuffer StringBuffer.append(Object)>
    //   12   22:pop             
            if(i < numInstances() - 1)
    //*  13   23:iload_2         
    //*  14   24:aload_0         
    //*  15   25:invokevirtual   #51  <Method int numInstances()>
    //*  16   28:iconst_1        
    //*  17   29:isub            
    //*  18   30:icmpge          40
                text.append('\n');
    //   19   33:aload_1         
    //   20   34:bipush          10
    //   21   36:invokevirtual   #544 <Method StringBuffer StringBuffer.append(char)>
    //   22   39:pop             
        }

    //   23   40:iinc            2  1
    //   24   43:iload_2         
    //   25   44:aload_0         
    //   26   45:invokevirtual   #51  <Method int numInstances()>
    //   27   48:icmplt          13
        return text.toString();
    //   28   51:aload_1         
    //   29   52:invokevirtual   #147 <Method String StringBuffer.toString()>
    //   30   55:areturn         
    }

    public Instances trainCV(int numFolds, int numFold)
    {
        if(numFolds < 2)
    //*   0    0:iload_1         
    //*   1    1:iconst_2        
    //*   2    2:icmpge          16
            throw new IllegalArgumentException("Number of folds must be at least 2!");
    //    3    5:new             #91  <Class IllegalArgumentException>
    //    4    8:dup             
    //    5    9:ldc2            #520 <String "Number of folds must be at least 2!">
    //    6   12:invokespecial   #96  <Method void IllegalArgumentException(String)>
    //    7   15:athrow          
        if(numFolds > numInstances())
    //*   8   16:iload_1         
    //*   9   17:aload_0         
    //*  10   18:invokevirtual   #51  <Method int numInstances()>
    //*  11   21:icmple          35
            throw new IllegalArgumentException("Can't have more folds than instances!");
    //   12   24:new             #91  <Class IllegalArgumentException>
    //   13   27:dup             
    //   14   28:ldc2            #522 <String "Can't have more folds than instances!">
    //   15   31:invokespecial   #96  <Method void IllegalArgumentException(String)>
    //   16   34:athrow          
        int numInstForFold = numInstances() / numFolds;
    //   17   35:aload_0         
    //   18   36:invokevirtual   #51  <Method int numInstances()>
    //   19   39:iload_1         
    //   20   40:idiv            
    //   21   41:istore_3        
        int offset;
        if(numFold < numInstances() % numFolds)
    //*  22   42:iload_2         
    //*  23   43:aload_0         
    //*  24   44:invokevirtual   #51  <Method int numInstances()>
    //*  25   47:iload_1         
    //*  26   48:irem            
    //*  27   49:icmpge          61
        {
            numInstForFold++;
    //   28   52:iinc            3  1
            offset = numFold;
    //   29   55:iload_2         
    //   30   56:istore          5
        } else
    //*  31   58:goto            69
        {
            offset = numInstances() % numFolds;
    //   32   61:aload_0         
    //   33   62:invokevirtual   #51  <Method int numInstances()>
    //   34   65:iload_1         
    //   35   66:irem            
    //   36   67:istore          5
        }
        Instances train = new Instances(this, numInstances() - numInstForFold);
    //   37   69:new             #2   <Class Instances>
    //   38   72:dup             
    //   39   73:aload_0         
    //   40   74:aload_0         
    //   41   75:invokevirtual   #51  <Method int numInstances()>
    //   42   78:iload_3         
    //   43   79:isub            
    //   44   80:invokespecial   #74  <Method void Instances(Instances, int)>
    //   45   83:astore          6
        int first = numFold * (numInstances() / numFolds) + offset;
    //   46   85:iload_2         
    //   47   86:aload_0         
    //   48   87:invokevirtual   #51  <Method int numInstances()>
    //   49   90:iload_1         
    //   50   91:idiv            
    //   51   92:imul            
    //   52   93:iload           5
    //   53   95:iadd            
    //   54   96:istore          4
        copyInstances(0, train, first);
    //   55   98:aload_0         
    //   56   99:iconst_0        
    //   57  100:aload           6
    //   58  102:iload           4
    //   59  104:invokevirtual   #59  <Method void copyInstances(int, Instances, int)>
        copyInstances(first + numInstForFold, train, numInstances() - first - numInstForFold);
    //   60  107:aload_0         
    //   61  108:iload           4
    //   62  110:iload_3         
    //   63  111:iadd            
    //   64  112:aload           6
    //   65  114:aload_0         
    //   66  115:invokevirtual   #51  <Method int numInstances()>
    //   67  118:iload           4
    //   68  120:isub            
    //   69  121:iload_3         
    //   70  122:isub            
    //   71  123:invokevirtual   #59  <Method void copyInstances(int, Instances, int)>
        return train;
    //   72  126:aload           6
    //   73  128:areturn         
    }

    public Instances trainCV(int numFolds, int numFold, Random random)
    {
        Instances train = trainCV(numFolds, numFold);
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:iload_2         
    //    3    3:invokevirtual   #549 <Method Instances trainCV(int, int)>
    //    4    6:astore          4
        train.randomize(random);
    //    5    8:aload           4
    //    6   10:aload_3         
    //    7   11:invokevirtual   #551 <Method void randomize(Random)>
        return train;
    //    8   14:aload           4
    //    9   16:areturn         
    }

    public double variance(int attIndex)
    {
        double sum = 0.0D;
    //    0    0:dconst_0        
    //    1    1:dstore_2        
        double sumSquared = 0.0D;
    //    2    2:dconst_0        
    //    3    3:dstore          4
        double sumOfWeights = 0.0D;
    //    4    5:dconst_0        
    //    5    6:dstore          6
        if(!attribute(attIndex).isNumeric())
    //*   6    8:aload_0         
    //*   7    9:iload_1         
    //*   8   10:invokevirtual   #154 <Method Attribute attribute(int)>
    //*   9   13:invokevirtual   #352 <Method boolean Attribute.isNumeric()>
    //*  10   16:ifne            30
            throw new IllegalArgumentException("Can't compute variance because attribute is not numeric!");
    //   11   19:new             #91  <Class IllegalArgumentException>
    //   12   22:dup             
    //   13   23:ldc2            #554 <String "Can't compute variance because attribute is not numeric!">
    //   14   26:invokespecial   #96  <Method void IllegalArgumentException(String)>
    //   15   29:athrow          
        for(int i = 0; i < numInstances(); i++)
    //*  16   30:iconst_0        
    //*  17   31:istore          8
    //*  18   33:goto            125
            if(!instance(i).isMissing(attIndex))
    //*  19   36:aload_0         
    //*  20   37:iload           8
    //*  21   39:invokevirtual   #275 <Method Instance instance(int)>
    //*  22   42:iload_1         
    //*  23   43:invokevirtual   #224 <Method boolean Instance.isMissing(int)>
    //*  24   46:ifne            122
            {
                sum += instance(i).weight() * instance(i).value(attIndex);
    //   25   49:dload_2         
    //   26   50:aload_0         
    //   27   51:iload           8
    //   28   53:invokevirtual   #275 <Method Instance instance(int)>
    //   29   56:invokevirtual   #374 <Method double Instance.weight()>
    //   30   59:aload_0         
    //   31   60:iload           8
    //   32   62:invokevirtual   #275 <Method Instance instance(int)>
    //   33   65:iload_1         
    //   34   66:invokevirtual   #234 <Method double Instance.value(int)>
    //   35   69:dmul            
    //   36   70:dadd            
    //   37   71:dstore_2        
                sumSquared += instance(i).weight() * instance(i).value(attIndex) * instance(i).value(attIndex);
    //   38   72:dload           4
    //   39   74:aload_0         
    //   40   75:iload           8
    //   41   77:invokevirtual   #275 <Method Instance instance(int)>
    //   42   80:invokevirtual   #374 <Method double Instance.weight()>
    //   43   83:aload_0         
    //   44   84:iload           8
    //   45   86:invokevirtual   #275 <Method Instance instance(int)>
    //   46   89:iload_1         
    //   47   90:invokevirtual   #234 <Method double Instance.value(int)>
    //   48   93:dmul            
    //   49   94:aload_0         
    //   50   95:iload           8
    //   51   97:invokevirtual   #275 <Method Instance instance(int)>
    //   52  100:iload_1         
    //   53  101:invokevirtual   #234 <Method double Instance.value(int)>
    //   54  104:dmul            
    //   55  105:dadd            
    //   56  106:dstore          4
                sumOfWeights += instance(i).weight();
    //   57  108:dload           6
    //   58  110:aload_0         
    //   59  111:iload           8
    //   60  113:invokevirtual   #275 <Method Instance instance(int)>
    //   61  116:invokevirtual   #374 <Method double Instance.weight()>
    //   62  119:dadd            
    //   63  120:dstore          6
            }

    //   64  122:iinc            8  1
    //   65  125:iload           8
    //   66  127:aload_0         
    //   67  128:invokevirtual   #51  <Method int numInstances()>
    //   68  131:icmplt          36
        if(sumOfWeights <= 1.0D)
    //*  69  134:dload           6
    //*  70  136:dconst_1        
    //*  71  137:dcmpg           
    //*  72  138:ifgt            143
            return 0.0D;
    //   73  141:dconst_0        
    //   74  142:dreturn         
        double result = (sumSquared - (sum * sum) / sumOfWeights) / (sumOfWeights - 1.0D);
    //   75  143:dload           4
    //   76  145:dload_2         
    //   77  146:dload_2         
    //   78  147:dmul            
    //   79  148:dload           6
    //   80  150:ddiv            
    //   81  151:dsub            
    //   82  152:dload           6
    //   83  154:dconst_1        
    //   84  155:dsub            
    //   85  156:ddiv            
    //   86  157:dstore          8
        if(result < 0.0D)
    //*  87  159:dload           8
    //*  88  161:dconst_0        
    //*  89  162:dcmpg           
    //*  90  163:ifge            168
            return 0.0D;
    //   91  166:dconst_0        
    //   92  167:dreturn         
        else
            return result;
    //   93  168:dload           8
    //   94  170:dreturn         
    }

    public double variance(Attribute att)
    {
        return variance(att.index());
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokevirtual   #186 <Method int Attribute.index()>
    //    3    5:invokevirtual   #557 <Method double variance(int)>
    //    4    8:dreturn         
    }

    public double[] attributeToDoubleArray(int index)
    {
        double result[] = new double[numInstances()];
    //    0    0:aload_0         
    //    1    1:invokevirtual   #51  <Method int numInstances()>
    //    2    4:newarray        double[]
    //    3    6:astore_2        
        for(int i = 0; i < result.length; i++)
    //*   4    7:iconst_0        
    //*   5    8:istore_3        
    //*   6    9:goto            27
            result[i] = instance(i).value(index);
    //    7   12:aload_2         
    //    8   13:iload_3         
    //    9   14:aload_0         
    //   10   15:iload_3         
    //   11   16:invokevirtual   #275 <Method Instance instance(int)>
    //   12   19:iload_1         
    //   13   20:invokevirtual   #234 <Method double Instance.value(int)>
    //   14   23:dastore         

    //   15   24:iinc            3  1
    //   16   27:iload_3         
    //   17   28:aload_2         
    //   18   29:arraylength     
    //   19   30:icmplt          12
        return result;
    //   20   33:aload_2         
    //   21   34:areturn         
    }

    protected void copyInstances(int from, Instances dest, int num)
    {
        for(int i = 0; i < num; i++)
    //*   0    0:iconst_0        
    //*   1    1:istore          4
    //*   2    3:goto            21
            dest.add(instance(from + i));
    //    3    6:aload_2         
    //    4    7:aload_0         
    //    5    8:iload_1         
    //    6    9:iload           4
    //    7   11:iadd            
    //    8   12:invokevirtual   #275 <Method Instance instance(int)>
    //    9   15:invokevirtual   #424 <Method void add(Instance)>

    //   10   18:iinc            4  1
    //   11   21:iload           4
    //   12   23:iload_3         
    //   13   24:icmplt          6
    //   14   27:return          
    }

    protected void freshAttributeInfo()
    {
        m_Attributes = (FastVector)m_Attributes.copyElements();
    //    0    0:aload_0         
    //    1    1:aload_0         
    //    2    2:getfield        #81  <Field FastVector m_Attributes>
    //    3    5:invokevirtual   #563 <Method Object FastVector.copyElements()>
    //    4    8:checkcast       #83  <Class FastVector>
    //    5   11:putfield        #81  <Field FastVector m_Attributes>
    //    6   14:return          
    }

    protected String instancesAndWeights()
    {
        StringBuffer text = new StringBuffer();
    //    0    0:new             #105 <Class StringBuffer>
    //    1    3:dup             
    //    2    4:invokespecial   #106 <Method void StringBuffer()>
    //    3    7:astore_1        
        for(int i = 0; i < numInstances(); i++)
    //*   4    8:iconst_0        
    //*   5    9:istore_2        
    //*   6   10:goto            74
        {
            text.append((new StringBuilder()).append(instance(i)).append(" ").append(instance(i).weight()).toString());
    //    7   13:aload_1         
    //    8   14:new             #122 <Class StringBuilder>
    //    9   17:dup             
    //   10   18:invokespecial   #565 <Method void StringBuilder()>
    //   11   21:aload_0         
    //   12   22:iload_2         
    //   13   23:invokevirtual   #275 <Method Instance instance(int)>
    //   14   26:invokevirtual   #568 <Method StringBuilder StringBuilder.append(Object)>
    //   15   29:ldc2            #528 <String " ">
    //   16   32:invokevirtual   #129 <Method StringBuilder StringBuilder.append(String)>
    //   17   35:aload_0         
    //   18   36:iload_2         
    //   19   37:invokevirtual   #275 <Method Instance instance(int)>
    //   20   40:invokevirtual   #374 <Method double Instance.weight()>
    //   21   43:invokevirtual   #571 <Method StringBuilder StringBuilder.append(double)>
    //   22   46:invokevirtual   #134 <Method String StringBuilder.toString()>
    //   23   49:invokevirtual   #137 <Method StringBuffer StringBuffer.append(String)>
    //   24   52:pop             
            if(i < numInstances() - 1)
    //*  25   53:iload_2         
    //*  26   54:aload_0         
    //*  27   55:invokevirtual   #51  <Method int numInstances()>
    //*  28   58:iconst_1        
    //*  29   59:isub            
    //*  30   60:icmpge          71
                text.append("\n");
    //   31   63:aload_1         
    //   32   64:ldc2            #534 <String "\n">
    //   33   67:invokevirtual   #137 <Method StringBuffer StringBuffer.append(String)>
    //   34   70:pop             
        }

    //   35   71:iinc            2  1
    //   36   74:iload_2         
    //   37   75:aload_0         
    //   38   76:invokevirtual   #51  <Method int numInstances()>
    //   39   79:icmplt          13
        return text.toString();
    //   40   82:aload_1         
    //   41   83:invokevirtual   #147 <Method String StringBuffer.toString()>
    //   42   86:areturn         
    }

    protected int partition(int attIndex, int l, int r)
    {
        double pivot = instance((l + r) / 2).value(attIndex);
    //    0    0:aload_0         
    //    1    1:iload_2         
    //    2    2:iload_3         
    //    3    3:iadd            
    //    4    4:iconst_2        
    //    5    5:idiv            
    //    6    6:invokevirtual   #275 <Method Instance instance(int)>
    //    7    9:iload_1         
    //    8   10:invokevirtual   #234 <Method double Instance.value(int)>
    //    9   13:dstore          4
    //*  10   15:goto            87
    //*  11   18:goto            24
        while(l < r) 
        {
            while(instance(l).value(attIndex) < pivot && l < r) 
                l++;
    //   12   21:iinc            2  1
    //   13   24:aload_0         
    //   14   25:iload_2         
    //   15   26:invokevirtual   #275 <Method Instance instance(int)>
    //   16   29:iload_1         
    //   17   30:invokevirtual   #234 <Method double Instance.value(int)>
    //   18   33:dload           4
    //   19   35:dcmpg           
    //   20   36:ifge            50
    //   21   39:iload_2         
    //   22   40:iload_3         
    //   23   41:icmplt          21
    //*  24   44:goto            50
            for(; instance(r).value(attIndex) > pivot && l < r; r--);
    //   25   47:iinc            3  -1
    //   26   50:aload_0         
    //   27   51:iload_3         
    //   28   52:invokevirtual   #275 <Method Instance instance(int)>
    //   29   55:iload_1         
    //   30   56:invokevirtual   #234 <Method double Instance.value(int)>
    //   31   59:dload           4
    //   32   61:dcmpl           
    //   33   62:ifle            70
    //   34   65:iload_2         
    //   35   66:iload_3         
    //   36   67:icmplt          47
            if(l < r)
    //*  37   70:iload_2         
    //*  38   71:iload_3         
    //*  39   72:icmpge          87
            {
                swap(l, r);
    //   40   75:aload_0         
    //   41   76:iload_2         
    //   42   77:iload_3         
    //   43   78:invokevirtual   #358 <Method void swap(int, int)>
                l++;
    //   44   81:iinc            2  1
                r--;
    //   45   84:iinc            3  -1
            }
        }
    //   46   87:iload_2         
    //   47   88:iload_3         
    //   48   89:icmplt          18
        if(l == r && instance(r).value(attIndex) > pivot)
    //*  49   92:iload_2         
    //*  50   93:iload_3         
    //*  51   94:icmpne          115
    //*  52   97:aload_0         
    //*  53   98:iload_3         
    //*  54   99:invokevirtual   #275 <Method Instance instance(int)>
    //*  55  102:iload_1         
    //*  56  103:invokevirtual   #234 <Method double Instance.value(int)>
    //*  57  106:dload           4
    //*  58  108:dcmpl           
    //*  59  109:ifle            115
            r--;
    //   60  112:iinc            3  -1
        return r;
    //   61  115:iload_3         
    //   62  116:ireturn         
    }

    protected void quickSort(int attIndex, int left, int right)
    {
        if(left < right)
    //*   0    0:iload_2         
    //*   1    1:iload_3         
    //*   2    2:icmpge          32
        {
            int middle = partition(attIndex, left, right);
    //    3    5:aload_0         
    //    4    6:iload_1         
    //    5    7:iload_2         
    //    6    8:iload_3         
    //    7    9:invokevirtual   #576 <Method int partition(int, int, int)>
    //    8   12:istore          4
            quickSort(attIndex, left, middle);
    //    9   14:aload_0         
    //   10   15:iload_1         
    //   11   16:iload_2         
    //   12   17:iload           4
    //   13   19:invokevirtual   #499 <Method void quickSort(int, int, int)>
            quickSort(attIndex, middle + 1, right);
    //   14   22:aload_0         
    //   15   23:iload_1         
    //   16   24:iload           4
    //   17   26:iconst_1        
    //   18   27:iadd            
    //   19   28:iload_3         
    //   20   29:invokevirtual   #499 <Method void quickSort(int, int, int)>
        }
    //   21   32:return          
    }

    protected int select(int attIndex, int left, int right, int k)
    {
        if(left == right)
    //*   0    0:iload_2         
    //*   1    1:iload_3         
    //*   2    2:icmpne          7
            return left;
    //    3    5:iload_2         
    //    4    6:ireturn         
        int middle = partition(attIndex, left, right);
    //    5    7:aload_0         
    //    6    8:iload_1         
    //    7    9:iload_2         
    //    8   10:iload_3         
    //    9   11:invokevirtual   #576 <Method int partition(int, int, int)>
    //   10   14:istore          5
        if((middle - left) + 1 >= k)
    //*  11   16:iload           5
    //*  12   18:iload_2         
    //*  13   19:isub            
    //*  14   20:iconst_1        
    //*  15   21:iadd            
    //*  16   22:iload           4
    //*  17   24:icmplt          38
            return select(attIndex, left, middle, k);
    //   18   27:aload_0         
    //   19   28:iload_1         
    //   20   29:iload_2         
    //   21   30:iload           5
    //   22   32:iload           4
    //   23   34:invokevirtual   #364 <Method int select(int, int, int, int)>
    //   24   37:ireturn         
        else
            return select(attIndex, middle + 1, right, k - ((middle - left) + 1));
    //   25   38:aload_0         
    //   26   39:iload_1         
    //   27   40:iload           5
    //   28   42:iconst_1        
    //   29   43:iadd            
    //   30   44:iload_3         
    //   31   45:iload           4
    //   32   47:iload           5
    //   33   49:iload_2         
    //   34   50:isub            
    //   35   51:iconst_1        
    //   36   52:iadd            
    //   37   53:isub            
    //   38   54:invokevirtual   #364 <Method int select(int, int, int, int)>
    //   39   57:ireturn         
    }

    protected void stratStep(int numFolds)
    {
        FastVector newVec = new FastVector(m_Instances.capacity());
    //    0    0:new             #83  <Class FastVector>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:getfield        #88  <Field FastVector m_Instances>
    //    4    8:invokevirtual   #581 <Method int FastVector.capacity()>
    //    5   11:invokespecial   #86  <Method void FastVector(int)>
    //    6   14:astore_2        
        for(int start = 0; newVec.size() < numInstances(); start++)
    //*   7   15:iconst_0        
    //*   8   16:istore_3        
    //*   9   17:goto            54
        {
            for(int j = start; j < numInstances(); j += numFolds)
    //*  10   20:iload_3         
    //*  11   21:istore          4
    //*  12   23:goto            42
                newVec.addElement(instance(j));
    //   13   26:aload_2         
    //   14   27:aload_0         
    //   15   28:iload           4
    //   16   30:invokevirtual   #275 <Method Instance instance(int)>
    //   17   33:invokevirtual   #179 <Method void FastVector.addElement(Object)>

    //   18   36:iload           4
    //   19   38:iload_1         
    //   20   39:iadd            
    //   21   40:istore          4
    //   22   42:iload           4
    //   23   44:aload_0         
    //   24   45:invokevirtual   #51  <Method int numInstances()>
    //   25   48:icmplt          26
        }

    //   26   51:iinc            3  1
    //   27   54:aload_2         
    //   28   55:invokevirtual   #143 <Method int FastVector.size()>
    //   29   58:aload_0         
    //   30   59:invokevirtual   #51  <Method int numInstances()>
    //   31   62:icmplt          20
        m_Instances = newVec;
    //   32   65:aload_0         
    //   33   66:aload_2         
    //   34   67:putfield        #88  <Field FastVector m_Instances>
    //   35   70:return          
    }

    public void swap(int i, int j)
    {
        m_Instances.swap(i, j);
    //    0    0:aload_0         
    //    1    1:getfield        #88  <Field FastVector m_Instances>
    //    2    4:iload_1         
    //    3    5:iload_2         
    //    4    6:invokevirtual   #583 <Method void FastVector.swap(int, int)>
    //    5    9:return          
    }

    public static Instances mergeInstances(Instances first, Instances second)
    {
        if(first.numInstances() != second.numInstances())
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #51  <Method int numInstances()>
    //*   2    4:aload_1         
    //*   3    5:invokevirtual   #51  <Method int numInstances()>
    //*   4    8:icmpeq          22
            throw new IllegalArgumentException("Instance sets must be of the same size");
    //    5   11:new             #91  <Class IllegalArgumentException>
    //    6   14:dup             
    //    7   15:ldc2            #587 <String "Instance sets must be of the same size">
    //    8   18:invokespecial   #96  <Method void IllegalArgumentException(String)>
    //    9   21:athrow          
        FastVector newAttributes = new FastVector();
    //   10   22:new             #83  <Class FastVector>
    //   11   25:dup             
    //   12   26:invokespecial   #170 <Method void FastVector()>
    //   13   29:astore_2        
        for(int i = 0; i < first.numAttributes(); i++)
    //*  14   30:iconst_0        
    //*  15   31:istore_3        
    //*  16   32:goto            47
            newAttributes.addElement(first.attribute(i));
    //   17   35:aload_2         
    //   18   36:aload_0         
    //   19   37:iload_3         
    //   20   38:invokevirtual   #154 <Method Attribute attribute(int)>
    //   21   41:invokevirtual   #179 <Method void FastVector.addElement(Object)>

    //   22   44:iinc            3  1
    //   23   47:iload_3         
    //   24   48:aload_0         
    //   25   49:invokevirtual   #160 <Method int numAttributes()>
    //   26   52:icmplt          35
        for(int i = 0; i < second.numAttributes(); i++)
    //*  27   55:iconst_0        
    //*  28   56:istore_3        
    //*  29   57:goto            72
            newAttributes.addElement(second.attribute(i));
    //   30   60:aload_2         
    //   31   61:aload_1         
    //   32   62:iload_3         
    //   33   63:invokevirtual   #154 <Method Attribute attribute(int)>
    //   34   66:invokevirtual   #179 <Method void FastVector.addElement(Object)>

    //   35   69:iinc            3  1
    //   36   72:iload_3         
    //   37   73:aload_1         
    //   38   74:invokevirtual   #160 <Method int numAttributes()>
    //   39   77:icmplt          60
        Instances merged = new Instances((new StringBuilder(String.valueOf(first.relationName()))).append('_').append(second.relationName()).toString(), newAttributes, first.numInstances());
    //   40   80:new             #2   <Class Instances>
    //   41   83:dup             
    //   42   84:new             #122 <Class StringBuilder>
    //   43   87:dup             
    //   44   88:aload_0         
    //   45   89:invokevirtual   #589 <Method String relationName()>
    //   46   92:invokestatic    #450 <Method String String.valueOf(Object)>
    //   47   95:invokespecial   #125 <Method void StringBuilder(String)>
    //   48   98:bipush          95
    //   49  100:invokevirtual   #592 <Method StringBuilder StringBuilder.append(char)>
    //   50  103:aload_1         
    //   51  104:invokevirtual   #589 <Method String relationName()>
    //   52  107:invokevirtual   #129 <Method StringBuilder StringBuilder.append(String)>
    //   53  110:invokevirtual   #134 <Method String StringBuilder.toString()>
    //   54  113:aload_2         
    //   55  114:aload_0         
    //   56  115:invokevirtual   #51  <Method int numInstances()>
    //   57  118:invokespecial   #593 <Method void Instances(String, FastVector, int)>
    //   58  121:astore_3        
        for(int i = 0; i < first.numInstances(); i++)
    //*  59  122:iconst_0        
    //*  60  123:istore          4
    //*  61  125:goto            150
            merged.add(first.instance(i).mergeInstance(second.instance(i)));
    //   62  128:aload_3         
    //   63  129:aload_0         
    //   64  130:iload           4
    //   65  132:invokevirtual   #275 <Method Instance instance(int)>
    //   66  135:aload_1         
    //   67  136:iload           4
    //   68  138:invokevirtual   #275 <Method Instance instance(int)>
    //   69  141:invokevirtual   #597 <Method Instance Instance.mergeInstance(Instance)>
    //   70  144:invokevirtual   #424 <Method void add(Instance)>

    //   71  147:iinc            4  1
    //   72  150:iload           4
    //   73  152:aload_0         
    //   74  153:invokevirtual   #51  <Method int numInstances()>
    //   75  156:icmplt          128
        return merged;
    //   76  159:aload_3         
    //   77  160:areturn         
    }

    public AttributeStats attributeStats(int index)
    {
        AttributeStats result = new AttributeStats();
    //    0    0:new             #604 <Class AttributeStats>
    //    1    3:dup             
    //    2    4:invokespecial   #605 <Method void AttributeStats()>
    //    3    7:astore_2        
        if(attribute(index).isNominal())
    //*   4    8:aload_0         
    //*   5    9:iload_1         
    //*   6   10:invokevirtual   #154 <Method Attribute attribute(int)>
    //*   7   13:invokevirtual   #227 <Method boolean Attribute.isNominal()>
    //*   8   16:ifeq            33
            result.nominalCounts = new int[attribute(index).numValues()];
    //    9   19:aload_2         
    //   10   20:aload_0         
    //   11   21:iload_1         
    //   12   22:invokevirtual   #154 <Method Attribute attribute(int)>
    //   13   25:invokevirtual   #246 <Method int Attribute.numValues()>
    //   14   28:newarray        int[]
    //   15   30:putfield        #608 <Field int[] AttributeStats.nominalCounts>
        if(attribute(index).isNumeric())
    //*  16   33:aload_0         
    //*  17   34:iload_1         
    //*  18   35:invokevirtual   #154 <Method Attribute attribute(int)>
    //*  19   38:invokevirtual   #352 <Method boolean Attribute.isNumeric()>
    //*  20   41:ifeq            55
            result.numericStats = new Stats();
    //   21   44:aload_2         
    //   22   45:new             #610 <Class Stats>
    //   23   48:dup             
    //   24   49:invokespecial   #611 <Method void Stats()>
    //   25   52:putfield        #615 <Field Stats AttributeStats.numericStats>
        result.totalCount = numInstances();
    //   26   55:aload_2         
    //   27   56:aload_0         
    //   28   57:invokevirtual   #51  <Method int numInstances()>
    //   29   60:putfield        #618 <Field int AttributeStats.totalCount>
        double attVals[] = attributeToDoubleArray(index);
    //   30   63:aload_0         
    //   31   64:iload_1         
    //   32   65:invokevirtual   #393 <Method double[] attributeToDoubleArray(int)>
    //   33   68:astore_3        
        int sorted[] = Utils.sort(attVals);
    //   34   69:aload_3         
    //   35   70:invokestatic    #397 <Method int[] Utils.sort(double[])>
    //   36   73:astore          4
        int currentCount = 0;
    //   37   75:iconst_0        
    //   38   76:istore          5
        double prev = Instance.missingValue();
    //   39   78:invokestatic    #621 <Method double Instance.missingValue()>
    //   40   81:dstore          6
        for(int j = 0; j < numInstances(); j++)
    //*  41   83:iconst_0        
    //*  42   84:istore          8
    //*  43   86:goto            163
        {
            Instance current = instance(sorted[j]);
    //   44   89:aload_0         
    //   45   90:aload           4
    //   46   92:iload           8
    //   47   94:iaload          
    //   48   95:invokevirtual   #275 <Method Instance instance(int)>
    //   49   98:astore          9
            if(current.isMissing(index))
    //*  50  100:aload           9
    //*  51  102:iload_1         
    //*  52  103:invokevirtual   #224 <Method boolean Instance.isMissing(int)>
    //*  53  106:ifeq            123
            {
                result.missingCount = numInstances() - j;
    //   54  109:aload_2         
    //   55  110:aload_0         
    //   56  111:invokevirtual   #51  <Method int numInstances()>
    //   57  114:iload           8
    //   58  116:isub            
    //   59  117:putfield        #624 <Field int AttributeStats.missingCount>
                break;
    //   60  120:goto            172
            }
            if(current.value(index) == prev)
    //*  61  123:aload           9
    //*  62  125:iload_1         
    //*  63  126:invokevirtual   #234 <Method double Instance.value(int)>
    //*  64  129:dload           6
    //*  65  131:dcmpl           
    //*  66  132:ifne            141
            {
                currentCount++;
    //   67  135:iinc            5  1
            } else
    //*  68  138:goto            160
            {
                result.addDistinct(prev, currentCount);
    //   69  141:aload_2         
    //   70  142:dload           6
    //   71  144:iload           5
    //   72  146:invokevirtual   #628 <Method void AttributeStats.addDistinct(double, int)>
                currentCount = 1;
    //   73  149:iconst_1        
    //   74  150:istore          5
                prev = current.value(index);
    //   75  152:aload           9
    //   76  154:iload_1         
    //   77  155:invokevirtual   #234 <Method double Instance.value(int)>
    //   78  158:dstore          6
            }
        }

    //   79  160:iinc            8  1
    //   80  163:iload           8
    //   81  165:aload_0         
    //   82  166:invokevirtual   #51  <Method int numInstances()>
    //   83  169:icmplt          89
        result.addDistinct(prev, currentCount);
    //   84  172:aload_2         
    //   85  173:dload           6
    //   86  175:iload           5
    //   87  177:invokevirtual   #628 <Method void AttributeStats.addDistinct(double, int)>
        result.distinctCount--;
    //   88  180:aload_2         
    //   89  181:dup             
    //   90  182:getfield        #631 <Field int AttributeStats.distinctCount>
    //   91  185:iconst_1        
    //   92  186:isub            
    //   93  187:putfield        #631 <Field int AttributeStats.distinctCount>
        return result;
    //   94  190:aload_2         
    //   95  191:areturn         
    }

    public static final String FILE_EXTENSION = ".ass";
    public static final String SERIALIZED_OBJ_FILE_EXTENSION = ".bsi";
    public static final String ASS_ADDITION = "@atributesof";
    public static final String ASS_DATA = "@data";
    protected String m_DimensionName;
    protected FastVector m_LatitudeEnum;
    protected FastVector m_Attributes;
    protected FastVector m_Instances;
    protected int m_ClassIndex;
    protected int m_Lines;
}
