// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   PropertyValueSelector.java

package rm.gui;

import java.beans.PropertyEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

class PropertyValueSelector extends JComboBox
{

    public PropertyValueSelector(PropertyEditor pe)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #17  <Method void JComboBox()>
        m_Editor = pe;
    //    2    4:aload_0         
    //    3    5:aload_1         
    //    4    6:putfield        #19  <Field PropertyEditor m_Editor>
        Object value = m_Editor.getAsText();
    //    5    9:aload_0         
    //    6   10:getfield        #19  <Field PropertyEditor m_Editor>
    //    7   13:invokeinterface #25  <Method String PropertyEditor.getAsText()>
    //    8   18:astore_2        
        String tags[] = m_Editor.getTags();
    //    9   19:aload_0         
    //   10   20:getfield        #19  <Field PropertyEditor m_Editor>
    //   11   23:invokeinterface #29  <Method String[] PropertyEditor.getTags()>
    //   12   28:astore_3        
        javax.swing.ComboBoxModel model = new DefaultComboBoxModel(tags) {

            public Object getSelectedItem()
            {
                return m_Editor.getAsText();
            //    0    0:aload_0         
            //    1    1:getfield        #16  <Field PropertyValueSelector this$0>
            //    2    4:getfield        #33  <Field PropertyEditor PropertyValueSelector.m_Editor>
            //    3    7:invokeinterface #39  <Method String PropertyEditor.getAsText()>
            //    4   12:areturn         
            }

            public void setSelectedItem(Object o)
            {
                m_Editor.setAsText((String)o);
            //    0    0:aload_0         
            //    1    1:getfield        #16  <Field PropertyValueSelector this$0>
            //    2    4:getfield        #33  <Field PropertyEditor PropertyValueSelector.m_Editor>
            //    3    7:aload_1         
            //    4    8:checkcast       #43  <Class String>
            //    5   11:invokeinterface #47  <Method void PropertyEditor.setAsText(String)>
            //    6   16:return          
            }

            private static final long serialVersionUID = 0x6e39bd6388dd0bf5L;
            final PropertyValueSelector this$0;

            
            {
                this$0 = PropertyValueSelector.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #16  <Field PropertyValueSelector this$0>
                super($anonymous0);
            //    3    5:aload_0         
            //    4    6:aload_2         
            //    5    7:invokespecial   #19  <Method void DefaultComboBoxModel(Object[])>
            //    6   10:return          
            }
        }
;
    //   13   29:new             #31  <Class PropertyValueSelector$1>
    //   14   32:dup             
    //   15   33:aload_0         
    //   16   34:aload_3         
    //   17   35:invokespecial   #34  <Method void PropertyValueSelector$1(PropertyValueSelector, Object[])>
    //   18   38:astore          4
        setModel(model);
    //   19   40:aload_0         
    //   20   41:aload           4
    //   21   43:invokevirtual   #38  <Method void setModel(javax.swing.ComboBoxModel)>
        setSelectedItem(value);
    //   22   46:aload_0         
    //   23   47:aload_2         
    //   24   48:invokevirtual   #42  <Method void setSelectedItem(Object)>
    //   25   51:return          
    }

    private static final long serialVersionUID = 0x1c6e4d3cc729b9cL;
    PropertyEditor m_Editor;
}
