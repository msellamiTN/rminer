// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   TrainingSetListener.java

package rm.gui.beans;

import java.util.EventListener;

// Referenced classes of package rm.gui.beans:
//            TrainingSetEvent

public interface TrainingSetListener
    extends EventListener
{

    public abstract void acceptTrainingSet(TrainingSetEvent trainingsetevent);
}
