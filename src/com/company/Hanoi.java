package com.company;

public class Hanoi {
    private String [] startStack;
    private String [] targetStack;
    private String [] helperStack;
    private int size;
    private int numberOfMoves;
    private int[] startPointer;
    private int[] targetPointer;
    private int[] helperPointer;

    public Hanoi(int size) {
        this.startStack = new String[size+1];
        this.targetStack = new String[size+1];
        this.helperStack = new String[size+1];
        this.size=size;
        for (int i=size; i>0; i--){
            startStack[i] = Integer.toString(i);
            targetStack[i] = "|";
            helperStack[i] = "|";
        }
        startStack[0] = "";
        targetStack[0] = "";
        helperStack[0] = "";
        this.startPointer = new int[1];
        this.targetPointer = new int[1];
        this.helperPointer = new int[1];
        startPointer[0]=0;// nastepnym razem wykorzystaj klasę z jednym polem publicznym
        targetPointer[0]=size;
        helperPointer[0]=size;
    }

    public int getSize() {
        return size;
    }

    public String[] getStartStack() {
        return startStack;
    }

    public String[] getTargetStack() {
        return targetStack;
    }

    public String[] getHelperStack() {
        return helperStack;
    }

    public int[] getStartPointer() {
        return startPointer;
    }

    public int[] getTargetPointer() {
        return targetPointer;
    }

    public int[] getHelperPointer() {
        return helperPointer;
    }

    public void printStacks() throws InterruptedException {

        for (int i=1;i<=size;i++){
            System.out.println(startStack[i]+"\t"+targetStack[i]+"\t"+helperStack[i]);
        }
        System.out.println("\nnr of moves: "+numberOfMoves+"\n");
        Thread.sleep(1000);

    }
    public void hanoiAlgorithm(String[] base, String[] target, String[] helper, int n,
                               int[] baseP, int[] targetP, int[] helperP) throws InterruptedException {
        if(n>1)hanoiAlgorithm(base, helper, target, n-1, baseP, helperP, targetP);
        switcheroo(base, target, baseP, targetP);
        numberOfMoves++;
        printStacks();
        if(n>1)hanoiAlgorithm(helper, target, base, n-1, helperP, targetP, baseP);
    }
    private void switcheroo(String[] base, String[] target, int[] baseP, int[] targetP){
        target[targetP[0]--]=base[++baseP[0]];
        base[baseP[0]]="|";
    }
}
