public class StringTreeSet implements Comparable {

    Noeud racine;
    public class Noeud {

            String data;
            Noeud gauche;
            Noeud droite;
            Noeud suivant;
    
            public Noeud(String data, Noeud suivant, Noeud gauche, Noeud droite) {
                this.data=data;
                this.suivant=suivant;
                this.gauche=gauche;
                this.droite=droite;
            }
        
            public void setSuivantDroite(Noeud n) {
                this.suivant = n;
            }
    
            public Noeud getSuivantDroite() {
                return this.suivant;
            }
    
            public void setSuivantGauche(Noeud n) {
                this.gauche = n;
            }
    
            public Noeud getSuivantGauche() {
                return this.suivant;
            }
        
            public void setData(String s) {
                this.data = s;
            }
        
            public String getData() {
                return this.data;
            }
    }

    @Override
    public int compareTo(Object o) {

    }
    
    boolean contains(String s) {
        Noeud cour = this.racine;
        do {
            
        } while(cour.getSuivantDroite() != null || cour.getSuivantGauche()!=null);

        
    }

    boolean add(String s){
        Noeud courant = this.racine;
        String value = "";
        while(courant.getSuivantDroite() != null || courant.getSuivantGauche()!=null) {
            if(s<courant.getData()){
                courant = courant.getSuivantGauche();
                value = courant.getData();
            }else{
                courant = courant.getSuivantDroite();
                value = courant.getData();
            }
        }
        if(value<courant){
            courant.setGaucheSuivant(new Noeud(s, null, null));
        }else{
            courant.setDroitSuivant(new Noeud(s, null, null));
        }
        return true;
        }
}
