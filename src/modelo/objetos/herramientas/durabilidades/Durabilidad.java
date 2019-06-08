package modelo.objetos.herramientas.durabilidades;

public abstract class Durabilidad {

   protected float durabilidad;

   public abstract void gastar(float fuerza);


   public float getDurabilidad(){
       return this.durabilidad;
   }

   public void setDurabilidad(float durabilidad){
       this.durabilidad = durabilidad;
   }

}
