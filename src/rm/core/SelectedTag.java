// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   SelectedTag.java

package rm.core;

import java.util.HashSet;

// Referenced classes of package rm.core:
//            Tag

public class SelectedTag
{

    public SelectedTag(int tagID, Tag tags[])
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #14  <Method void Object()>
        HashSet ID = new HashSet();
    //    2    4:new             #16  <Class HashSet>
    //    3    7:dup             
    //    4    8:invokespecial   #17  <Method void HashSet()>
    //    5   11:astore_3        
        HashSet IDStr = new HashSet();
    //    6   12:new             #16  <Class HashSet>
    //    7   15:dup             
    //    8   16:invokespecial   #17  <Method void HashSet()>
    //    9   19:astore          4
        for(int i = 0; i < tags.length; i++)
    //*  10   21:iconst_0        
    //*  11   22:istore          5
    //*  12   24:goto            62
        {
            ID.add(new Integer(tags[i].getID()));
    //   13   27:aload_3         
    //   14   28:new             #19  <Class Integer>
    //   15   31:dup             
    //   16   32:aload_2         
    //   17   33:iload           5
    //   18   35:aaload          
    //   19   36:invokevirtual   #25  <Method int Tag.getID()>
    //   20   39:invokespecial   #28  <Method void Integer(int)>
    //   21   42:invokevirtual   #32  <Method boolean HashSet.add(Object)>
    //   22   45:pop             
            IDStr.add(tags[i].getIDStr());
    //   23   46:aload           4
    //   24   48:aload_2         
    //   25   49:iload           5
    //   26   51:aaload          
    //   27   52:invokevirtual   #36  <Method String Tag.getIDStr()>
    //   28   55:invokevirtual   #32  <Method boolean HashSet.add(Object)>
    //   29   58:pop             
        }

    //   30   59:iinc            5  1
    //   31   62:iload           5
    //   32   64:aload_2         
    //   33   65:arraylength     
    //   34   66:icmplt          27
        if(ID.size() != tags.length)
    //*  35   69:aload_3         
    //*  36   70:invokevirtual   #39  <Method int HashSet.size()>
    //*  37   73:aload_2         
    //*  38   74:arraylength     
    //*  39   75:icmpeq          88
            throw new IllegalArgumentException("The IDs are not unique!");
    //   40   78:new             #41  <Class IllegalArgumentException>
    //   41   81:dup             
    //   42   82:ldc1            #43  <String "The IDs are not unique!">
    //   43   84:invokespecial   #46  <Method void IllegalArgumentException(String)>
    //   44   87:athrow          
        if(IDStr.size() != tags.length)
    //*  45   88:aload           4
    //*  46   90:invokevirtual   #39  <Method int HashSet.size()>
    //*  47   93:aload_2         
    //*  48   94:arraylength     
    //*  49   95:icmpeq          108
            throw new IllegalArgumentException("The ID strings are not unique!");
    //   50   98:new             #41  <Class IllegalArgumentException>
    //   51  101:dup             
    //   52  102:ldc1            #48  <String "The ID strings are not unique!">
    //   53  104:invokespecial   #46  <Method void IllegalArgumentException(String)>
    //   54  107:athrow          
        for(int i = 0; i < tags.length; i++)
    //*  55  108:iconst_0        
    //*  56  109:istore          5
    //*  57  111:goto            140
            if(tags[i].getID() == tagID)
    //*  58  114:aload_2         
    //*  59  115:iload           5
    //*  60  117:aaload          
    //*  61  118:invokevirtual   #25  <Method int Tag.getID()>
    //*  62  121:iload_1         
    //*  63  122:icmpne          137
            {
                m_Selected = i;
    //   64  125:aload_0         
    //   65  126:iload           5
    //   66  128:putfield        #50  <Field int m_Selected>
                m_Tags = tags;
    //   67  131:aload_0         
    //   68  132:aload_2         
    //   69  133:putfield        #52  <Field Tag[] m_Tags>
                return;
    //   70  136:return          
            }

