// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   CheckBoxList.java

package rm.gui;

import java.awt.Component;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;

public class CheckBoxList extends JList
{
    protected class CheckBoxListItem
    {

        public Object getContent()
        {
            return m_Content;
        //    0    0:aload_0         
        //    1    1:getfield        #30  <Field Object m_Content>
        //    2    4:areturn         
        }

        public void setChecked(boolean value)
        {
            m_Checked = value;
        //    0    0:aload_0         
        //    1    1:iload_1         
        //    2    2:putfield        #28  <Field boolean m_Checked>
        //    3    5:return          
        }

        public boolean getChecked()
        {
            return m_Checked;
        //    0    0:aload_0         
        //    1    1:getfield        #28  <Field boolean m_Checked>
        //    2    4:ireturn         
        }

        public String toString()
        {
            return m_Content.toString();
        //    0    0:aload_0         
        //    1    1:getfield        #30  <Field Object m_Content>
        //    2    4:invokevirtual   #42  <Method String Object.toString()>
        //    3    7:areturn         
        }

        public boolean equals(Object o)
        {
            if(!(o instanceof CheckBoxListItem))
        //*   0    0:aload_1         
        //*   1    1:instanceof      #2   <Class CheckBoxList$CheckBoxListItem>
        //*   2    4:ifne            17
                throw new IllegalArgumentException("Must be a CheckBoxListItem!");
        //    3    7:new             #46  <Class IllegalArgumentException>
        //    4   10:dup             
        //    5   11:ldc1            #48  <String "Must be a CheckBoxListItem!">
        //    6   13:invokespecial   #51  <Method void IllegalArgumentException(String)>
        //    7   16:athrow          
            else
                return getContent().equals(((CheckBoxListItem)o).getContent());
        //    8   17:aload_0         
        //    9   18:invokevirtual   #53  <Method Object getContent()>
        //   10   21:aload_1         
        //   11   22:checkcast       #2   <Class CheckBoxList$CheckBoxListItem>
        //   12   25:invokevirtual   #53  <Method Object getContent()>
        //   13   28:invokevirtual   #55  <Method boolean Object.equals(Object)>
        //   14   31:ireturn         
        }

        private boolean m_Checked;
        private Object m_Content;
        final CheckBoxList this$0;

        public CheckBoxListItem(Object o)
        {
            this(o, false);
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:aload_2         
        //    3    3:iconst_0        
        //    4    4:invokespecial   #16  <Method void CheckBoxList$CheckBoxListItem(CheckBoxList, Object, boolean)>
        //    5    7:return          
        }

        public CheckBoxListItem(Object o, boolean checked)
        {
            this$0 = CheckBoxList.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #23  <Field CheckBoxList this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #26  <Method void Object()>
            m_Checked = false;
        //    5    9:aload_0         
        //    6   10:iconst_0        
        //    7   11:putfield        #28  <Field boolean m_Checked>
            m_Content = null;
        //    8   14:aload_0         
        //    9   15:aconst_null     
        //   10   16:putfield        #30  <Field Object m_Content>
            m_Checked = checked;
        //   11   19:aload_0         
        //   12   20:iload_3         
        //   13   21:putfield        #28  <Field boolean m_Checked>
            m_Content = o;
        //   14   24:aload_0         
        //   15   25:aload_2         
        //   16   26:putfield        #30  <Field Object m_Content>
        //   17   29:return          
        }
    }

    public class CheckBoxListModel extends DefaultListModel
    {

        public void add(int index, Object element)
        {
            if(!(element instanceof CheckBoxListItem))
        //*   0    0:aload_2         
        //*   1    1:instanceof      #48  <Class CheckBoxList$CheckBoxListItem>
        //*   2    4:ifne            27
                super.add(index, new CheckBoxListItem(element));
        //    3    7:aload_0         
        //    4    8:iload_1         
        //    5    9:new             #48  <Class CheckBoxList$CheckBoxListItem>
        //    6   12:dup             
        //    7   13:aload_0         
        //    8   14:getfield        #16  <Field CheckBoxList this$0>
        //    9   17:aload_2         
        //   10   18:invokespecial   #51  <Method void CheckBoxList$CheckBoxListItem(CheckBoxList, Object)>
        //   11   21:invokespecial   #53  <Method void DefaultListModel.add(int, Object)>
            else
        //*  12   24:goto            33
                super.add(index, element);
        //   13   27:aload_0         
        //   14   28:iload_1         
        //   15   29:aload_2         
        //   16   30:invokespecial   #53  <Method void DefaultListModel.add(int, Object)>
        //   17   33:return          
        }

