package prob1;

public class Person {
    private final int INITIAL_SIZE = 4;
    private String[] lastName;
    private String[] firstName;
    private int[] age;
    private int size;
    // --------------------------------------------------------------
    public Person(){
        lastName = new String[INITIAL_SIZE];
        firstName = new String[INITIAL_SIZE];
        age = new int[INITIAL_SIZE];
        size =0;
    }
    /*
    public Person(String last, String first, int a) { // constructor
        lastName = last;
        firstName = first;
        age = a;
    }
     */
    // --------------------------------------------------------------
    /*
    public String getLast() // get last name
    {
        return lastName;
    }
     */
    public void add(String a, String b, int c){
        if(a==null) return;
        if(size == lastName.length) resize();
        lastName[size++] =a;
        firstName[size++] = b;
        age[size++] = c;
    }

    public boolean find(String s){
        if(s==null)return false;
        for(String test: lastName){
            if(test.equals(s))return true;
        }
        return false;
    }
    private void resize(){
        System.out.println("resizing lastname");
        int len= lastName.length;
        int newlen = 2*len;
        String[] newArray = new String[newlen];
        System.arraycopy(lastName,0,newArray,0,len);
        lastName = newArray;

        System.out.println("resizing firstname");
        int len1= firstName.length;
        int newlen1 = 2*len;
        String[] newArray1 = new String[newlen1];
        System.arraycopy(firstName,0,newArray1,0,len1);
        firstName = newArray;

        System.out.println("resizing age");
        int len2= lastName.length;
        int newlen2 = 2*len;
        int[] newArray2 = new int[newlen2];
        System.arraycopy(age,0,newArray2,0,len2);
        age = newArray2;
    }
    public void insert(String s, String s1, int a, int pos){
        if(pos>size || pos <0) return;
        if(pos ==lastName.length || size+1 > lastName.length){
            resize();
        }
//last name
        String[] tmp = new String[lastName.length+1];
        System.arraycopy(lastName,0,tmp,0,pos);
        tmp[pos] = s;

        System.arraycopy(lastName,pos,tmp,pos+1,lastName.length-pos);
        lastName = tmp;
//first name
        String[] tmp1 = new String[firstName.length+1];
        System.arraycopy(firstName,0,tmp1,0,pos);
        tmp1[pos] = s;

        System.arraycopy(firstName,pos,tmp1,pos+1,firstName.length-pos);
        firstName = tmp1;
//age
        int[] tmp2 = new int[age.length+1];
        System.arraycopy(age,0,tmp2,0,pos);
        tmp[pos] = s;

        System.arraycopy(age,pos,tmp2,pos+1,age.length-pos);
        age = tmp2;
        ++size;
    }

    public boolean remove(String s){
        if(size ==0) return false;
        if(s == null) return false;
        int index = -1;
        for(int i=0;i<size;i++){
            if(lastName[i].equals(s)){
                index = i;
                break;
            }
        }
        if(index ==-1) return false;
        //lastname
        String[] tmp = new String[lastName.length];
        System.arraycopy(lastName,0,tmp,0,index);
        System.arraycopy(lastName,index+1,tmp,index,lastName.length-(index+1));
        lastName = tmp;
        //firstname
        String[] tmp1 = new String[firstName.length];
        System.arraycopy(firstName,0,tmp,0,index);
        System.arraycopy(firstName,index+1,tmp,index,firstName.length-(index+1));
        firstName = tmp1;
        //age
        int[] tmp2 = new int[age.length];
        System.arraycopy(age,0,tmp,0,index);
        System.arraycopy(age,index+1,tmp,index,age.length-(index+1));
        age = tmp2;
        --size;
        return true;
    }
    @Override
    public String toString() {
        return "Person [lastName=" + lastName + "\n FirstName=" + firstName +
                "\nAge=" + age + "]";
    }
}
