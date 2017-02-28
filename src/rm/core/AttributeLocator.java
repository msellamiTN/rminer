// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   AttributeLocator.java

package rm.core;

import java.io.Serializable;
import java.util.Vector;

// Referenced classes of package rm.core:
//            Instances, Attribute

public class AttributeLocator
    implements Serializable, Comparable
{

    public AttributeLocator(Instances data, int type)
    {
        this(data, type, 0, data.numAttributes() - 1);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:iload_2         
    //    3    3:iconst_0        
    //    4    4:aload_1         
    //    5    5:invokevirtual   #28  <Method int Instances.numAttributes()>
    //    6    8:iconst_1        
    //    7    9:isub            
    //    8   10:invokespecial   #31  <Method void AttributeLocator(Instances, int, int, int)>
    //    9   13:return          
    }

    public AttributeLocator(Instances data, int type, int fromIndex, int toIndex)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #40  <Method void Object()>
        m_AllowedIndices = null;
    //    2    4:aload_0         
    //    3    5:aconst_null     
    //    4    6:putfield        #42  <Field int[] m_AllowedIndices>
        m_Attributes = null;
    //    5    9:aload_0         
    //    6   10:aconst_null     
    //    7   11:putfield        #44  <Field Vector m_Attributes>
        m_Locators = null;
    //    8   14:aload_0         
    //    9   15:aconst_null     
    //   10   16:putfield        #46  <Field Vector m_Locators>
        m_Type = -1;
    //   11   19:aload_0         
    //   12   20:iconst_m1       
    //   13   21:putfield        #48  <Field int m_Type>
        m_Data = null;
    //   14   24:aload_0         
    //   15   25:aconst_null     
    //   16   26:putfield        #50  <Field Instances m_Data>
        m_Indices = null;
    //   17   29:aload_0         
    //   18   30:aconst_null     
    //   19   31:putfield        #52  <Field int[] m_Indices>
        m_LocatorIndices = null;
    //   20   34:aload_0         
    //   21   35:aconst_null     
    //   22   36:putfield        #54  <Field int[] m_LocatorIndices>
        int indices[] = new int[(toIndex - fromIndex) + 1];
    //   23   39:iload           4
    //   24   41:iload_3         
    //   25   42:isub            
    //   26   43:iconst_1        
    //   27   44:iadd            
    //   28   45:newarray        int[]
    //   29   47:astore          5
        for(int i = 0; i < indices.length; i++)
    //*  30   49:iconst_0        
    //*  31   50:istore          6
    //*  32   52:goto            67
            indices[i] = fromIndex + i;
    //   33   55:aload           5
    //   34   57:iload           6
    //   35   59:iload_3         
    //   36   60:iload           6
    //   37   62:iadd            
    //   38   63:iastore         

    //   39   64:iinc            6  1
    //   40   67:iload           6
    //   41   69:aload           5
    //   42   71:arraylength     
    //   43   72:icmplt          55
        initialize(data, type, indices);
    //   44   75:aload_0         
    //   45   76:aload_1         
    //   46   77:iload_2         
    //   47   78:aload           5
    //   48   80:invokevirtual   #58  <Method void initialize(Instances, int, int[])>
    //   49   83:return          
    }

    public AttributeLocator(Instances data, int type, int indices[])
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #40  <Method void Object()>
        m_AllowedIndices = null;
    //    2    4:aload_0         
    //    3    5:aconst_null     
    //    4    6:putfield        #42  <Field int[] m_AllowedIndices>
        m_Attributes = null;
    //    5    9:aload_0         
    //    6   10:aconst_null     
    //    7   11:putfield        #44  <Field Vector m_Attributes>
        m_Locators = null;
    //    8   14:aload_0         
    //    9   15:aconst_null     
    //   10   16:putfield        #46  <Field Vector m_Locators>
        m_Type = -1;
    //   11   19:aload_0         
    //   12   20:iconst_m1       
    //   13   21:putfield        #48  <Field int m_Type>
        m_Data = null;
    //   14   24:aload_0         
    //   15   25:aconst_null     
    //   16   26:putfield        #50  <Field Instances m_Data>
        m_Indices = null;
    //   17   29:aload_0         
    //   18   30:aconst_null     
    //   19   31:putfield        #52  <Field int[] m_Indices>
        m_LocatorIndices = null;
    //   20   34:aload_0         
    //   21   35:aconst_null     
    //   22   36:putfield        #54  <Field int[] m_LocatorIndices>
        initialize(data, type, indices);
    //   23   39:aload_0         
    //   24   40:aload_1         
    //   25   41:iload_2         
    //   26   42:aload_3         
    //   27   43:invokevirtual   #58  <Method void initialize(Instances, int, int[])>
    //   28   46:return          
    }

    protected void initialize(Instances data, int type, int indices[])
    {
        m_Data = new Instances(data, 0);
    //    0    0:aload_0         
    //    1    1:new             #24  <Class Instances>
    //    2    4:dup             
    //    3    5:aload_1         
    //    4    6:iconst_0        
    //    5    7:invokespecial   #64  <Method void Instances(Instances, int)>
    //    6   10:putfield        #50  <Field Instances m_Data>
        m_Type = type;
    //    7   13:aload_0         
    //    8   14:iload_2         
    //    9   15:putfield        #48  <Field int m_Type>
        m_AllowedIndices = new int[indices.length];
    //   10   18:aload_0         
    //   11   19:aload_3         
    //   12   20:arraylength     
    //   13   21:newarray        int[]
    //   14   23:putfield        #42  <Field int[] m_AllowedIndices>
        System.arraycopy(indices, 0, m_AllowedIndices, 0, indices.length);
    //   15   26:aload_3         
    //   16   27:iconst_0        
    //   17   28:aload_0         
    //   18   29:getfield        #42  <Field int[] m_AllowedIndices>
    //   19   32:iconst_0        
    //   20   33:aload_3         
    //   21   34:arraylength     
    //   22   35:invokestatic    #70  <Method void System.arraycopy(Object, int, Object, int, int)>
        locate();
    //   23   38:aload_0         
    //   24   39:invokevirtual   #73  <Method void locate()>
        m_Indices = find(true);
    //   25   42:aload_0         
    //   26   43:aload_0         
    //   27   44:iconst_1        
    //   28   45:invokevirtual   #77  <Method int[] find(boolean)>
    //   29   48:putfield        #52  <Field int[] m_Indices>
        m_LocatorIndices = find(false);
    //   30   51:aload_0         
    //   31   52:aload_0         
    //   32   53:iconst_0        
    //   33   54:invokevirtual   #77  <Method int[] find(boolean)>
    //   34   57:putfield        #54  <Field int[] m_LocatorIndices>
    //   35   60:return          
    }

    public int getType()
    {
        return m_Type;
    //    0    0:aload_0         
    //    1    1:getfield        #48  <Field int m_Type>
    //    2    4:ireturn         
    }

    public int[] getAllowedIndices()
    {
        return m_AllowedIndices;
    //    0    0:aload_0         
    //    1    1:getfield        #42  <Field int[] m_AllowedIndices>
    //    2    4:areturn         
    }

    protected void locate()
    {
        m_Attributes = new Vector();
    //    0    0:aload_0         
    //    1    1:new             #82  <Class Vector>
    //    2    4:dup             
    //    3    5:invokespecial   #83  <Method void Vector()>
    //    4    8:putfield        #44  <Field Vector m_Attributes>
        m_Locators = new Vector();
    //    5   11:aload_0         
    //    6   12:new             #82  <Class Vector>
    //    7   15:dup             
    //    8   16:invokespecial   #83  <Method void Vector()>
    //    9   19:putfield        #46  <Field Vector m_Locators>
        for(int i = 0; i < m_AllowedIndices.length; i++)
    //*  10   22:iconst_0        
    //*  11   23:istore_1        
    //*  12   24:goto            97
        {
            m_Locators.add(null);
    //   13   27:aload_0         
    //   14   28:getfield        #46  <Field Vector m_Locators>
    //   15   31:aconst_null     
    //   16   32:invokevirtual   #87  <Method boolean Vector.add(Object)>
    //   17   35:pop             
            if(m_Data.attribute(m_AllowedIndices[i]).type() == getType())
    //*  18   36:aload_0         
    //*  19   37:getfield        #50  <Field Instances m_Data>
    //*  20   40:aload_0         
    //*  21   41:getfield        #42  <Field int[] m_AllowedIndices>
    //*  22   44:iload_1         
    //*  23   45:iaload          
    //*  24   46:invokevirtual   #91  <Method Attribute Instances.attribute(int)>
    //*  25   49:invokevirtual   #95  <Method int Attribute.type()>
    //*  26   52:aload_0         
    //*  27   53:invokevirtual   #97  <Method int getType()>
    //*  28   56:icmpne          78
                m_Attributes.add(new Boolean(true));
    //   29   59:aload_0         
    //   30   60:getfield        #44  <Field Vector m_Attributes>
    //   31   63:new             #99  <Class Boolean>
    //   32   66:dup             
    //   33   67:iconst_1        
    //   34   68:invokespecial   #102 <Method void Boolean(boolean)>
    //   35   71:invokevirtual   #87  <Method boolean Vector.add(Object)>
    //   36   74:pop             
            else
    //*  37   75:goto            94
                m_Attributes.add(new Boolean(false));
    //   38   78:aload_0         
    //   39   79:getfield        #44  <Field Vector m_Attributes>
    //   40   82:new             #99  <Class Boolean>
    //   41   85:dup             
    //   42   86:iconst_0        
    //   43   87:invokespecial   #102 <Method void Boolean(boolean)>
    //   44   90:invokevirtual   #87  <Method boolean Vector.add(Object)>
    //   45   93:pop             
        }

    //   46   94:iinc            1  1
    //   47   97:iload_1         
    //   48   98:aload_0         
    //   49   99:getfield        #42  <Field int[] m_AllowedIndices>
    //   50  102:arraylength     
    //   51  103:icmplt          27
    //   52  106:return          
    }

    public Instances getData()
    {
        return m_Data;
    //    0    0:aload_0         
    //    1    1:getfield        #50  <Field Instances m_Data>
    //    2    4:areturn         
    }

    protected int[] find(boolean findAtts)
    {
        Vector indices = new Vector();
    //    0    0:new             #82  <Class Vector>
    //    1    3:dup             
    //    2    4:invokespecial   #83  <Method void Vector()>
    //    3    7:astore          4
        if(findAtts)
    //*   4    9:iload_1         
    //*   5   10:ifeq            69
        {
            for(int i = 0; i < m_Attributes.size(); i++)
    //*   6   13:iconst_0        
    //*   7   14:istore_2        
    //*   8   15:goto            55
                if(((Boolean)(Boolean)m_Attributes.get(i)).booleanValue())
    //*   9   18:aload_0         
    //*  10   19:getfield        #44  <Field Vector m_Attributes>
    //*  11   22:iload_2         
    //*  12   23:invokevirtual   #108 <Method Object Vector.get(int)>
    //*  13   26:checkcast       #99  <Class Boolean>
    //*  14   29:checkcast       #99  <Class Boolean>
    //*  15   32:invokevirtual   #112 <Method boolean Boolean.booleanValue()>
    //*  16   35:ifeq            52
                    indices.add(new Integer(i));
    //   17   38:aload           4
    //   18   40:new             #114 <Class Integer>
    //   19   43:dup             
    //   20   44:iload_2         
    //   21   45:invokespecial   #117 <Method void Integer(int)>
    //   22   48:invokevirtual   #87  <Method boolean Vector.add(Object)>
    //   23   51:pop             

    //   24   52:iinc            2  1
    //   25   55:iload_2         
    //   26   56:aload_0         
    //   27   57:getfield        #44  <Field Vector m_Attributes>
    //   28   60:invokevirtual   #120 <Method int Vector.size()>
    //   29   63:icmplt          18
        } else
    //*  30   66:goto            113
        {
            for(int i = 0; i < m_Locators.size(); i++)
    //*  31   69:iconst_0        
    //*  32   70:istore_2        
    //*  33   71:goto            102
                if(m_Locators.get(i) != null)
    //*  34   74:aload_0         
    //*  35   75:getfield        #46  <Field Vector m_Locators>
    //*  36   78:iload_2         
    //*  37   79:invokevirtual   #108 <Method Object Vector.get(int)>
    //*  38   82:ifnull          99
                    indices.add(new Integer(i));
    //   39   85:aload           4
    //   40   87:new             #114 <Class Integer>
    //   41   90:dup             
    //   42   91:iload_2         
    //   43   92:invokespecial   #117 <Method void Integer(int)>
    //   44   95:invokevirtual   #87  <Method boolean Vector.add(Object)>
    //   45   98:pop             

    //   46   99:iinc            2  1
    //   47  102:iload_2         
    //   48  103:aload_0         
    //   49  104:getfield        #46  <Field Vector m_Locators>
    //   50  107:invokevirtual   #120 <Method int Vector.size()>
    //   51  110:icmplt          74
        }
        int result[] = new int[indices.size()];
    //   52  113:aload           4
    //   53  115:invokevirtual   #120 <Method int Vector.size()>
    //   54  118:newarray        int[]
    //   55  120:astore_3        
        for(int i = 0; i < indices.size(); i++)
    //*  56  121:iconst_0        
    //*  57  122:istore_2        
    //*  58  123:goto            147
            result[i] = ((Integer)(Integer)indices.get(i)).intValue();
    //   59  126:aload_3         
    //   60  127:iload_2         
    //   61  128:aload           4
    //   62  130:iload_2         
    //   63  131:invokevirtual   #108 <Method Object Vector.get(int)>
    //   64  134:checkcast       #114 <Class Integer>
    //   65  137:checkcast       #114 <Class Integer>
    //   66  140:invokevirtual   #123 <Method int Integer.intValue()>
    //   67  143:iastore         

    //   68  144:iinc            2  1
    //   69  147:iload_2         
    //   70  148:aload           4
    //   71  150:invokevirtual   #120 <Method int Vector.size()>
    //   72  153:icmplt          126
        return result;
    //   73  156:aload_3         
    //   74  157:areturn         
    }

    public int getActualIndex(int index)
    {
        return m_AllowedIndices[index];
    //    0    0:aload_0         
    //    1    1:getfield        #42  <Field int[] m_AllowedIndices>
    //    2    4:iload_1         
    //    3    5:iaload          
    //    4    6:ireturn         
    }

    public int[] getAttributeIndices()
    {
        return m_Indices;
    //    0    0:aload_0         
    //    1    1:getfield        #52  <Field int[] m_Indices>
    //    2    4:areturn         
    }

    public int[] getLocatorIndices()
    {
        return m_LocatorIndices;
    //    0    0:aload_0         
    //    1    1:getfield        #54  <Field int[] m_LocatorIndices>
    //    2    4:areturn         
    }

    public AttributeLocator getLocator(int index)
    {
        return (AttributeLocator)(AttributeLocator)m_Locators.get(index);
    //    0    0:aload_0         
    //    1    1:getfield        #46  <Field Vector m_Locators>
    //    2    4:iload_1         
    //    3    5:invokevirtual   #108 <Method Object Vector.get(int)>
    //    4    8:checkcast       #2   <Class AttributeLocator>
    //    5   11:checkcast       #2   <Class AttributeLocator>
    //    6   14:areturn         
    }

    public int compareTo(AttributeLocator o)
    {
        int result = 0;
    //    0    0:iconst_0        
    //    1    1:istore_2        
        if(getType() < o.getType())
    //*   2    2:aload_0         
    //*   3    3:invokevirtual   #97  <Method int getType()>
    //*   4    6:aload_1         
    //*   5    7:invokevirtual   #97  <Method int getType()>
    //*   6   10:icmpge          18
            result = -1;
    //    7   13:iconst_m1       
    //    8   14:istore_2        
        else
    //*   9   15:goto            129
        if(getType() > o.getType())
    //*  10   18:aload_0         
    //*  11   19:invokevirtual   #97  <Method int getType()>
    //*  12   22:aload_1         
    //*  13   23:invokevirtual   #97  <Method int getType()>
    //*  14   26:icmple          34
            result = 1;
    //   15   29:iconst_1        
    //   16   30:istore_2        
        else
    //*  17   31:goto            129
        if(getAllowedIndices().length < o.getAllowedIndices().length)
    //*  18   34:aload_0         
    //*  19   35:invokevirtual   #137 <Method int[] getAllowedIndices()>
    //*  20   38:arraylength     
    //*  21   39:aload_1         
    //*  22   40:invokevirtual   #137 <Method int[] getAllowedIndices()>
    //*  23   43:arraylength     
    //*  24   44:icmpge          52
            result = -1;
    //   25   47:iconst_m1       
    //   26   48:istore_2        
        else
    //*  27   49:goto            129
        if(getAllowedIndices().length > o.getAllowedIndices().length)
    //*  28   52:aload_0         
    //*  29   53:invokevirtual   #137 <Method int[] getAllowedIndices()>
    //*  30   56:arraylength     
    //*  31   57:aload_1         
    //*  32   58:invokevirtual   #137 <Method int[] getAllowedIndices()>
    //*  33   61:arraylength     
    //*  34   62:icmple          70
        {
            result = 1;
    //   35   65:iconst_1        
    //   36   66:istore_2        
        } else
    //*  37   67:goto            129
        {
            for(int i = 0; i < getAllowedIndices().length; i++)
    //*  38   70:iconst_0        
    //*  39   71:istore_3        
    //*  40   72:goto            120
            {
                if(getAllowedIndices()[i] < o.getAllowedIndices()[i])
    //*  41   75:aload_0         
    //*  42   76:invokevirtual   #137 <Method int[] getAllowedIndices()>
    //*  43   79:iload_3         
    //*  44   80:iaload          
    //*  45   81:aload_1         
    //*  46   82:invokevirtual   #137 <Method int[] getAllowedIndices()>
    //*  47   85:iload_3         
    //*  48   86:iaload          
    //*  49   87:icmpge          95
                {
                    result = -1;
    //   50   90:iconst_m1       
    //   51   91:istore_2        
                    break;
    //   52   92:goto            129
                }
                if(getAllowedIndices()[i] > o.getAllowedIndices()[i])
    //*  53   95:aload_0         
    //*  54   96:invokevirtual   #137 <Method int[] getAllowedIndices()>
    //*  55   99:iload_3         
    //*  56  100:iaload          
    //*  57  101:aload_1         
    //*  58  102:invokevirtual   #137 <Method int[] getAllowedIndices()>
    //*  59  105:iload_3         
    //*  60  106:iaload          
    //*  61  107:icmple          115
                {
                    result = 1;
    //   62  110:iconst_1        
    //   63  111:istore_2        
                    break;
    //   64  112:goto            129
                }
                result = 0;
    //   65  115:iconst_0        
    //   66  116:istore_2        
            }

    //   67  117:iinc            3  1
    //   68  120:iload_3         
    //   69  121:aload_0         
    //   70  122:invokevirtual   #137 <Method int[] getAllowedIndices()>
    //   71  125:arraylength     
    //   72  126:icmplt          75
        }
        return result;
    //   73  129:iload_2         
    //   74  130:ireturn         
    }

    public boolean equals(Object o)
    {
        return compareTo((AttributeLocator)o) == 0;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:checkcast       #2   <Class AttributeLocator>
    //    3    5:invokevirtual   #141 <Method int compareTo(AttributeLocator)>
    //    4    8:ifne            13
    //    5   11:iconst_1        
    //    6   12:ireturn         
    //    7   13:iconst_0        
    //    8   14:ireturn         
    }

    public String toString()
    {
        return m_Attributes.toString();
    //    0    0:aload_0         
    //    1    1:getfield        #44  <Field Vector m_Attributes>
    //    2    4:invokevirtual   #146 <Method String Vector.toString()>
    //    3    7:areturn         
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((AttributeLocator)obj);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:checkcast       #2   <Class AttributeLocator>
    //    3    5:invokevirtual   #141 <Method int compareTo(AttributeLocator)>
    //    4    8:ireturn         
    }

    protected int m_AllowedIndices[];
    protected Vector m_Attributes;
    protected Vector m_Locators;
    protected int m_Type;
    protected Instances m_Data;
    protected int m_Indices[];
    protected int m_LocatorIndices[];
}
