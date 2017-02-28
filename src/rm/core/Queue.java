// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   Queue.java

package rm.core;

import java.io.PrintStream;
import java.io.Serializable;

public class Queue
    implements Serializable
{
    protected class QueueNode
        implements Serializable
    {

        public QueueNode next(QueueNode next)
        {
            return m_Next = next;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:dup_x1          
        //    3    3:putfield        #37  <Field Queue$QueueNode m_Next>
        //    4    6:areturn         
        }

        public QueueNode next()
        {
            return m_Next;
        //    0    0:aload_0         
        //    1    1:getfield        #37  <Field Queue$QueueNode m_Next>
        //    2    4:areturn         
        }

        public Object contents(Object contents)
        {
            return m_Contents = contents;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:dup_x1          
        //    3    3:putfield        #27  <Field Object m_Contents>
        //    4    6:areturn         
        }

        public Object contents()
        {
            return m_Contents;
        //    0    0:aload_0         
        //    1    1:getfield        #27  <Field Object m_Contents>
        //    2    4:areturn         
        }

        private static final long serialVersionUID = 0xb8f462c4b5afde51L;
        protected QueueNode m_Next;
        protected Object m_Contents;
        final Queue this$0;

        public QueueNode(Object contents)
        {
            this$0 = Queue.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #22  <Field Queue this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #25  <Method void Object()>
            m_Contents = contents;
        //    5    9:aload_0         
        //    6   10:aload_2         
        //    7   11:putfield        #27  <Field Object m_Contents>
            next(null);
        //    8   14:aload_0         
        //    9   15:aconst_null     
        //   10   16:invokevirtual   #31  <Method Queue$QueueNode next(Queue$QueueNode)>
        //   11   19:pop             
        //   12   20:return          
        }
    }


    public Queue()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #16  <Method void Object()>
        m_Head = null;
    //    2    4:aload_0         
    //    3    5:aconst_null     
    //    4    6:putfield        #18  <Field Queue$QueueNode m_Head>
        m_Tail = null;
    //    5    9:aload_0         
    //    6   10:aconst_null     
    //    7   11:putfield        #20  <Field Queue$QueueNode m_Tail>
        m_Size = 0;
    //    8   14:aload_0         
    //    9   15:iconst_0        
    //   10   16:putfield        #22  <Field int m_Size>
    //   11   19:return          
    }

    public final synchronized void removeAllElements()
    {
        m_Size = 0;
    //    0    0:aload_0         
    //    1    1:iconst_0        
    //    2    2:putfield        #22  <Field int m_Size>
        m_Head = null;
    //    3    5:aload_0         
    //    4    6:aconst_null     
    //    5    7:putfield        #18  <Field Queue$QueueNode m_Head>
        m_Tail = null;
    //    6   10:aload_0         
    //    7   11:aconst_null     
    //    8   12:putfield        #20  <Field Queue$QueueNode m_Tail>
    //    9   15:return          
    }

    public synchronized Object push(Object item)
    {
        QueueNode newNode = new QueueNode(item);
    //    0    0:new             #31  <Class Queue$QueueNode>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:aload_1         
    //    4    6:invokespecial   #34  <Method void Queue$QueueNode(Queue, Object)>
    //    5    9:astore_2        
        if(m_Head == null)
    //*   6   10:aload_0         
    //*   7   11:getfield        #18  <Field Queue$QueueNode m_Head>
    //*   8   14:ifnonnull       30
            m_Head = m_Tail = newNode;
    //    9   17:aload_0         
    //   10   18:aload_0         
    //   11   19:aload_2         
    //   12   20:dup_x1          
    //   13   21:putfield        #20  <Field Queue$QueueNode m_Tail>
    //   14   24:putfield        #18  <Field Queue$QueueNode m_Head>
        else
    //*  15   27:goto            42
            m_Tail = m_Tail.next(newNode);
    //   16   30:aload_0         
    //   17   31:aload_0         
    //   18   32:getfield        #20  <Field Queue$QueueNode m_Tail>
    //   19   35:aload_2         
    //   20   36:invokevirtual   #38  <Method Queue$QueueNode Queue$QueueNode.next(Queue$QueueNode)>
    //   21   39:putfield        #20  <Field Queue$QueueNode m_Tail>
        m_Size++;
    //   22   42:aload_0         
    //   23   43:dup             
    //   24   44:getfield        #22  <Field int m_Size>
    //   25   47:iconst_1        
    //   26   48:iadd            
    //   27   49:putfield        #22  <Field int m_Size>
        return item;
    //   28   52:aload_1         
    //   29   53:areturn         
    }

    public synchronized Object pop()
        throws RuntimeException
    {
        if(m_Head == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #18  <Field Queue$QueueNode m_Head>
    //*   2    4:ifnonnull       17
            throw new RuntimeException("Queue is empty");
    //    3    7:new             #46  <Class RuntimeException>
    //    4   10:dup             
    //    5   11:ldc1            #48  <String "Queue is empty">
    //    6   13:invokespecial   #51  <Method void RuntimeException(String)>
    //    7   16:athrow          
        Object retval = m_Head.contents();
    //    8   17:aload_0         
    //    9   18:getfield        #18  <Field Queue$QueueNode m_Head>
    //   10   21:invokevirtual   #54  <Method Object Queue$QueueNode.contents()>
    //   11   24:astore_1        
        m_Size--;
    //   12   25:aload_0         
    //   13   26:dup             
    //   14   27:getfield        #22  <Field int m_Size>
    //   15   30:iconst_1        
    //   16   31:isub            
    //   17   32:putfield        #22  <Field int m_Size>
        m_Head = m_Head.next();
    //   18   35:aload_0         
    //   19   36:aload_0         
    //   20   37:getfield        #18  <Field Queue$QueueNode m_Head>
    //   21   40:invokevirtual   #57  <Method Queue$QueueNode Queue$QueueNode.next()>
    //   22   43:putfield        #18  <Field Queue$QueueNode m_Head>
        if(m_Head == null)
    //*  23   46:aload_0         
    //*  24   47:getfield        #18  <Field Queue$QueueNode m_Head>
    //*  25   50:ifnonnull       58
            m_Tail = null;
    //   26   53:aload_0         
    //   27   54:aconst_null     
    //   28   55:putfield        #20  <Field Queue$QueueNode m_Tail>
        return retval;
    //   29   58:aload_1         
    //   30   59:areturn         
    }

    public synchronized Object peek()
        throws RuntimeException
    {
        if(m_Head == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #18  <Field Queue$QueueNode m_Head>
    //*   2    4:ifnonnull       17
            throw new RuntimeException("Queue is empty");
    //    3    7:new             #46  <Class RuntimeException>
    //    4   10:dup             
    //    5   11:ldc1            #48  <String "Queue is empty">
    //    6   13:invokespecial   #51  <Method void RuntimeException(String)>
    //    7   16:athrow          
        else
            return m_Head.contents();
    //    8   17:aload_0         
    //    9   18:getfield        #18  <Field Queue$QueueNode m_Head>
    //   10   21:invokevirtual   #54  <Method Object Queue$QueueNode.contents()>
    //   11   24:areturn         
    }

    public boolean empty()
    {
        return m_Head == null;
    //    0    0:aload_0         
    //    1    1:getfield        #18  <Field Queue$QueueNode m_Head>
    //    2    4:ifnonnull       9
    //    3    7:iconst_1        
    //    4    8:ireturn         
    //    5    9:iconst_0        
    //    6   10:ireturn         
    }

    public int size()
    {
        return m_Size;
    //    0    0:aload_0         
    //    1    1:getfield        #22  <Field int m_Size>
    //    2    4:ireturn         
    }

    public String toString()
    {
        String retval = (new StringBuilder("Queue Contents ")).append(m_Size).append(" elements\n").toString();
    //    0    0:new             #67  <Class StringBuilder>
    //    1    3:dup             
    //    2    4:ldc1            #69  <String "Queue Contents ">
    //    3    6:invokespecial   #70  <Method void StringBuilder(String)>
    //    4    9:aload_0         
    //    5   10:getfield        #22  <Field int m_Size>
    //    6   13:invokevirtual   #74  <Method StringBuilder StringBuilder.append(int)>
    //    7   16:ldc1            #76  <String " elements\n">
    //    8   18:invokevirtual   #79  <Method StringBuilder StringBuilder.append(String)>
    //    9   21:invokevirtual   #81  <Method String StringBuilder.toString()>
    //   10   24:astore_1        
        QueueNode current = m_Head;
    //   11   25:aload_0         
    //   12   26:getfield        #18  <Field Queue$QueueNode m_Head>
    //   13   29:astore_2        
        if(current == null)
    //*  14   30:aload_2         
    //*  15   31:ifnonnull       92
            return (new StringBuilder(String.valueOf(retval))).append("Empty\n").toString();
    //   16   34:new             #67  <Class StringBuilder>
    //   17   37:dup             
    //   18   38:aload_1         
    //   19   39:invokestatic    #87  <Method String String.valueOf(Object)>
    //   20   42:invokespecial   #70  <Method void StringBuilder(String)>
    //   21   45:ldc1            #89  <String "Empty\n">
    //   22   47:invokevirtual   #79  <Method StringBuilder StringBuilder.append(String)>
    //   23   50:invokevirtual   #81  <Method String StringBuilder.toString()>
    //   24   53:areturn         
    //*  25   54:goto            92
        for(; current != null; current = current.next())
            retval = (new StringBuilder(String.valueOf(retval))).append(current.contents().toString()).append("\n").toString();
    //   26   57:new             #67  <Class StringBuilder>
    //   27   60:dup             
    //   28   61:aload_1         
    //   29   62:invokestatic    #87  <Method String String.valueOf(Object)>
    //   30   65:invokespecial   #70  <Method void StringBuilder(String)>
    //   31   68:aload_2         
    //   32   69:invokevirtual   #54  <Method Object Queue$QueueNode.contents()>
    //   33   72:invokevirtual   #90  <Method String Object.toString()>
    //   34   75:invokevirtual   #79  <Method StringBuilder StringBuilder.append(String)>
    //   35   78:ldc1            #92  <String "\n">
    //   36   80:invokevirtual   #79  <Method StringBuilder StringBuilder.append(String)>
    //   37   83:invokevirtual   #81  <Method String StringBuilder.toString()>
    //   38   86:astore_1        

    //   39   87:aload_2         
    //   40   88:invokevirtual   #57  <Method Queue$QueueNode Queue$QueueNode.next()>
    //   41   91:astore_2        
    //   42   92:aload_2         
    //   43   93:ifnonnull       57
        return retval;
    //   44   96:aload_1         
    //   45   97:areturn         
    }

    public static void main(String argv[])
    {
        try
        {
            Queue queue = new Queue();
    //    0    0:new             #2   <Class Queue>
    //    1    3:dup             
    //    2    4:invokespecial   #97  <Method void Queue()>
    //    3    7:astore_1        
            for(int i = 0; i < argv.length; i++)
    //*   4    8:iconst_0        
    //*   5    9:istore_2        
    //*   6   10:goto            24
                queue.push(argv[i]);
    //    7   13:aload_1         
    //    8   14:aload_0         
    //    9   15:iload_2         
    //   10   16:aaload          
    //   11   17:invokevirtual   #99  <Method Object push(Object)>
    //   12   20:pop             

    //   13   21:iinc            2  1
    //   14   24:iload_2         
    //   15   25:aload_0         
    //   16   26:arraylength     
    //   17   27:icmplt          13
            System.out.println("After pushing command line arguments");
    //   18   30:getstatic       #105 <Field PrintStream System.out>
    //   19   33:ldc1            #107 <String "After pushing command line arguments">
    //   20   35:invokevirtual   #112 <Method void PrintStream.println(String)>
            System.out.println(queue.toString());
    //   21   38:getstatic       #105 <Field PrintStream System.out>
    //   22   41:aload_1         
    //   23   42:invokevirtual   #113 <Method String toString()>
    //   24   45:invokevirtual   #112 <Method void PrintStream.println(String)>
    //*  25   48:goto            79
            for(; !queue.empty(); System.out.println((new StringBuilder("Pop: ")).append(queue.pop().toString()).toString()));
    //   26   51:getstatic       #105 <Field PrintStream System.out>
    //   27   54:new             #67  <Class StringBuilder>
    //   28   57:dup             
    //   29   58:ldc1            #115 <String "Pop: ">
    //   30   60:invokespecial   #70  <Method void StringBuilder(String)>
    //   31   63:aload_1         
    //   32   64:invokevirtual   #117 <Method Object pop()>
    //   33   67:invokevirtual   #90  <Method String Object.toString()>
    //   34   70:invokevirtual   #79  <Method StringBuilder StringBuilder.append(String)>
    //   35   73:invokevirtual   #81  <Method String StringBuilder.toString()>
    //   36   76:invokevirtual   #112 <Method void PrintStream.println(String)>
    //   37   79:aload_1         
    //   38   80:invokevirtual   #119 <Method boolean empty()>
    //   39   83:ifeq            51
            try
            {
                queue.pop();
    //   40   86:aload_1         
    //   41   87:invokevirtual   #117 <Method Object pop()>
    //   42   90:pop             
                System.out.println("ERROR: pop did not throw exception!");
    //   43   91:getstatic       #105 <Field PrintStream System.out>
    //   44   94:ldc1            #121 <String "ERROR: pop did not throw exception!">
    //   45   96:invokevirtual   #112 <Method void PrintStream.println(String)>
            }
    //*  46   99:goto            125
            catch(RuntimeException ex)
    //*  47  102:astore_2        
            {
                System.out.println("Pop on empty queue correctly gave exception.");
    //   48  103:getstatic       #105 <Field PrintStream System.out>
    //   49  106:ldc1            #123 <String "Pop on empty queue correctly gave exception.">
    //   50  108:invokevirtual   #112 <Method void PrintStream.println(String)>
            }
        }
    //*  51  111:goto            125
        catch(Exception ex)
    //*  52  114:astore_1        
        {
            System.out.println(ex.getMessage());
    //   53  115:getstatic       #105 <Field PrintStream System.out>
    //   54  118:aload_1         
    //   55  119:invokevirtual   #128 <Method String Exception.getMessage()>
    //   56  122:invokevirtual   #112 <Method void PrintStream.println(String)>
        }
    //   57  125:return          
    }

    protected QueueNode m_Head;
    protected QueueNode m_Tail;
    protected int m_Size;
}
