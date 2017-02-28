// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   ReducedLattices.java

package rm.rolemining.lattice;

import java.io.PrintStream;
import java.util.*;
import rm.core.Assignment;
import rm.rolemining.AbstractRoleminer;

// Referenced classes of package rm.rolemining.lattice:
//            Context, Concept, IntegerSet, ConceptSet

public class ReducedLattices extends AbstractRoleminer
{
    public class LatticeEdge
    {

        public int from;
        public int to;
        final ReducedLattices this$0;

        public LatticeEdge()
        {
            this$0 = ReducedLattices.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #14  <Field ReducedLattices this$0>
//            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #17  <Method void Object()>
        //    5    9:return          
        }
    }

    public class ThrEdge
    {

        public int r_super;
        public int r_low;
        final ReducedLattices this$0;

        public ThrEdge()
        {
            this$0 = ReducedLattices.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #14  <Field ReducedLattices this$0>
//            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #17  <Method void Object()>
        //    5    9:return          
        }
    }

    public class WSC
    {

        public int R;
        public int UA;
        public int PA;
        public int RH;
        public int DUPA;
        public int wsc;
        final ReducedLattices this$0;

        public WSC()
        {
            this$0 = ReducedLattices.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #18  <Field ReducedLattices this$0>
//            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #21  <Method void Object()>
        //    5    9:return          
        }
    }


