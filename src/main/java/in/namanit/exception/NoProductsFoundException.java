package in.namanit.exception;

public class NoProductsFoundException extends RuntimeException{

    public NoProductsFoundException(){

    }
    public NoProductsFoundException(String msg){
        super(msg);
    }

}
