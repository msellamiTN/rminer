// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   GenericObjectEditor.java

package rm.gui;

import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.*;
import rm.core.*;
import rm.rolemining.HierarchicalMiner;

// Referenced classes of package rm.gui:
//            CustomPanelSupplier, GenericPropertiesCreator, HierarchyPropertyParser, PropertyPanel, 
//            PropertyDialog, CheckBoxList, PropertySheetPanel

public class GenericObjectEditor
    implements PropertyEditor, CustomPanelSupplier
{
    public class GOETreeNode extends DefaultMutableTreeNode
    {

        protected void initCapabilities()
        {
            if(m_Capabilities != null)
        //*   0    0:aload_0         
        //*   1    1:getfield        #32  <Field Capabilities m_Capabilities>
        //*   2    4:ifnull          8
                return;
        //    3    7:return          
            if(!isLeaf())
        //*   4    8:aload_0         
        //*   5    9:invokevirtual   #53  <Method boolean isLeaf()>
        //*   6   12:ifne            16
                return;
        //    7   15:return          
            String classname = getClassnameFromPath(new TreePath(getPath()));
        //    8   16:aload_0         
        //    9   17:getfield        #27  <Field GenericObjectEditor this$0>
        //   10   20:new             #55  <Class TreePath>
        //   11   23:dup             
        //   12   24:aload_0         
        //   13   25:invokevirtual   #59  <Method javax.swing.tree.TreeNode[] getPath()>
        //   14   28:invokespecial   #62  <Method void TreePath(Object[])>
        //   15   31:invokevirtual   #68  <Method String GenericObjectEditor.getClassnameFromPath(TreePath)>
        //   16   34:astore_1        
            try
            {
                Class cls = Class.forName(classname);
        //   17   35:aload_1         
        //   18   36:invokestatic    #74  <Method Class Class.forName(String)>
        //   19   39:astore_2        
                if(!ClassDiscovery.hasInterface(rm/core/CapabilitiesHandler, cls))
        //*  20   40:ldc1            #76  <Class CapabilitiesHandler>
        //*  21   42:aload_2         
        //*  22   43:invokestatic    #82  <Method boolean ClassDiscovery.hasInterface(Class, Class)>
        //*  23   46:ifne            50
                    return;
        //   24   49:return          
                Object obj = cls.newInstance();
        //   25   50:aload_2         
        //   26   51:invokevirtual   #86  <Method Object Class.newInstance()>
        //   27   54:astore_3        
                m_Capabilities = ((CapabilitiesHandler)obj).getCapabilities();
        //   28   55:aload_0         
        //   29   56:aload_3         
        //   30   57:checkcast       #76  <Class CapabilitiesHandler>
        //   31   60:invokeinterface #90  <Method Capabilities CapabilitiesHandler.getCapabilities()>
        //   32   65:putfield        #32  <Field Capabilities m_Capabilities>
            }
        //*  33   68:goto            73
            catch(Exception exception) { }
        //   34   71:astore          4
        //   35   73:return          
        }

        public String toString()
        {
            String result = super.toString();
        //    0    0:aload_0         
        //    1    1:invokespecial   #99  <Method String DefaultMutableTreeNode.toString()>
        //    2    4:astore_1        
            if(m_CapabilitiesFilter != null)
        //*   3    5:aload_0         
        //*   4    6:getfield        #27  <Field GenericObjectEditor this$0>
        //*   5    9:getfield        #102 <Field Capabilities GenericObjectEditor.m_CapabilitiesFilter>
        //*   6   12:ifnull          124
            {
                initCapabilities();
        //    7   15:aload_0         
        //    8   16:invokevirtual   #104 <Method void initCapabilities()>
                if(m_Capabilities != null)
        //*   9   19:aload_0         
        //*  10   20:getfield        #32  <Field Capabilities m_Capabilities>
        //*  11   23:ifnull          124
                    if(m_Capabilities.supportsMaybe(m_CapabilitiesFilter) && !m_Capabilities.supports(m_CapabilitiesFilter))
        //*  12   26:aload_0         
        //*  13   27:getfield        #32  <Field Capabilities m_Capabilities>
        //*  14   30:aload_0         
        //*  15   31:getfield        #27  <Field GenericObjectEditor this$0>
        //*  16   34:getfield        #102 <Field Capabilities GenericObjectEditor.m_CapabilitiesFilter>
        //*  17   37:invokevirtual   #110 <Method boolean Capabilities.supportsMaybe(Capabilities)>
        //*  18   40:ifeq            85
        //*  19   43:aload_0         
        //*  20   44:getfield        #32  <Field Capabilities m_Capabilities>
        //*  21   47:aload_0         
        //*  22   48:getfield        #27  <Field GenericObjectEditor this$0>
        //*  23   51:getfield        #102 <Field Capabilities GenericObjectEditor.m_CapabilitiesFilter>
        //*  24   54:invokevirtual   #113 <Method boolean Capabilities.supports(Capabilities)>
        //*  25   57:ifne            85
                        result = (new StringBuilder("<html><font color=\"blue\">")).append(result).append("</font></i><html>").toString();
        //   26   60:new             #115 <Class StringBuilder>
        //   27   63:dup             
        //   28   64:ldc1            #117 <String "<html><font color=\"blue\">">
        //   29   66:invokespecial   #120 <Method void StringBuilder(String)>
        //   30   69:aload_1         
        //   31   70:invokevirtual   #124 <Method StringBuilder StringBuilder.append(String)>
        //   32   73:ldc1            #126 <String "</font></i><html>">
        //   33   75:invokevirtual   #124 <Method StringBuilder StringBuilder.append(String)>
        //   34   78:invokevirtual   #127 <Method String StringBuilder.toString()>
        //   35   81:astore_1        
                    else
        //*  36   82:goto            124
                    if(!m_Capabilities.supports(m_CapabilitiesFilter))
        //*  37   85:aload_0         
        //*  38   86:getfield        #32  <Field Capabilities m_Capabilities>
        //*  39   89:aload_0         
        //*  40   90:getfield        #27  <Field GenericObjectEditor this$0>
        //*  41   93:getfield        #102 <Field Capabilities GenericObjectEditor.m_CapabilitiesFilter>
        //*  42   96:invokevirtual   #113 <Method boolean Capabilities.supports(Capabilities)>
        //*  43   99:ifne            124
                        result = (new StringBuilder("<html><font color=\"silver\">")).append(result).append("</font></i><html>").toString();
        //   44  102:new             #115 <Class StringBuilder>
        //   45  105:dup             
        //   46  106:ldc1            #129 <String "<html><font color=\"silver\">">
        //   47  108:invokespecial   #120 <Method void StringBuilder(String)>
        //   48  111:aload_1         
        //   49  112:invokevirtual   #124 <Method StringBuilder StringBuilder.append(String)>
        //   50  115:ldc1            #126 <String "</font></i><html>">
        //   51  117:invokevirtual   #124 <Method StringBuilder StringBuilder.append(String)>
        //   52  120:invokevirtual   #127 <Method String StringBuilder.toString()>
        //   53  123:astore_1        
            }
            return result;
        //   54  124:aload_1         
        //   55  125:areturn         
        }

        static final long serialVersionUID = 0xe84c6b0ef5d54b0bL;
        public static final String NO_SUPPORT = "silver";
        public static final String MAYBE_SUPPORT = "blue";
        protected Capabilities m_Capabilities;
        final GenericObjectEditor this$0;
        static Class class$0;

        public GOETreeNode()
        {
            this$0 = GenericObjectEditor.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #27  <Field GenericObjectEditor this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #30  <Method void DefaultMutableTreeNode()>
            m_Capabilities = null;
        //    5    9:aload_0         
        //    6   10:aconst_null     
        //    7   11:putfield        #32  <Field Capabilities m_Capabilities>
        //    8   14:return          
        }

        public GOETreeNode(Object userObject)
        {
            this$0 = GenericObjectEditor.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #27  <Field GenericObjectEditor this$0>
            super(userObject);
        //    3    5:aload_0         
        //    4    6:aload_2         
        //    5    7:invokespecial   #40  <Method void DefaultMutableTreeNode(Object)>
            m_Capabilities = null;
        //    6   10:aload_0         
        //    7   11:aconst_null     
        //    8   12:putfield        #32  <Field Capabilities m_Capabilities>
        //    9   15:return          
        }

        public GOETreeNode(Object userObject, boolean allowsChildren)
        {
            this$0 = GenericObjectEditor.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #27  <Field GenericObjectEditor this$0>
            super(userObject, allowsChildren);
        //    3    5:aload_0         
        //    4    6:aload_2         
        //    5    7:iload_3         
        //    6    8:invokespecial   #46  <Method void DefaultMutableTreeNode(Object, boolean)>
            m_Capabilities = null;
        //    7   11:aload_0         
        //    8   12:aconst_null     
        //    9   13:putfield        #32  <Field Capabilities m_Capabilities>
        //   10   16:return          
        }
    }

    public class CapabilitiesFilterDialog extends JDialog
    {

        protected void initGUI()
        {
            setTitle("Filtering Capabilities...");
        //    0    0:aload_0         
        //    1    1:ldc1            #75  <String "Filtering Capabilities...">
        //    2    3:invokevirtual   #78  <Method void setTitle(String)>
            setLayout(new BorderLayout());
        //    3    6:aload_0         
        //    4    7:new             #80  <Class BorderLayout>
        //    5   10:dup             
        //    6   11:invokespecial   #81  <Method void BorderLayout()>
        //    7   14:invokevirtual   #85  <Method void setLayout(java.awt.LayoutManager)>
            JPanel panel = new JPanel(new BorderLayout());
        //    8   17:new             #87  <Class JPanel>
        //    9   20:dup             
        //   10   21:new             #80  <Class BorderLayout>
        //   11   24:dup             
        //   12   25:invokespecial   #81  <Method void BorderLayout()>
        //   13   28:invokespecial   #89  <Method void JPanel(java.awt.LayoutManager)>
        //   14   31:astore_1        
            panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        //   15   32:aload_1         
        //   16   33:iconst_5        
        //   17   34:iconst_5        
        //   18   35:iconst_5        
        //   19   36:iconst_5        
        //   20   37:invokestatic    #95  <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
        //   21   40:invokevirtual   #99  <Method void JPanel.setBorder(javax.swing.border.Border)>
            getContentPane().add(panel, "North");
        //   22   43:aload_0         
        //   23   44:invokevirtual   #103 <Method Container getContentPane()>
        //   24   47:aload_1         
        //   25   48:ldc1            #105 <String "North">
        //   26   50:invokevirtual   #111 <Method void Container.add(Component, Object)>
            m_InfoLabel.setText((new StringBuilder("<html>")).append(m_ClassType.getName().replaceAll(".*\\.", "")).append("s").append(" have to support <i>at least</i> the following capabilities <br>").append("(the ones highlighted <font color=\"").append("silver").append("\">").append("silver").append("</font> don't meet these requirements <br>").append("the ones highlighted  <font color=\"").append("blue").append("\">").append("blue").append("</font> possibly meet them):").append("</html>").toString());
        //   27   53:aload_0         
        //   28   54:getfield        #46  <Field JLabel m_InfoLabel>
        //   29   57:new             #113 <Class StringBuilder>
        //   30   60:dup             
        //   31   61:ldc1            #115 <String "<html>">
        //   32   63:invokespecial   #116 <Method void StringBuilder(String)>
        //   33   66:aload_0         
        //   34   67:getfield        #29  <Field GenericObjectEditor this$0>
        //   35   70:getfield        #122 <Field Class GenericObjectEditor.m_ClassType>
        //   36   73:invokevirtual   #128 <Method String Class.getName()>
        //   37   76:ldc1            #130 <String ".*\\.">
        //   38   78:ldc1            #132 <String "">
        //   39   80:invokevirtual   #138 <Method String String.replaceAll(String, String)>
        //   40   83:invokevirtual   #142 <Method StringBuilder StringBuilder.append(String)>
        //   41   86:ldc1            #144 <String "s">
        //   42   88:invokevirtual   #142 <Method StringBuilder StringBuilder.append(String)>
        //   43   91:ldc1            #146 <String " have to support <i>at least</i> the following capabilities <br>">
        //   44   93:invokevirtual   #142 <Method StringBuilder StringBuilder.append(String)>
        //   45   96:ldc1            #148 <String "(the ones highlighted <font color=\"">
        //   46   98:invokevirtual   #142 <Method StringBuilder StringBuilder.append(String)>
        //   47  101:ldc1            #150 <String "silver">
        //   48  103:invokevirtual   #142 <Method StringBuilder StringBuilder.append(String)>
        //   49  106:ldc1            #152 <String "\">">
        //   50  108:invokevirtual   #142 <Method StringBuilder StringBuilder.append(String)>
        //   51  111:ldc1            #150 <String "silver">
        //   52  113:invokevirtual   #142 <Method StringBuilder StringBuilder.append(String)>
        //   53  116:ldc1            #154 <String "</font> don't meet these requirements <br>">
        //   54  118:invokevirtual   #142 <Method StringBuilder StringBuilder.append(String)>
        //   55  121:ldc1            #156 <String "the ones highlighted  <font color=\"">
        //   56  123:invokevirtual   #142 <Method StringBuilder StringBuilder.append(String)>
        //   57  126:ldc1            #158 <String "blue">
        //   58  128:invokevirtual   #142 <Method StringBuilder StringBuilder.append(String)>
        //   59  131:ldc1            #152 <String "\">">
        //   60  133:invokevirtual   #142 <Method StringBuilder StringBuilder.append(String)>
        //   61  136:ldc1            #158 <String "blue">
        //   62  138:invokevirtual   #142 <Method StringBuilder StringBuilder.append(String)>
        //   63  141:ldc1            #160 <String "</font> possibly meet them):">
        //   64  143:invokevirtual   #142 <Method StringBuilder StringBuilder.append(String)>
        //   65  146:ldc1            #162 <String "</html>">
        //   66  148:invokevirtual   #142 <Method StringBuilder StringBuilder.append(String)>
        //   67  151:invokevirtual   #165 <Method String StringBuilder.toString()>
        //   68  154:invokevirtual   #168 <Method void JLabel.setText(String)>
            panel.add(m_InfoLabel, "Center");
        //   69  157:aload_1         
        //   70  158:aload_0         
        //   71  159:getfield        #46  <Field JLabel m_InfoLabel>
        //   72  162:ldc1            #170 <String "Center">
        //   73  164:invokevirtual   #171 <Method void JPanel.add(Component, Object)>
            getContentPane().add(new JScrollPane(m_List), "Center");
        //   74  167:aload_0         
        //   75  168:invokevirtual   #103 <Method Container getContentPane()>
        //   76  171:new             #173 <Class JScrollPane>
        //   77  174:dup             
        //   78  175:aload_0         
        //   79  176:getfield        #51  <Field CheckBoxList m_List>
        //   80  179:invokespecial   #176 <Method void JScrollPane(Component)>
        //   81  182:ldc1            #170 <String "Center">
        //   82  184:invokevirtual   #111 <Method void Container.add(Component, Object)>
            CheckBoxList.CheckBoxListModel model = (CheckBoxList.CheckBoxListModel)m_List.getModel();
        //   83  187:aload_0         
        //   84  188:getfield        #51  <Field CheckBoxList m_List>
        //   85  191:invokevirtual   #180 <Method javax.swing.ListModel CheckBoxList.getModel()>
        //   86  194:checkcast       #182 <Class CheckBoxList$CheckBoxListModel>
        //   87  197:astore_2        
            rm.core.Capabilities.Capability acapability[] = rm.core.Capabilities.Capability.values();
        //   88  198:invokestatic    #188 <Method rm.core.Capabilities$Capability[] rm.core.Capabilities$Capability.values()>
        //   89  201:astore          6
            int i = 0;
        //   90  203:iconst_0        
        //   91  204:istore          4
            for(int j = acapability.length; i < j; i++)
        //*  92  206:aload           6
        //*  93  208:arraylength     
        //*  94  209:istore          5
        //*  95  211:goto            228
            {
                rm.core.Capabilities.Capability cap = acapability[i];
        //   96  214:aload           6
        //   97  216:iload           4
        //   98  218:aaload          
        //   99  219:astore_3        
                model.addElement(cap);
        //  100  220:aload_2         
        //  101  221:aload_3         
        //  102  222:invokevirtual   #192 <Method void CheckBoxList$CheckBoxListModel.addElement(Object)>
            }

        //  103  225:iinc            4  1
        //  104  228:iload           4
        //  105  230:iload           5
        //  106  232:icmplt          214
            panel = new JPanel(new FlowLayout(1));
        //  107  235:new             #87  <Class JPanel>
        //  108  238:dup             
        //  109  239:new             #194 <Class FlowLayout>
        //  110  242:dup             
        //  111  243:iconst_1        
        //  112  244:invokespecial   #197 <Method void FlowLayout(int)>
        //  113  247:invokespecial   #89  <Method void JPanel(java.awt.LayoutManager)>
        //  114  250:astore_1        
            getContentPane().add(panel, "South");
        //  115  251:aload_0         
        //  116  252:invokevirtual   #103 <Method Container getContentPane()>
        //  117  255:aload_1         
        //  118  256:ldc1            #199 <String "South">
        //  119  258:invokevirtual   #111 <Method void Container.add(Component, Object)>
            m_OkButton.setMnemonic('O');
        //  120  261:aload_0         
        //  121  262:getfield        #60  <Field JButton m_OkButton>
        //  122  265:bipush          79
        //  123  267:invokevirtual   #203 <Method void JButton.setMnemonic(char)>
            m_OkButton.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e)
                {
                    updateCapabilities();
                //    0    0:aload_0         
                //    1    1:getfield        #13  <Field GenericObjectEditor$CapabilitiesFilterDialog this$1>
                //    2    4:invokevirtual   #27  <Method void GenericObjectEditor$CapabilitiesFilterDialog.updateCapabilities()>
                    if(m_CapabilitiesFilter == null)
                //*   3    7:aload_0         
                //*   4    8:getfield        #13  <Field GenericObjectEditor$CapabilitiesFilterDialog this$1>
                //*   5   11:invokestatic    #31  <Method GenericObjectEditor GenericObjectEditor$CapabilitiesFilterDialog.access$0(GenericObjectEditor$CapabilitiesFilterDialog)>
                //*   6   14:getfield        #37  <Field Capabilities GenericObjectEditor.m_CapabilitiesFilter>
                //*   7   17:ifnonnull       38
                        m_CapabilitiesFilter = new Capabilities(null);
                //    8   20:aload_0         
                //    9   21:getfield        #13  <Field GenericObjectEditor$CapabilitiesFilterDialog this$1>
                //   10   24:invokestatic    #31  <Method GenericObjectEditor GenericObjectEditor$CapabilitiesFilterDialog.access$0(GenericObjectEditor$CapabilitiesFilterDialog)>
                //   11   27:new             #39  <Class Capabilities>
                //   12   30:dup             
                //   13   31:aconst_null     
                //   14   32:invokespecial   #42  <Method void Capabilities(CapabilitiesHandler)>
                //   15   35:putfield        #37  <Field Capabilities GenericObjectEditor.m_CapabilitiesFilter>
                    m_CapabilitiesFilter.assign(m_Capabilities);
                //   16   38:aload_0         
                //   17   39:getfield        #13  <Field GenericObjectEditor$CapabilitiesFilterDialog this$1>
                //   18   42:invokestatic    #31  <Method GenericObjectEditor GenericObjectEditor$CapabilitiesFilterDialog.access$0(GenericObjectEditor$CapabilitiesFilterDialog)>
                //   19   45:getfield        #37  <Field Capabilities GenericObjectEditor.m_CapabilitiesFilter>
                //   20   48:aload_0         
                //   21   49:getfield        #13  <Field GenericObjectEditor$CapabilitiesFilterDialog this$1>
                //   22   52:getfield        #45  <Field Capabilities GenericObjectEditor$CapabilitiesFilterDialog.m_Capabilities>
                //   23   55:invokevirtual   #49  <Method void Capabilities.assign(Capabilities)>
                    m_Self.setVisible(false);
                //   24   58:aload_0         
                //   25   59:getfield        #13  <Field GenericObjectEditor$CapabilitiesFilterDialog this$1>
                //   26   62:getfield        #53  <Field JDialog GenericObjectEditor$CapabilitiesFilterDialog.m_Self>
                //   27   65:iconst_0        
                //   28   66:invokevirtual   #59  <Method void JDialog.setVisible(boolean)>
                    showPopup();
                //   29   69:aload_0         
                //   30   70:getfield        #13  <Field GenericObjectEditor$CapabilitiesFilterDialog this$1>
                //   31   73:invokevirtual   #62  <Method void GenericObjectEditor$CapabilitiesFilterDialog.showPopup()>
                //   32   76:return          
                }

                final CapabilitiesFilterDialog this$1;

                
                {
                    this$1 = CapabilitiesFilterDialog.this;
                //    0    0:aload_0         
                //    1    1:aload_1         
                //    2    2:putfield        #13  <Field GenericObjectEditor$CapabilitiesFilterDialog this$1>
                    super();
                //    3    5:aload_0         
                //    4    6:invokespecial   #16  <Method void Object()>
                //    5    9:return          
                }
            }
);
        //  124  270:aload_0         
        //  125  271:getfield        #60  <Field JButton m_OkButton>
        //  126  274:new             #205 <Class GenericObjectEditor$1>
        //  127  277:dup             
        //  128  278:aload_0         
        //  129  279:invokespecial   #208 <Method void GenericObjectEditor$1(GenericObjectEditor$CapabilitiesFilterDialog)>
        //  130  282:invokevirtual   #212 <Method void JButton.addActionListener(ActionListener)>
            panel.add(m_OkButton);
        //  131  285:aload_1         
        //  132  286:aload_0         
        //  133  287:getfield        #60  <Field JButton m_OkButton>
        //  134  290:invokevirtual   #215 <Method Component JPanel.add(Component)>
        //  135  293:pop             
            m_CancelButton.setMnemonic('C');
        //  136  294:aload_0         
        //  137  295:getfield        #64  <Field JButton m_CancelButton>
        //  138  298:bipush          67
        //  139  300:invokevirtual   #203 <Method void JButton.setMnemonic(char)>
            m_CancelButton.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e)
                {
                    m_Self.setVisible(false);
                //    0    0:aload_0         
                //    1    1:getfield        #13  <Field GenericObjectEditor$CapabilitiesFilterDialog this$1>
                //    2    4:getfield        #28  <Field JDialog GenericObjectEditor$CapabilitiesFilterDialog.m_Self>
                //    3    7:iconst_0        
                //    4    8:invokevirtual   #34  <Method void JDialog.setVisible(boolean)>
                    showPopup();
                //    5   11:aload_0         
                //    6   12:getfield        #13  <Field GenericObjectEditor$CapabilitiesFilterDialog this$1>
                //    7   15:invokevirtual   #37  <Method void GenericObjectEditor$CapabilitiesFilterDialog.showPopup()>
                //    8   18:return          
                }

                final CapabilitiesFilterDialog this$1;

                
                {
                    this$1 = CapabilitiesFilterDialog.this;
                //    0    0:aload_0         
                //    1    1:aload_1         
                //    2    2:putfield        #13  <Field GenericObjectEditor$CapabilitiesFilterDialog this$1>
                    super();
                //    3    5:aload_0         
                //    4    6:invokespecial   #16  <Method void Object()>
                //    5    9:return          
                }
            }
);
        //  140  303:aload_0         
        //  141  304:getfield        #64  <Field JButton m_CancelButton>
        //  142  307:new             #217 <Class GenericObjectEditor$2>
        //  143  310:dup             
        //  144  311:aload_0         
        //  145  312:invokespecial   #218 <Method void GenericObjectEditor$2(GenericObjectEditor$CapabilitiesFilterDialog)>
        //  146  315:invokevirtual   #212 <Method void JButton.addActionListener(ActionListener)>
            panel.add(m_CancelButton);
        //  147  318:aload_1         
        //  148  319:aload_0         
        //  149  320:getfield        #64  <Field JButton m_CancelButton>
        //  150  323:invokevirtual   #215 <Method Component JPanel.add(Component)>
        //  151  326:pop             
            pack();
        //  152  327:aload_0         
        //  153  328:invokevirtual   #221 <Method void pack()>
        //  154  331:return          
        }

        protected void updateList()
        {
            CheckBoxList.CheckBoxListModel model = (CheckBoxList.CheckBoxListModel)m_List.getModel();
        //    0    0:aload_0         
        //    1    1:getfield        #51  <Field CheckBoxList m_List>
        //    2    4:invokevirtual   #180 <Method javax.swing.ListModel CheckBoxList.getModel()>
        //    3    7:checkcast       #182 <Class CheckBoxList$CheckBoxListModel>
        //    4   10:astore_1        
            rm.core.Capabilities.Capability acapability[] = rm.core.Capabilities.Capability.values();
        //    5   11:invokestatic    #188 <Method rm.core.Capabilities$Capability[] rm.core.Capabilities$Capability.values()>
        //    6   14:astore          5
            int i = 0;
        //    7   16:iconst_0        
        //    8   17:istore_3        
            for(int j = acapability.length; i < j; i++)
        //*   9   18:aload           5
        //*  10   20:arraylength     
        //*  11   21:istore          4
        //*  12   23:goto            51
            {
                rm.core.Capabilities.Capability cap = acapability[i];
        //   13   26:aload           5
        //   14   28:iload_3         
        //   15   29:aaload          
        //   16   30:astore_2        
                model.setChecked(model.indexOf(cap), m_Capabilities.handles(cap));
        //   17   31:aload_1         
        //   18   32:aload_1         
        //   19   33:aload_2         
        //   20   34:invokevirtual   #232 <Method int CheckBoxList$CheckBoxListModel.indexOf(Object)>
        //   21   37:aload_0         
        //   22   38:getfield        #41  <Field Capabilities m_Capabilities>
        //   23   41:aload_2         
        //   24   42:invokevirtual   #236 <Method boolean Capabilities.handles(rm.core.Capabilities$Capability)>
        //   25   45:invokevirtual   #240 <Method void CheckBoxList$CheckBoxListModel.setChecked(int, boolean)>
            }

        //   26   48:iinc            3  1
        //   27   51:iload_3         
        //   28   52:iload           4
        //   29   54:icmplt          26
        //   30   57:return          
        }

        protected void updateCapabilities()
        {
            CheckBoxList.CheckBoxListModel model = (CheckBoxList.CheckBoxListModel)m_List.getModel();
        //    0    0:aload_0         
        //    1    1:getfield        #51  <Field CheckBoxList m_List>
        //    2    4:invokevirtual   #180 <Method javax.swing.ListModel CheckBoxList.getModel()>
        //    3    7:checkcast       #182 <Class CheckBoxList$CheckBoxListModel>
        //    4   10:astore_1        
            rm.core.Capabilities.Capability acapability[] = rm.core.Capabilities.Capability.values();
        //    5   11:invokestatic    #188 <Method rm.core.Capabilities$Capability[] rm.core.Capabilities$Capability.values()>
        //    6   14:astore          5
            int i = 0;
        //    7   16:iconst_0        
        //    8   17:istore_3        
            for(int j = acapability.length; i < j; i++)
        //*   9   18:aload           5
        //*  10   20:arraylength     
        //*  11   21:istore          4
        //*  12   23:goto            65
            {
                rm.core.Capabilities.Capability cap = acapability[i];
        //   13   26:aload           5
        //   14   28:iload_3         
        //   15   29:aaload          
        //   16   30:astore_2        
                if(model.getChecked(model.indexOf(cap)))
        //*  17   31:aload_1         
        //*  18   32:aload_1         
        //*  19   33:aload_2         
        //*  20   34:invokevirtual   #232 <Method int CheckBoxList$CheckBoxListModel.indexOf(Object)>
        //*  21   37:invokevirtual   #245 <Method boolean CheckBoxList$CheckBoxListModel.getChecked(int)>
        //*  22   40:ifeq            54
                    m_Capabilities.enable(cap);
        //   23   43:aload_0         
        //   24   44:getfield        #41  <Field Capabilities m_Capabilities>
        //   25   47:aload_2         
        //   26   48:invokevirtual   #249 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
                else
        //*  27   51:goto            62
                    m_Capabilities.disable(cap);
        //   28   54:aload_0         
        //   29   55:getfield        #41  <Field Capabilities m_Capabilities>
        //   30   58:aload_2         
        //   31   59:invokevirtual   #252 <Method void Capabilities.disable(rm.core.Capabilities$Capability)>
            }

        //   32   62:iinc            3  1
        //   33   65:iload_3         
        //   34   66:iload           4
        //   35   68:icmplt          26
        //   36   71:return          
        }

        public void setCapabilities(Capabilities value)
        {
            if(value != null)
        //*   0    0:aload_1         
        //*   1    1:ifnull          15
                m_Capabilities.assign(value);
        //    2    4:aload_0         
        //    3    5:getfield        #41  <Field Capabilities m_Capabilities>
        //    4    8:aload_1         
        //    5    9:invokevirtual   #257 <Method void Capabilities.assign(Capabilities)>
            else
        //*   6   12:goto            27
                m_Capabilities = new Capabilities(null);
        //    7   15:aload_0         
        //    8   16:new             #36  <Class Capabilities>
        //    9   19:dup             
        //   10   20:aconst_null     
        //   11   21:invokespecial   #39  <Method void Capabilities(CapabilitiesHandler)>
        //   12   24:putfield        #41  <Field Capabilities m_Capabilities>
            updateList();
        //   13   27:aload_0         
        //   14   28:invokevirtual   #259 <Method void updateList()>
        //   15   31:return          
        }

        public Capabilities getCapabilities()
        {
            return m_Capabilities;
        //    0    0:aload_0         
        //    1    1:getfield        #41  <Field Capabilities m_Capabilities>
        //    2    4:areturn         
        }

        public void setPopup(JPopupMenu value)
        {
            m_Popup = value;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #34  <Field JPopupMenu m_Popup>
        //    3    5:return          
        }

        public JPopupMenu getPopup()
        {
            return m_Popup;
        //    0    0:aload_0         
        //    1    1:getfield        #34  <Field JPopupMenu m_Popup>
        //    2    4:areturn         
        }

        public void showPopup()
        {
            if(getPopup() != null)
        //*   0    0:aload_0         
        //*   1    1:invokevirtual   #269 <Method JPopupMenu getPopup()>
        //*   2    4:ifnull          15
                getPopup().setVisible(true);
        //    3    7:aload_0         
        //    4    8:invokevirtual   #269 <Method JPopupMenu getPopup()>
        //    5   11:iconst_1        
        //    6   12:invokevirtual   #275 <Method void JPopupMenu.setVisible(boolean)>
        //    7   15:return          
        }

        static final long serialVersionUID = 0x931f2c463c07ab46L;
        protected JDialog m_Self;
        protected JPopupMenu m_Popup;
        protected Capabilities m_Capabilities;
        protected JLabel m_InfoLabel;
        protected CheckBoxList m_List;
        protected JButton m_OkButton;
        protected JButton m_CancelButton;
        final GenericObjectEditor this$0;


