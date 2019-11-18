package com.company;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class MyDataBoard<E extends Data> implements DataBoard<E> {

    private Vector<Category> categorie;
    private Vector<DataFriend> dati_amici;
    private String password;

    public MyDataBoard(String password) {
        this.password = password;
        categorie = new Vector<Category>();
        dati_amici = new Vector<DataFriend>();
    }

    @Override
    public void createCategory(String category, String passw) throws NullPointerException, AlreadyExistsException,WrongLoginException {
        if(category == null) throw new NullPointerException();
        if(!login(passw)) throw new WrongLoginException();
        if(!checkExists(category)) categorie.add(new Category(category));
        else throw new AlreadyExistsException();
    }

    private boolean login(String passw){
        return this.password.equals(passw);
    }

    private boolean checkExists(String name){
        Iterator<Category> it = categorie.iterator();
        while(it.hasNext()) {
            Category category = it.next();
            if(category.getNomeCat().equals(name)) return true;
        }
        return false;
    }

    private int findCategory(String name){
        for(int i = 0;i<categorie.size();i++){
            if(categorie.get(i).getNomeCat().equals(name)) return i;
        }
        return -1;
    }

    private int findFriend(Category c, String name){
        for(int i = 0;i<c.getAmici().size();i++){
            if(c.getAmici().get(i).equals(name)) return i;
        }
        return -1;
    }

    @Override
    public void removeCategory(String category, String passw) throws NullPointerException, WrongLoginException,NotExistsException{
        if(category == null || passw == null) throw new NullPointerException();
        if(!login(passw)) throw new WrongLoginException();
        if(!checkExists(category)) throw new NotExistsException();

        int pos = findCategory(category);
        if(pos != -1) categorie.remove(pos);
    }

    // Aggiunge un amico ad una categoria di dati
    // se vengono rispettati i controlli di identità
    @Override
    public void addFriend(String category, String passw, String friend) throws NullPointerException, WrongLoginException, AlreadyExistsException {
        if(category == null || passw == null || friend == null) throw new NullPointerException();
        if(login(passw)) throw new WrongLoginException();

        int pos_cat = findCategory(category);
        Category c = categorie.get(pos_cat);
        if(c.getAmici().contains(friend)) throw new AlreadyExistsException();
        else c.getAmici().add(friend);

    }

 //   @Override
 //   public void removeFriend(String category, String passw, String friend) {

 //   }

 //   @Override
 //   public boolean put(String passw, E dato, String categoria) {
 //       return false;
 //   }

    @Override
    public E get(String passw, E dato) {
        return null;
    }

    @Override
    public E remove(String passw, E dato) {
        return null;
    }

    @Override
    public List<E> getDataCategory(String passw, String category) {
        return null;
    }

    @Override
    public void insertLike(String friend, E dato) {

    }

    @Override
    public Iterator<E> getIterator(String passw) {
        return null;
    }

    @Override
    public Iterator<E> getFriendIterator(String friend) {
        return null;
    }

}
