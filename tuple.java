public class tuple<T> 
{
    T first;
    T second;
    T third; 
    
    tuple(T temp)
    {
        this.first = this.second = this.third = temp;
    }

    tuple(T f, T s, T t)
    {
        this.first = f;
        this.second = s;
        this.third = t;
    }
}