/*
        static GenericObjectEditor access$0(CapabilitiesFilterDialog capabilitiesfilterdialog)
        {
            return capabilitiesfilterdialog.this$0;
        //    0    0:aload_0         
        //    1    1:getfield        #29  <Field GenericObjectEditor this$0>
        //    2    4:areturn         
        }

*/

        public CapabilitiesFilterDialog()
        {
            this$0 = GenericObjectEditor.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #29  <Field GenericObjectEditor this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #32  <Method void JDialog()>
            m_Popup = null;
        //    5    9:aload_0         
        //    6   10:aconst_null     
        //    7   11:putfield        #34  <Field JPopupMenu m_Popup>
            m_Capabilities = new Capabilities(null);
        //    8   14:aload_0         
        //    9   15:new             #36  <Class Capabilities>
        //   10   18:dup             
        //   11   19:aconst_null     
        //   12   20:invokespecial   #39  <Method void Capabilities(CapabilitiesHandler)>
        //   13   23:putfield        #41  <Field Capabilities m_Capabilities>
            m_InfoLabel = new JLabel();
        //   14   26:aload_0         
        //   15   27:new             #43  <Class JLabel>
        //   16   30:dup             
        //   17   31:invokespecial   #44  <Method void JLabel()>
        //   18   34:putfield        #46  <Field JLabel m_InfoLabel>
            m_List = new CheckBoxList();
        //   19   37:aload_0         
        //   20   38:new             #48  <Class CheckBoxList>
        //   21   41:dup             
        //   22   42:invokespecial   #49  <Method void CheckBoxList()>
        //   23   45:putfield        #51  <Field CheckBoxList m_List>
            m_OkButton = new JButton("OK");
        //   24   48:aload_0         
        //   25   49:new             #53  <Class JButton>
        //   26   52:dup             
        //   27   53:ldc1            #55  <String "OK">
        //   28   55:invokespecial   #58  <Method void JButton(String)>
        //   29   58:putfield        #60  <Field JButton m_OkButton>
            m_CancelButton = new JButton("Cancel");
        //   30   61:aload_0         
        //   31   62:new             #53  <Class JButton>
        //   32   65:dup             
        //   33   66:ldc1            #62  <String "Cancel">
        //   34   68:invokespecial   #58  <Method void JButton(String)>
        //   35   71:putfield        #64  <Field JButton m_CancelButton>
            m_Self = this;
        //   36   74:aload_0         
        //   37   75:aload_0         
        //   38   76:putfield        #66  <Field JDialog m_Self>
            initGUI();
        //   39   79:aload_0         
        //   40   80:invokevirtual   #69  <Method void initGUI()>
        //   41   83:return          
        }
    }

    public class JTreePopupMenu extends JPopupMenu
    {

        public void show(Component invoker, int x, int y)
        {
            super.show(invoker, x, y);
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:iload_2         
        //    3    3:iload_3         
        //    4    4:invokespecial   #162 <Method void JPopupMenu.show(Component, int, int)>
            Point location = getLocationOnScreen();
        //    5    7:aload_0         
        //    6    8:invokevirtual   #166 <Method Point getLocationOnScreen()>
        //    7   11:astore          4
            Dimension screenSize = getToolkit().getScreenSize();
        //    8   13:aload_0         
        //    9   14:invokevirtual   #170 <Method Toolkit getToolkit()>
        //   10   17:invokevirtual   #176 <Method Dimension Toolkit.getScreenSize()>
        //   11   20:astore          5
            int maxWidth = (int)(screenSize.getWidth() - location.getX());
        //   12   22:aload           5
        //   13   24:invokevirtual   #180 <Method double Dimension.getWidth()>
        //   14   27:aload           4
        //   15   29:invokevirtual   #185 <Method double Point.getX()>
        //   16   32:dsub            
        //   17   33:d2i             
        //   18   34:istore          6
            int maxHeight = (int)(screenSize.getHeight() - location.getY());
        //   19   36:aload           5
        //   20   38:invokevirtual   #188 <Method double Dimension.getHeight()>
        //   21   41:aload           4
        //   22   43:invokevirtual   #191 <Method double Point.getY()>
        //   23   46:dsub            
        //   24   47:d2i             
        //   25   48:istore          7
            Dimension scrollerSize = m_scroller.getPreferredSize();
        //   26   50:aload_0         
        //   27   51:getfield        #131 <Field JScrollPane m_scroller>
        //   28   54:invokevirtual   #194 <Method Dimension JScrollPane.getPreferredSize()>
        //   29   57:astore          8
            int height = (int)scrollerSize.getHeight();
        //   30   59:aload           8
        //   31   61:invokevirtual   #188 <Method double Dimension.getHeight()>
        //   32   64:d2i             
        //   33   65:istore          9
            int width = (int)scrollerSize.getWidth();
        //   34   67:aload           8
        //   35   69:invokevirtual   #180 <Method double Dimension.getWidth()>
        //   36   72:d2i             
        //   37   73:istore          10
            if(width > maxWidth)
        //*  38   75:iload           10
        //*  39   77:iload           6
        //*  40   79:icmple          86
                width = maxWidth;
        //   41   82:iload           6
        //   42   84:istore          10
            if(height > maxHeight)
        //*  43   86:iload           9
        //*  44   88:iload           7
        //*  45   90:icmple          97
                height = maxHeight;
        //   46   93:iload           7
        //   47   95:istore          9
            m_scroller.setPreferredSize(new Dimension(width, height));
        //   48   97:aload_0         
        //   49   98:getfield        #131 <Field JScrollPane m_scroller>
        //   50  101:new             #133 <Class Dimension>
        //   51  104:dup             
        //   52  105:iload           10
        //   53  107:iload           9
        //   54  109:invokespecial   #136 <Method void Dimension(int, int)>
        //   55  112:invokevirtual   #140 <Method void JScrollPane.setPreferredSize(Dimension)>
            revalidate();
        //   56  115:aload_0         
        //   57  116:invokevirtual   #197 <Method void revalidate()>
            pack();
        //   58  119:aload_0         
        //   59  120:invokevirtual   #200 <Method void pack()>
        //   60  123:return          
        }

        static final long serialVersionUID = 0xd0c09f26b78ce415L;
        private JPopupMenu m_Self;
        private JTree m_tree;
        private JScrollPane m_scroller;
        private JButton m_FilterButton;
        private JButton m_RemoveFilterButton;
        private JButton m_CloseButton;
        final GenericObjectEditor this$0;
        static Class class$0;


/*
        static JButton access$0(JTreePopupMenu jtreepopupmenu)
        {
            return jtreepopupmenu.m_FilterButton;
        //    0    0:aload_0         
        //    1    1:getfield        #40  <Field JButton m_FilterButton>
        //    2    4:areturn         
        }

*/


/*
        static JPopupMenu access$1(JTreePopupMenu jtreepopupmenu)
        {
            return jtreepopupmenu.m_Self;
        //    0    0:aload_0         
        //    1    1:getfield        #50  <Field JPopupMenu m_Self>
        //    2    4:areturn         
        }

*/


/*
        static JButton access$2(JTreePopupMenu jtreepopupmenu)
        {
            return jtreepopupmenu.m_RemoveFilterButton;
        //    0    0:aload_0         
        //    1    1:getfield        #44  <Field JButton m_RemoveFilterButton>
        //    2    4:areturn         
        }

*/


/*
        static JButton access$3(JTreePopupMenu jtreepopupmenu)
        {
            return jtreepopupmenu.m_CloseButton;
        //    0    0:aload_0         
        //    1    1:getfield        #48  <Field JButton m_CloseButton>
        //    2    4:areturn         
        }

*/


/*
        static GenericObjectEditor access$4(JTreePopupMenu jtreepopupmenu)
        {
            return jtreepopupmenu.this$0;
        //    0    0:aload_0         
        //    1    1:getfield        #28  <Field GenericObjectEditor this$0>
        //    2    4:areturn         
        }

*/

        public JTreePopupMenu(JTree tree)
        {
            this$0 = GenericObjectEditor.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #28  <Field GenericObjectEditor this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #31  <Method void JPopupMenu()>
            m_FilterButton = new JButton("Filter...");
        //    5    9:aload_0         
        //    6   10:new             #33  <Class JButton>
        //    7   13:dup             
        //    8   14:ldc1            #35  <String "Filter...">
        //    9   16:invokespecial   #38  <Method void JButton(String)>
        //   10   19:putfield        #40  <Field JButton m_FilterButton>
            m_RemoveFilterButton = new JButton("Remove filter");
        //   11   22:aload_0         
        //   12   23:new             #33  <Class JButton>
        //   13   26:dup             
        //   14   27:ldc1            #42  <String "Remove filter">
        //   15   29:invokespecial   #38  <Method void JButton(String)>
        //   16   32:putfield        #44  <Field JButton m_RemoveFilterButton>
            m_CloseButton = new JButton("Close");
        //   17   35:aload_0         
        //   18   36:new             #33  <Class JButton>
        //   19   39:dup             
        //   20   40:ldc1            #46  <String "Close">
        //   21   42:invokespecial   #38  <Method void JButton(String)>
        //   22   45:putfield        #48  <Field JButton m_CloseButton>
            m_Self = this;
        //   23   48:aload_0         
        //   24   49:aload_0         
        //   25   50:putfield        #50  <Field JPopupMenu m_Self>
            setLayout(new BorderLayout());
        //   26   53:aload_0         
        //   27   54:new             #52  <Class BorderLayout>
        //   28   57:dup             
        //   29   58:invokespecial   #53  <Method void BorderLayout()>
        //   30   61:invokevirtual   #57  <Method void setLayout(java.awt.LayoutManager)>
            JPanel panel = new JPanel(new FlowLayout(2));
        //   31   64:new             #59  <Class JPanel>
        //   32   67:dup             
        //   33   68:new             #61  <Class FlowLayout>
        //   34   71:dup             
        //   35   72:iconst_2        
        //   36   73:invokespecial   #64  <Method void FlowLayout(int)>
        //   37   76:invokespecial   #66  <Method void JPanel(java.awt.LayoutManager)>
        //   38   79:astore_3        
            add(panel, "South");
        //   39   80:aload_0         
        //   40   81:aload_3         
        //   41   82:ldc1            #68  <String "South">
        //   42   84:invokevirtual   #72  <Method void add(Component, Object)>
            if(ClassDiscovery.hasInterface(rm/core/CapabilitiesHandler, m_ClassType))
        //*  43   87:ldc1            #74  <Class CapabilitiesHandler>
        //*  44   89:aload_1         
        //*  45   90:getfield        #79  <Field Class GenericObjectEditor.m_ClassType>
        //*  46   93:invokestatic    #85  <Method boolean ClassDiscovery.hasInterface(Class, Class)>
        //*  47   96:ifeq            165
            {
                m_FilterButton.setMnemonic('F');
        //   48   99:aload_0         
        //   49  100:getfield        #40  <Field JButton m_FilterButton>
        //   50  103:bipush          70
        //   51  105:invokevirtual   #89  <Method void JButton.setMnemonic(char)>
                m_FilterButton.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e)
                    {
                        if(e.getSource() == m_FilterButton)
                    //*   0    0:aload_1         
                    //*   1    1:invokevirtual   #28  <Method Object ActionEvent.getSource()>
                    //*   2    4:aload_0         
                    //*   3    5:getfield        #13  <Field GenericObjectEditor$JTreePopupMenu this$1>
                    //*   4    8:invokestatic    #34  <Method JButton GenericObjectEditor$JTreePopupMenu.access$0(GenericObjectEditor$JTreePopupMenu)>
                    //*   5   11:if_acmpne       83
                        {
                            CapabilitiesFilterDialog dialog = new CapabilitiesFilterDialog();
                    //    6   14:new             #36  <Class GenericObjectEditor$CapabilitiesFilterDialog>
                    //    7   17:dup             
                    //    8   18:aload_0         
                    //    9   19:getfield        #13  <Field GenericObjectEditor$JTreePopupMenu this$1>
                    //   10   22:invokestatic    #40  <Method GenericObjectEditor GenericObjectEditor$JTreePopupMenu.access$4(GenericObjectEditor$JTreePopupMenu)>
                    //   11   25:invokespecial   #43  <Method void GenericObjectEditor$CapabilitiesFilterDialog(GenericObjectEditor)>
                    //   12   28:astore_2        
                            dialog.setCapabilities(m_CapabilitiesFilter);
                    //   13   29:aload_2         
                    //   14   30:aload_0         
                    //   15   31:getfield        #13  <Field GenericObjectEditor$JTreePopupMenu this$1>
                    //   16   34:invokestatic    #40  <Method GenericObjectEditor GenericObjectEditor$JTreePopupMenu.access$4(GenericObjectEditor$JTreePopupMenu)>
                    //   17   37:getfield        #49  <Field Capabilities GenericObjectEditor.m_CapabilitiesFilter>
                    //   18   40:invokevirtual   #53  <Method void GenericObjectEditor$CapabilitiesFilterDialog.setCapabilities(Capabilities)>
                            dialog.setPopup(m_Self);
                    //   19   43:aload_2         
                    //   20   44:aload_0         
                    //   21   45:getfield        #13  <Field GenericObjectEditor$JTreePopupMenu this$1>
                    //   22   48:invokestatic    #57  <Method JPopupMenu GenericObjectEditor$JTreePopupMenu.access$1(GenericObjectEditor$JTreePopupMenu)>
                    //   23   51:invokevirtual   #61  <Method void GenericObjectEditor$CapabilitiesFilterDialog.setPopup(JPopupMenu)>
                            dialog.setVisible(true);
                    //   24   54:aload_2         
                    //   25   55:iconst_1        
                    //   26   56:invokevirtual   #65  <Method void GenericObjectEditor$CapabilitiesFilterDialog.setVisible(boolean)>
                            m_Support.firePropertyChange("", null, null);
                    //   27   59:aload_0         
                    //   28   60:getfield        #13  <Field GenericObjectEditor$JTreePopupMenu this$1>
                    //   29   63:invokestatic    #40  <Method GenericObjectEditor GenericObjectEditor$JTreePopupMenu.access$4(GenericObjectEditor$JTreePopupMenu)>
                    //   30   66:getfield        #69  <Field PropertyChangeSupport GenericObjectEditor.m_Support>
                    //   31   69:ldc1            #71  <String "">
                    //   32   71:aconst_null     
                    //   33   72:aconst_null     
                    //   34   73:invokevirtual   #77  <Method void PropertyChangeSupport.firePropertyChange(String, Object, Object)>
                            repaint();
                    //   35   76:aload_0         
                    //   36   77:getfield        #13  <Field GenericObjectEditor$JTreePopupMenu this$1>
                    //   37   80:invokevirtual   #80  <Method void GenericObjectEditor$JTreePopupMenu.repaint()>
                        }
                    //   38   83:return          
                    }

                    final JTreePopupMenu this$1;

                
                {
                    this$1 = JTreePopupMenu.this;
                //    0    0:aload_0         
                //    1    1:aload_1         
                //    2    2:putfield        #13  <Field GenericObjectEditor$JTreePopupMenu this$1>
                    super();
                //    3    5:aload_0         
                //    4    6:invokespecial   #16  <Method void Object()>
                //    5    9:return          
                }
                }
);
        //   52  108:aload_0         
        //   53  109:getfield        #40  <Field JButton m_FilterButton>
        //   54  112:new             #91  <Class GenericObjectEditor$3>
        //   55  115:dup             
        //   56  116:aload_0         
        //   57  117:invokespecial   #94  <Method void GenericObjectEditor$3(GenericObjectEditor$JTreePopupMenu)>
        //   58  120:invokevirtual   #98  <Method void JButton.addActionListener(ActionListener)>
                panel.add(m_FilterButton);
        //   59  123:aload_3         
        //   60  124:aload_0         
        //   61  125:getfield        #40  <Field JButton m_FilterButton>
        //   62  128:invokevirtual   #101 <Method Component JPanel.add(Component)>
        //   63  131:pop             
                m_RemoveFilterButton.setMnemonic('R');
        //   64  132:aload_0         
        //   65  133:getfield        #44  <Field JButton m_RemoveFilterButton>
        //   66  136:bipush          82
        //   67  138:invokevirtual   #89  <Method void JButton.setMnemonic(char)>
                m_RemoveFilterButton.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e)
                    {
                        if(e.getSource() == m_RemoveFilterButton)
                    //*   0    0:aload_1         
                    //*   1    1:invokevirtual   #28  <Method Object ActionEvent.getSource()>
                    //*   2    4:aload_0         
                    //*   3    5:getfield        #13  <Field GenericObjectEditor$JTreePopupMenu this$1>
                    //*   4    8:invokestatic    #34  <Method JButton GenericObjectEditor$JTreePopupMenu.access$2(GenericObjectEditor$JTreePopupMenu)>
                    //*   5   11:if_acmpne       49
                        {
                            m_CapabilitiesFilter = null;
                    //    6   14:aload_0         
                    //    7   15:getfield        #13  <Field GenericObjectEditor$JTreePopupMenu this$1>
                    //    8   18:invokestatic    #38  <Method GenericObjectEditor GenericObjectEditor$JTreePopupMenu.access$4(GenericObjectEditor$JTreePopupMenu)>
                    //    9   21:aconst_null     
                    //   10   22:putfield        #44  <Field Capabilities GenericObjectEditor.m_CapabilitiesFilter>
                            m_Support.firePropertyChange("", null, null);
                    //   11   25:aload_0         
                    //   12   26:getfield        #13  <Field GenericObjectEditor$JTreePopupMenu this$1>
                    //   13   29:invokestatic    #38  <Method GenericObjectEditor GenericObjectEditor$JTreePopupMenu.access$4(GenericObjectEditor$JTreePopupMenu)>
                    //   14   32:getfield        #48  <Field PropertyChangeSupport GenericObjectEditor.m_Support>
                    //   15   35:ldc1            #50  <String "">
                    //   16   37:aconst_null     
                    //   17   38:aconst_null     
                    //   18   39:invokevirtual   #56  <Method void PropertyChangeSupport.firePropertyChange(String, Object, Object)>
                            repaint();
                    //   19   42:aload_0         
                    //   20   43:getfield        #13  <Field GenericObjectEditor$JTreePopupMenu this$1>
                    //   21   46:invokevirtual   #59  <Method void GenericObjectEditor$JTreePopupMenu.repaint()>
                        }
                    //   22   49:return          
                    }

                    final JTreePopupMenu this$1;

                
                {
                    this$1 = JTreePopupMenu.this;
                //    0    0:aload_0         
                //    1    1:aload_1         
                //    2    2:putfield        #13  <Field GenericObjectEditor$JTreePopupMenu this$1>
                    super();
                //    3    5:aload_0         
                //    4    6:invokespecial   #16  <Method void Object()>
                //    5    9:return          
                }
                }
);
        //   68  141:aload_0         
        //   69  142:getfield        #44  <Field JButton m_RemoveFilterButton>
        //   70  145:new             #103 <Class GenericObjectEditor$4>
        //   71  148:dup             
        //   72  149:aload_0         
        //   73  150:invokespecial   #104 <Method void GenericObjectEditor$4(GenericObjectEditor$JTreePopupMenu)>
        //   74  153:invokevirtual   #98  <Method void JButton.addActionListener(ActionListener)>
                panel.add(m_RemoveFilterButton);
        //   75  156:aload_3         
        //   76  157:aload_0         
        //   77  158:getfield        #44  <Field JButton m_RemoveFilterButton>
        //   78  161:invokevirtual   #101 <Method Component JPanel.add(Component)>
        //   79  164:pop             
            }
            m_CloseButton.setMnemonic('C');
        //   80  165:aload_0         
        //   81  166:getfield        #48  <Field JButton m_CloseButton>
        //   82  169:bipush          67
        //   83  171:invokevirtual   #89  <Method void JButton.setMnemonic(char)>
            m_CloseButton.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e)
                {
                    if(e.getSource() == m_CloseButton)
                //*   0    0:aload_1         
                //*   1    1:invokevirtual   #28  <Method Object ActionEvent.getSource()>
                //*   2    4:aload_0         
                //*   3    5:getfield        #13  <Field GenericObjectEditor$JTreePopupMenu this$1>
                //*   4    8:invokestatic    #34  <Method JButton GenericObjectEditor$JTreePopupMenu.access$3(GenericObjectEditor$JTreePopupMenu)>
                //*   5   11:if_acmpne       25
                        m_Self.setVisible(false);
                //    6   14:aload_0         
                //    7   15:getfield        #13  <Field GenericObjectEditor$JTreePopupMenu this$1>
                //    8   18:invokestatic    #38  <Method JPopupMenu GenericObjectEditor$JTreePopupMenu.access$1(GenericObjectEditor$JTreePopupMenu)>
                //    9   21:iconst_0        
                //   10   22:invokevirtual   #44  <Method void JPopupMenu.setVisible(boolean)>
                //   11   25:return          
                }

                final JTreePopupMenu this$1;

                
                {
                    this$1 = JTreePopupMenu.this;
                //    0    0:aload_0         
                //    1    1:aload_1         
                //    2    2:putfield        #13  <Field GenericObjectEditor$JTreePopupMenu this$1>
                    super();
                //    3    5:aload_0         
                //    4    6:invokespecial   #16  <Method void Object()>
                //    5    9:return          
                }
            }
);
        //   84  174:aload_0         
        //   85  175:getfield        #48  <Field JButton m_CloseButton>
        //   86  178:new             #106 <Class GenericObjectEditor$5>
        //   87  181:dup             
        //   88  182:aload_0         
        //   89  183:invokespecial   #107 <Method void GenericObjectEditor$5(GenericObjectEditor$JTreePopupMenu)>
        //   90  186:invokevirtual   #98  <Method void JButton.addActionListener(ActionListener)>
            panel.add(m_CloseButton);
        //   91  189:aload_3         
        //   92  190:aload_0         
        //   93  191:getfield        #48  <Field JButton m_CloseButton>
        //   94  194:invokevirtual   #101 <Method Component JPanel.add(Component)>
        //   95  197:pop             
            m_tree = tree;
        //   96  198:aload_0         
        //   97  199:aload_2         
        //   98  200:putfield        #109 <Field JTree m_tree>
            JPanel treeView = new JPanel();
        //   99  203:new             #59  <Class JPanel>
        //  100  206:dup             
        //  101  207:invokespecial   #110 <Method void JPanel()>
        //  102  210:astore          4
            treeView.setLayout(new BorderLayout());
        //  103  212:aload           4
        //  104  214:new             #52  <Class BorderLayout>
        //  105  217:dup             
        //  106  218:invokespecial   #53  <Method void BorderLayout()>
        //  107  221:invokevirtual   #111 <Method void JPanel.setLayout(java.awt.LayoutManager)>
            treeView.add(m_tree, "North");
        //  108  224:aload           4
        //  109  226:aload_0         
        //  110  227:getfield        #109 <Field JTree m_tree>
        //  111  230:ldc1            #113 <String "North">
        //  112  232:invokevirtual   #114 <Method void JPanel.add(Component, Object)>
            treeView.setBackground(m_tree.getBackground());
        //  113  235:aload           4
        //  114  237:aload_0         
        //  115  238:getfield        #109 <Field JTree m_tree>
        //  116  241:invokevirtual   #120 <Method java.awt.Color JTree.getBackground()>
        //  117  244:invokevirtual   #124 <Method void JPanel.setBackground(java.awt.Color)>
            m_scroller = new JScrollPane(treeView);
        //  118  247:aload_0         
        //  119  248:new             #126 <Class JScrollPane>
        //  120  251:dup             
        //  121  252:aload           4
        //  122  254:invokespecial   #129 <Method void JScrollPane(Component)>
        //  123  257:putfield        #131 <Field JScrollPane m_scroller>
            m_scroller.setPreferredSize(new Dimension(300, 400));
        //  124  260:aload_0         
        //  125  261:getfield        #131 <Field JScrollPane m_scroller>
        //  126  264:new             #133 <Class Dimension>
        //  127  267:dup             
        //  128  268:sipush          300
        //  129  271:sipush          400
        //  130  274:invokespecial   #136 <Method void Dimension(int, int)>
        //  131  277:invokevirtual   #140 <Method void JScrollPane.setPreferredSize(Dimension)>
            m_scroller.getVerticalScrollBar().setUnitIncrement(20);
        //  132  280:aload_0         
        //  133  281:getfield        #131 <Field JScrollPane m_scroller>
        //  134  284:invokevirtual   #144 <Method JScrollBar JScrollPane.getVerticalScrollBar()>
        //  135  287:bipush          20
        //  136  289:invokevirtual   #149 <Method void JScrollBar.setUnitIncrement(int)>
            add(m_scroller);
        //  137  292:aload_0         
        //  138  293:aload_0         
        //  139  294:getfield        #131 <Field JScrollPane m_scroller>
        //  140  297:invokevirtual   #150 <Method Component add(Component)>
        //  141  300:pop             
        //  142  301:return          
        }
    }

    public class GOEPanel extends JPanel
    {

        protected void setCancelButton(boolean flag)
        {
            if(m_cancelBut != null)
        //*   0    0:aload_0         
        //*   1    1:getfield        #119 <Field JButton m_cancelBut>
        //*   2    4:ifnull          15
                m_cancelBut.setEnabled(flag);
        //    3    7:aload_0         
        //    4    8:getfield        #119 <Field JButton m_cancelBut>
        //    5   11:iload_1         
        //    6   12:invokevirtual   #92  <Method void JButton.setEnabled(boolean)>
        //    7   15:return          
        }

        protected Object openObject()
        {
            if(m_FileChooser == null)
        //*   0    0:aload_0         
        //*   1    1:getfield        #192 <Field JFileChooser m_FileChooser>
        //*   2    4:ifnonnull       11
                createFileChooser();
        //    3    7:aload_0         
        //    4    8:invokevirtual   #195 <Method void createFileChooser()>
            int returnVal = m_FileChooser.showOpenDialog(this);
        //    5   11:aload_0         
        //    6   12:getfield        #192 <Field JFileChooser m_FileChooser>
        //    7   15:aload_0         
        //    8   16:invokevirtual   #201 <Method int JFileChooser.showOpenDialog(Component)>
        //    9   19:istore_1        
            if(returnVal == 0)
        //*  10   20:iload_1         
        //*  11   21:ifne            161
            {
                File selected = m_FileChooser.getSelectedFile();
        //   12   24:aload_0         
        //   13   25:getfield        #192 <Field JFileChooser m_FileChooser>
        //   14   28:invokevirtual   #205 <Method File JFileChooser.getSelectedFile()>
        //   15   31:astore_2        
                try
                {
                    ObjectInputStream oi = new ObjectInputStream(new BufferedInputStream(new FileInputStream(selected)));
        //   16   32:new             #207 <Class ObjectInputStream>
        //   17   35:dup             
        //   18   36:new             #209 <Class BufferedInputStream>
        //   19   39:dup             
        //   20   40:new             #211 <Class FileInputStream>
        //   21   43:dup             
        //   22   44:aload_2         
        //   23   45:invokespecial   #214 <Method void FileInputStream(File)>
        //   24   48:invokespecial   #217 <Method void BufferedInputStream(java.io.InputStream)>
        //   25   51:invokespecial   #218 <Method void ObjectInputStream(java.io.InputStream)>
        //   26   54:astore_3        
                    Object obj = oi.readObject();
        //   27   55:aload_3         
        //   28   56:invokevirtual   #221 <Method Object ObjectInputStream.readObject()>
        //   29   59:astore          4
                    oi.close();
        //   30   61:aload_3         
        //   31   62:invokevirtual   #224 <Method void ObjectInputStream.close()>
                    if(!m_ClassType.isAssignableFrom(obj.getClass()))
        //*  32   65:aload_0         
        //*  33   66:getfield        #27  <Field GenericObjectEditor this$0>
        //*  34   69:getfield        #164 <Field Class GenericObjectEditor.m_ClassType>
        //*  35   72:aload           4
        //*  36   74:invokevirtual   #230 <Method Class Object.getClass()>
        //*  37   77:invokevirtual   #236 <Method boolean Class.isAssignableFrom(Class)>
        //*  38   80:ifne            116
                        throw new Exception((new StringBuilder("Object not of type: ")).append(m_ClassType.getName()).toString());
        //   39   83:new             #238 <Class Exception>
        //   40   86:dup             
        //   41   87:new             #240 <Class StringBuilder>
        //   42   90:dup             
        //   43   91:ldc1            #242 <String "Object not of type: ">
        //   44   93:invokespecial   #243 <Method void StringBuilder(String)>
        //   45   96:aload_0         
        //   46   97:getfield        #27  <Field GenericObjectEditor this$0>
        //   47  100:getfield        #164 <Field Class GenericObjectEditor.m_ClassType>
        //   48  103:invokevirtual   #247 <Method String Class.getName()>
        //   49  106:invokevirtual   #251 <Method StringBuilder StringBuilder.append(String)>
        //   50  109:invokevirtual   #254 <Method String StringBuilder.toString()>
        //   51  112:invokespecial   #255 <Method void Exception(String)>
        //   52  115:athrow          
                    else
                        return obj;
        //   53  116:aload           4
        //   54  118:areturn         
                }
                catch(Exception ex)
        //*  55  119:astore_3        
                {
                    JOptionPane.showMessageDialog(this, (new StringBuilder("Couldn't read object: ")).append(selected.getName()).append("\n").append(ex.getMessage()).toString(), "Open object file", 0);
        //   56  120:aload_0         
        //   57  121:new             #240 <Class StringBuilder>
        //   58  124:dup             
        //   59  125:ldc2            #257 <String "Couldn't read object: ">
        //   60  128:invokespecial   #243 <Method void StringBuilder(String)>
        //   61  131:aload_2         
        //   62  132:invokevirtual   #260 <Method String File.getName()>
        //   63  135:invokevirtual   #251 <Method StringBuilder StringBuilder.append(String)>
        //   64  138:ldc2            #262 <String "\n">
        //   65  141:invokevirtual   #251 <Method StringBuilder StringBuilder.append(String)>
        //   66  144:aload_3         
        //   67  145:invokevirtual   #265 <Method String Exception.getMessage()>
        //   68  148:invokevirtual   #251 <Method StringBuilder StringBuilder.append(String)>
        //   69  151:invokevirtual   #254 <Method String StringBuilder.toString()>
        //   70  154:ldc2            #267 <String "Open object file">
        //   71  157:iconst_0        
        //   72  158:invokestatic    #273 <Method void JOptionPane.showMessageDialog(Component, Object, String, int)>
                }
            }
            return null;
        //   73  161:aconst_null     
        //   74  162:areturn         
        }

        protected void saveObject(Object object)
        {
            if(m_FileChooser == null)
        //*   0    0:aload_0         
        //*   1    1:getfield        #192 <Field JFileChooser m_FileChooser>
        //*   2    4:ifnonnull       11
                createFileChooser();
        //    3    7:aload_0         
        //    4    8:invokevirtual   #195 <Method void createFileChooser()>
            int returnVal = m_FileChooser.showSaveDialog(this);
        //    5   11:aload_0         
        //    6   12:getfield        #192 <Field JFileChooser m_FileChooser>
        //    7   15:aload_0         
        //    8   16:invokevirtual   #287 <Method int JFileChooser.showSaveDialog(Component)>
        //    9   19:istore_2        
            if(returnVal == 0)
        //*  10   20:iload_2         
        //*  11   21:ifne            114
            {
                File sFile = m_FileChooser.getSelectedFile();
        //   12   24:aload_0         
        //   13   25:getfield        #192 <Field JFileChooser m_FileChooser>
        //   14   28:invokevirtual   #205 <Method File JFileChooser.getSelectedFile()>
        //   15   31:astore_3        
                try
                {
                    ObjectOutputStream oo = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(sFile)));
        //   16   32:new             #289 <Class ObjectOutputStream>
        //   17   35:dup             
        //   18   36:new             #291 <Class BufferedOutputStream>
        //   19   39:dup             
        //   20   40:new             #293 <Class FileOutputStream>
        //   21   43:dup             
        //   22   44:aload_3         
        //   23   45:invokespecial   #294 <Method void FileOutputStream(File)>
        //   24   48:invokespecial   #297 <Method void BufferedOutputStream(java.io.OutputStream)>
        //   25   51:invokespecial   #298 <Method void ObjectOutputStream(java.io.OutputStream)>
        //   26   54:astore          4
                    oo.writeObject(object);
        //   27   56:aload           4
        //   28   58:aload_1         
        //   29   59:invokevirtual   #301 <Method void ObjectOutputStream.writeObject(Object)>
                    oo.close();
        //   30   62:aload           4
        //   31   64:invokevirtual   #302 <Method void ObjectOutputStream.close()>
                }
        //*  32   67:goto            114
                catch(Exception ex)
        //*  33   70:astore          4
                {
                    JOptionPane.showMessageDialog(this, (new StringBuilder("Couldn't write to file: ")).append(sFile.getName()).append("\n").append(ex.getMessage()).toString(), "Save object", 0);
        //   34   72:aload_0         
        //   35   73:new             #240 <Class StringBuilder>
        //   36   76:dup             
        //   37   77:ldc2            #304 <String "Couldn't write to file: ">
        //   38   80:invokespecial   #243 <Method void StringBuilder(String)>
        //   39   83:aload_3         
        //   40   84:invokevirtual   #260 <Method String File.getName()>
        //   41   87:invokevirtual   #251 <Method StringBuilder StringBuilder.append(String)>
        //   42   90:ldc2            #262 <String "\n">
        //   43   93:invokevirtual   #251 <Method StringBuilder StringBuilder.append(String)>
        //   44   96:aload           4
        //   45   98:invokevirtual   #265 <Method String Exception.getMessage()>
        //   46  101:invokevirtual   #251 <Method StringBuilder StringBuilder.append(String)>
        //   47  104:invokevirtual   #254 <Method String StringBuilder.toString()>
        //   48  107:ldc2            #306 <String "Save object">
        //   49  110:iconst_0        
        //   50  111:invokestatic    #273 <Method void JOptionPane.showMessageDialog(Component, Object, String, int)>
                }
            }
        //   51  114:return          
        }

        protected void createFileChooser()
        {
            m_FileChooser = new JFileChooser(new File(System.getProperty("user.dir")));
        //    0    0:aload_0         
        //    1    1:new             #197 <Class JFileChooser>
        //    2    4:dup             
        //    3    5:new             #259 <Class File>
        //    4    8:dup             
        //    5    9:ldc2            #312 <String "user.dir">
        //    6   12:invokestatic    #318 <Method String System.getProperty(String)>
        //    7   15:invokespecial   #319 <Method void File(String)>
        //    8   18:invokespecial   #320 <Method void JFileChooser(File)>
        //    9   21:putfield        #192 <Field JFileChooser m_FileChooser>
            m_FileChooser.setFileSelectionMode(0);
        //   10   24:aload_0         
        //   11   25:getfield        #192 <Field JFileChooser m_FileChooser>
        //   12   28:iconst_0        
        //   13   29:invokevirtual   #324 <Method void JFileChooser.setFileSelectionMode(int)>
        //   14   32:return          
        }

        protected Object copyObject(Object source)
        {
            Object result = null;
        //    0    0:aconst_null     
        //    1    1:astore_2        
            try
            {
                result = GenericObjectEditor.makeCopy(source);
        //    2    2:aload_1         
        //    3    3:invokestatic    #327 <Method Object GenericObjectEditor.makeCopy(Object)>
        //    4    6:astore_2        
                setCancelButton(true);
        //    5    7:aload_0         
        //    6    8:iconst_1        
        //    7    9:invokevirtual   #329 <Method void setCancelButton(boolean)>
            }
        //*   8   12:goto            37
            catch(Exception ex)
        //*   9   15:astore_3        
            {
                setCancelButton(false);
        //   10   16:aload_0         
        //   11   17:iconst_0        
        //   12   18:invokevirtual   #329 <Method void setCancelButton(boolean)>
                System.err.println("GenericObjectEditor: Problem making backup object");
        //   13   21:getstatic       #333 <Field PrintStream System.err>
        //   14   24:ldc2            #335 <String "GenericObjectEditor: Problem making backup object">
        //   15   27:invokevirtual   #340 <Method void PrintStream.println(String)>
                System.err.println(ex);
        //   16   30:getstatic       #333 <Field PrintStream System.err>
        //   17   33:aload_3         
        //   18   34:invokevirtual   #342 <Method void PrintStream.println(Object)>
            }
            return result;
        //   19   37:aload_2         
        //   20   38:areturn         
        }

        public void setOkButtonText(String newLabel)
        {
            m_okBut.setText(newLabel);
        //    0    0:aload_0         
        //    1    1:getfield        #112 <Field JButton m_okBut>
        //    2    4:aload_1         
        //    3    5:invokevirtual   #348 <Method void JButton.setText(String)>
        //    4    8:return          
        }

        public void addOkListener(ActionListener a)
        {
            m_okBut.addActionListener(a);
        //    0    0:aload_0         
        //    1    1:getfield        #112 <Field JButton m_okBut>
        //    2    4:aload_1         
        //    3    5:invokevirtual   #99  <Method void JButton.addActionListener(ActionListener)>
        //    4    8:return          
        }

        public void addCancelListener(ActionListener a)
        {
            m_cancelBut.addActionListener(a);
        //    0    0:aload_0         
        //    1    1:getfield        #119 <Field JButton m_cancelBut>
        //    2    4:aload_1         
        //    3    5:invokevirtual   #99  <Method void JButton.addActionListener(ActionListener)>
        //    4    8:return          
        }

        public void removeOkListener(ActionListener a)
        {
            m_okBut.removeActionListener(a);
        //    0    0:aload_0         
        //    1    1:getfield        #112 <Field JButton m_okBut>
        //    2    4:aload_1         
        //    3    5:invokevirtual   #358 <Method void JButton.removeActionListener(ActionListener)>
        //    4    8:return          
        }

        public void removeCancelListener(ActionListener a)
        {
            m_cancelBut.removeActionListener(a);
        //    0    0:aload_0         
        //    1    1:getfield        #119 <Field JButton m_cancelBut>
        //    2    4:aload_1         
        //    3    5:invokevirtual   #358 <Method void JButton.removeActionListener(ActionListener)>
        //    4    8:return          
        }

        public void updateChildPropertySheet()
        {
            String className = "None";
        //    0    0:ldc1            #47  <String "None">
        //    1    2:astore_1        
            if(m_Object != null)
        //*   2    3:aload_0         
        //*   3    4:getfield        #27  <Field GenericObjectEditor this$0>
        //*   4    7:getfield        #36  <Field Object GenericObjectEditor.m_Object>
        //*   5   10:ifnull          27
                className = m_Object.getClass().getName();
        //    6   13:aload_0         
        //    7   14:getfield        #27  <Field GenericObjectEditor this$0>
        //    8   17:getfield        #36  <Field Object GenericObjectEditor.m_Object>
        //    9   20:invokevirtual   #230 <Method Class Object.getClass()>
        //   10   23:invokevirtual   #247 <Method String Class.getName()>
        //   11   26:astore_1        
            m_ClassNameLabel.setText(className);
        //   12   27:aload_0         
        //   13   28:getfield        #52  <Field JLabel m_ClassNameLabel>
        //   14   31:aload_1         
        //   15   32:invokevirtual   #360 <Method void JLabel.setText(String)>
            m_ChildPropertySheet.setTarget(m_Object);
        //   16   35:aload_0         
        //   17   36:getfield        #67  <Field PropertySheetPanel m_ChildPropertySheet>
        //   18   39:aload_0         
        //   19   40:getfield        #27  <Field GenericObjectEditor this$0>
        //   20   43:getfield        #36  <Field Object GenericObjectEditor.m_Object>
        //   21   46:invokevirtual   #363 <Method void PropertySheetPanel.setTarget(Object)>
            if(getTopLevelAncestor() != null && (getTopLevelAncestor() instanceof Window))
        //*  22   49:aload_0         
        //*  23   50:invokevirtual   #367 <Method Container getTopLevelAncestor()>
        //*  24   53:ifnull          76
        //*  25   56:aload_0         
        //*  26   57:invokevirtual   #367 <Method Container getTopLevelAncestor()>
        //*  27   60:instanceof      #369 <Class Window>
        //*  28   63:ifeq            76
                ((Window)getTopLevelAncestor()).pack();
        //   29   66:aload_0         
        //   30   67:invokevirtual   #367 <Method Container getTopLevelAncestor()>
        //   31   70:checkcast       #369 <Class Window>
        //   32   73:invokevirtual   #372 <Method void Window.pack()>
        //   33   76:return          
        }

        static final long serialVersionUID = 0x32bcd291bb82ef47L;
        protected PropertySheetPanel m_ChildPropertySheet;
        protected JLabel m_ClassNameLabel;
        protected JButton m_OpenBut;
        protected JButton m_SaveBut;
        protected JButton m_okBut;
        protected JButton m_cancelBut;
        protected JFileChooser m_FileChooser;
        final GenericObjectEditor this$0;


