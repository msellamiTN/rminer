// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   EiditUPA.java

package rm.gui.graph;

import java.io.*;
import rm.core.Assignment;
import rm.core.converters.AssLoader;
import rm.gui.AssignmentViewer;

public class EiditUPA
{

    public EiditUPA()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #9   <Method void Object()>
    //    2    4:return          
    }

    public static void main(String args[])
        throws Exception
    {
        int DEFAULT_WIDTH = 800;
    //    0    0:sipush          800
    //    1    3:istore_1        
        int DEFAULT_HEIGHT = 600;
    //    2    4:sipush          600
    //    3    7:istore_2        
        File file = new File((new StringBuilder(String.valueOf(System.getProperty("user.dir")))).append("\\datasets\\university_large.ass").toString());
    //    4    8:new             #20  <Class File>
    //    5   11:dup             
    //    6   12:new             #22  <Class StringBuilder>
    //    7   15:dup             
    //    8   16:ldc1            #24  <String "user.dir">
    //    9   18:invokestatic    #30  <Method String System.getProperty(String)>
    //   10   21:invokestatic    #36  <Method String String.valueOf(Object)>
    //   11   24:invokespecial   #39  <Method void StringBuilder(String)>
    //   12   27:ldc1            #41  <String "\\datasets\\university_large.ass">
    //   13   29:invokevirtual   #45  <Method StringBuilder StringBuilder.append(String)>
    //   14   32:invokevirtual   #49  <Method String StringBuilder.toString()>
    //   15   35:invokespecial   #50  <Method void File(String)>
    //   16   38:astore_3        
        AssLoader AL = new AssLoader(new FileReader(file));
    //   17   39:new             #52  <Class AssLoader>
    //   18   42:dup             
    //   19   43:new             #54  <Class FileReader>
    //   20   46:dup             
    //   21   47:aload_3         
    //   22   48:invokespecial   #57  <Method void FileReader(File)>
    //   23   51:invokespecial   #60  <Method void AssLoader(FileReader)>
    //   24   54:astore          4
        Assignment Ass = AL.getData();
    //   25   56:aload           4
    //   26   58:invokevirtual   #64  <Method Assignment AssLoader.getData()>
    //   27   61:astore          5
        System.out.println(Ass.getAssignementName());
    //   28   63:getstatic       #68  <Field PrintStream System.out>
    //   29   66:aload           5
    //   30   68:invokevirtual   #73  <Method String Assignment.getAssignementName()>
    //   31   71:invokevirtual   #78  <Method void PrintStream.println(String)>
        Assignment copy = new Assignment(Ass);
    //   32   74:new             #70  <Class Assignment>
    //   33   77:dup             
    //   34   78:aload           5
    //   35   80:invokespecial   #81  <Method void Assignment(Assignment)>
    //   36   83:astore          8
        AssignmentViewer dialog = new AssignmentViewer(copy);
    //   37   85:new             #83  <Class AssignmentViewer>
    //   38   88:dup             
    //   39   89:aload           8
    //   40   91:invokespecial   #84  <Method void AssignmentViewer(Assignment)>
    //   41   94:astore          6
        int result = dialog.showDialog();
    //   42   96:aload           6
    //   43   98:invokevirtual   #88  <Method int AssignmentViewer.showDialog()>
    //   44  101:istore          7
        if(result == 0)
    //*  45  103:iload           7
    //*  46  105:ifne            115
            Ass = dialog.getAssignment();
    //   47  108:aload           6
    //   48  110:invokevirtual   #91  <Method Assignment AssignmentViewer.getAssignment()>
    //   49  113:astore          5
    //   50  115:return          
    }
}
