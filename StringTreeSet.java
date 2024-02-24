import java.util.Iterator;

public class StringTreeSet implements Comparable<StringTreeSet> {

    Noeud racine;
    int cpt;

    public class Noeud {
        String data;
        Noeud gauche;
        Noeud droite;
        Noeud parent;


        public Noeud(String data, Noeud gauche, Noeud droite) {
            this.data = data;
            this.gauche = gauche;
            this.droite = droite;
        }

        public void setParent(Noeud n) {
            this.parent = n;
        }

        public Noeud getParent() {
            return this.parent;
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
        
        @Override
        public String toString() {
            String result = "";
            if (this.gauche != null) {
                result += this.gauche.toString() + " ";
            }
            result += this.data;
            if (this.droite != null) {
                result += " " + this.droite.toString();
            }
            return result;
        }
    }
    /* Méthode toString() itérative
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
    public String toString() {
        if (this.racine != null) {
            return this. racine.toString();
        } else {
            return "Arbre vide";
        }
    }    


    @Override
    public int compareTo(StringTreeSet other) {
        if (this.racine == null && other.racine == null) {
            return 0;
        } else if (this.racine == null) {
            return -1;
        } else if (other.racine == null) {
            return 1;
        } else {
            return this.racine.getData().compareTo(other.racine.getData());
        }
    }

    boolean add(String s) {
        if (this.racine == null) {
            this.racine = new Noeud(s, null, null);
            this.cpt++;
            return true;
        }
        Noeud parent = null;
        Noeud courant = this.racine;
        int c = 0;
        while (courant != null) {
            c = s.compareTo(courant.getData());
            if (c == 0) {
                return false; // L'élément est déjà présent
            }
            parent = courant;
            if (c < 0) {
                courant = courant.getGauche();
            } else {
                courant = courant.getDroite();
            }
        }
        if (c < 0) {
            parent.setGauche(new Noeud(s, null, null));
        } else {
            parent.setDroite(new Noeud(s, null, null));
        }
        this.cpt++;
        return true;
    }

    void clear() {
        this.racine = null;
        this.cpt=0;
    }

    boolean contains(String s) {
        Noeud courant = this.racine;

        while (courant != null) {
            int c = s.compareTo(courant.getData());
            if (c == 0)
                return true;
            else if (c < 0) {
                courant = courant.getGauche();
            } else {
                courant = courant.getDroite();
            }
        }
        return false;
    }

    String first() {
        Noeud courant = this.racine;
        if(courant == null) {
            return "Il n'y a pas d'élément";
        }

        while (courant.getGauche() != null) {
                courant = courant.getGauche();
        }
        return courant.getData();
    }

    boolean isEmpty() {
        return this.racine == null;
    }

    //J'arrive pas aussi
    /* 
    @Override
    public Iterator<String> iterator() {
        // Retourne une nouvelle instance de la classe interne StringTreeSetIterator
        return new StringTreeSetIterator();
    }
    */

    //Pas finit j'arrive pas
    boolean remove(String s) {
        Noeud courant = this.racine;
        Noeud parent;

        if(courant==null) {
            return false;
        }
        else if(courant.getDroite()==null && courant.getGauche()==null) {
            courant=null;
            return true;
        }

        while (courant != null) {
            int c = s.compareTo(courant.getData());
            if (c == 0) {
                if(courant.getDroite()==null && courant.getGauche()==null) {
                    courant=null;
                }
                return true;
            }
            else if (c < 0) {
                parent = courant;
                courant = courant.getGauche();
            } else {
                parent = courant;
                courant = courant.getDroite();
            }
        }
        return true;
    }

    int size() {
        return cpt;
    }

    public static void main(String[] args) {
        StringTreeSet treeSet = new StringTreeSet();

        // Ajouter des éléments
        treeSet.add("banana");
        treeSet.add("apple");
        treeSet.add("orange");
        treeSet.add("amande");


        // Afficher le contenu de l'arbre
        System.out.println("Contenu de l'arbre : " + treeSet.toString());

        // Vérifier la présence d'un élément
        System.out.println("Contient 'apple' : " + treeSet.contains("apple"));
        System.out.println("Contient 'grape' : " + treeSet.contains("grape"));

        treeSet.clear();
        System.out.println("Contenu de l'arbre : " + treeSet.toString() + " c'est " + treeSet.isEmpty());
        System.out.println("Taille d'élément : " + treeSet.size());

        // Ajouter des éléments
        treeSet.add("c");
        treeSet.add("banana");
        treeSet.add("apple");
        treeSet.add("ab");
        
        System.out.println("L'élément le plus à gauche : " + treeSet.first());
        System.out.println("Arbre vide ? " + treeSet.isEmpty());
        System.out.println("Taille d'élément : " + treeSet.size());

    }
}
