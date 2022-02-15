/*
Copyright (c) 2022 MUHAMAD ASHRAFF OTHMAN
Developed by the students of Universiti Kuala Lumpur (UniKL)
Malaysian Institute of Information Technology (MIIT)

Credit to our team :
MUHAMAD ASHRAFF BIN OTHMAN
MUHAMMAD HADIF BIN ABDUL RAHIM
SITI NABILAH BINTI MOHD HANAFI
SHARIFAH NURUL FATIHAH BINTI WAN ASHHAR MARZUKI
*/

import java.util.Stack; //IMPORT STACK CLASS
import java.util.EmptyStackException;
import java.util.Scanner;
import java.text.*;

public class evaluatePostfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Postfix Expression :");
        // INPUT POSTFIX VALUE
        String postfix = sc.next() + sc.nextLine();
        // SET DECIMAL FORMAT FOR THE RESULT
        DecimalFormat decFormat = new DecimalFormat("#.##");
        /*
         * INVOKE METHOD WITH PARAMETER OF POSTFIX EXPRESSION
         * AND ASSIGNED THE RESULT INTO VARIABLE
         */
        String result = decFormat.format(evalPostfix(postfix));
        // DISPLAY THE RESULT
        System.out.println("Evaluation value: " + result);
        sc.close();
    }// END MAIN

    // USING NON-VOID METHOD WITH RETURN DOUBLE DATATYPE
    public static Double evalPostfix(String postfix) {

        // CREATE STACK OBJECT
        Stack<Double> myStack = new Stack<>();
        // STORE CHARACTER COUNT
        int charCount = postfix.length();

        try {
            // USING FOR LOOP TO SCAN EACH CHARACTER IN A STRING
            for (int i = 0; i < charCount; i++) {

                char currentChar = postfix.charAt(i);
                char nextChar = ' ';

                // TO PREVENT INDEXOUT EXCEPTION
                if ((i + 1) < charCount) {
                    nextChar = postfix.charAt(i + 1);
                } // END IF

                if (Character.isWhitespace(currentChar)) {

                    /*
                     * IF THE SCANNED CHARACTER IS A BLANK CHAR
                     * THEN DO NOTHING
                     */

                } else if (Character.isDigit(currentChar)) {

                    /*
                     * IF THE SCANNED CHARACTER HAS DIGIT
                     * VALUE THEN PUSH THE VALUE TO THE STACK
                     */
                    Double num = 0.0;
                    String appendNum = "";
                    /*
                     * USING WHILE LOOP TO DETERMINE IF THE INPUT
                     * HAS MORE THAN 1 DIGIT
                     */
                    while (Character.isDigit(currentChar)) {
                        appendNum += Character.getNumericValue(currentChar);
                        num = Double.parseDouble(appendNum);
                        i++;
                        currentChar = postfix.charAt(i);
                    } // END DO
                    i--;
                    // PUSH THE DIGIT VALUE INTO THE STACK
                    myStack.push(num);

                } else {
                    /* IF THE CURRENT CHAR IS AN OPERATOR */
                    /*
                     * USING IF STATEMENT TO CHECK IF THE CURRENT CHAR
                     * IS AN OPERATOR OR IT HAS DIGIT VALUE AFTER THAT
                     * IF HAS VALUE(S) AFTER THE CHAR THEN PROBABLY
                     * IT IS A NEGATIVE NUMBER. PUSH THE NUMBER INTO
                     * THE STACK
                     */
                    if (Character.isDigit(nextChar)) {
                        Double num = 0.0;
                        // STORE OPERAND INTO VARIABLE
                        String appendNum = Character.toString(currentChar);
                        currentChar = postfix.charAt(i + 1);
                        while (Character.isDigit(currentChar)) {
                            appendNum += currentChar;
                            num = Double.parseDouble(appendNum);
                            i = i + 2;
                            currentChar = postfix.charAt(i);
                        } // END DO
                        i--;
                        // PUSH THE NEGATIVE VALUE INTO THE STACK
                        myStack.push(num);

                    } else {

                        /*
                         * ELSE IF IT IS JUST AN OPERATOR,
                         * POP TWO ELEMENTS FROM THE TOP OF THE STACK
                         * AND STORE IT IN THE VARIABLES
                         */
                        Double operand1 = myStack.pop();
                        Double operand2 = myStack.pop();
                        Double result = 0.0;

                        /*
                         * DO A MATHEMATICAL OPERATION BASED
                         * ON THE CURRENT OPERATOR CHARACTER
                         */
                        switch (currentChar) {
                            case '+':
                                result = operand2 + operand1;
                                break;

                            case '-':
                                result = operand2 - operand1;
                                break;

                            case '/':
                                result = operand2 / operand1;
                                break;

                            case '*':
                                result = operand2 * operand1;
                                break;
                        }// END SWITCH

                        /*
                         * FINALLY PUSH THE FINAL CALCULATION
                         * RESULT INTO THE STACK
                         */
                        myStack.push(result);

                    } // END IF
                } // END IF
            } // END FOR LOOP
              // USING TRY CATCH BLOCK TO HANDLE ERROR/EXCEPTION
        } catch (StringIndexOutOfBoundsException e) {
            // DO NOTHING
            // TO AVOID EXCEPTION OF UNUSED VALUE
        } catch (EmptyStackException e) {
            System.out.println("Error : Invalid Postfix Expression !");
        } catch (NumberFormatException e) {
            System.out.println("Error : Invalid Postfix Expression !");
        } // END TRY CATCH
          // GET RETURN VALUE OF TOP OF THE STACK (THE RESULT)
        return myStack.pop();
    }// END METHOD

}// END CLASS