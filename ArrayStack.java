public class ArrayStack<T> implements Stackable<T>{
	private T[] data;
	private int top;

	public ArrayStack (){
	  T[] data = (T[])(new Object[8]);
      top = -1;
   }   
   
   public void push(T datum){
      if(isFull()){
		
		throw new StackOutOfBoundsException("FULL");
      }
	  top++;
      this.data[top] = datum;
   }
   
   public T pop(){
      if(isEmpty()){
		throw new StackOutOfBoundsException("EMPTY");
      }
	  return data[top--];
   }
    
	public T peek(){
		if (isEmpty()){
			throw new StackOutOfBoundsException("EMPTY");
		}
		return data[top-1];
	}
	
	public boolean isFull(){
		if (top==data.length-1){
			return true;
		}
		else{
			return false;
		}
		
	}
	
	public boolean isEmpty(){
		if(top==-1){
			return true;
		}
		else{
		return false;
		}
	}
	
    public String toString(){ // verify functions well for output
        String s = "";
        for(int i=0; i<top+1; i++){
            s+=data[i].toString()+", ";
		}
        return s;
    }
}