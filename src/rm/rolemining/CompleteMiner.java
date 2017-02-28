// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   CompleteMiner.java

package rm.rolemining;

import java.io.*;
import java.util.Iterator;
import java.util.Vector;
import rm.core.Assignment;
import rm.core.converters.AssLoader;

// Referenced classes of package rm.rolemining:
//            CFMAbstractParent

public class CompleteMiner extends CFMAbstractParent
{

    public CompleteMiner()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #9   <Method void CFMAbstractParent()>
    //    2    4:return          
    }

    public void buildRoleminers(Assignment data)
        throws Exception
    {
        m_assignment = data;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #22  <Field Assignment m_assignment>
        constructionInitialRole(data);
    //    3    5:aload_0         
    //    4    6:aload_1         
    //    5    7:invokevirtual   #25  <Method void constructionInitialRole(Assignment)>
        initialGenRoles(data);
    //    6   10:aload_0         
    //    7   11:aload_1         
    //    8   12:invokevirtual   #28  <Method void initialGenRoles(Assignment)>
        CalculateCountsOfGenRoles();
    //    9   15:aload_0         
    //   10   16:invokespecial   #31  <Method void CalculateCountsOfGenRoles()>
        RoleRecommendation(data);
    //   11   19:aload_0         
    //   12   20:aload_1         
    //   13   21:invokevirtual   #34  <Method void RoleRecommendation(Assignment)>
        CalculateNumbersOfRoles();
    //   14   24:aload_0         
    //   15   25:invokevirtual   #37  <Method void CalculateNumbersOfRoles()>
    //   16   28:return          
    }

    private void CalculateCountsOfGenRoles()
    {
        for(Iterator iterator = GenRoles.iterator(); iterator.hasNext();)
    //*   0    0:aload_0         
    //*   1    1:getfield        #42  <Field Vector GenRoles>
    //*   2    4:invokevirtual   #48  <Method Iterator Vector.iterator()>
    //*   3    7:astore_2        
    //*   4    8:goto            76
        {
            CFMAbstractParent.GenRoleToCounts GenRole = (CFMAbstractParent.GenRoleToCounts)iterator.next();
    //    5   11:aload_2         
    //    6   12:invokeinterface #54  <Method Object Iterator.next()>
    //    7   17:checkcast       #56  <Class CFMAbstractParent$GenRoleToCounts>
    //    8   20:astore_1        
            for(Iterator iterator1 = InitRoles.iterator(); iterator1.hasNext();)
    //*   9   21:aload_0         
    //*  10   22:getfield        #59  <Field Vector InitRoles>
    //*  11   25:invokevirtual   #48  <Method Iterator Vector.iterator()>
    //*  12   28:astore          4
    //*  13   30:goto            66
            {
                CFMAbstractParent.InitRoleToCounts InitRole = (CFMAbstractParent.InitRoleToCounts)iterator1.next();
    //   14   33:aload           4
    //   15   35:invokeinterface #54  <Method Object Iterator.next()>
    //   16   40:checkcast       #61  <Class CFMAbstractParent$InitRoleToCounts>
    //   17   43:astore_3        
                if(isSubset(GenRole, InitRole))
    //*  18   44:aload_0         
    //*  19   45:aload_1         
    //*  20   46:aload_3         
    //*  21   47:invokespecial   #65  <Method boolean isSubset(CFMAbstractParent$GenRoleToCounts, CFMAbstractParent$InitRoleToCounts)>
    //*  22   50:ifeq            66
                    GenRole.setCounts(GenRole.getCounts() + InitRole.getCounts());
    //   23   53:aload_1         
    //   24   54:aload_1         
    //   25   55:invokevirtual   #69  <Method int CFMAbstractParent$GenRoleToCounts.getCounts()>
    //   26   58:aload_3         
    //   27   59:invokevirtual   #70  <Method int CFMAbstractParent$InitRoleToCounts.getCounts()>
    //   28   62:iadd            
    //   29   63:invokevirtual   #74  <Method void CFMAbstractParent$GenRoleToCounts.setCounts(int)>
            }

    //   30   66:aload           4
    //   31   68:invokeinterface #78  <Method boolean Iterator.hasNext()>
    //   32   73:ifne            33
        }

    //   33   76:aload_2         
    //   34   77:invokeinterface #78  <Method boolean Iterator.hasNext()>
    //   35   82:ifne            11
    //   36   85:return          
    }

    private boolean isSubset(CFMAbstractParent.GenRoleToCounts genRole, CFMAbstractParent.InitRoleToCounts initRole)
    {
        return initRole.getInitRole().containsAll(genRole.getInitRole());
    //    0    0:aload_2         
    //    1    1:invokevirtual   #86  <Method Vector CFMAbstractParent$InitRoleToCounts.getInitRole()>
    //    2    4:aload_1         
    //    3    5:invokevirtual   #87  <Method Vector CFMAbstractParent$GenRoleToCounts.getInitRole()>
    //    4    8:invokevirtual   #91  <Method boolean Vector.containsAll(java.util.Collection)>
    //    5   11:ifeq            16
    //    6   14:iconst_1        
    //    7   15:ireturn         
    //    8   16:iconst_0        
    //    9   17:ireturn         
    }

    protected void initialGenRoles(Assignment data)
    {
        rm.core.Matrix mat = data.getAssignmentMatrix();
    //    0    0:aload_1         
    //    1    1:invokevirtual   #99  <Method rm.core.Matrix Assignment.getAssignmentMatrix()>
    //    2    4:astore_2        
        int sizeOfInitRoles = InitRoles.size();
    //    3    5:aload_0         
    //    4    6:getfield        #59  <Field Vector InitRoles>
    //    5    9:invokevirtual   #102 <Method int Vector.size()>
    //    6   12:istore_3        
        for(int iindexOfInitRoles = 0; iindexOfInitRoles < sizeOfInitRoles - 1; iindexOfInitRoles++)
    //*   7   13:iconst_0        
    //*   8   14:istore          4
    //*   9   16:goto            265
        {
            CFMAbstractParent.InitRoleToCounts initRoleA = (CFMAbstractParent.InitRoleToCounts)InitRoles.get(iindexOfInitRoles);
    //   10   19:aload_0         
    //   11   20:getfield        #59  <Field Vector InitRoles>
    //   12   23:iload           4
    //   13   25:invokevirtual   #106 <Method Object Vector.get(int)>
    //   14   28:checkcast       #61  <Class CFMAbstractParent$InitRoleToCounts>
    //   15   31:astore          5
            for(int jindexOfInitRoles = iindexOfInitRoles + 1; jindexOfInitRoles < sizeOfInitRoles; jindexOfInitRoles++)
    //*  16   33:iload           4
    //*  17   35:iconst_1        
    //*  18   36:iadd            
    //*  19   37:istore          6
    //*  20   39:goto            140
            {
                CFMAbstractParent.InitRoleToCounts initRoleB = (CFMAbstractParent.InitRoleToCounts)InitRoles.get(jindexOfInitRoles);
    //   21   42:aload_0         
    //   22   43:getfield        #59  <Field Vector InitRoles>
    //   23   46:iload           6
    //   24   48:invokevirtual   #106 <Method Object Vector.get(int)>
    //   25   51:checkcast       #61  <Class CFMAbstractParent$InitRoleToCounts>
    //   26   54:astore          7
                Vector intersection = permissionIntersection(initRoleA.getInitRole(), initRoleB.getInitRole());
    //   27   56:aload_0         
    //   28   57:aload           5
    //   29   59:invokevirtual   #86  <Method Vector CFMAbstractParent$InitRoleToCounts.getInitRole()>
    //   30   62:aload           7
    //   31   64:invokevirtual   #86  <Method Vector CFMAbstractParent$InitRoleToCounts.getInitRole()>
    //   32   67:invokevirtual   #110 <Method Vector permissionIntersection(Vector, Vector)>
    //   33   70:astore          8
                if(!intersection.isEmpty())
    //*  34   72:aload           8
    //*  35   74:invokevirtual   #113 <Method boolean Vector.isEmpty()>
    //*  36   77:ifne            137
                {
                    int indexOfPermissionSet = GenRoleshasSomePermissionSet(intersection);
    //   37   80:aload_0         
    //   38   81:aload           8
    //   39   83:invokevirtual   #117 <Method int GenRoleshasSomePermissionSet(Vector)>
    //   40   86:istore          9
                    if(indexOfPermissionSet == -1)
    //*  41   88:iload           9
    //*  42   90:iconst_m1       
    //*  43   91:icmpne          137
                    {
                        CFMAbstractParent.GenRoleToCounts GenRole = new CFMAbstractParent.GenRoleToCounts(this);
    //   44   94:new             #56  <Class CFMAbstractParent$GenRoleToCounts>
    //   45   97:dup             
    //   46   98:aload_0         
    //   47   99:invokespecial   #120 <Method void CFMAbstractParent$GenRoleToCounts(CFMAbstractParent)>
    //   48  102:astore          10
                        GenRole.setInitRole(intersection);
    //   49  104:aload           10
    //   50  106:aload           8
    //   51  108:invokevirtual   #124 <Method void CFMAbstractParent$GenRoleToCounts.setInitRole(Vector)>
                        Vector useSet = getUserSet(intersection, mat);
    //   52  111:aload_0         
    //   53  112:aload           8
    //   54  114:aload_2         
    //   55  115:invokevirtual   #128 <Method Vector getUserSet(Vector, rm.core.Matrix)>
    //   56  118:astore          11
                        GenRole.setUseList(useSet);
    //   57  120:aload           10
    //   58  122:aload           11
    //   59  124:invokevirtual   #131 <Method void CFMAbstractParent$GenRoleToCounts.setUseList(Vector)>
                        GenRoles.add(GenRole);
    //   60  127:aload_0         
    //   61  128:getfield        #42  <Field Vector GenRoles>
    //   62  131:aload           10
    //   63  133:invokevirtual   #135 <Method boolean Vector.add(Object)>
    //   64  136:pop             
                    }
                }
            }

    //   65  137:iinc            6  1
    //   66  140:iload           6
    //   67  142:iload_3         
    //   68  143:icmplt          42
            for(int index = 0; index < GenRoles.size(); index++)
    //*  69  146:iconst_0        
    //*  70  147:istore          6
    //*  71  149:goto            250
            {
                CFMAbstractParent.GenRoleToCounts GenRole = (CFMAbstractParent.GenRoleToCounts)GenRoles.get(index);
    //   72  152:aload_0         
    //   73  153:getfield        #42  <Field Vector GenRoles>
    //   74  156:iload           6
    //   75  158:invokevirtual   #106 <Method Object Vector.get(int)>
    //   76  161:checkcast       #56  <Class CFMAbstractParent$GenRoleToCounts>
    //   77  164:astore          7
                Vector intersection = permissionIntersection(initRoleA.getInitRole(), GenRole.getInitRole());
    //   78  166:aload_0         
    //   79  167:aload           5
    //   80  169:invokevirtual   #86  <Method Vector CFMAbstractParent$InitRoleToCounts.getInitRole()>
    //   81  172:aload           7
    //   82  174:invokevirtual   #87  <Method Vector CFMAbstractParent$GenRoleToCounts.getInitRole()>
    //   83  177:invokevirtual   #110 <Method Vector permissionIntersection(Vector, Vector)>
    //   84  180:astore          8
                if(!intersection.isEmpty())
    //*  85  182:aload           8
    //*  86  184:invokevirtual   #113 <Method boolean Vector.isEmpty()>
    //*  87  187:ifne            247
                {
                    int indexOfPermissionSet = GenRoleshasSomePermissionSet(intersection);
    //   88  190:aload_0         
    //   89  191:aload           8
    //   90  193:invokevirtual   #117 <Method int GenRoleshasSomePermissionSet(Vector)>
    //   91  196:istore          9
                    if(indexOfPermissionSet == -1)
    //*  92  198:iload           9
    //*  93  200:iconst_m1       
    //*  94  201:icmpne          247
                    {
                        CFMAbstractParent.GenRoleToCounts tempGenRole = new CFMAbstractParent.GenRoleToCounts(this);
    //   95  204:new             #56  <Class CFMAbstractParent$GenRoleToCounts>
    //   96  207:dup             
    //   97  208:aload_0         
    //   98  209:invokespecial   #120 <Method void CFMAbstractParent$GenRoleToCounts(CFMAbstractParent)>
    //   99  212:astore          10
                        tempGenRole.setInitRole(intersection);
    //  100  214:aload           10
    //  101  216:aload           8
    //  102  218:invokevirtual   #124 <Method void CFMAbstractParent$GenRoleToCounts.setInitRole(Vector)>
                        Vector useSet = getUserSet(intersection, mat);
    //  103  221:aload_0         
    //  104  222:aload           8
    //  105  224:aload_2         
    //  106  225:invokevirtual   #128 <Method Vector getUserSet(Vector, rm.core.Matrix)>
    //  107  228:astore          11
                        tempGenRole.setUseList(useSet);
    //  108  230:aload           10
    //  109  232:aload           11
    //  110  234:invokevirtual   #131 <Method void CFMAbstractParent$GenRoleToCounts.setUseList(Vector)>
                        GenRoles.add(tempGenRole);
    //  111  237:aload_0         
    //  112  238:getfield        #42  <Field Vector GenRoles>
    //  113  241:aload           10
    //  114  243:invokevirtual   #135 <Method boolean Vector.add(Object)>
    //  115  246:pop             
                    }
                }
            }

    //  116  247:iinc            6  1
    //  117  250:iload           6
    //  118  252:aload_0         
    //  119  253:getfield        #42  <Field Vector GenRoles>
    //  120  256:invokevirtual   #102 <Method int Vector.size()>
    //  121  259:icmplt          152
        }

    //  122  262:iinc            4  1
    //  123  265:iload           4
    //  124  267:iload_3         
    //  125  268:iconst_1        
    //  126  269:isub            
    //  127  270:icmplt          19
    //  128  273:return          
    }

    protected int GenRoleshasSomePermissionSet(Vector intersection)
    {
        int sizeOfGenRoles = GenRoles.size();
    //    0    0:aload_0         
    //    1    1:getfield        #42  <Field Vector GenRoles>
    //    2    4:invokevirtual   #102 <Method int Vector.size()>
    //    3    7:istore_2        
        for(int index = 0; index < sizeOfGenRoles; index++)
    //*   4    8:iconst_0        
    //*   5    9:istore_3        
    //*   6   10:goto            39
            if(((CFMAbstractParent.GenRoleToCounts)GenRoles.get(index)).getInitRole().equals(intersection))
    //*   7   13:aload_0         
    //*   8   14:getfield        #42  <Field Vector GenRoles>
    //*   9   17:iload_3         
    //*  10   18:invokevirtual   #106 <Method Object Vector.get(int)>
    //*  11   21:checkcast       #56  <Class CFMAbstractParent$GenRoleToCounts>
    //*  12   24:invokevirtual   #87  <Method Vector CFMAbstractParent$GenRoleToCounts.getInitRole()>
    //*  13   27:aload_1         
    //*  14   28:invokevirtual   #155 <Method boolean Vector.equals(Object)>
    //*  15   31:ifeq            36
                return index;
    //   16   34:iload_3         
    //   17   35:ireturn         

    //   18   36:iinc            3  1
    //   19   39:iload_3         
    //   20   40:iload_2         
    //   21   41:icmplt          13
        int sizeOfInitRoles = InitRoles.size();
    //   22   44:aload_0         
    //   23   45:getfield        #59  <Field Vector InitRoles>
    //   24   48:invokevirtual   #102 <Method int Vector.size()>
    //   25   51:istore_3        
        for(int indexOfInitRoles = 0; indexOfInitRoles < sizeOfInitRoles; indexOfInitRoles++)
    //*  26   52:iconst_0        
    //*  27   53:istore          4
    //*  28   55:goto            86
            if(((CFMAbstractParent.InitRoleToCounts)InitRoles.get(indexOfInitRoles)).getInitRole().equals(intersection))
    //*  29   58:aload_0         
    //*  30   59:getfield        #59  <Field Vector InitRoles>
    //*  31   62:iload           4
    //*  32   64:invokevirtual   #106 <Method Object Vector.get(int)>
    //*  33   67:checkcast       #61  <Class CFMAbstractParent$InitRoleToCounts>
    //*  34   70:invokevirtual   #86  <Method Vector CFMAbstractParent$InitRoleToCounts.getInitRole()>
    //*  35   73:aload_1         
    //*  36   74:invokevirtual   #155 <Method boolean Vector.equals(Object)>
    //*  37   77:ifeq            83
                return indexOfInitRoles;
    //   38   80:iload           4
    //   39   82:ireturn         

    //   40   83:iinc            4  1
    //   41   86:iload           4
    //   42   88:iload_3         
    //   43   89:icmplt          58
        return -1;
    //   44   92:iconst_m1       
    //   45   93:ireturn         
    }

    public String globalInfo()
    {
        return "CM first generates the initial roles by every user's permissions \nthen intersect these initial roles and just generated role  \n to get more candidate roles until no role generates. \n";
    //    0    0:ldc1            #161 <String "CM first generates the initial roles by every user's permissions \nthen intersect these initial roles and just generated role  \n to get more candidate roles until no role generates. \n">
    //    1    2:areturn         
    }

    public static void main(String args[])
    {
        Assignment Ass = null;
    //    0    0:aconst_null     
    //    1    1:astore_1        
        try
        {
            File file = new File((new StringBuilder(String.valueOf(System.getProperty("user.dir")))).append("\\datasets\\orca_user_permission.ass").toString());
    //    2    2:new             #165 <Class File>
    //    3    5:dup             
    //    4    6:new             #167 <Class StringBuilder>
    //    5    9:dup             
    //    6   10:ldc1            #169 <String "user.dir">
    //    7   12:invokestatic    #175 <Method String System.getProperty(String)>
    //    8   15:invokestatic    #181 <Method String String.valueOf(Object)>
    //    9   18:invokespecial   #184 <Method void StringBuilder(String)>
    //   10   21:ldc1            #186 <String "\\datasets\\orca_user_permission.ass">
    //   11   23:invokevirtual   #190 <Method StringBuilder StringBuilder.append(String)>
    //   12   26:invokevirtual   #193 <Method String StringBuilder.toString()>
    //   13   29:invokespecial   #194 <Method void File(String)>
    //   14   32:astore_2        
            AssLoader AL = new AssLoader(new FileReader(file));
    //   15   33:new             #196 <Class AssLoader>
    //   16   36:dup             
    //   17   37:new             #198 <Class FileReader>
    //   18   40:dup             
    //   19   41:aload_2         
    //   20   42:invokespecial   #201 <Method void FileReader(File)>
    //   21   45:invokespecial   #204 <Method void AssLoader(FileReader)>
    //   22   48:astore_3        
            Ass = AL.getData();
    //   23   49:aload_3         
    //   24   50:invokevirtual   #208 <Method Assignment AssLoader.getData()>
    //   25   53:astore_1        
            System.out.println(Ass.getAssignementName());
    //   26   54:getstatic       #212 <Field PrintStream System.out>
    //   27   57:aload_1         
    //   28   58:invokevirtual   #215 <Method String Assignment.getAssignementName()>
    //   29   61:invokevirtual   #220 <Method void PrintStream.println(String)>
            CompleteMiner cm = new CompleteMiner();
    //   30   64:new             #2   <Class CompleteMiner>
    //   31   67:dup             
    //   32   68:invokespecial   #221 <Method void CompleteMiner()>
    //   33   71:astore          4
            cm.buildRoleminers(Ass);
    //   34   73:aload           4
    //   35   75:aload_1         
    //   36   76:invokevirtual   #223 <Method void buildRoleminers(Assignment)>
            System.out.println(cm.toString());
    //   37   79:getstatic       #212 <Field PrintStream System.out>
    //   38   82:aload           4
    //   39   84:invokevirtual   #224 <Method String toString()>
    //   40   87:invokevirtual   #220 <Method void PrintStream.println(String)>
            System.out.println(cm.generateRoles());
    //   41   90:getstatic       #212 <Field PrintStream System.out>
    //   42   93:aload           4
    //   43   95:invokevirtual   #227 <Method Assignment generateRoles()>
    //   44   98:invokevirtual   #230 <Method void PrintStream.println(Object)>
        }
    //*  45  101:goto            109
        catch(Exception e)
    //*  46  104:astore_2        
        {
            e.printStackTrace();
    //   47  105:aload_2         
    //   48  106:invokevirtual   #233 <Method void Exception.printStackTrace()>
        }
    //   49  109:return          
    }
}
