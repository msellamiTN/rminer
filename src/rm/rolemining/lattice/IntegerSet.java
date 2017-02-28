// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   IntegerSet.java

package rm.rolemining.lattice;


public class IntegerSet
{

    IntegerSet()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #15  <Method void Object()>
        element = new boolean[800];
    //    2    4:aload_0         
    //    3    5:sipush          800
    //    4    8:newarray        boolean[]
    //    5   10:putfield        #17  <Field boolean[] element>
        for(int i = 0; i < 800; i++)
    //*   6   13:iconst_0        
    //*   7   14:istore_1        
    //*   8   15:goto            28
            element[i] = false;
    //    9   18:aload_0         
    //   10   19:getfield        #17  <Field boolean[] element>
    //   11   22:iload_1         
    //   12   23:iconst_0        
    //   13   24:bastore         

    //   14   25:iinc            1  1
    //   15   28:iload_1         
    //   16   29:sipush          800
    //   17   32:icmplt          18
    //   18   35:return          
    }

    IntegerSet(int initialValue)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #15  <Method void Object()>
        element = new boolean[800];
    //    2    4:aload_0         
    //    3    5:sipush          800
    //    4    8:newarray        boolean[]
    //    5   10:putfield        #17  <Field boolean[] element>
        addElement(initialValue);
    //    6   13:aload_0         
    //    7   14:iload_1         
    //    8   15:invokevirtual   #26  <Method void addElement(int)>
    //    9   18:return          
    }

    IntegerSet(IntegerSet initialSet)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #15  <Method void Object()>
        element = new boolean[800];
    //    2    4:aload_0         
    //    3    5:sipush          800
    //    4    8:newarray        boolean[]
    //    5   10:putfield        #17  <Field boolean[] element>
        addElements(initialSet);
    //    6   13:aload_0         
    //    7   14:aload_1         
    //    8   15:invokevirtual   #31  <Method void addElements(IntegerSet)>
    //    9   18:return          
    }

    IntegerSet(int lo, int hi)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #15  <Method void Object()>
        element = new boolean[800];
    //    2    4:aload_0         
    //    3    5:sipush          800
    //    4    8:newarray        boolean[]
    //    5   10:putfield        #17  <Field boolean[] element>
        addAllElementsWithinRange(lo, hi);
    //    6   13:aload_0         
    //    7   14:iload_1         
    //    8   15:iload_2         
    //    9   16:invokevirtual   #36  <Method void addAllElementsWithinRange(int, int)>
    //   10   19:return          
    }

    private boolean isValidIndex(int index)
    {
        return index >= 0 && index < 800;
    //    0    0:iload_1         
    //    1    1:iflt            13
    //    2    4:iload_1         
    //    3    5:sipush          800
    //    4    8:icmpge          13
    //    5   11:iconst_1        
    //    6   12:ireturn         
    //    7   13:iconst_0        
    //    8   14:ireturn         
    }

    public void addElement(int newElement)
    {
        if(isValidIndex(newElement))
    //*   0    0:aload_0         
    //*   1    1:iload_1         
    //*   2    2:invokespecial   #43  <Method boolean isValidIndex(int)>
    //*   3    5:ifeq            15
            element[newElement] = true;
    //    4    8:aload_0         
    //    5    9:getfield        #17  <Field boolean[] element>
    //    6   12:iload_1         
    //    7   13:iconst_1        
    //    8   14:bastore         
    //    9   15:return          
    }

    public void addElements(IntegerSet newElements)
    {
        for(int i = 0; i < 800; i++)
    //*   0    0:iconst_0        
    //*   1    1:istore_2        
    //*   2    2:goto            24
            if(newElements.element[i])
    //*   3    5:aload_1         
    //*   4    6:getfield        #17  <Field boolean[] element>
    //*   5    9:iload_2         
    //*   6   10:baload          
    //*   7   11:ifeq            21
                element[i] = true;
    //    8   14:aload_0         
    //    9   15:getfield        #17  <Field boolean[] element>
    //   10   18:iload_2         
    //   11   19:iconst_1        
    //   12   20:bastore         

    //   13   21:iinc            2  1
    //   14   24:iload_2         
    //   15   25:sipush          800
    //   16   28:icmplt          5
    //   17   31:return          
    }

    public void addAllElementsWithinRange(int lo, int hi)
    {
        if(!isValidIndex(lo) || !isValidIndex(hi))
    //*   0    0:aload_0         
    //*   1    1:iload_1         
    //*   2    2:invokespecial   #43  <Method boolean isValidIndex(int)>
    //*   3    5:ifeq            16
    //*   4    8:aload_0         
    //*   5    9:iload_2         
    //*   6   10:invokespecial   #43  <Method boolean isValidIndex(int)>
    //*   7   13:ifne            17
            return;
    //    8   16:return          
        if(lo > hi)
    //*   9   17:iload_1         
    //*  10   18:iload_2         
    //*  11   19:icmple          30
        {
            int tmp = lo;
    //   12   22:iload_1         
    //   13   23:istore          4
            lo = hi;
    //   14   25:iload_2         
    //   15   26:istore_1        
            hi = tmp;
    //   16   27:iload           4
    //   17   29:istore_2        
        }
        for(int i = lo; i <= hi; i++)
    //*  18   30:iload_1         
    //*  19   31:istore_3        
    //*  20   32:goto            45
            element[i] = true;
    //   21   35:aload_0         
    //   22   36:getfield        #17  <Field boolean[] element>
    //   23   39:iload_3         
    //   24   40:iconst_1        
    //   25   41:bastore         

    //   26   42:iinc            3  1
    //   27   45:iload_3         
    //   28   46:iload_2         
    //   29   47:icmple          35
    //   30   50:return          
    }

    public void removeElement(int element)
    {
        if(isValidIndex(element))
    //*   0    0:aload_0         
    //*   1    1:iload_1         
    //*   2    2:invokespecial   #43  <Method boolean isValidIndex(int)>
    //*   3    5:ifeq            15
            this.element[element] = false;
    //    4    8:aload_0         
    //    5    9:getfield        #17  <Field boolean[] element>
    //    6   12:iload_1         
    //    7   13:iconst_0        
    //    8   14:bastore         
    //    9   15:return          
    }

    public IntegerSet removeElements(IntegerSet elements)
    {
        IntegerSet result = new IntegerSet();
    //    0    0:new             #2   <Class IntegerSet>
    //    1    3:dup             
    //    2    4:invokespecial   #50  <Method void IntegerSet()>
    //    3    7:astore_3        
        for(int i = 0; i < 800; i++)
    //*   4    8:iconst_0        
    //*   5    9:istore_2        
    //*   6   10:goto            39
            if(elements.element[i])
    //*   7   13:aload_1         
    //*   8   14:getfield        #17  <Field boolean[] element>
    //*   9   17:iload_2         
    //*  10   18:baload          
    //*  11   19:ifeq            36
            {
                element[i] = false;
    //   12   22:aload_0         
    //   13   23:getfield        #17  <Field boolean[] element>
    //   14   26:iload_2         
    //   15   27:iconst_0        
    //   16   28:bastore         
                result.element[i] = true;
    //   17   29:aload_3         
    //   18   30:getfield        #17  <Field boolean[] element>
    //   19   33:iload_2         
    //   20   34:iconst_1        
    //   21   35:bastore         
            }

    //   22   36:iinc            2  1
    //   23   39:iload_2         
    //   24   40:sipush          800
    //   25   43:icmplt          13
        return result;
    //   26   46:aload_3         
    //   27   47:areturn         
    }

    public boolean contains(int element)
    {
        if(isValidIndex(element))
    //*   0    0:aload_0         
    //*   1    1:iload_1         
    //*   2    2:invokespecial   #43  <Method boolean isValidIndex(int)>
    //*   3    5:ifeq            15
            return this.element[element];
    //    4    8:aload_0         
    //    5    9:getfield        #17  <Field boolean[] element>
    //    6   12:iload_1         
    //    7   13:baload          
    //    8   14:ireturn         
        else
            return false;
    //    9   15:iconst_0        
    //   10   16:ireturn         
    }

    public boolean contains(IntegerSet otherSet)
    {
        for(int i = 0; i < 800; i++)
    //*   0    0:iconst_0        
    //*   1    1:istore_2        
    //*   2    2:goto            34
            if(otherSet.element[i] && element[i] != otherSet.element[i])
    //*   3    5:aload_1         
    //*   4    6:getfield        #17  <Field boolean[] element>
    //*   5    9:iload_2         
    //*   6   10:baload          
    //*   7   11:ifeq            31
    //*   8   14:aload_0         
    //*   9   15:getfield        #17  <Field boolean[] element>
    //*  10   18:iload_2         
    //*  11   19:baload          
    //*  12   20:aload_1         
    //*  13   21:getfield        #17  <Field boolean[] element>
    //*  14   24:iload_2         
    //*  15   25:baload          
    //*  16   26:icmpeq          31
                return false;
    //   17   29:iconst_0        
    //   18   30:ireturn         

    //   19   31:iinc            2  1
    //   20   34:iload_2         
    //   21   35:sipush          800
    //   22   38:icmplt          5
        return true;
    //   23   41:iconst_1        
    //   24   42:ireturn         
    }

    public IntegerSet getUnion(IntegerSet otherSet)
    {
        IntegerSet result = new IntegerSet();
    //    0    0:new             #2   <Class IntegerSet>
    //    1    3:dup             
    //    2    4:invokespecial   #50  <Method void IntegerSet()>
    //    3    7:astore_3        
        for(int i = 0; i < 800; i++)
    //*   4    8:iconst_0        
    //*   5    9:istore_2        
    //*   6   10:goto            45
            result.element[i] = element[i] || otherSet.element[i];
    //    7   13:aload_3         
    //    8   14:getfield        #17  <Field boolean[] element>
    //    9   17:iload_2         
    //   10   18:aload_0         
    //   11   19:getfield        #17  <Field boolean[] element>
    //   12   22:iload_2         
    //   13   23:baload          
    //   14   24:ifne            40
    //   15   27:aload_1         
    //   16   28:getfield        #17  <Field boolean[] element>
    //   17   31:iload_2         
    //   18   32:baload          
    //   19   33:ifne            40
    //   20   36:iconst_0        
    //   21   37:goto            41
    //   22   40:iconst_1        
    //   23   41:bastore         

    //   24   42:iinc            2  1
    //   25   45:iload_2         
    //   26   46:sipush          800
    //   27   49:icmplt          13
        return result;
    //   28   52:aload_3         
    //   29   53:areturn         
    }

    public IntegerSet getIntersection(IntegerSet otherSet)
    {
        IntegerSet result = new IntegerSet();
    //    0    0:new             #2   <Class IntegerSet>
    //    1    3:dup             
    //    2    4:invokespecial   #50  <Method void IntegerSet()>
    //    3    7:astore_3        
        for(int i = 0; i < 800; i++)
    //*   4    8:iconst_0        
    //*   5    9:istore_2        
    //*   6   10:goto            45
            result.element[i] = element[i] && otherSet.element[i];
    //    7   13:aload_3         
    //    8   14:getfield        #17  <Field boolean[] element>
    //    9   17:iload_2         
    //   10   18:aload_0         
    //   11   19:getfield        #17  <Field boolean[] element>
    //   12   22:iload_2         
    //   13   23:baload          
    //   14   24:ifeq            40
    //   15   27:aload_1         
    //   16   28:getfield        #17  <Field boolean[] element>
    //   17   31:iload_2         
    //   18   32:baload          
    //   19   33:ifeq            40
    //   20   36:iconst_1        
    //   21   37:goto            41
    //   22   40:iconst_0        
    //   23   41:bastore         

    //   24   42:iinc            2  1
    //   25   45:iload_2         
    //   26   46:sipush          800
    //   27   49:icmplt          13
        return result;
    //   28   52:aload_3         
    //   29   53:areturn         
    }

    public IntegerSet getDifference(IntegerSet otherSet)
    {
        IntegerSet result = new IntegerSet();
    //    0    0:new             #2   <Class IntegerSet>
    //    1    3:dup             
    //    2    4:invokespecial   #50  <Method void IntegerSet()>
    //    3    7:astore_2        
        for(int i = 0; i < 800; i++)
    //*   4    8:iconst_0        
    //*   5    9:istore_3        
    //*   6   10:goto            42
            result.element[i] = element[i] != otherSet.element[i];
    //    7   13:aload_2         
    //    8   14:getfield        #17  <Field boolean[] element>
    //    9   17:iload_3         
    //   10   18:aload_0         
    //   11   19:getfield        #17  <Field boolean[] element>
    //   12   22:iload_3         
    //   13   23:baload          
    //   14   24:aload_1         
    //   15   25:getfield        #17  <Field boolean[] element>
    //   16   28:iload_3         
    //   17   29:baload          
    //   18   30:icmpeq          37
    //   19   33:iconst_1        
    //   20   34:goto            38
    //   21   37:iconst_0        
    //   22   38:bastore         

    //   23   39:iinc            3  1
    //   24   42:iload_3         
    //   25   43:sipush          800
    //   26   46:icmplt          13
        return result;
    //   27   49:aload_2         
    //   28   50:areturn         
    }

    public boolean isEmpty()
    {
        for(int i = 0; i < 800; i++)
    //*   0    0:iconst_0        
    //*   1    1:istore_1        
    //*   2    2:goto            19
            if(element[i])
    //*   3    5:aload_0         
    //*   4    6:getfield        #17  <Field boolean[] element>
    //*   5    9:iload_1         
    //*   6   10:baload          
    //*   7   11:ifeq            16
                return false;
    //    8   14:iconst_0        
    //    9   15:ireturn         

    //   10   16:iinc            1  1
    //   11   19:iload_1         
    //   12   20:sipush          800
    //   13   23:icmplt          5
        return true;
    //   14   26:iconst_1        
    //   15   27:ireturn         
    }

    public int getSize()
    {
        int result = 0;
    //    0    0:iconst_0        
    //    1    1:istore_2        
        for(int i = 0; i < 800; i++)
    //*   2    2:iconst_0        
    //*   3    3:istore_1        
    //*   4    4:goto            22
            if(element[i])
    //*   5    7:aload_0         
    //*   6    8:getfield        #17  <Field boolean[] element>
    //*   7   11:iload_1         
    //*   8   12:baload          
    //*   9   13:ifeq            19
                result++;
    //   10   16:iinc            2  1

    //   11   19:iinc            1  1
    //   12   22:iload_1         
    //   13   23:sipush          800
    //   14   26:icmplt          7
        return result;
    //   15   29:iload_2         
    //   16   30:ireturn         
    }

    public boolean equals(IntegerSet otherSet)
    {
        for(int i = 0; i < 800; i++)
    //*   0    0:iconst_0        
    //*   1    1:istore_2        
    //*   2    2:goto            25
            if(element[i] != otherSet.element[i])
    //*   3    5:aload_0         
    //*   4    6:getfield        #17  <Field boolean[] element>
    //*   5    9:iload_2         
    //*   6   10:baload          
    //*   7   11:aload_1         
    //*   8   12:getfield        #17  <Field boolean[] element>
    //*   9   15:iload_2         
    //*  10   16:baload          
    //*  11   17:icmpeq          22
                return false;
    //   12   20:iconst_0        
    //   13   21:ireturn         

    //   14   22:iinc            2  1
    //   15   25:iload_2         
    //   16   26:sipush          800
    //   17   29:icmplt          5
        return true;
    //   18   32:iconst_1        
    //   19   33:ireturn         
    }

    public boolean getElementAt(int i)
    {
        return element[i];
    //    0    0:aload_0         
    //    1    1:getfield        #17  <Field boolean[] element>
    //    2    4:iload_1         
    //    3    5:baload          
    //    4    6:ireturn         
    }

    static final int MAX_ELEMENTS = 800;
    private boolean element[];
}
