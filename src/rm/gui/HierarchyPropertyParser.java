// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   HierarchyPropertyParser.java

package rm.gui;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.StringTokenizer;
import java.util.Vector;

public class HierarchyPropertyParser
    implements Serializable
{
    private class TreeNode
    {

        public TreeNode parent;
        public String value;
        public Vector children;
        public int level;
        public String context;
        final HierarchyPropertyParser this$0;

        TreeNode()
        {
            this$0 = HierarchyPropertyParser.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #20  <Field HierarchyPropertyParser this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #23  <Method void Object()>
            parent = null;
        //    5    9:aload_0         
        //    6   10:aconst_null     
        //    7   11:putfield        #25  <Field HierarchyPropertyParser$TreeNode parent>
            value = null;
        //    8   14:aload_0         
        //    9   15:aconst_null     
        //   10   16:putfield        #27  <Field String value>
            children = null;
        //   11   19:aload_0         
        //   12   20:aconst_null     
        //   13   21:putfield        #29  <Field Vector children>
            level = 0;
        //   14   24:aload_0         
        //   15   25:iconst_0        
        //   16   26:putfield        #31  <Field int level>
            context = null;
        //   17   29:aload_0         
        //   18   30:aconst_null     
        //   19   31:putfield        #33  <Field String context>
        //   20   34:return          
        }
    }


    public HierarchyPropertyParser()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #23  <Method void Object()>
        m_Seperator = ".";
    //    2    4:aload_0         
    //    3    5:ldc1            #25  <String ".">
    //    4    7:putfield        #27  <Field String m_Seperator>
        m_Depth = 0;
    //    5   10:aload_0         
    //    6   11:iconst_0        
    //    7   12:putfield        #29  <Field int m_Depth>
        m_Root = new TreeNode();
    //    8   15:aload_0         
    //    9   16:new             #31  <Class HierarchyPropertyParser$TreeNode>
    //   10   19:dup             
    //   11   20:aload_0         
    //   12   21:invokespecial   #34  <Method void HierarchyPropertyParser$TreeNode(HierarchyPropertyParser)>
    //   13   24:putfield        #36  <Field HierarchyPropertyParser$TreeNode m_Root>
        m_Root.parent = null;
    //   14   27:aload_0         
    //   15   28:getfield        #36  <Field HierarchyPropertyParser$TreeNode m_Root>
    //   16   31:aconst_null     
    //   17   32:putfield        #39  <Field HierarchyPropertyParser$TreeNode HierarchyPropertyParser$TreeNode.parent>
        m_Root.children = new Vector();
    //   18   35:aload_0         
    //   19   36:getfield        #36  <Field HierarchyPropertyParser$TreeNode m_Root>
    //   20   39:new             #41  <Class Vector>
    //   21   42:dup             
    //   22   43:invokespecial   #42  <Method void Vector()>
    //   23   46:putfield        #46  <Field Vector HierarchyPropertyParser$TreeNode.children>
        goToRoot();
    //   24   49:aload_0         
    //   25   50:invokevirtual   #49  <Method void goToRoot()>
    //   26   53:return          
    }

    public HierarchyPropertyParser(String p, String delim)
        throws Exception
    {
        this();
    //    0    0:aload_0         
    //    1    1:invokespecial   #58  <Method void HierarchyPropertyParser()>
        build(p, delim);
    //    2    4:aload_0         
    //    3    5:aload_1         
    //    4    6:aload_2         
    //    5    7:invokevirtual   #61  <Method void build(String, String)>
    //    6   10:return          
    }

    public void setSeperator(String s)
    {
        m_Seperator = s;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #27  <Field String m_Seperator>
    //    3    5:return          
    }

    public String getSeperator()
    {
        return m_Seperator;
    //    0    0:aload_0         
    //    1    1:getfield        #27  <Field String m_Seperator>
    //    2    4:areturn         
    }

    public void build(String p, String delim)
        throws Exception
    {
        String property;
        for(StringTokenizer st = new StringTokenizer(p, delim); st.hasMoreTokens(); add(property))
    //*   0    0:new             #70  <Class StringTokenizer>
    //*   1    3:dup             
    //*   2    4:aload_1         
    //*   3    5:aload_2         
    //*   4    6:invokespecial   #72  <Method void StringTokenizer(String, String)>
    //*   5    9:astore_3        
    //*   6   10:goto            47
        {
            property = st.nextToken().trim();
    //    7   13:aload_3         
    //    8   14:invokevirtual   #75  <Method String StringTokenizer.nextToken()>
    //    9   17:invokevirtual   #80  <Method String String.trim()>
    //   10   20:astore          4
            if(!isHierachic(property))
    //*  11   22:aload_0         
    //*  12   23:aload           4
    //*  13   25:invokevirtual   #84  <Method boolean isHierachic(String)>
    //*  14   28:ifne            41
                throw new Exception("The given property is not inhierachy structure with seperators!");
    //   15   31:new             #57  <Class Exception>
    //   16   34:dup             
    //   17   35:ldc1            #86  <String "The given property is not inhierachy structure with seperators!">
    //   18   37:invokespecial   #88  <Method void Exception(String)>
    //   19   40:athrow          
        }

    //   20   41:aload_0         
    //   21   42:aload           4
    //   22   44:invokevirtual   #91  <Method void add(String)>
    //   23   47:aload_3         
    //   24   48:invokevirtual   #95  <Method boolean StringTokenizer.hasMoreTokens()>
    //   25   51:ifne            13
        goToRoot();
    //   26   54:aload_0         
    //   27   55:invokevirtual   #49  <Method void goToRoot()>
    //   28   58:return          
    }

    public synchronized void add(String property)
    {
        String values[] = tokenize(property);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokevirtual   #102 <Method String[] tokenize(String)>
    //    3    5:astore_2        
        if(m_Root.value == null)
    //*   4    6:aload_0         
    //*   5    7:getfield        #36  <Field HierarchyPropertyParser$TreeNode m_Root>
    //*   6   10:getfield        #105 <Field String HierarchyPropertyParser$TreeNode.value>
    //*   7   13:ifnonnull       26
            m_Root.value = values[0];
    //    8   16:aload_0         
    //    9   17:getfield        #36  <Field HierarchyPropertyParser$TreeNode m_Root>
    //   10   20:aload_2         
    //   11   21:iconst_0        
    //   12   22:aaload          
    //   13   23:putfield        #105 <Field String HierarchyPropertyParser$TreeNode.value>
        buildBranch(m_Root, values, 1);
    //   14   26:aload_0         
    //   15   27:aload_0         
    //   16   28:getfield        #36  <Field HierarchyPropertyParser$TreeNode m_Root>
    //   17   31:aload_2         
    //   18   32:iconst_1        
    //   19   33:invokespecial   #109 <Method void buildBranch(HierarchyPropertyParser$TreeNode, String[], int)>
    //   20   36:return          
    }

    private void buildBranch(TreeNode parent, String values[], int lvl)
    {
        if(lvl == values.length)
    //*   0    0:iload_3         
    //*   1    1:aload_2         
    //*   2    2:arraylength     
    //*   3    3:icmpne          12
        {
            parent.children = null;
    //    4    6:aload_1         
    //    5    7:aconst_null     
    //    6    8:putfield        #46  <Field Vector HierarchyPropertyParser$TreeNode.children>
            return;
    //    7   11:return          
        }
        if(lvl > m_Depth - 1)
    //*   8   12:iload_3         
    //*   9   13:aload_0         
    //*  10   14:getfield        #29  <Field int m_Depth>
    //*  11   17:iconst_1        
    //*  12   18:isub            
    //*  13   19:icmple          29
            m_Depth = lvl + 1;
    //   14   22:aload_0         
    //   15   23:iload_3         
    //   16   24:iconst_1        
    //   17   25:iadd            
    //   18   26:putfield        #29  <Field int m_Depth>
        Vector kids = parent.children;
    //   19   29:aload_1         
    //   20   30:getfield        #46  <Field Vector HierarchyPropertyParser$TreeNode.children>
    //   21   33:astore          4
        int index = search(kids, values[lvl]);
    //   22   35:aload_0         
    //   23   36:aload           4
    //   24   38:aload_2         
    //   25   39:iload_3         
    //   26   40:aaload          
    //   27   41:invokevirtual   #115 <Method int search(Vector, String)>
    //   28   44:istore          5
        if(index != -1)
    //*  29   46:iload           5
    //*  30   48:iconst_m1       
    //*  31   49:icmpeq          100
        {
            TreeNode newParent = (TreeNode)(TreeNode)kids.elementAt(index);
    //   32   52:aload           4
    //   33   54:iload           5
    //   34   56:invokevirtual   #119 <Method Object Vector.elementAt(int)>
    //   35   59:checkcast       #31  <Class HierarchyPropertyParser$TreeNode>
    //   36   62:checkcast       #31  <Class HierarchyPropertyParser$TreeNode>
    //   37   65:astore          6
            if(newParent.children == null)
    //*  38   67:aload           6
    //*  39   69:getfield        #46  <Field Vector HierarchyPropertyParser$TreeNode.children>
    //*  40   72:ifnonnull       87
                newParent.children = new Vector();
    //   41   75:aload           6
    //   42   77:new             #41  <Class Vector>
    //   43   80:dup             
    //   44   81:invokespecial   #42  <Method void Vector()>
    //   45   84:putfield        #46  <Field Vector HierarchyPropertyParser$TreeNode.children>
            buildBranch(newParent, values, lvl + 1);
    //   46   87:aload_0         
    //   47   88:aload           6
    //   48   90:aload_2         
    //   49   91:iload_3         
    //   50   92:iconst_1        
    //   51   93:iadd            
    //   52   94:invokespecial   #109 <Method void buildBranch(HierarchyPropertyParser$TreeNode, String[], int)>
        } else
    //*  53   97:goto            215
        {
            TreeNode added = new TreeNode();
    //   54  100:new             #31  <Class HierarchyPropertyParser$TreeNode>
    //   55  103:dup             
    //   56  104:aload_0         
    //   57  105:invokespecial   #34  <Method void HierarchyPropertyParser$TreeNode(HierarchyPropertyParser)>
    //   58  108:astore          6
            added.parent = parent;
    //   59  110:aload           6
    //   60  112:aload_1         
    //   61  113:putfield        #39  <Field HierarchyPropertyParser$TreeNode HierarchyPropertyParser$TreeNode.parent>
            added.value = values[lvl];
    //   62  116:aload           6
    //   63  118:aload_2         
    //   64  119:iload_3         
    //   65  120:aaload          
    //   66  121:putfield        #105 <Field String HierarchyPropertyParser$TreeNode.value>
            added.children = new Vector();
    //   67  124:aload           6
    //   68  126:new             #41  <Class Vector>
    //   69  129:dup             
    //   70  130:invokespecial   #42  <Method void Vector()>
    //   71  133:putfield        #46  <Field Vector HierarchyPropertyParser$TreeNode.children>
            added.level = lvl;
    //   72  136:aload           6
    //   73  138:iload_3         
    //   74  139:putfield        #122 <Field int HierarchyPropertyParser$TreeNode.level>
            if(parent != m_Root)
    //*  75  142:aload_1         
    //*  76  143:aload_0         
    //*  77  144:getfield        #36  <Field HierarchyPropertyParser$TreeNode m_Root>
    //*  78  147:if_acmpeq       189
                added.context = (new StringBuilder(String.valueOf(parent.context))).append(m_Seperator).append(parent.value).toString();
    //   79  150:aload           6
    //   80  152:new             #124 <Class StringBuilder>
    //   81  155:dup             
    //   82  156:aload_1         
    //   83  157:getfield        #127 <Field String HierarchyPropertyParser$TreeNode.context>
    //   84  160:invokestatic    #131 <Method String String.valueOf(Object)>
    //   85  163:invokespecial   #132 <Method void StringBuilder(String)>
    //   86  166:aload_0         
    //   87  167:getfield        #27  <Field String m_Seperator>
    //   88  170:invokevirtual   #136 <Method StringBuilder StringBuilder.append(String)>
    //   89  173:aload_1         
    //   90  174:getfield        #105 <Field String HierarchyPropertyParser$TreeNode.value>
    //   91  177:invokevirtual   #136 <Method StringBuilder StringBuilder.append(String)>
    //   92  180:invokevirtual   #139 <Method String StringBuilder.toString()>
    //   93  183:putfield        #127 <Field String HierarchyPropertyParser$TreeNode.context>
            else
    //*  94  186:goto            198
                added.context = parent.value;
    //   95  189:aload           6
    //   96  191:aload_1         
    //   97  192:getfield        #105 <Field String HierarchyPropertyParser$TreeNode.value>
    //   98  195:putfield        #127 <Field String HierarchyPropertyParser$TreeNode.context>
            kids.addElement(added);
    //   99  198:aload           4
    //  100  200:aload           6
    //  101  202:invokevirtual   #143 <Method void Vector.addElement(Object)>
            buildBranch(added, values, lvl + 1);
    //  102  205:aload_0         
    //  103  206:aload           6
    //  104  208:aload_2         
    //  105  209:iload_3         
    //  106  210:iconst_1        
    //  107  211:iadd            
    //  108  212:invokespecial   #109 <Method void buildBranch(HierarchyPropertyParser$TreeNode, String[], int)>
        }
    //  109  215:return          
    }

    public String[] tokenize(String rawString)
    {
        Vector result = new Vector();
    //    0    0:new             #41  <Class Vector>
    //    1    3:dup             
    //    2    4:invokespecial   #42  <Method void Vector()>
    //    3    7:astore_2        
        for(StringTokenizer tk = new StringTokenizer(rawString, m_Seperator); tk.hasMoreTokens(); result.addElement(tk.nextToken()));
    //    4    8:new             #70  <Class StringTokenizer>
    //    5   11:dup             
    //    6   12:aload_1         
    //    7   13:aload_0         
    //    8   14:getfield        #27  <Field String m_Seperator>
    //    9   17:invokespecial   #72  <Method void StringTokenizer(String, String)>
    //   10   20:astore_3        
    //   11   21:goto            32
    //   12   24:aload_2         
    //   13   25:aload_3         
    //   14   26:invokevirtual   #75  <Method String StringTokenizer.nextToken()>
    //   15   29:invokevirtual   #143 <Method void Vector.addElement(Object)>
    //   16   32:aload_3         
    //   17   33:invokevirtual   #95  <Method boolean StringTokenizer.hasMoreTokens()>
    //   18   36:ifne            24
        String newStrings[] = new String[result.size()];
    //   19   39:aload_2         
    //   20   40:invokevirtual   #152 <Method int Vector.size()>
    //   21   43:anewarray       String[]
    //   22   46:astore          4
        for(int i = 0; i < result.size(); i++)
    //*  23   48:iconst_0        
    //*  24   49:istore          5
    //*  25   51:goto            74
            newStrings[i] = (String)(String)result.elementAt(i);
    //   26   54:aload           4
    //   27   56:iload           5
    //   28   58:aload_2         
    //   29   59:iload           5
    //   30   61:invokevirtual   #119 <Method Object Vector.elementAt(int)>
    //   31   64:checkcast       #77  <Class String>
    //   32   67:checkcast       #77  <Class String>
    //   33   70:aastore         

    //   34   71:iinc            5  1
    //   35   74:iload           5
    //   36   76:aload_2         
    //   37   77:invokevirtual   #152 <Method int Vector.size()>
    //   38   80:icmplt          54
        return newStrings;
    //   39   83:aload           4
    //   40   85:areturn         
    }

    public boolean contains(String string)
    {
        String item[] = tokenize(string);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokevirtual   #102 <Method String[] tokenize(String)>
    //    3    5:astore_2        
        if(!item[0].equals(m_Root.value))
    //*   4    6:aload_2         
    //*   5    7:iconst_0        
    //*   6    8:aaload          
    //*   7    9:aload_0         
    //*   8   10:getfield        #36  <Field HierarchyPropertyParser$TreeNode m_Root>
    //*   9   13:getfield        #105 <Field String HierarchyPropertyParser$TreeNode.value>
    //*  10   16:invokevirtual   #162 <Method boolean String.equals(Object)>
    //*  11   19:ifne            24
            return false;
    //   12   22:iconst_0        
    //   13   23:ireturn         
        else
            return isContained(m_Root, item, 1);
    //   14   24:aload_0         
    //   15   25:aload_0         
    //   16   26:getfield        #36  <Field HierarchyPropertyParser$TreeNode m_Root>
    //   17   29:aload_2         
    //   18   30:iconst_1        
    //   19   31:invokespecial   #166 <Method boolean isContained(HierarchyPropertyParser$TreeNode, String[], int)>
    //   20   34:ireturn         
    }

    private boolean isContained(TreeNode parent, String values[], int lvl)
    {
        if(lvl == values.length)
    //*   0    0:iload_3         
    //*   1    1:aload_2         
    //*   2    2:arraylength     
    //*   3    3:icmpne          8
            return true;
    //    4    6:iconst_1        
    //    5    7:ireturn         
        if(lvl > values.length)
    //*   6    8:iload_3         
    //*   7    9:aload_2         
    //*   8   10:arraylength     
    //*   9   11:icmple          16
            return false;
    //   10   14:iconst_0        
    //   11   15:ireturn         
        Vector kids = parent.children;
    //   12   16:aload_1         
    //   13   17:getfield        #46  <Field Vector HierarchyPropertyParser$TreeNode.children>
    //   14   20:astore          4
        int index = search(kids, values[lvl]);
    //   15   22:aload_0         
    //   16   23:aload           4
    //   17   25:aload_2         
    //   18   26:iload_3         
    //   19   27:aaload          
    //   20   28:invokevirtual   #115 <Method int search(Vector, String)>
    //   21   31:istore          5
        if(index != -1)
    //*  22   33:iload           5
    //*  23   35:iconst_m1       
    //*  24   36:icmpeq          65
        {
            TreeNode newParent = (TreeNode)(TreeNode)kids.elementAt(index);
    //   25   39:aload           4
    //   26   41:iload           5
    //   27   43:invokevirtual   #119 <Method Object Vector.elementAt(int)>
    //   28   46:checkcast       #31  <Class HierarchyPropertyParser$TreeNode>
    //   29   49:checkcast       #31  <Class HierarchyPropertyParser$TreeNode>
    //   30   52:astore          6
            return isContained(newParent, values, lvl + 1);
    //   31   54:aload_0         
    //   32   55:aload           6
    //   33   57:aload_2         
    //   34   58:iload_3         
    //   35   59:iconst_1        
    //   36   60:iadd            
    //   37   61:invokespecial   #166 <Method boolean isContained(HierarchyPropertyParser$TreeNode, String[], int)>
    //   38   64:ireturn         
        } else
        {
            return false;
    //   39   65:iconst_0        
    //   40   66:ireturn         
        }
    }

    public boolean isHierachic(String string)
    {
        int index = string.indexOf(m_Seperator);
    //    0    0:aload_1         
    //    1    1:aload_0         
    //    2    2:getfield        #27  <Field String m_Seperator>
    //    3    5:invokevirtual   #172 <Method int String.indexOf(String)>
    //    4    8:istore_2        
        return index != string.length() - 1 && index != -1;
    //    5    9:iload_2         
    //    6   10:aload_1         
    //    7   11:invokevirtual   #175 <Method int String.length()>
    //    8   14:iconst_1        
    //    9   15:isub            
    //   10   16:icmpeq          24
    //   11   19:iload_2         
    //   12   20:iconst_m1       
    //   13   21:icmpne          26
    //   14   24:iconst_0        
    //   15   25:ireturn         
    //   16   26:iconst_1        
    //   17   27:ireturn         
    }

    public int search(Vector vct, String target)
    {
        if(vct == null)
    //*   0    0:aload_1         
    //*   1    1:ifnonnull       6
            return -1;
    //    2    4:iconst_m1       
    //    3    5:ireturn         
        for(int i = 0; i < vct.size(); i++)
    //*   4    6:iconst_0        
    //*   5    7:istore_3        
    //*   6    8:goto            37
            if(target.equals(((TreeNode)(TreeNode)vct.elementAt(i)).value))
    //*   7   11:aload_2         
    //*   8   12:aload_1         
    //*   9   13:iload_3         
    //*  10   14:invokevirtual   #119 <Method Object Vector.elementAt(int)>
    //*  11   17:checkcast       #31  <Class HierarchyPropertyParser$TreeNode>
    //*  12   20:checkcast       #31  <Class HierarchyPropertyParser$TreeNode>
    //*  13   23:getfield        #105 <Field String HierarchyPropertyParser$TreeNode.value>
    //*  14   26:invokevirtual   #162 <Method boolean String.equals(Object)>
    //*  15   29:ifeq            34
                return i;
    //   16   32:iload_3         
    //   17   33:ireturn         

    //   18   34:iinc            3  1
    //   19   37:iload_3         
    //   20   38:aload_1         
    //   21   39:invokevirtual   #152 <Method int Vector.size()>
    //   22   42:icmplt          11
        return -1;
    //   23   45:iconst_m1       
    //   24   46:ireturn         
    }

    public synchronized boolean goTo(String path)
    {
        if(!isHierachic(path))
    //*   0    0:aload_0         
    //*   1    1:aload_1         
    //*   2    2:invokevirtual   #84  <Method boolean isHierachic(String)>
    //*   3    5:ifne            30
            if(m_Root.value.equals(path))
    //*   4    8:aload_0         
    //*   5    9:getfield        #36  <Field HierarchyPropertyParser$TreeNode m_Root>
    //*   6   12:getfield        #105 <Field String HierarchyPropertyParser$TreeNode.value>
    //*   7   15:aload_1         
    //*   8   16:invokevirtual   #162 <Method boolean String.equals(Object)>
    //*   9   19:ifeq            28
            {
                goToRoot();
    //   10   22:aload_0         
    //   11   23:invokevirtual   #49  <Method void goToRoot()>
                return true;
    //   12   26:iconst_1        
    //   13   27:ireturn         
            } else
            {
                return false;
    //   14   28:iconst_0        
    //   15   29:ireturn         
            }
        TreeNode old = m_Current;
    //   16   30:aload_0         
    //   17   31:getfield        #180 <Field HierarchyPropertyParser$TreeNode m_Current>
    //   18   34:astore_2        
        m_Current = new TreeNode();
    //   19   35:aload_0         
    //   20   36:new             #31  <Class HierarchyPropertyParser$TreeNode>
    //   21   39:dup             
    //   22   40:aload_0         
    //   23   41:invokespecial   #34  <Method void HierarchyPropertyParser$TreeNode(HierarchyPropertyParser)>
    //   24   44:putfield        #180 <Field HierarchyPropertyParser$TreeNode m_Current>
        goToRoot();
    //   25   47:aload_0         
    //   26   48:invokevirtual   #49  <Method void goToRoot()>
        String nodes[] = tokenize(path);
    //   27   51:aload_0         
    //   28   52:aload_1         
    //   29   53:invokevirtual   #102 <Method String[] tokenize(String)>
    //   30   56:astore_3        
        if(!m_Current.value.equals(nodes[0]))
    //*  31   57:aload_0         
    //*  32   58:getfield        #180 <Field HierarchyPropertyParser$TreeNode m_Current>
    //*  33   61:getfield        #105 <Field String HierarchyPropertyParser$TreeNode.value>
    //*  34   64:aload_3         
    //*  35   65:iconst_0        
    //*  36   66:aaload          
    //*  37   67:invokevirtual   #162 <Method boolean String.equals(Object)>
    //*  38   70:ifne            75
            return false;
    //   39   73:iconst_0        
    //   40   74:ireturn         
        for(int i = 1; i < nodes.length; i++)
    //*  41   75:iconst_1        
    //*  42   76:istore          4
    //*  43   78:goto            136
        {
            int pos = search(m_Current.children, nodes[i]);
    //   44   81:aload_0         
    //   45   82:aload_0         
    //   46   83:getfield        #180 <Field HierarchyPropertyParser$TreeNode m_Current>
    //   47   86:getfield        #46  <Field Vector HierarchyPropertyParser$TreeNode.children>
    //   48   89:aload_3         
    //   49   90:iload           4
    //   50   92:aaload          
    //   51   93:invokevirtual   #115 <Method int search(Vector, String)>
    //   52   96:istore          5
            if(pos == -1)
    //*  53   98:iload           5
    //*  54  100:iconst_m1       
    //*  55  101:icmpne          111
            {
                m_Current = old;
    //   56  104:aload_0         
    //   57  105:aload_2         
    //   58  106:putfield        #180 <Field HierarchyPropertyParser$TreeNode m_Current>
                return false;
    //   59  109:iconst_0        
    //   60  110:ireturn         
            }
            m_Current = (TreeNode)(TreeNode)m_Current.children.elementAt(pos);
    //   61  111:aload_0         
    //   62  112:aload_0         
    //   63  113:getfield        #180 <Field HierarchyPropertyParser$TreeNode m_Current>
    //   64  116:getfield        #46  <Field Vector HierarchyPropertyParser$TreeNode.children>
    //   65  119:iload           5
    //   66  121:invokevirtual   #119 <Method Object Vector.elementAt(int)>
    //   67  124:checkcast       #31  <Class HierarchyPropertyParser$TreeNode>
    //   68  127:checkcast       #31  <Class HierarchyPropertyParser$TreeNode>
    //   69  130:putfield        #180 <Field HierarchyPropertyParser$TreeNode m_Current>
        }

    //   70  133:iinc            4  1
    //   71  136:iload           4
    //   72  138:aload_3         
    //   73  139:arraylength     
    //   74  140:icmplt          81
        return true;
    //   75  143:iconst_1        
    //   76  144:ireturn         
    }

    public synchronized boolean goDown(String path)
    {
        if(!isHierachic(path))
    //*   0    0:aload_0         
    //*   1    1:aload_1         
    //*   2    2:invokevirtual   #84  <Method boolean isHierachic(String)>
    //*   3    5:ifne            14
            return goToChild(path);
    //    4    8:aload_0         
    //    5    9:aload_1         
    //    6   10:invokevirtual   #188 <Method boolean goToChild(String)>
    //    7   13:ireturn         
        TreeNode old = m_Current;
    //    8   14:aload_0         
    //    9   15:getfield        #180 <Field HierarchyPropertyParser$TreeNode m_Current>
    //   10   18:astore_2        
        m_Current = new TreeNode();
    //   11   19:aload_0         
    //   12   20:new             #31  <Class HierarchyPropertyParser$TreeNode>
    //   13   23:dup             
    //   14   24:aload_0         
    //   15   25:invokespecial   #34  <Method void HierarchyPropertyParser$TreeNode(HierarchyPropertyParser)>
    //   16   28:putfield        #180 <Field HierarchyPropertyParser$TreeNode m_Current>
        String nodes[] = tokenize(path);
    //   17   31:aload_0         
    //   18   32:aload_1         
    //   19   33:invokevirtual   #102 <Method String[] tokenize(String)>
    //   20   36:astore_3        
        int pos = search(old.children, nodes[0]);
    //   21   37:aload_0         
    //   22   38:aload_2         
    //   23   39:getfield        #46  <Field Vector HierarchyPropertyParser$TreeNode.children>
    //   24   42:aload_3         
    //   25   43:iconst_0        
    //   26   44:aaload          
    //   27   45:invokevirtual   #115 <Method int search(Vector, String)>
    //   28   48:istore          4
        if(pos == -1)
    //*  29   50:iload           4
    //*  30   52:iconst_m1       
    //*  31   53:icmpne          63
        {
            m_Current = old;
    //   32   56:aload_0         
    //   33   57:aload_2         
    //   34   58:putfield        #180 <Field HierarchyPropertyParser$TreeNode m_Current>
            return false;
    //   35   61:iconst_0        
    //   36   62:ireturn         
        }
        m_Current = (TreeNode)(TreeNode)old.children.elementAt(pos);
    //   37   63:aload_0         
    //   38   64:aload_2         
    //   39   65:getfield        #46  <Field Vector HierarchyPropertyParser$TreeNode.children>
    //   40   68:iload           4
    //   41   70:invokevirtual   #119 <Method Object Vector.elementAt(int)>
    //   42   73:checkcast       #31  <Class HierarchyPropertyParser$TreeNode>
    //   43   76:checkcast       #31  <Class HierarchyPropertyParser$TreeNode>
    //   44   79:putfield        #180 <Field HierarchyPropertyParser$TreeNode m_Current>
        for(int i = 1; i < nodes.length; i++)
    //*  45   82:iconst_1        
    //*  46   83:istore          5
    //*  47   85:goto            143
        {
            pos = search(m_Current.children, nodes[i]);
    //   48   88:aload_0         
    //   49   89:aload_0         
    //   50   90:getfield        #180 <Field HierarchyPropertyParser$TreeNode m_Current>
    //   51   93:getfield        #46  <Field Vector HierarchyPropertyParser$TreeNode.children>
    //   52   96:aload_3         
    //   53   97:iload           5
    //   54   99:aaload          
    //   55  100:invokevirtual   #115 <Method int search(Vector, String)>
    //   56  103:istore          4
            if(pos == -1)
    //*  57  105:iload           4
    //*  58  107:iconst_m1       
    //*  59  108:icmpne          118
            {
                m_Current = old;
    //   60  111:aload_0         
    //   61  112:aload_2         
    //   62  113:putfield        #180 <Field HierarchyPropertyParser$TreeNode m_Current>
                return false;
    //   63  116:iconst_0        
    //   64  117:ireturn         
            }
            m_Current = (TreeNode)(TreeNode)m_Current.children.elementAt(pos);
    //   65  118:aload_0         
    //   66  119:aload_0         
    //   67  120:getfield        #180 <Field HierarchyPropertyParser$TreeNode m_Current>
    //   68  123:getfield        #46  <Field Vector HierarchyPropertyParser$TreeNode.children>
    //   69  126:iload           4
    //   70  128:invokevirtual   #119 <Method Object Vector.elementAt(int)>
    //   71  131:checkcast       #31  <Class HierarchyPropertyParser$TreeNode>
    //   72  134:checkcast       #31  <Class HierarchyPropertyParser$TreeNode>
    //   73  137:putfield        #180 <Field HierarchyPropertyParser$TreeNode m_Current>
        }

    //   74  140:iinc            5  1
    //   75  143:iload           5
    //   76  145:aload_3         
    //   77  146:arraylength     
    //   78  147:icmplt          88
        return true;
    //   79  150:iconst_1        
    //   80  151:ireturn         
    }

    public synchronized void goToRoot()
    {
        m_Current = m_Root;
    //    0    0:aload_0         
    //    1    1:aload_0         
    //    2    2:getfield        #36  <Field HierarchyPropertyParser$TreeNode m_Root>
    //    3    5:putfield        #180 <Field HierarchyPropertyParser$TreeNode m_Current>
    //    4    8:return          
    }

    public synchronized void goToParent()
    {
        if(m_Current.parent != null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #180 <Field HierarchyPropertyParser$TreeNode m_Current>
    //*   2    4:getfield        #39  <Field HierarchyPropertyParser$TreeNode HierarchyPropertyParser$TreeNode.parent>
    //*   3    7:ifnull          21
            m_Current = m_Current.parent;
    //    4   10:aload_0         
    //    5   11:aload_0         
    //    6   12:getfield        #180 <Field HierarchyPropertyParser$TreeNode m_Current>
    //    7   15:getfield        #39  <Field HierarchyPropertyParser$TreeNode HierarchyPropertyParser$TreeNode.parent>
    //    8   18:putfield        #180 <Field HierarchyPropertyParser$TreeNode m_Current>
    //    9   21:return          
    }

    public synchronized boolean goToChild(String value)
    {
        if(m_Current.children == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #180 <Field HierarchyPropertyParser$TreeNode m_Current>
    //*   2    4:getfield        #46  <Field Vector HierarchyPropertyParser$TreeNode.children>
    //*   3    7:ifnonnull       12
            return false;
    //    4   10:iconst_0        
    //    5   11:ireturn         
        int pos = search(m_Current.children, value);
    //    6   12:aload_0         
    //    7   13:aload_0         
    //    8   14:getfield        #180 <Field HierarchyPropertyParser$TreeNode m_Current>
    //    9   17:getfield        #46  <Field Vector HierarchyPropertyParser$TreeNode.children>
    //   10   20:aload_1         
    //   11   21:invokevirtual   #115 <Method int search(Vector, String)>
    //   12   24:istore_2        
        if(pos == -1)
    //*  13   25:iload_2         
    //*  14   26:iconst_m1       
    //*  15   27:icmpne          32
        {
            return false;
    //   16   30:iconst_0        
    //   17   31:ireturn         
        } else
        {
            m_Current = (TreeNode)(TreeNode)m_Current.children.elementAt(pos);
    //   18   32:aload_0         
    //   19   33:aload_0         
    //   20   34:getfield        #180 <Field HierarchyPropertyParser$TreeNode m_Current>
    //   21   37:getfield        #46  <Field Vector HierarchyPropertyParser$TreeNode.children>
    //   22   40:iload_2         
    //   23   41:invokevirtual   #119 <Method Object Vector.elementAt(int)>
    //   24   44:checkcast       #31  <Class HierarchyPropertyParser$TreeNode>
    //   25   47:checkcast       #31  <Class HierarchyPropertyParser$TreeNode>
    //   26   50:putfield        #180 <Field HierarchyPropertyParser$TreeNode m_Current>
            return true;
    //   27   53:iconst_1        
    //   28   54:ireturn         
        }
    }

    public synchronized void goToChild(int pos)
        throws Exception
    {
        if(m_Current.children == null || pos < 0 || pos >= m_Current.children.size())
    //*   0    0:aload_0         
    //*   1    1:getfield        #180 <Field HierarchyPropertyParser$TreeNode m_Current>
    //*   2    4:getfield        #46  <Field Vector HierarchyPropertyParser$TreeNode.children>
    //*   3    7:ifnull          28
    //*   4   10:iload_1         
    //*   5   11:iflt            28
    //*   6   14:iload_1         
    //*   7   15:aload_0         
    //*   8   16:getfield        #180 <Field HierarchyPropertyParser$TreeNode m_Current>
    //*   9   19:getfield        #46  <Field Vector HierarchyPropertyParser$TreeNode.children>
    //*  10   22:invokevirtual   #152 <Method int Vector.size()>
    //*  11   25:icmplt          38
        {
            throw new Exception("Position out of range or leaf reached");
    //   12   28:new             #57  <Class Exception>
    //   13   31:dup             
    //   14   32:ldc1            #192 <String "Position out of range or leaf reached">
    //   15   34:invokespecial   #88  <Method void Exception(String)>
    //   16   37:athrow          
        } else
        {
            m_Current = (TreeNode)(TreeNode)m_Current.children.elementAt(pos);
    //   17   38:aload_0         
    //   18   39:aload_0         
    //   19   40:getfield        #180 <Field HierarchyPropertyParser$TreeNode m_Current>
    //   20   43:getfield        #46  <Field Vector HierarchyPropertyParser$TreeNode.children>
    //   21   46:iload_1         
    //   22   47:invokevirtual   #119 <Method Object Vector.elementAt(int)>
    //   23   50:checkcast       #31  <Class HierarchyPropertyParser$TreeNode>
    //   24   53:checkcast       #31  <Class HierarchyPropertyParser$TreeNode>
    //   25   56:putfield        #180 <Field HierarchyPropertyParser$TreeNode m_Current>
            return;
    //   26   59:return          
        }
    }

    public synchronized int numChildren()
    {
        if(m_Current.children == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #180 <Field HierarchyPropertyParser$TreeNode m_Current>
    //*   2    4:getfield        #46  <Field Vector HierarchyPropertyParser$TreeNode.children>
    //*   3    7:ifnonnull       12
            return 0;
    //    4   10:iconst_0        
    //    5   11:ireturn         
        else
            return m_Current.children.size();
    //    6   12:aload_0         
    //    7   13:getfield        #180 <Field HierarchyPropertyParser$TreeNode m_Current>
    //    8   16:getfield        #46  <Field Vector HierarchyPropertyParser$TreeNode.children>
    //    9   19:invokevirtual   #152 <Method int Vector.size()>
    //   10   22:ireturn         
    }

    public synchronized String[] childrenValues()
    {
        if(m_Current.children == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #180 <Field HierarchyPropertyParser$TreeNode m_Current>
    //*   2    4:getfield        #46  <Field Vector HierarchyPropertyParser$TreeNode.children>
    //*   3    7:ifnonnull       12
            return null;
    //    4   10:aconst_null     
    //    5   11:areturn         
        Vector kids = m_Current.children;
    //    6   12:aload_0         
    //    7   13:getfield        #180 <Field HierarchyPropertyParser$TreeNode m_Current>
    //    8   16:getfield        #46  <Field Vector HierarchyPropertyParser$TreeNode.children>
    //    9   19:astore_1        
        String values[] = new String[kids.size()];
    //   10   20:aload_1         
    //   11   21:invokevirtual   #152 <Method int Vector.size()>
    //   12   24:anewarray       String[]
    //   13   27:astore_2        
        for(int i = 0; i < kids.size(); i++)
    //*  14   28:iconst_0        
    //*  15   29:istore_3        
    //*  16   30:goto            53
            values[i] = ((TreeNode)(TreeNode)kids.elementAt(i)).value;
    //   17   33:aload_2         
    //   18   34:iload_3         
    //   19   35:aload_1         
    //   20   36:iload_3         
    //   21   37:invokevirtual   #119 <Method Object Vector.elementAt(int)>
    //   22   40:checkcast       #31  <Class HierarchyPropertyParser$TreeNode>
    //   23   43:checkcast       #31  <Class HierarchyPropertyParser$TreeNode>
    //   24   46:getfield        #105 <Field String HierarchyPropertyParser$TreeNode.value>
    //   25   49:aastore         

    //   26   50:iinc            3  1
    //   27   53:iload_3         
    //   28   54:aload_1         
    //   29   55:invokevirtual   #152 <Method int Vector.size()>
    //   30   58:icmplt          33
        return values;
    //   31   61:aload_2         
    //   32   62:areturn         
    }

    public synchronized String parentValue()
    {
        if(m_Current.parent != null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #180 <Field HierarchyPropertyParser$TreeNode m_Current>
    //*   2    4:getfield        #39  <Field HierarchyPropertyParser$TreeNode HierarchyPropertyParser$TreeNode.parent>
    //*   3    7:ifnull          21
            return m_Current.parent.value;
    //    4   10:aload_0         
    //    5   11:getfield        #180 <Field HierarchyPropertyParser$TreeNode m_Current>
    //    6   14:getfield        #39  <Field HierarchyPropertyParser$TreeNode HierarchyPropertyParser$TreeNode.parent>
    //    7   17:getfield        #105 <Field String HierarchyPropertyParser$TreeNode.value>
    //    8   20:areturn         
        else
            return null;
    //    9   21:aconst_null     
    //   10   22:areturn         
    }

    public synchronized boolean isLeafReached()
    {
        return m_Current.children == null;
    //    0    0:aload_0         
    //    1    1:getfield        #180 <Field HierarchyPropertyParser$TreeNode m_Current>
    //    2    4:getfield        #46  <Field Vector HierarchyPropertyParser$TreeNode.children>
    //    3    7:ifnonnull       12
    //    4   10:iconst_1        
    //    5   11:ireturn         
    //    6   12:iconst_0        
    //    7   13:ireturn         
    }

    public synchronized boolean isRootReached()
    {
        return m_Current.parent == null;
    //    0    0:aload_0         
    //    1    1:getfield        #180 <Field HierarchyPropertyParser$TreeNode m_Current>
    //    2    4:getfield        #39  <Field HierarchyPropertyParser$TreeNode HierarchyPropertyParser$TreeNode.parent>
    //    3    7:ifnonnull       12
    //    4   10:iconst_1        
    //    5   11:ireturn         
    //    6   12:iconst_0        
    //    7   13:ireturn         
    }

    public synchronized String getValue()
    {
        return m_Current.value;
    //    0    0:aload_0         
    //    1    1:getfield        #180 <Field HierarchyPropertyParser$TreeNode m_Current>
    //    2    4:getfield        #105 <Field String HierarchyPropertyParser$TreeNode.value>
    //    3    7:areturn         
    }

    public synchronized int getLevel()
    {
        return m_Current.level;
    //    0    0:aload_0         
    //    1    1:getfield        #180 <Field HierarchyPropertyParser$TreeNode m_Current>
    //    2    4:getfield        #122 <Field int HierarchyPropertyParser$TreeNode.level>
    //    3    7:ireturn         
    }

    public int depth()
    {
        return m_Depth;
    //    0    0:aload_0         
    //    1    1:getfield        #29  <Field int m_Depth>
    //    2    4:ireturn         
    }

    public synchronized String context()
    {
        return m_Current.context;
    //    0    0:aload_0         
    //    1    1:getfield        #180 <Field HierarchyPropertyParser$TreeNode m_Current>
    //    2    4:getfield        #127 <Field String HierarchyPropertyParser$TreeNode.context>
    //    3    7:areturn         
    }

    public synchronized String fullValue()
    {
        if(m_Current == m_Root)
    //*   0    0:aload_0         
    //*   1    1:getfield        #180 <Field HierarchyPropertyParser$TreeNode m_Current>
    //*   2    4:aload_0         
    //*   3    5:getfield        #36  <Field HierarchyPropertyParser$TreeNode m_Root>
    //*   4    8:if_acmpne       19
            return m_Root.value;
    //    5   11:aload_0         
    //    6   12:getfield        #36  <Field HierarchyPropertyParser$TreeNode m_Root>
    //    7   15:getfield        #105 <Field String HierarchyPropertyParser$TreeNode.value>
    //    8   18:areturn         
        else
            return (new StringBuilder(String.valueOf(m_Current.context))).append(m_Seperator).append(m_Current.value).toString();
    //    9   19:new             #124 <Class StringBuilder>
    //   10   22:dup             
    //   11   23:aload_0         
    //   12   24:getfield        #180 <Field HierarchyPropertyParser$TreeNode m_Current>
    //   13   27:getfield        #127 <Field String HierarchyPropertyParser$TreeNode.context>
    //   14   30:invokestatic    #131 <Method String String.valueOf(Object)>
    //   15   33:invokespecial   #132 <Method void StringBuilder(String)>
    //   16   36:aload_0         
    //   17   37:getfield        #27  <Field String m_Seperator>
    //   18   40:invokevirtual   #136 <Method StringBuilder StringBuilder.append(String)>
    //   19   43:aload_0         
    //   20   44:getfield        #180 <Field HierarchyPropertyParser$TreeNode m_Current>
    //   21   47:getfield        #105 <Field String HierarchyPropertyParser$TreeNode.value>
    //   22   50:invokevirtual   #136 <Method StringBuilder StringBuilder.append(String)>
    //   23   53:invokevirtual   #139 <Method String StringBuilder.toString()>
    //   24   56:areturn         
    }

    public String showTree()
    {
        return showNode(m_Root, null);
    //    0    0:aload_0         
    //    1    1:aload_0         
    //    2    2:getfield        #36  <Field HierarchyPropertyParser$TreeNode m_Root>
    //    3    5:aconst_null     
    //    4    6:invokespecial   #207 <Method String showNode(HierarchyPropertyParser$TreeNode, boolean[])>
    //    5    9:areturn         
    }

    private String showNode(TreeNode node, boolean hasBar[])
    {
        StringBuffer text = new StringBuffer();
    //    0    0:new             #209 <Class StringBuffer>
    //    1    3:dup             
    //    2    4:invokespecial   #210 <Method void StringBuffer()>
    //    3    7:astore_3        
        for(int i = 0; i < node.level - 1; i++)
    //*   4    8:iconst_0        
    //*   5    9:istore          4
    //*   6   11:goto            41
            if(hasBar[i])
    //*   7   14:aload_2         
    //*   8   15:iload           4
    //*   9   17:baload          
    //*  10   18:ifeq            31
                text.append("  |       ");
    //   11   21:aload_3         
    //   12   22:ldc1            #212 <String "  |       ">
    //   13   24:invokevirtual   #215 <Method StringBuffer StringBuffer.append(String)>
    //   14   27:pop             
            else
    //*  15   28:goto            38
                text.append("          ");
    //   16   31:aload_3         
    //   17   32:ldc1            #217 <String "          ">
    //   18   34:invokevirtual   #215 <Method StringBuffer StringBuffer.append(String)>
    //   19   37:pop             

    //   20   38:iinc            4  1
    //   21   41:iload           4
    //   22   43:aload_1         
    //   23   44:getfield        #122 <Field int HierarchyPropertyParser$TreeNode.level>
    //   24   47:iconst_1        
    //   25   48:isub            
    //   26   49:icmplt          14
        if(node.level != 0)
    //*  27   52:aload_1         
    //*  28   53:getfield        #122 <Field int HierarchyPropertyParser$TreeNode.level>
    //*  29   56:ifeq            66
            text.append("  |------ ");
    //   30   59:aload_3         
    //   31   60:ldc1            #219 <String "  |------ ">
    //   32   62:invokevirtual   #215 <Method StringBuffer StringBuffer.append(String)>
    //   33   65:pop             
        text.append((new StringBuilder(String.valueOf(node.value))).append("(").append(node.level).append(")").append("[").append(node.context).append("]\n").toString());
    //   34   66:aload_3         
    //   35   67:new             #124 <Class StringBuilder>
    //   36   70:dup             
    //   37   71:aload_1         
    //   38   72:getfield        #105 <Field String HierarchyPropertyParser$TreeNode.value>
    //   39   75:invokestatic    #131 <Method String String.valueOf(Object)>
    //   40   78:invokespecial   #132 <Method void StringBuilder(String)>
    //   41   81:ldc1            #221 <String "(">
    //   42   83:invokevirtual   #136 <Method StringBuilder StringBuilder.append(String)>
    //   43   86:aload_1         
    //   44   87:getfield        #122 <Field int HierarchyPropertyParser$TreeNode.level>
    //   45   90:invokevirtual   #224 <Method StringBuilder StringBuilder.append(int)>
    //   46   93:ldc1            #226 <String ")">
    //   47   95:invokevirtual   #136 <Method StringBuilder StringBuilder.append(String)>
    //   48   98:ldc1            #228 <String "[">
    //   49  100:invokevirtual   #136 <Method StringBuilder StringBuilder.append(String)>
    //   50  103:aload_1         
    //   51  104:getfield        #127 <Field String HierarchyPropertyParser$TreeNode.context>
    //   52  107:invokevirtual   #136 <Method StringBuilder StringBuilder.append(String)>
    //   53  110:ldc1            #230 <String "]\n">
    //   54  112:invokevirtual   #136 <Method StringBuilder StringBuilder.append(String)>
    //   55  115:invokevirtual   #139 <Method String StringBuilder.toString()>
    //   56  118:invokevirtual   #215 <Method StringBuffer StringBuffer.append(String)>
    //   57  121:pop             
        if(node.children != null)
    //*  58  122:aload_1         
    //*  59  123:getfield        #46  <Field Vector HierarchyPropertyParser$TreeNode.children>
    //*  60  126:ifnull          250
        {
            for(int i = 0; i < node.children.size(); i++)
    //*  61  129:iconst_0        
    //*  62  130:istore          4
    //*  63  132:goto            238
            {
                boolean newBar[] = new boolean[node.level + 1];
    //   64  135:aload_1         
    //   65  136:getfield        #122 <Field int HierarchyPropertyParser$TreeNode.level>
    //   66  139:iconst_1        
    //   67  140:iadd            
    //   68  141:newarray        boolean[]
    //   69  143:astore          5
                int lvl = node.level;
    //   70  145:aload_1         
    //   71  146:getfield        #122 <Field int HierarchyPropertyParser$TreeNode.level>
    //   72  149:istore          6
                if(hasBar != null)
    //*  73  151:aload_2         
    //*  74  152:ifnull          180
                {
                    for(int j = 0; j < lvl; j++)
    //*  75  155:iconst_0        
    //*  76  156:istore          7
    //*  77  158:goto            173
                        newBar[j] = hasBar[j];
    //   78  161:aload           5
    //   79  163:iload           7
    //   80  165:aload_2         
    //   81  166:iload           7
    //   82  168:baload          
    //   83  169:bastore         

    //   84  170:iinc            7  1
    //   85  173:iload           7
    //   86  175:iload           6
    //   87  177:icmplt          161
                }
                if(i == node.children.size() - 1)
    //*  88  180:iload           4
    //*  89  182:aload_1         
    //*  90  183:getfield        #46  <Field Vector HierarchyPropertyParser$TreeNode.children>
    //*  91  186:invokevirtual   #152 <Method int Vector.size()>
    //*  92  189:iconst_1        
    //*  93  190:isub            
    //*  94  191:icmpne          203
                    newBar[lvl] = false;
    //   95  194:aload           5
    //   96  196:iload           6
    //   97  198:iconst_0        
    //   98  199:bastore         
                else
    //*  99  200:goto            209
                    newBar[lvl] = true;
    //  100  203:aload           5
    //  101  205:iload           6
    //  102  207:iconst_1        
    //  103  208:bastore         
                text.append(showNode((TreeNode)(TreeNode)node.children.elementAt(i), newBar));
    //  104  209:aload_3         
    //  105  210:aload_0         
    //  106  211:aload_1         
    //  107  212:getfield        #46  <Field Vector HierarchyPropertyParser$TreeNode.children>
    //  108  215:iload           4
    //  109  217:invokevirtual   #119 <Method Object Vector.elementAt(int)>
    //  110  220:checkcast       #31  <Class HierarchyPropertyParser$TreeNode>
    //  111  223:checkcast       #31  <Class HierarchyPropertyParser$TreeNode>
    //  112  226:aload           5
    //  113  228:invokespecial   #207 <Method String showNode(HierarchyPropertyParser$TreeNode, boolean[])>
    //  114  231:invokevirtual   #215 <Method StringBuffer StringBuffer.append(String)>
    //  115  234:pop             
            }

    //  116  235:iinc            4  1
    //  117  238:iload           4
    //  118  240:aload_1         
    //  119  241:getfield        #46  <Field Vector HierarchyPropertyParser$TreeNode.children>
    //  120  244:invokevirtual   #152 <Method int Vector.size()>
    //  121  247:icmplt          135
        }
        return text.toString();
    //  122  250:aload_3         
    //  123  251:invokevirtual   #231 <Method String StringBuffer.toString()>
    //  124  254:areturn         
    }

    public static void main(String args[])
    {
        StringBuffer sb = new StringBuffer();
    //    0    0:new             #209 <Class StringBuffer>
    //    1    3:dup             
    //    2    4:invokespecial   #210 <Method void StringBuffer()>
    //    3    7:astore_1        
        sb.append("node1.node1_1.node1_1_1.node1_1_1_1, ");
    //    4    8:aload_1         
    //    5    9:ldc1            #242 <String "node1.node1_1.node1_1_1.node1_1_1_1, ">
    //    6   11:invokevirtual   #215 <Method StringBuffer StringBuffer.append(String)>
    //    7   14:pop             
        sb.append("node1.node1_1.node1_1_1.node1_1_1_2, ");
    //    8   15:aload_1         
    //    9   16:ldc1            #244 <String "node1.node1_1.node1_1_1.node1_1_1_2, ">
    //   10   18:invokevirtual   #215 <Method StringBuffer StringBuffer.append(String)>
    //   11   21:pop             
        sb.append("node1.node1_1.node1_1_1.node1_1_1_3, ");
    //   12   22:aload_1         
    //   13   23:ldc1            #246 <String "node1.node1_1.node1_1_1.node1_1_1_3, ">
    //   14   25:invokevirtual   #215 <Method StringBuffer StringBuffer.append(String)>
    //   15   28:pop             
        sb.append("node1.node1_1.node1_1_2.node1_1_2_1, ");
    //   16   29:aload_1         
    //   17   30:ldc1            #248 <String "node1.node1_1.node1_1_2.node1_1_2_1, ">
    //   18   32:invokevirtual   #215 <Method StringBuffer StringBuffer.append(String)>
    //   19   35:pop             
        sb.append("node1.node1_1.node1_1_3.node1_1_3_1, ");
    //   20   36:aload_1         
    //   21   37:ldc1            #250 <String "node1.node1_1.node1_1_3.node1_1_3_1, ">
    //   22   39:invokevirtual   #215 <Method StringBuffer StringBuffer.append(String)>
    //   23   42:pop             
        sb.append("node1.node1_2.node1_2_1.node1_2_1_1, ");
    //   24   43:aload_1         
    //   25   44:ldc1            #252 <String "node1.node1_2.node1_2_1.node1_2_1_1, ">
    //   26   46:invokevirtual   #215 <Method StringBuffer StringBuffer.append(String)>
    //   27   49:pop             
        sb.append("node1.node1_2.node1_2_3.node1_2_3_1, ");
    //   28   50:aload_1         
    //   29   51:ldc1            #254 <String "node1.node1_2.node1_2_3.node1_2_3_1, ">
    //   30   53:invokevirtual   #215 <Method StringBuffer StringBuffer.append(String)>
    //   31   56:pop             
        sb.append("node1.node1_3.node1_3_3.node1_3_3_1, ");
    //   32   57:aload_1         
    //   33   58:ldc2            #256 <String "node1.node1_3.node1_3_3.node1_3_3_1, ">
    //   34   61:invokevirtual   #215 <Method StringBuffer StringBuffer.append(String)>
    //   35   64:pop             
        sb.append("node1.node1_3.node1_3_3.node1_3_3_2, ");
    //   36   65:aload_1         
    //   37   66:ldc2            #258 <String "node1.node1_3.node1_3_3.node1_3_3_2, ">
    //   38   69:invokevirtual   #215 <Method StringBuffer StringBuffer.append(String)>
    //   39   72:pop             
        String p = sb.toString();
    //   40   73:aload_1         
    //   41   74:invokevirtual   #231 <Method String StringBuffer.toString()>
    //   42   77:astore_2        
        try
        {
            HierarchyPropertyParser hpp = new HierarchyPropertyParser(p, ", ");
    //   43   78:new             #2   <Class HierarchyPropertyParser>
    //   44   81:dup             
    //   45   82:aload_2         
    //   46   83:ldc2            #260 <String ", ">
    //   47   86:invokespecial   #261 <Method void HierarchyPropertyParser(String, String)>
    //   48   89:astore_3        
            System.out.println((new StringBuilder("seperator: ")).append(hpp.getSeperator()).toString());
    //   49   90:getstatic       #267 <Field PrintStream System.out>
    //   50   93:new             #124 <Class StringBuilder>
    //   51   96:dup             
    //   52   97:ldc2            #269 <String "seperator: ">
    //   53  100:invokespecial   #132 <Method void StringBuilder(String)>
    //   54  103:aload_3         
    //   55  104:invokevirtual   #271 <Method String getSeperator()>
    //   56  107:invokevirtual   #136 <Method StringBuilder StringBuilder.append(String)>
    //   57  110:invokevirtual   #139 <Method String StringBuilder.toString()>
    //   58  113:invokevirtual   #276 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("depth: ")).append(hpp.depth()).toString());
    //   59  116:getstatic       #267 <Field PrintStream System.out>
    //   60  119:new             #124 <Class StringBuilder>
    //   61  122:dup             
    //   62  123:ldc2            #278 <String "depth: ">
    //   63  126:invokespecial   #132 <Method void StringBuilder(String)>
    //   64  129:aload_3         
    //   65  130:invokevirtual   #280 <Method int depth()>
    //   66  133:invokevirtual   #224 <Method StringBuilder StringBuilder.append(int)>
    //   67  136:invokevirtual   #139 <Method String StringBuilder.toString()>
    //   68  139:invokevirtual   #276 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("The tree:\n\n")).append(hpp.showTree()).toString());
    //   69  142:getstatic       #267 <Field PrintStream System.out>
    //   70  145:new             #124 <Class StringBuilder>
    //   71  148:dup             
    //   72  149:ldc2            #282 <String "The tree:\n\n">
    //   73  152:invokespecial   #132 <Method void StringBuilder(String)>
    //   74  155:aload_3         
    //   75  156:invokevirtual   #284 <Method String showTree()>
    //   76  159:invokevirtual   #136 <Method StringBuilder StringBuilder.append(String)>
    //   77  162:invokevirtual   #139 <Method String StringBuilder.toString()>
    //   78  165:invokevirtual   #276 <Method void PrintStream.println(String)>
            hpp.goToRoot();
    //   79  168:aload_3         
    //   80  169:invokevirtual   #49  <Method void goToRoot()>
            System.out.println((new StringBuilder("goto: ")).append(hpp.goTo("node1.node1_2.node1_2_1")).append(": ").append(hpp.getValue()).append(" | ").append(hpp.fullValue()).append(" leaf? ").append(hpp.isLeafReached()).toString());
    //   81  172:getstatic       #267 <Field PrintStream System.out>
    //   82  175:new             #124 <Class StringBuilder>
    //   83  178:dup             
    //   84  179:ldc2            #286 <String "goto: ">
    //   85  182:invokespecial   #132 <Method void StringBuilder(String)>
    //   86  185:aload_3         
    //   87  186:ldc2            #288 <String "node1.node1_2.node1_2_1">
    //   88  189:invokevirtual   #290 <Method boolean goTo(String)>
    //   89  192:invokevirtual   #293 <Method StringBuilder StringBuilder.append(boolean)>
    //   90  195:ldc2            #295 <String ": ">
    //   91  198:invokevirtual   #136 <Method StringBuilder StringBuilder.append(String)>
    //   92  201:aload_3         
    //   93  202:invokevirtual   #297 <Method String getValue()>
    //   94  205:invokevirtual   #136 <Method StringBuilder StringBuilder.append(String)>
    //   95  208:ldc2            #299 <String " | ">
    //   96  211:invokevirtual   #136 <Method StringBuilder StringBuilder.append(String)>
    //   97  214:aload_3         
    //   98  215:invokevirtual   #301 <Method String fullValue()>
    //   99  218:invokevirtual   #136 <Method StringBuilder StringBuilder.append(String)>
    //  100  221:ldc2            #303 <String " leaf? ">
    //  101  224:invokevirtual   #136 <Method StringBuilder StringBuilder.append(String)>
    //  102  227:aload_3         
    //  103  228:invokevirtual   #305 <Method boolean isLeafReached()>
    //  104  231:invokevirtual   #293 <Method StringBuilder StringBuilder.append(boolean)>
    //  105  234:invokevirtual   #139 <Method String StringBuilder.toString()>
    //  106  237:invokevirtual   #276 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("go down(wrong): ")).append(hpp.goDown("node1")).toString());
    //  107  240:getstatic       #267 <Field PrintStream System.out>
    //  108  243:new             #124 <Class StringBuilder>
    //  109  246:dup             
    //  110  247:ldc2            #307 <String "go down(wrong): ">
    //  111  250:invokespecial   #132 <Method void StringBuilder(String)>
    //  112  253:aload_3         
    //  113  254:ldc2            #309 <String "node1">
    //  114  257:invokevirtual   #311 <Method boolean goDown(String)>
    //  115  260:invokevirtual   #293 <Method StringBuilder StringBuilder.append(boolean)>
    //  116  263:invokevirtual   #139 <Method String StringBuilder.toString()>
    //  117  266:invokevirtual   #276 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Stay still? ")).append(hpp.getValue()).toString());
    //  118  269:getstatic       #267 <Field PrintStream System.out>
    //  119  272:new             #124 <Class StringBuilder>
    //  120  275:dup             
    //  121  276:ldc2            #313 <String "Stay still? ">
    //  122  279:invokespecial   #132 <Method void StringBuilder(String)>
    //  123  282:aload_3         
    //  124  283:invokevirtual   #297 <Method String getValue()>
    //  125  286:invokevirtual   #136 <Method StringBuilder StringBuilder.append(String)>
    //  126  289:invokevirtual   #139 <Method String StringBuilder.toString()>
    //  127  292:invokevirtual   #276 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("go to child: ")).append(hpp.goToChild("node1_2_1_1")).append(": ").append(hpp.getValue()).append(" | ").append(hpp.fullValue()).append(" leaf? ").append(hpp.isLeafReached()).append(" root? ").append(hpp.isRootReached()).toString());
    //  128  295:getstatic       #267 <Field PrintStream System.out>
    //  129  298:new             #124 <Class StringBuilder>
    //  130  301:dup             
    //  131  302:ldc2            #315 <String "go to child: ">
    //  132  305:invokespecial   #132 <Method void StringBuilder(String)>
    //  133  308:aload_3         
    //  134  309:ldc2            #317 <String "node1_2_1_1">
    //  135  312:invokevirtual   #188 <Method boolean goToChild(String)>
    //  136  315:invokevirtual   #293 <Method StringBuilder StringBuilder.append(boolean)>
    //  137  318:ldc2            #295 <String ": ">
    //  138  321:invokevirtual   #136 <Method StringBuilder StringBuilder.append(String)>
    //  139  324:aload_3         
    //  140  325:invokevirtual   #297 <Method String getValue()>
    //  141  328:invokevirtual   #136 <Method StringBuilder StringBuilder.append(String)>
    //  142  331:ldc2            #299 <String " | ">
    //  143  334:invokevirtual   #136 <Method StringBuilder StringBuilder.append(String)>
    //  144  337:aload_3         
    //  145  338:invokevirtual   #301 <Method String fullValue()>
    //  146  341:invokevirtual   #136 <Method StringBuilder StringBuilder.append(String)>
    //  147  344:ldc2            #303 <String " leaf? ">
    //  148  347:invokevirtual   #136 <Method StringBuilder StringBuilder.append(String)>
    //  149  350:aload_3         
    //  150  351:invokevirtual   #305 <Method boolean isLeafReached()>
    //  151  354:invokevirtual   #293 <Method StringBuilder StringBuilder.append(boolean)>
    //  152  357:ldc2            #319 <String " root? ">
    //  153  360:invokevirtual   #136 <Method StringBuilder StringBuilder.append(String)>
    //  154  363:aload_3         
    //  155  364:invokevirtual   #321 <Method boolean isRootReached()>
    //  156  367:invokevirtual   #293 <Method StringBuilder StringBuilder.append(boolean)>
    //  157  370:invokevirtual   #139 <Method String StringBuilder.toString()>
    //  158  373:invokevirtual   #276 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("parent: ")).append(hpp.parentValue()).toString());
    //  159  376:getstatic       #267 <Field PrintStream System.out>
    //  160  379:new             #124 <Class StringBuilder>
    //  161  382:dup             
    //  162  383:ldc2            #323 <String "parent: ">
    //  163  386:invokespecial   #132 <Method void StringBuilder(String)>
    //  164  389:aload_3         
    //  165  390:invokevirtual   #325 <Method String parentValue()>
    //  166  393:invokevirtual   #136 <Method StringBuilder StringBuilder.append(String)>
    //  167  396:invokevirtual   #139 <Method String StringBuilder.toString()>
    //  168  399:invokevirtual   #276 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("level: ")).append(hpp.getLevel()).toString());
    //  169  402:getstatic       #267 <Field PrintStream System.out>
    //  170  405:new             #124 <Class StringBuilder>
    //  171  408:dup             
    //  172  409:ldc2            #327 <String "level: ">
    //  173  412:invokespecial   #132 <Method void StringBuilder(String)>
    //  174  415:aload_3         
    //  175  416:invokevirtual   #329 <Method int getLevel()>
    //  176  419:invokevirtual   #224 <Method StringBuilder StringBuilder.append(int)>
    //  177  422:invokevirtual   #139 <Method String StringBuilder.toString()>
    //  178  425:invokevirtual   #276 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("context: ")).append(hpp.context()).toString());
    //  179  428:getstatic       #267 <Field PrintStream System.out>
    //  180  431:new             #124 <Class StringBuilder>
    //  181  434:dup             
    //  182  435:ldc2            #331 <String "context: ">
    //  183  438:invokespecial   #132 <Method void StringBuilder(String)>
    //  184  441:aload_3         
    //  185  442:invokevirtual   #333 <Method String context()>
    //  186  445:invokevirtual   #136 <Method StringBuilder StringBuilder.append(String)>
    //  187  448:invokevirtual   #139 <Method String StringBuilder.toString()>
    //  188  451:invokevirtual   #276 <Method void PrintStream.println(String)>
            hpp.goToRoot();
    //  189  454:aload_3         
    //  190  455:invokevirtual   #49  <Method void goToRoot()>
            System.out.println((new StringBuilder("After gotoRoot. leaf? ")).append(hpp.isLeafReached()).append(" root? ").append(hpp.isRootReached()).toString());
    //  191  458:getstatic       #267 <Field PrintStream System.out>
    //  192  461:new             #124 <Class StringBuilder>
    //  193  464:dup             
    //  194  465:ldc2            #335 <String "After gotoRoot. leaf? ">
    //  195  468:invokespecial   #132 <Method void StringBuilder(String)>
    //  196  471:aload_3         
    //  197  472:invokevirtual   #305 <Method boolean isLeafReached()>
    //  198  475:invokevirtual   #293 <Method StringBuilder StringBuilder.append(boolean)>
    //  199  478:ldc2            #319 <String " root? ">
    //  200  481:invokevirtual   #136 <Method StringBuilder StringBuilder.append(String)>
    //  201  484:aload_3         
    //  202  485:invokevirtual   #321 <Method boolean isRootReached()>
    //  203  488:invokevirtual   #293 <Method StringBuilder StringBuilder.append(boolean)>
    //  204  491:invokevirtual   #139 <Method String StringBuilder.toString()>
    //  205  494:invokevirtual   #276 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Go down(correct): ")).append(hpp.goDown("node1_1.node1_1_1")).append(" value: ").append(hpp.getValue()).append(" | ").append(hpp.fullValue()).append(" level: ").append(hpp.getLevel()).append(" leaf? ").append(hpp.isLeafReached()).append(" root? ").append(hpp.isRootReached()).toString());
    //  206  497:getstatic       #267 <Field PrintStream System.out>
    //  207  500:new             #124 <Class StringBuilder>
    //  208  503:dup             
    //  209  504:ldc2            #337 <String "Go down(correct): ">
    //  210  507:invokespecial   #132 <Method void StringBuilder(String)>
    //  211  510:aload_3         
    //  212  511:ldc2            #339 <String "node1_1.node1_1_1">
    //  213  514:invokevirtual   #311 <Method boolean goDown(String)>
    //  214  517:invokevirtual   #293 <Method StringBuilder StringBuilder.append(boolean)>
    //  215  520:ldc2            #341 <String " value: ">
    //  216  523:invokevirtual   #136 <Method StringBuilder StringBuilder.append(String)>
    //  217  526:aload_3         
    //  218  527:invokevirtual   #297 <Method String getValue()>
    //  219  530:invokevirtual   #136 <Method StringBuilder StringBuilder.append(String)>
    //  220  533:ldc2            #299 <String " | ">
    //  221  536:invokevirtual   #136 <Method StringBuilder StringBuilder.append(String)>
    //  222  539:aload_3         
    //  223  540:invokevirtual   #301 <Method String fullValue()>
    //  224  543:invokevirtual   #136 <Method StringBuilder StringBuilder.append(String)>
    //  225  546:ldc2            #343 <String " level: ">
    //  226  549:invokevirtual   #136 <Method StringBuilder StringBuilder.append(String)>
    //  227  552:aload_3         
    //  228  553:invokevirtual   #329 <Method int getLevel()>
    //  229  556:invokevirtual   #224 <Method StringBuilder StringBuilder.append(int)>
    //  230  559:ldc2            #303 <String " leaf? ">
    //  231  562:invokevirtual   #136 <Method StringBuilder StringBuilder.append(String)>
    //  232  565:aload_3         
    //  233  566:invokevirtual   #305 <Method boolean isLeafReached()>
    //  234  569:invokevirtual   #293 <Method StringBuilder StringBuilder.append(boolean)>
    //  235  572:ldc2            #319 <String " root? ">
    //  236  575:invokevirtual   #136 <Method StringBuilder StringBuilder.append(String)>
    //  237  578:aload_3         
    //  238  579:invokevirtual   #321 <Method boolean isRootReached()>
    //  239  582:invokevirtual   #293 <Method StringBuilder StringBuilder.append(boolean)>
    //  240  585:invokevirtual   #139 <Method String StringBuilder.toString()>
    //  241  588:invokevirtual   #276 <Method void PrintStream.println(String)>
            hpp.goToParent();
    //  242  591:aload_3         
    //  243  592:invokevirtual   #345 <Method void goToParent()>
            System.out.println((new StringBuilder("value: ")).append(hpp.getValue()).append(" | ").append(hpp.fullValue()).toString());
    //  244  595:getstatic       #267 <Field PrintStream System.out>
    //  245  598:new             #124 <Class StringBuilder>
    //  246  601:dup             
    //  247  602:ldc2            #347 <String "value: ">
    //  248  605:invokespecial   #132 <Method void StringBuilder(String)>
    //  249  608:aload_3         
    //  250  609:invokevirtual   #297 <Method String getValue()>
    //  251  612:invokevirtual   #136 <Method StringBuilder StringBuilder.append(String)>
    //  252  615:ldc2            #299 <String " | ">
    //  253  618:invokevirtual   #136 <Method StringBuilder StringBuilder.append(String)>
    //  254  621:aload_3         
    //  255  622:invokevirtual   #301 <Method String fullValue()>
    //  256  625:invokevirtual   #136 <Method StringBuilder StringBuilder.append(String)>
    //  257  628:invokevirtual   #139 <Method String StringBuilder.toString()>
    //  258  631:invokevirtual   #276 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("level: ")).append(hpp.getLevel()).toString());
    //  259  634:getstatic       #267 <Field PrintStream System.out>
    //  260  637:new             #124 <Class StringBuilder>
    //  261  640:dup             
    //  262  641:ldc2            #327 <String "level: ">
    //  263  644:invokespecial   #132 <Method void StringBuilder(String)>
    //  264  647:aload_3         
    //  265  648:invokevirtual   #329 <Method int getLevel()>
    //  266  651:invokevirtual   #224 <Method StringBuilder StringBuilder.append(int)>
    //  267  654:invokevirtual   #139 <Method String StringBuilder.toString()>
    //  268  657:invokevirtual   #276 <Method void PrintStream.println(String)>
            String chd[] = hpp.childrenValues();
    //  269  660:aload_3         
    //  270  661:invokevirtual   #349 <Method String[] childrenValues()>
    //  271  664:astore          4
            for(int i = 0; i < chd.length; i++)
    //* 272  666:iconst_0        
    //* 273  667:istore          5
    //* 274  669:goto            784
            {
                System.out.print((new StringBuilder("children ")).append(i).append(": ").append(chd[i]).toString());
    //  275  672:getstatic       #267 <Field PrintStream System.out>
    //  276  675:new             #124 <Class StringBuilder>
    //  277  678:dup             
    //  278  679:ldc2            #351 <String "children ">
    //  279  682:invokespecial   #132 <Method void StringBuilder(String)>
    //  280  685:iload           5
    //  281  687:invokevirtual   #224 <Method StringBuilder StringBuilder.append(int)>
    //  282  690:ldc2            #295 <String ": ">
    //  283  693:invokevirtual   #136 <Method StringBuilder StringBuilder.append(String)>
    //  284  696:aload           4
    //  285  698:iload           5
    //  286  700:aaload          
    //  287  701:invokevirtual   #136 <Method StringBuilder StringBuilder.append(String)>
    //  288  704:invokevirtual   #139 <Method String StringBuilder.toString()>
    //  289  707:invokevirtual   #354 <Method void PrintStream.print(String)>
                hpp.goDown(chd[i]);
    //  290  710:aload_3         
    //  291  711:aload           4
    //  292  713:iload           5
    //  293  715:aaload          
    //  294  716:invokevirtual   #311 <Method boolean goDown(String)>
    //  295  719:pop             
                System.out.println((new StringBuilder("real value: ")).append(hpp.getValue()).append(" | ").append(hpp.fullValue()).append("(level: ").append(hpp.getLevel()).append(")").toString());
    //  296  720:getstatic       #267 <Field PrintStream System.out>
    //  297  723:new             #124 <Class StringBuilder>
    //  298  726:dup             
    //  299  727:ldc2            #356 <String "real value: ">
    //  300  730:invokespecial   #132 <Method void StringBuilder(String)>
    //  301  733:aload_3         
    //  302  734:invokevirtual   #297 <Method String getValue()>
    //  303  737:invokevirtual   #136 <Method StringBuilder StringBuilder.append(String)>
    //  304  740:ldc2            #299 <String " | ">
    //  305  743:invokevirtual   #136 <Method StringBuilder StringBuilder.append(String)>
    //  306  746:aload_3         
    //  307  747:invokevirtual   #301 <Method String fullValue()>
    //  308  750:invokevirtual   #136 <Method StringBuilder StringBuilder.append(String)>
    //  309  753:ldc2            #358 <String "(level: ">
    //  310  756:invokevirtual   #136 <Method StringBuilder StringBuilder.append(String)>
    //  311  759:aload_3         
    //  312  760:invokevirtual   #329 <Method int getLevel()>
    //  313  763:invokevirtual   #224 <Method StringBuilder StringBuilder.append(int)>
    //  314  766:ldc1            #226 <String ")">
    //  315  768:invokevirtual   #136 <Method StringBuilder StringBuilder.append(String)>
    //  316  771:invokevirtual   #139 <Method String StringBuilder.toString()>
    //  317  774:invokevirtual   #276 <Method void PrintStream.println(String)>
                hpp.goToParent();
    //  318  777:aload_3         
    //  319  778:invokevirtual   #345 <Method void goToParent()>
            }

    //  320  781:iinc            5  1
    //  321  784:iload           5
    //  322  786:aload           4
    //  323  788:arraylength     
    //  324  789:icmplt          672
            System.out.println((new StringBuilder("Another way to go to root:")).append(hpp.goTo("node1")).append(": ").append(hpp.getValue()).append(" | ").append(hpp.fullValue()).toString());
    //  325  792:getstatic       #267 <Field PrintStream System.out>
    //  326  795:new             #124 <Class StringBuilder>
    //  327  798:dup             
    //  328  799:ldc2            #360 <String "Another way to go to root:">
    //  329  802:invokespecial   #132 <Method void StringBuilder(String)>
    //  330  805:aload_3         
    //  331  806:ldc2            #309 <String "node1">
    //  332  809:invokevirtual   #290 <Method boolean goTo(String)>
    //  333  812:invokevirtual   #293 <Method StringBuilder StringBuilder.append(boolean)>
    //  334  815:ldc2            #295 <String ": ">
    //  335  818:invokevirtual   #136 <Method StringBuilder StringBuilder.append(String)>
    //  336  821:aload_3         
    //  337  822:invokevirtual   #297 <Method String getValue()>
    //  338  825:invokevirtual   #136 <Method StringBuilder StringBuilder.append(String)>
    //  339  828:ldc2            #299 <String " | ">
    //  340  831:invokevirtual   #136 <Method StringBuilder StringBuilder.append(String)>
    //  341  834:aload_3         
    //  342  835:invokevirtual   #301 <Method String fullValue()>
    //  343  838:invokevirtual   #136 <Method StringBuilder StringBuilder.append(String)>
    //  344  841:invokevirtual   #139 <Method String StringBuilder.toString()>
    //  345  844:invokevirtual   #276 <Method void PrintStream.println(String)>
        }
    //* 346  847:goto            865
        catch(Exception e)
    //* 347  850:astore_3        
        {
            System.out.println(e.getMessage());
    //  348  851:getstatic       #267 <Field PrintStream System.out>
    //  349  854:aload_3         
    //  350  855:invokevirtual   #363 <Method String Exception.getMessage()>
    //  351  858:invokevirtual   #276 <Method void PrintStream.println(String)>
            e.printStackTrace();
    //  352  861:aload_3         
    //  353  862:invokevirtual   #366 <Method void Exception.printStackTrace()>
        }
    //  354  865:return          
    }

    private static final long serialVersionUID = 0xc6645181d2683a98L;
    private TreeNode m_Root;
    private TreeNode m_Current;
    private String m_Seperator;
    private int m_Depth;
}
