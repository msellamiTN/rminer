// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   PropertySelectorDialog.java

package rm.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.*;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.swing.*;
import javax.swing.tree.*;
import rm.experiment.PropertyNode;

public class PropertySelectorDialog extends JDialog
{

    public PropertySelectorDialog(Frame parentFrame, Object rootObject)
    {
        super(parentFrame, "Select a property", true);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:ldc1            #31  <String "Select a property">
    //    3    4:iconst_1        
    //    4    5:invokespecial   #34  <Method void JDialog(Frame, String, boolean)>
        m_SelectBut = new JButton("Select");
    //    5    8:aload_0         
    //    6    9:new             #36  <Class JButton>
    //    7   12:dup             
    //    8   13:ldc1            #38  <String "Select">
    //    9   15:invokespecial   #41  <Method void JButton(String)>
    //   10   18:putfield        #43  <Field JButton m_SelectBut>
        m_CancelBut = new JButton("Cancel");
    //   11   21:aload_0         
    //   12   22:new             #36  <Class JButton>
    //   13   25:dup             
    //   14   26:ldc1            #45  <String "Cancel">
    //   15   28:invokespecial   #41  <Method void JButton(String)>
    //   16   31:putfield        #47  <Field JButton m_CancelBut>
        m_CancelBut.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                m_Result = 1;
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field PropertySelectorDialog this$0>
            //    2    4:iconst_1        
            //    3    5:putfield        #28  <Field int PropertySelectorDialog.m_Result>
                setVisible(false);
            //    4    8:aload_0         
            //    5    9:getfield        #13  <Field PropertySelectorDialog this$0>
            //    6   12:iconst_0        
            //    7   13:invokevirtual   #32  <Method void PropertySelectorDialog.setVisible(boolean)>
            //    8   16:return          
            }

            final PropertySelectorDialog this$0;

            
            {
                this$0 = PropertySelectorDialog.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field PropertySelectorDialog this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //   17   34:aload_0         
    //   18   35:getfield        #47  <Field JButton m_CancelBut>
    //   19   38:new             #49  <Class PropertySelectorDialog$1>
    //   20   41:dup             
    //   21   42:aload_0         
    //   22   43:invokespecial   #52  <Method void PropertySelectorDialog$1(PropertySelectorDialog)>
    //   23   46:invokevirtual   #56  <Method void JButton.addActionListener(ActionListener)>
        m_SelectBut.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                TreePath tPath = m_Tree.getSelectionPath();
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field PropertySelectorDialog this$0>
            //    2    4:getfield        #28  <Field JTree PropertySelectorDialog.m_Tree>
            //    3    7:invokevirtual   #34  <Method TreePath JTree.getSelectionPath()>
            //    4   10:astore_2        
                if(tPath == null)
            //*   5   11:aload_2         
            //*   6   12:ifnonnull       26
                {
                    m_Result = 1;
            //    7   15:aload_0         
            //    8   16:getfield        #13  <Field PropertySelectorDialog this$0>
            //    9   19:iconst_1        
            //   10   20:putfield        #38  <Field int PropertySelectorDialog.m_Result>
                } else
            //*  11   23:goto            78
                {
                    m_ResultPath = tPath.getPath();
            //   12   26:aload_0         
            //   13   27:getfield        #13  <Field PropertySelectorDialog this$0>
            //   14   30:aload_2         
            //   15   31:invokevirtual   #44  <Method Object[] TreePath.getPath()>
            //   16   34:putfield        #48  <Field Object[] PropertySelectorDialog.m_ResultPath>
                    if(m_ResultPath == null || m_ResultPath.length < 2)
            //*  17   37:aload_0         
            //*  18   38:getfield        #13  <Field PropertySelectorDialog this$0>
            //*  19   41:getfield        #48  <Field Object[] PropertySelectorDialog.m_ResultPath>
            //*  20   44:ifnull          59
            //*  21   47:aload_0         
            //*  22   48:getfield        #13  <Field PropertySelectorDialog this$0>
            //*  23   51:getfield        #48  <Field Object[] PropertySelectorDialog.m_ResultPath>
            //*  24   54:arraylength     
            //*  25   55:iconst_2        
            //*  26   56:icmpge          70
                        m_Result = 1;
            //   27   59:aload_0         
            //   28   60:getfield        #13  <Field PropertySelectorDialog this$0>
            //   29   63:iconst_1        
            //   30   64:putfield        #38  <Field int PropertySelectorDialog.m_Result>
                    else
            //*  31   67:goto            78
                        m_Result = 0;
            //   32   70:aload_0         
            //   33   71:getfield        #13  <Field PropertySelectorDialog this$0>
            //   34   74:iconst_0        
            //   35   75:putfield        #38  <Field int PropertySelectorDialog.m_Result>
                }
                setVisible(false);
            //   36   78:aload_0         
            //   37   79:getfield        #13  <Field PropertySelectorDialog this$0>
            //   38   82:iconst_0        
            //   39   83:invokevirtual   #52  <Method void PropertySelectorDialog.setVisible(boolean)>
            //   40   86:return          
            }