    //   71  137:iinc            5  1
    //   72  140:iload           5
    //   73  142:aload_2         
    //   74  143:arraylength     
    //   75  144:icmplt          114
        throw new IllegalArgumentException("Selected tag is not valid");
    //   76  147:new             #41  <Class IllegalArgumentException>
    //   77  150:dup             
    //   78  151:ldc1            #54  <String "Selected tag is not valid">
    //   79  153:invokespecial   #46  <Method void IllegalArgumentException(String)>
    //   80  156:athrow          
    }

    public SelectedTag(String tagText, Tag tags[])
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #14  <Method void Object()>
        for(int i = 0; i < tags.length; i++)
    //*   2    4:iconst_0        
    //*   3    5:istore_3        
    //*   4    6:goto            49
            if(tags[i].getReadable().equalsIgnoreCase(tagText) || tags[i].getIDStr().equalsIgnoreCase(tagText))
    //*   5    9:aload_2         
    //*   6   10:iload_3         
    //*   7   11:aaload          
    //*   8   12:invokevirtual   #68  <Method String Tag.getReadable()>
    //*   9   15:aload_1         
    //*  10   16:invokevirtual   #74  <Method boolean String.equalsIgnoreCase(String)>
    //*  11   19:ifne            35
    //*  12   22:aload_2         
    //*  13   23:iload_3         
    //*  14   24:aaload          
    //*  15   25:invokevirtual   #36  <Method String Tag.getIDStr()>
    //*  16   28:aload_1         
    //*  17   29:invokevirtual   #74  <Method boolean String.equalsIgnoreCase(String)>
    //*  18   32:ifeq            46
            {
                m_Selected = i;
    //   19   35:aload_0         
    //   20   36:iload_3         
    //   21   37:putfield        #50  <Field int m_Selected>
                m_Tags = tags;
    //   22   40:aload_0         
    //   23   41:aload_2         
    //   24   42:putfield        #52  <Field Tag[] m_Tags>
                return;
    //   25   45:return          
            }

    //   26   46:iinc            3  1
    //   27   49:iload_3         
    //   28   50:aload_2         
    //   29   51:arraylength     
    //   30   52:icmplt          9
        throw new IllegalArgumentException("Selected tag is not valid");
    //   31   55:new             #41  <Class IllegalArgumentException>
    //   32   58:dup             
    //   33   59:ldc1            #54  <String "Selected tag is not valid">
    //   34   61:invokespecial   #46  <Method void IllegalArgumentException(String)>
    //   35   64:athrow          
    }

    public boolean equals(Object o)
    {
        if(o == null || !o.getClass().equals(getClass()))
    //*   0    0:aload_1         
    //*   1    1:ifnull          18
    //*   2    4:aload_1         
    //*   3    5:invokevirtual   #81  <Method Class Object.getClass()>
    //*   4    8:aload_0         
    //*   5    9:invokevirtual   #81  <Method Class Object.getClass()>
    //*   6   12:invokevirtual   #83  <Method boolean Object.equals(Object)>
    //*   7   15:ifne            20
            return false;
    //    8   18:iconst_0        
    //    9   19:ireturn         
        SelectedTag s = (SelectedTag)o;
    //   10   20:aload_1         
    //   11   21:checkcast       #2   <Class SelectedTag>
    //   12   24:astore_2        
        return s.getTags() == m_Tags && s.getSelectedTag() == m_Tags[m_Selected];
    //   13   25:aload_2         
    //   14   26:invokevirtual   #87  <Method Tag[] getTags()>
    //   15   29:aload_0         
    //   16   30:getfield        #52  <Field Tag[] m_Tags>
    //   17   33:if_acmpne       54
    //   18   36:aload_2         
    //   19   37:invokevirtual   #91  <Method Tag getSelectedTag()>
    //   20   40:aload_0         
    //   21   41:getfield        #52  <Field Tag[] m_Tags>
    //   22   44:aload_0         
    //   23   45:getfield        #50  <Field int m_Selected>
    //   24   48:aaload          
    //   25   49:if_acmpne       54
    //   26   52:iconst_1        
    //   27   53:ireturn         
    //   28   54:iconst_0        
    //   29   55:ireturn         
    }

    public Tag getSelectedTag()
    {
        return m_Tags[m_Selected];
    //    0    0:aload_0         
    //    1    1:getfield        #52  <Field Tag[] m_Tags>
    //    2    4:aload_0         
    //    3    5:getfield        #50  <Field int m_Selected>
    //    4    8:aaload          
    //    5    9:areturn         
    }

    public Tag[] getTags()
    {
        return m_Tags;
    //    0    0:aload_0         
    //    1    1:getfield        #52  <Field Tag[] m_Tags>
    //    2    4:areturn         
    }

    public String toString()
    {
        return getSelectedTag().toString();
    //    0    0:aload_0         
    //    1    1:invokevirtual   #91  <Method Tag getSelectedTag()>
    //    2    4:invokevirtual   #97  <Method String Tag.toString()>
    //    3    7:areturn         
    }

    protected int m_Selected;
    protected Tag m_Tags[];
}