        public void addElement(Object obj)
        {
            if(!(obj instanceof CheckBoxListItem))
        //*   0    0:aload_1         
        //*   1    1:instanceof      #48  <Class CheckBoxList$CheckBoxListItem>
        //*   2    4:ifne            26
                super.addElement(new CheckBoxListItem(obj));
        //    3    7:aload_0         
        //    4    8:new             #48  <Class CheckBoxList$CheckBoxListItem>
        //    5   11:dup             
        //    6   12:aload_0         
        //    7   13:getfield        #16  <Field CheckBoxList this$0>
        //    8   16:aload_1         
        //    9   17:invokespecial   #51  <Method void CheckBoxList$CheckBoxListItem(CheckBoxList, Object)>
        //   10   20:invokespecial   #57  <Method void DefaultListModel.addElement(Object)>
            else
        //*  11   23:goto            31
                super.addElement(obj);
        //   12   26:aload_0         
        //   13   27:aload_1         
        //   14   28:invokespecial   #57  <Method void DefaultListModel.addElement(Object)>
        //   15   31:return          
        }

        public boolean contains(Object elem)
        {
            if(!(elem instanceof CheckBoxListItem))
        //*   0    0:aload_1         
        //*   1    1:instanceof      #48  <Class CheckBoxList$CheckBoxListItem>
        //*   2    4:ifne            24
                return super.contains(new CheckBoxListItem(elem));
        //    3    7:aload_0         
        //    4    8:new             #48  <Class CheckBoxList$CheckBoxListItem>
        //    5   11:dup             
        //    6   12:aload_0         
        //    7   13:getfield        #16  <Field CheckBoxList this$0>
        //    8   16:aload_1         
        //    9   17:invokespecial   #51  <Method void CheckBoxList$CheckBoxListItem(CheckBoxList, Object)>
        //   10   20:invokespecial   #62  <Method boolean DefaultListModel.contains(Object)>
        //   11   23:ireturn         
            else
                return super.contains(elem);
        //   12   24:aload_0         
        //   13   25:aload_1         
        //   14   26:invokespecial   #62  <Method boolean DefaultListModel.contains(Object)>
        //   15   29:ireturn         
        }

        public void copyInto(Object anArray[])
        {
            if(anArray.length < getSize())
        //*   0    0:aload_1         
        //*   1    1:arraylength     
        //*   2    2:aload_0         
        //*   3    3:invokevirtual   #68  <Method int getSize()>
        //*   4    6:icmpge          19
                throw new IndexOutOfBoundsException("Array not big enough!");
        //    5    9:new             #70  <Class IndexOutOfBoundsException>
        //    6   12:dup             
        //    7   13:ldc1            #72  <String "Array not big enough!">
        //    8   15:invokespecial   #75  <Method void IndexOutOfBoundsException(String)>
        //    9   18:athrow          
            for(int i = 0; i < getSize(); i++)
        //*  10   19:iconst_0        
        //*  11   20:istore_2        
        //*  12   21:goto            41
                anArray[i] = ((CheckBoxListItem)getElementAt(i)).getContent();
        //   13   24:aload_1         
        //   14   25:iload_2         
        //   15   26:aload_0         
        //   16   27:iload_2         
        //   17   28:invokevirtual   #78  <Method Object getElementAt(int)>
        //   18   31:checkcast       #48  <Class CheckBoxList$CheckBoxListItem>
        //   19   34:invokevirtual   #82  <Method Object CheckBoxList$CheckBoxListItem.getContent()>
        //   20   37:aastore         

        //   21   38:iinc            2  1
        //   22   41:iload_2         
        //   23   42:aload_0         
        //   24   43:invokevirtual   #68  <Method int getSize()>
        //   25   46:icmplt          24
        //   26   49:return          
        }

        public Object elementAt(int index)
        {
            return ((CheckBoxListItem)super.elementAt(index)).getContent();
        //    0    0:aload_0         
        //    1    1:iload_1         
        //    2    2:invokespecial   #86  <Method Object DefaultListModel.elementAt(int)>
        //    3    5:checkcast       #48  <Class CheckBoxList$CheckBoxListItem>
        //    4    8:invokevirtual   #82  <Method Object CheckBoxList$CheckBoxListItem.getContent()>
        //    5   11:areturn         
        }

        public Object firstElement()
        {
            return ((CheckBoxListItem)super.firstElement()).getContent();
        //    0    0:aload_0         
        //    1    1:invokespecial   #89  <Method Object DefaultListModel.firstElement()>
        //    2    4:checkcast       #48  <Class CheckBoxList$CheckBoxListItem>
        //    3    7:invokevirtual   #82  <Method Object CheckBoxList$CheckBoxListItem.getContent()>
        //    4   10:areturn         
        }

        public Object get(int index)
        {
            return ((CheckBoxListItem)super.get(index)).getContent();
        //    0    0:aload_0         
        //    1    1:iload_1         
        //    2    2:invokespecial   #90  <Method Object DefaultListModel.get(int)>
        //    3    5:checkcast       #48  <Class CheckBoxList$CheckBoxListItem>
        //    4    8:invokevirtual   #82  <Method Object CheckBoxList$CheckBoxListItem.getContent()>
        //    5   11:areturn         
        }

