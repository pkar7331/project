package pl.prz.l6.systempotwierdzaniawizyt.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "notification_template")
public class NotificationTemplate {
    @Id
    @Column(name = "id_notification_template")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idNotificationTemplate;
    @Column(nullable = false, name = "name")
    private String name;
    @Column(nullable = false, name = "content")
    private String content;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "notificationTemplate", cascade = CascadeType.REMOVE, orphanRemoval = true)
    List<Notification> listOfNotification;

    public long getIdNotificationTemplate() {
        return idNotificationTemplate;
    }

    public void setIdNotificationTemplate(long idNotificationTemplate) {
        this.idNotificationTemplate = idNotificationTemplate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Notification> getListOfNotification() {
        return listOfNotification;
    }

    public void setListOfNotification(List<Notification> listOfNotification) {
        this.listOfNotification = listOfNotification;
    }
}
