public class StringTreeSet {

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

        public void setGaucheSuivant(Noeud n) {
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

        public Noeud getSuivant() {
            return this.suivant;
        }

    }

}