        public Object getElementAt(int index)
        {
            return ((CheckBoxListItem)super.getElementAt(index)).getContent();
        //    0    0:aload_0         
        //    1    1:iload_1         
        //    2    2:invokespecial   #91  <Method Object DefaultListModel.getElementAt(int)>
        //    3    5:checkcast       #48  <Class CheckBoxList$CheckBoxListItem>
        //    4    8:invokevirtual   #82  <Method Object CheckBoxList$CheckBoxListItem.getContent()>
        //    5   11:areturn         
        }

        public int indexOf(Object elem)
        {
            if(!(elem instanceof CheckBoxListItem))
        //*   0    0:aload_1         
        //*   1    1:instanceof      #48  <Class CheckBoxList$CheckBoxListItem>
        //*   2    4:ifne            24
                return super.indexOf(new CheckBoxListItem(elem));
        //    3    7:aload_0         
        //    4    8:new             #48  <Class CheckBoxList$CheckBoxListItem>
        //    5   11:dup             
        //    6   12:aload_0         
        //    7   13:getfield        #16  <Field CheckBoxList this$0>
        //    8   16:aload_1         
        //    9   17:invokespecial   #51  <Method void CheckBoxList$CheckBoxListItem(CheckBoxList, Object)>
        //   10   20:invokespecial   #95  <Method int DefaultListModel.indexOf(Object)>
        //   11   23:ireturn         
            else
                return super.indexOf(elem);
        //   12   24:aload_0         
        //   13   25:aload_1         
        //   14   26:invokespecial   #95  <Method int DefaultListModel.indexOf(Object)>
        //   15   29:ireturn         
        }

        public int indexOf(Object elem, int index)
        {
            if(!(elem instanceof CheckBoxListItem))
        //*   0    0:aload_1         
        //*   1    1:instanceof      #48  <Class CheckBoxList$CheckBoxListItem>
        //*   2    4:ifne            25
                return super.indexOf(new CheckBoxListItem(elem), index);
        //    3    7:aload_0         
        //    4    8:new             #48  <Class CheckBoxList$CheckBoxListItem>
        //    5   11:dup             
        //    6   12:aload_0         
        //    7   13:getfield        #16  <Field CheckBoxList this$0>
        //    8   16:aload_1         
        //    9   17:invokespecial   #51  <Method void CheckBoxList$CheckBoxListItem(CheckBoxList, Object)>
        //   10   20:iload_2         
        //   11   21:invokespecial   #98  <Method int DefaultListModel.indexOf(Object, int)>
        //   12   24:ireturn         
            else
                return super.indexOf(elem, index);
        //   13   25:aload_0         
        //   14   26:aload_1         
        //   15   27:iload_2         
        //   16   28:invokespecial   #98  <Method int DefaultListModel.indexOf(Object, int)>
        //   17   31:ireturn         
        }

        public void insertElementAt(Object obj, int index)
        {
            if(!(obj instanceof CheckBoxListItem))
        //*   0    0:aload_1         
        //*   1    1:instanceof      #48  <Class CheckBoxList$CheckBoxListItem>
        //*   2    4:ifne            27
                super.insertElementAt(new CheckBoxListItem(obj), index);
        //    3    7:aload_0         
        //    4    8:new             #48  <Class CheckBoxList$CheckBoxListItem>
        //    5   11:dup             
        //    6   12:aload_0         
        //    7   13:getfield        #16  <Field CheckBoxList this$0>
        //    8   16:aload_1         
        //    9   17:invokespecial   #51  <Method void CheckBoxList$CheckBoxListItem(CheckBoxList, Object)>
        //   10   20:iload_2         
        //   11   21:invokespecial   #102 <Method void DefaultListModel.insertElementAt(Object, int)>
            else
        //*  12   24:goto            33
                super.insertElementAt(obj, index);
        //   13   27:aload_0         
        //   14   28:aload_1         
        //   15   29:iload_2         
        //   16   30:invokespecial   #102 <Method void DefaultListModel.insertElementAt(Object, int)>
        //   17   33:return          
        }

        public Object lastElement()
        {
            return ((CheckBoxListItem)super.lastElement()).getContent();
        //    0    0:aload_0         
        //    1    1:invokespecial   #105 <Method Object DefaultListModel.lastElement()>
        //    2    4:checkcast       #48  <Class CheckBoxList$CheckBoxListItem>
        //    3    7:invokevirtual   #82  <Method Object CheckBoxList$CheckBoxListItem.getContent()>
        //    4   10:areturn         
        }