/*
        static GenericObjectEditor access$0(GOEPanel goepanel)
        {
            return goepanel.this$0;
        //    0    0:aload_0         
        //    1    1:getfield        #27  <Field GenericObjectEditor this$0>
        //    2    4:areturn         
        }

*/

        public GOEPanel()
        {
            this$0 = GenericObjectEditor.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #27  <Field GenericObjectEditor this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #30  <Method void JPanel()>
            m_Backup = copyObject(m_Object);
        //    5    9:aload_1         
        //    6   10:aload_0         
        //    7   11:aload_1         
        //    8   12:getfield        #36  <Field Object GenericObjectEditor.m_Object>
        //    9   15:invokevirtual   #40  <Method Object copyObject(Object)>
        //   10   18:putfield        #43  <Field Object GenericObjectEditor.m_Backup>
            m_ClassNameLabel = new JLabel("None");
        //   11   21:aload_0         
        //   12   22:new             #45  <Class JLabel>
        //   13   25:dup             
        //   14   26:ldc1            #47  <String "None">
        //   15   28:invokespecial   #50  <Method void JLabel(String)>
        //   16   31:putfield        #52  <Field JLabel m_ClassNameLabel>
            m_ClassNameLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        //   17   34:aload_0         
        //   18   35:getfield        #52  <Field JLabel m_ClassNameLabel>
        //   19   38:iconst_5        
        //   20   39:iconst_5        
        //   21   40:iconst_5        
        //   22   41:iconst_5        
        //   23   42:invokestatic    #58  <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
        //   24   45:invokevirtual   #62  <Method void JLabel.setBorder(javax.swing.border.Border)>
            m_ChildPropertySheet = new PropertySheetPanel();
        //   25   48:aload_0         
        //   26   49:new             #64  <Class PropertySheetPanel>
        //   27   52:dup             
        //   28   53:invokespecial   #65  <Method void PropertySheetPanel()>
        //   29   56:putfield        #67  <Field PropertySheetPanel m_ChildPropertySheet>
            m_ChildPropertySheet.addPropertyChangeListener(new PropertyChangeListener() {

                public void propertyChange(PropertyChangeEvent evt)
                {
                    m_Support.firePropertyChange("", null, null);
                //    0    0:aload_0         
                //    1    1:getfield        #13  <Field GenericObjectEditor$GOEPanel this$1>
                //    2    4:invokestatic    #28  <Method GenericObjectEditor GenericObjectEditor$GOEPanel.access$0(GenericObjectEditor$GOEPanel)>
                //    3    7:getfield        #34  <Field PropertyChangeSupport GenericObjectEditor.m_Support>
                //    4   10:ldc1            #36  <String "">
                //    5   12:aconst_null     
                //    6   13:aconst_null     
                //    7   14:invokevirtual   #42  <Method void PropertyChangeSupport.firePropertyChange(String, Object, Object)>
                //    8   17:return          
                }

                final GOEPanel this$1;

                
                {
                    this$1 = GOEPanel.this;
                //    0    0:aload_0         
                //    1    1:aload_1         
                //    2    2:putfield        #13  <Field GenericObjectEditor$GOEPanel this$1>
                    super();
                //    3    5:aload_0         
                //    4    6:invokespecial   #16  <Method void Object()>
                //    5    9:return          
                }
            }
);
        //   30   59:aload_0         
        //   31   60:getfield        #67  <Field PropertySheetPanel m_ChildPropertySheet>
        //   32   63:new             #69  <Class GenericObjectEditor$6>
        //   33   66:dup             
        //   34   67:aload_0         
        //   35   68:invokespecial   #72  <Method void GenericObjectEditor$6(GenericObjectEditor$GOEPanel)>
        //   36   71:invokevirtual   #76  <Method void PropertySheetPanel.addPropertyChangeListener(PropertyChangeListener)>
            m_OpenBut = new JButton("Open...");
        //   37   74:aload_0         
        //   38   75:new             #78  <Class JButton>
        //   39   78:dup             
        //   40   79:ldc1            #80  <String "Open...">
        //   41   81:invokespecial   #81  <Method void JButton(String)>
        //   42   84:putfield        #83  <Field JButton m_OpenBut>
            m_OpenBut.setToolTipText("Load a configured object");
        //   43   87:aload_0         
        //   44   88:getfield        #83  <Field JButton m_OpenBut>
        //   45   91:ldc1            #85  <String "Load a configured object">
        //   46   93:invokevirtual   #88  <Method void JButton.setToolTipText(String)>
            m_OpenBut.setEnabled(true);
        //   47   96:aload_0         
        //   48   97:getfield        #83  <Field JButton m_OpenBut>
        //   49  100:iconst_1        
        //   50  101:invokevirtual   #92  <Method void JButton.setEnabled(boolean)>
            m_OpenBut.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e)
                {
                    Object object = openObject();
                //    0    0:aload_0         
                //    1    1:getfield        #13  <Field GenericObjectEditor$GOEPanel this$1>
                //    2    4:invokevirtual   #28  <Method Object GenericObjectEditor$GOEPanel.openObject()>
                //    3    7:astore_2        
                    if(object != null)
                //*   4    8:aload_2         
                //*   5    9:ifnull          34
                    {
                        setValue(object);
                //    6   12:aload_0         
                //    7   13:getfield        #13  <Field GenericObjectEditor$GOEPanel this$1>
                //    8   16:invokestatic    #32  <Method GenericObjectEditor GenericObjectEditor$GOEPanel.access$0(GenericObjectEditor$GOEPanel)>
                //    9   19:aload_2         
                //   10   20:invokevirtual   #38  <Method void GenericObjectEditor.setValue(Object)>
                        setValue(object);
                //   11   23:aload_0         
                //   12   24:getfield        #13  <Field GenericObjectEditor$GOEPanel this$1>
                //   13   27:invokestatic    #32  <Method GenericObjectEditor GenericObjectEditor$GOEPanel.access$0(GenericObjectEditor$GOEPanel)>
                //   14   30:aload_2         
                //   15   31:invokevirtual   #38  <Method void GenericObjectEditor.setValue(Object)>
                    }
                //   16   34:return          
                }

                final GOEPanel this$1;

                
                {
                    this$1 = GOEPanel.this;
                //    0    0:aload_0         
                //    1    1:aload_1         
                //    2    2:putfield        #13  <Field GenericObjectEditor$GOEPanel this$1>
                    super();
                //    3    5:aload_0         
                //    4    6:invokespecial   #16  <Method void Object()>
                //    5    9:return          
                }
            }
);
        //   51  104:aload_0         
        //   52  105:getfield        #83  <Field JButton m_OpenBut>
        //   53  108:new             #94  <Class GenericObjectEditor$7>
        //   54  111:dup             
        //   55  112:aload_0         
        //   56  113:invokespecial   #95  <Method void GenericObjectEditor$7(GenericObjectEditor$GOEPanel)>
        //   57  116:invokevirtual   #99  <Method void JButton.addActionListener(ActionListener)>
            m_SaveBut = new JButton("Save...");
        //   58  119:aload_0         
        //   59  120:new             #78  <Class JButton>
        //   60  123:dup             
        //   61  124:ldc1            #101 <String "Save...">
        //   62  126:invokespecial   #81  <Method void JButton(String)>
        //   63  129:putfield        #103 <Field JButton m_SaveBut>
            m_SaveBut.setToolTipText("Save the current configured object");
        //   64  132:aload_0         
        //   65  133:getfield        #103 <Field JButton m_SaveBut>
        //   66  136:ldc1            #105 <String "Save the current configured object">
        //   67  138:invokevirtual   #88  <Method void JButton.setToolTipText(String)>
            m_SaveBut.setEnabled(true);
        //   68  141:aload_0         
        //   69  142:getfield        #103 <Field JButton m_SaveBut>
        //   70  145:iconst_1        
        //   71  146:invokevirtual   #92  <Method void JButton.setEnabled(boolean)>
            m_SaveBut.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e)
                {
                    saveObject(m_Object);
                //    0    0:aload_0         
                //    1    1:getfield        #13  <Field GenericObjectEditor$GOEPanel this$1>
                //    2    4:aload_0         
                //    3    5:getfield        #13  <Field GenericObjectEditor$GOEPanel this$1>
                //    4    8:invokestatic    #28  <Method GenericObjectEditor GenericObjectEditor$GOEPanel.access$0(GenericObjectEditor$GOEPanel)>
                //    5   11:getfield        #34  <Field Object GenericObjectEditor.m_Object>
                //    6   14:invokevirtual   #38  <Method void GenericObjectEditor$GOEPanel.saveObject(Object)>
                //    7   17:return          
                }

                final GOEPanel this$1;

                
                {
                    this$1 = GOEPanel.this;
                //    0    0:aload_0         
                //    1    1:aload_1         
                //    2    2:putfield        #13  <Field GenericObjectEditor$GOEPanel this$1>
                    super();
                //    3    5:aload_0         
                //    4    6:invokespecial   #16  <Method void Object()>
                //    5    9:return          
                }
            }
);
        //   72  149:aload_0         
        //   73  150:getfield        #103 <Field JButton m_SaveBut>
        //   74  153:new             #107 <Class GenericObjectEditor$8>
        //   75  156:dup             
        //   76  157:aload_0         
        //   77  158:invokespecial   #108 <Method void GenericObjectEditor$8(GenericObjectEditor$GOEPanel)>
        //   78  161:invokevirtual   #99  <Method void JButton.addActionListener(ActionListener)>
            m_okBut = new JButton("OK");
        //   79  164:aload_0         
        //   80  165:new             #78  <Class JButton>
        //   81  168:dup             
        //   82  169:ldc1            #110 <String "OK">
        //   83  171:invokespecial   #81  <Method void JButton(String)>
        //   84  174:putfield        #112 <Field JButton m_okBut>
            m_okBut.setEnabled(true);
        //   85  177:aload_0         
        //   86  178:getfield        #112 <Field JButton m_okBut>
        //   87  181:iconst_1        
        //   88  182:invokevirtual   #92  <Method void JButton.setEnabled(boolean)>
            m_okBut.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e)
                {
                    m_Backup = copyObject(m_Object);
                //    0    0:aload_0         
                //    1    1:getfield        #13  <Field GenericObjectEditor$GOEPanel this$1>
                //    2    4:invokestatic    #28  <Method GenericObjectEditor GenericObjectEditor$GOEPanel.access$0(GenericObjectEditor$GOEPanel)>
                //    3    7:aload_0         
                //    4    8:getfield        #13  <Field GenericObjectEditor$GOEPanel this$1>
                //    5   11:aload_0         
                //    6   12:getfield        #13  <Field GenericObjectEditor$GOEPanel this$1>
                //    7   15:invokestatic    #28  <Method GenericObjectEditor GenericObjectEditor$GOEPanel.access$0(GenericObjectEditor$GOEPanel)>
                //    8   18:getfield        #34  <Field Object GenericObjectEditor.m_Object>
                //    9   21:invokevirtual   #38  <Method Object GenericObjectEditor$GOEPanel.copyObject(Object)>
                //   10   24:putfield        #41  <Field Object GenericObjectEditor.m_Backup>
                    if(getTopLevelAncestor() != null && (getTopLevelAncestor() instanceof Window))
                //*  11   27:aload_0         
                //*  12   28:getfield        #13  <Field GenericObjectEditor$GOEPanel this$1>
                //*  13   31:invokevirtual   #45  <Method Container GenericObjectEditor$GOEPanel.getTopLevelAncestor()>
                //*  14   34:ifnull          65
                //*  15   37:aload_0         
                //*  16   38:getfield        #13  <Field GenericObjectEditor$GOEPanel this$1>
                //*  17   41:invokevirtual   #45  <Method Container GenericObjectEditor$GOEPanel.getTopLevelAncestor()>
                //*  18   44:instanceof      #47  <Class Window>
                //*  19   47:ifeq            65
                    {
                        Window w = (Window)getTopLevelAncestor();
                //   20   50:aload_0         
                //   21   51:getfield        #13  <Field GenericObjectEditor$GOEPanel this$1>
                //   22   54:invokevirtual   #45  <Method Container GenericObjectEditor$GOEPanel.getTopLevelAncestor()>
                //   23   57:checkcast       #47  <Class Window>
                //   24   60:astore_2        
                        w.dispose();
                //   25   61:aload_2         
                //   26   62:invokevirtual   #50  <Method void Window.dispose()>
                    }
                //   27   65:return          
                }

                final GOEPanel this$1;

                
                {
                    this$1 = GOEPanel.this;
                //    0    0:aload_0         
                //    1    1:aload_1         
                //    2    2:putfield        #13  <Field GenericObjectEditor$GOEPanel this$1>
                    super();
                //    3    5:aload_0         
                //    4    6:invokespecial   #16  <Method void Object()>
                //    5    9:return          
                }
            }
);
        //   89  185:aload_0         
        //   90  186:getfield        #112 <Field JButton m_okBut>
        //   91  189:new             #114 <Class GenericObjectEditor$9>
        //   92  192:dup             
        //   93  193:aload_0         
        //   94  194:invokespecial   #115 <Method void GenericObjectEditor$9(GenericObjectEditor$GOEPanel)>
        //   95  197:invokevirtual   #99  <Method void JButton.addActionListener(ActionListener)>
            m_cancelBut = new JButton("Cancel");
        //   96  200:aload_0         
        //   97  201:new             #78  <Class JButton>
        //   98  204:dup             
        //   99  205:ldc1            #117 <String "Cancel">
        //  100  207:invokespecial   #81  <Method void JButton(String)>
        //  101  210:putfield        #119 <Field JButton m_cancelBut>
            m_cancelBut.setEnabled(true);
        //  102  213:aload_0         
        //  103  214:getfield        #119 <Field JButton m_cancelBut>
        //  104  217:iconst_1        
        //  105  218:invokevirtual   #92  <Method void JButton.setEnabled(boolean)>
            m_cancelBut.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e)
                {
                    if(m_Backup != null)
                //*   0    0:aload_0         
                //*   1    1:getfield        #13  <Field GenericObjectEditor$GOEPanel this$1>
                //*   2    4:invokestatic    #28  <Method GenericObjectEditor GenericObjectEditor$GOEPanel.access$0(GenericObjectEditor$GOEPanel)>
                //*   3    7:getfield        #34  <Field Object GenericObjectEditor.m_Backup>
                //*   4   10:ifnull          94
                    {
                        m_Object = copyObject(m_Backup);
                //    5   13:aload_0         
                //    6   14:getfield        #13  <Field GenericObjectEditor$GOEPanel this$1>
                //    7   17:invokestatic    #28  <Method GenericObjectEditor GenericObjectEditor$GOEPanel.access$0(GenericObjectEditor$GOEPanel)>
                //    8   20:aload_0         
                //    9   21:getfield        #13  <Field GenericObjectEditor$GOEPanel this$1>
                //   10   24:aload_0         
                //   11   25:getfield        #13  <Field GenericObjectEditor$GOEPanel this$1>
                //   12   28:invokestatic    #28  <Method GenericObjectEditor GenericObjectEditor$GOEPanel.access$0(GenericObjectEditor$GOEPanel)>
                //   13   31:getfield        #34  <Field Object GenericObjectEditor.m_Backup>
                //   14   34:invokevirtual   #38  <Method Object GenericObjectEditor$GOEPanel.copyObject(Object)>
                //   15   37:putfield        #41  <Field Object GenericObjectEditor.m_Object>
                        m_Support.firePropertyChange("", null, null);
                //   16   40:aload_0         
                //   17   41:getfield        #13  <Field GenericObjectEditor$GOEPanel this$1>
                //   18   44:invokestatic    #28  <Method GenericObjectEditor GenericObjectEditor$GOEPanel.access$0(GenericObjectEditor$GOEPanel)>
                //   19   47:getfield        #45  <Field PropertyChangeSupport GenericObjectEditor.m_Support>
                //   20   50:ldc1            #47  <String "">
                //   21   52:aconst_null     
                //   22   53:aconst_null     
                //   23   54:invokevirtual   #53  <Method void PropertyChangeSupport.firePropertyChange(String, Object, Object)>
                        m_ObjectNames = getClassesFromProperties();
                //   24   57:aload_0         
                //   25   58:getfield        #13  <Field GenericObjectEditor$GOEPanel this$1>
                //   26   61:invokestatic    #28  <Method GenericObjectEditor GenericObjectEditor$GOEPanel.access$0(GenericObjectEditor$GOEPanel)>
                //   27   64:aload_0         
                //   28   65:getfield        #13  <Field GenericObjectEditor$GOEPanel this$1>
                //   29   68:invokestatic    #28  <Method GenericObjectEditor GenericObjectEditor$GOEPanel.access$0(GenericObjectEditor$GOEPanel)>
                //   30   71:invokevirtual   #57  <Method Hashtable GenericObjectEditor.getClassesFromProperties()>
                //   31   74:putfield        #61  <Field Hashtable GenericObjectEditor.m_ObjectNames>
                        updateObjectNames();
                //   32   77:aload_0         
                //   33   78:getfield        #13  <Field GenericObjectEditor$GOEPanel this$1>
                //   34   81:invokestatic    #28  <Method GenericObjectEditor GenericObjectEditor$GOEPanel.access$0(GenericObjectEditor$GOEPanel)>
                //   35   84:invokevirtual   #64  <Method void GenericObjectEditor.updateObjectNames()>
                        updateChildPropertySheet();
                //   36   87:aload_0         
                //   37   88:getfield        #13  <Field GenericObjectEditor$GOEPanel this$1>
                //   38   91:invokevirtual   #67  <Method void GenericObjectEditor$GOEPanel.updateChildPropertySheet()>
                    }
                    if(getTopLevelAncestor() != null && (getTopLevelAncestor() instanceof Window))
                //*  39   94:aload_0         
                //*  40   95:getfield        #13  <Field GenericObjectEditor$GOEPanel this$1>
                //*  41   98:invokevirtual   #71  <Method Container GenericObjectEditor$GOEPanel.getTopLevelAncestor()>
                //*  42  101:ifnull          132
                //*  43  104:aload_0         
                //*  44  105:getfield        #13  <Field GenericObjectEditor$GOEPanel this$1>
                //*  45  108:invokevirtual   #71  <Method Container GenericObjectEditor$GOEPanel.getTopLevelAncestor()>
                //*  46  111:instanceof      #73  <Class Window>
                //*  47  114:ifeq            132
                    {
                        Window w = (Window)getTopLevelAncestor();
                //   48  117:aload_0         
                //   49  118:getfield        #13  <Field GenericObjectEditor$GOEPanel this$1>
                //   50  121:invokevirtual   #71  <Method Container GenericObjectEditor$GOEPanel.getTopLevelAncestor()>
                //   51  124:checkcast       #73  <Class Window>
                //   52  127:astore_2        
                        w.dispose();
                //   53  128:aload_2         
                //   54  129:invokevirtual   #76  <Method void Window.dispose()>
                    }
                //   55  132:return          
                }

                final GOEPanel this$1;

                
                {
                    this$1 = GOEPanel.this;
                //    0    0:aload_0         
                //    1    1:aload_1         
                //    2    2:putfield        #13  <Field GenericObjectEditor$GOEPanel this$1>
                    super();
                //    3    5:aload_0         
                //    4    6:invokespecial   #16  <Method void Object()>
                //    5    9:return          
                }
            }
);
        //  106  221:aload_0         
        //  107  222:getfield        #119 <Field JButton m_cancelBut>
        //  108  225:new             #121 <Class GenericObjectEditor$10>
        //  109  228:dup             
        //  110  229:aload_0         
        //  111  230:invokespecial   #122 <Method void GenericObjectEditor$10(GenericObjectEditor$GOEPanel)>
        //  112  233:invokevirtual   #99  <Method void JButton.addActionListener(ActionListener)>
            setLayout(new BorderLayout());
        //  113  236:aload_0         
        //  114  237:new             #124 <Class BorderLayout>
        //  115  240:dup             
        //  116  241:invokespecial   #125 <Method void BorderLayout()>
        //  117  244:invokevirtual   #129 <Method void setLayout(java.awt.LayoutManager)>
            if(m_canChangeClassInDialog)
        //* 118  247:aload_1         
        //* 119  248:getfield        #133 <Field boolean GenericObjectEditor.m_canChangeClassInDialog>
        //* 120  251:ifeq            316
            {
                JButton chooseButton = createChooseClassButton();
        //  121  254:aload_1         
        //  122  255:invokevirtual   #137 <Method JButton GenericObjectEditor.createChooseClassButton()>
        //  123  258:astore_2        
                JPanel top = new JPanel();
        //  124  259:new             #4   <Class JPanel>
        //  125  262:dup             
        //  126  263:invokespecial   #30  <Method void JPanel()>
        //  127  266:astore_3        
                top.setLayout(new BorderLayout());
        //  128  267:aload_3         
        //  129  268:new             #124 <Class BorderLayout>
        //  130  271:dup             
        //  131  272:invokespecial   #125 <Method void BorderLayout()>
        //  132  275:invokevirtual   #138 <Method void JPanel.setLayout(java.awt.LayoutManager)>
                top.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        //  133  278:aload_3         
        //  134  279:iconst_5        
        //  135  280:iconst_5        
        //  136  281:iconst_5        
        //  137  282:iconst_5        
        //  138  283:invokestatic    #58  <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
        //  139  286:invokevirtual   #139 <Method void JPanel.setBorder(javax.swing.border.Border)>
                top.add(chooseButton, "West");
        //  140  289:aload_3         
        //  141  290:aload_2         
        //  142  291:ldc1            #141 <String "West">
        //  143  293:invokevirtual   #145 <Method void JPanel.add(Component, Object)>
                top.add(m_ClassNameLabel, "Center");
        //  144  296:aload_3         
        //  145  297:aload_0         
        //  146  298:getfield        #52  <Field JLabel m_ClassNameLabel>
        //  147  301:ldc1            #147 <String "Center">
        //  148  303:invokevirtual   #145 <Method void JPanel.add(Component, Object)>
                add(top, "North");
        //  149  306:aload_0         
        //  150  307:aload_3         
        //  151  308:ldc1            #149 <String "North">
        //  152  310:invokevirtual   #150 <Method void add(Component, Object)>
            } else
        //* 153  313:goto            326
            {
                add(m_ClassNameLabel, "North");
        //  154  316:aload_0         
        //  155  317:aload_0         
        //  156  318:getfield        #52  <Field JLabel m_ClassNameLabel>
        //  157  321:ldc1            #149 <String "North">
        //  158  323:invokevirtual   #150 <Method void add(Component, Object)>
            }
            add(m_ChildPropertySheet, "Center");
        //  159  326:aload_0         
        //  160  327:aload_0         
        //  161  328:getfield        #67  <Field PropertySheetPanel m_ChildPropertySheet>
        //  162  331:ldc1            #147 <String "Center">
        //  163  333:invokevirtual   #150 <Method void add(Component, Object)>
            JPanel okcButs = new JPanel();
        //  164  336:new             #4   <Class JPanel>
        //  165  339:dup             
        //  166  340:invokespecial   #30  <Method void JPanel()>
        //  167  343:astore_2        
            okcButs.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        //  168  344:aload_2         
        //  169  345:iconst_5        
        //  170  346:iconst_5        
        //  171  347:iconst_5        
        //  172  348:iconst_5        
        //  173  349:invokestatic    #58  <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
        //  174  352:invokevirtual   #139 <Method void JPanel.setBorder(javax.swing.border.Border)>
            okcButs.setLayout(new GridLayout(1, 4, 5, 5));
        //  175  355:aload_2         
        //  176  356:new             #152 <Class GridLayout>
        //  177  359:dup             
        //  178  360:iconst_1        
        //  179  361:iconst_4        
        //  180  362:iconst_5        
        //  181  363:iconst_5        
        //  182  364:invokespecial   #155 <Method void GridLayout(int, int, int, int)>
        //  183  367:invokevirtual   #138 <Method void JPanel.setLayout(java.awt.LayoutManager)>
            okcButs.add(m_OpenBut);
        //  184  370:aload_2         
        //  185  371:aload_0         
        //  186  372:getfield        #83  <Field JButton m_OpenBut>
        //  187  375:invokevirtual   #158 <Method Component JPanel.add(Component)>
        //  188  378:pop             
            okcButs.add(m_SaveBut);
        //  189  379:aload_2         
        //  190  380:aload_0         
        //  191  381:getfield        #103 <Field JButton m_SaveBut>
        //  192  384:invokevirtual   #158 <Method Component JPanel.add(Component)>
        //  193  387:pop             
            okcButs.add(m_okBut);
        //  194  388:aload_2         
        //  195  389:aload_0         
        //  196  390:getfield        #112 <Field JButton m_okBut>
        //  197  393:invokevirtual   #158 <Method Component JPanel.add(Component)>
        //  198  396:pop             
            okcButs.add(m_cancelBut);
        //  199  397:aload_2         
        //  200  398:aload_0         
        //  201  399:getfield        #119 <Field JButton m_cancelBut>
        //  202  402:invokevirtual   #158 <Method Component JPanel.add(Component)>
        //  203  405:pop             
            add(okcButs, "South");
        //  204  406:aload_0         
        //  205  407:aload_2         
        //  206  408:ldc1            #160 <String "South">
        //  207  410:invokevirtual   #150 <Method void add(Component, Object)>
            if(m_ClassType != null)
        //* 208  413:aload_1         
        //* 209  414:getfield        #164 <Field Class GenericObjectEditor.m_ClassType>
        //* 210  417:ifnull          443
            {
                m_ObjectNames = getClassesFromProperties();
        //  211  420:aload_1         
        //  212  421:aload_1         
        //  213  422:invokevirtual   #168 <Method Hashtable GenericObjectEditor.getClassesFromProperties()>
        //  214  425:putfield        #172 <Field Hashtable GenericObjectEditor.m_ObjectNames>
                if(m_Object != null)
        //* 215  428:aload_1         
        //* 216  429:getfield        #36  <Field Object GenericObjectEditor.m_Object>
        //* 217  432:ifnull          443
                {
                    updateObjectNames();
        //  218  435:aload_1         
        //  219  436:invokevirtual   #175 <Method void GenericObjectEditor.updateObjectNames()>
                    updateChildPropertySheet();
        //  220  439:aload_0         
        //  221  440:invokevirtual   #178 <Method void updateChildPropertySheet()>
                }
            }
        //  222  443:return          
        }
    }


    public GenericObjectEditor()
    {
        this(false);
    //    0    0:aload_0         
    //    1    1:iconst_0        
    //    2    2:invokespecial   #146 <Method void GenericObjectEditor(boolean)>
    //    3    5:return          
    }

    public GenericObjectEditor(boolean canChangeClassInDialog)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #149 <Method void Object()>
        m_Support = new PropertyChangeSupport(this);
    //    2    4:aload_0         
    //    3    5:new             #151 <Class PropertyChangeSupport>
    //    4    8:dup             
    //    5    9:aload_0         
    //    6   10:invokespecial   #154 <Method void PropertyChangeSupport(Object)>
    //    7   13:putfield        #156 <Field PropertyChangeSupport m_Support>
        m_Enabled = true;
    //    8   16:aload_0         
    //    9   17:iconst_1        
    //   10   18:putfield        #158 <Field boolean m_Enabled>
        m_CapabilitiesFilter = null;
    //   11   21:aload_0         
    //   12   22:aconst_null     
    //   13   23:putfield        #160 <Field Capabilities m_CapabilitiesFilter>
        m_canChangeClassInDialog = canChangeClassInDialog;
    //   14   26:aload_0         
    //   15   27:iload_1         
    //   16   28:putfield        #162 <Field boolean m_canChangeClassInDialog>
    //   17   31:return          
    }

    public static void registerEditors()
    {
        if(m_EditorsRegistered)
    //*   0    0:getstatic       #166 <Field boolean m_EditorsRegistered>
    //*   1    3:ifeq            7
            return;
    //    2    6:return          
        System.err.println("---Registering RMiner Editors---");
    //    3    7:getstatic       #170 <Field PrintStream System.err>
    //    4   10:ldc1            #172 <String "---Registering RMiner Editors---">
    //    5   12:invokevirtual   #177 <Method void PrintStream.println(String)>
        m_EditorsRegistered = true;
    //    6   15:iconst_1        
    //    7   16:putstatic       #166 <Field boolean m_EditorsRegistered>
        Properties props;
        try
        {
            props = Utils.readProperties("rm/gui/GUIEditors.props");
    //    8   19:ldc1            #29  <String "rm/gui/GUIEditors.props">
    //    9   21:invokestatic    #96  <Method Properties Utils.readProperties(String)>
    //   10   24:astore_0        
        }
    //*  11   25:goto            43
        catch(Exception e)
    //*  12   28:astore          6
        {
            props = new Properties();
    //   13   30:new             #98  <Class Properties>
    //   14   33:dup             
    //   15   34:invokespecial   #178 <Method void Properties()>
    //   16   37:astore_0        
            e.printStackTrace();
    //   17   38:aload           6
    //   18   40:invokevirtual   #181 <Method void Exception.printStackTrace()>
        }
        for(Enumeration enm = props.propertyNames(); enm.hasMoreElements();)
    //*  19   43:aload_0         
    //*  20   44:invokevirtual   #102 <Method Enumeration Properties.propertyNames()>
    //*  21   47:astore_1        
    //*  22   48:goto            169
        {
            String name = enm.nextElement().toString();
    //   23   51:aload_1         
    //   24   52:invokeinterface #185 <Method Object Enumeration.nextElement()>
    //   25   57:invokevirtual   #186 <Method String Object.toString()>
    //   26   60:astore_2        
            String value = props.getProperty(name, "");
    //   27   61:aload_0         
    //   28   62:aload_2         
    //   29   63:ldc1            #188 <String "">
    //   30   65:invokevirtual   #191 <Method String Properties.getProperty(String, String)>
    //   31   68:astore_3        
            try
            {
                Class cls;
                if(name.endsWith("[]"))
    //*  32   69:aload_2         
    //*  33   70:ldc1            #193 <String "[]">
    //*  34   72:invokevirtual   #199 <Method boolean String.endsWith(String)>
    //*  35   75:ifeq            108
                {
                    Class baseCls = Class.forName(name.substring(0, name.indexOf("[]")));
    //   36   78:aload_2         
    //   37   79:iconst_0        
    //   38   80:aload_2         
    //   39   81:ldc1            #193 <String "[]">
    //   40   83:invokevirtual   #203 <Method int String.indexOf(String)>
    //   41   86:invokevirtual   #207 <Method String String.substring(int, int)>
    //   42   89:invokestatic    #213 <Method Class Class.forName(String)>
    //   43   92:astore          4
                    cls = Array.newInstance(baseCls, 1).getClass();
    //   44   94:aload           4
    //   45   96:iconst_1        
    //   46   97:invokestatic    #219 <Method Object Array.newInstance(Class, int)>
    //   47  100:invokevirtual   #223 <Method Class Object.getClass()>
    //   48  103:astore          5
                } else
    //*  49  105:goto            114
                {
                    cls = Class.forName(name);
    //   50  108:aload_2         
    //   51  109:invokestatic    #213 <Method Class Class.forName(String)>
    //   52  112:astore          5
                }
                PropertyEditorManager.registerEditor(cls, Class.forName(value));
    //   53  114:aload           5
    //   54  116:aload_3         
    //   55  117:invokestatic    #213 <Method Class Class.forName(String)>
    //   56  120:invokestatic    #229 <Method void PropertyEditorManager.registerEditor(Class, Class)>
            }
    //*  57  123:goto            169
            catch(Exception e)
    //*  58  126:astore          6
            {
                System.err.println((new StringBuilder("Problem registering ")).append(name).append("/").append(value).append(": ").append(e).toString());
    //   59  128:getstatic       #170 <Field PrintStream System.err>
    //   60  131:new             #66  <Class StringBuilder>
    //   61  134:dup             
    //   62  135:ldc1            #231 <String "Problem registering ">
    //   63  137:invokespecial   #71  <Method void StringBuilder(String)>
    //   64  140:aload_2         
    //   65  141:invokevirtual   #81  <Method StringBuilder StringBuilder.append(String)>
    //   66  144:ldc1            #233 <String "/">
    //   67  146:invokevirtual   #81  <Method StringBuilder StringBuilder.append(String)>
    //   68  149:aload_3         
    //   69  150:invokevirtual   #81  <Method StringBuilder StringBuilder.append(String)>
    //   70  153:ldc1            #235 <String ": ">
    //   71  155:invokevirtual   #81  <Method StringBuilder StringBuilder.append(String)>
    //   72  158:aload           6
    //   73  160:invokevirtual   #238 <Method StringBuilder StringBuilder.append(Object)>
    //   74  163:invokevirtual   #82  <Method String StringBuilder.toString()>
    //   75  166:invokevirtual   #177 <Method void PrintStream.println(String)>
            }
        }

    //   76  169:aload_1         
    //   77  170:invokeinterface #107 <Method boolean Enumeration.hasMoreElements()>
    //   78  175:ifne            51
    //   79  178:return          
    }

    public void setCanChangeClassInDialog(boolean value)
    {
        m_canChangeClassInDialog = value;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #162 <Field boolean m_canChangeClassInDialog>
    //    3    5:return          
    }

    public boolean getCanChangeClassInDialog()
    {
        return m_canChangeClassInDialog;
    //    0    0:aload_0         
    //    1    1:getfield        #162 <Field boolean m_canChangeClassInDialog>
    //    2    4:ireturn         
    }

    public Object getBackup()
    {
        return m_Backup;
    //    0    0:aload_0         
    //    1    1:getfield        #249 <Field Object m_Backup>
    //    2    4:areturn         
    }

    protected static String getRootFromClass(String clsname, String separator)
    {
        if(clsname.indexOf(separator) > -1)
    //*   0    0:aload_0         
    //*   1    1:aload_1         
    //*   2    2:invokevirtual   #203 <Method int String.indexOf(String)>
    //*   3    5:iconst_m1       
    //*   4    6:icmple          20
            return clsname.substring(0, clsname.indexOf(separator));
    //    5    9:aload_0         
    //    6   10:iconst_0        
    //    7   11:aload_0         
    //    8   12:aload_1         
    //    9   13:invokevirtual   #203 <Method int String.indexOf(String)>
    //   10   16:invokevirtual   #207 <Method String String.substring(int, int)>
    //   11   19:areturn         
        else
            return null;
    //   12   20:aconst_null     
    //   13   21:areturn         
    }

    public static Hashtable sortClassesByRoot(String classes)
    {
        if(classes == null)
    //*   0    0:aload_0         
    //*   1    1:ifnonnull       6
            return null;
    //    2    4:aconst_null     
    //    3    5:areturn         
        Hashtable roots = new Hashtable();
    //    4    6:new             #256 <Class Hashtable>
    //    5    9:dup             
    //    6   10:invokespecial   #257 <Method void Hashtable()>
    //    7   13:astore_1        
        HierarchyPropertyParser hpp = new HierarchyPropertyParser();
    //    8   14:new             #259 <Class HierarchyPropertyParser>
    //    9   17:dup             
    //   10   18:invokespecial   #260 <Method void HierarchyPropertyParser()>
    //   11   21:astore          8
        String separator = hpp.getSeperator();
    //   12   23:aload           8
    //   13   25:invokevirtual   #263 <Method String HierarchyPropertyParser.getSeperator()>
    //   14   28:astore          9
        for(StringTokenizer tok = new StringTokenizer(classes, ", "); tok.hasMoreElements();)
    //*  15   30:new             #265 <Class StringTokenizer>
    //*  16   33:dup             
    //*  17   34:aload_0         
    //*  18   35:ldc2            #267 <String ", ">
    //*  19   38:invokespecial   #270 <Method void StringTokenizer(String, String)>
    //*  20   41:astore          5
    //*  21   43:goto            122
        {
            String clsname = tok.nextToken();
    //   22   46:aload           5
    //   23   48:invokevirtual   #273 <Method String StringTokenizer.nextToken()>
    //   24   51:astore          6
            String root = getRootFromClass(clsname, separator);
    //   25   53:aload           6
    //   26   55:aload           9
    //   27   57:invokestatic    #275 <Method String getRootFromClass(String, String)>
    //   28   60:astore          10
            if(root != null)
    //*  29   62:aload           10
    //*  30   64:ifnonnull       70
    //*  31   67:goto            122
            {
                Vector list;
                if(!roots.containsKey(root))
    //*  32   70:aload_1         
    //*  33   71:aload           10
    //*  34   73:invokevirtual   #279 <Method boolean Hashtable.containsKey(Object)>
    //*  35   76:ifne            100
                {
                    list = new Vector();
    //   36   79:new             #281 <Class Vector>
    //   37   82:dup             
    //   38   83:invokespecial   #282 <Method void Vector()>
    //   39   86:astore          7
                    roots.put(root, list);
    //   40   88:aload_1         
    //   41   89:aload           10
    //   42   91:aload           7
    //   43   93:invokevirtual   #286 <Method Object Hashtable.put(Object, Object)>
    //   44   96:pop             
                } else
    //*  45   97:goto            114
                {
                    list = (Vector)(Vector)roots.get(root);
    //   46  100:aload_1         
    //   47  101:aload           10
    //   48  103:invokevirtual   #290 <Method Object Hashtable.get(Object)>
    //   49  106:checkcast       #281 <Class Vector>
    //   50  109:checkcast       #281 <Class Vector>
    //   51  112:astore          7
                }
                list.add(clsname);
    //   52  114:aload           7
    //   53  116:aload           6
    //   54  118:invokevirtual   #293 <Method boolean Vector.add(Object)>
    //   55  121:pop             
            }
        }

    //   56  122:aload           5
    //   57  124:invokevirtual   #294 <Method boolean StringTokenizer.hasMoreElements()>
    //   58  127:ifne            46
        Hashtable result = new Hashtable();
    //   59  130:new             #256 <Class Hashtable>
    //   60  133:dup             
    //   61  134:invokespecial   #257 <Method void Hashtable()>
    //   62  137:astore_2        
        String root;
        String tmpStr;
        for(Enumeration enm = roots.keys(); enm.hasMoreElements(); result.put(root, tmpStr))
    //*  63  138:aload_1         
    //*  64  139:invokevirtual   #296 <Method Enumeration Hashtable.keys()>
    //*  65  142:astore_3        
    //*  66  143:goto            267
        {
            root = (String)(String)enm.nextElement();
    //   67  146:aload_3         
    //   68  147:invokeinterface #185 <Method Object Enumeration.nextElement()>
    //   69  152:checkcast       #195 <Class String>
    //   70  155:checkcast       #195 <Class String>
    //   71  158:astore          10
            Vector list = (Vector)(Vector)roots.get(root);
    //   72  160:aload_1         
    //   73  161:aload           10
    //   74  163:invokevirtual   #290 <Method Object Hashtable.get(Object)>
    //   75  166:checkcast       #281 <Class Vector>
    //   76  169:checkcast       #281 <Class Vector>
    //   77  172:astore          7
            tmpStr = "";
    //   78  174:ldc1            #188 <String "">
    //   79  176:astore          11
            for(int i = 0; i < list.size(); i++)
    //*  80  178:iconst_0        
    //*  81  179:istore          4
    //*  82  181:goto            248
            {
                if(i > 0)
    //*  83  184:iload           4
    //*  84  186:ifle            212
                    tmpStr = (new StringBuilder(String.valueOf(tmpStr))).append(",").toString();
    //   85  189:new             #66  <Class StringBuilder>
    //   86  192:dup             
    //   87  193:aload           11
    //   88  195:invokestatic    #300 <Method String String.valueOf(Object)>
    //   89  198:invokespecial   #71  <Method void StringBuilder(String)>
    //   90  201:ldc2            #302 <String ",">
    //   91  204:invokevirtual   #81  <Method StringBuilder StringBuilder.append(String)>
    //   92  207:invokevirtual   #82  <Method String StringBuilder.toString()>
    //   93  210:astore          11
                tmpStr = (new StringBuilder(String.valueOf(tmpStr))).append((String)(String)list.get(i)).toString();
    //   94  212:new             #66  <Class StringBuilder>
    //   95  215:dup             
    //   96  216:aload           11
    //   97  218:invokestatic    #300 <Method String String.valueOf(Object)>
    //   98  221:invokespecial   #71  <Method void StringBuilder(String)>
    //   99  224:aload           7
    //  100  226:iload           4
    //  101  228:invokevirtual   #305 <Method Object Vector.get(int)>
    //  102  231:checkcast       #195 <Class String>
    //  103  234:checkcast       #195 <Class String>
    //  104  237:invokevirtual   #81  <Method StringBuilder StringBuilder.append(String)>
    //  105  240:invokevirtual   #82  <Method String StringBuilder.toString()>
    //  106  243:astore          11
            }

    //  107  245:iinc            4  1
    //  108  248:iload           4
    //  109  250:aload           7
    //  110  252:invokevirtual   #309 <Method int Vector.size()>
    //  111  255:icmplt          184
        }

    //  112  258:aload_2         
    //  113  259:aload           10
    //  114  261:aload           11
    //  115  263:invokevirtual   #286 <Method Object Hashtable.put(Object, Object)>
    //  116  266:pop             
    //  117  267:aload_3         
    //  118  268:invokeinterface #107 <Method boolean Enumeration.hasMoreElements()>
    //  119  273:ifne            146
        return result;
    //  120  276:aload_2         
    //  121  277:areturn         
    }

    protected Hashtable getClassesFromProperties()
    {
        Hashtable hpps = new Hashtable();
    //    0    0:new             #256 <Class Hashtable>
    //    1    3:dup             
    //    2    4:invokespecial   #257 <Method void Hashtable()>
    //    3    7:astore_1        
        String className = m_ClassType.getName();
    //    4    8:aload_0         
    //    5    9:getfield        #326 <Field Class m_ClassType>
    //    6   12:invokevirtual   #329 <Method String Class.getName()>
    //    7   15:astore_2        
        Hashtable typeOptions = sortClassesByRoot(EDITOR_PROPERTIES.getProperty(className));
    //    8   16:getstatic       #64  <Field Properties EDITOR_PROPERTIES>
    //    9   19:aload_2         
    //   10   20:invokevirtual   #129 <Method String Properties.getProperty(String)>
    //   11   23:invokestatic    #331 <Method Hashtable sortClassesByRoot(String)>
    //   12   26:astore_3        
        if(typeOptions != null)
    //*  13   27:aload_3         
    //*  14   28:ifnull          135
            try
            {
                String root;
                HierarchyPropertyParser hpp;
                for(Enumeration enm = typeOptions.keys(); enm.hasMoreElements(); hpps.put(root, hpp))
    //*  15   31:aload_3         
    //*  16   32:invokevirtual   #296 <Method Enumeration Hashtable.keys()>
    //*  17   35:astore          4
    //*  18   37:goto            97
                {
                    root = (String)(String)enm.nextElement();
    //   19   40:aload           4
    //   20   42:invokeinterface #185 <Method Object Enumeration.nextElement()>
    //   21   47:checkcast       #195 <Class String>
    //   22   50:checkcast       #195 <Class String>
    //   23   53:astore          5
                    String typeOption = (String)(String)typeOptions.get(root);
    //   24   55:aload_3         
    //   25   56:aload           5
    //   26   58:invokevirtual   #290 <Method Object Hashtable.get(Object)>
    //   27   61:checkcast       #195 <Class String>
    //   28   64:checkcast       #195 <Class String>
    //   29   67:astore          6
                    hpp = new HierarchyPropertyParser();
    //   30   69:new             #259 <Class HierarchyPropertyParser>
    //   31   72:dup             
    //   32   73:invokespecial   #260 <Method void HierarchyPropertyParser()>
    //   33   76:astore          7
                    hpp.build(typeOption, ", ");
    //   34   78:aload           7
    //   35   80:aload           6
    //   36   82:ldc2            #267 <String ", ">
    //   37   85:invokevirtual   #334 <Method void HierarchyPropertyParser.build(String, String)>
                }

    //   38   88:aload_1         
    //   39   89:aload           5
    //   40   91:aload           7
    //   41   93:invokevirtual   #286 <Method Object Hashtable.put(Object, Object)>
    //   42   96:pop             
    //   43   97:aload           4
    //   44   99:invokeinterface #107 <Method boolean Enumeration.hasMoreElements()>
    //   45  104:ifne            40
            }
    //*  46  107:goto            135
            catch(Exception ex)
    //*  47  110:astore          4
            {
                System.err.println((new StringBuilder("Invalid property: ")).append(typeOptions).toString());
    //   48  112:getstatic       #170 <Field PrintStream System.err>
    //   49  115:new             #66  <Class StringBuilder>
    //   50  118:dup             
    //   51  119:ldc2            #336 <String "Invalid property: ">
    //   52  122:invokespecial   #71  <Method void StringBuilder(String)>
    //   53  125:aload_3         
    //   54  126:invokevirtual   #238 <Method StringBuilder StringBuilder.append(Object)>
    //   55  129:invokevirtual   #82  <Method String StringBuilder.toString()>
    //   56  132:invokevirtual   #177 <Method void PrintStream.println(String)>
            }
        return hpps;
    //   57  135:aload_1         
    //   58  136:areturn         
    }

    protected void updateObjectNames()
    {
        if(m_ObjectNames == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #343 <Field Hashtable m_ObjectNames>
    //*   2    4:ifnonnull       15
            m_ObjectNames = getClassesFromProperties();
    //    3    7:aload_0         
    //    4    8:aload_0         
    //    5    9:invokevirtual   #345 <Method Hashtable getClassesFromProperties()>
    //    6   12:putfield        #343 <Field Hashtable m_ObjectNames>
        if(m_Object != null)
    //*   7   15:aload_0         
    //*   8   16:getfield        #347 <Field Object m_Object>
    //*   9   19:ifnull          80
        {
            String className = m_Object.getClass().getName();
    //   10   22:aload_0         
    //   11   23:getfield        #347 <Field Object m_Object>
    //   12   26:invokevirtual   #223 <Method Class Object.getClass()>
    //   13   29:invokevirtual   #329 <Method String Class.getName()>
    //   14   32:astore_1        
            String root = getRootFromClass(className, (new HierarchyPropertyParser()).getSeperator());
    //   15   33:aload_1         
    //   16   34:new             #259 <Class HierarchyPropertyParser>
    //   17   37:dup             
    //   18   38:invokespecial   #260 <Method void HierarchyPropertyParser()>
    //   19   41:invokevirtual   #263 <Method String HierarchyPropertyParser.getSeperator()>
    //   20   44:invokestatic    #275 <Method String getRootFromClass(String, String)>
    //   21   47:astore_2        
            HierarchyPropertyParser hpp = (HierarchyPropertyParser)(HierarchyPropertyParser)m_ObjectNames.get(root);
    //   22   48:aload_0         
    //   23   49:getfield        #343 <Field Hashtable m_ObjectNames>
    //   24   52:aload_2         
    //   25   53:invokevirtual   #290 <Method Object Hashtable.get(Object)>
    //   26   56:checkcast       #259 <Class HierarchyPropertyParser>
    //   27   59:checkcast       #259 <Class HierarchyPropertyParser>
    //   28   62:astore_3        
            if(hpp != null && !hpp.contains(className))
    //*  29   63:aload_3         
    //*  30   64:ifnull          80
    //*  31   67:aload_3         
    //*  32   68:aload_1         
    //*  33   69:invokevirtual   #350 <Method boolean HierarchyPropertyParser.contains(String)>
    //*  34   72:ifne            80
                hpp.add(className);
    //   35   75:aload_3         
    //   36   76:aload_1         
    //   37   77:invokevirtual   #352 <Method void HierarchyPropertyParser.add(String)>
        }
    //   38   80:return          
    }

    public void setEnabled(boolean newVal)
    {
        if(newVal != m_Enabled)
    //*   0    0:iload_1         
    //*   1    1:aload_0         
    //*   2    2:getfield        #158 <Field boolean m_Enabled>
    //*   3    5:icmpeq          13
            m_Enabled = newVal;
    //    4    8:aload_0         
    //    5    9:iload_1         
    //    6   10:putfield        #158 <Field boolean m_Enabled>
    //    7   13:return          
    }

    public void setClassType(Class type)
    {
        m_ClassType = type;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #326 <Field Class m_ClassType>
        m_ObjectNames = getClassesFromProperties();
    //    3    5:aload_0         
    //    4    6:aload_0         
    //    5    7:invokevirtual   #345 <Method Hashtable getClassesFromProperties()>
    //    6   10:putfield        #343 <Field Hashtable m_ObjectNames>
    //    7   13:return          
    }

    public void setDefaultValue()
    {
        if(m_ClassType == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #326 <Field Class m_ClassType>
    //*   2    4:ifnonnull       17
        {
            System.err.println("No ClassType set up for GenericObjectEditor!!");
    //    3    7:getstatic       #170 <Field PrintStream System.err>
    //    4   10:ldc2            #360 <String "No ClassType set up for GenericObjectEditor!!">
    //    5   13:invokevirtual   #177 <Method void PrintStream.println(String)>
            return;
    //    6   16:return          
        }
        Hashtable hpps = getClassesFromProperties();
    //    7   17:aload_0         
    //    8   18:invokevirtual   #345 <Method Hashtable getClassesFromProperties()>
    //    9   21:astore_1        
        HierarchyPropertyParser hpp = null;
    //   10   22:aconst_null     
    //   11   23:astore_2        
        Enumeration enm = hpps.elements();
    //   12   24:aload_1         
    //   13   25:invokevirtual   #363 <Method Enumeration Hashtable.elements()>
    //   14   28:astore_3        
    //*  15   29:goto            89
        try
        {
            while(enm.hasMoreElements()) 
            {
                hpp = (HierarchyPropertyParser)(HierarchyPropertyParser)enm.nextElement();
    //   16   32:aload_3         
    //   17   33:invokeinterface #185 <Method Object Enumeration.nextElement()>
    //   18   38:checkcast       #259 <Class HierarchyPropertyParser>
    //   19   41:checkcast       #259 <Class HierarchyPropertyParser>
    //   20   44:astore_2        
                if(hpp.depth() > 0)
    //*  21   45:aload_2         
    //*  22   46:invokevirtual   #366 <Method int HierarchyPropertyParser.depth()>
    //*  23   49:ifle            89
                {
                    hpp.goToRoot();
    //   24   52:aload_2         
    //   25   53:invokevirtual   #369 <Method void HierarchyPropertyParser.goToRoot()>
    //*  26   56:goto            64
                    for(; !hpp.isLeafReached(); hpp.goToChild(0));
    //   27   59:aload_2         
    //   28   60:iconst_0        
    //   29   61:invokevirtual   #373 <Method void HierarchyPropertyParser.goToChild(int)>
    //   30   64:aload_2         
    //   31   65:invokevirtual   #376 <Method boolean HierarchyPropertyParser.isLeafReached()>
    //   32   68:ifeq            59
                    String defaultValue = hpp.fullValue();
    //   33   71:aload_2         
    //   34   72:invokevirtual   #379 <Method String HierarchyPropertyParser.fullValue()>
    //   35   75:astore          4
                    setValue(Class.forName(defaultValue).newInstance());
    //   36   77:aload_0         
    //   37   78:aload           4
    //   38   80:invokestatic    #213 <Method Class Class.forName(String)>
    //   39   83:invokevirtual   #381 <Method Object Class.newInstance()>
    //   40   86:invokevirtual   #384 <Method void setValue(Object)>
                }
            }
    //   41   89:aload_3         
    //   42   90:invokeinterface #107 <Method boolean Enumeration.hasMoreElements()>
    //   43   95:ifne            32
        }
    //*  44   98:goto            134
        catch(Exception ex)
    //*  45  101:astore          4
        {
            System.err.println((new StringBuilder("Problem loading the first class: ")).append(hpp.fullValue()).toString());
    //   46  103:getstatic       #170 <Field PrintStream System.err>
    //   47  106:new             #66  <Class StringBuilder>
    //   48  109:dup             
    //   49  110:ldc2            #386 <String "Problem loading the first class: ">
    //   50  113:invokespecial   #71  <Method void StringBuilder(String)>
    //   51  116:aload_2         
    //   52  117:invokevirtual   #379 <Method String HierarchyPropertyParser.fullValue()>
    //   53  120:invokevirtual   #81  <Method StringBuilder StringBuilder.append(String)>
    //   54  123:invokevirtual   #82  <Method String StringBuilder.toString()>
    //   55  126:invokevirtual   #177 <Method void PrintStream.println(String)>
            ex.printStackTrace();
    //   56  129:aload           4
    //   57  131:invokevirtual   #181 <Method void Exception.printStackTrace()>
        }
    //   58  134:return          
    }

    public void setValue(Object o)
    {
        if(m_ClassType == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #326 <Field Class m_ClassType>
    //*   2    4:ifnonnull       17
        {
            System.err.println("No ClassType set up for GenericObjectEditor!!");
    //    3    7:getstatic       #170 <Field PrintStream System.err>
    //    4   10:ldc2            #360 <String "No ClassType set up for GenericObjectEditor!!">
    //    5   13:invokevirtual   #177 <Method void PrintStream.println(String)>
            return;
    //    6   16:return          
        }
        if(!m_ClassType.isAssignableFrom(o.getClass()))
    //*   7   17:aload_0         
    //*   8   18:getfield        #326 <Field Class m_ClassType>
    //*   9   21:aload_1         
    //*  10   22:invokevirtual   #223 <Method Class Object.getClass()>
    //*  11   25:invokevirtual   #391 <Method boolean Class.isAssignableFrom(Class)>
    //*  12   28:ifne            41
        {
            System.err.println("setValue object not of correct type!");
    //   13   31:getstatic       #170 <Field PrintStream System.err>
    //   14   34:ldc2            #393 <String "setValue object not of correct type!">
    //   15   37:invokevirtual   #177 <Method void PrintStream.println(String)>
            return;
    //   16   40:return          
        }
        setObject(o);
    //   17   41:aload_0         
    //   18   42:aload_1         
    //   19   43:invokevirtual   #396 <Method void setObject(Object)>
        if(m_EditorComponent != null)
    //*  20   46:aload_0         
    //*  21   47:getfield        #398 <Field GenericObjectEditor$GOEPanel m_EditorComponent>
    //*  22   50:ifnull          60
            m_EditorComponent.repaint();
    //   23   53:aload_0         
    //   24   54:getfield        #398 <Field GenericObjectEditor$GOEPanel m_EditorComponent>
    //   25   57:invokevirtual   #403 <Method void GenericObjectEditor$GOEPanel.repaint()>
        updateObjectNames();
    //   26   60:aload_0         
    //   27   61:invokevirtual   #405 <Method void updateObjectNames()>
    //   28   64:return          
    }

    protected void setObject(Object c)
    {
        boolean trueChange;
        if(getValue() != null)
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #409 <Method Object getValue()>
    //*   2    4:ifnull          27
            trueChange = !c.equals(getValue());
    //    3    7:aload_1         
    //    4    8:aload_0         
    //    5    9:invokevirtual   #409 <Method Object getValue()>
    //    6   12:invokevirtual   #412 <Method boolean Object.equals(Object)>
    //    7   15:ifeq            22
    //    8   18:iconst_0        
    //    9   19:goto            23
    //   10   22:iconst_1        
    //   11   23:istore_2        
        else
    //*  12   24:goto            29
            trueChange = true;
    //   13   27:iconst_1        
    //   14   28:istore_2        
        m_Backup = m_Object;
    //   15   29:aload_0         
    //   16   30:aload_0         
    //   17   31:getfield        #347 <Field Object m_Object>
    //   18   34:putfield        #249 <Field Object m_Backup>
        m_Object = c;
    //   19   37:aload_0         
    //   20   38:aload_1         
    //   21   39:putfield        #347 <Field Object m_Object>
        if(m_EditorComponent != null)
    //*  22   42:aload_0         
    //*  23   43:getfield        #398 <Field GenericObjectEditor$GOEPanel m_EditorComponent>
    //*  24   46:ifnull          56
            m_EditorComponent.updateChildPropertySheet();
    //   25   49:aload_0         
    //   26   50:getfield        #398 <Field GenericObjectEditor$GOEPanel m_EditorComponent>
    //   27   53:invokevirtual   #415 <Method void GenericObjectEditor$GOEPanel.updateChildPropertySheet()>
        if(trueChange)
    //*  28   56:iload_2         
    //*  29   57:ifeq            71
            m_Support.firePropertyChange("", null, null);
    //   30   60:aload_0         
    //   31   61:getfield        #156 <Field PropertyChangeSupport m_Support>
    //   32   64:ldc1            #188 <String "">
    //   33   66:aconst_null     
    //   34   67:aconst_null     
    //   35   68:invokevirtual   #419 <Method void PropertyChangeSupport.firePropertyChange(String, Object, Object)>
    //   36   71:return          
    }

    public Object getValue()
    {
        Object result = null;
    //    0    0:aconst_null     
    //    1    1:astore_1        
        try
        {
            result = makeCopy(m_Object);
    //    2    2:aload_0         
    //    3    3:getfield        #347 <Field Object m_Object>
    //    4    6:invokestatic    #424 <Method Object makeCopy(Object)>
    //    5    9:astore_1        
        }
    //*   6   10:goto            18
        catch(Exception ex)
    //*   7   13:astore_2        
        {
            ex.printStackTrace();
    //    8   14:aload_2         
    //    9   15:invokevirtual   #181 <Method void Exception.printStackTrace()>
        }
        return result;
    //   10   18:aload_1         
    //   11   19:areturn         
    }

    public String getJavaInitializationString()
    {
        return (new StringBuilder("new ")).append(m_Object.getClass().getName()).append("()").toString();
    //    0    0:new             #66  <Class StringBuilder>
    //    1    3:dup             
    //    2    4:ldc2            #427 <String "new ">
    //    3    7:invokespecial   #71  <Method void StringBuilder(String)>
    //    4   10:aload_0         
    //    5   11:getfield        #347 <Field Object m_Object>
    //    6   14:invokevirtual   #223 <Method Class Object.getClass()>
    //    7   17:invokevirtual   #329 <Method String Class.getName()>
    //    8   20:invokevirtual   #81  <Method StringBuilder StringBuilder.append(String)>
    //    9   23:ldc2            #429 <String "()">
    //   10   26:invokevirtual   #81  <Method StringBuilder StringBuilder.append(String)>
    //   11   29:invokevirtual   #82  <Method String StringBuilder.toString()>
    //   12   32:areturn         
    }

    public boolean isPaintable()
    {
        return true;
    //    0    0:iconst_1        
    //    1    1:ireturn         
    }

    public void paintValue(Graphics gfx, Rectangle box)
    {
        if(m_Enabled)
    //*   0    0:aload_0         
    //*   1    1:getfield        #158 <Field boolean m_Enabled>
    //*   2    4:ifeq            174
        {
            String rep;
            if(m_Object != null)
    //*   3    7:aload_0         
    //*   4    8:getfield        #347 <Field Object m_Object>
    //*   5   11:ifnull          28
                rep = m_Object.getClass().getName();
    //    6   14:aload_0         
    //    7   15:getfield        #347 <Field Object m_Object>
    //    8   18:invokevirtual   #223 <Method Class Object.getClass()>
    //    9   21:invokevirtual   #329 <Method String Class.getName()>
    //   10   24:astore_3        
            else
    //*  11   25:goto            32
                rep = "None";
    //   12   28:ldc2            #434 <String "None">
    //   13   31:astore_3        
            int dotPos = rep.lastIndexOf('.');
    //   14   32:aload_3         
    //   15   33:bipush          46
    //   16   35:invokevirtual   #438 <Method int String.lastIndexOf(int)>
    //   17   38:istore          4
            if(dotPos != -1)
    //*  18   40:iload           4
    //*  19   42:iconst_m1       
    //*  20   43:icmpeq          55
                rep = rep.substring(dotPos + 1);
    //   21   46:aload_3         
    //   22   47:iload           4
    //   23   49:iconst_1        
    //   24   50:iadd            
    //   25   51:invokevirtual   #441 <Method String String.substring(int)>
    //   26   54:astore_3        
            Font originalFont = gfx.getFont();
    //   27   55:aload_1         
    //   28   56:invokevirtual   #447 <Method Font Graphics.getFont()>
    //   29   59:astore          5
            gfx.setFont(originalFont.deriveFont(1));
    //   30   61:aload_1         
    //   31   62:aload           5
    //   32   64:iconst_1        
    //   33   65:invokevirtual   #453 <Method Font Font.deriveFont(int)>
    //   34   68:invokevirtual   #457 <Method void Graphics.setFont(Font)>
            FontMetrics fm = gfx.getFontMetrics();
    //   35   71:aload_1         
    //   36   72:invokevirtual   #461 <Method FontMetrics Graphics.getFontMetrics()>
    //   37   75:astore          6
            int vpad = box.height - fm.getHeight();
    //   38   77:aload_2         
    //   39   78:getfield        #466 <Field int Rectangle.height>
    //   40   81:aload           6
    //   41   83:invokevirtual   #471 <Method int FontMetrics.getHeight()>
    //   42   86:isub            
    //   43   87:istore          7
            gfx.drawString(rep, 2, fm.getAscent() + vpad);
    //   44   89:aload_1         
    //   45   90:aload_3         
    //   46   91:iconst_2        
    //   47   92:aload           6
    //   48   94:invokevirtual   #474 <Method int FontMetrics.getAscent()>
    //   49   97:iload           7
    //   50   99:iadd            
    //   51  100:invokevirtual   #478 <Method void Graphics.drawString(String, int, int)>
            int repwidth = fm.stringWidth(rep);
    //   52  103:aload           6
    //   53  105:aload_3         
    //   54  106:invokevirtual   #481 <Method int FontMetrics.stringWidth(String)>
    //   55  109:istore          8
            gfx.setFont(originalFont);
    //   56  111:aload_1         
    //   57  112:aload           5
    //   58  114:invokevirtual   #457 <Method void Graphics.setFont(Font)>
            if(m_Object instanceof OptionHandler)
    //*  59  117:aload_0         
    //*  60  118:getfield        #347 <Field Object m_Object>
    //*  61  121:instanceof      #483 <Class OptionHandler>
    //*  62  124:ifeq            174
                gfx.drawString((new StringBuilder(" ")).append(Utils.joinOptions(((OptionHandler)m_Object).getOptions())).toString(), repwidth + 2, fm.getAscent() + vpad);
    //   63  127:aload_1         
    //   64  128:new             #66  <Class StringBuilder>
    //   65  131:dup             
    //   66  132:ldc2            #485 <String " ">
    //   67  135:invokespecial   #71  <Method void StringBuilder(String)>
    //   68  138:aload_0         
    //   69  139:getfield        #347 <Field Object m_Object>
    //   70  142:checkcast       #483 <Class OptionHandler>
    //   71  145:invokeinterface #489 <Method String[] OptionHandler.getOptions()>
    //   72  150:invokestatic    #493 <Method String Utils.joinOptions(String[])>
    //   73  153:invokevirtual   #81  <Method StringBuilder StringBuilder.append(String)>
    //   74  156:invokevirtual   #82  <Method String StringBuilder.toString()>
    //   75  159:iload           8
    //   76  161:iconst_2        
    //   77  162:iadd            
    //   78  163:aload           6
    //   79  165:invokevirtual   #474 <Method int FontMetrics.getAscent()>
    //   80  168:iload           7
    //   81  170:iadd            
    //   82  171:invokevirtual   #478 <Method void Graphics.drawString(String, int, int)>
        }
    //   83  174:return          
    }

    public String getAsText()
    {
        return null;
    //    0    0:aconst_null     
    //    1    1:areturn         
    }

    public void setAsText(String text)
    {
        throw new IllegalArgumentException(text);
    //    0    0:new             #509 <Class IllegalArgumentException>
    //    1    3:dup             
    //    2    4:aload_1         
    //    3    5:invokespecial   #510 <Method void IllegalArgumentException(String)>
    //    4    8:athrow          
    }

    public String[] getTags()
    {
        return null;
    //    0    0:aconst_null     
    //    1    1:areturn         
    }

    public boolean supportsCustomEditor()
    {
        return true;
    //    0    0:iconst_1        
    //    1    1:ireturn         
    }

    public Component getCustomEditor()
    {
        if(m_EditorComponent == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #398 <Field GenericObjectEditor$GOEPanel m_EditorComponent>
    //*   2    4:ifnonnull       19
            m_EditorComponent = new GOEPanel();
    //    3    7:aload_0         
    //    4    8:new             #400 <Class GenericObjectEditor$GOEPanel>
    //    5   11:dup             
    //    6   12:aload_0         
    //    7   13:invokespecial   #518 <Method void GenericObjectEditor$GOEPanel(GenericObjectEditor)>
    //    8   16:putfield        #398 <Field GenericObjectEditor$GOEPanel m_EditorComponent>
        return m_EditorComponent;
    //    9   19:aload_0         
    //   10   20:getfield        #398 <Field GenericObjectEditor$GOEPanel m_EditorComponent>
    //   11   23:areturn         
    }

    public void addPropertyChangeListener(PropertyChangeListener l)
    {
        m_Support.addPropertyChangeListener(l);
    //    0    0:aload_0         
    //    1    1:getfield        #156 <Field PropertyChangeSupport m_Support>
    //    2    4:aload_1         
    //    3    5:invokevirtual   #522 <Method void PropertyChangeSupport.addPropertyChangeListener(PropertyChangeListener)>
    //    4    8:return          
    }

    public void removePropertyChangeListener(PropertyChangeListener l)
    {
        m_Support.removePropertyChangeListener(l);
    //    0    0:aload_0         
    //    1    1:getfield        #156 <Field PropertyChangeSupport m_Support>
    //    2    4:aload_1         
    //    3    5:invokevirtual   #527 <Method void PropertyChangeSupport.removePropertyChangeListener(PropertyChangeListener)>
    //    4    8:return          
    }

    public JPanel getCustomPanel()
    {
        final JButton chooseButton = createChooseClassButton();
    //    0    0:aload_0         
    //    1    1:invokevirtual   #533 <Method JButton createChooseClassButton()>
    //    2    4:astore_1        
        m_ObjectPropertyPanel = new PropertyPanel(this, true);
    //    3    5:aload_0         
    //    4    6:new             #535 <Class PropertyPanel>
    //    5    9:dup             
    //    6   10:aload_0         
    //    7   11:iconst_1        
    //    8   12:invokespecial   #538 <Method void PropertyPanel(PropertyEditor, boolean)>
    //    9   15:putfield        #540 <Field PropertyPanel m_ObjectPropertyPanel>
        JPanel customPanel = new JPanel() {

            public void setEnabled(boolean enabled)
            {
                super.setEnabled(enabled);
            //    0    0:aload_0         
            //    1    1:iload_1         
            //    2    2:invokespecial   #26  <Method void JPanel.setEnabled(boolean)>
                chooseButton.setEnabled(enabled);
            //    3    5:aload_0         
            //    4    6:getfield        #15  <Field JButton val$chooseButton>
            //    5    9:iload_1         
            //    6   10:invokevirtual   #29  <Method void JButton.setEnabled(boolean)>
            //    7   13:return          
            }

            final GenericObjectEditor this$0;
            private final JButton val$chooseButton;

            
            {
                this$0 = GenericObjectEditor.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field GenericObjectEditor this$0>
                chooseButton = jbutton;
            //    3    5:aload_0         
            //    4    6:aload_2         
            //    5    7:putfield        #15  <Field JButton val$chooseButton>
                super();
            //    6   10:aload_0         
            //    7   11:invokespecial   #18  <Method void JPanel()>
            //    8   14:return          
            }
        }
;
    //   10   18:new             #542 <Class GenericObjectEditor$11>
    //   11   21:dup             
    //   12   22:aload_0         
    //   13   23:aload_1         
    //   14   24:invokespecial   #545 <Method void GenericObjectEditor$11(GenericObjectEditor, JButton)>
    //   15   27:astore_2        
        customPanel.setLayout(new BorderLayout());
    //   16   28:aload_2         
    //   17   29:new             #547 <Class BorderLayout>
    //   18   32:dup             
    //   19   33:invokespecial   #548 <Method void BorderLayout()>
    //   20   36:invokevirtual   #554 <Method void JPanel.setLayout(java.awt.LayoutManager)>
        customPanel.add(chooseButton, "West");
    //   21   39:aload_2         
    //   22   40:aload_1         
    //   23   41:ldc2            #556 <String "West">
    //   24   44:invokevirtual   #559 <Method void JPanel.add(Component, Object)>
        customPanel.add(m_ObjectPropertyPanel, "Center");
    //   25   47:aload_2         
    //   26   48:aload_0         
    //   27   49:getfield        #540 <Field PropertyPanel m_ObjectPropertyPanel>
    //   28   52:ldc2            #561 <String "Center">
    //   29   55:invokevirtual   #559 <Method void JPanel.add(Component, Object)>
        return customPanel;
    //   30   58:aload_2         
    //   31   59:areturn         
    }

    protected JButton createChooseClassButton()
    {
        JButton setButton = new JButton("Choose");
    //    0    0:new             #567 <Class JButton>
    //    1    3:dup             
    //    2    4:ldc2            #569 <String "Choose">
    //    3    7:invokespecial   #570 <Method void JButton(String)>
    //    4   10:astore_1        
        setButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                JPopupMenu popup = getChooseClassPopupMenu();
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field GenericObjectEditor this$0>
            //    2    4:invokevirtual   #28  <Method JPopupMenu GenericObjectEditor.getChooseClassPopupMenu()>
            //    3    7:astore_2        
                if(e.getSource() instanceof Component)
            //*   4    8:aload_1         
            //*   5    9:invokevirtual   #34  <Method Object ActionEvent.getSource()>
            //*   6   12:instanceof      #36  <Class Component>
            //*   7   15:ifeq            47
                {
                    Component comp = (Component)e.getSource();
            //    8   18:aload_1         
            //    9   19:invokevirtual   #34  <Method Object ActionEvent.getSource()>
            //   10   22:checkcast       #36  <Class Component>
            //   11   25:astore_3        
                    popup.show(comp, comp.getX(), comp.getY());
            //   12   26:aload_2         
            //   13   27:aload_3         
            //   14   28:aload_3         
            //   15   29:invokevirtual   #40  <Method int Component.getX()>
            //   16   32:aload_3         
            //   17   33:invokevirtual   #43  <Method int Component.getY()>
            //   18   36:invokevirtual   #49  <Method void JPopupMenu.show(Component, int, int)>
                    popup.pack();
            //   19   39:aload_2         
            //   20   40:invokevirtual   #52  <Method void JPopupMenu.pack()>
                    popup.repaint();
            //   21   43:aload_2         
            //   22   44:invokevirtual   #55  <Method void JPopupMenu.repaint()>
                }
            //   23   47:return          
            }

            final GenericObjectEditor this$0;

            
            {
                this$0 = GenericObjectEditor.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field GenericObjectEditor this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //    5   11:aload_1         
    //    6   12:new             #572 <Class GenericObjectEditor$12>
    //    7   15:dup             
    //    8   16:aload_0         
    //    9   17:invokespecial   #573 <Method void GenericObjectEditor$12(GenericObjectEditor)>
    //   10   20:invokevirtual   #577 <Method void JButton.addActionListener(ActionListener)>
        return setButton;
    //   11   23:aload_1         
    //   12   24:areturn         
    }

    protected String getClassnameFromPath(TreePath path)
    {
        StringBuffer classname = new StringBuffer();
    //    0    0:new             #582 <Class StringBuffer>
    //    1    3:dup             
    //    2    4:invokespecial   #583 <Method void StringBuffer()>
    //    3    7:astore_2        
        int start = 0;
    //    4    8:iconst_0        
    //    5    9:istore_3        
        if(m_ObjectNames.size() > 1)
    //*   6   10:aload_0         
    //*   7   11:getfield        #343 <Field Hashtable m_ObjectNames>
    //*   8   14:invokevirtual   #584 <Method int Hashtable.size()>
    //*   9   17:iconst_1        
    //*  10   18:icmple          23
            start = 1;
    //   11   21:iconst_1        
    //   12   22:istore_3        
        for(int i = start; i < path.getPathCount(); i++)
    //*  13   23:iload_3         
    //*  14   24:istore          4
    //*  15   26:goto            66
        {
            if(i > start)
    //*  16   29:iload           4
    //*  17   31:iload_3         
    //*  18   32:icmple          43
                classname.append(".");
    //   19   35:aload_2         
    //   20   36:ldc2            #586 <String ".">
    //   21   39:invokevirtual   #589 <Method StringBuffer StringBuffer.append(String)>
    //   22   42:pop             
            classname.append((String)((GOETreeNode)path.getPathComponent(i)).getUserObject());
    //   23   43:aload_2         
    //   24   44:aload_1         
    //   25   45:iload           4
    //   26   47:invokevirtual   #594 <Method Object TreePath.getPathComponent(int)>
    //   27   50:checkcast       #596 <Class GenericObjectEditor$GOETreeNode>
    //   28   53:invokevirtual   #599 <Method Object GenericObjectEditor$GOETreeNode.getUserObject()>
    //   29   56:checkcast       #195 <Class String>
    //   30   59:invokevirtual   #589 <Method StringBuffer StringBuffer.append(String)>
    //   31   62:pop             
        }

    //   32   63:iinc            4  1
    //   33   66:iload           4
    //   34   68:aload_1         
    //   35   69:invokevirtual   #602 <Method int TreePath.getPathCount()>
    //   36   72:icmplt          29
        return classname.toString();
    //   37   75:aload_2         
    //   38   76:invokevirtual   #603 <Method String StringBuffer.toString()>
    //   39   79:areturn         
    }

    public JPopupMenu getChooseClassPopupMenu()
    {
        updateObjectNames();
    //    0    0:aload_0         
    //    1    1:invokevirtual   #405 <Method void updateObjectNames()>
        m_treeNodeOfCurrentObject = null;
    //    2    4:aload_0         
    //    3    5:aconst_null     
    //    4    6:putfield        #612 <Field GenericObjectEditor$GOETreeNode m_treeNodeOfCurrentObject>
        final JTree tree = createTree(m_ObjectNames);
    //    5    9:aload_0         
    //    6   10:aload_0         
    //    7   11:getfield        #343 <Field Hashtable m_ObjectNames>
    //    8   14:invokevirtual   #616 <Method JTree createTree(Hashtable)>
    //    9   17:astore_1        
        if(m_treeNodeOfCurrentObject != null)
    //*  10   18:aload_0         
    //*  11   19:getfield        #612 <Field GenericObjectEditor$GOETreeNode m_treeNodeOfCurrentObject>
    //*  12   22:ifnull          43
            tree.setSelectionPath(new TreePath(m_treeNodeOfCurrentObject.getPath()));
    //   13   25:aload_1         
    //   14   26:new             #591 <Class TreePath>
    //   15   29:dup             
    //   16   30:aload_0         
    //   17   31:getfield        #612 <Field GenericObjectEditor$GOETreeNode m_treeNodeOfCurrentObject>
    //   18   34:invokevirtual   #620 <Method javax.swing.tree.TreeNode[] GenericObjectEditor$GOETreeNode.getPath()>
    //   19   37:invokespecial   #623 <Method void TreePath(Object[])>
    //   20   40:invokevirtual   #629 <Method void JTree.setSelectionPath(TreePath)>
        tree.getSelectionModel().setSelectionMode(1);
    //   21   43:aload_1         
    //   22   44:invokevirtual   #633 <Method TreeSelectionModel JTree.getSelectionModel()>
    //   23   47:iconst_1        
    //   24   48:invokeinterface #638 <Method void TreeSelectionModel.setSelectionMode(int)>
        final JPopupMenu popup = new JTreePopupMenu(tree);
    //   25   53:new             #640 <Class GenericObjectEditor$JTreePopupMenu>
    //   26   56:dup             
    //   27   57:aload_0         
    //   28   58:aload_1         
    //   29   59:invokespecial   #643 <Method void GenericObjectEditor$JTreePopupMenu(GenericObjectEditor, JTree)>
    //   30   62:astore_2        
        tree.addTreeSelectionListener(new TreeSelectionListener() {

            public void valueChanged(TreeSelectionEvent e)
            {
                GOETreeNode node = (GOETreeNode)tree.getLastSelectedPathComponent();
            //    0    0:aload_0         
            //    1    1:getfield        #19  <Field JTree val$tree>
            //    2    4:invokevirtual   #36  <Method Object JTree.getLastSelectedPathComponent()>
            //    3    7:checkcast       #38  <Class GenericObjectEditor$GOETreeNode>
            //    4   10:astore_2        
                if(node == null)
            //*   5   11:aload_2         
            //*   6   12:ifnonnull       16
                    return;
            //    7   15:return          
                if(node.isLeaf())
            //*   8   16:aload_2         
            //*   9   17:invokevirtual   #42  <Method boolean GenericObjectEditor$GOETreeNode.isLeaf()>
            //*  10   20:ifeq            52
                {
                    classSelected(getClassnameFromPath(tree.getSelectionPath()));
            //   11   23:aload_0         
            //   12   24:getfield        #17  <Field GenericObjectEditor this$0>
            //   13   27:aload_0         
            //   14   28:getfield        #17  <Field GenericObjectEditor this$0>
            //   15   31:aload_0         
            //   16   32:getfield        #19  <Field JTree val$tree>
            //   17   35:invokevirtual   #46  <Method TreePath JTree.getSelectionPath()>
            //   18   38:invokevirtual   #52  <Method String GenericObjectEditor.getClassnameFromPath(TreePath)>
            //   19   41:invokevirtual   #56  <Method void GenericObjectEditor.classSelected(String)>
                    popup.setVisible(false);
            //   20   44:aload_0         
            //   21   45:getfield        #21  <Field JPopupMenu val$popup>
            //   22   48:iconst_0        
            //   23   49:invokevirtual   #62  <Method void JPopupMenu.setVisible(boolean)>
                }
            //   24   52:return          
            }

            final GenericObjectEditor this$0;
            private final JTree val$tree;
            private final JPopupMenu val$popup;

            
            {
                this$0 = GenericObjectEditor.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #17  <Field GenericObjectEditor this$0>
                tree = jtree;
            //    3    5:aload_0         
            //    4    6:aload_2         
            //    5    7:putfield        #19  <Field JTree val$tree>
                popup = jpopupmenu;
            //    6   10:aload_0         
            //    7   11:aload_3         
            //    8   12:putfield        #21  <Field JPopupMenu val$popup>
                super();
            //    9   15:aload_0         
            //   10   16:invokespecial   #24  <Method void Object()>
            //   11   19:return          
            }
        }
);
    //   31   63:aload_1         
    //   32   64:new             #645 <Class GenericObjectEditor$13>
    //   33   67:dup             
    //   34   68:aload_0         
    //   35   69:aload_1         
    //   36   70:aload_2         
    //   37   71:invokespecial   #648 <Method void GenericObjectEditor$13(GenericObjectEditor, JTree, JPopupMenu)>
    //   38   74:invokevirtual   #652 <Method void JTree.addTreeSelectionListener(TreeSelectionListener)>
        return popup;
    //   39   77:aload_2         
    //   40   78:areturn         
    }

    protected JTree createTree(Hashtable hpps)
    {
        GOETreeNode superRoot;
        if(hpps.size() > 1)
    //*   0    0:aload_1         
    //*   1    1:invokevirtual   #584 <Method int Hashtable.size()>
    //*   2    4:iconst_1        
    //*   3    5:icmple          23
            superRoot = new GOETreeNode("root");
    //    4    8:new             #596 <Class GenericObjectEditor$GOETreeNode>
    //    5   11:dup             
    //    6   12:aload_0         
    //    7   13:ldc2            #657 <String "root">
    //    8   16:invokespecial   #660 <Method void GenericObjectEditor$GOETreeNode(GenericObjectEditor, Object)>
    //    9   19:astore_2        
        else
    //*  10   20:goto            25
            superRoot = null;
    //   11   23:aconst_null     
    //   12   24:astore_2        
        for(Enumeration enm = hpps.elements(); enm.hasMoreElements();)
    //*  13   25:aload_1         
    //*  14   26:invokevirtual   #363 <Method Enumeration Hashtable.elements()>
    //*  15   29:astore_3        
    //*  16   30:goto            91
        {
            HierarchyPropertyParser hpp = (HierarchyPropertyParser)(HierarchyPropertyParser)enm.nextElement();
    //   17   33:aload_3         
    //   18   34:invokeinterface #185 <Method Object Enumeration.nextElement()>
    //   19   39:checkcast       #259 <Class HierarchyPropertyParser>
    //   20   42:checkcast       #259 <Class HierarchyPropertyParser>
    //   21   45:astore          4
            hpp.goToRoot();
    //   22   47:aload           4
    //   23   49:invokevirtual   #369 <Method void HierarchyPropertyParser.goToRoot()>
            GOETreeNode root = new GOETreeNode(hpp.getValue());
    //   24   52:new             #596 <Class GenericObjectEditor$GOETreeNode>
    //   25   55:dup             
    //   26   56:aload_0         
    //   27   57:aload           4
    //   28   59:invokevirtual   #662 <Method String HierarchyPropertyParser.getValue()>
    //   29   62:invokespecial   #660 <Method void GenericObjectEditor$GOETreeNode(GenericObjectEditor, Object)>
    //   30   65:astore          5
            addChildrenToTree(root, hpp);
    //   31   67:aload_0         
    //   32   68:aload           5
    //   33   70:aload           4
    //   34   72:invokevirtual   #666 <Method void addChildrenToTree(GenericObjectEditor$GOETreeNode, HierarchyPropertyParser)>
            if(superRoot == null)
    //*  35   75:aload_2         
    //*  36   76:ifnonnull       85
                superRoot = root;
    //   37   79:aload           5
    //   38   81:astore_2        
            else
    //*  39   82:goto            91
                superRoot.add(root);
    //   40   85:aload_2         
    //   41   86:aload           5
    //   42   88:invokevirtual   #669 <Method void GenericObjectEditor$GOETreeNode.add(javax.swing.tree.MutableTreeNode)>
        }

    //   43   91:aload_3         
    //   44   92:invokeinterface #107 <Method boolean Enumeration.hasMoreElements()>
    //   45   97:ifne            33
        JTree tree = new JTree(superRoot);
    //   46  100:new             #625 <Class JTree>
    //   47  103:dup             
    //   48  104:aload_2         
    //   49  105:invokespecial   #672 <Method void JTree(javax.swing.tree.TreeNode)>
    //   50  108:astore          5
        return tree;
    //   51  110:aload           5
    //   52  112:areturn         
    }

    protected void addChildrenToTree(GOETreeNode tree, HierarchyPropertyParser hpp)
    {
        try
        {
            for(int i = 0; i < hpp.numChildren(); i++)
    //*   0    0:iconst_0        
    //*   1    1:istore_3        
    //*   2    2:goto            77
            {
                hpp.goToChild(i);
    //    3    5:aload_2         
    //    4    6:iload_3         
    //    5    7:invokevirtual   #373 <Method void HierarchyPropertyParser.goToChild(int)>
                GOETreeNode child = new GOETreeNode(hpp.getValue());
    //    6   10:new             #596 <Class GenericObjectEditor$GOETreeNode>
    //    7   13:dup             
    //    8   14:aload_0         
    //    9   15:aload_2         
    //   10   16:invokevirtual   #662 <Method String HierarchyPropertyParser.getValue()>
    //   11   19:invokespecial   #660 <Method void GenericObjectEditor$GOETreeNode(GenericObjectEditor, Object)>
    //   12   22:astore          4
                if(m_Object != null && m_Object.getClass().getName().equals(hpp.fullValue()))
    //*  13   24:aload_0         
    //*  14   25:getfield        #347 <Field Object m_Object>
    //*  15   28:ifnull          57
    //*  16   31:aload_0         
    //*  17   32:getfield        #347 <Field Object m_Object>
    //*  18   35:invokevirtual   #223 <Method Class Object.getClass()>
    //*  19   38:invokevirtual   #329 <Method String Class.getName()>
    //*  20   41:aload_2         
    //*  21   42:invokevirtual   #379 <Method String HierarchyPropertyParser.fullValue()>
    //*  22   45:invokevirtual   #674 <Method boolean String.equals(Object)>
    //*  23   48:ifeq            57
                    m_treeNodeOfCurrentObject = child;
    //   24   51:aload_0         
    //   25   52:aload           4
    //   26   54:putfield        #612 <Field GenericObjectEditor$GOETreeNode m_treeNodeOfCurrentObject>
                tree.add(child);
    //   27   57:aload_1         
    //   28   58:aload           4
    //   29   60:invokevirtual   #669 <Method void GenericObjectEditor$GOETreeNode.add(javax.swing.tree.MutableTreeNode)>
                addChildrenToTree(child, hpp);
    //   30   63:aload_0         
    //   31   64:aload           4
    //   32   66:aload_2         
    //   33   67:invokevirtual   #666 <Method void addChildrenToTree(GenericObjectEditor$GOETreeNode, HierarchyPropertyParser)>
                hpp.goToParent();
    //   34   70:aload_2         
    //   35   71:invokevirtual   #677 <Method void HierarchyPropertyParser.goToParent()>
            }

    //   36   74:iinc            3  1
    //   37   77:iload_3         
    //   38   78:aload_2         
    //   39   79:invokevirtual   #680 <Method int HierarchyPropertyParser.numChildren()>
    //   40   82:icmplt          5
        }
    //*  41   85:goto            93
        catch(Exception e)
    //*  42   88:astore_3        
        {
            e.printStackTrace();
    //   43   89:aload_3         
    //   44   90:invokevirtual   #181 <Method void Exception.printStackTrace()>
        }
    //   45   93:return          
    }

    protected void classSelected(String className)
    {
        try
        {
            if(m_Object != null && m_Object.getClass().getName().equals(className))
    //*   0    0:aload_0         
    //*   1    1:getfield        #347 <Field Object m_Object>
    //*   2    4:ifnull          25
    //*   3    7:aload_0         
    //*   4    8:getfield        #347 <Field Object m_Object>
    //*   5   11:invokevirtual   #223 <Method Class Object.getClass()>
    //*   6   14:invokevirtual   #329 <Method String Class.getName()>
    //*   7   17:aload_1         
    //*   8   18:invokevirtual   #674 <Method boolean String.equals(Object)>
    //*   9   21:ifeq            25
                return;
    //   10   24:return          
            setValue(Class.forName(className).newInstance());
    //   11   25:aload_0         
    //   12   26:aload_1         
    //   13   27:invokestatic    #213 <Method Class Class.forName(String)>
    //   14   30:invokevirtual   #381 <Method Object Class.newInstance()>
    //   15   33:invokevirtual   #384 <Method void setValue(Object)>
            if(m_EditorComponent != null)
    //*  16   36:aload_0         
    //*  17   37:getfield        #398 <Field GenericObjectEditor$GOEPanel m_EditorComponent>
    //*  18   40:ifnull          135
                m_EditorComponent.updateChildPropertySheet();
    //   19   43:aload_0         
    //   20   44:getfield        #398 <Field GenericObjectEditor$GOEPanel m_EditorComponent>
    //   21   47:invokevirtual   #415 <Method void GenericObjectEditor$GOEPanel.updateChildPropertySheet()>
        }
    //*  22   50:goto            135
        catch(Exception ex)
    //*  23   53:astore_2        
        {
            JOptionPane.showMessageDialog(null, (new StringBuilder("Could not create an example of\n")).append(className).append("\n").append("from the current classpath").toString(), "Class load failed", 0);
    //   24   54:aconst_null     
    //   25   55:new             #66  <Class StringBuilder>
    //   26   58:dup             
    //   27   59:ldc2            #684 <String "Could not create an example of\n">
    //   28   62:invokespecial   #71  <Method void StringBuilder(String)>
    //   29   65:aload_1         
    //   30   66:invokevirtual   #81  <Method StringBuilder StringBuilder.append(String)>
    //   31   69:ldc2            #686 <String "\n">
    //   32   72:invokevirtual   #81  <Method StringBuilder StringBuilder.append(String)>
    //   33   75:ldc2            #688 <String "from the current classpath">
    //   34   78:invokevirtual   #81  <Method StringBuilder StringBuilder.append(String)>
    //   35   81:invokevirtual   #82  <Method String StringBuilder.toString()>
    //   36   84:ldc2            #690 <String "Class load failed">
    //   37   87:iconst_0        
    //   38   88:invokestatic    #90  <Method void JOptionPane.showMessageDialog(Component, Object, String, int)>
            ex.printStackTrace();
    //   39   91:aload_2         
    //   40   92:invokevirtual   #181 <Method void Exception.printStackTrace()>
            try
            {
                if(m_Backup != null)
    //*  41   95:aload_0         
    //*  42   96:getfield        #249 <Field Object m_Backup>
    //*  43   99:ifnull          113
                    setValue(m_Backup);
    //   44  102:aload_0         
    //   45  103:aload_0         
    //   46  104:getfield        #249 <Field Object m_Backup>
    //   47  107:invokevirtual   #384 <Method void setValue(Object)>
                else
    //*  48  110:goto            135
                    setDefaultValue();
    //   49  113:aload_0         
    //   50  114:invokevirtual   #692 <Method void setDefaultValue()>
            }
    //*  51  117:goto            135
            catch(Exception e)
    //*  52  120:astore_3        
            {
                System.err.println(ex.getMessage());
    //   53  121:getstatic       #170 <Field PrintStream System.err>
    //   54  124:aload_2         
    //   55  125:invokevirtual   #695 <Method String Exception.getMessage()>
    //   56  128:invokevirtual   #177 <Method void PrintStream.println(String)>
                ex.printStackTrace();
    //   57  131:aload_2         
    //   58  132:invokevirtual   #181 <Method void Exception.printStackTrace()>
            }
        }
    //   59  135:return          
    }

    public void setCapabilitiesFilter(Capabilities value)
    {
        m_CapabilitiesFilter = new Capabilities(null);
    //    0    0:aload_0         
    //    1    1:new             #699 <Class Capabilities>
    //    2    4:dup             
    //    3    5:aconst_null     
    //    4    6:invokespecial   #702 <Method void Capabilities(CapabilitiesHandler)>
    //    5    9:putfield        #160 <Field Capabilities m_CapabilitiesFilter>
        m_CapabilitiesFilter.assign(value);
    //    6   12:aload_0         
    //    7   13:getfield        #160 <Field Capabilities m_CapabilitiesFilter>
    //    8   16:aload_1         
    //    9   17:invokevirtual   #705 <Method void Capabilities.assign(Capabilities)>
    //   10   20:return          
    }

    public Capabilities getCapabilitiesFilter()
    {
        return m_CapabilitiesFilter;
    //    0    0:aload_0         
    //    1    1:getfield        #160 <Field Capabilities m_CapabilitiesFilter>
    //    2    4:areturn         
    }

    public void removeCapabilitiesFilter()
    {
        m_CapabilitiesFilter = null;
    //    0    0:aload_0         
    //    1    1:aconst_null     
    //    2    2:putfield        #160 <Field Capabilities m_CapabilitiesFilter>
    //    3    5:return          
    }

    public static Object makeCopy(Object source)
        throws Exception
    {
        SerializedObject so = new SerializedObject(source);
    //    0    0:new             #711 <Class SerializedObject>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:invokespecial   #712 <Method void SerializedObject(Object)>
    //    4    8:astore_1        
        Object result = so.getObject();
    //    5    9:aload_1         
    //    6   10:invokevirtual   #715 <Method Object SerializedObject.getObject()>
    //    7   13:astore_2        
        return result;
    //    8   14:aload_2         
    //    9   15:areturn         
    }

    public static Vector getClassnames(String property)
    {
        Vector result = new Vector();
    //    0    0:new             #281 <Class Vector>
    //    1    3:dup             
    //    2    4:invokespecial   #282 <Method void Vector()>
    //    3    7:astore_1        
        String value = EDITOR_PROPERTIES.getProperty(property, "").replaceAll(" ", "").trim();
    //    4    8:getstatic       #64  <Field Properties EDITOR_PROPERTIES>
    //    5   11:aload_0         
    //    6   12:ldc1            #188 <String "">
    //    7   14:invokevirtual   #191 <Method String Properties.getProperty(String, String)>
    //    8   17:ldc2            #485 <String " ">
    //    9   20:ldc1            #188 <String "">
    //   10   22:invokevirtual   #725 <Method String String.replaceAll(String, String)>
    //   11   25:invokevirtual   #728 <Method String String.trim()>
    //   12   28:astore_2        
        if(value.length() > 0)
    //*  13   29:aload_2         
    //*  14   30:invokevirtual   #731 <Method int String.length()>
    //*  15   33:ifle            69
        {
            String items[] = value.split(",");
    //   16   36:aload_2         
    //   17   37:ldc2            #302 <String ",">
    //   18   40:invokevirtual   #735 <Method String[] String.split(String)>
    //   19   43:astore_3        
            for(int i = 0; i < items.length; i++)
    //*  20   44:iconst_0        
    //*  21   45:istore          4
    //*  22   47:goto            62
                result.add(items[i]);
    //   23   50:aload_1         
    //   24   51:aload_3         
    //   25   52:iload           4
    //   26   54:aaload          
    //   27   55:invokevirtual   #293 <Method boolean Vector.add(Object)>
    //   28   58:pop             

    //   29   59:iinc            4  1
    //   30   62:iload           4
    //   31   64:aload_3         
    //   32   65:arraylength     
    //   33   66:icmplt          50
        }
        return result;
    //   34   69:aload_1         
    //   35   70:areturn         
    }

    public static void main(String args[])
    {
        try
        {
            registerEditors();
    //    0    0:invokestatic    #744 <Method void registerEditors()>
            GenericObjectEditor ce = new GenericObjectEditor(true);
    //    1    3:new             #2   <Class GenericObjectEditor>
    //    2    6:dup             
    //    3    7:iconst_1        
    //    4    8:invokespecial   #146 <Method void GenericObjectEditor(boolean)>
    //    5   11:astore_1        
            ce.setClassType(rm/rolemining/HierarchicalMiner);
    //    6   12:aload_1         
    //    7   13:ldc2            #746 <Class HierarchicalMiner>
    //    8   16:invokevirtual   #748 <Method void setClassType(Class)>
            Object initial = new HierarchicalMiner();
    //    9   19:new             #746 <Class HierarchicalMiner>
    //   10   22:dup             
    //   11   23:invokespecial   #749 <Method void HierarchicalMiner()>
    //   12   26:astore_2        
            if(args.length > 0)
    //*  13   27:aload_0         
    //*  14   28:arraylength     
    //*  15   29:ifle            73
            {
                ce.setClassType(Class.forName(args[0]));
    //   16   32:aload_1         
    //   17   33:aload_0         
    //   18   34:iconst_0        
    //   19   35:aaload          
    //   20   36:invokestatic    #213 <Method Class Class.forName(String)>
    //   21   39:invokevirtual   #748 <Method void setClassType(Class)>
                if(args.length > 1)
    //*  22   42:aload_0         
    //*  23   43:arraylength     
    //*  24   44:iconst_1        
    //*  25   45:icmple          66
                {
                    initial = Class.forName(args[1]).newInstance();
    //   26   48:aload_0         
    //   27   49:iconst_1        
    //   28   50:aaload          
    //   29   51:invokestatic    #213 <Method Class Class.forName(String)>
    //   30   54:invokevirtual   #381 <Method Object Class.newInstance()>
    //   31   57:astore_2        
                    ce.setValue(initial);
    //   32   58:aload_1         
    //   33   59:aload_2         
    //   34   60:invokevirtual   #384 <Method void setValue(Object)>
                } else
    //*  35   63:goto            78
                {
                    ce.setDefaultValue();
    //   36   66:aload_1         
    //   37   67:invokevirtual   #692 <Method void setDefaultValue()>
                }
            } else
    //*  38   70:goto            78
            {
                ce.setValue(initial);
    //   39   73:aload_1         
    //   40   74:aload_2         
    //   41   75:invokevirtual   #384 <Method void setValue(Object)>
            }
            PropertyDialog pd = new PropertyDialog(null, ce, 100, 100);
    //   42   78:new             #751 <Class PropertyDialog>
    //   43   81:dup             
    //   44   82:aconst_null     
    //   45   83:aload_1         
    //   46   84:bipush          100
    //   47   86:bipush          100
    //   48   88:invokespecial   #754 <Method void PropertyDialog(java.awt.Frame, PropertyEditor, int, int)>
    //   49   91:astore_3        
            pd.addWindowListener(new WindowAdapter() {

                public void windowClosing(WindowEvent e)
                {
                    PropertyEditor pe = ((PropertyDialog)e.getSource()).getEditor();
                //    0    0:aload_1         
                //    1    1:invokevirtual   #21  <Method Object WindowEvent.getSource()>
                //    2    4:checkcast       #23  <Class PropertyDialog>
                //    3    7:invokevirtual   #27  <Method PropertyEditor PropertyDialog.getEditor()>
                //    4   10:astore_2        
                    Object c = pe.getValue();
                //    5   11:aload_2         
                //    6   12:invokeinterface #32  <Method Object PropertyEditor.getValue()>
                //    7   17:astore_3        
                    String options = "";
                //    8   18:ldc1            #34  <String "">
                //    9   20:astore          4
                    if(c instanceof OptionHandler)
                //*  10   22:aload_3         
                //*  11   23:instanceof      #36  <Class OptionHandler>
                //*  12   26:ifeq            43
                        options = Utils.joinOptions(((OptionHandler)c).getOptions());
                //   13   29:aload_3         
                //   14   30:checkcast       #36  <Class OptionHandler>
                //   15   33:invokeinterface #40  <Method String[] OptionHandler.getOptions()>
                //   16   38:invokestatic    #46  <Method String Utils.joinOptions(String[])>
                //   17   41:astore          4
                    System.out.println((new StringBuilder(String.valueOf(c.getClass().getName()))).append(" ").append(options).toString());
                //   18   43:getstatic       #52  <Field PrintStream System.out>
                //   19   46:new             #54  <Class StringBuilder>
                //   20   49:dup             
                //   21   50:aload_3         
                //   22   51:invokevirtual   #60  <Method Class Object.getClass()>
                //   23   54:invokevirtual   #66  <Method String Class.getName()>
                //   24   57:invokestatic    #72  <Method String String.valueOf(Object)>
                //   25   60:invokespecial   #75  <Method void StringBuilder(String)>
                //   26   63:ldc1            #77  <String " ">
                //   27   65:invokevirtual   #81  <Method StringBuilder StringBuilder.append(String)>
                //   28   68:aload           4
                //   29   70:invokevirtual   #81  <Method StringBuilder StringBuilder.append(String)>
                //   30   73:invokevirtual   #84  <Method String StringBuilder.toString()>
                //   31   76:invokevirtual   #89  <Method void PrintStream.println(String)>
                    System.exit(0);
                //   32   79:iconst_0        
                //   33   80:invokestatic    #93  <Method void System.exit(int)>
                //   34   83:return          
                }

            }
);
    //   50   92:aload_3         
    //   51   93:new             #756 <Class GenericObjectEditor$14>
    //   52   96:dup             
    //   53   97:invokespecial   #757 <Method void GenericObjectEditor$14()>
    //   54  100:invokevirtual   #761 <Method void PropertyDialog.addWindowListener(java.awt.event.WindowListener)>
            pd.setVisible(true);
    //   55  103:aload_3         
    //   56  104:iconst_1        
    //   57  105:invokevirtual   #764 <Method void PropertyDialog.setVisible(boolean)>
        }
    //*  58  108:goto            126
        catch(Exception ex)
    //*  59  111:astore_1        
        {
            ex.printStackTrace();
    //   60  112:aload_1         
    //   61  113:invokevirtual   #181 <Method void Exception.printStackTrace()>
            System.err.println(ex.getMessage());
    //   62  116:getstatic       #170 <Field PrintStream System.err>
    //   63  119:aload_1         
    //   64  120:invokevirtual   #695 <Method String Exception.getMessage()>
    //   65  123:invokevirtual   #177 <Method void PrintStream.println(String)>
        }
    //   66  126:return          
    }

    protected Object m_Object;
    protected Object m_Backup;
    protected PropertyChangeSupport m_Support;
    protected Class m_ClassType;
    protected Hashtable m_ObjectNames;
    protected GOEPanel m_EditorComponent;
    protected boolean m_Enabled;
    protected static String PROPERTY_FILE;
    protected static Properties EDITOR_PROPERTIES;
    public static final String GUIEDITORS_PROPERTY_FILE = "rm/gui/GUIEditors.props";
    protected GOETreeNode m_treeNodeOfCurrentObject;
    protected PropertyPanel m_ObjectPropertyPanel;
    protected boolean m_canChangeClassInDialog;
    protected static boolean m_EditorsRegistered;
    protected Capabilities m_CapabilitiesFilter;
    static Class class$0;

    static 
    {
        PROPERTY_FILE = "rm/gui/GenericObjectEditor.props";
    //    0    0:ldc1            #43  <String "rm/gui/GenericObjectEditor.props">
    //    1    2:putstatic       #45  <Field String PROPERTY_FILE>
        try
        {
            GenericPropertiesCreator creator = new GenericPropertiesCreator();
    //    2    5:new             #47  <Class GenericPropertiesCreator>
    //    3    8:dup             
    //    4    9:invokespecial   #50  <Method void GenericPropertiesCreator()>
    //    5   12:astore_0        
            if(creator.useDynamic())
    //*   6   13:aload_0         
    //*   7   14:invokevirtual   #54  <Method boolean GenericPropertiesCreator.useDynamic()>
    //*   8   17:ifeq            65
                try
                {
                    creator.execute(false);
    //    9   20:aload_0         
    //   10   21:iconst_0        
    //   11   22:invokevirtual   #58  <Method void GenericPropertiesCreator.execute(boolean)>
                    EDITOR_PROPERTIES = creator.getOutputProperties();
    //   12   25:aload_0         
    //   13   26:invokevirtual   #62  <Method Properties GenericPropertiesCreator.getOutputProperties()>
    //   14   29:putstatic       #64  <Field Properties EDITOR_PROPERTIES>
                }
    //*  15   32:goto            195
                catch(Exception e)
    //*  16   35:astore_1        
                {
                    JOptionPane.showMessageDialog(null, (new StringBuilder("Could not determine the properties for the generic object\neditor. This exception was produced:\n")).append(e.toString()).toString(), "GenericObjectEditor", 0);
    //   17   36:aconst_null     
    //   18   37:new             #66  <Class StringBuilder>
    //   19   40:dup             
    //   20   41:ldc1            #68  <String "Could not determine the properties for the generic object\neditor. This exception was produced:\n">
    //   21   43:invokespecial   #71  <Method void StringBuilder(String)>
    //   22   46:aload_1         
    //   23   47:invokevirtual   #77  <Method String Exception.toString()>
    //   24   50:invokevirtual   #81  <Method StringBuilder StringBuilder.append(String)>
    //   25   53:invokevirtual   #82  <Method String StringBuilder.toString()>
    //   26   56:ldc1            #84  <String "GenericObjectEditor">
    //   27   58:iconst_0        
    //   28   59:invokestatic    #90  <Method void JOptionPane.showMessageDialog(Component, Object, String, int)>
                }
            else
    //*  29   62:goto            195
                try
                {
                    EDITOR_PROPERTIES = Utils.readProperties(PROPERTY_FILE);
    //   30   65:getstatic       #45  <Field String PROPERTY_FILE>
    //   31   68:invokestatic    #96  <Method Properties Utils.readProperties(String)>
    //   32   71:putstatic       #64  <Field Properties EDITOR_PROPERTIES>
                    Enumeration keys = EDITOR_PROPERTIES.propertyNames();
    //   33   74:getstatic       #64  <Field Properties EDITOR_PROPERTIES>
    //   34   77:invokevirtual   #102 <Method Enumeration Properties.propertyNames()>
    //   35   80:astore_1        
                    if(!keys.hasMoreElements())
    //*  36   81:aload_1         
    //*  37   82:invokeinterface #107 <Method boolean Enumeration.hasMoreElements()>
    //*  38   87:ifne            195
                        throw new Exception("Failed to read a property file for the generic object editor");
    //   39   90:new             #73  <Class Exception>
    //   40   93:dup             
    //   41   94:ldc1            #109 <String "Failed to read a property file for the generic object editor">
    //   42   96:invokespecial   #110 <Method void Exception(String)>
    //   43   99:athrow          
                }
    //*  44  100:goto            195
                catch(Exception ex)
    //*  45  103:astore_1        
                {
                    JOptionPane.showMessageDialog(null, (new StringBuilder("Could not read a configuration file for the generic object\neditor. An example file is included with the Weka distribution.\nThis file should be named \"")).append(PROPERTY_FILE).append("\" and\n").append("should be placed either in your user home (which is set\n").append("to \"").append(System.getProperties().getProperty("user.home")).append("\")\n").append("or the directory that java was started from\n").toString(), "GenericObjectEditor", 0);
    //   46  104:aconst_null     
    //   47  105:new             #66  <Class StringBuilder>
    //   48  108:dup             
    //   49  109:ldc1            #112 <String "Could not read a configuration file for the generic object\neditor. An example file is included with the Weka distribution.\nThis file should be named \"">
    //   50  111:invokespecial   #71  <Method void StringBuilder(String)>
    //   51  114:getstatic       #45  <Field String PROPERTY_FILE>
    //   52  117:invokevirtual   #81  <Method StringBuilder StringBuilder.append(String)>
    //   53  120:ldc1            #114 <String "\" and\n">
    //   54  122:invokevirtual   #81  <Method StringBuilder StringBuilder.append(String)>
    //   55  125:ldc1            #116 <String "should be placed either in your user home (which is set\n">
    //   56  127:invokevirtual   #81  <Method StringBuilder StringBuilder.append(String)>
    //   57  130:ldc1            #118 <String "to \"">
    //   58  132:invokevirtual   #81  <Method StringBuilder StringBuilder.append(String)>
    //   59  135:invokestatic    #123 <Method Properties System.getProperties()>
    //   60  138:ldc1            #125 <String "user.home">
    //   61  140:invokevirtual   #129 <Method String Properties.getProperty(String)>
    //   62  143:invokevirtual   #81  <Method StringBuilder StringBuilder.append(String)>
    //   63  146:ldc1            #131 <String "\")\n">
    //   64  148:invokevirtual   #81  <Method StringBuilder StringBuilder.append(String)>
    //   65  151:ldc1            #133 <String "or the directory that java was started from\n">
    //   66  153:invokevirtual   #81  <Method StringBuilder StringBuilder.append(String)>
    //   67  156:invokevirtual   #82  <Method String StringBuilder.toString()>
    //   68  159:ldc1            #84  <String "GenericObjectEditor">
    //   69  161:iconst_0        
    //   70  162:invokestatic    #90  <Method void JOptionPane.showMessageDialog(Component, Object, String, int)>
                }
        }
    //*  71  165:goto            195
        catch(Exception e)
    //*  72  168:astore_0        
        {
            JOptionPane.showMessageDialog(null, (new StringBuilder("Could not initialize the GenericPropertiesCreator. This exception was produced:\n")).append(e.toString()).toString(), "GenericObjectEditor", 0);
    //   73  169:aconst_null     
    //   74  170:new             #66  <Class StringBuilder>
    //   75  173:dup             
    //   76  174:ldc1            #135 <String "Could not initialize the GenericPropertiesCreator. This exception was produced:\n">
    //   77  176:invokespecial   #71  <Method void StringBuilder(String)>
    //   78  179:aload_0         
    //   79  180:invokevirtual   #77  <Method String Exception.toString()>
    //   80  183:invokevirtual   #81  <Method StringBuilder StringBuilder.append(String)>
    //   81  186:invokevirtual   #82  <Method String StringBuilder.toString()>
    //   82  189:ldc1            #84  <String "GenericObjectEditor">
    //   83  191:iconst_0        
    //   84  192:invokestatic    #90  <Method void JOptionPane.showMessageDialog(Component, Object, String, int)>
        }
    //*  85  195:return          
    }
}
