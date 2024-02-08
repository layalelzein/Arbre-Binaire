public class StringTreeSet implements Comparable<StringTreeSet> {

    Noeud racine;

    public class Noeud {
        String data;
        Noeud gauche;
        Noeud droite;

        public Noeud(String data, Noeud gauche, Noeud droite) {
            this.data = data;
            this.gauche = gauche;
            this.droite = droite;
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
                return this.racine.toString();
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

    boolean contains(String s) {
        Noeud courant = this.racine;

        while (courant != null) {
            int c = s.compareTo(courant.getData());
            if (c == 0)
                return true;
            if (c < 0) {
                courant = courant.getGauche();
            } else {
                courant = courant.getDroite();
            }
        }
        return false;
    }

    boolean add(String s) {
        if (this.racine == null) {
            this.racine = new Noeud(s, null, null);
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
        return true;
    }

    public static void main(String[] args) {
        StringTreeSet treeSet = new StringTreeSet();

        // Ajouter des éléments
        treeSet.add("banana");
        treeSet.add("apple");
        treeSet.add("orange");

        // Afficher le contenu de l'arbre
        System.out.println("Contenu de l'arbre : " + treeSet);

        // Vérifier la présence d'un élément
        System.out.println("Contient 'apple' : " + treeSet.contains("apple"));
        System.out.println("Contient 'grape' : " + treeSet.contains("grape"));
    }
}