        public int lastIndexOf(Object elem)
        {
            if(!(elem instanceof CheckBoxListItem))
        //*   0    0:aload_1         
        //*   1    1:instanceof      #48  <Class CheckBoxList$CheckBoxListItem>
        //*   2    4:ifne            24
                return super.lastIndexOf(new CheckBoxListItem(elem));
        //    3    7:aload_0         
        //    4    8:new             #48  <Class CheckBoxList$CheckBoxListItem>
        //    5   11:dup             
        //    6   12:aload_0         
        //    7   13:getfield        #16  <Field CheckBoxList this$0>
        //    8   16:aload_1         
        //    9   17:invokespecial   #51  <Method void CheckBoxList$CheckBoxListItem(CheckBoxList, Object)>
        //   10   20:invokespecial   #108 <Method int DefaultListModel.lastIndexOf(Object)>
        //   11   23:ireturn         
            else
                return super.lastIndexOf(elem);
        //   12   24:aload_0         
        //   13   25:aload_1         
        //   14   26:invokespecial   #108 <Method int DefaultListModel.lastIndexOf(Object)>
        //   15   29:ireturn         
        }

        public int lastIndexOf(Object elem, int index)
        {
            if(!(elem instanceof CheckBoxListItem))
        //*   0    0:aload_1         
        //*   1    1:instanceof      #48  <Class CheckBoxList$CheckBoxListItem>
        //*   2    4:ifne            25
                return super.lastIndexOf(new CheckBoxListItem(elem), index);
        //    3    7:aload_0         
        //    4    8:new             #48  <Class CheckBoxList$CheckBoxListItem>
        //    5   11:dup             
        //    6   12:aload_0         
        //    7   13:getfield        #16  <Field CheckBoxList this$0>
        //    8   16:aload_1         
        //    9   17:invokespecial   #51  <Method void CheckBoxList$CheckBoxListItem(CheckBoxList, Object)>
        //   10   20:iload_2         
        //   11   21:invokespecial   #110 <Method int DefaultListModel.lastIndexOf(Object, int)>
        //   12   24:ireturn         
            else
                return super.lastIndexOf(elem, index);
        //   13   25:aload_0         
        //   14   26:aload_1         
        //   15   27:iload_2         
        //   16   28:invokespecial   #110 <Method int DefaultListModel.lastIndexOf(Object, int)>
        //   17   31:ireturn         
        }

        public Object remove(int index)
        {
            return ((CheckBoxListItem)super.remove(index)).getContent();
        //    0    0:aload_0         
        //    1    1:iload_1         
        //    2    2:invokespecial   #113 <Method Object DefaultListModel.remove(int)>
        //    3    5:checkcast       #48  <Class CheckBoxList$CheckBoxListItem>
        //    4    8:invokevirtual   #82  <Method Object CheckBoxList$CheckBoxListItem.getContent()>
        //    5   11:areturn         
        }

        public boolean removeElement(Object obj)
        {
            if(!(obj instanceof CheckBoxListItem))
        //*   0    0:aload_1         
        //*   1    1:instanceof      #48  <Class CheckBoxList$CheckBoxListItem>
        //*   2    4:ifne            24
                return super.removeElement(new CheckBoxListItem(obj));
        //    3    7:aload_0         
        //    4    8:new             #48  <Class CheckBoxList$CheckBoxListItem>
        //    5   11:dup             
        //    6   12:aload_0         
        //    7   13:getfield        #16  <Field CheckBoxList this$0>
        //    8   16:aload_1         
        //    9   17:invokespecial   #51  <Method void CheckBoxList$CheckBoxListItem(CheckBoxList, Object)>
        //   10   20:invokespecial   #116 <Method boolean DefaultListModel.removeElement(Object)>
        //   11   23:ireturn         
            else
                return super.removeElement(obj);
        //   12   24:aload_0         
        //   13   25:aload_1         
        //   14   26:invokespecial   #116 <Method boolean DefaultListModel.removeElement(Object)>
        //   15   29:ireturn         
        }

        public Object set(int index, Object element)
        {
            if(!(element instanceof CheckBoxListItem))
        //*   0    0:aload_2         
        //*   1    1:instanceof      #48  <Class CheckBoxList$CheckBoxListItem>
        //*   2    4:ifne            31
                return ((CheckBoxListItem)super.set(index, new CheckBoxListItem(element))).getContent();
        //    3    7:aload_0         
        //    4    8:iload_1         
        //    5    9:new             #48  <Class CheckBoxList$CheckBoxListItem>
        //    6   12:dup             
        //    7   13:aload_0         
        //    8   14:getfield        #16  <Field CheckBoxList this$0>
        //    9   17:aload_2         
        //   10   18:invokespecial   #51  <Method void CheckBoxList$CheckBoxListItem(CheckBoxList, Object)>
        //   11   21:invokespecial   #120 <Method Object DefaultListModel.set(int, Object)>
        //   12   24:checkcast       #48  <Class CheckBoxList$CheckBoxListItem>
        //   13   27:invokevirtual   #82  <Method Object CheckBoxList$CheckBoxListItem.getContent()>
        //   14   30:areturn         
            else
                return ((CheckBoxListItem)super.set(index, element)).getContent();
        //   15   31:aload_0         
        //   16   32:iload_1         
        //   17   33:aload_2         
        //   18   34:invokespecial   #120 <Method Object DefaultListModel.set(int, Object)>
        //   19   37:checkcast       #48  <Class CheckBoxList$CheckBoxListItem>
        //   20   40:invokevirtual   #82  <Method Object CheckBoxList$CheckBoxListItem.getContent()>
        //   21   43:areturn         
        }

