package paquete.sgr.entity.pojos;
// Generated 7/12/2018 03:49:07 PM by Hibernate Tools 4.3.1



/**
 * MaterialUtilizado generated by hbm2java
 */
public class MaterialUtilizado  implements java.io.Serializable {


     private Integer idMaterialUtilizado;
     private Material material;
     private Practica practica;

    public MaterialUtilizado() {
    }

    public MaterialUtilizado(Material material, Practica practica) {
       this.material = material;
       this.practica = practica;
    }
   
    public Integer getIdMaterialUtilizado() {
        return this.idMaterialUtilizado;
    }
    
    public void setIdMaterialUtilizado(Integer idMaterialUtilizado) {
        this.idMaterialUtilizado = idMaterialUtilizado;
    }
    public Material getMaterial() {
        return this.material;
    }
    
    public void setMaterial(Material material) {
        this.material = material;
    }
    public Practica getPractica() {
        return this.practica;
    }
    
    public void setPractica(Practica practica) {
        this.practica = practica;
    }




}


