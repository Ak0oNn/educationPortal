package bitlab.G114.ProjectNewsPortal.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "group_users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GroupUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_joined")
    private Date dateJoined;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> role;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_usersid")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_groupsid")
    private Group group;

}
