// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   CCRMimplement.java

package rm.rolemining;

import java.util.*;
import rm.core.*;

// Referenced classes of package rm.rolemining:
//            AbstractRoleminer

public class CCRMimplement extends AbstractRoleminer
    implements OptionHandler
{
    public class candidateRole
    {

        public Vector getPermVect()
        {
            return permVect;
        //    0    0:aload_0         
        //    1    1:getfield        #27  <Field Vector permVect>
        //    2    4:areturn         
        }

        public void setPermVect(Vector permVect)
        {
            this.permVect = permVect;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #27  <Field Vector permVect>
        //    3    5:return          
        }

        private Vector permVect;
        final CCRMimplement this$0;

        public candidateRole()
        {
            this$0 = CCRMimplement.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #15  <Field CCRMimplement this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #18  <Method void Object()>
        //    5    9:return          
        }
    }

    public class permNode
        implements Comparable
    {

        public int getPConstraint()
        {
            return pConstraint;
        //    0    0:aload_0         
        //    1    1:getfield        #27  <Field int pConstraint>
        //    2    4:ireturn         
        }

        public int compareTo(Object object)
        {
            permNode other = (permNode)object;
        //    0    0:aload_1         
        //    1    1:checkcast       #2   <Class CCRMimplement$permNode>
        //    2    4:astore_2        
            if(pConstraint > other.pConstraint)
        //*   3    5:aload_0         
        //*   4    6:getfield        #27  <Field int pConstraint>
        //*   5    9:aload_2         
        //*   6   10:getfield        #27  <Field int pConstraint>
        //*   7   13:icmple          18
                return 1;
        //    8   16:iconst_1        
        //    9   17:ireturn         
            return pConstraint != other.pConstraint ? -1 : 0;
        //   10   18:aload_0         
        //   11   19:getfield        #27  <Field int pConstraint>
        //   12   22:aload_2         
        //   13   23:getfield        #27  <Field int pConstraint>
        //   14   26:icmpne          31
        //   15   29:iconst_0        
        //   16   30:ireturn         
        //   17   31:iconst_m1       
        //   18   32:ireturn         
        }

        public permNode copy()
        {
            permNode copyPermNode = new permNode();
        //    0    0:new             #2   <Class CCRMimplement$permNode>
        //    1    3:dup             
        //    2    4:aload_0         
        //    3    5:getfield        #16  <Field CCRMimplement this$0>
        //    4    8:invokespecial   #36  <Method void CCRMimplement$permNode(CCRMimplement)>
        //    5   11:astore_1        
            copyPermNode.permIndex = permIndex;
        //    6   12:aload_1         
        //    7   13:aload_0         
        //    8   14:getfield        #38  <Field int permIndex>
        //    9   17:putfield        #38  <Field int permIndex>
            copyPermNode.pConstraint = pConstraint;
        //   10   20:aload_1         
        //   11   21:aload_0         
        //   12   22:getfield        #27  <Field int pConstraint>
        //   13   25:putfield        #27  <Field int pConstraint>
            return copyPermNode;
        //   14   28:aload_1         
        //   15   29:areturn         
        }

        public void setPConstraint(int constraint)
        {
            pConstraint = constraint;
        //    0    0:aload_0         
        //    1    1:iload_1         
        //    2    2:putfield        #27  <Field int pConstraint>
        //    3    5:return          
        }

        public int getPermIndex()
        {
            return permIndex;
        //    0    0:aload_0         
        //    1    1:getfield        #38  <Field int permIndex>
        //    2    4:ireturn         
        }

        public void setPermIndex(int permIndex)
        {
            this.permIndex = permIndex;
        //    0    0:aload_0         
        //    1    1:iload_1         
        //    2    2:putfield        #38  <Field int permIndex>
        //    3    5:return          
        }

        private int permIndex;
        private int pConstraint;
        final CCRMimplement this$0;

        public permNode()
        {
            this$0 = CCRMimplement.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #16  <Field CCRMimplement this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #19  <Method void Object()>
        //    5    9:return          
        }
    }

    public class Role
    {

        public Role copy()
        {
            Role copyRole = new Role();
        //    0    0:new             #2   <Class CCRMimplement$Role>
        //    1    3:dup             
        //    2    4:aload_0         
        //    3    5:getfield        #16  <Field CCRMimplement this$0>
        //    4    8:invokespecial   #27  <Method void CCRMimplement$Role(CCRMimplement)>
        //    5   11:astore_1        
            copyRole.perms = (Vector)perms.clone();
        //    6   12:aload_1         
        //    7   13:aload_0         
        //    8   14:getfield        #29  <Field Vector perms>
        //    9   17:invokevirtual   #35  <Method Object Vector.clone()>
        //   10   20:checkcast       #31  <Class Vector>
        //   11   23:putfield        #29  <Field Vector perms>
            copyRole.users = (Vector)users.clone();
        //   12   26:aload_1         
        //   13   27:aload_0         
        //   14   28:getfield        #37  <Field Vector users>
        //   15   31:invokevirtual   #35  <Method Object Vector.clone()>
        //   16   34:checkcast       #31  <Class Vector>
        //   17   37:putfield        #37  <Field Vector users>
            return copyRole;
        //   18   40:aload_1         
        //   19   41:areturn         
        }

        public Vector getPerms()
        {
            return perms;
        //    0    0:aload_0         
        //    1    1:getfield        #29  <Field Vector perms>
        //    2    4:areturn         
        }

        public void setPerms(Vector perms)
        {
            this.perms = perms;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #29  <Field Vector perms>
        //    3    5:return          
        }

        public Vector getUsers()
        {
            return users;
        //    0    0:aload_0         
        //    1    1:getfield        #37  <Field Vector users>
        //    2    4:areturn         
        }

        public void setUsers(Vector users)
        {
            this.users = users;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #37  <Field Vector users>
        //    3    5:return          
        }

        private Vector perms;
        private Vector users;
        final CCRMimplement this$0;

        public Role()
        {
            this$0 = CCRMimplement.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #16  <Field CCRMimplement this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #19  <Method void Object()>
        //    5    9:return          
        }
    }

    public class userNode
        implements Comparable
    {

        public int getUconstraint()
        {
            return uconstraint;
        //    0    0:aload_0         
        //    1    1:getfield        #31  <Field int uconstraint>
        //    2    4:ireturn         
        }

        public int compareTo(Object object)
        {
            userNode other = (userNode)object;
        //    0    0:aload_1         
        //    1    1:checkcast       #2   <Class CCRMimplement$userNode>
        //    2    4:astore_2        
            if(uconstraint > other.uconstraint)
        //*   3    5:aload_0         
        //*   4    6:getfield        #31  <Field int uconstraint>
        //*   5    9:aload_2         
        //*   6   10:getfield        #31  <Field int uconstraint>
        //*   7   13:icmple          18
                return 1;
        //    8   16:iconst_1        
        //    9   17:ireturn         
            return uconstraint != other.uconstraint ? -1 : 0;
        //   10   18:aload_0         
        //   11   19:getfield        #31  <Field int uconstraint>
        //   12   22:aload_2         
        //   13   23:getfield        #31  <Field int uconstraint>
        //   14   26:icmpne          31
        //   15   29:iconst_0        
        //   16   30:ireturn         
        //   17   31:iconst_m1       
        //   18   32:ireturn         
        }

        public userNode copy()
        {
            userNode copyUserNode = new userNode();
        //    0    0:new             #2   <Class CCRMimplement$userNode>
        //    1    3:dup             
        //    2    4:aload_0         
        //    3    5:getfield        #20  <Field CCRMimplement this$0>
        //    4    8:invokespecial   #40  <Method void CCRMimplement$userNode(CCRMimplement)>
        //    5   11:astore_1        
            copyUserNode.userIndex = userIndex;
        //    6   12:aload_1         
        //    7   13:aload_0         
        //    8   14:getfield        #42  <Field int userIndex>
        //    9   17:putfield        #42  <Field int userIndex>
            copyUserNode.uconstraint = uconstraint;
        //   10   20:aload_1         
        //   11   21:aload_0         
        //   12   22:getfield        #31  <Field int uconstraint>
        //   13   25:putfield        #31  <Field int uconstraint>
            copyUserNode.candidateRoleSet = (Vector)candidateRoleSet.clone();
        //   14   28:aload_1         
        //   15   29:aload_0         
        //   16   30:getfield        #44  <Field Vector candidateRoleSet>
        //   17   33:invokevirtual   #50  <Method Object Vector.clone()>
        //   18   36:checkcast       #46  <Class Vector>
        //   19   39:putfield        #44  <Field Vector candidateRoleSet>
            return copyUserNode;
        //   20   42:aload_1         
        //   21   43:areturn         
        }

        public void setUconstraint(int uconstraint)
        {
            this.uconstraint = uconstraint;
        //    0    0:aload_0         
        //    1    1:iload_1         
        //    2    2:putfield        #31  <Field int uconstraint>
        //    3    5:return          
        }

        public int getUserIndex()
        {
            return userIndex;
        //    0    0:aload_0         
        //    1    1:getfield        #42  <Field int userIndex>
        //    2    4:ireturn         
        }

        public void setUserIndex(int userIndex)
        {
            this.userIndex = userIndex;
        //    0    0:aload_0         
        //    1    1:iload_1         
        //    2    2:putfield        #42  <Field int userIndex>
        //    3    5:return          
        }

        public Vector getCandidateRoleSet()
        {
            return candidateRoleSet;
        //    0    0:aload_0         
        //    1    1:getfield        #44  <Field Vector candidateRoleSet>
        //    2    4:areturn         
        }

        public void setCandidateRoleSet(Vector candidateRoleSet)
        {
            this.candidateRoleSet = candidateRoleSet;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #44  <Field Vector candidateRoleSet>
        //    3    5:return          
        }

        private int userIndex;
        private Vector candidateRoleSet;
        private int uconstraint;
        final CCRMimplement this$0;

        public userNode()
        {
            this$0 = CCRMimplement.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #20  <Field CCRMimplement this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #23  <Method void Object()>
        //    5    9:return          
        }
    }


    public CCRMimplement()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #51  <Method void AbstractRoleminer()>
        wsc = 0;
    //    2    4:aload_0         
    //    3    5:iconst_0        
    //    4    6:putfield        #53  <Field int wsc>
        rh = 0;
    //    5    9:aload_0         
    //    6   10:iconst_0        
    //    7   11:putfield        #55  <Field int rh>
        ua = 0;
    //    8   14:aload_0         
    //    9   15:iconst_0        
    //   10   16:putfield        #57  <Field int ua>
        pa = 0;
    //   11   19:aload_0         
    //   12   20:iconst_0        
    //   13   21:putfield        #59  <Field int pa>
        permissions = new Vector();
    //   14   24:aload_0         
    //   15   25:new             #61  <Class Vector>
    //   16   28:dup             
    //   17   29:invokespecial   #62  <Method void Vector()>
    //   18   32:putfield        #64  <Field Vector permissions>
        users = new Vector();
    //   19   35:aload_0         
    //   20   36:new             #61  <Class Vector>
    //   21   39:dup             
    //   22   40:invokespecial   #62  <Method void Vector()>
    //   23   43:putfield        #66  <Field Vector users>
        userConstraint = new Vector();
    //   24   46:aload_0         
    //   25   47:new             #61  <Class Vector>
    //   26   50:dup             
    //   27   51:invokespecial   #62  <Method void Vector()>
    //   28   54:putfield        #68  <Field Vector userConstraint>
        permConstraint = new Vector();
    //   29   57:aload_0         
    //   30   58:new             #61  <Class Vector>
    //   31   61:dup             
    //   32   62:invokespecial   #62  <Method void Vector()>
    //   33   65:putfield        #70  <Field Vector permConstraint>
        roleSet = new Vector();
    //   34   68:aload_0         
    //   35   69:new             #61  <Class Vector>
    //   36   72:dup             
    //   37   73:invokespecial   #62  <Method void Vector()>
    //   38   76:putfield        #72  <Field Vector roleSet>
        realRoles = new Vector();
    //   39   79:aload_0         
    //   40   80:new             #61  <Class Vector>
    //   41   83:dup             
    //   42   84:invokespecial   #62  <Method void Vector()>
    //   43   87:putfield        #74  <Field Vector realRoles>
        log = new StringBuffer();
    //   44   90:aload_0         
    //   45   91:new             #76  <Class StringBuffer>
    //   46   94:dup             
    //   47   95:invokespecial   #77  <Method void StringBuffer()>
    //   48   98:putfield        #79  <Field StringBuffer log>
        resetOptions();
    //   49  101:aload_0         
    //   50  102:invokespecial   #82  <Method void resetOptions()>
    //   51  105:return          
    }

    public void buildRoleminers(Assignment data)
        throws Exception
    {
        m_assignment = data;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #91  <Field Assignment m_assignment>
        Matrix mat = data.getAssignmentMatrix();
    //    3    5:aload_1         
    //    4    6:invokevirtual   #97  <Method Matrix Assignment.getAssignmentMatrix()>
    //    5    9:astore_2        
        splitAttruteString(data.getDimensionY().getDimensionAttribute(), permissions);
    //    6   10:aload_0         
    //    7   11:aload_1         
    //    8   12:invokevirtual   #101 <Method Dimension Assignment.getDimensionY()>
    //    9   15:invokevirtual   #107 <Method Attribute Dimension.getDimensionAttribute()>
    //   10   18:aload_0         
    //   11   19:getfield        #64  <Field Vector permissions>
    //   12   22:invokespecial   #111 <Method void splitAttruteString(Attribute, Vector)>
        splitAttruteString(data.getDimensionX().getDimensionAttribute(), users);
    //   13   25:aload_0         
    //   14   26:aload_1         
    //   15   27:invokevirtual   #114 <Method Dimension Assignment.getDimensionX()>
    //   16   30:invokevirtual   #107 <Method Attribute Dimension.getDimensionAttribute()>
    //   17   33:aload_0         
    //   18   34:getfield        #66  <Field Vector users>
    //   19   37:invokespecial   #111 <Method void splitAttruteString(Attribute, Vector)>
        generateNeededData(mat);
    //   20   40:aload_0         
    //   21   41:aload_2         
    //   22   42:invokespecial   #118 <Method void generateNeededData(Matrix)>
        buildRoleState();
    //   23   45:aload_0         
    //   24   46:invokespecial   #121 <Method void buildRoleState()>
        tidyRoleState();
    //   25   49:aload_0         
    //   26   50:invokespecial   #124 <Method void tidyRoleState()>
        printRoleState();
    //   27   53:aload_0         
    //   28   54:invokespecial   #127 <Method void printRoleState()>
        computeWSC(mat);
    //   29   57:aload_0         
    //   30   58:aload_2         
    //   31   59:invokespecial   #130 <Method void computeWSC(Matrix)>
        log.append((new StringBuilder("R\u4E3A: ")).append(roleSet.size()).append("\n").toString());
    //   32   62:aload_0         
    //   33   63:getfield        #79  <Field StringBuffer log>
    //   34   66:new             #132 <Class StringBuilder>
    //   35   69:dup             
    //   36   70:ldc1            #134 <String "R\u4E3A: ">
    //   37   72:invokespecial   #137 <Method void StringBuilder(String)>
    //   38   75:aload_0         
    //   39   76:getfield        #72  <Field Vector roleSet>
    //   40   79:invokevirtual   #141 <Method int Vector.size()>
    //   41   82:invokevirtual   #145 <Method StringBuilder StringBuilder.append(int)>
    //   42   85:ldc1            #147 <String "\n">
    //   43   87:invokevirtual   #150 <Method StringBuilder StringBuilder.append(String)>
    //   44   90:invokevirtual   #154 <Method String StringBuilder.toString()>
    //   45   93:invokevirtual   #157 <Method StringBuffer StringBuffer.append(String)>
    //   46   96:pop             
        log.append((new StringBuilder("UA\u4E3A: ")).append(ua).append("\n").toString());
    //   47   97:aload_0         
    //   48   98:getfield        #79  <Field StringBuffer log>
    //   49  101:new             #132 <Class StringBuilder>
    //   50  104:dup             
    //   51  105:ldc1            #159 <String "UA\u4E3A: ">
    //   52  107:invokespecial   #137 <Method void StringBuilder(String)>
    //   53  110:aload_0         
    //   54  111:getfield        #57  <Field int ua>
    //   55  114:invokevirtual   #145 <Method StringBuilder StringBuilder.append(int)>
    //   56  117:ldc1            #147 <String "\n">
    //   57  119:invokevirtual   #150 <Method StringBuilder StringBuilder.append(String)>
    //   58  122:invokevirtual   #154 <Method String StringBuilder.toString()>
    //   59  125:invokevirtual   #157 <Method StringBuffer StringBuffer.append(String)>
    //   60  128:pop             
        log.append((new StringBuilder("PA\u4E3A: ")).append(pa).append("\n").toString());
    //   61  129:aload_0         
    //   62  130:getfield        #79  <Field StringBuffer log>
    //   63  133:new             #132 <Class StringBuilder>
    //   64  136:dup             
    //   65  137:ldc1            #161 <String "PA\u4E3A: ">
    //   66  139:invokespecial   #137 <Method void StringBuilder(String)>
    //   67  142:aload_0         
    //   68  143:getfield        #59  <Field int pa>
    //   69  146:invokevirtual   #145 <Method StringBuilder StringBuilder.append(int)>
    //   70  149:ldc1            #147 <String "\n">
    //   71  151:invokevirtual   #150 <Method StringBuilder StringBuilder.append(String)>
    //   72  154:invokevirtual   #154 <Method String StringBuilder.toString()>
    //   73  157:invokevirtual   #157 <Method StringBuffer StringBuffer.append(String)>
    //   74  160:pop             
        log.append((new StringBuilder("RH\u4E3A: ")).append(rh).append("\n").toString());
    //   75  161:aload_0         
    //   76  162:getfield        #79  <Field StringBuffer log>
    //   77  165:new             #132 <Class StringBuilder>
    //   78  168:dup             
    //   79  169:ldc1            #163 <String "RH\u4E3A: ">
    //   80  171:invokespecial   #137 <Method void StringBuilder(String)>
    //   81  174:aload_0         
    //   82  175:getfield        #55  <Field int rh>
    //   83  178:invokevirtual   #145 <Method StringBuilder StringBuilder.append(int)>
    //   84  181:ldc1            #147 <String "\n">
    //   85  183:invokevirtual   #150 <Method StringBuilder StringBuilder.append(String)>
    //   86  186:invokevirtual   #154 <Method String StringBuilder.toString()>
    //   87  189:invokevirtual   #157 <Method StringBuffer StringBuffer.append(String)>
    //   88  192:pop             
        log.append((new StringBuilder("wsc\u4E3A: ")).append(wsc).append("\n").toString());
    //   89  193:aload_0         
    //   90  194:getfield        #79  <Field StringBuffer log>
    //   91  197:new             #132 <Class StringBuilder>
    //   92  200:dup             
    //   93  201:ldc1            #165 <String "wsc\u4E3A: ">
    //   94  203:invokespecial   #137 <Method void StringBuilder(String)>
    //   95  206:aload_0         
    //   96  207:getfield        #53  <Field int wsc>
    //   97  210:invokevirtual   #145 <Method StringBuilder StringBuilder.append(int)>
    //   98  213:ldc1            #147 <String "\n">
    //   99  215:invokevirtual   #150 <Method StringBuilder StringBuilder.append(String)>
    //  100  218:invokevirtual   #154 <Method String StringBuilder.toString()>
    //  101  221:invokevirtual   #157 <Method StringBuffer StringBuffer.append(String)>
    //  102  224:pop             
    //  103  225:return          
    }

    private void printRoleState()
    {
        for(int index = 0; index < roleSet.size(); index++)
    //*   0    0:iconst_0        
    //*   1    1:istore_1        
    //*   2    2:goto            206
        {
            log.append((new StringBuilder("\u7B2C")).append(index).append("\u4E2A\u89D2\u8272\u7684\u6743\u9650\u4E3A: ").append("\n").toString());
    //    3    5:aload_0         
    //    4    6:getfield        #79  <Field StringBuffer log>
    //    5    9:new             #132 <Class StringBuilder>
    //    6   12:dup             
    //    7   13:ldc1            #170 <String "\u7B2C">
    //    8   15:invokespecial   #137 <Method void StringBuilder(String)>
    //    9   18:iload_1         
    //   10   19:invokevirtual   #145 <Method StringBuilder StringBuilder.append(int)>
    //   11   22:ldc1            #172 <String "\u4E2A\u89D2\u8272\u7684\u6743\u9650\u4E3A: ">
    //   12   24:invokevirtual   #150 <Method StringBuilder StringBuilder.append(String)>
    //   13   27:ldc1            #147 <String "\n">
    //   14   29:invokevirtual   #150 <Method StringBuilder StringBuilder.append(String)>
    //   15   32:invokevirtual   #154 <Method String StringBuilder.toString()>
    //   16   35:invokevirtual   #157 <Method StringBuffer StringBuffer.append(String)>
    //   17   38:pop             
            Vector indexPermList = ((Role)roleSet.get(index)).getPerms();
    //   18   39:aload_0         
    //   19   40:getfield        #72  <Field Vector roleSet>
    //   20   43:iload_1         
    //   21   44:invokevirtual   #176 <Method Object Vector.get(int)>
    //   22   47:checkcast       #178 <Class CCRMimplement$Role>
    //   23   50:invokevirtual   #182 <Method Vector CCRMimplement$Role.getPerms()>
    //   24   53:astore_2        
            for(int jndex = 0; jndex < indexPermList.size(); jndex++)
    //*  25   54:iconst_0        
    //*  26   55:istore_3        
    //*  27   56:goto            169
                if(jndex != indexPermList.size() - 1)
    //*  28   59:iload_3         
    //*  29   60:aload_2         
    //*  30   61:invokevirtual   #141 <Method int Vector.size()>
    //*  31   64:iconst_1        
    //*  32   65:isub            
    //*  33   66:icmpeq          119
                    log.append((new StringBuilder(String.valueOf((String)permissions.get(((Integer)indexPermList.get(jndex)).intValue())))).append("\n").toString());
    //   34   69:aload_0         
    //   35   70:getfield        #79  <Field StringBuffer log>
    //   36   73:new             #132 <Class StringBuilder>
    //   37   76:dup             
    //   38   77:aload_0         
    //   39   78:getfield        #64  <Field Vector permissions>
    //   40   81:aload_2         
    //   41   82:iload_3         
    //   42   83:invokevirtual   #176 <Method Object Vector.get(int)>
    //   43   86:checkcast       #184 <Class Integer>
    //   44   89:invokevirtual   #187 <Method int Integer.intValue()>
    //   45   92:invokevirtual   #176 <Method Object Vector.get(int)>
    //   46   95:checkcast       #189 <Class String>
    //   47   98:invokestatic    #193 <Method String String.valueOf(Object)>
    //   48  101:invokespecial   #137 <Method void StringBuilder(String)>
    //   49  104:ldc1            #147 <String "\n">
    //   50  106:invokevirtual   #150 <Method StringBuilder StringBuilder.append(String)>
    //   51  109:invokevirtual   #154 <Method String StringBuilder.toString()>
    //   52  112:invokevirtual   #157 <Method StringBuffer StringBuffer.append(String)>
    //   53  115:pop             
                else
    //*  54  116:goto            166
                    log.append((new StringBuilder(String.valueOf((String)permissions.get(((Integer)indexPermList.get(jndex)).intValue())))).append("\n").toString());
    //   55  119:aload_0         
    //   56  120:getfield        #79  <Field StringBuffer log>
    //   57  123:new             #132 <Class StringBuilder>
    //   58  126:dup             
    //   59  127:aload_0         
    //   60  128:getfield        #64  <Field Vector permissions>
    //   61  131:aload_2         
    //   62  132:iload_3         
    //   63  133:invokevirtual   #176 <Method Object Vector.get(int)>
    //   64  136:checkcast       #184 <Class Integer>
    //   65  139:invokevirtual   #187 <Method int Integer.intValue()>
    //   66  142:invokevirtual   #176 <Method Object Vector.get(int)>
    //   67  145:checkcast       #189 <Class String>
    //   68  148:invokestatic    #193 <Method String String.valueOf(Object)>
    //   69  151:invokespecial   #137 <Method void StringBuilder(String)>
    //   70  154:ldc1            #147 <String "\n">
    //   71  156:invokevirtual   #150 <Method StringBuilder StringBuilder.append(String)>
    //   72  159:invokevirtual   #154 <Method String StringBuilder.toString()>
    //   73  162:invokevirtual   #157 <Method StringBuffer StringBuffer.append(String)>
    //   74  165:pop             

    //   75  166:iinc            3  1
    //   76  169:iload_3         
    //   77  170:aload_2         
    //   78  171:invokevirtual   #141 <Method int Vector.size()>
    //   79  174:icmplt          59
            ua += ((Role)roleSet.get(index)).getUsers().size();
    //   80  177:aload_0         
    //   81  178:dup             
    //   82  179:getfield        #57  <Field int ua>
    //   83  182:aload_0         
    //   84  183:getfield        #72  <Field Vector roleSet>
    //   85  186:iload_1         
    //   86  187:invokevirtual   #176 <Method Object Vector.get(int)>
    //   87  190:checkcast       #178 <Class CCRMimplement$Role>
    //   88  193:invokevirtual   #196 <Method Vector CCRMimplement$Role.getUsers()>
    //   89  196:invokevirtual   #141 <Method int Vector.size()>
    //   90  199:iadd            
    //   91  200:putfield        #57  <Field int ua>
        }

    //   92  203:iinc            1  1
    //   93  206:iload_1         
    //   94  207:aload_0         
    //   95  208:getfield        #72  <Field Vector roleSet>
    //   96  211:invokevirtual   #141 <Method int Vector.size()>
    //   97  214:icmplt          5
        wsc += wu * ua;
    //   98  217:aload_0         
    //   99  218:dup             
    //  100  219:getfield        #53  <Field int wsc>
    //  101  222:aload_0         
    //  102  223:getfield        #198 <Field int wu>
    //  103  226:aload_0         
    //  104  227:getfield        #57  <Field int ua>
    //  105  230:imul            
    //  106  231:iadd            
    //  107  232:putfield        #53  <Field int wsc>
        log.append((new StringBuilder("\n\u89D2\u8272\u52BF\u7EA6\u675F\u7684\u4E2A\u6570\u4E3A: ")).append(roleLimits).append("\n").toString());
    //  108  235:aload_0         
    //  109  236:getfield        #79  <Field StringBuffer log>
    //  110  239:new             #132 <Class StringBuilder>
    //  111  242:dup             
    //  112  243:ldc1            #200 <String "\n\u89D2\u8272\u52BF\u7EA6\u675F\u7684\u4E2A\u6570\u4E3A: ">
    //  113  245:invokespecial   #137 <Method void StringBuilder(String)>
    //  114  248:aload_0         
    //  115  249:getfield        #202 <Field int roleLimits>
    //  116  252:invokevirtual   #145 <Method StringBuilder StringBuilder.append(int)>
    //  117  255:ldc1            #147 <String "\n">
    //  118  257:invokevirtual   #150 <Method StringBuilder StringBuilder.append(String)>
    //  119  260:invokevirtual   #154 <Method String StringBuilder.toString()>
    //  120  263:invokevirtual   #157 <Method StringBuffer StringBuffer.append(String)>
    //  121  266:pop             
        log.append((new StringBuilder("\u6743\u9650\u52BF\u7EA6\u675F\u7684\u4E2A\u6570\u4E3A: ")).append(permLimits).append("\n").toString());
    //  122  267:aload_0         
    //  123  268:getfield        #79  <Field StringBuffer log>
    //  124  271:new             #132 <Class StringBuilder>
    //  125  274:dup             
    //  126  275:ldc1            #204 <String "\u6743\u9650\u52BF\u7EA6\u675F\u7684\u4E2A\u6570\u4E3A: ">
    //  127  277:invokespecial   #137 <Method void StringBuilder(String)>
    //  128  280:aload_0         
    //  129  281:getfield        #206 <Field int permLimits>
    //  130  284:invokevirtual   #145 <Method StringBuilder StringBuilder.append(int)>
    //  131  287:ldc1            #147 <String "\n">
    //  132  289:invokevirtual   #150 <Method StringBuilder StringBuilder.append(String)>
    //  133  292:invokevirtual   #154 <Method String StringBuilder.toString()>
    //  134  295:invokevirtual   #157 <Method StringBuffer StringBuffer.append(String)>
    //  135  298:pop             
    //  136  299:return          
    }

    private void computeWSC(Matrix mat)
    {
        wsc += wr * roleSet.size();
    //    0    0:aload_0         
    //    1    1:dup             
    //    2    2:getfield        #53  <Field int wsc>
    //    3    5:aload_0         
    //    4    6:getfield        #213 <Field int wr>
    //    5    9:aload_0         
    //    6   10:getfield        #72  <Field Vector roleSet>
    //    7   13:invokevirtual   #141 <Method int Vector.size()>
    //    8   16:imul            
    //    9   17:iadd            
    //   10   18:putfield        #53  <Field int wsc>
        wsc += wh * rh;
    //   11   21:aload_0         
    //   12   22:dup             
    //   13   23:getfield        #53  <Field int wsc>
    //   14   26:aload_0         
    //   15   27:getfield        #215 <Field int wh>
    //   16   30:aload_0         
    //   17   31:getfield        #55  <Field int rh>
    //   18   34:imul            
    //   19   35:iadd            
    //   20   36:putfield        #53  <Field int wsc>
        for(int index = 0; index < roleSet.size(); index++)
    //*  21   39:iconst_0        
    //*  22   40:istore_2        
    //*  23   41:goto            109
        {
            pa += wp * ((Role)roleSet.get(index)).getPerms().size();
    //   24   44:aload_0         
    //   25   45:dup             
    //   26   46:getfield        #59  <Field int pa>
    //   27   49:aload_0         
    //   28   50:getfield        #217 <Field int wp>
    //   29   53:aload_0         
    //   30   54:getfield        #72  <Field Vector roleSet>
    //   31   57:iload_2         
    //   32   58:invokevirtual   #176 <Method Object Vector.get(int)>
    //   33   61:checkcast       #178 <Class CCRMimplement$Role>
    //   34   64:invokevirtual   #182 <Method Vector CCRMimplement$Role.getPerms()>
    //   35   67:invokevirtual   #141 <Method int Vector.size()>
    //   36   70:imul            
    //   37   71:iadd            
    //   38   72:putfield        #59  <Field int pa>
            wsc += wp * ((Role)roleSet.get(index)).getPerms().size();
    //   39   75:aload_0         
    //   40   76:dup             
    //   41   77:getfield        #53  <Field int wsc>
    //   42   80:aload_0         
    //   43   81:getfield        #217 <Field int wp>
    //   44   84:aload_0         
    //   45   85:getfield        #72  <Field Vector roleSet>
    //   46   88:iload_2         
    //   47   89:invokevirtual   #176 <Method Object Vector.get(int)>
    //   48   92:checkcast       #178 <Class CCRMimplement$Role>
    //   49   95:invokevirtual   #182 <Method Vector CCRMimplement$Role.getPerms()>
    //   50   98:invokevirtual   #141 <Method int Vector.size()>
    //   51  101:imul            
    //   52  102:iadd            
    //   53  103:putfield        #53  <Field int wsc>
        }

    //   54  106:iinc            2  1
    //   55  109:iload_2         
    //   56  110:aload_0         
    //   57  111:getfield        #72  <Field Vector roleSet>
    //   58  114:invokevirtual   #141 <Method int Vector.size()>
    //   59  117:icmplt          44
    //   60  120:return          
    }

    private void tidyRoleState()
    {
        for(int index = 0; index < realRoles.size(); index++)
    //*   0    0:iconst_0        
    //*   1    1:istore_1        
    //*   2    2:goto            27
            roleSet.add((Role)realRoles.get(index));
    //    3    5:aload_0         
    //    4    6:getfield        #72  <Field Vector roleSet>
    //    5    9:aload_0         
    //    6   10:getfield        #74  <Field Vector realRoles>
    //    7   13:iload_1         
    //    8   14:invokevirtual   #176 <Method Object Vector.get(int)>
    //    9   17:checkcast       #178 <Class CCRMimplement$Role>
    //   10   20:invokevirtual   #221 <Method boolean Vector.add(Object)>
    //   11   23:pop             

    //   12   24:iinc            1  1
    //   13   27:iload_1         
    //   14   28:aload_0         
    //   15   29:getfield        #74  <Field Vector realRoles>
    //   16   32:invokevirtual   #141 <Method int Vector.size()>
    //   17   35:icmplt          5
        for(int index = 0; index < roleSet.size() - 1; index++)
    //*  18   38:iconst_0        
    //*  19   39:istore_1        
    //*  20   40:goto            154
        {
            for(int jndex = index + 1; jndex < roleSet.size();)
    //*  21   43:iload_1         
    //*  22   44:iconst_1        
    //*  23   45:iadd            
    //*  24   46:istore_2        
    //*  25   47:goto            140
                if(isEqual(((Role)roleSet.get(index)).getPerms(), ((Role)roleSet.get(jndex)).getPerms()))
    //*  26   50:aload_0         
    //*  27   51:aload_0         
    //*  28   52:getfield        #72  <Field Vector roleSet>
    //*  29   55:iload_1         
    //*  30   56:invokevirtual   #176 <Method Object Vector.get(int)>
    //*  31   59:checkcast       #178 <Class CCRMimplement$Role>
    //*  32   62:invokevirtual   #182 <Method Vector CCRMimplement$Role.getPerms()>
    //*  33   65:aload_0         
    //*  34   66:getfield        #72  <Field Vector roleSet>
    //*  35   69:iload_2         
    //*  36   70:invokevirtual   #176 <Method Object Vector.get(int)>
    //*  37   73:checkcast       #178 <Class CCRMimplement$Role>
    //*  38   76:invokevirtual   #182 <Method Vector CCRMimplement$Role.getPerms()>
    //*  39   79:invokespecial   #225 <Method boolean isEqual(Vector, Vector)>
    //*  40   82:ifeq            137
                {
                    addElements(((Role)roleSet.get(index)).getUsers(), ((Role)roleSet.get(jndex)).getUsers());
    //   41   85:aload_0         
    //   42   86:aload_0         
    //   43   87:getfield        #72  <Field Vector roleSet>
    //   44   90:iload_1         
    //   45   91:invokevirtual   #176 <Method Object Vector.get(int)>
    //   46   94:checkcast       #178 <Class CCRMimplement$Role>
    //   47   97:invokevirtual   #196 <Method Vector CCRMimplement$Role.getUsers()>
    //   48  100:aload_0         
    //   49  101:getfield        #72  <Field Vector roleSet>
    //   50  104:iload_2         
    //   51  105:invokevirtual   #176 <Method Object Vector.get(int)>
    //   52  108:checkcast       #178 <Class CCRMimplement$Role>
    //   53  111:invokevirtual   #196 <Method Vector CCRMimplement$Role.getUsers()>
    //   54  114:invokespecial   #229 <Method void addElements(Vector, Vector)>
                    roleSet.remove(jndex);
    //   55  117:aload_0         
    //   56  118:getfield        #72  <Field Vector roleSet>
    //   57  121:iload_2         
    //   58  122:invokevirtual   #232 <Method Object Vector.remove(int)>
    //   59  125:pop             
                    numberOfRoles--;
    //   60  126:getstatic       #46  <Field int numberOfRoles>
    //   61  129:iconst_1        
    //   62  130:isub            
    //   63  131:putstatic       #46  <Field int numberOfRoles>
                } else
    //*  64  134:goto            140
                {
                    jndex++;
    //   65  137:iinc            2  1
                }

    //   66  140:iload_2         
    //   67  141:aload_0         
    //   68  142:getfield        #72  <Field Vector roleSet>
    //   69  145:invokevirtual   #141 <Method int Vector.size()>
    //   70  148:icmplt          50
        }

    //   71  151:iinc            1  1
    //   72  154:iload_1         
    //   73  155:aload_0         
    //   74  156:getfield        #72  <Field Vector roleSet>
    //   75  159:invokevirtual   #141 <Method int Vector.size()>
    //   76  162:iconst_1        
    //   77  163:isub            
    //   78  164:icmplt          43
        for(int index = 0; index < roleSet.size(); index++)
    //*  79  167:iconst_0        
    //*  80  168:istore_1        
    //*  81  169:goto            209
        {
            Collections.sort(((Role)roleSet.get(index)).getUsers());
    //   82  172:aload_0         
    //   83  173:getfield        #72  <Field Vector roleSet>
    //   84  176:iload_1         
    //   85  177:invokevirtual   #176 <Method Object Vector.get(int)>
    //   86  180:checkcast       #178 <Class CCRMimplement$Role>
    //   87  183:invokevirtual   #196 <Method Vector CCRMimplement$Role.getUsers()>
    //   88  186:invokestatic    #238 <Method void Collections.sort(java.util.List)>
            Collections.sort(((Role)roleSet.get(index)).getPerms());
    //   89  189:aload_0         
    //   90  190:getfield        #72  <Field Vector roleSet>
    //   91  193:iload_1         
    //   92  194:invokevirtual   #176 <Method Object Vector.get(int)>
    //   93  197:checkcast       #178 <Class CCRMimplement$Role>
    //   94  200:invokevirtual   #182 <Method Vector CCRMimplement$Role.getPerms()>
    //   95  203:invokestatic    #238 <Method void Collections.sort(java.util.List)>
        }

    //   96  206:iinc            1  1
    //   97  209:iload_1         
    //   98  210:aload_0         
    //   99  211:getfield        #72  <Field Vector roleSet>
    //  100  214:invokevirtual   #141 <Method int Vector.size()>
    //  101  217:icmplt          172
    //  102  220:return          
    }

    private void buildRoleState()
    {
        dealWithEquation();
    //    0    0:aload_0         
    //    1    1:invokespecial   #241 <Method void dealWithEquation()>
        dealWith1Constraint();
    //    2    4:aload_0         
    //    3    5:invokespecial   #244 <Method void dealWith1Constraint()>
        if(!haveSolution())
    //*   4    8:aload_0         
    //*   5    9:invokespecial   #248 <Method boolean haveSolution()>
    //*   6   12:ifne            25
            log.append("\u5F53\u524D\u7684\u7EA6\u675F\u65E0\u89E3!\n");
    //    7   15:aload_0         
    //    8   16:getfield        #79  <Field StringBuffer log>
    //    9   19:ldc1            #250 <String "\u5F53\u524D\u7684\u7EA6\u675F\u65E0\u89E3!\n">
    //   10   21:invokevirtual   #157 <Method StringBuffer StringBuffer.append(String)>
    //   11   24:pop             
        boolean havedone = true;
    //   12   25:iconst_1        
    //   13   26:istore_1        
    //*  14   27:goto            42
        while(havedone) 
        {
            havedone = false;
    //   15   30:iconst_0        
    //   16   31:istore_1        
            dealWithSubset(havedone);
    //   17   32:aload_0         
    //   18   33:iload_1         
    //   19   34:invokespecial   #254 <Method void dealWithSubset(boolean)>
            dealWithCross(havedone);
    //   20   37:aload_0         
    //   21   38:iload_1         
    //   22   39:invokespecial   #257 <Method void dealWithCross(boolean)>
        }
    //   23   42:iload_1         
    //   24   43:ifne            30
    //   25   46:return          
    }

    private boolean haveSolution()
    {
        for(int index = 0; index < permConstraint.size(); index++)
    //*   0    0:iconst_0        
    //*   1    1:istore_1        
    //*   2    2:goto            98
        {
            int curConstraint = ((permNode)permConstraint.get(index)).getPConstraint();
    //    3    5:aload_0         
    //    4    6:getfield        #70  <Field Vector permConstraint>
    //    5    9:iload_1         
    //    6   10:invokevirtual   #176 <Method Object Vector.get(int)>
    //    7   13:checkcast       #261 <Class CCRMimplement$permNode>
    //    8   16:invokevirtual   #264 <Method int CCRMimplement$permNode.getPConstraint()>
    //    9   19:istore_2        
            int curIndex = ((permNode)permConstraint.get(index)).getPermIndex();
    //   10   20:aload_0         
    //   11   21:getfield        #70  <Field Vector permConstraint>
    //   12   24:iload_1         
    //   13   25:invokevirtual   #176 <Method Object Vector.get(int)>
    //   14   28:checkcast       #261 <Class CCRMimplement$permNode>
    //   15   31:invokevirtual   #267 <Method int CCRMimplement$permNode.getPermIndex()>
    //   16   34:istore_3        
            int count = 0;
    //   17   35:iconst_0        
    //   18   36:istore          4
            for(int jndex = 0; jndex < realRoles.size(); jndex++)
    //*  19   38:iconst_0        
    //*  20   39:istore          5
    //*  21   41:goto            75
                if(((Role)realRoles.get(jndex)).getPerms().contains(Integer.valueOf(curIndex)))
    //*  22   44:aload_0         
    //*  23   45:getfield        #74  <Field Vector realRoles>
    //*  24   48:iload           5
    //*  25   50:invokevirtual   #176 <Method Object Vector.get(int)>
    //*  26   53:checkcast       #178 <Class CCRMimplement$Role>
    //*  27   56:invokevirtual   #182 <Method Vector CCRMimplement$Role.getPerms()>
    //*  28   59:iload_3         
    //*  29   60:invokestatic    #270 <Method Integer Integer.valueOf(int)>
    //*  30   63:invokevirtual   #273 <Method boolean Vector.contains(Object)>
    //*  31   66:ifeq            72
                    count++;
    //   32   69:iinc            4  1

    //   33   72:iinc            5  1
    //   34   75:iload           5
    //   35   77:aload_0         
    //   36   78:getfield        #74  <Field Vector realRoles>
    //   37   81:invokevirtual   #141 <Method int Vector.size()>
    //   38   84:icmplt          44
            if(count > curConstraint)
    //*  39   87:iload           4
    //*  40   89:iload_2         
    //*  41   90:icmple          95
                return false;
    //   42   93:iconst_0        
    //   43   94:ireturn         
        }

    //   44   95:iinc            1  1
    //   45   98:iload_1         
    //   46   99:aload_0         
    //   47  100:getfield        #70  <Field Vector permConstraint>
    //   48  103:invokevirtual   #141 <Method int Vector.size()>
    //   49  106:icmplt          5
        return true;
    //   50  109:iconst_1        
    //   51  110:ireturn         
    }

    private void dealWith1Constraint()
    {
        for(int index = 0; index < userConstraint.size();)
    //*   0    0:iconst_0        
    //*   1    1:istore_1        
    //*   2    2:goto            164
            if(((userNode)userConstraint.get(index)).getUconstraint() == 1)
    //*   3    5:aload_0         
    //*   4    6:getfield        #68  <Field Vector userConstraint>
    //*   5    9:iload_1         
    //*   6   10:invokevirtual   #176 <Method Object Vector.get(int)>
    //*   7   13:checkcast       #278 <Class CCRMimplement$userNode>
    //*   8   16:invokevirtual   #281 <Method int CCRMimplement$userNode.getUconstraint()>
    //*   9   19:iconst_1        
    //*  10   20:icmpne          161
            {
                Vector crs = ((userNode)userConstraint.get(index)).getCandidateRoleSet();
    //   11   23:aload_0         
    //   12   24:getfield        #68  <Field Vector userConstraint>
    //   13   27:iload_1         
    //   14   28:invokevirtual   #176 <Method Object Vector.get(int)>
    //   15   31:checkcast       #278 <Class CCRMimplement$userNode>
    //   16   34:invokevirtual   #284 <Method Vector CCRMimplement$userNode.getCandidateRoleSet()>
    //   17   37:astore_2        
                for(int kndex = 0; kndex < crs.size(); kndex++)
    //*  18   38:iconst_0        
    //*  19   39:istore_3        
    //*  20   40:goto            141
                {
                    Vector curPerms = ((candidateRole)crs.get(kndex)).getPermVect();
    //   21   43:aload_2         
    //   22   44:iload_3         
    //   23   45:invokevirtual   #176 <Method Object Vector.get(int)>
    //   24   48:checkcast       #286 <Class CCRMimplement$candidateRole>
    //   25   51:invokevirtual   #289 <Method Vector CCRMimplement$candidateRole.getPermVect()>
    //   26   54:astore          4
                    for(int jndex = 0; jndex < roleSet.size(); jndex++)
    //*  27   56:iconst_0        
    //*  28   57:istore          5
    //*  29   59:goto            126
                    {
                        Vector tempPerms = ((Role)roleSet.get(jndex)).getPerms();
    //   30   62:aload_0         
    //   31   63:getfield        #72  <Field Vector roleSet>
    //   32   66:iload           5
    //   33   68:invokevirtual   #176 <Method Object Vector.get(int)>
    //   34   71:checkcast       #178 <Class CCRMimplement$Role>
    //   35   74:invokevirtual   #182 <Method Vector CCRMimplement$Role.getPerms()>
    //   36   77:astore          6
                        if(!isEqual(curPerms, tempPerms))
                            continue;
    //   37   79:aload_0         
    //   38   80:aload           4
    //   39   82:aload           6
    //   40   84:invokespecial   #225 <Method boolean isEqual(Vector, Vector)>
    //   41   87:ifeq            123
                        realRoles.add((Role)roleSet.get(jndex));
    //   42   90:aload_0         
    //   43   91:getfield        #74  <Field Vector realRoles>
    //   44   94:aload_0         
    //   45   95:getfield        #72  <Field Vector roleSet>
    //   46   98:iload           5
    //   47  100:invokevirtual   #176 <Method Object Vector.get(int)>
    //   48  103:checkcast       #178 <Class CCRMimplement$Role>
    //   49  106:invokevirtual   #221 <Method boolean Vector.add(Object)>
    //   50  109:pop             
                        roleSet.remove(jndex);
    //   51  110:aload_0         
    //   52  111:getfield        #72  <Field Vector roleSet>
    //   53  114:iload           5
    //   54  116:invokevirtual   #232 <Method Object Vector.remove(int)>
    //   55  119:pop             
                        break;
    //   56  120:goto            138
                    }

    //   57  123:iinc            5  1
    //   58  126:iload           5
    //   59  128:aload_0         
    //   60  129:getfield        #72  <Field Vector roleSet>
    //   61  132:invokevirtual   #141 <Method int Vector.size()>
    //   62  135:icmplt          62
                }

    //   63  138:iinc            3  1
    //   64  141:iload_3         
    //   65  142:aload_2         
    //   66  143:invokevirtual   #141 <Method int Vector.size()>
    //   67  146:icmplt          43
                userConstraint.remove(index);
    //   68  149:aload_0         
    //   69  150:getfield        #68  <Field Vector userConstraint>
    //   70  153:iload_1         
    //   71  154:invokevirtual   #232 <Method Object Vector.remove(int)>
    //   72  157:pop             
            } else
    //*  73  158:goto            164
            {
                index++;
    //   74  161:iinc            1  1
            }

    //   75  164:iload_1         
    //   76  165:aload_0         
    //   77  166:getfield        #68  <Field Vector userConstraint>
    //   78  169:invokevirtual   #141 <Method int Vector.size()>
    //   79  172:icmplt          5
        for(int index = 0; index < permConstraint.size(); index++)
    //*  80  175:iconst_0        
    //*  81  176:istore_1        
    //*  82  177:goto            399
            if(((permNode)permConstraint.get(index)).getPConstraint() == 1)
    //*  83  180:aload_0         
    //*  84  181:getfield        #70  <Field Vector permConstraint>
    //*  85  184:iload_1         
    //*  86  185:invokevirtual   #176 <Method Object Vector.get(int)>
    //*  87  188:checkcast       #261 <Class CCRMimplement$permNode>
    //*  88  191:invokevirtual   #264 <Method int CCRMimplement$permNode.getPConstraint()>
    //*  89  194:iconst_1        
    //*  90  195:icmpne          396
            {
                for(int jndex = 0; jndex < roleSet.size();)
    //*  91  198:iconst_0        
    //*  92  199:istore_2        
    //*  93  200:goto            274
                    if(((Role)roleSet.get(jndex)).getPerms().contains(Integer.valueOf(((permNode)permConstraint.get(index)).getPermIndex())))
    //*  94  203:aload_0         
    //*  95  204:getfield        #72  <Field Vector roleSet>
    //*  96  207:iload_2         
    //*  97  208:invokevirtual   #176 <Method Object Vector.get(int)>
    //*  98  211:checkcast       #178 <Class CCRMimplement$Role>
    //*  99  214:invokevirtual   #182 <Method Vector CCRMimplement$Role.getPerms()>
    //* 100  217:aload_0         
    //* 101  218:getfield        #70  <Field Vector permConstraint>
    //* 102  221:iload_1         
    //* 103  222:invokevirtual   #176 <Method Object Vector.get(int)>
    //* 104  225:checkcast       #261 <Class CCRMimplement$permNode>
    //* 105  228:invokevirtual   #267 <Method int CCRMimplement$permNode.getPermIndex()>
    //* 106  231:invokestatic    #270 <Method Integer Integer.valueOf(int)>
    //* 107  234:invokevirtual   #273 <Method boolean Vector.contains(Object)>
    //* 108  237:ifeq            271
                    {
                        realRoles.add((Role)roleSet.get(jndex));
    //  109  240:aload_0         
    //  110  241:getfield        #74  <Field Vector realRoles>
    //  111  244:aload_0         
    //  112  245:getfield        #72  <Field Vector roleSet>
    //  113  248:iload_2         
    //  114  249:invokevirtual   #176 <Method Object Vector.get(int)>
    //  115  252:checkcast       #178 <Class CCRMimplement$Role>
    //  116  255:invokevirtual   #221 <Method boolean Vector.add(Object)>
    //  117  258:pop             
                        roleSet.remove(jndex);
    //  118  259:aload_0         
    //  119  260:getfield        #72  <Field Vector roleSet>
    //  120  263:iload_2         
    //  121  264:invokevirtual   #232 <Method Object Vector.remove(int)>
    //  122  267:pop             
                    } else
    //* 123  268:goto            274
                    {
                        jndex++;
    //  124  271:iinc            2  1
                    }

    //  125  274:iload_2         
    //  126  275:aload_0         
    //  127  276:getfield        #72  <Field Vector roleSet>
    //  128  279:invokevirtual   #141 <Method int Vector.size()>
    //  129  282:icmplt          203
                for(int jndex = 0; jndex < userConstraint.size();)
    //* 130  285:iconst_0        
    //* 131  286:istore_2        
    //* 132  287:goto            385
                {
                    Vector crs = ((userNode)userConstraint.get(jndex)).getCandidateRoleSet();
    //  133  290:aload_0         
    //  134  291:getfield        #68  <Field Vector userConstraint>
    //  135  294:iload_2         
    //  136  295:invokevirtual   #176 <Method Object Vector.get(int)>
    //  137  298:checkcast       #278 <Class CCRMimplement$userNode>
    //  138  301:invokevirtual   #284 <Method Vector CCRMimplement$userNode.getCandidateRoleSet()>
    //  139  304:astore_3        
                    int kndex;
                    for(kndex = 0; kndex < crs.size(); kndex++)
    //* 140  305:iconst_0        
    //* 141  306:istore          4
    //* 142  308:goto            352
                        if(((candidateRole)crs.get(kndex)).getPermVect().contains(Integer.valueOf(((permNode)permConstraint.get(index)).getPermIndex())))
    //* 143  311:aload_3         
    //* 144  312:iload           4
    //* 145  314:invokevirtual   #176 <Method Object Vector.get(int)>
    //* 146  317:checkcast       #286 <Class CCRMimplement$candidateRole>
    //* 147  320:invokevirtual   #289 <Method Vector CCRMimplement$candidateRole.getPermVect()>
    //* 148  323:aload_0         
    //* 149  324:getfield        #70  <Field Vector permConstraint>
    //* 150  327:iload_1         
    //* 151  328:invokevirtual   #176 <Method Object Vector.get(int)>
    //* 152  331:checkcast       #261 <Class CCRMimplement$permNode>
    //* 153  334:invokevirtual   #267 <Method int CCRMimplement$permNode.getPermIndex()>
    //* 154  337:invokestatic    #270 <Method Integer Integer.valueOf(int)>
    //* 155  340:invokevirtual   #273 <Method boolean Vector.contains(Object)>
    //* 156  343:ifeq            349
                            break;
    //  157  346:goto            361

    //  158  349:iinc            4  1
    //  159  352:iload           4
    //  160  354:aload_3         
    //  161  355:invokevirtual   #141 <Method int Vector.size()>
    //  162  358:icmplt          311
                    if(kndex < crs.size())
    //* 163  361:iload           4
    //* 164  363:aload_3         
    //* 165  364:invokevirtual   #141 <Method int Vector.size()>
    //* 166  367:icmpge          382
                        userConstraint.remove(jndex);
    //  167  370:aload_0         
    //  168  371:getfield        #68  <Field Vector userConstraint>
    //  169  374:iload_2         
    //  170  375:invokevirtual   #232 <Method Object Vector.remove(int)>
    //  171  378:pop             
                    else
    //* 172  379:goto            385
                        jndex++;
    //  173  382:iinc            2  1
                }

    //  174  385:iload_2         
    //  175  386:aload_0         
    //  176  387:getfield        #68  <Field Vector userConstraint>
    //  177  390:invokevirtual   #141 <Method int Vector.size()>
    //  178  393:icmplt          290
            }

    //  179  396:iinc            1  1
    //  180  399:iload_1         
    //  181  400:aload_0         
    //  182  401:getfield        #70  <Field Vector permConstraint>
    //  183  404:invokevirtual   #141 <Method int Vector.size()>
    //  184  407:icmplt          180
    //  185  410:return          
    }

    private void dealWithEquation()
    {
        for(int index = 0; index < userConstraint.size();)
    //*   0    0:iconst_0        
    //*   1    1:istore_1        
    //*   2    2:goto            214
        {
            Vector curPerms = ((candidateRole)((userNode)userConstraint.get(index)).getCandidateRoleSet().get(0)).getPermVect();
    //    3    5:aload_0         
    //    4    6:getfield        #68  <Field Vector userConstraint>
    //    5    9:iload_1         
    //    6   10:invokevirtual   #176 <Method Object Vector.get(int)>
    //    7   13:checkcast       #278 <Class CCRMimplement$userNode>
    //    8   16:invokevirtual   #284 <Method Vector CCRMimplement$userNode.getCandidateRoleSet()>
    //    9   19:iconst_0        
    //   10   20:invokevirtual   #176 <Method Object Vector.get(int)>
    //   11   23:checkcast       #286 <Class CCRMimplement$candidateRole>
    //   12   26:invokevirtual   #289 <Method Vector CCRMimplement$candidateRole.getPermVect()>
    //   13   29:astore_2        
            int equalIndex = -1;
    //   14   30:iconst_m1       
    //   15   31:istore_3        
            for(int jndex = 0; jndex < roleSet.size(); jndex++)
    //*  16   32:iconst_0        
    //*  17   33:istore          4
    //*  18   35:goto            74
            {
                Vector tempPerms = ((Role)roleSet.get(jndex)).getPerms();
    //   19   38:aload_0         
    //   20   39:getfield        #72  <Field Vector roleSet>
    //   21   42:iload           4
    //   22   44:invokevirtual   #176 <Method Object Vector.get(int)>
    //   23   47:checkcast       #178 <Class CCRMimplement$Role>
    //   24   50:invokevirtual   #182 <Method Vector CCRMimplement$Role.getPerms()>
    //   25   53:astore          5
                if(!isEqual(curPerms, tempPerms))
                    continue;
    //   26   55:aload_0         
    //   27   56:aload_2         
    //   28   57:aload           5
    //   29   59:invokespecial   #225 <Method boolean isEqual(Vector, Vector)>
    //   30   62:ifeq            71
                equalIndex = jndex;
    //   31   65:iload           4
    //   32   67:istore_3        
                break;
    //   33   68:goto            86
            }

    //   34   71:iinc            4  1
    //   35   74:iload           4
    //   36   76:aload_0         
    //   37   77:getfield        #72  <Field Vector roleSet>
    //   38   80:invokevirtual   #141 <Method int Vector.size()>
    //   39   83:icmplt          38
            if(equalIndex == -1)
    //*  40   86:iload_3         
    //*  41   87:iconst_m1       
    //*  42   88:icmpne          170
            {
                Role role = new Role();
    //   43   91:new             #178 <Class CCRMimplement$Role>
    //   44   94:dup             
    //   45   95:aload_0         
    //   46   96:invokespecial   #297 <Method void CCRMimplement$Role(CCRMimplement)>
    //   47   99:astore          4
                numberOfRoles++;
    //   48  101:getstatic       #46  <Field int numberOfRoles>
    //   49  104:iconst_1        
    //   50  105:iadd            
    //   51  106:putstatic       #46  <Field int numberOfRoles>
                role.setPerms(curPerms);
    //   52  109:aload           4
    //   53  111:aload_2         
    //   54  112:invokevirtual   #301 <Method void CCRMimplement$Role.setPerms(Vector)>
                Vector curUsers = new Vector();
    //   55  115:new             #61  <Class Vector>
    //   56  118:dup             
    //   57  119:invokespecial   #62  <Method void Vector()>
    //   58  122:astore          5
                curUsers.add(Integer.valueOf(((userNode)userConstraint.get(index)).getUserIndex()));
    //   59  124:aload           5
    //   60  126:aload_0         
    //   61  127:getfield        #68  <Field Vector userConstraint>
    //   62  130:iload_1         
    //   63  131:invokevirtual   #176 <Method Object Vector.get(int)>
    //   64  134:checkcast       #278 <Class CCRMimplement$userNode>
    //   65  137:invokevirtual   #304 <Method int CCRMimplement$userNode.getUserIndex()>
    //   66  140:invokestatic    #270 <Method Integer Integer.valueOf(int)>
    //   67  143:invokevirtual   #221 <Method boolean Vector.add(Object)>
    //   68  146:pop             
                role.setUsers(curUsers);
    //   69  147:aload           4
    //   70  149:aload           5
    //   71  151:invokevirtual   #307 <Method void CCRMimplement$Role.setUsers(Vector)>
                roleSet.add(role);
    //   72  154:aload_0         
    //   73  155:getfield        #72  <Field Vector roleSet>
    //   74  158:aload           4
    //   75  160:invokevirtual   #221 <Method boolean Vector.add(Object)>
    //   76  163:pop             
                index++;
    //   77  164:iinc            1  1
            } else
    //*  78  167:goto            214
            {
                ((Role)roleSet.get(equalIndex)).getUsers().add(Integer.valueOf(((userNode)userConstraint.get(index)).getUserIndex()));
    //   79  170:aload_0         
    //   80  171:getfield        #72  <Field Vector roleSet>
    //   81  174:iload_3         
    //   82  175:invokevirtual   #176 <Method Object Vector.get(int)>
    //   83  178:checkcast       #178 <Class CCRMimplement$Role>
    //   84  181:invokevirtual   #196 <Method Vector CCRMimplement$Role.getUsers()>
    //   85  184:aload_0         
    //   86  185:getfield        #68  <Field Vector userConstraint>
    //   87  188:iload_1         
    //   88  189:invokevirtual   #176 <Method Object Vector.get(int)>
    //   89  192:checkcast       #278 <Class CCRMimplement$userNode>
    //   90  195:invokevirtual   #304 <Method int CCRMimplement$userNode.getUserIndex()>
    //   91  198:invokestatic    #270 <Method Integer Integer.valueOf(int)>
    //   92  201:invokevirtual   #221 <Method boolean Vector.add(Object)>
    //   93  204:pop             
                userConstraint.remove(index);
    //   94  205:aload_0         
    //   95  206:getfield        #68  <Field Vector userConstraint>
    //   96  209:iload_1         
    //   97  210:invokevirtual   #232 <Method Object Vector.remove(int)>
    //   98  213:pop             
            }
        }

    //   99  214:iload_1         
    //  100  215:aload_0         
    //  101  216:getfield        #68  <Field Vector userConstraint>
    //  102  219:invokevirtual   #141 <Method int Vector.size()>
    //  103  222:icmplt          5
    //  104  225:return          
    }

    private boolean isEqual(Vector curPerms, Vector tempPerms)
    {
        return curPerms.equals(tempPerms);
    //    0    0:aload_1         
    //    1    1:aload_2         
    //    2    2:invokevirtual   #315 <Method boolean Vector.equals(Object)>
    //    3    5:ifeq            10
    //    4    8:iconst_1        
    //    5    9:ireturn         
    //    6   10:iconst_0        
    //    7   11:ireturn         
    }

    private void dealWithSubset(boolean havedone)
    {
        boolean subsetdone = true;
    //    0    0:iconst_1        
    //    1    1:istore_2        
    //*   2    2:goto            770
        while(subsetdone) 
        {
            subsetdone = false;
    //    3    5:iconst_0        
    //    4    6:istore_2        
            for(int index = 0; index < userConstraint.size(); index++)
    //*   5    7:iconst_0        
    //*   6    8:istore_3        
    //*   7    9:goto            759
            {
                Vector crs = ((userNode)userConstraint.get(index)).getCandidateRoleSet();
    //    8   12:aload_0         
    //    9   13:getfield        #68  <Field Vector userConstraint>
    //   10   16:iload_3         
    //   11   17:invokevirtual   #176 <Method Object Vector.get(int)>
    //   12   20:checkcast       #278 <Class CCRMimplement$userNode>
    //   13   23:invokevirtual   #284 <Method Vector CCRMimplement$userNode.getCandidateRoleSet()>
    //   14   26:astore          4
                for(int kndex = 0; kndex < crs.size(); kndex++)
    //*  15   28:iconst_0        
    //*  16   29:istore          5
    //*  17   31:goto            746
                {
                    Vector curPerms = ((candidateRole)crs.get(kndex)).getPermVect();
    //   18   34:aload           4
    //   19   36:iload           5
    //   20   38:invokevirtual   #176 <Method Object Vector.get(int)>
    //   21   41:checkcast       #286 <Class CCRMimplement$candidateRole>
    //   22   44:invokevirtual   #289 <Method Vector CCRMimplement$candidateRole.getPermVect()>
    //   23   47:astore          6
                    for(int jndex = 0; jndex < userConstraint.size() && jndex != index; jndex++)
    //*  24   49:iconst_0        
    //*  25   50:istore          7
    //*  26   52:goto            725
                    {
                        Vector tempCrs = ((userNode)userConstraint.get(jndex)).getCandidateRoleSet();
    //   27   55:aload_0         
    //   28   56:getfield        #68  <Field Vector userConstraint>
    //   29   59:iload           7
    //   30   61:invokevirtual   #176 <Method Object Vector.get(int)>
    //   31   64:checkcast       #278 <Class CCRMimplement$userNode>
    //   32   67:invokevirtual   #284 <Method Vector CCRMimplement$userNode.getCandidateRoleSet()>
    //   33   70:astore          8
                        for(int hndex = 0; hndex < tempCrs.size(); hndex++)
    //*  34   72:iconst_0        
    //*  35   73:istore          9
    //*  36   75:goto            712
                        {
                            Vector tempPerms = ((candidateRole)tempCrs.get(hndex)).getPermVect();
    //   37   78:aload           8
    //   38   80:iload           9
    //   39   82:invokevirtual   #176 <Method Object Vector.get(int)>
    //   40   85:checkcast       #286 <Class CCRMimplement$candidateRole>
    //   41   88:invokevirtual   #289 <Method Vector CCRMimplement$candidateRole.getPermVect()>
    //   42   91:astore          10
                            if(isSubSet(curPerms, tempPerms))
    //*  43   93:aload_0         
    //*  44   94:aload           6
    //*  45   96:aload           10
    //*  46   98:invokespecial   #318 <Method boolean isSubSet(Vector, Vector)>
    //*  47  101:ifeq            405
                            {
                                candidateRole crione = new candidateRole();
    //   48  104:new             #286 <Class CCRMimplement$candidateRole>
    //   49  107:dup             
    //   50  108:aload_0         
    //   51  109:invokespecial   #319 <Method void CCRMimplement$candidateRole(CCRMimplement)>
    //   52  112:astore          11
                                crione.setPermVect(curPerms);
    //   53  114:aload           11
    //   54  116:aload           6
    //   55  118:invokevirtual   #322 <Method void CCRMimplement$candidateRole.setPermVect(Vector)>
                                ((userNode)userConstraint.get(jndex)).getCandidateRoleSet().add(crione);
    //   56  121:aload_0         
    //   57  122:getfield        #68  <Field Vector userConstraint>
    //   58  125:iload           7
    //   59  127:invokevirtual   #176 <Method Object Vector.get(int)>
    //   60  130:checkcast       #278 <Class CCRMimplement$userNode>
    //   61  133:invokevirtual   #284 <Method Vector CCRMimplement$userNode.getCandidateRoleSet()>
    //   62  136:aload           11
    //   63  138:invokevirtual   #221 <Method boolean Vector.add(Object)>
    //   64  141:pop             
                                removalPermissionSet(((candidateRole)((userNode)userConstraint.get(jndex)).getCandidateRoleSet().get(hndex)).getPermVect(), curPerms);
    //   65  142:aload_0         
    //   66  143:aload_0         
    //   67  144:getfield        #68  <Field Vector userConstraint>
    //   68  147:iload           7
    //   69  149:invokevirtual   #176 <Method Object Vector.get(int)>
    //   70  152:checkcast       #278 <Class CCRMimplement$userNode>
    //   71  155:invokevirtual   #284 <Method Vector CCRMimplement$userNode.getCandidateRoleSet()>
    //   72  158:iload           9
    //   73  160:invokevirtual   #176 <Method Object Vector.get(int)>
    //   74  163:checkcast       #286 <Class CCRMimplement$candidateRole>
    //   75  166:invokevirtual   #289 <Method Vector CCRMimplement$candidateRole.getPermVect()>
    //   76  169:aload           6
    //   77  171:invokespecial   #325 <Method void removalPermissionSet(Vector, Vector)>
                                Vector onePermSet = ((candidateRole)((userNode)userConstraint.get(jndex)).getCandidateRoleSet().get(hndex)).getPermVect();
    //   78  174:aload_0         
    //   79  175:getfield        #68  <Field Vector userConstraint>
    //   80  178:iload           7
    //   81  180:invokevirtual   #176 <Method Object Vector.get(int)>
    //   82  183:checkcast       #278 <Class CCRMimplement$userNode>
    //   83  186:invokevirtual   #284 <Method Vector CCRMimplement$userNode.getCandidateRoleSet()>
    //   84  189:iload           9
    //   85  191:invokevirtual   #176 <Method Object Vector.get(int)>
    //   86  194:checkcast       #286 <Class CCRMimplement$candidateRole>
    //   87  197:invokevirtual   #289 <Method Vector CCRMimplement$candidateRole.getPermVect()>
    //   88  200:astore          12
                                int oneRoleIndex = findIndex(onePermSet);
    //   89  202:aload_0         
    //   90  203:aload           12
    //   91  205:invokespecial   #329 <Method int findIndex(Vector)>
    //   92  208:istore          13
                                removalPermissionSet(((Role)roleSet.get(oneRoleIndex)).getPerms(), curPerms);
    //   93  210:aload_0         
    //   94  211:aload_0         
    //   95  212:getfield        #72  <Field Vector roleSet>
    //   96  215:iload           13
    //   97  217:invokevirtual   #176 <Method Object Vector.get(int)>
    //   98  220:checkcast       #178 <Class CCRMimplement$Role>
    //   99  223:invokevirtual   #182 <Method Vector CCRMimplement$Role.getPerms()>
    //  100  226:aload           6
    //  101  228:invokespecial   #325 <Method void removalPermissionSet(Vector, Vector)>
                                int twoRoleIndex = findIndex(curPerms);
    //  102  231:aload_0         
    //  103  232:aload           6
    //  104  234:invokespecial   #329 <Method int findIndex(Vector)>
    //  105  237:istore          14
                                if(((Role)roleSet.get(oneRoleIndex)).getUsers().size() > 0 && ((Role)roleSet.get(twoRoleIndex)).getUsers().size() > 0 && isSubSet(((Role)roleSet.get(oneRoleIndex)).getUsers(), ((Role)roleSet.get(twoRoleIndex)).getUsers()))
    //* 106  239:aload_0         
    //* 107  240:getfield        #72  <Field Vector roleSet>
    //* 108  243:iload           13
    //* 109  245:invokevirtual   #176 <Method Object Vector.get(int)>
    //* 110  248:checkcast       #178 <Class CCRMimplement$Role>
    //* 111  251:invokevirtual   #196 <Method Vector CCRMimplement$Role.getUsers()>
    //* 112  254:invokevirtual   #141 <Method int Vector.size()>
    //* 113  257:ifle            352
    //* 114  260:aload_0         
    //* 115  261:getfield        #72  <Field Vector roleSet>
    //* 116  264:iload           14
    //* 117  266:invokevirtual   #176 <Method Object Vector.get(int)>
    //* 118  269:checkcast       #178 <Class CCRMimplement$Role>
    //* 119  272:invokevirtual   #196 <Method Vector CCRMimplement$Role.getUsers()>
    //* 120  275:invokevirtual   #141 <Method int Vector.size()>
    //* 121  278:ifle            352
    //* 122  281:aload_0         
    //* 123  282:aload_0         
    //* 124  283:getfield        #72  <Field Vector roleSet>
    //* 125  286:iload           13
    //* 126  288:invokevirtual   #176 <Method Object Vector.get(int)>
    //* 127  291:checkcast       #178 <Class CCRMimplement$Role>
    //* 128  294:invokevirtual   #196 <Method Vector CCRMimplement$Role.getUsers()>
    //* 129  297:aload_0         
    //* 130  298:getfield        #72  <Field Vector roleSet>
    //* 131  301:iload           14
    //* 132  303:invokevirtual   #176 <Method Object Vector.get(int)>
    //* 133  306:checkcast       #178 <Class CCRMimplement$Role>
    //* 134  309:invokevirtual   #196 <Method Vector CCRMimplement$Role.getUsers()>
    //* 135  312:invokespecial   #318 <Method boolean isSubSet(Vector, Vector)>
    //* 136  315:ifeq            352
                                    removalPermissionSet(((Role)roleSet.get(twoRoleIndex)).getUsers(), ((Role)roleSet.get(oneRoleIndex)).getUsers());
    //  137  318:aload_0         
    //  138  319:aload_0         
    //  139  320:getfield        #72  <Field Vector roleSet>
    //  140  323:iload           14
    //  141  325:invokevirtual   #176 <Method Object Vector.get(int)>
    //  142  328:checkcast       #178 <Class CCRMimplement$Role>
    //  143  331:invokevirtual   #196 <Method Vector CCRMimplement$Role.getUsers()>
    //  144  334:aload_0         
    //  145  335:getfield        #72  <Field Vector roleSet>
    //  146  338:iload           13
    //  147  340:invokevirtual   #176 <Method Object Vector.get(int)>
    //  148  343:checkcast       #178 <Class CCRMimplement$Role>
    //  149  346:invokevirtual   #196 <Method Vector CCRMimplement$Role.getUsers()>
    //  150  349:invokespecial   #325 <Method void removalPermissionSet(Vector, Vector)>
                                int oneConstraint = ((userNode)userConstraint.get(jndex)).getUconstraint();
    //  151  352:aload_0         
    //  152  353:getfield        #68  <Field Vector userConstraint>
    //  153  356:iload           7
    //  154  358:invokevirtual   #176 <Method Object Vector.get(int)>
    //  155  361:checkcast       #278 <Class CCRMimplement$userNode>
    //  156  364:invokevirtual   #281 <Method int CCRMimplement$userNode.getUconstraint()>
    //  157  367:istore          15
                                ((userNode)userConstraint.get(jndex)).setUconstraint(oneConstraint - 1);
    //  158  369:aload_0         
    //  159  370:getfield        #68  <Field Vector userConstraint>
    //  160  373:iload           7
    //  161  375:invokevirtual   #176 <Method Object Vector.get(int)>
    //  162  378:checkcast       #278 <Class CCRMimplement$userNode>
    //  163  381:iload           15
    //  164  383:iconst_1        
    //  165  384:isub            
    //  166  385:invokevirtual   #333 <Method void CCRMimplement$userNode.setUconstraint(int)>
                                havedone = true;
    //  167  388:iconst_1        
    //  168  389:istore_1        
                                subsetdone = true;
    //  169  390:iconst_1        
    //  170  391:istore_2        
                                rh++;
    //  171  392:aload_0         
    //  172  393:dup             
    //  173  394:getfield        #55  <Field int rh>
    //  174  397:iconst_1        
    //  175  398:iadd            
    //  176  399:putfield        #55  <Field int rh>
                            } else
    //* 177  402:goto            709
                            if(isSubSet(tempPerms, curPerms))
    //* 178  405:aload_0         
    //* 179  406:aload           10
    //* 180  408:aload           6
    //* 181  410:invokespecial   #318 <Method boolean isSubSet(Vector, Vector)>
    //* 182  413:ifeq            709
                            {
                                candidateRole crione = new candidateRole();
    //  183  416:new             #286 <Class CCRMimplement$candidateRole>
    //  184  419:dup             
    //  185  420:aload_0         
    //  186  421:invokespecial   #319 <Method void CCRMimplement$candidateRole(CCRMimplement)>
    //  187  424:astore          11
                                crione.setPermVect(tempPerms);
    //  188  426:aload           11
    //  189  428:aload           10
    //  190  430:invokevirtual   #322 <Method void CCRMimplement$candidateRole.setPermVect(Vector)>
                                ((userNode)userConstraint.get(index)).getCandidateRoleSet().add(crione);
    //  191  433:aload_0         
    //  192  434:getfield        #68  <Field Vector userConstraint>
    //  193  437:iload_3         
    //  194  438:invokevirtual   #176 <Method Object Vector.get(int)>
    //  195  441:checkcast       #278 <Class CCRMimplement$userNode>
    //  196  444:invokevirtual   #284 <Method Vector CCRMimplement$userNode.getCandidateRoleSet()>
    //  197  447:aload           11
    //  198  449:invokevirtual   #221 <Method boolean Vector.add(Object)>
    //  199  452:pop             
                                removalPermissionSet(((candidateRole)((userNode)userConstraint.get(index)).getCandidateRoleSet().get(kndex)).getPermVect(), tempPerms);
    //  200  453:aload_0         
    //  201  454:aload_0         
    //  202  455:getfield        #68  <Field Vector userConstraint>
    //  203  458:iload_3         
    //  204  459:invokevirtual   #176 <Method Object Vector.get(int)>
    //  205  462:checkcast       #278 <Class CCRMimplement$userNode>
    //  206  465:invokevirtual   #284 <Method Vector CCRMimplement$userNode.getCandidateRoleSet()>
    //  207  468:iload           5
    //  208  470:invokevirtual   #176 <Method Object Vector.get(int)>
    //  209  473:checkcast       #286 <Class CCRMimplement$candidateRole>
    //  210  476:invokevirtual   #289 <Method Vector CCRMimplement$candidateRole.getPermVect()>
    //  211  479:aload           10
    //  212  481:invokespecial   #325 <Method void removalPermissionSet(Vector, Vector)>
                                Vector twoPermSet = ((candidateRole)((userNode)userConstraint.get(index)).getCandidateRoleSet().get(kndex)).getPermVect();
    //  213  484:aload_0         
    //  214  485:getfield        #68  <Field Vector userConstraint>
    //  215  488:iload_3         
    //  216  489:invokevirtual   #176 <Method Object Vector.get(int)>
    //  217  492:checkcast       #278 <Class CCRMimplement$userNode>
    //  218  495:invokevirtual   #284 <Method Vector CCRMimplement$userNode.getCandidateRoleSet()>
    //  219  498:iload           5
    //  220  500:invokevirtual   #176 <Method Object Vector.get(int)>
    //  221  503:checkcast       #286 <Class CCRMimplement$candidateRole>
    //  222  506:invokevirtual   #289 <Method Vector CCRMimplement$candidateRole.getPermVect()>
    //  223  509:astore          12
                                int twoRoleIndex = findIndex(twoPermSet);
    //  224  511:aload_0         
    //  225  512:aload           12
    //  226  514:invokespecial   #329 <Method int findIndex(Vector)>
    //  227  517:istore          13
                                removalPermissionSet(((Role)roleSet.get(twoRoleIndex)).getPerms(), tempPerms);
    //  228  519:aload_0         
    //  229  520:aload_0         
    //  230  521:getfield        #72  <Field Vector roleSet>
    //  231  524:iload           13
    //  232  526:invokevirtual   #176 <Method Object Vector.get(int)>
    //  233  529:checkcast       #178 <Class CCRMimplement$Role>
    //  234  532:invokevirtual   #182 <Method Vector CCRMimplement$Role.getPerms()>
    //  235  535:aload           10
    //  236  537:invokespecial   #325 <Method void removalPermissionSet(Vector, Vector)>
                                int oneRoleIndex = findIndex(tempPerms);
    //  237  540:aload_0         
    //  238  541:aload           10
    //  239  543:invokespecial   #329 <Method int findIndex(Vector)>
    //  240  546:istore          14
                                if(((Role)roleSet.get(oneRoleIndex)).getUsers().size() > 0 && ((Role)roleSet.get(twoRoleIndex)).getUsers().size() > 0 && isSubSet(((Role)roleSet.get(twoRoleIndex)).getUsers(), ((Role)roleSet.get(oneRoleIndex)).getUsers()))
    //* 241  548:aload_0         
    //* 242  549:getfield        #72  <Field Vector roleSet>
    //* 243  552:iload           14
    //* 244  554:invokevirtual   #176 <Method Object Vector.get(int)>
    //* 245  557:checkcast       #178 <Class CCRMimplement$Role>
    //* 246  560:invokevirtual   #196 <Method Vector CCRMimplement$Role.getUsers()>
    //* 247  563:invokevirtual   #141 <Method int Vector.size()>
    //* 248  566:ifle            661
    //* 249  569:aload_0         
    //* 250  570:getfield        #72  <Field Vector roleSet>
    //* 251  573:iload           13
    //* 252  575:invokevirtual   #176 <Method Object Vector.get(int)>
    //* 253  578:checkcast       #178 <Class CCRMimplement$Role>
    //* 254  581:invokevirtual   #196 <Method Vector CCRMimplement$Role.getUsers()>
    //* 255  584:invokevirtual   #141 <Method int Vector.size()>
    //* 256  587:ifle            661
    //* 257  590:aload_0         
    //* 258  591:aload_0         
    //* 259  592:getfield        #72  <Field Vector roleSet>
    //* 260  595:iload           13
    //* 261  597:invokevirtual   #176 <Method Object Vector.get(int)>
    //* 262  600:checkcast       #178 <Class CCRMimplement$Role>
    //* 263  603:invokevirtual   #196 <Method Vector CCRMimplement$Role.getUsers()>
    //* 264  606:aload_0         
    //* 265  607:getfield        #72  <Field Vector roleSet>
    //* 266  610:iload           14
    //* 267  612:invokevirtual   #176 <Method Object Vector.get(int)>
    //* 268  615:checkcast       #178 <Class CCRMimplement$Role>
    //* 269  618:invokevirtual   #196 <Method Vector CCRMimplement$Role.getUsers()>
    //* 270  621:invokespecial   #318 <Method boolean isSubSet(Vector, Vector)>
    //* 271  624:ifeq            661
                                    removalPermissionSet(((Role)roleSet.get(oneRoleIndex)).getUsers(), ((Role)roleSet.get(twoRoleIndex)).getUsers());
    //  272  627:aload_0         
    //  273  628:aload_0         
    //  274  629:getfield        #72  <Field Vector roleSet>
    //  275  632:iload           14
    //  276  634:invokevirtual   #176 <Method Object Vector.get(int)>
    //  277  637:checkcast       #178 <Class CCRMimplement$Role>
    //  278  640:invokevirtual   #196 <Method Vector CCRMimplement$Role.getUsers()>
    //  279  643:aload_0         
    //  280  644:getfield        #72  <Field Vector roleSet>
    //  281  647:iload           13
    //  282  649:invokevirtual   #176 <Method Object Vector.get(int)>
    //  283  652:checkcast       #178 <Class CCRMimplement$Role>
    //  284  655:invokevirtual   #196 <Method Vector CCRMimplement$Role.getUsers()>
    //  285  658:invokespecial   #325 <Method void removalPermissionSet(Vector, Vector)>
                                int oneConstraint = ((userNode)userConstraint.get(index)).getUconstraint();
    //  286  661:aload_0         
    //  287  662:getfield        #68  <Field Vector userConstraint>
    //  288  665:iload_3         
    //  289  666:invokevirtual   #176 <Method Object Vector.get(int)>
    //  290  669:checkcast       #278 <Class CCRMimplement$userNode>
    //  291  672:invokevirtual   #281 <Method int CCRMimplement$userNode.getUconstraint()>
    //  292  675:istore          15
                                ((userNode)userConstraint.get(index)).setUconstraint(oneConstraint - 1);
    //  293  677:aload_0         
    //  294  678:getfield        #68  <Field Vector userConstraint>
    //  295  681:iload_3         
    //  296  682:invokevirtual   #176 <Method Object Vector.get(int)>
    //  297  685:checkcast       #278 <Class CCRMimplement$userNode>
    //  298  688:iload           15
    //  299  690:iconst_1        
    //  300  691:isub            
    //  301  692:invokevirtual   #333 <Method void CCRMimplement$userNode.setUconstraint(int)>
                                havedone = true;
    //  302  695:iconst_1        
    //  303  696:istore_1        
                                subsetdone = true;
    //  304  697:iconst_1        
    //  305  698:istore_2        
                                rh++;
    //  306  699:aload_0         
    //  307  700:dup             
    //  308  701:getfield        #55  <Field int rh>
    //  309  704:iconst_1        
    //  310  705:iadd            
    //  311  706:putfield        #55  <Field int rh>
                            }
                        }

    //  312  709:iinc            9  1
    //  313  712:iload           9
    //  314  714:aload           8
    //  315  716:invokevirtual   #141 <Method int Vector.size()>
    //  316  719:icmplt          78
                    }

    //  317  722:iinc            7  1
    //  318  725:iload           7
    //  319  727:aload_0         
    //  320  728:getfield        #68  <Field Vector userConstraint>
    //  321  731:invokevirtual   #141 <Method int Vector.size()>
    //  322  734:icmpge          743
    //  323  737:iload           7
    //  324  739:iload_3         
    //  325  740:icmpne          55
                }

    //  326  743:iinc            5  1
    //  327  746:iload           5
    //  328  748:aload           4
    //  329  750:invokevirtual   #141 <Method int Vector.size()>
    //  330  753:icmplt          34
            }

    //  331  756:iinc            3  1
    //  332  759:iload_3         
    //  333  760:aload_0         
    //  334  761:getfield        #68  <Field Vector userConstraint>
    //  335  764:invokevirtual   #141 <Method int Vector.size()>
    //  336  767:icmplt          12
        }
    //  337  770:iload_2         
    //  338  771:ifne            5
    //  339  774:return          
    }

    private boolean isSubSet(Vector curPerms, Vector tempPerms)
    {
        return tempPerms.containsAll(curPerms) && !curPerms.containsAll(tempPerms);
    //    0    0:aload_2         
    //    1    1:aload_1         
    //    2    2:invokevirtual   #347 <Method boolean Vector.containsAll(java.util.Collection)>
    //    3    5:ifeq            18
    //    4    8:aload_1         
    //    5    9:aload_2         
    //    6   10:invokevirtual   #347 <Method boolean Vector.containsAll(java.util.Collection)>
    //    7   13:ifne            18
    //    8   16:iconst_1        
    //    9   17:ireturn         
    //   10   18:iconst_0        
    //   11   19:ireturn         
    }

    private void dealWithCross(boolean havedone)
    {
        updateConstraint();
    //    0    0:aload_0         
    //    1    1:invokespecial   #350 <Method void updateConstraint()>
        int one = 0x7fffffff;
    //    2    4:ldc2            #351 <Int 0x7fffffff>
    //    3    7:istore_2        
        int two = 0x7fffffff;
    //    4    8:ldc2            #351 <Int 0x7fffffff>
    //    5   11:istore_3        
        int three = 0x7fffffff;
    //    6   12:ldc2            #351 <Int 0x7fffffff>
    //    7   15:istore          4
        int four = 0x7fffffff;
    //    8   17:ldc2            #351 <Int 0x7fffffff>
    //    9   20:istore          5
        int maxSize = 0;
    //   10   22:iconst_0        
    //   11   23:istore          6
        Vector commonPerms = new Vector();
    //   12   25:new             #61  <Class Vector>
    //   13   28:dup             
    //   14   29:invokespecial   #62  <Method void Vector()>
    //   15   32:astore          7
        for(int index = 0; index < userConstraint.size(); index++)
    //*  16   34:iconst_0        
    //*  17   35:istore          8
    //*  18   37:goto            228
        {
            Vector crs = ((userNode)userConstraint.get(index)).getCandidateRoleSet();
    //   19   40:aload_0         
    //   20   41:getfield        #68  <Field Vector userConstraint>
    //   21   44:iload           8
    //   22   46:invokevirtual   #176 <Method Object Vector.get(int)>
    //   23   49:checkcast       #278 <Class CCRMimplement$userNode>
    //   24   52:invokevirtual   #284 <Method Vector CCRMimplement$userNode.getCandidateRoleSet()>
    //   25   55:astore          9
            for(int kndex = 0; kndex < crs.size(); kndex++)
    //*  26   57:iconst_0        
    //*  27   58:istore          10
    //*  28   60:goto            215
            {
                Vector curPerms = ((candidateRole)crs.get(kndex)).getPermVect();
    //   29   63:aload           9
    //   30   65:iload           10
    //   31   67:invokevirtual   #176 <Method Object Vector.get(int)>
    //   32   70:checkcast       #286 <Class CCRMimplement$candidateRole>
    //   33   73:invokevirtual   #289 <Method Vector CCRMimplement$candidateRole.getPermVect()>
    //   34   76:astore          11
                for(int jndex = 0; jndex < userConstraint.size() && jndex != index; jndex++)
    //*  35   78:iconst_0        
    //*  36   79:istore          12
    //*  37   81:goto            193
                {
                    Vector tempCrs = ((userNode)userConstraint.get(jndex)).getCandidateRoleSet();
    //   38   84:aload_0         
    //   39   85:getfield        #68  <Field Vector userConstraint>
    //   40   88:iload           12
    //   41   90:invokevirtual   #176 <Method Object Vector.get(int)>
    //   42   93:checkcast       #278 <Class CCRMimplement$userNode>
    //   43   96:invokevirtual   #284 <Method Vector CCRMimplement$userNode.getCandidateRoleSet()>
    //   44   99:astore          13
                    for(int hndex = 0; hndex < tempCrs.size(); hndex++)
    //*  45  101:iconst_0        
    //*  46  102:istore          14
    //*  47  104:goto            180
                    {
                        Vector tempPerms = ((candidateRole)tempCrs.get(hndex)).getPermVect();
    //   48  107:aload           13
    //   49  109:iload           14
    //   50  111:invokevirtual   #176 <Method Object Vector.get(int)>
    //   51  114:checkcast       #286 <Class CCRMimplement$candidateRole>
    //   52  117:invokevirtual   #289 <Method Vector CCRMimplement$candidateRole.getPermVect()>
    //   53  120:astore          15
                        if(!isEqual(curPerms, tempPerms))
    //*  54  122:aload_0         
    //*  55  123:aload           11
    //*  56  125:aload           15
    //*  57  127:invokespecial   #225 <Method boolean isEqual(Vector, Vector)>
    //*  58  130:ifne            177
                        {
                            commonPerms = getCommonPermissions(curPerms, tempPerms);
    //   59  133:aload_0         
    //   60  134:aload           11
    //   61  136:aload           15
    //   62  138:invokespecial   #355 <Method Vector getCommonPermissions(Vector, Vector)>
    //   63  141:astore          7
                            if(commonPerms.size() > maxSize)
    //*  64  143:aload           7
    //*  65  145:invokevirtual   #141 <Method int Vector.size()>
    //*  66  148:iload           6
    //*  67  150:icmple          177
                            {
                                maxSize = commonPerms.size();
    //   68  153:aload           7
    //   69  155:invokevirtual   #141 <Method int Vector.size()>
    //   70  158:istore          6
                                one = index;
    //   71  160:iload           8
    //   72  162:istore_2        
                                two = kndex;
    //   73  163:iload           10
    //   74  165:istore_3        
                                three = jndex;
    //   75  166:iload           12
    //   76  168:istore          4
                                four = hndex;
    //   77  170:iload           14
    //   78  172:istore          5
                            }
                        }
                    }

    //   79  174:goto            177
    //   80  177:iinc            14  1
    //   81  180:iload           14
    //   82  182:aload           13
    //   83  184:invokevirtual   #141 <Method int Vector.size()>
    //   84  187:icmplt          107
                }

    //   85  190:iinc            12  1
    //   86  193:iload           12
    //   87  195:aload_0         
    //   88  196:getfield        #68  <Field Vector userConstraint>
    //   89  199:invokevirtual   #141 <Method int Vector.size()>
    //   90  202:icmpge          212
    //   91  205:iload           12
    //   92  207:iload           8
    //   93  209:icmpne          84
            }

    //   94  212:iinc            10  1
    //   95  215:iload           10
    //   96  217:aload           9
    //   97  219:invokevirtual   #141 <Method int Vector.size()>
    //   98  222:icmplt          63
        }

    //   99  225:iinc            8  1
    //  100  228:iload           8
    //  101  230:aload_0         
    //  102  231:getfield        #68  <Field Vector userConstraint>
    //  103  234:invokevirtual   #141 <Method int Vector.size()>
    //  104  237:icmplt          40
        if(maxSize >= 2)
    //* 105  240:iload           6
    //* 106  242:iconst_2        
    //* 107  243:icmplt          698
        {
            commonPerms = getCommonPermissions(((candidateRole)((userNode)userConstraint.get(one)).getCandidateRoleSet().get(two)).getPermVect(), ((candidateRole)((userNode)userConstraint.get(three)).getCandidateRoleSet().get(four)).getPermVect());
    //  108  246:aload_0         
    //  109  247:aload_0         
    //  110  248:getfield        #68  <Field Vector userConstraint>
    //  111  251:iload_2         
    //  112  252:invokevirtual   #176 <Method Object Vector.get(int)>
    //  113  255:checkcast       #278 <Class CCRMimplement$userNode>
    //  114  258:invokevirtual   #284 <Method Vector CCRMimplement$userNode.getCandidateRoleSet()>
    //  115  261:iload_3         
    //  116  262:invokevirtual   #176 <Method Object Vector.get(int)>
    //  117  265:checkcast       #286 <Class CCRMimplement$candidateRole>
    //  118  268:invokevirtual   #289 <Method Vector CCRMimplement$candidateRole.getPermVect()>
    //  119  271:aload_0         
    //  120  272:getfield        #68  <Field Vector userConstraint>
    //  121  275:iload           4
    //  122  277:invokevirtual   #176 <Method Object Vector.get(int)>
    //  123  280:checkcast       #278 <Class CCRMimplement$userNode>
    //  124  283:invokevirtual   #284 <Method Vector CCRMimplement$userNode.getCandidateRoleSet()>
    //  125  286:iload           5
    //  126  288:invokevirtual   #176 <Method Object Vector.get(int)>
    //  127  291:checkcast       #286 <Class CCRMimplement$candidateRole>
    //  128  294:invokevirtual   #289 <Method Vector CCRMimplement$candidateRole.getPermVect()>
    //  129  297:invokespecial   #355 <Method Vector getCommonPermissions(Vector, Vector)>
    //  130  300:astore          7
            Vector curUsers = new Vector();
    //  131  302:new             #61  <Class Vector>
    //  132  305:dup             
    //  133  306:invokespecial   #62  <Method void Vector()>
    //  134  309:astore          8
            int numIndex = findIndex(commonPerms);
    //  135  311:aload_0         
    //  136  312:aload           7
    //  137  314:invokespecial   #329 <Method int findIndex(Vector)>
    //  138  317:istore          9
            if(numIndex == -1)
    //* 139  319:iload           9
    //* 140  321:iconst_m1       
    //* 141  322:icmpne          367
            {
                Role role = new Role();
    //  142  325:new             #178 <Class CCRMimplement$Role>
    //  143  328:dup             
    //  144  329:aload_0         
    //  145  330:invokespecial   #297 <Method void CCRMimplement$Role(CCRMimplement)>
    //  146  333:astore          10
                numberOfRoles++;
    //  147  335:getstatic       #46  <Field int numberOfRoles>
    //  148  338:iconst_1        
    //  149  339:iadd            
    //  150  340:putstatic       #46  <Field int numberOfRoles>
                role.setPerms(commonPerms);
    //  151  343:aload           10
    //  152  345:aload           7
    //  153  347:invokevirtual   #301 <Method void CCRMimplement$Role.setPerms(Vector)>
                role.setUsers(curUsers);
    //  154  350:aload           10
    //  155  352:aload           8
    //  156  354:invokevirtual   #307 <Method void CCRMimplement$Role.setUsers(Vector)>
                roleSet.add(role);
    //  157  357:aload_0         
    //  158  358:getfield        #72  <Field Vector roleSet>
    //  159  361:aload           10
    //  160  363:invokevirtual   #221 <Method boolean Vector.add(Object)>
    //  161  366:pop             
            }
            havedone = true;
    //  162  367:iconst_1        
    //  163  368:istore_1        
            rh += 2;
    //  164  369:aload_0         
    //  165  370:dup             
    //  166  371:getfield        #55  <Field int rh>
    //  167  374:iconst_2        
    //  168  375:iadd            
    //  169  376:putfield        #55  <Field int rh>
            int oneConstraint = ((userNode)userConstraint.get(one)).getUconstraint();
    //  170  379:aload_0         
    //  171  380:getfield        #68  <Field Vector userConstraint>
    //  172  383:iload_2         
    //  173  384:invokevirtual   #176 <Method Object Vector.get(int)>
    //  174  387:checkcast       #278 <Class CCRMimplement$userNode>
    //  175  390:invokevirtual   #281 <Method int CCRMimplement$userNode.getUconstraint()>
    //  176  393:istore          10
            ((userNode)userConstraint.get(one)).setUconstraint(oneConstraint - 1);
    //  177  395:aload_0         
    //  178  396:getfield        #68  <Field Vector userConstraint>
    //  179  399:iload_2         
    //  180  400:invokevirtual   #176 <Method Object Vector.get(int)>
    //  181  403:checkcast       #278 <Class CCRMimplement$userNode>
    //  182  406:iload           10
    //  183  408:iconst_1        
    //  184  409:isub            
    //  185  410:invokevirtual   #333 <Method void CCRMimplement$userNode.setUconstraint(int)>
            Vector onePermSet = ((candidateRole)((userNode)userConstraint.get(one)).getCandidateRoleSet().get(two)).getPermVect();
    //  186  413:aload_0         
    //  187  414:getfield        #68  <Field Vector userConstraint>
    //  188  417:iload_2         
    //  189  418:invokevirtual   #176 <Method Object Vector.get(int)>
    //  190  421:checkcast       #278 <Class CCRMimplement$userNode>
    //  191  424:invokevirtual   #284 <Method Vector CCRMimplement$userNode.getCandidateRoleSet()>
    //  192  427:iload_3         
    //  193  428:invokevirtual   #176 <Method Object Vector.get(int)>
    //  194  431:checkcast       #286 <Class CCRMimplement$candidateRole>
    //  195  434:invokevirtual   #289 <Method Vector CCRMimplement$candidateRole.getPermVect()>
    //  196  437:astore          11
            int oneRoleIndex = findIndex(onePermSet);
    //  197  439:aload_0         
    //  198  440:aload           11
    //  199  442:invokespecial   #329 <Method int findIndex(Vector)>
    //  200  445:istore          12
            removalPermissionSet(((Role)roleSet.get(oneRoleIndex)).getPerms(), commonPerms);
    //  201  447:aload_0         
    //  202  448:aload_0         
    //  203  449:getfield        #72  <Field Vector roleSet>
    //  204  452:iload           12
    //  205  454:invokevirtual   #176 <Method Object Vector.get(int)>
    //  206  457:checkcast       #178 <Class CCRMimplement$Role>
    //  207  460:invokevirtual   #182 <Method Vector CCRMimplement$Role.getPerms()>
    //  208  463:aload           7
    //  209  465:invokespecial   #325 <Method void removalPermissionSet(Vector, Vector)>
            removalPermissionSet(((candidateRole)((userNode)userConstraint.get(one)).getCandidateRoleSet().get(two)).getPermVect(), commonPerms);
    //  210  468:aload_0         
    //  211  469:aload_0         
    //  212  470:getfield        #68  <Field Vector userConstraint>
    //  213  473:iload_2         
    //  214  474:invokevirtual   #176 <Method Object Vector.get(int)>
    //  215  477:checkcast       #278 <Class CCRMimplement$userNode>
    //  216  480:invokevirtual   #284 <Method Vector CCRMimplement$userNode.getCandidateRoleSet()>
    //  217  483:iload_3         
    //  218  484:invokevirtual   #176 <Method Object Vector.get(int)>
    //  219  487:checkcast       #286 <Class CCRMimplement$candidateRole>
    //  220  490:invokevirtual   #289 <Method Vector CCRMimplement$candidateRole.getPermVect()>
    //  221  493:aload           7
    //  222  495:invokespecial   #325 <Method void removalPermissionSet(Vector, Vector)>
            candidateRole crione = new candidateRole();
    //  223  498:new             #286 <Class CCRMimplement$candidateRole>
    //  224  501:dup             
    //  225  502:aload_0         
    //  226  503:invokespecial   #319 <Method void CCRMimplement$candidateRole(CCRMimplement)>
    //  227  506:astore          13
            crione.setPermVect(commonPerms);
    //  228  508:aload           13
    //  229  510:aload           7
    //  230  512:invokevirtual   #322 <Method void CCRMimplement$candidateRole.setPermVect(Vector)>
            ((userNode)userConstraint.get(one)).getCandidateRoleSet().add(crione);
    //  231  515:aload_0         
    //  232  516:getfield        #68  <Field Vector userConstraint>
    //  233  519:iload_2         
    //  234  520:invokevirtual   #176 <Method Object Vector.get(int)>
    //  235  523:checkcast       #278 <Class CCRMimplement$userNode>
    //  236  526:invokevirtual   #284 <Method Vector CCRMimplement$userNode.getCandidateRoleSet()>
    //  237  529:aload           13
    //  238  531:invokevirtual   #221 <Method boolean Vector.add(Object)>
    //  239  534:pop             
            int threeConstraint = ((userNode)userConstraint.get(three)).getUconstraint();
    //  240  535:aload_0         
    //  241  536:getfield        #68  <Field Vector userConstraint>
    //  242  539:iload           4
    //  243  541:invokevirtual   #176 <Method Object Vector.get(int)>
    //  244  544:checkcast       #278 <Class CCRMimplement$userNode>
    //  245  547:invokevirtual   #281 <Method int CCRMimplement$userNode.getUconstraint()>
    //  246  550:istore          14
            ((userNode)userConstraint.get(three)).setUconstraint(threeConstraint - 1);
    //  247  552:aload_0         
    //  248  553:getfield        #68  <Field Vector userConstraint>
    //  249  556:iload           4
    //  250  558:invokevirtual   #176 <Method Object Vector.get(int)>
    //  251  561:checkcast       #278 <Class CCRMimplement$userNode>
    //  252  564:iload           14
    //  253  566:iconst_1        
    //  254  567:isub            
    //  255  568:invokevirtual   #333 <Method void CCRMimplement$userNode.setUconstraint(int)>
            Vector twoPermSet = ((candidateRole)((userNode)userConstraint.get(three)).getCandidateRoleSet().get(four)).getPermVect();
    //  256  571:aload_0         
    //  257  572:getfield        #68  <Field Vector userConstraint>
    //  258  575:iload           4
    //  259  577:invokevirtual   #176 <Method Object Vector.get(int)>
    //  260  580:checkcast       #278 <Class CCRMimplement$userNode>
    //  261  583:invokevirtual   #284 <Method Vector CCRMimplement$userNode.getCandidateRoleSet()>
    //  262  586:iload           5
    //  263  588:invokevirtual   #176 <Method Object Vector.get(int)>
    //  264  591:checkcast       #286 <Class CCRMimplement$candidateRole>
    //  265  594:invokevirtual   #289 <Method Vector CCRMimplement$candidateRole.getPermVect()>
    //  266  597:astore          15
            int twoRoleIndex = findIndex(twoPermSet);
    //  267  599:aload_0         
    //  268  600:aload           15
    //  269  602:invokespecial   #329 <Method int findIndex(Vector)>
    //  270  605:istore          16
            removalPermissionSet(((Role)roleSet.get(twoRoleIndex)).getPerms(), commonPerms);
    //  271  607:aload_0         
    //  272  608:aload_0         
    //  273  609:getfield        #72  <Field Vector roleSet>
    //  274  612:iload           16
    //  275  614:invokevirtual   #176 <Method Object Vector.get(int)>
    //  276  617:checkcast       #178 <Class CCRMimplement$Role>
    //  277  620:invokevirtual   #182 <Method Vector CCRMimplement$Role.getPerms()>
    //  278  623:aload           7
    //  279  625:invokespecial   #325 <Method void removalPermissionSet(Vector, Vector)>
            removalPermissionSet(((candidateRole)((userNode)userConstraint.get(three)).getCandidateRoleSet().get(four)).getPermVect(), commonPerms);
    //  280  628:aload_0         
    //  281  629:aload_0         
    //  282  630:getfield        #68  <Field Vector userConstraint>
    //  283  633:iload           4
    //  284  635:invokevirtual   #176 <Method Object Vector.get(int)>
    //  285  638:checkcast       #278 <Class CCRMimplement$userNode>
    //  286  641:invokevirtual   #284 <Method Vector CCRMimplement$userNode.getCandidateRoleSet()>
    //  287  644:iload           5
    //  288  646:invokevirtual   #176 <Method Object Vector.get(int)>
    //  289  649:checkcast       #286 <Class CCRMimplement$candidateRole>
    //  290  652:invokevirtual   #289 <Method Vector CCRMimplement$candidateRole.getPermVect()>
    //  291  655:aload           7
    //  292  657:invokespecial   #325 <Method void removalPermissionSet(Vector, Vector)>
            candidateRole critwo = new candidateRole();
    //  293  660:new             #286 <Class CCRMimplement$candidateRole>
    //  294  663:dup             
    //  295  664:aload_0         
    //  296  665:invokespecial   #319 <Method void CCRMimplement$candidateRole(CCRMimplement)>
    //  297  668:astore          17
            critwo.setPermVect(commonPerms);
    //  298  670:aload           17
    //  299  672:aload           7
    //  300  674:invokevirtual   #322 <Method void CCRMimplement$candidateRole.setPermVect(Vector)>
            ((userNode)userConstraint.get(three)).getCandidateRoleSet().add(critwo);
    //  301  677:aload_0         
    //  302  678:getfield        #68  <Field Vector userConstraint>
    //  303  681:iload           4
    //  304  683:invokevirtual   #176 <Method Object Vector.get(int)>
    //  305  686:checkcast       #278 <Class CCRMimplement$userNode>
    //  306  689:invokevirtual   #284 <Method Vector CCRMimplement$userNode.getCandidateRoleSet()>
    //  307  692:aload           17
    //  308  694:invokevirtual   #221 <Method boolean Vector.add(Object)>
    //  309  697:pop             
        }
        dealWith1Constraint();
    //  310  698:aload_0         
    //  311  699:invokespecial   #244 <Method void dealWith1Constraint()>
    //  312  702:return          
    }

    private void addElements(Vector curUsers, Vector users)
    {
        for(int index = 0; index < users.size(); index++)
    //*   0    0:iconst_0        
    //*   1    1:istore_3        
    //*   2    2:goto            33
            if(!curUsers.contains(users.get(index)))
    //*   3    5:aload_1         
    //*   4    6:aload_2         
    //*   5    7:iload_3         
    //*   6    8:invokevirtual   #176 <Method Object Vector.get(int)>
    //*   7   11:invokevirtual   #273 <Method boolean Vector.contains(Object)>
    //*   8   14:ifne            30
                curUsers.add((Integer)users.get(index));
    //    9   17:aload_1         
    //   10   18:aload_2         
    //   11   19:iload_3         
    //   12   20:invokevirtual   #176 <Method Object Vector.get(int)>
    //   13   23:checkcast       #184 <Class Integer>
    //   14   26:invokevirtual   #221 <Method boolean Vector.add(Object)>
    //   15   29:pop             

    //   16   30:iinc            3  1
    //   17   33:iload_3         
    //   18   34:aload_2         
    //   19   35:invokevirtual   #141 <Method int Vector.size()>
    //   20   38:icmplt          5
    //   21   41:return          
    }

    private int findIndex(Vector commonPerms)
    {
        for(int index = 0; index < roleSet.size(); index++)
    //*   0    0:iconst_0        
    //*   1    1:istore_2        
    //*   2    2:goto            32
            if(isEqual(((Role)roleSet.get(index)).getPerms(), commonPerms))
    //*   3    5:aload_0         
    //*   4    6:aload_0         
    //*   5    7:getfield        #72  <Field Vector roleSet>
    //*   6   10:iload_2         
    //*   7   11:invokevirtual   #176 <Method Object Vector.get(int)>
    //*   8   14:checkcast       #178 <Class CCRMimplement$Role>
    //*   9   17:invokevirtual   #182 <Method Vector CCRMimplement$Role.getPerms()>
    //*  10   20:aload_1         
    //*  11   21:invokespecial   #225 <Method boolean isEqual(Vector, Vector)>
    //*  12   24:ifeq            29
                return index;
    //   13   27:iload_2         
    //   14   28:ireturn         

    //   15   29:iinc            2  1
    //   16   32:iload_2         
    //   17   33:aload_0         
    //   18   34:getfield        #72  <Field Vector roleSet>
    //   19   37:invokevirtual   #141 <Method int Vector.size()>
    //   20   40:icmplt          5
        return -1;
    //   21   43:iconst_m1       
    //   22   44:ireturn         
    }

    private void removalPermissionSet(Vector permVect, Vector commonPerms)
    {
        for(int index = 0; index < permVect.size();)
    //*   0    0:iconst_0        
    //*   1    1:istore_3        
    //*   2    2:goto            29
            if(commonPerms.contains(permVect.get(index)))
    //*   3    5:aload_2         
    //*   4    6:aload_1         
    //*   5    7:iload_3         
    //*   6    8:invokevirtual   #176 <Method Object Vector.get(int)>
    //*   7   11:invokevirtual   #273 <Method boolean Vector.contains(Object)>
    //*   8   14:ifeq            26
                permVect.remove(index);
    //    9   17:aload_1         
    //   10   18:iload_3         
    //   11   19:invokevirtual   #232 <Method Object Vector.remove(int)>
    //   12   22:pop             
            else
    //*  13   23:goto            29
                index++;
    //   14   26:iinc            3  1

    //   15   29:iload_3         
    //   16   30:aload_1         
    //   17   31:invokevirtual   #141 <Method int Vector.size()>
    //   18   34:icmplt          5
    //   19   37:return          
    }

    private Vector getCommonPermissions(Vector curPerms, Vector tempPerms)
    {
        Vector commonPerms = new Vector();
    //    0    0:new             #61  <Class Vector>
    //    1    3:dup             
    //    2    4:invokespecial   #62  <Method void Vector()>
    //    3    7:astore_3        
        for(int index = 0; index < curPerms.size(); index++)
    //*   4    8:iconst_0        
    //*   5    9:istore          4
    //*   6   11:goto            44
            if(tempPerms.contains(curPerms.get(index)))
    //*   7   14:aload_2         
    //*   8   15:aload_1         
    //*   9   16:iload           4
    //*  10   18:invokevirtual   #176 <Method Object Vector.get(int)>
    //*  11   21:invokevirtual   #273 <Method boolean Vector.contains(Object)>
    //*  12   24:ifeq            41
                commonPerms.add((Integer)curPerms.get(index));
    //   13   27:aload_3         
    //   14   28:aload_1         
    //   15   29:iload           4
    //   16   31:invokevirtual   #176 <Method Object Vector.get(int)>
    //   17   34:checkcast       #184 <Class Integer>
    //   18   37:invokevirtual   #221 <Method boolean Vector.add(Object)>
    //   19   40:pop             

    //   20   41:iinc            4  1
    //   21   44:iload           4
    //   22   46:aload_1         
    //   23   47:invokevirtual   #141 <Method int Vector.size()>
    //   24   50:icmplt          14
        return commonPerms;
    //   25   53:aload_3         
    //   26   54:areturn         
    }

    private void updateConstraint()
    {
        for(int index = 0; index < permConstraint.size(); index++)
    //*   0    0:iconst_0        
    //*   1    1:istore_1        
    //*   2    2:goto            113
        {
            int curConstraint = ((permNode)permConstraint.get(index)).getPConstraint();
    //    3    5:aload_0         
    //    4    6:getfield        #70  <Field Vector permConstraint>
    //    5    9:iload_1         
    //    6   10:invokevirtual   #176 <Method Object Vector.get(int)>
    //    7   13:checkcast       #261 <Class CCRMimplement$permNode>
    //    8   16:invokevirtual   #264 <Method int CCRMimplement$permNode.getPConstraint()>
    //    9   19:istore_2        
            int curIndex = ((permNode)permConstraint.get(index)).getPermIndex();
    //   10   20:aload_0         
    //   11   21:getfield        #70  <Field Vector permConstraint>
    //   12   24:iload_1         
    //   13   25:invokevirtual   #176 <Method Object Vector.get(int)>
    //   14   28:checkcast       #261 <Class CCRMimplement$permNode>
    //   15   31:invokevirtual   #267 <Method int CCRMimplement$permNode.getPermIndex()>
    //   16   34:istore_3        
            int count = 0;
    //   17   35:iconst_0        
    //   18   36:istore          4
            for(int jndex = 0; jndex < realRoles.size(); jndex++)
    //*  19   38:iconst_0        
    //*  20   39:istore          5
    //*  21   41:goto            75
                if(((Role)realRoles.get(jndex)).getPerms().contains(Integer.valueOf(curIndex)))
    //*  22   44:aload_0         
    //*  23   45:getfield        #74  <Field Vector realRoles>
    //*  24   48:iload           5
    //*  25   50:invokevirtual   #176 <Method Object Vector.get(int)>
    //*  26   53:checkcast       #178 <Class CCRMimplement$Role>
    //*  27   56:invokevirtual   #182 <Method Vector CCRMimplement$Role.getPerms()>
    //*  28   59:iload_3         
    //*  29   60:invokestatic    #270 <Method Integer Integer.valueOf(int)>
    //*  30   63:invokevirtual   #273 <Method boolean Vector.contains(Object)>
    //*  31   66:ifeq            72
                    count++;
    //   32   69:iinc            4  1

    //   33   72:iinc            5  1
    //   34   75:iload           5
    //   35   77:aload_0         
    //   36   78:getfield        #74  <Field Vector realRoles>
    //   37   81:invokevirtual   #141 <Method int Vector.size()>
    //   38   84:icmplt          44
            if(count > 0)
    //*  39   87:iload           4
    //*  40   89:ifle            110
                ((permNode)permConstraint.get(index)).setPConstraint(curConstraint - count);
    //   41   92:aload_0         
    //   42   93:getfield        #70  <Field Vector permConstraint>
    //   43   96:iload_1         
    //   44   97:invokevirtual   #176 <Method Object Vector.get(int)>
    //   45  100:checkcast       #261 <Class CCRMimplement$permNode>
    //   46  103:iload_2         
    //   47  104:iload           4
    //   48  106:isub            
    //   49  107:invokevirtual   #371 <Method void CCRMimplement$permNode.setPConstraint(int)>
        }

    //   50  110:iinc            1  1
    //   51  113:iload_1         
    //   52  114:aload_0         
    //   53  115:getfield        #70  <Field Vector permConstraint>
    //   54  118:invokevirtual   #141 <Method int Vector.size()>
    //   55  121:icmplt          5
    //   56  124:return          
    }

    private void generateNeededData(Matrix mat)
    {
        int users = mat.getRowDimension();
    //    0    0:aload_1         
    //    1    1:invokevirtual   #376 <Method int Matrix.getRowDimension()>
    //    2    4:istore_2        
        int perms = mat.getColumnDimension();
    //    3    5:aload_1         
    //    4    6:invokevirtual   #379 <Method int Matrix.getColumnDimension()>
    //    5    9:istore_3        
        int sum = 0;
    //    6   10:iconst_0        
    //    7   11:istore          4
        int userAverage = 0;
    //    8   13:iconst_0        
    //    9   14:istore          5
        int permAverage = 0;
    //   10   16:iconst_0        
    //   11   17:istore          6
        for(int index = 0; index < users; index++)
    //*  12   19:iconst_0        
    //*  13   20:istore          7
    //*  14   22:goto            58
        {
            for(int jndex = 0; jndex < perms; jndex++)
    //*  15   25:iconst_0        
    //*  16   26:istore          8
    //*  17   28:goto            49
                if(mat.get(index, jndex) == 1)
    //*  18   31:aload_1         
    //*  19   32:iload           7
    //*  20   34:iload           8
    //*  21   36:invokevirtual   #382 <Method byte Matrix.get(int, int)>
    //*  22   39:iconst_1        
    //*  23   40:icmpne          46
                    sum++;
    //   24   43:iinc            4  1

    //   25   46:iinc            8  1
    //   26   49:iload           8
    //   27   51:iload_3         
    //   28   52:icmplt          31
        }

    //   29   55:iinc            7  1
    //   30   58:iload           7
    //   31   60:iload_2         
    //   32   61:icmplt          25
        userAverage = getMyInt(sum, users);
    //   33   64:aload_0         
    //   34   65:iload           4
    //   35   67:iload_2         
    //   36   68:invokevirtual   #386 <Method int getMyInt(int, int)>
    //   37   71:istore          5
        permAverage = getMyInt(sum, perms);
    //   38   73:aload_0         
    //   39   74:iload           4
    //   40   76:iload_3         
    //   41   77:invokevirtual   #386 <Method int getMyInt(int, int)>
    //   42   80:istore          6
        int maxPermCount = 0;
    //   43   82:iconst_0        
    //   44   83:istore          7
        int maxUserCount = 0;
    //   45   85:iconst_0        
    //   46   86:istore          8
        for(int index = 0; index < users; index++)
    //*  47   88:iconst_0        
    //*  48   89:istore          9
    //*  49   91:goto            141
        {
            int indexPerms = 0;
    //   50   94:iconst_0        
    //   51   95:istore          10
            for(int jndex = 0; jndex < perms; jndex++)
    //*  52   97:iconst_0        
    //*  53   98:istore          11
    //*  54  100:goto            121
                if(mat.get(index, jndex) == 1)
    //*  55  103:aload_1         
    //*  56  104:iload           9
    //*  57  106:iload           11
    //*  58  108:invokevirtual   #382 <Method byte Matrix.get(int, int)>
    //*  59  111:iconst_1        
    //*  60  112:icmpne          118
                    indexPerms++;
    //   61  115:iinc            10  1

    //   62  118:iinc            11  1
    //   63  121:iload           11
    //   64  123:iload_3         
    //   65  124:icmplt          103
            if(maxPermCount < indexPerms)
    //*  66  127:iload           7
    //*  67  129:iload           10
    //*  68  131:icmpge          138
                maxPermCount = indexPerms;
    //   69  134:iload           10
    //   70  136:istore          7
        }

    //   71  138:iinc            9  1
    //   72  141:iload           9
    //   73  143:iload_2         
    //   74  144:icmplt          94
        for(int index = 0; index < perms; index++)
    //*  75  147:iconst_0        
    //*  76  148:istore          9
    //*  77  150:goto            200
        {
            int indexUsers = 0;
    //   78  153:iconst_0        
    //   79  154:istore          10
            for(int jndex = 0; jndex < users; jndex++)
    //*  80  156:iconst_0        
    //*  81  157:istore          11
    //*  82  159:goto            180
                if(mat.get(jndex, index) == 1)
    //*  83  162:aload_1         
    //*  84  163:iload           11
    //*  85  165:iload           9
    //*  86  167:invokevirtual   #382 <Method byte Matrix.get(int, int)>
    //*  87  170:iconst_1        
    //*  88  171:icmpne          177
                    indexUsers++;
    //   89  174:iinc            10  1

    //   90  177:iinc            11  1
    //   91  180:iload           11
    //   92  182:iload_2         
    //   93  183:icmplt          162
            if(maxUserCount < indexUsers)
    //*  94  186:iload           8
    //*  95  188:iload           10
    //*  96  190:icmpge          197
                maxUserCount = indexUsers;
    //   97  193:iload           10
    //   98  195:istore          8
        }

    //   99  197:iinc            9  1
    //  100  200:iload           9
    //  101  202:iload_3         
    //  102  203:icmplt          153
        int permUpperBound = (int)Math.ceil((double)userAverage * (((double)maxPermCount / (double)userAverage) * ucc));
    //  103  206:iload           5
    //  104  208:i2d             
    //  105  209:iload           7
    //  106  211:i2d             
    //  107  212:iload           5
    //  108  214:i2d             
    //  109  215:ddiv            
    //  110  216:aload_0         
    //  111  217:getfield        #388 <Field double ucc>
    //  112  220:dmul            
    //  113  221:dmul            
    //  114  222:invokestatic    #394 <Method double Math.ceil(double)>
    //  115  225:d2i             
    //  116  226:istore          9
        int userUpperBound = (int)Math.ceil((double)permAverage * (((double)maxUserCount / (double)permAverage) * pcc));
    //  117  228:iload           6
    //  118  230:i2d             
    //  119  231:iload           8
    //  120  233:i2d             
    //  121  234:iload           6
    //  122  236:i2d             
    //  123  237:ddiv            
    //  124  238:aload_0         
    //  125  239:getfield        #396 <Field double pcc>
    //  126  242:dmul            
    //  127  243:dmul            
    //  128  244:invokestatic    #394 <Method double Math.ceil(double)>
    //  129  247:d2i             
    //  130  248:istore          10
        for(int index = 0; index < users; index++)
    //* 131  250:iconst_0        
    //* 132  251:istore          11
    //* 133  253:goto            518
        {
            int indexPerms = 0;
    //  134  256:iconst_0        
    //  135  257:istore          12
            Vector permlist = new Vector();
    //  136  259:new             #61  <Class Vector>
    //  137  262:dup             
    //  138  263:invokespecial   #62  <Method void Vector()>
    //  139  266:astore          13
            for(int jndex = 0; jndex < perms; jndex++)
    //* 140  268:iconst_0        
    //* 141  269:istore          14
    //* 142  271:goto            303
                if(mat.get(index, jndex) == 1)
    //* 143  274:aload_1         
    //* 144  275:iload           11
    //* 145  277:iload           14
    //* 146  279:invokevirtual   #382 <Method byte Matrix.get(int, int)>
    //* 147  282:iconst_1        
    //* 148  283:icmpne          300
                {
                    indexPerms++;
    //  149  286:iinc            12  1
                    permlist.add(Integer.valueOf(jndex));
    //  150  289:aload           13
    //  151  291:iload           14
    //  152  293:invokestatic    #270 <Method Integer Integer.valueOf(int)>
    //  153  296:invokevirtual   #221 <Method boolean Vector.add(Object)>
    //  154  299:pop             
                }

    //  155  300:iinc            14  1
    //  156  303:iload           14
    //  157  305:iload_3         
    //  158  306:icmplt          274
            userNode un = new userNode();
    //  159  309:new             #278 <Class CCRMimplement$userNode>
    //  160  312:dup             
    //  161  313:aload_0         
    //  162  314:invokespecial   #397 <Method void CCRMimplement$userNode(CCRMimplement)>
    //  163  317:astore          14
            un.setUserIndex(index);
    //  164  319:aload           14
    //  165  321:iload           11
    //  166  323:invokevirtual   #400 <Method void CCRMimplement$userNode.setUserIndex(int)>
            candidateRole cr = new candidateRole();
    //  167  326:new             #286 <Class CCRMimplement$candidateRole>
    //  168  329:dup             
    //  169  330:aload_0         
    //  170  331:invokespecial   #319 <Method void CCRMimplement$candidateRole(CCRMimplement)>
    //  171  334:astore          15
            cr.setPermVect(permlist);
    //  172  336:aload           15
    //  173  338:aload           13
    //  174  340:invokevirtual   #322 <Method void CCRMimplement$candidateRole.setPermVect(Vector)>
            Vector crs = new Vector();
    //  175  343:new             #61  <Class Vector>
    //  176  346:dup             
    //  177  347:invokespecial   #62  <Method void Vector()>
    //  178  350:astore          16
            crs.add(cr);
    //  179  352:aload           16
    //  180  354:aload           15
    //  181  356:invokevirtual   #221 <Method boolean Vector.add(Object)>
    //  182  359:pop             
            un.setCandidateRoleSet(crs);
    //  183  360:aload           14
    //  184  362:aload           16
    //  185  364:invokevirtual   #403 <Method void CCRMimplement$userNode.setCandidateRoleSet(Vector)>
            un.setUconstraint(0x7fffffff);
    //  186  367:aload           14
    //  187  369:ldc2            #351 <Int 0x7fffffff>
    //  188  372:invokevirtual   #333 <Method void CCRMimplement$userNode.setUconstraint(int)>
            if(indexPerms > permUpperBound)
    //* 189  375:iload           12
    //* 190  377:iload           9
    //* 191  379:icmple          505
            {
                Vector probabilitySet = getProbabilityValues(permUpperBound);
    //  192  382:aload_0         
    //  193  383:iload           9
    //  194  385:invokespecial   #407 <Method Vector getProbabilityValues(int)>
    //  195  388:astore          17
                int result = 0;
    //  196  390:iconst_0        
    //  197  391:istore          18
                double r = Math.random();
    //  198  393:invokestatic    #411 <Method double Math.random()>
    //  199  396:dstore          19
                double probabilitySum = 0.0D;
    //  200  398:dconst_0        
    //  201  399:dstore          21
                for(int kndex = 0; kndex < probabilitySet.size(); kndex++)
    //* 202  401:iconst_0        
    //* 203  402:istore          23
    //* 204  404:goto            495
                {
                    probabilitySum += ((Double)probabilitySet.get(kndex)).doubleValue();
    //  205  407:dload           21
    //  206  409:aload           17
    //  207  411:iload           23
    //  208  413:invokevirtual   #176 <Method Object Vector.get(int)>
    //  209  416:checkcast       #413 <Class Double>
    //  210  419:invokevirtual   #416 <Method double Double.doubleValue()>
    //  211  422:dadd            
    //  212  423:dstore          21
                    if(probabilitySum <= r)
                        continue;
    //  213  425:dload           21
    //  214  427:dload           19
    //  215  429:dcmpl           
    //  216  430:ifle            492
                    result = kndex + 1;
    //  217  433:iload           23
    //  218  435:iconst_1        
    //  219  436:iadd            
    //  220  437:istore          18
                    log.append((new StringBuilder("\u89D2\u8272\u52BF\u7EA6\u675F\u4E3A: ")).append(maxUser).append("\n").toString());
    //  221  439:aload_0         
    //  222  440:getfield        #79  <Field StringBuffer log>
    //  223  443:new             #132 <Class StringBuilder>
    //  224  446:dup             
    //  225  447:ldc2            #418 <String "\u89D2\u8272\u52BF\u7EA6\u675F\u4E3A: ">
    //  226  450:invokespecial   #137 <Method void StringBuilder(String)>
    //  227  453:getstatic       #44  <Field int maxUser>
    //  228  456:invokevirtual   #145 <Method StringBuilder StringBuilder.append(int)>
    //  229  459:ldc1            #147 <String "\n">
    //  230  461:invokevirtual   #150 <Method StringBuilder StringBuilder.append(String)>
    //  231  464:invokevirtual   #154 <Method String StringBuilder.toString()>
    //  232  467:invokevirtual   #157 <Method StringBuffer StringBuffer.append(String)>
    //  233  470:pop             
                    un.setUconstraint(maxUser);
    //  234  471:aload           14
    //  235  473:getstatic       #44  <Field int maxUser>
    //  236  476:invokevirtual   #333 <Method void CCRMimplement$userNode.setUconstraint(int)>
                    roleLimits++;
    //  237  479:aload_0         
    //  238  480:dup             
    //  239  481:getfield        #202 <Field int roleLimits>
    //  240  484:iconst_1        
    //  241  485:iadd            
    //  242  486:putfield        #202 <Field int roleLimits>
                    break;
    //  243  489:goto            505
                }

    //  244  492:iinc            23  1
    //  245  495:iload           23
    //  246  497:aload           17
    //  247  499:invokevirtual   #141 <Method int Vector.size()>
    //  248  502:icmplt          407
            }
            userConstraint.add(un);
    //  249  505:aload_0         
    //  250  506:getfield        #68  <Field Vector userConstraint>
    //  251  509:aload           14
    //  252  511:invokevirtual   #221 <Method boolean Vector.add(Object)>
    //  253  514:pop             
        }

    //  254  515:iinc            11  1
    //  255  518:iload           11
    //  256  520:iload_2         
    //  257  521:icmplt          256
        Collections.sort(userConstraint);
    //  258  524:aload_0         
    //  259  525:getfield        #68  <Field Vector userConstraint>
    //  260  528:invokestatic    #238 <Method void Collections.sort(java.util.List)>
        for(int index = 0; index < perms; index++)
    //* 261  531:iconst_0        
    //* 262  532:istore          11
    //* 263  534:goto            698
        {
            int indexUsers = 0;
    //  264  537:iconst_0        
    //  265  538:istore          12
            for(int jndex = 0; jndex < users; jndex++)
    //* 266  540:iconst_0        
    //* 267  541:istore          13
    //* 268  543:goto            564
                if(mat.get(jndex, index) == 1)
    //* 269  546:aload_1         
    //* 270  547:iload           13
    //* 271  549:iload           11
    //* 272  551:invokevirtual   #382 <Method byte Matrix.get(int, int)>
    //* 273  554:iconst_1        
    //* 274  555:icmpne          561
                    indexUsers++;
    //  275  558:iinc            12  1

    //  276  561:iinc            13  1
    //  277  564:iload           13
    //  278  566:iload_2         
    //  279  567:icmplt          546
            permNode pn = new permNode();
    //  280  570:new             #261 <Class CCRMimplement$permNode>
    //  281  573:dup             
    //  282  574:aload_0         
    //  283  575:invokespecial   #419 <Method void CCRMimplement$permNode(CCRMimplement)>
    //  284  578:astore          13
            pn.setPermIndex(index);
    //  285  580:aload           13
    //  286  582:iload           11
    //  287  584:invokevirtual   #422 <Method void CCRMimplement$permNode.setPermIndex(int)>
            pn.setPConstraint(0x7fffffff);
    //  288  587:aload           13
    //  289  589:ldc2            #351 <Int 0x7fffffff>
    //  290  592:invokevirtual   #371 <Method void CCRMimplement$permNode.setPConstraint(int)>
            if(indexUsers > userUpperBound)
    //* 291  595:iload           12
    //* 292  597:iload           10
    //* 293  599:icmple          685
            {
                Vector probabilitySet = getProbabilityValues(userUpperBound);
    //  294  602:aload_0         
    //  295  603:iload           10
    //  296  605:invokespecial   #407 <Method Vector getProbabilityValues(int)>
    //  297  608:astore          14
                int result = 0;
    //  298  610:iconst_0        
    //  299  611:istore          15
                double r = Math.random();
    //  300  613:invokestatic    #411 <Method double Math.random()>
    //  301  616:dstore          16
                double probabilitySum = 0.0D;
    //  302  618:dconst_0        
    //  303  619:dstore          18
                for(int kndex = 0; kndex < probabilitySet.size(); kndex++)
    //* 304  621:iconst_0        
    //* 305  622:istore          20
    //* 306  624:goto            675
                {
                    probabilitySum += ((Double)probabilitySet.get(kndex)).doubleValue();
    //  307  627:dload           18
    //  308  629:aload           14
    //  309  631:iload           20
    //  310  633:invokevirtual   #176 <Method Object Vector.get(int)>
    //  311  636:checkcast       #413 <Class Double>
    //  312  639:invokevirtual   #416 <Method double Double.doubleValue()>
    //  313  642:dadd            
    //  314  643:dstore          18
                    if(probabilitySum <= r)
                        continue;
    //  315  645:dload           18
    //  316  647:dload           16
    //  317  649:dcmpl           
    //  318  650:ifle            672
                    result = kndex + 1;
    //  319  653:iload           20
    //  320  655:iconst_1        
    //  321  656:iadd            
    //  322  657:istore          15
                    permLimits++;
    //  323  659:aload_0         
    //  324  660:dup             
    //  325  661:getfield        #206 <Field int permLimits>
    //  326  664:iconst_1        
    //  327  665:iadd            
    //  328  666:putfield        #206 <Field int permLimits>
                    break;
    //  329  669:goto            685
                }

    //  330  672:iinc            20  1
    //  331  675:iload           20
    //  332  677:aload           14
    //  333  679:invokevirtual   #141 <Method int Vector.size()>
    //  334  682:icmplt          627
            }
            permConstraint.add(pn);
    //  335  685:aload_0         
    //  336  686:getfield        #70  <Field Vector permConstraint>
    //  337  689:aload           13
    //  338  691:invokevirtual   #221 <Method boolean Vector.add(Object)>
    //  339  694:pop             
        }

    //  340  695:iinc            11  1
    //  341  698:iload           11
    //  342  700:iload_3         
    //  343  701:icmplt          537
        Collections.sort(permConstraint);
    //  344  704:aload_0         
    //  345  705:getfield        #70  <Field Vector permConstraint>
    //  346  708:invokestatic    #238 <Method void Collections.sort(java.util.List)>
    //  347  711:return          
    }

    private Vector getProbabilityValues(int upper)
    {
        Vector probabilitySet = new Vector();
    //    0    0:new             #61  <Class Vector>
    //    1    3:dup             
    //    2    4:invokespecial   #62  <Method void Vector()>
    //    3    7:astore_2        
        for(int index = 0; index < upper; index++)
    //*   4    8:iconst_0        
    //*   5    9:istore_3        
    //*   6   10:goto            39
        {
            double pk = (double)(2 * index + 1) / (double)(upper * upper);
    //    7   13:iconst_2        
    //    8   14:iload_3         
    //    9   15:imul            
    //   10   16:iconst_1        
    //   11   17:iadd            
    //   12   18:i2d             
    //   13   19:iload_1         
    //   14   20:iload_1         
    //   15   21:imul            
    //   16   22:i2d             
    //   17   23:ddiv            
    //   18   24:dstore          4
            probabilitySet.add(index, Double.valueOf(pk));
    //   19   26:aload_2         
    //   20   27:iload_3         
    //   21   28:dload           4
    //   22   30:invokestatic    #447 <Method Double Double.valueOf(double)>
    //   23   33:invokevirtual   #450 <Method void Vector.add(int, Object)>
        }

    //   24   36:iinc            3  1
    //   25   39:iload_3         
    //   26   40:iload_1         
    //   27   41:icmplt          13
        return probabilitySet;
    //   28   44:aload_2         
    //   29   45:areturn         
    }

    public int getMyInt(int a, int b)
    {
        return (double)a / (double)b <= (double)(a / b) ? a / b : a / b + 1;
    //    0    0:iload_1         
    //    1    1:i2d             
    //    2    2:iload_2         
    //    3    3:i2d             
    //    4    4:ddiv            
    //    5    5:iload_1         
    //    6    6:iload_2         
    //    7    7:idiv            
    //    8    8:i2d             
    //    9    9:dcmpl           
    //   10   10:ifle            21
    //   11   13:iload_1         
    //   12   14:iload_2         
    //   13   15:idiv            
    //   14   16:iconst_1        
    //   15   17:iadd            
    //   16   18:goto            24
    //   17   21:iload_1         
    //   18   22:iload_2         
    //   19   23:idiv            
    //   20   24:ireturn         
    }

    private void splitAttruteString(Attribute latitudeAttrute, Vector splitString)
    {
        String perAttr = latitudeAttrute.toString();
    //    0    0:aload_1         
    //    1    1:invokevirtual   #458 <Method String Attribute.toString()>
    //    2    4:astore_3        
        int fristChar = perAttr.indexOf('{');
    //    3    5:aload_3         
    //    4    6:bipush          123
    //    5    8:invokevirtual   #462 <Method int String.indexOf(int)>
    //    6   11:istore          4
        int lastChar = perAttr.lastIndexOf('}');
    //    7   13:aload_3         
    //    8   14:bipush          125
    //    9   16:invokevirtual   #465 <Method int String.lastIndexOf(int)>
    //   10   19:istore          5
        perAttr = perAttr.substring(fristChar + 1, lastChar);
    //   11   21:aload_3         
    //   12   22:iload           4
    //   13   24:iconst_1        
    //   14   25:iadd            
    //   15   26:iload           5
    //   16   28:invokevirtual   #469 <Method String String.substring(int, int)>
    //   17   31:astore_3        
        for(int index = perAttr.indexOf(','); index != -1; index = perAttr.indexOf(','))
    //*  18   32:aload_3         
    //*  19   33:bipush          44
    //*  20   35:invokevirtual   #462 <Method int String.indexOf(int)>
    //*  21   38:istore          6
    //*  22   40:goto            72
        {
            splitString.add(perAttr.substring(0, index));
    //   23   43:aload_2         
    //   24   44:aload_3         
    //   25   45:iconst_0        
    //   26   46:iload           6
    //   27   48:invokevirtual   #469 <Method String String.substring(int, int)>
    //   28   51:invokevirtual   #221 <Method boolean Vector.add(Object)>
    //   29   54:pop             
            perAttr = perAttr.substring(index + 1);
    //   30   55:aload_3         
    //   31   56:iload           6
    //   32   58:iconst_1        
    //   33   59:iadd            
    //   34   60:invokevirtual   #472 <Method String String.substring(int)>
    //   35   63:astore_3        
        }

    //   36   64:aload_3         
    //   37   65:bipush          44
    //   38   67:invokevirtual   #462 <Method int String.indexOf(int)>
    //   39   70:istore          6
    //   40   72:iload           6
    //   41   74:iconst_m1       
    //   42   75:icmpne          43
        splitString.add(perAttr.substring(0));
    //   43   78:aload_2         
    //   44   79:aload_3         
    //   45   80:iconst_0        
    //   46   81:invokevirtual   #472 <Method String String.substring(int)>
    //   47   84:invokevirtual   #221 <Method boolean Vector.add(Object)>
    //   48   87:pop             
    //   49   88:return          
    }

    private void resetOptions()
    {
        wr = 1;
    //    0    0:aload_0         
    //    1    1:iconst_1        
    //    2    2:putfield        #213 <Field int wr>
        wu = 1;
    //    3    5:aload_0         
    //    4    6:iconst_1        
    //    5    7:putfield        #198 <Field int wu>
        wp = 1;
    //    6   10:aload_0         
    //    7   11:iconst_1        
    //    8   12:putfield        #217 <Field int wp>
        wh = 1;
    //    9   15:aload_0         
    //   10   16:iconst_1        
    //   11   17:putfield        #215 <Field int wh>
        roleLimits = 0;
    //   12   20:aload_0         
    //   13   21:iconst_0        
    //   14   22:putfield        #202 <Field int roleLimits>
        permLimits = 0;
    //   15   25:aload_0         
    //   16   26:iconst_0        
    //   17   27:putfield        #206 <Field int permLimits>
        ucc = 0.80000000000000004D;
    //   18   30:aload_0         
    //   19   31:ldc2w           #480 <Double 0.80000000000000004D>
    //   20   34:putfield        #388 <Field double ucc>
    //   21   37:return          
    }

    public String globalInfo()
    {
        return "CCR first generates roles by one role for all permissions a user has and Consider the Constraint \nthen for Optimizating the number of edges it deals with equality,subset and intersection\nsituation respectively until no further improvement is possible. \n";
    //    0    0:ldc2            #484 <String "CCR first generates roles by one role for all permissions a user has and Consider the Constraint \nthen for Optimizating the number of edges it deals with equality,subset and intersection\nsituation respectively until no further improvement is possible. \n">
    //    1    3:areturn         
    }

    public Capabilities getCapabilities()
    {
        Capabilities result = super.getCapabilities();
    //    0    0:aload_0         
    //    1    1:invokespecial   #488 <Method Capabilities AbstractRoleminer.getCapabilities()>
    //    2    4:astore_1        
        result.disableAll();
    //    3    5:aload_1         
    //    4    6:invokevirtual   #493 <Method void Capabilities.disableAll()>
        result.enable(rm.core.Capabilities.Capability.NOMINAL_ATTRIBUTES);
    //    5    9:aload_1         
    //    6   10:getstatic       #499 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.NOMINAL_ATTRIBUTES>
    //    7   13:invokevirtual   #503 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enable(rm.core.Capabilities.Capability.MISSING_VALUES);
    //    8   16:aload_1         
    //    9   17:getstatic       #506 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.MISSING_VALUES>
    //   10   20:invokevirtual   #503 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enable(rm.core.Capabilities.Capability.NO_CLASS);
    //   11   23:aload_1         
    //   12   24:getstatic       #509 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.NO_CLASS>
    //   13   27:invokevirtual   #503 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enable(rm.core.Capabilities.Capability.NOMINAL_CLASS);
    //   14   30:aload_1         
    //   15   31:getstatic       #512 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.NOMINAL_CLASS>
    //   16   34:invokevirtual   #503 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enable(rm.core.Capabilities.Capability.MISSING_CLASS_VALUES);
    //   17   37:aload_1         
    //   18   38:getstatic       #515 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.MISSING_CLASS_VALUES>
    //   19   41:invokevirtual   #503 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        return result;
    //   20   44:aload_1         
    //   21   45:areturn         
    }

    public Enumeration listOptions()
    {
        String string1 = (new StringBuilder("\tRequired weight of number of role for WSC. (default = ")).append(wr).append(")").toString();
    //    0    0:new             #132 <Class StringBuilder>
    //    1    3:dup             
    //    2    4:ldc2            #520 <String "\tRequired weight of number of role for WSC. (default = ">
    //    3    7:invokespecial   #137 <Method void StringBuilder(String)>
    //    4   10:aload_0         
    //    5   11:getfield        #213 <Field int wr>
    //    6   14:invokevirtual   #145 <Method StringBuilder StringBuilder.append(int)>
    //    7   17:ldc2            #522 <String ")">
    //    8   20:invokevirtual   #150 <Method StringBuilder StringBuilder.append(String)>
    //    9   23:invokevirtual   #154 <Method String StringBuilder.toString()>
    //   10   26:astore_1        
        String string2 = (new StringBuilder("\tRequired weight of number of user for WSC. (default = ")).append(wu).append(")").toString();
    //   11   27:new             #132 <Class StringBuilder>
    //   12   30:dup             
    //   13   31:ldc2            #524 <String "\tRequired weight of number of user for WSC. (default = ">
    //   14   34:invokespecial   #137 <Method void StringBuilder(String)>
    //   15   37:aload_0         
    //   16   38:getfield        #198 <Field int wu>
    //   17   41:invokevirtual   #145 <Method StringBuilder StringBuilder.append(int)>
    //   18   44:ldc2            #522 <String ")">
    //   19   47:invokevirtual   #150 <Method StringBuilder StringBuilder.append(String)>
    //   20   50:invokevirtual   #154 <Method String StringBuilder.toString()>
    //   21   53:astore_2        
        String string3 = (new StringBuilder("\tRequired weight of number of permission for WSC. (default = ")).append(wp).append(")").toString();
    //   22   54:new             #132 <Class StringBuilder>
    //   23   57:dup             
    //   24   58:ldc2            #526 <String "\tRequired weight of number of permission for WSC. (default = ">
    //   25   61:invokespecial   #137 <Method void StringBuilder(String)>
    //   26   64:aload_0         
    //   27   65:getfield        #217 <Field int wp>
    //   28   68:invokevirtual   #145 <Method StringBuilder StringBuilder.append(int)>
    //   29   71:ldc2            #522 <String ")">
    //   30   74:invokevirtual   #150 <Method StringBuilder StringBuilder.append(String)>
    //   31   77:invokevirtual   #154 <Method String StringBuilder.toString()>
    //   32   80:astore_3        
        String string4 = (new StringBuilder("\tRequired weight of number of roles' hierarchy for WSC. (default = ")).append(wh).append(")").toString();
    //   33   81:new             #132 <Class StringBuilder>
    //   34   84:dup             
    //   35   85:ldc2            #528 <String "\tRequired weight of number of roles' hierarchy for WSC. (default = ">
    //   36   88:invokespecial   #137 <Method void StringBuilder(String)>
    //   37   91:aload_0         
    //   38   92:getfield        #215 <Field int wh>
    //   39   95:invokevirtual   #145 <Method StringBuilder StringBuilder.append(int)>
    //   40   98:ldc2            #522 <String ")">
    //   41  101:invokevirtual   #150 <Method StringBuilder StringBuilder.append(String)>
    //   42  104:invokevirtual   #154 <Method String StringBuilder.toString()>
    //   43  107:astore          4
        String string5 = (new StringBuilder("\tRequired weight of number of user Constraint. (default = ")).append(ucc).append(")").toString();
    //   44  109:new             #132 <Class StringBuilder>
    //   45  112:dup             
    //   46  113:ldc2            #530 <String "\tRequired weight of number of user Constraint. (default = ">
    //   47  116:invokespecial   #137 <Method void StringBuilder(String)>
    //   48  119:aload_0         
    //   49  120:getfield        #388 <Field double ucc>
    //   50  123:invokevirtual   #533 <Method StringBuilder StringBuilder.append(double)>
    //   51  126:ldc2            #522 <String ")">
    //   52  129:invokevirtual   #150 <Method StringBuilder StringBuilder.append(String)>
    //   53  132:invokevirtual   #154 <Method String StringBuilder.toString()>
    //   54  135:astore          5
        String string6 = (new StringBuilder("\tRequired weight of number of permission Constraint. (default = ")).append(pcc).append(")").toString();
    //   55  137:new             #132 <Class StringBuilder>
    //   56  140:dup             
    //   57  141:ldc2            #535 <String "\tRequired weight of number of permission Constraint. (default = ">
    //   58  144:invokespecial   #137 <Method void StringBuilder(String)>
    //   59  147:aload_0         
    //   60  148:getfield        #396 <Field double pcc>
    //   61  151:invokevirtual   #533 <Method StringBuilder StringBuilder.append(double)>
    //   62  154:ldc2            #522 <String ")">
    //   63  157:invokevirtual   #150 <Method StringBuilder StringBuilder.append(String)>
    //   64  160:invokevirtual   #154 <Method String StringBuilder.toString()>
    //   65  163:astore          6
        FastVector newVector = new FastVector(6);
    //   66  165:new             #537 <Class FastVector>
    //   67  168:dup             
    //   68  169:bipush          6
    //   69  171:invokespecial   #539 <Method void FastVector(int)>
    //   70  174:astore          7
        newVector.addElement(new Option(string1, "R", 1, "-R <required weight of number of role>"));
    //   71  176:aload           7
    //   72  178:new             #541 <Class Option>
    //   73  181:dup             
    //   74  182:aload_1         
    //   75  183:ldc2            #543 <String "R">
    //   76  186:iconst_1        
    //   77  187:ldc2            #545 <String "-R <required weight of number of role>">
    //   78  190:invokespecial   #548 <Method void Option(String, String, int, String)>
    //   79  193:invokevirtual   #552 <Method void FastVector.addElement(Object)>
        newVector.addElement(new Option(string2, "U", 1, "-U <required weight of number of user>"));
    //   80  196:aload           7
    //   81  198:new             #541 <Class Option>
    //   82  201:dup             
    //   83  202:aload_2         
    //   84  203:ldc2            #554 <String "U">
    //   85  206:iconst_1        
    //   86  207:ldc2            #556 <String "-U <required weight of number of user>">
    //   87  210:invokespecial   #548 <Method void Option(String, String, int, String)>
    //   88  213:invokevirtual   #552 <Method void FastVector.addElement(Object)>
        newVector.addElement(new Option(string3, "P", 1, "-P <required weight of number of permission>"));
    //   89  216:aload           7
    //   90  218:new             #541 <Class Option>
    //   91  221:dup             
    //   92  222:aload_3         
    //   93  223:ldc2            #558 <String "P">
    //   94  226:iconst_1        
    //   95  227:ldc2            #560 <String "-P <required weight of number of permission>">
    //   96  230:invokespecial   #548 <Method void Option(String, String, int, String)>
    //   97  233:invokevirtual   #552 <Method void FastVector.addElement(Object)>
        newVector.addElement(new Option(string4, "H", 1, "-H <required weight of number of roles' hierarchy>"));
    //   98  236:aload           7
    //   99  238:new             #541 <Class Option>
    //  100  241:dup             
    //  101  242:aload           4
    //  102  244:ldc2            #562 <String "H">
    //  103  247:iconst_1        
    //  104  248:ldc2            #564 <String "-H <required weight of number of roles' hierarchy>">
    //  105  251:invokespecial   #548 <Method void Option(String, String, int, String)>
    //  106  254:invokevirtual   #552 <Method void FastVector.addElement(Object)>
        newVector.addElement(new Option(string5, "UCC", 1, "-H <required weight of number of user Constraint>"));
    //  107  257:aload           7
    //  108  259:new             #541 <Class Option>
    //  109  262:dup             
    //  110  263:aload           5
    //  111  265:ldc2            #566 <String "UCC">
    //  112  268:iconst_1        
    //  113  269:ldc2            #568 <String "-H <required weight of number of user Constraint>">
    //  114  272:invokespecial   #548 <Method void Option(String, String, int, String)>
    //  115  275:invokevirtual   #552 <Method void FastVector.addElement(Object)>
        newVector.addElement(new Option(string6, "PCC", 1, "-H <required weight of number of permission Constraint>"));
    //  116  278:aload           7
    //  117  280:new             #541 <Class Option>
    //  118  283:dup             
    //  119  284:aload           6
    //  120  286:ldc2            #570 <String "PCC">
    //  121  289:iconst_1        
    //  122  290:ldc2            #572 <String "-H <required weight of number of permission Constraint>">
    //  123  293:invokespecial   #548 <Method void Option(String, String, int, String)>
    //  124  296:invokevirtual   #552 <Method void FastVector.addElement(Object)>
        return newVector.elements();
    //  125  299:aload           7
    //  126  301:invokevirtual   #575 <Method Enumeration FastVector.elements()>
    //  127  304:areturn         
    }

    public void setOptions(String options[])
        throws Exception
    {
        resetOptions();
    //    0    0:aload_0         
    //    1    1:invokespecial   #82  <Method void resetOptions()>
        String s_wr = Utils.getOption('R', options);
    //    2    4:bipush          82
    //    3    6:aload_1         
    //    4    7:invokestatic    #591 <Method String Utils.getOption(char, String[])>
    //    5   10:astore_2        
        if(s_wr.length() != 0)
    //*   6   11:aload_2         
    //*   7   12:invokevirtual   #594 <Method int String.length()>
    //*   8   15:ifeq            26
            wr = Integer.parseInt(s_wr);
    //    9   18:aload_0         
    //   10   19:aload_2         
    //   11   20:invokestatic    #598 <Method int Integer.parseInt(String)>
    //   12   23:putfield        #213 <Field int wr>
        String s_wu = Utils.getOption('U', options);
    //   13   26:bipush          85
    //   14   28:aload_1         
    //   15   29:invokestatic    #591 <Method String Utils.getOption(char, String[])>
    //   16   32:astore_3        
        if(s_wu.length() != 0)
    //*  17   33:aload_3         
    //*  18   34:invokevirtual   #594 <Method int String.length()>
    //*  19   37:ifeq            48
            wu = Integer.parseInt(s_wu);
    //   20   40:aload_0         
    //   21   41:aload_3         
    //   22   42:invokestatic    #598 <Method int Integer.parseInt(String)>
    //   23   45:putfield        #198 <Field int wu>
        String s_wp = Utils.getOption('P', options);
    //   24   48:bipush          80
    //   25   50:aload_1         
    //   26   51:invokestatic    #591 <Method String Utils.getOption(char, String[])>
    //   27   54:astore          4
        if(s_wp.length() != 0)
    //*  28   56:aload           4
    //*  29   58:invokevirtual   #594 <Method int String.length()>
    //*  30   61:ifeq            73
            wp = Integer.parseInt(s_wp);
    //   31   64:aload_0         
    //   32   65:aload           4
    //   33   67:invokestatic    #598 <Method int Integer.parseInt(String)>
    //   34   70:putfield        #217 <Field int wp>
        String s_wh = Utils.getOption('H', options);
    //   35   73:bipush          72
    //   36   75:aload_1         
    //   37   76:invokestatic    #591 <Method String Utils.getOption(char, String[])>
    //   38   79:astore          5
        if(s_wu.length() != 0)
    //*  39   81:aload_3         
    //*  40   82:invokevirtual   #594 <Method int String.length()>
    //*  41   85:ifeq            97
            wh = Integer.parseInt(s_wh);
    //   42   88:aload_0         
    //   43   89:aload           5
    //   44   91:invokestatic    #598 <Method int Integer.parseInt(String)>
    //   45   94:putfield        #215 <Field int wh>
        String s_ucc = Utils.getOption("UCC", options);
    //   46   97:ldc2            #566 <String "UCC">
    //   47  100:aload_1         
    //   48  101:invokestatic    #601 <Method String Utils.getOption(String, String[])>
    //   49  104:astore          6
        if(s_ucc.length() != 0)
    //*  50  106:aload           6
    //*  51  108:invokevirtual   #594 <Method int String.length()>
    //*  52  111:ifeq            123
            ucc = Double.parseDouble(s_ucc);
    //   53  114:aload_0         
    //   54  115:aload           6
    //   55  117:invokestatic    #605 <Method double Double.parseDouble(String)>
    //   56  120:putfield        #388 <Field double ucc>
        String s_pcc = Utils.getOption("PCC", options);
    //   57  123:ldc2            #570 <String "PCC">
    //   58  126:aload_1         
    //   59  127:invokestatic    #601 <Method String Utils.getOption(String, String[])>
    //   60  130:astore          7
        if(s_pcc.length() != 0)
    //*  61  132:aload           7
    //*  62  134:invokevirtual   #594 <Method int String.length()>
    //*  63  137:ifeq            149
            pcc = Double.parseDouble(s_pcc);
    //   64  140:aload_0         
    //   65  141:aload           7
    //   66  143:invokestatic    #605 <Method double Double.parseDouble(String)>
    //   67  146:putfield        #396 <Field double pcc>
    //   68  149:return          
    }

    public String[] getOptions()
    {
        String options[] = new String[45];
    //    0    0:bipush          45
    //    1    2:anewarray       String[]
    //    2    5:astore_1        
        int current = 0;
    //    3    6:iconst_0        
    //    4    7:istore_2        
        options[current++] = "-R";
    //    5    8:aload_1         
    //    6    9:iload_2         
    //    7   10:iinc            2  1
    //    8   13:ldc2            #617 <String "-R">
    //    9   16:aastore         
        options[current++] = (new StringBuilder()).append(wr).toString();
    //   10   17:aload_1         
    //   11   18:iload_2         
    //   12   19:iinc            2  1
    //   13   22:new             #132 <Class StringBuilder>
    //   14   25:dup             
    //   15   26:invokespecial   #618 <Method void StringBuilder()>
    //   16   29:aload_0         
    //   17   30:getfield        #213 <Field int wr>
    //   18   33:invokevirtual   #145 <Method StringBuilder StringBuilder.append(int)>
    //   19   36:invokevirtual   #154 <Method String StringBuilder.toString()>
    //   20   39:aastore         
        options[current++] = "-U";
    //   21   40:aload_1         
    //   22   41:iload_2         
    //   23   42:iinc            2  1
    //   24   45:ldc2            #620 <String "-U">
    //   25   48:aastore         
        options[current++] = (new StringBuilder()).append(wu).toString();
    //   26   49:aload_1         
    //   27   50:iload_2         
    //   28   51:iinc            2  1
    //   29   54:new             #132 <Class StringBuilder>
    //   30   57:dup             
    //   31   58:invokespecial   #618 <Method void StringBuilder()>
    //   32   61:aload_0         
    //   33   62:getfield        #198 <Field int wu>
    //   34   65:invokevirtual   #145 <Method StringBuilder StringBuilder.append(int)>
    //   35   68:invokevirtual   #154 <Method String StringBuilder.toString()>
    //   36   71:aastore         
        options[current++] = "-P";
    //   37   72:aload_1         
    //   38   73:iload_2         
    //   39   74:iinc            2  1
    //   40   77:ldc2            #622 <String "-P">
    //   41   80:aastore         
        options[current++] = (new StringBuilder()).append(wp).toString();
    //   42   81:aload_1         
    //   43   82:iload_2         
    //   44   83:iinc            2  1
    //   45   86:new             #132 <Class StringBuilder>
    //   46   89:dup             
    //   47   90:invokespecial   #618 <Method void StringBuilder()>
    //   48   93:aload_0         
    //   49   94:getfield        #217 <Field int wp>
    //   50   97:invokevirtual   #145 <Method StringBuilder StringBuilder.append(int)>
    //   51  100:invokevirtual   #154 <Method String StringBuilder.toString()>
    //   52  103:aastore         
        options[current++] = "-H";
    //   53  104:aload_1         
    //   54  105:iload_2         
    //   55  106:iinc            2  1
    //   56  109:ldc2            #624 <String "-H">
    //   57  112:aastore         
        options[current++] = (new StringBuilder()).append(wh).toString();
    //   58  113:aload_1         
    //   59  114:iload_2         
    //   60  115:iinc            2  1
    //   61  118:new             #132 <Class StringBuilder>
    //   62  121:dup             
    //   63  122:invokespecial   #618 <Method void StringBuilder()>
    //   64  125:aload_0         
    //   65  126:getfield        #215 <Field int wh>
    //   66  129:invokevirtual   #145 <Method StringBuilder StringBuilder.append(int)>
    //   67  132:invokevirtual   #154 <Method String StringBuilder.toString()>
    //   68  135:aastore         
        options[current++] = "-UCC";
    //   69  136:aload_1         
    //   70  137:iload_2         
    //   71  138:iinc            2  1
    //   72  141:ldc2            #626 <String "-UCC">
    //   73  144:aastore         
        options[current++] = (new StringBuilder()).append(ucc).toString();
    //   74  145:aload_1         
    //   75  146:iload_2         
    //   76  147:iinc            2  1
    //   77  150:new             #132 <Class StringBuilder>
    //   78  153:dup             
    //   79  154:invokespecial   #618 <Method void StringBuilder()>
    //   80  157:aload_0         
    //   81  158:getfield        #388 <Field double ucc>
    //   82  161:invokevirtual   #533 <Method StringBuilder StringBuilder.append(double)>
    //   83  164:invokevirtual   #154 <Method String StringBuilder.toString()>
    //   84  167:aastore         
        options[current++] = "-PCC";
    //   85  168:aload_1         
    //   86  169:iload_2         
    //   87  170:iinc            2  1
    //   88  173:ldc2            #628 <String "-PCC">
    //   89  176:aastore         
        for(options[current++] = (new StringBuilder()).append(pcc).toString(); current < options.length; options[current++] = "");
    //   90  177:aload_1         
    //   91  178:iload_2         
    //   92  179:iinc            2  1
    //   93  182:new             #132 <Class StringBuilder>
    //   94  185:dup             
    //   95  186:invokespecial   #618 <Method void StringBuilder()>
    //   96  189:aload_0         
    //   97  190:getfield        #396 <Field double pcc>
    //   98  193:invokevirtual   #533 <Method StringBuilder StringBuilder.append(double)>
    //   99  196:invokevirtual   #154 <Method String StringBuilder.toString()>
    //  100  199:aastore         
    //  101  200:goto            212
    //  102  203:aload_1         
    //  103  204:iload_2         
    //  104  205:iinc            2  1
    //  105  208:ldc2            #630 <String "">
    //  106  211:aastore         
    //  107  212:iload_2         
    //  108  213:aload_1         
    //  109  214:arraylength     
    //  110  215:icmplt          203
        return options;
    //  111  218:aload_1         
    //  112  219:areturn         
    }

    public String toString()
    {
        return log.toString();
    //    0    0:aload_0         
    //    1    1:getfield        #79  <Field StringBuffer log>
    //    2    4:invokevirtual   #632 <Method String StringBuffer.toString()>
    //    3    7:areturn         
    }

    public Assignment generateRoles()
    {
        m_assroles = new Assignment();
    //    0    0:aload_0         
    //    1    1:new             #93  <Class Assignment>
    //    2    4:dup             
    //    3    5:invokespecial   #635 <Method void Assignment()>
    //    4    8:putfield        #637 <Field Assignment m_assroles>
        m_assroles.setAssignementName("role-permission");
    //    5   11:aload_0         
    //    6   12:getfield        #637 <Field Assignment m_assroles>
    //    7   15:ldc2            #639 <String "role-permission">
    //    8   18:invokevirtual   #642 <Method void Assignment.setAssignementName(String)>
        Matrix mat = new Matrix(numberOfRoles, permissions.size(), (byte)0);
    //    9   21:new             #373 <Class Matrix>
    //   10   24:dup             
    //   11   25:getstatic       #46  <Field int numberOfRoles>
    //   12   28:aload_0         
    //   13   29:getfield        #64  <Field Vector permissions>
    //   14   32:invokevirtual   #141 <Method int Vector.size()>
    //   15   35:iconst_0        
    //   16   36:invokespecial   #645 <Method void Matrix(int, int, byte)>
    //   17   39:astore_1        
        for(int i = 0; i < numberOfRoles; i++)
    //*  18   40:iconst_0        
    //*  19   41:istore_2        
    //*  20   42:goto            104
        {
            Vector upi = ((Role)roleSet.get(i)).getPerms();
    //   21   45:aload_0         
    //   22   46:getfield        #72  <Field Vector roleSet>
    //   23   49:iload_2         
    //   24   50:invokevirtual   #176 <Method Object Vector.get(int)>
    //   25   53:checkcast       #178 <Class CCRMimplement$Role>
    //   26   56:invokevirtual   #182 <Method Vector CCRMimplement$Role.getPerms()>
    //   27   59:astore_3        
            for(int j = 0; j < permissions.size(); j++)
    //*  28   60:iconst_0        
    //*  29   61:istore          4
    //*  30   63:goto            89
                if(upi.contains(Integer.valueOf(j)))
    //*  31   66:aload_3         
    //*  32   67:iload           4
    //*  33   69:invokestatic    #270 <Method Integer Integer.valueOf(int)>
    //*  34   72:invokevirtual   #273 <Method boolean Vector.contains(Object)>
    //*  35   75:ifeq            86
                    mat.set(i, j, (byte)1);
    //   36   78:aload_1         
    //   37   79:iload_2         
    //   38   80:iload           4
    //   39   82:iconst_1        
    //   40   83:invokevirtual   #648 <Method void Matrix.set(int, int, byte)>

    //   41   86:iinc            4  1
    //   42   89:iload           4
    //   43   91:aload_0         
    //   44   92:getfield        #64  <Field Vector permissions>
    //   45   95:invokevirtual   #141 <Method int Vector.size()>
    //   46   98:icmplt          66
        }

    //   47  101:iinc            2  1
    //   48  104:iload_2         
    //   49  105:getstatic       #46  <Field int numberOfRoles>
    //   50  108:icmplt          45
        m_assroles.setAssignmentMatrix(mat);
    //   51  111:aload_0         
    //   52  112:getfield        #637 <Field Assignment m_assroles>
    //   53  115:aload_1         
    //   54  116:invokevirtual   #651 <Method void Assignment.setAssignmentMatrix(Matrix)>
        FastVector fv = new FastVector();
    //   55  119:new             #537 <Class FastVector>
    //   56  122:dup             
    //   57  123:invokespecial   #652 <Method void FastVector()>
    //   58  126:astore_2        
        for(int i = 0; i < numberOfRoles; i++)
    //*  59  127:iconst_0        
    //*  60  128:istore_3        
    //*  61  129:goto            156
            fv.addElement((new StringBuilder("R")).append(i).toString());
    //   62  132:aload_2         
    //   63  133:new             #132 <Class StringBuilder>
    //   64  136:dup             
    //   65  137:ldc2            #543 <String "R">
    //   66  140:invokespecial   #137 <Method void StringBuilder(String)>
    //   67  143:iload_3         
    //   68  144:invokevirtual   #145 <Method StringBuilder StringBuilder.append(int)>
    //   69  147:invokevirtual   #154 <Method String StringBuilder.toString()>
    //   70  150:invokevirtual   #552 <Method void FastVector.addElement(Object)>

    //   71  153:iinc            3  1
    //   72  156:iload_3         
    //   73  157:getstatic       #46  <Field int numberOfRoles>
    //   74  160:icmplt          132
        Attribute dxa = new Attribute("role", fv);
    //   75  163:new             #457 <Class Attribute>
    //   76  166:dup             
    //   77  167:ldc2            #653 <String "role">
    //   78  170:aload_2         
    //   79  171:invokespecial   #656 <Method void Attribute(String, FastVector)>
    //   80  174:astore_3        
        Dimension dx = new Dimension();
    //   81  175:new             #103 <Class Dimension>
    //   82  178:dup             
    //   83  179:invokespecial   #657 <Method void Dimension()>
    //   84  182:astore          4
        dx.setDimensionAttribute(dxa);
    //   85  184:aload           4
    //   86  186:aload_3         
    //   87  187:invokevirtual   #661 <Method void Dimension.setDimensionAttribute(Attribute)>
        m_assroles.setDimensionX(dx);
    //   88  190:aload_0         
    //   89  191:getfield        #637 <Field Assignment m_assroles>
    //   90  194:aload           4
    //   91  196:invokevirtual   #665 <Method void Assignment.setDimensionX(Dimension)>
        Attribute dya = m_assignment.getDimensionY().getDimensionAttribute();
    //   92  199:aload_0         
    //   93  200:getfield        #91  <Field Assignment m_assignment>
    //   94  203:invokevirtual   #101 <Method Dimension Assignment.getDimensionY()>
    //   95  206:invokevirtual   #107 <Method Attribute Dimension.getDimensionAttribute()>
    //   96  209:astore          5
        Dimension dy = new Dimension();
    //   97  211:new             #103 <Class Dimension>
    //   98  214:dup             
    //   99  215:invokespecial   #657 <Method void Dimension()>
    //  100  218:astore          6
        dy.setDimensionAttribute(dya);
    //  101  220:aload           6
    //  102  222:aload           5
    //  103  224:invokevirtual   #661 <Method void Dimension.setDimensionAttribute(Attribute)>
        m_assroles.setDimensionY(dy);
    //  104  227:aload_0         
    //  105  228:getfield        #637 <Field Assignment m_assroles>
    //  106  231:aload           6
    //  107  233:invokevirtual   #668 <Method void Assignment.setDimensionY(Dimension)>
        return m_assroles;
    //  108  236:aload_0         
    //  109  237:getfield        #637 <Field Assignment m_assroles>
    //  110  240:areturn         
    }

    public double getPcc()
    {
        return pcc;
    //    0    0:aload_0         
    //    1    1:getfield        #396 <Field double pcc>
    //    2    4:dreturn         
    }

    public void setPcc(double pcc)
    {
        this.pcc = pcc;
    //    0    0:aload_0         
    //    1    1:dload_1         
    //    2    2:putfield        #396 <Field double pcc>
    //    3    5:return          
    }

    public double getUcc()
    {
        return ucc;
    //    0    0:aload_0         
    //    1    1:getfield        #388 <Field double ucc>
    //    2    4:dreturn         
    }

    public void setUcc(double ucc)
    {
        this.ucc = ucc;
    //    0    0:aload_0         
    //    1    1:dload_1         
    //    2    2:putfield        #388 <Field double ucc>
    //    3    5:return          
    }

    public int getWh()
    {
        return wh;
    //    0    0:aload_0         
    //    1    1:getfield        #215 <Field int wh>
    //    2    4:ireturn         
    }

    public void setWh(int wh)
    {
        this.wh = wh;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #215 <Field int wh>
    //    3    5:return          
    }

    public int getWp()
    {
        return wp;
    //    0    0:aload_0         
    //    1    1:getfield        #217 <Field int wp>
    //    2    4:ireturn         
    }

    public void setWp(int wp)
    {
        this.wp = wp;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #217 <Field int wp>
    //    3    5:return          
    }

    public int getWr()
    {
        return wr;
    //    0    0:aload_0         
    //    1    1:getfield        #213 <Field int wr>
    //    2    4:ireturn         
    }

    public void setWr(int wr)
    {
        this.wr = wr;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #213 <Field int wr>
    //    3    5:return          
    }

    public int getWu()
    {
        return wu;
    //    0    0:aload_0         
    //    1    1:getfield        #198 <Field int wu>
    //    2    4:ireturn         
    }

    public void setWu(int wu)
    {
        this.wu = wu;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #198 <Field int wu>
    //    3    5:return          
    }

    public String wrTipText()
    {
        return "The required weight of number of role for WSC.";
    //    0    0:ldc2            #693 <String "The required weight of number of role for WSC.">
    //    1    3:areturn         
    }

    public String wuTipText()
    {
        return "The required weight of number of user for WSC.";
    //    0    0:ldc2            #696 <String "The required weight of number of user for WSC.">
    //    1    3:areturn         
    }

    public String wpTipText()
    {
        return "The required weight of number of permission for WSC.";
    //    0    0:ldc2            #699 <String "The required weight of number of permission for WSC.">
    //    1    3:areturn         
    }

    public String whTipText()
    {
        return "The required weight of number of roles' hierarchy for WSC.";
    //    0    0:ldc2            #702 <String "The required weight of number of roles' hierarchy for WSC.">
    //    1    3:areturn         
    }

    public String uccTipText()
    {
        return "The required weight of number of user Constraint.";
    //    0    0:ldc2            #705 <String "The required weight of number of user Constraint.">
    //    1    3:areturn         
    }

    public String pccTipText()
    {
        return "The required weight of number of permission Constraint.";
    //    0    0:ldc2            #708 <String "The required weight of number of permission Constraint.">
    //    1    3:areturn         
    }

    private double ucc;
    private double pcc;
    private static int maxUser = 20;
    private int wr;
    private int wu;
    private int wp;
    private int wh;
    private int wsc;
    private int rh;
    private int ua;
    private int pa;
    private Vector permissions;
    private Vector users;
    private Vector userConstraint;
    private Vector permConstraint;
    public static int numberOfRoles = 0;
    private Vector roleSet;
    private Vector realRoles;
    private int roleLimits;
    private int permLimits;
    private Assignment m_assignment;
    private Assignment m_assroles;
    private StringBuffer log;

    static 
    {
    //    0    0:bipush          20
    //    1    2:putstatic       #44  <Field int maxUser>
    //    2    5:iconst_0        
    //    3    6:putstatic       #46  <Field int numberOfRoles>
    //*   4    9:return          
    }
}
