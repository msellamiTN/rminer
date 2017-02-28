// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   PropertySheetPanel.java

package rm.gui;

import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import javax.swing.*;
import rm.core.*;

// Referenced classes of package rm.gui:
//            GenericObjectEditor, PropertyPanel, PropertyValueSelector, PropertyText, 
//            PropertyDialog

public class PropertySheetPanel extends JPanel
    implements PropertyChangeListener
{
    protected class CapabilitiesHelpDialog extends JDialog
        implements PropertyChangeListener
    {

        protected void initialize()
        {
            setTitle("Information about Capabilities");
        //    0    0:aload_0         
        //    1    1:ldc1            #39  <String "Information about Capabilities">
        //    2    3:invokevirtual   #43  <Method void setTitle(String)>
            m_Self = this;
        //    3    6:aload_0         
        //    4    7:aload_0         
        //    5    8:putfield        #45  <Field PropertySheetPanel$CapabilitiesHelpDialog m_Self>
            m_CapabilitiesText = new JTextArea();
        //    6   11:aload_0         
        //    7   12:getfield        #20  <Field PropertySheetPanel this$0>
        //    8   15:new             #47  <Class JTextArea>
        //    9   18:dup             
        //   10   19:invokespecial   #49  <Method void JTextArea()>
        //   11   22:invokestatic    #55  <Method void PropertySheetPanel.access$0(PropertySheetPanel, JTextArea)>
            m_CapabilitiesText.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        //   12   25:aload_0         
        //   13   26:getfield        #20  <Field PropertySheetPanel this$0>
        //   14   29:invokestatic    #59  <Method JTextArea PropertySheetPanel.access$1(PropertySheetPanel)>
        //   15   32:iconst_5        
        //   16   33:iconst_5        
        //   17   34:iconst_5        
        //   18   35:iconst_5        
        //   19   36:invokestatic    #65  <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
        //   20   39:invokevirtual   #69  <Method void JTextArea.setBorder(javax.swing.border.Border)>
            m_CapabilitiesText.setLineWrap(true);
        //   21   42:aload_0         
        //   22   43:getfield        #20  <Field PropertySheetPanel this$0>
        //   23   46:invokestatic    #59  <Method JTextArea PropertySheetPanel.access$1(PropertySheetPanel)>
        //   24   49:iconst_1        
        //   25   50:invokevirtual   #73  <Method void JTextArea.setLineWrap(boolean)>
            m_CapabilitiesText.setWrapStyleWord(true);
        //   26   53:aload_0         
        //   27   54:getfield        #20  <Field PropertySheetPanel this$0>
        //   28   57:invokestatic    #59  <Method JTextArea PropertySheetPanel.access$1(PropertySheetPanel)>
        //   29   60:iconst_1        
        //   30   61:invokevirtual   #76  <Method void JTextArea.setWrapStyleWord(boolean)>
            m_CapabilitiesText.setEditable(false);
        //   31   64:aload_0         
        //   32   65:getfield        #20  <Field PropertySheetPanel this$0>
        //   33   68:invokestatic    #59  <Method JTextArea PropertySheetPanel.access$1(PropertySheetPanel)>
        //   34   71:iconst_0        
        //   35   72:invokevirtual   #79  <Method void JTextArea.setEditable(boolean)>
            updateText();
        //   36   75:aload_0         
        //   37   76:invokevirtual   #82  <Method void updateText()>
            addWindowListener(new WindowAdapter() {

                public void windowClosing(WindowEvent e)
                {
                    m_Self.dispose();
                //    0    0:aload_0         
                //    1    1:getfield        #11  <Field PropertySheetPanel$CapabilitiesHelpDialog this$1>
                //    2    4:invokestatic    #26  <Method PropertySheetPanel$CapabilitiesHelpDialog PropertySheetPanel$CapabilitiesHelpDialog.access$0(PropertySheetPanel$CapabilitiesHelpDialog)>
                //    3    7:invokevirtual   #29  <Method void PropertySheetPanel$CapabilitiesHelpDialog.dispose()>
                    if(m_CapabilitiesDialog == m_Self)
                //*   4   10:aload_0         
                //*   5   11:getfield        #11  <Field PropertySheetPanel$CapabilitiesHelpDialog this$1>
                //*   6   14:invokestatic    #33  <Method PropertySheetPanel PropertySheetPanel$CapabilitiesHelpDialog.access$1(PropertySheetPanel$CapabilitiesHelpDialog)>
                //*   7   17:invokestatic    #39  <Method PropertySheetPanel$CapabilitiesHelpDialog PropertySheetPanel.access$2(PropertySheetPanel)>
                //*   8   20:aload_0         
                //*   9   21:getfield        #11  <Field PropertySheetPanel$CapabilitiesHelpDialog this$1>
                //*  10   24:invokestatic    #26  <Method PropertySheetPanel$CapabilitiesHelpDialog PropertySheetPanel$CapabilitiesHelpDialog.access$0(PropertySheetPanel$CapabilitiesHelpDialog)>
                //*  11   27:if_acmpne       44
                        m_CapabilitiesBut.setEnabled(true);
                //   12   30:aload_0         
                //   13   31:getfield        #11  <Field PropertySheetPanel$CapabilitiesHelpDialog this$1>
                //   14   34:invokestatic    #33  <Method PropertySheetPanel PropertySheetPanel$CapabilitiesHelpDialog.access$1(PropertySheetPanel$CapabilitiesHelpDialog)>
                //   15   37:invokestatic    #43  <Method JButton PropertySheetPanel.access$3(PropertySheetPanel)>
                //   16   40:iconst_1        
                //   17   41:invokevirtual   #49  <Method void JButton.setEnabled(boolean)>
                //   18   44:return          
                }

                final CapabilitiesHelpDialog this$1;

                
                {
                    this$1 = CapabilitiesHelpDialog.this;
                //    0    0:aload_0         
                //    1    1:aload_1         
                //    2    2:putfield        #11  <Field PropertySheetPanel$CapabilitiesHelpDialog this$1>
                    super();
                //    3    5:aload_0         
                //    4    6:invokespecial   #14  <Method void WindowAdapter()>
                //    5    9:return          
                }
            }
);
        //   38   79:aload_0         
        //   39   80:new             #84  <Class PropertySheetPanel$1>
        //   40   83:dup             
        //   41   84:aload_0         
        //   42   85:invokespecial   #87  <Method void PropertySheetPanel$1(PropertySheetPanel$CapabilitiesHelpDialog)>
        //   43   88:invokevirtual   #91  <Method void addWindowListener(java.awt.event.WindowListener)>
            getContentPane().setLayout(new BorderLayout());
        //   44   91:aload_0         
        //   45   92:invokevirtual   #95  <Method Container getContentPane()>
        //   46   95:new             #97  <Class BorderLayout>
        //   47   98:dup             
        //   48   99:invokespecial   #98  <Method void BorderLayout()>
        //   49  102:invokevirtual   #104 <Method void Container.setLayout(java.awt.LayoutManager)>
            getContentPane().add(new JScrollPane(m_CapabilitiesText), "Center");
        //   50  105:aload_0         
        //   51  106:invokevirtual   #95  <Method Container getContentPane()>
        //   52  109:new             #106 <Class JScrollPane>
        //   53  112:dup             
        //   54  113:aload_0         
        //   55  114:getfield        #20  <Field PropertySheetPanel this$0>
        //   56  117:invokestatic    #59  <Method JTextArea PropertySheetPanel.access$1(PropertySheetPanel)>
        //   57  120:invokespecial   #109 <Method void JScrollPane(Component)>
        //   58  123:ldc1            #111 <String "Center">
        //   59  125:invokevirtual   #115 <Method void Container.add(Component, Object)>
            pack();
        //   60  128:aload_0         
        //   61  129:invokevirtual   #118 <Method void pack()>
        //   62  132:return          
        }

        protected String listCapabilities(Capabilities c)
        {
            String result = "";
        //    0    0:ldc1            #122 <String "">
        //    1    2:astore_2        
            for(Iterator iter = c.capabilities(); iter.hasNext();)
        //*   2    3:aload_1         
        //*   3    4:invokevirtual   #128 <Method Iterator Capabilities.capabilities()>
        //*   4    7:astore_3        
        //*   5    8:goto            65
            {
                if(result.length() != 0)
        //*   6   11:aload_2         
        //*   7   12:invokevirtual   #134 <Method int String.length()>
        //*   8   15:ifeq            38
                    result = (new StringBuilder(String.valueOf(result))).append(", ").toString();
        //    9   18:new             #136 <Class StringBuilder>
        //   10   21:dup             
        //   11   22:aload_2         
        //   12   23:invokestatic    #140 <Method String String.valueOf(Object)>
        //   13   26:invokespecial   #142 <Method void StringBuilder(String)>
        //   14   29:ldc1            #144 <String ", ">
        //   15   31:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
        //   16   34:invokevirtual   #152 <Method String StringBuilder.toString()>
        //   17   37:astore_2        
                result = (new StringBuilder(String.valueOf(result))).append(iter.next().toString()).toString();
        //   18   38:new             #136 <Class StringBuilder>
        //   19   41:dup             
        //   20   42:aload_2         
        //   21   43:invokestatic    #140 <Method String String.valueOf(Object)>
        //   22   46:invokespecial   #142 <Method void StringBuilder(String)>
        //   23   49:aload_3         
        //   24   50:invokeinterface #158 <Method Object Iterator.next()>
        //   25   55:invokevirtual   #161 <Method String Object.toString()>
        //   26   58:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
        //   27   61:invokevirtual   #152 <Method String StringBuilder.toString()>
        //   28   64:astore_2        
            }

        //   29   65:aload_3         
        //   30   66:invokeinterface #165 <Method boolean Iterator.hasNext()>
        //   31   71:ifne            11
            return result;
        //   32   74:aload_2         
        //   33   75:areturn         
        }

        protected String addCapabilities(String title, Capabilities c)
        {
            String result = (new StringBuilder(String.valueOf(title))).append("\n").toString();
        //    0    0:new             #136 <Class StringBuilder>
        //    1    3:dup             
        //    2    4:aload_1         
        //    3    5:invokestatic    #140 <Method String String.valueOf(Object)>
        //    4    8:invokespecial   #142 <Method void StringBuilder(String)>
        //    5   11:ldc1            #175 <String "\n">
        //    6   13:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
        //    7   16:invokevirtual   #152 <Method String StringBuilder.toString()>
        //    8   19:astore_3        
            String caps = listCapabilities(c.getClassCapabilities());
        //    9   20:aload_0         
        //   10   21:aload_2         
        //   11   22:invokevirtual   #179 <Method Capabilities Capabilities.getClassCapabilities()>
        //   12   25:invokevirtual   #181 <Method String listCapabilities(Capabilities)>
        //   13   28:astore          4
            if(caps.length() != 0)
        //*  14   30:aload           4
        //*  15   32:invokevirtual   #134 <Method int String.length()>
        //*  16   35:ifeq            98
            {
                result = (new StringBuilder(String.valueOf(result))).append("Class -- ").toString();
        //   17   38:new             #136 <Class StringBuilder>
        //   18   41:dup             
        //   19   42:aload_3         
        //   20   43:invokestatic    #140 <Method String String.valueOf(Object)>
        //   21   46:invokespecial   #142 <Method void StringBuilder(String)>
        //   22   49:ldc1            #183 <String "Class -- ">
        //   23   51:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
        //   24   54:invokevirtual   #152 <Method String StringBuilder.toString()>
        //   25   57:astore_3        
                result = (new StringBuilder(String.valueOf(result))).append(caps).toString();
        //   26   58:new             #136 <Class StringBuilder>
        //   27   61:dup             
        //   28   62:aload_3         
        //   29   63:invokestatic    #140 <Method String String.valueOf(Object)>
        //   30   66:invokespecial   #142 <Method void StringBuilder(String)>
        //   31   69:aload           4
        //   32   71:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
        //   33   74:invokevirtual   #152 <Method String StringBuilder.toString()>
        //   34   77:astore_3        
                result = (new StringBuilder(String.valueOf(result))).append("\n\n").toString();
        //   35   78:new             #136 <Class StringBuilder>
        //   36   81:dup             
        //   37   82:aload_3         
        //   38   83:invokestatic    #140 <Method String String.valueOf(Object)>
        //   39   86:invokespecial   #142 <Method void StringBuilder(String)>
        //   40   89:ldc1            #185 <String "\n\n">
        //   41   91:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
        //   42   94:invokevirtual   #152 <Method String StringBuilder.toString()>
        //   43   97:astore_3        
            }
            caps = listCapabilities(c.getAttributeCapabilities());
        //   44   98:aload_0         
        //   45   99:aload_2         
        //   46  100:invokevirtual   #188 <Method Capabilities Capabilities.getAttributeCapabilities()>
        //   47  103:invokevirtual   #181 <Method String listCapabilities(Capabilities)>
        //   48  106:astore          4
            if(caps.length() != 0)
        //*  49  108:aload           4
        //*  50  110:invokevirtual   #134 <Method int String.length()>
        //*  51  113:ifeq            176
            {
                result = (new StringBuilder(String.valueOf(result))).append("Attributes -- ").toString();
        //   52  116:new             #136 <Class StringBuilder>
        //   53  119:dup             
        //   54  120:aload_3         
        //   55  121:invokestatic    #140 <Method String String.valueOf(Object)>
        //   56  124:invokespecial   #142 <Method void StringBuilder(String)>
        //   57  127:ldc1            #190 <String "Attributes -- ">
        //   58  129:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
        //   59  132:invokevirtual   #152 <Method String StringBuilder.toString()>
        //   60  135:astore_3        
                result = (new StringBuilder(String.valueOf(result))).append(caps).toString();
        //   61  136:new             #136 <Class StringBuilder>
        //   62  139:dup             
        //   63  140:aload_3         
        //   64  141:invokestatic    #140 <Method String String.valueOf(Object)>
        //   65  144:invokespecial   #142 <Method void StringBuilder(String)>
        //   66  147:aload           4
        //   67  149:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
        //   68  152:invokevirtual   #152 <Method String StringBuilder.toString()>
        //   69  155:astore_3        
                result = (new StringBuilder(String.valueOf(result))).append("\n\n").toString();
        //   70  156:new             #136 <Class StringBuilder>
        //   71  159:dup             
        //   72  160:aload_3         
        //   73  161:invokestatic    #140 <Method String String.valueOf(Object)>
        //   74  164:invokespecial   #142 <Method void StringBuilder(String)>
        //   75  167:ldc1            #185 <String "\n\n">
        //   76  169:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
        //   77  172:invokevirtual   #152 <Method String StringBuilder.toString()>
        //   78  175:astore_3        
            }
            caps = listCapabilities(c.getOtherCapabilities());
        //   79  176:aload_0         
        //   80  177:aload_2         
        //   81  178:invokevirtual   #193 <Method Capabilities Capabilities.getOtherCapabilities()>
        //   82  181:invokevirtual   #181 <Method String listCapabilities(Capabilities)>
        //   83  184:astore          4
            if(caps.length() != 0)
        //*  84  186:aload           4
        //*  85  188:invokevirtual   #134 <Method int String.length()>
        //*  86  191:ifeq            254
            {
                result = (new StringBuilder(String.valueOf(result))).append("Other -- ").toString();
        //   87  194:new             #136 <Class StringBuilder>
        //   88  197:dup             
        //   89  198:aload_3         
        //   90  199:invokestatic    #140 <Method String String.valueOf(Object)>
        //   91  202:invokespecial   #142 <Method void StringBuilder(String)>
        //   92  205:ldc1            #195 <String "Other -- ">
        //   93  207:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
        //   94  210:invokevirtual   #152 <Method String StringBuilder.toString()>
        //   95  213:astore_3        
                result = (new StringBuilder(String.valueOf(result))).append(caps).toString();
        //   96  214:new             #136 <Class StringBuilder>
        //   97  217:dup             
        //   98  218:aload_3         
        //   99  219:invokestatic    #140 <Method String String.valueOf(Object)>
        //  100  222:invokespecial   #142 <Method void StringBuilder(String)>
        //  101  225:aload           4
        //  102  227:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
        //  103  230:invokevirtual   #152 <Method String StringBuilder.toString()>
        //  104  233:astore_3        
                result = (new StringBuilder(String.valueOf(result))).append("\n\n").toString();
        //  105  234:new             #136 <Class StringBuilder>
        //  106  237:dup             
        //  107  238:aload_3         
        //  108  239:invokestatic    #140 <Method String String.valueOf(Object)>
        //  109  242:invokespecial   #142 <Method void StringBuilder(String)>
        //  110  245:ldc1            #185 <String "\n\n">
        //  111  247:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
        //  112  250:invokevirtual   #152 <Method String StringBuilder.toString()>
        //  113  253:astore_3        
            }
            result = (new StringBuilder(String.valueOf(result))).append("Additional\n").toString();
        //  114  254:new             #136 <Class StringBuilder>
        //  115  257:dup             
        //  116  258:aload_3         
        //  117  259:invokestatic    #140 <Method String String.valueOf(Object)>
        //  118  262:invokespecial   #142 <Method void StringBuilder(String)>
        //  119  265:ldc1            #197 <String "Additional\n">
        //  120  267:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
        //  121  270:invokevirtual   #152 <Method String StringBuilder.toString()>
        //  122  273:astore_3        
            result = (new StringBuilder(String.valueOf(result))).append("min # of instances: ").append(c.getMinimumNumberInstances()).append("\n").toString();
        //  123  274:new             #136 <Class StringBuilder>
        //  124  277:dup             
        //  125  278:aload_3         
        //  126  279:invokestatic    #140 <Method String String.valueOf(Object)>
        //  127  282:invokespecial   #142 <Method void StringBuilder(String)>
        //  128  285:ldc1            #199 <String "min # of instances: ">
        //  129  287:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
        //  130  290:aload_2         
        //  131  291:invokevirtual   #202 <Method int Capabilities.getMinimumNumberInstances()>
        //  132  294:invokevirtual   #205 <Method StringBuilder StringBuilder.append(int)>
        //  133  297:ldc1            #175 <String "\n">
        //  134  299:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
        //  135  302:invokevirtual   #152 <Method String StringBuilder.toString()>
        //  136  305:astore_3        
            result = (new StringBuilder(String.valueOf(result))).append("\n").toString();
        //  137  306:new             #136 <Class StringBuilder>
        //  138  309:dup             
        //  139  310:aload_3         
        //  140  311:invokestatic    #140 <Method String String.valueOf(Object)>
        //  141  314:invokespecial   #142 <Method void StringBuilder(String)>
        //  142  317:ldc1            #175 <String "\n">
        //  143  319:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
        //  144  322:invokevirtual   #152 <Method String StringBuilder.toString()>
        //  145  325:astore_3        
            return result;
        //  146  326:aload_3         
        //  147  327:areturn         
        }

        protected void updateText()
        {
            StringBuffer helpText = new StringBuffer();
        //    0    0:new             #209 <Class StringBuffer>
        //    1    3:dup             
        //    2    4:invokespecial   #210 <Method void StringBuffer()>
        //    3    7:astore_1        
            if(m_Target instanceof CapabilitiesHandler)
        //*   4    8:aload_0         
        //*   5    9:getfield        #20  <Field PropertySheetPanel this$0>
        //*   6   12:invokestatic    #214 <Method Object PropertySheetPanel.access$4(PropertySheetPanel)>
        //*   7   15:instanceof      #216 <Class CapabilitiesHandler>
        //*   8   18:ifeq            47
                helpText.append(addCapabilities("CAPABILITIES", ((CapabilitiesHandler)m_Target).getCapabilities()));
        //    9   21:aload_1         
        //   10   22:aload_0         
        //   11   23:ldc1            #218 <String "CAPABILITIES">
        //   12   25:aload_0         
        //   13   26:getfield        #20  <Field PropertySheetPanel this$0>
        //   14   29:invokestatic    #214 <Method Object PropertySheetPanel.access$4(PropertySheetPanel)>
        //   15   32:checkcast       #216 <Class CapabilitiesHandler>
        //   16   35:invokeinterface #221 <Method Capabilities CapabilitiesHandler.getCapabilities()>
        //   17   40:invokevirtual   #223 <Method String addCapabilities(String, Capabilities)>
        //   18   43:invokevirtual   #226 <Method StringBuffer StringBuffer.append(String)>
        //   19   46:pop             
            if(m_Target instanceof MultiInstanceCapabilitiesHandler)
        //*  20   47:aload_0         
        //*  21   48:getfield        #20  <Field PropertySheetPanel this$0>
        //*  22   51:invokestatic    #214 <Method Object PropertySheetPanel.access$4(PropertySheetPanel)>
        //*  23   54:instanceof      #228 <Class MultiInstanceCapabilitiesHandler>
        //*  24   57:ifeq            86
                helpText.append(addCapabilities("MI CAPABILITIES", ((MultiInstanceCapabilitiesHandler)m_Target).getMultiInstanceCapabilities()));
        //   25   60:aload_1         
        //   26   61:aload_0         
        //   27   62:ldc1            #230 <String "MI CAPABILITIES">
        //   28   64:aload_0         
        //   29   65:getfield        #20  <Field PropertySheetPanel this$0>
        //   30   68:invokestatic    #214 <Method Object PropertySheetPanel.access$4(PropertySheetPanel)>
        //   31   71:checkcast       #228 <Class MultiInstanceCapabilitiesHandler>
        //   32   74:invokeinterface #233 <Method Capabilities MultiInstanceCapabilitiesHandler.getMultiInstanceCapabilities()>
        //   33   79:invokevirtual   #223 <Method String addCapabilities(String, Capabilities)>
        //   34   82:invokevirtual   #226 <Method StringBuffer StringBuffer.append(String)>
        //   35   85:pop             
            m_CapabilitiesText.setText(helpText.toString());
        //   36   86:aload_0         
        //   37   87:getfield        #20  <Field PropertySheetPanel this$0>
        //   38   90:invokestatic    #59  <Method JTextArea PropertySheetPanel.access$1(PropertySheetPanel)>
        //   39   93:aload_1         
        //   40   94:invokevirtual   #234 <Method String StringBuffer.toString()>
        //   41   97:invokevirtual   #237 <Method void JTextArea.setText(String)>
            m_CapabilitiesText.setCaretPosition(0);
        //   42  100:aload_0         
        //   43  101:getfield        #20  <Field PropertySheetPanel this$0>
        //   44  104:invokestatic    #59  <Method JTextArea PropertySheetPanel.access$1(PropertySheetPanel)>
        //   45  107:iconst_0        
        //   46  108:invokevirtual   #241 <Method void JTextArea.setCaretPosition(int)>
        //   47  111:return          
        }

        public void propertyChange(PropertyChangeEvent evt)
        {
            updateText();
        //    0    0:aload_0         
        //    1    1:invokevirtual   #82  <Method void updateText()>
        //    2    4:return          
        }

        private static final long serialVersionUID = 0xec81403ae2eefdfeL;
        private CapabilitiesHelpDialog m_Self;
        final PropertySheetPanel this$0;


/*
        static CapabilitiesHelpDialog access$0(CapabilitiesHelpDialog capabilitieshelpdialog)
        {
            return capabilitieshelpdialog.m_Self;
        //    0    0:aload_0         
        //    1    1:getfield        #45  <Field PropertySheetPanel$CapabilitiesHelpDialog m_Self>
        //    2    4:areturn         
        }

*/


/*
        static PropertySheetPanel access$1(CapabilitiesHelpDialog capabilitieshelpdialog)
        {
            return capabilitieshelpdialog.this$0;
        //    0    0:aload_0         
        //    1    1:getfield        #20  <Field PropertySheetPanel this$0>
        //    2    4:areturn         
        }

*/

        public CapabilitiesHelpDialog(Frame owner)
        {
            this$0 = PropertySheetPanel.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #20  <Field PropertySheetPanel this$0>
            super(owner);
        //    3    5:aload_0         
        //    4    6:aload_2         
        //    5    7:invokespecial   #23  <Method void JDialog(Frame)>
            initialize();
        //    6   10:aload_0         
        //    7   11:invokevirtual   #27  <Method void initialize()>
        //    8   14:return          
        }

        public CapabilitiesHelpDialog(Dialog owner)
        {
            this$0 = PropertySheetPanel.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #20  <Field PropertySheetPanel this$0>
            super(owner);
        //    3    5:aload_0         
        //    4    6:aload_2         
        //    5    7:invokespecial   #36  <Method void JDialog(Dialog)>
            initialize();
        //    6   10:aload_0         
        //    7   11:invokevirtual   #27  <Method void initialize()>
        //    8   14:return          
        }
    }


    public PropertySheetPanel()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #52  <Method void JPanel()>
        m_NumEditable = 0;
    //    2    4:aload_0         
    //    3    5:iconst_0        
    //    4    6:putfield        #54  <Field int m_NumEditable>
        support = new PropertyChangeSupport(this);
    //    5    9:aload_0         
    //    6   10:new             #56  <Class PropertyChangeSupport>
    //    7   13:dup             
    //    8   14:aload_0         
    //    9   15:invokespecial   #59  <Method void PropertyChangeSupport(Object)>
    //   10   18:putfield        #61  <Field PropertyChangeSupport support>
        setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
    //   11   21:aload_0         
    //   12   22:iconst_0        
    //   13   23:iconst_0        
    //   14   24:bipush          10
    //   15   26:iconst_0        
    //   16   27:invokestatic    #67  <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
    //   17   30:invokevirtual   #71  <Method void setBorder(javax.swing.border.Border)>
    //   18   33:return          
    }

    public JPanel getAboutPanel()
    {
        return m_aboutPanel;
    //    0    0:aload_0         
    //    1    1:getfield        #79  <Field JPanel m_aboutPanel>
    //    2    4:areturn         
    }

    public void propertyChange(PropertyChangeEvent evt)
    {
        wasModified(evt);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokevirtual   #84  <Method void wasModified(PropertyChangeEvent)>
        support.firePropertyChange("", null, null);
    //    3    5:aload_0         
    //    4    6:getfield        #61  <Field PropertyChangeSupport support>
    //    5    9:ldc1            #86  <String "">
    //    6   11:aconst_null     
    //    7   12:aconst_null     
    //    8   13:invokevirtual   #90  <Method void PropertyChangeSupport.firePropertyChange(String, Object, Object)>
    //    9   16:return          
    }

    public void addPropertyChangeListener(PropertyChangeListener l)
    {
        support.addPropertyChangeListener(l);
    //    0    0:aload_0         
    //    1    1:getfield        #61  <Field PropertyChangeSupport support>
    //    2    4:aload_1         
    //    3    5:invokevirtual   #96  <Method void PropertyChangeSupport.addPropertyChangeListener(PropertyChangeListener)>
    //    4    8:return          
    }

    public void removePropertyChangeListener(PropertyChangeListener l)
    {
        support.removePropertyChangeListener(l);
    //    0    0:aload_0         
    //    1    1:getfield        #61  <Field PropertyChangeSupport support>
    //    2    4:aload_1         
    //    3    5:invokevirtual   #101 <Method void PropertyChangeSupport.removePropertyChangeListener(PropertyChangeListener)>
    //    4    8:return          
    }

    public synchronized void setTarget(Object targ)
    {
        int componentOffset = 0;
    //    0    0:iconst_0        
    //    1    1:istore_2        
        removeAll();
    //    2    2:aload_0         
    //    3    3:invokevirtual   #105 <Method void removeAll()>
        setLayout(new BorderLayout());
    //    4    6:aload_0         
    //    5    7:new             #107 <Class BorderLayout>
    //    6   10:dup             
    //    7   11:invokespecial   #108 <Method void BorderLayout()>
    //    8   14:invokevirtual   #112 <Method void setLayout(java.awt.LayoutManager)>
        JPanel scrollablePanel = new JPanel();
    //    9   17:new             #4   <Class JPanel>
    //   10   20:dup             
    //   11   21:invokespecial   #52  <Method void JPanel()>
    //   12   24:astore_3        
        JScrollPane scrollPane = new JScrollPane(scrollablePanel);
    //   13   25:new             #114 <Class JScrollPane>
    //   14   28:dup             
    //   15   29:aload_3         
    //   16   30:invokespecial   #117 <Method void JScrollPane(Component)>
    //   17   33:astore          4
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
    //   18   35:aload           4
    //   19   37:invokestatic    #120 <Method javax.swing.border.Border BorderFactory.createEmptyBorder()>
    //   20   40:invokevirtual   #121 <Method void JScrollPane.setBorder(javax.swing.border.Border)>
        add(scrollPane, "Center");
    //   21   43:aload_0         
    //   22   44:aload           4
    //   23   46:ldc1            #123 <String "Center">
    //   24   48:invokevirtual   #127 <Method void add(Component, Object)>
        GridBagLayout gbLayout = new GridBagLayout();
    //   25   51:new             #129 <Class GridBagLayout>
    //   26   54:dup             
    //   27   55:invokespecial   #130 <Method void GridBagLayout()>
    //   28   58:astore          5
        scrollablePanel.setLayout(gbLayout);
    //   29   60:aload_3         
    //   30   61:aload           5
    //   31   63:invokevirtual   #131 <Method void JPanel.setLayout(java.awt.LayoutManager)>
        setVisible(false);
    //   32   66:aload_0         
    //   33   67:iconst_0        
    //   34   68:invokevirtual   #135 <Method void setVisible(boolean)>
        m_NumEditable = 0;
    //   35   71:aload_0         
    //   36   72:iconst_0        
    //   37   73:putfield        #54  <Field int m_NumEditable>
        m_Target = targ;
    //   38   76:aload_0         
    //   39   77:aload_1         
    //   40   78:putfield        #137 <Field Object m_Target>
        try
        {
            BeanInfo bi = Introspector.getBeanInfo(m_Target.getClass());
    //   41   81:aload_0         
    //   42   82:getfield        #137 <Field Object m_Target>
    //   43   85:invokevirtual   #143 <Method Class Object.getClass()>
    //   44   88:invokestatic    #149 <Method BeanInfo Introspector.getBeanInfo(Class)>
    //   45   91:astore          6
            m_Properties = bi.getPropertyDescriptors();
    //   46   93:aload_0         
    //   47   94:aload           6
    //   48   96:invokeinterface #155 <Method PropertyDescriptor[] BeanInfo.getPropertyDescriptors()>
    //   49  101:putfield        #157 <Field PropertyDescriptor[] m_Properties>
            m_Methods = bi.getMethodDescriptors();
    //   50  104:aload_0         
    //   51  105:aload           6
    //   52  107:invokeinterface #161 <Method MethodDescriptor[] BeanInfo.getMethodDescriptors()>
    //   53  112:putfield        #163 <Field MethodDescriptor[] m_Methods>
        }
    //*  54  115:goto            129
        catch(IntrospectionException ex)
    //*  55  118:astore          6
        {
            System.err.println("PropertySheet: Couldn't introspect");
    //   56  120:getstatic       #169 <Field PrintStream System.err>
    //   57  123:ldc1            #171 <String "PropertySheet: Couldn't introspect">
    //   58  125:invokevirtual   #177 <Method void PrintStream.println(String)>
            return;
    //   59  128:return          
        }
        JTextArea jt = new JTextArea();
    //   60  129:new             #179 <Class JTextArea>
    //   61  132:dup             
    //   62  133:invokespecial   #180 <Method void JTextArea()>
    //   63  136:astore          6
        m_HelpText = null;
    //   64  138:aload_0         
    //   65  139:aconst_null     
    //   66  140:putfield        #182 <Field StringBuffer m_HelpText>
        for(int i = 0; i < m_Methods.length;)
    //*  67  143:iconst_0        
    //*  68  144:istore          7
    //*  69  146:goto            703
        {
            String name = m_Methods[i].getDisplayName();
    //   70  149:aload_0         
    //   71  150:getfield        #163 <Field MethodDescriptor[] m_Methods>
    //   72  153:iload           7
    //   73  155:aaload          
    //   74  156:invokevirtual   #188 <Method String MethodDescriptor.getDisplayName()>
    //   75  159:astore          8
            Method meth = m_Methods[i].getMethod();
    //   76  161:aload_0         
    //   77  162:getfield        #163 <Field MethodDescriptor[] m_Methods>
    //   78  165:iload           7
    //   79  167:aaload          
    //   80  168:invokevirtual   #192 <Method Method MethodDescriptor.getMethod()>
    //   81  171:astore          9
            if(!name.equals("globalInfo") || !meth.getReturnType().equals(java/lang/String))
                continue;
    //   82  173:aload           8
    //   83  175:ldc1            #194 <String "globalInfo">
    //   84  177:invokevirtual   #200 <Method boolean String.equals(Object)>
    //   85  180:ifeq            700
    //   86  183:aload           9
    //   87  185:invokevirtual   #205 <Method Class Method.getReturnType()>
    //   88  188:ldc1            #196 <Class String>
    //   89  190:invokevirtual   #206 <Method boolean Object.equals(Object)>
    //   90  193:ifeq            700
            try
            {
                Object args[] = new Object[0];
    //   91  196:iconst_0        
    //   92  197:anewarray       Object[]
    //   93  200:astore          10
                String globalInfo = (String)meth.invoke(m_Target, args);
    //   94  202:aload           9
    //   95  204:aload_0         
    //   96  205:getfield        #137 <Field Object m_Target>
    //   97  208:aload           10
    //   98  210:invokevirtual   #210 <Method Object Method.invoke(Object, Object[])>
    //   99  213:checkcast       #196 <Class String>
    //  100  216:astore          11
                String summary = globalInfo;
    //  101  218:aload           11
    //  102  220:astore          12
                int ci = globalInfo.indexOf('.');
    //  103  222:aload           11
    //  104  224:bipush          46
    //  105  226:invokevirtual   #214 <Method int String.indexOf(int)>
    //  106  229:istore          13
                if(ci != -1)
    //* 107  231:iload           13
    //* 108  233:iconst_m1       
    //* 109  234:icmpeq          249
                    summary = globalInfo.substring(0, ci + 1);
    //  110  237:aload           11
    //  111  239:iconst_0        
    //  112  240:iload           13
    //  113  242:iconst_1        
    //  114  243:iadd            
    //  115  244:invokevirtual   #218 <Method String String.substring(int, int)>
    //  116  247:astore          12
                String className = targ.getClass().getName();
    //  117  249:aload_1         
    //  118  250:invokevirtual   #143 <Method Class Object.getClass()>
    //  119  253:invokevirtual   #223 <Method String Class.getName()>
    //  120  256:astore          14
                m_HelpText = new StringBuffer("NAME\n");
    //  121  258:aload_0         
    //  122  259:new             #225 <Class StringBuffer>
    //  123  262:dup             
    //  124  263:ldc1            #227 <String "NAME\n">
    //  125  265:invokespecial   #229 <Method void StringBuffer(String)>
    //  126  268:putfield        #182 <Field StringBuffer m_HelpText>
                m_HelpText.append(className).append("\n\n");
    //  127  271:aload_0         
    //  128  272:getfield        #182 <Field StringBuffer m_HelpText>
    //  129  275:aload           14
    //  130  277:invokevirtual   #233 <Method StringBuffer StringBuffer.append(String)>
    //  131  280:ldc1            #235 <String "\n\n">
    //  132  282:invokevirtual   #233 <Method StringBuffer StringBuffer.append(String)>
    //  133  285:pop             
                m_HelpText.append("SYNOPSIS\n").append(globalInfo).append("\n\n");
    //  134  286:aload_0         
    //  135  287:getfield        #182 <Field StringBuffer m_HelpText>
    //  136  290:ldc1            #237 <String "SYNOPSIS\n">
    //  137  292:invokevirtual   #233 <Method StringBuffer StringBuffer.append(String)>
    //  138  295:aload           11
    //  139  297:invokevirtual   #233 <Method StringBuffer StringBuffer.append(String)>
    //  140  300:ldc1            #235 <String "\n\n">
    //  141  302:invokevirtual   #233 <Method StringBuffer StringBuffer.append(String)>
    //  142  305:pop             
                m_HelpBut = new JButton("More");
    //  143  306:aload_0         
    //  144  307:new             #239 <Class JButton>
    //  145  310:dup             
    //  146  311:ldc1            #241 <String "More">
    //  147  313:invokespecial   #242 <Method void JButton(String)>
    //  148  316:putfield        #244 <Field JButton m_HelpBut>
                m_HelpBut.setToolTipText((new StringBuilder("More information about ")).append(className).toString());
    //  149  319:aload_0         
    //  150  320:getfield        #244 <Field JButton m_HelpBut>
    //  151  323:new             #246 <Class StringBuilder>
    //  152  326:dup             
    //  153  327:ldc1            #248 <String "More information about ">
    //  154  329:invokespecial   #249 <Method void StringBuilder(String)>
    //  155  332:aload           14
    //  156  334:invokevirtual   #252 <Method StringBuilder StringBuilder.append(String)>
    //  157  337:invokevirtual   #255 <Method String StringBuilder.toString()>
    //  158  340:invokevirtual   #258 <Method void JButton.setToolTipText(String)>
                m_HelpBut.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent a)
                    {
                        openHelpFrame();
                    //    0    0:aload_0         
                    //    1    1:getfield        #13  <Field PropertySheetPanel this$0>
                    //    2    4:invokevirtual   #27  <Method void PropertySheetPanel.openHelpFrame()>
                        m_HelpBut.setEnabled(false);
                    //    3    7:aload_0         
                    //    4    8:getfield        #13  <Field PropertySheetPanel this$0>
                    //    5   11:invokestatic    #31  <Method JButton PropertySheetPanel.access$5(PropertySheetPanel)>
                    //    6   14:iconst_0        
                    //    7   15:invokevirtual   #37  <Method void JButton.setEnabled(boolean)>
                    //    8   18:return          
                    }

                    final PropertySheetPanel this$0;

            
            {
                this$0 = PropertySheetPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field PropertySheetPanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
                }
);
    //  159  343:aload_0         
    //  160  344:getfield        #244 <Field JButton m_HelpBut>
    //  161  347:new             #260 <Class PropertySheetPanel$2>
    //  162  350:dup             
    //  163  351:aload_0         
    //  164  352:invokespecial   #263 <Method void PropertySheetPanel$2(PropertySheetPanel)>
    //  165  355:invokevirtual   #267 <Method void JButton.addActionListener(ActionListener)>
                if(m_Target instanceof CapabilitiesHandler)
    //* 166  358:aload_0         
    //* 167  359:getfield        #137 <Field Object m_Target>
    //* 168  362:instanceof      #269 <Class CapabilitiesHandler>
    //* 169  365:ifeq            425
                {
                    m_CapabilitiesBut = new JButton("Capabilities");
    //  170  368:aload_0         
    //  171  369:new             #239 <Class JButton>
    //  172  372:dup             
    //  173  373:ldc2            #271 <String "Capabilities">
    //  174  376:invokespecial   #242 <Method void JButton(String)>
    //  175  379:putfield        #273 <Field JButton m_CapabilitiesBut>
                    m_CapabilitiesBut.setToolTipText((new StringBuilder("The capabilities of ")).append(className).toString());
    //  176  382:aload_0         
    //  177  383:getfield        #273 <Field JButton m_CapabilitiesBut>
    //  178  386:new             #246 <Class StringBuilder>
    //  179  389:dup             
    //  180  390:ldc2            #275 <String "The capabilities of ">
    //  181  393:invokespecial   #249 <Method void StringBuilder(String)>
    //  182  396:aload           14
    //  183  398:invokevirtual   #252 <Method StringBuilder StringBuilder.append(String)>
    //  184  401:invokevirtual   #255 <Method String StringBuilder.toString()>
    //  185  404:invokevirtual   #258 <Method void JButton.setToolTipText(String)>
                    m_CapabilitiesBut.addActionListener(new ActionListener() {

                        public void actionPerformed(ActionEvent a)
                        {
                            openCapabilitiesHelpDialog();
                        //    0    0:aload_0         
                        //    1    1:getfield        #13  <Field PropertySheetPanel this$0>
                        //    2    4:invokevirtual   #27  <Method void PropertySheetPanel.openCapabilitiesHelpDialog()>
                            m_CapabilitiesBut.setEnabled(false);
                        //    3    7:aload_0         
                        //    4    8:getfield        #13  <Field PropertySheetPanel this$0>
                        //    5   11:invokestatic    #31  <Method JButton PropertySheetPanel.access$3(PropertySheetPanel)>
                        //    6   14:iconst_0        
                        //    7   15:invokevirtual   #37  <Method void JButton.setEnabled(boolean)>
                        //    8   18:return          
                        }

                        final PropertySheetPanel this$0;

            
            {
                this$0 = PropertySheetPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field PropertySheetPanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
                    }
);
    //  186  407:aload_0         
    //  187  408:getfield        #273 <Field JButton m_CapabilitiesBut>
    //  188  411:new             #277 <Class PropertySheetPanel$3>
    //  189  414:dup             
    //  190  415:aload_0         
    //  191  416:invokespecial   #278 <Method void PropertySheetPanel$3(PropertySheetPanel)>
    //  192  419:invokevirtual   #267 <Method void JButton.addActionListener(ActionListener)>
                } else
    //* 193  422:goto            430
                {
                    m_CapabilitiesBut = null;
    //  194  425:aload_0         
    //  195  426:aconst_null     
    //  196  427:putfield        #273 <Field JButton m_CapabilitiesBut>
                }
                jt.setColumns(30);
    //  197  430:aload           6
    //  198  432:bipush          30
    //  199  434:invokevirtual   #282 <Method void JTextArea.setColumns(int)>
                jt.setFont(new Font("SansSerif", 0, 12));
    //  200  437:aload           6
    //  201  439:new             #284 <Class Font>
    //  202  442:dup             
    //  203  443:ldc2            #286 <String "SansSerif">
    //  204  446:iconst_0        
    //  205  447:bipush          12
    //  206  449:invokespecial   #289 <Method void Font(String, int, int)>
    //  207  452:invokevirtual   #293 <Method void JTextArea.setFont(Font)>
                jt.setEditable(false);
    //  208  455:aload           6
    //  209  457:iconst_0        
    //  210  458:invokevirtual   #296 <Method void JTextArea.setEditable(boolean)>
                jt.setLineWrap(true);
    //  211  461:aload           6
    //  212  463:iconst_1        
    //  213  464:invokevirtual   #299 <Method void JTextArea.setLineWrap(boolean)>
                jt.setWrapStyleWord(true);
    //  214  467:aload           6
    //  215  469:iconst_1        
    //  216  470:invokevirtual   #302 <Method void JTextArea.setWrapStyleWord(boolean)>
                jt.setText(summary);
    //  217  473:aload           6
    //  218  475:aload           12
    //  219  477:invokevirtual   #305 <Method void JTextArea.setText(String)>
                jt.setBackground(getBackground());
    //  220  480:aload           6
    //  221  482:aload_0         
    //  222  483:invokevirtual   #309 <Method java.awt.Color getBackground()>
    //  223  486:invokevirtual   #313 <Method void JTextArea.setBackground(java.awt.Color)>
                JPanel jp = new JPanel();
    //  224  489:new             #4   <Class JPanel>
    //  225  492:dup             
    //  226  493:invokespecial   #52  <Method void JPanel()>
    //  227  496:astore          15
                jp.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("About"), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
    //  228  498:aload           15
    //  229  500:ldc2            #315 <String "About">
    //  230  503:invokestatic    #319 <Method javax.swing.border.TitledBorder BorderFactory.createTitledBorder(String)>
    //  231  506:iconst_5        
    //  232  507:iconst_5        
    //  233  508:iconst_5        
    //  234  509:iconst_5        
    //  235  510:invokestatic    #67  <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
    //  236  513:invokestatic    #323 <Method javax.swing.border.CompoundBorder BorderFactory.createCompoundBorder(javax.swing.border.Border, javax.swing.border.Border)>
    //  237  516:invokevirtual   #324 <Method void JPanel.setBorder(javax.swing.border.Border)>
                jp.setLayout(new BorderLayout());
    //  238  519:aload           15
    //  239  521:new             #107 <Class BorderLayout>
    //  240  524:dup             
    //  241  525:invokespecial   #108 <Method void BorderLayout()>
    //  242  528:invokevirtual   #131 <Method void JPanel.setLayout(java.awt.LayoutManager)>
                jp.add(jt, "Center");
    //  243  531:aload           15
    //  244  533:aload           6
    //  245  535:ldc1            #123 <String "Center">
    //  246  537:invokevirtual   #325 <Method void JPanel.add(Component, Object)>
                JPanel p2 = new JPanel();
    //  247  540:new             #4   <Class JPanel>
    //  248  543:dup             
    //  249  544:invokespecial   #52  <Method void JPanel()>
    //  250  547:astore          16
                p2.setLayout(new BorderLayout());
    //  251  549:aload           16
    //  252  551:new             #107 <Class BorderLayout>
    //  253  554:dup             
    //  254  555:invokespecial   #108 <Method void BorderLayout()>
    //  255  558:invokevirtual   #131 <Method void JPanel.setLayout(java.awt.LayoutManager)>
                p2.add(m_HelpBut, "North");
    //  256  561:aload           16
    //  257  563:aload_0         
    //  258  564:getfield        #244 <Field JButton m_HelpBut>
    //  259  567:ldc2            #327 <String "North">
    //  260  570:invokevirtual   #325 <Method void JPanel.add(Component, Object)>
                if(m_CapabilitiesBut != null)
    //* 261  573:aload_0         
    //* 262  574:getfield        #273 <Field JButton m_CapabilitiesBut>
    //* 263  577:ifnull          622
                {
                    JPanel p3 = new JPanel();
    //  264  580:new             #4   <Class JPanel>
    //  265  583:dup             
    //  266  584:invokespecial   #52  <Method void JPanel()>
    //  267  587:astore          17
                    p3.setLayout(new BorderLayout());
    //  268  589:aload           17
    //  269  591:new             #107 <Class BorderLayout>
    //  270  594:dup             
    //  271  595:invokespecial   #108 <Method void BorderLayout()>
    //  272  598:invokevirtual   #131 <Method void JPanel.setLayout(java.awt.LayoutManager)>
                    p3.add(m_CapabilitiesBut, "North");
    //  273  601:aload           17
    //  274  603:aload_0         
    //  275  604:getfield        #273 <Field JButton m_CapabilitiesBut>
    //  276  607:ldc2            #327 <String "North">
    //  277  610:invokevirtual   #325 <Method void JPanel.add(Component, Object)>
                    p2.add(p3, "Center");
    //  278  613:aload           16
    //  279  615:aload           17
    //  280  617:ldc1            #123 <String "Center">
    //  281  619:invokevirtual   #325 <Method void JPanel.add(Component, Object)>
                }
                jp.add(p2, "East");
    //  282  622:aload           15
    //  283  624:aload           16
    //  284  626:ldc2            #329 <String "East">
    //  285  629:invokevirtual   #325 <Method void JPanel.add(Component, Object)>
                GridBagConstraints gbConstraints = new GridBagConstraints();
    //  286  632:new             #331 <Class GridBagConstraints>
    //  287  635:dup             
    //  288  636:invokespecial   #332 <Method void GridBagConstraints()>
    //  289  639:astore          17
                gbConstraints.fill = 1;
    //  290  641:aload           17
    //  291  643:iconst_1        
    //  292  644:putfield        #335 <Field int GridBagConstraints.fill>
                gbConstraints.gridwidth = 2;
    //  293  647:aload           17
    //  294  649:iconst_2        
    //  295  650:putfield        #338 <Field int GridBagConstraints.gridwidth>
                gbConstraints.insets = new Insets(0, 5, 0, 5);
    //  296  653:aload           17
    //  297  655:new             #340 <Class Insets>
    //  298  658:dup             
    //  299  659:iconst_0        
    //  300  660:iconst_5        
    //  301  661:iconst_0        
    //  302  662:iconst_5        
    //  303  663:invokespecial   #343 <Method void Insets(int, int, int, int)>
    //  304  666:putfield        #347 <Field Insets GridBagConstraints.insets>
                gbLayout.setConstraints(jp, gbConstraints);
    //  305  669:aload           5
    //  306  671:aload           15
    //  307  673:aload           17
    //  308  675:invokevirtual   #351 <Method void GridBagLayout.setConstraints(Component, GridBagConstraints)>
                m_aboutPanel = jp;
    //  309  678:aload_0         
    //  310  679:aload           15
    //  311  681:putfield        #79  <Field JPanel m_aboutPanel>
                scrollablePanel.add(m_aboutPanel);
    //  312  684:aload_3         
    //  313  685:aload_0         
    //  314  686:getfield        #79  <Field JPanel m_aboutPanel>
    //  315  689:invokevirtual   #354 <Method Component JPanel.add(Component)>
    //  316  692:pop             
                componentOffset = 1;
    //  317  693:iconst_1        
    //  318  694:istore_2        
                break;
    //  319  695:goto            713
            }
            catch(Exception exception)
    //* 320  698:astore          10
            {
                i++;
    //  321  700:iinc            7  1
            }
        }

    //  322  703:iload           7
    //  323  705:aload_0         
    //  324  706:getfield        #163 <Field MethodDescriptor[] m_Methods>
    //  325  709:arraylength     
    //  326  710:icmplt          149
        m_Editors = new PropertyEditor[m_Properties.length];
    //  327  713:aload_0         
    //  328  714:aload_0         
    //  329  715:getfield        #157 <Field PropertyDescriptor[] m_Properties>
    //  330  718:arraylength     
    //  331  719:anewarray       PropertyEditor[]
    //  332  722:putfield        #358 <Field PropertyEditor[] m_Editors>
        m_Values = new Object[m_Properties.length];
    //  333  725:aload_0         
    //  334  726:aload_0         
    //  335  727:getfield        #157 <Field PropertyDescriptor[] m_Properties>
    //  336  730:arraylength     
    //  337  731:anewarray       Object[]
    //  338  734:putfield        #360 <Field Object[] m_Values>
        m_Views = new JComponent[m_Properties.length];
    //  339  737:aload_0         
    //  340  738:aload_0         
    //  341  739:getfield        #157 <Field PropertyDescriptor[] m_Properties>
    //  342  742:arraylength     
    //  343  743:anewarray       JComponent[]
    //  344  746:putfield        #364 <Field JComponent[] m_Views>
        m_Labels = new JLabel[m_Properties.length];
    //  345  749:aload_0         
    //  346  750:aload_0         
    //  347  751:getfield        #157 <Field PropertyDescriptor[] m_Properties>
    //  348  754:arraylength     
    //  349  755:anewarray       JLabel[]
    //  350  758:putfield        #368 <Field JLabel[] m_Labels>
        m_TipTexts = new String[m_Properties.length];
    //  351  761:aload_0         
    //  352  762:aload_0         
    //  353  763:getfield        #157 <Field PropertyDescriptor[] m_Properties>
    //  354  766:arraylength     
    //  355  767:anewarray       String[]
    //  356  770:putfield        #370 <Field String[] m_TipTexts>
        boolean firstTip = true;
    //  357  773:iconst_1        
    //  358  774:istore          7
        for(int i = 0; i < m_Properties.length; i++)
    //* 359  776:iconst_0        
    //* 360  777:istore          8
    //* 361  779:goto            1732
        {
            if(m_Properties[i].isHidden() || m_Properties[i].isExpert())
    //* 362  782:aload_0         
    //* 363  783:getfield        #157 <Field PropertyDescriptor[] m_Properties>
    //* 364  786:iload           8
    //* 365  788:aaload          
    //* 366  789:invokevirtual   #376 <Method boolean PropertyDescriptor.isHidden()>
    //* 367  792:ifne            1729
    //* 368  795:aload_0         
    //* 369  796:getfield        #157 <Field PropertyDescriptor[] m_Properties>
    //* 370  799:iload           8
    //* 371  801:aaload          
    //* 372  802:invokevirtual   #379 <Method boolean PropertyDescriptor.isExpert()>
    //* 373  805:ifeq            811
                continue;
    //  374  808:goto            1729
            String name = m_Properties[i].getDisplayName();
    //  375  811:aload_0         
    //  376  812:getfield        #157 <Field PropertyDescriptor[] m_Properties>
    //  377  815:iload           8
    //  378  817:aaload          
    //  379  818:invokevirtual   #380 <Method String PropertyDescriptor.getDisplayName()>
    //  380  821:astore          9
            Class type = m_Properties[i].getPropertyType();
    //  381  823:aload_0         
    //  382  824:getfield        #157 <Field PropertyDescriptor[] m_Properties>
    //  383  827:iload           8
    //  384  829:aaload          
    //  385  830:invokevirtual   #383 <Method Class PropertyDescriptor.getPropertyType()>
    //  386  833:astore          10
            Method getter = m_Properties[i].getReadMethod();
    //  387  835:aload_0         
    //  388  836:getfield        #157 <Field PropertyDescriptor[] m_Properties>
    //  389  839:iload           8
    //  390  841:aaload          
    //  391  842:invokevirtual   #386 <Method Method PropertyDescriptor.getReadMethod()>
    //  392  845:astore          11
            Method setter = m_Properties[i].getWriteMethod();
    //  393  847:aload_0         
    //  394  848:getfield        #157 <Field PropertyDescriptor[] m_Properties>
    //  395  851:iload           8
    //  396  853:aaload          
    //  397  854:invokevirtual   #389 <Method Method PropertyDescriptor.getWriteMethod()>
    //  398  857:astore          12
            if(getter == null || setter == null)
    //* 399  859:aload           11
    //* 400  861:ifnull          1729
    //* 401  864:aload           12
    //* 402  866:ifnonnull       872
                continue;
    //  403  869:goto            1729
            JComponent view = null;
    //  404  872:aconst_null     
    //  405  873:astore          13
            try
            {
                Object args[] = new Object[0];
    //  406  875:iconst_0        
    //  407  876:anewarray       Object[]
    //  408  879:astore          14
                Object value = getter.invoke(m_Target, args);
    //  409  881:aload           11
    //  410  883:aload_0         
    //  411  884:getfield        #137 <Field Object m_Target>
    //  412  887:aload           14
    //  413  889:invokevirtual   #210 <Method Object Method.invoke(Object, Object[])>
    //  414  892:astore          15
                m_Values[i] = value;
    //  415  894:aload_0         
    //  416  895:getfield        #360 <Field Object[] m_Values>
    //  417  898:iload           8
    //  418  900:aload           15
    //  419  902:aastore         
                PropertyEditor editor = null;
    //  420  903:aconst_null     
    //  421  904:astore          16
                Class pec = m_Properties[i].getPropertyEditorClass();
    //  422  906:aload_0         
    //  423  907:getfield        #157 <Field PropertyDescriptor[] m_Properties>
    //  424  910:iload           8
    //  425  912:aaload          
    //  426  913:invokevirtual   #392 <Method Class PropertyDescriptor.getPropertyEditorClass()>
    //  427  916:astore          17
                if(pec != null)
    //* 428  918:aload           17
    //* 429  920:ifnull          941
                    try
                    {
                        editor = (PropertyEditor)(PropertyEditor)pec.newInstance();
    //  430  923:aload           17
    //  431  925:invokevirtual   #396 <Method Object Class.newInstance()>
    //  432  928:checkcast       #356 <Class PropertyEditor>
    //  433  931:checkcast       #356 <Class PropertyEditor>
    //  434  934:astore          16
                    }
    //* 435  936:goto            941
                    catch(Exception exception1) { }
    //  436  939:astore          18
                if(editor == null)
    //* 437  941:aload           16
    //* 438  943:ifnonnull       953
                    editor = PropertyEditorManager.findEditor(type);
    //  439  946:aload           10
    //  440  948:invokestatic    #402 <Method PropertyEditor PropertyEditorManager.findEditor(Class)>
    //  441  951:astore          16
                m_Editors[i] = editor;
    //  442  953:aload_0         
    //  443  954:getfield        #358 <Field PropertyEditor[] m_Editors>
    //  444  957:iload           8
    //  445  959:aload           16
    //  446  961:aastore         
                if(editor == null)
    //* 447  962:aload           16
    //* 448  964:ifnonnull       988
                {
                    String getterClass = m_Properties[i].getReadMethod().getDeclaringClass().getName();
    //  449  967:aload_0         
    //  450  968:getfield        #157 <Field PropertyDescriptor[] m_Properties>
    //  451  971:iload           8
    //  452  973:aaload          
    //  453  974:invokevirtual   #386 <Method Method PropertyDescriptor.getReadMethod()>
    //  454  977:invokevirtual   #405 <Method Class Method.getDeclaringClass()>
    //  455  980:invokevirtual   #223 <Method String Class.getName()>
    //  456  983:astore          18
                    continue;
    //  457  985:goto            1729
                }
                if(editor instanceof GenericObjectEditor)
    //* 458  988:aload           16
    //* 459  990:instanceof      #407 <Class GenericObjectEditor>
    //* 460  993:ifeq            1006
                    ((GenericObjectEditor)editor).setClassType(type);
    //  461  996:aload           16
    //  462  998:checkcast       #407 <Class GenericObjectEditor>
    //  463 1001:aload           10
    //  464 1003:invokevirtual   #411 <Method void GenericObjectEditor.setClassType(Class)>
                if(value == null)
    //* 465 1006:aload           15
    //* 466 1008:ifnonnull       1032
                {
                    String getterClass = m_Properties[i].getReadMethod().getDeclaringClass().getName();
    //  467 1011:aload_0         
    //  468 1012:getfield        #157 <Field PropertyDescriptor[] m_Properties>
    //  469 1015:iload           8
    //  470 1017:aaload          
    //  471 1018:invokevirtual   #386 <Method Method PropertyDescriptor.getReadMethod()>
    //  472 1021:invokevirtual   #405 <Method Class Method.getDeclaringClass()>
    //  473 1024:invokevirtual   #223 <Method String Class.getName()>
    //  474 1027:astore          18
                    continue;
    //  475 1029:goto            1729
                }
                editor.setValue(value);
    //  476 1032:aload           16
    //  477 1034:aload           15
    //  478 1036:invokeinterface #414 <Method void PropertyEditor.setValue(Object)>
                String tipName = (new StringBuilder(String.valueOf(name))).append("TipText").toString();
    //  479 1041:new             #246 <Class StringBuilder>
    //  480 1044:dup             
    //  481 1045:aload           9
    //  482 1047:invokestatic    #418 <Method String String.valueOf(Object)>
    //  483 1050:invokespecial   #249 <Method void StringBuilder(String)>
    //  484 1053:ldc2            #420 <String "TipText">
    //  485 1056:invokevirtual   #252 <Method StringBuilder StringBuilder.append(String)>
    //  486 1059:invokevirtual   #255 <Method String StringBuilder.toString()>
    //  487 1062:astore          18
                for(int j = 0; j < m_Methods.length; j++)
    //* 488 1064:iconst_0        
    //* 489 1065:istore          19
    //* 490 1067:goto            1242
                {
                    String mname = m_Methods[j].getDisplayName();
    //  491 1070:aload_0         
    //  492 1071:getfield        #163 <Field MethodDescriptor[] m_Methods>
    //  493 1074:iload           19
    //  494 1076:aaload          
    //  495 1077:invokevirtual   #188 <Method String MethodDescriptor.getDisplayName()>
    //  496 1080:astore          20
                    Method meth = m_Methods[j].getMethod();
    //  497 1082:aload_0         
    //  498 1083:getfield        #163 <Field MethodDescriptor[] m_Methods>
    //  499 1086:iload           19
    //  500 1088:aaload          
    //  501 1089:invokevirtual   #192 <Method Method MethodDescriptor.getMethod()>
    //  502 1092:astore          21
                    if(!mname.equals(tipName) || !meth.getReturnType().equals(java/lang/String))
                        continue;
    //  503 1094:aload           20
    //  504 1096:aload           18
    //  505 1098:invokevirtual   #200 <Method boolean String.equals(Object)>
    //  506 1101:ifeq            1239
    //  507 1104:aload           21
    //  508 1106:invokevirtual   #205 <Method Class Method.getReturnType()>
    //  509 1109:ldc1            #196 <Class String>
    //  510 1111:invokevirtual   #206 <Method boolean Object.equals(Object)>
    //  511 1114:ifeq            1239
                    try
                    {
                        String tempTip = (String)meth.invoke(m_Target, args);
    //  512 1117:aload           21
    //  513 1119:aload_0         
    //  514 1120:getfield        #137 <Field Object m_Target>
    //  515 1123:aload           14
    //  516 1125:invokevirtual   #210 <Method Object Method.invoke(Object, Object[])>
    //  517 1128:checkcast       #196 <Class String>
    //  518 1131:astore          22
                        int ci = tempTip.indexOf('.');
    //  519 1133:aload           22
    //  520 1135:bipush          46
    //  521 1137:invokevirtual   #214 <Method int String.indexOf(int)>
    //  522 1140:istore          23
                        if(ci < 0)
    //* 523 1142:iload           23
    //* 524 1144:ifge            1159
                            m_TipTexts[i] = tempTip;
    //  525 1147:aload_0         
    //  526 1148:getfield        #370 <Field String[] m_TipTexts>
    //  527 1151:iload           8
    //  528 1153:aload           22
    //  529 1155:aastore         
                        else
    //* 530 1156:goto            1174
                            m_TipTexts[i] = tempTip.substring(0, ci);
    //  531 1159:aload_0         
    //  532 1160:getfield        #370 <Field String[] m_TipTexts>
    //  533 1163:iload           8
    //  534 1165:aload           22
    //  535 1167:iconst_0        
    //  536 1168:iload           23
    //  537 1170:invokevirtual   #218 <Method String String.substring(int, int)>
    //  538 1173:aastore         
                        if(m_HelpText != null)
    //* 539 1174:aload_0         
    //* 540 1175:getfield        #182 <Field StringBuffer m_HelpText>
    //* 541 1178:ifnull          1252
                        {
                            if(firstTip)
    //* 542 1181:iload           7
    //* 543 1183:ifeq            1200
                            {
                                m_HelpText.append("OPTIONS\n");
    //  544 1186:aload_0         
    //  545 1187:getfield        #182 <Field StringBuffer m_HelpText>
    //  546 1190:ldc2            #422 <String "OPTIONS\n">
    //  547 1193:invokevirtual   #233 <Method StringBuffer StringBuffer.append(String)>
    //  548 1196:pop             
                                firstTip = false;
    //  549 1197:iconst_0        
    //  550 1198:istore          7
                            }
                            m_HelpText.append(name).append(" -- ");
    //  551 1200:aload_0         
    //  552 1201:getfield        #182 <Field StringBuffer m_HelpText>
    //  553 1204:aload           9
    //  554 1206:invokevirtual   #233 <Method StringBuffer StringBuffer.append(String)>
    //  555 1209:ldc2            #424 <String " -- ">
    //  556 1212:invokevirtual   #233 <Method StringBuffer StringBuffer.append(String)>
    //  557 1215:pop             
                            m_HelpText.append(tempTip).append("\n\n");
    //  558 1216:aload_0         
    //  559 1217:getfield        #182 <Field StringBuffer m_HelpText>
    //  560 1220:aload           22
    //  561 1222:invokevirtual   #233 <Method StringBuffer StringBuffer.append(String)>
    //  562 1225:ldc1            #235 <String "\n\n">
    //  563 1227:invokevirtual   #233 <Method StringBuffer StringBuffer.append(String)>
    //  564 1230:pop             
                        }
                        break;
    //  565 1231:goto            1252
                    }
                    catch(Exception exception2) { }
    //  566 1234:astore          22
                    break;
    //  567 1236:goto            1252
                }

    //  568 1239:iinc            19  1
    //  569 1242:iload           19
    //  570 1244:aload_0         
    //  571 1245:getfield        #163 <Field MethodDescriptor[] m_Methods>
    //  572 1248:arraylength     
    //  573 1249:icmplt          1070
                if(editor.isPaintable() && editor.supportsCustomEditor())
    //* 574 1252:aload           16
    //* 575 1254:invokeinterface #427 <Method boolean PropertyEditor.isPaintable()>
    //* 576 1259:ifeq            1286
    //* 577 1262:aload           16
    //* 578 1264:invokeinterface #430 <Method boolean PropertyEditor.supportsCustomEditor()>
    //* 579 1269:ifeq            1286
                    view = new PropertyPanel(editor);
    //  580 1272:new             #432 <Class PropertyPanel>
    //  581 1275:dup             
    //  582 1276:aload           16
    //  583 1278:invokespecial   #435 <Method void PropertyPanel(PropertyEditor)>
    //  584 1281:astore          13
                else
    //* 585 1283:goto            1367
                if(editor.getTags() != null)
    //* 586 1286:aload           16
    //* 587 1288:invokeinterface #439 <Method String[] PropertyEditor.getTags()>
    //* 588 1293:ifnull          1310
                    view = new PropertyValueSelector(editor);
    //  589 1296:new             #441 <Class PropertyValueSelector>
    //  590 1299:dup             
    //  591 1300:aload           16
    //  592 1302:invokespecial   #442 <Method void PropertyValueSelector(PropertyEditor)>
    //  593 1305:astore          13
                else
    //* 594 1307:goto            1367
                if(editor.getAsText() != null)
    //* 595 1310:aload           16
    //* 596 1312:invokeinterface #445 <Method String PropertyEditor.getAsText()>
    //* 597 1317:ifnull          1334
                {
                    view = new PropertyText(editor);
    //  598 1320:new             #447 <Class PropertyText>
    //  599 1323:dup             
    //  600 1324:aload           16
    //  601 1326:invokespecial   #448 <Method void PropertyText(PropertyEditor)>
    //  602 1329:astore          13
                } else
    //* 603 1331:goto            1367
                {
                    System.err.println((new StringBuilder("Warning: Property \"")).append(name).append("\" has non-displayabale editor.  Skipping.").toString());
    //  604 1334:getstatic       #169 <Field PrintStream System.err>
    //  605 1337:new             #246 <Class StringBuilder>
    //  606 1340:dup             
    //  607 1341:ldc2            #450 <String "Warning: Property \"">
    //  608 1344:invokespecial   #249 <Method void StringBuilder(String)>
    //  609 1347:aload           9
    //  610 1349:invokevirtual   #252 <Method StringBuilder StringBuilder.append(String)>
    //  611 1352:ldc2            #452 <String "\" has non-displayabale editor.  Skipping.">
    //  612 1355:invokevirtual   #252 <Method StringBuilder StringBuilder.append(String)>
    //  613 1358:invokevirtual   #255 <Method String StringBuilder.toString()>
    //  614 1361:invokevirtual   #177 <Method void PrintStream.println(String)>
                    continue;
    //  615 1364:goto            1729
                }
                editor.addPropertyChangeListener(this);
    //  616 1367:aload           16
    //  617 1369:aload_0         
    //  618 1370:invokeinterface #453 <Method void PropertyEditor.addPropertyChangeListener(PropertyChangeListener)>
            }
    //* 619 1375:goto            1474
            catch(InvocationTargetException ex)
    //* 620 1378:astore          14
            {
                System.err.println((new StringBuilder("Skipping property ")).append(name).append(" ; exception on target: ").append(ex.getTargetException()).toString());
    //  621 1380:getstatic       #169 <Field PrintStream System.err>
    //  622 1383:new             #246 <Class StringBuilder>
    //  623 1386:dup             
    //  624 1387:ldc2            #455 <String "Skipping property ">
    //  625 1390:invokespecial   #249 <Method void StringBuilder(String)>
    //  626 1393:aload           9
    //  627 1395:invokevirtual   #252 <Method StringBuilder StringBuilder.append(String)>
    //  628 1398:ldc2            #457 <String " ; exception on target: ">
    //  629 1401:invokevirtual   #252 <Method StringBuilder StringBuilder.append(String)>
    //  630 1404:aload           14
    //  631 1406:invokevirtual   #463 <Method Throwable InvocationTargetException.getTargetException()>
    //  632 1409:invokevirtual   #466 <Method StringBuilder StringBuilder.append(Object)>
    //  633 1412:invokevirtual   #255 <Method String StringBuilder.toString()>
    //  634 1415:invokevirtual   #177 <Method void PrintStream.println(String)>
                ex.getTargetException().printStackTrace();
    //  635 1418:aload           14
    //  636 1420:invokevirtual   #463 <Method Throwable InvocationTargetException.getTargetException()>
    //  637 1423:invokevirtual   #471 <Method void Throwable.printStackTrace()>
                continue;
    //  638 1426:goto            1729
            }
            catch(Exception ex)
    //* 639 1429:astore          14
            {
                System.err.println((new StringBuilder("Skipping property ")).append(name).append(" ; exception: ").append(ex).toString());
    //  640 1431:getstatic       #169 <Field PrintStream System.err>
    //  641 1434:new             #246 <Class StringBuilder>
    //  642 1437:dup             
    //  643 1438:ldc2            #455 <String "Skipping property ">
    //  644 1441:invokespecial   #249 <Method void StringBuilder(String)>
    //  645 1444:aload           9
    //  646 1446:invokevirtual   #252 <Method StringBuilder StringBuilder.append(String)>
    //  647 1449:ldc2            #473 <String " ; exception: ">
    //  648 1452:invokevirtual   #252 <Method StringBuilder StringBuilder.append(String)>
    //  649 1455:aload           14
    //  650 1457:invokevirtual   #466 <Method StringBuilder StringBuilder.append(Object)>
    //  651 1460:invokevirtual   #255 <Method String StringBuilder.toString()>
    //  652 1463:invokevirtual   #177 <Method void PrintStream.println(String)>
                ex.printStackTrace();
    //  653 1466:aload           14
    //  654 1468:invokevirtual   #476 <Method void Exception.printStackTrace()>
                continue;
    //  655 1471:goto            1729
            }
            m_Labels[i] = new JLabel(name, 4);
    //  656 1474:aload_0         
    //  657 1475:getfield        #368 <Field JLabel[] m_Labels>
    //  658 1478:iload           8
    //  659 1480:new             #366 <Class JLabel>
    //  660 1483:dup             
    //  661 1484:aload           9
    //  662 1486:iconst_4        
    //  663 1487:invokespecial   #479 <Method void JLabel(String, int)>
    //  664 1490:aastore         
            m_Labels[i].setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 5));
    //  665 1491:aload_0         
    //  666 1492:getfield        #368 <Field JLabel[] m_Labels>
    //  667 1495:iload           8
    //  668 1497:aaload          
    //  669 1498:bipush          10
    //  670 1500:bipush          10
    //  671 1502:iconst_0        
    //  672 1503:iconst_5        
    //  673 1504:invokestatic    #67  <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
    //  674 1507:invokevirtual   #480 <Method void JLabel.setBorder(javax.swing.border.Border)>
            m_Views[i] = view;
    //  675 1510:aload_0         
    //  676 1511:getfield        #364 <Field JComponent[] m_Views>
    //  677 1514:iload           8
    //  678 1516:aload           13
    //  679 1518:aastore         
            GridBagConstraints gbConstraints = new GridBagConstraints();
    //  680 1519:new             #331 <Class GridBagConstraints>
    //  681 1522:dup             
    //  682 1523:invokespecial   #332 <Method void GridBagConstraints()>
    //  683 1526:astore          14
            gbConstraints.anchor = 13;
    //  684 1528:aload           14
    //  685 1530:bipush          13
    //  686 1532:putfield        #483 <Field int GridBagConstraints.anchor>
            gbConstraints.fill = 2;
    //  687 1535:aload           14
    //  688 1537:iconst_2        
    //  689 1538:putfield        #335 <Field int GridBagConstraints.fill>
            gbConstraints.gridy = i + componentOffset;
    //  690 1541:aload           14
    //  691 1543:iload           8
    //  692 1545:iload_2         
    //  693 1546:iadd            
    //  694 1547:putfield        #486 <Field int GridBagConstraints.gridy>
            gbConstraints.gridx = 0;
    //  695 1550:aload           14
    //  696 1552:iconst_0        
    //  697 1553:putfield        #489 <Field int GridBagConstraints.gridx>
            gbLayout.setConstraints(m_Labels[i], gbConstraints);
    //  698 1556:aload           5
    //  699 1558:aload_0         
    //  700 1559:getfield        #368 <Field JLabel[] m_Labels>
    //  701 1562:iload           8
    //  702 1564:aaload          
    //  703 1565:aload           14
    //  704 1567:invokevirtual   #351 <Method void GridBagLayout.setConstraints(Component, GridBagConstraints)>
            scrollablePanel.add(m_Labels[i]);
    //  705 1570:aload_3         
    //  706 1571:aload_0         
    //  707 1572:getfield        #368 <Field JLabel[] m_Labels>
    //  708 1575:iload           8
    //  709 1577:aaload          
    //  710 1578:invokevirtual   #354 <Method Component JPanel.add(Component)>
    //  711 1581:pop             
            JPanel newPanel = new JPanel();
    //  712 1582:new             #4   <Class JPanel>
    //  713 1585:dup             
    //  714 1586:invokespecial   #52  <Method void JPanel()>
    //  715 1589:astore          15
            if(m_TipTexts[i] != null)
    //* 716 1591:aload_0         
    //* 717 1592:getfield        #370 <Field String[] m_TipTexts>
    //* 718 1595:iload           8
    //* 719 1597:aaload          
    //* 720 1598:ifnull          1618
                m_Views[i].setToolTipText(m_TipTexts[i]);
    //  721 1601:aload_0         
    //  722 1602:getfield        #364 <Field JComponent[] m_Views>
    //  723 1605:iload           8
    //  724 1607:aaload          
    //  725 1608:aload_0         
    //  726 1609:getfield        #370 <Field String[] m_TipTexts>
    //  727 1612:iload           8
    //  728 1614:aaload          
    //  729 1615:invokevirtual   #490 <Method void JComponent.setToolTipText(String)>
            newPanel.setBorder(BorderFactory.createEmptyBorder(10, 5, 0, 10));
    //  730 1618:aload           15
    //  731 1620:bipush          10
    //  732 1622:iconst_5        
    //  733 1623:iconst_0        
    //  734 1624:bipush          10
    //  735 1626:invokestatic    #67  <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
    //  736 1629:invokevirtual   #324 <Method void JPanel.setBorder(javax.swing.border.Border)>
            newPanel.setLayout(new BorderLayout());
    //  737 1632:aload           15
    //  738 1634:new             #107 <Class BorderLayout>
    //  739 1637:dup             
    //  740 1638:invokespecial   #108 <Method void BorderLayout()>
    //  741 1641:invokevirtual   #131 <Method void JPanel.setLayout(java.awt.LayoutManager)>
            newPanel.add(m_Views[i], "Center");
    //  742 1644:aload           15
    //  743 1646:aload_0         
    //  744 1647:getfield        #364 <Field JComponent[] m_Views>
    //  745 1650:iload           8
    //  746 1652:aaload          
    //  747 1653:ldc1            #123 <String "Center">
    //  748 1655:invokevirtual   #325 <Method void JPanel.add(Component, Object)>
            gbConstraints = new GridBagConstraints();
    //  749 1658:new             #331 <Class GridBagConstraints>
    //  750 1661:dup             
    //  751 1662:invokespecial   #332 <Method void GridBagConstraints()>
    //  752 1665:astore          14
            gbConstraints.anchor = 17;
    //  753 1667:aload           14
    //  754 1669:bipush          17
    //  755 1671:putfield        #483 <Field int GridBagConstraints.anchor>
            gbConstraints.fill = 1;
    //  756 1674:aload           14
    //  757 1676:iconst_1        
    //  758 1677:putfield        #335 <Field int GridBagConstraints.fill>
            gbConstraints.gridy = i + componentOffset;
    //  759 1680:aload           14
    //  760 1682:iload           8
    //  761 1684:iload_2         
    //  762 1685:iadd            
    //  763 1686:putfield        #486 <Field int GridBagConstraints.gridy>
            gbConstraints.gridx = 1;
    //  764 1689:aload           14
    //  765 1691:iconst_1        
    //  766 1692:putfield        #489 <Field int GridBagConstraints.gridx>
            gbConstraints.weightx = 100D;
    //  767 1695:aload           14
    //  768 1697:ldc2w           #491 <Double 100D>
    //  769 1700:putfield        #496 <Field double GridBagConstraints.weightx>
            gbLayout.setConstraints(newPanel, gbConstraints);
    //  770 1703:aload           5
    //  771 1705:aload           15
    //  772 1707:aload           14
    //  773 1709:invokevirtual   #351 <Method void GridBagLayout.setConstraints(Component, GridBagConstraints)>
            scrollablePanel.add(newPanel);
    //  774 1712:aload_3         
    //  775 1713:aload           15
    //  776 1715:invokevirtual   #354 <Method Component JPanel.add(Component)>
    //  777 1718:pop             
            m_NumEditable++;
    //  778 1719:aload_0         
    //  779 1720:dup             
    //  780 1721:getfield        #54  <Field int m_NumEditable>
    //  781 1724:iconst_1        
    //  782 1725:iadd            
    //  783 1726:putfield        #54  <Field int m_NumEditable>
        }

    //  784 1729:iinc            8  1
    //  785 1732:iload           8
    //  786 1734:aload_0         
    //  787 1735:getfield        #157 <Field PropertyDescriptor[] m_Properties>
    //  788 1738:arraylength     
    //  789 1739:icmplt          782
        if(m_NumEditable == 0)
    //* 790 1742:aload_0         
    //* 791 1743:getfield        #54  <Field int m_NumEditable>
    //* 792 1746:ifne            1859
        {
            JLabel empty = new JLabel("No editable properties", 0);
    //  793 1749:new             #366 <Class JLabel>
    //  794 1752:dup             
    //  795 1753:ldc2            #498 <String "No editable properties">
    //  796 1756:iconst_0        
    //  797 1757:invokespecial   #479 <Method void JLabel(String, int)>
    //  798 1760:astore          8
            Dimension d = empty.getPreferredSize();
    //  799 1762:aload           8
    //  800 1764:invokevirtual   #502 <Method Dimension JLabel.getPreferredSize()>
    //  801 1767:astore          9
            empty.setPreferredSize(new Dimension(d.width * 2, d.height * 2));
    //  802 1769:aload           8
    //  803 1771:new             #504 <Class Dimension>
    //  804 1774:dup             
    //  805 1775:aload           9
    //  806 1777:getfield        #507 <Field int Dimension.width>
    //  807 1780:iconst_2        
    //  808 1781:imul            
    //  809 1782:aload           9
    //  810 1784:getfield        #510 <Field int Dimension.height>
    //  811 1787:iconst_2        
    //  812 1788:imul            
    //  813 1789:invokespecial   #513 <Method void Dimension(int, int)>
    //  814 1792:invokevirtual   #517 <Method void JLabel.setPreferredSize(Dimension)>
            empty.setBorder(BorderFactory.createEmptyBorder(10, 5, 0, 10));
    //  815 1795:aload           8
    //  816 1797:bipush          10
    //  817 1799:iconst_5        
    //  818 1800:iconst_0        
    //  819 1801:bipush          10
    //  820 1803:invokestatic    #67  <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
    //  821 1806:invokevirtual   #480 <Method void JLabel.setBorder(javax.swing.border.Border)>
            GridBagConstraints gbConstraints = new GridBagConstraints();
    //  822 1809:new             #331 <Class GridBagConstraints>
    //  823 1812:dup             
    //  824 1813:invokespecial   #332 <Method void GridBagConstraints()>
    //  825 1816:astore          10
            gbConstraints.anchor = 10;
    //  826 1818:aload           10
    //  827 1820:bipush          10
    //  828 1822:putfield        #483 <Field int GridBagConstraints.anchor>
            gbConstraints.fill = 2;
    //  829 1825:aload           10
    //  830 1827:iconst_2        
    //  831 1828:putfield        #335 <Field int GridBagConstraints.fill>
            gbConstraints.gridy = componentOffset;
    //  832 1831:aload           10
    //  833 1833:iload_2         
    //  834 1834:putfield        #486 <Field int GridBagConstraints.gridy>
            gbConstraints.gridx = 0;
    //  835 1837:aload           10
    //  836 1839:iconst_0        
    //  837 1840:putfield        #489 <Field int GridBagConstraints.gridx>
            gbLayout.setConstraints(empty, gbConstraints);
    //  838 1843:aload           5
    //  839 1845:aload           8
    //  840 1847:aload           10
    //  841 1849:invokevirtual   #351 <Method void GridBagLayout.setConstraints(Component, GridBagConstraints)>
            scrollablePanel.add(empty);
    //  842 1852:aload_3         
    //  843 1853:aload           8
    //  844 1855:invokevirtual   #354 <Method Component JPanel.add(Component)>
    //  845 1858:pop             
        }
        validate();
    //  846 1859:aload_0         
    //  847 1860:invokevirtual   #520 <Method void validate()>
        setVisible(true);
    //  848 1863:aload_0         
    //  849 1864:iconst_1        
    //  850 1865:invokevirtual   #135 <Method void setVisible(boolean)>
    //  851 1868:return          
    }

    protected void openHelpFrame()
    {
        JTextArea ta = new JTextArea();
    //    0    0:new             #179 <Class JTextArea>
    //    1    3:dup             
    //    2    4:invokespecial   #180 <Method void JTextArea()>
    //    3    7:astore_1        
        ta.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    //    4    8:aload_1         
    //    5    9:iconst_5        
    //    6   10:iconst_5        
    //    7   11:iconst_5        
    //    8   12:iconst_5        
    //    9   13:invokestatic    #67  <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
    //   10   16:invokevirtual   #573 <Method void JTextArea.setBorder(javax.swing.border.Border)>
        ta.setLineWrap(true);
    //   11   19:aload_1         
    //   12   20:iconst_1        
    //   13   21:invokevirtual   #299 <Method void JTextArea.setLineWrap(boolean)>
        ta.setWrapStyleWord(true);
    //   14   24:aload_1         
    //   15   25:iconst_1        
    //   16   26:invokevirtual   #302 <Method void JTextArea.setWrapStyleWord(boolean)>
        ta.setEditable(false);
    //   17   29:aload_1         
    //   18   30:iconst_0        
    //   19   31:invokevirtual   #296 <Method void JTextArea.setEditable(boolean)>
        ta.setText(m_HelpText.toString());
    //   20   34:aload_1         
    //   21   35:aload_0         
    //   22   36:getfield        #182 <Field StringBuffer m_HelpText>
    //   23   39:invokevirtual   #574 <Method String StringBuffer.toString()>
    //   24   42:invokevirtual   #305 <Method void JTextArea.setText(String)>
        ta.setCaretPosition(0);
    //   25   45:aload_1         
    //   26   46:iconst_0        
    //   27   47:invokevirtual   #577 <Method void JTextArea.setCaretPosition(int)>
        JDialog jdtmp;
        if(PropertyDialog.getParentDialog(this) != null)
    //*  28   50:aload_0         
    //*  29   51:invokestatic    #583 <Method Dialog PropertyDialog.getParentDialog(Container)>
    //*  30   54:ifnull          75
            jdtmp = new JDialog(PropertyDialog.getParentDialog(this), "Information");
    //   31   57:new             #585 <Class JDialog>
    //   32   60:dup             
    //   33   61:aload_0         
    //   34   62:invokestatic    #583 <Method Dialog PropertyDialog.getParentDialog(Container)>
    //   35   65:ldc2            #587 <String "Information">
    //   36   68:invokespecial   #590 <Method void JDialog(Dialog, String)>
    //   37   71:astore_2        
        else
    //*  38   72:goto            90
            jdtmp = new JDialog(PropertyDialog.getParentFrame(this), "Information");
    //   39   75:new             #585 <Class JDialog>
    //   40   78:dup             
    //   41   79:aload_0         
    //   42   80:invokestatic    #594 <Method Frame PropertyDialog.getParentFrame(Container)>
    //   43   83:ldc2            #587 <String "Information">
    //   44   86:invokespecial   #597 <Method void JDialog(Frame, String)>
    //   45   89:astore_2        
        final JDialog jd = jdtmp;
    //   46   90:aload_2         
    //   47   91:astore_3        
        jd.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e)
            {
                jd.dispose();
            //    0    0:aload_0         
            //    1    1:getfield        #15  <Field JDialog val$jd>
            //    2    4:invokevirtual   #29  <Method void JDialog.dispose()>
                if(m_HelpDialog == jd)
            //*   3    7:aload_0         
            //*   4    8:getfield        #13  <Field PropertySheetPanel this$0>
            //*   5   11:invokestatic    #35  <Method JDialog PropertySheetPanel.access$6(PropertySheetPanel)>
            //*   6   14:aload_0         
            //*   7   15:getfield        #15  <Field JDialog val$jd>
            //*   8   18:if_acmpne       32
                    m_HelpBut.setEnabled(true);
            //    9   21:aload_0         
            //   10   22:getfield        #13  <Field PropertySheetPanel this$0>
            //   11   25:invokestatic    #39  <Method JButton PropertySheetPanel.access$5(PropertySheetPanel)>
            //   12   28:iconst_1        
            //   13   29:invokevirtual   #45  <Method void JButton.setEnabled(boolean)>
            //   14   32:return          
            }

            final PropertySheetPanel this$0;
            private final JDialog val$jd;

            
            {
                this$0 = PropertySheetPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field PropertySheetPanel this$0>
                jd = jdialog;
            //    3    5:aload_0         
            //    4    6:aload_2         
            //    5    7:putfield        #15  <Field JDialog val$jd>
                super();
            //    6   10:aload_0         
            //    7   11:invokespecial   #18  <Method void WindowAdapter()>
            //    8   14:return          
            }
        }
);
    //   48   92:aload_3         
    //   49   93:new             #599 <Class PropertySheetPanel$4>
    //   50   96:dup             
    //   51   97:aload_0         
    //   52   98:aload_3         
    //   53   99:invokespecial   #602 <Method void PropertySheetPanel$4(PropertySheetPanel, JDialog)>
    //   54  102:invokevirtual   #606 <Method void JDialog.addWindowListener(java.awt.event.WindowListener)>
        jd.getContentPane().setLayout(new BorderLayout());
    //   55  105:aload_3         
    //   56  106:invokevirtual   #610 <Method Container JDialog.getContentPane()>
    //   57  109:new             #107 <Class BorderLayout>
    //   58  112:dup             
    //   59  113:invokespecial   #108 <Method void BorderLayout()>
    //   60  116:invokevirtual   #613 <Method void Container.setLayout(java.awt.LayoutManager)>
        jd.getContentPane().add(new JScrollPane(ta), "Center");
    //   61  119:aload_3         
    //   62  120:invokevirtual   #610 <Method Container JDialog.getContentPane()>
    //   63  123:new             #114 <Class JScrollPane>
    //   64  126:dup             
    //   65  127:aload_1         
    //   66  128:invokespecial   #117 <Method void JScrollPane(Component)>
    //   67  131:ldc1            #123 <String "Center">
    //   68  133:invokevirtual   #614 <Method void Container.add(Component, Object)>
        jd.pack();
    //   69  136:aload_3         
    //   70  137:invokevirtual   #617 <Method void JDialog.pack()>
        jd.setSize(400, 350);
    //   71  140:aload_3         
    //   72  141:sipush          400
    //   73  144:sipush          350
    //   74  147:invokevirtual   #620 <Method void JDialog.setSize(int, int)>
        jd.setLocation(m_aboutPanel.getTopLevelAncestor().getLocationOnScreen().x + m_aboutPanel.getTopLevelAncestor().getSize().width, m_aboutPanel.getTopLevelAncestor().getLocationOnScreen().y);
    //   75  150:aload_3         
    //   76  151:aload_0         
    //   77  152:getfield        #79  <Field JPanel m_aboutPanel>
    //   78  155:invokevirtual   #623 <Method Container JPanel.getTopLevelAncestor()>
    //   79  158:invokevirtual   #627 <Method Point Container.getLocationOnScreen()>
    //   80  161:getfield        #632 <Field int Point.x>
    //   81  164:aload_0         
    //   82  165:getfield        #79  <Field JPanel m_aboutPanel>
    //   83  168:invokevirtual   #623 <Method Container JPanel.getTopLevelAncestor()>
    //   84  171:invokevirtual   #635 <Method Dimension Container.getSize()>
    //   85  174:getfield        #507 <Field int Dimension.width>
    //   86  177:iadd            
    //   87  178:aload_0         
    //   88  179:getfield        #79  <Field JPanel m_aboutPanel>
    //   89  182:invokevirtual   #623 <Method Container JPanel.getTopLevelAncestor()>
    //   90  185:invokevirtual   #627 <Method Point Container.getLocationOnScreen()>
    //   91  188:getfield        #638 <Field int Point.y>
    //   92  191:invokevirtual   #641 <Method void JDialog.setLocation(int, int)>
        jd.setVisible(true);
    //   93  194:aload_3         
    //   94  195:iconst_1        
    //   95  196:invokevirtual   #642 <Method void JDialog.setVisible(boolean)>
        m_HelpDialog = jd;
    //   96  199:aload_0         
    //   97  200:aload_3         
    //   98  201:putfield        #644 <Field JDialog m_HelpDialog>
    //   99  204:return          
    }

    protected void openCapabilitiesHelpDialog()
    {
        if(PropertyDialog.getParentDialog(this) != null)
    //*   0    0:aload_0         
    //*   1    1:invokestatic    #583 <Method Dialog PropertyDialog.getParentDialog(Container)>
    //*   2    4:ifnull          26
            m_CapabilitiesDialog = new CapabilitiesHelpDialog(PropertyDialog.getParentDialog(this));
    //    3    7:aload_0         
    //    4    8:new             #650 <Class PropertySheetPanel$CapabilitiesHelpDialog>
    //    5   11:dup             
    //    6   12:aload_0         
    //    7   13:aload_0         
    //    8   14:invokestatic    #583 <Method Dialog PropertyDialog.getParentDialog(Container)>
    //    9   17:invokespecial   #653 <Method void PropertySheetPanel$CapabilitiesHelpDialog(PropertySheetPanel, Dialog)>
    //   10   20:putfield        #655 <Field PropertySheetPanel$CapabilitiesHelpDialog m_CapabilitiesDialog>
        else
    //*  11   23:goto            42
            m_CapabilitiesDialog = new CapabilitiesHelpDialog(PropertyDialog.getParentFrame(this));
    //   12   26:aload_0         
    //   13   27:new             #650 <Class PropertySheetPanel$CapabilitiesHelpDialog>
    //   14   30:dup             
    //   15   31:aload_0         
    //   16   32:aload_0         
    //   17   33:invokestatic    #594 <Method Frame PropertyDialog.getParentFrame(Container)>
    //   18   36:invokespecial   #658 <Method void PropertySheetPanel$CapabilitiesHelpDialog(PropertySheetPanel, Frame)>
    //   19   39:putfield        #655 <Field PropertySheetPanel$CapabilitiesHelpDialog m_CapabilitiesDialog>
        m_CapabilitiesDialog.setSize(400, 350);
    //   20   42:aload_0         
    //   21   43:getfield        #655 <Field PropertySheetPanel$CapabilitiesHelpDialog m_CapabilitiesDialog>
    //   22   46:sipush          400
    //   23   49:sipush          350
    //   24   52:invokevirtual   #659 <Method void PropertySheetPanel$CapabilitiesHelpDialog.setSize(int, int)>
        m_CapabilitiesDialog.setLocation(m_aboutPanel.getTopLevelAncestor().getLocationOnScreen().x + m_aboutPanel.getTopLevelAncestor().getSize().width, m_aboutPanel.getTopLevelAncestor().getLocationOnScreen().y);
    //   25   55:aload_0         
    //   26   56:getfield        #655 <Field PropertySheetPanel$CapabilitiesHelpDialog m_CapabilitiesDialog>
    //   27   59:aload_0         
    //   28   60:getfield        #79  <Field JPanel m_aboutPanel>
    //   29   63:invokevirtual   #623 <Method Container JPanel.getTopLevelAncestor()>
    //   30   66:invokevirtual   #627 <Method Point Container.getLocationOnScreen()>
    //   31   69:getfield        #632 <Field int Point.x>
    //   32   72:aload_0         
    //   33   73:getfield        #79  <Field JPanel m_aboutPanel>
    //   34   76:invokevirtual   #623 <Method Container JPanel.getTopLevelAncestor()>
    //   35   79:invokevirtual   #635 <Method Dimension Container.getSize()>
    //   36   82:getfield        #507 <Field int Dimension.width>
    //   37   85:iadd            
    //   38   86:aload_0         
    //   39   87:getfield        #79  <Field JPanel m_aboutPanel>
    //   40   90:invokevirtual   #623 <Method Container JPanel.getTopLevelAncestor()>
    //   41   93:invokevirtual   #627 <Method Point Container.getLocationOnScreen()>
    //   42   96:getfield        #638 <Field int Point.y>
    //   43   99:invokevirtual   #660 <Method void PropertySheetPanel$CapabilitiesHelpDialog.setLocation(int, int)>
        m_CapabilitiesDialog.setVisible(true);
    //   44  102:aload_0         
    //   45  103:getfield        #655 <Field PropertySheetPanel$CapabilitiesHelpDialog m_CapabilitiesDialog>
    //   46  106:iconst_1        
    //   47  107:invokevirtual   #661 <Method void PropertySheetPanel$CapabilitiesHelpDialog.setVisible(boolean)>
        addPropertyChangeListener(m_CapabilitiesDialog);
    //   48  110:aload_0         
    //   49  111:aload_0         
    //   50  112:getfield        #655 <Field PropertySheetPanel$CapabilitiesHelpDialog m_CapabilitiesDialog>
    //   51  115:invokevirtual   #662 <Method void addPropertyChangeListener(PropertyChangeListener)>
    //   52  118:return          
    }

    public int editableProperties()
    {
        return m_NumEditable;
    //    0    0:aload_0         
    //    1    1:getfield        #54  <Field int m_NumEditable>
    //    2    4:ireturn         
    }

    synchronized void wasModified(PropertyChangeEvent evt)
    {
        if(evt.getSource() instanceof PropertyEditor)
    //*   0    0:aload_1         
    //*   1    1:invokevirtual   #669 <Method Object PropertyChangeEvent.getSource()>
    //*   2    4:instanceof      #356 <Class PropertyEditor>
    //*   3    7:ifeq            463
        {
            PropertyEditor editor = (PropertyEditor)evt.getSource();
    //    4   10:aload_1         
    //    5   11:invokevirtual   #669 <Method Object PropertyChangeEvent.getSource()>
    //    6   14:checkcast       #356 <Class PropertyEditor>
    //    7   17:astore_2        
            for(int i = 0; i < m_Editors.length; i++)
    //*   8   18:iconst_0        
    //*   9   19:istore_3        
    //*  10   20:goto            454
            {
                if(m_Editors[i] != editor)
                    continue;
    //   11   23:aload_0         
    //   12   24:getfield        #358 <Field PropertyEditor[] m_Editors>
    //   13   27:iload_3         
    //   14   28:aaload          
    //   15   29:aload_2         
    //   16   30:if_acmpne       451
                PropertyDescriptor property = m_Properties[i];
    //   17   33:aload_0         
    //   18   34:getfield        #157 <Field PropertyDescriptor[] m_Properties>
    //   19   37:iload_3         
    //   20   38:aaload          
    //   21   39:astore          4
                Object value = editor.getValue();
    //   22   41:aload_2         
    //   23   42:invokeinterface #672 <Method Object PropertyEditor.getValue()>
    //   24   47:astore          5
                m_Values[i] = value;
    //   25   49:aload_0         
    //   26   50:getfield        #360 <Field Object[] m_Values>
    //   27   53:iload_3         
    //   28   54:aload           5
    //   29   56:aastore         
                Method setter = property.getWriteMethod();
    //   30   57:aload           4
    //   31   59:invokevirtual   #389 <Method Method PropertyDescriptor.getWriteMethod()>
    //   32   62:astore          6
                try
                {
                    Object args[] = {
                        value
                    };
    //   33   64:iconst_1        
    //   34   65:anewarray       Object[]
    //   35   68:dup             
    //   36   69:iconst_0        
    //   37   70:aload           5
    //   38   72:aastore         
    //   39   73:astore          7
                    args[0] = value;
    //   40   75:aload           7
    //   41   77:iconst_0        
    //   42   78:aload           5
    //   43   80:aastore         
                    setter.invoke(m_Target, args);
    //   44   81:aload           6
    //   45   83:aload_0         
    //   46   84:getfield        #137 <Field Object m_Target>
    //   47   87:aload           7
    //   48   89:invokevirtual   #210 <Method Object Method.invoke(Object, Object[])>
    //   49   92:pop             
                }
    //*  50   93:goto            414
                catch(InvocationTargetException ex)
    //*  51   96:astore          7
                {
                    if(ex.getTargetException() instanceof PropertyVetoException)
    //*  52   98:aload           7
    //*  53  100:invokevirtual   #463 <Method Throwable InvocationTargetException.getTargetException()>
    //*  54  103:instanceof      #674 <Class PropertyVetoException>
    //*  55  106:ifeq            207
                    {
                        String message = (new StringBuilder("WARNING: Vetoed; reason is: ")).append(ex.getTargetException().getMessage()).toString();
    //   56  109:new             #246 <Class StringBuilder>
    //   57  112:dup             
    //   58  113:ldc2            #676 <String "WARNING: Vetoed; reason is: ">
    //   59  116:invokespecial   #249 <Method void StringBuilder(String)>
    //   60  119:aload           7
    //   61  121:invokevirtual   #463 <Method Throwable InvocationTargetException.getTargetException()>
    //   62  124:invokevirtual   #679 <Method String Throwable.getMessage()>
    //   63  127:invokevirtual   #252 <Method StringBuilder StringBuilder.append(String)>
    //   64  130:invokevirtual   #255 <Method String StringBuilder.toString()>
    //   65  133:astore          8
                        System.err.println(message);
    //   66  135:getstatic       #169 <Field PrintStream System.err>
    //   67  138:aload           8
    //   68  140:invokevirtual   #177 <Method void PrintStream.println(String)>
                        Component jf;
                        if(evt.getSource() instanceof JPanel)
    //*  69  143:aload_1         
    //*  70  144:invokevirtual   #669 <Method Object PropertyChangeEvent.getSource()>
    //*  71  147:instanceof      #4   <Class JPanel>
    //*  72  150:ifeq            168
                            jf = ((JPanel)evt.getSource()).getParent();
    //   73  153:aload_1         
    //   74  154:invokevirtual   #669 <Method Object PropertyChangeEvent.getSource()>
    //   75  157:checkcast       #4   <Class JPanel>
    //   76  160:invokevirtual   #682 <Method Container JPanel.getParent()>
    //   77  163:astore          9
                        else
    //*  78  165:goto            177
                            jf = new JFrame();
    //   79  168:new             #684 <Class JFrame>
    //   80  171:dup             
    //   81  172:invokespecial   #685 <Method void JFrame()>
    //   82  175:astore          9
                        JOptionPane.showMessageDialog(jf, message, "error", 2);
    //   83  177:aload           9
    //   84  179:aload           8
    //   85  181:ldc2            #687 <String "error">
    //   86  184:iconst_2        
    //   87  185:invokestatic    #693 <Method void JOptionPane.showMessageDialog(Component, Object, String, int)>
                        if(jf instanceof JFrame)
    //*  88  188:aload           9
    //*  89  190:instanceof      #684 <Class JFrame>
    //*  90  193:ifeq            414
                            ((JFrame)jf).dispose();
    //   91  196:aload           9
    //   92  198:checkcast       #684 <Class JFrame>
    //   93  201:invokevirtual   #696 <Method void JFrame.dispose()>
                    } else
    //*  94  204:goto            414
                    {
                        System.err.println((new StringBuilder(String.valueOf(ex.getTargetException().getClass().getName()))).append(" while updating ").append(property.getName()).append(": ").append(ex.getTargetException().getMessage()).toString());
    //   95  207:getstatic       #169 <Field PrintStream System.err>
    //   96  210:new             #246 <Class StringBuilder>
    //   97  213:dup             
    //   98  214:aload           7
    //   99  216:invokevirtual   #463 <Method Throwable InvocationTargetException.getTargetException()>
    //  100  219:invokevirtual   #143 <Method Class Object.getClass()>
    //  101  222:invokevirtual   #223 <Method String Class.getName()>
    //  102  225:invokestatic    #418 <Method String String.valueOf(Object)>
    //  103  228:invokespecial   #249 <Method void StringBuilder(String)>
    //  104  231:ldc2            #698 <String " while updating ">
    //  105  234:invokevirtual   #252 <Method StringBuilder StringBuilder.append(String)>
    //  106  237:aload           4
    //  107  239:invokevirtual   #699 <Method String PropertyDescriptor.getName()>
    //  108  242:invokevirtual   #252 <Method StringBuilder StringBuilder.append(String)>
    //  109  245:ldc2            #701 <String ": ">
    //  110  248:invokevirtual   #252 <Method StringBuilder StringBuilder.append(String)>
    //  111  251:aload           7
    //  112  253:invokevirtual   #463 <Method Throwable InvocationTargetException.getTargetException()>
    //  113  256:invokevirtual   #679 <Method String Throwable.getMessage()>
    //  114  259:invokevirtual   #252 <Method StringBuilder StringBuilder.append(String)>
    //  115  262:invokevirtual   #255 <Method String StringBuilder.toString()>
    //  116  265:invokevirtual   #177 <Method void PrintStream.println(String)>
                        Component jf;
                        if(evt.getSource() instanceof JPanel)
    //* 117  268:aload_1         
    //* 118  269:invokevirtual   #669 <Method Object PropertyChangeEvent.getSource()>
    //* 119  272:instanceof      #4   <Class JPanel>
    //* 120  275:ifeq            293
                            jf = ((JPanel)evt.getSource()).getParent();
    //  121  278:aload_1         
    //  122  279:invokevirtual   #669 <Method Object PropertyChangeEvent.getSource()>
    //  123  282:checkcast       #4   <Class JPanel>
    //  124  285:invokevirtual   #682 <Method Container JPanel.getParent()>
    //  125  288:astore          8
                        else
    //* 126  290:goto            302
                            jf = new JFrame();
    //  127  293:new             #684 <Class JFrame>
    //  128  296:dup             
    //  129  297:invokespecial   #685 <Method void JFrame()>
    //  130  300:astore          8
                        JOptionPane.showMessageDialog(jf, (new StringBuilder(String.valueOf(ex.getTargetException().getClass().getName()))).append(" while updating ").append(property.getName()).append(":\n").append(ex.getTargetException().getMessage()).toString(), "error", 2);
    //  131  302:aload           8
    //  132  304:new             #246 <Class StringBuilder>
    //  133  307:dup             
    //  134  308:aload           7
    //  135  310:invokevirtual   #463 <Method Throwable InvocationTargetException.getTargetException()>
    //  136  313:invokevirtual   #143 <Method Class Object.getClass()>
    //  137  316:invokevirtual   #223 <Method String Class.getName()>
    //  138  319:invokestatic    #418 <Method String String.valueOf(Object)>
    //  139  322:invokespecial   #249 <Method void StringBuilder(String)>
    //  140  325:ldc2            #698 <String " while updating ">
    //  141  328:invokevirtual   #252 <Method StringBuilder StringBuilder.append(String)>
    //  142  331:aload           4
    //  143  333:invokevirtual   #699 <Method String PropertyDescriptor.getName()>
    //  144  336:invokevirtual   #252 <Method StringBuilder StringBuilder.append(String)>
    //  145  339:ldc2            #703 <String ":\n">
    //  146  342:invokevirtual   #252 <Method StringBuilder StringBuilder.append(String)>
    //  147  345:aload           7
    //  148  347:invokevirtual   #463 <Method Throwable InvocationTargetException.getTargetException()>
    //  149  350:invokevirtual   #679 <Method String Throwable.getMessage()>
    //  150  353:invokevirtual   #252 <Method StringBuilder StringBuilder.append(String)>
    //  151  356:invokevirtual   #255 <Method String StringBuilder.toString()>
    //  152  359:ldc2            #687 <String "error">
    //  153  362:iconst_2        
    //  154  363:invokestatic    #693 <Method void JOptionPane.showMessageDialog(Component, Object, String, int)>
                        if(jf instanceof JFrame)
    //* 155  366:aload           8
    //* 156  368:instanceof      #684 <Class JFrame>
    //* 157  371:ifeq            414
                            ((JFrame)jf).dispose();
    //  158  374:aload           8
    //  159  376:checkcast       #684 <Class JFrame>
    //  160  379:invokevirtual   #696 <Method void JFrame.dispose()>
                    }
                }
    //* 161  382:goto            414
                catch(Exception ex)
    //* 162  385:astore          7
                {
                    System.err.println((new StringBuilder("Unexpected exception while updating ")).append(property.getName()).toString());
    //  163  387:getstatic       #169 <Field PrintStream System.err>
    //  164  390:new             #246 <Class StringBuilder>
    //  165  393:dup             
    //  166  394:ldc2            #705 <String "Unexpected exception while updating ">
    //  167  397:invokespecial   #249 <Method void StringBuilder(String)>
    //  168  400:aload           4
    //  169  402:invokevirtual   #699 <Method String PropertyDescriptor.getName()>
    //  170  405:invokevirtual   #252 <Method StringBuilder StringBuilder.append(String)>
    //  171  408:invokevirtual   #255 <Method String StringBuilder.toString()>
    //  172  411:invokevirtual   #177 <Method void PrintStream.println(String)>
                }
                if(m_Views[i] != null && (m_Views[i] instanceof PropertyPanel))
    //* 173  414:aload_0         
    //* 174  415:getfield        #364 <Field JComponent[] m_Views>
    //* 175  418:iload_3         
    //* 176  419:aaload          
    //* 177  420:ifnull          463
    //* 178  423:aload_0         
    //* 179  424:getfield        #364 <Field JComponent[] m_Views>
    //* 180  427:iload_3         
    //* 181  428:aaload          
    //* 182  429:instanceof      #432 <Class PropertyPanel>
    //* 183  432:ifeq            463
                {
                    m_Views[i].repaint();
    //  184  435:aload_0         
    //  185  436:getfield        #364 <Field JComponent[] m_Views>
    //  186  439:iload_3         
    //  187  440:aaload          
    //  188  441:invokevirtual   #708 <Method void JComponent.repaint()>
                    revalidate();
    //  189  444:aload_0         
    //  190  445:invokevirtual   #711 <Method void revalidate()>
                }
                break;
    //  191  448:goto            463
            }

    //  192  451:iinc            3  1
    //  193  454:iload_3         
    //  194  455:aload_0         
    //  195  456:getfield        #358 <Field PropertyEditor[] m_Editors>
    //  196  459:arraylength     
    //  197  460:icmplt          23
        }
        for(int i = 0; i < m_Properties.length; i++)
    //* 198  463:iconst_0        
    //* 199  464:istore_2        
    //* 200  465:goto            634
        {
            Object o;
            try
            {
                Method getter = m_Properties[i].getReadMethod();
    //  201  468:aload_0         
    //  202  469:getfield        #157 <Field PropertyDescriptor[] m_Properties>
    //  203  472:iload_2         
    //  204  473:aaload          
    //  205  474:invokevirtual   #386 <Method Method PropertyDescriptor.getReadMethod()>
    //  206  477:astore          4
                Method setter = m_Properties[i].getWriteMethod();
    //  207  479:aload_0         
    //  208  480:getfield        #157 <Field PropertyDescriptor[] m_Properties>
    //  209  483:iload_2         
    //  210  484:aaload          
    //  211  485:invokevirtual   #389 <Method Method PropertyDescriptor.getWriteMethod()>
    //  212  488:astore          5
                if(getter == null || setter == null)
    //* 213  490:aload           4
    //* 214  492:ifnull          631
    //* 215  495:aload           5
    //* 216  497:ifnonnull       503
                    continue;
    //  217  500:goto            631
                Object args[] = new Object[0];
    //  218  503:iconst_0        
    //  219  504:anewarray       Object[]
    //  220  507:astore          6
                o = getter.invoke(m_Target, args);
    //  221  509:aload           4
    //  222  511:aload_0         
    //  223  512:getfield        #137 <Field Object m_Target>
    //  224  515:aload           6
    //  225  517:invokevirtual   #210 <Method Object Method.invoke(Object, Object[])>
    //  226  520:astore_3        
            }
    //* 227  521:goto            528
            catch(Exception ex)
    //* 228  524:astore          4
            {
                o = null;
    //  229  526:aconst_null     
    //  230  527:astore_3        
            }
            if(o != m_Values[i] && (o == null || !o.equals(m_Values[i])))
    //* 231  528:aload_3         
    //* 232  529:aload_0         
    //* 233  530:getfield        #360 <Field Object[] m_Values>
    //* 234  533:iload_2         
    //* 235  534:aaload          
    //* 236  535:if_acmpeq       631
    //* 237  538:aload_3         
    //* 238  539:ifnull          558
    //* 239  542:aload_3         
    //* 240  543:aload_0         
    //* 241  544:getfield        #360 <Field Object[] m_Values>
    //* 242  547:iload_2         
    //* 243  548:aaload          
    //* 244  549:invokevirtual   #206 <Method boolean Object.equals(Object)>
    //* 245  552:ifeq            558
    //* 246  555:goto            631
            {
                m_Values[i] = o;
    //  247  558:aload_0         
    //  248  559:getfield        #360 <Field Object[] m_Values>
    //  249  562:iload_2         
    //  250  563:aload_3         
    //  251  564:aastore         
                if(m_Editors[i] != null)
    //* 252  565:aload_0         
    //* 253  566:getfield        #358 <Field PropertyEditor[] m_Editors>
    //* 254  569:iload_2         
    //* 255  570:aaload          
    //* 256  571:ifnonnull       577
    //* 257  574:goto            631
                {
                    m_Editors[i].removePropertyChangeListener(this);
    //  258  577:aload_0         
    //  259  578:getfield        #358 <Field PropertyEditor[] m_Editors>
    //  260  581:iload_2         
    //  261  582:aaload          
    //  262  583:aload_0         
    //  263  584:invokeinterface #712 <Method void PropertyEditor.removePropertyChangeListener(PropertyChangeListener)>
                    m_Editors[i].setValue(o);
    //  264  589:aload_0         
    //  265  590:getfield        #358 <Field PropertyEditor[] m_Editors>
    //  266  593:iload_2         
    //  267  594:aaload          
    //  268  595:aload_3         
    //  269  596:invokeinterface #414 <Method void PropertyEditor.setValue(Object)>
                    m_Editors[i].addPropertyChangeListener(this);
    //  270  601:aload_0         
    //  271  602:getfield        #358 <Field PropertyEditor[] m_Editors>
    //  272  605:iload_2         
    //  273  606:aaload          
    //  274  607:aload_0         
    //  275  608:invokeinterface #453 <Method void PropertyEditor.addPropertyChangeListener(PropertyChangeListener)>
                    if(m_Views[i] != null)
    //* 276  613:aload_0         
    //* 277  614:getfield        #364 <Field JComponent[] m_Views>
    //* 278  617:iload_2         
    //* 279  618:aaload          
    //* 280  619:ifnull          631
                        m_Views[i].repaint();
    //  281  622:aload_0         
    //  282  623:getfield        #364 <Field JComponent[] m_Views>
    //  283  626:iload_2         
    //  284  627:aaload          
    //  285  628:invokevirtual   #708 <Method void JComponent.repaint()>
                }
            }
        }

    //  286  631:iinc            2  1
    //  287  634:iload_2         
    //  288  635:aload_0         
    //  289  636:getfield        #157 <Field PropertyDescriptor[] m_Properties>
    //  290  639:arraylength     
    //  291  640:icmplt          468
        if(Beans.isInstanceOf(m_Target, java/awt/Component))
    //* 292  643:aload_0         
    //* 293  644:getfield        #137 <Field Object m_Target>
    //* 294  647:ldc2            #714 <Class Component>
    //* 295  650:invokestatic    #720 <Method boolean Beans.isInstanceOf(Object, Class)>
    //* 296  653:ifeq            672
            ((Component)Beans.getInstanceOf(m_Target, java/awt/Component)).repaint();
    //  297  656:aload_0         
    //  298  657:getfield        #137 <Field Object m_Target>
    //  299  660:ldc2            #714 <Class Component>
    //  300  663:invokestatic    #724 <Method Object Beans.getInstanceOf(Object, Class)>
    //  301  666:checkcast       #714 <Class Component>
    //  302  669:invokevirtual   #725 <Method void Component.repaint()>
    //  303  672:return          
    }

    private static final long serialVersionUID = 0x83ef52e49f375d77L;
    private Object m_Target;
    private PropertyDescriptor m_Properties[];
    private MethodDescriptor m_Methods[];
    private PropertyEditor m_Editors[];
    private Object m_Values[];
    private JComponent m_Views[];
    private JLabel m_Labels[];
    private String m_TipTexts[];
    private StringBuffer m_HelpText;
    private JDialog m_HelpDialog;
    private CapabilitiesHelpDialog m_CapabilitiesDialog;
    private JButton m_HelpBut;
    private JButton m_CapabilitiesBut;
    private JTextArea m_CapabilitiesText;
    private int m_NumEditable;
    private JPanel m_aboutPanel;
    private PropertyChangeSupport support;
    static Class class$0;
    static Class class$1;