        public void setElementAt(Object obj, int index)
        {
            if(!(obj instanceof CheckBoxListItem))
        //*   0    0:aload_1         
        //*   1    1:instanceof      #48  <Class CheckBoxList$CheckBoxListItem>
        //*   2    4:ifne            27
                super.setElementAt(new CheckBoxListItem(obj), index);
        //    3    7:aload_0         
        //    4    8:new             #48  <Class CheckBoxList$CheckBoxListItem>
        //    5   11:dup             
        //    6   12:aload_0         
        //    7   13:getfield        #16  <Field CheckBoxList this$0>
        //    8   16:aload_1         
        //    9   17:invokespecial   #51  <Method void CheckBoxList$CheckBoxListItem(CheckBoxList, Object)>
        //   10   20:iload_2         
        //   11   21:invokespecial   #123 <Method void DefaultListModel.setElementAt(Object, int)>
            else
        //*  12   24:goto            33
                super.setElementAt(obj, index);
        //   13   27:aload_0         
        //   14   28:aload_1         
        //   15   29:iload_2         
        //   16   30:invokespecial   #123 <Method void DefaultListModel.setElementAt(Object, int)>
        //   17   33:return          
        }

        public Object[] toArray()
        {
            Object internal[] = super.toArray();
        //    0    0:aload_0         
        //    1    1:invokespecial   #127 <Method Object[] DefaultListModel.toArray()>
        //    2    4:astore_2        
            Object result[] = new Object[internal.length];
        //    3    5:aload_2         
        //    4    6:arraylength     
        //    5    7:anewarray       Object[]
        //    6   10:astore_1        
            for(int i = 0; i < internal.length; i++)
        //*   7   11:iconst_0        
        //*   8   12:istore_3        
        //*   9   13:goto            31
                result[i] = ((CheckBoxListItem)internal[i]).getContent();
        //   10   16:aload_1         
        //   11   17:iload_3         
        //   12   18:aload_2         
        //   13   19:iload_3         
        //   14   20:aaload          
        //   15   21:checkcast       #48  <Class CheckBoxList$CheckBoxListItem>
        //   16   24:invokevirtual   #82  <Method Object CheckBoxList$CheckBoxListItem.getContent()>
        //   17   27:aastore         

        //   18   28:iinc            3  1
        //   19   31:iload_3         
        //   20   32:aload_2         
        //   21   33:arraylength     
        //   22   34:icmplt          16
            return result;
        //   23   37:aload_1         
        //   24   38:areturn         
        }

        public boolean getChecked(int index)
        {
            return ((CheckBoxListItem)super.getElementAt(index)).getChecked();
        //    0    0:aload_0         
        //    1    1:iload_1         
        //    2    2:invokespecial   #91  <Method Object DefaultListModel.getElementAt(int)>
        //    3    5:checkcast       #48  <Class CheckBoxList$CheckBoxListItem>
        //    4    8:invokevirtual   #136 <Method boolean CheckBoxList$CheckBoxListItem.getChecked()>
        //    5   11:ireturn         
        }

        public void setChecked(int index, boolean checked)
        {
            ((CheckBoxListItem)super.getElementAt(index)).setChecked(checked);
        //    0    0:aload_0         
        //    1    1:iload_1         
        //    2    2:invokespecial   #91  <Method Object DefaultListModel.getElementAt(int)>
        //    3    5:checkcast       #48  <Class CheckBoxList$CheckBoxListItem>
        //    4    8:iload_2         
        //    5    9:invokevirtual   #141 <Method void CheckBoxList$CheckBoxListItem.setChecked(boolean)>
        //    6   12:return          
        }

        private static final long serialVersionUID = 0x6bdd4f18baa11963L;
        final CheckBoxList this$0;

        public CheckBoxListModel()
        {
            this$0 = CheckBoxList.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #16  <Field CheckBoxList this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #19  <Method void DefaultListModel()>
        //    5    9:return          
        }

        public CheckBoxListModel(Object listData[])
        {
            this$0 = CheckBoxList.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #16  <Field CheckBoxList this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #19  <Method void DefaultListModel()>
            for(int i = 0; i < listData.length; i++)
        //*   5    9:iconst_0        
        //*   6   10:istore_3        
        //*   7   11:goto            24
                addElement(listData[i]);
        //    8   14:aload_0         
        //    9   15:aload_2         
        //   10   16:iload_3         
        //   11   17:aaload          
        //   12   18:invokevirtual   #28  <Method void addElement(Object)>

        //   13   21:iinc            3  1
        //   14   24:iload_3         
        //   15   25:aload_2         
        //   16   26:arraylength     
        //   17   27:icmplt          14
        //   18   30:return          
        }

