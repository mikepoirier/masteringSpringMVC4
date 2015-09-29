package masterSpringMvc.profile;

import masterSpringMvc.date.PastLocalDate;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by blindweasel on 9/28/15.
 */
public class ProfileForm
{
    @Size(min = 2)
    private String twitterHandle;

    @Email
    @NotEmpty
    private String email;

    @NotNull
    @PastLocalDate
    private LocalDate birthDate;

    @NotEmpty
    private List<String> tastes = new ArrayList<>();

    public String getTwitterHandle()
    {
        return twitterHandle;
    }

    public void setTwitterHandle(String twitterHandle)
    {
        this.twitterHandle = twitterHandle;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public LocalDate getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate)
    {
        this.birthDate = birthDate;
    }

    public List<String> getTastes()
    {
        return tastes;
    }

    public void setTastes(List<String> tastes)
    {
        this.tastes = tastes;
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this)
                .append("twitterHandle", twitterHandle)
                .append("email", email)
                .append("birthDate", birthDate)
                .append("tastes", tastes)
                .toString();
    }
}
