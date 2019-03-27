package question3;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2<T> implements PileI<T>{
    /** par d�l�gation : utilisation de la class Stack */
    private Stack<T> stk;
    /** la capacit� de la pile */
    private int capacit�;

    /** Cr�ation d'une pile.
     * @param taille la "taille maximale" de la pile, doit �tre > 0
     */
    public Pile2(int taille){
        if (taille <= 0){
            taille = CAPACITE_PAR_DEFAUT;
        }
        this.stk = new Stack<T>();
        this.capacit� = taille;
    }
    
    /**
     * Constructeur par d�faut.
     */
    public Pile2(){
        this(PileI.CAPACITE_PAR_DEFAUT);
    }
    
    /**
     * Ajoute un �l�ment � la pile si elle n'est pas pleine.
     * @param o : �l�ment ajout�.
     */
    public void empiler(T o) throws PilePleineException{
        if(estPleine()){
            throw new PilePleineException();
        }
        this.stk.push(o);
    }
    
    /**
     * Supprime le dernier �l�ment ajout� � la pile.
     */
    public T depiler() throws PileVideException{
        if (estVide())
            throw new PileVideException();
        return this.stk.pop();
    }

    /**
     * Retourne le dernier �l�ment ajout� de la pile.
     */
    public T sommet() throws PileVideException{
         if (estVide())
            throw new PileVideException();
        return this.stk.peek();
    }
    
    /**
     * Donne le nombre maximal d'�l�ments que la pile peut contenir.
     */
    public int capacite(){
         return this.capacit�;
    }
    
    /**
     * Retoune le nombre d'�l�ments pr�sent dans la pile.
     */
    public int taille(){
         return this.stk.size();
    }
    
    /**
     * Retourne true si la pile est vide.
     */
    public boolean estVide(){
        return this.stk.empty();
    }
    
    /**
     * Retourne true si la pile est pleine.
     */
    public boolean estPleine(){
        return this.stk.size() == this.capacit�;
    }
    
    
	public boolean equals(Object o){
        if( this== o ){
            return true;
        }
        if(!(o instanceof Pile2)){
            return false;
        }
        Pile2 p1 = (Pile2)o;

        if (p1.taille() == this.taille() && p1.capacite() == this.capacite()){
            boolean estEgale = false;
            for(int i= stk.size()-1; i>=0 ; i--){
                Object temp = this.stk.get(i);
                boolean existe = false;
                for(int j = this.stk.size() - 1; j >= 0; j--){
                    if((temp == p1.stk.get(i))){
                        existe = true;
                    }
                }
                if(existe){
                    estEgale = true;
                } else{
                    return false;
                }

            }
            return true;
        }
        return false;
    }

    
    public int hashCode(){
        return toString().hashCode();
    }
    
    public String toString(){
         String s = "[";
        for (int i = this.stk.size() - 1; i >= 0; i--) {
           s+= this.stk.get(i).toString();
           if(i >0){
               s+= ", ";
           }       
        }
        return s + "]"; 
    }
    
} 