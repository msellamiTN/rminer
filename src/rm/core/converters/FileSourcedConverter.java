// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   FileSourcedConverter.java

package rm.core.converters;

import java.io.File;
import java.io.IOException;

public interface FileSourcedConverter
{

    public abstract String getFileExtension();

    public abstract String[] getFileExtensions();

    public abstract String getFileDescription();

    public abstract void setFile(File file)
        throws IOException;

    public abstract File retrieveFile();

    public abstract void setUseRelativePath(boolean flag);

    public abstract boolean getUseRelativePath();
}