            final PropertySelectorDialog this$0;

            
            {
                this$0 = PropertySelectorDialog.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field PropertySelectorDialog this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //   24   49:aload_0         
    //   25   50:getfield        #43  <Field JButton m_SelectBut>
    //   26   53:new             #58  <Class PropertySelectorDialog$2>
    //   27   56:dup             
    //   28   57:aload_0         
    //   29   58:invokespecial   #59  <Method void PropertySelectorDialog$2(PropertySelectorDialog)>
    //   30   61:invokevirtual   #56  <Method void JButton.addActionListener(ActionListener)>
        m_RootObject = rootObject;
    //   31   64:aload_0         
    //   32   65:aload_2         
    //   33   66:putfield        #61  <Field Object m_RootObject>
        m_Root = new DefaultMutableTreeNode(new PropertyNode(m_RootObject));
    //   34   69:aload_0         
    //   35   70:new             #63  <Class DefaultMutableTreeNode>
    //   36   73:dup             
    //   37   74:new             #65  <Class PropertyNode>
    //   38   77:dup             
    //   39   78:aload_0         
    //   40   79:getfield        #61  <Field Object m_RootObject>
    //   41   82:invokespecial   #68  <Method void PropertyNode(Object)>
    //   42   85:invokespecial   #69  <Method void DefaultMutableTreeNode(Object)>
    //   43   88:putfield        #71  <Field DefaultMutableTreeNode m_Root>
        createNodes(m_Root);
    //   44   91:aload_0         
    //   45   92:aload_0         
    //   46   93:getfield        #71  <Field DefaultMutableTreeNode m_Root>
    //   47   96:invokevirtual   #75  <Method void createNodes(DefaultMutableTreeNode)>
        Container c = getContentPane();
    //   48   99:aload_0         
    //   49  100:invokevirtual   #79  <Method Container getContentPane()>
    //   50  103:astore_3        
        c.setLayout(new BorderLayout());
    //   51  104:aload_3         
    //   52  105:new             #81  <Class BorderLayout>
    //   53  108:dup             
    //   54  109:invokespecial   #84  <Method void BorderLayout()>
    //   55  112:invokevirtual   #90  <Method void Container.setLayout(java.awt.LayoutManager)>
        Box b1 = new Box(0);
    //   56  115:new             #92  <Class Box>
    //   57  118:dup             
    //   58  119:iconst_0        
    //   59  120:invokespecial   #95  <Method void Box(int)>
    //   60  123:astore          4
        b1.add(m_SelectBut);
    //   61  125:aload           4
    //   62  127:aload_0         
    //   63  128:getfield        #43  <Field JButton m_SelectBut>
    //   64  131:invokevirtual   #99  <Method java.awt.Component Box.add(java.awt.Component)>
    //   65  134:pop             
        b1.add(Box.createHorizontalStrut(10));
    //   66  135:aload           4
    //   67  137:bipush          10
    //   68  139:invokestatic    #103 <Method java.awt.Component Box.createHorizontalStrut(int)>
    //   69  142:invokevirtual   #99  <Method java.awt.Component Box.add(java.awt.Component)>
    //   70  145:pop             
        b1.add(m_CancelBut);
    //   71  146:aload           4
    //   72  148:aload_0         
    //   73  149:getfield        #47  <Field JButton m_CancelBut>
    //   74  152:invokevirtual   #99  <Method java.awt.Component Box.add(java.awt.Component)>
    //   75  155:pop             
        c.add(b1, "South");
    //   76  156:aload_3         
    //   77  157:aload           4
    //   78  159:ldc1            #105 <String "South">
    //   79  161:invokevirtual   #108 <Method void Container.add(java.awt.Component, Object)>
        m_Tree = new JTree(m_Root);
    //   80  164:aload_0         
    //   81  165:new             #110 <Class JTree>
    //   82  168:dup             
    //   83  169:aload_0         
    //   84  170:getfield        #71  <Field DefaultMutableTreeNode m_Root>
    //   85  173:invokespecial   #113 <Method void JTree(javax.swing.tree.TreeNode)>
    //   86  176:putfield        #115 <Field JTree m_Tree>
        m_Tree.getSelectionModel().setSelectionMode(1);
    //   87  179:aload_0         
    //   88  180:getfield        #115 <Field JTree m_Tree>
    //   89  183:invokevirtual   #119 <Method TreeSelectionModel JTree.getSelectionModel()>
    //   90  186:iconst_1        
    //   91  187:invokeinterface #124 <Method void TreeSelectionModel.setSelectionMode(int)>
        c.add(new JScrollPane(m_Tree), "Center");
    //   92  192:aload_3         
    //   93  193:new             #126 <Class JScrollPane>
    //   94  196:dup             
    //   95  197:aload_0         
    //   96  198:getfield        #115 <Field JTree m_Tree>
    //   97  201:invokespecial   #129 <Method void JScrollPane(java.awt.Component)>
    //   98  204:ldc1            #131 <String "Center">
    //   99  206:invokevirtual   #108 <Method void Container.add(java.awt.Component, Object)>
        pack();
    //  100  209:aload_0         
    //  101  210:invokevirtual   #134 <Method void pack()>
    //  102  213:return          
    }

