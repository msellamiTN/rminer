// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   ConceptSet.java

package rm.rolemining.lattice;


// Referenced classes of package rm.rolemining.lattice:
//            Concept

public class ConceptSet
{

    public ConceptSet()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #16  <Method void Object()>
    //    2    4:aload_0         
    //    3    5:sipush          800
    //    4    8:putfield        #18  <Field int MAX_ELEMENTS>
        nbElements = 0;
    //    5   11:aload_0         
    //    6   12:iconst_0        
    //    7   13:putfield        #20  <Field int nbElements>
        element = new Concept[800];
    //    8   16:aload_0         
    //    9   17:sipush          800
    //   10   20:anewarray       Concept[]
    //   11   23:putfield        #24  <Field Concept[] element>
    //   12   26:return          
    }

    public int getNumberOfConcepts()
    {
        return nbElements;
    //    0    0:aload_0         
    //    1    1:getfield        #20  <Field int nbElements>
    //    2    4:ireturn         
    }

    public ConceptSet copy()
    {
        ConceptSet tempConceptSet = new ConceptSet();
    //    0    0:new             #2   <Class ConceptSet>
    //    1    3:dup             
    //    2    4:invokespecial   #33  <Method void ConceptSet()>
    //    3    7:astore_1        
        for(int index = 0; index < nbElements; index++)
    //*   4    8:iconst_0        
    //*   5    9:istore_2        
    //*   6   10:goto            28
            tempConceptSet.addConcept(getConcept(index).Copy());
    //    7   13:aload_1         
    //    8   14:aload_0         
    //    9   15:iload_2         
    //   10   16:invokevirtual   #37  <Method Concept getConcept(int)>
    //   11   19:invokevirtual   #41  <Method Concept Concept.Copy()>
    //   12   22:invokevirtual   #45  <Method void addConcept(Concept)>

    //   13   25:iinc            2  1
    //   14   28:iload_2         
    //   15   29:aload_0         
    //   16   30:getfield        #20  <Field int nbElements>
    //   17   33:icmplt          13
        return tempConceptSet;
    //   18   36:aload_1         
    //   19   37:areturn         
    }

    public boolean contains(Concept searchConcept)
    {
        for(int i = 0; i < nbElements; i++)
    //*   0    0:iconst_0        
    //*   1    1:istore_2        
    //*   2    2:goto            23
            if(element[i].equals(searchConcept))
    //*   3    5:aload_0         
    //*   4    6:getfield        #24  <Field Concept[] element>
    //*   5    9:iload_2         
    //*   6   10:aaload          
    //*   7   11:aload_1         
    //*   8   12:invokevirtual   #52  <Method boolean Concept.equals(Concept)>
    //*   9   15:ifeq            20
                return true;
    //   10   18:iconst_1        
    //   11   19:ireturn         

    //   12   20:iinc            2  1
    //   13   23:iload_2         
    //   14   24:aload_0         
    //   15   25:getfield        #20  <Field int nbElements>
    //   16   28:icmplt          5
        return false;
    //   17   31:iconst_0        
    //   18   32:ireturn         
    }

    public Concept findConcept(Concept searchConcept)
    {
        for(int i = 0; i < nbElements; i++)
    //*   0    0:iconst_0        
    //*   1    1:istore_2        
    //*   2    2:goto            28
            if(element[i].equals(searchConcept))
    //*   3    5:aload_0         
    //*   4    6:getfield        #24  <Field Concept[] element>
    //*   5    9:iload_2         
    //*   6   10:aaload          
    //*   7   11:aload_1         
    //*   8   12:invokevirtual   #52  <Method boolean Concept.equals(Concept)>
    //*   9   15:ifeq            25
                return element[i];
    //   10   18:aload_0         
    //   11   19:getfield        #24  <Field Concept[] element>
    //   12   22:iload_2         
    //   13   23:aaload          
    //   14   24:areturn         

    //   15   25:iinc            2  1
    //   16   28:iload_2         
    //   17   29:aload_0         
    //   18   30:getfield        #20  <Field int nbElements>
    //   19   33:icmplt          5
        return null;
    //   20   36:aconst_null     
    //   21   37:areturn         
    }

    public void addConcept(Concept NewConcept)
    {
        Concept foundConcept = null;
    //    0    0:aconst_null     
    //    1    1:astore_2        
        foundConcept = findConcept(NewConcept);
    //    2    2:aload_0         
    //    3    3:aload_1         
    //    4    4:invokevirtual   #59  <Method Concept findConcept(Concept)>
    //    5    7:astore_2        
        if(foundConcept == null)
    //*   6    8:aload_2         
    //*   7    9:ifnonnull       45
        {
            if(nbElements < 800)
    //*   8   12:aload_0         
    //*   9   13:getfield        #20  <Field int nbElements>
    //*  10   16:sipush          800
    //*  11   19:icmpge          50
            {
                element[nbElements] = NewConcept;
    //   12   22:aload_0         
    //   13   23:getfield        #24  <Field Concept[] element>
    //   14   26:aload_0         
    //   15   27:getfield        #20  <Field int nbElements>
    //   16   30:aload_1         
    //   17   31:aastore         
                nbElements++;
    //   18   32:aload_0         
    //   19   33:dup             
    //   20   34:getfield        #20  <Field int nbElements>
    //   21   37:iconst_1        
    //   22   38:iadd            
    //   23   39:putfield        #20  <Field int nbElements>
            }
        } else
    //*  24   42:goto            50
        {
            foundConcept.mergeWith(NewConcept);
    //   25   45:aload_2         
    //   26   46:aload_1         
    //   27   47:invokevirtual   #62  <Method void Concept.mergeWith(Concept)>
        }
    //   28   50:return          
    }

    public Concept getConcept(int index)
    {
        if(index < nbElements)
    //*   0    0:iload_1         
    //*   1    1:aload_0         
    //*   2    2:getfield        #20  <Field int nbElements>
    //*   3    5:icmpge          15
            return element[index];
    //    4    8:aload_0         
    //    5    9:getfield        #24  <Field Concept[] element>
    //    6   12:iload_1         
    //    7   13:aaload          
    //    8   14:areturn         
        else
            return null;
    //    9   15:aconst_null     
    //   10   16:areturn         
    }

    private final int MAX_ELEMENTS = 800;
    private int nbElements;
    private Concept element[];
}
