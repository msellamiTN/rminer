// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   Loader.java

package rm.gui;

import java.io.*;
import java.net.URL;

public class Loader
{

    public Loader(String dir)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #14  <Method void Object()>
        this.dir = dir;
    //    2    4:aload_0         
    //    3    5:aload_1         
    //    4    6:putfield        #16  <Field String dir>
    //    5    9:return          
    }

    public String getDir()
    {
        return dir;
    //    0    0:aload_0         
    //    1    1:getfield        #16  <Field String dir>
    //    2    4:areturn         
    }

    public String processFilename(String filename)
    {
        if(!filename.startsWith(getDir()))
    //*   0    0:aload_1         
    //*   1    1:aload_0         
    //*   2    2:invokevirtual   #26  <Method String getDir()>
    //*   3    5:invokevirtual   #32  <Method boolean String.startsWith(String)>
    //*   4    8:ifne            33
            filename = (new StringBuilder(String.valueOf(getDir()))).append(filename).toString();
    //    5   11:new             #34  <Class StringBuilder>
    //    6   14:dup             
    //    7   15:aload_0         
    //    8   16:invokevirtual   #26  <Method String getDir()>
    //    9   19:invokestatic    #38  <Method String String.valueOf(Object)>
    //   10   22:invokespecial   #40  <Method void StringBuilder(String)>
    //   11   25:aload_1         
    //   12   26:invokevirtual   #44  <Method StringBuilder StringBuilder.append(String)>
    //   13   29:invokevirtual   #47  <Method String StringBuilder.toString()>
    //   14   32:astore_1        
        return filename;
    //   15   33:aload_1         
    //   16   34:areturn         
    }

    public static URL getURL(String dir, String filename)
    {
        Loader loader = new Loader(dir);
    //    0    0:new             #2   <Class Loader>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:invokespecial   #51  <Method void Loader(String)>
    //    4    8:astore_2        
        return loader.getURL(filename);
    //    5    9:aload_2         
    //    6   10:aload_1         
    //    7   11:invokevirtual   #54  <Method URL getURL(String)>
    //    8   14:areturn         
    }

    public URL getURL(String filename)
    {
        filename = processFilename(filename);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokevirtual   #57  <Method String processFilename(String)>
    //    3    5:astore_1        
        return rm/gui/Loader.getClassLoader().getResource(filename);
    //    4    6:ldc1            #2   <Class Loader>
    //    5    8:invokevirtual   #63  <Method ClassLoader Class.getClassLoader()>
    //    6   11:aload_1         
    //    7   12:invokevirtual   #68  <Method URL ClassLoader.getResource(String)>
    //    8   15:areturn         
    }

    public static InputStream getInputStream(String dir, String filename)
    {
        Loader loader = new Loader(dir);
    //    0    0:new             #2   <Class Loader>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:invokespecial   #51  <Method void Loader(String)>
    //    4    8:astore_2        
        return loader.getInputStream(filename);
    //    5    9:aload_2         
    //    6   10:aload_1         
    //    7   11:invokevirtual   #73  <Method InputStream getInputStream(String)>
    //    8   14:areturn         
    }

    public InputStream getInputStream(String filename)
    {
        filename = processFilename(filename);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokevirtual   #57  <Method String processFilename(String)>
    //    3    5:astore_1        
        return rm/gui/Loader.getResourceAsStream(filename);
    //    4    6:ldc1            #2   <Class Loader>
    //    5    8:aload_1         
    //    6    9:invokevirtual   #76  <Method InputStream Class.getResourceAsStream(String)>
    //    7   12:areturn         
    }

    public static Reader getReader(String dir, String filename)
    {
        Loader loader = new Loader(dir);
    //    0    0:new             #2   <Class Loader>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:invokespecial   #51  <Method void Loader(String)>
    //    4    8:astore_2        
        return loader.getReader(filename);
    //    5    9:aload_2         
    //    6   10:aload_1         
    //    7   11:invokevirtual   #81  <Method Reader getReader(String)>
    //    8   14:areturn         
    }

    public Reader getReader(String filename)
    {
        InputStream in = getInputStream(filename);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokevirtual   #73  <Method InputStream getInputStream(String)>
    //    3    5:astore_2        
        if(in == null)
    //*   4    6:aload_2         
    //*   5    7:ifnonnull       12
            return null;
    //    6   10:aconst_null     
    //    7   11:areturn         
        else
            return new InputStreamReader(in);
    //    8   12:new             #83  <Class InputStreamReader>
    //    9   15:dup             
    //   10   16:aload_2         
    //   11   17:invokespecial   #86  <Method void InputStreamReader(InputStream)>
    //   12   20:areturn         
    }

    private String dir;
    static Class class$0;
}