    public int showDialog()
    {
        m_Result = 1;
    //    0    0:aload_0         
    //    1    1:iconst_1        
    //    2    2:putfield        #149 <Field int m_Result>
        setVisible(true);
    //    3    5:aload_0         
    //    4    6:iconst_1        
    //    5    7:invokevirtual   #153 <Method void setVisible(boolean)>
        return m_Result;
    //    6   10:aload_0         
    //    7   11:getfield        #149 <Field int m_Result>
    //    8   14:ireturn         
    }

    public PropertyNode[] getPath()
    {
        PropertyNode result[] = new PropertyNode[m_ResultPath.length - 1];
    //    0    0:aload_0         
    //    1    1:getfield        #157 <Field Object[] m_ResultPath>
    //    2    4:arraylength     
    //    3    5:iconst_1        
    //    4    6:isub            
    //    5    7:anewarray       PropertyNode[]
    //    6   10:astore_1        
        for(int i = 0; i < result.length; i++)
    //*   7   11:iconst_0        
    //*   8   12:istore_2        
    //*   9   13:goto            39
            result[i] = (PropertyNode)((DefaultMutableTreeNode)m_ResultPath[i + 1]).getUserObject();
    //   10   16:aload_1         
    //   11   17:iload_2         
    //   12   18:aload_0         
    //   13   19:getfield        #157 <Field Object[] m_ResultPath>
    //   14   22:iload_2         
    //   15   23:iconst_1        
    //   16   24:iadd            
    //   17   25:aaload          
    //   18   26:checkcast       #63  <Class DefaultMutableTreeNode>
    //   19   29:invokevirtual   #161 <Method Object DefaultMutableTreeNode.getUserObject()>
    //   20   32:checkcast       #65  <Class PropertyNode>
    //   21   35:aastore         

    //   22   36:iinc            2  1
    //   23   39:iload_2         
    //   24   40:aload_1         
    //   25   41:arraylength     
    //   26   42:icmplt          16
        return result;
    //   27   45:aload_1         
    //   28   46:areturn         
    }

