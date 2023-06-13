package prob3;

public class Marketing {
    private String employeeName;
    private String productName;
    private int saleAmount;

    Marketing(String employeeName, String productName, int saleAmount){
        this.employeeName = employeeName;
        this.productName = productName;
        this.saleAmount = saleAmount;
    }

    public int getSaleAmount(){return saleAmount;}

    public String toString(){
        return "[" + employeeName + ", " + productName + ", " + saleAmount + "]";
    }

    public boolean equals(Object obj){
        if(this == obj){return true;}
        if(obj == null || getClass() != obj.getClass()){return false;}
        Marketing other = (Marketing) obj;
        if(employeeName.equals(other.employeeName) && productName.equals(other.productName)
        && saleAmount == (other.saleAmount)){
            return true;
        }
        return false;
    }

}
