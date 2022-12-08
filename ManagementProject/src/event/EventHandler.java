package event;

import java.util.ArrayList;

import interfaces.IEvent;

public class EventHandler<TEventArgs>
{
    private ArrayList<IEvent<TEventArgs>> eventDelegateArray = new ArrayList<>();
    
    public void subscribe(IEvent<TEventArgs> methodReference)
    {
        eventDelegateArray.add(methodReference);
    }
    public void unSubscribe(IEvent<TEventArgs> methodReference)
    {
        eventDelegateArray.remove(methodReference);
    }
    public void invoke(Object source, TEventArgs eventArgs)
    {
        if (eventDelegateArray.size()>0)
            eventDelegateArray.forEach(t -> t.invoke(source, eventArgs));
    }
    public void close()
    {
        if (eventDelegateArray.size()>0)
            eventDelegateArray.clear();
    }
}