    protected void createNodes(DefaultMutableTreeNode localNode)
    {
        Object localObject;
        PropertyDescriptor localProperties[];
        int i;
        PropertyNode pNode = (PropertyNode)localNode.getUserObject();
    //    0    0:aload_1         
    //    1    1:invokevirtual   #161 <Method Object DefaultMutableTreeNode.getUserObject()>
    //    2    4:checkcast       #65  <Class PropertyNode>
    //    3    7:astore_2        
        localObject = pNode.value;
    //    4    8:aload_2         
    //    5    9:getfield        #167 <Field Object PropertyNode.value>
    //    6   12:astore_3        
        try
        {
            BeanInfo bi = Introspector.getBeanInfo(localObject.getClass());
    //    7   13:aload_3         
    //    8   14:invokevirtual   #173 <Method Class Object.getClass()>
    //    9   17:invokestatic    #179 <Method BeanInfo Introspector.getBeanInfo(Class)>
    //   10   20:astore          5
            localProperties = bi.getPropertyDescriptors();
    //   11   22:aload           5
    //   12   24:invokeinterface #185 <Method PropertyDescriptor[] BeanInfo.getPropertyDescriptors()>
    //   13   29:astore          4
        }
    //*  14   31:goto            45
        catch(IntrospectionException ex)
    //*  15   34:astore          5
        {
            System.err.println("PropertySelectorDialog: Couldn't introspect");
    //   16   36:getstatic       #191 <Field PrintStream System.err>
    //   17   39:ldc1            #193 <String "PropertySelectorDialog: Couldn't introspect">
    //   18   41:invokevirtual   #198 <Method void PrintStream.println(String)>
            return;
    //   19   44:return          
        }
        i = 0;
    //   20   45:iconst_0        
    //   21   46:istore          5
          goto _L1
    //*  22   48:goto            347
_L3:
        String name;
        Class type;
        Method getter;
        Object value;
        if(localProperties[i].isHidden() || localProperties[i].isExpert())
    //*  23   51:aload           4
    //*  24   53:iload           5
    //*  25   55:aaload          
    //*  26   56:invokevirtual   #204 <Method boolean PropertyDescriptor.isHidden()>
    //*  27   59:ifne            344
    //*  28   62:aload           4
    //*  29   64:iload           5
    //*  30   66:aaload          
    //*  31   67:invokevirtual   #207 <Method boolean PropertyDescriptor.isExpert()>
    //*  32   70:ifeq            76
            continue; /* Loop/switch isn't completed */
    //   33   73:goto            344
        name = localProperties[i].getDisplayName();
    //   34   76:aload           4
    //   35   78:iload           5
    //   36   80:aaload          
    //   37   81:invokevirtual   #211 <Method String PropertyDescriptor.getDisplayName()>
    //   38   84:astore          6
        type = localProperties[i].getPropertyType();
    //   39   86:aload           4
    //   40   88:iload           5
    //   41   90:aaload          
    //   42   91:invokevirtual   #214 <Method Class PropertyDescriptor.getPropertyType()>
    //   43   94:astore          7
        getter = localProperties[i].getReadMethod();
    //   44   96:aload           4
    //   45   98:iload           5
    //   46  100:aaload          
    //   47  101:invokevirtual   #218 <Method Method PropertyDescriptor.getReadMethod()>
    //   48  104:astore          8
        Method setter = localProperties[i].getWriteMethod();
    //   49  106:aload           4
    //   50  108:iload           5
    //   51  110:aaload          
    //   52  111:invokevirtual   #221 <Method Method PropertyDescriptor.getWriteMethod()>
    //   53  114:astore          9
        value = null;
    //   54  116:aconst_null     
    //   55  117:astore          10
        if(getter == null || setter == null)
    //*  56  119:aload           8
    //*  57  121:ifnull          344
    //*  58  124:aload           9
    //*  59  126:ifnonnull       132
            continue; /* Loop/switch isn't completed */
    //   60  129:goto            344
        PropertyEditor editor;
        Object args[] = new Object[0];
    //   61  132:iconst_0        
    //   62  133:anewarray       Object[]
    //   63  136:astore          11
        value = getter.invoke(localObject, args);
    //   64  138:aload           8
    //   65  140:aload_3         
    //   66  141:aload           11
    //   67  143:invokevirtual   #227 <Method Object Method.invoke(Object, Object[])>
    //   68  146:astore          10
        editor = null;
    //   69  148:aconst_null     
    //   70  149:astore          12
        Class pec = localProperties[i].getPropertyEditorClass();
    //   71  151:aload           4
    //   72  153:iload           5
    //   73  155:aaload          
    //   74  156:invokevirtual   #230 <Method Class PropertyDescriptor.getPropertyEditorClass()>
    //   75  159:astore          13
        if(pec != null)
    //*  76  161:aload           13
    //*  77  163:ifnull          184
            try
            {
                editor = (PropertyEditor)(PropertyEditor)pec.newInstance();
    //   78  166:aload           13
    //   79  168:invokevirtual   #235 <Method Object Class.newInstance()>
    //   80  171:checkcast       #237 <Class PropertyEditor>
    //   81  174:checkcast       #237 <Class PropertyEditor>
    //   82  177:astore          12
            }
    //*  83  179:goto            184
            catch(Exception exception) { }
    //   84  182:astore          14
        if(editor == null)
    //*  85  184:aload           12
    //*  86  186:ifnonnull       196
            editor = PropertyEditorManager.findEditor(type);
    //   87  189:aload           7
    //   88  191:invokestatic    #243 <Method PropertyEditor PropertyEditorManager.findEditor(Class)>
    //   89  194:astore          12
        InvocationTargetException ex;
        if(editor != null && value != null)
    //*  90  196:aload           12
    //*  91  198:ifnull          344
    //*  92  201:aload           10
    //*  93  203:ifnonnull       305
    //*  94  206:goto            344
    //*  95  209:goto            305
    //*  96  212:astore          11
    //*  97  214:getstatic       #191 <Field PrintStream System.err>
    //*  98  217:new             #245 <Class StringBuilder>
    //*  99  220:dup             
    //* 100  221:ldc1            #247 <String "Skipping property ">
    //* 101  223:invokespecial   #248 <Method void StringBuilder(String)>
    //* 102  226:aload           6
    //* 103  228:invokevirtual   #252 <Method StringBuilder StringBuilder.append(String)>
    //* 104  231:ldc1            #254 <String " ; exception on target: ">
    //* 105  233:invokevirtual   #252 <Method StringBuilder StringBuilder.append(String)>
    //* 106  236:aload           11
    //* 107  238:invokevirtual   #260 <Method Throwable InvocationTargetException.getTargetException()>
    //* 108  241:invokevirtual   #263 <Method StringBuilder StringBuilder.append(Object)>
    //* 109  244:invokevirtual   #266 <Method String StringBuilder.toString()>
    //* 110  247:invokevirtual   #198 <Method void PrintStream.println(String)>
    //* 111  250:aload           11
    //* 112  252:invokevirtual   #260 <Method Throwable InvocationTargetException.getTargetException()>
    //* 113  255:invokevirtual   #271 <Method void Throwable.printStackTrace()>
    //* 114  258:goto            344
    //* 115  261:astore          11
    //* 116  263:getstatic       #191 <Field PrintStream System.err>
    //* 117  266:new             #245 <Class StringBuilder>
    //* 118  269:dup             
    //* 119  270:ldc1            #247 <String "Skipping property ">
    //* 120  272:invokespecial   #248 <Method void StringBuilder(String)>
    //* 121  275:aload           6
    //* 122  277:invokevirtual   #252 <Method StringBuilder StringBuilder.append(String)>
    //* 123  280:ldc2            #273 <String " ; exception: ">
    //* 124  283:invokevirtual   #252 <Method StringBuilder StringBuilder.append(String)>
    //* 125  286:aload           11
    //* 126  288:invokevirtual   #263 <Method StringBuilder StringBuilder.append(Object)>
    //* 127  291:invokevirtual   #266 <Method String StringBuilder.toString()>
    //* 128  294:invokevirtual   #198 <Method void PrintStream.println(String)>
    //* 129  297:aload           11
    //* 130  299:invokevirtual   #276 <Method void Exception.printStackTrace()>
    //* 131  302:goto            344
        {
            DefaultMutableTreeNode child = new DefaultMutableTreeNode(new PropertyNode(value, localProperties[i], localObject.getClass()));
    //  132  305:new             #63  <Class DefaultMutableTreeNode>
    //  133  308:dup             
    //  134  309:new             #65  <Class PropertyNode>
    //  135  312:dup             
    //  136  313:aload           10
    //  137  315:aload           4
    //  138  317:iload           5
    //  139  319:aaload          
    //  140  320:aload_3         
    //  141  321:invokevirtual   #173 <Method Class Object.getClass()>
    //  142  324:invokespecial   #279 <Method void PropertyNode(Object, PropertyDescriptor, Class)>
    //  143  327:invokespecial   #69  <Method void DefaultMutableTreeNode(Object)>
    //  144  330:astore          11
            localNode.add(child);
    //  145  332:aload_1         
    //  146  333:aload           11
    //  147  335:invokevirtual   #282 <Method void DefaultMutableTreeNode.add(javax.swing.tree.MutableTreeNode)>
            createNodes(child);
    //  148  338:aload_0         
    //  149  339:aload           11
    //  150  341:invokevirtual   #75  <Method void createNodes(DefaultMutableTreeNode)>
        }
        continue; /* Loop/switch isn't completed */
        ex;
        System.err.println((new StringBuilder("Skipping property ")).append(name).append(" ; exception on target: ").append(ex.getTargetException()).toString());
        ex.getTargetException().printStackTrace();
        continue; /* Loop/switch isn't completed */
        ex;
        System.err.println((new StringBuilder("Skipping property ")).append(name).append(" ; exception: ").append(ex).toString());
        ex.printStackTrace();
        i++;
    //  151  344:iinc            5  1
_L1:
        if(i < localProperties.length) goto _L3; else goto _L2
    //  152  347:iload           5
    //  153  349:aload           4
    //  154  351:arraylength     
    //  155  352:icmplt          51
_L2:
    //  156  355:return          
    }

    private static final long serialVersionUID = 0xd436fb5a310c60eaL;
    protected JButton m_SelectBut;
    protected JButton m_CancelBut;
    protected DefaultMutableTreeNode m_Root;
    protected Object m_RootObject;
    protected int m_Result;
    protected Object m_ResultPath[];
    protected JTree m_Tree;
    public static final int APPROVE_OPTION = 0;
    public static final int CANCEL_OPTION = 1;
}
