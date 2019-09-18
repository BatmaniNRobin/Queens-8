public interface Stackable<T>{
   public T pop();
   public void push(T data);
   public T peek();
   public boolean isEmpty();
   public boolean isFull();
}