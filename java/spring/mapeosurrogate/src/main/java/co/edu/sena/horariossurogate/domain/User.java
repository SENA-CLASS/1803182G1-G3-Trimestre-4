package co.edu.sena.horariossurogate.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user", schema = "horarios")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "password")
    private String password;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "email")
    private String email;
    @Column(name = "activated")
    private Integer activated;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "lang_key")
    private String langKey;
    @Size(max = 256)
    @Column(name = "image_url")
    private String imageUrl;
    @Size(max = 20)
    @Column(name = "activation_key")
    private String activationKey;
    @Size(max = 20)
    @Column(name = "reset_key")
    private String resetKey;
    @Column(name = "reset_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date resetDate;
    @JoinTable(name = "user_authority",schema = "horarios", joinColumns = {
            @JoinColumn(name = "id_user", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_user"))},
            inverseJoinColumns = {
                    @JoinColumn(name = "name_rol", referencedColumnName = "name", foreignKey = @ForeignKey(name = "fk_authority"))})
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Authority> authorityList;


}