        public CheckBoxListModel(Vector listData)
        {
            this$0 = CheckBoxList.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #16  <Field CheckBoxList this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #19  <Method void DefaultListModel()>
            for(int i = 0; i < listData.size(); i++)
        //*   5    9:iconst_0        
        //*   6   10:istore_3        
        //*   7   11:goto            26
                addElement(listData.get(i));
        //    8   14:aload_0         
        //    9   15:aload_2         
        //   10   16:iload_3         
        //   11   17:invokevirtual   #39  <Method Object Vector.get(int)>
        //   12   20:invokevirtual   #28  <Method void addElement(Object)>

        //   13   23:iinc            3  1
        //   14   26:iload_3         
        //   15   27:aload_2         
        //   16   28:invokevirtual   #43  <Method int Vector.size()>
        //   17   31:icmplt          14
        //   18   34:return          
        }
    }

    public class CheckBoxListRenderer extends JCheckBox
        implements ListCellRenderer
    {

        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
        {
            setText(value.toString());
        //    0    0:aload_0         
        //    1    1:aload_2         
        //    2    2:invokevirtual   #33  <Method String Object.toString()>
        //    3    5:invokevirtual   #37  <Method void setText(String)>
            setSelected(((CheckBoxList)list).getChecked(index));
        //    4    8:aload_0         
        //    5    9:aload_1         
        //    6   10:checkcast       #39  <Class CheckBoxList>
        //    7   13:iload_3         
        //    8   14:invokevirtual   #43  <Method boolean CheckBoxList.getChecked(int)>
        //    9   17:invokevirtual   #47  <Method void setSelected(boolean)>
            setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
        //   10   20:aload_0         
        //   11   21:iload           4
        //   12   23:ifeq            33
        //   13   26:aload_1         
        //   14   27:invokevirtual   #53  <Method java.awt.Color JList.getSelectionBackground()>
        //   15   30:goto            37
        //   16   33:aload_1         
        //   17   34:invokevirtual   #56  <Method java.awt.Color JList.getBackground()>
        //   18   37:invokevirtual   #60  <Method void setBackground(java.awt.Color)>
            setForeground(isSelected ? list.getSelectionForeground() : list.getForeground());
        //   19   40:aload_0         
        //   20   41:iload           4
        //   21   43:ifeq            53
        //   22   46:aload_1         
        //   23   47:invokevirtual   #63  <Method java.awt.Color JList.getSelectionForeground()>
        //   24   50:goto            57
        //   25   53:aload_1         
        //   26   54:invokevirtual   #66  <Method java.awt.Color JList.getForeground()>
        //   27   57:invokevirtual   #69  <Method void setForeground(java.awt.Color)>
            setFocusPainted(false);
        //   28   60:aload_0         
        //   29   61:iconst_0        
        //   30   62:invokevirtual   #72  <Method void setFocusPainted(boolean)>
            return this;
        //   31   65:aload_0         
        //   32   66:areturn         
        }

        private static final long serialVersionUID = 0xeb46cf39a2eddaaL;
        final CheckBoxList this$0;

        public CheckBoxListRenderer()
        {
            this$0 = CheckBoxList.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #18  <Field CheckBoxList this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #21  <Method void JCheckBox()>
        //    5    9:return          
        }
    }


    public CheckBoxList()
    {
        this(null);
    //    0    0:aload_0         
    //    1    1:aconst_null     
    //    2    2:invokespecial   #15  <Method void CheckBoxList(CheckBoxList$CheckBoxListModel)>
    //    3    5:return          
    }

