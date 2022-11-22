package cl.yose.web.models;

import lombok.*;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="posteos")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Posteo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 5, max = 40, message = "Error en el ingreso del titulo")
    private String titulo;
    
    @NotNull
    @Size(min = 5, max = 40, message = "Error en el ingreso del contenido del posteo")
    private String texto;
    
    private String url;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
//---------------------------------------------------
    
    @JsonIgnore
    @OneToMany(mappedBy = "posteo",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="comentario_id")
    private Comentario comentario;

    
    
    
    
    
    
	//atributos de control
    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }
    //agregar a la columna la fecha despues de actualizar o cambiar valores de el registro
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }


}
