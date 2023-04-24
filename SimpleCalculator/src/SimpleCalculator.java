import java.util.Scanner;

public class SimpleCalculator {
	private static final int MIN = 0;
    private static final int MAX = 1000;
    
    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        
        String expression = scanner.nextLine();
        scanner.close();
         
        try {
            int express = evaluate(expression);
            System.out.println(express);
        } catch (AddZeroException e) {
            System.out.println("AddZeroException");
        } catch (SubtractZeroException e) {
            System.out.println("SubtractZeroException");
        } catch (OutOfRangeException e) {
            System.out.println("OutOfRangeException");
        }
    }
    
    private static int evaluate(String expression) throws AddZeroException, SubtractZeroException, OutOfRangeException {
        
    	String[] parts = expression.split("[+-]");
        
    	int firstoper = Integer.parseInt(parts[0]);	
        int secondoper = Integer.parseInt(parts[1]);
        
        char operator = expression.charAt(parts[0].length());
        
        int result;
        switch (operator) {
            case '+':
                if (firstoper == 0 || secondoper == 0) {
                    throw new AddZeroException();
                }
                result = firstoper + secondoper;
                break;
                
            case '-':
                if (firstoper == 0 || secondoper == 0) {
                    throw new SubtractZeroException();
                }
                result = firstoper - secondoper;
                break;
                
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
        
        if (firstoper < 0 || firstoper > 1000) {
            throw new OutOfRangeException();
        }
        if (secondoper < 0 || secondoper > 1000) {
            throw new OutOfRangeException();
        }
        
        
        if (result < MIN || result > MAX) {
            throw new OutOfRangeException();
        }
        
            
        return result;
        
    }
    
    //The method evaluate(String) from the type SimpleCalculator refers to the missing type AddZeroException
	//AddZeroException cannot be resolved to a type
	//SubtractZeroException cannot be resolved to a type
	//OutOfRangeException cannot be resolved to a type
    
    // private static final long serialVersionUID 클래스 버전 확인
    
    private static class OutOfRangeException extends Exception {
        private static final long serialVersionUID = 1L;
    }
    
    private static class AddZeroException extends Exception {
        private static final long serialVersionUID = 1L;
    }
    
    private static class SubtractZeroException extends Exception {
        private static final long serialVersionUID = 1L;
    }
    

}