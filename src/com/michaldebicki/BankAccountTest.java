package com.michaldebicki;

import static org.junit.Assert.*;

public class BankAccountTest {

    private BankAccount account;
    private static int count;

    @org.junit.BeforeClass
    public static void beforeClass() {
        System.out.println("This is before any class testes. Count = " + count++);
    }

    @org.junit.Before
    public void setup(){
        account = new BankAccount("Tim","Buchalka",1000.0, BankAccount.CHECKING);
        System.out.println("Running a test.....");
    }

    @org.junit.Test
    public void deposit() {
        double balance = account.deposit(200.00,true);
        assertEquals(1200.00,balance,0);
        assertEquals(1200.00,account.getBalance(),0);
    }

    @org.junit.Test
    public void withdraw_branch() {
        double balance = account.withdraw(600.00,true);
        assertEquals(400.0,balance,0);
    }
    @org.junit.Test//(expected = IllegalArgumentException.class)
    public void withdraw_notBranch() {
        try {
            account.withdraw(600.00, false);
            fail("Should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException e){

        }

    }

    @org.junit.Test
    public void getBalance_deposit() {
        account.deposit(200.00,true);
        assertEquals(1200.00,account.getBalance(),0);
    }
    @org.junit.Test
    public void getBalance_withdraw() {
        account.withdraw(200.00,true);
        assertEquals(800.00,account.getBalance(),0);
    }
    @org.junit.Test
    public void isChecking_true (){
        //assertEquals(true,account.isChecking());
        assertTrue("The account is NOT a checking account",account.isChecking());
        //assertNotEquals
        //assertArrayEquals
        //assertNull
        //assertSame //compares object references only
        //assertThat
    }

    @org.junit.AfterClass
    public static void afterClass(){
        System.out.println("This executes after any class testes. Count = " + count++);
    }
    @org.junit.After
    public void teardown() {
        System.out.println("Count = " + count++);
    }


}