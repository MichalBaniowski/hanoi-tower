package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner dataReader = new Scanner(System.in);
        boolean isOk=false;
        int numberOfdisks=3;
        System.out.println("wybierz ile ma być krążków: ");
        while (!isOk){
            try{
                numberOfdisks=dataReader.nextInt();
                isOk=true;
            }
            catch (InputMismatchException e){
                System.err.println("bład wczytania danych");
            }
            finally {
                dataReader.nextLine();
            }
        }
        dataReader.close();
		Hanoi hanoi = new Hanoi(numberOfdisks);
		hanoi.printStacks();
		hanoi.hanoiAlgorithm(   hanoi.getStartStack(),
                                hanoi.getTargetStack(),
                                hanoi.getHelperStack(),
                                hanoi.getSize(),
                                hanoi.getStartPointer(),
                                hanoi.getTargetPointer(),
                                hanoi.getHelperPointer());
    }
}
