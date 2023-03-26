public class Palabra {
    private Integer prioridad; 
    private String contenido;

    public Palabra(Integer prioridad,String contenido) {
        this.contenido = contenido;
        this.prioridad = prioridad;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
}
