// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   ExtensionFileFilter.java

package rm.gui;

import java.io.*;
import javax.swing.filechooser.FileFilter;

public class ExtensionFileFilter extends FileFilter
    implements FilenameFilter, Serializable
{

    public ExtensionFileFilter(String extension, String description)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #18  <Method void FileFilter()>
        m_Extension = new String[1];
    //    2    4:aload_0         
    //    3    5:iconst_1        
    //    4    6:anewarray       String[]
    //    5    9:putfield        #22  <Field String[] m_Extension>
        m_Extension[0] = extension;
    //    6   12:aload_0         
    //    7   13:getfield        #22  <Field String[] m_Extension>
    //    8   16:iconst_0        
    //    9   17:aload_1         
    //   10   18:aastore         
        m_Description = description;
    //   11   19:aload_0         
    //   12   20:aload_2         
    //   13   21:putfield        #24  <Field String m_Description>
    //   14   24:return          
    }

    public ExtensionFileFilter(String extensions[], String description)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #18  <Method void FileFilter()>
        m_Extension = extensions;
    //    2    4:aload_0         
    //    3    5:aload_1         
    //    4    6:putfield        #22  <Field String[] m_Extension>
        m_Description = description;
    //    5    9:aload_0         
    //    6   10:aload_2         
    //    7   11:putfield        #24  <Field String m_Description>
    //    8   14:return          
    }

    public String getDescription()
    {
        return m_Description;
    //    0    0:aload_0         
    //    1    1:getfield        #24  <Field String m_Description>
    //    2    4:areturn         
    }

    public String[] getExtensions()
    {
        return (String[])m_Extension.clone();
    //    0    0:aload_0         
    //    1    1:getfield        #22  <Field String[] m_Extension>
    //    2    4:invokevirtual   #41  <Method Object _5B_Ljava.lang.String_3B_.clone()>
    //    3    7:checkcast       #37  <Class String[]>
    //    4   10:areturn         
    }

    public boolean accept(File file)
    {
        String name = file.getName().toLowerCase();
    //    0    0:aload_1         
    //    1    1:invokevirtual   #48  <Method String File.getName()>
    //    2    4:invokevirtual   #51  <Method String String.toLowerCase()>
    //    3    7:astore_2        
        if(file.isDirectory())
    //*   4    8:aload_1         
    //*   5    9:invokevirtual   #55  <Method boolean File.isDirectory()>
    //*   6   12:ifeq            17
            return true;
    //    7   15:iconst_1        
    //    8   16:ireturn         
        for(int i = 0; i < m_Extension.length; i++)
    //*   9   17:iconst_0        
    //*  10   18:istore_3        
    //*  11   19:goto            40
            if(name.endsWith(m_Extension[i]))
    //*  12   22:aload_2         
    //*  13   23:aload_0         
    //*  14   24:getfield        #22  <Field String[] m_Extension>
    //*  15   27:iload_3         
    //*  16   28:aaload          
    //*  17   29:invokevirtual   #59  <Method boolean String.endsWith(String)>
    //*  18   32:ifeq            37
                return true;
    //   19   35:iconst_1        
    //   20   36:ireturn         

    //   21   37:iinc            3  1
    //   22   40:iload_3         
    //   23   41:aload_0         
    //   24   42:getfield        #22  <Field String[] m_Extension>
    //   25   45:arraylength     
    //   26   46:icmplt          22
        return false;
    //   27   49:iconst_0        
    //   28   50:ireturn         
    }

    public boolean accept(File dir, String name)
    {
        return accept(new File(dir, name));
    //    0    0:aload_0         
    //    1    1:new             #45  <Class File>
    //    2    4:dup             
    //    3    5:aload_1         
    //    4    6:aload_2         
    //    5    7:invokespecial   #68  <Method void File(File, String)>
    //    6   10:invokevirtual   #70  <Method boolean accept(File)>
    //    7   13:ireturn         
    }

    protected String m_Description;
    protected String m_Extension[];
}