    public ReducedLattices()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #30  <Method void AbstractRoleminer()>
        nodes = new Vector();
    //    2    4:aload_0         
    //    3    5:new             #32  <Class Vector>
    //    4    8:dup             
    //    5    9:invokespecial   #33  <Method void Vector()>
    //    6   12:putfield        #35  <Field Vector nodes>
        edges = new Vector();
    //    7   15:aload_0         
    //    8   16:new             #32  <Class Vector>
    //    9   19:dup             
    //   10   20:invokespecial   #33  <Method void Vector()>
    //   11   23:putfield        #37  <Field Vector edges>
        wr = 1;
    //   12   26:aload_0         
    //   13   27:iconst_1        
    //   14   28:putfield        #39  <Field int wr>
        wu = 1;
    //   15   31:aload_0         
    //   16   32:iconst_1        
    //   17   33:putfield        #41  <Field int wu>
        wp = 1;
    //   18   36:aload_0         
    //   19   37:iconst_1        
    //   20   38:putfield        #43  <Field int wp>
        wh = 1;
    //   21   41:aload_0         
    //   22   42:iconst_1        
    //   23   43:putfield        #45  <Field int wh>
    //   24   46:return          
    }

    public void setContext(Context context, StringBuffer log)
    {
        this.context = context;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #53  <Field Context context>
        allFormalConcepts = context.buildLattice(this);
    //    3    5:aload_0         
    //    4    6:aload_1         
    //    5    7:aload_0         
    //    6    8:invokevirtual   #59  <Method ConceptSet Context.buildLattice(ReducedLattices)>
    //    7   11:putfield        #61  <Field ConceptSet allFormalConcepts>
        noUser = context.getNoObjects();
    //    8   14:aload_0         
    //    9   15:aload_1         
    //   10   16:invokevirtual   #65  <Method int Context.getNoObjects()>
    //   11   19:putfield        #67  <Field int noUser>
        noPerm = context.getNoAttributes();
    //   12   22:aload_0         
    //   13   23:aload_1         
    //   14   24:invokevirtual   #70  <Method int Context.getNoAttributes()>
    //   15   27:putfield        #72  <Field int noPerm>
        this.log = log;
    //   16   30:aload_0         
    //   17   31:aload_2         
    //   18   32:putfield        #74  <Field StringBuffer log>
        this.log.append((new StringBuilder("Users: ")).append(noUser).append(" Permissions: ").append(noPerm).append("\n").toString());
    //   19   35:aload_0         
    //   20   36:getfield        #74  <Field StringBuffer log>
    //   21   39:new             #76  <Class StringBuilder>
    //   22   42:dup             
    //   23   43:ldc1            #78  <String "Users: ">
    //   24   45:invokespecial   #81  <Method void StringBuilder(String)>
    //   25   48:aload_0         
    //   26   49:getfield        #67  <Field int noUser>
    //   27   52:invokevirtual   #85  <Method StringBuilder StringBuilder.append(int)>
    //   28   55:ldc1            #87  <String " Permissions: ">
    //   29   57:invokevirtual   #90  <Method StringBuilder StringBuilder.append(String)>
    //   30   60:aload_0         
    //   31   61:getfield        #72  <Field int noPerm>
    //   32   64:invokevirtual   #85  <Method StringBuilder StringBuilder.append(int)>
    //   33   67:ldc1            #92  <String "\n">
    //   34   69:invokevirtual   #90  <Method StringBuilder StringBuilder.append(String)>
    //   35   72:invokevirtual   #96  <Method String StringBuilder.toString()>
    //   36   75:invokevirtual   #101 <Method StringBuffer StringBuffer.append(String)>
    //   37   78:pop             
    //   38   79:return          
    }

    public void setWeights(int wr, int wu, int wp, int wh)
    {
        this.wr = wr;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #39  <Field int wr>
        this.wu = wu;
    //    3    5:aload_0         
    //    4    6:iload_2         
    //    5    7:putfield        #41  <Field int wu>
        this.wp = wp;
    //    6   10:aload_0         
    //    7   11:iload_3         
    //    8   12:putfield        #43  <Field int wp>
        this.wh = wh;
    //    9   15:aload_0         
    //   10   16:iload           4
    //   11   18:putfield        #45  <Field int wh>
    //   12   21:return          
    }

    int addNode(IntegerSet objectNames, IntegerSet attributeNames, IntegerSet removedObjects, IntegerSet removedAttributes)
    {
        Concept n = new Concept();
    //    0    0:new             #107 <Class Concept>
    //    1    3:dup             
    //    2    4:invokespecial   #108 <Method void Concept()>
    //    3    7:astore          5
        n.allObjects.addElements(objectNames);
    //    4    9:aload           5
    //    5   11:getfield        #112 <Field IntegerSet Concept.allObjects>
    //    6   14:aload_1         
    //    7   15:invokevirtual   #118 <Method void IntegerSet.addElements(IntegerSet)>
        n.allAttributes.addElements(attributeNames);
    //    8   18:aload           5
    //    9   20:getfield        #121 <Field IntegerSet Concept.allAttributes>
    //   10   23:aload_2         
    //   11   24:invokevirtual   #118 <Method void IntegerSet.addElements(IntegerSet)>
        n.removedObjects.addElements(removedObjects);
    //   12   27:aload           5
    //   13   29:getfield        #124 <Field IntegerSet Concept.removedObjects>
    //   14   32:aload_3         
    //   15   33:invokevirtual   #118 <Method void IntegerSet.addElements(IntegerSet)>
        n.removedAttributes.addElements(removedAttributes);
    //   16   36:aload           5
    //   17   38:getfield        #127 <Field IntegerSet Concept.removedAttributes>
    //   18   41:aload           4
    //   19   43:invokevirtual   #118 <Method void IntegerSet.addElements(IntegerSet)>
        nnodes = nodes.size();
    //   20   46:aload_0         
    //   21   47:aload_0         
    //   22   48:getfield        #35  <Field Vector nodes>
    //   23   51:invokevirtual   #130 <Method int Vector.size()>
    //   24   54:putfield        #132 <Field int nnodes>
        nodes.add(n);
    //   25   57:aload_0         
    //   26   58:getfield        #35  <Field Vector nodes>
    //   27   61:aload           5
    //   28   63:invokevirtual   #136 <Method boolean Vector.add(Object)>
    //   29   66:pop             
        return nnodes++;
    //   30   67:aload_0         
    //   31   68:dup             
    //   32   69:getfield        #132 <Field int nnodes>
    //   33   72:dup_x1          
    //   34   73:iconst_1        
    //   35   74:iadd            
    //   36   75:putfield        #132 <Field int nnodes>
    //   37   78:ireturn         
    }

    protected int DeleteNode(int node)
    {
        nodes.remove(node);
    //    0    0:aload_0         
    //    1    1:getfield        #35  <Field Vector nodes>
    //    2    4:iload_1         
    //    3    5:invokevirtual   #146 <Method Object Vector.remove(int)>
    //    4    8:pop             
        for(int j = 0; j < nedges; j++)
    //*   5    9:iconst_0        
    //*   6   10:istore_2        
    //*   7   11:goto            113
        {
            if(((LatticeEdge)edges.get(j)).from > node)
    //*   8   14:aload_0         
    //*   9   15:getfield        #37  <Field Vector edges>
    //*  10   18:iload_2         
    //*  11   19:invokevirtual   #149 <Method Object Vector.get(int)>
    //*  12   22:checkcast       #151 <Class ReducedLattices$LatticeEdge>
    //*  13   25:getfield        #154 <Field int ReducedLattices$LatticeEdge.from>
    //*  14   28:iload_1         
    //*  15   29:icmple          62
                ((LatticeEdge)edges.get(j)).from = ((LatticeEdge)edges.get(j)).from - 1;
    //   16   32:aload_0         
    //   17   33:getfield        #37  <Field Vector edges>
    //   18   36:iload_2         
    //   19   37:invokevirtual   #149 <Method Object Vector.get(int)>
    //   20   40:checkcast       #151 <Class ReducedLattices$LatticeEdge>
    //   21   43:aload_0         
    //   22   44:getfield        #37  <Field Vector edges>
    //   23   47:iload_2         
    //   24   48:invokevirtual   #149 <Method Object Vector.get(int)>
    //   25   51:checkcast       #151 <Class ReducedLattices$LatticeEdge>
    //   26   54:getfield        #154 <Field int ReducedLattices$LatticeEdge.from>
    //   27   57:iconst_1        
    //   28   58:isub            
    //   29   59:putfield        #154 <Field int ReducedLattices$LatticeEdge.from>
            if(((LatticeEdge)edges.get(j)).to > node)
    //*  30   62:aload_0         
    //*  31   63:getfield        #37  <Field Vector edges>
    //*  32   66:iload_2         
    //*  33   67:invokevirtual   #149 <Method Object Vector.get(int)>
    //*  34   70:checkcast       #151 <Class ReducedLattices$LatticeEdge>
    //*  35   73:getfield        #157 <Field int ReducedLattices$LatticeEdge.to>
    //*  36   76:iload_1         
    //*  37   77:icmple          110
                ((LatticeEdge)edges.get(j)).to = ((LatticeEdge)edges.get(j)).to - 1;
    //   38   80:aload_0         
    //   39   81:getfield        #37  <Field Vector edges>
    //   40   84:iload_2         
    //   41   85:invokevirtual   #149 <Method Object Vector.get(int)>
    //   42   88:checkcast       #151 <Class ReducedLattices$LatticeEdge>
    //   43   91:aload_0         
    //   44   92:getfield        #37  <Field Vector edges>
    //   45   95:iload_2         
    //   46   96:invokevirtual   #149 <Method Object Vector.get(int)>
    //   47   99:checkcast       #151 <Class ReducedLattices$LatticeEdge>
    //   48  102:getfield        #157 <Field int ReducedLattices$LatticeEdge.to>
    //   49  105:iconst_1        
    //   50  106:isub            
    //   51  107:putfield        #157 <Field int ReducedLattices$LatticeEdge.to>
        }

    //   52  110:iinc            2  1
    //   53  113:iload_2         
    //   54  114:aload_0         
    //   55  115:getfield        #159 <Field int nedges>
    //   56  118:icmplt          14
        return nnodes--;
    //   57  121:aload_0         
    //   58  122:dup             
    //   59  123:getfield        #132 <Field int nnodes>
    //   60  126:dup_x1          
    //   61  127:iconst_1        
    //   62  128:isub            
    //   63  129:putfield        #132 <Field int nnodes>
    //   64  132:ireturn         
    }

    protected int addEdge(int from, int to)
    {
        if(edgeExists(from, to))
    //*   0    0:aload_0         
    //*   1    1:iload_1         
    //*   2    2:iload_2         
    //*   3    3:invokevirtual   #167 <Method boolean edgeExists(int, int)>
    //*   4    6:ifeq            16
        {
            return findEdge(from, to);
    //    5    9:aload_0         
    //    6   10:iload_1         
    //    7   11:iload_2         
    //    8   12:invokevirtual   #170 <Method int findEdge(int, int)>
    //    9   15:ireturn         
        } else
        {
            LatticeEdge e = new LatticeEdge();
    //   10   16:new             #151 <Class ReducedLattices$LatticeEdge>
    //   11   19:dup             
    //   12   20:aload_0         
    //   13   21:invokespecial   #173 <Method void ReducedLattices$LatticeEdge(ReducedLattices)>
    //   14   24:astore_3        
            e.from = from;
    //   15   25:aload_3         
    //   16   26:iload_1         
    //   17   27:putfield        #154 <Field int ReducedLattices$LatticeEdge.from>
            e.to = to;
    //   18   30:aload_3         
    //   19   31:iload_2         
    //   20   32:putfield        #157 <Field int ReducedLattices$LatticeEdge.to>
            nedges = edges.size();
    //   21   35:aload_0         
    //   22   36:aload_0         
    //   23   37:getfield        #37  <Field Vector edges>
    //   24   40:invokevirtual   #130 <Method int Vector.size()>
    //   25   43:putfield        #159 <Field int nedges>
            edges.add(e);
    //   26   46:aload_0         
    //   27   47:getfield        #37  <Field Vector edges>
    //   28   50:aload_3         
    //   29   51:invokevirtual   #136 <Method boolean Vector.add(Object)>
    //   30   54:pop             
            return nedges++;
    //   31   55:aload_0         
    //   32   56:dup             
    //   33   57:getfield        #159 <Field int nedges>
    //   34   60:dup_x1          
    //   35   61:iconst_1        
    //   36   62:iadd            
    //   37   63:putfield        #159 <Field int nedges>
    //   38   66:ireturn         
        }
    }

    protected int DeleteEdge(int from, int to)
    {
        int edgeId = -1;
    //    0    0:iconst_m1       
    //    1    1:istore_3        
        if(edgeExists(from, to))
    //*   2    2:aload_0         
    //*   3    3:iload_1         
    //*   4    4:iload_2         
    //*   5    5:invokevirtual   #167 <Method boolean edgeExists(int, int)>
    //*   6    8:ifeq            27
        {
            edgeId = findEdge(from, to);
    //    7   11:aload_0         
    //    8   12:iload_1         
    //    9   13:iload_2         
    //   10   14:invokevirtual   #170 <Method int findEdge(int, int)>
    //   11   17:istore_3        
            edges.remove(edgeId);
    //   12   18:aload_0         
    //   13   19:getfield        #37  <Field Vector edges>
    //   14   22:iload_3         
    //   15   23:invokevirtual   #146 <Method Object Vector.remove(int)>
    //   16   26:pop             
        }
        return nedges--;
    //   17   27:aload_0         
    //   18   28:dup             
    //   19   29:getfield        #159 <Field int nedges>
    //   20   32:dup_x1          
    //   21   33:iconst_1        
    //   22   34:isub            
    //   23   35:putfield        #159 <Field int nedges>
    //   24   38:ireturn         
    }

    protected int DeleteEdge(int edgeId)
    {
        edges.remove(edgeId);
    //    0    0:aload_0         
    //    1    1:getfield        #37  <Field Vector edges>
    //    2    4:iload_1         
    //    3    5:invokevirtual   #146 <Method Object Vector.remove(int)>
    //    4    8:pop             
        return nedges--;
    //    5    9:aload_0         
    //    6   10:dup             
    //    7   11:getfield        #159 <Field int nedges>
    //    8   14:dup_x1          
    //    9   15:iconst_1        
    //   10   16:isub            
    //   11   17:putfield        #159 <Field int nedges>
    //   12   20:ireturn         
    }

    void ReversalEdges(Vector edges)
    {
        for(int i = 0; i < edges.size(); i++)
    //*   0    0:iconst_0        
    //*   1    1:istore_3        
    //*   2    2:goto            54
        {
            int edgetemp = ((LatticeEdge)edges.get(i)).from;
    //    3    5:aload_1         
    //    4    6:iload_3         
    //    5    7:invokevirtual   #149 <Method Object Vector.get(int)>
    //    6   10:checkcast       #151 <Class ReducedLattices$LatticeEdge>
    //    7   13:getfield        #154 <Field int ReducedLattices$LatticeEdge.from>
    //    8   16:istore_2        
            ((LatticeEdge)edges.get(i)).from = ((LatticeEdge)edges.get(i)).to;
    //    9   17:aload_1         
    //   10   18:iload_3         
    //   11   19:invokevirtual   #149 <Method Object Vector.get(int)>
    //   12   22:checkcast       #151 <Class ReducedLattices$LatticeEdge>
    //   13   25:aload_1         
    //   14   26:iload_3         
    //   15   27:invokevirtual   #149 <Method Object Vector.get(int)>
    //   16   30:checkcast       #151 <Class ReducedLattices$LatticeEdge>
    //   17   33:getfield        #157 <Field int ReducedLattices$LatticeEdge.to>
    //   18   36:putfield        #154 <Field int ReducedLattices$LatticeEdge.from>
            ((LatticeEdge)edges.get(i)).to = edgetemp;
    //   19   39:aload_1         
    //   20   40:iload_3         
    //   21   41:invokevirtual   #149 <Method Object Vector.get(int)>
    //   22   44:checkcast       #151 <Class ReducedLattices$LatticeEdge>
    //   23   47:iload_2         
    //   24   48:putfield        #157 <Field int ReducedLattices$LatticeEdge.to>
        }

    //   25   51:iinc            3  1
    //   26   54:iload_3         
    //   27   55:aload_1         
    //   28   56:invokevirtual   #130 <Method int Vector.size()>
    //   29   59:icmplt          5
    //   30   62:return          
    }

    protected String TranslateObjectlist(IntegerSet objects)
    {
        return context.getObjectlist(objects);
    //    0    0:aload_0         
    //    1    1:getfield        #53  <Field Context context>
    //    2    4:aload_1         
    //    3    5:invokevirtual   #188 <Method String Context.getObjectlist(IntegerSet)>
    //    4    8:areturn         
    }

    protected String TranslateAttributelist(IntegerSet attributes)
    {
        return context.getAttributelist(attributes);
    //    0    0:aload_0         
    //    1    1:getfield        #53  <Field Context context>
    //    2    4:aload_1         
    //    3    5:invokevirtual   #193 <Method String Context.getAttributelist(IntegerSet)>
    //    4    8:areturn         
    }

    protected void PrintNode(Integer node)
    {
        log.append((new StringBuilder("{{")).append(TranslateObjectlist(((Concept)nodes.get(node.intValue())).allObjects)).append("};{").append(TranslateAttributelist(((Concept)nodes.get(node.intValue())).allAttributes)).append("}}").append("\n").toString());
    //    0    0:aload_0         
    //    1    1:getfield        #74  <Field StringBuffer log>
    //    2    4:new             #76  <Class StringBuilder>
    //    3    7:dup             
    //    4    8:ldc1            #198 <String "{{">
    //    5   10:invokespecial   #81  <Method void StringBuilder(String)>
    //    6   13:aload_0         
    //    7   14:aload_0         
    //    8   15:getfield        #35  <Field Vector nodes>
    //    9   18:aload_1         
    //   10   19:invokevirtual   #203 <Method int Integer.intValue()>
    //   11   22:invokevirtual   #149 <Method Object Vector.get(int)>
    //   12   25:checkcast       #107 <Class Concept>
    //   13   28:getfield        #112 <Field IntegerSet Concept.allObjects>
    //   14   31:invokevirtual   #205 <Method String TranslateObjectlist(IntegerSet)>
    //   15   34:invokevirtual   #90  <Method StringBuilder StringBuilder.append(String)>
    //   16   37:ldc1            #207 <String "};{">
    //   17   39:invokevirtual   #90  <Method StringBuilder StringBuilder.append(String)>
    //   18   42:aload_0         
    //   19   43:aload_0         
    //   20   44:getfield        #35  <Field Vector nodes>
    //   21   47:aload_1         
    //   22   48:invokevirtual   #203 <Method int Integer.intValue()>
    //   23   51:invokevirtual   #149 <Method Object Vector.get(int)>
    //   24   54:checkcast       #107 <Class Concept>
    //   25   57:getfield        #121 <Field IntegerSet Concept.allAttributes>
    //   26   60:invokevirtual   #209 <Method String TranslateAttributelist(IntegerSet)>
    //   27   63:invokevirtual   #90  <Method StringBuilder StringBuilder.append(String)>
    //   28   66:ldc1            #211 <String "}}">
    //   29   68:invokevirtual   #90  <Method StringBuilder StringBuilder.append(String)>
    //   30   71:ldc1            #92  <String "\n">
    //   31   73:invokevirtual   #90  <Method StringBuilder StringBuilder.append(String)>
    //   32   76:invokevirtual   #96  <Method String StringBuilder.toString()>
    //   33   79:invokevirtual   #101 <Method StringBuffer StringBuffer.append(String)>
    //   34   82:pop             
    //   35   83:return          
    }

    protected void PrintEdge(int i)
    {
        log.append((new StringBuilder(String.valueOf(((LatticeEdge)edges.get(i)).from))).append("-->").append(((LatticeEdge)edges.get(i)).to).append("\n").toString());
    //    0    0:aload_0         
    //    1    1:getfield        #74  <Field StringBuffer log>
    //    2    4:new             #76  <Class StringBuilder>
    //    3    7:dup             
    //    4    8:aload_0         
    //    5    9:getfield        #37  <Field Vector edges>
    //    6   12:iload_1         
    //    7   13:invokevirtual   #149 <Method Object Vector.get(int)>
    //    8   16:checkcast       #151 <Class ReducedLattices$LatticeEdge>
    //    9   19:getfield        #154 <Field int ReducedLattices$LatticeEdge.from>
    //   10   22:invokestatic    #220 <Method String String.valueOf(int)>
    //   11   25:invokespecial   #81  <Method void StringBuilder(String)>
    //   12   28:ldc1            #222 <String "-->">
    //   13   30:invokevirtual   #90  <Method StringBuilder StringBuilder.append(String)>
    //   14   33:aload_0         
    //   15   34:getfield        #37  <Field Vector edges>
    //   16   37:iload_1         
    //   17   38:invokevirtual   #149 <Method Object Vector.get(int)>
    //   18   41:checkcast       #151 <Class ReducedLattices$LatticeEdge>
    //   19   44:getfield        #157 <Field int ReducedLattices$LatticeEdge.to>
    //   20   47:invokevirtual   #85  <Method StringBuilder StringBuilder.append(int)>
    //   21   50:ldc1            #92  <String "\n">
    //   22   52:invokevirtual   #90  <Method StringBuilder StringBuilder.append(String)>
    //   23   55:invokevirtual   #96  <Method String StringBuilder.toString()>
    //   24   58:invokevirtual   #101 <Method StringBuffer StringBuffer.append(String)>
    //   25   61:pop             
        PrintNode(Integer.valueOf(((LatticeEdge)edges.get(i)).from));
    //   26   62:aload_0         
    //   27   63:aload_0         
    //   28   64:getfield        #37  <Field Vector edges>
    //   29   67:iload_1         
    //   30   68:invokevirtual   #149 <Method Object Vector.get(int)>
    //   31   71:checkcast       #151 <Class ReducedLattices$LatticeEdge>
    //   32   74:getfield        #154 <Field int ReducedLattices$LatticeEdge.from>
    //   33   77:invokestatic    #225 <Method Integer Integer.valueOf(int)>
    //   34   80:invokevirtual   #227 <Method void PrintNode(Integer)>
        PrintNode(Integer.valueOf(((LatticeEdge)edges.get(i)).to));
    //   35   83:aload_0         
    //   36   84:aload_0         
    //   37   85:getfield        #37  <Field Vector edges>
    //   38   88:iload_1         
    //   39   89:invokevirtual   #149 <Method Object Vector.get(int)>
    //   40   92:checkcast       #151 <Class ReducedLattices$LatticeEdge>
    //   41   95:getfield        #157 <Field int ReducedLattices$LatticeEdge.to>
    //   42   98:invokestatic    #225 <Method Integer Integer.valueOf(int)>
    //   43  101:invokevirtual   #227 <Method void PrintNode(Integer)>
    //   44  104:return          
    }

    boolean edgeExists(int from, int to)
    {
        for(int i = 0; i < edges.size(); i++)
    //*   0    0:iconst_0        
    //*   1    1:istore_3        
    //*   2    2:goto            46
            if(((LatticeEdge)edges.get(i)).from == from && ((LatticeEdge)edges.get(i)).to == to)
    //*   3    5:aload_0         
    //*   4    6:getfield        #37  <Field Vector edges>
    //*   5    9:iload_3         
    //*   6   10:invokevirtual   #149 <Method Object Vector.get(int)>
    //*   7   13:checkcast       #151 <Class ReducedLattices$LatticeEdge>
    //*   8   16:getfield        #154 <Field int ReducedLattices$LatticeEdge.from>
    //*   9   19:iload_1         
    //*  10   20:icmpne          43
    //*  11   23:aload_0         
    //*  12   24:getfield        #37  <Field Vector edges>
    //*  13   27:iload_3         
    //*  14   28:invokevirtual   #149 <Method Object Vector.get(int)>
    //*  15   31:checkcast       #151 <Class ReducedLattices$LatticeEdge>
    //*  16   34:getfield        #157 <Field int ReducedLattices$LatticeEdge.to>
    //*  17   37:iload_2         
    //*  18   38:icmpne          43
                return true;
    //   19   41:iconst_1        
    //   20   42:ireturn         

    //   21   43:iinc            3  1
    //   22   46:iload_3         
    //   23   47:aload_0         
    //   24   48:getfield        #37  <Field Vector edges>
    //   25   51:invokevirtual   #130 <Method int Vector.size()>
    //   26   54:icmplt          5
        return false;
    //   27   57:iconst_0        
    //   28   58:ireturn         
    }

    int findEdge(int from, int to)
    {
        for(int i = 0; i < edges.size(); i++)
    //*   0    0:iconst_0        
    //*   1    1:istore_3        
    //*   2    2:goto            46
            if(((LatticeEdge)edges.get(i)).from == from && ((LatticeEdge)edges.get(i)).to == to)
    //*   3    5:aload_0         
    //*   4    6:getfield        #37  <Field Vector edges>
    //*   5    9:iload_3         
    //*   6   10:invokevirtual   #149 <Method Object Vector.get(int)>
    //*   7   13:checkcast       #151 <Class ReducedLattices$LatticeEdge>
    //*   8   16:getfield        #154 <Field int ReducedLattices$LatticeEdge.from>
    //*   9   19:iload_1         
    //*  10   20:icmpne          43
    //*  11   23:aload_0         
    //*  12   24:getfield        #37  <Field Vector edges>
    //*  13   27:iload_3         
    //*  14   28:invokevirtual   #149 <Method Object Vector.get(int)>
    //*  15   31:checkcast       #151 <Class ReducedLattices$LatticeEdge>
    //*  16   34:getfield        #157 <Field int ReducedLattices$LatticeEdge.to>
    //*  17   37:iload_2         
    //*  18   38:icmpne          43
                return i;
    //   19   41:iload_3         
    //   20   42:ireturn         

    //   21   43:iinc            3  1
    //   22   46:iload_3         
    //   23   47:aload_0         
    //   24   48:getfield        #37  <Field Vector edges>
    //   25   51:invokevirtual   #130 <Method int Vector.size()>
    //   26   54:icmplt          5
        return -1;
    //   27   57:iconst_m1       
    //   28   58:ireturn         
    }

    int getNumberOfEdges()
    {
        return nedges;
    //    0    0:aload_0         
    //    1    1:getfield        #159 <Field int nedges>
    //    2    4:ireturn         
    }

    LatticeEdge getEdge(int i)
    {
        if(i >= 0 && i < edges.size())
    //*   0    0:iload_1         
    //*   1    1:iflt            27
    //*   2    4:iload_1         
    //*   3    5:aload_0         
    //*   4    6:getfield        #37  <Field Vector edges>
    //*   5    9:invokevirtual   #130 <Method int Vector.size()>
    //*   6   12:icmpge          27
            return (LatticeEdge)edges.get(i);
    //    7   15:aload_0         
    //    8   16:getfield        #37  <Field Vector edges>
    //    9   19:iload_1         
    //   10   20:invokevirtual   #149 <Method Object Vector.get(int)>
    //   11   23:checkcast       #151 <Class ReducedLattices$LatticeEdge>
    //   12   26:areturn         
        else
            return null;
    //   13   27:aconst_null     
    //   14   28:areturn         
    }

    int getNumberOfNodes()
    {
        return nodes.size();
    //    0    0:aload_0         
    //    1    1:getfield        #35  <Field Vector nodes>
    //    2    4:invokevirtual   #130 <Method int Vector.size()>
    //    3    7:ireturn         
    }

    Concept getNode(int i)
    {
        if(i >= 0 && i < nodes.size())
    //*   0    0:iload_1         
    //*   1    1:iflt            27
    //*   2    4:iload_1         
    //*   3    5:aload_0         
    //*   4    6:getfield        #35  <Field Vector nodes>
    //*   5    9:invokevirtual   #130 <Method int Vector.size()>
    //*   6   12:icmpge          27
            return (Concept)nodes.get(i);
    //    7   15:aload_0         
    //    8   16:getfield        #35  <Field Vector nodes>
    //    9   19:iload_1         
    //   10   20:invokevirtual   #149 <Method Object Vector.get(int)>
    //   11   23:checkcast       #107 <Class Concept>
    //   12   26:areturn         
        else
            return null;
    //   13   27:aconst_null     
    //   14   28:areturn         
    }

    IntegerSet findEdgeDestinations(int from)
    {
        IntegerSet Result = new IntegerSet();
    //    0    0:new             #114 <Class IntegerSet>
    //    1    3:dup             
    //    2    4:invokespecial   #236 <Method void IntegerSet()>
    //    3    7:astore_2        
        for(int i = 0; i < edges.size(); i++)
    //*   4    8:iconst_0        
    //*   5    9:istore_3        
    //*   6   10:goto            52
            if(((LatticeEdge)edges.get(i)).from == from)
    //*   7   13:aload_0         
    //*   8   14:getfield        #37  <Field Vector edges>
    //*   9   17:iload_3         
    //*  10   18:invokevirtual   #149 <Method Object Vector.get(int)>
    //*  11   21:checkcast       #151 <Class ReducedLattices$LatticeEdge>
    //*  12   24:getfield        #154 <Field int ReducedLattices$LatticeEdge.from>
    //*  13   27:iload_1         
    //*  14   28:icmpne          49
                Result.addElement(((LatticeEdge)edges.get(i)).to);
    //   15   31:aload_2         
    //   16   32:aload_0         
    //   17   33:getfield        #37  <Field Vector edges>
    //   18   36:iload_3         
    //   19   37:invokevirtual   #149 <Method Object Vector.get(int)>
    //   20   40:checkcast       #151 <Class ReducedLattices$LatticeEdge>
    //   21   43:getfield        #157 <Field int ReducedLattices$LatticeEdge.to>
    //   22   46:invokevirtual   #239 <Method void IntegerSet.addElement(int)>

    //   23   49:iinc            3  1
    //   24   52:iload_3         
    //   25   53:aload_0         
    //   26   54:getfield        #37  <Field Vector edges>
    //   27   57:invokevirtual   #130 <Method int Vector.size()>
    //   28   60:icmplt          13
        return Result;
    //   29   63:aload_2         
    //   30   64:areturn         
    }

    protected int ReduceEdges()
    {
        Vector removedEdges = new Vector();
    //    0    0:new             #32  <Class Vector>
    //    1    3:dup             
    //    2    4:invokespecial   #33  <Method void Vector()>
    //    3    7:astore_1        
        for(int i = 0; i < edges.size(); i++)
    //*   4    8:iconst_0        
    //*   5    9:istore_2        
    //*   6   10:goto            68
            if(FindPaths(((LatticeEdge)edges.get(i)).from, ((LatticeEdge)edges.get(i)).to) > 1)
    //*   7   13:aload_0         
    //*   8   14:aload_0         
    //*   9   15:getfield        #37  <Field Vector edges>
    //*  10   18:iload_2         
    //*  11   19:invokevirtual   #149 <Method Object Vector.get(int)>
    //*  12   22:checkcast       #151 <Class ReducedLattices$LatticeEdge>
    //*  13   25:getfield        #154 <Field int ReducedLattices$LatticeEdge.from>
    //*  14   28:aload_0         
    //*  15   29:getfield        #37  <Field Vector edges>
    //*  16   32:iload_2         
    //*  17   33:invokevirtual   #149 <Method Object Vector.get(int)>
    //*  18   36:checkcast       #151 <Class ReducedLattices$LatticeEdge>
    //*  19   39:getfield        #157 <Field int ReducedLattices$LatticeEdge.to>
    //*  20   42:invokevirtual   #244 <Method int FindPaths(int, int)>
    //*  21   45:iconst_1        
    //*  22   46:icmple          65
                removedEdges.add((LatticeEdge)edges.get(i));
    //   23   49:aload_1         
    //   24   50:aload_0         
    //   25   51:getfield        #37  <Field Vector edges>
    //   26   54:iload_2         
    //   27   55:invokevirtual   #149 <Method Object Vector.get(int)>
    //   28   58:checkcast       #151 <Class ReducedLattices$LatticeEdge>
    //   29   61:invokevirtual   #136 <Method boolean Vector.add(Object)>
    //   30   64:pop             

    //   31   65:iinc            2  1
    //   32   68:iload_2         
    //   33   69:aload_0         
    //   34   70:getfield        #37  <Field Vector edges>
    //   35   73:invokevirtual   #130 <Method int Vector.size()>
    //   36   76:icmplt          13
        for(int i = 0; i < removedEdges.size(); i++)
    //*  37   79:iconst_0        
    //*  38   80:istore_2        
    //*  39   81:goto            100
            edges.remove(removedEdges.get(i));
    //   40   84:aload_0         
    //   41   85:getfield        #37  <Field Vector edges>
    //   42   88:aload_1         
    //   43   89:iload_2         
    //   44   90:invokevirtual   #149 <Method Object Vector.get(int)>
    //   45   93:invokevirtual   #246 <Method boolean Vector.remove(Object)>
    //   46   96:pop             

    //   47   97:iinc            2  1
    //   48  100:iload_2         
    //   49  101:aload_1         
    //   50  102:invokevirtual   #130 <Method int Vector.size()>
    //   51  105:icmplt          84
        nedges = edges.size();
    //   52  108:aload_0         
    //   53  109:aload_0         
    //   54  110:getfield        #37  <Field Vector edges>
    //   55  113:invokevirtual   #130 <Method int Vector.size()>
    //   56  116:putfield        #159 <Field int nedges>
        ReversalEdges(edges);
    //   57  119:aload_0         
    //   58  120:aload_0         
    //   59  121:getfield        #37  <Field Vector edges>
    //   60  124:invokevirtual   #248 <Method void ReversalEdges(Vector)>
        return nedges;
    //   61  127:aload_0         
    //   62  128:getfield        #159 <Field int nedges>
    //   63  131:ireturn         
    }

    int FindPaths(int from, int to)
    {
        Integer nopath = Integer.valueOf(0);
    //    0    0:iconst_0        
    //    1    1:invokestatic    #225 <Method Integer Integer.valueOf(int)>
    //    2    4:astore_3        
        Integer qnode = Integer.valueOf(from);
    //    3    5:iload_1         
    //    4    6:invokestatic    #225 <Method Integer Integer.valueOf(int)>
    //    5    9:astore          4
        ArrayDeque qnodes = new ArrayDeque();
    //    6   11:new             #251 <Class ArrayDeque>
    //    7   14:dup             
    //    8   15:invokespecial   #252 <Method void ArrayDeque()>
    //    9   18:astore          5
        qnodes.add(Integer.valueOf(from));
    //   10   20:aload           5
    //   11   22:iload_1         
    //   12   23:invokestatic    #225 <Method Integer Integer.valueOf(int)>
    //   13   26:invokevirtual   #253 <Method boolean ArrayDeque.add(Object)>
    //   14   29:pop             
    //*  15   30:goto            149
        while(!qnodes.isEmpty()) 
        {
            qnode = (Integer)(Integer)qnodes.getFirst();
    //   16   33:aload           5
    //   17   35:invokevirtual   #257 <Method Object ArrayDeque.getFirst()>
    //   18   38:checkcast       #200 <Class Integer>
    //   19   41:checkcast       #200 <Class Integer>
    //   20   44:astore          4
            qnodes.removeFirst();
    //   21   46:aload           5
    //   22   48:invokevirtual   #260 <Method Object ArrayDeque.removeFirst()>
    //   23   51:pop             
            for(int i = 0; i < nedges; i++)
    //*  24   52:iconst_0        
    //*  25   53:istore          6
    //*  26   55:goto            140
                if(((LatticeEdge)edges.get(i)).from == qnode.intValue())
    //*  27   58:aload_0         
    //*  28   59:getfield        #37  <Field Vector edges>
    //*  29   62:iload           6
    //*  30   64:invokevirtual   #149 <Method Object Vector.get(int)>
    //*  31   67:checkcast       #151 <Class ReducedLattices$LatticeEdge>
    //*  32   70:getfield        #154 <Field int ReducedLattices$LatticeEdge.from>
    //*  33   73:aload           4
    //*  34   75:invokevirtual   #203 <Method int Integer.intValue()>
    //*  35   78:icmpne          137
                    if(((LatticeEdge)edges.get(i)).to != to)
    //*  36   81:aload_0         
    //*  37   82:getfield        #37  <Field Vector edges>
    //*  38   85:iload           6
    //*  39   87:invokevirtual   #149 <Method Object Vector.get(int)>
    //*  40   90:checkcast       #151 <Class ReducedLattices$LatticeEdge>
    //*  41   93:getfield        #157 <Field int ReducedLattices$LatticeEdge.to>
    //*  42   96:iload_2         
    //*  43   97:icmpeq          127
                        qnodes.add(Integer.valueOf(((LatticeEdge)edges.get(i)).to));
    //   44  100:aload           5
    //   45  102:aload_0         
    //   46  103:getfield        #37  <Field Vector edges>
    //   47  106:iload           6
    //   48  108:invokevirtual   #149 <Method Object Vector.get(int)>
    //   49  111:checkcast       #151 <Class ReducedLattices$LatticeEdge>
    //   50  114:getfield        #157 <Field int ReducedLattices$LatticeEdge.to>
    //   51  117:invokestatic    #225 <Method Integer Integer.valueOf(int)>
    //   52  120:invokevirtual   #253 <Method boolean ArrayDeque.add(Object)>
    //   53  123:pop             
                    else
    //*  54  124:goto            137
                        nopath = Integer.valueOf(nopath.intValue() + 1);
    //   55  127:aload_3         
    //   56  128:invokevirtual   #203 <Method int Integer.intValue()>
    //   57  131:iconst_1        
    //   58  132:iadd            
    //   59  133:invokestatic    #225 <Method Integer Integer.valueOf(int)>
    //   60  136:astore_3        

    //   61  137:iinc            6  1
    //   62  140:iload           6
    //   63  142:aload_0         
    //   64  143:getfield        #159 <Field int nedges>
    //   65  146:icmplt          58
        }
    //   66  149:aload           5
    //   67  151:invokevirtual   #264 <Method boolean ArrayDeque.isEmpty()>
    //   68  154:ifeq            33
        return nopath.intValue();
    //   69  157:aload_3         
    //   70  158:invokevirtual   #203 <Method int Integer.intValue()>
    //   71  161:ireturn         
    }

    protected ArrayList getSen(int curnode)
    {
        ArrayList Sen = new ArrayList();
    //    0    0:new             #272 <Class ArrayList>
    //    1    3:dup             
    //    2    4:invokespecial   #273 <Method void ArrayList()>
    //    3    7:astore_2        
        for(int i = 0; i < nedges; i++)
    //*   4    8:iconst_0        
    //*   5    9:istore_3        
    //*   6   10:goto            80
            if(((LatticeEdge)edges.get(i)).to == curnode && !Sen.contains(Integer.valueOf(((LatticeEdge)edges.get(i)).from)))
    //*   7   13:aload_0         
    //*   8   14:getfield        #37  <Field Vector edges>
    //*   9   17:iload_3         
    //*  10   18:invokevirtual   #149 <Method Object Vector.get(int)>
    //*  11   21:checkcast       #151 <Class ReducedLattices$LatticeEdge>
    //*  12   24:getfield        #157 <Field int ReducedLattices$LatticeEdge.to>
    //*  13   27:iload_1         
    //*  14   28:icmpne          77
    //*  15   31:aload_2         
    //*  16   32:aload_0         
    //*  17   33:getfield        #37  <Field Vector edges>
    //*  18   36:iload_3         
    //*  19   37:invokevirtual   #149 <Method Object Vector.get(int)>
    //*  20   40:checkcast       #151 <Class ReducedLattices$LatticeEdge>
    //*  21   43:getfield        #154 <Field int ReducedLattices$LatticeEdge.from>
    //*  22   46:invokestatic    #225 <Method Integer Integer.valueOf(int)>
    //*  23   49:invokevirtual   #276 <Method boolean ArrayList.contains(Object)>
    //*  24   52:ifne            77
                Sen.add(Integer.valueOf(((LatticeEdge)edges.get(i)).from));
    //   25   55:aload_2         
    //   26   56:aload_0         
    //   27   57:getfield        #37  <Field Vector edges>
    //   28   60:iload_3         
    //   29   61:invokevirtual   #149 <Method Object Vector.get(int)>
    //   30   64:checkcast       #151 <Class ReducedLattices$LatticeEdge>
    //   31   67:getfield        #154 <Field int ReducedLattices$LatticeEdge.from>
    //   32   70:invokestatic    #225 <Method Integer Integer.valueOf(int)>
    //   33   73:invokevirtual   #277 <Method boolean ArrayList.add(Object)>
    //   34   76:pop             

    //   35   77:iinc            3  1
    //   36   80:iload_3         
    //   37   81:aload_0         
    //   38   82:getfield        #159 <Field int nedges>
    //   39   85:icmplt          13
        return Sen;
    //   40   88:aload_2         
    //   41   89:areturn         
    }

    protected ArrayList getJun(int curnode)
    {
        ArrayList Jun = new ArrayList();
    //    0    0:new             #272 <Class ArrayList>
    //    1    3:dup             
    //    2    4:invokespecial   #273 <Method void ArrayList()>
    //    3    7:astore_2        
        for(int i = 0; i < nedges; i++)
    //*   4    8:iconst_0        
    //*   5    9:istore_3        
    //*   6   10:goto            80
            if(((LatticeEdge)edges.get(i)).from == curnode && !Jun.contains(Integer.valueOf(((LatticeEdge)edges.get(i)).to)))
    //*   7   13:aload_0         
    //*   8   14:getfield        #37  <Field Vector edges>
    //*   9   17:iload_3         
    //*  10   18:invokevirtual   #149 <Method Object Vector.get(int)>
    //*  11   21:checkcast       #151 <Class ReducedLattices$LatticeEdge>
    //*  12   24:getfield        #154 <Field int ReducedLattices$LatticeEdge.from>
    //*  13   27:iload_1         
    //*  14   28:icmpne          77
    //*  15   31:aload_2         
    //*  16   32:aload_0         
    //*  17   33:getfield        #37  <Field Vector edges>
    //*  18   36:iload_3         
    //*  19   37:invokevirtual   #149 <Method Object Vector.get(int)>
    //*  20   40:checkcast       #151 <Class ReducedLattices$LatticeEdge>
    //*  21   43:getfield        #157 <Field int ReducedLattices$LatticeEdge.to>
    //*  22   46:invokestatic    #225 <Method Integer Integer.valueOf(int)>
    //*  23   49:invokevirtual   #276 <Method boolean ArrayList.contains(Object)>
    //*  24   52:ifne            77
                Jun.add(Integer.valueOf(((LatticeEdge)edges.get(i)).to));
    //   25   55:aload_2         
    //   26   56:aload_0         
    //   27   57:getfield        #37  <Field Vector edges>
    //   28   60:iload_3         
    //   29   61:invokevirtual   #149 <Method Object Vector.get(int)>
    //   30   64:checkcast       #151 <Class ReducedLattices$LatticeEdge>
    //   31   67:getfield        #157 <Field int ReducedLattices$LatticeEdge.to>
    //   32   70:invokestatic    #225 <Method Integer Integer.valueOf(int)>
    //   33   73:invokevirtual   #277 <Method boolean ArrayList.add(Object)>
    //   34   76:pop             

    //   35   77:iinc            3  1
    //   36   80:iload_3         
    //   37   81:aload_0         
    //   38   82:getfield        #159 <Field int nedges>
    //   39   85:icmplt          13
        return Jun;
    //   40   88:aload_2         
    //   41   89:areturn         
    }

    protected ArrayList getThr(int curnode)
    {
        ArrayList Thr = new ArrayList();
    //    0    0:new             #272 <Class ArrayList>
    //    1    3:dup             
    //    2    4:invokespecial   #273 <Method void ArrayList()>
    //    3    7:astore_2        
        for(int i = 0; i < nedges; i++)
    //*   4    8:iconst_0        
    //*   5    9:istore_3        
    //*   6   10:goto            173
            if(((LatticeEdge)edges.get(i)).from == curnode)
    //*   7   13:aload_0         
    //*   8   14:getfield        #37  <Field Vector edges>
    //*   9   17:iload_3         
    //*  10   18:invokevirtual   #149 <Method Object Vector.get(int)>
    //*  11   21:checkcast       #151 <Class ReducedLattices$LatticeEdge>
    //*  12   24:getfield        #154 <Field int ReducedLattices$LatticeEdge.from>
    //*  13   27:iload_1         
    //*  14   28:icmpne          170
            {
                for(int j = 0; j < nedges; j++)
    //*  15   31:iconst_0        
    //*  16   32:istore          4
    //*  17   34:goto            161
                    if(((LatticeEdge)edges.get(j)).to == curnode)
    //*  18   37:aload_0         
    //*  19   38:getfield        #37  <Field Vector edges>
    //*  20   41:iload           4
    //*  21   43:invokevirtual   #149 <Method Object Vector.get(int)>
    //*  22   46:checkcast       #151 <Class ReducedLattices$LatticeEdge>
    //*  23   49:getfield        #157 <Field int ReducedLattices$LatticeEdge.to>
    //*  24   52:iload_1         
    //*  25   53:icmpne          158
                    {
                        ThrEdge temp = new ThrEdge();
    //   26   56:new             #286 <Class ReducedLattices$ThrEdge>
    //   27   59:dup             
    //   28   60:aload_0         
    //   29   61:invokespecial   #287 <Method void ReducedLattices$ThrEdge(ReducedLattices)>
    //   30   64:astore          5
                        temp.r_low = ((LatticeEdge)edges.get(j)).from;
    //   31   66:aload           5
    //   32   68:aload_0         
    //   33   69:getfield        #37  <Field Vector edges>
    //   34   72:iload           4
    //   35   74:invokevirtual   #149 <Method Object Vector.get(int)>
    //   36   77:checkcast       #151 <Class ReducedLattices$LatticeEdge>
    //   37   80:getfield        #154 <Field int ReducedLattices$LatticeEdge.from>
    //   38   83:putfield        #290 <Field int ReducedLattices$ThrEdge.r_low>
                        temp.r_super = ((LatticeEdge)edges.get(i)).to;
    //   39   86:aload           5
    //   40   88:aload_0         
    //   41   89:getfield        #37  <Field Vector edges>
    //   42   92:iload_3         
    //   43   93:invokevirtual   #149 <Method Object Vector.get(int)>
    //   44   96:checkcast       #151 <Class ReducedLattices$LatticeEdge>
    //   45   99:getfield        #157 <Field int ReducedLattices$LatticeEdge.to>
    //   46  102:putfield        #293 <Field int ReducedLattices$ThrEdge.r_super>
                        if(FindPaths(((LatticeEdge)edges.get(j)).from, ((LatticeEdge)edges.get(i)).to) == 1 && !Thr.contains(temp))
    //*  47  105:aload_0         
    //*  48  106:aload_0         
    //*  49  107:getfield        #37  <Field Vector edges>
    //*  50  110:iload           4
    //*  51  112:invokevirtual   #149 <Method Object Vector.get(int)>
    //*  52  115:checkcast       #151 <Class ReducedLattices$LatticeEdge>
    //*  53  118:getfield        #154 <Field int ReducedLattices$LatticeEdge.from>
    //*  54  121:aload_0         
    //*  55  122:getfield        #37  <Field Vector edges>
    //*  56  125:iload_3         
    //*  57  126:invokevirtual   #149 <Method Object Vector.get(int)>
    //*  58  129:checkcast       #151 <Class ReducedLattices$LatticeEdge>
    //*  59  132:getfield        #157 <Field int ReducedLattices$LatticeEdge.to>
    //*  60  135:invokevirtual   #244 <Method int FindPaths(int, int)>
    //*  61  138:iconst_1        
    //*  62  139:icmpne          158
    //*  63  142:aload_2         
    //*  64  143:aload           5
    //*  65  145:invokevirtual   #276 <Method boolean ArrayList.contains(Object)>
    //*  66  148:ifne            158
                            Thr.add(temp);
    //   67  151:aload_2         
    //   68  152:aload           5
    //   69  154:invokevirtual   #277 <Method boolean ArrayList.add(Object)>
    //   70  157:pop             
                    }

    //   71  158:iinc            4  1
    //   72  161:iload           4
    //   73  163:aload_0         
    //   74  164:getfield        #159 <Field int nedges>
    //   75  167:icmplt          37
            }

    //   76  170:iinc            3  1
    //   77  173:iload_3         
    //   78  174:aload_0         
    //   79  175:getfield        #159 <Field int nedges>
    //   80  178:icmplt          13
        return Thr;
    //   81  181:aload_2         
    //   82  182:areturn         
    }

    protected WSC ComputeWSC()
    {
        WSC wsc = new WSC();
    //    0    0:new             #301 <Class ReducedLattices$WSC>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:invokespecial   #302 <Method void ReducedLattices$WSC(ReducedLattices)>
    //    4    8:astore_1        
        int R = 0;
    //    5    9:iconst_0        
    //    6   10:istore_2        
        int UA = 0;
    //    7   11:iconst_0        
    //    8   12:istore_3        
        int PA = 0;
    //    9   13:iconst_0        
    //   10   14:istore          4
        int RH = 0;
    //   11   16:iconst_0        
    //   12   17:istore          5
        R = nodes.size();
    //   13   19:aload_0         
    //   14   20:getfield        #35  <Field Vector nodes>
    //   15   23:invokevirtual   #130 <Method int Vector.size()>
    //   16   26:istore_2        
        for(int i = 0; i < nodes.size(); i++)
    //*  17   27:iconst_0        
    //*  18   28:istore          6
    //*  19   30:goto            74
        {
            UA += ((Concept)nodes.get(i)).getNumberOfObjects();
    //   20   33:iload_3         
    //   21   34:aload_0         
    //   22   35:getfield        #35  <Field Vector nodes>
    //   23   38:iload           6
    //   24   40:invokevirtual   #149 <Method Object Vector.get(int)>
    //   25   43:checkcast       #107 <Class Concept>
    //   26   46:invokevirtual   #305 <Method int Concept.getNumberOfObjects()>
    //   27   49:iadd            
    //   28   50:istore_3        
            PA += ((Concept)nodes.get(i)).getNumberOfAttributes();
    //   29   51:iload           4
    //   30   53:aload_0         
    //   31   54:getfield        #35  <Field Vector nodes>
    //   32   57:iload           6
    //   33   59:invokevirtual   #149 <Method Object Vector.get(int)>
    //   34   62:checkcast       #107 <Class Concept>
    //   35   65:invokevirtual   #308 <Method int Concept.getNumberOfAttributes()>
    //   36   68:iadd            
    //   37   69:istore          4
        }

    //   38   71:iinc            6  1
    //   39   74:iload           6
    //   40   76:aload_0         
    //   41   77:getfield        #35  <Field Vector nodes>
    //   42   80:invokevirtual   #130 <Method int Vector.size()>
    //   43   83:icmplt          33
        RH += nedges;
    //   44   86:iload           5
    //   45   88:aload_0         
    //   46   89:getfield        #159 <Field int nedges>
    //   47   92:iadd            
    //   48   93:istore          5
        wsc.wsc = wr * R + wu * UA + wp * PA + wh * RH;
    //   49   95:aload_1         
    //   50   96:aload_0         
    //   51   97:getfield        #39  <Field int wr>
    //   52  100:iload_2         
    //   53  101:imul            
    //   54  102:aload_0         
    //   55  103:getfield        #41  <Field int wu>
    //   56  106:iload_3         
    //   57  107:imul            
    //   58  108:iadd            
    //   59  109:aload_0         
    //   60  110:getfield        #43  <Field int wp>
    //   61  113:iload           4
    //   62  115:imul            
    //   63  116:iadd            
    //   64  117:aload_0         
    //   65  118:getfield        #45  <Field int wh>
    //   66  121:iload           5
    //   67  123:imul            
    //   68  124:iadd            
    //   69  125:putfield        #311 <Field int ReducedLattices$WSC.wsc>
        wsc.R = R;
    //   70  128:aload_1         
    //   71  129:iload_2         
    //   72  130:putfield        #314 <Field int ReducedLattices$WSC.R>
        wsc.UA = UA;
    //   73  133:aload_1         
    //   74  134:iload_3         
    //   75  135:putfield        #317 <Field int ReducedLattices$WSC.UA>
        wsc.PA = PA;
    //   76  138:aload_1         
    //   77  139:iload           4
    //   78  141:putfield        #320 <Field int ReducedLattices$WSC.PA>
        wsc.RH = RH;
    //   79  144:aload_1         
    //   80  145:iload           5
    //   81  147:putfield        #323 <Field int ReducedLattices$WSC.RH>
        return wsc;
    //   82  150:aload_1         
    //   83  151:areturn         
    }

    protected void Update(int node, ArrayList Thr)
    {
        for(int i = 0; i < edges.size();)
    //*   0    0:iconst_0        
    //*   1    1:istore_3        
    //*   2    2:goto            69
            if(((LatticeEdge)edges.get(i)).from == node || ((LatticeEdge)edges.get(i)).to == node)
    //*   3    5:aload_0         
    //*   4    6:getfield        #37  <Field Vector edges>
    //*   5    9:iload_3         
    //*   6   10:invokevirtual   #149 <Method Object Vector.get(int)>
    //*   7   13:checkcast       #151 <Class ReducedLattices$LatticeEdge>
    //*   8   16:getfield        #154 <Field int ReducedLattices$LatticeEdge.from>
    //*   9   19:iload_1         
    //*  10   20:icmpeq          41
    //*  11   23:aload_0         
    //*  12   24:getfield        #37  <Field Vector edges>
    //*  13   27:iload_3         
    //*  14   28:invokevirtual   #149 <Method Object Vector.get(int)>
    //*  15   31:checkcast       #151 <Class ReducedLattices$LatticeEdge>
    //*  16   34:getfield        #157 <Field int ReducedLattices$LatticeEdge.to>
    //*  17   37:iload_1         
    //*  18   38:icmpne          66
            {
                log.append("Delete edge :\n");
    //   19   41:aload_0         
    //   20   42:getfield        #74  <Field StringBuffer log>
    //   21   45:ldc2            #329 <String "Delete edge :\n">
    //   22   48:invokevirtual   #101 <Method StringBuffer StringBuffer.append(String)>
    //   23   51:pop             
                PrintEdge(i);
    //   24   52:aload_0         
    //   25   53:iload_3         
    //   26   54:invokevirtual   #331 <Method void PrintEdge(int)>
                DeleteEdge(i);
    //   27   57:aload_0         
    //   28   58:iload_3         
    //   29   59:invokevirtual   #333 <Method int DeleteEdge(int)>
    //   30   62:pop             
            } else
    //*  31   63:goto            69
            {
                i++;
    //   32   66:iinc            3  1
            }

    //   33   69:iload_3         
    //   34   70:aload_0         
    //   35   71:getfield        #37  <Field Vector edges>
    //   36   74:invokevirtual   #130 <Method int Vector.size()>
    //   37   77:icmplt          5
        int noedge = 0;
    //   38   80:iconst_0        
    //   39   81:istore_3        
        if(Thr.size() > 0)
    //*  40   82:aload_2         
    //*  41   83:invokevirtual   #334 <Method int ArrayList.size()>
    //*  42   86:ifle            152
        {
            for(int i = 0; i < Thr.size(); i++)
    //*  43   89:iconst_0        
    //*  44   90:istore          4
    //*  45   92:goto            143
            {
                noedge = addEdge(((ThrEdge)Thr.get(i)).r_low, ((ThrEdge)Thr.get(i)).r_super);
    //   46   95:aload_0         
    //   47   96:aload_2         
    //   48   97:iload           4
    //   49   99:invokevirtual   #335 <Method Object ArrayList.get(int)>
    //   50  102:checkcast       #286 <Class ReducedLattices$ThrEdge>
    //   51  105:getfield        #290 <Field int ReducedLattices$ThrEdge.r_low>
    //   52  108:aload_2         
    //   53  109:iload           4
    //   54  111:invokevirtual   #335 <Method Object ArrayList.get(int)>
    //   55  114:checkcast       #286 <Class ReducedLattices$ThrEdge>
    //   56  117:getfield        #293 <Field int ReducedLattices$ThrEdge.r_super>
    //   57  120:invokevirtual   #337 <Method int addEdge(int, int)>
    //   58  123:istore_3        
                log.append("Add edge :\n");
    //   59  124:aload_0         
    //   60  125:getfield        #74  <Field StringBuffer log>
    //   61  128:ldc2            #339 <String "Add edge :\n">
    //   62  131:invokevirtual   #101 <Method StringBuffer StringBuffer.append(String)>
    //   63  134:pop             
                PrintEdge(noedge);
    //   64  135:aload_0         
    //   65  136:iload_3         
    //   66  137:invokevirtual   #331 <Method void PrintEdge(int)>
            }

    //   67  140:iinc            4  1
    //   68  143:iload           4
    //   69  145:aload_2         
    //   70  146:invokevirtual   #334 <Method int ArrayList.size()>
    //   71  149:icmplt          95
        }
    //   72  152:return          
    }

    void TestJunSenThr()
    {
        log.append("Output the Juniors of nodes:\n");
    //    0    0:aload_0         
    //    1    1:getfield        #74  <Field StringBuffer log>
    //    2    4:ldc2            #343 <String "Output the Juniors of nodes:\n">
    //    3    7:invokevirtual   #101 <Method StringBuffer StringBuffer.append(String)>
    //    4   10:pop             
        for(int i = 0; i < nnodes; i++)
    //*   5   11:iconst_0        
    //*   6   12:istore_1        
    //*   7   13:goto            97
        {
            log.append((new StringBuilder(String.valueOf(i))).append("  :").append("\n").toString());
    //    8   16:aload_0         
    //    9   17:getfield        #74  <Field StringBuffer log>
    //   10   20:new             #76  <Class StringBuilder>
    //   11   23:dup             
    //   12   24:iload_1         
    //   13   25:invokestatic    #220 <Method String String.valueOf(int)>
    //   14   28:invokespecial   #81  <Method void StringBuilder(String)>
    //   15   31:ldc2            #345 <String "  :">
    //   16   34:invokevirtual   #90  <Method StringBuilder StringBuilder.append(String)>
    //   17   37:ldc1            #92  <String "\n">
    //   18   39:invokevirtual   #90  <Method StringBuilder StringBuilder.append(String)>
    //   19   42:invokevirtual   #96  <Method String StringBuilder.toString()>
    //   20   45:invokevirtual   #101 <Method StringBuffer StringBuffer.append(String)>
    //   21   48:pop             
            PrintNode(Integer.valueOf(i));
    //   22   49:aload_0         
    //   23   50:iload_1         
    //   24   51:invokestatic    #225 <Method Integer Integer.valueOf(int)>
    //   25   54:invokevirtual   #227 <Method void PrintNode(Integer)>
            ArrayList Jun = getJun(i);
    //   26   57:aload_0         
    //   27   58:iload_1         
    //   28   59:invokevirtual   #347 <Method ArrayList getJun(int)>
    //   29   62:astore_2        
            for(int j = 0; j < Jun.size(); j++)
    //*  30   63:iconst_0        
    //*  31   64:istore_3        
    //*  32   65:goto            86
                PrintNode((Integer)(Integer)Jun.get(j));
    //   33   68:aload_0         
    //   34   69:aload_2         
    //   35   70:iload_3         
    //   36   71:invokevirtual   #335 <Method Object ArrayList.get(int)>
    //   37   74:checkcast       #200 <Class Integer>
    //   38   77:checkcast       #200 <Class Integer>
    //   39   80:invokevirtual   #227 <Method void PrintNode(Integer)>

    //   40   83:iinc            3  1
    //   41   86:iload_3         
    //   42   87:aload_2         
    //   43   88:invokevirtual   #334 <Method int ArrayList.size()>
    //   44   91:icmplt          68
        }

    //   45   94:iinc            1  1
    //   46   97:iload_1         
    //   47   98:aload_0         
    //   48   99:getfield        #132 <Field int nnodes>
    //   49  102:icmplt          16
        log.append("Output the Seniors of nodes:\n");
    //   50  105:aload_0         
    //   51  106:getfield        #74  <Field StringBuffer log>
    //   52  109:ldc2            #349 <String "Output the Seniors of nodes:\n">
    //   53  112:invokevirtual   #101 <Method StringBuffer StringBuffer.append(String)>
    //   54  115:pop             
        for(int i = 0; i < nnodes; i++)
    //*  55  116:iconst_0        
    //*  56  117:istore_1        
    //*  57  118:goto            202
        {
            log.append((new StringBuilder(String.valueOf(i))).append("  :").append("\n").toString());
    //   58  121:aload_0         
    //   59  122:getfield        #74  <Field StringBuffer log>
    //   60  125:new             #76  <Class StringBuilder>
    //   61  128:dup             
    //   62  129:iload_1         
    //   63  130:invokestatic    #220 <Method String String.valueOf(int)>
    //   64  133:invokespecial   #81  <Method void StringBuilder(String)>
    //   65  136:ldc2            #345 <String "  :">
    //   66  139:invokevirtual   #90  <Method StringBuilder StringBuilder.append(String)>
    //   67  142:ldc1            #92  <String "\n">
    //   68  144:invokevirtual   #90  <Method StringBuilder StringBuilder.append(String)>
    //   69  147:invokevirtual   #96  <Method String StringBuilder.toString()>
    //   70  150:invokevirtual   #101 <Method StringBuffer StringBuffer.append(String)>
    //   71  153:pop             
            PrintNode(Integer.valueOf(i));
    //   72  154:aload_0         
    //   73  155:iload_1         
    //   74  156:invokestatic    #225 <Method Integer Integer.valueOf(int)>
    //   75  159:invokevirtual   #227 <Method void PrintNode(Integer)>
            ArrayList Sen = getSen(i);
    //   76  162:aload_0         
    //   77  163:iload_1         
    //   78  164:invokevirtual   #351 <Method ArrayList getSen(int)>
    //   79  167:astore_2        
            for(int j = 0; j < Sen.size(); j++)
    //*  80  168:iconst_0        
    //*  81  169:istore_3        
    //*  82  170:goto            191
                PrintNode((Integer)(Integer)Sen.get(j));
    //   83  173:aload_0         
    //   84  174:aload_2         
    //   85  175:iload_3         
    //   86  176:invokevirtual   #335 <Method Object ArrayList.get(int)>
    //   87  179:checkcast       #200 <Class Integer>
    //   88  182:checkcast       #200 <Class Integer>
    //   89  185:invokevirtual   #227 <Method void PrintNode(Integer)>

    //   90  188:iinc            3  1
    //   91  191:iload_3         
    //   92  192:aload_2         
    //   93  193:invokevirtual   #334 <Method int ArrayList.size()>
    //   94  196:icmplt          173
        }

    //   95  199:iinc            1  1
    //   96  202:iload_1         
    //   97  203:aload_0         
    //   98  204:getfield        #132 <Field int nnodes>
    //   99  207:icmplt          121
        log.append("Output the Thr:\n");
    //  100  210:aload_0         
    //  101  211:getfield        #74  <Field StringBuffer log>
    //  102  214:ldc2            #353 <String "Output the Thr:\n">
    //  103  217:invokevirtual   #101 <Method StringBuffer StringBuffer.append(String)>
    //  104  220:pop             
        ThrEdge temp = new ThrEdge();
    //  105  221:new             #286 <Class ReducedLattices$ThrEdge>
    //  106  224:dup             
    //  107  225:aload_0         
    //  108  226:invokespecial   #287 <Method void ReducedLattices$ThrEdge(ReducedLattices)>
    //  109  229:astore_1        
        for(int i = 0; i < nnodes; i++)
    //* 110  230:iconst_0        
    //* 111  231:istore_2        
    //* 112  232:goto            361
        {
            log.append((new StringBuilder(String.valueOf(i))).append("  :\n").toString());
    //  113  235:aload_0         
    //  114  236:getfield        #74  <Field StringBuffer log>
    //  115  239:new             #76  <Class StringBuilder>
    //  116  242:dup             
    //  117  243:iload_2         
    //  118  244:invokestatic    #220 <Method String String.valueOf(int)>
    //  119  247:invokespecial   #81  <Method void StringBuilder(String)>
    //  120  250:ldc2            #355 <String "  :\n">
    //  121  253:invokevirtual   #90  <Method StringBuilder StringBuilder.append(String)>
    //  122  256:invokevirtual   #96  <Method String StringBuilder.toString()>
    //  123  259:invokevirtual   #101 <Method StringBuffer StringBuffer.append(String)>
    //  124  262:pop             
            PrintNode(Integer.valueOf(i));
    //  125  263:aload_0         
    //  126  264:iload_2         
    //  127  265:invokestatic    #225 <Method Integer Integer.valueOf(int)>
    //  128  268:invokevirtual   #227 <Method void PrintNode(Integer)>
            ArrayList Thr = getThr(i);
    //  129  271:aload_0         
    //  130  272:iload_2         
    //  131  273:invokevirtual   #357 <Method ArrayList getThr(int)>
    //  132  276:astore_3        
            for(int j = 0; j < Thr.size(); j++)
    //* 133  277:iconst_0        
    //* 134  278:istore          4
    //* 135  280:goto            349
            {
                temp = (ThrEdge)(ThrEdge)Thr.get(j);
    //  136  283:aload_3         
    //  137  284:iload           4
    //  138  286:invokevirtual   #335 <Method Object ArrayList.get(int)>
    //  139  289:checkcast       #286 <Class ReducedLattices$ThrEdge>
    //  140  292:checkcast       #286 <Class ReducedLattices$ThrEdge>
    //  141  295:astore_1        
                log.append("low: \n");
    //  142  296:aload_0         
    //  143  297:getfield        #74  <Field StringBuffer log>
    //  144  300:ldc2            #359 <String "low: \n">
    //  145  303:invokevirtual   #101 <Method StringBuffer StringBuffer.append(String)>
    //  146  306:pop             
                PrintNode(Integer.valueOf(temp.r_low));
    //  147  307:aload_0         
    //  148  308:aload_1         
    //  149  309:getfield        #290 <Field int ReducedLattices$ThrEdge.r_low>
    //  150  312:invokestatic    #225 <Method Integer Integer.valueOf(int)>
    //  151  315:invokevirtual   #227 <Method void PrintNode(Integer)>
                log.append("super: \n");
    //  152  318:aload_0         
    //  153  319:getfield        #74  <Field StringBuffer log>
    //  154  322:ldc2            #361 <String "super: \n">
    //  155  325:invokevirtual   #101 <Method StringBuffer StringBuffer.append(String)>
    //  156  328:pop             
                PrintNode(Integer.valueOf(temp.r_super));
    //  157  329:aload_0         
    //  158  330:aload_1         
    //  159  331:getfield        #293 <Field int ReducedLattices$ThrEdge.r_super>
    //  160  334:invokestatic    #225 <Method Integer Integer.valueOf(int)>
    //  161  337:invokevirtual   #227 <Method void PrintNode(Integer)>
                System.out.println();
    //  162  340:getstatic       #367 <Field PrintStream System.out>
    //  163  343:invokevirtual   #372 <Method void PrintStream.println()>
            }

    //  164  346:iinc            4  1
    //  165  349:iload           4
    //  166  351:aload_3         
    //  167  352:invokevirtual   #334 <Method int ArrayList.size()>
    //  168  355:icmplt          283
        }

    //  169  358:iinc            2  1
    //  170  361:iload_2         
    //  171  362:aload_0         
    //  172  363:getfield        #132 <Field int nnodes>
    //  173  366:icmplt          235
    //  174  369:return          
    }

    protected boolean JudgeNoBoth(ArrayList Jun, ArrayList Sen, ArrayList Thr)
    {
        return wh * (Sen.size() + Jun.size()) + wr >= wh * Thr.size();
    //    0    0:aload_0         
    //    1    1:getfield        #45  <Field int wh>
    //    2    4:aload_2         
    //    3    5:invokevirtual   #334 <Method int ArrayList.size()>
    //    4    8:aload_1         
    //    5    9:invokevirtual   #334 <Method int ArrayList.size()>
    //    6   12:iadd            
    //    7   13:imul            
    //    8   14:aload_0         
    //    9   15:getfield        #39  <Field int wr>
    //   10   18:iadd            
    //   11   19:aload_0         
    //   12   20:getfield        #45  <Field int wh>
    //   13   23:aload_3         
    //   14   24:invokevirtual   #334 <Method int ArrayList.size()>
    //   15   27:imul            
    //   16   28:icmplt          33
    //   17   31:iconst_1        
    //   18   32:ireturn         
    //   19   33:iconst_0        
    //   20   34:ireturn         
    }

    protected boolean JudgeNoPerm(ArrayList Jun, ArrayList Sen, ArrayList Thr, int n)
    {
        return wr + wu * n + wh * (Sen.size() + Jun.size()) >= wu * n * Jun.size() + wh * Thr.size();
    //    0    0:aload_0         
    //    1    1:getfield        #39  <Field int wr>
    //    2    4:aload_0         
    //    3    5:getfield        #41  <Field int wu>
    //    4    8:iload           4
    //    5   10:imul            
    //    6   11:iadd            
    //    7   12:aload_0         
    //    8   13:getfield        #45  <Field int wh>
    //    9   16:aload_2         
    //   10   17:invokevirtual   #334 <Method int ArrayList.size()>
    //   11   20:aload_1         
    //   12   21:invokevirtual   #334 <Method int ArrayList.size()>
    //   13   24:iadd            
    //   14   25:imul            
    //   15   26:iadd            
    //   16   27:aload_0         
    //   17   28:getfield        #41  <Field int wu>
    //   18   31:iload           4
    //   19   33:imul            
    //   20   34:aload_1         
    //   21   35:invokevirtual   #334 <Method int ArrayList.size()>
    //   22   38:imul            
    //   23   39:aload_0         
    //   24   40:getfield        #45  <Field int wh>
    //   25   43:aload_3         
    //   26   44:invokevirtual   #334 <Method int ArrayList.size()>
    //   27   47:imul            
    //   28   48:iadd            
    //   29   49:icmplt          54
    //   30   52:iconst_1        
    //   31   53:ireturn         
    //   32   54:iconst_0        
    //   33   55:ireturn         
    }

    protected boolean JudgeNoUser(ArrayList Jun, ArrayList Sen, ArrayList Thr, int p)
    {
        return wr + wp * p + wh * (Sen.size() + Jun.size()) >= wp * p * Sen.size() + wh * Thr.size();
    //    0    0:aload_0         
    //    1    1:getfield        #39  <Field int wr>
    //    2    4:aload_0         
    //    3    5:getfield        #43  <Field int wp>
    //    4    8:iload           4
    //    5   10:imul            
    //    6   11:iadd            
    //    7   12:aload_0         
    //    8   13:getfield        #45  <Field int wh>
    //    9   16:aload_2         
    //   10   17:invokevirtual   #334 <Method int ArrayList.size()>
    //   11   20:aload_1         
    //   12   21:invokevirtual   #334 <Method int ArrayList.size()>
    //   13   24:iadd            
    //   14   25:imul            
    //   15   26:iadd            
    //   16   27:aload_0         
    //   17   28:getfield        #43  <Field int wp>
    //   18   31:iload           4
    //   19   33:imul            
    //   20   34:aload_2         
    //   21   35:invokevirtual   #334 <Method int ArrayList.size()>
    //   22   38:imul            
    //   23   39:aload_0         
    //   24   40:getfield        #45  <Field int wh>
    //   25   43:aload_3         
    //   26   44:invokevirtual   #334 <Method int ArrayList.size()>
    //   27   47:imul            
    //   28   48:iadd            
    //   29   49:icmplt          54
    //   30   52:iconst_1        
    //   31   53:ireturn         
    //   32   54:iconst_0        
    //   33   55:ireturn         
    }

    public void buildRoleminers(Assignment assignment)
        throws Exception
    {
    //    0    0:return          
    }

    public Assignment generateRoles()
    {
        return null;
    //    0    0:aconst_null     
    //    1    1:areturn         
    }

    private Context context;
    private StringBuffer log;
    protected int nnodes;
    protected Vector nodes;
    protected int nedges;
    protected Vector edges;
    private int noUser;
    private int noPerm;
    private int wr;
    private int wu;
    private int wp;
    private int wh;
    public ConceptSet allFormalConcepts;
}
