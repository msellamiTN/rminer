// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   Undoable.java

package rm.core;


public interface Undoable
{

    public abstract boolean isUndoEnabled();

    public abstract void setUndoEnabled(boolean flag);

    public abstract void clearUndo();

    public abstract boolean canUndo();

    public abstract void undo();

    public abstract void addUndoPoint();
}
