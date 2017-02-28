// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   OutputZipper.java

package rm.experiment;

import java.io.*;
import java.util.zip.*;

public class OutputZipper
{

    public OutputZipper(File destination)
        throws Exception
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #19  <Method void Object()>
        m_zipOut = null;
    //    2    4:aload_0         
    //    3    5:aconst_null     
    //    4    6:putfield        #21  <Field DataOutputStream m_zipOut>
        m_zs = null;
    //    5    9:aload_0         
    //    6   10:aconst_null     
    //    7   11:putfield        #23  <Field ZipOutputStream m_zs>
        m_destination = destination;
    //    8   14:aload_0         
    //    9   15:aload_1         
    //   10   16:putfield        #25  <Field File m_destination>
        if(!m_destination.isDirectory())
    //*  11   19:aload_0         
    //*  12   20:getfield        #25  <Field File m_destination>
    //*  13   23:invokevirtual   #31  <Method boolean File.isDirectory()>
    //*  14   26:ifne            66
        {
            m_zs = new ZipOutputStream(new FileOutputStream(m_destination));
    //   15   29:aload_0         
    //   16   30:new             #33  <Class ZipOutputStream>
    //   17   33:dup             
    //   18   34:new             #35  <Class FileOutputStream>
    //   19   37:dup             
    //   20   38:aload_0         
    //   21   39:getfield        #25  <Field File m_destination>
    //   22   42:invokespecial   #37  <Method void FileOutputStream(File)>
    //   23   45:invokespecial   #40  <Method void ZipOutputStream(java.io.OutputStream)>
    //   24   48:putfield        #23  <Field ZipOutputStream m_zs>
            m_zipOut = new DataOutputStream(m_zs);
    //   25   51:aload_0         
    //   26   52:new             #42  <Class DataOutputStream>
    //   27   55:dup             
    //   28   56:aload_0         
    //   29   57:getfield        #23  <Field ZipOutputStream m_zs>
    //   30   60:invokespecial   #43  <Method void DataOutputStream(java.io.OutputStream)>
    //   31   63:putfield        #21  <Field DataOutputStream m_zipOut>
        }
    //   32   66:return          
    }

    public void zipit(String outString, String name)
        throws Exception
    {
        if(m_zipOut == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #21  <Field DataOutputStream m_zipOut>
    //*   2    4:ifnonnull       76
        {
            File saveFile = new File(m_destination, (new StringBuilder(String.valueOf(name))).append(".gz").toString());
    //    3    7:new             #27  <Class File>
    //    4   10:dup             
    //    5   11:aload_0         
    //    6   12:getfield        #25  <Field File m_destination>
    //    7   15:new             #52  <Class StringBuilder>
    //    8   18:dup             
    //    9   19:aload_2         
    //   10   20:invokestatic    #58  <Method String String.valueOf(Object)>
    //   11   23:invokespecial   #61  <Method void StringBuilder(String)>
    //   12   26:ldc1            #63  <String ".gz">
    //   13   28:invokevirtual   #67  <Method StringBuilder StringBuilder.append(String)>
    //   14   31:invokevirtual   #71  <Method String StringBuilder.toString()>
    //   15   34:invokespecial   #74  <Method void File(File, String)>
    //   16   37:astore_3        
            DataOutputStream dout = new DataOutputStream(new GZIPOutputStream(new FileOutputStream(saveFile)));
    //   17   38:new             #42  <Class DataOutputStream>
    //   18   41:dup             
    //   19   42:new             #76  <Class GZIPOutputStream>
    //   20   45:dup             
    //   21   46:new             #35  <Class FileOutputStream>
    //   22   49:dup             
    //   23   50:aload_3         
    //   24   51:invokespecial   #37  <Method void FileOutputStream(File)>
    //   25   54:invokespecial   #77  <Method void GZIPOutputStream(java.io.OutputStream)>
    //   26   57:invokespecial   #43  <Method void DataOutputStream(java.io.OutputStream)>
    //   27   60:astore          5
            dout.writeBytes(outString);
    //   28   62:aload           5
    //   29   64:aload_1         
    //   30   65:invokevirtual   #80  <Method void DataOutputStream.writeBytes(String)>
            dout.close();
    //   31   68:aload           5
    //   32   70:invokevirtual   #83  <Method void DataOutputStream.close()>
        } else
    //*  33   73:goto            110
        {
            ZipEntry ze = new ZipEntry(name);
    //   34   76:new             #85  <Class ZipEntry>
    //   35   79:dup             
    //   36   80:aload_2         
    //   37   81:invokespecial   #86  <Method void ZipEntry(String)>
    //   38   84:astore          4
            m_zs.putNextEntry(ze);
    //   39   86:aload_0         
    //   40   87:getfield        #23  <Field ZipOutputStream m_zs>
    //   41   90:aload           4
    //   42   92:invokevirtual   #90  <Method void ZipOutputStream.putNextEntry(ZipEntry)>
            m_zipOut.writeBytes(outString);
    //   43   95:aload_0         
    //   44   96:getfield        #21  <Field DataOutputStream m_zipOut>
    //   45   99:aload_1         
    //   46  100:invokevirtual   #80  <Method void DataOutputStream.writeBytes(String)>
            m_zs.closeEntry();
    //   47  103:aload_0         
    //   48  104:getfield        #23  <Field ZipOutputStream m_zs>
    //   49  107:invokevirtual   #93  <Method void ZipOutputStream.closeEntry()>
        }
    //   50  110:return          
    }

    public void finished()
        throws Exception
    {
        if(m_zipOut != null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #21  <Field DataOutputStream m_zipOut>
    //*   2    4:ifnull          14
            m_zipOut.close();
    //    3    7:aload_0         
    //    4    8:getfield        #21  <Field DataOutputStream m_zipOut>
    //    5   11:invokevirtual   #83  <Method void DataOutputStream.close()>
    //    6   14:return          
    }

    public static void main(String args[])
    {
        try
        {
            File testF = new File(new File(System.getProperty("user.dir")), "testOut.zip");
    //    0    0:new             #27  <Class File>
    //    1    3:dup             
    //    2    4:new             #27  <Class File>
    //    3    7:dup             
    //    4    8:ldc1            #105 <String "user.dir">
    //    5   10:invokestatic    #111 <Method String System.getProperty(String)>
    //    6   13:invokespecial   #112 <Method void File(String)>
    //    7   16:ldc1            #114 <String "testOut.zip">
    //    8   18:invokespecial   #74  <Method void File(File, String)>
    //    9   21:astore_1        
            OutputZipper oz = new OutputZipper(testF);
    //   10   22:new             #2   <Class OutputZipper>
    //   11   25:dup             
    //   12   26:aload_1         
    //   13   27:invokespecial   #115 <Method void OutputZipper(File)>
    //   14   30:astore_2        
            oz.zipit("Here is some test text to be zipped", "testzip");
    //   15   31:aload_2         
    //   16   32:ldc1            #117 <String "Here is some test text to be zipped">
    //   17   34:ldc1            #119 <String "testzip">
    //   18   36:invokevirtual   #121 <Method void zipit(String, String)>
            oz.zipit("Here is a second entry to be zipped", "testzip2");
    //   19   39:aload_2         
    //   20   40:ldc1            #123 <String "Here is a second entry to be zipped">
    //   21   42:ldc1            #125 <String "testzip2">
    //   22   44:invokevirtual   #121 <Method void zipit(String, String)>
            oz.finished();
    //   23   47:aload_2         
    //   24   48:invokevirtual   #127 <Method void finished()>
        }
    //*  25   51:goto            69
        catch(Exception ex)
    //*  26   54:astore_1        
        {
            ex.printStackTrace();
    //   27   55:aload_1         
    //   28   56:invokevirtual   #130 <Method void Exception.printStackTrace()>
            System.err.println(ex.getMessage());
    //   29   59:getstatic       #134 <Field PrintStream System.err>
    //   30   62:aload_1         
    //   31   63:invokevirtual   #137 <Method String Exception.getMessage()>
    //   32   66:invokevirtual   #142 <Method void PrintStream.println(String)>
        }
    //   33   69:return          
    }

    File m_destination;
    DataOutputStream m_zipOut;
    ZipOutputStream m_zs;
}
