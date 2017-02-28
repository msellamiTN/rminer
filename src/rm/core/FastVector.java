// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   FastVector.java

package rm.core;

import java.io.Serializable;
import java.util.Enumeration;

public class FastVector
    implements Serializable
{
    public class FastVectorEnumeration
        implements Enumeration
    {

        public final boolean hasMoreElements()
        {
            return m_Counter < m_Vector.size();
        //    0    0:aload_0         
        //    1    1:getfield        #22  <Field int m_Counter>
        //    2    4:aload_0         
        //    3    5:getfield        #24  <Field FastVector m_Vector>
        //    4    8:invokevirtual   #41  <Method int FastVector.size()>
        //    5   11:icmpge          16
        //    6   14:iconst_1        
        //    7   15:ireturn         
        //    8   16:iconst_0        
        //    9   17:ireturn         
        }

        public final Object nextElement()
        {
            Object result = m_Vector.elementAt(m_Counter);
        //    0    0:aload_0         
        //    1    1:getfield        #24  <Field FastVector m_Vector>
        //    2    4:aload_0         
        //    3    5:getfield        #22  <Field int m_Counter>
        //    4    8:invokevirtual   #47  <Method Object FastVector.elementAt(int)>
        //    5   11:astore_1        
            m_Counter++;
        //    6   12:aload_0         
        //    7   13:dup             
        //    8   14:getfield        #22  <Field int m_Counter>
        //    9   17:iconst_1        
        //   10   18:iadd            
        //   11   19:putfield        #22  <Field int m_Counter>
            if(m_Counter == m_SpecialElement)
        //*  12   22:aload_0         
        //*  13   23:getfield        #22  <Field int m_Counter>
        //*  14   26:aload_0         
        //*  15   27:getfield        #26  <Field int m_SpecialElement>
        //*  16   30:icmpne          43
                m_Counter++;
        //   17   33:aload_0         
        //   18   34:dup             
        //   19   35:getfield        #22  <Field int m_Counter>
        //   20   38:iconst_1        
        //   21   39:iadd            
        //   22   40:putfield        #22  <Field int m_Counter>
            return result;
        //   23   43:aload_1         
        //   24   44:areturn         
        }

        private int m_Counter;
        private FastVector m_Vector;
        private int m_SpecialElement;
        final FastVector this$0;

        public FastVectorEnumeration(FastVector vector)
        {
            this$0 = FastVector.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #17  <Field FastVector this$0>
//            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #20  <Method void Object()>
            m_Counter = 0;
        //    5    9:aload_0         
        //    6   10:iconst_0        
        //    7   11:putfield        #22  <Field int m_Counter>
            m_Vector = vector;
        //    8   14:aload_0         
        //    9   15:aload_2         
        //   10   16:putfield        #24  <Field FastVector m_Vector>
            m_SpecialElement = -1;
        //   11   19:aload_0         
        //   12   20:iconst_m1       
        //   13   21:putfield        #26  <Field int m_SpecialElement>
        //   14   24:return          
        }

        public FastVectorEnumeration(FastVector vector, int special)
        {
            this$0 = FastVector.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #17  <Field FastVector this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #20  <Method void Object()>
            m_Vector = vector;
        //    5    9:aload_0         
        //    6   10:aload_2         
        //    7   11:putfield        #24  <Field FastVector m_Vector>
            m_SpecialElement = special;
        //    8   14:aload_0         
        //    9   15:iload_3         
        //   10   16:putfield        #26  <Field int m_SpecialElement>
            if(special == 0)
        //*  11   19:iload_3         
        //*  12   20:ifne            31
                m_Counter = 1;
        //   13   23:aload_0         
        //   14   24:iconst_1        
        //   15   25:putfield        #22  <Field int m_Counter>
            else
        //*  16   28:goto            36
                m_Counter = 0;
        //   17   31:aload_0         
        //   18   32:iconst_0        
        //   19   33:putfield        #22  <Field int m_Counter>
        //   20   36:return          
        }
    }


    public FastVector()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #17  <Method void Object()>
        m_Size = 0;
    //    2    4:aload_0         
    //    3    5:iconst_0        
    //    4    6:putfield        #19  <Field int m_Size>
        m_CapacityIncrement = 1;
    //    5    9:aload_0         
    //    6   10:iconst_1        
    //    7   11:putfield        #21  <Field int m_CapacityIncrement>
        m_CapacityMultiplier = 2;
    //    8   14:aload_0         
    //    9   15:iconst_2        
    //   10   16:putfield        #23  <Field int m_CapacityMultiplier>
        m_Objects = new Object[0];
    //   11   19:aload_0         
    //   12   20:iconst_0        
    //   13   21:anewarray       Object[]
    //   14   24:putfield        #25  <Field Object[] m_Objects>
    //   15   27:return          
    }

    public FastVector(int capacity)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #17  <Method void Object()>
        m_Size = 0;
    //    2    4:aload_0         
    //    3    5:iconst_0        
    //    4    6:putfield        #19  <Field int m_Size>
        m_CapacityIncrement = 1;
    //    5    9:aload_0         
    //    6   10:iconst_1        
    //    7   11:putfield        #21  <Field int m_CapacityIncrement>
        m_CapacityMultiplier = 2;
    //    8   14:aload_0         
    //    9   15:iconst_2        
    //   10   16:putfield        #23  <Field int m_CapacityMultiplier>
        m_Objects = new Object[capacity];
    //   11   19:aload_0         
    //   12   20:iload_1         
    //   13   21:anewarray       Object[]
    //   14   24:putfield        #25  <Field Object[] m_Objects>
    //   15   27:return          
    }

    public final void addElement(Object element)
    {
        if(m_Size == m_Objects.length)
    //*   0    0:aload_0         
    //*   1    1:getfield        #19  <Field int m_Size>
    //*   2    4:aload_0         
    //*   3    5:getfield        #25  <Field Object[] m_Objects>
    //*   4    8:arraylength     
    //*   5    9:icmpne          50
        {
            Object newObjects[] = new Object[m_CapacityMultiplier * (m_Objects.length + m_CapacityIncrement)];
    //    6   12:aload_0         
    //    7   13:getfield        #23  <Field int m_CapacityMultiplier>
    //    8   16:aload_0         
    //    9   17:getfield        #25  <Field Object[] m_Objects>
    //   10   20:arraylength     
    //   11   21:aload_0         
    //   12   22:getfield        #21  <Field int m_CapacityIncrement>
    //   13   25:iadd            
    //   14   26:imul            
    //   15   27:anewarray       Object[]
    //   16   30:astore_2        
            System.arraycopy(((Object) (m_Objects)), 0, ((Object) (newObjects)), 0, m_Size);
    //   17   31:aload_0         
    //   18   32:getfield        #25  <Field Object[] m_Objects>
    //   19   35:iconst_0        
    //   20   36:aload_2         
    //   21   37:iconst_0        
    //   22   38:aload_0         
    //   23   39:getfield        #19  <Field int m_Size>
    //   24   42:invokestatic    #39  <Method void System.arraycopy(Object, int, Object, int, int)>
            m_Objects = newObjects;
    //   25   45:aload_0         
    //   26   46:aload_2         
    //   27   47:putfield        #25  <Field Object[] m_Objects>
        }
        m_Objects[m_Size] = element;
    //   28   50:aload_0         
    //   29   51:getfield        #25  <Field Object[] m_Objects>
    //   30   54:aload_0         
    //   31   55:getfield        #19  <Field int m_Size>
    //   32   58:aload_1         
    //   33   59:aastore         
        m_Size++;
    //   34   60:aload_0         
    //   35   61:dup             
    //   36   62:getfield        #19  <Field int m_Size>
    //   37   65:iconst_1        
    //   38   66:iadd            
    //   39   67:putfield        #19  <Field int m_Size>
    //   40   70:return          
    }

    public final int capacity()
    {
        return m_Objects.length;
    //    0    0:aload_0         
    //    1    1:getfield        #25  <Field Object[] m_Objects>
    //    2    4:arraylength     
    //    3    5:ireturn         
    }

    public final Object copy()
    {
        FastVector copy = new FastVector(m_Objects.length);
    //    0    0:new             #2   <Class FastVector>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:getfield        #25  <Field Object[] m_Objects>
    //    4    8:arraylength     
    //    5    9:invokespecial   #47  <Method void FastVector(int)>
    //    6   12:astore_1        
        copy.m_Size = m_Size;
    //    7   13:aload_1         
    //    8   14:aload_0         
    //    9   15:getfield        #19  <Field int m_Size>
    //   10   18:putfield        #19  <Field int m_Size>
        copy.m_CapacityIncrement = m_CapacityIncrement;
    //   11   21:aload_1         
    //   12   22:aload_0         
    //   13   23:getfield        #21  <Field int m_CapacityIncrement>
    //   14   26:putfield        #21  <Field int m_CapacityIncrement>
        copy.m_CapacityMultiplier = m_CapacityMultiplier;
    //   15   29:aload_1         
    //   16   30:aload_0         
    //   17   31:getfield        #23  <Field int m_CapacityMultiplier>
    //   18   34:putfield        #23  <Field int m_CapacityMultiplier>
        System.arraycopy(((Object) (m_Objects)), 0, ((Object) (copy.m_Objects)), 0, m_Size);
    //   19   37:aload_0         
    //   20   38:getfield        #25  <Field Object[] m_Objects>
    //   21   41:iconst_0        
    //   22   42:aload_1         
    //   23   43:getfield        #25  <Field Object[] m_Objects>
    //   24   46:iconst_0        
    //   25   47:aload_0         
    //   26   48:getfield        #19  <Field int m_Size>
    //   27   51:invokestatic    #39  <Method void System.arraycopy(Object, int, Object, int, int)>
        return copy;
    //   28   54:aload_1         
    //   29   55:areturn         
    }

    public final Object copyElements()
    {
        FastVector copy = new FastVector(m_Objects.length);
    //    0    0:new             #2   <Class FastVector>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:getfield        #25  <Field Object[] m_Objects>
    //    4    8:arraylength     
    //    5    9:invokespecial   #47  <Method void FastVector(int)>
    //    6   12:astore_1        
        copy.m_Size = m_Size;
    //    7   13:aload_1         
    //    8   14:aload_0         
    //    9   15:getfield        #19  <Field int m_Size>
    //   10   18:putfield        #19  <Field int m_Size>
        copy.m_CapacityIncrement = m_CapacityIncrement;
    //   11   21:aload_1         
    //   12   22:aload_0         
    //   13   23:getfield        #21  <Field int m_CapacityIncrement>
    //   14   26:putfield        #21  <Field int m_CapacityIncrement>
        copy.m_CapacityMultiplier = m_CapacityMultiplier;
    //   15   29:aload_1         
    //   16   30:aload_0         
    //   17   31:getfield        #23  <Field int m_CapacityMultiplier>
    //   18   34:putfield        #23  <Field int m_CapacityMultiplier>
        for(int i = 0; i < m_Size; i++)
    //*  19   37:iconst_0        
    //*  20   38:istore_2        
    //*  21   39:goto            63
            copy.m_Objects[i] = ((FastVector)m_Objects[i]).copy();
    //   22   42:aload_1         
    //   23   43:getfield        #25  <Field Object[] m_Objects>
    //   24   46:iload_2         
    //   25   47:aload_0         
    //   26   48:getfield        #25  <Field Object[] m_Objects>
    //   27   51:iload_2         
    //   28   52:aaload          
    //   29   53:checkcast       #2   <Class FastVector>
    //   30   56:invokevirtual   #50  <Method Object copy()>
    //   31   59:aastore         

    //   32   60:iinc            2  1
    //   33   63:iload_2         
    //   34   64:aload_0         
    //   35   65:getfield        #19  <Field int m_Size>
    //   36   68:icmplt          42
        return copy;
    //   37   71:aload_1         
    //   38   72:areturn         
    }

    public final Object elementAt(int index)
    {
        return m_Objects[index];
    //    0    0:aload_0         
    //    1    1:getfield        #25  <Field Object[] m_Objects>
    //    2    4:iload_1         
    //    3    5:aaload          
    //    4    6:areturn         
    }

    public final Enumeration elements()
    {
        return new FastVectorEnumeration(this);
    //    0    0:new             #58  <Class FastVector$FastVectorEnumeration>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:aload_0         
    //    4    6:invokespecial   #61  <Method void FastVector$FastVectorEnumeration(FastVector, FastVector)>
    //    5    9:areturn         
    }

    public final Enumeration elements(int index)
    {
        return new FastVectorEnumeration(this, index);
    //    0    0:new             #58  <Class FastVector$FastVectorEnumeration>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:aload_0         
    //    4    6:iload_1         
    //    5    7:invokespecial   #65  <Method void FastVector$FastVectorEnumeration(FastVector, FastVector, int)>
    //    6   10:areturn         
    }

    public boolean contains(Object o)
    {
        if(o == null)
    //*   0    0:aload_1         
    //*   1    1:ifnonnull       6
            return false;
    //    2    4:iconst_0        
    //    3    5:ireturn         
        for(int i = 0; i < m_Objects.length; i++)
    //*   4    6:iconst_0        
    //*   5    7:istore_2        
    //*   6    8:goto            29
            if(o.equals(m_Objects[i]))
    //*   7   11:aload_1         
    //*   8   12:aload_0         
    //*   9   13:getfield        #25  <Field Object[] m_Objects>
    //*  10   16:iload_2         
    //*  11   17:aaload          
    //*  12   18:invokevirtual   #70  <Method boolean Object.equals(Object)>
    //*  13   21:ifeq            26
                return true;
    //   14   24:iconst_1        
    //   15   25:ireturn         

    //   16   26:iinc            2  1
    //   17   29:iload_2         
    //   18   30:aload_0         
    //   19   31:getfield        #25  <Field Object[] m_Objects>
    //   20   34:arraylength     
    //   21   35:icmplt          11
        return false;
    //   22   38:iconst_0        
    //   23   39:ireturn         
    }

    public final Object firstElement()
    {
        return m_Objects[0];
    //    0    0:aload_0         
    //    1    1:getfield        #25  <Field Object[] m_Objects>
    //    2    4:iconst_0        
    //    3    5:aaload          
    //    4    6:areturn         
    }

    public final int indexOf(Object element)
    {
        for(int i = 0; i < m_Size; i++)
    //*   0    0:iconst_0        
    //*   1    1:istore_2        
    //*   2    2:goto            23
            if(element.equals(m_Objects[i]))
    //*   3    5:aload_1         
    //*   4    6:aload_0         
    //*   5    7:getfield        #25  <Field Object[] m_Objects>
    //*   6   10:iload_2         
    //*   7   11:aaload          
    //*   8   12:invokevirtual   #70  <Method boolean Object.equals(Object)>
    //*   9   15:ifeq            20
                return i;
    //   10   18:iload_2         
    //   11   19:ireturn         

    //   12   20:iinc            2  1
    //   13   23:iload_2         
    //   14   24:aload_0         
    //   15   25:getfield        #19  <Field int m_Size>
    //   16   28:icmplt          5
        return -1;
    //   17   31:iconst_m1       
    //   18   32:ireturn         
    }

    public final void insertElementAt(Object element, int index)
    {
        if(m_Size < m_Objects.length)
    //*   0    0:aload_0         
    //*   1    1:getfield        #19  <Field int m_Size>
    //*   2    4:aload_0         
    //*   3    5:getfield        #25  <Field Object[] m_Objects>
    //*   4    8:arraylength     
    //*   5    9:icmpge          43
        {
            System.arraycopy(((Object) (m_Objects)), index, ((Object) (m_Objects)), index + 1, m_Size - index);
    //    6   12:aload_0         
    //    7   13:getfield        #25  <Field Object[] m_Objects>
    //    8   16:iload_2         
    //    9   17:aload_0         
    //   10   18:getfield        #25  <Field Object[] m_Objects>
    //   11   21:iload_2         
    //   12   22:iconst_1        
    //   13   23:iadd            
    //   14   24:aload_0         
    //   15   25:getfield        #19  <Field int m_Size>
    //   16   28:iload_2         
    //   17   29:isub            
    //   18   30:invokestatic    #39  <Method void System.arraycopy(Object, int, Object, int, int)>
            m_Objects[index] = element;
    //   19   33:aload_0         
    //   20   34:getfield        #25  <Field Object[] m_Objects>
    //   21   37:iload_2         
    //   22   38:aload_1         
    //   23   39:aastore         
        } else
    //*  24   40:goto            100
        {
            Object newObjects[] = new Object[m_CapacityMultiplier * (m_Objects.length + m_CapacityIncrement)];
    //   25   43:aload_0         
    //   26   44:getfield        #23  <Field int m_CapacityMultiplier>
    //   27   47:aload_0         
    //   28   48:getfield        #25  <Field Object[] m_Objects>
    //   29   51:arraylength     
    //   30   52:aload_0         
    //   31   53:getfield        #21  <Field int m_CapacityIncrement>
    //   32   56:iadd            
    //   33   57:imul            
    //   34   58:anewarray       Object[]
    //   35   61:astore_3        
            System.arraycopy(((Object) (m_Objects)), 0, ((Object) (newObjects)), 0, index);
    //   36   62:aload_0         
    //   37   63:getfield        #25  <Field Object[] m_Objects>
    //   38   66:iconst_0        
    //   39   67:aload_3         
    //   40   68:iconst_0        
    //   41   69:iload_2         
    //   42   70:invokestatic    #39  <Method void System.arraycopy(Object, int, Object, int, int)>
            newObjects[index] = element;
    //   43   73:aload_3         
    //   44   74:iload_2         
    //   45   75:aload_1         
    //   46   76:aastore         
            System.arraycopy(((Object) (m_Objects)), index, ((Object) (newObjects)), index + 1, m_Size - index);
    //   47   77:aload_0         
    //   48   78:getfield        #25  <Field Object[] m_Objects>
    //   49   81:iload_2         
    //   50   82:aload_3         
    //   51   83:iload_2         
    //   52   84:iconst_1        
    //   53   85:iadd            
    //   54   86:aload_0         
    //   55   87:getfield        #19  <Field int m_Size>
    //   56   90:iload_2         
    //   57   91:isub            
    //   58   92:invokestatic    #39  <Method void System.arraycopy(Object, int, Object, int, int)>
            m_Objects = newObjects;
    //   59   95:aload_0         
    //   60   96:aload_3         
    //   61   97:putfield        #25  <Field Object[] m_Objects>
        }
        m_Size++;
    //   62  100:aload_0         
    //   63  101:dup             
    //   64  102:getfield        #19  <Field int m_Size>
    //   65  105:iconst_1        
    //   66  106:iadd            
    //   67  107:putfield        #19  <Field int m_Size>
    //   68  110:return          
    }

    public final Object lastElement()
    {
        return m_Objects[m_Size - 1];
    //    0    0:aload_0         
    //    1    1:getfield        #25  <Field Object[] m_Objects>
    //    2    4:aload_0         
    //    3    5:getfield        #19  <Field int m_Size>
    //    4    8:iconst_1        
    //    5    9:isub            
    //    6   10:aaload          
    //    7   11:areturn         
    }

    public final void removeElementAt(int index)
    {
        System.arraycopy(((Object) (m_Objects)), index + 1, ((Object) (m_Objects)), index, m_Size - index - 1);
    //    0    0:aload_0         
    //    1    1:getfield        #25  <Field Object[] m_Objects>
    //    2    4:iload_1         
    //    3    5:iconst_1        
    //    4    6:iadd            
    //    5    7:aload_0         
    //    6    8:getfield        #25  <Field Object[] m_Objects>
    //    7   11:iload_1         
    //    8   12:aload_0         
    //    9   13:getfield        #19  <Field int m_Size>
    //   10   16:iload_1         
    //   11   17:isub            
    //   12   18:iconst_1        
    //   13   19:isub            
    //   14   20:invokestatic    #39  <Method void System.arraycopy(Object, int, Object, int, int)>
        m_Objects[m_Size - 1] = null;
    //   15   23:aload_0         
    //   16   24:getfield        #25  <Field Object[] m_Objects>
    //   17   27:aload_0         
    //   18   28:getfield        #19  <Field int m_Size>
    //   19   31:iconst_1        
    //   20   32:isub            
    //   21   33:aconst_null     
    //   22   34:aastore         
        m_Size--;
    //   23   35:aload_0         
    //   24   36:dup             
    //   25   37:getfield        #19  <Field int m_Size>
    //   26   40:iconst_1        
    //   27   41:isub            
    //   28   42:putfield        #19  <Field int m_Size>
    //   29   45:return          
    }

    public final void removeAllElements()
    {
        m_Objects = new Object[m_Objects.length];
    //    0    0:aload_0         
    //    1    1:aload_0         
    //    2    2:getfield        #25  <Field Object[] m_Objects>
    //    3    5:arraylength     
    //    4    6:anewarray       Object[]
    //    5    9:putfield        #25  <Field Object[] m_Objects>
        m_Size = 0;
    //    6   12:aload_0         
    //    7   13:iconst_0        
    //    8   14:putfield        #19  <Field int m_Size>
    //    9   17:return          
    }

    public final void appendElements(FastVector toAppend)
    {
        setCapacity(size() + toAppend.size());
    //    0    0:aload_0         
    //    1    1:aload_0         
    //    2    2:invokevirtual   #84  <Method int size()>
    //    3    5:aload_1         
    //    4    6:invokevirtual   #84  <Method int size()>
    //    5    9:iadd            
    //    6   10:invokevirtual   #87  <Method void setCapacity(int)>
        System.arraycopy(((Object) (toAppend.m_Objects)), 0, ((Object) (m_Objects)), size(), toAppend.size());
    //    7   13:aload_1         
    //    8   14:getfield        #25  <Field Object[] m_Objects>
    //    9   17:iconst_0        
    //   10   18:aload_0         
    //   11   19:getfield        #25  <Field Object[] m_Objects>
    //   12   22:aload_0         
    //   13   23:invokevirtual   #84  <Method int size()>
    //   14   26:aload_1         
    //   15   27:invokevirtual   #84  <Method int size()>
    //   16   30:invokestatic    #39  <Method void System.arraycopy(Object, int, Object, int, int)>
        m_Size = m_Objects.length;
    //   17   33:aload_0         
    //   18   34:aload_0         
    //   19   35:getfield        #25  <Field Object[] m_Objects>
    //   20   38:arraylength     
    //   21   39:putfield        #19  <Field int m_Size>
    //   22   42:return          
    }

    public final Object[] toArray()
    {
        Object newObjects[] = new Object[size()];
    //    0    0:aload_0         
    //    1    1:invokevirtual   #84  <Method int size()>
    //    2    4:anewarray       Object[]
    //    3    7:astore_1        
        System.arraycopy(((Object) (m_Objects)), 0, ((Object) (newObjects)), 0, size());
    //    4    8:aload_0         
    //    5    9:getfield        #25  <Field Object[] m_Objects>
    //    6   12:iconst_0        
    //    7   13:aload_1         
    //    8   14:iconst_0        
    //    9   15:aload_0         
    //   10   16:invokevirtual   #84  <Method int size()>
    //   11   19:invokestatic    #39  <Method void System.arraycopy(Object, int, Object, int, int)>
        return newObjects;
    //   12   22:aload_1         
    //   13   23:areturn         
    }

    public final void setCapacity(int capacity)
    {
        Object newObjects[] = new Object[capacity];
    //    0    0:iload_1         
    //    1    1:anewarray       Object[]
    //    2    4:astore_2        
        System.arraycopy(((Object) (m_Objects)), 0, ((Object) (newObjects)), 0, Math.min(capacity, m_Size));
    //    3    5:aload_0         
    //    4    6:getfield        #25  <Field Object[] m_Objects>
    //    5    9:iconst_0        
    //    6   10:aload_2         
    //    7   11:iconst_0        
    //    8   12:iload_1         
    //    9   13:aload_0         
    //   10   14:getfield        #19  <Field int m_Size>
    //   11   17:invokestatic    #96  <Method int Math.min(int, int)>
    //   12   20:invokestatic    #39  <Method void System.arraycopy(Object, int, Object, int, int)>
        m_Objects = newObjects;
    //   13   23:aload_0         
    //   14   24:aload_2         
    //   15   25:putfield        #25  <Field Object[] m_Objects>
        if(m_Objects.length < m_Size)
    //*  16   28:aload_0         
    //*  17   29:getfield        #25  <Field Object[] m_Objects>
    //*  18   32:arraylength     
    //*  19   33:aload_0         
    //*  20   34:getfield        #19  <Field int m_Size>
    //*  21   37:icmpge          49
            m_Size = m_Objects.length;
    //   22   40:aload_0         
    //   23   41:aload_0         
    //   24   42:getfield        #25  <Field Object[] m_Objects>
    //   25   45:arraylength     
    //   26   46:putfield        #19  <Field int m_Size>
    //   27   49:return          
    }

    public final void setElementAt(Object element, int index)
    {
        m_Objects[index] = element;
    //    0    0:aload_0         
    //    1    1:getfield        #25  <Field Object[] m_Objects>
    //    2    4:iload_2         
    //    3    5:aload_1         
    //    4    6:aastore         
    //    5    7:return          
    }

    public final int size()
    {
        return m_Size;
    //    0    0:aload_0         
    //    1    1:getfield        #19  <Field int m_Size>
    //    2    4:ireturn         
    }

    public final void swap(int first, int second)
    {
        Object help = m_Objects[first];
    //    0    0:aload_0         
    //    1    1:getfield        #25  <Field Object[] m_Objects>
    //    2    4:iload_1         
    //    3    5:aaload          
    //    4    6:astore_3        
        m_Objects[first] = m_Objects[second];
    //    5    7:aload_0         
    //    6    8:getfield        #25  <Field Object[] m_Objects>
    //    7   11:iload_1         
    //    8   12:aload_0         
    //    9   13:getfield        #25  <Field Object[] m_Objects>
    //   10   16:iload_2         
    //   11   17:aaload          
    //   12   18:aastore         
        m_Objects[second] = help;
    //   13   19:aload_0         
    //   14   20:getfield        #25  <Field Object[] m_Objects>
    //   15   23:iload_2         
    //   16   24:aload_3         
    //   17   25:aastore         
    //   18   26:return          
    }

    public final void trimToSize()
    {
        Object newObjects[] = new Object[m_Size];
    //    0    0:aload_0         
    //    1    1:getfield        #19  <Field int m_Size>
    //    2    4:anewarray       Object[]
    //    3    7:astore_1        
        System.arraycopy(((Object) (m_Objects)), 0, ((Object) (newObjects)), 0, m_Size);
    //    4    8:aload_0         
    //    5    9:getfield        #25  <Field Object[] m_Objects>
    //    6   12:iconst_0        
    //    7   13:aload_1         
    //    8   14:iconst_0        
    //    9   15:aload_0         
    //   10   16:getfield        #19  <Field int m_Size>
    //   11   19:invokestatic    #39  <Method void System.arraycopy(Object, int, Object, int, int)>
        m_Objects = newObjects;
    //   12   22:aload_0         
    //   13   23:aload_1         
    //   14   24:putfield        #25  <Field Object[] m_Objects>
    //   15   27:return          
    }

    private Object m_Objects[];
    private int m_Size;
    private int m_CapacityIncrement;
    private int m_CapacityMultiplier;
}
