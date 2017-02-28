// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   WeightedRoleMining.java

package rm.rolemining;

import java.io.*;
import java.util.*;
import rm.core.*;
import rm.core.converters.AssLoader;

// Referenced classes of package rm.rolemining:
//            AbstractRoleminer

public class WeightedRoleMining extends AbstractRoleminer
    implements OptionHandler
{
    private class perm2Weight
        implements Comparable
    {

        public int getPerm()
        {
            return perm;
        //    0    0:aload_0         
        //    1    1:getfield        #28  <Field int perm>
        //    2    4:ireturn         
        }

        public int compareTo(Object object)
        {
            perm2Weight other = (perm2Weight)object;
        //    0    0:aload_1         
        //    1    1:checkcast       #2   <Class WeightedRoleMining$perm2Weight>
        //    2    4:astore_2        
            if(weight < other.weight)
        //*   3    5:aload_0         
        //*   4    6:getfield        #32  <Field double weight>
        //*   5    9:aload_2         
        //*   6   10:getfield        #32  <Field double weight>
        //*   7   13:dcmpg           
        //*   8   14:ifge            19
                return 1;
        //    9   17:iconst_1        
        //   10   18:ireturn         
            return weight != other.weight ? -1 : 0;
        //   11   19:aload_0         
        //   12   20:getfield        #32  <Field double weight>
        //   13   23:aload_2         
        //   14   24:getfield        #32  <Field double weight>
        //   15   27:dcmpl           
        //   16   28:ifne            33
        //   17   31:iconst_0        
        //   18   32:ireturn         
        //   19   33:iconst_m1       
        //   20   34:ireturn         
        }

        public void setPerm(int perm)
        {
            this.perm = perm;
        //    0    0:aload_0         
        //    1    1:iload_1         
        //    2    2:putfield        #28  <Field int perm>
        //    3    5:return          
        }

        public double getWeight()
        {
            return weight;
        //    0    0:aload_0         
        //    1    1:getfield        #32  <Field double weight>
        //    2    4:dreturn         
        }

        public void setWeight(double weight)
        {
            this.weight = weight;
        //    0    0:aload_0         
        //    1    1:dload_1         
        //    2    2:putfield        #32  <Field double weight>
        //    3    5:return          
        }

        private int perm;
        private double weight;
        final WeightedRoleMining this$0;

        perm2Weight()
        {
            this$0 = WeightedRoleMining.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #17  <Field WeightedRoleMining this$0>
//            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #20  <Method void Object()>
        //    5    9:return          
        }
    }

    public class FrequentNode
    {

        public Vector getPerm()
        {
            return perm;
        //    0    0:aload_0         
        //    1    1:getfield        #30  <Field Vector perm>
        //    2    4:areturn         
        }

        public void setPerm(Vector perm)
        {
            this.perm = perm;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #30  <Field Vector perm>
        //    3    5:return          
        }

        public Vector getPermUsers()
        {
            return permUsers;
        //    0    0:aload_0         
        //    1    1:getfield        #37  <Field Vector permUsers>
        //    2    4:areturn         
        }

        public void setPermUsers(Vector permUsers)
        {
            this.permUsers = permUsers;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #37  <Field Vector permUsers>
        //    3    5:return          
        }

        public double getWsfpi()
        {
            return wsfpi;
        //    0    0:aload_0         
        //    1    1:getfield        #42  <Field double wsfpi>
        //    2    4:dreturn         
        }

        public void setWsfpi(double wsfpi)
        {
            this.wsfpi = wsfpi;
        //    0    0:aload_0         
        //    1    1:dload_1         
        //    2    2:putfield        #42  <Field double wsfpi>
        //    3    5:return          
        }

        private Vector perm;
        private double wsfpi;
        private Vector permUsers;
        final WeightedRoleMining this$0;

        public FrequentNode()
        {
            this$0 = WeightedRoleMining.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #18  <Field WeightedRoleMining this$0>
//            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #21  <Method void Object()>
        //    5    9:return          
        }
    }

    public class CandidateNode
    {

        public CandidateNode copy()
        {
            CandidateNode clone = new CandidateNode();
        //    0    0:new             #2   <Class WeightedRoleMining$CandidateNode>
        //    1    3:dup             
        //    2    4:aload_0         
        //    3    5:getfield        #18  <Field WeightedRoleMining this$0>
        //    4    8:invokespecial   #29  <Method void WeightedRoleMining$CandidateNode(WeightedRoleMining)>
        //    5   11:astore_1        
            clone.perm = (Vector)perm.clone();
        //    6   12:aload_1         
        //    7   13:aload_0         
        //    8   14:getfield        #31  <Field Vector perm>
        //    9   17:invokevirtual   #37  <Method Object Vector.clone()>
        //   10   20:checkcast       #33  <Class Vector>
        //   11   23:putfield        #31  <Field Vector perm>
            clone.wsfpi = wsfpi;
        //   12   26:aload_1         
        //   13   27:aload_0         
        //   14   28:getfield        #39  <Field double wsfpi>
        //   15   31:putfield        #39  <Field double wsfpi>
            clone.permUsers = (Vector)permUsers.clone();
        //   16   34:aload_1         
        //   17   35:aload_0         
        //   18   36:getfield        #41  <Field Vector permUsers>
        //   19   39:invokevirtual   #37  <Method Object Vector.clone()>
        //   20   42:checkcast       #33  <Class Vector>
        //   21   45:putfield        #41  <Field Vector permUsers>
            return clone;
        //   22   48:aload_1         
        //   23   49:areturn         
        }

        public Vector getPerm()
        {
            return perm;
        //    0    0:aload_0         
        //    1    1:getfield        #31  <Field Vector perm>
        //    2    4:areturn         
        }

        public void setPerm(Vector perm)
        {
            this.perm = perm;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #31  <Field Vector perm>
        //    3    5:return          
        }

        public Vector getPermUsers()
        {
            return permUsers;
        //    0    0:aload_0         
        //    1    1:getfield        #41  <Field Vector permUsers>
        //    2    4:areturn         
        }

        public void setPermUsers(Vector permUsers)
        {
            this.permUsers = permUsers;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #41  <Field Vector permUsers>
        //    3    5:return          
        }

        public double getWsfpi()
        {
            return wsfpi;
        //    0    0:aload_0         
        //    1    1:getfield        #39  <Field double wsfpi>
        //    2    4:dreturn         
        }

        public void setWsfpi(double wsfpi)
        {
            this.wsfpi = wsfpi;
        //    0    0:aload_0         
        //    1    1:dload_1         
        //    2    2:putfield        #39  <Field double wsfpi>
        //    3    5:return          
        }

        private Vector perm;
        private double wsfpi;
        private Vector permUsers;
        final WeightedRoleMining this$0;

        public CandidateNode()
        {
            this$0 = WeightedRoleMining.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #18  <Field WeightedRoleMining this$0>
//            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #21  <Method void Object()>
        //    5    9:return          
        }
    }


    public WeightedRoleMining()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #44  <Method void AbstractRoleminer()>
        log = new StringBuffer();
    //    2    4:aload_0         
    //    3    5:new             #46  <Class StringBuffer>
    //    4    8:dup             
    //    5    9:invokespecial   #47  <Method void StringBuffer()>
    //    6   12:putfield        #49  <Field StringBuffer log>
        initalWeight = new Vector();
    //    7   15:aload_0         
    //    8   16:new             #51  <Class Vector>
    //    9   19:dup             
    //   10   20:invokespecial   #52  <Method void Vector()>
    //   11   23:putfield        #54  <Field Vector initalWeight>
        permissions = new Vector();
    //   12   26:aload_0         
    //   13   27:new             #51  <Class Vector>
    //   14   30:dup             
    //   15   31:invokespecial   #52  <Method void Vector()>
    //   16   34:putfield        #56  <Field Vector permissions>
        users = new Vector();
    //   17   37:aload_0         
    //   18   38:new             #51  <Class Vector>
    //   19   41:dup             
    //   20   42:invokespecial   #52  <Method void Vector()>
    //   21   45:putfield        #58  <Field Vector users>
        allP2W = new Vector();
    //   22   48:aload_0         
    //   23   49:new             #51  <Class Vector>
    //   24   52:dup             
    //   25   53:invokespecial   #52  <Method void Vector()>
    //   26   56:putfield        #60  <Field Vector allP2W>
        FrequentPerms = new Vector();
    //   27   59:aload_0         
    //   28   60:new             #51  <Class Vector>
    //   29   63:dup             
    //   30   64:invokespecial   #52  <Method void Vector()>
    //   31   67:putfield        #62  <Field Vector FrequentPerms>
        CandidatePerms = new Vector();
    //   32   70:aload_0         
    //   33   71:new             #51  <Class Vector>
    //   34   74:dup             
    //   35   75:invokespecial   #52  <Method void Vector()>
    //   36   78:putfield        #64  <Field Vector CandidatePerms>
        isOver = false;
    //   37   81:aload_0         
    //   38   82:iconst_0        
    //   39   83:putfield        #66  <Field boolean isOver>
        resetOptions();
    //   40   86:aload_0         
    //   41   87:invokevirtual   #69  <Method void resetOptions()>
    //   42   90:return          
    }

    public void buildRoleminers(Assignment data)
        throws Exception
    {
        m_assignment = data;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #78  <Field Assignment m_assignment>
        Matrix mat = data.getAssignmentMatrix();
    //    3    5:aload_1         
    //    4    6:invokevirtual   #84  <Method Matrix Assignment.getAssignmentMatrix()>
    //    5    9:astore_2        
        splitAttruteString(data.getDimensionY().getDimensionAttribute(), permissions);
    //    6   10:aload_0         
    //    7   11:aload_1         
    //    8   12:invokevirtual   #88  <Method Dimension Assignment.getDimensionY()>
    //    9   15:invokevirtual   #94  <Method Attribute Dimension.getDimensionAttribute()>
    //   10   18:aload_0         
    //   11   19:getfield        #56  <Field Vector permissions>
    //   12   22:invokespecial   #98  <Method void splitAttruteString(Attribute, Vector)>
        splitAttruteString(data.getDimensionX().getDimensionAttribute(), users);
    //   13   25:aload_0         
    //   14   26:aload_1         
    //   15   27:invokevirtual   #101 <Method Dimension Assignment.getDimensionX()>
    //   16   30:invokevirtual   #94  <Method Attribute Dimension.getDimensionAttribute()>
    //   17   33:aload_0         
    //   18   34:getfield        #58  <Field Vector users>
    //   19   37:invokespecial   #98  <Method void splitAttruteString(Attribute, Vector)>
        for(int index = 0; index < mat.getColumnDimension(); index++)
    //*  20   40:iconst_0        
    //*  21   41:istore_3        
    //*  22   42:goto            64
            initalWeight.add(index, new Double(0.0D));
    //   23   45:aload_0         
    //   24   46:getfield        #54  <Field Vector initalWeight>
    //   25   49:iload_3         
    //   26   50:new             #103 <Class Double>
    //   27   53:dup             
    //   28   54:dconst_0        
    //   29   55:invokespecial   #106 <Method void Double(double)>
    //   30   58:invokevirtual   #110 <Method void Vector.add(int, Object)>

    //   31   61:iinc            3  1
    //   32   64:iload_3         
    //   33   65:aload_2         
    //   34   66:invokevirtual   #116 <Method int Matrix.getColumnDimension()>
    //   35   69:icmplt          45
        initAllP2W(mat);
    //   36   72:aload_0         
    //   37   73:aload_2         
    //   38   74:invokespecial   #120 <Method void initAllP2W(Matrix)>
        Generate1FrePermission(mat);
    //   39   77:aload_0         
    //   40   78:aload_2         
    //   41   79:invokespecial   #123 <Method void Generate1FrePermission(Matrix)>
        FrequentPermssionGen(mat);
    //   42   82:aload_0         
    //   43   83:aload_2         
    //   44   84:invokespecial   #126 <Method void FrequentPermssionGen(Matrix)>
        generateRoleSet();
    //   45   87:aload_0         
    //   46   88:invokespecial   #129 <Method void generateRoleSet()>
    //   47   91:return          
    }

    private void generateRoleSet()
    {
        numberOfRoles = FrequentPerms.size();
    //    0    0:aload_0         
    //    1    1:getfield        #62  <Field Vector FrequentPerms>
    //    2    4:invokevirtual   #136 <Method int Vector.size()>
    //    3    7:putstatic       #39  <Field int numberOfRoles>
        log.append("\n--------------------------------------------------------------\n");
    //    4   10:aload_0         
    //    5   11:getfield        #49  <Field StringBuffer log>
    //    6   14:ldc1            #138 <String "\n--------------------------------------------------------------\n">
    //    7   16:invokevirtual   #142 <Method StringBuffer StringBuffer.append(String)>
    //    8   19:pop             
        for(int index = 0; index < numberOfRoles; index++)
    //*   9   20:iconst_0        
    //*  10   21:istore_1        
    //*  11   22:goto            390
        {
            log.append((new StringBuilder("The permissions of the ")).append(index).append("th role are:\n").toString());
    //   12   25:aload_0         
    //   13   26:getfield        #49  <Field StringBuffer log>
    //   14   29:new             #144 <Class StringBuilder>
    //   15   32:dup             
    //   16   33:ldc1            #146 <String "The permissions of the ">
    //   17   35:invokespecial   #149 <Method void StringBuilder(String)>
    //   18   38:iload_1         
    //   19   39:invokevirtual   #152 <Method StringBuilder StringBuilder.append(int)>
    //   20   42:ldc1            #154 <String "th role are:\n">
    //   21   44:invokevirtual   #157 <Method StringBuilder StringBuilder.append(String)>
    //   22   47:invokevirtual   #161 <Method String StringBuilder.toString()>
    //   23   50:invokevirtual   #142 <Method StringBuffer StringBuffer.append(String)>
    //   24   53:pop             
            Vector premSet = ((FrequentNode)FrequentPerms.get(index)).getPerm();
    //   25   54:aload_0         
    //   26   55:getfield        #62  <Field Vector FrequentPerms>
    //   27   58:iload_1         
    //   28   59:invokevirtual   #165 <Method Object Vector.get(int)>
    //   29   62:checkcast       #167 <Class WeightedRoleMining$FrequentNode>
    //   30   65:invokevirtual   #171 <Method Vector WeightedRoleMining$FrequentNode.getPerm()>
    //   31   68:astore_2        
            for(int jndex = 0; jndex < premSet.size(); jndex++)
    //*  32   69:iconst_0        
    //*  33   70:istore_3        
    //*  34   71:goto            184
                if(jndex != premSet.size() - 1)
    //*  35   74:iload_3         
    //*  36   75:aload_2         
    //*  37   76:invokevirtual   #136 <Method int Vector.size()>
    //*  38   79:iconst_1        
    //*  39   80:isub            
    //*  40   81:icmpeq          134
                    log.append((new StringBuilder(String.valueOf((String)permissions.get(((Integer)premSet.get(jndex)).intValue())))).append(",").toString());
    //   41   84:aload_0         
    //   42   85:getfield        #49  <Field StringBuffer log>
    //   43   88:new             #144 <Class StringBuilder>
    //   44   91:dup             
    //   45   92:aload_0         
    //   46   93:getfield        #56  <Field Vector permissions>
    //   47   96:aload_2         
    //   48   97:iload_3         
    //   49   98:invokevirtual   #165 <Method Object Vector.get(int)>
    //   50  101:checkcast       #173 <Class Integer>
    //   51  104:invokevirtual   #176 <Method int Integer.intValue()>
    //   52  107:invokevirtual   #165 <Method Object Vector.get(int)>
    //   53  110:checkcast       #178 <Class String>
    //   54  113:invokestatic    #182 <Method String String.valueOf(Object)>
    //   55  116:invokespecial   #149 <Method void StringBuilder(String)>
    //   56  119:ldc1            #184 <String ",">
    //   57  121:invokevirtual   #157 <Method StringBuilder StringBuilder.append(String)>
    //   58  124:invokevirtual   #161 <Method String StringBuilder.toString()>
    //   59  127:invokevirtual   #142 <Method StringBuffer StringBuffer.append(String)>
    //   60  130:pop             
                else
    //*  61  131:goto            181
                    log.append((new StringBuilder(String.valueOf((String)permissions.get(((Integer)premSet.get(jndex)).intValue())))).append("\n").toString());
    //   62  134:aload_0         
    //   63  135:getfield        #49  <Field StringBuffer log>
    //   64  138:new             #144 <Class StringBuilder>
    //   65  141:dup             
    //   66  142:aload_0         
    //   67  143:getfield        #56  <Field Vector permissions>
    //   68  146:aload_2         
    //   69  147:iload_3         
    //   70  148:invokevirtual   #165 <Method Object Vector.get(int)>
    //   71  151:checkcast       #173 <Class Integer>
    //   72  154:invokevirtual   #176 <Method int Integer.intValue()>
    //   73  157:invokevirtual   #165 <Method Object Vector.get(int)>
    //   74  160:checkcast       #178 <Class String>
    //   75  163:invokestatic    #182 <Method String String.valueOf(Object)>
    //   76  166:invokespecial   #149 <Method void StringBuilder(String)>
    //   77  169:ldc1            #186 <String "\n">
    //   78  171:invokevirtual   #157 <Method StringBuilder StringBuilder.append(String)>
    //   79  174:invokevirtual   #161 <Method String StringBuilder.toString()>
    //   80  177:invokevirtual   #142 <Method StringBuffer StringBuffer.append(String)>
    //   81  180:pop             

    //   82  181:iinc            3  1
    //   83  184:iload_3         
    //   84  185:aload_2         
    //   85  186:invokevirtual   #136 <Method int Vector.size()>
    //   86  189:icmplt          74
            log.append("The users are:\n");
    //   87  192:aload_0         
    //   88  193:getfield        #49  <Field StringBuffer log>
    //   89  196:ldc1            #188 <String "The users are:\n">
    //   90  198:invokevirtual   #142 <Method StringBuffer StringBuffer.append(String)>
    //   91  201:pop             
            Vector userSet = ((FrequentNode)FrequentPerms.get(index)).getPermUsers();
    //   92  202:aload_0         
    //   93  203:getfield        #62  <Field Vector FrequentPerms>
    //   94  206:iload_1         
    //   95  207:invokevirtual   #165 <Method Object Vector.get(int)>
    //   96  210:checkcast       #167 <Class WeightedRoleMining$FrequentNode>
    //   97  213:invokevirtual   #191 <Method Vector WeightedRoleMining$FrequentNode.getPermUsers()>
    //   98  216:astore_3        
            for(int jndex = 0; jndex < userSet.size(); jndex++)
    //*  99  217:iconst_0        
    //* 100  218:istore          4
    //* 101  220:goto            336
                if(jndex != userSet.size() - 1)
    //* 102  223:iload           4
    //* 103  225:aload_3         
    //* 104  226:invokevirtual   #136 <Method int Vector.size()>
    //* 105  229:iconst_1        
    //* 106  230:isub            
    //* 107  231:icmpeq          285
                    log.append((new StringBuilder(String.valueOf((String)users.get(((Integer)userSet.get(jndex)).intValue())))).append(",").toString());
    //  108  234:aload_0         
    //  109  235:getfield        #49  <Field StringBuffer log>
    //  110  238:new             #144 <Class StringBuilder>
    //  111  241:dup             
    //  112  242:aload_0         
    //  113  243:getfield        #58  <Field Vector users>
    //  114  246:aload_3         
    //  115  247:iload           4
    //  116  249:invokevirtual   #165 <Method Object Vector.get(int)>
    //  117  252:checkcast       #173 <Class Integer>
    //  118  255:invokevirtual   #176 <Method int Integer.intValue()>
    //  119  258:invokevirtual   #165 <Method Object Vector.get(int)>
    //  120  261:checkcast       #178 <Class String>
    //  121  264:invokestatic    #182 <Method String String.valueOf(Object)>
    //  122  267:invokespecial   #149 <Method void StringBuilder(String)>
    //  123  270:ldc1            #184 <String ",">
    //  124  272:invokevirtual   #157 <Method StringBuilder StringBuilder.append(String)>
    //  125  275:invokevirtual   #161 <Method String StringBuilder.toString()>
    //  126  278:invokevirtual   #142 <Method StringBuffer StringBuffer.append(String)>
    //  127  281:pop             
                else
    //* 128  282:goto            333
                    log.append((new StringBuilder(String.valueOf((String)users.get(((Integer)userSet.get(jndex)).intValue())))).append("\n").toString());
    //  129  285:aload_0         
    //  130  286:getfield        #49  <Field StringBuffer log>
    //  131  289:new             #144 <Class StringBuilder>
    //  132  292:dup             
    //  133  293:aload_0         
    //  134  294:getfield        #58  <Field Vector users>
    //  135  297:aload_3         
    //  136  298:iload           4
    //  137  300:invokevirtual   #165 <Method Object Vector.get(int)>
    //  138  303:checkcast       #173 <Class Integer>
    //  139  306:invokevirtual   #176 <Method int Integer.intValue()>
    //  140  309:invokevirtual   #165 <Method Object Vector.get(int)>
    //  141  312:checkcast       #178 <Class String>
    //  142  315:invokestatic    #182 <Method String String.valueOf(Object)>
    //  143  318:invokespecial   #149 <Method void StringBuilder(String)>
    //  144  321:ldc1            #186 <String "\n">
    //  145  323:invokevirtual   #157 <Method StringBuilder StringBuilder.append(String)>
    //  146  326:invokevirtual   #161 <Method String StringBuilder.toString()>
    //  147  329:invokevirtual   #142 <Method StringBuffer StringBuffer.append(String)>
    //  148  332:pop             

    //  149  333:iinc            4  1
    //  150  336:iload           4
    //  151  338:aload_3         
    //  152  339:invokevirtual   #136 <Method int Vector.size()>
    //  153  342:icmplt          223
            log.append((new StringBuilder("The weight is:")).append(((FrequentNode)FrequentPerms.get(index)).getWsfpi()).append("\n").toString());
    //  154  345:aload_0         
    //  155  346:getfield        #49  <Field StringBuffer log>
    //  156  349:new             #144 <Class StringBuilder>
    //  157  352:dup             
    //  158  353:ldc1            #193 <String "The weight is:">
    //  159  355:invokespecial   #149 <Method void StringBuilder(String)>
    //  160  358:aload_0         
    //  161  359:getfield        #62  <Field Vector FrequentPerms>
    //  162  362:iload_1         
    //  163  363:invokevirtual   #165 <Method Object Vector.get(int)>
    //  164  366:checkcast       #167 <Class WeightedRoleMining$FrequentNode>
    //  165  369:invokevirtual   #197 <Method double WeightedRoleMining$FrequentNode.getWsfpi()>
    //  166  372:invokevirtual   #200 <Method StringBuilder StringBuilder.append(double)>
    //  167  375:ldc1            #186 <String "\n">
    //  168  377:invokevirtual   #157 <Method StringBuilder StringBuilder.append(String)>
    //  169  380:invokevirtual   #161 <Method String StringBuilder.toString()>
    //  170  383:invokevirtual   #142 <Method StringBuffer StringBuffer.append(String)>
    //  171  386:pop             
        }

    //  172  387:iinc            1  1
    //  173  390:iload_1         
    //  174  391:getstatic       #39  <Field int numberOfRoles>
    //  175  394:icmplt          25
        log.append("--------------------------------------------------------------\n");
    //  176  397:aload_0         
    //  177  398:getfield        #49  <Field StringBuffer log>
    //  178  401:ldc1            #202 <String "--------------------------------------------------------------\n">
    //  179  403:invokevirtual   #142 <Method StringBuffer StringBuffer.append(String)>
    //  180  406:pop             
    //  181  407:return          
    }

    private void initAllP2W(Matrix mat)
    {
        int numberofPerms = mat.getColumnDimension();
    //    0    0:aload_1         
    //    1    1:invokevirtual   #116 <Method int Matrix.getColumnDimension()>
    //    2    4:istore_2        
        int numberOfUsers = mat.getRowDimension();
    //    3    5:aload_1         
    //    4    6:invokevirtual   #210 <Method int Matrix.getRowDimension()>
    //    5    9:istore_3        
        double AUR[][] = new double[numberOfUsers][numberOfUsers];
    //    6   10:iload_3         
    //    7   11:iload_3         
    //    8   12:multianewarray  double[][]
    //    9   16:astore          4
        for(int index = 0; index < numberOfUsers; index++)
    //*  10   18:iconst_0        
    //*  11   19:istore          5
    //*  12   21:goto            59
        {
            for(int jndex = 0; jndex < numberOfUsers; jndex++)
    //*  13   24:iconst_0        
    //*  14   25:istore          6
    //*  15   27:goto            50
                AUR[index][jndex] = getUserSimilarity(mat, index, jndex);
    //   16   30:aload           4
    //   17   32:iload           5
    //   18   34:aaload          
    //   19   35:iload           6
    //   20   37:aload_0         
    //   21   38:aload_1         
    //   22   39:iload           5
    //   23   41:iload           6
    //   24   43:invokespecial   #216 <Method double getUserSimilarity(Matrix, int, int)>
    //   25   46:dastore         

    //   26   47:iinc            6  1
    //   27   50:iload           6
    //   28   52:iload_3         
    //   29   53:icmplt          30
        }

    //   30   56:iinc            5  1
    //   31   59:iload           5
    //   32   61:iload_3         
    //   33   62:icmplt          24
        double APR[][] = new double[numberofPerms][numberofPerms];
    //   34   65:iload_2         
    //   35   66:iload_2         
    //   36   67:multianewarray  double[][]
    //   37   71:astore          5
        for(int index = 0; index < numberofPerms; index++)
    //*  38   73:iconst_0        
    //*  39   74:istore          6
    //*  40   76:goto            114
        {
            for(int jndex = 0; jndex < numberofPerms; jndex++)
    //*  41   79:iconst_0        
    //*  42   80:istore          7
    //*  43   82:goto            105
                APR[index][jndex] = getPermSimilarity(mat, index, jndex);
    //   44   85:aload           5
    //   45   87:iload           6
    //   46   89:aaload          
    //   47   90:iload           7
    //   48   92:aload_0         
    //   49   93:aload_1         
    //   50   94:iload           6
    //   51   96:iload           7
    //   52   98:invokespecial   #219 <Method double getPermSimilarity(Matrix, int, int)>
    //   53  101:dastore         

    //   54  102:iinc            7  1
    //   55  105:iload           7
    //   56  107:iload_2         
    //   57  108:icmplt          85
        }

    //   58  111:iinc            6  1
    //   59  114:iload           6
    //   60  116:iload_2         
    //   61  117:icmplt          79
        double NSM[][] = new double[numberOfUsers + numberofPerms][numberOfUsers + numberofPerms];
    //   62  120:iload_3         
    //   63  121:iload_2         
    //   64  122:iadd            
    //   65  123:iload_3         
    //   66  124:iload_2         
    //   67  125:iadd            
    //   68  126:multianewarray  double[][]
    //   69  130:astore          6
        for(int index = 0; index < numberOfUsers; index++)
    //*  70  132:iconst_0        
    //*  71  133:istore          7
    //*  72  135:goto            172
        {
            for(int jndex = 0; jndex < numberOfUsers; jndex++)
    //*  73  138:iconst_0        
    //*  74  139:istore          8
    //*  75  141:goto            163
                NSM[index][jndex] = AUR[index][jndex];
    //   76  144:aload           6
    //   77  146:iload           7
    //   78  148:aaload          
    //   79  149:iload           8
    //   80  151:aload           4
    //   81  153:iload           7
    //   82  155:aaload          
    //   83  156:iload           8
    //   84  158:daload          
    //   85  159:dastore         

    //   86  160:iinc            8  1
    //   87  163:iload           8
    //   88  165:iload_3         
    //   89  166:icmplt          144
        }

    //   90  169:iinc            7  1
    //   91  172:iload           7
    //   92  174:iload_3         
    //   93  175:icmplt          138
        for(int index = 0; index < numberOfUsers; index++)
    //*  94  178:iconst_0        
    //*  95  179:istore          7
    //*  96  181:goto            216
        {
            for(int jndex = numberOfUsers; jndex < numberOfUsers + numberofPerms; jndex++)
    //*  97  184:iload_3         
    //*  98  185:istore          8
    //*  99  187:goto            205
                NSM[index][jndex] = 1.0D / (double)numberofPerms;
    //  100  190:aload           6
    //  101  192:iload           7
    //  102  194:aaload          
    //  103  195:iload           8
    //  104  197:dconst_1        
    //  105  198:iload_2         
    //  106  199:i2d             
    //  107  200:ddiv            
    //  108  201:dastore         

    //  109  202:iinc            8  1
    //  110  205:iload           8
    //  111  207:iload_3         
    //  112  208:iload_2         
    //  113  209:iadd            
    //  114  210:icmplt          190
        }

    //  115  213:iinc            7  1
    //  116  216:iload           7
    //  117  218:iload_3         
    //  118  219:icmplt          184
        for(int index = numberOfUsers; index < numberOfUsers + numberofPerms; index++)
    //* 119  222:iload_3         
    //* 120  223:istore          7
    //* 121  225:goto            258
        {
            for(int jndex = 0; jndex < numberOfUsers; jndex++)
    //* 122  228:iconst_0        
    //* 123  229:istore          8
    //* 124  231:goto            249
                NSM[index][jndex] = 1.0D / (double)numberOfUsers;
    //  125  234:aload           6
    //  126  236:iload           7
    //  127  238:aaload          
    //  128  239:iload           8
    //  129  241:dconst_1        
    //  130  242:iload_3         
    //  131  243:i2d             
    //  132  244:ddiv            
    //  133  245:dastore         

    //  134  246:iinc            8  1
    //  135  249:iload           8
    //  136  251:iload_3         
    //  137  252:icmplt          234
        }

    //  138  255:iinc            7  1
    //  139  258:iload           7
    //  140  260:iload_3         
    //  141  261:iload_2         
    //  142  262:iadd            
    //  143  263:icmplt          228
        for(int index = numberOfUsers; index < numberOfUsers + numberofPerms; index++)
    //* 144  266:iload_3         
    //* 145  267:istore          7
    //* 146  269:goto            312
        {
            for(int jndex = numberOfUsers; jndex < numberOfUsers + numberofPerms; jndex++)
    //* 147  272:iload_3         
    //* 148  273:istore          8
    //* 149  275:goto            301
                NSM[index][jndex] = APR[index - numberOfUsers][jndex - numberOfUsers];
    //  150  278:aload           6
    //  151  280:iload           7
    //  152  282:aaload          
    //  153  283:iload           8
    //  154  285:aload           5
    //  155  287:iload           7
    //  156  289:iload_3         
    //  157  290:isub            
    //  158  291:aaload          
    //  159  292:iload           8
    //  160  294:iload_3         
    //  161  295:isub            
    //  162  296:daload          
    //  163  297:dastore         

    //  164  298:iinc            8  1
    //  165  301:iload           8
    //  166  303:iload_3         
    //  167  304:iload_2         
    //  168  305:iadd            
    //  169  306:icmplt          278
        }

    //  170  309:iinc            7  1
    //  171  312:iload           7
    //  172  314:iload_3         
    //  173  315:iload_2         
    //  174  316:iadd            
    //  175  317:icmplt          272
        double PRP[][] = new double[numberofPerms][numberofPerms];
    //  176  320:iload_2         
    //  177  321:iload_2         
    //  178  322:multianewarray  double[][]
    //  179  326:astore          7
        for(int index = 0; index < numberofPerms; index++)
    //* 180  328:iconst_0        
    //* 181  329:istore          8
    //* 182  331:goto            374
        {
            for(int jndex = 0; jndex < numberofPerms; jndex++)
    //* 183  334:iconst_0        
    //* 184  335:istore          9
    //* 185  337:goto            365
                PRP[index][jndex] = getPRP(NSM, APR, index, jndex, numberOfUsers, numberofPerms);
    //  186  340:aload           7
    //  187  342:iload           8
    //  188  344:aaload          
    //  189  345:iload           9
    //  190  347:aload_0         
    //  191  348:aload           6
    //  192  350:aload           5
    //  193  352:iload           8
    //  194  354:iload           9
    //  195  356:iload_3         
    //  196  357:iload_2         
    //  197  358:invokespecial   #223 <Method double getPRP(double[][], double[][], int, int, int, int)>
    //  198  361:dastore         

    //  199  362:iinc            9  1
    //  200  365:iload           9
    //  201  367:iload_2         
    //  202  368:icmplt          340
        }

    //  203  371:iinc            8  1
    //  204  374:iload           8
    //  205  376:iload_2         
    //  206  377:icmplt          334
        for(int index = 0; index < numberofPerms; index++)
    //* 207  380:iconst_0        
    //* 208  381:istore          8
    //* 209  383:goto            504
        {
            perm2Weight indexWeight = new perm2Weight();
    //  210  386:new             #225 <Class WeightedRoleMining$perm2Weight>
    //  211  389:dup             
    //  212  390:aload_0         
    //  213  391:invokespecial   #228 <Method void WeightedRoleMining$perm2Weight(WeightedRoleMining)>
    //  214  394:astore          9
            indexWeight.setPerm(index);
    //  215  396:aload           9
    //  216  398:iload           8
    //  217  400:invokevirtual   #232 <Method void WeightedRoleMining$perm2Weight.setPerm(int)>
            double wpi = 0.0D;
    //  218  403:dconst_0        
    //  219  404:dstore          10
            double sum = 0.0D;
    //  220  406:dconst_0        
    //  221  407:dstore          12
            for(int jndex = 0; jndex < numberofPerms; jndex++)
    //* 222  409:iconst_0        
    //* 223  410:istore          14
    //* 224  412:goto            438
                if(jndex != index)
    //* 225  415:iload           14
    //* 226  417:iload           8
    //* 227  419:icmpeq          435
                    sum += PRP[index][jndex];
    //  228  422:dload           12
    //  229  424:aload           7
    //  230  426:iload           8
    //  231  428:aaload          
    //  232  429:iload           14
    //  233  431:daload          
    //  234  432:dadd            
    //  235  433:dstore          12

    //  236  435:iinc            14  1
    //  237  438:iload           14
    //  238  440:iload_2         
    //  239  441:icmplt          415
            sum /= numberofPerms - 1;
    //  240  444:dload           12
    //  241  446:iload_2         
    //  242  447:iconst_1        
    //  243  448:isub            
    //  244  449:i2d             
    //  245  450:ddiv            
    //  246  451:dstore          12
            wpi = r * sum + o * ((Double)initalWeight.get(index)).doubleValue();
    //  247  453:aload_0         
    //  248  454:getfield        #234 <Field double r>
    //  249  457:dload           12
    //  250  459:dmul            
    //  251  460:aload_0         
    //  252  461:getfield        #236 <Field double o>
    //  253  464:aload_0         
    //  254  465:getfield        #54  <Field Vector initalWeight>
    //  255  468:iload           8
    //  256  470:invokevirtual   #165 <Method Object Vector.get(int)>
    //  257  473:checkcast       #103 <Class Double>
    //  258  476:invokevirtual   #239 <Method double Double.doubleValue()>
    //  259  479:dmul            
    //  260  480:dadd            
    //  261  481:dstore          10
            indexWeight.setWeight(wpi);
    //  262  483:aload           9
    //  263  485:dload           10
    //  264  487:invokevirtual   #242 <Method void WeightedRoleMining$perm2Weight.setWeight(double)>
            allP2W.add(index, indexWeight);
    //  265  490:aload_0         
    //  266  491:getfield        #60  <Field Vector allP2W>
    //  267  494:iload           8
    //  268  496:aload           9
    //  269  498:invokevirtual   #110 <Method void Vector.add(int, Object)>
        }

    //  270  501:iinc            8  1
    //  271  504:iload           8
    //  272  506:iload_2         
    //  273  507:icmplt          386
    //  274  510:return          
    }

    private void Generate1FrePermission(Matrix mat)
    {
        int N = mat.getColumnDimension();
    //    0    0:aload_1         
    //    1    1:invokevirtual   #116 <Method int Matrix.getColumnDimension()>
    //    2    4:istore_2        
        int M = mat.getRowDimension();
    //    3    5:aload_1         
    //    4    6:invokevirtual   #210 <Method int Matrix.getRowDimension()>
    //    5    9:istore_3        
        for(int index = 0; index < N; index++)
    //*   6   10:iconst_0        
    //*   7   11:istore          4
    //*   8   13:goto            480
        {
            double wpindex = 0.0D;
    //    9   16:dconst_0        
    //   10   17:dstore          5
            for(Iterator iterator = allP2W.iterator(); iterator.hasNext();)
    //*  11   19:aload_0         
    //*  12   20:getfield        #60  <Field Vector allP2W>
    //*  13   23:invokevirtual   #256 <Method Iterator Vector.iterator()>
    //*  14   26:astore          8
    //*  15   28:goto            60
            {
                perm2Weight mem = (perm2Weight)iterator.next();
    //   16   31:aload           8
    //   17   33:invokeinterface #262 <Method Object Iterator.next()>
    //   18   38:checkcast       #225 <Class WeightedRoleMining$perm2Weight>
    //   19   41:astore          7
                if(mem.getPerm() == index)
    //*  20   43:aload           7
    //*  21   45:invokevirtual   #264 <Method int WeightedRoleMining$perm2Weight.getPerm()>
    //*  22   48:iload           4
    //*  23   50:icmpne          60
                    wpindex = mem.getWeight();
    //   24   53:aload           7
    //   25   55:invokevirtual   #267 <Method double WeightedRoleMining$perm2Weight.getWeight()>
    //   26   58:dstore          5
            }

    //   27   60:aload           8
    //   28   62:invokeinterface #271 <Method boolean Iterator.hasNext()>
    //   29   67:ifne            31
            Vector numUsersPindex = new Vector();
    //   30   70:new             #51  <Class Vector>
    //   31   73:dup             
    //   32   74:invokespecial   #52  <Method void Vector()>
    //   33   77:astore          7
            for(int jndex = 0; jndex < M; jndex++)
    //*  34   79:iconst_0        
    //*  35   80:istore          8
    //*  36   82:goto            111
                if(mat.get(jndex, index) == 1)
    //*  37   85:aload_1         
    //*  38   86:iload           8
    //*  39   88:iload           4
    //*  40   90:invokevirtual   #274 <Method byte Matrix.get(int, int)>
    //*  41   93:iconst_1        
    //*  42   94:icmpne          108
                    numUsersPindex.add(Integer.valueOf(jndex));
    //   43   97:aload           7
    //   44   99:iload           8
    //   45  101:invokestatic    #277 <Method Integer Integer.valueOf(int)>
    //   46  104:invokevirtual   #280 <Method boolean Vector.add(Object)>
    //   47  107:pop             

    //   48  108:iinc            8  1
    //   49  111:iload           8
    //   50  113:iload_3         
    //   51  114:icmplt          85
            double wsfpindex = (wpindex * (double)numUsersPindex.size()) / (double)M;
    //   52  117:dload           5
    //   53  119:aload           7
    //   54  121:invokevirtual   #136 <Method int Vector.size()>
    //   55  124:i2d             
    //   56  125:dmul            
    //   57  126:iload_3         
    //   58  127:i2d             
    //   59  128:ddiv            
    //   60  129:dstore          8
            Vector perms = new Vector();
    //   61  131:new             #51  <Class Vector>
    //   62  134:dup             
    //   63  135:invokespecial   #52  <Method void Vector()>
    //   64  138:astore          10
            perms.add(Integer.valueOf(index));
    //   65  140:aload           10
    //   66  142:iload           4
    //   67  144:invokestatic    #277 <Method Integer Integer.valueOf(int)>
    //   68  147:invokevirtual   #280 <Method boolean Vector.add(Object)>
    //   69  150:pop             
            if(wsfpindex >= wminsup)
    //*  70  151:dload           8
    //*  71  153:aload_0         
    //*  72  154:getfield        #282 <Field double wminsup>
    //*  73  157:dcmpl           
    //*  74  158:iflt            275
            {
                FrequentNode fn = new FrequentNode();
    //   75  161:new             #167 <Class WeightedRoleMining$FrequentNode>
    //   76  164:dup             
    //   77  165:aload_0         
    //   78  166:invokespecial   #283 <Method void WeightedRoleMining$FrequentNode(WeightedRoleMining)>
    //   79  169:astore          11
                fn.setPerm(perms);
    //   80  171:aload           11
    //   81  173:aload           10
    //   82  175:invokevirtual   #286 <Method void WeightedRoleMining$FrequentNode.setPerm(Vector)>
                fn.setPermUsers(numUsersPindex);
    //   83  178:aload           11
    //   84  180:aload           7
    //   85  182:invokevirtual   #289 <Method void WeightedRoleMining$FrequentNode.setPermUsers(Vector)>
                fn.setWsfpi(wsfpindex);
    //   86  185:aload           11
    //   87  187:dload           8
    //   88  189:invokevirtual   #292 <Method void WeightedRoleMining$FrequentNode.setWsfpi(double)>
                log.append((new StringBuilder(String.valueOf(wsfpindex))).append("into F and C\n").toString());
    //   89  192:aload_0         
    //   90  193:getfield        #49  <Field StringBuffer log>
    //   91  196:new             #144 <Class StringBuilder>
    //   92  199:dup             
    //   93  200:dload           8
    //   94  202:invokestatic    #295 <Method String String.valueOf(double)>
    //   95  205:invokespecial   #149 <Method void StringBuilder(String)>
    //   96  208:ldc2            #297 <String "into F and C\n">
    //   97  211:invokevirtual   #157 <Method StringBuilder StringBuilder.append(String)>
    //   98  214:invokevirtual   #161 <Method String StringBuilder.toString()>
    //   99  217:invokevirtual   #142 <Method StringBuffer StringBuffer.append(String)>
    //  100  220:pop             
                FrequentPerms.add(fn);
    //  101  221:aload_0         
    //  102  222:getfield        #62  <Field Vector FrequentPerms>
    //  103  225:aload           11
    //  104  227:invokevirtual   #280 <Method boolean Vector.add(Object)>
    //  105  230:pop             
                CandidateNode cn = new CandidateNode();
    //  106  231:new             #299 <Class WeightedRoleMining$CandidateNode>
    //  107  234:dup             
    //  108  235:aload_0         
    //  109  236:invokespecial   #300 <Method void WeightedRoleMining$CandidateNode(WeightedRoleMining)>
    //  110  239:astore          12
                cn.setPerm(perms);
    //  111  241:aload           12
    //  112  243:aload           10
    //  113  245:invokevirtual   #301 <Method void WeightedRoleMining$CandidateNode.setPerm(Vector)>
                cn.setPermUsers(numUsersPindex);
    //  114  248:aload           12
    //  115  250:aload           7
    //  116  252:invokevirtual   #302 <Method void WeightedRoleMining$CandidateNode.setPermUsers(Vector)>
                cn.setWsfpi(wsfpindex);
    //  117  255:aload           12
    //  118  257:dload           8
    //  119  259:invokevirtual   #303 <Method void WeightedRoleMining$CandidateNode.setWsfpi(double)>
                CandidatePerms.add(cn);
    //  120  262:aload_0         
    //  121  263:getfield        #64  <Field Vector CandidatePerms>
    //  122  266:aload           12
    //  123  268:invokevirtual   #280 <Method boolean Vector.add(Object)>
    //  124  271:pop             
            } else
    //* 125  272:goto            477
            {
                Vector tempAllP2W = (Vector)allP2W.clone();
    //  126  275:aload_0         
    //  127  276:getfield        #60  <Field Vector allP2W>
    //  128  279:invokevirtual   #306 <Method Object Vector.clone()>
    //  129  282:checkcast       #51  <Class Vector>
    //  130  285:astore          11
                for(int jndex = 0; jndex < tempAllP2W.size(); jndex++)
    //* 131  287:iconst_0        
    //* 132  288:istore          12
    //* 133  290:goto            322
                    if(((perm2Weight)tempAllP2W.get(jndex)).getPerm() == index)
    //* 134  293:aload           11
    //* 135  295:iload           12
    //* 136  297:invokevirtual   #165 <Method Object Vector.get(int)>
    //* 137  300:checkcast       #225 <Class WeightedRoleMining$perm2Weight>
    //* 138  303:invokevirtual   #264 <Method int WeightedRoleMining$perm2Weight.getPerm()>
    //* 139  306:iload           4
    //* 140  308:icmpne          319
                        tempAllP2W.remove(jndex);
    //  141  311:aload           11
    //  142  313:iload           12
    //  143  315:invokevirtual   #309 <Method Object Vector.remove(int)>
    //  144  318:pop             

    //  145  319:iinc            12  1
    //  146  322:iload           12
    //  147  324:aload           11
    //  148  326:invokevirtual   #136 <Method int Vector.size()>
    //  149  329:icmplt          293
                Collections.sort(tempAllP2W);
    //  150  332:aload           11
    //  151  334:invokestatic    #315 <Method void Collections.sort(java.util.List)>
                double maxWeight = wpindex;
    //  152  337:dload           5
    //  153  339:dstore          12
                for(int jndex = 1; jndex <= tempAllP2W.size(); jndex++)
    //* 154  341:iconst_1        
    //* 155  342:istore          14
    //* 156  344:goto            467
                {
                    maxWeight += ((perm2Weight)tempAllP2W.get(jndex - 1)).getWeight();
    //  157  347:dload           12
    //  158  349:aload           11
    //  159  351:iload           14
    //  160  353:iconst_1        
    //  161  354:isub            
    //  162  355:invokevirtual   #165 <Method Object Vector.get(int)>
    //  163  358:checkcast       #225 <Class WeightedRoleMining$perm2Weight>
    //  164  361:invokevirtual   #267 <Method double WeightedRoleMining$perm2Weight.getWeight()>
    //  165  364:dadd            
    //  166  365:dstore          12
                    double minnumUsersPi = (wminsup * (double)N) / maxWeight;
    //  167  367:aload_0         
    //  168  368:getfield        #282 <Field double wminsup>
    //  169  371:iload_2         
    //  170  372:i2d             
    //  171  373:dmul            
    //  172  374:dload           12
    //  173  376:ddiv            
    //  174  377:dstore          15
                    if((double)numUsersPindex.size() < minnumUsersPi)
                        continue;
    //  175  379:aload           7
    //  176  381:invokevirtual   #136 <Method int Vector.size()>
    //  177  384:i2d             
    //  178  385:dload           15
    //  179  387:dcmpl           
    //  180  388:iflt            464
                    CandidateNode cn = new CandidateNode();
    //  181  391:new             #299 <Class WeightedRoleMining$CandidateNode>
    //  182  394:dup             
    //  183  395:aload_0         
    //  184  396:invokespecial   #300 <Method void WeightedRoleMining$CandidateNode(WeightedRoleMining)>
    //  185  399:astore          17
                    cn.setPerm(perms);
    //  186  401:aload           17
    //  187  403:aload           10
    //  188  405:invokevirtual   #301 <Method void WeightedRoleMining$CandidateNode.setPerm(Vector)>
                    cn.setPermUsers(numUsersPindex);
    //  189  408:aload           17
    //  190  410:aload           7
    //  191  412:invokevirtual   #302 <Method void WeightedRoleMining$CandidateNode.setPermUsers(Vector)>
                    cn.setWsfpi(wsfpindex);
    //  192  415:aload           17
    //  193  417:dload           8
    //  194  419:invokevirtual   #303 <Method void WeightedRoleMining$CandidateNode.setWsfpi(double)>
                    log.append((new StringBuilder(String.valueOf(wsfpindex))).append("into C\n").toString());
    //  195  422:aload_0         
    //  196  423:getfield        #49  <Field StringBuffer log>
    //  197  426:new             #144 <Class StringBuilder>
    //  198  429:dup             
    //  199  430:dload           8
    //  200  432:invokestatic    #295 <Method String String.valueOf(double)>
    //  201  435:invokespecial   #149 <Method void StringBuilder(String)>
    //  202  438:ldc2            #317 <String "into C\n">
    //  203  441:invokevirtual   #157 <Method StringBuilder StringBuilder.append(String)>
    //  204  444:invokevirtual   #161 <Method String StringBuilder.toString()>
    //  205  447:invokevirtual   #142 <Method StringBuffer StringBuffer.append(String)>
    //  206  450:pop             
                    CandidatePerms.add(cn);
    //  207  451:aload_0         
    //  208  452:getfield        #64  <Field Vector CandidatePerms>
    //  209  455:aload           17
    //  210  457:invokevirtual   #280 <Method boolean Vector.add(Object)>
    //  211  460:pop             
                    break;
    //  212  461:goto            477
                }

    //  213  464:iinc            14  1
    //  214  467:iload           14
    //  215  469:aload           11
    //  216  471:invokevirtual   #136 <Method int Vector.size()>
    //  217  474:icmple          347
            }
        }

    //  218  477:iinc            4  1
    //  219  480:iload           4
    //  220  482:iload_2         
    //  221  483:icmplt          16
    //  222  486:return          
    }

    private void FrequentPermssionGen(Matrix mat)
    {
        for(int k = 2; !isOver && k <= mat.getColumnDimension(); k++)
    //*   0    0:iconst_2        
    //*   1    1:istore_2        
    //*   2    2:goto            632
        {
            isOver = true;
    //    3    5:aload_0         
    //    4    6:iconst_1        
    //    5    7:putfield        #66  <Field boolean isOver>
            Vector kSubtract1ItemSet = new Vector();
    //    6   10:new             #51  <Class Vector>
    //    7   13:dup             
    //    8   14:invokespecial   #52  <Method void Vector()>
    //    9   17:astore_3        
            for(Iterator iterator = CandidatePerms.iterator(); iterator.hasNext();)
    //*  10   18:aload_0         
    //*  11   19:getfield        #64  <Field Vector CandidatePerms>
    //*  12   22:invokevirtual   #256 <Method Iterator Vector.iterator()>
    //*  13   25:astore          5
    //*  14   27:goto            66
            {
                CandidateNode mem = (CandidateNode)iterator.next();
    //   15   30:aload           5
    //   16   32:invokeinterface #262 <Method Object Iterator.next()>
    //   17   37:checkcast       #299 <Class WeightedRoleMining$CandidateNode>
    //   18   40:astore          4
                if(mem.getPerm().size() == k - 1)
    //*  19   42:aload           4
    //*  20   44:invokevirtual   #332 <Method Vector WeightedRoleMining$CandidateNode.getPerm()>
    //*  21   47:invokevirtual   #136 <Method int Vector.size()>
    //*  22   50:iload_2         
    //*  23   51:iconst_1        
    //*  24   52:isub            
    //*  25   53:icmpne          66
                    kSubtract1ItemSet.add(mem.copy());
    //   26   56:aload_3         
    //   27   57:aload           4
    //   28   59:invokevirtual   #336 <Method WeightedRoleMining$CandidateNode WeightedRoleMining$CandidateNode.copy()>
    //   29   62:invokevirtual   #280 <Method boolean Vector.add(Object)>
    //   30   65:pop             
            }

    //   31   66:aload           5
    //   32   68:invokeinterface #271 <Method boolean Iterator.hasNext()>
    //   33   73:ifne            30
            int size = kSubtract1ItemSet.size();
    //   34   76:aload_3         
    //   35   77:invokevirtual   #136 <Method int Vector.size()>
    //   36   80:istore          4
            for(int index = 0; index < size - 1; index++)
    //*  37   82:iconst_0        
    //*  38   83:istore          5
    //*  39   85:goto            620
            {
                for(int jndex = index + 1; jndex < size; jndex++)
    //*  40   88:iload           5
    //*  41   90:iconst_1        
    //*  42   91:iadd            
    //*  43   92:istore          6
    //*  44   94:goto            610
                    if(haskSubtract2SamePerms((CandidateNode)kSubtract1ItemSet.get(index), (CandidateNode)kSubtract1ItemSet.get(jndex), k))
    //*  45   97:aload_0         
    //*  46   98:aload_3         
    //*  47   99:iload           5
    //*  48  101:invokevirtual   #165 <Method Object Vector.get(int)>
    //*  49  104:checkcast       #299 <Class WeightedRoleMining$CandidateNode>
    //*  50  107:aload_3         
    //*  51  108:iload           6
    //*  52  110:invokevirtual   #165 <Method Object Vector.get(int)>
    //*  53  113:checkcast       #299 <Class WeightedRoleMining$CandidateNode>
    //*  54  116:iload_2         
    //*  55  117:invokespecial   #340 <Method boolean haskSubtract2SamePerms(WeightedRoleMining$CandidateNode, WeightedRoleMining$CandidateNode, int)>
    //*  56  120:ifeq            607
                    {
                        Vector kitemSet = (Vector)((CandidateNode)kSubtract1ItemSet.get(index)).getPerm().clone();
    //   57  123:aload_3         
    //   58  124:iload           5
    //   59  126:invokevirtual   #165 <Method Object Vector.get(int)>
    //   60  129:checkcast       #299 <Class WeightedRoleMining$CandidateNode>
    //   61  132:invokevirtual   #332 <Method Vector WeightedRoleMining$CandidateNode.getPerm()>
    //   62  135:invokevirtual   #306 <Method Object Vector.clone()>
    //   63  138:checkcast       #51  <Class Vector>
    //   64  141:astore          7
                        kitemSet.add((Integer)((CandidateNode)kSubtract1ItemSet.get(jndex)).getPerm().get(k - 2));
    //   65  143:aload           7
    //   66  145:aload_3         
    //   67  146:iload           6
    //   68  148:invokevirtual   #165 <Method Object Vector.get(int)>
    //   69  151:checkcast       #299 <Class WeightedRoleMining$CandidateNode>
    //   70  154:invokevirtual   #332 <Method Vector WeightedRoleMining$CandidateNode.getPerm()>
    //   71  157:iload_2         
    //   72  158:iconst_2        
    //   73  159:isub            
    //   74  160:invokevirtual   #165 <Method Object Vector.get(int)>
    //   75  163:checkcast       #173 <Class Integer>
    //   76  166:invokevirtual   #280 <Method boolean Vector.add(Object)>
    //   77  169:pop             
                        Collections.sort(kitemSet);
    //   78  170:aload           7
    //   79  172:invokestatic    #315 <Method void Collections.sort(java.util.List)>
                        Vector XYPermUsers = getIntersection(((CandidateNode)kSubtract1ItemSet.get(index)).getPermUsers(), ((CandidateNode)kSubtract1ItemSet.get(jndex)).getPermUsers());
    //   80  175:aload_0         
    //   81  176:aload_3         
    //   82  177:iload           5
    //   83  179:invokevirtual   #165 <Method Object Vector.get(int)>
    //   84  182:checkcast       #299 <Class WeightedRoleMining$CandidateNode>
    //   85  185:invokevirtual   #341 <Method Vector WeightedRoleMining$CandidateNode.getPermUsers()>
    //   86  188:aload_3         
    //   87  189:iload           6
    //   88  191:invokevirtual   #165 <Method Object Vector.get(int)>
    //   89  194:checkcast       #299 <Class WeightedRoleMining$CandidateNode>
    //   90  197:invokevirtual   #341 <Method Vector WeightedRoleMining$CandidateNode.getPermUsers()>
    //   91  200:invokespecial   #345 <Method Vector getIntersection(Vector, Vector)>
    //   92  203:astore          8
                        Collections.sort(XYPermUsers);
    //   93  205:aload           8
    //   94  207:invokestatic    #315 <Method void Collections.sort(java.util.List)>
                        double wxy = calculateComWeight(kitemSet);
    //   95  210:aload_0         
    //   96  211:aload           7
    //   97  213:invokespecial   #349 <Method double calculateComWeight(Vector)>
    //   98  216:dstore          9
                        double wsfxy = (wxy * (double)XYPermUsers.size()) / (double)mat.getRowDimension();
    //   99  218:dload           9
    //  100  220:aload           8
    //  101  222:invokevirtual   #136 <Method int Vector.size()>
    //  102  225:i2d             
    //  103  226:dmul            
    //  104  227:aload_1         
    //  105  228:invokevirtual   #210 <Method int Matrix.getRowDimension()>
    //  106  231:i2d             
    //  107  232:ddiv            
    //  108  233:dstore          11
                        if(wsfxy >= wminsup)
    //* 109  235:dload           11
    //* 110  237:aload_0         
    //* 111  238:getfield        #282 <Field double wminsup>
    //* 112  241:dcmpl           
    //* 113  242:iflt            364
                        {
                            FrequentNode fn = new FrequentNode();
    //  114  245:new             #167 <Class WeightedRoleMining$FrequentNode>
    //  115  248:dup             
    //  116  249:aload_0         
    //  117  250:invokespecial   #283 <Method void WeightedRoleMining$FrequentNode(WeightedRoleMining)>
    //  118  253:astore          13
                            fn.setPerm(kitemSet);
    //  119  255:aload           13
    //  120  257:aload           7
    //  121  259:invokevirtual   #286 <Method void WeightedRoleMining$FrequentNode.setPerm(Vector)>
                            fn.setPermUsers(XYPermUsers);
    //  122  262:aload           13
    //  123  264:aload           8
    //  124  266:invokevirtual   #289 <Method void WeightedRoleMining$FrequentNode.setPermUsers(Vector)>
                            fn.setWsfpi(wsfxy);
    //  125  269:aload           13
    //  126  271:dload           11
    //  127  273:invokevirtual   #292 <Method void WeightedRoleMining$FrequentNode.setWsfpi(double)>
                            log.append((new StringBuilder()).append(kitemSet).append("   into F and C\n").toString());
    //  128  276:aload_0         
    //  129  277:getfield        #49  <Field StringBuffer log>
    //  130  280:new             #144 <Class StringBuilder>
    //  131  283:dup             
    //  132  284:invokespecial   #350 <Method void StringBuilder()>
    //  133  287:aload           7
    //  134  289:invokevirtual   #353 <Method StringBuilder StringBuilder.append(Object)>
    //  135  292:ldc2            #355 <String "   into F and C\n">
    //  136  295:invokevirtual   #157 <Method StringBuilder StringBuilder.append(String)>
    //  137  298:invokevirtual   #161 <Method String StringBuilder.toString()>
    //  138  301:invokevirtual   #142 <Method StringBuffer StringBuffer.append(String)>
    //  139  304:pop             
                            FrequentPerms.add(fn);
    //  140  305:aload_0         
    //  141  306:getfield        #62  <Field Vector FrequentPerms>
    //  142  309:aload           13
    //  143  311:invokevirtual   #280 <Method boolean Vector.add(Object)>
    //  144  314:pop             
                            CandidateNode cn = new CandidateNode();
    //  145  315:new             #299 <Class WeightedRoleMining$CandidateNode>
    //  146  318:dup             
    //  147  319:aload_0         
    //  148  320:invokespecial   #300 <Method void WeightedRoleMining$CandidateNode(WeightedRoleMining)>
    //  149  323:astore          14
                            cn.setPerm(kitemSet);
    //  150  325:aload           14
    //  151  327:aload           7
    //  152  329:invokevirtual   #301 <Method void WeightedRoleMining$CandidateNode.setPerm(Vector)>
                            cn.setPermUsers(XYPermUsers);
    //  153  332:aload           14
    //  154  334:aload           8
    //  155  336:invokevirtual   #302 <Method void WeightedRoleMining$CandidateNode.setPermUsers(Vector)>
                            cn.setWsfpi(wsfxy);
    //  156  339:aload           14
    //  157  341:dload           11
    //  158  343:invokevirtual   #303 <Method void WeightedRoleMining$CandidateNode.setWsfpi(double)>
                            CandidatePerms.add(cn);
    //  159  346:aload_0         
    //  160  347:getfield        #64  <Field Vector CandidatePerms>
    //  161  350:aload           14
    //  162  352:invokevirtual   #280 <Method boolean Vector.add(Object)>
    //  163  355:pop             
                            isOver = false;
    //  164  356:aload_0         
    //  165  357:iconst_0        
    //  166  358:putfield        #66  <Field boolean isOver>
                        } else
    //* 167  361:goto            607
                        {
                            Vector kSubtract1PermWeight = new Vector();
    //  168  364:new             #51  <Class Vector>
    //  169  367:dup             
    //  170  368:invokespecial   #52  <Method void Vector()>
    //  171  371:astore          13
                            for(int kndex = 0; kndex < size; kndex++)
    //* 172  373:iconst_0        
    //* 173  374:istore          14
    //* 174  376:goto            417
                                if(kndex != index && kndex != jndex)
    //* 175  379:iload           14
    //* 176  381:iload           5
    //* 177  383:icmpeq          414
    //* 178  386:iload           14
    //* 179  388:iload           6
    //* 180  390:icmpeq          414
                                    kSubtract1PermWeight.add(Double.valueOf(((CandidateNode)kSubtract1ItemSet.get(kndex)).getWsfpi()));
    //  181  393:aload           13
    //  182  395:aload_3         
    //  183  396:iload           14
    //  184  398:invokevirtual   #165 <Method Object Vector.get(int)>
    //  185  401:checkcast       #299 <Class WeightedRoleMining$CandidateNode>
    //  186  404:invokevirtual   #356 <Method double WeightedRoleMining$CandidateNode.getWsfpi()>
    //  187  407:invokestatic    #359 <Method Double Double.valueOf(double)>
    //  188  410:invokevirtual   #280 <Method boolean Vector.add(Object)>
    //  189  413:pop             

    //  190  414:iinc            14  1
    //  191  417:iload           14
    //  192  419:iload           4
    //  193  421:icmplt          379
                            java.util.Comparator comp = Collections.reverseOrder();
    //  194  424:invokestatic    #363 <Method java.util.Comparator Collections.reverseOrder()>
    //  195  427:astore          14
                            Collections.sort(kSubtract1PermWeight, comp);
    //  196  429:aload           13
    //  197  431:aload           14
    //  198  433:invokestatic    #366 <Method void Collections.sort(java.util.List, java.util.Comparator)>
                            double maxWeight = ((CandidateNode)kSubtract1ItemSet.get(index)).getWsfpi() + ((CandidateNode)kSubtract1ItemSet.get(jndex)).getWsfpi();
    //  199  436:aload_3         
    //  200  437:iload           5
    //  201  439:invokevirtual   #165 <Method Object Vector.get(int)>
    //  202  442:checkcast       #299 <Class WeightedRoleMining$CandidateNode>
    //  203  445:invokevirtual   #356 <Method double WeightedRoleMining$CandidateNode.getWsfpi()>
    //  204  448:aload_3         
    //  205  449:iload           6
    //  206  451:invokevirtual   #165 <Method Object Vector.get(int)>
    //  207  454:checkcast       #299 <Class WeightedRoleMining$CandidateNode>
    //  208  457:invokevirtual   #356 <Method double WeightedRoleMining$CandidateNode.getWsfpi()>
    //  209  460:dadd            
    //  210  461:dstore          15
                            for(int kndex = 1; kndex <= kSubtract1PermWeight.size(); kndex++)
    //* 211  463:iconst_1        
    //* 212  464:istore          17
    //* 213  466:goto            597
                            {
                                maxWeight += ((Double)kSubtract1PermWeight.get(kndex - 1)).doubleValue();
    //  214  469:dload           15
    //  215  471:aload           13
    //  216  473:iload           17
    //  217  475:iconst_1        
    //  218  476:isub            
    //  219  477:invokevirtual   #165 <Method Object Vector.get(int)>
    //  220  480:checkcast       #103 <Class Double>
    //  221  483:invokevirtual   #239 <Method double Double.doubleValue()>
    //  222  486:dadd            
    //  223  487:dstore          15
                                double minnumUsersXY = (wminsup * (double)mat.getColumnDimension()) / maxWeight;
    //  224  489:aload_0         
    //  225  490:getfield        #282 <Field double wminsup>
    //  226  493:aload_1         
    //  227  494:invokevirtual   #116 <Method int Matrix.getColumnDimension()>
    //  228  497:i2d             
    //  229  498:dmul            
    //  230  499:dload           15
    //  231  501:ddiv            
    //  232  502:dstore          18
                                if((double)XYPermUsers.size() < minnumUsersXY)
                                    continue;
    //  233  504:aload           8
    //  234  506:invokevirtual   #136 <Method int Vector.size()>
    //  235  509:i2d             
    //  236  510:dload           18
    //  237  512:dcmpl           
    //  238  513:iflt            594
                                CandidateNode cn = new CandidateNode();
    //  239  516:new             #299 <Class WeightedRoleMining$CandidateNode>
    //  240  519:dup             
    //  241  520:aload_0         
    //  242  521:invokespecial   #300 <Method void WeightedRoleMining$CandidateNode(WeightedRoleMining)>
    //  243  524:astore          20
                                cn.setPerm(kitemSet);
    //  244  526:aload           20
    //  245  528:aload           7
    //  246  530:invokevirtual   #301 <Method void WeightedRoleMining$CandidateNode.setPerm(Vector)>
                                cn.setPermUsers(XYPermUsers);
    //  247  533:aload           20
    //  248  535:aload           8
    //  249  537:invokevirtual   #302 <Method void WeightedRoleMining$CandidateNode.setPermUsers(Vector)>
                                cn.setWsfpi(wsfxy);
    //  250  540:aload           20
    //  251  542:dload           11
    //  252  544:invokevirtual   #303 <Method void WeightedRoleMining$CandidateNode.setWsfpi(double)>
                                log.append((new StringBuilder()).append(kitemSet).append("   into C\n").toString());
    //  253  547:aload_0         
    //  254  548:getfield        #49  <Field StringBuffer log>
    //  255  551:new             #144 <Class StringBuilder>
    //  256  554:dup             
    //  257  555:invokespecial   #350 <Method void StringBuilder()>
    //  258  558:aload           7
    //  259  560:invokevirtual   #353 <Method StringBuilder StringBuilder.append(Object)>
    //  260  563:ldc2            #368 <String "   into C\n">
    //  261  566:invokevirtual   #157 <Method StringBuilder StringBuilder.append(String)>
    //  262  569:invokevirtual   #161 <Method String StringBuilder.toString()>
    //  263  572:invokevirtual   #142 <Method StringBuffer StringBuffer.append(String)>
    //  264  575:pop             
                                CandidatePerms.add(cn);
    //  265  576:aload_0         
    //  266  577:getfield        #64  <Field Vector CandidatePerms>
    //  267  580:aload           20
    //  268  582:invokevirtual   #280 <Method boolean Vector.add(Object)>
    //  269  585:pop             
                                isOver = false;
    //  270  586:aload_0         
    //  271  587:iconst_0        
    //  272  588:putfield        #66  <Field boolean isOver>
                                break;
    //  273  591:goto            607
                            }

    //  274  594:iinc            17  1
    //  275  597:iload           17
    //  276  599:aload           13
    //  277  601:invokevirtual   #136 <Method int Vector.size()>
    //  278  604:icmple          469
                        }
                    }

    //  279  607:iinc            6  1
    //  280  610:iload           6
    //  281  612:iload           4
    //  282  614:icmplt          97
            }

    //  283  617:iinc            5  1
    //  284  620:iload           5
    //  285  622:iload           4
    //  286  624:iconst_1        
    //  287  625:isub            
    //  288  626:icmplt          88
        }

    //  289  629:iinc            2  1
    //  290  632:aload_0         
    //  291  633:getfield        #66  <Field boolean isOver>
    //  292  636:ifne            647
    //  293  639:iload_2         
    //  294  640:aload_1         
    //  295  641:invokevirtual   #116 <Method int Matrix.getColumnDimension()>
    //  296  644:icmple          5
    //  297  647:return          
    }

    private boolean haskSubtract2SamePerms(CandidateNode node, CandidateNode node2, int k)
    {
        for(int index = 0; index < k - 2; index++)
    //*   0    0:iconst_0        
    //*   1    1:istore          4
    //*   2    3:goto            32
            if(node.getPerm().get(index) != node2.getPerm().get(index))
    //*   3    6:aload_1         
    //*   4    7:invokevirtual   #332 <Method Vector WeightedRoleMining$CandidateNode.getPerm()>
    //*   5   10:iload           4
    //*   6   12:invokevirtual   #165 <Method Object Vector.get(int)>
    //*   7   15:aload_2         
    //*   8   16:invokevirtual   #332 <Method Vector WeightedRoleMining$CandidateNode.getPerm()>
    //*   9   19:iload           4
    //*  10   21:invokevirtual   #165 <Method Object Vector.get(int)>
    //*  11   24:if_acmpeq       29
                return false;
    //   12   27:iconst_0        
    //   13   28:ireturn         

    //   14   29:iinc            4  1
    //   15   32:iload           4
    //   16   34:iload_3         
    //   17   35:iconst_2        
    //   18   36:isub            
    //   19   37:icmplt          6
        return true;
    //   20   40:iconst_1        
    //   21   41:ireturn         
    }

    private double calculateComWeight(Vector perm)
    {
        double comWeight = 0.0D;
    //    0    0:dconst_0        
    //    1    1:dstore_2        
        for(Iterator iterator = perm.iterator(); iterator.hasNext();)
    //*   2    2:aload_1         
    //*   3    3:invokevirtual   #256 <Method Iterator Vector.iterator()>
    //*   4    6:astore          5
    //*   5    8:goto            78
        {
            int first = ((Integer)iterator.next()).intValue();
    //    6   11:aload           5
    //    7   13:invokeinterface #262 <Method Object Iterator.next()>
    //    8   18:checkcast       #173 <Class Integer>
    //    9   21:invokevirtual   #176 <Method int Integer.intValue()>
    //   10   24:istore          4
            for(Iterator iterator1 = allP2W.iterator(); iterator1.hasNext();)
    //*  11   26:aload_0         
    //*  12   27:getfield        #60  <Field Vector allP2W>
    //*  13   30:invokevirtual   #256 <Method Iterator Vector.iterator()>
    //*  14   33:astore          7
    //*  15   35:goto            68
            {
                perm2Weight second = (perm2Weight)iterator1.next();
    //   16   38:aload           7
    //   17   40:invokeinterface #262 <Method Object Iterator.next()>
    //   18   45:checkcast       #225 <Class WeightedRoleMining$perm2Weight>
    //   19   48:astore          6
                if(second.getPerm() == first)
    //*  20   50:aload           6
    //*  21   52:invokevirtual   #264 <Method int WeightedRoleMining$perm2Weight.getPerm()>
    //*  22   55:iload           4
    //*  23   57:icmpne          68
                    comWeight += second.getWeight();
    //   24   60:dload_2         
    //   25   61:aload           6
    //   26   63:invokevirtual   #267 <Method double WeightedRoleMining$perm2Weight.getWeight()>
    //   27   66:dadd            
    //   28   67:dstore_2        
            }

    //   29   68:aload           7
    //   30   70:invokeinterface #271 <Method boolean Iterator.hasNext()>
    //   31   75:ifne            38
        }

    //   32   78:aload           5
    //   33   80:invokeinterface #271 <Method boolean Iterator.hasNext()>
    //   34   85:ifne            11
        return comWeight;
    //   35   88:dload_2         
    //   36   89:dreturn         
    }

    public Enumeration listOptions()
    {
        String string1 = (new StringBuilder("\tRequired proportion of permission and permission weight for permission weight. (default = ")).append(a).append(")").toString();
    //    0    0:new             #144 <Class StringBuilder>
    //    1    3:dup             
    //    2    4:ldc2            #390 <String "\tRequired proportion of permission and permission weight for permission weight. (default = ">
    //    3    7:invokespecial   #149 <Method void StringBuilder(String)>
    //    4   10:aload_0         
    //    5   11:getfield        #392 <Field double a>
    //    6   14:invokevirtual   #200 <Method StringBuilder StringBuilder.append(double)>
    //    7   17:ldc2            #394 <String ")">
    //    8   20:invokevirtual   #157 <Method StringBuilder StringBuilder.append(String)>
    //    9   23:invokevirtual   #161 <Method String StringBuilder.toString()>
    //   10   26:astore_1        
        String string2 = (new StringBuilder("\tRequired proportion of the weighted weight for permission weight. (default = ")).append(b).append(")").toString();
    //   11   27:new             #144 <Class StringBuilder>
    //   12   30:dup             
    //   13   31:ldc2            #396 <String "\tRequired proportion of the weighted weight for permission weight. (default = ">
    //   14   34:invokespecial   #149 <Method void StringBuilder(String)>
    //   15   37:aload_0         
    //   16   38:getfield        #398 <Field double b>
    //   17   41:invokevirtual   #200 <Method StringBuilder StringBuilder.append(double)>
    //   18   44:ldc2            #394 <String ")">
    //   19   47:invokevirtual   #157 <Method StringBuilder StringBuilder.append(String)>
    //   20   50:invokevirtual   #161 <Method String StringBuilder.toString()>
    //   21   53:astore_2        
        String string3 = (new StringBuilder("\tRequired proportion of calculated weight for permission weight. (default = ")).append(r).append(")").toString();
    //   22   54:new             #144 <Class StringBuilder>
    //   23   57:dup             
    //   24   58:ldc2            #400 <String "\tRequired proportion of calculated weight for permission weight. (default = ">
    //   25   61:invokespecial   #149 <Method void StringBuilder(String)>
    //   26   64:aload_0         
    //   27   65:getfield        #234 <Field double r>
    //   28   68:invokevirtual   #200 <Method StringBuilder StringBuilder.append(double)>
    //   29   71:ldc2            #394 <String ")">
    //   30   74:invokevirtual   #157 <Method StringBuilder StringBuilder.append(String)>
    //   31   77:invokevirtual   #161 <Method String StringBuilder.toString()>
    //   32   80:astore_3        
        String string4 = (new StringBuilder("\tRequired proportion of initial weight for permission weight. (default = ")).append(o).append(")").toString();
    //   33   81:new             #144 <Class StringBuilder>
    //   34   84:dup             
    //   35   85:ldc2            #402 <String "\tRequired proportion of initial weight for permission weight. (default = ">
    //   36   88:invokespecial   #149 <Method void StringBuilder(String)>
    //   37   91:aload_0         
    //   38   92:getfield        #236 <Field double o>
    //   39   95:invokevirtual   #200 <Method StringBuilder StringBuilder.append(double)>
    //   40   98:ldc2            #394 <String ")">
    //   41  101:invokevirtual   #157 <Method StringBuilder StringBuilder.append(String)>
    //   42  104:invokevirtual   #161 <Method String StringBuilder.toString()>
    //   43  107:astore          4
        String string5 = (new StringBuilder("\tRequired the Minimum support for frequent mode mining. (default = ")).append(wminsup).append(")").toString();
    //   44  109:new             #144 <Class StringBuilder>
    //   45  112:dup             
    //   46  113:ldc2            #404 <String "\tRequired the Minimum support for frequent mode mining. (default = ">
    //   47  116:invokespecial   #149 <Method void StringBuilder(String)>
    //   48  119:aload_0         
    //   49  120:getfield        #282 <Field double wminsup>
    //   50  123:invokevirtual   #200 <Method StringBuilder StringBuilder.append(double)>
    //   51  126:ldc2            #394 <String ")">
    //   52  129:invokevirtual   #157 <Method StringBuilder StringBuilder.append(String)>
    //   53  132:invokevirtual   #161 <Method String StringBuilder.toString()>
    //   54  135:astore          5
        FastVector newVector = new FastVector(5);
    //   55  137:new             #406 <Class FastVector>
    //   56  140:dup             
    //   57  141:iconst_5        
    //   58  142:invokespecial   #408 <Method void FastVector(int)>
    //   59  145:astore          6
        newVector.addElement(new Option(string1, "A", 1, "-A <required proportion of permission and permission weight>"));
    //   60  147:aload           6
    //   61  149:new             #410 <Class Option>
    //   62  152:dup             
    //   63  153:aload_1         
    //   64  154:ldc2            #412 <String "A">
    //   65  157:iconst_1        
    //   66  158:ldc2            #414 <String "-A <required proportion of permission and permission weight>">
    //   67  161:invokespecial   #417 <Method void Option(String, String, int, String)>
    //   68  164:invokevirtual   #421 <Method void FastVector.addElement(Object)>
        newVector.addElement(new Option(string2, "B", 1, "-B <required proportion of the weighted weight>"));
    //   69  167:aload           6
    //   70  169:new             #410 <Class Option>
    //   71  172:dup             
    //   72  173:aload_2         
    //   73  174:ldc2            #423 <String "B">
    //   74  177:iconst_1        
    //   75  178:ldc2            #425 <String "-B <required proportion of the weighted weight>">
    //   76  181:invokespecial   #417 <Method void Option(String, String, int, String)>
    //   77  184:invokevirtual   #421 <Method void FastVector.addElement(Object)>
        newVector.addElement(new Option(string3, "R", 1, "-R <required proportion of calculated weight>"));
    //   78  187:aload           6
    //   79  189:new             #410 <Class Option>
    //   80  192:dup             
    //   81  193:aload_3         
    //   82  194:ldc2            #427 <String "R">
    //   83  197:iconst_1        
    //   84  198:ldc2            #429 <String "-R <required proportion of calculated weight>">
    //   85  201:invokespecial   #417 <Method void Option(String, String, int, String)>
    //   86  204:invokevirtual   #421 <Method void FastVector.addElement(Object)>
        newVector.addElement(new Option(string4, "O", 1, "-O <required proportion of initial weight>"));
    //   87  207:aload           6
    //   88  209:new             #410 <Class Option>
    //   89  212:dup             
    //   90  213:aload           4
    //   91  215:ldc2            #431 <String "O">
    //   92  218:iconst_1        
    //   93  219:ldc2            #433 <String "-O <required proportion of initial weight>">
    //   94  222:invokespecial   #417 <Method void Option(String, String, int, String)>
    //   95  225:invokevirtual   #421 <Method void FastVector.addElement(Object)>
        newVector.addElement(new Option(string4, "W", 1, "-W <required the Minimum support>"));
    //   96  228:aload           6
    //   97  230:new             #410 <Class Option>
    //   98  233:dup             
    //   99  234:aload           4
    //  100  236:ldc2            #435 <String "W">
    //  101  239:iconst_1        
    //  102  240:ldc2            #437 <String "-W <required the Minimum support>">
    //  103  243:invokespecial   #417 <Method void Option(String, String, int, String)>
    //  104  246:invokevirtual   #421 <Method void FastVector.addElement(Object)>
        return newVector.elements();
    //  105  249:aload           6
    //  106  251:invokevirtual   #440 <Method Enumeration FastVector.elements()>
    //  107  254:areturn         
    }

    public String globalInfo()
    {
        return "WRM introduces the weight in the process of role mining.The aigorithm first calculates \nthe weight of every permission by three matrixs. Then mine the frequent itemset by \nfrequent mode mining.Last form the role by the frequent itemset. \n";
    //    0    0:ldc2            #451 <String "WRM introduces the weight in the process of role mining.The aigorithm first calculates \nthe weight of every permission by three matrixs. Then mine the frequent itemset by \nfrequent mode mining.Last form the role by the frequent itemset. \n">
    //    1    3:areturn         
    }

    public Capabilities getCapabilities()
    {
        Capabilities result = super.getCapabilities();
    //    0    0:aload_0         
    //    1    1:invokespecial   #455 <Method Capabilities AbstractRoleminer.getCapabilities()>
    //    2    4:astore_1        
        result.disableAll();
    //    3    5:aload_1         
    //    4    6:invokevirtual   #460 <Method void Capabilities.disableAll()>
        result.enable(rm.core.Capabilities.Capability.NOMINAL_ATTRIBUTES);
    //    5    9:aload_1         
    //    6   10:getstatic       #466 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.NOMINAL_ATTRIBUTES>
    //    7   13:invokevirtual   #470 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enable(rm.core.Capabilities.Capability.MISSING_VALUES);
    //    8   16:aload_1         
    //    9   17:getstatic       #473 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.MISSING_VALUES>
    //   10   20:invokevirtual   #470 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enable(rm.core.Capabilities.Capability.NO_CLASS);
    //   11   23:aload_1         
    //   12   24:getstatic       #476 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.NO_CLASS>
    //   13   27:invokevirtual   #470 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enable(rm.core.Capabilities.Capability.NOMINAL_CLASS);
    //   14   30:aload_1         
    //   15   31:getstatic       #479 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.NOMINAL_CLASS>
    //   16   34:invokevirtual   #470 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enable(rm.core.Capabilities.Capability.MISSING_CLASS_VALUES);
    //   17   37:aload_1         
    //   18   38:getstatic       #482 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.MISSING_CLASS_VALUES>
    //   19   41:invokevirtual   #470 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        return result;
    //   20   44:aload_1         
    //   21   45:areturn         
    }

    public void setOptions(String options[])
        throws Exception
    {
        resetOptions();
    //    0    0:aload_0         
    //    1    1:invokevirtual   #69  <Method void resetOptions()>
        String s_wa = Utils.getOption('A', options);
    //    2    4:bipush          65
    //    3    6:aload_1         
    //    4    7:invokestatic    #492 <Method String Utils.getOption(char, String[])>
    //    5   10:astore_2        
        if(s_wa.length() != 0)
    //*   6   11:aload_2         
    //*   7   12:invokevirtual   #495 <Method int String.length()>
    //*   8   15:ifeq            26
            a = Double.parseDouble(s_wa);
    //    9   18:aload_0         
    //   10   19:aload_2         
    //   11   20:invokestatic    #499 <Method double Double.parseDouble(String)>
    //   12   23:putfield        #392 <Field double a>
        String s_wb = Utils.getOption('B', options);
    //   13   26:bipush          66
    //   14   28:aload_1         
    //   15   29:invokestatic    #492 <Method String Utils.getOption(char, String[])>
    //   16   32:astore_3        
        if(s_wb.length() != 0)
    //*  17   33:aload_3         
    //*  18   34:invokevirtual   #495 <Method int String.length()>
    //*  19   37:ifeq            48
            b = Double.parseDouble(s_wb);
    //   20   40:aload_0         
    //   21   41:aload_3         
    //   22   42:invokestatic    #499 <Method double Double.parseDouble(String)>
    //   23   45:putfield        #398 <Field double b>
        String s_wr = Utils.getOption('R', options);
    //   24   48:bipush          82
    //   25   50:aload_1         
    //   26   51:invokestatic    #492 <Method String Utils.getOption(char, String[])>
    //   27   54:astore          4
        if(s_wr.length() != 0)
    //*  28   56:aload           4
    //*  29   58:invokevirtual   #495 <Method int String.length()>
    //*  30   61:ifeq            73
            r = Double.parseDouble(s_wr);
    //   31   64:aload_0         
    //   32   65:aload           4
    //   33   67:invokestatic    #499 <Method double Double.parseDouble(String)>
    //   34   70:putfield        #234 <Field double r>
        String s_wo = Utils.getOption('O', options);
    //   35   73:bipush          79
    //   36   75:aload_1         
    //   37   76:invokestatic    #492 <Method String Utils.getOption(char, String[])>
    //   38   79:astore          5
        if(s_wo.length() != 0)
    //*  39   81:aload           5
    //*  40   83:invokevirtual   #495 <Method int String.length()>
    //*  41   86:ifeq            98
            o = Double.parseDouble(s_wo);
    //   42   89:aload_0         
    //   43   90:aload           5
    //   44   92:invokestatic    #499 <Method double Double.parseDouble(String)>
    //   45   95:putfield        #236 <Field double o>
        String s_ww = Utils.getOption('W', options);
    //   46   98:bipush          87
    //   47  100:aload_1         
    //   48  101:invokestatic    #492 <Method String Utils.getOption(char, String[])>
    //   49  104:astore          6
        if(s_wo.length() != 0)
    //*  50  106:aload           5
    //*  51  108:invokevirtual   #495 <Method int String.length()>
    //*  52  111:ifeq            123
            wminsup = Double.parseDouble(s_ww);
    //   53  114:aload_0         
    //   54  115:aload           6
    //   55  117:invokestatic    #499 <Method double Double.parseDouble(String)>
    //   56  120:putfield        #282 <Field double wminsup>
    //   57  123:return          
    }

    public String[] getOptions()
    {
        String options[] = new String[30];
    //    0    0:bipush          30
    //    1    2:anewarray       String[]
    //    2    5:astore_1        
        int current = 0;
    //    3    6:iconst_0        
    //    4    7:istore_2        
        options[current++] = "-A";
    //    5    8:aload_1         
    //    6    9:iload_2         
    //    7   10:iinc            2  1
    //    8   13:ldc2            #510 <String "-A">
    //    9   16:aastore         
        options[current++] = (new StringBuilder()).append(a).toString();
    //   10   17:aload_1         
    //   11   18:iload_2         
    //   12   19:iinc            2  1
    //   13   22:new             #144 <Class StringBuilder>
    //   14   25:dup             
    //   15   26:invokespecial   #350 <Method void StringBuilder()>
    //   16   29:aload_0         
    //   17   30:getfield        #392 <Field double a>
    //   18   33:invokevirtual   #200 <Method StringBuilder StringBuilder.append(double)>
    //   19   36:invokevirtual   #161 <Method String StringBuilder.toString()>
    //   20   39:aastore         
        options[current++] = "-B";
    //   21   40:aload_1         
    //   22   41:iload_2         
    //   23   42:iinc            2  1
    //   24   45:ldc2            #512 <String "-B">
    //   25   48:aastore         
        options[current++] = (new StringBuilder()).append(b).toString();
    //   26   49:aload_1         
    //   27   50:iload_2         
    //   28   51:iinc            2  1
    //   29   54:new             #144 <Class StringBuilder>
    //   30   57:dup             
    //   31   58:invokespecial   #350 <Method void StringBuilder()>
    //   32   61:aload_0         
    //   33   62:getfield        #398 <Field double b>
    //   34   65:invokevirtual   #200 <Method StringBuilder StringBuilder.append(double)>
    //   35   68:invokevirtual   #161 <Method String StringBuilder.toString()>
    //   36   71:aastore         
        options[current++] = "-R";
    //   37   72:aload_1         
    //   38   73:iload_2         
    //   39   74:iinc            2  1
    //   40   77:ldc2            #514 <String "-R">
    //   41   80:aastore         
        options[current++] = (new StringBuilder()).append(r).toString();
    //   42   81:aload_1         
    //   43   82:iload_2         
    //   44   83:iinc            2  1
    //   45   86:new             #144 <Class StringBuilder>
    //   46   89:dup             
    //   47   90:invokespecial   #350 <Method void StringBuilder()>
    //   48   93:aload_0         
    //   49   94:getfield        #234 <Field double r>
    //   50   97:invokevirtual   #200 <Method StringBuilder StringBuilder.append(double)>
    //   51  100:invokevirtual   #161 <Method String StringBuilder.toString()>
    //   52  103:aastore         
        options[current++] = "-O";
    //   53  104:aload_1         
    //   54  105:iload_2         
    //   55  106:iinc            2  1
    //   56  109:ldc2            #516 <String "-O">
    //   57  112:aastore         
        options[current++] = (new StringBuilder()).append(o).toString();
    //   58  113:aload_1         
    //   59  114:iload_2         
    //   60  115:iinc            2  1
    //   61  118:new             #144 <Class StringBuilder>
    //   62  121:dup             
    //   63  122:invokespecial   #350 <Method void StringBuilder()>
    //   64  125:aload_0         
    //   65  126:getfield        #236 <Field double o>
    //   66  129:invokevirtual   #200 <Method StringBuilder StringBuilder.append(double)>
    //   67  132:invokevirtual   #161 <Method String StringBuilder.toString()>
    //   68  135:aastore         
        options[current++] = "-W";
    //   69  136:aload_1         
    //   70  137:iload_2         
    //   71  138:iinc            2  1
    //   72  141:ldc2            #518 <String "-W">
    //   73  144:aastore         
        for(options[current++] = (new StringBuilder()).append(wminsup).toString(); current < options.length; options[current++] = "");
    //   74  145:aload_1         
    //   75  146:iload_2         
    //   76  147:iinc            2  1
    //   77  150:new             #144 <Class StringBuilder>
    //   78  153:dup             
    //   79  154:invokespecial   #350 <Method void StringBuilder()>
    //   80  157:aload_0         
    //   81  158:getfield        #282 <Field double wminsup>
    //   82  161:invokevirtual   #200 <Method StringBuilder StringBuilder.append(double)>
    //   83  164:invokevirtual   #161 <Method String StringBuilder.toString()>
    //   84  167:aastore         
    //   85  168:goto            180
    //   86  171:aload_1         
    //   87  172:iload_2         
    //   88  173:iinc            2  1
    //   89  176:ldc2            #520 <String "">
    //   90  179:aastore         
    //   91  180:iload_2         
    //   92  181:aload_1         
    //   93  182:arraylength     
    //   94  183:icmplt          171
        return options;
    //   95  186:aload_1         
    //   96  187:areturn         
    }

    public String toString()
    {
        return log.toString();
    //    0    0:aload_0         
    //    1    1:getfield        #49  <Field StringBuffer log>
    //    2    4:invokevirtual   #522 <Method String StringBuffer.toString()>
    //    3    7:areturn         
    }

    private double getPRP(double nsm[][], double apr[][], int index, int jndex, int numberOfUsers, int numberofPerms)
    {
        double similarity = a * apr[index][jndex];
    //    0    0:aload_0         
    //    1    1:getfield        #392 <Field double a>
    //    2    4:aload_2         
    //    3    5:iload_3         
    //    4    6:aaload          
    //    5    7:iload           4
    //    6    9:daload          
    //    7   10:dmul            
    //    8   11:dstore          7
        double sum = 0.0D;
    //    9   13:dconst_0        
    //   10   14:dstore          9
        int row = numberOfUsers + numberofPerms;
    //   11   16:iload           5
    //   12   18:iload           6
    //   13   20:iadd            
    //   14   21:istore          11
        int col = row;
    //   15   23:iload           11
    //   16   25:istore          12
        for(int i = 0; i < row; i++)
    //*  17   27:iconst_0        
    //*  18   28:istore          13
    //*  19   30:goto            79
        {
            for(int j = 0; j < col; j++)
    //*  20   33:iconst_0        
    //*  21   34:istore          14
    //*  22   36:goto            69
                sum += nsm[index][i] * nsm[jndex][j] * nsm[i][j];
    //   23   39:dload           9
    //   24   41:aload_1         
    //   25   42:iload_3         
    //   26   43:aaload          
    //   27   44:iload           13
    //   28   46:daload          
    //   29   47:aload_1         
    //   30   48:iload           4
    //   31   50:aaload          
    //   32   51:iload           14
    //   33   53:daload          
    //   34   54:dmul            
    //   35   55:aload_1         
    //   36   56:iload           13
    //   37   58:aaload          
    //   38   59:iload           14
    //   39   61:daload          
    //   40   62:dmul            
    //   41   63:dadd            
    //   42   64:dstore          9

    //   43   66:iinc            14  1
    //   44   69:iload           14
    //   45   71:iload           12
    //   46   73:icmplt          39
        }

    //   47   76:iinc            13  1
    //   48   79:iload           13
    //   49   81:iload           11
    //   50   83:icmplt          33
        sum /= (numberOfUsers + numberofPerms) * (numberOfUsers + numberofPerms);
    //   51   86:dload           9
    //   52   88:iload           5
    //   53   90:iload           6
    //   54   92:iadd            
    //   55   93:iload           5
    //   56   95:iload           6
    //   57   97:iadd            
    //   58   98:imul            
    //   59   99:i2d             
    //   60  100:ddiv            
    //   61  101:dstore          9
        similarity += b * sum;
    //   62  103:dload           7
    //   63  105:aload_0         
    //   64  106:getfield        #398 <Field double b>
    //   65  109:dload           9
    //   66  111:dmul            
    //   67  112:dadd            
    //   68  113:dstore          7
        return similarity;
    //   69  115:dload           7
    //   70  117:dreturn         
    }

    private double getPermSimilarity(Matrix mat, int index, int jndex)
    {
        Vector indexUsers = new Vector();
    //    0    0:new             #51  <Class Vector>
    //    1    3:dup             
    //    2    4:invokespecial   #52  <Method void Vector()>
    //    3    7:astore          4
        Vector jndexUsers = new Vector();
    //    4    9:new             #51  <Class Vector>
    //    5   12:dup             
    //    6   13:invokespecial   #52  <Method void Vector()>
    //    7   16:astore          5
        for(int i = 0; i < mat.getRowDimension(); i++)
    //*   8   18:iconst_0        
    //*   9   19:istore          6
    //*  10   21:goto            71
        {
            if(mat.get(i, index) == 1)
    //*  11   24:aload_1         
    //*  12   25:iload           6
    //*  13   27:iload_2         
    //*  14   28:invokevirtual   #274 <Method byte Matrix.get(int, int)>
    //*  15   31:iconst_1        
    //*  16   32:icmpne          46
                indexUsers.add(Integer.valueOf(i));
    //   17   35:aload           4
    //   18   37:iload           6
    //   19   39:invokestatic    #277 <Method Integer Integer.valueOf(int)>
    //   20   42:invokevirtual   #280 <Method boolean Vector.add(Object)>
    //   21   45:pop             
            if(mat.get(i, jndex) == 1)
    //*  22   46:aload_1         
    //*  23   47:iload           6
    //*  24   49:iload_3         
    //*  25   50:invokevirtual   #274 <Method byte Matrix.get(int, int)>
    //*  26   53:iconst_1        
    //*  27   54:icmpne          68
                jndexUsers.add(Integer.valueOf(i));
    //   28   57:aload           5
    //   29   59:iload           6
    //   30   61:invokestatic    #277 <Method Integer Integer.valueOf(int)>
    //   31   64:invokevirtual   #280 <Method boolean Vector.add(Object)>
    //   32   67:pop             
        }

    //   33   68:iinc            6  1
    //   34   71:iload           6
    //   35   73:aload_1         
    //   36   74:invokevirtual   #210 <Method int Matrix.getRowDimension()>
    //   37   77:icmplt          24
        int common = getIntersection(indexUsers, jndexUsers).size();
    //   38   80:aload_0         
    //   39   81:aload           4
    //   40   83:aload           5
    //   41   85:invokespecial   #345 <Method Vector getIntersection(Vector, Vector)>
    //   42   88:invokevirtual   #136 <Method int Vector.size()>
    //   43   91:istore          6
        int union = getUnion(indexUsers, jndexUsers);
    //   44   93:aload_0         
    //   45   94:aload           4
    //   46   96:aload           5
    //   47   98:invokespecial   #533 <Method int getUnion(Vector, Vector)>
    //   48  101:istore          7
        return (double)common / (double)union;
    //   49  103:iload           6
    //   50  105:i2d             
    //   51  106:iload           7
    //   52  108:i2d             
    //   53  109:ddiv            
    //   54  110:dreturn         
    }

    private double getUserSimilarity(Matrix mat, int index, int jndex)
    {
        Vector indexPerms = new Vector();
    //    0    0:new             #51  <Class Vector>
    //    1    3:dup             
    //    2    4:invokespecial   #52  <Method void Vector()>
    //    3    7:astore          4
        Vector jndexPerms = new Vector();
    //    4    9:new             #51  <Class Vector>
    //    5   12:dup             
    //    6   13:invokespecial   #52  <Method void Vector()>
    //    7   16:astore          5
        for(int i = 0; i < mat.getColumnDimension(); i++)
    //*   8   18:iconst_0        
    //*   9   19:istore          6
    //*  10   21:goto            71
        {
            if(mat.get(index, i) == 1)
    //*  11   24:aload_1         
    //*  12   25:iload_2         
    //*  13   26:iload           6
    //*  14   28:invokevirtual   #274 <Method byte Matrix.get(int, int)>
    //*  15   31:iconst_1        
    //*  16   32:icmpne          46
                indexPerms.add(Integer.valueOf(i));
    //   17   35:aload           4
    //   18   37:iload           6
    //   19   39:invokestatic    #277 <Method Integer Integer.valueOf(int)>
    //   20   42:invokevirtual   #280 <Method boolean Vector.add(Object)>
    //   21   45:pop             
            if(mat.get(jndex, i) == 1)
    //*  22   46:aload_1         
    //*  23   47:iload_3         
    //*  24   48:iload           6
    //*  25   50:invokevirtual   #274 <Method byte Matrix.get(int, int)>
    //*  26   53:iconst_1        
    //*  27   54:icmpne          68
                jndexPerms.add(Integer.valueOf(i));
    //   28   57:aload           5
    //   29   59:iload           6
    //   30   61:invokestatic    #277 <Method Integer Integer.valueOf(int)>
    //   31   64:invokevirtual   #280 <Method boolean Vector.add(Object)>
    //   32   67:pop             
        }

    //   33   68:iinc            6  1
    //   34   71:iload           6
    //   35   73:aload_1         
    //   36   74:invokevirtual   #116 <Method int Matrix.getColumnDimension()>
    //   37   77:icmplt          24
        int common = getIntersection(indexPerms, jndexPerms).size();
    //   38   80:aload_0         
    //   39   81:aload           4
    //   40   83:aload           5
    //   41   85:invokespecial   #345 <Method Vector getIntersection(Vector, Vector)>
    //   42   88:invokevirtual   #136 <Method int Vector.size()>
    //   43   91:istore          6
        int union = getUnion(indexPerms, jndexPerms);
    //   44   93:aload_0         
    //   45   94:aload           4
    //   46   96:aload           5
    //   47   98:invokespecial   #533 <Method int getUnion(Vector, Vector)>
    //   48  101:istore          7
        return (double)common / (double)union;
    //   49  103:iload           6
    //   50  105:i2d             
    //   51  106:iload           7
    //   52  108:i2d             
    //   53  109:ddiv            
    //   54  110:dreturn         
    }

    private int getUnion(Vector indexPerms, Vector jndexPerms)
    {
        int count = indexPerms.size();
    //    0    0:aload_1         
    //    1    1:invokevirtual   #136 <Method int Vector.size()>
    //    2    4:istore_3        
        for(Iterator iterator = jndexPerms.iterator(); iterator.hasNext();)
    //*   3    5:aload_2         
    //*   4    6:invokevirtual   #256 <Method Iterator Vector.iterator()>
    //*   5    9:astore          5
    //*   6   11:goto            44
        {
            int two = ((Integer)iterator.next()).intValue();
    //    7   14:aload           5
    //    8   16:invokeinterface #262 <Method Object Iterator.next()>
    //    9   21:checkcast       #173 <Class Integer>
    //   10   24:invokevirtual   #176 <Method int Integer.intValue()>
    //   11   27:istore          4
            if(!indexPerms.contains(Integer.valueOf(two)))
    //*  12   29:aload_1         
    //*  13   30:iload           4
    //*  14   32:invokestatic    #277 <Method Integer Integer.valueOf(int)>
    //*  15   35:invokevirtual   #543 <Method boolean Vector.contains(Object)>
    //*  16   38:ifne            44
                count++;
    //   17   41:iinc            3  1
        }

    //   18   44:aload           5
    //   19   46:invokeinterface #271 <Method boolean Iterator.hasNext()>
    //   20   51:ifne            14
        return count;
    //   21   54:iload_3         
    //   22   55:ireturn         
    }

    private Vector getIntersection(Vector indexPerms, Vector jndexPerms)
    {
        Vector intersection = new Vector();
    //    0    0:new             #51  <Class Vector>
    //    1    3:dup             
    //    2    4:invokespecial   #52  <Method void Vector()>
    //    3    7:astore_3        
        for(Iterator iterator = indexPerms.iterator(); iterator.hasNext();)
    //*   4    8:aload_1         
    //*   5    9:invokevirtual   #256 <Method Iterator Vector.iterator()>
    //*   6   12:astore          5
    //*   7   14:goto            54
        {
            int one = ((Integer)iterator.next()).intValue();
    //    8   17:aload           5
    //    9   19:invokeinterface #262 <Method Object Iterator.next()>
    //   10   24:checkcast       #173 <Class Integer>
    //   11   27:invokevirtual   #176 <Method int Integer.intValue()>
    //   12   30:istore          4
            if(jndexPerms.contains(Integer.valueOf(one)))
    //*  13   32:aload_2         
    //*  14   33:iload           4
    //*  15   35:invokestatic    #277 <Method Integer Integer.valueOf(int)>
    //*  16   38:invokevirtual   #543 <Method boolean Vector.contains(Object)>
    //*  17   41:ifeq            54
                intersection.add(Integer.valueOf(one));
    //   18   44:aload_3         
    //   19   45:iload           4
    //   20   47:invokestatic    #277 <Method Integer Integer.valueOf(int)>
    //   21   50:invokevirtual   #280 <Method boolean Vector.add(Object)>
    //   22   53:pop             
        }

    //   23   54:aload           5
    //   24   56:invokeinterface #271 <Method boolean Iterator.hasNext()>
    //   25   61:ifne            17
        return intersection;
    //   26   64:aload_3         
    //   27   65:areturn         
    }

    private void splitAttruteString(Attribute latitudeAttrute, Vector splitString)
    {
        String perAttr = latitudeAttrute.toString();
    //    0    0:aload_1         
    //    1    1:invokevirtual   #552 <Method String Attribute.toString()>
    //    2    4:astore_3        
        int fristChar = perAttr.indexOf('{');
    //    3    5:aload_3         
    //    4    6:bipush          123
    //    5    8:invokevirtual   #556 <Method int String.indexOf(int)>
    //    6   11:istore          4
        int lastChar = perAttr.lastIndexOf('}');
    //    7   13:aload_3         
    //    8   14:bipush          125
    //    9   16:invokevirtual   #559 <Method int String.lastIndexOf(int)>
    //   10   19:istore          5
        perAttr = perAttr.substring(fristChar + 1, lastChar);
    //   11   21:aload_3         
    //   12   22:iload           4
    //   13   24:iconst_1        
    //   14   25:iadd            
    //   15   26:iload           5
    //   16   28:invokevirtual   #563 <Method String String.substring(int, int)>
    //   17   31:astore_3        
        for(int index = perAttr.indexOf(','); index != -1; index = perAttr.indexOf(','))
    //*  18   32:aload_3         
    //*  19   33:bipush          44
    //*  20   35:invokevirtual   #556 <Method int String.indexOf(int)>
    //*  21   38:istore          6
    //*  22   40:goto            72
        {
            splitString.add(perAttr.substring(0, index));
    //   23   43:aload_2         
    //   24   44:aload_3         
    //   25   45:iconst_0        
    //   26   46:iload           6
    //   27   48:invokevirtual   #563 <Method String String.substring(int, int)>
    //   28   51:invokevirtual   #280 <Method boolean Vector.add(Object)>
    //   29   54:pop             
            perAttr = perAttr.substring(index + 1);
    //   30   55:aload_3         
    //   31   56:iload           6
    //   32   58:iconst_1        
    //   33   59:iadd            
    //   34   60:invokevirtual   #566 <Method String String.substring(int)>
    //   35   63:astore_3        
        }

    //   36   64:aload_3         
    //   37   65:bipush          44
    //   38   67:invokevirtual   #556 <Method int String.indexOf(int)>
    //   39   70:istore          6
    //   40   72:iload           6
    //   41   74:iconst_m1       
    //   42   75:icmpne          43
        splitString.add(perAttr.substring(0));
    //   43   78:aload_2         
    //   44   79:aload_3         
    //   45   80:iconst_0        
    //   46   81:invokevirtual   #566 <Method String String.substring(int)>
    //   47   84:invokevirtual   #280 <Method boolean Vector.add(Object)>
    //   48   87:pop             
    //   49   88:return          
    }

    public void resetOptions()
    {
        a = 0.90000000000000002D;
    //    0    0:aload_0         
    //    1    1:ldc2w           #573 <Double 0.90000000000000002D>
    //    2    4:putfield        #392 <Field double a>
        b = 0.10000000000000001D;
    //    3    7:aload_0         
    //    4    8:ldc2w           #575 <Double 0.10000000000000001D>
    //    5   11:putfield        #398 <Field double b>
        r = 1.0D;
    //    6   14:aload_0         
    //    7   15:dconst_1        
    //    8   16:putfield        #234 <Field double r>
        o = 0.0D;
    //    9   19:aload_0         
    //   10   20:dconst_0        
    //   11   21:putfield        #236 <Field double o>
        wminsup = 0.34999999999999998D;
    //   12   24:aload_0         
    //   13   25:ldc2w           #577 <Double 0.34999999999999998D>
    //   14   28:putfield        #282 <Field double wminsup>
    //   15   31:return          
    }

    public Assignment generateRoles()
    {
        m_assroles = new Assignment();
    //    0    0:aload_0         
    //    1    1:new             #80  <Class Assignment>
    //    2    4:dup             
    //    3    5:invokespecial   #581 <Method void Assignment()>
    //    4    8:putfield        #583 <Field Assignment m_assroles>
        m_assroles.setAssignementName("role-permission");
    //    5   11:aload_0         
    //    6   12:getfield        #583 <Field Assignment m_assroles>
    //    7   15:ldc2            #585 <String "role-permission">
    //    8   18:invokevirtual   #588 <Method void Assignment.setAssignementName(String)>
        Matrix mat = new Matrix(numberOfRoles, permissions.size(), (byte)0);
    //    9   21:new             #112 <Class Matrix>
    //   10   24:dup             
    //   11   25:getstatic       #39  <Field int numberOfRoles>
    //   12   28:aload_0         
    //   13   29:getfield        #56  <Field Vector permissions>
    //   14   32:invokevirtual   #136 <Method int Vector.size()>
    //   15   35:iconst_0        
    //   16   36:invokespecial   #591 <Method void Matrix(int, int, byte)>
    //   17   39:astore_1        
        for(int i = 0; i < numberOfRoles; i++)
    //*  18   40:iconst_0        
    //*  19   41:istore_2        
    //*  20   42:goto            104
        {
            Vector upi = ((FrequentNode)FrequentPerms.get(i)).getPerm();
    //   21   45:aload_0         
    //   22   46:getfield        #62  <Field Vector FrequentPerms>
    //   23   49:iload_2         
    //   24   50:invokevirtual   #165 <Method Object Vector.get(int)>
    //   25   53:checkcast       #167 <Class WeightedRoleMining$FrequentNode>
    //   26   56:invokevirtual   #171 <Method Vector WeightedRoleMining$FrequentNode.getPerm()>
    //   27   59:astore_3        
            for(int j = 0; j < permissions.size(); j++)
    //*  28   60:iconst_0        
    //*  29   61:istore          4
    //*  30   63:goto            89
                if(upi.contains(Integer.valueOf(j)))
    //*  31   66:aload_3         
    //*  32   67:iload           4
    //*  33   69:invokestatic    #277 <Method Integer Integer.valueOf(int)>
    //*  34   72:invokevirtual   #543 <Method boolean Vector.contains(Object)>
    //*  35   75:ifeq            86
                    mat.set(i, j, (byte)1);
    //   36   78:aload_1         
    //   37   79:iload_2         
    //   38   80:iload           4
    //   39   82:iconst_1        
    //   40   83:invokevirtual   #594 <Method void Matrix.set(int, int, byte)>

    //   41   86:iinc            4  1
    //   42   89:iload           4
    //   43   91:aload_0         
    //   44   92:getfield        #56  <Field Vector permissions>
    //   45   95:invokevirtual   #136 <Method int Vector.size()>
    //   46   98:icmplt          66
        }

    //   47  101:iinc            2  1
    //   48  104:iload_2         
    //   49  105:getstatic       #39  <Field int numberOfRoles>
    //   50  108:icmplt          45
        m_assroles.setAssignmentMatrix(mat);
    //   51  111:aload_0         
    //   52  112:getfield        #583 <Field Assignment m_assroles>
    //   53  115:aload_1         
    //   54  116:invokevirtual   #597 <Method void Assignment.setAssignmentMatrix(Matrix)>
        FastVector fv = new FastVector();
    //   55  119:new             #406 <Class FastVector>
    //   56  122:dup             
    //   57  123:invokespecial   #598 <Method void FastVector()>
    //   58  126:astore_2        
        for(int i = 0; i < numberOfRoles; i++)
    //*  59  127:iconst_0        
    //*  60  128:istore_3        
    //*  61  129:goto            156
            fv.addElement((new StringBuilder("R")).append(i).toString());
    //   62  132:aload_2         
    //   63  133:new             #144 <Class StringBuilder>
    //   64  136:dup             
    //   65  137:ldc2            #427 <String "R">
    //   66  140:invokespecial   #149 <Method void StringBuilder(String)>
    //   67  143:iload_3         
    //   68  144:invokevirtual   #152 <Method StringBuilder StringBuilder.append(int)>
    //   69  147:invokevirtual   #161 <Method String StringBuilder.toString()>
    //   70  150:invokevirtual   #421 <Method void FastVector.addElement(Object)>

    //   71  153:iinc            3  1
    //   72  156:iload_3         
    //   73  157:getstatic       #39  <Field int numberOfRoles>
    //   74  160:icmplt          132
        Attribute dxa = new Attribute("role", fv);
    //   75  163:new             #551 <Class Attribute>
    //   76  166:dup             
    //   77  167:ldc2            #600 <String "role">
    //   78  170:aload_2         
    //   79  171:invokespecial   #603 <Method void Attribute(String, FastVector)>
    //   80  174:astore_3        
        Dimension dx = new Dimension();
    //   81  175:new             #90  <Class Dimension>
    //   82  178:dup             
    //   83  179:invokespecial   #604 <Method void Dimension()>
    //   84  182:astore          4
        dx.setDimensionAttribute(dxa);
    //   85  184:aload           4
    //   86  186:aload_3         
    //   87  187:invokevirtual   #608 <Method void Dimension.setDimensionAttribute(Attribute)>
        m_assroles.setDimensionX(dx);
    //   88  190:aload_0         
    //   89  191:getfield        #583 <Field Assignment m_assroles>
    //   90  194:aload           4
    //   91  196:invokevirtual   #612 <Method void Assignment.setDimensionX(Dimension)>
        Attribute dya = m_assignment.getDimensionY().getDimensionAttribute();
    //   92  199:aload_0         
    //   93  200:getfield        #78  <Field Assignment m_assignment>
    //   94  203:invokevirtual   #88  <Method Dimension Assignment.getDimensionY()>
    //   95  206:invokevirtual   #94  <Method Attribute Dimension.getDimensionAttribute()>
    //   96  209:astore          5
        Dimension dy = new Dimension();
    //   97  211:new             #90  <Class Dimension>
    //   98  214:dup             
    //   99  215:invokespecial   #604 <Method void Dimension()>
    //  100  218:astore          6
        dy.setDimensionAttribute(dya);
    //  101  220:aload           6
    //  102  222:aload           5
    //  103  224:invokevirtual   #608 <Method void Dimension.setDimensionAttribute(Attribute)>
        m_assroles.setDimensionY(dy);
    //  104  227:aload_0         
    //  105  228:getfield        #583 <Field Assignment m_assroles>
    //  106  231:aload           6
    //  107  233:invokevirtual   #615 <Method void Assignment.setDimensionY(Dimension)>
        return m_assroles;
    //  108  236:aload_0         
    //  109  237:getfield        #583 <Field Assignment m_assroles>
    //  110  240:areturn         
    }

    public String waTipText()
    {
        return "The required proportion of permission and permission weight for permission weight.";
    //    0    0:ldc2            #625 <String "The required proportion of permission and permission weight for permission weight.">
    //    1    3:areturn         
    }

    public String wbTipText()
    {
        return "The required proportion of the weighted weight for permission weight.";
    //    0    0:ldc2            #628 <String "The required proportion of the weighted weight for permission weight.">
    //    1    3:areturn         
    }

    public String wrTipText()
    {
        return "The required proportion of calculated weight for permission weight.";
    //    0    0:ldc2            #631 <String "The required proportion of calculated weight for permission weight.">
    //    1    3:areturn         
    }

    public String woTipText()
    {
        return "The required proportion of initial weight for permission weight.";
    //    0    0:ldc2            #634 <String "The required proportion of initial weight for permission weight.">
    //    1    3:areturn         
    }

    public String wwminsupTipText()
    {
        return "The required the Minimum support for frequent mode mining.";
    //    0    0:ldc2            #637 <String "The required the Minimum support for frequent mode mining.">
    //    1    3:areturn         
    }

    public static void main(String args[])
    {
        Assignment Ass = null;
    //    0    0:aconst_null     
    //    1    1:astore_1        
        try
        {
            File file = new File((new StringBuilder(String.valueOf(System.getProperty("user.dir")))).append("\\datasets\\orca_user_permission.ass").toString());
    //    2    2:new             #640 <Class File>
    //    3    5:dup             
    //    4    6:new             #144 <Class StringBuilder>
    //    5    9:dup             
    //    6   10:ldc2            #642 <String "user.dir">
    //    7   13:invokestatic    #648 <Method String System.getProperty(String)>
    //    8   16:invokestatic    #182 <Method String String.valueOf(Object)>
    //    9   19:invokespecial   #149 <Method void StringBuilder(String)>
    //   10   22:ldc2            #650 <String "\\datasets\\orca_user_permission.ass">
    //   11   25:invokevirtual   #157 <Method StringBuilder StringBuilder.append(String)>
    //   12   28:invokevirtual   #161 <Method String StringBuilder.toString()>
    //   13   31:invokespecial   #651 <Method void File(String)>
    //   14   34:astore_2        
            AssLoader AL = new AssLoader(new FileReader(file));
    //   15   35:new             #653 <Class AssLoader>
    //   16   38:dup             
    //   17   39:new             #655 <Class FileReader>
    //   18   42:dup             
    //   19   43:aload_2         
    //   20   44:invokespecial   #658 <Method void FileReader(File)>
    //   21   47:invokespecial   #661 <Method void AssLoader(FileReader)>
    //   22   50:astore_3        
            Ass = AL.getData();
    //   23   51:aload_3         
    //   24   52:invokevirtual   #664 <Method Assignment AssLoader.getData()>
    //   25   55:astore_1        
            System.out.println(Ass.getAssignementName());
    //   26   56:getstatic       #668 <Field PrintStream System.out>
    //   27   59:aload_1         
    //   28   60:invokevirtual   #671 <Method String Assignment.getAssignementName()>
    //   29   63:invokevirtual   #676 <Method void PrintStream.println(String)>
            WeightedRoleMining wrm = new WeightedRoleMining();
    //   30   66:new             #2   <Class WeightedRoleMining>
    //   31   69:dup             
    //   32   70:invokespecial   #677 <Method void WeightedRoleMining()>
    //   33   73:astore          4
            wrm.buildRoleminers(Ass);
    //   34   75:aload           4
    //   35   77:aload_1         
    //   36   78:invokevirtual   #679 <Method void buildRoleminers(Assignment)>
            System.out.println(wrm.toString());
    //   37   81:getstatic       #668 <Field PrintStream System.out>
    //   38   84:aload           4
    //   39   86:invokevirtual   #680 <Method String toString()>
    //   40   89:invokevirtual   #676 <Method void PrintStream.println(String)>
            System.out.println(wrm.generateRoles());
    //   41   92:getstatic       #668 <Field PrintStream System.out>
    //   42   95:aload           4
    //   43   97:invokevirtual   #682 <Method Assignment generateRoles()>
    //   44  100:invokevirtual   #684 <Method void PrintStream.println(Object)>
        }
    //*  45  103:goto            111
        catch(Exception e)
    //*  46  106:astore_2        
        {
            e.printStackTrace();
    //   47  107:aload_2         
    //   48  108:invokevirtual   #687 <Method void Exception.printStackTrace()>
        }
    //   49  111:return          
    }

    private double a;
    private double b;
    private double r;
    private double o;
    private double wminsup;
    private StringBuffer log;
    private Vector initalWeight;
    public static int numberOfRoles = 0;
    private Vector permissions;
    private Vector users;
    private Vector allP2W;
    private Vector FrequentPerms;
    private Vector CandidatePerms;
    private boolean isOver;
    private Assignment m_assignment;
    private Assignment m_assroles;

    static 
    {
    //    0    0:iconst_0        
    //    1    1:putstatic       #39  <Field int numberOfRoles>
    //*   2    4:return          
    }
}
