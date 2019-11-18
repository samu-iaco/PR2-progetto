package com.company;

import java.util.Vector;
import java.util.Iterator;
import java.util.Scanner;

import com.company.AlreadyExistsException;
import com.company.WrongLoginException;

public class TestCase {
    private static Scanner reader ;
    private static MyDataBoard<Data> lista ;

    public static void main(String[] args) {
        lista = new MyDataBoard<>("biketrial");
        reader= new Scanner(System.in);

        boolean run = true;

        while(run){
            stampaMenu();
            int op = chiediOperazione();

            switch (op){
                case 0:
                    run = false;
                    break;

                case 1:
                    creaCategoria();
                    break;

                case 2:
                    rimuoviCategoria();
                    break;
            }
        }

    }

    private static void stampaMenu() {
        System.out.println("0 - Esci dal programma");
        System.out.println("1 - Aggiungi Categoria");
        System.out.println("2 - Rimuovi categoria");
    }

    private static void rimuoviCategoria(){
        String categoria = chiediStringa("categoria");
        String pass_Cat = chiediStringa("password");
        try{
            lista.removeCategory(categoria,pass_Cat);

            System.out.println("Categoria rimossa");
        }catch (WrongLoginException e){
            System.out.println("password errata!");
        }catch (NotExistsException e){
            System.out.println("la categoria non esiste!");
        }
    }

    private static void creaCategoria(){
        String categoria = chiediStringa("categoria");
        String pass_Cat = chiediStringa("password");
        try{
            lista.createCategory(categoria,pass_Cat);

            System.out.println("Categoria creata correttamente");
        }catch (AlreadyExistsException e){
            System.out.println("categoria già esistente!");
        }
        catch (WrongLoginException e){
            System.out.println("password errata!");
        }
        catch (NullPointerException e){
            System.out.println("inserisci una categoria da inserire!");
        }
    }

    private static String chiediStringa(String message){
        System.out.print(message + ": ");
        return reader.next();
    }

    private static int chiediOperazione() {
        System.out.print("Inserisci operazione: ");
        return reader.nextInt();
    }
}
