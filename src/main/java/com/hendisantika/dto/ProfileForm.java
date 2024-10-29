package com.hendisantika.dto;

import com.hendisantika.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-mycars
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 03/02/22
 * Time: 07.20
 * To change this template use File | Settings | File Templates.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileForm {
    @NotNull
    @NotEmpty
    @Size(min = 5, max = 20)
    private String login;
    @NotNull
    @NotEmpty
    @Size(min = 5, max = 20)
    private String password;
    @NotNull
    @NotEmpty
    @Size(min = 2, max = 20)
    private String firstName;
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 30)
    private String lastName;
    @Email
    private String email;
    private String phone;

    public static ProfileForm createProfileFormFromUser(User user) {
        ProfileForm profileForm = new ProfileForm();
        profileForm.login = user.getLogin();
        profileForm.password = user.getPassword();
        profileForm.firstName = user.getFirstName();
        profileForm.lastName = user.getLastName();
        profileForm.email = user.getEmail();
        profileForm.phone = user.getPhone();
        return profileForm;
    }
}
