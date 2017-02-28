// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   Context.java

package rm.rolemining.lattice;

import rm.core.Matrix;

// Referenced classes of package rm.rolemining.lattice:
//            IntegerSet, ConceptSet, Concept, ReducedLattices

public class Context
{

    public Context(String obs[], String atts[], Matrix newmat, StringBuffer log)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #20  <Method void Object()>
        c_objects = obs;
    //    2    4:aload_0         
    //    3    5:aload_1         
    //    4    6:putfield        #22  <Field String[] c_objects>
        c_attributes = atts;
    //    5    9:aload_0         
    //    6   10:aload_2         
    //    7   11:putfield        #24  <Field String[] c_attributes>
        noObs = c_objects.length;
    //    8   14:aload_0         
    //    9   15:aload_0         
    //   10   16:getfield        #22  <Field String[] c_objects>
    //   11   19:arraylength     
    //   12   20:putfield        #26  <Field int noObs>
        noAttrs = c_attributes.length;
    //   13   23:aload_0         
    //   14   24:aload_0         
    //   15   25:getfield        #24  <Field String[] c_attributes>
    //   16   28:arraylength     
    //   17   29:putfield        #28  <Field int noAttrs>
        mat = newmat;
    //   18   32:aload_0         
    //   19   33:aload_3         
    //   20   34:putfield        #30  <Field Matrix mat>
        this.log = log;
    //   21   37:aload_0         
    //   22   38:aload           4
    //   23   40:putfield        #32  <Field StringBuffer log>
    //   24   43:return          
    }

    public int getNoObjects()
    {
        return noObs;
    //    0    0:aload_0         
    //    1    1:getfield        #26  <Field int noObs>
    //    2    4:ireturn         
    }

    public int getNoAttributes()
    {
        return noAttrs;
    //    0    0:aload_0         
    //    1    1:getfield        #28  <Field int noAttrs>
    //    2    4:ireturn         
    }

    String getObjectlist(IntegerSet i_objects)
    {
        String strlist = "";
    //    0    0:ldc1            #46  <String "">
    //    1    2:astore_2        
        for(int i = 0; i < noObs; i++)
    //*   2    3:iconst_0        
    //*   3    4:istore_3        
    //*   4    5:goto            48
            if(i_objects.contains(i))
    //*   5    8:aload_1         
    //*   6    9:iload_3         
    //*   7   10:invokevirtual   #52  <Method boolean IntegerSet.contains(int)>
    //*   8   13:ifeq            45
                strlist = (new StringBuilder(String.valueOf(strlist))).append(c_objects[i]).append(", ").toString();
    //    9   16:new             #54  <Class StringBuilder>
    //   10   19:dup             
    //   11   20:aload_2         
    //   12   21:invokestatic    #60  <Method String String.valueOf(Object)>
    //   13   24:invokespecial   #63  <Method void StringBuilder(String)>
    //   14   27:aload_0         
    //   15   28:getfield        #22  <Field String[] c_objects>
    //   16   31:iload_3         
    //   17   32:aaload          
    //   18   33:invokevirtual   #67  <Method StringBuilder StringBuilder.append(String)>
    //   19   36:ldc1            #69  <String ", ">
    //   20   38:invokevirtual   #67  <Method StringBuilder StringBuilder.append(String)>
    //   21   41:invokevirtual   #73  <Method String StringBuilder.toString()>
    //   22   44:astore_2        

    //   23   45:iinc            3  1
    //   24   48:iload_3         
    //   25   49:aload_0         
    //   26   50:getfield        #26  <Field int noObs>
    //   27   53:icmplt          8
        if(!strlist.equals(""))
    //*  28   56:aload_2         
    //*  29   57:ldc1            #46  <String "">
    //*  30   59:invokevirtual   #77  <Method boolean String.equals(Object)>
    //*  31   62:ifne            77
            return strlist.substring(0, strlist.length() - 2);
    //   32   65:aload_2         
    //   33   66:iconst_0        
    //   34   67:aload_2         
    //   35   68:invokevirtual   #80  <Method int String.length()>
    //   36   71:iconst_2        
    //   37   72:isub            
    //   38   73:invokevirtual   #84  <Method String String.substring(int, int)>
    //   39   76:areturn         
        else
            return strlist;
    //   40   77:aload_2         
    //   41   78:areturn         
    }

    String getAttributelist(IntegerSet i_attributes)
    {
        String strlist = "";
    //    0    0:ldc1            #46  <String "">
    //    1    2:astore_2        
        for(int i = 0; i < noAttrs; i++)
    //*   2    3:iconst_0        
    //*   3    4:istore_3        
    //*   4    5:goto            48
            if(i_attributes.contains(i))
    //*   5    8:aload_1         
    //*   6    9:iload_3         
    //*   7   10:invokevirtual   #52  <Method boolean IntegerSet.contains(int)>
    //*   8   13:ifeq            45
                strlist = (new StringBuilder(String.valueOf(strlist))).append(c_attributes[i]).append(", ").toString();
    //    9   16:new             #54  <Class StringBuilder>
    //   10   19:dup             
    //   11   20:aload_2         
    //   12   21:invokestatic    #60  <Method String String.valueOf(Object)>
    //   13   24:invokespecial   #63  <Method void StringBuilder(String)>
    //   14   27:aload_0         
    //   15   28:getfield        #24  <Field String[] c_attributes>
    //   16   31:iload_3         
    //   17   32:aaload          
    //   18   33:invokevirtual   #67  <Method StringBuilder StringBuilder.append(String)>
    //   19   36:ldc1            #69  <String ", ">
    //   20   38:invokevirtual   #67  <Method StringBuilder StringBuilder.append(String)>
    //   21   41:invokevirtual   #73  <Method String StringBuilder.toString()>
    //   22   44:astore_2        

    //   23   45:iinc            3  1
    //   24   48:iload_3         
    //   25   49:aload_0         
    //   26   50:getfield        #28  <Field int noAttrs>
    //   27   53:icmplt          8
        if(!strlist.equals(""))
    //*  28   56:aload_2         
    //*  29   57:ldc1            #46  <String "">
    //*  30   59:invokevirtual   #77  <Method boolean String.equals(Object)>
    //*  31   62:ifne            77
            return strlist.substring(0, strlist.length() - 2);
    //   32   65:aload_2         
    //   33   66:iconst_0        
    //   34   67:aload_2         
    //   35   68:invokevirtual   #80  <Method int String.length()>
    //   36   71:iconst_2        
    //   37   72:isub            
    //   38   73:invokevirtual   #84  <Method String String.substring(int, int)>
    //   39   76:areturn         
        else
            return strlist;
    //   40   77:aload_2         
    //   41   78:areturn         
    }

    public String[] getAllObjects()
    {
        return c_objects;
    //    0    0:aload_0         
    //    1    1:getfield        #22  <Field String[] c_objects>
    //    2    4:areturn         
    }

    public String[] getAllAttributes()
    {
        return c_attributes;
    //    0    0:aload_0         
    //    1    1:getfield        #24  <Field String[] c_attributes>
    //    2    4:areturn         
    }

    public ConceptSet buildLattice(ReducedLattices lattice)
    {
        ConceptSet allConcepts = getAllConcepts();
    //    0    0:aload_0         
    //    1    1:invokevirtual   #100 <Method ConceptSet getAllConcepts()>
    //    2    4:astore_3        
        ConceptSet tempallConcepts = allConcepts.copy();
    //    3    5:aload_3         
    //    4    6:invokevirtual   #105 <Method ConceptSet ConceptSet.copy()>
    //    5    9:astore_2        
        for(int i = 0; i < allConcepts.getNumberOfConcepts(); i++)
    //*   6   10:iconst_0        
    //*   7   11:istore          4
    //*   8   13:goto            30
            addNodeToLattice(lattice, allConcepts.getConcept(i));
    //    9   16:aload_0         
    //   10   17:aload_1         
    //   11   18:aload_3         
    //   12   19:iload           4
    //   13   21:invokevirtual   #109 <Method Concept ConceptSet.getConcept(int)>
    //   14   24:invokespecial   #113 <Method void addNodeToLattice(ReducedLattices, Concept)>

    //   15   27:iinc            4  1
    //   16   30:iload           4
    //   17   32:aload_3         
    //   18   33:invokevirtual   #116 <Method int ConceptSet.getNumberOfConcepts()>
    //   19   36:icmplt          16
        createEdges(lattice, allConcepts);
    //   20   39:aload_0         
    //   21   40:aload_1         
    //   22   41:aload_3         
    //   23   42:invokespecial   #120 <Method void createEdges(ReducedLattices, ConceptSet)>
        return tempallConcepts;
    //   24   45:aload_2         
    //   25   46:areturn         
    }

    public ConceptSet getAllConcepts()
    {
        ConceptSet result = new ConceptSet();
    //    0    0:new             #102 <Class ConceptSet>
    //    1    3:dup             
    //    2    4:invokespecial   #126 <Method void ConceptSet()>
    //    3    7:astore_1        
        for(int i = 0; i < noObs; i++)
    //*   4    8:iconst_0        
    //*   5    9:istore_3        
    //*   6   10:goto            35
        {
            Concept currConcept = getConceptForObject(i);
    //    7   13:aload_0         
    //    8   14:iload_3         
    //    9   15:invokespecial   #129 <Method Concept getConceptForObject(int)>
    //   10   18:astore_2        
            currConcept.inducingObjects.addElement(i);
    //   11   19:aload_2         
    //   12   20:getfield        #134 <Field IntegerSet Concept.inducingObjects>
    //   13   23:iload_3         
    //   14   24:invokevirtual   #138 <Method void IntegerSet.addElement(int)>
            result.addConcept(currConcept);
    //   15   27:aload_1         
    //   16   28:aload_2         
    //   17   29:invokevirtual   #142 <Method void ConceptSet.addConcept(Concept)>
        }

    //   18   32:iinc            3  1
    //   19   35:iload_3         
    //   20   36:aload_0         
    //   21   37:getfield        #26  <Field int noObs>
    //   22   40:icmplt          13
        for(int j = 0; j < noAttrs; j++)
    //*  23   43:iconst_0        
    //*  24   44:istore_3        
    //*  25   45:goto            70
        {
            Concept currConcept = getConceptForAttribute(j);
    //   26   48:aload_0         
    //   27   49:iload_3         
    //   28   50:invokespecial   #145 <Method Concept getConceptForAttribute(int)>
    //   29   53:astore_2        
            currConcept.inducingAttributes.addElement(j);
    //   30   54:aload_2         
    //   31   55:getfield        #148 <Field IntegerSet Concept.inducingAttributes>
    //   32   58:iload_3         
    //   33   59:invokevirtual   #138 <Method void IntegerSet.addElement(int)>
            result.addConcept(currConcept);
    //   34   62:aload_1         
    //   35   63:aload_2         
    //   36   64:invokevirtual   #142 <Method void ConceptSet.addConcept(Concept)>
        }

    //   37   67:iinc            3  1
    //   38   70:iload_3         
    //   39   71:aload_0         
    //   40   72:getfield        #28  <Field int noAttrs>
    //   41   75:icmplt          48
        for(int i = 0; i < result.getNumberOfConcepts(); i++)
    //*  42   78:iconst_0        
    //*  43   79:istore_3        
    //*  44   80:goto            116
        {
            Concept currConcept = result.getConcept(i);
    //   45   83:aload_1         
    //   46   84:iload_3         
    //   47   85:invokevirtual   #109 <Method Concept ConceptSet.getConcept(int)>
    //   48   88:astore_2        
            currConcept.removedObjects.removeElements(currConcept.inducingObjects);
    //   49   89:aload_2         
    //   50   90:getfield        #151 <Field IntegerSet Concept.removedObjects>
    //   51   93:aload_2         
    //   52   94:getfield        #134 <Field IntegerSet Concept.inducingObjects>
    //   53   97:invokevirtual   #155 <Method IntegerSet IntegerSet.removeElements(IntegerSet)>
    //   54  100:pop             
            currConcept.removedAttributes.removeElements(currConcept.inducingAttributes);
    //   55  101:aload_2         
    //   56  102:getfield        #158 <Field IntegerSet Concept.removedAttributes>
    //   57  105:aload_2         
    //   58  106:getfield        #148 <Field IntegerSet Concept.inducingAttributes>
    //   59  109:invokevirtual   #155 <Method IntegerSet IntegerSet.removeElements(IntegerSet)>
    //   60  112:pop             
        }

    //   61  113:iinc            3  1
    //   62  116:iload_3         
    //   63  117:aload_1         
    //   64  118:invokevirtual   #116 <Method int ConceptSet.getNumberOfConcepts()>
    //   65  121:icmplt          83
        log.append("\n");
    //   66  124:aload_0         
    //   67  125:getfield        #32  <Field StringBuffer log>
    //   68  128:ldc1            #160 <String "\n">
    //   69  130:invokevirtual   #165 <Method StringBuffer StringBuffer.append(String)>
    //   70  133:pop             
        return result;
    //   71  134:aload_1         
    //   72  135:areturn         
    }

    private Concept getConceptForObject(int index)
    {
        Concept result = new Concept();
    //    0    0:new             #131 <Class Concept>
    //    1    3:dup             
    //    2    4:invokespecial   #170 <Method void Concept()>
    //    3    7:astore_2        
        IntegerSet allAttributes = getAllAttributesForObject(index);
    //    4    8:aload_0         
    //    5    9:iload_1         
    //    6   10:invokevirtual   #174 <Method IntegerSet getAllAttributesForObject(int)>
    //    7   13:astore          4
        IntegerSet allObjects = getAllCommonAttributes(allAttributes);
    //    8   15:aload_0         
    //    9   16:aload           4
    //   10   18:invokevirtual   #177 <Method IntegerSet getAllCommonAttributes(IntegerSet)>
    //   11   21:astore          5
        result.addObjects(index);
    //   12   23:aload_2         
    //   13   24:iload_1         
    //   14   25:invokevirtual   #180 <Method void Concept.addObjects(int)>
        for(int i = 0; i < 800; i++)
    //*  15   28:iconst_0        
    //*  16   29:istore_3        
    //*  17   30:goto            50
            if(allAttributes.contains(i))
    //*  18   33:aload           4
    //*  19   35:iload_3         
    //*  20   36:invokevirtual   #52  <Method boolean IntegerSet.contains(int)>
    //*  21   39:ifeq            47
                result.addAttribute(i);
    //   22   42:aload_2         
    //   23   43:iload_3         
    //   24   44:invokevirtual   #183 <Method void Concept.addAttribute(int)>

    //   25   47:iinc            3  1
    //   26   50:iload_3         
    //   27   51:sipush          800
    //   28   54:icmplt          33
        for(int i = 0; i < 800; i++)
    //*  29   57:iconst_0        
    //*  30   58:istore_3        
    //*  31   59:goto            79
            if(allObjects.contains(i))
    //*  32   62:aload           5
    //*  33   64:iload_3         
    //*  34   65:invokevirtual   #52  <Method boolean IntegerSet.contains(int)>
    //*  35   68:ifeq            76
                result.addObjects(i);
    //   36   71:aload_2         
    //   37   72:iload_3         
    //   38   73:invokevirtual   #180 <Method void Concept.addObjects(int)>

    //   39   76:iinc            3  1
    //   40   79:iload_3         
    //   41   80:sipush          800
    //   42   83:icmplt          62
        return result;
    //   43   86:aload_2         
    //   44   87:areturn         
    }

    private Concept getConceptForAttribute(int index)
    {
        Concept result = new Concept();
    //    0    0:new             #131 <Class Concept>
    //    1    3:dup             
    //    2    4:invokespecial   #170 <Method void Concept()>
    //    3    7:astore_2        
        IntegerSet allObjects = getAllObjectsForAttribute(index);
    //    4    8:aload_0         
    //    5    9:iload_1         
    //    6   10:invokevirtual   #189 <Method IntegerSet getAllObjectsForAttribute(int)>
    //    7   13:astore          5
        IntegerSet allAttributes = getAllCommonObjects(allObjects);
    //    8   15:aload_0         
    //    9   16:aload           5
    //   10   18:invokevirtual   #192 <Method IntegerSet getAllCommonObjects(IntegerSet)>
    //   11   21:astore          4
        result.addAttribute(index);
    //   12   23:aload_2         
    //   13   24:iload_1         
    //   14   25:invokevirtual   #183 <Method void Concept.addAttribute(int)>
        for(int i = 0; i < 800; i++)
    //*  15   28:iconst_0        
    //*  16   29:istore_3        
    //*  17   30:goto            50
            if(allAttributes.contains(i))
    //*  18   33:aload           4
    //*  19   35:iload_3         
    //*  20   36:invokevirtual   #52  <Method boolean IntegerSet.contains(int)>
    //*  21   39:ifeq            47
                result.addAttribute(i);
    //   22   42:aload_2         
    //   23   43:iload_3         
    //   24   44:invokevirtual   #183 <Method void Concept.addAttribute(int)>

    //   25   47:iinc            3  1
    //   26   50:iload_3         
    //   27   51:sipush          800
    //   28   54:icmplt          33
        for(int i = 0; i < 800; i++)
    //*  29   57:iconst_0        
    //*  30   58:istore_3        
    //*  31   59:goto            79
            if(allObjects.contains(i))
    //*  32   62:aload           5
    //*  33   64:iload_3         
    //*  34   65:invokevirtual   #52  <Method boolean IntegerSet.contains(int)>
    //*  35   68:ifeq            76
                result.addObjects(i);
    //   36   71:aload_2         
    //   37   72:iload_3         
    //   38   73:invokevirtual   #180 <Method void Concept.addObjects(int)>

    //   39   76:iinc            3  1
    //   40   79:iload_3         
    //   41   80:sipush          800
    //   42   83:icmplt          62
        return result;
    //   43   86:aload_2         
    //   44   87:areturn         
    }

    public IntegerSet getAllAttributesForObject(int o)
    {
        IntegerSet result = new IntegerSet();
    //    0    0:new             #48  <Class IntegerSet>
    //    1    3:dup             
    //    2    4:invokespecial   #193 <Method void IntegerSet()>
    //    3    7:astore_2        
        for(int i = 0; i < noAttrs; i++)
    //*   4    8:iconst_0        
    //*   5    9:istore_3        
    //*   6   10:goto            34
            if(mat.get(o, i) == 1)
    //*   7   13:aload_0         
    //*   8   14:getfield        #30  <Field Matrix mat>
    //*   9   17:iload_1         
    //*  10   18:iload_3         
    //*  11   19:invokevirtual   #199 <Method byte Matrix.get(int, int)>
    //*  12   22:iconst_1        
    //*  13   23:icmpne          31
                result.addElement(i);
    //   14   26:aload_2         
    //   15   27:iload_3         
    //   16   28:invokevirtual   #138 <Method void IntegerSet.addElement(int)>

    //   17   31:iinc            3  1
    //   18   34:iload_3         
    //   19   35:aload_0         
    //   20   36:getfield        #28  <Field int noAttrs>
    //   21   39:icmplt          13
        return result;
    //   22   42:aload_2         
    //   23   43:areturn         
    }

    public IntegerSet getAllObjectsForAttribute(int a)
    {
        IntegerSet result = new IntegerSet();
    //    0    0:new             #48  <Class IntegerSet>
    //    1    3:dup             
    //    2    4:invokespecial   #193 <Method void IntegerSet()>
    //    3    7:astore_2        
        for(int i = 0; i < noObs; i++)
    //*   4    8:iconst_0        
    //*   5    9:istore_3        
    //*   6   10:goto            34
            if(mat.get(i, a) == 1)
    //*   7   13:aload_0         
    //*   8   14:getfield        #30  <Field Matrix mat>
    //*   9   17:iload_3         
    //*  10   18:iload_1         
    //*  11   19:invokevirtual   #199 <Method byte Matrix.get(int, int)>
    //*  12   22:iconst_1        
    //*  13   23:icmpne          31
                result.addElement(i);
    //   14   26:aload_2         
    //   15   27:iload_3         
    //   16   28:invokevirtual   #138 <Method void IntegerSet.addElement(int)>

    //   17   31:iinc            3  1
    //   18   34:iload_3         
    //   19   35:aload_0         
    //   20   36:getfield        #26  <Field int noObs>
    //   21   39:icmplt          13
        return result;
    //   22   42:aload_2         
    //   23   43:areturn         
    }

    public IntegerSet getAllCommonAttributes(IntegerSet attributeSet)
    {
        IntegerSet result = new IntegerSet();
    //    0    0:new             #48  <Class IntegerSet>
    //    1    3:dup             
    //    2    4:invokespecial   #193 <Method void IntegerSet()>
    //    3    7:astore_2        
        for(int i = 0; i < noAttrs; i++)
    //*   4    8:iconst_0        
    //*   5    9:istore          4
    //*   6   11:goto            91
            if(attributeSet.contains(i))
    //*   7   14:aload_1         
    //*   8   15:iload           4
    //*   9   17:invokevirtual   #52  <Method boolean IntegerSet.contains(int)>
    //*  10   20:ifeq            88
            {
                IntegerSet current = new IntegerSet();
    //   11   23:new             #48  <Class IntegerSet>
    //   12   26:dup             
    //   13   27:invokespecial   #193 <Method void IntegerSet()>
    //   14   30:astore_3        
                for(int j = 0; j < noObs; j++)
    //*  15   31:iconst_0        
    //*  16   32:istore          5
    //*  17   34:goto            61
                    if(mat.get(j, i) == 1)
    //*  18   37:aload_0         
    //*  19   38:getfield        #30  <Field Matrix mat>
    //*  20   41:iload           5
    //*  21   43:iload           4
    //*  22   45:invokevirtual   #199 <Method byte Matrix.get(int, int)>
    //*  23   48:iconst_1        
    //*  24   49:icmpne          58
                        current.addElement(j);
    //   25   52:aload_3         
    //   26   53:iload           5
    //   27   55:invokevirtual   #138 <Method void IntegerSet.addElement(int)>

    //   28   58:iinc            5  1
    //   29   61:iload           5
    //   30   63:aload_0         
    //   31   64:getfield        #26  <Field int noObs>
    //   32   67:icmplt          37
                if(result.isEmpty())
    //*  33   70:aload_2         
    //*  34   71:invokevirtual   #205 <Method boolean IntegerSet.isEmpty()>
    //*  35   74:ifeq            82
                    result = current;
    //   36   77:aload_3         
    //   37   78:astore_2        
                else
    //*  38   79:goto            88
                    result = result.getIntersection(current);
    //   39   82:aload_2         
    //   40   83:aload_3         
    //   41   84:invokevirtual   #208 <Method IntegerSet IntegerSet.getIntersection(IntegerSet)>
    //   42   87:astore_2        
            }

    //   43   88:iinc            4  1
    //   44   91:iload           4
    //   45   93:aload_0         
    //   46   94:getfield        #28  <Field int noAttrs>
    //   47   97:icmplt          14
        return result;
    //   48  100:aload_2         
    //   49  101:areturn         
    }

    public IntegerSet getAllCommonObjects(IntegerSet objectSet)
    {
        IntegerSet result = new IntegerSet();
    //    0    0:new             #48  <Class IntegerSet>
    //    1    3:dup             
    //    2    4:invokespecial   #193 <Method void IntegerSet()>
    //    3    7:astore_2        
        for(int i = 0; i < noObs; i++)
    //*   4    8:iconst_0        
    //*   5    9:istore          4
    //*   6   11:goto            91
            if(objectSet.contains(i))
    //*   7   14:aload_1         
    //*   8   15:iload           4
    //*   9   17:invokevirtual   #52  <Method boolean IntegerSet.contains(int)>
    //*  10   20:ifeq            88
            {
                IntegerSet current = new IntegerSet();
    //   11   23:new             #48  <Class IntegerSet>
    //   12   26:dup             
    //   13   27:invokespecial   #193 <Method void IntegerSet()>
    //   14   30:astore_3        
                for(int j = 0; j < noAttrs; j++)
    //*  15   31:iconst_0        
    //*  16   32:istore          5
    //*  17   34:goto            61
                    if(mat.get(i, j) == 1)
    //*  18   37:aload_0         
    //*  19   38:getfield        #30  <Field Matrix mat>
    //*  20   41:iload           4
    //*  21   43:iload           5
    //*  22   45:invokevirtual   #199 <Method byte Matrix.get(int, int)>
    //*  23   48:iconst_1        
    //*  24   49:icmpne          58
                        current.addElement(j);
    //   25   52:aload_3         
    //   26   53:iload           5
    //   27   55:invokevirtual   #138 <Method void IntegerSet.addElement(int)>

    //   28   58:iinc            5  1
    //   29   61:iload           5
    //   30   63:aload_0         
    //   31   64:getfield        #28  <Field int noAttrs>
    //   32   67:icmplt          37
                if(result.isEmpty())
    //*  33   70:aload_2         
    //*  34   71:invokevirtual   #205 <Method boolean IntegerSet.isEmpty()>
    //*  35   74:ifeq            82
                    result = current;
    //   36   77:aload_3         
    //   37   78:astore_2        
                else
    //*  38   79:goto            88
                    result = result.getIntersection(current);
    //   39   82:aload_2         
    //   40   83:aload_3         
    //   41   84:invokevirtual   #208 <Method IntegerSet IntegerSet.getIntersection(IntegerSet)>
    //   42   87:astore_2        
            }

    //   43   88:iinc            4  1
    //   44   91:iload           4
    //   45   93:aload_0         
    //   46   94:getfield        #26  <Field int noObs>
    //   47   97:icmplt          14
        return result;
    //   48  100:aload_2         
    //   49  101:areturn         
    }

    public String conceptToString(Concept concept)
    {
        String result = (new StringBuilder("Concept=({")).append(getObjectlist(concept.allObjects)).append("}; {").append(getAttributelist(concept.allAttributes)).append("})").toString();
    //    0    0:new             #54  <Class StringBuilder>
    //    1    3:dup             
    //    2    4:ldc1            #215 <String "Concept=({">
    //    3    6:invokespecial   #63  <Method void StringBuilder(String)>
    //    4    9:aload_0         
    //    5   10:aload_1         
    //    6   11:getfield        #217 <Field IntegerSet Concept.allObjects>
    //    7   14:invokevirtual   #219 <Method String getObjectlist(IntegerSet)>
    //    8   17:invokevirtual   #67  <Method StringBuilder StringBuilder.append(String)>
    //    9   20:ldc1            #221 <String "}; {">
    //   10   22:invokevirtual   #67  <Method StringBuilder StringBuilder.append(String)>
    //   11   25:aload_0         
    //   12   26:aload_1         
    //   13   27:getfield        #223 <Field IntegerSet Concept.allAttributes>
    //   14   30:invokevirtual   #225 <Method String getAttributelist(IntegerSet)>
    //   15   33:invokevirtual   #67  <Method StringBuilder StringBuilder.append(String)>
    //   16   36:ldc1            #227 <String "})">
    //   17   38:invokevirtual   #67  <Method StringBuilder StringBuilder.append(String)>
    //   18   41:invokevirtual   #73  <Method String StringBuilder.toString()>
    //   19   44:astore_2        
        result = (new StringBuilder(String.valueOf(result))).append("\n\t\tinduced by ({").append(getObjectlist(concept.inducingObjects)).append("}; {").append(getAttributelist(concept.inducingAttributes)).append("}").toString();
    //   20   45:new             #54  <Class StringBuilder>
    //   21   48:dup             
    //   22   49:aload_2         
    //   23   50:invokestatic    #60  <Method String String.valueOf(Object)>
    //   24   53:invokespecial   #63  <Method void StringBuilder(String)>
    //   25   56:ldc1            #229 <String "\n\t\tinduced by ({">
    //   26   58:invokevirtual   #67  <Method StringBuilder StringBuilder.append(String)>
    //   27   61:aload_0         
    //   28   62:aload_1         
    //   29   63:getfield        #134 <Field IntegerSet Concept.inducingObjects>
    //   30   66:invokevirtual   #219 <Method String getObjectlist(IntegerSet)>
    //   31   69:invokevirtual   #67  <Method StringBuilder StringBuilder.append(String)>
    //   32   72:ldc1            #221 <String "}; {">
    //   33   74:invokevirtual   #67  <Method StringBuilder StringBuilder.append(String)>
    //   34   77:aload_0         
    //   35   78:aload_1         
    //   36   79:getfield        #148 <Field IntegerSet Concept.inducingAttributes>
    //   37   82:invokevirtual   #225 <Method String getAttributelist(IntegerSet)>
    //   38   85:invokevirtual   #67  <Method StringBuilder StringBuilder.append(String)>
    //   39   88:ldc1            #231 <String "}">
    //   40   90:invokevirtual   #67  <Method StringBuilder StringBuilder.append(String)>
    //   41   93:invokevirtual   #73  <Method String StringBuilder.toString()>
    //   42   96:astore_2        
        result = (new StringBuilder(String.valueOf(result))).append(")\n\t\tremoved: ({").append(getObjectlist(concept.removedObjects)).append("}; {").append(getAttributelist(concept.removedAttributes)).append("})").toString();
    //   43   97:new             #54  <Class StringBuilder>
    //   44  100:dup             
    //   45  101:aload_2         
    //   46  102:invokestatic    #60  <Method String String.valueOf(Object)>
    //   47  105:invokespecial   #63  <Method void StringBuilder(String)>
    //   48  108:ldc1            #233 <String ")\n\t\tremoved: ({">
    //   49  110:invokevirtual   #67  <Method StringBuilder StringBuilder.append(String)>
    //   50  113:aload_0         
    //   51  114:aload_1         
    //   52  115:getfield        #151 <Field IntegerSet Concept.removedObjects>
    //   53  118:invokevirtual   #219 <Method String getObjectlist(IntegerSet)>
    //   54  121:invokevirtual   #67  <Method StringBuilder StringBuilder.append(String)>
    //   55  124:ldc1            #221 <String "}; {">
    //   56  126:invokevirtual   #67  <Method StringBuilder StringBuilder.append(String)>
    //   57  129:aload_0         
    //   58  130:aload_1         
    //   59  131:getfield        #158 <Field IntegerSet Concept.removedAttributes>
    //   60  134:invokevirtual   #225 <Method String getAttributelist(IntegerSet)>
    //   61  137:invokevirtual   #67  <Method StringBuilder StringBuilder.append(String)>
    //   62  140:ldc1            #227 <String "})">
    //   63  142:invokevirtual   #67  <Method StringBuilder StringBuilder.append(String)>
    //   64  145:invokevirtual   #73  <Method String StringBuilder.toString()>
    //   65  148:astore_2        
        return result;
    //   66  149:aload_2         
    //   67  150:areturn         
    }

    private void addNodeToLattice(ReducedLattices lattice, Concept currConcept)
    {
        int nodeIdx = lattice.addNode(currConcept.inducingObjects, currConcept.inducingAttributes, currConcept.removedObjects, currConcept.removedAttributes);
    //    0    0:aload_1         
    //    1    1:aload_2         
    //    2    2:getfield        #134 <Field IntegerSet Concept.inducingObjects>
    //    3    5:aload_2         
    //    4    6:getfield        #148 <Field IntegerSet Concept.inducingAttributes>
    //    5    9:aload_2         
    //    6   10:getfield        #151 <Field IntegerSet Concept.removedObjects>
    //    7   13:aload_2         
    //    8   14:getfield        #158 <Field IntegerSet Concept.removedAttributes>
    //    9   17:invokevirtual   #240 <Method int ReducedLattices.addNode(IntegerSet, IntegerSet, IntegerSet, IntegerSet)>
    //   10   20:istore_3        
        currConcept.associatedLatticeNode = nodeIdx;
    //   11   21:aload_2         
    //   12   22:iload_3         
    //   13   23:putfield        #243 <Field int Concept.associatedLatticeNode>
    //   14   26:return          
    }

    private void createEdges(ReducedLattices lattice, ConceptSet allConcepts)
    {
        IntegerSet nodeWithAncessors = new IntegerSet();
    //    0    0:new             #48  <Class IntegerSet>
    //    1    3:dup             
    //    2    4:invokespecial   #193 <Method void IntegerSet()>
    //    3    7:astore_3        
        IntegerSet nodeWithSuccessors = new IntegerSet();
    //    4    8:new             #48  <Class IntegerSet>
    //    5   11:dup             
    //    6   12:invokespecial   #193 <Method void IntegerSet()>
    //    7   15:astore          4
        Concept infimum = null;
    //    8   17:aconst_null     
    //    9   18:astore          14
        Concept supremum = null;
    //   10   20:aconst_null     
    //   11   21:astore          15
        IntegerSet fromSet = new IntegerSet();
    //   12   23:new             #48  <Class IntegerSet>
    //   13   26:dup             
    //   14   27:invokespecial   #193 <Method void IntegerSet()>
    //   15   30:astore          17
        IntegerSet toSet = new IntegerSet();
    //   16   32:new             #48  <Class IntegerSet>
    //   17   35:dup             
    //   18   36:invokespecial   #193 <Method void IntegerSet()>
    //   19   39:astore          18
        IntegerSet nextNodes = null;
    //   20   41:aconst_null     
    //   21   42:astore          20
        int yLevel = 0;
    //   22   44:iconst_0        
    //   23   45:istore          21
        for(int i = 0; i < allConcepts.getNumberOfConcepts(); i++)
    //*  24   47:iconst_0        
    //*  25   48:istore          16
    //*  26   50:goto            124
        {
            Concept outerConcept = allConcepts.getConcept(i);
    //   27   53:aload_2         
    //   28   54:iload           16
    //   29   56:invokevirtual   #109 <Method Concept ConceptSet.getConcept(int)>
    //   30   59:astore          5
            if(outerConcept.allObjects.getSize() == noObs || outerConcept.allAttributes.isEmpty())
    //*  31   61:aload           5
    //*  32   63:getfield        #217 <Field IntegerSet Concept.allObjects>
    //*  33   66:invokevirtual   #247 <Method int IntegerSet.getSize()>
    //*  34   69:aload_0         
    //*  35   70:getfield        #26  <Field int noObs>
    //*  36   73:icmpeq          87
    //*  37   76:aload           5
    //*  38   78:getfield        #223 <Field IntegerSet Concept.allAttributes>
    //*  39   81:invokevirtual   #205 <Method boolean IntegerSet.isEmpty()>
    //*  40   84:ifeq            91
                supremum = outerConcept;
    //   41   87:aload           5
    //   42   89:astore          15
            if(outerConcept.allAttributes.getSize() == noAttrs || outerConcept.allObjects.isEmpty())
    //*  43   91:aload           5
    //*  44   93:getfield        #223 <Field IntegerSet Concept.allAttributes>
    //*  45   96:invokevirtual   #247 <Method int IntegerSet.getSize()>
    //*  46   99:aload_0         
    //*  47  100:getfield        #28  <Field int noAttrs>
    //*  48  103:icmpeq          117
    //*  49  106:aload           5
    //*  50  108:getfield        #217 <Field IntegerSet Concept.allObjects>
    //*  51  111:invokevirtual   #205 <Method boolean IntegerSet.isEmpty()>
    //*  52  114:ifeq            121
                infimum = outerConcept;
    //   53  117:aload           5
    //   54  119:astore          14
        }

    //   55  121:iinc            16  1
    //   56  124:iload           16
    //   57  126:aload_2         
    //   58  127:invokevirtual   #116 <Method int ConceptSet.getNumberOfConcepts()>
    //   59  130:icmplt          53
        for(int i = 0; i < allConcepts.getNumberOfConcepts(); i++)
    //*  60  133:iconst_0        
    //*  61  134:istore          16
    //*  62  136:goto            371
        {
            Concept outerConcept = allConcepts.getConcept(i);
    //   63  139:aload_2         
    //   64  140:iload           16
    //   65  142:invokevirtual   #109 <Method Concept ConceptSet.getConcept(int)>
    //   66  145:astore          5
            if(outerConcept != infimum && outerConcept != supremum)
    //*  67  147:aload           5
    //*  68  149:aload           14
    //*  69  151:if_acmpeq       368
    //*  70  154:aload           5
    //*  71  156:aload           15
    //*  72  158:if_acmpne       164
    //*  73  161:goto            368
            {
                IntegerSet outerObjects = outerConcept.removedObjects;
    //   74  164:aload           5
    //   75  166:getfield        #151 <Field IntegerSet Concept.removedObjects>
    //   76  169:astore          11
                IntegerSet outerAttribs = outerConcept.removedAttributes;
    //   77  171:aload           5
    //   78  173:getfield        #158 <Field IntegerSet Concept.removedAttributes>
    //   79  176:astore          10
                boolean hasRemovedAttributes = !outerConcept.removedAttributes.isEmpty();
    //   80  178:aload           5
    //   81  180:getfield        #158 <Field IntegerSet Concept.removedAttributes>
    //   82  183:invokevirtual   #205 <Method boolean IntegerSet.isEmpty()>
    //   83  186:ifeq            193
    //   84  189:iconst_0        
    //   85  190:goto            194
    //   86  193:iconst_1        
    //   87  194:istore          7
                boolean hasRemovedObjects = !outerConcept.removedObjects.isEmpty();
    //   88  196:aload           5
    //   89  198:getfield        #151 <Field IntegerSet Concept.removedObjects>
    //   90  201:invokevirtual   #205 <Method boolean IntegerSet.isEmpty()>
    //   91  204:ifeq            211
    //   92  207:iconst_0        
    //   93  208:goto            212
    //   94  211:iconst_1        
    //   95  212:istore          8
                if(hasRemovedAttributes || hasRemovedObjects)
    //*  96  214:iload           7
    //*  97  216:ifne            227
    //*  98  219:iload           8
    //*  99  221:ifne            227
    //* 100  224:goto            368
                {
                    for(int j = 0; j < allConcepts.getNumberOfConcepts(); j++)
    //* 101  227:iconst_0        
    //* 102  228:istore          22
    //* 103  230:goto            359
                        if(j != i)
    //* 104  233:iload           22
    //* 105  235:iload           16
    //* 106  237:icmpne          243
    //* 107  240:goto            356
                        {
                            Concept innerConcept = allConcepts.getConcept(j);
    //  108  243:aload_2         
    //  109  244:iload           22
    //  110  246:invokevirtual   #109 <Method Concept ConceptSet.getConcept(int)>
    //  111  249:astore          6
                            if(innerConcept != infimum && innerConcept != supremum)
    //* 112  251:aload           6
    //* 113  253:aload           14
    //* 114  255:if_acmpeq       356
    //* 115  258:aload           6
    //* 116  260:aload           15
    //* 117  262:if_acmpne       268
    //* 118  265:goto            356
                            {
                                IntegerSet innerObjects = innerConcept.inducingObjects;
    //  119  268:aload           6
    //  120  270:getfield        #134 <Field IntegerSet Concept.inducingObjects>
    //  121  273:astore          13
                                IntegerSet innerAttribs = innerConcept.inducingAttributes;
    //  122  275:aload           6
    //  123  277:getfield        #148 <Field IntegerSet Concept.inducingAttributes>
    //  124  280:astore          12
                                if(hasRemovedAttributes)
    //* 125  282:iload           7
    //* 126  284:ifeq            319
                                {
                                    IntegerSet intersec = outerAttribs.getIntersection(innerAttribs);
    //  127  287:aload           10
    //  128  289:aload           12
    //  129  291:invokevirtual   #208 <Method IntegerSet IntegerSet.getIntersection(IntegerSet)>
    //  130  294:astore          9
                                    if(!intersec.isEmpty())
    //* 131  296:aload           9
    //* 132  298:invokevirtual   #205 <Method boolean IntegerSet.isEmpty()>
    //* 133  301:ifne            319
                                        lattice.addEdge(innerConcept.associatedLatticeNode, outerConcept.associatedLatticeNode);
    //  134  304:aload_1         
    //  135  305:aload           6
    //  136  307:getfield        #243 <Field int Concept.associatedLatticeNode>
    //  137  310:aload           5
    //  138  312:getfield        #243 <Field int Concept.associatedLatticeNode>
    //  139  315:invokevirtual   #251 <Method int ReducedLattices.addEdge(int, int)>
    //  140  318:pop             
                                }
                                if(hasRemovedObjects)
    //* 141  319:iload           8
    //* 142  321:ifeq            356
                                {
                                    IntegerSet intersec = outerObjects.getIntersection(innerObjects);
    //  143  324:aload           11
    //  144  326:aload           13
    //  145  328:invokevirtual   #208 <Method IntegerSet IntegerSet.getIntersection(IntegerSet)>
    //  146  331:astore          9
                                    if(!intersec.isEmpty())
    //* 147  333:aload           9
    //* 148  335:invokevirtual   #205 <Method boolean IntegerSet.isEmpty()>
    //* 149  338:ifne            356
                                        lattice.addEdge(outerConcept.associatedLatticeNode, innerConcept.associatedLatticeNode);
    //  150  341:aload_1         
    //  151  342:aload           5
    //  152  344:getfield        #243 <Field int Concept.associatedLatticeNode>
    //  153  347:aload           6
    //  154  349:getfield        #243 <Field int Concept.associatedLatticeNode>
    //  155  352:invokevirtual   #251 <Method int ReducedLattices.addEdge(int, int)>
    //  156  355:pop             
                                }
                            }
                        }

    //  157  356:iinc            22  1
    //  158  359:iload           22
    //  159  361:aload_2         
    //  160  362:invokevirtual   #116 <Method int ConceptSet.getNumberOfConcepts()>
    //  161  365:icmplt          233
                }
            }
        }

    //  162  368:iinc            16  1
    //  163  371:iload           16
    //  164  373:aload_2         
    //  165  374:invokevirtual   #116 <Method int ConceptSet.getNumberOfConcepts()>
    //  166  377:icmplt          139
        for(int i = 0; i < lattice.getNumberOfEdges(); i++)
    //* 167  380:iconst_0        
    //* 168  381:istore          16
    //* 169  383:goto            417
        {
            fromSet.addElement(lattice.getEdge(i).from);
    //  170  386:aload           17
    //  171  388:aload_1         
    //  172  389:iload           16
    //  173  391:invokevirtual   #255 <Method ReducedLattices$LatticeEdge ReducedLattices.getEdge(int)>
    //  174  394:getfield        #260 <Field int ReducedLattices$LatticeEdge.from>
    //  175  397:invokevirtual   #138 <Method void IntegerSet.addElement(int)>
            toSet.addElement(lattice.getEdge(i).to);
    //  176  400:aload           18
    //  177  402:aload_1         
    //  178  403:iload           16
    //  179  405:invokevirtual   #255 <Method ReducedLattices$LatticeEdge ReducedLattices.getEdge(int)>
    //  180  408:getfield        #263 <Field int ReducedLattices$LatticeEdge.to>
    //  181  411:invokevirtual   #138 <Method void IntegerSet.addElement(int)>
        }

    //  182  414:iinc            16  1
    //  183  417:iload           16
    //  184  419:aload_1         
    //  185  420:invokevirtual   #266 <Method int ReducedLattices.getNumberOfEdges()>
    //  186  423:icmplt          386
        if(supremum == null)
    //* 187  426:aload           15
    //* 188  428:ifnonnull       477
        {
            supremum = new Concept();
    //  189  431:new             #131 <Class Concept>
    //  190  434:dup             
    //  191  435:invokespecial   #170 <Method void Concept()>
    //  192  438:astore          15
            supremum.associatedLatticeNode = lattice.addNode(new IntegerSet(), new IntegerSet(), new IntegerSet(), new IntegerSet());
    //  193  440:aload           15
    //  194  442:aload_1         
    //  195  443:new             #48  <Class IntegerSet>
    //  196  446:dup             
    //  197  447:invokespecial   #193 <Method void IntegerSet()>
    //  198  450:new             #48  <Class IntegerSet>
    //  199  453:dup             
    //  200  454:invokespecial   #193 <Method void IntegerSet()>
    //  201  457:new             #48  <Class IntegerSet>
    //  202  460:dup             
    //  203  461:invokespecial   #193 <Method void IntegerSet()>
    //  204  464:new             #48  <Class IntegerSet>
    //  205  467:dup             
    //  206  468:invokespecial   #193 <Method void IntegerSet()>
    //  207  471:invokevirtual   #240 <Method int ReducedLattices.addNode(IntegerSet, IntegerSet, IntegerSet, IntegerSet)>
    //  208  474:putfield        #243 <Field int Concept.associatedLatticeNode>
        }
        if(infimum == null)
    //* 209  477:aload           14
    //* 210  479:ifnonnull       528
        {
            infimum = new Concept();
    //  211  482:new             #131 <Class Concept>
    //  212  485:dup             
    //  213  486:invokespecial   #170 <Method void Concept()>
    //  214  489:astore          14
            infimum.associatedLatticeNode = lattice.addNode(new IntegerSet(), new IntegerSet(), new IntegerSet(), new IntegerSet());
    //  215  491:aload           14
    //  216  493:aload_1         
    //  217  494:new             #48  <Class IntegerSet>
    //  218  497:dup             
    //  219  498:invokespecial   #193 <Method void IntegerSet()>
    //  220  501:new             #48  <Class IntegerSet>
    //  221  504:dup             
    //  222  505:invokespecial   #193 <Method void IntegerSet()>
    //  223  508:new             #48  <Class IntegerSet>
    //  224  511:dup             
    //  225  512:invokespecial   #193 <Method void IntegerSet()>
    //  226  515:new             #48  <Class IntegerSet>
    //  227  518:dup             
    //  228  519:invokespecial   #193 <Method void IntegerSet()>
    //  229  522:invokevirtual   #240 <Method int ReducedLattices.addNode(IntegerSet, IntegerSet, IntegerSet, IntegerSet)>
    //  230  525:putfield        #243 <Field int Concept.associatedLatticeNode>
        }
        for(int i = 0; i < lattice.getNumberOfNodes(); i++)
    //* 231  528:iconst_0        
    //* 232  529:istore          16
    //* 233  531:goto            604
            if(i != supremum.associatedLatticeNode && i != infimum.associatedLatticeNode)
    //* 234  534:iload           16
    //* 235  536:aload           15
    //* 236  538:getfield        #243 <Field int Concept.associatedLatticeNode>
    //* 237  541:icmpeq          601
    //* 238  544:iload           16
    //* 239  546:aload           14
    //* 240  548:getfield        #243 <Field int Concept.associatedLatticeNode>
    //* 241  551:icmpne          557
    //* 242  554:goto            601
            {
                if(!fromSet.contains(i))
    //* 243  557:aload           17
    //* 244  559:iload           16
    //* 245  561:invokevirtual   #52  <Method boolean IntegerSet.contains(int)>
    //* 246  564:ifne            579
                    lattice.addEdge(i, infimum.associatedLatticeNode);
    //  247  567:aload_1         
    //  248  568:iload           16
    //  249  570:aload           14
    //  250  572:getfield        #243 <Field int Concept.associatedLatticeNode>
    //  251  575:invokevirtual   #251 <Method int ReducedLattices.addEdge(int, int)>
    //  252  578:pop             
                if(!toSet.contains(i))
    //* 253  579:aload           18
    //* 254  581:iload           16
    //* 255  583:invokevirtual   #52  <Method boolean IntegerSet.contains(int)>
    //* 256  586:ifne            601
                    lattice.addEdge(supremum.associatedLatticeNode, i);
    //  257  589:aload_1         
    //  258  590:aload           15
    //  259  592:getfield        #243 <Field int Concept.associatedLatticeNode>
    //  260  595:iload           16
    //  261  597:invokevirtual   #251 <Method int ReducedLattices.addEdge(int, int)>
    //  262  600:pop             
            }

    //  263  601:iinc            16  1
    //  264  604:iload           16
    //  265  606:aload_1         
    //  266  607:invokevirtual   #269 <Method int ReducedLattices.getNumberOfNodes()>
    //  267  610:icmplt          534
    //  268  613:return          
    }

    private String c_objects[];
    private String c_attributes[];
    private int noObs;
    private int noAttrs;
    private Matrix mat;
    private StringBuffer log;
}
