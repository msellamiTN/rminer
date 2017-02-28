// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   Greed.java

package rm.assignment;

import java.io.*;
import java.util.Enumeration;
import rm.core.*;
import rm.core.converters.AssLoader;

// Referenced classes of package rm.assignment:
//            AbstractAssignment

public class Greed extends AbstractAssignment
    implements OptionHandler
{

    public Greed()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #28  <Method void AbstractAssignment()>
    //    2    4:return          
    }

    public void buildAssigns(Assignment upa, Assignment pa)
        throws Exception
    {
        m_assignment = upa;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #39  <Field Assignment m_assignment>
        m_assroles = pa;
    //    3    5:aload_0         
    //    4    6:aload_2         
    //    5    7:putfield        #41  <Field Assignment m_assroles>
        Matrix mupa = m_assignment.getAssignmentMatrix();
    //    6   10:aload_0         
    //    7   11:getfield        #39  <Field Assignment m_assignment>
    //    8   14:invokevirtual   #47  <Method Matrix Assignment.getAssignmentMatrix()>
    //    9   17:astore_3        
        noUsers = mupa.getRowDimension();
    //   10   18:aload_0         
    //   11   19:aload_3         
    //   12   20:invokevirtual   #53  <Method int Matrix.getRowDimension()>
    //   13   23:putfield        #55  <Field int noUsers>
        noPerms = mupa.getColumnDimension();
    //   14   26:aload_0         
    //   15   27:aload_3         
    //   16   28:invokevirtual   #58  <Method int Matrix.getColumnDimension()>
    //   17   31:putfield        #60  <Field int noPerms>
        userSet = m_assignment.getDimensionX().getDimensionAttribute().toArray();
    //   18   34:aload_0         
    //   19   35:aload_0         
    //   20   36:getfield        #39  <Field Assignment m_assignment>
    //   21   39:invokevirtual   #64  <Method Dimension Assignment.getDimensionX()>
    //   22   42:invokevirtual   #70  <Method Attribute Dimension.getDimensionAttribute()>
    //   23   45:invokevirtual   #76  <Method Object[] Attribute.toArray()>
    //   24   48:putfield        #78  <Field Object[] userSet>
        permSet = m_assignment.getDimensionY().getDimensionAttribute().toArray();
    //   25   51:aload_0         
    //   26   52:aload_0         
    //   27   53:getfield        #39  <Field Assignment m_assignment>
    //   28   56:invokevirtual   #81  <Method Dimension Assignment.getDimensionY()>
    //   29   59:invokevirtual   #70  <Method Attribute Dimension.getDimensionAttribute()>
    //   30   62:invokevirtual   #76  <Method Object[] Attribute.toArray()>
    //   31   65:putfield        #83  <Field Object[] permSet>
        isUpa = genIntegerSet(mupa);
    //   32   68:aload_0         
    //   33   69:aload_0         
    //   34   70:aload_3         
    //   35   71:invokespecial   #87  <Method IntegerSet[] genIntegerSet(Matrix)>
    //   36   74:putfield        #89  <Field IntegerSet[] isUpa>
        Matrix mpa = m_assroles.getAssignmentMatrix();
    //   37   77:aload_0         
    //   38   78:getfield        #41  <Field Assignment m_assroles>
    //   39   81:invokevirtual   #47  <Method Matrix Assignment.getAssignmentMatrix()>
    //   40   84:astore          4
        noRoles = mpa.getRowDimension();
    //   41   86:aload_0         
    //   42   87:aload           4
    //   43   89:invokevirtual   #53  <Method int Matrix.getRowDimension()>
    //   44   92:putfield        #91  <Field int noRoles>
        roleSet = m_assroles.getDimensionX().getDimensionAttribute().toArray();
    //   45   95:aload_0         
    //   46   96:aload_0         
    //   47   97:getfield        #41  <Field Assignment m_assroles>
    //   48  100:invokevirtual   #64  <Method Dimension Assignment.getDimensionX()>
    //   49  103:invokevirtual   #70  <Method Attribute Dimension.getDimensionAttribute()>
    //   50  106:invokevirtual   #76  <Method Object[] Attribute.toArray()>
    //   51  109:putfield        #93  <Field Object[] roleSet>
        isPa = genIntegerSet(mpa);
    //   52  112:aload_0         
    //   53  113:aload_0         
    //   54  114:aload           4
    //   55  116:invokespecial   #87  <Method IntegerSet[] genIntegerSet(Matrix)>
    //   56  119:putfield        #95  <Field IntegerSet[] isPa>
        mua = new Matrix(noUsers, noRoles, (byte)0);
    //   57  122:aload_0         
    //   58  123:new             #49  <Class Matrix>
    //   59  126:dup             
    //   60  127:aload_0         
    //   61  128:getfield        #55  <Field int noUsers>
    //   62  131:aload_0         
    //   63  132:getfield        #91  <Field int noRoles>
    //   64  135:iconst_0        
    //   65  136:invokespecial   #98  <Method void Matrix(int, int, byte)>
    //   66  139:putfield        #100 <Field Matrix mua>
        for(int i = 0; i < noUsers; i++)
    //*  67  142:iconst_0        
    //*  68  143:istore          5
    //*  69  145:goto            262
        {
            boolean used[] = new boolean[noRoles];
    //   70  148:aload_0         
    //   71  149:getfield        #91  <Field int noRoles>
    //   72  152:newarray        boolean[]
    //   73  154:astore          6
            IntegerSet temp = new IntegerSet(noPerms);
    //   74  156:new             #102 <Class IntegerSet>
    //   75  159:dup             
    //   76  160:aload_0         
    //   77  161:getfield        #60  <Field int noPerms>
    //   78  164:invokespecial   #105 <Method void IntegerSet(int)>
    //   79  167:astore          8
            for(int j = 0; j < noRoles; j++)
    //*  80  169:iconst_0        
    //*  81  170:istore          9
    //*  82  172:goto            184
                used[j] = false;
    //   83  175:aload           6
    //   84  177:iload           9
    //   85  179:iconst_0        
    //   86  180:bastore         

    //   87  181:iinc            9  1
    //   88  184:iload           9
    //   89  186:aload_0         
    //   90  187:getfield        #91  <Field int noRoles>
    //   91  190:icmplt          175
    //*  92  193:goto            240
            int next;
            while((next = nextLargestRole(isUpa[i], used)) >= 0) 
            {
                temp = temp.getUnion(isPa[next]);
    //   93  196:aload           8
    //   94  198:aload_0         
    //   95  199:getfield        #95  <Field IntegerSet[] isPa>
    //   96  202:iload           7
    //   97  204:aaload          
    //   98  205:invokevirtual   #109 <Method IntegerSet IntegerSet.getUnion(IntegerSet)>
    //   99  208:astore          8
                mua.set(i, next, (byte)1);
    //  100  210:aload_0         
    //  101  211:getfield        #100 <Field Matrix mua>
    //  102  214:iload           5
    //  103  216:iload           7
    //  104  218:iconst_1        
    //  105  219:invokevirtual   #112 <Method void Matrix.set(int, int, byte)>
                if(temp.equals(isUpa[i]))
    //* 106  222:aload           8
    //* 107  224:aload_0         
    //* 108  225:getfield        #89  <Field IntegerSet[] isUpa>
    //* 109  228:iload           5
    //* 110  230:aaload          
    //* 111  231:invokevirtual   #116 <Method boolean IntegerSet.equals(IntegerSet)>
    //* 112  234:ifeq            240
                    break;
    //  113  237:goto            259
            }
    //  114  240:aload_0         
    //  115  241:aload_0         
    //  116  242:getfield        #89  <Field IntegerSet[] isUpa>
    //  117  245:iload           5
    //  118  247:aaload          
    //  119  248:aload           6
    //  120  250:invokespecial   #120 <Method int nextLargestRole(IntegerSet, boolean[])>
    //  121  253:dup             
    //  122  254:istore          7
    //  123  256:ifge            196
        }

    //  124  259:iinc            5  1
    //  125  262:iload           5
    //  126  264:aload_0         
    //  127  265:getfield        #55  <Field int noUsers>
    //  128  268:icmplt          148
    //  129  271:return          
    }

    private IntegerSet[] genIntegerSet(Matrix mat)
    {
        int nr = mat.getRowDimension();
    //    0    0:aload_1         
    //    1    1:invokevirtual   #53  <Method int Matrix.getRowDimension()>
    //    2    4:istore_2        
        int nc = mat.getColumnDimension();
    //    3    5:aload_1         
    //    4    6:invokevirtual   #58  <Method int Matrix.getColumnDimension()>
    //    5    9:istore_3        
        IntegerSet inset[] = new IntegerSet[nr];
    //    6   10:iload_2         
    //    7   11:anewarray       IntegerSet[]
    //    8   14:astore          4
        for(int i = 0; i < nr; i++)
    //*   9   16:iconst_0        
    //*  10   17:istore          5
    //*  11   19:goto            75
        {
            inset[i] = new IntegerSet(nc);
    //   12   22:aload           4
    //   13   24:iload           5
    //   14   26:new             #102 <Class IntegerSet>
    //   15   29:dup             
    //   16   30:iload_3         
    //   17   31:invokespecial   #105 <Method void IntegerSet(int)>
    //   18   34:aastore         
            for(int j = 0; j < nc; j++)
    //*  19   35:iconst_0        
    //*  20   36:istore          6
    //*  21   38:goto            66
                if(mat.get(i, j) == 1)
    //*  22   41:aload_1         
    //*  23   42:iload           5
    //*  24   44:iload           6
    //*  25   46:invokevirtual   #135 <Method byte Matrix.get(int, int)>
    //*  26   49:iconst_1        
    //*  27   50:icmpne          63
                    inset[i].addElement(j);
    //   28   53:aload           4
    //   29   55:iload           5
    //   30   57:aaload          
    //   31   58:iload           6
    //   32   60:invokevirtual   #138 <Method void IntegerSet.addElement(int)>

    //   33   63:iinc            6  1
    //   34   66:iload           6
    //   35   68:iload_3         
    //   36   69:icmplt          41
        }

    //   37   72:iinc            5  1
    //   38   75:iload           5
    //   39   77:iload_2         
    //   40   78:icmplt          22
        return inset;
    //   41   81:aload           4
    //   42   83:areturn         
    }

    private int nextLargestRole(IntegerSet ui, boolean used[])
    {
        int i = -1;
    //    0    0:iconst_m1       
    //    1    1:istore_3        
        int l = -1;
    //    2    2:iconst_m1       
    //    3    3:istore          4
        int n_covered = -1;
    //    4    5:iconst_m1       
    //    5    6:istore          5
        for(i = 0; i < noRoles; i++)
    //*   6    8:iconst_0        
    //*   7    9:istore_3        
    //*   8   10:goto            63
            if(ui.contains(isPa[i]) && !used[i] && isPa[i].getSize() > n_covered)
    //*   9   13:aload_1         
    //*  10   14:aload_0         
    //*  11   15:getfield        #95  <Field IntegerSet[] isPa>
    //*  12   18:iload_3         
    //*  13   19:aaload          
    //*  14   20:invokevirtual   #145 <Method boolean IntegerSet.contains(IntegerSet)>
    //*  15   23:ifeq            60
    //*  16   26:aload_2         
    //*  17   27:iload_3         
    //*  18   28:baload          
    //*  19   29:ifne            60
    //*  20   32:aload_0         
    //*  21   33:getfield        #95  <Field IntegerSet[] isPa>
    //*  22   36:iload_3         
    //*  23   37:aaload          
    //*  24   38:invokevirtual   #148 <Method int IntegerSet.getSize()>
    //*  25   41:iload           5
    //*  26   43:icmple          60
            {
                l = i;
    //   27   46:iload_3         
    //   28   47:istore          4
                n_covered = isPa[i].getSize();
    //   29   49:aload_0         
    //   30   50:getfield        #95  <Field IntegerSet[] isPa>
    //   31   53:iload_3         
    //   32   54:aaload          
    //   33   55:invokevirtual   #148 <Method int IntegerSet.getSize()>
    //   34   58:istore          5
            }

    //   35   60:iinc            3  1
    //   36   63:iload_3         
    //   37   64:aload_0         
    //   38   65:getfield        #91  <Field int noRoles>
    //   39   68:icmplt          13
        if(l != -1)
    //*  40   71:iload           4
    //*  41   73:iconst_m1       
    //*  42   74:icmpeq          82
            used[l] = true;
    //   43   77:aload_2         
    //   44   78:iload           4
    //   45   80:iconst_1        
    //   46   81:bastore         
        return l;
    //   47   82:iload           4
    //   48   84:ireturn         
    }

    public String toString()
    {
        StringBuffer txt = new StringBuffer();
    //    0    0:new             #155 <Class StringBuffer>
    //    1    3:dup             
    //    2    4:invokespecial   #156 <Method void StringBuffer()>
    //    3    7:astore_1        
        boolean flag = false;
    //    4    8:iconst_0        
    //    5    9:istore_2        
        for(int i = 0; i < noUsers; i++)
    //*   6   10:iconst_0        
    //*   7   11:istore_3        
    //*   8   12:goto            135
        {
            txt.append((new StringBuilder()).append(userSet[i]).append(": [").toString());
    //    9   15:aload_1         
    //   10   16:new             #158 <Class StringBuilder>
    //   11   19:dup             
    //   12   20:invokespecial   #159 <Method void StringBuilder()>
    //   13   23:aload_0         
    //   14   24:getfield        #78  <Field Object[] userSet>
    //   15   27:iload_3         
    //   16   28:aaload          
    //   17   29:invokevirtual   #163 <Method StringBuilder StringBuilder.append(Object)>
    //   18   32:ldc1            #165 <String ": [">
    //   19   34:invokevirtual   #168 <Method StringBuilder StringBuilder.append(String)>
    //   20   37:invokevirtual   #170 <Method String StringBuilder.toString()>
    //   21   40:invokevirtual   #173 <Method StringBuffer StringBuffer.append(String)>
    //   22   43:pop             
            flag = false;
    //   23   44:iconst_0        
    //   24   45:istore_2        
            for(int j = 0; j < noRoles; j++)
    //*  25   46:iconst_0        
    //*  26   47:istore          4
    //*  27   49:goto            101
                if(mua.get(i, j) == 1)
    //*  28   52:aload_0         
    //*  29   53:getfield        #100 <Field Matrix mua>
    //*  30   56:iload_3         
    //*  31   57:iload           4
    //*  32   59:invokevirtual   #135 <Method byte Matrix.get(int, int)>
    //*  33   62:iconst_1        
    //*  34   63:icmpne          98
                {
                    txt.append((new StringBuilder()).append(roleSet[j]).append(",").toString());
    //   35   66:aload_1         
    //   36   67:new             #158 <Class StringBuilder>
    //   37   70:dup             
    //   38   71:invokespecial   #159 <Method void StringBuilder()>
    //   39   74:aload_0         
    //   40   75:getfield        #93  <Field Object[] roleSet>
    //   41   78:iload           4
    //   42   80:aaload          
    //   43   81:invokevirtual   #163 <Method StringBuilder StringBuilder.append(Object)>
    //   44   84:ldc1            #175 <String ",">
    //   45   86:invokevirtual   #168 <Method StringBuilder StringBuilder.append(String)>
    //   46   89:invokevirtual   #170 <Method String StringBuilder.toString()>
    //   47   92:invokevirtual   #173 <Method StringBuffer StringBuffer.append(String)>
    //   48   95:pop             
                    flag = true;
    //   49   96:iconst_1        
    //   50   97:istore_2        
                }

    //   51   98:iinc            4  1
    //   52  101:iload           4
    //   53  103:aload_0         
    //   54  104:getfield        #91  <Field int noRoles>
    //   55  107:icmplt          52
            if(flag)
    //*  56  110:iload_2         
    //*  57  111:ifeq            125
                txt.deleteCharAt(txt.length() - 1);
    //   58  114:aload_1         
    //   59  115:aload_1         
    //   60  116:invokevirtual   #178 <Method int StringBuffer.length()>
    //   61  119:iconst_1        
    //   62  120:isub            
    //   63  121:invokevirtual   #182 <Method StringBuffer StringBuffer.deleteCharAt(int)>
    //   64  124:pop             
            txt.append("]\n");
    //   65  125:aload_1         
    //   66  126:ldc1            #184 <String "]\n">
    //   67  128:invokevirtual   #173 <Method StringBuffer StringBuffer.append(String)>
    //   68  131:pop             
        }

    //   69  132:iinc            3  1
    //   70  135:iload_3         
    //   71  136:aload_0         
    //   72  137:getfield        #55  <Field int noUsers>
    //   73  140:icmplt          15
        return txt.toString();
    //   74  143:aload_1         
    //   75  144:invokevirtual   #185 <Method String StringBuffer.toString()>
    //   76  147:areturn         
    }

    public Assignment generateUA()
    {
        m_ua = new Assignment();
    //    0    0:aload_0         
    //    1    1:new             #43  <Class Assignment>
    //    2    4:dup             
    //    3    5:invokespecial   #192 <Method void Assignment()>
    //    4    8:putfield        #194 <Field Assignment m_ua>
        m_ua.setAssignementName("user-role");
    //    5   11:aload_0         
    //    6   12:getfield        #194 <Field Assignment m_ua>
    //    7   15:ldc1            #196 <String "user-role">
    //    8   17:invokevirtual   #200 <Method void Assignment.setAssignementName(String)>
        m_ua.setAssignmentMatrix(mua);
    //    9   20:aload_0         
    //   10   21:getfield        #194 <Field Assignment m_ua>
    //   11   24:aload_0         
    //   12   25:getfield        #100 <Field Matrix mua>
    //   13   28:invokevirtual   #204 <Method void Assignment.setAssignmentMatrix(Matrix)>
        m_ua.setDimensionX(m_assignment.getDimensionX());
    //   14   31:aload_0         
    //   15   32:getfield        #194 <Field Assignment m_ua>
    //   16   35:aload_0         
    //   17   36:getfield        #39  <Field Assignment m_assignment>
    //   18   39:invokevirtual   #64  <Method Dimension Assignment.getDimensionX()>
    //   19   42:invokevirtual   #208 <Method void Assignment.setDimensionX(Dimension)>
        m_ua.setDimensionY(m_assroles.getDimensionX());
    //   20   45:aload_0         
    //   21   46:getfield        #194 <Field Assignment m_ua>
    //   22   49:aload_0         
    //   23   50:getfield        #41  <Field Assignment m_assroles>
    //   24   53:invokevirtual   #64  <Method Dimension Assignment.getDimensionX()>
    //   25   56:invokevirtual   #211 <Method void Assignment.setDimensionY(Dimension)>
        return m_ua;
    //   26   59:aload_0         
    //   27   60:getfield        #194 <Field Assignment m_ua>
    //   28   63:areturn         
    }

    public String globalInfo()
    {
        return "A greed algorithm to assign roles\nto users according to the upa.";
    //    0    0:ldc1            #214 <String "A greed algorithm to assign roles\nto users according to the upa.">
    //    1    2:areturn         
    }

    public Capabilities getCapabilities()
    {
        Capabilities result = super.getCapabilities();
    //    0    0:aload_0         
    //    1    1:invokespecial   #218 <Method Capabilities AbstractAssignment.getCapabilities()>
    //    2    4:astore_1        
        result.disableAll();
    //    3    5:aload_1         
    //    4    6:invokevirtual   #223 <Method void Capabilities.disableAll()>
        result.enable(rm.core.Capabilities.Capability.NOMINAL_ATTRIBUTES);
    //    5    9:aload_1         
    //    6   10:getstatic       #229 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.NOMINAL_ATTRIBUTES>
    //    7   13:invokevirtual   #233 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enable(rm.core.Capabilities.Capability.MISSING_VALUES);
    //    8   16:aload_1         
    //    9   17:getstatic       #236 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.MISSING_VALUES>
    //   10   20:invokevirtual   #233 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enable(rm.core.Capabilities.Capability.NO_CLASS);
    //   11   23:aload_1         
    //   12   24:getstatic       #239 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.NO_CLASS>
    //   13   27:invokevirtual   #233 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enable(rm.core.Capabilities.Capability.NOMINAL_CLASS);
    //   14   30:aload_1         
    //   15   31:getstatic       #242 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.NOMINAL_CLASS>
    //   16   34:invokevirtual   #233 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enable(rm.core.Capabilities.Capability.MISSING_CLASS_VALUES);
    //   17   37:aload_1         
    //   18   38:getstatic       #245 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.MISSING_CLASS_VALUES>
    //   19   41:invokevirtual   #233 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        return result;
    //   20   44:aload_1         
    //   21   45:areturn         
    }

    public Enumeration listOptions()
    {
        String string1 = "\t. this algorithm has no parameters.";
    //    0    0:ldc1            #251 <String "\t. this algorithm has no parameters.">
    //    1    2:astore_1        
        FastVector newVector = new FastVector(1);
    //    2    3:new             #253 <Class FastVector>
    //    3    6:dup             
    //    4    7:iconst_1        
    //    5    8:invokespecial   #254 <Method void FastVector(int)>
    //    6   11:astore_2        
        newVector.addElement(new Option(string1, "", 0, "- <no paramenters>"));
    //    7   12:aload_2         
    //    8   13:new             #256 <Class Option>
    //    9   16:dup             
    //   10   17:aload_1         
    //   11   18:ldc2            #258 <String "">
    //   12   21:iconst_0        
    //   13   22:ldc2            #260 <String "- <no paramenters>">
    //   14   25:invokespecial   #263 <Method void Option(String, String, int, String)>
    //   15   28:invokevirtual   #266 <Method void FastVector.addElement(Object)>
        return newVector.elements();
    //   16   31:aload_2         
    //   17   32:invokevirtual   #269 <Method Enumeration FastVector.elements()>
    //   18   35:areturn         
    }

    public void setOptions(String as[])
        throws Exception
    {
    //    0    0:return          
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
        options[current++] = "";
    //    5    8:aload_1         
    //    6    9:iload_2         
    //    7   10:iinc            2  1
    //    8   13:ldc2            #258 <String "">
    //    9   16:aastore         
        for(options[current++] = ""; current < options.length; options[current++] = "");
    //   10   17:aload_1         
    //   11   18:iload_2         
    //   12   19:iinc            2  1
    //   13   22:ldc2            #258 <String "">
    //   14   25:aastore         
    //   15   26:goto            38
    //   16   29:aload_1         
    //   17   30:iload_2         
    //   18   31:iinc            2  1
    //   19   34:ldc2            #258 <String "">
    //   20   37:aastore         
    //   21   38:iload_2         
    //   22   39:aload_1         
    //   23   40:arraylength     
    //   24   41:icmplt          29
        return options;
    //   25   44:aload_1         
    //   26   45:areturn         
    }

    public static void main(String args[])
    {
        try
        {
            File fileupa = new File((new StringBuilder(String.valueOf(System.getProperty("user.dir")))).append("\\datasets\\test-user-permission.up").toString());
    //    0    0:new             #285 <Class File>
    //    1    3:dup             
    //    2    4:new             #158 <Class StringBuilder>
    //    3    7:dup             
    //    4    8:ldc2            #287 <String "user.dir">
    //    5   11:invokestatic    #293 <Method String System.getProperty(String)>
    //    6   14:invokestatic    #297 <Method String String.valueOf(Object)>
    //    7   17:invokespecial   #299 <Method void StringBuilder(String)>
    //    8   20:ldc2            #301 <String "\\datasets\\test-user-permission.up">
    //    9   23:invokevirtual   #168 <Method StringBuilder StringBuilder.append(String)>
    //   10   26:invokevirtual   #170 <Method String StringBuilder.toString()>
    //   11   29:invokespecial   #302 <Method void File(String)>
    //   12   32:astore_1        
            AssLoader ALupa = new AssLoader(new FileReader(fileupa));
    //   13   33:new             #304 <Class AssLoader>
    //   14   36:dup             
    //   15   37:new             #306 <Class FileReader>
    //   16   40:dup             
    //   17   41:aload_1         
    //   18   42:invokespecial   #309 <Method void FileReader(File)>
    //   19   45:invokespecial   #312 <Method void AssLoader(FileReader)>
    //   20   48:astore_2        
            Assignment Assupa = ALupa.getData();
    //   21   49:aload_2         
    //   22   50:invokevirtual   #315 <Method Assignment AssLoader.getData()>
    //   23   53:astore_3        
            System.out.println(Assupa.getAssignementName());
    //   24   54:getstatic       #319 <Field PrintStream System.out>
    //   25   57:aload_3         
    //   26   58:invokevirtual   #322 <Method String Assignment.getAssignementName()>
    //   27   61:invokevirtual   #327 <Method void PrintStream.println(String)>
            File filepa = new File((new StringBuilder(String.valueOf(System.getProperty("user.dir")))).append("\\datasets\\ORCA.ass").toString());
    //   28   64:new             #285 <Class File>
    //   29   67:dup             
    //   30   68:new             #158 <Class StringBuilder>
    //   31   71:dup             
    //   32   72:ldc2            #287 <String "user.dir">
    //   33   75:invokestatic    #293 <Method String System.getProperty(String)>
    //   34   78:invokestatic    #297 <Method String String.valueOf(Object)>
    //   35   81:invokespecial   #299 <Method void StringBuilder(String)>
    //   36   84:ldc2            #329 <String "\\datasets\\ORCA.ass">
    //   37   87:invokevirtual   #168 <Method StringBuilder StringBuilder.append(String)>
    //   38   90:invokevirtual   #170 <Method String StringBuilder.toString()>
    //   39   93:invokespecial   #302 <Method void File(String)>
    //   40   96:astore          4
            AssLoader ALpa = new AssLoader(new FileReader(filepa));
    //   41   98:new             #304 <Class AssLoader>
    //   42  101:dup             
    //   43  102:new             #306 <Class FileReader>
    //   44  105:dup             
    //   45  106:aload           4
    //   46  108:invokespecial   #309 <Method void FileReader(File)>
    //   47  111:invokespecial   #312 <Method void AssLoader(FileReader)>
    //   48  114:astore          5
            Assignment Asspa = ALpa.getData();
    //   49  116:aload           5
    //   50  118:invokevirtual   #315 <Method Assignment AssLoader.getData()>
    //   51  121:astore          6
            System.out.println(Asspa.getAssignementName());
    //   52  123:getstatic       #319 <Field PrintStream System.out>
    //   53  126:aload           6
    //   54  128:invokevirtual   #322 <Method String Assignment.getAssignementName()>
    //   55  131:invokevirtual   #327 <Method void PrintStream.println(String)>
            Greed gd = new Greed();
    //   56  134:new             #2   <Class Greed>
    //   57  137:dup             
    //   58  138:invokespecial   #330 <Method void Greed()>
    //   59  141:astore          7
            gd.buildAssigns(Assupa, Asspa);
    //   60  143:aload           7
    //   61  145:aload_3         
    //   62  146:aload           6
    //   63  148:invokevirtual   #332 <Method void buildAssigns(Assignment, Assignment)>
            System.out.println(gd.toString());
    //   64  151:getstatic       #319 <Field PrintStream System.out>
    //   65  154:aload           7
    //   66  156:invokevirtual   #333 <Method String toString()>
    //   67  159:invokevirtual   #327 <Method void PrintStream.println(String)>
            System.out.println(gd.generateUA().toString());
    //   68  162:getstatic       #319 <Field PrintStream System.out>
    //   69  165:aload           7
    //   70  167:invokevirtual   #335 <Method Assignment generateUA()>
    //   71  170:invokevirtual   #336 <Method String Assignment.toString()>
    //   72  173:invokevirtual   #327 <Method void PrintStream.println(String)>
        }
    //*  73  176:goto            184
        catch(Exception e)
    //*  74  179:astore_1        
        {
            e.printStackTrace();
    //   75  180:aload_1         
    //   76  181:invokevirtual   #339 <Method void Exception.printStackTrace()>
        }
    //   77  184:return          
    }

    private Assignment m_assignment;
    private Assignment m_assroles;
    private Assignment m_ua;
    private int noUsers;
    private int noRoles;
    private int noPerms;
    private Object userSet[];
    private Object roleSet[];
    private Object permSet[];
    private IntegerSet isUpa[];
    private IntegerSet isPa[];
    private Matrix mua;

    @Override
    public Assignment generateUA() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Matrix getAssignmentMatrix() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getDimensionX() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getDimensionY() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
