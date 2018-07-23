package pl.prz.l6.systempotwierdzaniawizyt.model;

import javax.persistence.*;

@Entity
@Table(name = "user_settings")
public class UserSettings {

    @Id
    @Column(name = "id_user_settings")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUserSettings;

    @Column(name = "delta_time_notif_err")
    private int deltaTimeNotifErr;
    @Column(name = "delta_time_notif")
    private int deltaTimeNotif;


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    private User user;

    public long getIdUserSettings() {
        return idUserSettings;
    }

    public void setIdUserSettings(long idUserSettings) {
        this.idUserSettings = idUserSettings;
    }

    public int getDeltaTimeNotifErr() {
        return deltaTimeNotifErr;
    }

    public void setDeltaTimeNotifErr(int deltaTimeNotifErr) {
        this.deltaTimeNotifErr = deltaTimeNotifErr;
    }

    public int getDeltaTimeNotif() {
        return deltaTimeNotif;
    }

    public void setDeltaTimeNotif(int deltaTimeNotif) {
        this.deltaTimeNotif = deltaTimeNotif;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
