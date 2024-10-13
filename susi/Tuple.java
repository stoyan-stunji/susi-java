public class Tuple<T>
{
    public T first;
    public T second;
    public T third;

    public Tuple(T firstSecondThird)
    {
        this.first = this.second = this.third = firstSecondThird;
    }

    public Tuple(T first, T second, T third)
    {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}