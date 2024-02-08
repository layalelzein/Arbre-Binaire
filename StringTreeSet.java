public class StringTreeSet implements Comparable<StringTreeSet> {

    Noeud racine;
    public class Noeud {

            String data;
            Noeud gauche;
            Noeud droite;
    
            public Noeud(String data, Noeud gauche, Noeud droite) {
                this.data=data;
                this.gauche=gauche;
                this.droite=droite;
            }
        
            public void setDroite(Noeud n) {
                this.droite = n;
            }
    
            public Noeud getDroite() {
                return this.droite;
            }
    
            public void setGauche(Noeud n) {
                this.gauche = n;
            }
    
            public Noeud getGauche() {
                return this.gauche;
            }
        
            public void setData(String s) {
                this.data = s;
            }
        
            public String getData() {
                return this.data;
            }

            public String toString () {
                return this.getGauche().toString() + " " + this.getData() + this.getDroite().toString();
            }
    }
    public String toString () {
        return this.racine.toString();
    }
    /*
    public String toString () {
        Stack<Noeud> p = new Stack<Noeud>();
        p.push(his.racine);
        StringBuilder s = new StringBuilder();
        while(!p.isEmpty()) {
            Noeud courant ) p.pop();
            s.append(courant.getData())
        }
        if(courant.getDroite == null) {
            p.push(courant.getDroite())
            p.push(courant.getGauche())
        }
        return this.racine.toString();
    } 
    
     */

     @Override
     public int compareTo(StringTreeSet other) {
         // Comparez les arbres en fonction de leur racine
         if (this.racine == null && other.racine == null) {
             return 0; // Les deux arbres sont vides, donc ils sont égaux
         } else if (this.racine == null) {
             return -1; // Seul l'arbre actuel est vide, donc il est inférieur
         } else if (other.racine == null) {
             return 1; // Seul l'autre arbre est vide, donc il est inférieur
         } else {
             // Comparez les données des racines des deux arbres
             return this.racine.getData().compareTo(other.racine.getData());
         }
     }
    
    boolean contains(String s) {
        Noeud courant = this.racine;

        while(courant!=null) {
            int c = s.compareTo(courant.getData());
            if(c==0)
                return true;
            if(c<0) {
                courant = courant.getDroite();
            }
            else {
                courant = courant.getGauche();
            }
        }
        return false;
    }
    
    boolean add(String s){
        Noeud courant = this.racine;
        while(true) {
            int c = s.compareTo(courant.getData());
            if(c==0)
                return false;
            if(c<0) {
                courant = courant.getDroite();
                if(courant.getDroite() == null) {
                    courant.setDroite(new Noeud(s,null, null));
                    return true;
                }
            }

            else {
                courant = courant.getGauche();
                if(courant.getGauche() == null) {
                    courant.setGauche(new Noeud(s,null, null));
                    return true;
                }
            }
        }
      }
}
