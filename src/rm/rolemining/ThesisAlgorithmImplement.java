// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   ThesisAlgorithmImplement.java

package rm.rolemining;

import java.util.*;
import rm.core.*;

// Referenced classes of package rm.rolemining:
//            AbstractRoleminer

public class ThesisAlgorithmImplement extends AbstractRoleminer
    implements OptionHandler
{
    public class Role
        implements Comparable
    {

        public Role clone()
        {
            Role role = new Role();
        //    0    0:new             #2   <Class ThesisAlgorithmImplement$Role>
        //    1    3:dup             
        //    2    4:aload_0         
        //    3    5:getfield        #23  <Field ThesisAlgorithmImplement this$0>
        //    4    8:invokespecial   #34  <Method void ThesisAlgorithmImplement$Role(ThesisAlgorithmImplement)>
        //    5   11:astore_1        
            role.setChildren(children);
        //    6   12:aload_1         
        //    7   13:aload_0         
        //    8   14:getfield        #36  <Field Vector children>
        //    9   17:invokevirtual   #40  <Method void setChildren(Vector)>
            role.setIndex(index);
        //   10   20:aload_1         
        //   11   21:aload_0         
        //   12   22:getfield        #42  <Field int index>
        //   13   25:invokevirtual   #46  <Method void setIndex(int)>
            role.setParents(parents);
        //   14   28:aload_1         
        //   15   29:aload_0         
        //   16   30:getfield        #48  <Field Vector parents>
        //   17   33:invokevirtual   #51  <Method void setParents(Vector)>
            role.setPerms(perms);
        //   18   36:aload_1         
        //   19   37:aload_0         
        //   20   38:getfield        #53  <Field Vector perms>
        //   21   41:invokevirtual   #56  <Method void setPerms(Vector)>
            role.setUsers(users);
        //   22   44:aload_1         
        //   23   45:aload_0         
        //   24   46:getfield        #58  <Field Vector users>
        //   25   49:invokevirtual   #61  <Method void setUsers(Vector)>
            return role;
        //   26   52:aload_1         
        //   27   53:areturn         
        }

        public Vector getPerms()
        {
            return perms;
        //    0    0:aload_0         
        //    1    1:getfield        #53  <Field Vector perms>
        //    2    4:areturn         
        }

        public void setPerms(Vector perms)
        {
            this.perms = perms;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #53  <Field Vector perms>
        //    3    5:return          
        }

        public Vector getUsers()
        {
            return users;
        //    0    0:aload_0         
        //    1    1:getfield        #58  <Field Vector users>
        //    2    4:areturn         
        }

        public void setUsers(Vector users)
        {
            this.users = users;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #58  <Field Vector users>
        //    3    5:return          
        }

        public int getIndex()
        {
            return index;
        //    0    0:aload_0         
        //    1    1:getfield        #42  <Field int index>
        //    2    4:ireturn         
        }

        public void setIndex(int index)
        {
            this.index = index;
        //    0    0:aload_0         
        //    1    1:iload_1         
        //    2    2:putfield        #42  <Field int index>
        //    3    5:return          
        }

        public int compareTo(Object object)
        {
            Role other = (Role)object;
        //    0    0:aload_1         
        //    1    1:checkcast       #2   <Class ThesisAlgorithmImplement$Role>
        //    2    4:astore_2        
            if(perms.size() < other.perms.size())
        //*   3    5:aload_0         
        //*   4    6:getfield        #53  <Field Vector perms>
        //*   5    9:invokevirtual   #77  <Method int Vector.size()>
        //*   6   12:aload_2         
        //*   7   13:getfield        #53  <Field Vector perms>
        //*   8   16:invokevirtual   #77  <Method int Vector.size()>
        //*   9   19:icmpge          24
                return 1;
        //   10   22:iconst_1        
        //   11   23:ireturn         
            return perms.size() >= other.perms.size() ? -1 : 0;
        //   12   24:aload_0         
        //   13   25:getfield        #53  <Field Vector perms>
        //   14   28:invokevirtual   #77  <Method int Vector.size()>
        //   15   31:aload_2         
        //   16   32:getfield        #53  <Field Vector perms>
        //   17   35:invokevirtual   #77  <Method int Vector.size()>
        //   18   38:icmpge          43
        //   19   41:iconst_0        
        //   20   42:ireturn         
        //   21   43:iconst_m1       
        //   22   44:ireturn         
        }

        public Vector getChildren()
        {
            return children;
        //    0    0:aload_0         
        //    1    1:getfield        #36  <Field Vector children>
        //    2    4:areturn         
        }

        public void setChildren(Vector children)
        {
            this.children = children;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #36  <Field Vector children>
        //    3    5:return          
        }

        public Vector getParents()
        {
            return parents;
        //    0    0:aload_0         
        //    1    1:getfield        #48  <Field Vector parents>
        //    2    4:areturn         
        }

        public void setParents(Vector parents)
        {
            this.parents = parents;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #48  <Field Vector parents>
        //    3    5:return          
        }

        protected volatile Object clone()
        {
            return clone();
        //    0    0:aload_0         
        //    1    1:invokevirtual   #87  <Method ThesisAlgorithmImplement$Role clone()>
        //    2    4:areturn         
        }

        int index;
        Vector children;
        Vector parents;
        Vector users;
        Vector perms;
        final ThesisAlgorithmImplement this$0;

        public Role()
        {
            this$0 = ThesisAlgorithmImplement.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #23  <Field ThesisAlgorithmImplement this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #26  <Method void Object()>
        //    5    9:return          
        }
    }

    public class Role2Count
    {

        public int getCount()
        {
            return count;
        //    0    0:aload_0         
        //    1    1:getfield        #27  <Field int count>
        //    2    4:ireturn         
        }

        public void setCount(int count)
        {
            this.count = count;
        //    0    0:aload_0         
        //    1    1:iload_1         
        //    2    2:putfield        #27  <Field int count>
        //    3    5:return          
        }

        public int getIndex()
        {
            return index;
        //    0    0:aload_0         
        //    1    1:getfield        #32  <Field int index>
        //    2    4:ireturn         
        }

        public void setIndex(int index)
        {
            this.index = index;
        //    0    0:aload_0         
        //    1    1:iload_1         
        //    2    2:putfield        #32  <Field int index>
        //    3    5:return          
        }

        public Role getRole()
        {
            return role;
        //    0    0:aload_0         
        //    1    1:getfield        #37  <Field ThesisAlgorithmImplement$Role role>
        //    2    4:areturn         
        }

        public void setRole(Role role)
        {
            this.role = role;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #37  <Field ThesisAlgorithmImplement$Role role>
        //    3    5:return          
        }

        Role role;
        int count;
        int index;
        final ThesisAlgorithmImplement this$0;

        public Role2Count()
        {
            this$0 = ThesisAlgorithmImplement.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #16  <Field ThesisAlgorithmImplement this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #19  <Method void Object()>
        //    5    9:return          
        }
    }


    public ThesisAlgorithmImplement()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #51  <Method void AbstractRoleminer()>
        permissions = new Vector();
    //    2    4:aload_0         
    //    3    5:new             #53  <Class Vector>
    //    4    8:dup             
    //    5    9:invokespecial   #54  <Method void Vector()>
    //    6   12:putfield        #56  <Field Vector permissions>
        userCandidateRoles = new Vector();
    //    7   15:aload_0         
    //    8   16:new             #53  <Class Vector>
    //    9   19:dup             
    //   10   20:invokespecial   #54  <Method void Vector()>
    //   11   23:putfield        #58  <Field Vector userCandidateRoles>
        initRoles = new Vector();
    //   12   26:aload_0         
    //   13   27:new             #53  <Class Vector>
    //   14   30:dup             
    //   15   31:invokespecial   #54  <Method void Vector()>
    //   16   34:putfield        #60  <Field Vector initRoles>
        defaultRoles = new Vector();
    //   17   37:aload_0         
    //   18   38:new             #53  <Class Vector>
    //   19   41:dup             
    //   20   42:invokespecial   #54  <Method void Vector()>
    //   21   45:putfield        #62  <Field Vector defaultRoles>
        FinalRoles = new Vector();
    //   22   48:aload_0         
    //   23   49:new             #53  <Class Vector>
    //   24   52:dup             
    //   25   53:invokespecial   #54  <Method void Vector()>
    //   26   56:putfield        #64  <Field Vector FinalRoles>
        users = new Vector();
    //   27   59:aload_0         
    //   28   60:new             #53  <Class Vector>
    //   29   63:dup             
    //   30   64:invokespecial   #54  <Method void Vector()>
    //   31   67:putfield        #66  <Field Vector users>
        log = new StringBuffer();
    //   32   70:aload_0         
    //   33   71:new             #68  <Class StringBuffer>
    //   34   74:dup             
    //   35   75:invokespecial   #69  <Method void StringBuffer()>
    //   36   78:putfield        #71  <Field StringBuffer log>
        resetOptions();
    //   37   81:aload_0         
    //   38   82:invokevirtual   #74  <Method void resetOptions()>
    //   39   85:return          
    }

    public void buildRoleminers(Assignment data)
        throws Exception
    {
        m_assignment = data;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #83  <Field Assignment m_assignment>
        ConstructionInitialRole(data);
    //    3    5:aload_0         
    //    4    6:aload_1         
    //    5    7:invokespecial   #86  <Method void ConstructionInitialRole(Assignment)>
        Role role;
        for(Iterator iterator = initRoles.iterator(); iterator.hasNext(); FinalRoles.add(role))
    //*   6   10:aload_0         
    //*   7   11:getfield        #60  <Field Vector initRoles>
    //*   8   14:invokevirtual   #90  <Method Iterator Vector.iterator()>
    //*   9   17:astore_3        
    //*  10   18:goto            40
            role = (Role)iterator.next();
    //   11   21:aload_3         
    //   12   22:invokeinterface #96  <Method Object Iterator.next()>
    //   13   27:checkcast       #98  <Class ThesisAlgorithmImplement$Role>
    //   14   30:astore_2        

    //   15   31:aload_0         
    //   16   32:getfield        #64  <Field Vector FinalRoles>
    //   17   35:aload_2         
    //   18   36:invokevirtual   #102 <Method boolean Vector.add(Object)>
    //   19   39:pop             
    //   20   40:aload_3         
    //   21   41:invokeinterface #106 <Method boolean Iterator.hasNext()>
    //   22   46:ifne            21
        GenerateFinalRole();
    //   23   49:aload_0         
    //   24   50:invokespecial   #109 <Method void GenerateFinalRole()>
        Collections.sort(FinalRoles);
    //   25   53:aload_0         
    //   26   54:getfield        #64  <Field Vector FinalRoles>
    //   27   57:invokestatic    #115 <Method void Collections.sort(java.util.List)>
        log.append((new StringBuilder("\u5F97\u5230\u7684\u89D2\u8272\u6570\u4E3A: ")).append(FinalRoles.size()).append("\n").toString());
    //   28   60:aload_0         
    //   29   61:getfield        #71  <Field StringBuffer log>
    //   30   64:new             #117 <Class StringBuilder>
    //   31   67:dup             
    //   32   68:ldc1            #119 <String "\u5F97\u5230\u7684\u89D2\u8272\u6570\u4E3A: ">
    //   33   70:invokespecial   #122 <Method void StringBuilder(String)>
    //   34   73:aload_0         
    //   35   74:getfield        #64  <Field Vector FinalRoles>
    //   36   77:invokevirtual   #126 <Method int Vector.size()>
    //   37   80:invokevirtual   #130 <Method StringBuilder StringBuilder.append(int)>
    //   38   83:ldc1            #132 <String "\n">
    //   39   85:invokevirtual   #135 <Method StringBuilder StringBuilder.append(String)>
    //   40   88:invokevirtual   #139 <Method String StringBuilder.toString()>
    //   41   91:invokevirtual   #142 <Method StringBuffer StringBuffer.append(String)>
    //   42   94:pop             
        double wsc = CalculateWSC();
    //   43   95:aload_0         
    //   44   96:invokespecial   #146 <Method double CalculateWSC()>
    //   45   99:dstore_2        
        log.append((new StringBuilder("\u6700\u7EC8\u7684wsc\u4E3A: ")).append(wsc).append("\n").toString());
    //   46  100:aload_0         
    //   47  101:getfield        #71  <Field StringBuffer log>
    //   48  104:new             #117 <Class StringBuilder>
    //   49  107:dup             
    //   50  108:ldc1            #148 <String "\u6700\u7EC8\u7684wsc\u4E3A: ">
    //   51  110:invokespecial   #122 <Method void StringBuilder(String)>
    //   52  113:dload_2         
    //   53  114:invokevirtual   #151 <Method StringBuilder StringBuilder.append(double)>
    //   54  117:ldc1            #132 <String "\n">
    //   55  119:invokevirtual   #135 <Method StringBuilder StringBuilder.append(String)>
    //   56  122:invokevirtual   #139 <Method String StringBuilder.toString()>
    //   57  125:invokevirtual   #142 <Method StringBuffer StringBuffer.append(String)>
    //   58  128:pop             
        int UA = 0;
    //   59  129:iconst_0        
    //   60  130:istore          4
        int PA = 0;
    //   61  132:iconst_0        
    //   62  133:istore          5
        int RH = 0;
    //   63  135:iconst_0        
    //   64  136:istore          6
        for(Iterator iterator1 = FinalRoles.iterator(); iterator1.hasNext();)
    //*  65  138:aload_0         
    //*  66  139:getfield        #64  <Field Vector FinalRoles>
    //*  67  142:invokevirtual   #90  <Method Iterator Vector.iterator()>
    //*  68  145:astore          8
    //*  69  147:goto            216
        {
            Role role = (Role)iterator1.next();
    //   70  150:aload           8
    //   71  152:invokeinterface #96  <Method Object Iterator.next()>
    //   72  157:checkcast       #98  <Class ThesisAlgorithmImplement$Role>
    //   73  160:astore          7
            UA += wu * role.getUsers().size();
    //   74  162:iload           4
    //   75  164:aload_0         
    //   76  165:getfield        #153 <Field int wu>
    //   77  168:aload           7
    //   78  170:invokevirtual   #157 <Method Vector ThesisAlgorithmImplement$Role.getUsers()>
    //   79  173:invokevirtual   #126 <Method int Vector.size()>
    //   80  176:imul            
    //   81  177:iadd            
    //   82  178:istore          4
            PA += wp * role.getPerms().size();
    //   83  180:iload           5
    //   84  182:aload_0         
    //   85  183:getfield        #159 <Field int wp>
    //   86  186:aload           7
    //   87  188:invokevirtual   #162 <Method Vector ThesisAlgorithmImplement$Role.getPerms()>
    //   88  191:invokevirtual   #126 <Method int Vector.size()>
    //   89  194:imul            
    //   90  195:iadd            
    //   91  196:istore          5
            RH += wh * role.getParents().size();
    //   92  198:iload           6
    //   93  200:aload_0         
    //   94  201:getfield        #164 <Field int wh>
    //   95  204:aload           7
    //   96  206:invokevirtual   #167 <Method Vector ThesisAlgorithmImplement$Role.getParents()>
    //   97  209:invokevirtual   #126 <Method int Vector.size()>
    //   98  212:imul            
    //   99  213:iadd            
    //  100  214:istore          6
        }

    //  101  216:aload           8
    //  102  218:invokeinterface #106 <Method boolean Iterator.hasNext()>
    //  103  223:ifne            150
        log.append((new StringBuilder("UA,PA,RH: ")).append(UA).append(" ").append(PA).append(" ").append(RH).append("\n").toString());
    //  104  226:aload_0         
    //  105  227:getfield        #71  <Field StringBuffer log>
    //  106  230:new             #117 <Class StringBuilder>
    //  107  233:dup             
    //  108  234:ldc1            #169 <String "UA,PA,RH: ">
    //  109  236:invokespecial   #122 <Method void StringBuilder(String)>
    //  110  239:iload           4
    //  111  241:invokevirtual   #130 <Method StringBuilder StringBuilder.append(int)>
    //  112  244:ldc1            #171 <String " ">
    //  113  246:invokevirtual   #135 <Method StringBuilder StringBuilder.append(String)>
    //  114  249:iload           5
    //  115  251:invokevirtual   #130 <Method StringBuilder StringBuilder.append(int)>
    //  116  254:ldc1            #171 <String " ">
    //  117  256:invokevirtual   #135 <Method StringBuilder StringBuilder.append(String)>
    //  118  259:iload           6
    //  119  261:invokevirtual   #130 <Method StringBuilder StringBuilder.append(int)>
    //  120  264:ldc1            #132 <String "\n">
    //  121  266:invokevirtual   #135 <Method StringBuilder StringBuilder.append(String)>
    //  122  269:invokevirtual   #139 <Method String StringBuilder.toString()>
    //  123  272:invokevirtual   #142 <Method StringBuffer StringBuffer.append(String)>
    //  124  275:pop             
    //  125  276:return          
    }

    private void ConstructionInitialRole(Assignment ass)
    {
        Matrix mat = ass.getAssignmentMatrix();
    //    0    0:aload_1         
    //    1    1:invokevirtual   #184 <Method Matrix Assignment.getAssignmentMatrix()>
    //    2    4:astore_2        
        Attribute usersAttr = ass.getDimensionX().getDimensionAttribute();
    //    3    5:aload_1         
    //    4    6:invokevirtual   #188 <Method Dimension Assignment.getDimensionX()>
    //    5    9:invokevirtual   #194 <Method Attribute Dimension.getDimensionAttribute()>
    //    6   12:astore_3        
        Attribute permissionsAttr = ass.getDimensionY().getDimensionAttribute();
    //    7   13:aload_1         
    //    8   14:invokevirtual   #197 <Method Dimension Assignment.getDimensionY()>
    //    9   17:invokevirtual   #194 <Method Attribute Dimension.getDimensionAttribute()>
    //   10   20:astore          4
        SplitAttruteString(ass.getDimensionY().getDimensionAttribute(), permissions);
    //   11   22:aload_0         
    //   12   23:aload_1         
    //   13   24:invokevirtual   #197 <Method Dimension Assignment.getDimensionY()>
    //   14   27:invokevirtual   #194 <Method Attribute Dimension.getDimensionAttribute()>
    //   15   30:aload_0         
    //   16   31:getfield        #56  <Field Vector permissions>
    //   17   34:invokespecial   #201 <Method void SplitAttruteString(Attribute, Vector)>
        SplitAttruteString(ass.getDimensionX().getDimensionAttribute(), users);
    //   18   37:aload_0         
    //   19   38:aload_1         
    //   20   39:invokevirtual   #188 <Method Dimension Assignment.getDimensionX()>
    //   21   42:invokevirtual   #194 <Method Attribute Dimension.getDimensionAttribute()>
    //   22   45:aload_0         
    //   23   46:getfield        #66  <Field Vector users>
    //   24   49:invokespecial   #201 <Method void SplitAttruteString(Attribute, Vector)>
        CreateInitCandidateRole(mat);
    //   25   52:aload_0         
    //   26   53:aload_2         
    //   27   54:invokespecial   #205 <Method void CreateInitCandidateRole(Matrix)>
        GenerateInitialRole(mat);
    //   28   57:aload_0         
    //   29   58:aload_2         
    //   30   59:invokespecial   #208 <Method void GenerateInitialRole(Matrix)>
    //   31   62:return          
    }

    private void GenerateFinalRole()
    {
        Collections.sort(FinalRoles);
    //    0    0:aload_0         
    //    1    1:getfield        #64  <Field Vector FinalRoles>
    //    2    4:invokestatic    #115 <Method void Collections.sort(java.util.List)>
        for(Iterator iterator = FinalRoles.iterator(); iterator.hasNext();)
    //*   3    7:aload_0         
    //*   4    8:getfield        #64  <Field Vector FinalRoles>
    //*   5   11:invokevirtual   #90  <Method Iterator Vector.iterator()>
    //*   6   14:astore_2        
    //*   7   15:goto            49
        {
            Role role = (Role)iterator.next();
    //    8   18:aload_2         
    //    9   19:invokeinterface #96  <Method Object Iterator.next()>
    //   10   24:checkcast       #98  <Class ThesisAlgorithmImplement$Role>
    //   11   27:astore_1        
            if(role.getIndex() == -1)
    //*  12   28:aload_1         
    //*  13   29:invokevirtual   #217 <Method int ThesisAlgorithmImplement$Role.getIndex()>
    //*  14   32:iconst_m1       
    //*  15   33:icmpne          49
                role.setIndex(roleAscending++);
    //   16   36:aload_1         
    //   17   37:getstatic       #44  <Field int roleAscending>
    //   18   40:dup             
    //   19   41:iconst_1        
    //   20   42:iadd            
    //   21   43:putstatic       #44  <Field int roleAscending>
    //   22   46:invokevirtual   #221 <Method void ThesisAlgorithmImplement$Role.setIndex(int)>
        }

    //   23   49:aload_2         
    //   24   50:invokeinterface #106 <Method boolean Iterator.hasNext()>
    //   25   55:ifne            18
        boolean done = true;
    //   26   58:iconst_1        
    //   27   59:istore_1        
    //*  28   60:goto            80
        while(done) 
        {
            done = false;
    //   29   63:iconst_0        
    //   30   64:istore_1        
            HandleEquality(done);
    //   31   65:aload_0         
    //   32   66:iload_1         
    //   33   67:invokespecial   #225 <Method void HandleEquality(boolean)>
            HandleSubSet(done);
    //   34   70:aload_0         
    //   35   71:iload_1         
    //   36   72:invokespecial   #228 <Method void HandleSubSet(boolean)>
            HandleIntersection(done);
    //   37   75:aload_0         
    //   38   76:iload_1         
    //   39   77:invokespecial   #231 <Method void HandleIntersection(boolean)>
        }
    //   40   80:iload_1         
    //   41   81:ifne            63
    //   42   84:return          
    }

    private void HandleIntersection(boolean done)
    {
        Collections.sort(FinalRoles);
    //    0    0:aload_0         
    //    1    1:getfield        #64  <Field Vector FinalRoles>
    //    2    4:invokestatic    #115 <Method void Collections.sort(java.util.List)>
        for(int i = 0; i < FinalRoles.size() - 1; i++)
    //*   3    7:iconst_0        
    //*   4    8:istore_2        
    //*   5    9:goto            502
        {
            Role CurFirtRole = (Role)FinalRoles.get(i);
    //    6   12:aload_0         
    //    7   13:getfield        #64  <Field Vector FinalRoles>
    //    8   16:iload_2         
    //    9   17:invokevirtual   #237 <Method Object Vector.get(int)>
    //   10   20:checkcast       #98  <Class ThesisAlgorithmImplement$Role>
    //   11   23:astore_3        
            if(CurFirtRole.getIndex() >= threshold)
    //*  12   24:aload_3         
    //*  13   25:invokevirtual   #217 <Method int ThesisAlgorithmImplement$Role.getIndex()>
    //*  14   28:getstatic       #46  <Field int threshold>
    //*  15   31:icmpge          37
    //*  16   34:goto            499
            {
                for(int j = i + 1; j < FinalRoles.size(); j++)
    //*  17   37:iload_2         
    //*  18   38:iconst_1        
    //*  19   39:iadd            
    //*  20   40:istore          4
    //*  21   42:goto            487
                {
                    Role CurSendRole = (Role)FinalRoles.get(j);
    //   22   45:aload_0         
    //   23   46:getfield        #64  <Field Vector FinalRoles>
    //   24   49:iload           4
    //   25   51:invokevirtual   #237 <Method Object Vector.get(int)>
    //   26   54:checkcast       #98  <Class ThesisAlgorithmImplement$Role>
    //   27   57:astore          5
                    if(CurSendRole.getIndex() >= threshold)
    //*  28   59:aload           5
    //*  29   61:invokevirtual   #217 <Method int ThesisAlgorithmImplement$Role.getIndex()>
    //*  30   64:getstatic       #46  <Field int threshold>
    //*  31   67:icmpge          73
    //*  32   70:goto            484
                    {
                        Vector CommonPerms = GetCommonElement(CurFirtRole.getPerms(), CurSendRole.getPerms());
    //   33   73:aload_0         
    //   34   74:aload_3         
    //   35   75:invokevirtual   #162 <Method Vector ThesisAlgorithmImplement$Role.getPerms()>
    //   36   78:aload           5
    //   37   80:invokevirtual   #162 <Method Vector ThesisAlgorithmImplement$Role.getPerms()>
    //   38   83:invokespecial   #241 <Method Vector GetCommonElement(Vector, Vector)>
    //   39   86:astore          6
                        if(CommonPerms.size() > 0 && CommonPerms.size() != CurFirtRole.getPerms().size() && CommonPerms.size() != CurSendRole.getPerms().size())
    //*  40   88:aload           6
    //*  41   90:invokevirtual   #126 <Method int Vector.size()>
    //*  42   93:ifle            484
    //*  43   96:aload           6
    //*  44   98:invokevirtual   #126 <Method int Vector.size()>
    //*  45  101:aload_3         
    //*  46  102:invokevirtual   #162 <Method Vector ThesisAlgorithmImplement$Role.getPerms()>
    //*  47  105:invokevirtual   #126 <Method int Vector.size()>
    //*  48  108:icmpeq          484
    //*  49  111:aload           6
    //*  50  113:invokevirtual   #126 <Method int Vector.size()>
    //*  51  116:aload           5
    //*  52  118:invokevirtual   #162 <Method Vector ThesisAlgorithmImplement$Role.getPerms()>
    //*  53  121:invokevirtual   #126 <Method int Vector.size()>
    //*  54  124:icmpeq          484
                        {
                            double PreSim = RolePreSimilarity(CurFirtRole, CurSendRole);
    //   55  127:aload_0         
    //   56  128:aload_3         
    //   57  129:aload           5
    //   58  131:invokespecial   #245 <Method double RolePreSimilarity(ThesisAlgorithmImplement$Role, ThesisAlgorithmImplement$Role)>
    //   59  134:dstore          7
                            double PreWSC = CalculateWSC();
    //   60  136:aload_0         
    //   61  137:invokespecial   #146 <Method double CalculateWSC()>
    //   62  140:dstore          9
                            double PreGOF = (1.0D - wf) * PreWSC + wf * PreWSC * PreSim;
    //   63  142:dconst_1        
    //   64  143:aload_0         
    //   65  144:getfield        #247 <Field double wf>
    //   66  147:dsub            
    //   67  148:dload           9
    //   68  150:dmul            
    //   69  151:aload_0         
    //   70  152:getfield        #247 <Field double wf>
    //   71  155:dload           9
    //   72  157:dmul            
    //   73  158:dload           7
    //   74  160:dmul            
    //   75  161:dadd            
    //   76  162:dstore          11
                            Vector saveRoles = new Vector();
    //   77  164:new             #53  <Class Vector>
    //   78  167:dup             
    //   79  168:invokespecial   #54  <Method void Vector()>
    //   80  171:astore          13
                            Role role;
                            for(Iterator iterator = FinalRoles.iterator(); iterator.hasNext(); saveRoles.add(role))
    //*  81  173:aload_0         
    //*  82  174:getfield        #64  <Field Vector FinalRoles>
    //*  83  177:invokevirtual   #90  <Method Iterator Vector.iterator()>
    //*  84  180:astore          15
    //*  85  182:goto            205
                                role = (Role)iterator.next();
    //   86  185:aload           15
    //   87  187:invokeinterface #96  <Method Object Iterator.next()>
    //   88  192:checkcast       #98  <Class ThesisAlgorithmImplement$Role>
    //   89  195:astore          14

    //   90  197:aload           13
    //   91  199:aload           14
    //   92  201:invokevirtual   #102 <Method boolean Vector.add(Object)>
    //   93  204:pop             
    //   94  205:aload           15
    //   95  207:invokeinterface #106 <Method boolean Iterator.hasNext()>
    //   96  212:ifne            185
                            role = new Role();
    //   97  215:new             #98  <Class ThesisAlgorithmImplement$Role>
    //   98  218:dup             
    //   99  219:aload_0         
    //  100  220:invokespecial   #250 <Method void ThesisAlgorithmImplement$Role(ThesisAlgorithmImplement)>
    //  101  223:astore          14
                            role.setPerms(CommonPerms);
    //  102  225:aload           14
    //  103  227:aload           6
    //  104  229:invokevirtual   #254 <Method void ThesisAlgorithmImplement$Role.setPerms(Vector)>
                            role.setIndex(roleAscending++);
    //  105  232:aload           14
    //  106  234:getstatic       #44  <Field int roleAscending>
    //  107  237:dup             
    //  108  238:iconst_1        
    //  109  239:iadd            
    //  110  240:putstatic       #44  <Field int roleAscending>
    //  111  243:invokevirtual   #221 <Method void ThesisAlgorithmImplement$Role.setIndex(int)>
                            Vector CurParents = new Vector();
    //  112  246:new             #53  <Class Vector>
    //  113  249:dup             
    //  114  250:invokespecial   #54  <Method void Vector()>
    //  115  253:astore          15
                            CurParents.add(Integer.valueOf(CurFirtRole.getIndex()));
    //  116  255:aload           15
    //  117  257:aload_3         
    //  118  258:invokevirtual   #217 <Method int ThesisAlgorithmImplement$Role.getIndex()>
    //  119  261:invokestatic    #260 <Method Integer Integer.valueOf(int)>
    //  120  264:invokevirtual   #102 <Method boolean Vector.add(Object)>
    //  121  267:pop             
                            CurParents.add(Integer.valueOf(CurSendRole.getIndex()));
    //  122  268:aload           15
    //  123  270:aload           5
    //  124  272:invokevirtual   #217 <Method int ThesisAlgorithmImplement$Role.getIndex()>
    //  125  275:invokestatic    #260 <Method Integer Integer.valueOf(int)>
    //  126  278:invokevirtual   #102 <Method boolean Vector.add(Object)>
    //  127  281:pop             
                            role.setParents(CurParents);
    //  128  282:aload           14
    //  129  284:aload           15
    //  130  286:invokevirtual   #263 <Method void ThesisAlgorithmImplement$Role.setParents(Vector)>
                            Vector CurUsers = new Vector();
    //  131  289:new             #53  <Class Vector>
    //  132  292:dup             
    //  133  293:invokespecial   #54  <Method void Vector()>
    //  134  296:astore          16
                            role.setUsers(CurUsers);
    //  135  298:aload           14
    //  136  300:aload           16
    //  137  302:invokevirtual   #266 <Method void ThesisAlgorithmImplement$Role.setUsers(Vector)>
                            Vector CurChildren = new Vector();
    //  138  305:new             #53  <Class Vector>
    //  139  308:dup             
    //  140  309:invokespecial   #54  <Method void Vector()>
    //  141  312:astore          17
                            role.setChildren(CurChildren);
    //  142  314:aload           14
    //  143  316:aload           17
    //  144  318:invokevirtual   #269 <Method void ThesisAlgorithmImplement$Role.setChildren(Vector)>
                            FinalRoles.add(role);
    //  145  321:aload_0         
    //  146  322:getfield        #64  <Field Vector FinalRoles>
    //  147  325:aload           14
    //  148  327:invokevirtual   #102 <Method boolean Vector.add(Object)>
    //  149  330:pop             
                            CurFirtRole.getChildren().add(Integer.valueOf(role.getIndex()));
    //  150  331:aload_3         
    //  151  332:invokevirtual   #272 <Method Vector ThesisAlgorithmImplement$Role.getChildren()>
    //  152  335:aload           14
    //  153  337:invokevirtual   #217 <Method int ThesisAlgorithmImplement$Role.getIndex()>
    //  154  340:invokestatic    #260 <Method Integer Integer.valueOf(int)>
    //  155  343:invokevirtual   #102 <Method boolean Vector.add(Object)>
    //  156  346:pop             
                            CurSendRole.getChildren().add(Integer.valueOf(role.getIndex()));
    //  157  347:aload           5
    //  158  349:invokevirtual   #272 <Method Vector ThesisAlgorithmImplement$Role.getChildren()>
    //  159  352:aload           14
    //  160  354:invokevirtual   #217 <Method int ThesisAlgorithmImplement$Role.getIndex()>
    //  161  357:invokestatic    #260 <Method Integer Integer.valueOf(int)>
    //  162  360:invokevirtual   #102 <Method boolean Vector.add(Object)>
    //  163  363:pop             
                            removeAll(CurFirtRole.getPerms(), CommonPerms);
    //  164  364:aload_0         
    //  165  365:aload_3         
    //  166  366:invokevirtual   #162 <Method Vector ThesisAlgorithmImplement$Role.getPerms()>
    //  167  369:aload           6
    //  168  371:invokespecial   #276 <Method void removeAll(Vector, Vector)>
                            removeAll(CurSendRole.getPerms(), CommonPerms);
    //  169  374:aload_0         
    //  170  375:aload           5
    //  171  377:invokevirtual   #162 <Method Vector ThesisAlgorithmImplement$Role.getPerms()>
    //  172  380:aload           6
    //  173  382:invokespecial   #276 <Method void removeAll(Vector, Vector)>
                            double CurSim = RolePreSimilarity(CurFirtRole, CurSendRole);
    //  174  385:aload_0         
    //  175  386:aload_3         
    //  176  387:aload           5
    //  177  389:invokespecial   #245 <Method double RolePreSimilarity(ThesisAlgorithmImplement$Role, ThesisAlgorithmImplement$Role)>
    //  178  392:dstore          18
                            double CurWSC = CalculateWSC();
    //  179  394:aload_0         
    //  180  395:invokespecial   #146 <Method double CalculateWSC()>
    //  181  398:dstore          20
                            double CurGoF = (1.0D - wf) * CurWSC + wf * CurWSC * CurSim;
    //  182  400:dconst_1        
    //  183  401:aload_0         
    //  184  402:getfield        #247 <Field double wf>
    //  185  405:dsub            
    //  186  406:dload           20
    //  187  408:dmul            
    //  188  409:aload_0         
    //  189  410:getfield        #247 <Field double wf>
    //  190  413:dload           20
    //  191  415:dmul            
    //  192  416:dload           18
    //  193  418:dmul            
    //  194  419:dadd            
    //  195  420:dstore          22
                            if(CurGoF > PreGOF)
    //* 196  422:dload           22
    //* 197  424:dload           11
    //* 198  426:dcmpl           
    //* 199  427:ifle            482
                            {
                                FinalRoles.clear();
    //  200  430:aload_0         
    //  201  431:getfield        #64  <Field Vector FinalRoles>
    //  202  434:invokevirtual   #279 <Method void Vector.clear()>
                                Role tmpRole;
                                for(Iterator iterator1 = saveRoles.iterator(); iterator1.hasNext(); FinalRoles.add(tmpRole))
    //* 203  437:aload           13
    //* 204  439:invokevirtual   #90  <Method Iterator Vector.iterator()>
    //* 205  442:astore          25
    //* 206  444:goto            469
                                    tmpRole = (Role)iterator1.next();
    //  207  447:aload           25
    //  208  449:invokeinterface #96  <Method Object Iterator.next()>
    //  209  454:checkcast       #98  <Class ThesisAlgorithmImplement$Role>
    //  210  457:astore          24

    //  211  459:aload_0         
    //  212  460:getfield        #64  <Field Vector FinalRoles>
    //  213  463:aload           24
    //  214  465:invokevirtual   #102 <Method boolean Vector.add(Object)>
    //  215  468:pop             
    //  216  469:aload           25
    //  217  471:invokeinterface #106 <Method boolean Iterator.hasNext()>
    //  218  476:ifne            447
                            } else
    //* 219  479:goto            484
                            {
                                done = true;
    //  220  482:iconst_1        
    //  221  483:istore_1        
                            }
                        }
                    }
                }

    //  222  484:iinc            4  1
    //  223  487:iload           4
    //  224  489:aload_0         
    //  225  490:getfield        #64  <Field Vector FinalRoles>
    //  226  493:invokevirtual   #126 <Method int Vector.size()>
    //  227  496:icmplt          45
            }
        }

    //  228  499:iinc            2  1
    //  229  502:iload_2         
    //  230  503:aload_0         
    //  231  504:getfield        #64  <Field Vector FinalRoles>
    //  232  507:invokevirtual   #126 <Method int Vector.size()>
    //  233  510:iconst_1        
    //  234  511:isub            
    //  235  512:icmplt          12
    //  236  515:return          
    }

    private void HandleSubSet(boolean done)
    {
        Collections.sort(FinalRoles);
    //    0    0:aload_0         
    //    1    1:getfield        #64  <Field Vector FinalRoles>
    //    2    4:invokestatic    #115 <Method void Collections.sort(java.util.List)>
        int size = FinalRoles.size();
    //    3    7:aload_0         
    //    4    8:getfield        #64  <Field Vector FinalRoles>
    //    5   11:invokevirtual   #126 <Method int Vector.size()>
    //    6   14:istore_2        
        for(int i = 0; i < size - 1; i++)
    //*   7   15:iconst_0        
    //*   8   16:istore_3        
    //*   9   17:goto            378
        {
            for(int j = i + 1; j < size; j++)
    //*  10   20:iload_3         
    //*  11   21:iconst_1        
    //*  12   22:iadd            
    //*  13   23:istore          4
    //*  14   25:goto            369
            {
                Role CurRole = (Role)FinalRoles.get(i);
    //   15   28:aload_0         
    //   16   29:getfield        #64  <Field Vector FinalRoles>
    //   17   32:iload_3         
    //   18   33:invokevirtual   #237 <Method Object Vector.get(int)>
    //   19   36:checkcast       #98  <Class ThesisAlgorithmImplement$Role>
    //   20   39:astore          5
                Role SubRole = (Role)FinalRoles.get(j);
    //   21   41:aload_0         
    //   22   42:getfield        #64  <Field Vector FinalRoles>
    //   23   45:iload           4
    //   24   47:invokevirtual   #237 <Method Object Vector.get(int)>
    //   25   50:checkcast       #98  <Class ThesisAlgorithmImplement$Role>
    //   26   53:astore          6
                if(CurRole.getIndex() >= threshold || SubRole.getIndex() >= threshold)
    //*  27   55:aload           5
    //*  28   57:invokevirtual   #217 <Method int ThesisAlgorithmImplement$Role.getIndex()>
    //*  29   60:getstatic       #46  <Field int threshold>
    //*  30   63:icmpge          80
    //*  31   66:aload           6
    //*  32   68:invokevirtual   #217 <Method int ThesisAlgorithmImplement$Role.getIndex()>
    //*  33   71:getstatic       #46  <Field int threshold>
    //*  34   74:icmpge          80
    //*  35   77:goto            366
                {
                    if(CurRole.getIndex() < threshold)
    //*  36   80:aload           5
    //*  37   82:invokevirtual   #217 <Method int ThesisAlgorithmImplement$Role.getIndex()>
    //*  38   85:getstatic       #46  <Field int threshold>
    //*  39   88:icmpge          112
                    {
                        Role tmpRole = CurRole.clone();
    //   40   91:aload           5
    //   41   93:invokevirtual   #301 <Method ThesisAlgorithmImplement$Role ThesisAlgorithmImplement$Role.clone()>
    //   42   96:astore          7
                        CurRole = SubRole.clone();
    //   43   98:aload           6
    //   44  100:invokevirtual   #301 <Method ThesisAlgorithmImplement$Role ThesisAlgorithmImplement$Role.clone()>
    //   45  103:astore          5
                        SubRole = tmpRole.clone();
    //   46  105:aload           7
    //   47  107:invokevirtual   #301 <Method ThesisAlgorithmImplement$Role ThesisAlgorithmImplement$Role.clone()>
    //   48  110:astore          6
                    }
                    if(isSubSet(CurRole.getPerms(), SubRole.getPerms()))
    //*  49  112:aload_0         
    //*  50  113:aload           5
    //*  51  115:invokevirtual   #162 <Method Vector ThesisAlgorithmImplement$Role.getPerms()>
    //*  52  118:aload           6
    //*  53  120:invokevirtual   #162 <Method Vector ThesisAlgorithmImplement$Role.getPerms()>
    //*  54  123:invokespecial   #305 <Method boolean isSubSet(Vector, Vector)>
    //*  55  126:ifeq            366
                    {
                        double PreSim = RolePreSimilarity(CurRole, SubRole);
    //   56  129:aload_0         
    //   57  130:aload           5
    //   58  132:aload           6
    //   59  134:invokespecial   #245 <Method double RolePreSimilarity(ThesisAlgorithmImplement$Role, ThesisAlgorithmImplement$Role)>
    //   60  137:dstore          7
                        double PreWSC = CalculateWSC();
    //   61  139:aload_0         
    //   62  140:invokespecial   #146 <Method double CalculateWSC()>
    //   63  143:dstore          9
                        double PreGOF = (1.0D - wf) * PreWSC + wf * PreWSC * PreSim;
    //   64  145:dconst_1        
    //   65  146:aload_0         
    //   66  147:getfield        #247 <Field double wf>
    //   67  150:dsub            
    //   68  151:dload           9
    //   69  153:dmul            
    //   70  154:aload_0         
    //   71  155:getfield        #247 <Field double wf>
    //   72  158:dload           9
    //   73  160:dmul            
    //   74  161:dload           7
    //   75  163:dmul            
    //   76  164:dadd            
    //   77  165:dstore          11
                        Vector saveRoles = new Vector();
    //   78  167:new             #53  <Class Vector>
    //   79  170:dup             
    //   80  171:invokespecial   #54  <Method void Vector()>
    //   81  174:astore          13
                        Role role;
                        for(Iterator iterator = FinalRoles.iterator(); iterator.hasNext(); saveRoles.add(role))
    //*  82  176:aload_0         
    //*  83  177:getfield        #64  <Field Vector FinalRoles>
    //*  84  180:invokevirtual   #90  <Method Iterator Vector.iterator()>
    //*  85  183:astore          15
    //*  86  185:goto            208
                            role = (Role)iterator.next();
    //   87  188:aload           15
    //   88  190:invokeinterface #96  <Method Object Iterator.next()>
    //   89  195:checkcast       #98  <Class ThesisAlgorithmImplement$Role>
    //   90  198:astore          14

    //   91  200:aload           13
    //   92  202:aload           14
    //   93  204:invokevirtual   #102 <Method boolean Vector.add(Object)>
    //   94  207:pop             
    //   95  208:aload           15
    //   96  210:invokeinterface #106 <Method boolean Iterator.hasNext()>
    //   97  215:ifne            188
                        removeAll(CurRole.getPerms(), SubRole.getPerms());
    //   98  218:aload_0         
    //   99  219:aload           5
    //  100  221:invokevirtual   #162 <Method Vector ThesisAlgorithmImplement$Role.getPerms()>
    //  101  224:aload           6
    //  102  226:invokevirtual   #162 <Method Vector ThesisAlgorithmImplement$Role.getPerms()>
    //  103  229:invokespecial   #276 <Method void removeAll(Vector, Vector)>
                        CurRole.getChildren().add(Integer.valueOf(SubRole.getIndex()));
    //  104  232:aload           5
    //  105  234:invokevirtual   #272 <Method Vector ThesisAlgorithmImplement$Role.getChildren()>
    //  106  237:aload           6
    //  107  239:invokevirtual   #217 <Method int ThesisAlgorithmImplement$Role.getIndex()>
    //  108  242:invokestatic    #260 <Method Integer Integer.valueOf(int)>
    //  109  245:invokevirtual   #102 <Method boolean Vector.add(Object)>
    //  110  248:pop             
                        SubRole.getParents().add(Integer.valueOf(CurRole.getIndex()));
    //  111  249:aload           6
    //  112  251:invokevirtual   #167 <Method Vector ThesisAlgorithmImplement$Role.getParents()>
    //  113  254:aload           5
    //  114  256:invokevirtual   #217 <Method int ThesisAlgorithmImplement$Role.getIndex()>
    //  115  259:invokestatic    #260 <Method Integer Integer.valueOf(int)>
    //  116  262:invokevirtual   #102 <Method boolean Vector.add(Object)>
    //  117  265:pop             
                        double CurSim = RolePreSimilarity(CurRole, SubRole);
    //  118  266:aload_0         
    //  119  267:aload           5
    //  120  269:aload           6
    //  121  271:invokespecial   #245 <Method double RolePreSimilarity(ThesisAlgorithmImplement$Role, ThesisAlgorithmImplement$Role)>
    //  122  274:dstore          14
                        double CurWSC = CalculateWSC();
    //  123  276:aload_0         
    //  124  277:invokespecial   #146 <Method double CalculateWSC()>
    //  125  280:dstore          16
                        double CurGoF = (1.0D - wf) * CurWSC + wf * CurWSC * CurSim;
    //  126  282:dconst_1        
    //  127  283:aload_0         
    //  128  284:getfield        #247 <Field double wf>
    //  129  287:dsub            
    //  130  288:dload           16
    //  131  290:dmul            
    //  132  291:aload_0         
    //  133  292:getfield        #247 <Field double wf>
    //  134  295:dload           16
    //  135  297:dmul            
    //  136  298:dload           14
    //  137  300:dmul            
    //  138  301:dadd            
    //  139  302:dstore          18
                        if(CurGoF > PreGOF)
    //* 140  304:dload           18
    //* 141  306:dload           11
    //* 142  308:dcmpl           
    //* 143  309:ifle            364
                        {
                            FinalRoles.clear();
    //  144  312:aload_0         
    //  145  313:getfield        #64  <Field Vector FinalRoles>
    //  146  316:invokevirtual   #279 <Method void Vector.clear()>
                            Role role;
                            for(Iterator iterator1 = saveRoles.iterator(); iterator1.hasNext(); FinalRoles.add(role))
    //* 147  319:aload           13
    //* 148  321:invokevirtual   #90  <Method Iterator Vector.iterator()>
    //* 149  324:astore          21
    //* 150  326:goto            351
                                role = (Role)iterator1.next();
    //  151  329:aload           21
    //  152  331:invokeinterface #96  <Method Object Iterator.next()>
    //  153  336:checkcast       #98  <Class ThesisAlgorithmImplement$Role>
    //  154  339:astore          20

    //  155  341:aload_0         
    //  156  342:getfield        #64  <Field Vector FinalRoles>
    //  157  345:aload           20
    //  158  347:invokevirtual   #102 <Method boolean Vector.add(Object)>
    //  159  350:pop             
    //  160  351:aload           21
    //  161  353:invokeinterface #106 <Method boolean Iterator.hasNext()>
    //  162  358:ifne            329
                        } else
    //* 163  361:goto            366
                        {
                            done = true;
    //  164  364:iconst_1        
    //  165  365:istore_1        
                        }
                    }
                }
            }

    //  166  366:iinc            4  1
    //  167  369:iload           4
    //  168  371:iload_2         
    //  169  372:icmplt          28
        }

    //  170  375:iinc            3  1
    //  171  378:iload_3         
    //  172  379:iload_2         
    //  173  380:iconst_1        
    //  174  381:isub            
    //  175  382:icmplt          20
    //  176  385:return          
    }

    private double CalculateWSC()
    {
        double wsc = wr * FinalRoles.size();
    //    0    0:aload_0         
    //    1    1:getfield        #309 <Field int wr>
    //    2    4:aload_0         
    //    3    5:getfield        #64  <Field Vector FinalRoles>
    //    4    8:invokevirtual   #126 <Method int Vector.size()>
    //    5   11:imul            
    //    6   12:i2d             
    //    7   13:dstore_1        
        for(Iterator iterator = FinalRoles.iterator(); iterator.hasNext();)
    //*   8   14:aload_0         
    //*   9   15:getfield        #64  <Field Vector FinalRoles>
    //*  10   18:invokevirtual   #90  <Method Iterator Vector.iterator()>
    //*  11   21:astore          4
    //*  12   23:goto            85
        {
            Role role = (Role)iterator.next();
    //   13   26:aload           4
    //   14   28:invokeinterface #96  <Method Object Iterator.next()>
    //   15   33:checkcast       #98  <Class ThesisAlgorithmImplement$Role>
    //   16   36:astore_3        
            wsc += wu * role.getUsers().size();
    //   17   37:dload_1         
    //   18   38:aload_0         
    //   19   39:getfield        #153 <Field int wu>
    //   20   42:aload_3         
    //   21   43:invokevirtual   #157 <Method Vector ThesisAlgorithmImplement$Role.getUsers()>
    //   22   46:invokevirtual   #126 <Method int Vector.size()>
    //   23   49:imul            
    //   24   50:i2d             
    //   25   51:dadd            
    //   26   52:dstore_1        
            wsc += wp * role.getPerms().size();
    //   27   53:dload_1         
    //   28   54:aload_0         
    //   29   55:getfield        #159 <Field int wp>
    //   30   58:aload_3         
    //   31   59:invokevirtual   #162 <Method Vector ThesisAlgorithmImplement$Role.getPerms()>
    //   32   62:invokevirtual   #126 <Method int Vector.size()>
    //   33   65:imul            
    //   34   66:i2d             
    //   35   67:dadd            
    //   36   68:dstore_1        
            wsc += wh * role.getParents().size();
    //   37   69:dload_1         
    //   38   70:aload_0         
    //   39   71:getfield        #164 <Field int wh>
    //   40   74:aload_3         
    //   41   75:invokevirtual   #167 <Method Vector ThesisAlgorithmImplement$Role.getParents()>
    //   42   78:invokevirtual   #126 <Method int Vector.size()>
    //   43   81:imul            
    //   44   82:i2d             
    //   45   83:dadd            
    //   46   84:dstore_1        
        }

    //   47   85:aload           4
    //   48   87:invokeinterface #106 <Method boolean Iterator.hasNext()>
    //   49   92:ifne            26
        return wsc;
    //   50   95:dload_1         
    //   51   96:dreturn         
    }

    private double RolePreSimilarity(Role curRole, Role subRole)
    {
        int CommonPermNum = GetCommonElement(curRole.getPerms(), subRole.getPerms()).size();
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokevirtual   #162 <Method Vector ThesisAlgorithmImplement$Role.getPerms()>
    //    3    5:aload_2         
    //    4    6:invokevirtual   #162 <Method Vector ThesisAlgorithmImplement$Role.getPerms()>
    //    5    9:invokespecial   #241 <Method Vector GetCommonElement(Vector, Vector)>
    //    6   12:invokevirtual   #126 <Method int Vector.size()>
    //    7   15:istore_3        
        int AllPermNum = GetAllNum(curRole.getPerms(), subRole.getPerms());
    //    8   16:aload_0         
    //    9   17:aload_1         
    //   10   18:invokevirtual   #162 <Method Vector ThesisAlgorithmImplement$Role.getPerms()>
    //   11   21:aload_2         
    //   12   22:invokevirtual   #162 <Method Vector ThesisAlgorithmImplement$Role.getPerms()>
    //   13   25:invokespecial   #313 <Method int GetAllNum(Vector, Vector)>
    //   14   28:istore          4
        double PermSim = (double)CommonPermNum / (double)AllPermNum;
    //   15   30:iload_3         
    //   16   31:i2d             
    //   17   32:iload           4
    //   18   34:i2d             
    //   19   35:ddiv            
    //   20   36:dstore          5
        int CommonUserNum = GetCommonElement(curRole.getUsers(), subRole.getUsers()).size();
    //   21   38:aload_0         
    //   22   39:aload_1         
    //   23   40:invokevirtual   #157 <Method Vector ThesisAlgorithmImplement$Role.getUsers()>
    //   24   43:aload_2         
    //   25   44:invokevirtual   #157 <Method Vector ThesisAlgorithmImplement$Role.getUsers()>
    //   26   47:invokespecial   #241 <Method Vector GetCommonElement(Vector, Vector)>
    //   27   50:invokevirtual   #126 <Method int Vector.size()>
    //   28   53:istore          7
        int AllUserNum = GetAllNum(curRole.getUsers(), subRole.getUsers());
    //   29   55:aload_0         
    //   30   56:aload_1         
    //   31   57:invokevirtual   #157 <Method Vector ThesisAlgorithmImplement$Role.getUsers()>
    //   32   60:aload_2         
    //   33   61:invokevirtual   #157 <Method Vector ThesisAlgorithmImplement$Role.getUsers()>
    //   34   64:invokespecial   #313 <Method int GetAllNum(Vector, Vector)>
    //   35   67:istore          8
        double UserSim = (double)CommonUserNum / (double)AllUserNum;
    //   36   69:iload           7
    //   37   71:i2d             
    //   38   72:iload           8
    //   39   74:i2d             
    //   40   75:ddiv            
    //   41   76:dstore          9
        int maxSenNum = max(curRole.getParents().size(), subRole.getParents().size());
    //   42   78:aload_0         
    //   43   79:aload_1         
    //   44   80:invokevirtual   #167 <Method Vector ThesisAlgorithmImplement$Role.getParents()>
    //   45   83:invokevirtual   #126 <Method int Vector.size()>
    //   46   86:aload_2         
    //   47   87:invokevirtual   #167 <Method Vector ThesisAlgorithmImplement$Role.getParents()>
    //   48   90:invokevirtual   #126 <Method int Vector.size()>
    //   49   93:invokespecial   #317 <Method int max(int, int)>
    //   50   96:istore          11
        int minSenNum = min(curRole.getParents().size(), subRole.getParents().size());
    //   51   98:aload_0         
    //   52   99:aload_1         
    //   53  100:invokevirtual   #167 <Method Vector ThesisAlgorithmImplement$Role.getParents()>
    //   54  103:invokevirtual   #126 <Method int Vector.size()>
    //   55  106:aload_2         
    //   56  107:invokevirtual   #167 <Method Vector ThesisAlgorithmImplement$Role.getParents()>
    //   57  110:invokevirtual   #126 <Method int Vector.size()>
    //   58  113:invokespecial   #320 <Method int min(int, int)>
    //   59  116:istore          12
        int maxJunNum = max(curRole.getChildren().size(), subRole.getChildren().size());
    //   60  118:aload_0         
    //   61  119:aload_1         
    //   62  120:invokevirtual   #272 <Method Vector ThesisAlgorithmImplement$Role.getChildren()>
    //   63  123:invokevirtual   #126 <Method int Vector.size()>
    //   64  126:aload_2         
    //   65  127:invokevirtual   #272 <Method Vector ThesisAlgorithmImplement$Role.getChildren()>
    //   66  130:invokevirtual   #126 <Method int Vector.size()>
    //   67  133:invokespecial   #317 <Method int max(int, int)>
    //   68  136:istore          13
        int minJunNum = min(curRole.getChildren().size(), subRole.getChildren().size());
    //   69  138:aload_0         
    //   70  139:aload_1         
    //   71  140:invokevirtual   #272 <Method Vector ThesisAlgorithmImplement$Role.getChildren()>
    //   72  143:invokevirtual   #126 <Method int Vector.size()>
    //   73  146:aload_2         
    //   74  147:invokevirtual   #272 <Method Vector ThesisAlgorithmImplement$Role.getChildren()>
    //   75  150:invokevirtual   #126 <Method int Vector.size()>
    //   76  153:invokespecial   #320 <Method int min(int, int)>
    //   77  156:istore          14
        double StructSim = ((double)minSenNum / (double)maxSenNum) * 0.5D + ((double)minJunNum / (double)maxJunNum) * 0.5D;
    //   78  158:iload           12
    //   79  160:i2d             
    //   80  161:iload           11
    //   81  163:i2d             
    //   82  164:ddiv            
    //   83  165:ldc2w           #321 <Double 0.5D>
    //   84  168:dmul            
    //   85  169:iload           14
    //   86  171:i2d             
    //   87  172:iload           13
    //   88  174:i2d             
    //   89  175:ddiv            
    //   90  176:ldc2w           #321 <Double 0.5D>
    //   91  179:dmul            
    //   92  180:dadd            
    //   93  181:dstore          15
        int CommonRoleSenNum = GetCommonSenRoleNmm(curRole, subRole);
    //   94  183:aload_0         
    //   95  184:aload_1         
    //   96  185:aload_2         
    //   97  186:invokespecial   #326 <Method int GetCommonSenRoleNmm(ThesisAlgorithmImplement$Role, ThesisAlgorithmImplement$Role)>
    //   98  189:istore          17
        int CommonRoleJunNum = GetCommonJunRoleNum(curRole, subRole);
    //   99  191:aload_0         
    //  100  192:aload_1         
    //  101  193:aload_2         
    //  102  194:invokespecial   #329 <Method int GetCommonJunRoleNum(ThesisAlgorithmImplement$Role, ThesisAlgorithmImplement$Role)>
    //  103  197:istore          18
        int roleSenNum = (curRole.getParents().size() + subRole.getParents().size()) - CommonRoleSenNum;
    //  104  199:aload_1         
    //  105  200:invokevirtual   #167 <Method Vector ThesisAlgorithmImplement$Role.getParents()>
    //  106  203:invokevirtual   #126 <Method int Vector.size()>
    //  107  206:aload_2         
    //  108  207:invokevirtual   #167 <Method Vector ThesisAlgorithmImplement$Role.getParents()>
    //  109  210:invokevirtual   #126 <Method int Vector.size()>
    //  110  213:iadd            
    //  111  214:iload           17
    //  112  216:isub            
    //  113  217:istore          19
        int roleJunNum = (curRole.getChildren().size() + subRole.getChildren().size()) - CommonRoleJunNum;
    //  114  219:aload_1         
    //  115  220:invokevirtual   #272 <Method Vector ThesisAlgorithmImplement$Role.getChildren()>
    //  116  223:invokevirtual   #126 <Method int Vector.size()>
    //  117  226:aload_2         
    //  118  227:invokevirtual   #272 <Method Vector ThesisAlgorithmImplement$Role.getChildren()>
    //  119  230:invokevirtual   #126 <Method int Vector.size()>
    //  120  233:iadd            
    //  121  234:iload           18
    //  122  236:isub            
    //  123  237:istore          20
        double ContentSim = ((double)CommonRoleSenNum / (double)roleSenNum) * 0.5D + ((double)CommonRoleJunNum / (double)roleJunNum) * 0.5D;
    //  124  239:iload           17
    //  125  241:i2d             
    //  126  242:iload           19
    //  127  244:i2d             
    //  128  245:ddiv            
    //  129  246:ldc2w           #321 <Double 0.5D>
    //  130  249:dmul            
    //  131  250:iload           18
    //  132  252:i2d             
    //  133  253:iload           20
    //  134  255:i2d             
    //  135  256:ddiv            
    //  136  257:ldc2w           #321 <Double 0.5D>
    //  137  260:dmul            
    //  138  261:dadd            
    //  139  262:dstore          21
        Vector CurSenRole = GetSenRole(curRole);
    //  140  264:aload_0         
    //  141  265:aload_1         
    //  142  266:invokespecial   #333 <Method Vector GetSenRole(ThesisAlgorithmImplement$Role)>
    //  143  269:astore          23
        Vector SubSenRole = GetSenRole(subRole);
    //  144  271:aload_0         
    //  145  272:aload_2         
    //  146  273:invokespecial   #333 <Method Vector GetSenRole(ThesisAlgorithmImplement$Role)>
    //  147  276:astore          24
        Vector CurSenPerms = new Vector();
    //  148  278:new             #53  <Class Vector>
    //  149  281:dup             
    //  150  282:invokespecial   #54  <Method void Vector()>
    //  151  285:astore          25
        Role role;
        for(Iterator iterator = CurSenRole.iterator(); iterator.hasNext(); CurSenPerms.addAll(role.getPerms()))
    //* 152  287:aload           23
    //* 153  289:invokevirtual   #90  <Method Iterator Vector.iterator()>
    //* 154  292:astore          27
    //* 155  294:goto            320
            role = (Role)iterator.next();
    //  156  297:aload           27
    //  157  299:invokeinterface #96  <Method Object Iterator.next()>
    //  158  304:checkcast       #98  <Class ThesisAlgorithmImplement$Role>
    //  159  307:astore          26

    //  160  309:aload           25
    //  161  311:aload           26
    //  162  313:invokevirtual   #162 <Method Vector ThesisAlgorithmImplement$Role.getPerms()>
    //  163  316:invokevirtual   #337 <Method boolean Vector.addAll(java.util.Collection)>
    //  164  319:pop             
    //  165  320:aload           27
    //  166  322:invokeinterface #106 <Method boolean Iterator.hasNext()>
    //  167  327:ifne            297
        Vector SubSenPerms = new Vector();
    //  168  330:new             #53  <Class Vector>
    //  169  333:dup             
    //  170  334:invokespecial   #54  <Method void Vector()>
    //  171  337:astore          26
        Role role;
        for(Iterator iterator1 = SubSenRole.iterator(); iterator1.hasNext(); SubSenPerms.addAll(role.getPerms()))
    //* 172  339:aload           24
    //* 173  341:invokevirtual   #90  <Method Iterator Vector.iterator()>
    //* 174  344:astore          28
    //* 175  346:goto            372
            role = (Role)iterator1.next();
    //  176  349:aload           28
    //  177  351:invokeinterface #96  <Method Object Iterator.next()>
    //  178  356:checkcast       #98  <Class ThesisAlgorithmImplement$Role>
    //  179  359:astore          27

    //  180  361:aload           26
    //  181  363:aload           27
    //  182  365:invokevirtual   #162 <Method Vector ThesisAlgorithmImplement$Role.getPerms()>
    //  183  368:invokevirtual   #337 <Method boolean Vector.addAll(java.util.Collection)>
    //  184  371:pop             
    //  185  372:aload           28
    //  186  374:invokeinterface #106 <Method boolean Iterator.hasNext()>
    //  187  379:ifne            349
        int CommonPermSenNum = GetCommonElement(CurSenPerms, SubSenPerms).size();
    //  188  382:aload_0         
    //  189  383:aload           25
    //  190  385:aload           26
    //  191  387:invokespecial   #241 <Method Vector GetCommonElement(Vector, Vector)>
    //  192  390:invokevirtual   #126 <Method int Vector.size()>
    //  193  393:istore          27
        int AllSenPermNum = GetAllNum(CurSenPerms, SubSenPerms);
    //  194  395:aload_0         
    //  195  396:aload           25
    //  196  398:aload           26
    //  197  400:invokespecial   #313 <Method int GetAllNum(Vector, Vector)>
    //  198  403:istore          28
        Vector CurSenUser = new Vector();
    //  199  405:new             #53  <Class Vector>
    //  200  408:dup             
    //  201  409:invokespecial   #54  <Method void Vector()>
    //  202  412:astore          29
        Role role;
        for(Iterator iterator2 = CurSenRole.iterator(); iterator2.hasNext(); CurSenUser.addAll(role.getUsers()))
    //* 203  414:aload           23
    //* 204  416:invokevirtual   #90  <Method Iterator Vector.iterator()>
    //* 205  419:astore          31
    //* 206  421:goto            447
            role = (Role)iterator2.next();
    //  207  424:aload           31
    //  208  426:invokeinterface #96  <Method Object Iterator.next()>
    //  209  431:checkcast       #98  <Class ThesisAlgorithmImplement$Role>
    //  210  434:astore          30

    //  211  436:aload           29
    //  212  438:aload           30
    //  213  440:invokevirtual   #157 <Method Vector ThesisAlgorithmImplement$Role.getUsers()>
    //  214  443:invokevirtual   #337 <Method boolean Vector.addAll(java.util.Collection)>
    //  215  446:pop             
    //  216  447:aload           31
    //  217  449:invokeinterface #106 <Method boolean Iterator.hasNext()>
    //  218  454:ifne            424
        Vector SubSenUsers = new Vector();
    //  219  457:new             #53  <Class Vector>
    //  220  460:dup             
    //  221  461:invokespecial   #54  <Method void Vector()>
    //  222  464:astore          30
        Role role;
        for(Iterator iterator3 = SubSenRole.iterator(); iterator3.hasNext(); SubSenUsers.addAll(role.getUsers()))
    //* 223  466:aload           24
    //* 224  468:invokevirtual   #90  <Method Iterator Vector.iterator()>
    //* 225  471:astore          32
    //* 226  473:goto            499
            role = (Role)iterator3.next();
    //  227  476:aload           32
    //  228  478:invokeinterface #96  <Method Object Iterator.next()>
    //  229  483:checkcast       #98  <Class ThesisAlgorithmImplement$Role>
    //  230  486:astore          31

    //  231  488:aload           30
    //  232  490:aload           31
    //  233  492:invokevirtual   #157 <Method Vector ThesisAlgorithmImplement$Role.getUsers()>
    //  234  495:invokevirtual   #337 <Method boolean Vector.addAll(java.util.Collection)>
    //  235  498:pop             
    //  236  499:aload           32
    //  237  501:invokeinterface #106 <Method boolean Iterator.hasNext()>
    //  238  506:ifne            476
        int CommonUserSenNum = GetCommonElement(CurSenUser, SubSenUsers).size();
    //  239  509:aload_0         
    //  240  510:aload           29
    //  241  512:aload           30
    //  242  514:invokespecial   #241 <Method Vector GetCommonElement(Vector, Vector)>
    //  243  517:invokevirtual   #126 <Method int Vector.size()>
    //  244  520:istore          31
        int AllSenUserNum = GetAllNum(CurSenUser, SubSenUsers);
    //  245  522:aload_0         
    //  246  523:aload           29
    //  247  525:aload           30
    //  248  527:invokespecial   #313 <Method int GetAllNum(Vector, Vector)>
    //  249  530:istore          32
        Vector CurJunRole = GetJunRole(curRole);
    //  250  532:aload_0         
    //  251  533:aload_1         
    //  252  534:invokespecial   #340 <Method Vector GetJunRole(ThesisAlgorithmImplement$Role)>
    //  253  537:astore          33
        Vector SubJunRole = GetJunRole(subRole);
    //  254  539:aload_0         
    //  255  540:aload_2         
    //  256  541:invokespecial   #340 <Method Vector GetJunRole(ThesisAlgorithmImplement$Role)>
    //  257  544:astore          34
        Vector CurJunPerms = new Vector();
    //  258  546:new             #53  <Class Vector>
    //  259  549:dup             
    //  260  550:invokespecial   #54  <Method void Vector()>
    //  261  553:astore          35
        Role role;
        for(Iterator iterator4 = CurJunRole.iterator(); iterator4.hasNext(); CurJunPerms.addAll(role.getPerms()))
    //* 262  555:aload           33
    //* 263  557:invokevirtual   #90  <Method Iterator Vector.iterator()>
    //* 264  560:astore          37
    //* 265  562:goto            588
            role = (Role)iterator4.next();
    //  266  565:aload           37
    //  267  567:invokeinterface #96  <Method Object Iterator.next()>
    //  268  572:checkcast       #98  <Class ThesisAlgorithmImplement$Role>
    //  269  575:astore          36

    //  270  577:aload           35
    //  271  579:aload           36
    //  272  581:invokevirtual   #162 <Method Vector ThesisAlgorithmImplement$Role.getPerms()>
    //  273  584:invokevirtual   #337 <Method boolean Vector.addAll(java.util.Collection)>
    //  274  587:pop             
    //  275  588:aload           37
    //  276  590:invokeinterface #106 <Method boolean Iterator.hasNext()>
    //  277  595:ifne            565
        Vector SubJunPerms = new Vector();
    //  278  598:new             #53  <Class Vector>
    //  279  601:dup             
    //  280  602:invokespecial   #54  <Method void Vector()>
    //  281  605:astore          36
        Role role;
        for(Iterator iterator5 = SubJunRole.iterator(); iterator5.hasNext(); SubJunPerms.addAll(role.getPerms()))
    //* 282  607:aload           34
    //* 283  609:invokevirtual   #90  <Method Iterator Vector.iterator()>
    //* 284  612:astore          38
    //* 285  614:goto            640
            role = (Role)iterator5.next();
    //  286  617:aload           38
    //  287  619:invokeinterface #96  <Method Object Iterator.next()>
    //  288  624:checkcast       #98  <Class ThesisAlgorithmImplement$Role>
    //  289  627:astore          37

    //  290  629:aload           36
    //  291  631:aload           37
    //  292  633:invokevirtual   #162 <Method Vector ThesisAlgorithmImplement$Role.getPerms()>
    //  293  636:invokevirtual   #337 <Method boolean Vector.addAll(java.util.Collection)>
    //  294  639:pop             
    //  295  640:aload           38
    //  296  642:invokeinterface #106 <Method boolean Iterator.hasNext()>
    //  297  647:ifne            617
        int CommonPermJunNum = GetCommonElement(CurJunPerms, SubJunPerms).size();
    //  298  650:aload_0         
    //  299  651:aload           35
    //  300  653:aload           36
    //  301  655:invokespecial   #241 <Method Vector GetCommonElement(Vector, Vector)>
    //  302  658:invokevirtual   #126 <Method int Vector.size()>
    //  303  661:istore          37
        int AllJunPermNum = GetAllNum(CurJunPerms, SubJunPerms);
    //  304  663:aload_0         
    //  305  664:aload           35
    //  306  666:aload           36
    //  307  668:invokespecial   #313 <Method int GetAllNum(Vector, Vector)>
    //  308  671:istore          38
        Vector CurJunUser = new Vector();
    //  309  673:new             #53  <Class Vector>
    //  310  676:dup             
    //  311  677:invokespecial   #54  <Method void Vector()>
    //  312  680:astore          39
        Role role;
        for(Iterator iterator6 = CurJunRole.iterator(); iterator6.hasNext(); CurJunUser.addAll(role.getUsers()))
    //* 313  682:aload           33
    //* 314  684:invokevirtual   #90  <Method Iterator Vector.iterator()>
    //* 315  687:astore          41
    //* 316  689:goto            715
            role = (Role)iterator6.next();
    //  317  692:aload           41
    //  318  694:invokeinterface #96  <Method Object Iterator.next()>
    //  319  699:checkcast       #98  <Class ThesisAlgorithmImplement$Role>
    //  320  702:astore          40

    //  321  704:aload           39
    //  322  706:aload           40
    //  323  708:invokevirtual   #157 <Method Vector ThesisAlgorithmImplement$Role.getUsers()>
    //  324  711:invokevirtual   #337 <Method boolean Vector.addAll(java.util.Collection)>
    //  325  714:pop             
    //  326  715:aload           41
    //  327  717:invokeinterface #106 <Method boolean Iterator.hasNext()>
    //  328  722:ifne            692
        Vector SubJunUsers = new Vector();
    //  329  725:new             #53  <Class Vector>
    //  330  728:dup             
    //  331  729:invokespecial   #54  <Method void Vector()>
    //  332  732:astore          40
        Role role;
        for(Iterator iterator7 = SubJunRole.iterator(); iterator7.hasNext(); SubJunUsers.addAll(role.getUsers()))
    //* 333  734:aload           34
    //* 334  736:invokevirtual   #90  <Method Iterator Vector.iterator()>
    //* 335  739:astore          42
    //* 336  741:goto            767
            role = (Role)iterator7.next();
    //  337  744:aload           42
    //  338  746:invokeinterface #96  <Method Object Iterator.next()>
    //  339  751:checkcast       #98  <Class ThesisAlgorithmImplement$Role>
    //  340  754:astore          41

    //  341  756:aload           40
    //  342  758:aload           41
    //  343  760:invokevirtual   #157 <Method Vector ThesisAlgorithmImplement$Role.getUsers()>
    //  344  763:invokevirtual   #337 <Method boolean Vector.addAll(java.util.Collection)>
    //  345  766:pop             
    //  346  767:aload           42
    //  347  769:invokeinterface #106 <Method boolean Iterator.hasNext()>
    //  348  774:ifne            744
        int CommonUserJunNum = GetCommonElement(CurJunUser, SubJunUsers).size();
    //  349  777:aload_0         
    //  350  778:aload           39
    //  351  780:aload           40
    //  352  782:invokespecial   #241 <Method Vector GetCommonElement(Vector, Vector)>
    //  353  785:invokevirtual   #126 <Method int Vector.size()>
    //  354  788:istore          41
        int AllJunUserNum = GetAllNum(CurJunUser, SubJunUsers);
    //  355  790:aload_0         
    //  356  791:aload           39
    //  357  793:aload           40
    //  358  795:invokespecial   #313 <Method int GetAllNum(Vector, Vector)>
    //  359  798:istore          42
        double SemPermSim = ((double)CommonPermSenNum / (double)AllSenPermNum) * 0.25D + ((double)CommonPermJunNum / (double)AllJunPermNum) * 0.25D + ((double)CommonUserSenNum / (double)AllSenUserNum) * 0.25D + ((double)CommonUserJunNum / (double)AllJunUserNum) * 0.25D;
    //  360  800:iload           27
    //  361  802:i2d             
    //  362  803:iload           28
    //  363  805:i2d             
    //  364  806:ddiv            
    //  365  807:ldc2w           #341 <Double 0.25D>
    //  366  810:dmul            
    //  367  811:iload           37
    //  368  813:i2d             
    //  369  814:iload           38
    //  370  816:i2d             
    //  371  817:ddiv            
    //  372  818:ldc2w           #341 <Double 0.25D>
    //  373  821:dmul            
    //  374  822:dadd            
    //  375  823:iload           31
    //  376  825:i2d             
    //  377  826:iload           32
    //  378  828:i2d             
    //  379  829:ddiv            
    //  380  830:ldc2w           #341 <Double 0.25D>
    //  381  833:dmul            
    //  382  834:dadd            
    //  383  835:iload           41
    //  384  837:i2d             
    //  385  838:iload           42
    //  386  840:i2d             
    //  387  841:ddiv            
    //  388  842:ldc2w           #341 <Double 0.25D>
    //  389  845:dmul            
    //  390  846:dadd            
    //  391  847:dstore          43
        double RelSim = ContentSim * 0.5D + (SemPermSim * 1.0D) / 3D + (StructSim * 1.0D) / 6D;
    //  392  849:dload           21
    //  393  851:ldc2w           #321 <Double 0.5D>
    //  394  854:dmul            
    //  395  855:dload           43
    //  396  857:dconst_1        
    //  397  858:dmul            
    //  398  859:ldc2w           #343 <Double 3D>
    //  399  862:ddiv            
    //  400  863:dadd            
    //  401  864:dload           15
    //  402  866:dconst_1        
    //  403  867:dmul            
    //  404  868:ldc2w           #345 <Double 6D>
    //  405  871:ddiv            
    //  406  872:dadd            
    //  407  873:dstore          45
        double Sim = wsp * PermSim + wsu * UserSim + wsh * RelSim;
    //  408  875:aload_0         
    //  409  876:getfield        #348 <Field double wsp>
    //  410  879:dload           5
    //  411  881:dmul            
    //  412  882:aload_0         
    //  413  883:getfield        #350 <Field double wsu>
    //  414  886:dload           9
    //  415  888:dmul            
    //  416  889:dadd            
    //  417  890:aload_0         
    //  418  891:getfield        #352 <Field double wsh>
    //  419  894:dload           45
    //  420  896:dmul            
    //  421  897:dadd            
    //  422  898:dstore          47
        return Sim;
    //  423  900:dload           47
    //  424  902:dreturn         
    }

    private Vector GetJunRole(Role curRole)
    {
        Vector JunRole = new Vector();
    //    0    0:new             #53  <Class Vector>
    //    1    3:dup             
    //    2    4:invokespecial   #54  <Method void Vector()>
    //    3    7:astore_2        
        Vector curChildren = curRole.getChildren();
    //    4    8:aload_1         
    //    5    9:invokevirtual   #272 <Method Vector ThesisAlgorithmImplement$Role.getChildren()>
    //    6   12:astore_3        
        for(Iterator iterator = curChildren.iterator(); iterator.hasNext();)
    //*   7   13:aload_3         
    //*   8   14:invokevirtual   #90  <Method Iterator Vector.iterator()>
    //*   9   17:astore          5
    //*  10   19:goto            88
        {
            int index = ((Integer)iterator.next()).intValue();
    //   11   22:aload           5
    //   12   24:invokeinterface #96  <Method Object Iterator.next()>
    //   13   29:checkcast       #256 <Class Integer>
    //   14   32:invokevirtual   #397 <Method int Integer.intValue()>
    //   15   35:istore          4
            for(Iterator iterator1 = FinalRoles.iterator(); iterator1.hasNext();)
    //*  16   37:aload_0         
    //*  17   38:getfield        #64  <Field Vector FinalRoles>
    //*  18   41:invokevirtual   #90  <Method Iterator Vector.iterator()>
    //*  19   44:astore          7
    //*  20   46:goto            78
            {
                Role role = (Role)iterator1.next();
    //   21   49:aload           7
    //   22   51:invokeinterface #96  <Method Object Iterator.next()>
    //   23   56:checkcast       #98  <Class ThesisAlgorithmImplement$Role>
    //   24   59:astore          6
                if(role.getIndex() == index)
    //*  25   61:aload           6
    //*  26   63:invokevirtual   #217 <Method int ThesisAlgorithmImplement$Role.getIndex()>
    //*  27   66:iload           4
    //*  28   68:icmpne          78
                    JunRole.add(role);
    //   29   71:aload_2         
    //   30   72:aload           6
    //   31   74:invokevirtual   #102 <Method boolean Vector.add(Object)>
    //   32   77:pop             
            }

    //   33   78:aload           7
    //   34   80:invokeinterface #106 <Method boolean Iterator.hasNext()>
    //   35   85:ifne            49
        }

    //   36   88:aload           5
    //   37   90:invokeinterface #106 <Method boolean Iterator.hasNext()>
    //   38   95:ifne            22
        return JunRole;
    //   39   98:aload_2         
    //   40   99:areturn         
    }

    private Vector GetSenRole(Role curRole)
    {
        Vector SenRole = new Vector();
    //    0    0:new             #53  <Class Vector>
    //    1    3:dup             
    //    2    4:invokespecial   #54  <Method void Vector()>
    //    3    7:astore_2        
        Vector curParents = curRole.getParents();
    //    4    8:aload_1         
    //    5    9:invokevirtual   #167 <Method Vector ThesisAlgorithmImplement$Role.getParents()>
    //    6   12:astore_3        
        for(Iterator iterator = curParents.iterator(); iterator.hasNext();)
    //*   7   13:aload_3         
    //*   8   14:invokevirtual   #90  <Method Iterator Vector.iterator()>
    //*   9   17:astore          5
    //*  10   19:goto            88
        {
            int index = ((Integer)iterator.next()).intValue();
    //   11   22:aload           5
    //   12   24:invokeinterface #96  <Method Object Iterator.next()>
    //   13   29:checkcast       #256 <Class Integer>
    //   14   32:invokevirtual   #397 <Method int Integer.intValue()>
    //   15   35:istore          4
            for(Iterator iterator1 = FinalRoles.iterator(); iterator1.hasNext();)
    //*  16   37:aload_0         
    //*  17   38:getfield        #64  <Field Vector FinalRoles>
    //*  18   41:invokevirtual   #90  <Method Iterator Vector.iterator()>
    //*  19   44:astore          7
    //*  20   46:goto            78
            {
                Role role = (Role)iterator1.next();
    //   21   49:aload           7
    //   22   51:invokeinterface #96  <Method Object Iterator.next()>
    //   23   56:checkcast       #98  <Class ThesisAlgorithmImplement$Role>
    //   24   59:astore          6
                if(role.getIndex() == index)
    //*  25   61:aload           6
    //*  26   63:invokevirtual   #217 <Method int ThesisAlgorithmImplement$Role.getIndex()>
    //*  27   66:iload           4
    //*  28   68:icmpne          78
                    SenRole.add(role);
    //   29   71:aload_2         
    //   30   72:aload           6
    //   31   74:invokevirtual   #102 <Method boolean Vector.add(Object)>
    //   32   77:pop             
            }

    //   33   78:aload           7
    //   34   80:invokeinterface #106 <Method boolean Iterator.hasNext()>
    //   35   85:ifne            49
        }

    //   36   88:aload           5
    //   37   90:invokeinterface #106 <Method boolean Iterator.hasNext()>
    //   38   95:ifne            22
        return SenRole;
    //   39   98:aload_2         
    //   40   99:areturn         
    }

    private int GetCommonJunRoleNum(Role curRole, Role subRole)
    {
        int count = 0;
    //    0    0:iconst_0        
    //    1    1:istore_3        
        Vector curChildren = curRole.getChildren();
    //    2    2:aload_1         
    //    3    3:invokevirtual   #272 <Method Vector ThesisAlgorithmImplement$Role.getChildren()>
    //    4    6:astore          4
        for(Iterator iterator = curChildren.iterator(); iterator.hasNext();)
    //*   5    8:aload           4
    //*   6   10:invokevirtual   #90  <Method Iterator Vector.iterator()>
    //*   7   13:astore          6
    //*   8   15:goto            51
        {
            int index = ((Integer)iterator.next()).intValue();
    //    9   18:aload           6
    //   10   20:invokeinterface #96  <Method Object Iterator.next()>
    //   11   25:checkcast       #256 <Class Integer>
    //   12   28:invokevirtual   #397 <Method int Integer.intValue()>
    //   13   31:istore          5
            if(subRole.getChildren().contains(Integer.valueOf(index)))
    //*  14   33:aload_2         
    //*  15   34:invokevirtual   #272 <Method Vector ThesisAlgorithmImplement$Role.getChildren()>
    //*  16   37:iload           5
    //*  17   39:invokestatic    #260 <Method Integer Integer.valueOf(int)>
    //*  18   42:invokevirtual   #405 <Method boolean Vector.contains(Object)>
    //*  19   45:ifeq            51
                count++;
    //   20   48:iinc            3  1
        }

    //   21   51:aload           6
    //   22   53:invokeinterface #106 <Method boolean Iterator.hasNext()>
    //   23   58:ifne            18
        return count;
    //   24   61:iload_3         
    //   25   62:ireturn         
    }

    private int GetCommonSenRoleNmm(Role curRole, Role subRole)
    {
        int count = 0;
    //    0    0:iconst_0        
    //    1    1:istore_3        
        Vector curParents = curRole.getParents();
    //    2    2:aload_1         
    //    3    3:invokevirtual   #167 <Method Vector ThesisAlgorithmImplement$Role.getParents()>
    //    4    6:astore          4
        for(Iterator iterator = curParents.iterator(); iterator.hasNext();)
    //*   5    8:aload           4
    //*   6   10:invokevirtual   #90  <Method Iterator Vector.iterator()>
    //*   7   13:astore          6
    //*   8   15:goto            51
        {
            int index = ((Integer)iterator.next()).intValue();
    //    9   18:aload           6
    //   10   20:invokeinterface #96  <Method Object Iterator.next()>
    //   11   25:checkcast       #256 <Class Integer>
    //   12   28:invokevirtual   #397 <Method int Integer.intValue()>
    //   13   31:istore          5
            if(subRole.getParents().contains(Integer.valueOf(index)))
    //*  14   33:aload_2         
    //*  15   34:invokevirtual   #167 <Method Vector ThesisAlgorithmImplement$Role.getParents()>
    //*  16   37:iload           5
    //*  17   39:invokestatic    #260 <Method Integer Integer.valueOf(int)>
    //*  18   42:invokevirtual   #405 <Method boolean Vector.contains(Object)>
    //*  19   45:ifeq            51
                count++;
    //   20   48:iinc            3  1
        }

    //   21   51:aload           6
    //   22   53:invokeinterface #106 <Method boolean Iterator.hasNext()>
    //   23   58:ifne            18
        return count;
    //   24   61:iload_3         
    //   25   62:ireturn         
    }

    private int min(int i, int j)
    {
        return i >= j ? j : i;
    //    0    0:iload_1         
    //    1    1:iload_2         
    //    2    2:icmpge          9
    //    3    5:iload_1         
    //    4    6:goto            10
    //    5    9:iload_2         
    //    6   10:ireturn         
    }

    private int max(int i, int j)
    {
        return i <= j ? j : i;
    //    0    0:iload_1         
    //    1    1:iload_2         
    //    2    2:icmple          9
    //    3    5:iload_1         
    //    4    6:goto            10
    //    5    9:iload_2         
    //    6   10:ireturn         
    }

    private int GetAllNum(Vector perms1, Vector perms2)
    {
        int count = perms1.size();
    //    0    0:aload_1         
    //    1    1:invokevirtual   #126 <Method int Vector.size()>
    //    2    4:istore_3        
        for(Iterator iterator = perms2.iterator(); iterator.hasNext();)
    //*   3    5:aload_2         
    //*   4    6:invokevirtual   #90  <Method Iterator Vector.iterator()>
    //*   5    9:astore          5
    //*   6   11:goto            38
        {
            String str = (String)iterator.next();
    //    7   14:aload           5
    //    8   16:invokeinterface #96  <Method Object Iterator.next()>
    //    9   21:checkcast       #409 <Class String>
    //   10   24:astore          4
            if(!perms1.contains(str))
    //*  11   26:aload_1         
    //*  12   27:aload           4
    //*  13   29:invokevirtual   #405 <Method boolean Vector.contains(Object)>
    //*  14   32:ifne            38
                count++;
    //   15   35:iinc            3  1
        }

    //   16   38:aload           5
    //   17   40:invokeinterface #106 <Method boolean Iterator.hasNext()>
    //   18   45:ifne            14
        return count;
    //   19   48:iload_3         
    //   20   49:ireturn         
    }

    private Vector GetCommonElement(Vector perms1, Vector perms2)
    {
        Vector ComElements = new Vector();
    //    0    0:new             #53  <Class Vector>
    //    1    3:dup             
    //    2    4:invokespecial   #54  <Method void Vector()>
    //    3    7:astore_3        
        for(Iterator iterator = perms1.iterator(); iterator.hasNext();)
    //*   4    8:aload_1         
    //*   5    9:invokevirtual   #90  <Method Iterator Vector.iterator()>
    //*   6   12:astore          5
    //*   7   14:goto            45
        {
            String str = (String)iterator.next();
    //    8   17:aload           5
    //    9   19:invokeinterface #96  <Method Object Iterator.next()>
    //   10   24:checkcast       #409 <Class String>
    //   11   27:astore          4
            if(perms2.contains(str))
    //*  12   29:aload_2         
    //*  13   30:aload           4
    //*  14   32:invokevirtual   #405 <Method boolean Vector.contains(Object)>
    //*  15   35:ifeq            45
                ComElements.add(str);
    //   16   38:aload_3         
    //   17   39:aload           4
    //   18   41:invokevirtual   #102 <Method boolean Vector.add(Object)>
    //   19   44:pop             
        }

    //   20   45:aload           5
    //   21   47:invokeinterface #106 <Method boolean Iterator.hasNext()>
    //   22   52:ifne            17
        return ComElements;
    //   23   55:aload_3         
    //   24   56:areturn         
    }

    private void HandleEquality(boolean done)
    {
        Collections.sort(FinalRoles);
    //    0    0:aload_0         
    //    1    1:getfield        #64  <Field Vector FinalRoles>
    //    2    4:invokestatic    #115 <Method void Collections.sort(java.util.List)>
        for(int i = 0; i < FinalRoles.size() - 1;)
    //*   3    7:iconst_0        
    //*   4    8:istore_2        
    //*   5    9:goto            403
        {
            Role CurRole = (Role)FinalRoles.get(i);
    //    6   12:aload_0         
    //    7   13:getfield        #64  <Field Vector FinalRoles>
    //    8   16:iload_2         
    //    9   17:invokevirtual   #237 <Method Object Vector.get(int)>
    //   10   20:checkcast       #98  <Class ThesisAlgorithmImplement$Role>
    //   11   23:astore_3        
            Role NextRole = (Role)FinalRoles.get(i + 1);
    //   12   24:aload_0         
    //   13   25:getfield        #64  <Field Vector FinalRoles>
    //   14   28:iload_2         
    //   15   29:iconst_1        
    //   16   30:iadd            
    //   17   31:invokevirtual   #237 <Method Object Vector.get(int)>
    //   18   34:checkcast       #98  <Class ThesisAlgorithmImplement$Role>
    //   19   37:astore          4
            int userNumSum = CurRole.getUsers().size() + NextRole.getUsers().size();
    //   20   39:aload_3         
    //   21   40:invokevirtual   #157 <Method Vector ThesisAlgorithmImplement$Role.getUsers()>
    //   22   43:invokevirtual   #126 <Method int Vector.size()>
    //   23   46:aload           4
    //   24   48:invokevirtual   #157 <Method Vector ThesisAlgorithmImplement$Role.getUsers()>
    //   25   51:invokevirtual   #126 <Method int Vector.size()>
    //   26   54:iadd            
    //   27   55:istore          5
            if(isEqual(CurRole.getPerms(), NextRole.getPerms()) && userNumSum < userCardConstraint)
    //*  28   57:aload_0         
    //*  29   58:aload_3         
    //*  30   59:invokevirtual   #162 <Method Vector ThesisAlgorithmImplement$Role.getPerms()>
    //*  31   62:aload           4
    //*  32   64:invokevirtual   #162 <Method Vector ThesisAlgorithmImplement$Role.getPerms()>
    //*  33   67:invokespecial   #418 <Method boolean isEqual(Vector, Vector)>
    //*  34   70:ifeq            400
    //*  35   73:iload           5
    //*  36   75:getstatic       #40  <Field int userCardConstraint>
    //*  37   78:icmpge          400
            {
                if(NextRole.getIndex() < threshold)
    //*  38   81:aload           4
    //*  39   83:invokevirtual   #217 <Method int ThesisAlgorithmImplement$Role.getIndex()>
    //*  40   86:getstatic       #46  <Field int threshold>
    //*  41   89:icmpge          111
                {
                    Role tmpRole = CurRole.clone();
    //   42   92:aload_3         
    //   43   93:invokevirtual   #301 <Method ThesisAlgorithmImplement$Role ThesisAlgorithmImplement$Role.clone()>
    //   44   96:astore          6
                    CurRole = NextRole.clone();
    //   45   98:aload           4
    //   46  100:invokevirtual   #301 <Method ThesisAlgorithmImplement$Role ThesisAlgorithmImplement$Role.clone()>
    //   47  103:astore_3        
                    NextRole = tmpRole.clone();
    //   48  104:aload           6
    //   49  106:invokevirtual   #301 <Method ThesisAlgorithmImplement$Role ThesisAlgorithmImplement$Role.clone()>
    //   50  109:astore          4
                }
                CurRole.getUsers().addAll(NextRole.getUsers());
    //   51  111:aload_3         
    //   52  112:invokevirtual   #157 <Method Vector ThesisAlgorithmImplement$Role.getUsers()>
    //   53  115:aload           4
    //   54  117:invokevirtual   #157 <Method Vector ThesisAlgorithmImplement$Role.getUsers()>
    //   55  120:invokevirtual   #337 <Method boolean Vector.addAll(java.util.Collection)>
    //   56  123:pop             
                CurRole.getChildren().addAll(NextRole.getChildren());
    //   57  124:aload_3         
    //   58  125:invokevirtual   #272 <Method Vector ThesisAlgorithmImplement$Role.getChildren()>
    //   59  128:aload           4
    //   60  130:invokevirtual   #272 <Method Vector ThesisAlgorithmImplement$Role.getChildren()>
    //   61  133:invokevirtual   #337 <Method boolean Vector.addAll(java.util.Collection)>
    //   62  136:pop             
                CurRole.getParents().addAll(NextRole.getParents());
    //   63  137:aload_3         
    //   64  138:invokevirtual   #167 <Method Vector ThesisAlgorithmImplement$Role.getParents()>
    //   65  141:aload           4
    //   66  143:invokevirtual   #167 <Method Vector ThesisAlgorithmImplement$Role.getParents()>
    //   67  146:invokevirtual   #337 <Method boolean Vector.addAll(java.util.Collection)>
    //   68  149:pop             
                for(int k = 0; k < FinalRoles.size() && k != i && k != i + 1; k++)
    //*  69  150:iconst_0        
    //*  70  151:istore          6
    //*  71  153:goto            241
                {
                    Role role = (Role)FinalRoles.get(k);
    //   72  156:aload_0         
    //   73  157:getfield        #64  <Field Vector FinalRoles>
    //   74  160:iload           6
    //   75  162:invokevirtual   #237 <Method Object Vector.get(int)>
    //   76  165:checkcast       #98  <Class ThesisAlgorithmImplement$Role>
    //   77  168:astore          7
                    int size = role.getChildren().size();
    //   78  170:aload           7
    //   79  172:invokevirtual   #272 <Method Vector ThesisAlgorithmImplement$Role.getChildren()>
    //   80  175:invokevirtual   #126 <Method int Vector.size()>
    //   81  178:istore          8
                    for(int j = 0; j < size; j++)
    //*  82  180:iconst_0        
    //*  83  181:istore          9
    //*  84  183:goto            231
                        if(((Integer)role.getChildren().get(j)).intValue() == NextRole.getIndex())
    //*  85  186:aload           7
    //*  86  188:invokevirtual   #272 <Method Vector ThesisAlgorithmImplement$Role.getChildren()>
    //*  87  191:iload           9
    //*  88  193:invokevirtual   #237 <Method Object Vector.get(int)>
    //*  89  196:checkcast       #256 <Class Integer>
    //*  90  199:invokevirtual   #397 <Method int Integer.intValue()>
    //*  91  202:aload           4
    //*  92  204:invokevirtual   #217 <Method int ThesisAlgorithmImplement$Role.getIndex()>
    //*  93  207:icmpne          228
                            role.getChildren().set(j, Integer.valueOf(CurRole.getIndex()));
    //   94  210:aload           7
    //   95  212:invokevirtual   #272 <Method Vector ThesisAlgorithmImplement$Role.getChildren()>
    //   96  215:iload           9
    //   97  217:aload_3         
    //   98  218:invokevirtual   #217 <Method int ThesisAlgorithmImplement$Role.getIndex()>
    //   99  221:invokestatic    #260 <Method Integer Integer.valueOf(int)>
    //  100  224:invokevirtual   #422 <Method Object Vector.set(int, Object)>
    //  101  227:pop             

    //  102  228:iinc            9  1
    //  103  231:iload           9
    //  104  233:iload           8
    //  105  235:icmplt          186
                }

    //  106  238:iinc            6  1
    //  107  241:iload           6
    //  108  243:aload_0         
    //  109  244:getfield        #64  <Field Vector FinalRoles>
    //  110  247:invokevirtual   #126 <Method int Vector.size()>
    //  111  250:icmpge          267
    //  112  253:iload           6
    //  113  255:iload_2         
    //  114  256:icmpeq          267
    //  115  259:iload           6
    //  116  261:iload_2         
    //  117  262:iconst_1        
    //  118  263:iadd            
    //  119  264:icmpne          156
                for(int k = 0; k < FinalRoles.size() && k != i && k != i + 1; k++)
    //* 120  267:iconst_0        
    //* 121  268:istore          6
    //* 122  270:goto            358
                {
                    Role role = (Role)FinalRoles.get(k);
    //  123  273:aload_0         
    //  124  274:getfield        #64  <Field Vector FinalRoles>
    //  125  277:iload           6
    //  126  279:invokevirtual   #237 <Method Object Vector.get(int)>
    //  127  282:checkcast       #98  <Class ThesisAlgorithmImplement$Role>
    //  128  285:astore          7
                    int size = role.getParents().size();
    //  129  287:aload           7
    //  130  289:invokevirtual   #167 <Method Vector ThesisAlgorithmImplement$Role.getParents()>
    //  131  292:invokevirtual   #126 <Method int Vector.size()>
    //  132  295:istore          8
                    for(int j = 0; j < size; j++)
    //* 133  297:iconst_0        
    //* 134  298:istore          9
    //* 135  300:goto            348
                        if(((Integer)role.getParents().get(j)).intValue() == NextRole.getIndex())
    //* 136  303:aload           7
    //* 137  305:invokevirtual   #167 <Method Vector ThesisAlgorithmImplement$Role.getParents()>
    //* 138  308:iload           9
    //* 139  310:invokevirtual   #237 <Method Object Vector.get(int)>
    //* 140  313:checkcast       #256 <Class Integer>
    //* 141  316:invokevirtual   #397 <Method int Integer.intValue()>
    //* 142  319:aload           4
    //* 143  321:invokevirtual   #217 <Method int ThesisAlgorithmImplement$Role.getIndex()>
    //* 144  324:icmpne          345
                            role.getParents().set(j, Integer.valueOf(CurRole.getIndex()));
    //  145  327:aload           7
    //  146  329:invokevirtual   #167 <Method Vector ThesisAlgorithmImplement$Role.getParents()>
    //  147  332:iload           9
    //  148  334:aload_3         
    //  149  335:invokevirtual   #217 <Method int ThesisAlgorithmImplement$Role.getIndex()>
    //  150  338:invokestatic    #260 <Method Integer Integer.valueOf(int)>
    //  151  341:invokevirtual   #422 <Method Object Vector.set(int, Object)>
    //  152  344:pop             

    //  153  345:iinc            9  1
    //  154  348:iload           9
    //  155  350:iload           8
    //  156  352:icmplt          303
                }

    //  157  355:iinc            6  1
    //  158  358:iload           6
    //  159  360:aload_0         
    //  160  361:getfield        #64  <Field Vector FinalRoles>
    //  161  364:invokevirtual   #126 <Method int Vector.size()>
    //  162  367:icmpge          384
    //  163  370:iload           6
    //  164  372:iload_2         
    //  165  373:icmpeq          384
    //  166  376:iload           6
    //  167  378:iload_2         
    //  168  379:iconst_1        
    //  169  380:iadd            
    //  170  381:icmpne          273
                done = true;
    //  171  384:iconst_1        
    //  172  385:istore_1        
                FinalRoles.remove(i + 1);
    //  173  386:aload_0         
    //  174  387:getfield        #64  <Field Vector FinalRoles>
    //  175  390:iload_2         
    //  176  391:iconst_1        
    //  177  392:iadd            
    //  178  393:invokevirtual   #425 <Method Object Vector.remove(int)>
    //  179  396:pop             
            } else
    //* 180  397:goto            403
            {
                i++;
    //  181  400:iinc            2  1
            }
        }

    //  182  403:iload_2         
    //  183  404:aload_0         
    //  184  405:getfield        #64  <Field Vector FinalRoles>
    //  185  408:invokevirtual   #126 <Method int Vector.size()>
    //  186  411:iconst_1        
    //  187  412:isub            
    //  188  413:icmplt          12
    //  189  416:return          
    }

    private void GenerateInitialRole(Matrix mat)
    {
        CalculateCardConstraint(mat);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokespecial   #431 <Method void CalculateCardConstraint(Matrix)>
        log.append((new StringBuilder("\u7528\u6237\u52BF\u7EA6\u675F\u4E3A\uFF1A ")).append(userCardConstraint).append("\n").toString());
    //    3    5:aload_0         
    //    4    6:getfield        #71  <Field StringBuffer log>
    //    5    9:new             #117 <Class StringBuilder>
    //    6   12:dup             
    //    7   13:ldc2            #433 <String "\u7528\u6237\u52BF\u7EA6\u675F\u4E3A\uFF1A ">
    //    8   16:invokespecial   #122 <Method void StringBuilder(String)>
    //    9   19:getstatic       #40  <Field int userCardConstraint>
    //   10   22:invokevirtual   #130 <Method StringBuilder StringBuilder.append(int)>
    //   11   25:ldc1            #132 <String "\n">
    //   12   27:invokevirtual   #135 <Method StringBuilder StringBuilder.append(String)>
    //   13   30:invokevirtual   #139 <Method String StringBuilder.toString()>
    //   14   33:invokevirtual   #142 <Method StringBuffer StringBuffer.append(String)>
    //   15   36:pop             
        log.append((new StringBuilder("\u6743\u9650\u52BF\u7EA6\u675F\u4E3A\uFF1A ")).append(permCardConstraint).append("\n").toString());
    //   16   37:aload_0         
    //   17   38:getfield        #71  <Field StringBuffer log>
    //   18   41:new             #117 <Class StringBuilder>
    //   19   44:dup             
    //   20   45:ldc2            #435 <String "\u6743\u9650\u52BF\u7EA6\u675F\u4E3A\uFF1A ">
    //   21   48:invokespecial   #122 <Method void StringBuilder(String)>
    //   22   51:getstatic       #42  <Field int permCardConstraint>
    //   23   54:invokevirtual   #130 <Method StringBuilder StringBuilder.append(int)>
    //   24   57:ldc1            #132 <String "\n">
    //   25   59:invokevirtual   #135 <Method StringBuilder StringBuilder.append(String)>
    //   26   62:invokevirtual   #139 <Method String StringBuilder.toString()>
    //   27   65:invokevirtual   #142 <Method StringBuffer StringBuffer.append(String)>
    //   28   68:pop             
        do
        {
            Vector GreaterRoles = new Vector();
    //   29   69:new             #53  <Class Vector>
    //   30   72:dup             
    //   31   73:invokespecial   #54  <Method void Vector()>
    //   32   76:astore_2        
            Vector LowerRoles = new Vector();
    //   33   77:new             #53  <Class Vector>
    //   34   80:dup             
    //   35   81:invokespecial   #54  <Method void Vector()>
    //   36   84:astore_3        
            for(Iterator iterator1 = userCandidateRoles.iterator(); iterator1.hasNext();)
    //*  37   85:aload_0         
    //*  38   86:getfield        #58  <Field Vector userCandidateRoles>
    //*  39   89:invokevirtual   #90  <Method Iterator Vector.iterator()>
    //*  40   92:astore          5
    //*  41   94:goto            140
            {
                Role role = (Role)iterator1.next();
    //   42   97:aload           5
    //   43   99:invokeinterface #96  <Method Object Iterator.next()>
    //   44  104:checkcast       #98  <Class ThesisAlgorithmImplement$Role>
    //   45  107:astore          4
                if(role.getPerms().size() > permCardConstraint)
    //*  46  109:aload           4
    //*  47  111:invokevirtual   #162 <Method Vector ThesisAlgorithmImplement$Role.getPerms()>
    //*  48  114:invokevirtual   #126 <Method int Vector.size()>
    //*  49  117:getstatic       #42  <Field int permCardConstraint>
    //*  50  120:icmple          133
                    GreaterRoles.add(role);
    //   51  123:aload_2         
    //   52  124:aload           4
    //   53  126:invokevirtual   #102 <Method boolean Vector.add(Object)>
    //   54  129:pop             
                else
    //*  55  130:goto            140
                    LowerRoles.add(role);
    //   56  133:aload_3         
    //   57  134:aload           4
    //   58  136:invokevirtual   #102 <Method boolean Vector.add(Object)>
    //   59  139:pop             
            }

    //   60  140:aload           5
    //   61  142:invokeinterface #106 <Method boolean Iterator.hasNext()>
    //   62  147:ifne            97
            if(GreaterRoles.isEmpty())
    //*  63  150:aload_2         
    //*  64  151:invokevirtual   #438 <Method boolean Vector.isEmpty()>
    //*  65  154:ifeq            160
                break;
    //   66  157:goto            729
            Collections.sort(GreaterRoles);
    //   67  160:aload_2         
    //   68  161:invokestatic    #115 <Method void Collections.sort(java.util.List)>
            Collections.sort(LowerRoles);
    //   69  164:aload_3         
    //   70  165:invokestatic    #115 <Method void Collections.sort(java.util.List)>
            Vector RoleCouVect = new Vector();
    //   71  168:new             #53  <Class Vector>
    //   72  171:dup             
    //   73  172:invokespecial   #54  <Method void Vector()>
    //   74  175:astore          4
            Role role;
            for(int i = 0; i < LowerRoles.size(); i++)
    //*  75  177:iconst_0        
    //*  76  178:istore          5
    //*  77  180:goto            368
            {
                role = (Role)LowerRoles.get(i);
    //   78  183:aload_3         
    //   79  184:iload           5
    //   80  186:invokevirtual   #237 <Method Object Vector.get(int)>
    //   81  189:checkcast       #98  <Class ThesisAlgorithmImplement$Role>
    //   82  192:astore          6
                int count = role.getUsers().size();
    //   83  194:aload           6
    //   84  196:invokevirtual   #157 <Method Vector ThesisAlgorithmImplement$Role.getUsers()>
    //   85  199:invokevirtual   #126 <Method int Vector.size()>
    //   86  202:istore          7
                for(int j = i - 1; j >= 0; j--)
    //*  87  204:iload           5
    //*  88  206:iconst_1        
    //*  89  207:isub            
    //*  90  208:istore          8
    //*  91  210:goto            260
                    if(isSubSet(((Role)LowerRoles.get(j)).getPerms(), role.getPerms()))
    //*  92  213:aload_0         
    //*  93  214:aload_3         
    //*  94  215:iload           8
    //*  95  217:invokevirtual   #237 <Method Object Vector.get(int)>
    //*  96  220:checkcast       #98  <Class ThesisAlgorithmImplement$Role>
    //*  97  223:invokevirtual   #162 <Method Vector ThesisAlgorithmImplement$Role.getPerms()>
    //*  98  226:aload           6
    //*  99  228:invokevirtual   #162 <Method Vector ThesisAlgorithmImplement$Role.getPerms()>
    //* 100  231:invokespecial   #305 <Method boolean isSubSet(Vector, Vector)>
    //* 101  234:ifeq            257
                        count += ((Role)LowerRoles.get(j)).getUsers().size();
    //  102  237:iload           7
    //  103  239:aload_3         
    //  104  240:iload           8
    //  105  242:invokevirtual   #237 <Method Object Vector.get(int)>
    //  106  245:checkcast       #98  <Class ThesisAlgorithmImplement$Role>
    //  107  248:invokevirtual   #157 <Method Vector ThesisAlgorithmImplement$Role.getUsers()>
    //  108  251:invokevirtual   #126 <Method int Vector.size()>
    //  109  254:iadd            
    //  110  255:istore          7

    //  111  257:iinc            8  -1
    //  112  260:iload           8
    //  113  262:ifge            213
                for(Iterator iterator2 = GreaterRoles.iterator(); iterator2.hasNext();)
    //* 114  265:aload_2         
    //* 115  266:invokevirtual   #90  <Method Iterator Vector.iterator()>
    //* 116  269:astore          9
    //* 117  271:goto            316
                {
                    Role CurRole = (Role)iterator2.next();
    //  118  274:aload           9
    //  119  276:invokeinterface #96  <Method Object Iterator.next()>
    //  120  281:checkcast       #98  <Class ThesisAlgorithmImplement$Role>
    //  121  284:astore          8
                    if(isSubSet(CurRole.getPerms(), role.getPerms()))
    //* 122  286:aload_0         
    //* 123  287:aload           8
    //* 124  289:invokevirtual   #162 <Method Vector ThesisAlgorithmImplement$Role.getPerms()>
    //* 125  292:aload           6
    //* 126  294:invokevirtual   #162 <Method Vector ThesisAlgorithmImplement$Role.getPerms()>
    //* 127  297:invokespecial   #305 <Method boolean isSubSet(Vector, Vector)>
    //* 128  300:ifeq            316
                        count += CurRole.getUsers().size();
    //  129  303:iload           7
    //  130  305:aload           8
    //  131  307:invokevirtual   #157 <Method Vector ThesisAlgorithmImplement$Role.getUsers()>
    //  132  310:invokevirtual   #126 <Method int Vector.size()>
    //  133  313:iadd            
    //  134  314:istore          7
                }

    //  135  316:aload           9
    //  136  318:invokeinterface #106 <Method boolean Iterator.hasNext()>
    //  137  323:ifne            274
                Role2Count r2c = new Role2Count();
    //  138  326:new             #440 <Class ThesisAlgorithmImplement$Role2Count>
    //  139  329:dup             
    //  140  330:aload_0         
    //  141  331:invokespecial   #441 <Method void ThesisAlgorithmImplement$Role2Count(ThesisAlgorithmImplement)>
    //  142  334:astore          8
                r2c.setRole(role);
    //  143  336:aload           8
    //  144  338:aload           6
    //  145  340:invokevirtual   #445 <Method void ThesisAlgorithmImplement$Role2Count.setRole(ThesisAlgorithmImplement$Role)>
                r2c.setCount(count);
    //  146  343:aload           8
    //  147  345:iload           7
    //  148  347:invokevirtual   #448 <Method void ThesisAlgorithmImplement$Role2Count.setCount(int)>
                r2c.setIndex(i);
    //  149  350:aload           8
    //  150  352:iload           5
    //  151  354:invokevirtual   #449 <Method void ThesisAlgorithmImplement$Role2Count.setIndex(int)>
                RoleCouVect.add(r2c);
    //  152  357:aload           4
    //  153  359:aload           8
    //  154  361:invokevirtual   #102 <Method boolean Vector.add(Object)>
    //  155  364:pop             
            }

    //  156  365:iinc            5  1
    //  157  368:iload           5
    //  158  370:aload_3         
    //  159  371:invokevirtual   #126 <Method int Vector.size()>
    //  160  374:icmplt          183
            int maxCount = 0;
    //  161  377:iconst_0        
    //  162  378:istore          5
            role = new Role();
    //  163  380:new             #98  <Class ThesisAlgorithmImplement$Role>
    //  164  383:dup             
    //  165  384:aload_0         
    //  166  385:invokespecial   #250 <Method void ThesisAlgorithmImplement$Role(ThesisAlgorithmImplement)>
    //  167  388:astore          6
            int index = -1;
    //  168  390:iconst_m1       
    //  169  391:istore          7
            for(Iterator iterator3 = RoleCouVect.iterator(); iterator3.hasNext();)
    //* 170  393:aload           4
    //* 171  395:invokevirtual   #90  <Method Iterator Vector.iterator()>
    //* 172  398:astore          9
    //* 173  400:goto            457
            {
                Role2Count r2c = (Role2Count)iterator3.next();
    //  174  403:aload           9
    //  175  405:invokeinterface #96  <Method Object Iterator.next()>
    //  176  410:checkcast       #440 <Class ThesisAlgorithmImplement$Role2Count>
    //  177  413:astore          8
                if(r2c.count > maxCount && r2c.count < userCardConstraint)
    //* 178  415:aload           8
    //* 179  417:getfield        #451 <Field int ThesisAlgorithmImplement$Role2Count.count>
    //* 180  420:iload           5
    //* 181  422:icmple          457
    //* 182  425:aload           8
    //* 183  427:getfield        #451 <Field int ThesisAlgorithmImplement$Role2Count.count>
    //* 184  430:getstatic       #40  <Field int userCardConstraint>
    //* 185  433:icmpge          457
                {
                    maxCount = r2c.count;
    //  186  436:aload           8
    //  187  438:getfield        #451 <Field int ThesisAlgorithmImplement$Role2Count.count>
    //  188  441:istore          5
                    role = r2c.getRole();
    //  189  443:aload           8
    //  190  445:invokevirtual   #454 <Method ThesisAlgorithmImplement$Role ThesisAlgorithmImplement$Role2Count.getRole()>
    //  191  448:astore          6
                    index = r2c.getIndex();
    //  192  450:aload           8
    //  193  452:invokevirtual   #455 <Method int ThesisAlgorithmImplement$Role2Count.getIndex()>
    //  194  455:istore          7
                }
            }

    //  195  457:aload           9
    //  196  459:invokeinterface #106 <Method boolean Iterator.hasNext()>
    //  197  464:ifne            403
            Vector rolePerms = role.getPerms();
    //  198  467:aload           6
    //  199  469:invokevirtual   #162 <Method Vector ThesisAlgorithmImplement$Role.getPerms()>
    //  200  472:astore          8
            for(Iterator iterator4 = GreaterRoles.iterator(); iterator4.hasNext();)
    //* 201  474:aload_2         
    //* 202  475:invokevirtual   #90  <Method Iterator Vector.iterator()>
    //* 203  478:astore          10
    //* 204  480:goto            534
            {
                Role CurRole = (Role)iterator4.next();
    //  205  483:aload           10
    //  206  485:invokeinterface #96  <Method Object Iterator.next()>
    //  207  490:checkcast       #98  <Class ThesisAlgorithmImplement$Role>
    //  208  493:astore          9
                if(isSubSet(CurRole.getPerms(), rolePerms))
    //* 209  495:aload_0         
    //* 210  496:aload           9
    //* 211  498:invokevirtual   #162 <Method Vector ThesisAlgorithmImplement$Role.getPerms()>
    //* 212  501:aload           8
    //* 213  503:invokespecial   #305 <Method boolean isSubSet(Vector, Vector)>
    //* 214  506:ifeq            534
                {
                    removeAll(CurRole.getPerms(), rolePerms);
    //  215  509:aload_0         
    //  216  510:aload           9
    //  217  512:invokevirtual   #162 <Method Vector ThesisAlgorithmImplement$Role.getPerms()>
    //  218  515:aload           8
    //  219  517:invokespecial   #276 <Method void removeAll(Vector, Vector)>
                    role.getUsers().addAll(CurRole.getUsers());
    //  220  520:aload           6
    //  221  522:invokevirtual   #157 <Method Vector ThesisAlgorithmImplement$Role.getUsers()>
    //  222  525:aload           9
    //  223  527:invokevirtual   #157 <Method Vector ThesisAlgorithmImplement$Role.getUsers()>
    //  224  530:invokevirtual   #337 <Method boolean Vector.addAll(java.util.Collection)>
    //  225  533:pop             
                }
            }

    //  226  534:aload           10
    //  227  536:invokeinterface #106 <Method boolean Iterator.hasNext()>
    //  228  541:ifne            483
            for(int i = 0; i < index; i++)
    //* 229  544:iconst_0        
    //* 230  545:istore          9
    //* 231  547:goto            613
                if(isSubSet(((Role)LowerRoles.get(i)).getPerms(), rolePerms))
    //* 232  550:aload_0         
    //* 233  551:aload_3         
    //* 234  552:iload           9
    //* 235  554:invokevirtual   #237 <Method Object Vector.get(int)>
    //* 236  557:checkcast       #98  <Class ThesisAlgorithmImplement$Role>
    //* 237  560:invokevirtual   #162 <Method Vector ThesisAlgorithmImplement$Role.getPerms()>
    //* 238  563:aload           8
    //* 239  565:invokespecial   #305 <Method boolean isSubSet(Vector, Vector)>
    //* 240  568:ifeq            610
                {
                    removeAll(((Role)LowerRoles.get(i)).getPerms(), rolePerms);
    //  241  571:aload_0         
    //  242  572:aload_3         
    //  243  573:iload           9
    //  244  575:invokevirtual   #237 <Method Object Vector.get(int)>
    //  245  578:checkcast       #98  <Class ThesisAlgorithmImplement$Role>
    //  246  581:invokevirtual   #162 <Method Vector ThesisAlgorithmImplement$Role.getPerms()>
    //  247  584:aload           8
    //  248  586:invokespecial   #276 <Method void removeAll(Vector, Vector)>
                    role.getUsers().addAll(((Role)LowerRoles.get(i)).getUsers());
    //  249  589:aload           6
    //  250  591:invokevirtual   #157 <Method Vector ThesisAlgorithmImplement$Role.getUsers()>
    //  251  594:aload_3         
    //  252  595:iload           9
    //  253  597:invokevirtual   #237 <Method Object Vector.get(int)>
    //  254  600:checkcast       #98  <Class ThesisAlgorithmImplement$Role>
    //  255  603:invokevirtual   #157 <Method Vector ThesisAlgorithmImplement$Role.getUsers()>
    //  256  606:invokevirtual   #337 <Method boolean Vector.addAll(java.util.Collection)>
    //  257  609:pop             
                }

    //  258  610:iinc            9  1
    //  259  613:iload           9
    //  260  615:iload           7
    //  261  617:icmplt          550
            LowerRoles.remove(index);
    //  262  620:aload_3         
    //  263  621:iload           7
    //  264  623:invokevirtual   #425 <Method Object Vector.remove(int)>
    //  265  626:pop             
            initRoles.add(role);
    //  266  627:aload_0         
    //  267  628:getfield        #60  <Field Vector initRoles>
    //  268  631:aload           6
    //  269  633:invokevirtual   #102 <Method boolean Vector.add(Object)>
    //  270  636:pop             
            userCandidateRoles.clear();
    //  271  637:aload_0         
    //  272  638:getfield        #58  <Field Vector userCandidateRoles>
    //  273  641:invokevirtual   #279 <Method void Vector.clear()>
            Role CurRole;
            for(Iterator iterator5 = GreaterRoles.iterator(); iterator5.hasNext(); userCandidateRoles.add(CurRole))
    //* 274  644:aload_2         
    //* 275  645:invokevirtual   #90  <Method Iterator Vector.iterator()>
    //* 276  648:astore          10
    //* 277  650:goto            675
                CurRole = (Role)iterator5.next();
    //  278  653:aload           10
    //  279  655:invokeinterface #96  <Method Object Iterator.next()>
    //  280  660:checkcast       #98  <Class ThesisAlgorithmImplement$Role>
    //  281  663:astore          9

    //  282  665:aload_0         
    //  283  666:getfield        #58  <Field Vector userCandidateRoles>
    //  284  669:aload           9
    //  285  671:invokevirtual   #102 <Method boolean Vector.add(Object)>
    //  286  674:pop             
    //  287  675:aload           10
    //  288  677:invokeinterface #106 <Method boolean Iterator.hasNext()>
    //  289  682:ifne            653
            Role CurRole;
            for(Iterator iterator6 = LowerRoles.iterator(); iterator6.hasNext(); userCandidateRoles.add(CurRole))
    //* 290  685:aload_3         
    //* 291  686:invokevirtual   #90  <Method Iterator Vector.iterator()>
    //* 292  689:astore          10
    //* 293  691:goto            716
                CurRole = (Role)iterator6.next();
    //  294  694:aload           10
    //  295  696:invokeinterface #96  <Method Object Iterator.next()>
    //  296  701:checkcast       #98  <Class ThesisAlgorithmImplement$Role>
    //  297  704:astore          9

    //  298  706:aload_0         
    //  299  707:getfield        #58  <Field Vector userCandidateRoles>
    //  300  710:aload           9
    //  301  712:invokevirtual   #102 <Method boolean Vector.add(Object)>
    //  302  715:pop             
    //  303  716:aload           10
    //  304  718:invokeinterface #106 <Method boolean Iterator.hasNext()>
    //  305  723:ifne            694
        } while(true);
    //  306  726:goto            69
        Role role;
        for(Iterator iterator = userCandidateRoles.iterator(); iterator.hasNext(); initRoles.add(role))
    //* 307  729:aload_0         
    //* 308  730:getfield        #58  <Field Vector userCandidateRoles>
    //* 309  733:invokevirtual   #90  <Method Iterator Vector.iterator()>
    //* 310  736:astore_3        
    //* 311  737:goto            759
            role = (Role)iterator.next();
    //  312  740:aload_3         
    //  313  741:invokeinterface #96  <Method Object Iterator.next()>
    //  314  746:checkcast       #98  <Class ThesisAlgorithmImplement$Role>
    //  315  749:astore_2        

    //  316  750:aload_0         
    //  317  751:getfield        #60  <Field Vector initRoles>
    //  318  754:aload_2         
    //  319  755:invokevirtual   #102 <Method boolean Vector.add(Object)>
    //  320  758:pop             
    //  321  759:aload_3         
    //  322  760:invokeinterface #106 <Method boolean Iterator.hasNext()>
    //  323  765:ifne            740
        initRoles.addAll(defaultRoles);
    //  324  768:aload_0         
    //  325  769:getfield        #60  <Field Vector initRoles>
    //  326  772:aload_0         
    //  327  773:getfield        #62  <Field Vector defaultRoles>
    //  328  776:invokevirtual   #337 <Method boolean Vector.addAll(java.util.Collection)>
    //  329  779:pop             
    //  330  780:return          
    }

    private void CalculateCardConstraint(Matrix mat)
    {
        int row = mat.getRowDimension();
    //    0    0:aload_1         
    //    1    1:invokevirtual   #468 <Method int Matrix.getRowDimension()>
    //    2    4:istore_2        
        int col = mat.getColumnDimension();
    //    3    5:aload_1         
    //    4    6:invokevirtual   #471 <Method int Matrix.getColumnDimension()>
    //    5    9:istore_3        
        int minPermValue = col;
    //    6   10:iload_3         
    //    7   11:istore          4
        int minUserValue = row;
    //    8   13:iload_2         
    //    9   14:istore          5
        int count = 0;
    //   10   16:iconst_0        
    //   11   17:istore          6
        for(int i = 0; i < row; i++)
    //*  12   19:iconst_0        
    //*  13   20:istore          7
    //*  14   22:goto            75
        {
            int permNum = 0;
    //   15   25:iconst_0        
    //   16   26:istore          8
            for(int j = 0; j < col; j++)
    //*  17   28:iconst_0        
    //*  18   29:istore          9
    //*  19   31:goto            55
                if(mat.get(i, j) == 1)
    //*  20   34:aload_1         
    //*  21   35:iload           7
    //*  22   37:iload           9
    //*  23   39:invokevirtual   #474 <Method byte Matrix.get(int, int)>
    //*  24   42:iconst_1        
    //*  25   43:icmpne          52
                {
                    count++;
    //   26   46:iinc            6  1
                    permNum++;
    //   27   49:iinc            8  1
                }

    //   28   52:iinc            9  1
    //   29   55:iload           9
    //   30   57:iload_3         
    //   31   58:icmplt          34
            if(minPermValue > permNum)
    //*  32   61:iload           4
    //*  33   63:iload           8
    //*  34   65:icmple          72
                minPermValue = permNum;
    //   35   68:iload           8
    //   36   70:istore          4
        }

    //   37   72:iinc            7  1
    //   38   75:iload           7
    //   39   77:iload_2         
    //   40   78:icmplt          25
        for(int j = 0; j < col; j++)
    //*  41   81:iconst_0        
    //*  42   82:istore          7
    //*  43   84:goto            134
        {
            int userNum = 0;
    //   44   87:iconst_0        
    //   45   88:istore          8
            for(int i = 0; i < row; i++)
    //*  46   90:iconst_0        
    //*  47   91:istore          9
    //*  48   93:goto            114
                if(mat.get(i, j) == 1)
    //*  49   96:aload_1         
    //*  50   97:iload           9
    //*  51   99:iload           7
    //*  52  101:invokevirtual   #474 <Method byte Matrix.get(int, int)>
    //*  53  104:iconst_1        
    //*  54  105:icmpne          111
                    userNum++;
    //   55  108:iinc            8  1

    //   56  111:iinc            9  1
    //   57  114:iload           9
    //   58  116:iload_2         
    //   59  117:icmplt          96
            if(minUserValue > userNum)
    //*  60  120:iload           5
    //*  61  122:iload           8
    //*  62  124:icmple          131
                minUserValue = userNum;
    //   63  127:iload           8
    //   64  129:istore          5
        }

    //   65  131:iinc            7  1
    //   66  134:iload           7
    //   67  136:iload_3         
    //   68  137:icmplt          87
        log.append((new StringBuilder("\u7528\u6237\u62E5\u6709\u7684\u6700\u5C11\u6743\u9650\u6570\u662F\uFF1A ")).append(minPermValue).append("\n").toString());
    //   69  140:aload_0         
    //   70  141:getfield        #71  <Field StringBuffer log>
    //   71  144:new             #117 <Class StringBuilder>
    //   72  147:dup             
    //   73  148:ldc2            #476 <String "\u7528\u6237\u62E5\u6709\u7684\u6700\u5C11\u6743\u9650\u6570\u662F\uFF1A ">
    //   74  151:invokespecial   #122 <Method void StringBuilder(String)>
    //   75  154:iload           4
    //   76  156:invokevirtual   #130 <Method StringBuilder StringBuilder.append(int)>
    //   77  159:ldc1            #132 <String "\n">
    //   78  161:invokevirtual   #135 <Method StringBuilder StringBuilder.append(String)>
    //   79  164:invokevirtual   #139 <Method String StringBuilder.toString()>
    //   80  167:invokevirtual   #142 <Method StringBuffer StringBuffer.append(String)>
    //   81  170:pop             
        log.append((new StringBuilder("\u6743\u9650\u5F55\u5C5E\u7684\u6700\u5C11\u7528\u6237\u6570\u662F\uFF1A ")).append(minUserValue).append("\n").toString());
    //   82  171:aload_0         
    //   83  172:getfield        #71  <Field StringBuffer log>
    //   84  175:new             #117 <Class StringBuilder>
    //   85  178:dup             
    //   86  179:ldc2            #478 <String "\u6743\u9650\u5F55\u5C5E\u7684\u6700\u5C11\u7528\u6237\u6570\u662F\uFF1A ">
    //   87  182:invokespecial   #122 <Method void StringBuilder(String)>
    //   88  185:iload           5
    //   89  187:invokevirtual   #130 <Method StringBuilder StringBuilder.append(int)>
    //   90  190:ldc1            #132 <String "\n">
    //   91  192:invokevirtual   #135 <Method StringBuilder StringBuilder.append(String)>
    //   92  195:invokevirtual   #139 <Method String StringBuilder.toString()>
    //   93  198:invokevirtual   #142 <Method StringBuffer StringBuffer.append(String)>
    //   94  201:pop             
        Random rnd = new Random(System.currentTimeMillis());
    //   95  202:new             #480 <Class Random>
    //   96  205:dup             
    //   97  206:invokestatic    #486 <Method long System.currentTimeMillis()>
    //   98  209:invokespecial   #489 <Method void Random(long)>
    //   99  212:astore          7
        permCardConstraint = (int)((double)minPermValue + (double)(col - minPermValue) * rnd.nextDouble());
    //  100  214:iload           4
    //  101  216:i2d             
    //  102  217:iload_3         
    //  103  218:iload           4
    //  104  220:isub            
    //  105  221:i2d             
    //  106  222:aload           7
    //  107  224:invokevirtual   #492 <Method double Random.nextDouble()>
    //  108  227:dmul            
    //  109  228:dadd            
    //  110  229:d2i             
    //  111  230:putstatic       #42  <Field int permCardConstraint>
        if(permCardConstraint == minPermValue)
    //* 112  233:getstatic       #42  <Field int permCardConstraint>
    //* 113  236:iload           4
    //* 114  238:icmpne          251
            permCardConstraint = (int)((double)count / (double)row);
    //  115  241:iload           6
    //  116  243:i2d             
    //  117  244:iload_2         
    //  118  245:i2d             
    //  119  246:ddiv            
    //  120  247:d2i             
    //  121  248:putstatic       #42  <Field int permCardConstraint>
        Random rdm = new Random(System.currentTimeMillis());
    //  122  251:new             #480 <Class Random>
    //  123  254:dup             
    //  124  255:invokestatic    #486 <Method long System.currentTimeMillis()>
    //  125  258:invokespecial   #489 <Method void Random(long)>
    //  126  261:astore          8
        userCardConstraint = (int)((double)minUserValue + (double)(row - minUserValue) * rdm.nextDouble());
    //  127  263:iload           5
    //  128  265:i2d             
    //  129  266:iload_2         
    //  130  267:iload           5
    //  131  269:isub            
    //  132  270:i2d             
    //  133  271:aload           8
    //  134  273:invokevirtual   #492 <Method double Random.nextDouble()>
    //  135  276:dmul            
    //  136  277:dadd            
    //  137  278:d2i             
    //  138  279:putstatic       #40  <Field int userCardConstraint>
        if(userCardConstraint == minUserValue)
    //* 139  282:getstatic       #40  <Field int userCardConstraint>
    //* 140  285:iload           5
    //* 141  287:icmpne          300
            userCardConstraint = (int)((double)count / (double)col);
    //  142  290:iload           6
    //  143  292:i2d             
    //  144  293:iload_3         
    //  145  294:i2d             
    //  146  295:ddiv            
    //  147  296:d2i             
    //  148  297:putstatic       #40  <Field int userCardConstraint>
    //  149  300:return          
    }

    private void CreateInitCandidateRole(Matrix mat)
    {
        int row = mat.getRowDimension();
    //    0    0:aload_1         
    //    1    1:invokevirtual   #468 <Method int Matrix.getRowDimension()>
    //    2    4:istore_2        
        int col = mat.getColumnDimension();
    //    3    5:aload_1         
    //    4    6:invokevirtual   #471 <Method int Matrix.getColumnDimension()>
    //    5    9:istore_3        
        for(int i = 0; i < row; i++)
    //*   6   10:iconst_0        
    //*   7   11:istore          4
    //*   8   13:goto            239
        {
            Vector userPerms = new Vector();
    //    9   16:new             #53  <Class Vector>
    //   10   19:dup             
    //   11   20:invokespecial   #54  <Method void Vector()>
    //   12   23:astore          5
            for(int j = 0; j < col; j++)
    //*  13   25:iconst_0        
    //*  14   26:istore          6
    //*  15   28:goto            64
                if(mat.get(i, j) == 1)
    //*  16   31:aload_1         
    //*  17   32:iload           4
    //*  18   34:iload           6
    //*  19   36:invokevirtual   #474 <Method byte Matrix.get(int, int)>
    //*  20   39:iconst_1        
    //*  21   40:icmpne          61
                    userPerms.add((String)permissions.get(j));
    //   22   43:aload           5
    //   23   45:aload_0         
    //   24   46:getfield        #56  <Field Vector permissions>
    //   25   49:iload           6
    //   26   51:invokevirtual   #237 <Method Object Vector.get(int)>
    //   27   54:checkcast       #409 <Class String>
    //   28   57:invokevirtual   #102 <Method boolean Vector.add(Object)>
    //   29   60:pop             

    //   30   61:iinc            6  1
    //   31   64:iload           6
    //   32   66:iload_3         
    //   33   67:icmplt          31
            for(Iterator iterator = defaultRoles.iterator(); iterator.hasNext();)
    //*  34   70:aload_0         
    //*  35   71:getfield        #62  <Field Vector defaultRoles>
    //*  36   74:invokevirtual   #90  <Method Iterator Vector.iterator()>
    //*  37   77:astore          7
    //*  38   79:goto            119
            {
                Role role = (Role)iterator.next();
    //   39   82:aload           7
    //   40   84:invokeinterface #96  <Method Object Iterator.next()>
    //   41   89:checkcast       #98  <Class ThesisAlgorithmImplement$Role>
    //   42   92:astore          6
                if(isSubSet(userPerms, role.getPerms()))
    //*  43   94:aload_0         
    //*  44   95:aload           5
    //*  45   97:aload           6
    //*  46   99:invokevirtual   #162 <Method Vector ThesisAlgorithmImplement$Role.getPerms()>
    //*  47  102:invokespecial   #305 <Method boolean isSubSet(Vector, Vector)>
    //*  48  105:ifeq            119
                    removeAll(userPerms, role.getPerms());
    //   49  108:aload_0         
    //   50  109:aload           5
    //   51  111:aload           6
    //   52  113:invokevirtual   #162 <Method Vector ThesisAlgorithmImplement$Role.getPerms()>
    //   53  116:invokespecial   #276 <Method void removeAll(Vector, Vector)>
            }

    //   54  119:aload           7
    //   55  121:invokeinterface #106 <Method boolean Iterator.hasNext()>
    //   56  126:ifne            82
            if(!userPerms.isEmpty())
    //*  57  129:aload           5
    //*  58  131:invokevirtual   #438 <Method boolean Vector.isEmpty()>
    //*  59  134:ifne            236
            {
                Vector userSet = new Vector();
    //   60  137:new             #53  <Class Vector>
    //   61  140:dup             
    //   62  141:invokespecial   #54  <Method void Vector()>
    //   63  144:astore          6
                userSet.add((String)users.get(i));
    //   64  146:aload           6
    //   65  148:aload_0         
    //   66  149:getfield        #66  <Field Vector users>
    //   67  152:iload           4
    //   68  154:invokevirtual   #237 <Method Object Vector.get(int)>
    //   69  157:checkcast       #409 <Class String>
    //   70  160:invokevirtual   #102 <Method boolean Vector.add(Object)>
    //   71  163:pop             
                Role role = new Role();
    //   72  164:new             #98  <Class ThesisAlgorithmImplement$Role>
    //   73  167:dup             
    //   74  168:aload_0         
    //   75  169:invokespecial   #250 <Method void ThesisAlgorithmImplement$Role(ThesisAlgorithmImplement)>
    //   76  172:astore          7
                Vector roleChildren = new Vector();
    //   77  174:new             #53  <Class Vector>
    //   78  177:dup             
    //   79  178:invokespecial   #54  <Method void Vector()>
    //   80  181:astore          8
                role.setChildren(roleChildren);
    //   81  183:aload           7
    //   82  185:aload           8
    //   83  187:invokevirtual   #269 <Method void ThesisAlgorithmImplement$Role.setChildren(Vector)>
                Vector roleParents = new Vector();
    //   84  190:new             #53  <Class Vector>
    //   85  193:dup             
    //   86  194:invokespecial   #54  <Method void Vector()>
    //   87  197:astore          9
                role.setParents(roleParents);
    //   88  199:aload           7
    //   89  201:aload           9
    //   90  203:invokevirtual   #263 <Method void ThesisAlgorithmImplement$Role.setParents(Vector)>
                role.setIndex(-1);
    //   91  206:aload           7
    //   92  208:iconst_m1       
    //   93  209:invokevirtual   #221 <Method void ThesisAlgorithmImplement$Role.setIndex(int)>
                role.setUsers(userSet);
    //   94  212:aload           7
    //   95  214:aload           6
    //   96  216:invokevirtual   #266 <Method void ThesisAlgorithmImplement$Role.setUsers(Vector)>
                role.setPerms(userPerms);
    //   97  219:aload           7
    //   98  221:aload           5
    //   99  223:invokevirtual   #254 <Method void ThesisAlgorithmImplement$Role.setPerms(Vector)>
                userCandidateRoles.add(role);
    //  100  226:aload_0         
    //  101  227:getfield        #58  <Field Vector userCandidateRoles>
    //  102  230:aload           7
    //  103  232:invokevirtual   #102 <Method boolean Vector.add(Object)>
    //  104  235:pop             
            }
        }

    //  105  236:iinc            4  1
    //  106  239:iload           4
    //  107  241:iload_2         
    //  108  242:icmplt          16
        Collections.sort(userCandidateRoles);
    //  109  245:aload_0         
    //  110  246:getfield        #58  <Field Vector userCandidateRoles>
    //  111  249:invokestatic    #115 <Method void Collections.sort(java.util.List)>
        for(int i = 0; i < userCandidateRoles.size() - 1;)
    //* 112  252:iconst_0        
    //* 113  253:istore          4
    //* 114  255:goto            337
        {
            Role CurRole = (Role)userCandidateRoles.get(i);
    //  115  258:aload_0         
    //  116  259:getfield        #58  <Field Vector userCandidateRoles>
    //  117  262:iload           4
    //  118  264:invokevirtual   #237 <Method Object Vector.get(int)>
    //  119  267:checkcast       #98  <Class ThesisAlgorithmImplement$Role>
    //  120  270:astore          5
            Role NextRole = (Role)userCandidateRoles.get(i + 1);
    //  121  272:aload_0         
    //  122  273:getfield        #58  <Field Vector userCandidateRoles>
    //  123  276:iload           4
    //  124  278:iconst_1        
    //  125  279:iadd            
    //  126  280:invokevirtual   #237 <Method Object Vector.get(int)>
    //  127  283:checkcast       #98  <Class ThesisAlgorithmImplement$Role>
    //  128  286:astore          6
            if(isEqual(CurRole.getPerms(), NextRole.getPerms()))
    //* 129  288:aload_0         
    //* 130  289:aload           5
    //* 131  291:invokevirtual   #162 <Method Vector ThesisAlgorithmImplement$Role.getPerms()>
    //* 132  294:aload           6
    //* 133  296:invokevirtual   #162 <Method Vector ThesisAlgorithmImplement$Role.getPerms()>
    //* 134  299:invokespecial   #418 <Method boolean isEqual(Vector, Vector)>
    //* 135  302:ifeq            334
            {
                CurRole.getUsers().addAll(NextRole.getUsers());
    //  136  305:aload           5
    //  137  307:invokevirtual   #157 <Method Vector ThesisAlgorithmImplement$Role.getUsers()>
    //  138  310:aload           6
    //  139  312:invokevirtual   #157 <Method Vector ThesisAlgorithmImplement$Role.getUsers()>
    //  140  315:invokevirtual   #337 <Method boolean Vector.addAll(java.util.Collection)>
    //  141  318:pop             
                userCandidateRoles.remove(i + 1);
    //  142  319:aload_0         
    //  143  320:getfield        #58  <Field Vector userCandidateRoles>
    //  144  323:iload           4
    //  145  325:iconst_1        
    //  146  326:iadd            
    //  147  327:invokevirtual   #425 <Method Object Vector.remove(int)>
    //  148  330:pop             
            } else
    //* 149  331:goto            337
            {
                i++;
    //  150  334:iinc            4  1
            }
        }

    //  151  337:iload           4
    //  152  339:aload_0         
    //  153  340:getfield        #58  <Field Vector userCandidateRoles>
    //  154  343:invokevirtual   #126 <Method int Vector.size()>
    //  155  346:iconst_1        
    //  156  347:isub            
    //  157  348:icmplt          258
    //  158  351:return          
    }

    private boolean isEqual(Vector perms1, Vector perms2)
    {
        return isSubSet(perms1, perms2) && isSubSet(perms2, perms1);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:aload_2         
    //    3    3:invokespecial   #305 <Method boolean isSubSet(Vector, Vector)>
    //    4    6:ifeq            20
    //    5    9:aload_0         
    //    6   10:aload_2         
    //    7   11:aload_1         
    //    8   12:invokespecial   #305 <Method boolean isSubSet(Vector, Vector)>
    //    9   15:ifeq            20
    //   10   18:iconst_1        
    //   11   19:ireturn         
    //   12   20:iconst_0        
    //   13   21:ireturn         
    }

    private void removeAll(Vector userPerms, Vector perms)
    {
        for(Iterator iterator = perms.iterator(); iterator.hasNext();)
    //*   0    0:aload_2         
    //*   1    1:invokevirtual   #90  <Method Iterator Vector.iterator()>
    //*   2    4:astore          4
    //*   3    6:goto            34
        {
            String perm = (String)iterator.next();
    //    4    9:aload           4
    //    5   11:invokeinterface #96  <Method Object Iterator.next()>
    //    6   16:checkcast       #409 <Class String>
    //    7   19:astore_3        
            if(userPerms.contains(perm))
    //*   8   20:aload_1         
    //*   9   21:aload_3         
    //*  10   22:invokevirtual   #405 <Method boolean Vector.contains(Object)>
    //*  11   25:ifeq            34
                userPerms.remove(perm);
    //   12   28:aload_1         
    //   13   29:aload_3         
    //   14   30:invokevirtual   #509 <Method boolean Vector.remove(Object)>
    //   15   33:pop             
        }

    //   16   34:aload           4
    //   17   36:invokeinterface #106 <Method boolean Iterator.hasNext()>
    //   18   41:ifne            9
    //   19   44:return          
    }

    private boolean isSubSet(Vector userPerms, Vector perms)
    {
        for(Iterator iterator = perms.iterator(); iterator.hasNext();)
    //*   0    0:aload_2         
    //*   1    1:invokevirtual   #90  <Method Iterator Vector.iterator()>
    //*   2    4:astore          4
    //*   3    6:goto            30
        {
            String perm = (String)iterator.next();
    //    4    9:aload           4
    //    5   11:invokeinterface #96  <Method Object Iterator.next()>
    //    6   16:checkcast       #409 <Class String>
    //    7   19:astore_3        
            if(!userPerms.contains(perm))
    //*   8   20:aload_1         
    //*   9   21:aload_3         
    //*  10   22:invokevirtual   #405 <Method boolean Vector.contains(Object)>
    //*  11   25:ifne            30
                return false;
    //   12   28:iconst_0        
    //   13   29:ireturn         
        }

    //   14   30:aload           4
    //   15   32:invokeinterface #106 <Method boolean Iterator.hasNext()>
    //   16   37:ifne            9
        return true;
    //   17   40:iconst_1        
    //   18   41:ireturn         
    }

    private void SplitAttruteString(Attribute latitudeAttrute, Vector strVect)
    {
        String perAttr = latitudeAttrute.toString();
    //    0    0:aload_1         
    //    1    1:invokevirtual   #515 <Method String Attribute.toString()>
    //    2    4:astore_3        
        int fristChar = perAttr.indexOf('{');
    //    3    5:aload_3         
    //    4    6:bipush          123
    //    5    8:invokevirtual   #519 <Method int String.indexOf(int)>
    //    6   11:istore          4
        int lastChar = perAttr.lastIndexOf('}');
    //    7   13:aload_3         
    //    8   14:bipush          125
    //    9   16:invokevirtual   #522 <Method int String.lastIndexOf(int)>
    //   10   19:istore          5
        perAttr = perAttr.substring(fristChar + 1, lastChar);
    //   11   21:aload_3         
    //   12   22:iload           4
    //   13   24:iconst_1        
    //   14   25:iadd            
    //   15   26:iload           5
    //   16   28:invokevirtual   #526 <Method String String.substring(int, int)>
    //   17   31:astore_3        
        for(int index = perAttr.indexOf(','); index != -1; index = perAttr.indexOf(','))
    //*  18   32:aload_3         
    //*  19   33:bipush          44
    //*  20   35:invokevirtual   #519 <Method int String.indexOf(int)>
    //*  21   38:istore          6
    //*  22   40:goto            72
        {
            strVect.add(perAttr.substring(0, index));
    //   23   43:aload_2         
    //   24   44:aload_3         
    //   25   45:iconst_0        
    //   26   46:iload           6
    //   27   48:invokevirtual   #526 <Method String String.substring(int, int)>
    //   28   51:invokevirtual   #102 <Method boolean Vector.add(Object)>
    //   29   54:pop             
            perAttr = perAttr.substring(index + 1);
    //   30   55:aload_3         
    //   31   56:iload           6
    //   32   58:iconst_1        
    //   33   59:iadd            
    //   34   60:invokevirtual   #529 <Method String String.substring(int)>
    //   35   63:astore_3        
        }

    //   36   64:aload_3         
    //   37   65:bipush          44
    //   38   67:invokevirtual   #519 <Method int String.indexOf(int)>
    //   39   70:istore          6
    //   40   72:iload           6
    //   41   74:iconst_m1       
    //   42   75:icmpne          43
        strVect.add(perAttr.substring(0));
    //   43   78:aload_2         
    //   44   79:aload_3         
    //   45   80:iconst_0        
    //   46   81:invokevirtual   #529 <Method String String.substring(int)>
    //   47   84:invokevirtual   #102 <Method boolean Vector.add(Object)>
    //   48   87:pop             
    //   49   88:return          
    }

    public void resetOptions()
    {
        wr = 1;
    //    0    0:aload_0         
    //    1    1:iconst_1        
    //    2    2:putfield        #309 <Field int wr>
        wu = 1;
    //    3    5:aload_0         
    //    4    6:iconst_1        
    //    5    7:putfield        #153 <Field int wu>
        wp = 1;
    //    6   10:aload_0         
    //    7   11:iconst_1        
    //    8   12:putfield        #159 <Field int wp>
        wh = 1;
    //    9   15:aload_0         
    //   10   16:iconst_1        
    //   11   17:putfield        #164 <Field int wh>
        wsp = 0.33333333333333331D;
    //   12   20:aload_0         
    //   13   21:ldc2w           #535 <Double 0.33333333333333331D>
    //   14   24:putfield        #348 <Field double wsp>
        wsu = 0.33333333333333331D;
    //   15   27:aload_0         
    //   16   28:ldc2w           #535 <Double 0.33333333333333331D>
    //   17   31:putfield        #350 <Field double wsu>
        wsh = 0.33333333333333331D;
    //   18   34:aload_0         
    //   19   35:ldc2w           #535 <Double 0.33333333333333331D>
    //   20   38:putfield        #352 <Field double wsh>
        wf = 0.5D;
    //   21   41:aload_0         
    //   22   42:ldc2w           #321 <Double 0.5D>
    //   23   45:putfield        #247 <Field double wf>
    //   24   48:return          
    }

    public Capabilities getCapabilities()
    {
        Capabilities result = super.getCapabilities();
    //    0    0:aload_0         
    //    1    1:invokespecial   #540 <Method Capabilities AbstractRoleminer.getCapabilities()>
    //    2    4:astore_1        
        result.disableAll();
    //    3    5:aload_1         
    //    4    6:invokevirtual   #545 <Method void Capabilities.disableAll()>
        result.enable(rm.core.Capabilities.Capability.NOMINAL_ATTRIBUTES);
    //    5    9:aload_1         
    //    6   10:getstatic       #551 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.NOMINAL_ATTRIBUTES>
    //    7   13:invokevirtual   #555 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enable(rm.core.Capabilities.Capability.MISSING_VALUES);
    //    8   16:aload_1         
    //    9   17:getstatic       #558 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.MISSING_VALUES>
    //   10   20:invokevirtual   #555 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enable(rm.core.Capabilities.Capability.NO_CLASS);
    //   11   23:aload_1         
    //   12   24:getstatic       #561 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.NO_CLASS>
    //   13   27:invokevirtual   #555 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enable(rm.core.Capabilities.Capability.NOMINAL_CLASS);
    //   14   30:aload_1         
    //   15   31:getstatic       #564 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.NOMINAL_CLASS>
    //   16   34:invokevirtual   #555 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enable(rm.core.Capabilities.Capability.MISSING_CLASS_VALUES);
    //   17   37:aload_1         
    //   18   38:getstatic       #567 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.MISSING_CLASS_VALUES>
    //   19   41:invokevirtual   #555 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        return result;
    //   20   44:aload_1         
    //   21   45:areturn         
    }

    public String globalInfo()
    {
        return "UPCRM first generates roles by one role for all permissions a user has and Consider the Constraint \nthen for Optimizating the number of edges it deals with equality,subset and intersection\nsituation respectively until no further improvement is possible. \n";
    //    0    0:ldc2            #572 <String "UPCRM first generates roles by one role for all permissions a user has and Consider the Constraint \nthen for Optimizating the number of edges it deals with equality,subset and intersection\nsituation respectively until no further improvement is possible. \n">
    //    1    3:areturn         
    }

    public Enumeration listOptions()
    {
        String string1 = (new StringBuilder("\tRequired weight of number of role for WSC. (default = ")).append(wr).append(")").toString();
    //    0    0:new             #117 <Class StringBuilder>
    //    1    3:dup             
    //    2    4:ldc2            #576 <String "\tRequired weight of number of role for WSC. (default = ">
    //    3    7:invokespecial   #122 <Method void StringBuilder(String)>
    //    4   10:aload_0         
    //    5   11:getfield        #309 <Field int wr>
    //    6   14:invokevirtual   #130 <Method StringBuilder StringBuilder.append(int)>
    //    7   17:ldc2            #578 <String ")">
    //    8   20:invokevirtual   #135 <Method StringBuilder StringBuilder.append(String)>
    //    9   23:invokevirtual   #139 <Method String StringBuilder.toString()>
    //   10   26:astore_1        
        String string2 = (new StringBuilder("\tRequired weight of number of user for WSC. (default = ")).append(wu).append(")").toString();
    //   11   27:new             #117 <Class StringBuilder>
    //   12   30:dup             
    //   13   31:ldc2            #580 <String "\tRequired weight of number of user for WSC. (default = ">
    //   14   34:invokespecial   #122 <Method void StringBuilder(String)>
    //   15   37:aload_0         
    //   16   38:getfield        #153 <Field int wu>
    //   17   41:invokevirtual   #130 <Method StringBuilder StringBuilder.append(int)>
    //   18   44:ldc2            #578 <String ")">
    //   19   47:invokevirtual   #135 <Method StringBuilder StringBuilder.append(String)>
    //   20   50:invokevirtual   #139 <Method String StringBuilder.toString()>
    //   21   53:astore_2        
        String string3 = (new StringBuilder("\tRequired weight of number of permission for WSC. (default = ")).append(wp).append(")").toString();
    //   22   54:new             #117 <Class StringBuilder>
    //   23   57:dup             
    //   24   58:ldc2            #582 <String "\tRequired weight of number of permission for WSC. (default = ">
    //   25   61:invokespecial   #122 <Method void StringBuilder(String)>
    //   26   64:aload_0         
    //   27   65:getfield        #159 <Field int wp>
    //   28   68:invokevirtual   #130 <Method StringBuilder StringBuilder.append(int)>
    //   29   71:ldc2            #578 <String ")">
    //   30   74:invokevirtual   #135 <Method StringBuilder StringBuilder.append(String)>
    //   31   77:invokevirtual   #139 <Method String StringBuilder.toString()>
    //   32   80:astore_3        
        String string4 = (new StringBuilder("\tRequired weight of number of roles' hierarchy for WSC. (default = ")).append(wh).append(")").toString();
    //   33   81:new             #117 <Class StringBuilder>
    //   34   84:dup             
    //   35   85:ldc2            #584 <String "\tRequired weight of number of roles' hierarchy for WSC. (default = ">
    //   36   88:invokespecial   #122 <Method void StringBuilder(String)>
    //   37   91:aload_0         
    //   38   92:getfield        #164 <Field int wh>
    //   39   95:invokevirtual   #130 <Method StringBuilder StringBuilder.append(int)>
    //   40   98:ldc2            #578 <String ")">
    //   41  101:invokevirtual   #135 <Method StringBuilder StringBuilder.append(String)>
    //   42  104:invokevirtual   #139 <Method String StringBuilder.toString()>
    //   43  107:astore          4
        String string5 = (new StringBuilder("\tRequired weight of Similarity of permssions for Similarity. (default = ")).append(wsp).append(")").toString();
    //   44  109:new             #117 <Class StringBuilder>
    //   45  112:dup             
    //   46  113:ldc2            #586 <String "\tRequired weight of Similarity of permssions for Similarity. (default = ">
    //   47  116:invokespecial   #122 <Method void StringBuilder(String)>
    //   48  119:aload_0         
    //   49  120:getfield        #348 <Field double wsp>
    //   50  123:invokevirtual   #151 <Method StringBuilder StringBuilder.append(double)>
    //   51  126:ldc2            #578 <String ")">
    //   52  129:invokevirtual   #135 <Method StringBuilder StringBuilder.append(String)>
    //   53  132:invokevirtual   #139 <Method String StringBuilder.toString()>
    //   54  135:astore          5
        String string6 = (new StringBuilder("\tRequired weight of Similarity of users for Similarity. (default = ")).append(wsu).append(")").toString();
    //   55  137:new             #117 <Class StringBuilder>
    //   56  140:dup             
    //   57  141:ldc2            #588 <String "\tRequired weight of Similarity of users for Similarity. (default = ">
    //   58  144:invokespecial   #122 <Method void StringBuilder(String)>
    //   59  147:aload_0         
    //   60  148:getfield        #350 <Field double wsu>
    //   61  151:invokevirtual   #151 <Method StringBuilder StringBuilder.append(double)>
    //   62  154:ldc2            #578 <String ")">
    //   63  157:invokevirtual   #135 <Method StringBuilder StringBuilder.append(String)>
    //   64  160:invokevirtual   #139 <Method String StringBuilder.toString()>
    //   65  163:astore          6
        String string7 = (new StringBuilder("\tRequired weight of Similarity of hierarchy for Similarity. (default = ")).append(wsh).append(")").toString();
    //   66  165:new             #117 <Class StringBuilder>
    //   67  168:dup             
    //   68  169:ldc2            #590 <String "\tRequired weight of Similarity of hierarchy for Similarity. (default = ">
    //   69  172:invokespecial   #122 <Method void StringBuilder(String)>
    //   70  175:aload_0         
    //   71  176:getfield        #352 <Field double wsh>
    //   72  179:invokevirtual   #151 <Method StringBuilder StringBuilder.append(double)>
    //   73  182:ldc2            #578 <String ")">
    //   74  185:invokevirtual   #135 <Method StringBuilder StringBuilder.append(String)>
    //   75  188:invokevirtual   #139 <Method String StringBuilder.toString()>
    //   76  191:astore          7
        String string8 = (new StringBuilder("\tRequired weight of Similarity of Similarity for GOF. (default = ")).append(wf).append(")").toString();
    //   77  193:new             #117 <Class StringBuilder>
    //   78  196:dup             
    //   79  197:ldc2            #592 <String "\tRequired weight of Similarity of Similarity for GOF. (default = ">
    //   80  200:invokespecial   #122 <Method void StringBuilder(String)>
    //   81  203:aload_0         
    //   82  204:getfield        #247 <Field double wf>
    //   83  207:invokevirtual   #151 <Method StringBuilder StringBuilder.append(double)>
    //   84  210:ldc2            #578 <String ")">
    //   85  213:invokevirtual   #135 <Method StringBuilder StringBuilder.append(String)>
    //   86  216:invokevirtual   #139 <Method String StringBuilder.toString()>
    //   87  219:astore          8
        FastVector newVector = new FastVector(8);
    //   88  221:new             #594 <Class FastVector>
    //   89  224:dup             
    //   90  225:bipush          8
    //   91  227:invokespecial   #596 <Method void FastVector(int)>
    //   92  230:astore          9
        newVector.addElement(new Option(string1, "R", 1, "-R <required weight of number of role>"));
    //   93  232:aload           9
    //   94  234:new             #598 <Class Option>
    //   95  237:dup             
    //   96  238:aload_1         
    //   97  239:ldc2            #600 <String "R">
    //   98  242:iconst_1        
    //   99  243:ldc2            #602 <String "-R <required weight of number of role>">
    //  100  246:invokespecial   #605 <Method void Option(String, String, int, String)>
    //  101  249:invokevirtual   #609 <Method void FastVector.addElement(Object)>
        newVector.addElement(new Option(string2, "U", 1, "-U <required weight of number of user>"));
    //  102  252:aload           9
    //  103  254:new             #598 <Class Option>
    //  104  257:dup             
    //  105  258:aload_2         
    //  106  259:ldc2            #611 <String "U">
    //  107  262:iconst_1        
    //  108  263:ldc2            #613 <String "-U <required weight of number of user>">
    //  109  266:invokespecial   #605 <Method void Option(String, String, int, String)>
    //  110  269:invokevirtual   #609 <Method void FastVector.addElement(Object)>
        newVector.addElement(new Option(string3, "P", 1, "-P <required weight of number of permission>"));
    //  111  272:aload           9
    //  112  274:new             #598 <Class Option>
    //  113  277:dup             
    //  114  278:aload_3         
    //  115  279:ldc2            #615 <String "P">
    //  116  282:iconst_1        
    //  117  283:ldc2            #617 <String "-P <required weight of number of permission>">
    //  118  286:invokespecial   #605 <Method void Option(String, String, int, String)>
    //  119  289:invokevirtual   #609 <Method void FastVector.addElement(Object)>
        newVector.addElement(new Option(string4, "H", 1, "-H <required weight of number of roles' hierarchy>"));
    //  120  292:aload           9
    //  121  294:new             #598 <Class Option>
    //  122  297:dup             
    //  123  298:aload           4
    //  124  300:ldc2            #619 <String "H">
    //  125  303:iconst_1        
    //  126  304:ldc2            #621 <String "-H <required weight of number of roles' hierarchy>">
    //  127  307:invokespecial   #605 <Method void Option(String, String, int, String)>
    //  128  310:invokevirtual   #609 <Method void FastVector.addElement(Object)>
        newVector.addElement(new Option(string5, "SP", 1, "-H <required weight of Similarity of permssions>"));
    //  129  313:aload           9
    //  130  315:new             #598 <Class Option>
    //  131  318:dup             
    //  132  319:aload           5
    //  133  321:ldc2            #623 <String "SP">
    //  134  324:iconst_1        
    //  135  325:ldc2            #625 <String "-H <required weight of Similarity of permssions>">
    //  136  328:invokespecial   #605 <Method void Option(String, String, int, String)>
    //  137  331:invokevirtual   #609 <Method void FastVector.addElement(Object)>
        newVector.addElement(new Option(string6, "SU", 1, "-H <required weight of Similarity of users>"));
    //  138  334:aload           9
    //  139  336:new             #598 <Class Option>
    //  140  339:dup             
    //  141  340:aload           6
    //  142  342:ldc2            #627 <String "SU">
    //  143  345:iconst_1        
    //  144  346:ldc2            #629 <String "-H <required weight of Similarity of users>">
    //  145  349:invokespecial   #605 <Method void Option(String, String, int, String)>
    //  146  352:invokevirtual   #609 <Method void FastVector.addElement(Object)>
        newVector.addElement(new Option(string7, "SH", 1, "-H <required weight of Similarity of hierarchy>"));
    //  147  355:aload           9
    //  148  357:new             #598 <Class Option>
    //  149  360:dup             
    //  150  361:aload           7
    //  151  363:ldc2            #631 <String "SH">
    //  152  366:iconst_1        
    //  153  367:ldc2            #633 <String "-H <required weight of Similarity of hierarchy>">
    //  154  370:invokespecial   #605 <Method void Option(String, String, int, String)>
    //  155  373:invokevirtual   #609 <Method void FastVector.addElement(Object)>
        newVector.addElement(new Option(string8, "WF", 1, "-H <required weight of Similarity of Similarity>"));
    //  156  376:aload           9
    //  157  378:new             #598 <Class Option>
    //  158  381:dup             
    //  159  382:aload           8
    //  160  384:ldc2            #635 <String "WF">
    //  161  387:iconst_1        
    //  162  388:ldc2            #637 <String "-H <required weight of Similarity of Similarity>">
    //  163  391:invokespecial   #605 <Method void Option(String, String, int, String)>
    //  164  394:invokevirtual   #609 <Method void FastVector.addElement(Object)>
        return newVector.elements();
    //  165  397:aload           9
    //  166  399:invokevirtual   #640 <Method Enumeration FastVector.elements()>
    //  167  402:areturn         
    }

    public void setOptions(String options[])
        throws Exception
    {
        resetOptions();
    //    0    0:aload_0         
    //    1    1:invokevirtual   #74  <Method void resetOptions()>
        String s_wr = Utils.getOption('R', options);
    //    2    4:bipush          82
    //    3    6:aload_1         
    //    4    7:invokestatic    #658 <Method String Utils.getOption(char, String[])>
    //    5   10:astore_2        
        if(s_wr.length() != 0)
    //*   6   11:aload_2         
    //*   7   12:invokevirtual   #661 <Method int String.length()>
    //*   8   15:ifeq            26
            wr = Integer.parseInt(s_wr);
    //    9   18:aload_0         
    //   10   19:aload_2         
    //   11   20:invokestatic    #665 <Method int Integer.parseInt(String)>
    //   12   23:putfield        #309 <Field int wr>
        String s_wu = Utils.getOption('U', options);
    //   13   26:bipush          85
    //   14   28:aload_1         
    //   15   29:invokestatic    #658 <Method String Utils.getOption(char, String[])>
    //   16   32:astore_3        
        if(s_wu.length() != 0)
    //*  17   33:aload_3         
    //*  18   34:invokevirtual   #661 <Method int String.length()>
    //*  19   37:ifeq            48
            wu = Integer.parseInt(s_wu);
    //   20   40:aload_0         
    //   21   41:aload_3         
    //   22   42:invokestatic    #665 <Method int Integer.parseInt(String)>
    //   23   45:putfield        #153 <Field int wu>
        String s_wp = Utils.getOption('P', options);
    //   24   48:bipush          80
    //   25   50:aload_1         
    //   26   51:invokestatic    #658 <Method String Utils.getOption(char, String[])>
    //   27   54:astore          4
        if(s_wp.length() != 0)
    //*  28   56:aload           4
    //*  29   58:invokevirtual   #661 <Method int String.length()>
    //*  30   61:ifeq            73
            wp = Integer.parseInt(s_wp);
    //   31   64:aload_0         
    //   32   65:aload           4
    //   33   67:invokestatic    #665 <Method int Integer.parseInt(String)>
    //   34   70:putfield        #159 <Field int wp>
        String s_wh = Utils.getOption('H', options);
    //   35   73:bipush          72
    //   36   75:aload_1         
    //   37   76:invokestatic    #658 <Method String Utils.getOption(char, String[])>
    //   38   79:astore          5
        if(s_wu.length() != 0)
    //*  39   81:aload_3         
    //*  40   82:invokevirtual   #661 <Method int String.length()>
    //*  41   85:ifeq            97
            wh = Integer.parseInt(s_wh);
    //   42   88:aload_0         
    //   43   89:aload           5
    //   44   91:invokestatic    #665 <Method int Integer.parseInt(String)>
    //   45   94:putfield        #164 <Field int wh>
        String s_wsp = Utils.getOption("SP", options);
    //   46   97:ldc2            #623 <String "SP">
    //   47  100:aload_1         
    //   48  101:invokestatic    #668 <Method String Utils.getOption(String, String[])>
    //   49  104:astore          6
        if(s_wsp.length() != 0)
    //*  50  106:aload           6
    //*  51  108:invokevirtual   #661 <Method int String.length()>
    //*  52  111:ifeq            123
            wsp = Double.parseDouble(s_wsp);
    //   53  114:aload_0         
    //   54  115:aload           6
    //   55  117:invokestatic    #674 <Method double Double.parseDouble(String)>
    //   56  120:putfield        #348 <Field double wsp>
        String s_wsu = Utils.getOption("SU", options);
    //   57  123:ldc2            #627 <String "SU">
    //   58  126:aload_1         
    //   59  127:invokestatic    #668 <Method String Utils.getOption(String, String[])>
    //   60  130:astore          7
        if(s_wsu.length() != 0)
    //*  61  132:aload           7
    //*  62  134:invokevirtual   #661 <Method int String.length()>
    //*  63  137:ifeq            149
            wsu = Double.parseDouble(s_wsu);
    //   64  140:aload_0         
    //   65  141:aload           7
    //   66  143:invokestatic    #674 <Method double Double.parseDouble(String)>
    //   67  146:putfield        #350 <Field double wsu>
        String s_wsh = Utils.getOption("SH", options);
    //   68  149:ldc2            #631 <String "SH">
    //   69  152:aload_1         
    //   70  153:invokestatic    #668 <Method String Utils.getOption(String, String[])>
    //   71  156:astore          8
        if(s_wsh.length() != 0)
    //*  72  158:aload           8
    //*  73  160:invokevirtual   #661 <Method int String.length()>
    //*  74  163:ifeq            175
            wsh = Double.parseDouble(s_wsh);
    //   75  166:aload_0         
    //   76  167:aload           8
    //   77  169:invokestatic    #674 <Method double Double.parseDouble(String)>
    //   78  172:putfield        #352 <Field double wsh>
        String s_wf = Utils.getOption("WF", options);
    //   79  175:ldc2            #635 <String "WF">
    //   80  178:aload_1         
    //   81  179:invokestatic    #668 <Method String Utils.getOption(String, String[])>
    //   82  182:astore          9
        if(s_wf.length() != 0)
    //*  83  184:aload           9
    //*  84  186:invokevirtual   #661 <Method int String.length()>
    //*  85  189:ifeq            201
            wf = Double.parseDouble(s_wf);
    //   86  192:aload_0         
    //   87  193:aload           9
    //   88  195:invokestatic    #674 <Method double Double.parseDouble(String)>
    //   89  198:putfield        #247 <Field double wf>
    //   90  201:return          
    }

    public String[] getOptions()
    {
        String options[] = new String[60];
    //    0    0:bipush          60
    //    1    2:anewarray       String[]
    //    2    5:astore_1        
        int current = 0;
    //    3    6:iconst_0        
    //    4    7:istore_2        
        options[current++] = "-R";
    //    5    8:aload_1         
    //    6    9:iload_2         
    //    7   10:iinc            2  1
    //    8   13:ldc2            #688 <String "-R">
    //    9   16:aastore         
        options[current++] = (new StringBuilder()).append(wr).toString();
    //   10   17:aload_1         
    //   11   18:iload_2         
    //   12   19:iinc            2  1
    //   13   22:new             #117 <Class StringBuilder>
    //   14   25:dup             
    //   15   26:invokespecial   #689 <Method void StringBuilder()>
    //   16   29:aload_0         
    //   17   30:getfield        #309 <Field int wr>
    //   18   33:invokevirtual   #130 <Method StringBuilder StringBuilder.append(int)>
    //   19   36:invokevirtual   #139 <Method String StringBuilder.toString()>
    //   20   39:aastore         
        options[current++] = "-U";
    //   21   40:aload_1         
    //   22   41:iload_2         
    //   23   42:iinc            2  1
    //   24   45:ldc2            #691 <String "-U">
    //   25   48:aastore         
        options[current++] = (new StringBuilder()).append(wu).toString();
    //   26   49:aload_1         
    //   27   50:iload_2         
    //   28   51:iinc            2  1
    //   29   54:new             #117 <Class StringBuilder>
    //   30   57:dup             
    //   31   58:invokespecial   #689 <Method void StringBuilder()>
    //   32   61:aload_0         
    //   33   62:getfield        #153 <Field int wu>
    //   34   65:invokevirtual   #130 <Method StringBuilder StringBuilder.append(int)>
    //   35   68:invokevirtual   #139 <Method String StringBuilder.toString()>
    //   36   71:aastore         
        options[current++] = "-P";
    //   37   72:aload_1         
    //   38   73:iload_2         
    //   39   74:iinc            2  1
    //   40   77:ldc2            #693 <String "-P">
    //   41   80:aastore         
        options[current++] = (new StringBuilder()).append(wp).toString();
    //   42   81:aload_1         
    //   43   82:iload_2         
    //   44   83:iinc            2  1
    //   45   86:new             #117 <Class StringBuilder>
    //   46   89:dup             
    //   47   90:invokespecial   #689 <Method void StringBuilder()>
    //   48   93:aload_0         
    //   49   94:getfield        #159 <Field int wp>
    //   50   97:invokevirtual   #130 <Method StringBuilder StringBuilder.append(int)>
    //   51  100:invokevirtual   #139 <Method String StringBuilder.toString()>
    //   52  103:aastore         
        options[current++] = "-H";
    //   53  104:aload_1         
    //   54  105:iload_2         
    //   55  106:iinc            2  1
    //   56  109:ldc2            #695 <String "-H">
    //   57  112:aastore         
        options[current++] = (new StringBuilder()).append(wh).toString();
    //   58  113:aload_1         
    //   59  114:iload_2         
    //   60  115:iinc            2  1
    //   61  118:new             #117 <Class StringBuilder>
    //   62  121:dup             
    //   63  122:invokespecial   #689 <Method void StringBuilder()>
    //   64  125:aload_0         
    //   65  126:getfield        #164 <Field int wh>
    //   66  129:invokevirtual   #130 <Method StringBuilder StringBuilder.append(int)>
    //   67  132:invokevirtual   #139 <Method String StringBuilder.toString()>
    //   68  135:aastore         
        options[current++] = "-SP";
    //   69  136:aload_1         
    //   70  137:iload_2         
    //   71  138:iinc            2  1
    //   72  141:ldc2            #697 <String "-SP">
    //   73  144:aastore         
        options[current++] = (new StringBuilder()).append(wsp).toString();
    //   74  145:aload_1         
    //   75  146:iload_2         
    //   76  147:iinc            2  1
    //   77  150:new             #117 <Class StringBuilder>
    //   78  153:dup             
    //   79  154:invokespecial   #689 <Method void StringBuilder()>
    //   80  157:aload_0         
    //   81  158:getfield        #348 <Field double wsp>
    //   82  161:invokevirtual   #151 <Method StringBuilder StringBuilder.append(double)>
    //   83  164:invokevirtual   #139 <Method String StringBuilder.toString()>
    //   84  167:aastore         
        options[current++] = "-SU";
    //   85  168:aload_1         
    //   86  169:iload_2         
    //   87  170:iinc            2  1
    //   88  173:ldc2            #699 <String "-SU">
    //   89  176:aastore         
        options[current++] = (new StringBuilder()).append(wsu).toString();
    //   90  177:aload_1         
    //   91  178:iload_2         
    //   92  179:iinc            2  1
    //   93  182:new             #117 <Class StringBuilder>
    //   94  185:dup             
    //   95  186:invokespecial   #689 <Method void StringBuilder()>
    //   96  189:aload_0         
    //   97  190:getfield        #350 <Field double wsu>
    //   98  193:invokevirtual   #151 <Method StringBuilder StringBuilder.append(double)>
    //   99  196:invokevirtual   #139 <Method String StringBuilder.toString()>
    //  100  199:aastore         
        options[current++] = "-SH";
    //  101  200:aload_1         
    //  102  201:iload_2         
    //  103  202:iinc            2  1
    //  104  205:ldc2            #701 <String "-SH">
    //  105  208:aastore         
        options[current++] = (new StringBuilder()).append(wsh).toString();
    //  106  209:aload_1         
    //  107  210:iload_2         
    //  108  211:iinc            2  1
    //  109  214:new             #117 <Class StringBuilder>
    //  110  217:dup             
    //  111  218:invokespecial   #689 <Method void StringBuilder()>
    //  112  221:aload_0         
    //  113  222:getfield        #352 <Field double wsh>
    //  114  225:invokevirtual   #151 <Method StringBuilder StringBuilder.append(double)>
    //  115  228:invokevirtual   #139 <Method String StringBuilder.toString()>
    //  116  231:aastore         
        options[current++] = "-WF";
    //  117  232:aload_1         
    //  118  233:iload_2         
    //  119  234:iinc            2  1
    //  120  237:ldc2            #703 <String "-WF">
    //  121  240:aastore         
        for(options[current++] = (new StringBuilder()).append(wf).toString(); current < options.length; options[current++] = "");
    //  122  241:aload_1         
    //  123  242:iload_2         
    //  124  243:iinc            2  1
    //  125  246:new             #117 <Class StringBuilder>
    //  126  249:dup             
    //  127  250:invokespecial   #689 <Method void StringBuilder()>
    //  128  253:aload_0         
    //  129  254:getfield        #247 <Field double wf>
    //  130  257:invokevirtual   #151 <Method StringBuilder StringBuilder.append(double)>
    //  131  260:invokevirtual   #139 <Method String StringBuilder.toString()>
    //  132  263:aastore         
    //  133  264:goto            276
    //  134  267:aload_1         
    //  135  268:iload_2         
    //  136  269:iinc            2  1
    //  137  272:ldc2            #705 <String "">
    //  138  275:aastore         
    //  139  276:iload_2         
    //  140  277:aload_1         
    //  141  278:arraylength     
    //  142  279:icmplt          267
        return options;
    //  143  282:aload_1         
    //  144  283:areturn         
    }

    public String toString()
    {
        return log.toString();
    //    0    0:aload_0         
    //    1    1:getfield        #71  <Field StringBuffer log>
    //    2    4:invokevirtual   #707 <Method String StringBuffer.toString()>
    //    3    7:areturn         
    }

    public Assignment generateRoles()
    {
        m_assroles = new Assignment();
    //    0    0:aload_0         
    //    1    1:new             #180 <Class Assignment>
    //    2    4:dup             
    //    3    5:invokespecial   #710 <Method void Assignment()>
    //    4    8:putfield        #712 <Field Assignment m_assroles>
        m_assroles.setAssignementName("role-permission");
    //    5   11:aload_0         
    //    6   12:getfield        #712 <Field Assignment m_assroles>
    //    7   15:ldc2            #714 <String "role-permission">
    //    8   18:invokevirtual   #717 <Method void Assignment.setAssignementName(String)>
        Matrix mat = new Matrix(roleAscending, permissions.size(), (byte)0);
    //    9   21:new             #465 <Class Matrix>
    //   10   24:dup             
    //   11   25:getstatic       #44  <Field int roleAscending>
    //   12   28:aload_0         
    //   13   29:getfield        #56  <Field Vector permissions>
    //   14   32:invokevirtual   #126 <Method int Vector.size()>
    //   15   35:iconst_0        
    //   16   36:invokespecial   #720 <Method void Matrix(int, int, byte)>
    //   17   39:astore_1        
        for(int i = 0; i < roleAscending; i++)
    //*  18   40:iconst_0        
    //*  19   41:istore_2        
    //*  20   42:goto            108
        {
            Vector upi = ((Role)FinalRoles.get(i)).getPerms();
    //   21   45:aload_0         
    //   22   46:getfield        #64  <Field Vector FinalRoles>
    //   23   49:iload_2         
    //   24   50:invokevirtual   #237 <Method Object Vector.get(int)>
    //   25   53:checkcast       #98  <Class ThesisAlgorithmImplement$Role>
    //   26   56:invokevirtual   #162 <Method Vector ThesisAlgorithmImplement$Role.getPerms()>
    //   27   59:astore_3        
            for(int j = 0; j < permissions.size(); j++)
    //*  28   60:iconst_0        
    //*  29   61:istore          4
    //*  30   63:goto            93
                if(upi.contains(permissions.get(j)))
    //*  31   66:aload_3         
    //*  32   67:aload_0         
    //*  33   68:getfield        #56  <Field Vector permissions>
    //*  34   71:iload           4
    //*  35   73:invokevirtual   #237 <Method Object Vector.get(int)>
    //*  36   76:invokevirtual   #405 <Method boolean Vector.contains(Object)>
    //*  37   79:ifeq            90
                    mat.set(i, j, (byte)1);
    //   38   82:aload_1         
    //   39   83:iload_2         
    //   40   84:iload           4
    //   41   86:iconst_1        
    //   42   87:invokevirtual   #722 <Method void Matrix.set(int, int, byte)>

    //   43   90:iinc            4  1
    //   44   93:iload           4
    //   45   95:aload_0         
    //   46   96:getfield        #56  <Field Vector permissions>
    //   47   99:invokevirtual   #126 <Method int Vector.size()>
    //   48  102:icmplt          66
        }

    //   49  105:iinc            2  1
    //   50  108:iload_2         
    //   51  109:getstatic       #44  <Field int roleAscending>
    //   52  112:icmplt          45
        m_assroles.setAssignmentMatrix(mat);
    //   53  115:aload_0         
    //   54  116:getfield        #712 <Field Assignment m_assroles>
    //   55  119:aload_1         
    //   56  120:invokevirtual   #725 <Method void Assignment.setAssignmentMatrix(Matrix)>
        FastVector fv = new FastVector();
    //   57  123:new             #594 <Class FastVector>
    //   58  126:dup             
    //   59  127:invokespecial   #726 <Method void FastVector()>
    //   60  130:astore_2        
        for(int i = 0; i < roleAscending; i++)
    //*  61  131:iconst_0        
    //*  62  132:istore_3        
    //*  63  133:goto            160
            fv.addElement((new StringBuilder("R")).append(i).toString());
    //   64  136:aload_2         
    //   65  137:new             #117 <Class StringBuilder>
    //   66  140:dup             
    //   67  141:ldc2            #600 <String "R">
    //   68  144:invokespecial   #122 <Method void StringBuilder(String)>
    //   69  147:iload_3         
    //   70  148:invokevirtual   #130 <Method StringBuilder StringBuilder.append(int)>
    //   71  151:invokevirtual   #139 <Method String StringBuilder.toString()>
    //   72  154:invokevirtual   #609 <Method void FastVector.addElement(Object)>

    //   73  157:iinc            3  1
    //   74  160:iload_3         
    //   75  161:getstatic       #44  <Field int roleAscending>
    //   76  164:icmplt          136
        Attribute dxa = new Attribute("role", fv);
    //   77  167:new             #514 <Class Attribute>
    //   78  170:dup             
    //   79  171:ldc2            #727 <String "role">
    //   80  174:aload_2         
    //   81  175:invokespecial   #730 <Method void Attribute(String, FastVector)>
    //   82  178:astore_3        
        Dimension dx = new Dimension();
    //   83  179:new             #190 <Class Dimension>
    //   84  182:dup             
    //   85  183:invokespecial   #731 <Method void Dimension()>
    //   86  186:astore          4
        dx.setDimensionAttribute(dxa);
    //   87  188:aload           4
    //   88  190:aload_3         
    //   89  191:invokevirtual   #735 <Method void Dimension.setDimensionAttribute(Attribute)>
        m_assroles.setDimensionX(dx);
    //   90  194:aload_0         
    //   91  195:getfield        #712 <Field Assignment m_assroles>
    //   92  198:aload           4
    //   93  200:invokevirtual   #739 <Method void Assignment.setDimensionX(Dimension)>
        Attribute dya = m_assignment.getDimensionY().getDimensionAttribute();
    //   94  203:aload_0         
    //   95  204:getfield        #83  <Field Assignment m_assignment>
    //   96  207:invokevirtual   #197 <Method Dimension Assignment.getDimensionY()>
    //   97  210:invokevirtual   #194 <Method Attribute Dimension.getDimensionAttribute()>
    //   98  213:astore          5
        Dimension dy = new Dimension();
    //   99  215:new             #190 <Class Dimension>
    //  100  218:dup             
    //  101  219:invokespecial   #731 <Method void Dimension()>
    //  102  222:astore          6
        dy.setDimensionAttribute(dya);
    //  103  224:aload           6
    //  104  226:aload           5
    //  105  228:invokevirtual   #735 <Method void Dimension.setDimensionAttribute(Attribute)>
        m_assroles.setDimensionY(dy);
    //  106  231:aload_0         
    //  107  232:getfield        #712 <Field Assignment m_assroles>
    //  108  235:aload           6
    //  109  237:invokevirtual   #742 <Method void Assignment.setDimensionY(Dimension)>
        return m_assroles;
    //  110  240:aload_0         
    //  111  241:getfield        #712 <Field Assignment m_assroles>
    //  112  244:areturn         
    }

    public double getWf()
    {
        return wf;
    //    0    0:aload_0         
    //    1    1:getfield        #247 <Field double wf>
    //    2    4:dreturn         
    }

    public void setWf(double wf)
    {
        this.wf = wf;
    //    0    0:aload_0         
    //    1    1:dload_1         
    //    2    2:putfield        #247 <Field double wf>
    //    3    5:return          
    }

    public int getWh()
    {
        return wh;
    //    0    0:aload_0         
    //    1    1:getfield        #164 <Field int wh>
    //    2    4:ireturn         
    }

    public void setWh(int wh)
    {
        this.wh = wh;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #164 <Field int wh>
    //    3    5:return          
    }

    public int getWp()
    {
        return wp;
    //    0    0:aload_0         
    //    1    1:getfield        #159 <Field int wp>
    //    2    4:ireturn         
    }

    public void setWp(int wp)
    {
        this.wp = wp;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #159 <Field int wp>
    //    3    5:return          
    }

    public int getWr()
    {
        return wr;
    //    0    0:aload_0         
    //    1    1:getfield        #309 <Field int wr>
    //    2    4:ireturn         
    }

    public void setWr(int wr)
    {
        this.wr = wr;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #309 <Field int wr>
    //    3    5:return          
    }

    public double getWsh()
    {
        return wsh;
    //    0    0:aload_0         
    //    1    1:getfield        #352 <Field double wsh>
    //    2    4:dreturn         
    }

    public void setWsh(double wsh)
    {
        this.wsh = wsh;
    //    0    0:aload_0         
    //    1    1:dload_1         
    //    2    2:putfield        #352 <Field double wsh>
    //    3    5:return          
    }

    public double getWsp()
    {
        return wsp;
    //    0    0:aload_0         
    //    1    1:getfield        #348 <Field double wsp>
    //    2    4:dreturn         
    }

    public void setWsp(double wsp)
    {
        this.wsp = wsp;
    //    0    0:aload_0         
    //    1    1:dload_1         
    //    2    2:putfield        #348 <Field double wsp>
    //    3    5:return          
    }

    public double getWsu()
    {
        return wsu;
    //    0    0:aload_0         
    //    1    1:getfield        #350 <Field double wsu>
    //    2    4:dreturn         
    }

    public void setWsu(double wsu)
    {
        this.wsu = wsu;
    //    0    0:aload_0         
    //    1    1:dload_1         
    //    2    2:putfield        #350 <Field double wsu>
    //    3    5:return          
    }

    public int getWu()
    {
        return wu;
    //    0    0:aload_0         
    //    1    1:getfield        #153 <Field int wu>
    //    2    4:ireturn         
    }

    public void setWu(int wu)
    {
        this.wu = wu;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #153 <Field int wu>
    //    3    5:return          
    }

    public String wrTipText()
    {
        return "The required weight of number of role for WSC.";
    //    0    0:ldc2            #769 <String "The required weight of number of role for WSC.">
    //    1    3:areturn         
    }

    public String wuTipText()
    {
        return "The required weight of number of user for WSC.";
    //    0    0:ldc2            #772 <String "The required weight of number of user for WSC.">
    //    1    3:areturn         
    }

    public String wpTipText()
    {
        return "The required weight of number of permission for WSC.";
    //    0    0:ldc2            #775 <String "The required weight of number of permission for WSC.">
    //    1    3:areturn         
    }

    public String whTipText()
    {
        return "The required weight of number of roles' hierarchy for WSC.";
    //    0    0:ldc2            #778 <String "The required weight of number of roles' hierarchy for WSC.">
    //    1    3:areturn         
    }

    public String wspTipText()
    {
        return "The required weight of Similarity of permssions for Similarity.";
    //    0    0:ldc2            #781 <String "The required weight of Similarity of permssions for Similarity.">
    //    1    3:areturn         
    }

    public String wsuTipText()
    {
        return "The required weight of Similarity of users for Similarity.";
    //    0    0:ldc2            #784 <String "The required weight of Similarity of users for Similarity.">
    //    1    3:areturn         
    }

    public String wshTipText()
    {
        return "The required weight of Similarity of hierarchy for Similarity.";
    //    0    0:ldc2            #787 <String "The required weight of Similarity of hierarchy for Similarity.">
    //    1    3:areturn         
    }

    public String wfTipText()
    {
        return "The required weight of Similarity of Similarity for GOF.";
    //    0    0:ldc2            #790 <String "The required weight of Similarity of Similarity for GOF.">
    //    1    3:areturn         
    }

    public Vector permissions;
    public Vector userCandidateRoles;
    public Vector initRoles;
    public Vector defaultRoles;
    public Vector FinalRoles;
    public Vector users;
    public static int userCardConstraint = 40;
    public static int permCardConstraint = 56;
    public static int roleAscending = 0;
    public static int threshold = 0;
    private StringBuffer log;
    public int wr;
    public int wu;
    public int wp;
    public int wh;
    public double wsp;
    public double wsu;
    public double wsh;
    public double wf;
    private Assignment m_assignment;
    private Assignment m_assroles;

    static 
    {
    //    0    0:bipush          40
    //    1    2:putstatic       #40  <Field int userCardConstraint>
    //    2    5:bipush          56
    //    3    7:putstatic       #42  <Field int permCardConstraint>
    //    4   10:iconst_0        
    //    5   11:putstatic       #44  <Field int roleAscending>
    //    6   14:iconst_0        
    //    7   15:putstatic       #46  <Field int threshold>
    //*   8   18:return          
    }
}
