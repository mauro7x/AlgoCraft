package modelo.objetos.herramientas.reglas;


public abstract class ReglasDecorador implements ReglasDesgasteRecurso {

    private ReglasDesgasteRecurso reglas;

    public ReglasDecorador(ReglasDesgasteRecurso reglas){
        this.reglas = reglas;
    }

    protected ReglasDesgasteRecurso getReglas(){
        return this.reglas;
    }



}
