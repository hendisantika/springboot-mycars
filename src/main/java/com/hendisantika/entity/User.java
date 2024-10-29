package com.hendisantika.entity;

import com.hendisantika.dto.ProfileForm;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-mycars
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 03/02/22
 * Time: 07.27
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "USER")
@Data
@NoArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "LOGIN", nullable = false, unique = true)
    private String login;
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;
    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;
    private String email;
    private String phone;
    @Lob
    private byte[] profileImage;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "OWNER_ID")
    private Set<Car> cars;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private Set<Authority> authorities;

    public User(String login, String password, String firstName, String lastName) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String login, String password, String firstName, String lastName, String email, String phone) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public void updateProfileFromProfileForm(ProfileForm profileForm) {
        login = profileForm.getLogin();
        password = profileForm.getPassword();
        firstName = profileForm.getFirstName();
        lastName = profileForm.getLastName();
        phone = profileForm.getPhone();
        email = profileForm.getEmail();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
