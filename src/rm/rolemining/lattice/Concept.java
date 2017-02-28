// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   Concept.java

package rm.rolemining.lattice;


// Referenced classes of package rm.rolemining.lattice:
//            IntegerSet

public class Concept
{

    public Concept()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #18  <Method void Object()>
        allObjects = new IntegerSet();
    //    2    4:aload_0         
    //    3    5:new             #20  <Class IntegerSet>
    //    4    8:dup             
    //    5    9:invokespecial   #21  <Method void IntegerSet()>
    //    6   12:putfield        #23  <Field IntegerSet allObjects>
        allAttributes = new IntegerSet();
    //    7   15:aload_0         
    //    8   16:new             #20  <Class IntegerSet>
    //    9   19:dup             
    //   10   20:invokespecial   #21  <Method void IntegerSet()>
    //   11   23:putfield        #25  <Field IntegerSet allAttributes>
        inducingObjects = new IntegerSet();
    //   12   26:aload_0         
    //   13   27:new             #20  <Class IntegerSet>
    //   14   30:dup             
    //   15   31:invokespecial   #21  <Method void IntegerSet()>
    //   16   34:putfield        #27  <Field IntegerSet inducingObjects>
        inducingAttributes = new IntegerSet();
    //   17   37:aload_0         
    //   18   38:new             #20  <Class IntegerSet>
    //   19   41:dup             
    //   20   42:invokespecial   #21  <Method void IntegerSet()>
    //   21   45:putfield        #29  <Field IntegerSet inducingAttributes>
        removedObjects = new IntegerSet();
    //   22   48:aload_0         
    //   23   49:new             #20  <Class IntegerSet>
    //   24   52:dup             
    //   25   53:invokespecial   #21  <Method void IntegerSet()>
    //   26   56:putfield        #31  <Field IntegerSet removedObjects>
        removedAttributes = new IntegerSet();
    //   27   59:aload_0         
    //   28   60:new             #20  <Class IntegerSet>
    //   29   63:dup             
    //   30   64:invokespecial   #21  <Method void IntegerSet()>
    //   31   67:putfield        #33  <Field IntegerSet removedAttributes>
        associatedLatticeNode = -1;
    //   32   70:aload_0         
    //   33   71:iconst_m1       
    //   34   72:putfield        #35  <Field int associatedLatticeNode>
    //   35   75:return          
    }

    public void addObjects(int formalObject)
    {
        allObjects.addElement(formalObject);
    //    0    0:aload_0         
    //    1    1:getfield        #23  <Field IntegerSet allObjects>
    //    2    4:iload_1         
    //    3    5:invokevirtual   #44  <Method void IntegerSet.addElement(int)>
        removedObjects.addElement(formalObject);
    //    4    8:aload_0         
    //    5    9:getfield        #31  <Field IntegerSet removedObjects>
    //    6   12:iload_1         
    //    7   13:invokevirtual   #44  <Method void IntegerSet.addElement(int)>
    //    8   16:return          
    }

    public void addAttribute(int formalAttribute)
    {
        allAttributes.addElement(formalAttribute);
    //    0    0:aload_0         
    //    1    1:getfield        #25  <Field IntegerSet allAttributes>
    //    2    4:iload_1         
    //    3    5:invokevirtual   #44  <Method void IntegerSet.addElement(int)>
        removedAttributes.addElement(formalAttribute);
    //    4    8:aload_0         
    //    5    9:getfield        #33  <Field IntegerSet removedAttributes>
    //    6   12:iload_1         
    //    7   13:invokevirtual   #44  <Method void IntegerSet.addElement(int)>
    //    8   16:return          
    }

    public void addInducingObject(int formalObject)
    {
        inducingObjects.addElement(formalObject);
    //    0    0:aload_0         
    //    1    1:getfield        #27  <Field IntegerSet inducingObjects>
    //    2    4:iload_1         
    //    3    5:invokevirtual   #44  <Method void IntegerSet.addElement(int)>
    //    4    8:return          
    }

    public void addInducingAttribute(int formalAttribute)
    {
        inducingAttributes.addElement(formalAttribute);
    //    0    0:aload_0         
    //    1    1:getfield        #29  <Field IntegerSet inducingAttributes>
    //    2    4:iload_1         
    //    3    5:invokevirtual   #44  <Method void IntegerSet.addElement(int)>
    //    4    8:return          
    }

    public void mergeWith(Concept inducedConcept)
    {
        inducingObjects.addElements(inducedConcept.inducingObjects);
    //    0    0:aload_0         
    //    1    1:getfield        #27  <Field IntegerSet inducingObjects>
    //    2    4:aload_1         
    //    3    5:getfield        #27  <Field IntegerSet inducingObjects>
    //    4    8:invokevirtual   #55  <Method void IntegerSet.addElements(IntegerSet)>
        inducingAttributes.addElements(inducedConcept.inducingAttributes);
    //    5   11:aload_0         
    //    6   12:getfield        #29  <Field IntegerSet inducingAttributes>
    //    7   15:aload_1         
    //    8   16:getfield        #29  <Field IntegerSet inducingAttributes>
    //    9   19:invokevirtual   #55  <Method void IntegerSet.addElements(IntegerSet)>
        removedObjects.addElements(inducedConcept.removedObjects);
    //   10   22:aload_0         
    //   11   23:getfield        #31  <Field IntegerSet removedObjects>
    //   12   26:aload_1         
    //   13   27:getfield        #31  <Field IntegerSet removedObjects>
    //   14   30:invokevirtual   #55  <Method void IntegerSet.addElements(IntegerSet)>
        removedAttributes.addElements(inducedConcept.removedAttributes);
    //   15   33:aload_0         
    //   16   34:getfield        #33  <Field IntegerSet removedAttributes>
    //   17   37:aload_1         
    //   18   38:getfield        #33  <Field IntegerSet removedAttributes>
    //   19   41:invokevirtual   #55  <Method void IntegerSet.addElements(IntegerSet)>
    //   20   44:return          
    }

    public int getNumberOfObjects()
    {
        return allObjects.getSize();
    //    0    0:aload_0         
    //    1    1:getfield        #23  <Field IntegerSet allObjects>
    //    2    4:invokevirtual   #61  <Method int IntegerSet.getSize()>
    //    3    7:ireturn         
    }

    public int getNumberOfAttributes()
    {
        return allAttributes.getSize();
    //    0    0:aload_0         
    //    1    1:getfield        #25  <Field IntegerSet allAttributes>
    //    2    4:invokevirtual   #61  <Method int IntegerSet.getSize()>
    //    3    7:ireturn         
    }

    public boolean equals(Concept otherConcept)
    {
        return allObjects.equals(otherConcept.allObjects) && allAttributes.equals(otherConcept.allAttributes);
    //    0    0:aload_0         
    //    1    1:getfield        #23  <Field IntegerSet allObjects>
    //    2    4:aload_1         
    //    3    5:getfield        #23  <Field IntegerSet allObjects>
    //    4    8:invokevirtual   #67  <Method boolean IntegerSet.equals(IntegerSet)>
    //    5   11:ifeq            30
    //    6   14:aload_0         
    //    7   15:getfield        #25  <Field IntegerSet allAttributes>
    //    8   18:aload_1         
    //    9   19:getfield        #25  <Field IntegerSet allAttributes>
    //   10   22:invokevirtual   #67  <Method boolean IntegerSet.equals(IntegerSet)>
    //   11   25:ifeq            30
    //   12   28:iconst_1        
    //   13   29:ireturn         
    //   14   30:iconst_0        
    //   15   31:ireturn         
    }

    public Concept Copy()
    {
        Concept newconcept = new Concept();
    //    0    0:new             #2   <Class Concept>
    //    1    3:dup             
    //    2    4:invokespecial   #71  <Method void Concept()>
    //    3    7:astore_1        
        newconcept.allObjects = new IntegerSet(allObjects);
    //    4    8:aload_1         
    //    5    9:new             #20  <Class IntegerSet>
    //    6   12:dup             
    //    7   13:aload_0         
    //    8   14:getfield        #23  <Field IntegerSet allObjects>
    //    9   17:invokespecial   #73  <Method void IntegerSet(IntegerSet)>
    //   10   20:putfield        #23  <Field IntegerSet allObjects>
        newconcept.allAttributes = new IntegerSet(allAttributes);
    //   11   23:aload_1         
    //   12   24:new             #20  <Class IntegerSet>
    //   13   27:dup             
    //   14   28:aload_0         
    //   15   29:getfield        #25  <Field IntegerSet allAttributes>
    //   16   32:invokespecial   #73  <Method void IntegerSet(IntegerSet)>
    //   17   35:putfield        #25  <Field IntegerSet allAttributes>
        newconcept.inducingObjects = new IntegerSet(inducingObjects);
    //   18   38:aload_1         
    //   19   39:new             #20  <Class IntegerSet>
    //   20   42:dup             
    //   21   43:aload_0         
    //   22   44:getfield        #27  <Field IntegerSet inducingObjects>
    //   23   47:invokespecial   #73  <Method void IntegerSet(IntegerSet)>
    //   24   50:putfield        #27  <Field IntegerSet inducingObjects>
        newconcept.inducingAttributes = new IntegerSet(inducingAttributes);
    //   25   53:aload_1         
    //   26   54:new             #20  <Class IntegerSet>
    //   27   57:dup             
    //   28   58:aload_0         
    //   29   59:getfield        #29  <Field IntegerSet inducingAttributes>
    //   30   62:invokespecial   #73  <Method void IntegerSet(IntegerSet)>
    //   31   65:putfield        #29  <Field IntegerSet inducingAttributes>
        newconcept.removedObjects = new IntegerSet(removedObjects);
    //   32   68:aload_1         
    //   33   69:new             #20  <Class IntegerSet>
    //   34   72:dup             
    //   35   73:aload_0         
    //   36   74:getfield        #31  <Field IntegerSet removedObjects>
    //   37   77:invokespecial   #73  <Method void IntegerSet(IntegerSet)>
    //   38   80:putfield        #31  <Field IntegerSet removedObjects>
        newconcept.removedAttributes = new IntegerSet(removedAttributes);
    //   39   83:aload_1         
    //   40   84:new             #20  <Class IntegerSet>
    //   41   87:dup             
    //   42   88:aload_0         
    //   43   89:getfield        #33  <Field IntegerSet removedAttributes>
    //   44   92:invokespecial   #73  <Method void IntegerSet(IntegerSet)>
    //   45   95:putfield        #33  <Field IntegerSet removedAttributes>
        newconcept.associatedLatticeNode = associatedLatticeNode;
    //   46   98:aload_1         
    //   47   99:aload_0         
    //   48  100:getfield        #35  <Field int associatedLatticeNode>
    //   49  103:putfield        #35  <Field int associatedLatticeNode>
        return newconcept;
    //   50  106:aload_1         
    //   51  107:areturn         
    }

    public IntegerSet allObjects;
    public IntegerSet allAttributes;
    protected IntegerSet inducingObjects;
    protected IntegerSet inducingAttributes;
    protected IntegerSet removedObjects;
    protected IntegerSet removedAttributes;
    protected int associatedLatticeNode;
}