    public CheckBoxList(CheckBoxListModel model)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #21  <Method void JList()>
        if(model == null)
    //*   2    4:aload_1         
    //*   3    5:ifnonnull       22
            model = new CheckBoxListModel();
    //    4    8:new             #23  <Class CheckBoxList$CheckBoxListModel>
    //    5   11:dup             
    //    6   12:aload_0         
    //    7   13:dup             
    //    8   14:invokevirtual   #29  <Method Class Object.getClass()>
    //    9   17:pop             
    //   10   18:invokespecial   #32  <Method void CheckBoxList$CheckBoxListModel(CheckBoxList)>
    //   11   21:astore_1        
        setModel(model);
    //   12   22:aload_0         
    //   13   23:aload_1         
    //   14   24:invokevirtual   #36  <Method void setModel(ListModel)>
        setCellRenderer(new CheckBoxListRenderer());
    //   15   27:aload_0         
    //   16   28:new             #38  <Class CheckBoxList$CheckBoxListRenderer>
    //   17   31:dup             
    //   18   32:aload_0         
    //   19   33:invokespecial   #39  <Method void CheckBoxList$CheckBoxListRenderer(CheckBoxList)>
    //   20   36:invokevirtual   #43  <Method void setCellRenderer(ListCellRenderer)>
        addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e)
            {
                int index = locationToIndex(e.getPoint());
            //    0    0:aload_0         
            //    1    1:getfield        #11  <Field CheckBoxList this$0>
            //    2    4:aload_1         
            //    3    5:invokevirtual   #26  <Method java.awt.Point MouseEvent.getPoint()>
            //    4    8:invokevirtual   #32  <Method int CheckBoxList.locationToIndex(java.awt.Point)>
            //    5   11:istore_2        
                if(index != -1)
            //*   6   12:iload_2         
            //*   7   13:iconst_m1       
            //*   8   14:icmpeq          48
                {
                    setChecked(index, !getChecked(index));
            //    9   17:aload_0         
            //   10   18:getfield        #11  <Field CheckBoxList this$0>
            //   11   21:iload_2         
            //   12   22:aload_0         
            //   13   23:getfield        #11  <Field CheckBoxList this$0>
            //   14   26:iload_2         
            //   15   27:invokevirtual   #36  <Method boolean CheckBoxList.getChecked(int)>
            //   16   30:ifeq            37
            //   17   33:iconst_0        
            //   18   34:goto            38
            //   19   37:iconst_1        
            //   20   38:invokevirtual   #40  <Method void CheckBoxList.setChecked(int, boolean)>
                    repaint();
            //   21   41:aload_0         
            //   22   42:getfield        #11  <Field CheckBoxList this$0>
            //   23   45:invokevirtual   #43  <Method void CheckBoxList.repaint()>
                }
            //   24   48:return          
            }

            final CheckBoxList this$0;

            
            {
                this$0 = CheckBoxList.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #11  <Field CheckBoxList this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #14  <Method void MouseAdapter()>
            //    5    9:return          
            }
        }
);
    //   21   39:aload_0         
    //   22   40:new             #45  <Class CheckBoxList$1>
    //   23   43:dup             
    //   24   44:aload_0         
    //   25   45:invokespecial   #46  <Method void CheckBoxList$1(CheckBoxList)>
    //   26   48:invokevirtual   #50  <Method void addMouseListener(java.awt.event.MouseListener)>
        addKeyListener(new KeyAdapter() {

            public void keyTyped(KeyEvent e)
            {
                if(e.getKeyChar() == ' ' && e.getModifiers() == 0)
            //*   0    0:aload_1         
            //*   1    1:invokevirtual   #26  <Method char KeyEvent.getKeyChar()>
            //*   2    4:bipush          32
            //*   3    6:icmpne          59
            //*   4    9:aload_1         
            //*   5   10:invokevirtual   #30  <Method int KeyEvent.getModifiers()>
            //*   6   13:ifne            59
                {
                    int index = getSelectedIndex();
            //    7   16:aload_0         
            //    8   17:getfield        #11  <Field CheckBoxList this$0>
            //    9   20:invokevirtual   #35  <Method int CheckBoxList.getSelectedIndex()>
            //   10   23:istore_2        
                    setChecked(index, !getChecked(index));
            //   11   24:aload_0         
            //   12   25:getfield        #11  <Field CheckBoxList this$0>
            //   13   28:iload_2         
            //   14   29:aload_0         
            //   15   30:getfield        #11  <Field CheckBoxList this$0>
            //   16   33:iload_2         
            //   17   34:invokevirtual   #39  <Method boolean CheckBoxList.getChecked(int)>
            //   18   37:ifeq            44
            //   19   40:iconst_0        
            //   20   41:goto            45
            //   21   44:iconst_1        
            //   22   45:invokevirtual   #43  <Method void CheckBoxList.setChecked(int, boolean)>
                    e.consume();
            //   23   48:aload_1         
            //   24   49:invokevirtual   #46  <Method void KeyEvent.consume()>
                    repaint();
            //   25   52:aload_0         
            //   26   53:getfield        #11  <Field CheckBoxList this$0>
            //   27   56:invokevirtual   #49  <Method void CheckBoxList.repaint()>
                }
            //   28   59:return          
            }

            final CheckBoxList this$0;

            
            {
                this$0 = CheckBoxList.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #11  <Field CheckBoxList this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #14  <Method void KeyAdapter()>
            //    5    9:return          
            }
        }
);
    //   27   51:aload_0         
    //   28   52:new             #52  <Class CheckBoxList$2>
    //   29   55:dup             
    //   30   56:aload_0         
    //   31   57:invokespecial   #53  <Method void CheckBoxList$2(CheckBoxList)>
    //   32   60:invokevirtual   #57  <Method void addKeyListener(java.awt.event.KeyListener)>
    //   33   63:return          
    }

    public void setModel(ListModel model)
    {
        if(!(model instanceof CheckBoxListModel))
    //*   0    0:aload_1         
    //*   1    1:instanceof      #23  <Class CheckBoxList$CheckBoxListModel>
    //*   2    4:ifne            17
        {
            throw new IllegalArgumentException("Model must be an instance of CheckBoxListModel!");
    //    3    7:new             #61  <Class IllegalArgumentException>
    //    4   10:dup             
    //    5   11:ldc1            #63  <String "Model must be an instance of CheckBoxListModel!">
    //    6   13:invokespecial   #66  <Method void IllegalArgumentException(String)>
    //    7   16:athrow          
        } else
        {
            super.setModel(model);
    //    8   17:aload_0         
    //    9   18:aload_1         
    //   10   19:invokespecial   #67  <Method void JList.setModel(ListModel)>
            return;
    //   11   22:return          
        }
    }

    public void setListData(Object listData[])
    {
        setModel(new CheckBoxListModel(listData));
    //    0    0:aload_0         
    //    1    1:new             #23  <Class CheckBoxList$CheckBoxListModel>
    //    2    4:dup             
    //    3    5:aload_0         
    //    4    6:aload_1         
    //    5    7:invokespecial   #73  <Method void CheckBoxList$CheckBoxListModel(CheckBoxList, Object[])>
    //    6   10:invokevirtual   #36  <Method void setModel(ListModel)>
    //    7   13:return          
    }

    public void setListData(Vector listData)
    {
        setModel(new CheckBoxListModel(listData));
    //    0    0:aload_0         
    //    1    1:new             #23  <Class CheckBoxList$CheckBoxListModel>
    //    2    4:dup             
    //    3    5:aload_0         
    //    4    6:aload_1         
    //    5    7:invokespecial   #79  <Method void CheckBoxList$CheckBoxListModel(CheckBoxList, Vector)>
    //    6   10:invokevirtual   #36  <Method void setModel(ListModel)>
    //    7   13:return          
    }

    public boolean getChecked(int index)
    {
        return ((CheckBoxListModel)getModel()).getChecked(index);
    //    0    0:aload_0         
    //    1    1:invokevirtual   #86  <Method ListModel getModel()>
    //    2    4:checkcast       #23  <Class CheckBoxList$CheckBoxListModel>
    //    3    7:iload_1         
    //    4    8:invokevirtual   #88  <Method boolean CheckBoxList$CheckBoxListModel.getChecked(int)>
    //    5   11:ireturn         
    }

    public void setChecked(int index, boolean checked)
    {
        ((CheckBoxListModel)getModel()).setChecked(index, checked);
    //    0    0:aload_0         
    //    1    1:invokevirtual   #86  <Method ListModel getModel()>
    //    2    4:checkcast       #23  <Class CheckBoxList$CheckBoxListModel>
    //    3    7:iload_1         
    //    4    8:iload_2         
    //    5    9:invokevirtual   #94  <Method void CheckBoxList$CheckBoxListModel.setChecked(int, boolean)>
    //    6   12:return          
    }

    public int[] getCheckedIndices()
    {
        Vector list = new Vector();
    //    0    0:new             #100 <Class Vector>
    //    1    3:dup             
    //    2    4:invokespecial   #101 <Method void Vector()>
    //    3    7:astore_1        
        for(int i = 0; i < getModel().getSize(); i++)
    //*   4    8:iconst_0        
    //*   5    9:istore_3        
    //*   6   10:goto            37
            if(getChecked(i))
    //*   7   13:aload_0         
    //*   8   14:iload_3         
    //*   9   15:invokevirtual   #102 <Method boolean getChecked(int)>
    //*  10   18:ifeq            34
                list.add(new Integer(i));
    //   11   21:aload_1         
    //   12   22:new             #104 <Class Integer>
    //   13   25:dup             
    //   14   26:iload_3         
    //   15   27:invokespecial   #107 <Method void Integer(int)>
    //   16   30:invokevirtual   #111 <Method boolean Vector.add(Object)>
    //   17   33:pop             

    //   18   34:iinc            3  1
    //   19   37:iload_3         
    //   20   38:aload_0         
    //   21   39:invokevirtual   #86  <Method ListModel getModel()>
    //   22   42:invokeinterface #117 <Method int ListModel.getSize()>
    //   23   47:icmplt          13
        int result[] = new int[list.size()];
    //   24   50:aload_1         
    //   25   51:invokevirtual   #120 <Method int Vector.size()>
    //   26   54:newarray        int[]
    //   27   56:astore_2        
        for(int i = 0; i < list.size(); i++)
    //*  28   57:iconst_0        
    //*  29   58:istore_3        
    //*  30   59:goto            82
            result[i] = ((Integer)(Integer)list.get(i)).intValue();
    //   31   62:aload_2         
    //   32   63:iload_3         
    //   33   64:aload_1         
    //   34   65:iload_3         
    //   35   66:invokevirtual   #124 <Method Object Vector.get(int)>
    //   36   69:checkcast       #104 <Class Integer>
    //   37   72:checkcast       #104 <Class Integer>
    //   38   75:invokevirtual   #127 <Method int Integer.intValue()>
    //   39   78:iastore         

    //   40   79:iinc            3  1
    //   41   82:iload_3         
    //   42   83:aload_1         
    //   43   84:invokevirtual   #120 <Method int Vector.size()>
    //   44   87:icmplt          62
        return result;
    //   45   90:aload_2         
    //   46   91:areturn         
    }

    private static final long serialVersionUID = 0xc37faf1d6cab568eL;
}