/*
    static void access$0(PropertySheetPanel propertysheetpanel, JTextArea jtextarea)
    {
        propertysheetpanel.m_CapabilitiesText = jtextarea;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #735 <Field JTextArea m_CapabilitiesText>
        return;
    //    3    5:return          
    }

*/


/*
    static JTextArea access$1(PropertySheetPanel propertysheetpanel)
    {
        return propertysheetpanel.m_CapabilitiesText;
    //    0    0:aload_0         
    //    1    1:getfield        #735 <Field JTextArea m_CapabilitiesText>
    //    2    4:areturn         
    }

*/


/*
    static CapabilitiesHelpDialog access$2(PropertySheetPanel propertysheetpanel)
    {
        return propertysheetpanel.m_CapabilitiesDialog;
    //    0    0:aload_0         
    //    1    1:getfield        #655 <Field PropertySheetPanel$CapabilitiesHelpDialog m_CapabilitiesDialog>
    //    2    4:areturn         
    }

*/


/*
    static JButton access$3(PropertySheetPanel propertysheetpanel)
    {
        return propertysheetpanel.m_CapabilitiesBut;
    //    0    0:aload_0         
    //    1    1:getfield        #273 <Field JButton m_CapabilitiesBut>
    //    2    4:areturn         
    }

*/


/*
    static Object access$4(PropertySheetPanel propertysheetpanel)
    {
        return propertysheetpanel.m_Target;
    //    0    0:aload_0         
    //    1    1:getfield        #137 <Field Object m_Target>
    //    2    4:areturn         
    }

*/


/*
    static JButton access$5(PropertySheetPanel propertysheetpanel)
    {
        return propertysheetpanel.m_HelpBut;
    //    0    0:aload_0         
    //    1    1:getfield        #244 <Field JButton m_HelpBut>
    //    2    4:areturn         
    }

*/


/*
    static JDialog access$6(PropertySheetPanel propertysheetpanel)
    {
        return propertysheetpanel.m_HelpDialog;
    //    0    0:aload_0         
    //    1    1:getfield        #644 <Field JDialog m_HelpDialog>
    //    2    4:areturn         
    }

*/
}
