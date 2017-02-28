// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   IntegerSet.java

package rm.core;


public class IntegerSet
{

    public IntegerSet(int n)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #14  <Method void Object()>
        n_elements = n;
    //    2    4:aload_0         
    //    3    5:iload_1         
    //    4    6:putfield        #16  <Field int n_elements>
        element = new boolean[n_elements];
    //    5    9:aload_0         
    //    6   10:aload_0         
    //    7   11:getfield        #16  <Field int n_elements>
    //    8   14:newarray        boolean[]
    //    9   16:putfield        #18  <Field boolean[] element>
        for(int i = 0; i < n_elements; i++)
    //*  10   19:iconst_0        
    //*  11   20:istore_2        
    //*  12   21:goto            34
            element[i] = false;
    //   13   24:aload_0         
    //   14   25:getfield        #18  <Field boolean[] element>
    //   15   28:iload_2         
    //   16   29:iconst_0        
    //   17   30:bastore         

    //   18   31:iinc            2  1
    //   19   34:iload_2         
    //   20   35:aload_0         
    //   21   36:getfield        #16  <Field int n_elements>
    //   22   39:icmplt          24
    //   23   42:return          
    }

    public IntegerSet(IntegerSet initialSet)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #14  <Method void Object()>
        addElements(initialSet);
    //    2    4:aload_0         
    //    3    5:aload_1         
    //    4    6:invokevirtual   #28  <Method void addElements(IntegerSet)>
    //    5    9:return          
    }

    IntegerSet(int lo, int hi)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #14  <Method void Object()>
        addAllElementsWithinRange(lo, hi);
    //    2    4:aload_0         
    //    3    5:iload_1         
    //    4    6:iload_2         
    //    5    7:invokevirtual   #33  <Method void addAllElementsWithinRange(int, int)>
    //    6   10:return          
    }

    private boolean isValidIndex(int index)
    {
        return index >= 0 && index < n_elements;
    //    0    0:iload_1         
    //    1    1:iflt            14
    //    2    4:iload_1         
    //    3    5:aload_0         
    //    4    6:getfield        #16  <Field int n_elements>
    //    5    9:icmpge          14
    //    6   12:iconst_1        
    //    7   13:ireturn         
    //    8   14:iconst_0        
    //    9   15:ireturn         
    }

    public void addElement(int newElement)
    {
        if(isValidIndex(newElement))
    //*   0    0:aload_0         
    //*   1    1:iload_1         
    //*   2    2:invokespecial   #41  <Method boolean isValidIndex(int)>
    //*   3    5:ifeq            15
            element[newElement] = true;
    //    4    8:aload_0         
    //    5    9:getfield        #18  <Field boolean[] element>
    //    6   12:iload_1         
    //    7   13:iconst_1        
    //    8   14:bastore         
    //    9   15:return          
    }

    public void addElements(IntegerSet newElements)
    {
        for(int i = 0; i < n_elements; i++)
    //*   0    0:iconst_0        
    //*   1    1:istore_2        
    //*   2    2:goto            24
            if(newElements.element[i])
    //*   3    5:aload_1         
    //*   4    6:getfield        #18  <Field boolean[] element>
    //*   5    9:iload_2         
    //*   6   10:baload          
    //*   7   11:ifeq            21
                element[i] = true;
    //    8   14:aload_0         
    //    9   15:getfield        #18  <Field boolean[] element>
    //   10   18:iload_2         
    //   11   19:iconst_1        
    //   12   20:bastore         

    //   13   21:iinc            2  1
    //   14   24:iload_2         
    //   15   25:aload_0         
    //   16   26:getfield        #16  <Field int n_elements>
    //   17   29:icmplt          5
    //   18   32:return          
    }

    public void addAllElementsWithinRange(int lo, int hi)
    {
        if(!isValidIndex(lo) || !isValidIndex(hi))
    //*   0    0:aload_0         
    //*   1    1:iload_1         
    //*   2    2:invokespecial   #41  <Method boolean isValidIndex(int)>
    //*   3    5:ifeq            16
    //*   4    8:aload_0         
    //*   5    9:iload_2         
    //*   6   10:invokespecial   #41  <Method boolean isValidIndex(int)>
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
    //   22   36:getfield        #18  <Field boolean[] element>
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
    //*   2    2:invokespecial   #41  <Method boolean isValidIndex(int)>
    //*   3    5:ifeq            15
            this.element[element] = false;
    //    4    8:aload_0         
    //    5    9:getfield        #18  <Field boolean[] element>
    //    6   12:iload_1         
    //    7   13:iconst_0        
    //    8   14:bastore         
    //    9   15:return          
    }

    public IntegerSet removeElements(IntegerSet elements)
    {
        IntegerSet result = new IntegerSet(n_elements);
    //    0    0:new             #2   <Class IntegerSet>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:getfield        #16  <Field int n_elements>
    //    4    8:invokespecial   #49  <Method void IntegerSet(int)>
    //    5   11:astore_3        
        for(int i = 0; i < n_elements; i++)
    //*   6   12:iconst_0        
    //*   7   13:istore_2        
    //*   8   14:goto            43
            if(elements.element[i])
    //*   9   17:aload_1         
    //*  10   18:getfield        #18  <Field boolean[] element>
    //*  11   21:iload_2         
    //*  12   22:baload          
    //*  13   23:ifeq            40
            {
                element[i] = false;
    //   14   26:aload_0         
    //   15   27:getfield        #18  <Field boolean[] element>
    //   16   30:iload_2         
    //   17   31:iconst_0        
    //   18   32:bastore         
                result.element[i] = true;
    //   19   33:aload_3         
    //   20   34:getfield        #18  <Field boolean[] element>
    //   21   37:iload_2         
    //   22   38:iconst_1        
    //   23   39:bastore         
            }

    //   24   40:iinc            2  1
    //   25   43:iload_2         
    //   26   44:aload_0         
    //   27   45:getfield        #16  <Field int n_elements>
    //   28   48:icmplt          17
        return result;
    //   29   51:aload_3         
    //   30   52:areturn         
    }

    public boolean contains(int element)
    {
        if(isValidIndex(element))
    //*   0    0:aload_0         
    //*   1    1:iload_1         
    //*   2    2:invokespecial   #41  <Method boolean isValidIndex(int)>
    //*   3    5:ifeq            15
            return this.element[element];
    //    4    8:aload_0         
    //    5    9:getfield        #18  <Field boolean[] element>
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
        for(int i = 0; i < n_elements; i++)
    //*   0    0:iconst_0        
    //*   1    1:istore_2        
    //*   2    2:goto            34
            if(otherSet.element[i] && element[i] != otherSet.element[i])
    //*   3    5:aload_1         
    //*   4    6:getfield        #18  <Field boolean[] element>
    //*   5    9:iload_2         
    //*   6   10:baload          
    //*   7   11:ifeq            31
    //*   8   14:aload_0         
    //*   9   15:getfield        #18  <Field boolean[] element>
    //*  10   18:iload_2         
    //*  11   19:baload          
    //*  12   20:aload_1         
    //*  13   21:getfield        #18  <Field boolean[] element>
    //*  14   24:iload_2         
    //*  15   25:baload          
    //*  16   26:icmpeq          31
                return false;
    //   17   29:iconst_0        
    //   18   30:ireturn         

    //   19   31:iinc            2  1
    //   20   34:iload_2         
    //   21   35:aload_0         
    //   22   36:getfield        #16  <Field int n_elements>
    //   23   39:icmplt          5
        return true;
    //   24   42:iconst_1        
    //   25   43:ireturn         
    }

    public IntegerSet getUnion(IntegerSet otherSet)
    {
        IntegerSet result = new IntegerSet(n_elements);
    //    0    0:new             #2   <Class IntegerSet>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:getfield        #16  <Field int n_elements>
    //    4    8:invokespecial   #49  <Method void IntegerSet(int)>
    //    5   11:astore_3        
        for(int i = 0; i < n_elements; i++)
    //*   6   12:iconst_0        
    //*   7   13:istore_2        
    //*   8   14:goto            49
            result.element[i] = element[i] || otherSet.element[i];
    //    9   17:aload_3         
    //   10   18:getfield        #18  <Field boolean[] element>
    //   11   21:iload_2         
    //   12   22:aload_0         
    //   13   23:getfield        #18  <Field boolean[] element>
    //   14   26:iload_2         
    //   15   27:baload          
    //   16   28:ifne            44
    //   17   31:aload_1         
    //   18   32:getfield        #18  <Field boolean[] element>
    //   19   35:iload_2         
    //   20   36:baload          
    //   21   37:ifne            44
    //   22   40:iconst_0        
    //   23   41:goto            45
    //   24   44:iconst_1        
    //   25   45:bastore         

    //   26   46:iinc            2  1
    //   27   49:iload_2         
    //   28   50:aload_0         
    //   29   51:getfield        #16  <Field int n_elements>
    //   30   54:icmplt          17
        return result;
    //   31   57:aload_3         
    //   32   58:areturn         
    }

    public IntegerSet getIntersection(IntegerSet otherSet)
    {
        IntegerSet result = new IntegerSet(n_elements);
    //    0    0:new             #2   <Class IntegerSet>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:getfield        #16  <Field int n_elements>
    //    4    8:invokespecial   #49  <Method void IntegerSet(int)>
    //    5   11:astore_3        
        for(int i = 0; i < n_elements; i++)
    //*   6   12:iconst_0        
    //*   7   13:istore_2        
    //*   8   14:goto            49
            result.element[i] = element[i] && otherSet.element[i];
    //    9   17:aload_3         
    //   10   18:getfield        #18  <Field boolean[] element>
    //   11   21:iload_2         
    //   12   22:aload_0         
    //   13   23:getfield        #18  <Field boolean[] element>
    //   14   26:iload_2         
    //   15   27:baload          
    //   16   28:ifeq            44
    //   17   31:aload_1         
    //   18   32:getfield        #18  <Field boolean[] element>
    //   19   35:iload_2         
    //   20   36:baload          
    //   21   37:ifeq            44
    //   22   40:iconst_1        
    //   23   41:goto            45
    //   24   44:iconst_0        
    //   25   45:bastore         

    //   26   46:iinc            2  1
    //   27   49:iload_2         
    //   28   50:aload_0         
    //   29   51:getfield        #16  <Field int n_elements>
    //   30   54:icmplt          17
        return result;
    //   31   57:aload_3         
    //   32   58:areturn         
    }

    public IntegerSet getDifference(IntegerSet otherSet)
    {
        IntegerSet result = new IntegerSet(n_elements);
    //    0    0:new             #2   <Class IntegerSet>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:getfield        #16  <Field int n_elements>
    //    4    8:invokespecial   #49  <Method void IntegerSet(int)>
    //    5   11:astore_2        
        for(int i = 0; i < n_elements; i++)
    //*   6   12:iconst_0        
    //*   7   13:istore_3        
    //*   8   14:goto            46
            result.element[i] = element[i] != otherSet.element[i];
    //    9   17:aload_2         
    //   10   18:getfield        #18  <Field boolean[] element>
    //   11   21:iload_3         
    //   12   22:aload_0         
    //   13   23:getfield        #18  <Field boolean[] element>
    //   14   26:iload_3         
    //   15   27:baload          
    //   16   28:aload_1         
    //   17   29:getfield        #18  <Field boolean[] element>
    //   18   32:iload_3         
    //   19   33:baload          
    //   20   34:icmpeq          41
    //   21   37:iconst_1        
    //   22   38:goto            42
    //   23   41:iconst_0        
    //   24   42:bastore         

    //   25   43:iinc            3  1
    //   26   46:iload_3         
    //   27   47:aload_0         
    //   28   48:getfield        #16  <Field int n_elements>
    //   29   51:icmplt          17
        return result;
    //   30   54:aload_2         
    //   31   55:areturn         
    }

    public boolean isEmpty()
    {
        for(int i = 0; i < n_elements; i++)
    //*   0    0:iconst_0        
    //*   1    1:istore_1        
    //*   2    2:goto            19
            if(element[i])
    //*   3    5:aload_0         
    //*   4    6:getfield        #18  <Field boolean[] element>
    //*   5    9:iload_1         
    //*   6   10:baload          
    //*   7   11:ifeq            16
                return false;
    //    8   14:iconst_0        
    //    9   15:ireturn         

    //   10   16:iinc            1  1
    //   11   19:iload_1         
    //   12   20:aload_0         
    //   13   21:getfield        #16  <Field int n_elements>
    //   14   24:icmplt          5
        return true;
    //   15   27:iconst_1        
    //   16   28:ireturn         
    }

    public int getSize()
    {
        int result = 0;
    //    0    0:iconst_0        
    //    1    1:istore_2        
        for(int i = 0; i < n_elements; i++)
    //*   2    2:iconst_0        
    //*   3    3:istore_1        
    //*   4    4:goto            22
            if(element[i])
    //*   5    7:aload_0         
    //*   6    8:getfield        #18  <Field boolean[] element>
    //*   7   11:iload_1         
    //*   8   12:baload          
    //*   9   13:ifeq            19
                result++;
    //   10   16:iinc            2  1

    //   11   19:iinc            1  1
    //   12   22:iload_1         
    //   13   23:aload_0         
    //   14   24:getfield        #16  <Field int n_elements>
    //   15   27:icmplt          7
        return result;
    //   16   30:iload_2         
    //   17   31:ireturn         
    }

    public boolean equals(IntegerSet otherSet)
    {
        for(int i = 0; i < n_elements; i++)
    //*   0    0:iconst_0        
    //*   1    1:istore_2        
    //*   2    2:goto            25
            if(element[i] != otherSet.element[i])
    //*   3    5:aload_0         
    //*   4    6:getfield        #18  <Field boolean[] element>
    //*   5    9:iload_2         
    //*   6   10:baload          
    //*   7   11:aload_1         
    //*   8   12:getfield        #18  <Field boolean[] element>
    //*   9   15:iload_2         
    //*  10   16:baload          
    //*  11   17:icmpeq          22
                return false;
    //   12   20:iconst_0        
    //   13   21:ireturn         

    //   14   22:iinc            2  1
    //   15   25:iload_2         
    //   16   26:aload_0         
    //   17   27:getfield        #16  <Field int n_elements>
    //   18   30:icmplt          5
        return true;
    //   19   33:iconst_1        
    //   20   34:ireturn         
    }

    public boolean getElementAt(int i)
    {
        return element[i];
    //    0    0:aload_0         
    //    1    1:getfield        #18  <Field boolean[] element>
    //    2    4:iload_1         
    //    3    5:baload          
    //    4    6:ireturn         
    }

    public int getNelements()
    {
        return n_elements;
    //    0    0:aload_0         
    //    1    1:getfield        #16  <Field int n_elements>
    //    2    4:ireturn         
    }

    private int n_elements;
    private boolean element[];
}
