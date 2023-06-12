package prob1;
import java.util.Arrays;

public class MyStringList {
    private final int INITIAL_LENGTH = 4;
    private String[] currentArray;
    private int size;

    public MyStringList(){
        currentArray = new String[INITIAL_LENGTH];
        size =0;
    }

    public void add(String a){
        if(a==null) return;
        if(size == currentArray.length) resize();
        currentArray[size++] =a;
    }

    public String get(int i){
        if(i<0 || i >=size){
            return null;
        }
        return currentArray[i];
    }

    private void resize(){
        System.out.println("resizing");
        int len= currentArray.length;
        int newlen = 2*len;
        String[] newArray = new String[newlen];
        System.arraycopy(currentArray,0,newArray,0,len);
        currentArray = newArray;
    }

    public boolean find(String s){
        if(s==null)return false;
        for(String test: currentArray){
            if(test.equals(s))return true;
        }
        return false;
    }

    public void insert(String s, int pos){
        if(pos>size || pos <0) return;
        if(pos ==currentArray.length || size+1 > currentArray.length){
            resize();
        }
        String[] tmp = new String[currentArray.length+1];
        System.arraycopy(currentArray,0,tmp,0,pos);
        tmp[pos] = s;

        System.arraycopy(currentArray,pos,tmp,pos+1,currentArray.length-pos);
        currentArray = tmp;
        ++size;
    }

    public boolean remove(String s){
        if(size ==0) return false;
        if(s == null) return false;
        int index = -1;
        for(int i=0;i<size;i++){
            if(currentArray[i].equals(s)){
                index = i;
                break;
            }
        }
        if(index ==-1) return false;
        String[] tmp = new String[currentArray.length];
        System.arraycopy(currentArray,0,tmp,0,index);
        System.arraycopy(currentArray,index+1,tmp,index,currentArray.length-(index+1));
        currentArray = tmp;
        --size;
        return true;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        for(int i=0;i<size-1;i++){
            sb.append(currentArray[i]+ " ");
        }
        sb.append(currentArray[size-1]+"]");
        return sb.toString();
    }

    public int size(){return size;}
    public boolean isEmpty(){return (size ==0);}
    public Object clone(){
        String[]tmp = Arrays.copyOf(currentArray,size);
        return tmp;
    }


    public static void main(String[] args) {
        MyStringList l = new MyStringList();
        l.add("bob");
        l.add("some");
        l.add("body");
        l.add("touch");
        l.add("my");
        l.add("spaghetti");
        //l.insert("omg", 1);

        System.out.println("Number of elements: "+l.size);
        System.out.println("Length of current array: "+ l.currentArray.length);
    }
}
