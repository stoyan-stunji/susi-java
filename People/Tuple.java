package People;
public class Tuple<T>
{
    public T first;
    public T second;
    public T third;

    public Tuple(T firstSecondThird)
    {
        this.first = this.second = this.third = firstSecondThird;
    }
}